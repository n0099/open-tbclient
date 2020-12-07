package com.baidu.swan.apps.u.c;

import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.util.Pair;
import com.baidu.swan.apps.extcore.model.ExtensionCore;
import com.baidu.swan.apps.model.SwanAppBearInfo;
import com.baidu.swan.apps.swancore.model.SwanCoreVersion;
import com.baidu.swan.apps.u.c.e;
import com.baidu.swan.pms.model.PMSAppInfo;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes25.dex */
public abstract class e<SelfT extends e<SelfT>> extends com.baidu.swan.apps.u.c.a.c<SelfT> {
    protected static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private Pair<String, JSONObject> ddC;

    public boolean aBc() {
        return getBoolean("cts_launch_mode", false);
    }

    public SelfT fM(boolean z) {
        aa("cts_launch_mode", z);
        return (SelfT) aBa();
    }

    public String avf() {
        return getString("mAppTitle");
    }

    public SelfT pT(String str) {
        cb("mAppTitle", str);
        return (SelfT) aBa();
    }

    public String getAppKey() {
        return getString("mAppKey");
    }

    public SelfT pS(String str) {
        cb("mAppKey", str);
        return (SelfT) aBa();
    }

    public String getAppId() {
        return getString("mAppId", "");
    }

    public SelfT pR(String str) {
        cb("mAppId", str);
        return (SelfT) aBa();
    }

    public String getIconUrl() {
        return getString("app_icon_url");
    }

    public SelfT pQ(String str) {
        cb("app_icon_url", str);
        return (SelfT) aBa();
    }

    public String aAO() {
        return "";
    }

    public SelfT pP(String str) {
        return (SelfT) aBa();
    }

    public int aAP() {
        return 0;
    }

    public String aAQ() {
        return "";
    }

    public String aAR() {
        return "";
    }

    public String aAS() {
        return "";
    }

    public String aAT() {
        return "";
    }

    public SelfT pO(String str) {
        return (SelfT) aBa();
    }

    public String aAU() {
        return "";
    }

    public SelfT pN(String str) {
        return (SelfT) aBa();
    }

    public SwanAppBearInfo aAV() {
        return null;
    }

    public String aAW() {
        return "";
    }

    public String getVersion() {
        return "";
    }

    public SelfT pM(String str) {
        return (SelfT) aBa();
    }

    public String getVersionCode() {
        return "";
    }

    public int getType() {
        return 0;
    }

    public long aAX() {
        return 0L;
    }

    public int getOrientation() {
        int i = getInt("appFrameOrientation", -1);
        if (-1 < i) {
            return i;
        }
        return -1;
    }

    public SelfT jx(int i) {
        return (SelfT) S("appFrameOrientation", i);
    }

    public long aBd() {
        return getLong("navigate_bar_color_key", 2147483648L);
    }

    public SelfT ck(long j) {
        if (2147483648L != j) {
            p("navigate_bar_color_key", j);
        }
        return (SelfT) aBa();
    }

    public String aBe() {
        return getString("mFrom");
    }

    public String aBf() {
        return getString("mFromLast");
    }

    public SelfT pU(String str) {
        cb("mFromLast", aBe());
        return (SelfT) cb("mFrom", str);
    }

    public String aBg() {
        return getString("launchScheme");
    }

    public SelfT pV(String str) {
        return (SelfT) cb("launchScheme", str);
    }

    public String getPage() {
        return getString("mPage");
    }

    public SelfT pW(String str) {
        return (SelfT) cb("mPage", str);
    }

    public String aBh() {
        return getString("max_swan_version");
    }

    public String aBi() {
        return getString("min_swan_version");
    }

    public Bundle aBj() {
        return qe("mExtraData");
    }

    public SelfT G(Bundle bundle) {
        return (SelfT) d("mExtraData", bundle);
    }

    @NonNull
    public Bundle aBk() {
        Bundle aBj = aBj();
        if (aBj == null) {
            Bundle bundle = new Bundle();
            G(bundle);
            return bundle;
        }
        return aBj;
    }

    public SelfT ca(String str, String str2) {
        if (str != null && str2 != null) {
            aBk().putString(str, str2);
        }
        return (SelfT) aBa();
    }

    public SelfT o(String str, long j) {
        aBk().putLong(str, j);
        return (SelfT) aBa();
    }

    public String aBl() {
        return getString("mClickId");
    }

    public SelfT pX(String str) {
        return (SelfT) cb("mClickId", str);
    }

    public boolean isDebug() {
        return getBoolean("mIsDebug", false);
    }

    public SelfT fN(boolean z) {
        return (SelfT) aa("mIsDebug", z);
    }

    public String aBm() {
        return getString("notInHistory");
    }

    public SelfT pY(String str) {
        return (SelfT) cb("notInHistory", str);
    }

    public String aBn() {
        return getString("launch_app_open_url");
    }

    public String aBo() {
        return getString("launch_app_download_url");
    }

    public String aBp() {
        return getString("targetSwanVersion");
    }

    public SelfT pZ(String str) {
        return (SelfT) cb("targetSwanVersion", str);
    }

    public SwanCoreVersion auD() {
        return (SwanCoreVersion) qf("swanCoreVersion");
    }

    public SelfT b(SwanCoreVersion swanCoreVersion) {
        return (SelfT) a("swanCoreVersion", swanCoreVersion);
    }

    public ExtensionCore auE() {
        return (ExtensionCore) qf("extensionCore");
    }

    public SelfT c(ExtensionCore extensionCore) {
        return (SelfT) a("extensionCore", extensionCore);
    }

    public int getAppFrameType() {
        return getInt("appFrameType");
    }

    public SelfT jy(int i) {
        return (SelfT) S("appFrameType", i);
    }

    public boolean aBq() {
        return getBoolean("console_switch", false);
    }

    public SelfT fO(boolean z) {
        return (SelfT) aa("console_switch", z);
    }

    public int aBr() {
        return getInt("launchFlags", 0);
    }

    public SelfT jz(int i) {
        return (SelfT) S("launchFlags", i);
    }

    public SelfT jA(int i) {
        return jz(aBr() | i);
    }

    public long aAY() {
        return 0L;
    }

    public SelfT cj(long j) {
        return (SelfT) aBa();
    }

    public long aBs() {
        return getLong("last_start_timestamp");
    }

    public SelfT cl(long j) {
        return (SelfT) p("last_start_timestamp", j);
    }

    public String aBt() {
        return getString("remoteDebugUrl");
    }

    public SelfT qa(String str) {
        return (SelfT) cb("remoteDebugUrl", str);
    }

    public PMSAppInfo aBu() {
        return (PMSAppInfo) qf("pms_db_info_onload");
    }

    public SelfT k(PMSAppInfo pMSAppInfo) {
        return (SelfT) a("pms_db_info_onload", pMSAppInfo);
    }

    public SelfT l(PMSAppInfo pMSAppInfo) {
        if (pMSAppInfo != null) {
            a("pms_db_info_updated", pMSAppInfo);
            if (!aBv()) {
                k(pMSAppInfo);
            }
        }
        return (SelfT) aBa();
    }

    public boolean aBv() {
        return containsKey("pms_db_info_onload") && aBu() != null;
    }

    public JSONObject aBw() {
        String aBg = aBg();
        if (this.ddC != null && TextUtils.equals((CharSequence) this.ddC.first, aBg)) {
            return (JSONObject) this.ddC.second;
        }
        this.ddC = null;
        if (TextUtils.isEmpty(aBg)) {
            this.ddC = null;
            return null;
        }
        String queryParameter = Uri.parse(aBg).getQueryParameter("_baiduboxapp");
        if (!TextUtils.isEmpty(queryParameter)) {
            try {
                this.ddC = new Pair<>(aBg, new JSONObject(queryParameter).optJSONObject("ext"));
            } catch (JSONException e) {
                if (DEBUG) {
                    e.printStackTrace();
                }
            }
        }
        if (this.ddC == null) {
            return null;
        }
        return (JSONObject) this.ddC.second;
    }

    public String aBx() {
        return getString("launch_id");
    }

    public SelfT qb(String str) {
        return (SelfT) cb("launch_id", str);
    }

    public boolean aBy() {
        return getBoolean("swan_app_independent", false);
    }

    public SelfT fP(boolean z) {
        return (SelfT) aa("swan_app_independent", z);
    }

    public String aBz() {
        return getString("swan_app_sub_root_path");
    }

    public SelfT qc(String str) {
        return (SelfT) cb("swan_app_sub_root_path", str);
    }
}
