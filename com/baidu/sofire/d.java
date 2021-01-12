package com.baidu.sofire;

import android.content.Context;
import android.os.FileObserver;
import java.io.File;
/* loaded from: classes14.dex */
public class d extends FileObserver {

    /* renamed from: a  reason: collision with root package name */
    private String f5233a;

    /* renamed from: b  reason: collision with root package name */
    private String f5234b;
    private int c;
    private Context d;

    public d(Context context, int i, String str, String str2) {
        super(str, 4095);
        try {
            this.f5233a = str;
            this.f5234b = str2;
            this.c = i;
            this.d = context;
            new StringBuilder("f=").append(this.f5233a).append(", e=").append(new File(this.f5233a).exists()).append(", b=").append(this.f5234b);
            b.a();
        } catch (Throwable th) {
            com.baidu.sofire.i.e.a();
        }
    }

    public final boolean a() {
        try {
            File file = new File(this.f5234b);
            if (file.exists()) {
                return file.delete();
            }
            return false;
        } catch (Throwable th) {
            com.baidu.sofire.i.e.a();
            return false;
        }
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [com.baidu.sofire.d$1] */
    @Override // android.os.FileObserver
    public void onEvent(int i, String str) {
        switch (i) {
            case 2:
            case 4:
            case 64:
            case 128:
            case 512:
            case 1024:
            case 2048:
                try {
                    new Thread() { // from class: com.baidu.sofire.d.1
                        @Override // java.lang.Thread, java.lang.Runnable
                        public final void run() {
                            try {
                                super.run();
                                b.a();
                                synchronized (d.class) {
                                    if (!com.baidu.sofire.i.e.c(d.this.f5233a)) {
                                        b.a();
                                        com.baidu.sofire.i.e.a(d.this.f5234b, d.this.f5233a);
                                        com.baidu.sofire.i.e.a(d.this.f5233a, true);
                                        c.a(new File(d.this.f5233a));
                                        c.a(d.this.d, d.this.c, new File(d.this.f5233a), new File(d.this.f5234b));
                                        new StringBuilder().append(d.this.f5233a.toString());
                                        b.a();
                                        com.baidu.sofire.c.a.a(d.this.d).b(d.this.c, -1);
                                    }
                                }
                            } catch (Throwable th) {
                                com.baidu.sofire.i.e.a();
                            }
                        }
                    }.start();
                    return;
                } catch (Throwable th) {
                    com.baidu.sofire.i.e.a();
                    return;
                }
            default:
                return;
        }
    }
}
