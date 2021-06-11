package com.baidu.sofire;

import android.content.Context;
import android.os.FileObserver;
import java.io.File;
/* loaded from: classes2.dex */
public class d extends FileObserver {

    /* renamed from: a  reason: collision with root package name */
    public String f10234a;

    /* renamed from: b  reason: collision with root package name */
    public String f10235b;

    /* renamed from: c  reason: collision with root package name */
    public int f10236c;

    /* renamed from: d  reason: collision with root package name */
    public Context f10237d;

    public d(Context context, int i2, String str, String str2) {
        super(str, 4095);
        try {
            this.f10234a = str;
            this.f10235b = str2;
            this.f10236c = i2;
            this.f10237d = context;
            StringBuilder sb = new StringBuilder("f=");
            sb.append(this.f10234a);
            sb.append(", e=");
            sb.append(new File(this.f10234a).exists());
            sb.append(", b=");
            sb.append(this.f10235b);
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
                                if (!com.baidu.sofire.g.d.c(d.this.f10234a)) {
                                    b.a();
                                    com.baidu.sofire.g.d.a(d.this.f10235b, d.this.f10234a);
                                    com.baidu.sofire.g.d.a(d.this.f10234a, true);
                                    c.a(new File(d.this.f10234a));
                                    c.a(d.this.f10237d, d.this.f10236c, new File(d.this.f10234a), new File(d.this.f10235b));
                                    new StringBuilder().append(d.this.f10234a.toString());
                                    b.a();
                                    com.baidu.sofire.a.a.a(d.this.f10237d).b(d.this.f10236c, -1);
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
            File file = new File(this.f10235b);
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
