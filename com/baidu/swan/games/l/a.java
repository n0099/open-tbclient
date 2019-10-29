package com.baidu.swan.games.l;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.intercept.UnitedSchemeBaseInterceptor;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.swan.apps.ak.e;
import com.baidu.swan.apps.an.aa;
import com.baidu.swan.apps.an.ac;
import com.baidu.swan.apps.b;
import com.baidu.swan.apps.install.e;
import com.baidu.swan.apps.statistic.a.d;
import com.baidu.swan.apps.v.b.c;
import com.baidu.swan.games.i.a;
import java.io.File;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class a extends UnitedSchemeBaseInterceptor {
    private static final boolean DEBUG = b.DEBUG;
    private static final Set<String> bnv = new HashSet();

    static {
        bnv.add("_baiduboxapp");
    }

    @Override // com.baidu.searchbox.unitedscheme.intercept.UnitedSchemeBaseInterceptor
    public String getInterceptorName() {
        return "aigames_launch_interceptor";
    }

    @Override // com.baidu.searchbox.unitedscheme.intercept.UnitedSchemeBaseInterceptor, com.baidu.searchbox.unitedscheme.intercept.UnitedSchemeAbsInterceptor
    public boolean shouldInterceptDispatch(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler) {
        Uri uri = unitedSchemeEntity.getUri();
        if (uri == null || !TextUtils.equals(uri.getHost(), "swangame")) {
            return false;
        }
        if (unitedSchemeEntity.isOnlyVerify()) {
            return true;
        }
        String e = e(uri);
        if (DEBUG) {
            Log.d("SwanGameLaunchAction", "mAppId: " + e);
        }
        if (TextUtils.isEmpty(e)) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201);
            com.baidu.swan.apps.ak.a iL = new com.baidu.swan.apps.ak.a().as(1L).at(1L).iL("appId is empty");
            e.TT().b(iL);
            com.baidu.swan.apps.statistic.e.b(new d().ia(com.baidu.swan.apps.statistic.e.eL(1)).a(iL).aK("scheme", uri.toString()));
            return true;
        }
        String b = b(e, uri);
        if (DEBUG) {
            Log.d("SwanGameLaunchAction", "pagePath: " + b);
        }
        String h = h(uri);
        if (DEBUG) {
            Log.d("SwanGameLaunchAction", "query: " + h);
        }
        c cVar = new c();
        cVar.mAppId = e;
        cVar.aTi = uri.toString();
        cVar.aTl = 1;
        if (!TextUtils.isEmpty(b)) {
            cVar.aTe = b + "?" + h;
        }
        String param = unitedSchemeEntity.getParam("_baiduboxapp");
        if (!TextUtils.isEmpty(param)) {
            try {
                JSONObject jSONObject = new JSONObject(param);
                cVar.mFrom = jSONObject.optString("from");
                cVar.ar("srcAppId", jSONObject.optString("srcAppId"));
                cVar.ar("extraData", jSONObject.getString("extraData"));
            } catch (JSONException e2) {
                if (DEBUG) {
                    Log.d("SwanGameLaunchAction", "getLaunchFrom failed: " + Log.getStackTraceString(e2));
                }
            }
        }
        if (DEBUG) {
            Log.d("SwanGameLaunchAction", "launchParams: " + cVar);
        }
        String param2 = unitedSchemeEntity.getParam("downloadUrl");
        if (DEBUG && !TextUtils.isEmpty(param2)) {
            a(cVar, param2, context, unitedSchemeEntity, callbackHandler);
            return true;
        }
        com.baidu.swan.apps.an.b.e(context, c.c(context, cVar));
        unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(0);
        return true;
    }

    private String e(Uri uri) {
        List<String> pathSegments = uri.getPathSegments();
        if (pathSegments == null || pathSegments.isEmpty()) {
            return null;
        }
        return pathSegments.get(0);
    }

    private String b(String str, Uri uri) {
        String path = uri.getPath();
        if (TextUtils.isEmpty(path)) {
            return null;
        }
        String substring = path.substring(str.length() + 1);
        if (substring.endsWith(File.separator)) {
            return substring.substring(0, substring.length() - 1);
        }
        return substring;
    }

    private String h(Uri uri) {
        return aa.d(uri.getQuery(), bnv);
    }

    private void a(final c cVar, String str, Context context, final UnitedSchemeEntity unitedSchemeEntity, final CallbackHandler callbackHandler) {
        e.c cVar2 = new e.c();
        cVar2.mAppId = cVar.mAppId;
        cVar2.mDownloadUrl = str;
        final Context applicationContext = context.getApplicationContext();
        if (applicationContext != null) {
            com.baidu.swan.games.i.a.a(cVar2, new e.b() { // from class: com.baidu.swan.games.l.a.1
                @Override // com.baidu.swan.apps.install.e.b
                public void cr(int i) {
                }

                @Override // com.baidu.swan.apps.install.e.b
                public void onSuccess() {
                    if (a.DEBUG) {
                        Log.d("SwanGameLaunchAction", "onSuccess");
                    }
                    ac.runOnUiThread(new Runnable() { // from class: com.baidu.swan.games.l.a.1.1
                        @Override // java.lang.Runnable
                        public void run() {
                            com.baidu.swan.apps.res.widget.b.d.a(applicationContext, "小游戏包下载成功").QN();
                        }
                    });
                    cVar.aTk = "1.6.0";
                    cVar.aTf = true;
                    com.baidu.swan.apps.v.b.b g = a.this.g(cVar);
                    if (g != null) {
                        com.baidu.swan.games.i.a.c(g, new com.baidu.swan.apps.install.b() { // from class: com.baidu.swan.games.l.a.1.2
                            @Override // com.baidu.swan.apps.install.b
                            public void a(int i, com.baidu.swan.apps.install.a aVar) {
                                a.c cVar3 = (a.c) aVar;
                                if (i == 0 && cVar3 != null && cVar3.bBX != null) {
                                    cVar.aTm = cVar3.bBX.bDj;
                                    Intent c = c.c(applicationContext, cVar);
                                    c.setAction("com.baidu.searchbox.action.aiapps.LAUNCH");
                                    c.setFlags(268435456);
                                    applicationContext.startActivity(c);
                                    UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(0));
                                }
                            }
                        });
                    }
                }

                @Override // com.baidu.swan.apps.install.e.b
                public void onFailed() {
                    if (a.DEBUG) {
                        Log.d("SwanGameLaunchAction", "onFailed");
                    }
                    com.baidu.swan.apps.ak.a iL = new com.baidu.swan.apps.ak.a().as(7L).at(9L).iL("debug download pkg fail");
                    com.baidu.swan.apps.ak.e.TT().b(iL);
                    com.baidu.swan.apps.v.a.c cVar3 = new com.baidu.swan.apps.v.a.c();
                    cVar3.mAppId = cVar.mAppId;
                    com.baidu.swan.apps.v.a.a.a(applicationContext, iL, 1, cVar3);
                    unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.baidu.swan.apps.v.b.b g(c cVar) {
        if (cVar == null) {
            return null;
        }
        com.baidu.swan.apps.v.b.b Kq = com.baidu.swan.apps.v.b.b.Kq();
        Kq.setAppId(cVar.mAppId);
        Kq.fv(cVar.mFrom);
        Kq.setPage(cVar.aTe);
        Kq.setDebug(cVar.aTf);
        Kq.fz(cVar.aTh);
        Kq.p(cVar.Ks());
        Kq.fw(cVar.aTi);
        Kq.fA(cVar.aTj);
        Kq.a(cVar.aOc);
        Kq.a(cVar.aOd);
        Kq.fD(cVar.aTk);
        Kq.setVersion("0");
        Kq.m19do(cVar.aTl);
        return Kq;
    }
}
