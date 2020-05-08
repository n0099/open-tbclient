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
    static final e ajE = new e();
    private boolean aq = false;
    private long ajF = 0;
    private long ajG = 41666666;
    private long ajH = 16666665;
    private int au = 0;

    private e() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void a(e eVar) {
        Context context;
        byte[] bArr = null;
        Map<String, Object> st = a.ss().st();
        if (st == null) {
            com.baidu.crabsdk.c.a.w("no keyStack; blockRecord = null; not a block!!!");
            return;
        }
        com.baidu.crabsdk.c.a.v("^^ -BlockCanaryCore- ^^" + st.toString());
        context = c.ajB;
        Map<String, Object> a = com.baidu.crabsdk.sender.g.a(context, (Throwable) null, true);
        a.putAll(st);
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
        if (com.baidu.crabsdk.sender.h.sR()) {
            com.baidu.crabsdk.c.a.de("-BlockCanaryCore- switch on -  *^o^* doUploadBlock *^o^*");
            if (!com.baidu.crabsdk.sender.h.sV()) {
                com.baidu.crabsdk.c.a.de("CrashSwitch.canBlockUploadToday() == false");
                b.su().stop();
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
        this.ajF = 0L;
        this.au = 0;
    }

    @Override // android.view.Choreographer.FrameCallback
    public final void doFrame(long j) {
        ExecutorService executorService;
        try {
            if (this.ajF != 0) {
                long j2 = j - this.ajF;
                if (j2 > this.ajG) {
                    this.au = (int) ((j2 / this.ajH) + this.au);
                } else if (this.au > 0) {
                    if (this.au > 30) {
                        com.baidu.crabsdk.c.a.v("^^ block skip frames = " + this.au + "\n^^ costs : " + TimeUnit.NANOSECONDS.toMillis(this.au * this.ajH) + "ms");
                        if (TimeUnit.NANOSECONDS.toMillis(this.au * this.ajH) >= a.W) {
                            executorService = c.ajC;
                            executorService.execute(new f(this));
                        }
                        this.au = 1;
                    }
                    this.au--;
                }
            }
            this.ajF = j;
        } catch (Throwable th) {
            com.baidu.crabsdk.c.a.w("doFrame:" + th.toString());
        }
        try {
            Choreographer.getInstance().postFrameCallback(ajE);
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
                    Choreographer.getInstance().postFrameCallback(ajE);
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
            Choreographer.getInstance().removeFrameCallback(ajE);
            com.baidu.crabsdk.c.a.de("stop FrameMonitor !!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
