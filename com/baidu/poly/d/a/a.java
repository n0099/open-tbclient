package com.baidu.poly.d.a;

import android.app.Activity;
import com.baidu.poly.d.a;
import java.util.Map;
/* loaded from: classes2.dex */
public class a extends c {
    private static a ahj;

    private a() {
    }

    public static a tH() {
        if (ahj == null) {
            synchronized (a.class) {
                if (ahj == null) {
                    ahj = new a();
                }
            }
        }
        return ahj;
    }

    @Override // com.baidu.poly.d.a.c, com.baidu.poly.d.a.d
    public void a(Activity activity, Map<String, String> map, a.C0083a c0083a) {
    }
}
