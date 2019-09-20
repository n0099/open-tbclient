package com.baidu.poly.d.a;

import android.app.Activity;
import com.baidu.poly.d.a;
import java.util.Map;
/* loaded from: classes2.dex */
public class b extends c {
    private static b aix;

    private b() {
    }

    public static b uX() {
        if (aix == null) {
            synchronized (b.class) {
                if (aix == null) {
                    aix = new b();
                }
            }
        }
        return aix;
    }

    @Override // com.baidu.poly.d.a.c, com.baidu.poly.d.a.d
    public void a(Activity activity, Map<String, String> map, final a.C0099a c0099a) {
        com.baidu.swan.apps.aa.b.Io().a(activity, l(map).get("orderInfo"), new com.baidu.swan.apps.aa.a.b() { // from class: com.baidu.poly.d.a.b.1
            @Override // com.baidu.swan.apps.aa.a.b
            public void j(int i, String str) {
                if (c0099a != null) {
                    switch (i) {
                        case 0:
                            c0099a.onResult(0, str);
                            return;
                        case 1:
                            c0099a.onResult(1, str);
                            return;
                        case 2:
                            c0099a.onResult(2, str);
                            return;
                        case 3:
                            c0099a.onResult(3, str);
                            return;
                        default:
                            c0099a.onResult(3, str);
                            return;
                    }
                }
            }
        });
    }
}
