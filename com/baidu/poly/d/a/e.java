package com.baidu.poly.d.a;

import android.app.Activity;
import com.baidu.poly.d.a;
import java.util.Map;
/* loaded from: classes2.dex */
public class e extends c {
    private static final String TAG = e.class.getSimpleName();
    private static e ahm;

    private e() {
    }

    public static e tJ() {
        if (ahm == null) {
            synchronized (e.class) {
                if (ahm == null) {
                    ahm = new e();
                }
            }
        }
        return ahm;
    }

    @Override // com.baidu.poly.d.a.c, com.baidu.poly.d.a.d
    public void a(Activity activity, Map<String, String> map, a.C0083a c0083a) {
    }
}
