package com.baidu.poly.d.a;

import android.app.Activity;
import com.baidu.poly.d.a;
import com.baidu.searchbox.ng.ai.apps.ioc.AiAppsRuntime;
import com.baidu.searchbox.ng.ai.apps.pay.callback.BaiduPayCallback;
import java.util.Map;
/* loaded from: classes2.dex */
public class b extends c {
    private static b aiB;

    private b() {
    }

    public static b uH() {
        if (aiB == null) {
            synchronized (b.class) {
                if (aiB == null) {
                    aiB = new b();
                }
            }
        }
        return aiB;
    }

    @Override // com.baidu.poly.d.a.c, com.baidu.poly.d.a.d
    public void a(Activity activity, Map<String, String> map, final a.C0115a c0115a) {
        AiAppsRuntime.getPolymerPayRuntime().doBaiFuBaoPay(activity, l(map).get("orderInfo"), new BaiduPayCallback() { // from class: com.baidu.poly.d.a.b.1
            @Override // com.baidu.searchbox.ng.ai.apps.pay.callback.BaiduPayCallback
            public void onBaiduPayResult(int i, String str) {
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
