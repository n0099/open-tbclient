package com.baidu.sofire;

import android.content.Context;
import android.os.FileObserver;
import com.baidu.sofire.utility.x;
import java.io.File;
/* loaded from: classes2.dex */
public class d extends FileObserver {

    /* renamed from: a  reason: collision with root package name */
    public String f10289a;

    /* renamed from: b  reason: collision with root package name */
    public String f10290b;

    /* renamed from: c  reason: collision with root package name */
    public int f10291c;

    /* renamed from: d  reason: collision with root package name */
    public Context f10292d;

    public d(Context context, int i2, String str, String str2) {
        super(str, 4095);
        try {
            this.f10289a = str;
            this.f10290b = str2;
            this.f10291c = i2;
            this.f10292d = context;
        } catch (Throwable unused) {
            com.baidu.sofire.utility.c.a();
        }
    }

    @Override // android.os.FileObserver
    public void onEvent(int i2, String str) {
        if (i2 == 2 || i2 == 4 || i2 == 64 || i2 == 128 || i2 == 512 || i2 == 1024 || i2 == 2048) {
            try {
                x.a(this.f10292d).a(new Runnable() { // from class: com.baidu.sofire.d.1
                    @Override // java.lang.Runnable
                    public final void run() {
                        try {
                            synchronized (d.class) {
                                if (!com.baidu.sofire.utility.c.c(d.this.f10289a)) {
                                    com.baidu.sofire.utility.c.a(d.this.f10290b, d.this.f10289a);
                                    com.baidu.sofire.utility.c.a(d.this.f10289a, true);
                                    c.a(new File(d.this.f10289a));
                                    c.a(d.this.f10292d, d.this.f10291c, new File(d.this.f10289a), new File(d.this.f10290b));
                                    com.baidu.sofire.a.a.a(d.this.f10292d).b(d.this.f10291c, -1);
                                }
                            }
                        } catch (Throwable unused) {
                            com.baidu.sofire.utility.c.a();
                        }
                    }
                });
            } catch (Throwable unused) {
                com.baidu.sofire.utility.c.a();
            }
        }
    }

    public final boolean a() {
        try {
            File file = new File(this.f10290b);
            if (file.exists()) {
                return file.delete();
            }
            return false;
        } catch (Throwable unused) {
            com.baidu.sofire.utility.c.a();
            return false;
        }
    }
}
