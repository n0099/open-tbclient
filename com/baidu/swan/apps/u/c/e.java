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
/* loaded from: classes8.dex */
public abstract class e<SelfT extends e<SelfT>> extends com.baidu.swan.apps.u.c.a.c<SelfT> {
    protected static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private Pair<String, JSONObject> dhu;

    public boolean azb() {
        return getBoolean("cts_launch_mode", false);
    }

    public SelfT fT(boolean z) {
        Z("cts_launch_mode", z);
        return (SelfT) ayZ();
    }

    public String atf() {
        return getString("mAppTitle");
    }

    public SelfT pa(String str) {
        bT("mAppTitle", str);
        return (SelfT) ayZ();
    }

    public String getAppKey() {
        return getString("mAppKey");
    }

    public SelfT oZ(String str) {
        bT("mAppKey", str);
        return (SelfT) ayZ();
    }

    public String getAppId() {
        return getString("mAppId", "");
    }

    public SelfT oY(String str) {
        bT("mAppId", str);
        return (SelfT) ayZ();
    }

    public String getIconUrl() {
        return getString("app_icon_url");
    }

    public SelfT oX(String str) {
        bT("app_icon_url", str);
        return (SelfT) ayZ();
    }

    public String ayN() {
        return "";
    }

    public SelfT oW(String str) {
        return (SelfT) ayZ();
    }

    public int ayO() {
        return 0;
    }

    public String ayP() {
        return "";
    }

    public String ayQ() {
        return "";
    }

    public String ayR() {
        return "";
    }

    public String ayS() {
        return "";
    }

    public SelfT oV(String str) {
        return (SelfT) ayZ();
    }

    public String ayT() {
        return "";
    }

    public SelfT oU(String str) {
        return (SelfT) ayZ();
    }

    public SwanAppBearInfo ayU() {
        return null;
    }

    public String ayV() {
        return "";
    }

    public String getVersion() {
        return "";
    }

    public SelfT oT(String str) {
        return (SelfT) ayZ();
    }

    public String getVersionCode() {
        return "";
    }

    public int getType() {
        return 0;
    }

    public long ayW() {
        return 0L;
    }

    public int getOrientation() {
        int i = getInt("appFrameOrientation", -1);
        if (-1 < i) {
            return i;
        }
        return -1;
    }

    public SelfT hQ(int i) {
        return (SelfT) X("appFrameOrientation", i);
    }

    public long azc() {
        return getLong("navigate_bar_color_key", KsMediaMeta.AV_CH_WIDE_LEFT);
    }

    public SelfT cr(long j) {
        if (KsMediaMeta.AV_CH_WIDE_LEFT != j) {
            o("navigate_bar_color_key", j);
        }
        return (SelfT) ayZ();
    }

    public String azd() {
        return getString("mFrom");
    }

    public String aze() {
        return getString("mFromLast");
    }

    public SelfT pb(String str) {
        bT("mFromLast", azd());
        return (SelfT) bT("mFrom", str);
    }

    public String azf() {
        return getString("launchScheme");
    }

    public SelfT pc(String str) {
        return (SelfT) bT("launchScheme", str);
    }

    public String getPage() {
        return getString("mPage");
    }

    public SelfT pd(String str) {
        return (SelfT) bT("mPage", str);
    }

    public String azg() {
        return getString("max_swan_version");
    }

    public String azh() {
        return getString("min_swan_version");
    }

    public Bundle azi() {
        return pl("mExtraData");
    }

    public SelfT G(Bundle bundle) {
        return (SelfT) e("mExtraData", bundle);
    }

    @NonNull
    public Bundle azj() {
        Bundle azi = azi();
        if (azi == null) {
            Bundle bundle = new Bundle();
            G(bundle);
            return bundle;
        }
        return azi;
    }

    public SelfT bS(String str, String str2) {
        if (str != null && str2 != null) {
            azj().putString(str, str2);
        }
        return (SelfT) ayZ();
    }

    public SelfT n(String str, long j) {
        azj().putLong(str, j);
        return (SelfT) ayZ();
    }

    public String azk() {
        return getString("mClickId");
    }

    public SelfT pe(String str) {
        return (SelfT) bT("mClickId", str);
    }

    public boolean isDebug() {
        return getBoolean("mIsDebug", false);
    }

    public SelfT fU(boolean z) {
        return (SelfT) Z("mIsDebug", z);
    }

    public String azl() {
        return getString("notInHistory");
    }

    public SelfT pf(String str) {
        return (SelfT) bT("notInHistory", str);
    }

    public String azm() {
        return getString("launch_app_open_url");
    }

    public String azn() {
        return getString("launch_app_download_url");
    }

    public String azo() {
        return getString("targetSwanVersion");
    }

    public SelfT pg(String str) {
        return (SelfT) bT("targetSwanVersion", str);
    }

    public SwanCoreVersion asD() {
        return (SwanCoreVersion) pm("swanCoreVersion");
    }

    public SelfT b(SwanCoreVersion swanCoreVersion) {
        return (SelfT) a("swanCoreVersion", swanCoreVersion);
    }

    public ExtensionCore asE() {
        return (ExtensionCore) pm("extensionCore");
    }

    public SelfT c(ExtensionCore extensionCore) {
        return (SelfT) a("extensionCore", extensionCore);
    }

    public int getAppFrameType() {
        return getInt("appFrameType");
    }

    public SelfT hR(int i) {
        return (SelfT) X("appFrameType", i);
    }

    public boolean azp() {
        return getBoolean("console_switch", false);
    }

    public SelfT fV(boolean z) {
        return (SelfT) Z("console_switch", z);
    }

    public int azq() {
        return getInt("launchFlags", 0);
    }

    public SelfT hS(int i) {
        return (SelfT) X("launchFlags", i);
    }

    public SelfT hT(int i) {
        return hS(azq() | i);
    }

    public long ayX() {
        return 0L;
    }

    public SelfT cq(long j) {
        return (SelfT) ayZ();
    }

    public long azr() {
        return getLong("last_start_timestamp");
    }

    public SelfT cs(long j) {
        return (SelfT) o("last_start_timestamp", j);
    }

    public String azs() {
        return getString("remoteDebugUrl");
    }

    public SelfT ph(String str) {
        return (SelfT) bT("remoteDebugUrl", str);
    }

    public PMSAppInfo azt() {
        return (PMSAppInfo) pm("pms_db_info_onload");
    }

    public SelfT k(PMSAppInfo pMSAppInfo) {
        return (SelfT) a("pms_db_info_onload", pMSAppInfo);
    }

    public SelfT l(PMSAppInfo pMSAppInfo) {
        if (pMSAppInfo != null) {
            a("pms_db_info_updated", pMSAppInfo);
            if (!azu()) {
                k(pMSAppInfo);
            }
        }
        return (SelfT) ayZ();
    }

    public boolean azu() {
        return containsKey("pms_db_info_onload") && azt() != null;
    }

    public JSONObject azv() {
        String azf = azf();
        if (this.dhu != null && TextUtils.equals((CharSequence) this.dhu.first, azf)) {
            return (JSONObject) this.dhu.second;
        }
        this.dhu = null;
        if (TextUtils.isEmpty(azf)) {
            this.dhu = null;
            return null;
        }
        String queryParameter = Uri.parse(azf).getQueryParameter("_baiduboxapp");
        if (!TextUtils.isEmpty(queryParameter)) {
            try {
                this.dhu = new Pair<>(azf, new JSONObject(queryParameter).optJSONObject("ext"));
            } catch (JSONException e) {
                if (DEBUG) {
                    e.printStackTrace();
                }
            }
        }
        if (this.dhu == null) {
            return null;
        }
        return (JSONObject) this.dhu.second;
    }

    public String azw() {
        return getString("launch_id");
    }

    public SelfT pi(String str) {
        return (SelfT) bT("launch_id", str);
    }

    public boolean azx() {
        return getBoolean("swan_app_independent", false);
    }

    public SelfT fW(boolean z) {
        return (SelfT) Z("swan_app_independent", z);
    }

    public String azy() {
        return getString("swan_app_sub_root_path");
    }

    public SelfT pj(String str) {
        return (SelfT) bT("swan_app_sub_root_path", str);
    }
}
