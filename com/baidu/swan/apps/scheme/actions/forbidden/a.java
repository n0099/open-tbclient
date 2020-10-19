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
/* loaded from: classes10.dex */
public class a {
    private boolean dhq;
    private List<String> dhr;
    private String dhs;
    private static String TAG = "SwanAppPageForbidden";
    private static boolean DEBUG = b.DEBUG;

    private a() {
        this.dhq = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.swan.apps.scheme.actions.forbidden.a$a  reason: collision with other inner class name */
    /* loaded from: classes10.dex */
    public static class C0448a {
        private static final a dhw = new a();
    }

    public static a aEk() {
        return C0448a.dhw;
    }

    public boolean rT(String str) {
        boolean z = false;
        if (!TextUtils.isEmpty(str) && com.baidu.swan.apps.f.a.a(d.aCW().aCS().abu())) {
            String delAllParamsFromUrl = ai.delAllParamsFromUrl(str);
            if (!TextUtils.isEmpty(delAllParamsFromUrl) && delAllParamsFromUrl.startsWith("/")) {
                delAllParamsFromUrl = delAllParamsFromUrl.substring(1);
            }
            if (!this.dhq) {
                aEm();
            }
            z = rU(delAllParamsFromUrl);
            if (DEBUG) {
                Log.d(TAG, "check, hitPath = " + z + " path = " + str);
            }
        }
        return z;
    }

    public boolean f(com.baidu.swan.apps.model.b bVar) {
        boolean z = false;
        if (bVar != null && com.baidu.swan.apps.f.a.a(d.aCW().aCS().abu())) {
            if (!this.dhq) {
                aEm();
            }
            z = (rU(bVar.mPage) || rU(bVar.cRK)) ? true : true;
            if (DEBUG) {
                Log.d(TAG, "check, hitPath = " + z + " params = " + bVar.toString());
            }
        }
        return z;
    }

    public void c(final String str, com.baidu.swan.apps.model.b bVar) {
        final f abs;
        String d;
        if (bVar != null && (abs = com.baidu.swan.apps.v.f.avu().abs()) != null && !(abs.akH() instanceof com.baidu.swan.apps.core.d.d)) {
            if (rU(bVar.cRK)) {
                d = com.baidu.swan.apps.model.b.e(bVar);
            } else {
                d = com.baidu.swan.apps.model.b.d(bVar);
            }
            if (DEBUG) {
                Log.d(TAG, "jump from " + str + " ; path = " + d);
            }
            e aCS = d.aCW().aCS();
            b.a aDe = aCS.aDe();
            ForbiddenInfo forbiddenInfo = new ForbiddenInfo();
            forbiddenInfo.appId = aCS.getAppId();
            forbiddenInfo.appKey = aCS.getAppKey();
            forbiddenInfo.appTitle = aDe.aoj();
            forbiddenInfo.forbiddenReason = aEl();
            forbiddenInfo.launchSource = aDe.auj();
            forbiddenInfo.launchPath = d;
            forbiddenInfo.enableSlidingFlag = 0;
            a(forbiddenInfo);
            final com.baidu.swan.apps.core.d.d a2 = com.baidu.swan.apps.core.d.d.a("type_path_forbidden", forbiddenInfo);
            ak.runOnUiThread(new Runnable() { // from class: com.baidu.swan.apps.scheme.actions.forbidden.a.1
                @Override // java.lang.Runnable
                public void run() {
                    abs.mt(str).ak(f.cwD, f.cwF).f(a2).akS();
                }
            });
        }
    }

    private void a(ForbiddenInfo forbiddenInfo) {
        SwanAppActivity aCU;
        e aDb = e.aDb();
        if (aDb != null && (aCU = aDb.aCS().aCU()) != null) {
            String a2 = com.baidu.swan.apps.swancore.b.a(com.baidu.swan.apps.v.f.avu().auW(), aDb.abu().getAppFrameType());
            com.baidu.swan.apps.am.a aVar = new com.baidu.swan.apps.am.a();
            aVar.bX(10L).bY(48L).tr("path forbiddeon");
            forbiddenInfo.forbiddenDetail = aCU.getString(a.h.aiapps_open_failed_detail_format, ak.getVersionName(), a2, String.valueOf(aVar.aHv()));
        }
    }

    public String aEl() {
        return this.dhs;
    }

    private boolean rU(String str) {
        if (TextUtils.isEmpty(str) || this.dhr == null || this.dhr.isEmpty()) {
            return false;
        }
        return this.dhr.contains(str);
    }

    private String rV(String str) {
        return str + "_forbidden_path";
    }

    private String rW(String str) {
        return str + "_forbidden_tips";
    }

    public void c(JSONArray jSONArray, String str, String str2) {
        if (!TextUtils.isEmpty(str2)) {
            String rV = rV(str2);
            String rW = rW(str2);
            if (jSONArray == null || jSONArray.length() == 0) {
                h.aGy().edit().remove(rV).remove(rW).apply();
                if (DEBUG) {
                    Log.d(TAG, "writeDataSwanKv, but list is null, appKey = " + str2 + " ; tips = " + str);
                    return;
                }
                return;
            }
            String jSONArray2 = jSONArray.toString();
            h.aGy().edit().putString(rV, jSONArray2).putString(rW, str).apply();
            if (DEBUG) {
                Log.d(TAG, "writeDataSwanKv, appKey = " + str2 + " ; tips = " + str + " ; path = " + jSONArray2);
            }
        }
    }

    private void aEm() {
        com.baidu.swan.apps.storage.c.b aGy = h.aGy();
        String appKey = d.aCW().aCS().getAppKey();
        String string = aGy.getString(rV(appKey), null);
        if (DEBUG) {
            Log.d(TAG, "readDataSwanKv, appKey = " + appKey + " ; tips = " + this.dhs + " ; path = " + string);
        }
        if (TextUtils.isEmpty(string)) {
            this.dhr = null;
            this.dhs = null;
        } else {
            JSONArray tH = v.tH(string);
            int length = tH.length();
            this.dhr = new ArrayList();
            for (int i = 0; i < length; i++) {
                String optString = tH.optString(i);
                if (!TextUtils.isEmpty(optString)) {
                    this.dhr.add(optString);
                }
            }
            this.dhs = aGy.getString(rW(appKey), null);
        }
        this.dhq = true;
    }

    public void aEn() {
        if (DEBUG) {
            Log.d(TAG, "releaseData");
        }
        this.dhq = false;
        this.dhs = null;
        if (this.dhr != null) {
            this.dhr.clear();
            this.dhr = null;
        }
    }
}
