package com.baidu.searchbox.afx.decode;

import android.app.ActivityManager;
import android.content.pm.ConfigurationInfo;
import android.media.MediaCodec;
import android.media.MediaCrypto;
import android.media.MediaExtractor;
import android.media.MediaFormat;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.Surface;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.afx.callback.ErrorInfo;
import com.baidu.searchbox.afx.callback.OnReportListener;
import com.baidu.searchbox.afx.callback.OnVideoEndedListener;
import com.baidu.searchbox.afx.callback.OnVideoErrorListener;
import com.baidu.searchbox.afx.callback.PlaySuccessInfo;
import com.baidu.searchbox.afx.gl.GLTextureView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.sina.weibo.sdk.utils.FileUtils;
import java.io.File;
import java.io.FileDescriptor;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
/* loaded from: classes2.dex */
public class VideoPlayer {
    public static /* synthetic */ Interceptable $ic = null;
    public static final boolean DEBUG = false;
    public static final int DEFAULT_FPS = 25;
    public static final int MEDIA_INFO_EXTRA_NONE = 0;
    public static final int MEDIA_INFO_VIDEO_RENDERING_START = 3;
    public static final int MS_PER_SECOND = 1000;
    public static final String TAG = "VideoPlayer";
    public transient /* synthetic */ FieldHolder $fh;
    public MediaCodec.BufferInfo mBufferInfo;
    public int mDurationPerFrame;
    public long mDurationUs;
    public int mFps;
    public FrameCallback mFrameCallback;
    public GLTextureView mGLTextureView;
    public int mInputChunk;
    public volatile boolean mIsPauseRequested;
    public volatile boolean mIsStopRequested;
    public boolean mLoop;
    public MediaExtractor mMediaExtractor;
    public OnInfoListener mOnInfoListener;
    public Surface mOutputSurface;
    public volatile int mPlayFrames;
    public volatile long mStartFrameTimeUs;
    public int mVideoHeight;
    public int mVideoWidth;

    /* loaded from: classes2.dex */
    public interface FrameCallback {
        void loopReset();

        void preRender(long j);

        void reset();
    }

    /* loaded from: classes2.dex */
    public interface OnInfoListener {
        boolean onInfo(VideoPlayer videoPlayer, int i, int i2);
    }

    /* loaded from: classes2.dex */
    public class PlayTask implements Runnable {
        public static /* synthetic */ Interceptable $ic = null;
        public static final int MSG_PLAY_ERROR = 1;
        public static final int MSG_PLAY_STOPPED = 0;
        public transient /* synthetic */ FieldHolder $fh;
        public LocalHandler mLocalHandler;
        public VideoPlayer mPlayer;
        public String mPrepareTime;
        public final Object mStopLock;
        public boolean mStopped;
        public Thread mThread;

        /* loaded from: classes2.dex */
        public class LocalHandler extends Handler {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public OnVideoEndedListener mOnEndedListener;
            public OnVideoErrorListener mOnErrorListener;
            public OnReportListener mOnReportListener;

            public LocalHandler(OnVideoEndedListener onVideoEndedListener, OnVideoErrorListener onVideoErrorListener, OnReportListener onReportListener) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {onVideoEndedListener, onVideoErrorListener, onReportListener};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.mOnEndedListener = onVideoEndedListener;
                this.mOnErrorListener = onVideoErrorListener;
                this.mOnReportListener = onReportListener;
            }

            @Override // android.os.Handler
            public void handleMessage(Message message) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, message) == null) {
                    int i = message.what;
                    if (i != 0) {
                        if (i == 1) {
                            String valueOf = String.valueOf(System.currentTimeMillis() / 1000);
                            OnReportListener onReportListener = this.mOnReportListener;
                            if (onReportListener != null) {
                                onReportListener.onError(new ErrorInfo(16, ErrorInfo.VIDEO_PLAY_SOURCE_ERROR_ERRORMSG, (Exception) message.obj, null, null, null, valueOf));
                            }
                            OnVideoErrorListener onVideoErrorListener = this.mOnErrorListener;
                            if (onVideoErrorListener != null) {
                                onVideoErrorListener.onError(new ErrorInfo(16, ErrorInfo.VIDEO_PLAY_SOURCE_ERROR_ERRORMSG, (Exception) message.obj, null, null, null, valueOf));
                                return;
                            }
                            return;
                        }
                        return;
                    }
                    String str = (String) message.obj;
                    OnVideoEndedListener onVideoEndedListener = this.mOnEndedListener;
                    if (onVideoEndedListener != null) {
                        onVideoEndedListener.onVideoEnded();
                    }
                    if (this.mOnReportListener != null) {
                        this.mOnReportListener.onSuccess(new PlaySuccessInfo(null, String.valueOf(System.currentTimeMillis() / 1000), str));
                    }
                }
            }
        }

        public PlayTask(VideoPlayer videoPlayer, OnVideoEndedListener onVideoEndedListener, OnVideoErrorListener onVideoErrorListener, OnReportListener onReportListener) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {videoPlayer, onVideoEndedListener, onVideoErrorListener, onReportListener};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.mStopLock = new Object();
            this.mStopped = false;
            this.mPlayer = videoPlayer;
            this.mLocalHandler = new LocalHandler(onVideoEndedListener, onVideoErrorListener, onReportListener);
        }

        public void execute() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                Thread thread = new Thread(this, "VideoPlayer$PlayTask");
                this.mThread = thread;
                thread.start();
            }
        }

        public void release() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                this.mPlayer = null;
                LocalHandler localHandler = this.mLocalHandler;
                if (localHandler != null) {
                    localHandler.mOnEndedListener = null;
                    this.mLocalHandler.mOnErrorListener = null;
                    this.mLocalHandler.mOnReportListener = null;
                    this.mLocalHandler = null;
                }
            }
        }

        public void waitForStop() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
                synchronized (this.mStopLock) {
                    while (!this.mStopped) {
                        try {
                            this.mStopLock.wait();
                        } catch (InterruptedException unused) {
                        }
                    }
                }
            }
        }

        /* JADX DEBUG: Finally have unexpected throw blocks count: 2, expect 1 */
        @Override // java.lang.Runnable
        public void run() {
            boolean z;
            LocalHandler localHandler;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                try {
                    try {
                        this.mPrepareTime = String.valueOf(System.currentTimeMillis() / 1000);
                        this.mPlayer.play();
                        synchronized (this.mStopLock) {
                            this.mStopped = true;
                            this.mStopLock.notifyAll();
                        }
                        localHandler = this.mLocalHandler;
                        if (localHandler == null) {
                            return;
                        }
                    } catch (Exception e) {
                        if (this.mLocalHandler != null) {
                            z = this.mLocalHandler.sendMessage(this.mLocalHandler.obtainMessage(1, e));
                        } else {
                            z = false;
                        }
                        synchronized (this.mStopLock) {
                            this.mStopped = true;
                            this.mStopLock.notifyAll();
                            if (z || (localHandler = this.mLocalHandler) == null) {
                                return;
                            }
                        }
                    }
                    localHandler.sendMessage(localHandler.obtainMessage(0, this.mPrepareTime));
                } catch (Throwable th) {
                    synchronized (this.mStopLock) {
                        this.mStopped = true;
                        this.mStopLock.notifyAll();
                        LocalHandler localHandler2 = this.mLocalHandler;
                        if (localHandler2 != null) {
                            localHandler2.sendMessage(localHandler2.obtainMessage(0, this.mPrepareTime));
                        }
                        throw th;
                    }
                }
            }
        }
    }

    public VideoPlayer() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mBufferInfo = new MediaCodec.BufferInfo();
        this.mFps = 25;
        this.mDurationPerFrame = 0;
        this.mInputChunk = 1;
        this.mStartFrameTimeUs = 0L;
        this.mPlayFrames = Integer.MAX_VALUE;
    }

    public void release() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            requestStop();
            MediaExtractor mediaExtractor = this.mMediaExtractor;
            if (mediaExtractor != null) {
                try {
                    mediaExtractor.release();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                this.mMediaExtractor = null;
            }
            Surface surface = this.mOutputSurface;
            if (surface != null) {
                try {
                    surface.release();
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
                this.mOutputSurface = null;
            }
            this.mGLTextureView = null;
            this.mStartFrameTimeUs = 0L;
            this.mPlayFrames = Integer.MAX_VALUE;
        }
    }

    public void setDataSource(FileDescriptor fileDescriptor) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, fileDescriptor) == null) {
            MediaExtractor mediaExtractor = new MediaExtractor();
            this.mMediaExtractor = mediaExtractor;
            mediaExtractor.setDataSource(fileDescriptor);
            onDataSourceSet(this.mMediaExtractor);
        }
    }

    public void setFrameCallback(FrameCallback frameCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, frameCallback) == null) {
            this.mFrameCallback = frameCallback;
        }
    }

    public void setGLTextureView(GLTextureView gLTextureView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, gLTextureView) == null) {
            this.mGLTextureView = gLTextureView;
        }
    }

    public void setLoopSection(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048592, this, i) == null) {
            setLoopSection(i, (int) ((this.mDurationUs / 1000000.0d) * this.mFps));
        }
    }

    public void setLooping(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048596, this, z) == null) {
            this.mLoop = z;
        }
    }

    public void setOnInfoListener(OnInfoListener onInfoListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048597, this, onInfoListener) == null) {
            this.mOnInfoListener = onInfoListener;
        }
    }

    public void setSurface(Surface surface) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048598, this, surface) == null) {
            this.mOutputSurface = surface;
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r26v0, resolved type: android.media.MediaExtractor */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:104:0x016c A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:82:0x013c  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x0141  */
    /* JADX WARN: Type inference failed for: r10v0 */
    /* JADX WARN: Type inference failed for: r10v1, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r10v2 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void doExtract(MediaExtractor mediaExtractor, int i, MediaCodec mediaCodec, FrameCallback frameCallback) {
        boolean z;
        boolean z2;
        int dequeueInputBuffer;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLILL(65538, this, mediaExtractor, i, mediaCodec, frameCallback) == null) {
            GLTextureView gLTextureView = this.mGLTextureView;
            ByteBuffer[] inputBuffers = mediaCodec.getInputBuffers();
            this.mInputChunk = 1;
            ?? r10 = 0;
            long j = -1;
            boolean z3 = false;
            boolean z4 = false;
            boolean z5 = false;
            boolean z6 = true;
            while (!z3) {
                if (this.mIsStopRequested) {
                    this.mIsPauseRequested = r10;
                    this.mIsStopRequested = r10;
                    return;
                }
                if (this.mIsPauseRequested) {
                    synchronized (this) {
                        if (this.mIsPauseRequested) {
                            if (frameCallback != null) {
                                frameCallback.reset();
                            }
                            try {
                                wait();
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                }
                if (!z4 && (dequeueInputBuffer = mediaCodec.dequeueInputBuffer(10000L)) >= 0) {
                    if (j == -1) {
                        j = System.nanoTime();
                    }
                    long j2 = j;
                    int readSampleData = mediaExtractor.readSampleData(inputBuffers[dequeueInputBuffer], r10);
                    if (readSampleData < 0) {
                        mediaCodec.queueInputBuffer(dequeueInputBuffer, 0, 0, 0L, 4);
                        j = j2;
                        z4 = true;
                        z5 = true;
                    } else {
                        if (mediaExtractor.getSampleTrackIndex() != i) {
                            Log.w(TAG, "WEIRD: got sample from track " + mediaExtractor.getSampleTrackIndex() + ", expected " + i);
                        }
                        if (z5 && this.mInputChunk == this.mPlayFrames + 1) {
                            mediaCodec.queueInputBuffer(dequeueInputBuffer, 0, 0, 0L, 4);
                            j = j2;
                            z4 = true;
                        } else {
                            mediaCodec.queueInputBuffer(dequeueInputBuffer, 0, readSampleData, mediaExtractor.getSampleTime(), 0);
                            this.mInputChunk++;
                            mediaExtractor.advance();
                            j = j2;
                        }
                    }
                }
                if (!z3) {
                    int dequeueOutputBuffer = mediaCodec.dequeueOutputBuffer(this.mBufferInfo, 10000L);
                    if (dequeueOutputBuffer != -1 && dequeueOutputBuffer != -3) {
                        if (dequeueOutputBuffer == -2) {
                            mediaCodec.getOutputFormat();
                        } else if (dequeueOutputBuffer >= 0) {
                            if (j != 0) {
                                System.nanoTime();
                                j = 0;
                            }
                            if ((this.mBufferInfo.flags & 4) != 0) {
                                if (this.mLoop) {
                                    z = true;
                                } else {
                                    z = false;
                                    z3 = true;
                                }
                            } else {
                                z = false;
                            }
                            if (this.mBufferInfo.size != 0) {
                                z2 = true;
                            } else {
                                z2 = false;
                            }
                            if (z2 && frameCallback != null) {
                                frameCallback.preRender(this.mBufferInfo.presentationTimeUs);
                            }
                            if (gLTextureView != null) {
                                gLTextureView.requestRender();
                                OnInfoListener onInfoListener = this.mOnInfoListener;
                                if (onInfoListener != null && z6) {
                                    onInfoListener.onInfo(this, 3, 0);
                                    z6 = false;
                                    mediaCodec.releaseOutputBuffer(dequeueOutputBuffer, z2);
                                    if (gLTextureView != null) {
                                        gLTextureView.requestRender();
                                    }
                                    if (!z) {
                                        this.mInputChunk = 1;
                                        mediaExtractor.seekTo(this.mStartFrameTimeUs, 2);
                                        mediaCodec.flush();
                                        if (frameCallback != null) {
                                            frameCallback.loopReset();
                                        }
                                        z4 = false;
                                    }
                                }
                            }
                            mediaCodec.releaseOutputBuffer(dequeueOutputBuffer, z2);
                            if (gLTextureView != null) {
                            }
                            if (!z) {
                            }
                        } else {
                            throw new RuntimeException("unexpected result from decoder.dequeueOutputBuffer: " + dequeueOutputBuffer);
                        }
                    }
                }
                r10 = 0;
            }
        }
    }

    private void onDataSourceSet(MediaExtractor mediaExtractor) {
        int selectVideoTrackIndex;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(65539, this, mediaExtractor) != null) || (selectVideoTrackIndex = selectVideoTrackIndex(mediaExtractor)) < 0) {
            return;
        }
        mediaExtractor.selectTrack(selectVideoTrackIndex);
        MediaFormat trackFormat = mediaExtractor.getTrackFormat(selectVideoTrackIndex);
        this.mVideoWidth = trackFormat.getInteger("width");
        this.mVideoHeight = trackFormat.getInteger("height");
        this.mDurationUs = trackFormat.getLong("durationUs");
        try {
            int integer = trackFormat.getInteger("frame-rate");
            this.mFps = integer;
            this.mDurationPerFrame = 1000 / integer;
        } catch (Exception e) {
            Log.e(TAG, "get frame rate (FPS) failed.", e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void play() throws IOException {
        FrameCallback frameCallback;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, this) == null) {
            int selectVideoTrackIndex = selectVideoTrackIndex(this.mMediaExtractor);
            if (selectVideoTrackIndex >= 0) {
                this.mMediaExtractor.selectTrack(selectVideoTrackIndex);
                MediaFormat trackFormat = this.mMediaExtractor.getTrackFormat(selectVideoTrackIndex);
                MediaCodec createDecoderByType = MediaCodec.createDecoderByType(trackFormat.getString("mime"));
                Surface surface = this.mOutputSurface;
                if (surface != null) {
                    createDecoderByType.configure(trackFormat, surface, (MediaCrypto) null, 0);
                    createDecoderByType.start();
                    try {
                        doExtract(this.mMediaExtractor, selectVideoTrackIndex, createDecoderByType, this.mFrameCallback);
                        this.mMediaExtractor.seekTo(0L, 2);
                        createDecoderByType.flush();
                        if (frameCallback != null) {
                            return;
                        }
                        return;
                    } finally {
                        try {
                            createDecoderByType.stop();
                        } catch (Exception unused) {
                        }
                        try {
                            createDecoderByType.release();
                        } catch (Exception unused2) {
                        }
                        frameCallback = this.mFrameCallback;
                        if (frameCallback != null) {
                            frameCallback.reset();
                        }
                    }
                }
                throw new IllegalStateException("The output surface is not prepared.");
            }
            throw new RuntimeException("No video track found in source file.");
        }
    }

    public static int selectVideoTrackIndex(MediaExtractor mediaExtractor) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, mediaExtractor)) == null) {
            int trackCount = mediaExtractor.getTrackCount();
            for (int i = 0; i < trackCount; i++) {
                if (mediaExtractor.getTrackFormat(i).getString("mime").startsWith(FileUtils.VIDEO_FILE_START)) {
                    return i;
                }
            }
            return -1;
        }
        return invokeL.intValue;
    }

    public void setDataSource(File file) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, file) == null) {
            FileInputStream fileInputStream = null;
            try {
                FileInputStream fileInputStream2 = new FileInputStream(file);
                try {
                    setDataSource(fileInputStream2.getFD());
                    try {
                        fileInputStream2.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                } catch (Throwable th) {
                    th = th;
                    fileInputStream = fileInputStream2;
                    if (fileInputStream != null) {
                        try {
                            fileInputStream.close();
                        } catch (IOException e2) {
                            e2.printStackTrace();
                        }
                    }
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
            }
        }
    }

    public int getCurrentPosition() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.mDurationPerFrame * (this.mInputChunk - 1);
        }
        return invokeV.intValue;
    }

    public long getDuration() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.mDurationUs / 1000;
        }
        return invokeV.longValue;
    }

    public int getFps() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.mFps;
        }
        return invokeV.intValue;
    }

    public String getGlVersion() {
        InterceptResult invokeV;
        ActivityManager activityManager;
        ConfigurationInfo deviceConfigurationInfo;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            GLTextureView gLTextureView = this.mGLTextureView;
            if (gLTextureView != null && (activityManager = (ActivityManager) gLTextureView.getContext().getSystemService("activity")) != null && (deviceConfigurationInfo = activityManager.getDeviceConfigurationInfo()) != null) {
                return deviceConfigurationInfo.getGlEsVersion();
            }
            return null;
        }
        return (String) invokeV.objValue;
    }

    public int getVideoHeight() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.mVideoHeight;
        }
        return invokeV.intValue;
    }

    public int getVideoWidth() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return this.mVideoWidth;
        }
        return invokeV.intValue;
    }

    public void requestPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            this.mIsPauseRequested = true;
        }
    }

    public void requestResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            this.mIsPauseRequested = false;
            synchronized (this) {
                notifyAll();
            }
        }
    }

    public void requestStop() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            this.mIsStopRequested = true;
        }
    }

    public void setDataSource(FileDescriptor fileDescriptor, long j, long j2) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048588, this, new Object[]{fileDescriptor, Long.valueOf(j), Long.valueOf(j2)}) == null) {
            MediaExtractor mediaExtractor = new MediaExtractor();
            this.mMediaExtractor = mediaExtractor;
            mediaExtractor.setDataSource(fileDescriptor, j, j2);
            onDataSourceSet(this.mMediaExtractor);
        }
    }

    public void setDataSource(String str) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, str) == null) {
            setDataSource(new File(str));
        }
    }

    public void setLoopSection(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048594, this, j) == null) {
            setLoopSection(j, (long) (this.mDurationUs / 1000.0d));
        }
    }

    public void setLoopSection(int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048593, this, i, i2) == null) {
            this.mStartFrameTimeUs = (long) ((1000.0d / this.mFps) * i * 1000.0d);
            this.mPlayFrames = (i2 - i) + 1;
        }
    }

    public void setLoopSection(long j, long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048595, this, new Object[]{Long.valueOf(j), Long.valueOf(j2)}) == null) {
            this.mStartFrameTimeUs = 1000 * j;
            this.mPlayFrames = ((int) (((j2 - j) / 1000.0d) * this.mFps)) + 1;
        }
    }
}
