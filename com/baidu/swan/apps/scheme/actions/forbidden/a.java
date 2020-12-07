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
/* loaded from: classes25.dex */
public class a {
    private boolean dBf;
    private List<String> dBg;
    private String dBh;
    private static String TAG = "SwanAppPageForbidden";
    private static boolean DEBUG = b.DEBUG;

    private a() {
        this.dBf = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.swan.apps.scheme.actions.forbidden.a$a  reason: collision with other inner class name */
    /* loaded from: classes25.dex */
    public static class C0484a {
        private static final a dBl = new a();
    }

    public static a aLe() {
        return C0484a.dBl;
    }

    public boolean td(String str) {
        boolean z = false;
        if (!TextUtils.isEmpty(str) && com.baidu.swan.apps.f.a.a(d.aJQ().aJM().aio())) {
            String delAllParamsFromUrl = ai.delAllParamsFromUrl(str);
            if (!TextUtils.isEmpty(delAllParamsFromUrl) && delAllParamsFromUrl.startsWith("/")) {
                delAllParamsFromUrl = delAllParamsFromUrl.substring(1);
            }
            if (!this.dBf) {
                aLg();
            }
            z = te(delAllParamsFromUrl);
            if (DEBUG) {
                Log.d(TAG, "check, hitPath = " + z + " path = " + str);
            }
        }
        return z;
    }

    public boolean f(com.baidu.swan.apps.model.b bVar) {
        boolean z = false;
        if (bVar != null && com.baidu.swan.apps.f.a.a(d.aJQ().aJM().aio())) {
            if (!this.dBf) {
                aLg();
            }
            z = (te(bVar.mPage) || te(bVar.dlu)) ? true : true;
            if (DEBUG) {
                Log.d(TAG, "check, hitPath = " + z + " params = " + bVar.toString());
            }
        }
        return z;
    }

    public void c(final String str, com.baidu.swan.apps.model.b bVar) {
        final f aim;
        String d;
        if (bVar != null && (aim = com.baidu.swan.apps.v.f.aCp().aim()) != null && !(aim.arB() instanceof com.baidu.swan.apps.core.d.d)) {
            if (te(bVar.dlu)) {
                d = com.baidu.swan.apps.model.b.e(bVar);
            } else {
                d = com.baidu.swan.apps.model.b.d(bVar);
            }
            if (DEBUG) {
                Log.d(TAG, "jump from " + str + " ; path = " + d);
            }
            e aJM = d.aJQ().aJM();
            b.a aJY = aJM.aJY();
            ForbiddenInfo forbiddenInfo = new ForbiddenInfo();
            forbiddenInfo.appId = aJM.getAppId();
            forbiddenInfo.appKey = aJM.getAppKey();
            forbiddenInfo.appTitle = aJY.avf();
            forbiddenInfo.forbiddenReason = aLf();
            forbiddenInfo.launchSource = aJY.aBe();
            forbiddenInfo.launchPath = d;
            forbiddenInfo.enableSlidingFlag = 0;
            a(forbiddenInfo);
            final com.baidu.swan.apps.core.d.d a2 = com.baidu.swan.apps.core.d.d.a("type_path_forbidden", forbiddenInfo);
            ak.runOnUiThread(new Runnable() { // from class: com.baidu.swan.apps.scheme.actions.forbidden.a.1
                @Override // java.lang.Runnable
                public void run() {
                    aim.nC(str).an(f.cQb, f.cQd).f(a2).arM();
                }
            });
        }
    }

    private void a(ForbiddenInfo forbiddenInfo) {
        SwanAppActivity aJO;
        e aJV = e.aJV();
        if (aJV != null && (aJO = aJV.aJM().aJO()) != null) {
            String a2 = com.baidu.swan.apps.swancore.b.a(com.baidu.swan.apps.v.f.aCp().aBR(), aJV.aio().getAppFrameType());
            com.baidu.swan.apps.am.a aVar = new com.baidu.swan.apps.am.a();
            aVar.cU(10L).cV(48L).uA("path forbiddeon");
            forbiddenInfo.forbiddenDetail = aJO.getString(a.h.aiapps_open_failed_detail_format, ak.getVersionName(), a2, String.valueOf(aVar.aOo()));
        }
    }

    public String aLf() {
        return this.dBh;
    }

    private boolean te(String str) {
        if (TextUtils.isEmpty(str) || this.dBg == null || this.dBg.isEmpty()) {
            return false;
        }
        return this.dBg.contains(str);
    }

    private String tf(String str) {
        return str + "_forbidden_path";
    }

    private String tg(String str) {
        return str + "_forbidden_tips";
    }

    public void c(JSONArray jSONArray, String str, String str2) {
        if (!TextUtils.isEmpty(str2)) {
            String tf = tf(str2);
            String tg = tg(str2);
            if (jSONArray == null || jSONArray.length() == 0) {
                h.aNr().edit().remove(tf).remove(tg).apply();
                if (DEBUG) {
                    Log.d(TAG, "writeDataSwanKv, but list is null, appKey = " + str2 + " ; tips = " + str);
                    return;
                }
                return;
            }
            String jSONArray2 = jSONArray.toString();
            h.aNr().edit().putString(tf, jSONArray2).putString(tg, str).apply();
            if (DEBUG) {
                Log.d(TAG, "writeDataSwanKv, appKey = " + str2 + " ; tips = " + str + " ; path = " + jSONArray2);
            }
        }
    }

    private void aLg() {
        com.baidu.swan.apps.storage.c.b aNr = h.aNr();
        String appKey = d.aJQ().aJM().getAppKey();
        String string = aNr.getString(tf(appKey), null);
        if (DEBUG) {
            Log.d(TAG, "readDataSwanKv, appKey = " + appKey + " ; tips = " + this.dBh + " ; path = " + string);
        }
        if (TextUtils.isEmpty(string)) {
            this.dBg = null;
            this.dBh = null;
        } else {
            JSONArray uQ = v.uQ(string);
            int length = uQ.length();
            this.dBg = new ArrayList();
            for (int i = 0; i < length; i++) {
                String optString = uQ.optString(i);
                if (!TextUtils.isEmpty(optString)) {
                    this.dBg.add(optString);
                }
            }
            this.dBh = aNr.getString(tg(appKey), null);
        }
        this.dBf = true;
    }

    public void aLh() {
        if (DEBUG) {
            Log.d(TAG, "releaseData");
        }
        this.dBf = false;
        this.dBh = null;
        if (this.dBg != null) {
            this.dBg.clear();
            this.dBg = null;
        }
    }
}
