package com.baidu.swan.apps.u.b;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.ActivityChooserView;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.process.ipc.delegate.DelegateUtils;
import com.baidu.searchbox.process.ipc.delegate.provider.ProviderDelegation;
import com.baidu.searchbox.process.ipc.util.ProcessUtils;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.SwanAppErrorActivity;
import com.baidu.swan.apps.a;
import com.baidu.swan.apps.ap.ak;
import com.baidu.swan.apps.ap.j;
import com.baidu.swan.apps.ap.k;
import com.baidu.swan.apps.ap.q;
import com.baidu.swan.apps.ap.x;
import com.baidu.swan.apps.b;
import com.baidu.swan.apps.console.c;
import com.baidu.swan.apps.network.SwanAppNetworkUtils;
import com.baidu.swan.apps.performance.i;
import com.baidu.swan.apps.process.SwanAppProcessInfo;
import com.baidu.swan.apps.scheme.actions.forbidden.ForbiddenInfo;
import com.baidu.swan.apps.statistic.search.SearchFlowEvent;
import com.baidu.swan.apps.v.f;
import com.baidu.swan.apps.view.SwanAppErrorDialog;
import com.baidu.swan.c.d;
import com.baidu.swan.pms.node.b.e;
import java.io.File;
import java.util.HashSet;
import java.util.concurrent.TimeUnit;
/* loaded from: classes8.dex */
public class a {
    private static final boolean DEBUG = b.DEBUG;
    private static boolean isShowing = false;
    private static final long cvP = TimeUnit.SECONDS.toMillis(1);

    public static void a(Context context, @NonNull com.baidu.swan.apps.am.a aVar, int i, String str) {
        a(context, aVar, i, str, (Bundle) null);
    }

    public static void a(Context context, @NonNull com.baidu.swan.apps.am.a aVar, int i, String str, Bundle bundle) {
        i.d(aVar);
        a(context, aVar, i, str, false, bundle);
    }

    public static void a(Context context, @NonNull com.baidu.swan.apps.am.a aVar, int i, String str, boolean z) {
        a(context, aVar, i, str, z, (Bundle) null);
    }

    public static void a(Context context, @NonNull com.baidu.swan.apps.am.a aVar, int i, String str, boolean z, Bundle bundle) {
        File aEJ;
        if (context != null) {
            if ((context instanceof SwanAppActivity) && ((SwanAppActivity) context).isDestroyed()) {
                c.bb("LaunchError", "launch activity closed, ignore launch error");
                return;
            }
            c.bb("LaunchError", "handleLaunchError errCode: " + aVar.toString());
            String a = com.baidu.swan.apps.swancore.b.a(f.arY().arA(), i);
            long aDY = aVar.aDY();
            String aEa = aVar.aEa();
            boolean z2 = 1020 == aDY && !TextUtils.isEmpty(aEa);
            String co = z2 ? aEa : e.aUE().co(aDY);
            String format = String.format(context.getResources().getString(a.h.aiapps_open_failed_detail_format), ak.getVersionName(), a, String.valueOf(aVar.aEc()));
            if (!com.baidu.swan.apps.t.a.aps().a(context, str, aVar)) {
                if (i == 0) {
                    a(context, str, co, format, bundle);
                } else if (i == 1) {
                    a(context, str, co, z2 ? aEa : e.aUE().cp(aDY), format, z ? SwanAppProcessInfo.current().index : SwanAppProcessInfo.UNKNOWN.index);
                }
            }
            StringBuilder sb = new StringBuilder();
            String a2 = j.a(j.aEI(), "yyyy-MM-dd HH:mm:ss");
            if (!TextUtils.isEmpty(str)) {
                sb.append(a2).append(": ").append(str).append("\r\n");
            }
            sb.append(a2).append(": ").append(format).append("\r\n");
            q.ac(sb.toString(), false);
            com.baidu.swan.apps.statistic.search.b.a(new SearchFlowEvent("nreach", System.currentTimeMillis(), "swan_error", "", SearchFlowEvent.EventType.END));
            if (b.DEBUG) {
                String aFi = ak.aFi();
                if (!TextUtils.isEmpty(aFi) && (aEJ = k.aEJ()) != null) {
                    File file = new File(aEJ.getPath(), "error_dialog_info.txt");
                    d.deleteFile(file);
                    StringBuilder sb2 = new StringBuilder();
                    if (!TextUtils.isEmpty(format)) {
                        sb2.append(format).append("\n");
                    }
                    sb2.append(aFi).append("\n");
                    d.saveFile(sb2.toString(), file);
                }
            }
        }
    }

    private static void a(Context context, String str, String str2, String str3, Bundle bundle) {
        Intent intent = new Intent();
        if (bundle != null) {
            intent.putExtras(bundle);
        }
        intent.putExtra("swan_error_type", W(context, str) ? "type_network_error" : "type_normal");
        com.baidu.swan.apps.runtime.e azJ = com.baidu.swan.apps.runtime.e.azJ();
        if (azJ != null) {
            ForbiddenInfo forbiddenInfo = new ForbiddenInfo(azJ.azM(), str2, str3);
            forbiddenInfo.enableSlidingFlag = -1;
            intent.putExtra("swan_error_forbidden_info", forbiddenInfo);
        }
        intent.setComponent(new ComponentName(context, SwanAppErrorActivity.class));
        if (!(context instanceof Activity)) {
            intent.addFlags(268435456);
        }
        context.startActivity(intent);
    }

    private static void a(Context context, String str, String str2, String str3, String str4, int i) {
        if (W(context, str)) {
            if (x.cx(context)) {
                com.baidu.swan.apps.res.widget.b.d.k(AppRuntime.getAppContext(), a.h.aiapps_net_error).showToast();
                return;
            }
            if (DEBUG) {
                Log.w("LaunchError", "show network err toast: areNotificationsEnabled false");
            }
            c(str2, str4, i);
        } else if (x.cx(context)) {
            n(context, str3, str4);
        } else {
            if (DEBUG) {
                Log.w("LaunchError", "handleLaunchError: areNotificationsEnabled false");
            }
            c(str2, str4, i);
        }
    }

    private static boolean W(@NonNull Context context, @Nullable String str) {
        return (TextUtils.isEmpty(str) || SwanAppNetworkUtils.isNetworkConnected(context) || com.baidu.swan.apps.u.f.a.nW(str)) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void c(final String str, final String str2, final int i) {
        if (!TextUtils.isEmpty(str) || !TextUtils.isEmpty(str2)) {
            if (!ProcessUtils.isMainProcess()) {
                Bundle bundle = new Bundle();
                bundle.putString("arg_title", str);
                bundle.putString("arg_message", str2);
                bundle.putInt("arg_match_target_down", i);
                DelegateUtils.callOnMainWithContentProvider(com.baidu.swan.apps.t.a.aoJ(), C0453a.class, bundle);
                return;
            }
            if (DEBUG) {
                Log.d("LaunchError", "show normal err dialog, isShowing=" + isShowing);
            }
            if (!SwanAppProcessInfo.checkProcessId(i)) {
                bG(str, str2);
                return;
            }
            final HashSet N = com.facebook.common.internal.i.N("event_puppet_unload_app", "event_puppet_offline");
            com.baidu.swan.apps.process.messaging.service.e.ayg().a(new com.baidu.swan.apps.process.messaging.service.a() { // from class: com.baidu.swan.apps.u.b.a.1
                @Override // com.baidu.swan.apps.process.messaging.service.a
                public void c(String str3, com.baidu.swan.apps.process.messaging.service.c cVar) {
                    if (cVar.cJD.index == i && N.contains(str3)) {
                        com.baidu.swan.apps.process.messaging.service.e.ayg().a(this);
                        a.bG(str, str2);
                    }
                }

                @Override // com.baidu.swan.apps.process.messaging.service.a
                public void alw() {
                    a.bG(str, str2);
                }
            }, cvP);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void bG(String str, String str2) {
        if (!isShowing) {
            SwanAppErrorDialog.aFR().qb(str).a(new DialogInterface.OnDismissListener() { // from class: com.baidu.swan.apps.u.b.a.2
                @Override // android.content.DialogInterface.OnDismissListener
                public void onDismiss(DialogInterface dialogInterface) {
                    boolean unused = a.isShowing = false;
                }
            }).qc(str2).a(a.h.aiapps_open_failed_button, (DialogInterface.OnClickListener) null).show();
            isShowing = true;
        }
    }

    private static void n(@NonNull Context context, @NonNull String str, @NonNull String str2) {
        String format = String.format(context.getResources().getString(a.h.swanapp_launch_err_toast_format), str, str2);
        if (DEBUG) {
            Log.d("LaunchError", "show normal err toast: " + format);
        }
        com.baidu.swan.apps.res.widget.b.d.a(AppRuntime.getAppContext(), format).jf(ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED).showMultiToast();
    }

    /* renamed from: com.baidu.swan.apps.u.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public static class C0453a extends ProviderDelegation {
        @Override // com.baidu.searchbox.process.ipc.delegate.provider.ProviderDelegation
        public Bundle execCall(Bundle bundle) {
            if (bundle != null) {
                a.c(bundle.getString("arg_title"), bundle.getString("arg_message"), bundle.getInt("arg_match_target_down", SwanAppProcessInfo.UNKNOWN.index));
                return null;
            }
            return null;
        }
    }
}
