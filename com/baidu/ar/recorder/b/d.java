package com.baidu.ar.recorder.b;

import android.media.MediaCodec;
import android.media.MediaFormat;
import android.media.MediaMuxer;
import java.nio.ByteBuffer;
/* loaded from: classes3.dex */
public class d {
    private static final String TAG = d.class.getSimpleName();
    private MediaMuxer uV;
    private volatile boolean uW = false;
    private e uo;

    /* JADX WARN: Code restructure failed: missing block: B:4:0x0007, code lost:
        if (r0 >= 0) goto L5;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public synchronized int a(MediaFormat mediaFormat) {
        int i;
        try {
            i = this.uV.addTrack(mediaFormat);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return i;
        com.baidu.ar.h.b.b(TAG, "addMuxerTrack error!!!");
        i = -1;
        return i;
    }

    public boolean a(int i, ByteBuffer byteBuffer, MediaCodec.BufferInfo bufferInfo) {
        if (i != -1) {
            try {
                this.uV.writeSampleData(i, byteBuffer, bufferInfo);
                return true;
            } catch (Exception e) {
                com.baidu.ar.h.b.b(TAG, "startMuxer error!!!");
            }
        }
        return false;
    }

    public boolean a(String str, int i, e eVar) {
        if (!com.baidu.ar.recorder.c.a.ay(str)) {
            com.baidu.ar.recorder.c.a.ax(str);
        }
        try {
            this.uV = new MediaMuxer(str, i);
            this.uo = eVar;
            this.uW = false;
            return true;
        } catch (Exception e) {
            com.baidu.ar.h.b.b(TAG, "initMovieMuxer init error!!!");
            e.printStackTrace();
            return false;
        }
    }

    public boolean fU() {
        return this.uW;
    }

    public synchronized void fV() {
        boolean z = true;
        synchronized (this) {
            try {
                this.uV.start();
                this.uW = true;
            } catch (Exception e) {
                com.baidu.ar.h.b.b(TAG, "startMuxer error!!!");
                z = false;
            }
            if (this.uo != null) {
                this.uo.O(z);
            }
        }
    }

    public synchronized void fW() {
        boolean z = false;
        synchronized (this) {
            try {
                this.uV.stop();
                this.uW = false;
                z = true;
            } catch (Exception e) {
                com.baidu.ar.h.b.b(TAG, "stopMuxer error!!!");
            }
            if (this.uo != null) {
                this.uo.P(z);
            }
        }
    }

    public void fX() {
        if (this.uW) {
            return;
        }
        this.uV.release();
        this.uV = null;
    }
}
