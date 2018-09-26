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
/* loaded from: classes2.dex */
public final class e implements Choreographer.FrameCallback {
    static final e UC = new e();
    private boolean an = false;
    private long UD = 0;
    private long UE = 41666666;
    private long UF = 16666665;
    private int ar = 0;

    private e() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void a(e eVar) {
        Context context;
        byte[] bArr = null;
        Map<String, Object> g = a.pY().g();
        if (g == null) {
            com.baidu.crabsdk.c.a.cy("no keyStack; blockRecord = null; not a block!!!");
            return;
        }
        com.baidu.crabsdk.c.a.cx("^^ -BlockCanaryCore- ^^" + g.toString());
        context = c.Uy;
        Map<String, Object> a = com.baidu.crabsdk.sender.d.a(context, (Throwable) null, true);
        a.putAll(g);
        com.baidu.crabsdk.sender.d.b(a);
        String k = com.baidu.crabsdk.sender.f.k(a);
        String c = com.baidu.crabsdk.c.d.c(com.baidu.crabsdk.a.d, UUID.randomUUID().toString());
        String S = com.baidu.crabsdk.c.d.S(k, c);
        try {
            c = com.baidu.crabsdk.c.e.cE(c);
        } catch (Exception e) {
            e.printStackTrace();
        }
        com.baidu.crabsdk.sender.e.ac();
        if (com.baidu.crabsdk.sender.e.qs()) {
            com.baidu.crabsdk.c.a.cv("-BlockCanaryCore- switch on -  *^o^* doUploadBlock *^o^*");
            if (!com.baidu.crabsdk.sender.e.qv()) {
                com.baidu.crabsdk.c.a.cv("CrashSwitch.canBlockUploadToday() == false");
                b.pZ().stop();
                eVar.stop();
                return;
            }
            if (S != null) {
                try {
                    if (S.length() != 0) {
                        if (com.baidu.crabsdk.a.H) {
                            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                            DeflaterOutputStream deflaterOutputStream = new DeflaterOutputStream(byteArrayOutputStream, new Deflater(9, true));
                            deflaterOutputStream.write(S.getBytes("UTF-8"));
                            deflaterOutputStream.close();
                            bArr = byteArrayOutputStream.toByteArray();
                        } else {
                            bArr = S.getBytes("UTF-8");
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
        this.UD = 0L;
        this.ar = 0;
    }

    @Override // android.view.Choreographer.FrameCallback
    public final void doFrame(long j) {
        ExecutorService executorService;
        try {
            if (this.UD != 0) {
                long j2 = j - this.UD;
                if (j2 > this.UE) {
                    this.ar = (int) ((j2 / this.UF) + this.ar);
                } else if (this.ar > 0) {
                    if (this.ar > 30) {
                        com.baidu.crabsdk.c.a.cx("^^ block skip frames = " + this.ar + "\n^^ costs : " + TimeUnit.NANOSECONDS.toMillis(this.ar * this.UF) + "ms");
                        if (TimeUnit.NANOSECONDS.toMillis(this.ar * this.UF) >= a.T) {
                            executorService = c.Uz;
                            executorService.execute(new f(this));
                        }
                        this.ar = 1;
                    }
                    this.ar--;
                }
            }
            this.UD = j;
        } catch (Throwable th) {
            com.baidu.crabsdk.c.a.cy("doFrame:" + th.toString());
        }
        Choreographer.getInstance().postFrameCallback(UC);
    }

    public final void start() {
        if (this.an) {
            return;
        }
        this.an = true;
        reset();
        try {
            if (Looper.getMainLooper() == Looper.myLooper()) {
                Choreographer.getInstance().postFrameCallback(UC);
            } else {
                new Handler(Looper.getMainLooper()).post(new g(this));
            }
        } catch (Exception e) {
            com.baidu.crabsdk.c.a.f("postFrameCallback error!!", e);
        }
    }

    public final void stop() {
        this.an = false;
        reset();
        if (Looper.getMainLooper() != Looper.myLooper()) {
            new Handler(Looper.getMainLooper()).post(new h(this));
            return;
        }
        Choreographer.getInstance().removeFrameCallback(UC);
        com.baidu.crabsdk.c.a.cv("stop FrameMonitor !!");
    }
}
