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
    static final e RY = new e();
    private boolean an = false;
    private long RZ = 0;
    private long Sa = 41666666;
    private long Sb = 16666665;
    private int ar = 0;

    private e() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void a(e eVar) {
        Context context;
        byte[] bArr = null;
        Map<String, Object> g = a.oS().g();
        if (g == null) {
            com.baidu.crabsdk.c.a.ce("no keyStack; blockRecord = null; not a block!!!");
            return;
        }
        com.baidu.crabsdk.c.a.cd("^^ -BlockCanaryCore- ^^" + g.toString());
        context = c.RV;
        Map<String, Object> a = com.baidu.crabsdk.sender.d.a(context, (Throwable) null, true);
        a.putAll(g);
        com.baidu.crabsdk.sender.d.b(a);
        String j = com.baidu.crabsdk.sender.f.j(a);
        String c = com.baidu.crabsdk.c.d.c(com.baidu.crabsdk.a.d, UUID.randomUUID().toString());
        String M = com.baidu.crabsdk.c.d.M(j, c);
        try {
            c = com.baidu.crabsdk.c.e.ck(c);
        } catch (Exception e) {
            e.printStackTrace();
        }
        com.baidu.crabsdk.sender.e.ac();
        if (com.baidu.crabsdk.sender.e.pm()) {
            com.baidu.crabsdk.c.a.cb("-BlockCanaryCore- switch on -  *^o^* doUploadBlock *^o^*");
            if (!com.baidu.crabsdk.sender.e.pp()) {
                com.baidu.crabsdk.c.a.cb("CrashSwitch.canBlockUploadToday() == false");
                b.oT().stop();
                eVar.stop();
                return;
            }
            if (M != null) {
                try {
                    if (M.length() != 0) {
                        if (com.baidu.crabsdk.a.H) {
                            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                            DeflaterOutputStream deflaterOutputStream = new DeflaterOutputStream(byteArrayOutputStream, new Deflater(9, true));
                            deflaterOutputStream.write(M.getBytes("UTF-8"));
                            deflaterOutputStream.close();
                            bArr = byteArrayOutputStream.toByteArray();
                        } else {
                            bArr = M.getBytes("UTF-8");
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
        this.RZ = 0L;
        this.ar = 0;
    }

    @Override // android.view.Choreographer.FrameCallback
    public final void doFrame(long j) {
        ExecutorService executorService;
        try {
            if (this.RZ != 0) {
                long j2 = j - this.RZ;
                if (j2 > this.Sa) {
                    this.ar = (int) ((j2 / this.Sb) + this.ar);
                } else if (this.ar > 0) {
                    if (this.ar > 30) {
                        com.baidu.crabsdk.c.a.cd("^^ block skip frames = " + this.ar + "\n^^ costs : " + TimeUnit.NANOSECONDS.toMillis(this.ar * this.Sb) + "ms");
                        if (TimeUnit.NANOSECONDS.toMillis(this.ar * this.Sb) >= a.T) {
                            executorService = c.RW;
                            executorService.execute(new f(this));
                        }
                        this.ar = 1;
                    }
                    this.ar--;
                }
            }
            this.RZ = j;
        } catch (Throwable th) {
            com.baidu.crabsdk.c.a.ce("doFrame:" + th.toString());
        }
        Choreographer.getInstance().postFrameCallback(RY);
    }

    public final void start() {
        if (this.an) {
            return;
        }
        this.an = true;
        reset();
        try {
            if (Looper.getMainLooper() == Looper.myLooper()) {
                Choreographer.getInstance().postFrameCallback(RY);
            } else {
                new Handler(Looper.getMainLooper()).post(new g(this));
            }
        } catch (Exception e) {
            com.baidu.crabsdk.c.a.b("postFrameCallback error!!", e);
        }
    }

    public final void stop() {
        this.an = false;
        reset();
        if (Looper.getMainLooper() != Looper.myLooper()) {
            new Handler(Looper.getMainLooper()).post(new h(this));
            return;
        }
        Choreographer.getInstance().removeFrameCallback(RY);
        com.baidu.crabsdk.c.a.cb("stop FrameMonitor !!");
    }
}
