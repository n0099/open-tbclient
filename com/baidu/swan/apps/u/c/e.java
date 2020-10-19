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
    private Pair<String, JSONObject> cJZ;

    public boolean auh() {
        return getBoolean("cts_launch_mode", false);
    }

    public SelfT eY(boolean z) {
        X("cts_launch_mode", z);
        return (SelfT) auf();
    }

    public String aoj() {
        return getString("mAppTitle");
    }

    public SelfT oL(String str) {
        bO("mAppTitle", str);
        return (SelfT) auf();
    }

    public String getAppKey() {
        return getString("mAppKey");
    }

    public SelfT oK(String str) {
        bO("mAppKey", str);
        return (SelfT) auf();
    }

    public String getAppId() {
        return getString("mAppId", "");
    }

    public SelfT oJ(String str) {
        bO("mAppId", str);
        return (SelfT) auf();
    }

    public String getIconUrl() {
        return getString("app_icon_url");
    }

    public SelfT oI(String str) {
        bO("app_icon_url", str);
        return (SelfT) auf();
    }

    public String atT() {
        return "";
    }

    public SelfT oH(String str) {
        return (SelfT) auf();
    }

    public int atU() {
        return 0;
    }

    public String atV() {
        return "";
    }

    public String atW() {
        return "";
    }

    public String atX() {
        return "";
    }

    public String atY() {
        return "";
    }

    public SelfT oG(String str) {
        return (SelfT) auf();
    }

    public String atZ() {
        return "";
    }

    public SelfT oF(String str) {
        return (SelfT) auf();
    }

    public SwanAppBearInfo aua() {
        return null;
    }

    public String aub() {
        return "";
    }

    public String getVersion() {
        return "";
    }

    public SelfT oE(String str) {
        return (SelfT) auf();
    }

    public String getVersionCode() {
        return "";
    }

    public int getType() {
        return 0;
    }

    public long auc() {
        return 0L;
    }

    public int getOrientation() {
        int i = getInt("appFrameOrientation", -1);
        if (-1 < i) {
            return i;
        }
        return -1;
    }

    public SelfT iI(int i) {
        return (SelfT) P("appFrameOrientation", i);
    }

    public long aui() {
        return getLong("navigate_bar_color_key", 2147483648L);
    }

    public SelfT bn(long j) {
        if (2147483648L != j) {
            n("navigate_bar_color_key", j);
        }
        return (SelfT) auf();
    }

    public String auj() {
        return getString("mFrom");
    }

    public String auk() {
        return getString("mFromLast");
    }

    public SelfT oM(String str) {
        bO("mFromLast", auj());
        return (SelfT) bO("mFrom", str);
    }

    public String aul() {
        return getString("launchScheme");
    }

    public SelfT oN(String str) {
        return (SelfT) bO("launchScheme", str);
    }

    public String getPage() {
        return getString("mPage");
    }

    public SelfT oO(String str) {
        return (SelfT) bO("mPage", str);
    }

    public String aum() {
        return getString("max_swan_version");
    }

    public String aun() {
        return getString("min_swan_version");
    }

    public Bundle auo() {
        return oW("mExtraData");
    }

    public SelfT G(Bundle bundle) {
        return (SelfT) d("mExtraData", bundle);
    }

    @NonNull
    public Bundle aup() {
        Bundle auo = auo();
        if (auo == null) {
            Bundle bundle = new Bundle();
            G(bundle);
            return bundle;
        }
        return auo;
    }

    public SelfT bN(String str, String str2) {
        if (str != null && str2 != null) {
            aup().putString(str, str2);
        }
        return (SelfT) auf();
    }

    public SelfT m(String str, long j) {
        aup().putLong(str, j);
        return (SelfT) auf();
    }

    public String auq() {
        return getString("mClickId");
    }

    public SelfT oP(String str) {
        return (SelfT) bO("mClickId", str);
    }

    public boolean isDebug() {
        return getBoolean("mIsDebug", false);
    }

    public SelfT eZ(boolean z) {
        return (SelfT) X("mIsDebug", z);
    }

    public String aur() {
        return getString("notInHistory");
    }

    public SelfT oQ(String str) {
        return (SelfT) bO("notInHistory", str);
    }

    public String aus() {
        return getString("launch_app_open_url");
    }

    public String aut() {
        return getString("launch_app_download_url");
    }

    public String auu() {
        return getString("targetSwanVersion");
    }

    public SelfT oR(String str) {
        return (SelfT) bO("targetSwanVersion", str);
    }

    public SwanCoreVersion anI() {
        return (SwanCoreVersion) oX("swanCoreVersion");
    }

    public SelfT b(SwanCoreVersion swanCoreVersion) {
        return (SelfT) a("swanCoreVersion", swanCoreVersion);
    }

    public ExtensionCore anJ() {
        return (ExtensionCore) oX("extensionCore");
    }

    public SelfT c(ExtensionCore extensionCore) {
        return (SelfT) a("extensionCore", extensionCore);
    }

    public int getAppFrameType() {
        return getInt("appFrameType");
    }

    public SelfT iJ(int i) {
        return (SelfT) P("appFrameType", i);
    }

    public boolean auv() {
        return getBoolean("console_switch", false);
    }

    public SelfT fa(boolean z) {
        return (SelfT) X("console_switch", z);
    }

    public int auw() {
        return getInt("launchFlags", 0);
    }

    public SelfT iK(int i) {
        return (SelfT) P("launchFlags", i);
    }

    public SelfT iL(int i) {
        return iK(auw() | i);
    }

    public long aud() {
        return 0L;
    }

    public SelfT bm(long j) {
        return (SelfT) auf();
    }

    public long aux() {
        return getLong("last_start_timestamp");
    }

    public SelfT bo(long j) {
        return (SelfT) n("last_start_timestamp", j);
    }

    public String auy() {
        return getString("remoteDebugUrl");
    }

    public SelfT oS(String str) {
        return (SelfT) bO("remoteDebugUrl", str);
    }

    public PMSAppInfo auz() {
        return (PMSAppInfo) oX("pms_db_info_onload");
    }

    public SelfT k(PMSAppInfo pMSAppInfo) {
        return (SelfT) a("pms_db_info_onload", pMSAppInfo);
    }

    public SelfT l(PMSAppInfo pMSAppInfo) {
        if (pMSAppInfo != null) {
            a("pms_db_info_updated", pMSAppInfo);
            if (!auA()) {
                k(pMSAppInfo);
            }
        }
        return (SelfT) auf();
    }

    public boolean auA() {
        return containsKey("pms_db_info_onload") && auz() != null;
    }

    public JSONObject auB() {
        String aul = aul();
        if (this.cJZ != null && TextUtils.equals((CharSequence) this.cJZ.first, aul)) {
            return (JSONObject) this.cJZ.second;
        }
        this.cJZ = null;
        if (TextUtils.isEmpty(aul)) {
            this.cJZ = null;
            return null;
        }
        String queryParameter = Uri.parse(aul).getQueryParameter("_baiduboxapp");
        if (!TextUtils.isEmpty(queryParameter)) {
            try {
                this.cJZ = new Pair<>(aul, new JSONObject(queryParameter).optJSONObject("ext"));
            } catch (JSONException e) {
                if (DEBUG) {
                    e.printStackTrace();
                }
            }
        }
        if (this.cJZ == null) {
            return null;
        }
        return (JSONObject) this.cJZ.second;
    }

    public String auC() {
        return getString("launch_id");
    }

    public SelfT oT(String str) {
        return (SelfT) bO("launch_id", str);
    }

    public boolean auD() {
        return getBoolean("swan_app_independent", false);
    }

    public SelfT fb(boolean z) {
        return (SelfT) X("swan_app_independent", z);
    }

    public String auE() {
        return getString("swan_app_sub_root_path");
    }

    public SelfT oU(String str) {
        return (SelfT) bO("swan_app_sub_root_path", str);
    }
}
