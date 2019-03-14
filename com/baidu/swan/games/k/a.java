package com.baidu.swan.games.k;

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
import com.baidu.swan.apps.an.y;
import com.baidu.swan.apps.b;
import com.baidu.swan.apps.install.c;
import com.baidu.swan.apps.statistic.a.d;
import com.baidu.swan.apps.statistic.c;
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
    private static final Set<String> aQr = new HashSet();

    static {
        aQr.add("_baiduboxapp");
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
        String g = g(uri);
        if (DEBUG) {
            Log.d("SwanGameLaunchAction", "mAppId: " + g);
        }
        if (TextUtils.isEmpty(g)) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201);
            com.baidu.swan.apps.ak.a hw = new com.baidu.swan.apps.ak.a().L(1L).M(1L).hw("appId is empty");
            e.LG().b(hw);
            c.a(new d().gR(c.dC(1)).a(hw).aA("scheme", uri.toString()));
            return true;
        }
        String b = b(g, uri);
        if (DEBUG) {
            Log.d("SwanGameLaunchAction", "pagePath: " + b);
        }
        String j = j(uri);
        if (DEBUG) {
            Log.d("SwanGameLaunchAction", "query: " + j);
        }
        com.baidu.swan.apps.v.b.c cVar = new com.baidu.swan.apps.v.b.c();
        cVar.mAppId = g;
        cVar.axH = uri.toString();
        cVar.axX = 1;
        if (!TextUtils.isEmpty(b)) {
            cVar.axI = b + "?" + j;
        }
        String param = unitedSchemeEntity.getParam("_baiduboxapp");
        if (!TextUtils.isEmpty(param)) {
            try {
                JSONObject jSONObject = new JSONObject(param);
                cVar.mFrom = jSONObject.optString("from");
                cVar.al("srcAppId", jSONObject.optString("srcAppId"));
                cVar.al("extraData", jSONObject.getString("extraData"));
            } catch (JSONException e) {
                if (DEBUG) {
                    Log.d("SwanGameLaunchAction", "getLaunchFrom failed: " + Log.getStackTraceString(e));
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
        com.baidu.swan.apps.an.b.h(context, com.baidu.swan.apps.v.b.c.c(context, cVar));
        unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(0);
        return true;
    }

    private String g(Uri uri) {
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

    private String j(Uri uri) {
        return y.c(uri.getQuery(), aQr);
    }

    private void a(final com.baidu.swan.apps.v.b.c cVar, String str, Context context, final UnitedSchemeEntity unitedSchemeEntity, final CallbackHandler callbackHandler) {
        c.C0144c c0144c = new c.C0144c();
        c0144c.mAppId = cVar.mAppId;
        c0144c.mDownloadUrl = str;
        final Context applicationContext = context.getApplicationContext();
        if (applicationContext != null) {
            com.baidu.swan.games.i.a.a(c0144c, new c.b() { // from class: com.baidu.swan.games.k.a.1
                @Override // com.baidu.swan.apps.install.c.b
                public void cv(int i) {
                }

                @Override // com.baidu.swan.apps.install.c.b
                public void onSuccess() {
                    if (a.DEBUG) {
                        Log.d("SwanGameLaunchAction", "onSuccess");
                    }
                    aa.runOnUiThread(new Runnable() { // from class: com.baidu.swan.games.k.a.1.1
                        @Override // java.lang.Runnable
                        public void run() {
                            com.baidu.swan.apps.res.widget.b.d.a(applicationContext, "小游戏包下载成功").IK();
                        }
                    });
                    cVar.axW = "1.6.0";
                    cVar.axS = true;
                    com.baidu.swan.apps.v.b.b g = a.this.g(cVar);
                    if (g != null) {
                        com.baidu.swan.games.i.a.c(g, new com.baidu.swan.apps.install.b() { // from class: com.baidu.swan.games.k.a.1.2
                            @Override // com.baidu.swan.apps.install.b
                            public void a(int i, com.baidu.swan.apps.install.a aVar) {
                                a.b bVar = (a.b) aVar;
                                if (i == 0 && bVar != null && bVar.bdE != null) {
                                    cVar.aye = bVar.bdE.beP;
                                    Intent c = com.baidu.swan.apps.v.b.c.c(applicationContext, cVar);
                                    c.setAction("com.baidu.searchbox.action.aiapps.LAUNCH");
                                    c.setFlags(268435456);
                                    applicationContext.startActivity(c);
                                    UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(0));
                                }
                            }
                        });
                    }
                }

                @Override // com.baidu.swan.apps.install.c.b
                public void onFailed() {
                    if (a.DEBUG) {
                        Log.d("SwanGameLaunchAction", "onFailed");
                    }
                    com.baidu.swan.apps.ak.a hw = new com.baidu.swan.apps.ak.a().L(7L).M(9L).hw("debug download pkg fail");
                    e.LG().b(hw);
                    com.baidu.swan.apps.v.a.a.a(applicationContext, hw, 1);
                    unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.baidu.swan.apps.v.b.b g(com.baidu.swan.apps.v.b.c cVar) {
        if (cVar == null) {
            return null;
        }
        com.baidu.swan.apps.v.b.b DD = com.baidu.swan.apps.v.b.b.DD();
        DD.mAppId = cVar.mAppId;
        DD.axG = cVar.mFrom;
        DD.axI = cVar.axI;
        DD.axS = cVar.axS;
        DD.axR = cVar.axR;
        DD.axQ = cVar.DC();
        DD.axH = cVar.axH;
        DD.axT = cVar.axT;
        DD.atq = cVar.atq;
        DD.atr = cVar.atr;
        DD.axW = cVar.axW;
        DD.mVersion = "0";
        DD.axX = cVar.axX;
        return DD;
    }
}
