package com.baidu.ar.recorder.encoder;

import android.media.MediaCodec;
import android.media.MediaFormat;
import android.media.MediaMuxer;
import android.support.annotation.RequiresApi;
import android.util.Log;
import java.nio.ByteBuffer;
@RequiresApi(api = 18)
/* loaded from: classes3.dex */
public class d {
    private static final String a = d.class.getSimpleName();
    private static volatile d e;
    private MediaMuxer b;
    private volatile boolean c = false;
    private e d;

    private d() {
    }

    public static d a() {
        if (e == null) {
            synchronized (d.class) {
                if (e == null) {
                    e = new d();
                }
            }
        }
        return e;
    }

    /* JADX WARN: Code restructure failed: missing block: B:4:0x0007, code lost:
        if (r0 >= 0) goto L5;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public synchronized int a(MediaFormat mediaFormat) {
        int i;
        try {
            i = this.b.addTrack(mediaFormat);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        return i;
        Log.e(a, "addMuxerTrack error!!!");
        i = -1;
        return i;
    }

    public boolean a(int i, ByteBuffer byteBuffer, MediaCodec.BufferInfo bufferInfo) {
        if (i != -1) {
            try {
                this.b.writeSampleData(i, byteBuffer, bufferInfo);
                return true;
            } catch (Exception e2) {
                Log.e(a, "startMuxer error!!!");
            }
        }
        return false;
    }

    public boolean a(String str, int i, e eVar) {
        if (!com.baidu.ar.recorder.e.a.b(str)) {
            com.baidu.ar.recorder.e.a.a(str);
        }
        try {
            this.b = new MediaMuxer(str, i);
            this.d = eVar;
            this.c = false;
            return true;
        } catch (Exception e2) {
            Log.e(a, "initMovieMuxer init error!!!");
            e2.printStackTrace();
            return false;
        }
    }

    public boolean b() {
        return this.c;
    }

    public synchronized void c() {
        boolean z = true;
        synchronized (this) {
            try {
                this.b.start();
                this.c = true;
            } catch (Exception e2) {
                Log.e(a, "startMuxer error!!!");
                z = false;
            }
            if (this.d != null) {
                this.d.a(z);
            }
        }
    }

    public synchronized void d() {
        boolean z = false;
        synchronized (this) {
            try {
                this.b.stop();
                this.c = false;
                z = true;
            } catch (Exception e2) {
                Log.e(a, "stopMuxer error!!!");
            }
            if (this.d != null) {
                this.d.b(z);
            }
        }
    }

    public void e() {
        if (this.c) {
            return;
        }
        this.b.release();
        this.b = null;
        e = null;
    }
}
