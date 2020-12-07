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
    static final e aoL = new e();
    private boolean aq = false;
    private long aoM = 0;
    private long aoN = 41666666;
    private long aoO = 16666665;
    private int au = 0;

    private e() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void a(e eVar) {
        Context context;
        byte[] bArr = null;
        Map<String, Object> uT = a.uS().uT();
        if (uT == null) {
            com.baidu.crabsdk.c.a.w("no keyStack; blockRecord = null; not a block!!!");
            return;
        }
        com.baidu.crabsdk.c.a.v("^^ -BlockCanaryCore- ^^" + uT.toString());
        context = c.aoI;
        Map<String, Object> a2 = com.baidu.crabsdk.sender.g.a(context, (Throwable) null, true);
        a2.putAll(uT);
        com.baidu.crabsdk.sender.g.b(a2);
        String e = com.baidu.crabsdk.sender.i.e(a2);
        String c = com.baidu.crabsdk.c.d.c(com.baidu.crabsdk.a.d, UUID.randomUUID().toString());
        String W = com.baidu.crabsdk.c.d.W(e, c);
        try {
            c = com.baidu.crabsdk.c.e.dL(c);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        com.baidu.crabsdk.sender.h.vq();
        if (com.baidu.crabsdk.sender.h.vm()) {
            com.baidu.crabsdk.c.a.dE("-BlockCanaryCore- switch on -  *^o^* doUploadBlock *^o^*");
            if (!com.baidu.crabsdk.sender.h.ae()) {
                com.baidu.crabsdk.c.a.dE("CrashSwitch.canBlockUploadToday() == false");
                b.uU().stop();
                eVar.stop();
                return;
            }
            if (W != null) {
                try {
                    if (W.length() != 0) {
                        if (com.baidu.crabsdk.a.H) {
                            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                            DeflaterOutputStream deflaterOutputStream = new DeflaterOutputStream(byteArrayOutputStream, new Deflater(9, true));
                            deflaterOutputStream.write(W.getBytes("UTF-8"));
                            deflaterOutputStream.close();
                            bArr = byteArrayOutputStream.toByteArray();
                        } else {
                            bArr = W.getBytes("UTF-8");
                        }
                    }
                } catch (UnsupportedEncodingException e3) {
                    e3.printStackTrace();
                    return;
                } catch (IOException e4) {
                    e4.printStackTrace();
                    return;
                }
            }
            com.baidu.crabsdk.sender.k.a(bArr, c);
        }
    }

    private void reset() {
        this.aoM = 0L;
        this.au = 0;
    }

    @Override // android.view.Choreographer.FrameCallback
    public final void doFrame(long j) {
        ExecutorService executorService;
        try {
            if (this.aoM != 0) {
                long j2 = j - this.aoM;
                if (j2 > this.aoN) {
                    this.au = (int) ((j2 / this.aoO) + this.au);
                } else if (this.au > 0) {
                    if (this.au > 30) {
                        com.baidu.crabsdk.c.a.v("^^ block skip frames = " + this.au + "\n^^ costs : " + TimeUnit.NANOSECONDS.toMillis(this.au * this.aoO) + "ms");
                        if (TimeUnit.NANOSECONDS.toMillis(this.au * this.aoO) >= a.W) {
                            executorService = c.aoJ;
                            executorService.execute(new f(this));
                        }
                        this.au = 1;
                    }
                    this.au--;
                }
            }
            this.aoM = j;
        } catch (Throwable th) {
            com.baidu.crabsdk.c.a.w("doFrame:" + th.toString());
        }
        try {
            Choreographer.getInstance().postFrameCallback(aoL);
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
                    Choreographer.getInstance().postFrameCallback(aoL);
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
            Choreographer.getInstance().removeFrameCallback(aoL);
            com.baidu.crabsdk.c.a.dE("stop FrameMonitor !!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
