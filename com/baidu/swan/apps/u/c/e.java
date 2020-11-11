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
    private Pair<String, JSONObject> cYo;

    public boolean ayB() {
        return getBoolean("cts_launch_mode", false);
    }

    public SelfT fu(boolean z) {
        Z("cts_launch_mode", z);
        return (SelfT) ayz();
    }

    public String asF() {
        return getString("mAppTitle");
    }

    public SelfT ps(String str) {
        bV("mAppTitle", str);
        return (SelfT) ayz();
    }

    public String getAppKey() {
        return getString("mAppKey");
    }

    public SelfT pr(String str) {
        bV("mAppKey", str);
        return (SelfT) ayz();
    }

    public String getAppId() {
        return getString("mAppId", "");
    }

    public SelfT pq(String str) {
        bV("mAppId", str);
        return (SelfT) ayz();
    }

    public String getIconUrl() {
        return getString("app_icon_url");
    }

    public SelfT pp(String str) {
        bV("app_icon_url", str);
        return (SelfT) ayz();
    }

    public String ayn() {
        return "";
    }

    public SelfT po(String str) {
        return (SelfT) ayz();
    }

    public int ayo() {
        return 0;
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

    public String ays() {
        return "";
    }

    public SelfT pn(String str) {
        return (SelfT) ayz();
    }

    public String ayt() {
        return "";
    }

    public SelfT pm(String str) {
        return (SelfT) ayz();
    }

    public SwanAppBearInfo ayu() {
        return null;
    }

    public String ayv() {
        return "";
    }

    public String getVersion() {
        return "";
    }

    public SelfT pl(String str) {
        return (SelfT) ayz();
    }

    public String getVersionCode() {
        return "";
    }

    public int getType() {
        return 0;
    }

    public long ayw() {
        return 0L;
    }

    public int getOrientation() {
        int i = getInt("appFrameOrientation", -1);
        if (-1 < i) {
            return i;
        }
        return -1;
    }

    public SelfT jd(int i) {
        return (SelfT) R("appFrameOrientation", i);
    }

    public long ayC() {
        return getLong("navigate_bar_color_key", 2147483648L);
    }

    public SelfT bL(long j) {
        if (2147483648L != j) {
            p("navigate_bar_color_key", j);
        }
        return (SelfT) ayz();
    }

    public String ayD() {
        return getString("mFrom");
    }

    public String ayE() {
        return getString("mFromLast");
    }

    public SelfT pt(String str) {
        bV("mFromLast", ayD());
        return (SelfT) bV("mFrom", str);
    }

    public String ayF() {
        return getString("launchScheme");
    }

    public SelfT pu(String str) {
        return (SelfT) bV("launchScheme", str);
    }

    public String getPage() {
        return getString("mPage");
    }

    public SelfT pv(String str) {
        return (SelfT) bV("mPage", str);
    }

    public String ayG() {
        return getString("max_swan_version");
    }

    public String ayH() {
        return getString("min_swan_version");
    }

    public Bundle ayI() {
        return pD("mExtraData");
    }

    public SelfT G(Bundle bundle) {
        return (SelfT) d("mExtraData", bundle);
    }

    @NonNull
    public Bundle ayJ() {
        Bundle ayI = ayI();
        if (ayI == null) {
            Bundle bundle = new Bundle();
            G(bundle);
            return bundle;
        }
        return ayI;
    }

    public SelfT bU(String str, String str2) {
        if (str != null && str2 != null) {
            ayJ().putString(str, str2);
        }
        return (SelfT) ayz();
    }

    public SelfT o(String str, long j) {
        ayJ().putLong(str, j);
        return (SelfT) ayz();
    }

    public String ayK() {
        return getString("mClickId");
    }

    public SelfT pw(String str) {
        return (SelfT) bV("mClickId", str);
    }

    public boolean isDebug() {
        return getBoolean("mIsDebug", false);
    }

    public SelfT fv(boolean z) {
        return (SelfT) Z("mIsDebug", z);
    }

    public String ayL() {
        return getString("notInHistory");
    }

    public SelfT px(String str) {
        return (SelfT) bV("notInHistory", str);
    }

    public String ayM() {
        return getString("launch_app_open_url");
    }

    public String ayN() {
        return getString("launch_app_download_url");
    }

    public String ayO() {
        return getString("targetSwanVersion");
    }

    public SelfT py(String str) {
        return (SelfT) bV("targetSwanVersion", str);
    }

    public SwanCoreVersion asd() {
        return (SwanCoreVersion) pE("swanCoreVersion");
    }

    public SelfT b(SwanCoreVersion swanCoreVersion) {
        return (SelfT) a("swanCoreVersion", swanCoreVersion);
    }

    public ExtensionCore ase() {
        return (ExtensionCore) pE("extensionCore");
    }

    public SelfT c(ExtensionCore extensionCore) {
        return (SelfT) a("extensionCore", extensionCore);
    }

    public int getAppFrameType() {
        return getInt("appFrameType");
    }

    public SelfT je(int i) {
        return (SelfT) R("appFrameType", i);
    }

    public boolean ayP() {
        return getBoolean("console_switch", false);
    }

    public SelfT fw(boolean z) {
        return (SelfT) Z("console_switch", z);
    }

    public int ayQ() {
        return getInt("launchFlags", 0);
    }

    public SelfT jf(int i) {
        return (SelfT) R("launchFlags", i);
    }

    public SelfT jg(int i) {
        return jf(ayQ() | i);
    }

    public long ayx() {
        return 0L;
    }

    public SelfT bK(long j) {
        return (SelfT) ayz();
    }

    public long ayR() {
        return getLong("last_start_timestamp");
    }

    public SelfT bM(long j) {
        return (SelfT) p("last_start_timestamp", j);
    }

    public String ayS() {
        return getString("remoteDebugUrl");
    }

    public SelfT pz(String str) {
        return (SelfT) bV("remoteDebugUrl", str);
    }

    public PMSAppInfo ayT() {
        return (PMSAppInfo) pE("pms_db_info_onload");
    }

    public SelfT k(PMSAppInfo pMSAppInfo) {
        return (SelfT) a("pms_db_info_onload", pMSAppInfo);
    }

    public SelfT l(PMSAppInfo pMSAppInfo) {
        if (pMSAppInfo != null) {
            a("pms_db_info_updated", pMSAppInfo);
            if (!ayU()) {
                k(pMSAppInfo);
            }
        }
        return (SelfT) ayz();
    }

    public boolean ayU() {
        return containsKey("pms_db_info_onload") && ayT() != null;
    }

    public JSONObject ayV() {
        String ayF = ayF();
        if (this.cYo != null && TextUtils.equals((CharSequence) this.cYo.first, ayF)) {
            return (JSONObject) this.cYo.second;
        }
        this.cYo = null;
        if (TextUtils.isEmpty(ayF)) {
            this.cYo = null;
            return null;
        }
        String queryParameter = Uri.parse(ayF).getQueryParameter("_baiduboxapp");
        if (!TextUtils.isEmpty(queryParameter)) {
            try {
                this.cYo = new Pair<>(ayF, new JSONObject(queryParameter).optJSONObject("ext"));
            } catch (JSONException e) {
                if (DEBUG) {
                    e.printStackTrace();
                }
            }
        }
        if (this.cYo == null) {
            return null;
        }
        return (JSONObject) this.cYo.second;
    }

    public String ayW() {
        return getString("launch_id");
    }

    public SelfT pA(String str) {
        return (SelfT) bV("launch_id", str);
    }

    public boolean ayX() {
        return getBoolean("swan_app_independent", false);
    }

    public SelfT fx(boolean z) {
        return (SelfT) Z("swan_app_independent", z);
    }

    public String ayY() {
        return getString("swan_app_sub_root_path");
    }

    public SelfT pB(String str) {
        return (SelfT) bV("swan_app_sub_root_path", str);
    }
}
