package com.baidu.swan.apps.v.a;

import android.content.Context;
import android.content.DialogInterface;
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
import com.baidu.searchbox.unitedscheme.SchemeRouter;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.a;
import com.baidu.swan.apps.aq.aj;
import com.baidu.swan.apps.aq.i;
import com.baidu.swan.apps.aq.j;
import com.baidu.swan.apps.aq.o;
import com.baidu.swan.apps.aq.v;
import com.baidu.swan.apps.network.SwanAppNetworkUtils;
import com.baidu.swan.apps.performance.g;
import com.baidu.swan.apps.process.SwanAppProcessInfo;
import com.baidu.swan.apps.process.messaging.service.c;
import com.baidu.swan.apps.res.widget.b.d;
import com.baidu.swan.apps.statistic.search.SearchFlowEvent;
import com.baidu.swan.apps.view.SwanAppErrorDialog;
import com.baidu.swan.apps.w.f;
import com.baidu.swan.pms.node.b.e;
import java.io.File;
import java.util.HashSet;
import java.util.concurrent.TimeUnit;
/* loaded from: classes11.dex */
public class a {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static boolean isShowing = false;
    private static final long chj = TimeUnit.SECONDS.toMillis(1);

    public static void a(Context context, @NonNull com.baidu.swan.apps.an.a aVar, int i, String str) {
        g.a(aVar);
        a(context, aVar, i, str, false);
    }

    public static void a(Context context, @NonNull com.baidu.swan.apps.an.a aVar, int i, String str, boolean z) {
        File atr;
        if (context != null) {
            if ((context instanceof SwanAppActivity) && ((SwanAppActivity) context).isDestroyed()) {
                if (DEBUG) {
                    Log.d("LaunchError", "launcher activity closed, ignore launch err");
                    return;
                }
                return;
            }
            if (DEBUG) {
                Log.d("LaunchError", "start handleLaunchError errCode: " + aVar.toString());
            }
            String a = com.baidu.swan.apps.swancore.b.a(f.ahV().ahx(), i);
            long asI = aVar.asI();
            String asK = aVar.asK();
            boolean z2 = 1020 == asI && !TextUtils.isEmpty(asK);
            String bP = z2 ? asK : e.aHh().bP(asI);
            if (!z2) {
                asK = e.aHh().bQ(asI);
            }
            String format = String.format(context.getResources().getString(a.h.aiapps_open_failed_detail_format), aj.getVersionName(), a, String.valueOf(aVar.asM()));
            int i2 = z ? SwanAppProcessInfo.current().index : SwanAppProcessInfo.UNKNOWN.index;
            if (!com.baidu.swan.apps.u.a.afx().a(str, aVar)) {
                if (T(context, str)) {
                    if (DEBUG) {
                        Log.d("LaunchError", "show network err toast");
                    }
                    if (v.cn(context)) {
                        d.k(AppRuntime.getAppContext(), a.h.aiapps_net_error).showToast();
                    } else {
                        if (DEBUG) {
                            Log.w("LaunchError", "show network err toast: areNotificationsEnabled false");
                        }
                        c(bP, format, i2);
                    }
                } else if (b.kH(str)) {
                    if (DEBUG) {
                        Log.d("LaunchError", "execute swan new year h5 downgrade  => h5 downgrade");
                    }
                    SchemeRouter.invoke(AppRuntime.getAppContext(), b.agr());
                } else if (v.cn(context)) {
                    o(context, asK, format);
                } else {
                    if (DEBUG) {
                        Log.w("LaunchError", "handleLaunchError: areNotificationsEnabled false");
                    }
                    c(bP, format, i2);
                }
            }
            StringBuilder sb = new StringBuilder();
            String a2 = i.a(i.atq(), "yyyy-MM-dd HH:mm:ss");
            if (!TextUtils.isEmpty(str)) {
                sb.append(a2).append(": ").append(str).append("\r\n");
            }
            sb.append(a2).append(": ").append(format).append("\r\n");
            o.W(sb.toString(), false);
            com.baidu.swan.apps.statistic.search.b.a(new SearchFlowEvent("nreach", System.currentTimeMillis(), "swan_error", "", SearchFlowEvent.EventType.END));
            if (com.baidu.swan.apps.b.DEBUG) {
                String atN = aj.atN();
                if (!TextUtils.isEmpty(atN) && (atr = j.atr()) != null) {
                    File file = new File(atr.getPath(), "error_dialog_info.txt");
                    com.baidu.swan.e.d.deleteFile(file);
                    StringBuilder sb2 = new StringBuilder("");
                    if (!TextUtils.isEmpty(format)) {
                        sb2.append(format).append("\n");
                    }
                    sb2.append(atN).append("\n");
                    com.baidu.swan.e.d.saveFile(sb2.toString(), file);
                }
            }
        }
    }

    private static boolean T(@NonNull Context context, @Nullable String str) {
        return (TextUtils.isEmpty(str) || SwanAppNetworkUtils.isNetworkConnected(context) || com.baidu.swan.apps.v.d.a.lp(str)) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void c(final String str, final String str2, final int i) {
        if (!TextUtils.isEmpty(str) || !TextUtils.isEmpty(str2)) {
            if (!ProcessUtils.isMainProcess()) {
                Bundle bundle = new Bundle();
                bundle.putString("arg_title", str);
                bundle.putString("arg_message", str2);
                bundle.putInt("arg_match_target_down", i);
                DelegateUtils.callOnMainWithContentProvider(com.baidu.swan.apps.u.a.aeR(), C0395a.class, bundle);
                return;
            }
            if (DEBUG) {
                Log.d("LaunchError", "show normal err dialog, isShowing=" + isShowing);
            }
            if (!SwanAppProcessInfo.checkProcessId(i)) {
                bp(str, str2);
                return;
            }
            final HashSet O = com.facebook.common.internal.i.O("event_puppet_unload_app", "event_puppet_offline");
            com.baidu.swan.apps.process.messaging.service.e.anp().a(new com.baidu.swan.apps.process.messaging.service.a() { // from class: com.baidu.swan.apps.v.a.a.1
                @Override // com.baidu.swan.apps.process.messaging.service.a
                public void b(String str3, c cVar) {
                    if (cVar.cud.index == i && O.contains(str3)) {
                        com.baidu.swan.apps.process.messaging.service.e.anp().a(this);
                        a.bp(str, str2);
                    }
                }

                @Override // com.baidu.swan.apps.process.messaging.service.a
                public void agq() {
                    a.bp(str, str2);
                }
            }, chj);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void bp(String str, String str2) {
        if (!isShowing) {
            SwanAppErrorDialog.aup().nm(str).a(new DialogInterface.OnDismissListener() { // from class: com.baidu.swan.apps.v.a.a.2
                @Override // android.content.DialogInterface.OnDismissListener
                public void onDismiss(DialogInterface dialogInterface) {
                    boolean unused = a.isShowing = false;
                }
            }).nn(str2).a(a.h.aiapps_open_failed_button, (DialogInterface.OnClickListener) null).show();
            isShowing = true;
        }
    }

    private static void o(@NonNull Context context, @NonNull String str, @NonNull String str2) {
        String format = String.format(context.getResources().getString(a.h.swanapp_launch_err_toast_format), str, str2);
        if (DEBUG) {
            Log.d("LaunchError", "show normal err toast: " + format);
        }
        d.a(AppRuntime.getAppContext(), format).gE(ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED).showMultiToast();
    }

    /* renamed from: com.baidu.swan.apps.v.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    public static class C0395a extends ProviderDelegation {
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
