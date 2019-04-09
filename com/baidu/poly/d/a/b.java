package com.baidu.poly.d.a;

import android.app.Activity;
import com.baidu.poly.d.a;
import java.util.Map;
/* loaded from: classes2.dex */
public class b extends c {
    private static b ahk;

    private b() {
    }

    public static b tI() {
        if (ahk == null) {
            synchronized (b.class) {
                if (ahk == null) {
                    ahk = new b();
                }
            }
        }
        return ahk;
    }

    @Override // com.baidu.poly.d.a.c, com.baidu.poly.d.a.d
    public void a(Activity activity, Map<String, String> map, a.C0083a c0083a) {
    }
}
