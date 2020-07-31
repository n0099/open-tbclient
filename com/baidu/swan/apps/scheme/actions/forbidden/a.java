package com.baidu.swan.apps.scheme.actions.forbidden;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.swan.apps.aq.aj;
import com.baidu.swan.apps.aq.al;
import com.baidu.swan.apps.aq.v;
import com.baidu.swan.apps.core.d.f;
import com.baidu.swan.apps.runtime.d;
import com.baidu.swan.apps.runtime.e;
import com.baidu.swan.apps.storage.c.h;
import com.baidu.swan.apps.u.c.b;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
/* loaded from: classes7.dex */
public class a {
    private boolean cKf;
    private List<String> cKg;
    private String cKh;
    private static String TAG = "SwanAppPageForbidden";
    private static boolean DEBUG = com.baidu.swan.apps.b.DEBUG;

    private a() {
        this.cKf = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.swan.apps.scheme.actions.forbidden.a$a  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public static class C0390a {
        private static final a cKl = new a();
    }

    public static a asG() {
        return C0390a.cKl;
    }

    public boolean oQ(String str) {
        boolean z = false;
        if (!TextUtils.isEmpty(str) && com.baidu.swan.apps.e.a.a(d.arr().arn().Se())) {
            String delAllParamsFromUrl = aj.delAllParamsFromUrl(str);
            if (!TextUtils.isEmpty(delAllParamsFromUrl) && delAllParamsFromUrl.startsWith("/")) {
                delAllParamsFromUrl = delAllParamsFromUrl.substring(1);
            }
            if (!this.cKf) {
                if (com.baidu.swan.apps.performance.b.b.aoo()) {
                    asJ();
                } else {
                    asI();
                }
            }
            z = oR(delAllParamsFromUrl);
            if (DEBUG) {
                Log.d(TAG, "check, hitPath = " + z + " path = " + str);
            }
        }
        return z;
    }

    public boolean f(com.baidu.swan.apps.model.b bVar) {
        boolean z = false;
        if (bVar != null && com.baidu.swan.apps.e.a.a(d.arr().arn().Se())) {
            if (!this.cKf) {
                if (com.baidu.swan.apps.performance.b.b.aoo()) {
                    asJ();
                } else {
                    asI();
                }
            }
            z = (oR(bVar.mPage) || oR(bVar.cvJ)) ? true : true;
            if (DEBUG) {
                Log.d(TAG, "check, hitPath = " + z + " params = " + bVar.toString());
            }
        }
        return z;
    }

    public void c(final String str, com.baidu.swan.apps.model.b bVar) {
        final f Sc;
        String d;
        if (bVar != null && (Sc = com.baidu.swan.apps.v.f.akr().Sc()) != null && !(Sc.aaZ() instanceof com.baidu.swan.apps.core.d.d)) {
            if (oR(bVar.cvJ)) {
                d = com.baidu.swan.apps.model.b.e(bVar);
            } else {
                d = com.baidu.swan.apps.model.b.d(bVar);
            }
            if (DEBUG) {
                Log.d(TAG, "jump from " + str + " ; path = " + d);
            }
            e arn = d.arr().arn();
            b.a arz = arn.arz();
            ForbiddenInfo forbiddenInfo = new ForbiddenInfo();
            forbiddenInfo.appId = arn.getAppId();
            forbiddenInfo.appKey = arn.getAppKey();
            forbiddenInfo.appTitle = arz.aee();
            forbiddenInfo.forbiddenReason = asH();
            forbiddenInfo.launchSource = arz.ajg();
            forbiddenInfo.launchPath = d;
            forbiddenInfo.enableSlidingFlag = 0;
            final com.baidu.swan.apps.core.d.d a = com.baidu.swan.apps.core.d.d.a("type_path_forbidden", forbiddenInfo);
            al.runOnUiThread(new Runnable() { // from class: com.baidu.swan.apps.scheme.actions.forbidden.a.1
                @Override // java.lang.Runnable
                public void run() {
                    Sc.jO(str).ag(f.cci, f.cck).f(a).abl();
                }
            });
        }
    }

    public String asH() {
        return this.cKh;
    }

    private boolean oR(String str) {
        if (TextUtils.isEmpty(str) || this.cKg == null || this.cKg.isEmpty()) {
            return false;
        }
        return this.cKg.contains(str);
    }

    private String oS(String str) {
        return str + "_forbidden_path";
    }

    private String oT(String str) {
        return str + "_forbidden_tips";
    }

    public void c(JSONArray jSONArray, String str, String str2) {
        if (!TextUtils.isEmpty(str2)) {
            String oS = oS(str2);
            String oT = oT(str2);
            if (jSONArray == null || jSONArray.length() == 0) {
                b.asM().edit().remove(oS).remove(oT).apply();
                if (DEBUG) {
                    Log.d(TAG, "writeData, but list is null, appKey = " + str2 + " ; tips = " + str);
                    return;
                }
                return;
            }
            String jSONArray2 = jSONArray.toString();
            b.asM().edit().putString(oS, jSONArray2).putString(oT, str).apply();
            if (DEBUG) {
                Log.d(TAG, "writeData, appKey = " + str2 + " ; tips = " + str + " ; path = " + jSONArray2);
            }
        }
    }

    public void d(JSONArray jSONArray, String str, String str2) {
        if (!TextUtils.isEmpty(str2)) {
            String oS = oS(str2);
            String oT = oT(str2);
            if (jSONArray == null || jSONArray.length() == 0) {
                h.auW().edit().remove(oS).remove(oT).apply();
                if (DEBUG) {
                    Log.d(TAG, "writeDataSwanKv, but list is null, appKey = " + str2 + " ; tips = " + str);
                    return;
                }
                return;
            }
            String jSONArray2 = jSONArray.toString();
            h.auW().edit().putString(oS, jSONArray2).putString(oT, str).apply();
            if (DEBUG) {
                Log.d(TAG, "writeDataSwanKv, appKey = " + str2 + " ; tips = " + str + " ; path = " + jSONArray2);
            }
        }
    }

    private void asI() {
        b asM = b.asM();
        String appKey = d.arr().arn().getAppKey();
        this.cKh = asM.getString(oT(appKey), null);
        String string = asM.getString(oS(appKey), null);
        if (DEBUG) {
            Log.d(TAG, "readData, appKey = " + appKey + " ; tips = " + this.cKh + " ; path = " + string);
        }
        if (TextUtils.isEmpty(string)) {
            this.cKg = null;
        } else {
            JSONArray qA = v.qA(string);
            int length = qA.length();
            this.cKg = new ArrayList();
            for (int i = 0; i < length; i++) {
                String optString = qA.optString(i);
                if (!TextUtils.isEmpty(optString)) {
                    this.cKg.add(optString);
                }
            }
        }
        this.cKf = true;
    }

    private void asJ() {
        com.baidu.swan.apps.storage.c.b auW = h.auW();
        String appKey = d.arr().arn().getAppKey();
        String string = auW.getString(oS(appKey), null);
        if (DEBUG) {
            Log.d(TAG, "readDataSwanKv, appKey = " + appKey + " ; tips = " + this.cKh + " ; path = " + string);
        }
        if (TextUtils.isEmpty(string)) {
            this.cKg = null;
            this.cKh = null;
        } else {
            JSONArray qA = v.qA(string);
            int length = qA.length();
            this.cKg = new ArrayList();
            for (int i = 0; i < length; i++) {
                String optString = qA.optString(i);
                if (!TextUtils.isEmpty(optString)) {
                    this.cKg.add(optString);
                }
            }
            this.cKh = auW.getString(oT(appKey), null);
        }
        this.cKf = true;
    }

    public void asK() {
        if (DEBUG) {
            Log.d(TAG, "releaseData");
        }
        this.cKf = false;
        this.cKh = null;
        if (this.cKg != null) {
            this.cKg.clear();
            this.cKg = null;
        }
    }
}
