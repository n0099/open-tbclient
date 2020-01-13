package com.baidu.swan.apps.x.a;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.android.util.time.DateTimeUtil;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.process.ipc.delegate.DelegateUtils;
import com.baidu.searchbox.process.ipc.delegate.provider.ProviderDelegation;
import com.baidu.searchbox.process.ipc.util.ProcessUtils;
import com.baidu.searchbox.unitedscheme.SchemeRouter;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.a;
import com.baidu.swan.apps.as.ai;
import com.baidu.swan.apps.as.h;
import com.baidu.swan.apps.as.i;
import com.baidu.swan.apps.as.n;
import com.baidu.swan.apps.as.u;
import com.baidu.swan.apps.network.SwanAppNetworkUtils;
import com.baidu.swan.apps.process.SwanAppProcessInfo;
import com.baidu.swan.apps.process.messaging.service.e;
import com.baidu.swan.apps.res.widget.b.d;
import com.baidu.swan.apps.statistic.search.SearchFlowEvent;
import com.baidu.swan.apps.view.SwanAppErrorDialog;
import com.baidu.swan.apps.y.f;
import com.baidu.swan.config.d.c;
import java.io.File;
import java.util.HashSet;
import java.util.concurrent.TimeUnit;
/* loaded from: classes10.dex */
public class a {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static boolean isShowing = false;
    private static final long bua = TimeUnit.SECONDS.toMillis(1);

    public static void a(Context context, @NonNull com.baidu.swan.apps.ap.a aVar, int i, String str) {
        a(context, aVar, i, str, false);
    }

    public static void a(Context context, @NonNull com.baidu.swan.apps.ap.a aVar, int i, String str, boolean z) {
        File aes;
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
            String a = com.baidu.swan.apps.swancore.b.a(f.UC().Uf(), i);
            String aP = c.agS().aP(aVar.adR());
            String aQ = c.agS().aQ(aVar.adR());
            String format = String.format(context.getResources().getString(a.h.aiapps_open_failed_detail_format), ai.getVersionName(), a, String.valueOf(aVar.adU()));
            int i2 = z ? SwanAppProcessInfo.current().index : SwanAppProcessInfo.UNKNOWN.index;
            if (!com.baidu.swan.apps.w.a.Sn().a(str, aVar)) {
                if (al(context, str)) {
                    if (DEBUG) {
                        Log.d("LaunchError", "show network err toast");
                    }
                    if (u.cw(context)) {
                        d.q(AppRuntime.getAppContext(), a.h.aiapps_net_error).showToast();
                    } else {
                        if (DEBUG) {
                            Log.w("LaunchError", "show network err toast: areNotificationsEnabled false");
                        }
                        e(aP, format, i2);
                    }
                } else if (b.hU(str)) {
                    if (DEBUG) {
                        Log.d("LaunchError", "execute swan new year h5 downgrade  => h5 downgrade");
                    }
                    SchemeRouter.invoke(AppRuntime.getAppContext(), b.Ta());
                } else if (u.cw(context)) {
                    m(context, aQ, format);
                } else {
                    if (DEBUG) {
                        Log.w("LaunchError", "handleLaunchError: areNotificationsEnabled false");
                    }
                    e(aP, format, i2);
                }
            }
            StringBuilder sb = new StringBuilder();
            String formatDate = h.getFormatDate(h.getCurrDate(), DateTimeUtil.TIME_FORMAT);
            if (!TextUtils.isEmpty(str)) {
                sb.append(formatDate).append(": ").append(str).append("\r\n");
            }
            sb.append(formatDate).append(": ").append(format).append("\r\n");
            n.E(sb.toString(), false);
            com.baidu.swan.apps.statistic.search.b.a(new SearchFlowEvent("nreach", System.currentTimeMillis(), "swan_error", "", SearchFlowEvent.EventType.END));
            if (com.baidu.swan.apps.b.DEBUG) {
                String aeN = ai.aeN();
                if (!TextUtils.isEmpty(aeN) && (aes = i.aes()) != null) {
                    File file = new File(aes.getPath(), "error_dialog_info.txt");
                    com.baidu.swan.d.c.deleteFile(file);
                    StringBuilder sb2 = new StringBuilder("");
                    if (!TextUtils.isEmpty(format)) {
                        sb2.append(format).append("\n");
                    }
                    sb2.append(aeN).append("\n");
                    com.baidu.swan.d.c.saveFile(sb2.toString(), file);
                }
            }
        }
    }

    private static boolean al(@NonNull Context context, @Nullable String str) {
        return (TextUtils.isEmpty(str) || SwanAppNetworkUtils.isNetworkConnected(context) || com.baidu.swan.apps.x.d.a.iC(str)) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void e(final String str, final String str2, final int i) {
        if (!TextUtils.isEmpty(str) || !TextUtils.isEmpty(str2)) {
            if (!ProcessUtils.isMainProcess()) {
                Bundle bundle = new Bundle();
                bundle.putString("arg_title", str);
                bundle.putString("arg_message", str2);
                bundle.putInt("arg_match_target_down", i);
                DelegateUtils.callOnMainWithContentProvider(com.baidu.swan.apps.w.a.RG(), C0298a.class, bundle);
                return;
            }
            if (DEBUG) {
                Log.d("LaunchError", "show normal err dialog, isShowing=" + isShowing);
            }
            if (!SwanAppProcessInfo.checkProcessId(i)) {
                aG(str, str2);
                return;
            }
            final HashSet K = com.facebook.common.internal.i.K("event_puppet_unload_app", "event_puppet_offline");
            e.Ze().a(new com.baidu.swan.apps.process.messaging.service.a() { // from class: com.baidu.swan.apps.x.a.a.1
                @Override // com.baidu.swan.apps.process.messaging.service.a
                public void b(String str3, com.baidu.swan.apps.process.messaging.service.c cVar) {
                    if (cVar.bFt.index == i && K.contains(str3)) {
                        e.Ze().a(this);
                        a.aG(str, str2);
                    }
                }

                @Override // com.baidu.swan.apps.process.messaging.service.a
                public void SZ() {
                    a.aG(str, str2);
                }
            }, bua);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void aG(String str, String str2) {
        if (!isShowing) {
            SwanAppErrorDialog.afi().kq(str).a(new DialogInterface.OnDismissListener() { // from class: com.baidu.swan.apps.x.a.a.2
                @Override // android.content.DialogInterface.OnDismissListener
                public void onDismiss(DialogInterface dialogInterface) {
                    boolean unused = a.isShowing = false;
                }
            }).kr(str2).a(a.h.aiapps_open_failed_button, (DialogInterface.OnClickListener) null).show();
            isShowing = true;
        }
    }

    private static void m(@NonNull Context context, @NonNull String str, @NonNull String str2) {
        String format = String.format(context.getResources().getString(a.h.swanapp_launch_err_toast_format), str, str2);
        if (DEBUG) {
            Log.d("LaunchError", "show normal err toast: " + format);
        }
        d.a(AppRuntime.getAppContext(), format).fN(Integer.MAX_VALUE).showMultiToast();
    }

    /* renamed from: com.baidu.swan.apps.x.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes10.dex */
    public static class C0298a extends ProviderDelegation {
        @Override // com.baidu.searchbox.process.ipc.delegate.provider.ProviderDelegation
        public Bundle execCall(Bundle bundle) {
            if (bundle != null) {
                a.e(bundle.getString("arg_title"), bundle.getString("arg_message"), bundle.getInt("arg_match_target_down", SwanAppProcessInfo.UNKNOWN.index));
                return null;
            }
            return null;
        }
    }
}
