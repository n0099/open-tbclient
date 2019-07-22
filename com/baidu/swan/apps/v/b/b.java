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
    private String auT;
    private String auU;
    private String auZ;
    private String ava;
    private String avb;
    private int avm = 0;
    private long azc;
    private String azd;
    private String aze;
    private Bundle azf;
    private String azg;
    private boolean azh;
    private String azi;
    private SwanCoreVersion azj;
    private ExtensionCore azk;
    private boolean azl;
    private int azm;
    private long azn;
    private long azo;
    private String azp;
    private PMSAppInfo azq;
    private JSONObject azr;
    private String page;

    public static b F(Intent intent) {
        if (intent == null) {
            throw new IllegalArgumentException("intent must not be null.");
        }
        b bVar = new b();
        bVar.e((PMSAppInfo) n.d(intent, "swan_pms_db_info"));
        bVar.F(n.a(intent, "aiapps_navigatebar_color", (long) IjkMediaMeta.AV_CH_WIDE_LEFT));
        if (d.H(intent)) {
            bVar.eM("1250000000000000");
        } else {
            bVar.eM(n.b(intent, "aiapps_launch_from"));
        }
        bVar.eN(n.b(intent, "aiapps_launch_scheme"));
        if (bVar.FH() != null) {
            String queryParameter = Uri.parse(bVar.FH()).getQueryParameter("_baiduboxapp");
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
        bVar.eO(n.b(intent, "aiapps_max_swan_version"));
        bVar.eP(n.b(intent, "aiapps_min_swan_version"));
        bVar.p(n.c(intent, "aiapps_extra_data"));
        bVar.eQ(n.b(intent, "aiapps_add_click_id"));
        bVar.eR(n.b(intent, "aiapps_not_in_history"));
        bVar.eS(n.b(intent, "aiapps_app_open_url"));
        bVar.eT(n.b(intent, "aiapps_app_download_url"));
        bVar.eU(n.b(intent, "aiapps_app_cur_swan_version"));
        bVar.a((SwanCoreVersion) n.d(intent, "aiapps_swan_core_version"));
        bVar.a((ExtensionCore) n.d(intent, "aiapps_extension_core"));
        bVar.cr(n.a(intent, "aiapps_app_frame_type", 0));
        bVar.aW(n.a(intent, "aiapps_app_console_switch", false));
        bVar.cF(n.a(intent, "aiapps_app_launch_flags", 0));
        bVar.setOrientation(n.a(intent, "ai_launch_app_orientation", 0));
        bVar.eV(n.b(intent, "remoteDebugUrl"));
        return bVar;
    }

    public static Intent b(Context context, b bVar) {
        if (context == null || bVar == null || !bVar.Fv()) {
            return null;
        }
        Intent intent = new Intent();
        intent.setAction("com.baidu.searchbox.action.aiapps.LAUNCH");
        intent.setComponent(new ComponentName(context, SwanAppLauncherActivity.class));
        intent.putExtra("swan_pms_db_info", bVar.FW());
        intent.putExtra("aiapps_is_debug", bVar.isDebug());
        intent.putExtra("aiapps_max_swan_version", bVar.FI());
        intent.putExtra("aiapps_min_swan_version", bVar.FJ());
        intent.putExtra("aiapps_extra_data", bVar.FK());
        intent.putExtra("aiapps_add_click_id", bVar.FL());
        intent.putExtra("aiapps_app_frame_type", bVar.FQ());
        intent.putExtra("ai_launch_app_orientation", bVar.getOrientation());
        if (bVar.FF() != IjkMediaMeta.AV_CH_WIDE_LEFT) {
            intent.putExtra("aiapps_navigatebar_color", bVar.FF());
        }
        if (!TextUtils.isEmpty(bVar.FG())) {
            intent.putExtra("aiapps_launch_from", bVar.FG());
        }
        if (!TextUtils.isEmpty(bVar.FH())) {
            intent.putExtra("aiapps_launch_scheme", bVar.FH());
        }
        if (!TextUtils.isEmpty(bVar.getPage())) {
            intent.putExtra("aiapps_page", bVar.getPage());
        }
        if (!TextUtils.isEmpty(bVar.FM())) {
            intent.putExtra("aiapps_not_in_history", bVar.FM());
        }
        if (!TextUtils.isEmpty(bVar.FN())) {
            intent.putExtra("aiapps_app_open_url", bVar.FN());
        }
        if (!TextUtils.isEmpty(bVar.FO())) {
            intent.putExtra("aiapps_app_download_url", bVar.FO());
        }
        if (bVar.Ci() != null) {
            intent.putExtra("aiapps_swan_core_version", bVar.Ci());
        }
        if (bVar.Cj() != null) {
            intent.putExtra("aiapps_extension_core", bVar.Cj());
        }
        if (bVar.FP() != null) {
            intent.putExtra("aiapps_app_cur_swan_version", bVar.FP());
        }
        intent.putExtra("aiapps_app_console_switch", com.baidu.swan.apps.console.b.dp(bVar.getAppKey()));
        intent.putExtra("remoteDebugUrl", bVar.FV());
        intent.putExtra("aiapps_app_launch_flags", bVar.FS());
        return intent;
    }

    public static Intent c(Context context, b bVar) {
        if (context == null || bVar == null) {
            return null;
        }
        Intent intent = new Intent();
        intent.putExtra("swan_pms_db_info", bVar.FW());
        return intent;
    }

    public static b Fs() {
        b bVar = new b();
        bVar.ed("小程序测试");
        bVar.setAppId("wSfMyKIbrbNg7ogTFTcBuk1P8mgGTlB1");
        bVar.F(Color.parseColor("#FF308EF0"));
        bVar.eM("1230000000000000");
        bVar.eJ("小程序简介");
        bVar.eK("测试服务类目");
        bVar.eL("测试主体信息");
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
        if (cVar.gO(aa.iq(str))) {
            return str;
        }
        return null;
    }

    public JSONObject Ft() {
        if (this.aze != null) {
            String queryParameter = Uri.parse(this.aze).getQueryParameter("_swaninfo");
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
    public Bundle Fu() {
        if (this.azf == null) {
            this.azf = new Bundle();
        }
        return this.azf;
    }

    public void aj(String str, String str2) {
        if (str != null && str2 != null) {
            Fu().putString(str, str2);
        }
    }

    private boolean Fv() {
        return (TextUtils.isEmpty(getAppId()) || TextUtils.isEmpty(Cv())) ? false : true;
    }

    public String Cu() {
        return "SwanAppLaunchInfo{mAppId='" + getAppId() + "', mAppKey='" + getAppKey() + "', mAppTitle='" + Cv() + "', pmsAppInfo is null='" + (this.azq == null) + "', launchFrom='" + FG() + "', launchScheme='" + FH() + "', page='" + getPage() + "', mErrorCode=" + Fx() + ", mErrorDetail='" + Fy() + "', mErrorMsg='" + Fz() + "', mResumeDate='" + FA() + "', maxSwanVersion='" + FI() + "', minSwanVersion='" + FJ() + "', mVersion='" + getVersion() + "', mType=" + getType() + ", extraData=" + FK() + ", isDebug=" + isDebug() + ", targetSwanVersion='" + FP() + "', swanCoreVersion=" + Ci() + ", appFrameType=" + FQ() + ", consoleSwitch=" + FR() + ", orientation=" + getOrientation() + ", versionCode='" + getVersionCode() + "', launchFlags=" + FS() + ", swanAppStartTime=" + FT() + ", extStartTimestamp=" + FU() + ", remoteDebug='" + FV() + "', extJSonObject=" + FX() + '}';
    }

    public String Cv() {
        return this.azq == null ? "" : this.azq.appName;
    }

    public void ed(String str) {
        if (this.azq != null) {
            this.azq.appName = str;
        }
    }

    public String getAppKey() {
        return this.azq == null ? "" : this.azq.appKey;
    }

    public void setAppKey(String str) {
        if (this.azq != null) {
            this.azq.appKey = str;
        }
    }

    public String getAppId() {
        return this.azq == null ? "" : this.azq.appId;
    }

    public void setAppId(String str) {
        if (this.azq != null) {
            this.azq.appId = str;
        }
    }

    public String getIconUrl() {
        return this.azq == null ? "" : this.azq.iconUrl;
    }

    public void setIconUrl(String str) {
        if (this.azq != null) {
            this.azq.iconUrl = str;
        }
    }

    public String Fw() {
        return this.azq == null ? "" : this.azq.description;
    }

    public void eJ(String str) {
        if (this.azq != null) {
            this.azq.description = str;
        }
    }

    public int Fx() {
        if (this.azq == null) {
            return 0;
        }
        return this.azq.appStatus;
    }

    public String Fy() {
        return this.azq == null ? "" : this.azq.bsH;
    }

    public String Fz() {
        return this.azq == null ? "" : this.azq.bsI;
    }

    public String FA() {
        return this.azq == null ? "" : this.azq.auS;
    }

    public String FB() {
        return this.azq == null ? "" : this.azq.auV;
    }

    public void eK(String str) {
        if (this.azq != null) {
            this.azq.auV = str;
        }
    }

    public String FC() {
        return this.azq == null ? "" : this.azq.auW;
    }

    public void eL(String str) {
        if (this.azq != null) {
            this.azq.auW = str;
        }
    }

    public SwanAppBearInfo FD() {
        if (this.azq == null) {
            return null;
        }
        String str = this.azq.auX;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return new SwanAppBearInfo(str);
    }

    public String getVersion() {
        return this.azq == null ? "" : String.valueOf(this.azq.versionCode);
    }

    public void setVersion(String str) {
        if (!TextUtils.isEmpty(str) && this.azq != null) {
            try {
                this.azq.versionCode = Integer.parseInt(str);
            } catch (NumberFormatException e) {
                if (DEBUG) {
                    e.printStackTrace();
                }
            }
        }
    }

    public String getVersionCode() {
        return this.azq == null ? "" : this.azq.versionName;
    }

    public int getType() {
        if (this.azq == null) {
            return 0;
        }
        return this.azq.type;
    }

    public long FE() {
        if (this.azq == null) {
            return 0L;
        }
        return this.azq.bsJ;
    }

    public int getOrientation() {
        if (this.azq == null) {
            return 0;
        }
        return this.azq.orientation;
    }

    public void setOrientation(int i) {
        if (this.azq != null) {
            this.azq.orientation = i;
        }
    }

    public long FF() {
        return this.azc;
    }

    public void F(long j) {
        this.azc = j;
    }

    public String FG() {
        return this.azd;
    }

    public void eM(String str) {
        this.azd = str;
    }

    public String FH() {
        return this.aze;
    }

    public void eN(String str) {
        this.aze = str;
    }

    public String getPage() {
        return this.page;
    }

    public void setPage(String str) {
        this.page = str;
    }

    public String FI() {
        return this.auT;
    }

    public void eO(String str) {
        this.auT = str;
    }

    public String FJ() {
        return this.auU;
    }

    public void eP(String str) {
        this.auU = str;
    }

    public Bundle FK() {
        return this.azf;
    }

    public void p(Bundle bundle) {
        this.azf = bundle;
    }

    public String FL() {
        return this.azg;
    }

    public void eQ(String str) {
        this.azg = str;
    }

    public boolean isDebug() {
        return this.azh;
    }

    public void setDebug(boolean z) {
        this.azh = z;
    }

    public String FM() {
        return this.azi;
    }

    public void eR(String str) {
        this.azi = str;
    }

    public String FN() {
        return this.auZ;
    }

    public void eS(String str) {
        this.auZ = str;
    }

    public String FO() {
        return this.ava;
    }

    public void eT(String str) {
        this.ava = str;
    }

    public String FP() {
        return this.avb;
    }

    public void eU(String str) {
        this.avb = str;
    }

    public SwanCoreVersion Ci() {
        return this.azj;
    }

    public void a(SwanCoreVersion swanCoreVersion) {
        this.azj = swanCoreVersion;
    }

    public ExtensionCore Cj() {
        return this.azk;
    }

    public void a(ExtensionCore extensionCore) {
        this.azk = extensionCore;
    }

    public int FQ() {
        return this.avm;
    }

    public void cr(int i) {
        this.avm = i;
    }

    public boolean FR() {
        return this.azl;
    }

    public void aW(boolean z) {
        this.azl = z;
    }

    public int FS() {
        return this.azm;
    }

    public void cF(int i) {
        this.azm = i;
    }

    public long FT() {
        return this.azn;
    }

    public void G(long j) {
        this.azn = j;
    }

    public long FU() {
        return this.azo;
    }

    public void H(long j) {
        this.azo = j;
    }

    public String FV() {
        return this.azp;
    }

    public void eV(String str) {
        this.azp = str;
    }

    public PMSAppInfo FW() {
        return this.azq;
    }

    public void e(PMSAppInfo pMSAppInfo) {
        this.azq = pMSAppInfo;
    }

    public JSONObject FX() {
        return this.azr;
    }

    public void E(JSONObject jSONObject) {
        this.azr = jSONObject;
    }

    public static b a(b bVar, b bVar2) {
        if (bVar2 == null || bVar2.azq == null) {
            return bVar;
        }
        if (bVar != null && bVar.azq != null && bVar.azq.versionCode < bVar2.azq.versionCode) {
            bVar2.azq = bVar.azq;
            return bVar2;
        }
        return bVar2;
    }
}
