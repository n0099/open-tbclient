package com.baidu.sofire;

import android.content.Context;
import android.os.FileObserver;
import java.io.File;
/* loaded from: classes.dex */
public class d extends FileObserver {
    private String a;
    private String b;
    private int c;
    private Context d;

    public d(Context context, int i, String str, String str2) {
        super(str, 4095);
        try {
            this.a = str;
            this.b = str2;
            this.c = i;
            this.d = context;
            b.a("f=" + this.a + ", e=" + new File(this.a).exists() + ", b=" + this.b);
        } catch (Throwable th) {
            com.baidu.sofire.b.e.a(th);
        }
    }

    public boolean a() {
        try {
            File file = new File(this.b);
            if (file == null || !file.exists()) {
                return false;
            }
            return file.delete();
        } catch (Throwable th) {
            com.baidu.sofire.b.e.a(th);
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
                        public void run() {
                            try {
                                super.run();
                                b.a("target event!");
                                synchronized (d.class) {
                                    if (!com.baidu.sofire.b.e.c(d.this.a)) {
                                        b.a("do copyFile!!!");
                                        com.baidu.sofire.b.e.b(d.this.b, d.this.a);
                                        com.baidu.sofire.b.e.a(d.this.a, true);
                                        c.a(new File(d.this.a));
                                        c.a(d.this.d, d.this.c, new File(d.this.a), new File(d.this.b));
                                        b.a("update delete status to -1" + d.this.a.toString());
                                        com.baidu.sofire.a.a.a(d.this.d).d(d.this.c, -1);
                                    }
                                }
                            } catch (Throwable th) {
                                com.baidu.sofire.b.e.a(th);
                            }
                        }
                    }.start();
                    return;
                } catch (Throwable th) {
                    com.baidu.sofire.b.e.a(th);
                    return;
                }
            default:
                return;
        }
    }
}
