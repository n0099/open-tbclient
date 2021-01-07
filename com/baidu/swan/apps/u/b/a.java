package com.baidu.swan.apps.u.b;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.ActivityChooserView;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.process.ipc.delegate.DelegateUtils;
import com.baidu.searchbox.process.ipc.delegate.provider.ProviderDelegation;
import com.baidu.searchbox.process.ipc.util.ProcessUtils;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.SwanAppErrorActivity;
import com.baidu.swan.apps.a;
import com.baidu.swan.apps.ao.ak;
import com.baidu.swan.apps.ao.j;
import com.baidu.swan.apps.ao.k;
import com.baidu.swan.apps.ao.q;
import com.baidu.swan.apps.ao.x;
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
/* loaded from: classes9.dex */
public class a {
    private static final boolean DEBUG = b.DEBUG;
    private static boolean isShowing = false;
    private static final long dit = TimeUnit.SECONDS.toMillis(1);

    public static void a(Context context, @NonNull com.baidu.swan.apps.al.a aVar, int i, String str) {
        a(context, aVar, i, str, (Bundle) null);
    }

    public static void a(Context context, @NonNull com.baidu.swan.apps.al.a aVar, int i, String str, Bundle bundle) {
        i.d(aVar);
        a(context, aVar, i, str, false, bundle);
    }

    public static void a(Context context, @NonNull com.baidu.swan.apps.al.a aVar, int i, String str, boolean z) {
        a(context, aVar, i, str, z, (Bundle) null);
    }

    public static void a(Context context, @NonNull com.baidu.swan.apps.al.a aVar, int i, String str, boolean z, Bundle bundle) {
        File aRn;
        if (context != null) {
            if ((context instanceof SwanAppActivity) && ((SwanAppActivity) context).isDestroyed()) {
                c.bs("LaunchError", "launch activity closed, ignore launch error");
                return;
            }
            c.bs("LaunchError", "handleLaunchError errCode: " + aVar.toString());
            String a2 = com.baidu.swan.apps.swancore.b.a(f.aDH().aDj(), i);
            long aQC = aVar.aQC();
            String aQE = aVar.aQE();
            boolean z2 = 1020 == aQC && !TextUtils.isEmpty(aQE);
            String du = z2 ? aQE : e.bhm().du(aQC);
            String format = String.format(context.getResources().getString(a.h.aiapps_open_failed_detail_format), ak.getVersionName(), a2, String.valueOf(aVar.aQG()));
            if (!com.baidu.swan.apps.t.a.aBa().a(context, str, aVar)) {
                if (i == 0) {
                    a(context, str, du, format, bundle);
                } else if (i == 1) {
                    a(context, str, du, z2 ? aQE : e.bhm().dv(aQC), format, z ? SwanAppProcessInfo.current().index : SwanAppProcessInfo.UNKNOWN.index);
                }
            }
            StringBuilder sb = new StringBuilder();
            String a3 = j.a(j.aRm(), "yyyy-MM-dd HH:mm:ss");
            if (!TextUtils.isEmpty(str)) {
                sb.append(a3).append(": ").append(str).append("\r\n");
            }
            sb.append(a3).append(": ").append(format).append("\r\n");
            q.aj(sb.toString(), false);
            com.baidu.swan.apps.statistic.search.b.a(new SearchFlowEvent("nreach", System.currentTimeMillis(), "swan_error", "", SearchFlowEvent.EventType.END));
            if (b.DEBUG) {
                String stackTrace = ak.getStackTrace();
                if (!TextUtils.isEmpty(stackTrace) && (aRn = k.aRn()) != null) {
                    File file = new File(aRn.getPath(), "error_dialog_info.txt");
                    d.deleteFile(file);
                    StringBuilder sb2 = new StringBuilder();
                    if (!TextUtils.isEmpty(format)) {
                        sb2.append(format).append("\n");
                    }
                    sb2.append(stackTrace).append("\n");
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
        intent.putExtra("swan_error_type", aj(context, str) ? "type_network_error" : "type_normal");
        com.baidu.swan.apps.runtime.e aMm = com.baidu.swan.apps.runtime.e.aMm();
        if (aMm != null) {
            ForbiddenInfo forbiddenInfo = new ForbiddenInfo(aMm.aMp(), str2, str3);
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
        if (aj(context, str)) {
            if (x.dy(context)) {
                com.baidu.swan.apps.res.widget.b.d.u(AppRuntime.getAppContext(), a.h.aiapps_net_error).aLT();
                return;
            }
            if (DEBUG) {
                Log.w("LaunchError", "show network err toast: areNotificationsEnabled false");
            }
            g(str2, str4, i);
        } else if (x.dy(context)) {
            q(context, str3, str4);
        } else {
            if (DEBUG) {
                Log.w("LaunchError", "handleLaunchError: areNotificationsEnabled false");
            }
            g(str2, str4, i);
        }
    }

    private static boolean aj(@NonNull Context context, @Nullable String str) {
        return (TextUtils.isEmpty(str) || SwanAppNetworkUtils.isNetworkConnected(context) || com.baidu.swan.apps.u.f.a.qe(str)) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void g(final String str, final String str2, final int i) {
        if (!TextUtils.isEmpty(str) || !TextUtils.isEmpty(str2)) {
            if (!ProcessUtils.isMainProcess()) {
                Bundle bundle = new Bundle();
                bundle.putString("arg_title", str);
                bundle.putString("arg_message", str2);
                bundle.putInt("arg_match_target_down", i);
                DelegateUtils.callOnMainWithContentProvider(com.baidu.swan.apps.t.a.aAs(), C0494a.class, bundle);
                return;
            }
            if (DEBUG) {
                Log.d("LaunchError", "show normal err dialog, isShowing=" + isShowing);
            }
            if (!SwanAppProcessInfo.checkProcessId(i)) {
                bX(str, str2);
                return;
            }
            final HashSet R = com.facebook.common.internal.i.R("event_puppet_unload_app", "event_puppet_offline");
            com.baidu.swan.apps.process.messaging.service.e.aJM().a(new com.baidu.swan.apps.process.messaging.service.a() { // from class: com.baidu.swan.apps.u.b.a.1
                @Override // com.baidu.swan.apps.process.messaging.service.a
                public void c(String str3, com.baidu.swan.apps.process.messaging.service.c cVar) {
                    if (cVar.dwt.index == i && R.contains(str3)) {
                        com.baidu.swan.apps.process.messaging.service.e.aJM().a(this);
                        a.bX(str, str2);
                    }
                }

                @Override // com.baidu.swan.apps.process.messaging.service.a
                public void axg() {
                    a.bX(str, str2);
                }
            }, dit);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void bX(String str, String str2) {
        if (!isShowing) {
            SwanAppErrorDialog.aSy().sl(str).b(new DialogInterface.OnDismissListener() { // from class: com.baidu.swan.apps.u.b.a.2
                @Override // android.content.DialogInterface.OnDismissListener
                public void onDismiss(DialogInterface dialogInterface) {
                    boolean unused = a.isShowing = false;
                }
            }).sm(str2).a(a.h.aiapps_open_failed_button, (DialogInterface.OnClickListener) null).show();
            isShowing = true;
        }
    }

    private static void q(@NonNull Context context, @NonNull String str, @NonNull String str2) {
        String format = String.format(context.getResources().getString(a.h.swanapp_launch_err_toast_format), str, str2);
        if (DEBUG) {
            Log.d("LaunchError", "show normal err toast: " + format);
        }
        com.baidu.swan.apps.res.widget.b.d.a(AppRuntime.getAppContext(), format).kI(ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED).aLU();
    }

    /* renamed from: com.baidu.swan.apps.u.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public static class C0494a extends ProviderDelegation {
        @Override // com.baidu.searchbox.process.ipc.delegate.provider.ProviderDelegation
        public Bundle execCall(Bundle bundle) {
            if (bundle != null) {
                a.g(bundle.getString("arg_title"), bundle.getString("arg_message"), bundle.getInt("arg_match_target_down", SwanAppProcessInfo.UNKNOWN.index));
                return null;
            }
            return null;
        }
    }
}
