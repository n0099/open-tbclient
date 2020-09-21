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
/* loaded from: classes3.dex */
public abstract class e<SelfT extends e<SelfT>> extends com.baidu.swan.apps.u.c.a.c<SelfT> {
    protected static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private Pair<String, JSONObject> cxU;

    public boolean arv() {
        return getBoolean("cts_launch_mode", false);
    }

    public SelfT eC(boolean z) {
        T("cts_launch_mode", z);
        return (SelfT) art();
    }

    public String aly() {
        return getString("mAppTitle");
    }

    public SelfT nX(String str) {
        bJ("mAppTitle", str);
        return (SelfT) art();
    }

    public String getAppKey() {
        return getString("mAppKey");
    }

    public SelfT nW(String str) {
        bJ("mAppKey", str);
        return (SelfT) art();
    }

    public String getAppId() {
        return getString("mAppId", "");
    }

    public SelfT nV(String str) {
        bJ("mAppId", str);
        return (SelfT) art();
    }

    public String getIconUrl() {
        return getString("app_icon_url");
    }

    public SelfT nU(String str) {
        bJ("app_icon_url", str);
        return (SelfT) art();
    }

    public String arh() {
        return "";
    }

    public SelfT nT(String str) {
        return (SelfT) art();
    }

    public int ari() {
        return 0;
    }

    public String arj() {
        return "";
    }

    public String ark() {
        return "";
    }

    public String arl() {
        return "";
    }

    public String arm() {
        return "";
    }

    public SelfT nS(String str) {
        return (SelfT) art();
    }

    public String arn() {
        return "";
    }

    public SelfT nR(String str) {
        return (SelfT) art();
    }

    public SwanAppBearInfo aro() {
        return null;
    }

    public String arp() {
        return "";
    }

    public String getVersion() {
        return "";
    }

    public SelfT nQ(String str) {
        return (SelfT) art();
    }

    public String getVersionCode() {
        return "";
    }

    public int getType() {
        return 0;
    }

    public long arq() {
        return 0L;
    }

    public int getOrientation() {
        int i = getInt("appFrameOrientation", -1);
        if (-1 < i) {
            return i;
        }
        return -1;
    }

    public SelfT il(int i) {
        return (SelfT) O("appFrameOrientation", i);
    }

    public long arw() {
        return getLong("navigate_bar_color_key", 2147483648L);
    }

    public SelfT bf(long j) {
        if (2147483648L != j) {
            n("navigate_bar_color_key", j);
        }
        return (SelfT) art();
    }

    public String arx() {
        return getString("mFrom");
    }

    public String ary() {
        return getString("mFromLast");
    }

    public SelfT nY(String str) {
        bJ("mFromLast", arx());
        return (SelfT) bJ("mFrom", str);
    }

    public String arz() {
        return getString("launchScheme");
    }

    public SelfT nZ(String str) {
        return (SelfT) bJ("launchScheme", str);
    }

    public String getPage() {
        return getString("mPage");
    }

    public SelfT oa(String str) {
        return (SelfT) bJ("mPage", str);
    }

    public String arA() {
        return getString("max_swan_version");
    }

    public String arB() {
        return getString("min_swan_version");
    }

    public Bundle arC() {
        return oj("mExtraData");
    }

    public SelfT G(Bundle bundle) {
        return (SelfT) d("mExtraData", bundle);
    }

    @NonNull
    public Bundle arD() {
        Bundle arC = arC();
        if (arC == null) {
            Bundle bundle = new Bundle();
            G(bundle);
            return bundle;
        }
        return arC;
    }

    public SelfT bI(String str, String str2) {
        if (str != null && str2 != null) {
            arD().putString(str, str2);
        }
        return (SelfT) art();
    }

    public SelfT m(String str, long j) {
        arD().putLong(str, j);
        return (SelfT) art();
    }

    public String arE() {
        return getString("mClickId");
    }

    public SelfT ob(String str) {
        return (SelfT) bJ("mClickId", str);
    }

    public boolean isDebug() {
        return getBoolean("mIsDebug", false);
    }

    public SelfT eD(boolean z) {
        return (SelfT) T("mIsDebug", z);
    }

    public String arF() {
        return getString("notInHistory");
    }

    public SelfT oc(String str) {
        return (SelfT) bJ("notInHistory", str);
    }

    public String arG() {
        return getString("launch_app_open_url");
    }

    public String arH() {
        return getString("launch_app_download_url");
    }

    public String arI() {
        return getString("targetSwanVersion");
    }

    public SelfT od(String str) {
        return (SelfT) bJ("targetSwanVersion", str);
    }

    public SwanCoreVersion akX() {
        return (SwanCoreVersion) ok("swanCoreVersion");
    }

    public SelfT b(SwanCoreVersion swanCoreVersion) {
        return (SelfT) a("swanCoreVersion", swanCoreVersion);
    }

    public ExtensionCore akY() {
        return (ExtensionCore) ok("extensionCore");
    }

    public SelfT c(ExtensionCore extensionCore) {
        return (SelfT) a("extensionCore", extensionCore);
    }

    public int getAppFrameType() {
        return getInt("appFrameType");
    }

    public SelfT im(int i) {
        return (SelfT) O("appFrameType", i);
    }

    public boolean arJ() {
        return getBoolean("console_switch", false);
    }

    public SelfT eE(boolean z) {
        return (SelfT) T("console_switch", z);
    }

    public int arK() {
        return getInt("launchFlags", 0);
    }

    public SelfT in(int i) {
        return (SelfT) O("launchFlags", i);
    }

    public SelfT io(int i) {
        return in(arK() | i);
    }

    public long arr() {
        return 0L;
    }

    public SelfT be(long j) {
        return (SelfT) art();
    }

    public long arL() {
        return getLong("last_start_timestamp");
    }

    public SelfT bg(long j) {
        return (SelfT) n("last_start_timestamp", j);
    }

    public String arM() {
        return getString("remoteDebugUrl");
    }

    public SelfT oe(String str) {
        return (SelfT) bJ("remoteDebugUrl", str);
    }

    public PMSAppInfo arN() {
        return (PMSAppInfo) ok("pms_db_info_onload");
    }

    public SelfT k(PMSAppInfo pMSAppInfo) {
        return (SelfT) a("pms_db_info_onload", pMSAppInfo);
    }

    public SelfT l(PMSAppInfo pMSAppInfo) {
        if (pMSAppInfo != null) {
            a("pms_db_info_updated", pMSAppInfo);
            if (!arO()) {
                k(pMSAppInfo);
            }
        }
        return (SelfT) art();
    }

    public boolean arO() {
        return containsKey("pms_db_info_onload") && arN() != null;
    }

    public JSONObject arP() {
        String arz = arz();
        if (this.cxU != null && TextUtils.equals((CharSequence) this.cxU.first, arz)) {
            return (JSONObject) this.cxU.second;
        }
        this.cxU = null;
        if (TextUtils.isEmpty(arz)) {
            this.cxU = null;
            return null;
        }
        String queryParameter = Uri.parse(arz).getQueryParameter("_baiduboxapp");
        if (!TextUtils.isEmpty(queryParameter)) {
            try {
                this.cxU = new Pair<>(arz, new JSONObject(queryParameter).optJSONObject("ext"));
            } catch (JSONException e) {
                if (DEBUG) {
                    e.printStackTrace();
                }
            }
        }
        if (this.cxU == null) {
            return null;
        }
        return (JSONObject) this.cxU.second;
    }

    public String arQ() {
        return getString("launch_id");
    }

    public SelfT og(String str) {
        return (SelfT) bJ("launch_id", str);
    }

    public boolean arR() {
        return getBoolean("swan_app_independent", false);
    }

    public SelfT eF(boolean z) {
        return (SelfT) T("swan_app_independent", z);
    }

    public String arS() {
        return getString("swan_app_sub_root_path");
    }

    public SelfT oh(String str) {
        return (SelfT) bJ("swan_app_sub_root_path", str);
    }
}
