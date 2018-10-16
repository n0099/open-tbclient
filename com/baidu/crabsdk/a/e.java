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
    static final e Xq = new e();
    private boolean ao = false;
    private long Xr = 0;
    private long Xs = 41666666;
    private long Xt = 16666665;
    private int as = 0;

    private e() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void a(e eVar) {
        Context context;
        byte[] bArr = null;
        Map<String, Object> g = a.ri().g();
        if (g == null) {
            com.baidu.crabsdk.c.a.cJ("no keyStack; blockRecord = null; not a block!!!");
            return;
        }
        com.baidu.crabsdk.c.a.cI("^^ -BlockCanaryCore- ^^" + g.toString());
        context = c.Xn;
        Map<String, Object> a = com.baidu.crabsdk.sender.d.a(context, (Throwable) null, true);
        a.putAll(g);
        com.baidu.crabsdk.sender.d.b(a);
        String j = com.baidu.crabsdk.sender.f.j(a);
        String c = com.baidu.crabsdk.c.d.c(com.baidu.crabsdk.a.d, UUID.randomUUID().toString());
        String Y = com.baidu.crabsdk.c.d.Y(j, c);
        try {
            c = com.baidu.crabsdk.c.e.cO(c);
        } catch (Exception e) {
            e.printStackTrace();
        }
        com.baidu.crabsdk.sender.e.rF();
        if (com.baidu.crabsdk.sender.e.rB()) {
            com.baidu.crabsdk.c.a.cG("-BlockCanaryCore- switch on -  *^o^* doUploadBlock *^o^*");
            if (!com.baidu.crabsdk.sender.e.rE()) {
                com.baidu.crabsdk.c.a.cG("CrashSwitch.canBlockUploadToday() == false");
                b.rj().stop();
                eVar.stop();
                return;
            }
            if (Y != null) {
                try {
                    if (Y.length() != 0) {
                        if (com.baidu.crabsdk.a.H) {
                            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                            DeflaterOutputStream deflaterOutputStream = new DeflaterOutputStream(byteArrayOutputStream, new Deflater(9, true));
                            deflaterOutputStream.write(Y.getBytes("UTF-8"));
                            deflaterOutputStream.close();
                            bArr = byteArrayOutputStream.toByteArray();
                        } else {
                            bArr = Y.getBytes("UTF-8");
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
        this.Xr = 0L;
        this.as = 0;
    }

    @Override // android.view.Choreographer.FrameCallback
    public final void doFrame(long j) {
        ExecutorService executorService;
        try {
            if (this.Xr != 0) {
                long j2 = j - this.Xr;
                if (j2 > this.Xs) {
                    this.as = (int) ((j2 / this.Xt) + this.as);
                } else if (this.as > 0) {
                    if (this.as > 30) {
                        com.baidu.crabsdk.c.a.cI("^^ block skip frames = " + this.as + "\n^^ costs : " + TimeUnit.NANOSECONDS.toMillis(this.as * this.Xt) + "ms");
                        if (TimeUnit.NANOSECONDS.toMillis(this.as * this.Xt) >= a.U) {
                            executorService = c.Xo;
                            executorService.execute(new f(this));
                        }
                        this.as = 1;
                    }
                    this.as--;
                }
            }
            this.Xr = j;
        } catch (Throwable th) {
            com.baidu.crabsdk.c.a.cJ("doFrame:" + th.toString());
        }
        try {
            Choreographer.getInstance().postFrameCallback(Xq);
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
                    Choreographer.getInstance().postFrameCallback(Xq);
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
            Choreographer.getInstance().removeFrameCallback(Xq);
            com.baidu.crabsdk.c.a.cG("stop FrameMonitor !!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
