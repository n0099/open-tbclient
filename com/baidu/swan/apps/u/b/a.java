package com.baidu.swan.apps.u.b;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.SwanAppErrorActivity;
import com.baidu.swan.apps.a;
import com.baidu.swan.apps.aq.al;
import com.baidu.swan.apps.aq.j;
import com.baidu.swan.apps.aq.k;
import com.baidu.swan.apps.aq.q;
import com.baidu.swan.apps.b;
import com.baidu.swan.apps.console.c;
import com.baidu.swan.apps.network.SwanAppNetworkUtils;
import com.baidu.swan.apps.performance.i;
import com.baidu.swan.apps.scheme.actions.forbidden.ForbiddenInfo;
import com.baidu.swan.apps.statistic.search.SearchFlowEvent;
import com.baidu.swan.apps.v.f;
import com.baidu.swan.d.d;
import com.baidu.swan.pms.node.b.e;
import java.io.File;
import java.util.concurrent.TimeUnit;
/* loaded from: classes7.dex */
public class a {
    private static final boolean DEBUG = b.DEBUG;
    private static boolean isShowing = false;
    private static final long cof = TimeUnit.SECONDS.toMillis(1);

    public static void a(Context context, @NonNull com.baidu.swan.apps.an.a aVar, int i, String str) {
        i.a(aVar);
        a(context, aVar, i, str, false);
    }

    public static void a(Context context, @NonNull com.baidu.swan.apps.an.a aVar, int i, String str, boolean z) {
        File awz;
        if (context != null) {
            if ((context instanceof SwanAppActivity) && ((SwanAppActivity) context).isDestroyed()) {
                c.aW("LaunchError", "launch activity closed, ignore launch error");
                return;
            }
            c.aW("LaunchError", "handleLaunchError errCode: " + aVar.toString());
            String a = com.baidu.swan.apps.swancore.b.a(f.akr().ajT(), i);
            long avP = aVar.avP();
            String avR = aVar.avR();
            if (!(1020 == avP && !TextUtils.isEmpty(avR))) {
                avR = e.aMf().cf(avP);
            }
            String format = String.format(context.getResources().getString(a.h.aiapps_open_failed_detail_format), al.getVersionName(), a, String.valueOf(aVar.avT()));
            if (!com.baidu.swan.apps.t.a.ahQ().a(context, str, aVar)) {
                Intent intent = new Intent();
                intent.putExtra("swan_error_type", T(context, str) ? "type_network_error" : "type_normal");
                com.baidu.swan.apps.runtime.e arw = com.baidu.swan.apps.runtime.e.arw();
                if (arw != null) {
                    ForbiddenInfo forbiddenInfo = new ForbiddenInfo(arw.arz(), avR, format);
                    forbiddenInfo.enableSlidingFlag = -1;
                    intent.putExtra("swan_error_forbidden_info", forbiddenInfo);
                }
                intent.setComponent(new ComponentName(context, SwanAppErrorActivity.class));
                if (!(context instanceof Activity)) {
                    intent.addFlags(268435456);
                }
                context.startActivity(intent);
            }
            StringBuilder sb = new StringBuilder();
            String a2 = j.a(j.awy(), "yyyy-MM-dd HH:mm:ss");
            if (!TextUtils.isEmpty(str)) {
                sb.append(a2).append(": ").append(str).append("\r\n");
            }
            sb.append(a2).append(": ").append(format).append("\r\n");
            q.X(sb.toString(), false);
            com.baidu.swan.apps.statistic.search.b.a(new SearchFlowEvent("nreach", System.currentTimeMillis(), "swan_error", "", SearchFlowEvent.EventType.END));
            if (b.DEBUG) {
                String awZ = al.awZ();
                if (!TextUtils.isEmpty(awZ) && (awz = k.awz()) != null) {
                    File file = new File(awz.getPath(), "error_dialog_info.txt");
                    d.deleteFile(file);
                    StringBuilder sb2 = new StringBuilder();
                    if (!TextUtils.isEmpty(format)) {
                        sb2.append(format).append("\n");
                    }
                    sb2.append(awZ).append("\n");
                    d.saveFile(sb2.toString(), file);
                }
            }
        }
    }

    private static boolean T(@NonNull Context context, @Nullable String str) {
        return (TextUtils.isEmpty(str) || SwanAppNetworkUtils.isNetworkConnected(context) || com.baidu.swan.apps.u.e.a.lY(str)) ? false : true;
    }
}
