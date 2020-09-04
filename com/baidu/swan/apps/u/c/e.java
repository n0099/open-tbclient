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
/* loaded from: classes8.dex */
public abstract class e<SelfT extends e<SelfT>> extends com.baidu.swan.apps.u.c.a.c<SelfT> {
    protected static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private Pair<String, JSONObject> cvT;

    public boolean aqL() {
        return getBoolean("cts_launch_mode", false);
    }

    public SelfT eE(boolean z) {
        T("cts_launch_mode", z);
        return (SelfT) aqJ();
    }

    public String akO() {
        return getString("mAppTitle");
    }

    public SelfT nE(String str) {
        bJ("mAppTitle", str);
        return (SelfT) aqJ();
    }

    public String getAppKey() {
        return getString("mAppKey");
    }

    public SelfT nD(String str) {
        bJ("mAppKey", str);
        return (SelfT) aqJ();
    }

    public String getAppId() {
        return getString("mAppId", "");
    }

    public SelfT nC(String str) {
        bJ("mAppId", str);
        return (SelfT) aqJ();
    }

    public String getIconUrl() {
        return getString("app_icon_url");
    }

    public SelfT nB(String str) {
        bJ("app_icon_url", str);
        return (SelfT) aqJ();
    }

    public String aqx() {
        return "";
    }

    public SelfT nA(String str) {
        return (SelfT) aqJ();
    }

    public int aqy() {
        return 0;
    }

    public String aqz() {
        return "";
    }

    public String aqA() {
        return "";
    }

    public String aqB() {
        return "";
    }

    public String aqC() {
        return "";
    }

    public SelfT nz(String str) {
        return (SelfT) aqJ();
    }

    public String aqD() {
        return "";
    }

    public SelfT ny(String str) {
        return (SelfT) aqJ();
    }

    public SwanAppBearInfo aqE() {
        return null;
    }

    public String aqF() {
        return "";
    }

    public String getVersion() {
        return "";
    }

    public SelfT nx(String str) {
        return (SelfT) aqJ();
    }

    public String getVersionCode() {
        return "";
    }

    public int getType() {
        return 0;
    }

    public long aqG() {
        return 0L;
    }

    public int getOrientation() {
        int i = getInt("appFrameOrientation", -1);
        if (-1 < i) {
            return i;
        }
        return -1;
    }

    public SelfT ib(int i) {
        return (SelfT) O("appFrameOrientation", i);
    }

    public long aqM() {
        return getLong("navigate_bar_color_key", 2147483648L);
    }

    public SelfT be(long j) {
        if (2147483648L != j) {
            n("navigate_bar_color_key", j);
        }
        return (SelfT) aqJ();
    }

    public String aqN() {
        return getString("mFrom");
    }

    public String aqO() {
        return getString("mFromLast");
    }

    public SelfT nF(String str) {
        bJ("mFromLast", aqN());
        return (SelfT) bJ("mFrom", str);
    }

    public String aqP() {
        return getString("launchScheme");
    }

    public SelfT nG(String str) {
        return (SelfT) bJ("launchScheme", str);
    }

    public String getPage() {
        return getString("mPage");
    }

    public SelfT nH(String str) {
        return (SelfT) bJ("mPage", str);
    }

    public String aqQ() {
        return getString("max_swan_version");
    }

    public String aqR() {
        return getString("min_swan_version");
    }

    public Bundle aqS() {
        return nP("mExtraData");
    }

    public SelfT G(Bundle bundle) {
        return (SelfT) d("mExtraData", bundle);
    }

    @NonNull
    public Bundle aqT() {
        Bundle aqS = aqS();
        if (aqS == null) {
            Bundle bundle = new Bundle();
            G(bundle);
            return bundle;
        }
        return aqS;
    }

    public SelfT bI(String str, String str2) {
        if (str != null && str2 != null) {
            aqT().putString(str, str2);
        }
        return (SelfT) aqJ();
    }

    public SelfT m(String str, long j) {
        aqT().putLong(str, j);
        return (SelfT) aqJ();
    }

    public String aqU() {
        return getString("mClickId");
    }

    public SelfT nI(String str) {
        return (SelfT) bJ("mClickId", str);
    }

    public boolean isDebug() {
        return getBoolean("mIsDebug", false);
    }

    public SelfT eF(boolean z) {
        return (SelfT) T("mIsDebug", z);
    }

    public String aqV() {
        return getString("notInHistory");
    }

    public SelfT nJ(String str) {
        return (SelfT) bJ("notInHistory", str);
    }

    public String aqW() {
        return getString("launch_app_open_url");
    }

    public String aqX() {
        return getString("launch_app_download_url");
    }

    public String aqY() {
        return getString("targetSwanVersion");
    }

    public SelfT nK(String str) {
        return (SelfT) bJ("targetSwanVersion", str);
    }

    public SwanCoreVersion akn() {
        return (SwanCoreVersion) nQ("swanCoreVersion");
    }

    public SelfT b(SwanCoreVersion swanCoreVersion) {
        return (SelfT) a("swanCoreVersion", swanCoreVersion);
    }

    public ExtensionCore ako() {
        return (ExtensionCore) nQ("extensionCore");
    }

    public SelfT c(ExtensionCore extensionCore) {
        return (SelfT) a("extensionCore", extensionCore);
    }

    public int getAppFrameType() {
        return getInt("appFrameType");
    }

    public SelfT ic(int i) {
        return (SelfT) O("appFrameType", i);
    }

    public boolean aqZ() {
        return getBoolean("console_switch", false);
    }

    public SelfT eG(boolean z) {
        return (SelfT) T("console_switch", z);
    }

    public int ara() {
        return getInt("launchFlags", 0);
    }

    public SelfT id(int i) {
        return (SelfT) O("launchFlags", i);
    }

    public SelfT ie(int i) {
        return id(ara() | i);
    }

    public long aqH() {
        return 0L;
    }

    public SelfT bd(long j) {
        return (SelfT) aqJ();
    }

    public long arb() {
        return getLong("last_start_timestamp");
    }

    public SelfT bf(long j) {
        return (SelfT) n("last_start_timestamp", j);
    }

    public String arc() {
        return getString("remoteDebugUrl");
    }

    public SelfT nL(String str) {
        return (SelfT) bJ("remoteDebugUrl", str);
    }

    public PMSAppInfo ard() {
        return (PMSAppInfo) nQ("pms_db_info_onload");
    }

    public SelfT k(PMSAppInfo pMSAppInfo) {
        return (SelfT) a("pms_db_info_onload", pMSAppInfo);
    }

    public SelfT l(PMSAppInfo pMSAppInfo) {
        if (pMSAppInfo != null) {
            a("pms_db_info_updated", pMSAppInfo);
            if (!are()) {
                k(pMSAppInfo);
            }
        }
        return (SelfT) aqJ();
    }

    public boolean are() {
        return containsKey("pms_db_info_onload") && ard() != null;
    }

    public JSONObject arf() {
        String aqP = aqP();
        if (this.cvT != null && TextUtils.equals((CharSequence) this.cvT.first, aqP)) {
            return (JSONObject) this.cvT.second;
        }
        this.cvT = null;
        if (TextUtils.isEmpty(aqP)) {
            this.cvT = null;
            return null;
        }
        String queryParameter = Uri.parse(aqP).getQueryParameter("_baiduboxapp");
        if (!TextUtils.isEmpty(queryParameter)) {
            try {
                this.cvT = new Pair<>(aqP, new JSONObject(queryParameter).optJSONObject("ext"));
            } catch (JSONException e) {
                if (DEBUG) {
                    e.printStackTrace();
                }
            }
        }
        if (this.cvT == null) {
            return null;
        }
        return (JSONObject) this.cvT.second;
    }

    public String arg() {
        return getString("launch_id");
    }

    public SelfT nM(String str) {
        return (SelfT) bJ("launch_id", str);
    }

    public boolean arh() {
        return getBoolean("swan_app_independent", false);
    }

    public SelfT eH(boolean z) {
        return (SelfT) T("swan_app_independent", z);
    }

    public String ari() {
        return getString("swan_app_sub_root_path");
    }

    public SelfT nN(String str) {
        return (SelfT) bJ("swan_app_sub_root_path", str);
    }
}
