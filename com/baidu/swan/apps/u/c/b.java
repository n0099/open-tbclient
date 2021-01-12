package com.baidu.swan.apps.u.c;

import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.swan.apps.ao.ai;
import com.baidu.swan.apps.model.SwanAppBearInfo;
import com.baidu.swan.apps.performance.k;
import com.baidu.swan.apps.runtime.config.SwanAppConfigData;
import com.baidu.swan.apps.scheme.actions.k.j;
import com.baidu.swan.apps.u.c.b;
import com.baidu.swan.pms.model.PMSAppInfo;
import java.io.File;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public abstract class b<SelfT extends b<SelfT>> extends e<SelfT> {
    private long ddG;

    /* loaded from: classes8.dex */
    public static final class a extends b<a> {
        @Override // com.baidu.swan.apps.u.c.b, com.baidu.swan.apps.u.c.a.c
        public /* synthetic */ com.baidu.swan.apps.u.c.a.c D(Bundle bundle) {
            return super.D(bundle);
        }

        @Override // com.baidu.swan.apps.u.c.b, com.baidu.swan.apps.u.c.e
        public /* synthetic */ e ck(long j) {
            return super.ck(j);
        }

        @Override // com.baidu.swan.apps.u.c.b, com.baidu.swan.apps.u.c.e
        public /* synthetic */ e hM(int i) {
            return super.hM(i);
        }

        @Override // com.baidu.swan.apps.u.c.b, com.baidu.swan.apps.u.c.e
        public /* synthetic */ e oA(String str) {
            return super.oA(str);
        }

        @Override // com.baidu.swan.apps.u.c.b, com.baidu.swan.apps.u.c.e
        public /* synthetic */ e oB(String str) {
            return super.oB(str);
        }

        @Override // com.baidu.swan.apps.u.c.b, com.baidu.swan.apps.u.c.e
        public /* synthetic */ e ou(String str) {
            return super.ou(str);
        }

        @Override // com.baidu.swan.apps.u.c.b, com.baidu.swan.apps.u.c.e
        public /* synthetic */ e ov(String str) {
            return super.ov(str);
        }

        @Override // com.baidu.swan.apps.u.c.b, com.baidu.swan.apps.u.c.e
        public /* synthetic */ e ow(String str) {
            return super.ow(str);
        }

        @Override // com.baidu.swan.apps.u.c.b, com.baidu.swan.apps.u.c.e
        public /* synthetic */ e ox(String str) {
            return super.ox(str);
        }

        @Override // com.baidu.swan.apps.u.c.b, com.baidu.swan.apps.u.c.e
        public /* synthetic */ e oy(String str) {
            return super.oy(str);
        }

        @Override // com.baidu.swan.apps.u.c.b, com.baidu.swan.apps.u.c.e
        public /* synthetic */ e oz(String str) {
            return super.oz(str);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.apps.ao.e.d
        /* renamed from: ayx */
        public a ayy() {
            return this;
        }
    }

    public static b t(Intent intent) {
        if (intent == null) {
            throw new IllegalArgumentException("intent must not be null.");
        }
        return new a().u(intent);
    }

    public SelfT u(Intent intent) {
        if (intent == null) {
            return (SelfT) ayy();
        }
        D(intent.getExtras());
        if (d.v(intent)) {
            oC("1250000000000000");
            p("box_cold_launch", -1L);
        }
        return (SelfT) ayy();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.swan.apps.u.c.a.c
    /* renamed from: C */
    public SelfT D(Bundle bundle) {
        if (bundle == null) {
            return (SelfT) ayy();
        }
        com.baidu.swan.apps.console.debugger.b.n(bundle);
        k.aDJ().J(bundle);
        super.D(bundle);
        if (TextUtils.isEmpty(bundle.getString("mPage"))) {
            oL("mPage");
        }
        return (SelfT) ayy();
    }

    @Override // com.baidu.swan.apps.u.c.a.c
    public Bundle toBundle() {
        Bundle bundle = super.toBundle();
        com.baidu.swan.apps.console.debugger.b.o(bundle);
        String appId = getAppId();
        if (!TextUtils.isEmpty(appId)) {
            bundle.putString("mAppId", appId);
        }
        return bundle;
    }

    public static b ayk() {
        a aVar = new a();
        aVar.oB("小程序测试");
        aVar.oz("wSfMyKIbrbNg7ogTFTcBuk1P8mgGTlB1");
        aVar.cl(Color.parseColor("#FF308EF0"));
        aVar.oC("1230000000000000");
        aVar.ox("小程序简介");
        aVar.ow("测试服务类目");
        aVar.ov("测试主体信息");
        aVar.oA("CdKRXT4IrCwTD6LIBS7DIlL8rmbKx58N");
        aVar.ou("1.0");
        aVar.oy("https://gss3.bdstatic.com/9rkZsjib41gCpNKfpU_Y_D3/searchbox/aps/1516937209_WechatIMG147.jpeg");
        return aVar;
    }

    public static String a(b bVar, SwanAppConfigData swanAppConfigData) {
        return b(ok(bVar.getPage()), swanAppConfigData);
    }

    public static String a(String str, SwanAppConfigData swanAppConfigData) {
        if (TextUtils.isEmpty(str) || swanAppConfigData == null) {
            if (DEBUG) {
                Log.d("SwanAppLaunchInfo", "getPageInfo ret null - " + str);
            }
            return null;
        }
        Uri parse = Uri.parse(str);
        String l = ai.l(parse);
        if (TextUtils.isEmpty(l)) {
            if (DEBUG) {
                Log.d("SwanAppLaunchInfo", "getPageInfo appId is null");
            }
            return null;
        }
        String b2 = b(l, parse);
        if (TextUtils.isEmpty(b2)) {
            if (DEBUG) {
                Log.d("SwanAppLaunchInfo", "getPageInfo no launchPath ");
            }
            return null;
        }
        String deleteQueryParam = ai.deleteQueryParam(parse.getEncodedQuery(), com.baidu.swan.apps.scheme.a.a.dFW);
        if (!TextUtils.isEmpty(deleteQueryParam)) {
            b2 = b2 + "?" + deleteQueryParam;
        }
        return b(ok(b2), swanAppConfigData);
    }

    private static String b(String str, Uri uri) {
        String path = uri.getPath();
        if (TextUtils.isEmpty(path)) {
            return null;
        }
        String substring = path.substring(str.length() + 1);
        if (substring.endsWith(File.separator)) {
            substring = substring.substring(0, substring.length() - 1);
        }
        return substring.replaceAll("/+", "/");
    }

    public static String ok(String str) {
        if (!TextUtils.isEmpty(str) && str.startsWith(File.separator)) {
            return str.substring(1);
        }
        return str;
    }

    private static String b(String str, SwanAppConfigData swanAppConfigData) {
        if (TextUtils.isEmpty(str) || swanAppConfigData == null) {
            return null;
        }
        String delAllParamsFromUrl = ai.delAllParamsFromUrl(str);
        if (com.baidu.swan.apps.ac.b.a.qq(delAllParamsFromUrl)) {
            return ai.deleteQueryParam(str, com.baidu.swan.apps.scheme.a.a.dFW);
        }
        if (swanAppConfigData.ry(j.rX(delAllParamsFromUrl))) {
            return str;
        }
        return null;
    }

    public JSONObject ayl() {
        String ayE = ayE();
        if (ayE != null) {
            String queryParameter = Uri.parse(ayE).getQueryParameter("_swaninfo");
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

    public String asD() {
        return "SwanAppLaunchInfo{mAppId='" + getAppId() + "', mAppKey='" + getAppKey() + "', mAppTitle='" + asE() + "', pmsAppInfo is null='" + ayT() + "', launchFrom='" + ayC() + "', launchScheme='" + ayE() + "', page='" + getPage() + "', mErrorCode=" + ayn() + ", mErrorDetail='" + ayo() + "', mErrorMsg='" + ayp() + "', mResumeDate='" + ayq() + "', maxSwanVersion='" + ayF() + "', minSwanVersion='" + ayG() + "', mVersion='" + getVersion() + "', mType=" + getType() + ", extraData=" + ayH() + ", isDebug=" + isDebug() + ", targetSwanVersion='" + ayN() + "', swanCoreVersion=" + asb() + ", appFrameType=" + getAppFrameType() + ", consoleSwitch=" + ayO() + ", orientation=" + getOrientation() + ", versionCode='" + getVersionCode() + "', launchFlags=" + ayP() + ", swanAppStartTime=" + ayw() + ", extStartTimestamp=" + ayQ() + ", remoteDebug='" + ayR() + "', extJSonObject=" + ayU() + ", launchId=" + ayV() + '}';
    }

    @Override // com.baidu.swan.apps.u.c.e
    public String asE() {
        PMSAppInfo ayS = ayS();
        return (ayS == null || TextUtils.isEmpty(ayS.appName)) ? super.asE() : ayS.appName;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.swan.apps.u.c.e
    /* renamed from: ol */
    public SelfT oB(String str) {
        PMSAppInfo ayS = ayS();
        if (ayS != null) {
            ayS.appName = str;
        }
        return (SelfT) super.oB(str);
    }

    @Override // com.baidu.swan.apps.u.c.e
    public String getAppKey() {
        PMSAppInfo ayS = ayS();
        return (ayS == null || TextUtils.isEmpty(ayS.appKey)) ? super.getAppKey() : ayS.appKey;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.swan.apps.u.c.e
    /* renamed from: om */
    public SelfT oA(String str) {
        PMSAppInfo ayS = ayS();
        if (ayS != null) {
            ayS.appKey = str;
        }
        return (SelfT) super.oA(str);
    }

    @Override // com.baidu.swan.apps.u.c.e
    public String getAppId() {
        PMSAppInfo ayS = ayS();
        return (ayS == null || TextUtils.isEmpty(ayS.appId)) ? super.getAppId() : ayS.appId;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.swan.apps.u.c.e
    /* renamed from: oo */
    public SelfT oz(String str) {
        super.oz(str);
        PMSAppInfo ayS = ayS();
        if (ayS != null) {
            ayS.appId = str;
            return (SelfT) super.oz(str);
        }
        return (SelfT) ayy();
    }

    @Override // com.baidu.swan.apps.u.c.e
    public String getIconUrl() {
        PMSAppInfo ayS = ayS();
        return (ayS == null || TextUtils.isEmpty(ayS.iconUrl)) ? super.getIconUrl() : ayS.iconUrl;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.swan.apps.u.c.e
    /* renamed from: op */
    public SelfT oy(String str) {
        super.oy(str);
        PMSAppInfo ayS = ayS();
        if (ayS != null) {
            ayS.iconUrl = str;
            return (SelfT) super.oy(str);
        }
        return (SelfT) ayy();
    }

    @Override // com.baidu.swan.apps.u.c.e
    public String aym() {
        PMSAppInfo ayS = ayS();
        return ayS == null ? "" : ayS.description;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.swan.apps.u.c.e
    /* renamed from: oq */
    public SelfT ox(String str) {
        PMSAppInfo ayS = ayS();
        if (ayS != null) {
            ayS.description = str;
            return (SelfT) super.ox(str);
        }
        return (SelfT) ayy();
    }

    @Override // com.baidu.swan.apps.u.c.e
    public int ayn() {
        PMSAppInfo ayS = ayS();
        if (ayS == null) {
            return 0;
        }
        return ayS.appStatus;
    }

    @Override // com.baidu.swan.apps.u.c.e
    public String ayo() {
        PMSAppInfo ayS = ayS();
        return ayS == null ? "" : ayS.statusDetail;
    }

    @Override // com.baidu.swan.apps.u.c.e
    public String ayp() {
        PMSAppInfo ayS = ayS();
        return ayS == null ? "" : ayS.statusDesc;
    }

    @Override // com.baidu.swan.apps.u.c.e
    public String ayq() {
        PMSAppInfo ayS = ayS();
        return ayS == null ? "" : ayS.resumeDate;
    }

    @Override // com.baidu.swan.apps.u.c.e
    public String ayr() {
        PMSAppInfo ayS = ayS();
        return ayS == null ? "" : ayS.serviceCategory;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.swan.apps.u.c.e
    /* renamed from: or */
    public SelfT ow(String str) {
        PMSAppInfo ayS = ayS();
        if (ayS != null) {
            ayS.serviceCategory = str;
            return (SelfT) super.ow(str);
        }
        return (SelfT) ayy();
    }

    @Override // com.baidu.swan.apps.u.c.e
    public String ays() {
        PMSAppInfo ayS = ayS();
        return ayS == null ? "" : ayS.subjectInfo;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.swan.apps.u.c.e
    /* renamed from: os */
    public SelfT ov(String str) {
        PMSAppInfo ayS = ayS();
        if (ayS != null) {
            ayS.subjectInfo = str;
            return (SelfT) super.ov(str);
        }
        return (SelfT) ayy();
    }

    @Override // com.baidu.swan.apps.u.c.e
    public SwanAppBearInfo ayt() {
        PMSAppInfo ayS = ayS();
        if (ayS == null) {
            return null;
        }
        String str = ayS.bearInfo;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return new SwanAppBearInfo(str);
    }

    @Override // com.baidu.swan.apps.u.c.e
    public String ayu() {
        PMSAppInfo ayS = ayS();
        if (ayS == null) {
            return null;
        }
        return ayS.quickAppKey;
    }

    @Override // com.baidu.swan.apps.u.c.e
    public String getVersion() {
        PMSAppInfo ayS = ayS();
        return ayS == null ? "" : String.valueOf(ayS.versionCode);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.swan.apps.u.c.e
    /* renamed from: ot */
    public SelfT ou(String str) {
        PMSAppInfo ayS = ayS();
        if (!TextUtils.isEmpty(str) && ayS != null) {
            try {
                ayS.versionCode = Integer.parseInt(str);
                return (SelfT) super.ou(str);
            } catch (NumberFormatException e) {
                if (DEBUG) {
                    e.printStackTrace();
                }
            }
        }
        return (SelfT) ayy();
    }

    @Override // com.baidu.swan.apps.u.c.e
    public String getVersionCode() {
        PMSAppInfo ayS = ayS();
        return ayS == null ? "" : ayS.versionName;
    }

    @Override // com.baidu.swan.apps.u.c.e
    public int getType() {
        PMSAppInfo ayS = ayS();
        if (ayS == null) {
            return 0;
        }
        return ayS.type;
    }

    @Override // com.baidu.swan.apps.u.c.e
    public long ayv() {
        PMSAppInfo ayS = ayS();
        if (ayS == null) {
            return 0L;
        }
        return ayS.pkgSize;
    }

    @Override // com.baidu.swan.apps.u.c.e
    public int getOrientation() {
        PMSAppInfo ayS = ayS();
        int orientation = ayS == null ? -1 : ayS.getOrientation();
        return -1 < orientation ? orientation : super.getOrientation();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.swan.apps.u.c.e
    /* renamed from: hL */
    public SelfT hM(int i) {
        PMSAppInfo ayS = ayS();
        if (ayS != null) {
            ayS.setOrientation(i);
            return (SelfT) super.hM(i);
        }
        return (SelfT) ayy();
    }

    @Override // com.baidu.swan.apps.u.c.e
    public long ayw() {
        return this.ddG;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.swan.apps.u.c.e
    /* renamed from: cj */
    public SelfT ck(long j) {
        if (this.ddG >= 1 || j <= 0) {
            return (SelfT) ayy();
        }
        this.ddG = j;
        return (SelfT) super.ck(j);
    }
}
