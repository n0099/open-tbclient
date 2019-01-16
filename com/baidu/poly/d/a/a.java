package com.baidu.poly.d.a;

import android.app.Activity;
import com.baidu.poly.d.a;
import com.baidu.searchbox.ng.ai.apps.ioc.AiAppsRuntime;
import com.baidu.searchbox.ng.ai.apps.pay.callback.AliPayCallback;
import java.util.Map;
/* loaded from: classes2.dex */
public class a extends c {
    private static a aiy;

    private a() {
    }

    public static a uG() {
        if (aiy == null) {
            synchronized (a.class) {
                if (aiy == null) {
                    aiy = new a();
                }
            }
        }
        return aiy;
    }

    @Override // com.baidu.poly.d.a.c, com.baidu.poly.d.a.d
    public void a(Activity activity, Map<String, String> map, final a.C0115a c0115a) {
        AiAppsRuntime.getPolymerPayRuntime().doAliPay(activity, l(map).get("orderInfo"), new AliPayCallback() { // from class: com.baidu.poly.d.a.a.1
            @Override // com.baidu.searchbox.ng.ai.apps.pay.callback.AliPayCallback
            public void onAliPayResult(int i, String str) {
                if (c0115a != null) {
                    switch (i) {
                        case 0:
                            c0115a.onResult(0, str);
                            return;
                        case 1:
                            c0115a.onResult(1, str);
                            return;
                        case 2:
                            c0115a.onResult(2, str);
                            return;
                        case 3:
                            c0115a.onResult(3, str);
                            return;
                        default:
                            c0115a.onResult(3, str);
                            return;
                    }
                }
            }
        });
    }
}
