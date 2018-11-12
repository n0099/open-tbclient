package com.baidu.sofire;

import android.content.Context;
import android.content.Intent;
import com.baidu.sofire.ac.Callback;
import java.util.HashMap;
/* loaded from: classes.dex */
public class a {
    public static void a(Context context, Intent intent) {
        int i = 0;
        try {
            String[] h = com.baidu.sofire.b.e.h(context);
            b.a("onReceiveAwakeMessage : " + h[0] + " : " + h[1]);
            com.baidu.sofire.core.e.a(context, 0, h[0], h[1], 100028);
            while (true) {
                Thread.sleep(500L);
                i++;
                b.a("onReceiveAwakeMessage : " + i);
                if (i > 60) {
                    HashMap hashMap = new HashMap();
                    hashMap.put("0", "152");
                    hashMap.put("1", h[0]);
                    com.baidu.sofire.b.e.a(context.getApplicationContext(), "1014115", hashMap);
                    b.a("onReceiveAwakeMessage : " + hashMap.toString());
                    break;
                }
                com.baidu.sofire.core.g a = com.baidu.sofire.core.g.a();
                if (a == null) {
                    b.a("onReceiveAwakeMessage : h : " + i);
                } else if (a.d("com.baidu.sofire.x24") != null) {
                    break;
                }
            }
            b.a("onReceiveAwakeMessage : call");
            com.baidu.sofire.core.e.a(100028, "onReceiveAwakeMessage", new Callback() { // from class: com.baidu.sofire.a.1
                @Override // com.baidu.sofire.ac.Callback
                public Object onEnd(Object... objArr) {
                    return super.onEnd(objArr);
                }
            }, new Class[]{Context.class, Intent.class}, context, intent);
        } catch (Throwable th) {
            b.a("onReceiveAwakeMessage : e");
            com.baidu.sofire.b.e.a(th);
        }
    }
}
