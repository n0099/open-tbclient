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
/* loaded from: classes6.dex */
public final class e implements Choreographer.FrameCallback {
    static final e Po = new e();
    private boolean ao = false;
    private long Pp = 0;
    private long Pq = 41666666;
    private long Pr = 16666665;
    private int Ps = 0;

    private e() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void a(e eVar) {
        Context context;
        byte[] bArr = null;
        Map<String, Object> g = a.nr().g();
        if (g == null) {
            com.baidu.crabsdk.c.a.w("no keyStack; blockRecord = null; not a block!!!");
            return;
        }
        com.baidu.crabsdk.c.a.v("^^ -BlockCanaryCore- ^^" + g.toString());
        context = c.Pl;
        Map<String, Object> a = com.baidu.crabsdk.sender.g.a(context, (Throwable) null, true);
        a.putAll(g);
        com.baidu.crabsdk.sender.g.b(a);
        String g2 = com.baidu.crabsdk.sender.i.g(a);
        String c = com.baidu.crabsdk.c.d.c(com.baidu.crabsdk.a.d, UUID.randomUUID().toString());
        String K = com.baidu.crabsdk.c.d.K(g2, c);
        try {
            c = com.baidu.crabsdk.c.e.cj(c);
        } catch (Exception e) {
            e.printStackTrace();
        }
        com.baidu.crabsdk.sender.h.nO();
        if (com.baidu.crabsdk.sender.h.nJ()) {
            com.baidu.crabsdk.c.a.cb("-BlockCanaryCore- switch on -  *^o^* doUploadBlock *^o^*");
            if (!com.baidu.crabsdk.sender.h.nN()) {
                com.baidu.crabsdk.c.a.cb("CrashSwitch.canBlockUploadToday() == false");
                b.ns().stop();
                eVar.stop();
                return;
            }
            if (K != null) {
                try {
                    if (K.length() != 0) {
                        if (com.baidu.crabsdk.a.H) {
                            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                            DeflaterOutputStream deflaterOutputStream = new DeflaterOutputStream(byteArrayOutputStream, new Deflater(9, true));
                            deflaterOutputStream.write(K.getBytes("UTF-8"));
                            deflaterOutputStream.close();
                            bArr = byteArrayOutputStream.toByteArray();
                        } else {
                            bArr = K.getBytes("UTF-8");
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
        this.Pp = 0L;
        this.Ps = 0;
    }

    @Override // android.view.Choreographer.FrameCallback
    public final void doFrame(long j) {
        ExecutorService executorService;
        try {
            if (this.Pp != 0) {
                long j2 = j - this.Pp;
                if (j2 > this.Pq) {
                    this.Ps = (int) ((j2 / this.Pr) + this.Ps);
                } else if (this.Ps > 0) {
                    if (this.Ps > 30) {
                        com.baidu.crabsdk.c.a.v("^^ block skip frames = " + this.Ps + "\n^^ costs : " + TimeUnit.NANOSECONDS.toMillis(this.Ps * this.Pr) + "ms");
                        if (TimeUnit.NANOSECONDS.toMillis(this.Ps * this.Pr) >= a.U) {
                            executorService = c.Pm;
                            executorService.execute(new f(this));
                        }
                        this.Ps = 1;
                    }
                    this.Ps--;
                }
            }
            this.Pp = j;
        } catch (Throwable th) {
            com.baidu.crabsdk.c.a.w("doFrame:" + th.toString());
        }
        try {
            Choreographer.getInstance().postFrameCallback(Po);
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
                    Choreographer.getInstance().postFrameCallback(Po);
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
            Choreographer.getInstance().removeFrameCallback(Po);
            com.baidu.crabsdk.c.a.cb("stop FrameMonitor !!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
