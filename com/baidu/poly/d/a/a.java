package com.baidu.poly.d.a;

import android.app.Activity;
import com.baidu.poly.d.a;
import java.util.Map;
/* loaded from: classes2.dex */
public class a extends c {
    private static a ahc;

    private a() {
    }

    public static a tI() {
        if (ahc == null) {
            synchronized (a.class) {
                if (ahc == null) {
                    ahc = new a();
                }
            }
        }
        return ahc;
    }

    @Override // com.baidu.poly.d.a.c, com.baidu.poly.d.a.d
    public void a(Activity activity, Map<String, String> map, a.C0054a c0054a) {
    }
}
