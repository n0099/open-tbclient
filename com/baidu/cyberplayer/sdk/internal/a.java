package com.baidu.cyberplayer.sdk.internal;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Handler;
import android.os.HandlerThread;
import com.baidu.cyberplayer.sdk.BEngineManager;
import java.io.File;
import java.io.IOException;
/* loaded from: classes.dex */
abstract class a {

    /* renamed from: a  reason: collision with root package name */
    private int f879a = 7;

    /* renamed from: a  reason: collision with other field name */
    private Context f20a;

    /* renamed from: a  reason: collision with other field name */
    private BEngineManager.OnEngineListener f21a;

    /* renamed from: a  reason: collision with other field name */
    private CyberPlayerEngineManager f22a;

    /* renamed from: a  reason: collision with other field name */
    private boolean f23a;
    private Context b;

    protected abstract String a();

    /* renamed from: a  reason: collision with other method in class */
    protected abstract boolean m7a();

    protected abstract void b();

    /* renamed from: b  reason: collision with other method in class */
    protected abstract boolean m8b();

    public a(Context context, CyberPlayerEngineManager cyberPlayerEngineManager, BEngineManager.OnEngineListener onEngineListener, boolean z) {
        this.f23a = false;
        if (context != null) {
            this.b = context;
            this.f20a = context.getApplicationContext();
        }
        this.f22a = cyberPlayerEngineManager;
        this.f21a = onEngineListener;
        this.f23a = z;
    }

    /* renamed from: a  reason: collision with other method in class */
    public final void m6a() {
        if (this.f22a == null || this.f20a == null) {
            if (this.f21a != null) {
                b();
                this.f21a.onInstalled(7);
                return;
            }
            return;
        }
        final HandlerThread handlerThread = new HandlerThread("download");
        handlerThread.start();
        new Handler(handlerThread.getLooper()).post(new Runnable() { // from class: com.baidu.cyberplayer.sdk.internal.a.1
            @Override // java.lang.Runnable
            public void run() {
                if (a.this.f21a != null && !a.this.f21a.onPrepare()) {
                    a.this.f879a = 3;
                } else if (a.this.m7a() && a.this.m8b() && a.this.c()) {
                    a.this.f879a = 0;
                }
                if (a.this.f21a != null) {
                    if (a.this.f879a == 5 || a.this.f879a == 7 || a.this.f879a == 4 || a.this.f879a == 0 || a.this.f879a == 9) {
                        a.this.b();
                    }
                    a.this.f21a.onInstalled(a.this.f879a);
                }
                a.this.f22a.onInstallCompleted();
                handlerThread.quit();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void a(int i) {
        this.f879a = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean c() {
        if (this.f21a != null) {
            int onPreInstall = this.f21a.onPreInstall();
            if (onPreInstall == 1) {
                this.f879a = 2;
                return false;
            } else if (onPreInstall == 2) {
                this.f879a = 3;
                b();
                return false;
            }
        }
        String a2 = a();
        if (a2 != null) {
            return a(this.f20a, a2);
        }
        return false;
    }

    private boolean a(Context context, String str) {
        try {
            Runtime.getRuntime().exec("chmod 666 " + str);
        } catch (IOException e) {
            e.printStackTrace();
        }
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.setDataAndType(Uri.fromFile(new File(str)), "application/vnd.android.package-archive");
        intent.addFlags(268435456);
        this.b.startActivity(intent);
        Object obj = new Object();
        int i = 200;
        while (true) {
            int i2 = i - 1;
            if (i <= 0) {
                break;
            } else if (d.m16a(context)) {
                return true;
            } else {
                synchronized (obj) {
                    try {
                        obj.wait(100L);
                    } catch (InterruptedException e2) {
                        e2.printStackTrace();
                        return false;
                    }
                }
                i = i2;
            }
        }
    }
}
