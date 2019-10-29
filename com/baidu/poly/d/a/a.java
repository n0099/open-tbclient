package com.baidu.poly.d.a;

import android.app.Activity;
import com.baidu.poly.d.a;
import java.util.Map;
/* loaded from: classes2.dex */
public class a extends c {
    private static a aBR;

    private a() {
    }

    public static a zQ() {
        if (aBR == null) {
            synchronized (a.class) {
                if (aBR == null) {
                    aBR = new a();
                }
            }
        }
        return aBR;
    }

    @Override // com.baidu.poly.d.a.c, com.baidu.poly.d.a.d
    public void a(Activity activity, Map<String, String> map, final a.C0131a c0131a) {
        com.baidu.swan.apps.aa.b.Ni().a(activity, m(map).get("orderInfo"), new com.baidu.swan.apps.aa.a.a() { // from class: com.baidu.poly.d.a.a.1
            @Override // com.baidu.swan.apps.aa.a.a
            public void m(int i, String str) {
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
