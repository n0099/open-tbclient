package com.baidu.poly.d.a;

import android.app.Activity;
import com.baidu.poly.d.a;
import java.util.Map;
/* loaded from: classes2.dex */
public class e extends c {
    private static final String TAG = e.class.getSimpleName();
    private static e aBX;

    private e() {
    }

    public static e zS() {
        if (aBX == null) {
            synchronized (e.class) {
                if (aBX == null) {
                    aBX = new e();
                }
            }
        }
        return aBX;
    }

    @Override // com.baidu.poly.d.a.c, com.baidu.poly.d.a.d
    public void a(Activity activity, Map<String, String> map, final a.C0131a c0131a) {
        com.baidu.swan.apps.aa.b.Ni().b(activity, m(map), new com.baidu.swan.apps.aa.a.d() { // from class: com.baidu.poly.d.a.e.1
            @Override // com.baidu.swan.apps.aa.a.d
            public void o(int i, String str) {
                if (c0131a != null) {
                    switch (i) {
                        case 0:
                            c0131a.onResult(0, str);
                            return;
                        case 1:
                            c0131a.onResult(1, str);
                            return;
                        case 2:
                            c0131a.onResult(2, str);
                            return;
                        case 3:
                            c0131a.onResult(3, str);
                            return;
                        default:
                            c0131a.onResult(3, str);
                            return;
                    }
                }
            }
        });
    }
}
