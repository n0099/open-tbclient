package com.baidu.mario.a.b;

import android.media.MediaCodec;
import android.media.MediaFormat;
import android.media.MediaMuxer;
import android.util.Log;
import java.nio.ByteBuffer;
/* loaded from: classes5.dex */
public class e {
    private static final String TAG = e.class.getSimpleName();
    private f chy;
    private MediaMuxer cil;
    private volatile boolean cim = false;

    public boolean adq() {
        return this.cim;
    }

    public boolean a(String str, int i, f fVar) {
        if (!com.baidu.mario.a.c.a.jB(str)) {
            com.baidu.mario.a.c.a.jA(str);
        }
        try {
            this.cil = new MediaMuxer(str, i);
            this.chy = fVar;
            this.cim = false;
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
            i = this.cil.addTrack(mediaFormat);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return i;
        Log.e(TAG, "addMuxerTrack error!!!");
        i = -1;
        return i;
    }

    public synchronized void adr() {
        boolean z = true;
        synchronized (this) {
            try {
                this.cil.start();
                this.cim = true;
            } catch (Exception e) {
                Log.e(TAG, "startMuxer error!!!");
                z = false;
            }
            if (this.chy != null) {
                this.chy.dT(z);
            }
        }
    }

    public boolean b(int i, ByteBuffer byteBuffer, MediaCodec.BufferInfo bufferInfo) {
        if (i != -1) {
            try {
                this.cil.writeSampleData(i, byteBuffer, bufferInfo);
                return true;
            } catch (Exception e) {
                Log.e(TAG, "startMuxer error!!!");
            }
        }
        return false;
    }

    public synchronized void ads() {
        boolean z = false;
        synchronized (this) {
            try {
                this.cil.stop();
                this.cim = false;
                z = true;
            } catch (Exception e) {
                Log.e(TAG, "stopMuxer error!!!");
            }
            if (this.chy != null) {
                this.chy.dU(z);
            }
        }
    }

    public void adt() {
        if (!this.cim) {
            this.cil.release();
            this.cil = null;
        }
    }
}
