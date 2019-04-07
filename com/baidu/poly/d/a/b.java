package com.baidu.poly.d.a;

import android.app.Activity;
import com.baidu.poly.d.a;
import java.util.Map;
/* loaded from: classes2.dex */
public class b extends c {
    private static b ahj;

    private b() {
    }

    public static b tI() {
        if (ahj == null) {
            synchronized (b.class) {
                if (ahj == null) {
                    ahj = new b();
                }
            }
        }
        return ahj;
    }

    @Override // com.baidu.poly.d.a.c, com.baidu.poly.d.a.d
    public void a(Activity activity, Map<String, String> map, a.C0083a c0083a) {
    }
}
