package com.baidu.swan.apps.v.a;

import android.content.Context;
import android.content.DialogInterface;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.unitedscheme.SchemeRouter;
import com.baidu.swan.apps.SwanAppLauncherActivity;
import com.baidu.swan.apps.a;
import com.baidu.swan.apps.an.ac;
import com.baidu.swan.apps.an.f;
import com.baidu.swan.apps.an.k;
import com.baidu.swan.apps.an.q;
import com.baidu.swan.apps.network.SwanAppNetworkUtils;
import com.baidu.swan.apps.res.widget.b.d;
import com.baidu.swan.apps.statistic.search.SearchFlowEvent;
import com.baidu.swan.apps.view.SwanAppErrorDialog;
import com.baidu.swan.apps.w.e;
import java.io.File;
/* loaded from: classes2.dex */
public class a {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static boolean isShowing = false;

    public static void a(Context context, @NonNull com.baidu.swan.apps.ak.a aVar, int i, c cVar) {
        File Pp;
        if (context != null) {
            if ((context instanceof SwanAppLauncherActivity) && SwanAppLauncherActivity.aC(context)) {
                if (DEBUG) {
                    Log.d("LaunchError", "launcher activity closed, ignore launch err");
                    return;
                }
                return;
            }
            if (DEBUG) {
                Log.d("LaunchError", "start handleLaunchError with isShowing: " + isShowing + " errCode: " + aVar.toString());
            }
            String a = com.baidu.swan.apps.swancore.b.a(e.GJ().Go(), i);
            String format = String.format(context.getResources().getString(a.h.aiapps_open_failed_msg), ac.getVersionName(), a, String.valueOf(aVar.OZ()));
            if (a(context, cVar)) {
                if (DEBUG) {
                    Log.d("LaunchError", "show network err toast");
                }
                if (q.bG(context)) {
                    d.k(AppRuntime.getAppContext(), a.h.aiapps_net_error).LU();
                } else {
                    if (DEBUG) {
                        Log.w("LaunchError", "show network err toast: areNotificationsEnabled false");
                    }
                    eK(format);
                }
            } else if (b.a(cVar)) {
                if (DEBUG) {
                    Log.d("LaunchError", "execute swan new year h5 downgrade  => h5 downgrade");
                }
                SchemeRouter.invoke(AppRuntime.getAppContext(), b.Fu());
            } else if (q.bG(context)) {
                b(context, a, aVar);
            } else {
                if (DEBUG) {
                    Log.w("LaunchError", "handleLaunchError: areNotificationsEnabled false");
                }
                if (!isShowing) {
                    eK(format);
                    return;
                }
                return;
            }
            StringBuilder sb = new StringBuilder();
            String a2 = com.baidu.swan.apps.an.e.a(com.baidu.swan.apps.an.e.Po(), "yyyy-MM-dd HH:mm:ss");
            if (cVar != null) {
                String str = cVar.mAppId;
                if (!TextUtils.isEmpty(str)) {
                    sb.append(a2).append(": ").append(str).append("\r\n");
                }
            }
            sb.append(a2).append(": ").append(format).append("\r\n");
            k.x(sb.toString(), false);
            com.baidu.swan.apps.statistic.search.b.a(new SearchFlowEvent("nreach", System.currentTimeMillis(), "swan_error", "", SearchFlowEvent.EventType.END));
            com.baidu.swan.apps.statistic.b.c.c(new com.baidu.swan.apps.statistic.b.a("error", String.valueOf(System.currentTimeMillis()), String.valueOf(aVar.OZ())));
            if (com.baidu.swan.apps.b.DEBUG) {
                String PN = ac.PN();
                if (!TextUtils.isEmpty(PN) && (Pp = f.Pp()) != null) {
                    File file = new File(Pp.getPath(), "error_dialog_info.txt");
                    com.baidu.swan.c.a.deleteFile(file);
                    StringBuilder sb2 = new StringBuilder("");
                    if (!TextUtils.isEmpty(format)) {
                        sb2.append(format).append("\n");
                    }
                    sb2.append(PN).append("\n");
                    com.baidu.swan.c.a.b(sb2.toString(), file);
                }
            }
        }
    }

    private static boolean a(@NonNull Context context, @Nullable c cVar) {
        return (cVar == null || TextUtils.isEmpty(cVar.mAppId) || SwanAppNetworkUtils.isNetworkConnected(context) || com.baidu.swan.apps.v.d.a.R(context, cVar.mAppId)) ? false : true;
    }

    private static void eK(@NonNull String str) {
        if (!isShowing) {
            if (DEBUG) {
                Log.d("LaunchError", "show normal err dialog");
            }
            SwanAppErrorDialog.Qh().ds(a.h.aiapps_open_failed_title).a(new DialogInterface.OnDismissListener() { // from class: com.baidu.swan.apps.v.a.a.1
                @Override // android.content.DialogInterface.OnDismissListener
                public void onDismiss(DialogInterface dialogInterface) {
                    boolean unused = a.isShowing = false;
                }
            }).gB(str).a(a.h.aiapps_open_failed_button, (DialogInterface.OnClickListener) null).show();
            isShowing = true;
        }
    }

    private static void b(@NonNull Context context, @NonNull String str, @NonNull com.baidu.swan.apps.ak.a aVar) {
        String format = String.format(context.getResources().getString(a.h.swanapp_launch_err_tip), ac.getVersionName(), str, String.valueOf(aVar.OZ()));
        if (DEBUG) {
            Log.d("LaunchError", "show normal err toast: " + format);
        }
        d.a(AppRuntime.getAppContext(), format).LV();
    }
}
