package com.baidu.crabsdk.a;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.view.Choreographer;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.zip.Deflater;
import java.util.zip.DeflaterOutputStream;
/* JADX INFO: Access modifiers changed from: package-private */
@TargetApi(16)
/* loaded from: classes8.dex */
public final class e implements Choreographer.FrameCallback {
    static final e QX = new e();
    private boolean ao = false;
    private long QY = 0;
    private long QZ = 41666666;
    private long Ra = 16666665;
    private int Rb = 0;

    private e() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void a(e eVar) {
        Context context;
        byte[] bArr = null;
        Map<String, Object> g = a.nZ().g();
        if (g == null) {
            com.baidu.crabsdk.c.a.w("no keyStack; blockRecord = null; not a block!!!");
            return;
        }
        com.baidu.crabsdk.c.a.v("^^ -BlockCanaryCore- ^^" + g.toString());
        context = c.QU;
        Map<String, Object> a = com.baidu.crabsdk.sender.g.a(context, (Throwable) null, true);
        a.putAll(g);
        com.baidu.crabsdk.sender.g.b(a);
        String g2 = com.baidu.crabsdk.sender.i.g(a);
        String c = com.baidu.crabsdk.c.d.c(com.baidu.crabsdk.a.d, UUID.randomUUID().toString());
        String P = com.baidu.crabsdk.c.d.P(g2, c);
        try {
            c = com.baidu.crabsdk.c.e.cr(c);
        } catch (Exception e) {
            e.printStackTrace();
        }
        com.baidu.crabsdk.sender.h.ox();
        if (com.baidu.crabsdk.sender.h.os()) {
            com.baidu.crabsdk.c.a.cj("-BlockCanaryCore- switch on -  *^o^* doUploadBlock *^o^*");
            if (!com.baidu.crabsdk.sender.h.ow()) {
                com.baidu.crabsdk.c.a.cj("CrashSwitch.canBlockUploadToday() == false");
                b.oa().stop();
                eVar.stop();
                return;
            }
            if (P != null) {
                try {
                    if (P.length() != 0) {
                        if (com.baidu.crabsdk.a.H) {
                            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                            DeflaterOutputStream deflaterOutputStream = new DeflaterOutputStream(byteArrayOutputStream, new Deflater(9, true));
                            deflaterOutputStream.write(P.getBytes("UTF-8"));
                            deflaterOutputStream.close();
                            bArr = byteArrayOutputStream.toByteArray();
                        } else {
                            bArr = P.getBytes("UTF-8");
                        }
                    }
                } catch (UnsupportedEncodingException e2) {
                    e2.printStackTrace();
                    return;
                } catch (IOException e3) {
                    e3.printStackTrace();
                    return;
                }
            }
            com.baidu.crabsdk.sender.k.a(bArr, c);
        }
    }

    private void reset() {
        this.QY = 0L;
        this.Rb = 0;
    }

    @Override // android.view.Choreographer.FrameCallback
    public final void doFrame(long j) {
        ExecutorService executorService;
        try {
            if (this.QY != 0) {
                long j2 = j - this.QY;
                if (j2 > this.QZ) {
                    this.Rb = (int) ((j2 / this.Ra) + this.Rb);
                } else if (this.Rb > 0) {
                    if (this.Rb > 30) {
                        com.baidu.crabsdk.c.a.v("^^ block skip frames = " + this.Rb + "\n^^ costs : " + TimeUnit.NANOSECONDS.toMillis(this.Rb * this.Ra) + "ms");
                        if (TimeUnit.NANOSECONDS.toMillis(this.Rb * this.Ra) >= a.U) {
                            executorService = c.QV;
                            executorService.execute(new f(this));
                        }
                        this.Rb = 1;
                    }
                    this.Rb--;
                }
            }
            this.QY = j;
        } catch (Throwable th) {
            com.baidu.crabsdk.c.a.w("doFrame:" + th.toString());
        }
        try {
            Choreographer.getInstance().postFrameCallback(QX);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public final void start() {
        if (this.ao) {
            return;
        }
        this.ao = true;
        reset();
        try {
            if (Looper.getMainLooper() == Looper.myLooper()) {
                try {
                    Choreographer.getInstance().postFrameCallback(QX);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } else {
                new Handler(Looper.getMainLooper()).post(new g(this));
            }
        } catch (Exception e2) {
            com.baidu.crabsdk.c.a.f("postFrameCallback error!!", e2);
        }
    }

    public final void stop() {
        this.ao = false;
        reset();
        if (Looper.getMainLooper() != Looper.myLooper()) {
            new Handler(Looper.getMainLooper()).post(new h(this));
            return;
        }
        try {
            Choreographer.getInstance().removeFrameCallback(QX);
            com.baidu.crabsdk.c.a.cj("stop FrameMonitor !!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
