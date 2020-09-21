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
import com.baidu.swan.apps.am.e;
import com.baidu.swan.apps.ap.ai;
import com.baidu.swan.apps.ap.ak;
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
/* loaded from: classes3.dex */
public class a extends UnitedSchemeBaseInterceptor {
    private static final boolean DEBUG = b.DEBUG;
    private static final Set<String> cWh = new HashSet();

    static {
        cWh.add("_baiduboxapp");
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
        JSONException e;
        String str;
        String param;
        Uri uri = unitedSchemeEntity.getUri();
        if (uri == null || !TextUtils.equals(uri.getHost(), "swangame")) {
            return false;
        }
        if (unitedSchemeEntity.isOnlyVerify()) {
            return true;
        }
        String j = j(uri);
        if (DEBUG) {
            Log.d("SwanGameLaunchAction", "mAppId: " + j);
        }
        if (TextUtils.isEmpty(j)) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201);
            com.baidu.swan.apps.am.a sH = new com.baidu.swan.apps.am.a().bP(1L).bQ(1L).sH("appId is empty");
            e.aEQ().j(sH);
            h.b(new d().rO(h.jG(1)).i(sH).cm("scheme", uri.toString()));
            return true;
        }
        if (com.baidu.swan.games.utils.so.d.aQQ() != null) {
            boolean exists = new File(com.baidu.swan.games.utils.so.d.aQQ()).exists();
            if (DEBUG) {
                Log.d("V8LoadChecker", "is v8 load success: " + exists);
            }
            if (!exists) {
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201);
                com.baidu.swan.apps.am.a sH2 = new com.baidu.swan.apps.am.a().bP(1L).bQ(1L).sH("v8 is error");
                e.aEQ().j(sH2);
                h.b(new d().rO(h.jG(1)).i(sH2).cm(V8Engine.TYPE_V8, uri.toString()));
                return true;
            }
        }
        String b = b(j, uri);
        if (DEBUG) {
            Log.d("SwanGameLaunchAction", "pagePath: " + b);
        }
        String l = l(uri);
        if (DEBUG) {
            Log.d("SwanGameLaunchAction", "query: " + l);
        }
        c.a aVar = (c.a) ((c.a) ((c.a) ((c.a) new c.a().nV(j)).nZ(uri.toString())).im(1)).eC(false);
        if (!TextUtils.isEmpty(b)) {
            aVar.oa(b + "?" + l);
        }
        String param2 = unitedSchemeEntity.getParam("_baiduboxapp");
        if (TextUtils.isEmpty(param2)) {
            str = null;
        } else {
            try {
                JSONObject jSONObject = new JSONObject(param2);
                aVar.nY(jSONObject.optString("from"));
                aVar.oc(jSONObject.optString("notinhis"));
                aVar.bI("srcAppId", jSONObject.optString("srcAppId"));
                if (!jSONObject.isNull("extraData")) {
                    aVar.bI("extraData", jSONObject.optString("extraData"));
                }
                str = jSONObject.optString("navi");
                try {
                    JSONObject a = com.baidu.swan.c.c.a(aVar.arx(), jSONObject.optJSONObject("ubc"), "pre_source");
                    if (a != null) {
                        aVar.bI("ubc", a.toString());
                    }
                    String optString = jSONObject.optString("veloce");
                    if (!TextUtils.isEmpty(optString)) {
                        long optLong = new JSONObject(optString).optLong(LogBuilder.KEY_START_TIME);
                        if (optLong > 0) {
                            aVar.n("veloce_start_time", optLong);
                        }
                    }
                } catch (JSONException e2) {
                    e = e2;
                    if (DEBUG) {
                        Log.d("SwanGameLaunchAction", "getLaunchFrom failed: " + Log.getStackTraceString(e));
                    }
                    if (DEBUG) {
                    }
                    param = unitedSchemeEntity.getParam("downloadUrl");
                    if (!com.baidu.swan.apps.ad.a.a.axI()) {
                    }
                    aVar.eC(true);
                    a(aVar, param, context, unitedSchemeEntity, callbackHandler);
                    return true;
                }
            } catch (JSONException e3) {
                e = e3;
                str = null;
            }
        }
        if (DEBUG) {
            Log.d("SwanGameLaunchAction", "launchParams: " + aVar);
        }
        param = unitedSchemeEntity.getParam("downloadUrl");
        if ((!com.baidu.swan.apps.ad.a.a.axI() || DEBUG) && !TextUtils.isEmpty(param)) {
            aVar.eC(true);
            a(aVar, param, context, unitedSchemeEntity, callbackHandler);
            return true;
        }
        SwanLauncher.ame().a(aVar, (Bundle) null);
        com.baidu.swan.apps.u.a.a(str, j, callbackHandler, unitedSchemeEntity, null);
        return true;
    }

    private String j(Uri uri) {
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

    private String l(Uri uri) {
        return ai.deleteQueryParam(uri.getQuery(), cWh);
    }

    private void a(final c cVar, String str, Context context, final UnitedSchemeEntity unitedSchemeEntity, final CallbackHandler callbackHandler) {
        d.c cVar2 = new d.c();
        cVar2.mAppId = cVar.getAppId();
        cVar2.mDownloadUrl = str;
        final Context applicationContext = context.getApplicationContext();
        if (applicationContext != null) {
            com.baidu.swan.games.l.a.a(cVar2, new d.b() { // from class: com.baidu.swan.games.o.a.1
                @Override // com.baidu.swan.apps.r.d.b
                public void eO(int i) {
                }

                @Override // com.baidu.swan.apps.r.d.b
                public void onSuccess() {
                    if (a.DEBUG) {
                        Log.d("SwanGameLaunchAction", "onSuccess");
                    }
                    ak.runOnUiThread(new Runnable() { // from class: com.baidu.swan.games.o.a.1.1
                        @Override // java.lang.Runnable
                        public void run() {
                            com.baidu.swan.apps.res.widget.b.d.a(applicationContext, "小游戏包下载成功").showToast();
                        }
                    });
                    cVar.od("1.6.0");
                    cVar.eD(true);
                    com.baidu.swan.apps.u.c.b e = a.this.e(cVar);
                    if (e != null) {
                        com.baidu.swan.games.l.a.c(e, new com.baidu.swan.apps.r.b() { // from class: com.baidu.swan.games.o.a.1.2
                            @Override // com.baidu.swan.apps.r.b
                            public void a(int i, com.baidu.swan.apps.r.a aVar) {
                                a.b bVar = (a.b) aVar;
                                if (i == 0 && bVar != null && bVar.dwj != null) {
                                    cVar.il(bVar.dwj.dxT);
                                    Intent a = c.a(applicationContext, cVar);
                                    a.setAction("com.baidu.searchbox.action.aiapps.LAUNCH");
                                    a.setFlags(268435456);
                                    applicationContext.startActivity(a);
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
                    com.baidu.swan.apps.am.a sH = new com.baidu.swan.apps.am.a().bP(7L).bQ(9L).sH("debug download pkg fail");
                    e.aEQ().j(sH);
                    com.baidu.swan.apps.u.b.a.a(applicationContext, sH, 1, cVar.getAppId());
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
        com.baidu.swan.apps.u.c.b arf = com.baidu.swan.apps.u.c.b.arf();
        arf.nV(cVar.getAppId());
        arf.nY(cVar.arx());
        arf.oa(cVar.getPage());
        arf.eD(cVar.isDebug());
        arf.ob(cVar.arE());
        arf.G(cVar.arD());
        arf.nZ(cVar.arz());
        arf.oc(cVar.arF());
        arf.b(cVar.akX());
        arf.c(cVar.akY());
        arf.od(cVar.arI());
        arf.nQ("0");
        arf.im(cVar.getAppFrameType());
        return arf;
    }
}
