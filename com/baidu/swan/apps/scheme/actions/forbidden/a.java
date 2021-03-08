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
    private boolean dID;
    private List<String> dIE;
    private String dIF;
    private static String TAG = "SwanAppPageForbidden";
    private static boolean DEBUG = b.DEBUG;

    private a() {
        this.dID = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.swan.apps.scheme.actions.forbidden.a$a  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public static class C0463a {
        private static final a dIJ = new a();
    }

    public static a aJX() {
        return C0463a.dIJ;
    }

    public boolean so(String str) {
        boolean z = false;
        if (!TextUtils.isEmpty(str) && com.baidu.swan.apps.f.a.a(d.aIJ().aIF().agc())) {
            String delAllParamsFromUrl = ai.delAllParamsFromUrl(str);
            if (!TextUtils.isEmpty(delAllParamsFromUrl) && delAllParamsFromUrl.startsWith("/")) {
                delAllParamsFromUrl = delAllParamsFromUrl.substring(1);
            }
            if (!this.dID) {
                aJZ();
            }
            z = sp(delAllParamsFromUrl);
            if (DEBUG) {
                Log.d(TAG, "check, hitPath = " + z + " path = " + str);
            }
        }
        return z;
    }

    public boolean f(com.baidu.swan.apps.model.b bVar) {
        boolean z = false;
        if (bVar != null && com.baidu.swan.apps.f.a.a(d.aIJ().aIF().agc())) {
            if (!this.dID) {
                aJZ();
            }
            z = (sp(bVar.mPage) || sp(bVar.dps)) ? true : true;
            if (DEBUG) {
                Log.d(TAG, "check, hitPath = " + z + " params = " + bVar.toString());
            }
        }
        return z;
    }

    public void c(final String str, com.baidu.swan.apps.model.b bVar) {
        final f aga;
        String d;
        if (bVar != null && (aga = com.baidu.swan.apps.v.f.aAo().aga()) != null && !(aga.apA() instanceof com.baidu.swan.apps.core.d.d)) {
            if (sp(bVar.dps)) {
                d = com.baidu.swan.apps.model.b.e(bVar);
            } else {
                d = com.baidu.swan.apps.model.b.d(bVar);
            }
            if (DEBUG) {
                Log.d(TAG, "jump from " + str + " ; path = " + d);
            }
            e aIF = d.aIJ().aIF();
            b.a aIR = aIF.aIR();
            ForbiddenInfo forbiddenInfo = new ForbiddenInfo();
            forbiddenInfo.appId = aIF.getAppId();
            forbiddenInfo.appKey = aIF.getAppKey();
            forbiddenInfo.appTitle = aIR.atf();
            forbiddenInfo.forbiddenReason = aJY();
            forbiddenInfo.launchSource = aIR.azd();
            forbiddenInfo.launchPath = d;
            forbiddenInfo.enableSlidingFlag = 0;
            a(forbiddenInfo);
            final com.baidu.swan.apps.core.d.d a2 = com.baidu.swan.apps.core.d.d.a("type_path_forbidden", forbiddenInfo);
            ak.runOnUiThread(new Runnable() { // from class: com.baidu.swan.apps.scheme.actions.forbidden.a.1
                @Override // java.lang.Runnable
                public void run() {
                    aga.mJ(str).af(f.cTZ, f.cUb).f(a2).apL();
                }
            });
        }
    }

    private void a(ForbiddenInfo forbiddenInfo) {
        SwanAppActivity aIH;
        e aIO = e.aIO();
        if (aIO != null && (aIH = aIO.aIF().aIH()) != null) {
            String a2 = com.baidu.swan.apps.swancore.b.a(com.baidu.swan.apps.v.f.aAo().azQ(), aIO.agc().getAppFrameType());
            com.baidu.swan.apps.al.a aVar = new com.baidu.swan.apps.al.a();
            aVar.db(10L).dc(48L).tM("path forbiddeon");
            forbiddenInfo.forbiddenDetail = aIH.getString(a.h.aiapps_open_failed_detail_format, ak.getVersionName(), a2, String.valueOf(aVar.aNi()));
        }
    }

    public String aJY() {
        return this.dIF;
    }

    private boolean sp(String str) {
        if (TextUtils.isEmpty(str) || this.dIE == null || this.dIE.isEmpty()) {
            return false;
        }
        return this.dIE.contains(str);
    }

    private String sq(String str) {
        return str + "_forbidden_path";
    }

    private String ss(String str) {
        return str + "_forbidden_tips";
    }

    public void c(JSONArray jSONArray, String str, String str2) {
        if (!TextUtils.isEmpty(str2)) {
            String sq = sq(str2);
            String ss = ss(str2);
            if (jSONArray == null || jSONArray.length() == 0) {
                h.aMk().edit().remove(sq).remove(ss).apply();
                if (DEBUG) {
                    Log.d(TAG, "writeDataSwanKv, but list is null, appKey = " + str2 + " ; tips = " + str);
                    return;
                }
                return;
            }
            String jSONArray2 = jSONArray.toString();
            h.aMk().edit().putString(sq, jSONArray2).putString(ss, str).apply();
            if (DEBUG) {
                Log.d(TAG, "writeDataSwanKv, appKey = " + str2 + " ; tips = " + str + " ; path = " + jSONArray2);
            }
        }
    }

    private void aJZ() {
        com.baidu.swan.apps.storage.c.b aMk = h.aMk();
        String appKey = d.aIJ().aIF().getAppKey();
        String string = aMk.getString(sq(appKey), null);
        if (DEBUG) {
            Log.d(TAG, "readDataSwanKv, appKey = " + appKey + " ; tips = " + this.dIF + " ; path = " + string);
        }
        if (TextUtils.isEmpty(string)) {
            this.dIE = null;
            this.dIF = null;
        } else {
            JSONArray ue = v.ue(string);
            int length = ue.length();
            this.dIE = new ArrayList();
            for (int i = 0; i < length; i++) {
                String optString = ue.optString(i);
                if (!TextUtils.isEmpty(optString)) {
                    this.dIE.add(optString);
                }
            }
            this.dIF = aMk.getString(ss(appKey), null);
        }
        this.dID = true;
    }

    public void aKa() {
        if (DEBUG) {
            Log.d(TAG, "releaseData");
        }
        this.dID = false;
        this.dIF = null;
        if (this.dIE != null) {
            this.dIE.clear();
            this.dIE = null;
        }
    }
}
