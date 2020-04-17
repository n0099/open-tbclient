package com.baidu.swan.apps.x.b;

import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import com.baidu.swan.apps.as.ag;
import com.baidu.swan.apps.model.SwanAppBearInfo;
import com.baidu.swan.apps.runtime.config.SwanAppConfigData;
import com.baidu.swan.apps.x.b.b;
import com.baidu.swan.pms.model.PMSAppInfo;
import java.io.File;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public abstract class b<SelfT extends b<SelfT>> extends e<SelfT> {
    private long bWG;

    /* loaded from: classes11.dex */
    public static final class a extends b<a> {
        @Override // com.baidu.swan.apps.x.b.b, com.baidu.swan.apps.x.b.a.c
        public /* synthetic */ com.baidu.swan.apps.x.b.a.c B(Bundle bundle) {
            return super.B(bundle);
        }

        @Override // com.baidu.swan.apps.x.b.b, com.baidu.swan.apps.x.b.e
        public /* synthetic */ e aN(long j) {
            return super.aN(j);
        }

        @Override // com.baidu.swan.apps.x.b.b, com.baidu.swan.apps.x.b.e
        public /* synthetic */ e fn(int i) {
            return super.fn(i);
        }

        @Override // com.baidu.swan.apps.x.b.b, com.baidu.swan.apps.x.b.e
        public /* synthetic */ e jF(String str) {
            return super.jF(str);
        }

        @Override // com.baidu.swan.apps.x.b.b, com.baidu.swan.apps.x.b.e
        public /* synthetic */ e jG(String str) {
            return super.jG(str);
        }

        @Override // com.baidu.swan.apps.x.b.b, com.baidu.swan.apps.x.b.e
        public /* synthetic */ e jH(String str) {
            return super.jH(str);
        }

        @Override // com.baidu.swan.apps.x.b.b, com.baidu.swan.apps.x.b.e
        public /* synthetic */ e jI(String str) {
            return super.jI(str);
        }

        @Override // com.baidu.swan.apps.x.b.b, com.baidu.swan.apps.x.b.e
        public /* synthetic */ e jJ(String str) {
            return super.jJ(str);
        }

        @Override // com.baidu.swan.apps.x.b.b, com.baidu.swan.apps.x.b.e
        public /* synthetic */ e jK(String str) {
            return super.jK(str);
        }

        @Override // com.baidu.swan.apps.x.b.b, com.baidu.swan.apps.x.b.e
        public /* synthetic */ e jL(String str) {
            return super.jL(str);
        }

        @Override // com.baidu.swan.apps.x.b.b, com.baidu.swan.apps.x.b.e
        public /* synthetic */ e jM(String str) {
            return super.jM(str);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.apps.as.d.d
        /* renamed from: adw */
        public a adx() {
            return this;
        }
    }

    public static b F(Intent intent) {
        if (intent == null) {
            throw new IllegalArgumentException("intent must not be null.");
        }
        return new a().G(intent);
    }

    public SelfT G(Intent intent) {
        if (intent == null) {
            return (SelfT) adx();
        }
        B(intent.getExtras());
        if (d.H(intent)) {
            jN("1250000000000000");
        }
        return (SelfT) adx();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.swan.apps.x.b.a.c
    /* renamed from: A */
    public SelfT B(Bundle bundle) {
        if (bundle == null) {
            return (SelfT) adx();
        }
        com.baidu.swan.apps.console.debugger.b.n(bundle);
        super.B(bundle);
        if (TextUtils.isEmpty(bundle.getString("mPage"))) {
            jV("mPage");
        }
        return (SelfT) adx();
    }

    @Override // com.baidu.swan.apps.x.b.a.c
    public Bundle toBundle() {
        Bundle bundle = super.toBundle();
        com.baidu.swan.apps.console.debugger.b.o(bundle);
        String appId = getAppId();
        if (!TextUtils.isEmpty(appId)) {
            bundle.putString("mAppId", appId);
        }
        return bundle;
    }

    public static b adk() {
        a aVar = new a();
        aVar.jM("小程序测试");
        aVar.jK("wSfMyKIbrbNg7ogTFTcBuk1P8mgGTlB1");
        aVar.aO(Color.parseColor("#FF308EF0"));
        aVar.jN("1230000000000000");
        aVar.jI("小程序简介");
        aVar.jH("测试服务类目");
        aVar.jG("测试主体信息");
        aVar.jL("CdKRXT4IrCwTD6LIBS7DIlL8rmbKx58N");
        aVar.jF("1.0");
        aVar.jJ("https://gss3.bdstatic.com/9rkZsjib41gCpNKfpU_Y_D3/searchbox/aps/1516937209_WechatIMG147.jpeg");
        return aVar;
    }

    public static String a(b bVar, SwanAppConfigData swanAppConfigData) {
        String page = bVar.getPage();
        if (!TextUtils.isEmpty(page) && page.startsWith(File.separator)) {
            page = page.substring(1);
        }
        return a(page, swanAppConfigData);
    }

    private static String a(String str, SwanAppConfigData swanAppConfigData) {
        if (TextUtils.isEmpty(str) || swanAppConfigData == null) {
            return null;
        }
        if (swanAppConfigData.mo(ag.delAllParamsFromUrl(str))) {
            return str;
        }
        return null;
    }

    public JSONObject adl() {
        String adD = adD();
        if (adD != null) {
            String queryParameter = Uri.parse(adD).getQueryParameter("_swaninfo");
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

    public String YS() {
        return "SwanAppLaunchInfo{mAppId='" + getAppId() + "', mAppKey='" + getAppKey() + "', mAppTitle='" + YT() + "', pmsAppInfo is null='" + adS() + "', launchFrom='" + adB() + "', launchScheme='" + adD() + "', page='" + getPage() + "', mErrorCode=" + adn() + ", mErrorDetail='" + ado() + "', mErrorMsg='" + adp() + "', mResumeDate='" + adq() + "', maxSwanVersion='" + adE() + "', minSwanVersion='" + adF() + "', mVersion='" + getVersion() + "', mType=" + getType() + ", extraData=" + adG() + ", isDebug=" + isDebug() + ", targetSwanVersion='" + adM() + "', swanCoreVersion=" + YI() + ", appFrameType=" + getAppFrameType() + ", consoleSwitch=" + adN() + ", orientation=" + getOrientation() + ", versionCode='" + getVersionCode() + "', launchFlags=" + adO() + ", swanAppStartTime=" + adv() + ", extStartTimestamp=" + adP() + ", remoteDebug='" + adQ() + "', extJSonObject=" + adT() + ", launchId=" + adU() + '}';
    }

    @Override // com.baidu.swan.apps.x.b.e
    public String YT() {
        PMSAppInfo adR = adR();
        return (adR == null || TextUtils.isEmpty(adR.appName)) ? super.YT() : adR.appName;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.swan.apps.x.b.e
    /* renamed from: jx */
    public SelfT jM(String str) {
        PMSAppInfo adR = adR();
        if (adR != null) {
            adR.appName = str;
        }
        return (SelfT) super.jM(str);
    }

    @Override // com.baidu.swan.apps.x.b.e
    public String getAppKey() {
        PMSAppInfo adR = adR();
        return (adR == null || TextUtils.isEmpty(adR.appKey)) ? super.getAppKey() : adR.appKey;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.swan.apps.x.b.e
    /* renamed from: jy */
    public SelfT jL(String str) {
        PMSAppInfo adR = adR();
        if (adR != null) {
            adR.appKey = str;
        }
        return (SelfT) super.jL(str);
    }

    @Override // com.baidu.swan.apps.x.b.e
    public String getAppId() {
        PMSAppInfo adR = adR();
        return (adR == null || TextUtils.isEmpty(adR.appId)) ? super.getAppId() : adR.appId;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.swan.apps.x.b.e
    /* renamed from: jz */
    public SelfT jK(String str) {
        super.jK(str);
        PMSAppInfo adR = adR();
        if (adR != null) {
            adR.appId = str;
            return (SelfT) super.jK(str);
        }
        return (SelfT) adx();
    }

    @Override // com.baidu.swan.apps.x.b.e
    public String getIconUrl() {
        PMSAppInfo adR = adR();
        return (adR == null || TextUtils.isEmpty(adR.iconUrl)) ? super.getIconUrl() : adR.iconUrl;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.swan.apps.x.b.e
    /* renamed from: jA */
    public SelfT jJ(String str) {
        super.jJ(str);
        PMSAppInfo adR = adR();
        if (adR != null) {
            adR.iconUrl = str;
            return (SelfT) super.jJ(str);
        }
        return (SelfT) adx();
    }

    @Override // com.baidu.swan.apps.x.b.e
    public String adm() {
        PMSAppInfo adR = adR();
        return adR == null ? "" : adR.description;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.swan.apps.x.b.e
    /* renamed from: jB */
    public SelfT jI(String str) {
        PMSAppInfo adR = adR();
        if (adR != null) {
            adR.description = str;
            return (SelfT) super.jI(str);
        }
        return (SelfT) adx();
    }

    @Override // com.baidu.swan.apps.x.b.e
    public int adn() {
        PMSAppInfo adR = adR();
        if (adR == null) {
            return 0;
        }
        return adR.appStatus;
    }

    @Override // com.baidu.swan.apps.x.b.e
    public String ado() {
        PMSAppInfo adR = adR();
        return adR == null ? "" : adR.statusDetail;
    }

    @Override // com.baidu.swan.apps.x.b.e
    public String adp() {
        PMSAppInfo adR = adR();
        return adR == null ? "" : adR.statusDesc;
    }

    @Override // com.baidu.swan.apps.x.b.e
    public String adq() {
        PMSAppInfo adR = adR();
        return adR == null ? "" : adR.resumeDate;
    }

    @Override // com.baidu.swan.apps.x.b.e
    public String adr() {
        PMSAppInfo adR = adR();
        return adR == null ? "" : adR.serviceCategory;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.swan.apps.x.b.e
    /* renamed from: jC */
    public SelfT jH(String str) {
        PMSAppInfo adR = adR();
        if (adR != null) {
            adR.serviceCategory = str;
            return (SelfT) super.jH(str);
        }
        return (SelfT) adx();
    }

    @Override // com.baidu.swan.apps.x.b.e
    public String ads() {
        PMSAppInfo adR = adR();
        return adR == null ? "" : adR.subjectInfo;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.swan.apps.x.b.e
    /* renamed from: jD */
    public SelfT jG(String str) {
        PMSAppInfo adR = adR();
        if (adR != null) {
            adR.subjectInfo = str;
            return (SelfT) super.jG(str);
        }
        return (SelfT) adx();
    }

    @Override // com.baidu.swan.apps.x.b.e
    public SwanAppBearInfo adt() {
        PMSAppInfo adR = adR();
        if (adR == null) {
            return null;
        }
        String str = adR.bearInfo;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return new SwanAppBearInfo(str);
    }

    @Override // com.baidu.swan.apps.x.b.e
    public String getVersion() {
        PMSAppInfo adR = adR();
        return adR == null ? "" : String.valueOf(adR.versionCode);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.swan.apps.x.b.e
    /* renamed from: jE */
    public SelfT jF(String str) {
        PMSAppInfo adR = adR();
        if (!TextUtils.isEmpty(str) && adR != null) {
            try {
                adR.versionCode = Integer.parseInt(str);
                return (SelfT) super.jF(str);
            } catch (NumberFormatException e) {
                if (DEBUG) {
                    e.printStackTrace();
                }
            }
        }
        return (SelfT) adx();
    }

    @Override // com.baidu.swan.apps.x.b.e
    public String getVersionCode() {
        PMSAppInfo adR = adR();
        return adR == null ? "" : adR.versionName;
    }

    @Override // com.baidu.swan.apps.x.b.e
    public int getType() {
        PMSAppInfo adR = adR();
        if (adR == null) {
            return 0;
        }
        return adR.type;
    }

    @Override // com.baidu.swan.apps.x.b.e
    public long adu() {
        PMSAppInfo adR = adR();
        if (adR == null) {
            return 0L;
        }
        return adR.pkgSize;
    }

    @Override // com.baidu.swan.apps.x.b.e
    public int getOrientation() {
        PMSAppInfo adR = adR();
        int orientation = adR == null ? -1 : adR.getOrientation();
        return -1 < orientation ? orientation : super.getOrientation();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.swan.apps.x.b.e
    /* renamed from: fm */
    public SelfT fn(int i) {
        PMSAppInfo adR = adR();
        if (adR != null) {
            adR.setOrientation(i);
            return (SelfT) super.fn(i);
        }
        return (SelfT) adx();
    }

    @Override // com.baidu.swan.apps.x.b.e
    public long adv() {
        return this.bWG;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.swan.apps.x.b.e
    /* renamed from: aM */
    public SelfT aN(long j) {
        if (this.bWG >= 1 || j <= 0) {
            return (SelfT) adx();
        }
        this.bWG = j;
        return (SelfT) super.aN(j);
    }
}
