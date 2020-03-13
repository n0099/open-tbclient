package com.baidu.swan.bdprivate.a;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.searchbox.process.ipc.agent.activity.MainProcessDelegateActivity;
import com.baidu.searchbox.process.ipc.agent.activity.PluginDelegateActivity;
import com.baidu.searchbox.process.ipc.delegate.DelegateListener;
import com.baidu.searchbox.process.ipc.delegate.DelegateResult;
import com.baidu.searchbox.process.ipc.delegate.DelegateUtils;
import com.baidu.searchbox.process.ipc.util.ProcessUtils;
import com.baidu.swan.apps.as.ai;
import com.baidu.swan.apps.res.widget.dialog.g;
import com.baidu.swan.bdprivate.a.l;
import com.baidu.swan.bdprivate.b;
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

    public static boolean cR(Context context) {
        return ProcessUtils.isMainProcess() ? isLogin(context) : cV(context);
    }

    public static String cS(Context context) {
        return ProcessUtils.isMainProcess() ? getBduss(context) : cW(context);
    }

    public static String cT(Context context) {
        return ProcessUtils.isMainProcess() ? getUid(context) : cX(context);
    }

    public static String cU(Context context) {
        return ProcessUtils.isMainProcess() ? getCuid(context) : cY(context);
    }

    public static void a(com.baidu.swan.apps.a.c cVar) {
        if (cVar != null) {
            u.ahP().b(cVar);
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
            u.ahP().a(context, bundle, aVar);
        }
    }

    public static boolean cV(Context context) {
        DelegateResult callOnMainWithContentProvider = DelegateUtils.callOnMainWithContentProvider(context, j.class, null);
        return callOnMainWithContentProvider.isOk() && callOnMainWithContentProvider.mResult.getBoolean("result", false);
    }

    public static boolean isLogin(Context context) {
        if (ProcessUtils.isMainProcess()) {
            return u.ahP().isLogin(context);
        }
        return false;
    }

    public static String cW(Context context) {
        DelegateResult callOnMainWithContentProvider = DelegateUtils.callOnMainWithContentProvider(context, c.class, null);
        return callOnMainWithContentProvider.isOk() ? callOnMainWithContentProvider.mResult.getString("result", "") : "";
    }

    public static String getBduss(Context context) {
        if (!ProcessUtils.isMainProcess()) {
            return "";
        }
        String bduss = u.ahP().getBduss(context);
        return TextUtils.isEmpty(bduss) ? "" : bduss;
    }

    public static String cX(Context context) {
        DelegateResult callOnMainWithContentProvider = DelegateUtils.callOnMainWithContentProvider(context, g.class, null);
        return callOnMainWithContentProvider.isOk() ? callOnMainWithContentProvider.mResult.getString("result", "") : "";
    }

    public static String getUid(Context context) {
        return !ProcessUtils.isMainProcess() ? "" : u.ahP().getUid(context);
    }

    public static String cY(Context context) {
        DelegateResult callOnMainWithContentProvider = DelegateUtils.callOnMainWithContentProvider(context, d.class, null);
        return callOnMainWithContentProvider.isOk() ? callOnMainWithContentProvider.mResult.getString("result", "") : "";
    }

    public static String getCuid(Context context) {
        return !ProcessUtils.isMainProcess() ? "" : u.ahP().getCuid(context);
    }

    public static void a(Context context, com.baidu.swan.apps.as.d.b<Bundle> bVar, @Nullable String... strArr) {
        if (ProcessUtils.isMainProcess()) {
            b(context, bVar, strArr);
        } else {
            b(bVar, strArr);
        }
    }

    public static void b(final com.baidu.swan.apps.as.d.b<Bundle> bVar, String... strArr) {
        if (strArr == null || strArr.length < 1) {
            bVar.D(null);
            return;
        }
        com.baidu.swan.apps.runtime.e acF = com.baidu.swan.apps.runtime.e.acF();
        if (acF == null) {
            bVar.D(null);
            return;
        }
        com.baidu.swan.apps.process.messaging.client.a acy = acF.acy();
        if (acy == null) {
            bVar.D(null);
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putStringArray("key_param_tpl_list", strArr);
        acy.a(bundle, f.class, new com.baidu.swan.apps.process.a.b.c.b() { // from class: com.baidu.swan.bdprivate.a.a.2
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
                com.baidu.swan.apps.as.d.b.this.D(bundle2);
            }

            @Override // com.baidu.swan.apps.process.a.b.c.b, com.baidu.swan.apps.process.a.b.c.a
            public long getTimeoutMillis() {
                return 30000L;
            }
        });
    }

    public static void b(Context context, final com.baidu.swan.apps.as.d.b<Bundle> bVar, @Nullable String... strArr) {
        if (!ProcessUtils.isMainProcess()) {
            throw new IllegalStateException("must call in MainProcess");
        }
        String bduss = getBduss(context);
        if (TextUtils.isEmpty(bduss)) {
            bVar.D(null);
        } else {
            a(new l.a() { // from class: com.baidu.swan.bdprivate.a.a.3
                @Override // com.baidu.swan.bdprivate.a.l.a
                public void a(l lVar) {
                    if (lVar.mErrCode != 0 || lVar.mStokens == null) {
                        com.baidu.swan.apps.as.d.b.this.D(null);
                    }
                    Bundle bundle = new Bundle();
                    for (Map.Entry<String, String> entry : lVar.mStokens.entrySet()) {
                        String key = entry.getKey();
                        if (!TextUtils.isEmpty(key)) {
                            bundle.putString(key, entry.getValue());
                        }
                    }
                    com.baidu.swan.apps.as.d.b.this.D(bundle);
                }

                @Override // com.baidu.swan.bdprivate.a.l.a
                public void b(l lVar) {
                    com.baidu.swan.apps.as.d.b.this.D(null);
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
        u.ahP().a(aVar, str, list);
    }

    public static String cZ(Context context) {
        return ProcessUtils.isMainProcess() ? db(context) : da(context);
    }

    public static String da(Context context) {
        DelegateResult callOnMainWithContentProvider = DelegateUtils.callOnMainWithContentProvider(context, e.class, null);
        return callOnMainWithContentProvider.isOk() ? callOnMainWithContentProvider.mResult.getString("result", "") : "";
    }

    public static String db(Context context) {
        return !ProcessUtils.isMainProcess() ? "" : u.ahP().db(context);
    }

    public static z dc(Context context) {
        return ProcessUtils.isMainProcess() ? de(context) : dd(context);
    }

    public static z dd(Context context) {
        DelegateResult callOnMainWithContentProvider = DelegateUtils.callOnMainWithContentProvider(context, h.class, null);
        if (callOnMainWithContentProvider.isOk()) {
            z zVar = new z();
            zVar.displayName = callOnMainWithContentProvider.mResult.getString("NICK_NAME", "");
            zVar.aqp = callOnMainWithContentProvider.mResult.getString("AVATAR_URL", "");
            return zVar;
        }
        return null;
    }

    public static z de(Context context) {
        if (ProcessUtils.isMainProcess()) {
            return u.ahP().de(context);
        }
        return null;
    }

    public static void a(Activity activity, boolean z, String str, com.baidu.swan.apps.as.d.b<Bundle> bVar) {
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
    public static void a(Activity activity, String str, com.baidu.swan.apps.as.d.b<Bundle> bVar) {
        u.ahP().a(activity, "baidu_mini_programs_" + str, cS(activity), m(bVar));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void b(Activity activity, String str, com.baidu.swan.apps.as.d.b<Bundle> bVar) {
        u.ahP().b(activity, "baidu_mini_programs_" + str, cS(activity), m(bVar));
    }

    private static aa m(final com.baidu.swan.apps.as.d.b<Bundle> bVar) {
        final Bundle bundle = new Bundle();
        return new aa() { // from class: com.baidu.swan.bdprivate.a.a.4
            @Override // com.baidu.swan.bdprivate.a.aa
            public void a(y yVar) {
                if (a.DEBUG) {
                    Log.d("AccountUtils", "callbackkey=" + yVar.callbackkey);
                }
                bundle.putString("callbackKey", yVar.callbackkey);
                if (bVar != null) {
                    bVar.D(bundle);
                }
            }

            @Override // com.baidu.swan.bdprivate.a.aa
            public void onFailure(String str) {
                if (a.DEBUG) {
                    Log.d("AccountUtils", "onFailure=" + str);
                }
                bundle.putString("failMsg", str);
                if (bVar != null) {
                    bVar.D(bundle);
                }
            }
        };
    }

    private static void b(Activity activity, boolean z, String str, final com.baidu.swan.apps.as.d.b<Bundle> bVar) {
        Bundle bundle = new Bundle();
        bundle.putBoolean("isRealName", z);
        bundle.putString("swanAppId", str);
        DelegateUtils.callOnMainWithActivity(activity, PluginDelegateActivity.class, b.class, bundle, new DelegateListener() { // from class: com.baidu.swan.bdprivate.a.a.5
            @Override // com.baidu.searchbox.process.ipc.delegate.DelegateListener
            public void onDelegateCallBack(@NonNull DelegateResult delegateResult) {
                Bundle bundle2 = delegateResult.mResult;
                if (com.baidu.swan.apps.as.d.b.this != null) {
                    com.baidu.swan.apps.as.d.b.this.D(com.baidu.swan.apps.as.r.safeGetBundle(bundle2, "result"));
                }
            }
        });
    }

    public static String cf(Context context) {
        return !ProcessUtils.isMainProcess() ? df(context) : getZid(context);
    }

    public static String df(Context context) {
        DelegateResult callOnMainWithContentProvider = DelegateUtils.callOnMainWithContentProvider(context, i.class, null);
        return callOnMainWithContentProvider.isOk() ? callOnMainWithContentProvider.mResult.getString("result", "") : "";
    }

    public static String getZid(Context context) {
        return u.ahP().getZid(context);
    }

    public static void b(final Activity activity, JSONObject jSONObject) {
        JSONObject aP = com.baidu.swan.apps.setting.oauth.c.aP(jSONObject);
        if (aP != null && activity != null) {
            int optInt = aP.optInt("errno", 11001);
            final String optString = aP.optString("tipmsg");
            if (optInt == 401 || optInt == 400701) {
                JSONObject optJSONObject = aP.optJSONObject("tipoption");
                final String optString2 = optJSONObject != null ? optJSONObject.optString("title") : null;
                if (!TextUtils.isEmpty(optString2) && !TextUtils.isEmpty(optString)) {
                    ai.runOnUiThread(new Runnable() { // from class: com.baidu.swan.bdprivate.a.a.6
                        @Override // java.lang.Runnable
                        public void run() {
                            a.b(activity, optString2, optString);
                        }
                    });
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void b(final Activity activity, String str, String str2) {
        new g.a(activity).e(str).kJ(str2).a(new com.baidu.swan.apps.view.c.a()).dD(true).a(activity.getString(b.g.aiapps_login_immediately), new DialogInterface.OnClickListener() { // from class: com.baidu.swan.bdprivate.a.a.7
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                a.a(activity, true, (Bundle) null, (com.baidu.swan.apps.a.a) null);
            }
        }).b(activity.getString(b.g.aiapps_login_refuse), null).acp();
    }
}
