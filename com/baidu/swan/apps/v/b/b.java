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
    private long cma;

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
        public /* synthetic */ e fN(int i) {
            return super.fN(i);
        }

        @Override // com.baidu.swan.apps.v.b.b, com.baidu.swan.apps.v.b.e
        public /* synthetic */ e kZ(String str) {
            return super.kZ(str);
        }

        @Override // com.baidu.swan.apps.v.b.b, com.baidu.swan.apps.v.b.e
        public /* synthetic */ e la(String str) {
            return super.la(str);
        }

        @Override // com.baidu.swan.apps.v.b.b, com.baidu.swan.apps.v.b.e
        public /* synthetic */ e lb(String str) {
            return super.lb(str);
        }

        @Override // com.baidu.swan.apps.v.b.b, com.baidu.swan.apps.v.b.e
        public /* synthetic */ e lc(String str) {
            return super.lc(str);
        }

        @Override // com.baidu.swan.apps.v.b.b, com.baidu.swan.apps.v.b.e
        public /* synthetic */ e ld(String str) {
            return super.ld(str);
        }

        @Override // com.baidu.swan.apps.v.b.b, com.baidu.swan.apps.v.b.e
        public /* synthetic */ e le(String str) {
            return super.le(str);
        }

        @Override // com.baidu.swan.apps.v.b.b, com.baidu.swan.apps.v.b.e
        public /* synthetic */ e lf(String str) {
            return super.lf(str);
        }

        @Override // com.baidu.swan.apps.v.b.b, com.baidu.swan.apps.v.b.e
        public /* synthetic */ e lg(String str) {
            return super.lg(str);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.apps.aq.e.d
        /* renamed from: ahL */
        public a ahM() {
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
            return (SelfT) ahM();
        }
        E(intent.getExtras());
        if (d.t(intent)) {
            lh("1250000000000000");
        }
        return (SelfT) ahM();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.swan.apps.v.b.a.c
    /* renamed from: D */
    public SelfT E(Bundle bundle) {
        if (bundle == null) {
            return (SelfT) ahM();
        }
        com.baidu.swan.apps.console.debugger.b.p(bundle);
        i.amG().K(bundle);
        super.E(bundle);
        if (TextUtils.isEmpty(bundle.getString("mPage"))) {
            lp("mPage");
        }
        return (SelfT) ahM();
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

    public static b ahz() {
        a aVar = new a();
        aVar.lg("小程序测试");
        aVar.le("wSfMyKIbrbNg7ogTFTcBuk1P8mgGTlB1");
        aVar.aV(Color.parseColor("#FF308EF0"));
        aVar.lh("1230000000000000");
        aVar.lc("小程序简介");
        aVar.lb("测试服务类目");
        aVar.la("测试主体信息");
        aVar.lf("CdKRXT4IrCwTD6LIBS7DIlL8rmbKx58N");
        aVar.kZ("1.0");
        aVar.ld("https://gss3.bdstatic.com/9rkZsjib41gCpNKfpU_Y_D3/searchbox/aps/1516937209_WechatIMG147.jpeg");
        return aVar;
    }

    public static String a(b bVar, SwanAppConfigData swanAppConfigData) {
        return a(kQ(bVar.getPage()), swanAppConfigData);
    }

    public static String kQ(String str) {
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
        if (com.baidu.swan.apps.ae.b.a.mP(delAllParamsFromUrl)) {
            return ah.deleteQueryParam(str, com.baidu.swan.apps.scheme.a.a.cHX);
        }
        if (swanAppConfigData.nS(j.oq(delAllParamsFromUrl))) {
            return str;
        }
        return null;
    }

    public JSONObject ahA() {
        String ahS = ahS();
        if (ahS != null) {
            String queryParameter = Uri.parse(ahS).getQueryParameter("_swaninfo");
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

    public String acY() {
        return "SwanAppLaunchInfo{mAppId='" + getAppId() + "', mAppKey='" + getAppKey() + "', mAppTitle='" + acZ() + "', pmsAppInfo is null='" + aih() + "', launchFrom='" + ahQ() + "', launchScheme='" + ahS() + "', page='" + getPage() + "', mErrorCode=" + ahC() + ", mErrorDetail='" + ahD() + "', mErrorMsg='" + ahE() + "', mResumeDate='" + ahF() + "', maxSwanVersion='" + ahT() + "', minSwanVersion='" + ahU() + "', mVersion='" + getVersion() + "', mType=" + getType() + ", extraData=" + ahV() + ", isDebug=" + isDebug() + ", targetSwanVersion='" + aib() + "', swanCoreVersion=" + acM() + ", appFrameType=" + getAppFrameType() + ", consoleSwitch=" + aic() + ", orientation=" + getOrientation() + ", versionCode='" + getVersionCode() + "', launchFlags=" + aid() + ", swanAppStartTime=" + ahK() + ", extStartTimestamp=" + aie() + ", remoteDebug='" + aif() + "', extJSonObject=" + aii() + ", launchId=" + aij() + '}';
    }

    @Override // com.baidu.swan.apps.v.b.e
    public String acZ() {
        PMSAppInfo aig = aig();
        return (aig == null || TextUtils.isEmpty(aig.appName)) ? super.acZ() : aig.appName;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.swan.apps.v.b.e
    /* renamed from: kR */
    public SelfT lg(String str) {
        PMSAppInfo aig = aig();
        if (aig != null) {
            aig.appName = str;
        }
        return (SelfT) super.lg(str);
    }

    @Override // com.baidu.swan.apps.v.b.e
    public String getAppKey() {
        PMSAppInfo aig = aig();
        return (aig == null || TextUtils.isEmpty(aig.appKey)) ? super.getAppKey() : aig.appKey;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.swan.apps.v.b.e
    /* renamed from: kS */
    public SelfT lf(String str) {
        PMSAppInfo aig = aig();
        if (aig != null) {
            aig.appKey = str;
        }
        return (SelfT) super.lf(str);
    }

    @Override // com.baidu.swan.apps.v.b.e
    public String getAppId() {
        PMSAppInfo aig = aig();
        return (aig == null || TextUtils.isEmpty(aig.appId)) ? super.getAppId() : aig.appId;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.swan.apps.v.b.e
    /* renamed from: kT */
    public SelfT le(String str) {
        super.le(str);
        PMSAppInfo aig = aig();
        if (aig != null) {
            aig.appId = str;
            return (SelfT) super.le(str);
        }
        return (SelfT) ahM();
    }

    @Override // com.baidu.swan.apps.v.b.e
    public String getIconUrl() {
        PMSAppInfo aig = aig();
        return (aig == null || TextUtils.isEmpty(aig.iconUrl)) ? super.getIconUrl() : aig.iconUrl;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.swan.apps.v.b.e
    /* renamed from: kU */
    public SelfT ld(String str) {
        super.ld(str);
        PMSAppInfo aig = aig();
        if (aig != null) {
            aig.iconUrl = str;
            return (SelfT) super.ld(str);
        }
        return (SelfT) ahM();
    }

    @Override // com.baidu.swan.apps.v.b.e
    public String ahB() {
        PMSAppInfo aig = aig();
        return aig == null ? "" : aig.description;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.swan.apps.v.b.e
    /* renamed from: kV */
    public SelfT lc(String str) {
        PMSAppInfo aig = aig();
        if (aig != null) {
            aig.description = str;
            return (SelfT) super.lc(str);
        }
        return (SelfT) ahM();
    }

    @Override // com.baidu.swan.apps.v.b.e
    public int ahC() {
        PMSAppInfo aig = aig();
        if (aig == null) {
            return 0;
        }
        return aig.appStatus;
    }

    @Override // com.baidu.swan.apps.v.b.e
    public String ahD() {
        PMSAppInfo aig = aig();
        return aig == null ? "" : aig.statusDetail;
    }

    @Override // com.baidu.swan.apps.v.b.e
    public String ahE() {
        PMSAppInfo aig = aig();
        return aig == null ? "" : aig.statusDesc;
    }

    @Override // com.baidu.swan.apps.v.b.e
    public String ahF() {
        PMSAppInfo aig = aig();
        return aig == null ? "" : aig.resumeDate;
    }

    @Override // com.baidu.swan.apps.v.b.e
    public String ahG() {
        PMSAppInfo aig = aig();
        return aig == null ? "" : aig.serviceCategory;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.swan.apps.v.b.e
    /* renamed from: kW */
    public SelfT lb(String str) {
        PMSAppInfo aig = aig();
        if (aig != null) {
            aig.serviceCategory = str;
            return (SelfT) super.lb(str);
        }
        return (SelfT) ahM();
    }

    @Override // com.baidu.swan.apps.v.b.e
    public String ahH() {
        PMSAppInfo aig = aig();
        return aig == null ? "" : aig.subjectInfo;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.swan.apps.v.b.e
    /* renamed from: kX */
    public SelfT la(String str) {
        PMSAppInfo aig = aig();
        if (aig != null) {
            aig.subjectInfo = str;
            return (SelfT) super.la(str);
        }
        return (SelfT) ahM();
    }

    @Override // com.baidu.swan.apps.v.b.e
    public SwanAppBearInfo ahI() {
        PMSAppInfo aig = aig();
        if (aig == null) {
            return null;
        }
        String str = aig.bearInfo;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return new SwanAppBearInfo(str);
    }

    @Override // com.baidu.swan.apps.v.b.e
    public String getVersion() {
        PMSAppInfo aig = aig();
        return aig == null ? "" : String.valueOf(aig.versionCode);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.swan.apps.v.b.e
    /* renamed from: kY */
    public SelfT kZ(String str) {
        PMSAppInfo aig = aig();
        if (!TextUtils.isEmpty(str) && aig != null) {
            try {
                aig.versionCode = Integer.parseInt(str);
                return (SelfT) super.kZ(str);
            } catch (NumberFormatException e) {
                if (DEBUG) {
                    e.printStackTrace();
                }
            }
        }
        return (SelfT) ahM();
    }

    @Override // com.baidu.swan.apps.v.b.e
    public String getVersionCode() {
        PMSAppInfo aig = aig();
        return aig == null ? "" : aig.versionName;
    }

    @Override // com.baidu.swan.apps.v.b.e
    public int getType() {
        PMSAppInfo aig = aig();
        if (aig == null) {
            return 0;
        }
        return aig.type;
    }

    @Override // com.baidu.swan.apps.v.b.e
    public long ahJ() {
        PMSAppInfo aig = aig();
        if (aig == null) {
            return 0L;
        }
        return aig.pkgSize;
    }

    @Override // com.baidu.swan.apps.v.b.e
    public int getOrientation() {
        PMSAppInfo aig = aig();
        int orientation = aig == null ? -1 : aig.getOrientation();
        return -1 < orientation ? orientation : super.getOrientation();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.swan.apps.v.b.e
    /* renamed from: fM */
    public SelfT fN(int i) {
        PMSAppInfo aig = aig();
        if (aig != null) {
            aig.setOrientation(i);
            return (SelfT) super.fN(i);
        }
        return (SelfT) ahM();
    }

    @Override // com.baidu.swan.apps.v.b.e
    public long ahK() {
        return this.cma;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.swan.apps.v.b.e
    /* renamed from: aT */
    public SelfT aU(long j) {
        if (this.cma >= 1 || j <= 0) {
            return (SelfT) ahM();
        }
        this.cma = j;
        return (SelfT) super.aU(j);
    }
}
