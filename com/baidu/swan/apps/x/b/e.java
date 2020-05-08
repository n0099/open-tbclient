package com.baidu.swan.apps.x.b;

import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.util.Pair;
import com.baidu.swan.apps.extcore.model.ExtensionCore;
import com.baidu.swan.apps.model.SwanAppBearInfo;
import com.baidu.swan.apps.swancore.model.SwanCoreVersion;
import com.baidu.swan.apps.x.b.e;
import com.baidu.swan.pms.model.PMSAppInfo;
import org.json.JSONException;
import org.json.JSONObject;
import tv.danmaku.ijk.media.player.IjkMediaMeta;
/* loaded from: classes11.dex */
public abstract class e<SelfT extends e<SelfT>> extends com.baidu.swan.apps.x.b.a.c<SelfT> {
    protected static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private Pair<String, JSONObject> bWN;

    public boolean ady() {
        return getBoolean("cts_launch_mode", false);
    }

    public SelfT dI(boolean z) {
        B("cts_launch_mode", z);
        return (SelfT) adw();
    }

    public String YS() {
        return getString("mAppTitle");
    }

    public SelfT jM(String str) {
        bb("mAppTitle", str);
        return (SelfT) adw();
    }

    public String getAppKey() {
        return getString("mAppKey");
    }

    public SelfT jL(String str) {
        bb("mAppKey", str);
        return (SelfT) adw();
    }

    public String getAppId() {
        return getString("mAppId", "");
    }

    public SelfT jK(String str) {
        bb("mAppId", str);
        return (SelfT) adw();
    }

    public String getIconUrl() {
        return getString("app_icon_url");
    }

    public SelfT jJ(String str) {
        bb("app_icon_url", str);
        return (SelfT) adw();
    }

    public String adl() {
        return "";
    }

    public SelfT jI(String str) {
        return (SelfT) adw();
    }

    public int adm() {
        return 0;
    }

    public String adn() {
        return "";
    }

    public String ado() {
        return "";
    }

    public String adp() {
        return "";
    }

    public String adq() {
        return "";
    }

    public SelfT jH(String str) {
        return (SelfT) adw();
    }

    public String adr() {
        return "";
    }

    public SelfT jG(String str) {
        return (SelfT) adw();
    }

    public SwanAppBearInfo ads() {
        return null;
    }

    public String getVersion() {
        return "";
    }

    public SelfT jF(String str) {
        return (SelfT) adw();
    }

    public String getVersionCode() {
        return "";
    }

    public int getType() {
        return 0;
    }

    public long adt() {
        return 0L;
    }

    public int getOrientation() {
        int i = getInt("appFrameOrientation", -1);
        if (-1 < i) {
            return i;
        }
        return -1;
    }

    public SelfT fn(int i) {
        return (SelfT) I("appFrameOrientation", i);
    }

    public long adz() {
        return getLong("navigate_bar_color_key", IjkMediaMeta.AV_CH_WIDE_LEFT);
    }

    public SelfT aO(long j) {
        if (IjkMediaMeta.AV_CH_WIDE_LEFT != j) {
            k("navigate_bar_color_key", j);
        }
        return (SelfT) adw();
    }

    public String adA() {
        return getString("mFrom");
    }

    public String adB() {
        return getString("mFromLast");
    }

    public SelfT jN(String str) {
        bb("mFromLast", adA());
        return (SelfT) bb("mFrom", str);
    }

    public String adC() {
        return getString("launchScheme");
    }

    public SelfT jO(String str) {
        return (SelfT) bb("launchScheme", str);
    }

    public String getPage() {
        return getString("mPage");
    }

    public SelfT jP(String str) {
        return (SelfT) bb("mPage", str);
    }

    public String adD() {
        return getString("max_swan_version");
    }

    public String adE() {
        return getString("min_swan_version");
    }

    public Bundle adF() {
        return jW("mExtraData");
    }

    public SelfT E(Bundle bundle) {
        return (SelfT) c("mExtraData", bundle);
    }

    @NonNull
    public Bundle adG() {
        Bundle adF = adF();
        if (adF == null) {
            Bundle bundle = new Bundle();
            E(bundle);
            return bundle;
        }
        return adF;
    }

    public SelfT ba(String str, String str2) {
        if (str != null && str2 != null) {
            adG().putString(str, str2);
        }
        return (SelfT) adw();
    }

    public String adH() {
        return getString("mClickId");
    }

    public SelfT jQ(String str) {
        return (SelfT) bb("mClickId", str);
    }

    public boolean isDebug() {
        return getBoolean("mIsDebug", false);
    }

    public SelfT dJ(boolean z) {
        return (SelfT) B("mIsDebug", z);
    }

    public String adI() {
        return getString("notInHistory");
    }

    public SelfT jR(String str) {
        return (SelfT) bb("notInHistory", str);
    }

    public String adJ() {
        return getString("launch_app_open_url");
    }

    public String adK() {
        return getString("launch_app_download_url");
    }

    public String adL() {
        return getString("targetSwanVersion");
    }

    public SelfT jS(String str) {
        return (SelfT) bb("targetSwanVersion", str);
    }

    public SwanCoreVersion YH() {
        return (SwanCoreVersion) jX("swanCoreVersion");
    }

    public SelfT b(SwanCoreVersion swanCoreVersion) {
        return (SelfT) a("swanCoreVersion", swanCoreVersion);
    }

    public ExtensionCore YI() {
        return (ExtensionCore) jX("extensionCore");
    }

    public SelfT c(ExtensionCore extensionCore) {
        return (SelfT) a("extensionCore", extensionCore);
    }

    public int getAppFrameType() {
        return getInt("appFrameType");
    }

    public SelfT fo(int i) {
        return (SelfT) I("appFrameType", i);
    }

    public boolean adM() {
        return getBoolean("console_switch", false);
    }

    public SelfT dK(boolean z) {
        return (SelfT) B("console_switch", z);
    }

    public int adN() {
        return getInt("launchFlags", 0);
    }

    public SelfT fp(int i) {
        return (SelfT) I("launchFlags", i);
    }

    public SelfT fq(int i) {
        return fp(adN() | i);
    }

    public long adu() {
        return 0L;
    }

    public SelfT aN(long j) {
        return (SelfT) adw();
    }

    public long adO() {
        return getLong("last_start_timestamp");
    }

    public SelfT aP(long j) {
        return (SelfT) k("last_start_timestamp", j);
    }

    public String adP() {
        return getString("remoteDebugUrl");
    }

    public SelfT jT(String str) {
        return (SelfT) bb("remoteDebugUrl", str);
    }

    public PMSAppInfo adQ() {
        return (PMSAppInfo) jX("pms_db_info_onload");
    }

    public SelfT g(PMSAppInfo pMSAppInfo) {
        return (SelfT) a("pms_db_info_onload", pMSAppInfo);
    }

    public SelfT h(PMSAppInfo pMSAppInfo) {
        if (pMSAppInfo != null) {
            a("pms_db_info_updated", pMSAppInfo);
            if (!adR()) {
                g(pMSAppInfo);
            }
        }
        return (SelfT) adw();
    }

    public boolean adR() {
        return containsKey("pms_db_info_onload") && adQ() != null;
    }

    public JSONObject adS() {
        String adC = adC();
        if (this.bWN != null && TextUtils.equals((CharSequence) this.bWN.first, adC)) {
            return (JSONObject) this.bWN.second;
        }
        this.bWN = null;
        if (TextUtils.isEmpty(adC)) {
            this.bWN = null;
            return null;
        }
        String queryParameter = Uri.parse(adC).getQueryParameter("_baiduboxapp");
        if (!TextUtils.isEmpty(queryParameter)) {
            try {
                this.bWN = new Pair<>(adC, new JSONObject(queryParameter).optJSONObject("ext"));
            } catch (JSONException e) {
                if (DEBUG) {
                    e.printStackTrace();
                }
            }
        }
        if (this.bWN == null) {
            return null;
        }
        return (JSONObject) this.bWN.second;
    }

    public String adT() {
        return getString("launch_id");
    }

    public boolean adU() {
        return getBoolean("swan_app_independent", false);
    }

    public SelfT dL(boolean z) {
        return (SelfT) B("swan_app_independent", z);
    }

    public String adV() {
        return getString("swan_app_sub_root_path");
    }

    public SelfT jU(String str) {
        return (SelfT) bb("swan_app_sub_root_path", str);
    }
}
