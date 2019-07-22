package com.baidu.poly.d.a;

import android.app.Activity;
import com.baidu.poly.d.a;
import java.util.Map;
/* loaded from: classes2.dex */
public class a extends c {
    private static a ahX;

    private a() {
    }

    public static a uS() {
        if (ahX == null) {
            synchronized (a.class) {
                if (ahX == null) {
                    ahX = new a();
                }
            }
        }
        return ahX;
    }

    @Override // com.baidu.poly.d.a.c, com.baidu.poly.d.a.d
    public void a(Activity activity, Map<String, String> map, final a.C0085a c0085a) {
        com.baidu.swan.apps.aa.b.Ik().a(activity, l(map).get("orderInfo"), new com.baidu.swan.apps.aa.a.a() { // from class: com.baidu.poly.d.a.a.1
            @Override // com.baidu.swan.apps.aa.a.a
            public void i(int i, String str) {
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
