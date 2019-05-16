package com.baidu.mario.b.b;

import android.media.MediaCodec;
import android.media.MediaFormat;
import android.media.MediaMuxer;
import android.util.Log;
import java.nio.ByteBuffer;
/* loaded from: classes2.dex */
public class e {
    private static final String TAG = e.class.getSimpleName();
    private f adV;
    private MediaMuxer aeT;
    private volatile boolean aeU = false;

    public boolean tF() {
        return this.aeU;
    }

    public boolean a(String str, int i, f fVar) {
        if (!com.baidu.mario.b.c.a.cD(str)) {
            com.baidu.mario.b.c.a.cC(str);
        }
        try {
            this.aeT = new MediaMuxer(str, i);
            this.adV = fVar;
            this.aeU = false;
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
            i = this.aeT.addTrack(mediaFormat);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return i;
        Log.e(TAG, "addMuxerTrack error!!!");
        i = -1;
        return i;
    }

    public synchronized void tG() {
        boolean z = true;
        synchronized (this) {
            try {
                this.aeT.start();
                this.aeU = true;
            } catch (Exception e) {
                Log.e(TAG, "startMuxer error!!!");
                z = false;
            }
            if (this.adV != null) {
                this.adV.aJ(z);
            }
        }
    }

    public boolean b(int i, ByteBuffer byteBuffer, MediaCodec.BufferInfo bufferInfo) {
        if (i != -1) {
            try {
                this.aeT.writeSampleData(i, byteBuffer, bufferInfo);
                return true;
            } catch (Exception e) {
                Log.e(TAG, "startMuxer error!!!");
            }
        }
        return false;
    }

    public synchronized void tH() {
        boolean z = false;
        synchronized (this) {
            try {
                this.aeT.stop();
                this.aeU = false;
                z = true;
            } catch (Exception e) {
                Log.e(TAG, "stopMuxer error!!!");
            }
            if (this.adV != null) {
                this.adV.aK(z);
            }
        }
    }

    public void tI() {
        if (!this.aeU) {
            this.aeT.release();
            this.aeT = null;
        }
    }
}
