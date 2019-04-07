package com.baidu.poly.d.a;

import android.app.Activity;
import com.baidu.poly.d.a;
import java.util.Map;
/* loaded from: classes2.dex */
public class e extends c {
    private static final String TAG = e.class.getSimpleName();
    private static e ahl;

    private e() {
    }

    public static e tJ() {
        if (ahl == null) {
            synchronized (e.class) {
                if (ahl == null) {
                    ahl = new e();
                }
            }
        }
        return ahl;
    }

    @Override // com.baidu.poly.d.a.c, com.baidu.poly.d.a.d
    public void a(Activity activity, Map<String, String> map, a.C0083a c0083a) {
    }
}
