package com.baidu.swan.apps.core.c;

import android.content.Context;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.baidu.swan.apps.a;
import com.baidu.swan.apps.res.widget.dialog.g;
import com.baidu.swan.apps.u.b.c;
/* loaded from: classes2.dex */
public class c {

    /* loaded from: classes2.dex */
    public interface a {
        void c(boolean z, String str);
    }

    public static void a(@NonNull com.baidu.swan.apps.ae.b bVar, @NonNull final Context context, @NonNull final a aVar) {
        com.baidu.swan.apps.u.a.DG().a(bVar.getAppKey(), new c.a() { // from class: com.baidu.swan.apps.core.c.c.1
            @Override // com.baidu.swan.apps.u.b.c.a
            public void k(Exception exc) {
                com.baidu.swan.apps.console.c.e("DeveloperAuthenticateHelper", "onFail : Authentication exception :", exc);
                String message = exc.getMessage();
                aVar.c(false, context.getString(a.h.aiapps_authenticate_fail) + (TextUtils.isEmpty(message) ? "" : "\n" + message));
            }

            @Override // com.baidu.swan.apps.u.b.c.a
            public void aU(boolean z) {
                if (!z) {
                    com.baidu.swan.apps.console.c.e("DeveloperAuthenticateHelper", "Authentication Fail : Not developer");
                    aVar.c(false, context.getString(a.h.aiapps_authenticate_fail));
                    return;
                }
                com.baidu.swan.apps.console.c.e("DeveloperAuthenticateHelper", "Authentication Success");
                aVar.c(true, "");
            }
        });
    }

    public static void S(Context context, String str) {
        new g.a(context).d(context.getString(a.h.aiapps_debug_switch_title)).gx(str).a(new com.baidu.swan.apps.view.b.a()).b(a.h.aiapps_confirm, null).KK();
    }
}
