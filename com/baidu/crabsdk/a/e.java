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
    static final e Xz = new e();
    private boolean ao = false;
    private long XA = 0;
    private long XB = 41666666;
    private long XC = 16666665;
    private int as = 0;

    private e() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void a(e eVar) {
        Context context;
        byte[] bArr = null;
        Map<String, Object> g = a.rj().g();
        if (g == null) {
            com.baidu.crabsdk.c.a.cK("no keyStack; blockRecord = null; not a block!!!");
            return;
        }
        com.baidu.crabsdk.c.a.cJ("^^ -BlockCanaryCore- ^^" + g.toString());
        context = c.Xw;
        Map<String, Object> a = com.baidu.crabsdk.sender.d.a(context, (Throwable) null, true);
        a.putAll(g);
        com.baidu.crabsdk.sender.d.b(a);
        String j = com.baidu.crabsdk.sender.f.j(a);
        String c = com.baidu.crabsdk.c.d.c(com.baidu.crabsdk.a.d, UUID.randomUUID().toString());
        String Z = com.baidu.crabsdk.c.d.Z(j, c);
        try {
            c = com.baidu.crabsdk.c.e.cP(c);
        } catch (Exception e) {
            e.printStackTrace();
        }
        com.baidu.crabsdk.sender.e.rF();
        if (com.baidu.crabsdk.sender.e.rB()) {
            com.baidu.crabsdk.c.a.cH("-BlockCanaryCore- switch on -  *^o^* doUploadBlock *^o^*");
            if (!com.baidu.crabsdk.sender.e.rE()) {
                com.baidu.crabsdk.c.a.cH("CrashSwitch.canBlockUploadToday() == false");
                b.rk().stop();
                eVar.stop();
                return;
            }
            if (Z != null) {
                try {
                    if (Z.length() != 0) {
                        if (com.baidu.crabsdk.a.H) {
                            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                            DeflaterOutputStream deflaterOutputStream = new DeflaterOutputStream(byteArrayOutputStream, new Deflater(9, true));
                            deflaterOutputStream.write(Z.getBytes("UTF-8"));
                            deflaterOutputStream.close();
                            bArr = byteArrayOutputStream.toByteArray();
                        } else {
                            bArr = Z.getBytes("UTF-8");
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
            com.baidu.crabsdk.sender.h.a(bArr, c);
        }
    }

    private void reset() {
        this.XA = 0L;
        this.as = 0;
    }

    @Override // android.view.Choreographer.FrameCallback
    public final void doFrame(long j) {
        ExecutorService executorService;
        try {
            if (this.XA != 0) {
                long j2 = j - this.XA;
                if (j2 > this.XB) {
                    this.as = (int) ((j2 / this.XC) + this.as);
                } else if (this.as > 0) {
                    if (this.as > 30) {
                        com.baidu.crabsdk.c.a.cJ("^^ block skip frames = " + this.as + "\n^^ costs : " + TimeUnit.NANOSECONDS.toMillis(this.as * this.XC) + "ms");
                        if (TimeUnit.NANOSECONDS.toMillis(this.as * this.XC) >= a.U) {
                            executorService = c.Xx;
                            executorService.execute(new f(this));
                        }
                        this.as = 1;
                    }
                    this.as--;
                }
            }
            this.XA = j;
        } catch (Throwable th) {
            com.baidu.crabsdk.c.a.cK("doFrame:" + th.toString());
        }
        try {
            Choreographer.getInstance().postFrameCallback(Xz);
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
                    Choreographer.getInstance().postFrameCallback(Xz);
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
            Choreographer.getInstance().removeFrameCallback(Xz);
            com.baidu.crabsdk.c.a.cH("stop FrameMonitor !!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
