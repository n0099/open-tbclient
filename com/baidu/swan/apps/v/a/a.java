package com.baidu.swan.apps.v.a;

import android.content.Context;
import android.content.DialogInterface;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.live.adp.lib.stats.BdStatsConstant;
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
    private static boolean abS = false;

    public static void a(Context context, @NonNull com.baidu.swan.apps.ak.a aVar, int i, c cVar) {
        File Uf;
        if (context != null) {
            if ((context instanceof SwanAppLauncherActivity) && SwanAppLauncherActivity.aG(context)) {
                if (DEBUG) {
                    Log.d("LaunchError", "launcher activity closed, ignore launch err");
                    return;
                }
                return;
            }
            if (DEBUG) {
                Log.d("LaunchError", "start handleLaunchError with isShowing: " + abS + " errCode: " + aVar.toString());
            }
            String a = com.baidu.swan.apps.swancore.b.a(e.LD().Li(), i);
            String format = String.format(context.getResources().getString(a.h.aiapps_open_failed_msg), ac.getVersionName(), a, String.valueOf(aVar.TP()));
            if (a(context, cVar)) {
                if (DEBUG) {
                    Log.d("LaunchError", "show network err toast");
                }
                if (q.bH(context)) {
                    d.i(AppRuntime.getAppContext(), a.h.aiapps_net_error).QN();
                } else {
                    if (DEBUG) {
                        Log.w("LaunchError", "show network err toast: areNotificationsEnabled false");
                    }
                    fr(format);
                }
            } else if (b.a(cVar)) {
                if (DEBUG) {
                    Log.d("LaunchError", "execute swan new year h5 downgrade  => h5 downgrade");
                }
                SchemeRouter.invoke(AppRuntime.getAppContext(), b.Ko());
            } else if (q.bH(context)) {
                b(context, a, aVar);
            } else {
                if (DEBUG) {
                    Log.w("LaunchError", "handleLaunchError: areNotificationsEnabled false");
                }
                if (!abS) {
                    fr(format);
                    return;
                }
                return;
            }
            StringBuilder sb = new StringBuilder();
            String a2 = com.baidu.swan.apps.an.e.a(com.baidu.swan.apps.an.e.Ue(), "yyyy-MM-dd HH:mm:ss");
            if (cVar != null) {
                String str = cVar.mAppId;
                if (!TextUtils.isEmpty(str)) {
                    sb.append(a2).append(": ").append(str).append("\r\n");
                }
            }
            sb.append(a2).append(": ").append(format).append("\r\n");
            k.A(sb.toString(), false);
            com.baidu.swan.apps.statistic.search.b.a(new SearchFlowEvent("nreach", System.currentTimeMillis(), "swan_error", "", SearchFlowEvent.EventType.END));
            com.baidu.swan.apps.statistic.b.c.c(new com.baidu.swan.apps.statistic.b.a(BdStatsConstant.StatsType.ERROR, String.valueOf(System.currentTimeMillis()), String.valueOf(aVar.TP())));
            if (com.baidu.swan.apps.b.DEBUG) {
                String UD = ac.UD();
                if (!TextUtils.isEmpty(UD) && (Uf = f.Uf()) != null) {
                    File file = new File(Uf.getPath(), "error_dialog_info.txt");
                    com.baidu.swan.c.a.deleteFile(file);
                    StringBuilder sb2 = new StringBuilder("");
                    if (!TextUtils.isEmpty(format)) {
                        sb2.append(format).append("\n");
                    }
                    sb2.append(UD).append("\n");
                    com.baidu.swan.c.a.b(sb2.toString(), file);
                }
            }
        }
    }

    private static boolean a(@NonNull Context context, @Nullable c cVar) {
        return (cVar == null || TextUtils.isEmpty(cVar.mAppId) || SwanAppNetworkUtils.isNetworkConnected(context) || com.baidu.swan.apps.v.d.a.Q(context, cVar.mAppId)) ? false : true;
    }

    private static void fr(@NonNull String str) {
        if (!abS) {
            if (DEBUG) {
                Log.d("LaunchError", "show normal err dialog");
            }
            SwanAppErrorDialog.UX().en(a.h.aiapps_open_failed_title).a(new DialogInterface.OnDismissListener() { // from class: com.baidu.swan.apps.v.a.a.1
                @Override // android.content.DialogInterface.OnDismissListener
                public void onDismiss(DialogInterface dialogInterface) {
                    boolean unused = a.abS = false;
                }
            }).hf(str).a(a.h.aiapps_open_failed_button, (DialogInterface.OnClickListener) null).show();
            abS = true;
        }
    }

    private static void b(@NonNull Context context, @NonNull String str, @NonNull com.baidu.swan.apps.ak.a aVar) {
        String format = String.format(context.getResources().getString(a.h.swanapp_launch_err_tip), ac.getVersionName(), str, String.valueOf(aVar.TP()));
        if (DEBUG) {
            Log.d("LaunchError", "show normal err toast: " + format);
        }
        d.a(AppRuntime.getAppContext(), format).QO();
    }
}
