package com.baidu.channelrtc.medialivesender;

import android.hardware.Camera;
import android.media.MediaRecorder;
import android.net.LocalServerSocket;
import android.net.LocalSocket;
import android.util.Log;
import android.view.SurfaceHolder;
import java.io.IOException;
/* loaded from: classes.dex */
class VideoRecorder {
    private static final String TAG = "VideoRecorder";
    private static VideoRecorder sInstance = null;
    private boolean isVideoRecording;
    private Camera mCamera;
    private MediaRecorder mRecorder;
    private LocalSocket mSenderSoc;
    private LocalServerSocket mServerSoc;
    private int mheight;
    private SurfaceHolder mholder;
    private int mwidth;
    private int mframeRate = 25;
    private int mbitRate = 512000;
    private boolean stoped = false;

    private VideoRecorder() {
    }

    public static synchronized VideoRecorder getInstance() {
        VideoRecorder videoRecorder;
        synchronized (VideoRecorder.class) {
            if (sInstance == null) {
                sInstance = new VideoRecorder();
            }
            videoRecorder = sInstance;
        }
        return videoRecorder;
    }

    private boolean initLocalSocket() {
        try {
            this.mSenderSoc = this.mServerSoc.accept();
            this.mSenderSoc.setReceiveBufferSize(10240);
            this.mSenderSoc.setSendBufferSize(10240);
            return true;
        } catch (IOException e) {
            return false;
        }
    }

    private boolean initVideoRecorder(SurfaceHolder surfaceHolder) {
        boolean z;
        if (this.mRecorder != null) {
            releaseMediaRecorder();
        }
        try {
            this.mCamera.unlock();
        } catch (Exception e) {
            Log.e(TAG, "mCamera unlock failed");
        }
        this.mRecorder = new MediaRecorder();
        this.mRecorder.setCamera(this.mCamera);
        this.mRecorder.setVideoSource(1);
        this.mRecorder.setOutputFormat(2);
        this.mRecorder.setVideoEncoder(2);
        this.mRecorder.setVideoEncodingBitRate(this.mbitRate);
        this.mRecorder.setPreviewDisplay(surfaceHolder.getSurface());
        this.mRecorder.setVideoSize(this.mwidth, this.mheight);
        this.mRecorder.setOrientationHint(90);
        this.mRecorder.setOutputFile(this.mSenderSoc.getFileDescriptor());
        try {
            this.mRecorder.prepare();
            this.mRecorder.start();
            z = true;
        } catch (Exception e2) {
            z = false;
            releaseMediaRecorder();
            Log.e(TAG, "采集准备失败");
        }
        this.isVideoRecording = true;
        return z;
    }

    private void prepar() {
        if (!preparVideoRecoder(this.mholder)) {
            Log.e(TAG, "采集初始化失");
            releaseAll();
            return;
        }
        try {
            this.mRecorder.prepare();
            this.mRecorder.start();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (IllegalStateException e2) {
            e2.printStackTrace();
        }
        try {
            Thread.sleep(2000L);
        } catch (InterruptedException e3) {
            e3.printStackTrace();
        }
        releaseMediaRecorder();
    }

    private boolean preparVideoRecoder(SurfaceHolder surfaceHolder) {
        if (this.mRecorder != null) {
            releaseMediaRecorder();
        }
        try {
            this.mCamera.unlock();
        } catch (Exception e) {
            Log.e(TAG, "mCamera unlock failed");
        }
        this.mRecorder = new MediaRecorder();
        this.mRecorder.setCamera(this.mCamera);
        this.mRecorder.setVideoSource(1);
        this.mRecorder.setOutputFormat(1);
        this.mRecorder.setVideoEncoder(2);
        this.mRecorder.setVideoEncodingBitRate(this.mbitRate);
        this.mRecorder.setPreviewDisplay(surfaceHolder.getSurface());
        this.mRecorder.setVideoSize(this.mwidth, this.mheight);
        this.mRecorder.setOrientationHint(90);
        this.mRecorder.setOutputFile("/sdcard/prepar.3gp");
        this.isVideoRecording = true;
        return true;
    }

    private void releaseLocalSocket() {
        try {
            if (this.mSenderSoc != null) {
                this.mSenderSoc.close();
            }
            if (this.mServerSoc != null) {
                this.mServerSoc.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        this.mSenderSoc = null;
        this.mServerSoc = null;
    }

    private void releaseMediaRecorder() {
        try {
            if (this.mRecorder == null) {
                return;
            }
            if (this.isVideoRecording) {
                this.mRecorder.stop();
                this.isVideoRecording = false;
            }
            this.mRecorder.release();
            this.mRecorder = null;
        } catch (Exception e) {
            Log.d(TAG, e.toString());
        }
    }

    public void prepareServer(LiveNativeSender liveNativeSender) {
        if (this.isVideoRecording) {
            Log.e(TAG, "正在视频采集");
            return;
        }
        if (this.stoped) {
            this.stoped = false;
        }
        Log.i(TAG, "videorecorder started: before prepare");
        prepar();
        Log.i(TAG, "videorecorder started: after prepare");
        Log.i(TAG, "set video params:" + this.mwidth + this.mheight + this.mbitRate + this.mframeRate);
        liveNativeSender.setVideoParams(this.mwidth, this.mheight, this.mbitRate, this.mframeRate);
        try {
            releaseLocalSocket();
            this.mServerSoc = new LocalServerSocket("com.baidu.livevideo.Video");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void releaseAll() {
        releaseLocalSocket();
        releaseMediaRecorder();
        sInstance = null;
    }

    public void setCamera(Camera camera) {
        if (camera != null) {
            this.mCamera = camera;
        }
    }

    public void setSurfaceHolder(SurfaceHolder surfaceHolder) {
        if (surfaceHolder != null) {
            this.mholder = surfaceHolder;
        }
    }

    public void setVideoEncodingBitRate(int i) {
        if (i > 0) {
            this.mbitRate = i;
        }
        Log.i(TAG, "bitRate = " + this.mbitRate);
    }

    public void setVideoSize(int i, int i2) {
        if (i > 0 && i2 > 0) {
            this.mwidth = i;
            this.mheight = i2;
        }
        Log.i("fff", "width = " + this.mwidth);
        Log.i("fff", "height = " + this.mheight);
    }

    public void start() {
        if (!initLocalSocket()) {
            Log.e(TAG, "本地服务开启失败");
            releaseAll();
            return;
        }
        Log.i(TAG, "init local socket success");
        if (initVideoRecorder(this.mholder)) {
            Log.i(TAG, "init video recorder success");
            return;
        }
        Log.e(TAG, "采集初始化失");
        releaseAll();
    }

    public void stop() {
        if (this.mRecorder == null) {
            return;
        }
        this.stoped = true;
    }
}
