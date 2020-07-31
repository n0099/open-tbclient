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
/* loaded from: classes7.dex */
public abstract class e<SelfT extends e<SelfT>> extends com.baidu.swan.apps.u.c.a.c<SelfT> {
    protected static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private Pair<String, JSONObject> coh;

    public boolean aje() {
        return getBoolean("cts_launch_mode", false);
    }

    public SelfT el(boolean z) {
        O("cts_launch_mode", z);
        return (SelfT) ajc();
    }

    public String aee() {
        return getString("mAppTitle");
    }

    public SelfT lG(String str) {
        bw("mAppTitle", str);
        return (SelfT) ajc();
    }

    public String getAppKey() {
        return getString("mAppKey");
    }

    public SelfT lF(String str) {
        bw("mAppKey", str);
        return (SelfT) ajc();
    }

    public String getAppId() {
        return getString("mAppId", "");
    }

    public SelfT lE(String str) {
        bw("mAppId", str);
        return (SelfT) ajc();
    }

    public String getIconUrl() {
        return getString("app_icon_url");
    }

    public SelfT lD(String str) {
        bw("app_icon_url", str);
        return (SelfT) ajc();
    }

    public String aiR() {
        return "";
    }

    public SelfT lC(String str) {
        return (SelfT) ajc();
    }

    public int aiS() {
        return 0;
    }

    public String aiT() {
        return "";
    }

    public String aiU() {
        return "";
    }

    public String aiV() {
        return "";
    }

    public String aiW() {
        return "";
    }

    public SelfT lB(String str) {
        return (SelfT) ajc();
    }

    public String aiX() {
        return "";
    }

    public SelfT lA(String str) {
        return (SelfT) ajc();
    }

    public SwanAppBearInfo aiY() {
        return null;
    }

    public String getVersion() {
        return "";
    }

    public SelfT lz(String str) {
        return (SelfT) ajc();
    }

    public String getVersionCode() {
        return "";
    }

    public int getType() {
        return 0;
    }

    public long aiZ() {
        return 0L;
    }

    public int getOrientation() {
        int i = getInt("appFrameOrientation", -1);
        if (-1 < i) {
            return i;
        }
        return -1;
    }

    public SelfT fX(int i) {
        return (SelfT) M("appFrameOrientation", i);
    }

    public long ajf() {
        return getLong("navigate_bar_color_key", 2147483648L);
    }

    public SelfT aZ(long j) {
        if (2147483648L != j) {
            k("navigate_bar_color_key", j);
        }
        return (SelfT) ajc();
    }

    public String ajg() {
        return getString("mFrom");
    }

    public String ajh() {
        return getString("mFromLast");
    }

    public SelfT lH(String str) {
        bw("mFromLast", ajg());
        return (SelfT) bw("mFrom", str);
    }

    public String aji() {
        return getString("launchScheme");
    }

    public SelfT lI(String str) {
        return (SelfT) bw("launchScheme", str);
    }

    public String getPage() {
        return getString("mPage");
    }

    public SelfT lJ(String str) {
        return (SelfT) bw("mPage", str);
    }

    public String ajj() {
        return getString("max_swan_version");
    }

    public String ajk() {
        return getString("min_swan_version");
    }

    public Bundle ajl() {
        return lR("mExtraData");
    }

    public SelfT I(Bundle bundle) {
        return (SelfT) e("mExtraData", bundle);
    }

    @NonNull
    public Bundle ajm() {
        Bundle ajl = ajl();
        if (ajl == null) {
            Bundle bundle = new Bundle();
            I(bundle);
            return bundle;
        }
        return ajl;
    }

    public SelfT bv(String str, String str2) {
        if (str != null && str2 != null) {
            ajm().putString(str, str2);
        }
        return (SelfT) ajc();
    }

    public SelfT j(String str, long j) {
        ajm().putLong(str, j);
        return (SelfT) ajc();
    }

    public String ajn() {
        return getString("mClickId");
    }

    public SelfT lK(String str) {
        return (SelfT) bw("mClickId", str);
    }

    public boolean isDebug() {
        return getBoolean("mIsDebug", false);
    }

    public SelfT em(boolean z) {
        return (SelfT) O("mIsDebug", z);
    }

    public String ajo() {
        return getString("notInHistory");
    }

    public SelfT lL(String str) {
        return (SelfT) bw("notInHistory", str);
    }

    public String ajp() {
        return getString("launch_app_open_url");
    }

    public String ajq() {
        return getString("launch_app_download_url");
    }

    public String ajr() {
        return getString("targetSwanVersion");
    }

    public SelfT lM(String str) {
        return (SelfT) bw("targetSwanVersion", str);
    }

    public SwanCoreVersion adQ() {
        return (SwanCoreVersion) lS("swanCoreVersion");
    }

    public SelfT b(SwanCoreVersion swanCoreVersion) {
        return (SelfT) a("swanCoreVersion", swanCoreVersion);
    }

    public ExtensionCore adR() {
        return (ExtensionCore) lS("extensionCore");
    }

    public SelfT c(ExtensionCore extensionCore) {
        return (SelfT) a("extensionCore", extensionCore);
    }

    public int getAppFrameType() {
        return getInt("appFrameType");
    }

    public SelfT fY(int i) {
        return (SelfT) M("appFrameType", i);
    }

    public boolean ajs() {
        return getBoolean("console_switch", false);
    }

    public SelfT en(boolean z) {
        return (SelfT) O("console_switch", z);
    }

    public int ajt() {
        return getInt("launchFlags", 0);
    }

    public SelfT fZ(int i) {
        return (SelfT) M("launchFlags", i);
    }

    public SelfT ga(int i) {
        return fZ(ajt() | i);
    }

    public long aja() {
        return 0L;
    }

    public SelfT aY(long j) {
        return (SelfT) ajc();
    }

    public long aju() {
        return getLong("last_start_timestamp");
    }

    public SelfT ba(long j) {
        return (SelfT) k("last_start_timestamp", j);
    }

    public String ajv() {
        return getString("remoteDebugUrl");
    }

    public SelfT lN(String str) {
        return (SelfT) bw("remoteDebugUrl", str);
    }

    public PMSAppInfo ajw() {
        return (PMSAppInfo) lS("pms_db_info_onload");
    }

    public SelfT k(PMSAppInfo pMSAppInfo) {
        return (SelfT) a("pms_db_info_onload", pMSAppInfo);
    }

    public SelfT l(PMSAppInfo pMSAppInfo) {
        if (pMSAppInfo != null) {
            a("pms_db_info_updated", pMSAppInfo);
            if (!ajx()) {
                k(pMSAppInfo);
            }
        }
        return (SelfT) ajc();
    }

    public boolean ajx() {
        return containsKey("pms_db_info_onload") && ajw() != null;
    }

    public JSONObject ajy() {
        String aji = aji();
        if (this.coh != null && TextUtils.equals((CharSequence) this.coh.first, aji)) {
            return (JSONObject) this.coh.second;
        }
        this.coh = null;
        if (TextUtils.isEmpty(aji)) {
            this.coh = null;
            return null;
        }
        String queryParameter = Uri.parse(aji).getQueryParameter("_baiduboxapp");
        if (!TextUtils.isEmpty(queryParameter)) {
            try {
                this.coh = new Pair<>(aji, new JSONObject(queryParameter).optJSONObject("ext"));
            } catch (JSONException e) {
                if (DEBUG) {
                    e.printStackTrace();
                }
            }
        }
        if (this.coh == null) {
            return null;
        }
        return (JSONObject) this.coh.second;
    }

    public String ajz() {
        return getString("launch_id");
    }

    public SelfT lO(String str) {
        return (SelfT) bw("launch_id", str);
    }

    public boolean ajA() {
        return getBoolean("swan_app_independent", false);
    }

    public SelfT eo(boolean z) {
        return (SelfT) O("swan_app_independent", z);
    }

    public String ajB() {
        return getString("swan_app_sub_root_path");
    }

    public SelfT lP(String str) {
        return (SelfT) bw("swan_app_sub_root_path", str);
    }
}
