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
/* loaded from: classes5.dex */
public final class e implements Choreographer.FrameCallback {
    static final e apO = new e();
    private boolean aq = false;
    private long ar = 0;
    private long apP = 41666666;
    private long apQ = 16666665;
    private int au = 0;

    private e() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void a(e eVar) {
        Context context;
        byte[] bArr = null;
        Map<String, Object> h = a.uh().h();
        if (h == null) {
            com.baidu.crabsdk.c.a.w("no keyStack; blockRecord = null; not a block!!!");
            return;
        }
        com.baidu.crabsdk.c.a.v("^^ -BlockCanaryCore- ^^" + h.toString());
        context = c.apL;
        Map<String, Object> a2 = com.baidu.crabsdk.sender.g.a(context, (Throwable) null, true);
        a2.putAll(h);
        com.baidu.crabsdk.sender.g.b(a2);
        String e = com.baidu.crabsdk.sender.i.e(a2);
        String c = com.baidu.crabsdk.c.d.c(com.baidu.crabsdk.a.d, UUID.randomUUID().toString());
        String e2 = com.baidu.crabsdk.c.d.e(e, c);
        try {
            c = com.baidu.crabsdk.c.e.dD(c);
        } catch (Exception e3) {
            e3.printStackTrace();
        }
        com.baidu.crabsdk.sender.h.ah();
        if (com.baidu.crabsdk.sender.h.uy()) {
            com.baidu.crabsdk.c.a.dw("-BlockCanaryCore- switch on -  *^o^* doUploadBlock *^o^*");
            if (!com.baidu.crabsdk.sender.h.ae()) {
                com.baidu.crabsdk.c.a.dw("CrashSwitch.canBlockUploadToday() == false");
                b.ui().stop();
                eVar.stop();
                return;
            }
            if (e2 != null) {
                try {
                    if (e2.length() != 0) {
                        if (com.baidu.crabsdk.a.H) {
                            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                            DeflaterOutputStream deflaterOutputStream = new DeflaterOutputStream(byteArrayOutputStream, new Deflater(9, true));
                            deflaterOutputStream.write(e2.getBytes("UTF-8"));
                            deflaterOutputStream.close();
                            bArr = byteArrayOutputStream.toByteArray();
                        } else {
                            bArr = e2.getBytes("UTF-8");
                        }
                    }
                } catch (UnsupportedEncodingException e4) {
                    e4.printStackTrace();
                    return;
                } catch (IOException e5) {
                    e5.printStackTrace();
                    return;
                }
            }
            com.baidu.crabsdk.sender.k.a(bArr, c);
        }
    }

    private void reset() {
        this.ar = 0L;
        this.au = 0;
    }

    @Override // android.view.Choreographer.FrameCallback
    public final void doFrame(long j) {
        ExecutorService executorService;
        try {
            if (this.ar != 0) {
                long j2 = j - this.ar;
                if (j2 > this.apP) {
                    this.au = (int) ((j2 / this.apQ) + this.au);
                } else if (this.au > 0) {
                    if (this.au > 30) {
                        com.baidu.crabsdk.c.a.v("^^ block skip frames = " + this.au + "\n^^ costs : " + TimeUnit.NANOSECONDS.toMillis(this.au * this.apQ) + "ms");
                        if (TimeUnit.NANOSECONDS.toMillis(this.au * this.apQ) >= a.W) {
                            executorService = c.apM;
                            executorService.execute(new f(this));
                        }
                        this.au = 1;
                    }
                    this.au--;
                }
            }
            this.ar = j;
        } catch (Throwable th) {
            com.baidu.crabsdk.c.a.w("doFrame:" + th.toString());
        }
        try {
            Choreographer.getInstance().postFrameCallback(apO);
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
                    Choreographer.getInstance().postFrameCallback(apO);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } else {
                new Handler(Looper.getMainLooper()).post(new g(this));
            }
        } catch (Exception e2) {
            com.baidu.crabsdk.c.a.a("postFrameCallback error!!", e2);
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
            Choreographer.getInstance().removeFrameCallback(apO);
            com.baidu.crabsdk.c.a.dw("stop FrameMonitor !!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
