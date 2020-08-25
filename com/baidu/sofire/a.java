package com.baidu.sofire;

import android.content.Context;
import android.content.Intent;
import com.baidu.sofire.ac.Callback;
import java.util.HashMap;
/* loaded from: classes20.dex */
public final class a {
    public static void a(Context context, Intent intent) {
        int i = 0;
        try {
            String[] g = com.baidu.sofire.i.e.g(context);
            new StringBuilder().append(g[0]).append(" : ").append(g[1]);
            b.a();
            com.baidu.sofire.core.d.a(context, 0, g[0], g[1], 100028);
            while (true) {
                Thread.sleep(500L);
                i++;
                new StringBuilder().append(i);
                b.a();
                if (i > 60) {
                    HashMap hashMap = new HashMap();
                    hashMap.put("0", "152");
                    hashMap.put("1", g[0]);
                    com.baidu.sofire.i.e.a(context.getApplicationContext(), "1014115", hashMap);
                    new StringBuilder().append(hashMap.toString());
                    b.a();
                    break;
                }
                com.baidu.sofire.core.f a = com.baidu.sofire.core.f.a();
                if (a == null) {
                    b.a();
                } else if (a.d("com.baidu.sofire.x24") != null) {
                    break;
                }
            }
            b.a();
            com.baidu.sofire.core.d.a(100028, "onReceiveAwakeMessage", new Callback() { // from class: com.baidu.sofire.a.1
                @Override // com.baidu.sofire.ac.Callback
                public final Object onEnd(Object... objArr) {
                    return super.onEnd(objArr);
                }
            }, new Class[]{Context.class, Intent.class}, context, intent);
        } catch (Throwable th) {
            b.a();
            com.baidu.sofire.i.e.a();
        }
    }
}
