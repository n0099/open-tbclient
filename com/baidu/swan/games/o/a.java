package com.baidu.swan.games.o;

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
import com.baidu.swan.apps.an.e;
import com.baidu.swan.apps.aq.aj;
import com.baidu.swan.apps.aq.al;
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
/* loaded from: classes7.dex */
public class a extends UnitedSchemeBaseInterceptor {
    private static final boolean DEBUG = b.DEBUG;
    private static final Set<String> cLf = new HashSet();

    static {
        cLf.add("_baiduboxapp");
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
        String j = j(uri);
        if (DEBUG) {
            Log.d("SwanGameLaunchAction", "mAppId: " + j);
        }
        if (TextUtils.isEmpty(j)) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201);
            com.baidu.swan.apps.an.a qm = new com.baidu.swan.apps.an.a().bJ(1L).bK(1L).qm("appId is empty");
            e.avX().g(qm);
            h.b(new d().pu(h.ho(1)).f(qm).bV(SuspensionBallEntity.KEY_SCHEME, uri.toString()));
            return true;
        }
        String b = b(j, uri);
        if (DEBUG) {
            Log.d("SwanGameLaunchAction", "pagePath: " + b);
        }
        String l = l(uri);
        if (DEBUG) {
            Log.d("SwanGameLaunchAction", "query: " + l);
        }
        c.a aVar = (c.a) ((c.a) ((c.a) ((c.a) new c.a().lE(j)).lI(uri.toString())).fY(1)).el(false);
        if (!TextUtils.isEmpty(b)) {
            aVar.lJ(b + "?" + l);
        }
        String param2 = unitedSchemeEntity.getParam("_baiduboxapp");
        if (TextUtils.isEmpty(param2)) {
            str = null;
        } else {
            try {
                jSONObject = new JSONObject(param2);
                aVar.lH(jSONObject.optString("from"));
                aVar.lL(jSONObject.optString("notinhis"));
                aVar.bv("srcAppId", jSONObject.optString("srcAppId"));
                if (!jSONObject.isNull("extraData")) {
                    aVar.bv("extraData", jSONObject.optString("extraData"));
                }
                str = jSONObject.optString("navi");
            } catch (JSONException e2) {
                e = e2;
                str = null;
            }
            try {
                JSONObject a = com.baidu.swan.d.c.a(aVar.ajg(), jSONObject.optJSONObject("ubc"), "pre_source");
                if (a != null) {
                    aVar.bv("ubc", a.toString());
                }
                String optString = jSONObject.optString("veloce");
                if (!TextUtils.isEmpty(optString)) {
                    long optLong = new JSONObject(optString).optLong(LogBuilder.KEY_START_TIME);
                    if (optLong > 0) {
                        aVar.k("veloce_start_time", optLong);
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
                if (!com.baidu.swan.apps.ae.a.a.apc()) {
                }
                aVar.el(true);
                a(aVar, param, context, unitedSchemeEntity, callbackHandler);
                return true;
            }
        }
        if (DEBUG) {
            Log.d("SwanGameLaunchAction", "launchParams: " + aVar);
        }
        param = unitedSchemeEntity.getParam("downloadUrl");
        if ((!com.baidu.swan.apps.ae.a.a.apc() || DEBUG) && !TextUtils.isEmpty(param)) {
            aVar.el(true);
            a(aVar, param, context, unitedSchemeEntity, callbackHandler);
            return true;
        }
        SwanLauncher.aeL().a(aVar, (Bundle) null);
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
        return aj.deleteQueryParam(uri.getQuery(), cLf);
    }

    private void a(final c cVar, String str, Context context, final UnitedSchemeEntity unitedSchemeEntity, final CallbackHandler callbackHandler) {
        d.c cVar2 = new d.c();
        cVar2.mAppId = cVar.getAppId();
        cVar2.mDownloadUrl = str;
        final Context applicationContext = context.getApplicationContext();
        if (applicationContext != null) {
            com.baidu.swan.games.l.a.a(cVar2, new d.b() { // from class: com.baidu.swan.games.o.a.1
                @Override // com.baidu.swan.apps.r.d.b
                public void dE(int i) {
                }

                @Override // com.baidu.swan.apps.r.d.b
                public void onSuccess() {
                    if (a.DEBUG) {
                        Log.d("SwanGameLaunchAction", "onSuccess");
                    }
                    al.runOnUiThread(new Runnable() { // from class: com.baidu.swan.games.o.a.1.1
                        @Override // java.lang.Runnable
                        public void run() {
                            com.baidu.swan.apps.res.widget.b.d.a(applicationContext, "小游戏包下载成功").showToast();
                        }
                    });
                    cVar.lM("1.6.0");
                    cVar.em(true);
                    com.baidu.swan.apps.u.c.b e = a.this.e(cVar);
                    if (e != null) {
                        com.baidu.swan.games.l.a.c(e, new com.baidu.swan.apps.r.b() { // from class: com.baidu.swan.games.o.a.1.2
                            @Override // com.baidu.swan.apps.r.b
                            public void a(int i, com.baidu.swan.apps.r.a aVar) {
                                a.b bVar = (a.b) aVar;
                                if (i == 0 && bVar != null && bVar.djW != null) {
                                    cVar.fX(bVar.djW.dlJ);
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
                    com.baidu.swan.apps.an.a qm = new com.baidu.swan.apps.an.a().bJ(7L).bK(9L).qm("debug download pkg fail");
                    e.avX().g(qm);
                    com.baidu.swan.apps.u.b.a.a(applicationContext, qm, 1, cVar.getAppId());
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
        com.baidu.swan.apps.u.c.b aiP = com.baidu.swan.apps.u.c.b.aiP();
        aiP.lE(cVar.getAppId());
        aiP.lH(cVar.ajg());
        aiP.lJ(cVar.getPage());
        aiP.em(cVar.isDebug());
        aiP.lK(cVar.ajn());
        aiP.I(cVar.ajm());
        aiP.lI(cVar.aji());
        aiP.lL(cVar.ajo());
        aiP.b(cVar.adQ());
        aiP.c(cVar.adR());
        aiP.lM(cVar.ajr());
        aiP.lz("0");
        aiP.fY(cVar.getAppFrameType());
        return aiP;
    }
}
