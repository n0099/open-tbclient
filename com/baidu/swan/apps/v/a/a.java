package com.baidu.swan.apps.v.a;

import android.content.Context;
import android.content.DialogInterface;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.baidu.swan.apps.a;
import com.baidu.swan.apps.an.aa;
import com.baidu.swan.apps.an.f;
import com.baidu.swan.apps.statistic.b.c;
import com.baidu.swan.apps.statistic.search.SearchFlowEvent;
import com.baidu.swan.apps.swancore.b;
import com.baidu.swan.apps.view.SwanAppErrorDialog;
import com.baidu.swan.apps.w.e;
import java.io.File;
/* loaded from: classes2.dex */
public class a {
    private static boolean isShowing = false;

    public static void a(Context context, @NonNull com.baidu.swan.apps.ak.a aVar, int i) {
        File LP;
        if (context != null && !isShowing) {
            String format = String.format(context.getResources().getString(a.h.aiapps_open_failed_msg), aa.getVersionName(), b.a(e.Ea().DF(), i), String.valueOf(aVar.LA()));
            SwanAppErrorDialog.ME().dj(a.h.aiapps_open_failed_title).a(new DialogInterface.OnDismissListener() { // from class: com.baidu.swan.apps.v.a.a.1
                @Override // android.content.DialogInterface.OnDismissListener
                public void onDismiss(DialogInterface dialogInterface) {
                    boolean unused = a.isShowing = false;
                }
            }).gb(format).a(a.h.aiapps_open_failed_button, (DialogInterface.OnClickListener) null).show();
            isShowing = true;
            com.baidu.swan.apps.statistic.search.b.a(new SearchFlowEvent("nreach", System.currentTimeMillis(), "swan_error", "", SearchFlowEvent.EventType.END));
            c.c(new com.baidu.swan.apps.statistic.b.a("error", String.valueOf(System.currentTimeMillis()), String.valueOf(aVar.LA())));
            if (com.baidu.swan.apps.b.DEBUG) {
                String Ml = aa.Ml();
                if (!TextUtils.isEmpty(Ml) && (LP = f.LP()) != null) {
                    File file = new File(LP.getPath(), "error_dialog_info.txt");
                    com.baidu.swan.c.b.deleteFile(file);
                    StringBuilder sb = new StringBuilder("");
                    if (!TextUtils.isEmpty(format)) {
                        sb.append(format).append("\n");
                    }
                    sb.append(Ml).append("\n");
                    com.baidu.swan.c.b.b(sb.toString(), file);
                }
            }
        }
    }
}
