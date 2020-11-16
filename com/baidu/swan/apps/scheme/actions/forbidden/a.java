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
/* loaded from: classes7.dex */
public class a {
    private boolean dug;
    private List<String> duh;
    private String dui;
    private static String TAG = "SwanAppPageForbidden";
    private static boolean DEBUG = b.DEBUG;

    private a() {
        this.dug = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.swan.apps.scheme.actions.forbidden.a$a  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public static class C0472a {
        private static final a dum = new a();
    }

    public static a aHW() {
        return C0472a.dum;
    }

    public boolean sw(String str) {
        boolean z = false;
        if (!TextUtils.isEmpty(str) && com.baidu.swan.apps.f.a.a(d.aGI().aGE().afg())) {
            String delAllParamsFromUrl = ai.delAllParamsFromUrl(str);
            if (!TextUtils.isEmpty(delAllParamsFromUrl) && delAllParamsFromUrl.startsWith("/")) {
                delAllParamsFromUrl = delAllParamsFromUrl.substring(1);
            }
            if (!this.dug) {
                aHY();
            }
            z = sx(delAllParamsFromUrl);
            if (DEBUG) {
                Log.d(TAG, "check, hitPath = " + z + " path = " + str);
            }
        }
        return z;
    }

    public boolean f(com.baidu.swan.apps.model.b bVar) {
        boolean z = false;
        if (bVar != null && com.baidu.swan.apps.f.a.a(d.aGI().aGE().afg())) {
            if (!this.dug) {
                aHY();
            }
            z = (sx(bVar.mPage) || sx(bVar.dew)) ? true : true;
            if (DEBUG) {
                Log.d(TAG, "check, hitPath = " + z + " params = " + bVar.toString());
            }
        }
        return z;
    }

    public void c(final String str, com.baidu.swan.apps.model.b bVar) {
        final f afe;
        String d;
        if (bVar != null && (afe = com.baidu.swan.apps.v.f.azg().afe()) != null && !(afe.aot() instanceof com.baidu.swan.apps.core.d.d)) {
            if (sx(bVar.dew)) {
                d = com.baidu.swan.apps.model.b.e(bVar);
            } else {
                d = com.baidu.swan.apps.model.b.d(bVar);
            }
            if (DEBUG) {
                Log.d(TAG, "jump from " + str + " ; path = " + d);
            }
            e aGE = d.aGI().aGE();
            b.a aGQ = aGE.aGQ();
            ForbiddenInfo forbiddenInfo = new ForbiddenInfo();
            forbiddenInfo.appId = aGE.getAppId();
            forbiddenInfo.appKey = aGE.getAppKey();
            forbiddenInfo.appTitle = aGQ.arW();
            forbiddenInfo.forbiddenReason = aHX();
            forbiddenInfo.launchSource = aGQ.axV();
            forbiddenInfo.launchPath = d;
            forbiddenInfo.enableSlidingFlag = 0;
            a(forbiddenInfo);
            final com.baidu.swan.apps.core.d.d a2 = com.baidu.swan.apps.core.d.d.a("type_path_forbidden", forbiddenInfo);
            ak.runOnUiThread(new Runnable() { // from class: com.baidu.swan.apps.scheme.actions.forbidden.a.1
                @Override // java.lang.Runnable
                public void run() {
                    afe.mV(str).al(f.cJi, f.cJk).f(a2).aoE();
                }
            });
        }
    }

    private void a(ForbiddenInfo forbiddenInfo) {
        SwanAppActivity aGG;
        e aGN = e.aGN();
        if (aGN != null && (aGG = aGN.aGE().aGG()) != null) {
            String a2 = com.baidu.swan.apps.swancore.b.a(com.baidu.swan.apps.v.f.azg().ayI(), aGN.afg().getAppFrameType());
            com.baidu.swan.apps.am.a aVar = new com.baidu.swan.apps.am.a();
            aVar.cv(10L).cw(48L).tT("path forbiddeon");
            forbiddenInfo.forbiddenDetail = aGG.getString(a.h.aiapps_open_failed_detail_format, ak.getVersionName(), a2, String.valueOf(aVar.aLh()));
        }
    }

    public String aHX() {
        return this.dui;
    }

    private boolean sx(String str) {
        if (TextUtils.isEmpty(str) || this.duh == null || this.duh.isEmpty()) {
            return false;
        }
        return this.duh.contains(str);
    }

    private String sy(String str) {
        return str + "_forbidden_path";
    }

    private String sz(String str) {
        return str + "_forbidden_tips";
    }

    public void c(JSONArray jSONArray, String str, String str2) {
        if (!TextUtils.isEmpty(str2)) {
            String sy = sy(str2);
            String sz = sz(str2);
            if (jSONArray == null || jSONArray.length() == 0) {
                h.aKk().edit().remove(sy).remove(sz).apply();
                if (DEBUG) {
                    Log.d(TAG, "writeDataSwanKv, but list is null, appKey = " + str2 + " ; tips = " + str);
                    return;
                }
                return;
            }
            String jSONArray2 = jSONArray.toString();
            h.aKk().edit().putString(sy, jSONArray2).putString(sz, str).apply();
            if (DEBUG) {
                Log.d(TAG, "writeDataSwanKv, appKey = " + str2 + " ; tips = " + str + " ; path = " + jSONArray2);
            }
        }
    }

    private void aHY() {
        com.baidu.swan.apps.storage.c.b aKk = h.aKk();
        String appKey = d.aGI().aGE().getAppKey();
        String string = aKk.getString(sy(appKey), null);
        if (DEBUG) {
            Log.d(TAG, "readDataSwanKv, appKey = " + appKey + " ; tips = " + this.dui + " ; path = " + string);
        }
        if (TextUtils.isEmpty(string)) {
            this.duh = null;
            this.dui = null;
        } else {
            JSONArray uj = v.uj(string);
            int length = uj.length();
            this.duh = new ArrayList();
            for (int i = 0; i < length; i++) {
                String optString = uj.optString(i);
                if (!TextUtils.isEmpty(optString)) {
                    this.duh.add(optString);
                }
            }
            this.dui = aKk.getString(sz(appKey), null);
        }
        this.dug = true;
    }

    public void aHZ() {
        if (DEBUG) {
            Log.d(TAG, "releaseData");
        }
        this.dug = false;
        this.dui = null;
        if (this.duh != null) {
            this.duh.clear();
            this.duh = null;
        }
    }
}
