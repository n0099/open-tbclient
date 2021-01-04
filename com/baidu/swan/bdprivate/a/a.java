package com.baidu.swan.bdprivate.a;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.android.util.io.BaseJsonData;
import com.baidu.live.tbadk.core.data.RequestResponseCode;
import com.baidu.live.tbadk.core.util.TiebaInitialize;
import com.baidu.searchbox.process.ipc.agent.activity.MainProcessDelegateActivity;
import com.baidu.searchbox.process.ipc.agent.activity.PluginDelegateActivity;
import com.baidu.searchbox.process.ipc.delegate.DelegateListener;
import com.baidu.searchbox.process.ipc.delegate.DelegateResult;
import com.baidu.searchbox.process.ipc.delegate.DelegateUtils;
import com.baidu.searchbox.process.ipc.util.ProcessUtils;
import com.baidu.swan.apps.ao.ak;
import com.baidu.swan.apps.res.widget.dialog.g;
import com.baidu.swan.bdprivate.a.l;
import com.baidu.swan.bdprivate.api.b;
import com.baidu.swan.bdprivate.b;
import com.baidu.swan.bdprivate.b.a;
import com.baidu.swan.bdprivate.d.a;
import com.baidu.swan.bdprivate.extensions.loginauthmobile.SwanAppPhoneLoginDialog;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;
/* loaded from: classes9.dex */
public final class a {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;

    public static void a(Activity activity, boolean z, Bundle bundle, com.baidu.swan.apps.a.a aVar) {
        if (ProcessUtils.isMainProcess()) {
            a(activity, bundle, aVar);
        } else {
            b(activity, z, bundle, aVar);
        }
    }

    public static boolean dW(Context context) {
        return ProcessUtils.isMainProcess() ? isLogin(context) : ea(context);
    }

    public static String dX(Context context) {
        return ProcessUtils.isMainProcess() ? getBduss(context) : eb(context);
    }

    public static void a(Context context, String str, ArrayList<String> arrayList, b.a aVar) {
        if (ProcessUtils.isMainProcess()) {
            a(str, arrayList, aVar);
        } else {
            b(context, str, arrayList, aVar);
        }
    }

    public static String dY(Context context) {
        return ProcessUtils.isMainProcess() ? getUid(context) : ec(context);
    }

    public static String dZ(Context context) {
        return ProcessUtils.isMainProcess() ? getCuid(context) : ed(context);
    }

    public static void a(com.baidu.swan.apps.a.c cVar) {
        if (cVar != null) {
            v.aSU().b(cVar);
        }
    }

    public static void b(Activity activity, boolean z, Bundle bundle, final com.baidu.swan.apps.a.a aVar) {
        Bundle bundle2 = new Bundle();
        bundle2.putBoolean("key_login_force", z);
        bundle2.putBundle("key_login_params", bundle);
        DelegateUtils.callOnMainWithActivity(activity, MainProcessDelegateActivity.class, k.class, bundle2, new DelegateListener() { // from class: com.baidu.swan.bdprivate.a.a.1
            @Override // com.baidu.searchbox.process.ipc.delegate.DelegateListener
            public void onDelegateCallBack(@NonNull DelegateResult delegateResult) {
                if (com.baidu.swan.apps.a.a.this != null) {
                    if (!delegateResult.isOk()) {
                        com.baidu.swan.apps.a.a.this.onResult(-1);
                        return;
                    }
                    com.baidu.swan.apps.a.a.this.onResult(delegateResult.mResult.getInt("result_code", -1));
                }
            }
        });
    }

    public static void a(Context context, Bundle bundle, com.baidu.swan.apps.a.a aVar) {
        if (!ProcessUtils.isMainProcess()) {
            aVar.onResult(-1);
        } else {
            v.aSU().a(context, bundle, aVar);
        }
    }

    public static boolean ea(Context context) {
        DelegateResult callOnMainWithContentProvider = DelegateUtils.callOnMainWithContentProvider(context, j.class, null);
        return callOnMainWithContentProvider.isOk() && callOnMainWithContentProvider.mResult.getBoolean("result", false);
    }

    public static boolean isLogin(Context context) {
        if (ProcessUtils.isMainProcess()) {
            return v.aSU().isLogin(context);
        }
        return false;
    }

    public static String eb(Context context) {
        DelegateResult callOnMainWithContentProvider = DelegateUtils.callOnMainWithContentProvider(context, c.class, null);
        return callOnMainWithContentProvider.isOk() ? callOnMainWithContentProvider.mResult.getString("result", "") : "";
    }

    public static String getBduss(Context context) {
        if (!ProcessUtils.isMainProcess()) {
            return "";
        }
        String bduss = v.aSU().getBduss(context);
        return TextUtils.isEmpty(bduss) ? "" : bduss;
    }

    public static void b(Context context, String str, ArrayList<String> arrayList, final b.a aVar) {
        com.baidu.swan.apps.runtime.e aMk = com.baidu.swan.apps.runtime.e.aMk();
        if (aMk == null) {
            aVar.vj(null);
            return;
        }
        com.baidu.swan.apps.process.messaging.client.a aMb = aMk.aMb();
        if (aMb == null) {
            aVar.vj(null);
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putString("key_result_client_id", str);
        bundle.putStringArrayList("key_param_tpl_list", arrayList);
        aMb.b(bundle, e.class, new com.baidu.swan.apps.process.a.b.c.b() { // from class: com.baidu.swan.bdprivate.a.a.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.swan.apps.process.a.b.c.a
            public void onEvent(@NonNull com.baidu.swan.apps.process.a.b.a.b bVar) {
                if (a.DEBUG) {
                    Log.d("AccountUtils", "get openBduss messenger delegate observer receive event");
                }
                String str2 = null;
                if (bVar.getResult() != null) {
                    if (a.DEBUG) {
                        Log.d("AccountUtils", "get openBduss : result " + bVar.getResult());
                    }
                    str2 = bVar.getResult().getString("result");
                } else if (a.DEBUG) {
                    Log.d("AccountUtils", "get openBduss : result null");
                }
                b.a.this.vj(str2);
            }

            @Override // com.baidu.swan.apps.process.a.b.c.b, com.baidu.swan.apps.process.a.b.c.a
            public long getTimeoutMillis() {
                return 30000L;
            }
        });
    }

    public static void a(String str, ArrayList<String> arrayList, b.a aVar) {
        if (ProcessUtils.isMainProcess()) {
            v.aSU().a(str, arrayList, aVar);
        }
    }

    public static String ec(Context context) {
        DelegateResult callOnMainWithContentProvider = DelegateUtils.callOnMainWithContentProvider(context, h.class, null);
        return callOnMainWithContentProvider.isOk() ? callOnMainWithContentProvider.mResult.getString("result", "") : "";
    }

    public static String getUid(Context context) {
        return !ProcessUtils.isMainProcess() ? "" : v.aSU().getUid(context);
    }

    public static String ed(Context context) {
        DelegateResult callOnMainWithContentProvider = DelegateUtils.callOnMainWithContentProvider(context, d.class, null);
        return callOnMainWithContentProvider.isOk() ? callOnMainWithContentProvider.mResult.getString("result", "") : "";
    }

    public static String getCuid(Context context) {
        return !ProcessUtils.isMainProcess() ? "" : v.aSU().getCuid(context);
    }

    public static void a(Context context, com.baidu.swan.apps.ao.e.b<Bundle> bVar, @Nullable String... strArr) {
        if (ProcessUtils.isMainProcess()) {
            b(context, bVar, strArr);
        } else {
            b(bVar, strArr);
        }
    }

    public static void b(final com.baidu.swan.apps.ao.e.b<Bundle> bVar, String... strArr) {
        if (strArr == null || strArr.length < 1) {
            bVar.L(null);
            return;
        }
        com.baidu.swan.apps.runtime.e aMk = com.baidu.swan.apps.runtime.e.aMk();
        if (aMk == null) {
            bVar.L(null);
            return;
        }
        com.baidu.swan.apps.process.messaging.client.a aMb = aMk.aMb();
        if (aMb == null) {
            bVar.L(null);
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putStringArray("key_param_tpl_list", strArr);
        aMb.b(bundle, g.class, new com.baidu.swan.apps.process.a.b.c.b() { // from class: com.baidu.swan.bdprivate.a.a.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.swan.apps.process.a.b.c.a
            public void onEvent(@NonNull com.baidu.swan.apps.process.a.b.a.b bVar2) {
                if (a.DEBUG) {
                    Log.d("AccountUtils", "get stoken messenger delegate observer receive event");
                }
                Bundle bundle2 = null;
                if (bVar2.getResult() != null) {
                    if (a.DEBUG) {
                        Log.d("AccountUtils", "get stoken : result " + bVar2.getResult());
                    }
                    bundle2 = bVar2.getResult().getBundle("key_result_stokent");
                } else if (a.DEBUG) {
                    Log.d("AccountUtils", "get stoken : result null");
                }
                com.baidu.swan.apps.ao.e.b.this.L(bundle2);
            }

            @Override // com.baidu.swan.apps.process.a.b.c.b, com.baidu.swan.apps.process.a.b.c.a
            public long getTimeoutMillis() {
                return 30000L;
            }
        });
    }

    public static void b(Context context, final com.baidu.swan.apps.ao.e.b<Bundle> bVar, @Nullable String... strArr) {
        if (!ProcessUtils.isMainProcess()) {
            throw new IllegalStateException("must call in MainProcess");
        }
        String bduss = getBduss(context);
        if (TextUtils.isEmpty(bduss)) {
            bVar.L(null);
        } else {
            a(new l.a() { // from class: com.baidu.swan.bdprivate.a.a.4
                @Override // com.baidu.swan.bdprivate.a.l.a
                public void a(l lVar) {
                    if (lVar.mErrCode != 0 || lVar.mStokens == null) {
                        com.baidu.swan.apps.ao.e.b.this.L(null);
                    }
                    Bundle bundle = new Bundle();
                    for (Map.Entry<String, String> entry : lVar.mStokens.entrySet()) {
                        String key = entry.getKey();
                        if (!TextUtils.isEmpty(key)) {
                            bundle.putString(key, entry.getValue());
                        }
                    }
                    com.baidu.swan.apps.ao.e.b.this.L(bundle);
                }

                @Override // com.baidu.swan.bdprivate.a.l.a
                public void b(l lVar) {
                    com.baidu.swan.apps.ao.e.b.this.L(null);
                }

                @Override // com.baidu.swan.bdprivate.a.l.a
                public void onStart() {
                }

                @Override // com.baidu.swan.bdprivate.a.l.a
                public void onFinish() {
                }
            }, bduss, strArr == null ? Collections.emptyList() : Arrays.asList(strArr));
        }
    }

    private static void a(l.a aVar, String str, List<String> list) {
        v.aSU().a(aVar, str, list);
    }

    public static String ee(Context context) {
        return ProcessUtils.isMainProcess() ? eg(context) : ef(context);
    }

    public static String ef(Context context) {
        DelegateResult callOnMainWithContentProvider = DelegateUtils.callOnMainWithContentProvider(context, f.class, null);
        return callOnMainWithContentProvider.isOk() ? callOnMainWithContentProvider.mResult.getString("result", "") : "";
    }

    public static String eg(Context context) {
        return !ProcessUtils.isMainProcess() ? "" : v.aSU().eg(context);
    }

    public static aa eh(Context context) {
        return ProcessUtils.isMainProcess() ? ej(context) : ei(context);
    }

    public static aa ei(Context context) {
        DelegateResult callOnMainWithContentProvider = DelegateUtils.callOnMainWithContentProvider(context, i.class, null);
        if (callOnMainWithContentProvider.isOk()) {
            aa aaVar = new aa();
            aaVar.displayName = callOnMainWithContentProvider.mResult.getString("NICK_NAME", "");
            aaVar.aWS = callOnMainWithContentProvider.mResult.getString("AVATAR_URL", "");
            return aaVar;
        }
        return null;
    }

    public static aa ej(Context context) {
        if (ProcessUtils.isMainProcess()) {
            return v.aSU().ej(context);
        }
        return null;
    }

    public static void a(Activity activity, final com.baidu.swan.apps.b.a.b bVar) {
        DelegateUtils.callOnMainWithActivity(activity, MainProcessDelegateActivity.class, com.baidu.swan.bdprivate.b.a.class, new DelegateListener() { // from class: com.baidu.swan.bdprivate.a.a.5
            @Override // com.baidu.searchbox.process.ipc.delegate.DelegateListener
            public void onDelegateCallBack(@NonNull DelegateResult delegateResult) {
                String string = delegateResult.mResult.getString("address_info");
                if (TextUtils.isEmpty(string)) {
                    if (com.baidu.swan.apps.b.DEBUG) {
                        Log.e("AccountUtils", delegateResult.mResult.getString(TiebaInitialize.LogFields.ERROR_MESSAGE));
                    }
                    com.baidu.swan.apps.b.a.b.this.hE(0);
                    return;
                }
                if (com.baidu.swan.apps.b.DEBUG) {
                    Log.i("AccountUtils", string);
                }
                com.baidu.swan.apps.b.a.b.this.aH(com.baidu.swan.apps.ao.v.parseString(string));
            }
        });
    }

    public static void a(Context context, a.InterfaceC0505a interfaceC0505a) {
        if (ProcessUtils.isMainProcess()) {
            v.aSU().a(context, interfaceC0505a);
        }
    }

    public static void a(Context context, a.InterfaceC0507a interfaceC0507a) {
        if (ProcessUtils.isMainProcess()) {
            v.aSU().a(context, interfaceC0507a);
        }
    }

    public static void a(Activity activity, String str, String str2, com.baidu.swan.apps.ao.e.b<Bundle> bVar) {
        boolean equals = TextUtils.equals(str, "1");
        if (ProcessUtils.isMainProcess()) {
            if (equals) {
                a(activity, str2, bVar);
                return;
            } else {
                b(activity, str2, bVar);
                return;
            }
        }
        a(activity, equals, str2, bVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(Activity activity, String str, com.baidu.swan.apps.ao.e.b<Bundle> bVar) {
        v.aSU().a(activity, "baidu_mini_programs_" + str, dX(activity), E(bVar));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void b(Activity activity, String str, com.baidu.swan.apps.ao.e.b<Bundle> bVar) {
        v.aSU().b(activity, "baidu_mini_programs_" + str, dX(activity), E(bVar));
    }

    private static ab E(final com.baidu.swan.apps.ao.e.b<Bundle> bVar) {
        final Bundle bundle = new Bundle();
        return new ab() { // from class: com.baidu.swan.bdprivate.a.a.6
            @Override // com.baidu.swan.bdprivate.a.ab
            public void a(z zVar) {
                if (a.DEBUG) {
                    Log.d("AccountUtils", "callbackkey=" + zVar.callbackkey);
                }
                bundle.putString("callbackKey", zVar.callbackkey);
                if (bVar != null) {
                    bVar.L(bundle);
                }
            }

            @Override // com.baidu.swan.bdprivate.a.ab
            public void onFailure(String str) {
                if (a.DEBUG) {
                    Log.d("AccountUtils", "onFailure=" + str);
                }
                bundle.putString("failMsg", str);
                if (bVar != null) {
                    bVar.L(bundle);
                }
            }
        };
    }

    private static void a(Activity activity, boolean z, String str, final com.baidu.swan.apps.ao.e.b<Bundle> bVar) {
        Bundle bundle = new Bundle();
        bundle.putBoolean("isRealName", z);
        bundle.putString("swanAppId", str);
        DelegateUtils.callOnMainWithActivity(activity, PluginDelegateActivity.class, b.class, bundle, new DelegateListener() { // from class: com.baidu.swan.bdprivate.a.a.7
            @Override // com.baidu.searchbox.process.ipc.delegate.DelegateListener
            public void onDelegateCallBack(@NonNull DelegateResult delegateResult) {
                Bundle bundle2 = delegateResult.mResult;
                if (com.baidu.swan.apps.ao.e.b.this != null) {
                    com.baidu.swan.apps.ao.e.b.this.L(com.baidu.swan.apps.ao.u.i(bundle2, "result"));
                }
            }
        });
    }

    public static String cU(Context context) {
        return !ProcessUtils.isMainProcess() ? ek(context) : getZid(context);
    }

    public static String ek(Context context) {
        DelegateResult callOnMainWithContentProvider = DelegateUtils.callOnMainWithContentProvider(context, com.baidu.swan.facade.c.a.class, null);
        return callOnMainWithContentProvider.isOk() ? callOnMainWithContentProvider.mResult.getString("result", "") : "";
    }

    public static String getZid(Context context) {
        return v.aSU().getZid(context);
    }

    public static void a(Context context, SwanAppPhoneLoginDialog.a aVar, String str) {
        v.aSU().a(context, aVar, str);
    }

    public static void b(final Activity activity, JSONObject jSONObject) {
        JSONObject ca = com.baidu.swan.apps.setting.oauth.c.ca(jSONObject);
        if (ca != null && activity != null) {
            int optInt = ca.optInt(BaseJsonData.TAG_ERRNO, RequestResponseCode.REQUEST_LOGIN_WRITE);
            final String optString = ca.optString("tipmsg");
            if (optInt == 401 || optInt == 400701) {
                JSONObject optJSONObject = ca.optJSONObject("tipoption");
                final String optString2 = optJSONObject != null ? optJSONObject.optString("title") : null;
                if (!TextUtils.isEmpty(optString2) && !TextUtils.isEmpty(optString)) {
                    ak.runOnUiThread(new Runnable() { // from class: com.baidu.swan.bdprivate.a.a.8
                        @Override // java.lang.Runnable
                        public void run() {
                            a.a(activity, optString2, optString);
                        }
                    });
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void a(final Activity activity, String str, String str2) {
        new g.a(activity).f(str).sp(str2).a(new com.baidu.swan.apps.view.c.a()).gV(true).a(activity.getString(b.g.aiapps_login_immediately), new DialogInterface.OnClickListener() { // from class: com.baidu.swan.bdprivate.a.a.9
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                a.a(activity, true, (Bundle) null, (com.baidu.swan.apps.a.a) null);
            }
        }).b(activity.getString(b.g.aiapps_login_refuse), null).aLx();
    }
}
