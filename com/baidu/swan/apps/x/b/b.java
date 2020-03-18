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
    private long byA;

    /* loaded from: classes11.dex */
    public static final class a extends b<a> {
        @Override // com.baidu.swan.apps.x.b.b, com.baidu.swan.apps.x.b.a.c
        public /* synthetic */ com.baidu.swan.apps.x.b.a.c B(Bundle bundle) {
            return super.B(bundle);
        }

        @Override // com.baidu.swan.apps.x.b.b, com.baidu.swan.apps.x.b.e
        public /* synthetic */ e aj(long j) {
            return super.aj(j);
        }

        @Override // com.baidu.swan.apps.x.b.b, com.baidu.swan.apps.x.b.e
        public /* synthetic */ e fi(int i) {
            return super.fi(i);
        }

        @Override // com.baidu.swan.apps.x.b.b, com.baidu.swan.apps.x.b.e
        public /* synthetic */ e is(String str) {
            return super.is(str);
        }

        @Override // com.baidu.swan.apps.x.b.b, com.baidu.swan.apps.x.b.e
        public /* synthetic */ e it(String str) {
            return super.it(str);
        }

        @Override // com.baidu.swan.apps.x.b.b, com.baidu.swan.apps.x.b.e
        public /* synthetic */ e iu(String str) {
            return super.iu(str);
        }

        @Override // com.baidu.swan.apps.x.b.b, com.baidu.swan.apps.x.b.e
        public /* synthetic */ e iv(String str) {
            return super.iv(str);
        }

        @Override // com.baidu.swan.apps.x.b.b, com.baidu.swan.apps.x.b.e
        public /* synthetic */ e iw(String str) {
            return super.iw(str);
        }

        @Override // com.baidu.swan.apps.x.b.b, com.baidu.swan.apps.x.b.e
        public /* synthetic */ e ix(String str) {
            return super.ix(str);
        }

        @Override // com.baidu.swan.apps.x.b.b, com.baidu.swan.apps.x.b.e
        public /* synthetic */ e iy(String str) {
            return super.iy(str);
        }

        @Override // com.baidu.swan.apps.x.b.b, com.baidu.swan.apps.x.b.e
        public /* synthetic */ e iz(String str) {
            return super.iz(str);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.apps.as.d.d
        /* renamed from: VH */
        public a VI() {
            return this;
        }
    }

    public static b G(Intent intent) {
        if (intent == null) {
            throw new IllegalArgumentException("intent must not be null.");
        }
        return new a().H(intent);
    }

    public SelfT H(Intent intent) {
        if (intent == null) {
            return (SelfT) VI();
        }
        B(intent.getExtras());
        if (d.I(intent)) {
            iA("1250000000000000");
        }
        return (SelfT) VI();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.swan.apps.x.b.a.c
    /* renamed from: A */
    public SelfT B(Bundle bundle) {
        if (bundle == null) {
            return (SelfT) VI();
        }
        com.baidu.swan.apps.console.debugger.b.n(bundle);
        super.B(bundle);
        if (TextUtils.isEmpty(bundle.getString("mPage"))) {
            iI("mPage");
        }
        return (SelfT) VI();
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

    public static b Vv() {
        a aVar = new a();
        aVar.iz("小程序测试");
        aVar.ix("wSfMyKIbrbNg7ogTFTcBuk1P8mgGTlB1");
        aVar.ak(Color.parseColor("#FF308EF0"));
        aVar.iA("1230000000000000");
        aVar.iv("小程序简介");
        aVar.iu("测试服务类目");
        aVar.it("测试主体信息");
        aVar.iy("CdKRXT4IrCwTD6LIBS7DIlL8rmbKx58N");
        aVar.is("1.0");
        aVar.iw("https://gss3.bdstatic.com/9rkZsjib41gCpNKfpU_Y_D3/searchbox/aps/1516937209_WechatIMG147.jpeg");
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
        if (swanAppConfigData.lb(ag.delAllParamsFromUrl(str))) {
            return str;
        }
        return null;
    }

    public JSONObject Vw() {
        String VO = VO();
        if (VO != null) {
            String queryParameter = Uri.parse(VO).getQueryParameter("_swaninfo");
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

    public String Rd() {
        return "SwanAppLaunchInfo{mAppId='" + getAppId() + "', mAppKey='" + getAppKey() + "', mAppTitle='" + Re() + "', pmsAppInfo is null='" + Wd() + "', launchFrom='" + VM() + "', launchScheme='" + VO() + "', page='" + getPage() + "', mErrorCode=" + Vy() + ", mErrorDetail='" + Vz() + "', mErrorMsg='" + VA() + "', mResumeDate='" + VB() + "', maxSwanVersion='" + VP() + "', minSwanVersion='" + VQ() + "', mVersion='" + getVersion() + "', mType=" + getType() + ", extraData=" + VR() + ", isDebug=" + isDebug() + ", targetSwanVersion='" + VX() + "', swanCoreVersion=" + QT() + ", appFrameType=" + getAppFrameType() + ", consoleSwitch=" + VY() + ", orientation=" + getOrientation() + ", versionCode='" + getVersionCode() + "', launchFlags=" + VZ() + ", swanAppStartTime=" + VG() + ", extStartTimestamp=" + Wa() + ", remoteDebug='" + Wb() + "', extJSonObject=" + We() + ", launchId=" + Wf() + '}';
    }

    @Override // com.baidu.swan.apps.x.b.e
    public String Re() {
        PMSAppInfo Wc = Wc();
        return (Wc == null || TextUtils.isEmpty(Wc.appName)) ? super.Re() : Wc.appName;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.swan.apps.x.b.e
    /* renamed from: ik */
    public SelfT iz(String str) {
        PMSAppInfo Wc = Wc();
        if (Wc != null) {
            Wc.appName = str;
        }
        return (SelfT) super.iz(str);
    }

    @Override // com.baidu.swan.apps.x.b.e
    public String getAppKey() {
        PMSAppInfo Wc = Wc();
        return (Wc == null || TextUtils.isEmpty(Wc.appKey)) ? super.getAppKey() : Wc.appKey;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.swan.apps.x.b.e
    /* renamed from: il */
    public SelfT iy(String str) {
        PMSAppInfo Wc = Wc();
        if (Wc != null) {
            Wc.appKey = str;
        }
        return (SelfT) super.iy(str);
    }

    @Override // com.baidu.swan.apps.x.b.e
    public String getAppId() {
        PMSAppInfo Wc = Wc();
        return (Wc == null || TextUtils.isEmpty(Wc.appId)) ? super.getAppId() : Wc.appId;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.swan.apps.x.b.e
    /* renamed from: im */
    public SelfT ix(String str) {
        super.ix(str);
        PMSAppInfo Wc = Wc();
        if (Wc != null) {
            Wc.appId = str;
            return (SelfT) super.ix(str);
        }
        return (SelfT) VI();
    }

    @Override // com.baidu.swan.apps.x.b.e
    public String getIconUrl() {
        PMSAppInfo Wc = Wc();
        return (Wc == null || TextUtils.isEmpty(Wc.iconUrl)) ? super.getIconUrl() : Wc.iconUrl;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.swan.apps.x.b.e
    /* renamed from: in */
    public SelfT iw(String str) {
        super.iw(str);
        PMSAppInfo Wc = Wc();
        if (Wc != null) {
            Wc.iconUrl = str;
            return (SelfT) super.iw(str);
        }
        return (SelfT) VI();
    }

    @Override // com.baidu.swan.apps.x.b.e
    public String Vx() {
        PMSAppInfo Wc = Wc();
        return Wc == null ? "" : Wc.description;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.swan.apps.x.b.e
    /* renamed from: io */
    public SelfT iv(String str) {
        PMSAppInfo Wc = Wc();
        if (Wc != null) {
            Wc.description = str;
            return (SelfT) super.iv(str);
        }
        return (SelfT) VI();
    }

    @Override // com.baidu.swan.apps.x.b.e
    public int Vy() {
        PMSAppInfo Wc = Wc();
        if (Wc == null) {
            return 0;
        }
        return Wc.appStatus;
    }

    @Override // com.baidu.swan.apps.x.b.e
    public String Vz() {
        PMSAppInfo Wc = Wc();
        return Wc == null ? "" : Wc.statusDetail;
    }

    @Override // com.baidu.swan.apps.x.b.e
    public String VA() {
        PMSAppInfo Wc = Wc();
        return Wc == null ? "" : Wc.statusDesc;
    }

    @Override // com.baidu.swan.apps.x.b.e
    public String VB() {
        PMSAppInfo Wc = Wc();
        return Wc == null ? "" : Wc.resumeDate;
    }

    @Override // com.baidu.swan.apps.x.b.e
    public String VC() {
        PMSAppInfo Wc = Wc();
        return Wc == null ? "" : Wc.serviceCategory;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.swan.apps.x.b.e
    /* renamed from: ip */
    public SelfT iu(String str) {
        PMSAppInfo Wc = Wc();
        if (Wc != null) {
            Wc.serviceCategory = str;
            return (SelfT) super.iu(str);
        }
        return (SelfT) VI();
    }

    @Override // com.baidu.swan.apps.x.b.e
    public String VD() {
        PMSAppInfo Wc = Wc();
        return Wc == null ? "" : Wc.subjectInfo;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.swan.apps.x.b.e
    /* renamed from: iq */
    public SelfT it(String str) {
        PMSAppInfo Wc = Wc();
        if (Wc != null) {
            Wc.subjectInfo = str;
            return (SelfT) super.it(str);
        }
        return (SelfT) VI();
    }

    @Override // com.baidu.swan.apps.x.b.e
    public SwanAppBearInfo VE() {
        PMSAppInfo Wc = Wc();
        if (Wc == null) {
            return null;
        }
        String str = Wc.bearInfo;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return new SwanAppBearInfo(str);
    }

    @Override // com.baidu.swan.apps.x.b.e
    public String getVersion() {
        PMSAppInfo Wc = Wc();
        return Wc == null ? "" : String.valueOf(Wc.versionCode);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.swan.apps.x.b.e
    /* renamed from: ir */
    public SelfT is(String str) {
        PMSAppInfo Wc = Wc();
        if (!TextUtils.isEmpty(str) && Wc != null) {
            try {
                Wc.versionCode = Integer.parseInt(str);
                return (SelfT) super.is(str);
            } catch (NumberFormatException e) {
                if (DEBUG) {
                    e.printStackTrace();
                }
            }
        }
        return (SelfT) VI();
    }

    @Override // com.baidu.swan.apps.x.b.e
    public String getVersionCode() {
        PMSAppInfo Wc = Wc();
        return Wc == null ? "" : Wc.versionName;
    }

    @Override // com.baidu.swan.apps.x.b.e
    public int getType() {
        PMSAppInfo Wc = Wc();
        if (Wc == null) {
            return 0;
        }
        return Wc.type;
    }

    @Override // com.baidu.swan.apps.x.b.e
    public long VF() {
        PMSAppInfo Wc = Wc();
        if (Wc == null) {
            return 0L;
        }
        return Wc.pkgSize;
    }

    @Override // com.baidu.swan.apps.x.b.e
    public int getOrientation() {
        PMSAppInfo Wc = Wc();
        int orientation = Wc == null ? -1 : Wc.getOrientation();
        return -1 < orientation ? orientation : super.getOrientation();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.swan.apps.x.b.e
    /* renamed from: fh */
    public SelfT fi(int i) {
        PMSAppInfo Wc = Wc();
        if (Wc != null) {
            Wc.setOrientation(i);
            return (SelfT) super.fi(i);
        }
        return (SelfT) VI();
    }

    @Override // com.baidu.swan.apps.x.b.e
    public long VG() {
        return this.byA;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.swan.apps.x.b.e
    /* renamed from: ai */
    public SelfT aj(long j) {
        if (this.byA >= 1 || j <= 0) {
            return (SelfT) VI();
        }
        this.byA = j;
        return (SelfT) super.aj(j);
    }
}
