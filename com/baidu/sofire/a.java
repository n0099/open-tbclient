package com.baidu.sofire;

import android.content.Context;
import android.content.Intent;
import com.baidu.sofire.ac.Callback;
import java.util.HashMap;
/* loaded from: classes.dex */
public final class a {
    public static void a(Context context, Intent intent) {
        int i = 0;
        try {
            String[] e = com.baidu.sofire.b.e.e(context);
            new StringBuilder().append(e[0]).append(" : ").append(e[1]);
            com.baidu.sofire.b.e.a(context, 0, e[0], e[1], 100028);
            while (true) {
                Thread.sleep(500L);
                i++;
                new StringBuilder().append(i);
                if (i > 60) {
                    HashMap hashMap = new HashMap();
                    hashMap.put("0", "152");
                    hashMap.put("1", e[0]);
                    com.baidu.sofire.b.e.a(context.getApplicationContext(), "1014115", hashMap);
                    new StringBuilder().append(hashMap.toString());
                    break;
                }
                com.baidu.sofire.core.e a = com.baidu.sofire.core.e.a();
                if (a != null && a.d("com.baidu.techain.x24") != null) {
                    break;
                }
            }
            com.baidu.sofire.b.e.a(100028, "onReceiveAwakeMessage", new Callback() { // from class: com.baidu.sofire.a.1
                @Override // com.baidu.sofire.ac.Callback
                public final Object onEnd(Object... objArr) {
                    return super.onEnd(objArr);
                }
            }, new Class[]{Context.class, Intent.class}, context, intent);
        } catch (Throwable th) {
            com.baidu.sofire.b.e.a(th);
        }
    }
}
