package com.baidu.mario.a.b;

import android.media.MediaCodec;
import android.media.MediaFormat;
import android.media.MediaMuxer;
import android.util.Log;
import java.nio.ByteBuffer;
/* loaded from: classes15.dex */
public class e {
    private static final String TAG = e.class.getSimpleName();
    private f cgU;
    private MediaMuxer chG;
    private volatile boolean chH = false;

    public boolean abn() {
        return this.chH;
    }

    public boolean a(String str, int i, f fVar) {
        if (!com.baidu.mario.a.c.a.iW(str)) {
            com.baidu.mario.a.c.a.iV(str);
        }
        try {
            this.chG = new MediaMuxer(str, i);
            this.cgU = fVar;
            this.chH = false;
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
    public synchronized int b(MediaFormat mediaFormat) {
        int i;
        try {
            i = this.chG.addTrack(mediaFormat);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return i;
        Log.e(TAG, "addMuxerTrack error!!!");
        i = -1;
        return i;
    }

    public synchronized void abo() {
        boolean z = true;
        synchronized (this) {
            try {
                this.chG.start();
                this.chH = true;
            } catch (Exception e) {
                Log.e(TAG, "startMuxer error!!!");
                z = false;
            }
            if (this.cgU != null) {
                this.cgU.dX(z);
            }
        }
    }

    public boolean b(int i, ByteBuffer byteBuffer, MediaCodec.BufferInfo bufferInfo) {
        if (i != -1) {
            try {
                this.chG.writeSampleData(i, byteBuffer, bufferInfo);
                return true;
            } catch (Exception e) {
                Log.e(TAG, "startMuxer error!!!");
            }
        }
        return false;
    }

    public synchronized void abp() {
        boolean z = false;
        synchronized (this) {
            try {
                this.chG.stop();
                this.chH = false;
                z = true;
            } catch (Exception e) {
                Log.e(TAG, "stopMuxer error!!!");
            }
            if (this.cgU != null) {
                this.cgU.dY(z);
            }
        }
    }

    public void abq() {
        if (!this.chH) {
            this.chG.release();
            this.chG = null;
        }
    }
}
