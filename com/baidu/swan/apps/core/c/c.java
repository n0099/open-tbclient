package com.baidu.swan.apps.core.c;

import android.content.Context;
import android.content.DialogInterface;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.baidu.swan.apps.a;
import com.baidu.swan.apps.adaptation.a.e;
import com.baidu.swan.apps.res.widget.dialog.g;
import com.baidu.swan.apps.runtime.e;
/* loaded from: classes9.dex */
public class c {

    /* loaded from: classes9.dex */
    public interface a {
        void e(boolean z, String str);
    }

    public static void a(@NonNull e eVar, @NonNull final Context context, @NonNull final a aVar) {
        com.baidu.swan.apps.a.b.a(eVar.getAppKey(), new e.a() { // from class: com.baidu.swan.apps.core.c.c.1
            @Override // com.baidu.swan.apps.adaptation.a.e.a
            public void j(Exception exc) {
                com.baidu.swan.apps.console.c.e("DeveloperAuthenticateHelper", "onFail : Authentication exception :", exc);
                String message = exc.getMessage();
                aVar.e(false, context.getString(a.h.aiapps_authenticate_fail) + (TextUtils.isEmpty(message) ? "" : "\n" + message));
            }

            @Override // com.baidu.swan.apps.adaptation.a.e.a
            public void bI(boolean z) {
                if (!z) {
                    com.baidu.swan.apps.console.c.e("DeveloperAuthenticateHelper", "Authentication Fail : Not developer");
                    aVar.e(false, context.getString(a.h.aiapps_authenticate_fail));
                    return;
                }
                com.baidu.swan.apps.console.c.e("DeveloperAuthenticateHelper", "Authentication Success");
                aVar.e(true, "");
            }
        });
    }

    public static void ah(Context context, String str) {
        new g.a(context).e(context.getString(a.h.aiapps_debug_switch_title)).kr(str).a(new com.baidu.swan.apps.view.c.a()).c(a.h.aiapps_confirm, (DialogInterface.OnClickListener) null).ZC();
    }
}
