package com.baidu.mario.a.b;

import android.media.MediaCodec;
import android.media.MediaFormat;
import android.media.MediaMuxer;
import android.util.Log;
import java.nio.ByteBuffer;
/* loaded from: classes10.dex */
public class e {
    private static final String TAG = e.class.getSimpleName();
    private f btq;
    private MediaMuxer buc;
    private volatile boolean bud = false;

    public boolean MJ() {
        return this.bud;
    }

    public boolean a(String str, int i, f fVar) {
        if (!com.baidu.mario.a.c.a.gl(str)) {
            com.baidu.mario.a.c.a.gk(str);
        }
        try {
            this.buc = new MediaMuxer(str, i);
            this.btq = fVar;
            this.bud = false;
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
            i = this.buc.addTrack(mediaFormat);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return i;
        Log.e(TAG, "addMuxerTrack error!!!");
        i = -1;
        return i;
    }

    public synchronized void MK() {
        boolean z = true;
        synchronized (this) {
            try {
                this.buc.start();
                this.bud = true;
            } catch (Exception e) {
                Log.e(TAG, "startMuxer error!!!");
                z = false;
            }
            if (this.btq != null) {
                this.btq.cK(z);
            }
        }
    }

    public boolean b(int i, ByteBuffer byteBuffer, MediaCodec.BufferInfo bufferInfo) {
        if (i != -1) {
            try {
                this.buc.writeSampleData(i, byteBuffer, bufferInfo);
                return true;
            } catch (Exception e) {
                Log.e(TAG, "startMuxer error!!!");
            }
        }
        return false;
    }

    public synchronized void ML() {
        boolean z = false;
        synchronized (this) {
            try {
                this.buc.stop();
                this.bud = false;
                z = true;
            } catch (Exception e) {
                Log.e(TAG, "stopMuxer error!!!");
            }
            if (this.btq != null) {
                this.btq.cL(z);
            }
        }
    }

    public void MM() {
        if (!this.bud) {
            this.buc.release();
            this.buc = null;
        }
    }
}
