package com.baidu.poly.d.a;

import android.app.Activity;
import com.baidu.poly.d.a;
import java.util.Map;
/* loaded from: classes2.dex */
public class a extends c {
    private static a ahi;

    private a() {
    }

    public static a tH() {
        if (ahi == null) {
            synchronized (a.class) {
                if (ahi == null) {
                    ahi = new a();
                }
            }
        }
        return ahi;
    }

    @Override // com.baidu.poly.d.a.c, com.baidu.poly.d.a.d
    public void a(Activity activity, Map<String, String> map, a.C0083a c0083a) {
    }
}
