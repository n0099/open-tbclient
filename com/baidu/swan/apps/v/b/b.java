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
    private int auI = 0;
    private String auq;
    private String aur;
    private String auw;
    private String aux;
    private String auy;
    private boolean ayA;
    private String ayB;
    private SwanCoreVersion ayC;
    private ExtensionCore ayD;
    private boolean ayE;
    private int ayF;
    private long ayG;
    private long ayH;
    private String ayI;
    private PMSAppInfo ayJ;
    private JSONObject ayK;
    private long ayv;
    private String ayw;
    private String ayx;
    private Bundle ayy;
    private String ayz;
    private String page;

    public static b F(Intent intent) {
        if (intent == null) {
            throw new IllegalArgumentException("intent must not be null.");
        }
        b bVar = new b();
        bVar.e((PMSAppInfo) n.d(intent, "swan_pms_db_info"));
        bVar.F(n.a(intent, "aiapps_navigatebar_color", (long) IjkMediaMeta.AV_CH_WIDE_LEFT));
        if (d.H(intent)) {
            bVar.eH("1250000000000000");
        } else {
            bVar.eH(n.b(intent, "aiapps_launch_from"));
        }
        bVar.eI(n.b(intent, "aiapps_launch_scheme"));
        if (bVar.EX() != null) {
            String queryParameter = Uri.parse(bVar.EX()).getQueryParameter("_baiduboxapp");
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
        bVar.eJ(n.b(intent, "aiapps_max_swan_version"));
        bVar.eK(n.b(intent, "aiapps_min_swan_version"));
        bVar.p(n.c(intent, "aiapps_extra_data"));
        bVar.eL(n.b(intent, "aiapps_add_click_id"));
        bVar.eM(n.b(intent, "aiapps_not_in_history"));
        bVar.eN(n.b(intent, "aiapps_app_open_url"));
        bVar.eO(n.b(intent, "aiapps_app_download_url"));
        bVar.eP(n.b(intent, "aiapps_app_cur_swan_version"));
        bVar.a((SwanCoreVersion) n.d(intent, "aiapps_swan_core_version"));
        bVar.a((ExtensionCore) n.d(intent, "aiapps_extension_core"));
        bVar.cr(n.a(intent, "aiapps_app_frame_type", 0));
        bVar.aT(n.a(intent, "aiapps_app_console_switch", false));
        bVar.cE(n.a(intent, "aiapps_app_launch_flags", 0));
        bVar.setOrientation(n.a(intent, "ai_launch_app_orientation", 0));
        bVar.eQ(n.b(intent, "remoteDebugUrl"));
        return bVar;
    }

    public static Intent b(Context context, b bVar) {
        if (context == null || bVar == null || !bVar.EL()) {
            return null;
        }
        Intent intent = new Intent();
        intent.setAction("com.baidu.searchbox.action.aiapps.LAUNCH");
        intent.setComponent(new ComponentName(context, SwanAppLauncherActivity.class));
        intent.putExtra("swan_pms_db_info", bVar.Fm());
        intent.putExtra("aiapps_is_debug", bVar.isDebug());
        intent.putExtra("aiapps_max_swan_version", bVar.EY());
        intent.putExtra("aiapps_min_swan_version", bVar.EZ());
        intent.putExtra("aiapps_extra_data", bVar.Fa());
        intent.putExtra("aiapps_add_click_id", bVar.Fb());
        intent.putExtra("aiapps_app_frame_type", bVar.Fg());
        intent.putExtra("ai_launch_app_orientation", bVar.getOrientation());
        if (bVar.EV() != IjkMediaMeta.AV_CH_WIDE_LEFT) {
            intent.putExtra("aiapps_navigatebar_color", bVar.EV());
        }
        if (!TextUtils.isEmpty(bVar.EW())) {
            intent.putExtra("aiapps_launch_from", bVar.EW());
        }
        if (!TextUtils.isEmpty(bVar.EX())) {
            intent.putExtra("aiapps_launch_scheme", bVar.EX());
        }
        if (!TextUtils.isEmpty(bVar.getPage())) {
            intent.putExtra("aiapps_page", bVar.getPage());
        }
        if (!TextUtils.isEmpty(bVar.Fc())) {
            intent.putExtra("aiapps_not_in_history", bVar.Fc());
        }
        if (!TextUtils.isEmpty(bVar.Fd())) {
            intent.putExtra("aiapps_app_open_url", bVar.Fd());
        }
        if (!TextUtils.isEmpty(bVar.Fe())) {
            intent.putExtra("aiapps_app_download_url", bVar.Fe());
        }
        if (bVar.BA() != null) {
            intent.putExtra("aiapps_swan_core_version", bVar.BA());
        }
        if (bVar.BB() != null) {
            intent.putExtra("aiapps_extension_core", bVar.BB());
        }
        if (bVar.Ff() != null) {
            intent.putExtra("aiapps_app_cur_swan_version", bVar.Ff());
        }
        intent.putExtra("aiapps_app_console_switch", com.baidu.swan.apps.console.b.dk(bVar.getAppKey()));
        intent.putExtra("remoteDebugUrl", bVar.Fl());
        intent.putExtra("aiapps_app_launch_flags", bVar.Fi());
        return intent;
    }

    public static Intent c(Context context, b bVar) {
        if (context == null || bVar == null) {
            return null;
        }
        Intent intent = new Intent();
        intent.putExtra("swan_pms_db_info", bVar.Fm());
        return intent;
    }

    public static b EI() {
        b bVar = new b();
        bVar.dY("小程序测试");
        bVar.setAppId("wSfMyKIbrbNg7ogTFTcBuk1P8mgGTlB1");
        bVar.F(Color.parseColor("#FF308EF0"));
        bVar.eH("1230000000000000");
        bVar.eE("小程序简介");
        bVar.eF("测试服务类目");
        bVar.eG("测试主体信息");
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
        if (cVar.gH(aa.ij(str))) {
            return str;
        }
        return null;
    }

    public JSONObject EJ() {
        if (this.ayx != null) {
            String queryParameter = Uri.parse(this.ayx).getQueryParameter("_swaninfo");
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
    public Bundle EK() {
        if (this.ayy == null) {
            this.ayy = new Bundle();
        }
        return this.ayy;
    }

    public void aj(String str, String str2) {
        if (str != null && str2 != null) {
            EK().putString(str, str2);
        }
    }

    private boolean EL() {
        return (TextUtils.isEmpty(getAppId()) || TextUtils.isEmpty(BM())) ? false : true;
    }

    public String toShortString() {
        return "SwanAppLaunchInfo{mAppId='" + getAppId() + "', mAppKey='" + getAppKey() + "', mAppTitle='" + BM() + "', pmsAppInfo is null='" + (this.ayJ == null) + "', launchFrom='" + EW() + "', launchScheme='" + EX() + "', page='" + getPage() + "', mErrorCode=" + EN() + ", mErrorDetail='" + EO() + "', mErrorMsg='" + EP() + "', mResumeDate='" + EQ() + "', maxSwanVersion='" + EY() + "', minSwanVersion='" + EZ() + "', mVersion='" + getVersion() + "', mType=" + getType() + ", extraData=" + Fa() + ", isDebug=" + isDebug() + ", targetSwanVersion='" + Ff() + "', swanCoreVersion=" + BA() + ", appFrameType=" + Fg() + ", consoleSwitch=" + Fh() + ", orientation=" + getOrientation() + ", versionCode='" + getVersionCode() + "', launchFlags=" + Fi() + ", swanAppStartTime=" + Fj() + ", extStartTimestamp=" + Fk() + ", remoteDebug='" + Fl() + "', extJSonObject=" + Fn() + '}';
    }

    public String BM() {
        return this.ayJ == null ? "" : this.ayJ.appName;
    }

    public void dY(String str) {
        if (this.ayJ != null) {
            this.ayJ.appName = str;
        }
    }

    public String getAppKey() {
        return this.ayJ == null ? "" : this.ayJ.appKey;
    }

    public void setAppKey(String str) {
        if (this.ayJ != null) {
            this.ayJ.appKey = str;
        }
    }

    public String getAppId() {
        return this.ayJ == null ? "" : this.ayJ.appId;
    }

    public void setAppId(String str) {
        if (this.ayJ != null) {
            this.ayJ.appId = str;
        }
    }

    public String getIconUrl() {
        return this.ayJ == null ? "" : this.ayJ.iconUrl;
    }

    public void setIconUrl(String str) {
        if (this.ayJ != null) {
            this.ayJ.iconUrl = str;
        }
    }

    public String EM() {
        return this.ayJ == null ? "" : this.ayJ.description;
    }

    public void eE(String str) {
        if (this.ayJ != null) {
            this.ayJ.description = str;
        }
    }

    public int EN() {
        if (this.ayJ == null) {
            return 0;
        }
        return this.ayJ.appStatus;
    }

    public String EO() {
        return this.ayJ == null ? "" : this.ayJ.brT;
    }

    public String EP() {
        return this.ayJ == null ? "" : this.ayJ.brU;
    }

    public String EQ() {
        return this.ayJ == null ? "" : this.ayJ.aup;
    }

    public String ER() {
        return this.ayJ == null ? "" : this.ayJ.aus;
    }

    public void eF(String str) {
        if (this.ayJ != null) {
            this.ayJ.aus = str;
        }
    }

    public String ES() {
        return this.ayJ == null ? "" : this.ayJ.aut;
    }

    public void eG(String str) {
        if (this.ayJ != null) {
            this.ayJ.aut = str;
        }
    }

    public SwanAppBearInfo ET() {
        if (this.ayJ == null) {
            return null;
        }
        String str = this.ayJ.auu;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return new SwanAppBearInfo(str);
    }

    public String getVersion() {
        return this.ayJ == null ? "" : String.valueOf(this.ayJ.versionCode);
    }

    public void setVersion(String str) {
        if (!TextUtils.isEmpty(str) && this.ayJ != null) {
            try {
                this.ayJ.versionCode = Integer.parseInt(str);
            } catch (NumberFormatException e) {
                if (DEBUG) {
                    e.printStackTrace();
                }
            }
        }
    }

    public String getVersionCode() {
        return this.ayJ == null ? "" : this.ayJ.versionName;
    }

    public int getType() {
        if (this.ayJ == null) {
            return 0;
        }
        return this.ayJ.type;
    }

    public long EU() {
        if (this.ayJ == null) {
            return 0L;
        }
        return this.ayJ.brV;
    }

    public int getOrientation() {
        if (this.ayJ == null) {
            return 0;
        }
        return this.ayJ.orientation;
    }

    public void setOrientation(int i) {
        if (this.ayJ != null) {
            this.ayJ.orientation = i;
        }
    }

    public long EV() {
        return this.ayv;
    }

    public void F(long j) {
        this.ayv = j;
    }

    public String EW() {
        return this.ayw;
    }

    public void eH(String str) {
        this.ayw = str;
    }

    public String EX() {
        return this.ayx;
    }

    public void eI(String str) {
        this.ayx = str;
    }

    public String getPage() {
        return this.page;
    }

    public void setPage(String str) {
        this.page = str;
    }

    public String EY() {
        return this.auq;
    }

    public void eJ(String str) {
        this.auq = str;
    }

    public String EZ() {
        return this.aur;
    }

    public void eK(String str) {
        this.aur = str;
    }

    public Bundle Fa() {
        return this.ayy;
    }

    public void p(Bundle bundle) {
        this.ayy = bundle;
    }

    public String Fb() {
        return this.ayz;
    }

    public void eL(String str) {
        this.ayz = str;
    }

    public boolean isDebug() {
        return this.ayA;
    }

    public void setDebug(boolean z) {
        this.ayA = z;
    }

    public String Fc() {
        return this.ayB;
    }

    public void eM(String str) {
        this.ayB = str;
    }

    public String Fd() {
        return this.auw;
    }

    public void eN(String str) {
        this.auw = str;
    }

    public String Fe() {
        return this.aux;
    }

    public void eO(String str) {
        this.aux = str;
    }

    public String Ff() {
        return this.auy;
    }

    public void eP(String str) {
        this.auy = str;
    }

    public SwanCoreVersion BA() {
        return this.ayC;
    }

    public void a(SwanCoreVersion swanCoreVersion) {
        this.ayC = swanCoreVersion;
    }

    public ExtensionCore BB() {
        return this.ayD;
    }

    public void a(ExtensionCore extensionCore) {
        this.ayD = extensionCore;
    }

    public int Fg() {
        return this.auI;
    }

    public void cr(int i) {
        this.auI = i;
    }

    public boolean Fh() {
        return this.ayE;
    }

    public void aT(boolean z) {
        this.ayE = z;
    }

    public int Fi() {
        return this.ayF;
    }

    public void cE(int i) {
        this.ayF = i;
    }

    public long Fj() {
        return this.ayG;
    }

    public void G(long j) {
        this.ayG = j;
    }

    public long Fk() {
        return this.ayH;
    }

    public void H(long j) {
        this.ayH = j;
    }

    public String Fl() {
        return this.ayI;
    }

    public void eQ(String str) {
        this.ayI = str;
    }

    public PMSAppInfo Fm() {
        return this.ayJ;
    }

    public void e(PMSAppInfo pMSAppInfo) {
        this.ayJ = pMSAppInfo;
    }

    public JSONObject Fn() {
        return this.ayK;
    }

    public void E(JSONObject jSONObject) {
        this.ayK = jSONObject;
    }

    public static b a(b bVar, b bVar2) {
        if (bVar2 == null || bVar2.ayJ == null) {
            return bVar;
        }
        if (bVar != null && bVar.ayJ != null && bVar.ayJ.versionCode < bVar2.ayJ.versionCode) {
            bVar2.ayJ = bVar.ayJ;
            return bVar2;
        }
        return bVar2;
    }
}
