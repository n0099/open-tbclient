package com.baidu.mario.a.b;

import android.media.MediaCodec;
import android.media.MediaFormat;
import android.media.MediaMuxer;
import android.util.Log;
import java.nio.ByteBuffer;
/* loaded from: classes11.dex */
public class e {
    private static final String TAG = e.class.getSimpleName();
    private f aKx;
    private volatile boolean aLx = false;
    private MediaMuxer mMediaMuxer;

    public boolean DJ() {
        return this.aLx;
    }

    public boolean a(String str, int i, f fVar) {
        if (!com.baidu.mario.a.c.a.ey(str)) {
            com.baidu.mario.a.c.a.ex(str);
        }
        try {
            this.mMediaMuxer = new MediaMuxer(str, i);
            this.aKx = fVar;
            this.aLx = false;
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

    public synchronized void DK() {
        boolean z = true;
        synchronized (this) {
            try {
                this.mMediaMuxer.start();
                this.aLx = true;
            } catch (Exception e) {
                Log.e(TAG, "startMuxer error!!!");
                z = false;
            }
            if (this.aKx != null) {
                this.aKx.bH(z);
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

    public synchronized void DL() {
        boolean z = false;
        synchronized (this) {
            try {
                this.mMediaMuxer.stop();
                this.aLx = false;
                z = true;
            } catch (Exception e) {
                Log.e(TAG, "stopMuxer error!!!");
            }
            if (this.aKx != null) {
                this.aKx.bI(z);
            }
        }
    }

    public void DM() {
        if (!this.aLx) {
            this.mMediaMuxer.release();
            this.mMediaMuxer = null;
        }
    }
}
