package com.baidu.sofire;

import android.content.Context;
import android.os.FileObserver;
import java.io.File;
/* loaded from: classes.dex */
public class c extends FileObserver {
    private String a;
    private String b;
    private int c;
    private Context d;

    public c(Context context, int i, String str, String str2) {
        super(str, 4095);
        try {
            this.a = str;
            this.b = str2;
            this.c = i;
            this.d = context;
            new StringBuilder("f=").append(this.a).append(", e=").append(new File(this.a).exists()).append(", b=").append(this.b);
        } catch (Throwable th) {
            com.baidu.sofire.b.d.a(th);
        }
    }

    public final boolean a() {
        try {
            File file = new File(this.b);
            if (file.exists()) {
                return file.delete();
            }
            return false;
        } catch (Throwable th) {
            com.baidu.sofire.b.d.a(th);
            return false;
        }
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [com.baidu.sofire.c$1] */
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
                    new Thread() { // from class: com.baidu.sofire.c.1
                        @Override // java.lang.Thread, java.lang.Runnable
                        public final void run() {
                            try {
                                super.run();
                                synchronized (c.class) {
                                    if (!com.baidu.sofire.b.d.a(c.this.a)) {
                                        com.baidu.sofire.b.d.b(c.this.b, c.this.a);
                                        com.baidu.sofire.b.d.a(c.this.a, true);
                                        b.a(new File(c.this.a));
                                        b.a(c.this.d, c.this.c, new File(c.this.a), new File(c.this.b));
                                        new StringBuilder().append(c.this.a.toString());
                                        com.baidu.sofire.a.a.aA(c.this.d).b(c.this.c, -1);
                                    }
                                }
                            } catch (Throwable th) {
                                com.baidu.sofire.b.d.a(th);
                            }
                        }
                    }.start();
                    return;
                } catch (Throwable th) {
                    com.baidu.sofire.b.d.a(th);
                    return;
                }
            default:
                return;
        }
    }
}
