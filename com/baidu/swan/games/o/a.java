package com.baidu.swan.games.o;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.intercept.UnitedSchemeBaseInterceptor;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.searchbox.v8engine.V8Engine;
import com.baidu.swan.apps.al.e;
import com.baidu.swan.apps.ao.ai;
import com.baidu.swan.apps.ao.ak;
import com.baidu.swan.apps.b;
import com.baidu.swan.apps.env.launch.SwanLauncher;
import com.baidu.swan.apps.r.d;
import com.baidu.swan.apps.statistic.a.d;
import com.baidu.swan.apps.statistic.h;
import com.baidu.swan.apps.u.c.c;
import com.baidu.swan.games.l.a;
import com.sina.weibo.sdk.statistic.LogBuilder;
import java.io.File;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class a extends UnitedSchemeBaseInterceptor {
    private static final boolean DEBUG = b.DEBUG;
    private static final Set<String> dFW = new HashSet();

    static {
        dFW.add("_baiduboxapp");
    }

    @Override // com.baidu.searchbox.unitedscheme.intercept.UnitedSchemeBaseInterceptor
    public String getInterceptorName() {
        return "aigames_launch_interceptor";
    }

    /* JADX WARN: Removed duplicated region for block: B:49:0x0221  */
    @Override // com.baidu.searchbox.unitedscheme.intercept.UnitedSchemeBaseInterceptor, com.baidu.searchbox.unitedscheme.intercept.UnitedSchemeAbsInterceptor
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean shouldInterceptDispatch(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler) {
        String str;
        String param;
        Uri uri = unitedSchemeEntity.getUri();
        if (uri == null || !TextUtils.equals(uri.getHost(), "swangame")) {
            return false;
        }
        if (unitedSchemeEntity.isOnlyVerify()) {
            return true;
        }
        String l = l(uri);
        if (DEBUG) {
            Log.d("SwanGameLaunchAction", "mAppId: " + l);
        }
        if (TextUtils.isEmpty(l)) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201);
            com.baidu.swan.apps.al.a aVar = new com.baidu.swan.apps.al.a().cV(1L).cW(1L).to("appId is empty");
            e.aMQ().j(aVar);
            h.b(new d().sw(h.jr(1)).i(aVar).cC("scheme", uri.toString()));
            return true;
        }
        if (com.baidu.swan.games.utils.so.d.aYR() != null) {
            boolean exists = new File(com.baidu.swan.games.utils.so.d.aYR()).exists();
            if (DEBUG) {
                Log.d("V8LoadChecker", "is v8 load success: " + exists);
            }
            if (!exists) {
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201);
                com.baidu.swan.apps.al.a aVar2 = new com.baidu.swan.apps.al.a().cV(1L).cW(1L).to("v8 is error");
                e.aMQ().j(aVar2);
                h.b(new d().sw(h.jr(1)).i(aVar2).cC(V8Engine.TYPE_V8, uri.toString()));
                return true;
            }
        }
        String b2 = b(l, uri);
        if (DEBUG) {
            Log.d("SwanGameLaunchAction", "pagePath: " + b2);
        }
        String n = n(uri);
        if (DEBUG) {
            Log.d("SwanGameLaunchAction", "query: " + n);
        }
        c.a aVar3 = (c.a) ((c.a) ((c.a) ((c.a) new c.a().oz(l)).oD(uri.toString())).hN(1)).fR(false);
        if (!TextUtils.isEmpty(b2)) {
            aVar3.oE(b2 + "?" + n);
        }
        String param2 = unitedSchemeEntity.getParam("_baiduboxapp");
        if (TextUtils.isEmpty(param2)) {
            str = null;
        } else {
            try {
                JSONObject jSONObject = new JSONObject(param2);
                aVar3.oC(jSONObject.optString("from"));
                aVar3.oG(jSONObject.optString("notinhis"));
                aVar3.bY("srcAppId", jSONObject.optString("srcAppId"));
                if (!jSONObject.isNull("extraData")) {
                    aVar3.bY("extraData", jSONObject.optString("extraData"));
                }
                str = jSONObject.optString("navi");
                try {
                    JSONObject a2 = com.baidu.swan.c.c.a(aVar3.ayC(), jSONObject.optJSONObject("ubc"), "pre_source");
                    if (a2 != null) {
                        aVar3.bY("ubc", a2.toString());
                    }
                    String optString = jSONObject.optString("veloce");
                    if (!TextUtils.isEmpty(optString)) {
                        long optLong = new JSONObject(optString).optLong(LogBuilder.KEY_START_TIME);
                        if (optLong > 0) {
                            aVar3.p("veloce_start_time", optLong);
                        }
                    }
                } catch (JSONException e) {
                    e = e;
                    if (DEBUG) {
                        Log.d("SwanGameLaunchAction", "getLaunchFrom failed: " + Log.getStackTraceString(e));
                    }
                    if (DEBUG) {
                    }
                    param = unitedSchemeEntity.getParam("downloadUrl");
                    if (!com.baidu.swan.apps.ad.a.a.aEN()) {
                    }
                    aVar3.fR(true);
                    a(aVar3, param, context, unitedSchemeEntity, callbackHandler);
                    return true;
                }
            } catch (JSONException e2) {
                e = e2;
                str = null;
            }
        }
        if (DEBUG) {
            Log.d("SwanGameLaunchAction", "launchParams: " + aVar3);
        }
        param = unitedSchemeEntity.getParam("downloadUrl");
        if ((!com.baidu.swan.apps.ad.a.a.aEN() || DEBUG) && !TextUtils.isEmpty(param)) {
            aVar3.fR(true);
            a(aVar3, param, context, unitedSchemeEntity, callbackHandler);
            return true;
        }
        SwanLauncher.atk().a(aVar3, (Bundle) null);
        com.baidu.swan.apps.u.a.a(str, l, callbackHandler, unitedSchemeEntity, null);
        return true;
    }

    private String l(Uri uri) {
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

    private String n(Uri uri) {
        return ai.deleteQueryParam(uri.getQuery(), dFW);
    }

    private void a(final c cVar, String str, Context context, final UnitedSchemeEntity unitedSchemeEntity, final CallbackHandler callbackHandler) {
        d.c cVar2 = new d.c();
        cVar2.mAppId = cVar.getAppId();
        cVar2.mDownloadUrl = str;
        final Context applicationContext = context.getApplicationContext();
        if (applicationContext != null) {
            com.baidu.swan.games.l.a.a(cVar2, new d.b() { // from class: com.baidu.swan.games.o.a.1
                @Override // com.baidu.swan.apps.r.d.b
                public void dO(int i) {
                }

                @Override // com.baidu.swan.apps.r.d.b
                public void onSuccess() {
                    if (a.DEBUG) {
                        Log.d("SwanGameLaunchAction", "onSuccess");
                    }
                    ak.runOnUiThread(new Runnable() { // from class: com.baidu.swan.games.o.a.1.1
                        @Override // java.lang.Runnable
                        public void run() {
                            com.baidu.swan.apps.res.widget.b.d.a(applicationContext, "小游戏包下载成功").aHZ();
                        }
                    });
                    cVar.oH("1.6.0");
                    cVar.fS(true);
                    com.baidu.swan.apps.u.c.b e = a.this.e(cVar);
                    if (e != null) {
                        com.baidu.swan.games.l.a.c(e, new com.baidu.swan.apps.r.b() { // from class: com.baidu.swan.games.o.a.1.2
                            @Override // com.baidu.swan.apps.r.b
                            public void a(int i, com.baidu.swan.apps.r.a aVar) {
                                a.b bVar = (a.b) aVar;
                                if (i == 0 && bVar != null && bVar.efZ != null) {
                                    cVar.hM(bVar.efZ.ehL);
                                    Intent a2 = c.a(applicationContext, cVar);
                                    a2.setAction("com.baidu.searchbox.action.aiapps.LAUNCH");
                                    a2.setFlags(268435456);
                                    applicationContext.startActivity(a2);
                                    UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(0));
                                }
                            }
                        });
                    }
                }

                @Override // com.baidu.swan.apps.r.d.b
                public void onFailed() {
                    if (a.DEBUG) {
                        Log.d("SwanGameLaunchAction", "onFailed");
                    }
                    com.baidu.swan.apps.al.a aVar = new com.baidu.swan.apps.al.a().cV(7L).cW(9L).to("debug download pkg fail");
                    e.aMQ().j(aVar);
                    com.baidu.swan.apps.u.b.a.a(applicationContext, aVar, 1, cVar.getAppId());
                    unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.baidu.swan.apps.u.c.b e(c cVar) {
        if (cVar == null) {
            return null;
        }
        com.baidu.swan.apps.u.c.b ayk = com.baidu.swan.apps.u.c.b.ayk();
        ayk.oz(cVar.getAppId());
        ayk.oC(cVar.ayC());
        ayk.oE(cVar.getPage());
        ayk.fS(cVar.isDebug());
        ayk.oF(cVar.ayJ());
        ayk.G(cVar.ayI());
        ayk.oD(cVar.ayE());
        ayk.oG(cVar.ayK());
        ayk.b(cVar.asb());
        ayk.c(cVar.asc());
        ayk.oH(cVar.ayN());
        ayk.ou("0");
        ayk.hN(cVar.getAppFrameType());
        return ayk;
    }
}
