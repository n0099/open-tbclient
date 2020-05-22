package com.baidu.swan.apps.v.b;

import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import com.baidu.swan.apps.aq.ah;
import com.baidu.swan.apps.model.SwanAppBearInfo;
import com.baidu.swan.apps.performance.i;
import com.baidu.swan.apps.runtime.config.SwanAppConfigData;
import com.baidu.swan.apps.scheme.actions.k.j;
import com.baidu.swan.apps.v.b.b;
import com.baidu.swan.pms.model.PMSAppInfo;
import java.io.File;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public abstract class b<SelfT extends b<SelfT>> extends e<SelfT> {
    private long chm;

    /* loaded from: classes11.dex */
    public static final class a extends b<a> {
        @Override // com.baidu.swan.apps.v.b.b, com.baidu.swan.apps.v.b.a.c
        public /* synthetic */ com.baidu.swan.apps.v.b.a.c E(Bundle bundle) {
            return super.E(bundle);
        }

        @Override // com.baidu.swan.apps.v.b.b, com.baidu.swan.apps.v.b.e
        public /* synthetic */ e aU(long j) {
            return super.aU(j);
        }

        @Override // com.baidu.swan.apps.v.b.b, com.baidu.swan.apps.v.b.e
        public /* synthetic */ e fA(int i) {
            return super.fA(i);
        }

        @Override // com.baidu.swan.apps.v.b.b, com.baidu.swan.apps.v.b.e
        public /* synthetic */ e kR(String str) {
            return super.kR(str);
        }

        @Override // com.baidu.swan.apps.v.b.b, com.baidu.swan.apps.v.b.e
        public /* synthetic */ e kS(String str) {
            return super.kS(str);
        }

        @Override // com.baidu.swan.apps.v.b.b, com.baidu.swan.apps.v.b.e
        public /* synthetic */ e kT(String str) {
            return super.kT(str);
        }

        @Override // com.baidu.swan.apps.v.b.b, com.baidu.swan.apps.v.b.e
        public /* synthetic */ e kU(String str) {
            return super.kU(str);
        }

        @Override // com.baidu.swan.apps.v.b.b, com.baidu.swan.apps.v.b.e
        public /* synthetic */ e kV(String str) {
            return super.kV(str);
        }

        @Override // com.baidu.swan.apps.v.b.b, com.baidu.swan.apps.v.b.e
        public /* synthetic */ e kW(String str) {
            return super.kW(str);
        }

        @Override // com.baidu.swan.apps.v.b.b, com.baidu.swan.apps.v.b.e
        public /* synthetic */ e kX(String str) {
            return super.kX(str);
        }

        @Override // com.baidu.swan.apps.v.b.b, com.baidu.swan.apps.v.b.e
        public /* synthetic */ e kY(String str) {
            return super.kY(str);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.apps.aq.e.d
        /* renamed from: agF */
        public a agG() {
            return this;
        }
    }

    public static b r(Intent intent) {
        if (intent == null) {
            throw new IllegalArgumentException("intent must not be null.");
        }
        return new a().s(intent);
    }

    public SelfT s(Intent intent) {
        if (intent == null) {
            return (SelfT) agG();
        }
        E(intent.getExtras());
        if (d.t(intent)) {
            kZ("1250000000000000");
        }
        return (SelfT) agG();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.swan.apps.v.b.a.c
    /* renamed from: D */
    public SelfT E(Bundle bundle) {
        if (bundle == null) {
            return (SelfT) agG();
        }
        com.baidu.swan.apps.console.debugger.b.p(bundle);
        i.alA().K(bundle);
        super.E(bundle);
        if (TextUtils.isEmpty(bundle.getString("mPage"))) {
            lh("mPage");
        }
        return (SelfT) agG();
    }

    @Override // com.baidu.swan.apps.v.b.a.c
    public Bundle toBundle() {
        Bundle bundle = super.toBundle();
        com.baidu.swan.apps.console.debugger.b.q(bundle);
        String appId = getAppId();
        if (!TextUtils.isEmpty(appId)) {
            bundle.putString("mAppId", appId);
        }
        return bundle;
    }

    public static b agt() {
        a aVar = new a();
        aVar.kY("小程序测试");
        aVar.kW("wSfMyKIbrbNg7ogTFTcBuk1P8mgGTlB1");
        aVar.aV(Color.parseColor("#FF308EF0"));
        aVar.kZ("1230000000000000");
        aVar.kU("小程序简介");
        aVar.kT("测试服务类目");
        aVar.kS("测试主体信息");
        aVar.kX("CdKRXT4IrCwTD6LIBS7DIlL8rmbKx58N");
        aVar.kR("1.0");
        aVar.kV("https://gss3.bdstatic.com/9rkZsjib41gCpNKfpU_Y_D3/searchbox/aps/1516937209_WechatIMG147.jpeg");
        return aVar;
    }

    public static String a(b bVar, SwanAppConfigData swanAppConfigData) {
        return a(kI(bVar.getPage()), swanAppConfigData);
    }

    public static String kI(String str) {
        if (!TextUtils.isEmpty(str) && str.startsWith(File.separator)) {
            return str.substring(1);
        }
        return str;
    }

    private static String a(String str, SwanAppConfigData swanAppConfigData) {
        if (TextUtils.isEmpty(str) || swanAppConfigData == null) {
            return null;
        }
        String delAllParamsFromUrl = ah.delAllParamsFromUrl(str);
        if (com.baidu.swan.apps.ae.b.a.mH(delAllParamsFromUrl)) {
            return ah.deleteQueryParam(str, com.baidu.swan.apps.scheme.a.a.cDn);
        }
        if (swanAppConfigData.nK(j.oh(delAllParamsFromUrl))) {
            return str;
        }
        return null;
    }

    public JSONObject agu() {
        String agM = agM();
        if (agM != null) {
            String queryParameter = Uri.parse(agM).getQueryParameter("_swaninfo");
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

    public String abS() {
        return "SwanAppLaunchInfo{mAppId='" + getAppId() + "', mAppKey='" + getAppKey() + "', mAppTitle='" + abT() + "', pmsAppInfo is null='" + ahb() + "', launchFrom='" + agK() + "', launchScheme='" + agM() + "', page='" + getPage() + "', mErrorCode=" + agw() + ", mErrorDetail='" + agx() + "', mErrorMsg='" + agy() + "', mResumeDate='" + agz() + "', maxSwanVersion='" + agN() + "', minSwanVersion='" + agO() + "', mVersion='" + getVersion() + "', mType=" + getType() + ", extraData=" + agP() + ", isDebug=" + isDebug() + ", targetSwanVersion='" + agV() + "', swanCoreVersion=" + abG() + ", appFrameType=" + getAppFrameType() + ", consoleSwitch=" + agW() + ", orientation=" + getOrientation() + ", versionCode='" + getVersionCode() + "', launchFlags=" + agX() + ", swanAppStartTime=" + agE() + ", extStartTimestamp=" + agY() + ", remoteDebug='" + agZ() + "', extJSonObject=" + ahc() + ", launchId=" + ahd() + '}';
    }

    @Override // com.baidu.swan.apps.v.b.e
    public String abT() {
        PMSAppInfo aha = aha();
        return (aha == null || TextUtils.isEmpty(aha.appName)) ? super.abT() : aha.appName;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.swan.apps.v.b.e
    /* renamed from: kJ */
    public SelfT kY(String str) {
        PMSAppInfo aha = aha();
        if (aha != null) {
            aha.appName = str;
        }
        return (SelfT) super.kY(str);
    }

    @Override // com.baidu.swan.apps.v.b.e
    public String getAppKey() {
        PMSAppInfo aha = aha();
        return (aha == null || TextUtils.isEmpty(aha.appKey)) ? super.getAppKey() : aha.appKey;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.swan.apps.v.b.e
    /* renamed from: kK */
    public SelfT kX(String str) {
        PMSAppInfo aha = aha();
        if (aha != null) {
            aha.appKey = str;
        }
        return (SelfT) super.kX(str);
    }

    @Override // com.baidu.swan.apps.v.b.e
    public String getAppId() {
        PMSAppInfo aha = aha();
        return (aha == null || TextUtils.isEmpty(aha.appId)) ? super.getAppId() : aha.appId;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.swan.apps.v.b.e
    /* renamed from: kL */
    public SelfT kW(String str) {
        super.kW(str);
        PMSAppInfo aha = aha();
        if (aha != null) {
            aha.appId = str;
            return (SelfT) super.kW(str);
        }
        return (SelfT) agG();
    }

    @Override // com.baidu.swan.apps.v.b.e
    public String getIconUrl() {
        PMSAppInfo aha = aha();
        return (aha == null || TextUtils.isEmpty(aha.iconUrl)) ? super.getIconUrl() : aha.iconUrl;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.swan.apps.v.b.e
    /* renamed from: kM */
    public SelfT kV(String str) {
        super.kV(str);
        PMSAppInfo aha = aha();
        if (aha != null) {
            aha.iconUrl = str;
            return (SelfT) super.kV(str);
        }
        return (SelfT) agG();
    }

    @Override // com.baidu.swan.apps.v.b.e
    public String agv() {
        PMSAppInfo aha = aha();
        return aha == null ? "" : aha.description;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.swan.apps.v.b.e
    /* renamed from: kN */
    public SelfT kU(String str) {
        PMSAppInfo aha = aha();
        if (aha != null) {
            aha.description = str;
            return (SelfT) super.kU(str);
        }
        return (SelfT) agG();
    }

    @Override // com.baidu.swan.apps.v.b.e
    public int agw() {
        PMSAppInfo aha = aha();
        if (aha == null) {
            return 0;
        }
        return aha.appStatus;
    }

    @Override // com.baidu.swan.apps.v.b.e
    public String agx() {
        PMSAppInfo aha = aha();
        return aha == null ? "" : aha.statusDetail;
    }

    @Override // com.baidu.swan.apps.v.b.e
    public String agy() {
        PMSAppInfo aha = aha();
        return aha == null ? "" : aha.statusDesc;
    }

    @Override // com.baidu.swan.apps.v.b.e
    public String agz() {
        PMSAppInfo aha = aha();
        return aha == null ? "" : aha.resumeDate;
    }

    @Override // com.baidu.swan.apps.v.b.e
    public String agA() {
        PMSAppInfo aha = aha();
        return aha == null ? "" : aha.serviceCategory;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.swan.apps.v.b.e
    /* renamed from: kO */
    public SelfT kT(String str) {
        PMSAppInfo aha = aha();
        if (aha != null) {
            aha.serviceCategory = str;
            return (SelfT) super.kT(str);
        }
        return (SelfT) agG();
    }

    @Override // com.baidu.swan.apps.v.b.e
    public String agB() {
        PMSAppInfo aha = aha();
        return aha == null ? "" : aha.subjectInfo;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.swan.apps.v.b.e
    /* renamed from: kP */
    public SelfT kS(String str) {
        PMSAppInfo aha = aha();
        if (aha != null) {
            aha.subjectInfo = str;
            return (SelfT) super.kS(str);
        }
        return (SelfT) agG();
    }

    @Override // com.baidu.swan.apps.v.b.e
    public SwanAppBearInfo agC() {
        PMSAppInfo aha = aha();
        if (aha == null) {
            return null;
        }
        String str = aha.bearInfo;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return new SwanAppBearInfo(str);
    }

    @Override // com.baidu.swan.apps.v.b.e
    public String getVersion() {
        PMSAppInfo aha = aha();
        return aha == null ? "" : String.valueOf(aha.versionCode);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.swan.apps.v.b.e
    /* renamed from: kQ */
    public SelfT kR(String str) {
        PMSAppInfo aha = aha();
        if (!TextUtils.isEmpty(str) && aha != null) {
            try {
                aha.versionCode = Integer.parseInt(str);
                return (SelfT) super.kR(str);
            } catch (NumberFormatException e) {
                if (DEBUG) {
                    e.printStackTrace();
                }
            }
        }
        return (SelfT) agG();
    }

    @Override // com.baidu.swan.apps.v.b.e
    public String getVersionCode() {
        PMSAppInfo aha = aha();
        return aha == null ? "" : aha.versionName;
    }

    @Override // com.baidu.swan.apps.v.b.e
    public int getType() {
        PMSAppInfo aha = aha();
        if (aha == null) {
            return 0;
        }
        return aha.type;
    }

    @Override // com.baidu.swan.apps.v.b.e
    public long agD() {
        PMSAppInfo aha = aha();
        if (aha == null) {
            return 0L;
        }
        return aha.pkgSize;
    }

    @Override // com.baidu.swan.apps.v.b.e
    public int getOrientation() {
        PMSAppInfo aha = aha();
        int orientation = aha == null ? -1 : aha.getOrientation();
        return -1 < orientation ? orientation : super.getOrientation();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.swan.apps.v.b.e
    /* renamed from: fz */
    public SelfT fA(int i) {
        PMSAppInfo aha = aha();
        if (aha != null) {
            aha.setOrientation(i);
            return (SelfT) super.fA(i);
        }
        return (SelfT) agG();
    }

    @Override // com.baidu.swan.apps.v.b.e
    public long agE() {
        return this.chm;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.swan.apps.v.b.e
    /* renamed from: aT */
    public SelfT aU(long j) {
        if (this.chm >= 1 || j <= 0) {
            return (SelfT) agG();
        }
        this.chm = j;
        return (SelfT) super.aU(j);
    }
}
