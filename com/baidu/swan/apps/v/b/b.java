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
    private String aOH;
    private String aOI;
    private String aON;
    private String aOO;
    private String aOP;
    private int aOZ = 0;
    private long aSO;
    private String aSP;
    private String aSQ;
    private Bundle aSR;
    private String aSS;
    private boolean aST;
    private String aSU;
    private SwanCoreVersion aSV;
    private ExtensionCore aSW;
    private boolean aSX;
    private int aSY;
    private long aSZ;
    private long aTa;
    private String aTb;
    private PMSAppInfo aTc;
    private JSONObject aTd;
    private String page;

    public static b L(Intent intent) {
        if (intent == null) {
            throw new IllegalArgumentException("intent must not be null.");
        }
        b bVar = new b();
        bVar.e((PMSAppInfo) n.d(intent, "swan_pms_db_info"));
        bVar.Y(n.a(intent, "aiapps_navigatebar_color", (long) IjkMediaMeta.AV_CH_WIDE_LEFT));
        if (d.N(intent)) {
            bVar.fv("1250000000000000");
        } else {
            bVar.fv(n.b(intent, "aiapps_launch_from"));
        }
        bVar.fw(n.b(intent, "aiapps_launch_scheme"));
        if (bVar.KF() != null) {
            String queryParameter = Uri.parse(bVar.KF()).getQueryParameter("_baiduboxapp");
            if (!TextUtils.isEmpty(queryParameter)) {
                try {
                    bVar.ac(new JSONObject(queryParameter).optJSONObject("ext"));
                } catch (JSONException e) {
                    if (DEBUG) {
                        e.printStackTrace();
                    }
                }
            }
        }
        bVar.setPage(n.b(intent, "aiapps_page"));
        bVar.setDebug(n.a(intent, "aiapps_is_debug", true));
        bVar.fx(n.b(intent, "aiapps_max_swan_version"));
        bVar.fy(n.b(intent, "aiapps_min_swan_version"));
        bVar.p(n.c(intent, "aiapps_extra_data"));
        bVar.fz(n.b(intent, "aiapps_add_click_id"));
        bVar.fA(n.b(intent, "aiapps_not_in_history"));
        bVar.fB(n.b(intent, "aiapps_app_open_url"));
        bVar.fC(n.b(intent, "aiapps_app_download_url"));
        bVar.fD(n.b(intent, "aiapps_app_cur_swan_version"));
        bVar.a((SwanCoreVersion) n.d(intent, "aiapps_swan_core_version"));
        bVar.a((ExtensionCore) n.d(intent, "aiapps_extension_core"));
        bVar.m19do(n.a(intent, "aiapps_app_frame_type", 0));
        bVar.bo(n.a(intent, "aiapps_app_console_switch", false));
        bVar.dB(n.a(intent, "aiapps_app_launch_flags", 0));
        bVar.setOrientation(n.a(intent, "ai_launch_app_orientation", 0));
        bVar.fE(n.b(intent, "remoteDebugUrl"));
        return bVar;
    }

    public static Intent b(Context context, b bVar) {
        if (context == null || bVar == null || !bVar.Kt()) {
            return null;
        }
        Intent intent = new Intent();
        intent.setAction("com.baidu.searchbox.action.aiapps.LAUNCH");
        intent.setComponent(new ComponentName(context, SwanAppLauncherActivity.class));
        intent.putExtra("swan_pms_db_info", bVar.KU());
        intent.putExtra("aiapps_is_debug", bVar.isDebug());
        intent.putExtra("aiapps_max_swan_version", bVar.KG());
        intent.putExtra("aiapps_min_swan_version", bVar.KH());
        intent.putExtra("aiapps_extra_data", bVar.KI());
        intent.putExtra("aiapps_add_click_id", bVar.KJ());
        intent.putExtra("aiapps_app_frame_type", bVar.KO());
        intent.putExtra("ai_launch_app_orientation", bVar.getOrientation());
        if (bVar.KD() != IjkMediaMeta.AV_CH_WIDE_LEFT) {
            intent.putExtra("aiapps_navigatebar_color", bVar.KD());
        }
        if (!TextUtils.isEmpty(bVar.KE())) {
            intent.putExtra("aiapps_launch_from", bVar.KE());
        }
        if (!TextUtils.isEmpty(bVar.KF())) {
            intent.putExtra("aiapps_launch_scheme", bVar.KF());
        }
        if (!TextUtils.isEmpty(bVar.getPage())) {
            intent.putExtra("aiapps_page", bVar.getPage());
        }
        if (!TextUtils.isEmpty(bVar.KK())) {
            intent.putExtra("aiapps_not_in_history", bVar.KK());
        }
        if (!TextUtils.isEmpty(bVar.KL())) {
            intent.putExtra("aiapps_app_open_url", bVar.KL());
        }
        if (!TextUtils.isEmpty(bVar.KM())) {
            intent.putExtra("aiapps_app_download_url", bVar.KM());
        }
        if (bVar.Hg() != null) {
            intent.putExtra("aiapps_swan_core_version", bVar.Hg());
        }
        if (bVar.Hh() != null) {
            intent.putExtra("aiapps_extension_core", bVar.Hh());
        }
        if (bVar.KN() != null) {
            intent.putExtra("aiapps_app_cur_swan_version", bVar.KN());
        }
        intent.putExtra("aiapps_app_console_switch", com.baidu.swan.apps.console.b.ea(bVar.getAppKey()));
        intent.putExtra("remoteDebugUrl", bVar.KT());
        intent.putExtra("aiapps_app_launch_flags", bVar.KQ());
        return intent;
    }

    public static Intent c(Context context, b bVar) {
        if (context == null || bVar == null) {
            return null;
        }
        Intent intent = new Intent();
        intent.putExtra("swan_pms_db_info", bVar.KU());
        return intent;
    }

    public static b Kq() {
        b bVar = new b();
        bVar.eM("小程序测试");
        bVar.setAppId("wSfMyKIbrbNg7ogTFTcBuk1P8mgGTlB1");
        bVar.Y(Color.parseColor("#FF308EF0"));
        bVar.fv("1230000000000000");
        bVar.fs("小程序简介");
        bVar.ft("测试服务类目");
        bVar.fu("测试主体信息");
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
        if (cVar.hu(aa.iV(str))) {
            return str;
        }
        return null;
    }

    public JSONObject Kr() {
        if (this.aSQ != null) {
            String queryParameter = Uri.parse(this.aSQ).getQueryParameter("_swaninfo");
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
    public Bundle Ks() {
        if (this.aSR == null) {
            this.aSR = new Bundle();
        }
        return this.aSR;
    }

    public void ar(String str, String str2) {
        if (str != null && str2 != null) {
            Ks().putString(str, str2);
        }
    }

    private boolean Kt() {
        return (TextUtils.isEmpty(getAppId()) || TextUtils.isEmpty(Ht())) ? false : true;
    }

    public String Hs() {
        return "SwanAppLaunchInfo{mAppId='" + getAppId() + "', mAppKey='" + getAppKey() + "', mAppTitle='" + Ht() + "', pmsAppInfo is null='" + (this.aTc == null) + "', launchFrom='" + KE() + "', launchScheme='" + KF() + "', page='" + getPage() + "', mErrorCode=" + Kv() + ", mErrorDetail='" + Kw() + "', mErrorMsg='" + Kx() + "', mResumeDate='" + Ky() + "', maxSwanVersion='" + KG() + "', minSwanVersion='" + KH() + "', mVersion='" + getVersion() + "', mType=" + getType() + ", extraData=" + KI() + ", isDebug=" + isDebug() + ", targetSwanVersion='" + KN() + "', swanCoreVersion=" + Hg() + ", appFrameType=" + KO() + ", consoleSwitch=" + KP() + ", orientation=" + getOrientation() + ", versionCode='" + getVersionCode() + "', launchFlags=" + KQ() + ", swanAppStartTime=" + KR() + ", extStartTimestamp=" + KS() + ", remoteDebug='" + KT() + "', extJSonObject=" + KV() + '}';
    }

    public String Ht() {
        return this.aTc == null ? "" : this.aTc.appName;
    }

    public void eM(String str) {
        if (this.aTc != null) {
            this.aTc.appName = str;
        }
    }

    public String getAppKey() {
        return this.aTc == null ? "" : this.aTc.appKey;
    }

    public void setAppKey(String str) {
        if (this.aTc != null) {
            this.aTc.appKey = str;
        }
    }

    public String getAppId() {
        return this.aTc == null ? "" : this.aTc.appId;
    }

    public void setAppId(String str) {
        if (this.aTc != null) {
            this.aTc.appId = str;
        }
    }

    public String getIconUrl() {
        return this.aTc == null ? "" : this.aTc.iconUrl;
    }

    public void setIconUrl(String str) {
        if (this.aTc != null) {
            this.aTc.iconUrl = str;
        }
    }

    public String Ku() {
        return this.aTc == null ? "" : this.aTc.description;
    }

    public void fs(String str) {
        if (this.aTc != null) {
            this.aTc.description = str;
        }
    }

    public int Kv() {
        if (this.aTc == null) {
            return 0;
        }
        return this.aTc.appStatus;
    }

    public String Kw() {
        return this.aTc == null ? "" : this.aTc.bLQ;
    }

    public String Kx() {
        return this.aTc == null ? "" : this.aTc.bLR;
    }

    public String Ky() {
        return this.aTc == null ? "" : this.aTc.aOG;
    }

    public String Kz() {
        return this.aTc == null ? "" : this.aTc.aOJ;
    }

    public void ft(String str) {
        if (this.aTc != null) {
            this.aTc.aOJ = str;
        }
    }

    public String KA() {
        return this.aTc == null ? "" : this.aTc.aOK;
    }

    public void fu(String str) {
        if (this.aTc != null) {
            this.aTc.aOK = str;
        }
    }

    public SwanAppBearInfo KB() {
        if (this.aTc == null) {
            return null;
        }
        String str = this.aTc.aOL;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return new SwanAppBearInfo(str);
    }

    public String getVersion() {
        return this.aTc == null ? "" : String.valueOf(this.aTc.versionCode);
    }

    public void setVersion(String str) {
        if (!TextUtils.isEmpty(str) && this.aTc != null) {
            try {
                this.aTc.versionCode = Integer.parseInt(str);
            } catch (NumberFormatException e) {
                if (DEBUG) {
                    e.printStackTrace();
                }
            }
        }
    }

    public String getVersionCode() {
        return this.aTc == null ? "" : this.aTc.versionName;
    }

    public int getType() {
        if (this.aTc == null) {
            return 0;
        }
        return this.aTc.type;
    }

    public long KC() {
        if (this.aTc == null) {
            return 0L;
        }
        return this.aTc.bLS;
    }

    public int getOrientation() {
        if (this.aTc == null) {
            return 0;
        }
        return this.aTc.orientation;
    }

    public void setOrientation(int i) {
        if (this.aTc != null) {
            this.aTc.orientation = i;
        }
    }

    public long KD() {
        return this.aSO;
    }

    public void Y(long j) {
        this.aSO = j;
    }

    public String KE() {
        return this.aSP;
    }

    public void fv(String str) {
        this.aSP = str;
    }

    public String KF() {
        return this.aSQ;
    }

    public void fw(String str) {
        this.aSQ = str;
    }

    public String getPage() {
        return this.page;
    }

    public void setPage(String str) {
        this.page = str;
    }

    public String KG() {
        return this.aOH;
    }

    public void fx(String str) {
        this.aOH = str;
    }

    public String KH() {
        return this.aOI;
    }

    public void fy(String str) {
        this.aOI = str;
    }

    public Bundle KI() {
        return this.aSR;
    }

    public void p(Bundle bundle) {
        this.aSR = bundle;
    }

    public String KJ() {
        return this.aSS;
    }

    public void fz(String str) {
        this.aSS = str;
    }

    public boolean isDebug() {
        return this.aST;
    }

    public void setDebug(boolean z) {
        this.aST = z;
    }

    public String KK() {
        return this.aSU;
    }

    public void fA(String str) {
        this.aSU = str;
    }

    public String KL() {
        return this.aON;
    }

    public void fB(String str) {
        this.aON = str;
    }

    public String KM() {
        return this.aOO;
    }

    public void fC(String str) {
        this.aOO = str;
    }

    public String KN() {
        return this.aOP;
    }

    public void fD(String str) {
        this.aOP = str;
    }

    public SwanCoreVersion Hg() {
        return this.aSV;
    }

    public void a(SwanCoreVersion swanCoreVersion) {
        this.aSV = swanCoreVersion;
    }

    public ExtensionCore Hh() {
        return this.aSW;
    }

    public void a(ExtensionCore extensionCore) {
        this.aSW = extensionCore;
    }

    public int KO() {
        return this.aOZ;
    }

    /* renamed from: do  reason: not valid java name */
    public void m19do(int i) {
        this.aOZ = i;
    }

    public boolean KP() {
        return this.aSX;
    }

    public void bo(boolean z) {
        this.aSX = z;
    }

    public int KQ() {
        return this.aSY;
    }

    public void dB(int i) {
        this.aSY = i;
    }

    public long KR() {
        return this.aSZ;
    }

    public void Z(long j) {
        this.aSZ = j;
    }

    public long KS() {
        return this.aTa;
    }

    public void aa(long j) {
        this.aTa = j;
    }

    public String KT() {
        return this.aTb;
    }

    public void fE(String str) {
        this.aTb = str;
    }

    public PMSAppInfo KU() {
        return this.aTc;
    }

    public void e(PMSAppInfo pMSAppInfo) {
        this.aTc = pMSAppInfo;
    }

    public JSONObject KV() {
        return this.aTd;
    }

    public void ac(JSONObject jSONObject) {
        this.aTd = jSONObject;
    }

    public static b a(b bVar, b bVar2) {
        if (bVar2 == null || bVar2.aTc == null) {
            return bVar;
        }
        if (bVar != null && bVar.aTc != null && bVar.aTc.versionCode < bVar2.aTc.versionCode) {
            bVar2.aTc = bVar.aTc;
            return bVar2;
        }
        return bVar2;
    }
}
