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
/* loaded from: classes9.dex */
public class a {
    private boolean dHc;
    private List<String> dHd;
    private String dHe;
    private static String TAG = "SwanAppPageForbidden";
    private static boolean DEBUG = b.DEBUG;

    private a() {
        this.dHc = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.swan.apps.scheme.actions.forbidden.a$a  reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public static class C0457a {
        private static final a dHi = new a();
    }

    public static a aJU() {
        return C0457a.dHi;
    }

    public boolean sh(String str) {
        boolean z = false;
        if (!TextUtils.isEmpty(str) && com.baidu.swan.apps.f.a.a(d.aIG().aIC().afZ())) {
            String delAllParamsFromUrl = ai.delAllParamsFromUrl(str);
            if (!TextUtils.isEmpty(delAllParamsFromUrl) && delAllParamsFromUrl.startsWith("/")) {
                delAllParamsFromUrl = delAllParamsFromUrl.substring(1);
            }
            if (!this.dHc) {
                aJW();
            }
            z = si(delAllParamsFromUrl);
            if (DEBUG) {
                Log.d(TAG, "check, hitPath = " + z + " path = " + str);
            }
        }
        return z;
    }

    public boolean f(com.baidu.swan.apps.model.b bVar) {
        boolean z = false;
        if (bVar != null && com.baidu.swan.apps.f.a.a(d.aIG().aIC().afZ())) {
            if (!this.dHc) {
                aJW();
            }
            z = (si(bVar.mPage) || si(bVar.dnO)) ? true : true;
            if (DEBUG) {
                Log.d(TAG, "check, hitPath = " + z + " params = " + bVar.toString());
            }
        }
        return z;
    }

    public void c(final String str, com.baidu.swan.apps.model.b bVar) {
        final f afX;
        String d;
        if (bVar != null && (afX = com.baidu.swan.apps.v.f.aAl().afX()) != null && !(afX.apx() instanceof com.baidu.swan.apps.core.d.d)) {
            if (si(bVar.dnO)) {
                d = com.baidu.swan.apps.model.b.e(bVar);
            } else {
                d = com.baidu.swan.apps.model.b.d(bVar);
            }
            if (DEBUG) {
                Log.d(TAG, "jump from " + str + " ; path = " + d);
            }
            e aIC = d.aIG().aIC();
            b.a aIO = aIC.aIO();
            ForbiddenInfo forbiddenInfo = new ForbiddenInfo();
            forbiddenInfo.appId = aIC.getAppId();
            forbiddenInfo.appKey = aIC.getAppKey();
            forbiddenInfo.appTitle = aIO.atc();
            forbiddenInfo.forbiddenReason = aJV();
            forbiddenInfo.launchSource = aIO.aza();
            forbiddenInfo.launchPath = d;
            forbiddenInfo.enableSlidingFlag = 0;
            a(forbiddenInfo);
            final com.baidu.swan.apps.core.d.d a2 = com.baidu.swan.apps.core.d.d.a("type_path_forbidden", forbiddenInfo);
            ak.runOnUiThread(new Runnable() { // from class: com.baidu.swan.apps.scheme.actions.forbidden.a.1
                @Override // java.lang.Runnable
                public void run() {
                    afX.mC(str).af(f.cSz, f.cSB).f(a2).apI();
                }
            });
        }
    }

    private void a(ForbiddenInfo forbiddenInfo) {
        SwanAppActivity aIE;
        e aIL = e.aIL();
        if (aIL != null && (aIE = aIL.aIC().aIE()) != null) {
            String a2 = com.baidu.swan.apps.swancore.b.a(com.baidu.swan.apps.v.f.aAl().azN(), aIL.afZ().getAppFrameType());
            com.baidu.swan.apps.al.a aVar = new com.baidu.swan.apps.al.a();
            aVar.db(10L).dc(48L).tF("path forbiddeon");
            forbiddenInfo.forbiddenDetail = aIE.getString(a.h.aiapps_open_failed_detail_format, ak.getVersionName(), a2, String.valueOf(aVar.aNf()));
        }
    }

    public String aJV() {
        return this.dHe;
    }

    private boolean si(String str) {
        if (TextUtils.isEmpty(str) || this.dHd == null || this.dHd.isEmpty()) {
            return false;
        }
        return this.dHd.contains(str);
    }

    private String sj(String str) {
        return str + "_forbidden_path";
    }

    private String sk(String str) {
        return str + "_forbidden_tips";
    }

    public void c(JSONArray jSONArray, String str, String str2) {
        if (!TextUtils.isEmpty(str2)) {
            String sj = sj(str2);
            String sk = sk(str2);
            if (jSONArray == null || jSONArray.length() == 0) {
                h.aMh().edit().remove(sj).remove(sk).apply();
                if (DEBUG) {
                    Log.d(TAG, "writeDataSwanKv, but list is null, appKey = " + str2 + " ; tips = " + str);
                    return;
                }
                return;
            }
            String jSONArray2 = jSONArray.toString();
            h.aMh().edit().putString(sj, jSONArray2).putString(sk, str).apply();
            if (DEBUG) {
                Log.d(TAG, "writeDataSwanKv, appKey = " + str2 + " ; tips = " + str + " ; path = " + jSONArray2);
            }
        }
    }

    private void aJW() {
        com.baidu.swan.apps.storage.c.b aMh = h.aMh();
        String appKey = d.aIG().aIC().getAppKey();
        String string = aMh.getString(sj(appKey), null);
        if (DEBUG) {
            Log.d(TAG, "readDataSwanKv, appKey = " + appKey + " ; tips = " + this.dHe + " ; path = " + string);
        }
        if (TextUtils.isEmpty(string)) {
            this.dHd = null;
            this.dHe = null;
        } else {
            JSONArray tX = v.tX(string);
            int length = tX.length();
            this.dHd = new ArrayList();
            for (int i = 0; i < length; i++) {
                String optString = tX.optString(i);
                if (!TextUtils.isEmpty(optString)) {
                    this.dHd.add(optString);
                }
            }
            this.dHe = aMh.getString(sk(appKey), null);
        }
        this.dHc = true;
    }

    public void aJX() {
        if (DEBUG) {
            Log.d(TAG, "releaseData");
        }
        this.dHc = false;
        this.dHe = null;
        if (this.dHd != null) {
            this.dHd.clear();
            this.dHd = null;
        }
    }
}
