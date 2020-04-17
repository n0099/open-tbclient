package com.baidu.ar.recorder.b;

import android.media.MediaCodec;
import android.media.MediaFormat;
import android.media.MediaMuxer;
import java.nio.ByteBuffer;
/* loaded from: classes3.dex */
public class d {
    private static final String TAG = d.class.getSimpleName();
    private e sw;
    private MediaMuxer td;
    private volatile boolean te = false;

    /* JADX WARN: Code restructure failed: missing block: B:4:0x0007, code lost:
        if (r0 >= 0) goto L5;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public synchronized int a(MediaFormat mediaFormat) {
        int i;
        try {
            i = this.td.addTrack(mediaFormat);
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
                this.td.writeSampleData(i, byteBuffer, bufferInfo);
                return true;
            } catch (Exception e) {
                com.baidu.ar.f.b.b(TAG, "startMuxer error!!!");
            }
        }
        return false;
    }

    public boolean a(String str, int i, e eVar) {
        if (!com.baidu.ar.recorder.c.a.aq(str)) {
            com.baidu.ar.recorder.c.a.ap(str);
        }
        try {
            this.td = new MediaMuxer(str, i);
            this.sw = eVar;
            this.te = false;
            return true;
        } catch (Exception e) {
            com.baidu.ar.f.b.b(TAG, "initMovieMuxer init error!!!");
            e.printStackTrace();
            return false;
        }
    }

    public boolean er() {
        return this.te;
    }

    public synchronized void es() {
        boolean z = true;
        synchronized (this) {
            try {
                this.td.start();
                this.te = true;
            } catch (Exception e) {
                com.baidu.ar.f.b.b(TAG, "startMuxer error!!!");
                z = false;
            }
            if (this.sw != null) {
                this.sw.O(z);
            }
        }
    }

    public synchronized void et() {
        boolean z = false;
        synchronized (this) {
            try {
                this.td.stop();
                this.te = false;
                z = true;
            } catch (Exception e) {
                com.baidu.ar.f.b.b(TAG, "stopMuxer error!!!");
            }
            if (this.sw != null) {
                this.sw.P(z);
            }
        }
    }

    public void eu() {
        if (this.te) {
            return;
        }
        this.td.release();
        this.td = null;
    }
}
