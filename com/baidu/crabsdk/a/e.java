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
import org.apache.http.protocol.HTTP;
/* JADX INFO: Access modifiers changed from: package-private */
@TargetApi(16)
/* loaded from: classes3.dex */
public final class e implements Choreographer.FrameCallback {
    static final e aaZ = new e();
    private boolean ao = false;
    private long aba = 0;
    private long abb = 41666666;
    private long abd = 16666665;
    private int as = 0;

    private e() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void a(e eVar) {
        Context context;
        byte[] bArr = null;
        Map<String, Object> g = a.rJ().g();
        if (g == null) {
            com.baidu.crabsdk.c.a.cy("no keyStack; blockRecord = null; not a block!!!");
            return;
        }
        com.baidu.crabsdk.c.a.cx("^^ -BlockCanaryCore- ^^" + g.toString());
        context = c.aaW;
        Map<String, Object> a = com.baidu.crabsdk.sender.d.a(context, (Throwable) null, true);
        a.putAll(g);
        com.baidu.crabsdk.sender.d.b(a);
        String j = com.baidu.crabsdk.sender.f.j(a);
        String c = com.baidu.crabsdk.c.d.c(com.baidu.crabsdk.a.d, UUID.randomUUID().toString());
        String S = com.baidu.crabsdk.c.d.S(j, c);
        try {
            c = com.baidu.crabsdk.c.e.cD(c);
        } catch (Exception e) {
            e.printStackTrace();
        }
        com.baidu.crabsdk.sender.e.sg();
        if (com.baidu.crabsdk.sender.e.sc()) {
            com.baidu.crabsdk.c.a.cv("-BlockCanaryCore- switch on -  *^o^* doUploadBlock *^o^*");
            if (!com.baidu.crabsdk.sender.e.sf()) {
                com.baidu.crabsdk.c.a.cv("CrashSwitch.canBlockUploadToday() == false");
                b.rK().stop();
                eVar.stop();
                return;
            }
            if (S != null) {
                try {
                    if (S.length() != 0) {
                        if (com.baidu.crabsdk.a.H) {
                            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                            DeflaterOutputStream deflaterOutputStream = new DeflaterOutputStream(byteArrayOutputStream, new Deflater(9, true));
                            deflaterOutputStream.write(S.getBytes(HTTP.UTF_8));
                            deflaterOutputStream.close();
                            bArr = byteArrayOutputStream.toByteArray();
                        } else {
                            bArr = S.getBytes(HTTP.UTF_8);
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
        this.aba = 0L;
        this.as = 0;
    }

    @Override // android.view.Choreographer.FrameCallback
    public final void doFrame(long j) {
        ExecutorService executorService;
        try {
            if (this.aba != 0) {
                long j2 = j - this.aba;
                if (j2 > this.abb) {
                    this.as = (int) ((j2 / this.abd) + this.as);
                } else if (this.as > 0) {
                    if (this.as > 30) {
                        com.baidu.crabsdk.c.a.cx("^^ block skip frames = " + this.as + "\n^^ costs : " + TimeUnit.NANOSECONDS.toMillis(this.as * this.abd) + "ms");
                        if (TimeUnit.NANOSECONDS.toMillis(this.as * this.abd) >= a.U) {
                            executorService = c.aaX;
                            executorService.execute(new f(this));
                        }
                        this.as = 1;
                    }
                    this.as--;
                }
            }
            this.aba = j;
        } catch (Throwable th) {
            com.baidu.crabsdk.c.a.cy("doFrame:" + th.toString());
        }
        try {
            Choreographer.getInstance().postFrameCallback(aaZ);
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
                    Choreographer.getInstance().postFrameCallback(aaZ);
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
            Choreographer.getInstance().removeFrameCallback(aaZ);
            com.baidu.crabsdk.c.a.cv("stop FrameMonitor !!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
