package com.baidu.swan.apps.core.b;

import android.content.Context;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.baidu.swan.apps.b;
import com.baidu.swan.apps.res.widget.dialog.e;
import com.baidu.swan.apps.u.b.c;
/* loaded from: classes2.dex */
public class c {

    /* loaded from: classes2.dex */
    public interface a {
        void c(boolean z, String str);
    }

    public static void a(@NonNull com.baidu.swan.apps.ae.b bVar, @NonNull final Context context, @NonNull final a aVar) {
        com.baidu.swan.apps.u.a.CD().a(bVar.getAppKey(), new c.a() { // from class: com.baidu.swan.apps.core.b.c.1
            @Override // com.baidu.swan.apps.u.b.c.a
            public void k(Exception exc) {
                com.baidu.swan.apps.console.c.e("DeveloperAuthenticateHelper", "onFail : Authentication exception :", exc);
                String message = exc.getMessage();
                aVar.c(false, context.getString(b.h.aiapps_authenticate_fail) + (TextUtils.isEmpty(message) ? "" : "\n" + message));
            }

            @Override // com.baidu.swan.apps.u.b.c.a
            public void aS(boolean z) {
                if (!z) {
                    com.baidu.swan.apps.console.c.e("DeveloperAuthenticateHelper", "Authentication Fail : Not developer");
                    aVar.c(false, context.getString(b.h.aiapps_authenticate_fail));
                    return;
                }
                com.baidu.swan.apps.console.c.e("DeveloperAuthenticateHelper", "Authentication Success");
                aVar.c(true, "");
            }
        });
    }

    public static void af(Context context, String str) {
        new e.a(context).d(context.getString(b.h.aiapps_debug_switch_title)).gd(str).a(new com.baidu.swan.apps.view.b.a()).b(b.h.aiapps_confirm, null).Iu();
    }
}
