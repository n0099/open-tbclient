package com.baidu.poly.d.a;

import android.app.Activity;
import com.baidu.poly.d.a;
import java.util.Map;
/* loaded from: classes2.dex */
public class e extends c {
    private static final String TAG = e.class.getSimpleName();
    private static e ahf;

    private e() {
    }

    public static e tK() {
        if (ahf == null) {
            synchronized (e.class) {
                if (ahf == null) {
                    ahf = new e();
                }
            }
        }
        return ahf;
    }

    @Override // com.baidu.poly.d.a.c, com.baidu.poly.d.a.d
    public void a(Activity activity, Map<String, String> map, a.C0054a c0054a) {
    }
}
