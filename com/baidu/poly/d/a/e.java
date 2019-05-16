package com.baidu.poly.d.a;

import android.app.Activity;
import com.baidu.poly.d.a;
import java.util.Map;
/* loaded from: classes2.dex */
public class e extends c {
    private static final String TAG = e.class.getSimpleName();
    private static e ahC;

    private e() {
    }

    public static e uu() {
        if (ahC == null) {
            synchronized (e.class) {
                if (ahC == null) {
                    ahC = new e();
                }
            }
        }
        return ahC;
    }

    @Override // com.baidu.poly.d.a.c, com.baidu.poly.d.a.d
    public void a(Activity activity, Map<String, String> map, final a.C0085a c0085a) {
        com.baidu.swan.apps.aa.b.Hy().b(activity, l(map), new com.baidu.swan.apps.aa.a.d() { // from class: com.baidu.poly.d.a.e.1
            @Override // com.baidu.swan.apps.aa.a.d
            public void k(int i, String str) {
                if (c0085a != null) {
                    switch (i) {
                        case 0:
                            c0085a.onResult(0, str);
                            return;
                        case 1:
                            c0085a.onResult(1, str);
                            return;
                        case 2:
                            c0085a.onResult(2, str);
                            return;
                        case 3:
                            c0085a.onResult(3, str);
                            return;
                        default:
                            c0085a.onResult(3, str);
                            return;
                    }
                }
            }
        });
    }
}
