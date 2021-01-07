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
/* loaded from: classes9.dex */
public abstract class e<SelfT extends e<SelfT>> extends com.baidu.swan.apps.u.c.a.c<SelfT> {
    protected static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private Pair<String, JSONObject> dix;

    public boolean aCu() {
        return getBoolean("cts_launch_mode", false);
    }

    public SelfT fV(boolean z) {
        aa("cts_launch_mode", z);
        return (SelfT) aCs();
    }

    public String awy() {
        return getString("mAppTitle");
    }

    public SelfT pM(String str) {
        ca("mAppTitle", str);
        return (SelfT) aCs();
    }

    public String getAppKey() {
        return getString("mAppKey");
    }

    public SelfT pL(String str) {
        ca("mAppKey", str);
        return (SelfT) aCs();
    }

    public String getAppId() {
        return getString("mAppId", "");
    }

    public SelfT pK(String str) {
        ca("mAppId", str);
        return (SelfT) aCs();
    }

    public String getIconUrl() {
        return getString("app_icon_url");
    }

    public SelfT pJ(String str) {
        ca("app_icon_url", str);
        return (SelfT) aCs();
    }

    public String aCg() {
        return "";
    }

    public SelfT pI(String str) {
        return (SelfT) aCs();
    }

    public int aCh() {
        return 0;
    }

    public String aCi() {
        return "";
    }

    public String aCj() {
        return "";
    }

    public String aCk() {
        return "";
    }

    public String aCl() {
        return "";
    }

    public SelfT pH(String str) {
        return (SelfT) aCs();
    }

    public String aCm() {
        return "";
    }

    public SelfT pG(String str) {
        return (SelfT) aCs();
    }

    public SwanAppBearInfo aCn() {
        return null;
    }

    public String aCo() {
        return "";
    }

    public String getVersion() {
        return "";
    }

    public SelfT pF(String str) {
        return (SelfT) aCs();
    }

    public String getVersionCode() {
        return "";
    }

    public int getType() {
        return 0;
    }

    public long aCp() {
        return 0L;
    }

    public int getOrientation() {
        int i = getInt("appFrameOrientation", -1);
        if (-1 < i) {
            return i;
        }
        return -1;
    }

    public SelfT js(int i) {
        return (SelfT) U("appFrameOrientation", i);
    }

    public long aCv() {
        return getLong("navigate_bar_color_key", KsMediaMeta.AV_CH_WIDE_LEFT);
    }

    public SelfT cl(long j) {
        if (KsMediaMeta.AV_CH_WIDE_LEFT != j) {
            p("navigate_bar_color_key", j);
        }
        return (SelfT) aCs();
    }

    public String aCw() {
        return getString("mFrom");
    }

    public String aCx() {
        return getString("mFromLast");
    }

    public SelfT pN(String str) {
        ca("mFromLast", aCw());
        return (SelfT) ca("mFrom", str);
    }

    public String aCy() {
        return getString("launchScheme");
    }

    public SelfT pO(String str) {
        return (SelfT) ca("launchScheme", str);
    }

    public String getPage() {
        return getString("mPage");
    }

    public SelfT pP(String str) {
        return (SelfT) ca("mPage", str);
    }

    public String aCz() {
        return getString("max_swan_version");
    }

    public String aCA() {
        return getString("min_swan_version");
    }

    public Bundle aCB() {
        return pX("mExtraData");
    }

    public SelfT G(Bundle bundle) {
        return (SelfT) d("mExtraData", bundle);
    }

    @NonNull
    public Bundle aCC() {
        Bundle aCB = aCB();
        if (aCB == null) {
            Bundle bundle = new Bundle();
            G(bundle);
            return bundle;
        }
        return aCB;
    }

    public SelfT bZ(String str, String str2) {
        if (str != null && str2 != null) {
            aCC().putString(str, str2);
        }
        return (SelfT) aCs();
    }

    public SelfT o(String str, long j) {
        aCC().putLong(str, j);
        return (SelfT) aCs();
    }

    public String aCD() {
        return getString("mClickId");
    }

    public SelfT pQ(String str) {
        return (SelfT) ca("mClickId", str);
    }

    public boolean isDebug() {
        return getBoolean("mIsDebug", false);
    }

    public SelfT fW(boolean z) {
        return (SelfT) aa("mIsDebug", z);
    }

    public String aCE() {
        return getString("notInHistory");
    }

    public SelfT pR(String str) {
        return (SelfT) ca("notInHistory", str);
    }

    public String aCF() {
        return getString("launch_app_open_url");
    }

    public String aCG() {
        return getString("launch_app_download_url");
    }

    public String aCH() {
        return getString("targetSwanVersion");
    }

    public SelfT pS(String str) {
        return (SelfT) ca("targetSwanVersion", str);
    }

    public SwanCoreVersion avW() {
        return (SwanCoreVersion) pY("swanCoreVersion");
    }

    public SelfT b(SwanCoreVersion swanCoreVersion) {
        return (SelfT) a("swanCoreVersion", swanCoreVersion);
    }

    public ExtensionCore avX() {
        return (ExtensionCore) pY("extensionCore");
    }

    public SelfT c(ExtensionCore extensionCore) {
        return (SelfT) a("extensionCore", extensionCore);
    }

    public int getAppFrameType() {
        return getInt("appFrameType");
    }

    public SelfT jt(int i) {
        return (SelfT) U("appFrameType", i);
    }

    public boolean aCI() {
        return getBoolean("console_switch", false);
    }

    public SelfT fX(boolean z) {
        return (SelfT) aa("console_switch", z);
    }

    public int aCJ() {
        return getInt("launchFlags", 0);
    }

    public SelfT ju(int i) {
        return (SelfT) U("launchFlags", i);
    }

    public SelfT jv(int i) {
        return ju(aCJ() | i);
    }

    public long aCq() {
        return 0L;
    }

    public SelfT ck(long j) {
        return (SelfT) aCs();
    }

    public long aCK() {
        return getLong("last_start_timestamp");
    }

    public SelfT cm(long j) {
        return (SelfT) p("last_start_timestamp", j);
    }

    public String aCL() {
        return getString("remoteDebugUrl");
    }

    public SelfT pT(String str) {
        return (SelfT) ca("remoteDebugUrl", str);
    }

    public PMSAppInfo aCM() {
        return (PMSAppInfo) pY("pms_db_info_onload");
    }

    public SelfT k(PMSAppInfo pMSAppInfo) {
        return (SelfT) a("pms_db_info_onload", pMSAppInfo);
    }

    public SelfT l(PMSAppInfo pMSAppInfo) {
        if (pMSAppInfo != null) {
            a("pms_db_info_updated", pMSAppInfo);
            if (!aCN()) {
                k(pMSAppInfo);
            }
        }
        return (SelfT) aCs();
    }

    public boolean aCN() {
        return containsKey("pms_db_info_onload") && aCM() != null;
    }

    public JSONObject aCO() {
        String aCy = aCy();
        if (this.dix != null && TextUtils.equals((CharSequence) this.dix.first, aCy)) {
            return (JSONObject) this.dix.second;
        }
        this.dix = null;
        if (TextUtils.isEmpty(aCy)) {
            this.dix = null;
            return null;
        }
        String queryParameter = Uri.parse(aCy).getQueryParameter("_baiduboxapp");
        if (!TextUtils.isEmpty(queryParameter)) {
            try {
                this.dix = new Pair<>(aCy, new JSONObject(queryParameter).optJSONObject("ext"));
            } catch (JSONException e) {
                if (DEBUG) {
                    e.printStackTrace();
                }
            }
        }
        if (this.dix == null) {
            return null;
        }
        return (JSONObject) this.dix.second;
    }

    public String aCP() {
        return getString("launch_id");
    }

    public SelfT pU(String str) {
        return (SelfT) ca("launch_id", str);
    }

    public boolean aCQ() {
        return getBoolean("swan_app_independent", false);
    }

    public SelfT fY(boolean z) {
        return (SelfT) aa("swan_app_independent", z);
    }

    public String aCR() {
        return getString("swan_app_sub_root_path");
    }

    public SelfT pV(String str) {
        return (SelfT) ca("swan_app_sub_root_path", str);
    }
}
