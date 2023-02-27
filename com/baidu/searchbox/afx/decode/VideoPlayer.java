package com.baidu.searchbox.afx.decode;

import android.annotation.SuppressLint;
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
import com.baidu.searchbox.afx.callback.ErrorInfo;
import com.baidu.searchbox.afx.callback.OnReportListener;
import com.baidu.searchbox.afx.callback.OnVideoEndedListener;
import com.baidu.searchbox.afx.callback.OnVideoErrorListener;
import com.baidu.searchbox.afx.callback.PlaySuccessInfo;
import com.baidu.searchbox.afx.gl.GLTextureView;
import com.sina.weibo.sdk.utils.FileUtils;
import java.io.File;
import java.io.FileDescriptor;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
/* loaded from: classes2.dex */
public class VideoPlayer {
    public static final boolean DEBUG = false;
    public static final int DEFAULT_FPS = 25;
    public static final int MEDIA_INFO_EXTRA_NONE = 0;
    public static final int MEDIA_INFO_VIDEO_RENDERING_START = 3;
    public static final int MS_PER_SECOND = 1000;
    public static final String TAG = "VideoPlayer";
    public long mDurationUs;
    public FrameCallback mFrameCallback;
    public GLTextureView mGLTextureView;
    public volatile boolean mIsPauseRequested;
    public volatile boolean mIsStopRequested;
    public boolean mLoop;
    public MediaExtractor mMediaExtractor;
    public OnInfoListener mOnInfoListener;
    public Surface mOutputSurface;
    public int mVideoHeight;
    public int mVideoWidth;
    public MediaCodec.BufferInfo mBufferInfo = new MediaCodec.BufferInfo();
    public int mFps = 25;
    public int mDurationPerFrame = 0;
    public int mInputChunk = 1;
    public volatile long mStartFrameTimeUs = 0;
    public volatile int mPlayFrames = Integer.MAX_VALUE;

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
    public static class PlayTask implements Runnable {
        public static final int MSG_PLAY_ERROR = 1;
        public static final int MSG_PLAY_STOPPED = 0;
        public LocalHandler mLocalHandler;
        public VideoPlayer mPlayer;
        public String mPrepareTime;
        public final Object mStopLock = new Object();
        public boolean mStopped = false;
        public Thread mThread;

        /* loaded from: classes2.dex */
        public static class LocalHandler extends Handler {
            public OnVideoEndedListener mOnEndedListener;
            public OnVideoErrorListener mOnErrorListener;
            public OnReportListener mOnReportListener;

            public LocalHandler(OnVideoEndedListener onVideoEndedListener, OnVideoErrorListener onVideoErrorListener, OnReportListener onReportListener) {
                this.mOnEndedListener = onVideoEndedListener;
                this.mOnErrorListener = onVideoErrorListener;
                this.mOnReportListener = onReportListener;
            }

            @Override // android.os.Handler
            public void handleMessage(Message message) {
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

        public PlayTask(VideoPlayer videoPlayer, OnVideoEndedListener onVideoEndedListener, OnVideoErrorListener onVideoErrorListener, OnReportListener onReportListener) {
            this.mPlayer = videoPlayer;
            this.mLocalHandler = new LocalHandler(onVideoEndedListener, onVideoErrorListener, onReportListener);
        }

        @SuppressLint({"MobilebdThread"})
        public void execute() {
            Thread thread = new Thread(this, "VideoPlayer$PlayTask");
            this.mThread = thread;
            thread.start();
        }

        public void release() {
            this.mPlayer = null;
            LocalHandler localHandler = this.mLocalHandler;
            if (localHandler != null) {
                localHandler.mOnEndedListener = null;
                this.mLocalHandler.mOnErrorListener = null;
                this.mLocalHandler.mOnReportListener = null;
                this.mLocalHandler = null;
            }
        }

        public void waitForStop() {
            synchronized (this.mStopLock) {
                while (!this.mStopped) {
                    try {
                        this.mStopLock.wait();
                    } catch (InterruptedException unused) {
                    }
                }
            }
        }

        /* JADX DEBUG: Finally have unexpected throw blocks count: 2, expect 1 */
        @Override // java.lang.Runnable
        public void run() {
            boolean z;
            LocalHandler localHandler;
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

    public int getCurrentPosition() {
        return this.mDurationPerFrame * (this.mInputChunk - 1);
    }

    public long getDuration() {
        return this.mDurationUs / 1000;
    }

    public int getFps() {
        return this.mFps;
    }

    public String getGlVersion() {
        ActivityManager activityManager;
        ConfigurationInfo deviceConfigurationInfo;
        GLTextureView gLTextureView = this.mGLTextureView;
        if (gLTextureView != null && (activityManager = (ActivityManager) gLTextureView.getContext().getSystemService("activity")) != null && (deviceConfigurationInfo = activityManager.getDeviceConfigurationInfo()) != null) {
            return deviceConfigurationInfo.getGlEsVersion();
        }
        return null;
    }

    public int getVideoHeight() {
        return this.mVideoHeight;
    }

    public int getVideoWidth() {
        return this.mVideoWidth;
    }

    public void release() {
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

    public void requestPause() {
        this.mIsPauseRequested = true;
    }

    public void requestResume() {
        this.mIsPauseRequested = false;
        synchronized (this) {
            notifyAll();
        }
    }

    public void requestStop() {
        this.mIsStopRequested = true;
    }

    public static int selectVideoTrackIndex(MediaExtractor mediaExtractor) {
        int trackCount = mediaExtractor.getTrackCount();
        for (int i = 0; i < trackCount; i++) {
            if (mediaExtractor.getTrackFormat(i).getString("mime").startsWith(FileUtils.VIDEO_FILE_START)) {
                return i;
            }
        }
        return -1;
    }

    public void setDataSource(File file) throws IOException {
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

    public void setFrameCallback(FrameCallback frameCallback) {
        this.mFrameCallback = frameCallback;
    }

    public void setGLTextureView(GLTextureView gLTextureView) {
        this.mGLTextureView = gLTextureView;
    }

    public void setLoopSection(int i) {
        setLoopSection(i, (int) ((this.mDurationUs / 1000000.0d) * this.mFps));
    }

    public void setLooping(boolean z) {
        this.mLoop = z;
    }

    public void setOnInfoListener(OnInfoListener onInfoListener) {
        this.mOnInfoListener = onInfoListener;
    }

    public void setSurface(Surface surface) {
        this.mOutputSurface = surface;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r26v0, resolved type: android.media.MediaExtractor */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:80:0x0138  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x013d  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x0168 A[SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r10v0 */
    /* JADX WARN: Type inference failed for: r10v1, types: [int, boolean] */
    /* JADX WARN: Type inference failed for: r10v2 */
    @SuppressLint({"BDThrowableCheck"})
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void doExtract(MediaExtractor mediaExtractor, int i, MediaCodec mediaCodec, FrameCallback frameCallback) {
        boolean z;
        boolean z2;
        int dequeueInputBuffer;
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

    @SuppressLint({"BDThrowableCheck"})
    private void onDataSourceSet(MediaExtractor mediaExtractor) {
        int selectVideoTrackIndex = selectVideoTrackIndex(mediaExtractor);
        if (selectVideoTrackIndex < 0) {
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
    @SuppressLint({"BDThrowableCheck"})
    public void play() throws IOException {
        FrameCallback frameCallback;
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

    public void setDataSource(FileDescriptor fileDescriptor) throws IOException {
        MediaExtractor mediaExtractor = new MediaExtractor();
        this.mMediaExtractor = mediaExtractor;
        mediaExtractor.setDataSource(fileDescriptor);
        onDataSourceSet(this.mMediaExtractor);
    }

    public void setLoopSection(long j) {
        setLoopSection(j, (long) (this.mDurationUs / 1000.0d));
    }

    public void setDataSource(FileDescriptor fileDescriptor, long j, long j2) throws IOException {
        MediaExtractor mediaExtractor = new MediaExtractor();
        this.mMediaExtractor = mediaExtractor;
        mediaExtractor.setDataSource(fileDescriptor, j, j2);
        onDataSourceSet(this.mMediaExtractor);
    }

    public void setDataSource(String str) throws IOException {
        setDataSource(new File(str));
    }

    public void setLoopSection(int i, int i2) {
        this.mStartFrameTimeUs = (long) ((1000.0d / this.mFps) * i * 1000.0d);
        this.mPlayFrames = (i2 - i) + 1;
    }

    public void setLoopSection(long j, long j2) {
        this.mStartFrameTimeUs = 1000 * j;
        this.mPlayFrames = ((int) (((j2 - j) / 1000.0d) * this.mFps)) + 1;
    }
}
