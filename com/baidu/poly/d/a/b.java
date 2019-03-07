package com.baidu.poly.d.a;

import android.app.Activity;
import com.baidu.poly.d.a;
import java.util.Map;
/* loaded from: classes2.dex */
public class b extends c {
    private static b ahd;

    private b() {
    }

    public static b tJ() {
        if (ahd == null) {
            synchronized (b.class) {
                if (ahd == null) {
                    ahd = new b();
                }
            }
        }
        return ahd;
    }

    @Override // com.baidu.poly.d.a.c, com.baidu.poly.d.a.d
    public void a(Activity activity, Map<String, String> map, a.C0054a c0054a) {
    }
}
