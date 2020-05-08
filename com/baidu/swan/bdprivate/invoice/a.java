package com.baidu.swan.bdprivate.invoice;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.baidu.swan.bdprivate.b;
/* loaded from: classes11.dex */
public class a {
    public static void q(Context context, String str, String str2) {
        if (context != null) {
            if (TextUtils.isEmpty(str2)) {
                str2 = context.getResources().getString(b.g.invoice_error_operation_failed);
            }
            com.baidu.swan.apps.console.c.e("chooseInvoiceTitle", "网络请求错误：" + str2);
            com.baidu.swan.apps.res.widget.b.d.a(context, str2).showToast();
        }
    }

    public static void a(Activity activity, com.baidu.swan.apps.a.a aVar) {
        com.baidu.swan.apps.console.c.e("chooseInvoiceTitle", "登录状态异常");
        com.baidu.swan.bdprivate.a.a.a(activity, false, (Bundle) null, aVar);
    }
}
