package com.baidu.mario.a.b;

import android.media.MediaCodec;
import android.media.MediaFormat;
import android.media.MediaMuxer;
import android.util.Log;
import java.nio.ByteBuffer;
/* loaded from: classes11.dex */
public class e {
    private static final String TAG = e.class.getSimpleName();
    private f aKi;
    private volatile boolean aLi = false;
    private MediaMuxer mMediaMuxer;

    public boolean DC() {
        return this.aLi;
    }

    public boolean a(String str, int i, f fVar) {
        if (!com.baidu.mario.a.c.a.ez(str)) {
            com.baidu.mario.a.c.a.ey(str);
        }
        try {
            this.mMediaMuxer = new MediaMuxer(str, i);
            this.aKi = fVar;
            this.aLi = false;
            return true;
        } catch (Exception e) {
            Log.e(TAG, "initMovieMuxer init error!!!");
            e.printStackTrace();
            return false;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:4:0x0007, code lost:
        if (r0 >= 0) goto L5;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public synchronized int c(MediaFormat mediaFormat) {
        int i;
        try {
            i = this.mMediaMuxer.addTrack(mediaFormat);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return i;
        Log.e(TAG, "addMuxerTrack error!!!");
        i = -1;
        return i;
    }

    public synchronized void DD() {
        boolean z = true;
        synchronized (this) {
            try {
                this.mMediaMuxer.start();
                this.aLi = true;
            } catch (Exception e) {
                Log.e(TAG, "startMuxer error!!!");
                z = false;
            }
            if (this.aKi != null) {
                this.aKi.bG(z);
            }
        }
    }

    public boolean b(int i, ByteBuffer byteBuffer, MediaCodec.BufferInfo bufferInfo) {
        if (i != -1) {
            try {
                this.mMediaMuxer.writeSampleData(i, byteBuffer, bufferInfo);
                return true;
            } catch (Exception e) {
                Log.e(TAG, "startMuxer error!!!");
            }
        }
        return false;
    }

    public synchronized void DE() {
        boolean z = false;
        synchronized (this) {
            try {
                this.mMediaMuxer.stop();
                this.aLi = false;
                z = true;
            } catch (Exception e) {
                Log.e(TAG, "stopMuxer error!!!");
            }
            if (this.aKi != null) {
                this.aKi.bH(z);
            }
        }
    }

    public void DF() {
        if (!this.aLi) {
            this.mMediaMuxer.release();
            this.mMediaMuxer = null;
        }
    }
}
