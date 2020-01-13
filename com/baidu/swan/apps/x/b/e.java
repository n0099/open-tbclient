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
/* loaded from: classes10.dex */
public abstract class e<SelfT extends e<SelfT>> extends com.baidu.swan.apps.x.b.a.c<SelfT> {
    protected static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private Pair<String, JSONObject> bue;

    public boolean Tr() {
        return getBoolean("cts_launch_mode", false);
    }

    public SelfT cE(boolean z) {
        w("cts_launch_mode", z);
        return (SelfT) Tp();
    }

    public String OL() {
        return getString("mAppTitle");
    }

    public SelfT il(String str) {
        aI("mAppTitle", str);
        return (SelfT) Tp();
    }

    public String getAppKey() {
        return getString("mAppKey");
    }

    public SelfT ik(String str) {
        aI("mAppKey", str);
        return (SelfT) Tp();
    }

    public String getAppId() {
        return getString("mAppId", "");
    }

    public SelfT ij(String str) {
        aI("mAppId", str);
        return (SelfT) Tp();
    }

    public String getIconUrl() {
        return getString("app_icon_url");
    }

    public SelfT ii(String str) {
        aI("app_icon_url", str);
        return (SelfT) Tp();
    }

    public String Te() {
        return "";
    }

    public SelfT ih(String str) {
        return (SelfT) Tp();
    }

    public int Tf() {
        return 0;
    }

    public String Tg() {
        return "";
    }

    public String Th() {
        return "";
    }

    public String Ti() {
        return "";
    }

    public String Tj() {
        return "";
    }

    public SelfT ig(String str) {
        return (SelfT) Tp();
    }

    public String Tk() {
        return "";
    }

    /* renamed from: if */
    public SelfT mo23if(String str) {
        return (SelfT) Tp();
    }

    public SwanAppBearInfo Tl() {
        return null;
    }

    public String getVersion() {
        return "";
    }

    public SelfT ie(String str) {
        return (SelfT) Tp();
    }

    public String getVersionCode() {
        return "";
    }

    public int getType() {
        return 0;
    }

    public long Tm() {
        return 0L;
    }

    public int getOrientation() {
        int i = getInt("appFrameOrientation", -1);
        if (-1 < i) {
            return i;
        }
        return -1;
    }

    public SelfT eS(int i) {
        return (SelfT) C("appFrameOrientation", i);
    }

    public long Ts() {
        return getLong("navigate_bar_color_key", IjkMediaMeta.AV_CH_WIDE_LEFT);
    }

    public SelfT ag(long j) {
        if (IjkMediaMeta.AV_CH_WIDE_LEFT != j) {
            j("navigate_bar_color_key", j);
        }
        return (SelfT) Tp();
    }

    public String Tt() {
        return getString("mFrom");
    }

    public String Tu() {
        return getString("mFromLast");
    }

    public SelfT im(String str) {
        aI("mFromLast", Tt());
        return (SelfT) aI("mFrom", str);
    }

    public String Tv() {
        return getString("launchScheme");
    }

    public SelfT in(String str) {
        return (SelfT) aI("launchScheme", str);
    }

    public String getPage() {
        return getString("mPage");
    }

    public SelfT io(String str) {
        return (SelfT) aI("mPage", str);
    }

    public String Tw() {
        return getString("max_swan_version");
    }

    public String Tx() {
        return getString("min_swan_version");
    }

    public Bundle Ty() {
        return iv("mExtraData");
    }

    public SelfT E(Bundle bundle) {
        return (SelfT) c("mExtraData", bundle);
    }

    @NonNull
    public Bundle Tz() {
        Bundle Ty = Ty();
        if (Ty == null) {
            Bundle bundle = new Bundle();
            E(bundle);
            return bundle;
        }
        return Ty;
    }

    public SelfT aH(String str, String str2) {
        if (str != null && str2 != null) {
            Tz().putString(str, str2);
        }
        return (SelfT) Tp();
    }

    public String TA() {
        return getString("mClickId");
    }

    public SelfT ip(String str) {
        return (SelfT) aI("mClickId", str);
    }

    public boolean isDebug() {
        return getBoolean("mIsDebug", false);
    }

    public SelfT cF(boolean z) {
        return (SelfT) w("mIsDebug", z);
    }

    public String TB() {
        return getString("notInHistory");
    }

    public SelfT iq(String str) {
        return (SelfT) aI("notInHistory", str);
    }

    public String TC() {
        return getString("launch_app_open_url");
    }

    public String TD() {
        return getString("launch_app_download_url");
    }

    public String TE() {
        return getString("targetSwanVersion");
    }

    public SelfT ir(String str) {
        return (SelfT) aI("targetSwanVersion", str);
    }

    public SwanCoreVersion OA() {
        return (SwanCoreVersion) iw("swanCoreVersion");
    }

    public SelfT b(SwanCoreVersion swanCoreVersion) {
        return (SelfT) a("swanCoreVersion", swanCoreVersion);
    }

    public ExtensionCore OB() {
        return (ExtensionCore) iw("extensionCore");
    }

    public SelfT c(ExtensionCore extensionCore) {
        return (SelfT) a("extensionCore", extensionCore);
    }

    public int getAppFrameType() {
        return getInt("appFrameType");
    }

    public SelfT eT(int i) {
        return (SelfT) C("appFrameType", i);
    }

    public boolean TF() {
        return getBoolean("console_switch", false);
    }

    public SelfT cG(boolean z) {
        return (SelfT) w("console_switch", z);
    }

    public int TG() {
        return getInt("launchFlags", 0);
    }

    public SelfT eU(int i) {
        return (SelfT) C("launchFlags", i);
    }

    public SelfT eV(int i) {
        return eU(TG() | i);
    }

    public long Tn() {
        return 0L;
    }

    public SelfT af(long j) {
        return (SelfT) Tp();
    }

    public long TH() {
        return getLong("last_start_timestamp");
    }

    public SelfT ah(long j) {
        return (SelfT) j("last_start_timestamp", j);
    }

    public String TI() {
        return getString("remoteDebugUrl");
    }

    public SelfT is(String str) {
        return (SelfT) aI("remoteDebugUrl", str);
    }

    public PMSAppInfo TJ() {
        return (PMSAppInfo) iw("pms_db_info_onload");
    }

    public SelfT g(PMSAppInfo pMSAppInfo) {
        return (SelfT) a("pms_db_info_onload", pMSAppInfo);
    }

    public SelfT h(PMSAppInfo pMSAppInfo) {
        if (pMSAppInfo != null) {
            a("pms_db_info_updated", pMSAppInfo);
            if (!TK()) {
                g(pMSAppInfo);
            }
        }
        return (SelfT) Tp();
    }

    public boolean TK() {
        return containsKey("pms_db_info_onload") && TJ() != null;
    }

    public JSONObject TL() {
        String Tv = Tv();
        if (this.bue != null && TextUtils.equals((CharSequence) this.bue.first, Tv)) {
            return (JSONObject) this.bue.second;
        }
        this.bue = null;
        if (TextUtils.isEmpty(Tv)) {
            this.bue = null;
            return null;
        }
        String queryParameter = Uri.parse(Tv).getQueryParameter("_baiduboxapp");
        if (!TextUtils.isEmpty(queryParameter)) {
            try {
                this.bue = new Pair<>(Tv, new JSONObject(queryParameter).optJSONObject("ext"));
            } catch (JSONException e) {
                if (DEBUG) {
                    e.printStackTrace();
                }
            }
        }
        if (this.bue == null) {
            return null;
        }
        return (JSONObject) this.bue.second;
    }

    public String TM() {
        return getString("launch_id");
    }

    public boolean TN() {
        return getBoolean("swan_app_independent", false);
    }

    public SelfT cH(boolean z) {
        return (SelfT) w("swan_app_independent", z);
    }

    public String TO() {
        return getString("swan_app_sub_root_path");
    }

    public SelfT it(String str) {
        return (SelfT) aI("swan_app_sub_root_path", str);
    }
}
