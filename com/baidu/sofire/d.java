package com.baidu.sofire;

import android.content.Context;
import android.os.FileObserver;
import java.io.File;
/* loaded from: classes2.dex */
public class d extends FileObserver {

    /* renamed from: a  reason: collision with root package name */
    public String f11204a;

    /* renamed from: b  reason: collision with root package name */
    public String f11205b;

    /* renamed from: c  reason: collision with root package name */
    public int f11206c;

    /* renamed from: d  reason: collision with root package name */
    public Context f11207d;

    public d(Context context, int i2, String str, String str2) {
        super(str, 4095);
        try {
            this.f11204a = str;
            this.f11205b = str2;
            this.f11206c = i2;
            this.f11207d = context;
            StringBuilder sb = new StringBuilder("f=");
            sb.append(this.f11204a);
            sb.append(", e=");
            sb.append(new File(this.f11204a).exists());
            sb.append(", b=");
            sb.append(this.f11205b);
            b.a();
        } catch (Throwable unused) {
            com.baidu.sofire.g.d.a();
        }
    }

    @Override // android.os.FileObserver
    public void onEvent(int i2, String str) {
        if (i2 == 2 || i2 == 4 || i2 == 64 || i2 == 128 || i2 == 512 || i2 == 1024 || i2 == 2048) {
            try {
                new Thread() { // from class: com.baidu.sofire.d.1
                    @Override // java.lang.Thread, java.lang.Runnable
                    public final void run() {
                        try {
                            super.run();
                            b.a();
                            synchronized (d.class) {
                                if (!com.baidu.sofire.g.d.c(d.this.f11204a)) {
                                    b.a();
                                    com.baidu.sofire.g.d.a(d.this.f11205b, d.this.f11204a);
                                    com.baidu.sofire.g.d.a(d.this.f11204a, true);
                                    c.a(new File(d.this.f11204a));
                                    c.a(d.this.f11207d, d.this.f11206c, new File(d.this.f11204a), new File(d.this.f11205b));
                                    new StringBuilder().append(d.this.f11204a.toString());
                                    b.a();
                                    com.baidu.sofire.a.a.a(d.this.f11207d).b(d.this.f11206c, -1);
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
            File file = new File(this.f11205b);
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
