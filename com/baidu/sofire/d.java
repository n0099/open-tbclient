package com.baidu.sofire;

import android.os.FileObserver;
import java.io.File;
/* loaded from: classes.dex */
public class d extends FileObserver {
    private String a;
    private String b;

    public d(String str, String str2) {
        super(str, 4095);
        this.a = str;
        this.b = str2;
        String str3 = "f=" + this.a + ", e=" + new File(this.a).exists() + ", b=" + this.b;
        b.a();
    }

    public final boolean a() {
        File file = new File(this.b);
        if (!file.exists()) {
            return false;
        }
        return file.delete();
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
                            super.run();
                            b.a();
                            synchronized (d.class) {
                                if (!com.baidu.sofire.b.d.a(d.this.a)) {
                                    b.a();
                                    com.baidu.sofire.b.d.b(d.this.b, d.this.a);
                                    com.baidu.sofire.b.d.a(d.this.a, true);
                                    c.a(new File(d.this.a));
                                    c.a(new File(d.this.a), new File(d.this.b));
                                }
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
