package com.baidu.swan.games.n;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.searchbox.suspensionball.SuspensionBallEntity;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.intercept.UnitedSchemeBaseInterceptor;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.swan.apps.ap.e;
import com.baidu.swan.apps.as.ag;
import com.baidu.swan.apps.as.ai;
import com.baidu.swan.apps.b;
import com.baidu.swan.apps.env.launch.SwanLauncher;
import com.baidu.swan.apps.statistic.a.d;
import com.baidu.swan.apps.statistic.f;
import com.baidu.swan.apps.t.e;
import com.baidu.swan.apps.x.b.c;
import com.baidu.swan.games.k.a;
import com.sina.weibo.sdk.statistic.LogBuilder;
import java.io.File;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class a extends UnitedSchemeBaseInterceptor {
    private static final boolean DEBUG = b.DEBUG;
    private static final Set<String> bSx = new HashSet();

    static {
        bSx.add("_baiduboxapp");
    }

    @Override // com.baidu.searchbox.unitedscheme.intercept.UnitedSchemeBaseInterceptor
    public String getInterceptorName() {
        return "aigames_launch_interceptor";
    }

    /* JADX WARN: Removed duplicated region for block: B:42:0x01ab  */
    @Override // com.baidu.searchbox.unitedscheme.intercept.UnitedSchemeBaseInterceptor, com.baidu.searchbox.unitedscheme.intercept.UnitedSchemeAbsInterceptor
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean shouldInterceptDispatch(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler) {
        JSONException e;
        String str;
        JSONObject jSONObject;
        String param;
        Uri uri = unitedSchemeEntity.getUri();
        if (uri == null || !TextUtils.equals(uri.getHost(), "swangame")) {
            return false;
        }
        if (unitedSchemeEntity.isOnlyVerify()) {
            return true;
        }
        String h = h(uri);
        if (DEBUG) {
            Log.d("SwanGameLaunchAction", "mAppId: " + h);
        }
        if (TextUtils.isEmpty(h)) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201);
            com.baidu.swan.apps.ap.a my = new com.baidu.swan.apps.ap.a().aI(1L).aJ(1L).my("appId is empty");
            e.agr().f(my);
            f.b(new d().lM(f.gs(1)).e(my).bn(SuspensionBallEntity.KEY_SCHEME, uri.toString()));
            return true;
        }
        String b = b(h, uri);
        if (DEBUG) {
            Log.d("SwanGameLaunchAction", "pagePath: " + b);
        }
        String j = j(uri);
        if (DEBUG) {
            Log.d("SwanGameLaunchAction", "query: " + j);
        }
        c.a aVar = (c.a) ((c.a) ((c.a) ((c.a) new c.a().ix(h)).iB(uri.toString())).fj(1)).cM(false);
        if (!TextUtils.isEmpty(b)) {
            aVar.iC(b + "?" + j);
        }
        String param2 = unitedSchemeEntity.getParam("_baiduboxapp");
        if (TextUtils.isEmpty(param2)) {
            str = null;
        } else {
            try {
                jSONObject = new JSONObject(param2);
                aVar.iA(jSONObject.optString("from"));
                aVar.iE(jSONObject.optString("notinhis"));
                aVar.aQ("srcAppId", jSONObject.optString("srcAppId"));
                if (!jSONObject.isNull("extraData")) {
                    aVar.aQ("extraData", jSONObject.optString("extraData"));
                }
                str = jSONObject.optString("navi");
            } catch (JSONException e2) {
                e = e2;
                str = null;
            }
            try {
                JSONObject a = com.baidu.swan.d.b.a(aVar.VM(), jSONObject.optJSONObject("ubc"), "pre_source");
                if (a != null) {
                    aVar.aQ("ubc", a.toString());
                }
                String optString = jSONObject.optString("veloce");
                if (!TextUtils.isEmpty(optString)) {
                    long optLong = new JSONObject(optString).optLong(LogBuilder.KEY_START_TIME);
                    if (optLong > 0) {
                        aVar.j("veloce_start_time", optLong);
                    }
                }
            } catch (JSONException e3) {
                e = e3;
                if (DEBUG) {
                    Log.d("SwanGameLaunchAction", "getLaunchFrom failed: " + Log.getStackTraceString(e));
                }
                if (DEBUG) {
                }
                param = unitedSchemeEntity.getParam("downloadUrl");
                if (!com.baidu.swan.apps.ah.a.a.aaC()) {
                }
                aVar.cM(true);
                a(aVar, param, context, unitedSchemeEntity, callbackHandler);
                return true;
            }
        }
        if (DEBUG) {
            Log.d("SwanGameLaunchAction", "launchParams: " + aVar);
        }
        param = unitedSchemeEntity.getParam("downloadUrl");
        if ((!com.baidu.swan.apps.ah.a.a.aaC() || DEBUG) && !TextUtils.isEmpty(param)) {
            aVar.cM(true);
            a(aVar, param, context, unitedSchemeEntity, callbackHandler);
            return true;
        }
        SwanLauncher.RJ().a(aVar, (Bundle) null);
        com.baidu.swan.apps.x.a.a(str, h, callbackHandler, unitedSchemeEntity);
        return true;
    }

    private String h(Uri uri) {
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
        return ag.deleteQueryParam(uri.getQuery(), bSx);
    }

    private void a(final c cVar, String str, Context context, final UnitedSchemeEntity unitedSchemeEntity, final CallbackHandler callbackHandler) {
        e.c cVar2 = new e.c();
        cVar2.mAppId = cVar.getAppId();
        cVar2.mDownloadUrl = str;
        final Context applicationContext = context.getApplicationContext();
        if (applicationContext != null) {
            com.baidu.swan.games.k.a.a(cVar2, new e.b() { // from class: com.baidu.swan.games.n.a.1
                @Override // com.baidu.swan.apps.t.e.b
                public void cX(int i) {
                }

                @Override // com.baidu.swan.apps.t.e.b
                public void onSuccess() {
                    if (a.DEBUG) {
                        Log.d("SwanGameLaunchAction", "onSuccess");
                    }
                    ai.runOnUiThread(new Runnable() { // from class: com.baidu.swan.games.n.a.1.1
                        @Override // java.lang.Runnable
                        public void run() {
                            com.baidu.swan.apps.res.widget.b.d.a(applicationContext, "小游戏包下载成功").showToast();
                        }
                    });
                    cVar.iF("1.6.0");
                    cVar.cN(true);
                    com.baidu.swan.apps.x.b.b e = a.this.e(cVar);
                    if (e != null) {
                        com.baidu.swan.games.k.a.c(e, new com.baidu.swan.apps.t.b() { // from class: com.baidu.swan.games.n.a.1.2
                            @Override // com.baidu.swan.apps.t.b
                            public void a(int i, com.baidu.swan.apps.t.a aVar) {
                                a.b bVar = (a.b) aVar;
                                if (i == 0 && bVar != null && bVar.cpF != null) {
                                    cVar.fi(bVar.cpF.crr);
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

                @Override // com.baidu.swan.apps.t.e.b
                public void onFailed() {
                    if (a.DEBUG) {
                        Log.d("SwanGameLaunchAction", "onFailed");
                    }
                    com.baidu.swan.apps.ap.a my = new com.baidu.swan.apps.ap.a().aI(7L).aJ(9L).my("debug download pkg fail");
                    com.baidu.swan.apps.ap.e.agr().f(my);
                    com.baidu.swan.apps.x.a.a.a(applicationContext, my, 1, cVar.getAppId());
                    unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.baidu.swan.apps.x.b.b e(c cVar) {
        if (cVar == null) {
            return null;
        }
        com.baidu.swan.apps.x.b.b Vv = com.baidu.swan.apps.x.b.b.Vv();
        Vv.ix(cVar.getAppId());
        Vv.iA(cVar.VM());
        Vv.iC(cVar.getPage());
        Vv.cN(cVar.isDebug());
        Vv.iD(cVar.VT());
        Vv.E(cVar.VS());
        Vv.iB(cVar.VO());
        Vv.iE(cVar.VU());
        Vv.b(cVar.QT());
        Vv.c(cVar.QU());
        Vv.iF(cVar.VX());
        Vv.is("0");
        Vv.fj(cVar.getAppFrameType());
        return Vv;
    }
}
