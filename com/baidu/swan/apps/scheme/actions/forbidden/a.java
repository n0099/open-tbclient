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
    private boolean dpS;
    private List<String> dpT;
    private String dpU;
    private static String TAG = "SwanAppPageForbidden";
    private static boolean DEBUG = b.DEBUG;

    private a() {
        this.dpS = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.swan.apps.scheme.actions.forbidden.a$a  reason: collision with other inner class name */
    /* loaded from: classes10.dex */
    public static class C0462a {
        private static final a dpY = new a();
    }

    public static a aGe() {
        return C0462a.dpY;
    }

    public boolean sm(String str) {
        boolean z = false;
        if (!TextUtils.isEmpty(str) && com.baidu.swan.apps.f.a.a(d.aEQ().aEM().ado())) {
            String delAllParamsFromUrl = ai.delAllParamsFromUrl(str);
            if (!TextUtils.isEmpty(delAllParamsFromUrl) && delAllParamsFromUrl.startsWith("/")) {
                delAllParamsFromUrl = delAllParamsFromUrl.substring(1);
            }
            if (!this.dpS) {
                aGg();
            }
            z = sn(delAllParamsFromUrl);
            if (DEBUG) {
                Log.d(TAG, "check, hitPath = " + z + " path = " + str);
            }
        }
        return z;
    }

    public boolean f(com.baidu.swan.apps.model.b bVar) {
        boolean z = false;
        if (bVar != null && com.baidu.swan.apps.f.a.a(d.aEQ().aEM().ado())) {
            if (!this.dpS) {
                aGg();
            }
            z = (sn(bVar.mPage) || sn(bVar.dag)) ? true : true;
            if (DEBUG) {
                Log.d(TAG, "check, hitPath = " + z + " params = " + bVar.toString());
            }
        }
        return z;
    }

    public void c(final String str, com.baidu.swan.apps.model.b bVar) {
        final f adm;
        String d;
        if (bVar != null && (adm = com.baidu.swan.apps.v.f.axo().adm()) != null && !(adm.amB() instanceof com.baidu.swan.apps.core.d.d)) {
            if (sn(bVar.dag)) {
                d = com.baidu.swan.apps.model.b.e(bVar);
            } else {
                d = com.baidu.swan.apps.model.b.d(bVar);
            }
            if (DEBUG) {
                Log.d(TAG, "jump from " + str + " ; path = " + d);
            }
            e aEM = d.aEQ().aEM();
            b.a aEY = aEM.aEY();
            ForbiddenInfo forbiddenInfo = new ForbiddenInfo();
            forbiddenInfo.appId = aEM.getAppId();
            forbiddenInfo.appKey = aEM.getAppKey();
            forbiddenInfo.appTitle = aEY.aqe();
            forbiddenInfo.forbiddenReason = aGf();
            forbiddenInfo.launchSource = aEY.awd();
            forbiddenInfo.launchPath = d;
            forbiddenInfo.enableSlidingFlag = 0;
            a(forbiddenInfo);
            final com.baidu.swan.apps.core.d.d a2 = com.baidu.swan.apps.core.d.d.a("type_path_forbidden", forbiddenInfo);
            ak.runOnUiThread(new Runnable() { // from class: com.baidu.swan.apps.scheme.actions.forbidden.a.1
                @Override // java.lang.Runnable
                public void run() {
                    adm.mM(str).al(f.cEZ, f.cFb).f(a2).amM();
                }
            });
        }
    }

    private void a(ForbiddenInfo forbiddenInfo) {
        SwanAppActivity aEO;
        e aEV = e.aEV();
        if (aEV != null && (aEO = aEV.aEM().aEO()) != null) {
            String a2 = com.baidu.swan.apps.swancore.b.a(com.baidu.swan.apps.v.f.axo().awQ(), aEV.ado().getAppFrameType());
            com.baidu.swan.apps.am.a aVar = new com.baidu.swan.apps.am.a();
            aVar.bZ(10L).ca(48L).tK("path forbiddeon");
            forbiddenInfo.forbiddenDetail = aEO.getString(a.h.aiapps_open_failed_detail_format, ak.getVersionName(), a2, String.valueOf(aVar.aJp()));
        }
    }

    public String aGf() {
        return this.dpU;
    }

    private boolean sn(String str) {
        if (TextUtils.isEmpty(str) || this.dpT == null || this.dpT.isEmpty()) {
            return false;
        }
        return this.dpT.contains(str);
    }

    private String so(String str) {
        return str + "_forbidden_path";
    }

    private String sp(String str) {
        return str + "_forbidden_tips";
    }

    public void c(JSONArray jSONArray, String str, String str2) {
        if (!TextUtils.isEmpty(str2)) {
            String so = so(str2);
            String sp = sp(str2);
            if (jSONArray == null || jSONArray.length() == 0) {
                h.aIs().edit().remove(so).remove(sp).apply();
                if (DEBUG) {
                    Log.d(TAG, "writeDataSwanKv, but list is null, appKey = " + str2 + " ; tips = " + str);
                    return;
                }
                return;
            }
            String jSONArray2 = jSONArray.toString();
            h.aIs().edit().putString(so, jSONArray2).putString(sp, str).apply();
            if (DEBUG) {
                Log.d(TAG, "writeDataSwanKv, appKey = " + str2 + " ; tips = " + str + " ; path = " + jSONArray2);
            }
        }
    }

    private void aGg() {
        com.baidu.swan.apps.storage.c.b aIs = h.aIs();
        String appKey = d.aEQ().aEM().getAppKey();
        String string = aIs.getString(so(appKey), null);
        if (DEBUG) {
            Log.d(TAG, "readDataSwanKv, appKey = " + appKey + " ; tips = " + this.dpU + " ; path = " + string);
        }
        if (TextUtils.isEmpty(string)) {
            this.dpT = null;
            this.dpU = null;
        } else {
            JSONArray ua = v.ua(string);
            int length = ua.length();
            this.dpT = new ArrayList();
            for (int i = 0; i < length; i++) {
                String optString = ua.optString(i);
                if (!TextUtils.isEmpty(optString)) {
                    this.dpT.add(optString);
                }
            }
            this.dpU = aIs.getString(sp(appKey), null);
        }
        this.dpS = true;
    }

    public void aGh() {
        if (DEBUG) {
            Log.d(TAG, "releaseData");
        }
        this.dpS = false;
        this.dpU = null;
        if (this.dpT != null) {
            this.dpT.clear();
            this.dpT = null;
        }
    }
}
