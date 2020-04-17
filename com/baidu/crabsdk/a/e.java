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
    static final e ajy = new e();
    private boolean aq = false;
    private long ajz = 0;
    private long ajA = 41666666;
    private long ajB = 16666665;
    private int au = 0;

    private e() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void a(e eVar) {
        Context context;
        byte[] bArr = null;
        Map<String, Object> su = a.st().su();
        if (su == null) {
            com.baidu.crabsdk.c.a.w("no keyStack; blockRecord = null; not a block!!!");
            return;
        }
        com.baidu.crabsdk.c.a.v("^^ -BlockCanaryCore- ^^" + su.toString());
        context = c.ajv;
        Map<String, Object> a = com.baidu.crabsdk.sender.g.a(context, (Throwable) null, true);
        a.putAll(su);
        com.baidu.crabsdk.sender.g.b(a);
        String d = com.baidu.crabsdk.sender.i.d(a);
        String c = com.baidu.crabsdk.c.d.c(com.baidu.crabsdk.a.d, UUID.randomUUID().toString());
        String S = com.baidu.crabsdk.c.d.S(d, c);
        try {
            c = com.baidu.crabsdk.c.e.dl(c);
        } catch (Exception e) {
            e.printStackTrace();
        }
        com.baidu.crabsdk.sender.h.ah();
        if (com.baidu.crabsdk.sender.h.sS()) {
            com.baidu.crabsdk.c.a.de("-BlockCanaryCore- switch on -  *^o^* doUploadBlock *^o^*");
            if (!com.baidu.crabsdk.sender.h.sW()) {
                com.baidu.crabsdk.c.a.de("CrashSwitch.canBlockUploadToday() == false");
                b.sv().stop();
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
            com.baidu.crabsdk.sender.k.a(bArr, c);
        }
    }

    private void reset() {
        this.ajz = 0L;
        this.au = 0;
    }

    @Override // android.view.Choreographer.FrameCallback
    public final void doFrame(long j) {
        ExecutorService executorService;
        try {
            if (this.ajz != 0) {
                long j2 = j - this.ajz;
                if (j2 > this.ajA) {
                    this.au = (int) ((j2 / this.ajB) + this.au);
                } else if (this.au > 0) {
                    if (this.au > 30) {
                        com.baidu.crabsdk.c.a.v("^^ block skip frames = " + this.au + "\n^^ costs : " + TimeUnit.NANOSECONDS.toMillis(this.au * this.ajB) + "ms");
                        if (TimeUnit.NANOSECONDS.toMillis(this.au * this.ajB) >= a.W) {
                            executorService = c.ajw;
                            executorService.execute(new f(this));
                        }
                        this.au = 1;
                    }
                    this.au--;
                }
            }
            this.ajz = j;
        } catch (Throwable th) {
            com.baidu.crabsdk.c.a.w("doFrame:" + th.toString());
        }
        try {
            Choreographer.getInstance().postFrameCallback(ajy);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public final void start() {
        if (this.aq) {
            return;
        }
        this.aq = true;
        reset();
        try {
            if (Looper.getMainLooper() == Looper.myLooper()) {
                try {
                    Choreographer.getInstance().postFrameCallback(ajy);
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
        this.aq = false;
        reset();
        if (Looper.getMainLooper() != Looper.myLooper()) {
            new Handler(Looper.getMainLooper()).post(new h(this));
            return;
        }
        try {
            Choreographer.getInstance().removeFrameCallback(ajy);
            com.baidu.crabsdk.c.a.de("stop FrameMonitor !!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
