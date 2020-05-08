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
    private long bWM;

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
        /* renamed from: adv */
        public a adw() {
            return this;
        }
    }

    public static b s(Intent intent) {
        if (intent == null) {
            throw new IllegalArgumentException("intent must not be null.");
        }
        return new a().t(intent);
    }

    public SelfT t(Intent intent) {
        if (intent == null) {
            return (SelfT) adw();
        }
        B(intent.getExtras());
        if (d.u(intent)) {
            jN("1250000000000000");
        }
        return (SelfT) adw();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.swan.apps.x.b.a.c
    /* renamed from: A */
    public SelfT B(Bundle bundle) {
        if (bundle == null) {
            return (SelfT) adw();
        }
        com.baidu.swan.apps.console.debugger.b.n(bundle);
        super.B(bundle);
        if (TextUtils.isEmpty(bundle.getString("mPage"))) {
            jV("mPage");
        }
        return (SelfT) adw();
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

    public static b adj() {
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

    public JSONObject adk() {
        String adC = adC();
        if (adC != null) {
            String queryParameter = Uri.parse(adC).getQueryParameter("_swaninfo");
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

    public String YR() {
        return "SwanAppLaunchInfo{mAppId='" + getAppId() + "', mAppKey='" + getAppKey() + "', mAppTitle='" + YS() + "', pmsAppInfo is null='" + adR() + "', launchFrom='" + adA() + "', launchScheme='" + adC() + "', page='" + getPage() + "', mErrorCode=" + adm() + ", mErrorDetail='" + adn() + "', mErrorMsg='" + ado() + "', mResumeDate='" + adp() + "', maxSwanVersion='" + adD() + "', minSwanVersion='" + adE() + "', mVersion='" + getVersion() + "', mType=" + getType() + ", extraData=" + adF() + ", isDebug=" + isDebug() + ", targetSwanVersion='" + adL() + "', swanCoreVersion=" + YH() + ", appFrameType=" + getAppFrameType() + ", consoleSwitch=" + adM() + ", orientation=" + getOrientation() + ", versionCode='" + getVersionCode() + "', launchFlags=" + adN() + ", swanAppStartTime=" + adu() + ", extStartTimestamp=" + adO() + ", remoteDebug='" + adP() + "', extJSonObject=" + adS() + ", launchId=" + adT() + '}';
    }

    @Override // com.baidu.swan.apps.x.b.e
    public String YS() {
        PMSAppInfo adQ = adQ();
        return (adQ == null || TextUtils.isEmpty(adQ.appName)) ? super.YS() : adQ.appName;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.swan.apps.x.b.e
    /* renamed from: jx */
    public SelfT jM(String str) {
        PMSAppInfo adQ = adQ();
        if (adQ != null) {
            adQ.appName = str;
        }
        return (SelfT) super.jM(str);
    }

    @Override // com.baidu.swan.apps.x.b.e
    public String getAppKey() {
        PMSAppInfo adQ = adQ();
        return (adQ == null || TextUtils.isEmpty(adQ.appKey)) ? super.getAppKey() : adQ.appKey;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.swan.apps.x.b.e
    /* renamed from: jy */
    public SelfT jL(String str) {
        PMSAppInfo adQ = adQ();
        if (adQ != null) {
            adQ.appKey = str;
        }
        return (SelfT) super.jL(str);
    }

    @Override // com.baidu.swan.apps.x.b.e
    public String getAppId() {
        PMSAppInfo adQ = adQ();
        return (adQ == null || TextUtils.isEmpty(adQ.appId)) ? super.getAppId() : adQ.appId;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.swan.apps.x.b.e
    /* renamed from: jz */
    public SelfT jK(String str) {
        super.jK(str);
        PMSAppInfo adQ = adQ();
        if (adQ != null) {
            adQ.appId = str;
            return (SelfT) super.jK(str);
        }
        return (SelfT) adw();
    }

    @Override // com.baidu.swan.apps.x.b.e
    public String getIconUrl() {
        PMSAppInfo adQ = adQ();
        return (adQ == null || TextUtils.isEmpty(adQ.iconUrl)) ? super.getIconUrl() : adQ.iconUrl;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.swan.apps.x.b.e
    /* renamed from: jA */
    public SelfT jJ(String str) {
        super.jJ(str);
        PMSAppInfo adQ = adQ();
        if (adQ != null) {
            adQ.iconUrl = str;
            return (SelfT) super.jJ(str);
        }
        return (SelfT) adw();
    }

    @Override // com.baidu.swan.apps.x.b.e
    public String adl() {
        PMSAppInfo adQ = adQ();
        return adQ == null ? "" : adQ.description;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.swan.apps.x.b.e
    /* renamed from: jB */
    public SelfT jI(String str) {
        PMSAppInfo adQ = adQ();
        if (adQ != null) {
            adQ.description = str;
            return (SelfT) super.jI(str);
        }
        return (SelfT) adw();
    }

    @Override // com.baidu.swan.apps.x.b.e
    public int adm() {
        PMSAppInfo adQ = adQ();
        if (adQ == null) {
            return 0;
        }
        return adQ.appStatus;
    }

    @Override // com.baidu.swan.apps.x.b.e
    public String adn() {
        PMSAppInfo adQ = adQ();
        return adQ == null ? "" : adQ.statusDetail;
    }

    @Override // com.baidu.swan.apps.x.b.e
    public String ado() {
        PMSAppInfo adQ = adQ();
        return adQ == null ? "" : adQ.statusDesc;
    }

    @Override // com.baidu.swan.apps.x.b.e
    public String adp() {
        PMSAppInfo adQ = adQ();
        return adQ == null ? "" : adQ.resumeDate;
    }

    @Override // com.baidu.swan.apps.x.b.e
    public String adq() {
        PMSAppInfo adQ = adQ();
        return adQ == null ? "" : adQ.serviceCategory;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.swan.apps.x.b.e
    /* renamed from: jC */
    public SelfT jH(String str) {
        PMSAppInfo adQ = adQ();
        if (adQ != null) {
            adQ.serviceCategory = str;
            return (SelfT) super.jH(str);
        }
        return (SelfT) adw();
    }

    @Override // com.baidu.swan.apps.x.b.e
    public String adr() {
        PMSAppInfo adQ = adQ();
        return adQ == null ? "" : adQ.subjectInfo;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.swan.apps.x.b.e
    /* renamed from: jD */
    public SelfT jG(String str) {
        PMSAppInfo adQ = adQ();
        if (adQ != null) {
            adQ.subjectInfo = str;
            return (SelfT) super.jG(str);
        }
        return (SelfT) adw();
    }

    @Override // com.baidu.swan.apps.x.b.e
    public SwanAppBearInfo ads() {
        PMSAppInfo adQ = adQ();
        if (adQ == null) {
            return null;
        }
        String str = adQ.bearInfo;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return new SwanAppBearInfo(str);
    }

    @Override // com.baidu.swan.apps.x.b.e
    public String getVersion() {
        PMSAppInfo adQ = adQ();
        return adQ == null ? "" : String.valueOf(adQ.versionCode);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.swan.apps.x.b.e
    /* renamed from: jE */
    public SelfT jF(String str) {
        PMSAppInfo adQ = adQ();
        if (!TextUtils.isEmpty(str) && adQ != null) {
            try {
                adQ.versionCode = Integer.parseInt(str);
                return (SelfT) super.jF(str);
            } catch (NumberFormatException e) {
                if (DEBUG) {
                    e.printStackTrace();
                }
            }
        }
        return (SelfT) adw();
    }

    @Override // com.baidu.swan.apps.x.b.e
    public String getVersionCode() {
        PMSAppInfo adQ = adQ();
        return adQ == null ? "" : adQ.versionName;
    }

    @Override // com.baidu.swan.apps.x.b.e
    public int getType() {
        PMSAppInfo adQ = adQ();
        if (adQ == null) {
            return 0;
        }
        return adQ.type;
    }

    @Override // com.baidu.swan.apps.x.b.e
    public long adt() {
        PMSAppInfo adQ = adQ();
        if (adQ == null) {
            return 0L;
        }
        return adQ.pkgSize;
    }

    @Override // com.baidu.swan.apps.x.b.e
    public int getOrientation() {
        PMSAppInfo adQ = adQ();
        int orientation = adQ == null ? -1 : adQ.getOrientation();
        return -1 < orientation ? orientation : super.getOrientation();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.swan.apps.x.b.e
    /* renamed from: fm */
    public SelfT fn(int i) {
        PMSAppInfo adQ = adQ();
        if (adQ != null) {
            adQ.setOrientation(i);
            return (SelfT) super.fn(i);
        }
        return (SelfT) adw();
    }

    @Override // com.baidu.swan.apps.x.b.e
    public long adu() {
        return this.bWM;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.swan.apps.x.b.e
    /* renamed from: aM */
    public SelfT aN(long j) {
        if (this.bWM >= 1 || j <= 0) {
            return (SelfT) adw();
        }
        this.bWM = j;
        return (SelfT) super.aN(j);
    }
}
