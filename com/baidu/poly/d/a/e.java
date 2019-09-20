package com.baidu.poly.d.a;

import android.app.Activity;
import com.baidu.poly.d.a;
import java.util.Map;
/* loaded from: classes2.dex */
public class e extends c {
    private static final String TAG = e.class.getSimpleName();
    private static e aiA;

    private e() {
    }

    public static e uY() {
        if (aiA == null) {
            synchronized (e.class) {
                if (aiA == null) {
                    aiA = new e();
                }
            }
        }
        return aiA;
    }

    @Override // com.baidu.poly.d.a.c, com.baidu.poly.d.a.d
    public void a(Activity activity, Map<String, String> map, final a.C0099a c0099a) {
        com.baidu.swan.apps.aa.b.Io().b(activity, l(map), new com.baidu.swan.apps.aa.a.d() { // from class: com.baidu.poly.d.a.e.1
            @Override // com.baidu.swan.apps.aa.a.d
            public void k(int i, String str) {
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
