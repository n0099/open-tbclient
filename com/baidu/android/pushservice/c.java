package com.baidu.android.pushservice;

import android.content.Context;
import android.os.Handler;
import com.baidu.android.pushservice.d.g;
import com.baidu.android.pushservice.d.j;
import java.util.List;
import java.util.Random;
/* loaded from: classes5.dex */
public class c {
    private static volatile c a;
    private Context b;
    private Handler c;
    private Runnable d;
    private volatile boolean e;

    /* loaded from: classes5.dex */
    public interface a {
        void a(int i, String str);
    }

    private c(Context context) {
        this.b = context.getApplicationContext();
        this.c = new Handler(context.getMainLooper());
    }

    public static c a(Context context) {
        if (a == null) {
            synchronized (c.class) {
                if (a == null) {
                    a = new c(context);
                }
            }
        }
        return a;
    }

    private com.baidu.android.pushservice.g.c a(final a aVar, String str) {
        return new com.baidu.android.pushservice.d.g(this.b, str, new g.a() { // from class: com.baidu.android.pushservice.c.2
            @Override // com.baidu.android.pushservice.d.g.a
            public void a(List<String> list) {
                if (c.this.c != null) {
                    c.this.c.removeCallbacksAndMessages(null);
                }
                if (c.this.e) {
                    c.this.e = false;
                } else if (list == null || list.isEmpty()) {
                    aVar.a(-1, null);
                } else {
                    aVar.a(0, list.get(new Random().nextInt(list.size())));
                }
            }
        });
    }

    private com.baidu.android.pushservice.g.c b(final a aVar, String str) {
        return new com.baidu.android.pushservice.d.j(this.b, str, new j.a() { // from class: com.baidu.android.pushservice.c.3
            @Override // com.baidu.android.pushservice.d.j.a
            public void a(int i, String[] strArr) {
                String str2 = null;
                if (i == 0 && strArr != null && strArr.length > 0) {
                    str2 = strArr[0];
                }
                aVar.a(i, str2);
            }
        });
    }

    public void a(int i, final a aVar) {
        com.baidu.android.pushservice.g.c a2;
        if (aVar != null) {
            if (i == 0) {
                a2 = b(aVar, h.d(this.b));
            } else if (i == 1) {
                a2 = b(aVar, h.c(this.b));
            } else if (i != 2) {
                return;
            } else {
                if (this.d == null) {
                    this.d = new Runnable() { // from class: com.baidu.android.pushservice.c.1
                        @Override // java.lang.Runnable
                        public void run() {
                            c.this.e = true;
                            aVar.a(-1, null);
                        }
                    };
                }
                this.c.postDelayed(this.d, 5000L);
                a2 = a(aVar, h.c(this.b));
            }
            if (a2 != null) {
                com.baidu.android.pushservice.g.d.a().a(a2);
            }
        }
    }
}
