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
    private boolean dJK;
    private List<String> dJL;
    private String dJM;
    private static String TAG = "SwanAppPageForbidden";
    private static boolean DEBUG = b.DEBUG;

    private a() {
        this.dJK = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.swan.apps.scheme.actions.forbidden.a$a  reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public static class C0477a {
        private static final a dJQ = new a();
    }

    public static a aNu() {
        return C0477a.dJQ;
    }

    public boolean ta(String str) {
        boolean z = false;
        if (!TextUtils.isEmpty(str) && com.baidu.swan.apps.f.a.a(d.aMg().aMc().aju())) {
            String delAllParamsFromUrl = ai.delAllParamsFromUrl(str);
            if (!TextUtils.isEmpty(delAllParamsFromUrl) && delAllParamsFromUrl.startsWith("/")) {
                delAllParamsFromUrl = delAllParamsFromUrl.substring(1);
            }
            if (!this.dJK) {
                aNw();
            }
            z = tb(delAllParamsFromUrl);
            if (DEBUG) {
                Log.d(TAG, "check, hitPath = " + z + " path = " + str);
            }
        }
        return z;
    }

    public boolean f(com.baidu.swan.apps.model.b bVar) {
        boolean z = false;
        if (bVar != null && com.baidu.swan.apps.f.a.a(d.aMg().aMc().aju())) {
            if (!this.dJK) {
                aNw();
            }
            z = (tb(bVar.mPage) || tb(bVar.dqt)) ? true : true;
            if (DEBUG) {
                Log.d(TAG, "check, hitPath = " + z + " params = " + bVar.toString());
            }
        }
        return z;
    }

    public void c(final String str, com.baidu.swan.apps.model.b bVar) {
        final f ajs;
        String d;
        if (bVar != null && (ajs = com.baidu.swan.apps.v.f.aDG().ajs()) != null && !(ajs.asT() instanceof com.baidu.swan.apps.core.d.d)) {
            if (tb(bVar.dqt)) {
                d = com.baidu.swan.apps.model.b.e(bVar);
            } else {
                d = com.baidu.swan.apps.model.b.d(bVar);
            }
            if (DEBUG) {
                Log.d(TAG, "jump from " + str + " ; path = " + d);
            }
            e aMc = d.aMg().aMc();
            b.a aMo = aMc.aMo();
            ForbiddenInfo forbiddenInfo = new ForbiddenInfo();
            forbiddenInfo.appId = aMc.getAppId();
            forbiddenInfo.appKey = aMc.getAppKey();
            forbiddenInfo.appTitle = aMo.awx();
            forbiddenInfo.forbiddenReason = aNv();
            forbiddenInfo.launchSource = aMo.aCv();
            forbiddenInfo.launchPath = d;
            forbiddenInfo.enableSlidingFlag = 0;
            a(forbiddenInfo);
            final com.baidu.swan.apps.core.d.d a2 = com.baidu.swan.apps.core.d.d.a("type_path_forbidden", forbiddenInfo);
            ak.runOnUiThread(new Runnable() { // from class: com.baidu.swan.apps.scheme.actions.forbidden.a.1
                @Override // java.lang.Runnable
                public void run() {
                    ajs.nv(str).ai(f.cUY, f.cVa).f(a2).ate();
                }
            });
        }
    }

    private void a(ForbiddenInfo forbiddenInfo) {
        SwanAppActivity aMe;
        e aMl = e.aMl();
        if (aMl != null && (aMe = aMl.aMc().aMe()) != null) {
            String a2 = com.baidu.swan.apps.swancore.b.a(com.baidu.swan.apps.v.f.aDG().aDi(), aMl.aju().getAppFrameType());
            com.baidu.swan.apps.al.a aVar = new com.baidu.swan.apps.al.a();
            aVar.cV(10L).cW(48L).ux("path forbiddeon");
            forbiddenInfo.forbiddenDetail = aMe.getString(a.h.aiapps_open_failed_detail_format, ak.getVersionName(), a2, String.valueOf(aVar.aQF()));
        }
    }

    public String aNv() {
        return this.dJM;
    }

    private boolean tb(String str) {
        if (TextUtils.isEmpty(str) || this.dJL == null || this.dJL.isEmpty()) {
            return false;
        }
        return this.dJL.contains(str);
    }

    private String tc(String str) {
        return str + "_forbidden_path";
    }

    private String td(String str) {
        return str + "_forbidden_tips";
    }

    public void c(JSONArray jSONArray, String str, String str2) {
        if (!TextUtils.isEmpty(str2)) {
            String tc = tc(str2);
            String td = td(str2);
            if (jSONArray == null || jSONArray.length() == 0) {
                h.aPH().edit().remove(tc).remove(td).apply();
                if (DEBUG) {
                    Log.d(TAG, "writeDataSwanKv, but list is null, appKey = " + str2 + " ; tips = " + str);
                    return;
                }
                return;
            }
            String jSONArray2 = jSONArray.toString();
            h.aPH().edit().putString(tc, jSONArray2).putString(td, str).apply();
            if (DEBUG) {
                Log.d(TAG, "writeDataSwanKv, appKey = " + str2 + " ; tips = " + str + " ; path = " + jSONArray2);
            }
        }
    }

    private void aNw() {
        com.baidu.swan.apps.storage.c.b aPH = h.aPH();
        String appKey = d.aMg().aMc().getAppKey();
        String string = aPH.getString(tc(appKey), null);
        if (DEBUG) {
            Log.d(TAG, "readDataSwanKv, appKey = " + appKey + " ; tips = " + this.dJM + " ; path = " + string);
        }
        if (TextUtils.isEmpty(string)) {
            this.dJL = null;
            this.dJM = null;
        } else {
            JSONArray uP = v.uP(string);
            int length = uP.length();
            this.dJL = new ArrayList();
            for (int i = 0; i < length; i++) {
                String optString = uP.optString(i);
                if (!TextUtils.isEmpty(optString)) {
                    this.dJL.add(optString);
                }
            }
            this.dJM = aPH.getString(td(appKey), null);
        }
        this.dJK = true;
    }

    public void aNx() {
        if (DEBUG) {
            Log.d(TAG, "releaseData");
        }
        this.dJK = false;
        this.dJM = null;
        if (this.dJL != null) {
            this.dJL.clear();
            this.dJL = null;
        }
    }
}
