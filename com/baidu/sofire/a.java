package com.baidu.sofire;

import android.content.Context;
import android.content.Intent;
import com.baidu.sofire.ac.Callback;
import com.baidu.wallet.core.StatusCode;
import com.baidu.webkit.sdk.dumper.ZeusCrashHandler;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes2.dex */
public final class a {
    public static void a(Context context, Intent intent) {
        try {
            String[] h2 = com.baidu.sofire.g.d.h(context);
            StringBuilder sb = new StringBuilder();
            sb.append(h2[0]);
            sb.append(ZeusCrashHandler.NAME_SEPERATOR);
            sb.append(h2[1]);
            b.a();
            com.baidu.sofire.core.d.a(context, 0, h2[0], h2[1], StatusCode.SERVICE_CODE_CARD_MAYBE_ERR_AND_NOT_SUPPORT);
            int i = 0;
            while (true) {
                Thread.sleep(500L);
                i++;
                new StringBuilder().append(i);
                b.a();
                if (i > 60) {
                    HashMap hashMap = new HashMap();
                    hashMap.put("0", "152");
                    hashMap.put("1", h2[0]);
                    com.baidu.sofire.g.d.a(context.getApplicationContext(), "1014115", (Map<String, Object>) hashMap, false);
                    new StringBuilder().append(hashMap.toString());
                    b.a();
                    break;
                }
                com.baidu.sofire.core.f a2 = com.baidu.sofire.core.f.a();
                if (a2 == null) {
                    b.a();
                } else if (a2.d("com.baidu.sofire.x24") != null) {
                    break;
                }
            }
            b.a();
            com.baidu.sofire.core.d.a((int) StatusCode.SERVICE_CODE_CARD_MAYBE_ERR_AND_NOT_SUPPORT, "onReceiveAwakeMessage", new Callback() { // from class: com.baidu.sofire.a.1
                @Override // com.baidu.sofire.ac.Callback
                public final Object onEnd(Object... objArr) {
                    return super.onEnd(objArr);
                }
            }, new Class[]{Context.class, Intent.class}, context, intent);
        } catch (Throwable unused) {
            b.a();
            com.baidu.sofire.g.d.a();
        }
    }
}
