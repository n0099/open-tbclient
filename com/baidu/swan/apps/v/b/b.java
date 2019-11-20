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
    private int aOH = 0;
    private String aOp;
    private String aOq;
    private String aOv;
    private String aOw;
    private String aOx;
    private String aSA;
    private boolean aSB;
    private String aSC;
    private SwanCoreVersion aSD;
    private ExtensionCore aSE;
    private boolean aSF;
    private int aSG;
    private long aSH;
    private long aSI;
    private String aSJ;
    private PMSAppInfo aSK;
    private JSONObject aSL;
    private long aSw;
    private String aSx;
    private String aSy;
    private Bundle aSz;
    private String page;

    public static b L(Intent intent) {
        if (intent == null) {
            throw new IllegalArgumentException("intent must not be null.");
        }
        b bVar = new b();
        bVar.e((PMSAppInfo) n.c(intent, "swan_pms_db_info"));
        bVar.X(n.a(intent, "aiapps_navigatebar_color", (long) IjkMediaMeta.AV_CH_WIDE_LEFT));
        if (d.N(intent)) {
            bVar.fv("1250000000000000");
        } else {
            bVar.fv(n.a(intent, "aiapps_launch_from"));
        }
        bVar.fw(n.a(intent, "aiapps_launch_scheme"));
        if (bVar.KG() != null) {
            String queryParameter = Uri.parse(bVar.KG()).getQueryParameter("_baiduboxapp");
            if (!TextUtils.isEmpty(queryParameter)) {
                try {
                    bVar.ad(new JSONObject(queryParameter).optJSONObject("ext"));
                } catch (JSONException e) {
                    if (DEBUG) {
                        e.printStackTrace();
                    }
                }
            }
        }
        bVar.setPage(n.a(intent, "aiapps_page"));
        bVar.setDebug(n.a(intent, "aiapps_is_debug", true));
        bVar.fx(n.a(intent, "aiapps_max_swan_version"));
        bVar.fy(n.a(intent, "aiapps_min_swan_version"));
        bVar.p(n.b(intent, "aiapps_extra_data"));
        bVar.fz(n.a(intent, "aiapps_add_click_id"));
        bVar.fA(n.a(intent, "aiapps_not_in_history"));
        bVar.fB(n.a(intent, "aiapps_app_open_url"));
        bVar.fC(n.a(intent, "aiapps_app_download_url"));
        bVar.fD(n.a(intent, "aiapps_app_cur_swan_version"));
        bVar.a((SwanCoreVersion) n.c(intent, "aiapps_swan_core_version"));
        bVar.a((ExtensionCore) n.c(intent, "aiapps_extension_core"));
        bVar.m19do(n.a(intent, "aiapps_app_frame_type", 0));
        bVar.bo(n.a(intent, "aiapps_app_console_switch", false));
        bVar.dB(n.a(intent, "aiapps_app_launch_flags", 0));
        bVar.setOrientation(n.a(intent, "ai_launch_app_orientation", 0));
        bVar.fE(n.a(intent, "remoteDebugUrl"));
        return bVar;
    }

    public static Intent b(Context context, b bVar) {
        if (context == null || bVar == null || !bVar.Ku()) {
            return null;
        }
        Intent intent = new Intent();
        intent.setAction("com.baidu.searchbox.action.aiapps.LAUNCH");
        intent.setComponent(new ComponentName(context, SwanAppLauncherActivity.class));
        intent.putExtra("swan_pms_db_info", bVar.KV());
        intent.putExtra("aiapps_is_debug", bVar.isDebug());
        intent.putExtra("aiapps_max_swan_version", bVar.KH());
        intent.putExtra("aiapps_min_swan_version", bVar.KI());
        intent.putExtra("aiapps_extra_data", bVar.KJ());
        intent.putExtra("aiapps_add_click_id", bVar.KK());
        intent.putExtra("aiapps_app_frame_type", bVar.KP());
        intent.putExtra("ai_launch_app_orientation", bVar.getOrientation());
        if (bVar.KE() != IjkMediaMeta.AV_CH_WIDE_LEFT) {
            intent.putExtra("aiapps_navigatebar_color", bVar.KE());
        }
        if (!TextUtils.isEmpty(bVar.KF())) {
            intent.putExtra("aiapps_launch_from", bVar.KF());
        }
        if (!TextUtils.isEmpty(bVar.KG())) {
            intent.putExtra("aiapps_launch_scheme", bVar.KG());
        }
        if (!TextUtils.isEmpty(bVar.getPage())) {
            intent.putExtra("aiapps_page", bVar.getPage());
        }
        if (!TextUtils.isEmpty(bVar.KL())) {
            intent.putExtra("aiapps_not_in_history", bVar.KL());
        }
        if (!TextUtils.isEmpty(bVar.KM())) {
            intent.putExtra("aiapps_app_open_url", bVar.KM());
        }
        if (!TextUtils.isEmpty(bVar.KN())) {
            intent.putExtra("aiapps_app_download_url", bVar.KN());
        }
        if (bVar.Hh() != null) {
            intent.putExtra("aiapps_swan_core_version", bVar.Hh());
        }
        if (bVar.Hi() != null) {
            intent.putExtra("aiapps_extension_core", bVar.Hi());
        }
        if (bVar.KO() != null) {
            intent.putExtra("aiapps_app_cur_swan_version", bVar.KO());
        }
        intent.putExtra("aiapps_app_console_switch", com.baidu.swan.apps.console.b.ea(bVar.getAppKey()));
        intent.putExtra("remoteDebugUrl", bVar.KU());
        intent.putExtra("aiapps_app_launch_flags", bVar.KR());
        return intent;
    }

    public static Intent c(Context context, b bVar) {
        if (context == null || bVar == null) {
            return null;
        }
        Intent intent = new Intent();
        intent.putExtra("swan_pms_db_info", bVar.KV());
        return intent;
    }

    public static b Kr() {
        b bVar = new b();
        bVar.eM("小程序测试");
        bVar.setAppId("wSfMyKIbrbNg7ogTFTcBuk1P8mgGTlB1");
        bVar.X(Color.parseColor("#FF308EF0"));
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

    public JSONObject Ks() {
        if (this.aSy != null) {
            String queryParameter = Uri.parse(this.aSy).getQueryParameter("_swaninfo");
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
    public Bundle Kt() {
        if (this.aSz == null) {
            this.aSz = new Bundle();
        }
        return this.aSz;
    }

    public void ar(String str, String str2) {
        if (str != null && str2 != null) {
            Kt().putString(str, str2);
        }
    }

    private boolean Ku() {
        return (TextUtils.isEmpty(getAppId()) || TextUtils.isEmpty(Hu())) ? false : true;
    }

    public String Ht() {
        return "SwanAppLaunchInfo{mAppId='" + getAppId() + "', mAppKey='" + getAppKey() + "', mAppTitle='" + Hu() + "', pmsAppInfo is null='" + (this.aSK == null) + "', launchFrom='" + KF() + "', launchScheme='" + KG() + "', page='" + getPage() + "', mErrorCode=" + Kw() + ", mErrorDetail='" + Kx() + "', mErrorMsg='" + Ky() + "', mResumeDate='" + Kz() + "', maxSwanVersion='" + KH() + "', minSwanVersion='" + KI() + "', mVersion='" + getVersion() + "', mType=" + getType() + ", extraData=" + KJ() + ", isDebug=" + isDebug() + ", targetSwanVersion='" + KO() + "', swanCoreVersion=" + Hh() + ", appFrameType=" + KP() + ", consoleSwitch=" + KQ() + ", orientation=" + getOrientation() + ", versionCode='" + getVersionCode() + "', launchFlags=" + KR() + ", swanAppStartTime=" + KS() + ", extStartTimestamp=" + KT() + ", remoteDebug='" + KU() + "', extJSonObject=" + KW() + '}';
    }

    public String Hu() {
        return this.aSK == null ? "" : this.aSK.appName;
    }

    public void eM(String str) {
        if (this.aSK != null) {
            this.aSK.appName = str;
        }
    }

    public String getAppKey() {
        return this.aSK == null ? "" : this.aSK.appKey;
    }

    public void setAppKey(String str) {
        if (this.aSK != null) {
            this.aSK.appKey = str;
        }
    }

    public String getAppId() {
        return this.aSK == null ? "" : this.aSK.appId;
    }

    public void setAppId(String str) {
        if (this.aSK != null) {
            this.aSK.appId = str;
        }
    }

    public String getIconUrl() {
        return this.aSK == null ? "" : this.aSK.iconUrl;
    }

    public void setIconUrl(String str) {
        if (this.aSK != null) {
            this.aSK.iconUrl = str;
        }
    }

    public String Kv() {
        return this.aSK == null ? "" : this.aSK.description;
    }

    public void fs(String str) {
        if (this.aSK != null) {
            this.aSK.description = str;
        }
    }

    public int Kw() {
        if (this.aSK == null) {
            return 0;
        }
        return this.aSK.appStatus;
    }

    public String Kx() {
        return this.aSK == null ? "" : this.aSK.bKZ;
    }

    public String Ky() {
        return this.aSK == null ? "" : this.aSK.bLa;
    }

    public String Kz() {
        return this.aSK == null ? "" : this.aSK.aOo;
    }

    public String KA() {
        return this.aSK == null ? "" : this.aSK.aOr;
    }

    public void ft(String str) {
        if (this.aSK != null) {
            this.aSK.aOr = str;
        }
    }

    public String KB() {
        return this.aSK == null ? "" : this.aSK.aOs;
    }

    public void fu(String str) {
        if (this.aSK != null) {
            this.aSK.aOs = str;
        }
    }

    public SwanAppBearInfo KC() {
        if (this.aSK == null) {
            return null;
        }
        String str = this.aSK.aOt;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return new SwanAppBearInfo(str);
    }

    public String getVersion() {
        return this.aSK == null ? "" : String.valueOf(this.aSK.versionCode);
    }

    public void setVersion(String str) {
        if (!TextUtils.isEmpty(str) && this.aSK != null) {
            try {
                this.aSK.versionCode = Integer.parseInt(str);
            } catch (NumberFormatException e) {
                if (DEBUG) {
                    e.printStackTrace();
                }
            }
        }
    }

    public String getVersionCode() {
        return this.aSK == null ? "" : this.aSK.versionName;
    }

    public int getType() {
        if (this.aSK == null) {
            return 0;
        }
        return this.aSK.type;
    }

    public long KD() {
        if (this.aSK == null) {
            return 0L;
        }
        return this.aSK.bLb;
    }

    public int getOrientation() {
        if (this.aSK == null) {
            return 0;
        }
        return this.aSK.orientation;
    }

    public void setOrientation(int i) {
        if (this.aSK != null) {
            this.aSK.orientation = i;
        }
    }

    public long KE() {
        return this.aSw;
    }

    public void X(long j) {
        this.aSw = j;
    }

    public String KF() {
        return this.aSx;
    }

    public void fv(String str) {
        this.aSx = str;
    }

    public String KG() {
        return this.aSy;
    }

    public void fw(String str) {
        this.aSy = str;
    }

    public String getPage() {
        return this.page;
    }

    public void setPage(String str) {
        this.page = str;
    }

    public String KH() {
        return this.aOp;
    }

    public void fx(String str) {
        this.aOp = str;
    }

    public String KI() {
        return this.aOq;
    }

    public void fy(String str) {
        this.aOq = str;
    }

    public Bundle KJ() {
        return this.aSz;
    }

    public void p(Bundle bundle) {
        this.aSz = bundle;
    }

    public String KK() {
        return this.aSA;
    }

    public void fz(String str) {
        this.aSA = str;
    }

    public boolean isDebug() {
        return this.aSB;
    }

    public void setDebug(boolean z) {
        this.aSB = z;
    }

    public String KL() {
        return this.aSC;
    }

    public void fA(String str) {
        this.aSC = str;
    }

    public String KM() {
        return this.aOv;
    }

    public void fB(String str) {
        this.aOv = str;
    }

    public String KN() {
        return this.aOw;
    }

    public void fC(String str) {
        this.aOw = str;
    }

    public String KO() {
        return this.aOx;
    }

    public void fD(String str) {
        this.aOx = str;
    }

    public SwanCoreVersion Hh() {
        return this.aSD;
    }

    public void a(SwanCoreVersion swanCoreVersion) {
        this.aSD = swanCoreVersion;
    }

    public ExtensionCore Hi() {
        return this.aSE;
    }

    public void a(ExtensionCore extensionCore) {
        this.aSE = extensionCore;
    }

    public int KP() {
        return this.aOH;
    }

    /* renamed from: do  reason: not valid java name */
    public void m19do(int i) {
        this.aOH = i;
    }

    public boolean KQ() {
        return this.aSF;
    }

    public void bo(boolean z) {
        this.aSF = z;
    }

    public int KR() {
        return this.aSG;
    }

    public void dB(int i) {
        this.aSG = i;
    }

    public long KS() {
        return this.aSH;
    }

    public void Y(long j) {
        this.aSH = j;
    }

    public long KT() {
        return this.aSI;
    }

    public void Z(long j) {
        this.aSI = j;
    }

    public String KU() {
        return this.aSJ;
    }

    public void fE(String str) {
        this.aSJ = str;
    }

    public PMSAppInfo KV() {
        return this.aSK;
    }

    public void e(PMSAppInfo pMSAppInfo) {
        this.aSK = pMSAppInfo;
    }

    public JSONObject KW() {
        return this.aSL;
    }

    public void ad(JSONObject jSONObject) {
        this.aSL = jSONObject;
    }

    public static b a(b bVar, b bVar2) {
        if (bVar2 == null || bVar2.aSK == null) {
            return bVar;
        }
        if (bVar != null && bVar.aSK != null && bVar.aSK.versionCode < bVar2.aSK.versionCode) {
            bVar2.aSK = bVar.aSK;
            return bVar2;
        }
        return bVar2;
    }
}
