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
import com.baidu.swan.apps.aq.ah;
import com.baidu.swan.apps.aq.aj;
import com.baidu.swan.apps.b;
import com.baidu.swan.apps.env.launch.SwanLauncher;
import com.baidu.swan.apps.r.e;
import com.baidu.swan.apps.statistic.a.d;
import com.baidu.swan.apps.statistic.h;
import com.baidu.swan.apps.v.b.c;
import com.baidu.swan.games.l.a;
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
    private static final Set<String> cHX = new HashSet();

    static {
        cHX.add("_baiduboxapp");
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
            com.baidu.swan.apps.an.a pB = new com.baidu.swan.apps.an.a().bw(1L).bx(1L).pB("appId is empty");
            e.atW().g(pB);
            h.b(new d().oK(h.hf(1)).f(pB).bU(SuspensionBallEntity.KEY_SCHEME, uri.toString()));
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
        c.a aVar = (c.a) ((c.a) ((c.a) ((c.a) new c.a().le(j)).li(uri.toString())).fO(1)).ed(false);
        if (!TextUtils.isEmpty(b)) {
            aVar.lj(b + "?" + l);
        }
        String param2 = unitedSchemeEntity.getParam("_baiduboxapp");
        if (TextUtils.isEmpty(param2)) {
            str = null;
        } else {
            try {
                jSONObject = new JSONObject(param2);
                aVar.lh(jSONObject.optString("from"));
                aVar.ll(jSONObject.optString("notinhis"));
                aVar.bt("srcAppId", jSONObject.optString("srcAppId"));
                if (!jSONObject.isNull("extraData")) {
                    aVar.bt("extraData", jSONObject.optString("extraData"));
                }
                str = jSONObject.optString("navi");
            } catch (JSONException e2) {
                e = e2;
                str = null;
            }
            try {
                JSONObject a = com.baidu.swan.e.c.a(aVar.ahQ(), jSONObject.optJSONObject("ubc"), "pre_source");
                if (a != null) {
                    aVar.bt("ubc", a.toString());
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
                if (!com.baidu.swan.apps.af.a.a.ant()) {
                }
                aVar.ed(true);
                a(aVar, param, context, unitedSchemeEntity, callbackHandler);
                return true;
            }
        }
        if (DEBUG) {
            Log.d("SwanGameLaunchAction", "launchParams: " + aVar);
        }
        param = unitedSchemeEntity.getParam("downloadUrl");
        if ((!com.baidu.swan.apps.af.a.a.ant() || DEBUG) && !TextUtils.isEmpty(param)) {
            aVar.ed(true);
            a(aVar, param, context, unitedSchemeEntity, callbackHandler);
            return true;
        }
        SwanLauncher.adE().a(aVar, (Bundle) null);
        com.baidu.swan.apps.v.a.a(str, j, callbackHandler, unitedSchemeEntity, null);
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
        return ah.deleteQueryParam(uri.getQuery(), cHX);
    }

    private void a(final c cVar, String str, Context context, final UnitedSchemeEntity unitedSchemeEntity, final CallbackHandler callbackHandler) {
        e.c cVar2 = new e.c();
        cVar2.mAppId = cVar.getAppId();
        cVar2.mDownloadUrl = str;
        final Context applicationContext = context.getApplicationContext();
        if (applicationContext != null) {
            com.baidu.swan.games.l.a.a(cVar2, new e.b() { // from class: com.baidu.swan.games.o.a.1
                @Override // com.baidu.swan.apps.r.e.b
                public void dE(int i) {
                }

                @Override // com.baidu.swan.apps.r.e.b
                public void onSuccess() {
                    if (a.DEBUG) {
                        Log.d("SwanGameLaunchAction", "onSuccess");
                    }
                    aj.runOnUiThread(new Runnable() { // from class: com.baidu.swan.games.o.a.1.1
                        @Override // java.lang.Runnable
                        public void run() {
                            com.baidu.swan.apps.res.widget.b.d.a(applicationContext, "小游戏包下载成功").showToast();
                        }
                    });
                    cVar.lm("1.6.0");
                    cVar.ee(true);
                    com.baidu.swan.apps.v.b.b e = a.this.e(cVar);
                    if (e != null) {
                        com.baidu.swan.games.l.a.c(e, new com.baidu.swan.apps.r.b() { // from class: com.baidu.swan.games.o.a.1.2
                            @Override // com.baidu.swan.apps.r.b
                            public void a(int i, com.baidu.swan.apps.r.a aVar) {
                                a.b bVar = (a.b) aVar;
                                if (i == 0 && bVar != null && bVar.dem != null) {
                                    cVar.fN(bVar.dem.dga);
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

                @Override // com.baidu.swan.apps.r.e.b
                public void onFailed() {
                    if (a.DEBUG) {
                        Log.d("SwanGameLaunchAction", "onFailed");
                    }
                    com.baidu.swan.apps.an.a pB = new com.baidu.swan.apps.an.a().bw(7L).bx(9L).pB("debug download pkg fail");
                    com.baidu.swan.apps.an.e.atW().g(pB);
                    com.baidu.swan.apps.v.a.a.a(applicationContext, pB, 1, cVar.getAppId());
                    unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.baidu.swan.apps.v.b.b e(c cVar) {
        if (cVar == null) {
            return null;
        }
        com.baidu.swan.apps.v.b.b ahz = com.baidu.swan.apps.v.b.b.ahz();
        ahz.le(cVar.getAppId());
        ahz.lh(cVar.ahQ());
        ahz.lj(cVar.getPage());
        ahz.ee(cVar.isDebug());
        ahz.lk(cVar.ahX());
        ahz.H(cVar.ahW());
        ahz.li(cVar.ahS());
        ahz.ll(cVar.ahY());
        ahz.b(cVar.acM());
        ahz.c(cVar.acN());
        ahz.lm(cVar.aib());
        ahz.kZ("0");
        ahz.fO(cVar.getAppFrameType());
        return ahz;
    }
}
