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
    private boolean dvN;
    private List<String> dvO;
    private String dvP;
    private static String TAG = "SwanAppPageForbidden";
    private static boolean DEBUG = b.DEBUG;

    private a() {
        this.dvN = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.swan.apps.scheme.actions.forbidden.a$a  reason: collision with other inner class name */
    /* loaded from: classes10.dex */
    public static class C0474a {
        private static final a dvT = new a();
    }

    public static a aIE() {
        return C0474a.dvT;
    }

    public boolean sB(String str) {
        boolean z = false;
        if (!TextUtils.isEmpty(str) && com.baidu.swan.apps.f.a.a(d.aHq().aHm().afO())) {
            String delAllParamsFromUrl = ai.delAllParamsFromUrl(str);
            if (!TextUtils.isEmpty(delAllParamsFromUrl) && delAllParamsFromUrl.startsWith("/")) {
                delAllParamsFromUrl = delAllParamsFromUrl.substring(1);
            }
            if (!this.dvN) {
                aIG();
            }
            z = sC(delAllParamsFromUrl);
            if (DEBUG) {
                Log.d(TAG, "check, hitPath = " + z + " path = " + str);
            }
        }
        return z;
    }

    public boolean f(com.baidu.swan.apps.model.b bVar) {
        boolean z = false;
        if (bVar != null && com.baidu.swan.apps.f.a.a(d.aHq().aHm().afO())) {
            if (!this.dvN) {
                aIG();
            }
            z = (sC(bVar.mPage) || sC(bVar.dgd)) ? true : true;
            if (DEBUG) {
                Log.d(TAG, "check, hitPath = " + z + " params = " + bVar.toString());
            }
        }
        return z;
    }

    public void c(final String str, com.baidu.swan.apps.model.b bVar) {
        final f afM;
        String d;
        if (bVar != null && (afM = com.baidu.swan.apps.v.f.azO().afM()) != null && !(afM.apb() instanceof com.baidu.swan.apps.core.d.d)) {
            if (sC(bVar.dgd)) {
                d = com.baidu.swan.apps.model.b.e(bVar);
            } else {
                d = com.baidu.swan.apps.model.b.d(bVar);
            }
            if (DEBUG) {
                Log.d(TAG, "jump from " + str + " ; path = " + d);
            }
            e aHm = d.aHq().aHm();
            b.a aHy = aHm.aHy();
            ForbiddenInfo forbiddenInfo = new ForbiddenInfo();
            forbiddenInfo.appId = aHm.getAppId();
            forbiddenInfo.appKey = aHm.getAppKey();
            forbiddenInfo.appTitle = aHy.asF();
            forbiddenInfo.forbiddenReason = aIF();
            forbiddenInfo.launchSource = aHy.ayD();
            forbiddenInfo.launchPath = d;
            forbiddenInfo.enableSlidingFlag = 0;
            a(forbiddenInfo);
            final com.baidu.swan.apps.core.d.d a2 = com.baidu.swan.apps.core.d.d.a("type_path_forbidden", forbiddenInfo);
            ak.runOnUiThread(new Runnable() { // from class: com.baidu.swan.apps.scheme.actions.forbidden.a.1
                @Override // java.lang.Runnable
                public void run() {
                    afM.nb(str).al(f.cKS, f.cKU).f(a2).apn();
                }
            });
        }
    }

    private void a(ForbiddenInfo forbiddenInfo) {
        SwanAppActivity aHo;
        e aHv = e.aHv();
        if (aHv != null && (aHo = aHv.aHm().aHo()) != null) {
            String a2 = com.baidu.swan.apps.swancore.b.a(com.baidu.swan.apps.v.f.azO().azq(), aHv.afO().getAppFrameType());
            com.baidu.swan.apps.am.a aVar = new com.baidu.swan.apps.am.a();
            aVar.cv(10L).cw(48L).tY("path forbiddeon");
            forbiddenInfo.forbiddenDetail = aHo.getString(a.h.aiapps_open_failed_detail_format, ak.getVersionName(), a2, String.valueOf(aVar.aLP()));
        }
    }

    public String aIF() {
        return this.dvP;
    }

    private boolean sC(String str) {
        if (TextUtils.isEmpty(str) || this.dvO == null || this.dvO.isEmpty()) {
            return false;
        }
        return this.dvO.contains(str);
    }

    private String sD(String str) {
        return str + "_forbidden_path";
    }

    private String sE(String str) {
        return str + "_forbidden_tips";
    }

    public void c(JSONArray jSONArray, String str, String str2) {
        if (!TextUtils.isEmpty(str2)) {
            String sD = sD(str2);
            String sE = sE(str2);
            if (jSONArray == null || jSONArray.length() == 0) {
                h.aKS().edit().remove(sD).remove(sE).apply();
                if (DEBUG) {
                    Log.d(TAG, "writeDataSwanKv, but list is null, appKey = " + str2 + " ; tips = " + str);
                    return;
                }
                return;
            }
            String jSONArray2 = jSONArray.toString();
            h.aKS().edit().putString(sD, jSONArray2).putString(sE, str).apply();
            if (DEBUG) {
                Log.d(TAG, "writeDataSwanKv, appKey = " + str2 + " ; tips = " + str + " ; path = " + jSONArray2);
            }
        }
    }

    private void aIG() {
        com.baidu.swan.apps.storage.c.b aKS = h.aKS();
        String appKey = d.aHq().aHm().getAppKey();
        String string = aKS.getString(sD(appKey), null);
        if (DEBUG) {
            Log.d(TAG, "readDataSwanKv, appKey = " + appKey + " ; tips = " + this.dvP + " ; path = " + string);
        }
        if (TextUtils.isEmpty(string)) {
            this.dvO = null;
            this.dvP = null;
        } else {
            JSONArray uo = v.uo(string);
            int length = uo.length();
            this.dvO = new ArrayList();
            for (int i = 0; i < length; i++) {
                String optString = uo.optString(i);
                if (!TextUtils.isEmpty(optString)) {
                    this.dvO.add(optString);
                }
            }
            this.dvP = aKS.getString(sE(appKey), null);
        }
        this.dvN = true;
    }

    public void aIH() {
        if (DEBUG) {
            Log.d(TAG, "releaseData");
        }
        this.dvN = false;
        this.dvP = null;
        if (this.dvO != null) {
            this.dvO.clear();
            this.dvO = null;
        }
    }
}
