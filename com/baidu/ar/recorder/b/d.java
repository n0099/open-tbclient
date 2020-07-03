package com.baidu.ar.recorder.b;

import android.media.MediaCodec;
import android.media.MediaFormat;
import android.media.MediaMuxer;
import java.nio.ByteBuffer;
/* loaded from: classes3.dex */
public class d {
    private static final String TAG = d.class.getSimpleName();
    private e sW;
    private MediaMuxer tD;
    private volatile boolean tE = false;

    /* JADX WARN: Code restructure failed: missing block: B:4:0x0007, code lost:
        if (r0 >= 0) goto L5;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public synchronized int a(MediaFormat mediaFormat) {
        int i;
        try {
            i = this.tD.addTrack(mediaFormat);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return i;
        com.baidu.ar.f.b.b(TAG, "addMuxerTrack error!!!");
        i = -1;
        return i;
    }

    public boolean a(int i, ByteBuffer byteBuffer, MediaCodec.BufferInfo bufferInfo) {
        if (i != -1) {
            try {
                this.tD.writeSampleData(i, byteBuffer, bufferInfo);
                return true;
            } catch (Exception e) {
                com.baidu.ar.f.b.b(TAG, "startMuxer error!!!");
            }
        }
        return false;
    }

    public boolean a(String str, int i, e eVar) {
        if (!com.baidu.ar.recorder.c.a.ar(str)) {
            com.baidu.ar.recorder.c.a.aq(str);
        }
        try {
            this.tD = new MediaMuxer(str, i);
            this.sW = eVar;
            this.tE = false;
            return true;
        } catch (Exception e) {
            com.baidu.ar.f.b.b(TAG, "initMovieMuxer init error!!!");
            e.printStackTrace();
            return false;
        }
    }

    public boolean eH() {
        return this.tE;
    }

    public synchronized void eI() {
        boolean z = true;
        synchronized (this) {
            try {
                this.tD.start();
                this.tE = true;
            } catch (Exception e) {
                com.baidu.ar.f.b.b(TAG, "startMuxer error!!!");
                z = false;
            }
            if (this.sW != null) {
                this.sW.P(z);
            }
        }
    }

    public synchronized void eJ() {
        boolean z = false;
        synchronized (this) {
            try {
                this.tD.stop();
                this.tE = false;
                z = true;
            } catch (Exception e) {
                com.baidu.ar.f.b.b(TAG, "stopMuxer error!!!");
            }
            if (this.sW != null) {
                this.sW.Q(z);
            }
        }
    }

    public void eK() {
        if (this.tE) {
            return;
        }
        this.tD.release();
        this.tD = null;
    }
}
