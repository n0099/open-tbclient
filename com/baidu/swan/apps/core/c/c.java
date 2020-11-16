package com.baidu.swan.apps.core.c;

import android.content.Context;
import android.content.DialogInterface;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.baidu.swan.apps.a;
import com.baidu.swan.apps.adaptation.a.e;
import com.baidu.swan.apps.res.widget.dialog.g;
import com.baidu.swan.apps.runtime.e;
/* loaded from: classes7.dex */
public class c {

    /* loaded from: classes7.dex */
    public interface a {
        void k(boolean z, String str);
    }

    public static void a(@NonNull e eVar, @NonNull final Context context, @NonNull final a aVar) {
        com.baidu.swan.apps.a.b.a(eVar.getAppKey(), new e.a() { // from class: com.baidu.swan.apps.core.c.c.1
            @Override // com.baidu.swan.apps.adaptation.a.e.a
            public void m(Exception exc) {
                com.baidu.swan.apps.console.c.e("DeveloperAuthenticateHelper", "onFail : Authentication exception :", exc);
                String message = exc.getMessage();
                aVar.k(false, context.getString(a.h.aiapps_authenticate_fail) + (TextUtils.isEmpty(message) ? "" : "\n" + message));
            }

            @Override // com.baidu.swan.apps.adaptation.a.e.a
            public void ep(boolean z) {
                if (!z) {
                    com.baidu.swan.apps.console.c.e("DeveloperAuthenticateHelper", "Authentication Fail : Not developer");
                    aVar.k(false, context.getString(a.h.aiapps_authenticate_fail));
                    return;
                }
                com.baidu.swan.apps.console.c.e("DeveloperAuthenticateHelper", "Authentication Success");
                aVar.k(true, "");
            }
        });
    }

    public static void Y(Context context, String str) {
        new g.a(context).f(context.getString(a.h.aiapps_debug_switch_title)).rL(str).a(new com.baidu.swan.apps.view.c.a()).c(a.h.aiapps_confirm, (DialogInterface.OnClickListener) null).aGt();
    }
}
