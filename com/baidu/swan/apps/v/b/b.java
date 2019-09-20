package com.baidu.swan.apps.v.b;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.baidu.swan.apps.SwanAppLauncherActivity;
import com.baidu.swan.apps.an.aa;
import com.baidu.swan.apps.an.n;
import com.baidu.swan.apps.extcore.model.ExtensionCore;
import com.baidu.swan.apps.model.SwanAppBearInfo;
import com.baidu.swan.apps.swancore.model.SwanCoreVersion;
import com.baidu.swan.pms.model.PMSAppInfo;
import java.io.File;
import org.json.JSONException;
import org.json.JSONObject;
import tv.danmaku.ijk.media.player.IjkMediaMeta;
/* loaded from: classes2.dex */
public final class b {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private int avK = 0;
    private String avr;
    private String avs;
    private String avx;
    private String avy;
    private String avz;
    private long azA;
    private String azB;
    private String azC;
    private Bundle azD;
    private String azE;
    private boolean azF;
    private String azG;
    private SwanCoreVersion azH;
    private ExtensionCore azI;
    private boolean azJ;
    private int azK;
    private long azL;
    private long azM;
    private String azN;
    private PMSAppInfo azO;
    private JSONObject azP;
    private String page;

    public static b F(Intent intent) {
        if (intent == null) {
            throw new IllegalArgumentException("intent must not be null.");
        }
        b bVar = new b();
        bVar.e((PMSAppInfo) n.d(intent, "swan_pms_db_info"));
        bVar.F(n.a(intent, "aiapps_navigatebar_color", (long) IjkMediaMeta.AV_CH_WIDE_LEFT));
        if (d.H(intent)) {
            bVar.eO("1250000000000000");
        } else {
            bVar.eO(n.b(intent, "aiapps_launch_from"));
        }
        bVar.eP(n.b(intent, "aiapps_launch_scheme"));
        if (bVar.FL() != null) {
            String queryParameter = Uri.parse(bVar.FL()).getQueryParameter("_baiduboxapp");
            if (!TextUtils.isEmpty(queryParameter)) {
                try {
                    bVar.E(new JSONObject(queryParameter).optJSONObject("ext"));
                } catch (JSONException e) {
                    if (DEBUG) {
                        e.printStackTrace();
                    }
                }
            }
        }
        bVar.setPage(n.b(intent, "aiapps_page"));
        bVar.setDebug(n.a(intent, "aiapps_is_debug", true));
        bVar.eQ(n.b(intent, "aiapps_max_swan_version"));
        bVar.eR(n.b(intent, "aiapps_min_swan_version"));
        bVar.p(n.c(intent, "aiapps_extra_data"));
        bVar.eS(n.b(intent, "aiapps_add_click_id"));
        bVar.eT(n.b(intent, "aiapps_not_in_history"));
        bVar.eU(n.b(intent, "aiapps_app_open_url"));
        bVar.eV(n.b(intent, "aiapps_app_download_url"));
        bVar.eW(n.b(intent, "aiapps_app_cur_swan_version"));
        bVar.a((SwanCoreVersion) n.d(intent, "aiapps_swan_core_version"));
        bVar.a((ExtensionCore) n.d(intent, "aiapps_extension_core"));
        bVar.cs(n.a(intent, "aiapps_app_frame_type", 0));
        bVar.aW(n.a(intent, "aiapps_app_console_switch", false));
        bVar.cG(n.a(intent, "aiapps_app_launch_flags", 0));
        bVar.setOrientation(n.a(intent, "ai_launch_app_orientation", 0));
        bVar.eX(n.b(intent, "remoteDebugUrl"));
        return bVar;
    }

    public static Intent b(Context context, b bVar) {
        if (context == null || bVar == null || !bVar.Fz()) {
            return null;
        }
        Intent intent = new Intent();
        intent.setAction("com.baidu.searchbox.action.aiapps.LAUNCH");
        intent.setComponent(new ComponentName(context, SwanAppLauncherActivity.class));
        intent.putExtra("swan_pms_db_info", bVar.Ga());
        intent.putExtra("aiapps_is_debug", bVar.isDebug());
        intent.putExtra("aiapps_max_swan_version", bVar.FM());
        intent.putExtra("aiapps_min_swan_version", bVar.FN());
        intent.putExtra("aiapps_extra_data", bVar.FO());
        intent.putExtra("aiapps_add_click_id", bVar.FP());
        intent.putExtra("aiapps_app_frame_type", bVar.FU());
        intent.putExtra("ai_launch_app_orientation", bVar.getOrientation());
        if (bVar.FJ() != IjkMediaMeta.AV_CH_WIDE_LEFT) {
            intent.putExtra("aiapps_navigatebar_color", bVar.FJ());
        }
        if (!TextUtils.isEmpty(bVar.FK())) {
            intent.putExtra("aiapps_launch_from", bVar.FK());
        }
        if (!TextUtils.isEmpty(bVar.FL())) {
            intent.putExtra("aiapps_launch_scheme", bVar.FL());
        }
        if (!TextUtils.isEmpty(bVar.getPage())) {
            intent.putExtra("aiapps_page", bVar.getPage());
        }
        if (!TextUtils.isEmpty(bVar.FQ())) {
            intent.putExtra("aiapps_not_in_history", bVar.FQ());
        }
        if (!TextUtils.isEmpty(bVar.FR())) {
            intent.putExtra("aiapps_app_open_url", bVar.FR());
        }
        if (!TextUtils.isEmpty(bVar.FS())) {
            intent.putExtra("aiapps_app_download_url", bVar.FS());
        }
        if (bVar.Cm() != null) {
            intent.putExtra("aiapps_swan_core_version", bVar.Cm());
        }
        if (bVar.Cn() != null) {
            intent.putExtra("aiapps_extension_core", bVar.Cn());
        }
        if (bVar.FT() != null) {
            intent.putExtra("aiapps_app_cur_swan_version", bVar.FT());
        }
        intent.putExtra("aiapps_app_console_switch", com.baidu.swan.apps.console.b.dr(bVar.getAppKey()));
        intent.putExtra("remoteDebugUrl", bVar.FZ());
        intent.putExtra("aiapps_app_launch_flags", bVar.FW());
        return intent;
    }

    public static Intent c(Context context, b bVar) {
        if (context == null || bVar == null) {
            return null;
        }
        Intent intent = new Intent();
        intent.putExtra("swan_pms_db_info", bVar.Ga());
        return intent;
    }

    public static b Fw() {
        b bVar = new b();
        bVar.ef("小程序测试");
        bVar.setAppId("wSfMyKIbrbNg7ogTFTcBuk1P8mgGTlB1");
        bVar.F(Color.parseColor("#FF308EF0"));
        bVar.eO("1230000000000000");
        bVar.eL("小程序简介");
        bVar.eM("测试服务类目");
        bVar.eN("测试主体信息");
        bVar.setAppKey("CdKRXT4IrCwTD6LIBS7DIlL8rmbKx58N");
        bVar.setVersion("1.0");
        bVar.setIconUrl("https://gss3.bdstatic.com/9rkZsjib41gCpNKfpU_Y_D3/searchbox/aps/1516937209_WechatIMG147.jpeg");
        return bVar;
    }

    public static String a(b bVar, com.baidu.swan.apps.ae.a.c cVar) {
        String page = bVar.getPage();
        if (!TextUtils.isEmpty(page) && page.startsWith(File.separator)) {
            page = page.substring(1);
        }
        bVar.setPage(null);
        return a(page, cVar);
    }

    private static String a(String str, com.baidu.swan.apps.ae.a.c cVar) {
        if (TextUtils.isEmpty(str) || cVar == null) {
            return null;
        }
        if (cVar.gQ(aa.is(str))) {
            return str;
        }
        return null;
    }

    public JSONObject Fx() {
        if (this.azC != null) {
            String queryParameter = Uri.parse(this.azC).getQueryParameter("_swaninfo");
            if (!TextUtils.isEmpty(queryParameter)) {
                try {
                    return new JSONObject(queryParameter).optJSONObject("baidusearch");
                } catch (JSONException e) {
                    if (DEBUG) {
                        e.printStackTrace();
                    }
                }
            }
        }
        return new JSONObject();
    }

    public boolean isValid() {
        return !TextUtils.isEmpty(getAppId());
    }

    @NonNull
    public Bundle Fy() {
        if (this.azD == null) {
            this.azD = new Bundle();
        }
        return this.azD;
    }

    public void aj(String str, String str2) {
        if (str != null && str2 != null) {
            Fy().putString(str, str2);
        }
    }

    private boolean Fz() {
        return (TextUtils.isEmpty(getAppId()) || TextUtils.isEmpty(Cz())) ? false : true;
    }

    public String Cy() {
        return "SwanAppLaunchInfo{mAppId='" + getAppId() + "', mAppKey='" + getAppKey() + "', mAppTitle='" + Cz() + "', pmsAppInfo is null='" + (this.azO == null) + "', launchFrom='" + FK() + "', launchScheme='" + FL() + "', page='" + getPage() + "', mErrorCode=" + FB() + ", mErrorDetail='" + FC() + "', mErrorMsg='" + FD() + "', mResumeDate='" + FE() + "', maxSwanVersion='" + FM() + "', minSwanVersion='" + FN() + "', mVersion='" + getVersion() + "', mType=" + getType() + ", extraData=" + FO() + ", isDebug=" + isDebug() + ", targetSwanVersion='" + FT() + "', swanCoreVersion=" + Cm() + ", appFrameType=" + FU() + ", consoleSwitch=" + FV() + ", orientation=" + getOrientation() + ", versionCode='" + getVersionCode() + "', launchFlags=" + FW() + ", swanAppStartTime=" + FX() + ", extStartTimestamp=" + FY() + ", remoteDebug='" + FZ() + "', extJSonObject=" + Gb() + '}';
    }

    public String Cz() {
        return this.azO == null ? "" : this.azO.appName;
    }

    public void ef(String str) {
        if (this.azO != null) {
            this.azO.appName = str;
        }
    }

    public String getAppKey() {
        return this.azO == null ? "" : this.azO.appKey;
    }

    public void setAppKey(String str) {
        if (this.azO != null) {
            this.azO.appKey = str;
        }
    }

    public String getAppId() {
        return this.azO == null ? "" : this.azO.appId;
    }

    public void setAppId(String str) {
        if (this.azO != null) {
            this.azO.appId = str;
        }
    }

    public String getIconUrl() {
        return this.azO == null ? "" : this.azO.iconUrl;
    }

    public void setIconUrl(String str) {
        if (this.azO != null) {
            this.azO.iconUrl = str;
        }
    }

    public String FA() {
        return this.azO == null ? "" : this.azO.description;
    }

    public void eL(String str) {
        if (this.azO != null) {
            this.azO.description = str;
        }
    }

    public int FB() {
        if (this.azO == null) {
            return 0;
        }
        return this.azO.appStatus;
    }

    public String FC() {
        return this.azO == null ? "" : this.azO.btf;
    }

    public String FD() {
        return this.azO == null ? "" : this.azO.btg;
    }

    public String FE() {
        return this.azO == null ? "" : this.azO.avq;
    }

    public String FF() {
        return this.azO == null ? "" : this.azO.avt;
    }

    public void eM(String str) {
        if (this.azO != null) {
            this.azO.avt = str;
        }
    }

    public String FG() {
        return this.azO == null ? "" : this.azO.avu;
    }

    public void eN(String str) {
        if (this.azO != null) {
            this.azO.avu = str;
        }
    }

    public SwanAppBearInfo FH() {
        if (this.azO == null) {
            return null;
        }
        String str = this.azO.avv;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return new SwanAppBearInfo(str);
    }

    public String getVersion() {
        return this.azO == null ? "" : String.valueOf(this.azO.versionCode);
    }

    public void setVersion(String str) {
        if (!TextUtils.isEmpty(str) && this.azO != null) {
            try {
                this.azO.versionCode = Integer.parseInt(str);
            } catch (NumberFormatException e) {
                if (DEBUG) {
                    e.printStackTrace();
                }
            }
        }
    }

    public String getVersionCode() {
        return this.azO == null ? "" : this.azO.versionName;
    }

    public int getType() {
        if (this.azO == null) {
            return 0;
        }
        return this.azO.type;
    }

    public long FI() {
        if (this.azO == null) {
            return 0L;
        }
        return this.azO.bth;
    }

    public int getOrientation() {
        if (this.azO == null) {
            return 0;
        }
        return this.azO.orientation;
    }

    public void setOrientation(int i) {
        if (this.azO != null) {
            this.azO.orientation = i;
        }
    }

    public long FJ() {
        return this.azA;
    }

    public void F(long j) {
        this.azA = j;
    }

    public String FK() {
        return this.azB;
    }

    public void eO(String str) {
        this.azB = str;
    }

    public String FL() {
        return this.azC;
    }

    public void eP(String str) {
        this.azC = str;
    }

    public String getPage() {
        return this.page;
    }

    public void setPage(String str) {
        this.page = str;
    }

    public String FM() {
        return this.avr;
    }

    public void eQ(String str) {
        this.avr = str;
    }

    public String FN() {
        return this.avs;
    }

    public void eR(String str) {
        this.avs = str;
    }

    public Bundle FO() {
        return this.azD;
    }

    public void p(Bundle bundle) {
        this.azD = bundle;
    }

    public String FP() {
        return this.azE;
    }

    public void eS(String str) {
        this.azE = str;
    }

    public boolean isDebug() {
        return this.azF;
    }

    public void setDebug(boolean z) {
        this.azF = z;
    }

    public String FQ() {
        return this.azG;
    }

    public void eT(String str) {
        this.azG = str;
    }

    public String FR() {
        return this.avx;
    }

    public void eU(String str) {
        this.avx = str;
    }

    public String FS() {
        return this.avy;
    }

    public void eV(String str) {
        this.avy = str;
    }

    public String FT() {
        return this.avz;
    }

    public void eW(String str) {
        this.avz = str;
    }

    public SwanCoreVersion Cm() {
        return this.azH;
    }

    public void a(SwanCoreVersion swanCoreVersion) {
        this.azH = swanCoreVersion;
    }

    public ExtensionCore Cn() {
        return this.azI;
    }

    public void a(ExtensionCore extensionCore) {
        this.azI = extensionCore;
    }

    public int FU() {
        return this.avK;
    }

    public void cs(int i) {
        this.avK = i;
    }

    public boolean FV() {
        return this.azJ;
    }

    public void aW(boolean z) {
        this.azJ = z;
    }

    public int FW() {
        return this.azK;
    }

    public void cG(int i) {
        this.azK = i;
    }

    public long FX() {
        return this.azL;
    }

    public void G(long j) {
        this.azL = j;
    }

    public long FY() {
        return this.azM;
    }

    public void H(long j) {
        this.azM = j;
    }

    public String FZ() {
        return this.azN;
    }

    public void eX(String str) {
        this.azN = str;
    }

    public PMSAppInfo Ga() {
        return this.azO;
    }

    public void e(PMSAppInfo pMSAppInfo) {
        this.azO = pMSAppInfo;
    }

    public JSONObject Gb() {
        return this.azP;
    }

    public void E(JSONObject jSONObject) {
        this.azP = jSONObject;
    }

    public static b a(b bVar, b bVar2) {
        if (bVar2 == null || bVar2.azO == null) {
            return bVar;
        }
        if (bVar != null && bVar.azO != null && bVar.azO.versionCode < bVar2.azO.versionCode) {
            bVar2.azO = bVar.azO;
            return bVar2;
        }
        return bVar2;
    }
}
