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
/* loaded from: classes12.dex */
public final class e implements Choreographer.FrameCallback {
    static final e alA = new e();
    private boolean aq = false;
    private long alB = 0;
    private long alC = 41666666;
    private long alD = 16666665;
    private int au = 0;

    private e() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void a(e eVar) {
        Context context;
        byte[] bArr = null;
        Map<String, Object> ta = a.sZ().ta();
        if (ta == null) {
            com.baidu.crabsdk.c.a.w("no keyStack; blockRecord = null; not a block!!!");
            return;
        }
        com.baidu.crabsdk.c.a.v("^^ -BlockCanaryCore- ^^" + ta.toString());
        context = c.alx;
        Map<String, Object> a = com.baidu.crabsdk.sender.g.a(context, (Throwable) null, true);
        a.putAll(ta);
        com.baidu.crabsdk.sender.g.b(a);
        String e = com.baidu.crabsdk.sender.i.e(a);
        String c = com.baidu.crabsdk.c.d.c(com.baidu.crabsdk.a.d, UUID.randomUUID().toString());
        String R = com.baidu.crabsdk.c.d.R(e, c);
        try {
            c = com.baidu.crabsdk.c.e.m19do(c);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        com.baidu.crabsdk.sender.h.ah();
        if (com.baidu.crabsdk.sender.h.tv()) {
            com.baidu.crabsdk.c.a.dh("-BlockCanaryCore- switch on -  *^o^* doUploadBlock *^o^*");
            if (!com.baidu.crabsdk.sender.h.tx()) {
                com.baidu.crabsdk.c.a.dh("CrashSwitch.canBlockUploadToday() == false");
                b.tb().stop();
                eVar.stop();
                return;
            }
            if (R != null) {
                try {
                    if (R.length() != 0) {
                        if (com.baidu.crabsdk.a.H) {
                            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                            DeflaterOutputStream deflaterOutputStream = new DeflaterOutputStream(byteArrayOutputStream, new Deflater(9, true));
                            deflaterOutputStream.write(R.getBytes("UTF-8"));
                            deflaterOutputStream.close();
                            bArr = byteArrayOutputStream.toByteArray();
                        } else {
                            bArr = R.getBytes("UTF-8");
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
        this.alB = 0L;
        this.au = 0;
    }

    @Override // android.view.Choreographer.FrameCallback
    public final void doFrame(long j) {
        ExecutorService executorService;
        try {
            if (this.alB != 0) {
                long j2 = j - this.alB;
                if (j2 > this.alC) {
                    this.au = (int) ((j2 / this.alD) + this.au);
                } else if (this.au > 0) {
                    if (this.au > 30) {
                        com.baidu.crabsdk.c.a.v("^^ block skip frames = " + this.au + "\n^^ costs : " + TimeUnit.NANOSECONDS.toMillis(this.au * this.alD) + "ms");
                        if (TimeUnit.NANOSECONDS.toMillis(this.au * this.alD) >= a.W) {
                            executorService = c.aly;
                            executorService.execute(new f(this));
                        }
                        this.au = 1;
                    }
                    this.au--;
                }
            }
            this.alB = j;
        } catch (Throwable th) {
            com.baidu.crabsdk.c.a.w("doFrame:" + th.toString());
        }
        try {
            Choreographer.getInstance().postFrameCallback(alA);
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
                    Choreographer.getInstance().postFrameCallback(alA);
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
            Choreographer.getInstance().removeFrameCallback(alA);
            com.baidu.crabsdk.c.a.dh("stop FrameMonitor !!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
