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
    private Pair<String, JSONObject> byo;

    public boolean VF() {
        return getBoolean("cts_launch_mode", false);
    }

    public SelfT cL(boolean z) {
        w("cts_launch_mode", z);
        return (SelfT) VD();
    }

    public String QZ() {
        return getString("mAppTitle");
    }

    public SelfT iA(String str) {
        aS("mAppTitle", str);
        return (SelfT) VD();
    }

    public String getAppKey() {
        return getString("mAppKey");
    }

    public SelfT iz(String str) {
        aS("mAppKey", str);
        return (SelfT) VD();
    }

    public String getAppId() {
        return getString("mAppId", "");
    }

    public SelfT iy(String str) {
        aS("mAppId", str);
        return (SelfT) VD();
    }

    public String getIconUrl() {
        return getString("app_icon_url");
    }

    public SelfT ix(String str) {
        aS("app_icon_url", str);
        return (SelfT) VD();
    }

    public String Vs() {
        return "";
    }

    public SelfT iw(String str) {
        return (SelfT) VD();
    }

    public int Vt() {
        return 0;
    }

    public String Vu() {
        return "";
    }

    public String Vv() {
        return "";
    }

    public String Vw() {
        return "";
    }

    public String Vx() {
        return "";
    }

    public SelfT iv(String str) {
        return (SelfT) VD();
    }

    public String Vy() {
        return "";
    }

    public SelfT iu(String str) {
        return (SelfT) VD();
    }

    public SwanAppBearInfo Vz() {
        return null;
    }

    public String getVersion() {
        return "";
    }

    public SelfT it(String str) {
        return (SelfT) VD();
    }

    public String getVersionCode() {
        return "";
    }

    public int getType() {
        return 0;
    }

    public long VA() {
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

    public long VG() {
        return getLong("navigate_bar_color_key", IjkMediaMeta.AV_CH_WIDE_LEFT);
    }

    public SelfT ak(long j) {
        if (IjkMediaMeta.AV_CH_WIDE_LEFT != j) {
            j("navigate_bar_color_key", j);
        }
        return (SelfT) VD();
    }

    public String VH() {
        return getString("mFrom");
    }

    public String VI() {
        return getString("mFromLast");
    }

    public SelfT iB(String str) {
        aS("mFromLast", VH());
        return (SelfT) aS("mFrom", str);
    }

    public String VJ() {
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

    public String VK() {
        return getString("max_swan_version");
    }

    public String VL() {
        return getString("min_swan_version");
    }

    public Bundle VM() {
        return iK("mExtraData");
    }

    public SelfT E(Bundle bundle) {
        return (SelfT) c("mExtraData", bundle);
    }

    @NonNull
    public Bundle VN() {
        Bundle VM = VM();
        if (VM == null) {
            Bundle bundle = new Bundle();
            E(bundle);
            return bundle;
        }
        return VM;
    }

    public SelfT aR(String str, String str2) {
        if (str != null && str2 != null) {
            VN().putString(str, str2);
        }
        return (SelfT) VD();
    }

    public String VO() {
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

    public String VP() {
        return getString("notInHistory");
    }

    public SelfT iF(String str) {
        return (SelfT) aS("notInHistory", str);
    }

    public String VQ() {
        return getString("launch_app_open_url");
    }

    public String VR() {
        return getString("launch_app_download_url");
    }

    public String VS() {
        return getString("targetSwanVersion");
    }

    public SelfT iG(String str) {
        return (SelfT) aS("targetSwanVersion", str);
    }

    public SwanCoreVersion QO() {
        return (SwanCoreVersion) iL("swanCoreVersion");
    }

    public SelfT b(SwanCoreVersion swanCoreVersion) {
        return (SelfT) a("swanCoreVersion", swanCoreVersion);
    }

    public ExtensionCore QP() {
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

    public boolean VT() {
        return getBoolean("console_switch", false);
    }

    public SelfT cN(boolean z) {
        return (SelfT) w("console_switch", z);
    }

    public int VU() {
        return getInt("launchFlags", 0);
    }

    public SelfT fk(int i) {
        return (SelfT) A("launchFlags", i);
    }

    public SelfT fl(int i) {
        return fk(VU() | i);
    }

    public long VB() {
        return 0L;
    }

    public SelfT aj(long j) {
        return (SelfT) VD();
    }

    public long VV() {
        return getLong("last_start_timestamp");
    }

    public SelfT al(long j) {
        return (SelfT) j("last_start_timestamp", j);
    }

    public String VW() {
        return getString("remoteDebugUrl");
    }

    public SelfT iH(String str) {
        return (SelfT) aS("remoteDebugUrl", str);
    }

    public PMSAppInfo VX() {
        return (PMSAppInfo) iL("pms_db_info_onload");
    }

    public SelfT g(PMSAppInfo pMSAppInfo) {
        return (SelfT) a("pms_db_info_onload", pMSAppInfo);
    }

    public SelfT h(PMSAppInfo pMSAppInfo) {
        if (pMSAppInfo != null) {
            a("pms_db_info_updated", pMSAppInfo);
            if (!VY()) {
                g(pMSAppInfo);
            }
        }
        return (SelfT) VD();
    }

    public boolean VY() {
        return containsKey("pms_db_info_onload") && VX() != null;
    }

    public JSONObject VZ() {
        String VJ = VJ();
        if (this.byo != null && TextUtils.equals((CharSequence) this.byo.first, VJ)) {
            return (JSONObject) this.byo.second;
        }
        this.byo = null;
        if (TextUtils.isEmpty(VJ)) {
            this.byo = null;
            return null;
        }
        String queryParameter = Uri.parse(VJ).getQueryParameter("_baiduboxapp");
        if (!TextUtils.isEmpty(queryParameter)) {
            try {
                this.byo = new Pair<>(VJ, new JSONObject(queryParameter).optJSONObject("ext"));
            } catch (JSONException e) {
                if (DEBUG) {
                    e.printStackTrace();
                }
            }
        }
        if (this.byo == null) {
            return null;
        }
        return (JSONObject) this.byo.second;
    }

    public String Wa() {
        return getString("launch_id");
    }

    public boolean Wb() {
        return getBoolean("swan_app_independent", false);
    }

    public SelfT cO(boolean z) {
        return (SelfT) w("swan_app_independent", z);
    }

    public String Wc() {
        return getString("swan_app_sub_root_path");
    }

    public SelfT iI(String str) {
        return (SelfT) aS("swan_app_sub_root_path", str);
    }
}
