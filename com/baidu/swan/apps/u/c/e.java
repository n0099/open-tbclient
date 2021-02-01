package com.baidu.swan.apps.u.c;

import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Pair;
import androidx.annotation.NonNull;
import com.baidu.swan.apps.extcore.model.ExtensionCore;
import com.baidu.swan.apps.model.SwanAppBearInfo;
import com.baidu.swan.apps.swancore.model.SwanCoreVersion;
import com.baidu.swan.apps.u.c.e;
import com.baidu.swan.pms.model.PMSAppInfo;
import com.kwai.video.player.KsMediaMeta;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes9.dex */
public abstract class e<SelfT extends e<SelfT>> extends com.baidu.swan.apps.u.c.a.c<SelfT> {
    protected static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private Pair<String, JSONObject> dfT;

    public boolean ayY() {
        return getBoolean("cts_launch_mode", false);
    }

    public SelfT fT(boolean z) {
        Z("cts_launch_mode", z);
        return (SelfT) ayW();
    }

    public String atc() {
        return getString("mAppTitle");
    }

    public SelfT oT(String str) {
        bT("mAppTitle", str);
        return (SelfT) ayW();
    }

    public String getAppKey() {
        return getString("mAppKey");
    }

    public SelfT oS(String str) {
        bT("mAppKey", str);
        return (SelfT) ayW();
    }

    public String getAppId() {
        return getString("mAppId", "");
    }

    public SelfT oR(String str) {
        bT("mAppId", str);
        return (SelfT) ayW();
    }

    public String getIconUrl() {
        return getString("app_icon_url");
    }

    public SelfT oQ(String str) {
        bT("app_icon_url", str);
        return (SelfT) ayW();
    }

    public String ayK() {
        return "";
    }

    public SelfT oP(String str) {
        return (SelfT) ayW();
    }

    public int ayL() {
        return 0;
    }

    public String ayM() {
        return "";
    }

    public String ayN() {
        return "";
    }

    public String ayO() {
        return "";
    }

    public String ayP() {
        return "";
    }

    public SelfT oO(String str) {
        return (SelfT) ayW();
    }

    public String ayQ() {
        return "";
    }

    public SelfT oN(String str) {
        return (SelfT) ayW();
    }

    public SwanAppBearInfo ayR() {
        return null;
    }

    public String ayS() {
        return "";
    }

    public String getVersion() {
        return "";
    }

    public SelfT oM(String str) {
        return (SelfT) ayW();
    }

    public String getVersionCode() {
        return "";
    }

    public int getType() {
        return 0;
    }

    public long ayT() {
        return 0L;
    }

    public int getOrientation() {
        int i = getInt("appFrameOrientation", -1);
        if (-1 < i) {
            return i;
        }
        return -1;
    }

    public SelfT hP(int i) {
        return (SelfT) W("appFrameOrientation", i);
    }

    public long ayZ() {
        return getLong("navigate_bar_color_key", KsMediaMeta.AV_CH_WIDE_LEFT);
    }

    public SelfT cr(long j) {
        if (KsMediaMeta.AV_CH_WIDE_LEFT != j) {
            o("navigate_bar_color_key", j);
        }
        return (SelfT) ayW();
    }

    public String aza() {
        return getString("mFrom");
    }

    public String azb() {
        return getString("mFromLast");
    }

    public SelfT oU(String str) {
        bT("mFromLast", aza());
        return (SelfT) bT("mFrom", str);
    }

    public String azc() {
        return getString("launchScheme");
    }

    public SelfT oV(String str) {
        return (SelfT) bT("launchScheme", str);
    }

    public String getPage() {
        return getString("mPage");
    }

    public SelfT oW(String str) {
        return (SelfT) bT("mPage", str);
    }

    public String azd() {
        return getString("max_swan_version");
    }

    public String aze() {
        return getString("min_swan_version");
    }

    public Bundle azf() {
        return pe("mExtraData");
    }

    public SelfT G(Bundle bundle) {
        return (SelfT) e("mExtraData", bundle);
    }

    @NonNull
    public Bundle azg() {
        Bundle azf = azf();
        if (azf == null) {
            Bundle bundle = new Bundle();
            G(bundle);
            return bundle;
        }
        return azf;
    }

    public SelfT bS(String str, String str2) {
        if (str != null && str2 != null) {
            azg().putString(str, str2);
        }
        return (SelfT) ayW();
    }

    public SelfT n(String str, long j) {
        azg().putLong(str, j);
        return (SelfT) ayW();
    }

    public String azh() {
        return getString("mClickId");
    }

    public SelfT oX(String str) {
        return (SelfT) bT("mClickId", str);
    }

    public boolean isDebug() {
        return getBoolean("mIsDebug", false);
    }

    public SelfT fU(boolean z) {
        return (SelfT) Z("mIsDebug", z);
    }

    public String azi() {
        return getString("notInHistory");
    }

    public SelfT oY(String str) {
        return (SelfT) bT("notInHistory", str);
    }

    public String azj() {
        return getString("launch_app_open_url");
    }

    public String azk() {
        return getString("launch_app_download_url");
    }

    public String azl() {
        return getString("targetSwanVersion");
    }

    public SelfT oZ(String str) {
        return (SelfT) bT("targetSwanVersion", str);
    }

    public SwanCoreVersion asA() {
        return (SwanCoreVersion) pf("swanCoreVersion");
    }

    public SelfT b(SwanCoreVersion swanCoreVersion) {
        return (SelfT) a("swanCoreVersion", swanCoreVersion);
    }

    public ExtensionCore asB() {
        return (ExtensionCore) pf("extensionCore");
    }

    public SelfT c(ExtensionCore extensionCore) {
        return (SelfT) a("extensionCore", extensionCore);
    }

    public int getAppFrameType() {
        return getInt("appFrameType");
    }

    public SelfT hQ(int i) {
        return (SelfT) W("appFrameType", i);
    }

    public boolean azm() {
        return getBoolean("console_switch", false);
    }

    public SelfT fV(boolean z) {
        return (SelfT) Z("console_switch", z);
    }

    public int azn() {
        return getInt("launchFlags", 0);
    }

    public SelfT hR(int i) {
        return (SelfT) W("launchFlags", i);
    }

    public SelfT hS(int i) {
        return hR(azn() | i);
    }

    public long ayU() {
        return 0L;
    }

    public SelfT cq(long j) {
        return (SelfT) ayW();
    }

    public long azo() {
        return getLong("last_start_timestamp");
    }

    public SelfT cs(long j) {
        return (SelfT) o("last_start_timestamp", j);
    }

    public String azp() {
        return getString("remoteDebugUrl");
    }

    public SelfT pa(String str) {
        return (SelfT) bT("remoteDebugUrl", str);
    }

    public PMSAppInfo azq() {
        return (PMSAppInfo) pf("pms_db_info_onload");
    }

    public SelfT k(PMSAppInfo pMSAppInfo) {
        return (SelfT) a("pms_db_info_onload", pMSAppInfo);
    }

    public SelfT l(PMSAppInfo pMSAppInfo) {
        if (pMSAppInfo != null) {
            a("pms_db_info_updated", pMSAppInfo);
            if (!azr()) {
                k(pMSAppInfo);
            }
        }
        return (SelfT) ayW();
    }

    public boolean azr() {
        return containsKey("pms_db_info_onload") && azq() != null;
    }

    public JSONObject azs() {
        String azc = azc();
        if (this.dfT != null && TextUtils.equals((CharSequence) this.dfT.first, azc)) {
            return (JSONObject) this.dfT.second;
        }
        this.dfT = null;
        if (TextUtils.isEmpty(azc)) {
            this.dfT = null;
            return null;
        }
        String queryParameter = Uri.parse(azc).getQueryParameter("_baiduboxapp");
        if (!TextUtils.isEmpty(queryParameter)) {
            try {
                this.dfT = new Pair<>(azc, new JSONObject(queryParameter).optJSONObject("ext"));
            } catch (JSONException e) {
                if (DEBUG) {
                    e.printStackTrace();
                }
            }
        }
        if (this.dfT == null) {
            return null;
        }
        return (JSONObject) this.dfT.second;
    }

    public String azt() {
        return getString("launch_id");
    }

    public SelfT pb(String str) {
        return (SelfT) bT("launch_id", str);
    }

    public boolean azu() {
        return getBoolean("swan_app_independent", false);
    }

    public SelfT fW(boolean z) {
        return (SelfT) Z("swan_app_independent", z);
    }

    public String azv() {
        return getString("swan_app_sub_root_path");
    }

    public SelfT pc(String str) {
        return (SelfT) bT("swan_app_sub_root_path", str);
    }
}
