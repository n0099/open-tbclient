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
    static final e YU = new e();
    private boolean ao = false;
    private long YV = 0;
    private long YW = 41666666;
    private long YX = 16666665;
    private int as = 0;

    private e() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void a(e eVar) {
        Context context;
        byte[] bArr = null;
        Map<String, Object> g = a.qE().g();
        if (g == null) {
            com.baidu.crabsdk.c.a.w("no keyStack; blockRecord = null; not a block!!!");
            return;
        }
        com.baidu.crabsdk.c.a.v("^^ -BlockCanaryCore- ^^" + g.toString());
        context = c.YR;
        Map<String, Object> a = com.baidu.crabsdk.sender.g.a(context, (Throwable) null, true);
        a.putAll(g);
        com.baidu.crabsdk.sender.g.b(a);
        String i = com.baidu.crabsdk.sender.i.i(a);
        String c = com.baidu.crabsdk.c.d.c(com.baidu.crabsdk.a.d, UUID.randomUUID().toString());
        String M = com.baidu.crabsdk.c.d.M(i, c);
        try {
            c = com.baidu.crabsdk.c.e.cn(c);
        } catch (Exception e) {
            e.printStackTrace();
        }
        com.baidu.crabsdk.sender.h.ac();
        if (com.baidu.crabsdk.sender.h.qX()) {
            com.baidu.crabsdk.c.a.cf("-BlockCanaryCore- switch on -  *^o^* doUploadBlock *^o^*");
            if (!com.baidu.crabsdk.sender.h.ra()) {
                com.baidu.crabsdk.c.a.cf("CrashSwitch.canBlockUploadToday() == false");
                b.qF().stop();
                eVar.stop();
                return;
            }
            if (M != null) {
                try {
                    if (M.length() != 0) {
                        if (com.baidu.crabsdk.a.H) {
                            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                            DeflaterOutputStream deflaterOutputStream = new DeflaterOutputStream(byteArrayOutputStream, new Deflater(9, true));
                            deflaterOutputStream.write(M.getBytes(HTTP.UTF_8));
                            deflaterOutputStream.close();
                            bArr = byteArrayOutputStream.toByteArray();
                        } else {
                            bArr = M.getBytes(HTTP.UTF_8);
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
        this.YV = 0L;
        this.as = 0;
    }

    @Override // android.view.Choreographer.FrameCallback
    public final void doFrame(long j) {
        ExecutorService executorService;
        try {
            if (this.YV != 0) {
                long j2 = j - this.YV;
                if (j2 > this.YW) {
                    this.as = (int) ((j2 / this.YX) + this.as);
                } else if (this.as > 0) {
                    if (this.as > 30) {
                        com.baidu.crabsdk.c.a.v("^^ block skip frames = " + this.as + "\n^^ costs : " + TimeUnit.NANOSECONDS.toMillis(this.as * this.YX) + "ms");
                        if (TimeUnit.NANOSECONDS.toMillis(this.as * this.YX) >= a.U) {
                            executorService = c.YS;
                            executorService.execute(new f(this));
                        }
                        this.as = 1;
                    }
                    this.as--;
                }
            }
            this.YV = j;
        } catch (Throwable th) {
            com.baidu.crabsdk.c.a.w("doFrame:" + th.toString());
        }
        try {
            Choreographer.getInstance().postFrameCallback(YU);
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
                    Choreographer.getInstance().postFrameCallback(YU);
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
        this.ao = false;
        reset();
        if (Looper.getMainLooper() != Looper.myLooper()) {
            new Handler(Looper.getMainLooper()).post(new h(this));
            return;
        }
        try {
            Choreographer.getInstance().removeFrameCallback(YU);
            com.baidu.crabsdk.c.a.cf("stop FrameMonitor !!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
