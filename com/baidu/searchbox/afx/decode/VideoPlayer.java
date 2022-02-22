package com.baidu.searchbox.afx.decode;

import android.app.ActivityManager;
import android.content.pm.ConfigurationInfo;
import android.media.MediaCodec;
import android.media.MediaCrypto;
import android.media.MediaExtractor;
import android.media.MediaFormat;
import android.os.Handler;
import android.os.Message;
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
/* loaded from: classes11.dex */
public class VideoPlayer {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int DEFAULT_FPS = 25;
    public static final int MEDIA_INFO_EXTRA_NONE = 0;
    public static final int MEDIA_INFO_VIDEO_RENDERING_START = 3;
    public static final String TAG = "VideoPlayer";
    public static final boolean VERBOSE = false;
    public transient /* synthetic */ FieldHolder $fh;
    public MediaCodec.BufferInfo mBufferInfo;
    public long mDurationUs;
    public int mFps;
    public FrameCallback mFrameCallback;
    public GLTextureView mGLTextureView;
    public volatile boolean mIsPauseRequested;
    public volatile boolean mIsStopRequested;
    public boolean mLoop;
    public MediaCodec mMediaDecoder;
    public MediaExtractor mMediaExtractor;
    public OnInfoListener mOnInfoListener;
    public Surface mOutputSurface;
    public volatile int mPlayFrames;
    public volatile long mStartFrameTimeUs;
    public int mVideoHeight;
    public int mVideoWidth;

    /* loaded from: classes11.dex */
    public interface FrameCallback {
        void loopReset();

        void preRender(long j2);

        void reset();
    }

    /* loaded from: classes11.dex */
    public interface OnInfoListener {
        boolean onInfo(VideoPlayer videoPlayer, int i2, int i3);
    }

    /* loaded from: classes11.dex */
    public static class PlayTask implements Runnable {
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

        /* loaded from: classes11.dex */
        public static class LocalHandler extends Handler {
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
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
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
                    int i2 = message.what;
                    if (i2 == 0) {
                        String str = (String) message.obj;
                        OnVideoEndedListener onVideoEndedListener = this.mOnEndedListener;
                        if (onVideoEndedListener != null) {
                            onVideoEndedListener.onVideoEnded();
                        }
                        if (this.mOnReportListener != null) {
                            this.mOnReportListener.onSuccess(new PlaySuccessInfo(null, String.valueOf(System.currentTimeMillis() / 1000), str));
                        }
                    } else if (i2 != 1) {
                    } else {
                        String valueOf = String.valueOf(System.currentTimeMillis() / 1000);
                        OnReportListener onReportListener = this.mOnReportListener;
                        if (onReportListener != null) {
                            onReportListener.onError(new ErrorInfo(16, ErrorInfo.VIDEO_PLAY_SOURCE_ERROR_ERRORMSG, (Exception) message.obj, null, null, null, valueOf));
                        }
                        OnVideoErrorListener onVideoErrorListener = this.mOnErrorListener;
                        if (onVideoErrorListener != null) {
                            onVideoErrorListener.onError(new ErrorInfo(16, ErrorInfo.VIDEO_PLAY_SOURCE_ERROR_ERRORMSG, (Exception) message.obj, null, null, null, valueOf));
                        }
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
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
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

        /* JADX DEBUG: Finally have unexpected throw blocks count: 2, expect 1 */
        @Override // java.lang.Runnable
        public void run() {
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
                    } catch (Exception e2) {
                        boolean sendMessage = this.mLocalHandler != null ? this.mLocalHandler.sendMessage(this.mLocalHandler.obtainMessage(1, e2)) : false;
                        synchronized (this.mStopLock) {
                            this.mStopped = true;
                            this.mStopLock.notifyAll();
                            if (sendMessage || (localHandler = this.mLocalHandler) == null) {
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
    }

    public VideoPlayer() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mBufferInfo = new MediaCodec.BufferInfo();
        this.mFps = 25;
        this.mStartFrameTimeUs = 0L;
        this.mPlayFrames = Integer.MAX_VALUE;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r27v0, resolved type: android.media.MediaExtractor */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:105:0x0177 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:83:0x0148  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x014d  */
    /* JADX WARN: Type inference failed for: r10v0 */
    /* JADX WARN: Type inference failed for: r10v1, types: [int, boolean] */
    /* JADX WARN: Type inference failed for: r10v2 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void doExtract(MediaExtractor mediaExtractor, int i2, MediaCodec mediaCodec, FrameCallback frameCallback) {
        ByteBuffer[] byteBufferArr;
        boolean z;
        int dequeueInputBuffer;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLILL(65538, this, mediaExtractor, i2, mediaCodec, frameCallback) == null) {
            GLTextureView gLTextureView = this.mGLTextureView;
            ByteBuffer[] inputBuffers = mediaCodec.getInputBuffers();
            long j2 = -1;
            ?? r10 = 0;
            long j3 = -1;
            int i3 = 1;
            boolean z2 = false;
            boolean z3 = false;
            boolean z4 = false;
            boolean z5 = true;
            while (!z2) {
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
                            } catch (InterruptedException e2) {
                                e2.printStackTrace();
                            }
                        }
                    }
                }
                if (z3 || (dequeueInputBuffer = mediaCodec.dequeueInputBuffer(10000L)) < 0) {
                    byteBufferArr = inputBuffers;
                    i3 = i3;
                } else {
                    if (j3 == j2) {
                        j3 = System.nanoTime();
                    }
                    long j4 = j3;
                    int readSampleData = mediaExtractor.readSampleData(inputBuffers[dequeueInputBuffer], r10);
                    if (readSampleData < 0) {
                        byteBufferArr = inputBuffers;
                        mediaCodec.queueInputBuffer(dequeueInputBuffer, 0, 0, 0L, 4);
                        i3 = i3;
                        j3 = j4;
                        z3 = true;
                        z4 = true;
                    } else {
                        int i4 = i3;
                        byteBufferArr = inputBuffers;
                        if (mediaExtractor.getSampleTrackIndex() != i2) {
                            String str = "WEIRD: got sample from track " + mediaExtractor.getSampleTrackIndex() + ", expected " + i2;
                        }
                        if (z4 && i4 == this.mPlayFrames + 1) {
                            mediaCodec.queueInputBuffer(dequeueInputBuffer, 0, 0, 0L, 4);
                            i3 = i4;
                            j3 = j4;
                            z3 = true;
                        } else {
                            mediaCodec.queueInputBuffer(dequeueInputBuffer, 0, readSampleData, mediaExtractor.getSampleTime(), 0);
                            i3 = i4 + 1;
                            mediaExtractor.advance();
                            j3 = j4;
                        }
                    }
                }
                if (!z2) {
                    int dequeueOutputBuffer = mediaCodec.dequeueOutputBuffer(this.mBufferInfo, 10000L);
                    if (dequeueOutputBuffer != -1 && dequeueOutputBuffer != -3) {
                        if (dequeueOutputBuffer == -2) {
                            mediaCodec.getOutputFormat();
                        } else if (dequeueOutputBuffer >= 0) {
                            if (j3 != 0) {
                                System.nanoTime();
                                j3 = 0;
                            }
                            if ((this.mBufferInfo.flags & 4) == 0) {
                                z = false;
                            } else if (this.mLoop) {
                                z = true;
                            } else {
                                z = false;
                                z2 = true;
                            }
                            boolean z6 = this.mBufferInfo.size != 0;
                            if (z6 && frameCallback != null) {
                                frameCallback.preRender(this.mBufferInfo.presentationTimeUs);
                            }
                            if (gLTextureView != null) {
                                gLTextureView.requestRender();
                                OnInfoListener onInfoListener = this.mOnInfoListener;
                                if (onInfoListener != null && z5) {
                                    onInfoListener.onInfo(this, 3, 0);
                                    z5 = false;
                                    mediaCodec.releaseOutputBuffer(dequeueOutputBuffer, z6);
                                    if (gLTextureView != null) {
                                        gLTextureView.requestRender();
                                    }
                                    if (!z) {
                                        mediaExtractor.seekTo(this.mStartFrameTimeUs, 2);
                                        mediaCodec.flush();
                                        if (frameCallback != null) {
                                            frameCallback.loopReset();
                                        }
                                        i3 = 1;
                                        z3 = false;
                                    }
                                }
                            }
                            mediaCodec.releaseOutputBuffer(dequeueOutputBuffer, z6);
                            if (gLTextureView != null) {
                            }
                            if (!z) {
                            }
                        } else {
                            throw new RuntimeException("unexpected result from decoder.dequeueOutputBuffer: " + dequeueOutputBuffer);
                        }
                    }
                }
                inputBuffers = byteBufferArr;
                r10 = 0;
                j2 = -1;
            }
        }
    }

    private void onDataSourceSet(MediaExtractor mediaExtractor) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, this, mediaExtractor) == null) {
            int selectVideoTrackIndex = selectVideoTrackIndex(mediaExtractor);
            if (selectVideoTrackIndex >= 0) {
                mediaExtractor.selectTrack(selectVideoTrackIndex);
                MediaFormat trackFormat = mediaExtractor.getTrackFormat(selectVideoTrackIndex);
                this.mVideoWidth = trackFormat.getInteger("width");
                this.mVideoHeight = trackFormat.getInteger("height");
                this.mDurationUs = trackFormat.getLong("durationUs");
                try {
                    this.mFps = trackFormat.getInteger("frame-rate");
                    return;
                } catch (Exception unused) {
                    return;
                }
            }
            throw new RuntimeException("No video track found in source file.");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void play() throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, this) == null) {
            MediaExtractor mediaExtractor = this.mMediaExtractor;
            MediaCodec mediaCodec = this.mMediaDecoder;
            int selectVideoTrackIndex = selectVideoTrackIndex(mediaExtractor);
            if (selectVideoTrackIndex >= 0) {
                mediaExtractor.selectTrack(selectVideoTrackIndex);
                if (mediaCodec == null) {
                    MediaFormat trackFormat = mediaExtractor.getTrackFormat(selectVideoTrackIndex);
                    MediaCodec createDecoderByType = MediaCodec.createDecoderByType(trackFormat.getString("mime"));
                    Surface surface = this.mOutputSurface;
                    if (surface != null) {
                        createDecoderByType.configure(trackFormat, surface, (MediaCrypto) null, 0);
                        createDecoderByType.start();
                        this.mMediaDecoder = createDecoderByType;
                        mediaCodec = createDecoderByType;
                    } else {
                        throw new IllegalStateException("The output surface is not prepared.");
                    }
                }
                doExtract(mediaExtractor, selectVideoTrackIndex, mediaCodec, this.mFrameCallback);
                mediaExtractor.seekTo(0L, 2);
                mediaCodec.flush();
                FrameCallback frameCallback = this.mFrameCallback;
                if (frameCallback != null) {
                    frameCallback.reset();
                    return;
                }
                return;
            }
            throw new RuntimeException("No video track found in source file.");
        }
    }

    public static int selectVideoTrackIndex(MediaExtractor mediaExtractor) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, mediaExtractor)) == null) {
            int trackCount = mediaExtractor.getTrackCount();
            for (int i2 = 0; i2 < trackCount; i2++) {
                if (mediaExtractor.getTrackFormat(i2).getString("mime").startsWith(FileUtils.VIDEO_FILE_START)) {
                    return i2;
                }
            }
            return -1;
        }
        return invokeL.intValue;
    }

    public long getDuration() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.mDurationUs / 1000 : invokeV.longValue;
    }

    public int getFps() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.mFps : invokeV.intValue;
    }

    public String getGlVersion() {
        InterceptResult invokeV;
        ActivityManager activityManager;
        ConfigurationInfo deviceConfigurationInfo;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            GLTextureView gLTextureView = this.mGLTextureView;
            if (gLTextureView == null || (activityManager = (ActivityManager) gLTextureView.getContext().getSystemService("activity")) == null || (deviceConfigurationInfo = activityManager.getDeviceConfigurationInfo()) == null) {
                return null;
            }
            return deviceConfigurationInfo.getGlEsVersion();
        }
        return (String) invokeV.objValue;
    }

    public int getVideoHeight() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.mVideoHeight : invokeV.intValue;
    }

    public int getVideoWidth() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.mVideoWidth : invokeV.intValue;
    }

    public void release() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            MediaCodec mediaCodec = this.mMediaDecoder;
            if (mediaCodec != null) {
                try {
                    mediaCodec.stop();
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
                try {
                    this.mMediaDecoder.release();
                } catch (Exception e3) {
                    e3.printStackTrace();
                }
                this.mMediaDecoder = null;
            }
            MediaExtractor mediaExtractor = this.mMediaExtractor;
            if (mediaExtractor != null) {
                try {
                    mediaExtractor.release();
                } catch (Exception e4) {
                    e4.printStackTrace();
                }
                this.mMediaExtractor = null;
            }
            Surface surface = this.mOutputSurface;
            if (surface != null) {
                try {
                    surface.release();
                } catch (Exception e5) {
                    e5.printStackTrace();
                }
                this.mOutputSurface = null;
            }
            this.mGLTextureView = null;
            this.mStartFrameTimeUs = 0L;
            this.mPlayFrames = Integer.MAX_VALUE;
        }
    }

    public void requestPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            this.mIsPauseRequested = true;
        }
    }

    public void requestResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            this.mIsPauseRequested = false;
            synchronized (this) {
                notifyAll();
            }
        }
    }

    public void requestStop() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            this.mIsStopRequested = true;
        }
    }

    public void setDataSource(String str) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, str) == null) {
            setDataSource(new File(str));
        }
    }

    public void setFrameCallback(FrameCallback frameCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, frameCallback) == null) {
            this.mFrameCallback = frameCallback;
        }
    }

    public void setGLTextureView(GLTextureView gLTextureView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, gLTextureView) == null) {
            this.mGLTextureView = gLTextureView;
        }
    }

    public void setLoopSection(long j2, long j3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048594, this, new Object[]{Long.valueOf(j2), Long.valueOf(j3)}) == null) {
            this.mStartFrameTimeUs = 1000 * j2;
            this.mPlayFrames = ((int) (((j3 - j2) / 1000.0d) * this.mFps)) + 1;
        }
    }

    public void setLooping(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048595, this, z) == null) {
            this.mLoop = z;
        }
    }

    public void setOnInfoListener(OnInfoListener onInfoListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048596, this, onInfoListener) == null) {
            this.mOnInfoListener = onInfoListener;
        }
    }

    public void setSurface(Surface surface) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048597, this, surface) == null) {
            this.mOutputSurface = surface;
        }
    }

    public void setDataSource(File file) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable != null && interceptable.invokeL(1048585, this, file) != null) {
            return;
        }
        FileInputStream fileInputStream = null;
        try {
            FileInputStream fileInputStream2 = new FileInputStream(file);
            try {
                setDataSource(fileInputStream2.getFD());
                try {
                    fileInputStream2.close();
                } catch (IOException e2) {
                    e2.printStackTrace();
                }
            } catch (Throwable th) {
                th = th;
                fileInputStream = fileInputStream2;
                if (fileInputStream != null) {
                    try {
                        fileInputStream.close();
                    } catch (IOException e3) {
                        e3.printStackTrace();
                    }
                }
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public void setLoopSection(long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048593, this, j2) == null) {
            setLoopSection(j2, (long) (this.mDurationUs / 1000.0d));
        }
    }

    public void setLoopSection(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048592, this, i2, i3) == null) {
            this.mStartFrameTimeUs = (long) ((1000.0d / this.mFps) * i2 * 1000.0d);
            this.mPlayFrames = (i3 - i2) + 1;
        }
    }

    public void setLoopSection(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048591, this, i2) == null) {
            setLoopSection(i2, (int) ((this.mDurationUs / 1000000.0d) * this.mFps));
        }
    }

    public void setDataSource(FileDescriptor fileDescriptor) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, fileDescriptor) == null) {
            MediaExtractor mediaExtractor = new MediaExtractor();
            this.mMediaExtractor = mediaExtractor;
            mediaExtractor.setDataSource(fileDescriptor);
            onDataSourceSet(this.mMediaExtractor);
        }
    }

    public void setDataSource(FileDescriptor fileDescriptor, long j2, long j3) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048587, this, new Object[]{fileDescriptor, Long.valueOf(j2), Long.valueOf(j3)}) == null) {
            MediaExtractor mediaExtractor = new MediaExtractor();
            this.mMediaExtractor = mediaExtractor;
            mediaExtractor.setDataSource(fileDescriptor, j2, j3);
            onDataSourceSet(this.mMediaExtractor);
        }
    }
}
