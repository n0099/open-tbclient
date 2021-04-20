package com.baidu.sofire;

import android.content.Context;
import android.os.FileObserver;
import java.io.File;
/* loaded from: classes2.dex */
public class d extends FileObserver {

    /* renamed from: a  reason: collision with root package name */
    public String f11374a;

    /* renamed from: b  reason: collision with root package name */
    public String f11375b;

    /* renamed from: c  reason: collision with root package name */
    public int f11376c;

    /* renamed from: d  reason: collision with root package name */
    public Context f11377d;

    public d(Context context, int i, String str, String str2) {
        super(str, 4095);
        try {
            this.f11374a = str;
            this.f11375b = str2;
            this.f11376c = i;
            this.f11377d = context;
            StringBuilder sb = new StringBuilder("f=");
            sb.append(this.f11374a);
            sb.append(", e=");
            sb.append(new File(this.f11374a).exists());
            sb.append(", b=");
            sb.append(this.f11375b);
            b.a();
        } catch (Throwable unused) {
            com.baidu.sofire.g.d.a();
        }
    }

    @Override // android.os.FileObserver
    public void onEvent(int i, String str) {
        if (i == 2 || i == 4 || i == 64 || i == 128 || i == 512 || i == 1024 || i == 2048) {
            try {
                new Thread() { // from class: com.baidu.sofire.d.1
                    @Override // java.lang.Thread, java.lang.Runnable
                    public final void run() {
                        try {
                            super.run();
                            b.a();
                            synchronized (d.class) {
                                if (!com.baidu.sofire.g.d.c(d.this.f11374a)) {
                                    b.a();
                                    com.baidu.sofire.g.d.a(d.this.f11375b, d.this.f11374a);
                                    com.baidu.sofire.g.d.a(d.this.f11374a, true);
                                    c.a(new File(d.this.f11374a));
                                    c.a(d.this.f11377d, d.this.f11376c, new File(d.this.f11374a), new File(d.this.f11375b));
                                    new StringBuilder().append(d.this.f11374a.toString());
                                    b.a();
                                    com.baidu.sofire.a.a.a(d.this.f11377d).b(d.this.f11376c, -1);
                                }
                            }
                        } catch (Throwable unused) {
                            com.baidu.sofire.g.d.a();
                        }
                    }
                }.start();
            } catch (Throwable unused) {
                com.baidu.sofire.g.d.a();
            }
        }
    }

    public final boolean a() {
        try {
            File file = new File(this.f11375b);
            if (file.exists()) {
                return file.delete();
            }
            return false;
        } catch (Throwable unused) {
            com.baidu.sofire.g.d.a();
            return false;
        }
    }
}
