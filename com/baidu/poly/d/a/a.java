package com.baidu.poly.d.a;

import android.app.Activity;
import com.baidu.poly.d.a;
import java.util.Map;
/* loaded from: classes2.dex */
public class a extends c {
    private static a ahd;

    private a() {
    }

    public static a tI() {
        if (ahd == null) {
            synchronized (a.class) {
                if (ahd == null) {
                    ahd = new a();
                }
            }
        }
        return ahd;
    }

    @Override // com.baidu.poly.d.a.c, com.baidu.poly.d.a.d
    public void a(Activity activity, Map<String, String> map, a.C0083a c0083a) {
    }
}
