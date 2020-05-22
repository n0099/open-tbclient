package com.baidu.mario.a.b;

import android.media.MediaCodec;
import android.media.MediaFormat;
import android.media.MediaMuxer;
import android.util.Log;
import java.nio.ByteBuffer;
/* loaded from: classes11.dex */
public class e {
    private static final String TAG = e.class.getSimpleName();
    private f bnU;
    private MediaMuxer boG;
    private volatile boolean boH = false;

    public boolean Lt() {
        return this.boH;
    }

    public boolean a(String str, int i, f fVar) {
        if (!com.baidu.mario.a.c.a.ge(str)) {
            com.baidu.mario.a.c.a.gd(str);
        }
        try {
            this.boG = new MediaMuxer(str, i);
            this.bnU = fVar;
            this.boH = false;
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
            i = this.boG.addTrack(mediaFormat);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return i;
        Log.e(TAG, "addMuxerTrack error!!!");
        i = -1;
        return i;
    }

    public synchronized void Lu() {
        boolean z = true;
        synchronized (this) {
            try {
                this.boG.start();
                this.boH = true;
            } catch (Exception e) {
                Log.e(TAG, "startMuxer error!!!");
                z = false;
            }
            if (this.bnU != null) {
                this.bnU.cC(z);
            }
        }
    }

    public boolean b(int i, ByteBuffer byteBuffer, MediaCodec.BufferInfo bufferInfo) {
        if (i != -1) {
            try {
                this.boG.writeSampleData(i, byteBuffer, bufferInfo);
                return true;
            } catch (Exception e) {
                Log.e(TAG, "startMuxer error!!!");
            }
        }
        return false;
    }

    public synchronized void Lv() {
        boolean z = false;
        synchronized (this) {
            try {
                this.boG.stop();
                this.boH = false;
                z = true;
            } catch (Exception e) {
                Log.e(TAG, "stopMuxer error!!!");
            }
            if (this.bnU != null) {
                this.bnU.cD(z);
            }
        }
    }

    public void Lw() {
        if (!this.boH) {
            this.boG.release();
            this.boG = null;
        }
    }
}
