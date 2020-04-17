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
    private Pair<String, JSONObject> bWH;

    public boolean adz() {
        return getBoolean("cts_launch_mode", false);
    }

    public SelfT dI(boolean z) {
        B("cts_launch_mode", z);
        return (SelfT) adx();
    }

    public String YT() {
        return getString("mAppTitle");
    }

    public SelfT jM(String str) {
        bb("mAppTitle", str);
        return (SelfT) adx();
    }

    public String getAppKey() {
        return getString("mAppKey");
    }

    public SelfT jL(String str) {
        bb("mAppKey", str);
        return (SelfT) adx();
    }

    public String getAppId() {
        return getString("mAppId", "");
    }

    public SelfT jK(String str) {
        bb("mAppId", str);
        return (SelfT) adx();
    }

    public String getIconUrl() {
        return getString("app_icon_url");
    }

    public SelfT jJ(String str) {
        bb("app_icon_url", str);
        return (SelfT) adx();
    }

    public String adm() {
        return "";
    }

    public SelfT jI(String str) {
        return (SelfT) adx();
    }

    public int adn() {
        return 0;
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

    public String adr() {
        return "";
    }

    public SelfT jH(String str) {
        return (SelfT) adx();
    }

    public String ads() {
        return "";
    }

    public SelfT jG(String str) {
        return (SelfT) adx();
    }

    public SwanAppBearInfo adt() {
        return null;
    }

    public String getVersion() {
        return "";
    }

    public SelfT jF(String str) {
        return (SelfT) adx();
    }

    public String getVersionCode() {
        return "";
    }

    public int getType() {
        return 0;
    }

    public long adu() {
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

    public long adA() {
        return getLong("navigate_bar_color_key", IjkMediaMeta.AV_CH_WIDE_LEFT);
    }

    public SelfT aO(long j) {
        if (IjkMediaMeta.AV_CH_WIDE_LEFT != j) {
            k("navigate_bar_color_key", j);
        }
        return (SelfT) adx();
    }

    public String adB() {
        return getString("mFrom");
    }

    public String adC() {
        return getString("mFromLast");
    }

    public SelfT jN(String str) {
        bb("mFromLast", adB());
        return (SelfT) bb("mFrom", str);
    }

    public String adD() {
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

    public String adE() {
        return getString("max_swan_version");
    }

    public String adF() {
        return getString("min_swan_version");
    }

    public Bundle adG() {
        return jW("mExtraData");
    }

    public SelfT E(Bundle bundle) {
        return (SelfT) c("mExtraData", bundle);
    }

    @NonNull
    public Bundle adH() {
        Bundle adG = adG();
        if (adG == null) {
            Bundle bundle = new Bundle();
            E(bundle);
            return bundle;
        }
        return adG;
    }

    public SelfT ba(String str, String str2) {
        if (str != null && str2 != null) {
            adH().putString(str, str2);
        }
        return (SelfT) adx();
    }

    public String adI() {
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

    public String adJ() {
        return getString("notInHistory");
    }

    public SelfT jR(String str) {
        return (SelfT) bb("notInHistory", str);
    }

    public String adK() {
        return getString("launch_app_open_url");
    }

    public String adL() {
        return getString("launch_app_download_url");
    }

    public String adM() {
        return getString("targetSwanVersion");
    }

    public SelfT jS(String str) {
        return (SelfT) bb("targetSwanVersion", str);
    }

    public SwanCoreVersion YI() {
        return (SwanCoreVersion) jX("swanCoreVersion");
    }

    public SelfT b(SwanCoreVersion swanCoreVersion) {
        return (SelfT) a("swanCoreVersion", swanCoreVersion);
    }

    public ExtensionCore YJ() {
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

    public boolean adN() {
        return getBoolean("console_switch", false);
    }

    public SelfT dK(boolean z) {
        return (SelfT) B("console_switch", z);
    }

    public int adO() {
        return getInt("launchFlags", 0);
    }

    public SelfT fp(int i) {
        return (SelfT) I("launchFlags", i);
    }

    public SelfT fq(int i) {
        return fp(adO() | i);
    }

    public long adv() {
        return 0L;
    }

    public SelfT aN(long j) {
        return (SelfT) adx();
    }

    public long adP() {
        return getLong("last_start_timestamp");
    }

    public SelfT aP(long j) {
        return (SelfT) k("last_start_timestamp", j);
    }

    public String adQ() {
        return getString("remoteDebugUrl");
    }

    public SelfT jT(String str) {
        return (SelfT) bb("remoteDebugUrl", str);
    }

    public PMSAppInfo adR() {
        return (PMSAppInfo) jX("pms_db_info_onload");
    }

    public SelfT g(PMSAppInfo pMSAppInfo) {
        return (SelfT) a("pms_db_info_onload", pMSAppInfo);
    }

    public SelfT h(PMSAppInfo pMSAppInfo) {
        if (pMSAppInfo != null) {
            a("pms_db_info_updated", pMSAppInfo);
            if (!adS()) {
                g(pMSAppInfo);
            }
        }
        return (SelfT) adx();
    }

    public boolean adS() {
        return containsKey("pms_db_info_onload") && adR() != null;
    }

    public JSONObject adT() {
        String adD = adD();
        if (this.bWH != null && TextUtils.equals((CharSequence) this.bWH.first, adD)) {
            return (JSONObject) this.bWH.second;
        }
        this.bWH = null;
        if (TextUtils.isEmpty(adD)) {
            this.bWH = null;
            return null;
        }
        String queryParameter = Uri.parse(adD).getQueryParameter("_baiduboxapp");
        if (!TextUtils.isEmpty(queryParameter)) {
            try {
                this.bWH = new Pair<>(adD, new JSONObject(queryParameter).optJSONObject("ext"));
            } catch (JSONException e) {
                if (DEBUG) {
                    e.printStackTrace();
                }
            }
        }
        if (this.bWH == null) {
            return null;
        }
        return (JSONObject) this.bWH.second;
    }

    public String adU() {
        return getString("launch_id");
    }

    public boolean adV() {
        return getBoolean("swan_app_independent", false);
    }

    public SelfT dL(boolean z) {
        return (SelfT) B("swan_app_independent", z);
    }

    public String adW() {
        return getString("swan_app_sub_root_path");
    }

    public SelfT jU(String str) {
        return (SelfT) bb("swan_app_sub_root_path", str);
    }
}
