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
    private Pair<String, JSONObject> cmb;

    public boolean ahO() {
        return getBoolean("cts_launch_mode", false);
    }

    public SelfT ed(boolean z) {
        P("cts_launch_mode", z);
        return (SelfT) ahM();
    }

    public String acZ() {
        return getString("mAppTitle");
    }

    public SelfT lg(String str) {
        bu("mAppTitle", str);
        return (SelfT) ahM();
    }

    public String getAppKey() {
        return getString("mAppKey");
    }

    public SelfT lf(String str) {
        bu("mAppKey", str);
        return (SelfT) ahM();
    }

    public String getAppId() {
        return getString("mAppId", "");
    }

    public SelfT le(String str) {
        bu("mAppId", str);
        return (SelfT) ahM();
    }

    public String getIconUrl() {
        return getString("app_icon_url");
    }

    public SelfT ld(String str) {
        bu("app_icon_url", str);
        return (SelfT) ahM();
    }

    public String ahB() {
        return "";
    }

    public SelfT lc(String str) {
        return (SelfT) ahM();
    }

    public int ahC() {
        return 0;
    }

    public String ahD() {
        return "";
    }

    public String ahE() {
        return "";
    }

    public String ahF() {
        return "";
    }

    public String ahG() {
        return "";
    }

    public SelfT lb(String str) {
        return (SelfT) ahM();
    }

    public String ahH() {
        return "";
    }

    public SelfT la(String str) {
        return (SelfT) ahM();
    }

    public SwanAppBearInfo ahI() {
        return null;
    }

    public String getVersion() {
        return "";
    }

    public SelfT kZ(String str) {
        return (SelfT) ahM();
    }

    public String getVersionCode() {
        return "";
    }

    public int getType() {
        return 0;
    }

    public long ahJ() {
        return 0L;
    }

    public int getOrientation() {
        int i = getInt("appFrameOrientation", -1);
        if (-1 < i) {
            return i;
        }
        return -1;
    }

    public SelfT fN(int i) {
        return (SelfT) M("appFrameOrientation", i);
    }

    public long ahP() {
        return getLong("navigate_bar_color_key", IjkMediaMeta.AV_CH_WIDE_LEFT);
    }

    public SelfT aV(long j) {
        if (IjkMediaMeta.AV_CH_WIDE_LEFT != j) {
            j("navigate_bar_color_key", j);
        }
        return (SelfT) ahM();
    }

    public String ahQ() {
        return getString("mFrom");
    }

    public String ahR() {
        return getString("mFromLast");
    }

    public SelfT lh(String str) {
        bu("mFromLast", ahQ());
        return (SelfT) bu("mFrom", str);
    }

    public String ahS() {
        return getString("launchScheme");
    }

    public SelfT li(String str) {
        return (SelfT) bu("launchScheme", str);
    }

    public String getPage() {
        return getString("mPage");
    }

    public SelfT lj(String str) {
        return (SelfT) bu("mPage", str);
    }

    public String ahT() {
        return getString("max_swan_version");
    }

    public String ahU() {
        return getString("min_swan_version");
    }

    public Bundle ahV() {
        return lq("mExtraData");
    }

    public SelfT H(Bundle bundle) {
        return (SelfT) e("mExtraData", bundle);
    }

    @NonNull
    public Bundle ahW() {
        Bundle ahV = ahV();
        if (ahV == null) {
            Bundle bundle = new Bundle();
            H(bundle);
            return bundle;
        }
        return ahV;
    }

    public SelfT bt(String str, String str2) {
        if (str != null && str2 != null) {
            ahW().putString(str, str2);
        }
        return (SelfT) ahM();
    }

    public SelfT i(String str, long j) {
        ahW().putLong(str, j);
        return (SelfT) ahM();
    }

    public String ahX() {
        return getString("mClickId");
    }

    public SelfT lk(String str) {
        return (SelfT) bu("mClickId", str);
    }

    public boolean isDebug() {
        return getBoolean("mIsDebug", false);
    }

    public SelfT ee(boolean z) {
        return (SelfT) P("mIsDebug", z);
    }

    public String ahY() {
        return getString("notInHistory");
    }

    public SelfT ll(String str) {
        return (SelfT) bu("notInHistory", str);
    }

    public String ahZ() {
        return getString("launch_app_open_url");
    }

    public String aia() {
        return getString("launch_app_download_url");
    }

    public String aib() {
        return getString("targetSwanVersion");
    }

    public SelfT lm(String str) {
        return (SelfT) bu("targetSwanVersion", str);
    }

    public SwanCoreVersion acM() {
        return (SwanCoreVersion) lr("swanCoreVersion");
    }

    public SelfT b(SwanCoreVersion swanCoreVersion) {
        return (SelfT) a("swanCoreVersion", swanCoreVersion);
    }

    public ExtensionCore acN() {
        return (ExtensionCore) lr("extensionCore");
    }

    public SelfT c(ExtensionCore extensionCore) {
        return (SelfT) a("extensionCore", extensionCore);
    }

    public int getAppFrameType() {
        return getInt("appFrameType");
    }

    public SelfT fO(int i) {
        return (SelfT) M("appFrameType", i);
    }

    public boolean aic() {
        return getBoolean("console_switch", false);
    }

    public SelfT ef(boolean z) {
        return (SelfT) P("console_switch", z);
    }

    public int aid() {
        return getInt("launchFlags", 0);
    }

    public SelfT fP(int i) {
        return (SelfT) M("launchFlags", i);
    }

    public SelfT fQ(int i) {
        return fP(aid() | i);
    }

    public long ahK() {
        return 0L;
    }

    public SelfT aU(long j) {
        return (SelfT) ahM();
    }

    public long aie() {
        return getLong("last_start_timestamp");
    }

    public SelfT aW(long j) {
        return (SelfT) j("last_start_timestamp", j);
    }

    public String aif() {
        return getString("remoteDebugUrl");
    }

    public SelfT ln(String str) {
        return (SelfT) bu("remoteDebugUrl", str);
    }

    public PMSAppInfo aig() {
        return (PMSAppInfo) lr("pms_db_info_onload");
    }

    public SelfT h(PMSAppInfo pMSAppInfo) {
        return (SelfT) a("pms_db_info_onload", pMSAppInfo);
    }

    public SelfT i(PMSAppInfo pMSAppInfo) {
        if (pMSAppInfo != null) {
            a("pms_db_info_updated", pMSAppInfo);
            if (!aih()) {
                h(pMSAppInfo);
            }
        }
        return (SelfT) ahM();
    }

    public boolean aih() {
        return containsKey("pms_db_info_onload") && aig() != null;
    }

    public JSONObject aii() {
        String ahS = ahS();
        if (this.cmb != null && TextUtils.equals((CharSequence) this.cmb.first, ahS)) {
            return (JSONObject) this.cmb.second;
        }
        this.cmb = null;
        if (TextUtils.isEmpty(ahS)) {
            this.cmb = null;
            return null;
        }
        String queryParameter = Uri.parse(ahS).getQueryParameter("_baiduboxapp");
        if (!TextUtils.isEmpty(queryParameter)) {
            try {
                this.cmb = new Pair<>(ahS, new JSONObject(queryParameter).optJSONObject("ext"));
            } catch (JSONException e) {
                if (DEBUG) {
                    e.printStackTrace();
                }
            }
        }
        if (this.cmb == null) {
            return null;
        }
        return (JSONObject) this.cmb.second;
    }

    public String aij() {
        return getString("launch_id");
    }

    public boolean aik() {
        return getBoolean("swan_app_independent", false);
    }

    public SelfT eg(boolean z) {
        return (SelfT) P("swan_app_independent", z);
    }

    public String ail() {
        return getString("swan_app_sub_root_path");
    }

    public SelfT lo(String str) {
        return (SelfT) bu("swan_app_sub_root_path", str);
    }
}
