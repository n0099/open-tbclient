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
                                synchronized (d.class) {
                                    if (!com.baidu.sofire.b.d.a(d.this.a)) {
                                        com.baidu.sofire.b.d.b(d.this.b, d.this.a);
                                        com.baidu.sofire.b.d.a(d.this.a, true);
                                        c.a(new File(d.this.a));
                                        c.a(d.this.d, d.this.c, new File(d.this.a), new File(d.this.b));
                                        new StringBuilder().append(d.this.a.toString());
                                        com.baidu.sofire.a.a.a(d.this.d).b(d.this.c, -1);
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
