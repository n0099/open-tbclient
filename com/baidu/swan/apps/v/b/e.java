package com.baidu.swan.apps.v.b;

import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.util.Pair;
import com.baidu.swan.apps.extcore.model.ExtensionCore;
import com.baidu.swan.apps.model.SwanAppBearInfo;
import com.baidu.swan.apps.swancore.model.SwanCoreVersion;
import com.baidu.swan.apps.v.b.e;
import com.baidu.swan.pms.model.PMSAppInfo;
import org.json.JSONException;
import org.json.JSONObject;
import tv.danmaku.ijk.media.player.IjkMediaMeta;
/* loaded from: classes11.dex */
public abstract class e<SelfT extends e<SelfT>> extends com.baidu.swan.apps.v.b.a.c<SelfT> {
    protected static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private Pair<String, JSONObject> chn;

    public boolean agI() {
        return getBoolean("cts_launch_mode", false);
    }

    public SelfT dY(boolean z) {
        N("cts_launch_mode", z);
        return (SelfT) agG();
    }

    public String abT() {
        return getString("mAppTitle");
    }

    public SelfT kY(String str) {
        bs("mAppTitle", str);
        return (SelfT) agG();
    }

    public String getAppKey() {
        return getString("mAppKey");
    }

    public SelfT kX(String str) {
        bs("mAppKey", str);
        return (SelfT) agG();
    }

    public String getAppId() {
        return getString("mAppId", "");
    }

    public SelfT kW(String str) {
        bs("mAppId", str);
        return (SelfT) agG();
    }

    public String getIconUrl() {
        return getString("app_icon_url");
    }

    public SelfT kV(String str) {
        bs("app_icon_url", str);
        return (SelfT) agG();
    }

    public String agv() {
        return "";
    }

    public SelfT kU(String str) {
        return (SelfT) agG();
    }

    public int agw() {
        return 0;
    }

    public String agx() {
        return "";
    }

    public String agy() {
        return "";
    }

    public String agz() {
        return "";
    }

    public String agA() {
        return "";
    }

    public SelfT kT(String str) {
        return (SelfT) agG();
    }

    public String agB() {
        return "";
    }

    public SelfT kS(String str) {
        return (SelfT) agG();
    }

    public SwanAppBearInfo agC() {
        return null;
    }

    public String getVersion() {
        return "";
    }

    public SelfT kR(String str) {
        return (SelfT) agG();
    }

    public String getVersionCode() {
        return "";
    }

    public int getType() {
        return 0;
    }

    public long agD() {
        return 0L;
    }

    public int getOrientation() {
        int i = getInt("appFrameOrientation", -1);
        if (-1 < i) {
            return i;
        }
        return -1;
    }

    public SelfT fC(int i) {
        return (SelfT) M("appFrameOrientation", i);
    }

    public long agJ() {
        return getLong("navigate_bar_color_key", IjkMediaMeta.AV_CH_WIDE_LEFT);
    }

    public SelfT aV(long j) {
        if (IjkMediaMeta.AV_CH_WIDE_LEFT != j) {
            j("navigate_bar_color_key", j);
        }
        return (SelfT) agG();
    }

    public String agK() {
        return getString("mFrom");
    }

    public String agL() {
        return getString("mFromLast");
    }

    public SelfT kZ(String str) {
        bs("mFromLast", agK());
        return (SelfT) bs("mFrom", str);
    }

    public String agM() {
        return getString("launchScheme");
    }

    public SelfT la(String str) {
        return (SelfT) bs("launchScheme", str);
    }

    public String getPage() {
        return getString("mPage");
    }

    public SelfT lb(String str) {
        return (SelfT) bs("mPage", str);
    }

    public String agN() {
        return getString("max_swan_version");
    }

    public String agO() {
        return getString("min_swan_version");
    }

    public Bundle agP() {
        return li("mExtraData");
    }

    public SelfT H(Bundle bundle) {
        return (SelfT) e("mExtraData", bundle);
    }

    @NonNull
    public Bundle agQ() {
        Bundle agP = agP();
        if (agP == null) {
            Bundle bundle = new Bundle();
            H(bundle);
            return bundle;
        }
        return agP;
    }

    public SelfT br(String str, String str2) {
        if (str != null && str2 != null) {
            agQ().putString(str, str2);
        }
        return (SelfT) agG();
    }

    public SelfT i(String str, long j) {
        agQ().putLong(str, j);
        return (SelfT) agG();
    }

    public String agR() {
        return getString("mClickId");
    }

    public SelfT lc(String str) {
        return (SelfT) bs("mClickId", str);
    }

    public boolean isDebug() {
        return getBoolean("mIsDebug", false);
    }

    public SelfT dZ(boolean z) {
        return (SelfT) N("mIsDebug", z);
    }

    public String agS() {
        return getString("notInHistory");
    }

    public SelfT ld(String str) {
        return (SelfT) bs("notInHistory", str);
    }

    public String agT() {
        return getString("launch_app_open_url");
    }

    public String agU() {
        return getString("launch_app_download_url");
    }

    public String agV() {
        return getString("targetSwanVersion");
    }

    public SelfT le(String str) {
        return (SelfT) bs("targetSwanVersion", str);
    }

    public SwanCoreVersion abG() {
        return (SwanCoreVersion) lj("swanCoreVersion");
    }

    public SelfT b(SwanCoreVersion swanCoreVersion) {
        return (SelfT) a("swanCoreVersion", swanCoreVersion);
    }

    public ExtensionCore abH() {
        return (ExtensionCore) lj("extensionCore");
    }

    public SelfT c(ExtensionCore extensionCore) {
        return (SelfT) a("extensionCore", extensionCore);
    }

    public int getAppFrameType() {
        return getInt("appFrameType");
    }

    public SelfT fD(int i) {
        return (SelfT) M("appFrameType", i);
    }

    public boolean agW() {
        return getBoolean("console_switch", false);
    }

    public SelfT ea(boolean z) {
        return (SelfT) N("console_switch", z);
    }

    public int agX() {
        return getInt("launchFlags", 0);
    }

    public SelfT fE(int i) {
        return (SelfT) M("launchFlags", i);
    }

    public SelfT fF(int i) {
        return fE(agX() | i);
    }

    public long agE() {
        return 0L;
    }

    public SelfT aU(long j) {
        return (SelfT) agG();
    }

    public long agY() {
        return getLong("last_start_timestamp");
    }

    public SelfT aW(long j) {
        return (SelfT) j("last_start_timestamp", j);
    }

    public String agZ() {
        return getString("remoteDebugUrl");
    }

    public SelfT lf(String str) {
        return (SelfT) bs("remoteDebugUrl", str);
    }

    public PMSAppInfo aha() {
        return (PMSAppInfo) lj("pms_db_info_onload");
    }

    public SelfT h(PMSAppInfo pMSAppInfo) {
        return (SelfT) a("pms_db_info_onload", pMSAppInfo);
    }

    public SelfT i(PMSAppInfo pMSAppInfo) {
        if (pMSAppInfo != null) {
            a("pms_db_info_updated", pMSAppInfo);
            if (!ahb()) {
                h(pMSAppInfo);
            }
        }
        return (SelfT) agG();
    }

    public boolean ahb() {
        return containsKey("pms_db_info_onload") && aha() != null;
    }

    public JSONObject ahc() {
        String agM = agM();
        if (this.chn != null && TextUtils.equals((CharSequence) this.chn.first, agM)) {
            return (JSONObject) this.chn.second;
        }
        this.chn = null;
        if (TextUtils.isEmpty(agM)) {
            this.chn = null;
            return null;
        }
        String queryParameter = Uri.parse(agM).getQueryParameter("_baiduboxapp");
        if (!TextUtils.isEmpty(queryParameter)) {
            try {
                this.chn = new Pair<>(agM, new JSONObject(queryParameter).optJSONObject("ext"));
            } catch (JSONException e) {
                if (DEBUG) {
                    e.printStackTrace();
                }
            }
        }
        if (this.chn == null) {
            return null;
        }
        return (JSONObject) this.chn.second;
    }

    public String ahd() {
        return getString("launch_id");
    }

    public boolean ahe() {
        return getBoolean("swan_app_independent", false);
    }

    public SelfT eb(boolean z) {
        return (SelfT) N("swan_app_independent", z);
    }

    public String ahf() {
        return getString("swan_app_sub_root_path");
    }

    public SelfT lg(String str) {
        return (SelfT) bs("swan_app_sub_root_path", str);
    }
}
