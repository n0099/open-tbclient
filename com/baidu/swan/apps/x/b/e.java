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
    private Pair<String, JSONObject> byB;

    public boolean VK() {
        return getBoolean("cts_launch_mode", false);
    }

    public SelfT cM(boolean z) {
        w("cts_launch_mode", z);
        return (SelfT) VI();
    }

    public String Re() {
        return getString("mAppTitle");
    }

    public SelfT iz(String str) {
        aR("mAppTitle", str);
        return (SelfT) VI();
    }

    public String getAppKey() {
        return getString("mAppKey");
    }

    public SelfT iy(String str) {
        aR("mAppKey", str);
        return (SelfT) VI();
    }

    public String getAppId() {
        return getString("mAppId", "");
    }

    public SelfT ix(String str) {
        aR("mAppId", str);
        return (SelfT) VI();
    }

    public String getIconUrl() {
        return getString("app_icon_url");
    }

    public SelfT iw(String str) {
        aR("app_icon_url", str);
        return (SelfT) VI();
    }

    public String Vx() {
        return "";
    }

    public SelfT iv(String str) {
        return (SelfT) VI();
    }

    public int Vy() {
        return 0;
    }

    public String Vz() {
        return "";
    }

    public String VA() {
        return "";
    }

    public String VB() {
        return "";
    }

    public String VC() {
        return "";
    }

    public SelfT iu(String str) {
        return (SelfT) VI();
    }

    public String VD() {
        return "";
    }

    public SelfT it(String str) {
        return (SelfT) VI();
    }

    public SwanAppBearInfo VE() {
        return null;
    }

    public String getVersion() {
        return "";
    }

    public SelfT is(String str) {
        return (SelfT) VI();
    }

    public String getVersionCode() {
        return "";
    }

    public int getType() {
        return 0;
    }

    public long VF() {
        return 0L;
    }

    public int getOrientation() {
        int i = getInt("appFrameOrientation", -1);
        if (-1 < i) {
            return i;
        }
        return -1;
    }

    public SelfT fi(int i) {
        return (SelfT) A("appFrameOrientation", i);
    }

    public long VL() {
        return getLong("navigate_bar_color_key", IjkMediaMeta.AV_CH_WIDE_LEFT);
    }

    public SelfT ak(long j) {
        if (IjkMediaMeta.AV_CH_WIDE_LEFT != j) {
            j("navigate_bar_color_key", j);
        }
        return (SelfT) VI();
    }

    public String VM() {
        return getString("mFrom");
    }

    public String VN() {
        return getString("mFromLast");
    }

    public SelfT iA(String str) {
        aR("mFromLast", VM());
        return (SelfT) aR("mFrom", str);
    }

    public String VO() {
        return getString("launchScheme");
    }

    public SelfT iB(String str) {
        return (SelfT) aR("launchScheme", str);
    }

    public String getPage() {
        return getString("mPage");
    }

    public SelfT iC(String str) {
        return (SelfT) aR("mPage", str);
    }

    public String VP() {
        return getString("max_swan_version");
    }

    public String VQ() {
        return getString("min_swan_version");
    }

    public Bundle VR() {
        return iJ("mExtraData");
    }

    public SelfT E(Bundle bundle) {
        return (SelfT) c("mExtraData", bundle);
    }

    @NonNull
    public Bundle VS() {
        Bundle VR = VR();
        if (VR == null) {
            Bundle bundle = new Bundle();
            E(bundle);
            return bundle;
        }
        return VR;
    }

    public SelfT aQ(String str, String str2) {
        if (str != null && str2 != null) {
            VS().putString(str, str2);
        }
        return (SelfT) VI();
    }

    public String VT() {
        return getString("mClickId");
    }

    public SelfT iD(String str) {
        return (SelfT) aR("mClickId", str);
    }

    public boolean isDebug() {
        return getBoolean("mIsDebug", false);
    }

    public SelfT cN(boolean z) {
        return (SelfT) w("mIsDebug", z);
    }

    public String VU() {
        return getString("notInHistory");
    }

    public SelfT iE(String str) {
        return (SelfT) aR("notInHistory", str);
    }

    public String VV() {
        return getString("launch_app_open_url");
    }

    public String VW() {
        return getString("launch_app_download_url");
    }

    public String VX() {
        return getString("targetSwanVersion");
    }

    public SelfT iF(String str) {
        return (SelfT) aR("targetSwanVersion", str);
    }

    public SwanCoreVersion QT() {
        return (SwanCoreVersion) iK("swanCoreVersion");
    }

    public SelfT b(SwanCoreVersion swanCoreVersion) {
        return (SelfT) a("swanCoreVersion", swanCoreVersion);
    }

    public ExtensionCore QU() {
        return (ExtensionCore) iK("extensionCore");
    }

    public SelfT c(ExtensionCore extensionCore) {
        return (SelfT) a("extensionCore", extensionCore);
    }

    public int getAppFrameType() {
        return getInt("appFrameType");
    }

    public SelfT fj(int i) {
        return (SelfT) A("appFrameType", i);
    }

    public boolean VY() {
        return getBoolean("console_switch", false);
    }

    public SelfT cO(boolean z) {
        return (SelfT) w("console_switch", z);
    }

    public int VZ() {
        return getInt("launchFlags", 0);
    }

    public SelfT fk(int i) {
        return (SelfT) A("launchFlags", i);
    }

    public SelfT fl(int i) {
        return fk(VZ() | i);
    }

    public long VG() {
        return 0L;
    }

    public SelfT aj(long j) {
        return (SelfT) VI();
    }

    public long Wa() {
        return getLong("last_start_timestamp");
    }

    public SelfT al(long j) {
        return (SelfT) j("last_start_timestamp", j);
    }

    public String Wb() {
        return getString("remoteDebugUrl");
    }

    public SelfT iG(String str) {
        return (SelfT) aR("remoteDebugUrl", str);
    }

    public PMSAppInfo Wc() {
        return (PMSAppInfo) iK("pms_db_info_onload");
    }

    public SelfT g(PMSAppInfo pMSAppInfo) {
        return (SelfT) a("pms_db_info_onload", pMSAppInfo);
    }

    public SelfT h(PMSAppInfo pMSAppInfo) {
        if (pMSAppInfo != null) {
            a("pms_db_info_updated", pMSAppInfo);
            if (!Wd()) {
                g(pMSAppInfo);
            }
        }
        return (SelfT) VI();
    }

    public boolean Wd() {
        return containsKey("pms_db_info_onload") && Wc() != null;
    }

    public JSONObject We() {
        String VO = VO();
        if (this.byB != null && TextUtils.equals((CharSequence) this.byB.first, VO)) {
            return (JSONObject) this.byB.second;
        }
        this.byB = null;
        if (TextUtils.isEmpty(VO)) {
            this.byB = null;
            return null;
        }
        String queryParameter = Uri.parse(VO).getQueryParameter("_baiduboxapp");
        if (!TextUtils.isEmpty(queryParameter)) {
            try {
                this.byB = new Pair<>(VO, new JSONObject(queryParameter).optJSONObject("ext"));
            } catch (JSONException e) {
                if (DEBUG) {
                    e.printStackTrace();
                }
            }
        }
        if (this.byB == null) {
            return null;
        }
        return (JSONObject) this.byB.second;
    }

    public String Wf() {
        return getString("launch_id");
    }

    public boolean Wg() {
        return getBoolean("swan_app_independent", false);
    }

    public SelfT cP(boolean z) {
        return (SelfT) w("swan_app_independent", z);
    }

    public String Wh() {
        return getString("swan_app_sub_root_path");
    }

    public SelfT iH(String str) {
        return (SelfT) aR("swan_app_sub_root_path", str);
    }
}
