package com.baidu.swan.apps.scheme.actions.forbidden;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.a;
import com.baidu.swan.apps.ao.ai;
import com.baidu.swan.apps.ao.ak;
import com.baidu.swan.apps.ao.v;
import com.baidu.swan.apps.b;
import com.baidu.swan.apps.core.d.f;
import com.baidu.swan.apps.runtime.d;
import com.baidu.swan.apps.runtime.e;
import com.baidu.swan.apps.storage.c.h;
import com.baidu.swan.apps.u.c.b;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
/* loaded from: classes8.dex */
public class a {
    private boolean dEY;
    private List<String> dEZ;
    private String dFa;
    private static String TAG = "SwanAppPageForbidden";
    private static boolean DEBUG = b.DEBUG;

    private a() {
        this.dEY = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.swan.apps.scheme.actions.forbidden.a$a  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public static class C0460a {
        private static final a dFe = new a();
    }

    public static a aJB() {
        return C0460a.dFe;
    }

    public boolean rO(String str) {
        boolean z = false;
        if (!TextUtils.isEmpty(str) && com.baidu.swan.apps.f.a.a(d.aIn().aIj().afB())) {
            String delAllParamsFromUrl = ai.delAllParamsFromUrl(str);
            if (!TextUtils.isEmpty(delAllParamsFromUrl) && delAllParamsFromUrl.startsWith("/")) {
                delAllParamsFromUrl = delAllParamsFromUrl.substring(1);
            }
            if (!this.dEY) {
                aJD();
            }
            z = rP(delAllParamsFromUrl);
            if (DEBUG) {
                Log.d(TAG, "check, hitPath = " + z + " path = " + str);
            }
        }
        return z;
    }

    public boolean f(com.baidu.swan.apps.model.b bVar) {
        boolean z = false;
        if (bVar != null && com.baidu.swan.apps.f.a.a(d.aIn().aIj().afB())) {
            if (!this.dEY) {
                aJD();
            }
            z = (rP(bVar.mPage) || rP(bVar.dlD)) ? true : true;
            if (DEBUG) {
                Log.d(TAG, "check, hitPath = " + z + " params = " + bVar.toString());
            }
        }
        return z;
    }

    public void c(final String str, com.baidu.swan.apps.model.b bVar) {
        final f afz;
        String d;
        if (bVar != null && (afz = com.baidu.swan.apps.v.f.azN().afz()) != null && !(afz.aoY() instanceof com.baidu.swan.apps.core.d.d)) {
            if (rP(bVar.dlD)) {
                d = com.baidu.swan.apps.model.b.e(bVar);
            } else {
                d = com.baidu.swan.apps.model.b.d(bVar);
            }
            if (DEBUG) {
                Log.d(TAG, "jump from " + str + " ; path = " + d);
            }
            e aIj = d.aIn().aIj();
            b.a aIv = aIj.aIv();
            ForbiddenInfo forbiddenInfo = new ForbiddenInfo();
            forbiddenInfo.appId = aIj.getAppId();
            forbiddenInfo.appKey = aIj.getAppKey();
            forbiddenInfo.appTitle = aIv.asE();
            forbiddenInfo.forbiddenReason = aJC();
            forbiddenInfo.launchSource = aIv.ayC();
            forbiddenInfo.launchPath = d;
            forbiddenInfo.enableSlidingFlag = 0;
            a(forbiddenInfo);
            final com.baidu.swan.apps.core.d.d a2 = com.baidu.swan.apps.core.d.d.a("type_path_forbidden", forbiddenInfo);
            ak.runOnUiThread(new Runnable() { // from class: com.baidu.swan.apps.scheme.actions.forbidden.a.1
                @Override // java.lang.Runnable
                public void run() {
                    afz.mk(str).ai(f.cQm, f.cQo).f(a2).apk();
                }
            });
        }
    }

    private void a(ForbiddenInfo forbiddenInfo) {
        SwanAppActivity aIl;
        e aIs = e.aIs();
        if (aIs != null && (aIl = aIs.aIj().aIl()) != null) {
            String a2 = com.baidu.swan.apps.swancore.b.a(com.baidu.swan.apps.v.f.azN().azp(), aIs.afB().getAppFrameType());
            com.baidu.swan.apps.al.a aVar = new com.baidu.swan.apps.al.a();
            aVar.cV(10L).cW(48L).tm("path forbiddeon");
            forbiddenInfo.forbiddenDetail = aIl.getString(a.h.aiapps_open_failed_detail_format, ak.getVersionName(), a2, String.valueOf(aVar.aMM()));
        }
    }

    public String aJC() {
        return this.dFa;
    }

    private boolean rP(String str) {
        if (TextUtils.isEmpty(str) || this.dEZ == null || this.dEZ.isEmpty()) {
            return false;
        }
        return this.dEZ.contains(str);
    }

    private String rQ(String str) {
        return str + "_forbidden_path";
    }

    private String rR(String str) {
        return str + "_forbidden_tips";
    }

    public void c(JSONArray jSONArray, String str, String str2) {
        if (!TextUtils.isEmpty(str2)) {
            String rQ = rQ(str2);
            String rR = rR(str2);
            if (jSONArray == null || jSONArray.length() == 0) {
                h.aLO().edit().remove(rQ).remove(rR).apply();
                if (DEBUG) {
                    Log.d(TAG, "writeDataSwanKv, but list is null, appKey = " + str2 + " ; tips = " + str);
                    return;
                }
                return;
            }
            String jSONArray2 = jSONArray.toString();
            h.aLO().edit().putString(rQ, jSONArray2).putString(rR, str).apply();
            if (DEBUG) {
                Log.d(TAG, "writeDataSwanKv, appKey = " + str2 + " ; tips = " + str + " ; path = " + jSONArray2);
            }
        }
    }

    private void aJD() {
        com.baidu.swan.apps.storage.c.b aLO = h.aLO();
        String appKey = d.aIn().aIj().getAppKey();
        String string = aLO.getString(rQ(appKey), null);
        if (DEBUG) {
            Log.d(TAG, "readDataSwanKv, appKey = " + appKey + " ; tips = " + this.dFa + " ; path = " + string);
        }
        if (TextUtils.isEmpty(string)) {
            this.dEZ = null;
            this.dFa = null;
        } else {
            JSONArray tE = v.tE(string);
            int length = tE.length();
            this.dEZ = new ArrayList();
            for (int i = 0; i < length; i++) {
                String optString = tE.optString(i);
                if (!TextUtils.isEmpty(optString)) {
                    this.dEZ.add(optString);
                }
            }
            this.dFa = aLO.getString(rR(appKey), null);
        }
        this.dEY = true;
    }

    public void aJE() {
        if (DEBUG) {
            Log.d(TAG, "releaseData");
        }
        this.dEY = false;
        this.dFa = null;
        if (this.dEZ != null) {
            this.dEZ.clear();
            this.dEZ = null;
        }
    }
}
