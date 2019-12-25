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
/* loaded from: classes9.dex */
public abstract class e<SelfT extends e<SelfT>> extends com.baidu.swan.apps.x.b.a.c<SelfT> {
    protected static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private Pair<String, JSONObject> btq;

    public boolean SU() {
        return getBoolean("cts_launch_mode", false);
    }

    public SelfT cz(boolean z) {
        w("cts_launch_mode", z);
        return (SelfT) SS();
    }

    public String Op() {
        return getString("mAppTitle");
    }

    public SelfT ii(String str) {
        aH("mAppTitle", str);
        return (SelfT) SS();
    }

    public String getAppKey() {
        return getString("mAppKey");
    }

    public SelfT ih(String str) {
        aH("mAppKey", str);
        return (SelfT) SS();
    }

    public String getAppId() {
        return getString("mAppId", "");
    }

    public SelfT ig(String str) {
        aH("mAppId", str);
        return (SelfT) SS();
    }

    public String getIconUrl() {
        return getString("app_icon_url");
    }

    /* renamed from: if */
    public SelfT mo20if(String str) {
        aH("app_icon_url", str);
        return (SelfT) SS();
    }

    public String SH() {
        return "";
    }

    public SelfT ie(String str) {
        return (SelfT) SS();
    }

    public int SI() {
        return 0;
    }

    public String SJ() {
        return "";
    }

    public String SK() {
        return "";
    }

    public String SL() {
        return "";
    }

    public String SM() {
        return "";
    }

    public SelfT ic(String str) {
        return (SelfT) SS();
    }

    public String SN() {
        return "";
    }

    public SelfT ib(String str) {
        return (SelfT) SS();
    }

    public SwanAppBearInfo SO() {
        return null;
    }

    public String getVersion() {
        return "";
    }

    public SelfT ia(String str) {
        return (SelfT) SS();
    }

    public String getVersionCode() {
        return "";
    }

    public int getType() {
        return 0;
    }

    public long SP() {
        return 0L;
    }

    public int getOrientation() {
        int i = getInt("appFrameOrientation", -1);
        if (-1 < i) {
            return i;
        }
        return -1;
    }

    public SelfT eR(int i) {
        return (SelfT) C("appFrameOrientation", i);
    }

    public long SV() {
        return getLong("navigate_bar_color_key", IjkMediaMeta.AV_CH_WIDE_LEFT);
    }

    public SelfT ad(long j) {
        if (IjkMediaMeta.AV_CH_WIDE_LEFT != j) {
            j("navigate_bar_color_key", j);
        }
        return (SelfT) SS();
    }

    public String SW() {
        return getString("mFrom");
    }

    public String SX() {
        return getString("mFromLast");
    }

    public SelfT ij(String str) {
        aH("mFromLast", SW());
        return (SelfT) aH("mFrom", str);
    }

    public String SY() {
        return getString("launchScheme");
    }

    public SelfT ik(String str) {
        return (SelfT) aH("launchScheme", str);
    }

    public String getPage() {
        return getString("mPage");
    }

    public SelfT il(String str) {
        return (SelfT) aH("mPage", str);
    }

    public String SZ() {
        return getString("max_swan_version");
    }

    public String Ta() {
        return getString("min_swan_version");
    }

    public Bundle Tb() {
        return is("mExtraData");
    }

    public SelfT E(Bundle bundle) {
        return (SelfT) c("mExtraData", bundle);
    }

    @NonNull
    public Bundle Tc() {
        Bundle Tb = Tb();
        if (Tb == null) {
            Bundle bundle = new Bundle();
            E(bundle);
            return bundle;
        }
        return Tb;
    }

    public SelfT aG(String str, String str2) {
        if (str != null && str2 != null) {
            Tc().putString(str, str2);
        }
        return (SelfT) SS();
    }

    public String Td() {
        return getString("mClickId");
    }

    public SelfT im(String str) {
        return (SelfT) aH("mClickId", str);
    }

    public boolean isDebug() {
        return getBoolean("mIsDebug", false);
    }

    public SelfT cA(boolean z) {
        return (SelfT) w("mIsDebug", z);
    }

    public String Te() {
        return getString("notInHistory");
    }

    public SelfT in(String str) {
        return (SelfT) aH("notInHistory", str);
    }

    public String Tf() {
        return getString("launch_app_open_url");
    }

    public String Tg() {
        return getString("launch_app_download_url");
    }

    public String Th() {
        return getString("targetSwanVersion");
    }

    public SelfT io(String str) {
        return (SelfT) aH("targetSwanVersion", str);
    }

    public SwanCoreVersion Oe() {
        return (SwanCoreVersion) it("swanCoreVersion");
    }

    public SelfT b(SwanCoreVersion swanCoreVersion) {
        return (SelfT) a("swanCoreVersion", swanCoreVersion);
    }

    public ExtensionCore Of() {
        return (ExtensionCore) it("extensionCore");
    }

    public SelfT c(ExtensionCore extensionCore) {
        return (SelfT) a("extensionCore", extensionCore);
    }

    public int getAppFrameType() {
        return getInt("appFrameType");
    }

    public SelfT eS(int i) {
        return (SelfT) C("appFrameType", i);
    }

    public boolean Ti() {
        return getBoolean("console_switch", false);
    }

    public SelfT cB(boolean z) {
        return (SelfT) w("console_switch", z);
    }

    public int Tj() {
        return getInt("launchFlags", 0);
    }

    public SelfT eT(int i) {
        return (SelfT) C("launchFlags", i);
    }

    public SelfT eU(int i) {
        return eT(Tj() | i);
    }

    public long SQ() {
        return 0L;
    }

    public SelfT ac(long j) {
        return (SelfT) SS();
    }

    public long Tk() {
        return getLong("last_start_timestamp");
    }

    public SelfT ae(long j) {
        return (SelfT) j("last_start_timestamp", j);
    }

    public String Tl() {
        return getString("remoteDebugUrl");
    }

    public SelfT ip(String str) {
        return (SelfT) aH("remoteDebugUrl", str);
    }

    public PMSAppInfo Tm() {
        return (PMSAppInfo) it("pms_db_info_onload");
    }

    public SelfT g(PMSAppInfo pMSAppInfo) {
        return (SelfT) a("pms_db_info_onload", pMSAppInfo);
    }

    public SelfT h(PMSAppInfo pMSAppInfo) {
        if (pMSAppInfo != null) {
            a("pms_db_info_updated", pMSAppInfo);
            if (!Tn()) {
                g(pMSAppInfo);
            }
        }
        return (SelfT) SS();
    }

    public boolean Tn() {
        return containsKey("pms_db_info_onload") && Tm() != null;
    }

    public JSONObject To() {
        String SY = SY();
        if (this.btq != null && TextUtils.equals((CharSequence) this.btq.first, SY)) {
            return (JSONObject) this.btq.second;
        }
        this.btq = null;
        if (TextUtils.isEmpty(SY)) {
            this.btq = null;
            return null;
        }
        String queryParameter = Uri.parse(SY).getQueryParameter("_baiduboxapp");
        if (!TextUtils.isEmpty(queryParameter)) {
            try {
                this.btq = new Pair<>(SY, new JSONObject(queryParameter).optJSONObject("ext"));
            } catch (JSONException e) {
                if (DEBUG) {
                    e.printStackTrace();
                }
            }
        }
        if (this.btq == null) {
            return null;
        }
        return (JSONObject) this.btq.second;
    }

    public String Tp() {
        return getString("launch_id");
    }

    public boolean Tq() {
        return getBoolean("swan_app_independent", false);
    }

    public SelfT cC(boolean z) {
        return (SelfT) w("swan_app_independent", z);
    }

    public String Tr() {
        return getString("swan_app_sub_root_path");
    }

    public SelfT iq(String str) {
        return (SelfT) aH("swan_app_sub_root_path", str);
    }
}
