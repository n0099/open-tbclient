package com.baidu.swan.bdprivate.a;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.android.util.io.BaseJsonData;
import com.baidu.live.tbadk.core.util.TiebaInitialize;
import com.baidu.searchbox.process.ipc.agent.activity.MainProcessDelegateActivity;
import com.baidu.searchbox.process.ipc.agent.activity.PluginDelegateActivity;
import com.baidu.searchbox.process.ipc.delegate.DelegateListener;
import com.baidu.searchbox.process.ipc.delegate.DelegateResult;
import com.baidu.searchbox.process.ipc.delegate.DelegateUtils;
import com.baidu.searchbox.process.ipc.util.ProcessUtils;
import com.baidu.swan.apps.aq.aj;
import com.baidu.swan.apps.res.widget.dialog.g;
import com.baidu.swan.bdprivate.a.l;
import com.baidu.swan.bdprivate.api.b;
import com.baidu.swan.bdprivate.b;
import com.baidu.swan.bdprivate.b.a;
import com.baidu.swan.bdprivate.e.a;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public final class a {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;

    public static void a(Activity activity, boolean z, Bundle bundle, com.baidu.swan.apps.a.a aVar) {
        if (ProcessUtils.isMainProcess()) {
            a(activity, bundle, aVar);
        } else {
            b(activity, z, bundle, aVar);
        }
    }

    public static boolean cG(Context context) {
        return ProcessUtils.isMainProcess() ? isLogin(context) : cK(context);
    }

    public static String cH(Context context) {
        return ProcessUtils.isMainProcess() ? getBduss(context) : cL(context);
    }

    public static void a(Context context, String str, ArrayList<String> arrayList, b.a aVar) {
        if (ProcessUtils.isMainProcess()) {
            a(str, arrayList, aVar);
        } else {
            b(context, str, arrayList, aVar);
        }
    }

    public static String cI(Context context) {
        return ProcessUtils.isMainProcess() ? getUid(context) : cM(context);
    }

    public static String cJ(Context context) {
        return ProcessUtils.isMainProcess() ? getCuid(context) : cN(context);
    }

    public static void a(com.baidu.swan.apps.a.c cVar) {
        if (cVar != null) {
            u.auH().b(cVar);
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
            u.auH().a(context, bundle, aVar);
        }
    }

    public static boolean cK(Context context) {
        DelegateResult callOnMainWithContentProvider = DelegateUtils.callOnMainWithContentProvider(context, j.class, null);
        return callOnMainWithContentProvider.isOk() && callOnMainWithContentProvider.mResult.getBoolean("result", false);
    }

    public static boolean isLogin(Context context) {
        if (ProcessUtils.isMainProcess()) {
            return u.auH().isLogin(context);
        }
        return false;
    }

    public static String cL(Context context) {
        DelegateResult callOnMainWithContentProvider = DelegateUtils.callOnMainWithContentProvider(context, c.class, null);
        return callOnMainWithContentProvider.isOk() ? callOnMainWithContentProvider.mResult.getString("result", "") : "";
    }

    public static String getBduss(Context context) {
        if (!ProcessUtils.isMainProcess()) {
            return "";
        }
        String bduss = u.auH().getBduss(context);
        return TextUtils.isEmpty(bduss) ? "" : bduss;
    }

    public static void b(Context context, String str, ArrayList<String> arrayList, final b.a aVar) {
        com.baidu.swan.apps.runtime.e aoF = com.baidu.swan.apps.runtime.e.aoF();
        if (aoF == null) {
            aVar.pX(null);
            return;
        }
        com.baidu.swan.apps.process.messaging.client.a aow = aoF.aow();
        if (aow == null) {
            aVar.pX(null);
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putString("key_result_client_id", str);
        bundle.putStringArrayList("key_param_tpl_list", arrayList);
        aow.b(bundle, e.class, new com.baidu.swan.apps.process.a.b.c.b() { // from class: com.baidu.swan.bdprivate.a.a.2
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
                b.a.this.pX(str2);
            }

            @Override // com.baidu.swan.apps.process.a.b.c.b, com.baidu.swan.apps.process.a.b.c.a
            public long getTimeoutMillis() {
                return 30000L;
            }
        });
    }

    public static void a(String str, ArrayList<String> arrayList, b.a aVar) {
        if (ProcessUtils.isMainProcess()) {
            u.auH().a(str, arrayList, aVar);
        }
    }

    public static String cM(Context context) {
        DelegateResult callOnMainWithContentProvider = DelegateUtils.callOnMainWithContentProvider(context, h.class, null);
        return callOnMainWithContentProvider.isOk() ? callOnMainWithContentProvider.mResult.getString("result", "") : "";
    }

    public static String getUid(Context context) {
        return !ProcessUtils.isMainProcess() ? "" : u.auH().getUid(context);
    }

    public static String cN(Context context) {
        DelegateResult callOnMainWithContentProvider = DelegateUtils.callOnMainWithContentProvider(context, d.class, null);
        return callOnMainWithContentProvider.isOk() ? callOnMainWithContentProvider.mResult.getString("result", "") : "";
    }

    public static String getCuid(Context context) {
        return !ProcessUtils.isMainProcess() ? "" : u.auH().getCuid(context);
    }

    public static void a(Context context, com.baidu.swan.apps.aq.e.b<Bundle> bVar, @Nullable String... strArr) {
        if (ProcessUtils.isMainProcess()) {
            b(context, bVar, strArr);
        } else {
            b(bVar, strArr);
        }
    }

    public static void b(final com.baidu.swan.apps.aq.e.b<Bundle> bVar, String... strArr) {
        if (strArr == null || strArr.length < 1) {
            bVar.H(null);
            return;
        }
        com.baidu.swan.apps.runtime.e aoF = com.baidu.swan.apps.runtime.e.aoF();
        if (aoF == null) {
            bVar.H(null);
            return;
        }
        com.baidu.swan.apps.process.messaging.client.a aow = aoF.aow();
        if (aow == null) {
            bVar.H(null);
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putStringArray("key_param_tpl_list", strArr);
        aow.b(bundle, g.class, new com.baidu.swan.apps.process.a.b.c.b() { // from class: com.baidu.swan.bdprivate.a.a.3
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
                com.baidu.swan.apps.aq.e.b.this.H(bundle2);
            }

            @Override // com.baidu.swan.apps.process.a.b.c.b, com.baidu.swan.apps.process.a.b.c.a
            public long getTimeoutMillis() {
                return 30000L;
            }
        });
    }

    public static void b(Context context, final com.baidu.swan.apps.aq.e.b<Bundle> bVar, @Nullable String... strArr) {
        if (!ProcessUtils.isMainProcess()) {
            throw new IllegalStateException("must call in MainProcess");
        }
        String bduss = getBduss(context);
        if (TextUtils.isEmpty(bduss)) {
            bVar.H(null);
        } else {
            a(new l.a() { // from class: com.baidu.swan.bdprivate.a.a.4
                @Override // com.baidu.swan.bdprivate.a.l.a
                public void a(l lVar) {
                    if (lVar.mErrCode != 0 || lVar.mStokens == null) {
                        com.baidu.swan.apps.aq.e.b.this.H(null);
                    }
                    Bundle bundle = new Bundle();
                    for (Map.Entry<String, String> entry : lVar.mStokens.entrySet()) {
                        String key = entry.getKey();
                        if (!TextUtils.isEmpty(key)) {
                            bundle.putString(key, entry.getValue());
                        }
                    }
                    com.baidu.swan.apps.aq.e.b.this.H(bundle);
                }

                @Override // com.baidu.swan.bdprivate.a.l.a
                public void b(l lVar) {
                    com.baidu.swan.apps.aq.e.b.this.H(null);
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
        u.auH().a(aVar, str, list);
    }

    public static String cO(Context context) {
        return ProcessUtils.isMainProcess() ? cQ(context) : cP(context);
    }

    public static String cP(Context context) {
        DelegateResult callOnMainWithContentProvider = DelegateUtils.callOnMainWithContentProvider(context, f.class, null);
        return callOnMainWithContentProvider.isOk() ? callOnMainWithContentProvider.mResult.getString("result", "") : "";
    }

    public static String cQ(Context context) {
        return !ProcessUtils.isMainProcess() ? "" : u.auH().cQ(context);
    }

    public static z cR(Context context) {
        return ProcessUtils.isMainProcess() ? cT(context) : cS(context);
    }

    public static z cS(Context context) {
        DelegateResult callOnMainWithContentProvider = DelegateUtils.callOnMainWithContentProvider(context, i.class, null);
        if (callOnMainWithContentProvider.isOk()) {
            z zVar = new z();
            zVar.displayName = callOnMainWithContentProvider.mResult.getString("NICK_NAME", "");
            zVar.aOX = callOnMainWithContentProvider.mResult.getString("AVATAR_URL", "");
            return zVar;
        }
        return null;
    }

    public static z cT(Context context) {
        if (ProcessUtils.isMainProcess()) {
            return u.auH().cT(context);
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
                    com.baidu.swan.apps.b.a.b.this.ei(0);
                    return;
                }
                if (com.baidu.swan.apps.b.DEBUG) {
                    Log.i("AccountUtils", string);
                }
                com.baidu.swan.apps.b.a.b.this.ab(com.baidu.swan.apps.aq.t.parseString(string));
            }
        });
    }

    public static void a(Context context, a.InterfaceC0408a interfaceC0408a) {
        if (ProcessUtils.isMainProcess()) {
            u.auH().a(context, interfaceC0408a);
        }
    }

    public static void a(Context context, a.InterfaceC0412a interfaceC0412a) {
        if (ProcessUtils.isMainProcess()) {
            u.auH().a(context, interfaceC0412a);
        }
    }

    public static void a(Activity activity, boolean z, String str, com.baidu.swan.apps.aq.e.b<Bundle> bVar) {
        if (ProcessUtils.isMainProcess()) {
            if (z) {
                a(activity, str, bVar);
                return;
            } else {
                b(activity, str, bVar);
                return;
            }
        }
        b(activity, z, str, bVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(Activity activity, String str, com.baidu.swan.apps.aq.e.b<Bundle> bVar) {
        u.auH().a(activity, "baidu_mini_programs_" + str, cH(activity), u(bVar));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void b(Activity activity, String str, com.baidu.swan.apps.aq.e.b<Bundle> bVar) {
        u.auH().b(activity, "baidu_mini_programs_" + str, cH(activity), u(bVar));
    }

    private static aa u(final com.baidu.swan.apps.aq.e.b<Bundle> bVar) {
        final Bundle bundle = new Bundle();
        return new aa() { // from class: com.baidu.swan.bdprivate.a.a.6
            @Override // com.baidu.swan.bdprivate.a.aa
            public void a(y yVar) {
                if (a.DEBUG) {
                    Log.d("AccountUtils", "callbackkey=" + yVar.callbackkey);
                }
                bundle.putString("callbackKey", yVar.callbackkey);
                if (bVar != null) {
                    bVar.H(bundle);
                }
            }

            @Override // com.baidu.swan.bdprivate.a.aa
            public void onFailure(String str) {
                if (a.DEBUG) {
                    Log.d("AccountUtils", "onFailure=" + str);
                }
                bundle.putString("failMsg", str);
                if (bVar != null) {
                    bVar.H(bundle);
                }
            }
        };
    }

    private static void b(Activity activity, boolean z, String str, final com.baidu.swan.apps.aq.e.b<Bundle> bVar) {
        Bundle bundle = new Bundle();
        bundle.putBoolean("isRealName", z);
        bundle.putString("swanAppId", str);
        DelegateUtils.callOnMainWithActivity(activity, PluginDelegateActivity.class, b.class, bundle, new DelegateListener() { // from class: com.baidu.swan.bdprivate.a.a.7
            @Override // com.baidu.searchbox.process.ipc.delegate.DelegateListener
            public void onDelegateCallBack(@NonNull DelegateResult delegateResult) {
                Bundle bundle2 = delegateResult.mResult;
                if (com.baidu.swan.apps.aq.e.b.this != null) {
                    com.baidu.swan.apps.aq.e.b.this.H(com.baidu.swan.apps.aq.s.safeGetBundle(bundle2, "result"));
                }
            }
        });
    }

    public static String bR(Context context) {
        return !ProcessUtils.isMainProcess() ? cU(context) : getZid(context);
    }

    public static String cU(Context context) {
        DelegateResult callOnMainWithContentProvider = DelegateUtils.callOnMainWithContentProvider(context, com.baidu.swan.facade.c.a.class, null);
        return callOnMainWithContentProvider.isOk() ? callOnMainWithContentProvider.mResult.getString("result", "") : "";
    }

    public static String getZid(Context context) {
        return u.auH().getZid(context);
    }

    public static void b(final Activity activity, JSONObject jSONObject) {
        JSONObject bj = com.baidu.swan.apps.setting.oauth.c.bj(jSONObject);
        if (bj != null && activity != null) {
            int optInt = bj.optInt(BaseJsonData.TAG_ERRNO, 11001);
            final String optString = bj.optString("tipmsg");
            if (optInt == 401 || optInt == 400701) {
                JSONObject optJSONObject = bj.optJSONObject("tipoption");
                final String optString2 = optJSONObject != null ? optJSONObject.optString("title") : null;
                if (!TextUtils.isEmpty(optString2) && !TextUtils.isEmpty(optString)) {
                    aj.runOnUiThread(new Runnable() { // from class: com.baidu.swan.bdprivate.a.a.8
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
        new g.a(activity).e(str).nq(str2).a(new com.baidu.swan.apps.view.c.a()).eT(true).a(activity.getString(b.g.aiapps_login_immediately), new DialogInterface.OnClickListener() { // from class: com.baidu.swan.bdprivate.a.a.9
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                a.a(activity, true, (Bundle) null, (com.baidu.swan.apps.a.a) null);
            }
        }).b(activity.getString(b.g.aiapps_login_refuse), null).aon();
    }
}
