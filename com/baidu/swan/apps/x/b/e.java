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
    private Pair<String, JSONObject> byp;

    public boolean VH() {
        return getBoolean("cts_launch_mode", false);
    }

    public SelfT cL(boolean z) {
        w("cts_launch_mode", z);
        return (SelfT) VF();
    }

    public String Rb() {
        return getString("mAppTitle");
    }

    public SelfT iA(String str) {
        aS("mAppTitle", str);
        return (SelfT) VF();
    }

    public String getAppKey() {
        return getString("mAppKey");
    }

    public SelfT iz(String str) {
        aS("mAppKey", str);
        return (SelfT) VF();
    }

    public String getAppId() {
        return getString("mAppId", "");
    }

    public SelfT iy(String str) {
        aS("mAppId", str);
        return (SelfT) VF();
    }

    public String getIconUrl() {
        return getString("app_icon_url");
    }

    public SelfT ix(String str) {
        aS("app_icon_url", str);
        return (SelfT) VF();
    }

    public String Vu() {
        return "";
    }

    public SelfT iw(String str) {
        return (SelfT) VF();
    }

    public int Vv() {
        return 0;
    }

    public String Vw() {
        return "";
    }

    public String Vx() {
        return "";
    }

    public String Vy() {
        return "";
    }

    public String Vz() {
        return "";
    }

    public SelfT iv(String str) {
        return (SelfT) VF();
    }

    public String VA() {
        return "";
    }

    public SelfT iu(String str) {
        return (SelfT) VF();
    }

    public SwanAppBearInfo VB() {
        return null;
    }

    public String getVersion() {
        return "";
    }

    public SelfT it(String str) {
        return (SelfT) VF();
    }

    public String getVersionCode() {
        return "";
    }

    public int getType() {
        return 0;
    }

    public long VC() {
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

    public long VI() {
        return getLong("navigate_bar_color_key", IjkMediaMeta.AV_CH_WIDE_LEFT);
    }

    public SelfT ak(long j) {
        if (IjkMediaMeta.AV_CH_WIDE_LEFT != j) {
            j("navigate_bar_color_key", j);
        }
        return (SelfT) VF();
    }

    public String VJ() {
        return getString("mFrom");
    }

    public String VK() {
        return getString("mFromLast");
    }

    public SelfT iB(String str) {
        aS("mFromLast", VJ());
        return (SelfT) aS("mFrom", str);
    }

    public String VL() {
        return getString("launchScheme");
    }

    public SelfT iC(String str) {
        return (SelfT) aS("launchScheme", str);
    }

    public String getPage() {
        return getString("mPage");
    }

    public SelfT iD(String str) {
        return (SelfT) aS("mPage", str);
    }

    public String VM() {
        return getString("max_swan_version");
    }

    public String VN() {
        return getString("min_swan_version");
    }

    public Bundle VO() {
        return iK("mExtraData");
    }

    public SelfT E(Bundle bundle) {
        return (SelfT) c("mExtraData", bundle);
    }

    @NonNull
    public Bundle VP() {
        Bundle VO = VO();
        if (VO == null) {
            Bundle bundle = new Bundle();
            E(bundle);
            return bundle;
        }
        return VO;
    }

    public SelfT aR(String str, String str2) {
        if (str != null && str2 != null) {
            VP().putString(str, str2);
        }
        return (SelfT) VF();
    }

    public String VQ() {
        return getString("mClickId");
    }

    public SelfT iE(String str) {
        return (SelfT) aS("mClickId", str);
    }

    public boolean isDebug() {
        return getBoolean("mIsDebug", false);
    }

    public SelfT cM(boolean z) {
        return (SelfT) w("mIsDebug", z);
    }

    public String VR() {
        return getString("notInHistory");
    }

    public SelfT iF(String str) {
        return (SelfT) aS("notInHistory", str);
    }

    public String VS() {
        return getString("launch_app_open_url");
    }

    public String VT() {
        return getString("launch_app_download_url");
    }

    public String VU() {
        return getString("targetSwanVersion");
    }

    public SelfT iG(String str) {
        return (SelfT) aS("targetSwanVersion", str);
    }

    public SwanCoreVersion QQ() {
        return (SwanCoreVersion) iL("swanCoreVersion");
    }

    public SelfT b(SwanCoreVersion swanCoreVersion) {
        return (SelfT) a("swanCoreVersion", swanCoreVersion);
    }

    public ExtensionCore QR() {
        return (ExtensionCore) iL("extensionCore");
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

    public boolean VV() {
        return getBoolean("console_switch", false);
    }

    public SelfT cN(boolean z) {
        return (SelfT) w("console_switch", z);
    }

    public int VW() {
        return getInt("launchFlags", 0);
    }

    public SelfT fk(int i) {
        return (SelfT) A("launchFlags", i);
    }

    public SelfT fl(int i) {
        return fk(VW() | i);
    }

    public long VD() {
        return 0L;
    }

    public SelfT aj(long j) {
        return (SelfT) VF();
    }

    public long VX() {
        return getLong("last_start_timestamp");
    }

    public SelfT al(long j) {
        return (SelfT) j("last_start_timestamp", j);
    }

    public String VY() {
        return getString("remoteDebugUrl");
    }

    public SelfT iH(String str) {
        return (SelfT) aS("remoteDebugUrl", str);
    }

    public PMSAppInfo VZ() {
        return (PMSAppInfo) iL("pms_db_info_onload");
    }

    public SelfT g(PMSAppInfo pMSAppInfo) {
        return (SelfT) a("pms_db_info_onload", pMSAppInfo);
    }

    public SelfT h(PMSAppInfo pMSAppInfo) {
        if (pMSAppInfo != null) {
            a("pms_db_info_updated", pMSAppInfo);
            if (!Wa()) {
                g(pMSAppInfo);
            }
        }
        return (SelfT) VF();
    }

    public boolean Wa() {
        return containsKey("pms_db_info_onload") && VZ() != null;
    }

    public JSONObject Wb() {
        String VL = VL();
        if (this.byp != null && TextUtils.equals((CharSequence) this.byp.first, VL)) {
            return (JSONObject) this.byp.second;
        }
        this.byp = null;
        if (TextUtils.isEmpty(VL)) {
            this.byp = null;
            return null;
        }
        String queryParameter = Uri.parse(VL).getQueryParameter("_baiduboxapp");
        if (!TextUtils.isEmpty(queryParameter)) {
            try {
                this.byp = new Pair<>(VL, new JSONObject(queryParameter).optJSONObject("ext"));
            } catch (JSONException e) {
                if (DEBUG) {
                    e.printStackTrace();
                }
            }
        }
        if (this.byp == null) {
            return null;
        }
        return (JSONObject) this.byp.second;
    }

    public String Wc() {
        return getString("launch_id");
    }

    public boolean Wd() {
        return getBoolean("swan_app_independent", false);
    }

    public SelfT cO(boolean z) {
        return (SelfT) w("swan_app_independent", z);
    }

    public String We() {
        return getString("swan_app_sub_root_path");
    }

    public SelfT iI(String str) {
        return (SelfT) aS("swan_app_sub_root_path", str);
    }
}
