package com.baidu.poly.d.a;

import android.app.Activity;
import com.baidu.poly.d.a;
import com.baidu.searchbox.ng.ai.apps.ioc.AiAppsRuntime;
import com.baidu.searchbox.ng.ai.apps.pay.callback.WeChatPayCallback;
import java.util.Map;
/* loaded from: classes2.dex */
public class e extends c {
    private static final String TAG = e.class.getSimpleName();
    private static e aiv;

    private e() {
    }

    public static e uE() {
        if (aiv == null) {
            synchronized (e.class) {
                if (aiv == null) {
                    aiv = new e();
                }
            }
        }
        return aiv;
    }

    @Override // com.baidu.poly.d.a.c, com.baidu.poly.d.a.d
    public void a(Activity activity, Map<String, String> map, final a.C0115a c0115a) {
        AiAppsRuntime.getPolymerPayRuntime().doWeChatPay(activity, l(map), new WeChatPayCallback() { // from class: com.baidu.poly.d.a.e.1
            @Override // com.baidu.searchbox.ng.ai.apps.pay.callback.WeChatPayCallback
            public void onWeChatPayResult(int i, String str) {
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
