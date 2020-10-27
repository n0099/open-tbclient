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
/* loaded from: classes10.dex */
public abstract class e<SelfT extends e<SelfT>> extends com.baidu.swan.apps.u.c.a.c<SelfT> {
    protected static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private Pair<String, JSONObject> cSv;

    public boolean awb() {
        return getBoolean("cts_launch_mode", false);
    }

    public SelfT fl(boolean z) {
        Z("cts_launch_mode", z);
        return (SelfT) avZ();
    }

    public String aqe() {
        return getString("mAppTitle");
    }

    public SelfT pe(String str) {
        bV("mAppTitle", str);
        return (SelfT) avZ();
    }

    public String getAppKey() {
        return getString("mAppKey");
    }

    public SelfT pd(String str) {
        bV("mAppKey", str);
        return (SelfT) avZ();
    }

    public String getAppId() {
        return getString("mAppId", "");
    }

    public SelfT pc(String str) {
        bV("mAppId", str);
        return (SelfT) avZ();
    }

    public String getIconUrl() {
        return getString("app_icon_url");
    }

    public SelfT pb(String str) {
        bV("app_icon_url", str);
        return (SelfT) avZ();
    }

    public String avN() {
        return "";
    }

    public SelfT pa(String str) {
        return (SelfT) avZ();
    }

    public int avO() {
        return 0;
    }

    public String avP() {
        return "";
    }

    public String avQ() {
        return "";
    }

    public String avR() {
        return "";
    }

    public String avS() {
        return "";
    }

    public SelfT oZ(String str) {
        return (SelfT) avZ();
    }

    public String avT() {
        return "";
    }

    public SelfT oY(String str) {
        return (SelfT) avZ();
    }

    public SwanAppBearInfo avU() {
        return null;
    }

    public String avV() {
        return "";
    }

    public String getVersion() {
        return "";
    }

    public SelfT oX(String str) {
        return (SelfT) avZ();
    }

    public String getVersionCode() {
        return "";
    }

    public int getType() {
        return 0;
    }

    public long avW() {
        return 0L;
    }

    public int getOrientation() {
        int i = getInt("appFrameOrientation", -1);
        if (-1 < i) {
            return i;
        }
        return -1;
    }

    public SelfT iT(int i) {
        return (SelfT) P("appFrameOrientation", i);
    }

    public long awc() {
        return getLong("navigate_bar_color_key", 2147483648L);
    }

    public SelfT bp(long j) {
        if (2147483648L != j) {
            p("navigate_bar_color_key", j);
        }
        return (SelfT) avZ();
    }

    public String awd() {
        return getString("mFrom");
    }

    public String awe() {
        return getString("mFromLast");
    }

    public SelfT pf(String str) {
        bV("mFromLast", awd());
        return (SelfT) bV("mFrom", str);
    }

    public String awf() {
        return getString("launchScheme");
    }

    public SelfT pg(String str) {
        return (SelfT) bV("launchScheme", str);
    }

    public String getPage() {
        return getString("mPage");
    }

    public SelfT ph(String str) {
        return (SelfT) bV("mPage", str);
    }

    public String awg() {
        return getString("max_swan_version");
    }

    public String awh() {
        return getString("min_swan_version");
    }

    public Bundle awi() {
        return pp("mExtraData");
    }

    public SelfT G(Bundle bundle) {
        return (SelfT) d("mExtraData", bundle);
    }

    @NonNull
    public Bundle awj() {
        Bundle awi = awi();
        if (awi == null) {
            Bundle bundle = new Bundle();
            G(bundle);
            return bundle;
        }
        return awi;
    }

    public SelfT bU(String str, String str2) {
        if (str != null && str2 != null) {
            awj().putString(str, str2);
        }
        return (SelfT) avZ();
    }

    public SelfT o(String str, long j) {
        awj().putLong(str, j);
        return (SelfT) avZ();
    }

    public String awk() {
        return getString("mClickId");
    }

    public SelfT pi(String str) {
        return (SelfT) bV("mClickId", str);
    }

    public boolean isDebug() {
        return getBoolean("mIsDebug", false);
    }

    public SelfT fm(boolean z) {
        return (SelfT) Z("mIsDebug", z);
    }

    public String awl() {
        return getString("notInHistory");
    }

    public SelfT pj(String str) {
        return (SelfT) bV("notInHistory", str);
    }

    public String awm() {
        return getString("launch_app_open_url");
    }

    public String awn() {
        return getString("launch_app_download_url");
    }

    public String awo() {
        return getString("targetSwanVersion");
    }

    public SelfT pk(String str) {
        return (SelfT) bV("targetSwanVersion", str);
    }

    public SwanCoreVersion apD() {
        return (SwanCoreVersion) pq("swanCoreVersion");
    }

    public SelfT b(SwanCoreVersion swanCoreVersion) {
        return (SelfT) a("swanCoreVersion", swanCoreVersion);
    }

    public ExtensionCore apE() {
        return (ExtensionCore) pq("extensionCore");
    }

    public SelfT c(ExtensionCore extensionCore) {
        return (SelfT) a("extensionCore", extensionCore);
    }

    public int getAppFrameType() {
        return getInt("appFrameType");
    }

    public SelfT iU(int i) {
        return (SelfT) P("appFrameType", i);
    }

    public boolean awp() {
        return getBoolean("console_switch", false);
    }

    public SelfT fn(boolean z) {
        return (SelfT) Z("console_switch", z);
    }

    public int awq() {
        return getInt("launchFlags", 0);
    }

    public SelfT iV(int i) {
        return (SelfT) P("launchFlags", i);
    }

    public SelfT iW(int i) {
        return iV(awq() | i);
    }

    public long avX() {
        return 0L;
    }

    public SelfT bo(long j) {
        return (SelfT) avZ();
    }

    public long awr() {
        return getLong("last_start_timestamp");
    }

    public SelfT bq(long j) {
        return (SelfT) p("last_start_timestamp", j);
    }

    public String aws() {
        return getString("remoteDebugUrl");
    }

    public SelfT pl(String str) {
        return (SelfT) bV("remoteDebugUrl", str);
    }

    public PMSAppInfo awt() {
        return (PMSAppInfo) pq("pms_db_info_onload");
    }

    public SelfT k(PMSAppInfo pMSAppInfo) {
        return (SelfT) a("pms_db_info_onload", pMSAppInfo);
    }

    public SelfT l(PMSAppInfo pMSAppInfo) {
        if (pMSAppInfo != null) {
            a("pms_db_info_updated", pMSAppInfo);
            if (!awu()) {
                k(pMSAppInfo);
            }
        }
        return (SelfT) avZ();
    }

    public boolean awu() {
        return containsKey("pms_db_info_onload") && awt() != null;
    }

    public JSONObject awv() {
        String awf = awf();
        if (this.cSv != null && TextUtils.equals((CharSequence) this.cSv.first, awf)) {
            return (JSONObject) this.cSv.second;
        }
        this.cSv = null;
        if (TextUtils.isEmpty(awf)) {
            this.cSv = null;
            return null;
        }
        String queryParameter = Uri.parse(awf).getQueryParameter("_baiduboxapp");
        if (!TextUtils.isEmpty(queryParameter)) {
            try {
                this.cSv = new Pair<>(awf, new JSONObject(queryParameter).optJSONObject("ext"));
            } catch (JSONException e) {
                if (DEBUG) {
                    e.printStackTrace();
                }
            }
        }
        if (this.cSv == null) {
            return null;
        }
        return (JSONObject) this.cSv.second;
    }

    public String aww() {
        return getString("launch_id");
    }

    public SelfT pm(String str) {
        return (SelfT) bV("launch_id", str);
    }

    public boolean awx() {
        return getBoolean("swan_app_independent", false);
    }

    public SelfT fo(boolean z) {
        return (SelfT) Z("swan_app_independent", z);
    }

    public String awy() {
        return getString("swan_app_sub_root_path");
    }

    public SelfT pn(String str) {
        return (SelfT) bV("swan_app_sub_root_path", str);
    }
}
