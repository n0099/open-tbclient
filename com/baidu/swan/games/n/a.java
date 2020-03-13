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
    private static final Set<String> bSm = new HashSet();

    static {
        bSm.add("_baiduboxapp");
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
            com.baidu.swan.apps.ap.a mz = new com.baidu.swan.apps.ap.a().aI(1L).aJ(1L).mz("appId is empty");
            e.ago().f(mz);
            f.b(new d().lN(f.gs(1)).e(mz).bo(SuspensionBallEntity.KEY_SCHEME, uri.toString()));
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
        c.a aVar = (c.a) ((c.a) ((c.a) ((c.a) new c.a().iy(h)).iC(uri.toString())).fj(1)).cL(false);
        if (!TextUtils.isEmpty(b)) {
            aVar.iD(b + "?" + j);
        }
        String param2 = unitedSchemeEntity.getParam("_baiduboxapp");
        if (TextUtils.isEmpty(param2)) {
            str = null;
        } else {
            try {
                jSONObject = new JSONObject(param2);
                aVar.iB(jSONObject.optString("from"));
                aVar.iF(jSONObject.optString("notinhis"));
                aVar.aR("srcAppId", jSONObject.optString("srcAppId"));
                if (!jSONObject.isNull("extraData")) {
                    aVar.aR("extraData", jSONObject.optString("extraData"));
                }
                str = jSONObject.optString("navi");
            } catch (JSONException e2) {
                e = e2;
                str = null;
            }
            try {
                JSONObject a = com.baidu.swan.d.b.a(aVar.VJ(), jSONObject.optJSONObject("ubc"), "pre_source");
                if (a != null) {
                    aVar.aR("ubc", a.toString());
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
                if (!com.baidu.swan.apps.ah.a.a.aaz()) {
                }
                aVar.cL(true);
                a(aVar, param, context, unitedSchemeEntity, callbackHandler);
                return true;
            }
        }
        if (DEBUG) {
            Log.d("SwanGameLaunchAction", "launchParams: " + aVar);
        }
        param = unitedSchemeEntity.getParam("downloadUrl");
        if ((!com.baidu.swan.apps.ah.a.a.aaz() || DEBUG) && !TextUtils.isEmpty(param)) {
            aVar.cL(true);
            a(aVar, param, context, unitedSchemeEntity, callbackHandler);
            return true;
        }
        SwanLauncher.RG().a(aVar, (Bundle) null);
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
        return ag.deleteQueryParam(uri.getQuery(), bSm);
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
                    cVar.iG("1.6.0");
                    cVar.cM(true);
                    com.baidu.swan.apps.x.b.b e = a.this.e(cVar);
                    if (e != null) {
                        com.baidu.swan.games.k.a.c(e, new com.baidu.swan.apps.t.b() { // from class: com.baidu.swan.games.n.a.1.2
                            @Override // com.baidu.swan.apps.t.b
                            public void a(int i, com.baidu.swan.apps.t.a aVar) {
                                a.b bVar = (a.b) aVar;
                                if (i == 0 && bVar != null && bVar.cpt != null) {
                                    cVar.fi(bVar.cpt.crg);
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
                    com.baidu.swan.apps.ap.a mz = new com.baidu.swan.apps.ap.a().aI(7L).aJ(9L).mz("debug download pkg fail");
                    com.baidu.swan.apps.ap.e.ago().f(mz);
                    com.baidu.swan.apps.x.a.a.a(applicationContext, mz, 1, cVar.getAppId());
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
        com.baidu.swan.apps.x.b.b Vs = com.baidu.swan.apps.x.b.b.Vs();
        Vs.iy(cVar.getAppId());
        Vs.iB(cVar.VJ());
        Vs.iD(cVar.getPage());
        Vs.cM(cVar.isDebug());
        Vs.iE(cVar.VQ());
        Vs.E(cVar.VP());
        Vs.iC(cVar.VL());
        Vs.iF(cVar.VR());
        Vs.b(cVar.QQ());
        Vs.c(cVar.QR());
        Vs.iG(cVar.VU());
        Vs.it("0");
        Vs.fj(cVar.getAppFrameType());
        return Vs;
    }
}
