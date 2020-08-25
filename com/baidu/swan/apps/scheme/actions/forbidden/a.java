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
/* loaded from: classes8.dex */
public class a {
    private boolean cTe;
    private List<String> cTf;
    private String cTg;
    private static String TAG = "SwanAppPageForbidden";
    private static boolean DEBUG = b.DEBUG;

    private a() {
        this.cTe = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.swan.apps.scheme.actions.forbidden.a$a  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public static class C0436a {
        private static final a cTk = new a();
    }

    public static a aAS() {
        return C0436a.cTk;
    }

    public boolean qN(String str) {
        boolean z = false;
        if (!TextUtils.isEmpty(str) && com.baidu.swan.apps.f.a.a(d.azE().azA().XZ())) {
            String delAllParamsFromUrl = ai.delAllParamsFromUrl(str);
            if (!TextUtils.isEmpty(delAllParamsFromUrl) && delAllParamsFromUrl.startsWith("/")) {
                delAllParamsFromUrl = delAllParamsFromUrl.substring(1);
            }
            if (!this.cTe) {
                aAU();
            }
            z = qO(delAllParamsFromUrl);
            if (DEBUG) {
                Log.d(TAG, "check, hitPath = " + z + " path = " + str);
            }
        }
        return z;
    }

    public boolean f(com.baidu.swan.apps.model.b bVar) {
        boolean z = false;
        if (bVar != null && com.baidu.swan.apps.f.a.a(d.azE().azA().XZ())) {
            if (!this.cTe) {
                aAU();
            }
            z = (qO(bVar.mPage) || qO(bVar.cDC)) ? true : true;
            if (DEBUG) {
                Log.d(TAG, "check, hitPath = " + z + " params = " + bVar.toString());
            }
        }
        return z;
    }

    public void c(final String str, com.baidu.swan.apps.model.b bVar) {
        final f XX;
        String d;
        if (bVar != null && (XX = com.baidu.swan.apps.v.f.arY().XX()) != null && !(XX.ahm() instanceof com.baidu.swan.apps.core.d.d)) {
            if (qO(bVar.cDC)) {
                d = com.baidu.swan.apps.model.b.e(bVar);
            } else {
                d = com.baidu.swan.apps.model.b.d(bVar);
            }
            if (DEBUG) {
                Log.d(TAG, "jump from " + str + " ; path = " + d);
            }
            e azA = d.azE().azA();
            b.a azM = azA.azM();
            ForbiddenInfo forbiddenInfo = new ForbiddenInfo();
            forbiddenInfo.appId = azA.getAppId();
            forbiddenInfo.appKey = azA.getAppKey();
            forbiddenInfo.appTitle = azM.akO();
            forbiddenInfo.forbiddenReason = aAT();
            forbiddenInfo.launchSource = azM.aqN();
            forbiddenInfo.launchPath = d;
            forbiddenInfo.enableSlidingFlag = 0;
            a(forbiddenInfo);
            final com.baidu.swan.apps.core.d.d a = com.baidu.swan.apps.core.d.d.a("type_path_forbidden", forbiddenInfo);
            ak.runOnUiThread(new Runnable() { // from class: com.baidu.swan.apps.scheme.actions.forbidden.a.1
                @Override // java.lang.Runnable
                public void run() {
                    XX.ln(str).al(f.cig, f.cii).f(a).ahx();
                }
            });
        }
    }

    private void a(ForbiddenInfo forbiddenInfo) {
        SwanAppActivity azC;
        e azJ = e.azJ();
        if (azJ != null && (azC = azJ.azA().azC()) != null) {
            String a = com.baidu.swan.apps.swancore.b.a(com.baidu.swan.apps.v.f.arY().arA(), azJ.XZ().getAppFrameType());
            com.baidu.swan.apps.am.a aVar = new com.baidu.swan.apps.am.a();
            aVar.bO(10L).bP(48L).sk("path forbiddeon");
            forbiddenInfo.forbiddenDetail = azC.getString(a.h.aiapps_open_failed_detail_format, ak.getVersionName(), a, String.valueOf(aVar.aEc()));
        }
    }

    public String aAT() {
        return this.cTg;
    }

    private boolean qO(String str) {
        if (TextUtils.isEmpty(str) || this.cTf == null || this.cTf.isEmpty()) {
            return false;
        }
        return this.cTf.contains(str);
    }

    private String qP(String str) {
        return str + "_forbidden_path";
    }

    private String qQ(String str) {
        return str + "_forbidden_tips";
    }

    public void c(JSONArray jSONArray, String str, String str2) {
        if (!TextUtils.isEmpty(str2)) {
            String qP = qP(str2);
            String qQ = qQ(str2);
            if (jSONArray == null || jSONArray.length() == 0) {
                h.aDf().edit().remove(qP).remove(qQ).apply();
                if (DEBUG) {
                    Log.d(TAG, "writeDataSwanKv, but list is null, appKey = " + str2 + " ; tips = " + str);
                    return;
                }
                return;
            }
            String jSONArray2 = jSONArray.toString();
            h.aDf().edit().putString(qP, jSONArray2).putString(qQ, str).apply();
            if (DEBUG) {
                Log.d(TAG, "writeDataSwanKv, appKey = " + str2 + " ; tips = " + str + " ; path = " + jSONArray2);
            }
        }
    }

    private void aAU() {
        com.baidu.swan.apps.storage.c.b aDf = h.aDf();
        String appKey = d.azE().azA().getAppKey();
        String string = aDf.getString(qP(appKey), null);
        if (DEBUG) {
            Log.d(TAG, "readDataSwanKv, appKey = " + appKey + " ; tips = " + this.cTg + " ; path = " + string);
        }
        if (TextUtils.isEmpty(string)) {
            this.cTf = null;
            this.cTg = null;
        } else {
            JSONArray sB = v.sB(string);
            int length = sB.length();
            this.cTf = new ArrayList();
            for (int i = 0; i < length; i++) {
                String optString = sB.optString(i);
                if (!TextUtils.isEmpty(optString)) {
                    this.cTf.add(optString);
                }
            }
            this.cTg = aDf.getString(qQ(appKey), null);
        }
        this.cTe = true;
    }

    public void aAV() {
        if (DEBUG) {
            Log.d(TAG, "releaseData");
        }
        this.cTe = false;
        this.cTg = null;
        if (this.cTf != null) {
            this.cTf.clear();
            this.cTf = null;
        }
    }
}
