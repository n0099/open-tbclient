package com.baidu.ar.recorder.b;

import android.media.MediaCodec;
import android.media.MediaFormat;
import android.media.MediaMuxer;
import java.nio.ByteBuffer;
/* loaded from: classes11.dex */
public class d {
    private static final String TAG = d.class.getSimpleName();
    private e tB;
    private MediaMuxer ui;
    private volatile boolean uj = false;

    /* JADX WARN: Code restructure failed: missing block: B:4:0x0007, code lost:
        if (r0 >= 0) goto L5;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public synchronized int a(MediaFormat mediaFormat) {
        int i;
        try {
            i = this.ui.addTrack(mediaFormat);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return i;
        com.baidu.ar.g.b.b(TAG, "addMuxerTrack error!!!");
        i = -1;
        return i;
    }

    public boolean a(int i, ByteBuffer byteBuffer, MediaCodec.BufferInfo bufferInfo) {
        if (i != -1) {
            try {
                this.ui.writeSampleData(i, byteBuffer, bufferInfo);
                return true;
            } catch (Exception e) {
                com.baidu.ar.g.b.b(TAG, "startMuxer error!!!");
            }
        }
        return false;
    }

    public boolean a(String str, int i, e eVar) {
        if (!com.baidu.ar.recorder.c.a.av(str)) {
            com.baidu.ar.recorder.c.a.au(str);
        }
        try {
            this.ui = new MediaMuxer(str, i);
            this.tB = eVar;
            this.uj = false;
            return true;
        } catch (Exception e) {
            com.baidu.ar.g.b.b(TAG, "initMovieMuxer init error!!!");
            e.printStackTrace();
            return false;
        }
    }

    public boolean fT() {
        return this.uj;
    }

    public synchronized void fU() {
        boolean z = true;
        synchronized (this) {
            try {
                this.ui.start();
                this.uj = true;
            } catch (Exception e) {
                com.baidu.ar.g.b.b(TAG, "startMuxer error!!!");
                z = false;
            }
            if (this.tB != null) {
                this.tB.Q(z);
            }
        }
    }

    public synchronized void fV() {
        boolean z = false;
        synchronized (this) {
            try {
                this.ui.stop();
                this.uj = false;
                z = true;
            } catch (Exception e) {
                com.baidu.ar.g.b.b(TAG, "stopMuxer error!!!");
            }
            if (this.tB != null) {
                this.tB.R(z);
            }
        }
    }

    public void fW() {
        if (this.uj) {
            return;
        }
        this.ui.release();
        this.ui = null;
    }
}
