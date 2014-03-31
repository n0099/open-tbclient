package com.baidu.batsdk.a;

import android.content.Context;
import java.util.List;
import java.util.Map;
/* loaded from: classes.dex */
public final class b {
    private static long a = 0;

    public static void a(Context context) {
        if (a == 0) {
            a = System.currentTimeMillis();
        } else if (System.currentTimeMillis() - a < com.baidu.batsdk.a.i) {
            com.baidu.batsdk.f.a.a("clean wait.");
        } else {
            Map<String, Object> m = com.baidu.batsdk.b.b.m(context);
            List list = (List) m.get("crashFiles");
            List list2 = (List) m.get("feedbackFiles");
            ((Long) m.get("allSize")).longValue();
            if (list.size() + list2.size() < 100) {
                com.baidu.batsdk.f.a.b("clean not need.");
                return;
            }
            com.baidu.batsdk.f.a.a("clean start");
            for (int i = 0; i < list.size() - 50; i++) {
                com.baidu.batsdk.b.b.d(context, (String) list.get(i));
            }
            for (int i2 = 0; i2 < list2.size() - 50; i2++) {
                com.baidu.batsdk.b.b.d(context, (String) list2.get(i2));
            }
            com.baidu.batsdk.f.a.a("delete " + (list.size() + (-50) > 0 ? list.size() - 50 : 0) + " crashfiles, " + (list2.size() + (-50) > 0 ? list2.size() - 50 : 0) + " feedbackfiles.");
            com.baidu.batsdk.f.a.b("clean success.");
        }
    }
}
