package com.baidu.mario.a.b;

import android.media.MediaCodec;
import android.media.MediaFormat;
import android.media.MediaMuxer;
import android.util.Log;
import java.nio.ByteBuffer;
/* loaded from: classes4.dex */
public class e {
    private static final String TAG = e.class.getSimpleName();
    private f bCC;
    private MediaMuxer bDo;
    private volatile boolean bDp = false;

    public boolean Tz() {
        return this.bDp;
    }

    public boolean a(String str, int i, f fVar) {
        if (!com.baidu.mario.a.c.a.id(str)) {
            com.baidu.mario.a.c.a.ic(str);
        }
        try {
            this.bDo = new MediaMuxer(str, i);
            this.bCC = fVar;
            this.bDp = false;
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
            i = this.bDo.addTrack(mediaFormat);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return i;
        Log.e(TAG, "addMuxerTrack error!!!");
        i = -1;
        return i;
    }

    public synchronized void TA() {
        boolean z = true;
        synchronized (this) {
            try {
                this.bDo.start();
                this.bDp = true;
            } catch (Exception e) {
                Log.e(TAG, "startMuxer error!!!");
                z = false;
            }
            if (this.bCC != null) {
                this.bCC.cU(z);
            }
        }
    }

    public boolean b(int i, ByteBuffer byteBuffer, MediaCodec.BufferInfo bufferInfo) {
        if (i != -1) {
            try {
                this.bDo.writeSampleData(i, byteBuffer, bufferInfo);
                return true;
            } catch (Exception e) {
                Log.e(TAG, "startMuxer error!!!");
            }
        }
        return false;
    }

    public synchronized void TB() {
        boolean z = false;
        synchronized (this) {
            try {
                this.bDo.stop();
                this.bDp = false;
                z = true;
            } catch (Exception e) {
                Log.e(TAG, "stopMuxer error!!!");
            }
            if (this.bCC != null) {
                this.bCC.cV(z);
            }
        }
    }

    public void TC() {
        if (!this.bDp) {
            this.bDo.release();
            this.bDo = null;
        }
    }
}
