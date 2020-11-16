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
/* loaded from: classes7.dex */
public abstract class e<SelfT extends e<SelfT>> extends com.baidu.swan.apps.u.c.a.c<SelfT> {
    protected static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private Pair<String, JSONObject> cWE;

    public boolean axT() {
        return getBoolean("cts_launch_mode", false);
    }

    public SelfT fx(boolean z) {
        Z("cts_launch_mode", z);
        return (SelfT) axR();
    }

    public String arW() {
        return getString("mAppTitle");
    }

    public SelfT pm(String str) {
        bU("mAppTitle", str);
        return (SelfT) axR();
    }

    public String getAppKey() {
        return getString("mAppKey");
    }

    public SelfT pl(String str) {
        bU("mAppKey", str);
        return (SelfT) axR();
    }

    public String getAppId() {
        return getString("mAppId", "");
    }

    public SelfT pk(String str) {
        bU("mAppId", str);
        return (SelfT) axR();
    }

    public String getIconUrl() {
        return getString("app_icon_url");
    }

    public SelfT pj(String str) {
        bU("app_icon_url", str);
        return (SelfT) axR();
    }

    public String axF() {
        return "";
    }

    public SelfT pi(String str) {
        return (SelfT) axR();
    }

    public int axG() {
        return 0;
    }

    public String axH() {
        return "";
    }

    public String axI() {
        return "";
    }

    public String axJ() {
        return "";
    }

    public String axK() {
        return "";
    }

    public SelfT ph(String str) {
        return (SelfT) axR();
    }

    public String axL() {
        return "";
    }

    public SelfT pg(String str) {
        return (SelfT) axR();
    }

    public SwanAppBearInfo axM() {
        return null;
    }

    public String axN() {
        return "";
    }

    public String getVersion() {
        return "";
    }

    public SelfT pf(String str) {
        return (SelfT) axR();
    }

    public String getVersionCode() {
        return "";
    }

    public int getType() {
        return 0;
    }

    public long axO() {
        return 0L;
    }

    public int getOrientation() {
        int i = getInt("appFrameOrientation", -1);
        if (-1 < i) {
            return i;
        }
        return -1;
    }

    public SelfT iZ(int i) {
        return (SelfT) R("appFrameOrientation", i);
    }

    public long axU() {
        return getLong("navigate_bar_color_key", 2147483648L);
    }

    public SelfT bL(long j) {
        if (2147483648L != j) {
            p("navigate_bar_color_key", j);
        }
        return (SelfT) axR();
    }

    public String axV() {
        return getString("mFrom");
    }

    public String axW() {
        return getString("mFromLast");
    }

    public SelfT pn(String str) {
        bU("mFromLast", axV());
        return (SelfT) bU("mFrom", str);
    }

    public String axX() {
        return getString("launchScheme");
    }

    public SelfT po(String str) {
        return (SelfT) bU("launchScheme", str);
    }

    public String getPage() {
        return getString("mPage");
    }

    public SelfT pp(String str) {
        return (SelfT) bU("mPage", str);
    }

    public String axY() {
        return getString("max_swan_version");
    }

    public String axZ() {
        return getString("min_swan_version");
    }

    public Bundle aya() {
        return px("mExtraData");
    }

    public SelfT G(Bundle bundle) {
        return (SelfT) d("mExtraData", bundle);
    }

    @NonNull
    public Bundle ayb() {
        Bundle aya = aya();
        if (aya == null) {
            Bundle bundle = new Bundle();
            G(bundle);
            return bundle;
        }
        return aya;
    }

    public SelfT bT(String str, String str2) {
        if (str != null && str2 != null) {
            ayb().putString(str, str2);
        }
        return (SelfT) axR();
    }

    public SelfT o(String str, long j) {
        ayb().putLong(str, j);
        return (SelfT) axR();
    }

    public String ayc() {
        return getString("mClickId");
    }

    public SelfT pq(String str) {
        return (SelfT) bU("mClickId", str);
    }

    public boolean isDebug() {
        return getBoolean("mIsDebug", false);
    }

    public SelfT fy(boolean z) {
        return (SelfT) Z("mIsDebug", z);
    }

    public String ayd() {
        return getString("notInHistory");
    }

    public SelfT pr(String str) {
        return (SelfT) bU("notInHistory", str);
    }

    public String aye() {
        return getString("launch_app_open_url");
    }

    public String ayf() {
        return getString("launch_app_download_url");
    }

    public String ayg() {
        return getString("targetSwanVersion");
    }

    public SelfT ps(String str) {
        return (SelfT) bU("targetSwanVersion", str);
    }

    public SwanCoreVersion arv() {
        return (SwanCoreVersion) py("swanCoreVersion");
    }

    public SelfT b(SwanCoreVersion swanCoreVersion) {
        return (SelfT) a("swanCoreVersion", swanCoreVersion);
    }

    public ExtensionCore arw() {
        return (ExtensionCore) py("extensionCore");
    }

    public SelfT c(ExtensionCore extensionCore) {
        return (SelfT) a("extensionCore", extensionCore);
    }

    public int getAppFrameType() {
        return getInt("appFrameType");
    }

    public SelfT ja(int i) {
        return (SelfT) R("appFrameType", i);
    }

    public boolean ayh() {
        return getBoolean("console_switch", false);
    }

    public SelfT fz(boolean z) {
        return (SelfT) Z("console_switch", z);
    }

    public int ayi() {
        return getInt("launchFlags", 0);
    }

    public SelfT jb(int i) {
        return (SelfT) R("launchFlags", i);
    }

    public SelfT jc(int i) {
        return jb(ayi() | i);
    }

    public long axP() {
        return 0L;
    }

    public SelfT bK(long j) {
        return (SelfT) axR();
    }

    public long ayj() {
        return getLong("last_start_timestamp");
    }

    public SelfT bM(long j) {
        return (SelfT) p("last_start_timestamp", j);
    }

    public String ayk() {
        return getString("remoteDebugUrl");
    }

    public SelfT pt(String str) {
        return (SelfT) bU("remoteDebugUrl", str);
    }

    public PMSAppInfo ayl() {
        return (PMSAppInfo) py("pms_db_info_onload");
    }

    public SelfT k(PMSAppInfo pMSAppInfo) {
        return (SelfT) a("pms_db_info_onload", pMSAppInfo);
    }

    public SelfT l(PMSAppInfo pMSAppInfo) {
        if (pMSAppInfo != null) {
            a("pms_db_info_updated", pMSAppInfo);
            if (!aym()) {
                k(pMSAppInfo);
            }
        }
        return (SelfT) axR();
    }

    public boolean aym() {
        return containsKey("pms_db_info_onload") && ayl() != null;
    }

    public JSONObject ayn() {
        String axX = axX();
        if (this.cWE != null && TextUtils.equals((CharSequence) this.cWE.first, axX)) {
            return (JSONObject) this.cWE.second;
        }
        this.cWE = null;
        if (TextUtils.isEmpty(axX)) {
            this.cWE = null;
            return null;
        }
        String queryParameter = Uri.parse(axX).getQueryParameter("_baiduboxapp");
        if (!TextUtils.isEmpty(queryParameter)) {
            try {
                this.cWE = new Pair<>(axX, new JSONObject(queryParameter).optJSONObject("ext"));
            } catch (JSONException e) {
                if (DEBUG) {
                    e.printStackTrace();
                }
            }
        }
        if (this.cWE == null) {
            return null;
        }
        return (JSONObject) this.cWE.second;
    }

    public String ayo() {
        return getString("launch_id");
    }

    public SelfT pu(String str) {
        return (SelfT) bU("launch_id", str);
    }

    public boolean ayp() {
        return getBoolean("swan_app_independent", false);
    }

    public SelfT fA(boolean z) {
        return (SelfT) Z("swan_app_independent", z);
    }

    public String ayq() {
        return getString("swan_app_sub_root_path");
    }

    public SelfT pv(String str) {
        return (SelfT) bU("swan_app_sub_root_path", str);
    }
}
