package com.baidu.swan.apps.scheme.actions.forbidden;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.a;
import com.baidu.swan.apps.ap.ai;
import com.baidu.swan.apps.ap.ak;
import com.baidu.swan.apps.ap.v;
import com.baidu.swan.apps.b;
import com.baidu.swan.apps.core.d.f;
import com.baidu.swan.apps.runtime.d;
import com.baidu.swan.apps.runtime.e;
import com.baidu.swan.apps.storage.c.h;
import com.baidu.swan.apps.u.c.b;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
/* loaded from: classes3.dex */
public class a {
    private boolean cVi;
    private List<String> cVj;
    private String cVk;
    private static String TAG = "SwanAppPageForbidden";
    private static boolean DEBUG = b.DEBUG;

    private a() {
        this.cVi = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.swan.apps.scheme.actions.forbidden.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static class C0431a {
        private static final a cVo = new a();
    }

    public static a aBB() {
        return C0431a.cVo;
    }

    public boolean rh(String str) {
        boolean z = false;
        if (!TextUtils.isEmpty(str) && com.baidu.swan.apps.f.a.a(d.aAn().aAj().YI())) {
            String delAllParamsFromUrl = ai.delAllParamsFromUrl(str);
            if (!TextUtils.isEmpty(delAllParamsFromUrl) && delAllParamsFromUrl.startsWith("/")) {
                delAllParamsFromUrl = delAllParamsFromUrl.substring(1);
            }
            if (!this.cVi) {
                aBD();
            }
            z = ri(delAllParamsFromUrl);
            if (DEBUG) {
                Log.d(TAG, "check, hitPath = " + z + " path = " + str);
            }
        }
        return z;
    }

    public boolean f(com.baidu.swan.apps.model.b bVar) {
        boolean z = false;
        if (bVar != null && com.baidu.swan.apps.f.a.a(d.aAn().aAj().YI())) {
            if (!this.cVi) {
                aBD();
            }
            z = (ri(bVar.mPage) || ri(bVar.cFG)) ? true : true;
            if (DEBUG) {
                Log.d(TAG, "check, hitPath = " + z + " params = " + bVar.toString());
            }
        }
        return z;
    }

    public void c(final String str, com.baidu.swan.apps.model.b bVar) {
        final f YG;
        String d;
        if (bVar != null && (YG = com.baidu.swan.apps.v.f.asJ().YG()) != null && !(YG.ahW() instanceof com.baidu.swan.apps.core.d.d)) {
            if (ri(bVar.cFG)) {
                d = com.baidu.swan.apps.model.b.e(bVar);
            } else {
                d = com.baidu.swan.apps.model.b.d(bVar);
            }
            if (DEBUG) {
                Log.d(TAG, "jump from " + str + " ; path = " + d);
            }
            e aAj = d.aAn().aAj();
            b.a aAv = aAj.aAv();
            ForbiddenInfo forbiddenInfo = new ForbiddenInfo();
            forbiddenInfo.appId = aAj.getAppId();
            forbiddenInfo.appKey = aAj.getAppKey();
            forbiddenInfo.appTitle = aAv.aly();
            forbiddenInfo.forbiddenReason = aBC();
            forbiddenInfo.launchSource = aAv.arx();
            forbiddenInfo.launchPath = d;
            forbiddenInfo.enableSlidingFlag = 0;
            a(forbiddenInfo);
            final com.baidu.swan.apps.core.d.d a = com.baidu.swan.apps.core.d.d.a("type_path_forbidden", forbiddenInfo);
            ak.runOnUiThread(new Runnable() { // from class: com.baidu.swan.apps.scheme.actions.forbidden.a.1
                @Override // java.lang.Runnable
                public void run() {
                    YG.lH(str).al(f.ckl, f.ckn).f(a).aih();
                }
            });
        }
    }

    private void a(ForbiddenInfo forbiddenInfo) {
        SwanAppActivity aAl;
        e aAs = e.aAs();
        if (aAs != null && (aAl = aAs.aAj().aAl()) != null) {
            String a = com.baidu.swan.apps.swancore.b.a(com.baidu.swan.apps.v.f.asJ().ask(), aAs.YI().getAppFrameType());
            com.baidu.swan.apps.am.a aVar = new com.baidu.swan.apps.am.a();
            aVar.bP(10L).bQ(48L).sF("path forbiddeon");
            forbiddenInfo.forbiddenDetail = aAl.getString(a.h.aiapps_open_failed_detail_format, ak.getVersionName(), a, String.valueOf(aVar.aEM()));
        }
    }

    public String aBC() {
        return this.cVk;
    }

    private boolean ri(String str) {
        if (TextUtils.isEmpty(str) || this.cVj == null || this.cVj.isEmpty()) {
            return false;
        }
        return this.cVj.contains(str);
    }

    private String rj(String str) {
        return str + "_forbidden_path";
    }

    private String rk(String str) {
        return str + "_forbidden_tips";
    }

    public void c(JSONArray jSONArray, String str, String str2) {
        if (!TextUtils.isEmpty(str2)) {
            String rj = rj(str2);
            String rk = rk(str2);
            if (jSONArray == null || jSONArray.length() == 0) {
                h.aDP().edit().remove(rj).remove(rk).apply();
                if (DEBUG) {
                    Log.d(TAG, "writeDataSwanKv, but list is null, appKey = " + str2 + " ; tips = " + str);
                    return;
                }
                return;
            }
            String jSONArray2 = jSONArray.toString();
            h.aDP().edit().putString(rj, jSONArray2).putString(rk, str).apply();
            if (DEBUG) {
                Log.d(TAG, "writeDataSwanKv, appKey = " + str2 + " ; tips = " + str + " ; path = " + jSONArray2);
            }
        }
    }

    private void aBD() {
        com.baidu.swan.apps.storage.c.b aDP = h.aDP();
        String appKey = d.aAn().aAj().getAppKey();
        String string = aDP.getString(rj(appKey), null);
        if (DEBUG) {
            Log.d(TAG, "readDataSwanKv, appKey = " + appKey + " ; tips = " + this.cVk + " ; path = " + string);
        }
        if (TextUtils.isEmpty(string)) {
            this.cVj = null;
            this.cVk = null;
        } else {
            JSONArray sV = v.sV(string);
            int length = sV.length();
            this.cVj = new ArrayList();
            for (int i = 0; i < length; i++) {
                String optString = sV.optString(i);
                if (!TextUtils.isEmpty(optString)) {
                    this.cVj.add(optString);
                }
            }
            this.cVk = aDP.getString(rk(appKey), null);
        }
        this.cVi = true;
    }

    public void aBE() {
        if (DEBUG) {
            Log.d(TAG, "releaseData");
        }
        this.cVi = false;
        this.cVk = null;
        if (this.cVj != null) {
            this.cVj.clear();
            this.cVj = null;
        }
    }
}
