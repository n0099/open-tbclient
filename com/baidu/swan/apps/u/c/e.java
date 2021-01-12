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
    private Pair<String, JSONObject> ddH;

    public boolean ayA() {
        return getBoolean("cts_launch_mode", false);
    }

    public SelfT fR(boolean z) {
        aa("cts_launch_mode", z);
        return (SelfT) ayy();
    }

    public String asE() {
        return getString("mAppTitle");
    }

    public SelfT oB(String str) {
        bZ("mAppTitle", str);
        return (SelfT) ayy();
    }

    public String getAppKey() {
        return getString("mAppKey");
    }

    public SelfT oA(String str) {
        bZ("mAppKey", str);
        return (SelfT) ayy();
    }

    public String getAppId() {
        return getString("mAppId", "");
    }

    public SelfT oz(String str) {
        bZ("mAppId", str);
        return (SelfT) ayy();
    }

    public String getIconUrl() {
        return getString("app_icon_url");
    }

    public SelfT oy(String str) {
        bZ("app_icon_url", str);
        return (SelfT) ayy();
    }

    public String aym() {
        return "";
    }

    public SelfT ox(String str) {
        return (SelfT) ayy();
    }

    public int ayn() {
        return 0;
    }

    public String ayo() {
        return "";
    }

    public String ayp() {
        return "";
    }

    public String ayq() {
        return "";
    }

    public String ayr() {
        return "";
    }

    public SelfT ow(String str) {
        return (SelfT) ayy();
    }

    public String ays() {
        return "";
    }

    public SelfT ov(String str) {
        return (SelfT) ayy();
    }

    public SwanAppBearInfo ayt() {
        return null;
    }

    public String ayu() {
        return "";
    }

    public String getVersion() {
        return "";
    }

    public SelfT ou(String str) {
        return (SelfT) ayy();
    }

    public String getVersionCode() {
        return "";
    }

    public int getType() {
        return 0;
    }

    public long ayv() {
        return 0L;
    }

    public int getOrientation() {
        int i = getInt("appFrameOrientation", -1);
        if (-1 < i) {
            return i;
        }
        return -1;
    }

    public SelfT hM(int i) {
        return (SelfT) U("appFrameOrientation", i);
    }

    public long ayB() {
        return getLong("navigate_bar_color_key", KsMediaMeta.AV_CH_WIDE_LEFT);
    }

    public SelfT cl(long j) {
        if (KsMediaMeta.AV_CH_WIDE_LEFT != j) {
            p("navigate_bar_color_key", j);
        }
        return (SelfT) ayy();
    }

    public String ayC() {
        return getString("mFrom");
    }

    public String ayD() {
        return getString("mFromLast");
    }

    public SelfT oC(String str) {
        bZ("mFromLast", ayC());
        return (SelfT) bZ("mFrom", str);
    }

    public String ayE() {
        return getString("launchScheme");
    }

    public SelfT oD(String str) {
        return (SelfT) bZ("launchScheme", str);
    }

    public String getPage() {
        return getString("mPage");
    }

    public SelfT oE(String str) {
        return (SelfT) bZ("mPage", str);
    }

    public String ayF() {
        return getString("max_swan_version");
    }

    public String ayG() {
        return getString("min_swan_version");
    }

    public Bundle ayH() {
        return oM("mExtraData");
    }

    public SelfT G(Bundle bundle) {
        return (SelfT) e("mExtraData", bundle);
    }

    @NonNull
    public Bundle ayI() {
        Bundle ayH = ayH();
        if (ayH == null) {
            Bundle bundle = new Bundle();
            G(bundle);
            return bundle;
        }
        return ayH;
    }

    public SelfT bY(String str, String str2) {
        if (str != null && str2 != null) {
            ayI().putString(str, str2);
        }
        return (SelfT) ayy();
    }

    public SelfT o(String str, long j) {
        ayI().putLong(str, j);
        return (SelfT) ayy();
    }

    public String ayJ() {
        return getString("mClickId");
    }

    public SelfT oF(String str) {
        return (SelfT) bZ("mClickId", str);
    }

    public boolean isDebug() {
        return getBoolean("mIsDebug", false);
    }

    public SelfT fS(boolean z) {
        return (SelfT) aa("mIsDebug", z);
    }

    public String ayK() {
        return getString("notInHistory");
    }

    public SelfT oG(String str) {
        return (SelfT) bZ("notInHistory", str);
    }

    public String ayL() {
        return getString("launch_app_open_url");
    }

    public String ayM() {
        return getString("launch_app_download_url");
    }

    public String ayN() {
        return getString("targetSwanVersion");
    }

    public SelfT oH(String str) {
        return (SelfT) bZ("targetSwanVersion", str);
    }

    public SwanCoreVersion asb() {
        return (SwanCoreVersion) oN("swanCoreVersion");
    }

    public SelfT b(SwanCoreVersion swanCoreVersion) {
        return (SelfT) a("swanCoreVersion", swanCoreVersion);
    }

    public ExtensionCore asc() {
        return (ExtensionCore) oN("extensionCore");
    }

    public SelfT c(ExtensionCore extensionCore) {
        return (SelfT) a("extensionCore", extensionCore);
    }

    public int getAppFrameType() {
        return getInt("appFrameType");
    }

    public SelfT hN(int i) {
        return (SelfT) U("appFrameType", i);
    }

    public boolean ayO() {
        return getBoolean("console_switch", false);
    }

    public SelfT fT(boolean z) {
        return (SelfT) aa("console_switch", z);
    }

    public int ayP() {
        return getInt("launchFlags", 0);
    }

    public SelfT hO(int i) {
        return (SelfT) U("launchFlags", i);
    }

    public SelfT hP(int i) {
        return hO(ayP() | i);
    }

    public long ayw() {
        return 0L;
    }

    public SelfT ck(long j) {
        return (SelfT) ayy();
    }

    public long ayQ() {
        return getLong("last_start_timestamp");
    }

    public SelfT cm(long j) {
        return (SelfT) p("last_start_timestamp", j);
    }

    public String ayR() {
        return getString("remoteDebugUrl");
    }

    public SelfT oI(String str) {
        return (SelfT) bZ("remoteDebugUrl", str);
    }

    public PMSAppInfo ayS() {
        return (PMSAppInfo) oN("pms_db_info_onload");
    }

    public SelfT k(PMSAppInfo pMSAppInfo) {
        return (SelfT) a("pms_db_info_onload", pMSAppInfo);
    }

    public SelfT l(PMSAppInfo pMSAppInfo) {
        if (pMSAppInfo != null) {
            a("pms_db_info_updated", pMSAppInfo);
            if (!ayT()) {
                k(pMSAppInfo);
            }
        }
        return (SelfT) ayy();
    }

    public boolean ayT() {
        return containsKey("pms_db_info_onload") && ayS() != null;
    }

    public JSONObject ayU() {
        String ayE = ayE();
        if (this.ddH != null && TextUtils.equals((CharSequence) this.ddH.first, ayE)) {
            return (JSONObject) this.ddH.second;
        }
        this.ddH = null;
        if (TextUtils.isEmpty(ayE)) {
            this.ddH = null;
            return null;
        }
        String queryParameter = Uri.parse(ayE).getQueryParameter("_baiduboxapp");
        if (!TextUtils.isEmpty(queryParameter)) {
            try {
                this.ddH = new Pair<>(ayE, new JSONObject(queryParameter).optJSONObject("ext"));
            } catch (JSONException e) {
                if (DEBUG) {
                    e.printStackTrace();
                }
            }
        }
        if (this.ddH == null) {
            return null;
        }
        return (JSONObject) this.ddH.second;
    }

    public String ayV() {
        return getString("launch_id");
    }

    public SelfT oJ(String str) {
        return (SelfT) bZ("launch_id", str);
    }

    public boolean ayW() {
        return getBoolean("swan_app_independent", false);
    }

    public SelfT fU(boolean z) {
        return (SelfT) aa("swan_app_independent", z);
    }

    public String ayX() {
        return getString("swan_app_sub_root_path");
    }

    public SelfT oK(String str) {
        return (SelfT) bZ("swan_app_sub_root_path", str);
    }
}
