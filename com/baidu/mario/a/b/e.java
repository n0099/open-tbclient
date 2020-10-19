package com.baidu.mario.a.b;

import android.media.MediaCodec;
import android.media.MediaFormat;
import android.media.MediaMuxer;
import android.util.Log;
import java.nio.ByteBuffer;
/* loaded from: classes5.dex */
public class e {
    private static final String TAG = e.class.getSimpleName();
    private MediaMuxer bJQ;
    private volatile boolean bJR = false;
    private f bJe;

    public boolean Vs() {
        return this.bJR;
    }

    public boolean a(String str, int i, f fVar) {
        if (!com.baidu.mario.a.c.a.iE(str)) {
            com.baidu.mario.a.c.a.iD(str);
        }
        try {
            this.bJQ = new MediaMuxer(str, i);
            this.bJe = fVar;
            this.bJR = false;
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
            i = this.bJQ.addTrack(mediaFormat);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return i;
        Log.e(TAG, "addMuxerTrack error!!!");
        i = -1;
        return i;
    }

    public synchronized void Vt() {
        boolean z = true;
        synchronized (this) {
            try {
                this.bJQ.start();
                this.bJR = true;
            } catch (Exception e) {
                Log.e(TAG, "startMuxer error!!!");
                z = false;
            }
            if (this.bJe != null) {
                this.bJe.db(z);
            }
        }
    }

    public boolean b(int i, ByteBuffer byteBuffer, MediaCodec.BufferInfo bufferInfo) {
        if (i != -1) {
            try {
                this.bJQ.writeSampleData(i, byteBuffer, bufferInfo);
                return true;
            } catch (Exception e) {
                Log.e(TAG, "startMuxer error!!!");
            }
        }
        return false;
    }

    public synchronized void Vu() {
        boolean z = false;
        synchronized (this) {
            try {
                this.bJQ.stop();
                this.bJR = false;
                z = true;
            } catch (Exception e) {
                Log.e(TAG, "stopMuxer error!!!");
            }
            if (this.bJe != null) {
                this.bJe.dc(z);
            }
        }
    }

    public void Vv() {
        if (!this.bJR) {
            this.bJQ.release();
            this.bJQ = null;
        }
    }
}
