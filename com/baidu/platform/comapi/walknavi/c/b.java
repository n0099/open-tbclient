package com.baidu.platform.comapi.walknavi.c;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import com.baidu.platform.comjni.bikenavi.JNIEngineManager;
import com.baidu.platform.comjni.jninative.EngineCommonConfig;
/* loaded from: classes2.dex */
public class b extends com.baidu.platform.comapi.walknavi.a {

    /* renamed from: a  reason: collision with root package name */
    public JNIEngineManager f9909a = null;

    /* renamed from: b  reason: collision with root package name */
    public long f9910b = 0;

    /* renamed from: c  reason: collision with root package name */
    public long f9911c = 0;

    /* renamed from: d  reason: collision with root package name */
    public long f9912d = 0;

    /* renamed from: e  reason: collision with root package name */
    public com.baidu.platform.comapi.walknavi.c.a f9913e = null;

    /* renamed from: f  reason: collision with root package name */
    public int f9914f = 0;

    /* renamed from: g  reason: collision with root package name */
    public Handler f9915g = new c(this);

    /* loaded from: classes2.dex */
    public class a extends Thread {

        /* renamed from: b  reason: collision with root package name */
        public EngineCommonConfig f9917b;

        /* renamed from: c  reason: collision with root package name */
        public long f9918c;

        public a(long j, EngineCommonConfig engineCommonConfig) {
            this.f9918c = j;
            this.f9917b = engineCommonConfig;
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            long[] jArr = {0};
            int initBaseManager = b.this.f9909a.initBaseManager(this.f9917b, this.f9918c, jArr);
            Log.d("ret====", "ret：" + initBaseManager);
            if (initBaseManager != 0) {
                Message.obtain(b.this.f9915g, 1).sendToTarget();
                return;
            }
            b.this.f9910b = jArr[0];
            Message.obtain(b.this.f9915g, 16).sendToTarget();
        }
    }

    /* renamed from: com.baidu.platform.comapi.walknavi.c.b$b  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class C0120b extends Thread {

        /* renamed from: b  reason: collision with root package name */
        public Context f9920b;

        public C0120b(Context context) {
            this.f9920b = context;
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            if (com.baidu.platform.comapi.wnplatform.o.a.a.a(this.f9920b)) {
                Message.obtain(b.this.f9915g, 32).sendToTarget();
                return;
            }
            com.baidu.platform.comapi.wnplatform.d.a.a("InitResourceThread  error");
            Log.d("InitResourceThread", "InitResourceThread  error");
            Message.obtain(b.this.f9915g, 1).sendToTarget();
        }
    }

    @Override // com.baidu.platform.comapi.walknavi.a
    public boolean ready() {
        return true;
    }

    @Override // com.baidu.platform.comapi.walknavi.a
    public synchronized void release() {
        d();
        this.f9909a = null;
        this.f9911c = 0L;
        this.f9912d = 0L;
        this.f9914f = 0;
        this.f9910b = 0L;
        this.f9913e = null;
    }

    private synchronized void d() {
        if (this.f9909a != null) {
            this.f9909a.uninitBaseManager(this.f9910b);
            this.f9911c = 0L;
        }
    }

    public long b() {
        if (this.f9911c == 0) {
            this.f9911c = a(0);
        }
        return this.f9911c;
    }

    public long c() {
        if (this.f9912d == 0) {
            this.f9912d = a(1);
        }
        return this.f9912d;
    }

    public int a() {
        return this.f9914f;
    }

    public void a(Context context, long j, com.baidu.platform.comapi.walknavi.c.a aVar) {
        this.f9913e = aVar;
        if (this.f9914f == 48) {
            if (aVar != null) {
                aVar.a();
                return;
            }
            return;
        }
        EngineCommonConfig engineCommonConfig = new EngineCommonConfig();
        int min = Math.min(com.baidu.platform.comapi.wnplatform.o.b.b.a().b(), 800);
        engineCommonConfig.mStreetPicWidth = min;
        engineCommonConfig.mStreetPicHeight = (min * 3) / 5;
        engineCommonConfig.mStreetPicQuality = 80;
        engineCommonConfig.mNoExistSensor = !com.baidu.platform.comapi.walknavi.b.a().e();
        this.f9909a = new JNIEngineManager();
        new a(j, engineCommonConfig).start();
        new C0120b(context).start();
    }

    private long a(int i) {
        JNIEngineManager jNIEngineManager = this.f9909a;
        if (jNIEngineManager != null) {
            long j = this.f9910b;
            if (j != 0) {
                long[] jArr = {0};
                try {
                    jNIEngineManager.getSubSysHandle(j, i, jArr);
                } catch (Exception e2) {
                    com.baidu.platform.comapi.wnplatform.d.a.b(e2.getMessage());
                }
                return jArr[0];
            }
        }
        return 0L;
    }
}
