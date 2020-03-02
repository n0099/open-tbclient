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
    private long byo;

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
        public /* synthetic */ e iA(String str) {
            return super.iA(str);
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
        /* renamed from: VE */
        public a VF() {
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
            return (SelfT) VF();
        }
        B(intent.getExtras());
        if (d.I(intent)) {
            iB("1250000000000000");
        }
        return (SelfT) VF();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.swan.apps.x.b.a.c
    /* renamed from: A */
    public SelfT B(Bundle bundle) {
        if (bundle == null) {
            return (SelfT) VF();
        }
        com.baidu.swan.apps.console.debugger.b.n(bundle);
        super.B(bundle);
        if (TextUtils.isEmpty(bundle.getString("mPage"))) {
            iJ("mPage");
        }
        return (SelfT) VF();
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

    public static b Vs() {
        a aVar = new a();
        aVar.iA("小程序测试");
        aVar.iy("wSfMyKIbrbNg7ogTFTcBuk1P8mgGTlB1");
        aVar.ak(Color.parseColor("#FF308EF0"));
        aVar.iB("1230000000000000");
        aVar.iw("小程序简介");
        aVar.iv("测试服务类目");
        aVar.iu("测试主体信息");
        aVar.iz("CdKRXT4IrCwTD6LIBS7DIlL8rmbKx58N");
        aVar.it("1.0");
        aVar.ix("https://gss3.bdstatic.com/9rkZsjib41gCpNKfpU_Y_D3/searchbox/aps/1516937209_WechatIMG147.jpeg");
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
        if (swanAppConfigData.lc(ag.delAllParamsFromUrl(str))) {
            return str;
        }
        return null;
    }

    public JSONObject Vt() {
        String VL = VL();
        if (VL != null) {
            String queryParameter = Uri.parse(VL).getQueryParameter("_swaninfo");
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

    public String Ra() {
        return "SwanAppLaunchInfo{mAppId='" + getAppId() + "', mAppKey='" + getAppKey() + "', mAppTitle='" + Rb() + "', pmsAppInfo is null='" + Wa() + "', launchFrom='" + VJ() + "', launchScheme='" + VL() + "', page='" + getPage() + "', mErrorCode=" + Vv() + ", mErrorDetail='" + Vw() + "', mErrorMsg='" + Vx() + "', mResumeDate='" + Vy() + "', maxSwanVersion='" + VM() + "', minSwanVersion='" + VN() + "', mVersion='" + getVersion() + "', mType=" + getType() + ", extraData=" + VO() + ", isDebug=" + isDebug() + ", targetSwanVersion='" + VU() + "', swanCoreVersion=" + QQ() + ", appFrameType=" + getAppFrameType() + ", consoleSwitch=" + VV() + ", orientation=" + getOrientation() + ", versionCode='" + getVersionCode() + "', launchFlags=" + VW() + ", swanAppStartTime=" + VD() + ", extStartTimestamp=" + VX() + ", remoteDebug='" + VY() + "', extJSonObject=" + Wb() + ", launchId=" + Wc() + '}';
    }

    @Override // com.baidu.swan.apps.x.b.e
    public String Rb() {
        PMSAppInfo VZ = VZ();
        return (VZ == null || TextUtils.isEmpty(VZ.appName)) ? super.Rb() : VZ.appName;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.swan.apps.x.b.e
    /* renamed from: il */
    public SelfT iA(String str) {
        PMSAppInfo VZ = VZ();
        if (VZ != null) {
            VZ.appName = str;
        }
        return (SelfT) super.iA(str);
    }

    @Override // com.baidu.swan.apps.x.b.e
    public String getAppKey() {
        PMSAppInfo VZ = VZ();
        return (VZ == null || TextUtils.isEmpty(VZ.appKey)) ? super.getAppKey() : VZ.appKey;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.swan.apps.x.b.e
    /* renamed from: im */
    public SelfT iz(String str) {
        PMSAppInfo VZ = VZ();
        if (VZ != null) {
            VZ.appKey = str;
        }
        return (SelfT) super.iz(str);
    }

    @Override // com.baidu.swan.apps.x.b.e
    public String getAppId() {
        PMSAppInfo VZ = VZ();
        return (VZ == null || TextUtils.isEmpty(VZ.appId)) ? super.getAppId() : VZ.appId;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.swan.apps.x.b.e
    /* renamed from: in */
    public SelfT iy(String str) {
        super.iy(str);
        PMSAppInfo VZ = VZ();
        if (VZ != null) {
            VZ.appId = str;
            return (SelfT) super.iy(str);
        }
        return (SelfT) VF();
    }

    @Override // com.baidu.swan.apps.x.b.e
    public String getIconUrl() {
        PMSAppInfo VZ = VZ();
        return (VZ == null || TextUtils.isEmpty(VZ.iconUrl)) ? super.getIconUrl() : VZ.iconUrl;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.swan.apps.x.b.e
    /* renamed from: io */
    public SelfT ix(String str) {
        super.ix(str);
        PMSAppInfo VZ = VZ();
        if (VZ != null) {
            VZ.iconUrl = str;
            return (SelfT) super.ix(str);
        }
        return (SelfT) VF();
    }

    @Override // com.baidu.swan.apps.x.b.e
    public String Vu() {
        PMSAppInfo VZ = VZ();
        return VZ == null ? "" : VZ.description;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.swan.apps.x.b.e
    /* renamed from: ip */
    public SelfT iw(String str) {
        PMSAppInfo VZ = VZ();
        if (VZ != null) {
            VZ.description = str;
            return (SelfT) super.iw(str);
        }
        return (SelfT) VF();
    }

    @Override // com.baidu.swan.apps.x.b.e
    public int Vv() {
        PMSAppInfo VZ = VZ();
        if (VZ == null) {
            return 0;
        }
        return VZ.appStatus;
    }

    @Override // com.baidu.swan.apps.x.b.e
    public String Vw() {
        PMSAppInfo VZ = VZ();
        return VZ == null ? "" : VZ.statusDetail;
    }

    @Override // com.baidu.swan.apps.x.b.e
    public String Vx() {
        PMSAppInfo VZ = VZ();
        return VZ == null ? "" : VZ.statusDesc;
    }

    @Override // com.baidu.swan.apps.x.b.e
    public String Vy() {
        PMSAppInfo VZ = VZ();
        return VZ == null ? "" : VZ.resumeDate;
    }

    @Override // com.baidu.swan.apps.x.b.e
    public String Vz() {
        PMSAppInfo VZ = VZ();
        return VZ == null ? "" : VZ.serviceCategory;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.swan.apps.x.b.e
    /* renamed from: iq */
    public SelfT iv(String str) {
        PMSAppInfo VZ = VZ();
        if (VZ != null) {
            VZ.serviceCategory = str;
            return (SelfT) super.iv(str);
        }
        return (SelfT) VF();
    }

    @Override // com.baidu.swan.apps.x.b.e
    public String VA() {
        PMSAppInfo VZ = VZ();
        return VZ == null ? "" : VZ.subjectInfo;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.swan.apps.x.b.e
    /* renamed from: ir */
    public SelfT iu(String str) {
        PMSAppInfo VZ = VZ();
        if (VZ != null) {
            VZ.subjectInfo = str;
            return (SelfT) super.iu(str);
        }
        return (SelfT) VF();
    }

    @Override // com.baidu.swan.apps.x.b.e
    public SwanAppBearInfo VB() {
        PMSAppInfo VZ = VZ();
        if (VZ == null) {
            return null;
        }
        String str = VZ.bearInfo;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return new SwanAppBearInfo(str);
    }

    @Override // com.baidu.swan.apps.x.b.e
    public String getVersion() {
        PMSAppInfo VZ = VZ();
        return VZ == null ? "" : String.valueOf(VZ.versionCode);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.swan.apps.x.b.e
    /* renamed from: is */
    public SelfT it(String str) {
        PMSAppInfo VZ = VZ();
        if (!TextUtils.isEmpty(str) && VZ != null) {
            try {
                VZ.versionCode = Integer.parseInt(str);
                return (SelfT) super.it(str);
            } catch (NumberFormatException e) {
                if (DEBUG) {
                    e.printStackTrace();
                }
            }
        }
        return (SelfT) VF();
    }

    @Override // com.baidu.swan.apps.x.b.e
    public String getVersionCode() {
        PMSAppInfo VZ = VZ();
        return VZ == null ? "" : VZ.versionName;
    }

    @Override // com.baidu.swan.apps.x.b.e
    public int getType() {
        PMSAppInfo VZ = VZ();
        if (VZ == null) {
            return 0;
        }
        return VZ.type;
    }

    @Override // com.baidu.swan.apps.x.b.e
    public long VC() {
        PMSAppInfo VZ = VZ();
        if (VZ == null) {
            return 0L;
        }
        return VZ.pkgSize;
    }

    @Override // com.baidu.swan.apps.x.b.e
    public int getOrientation() {
        PMSAppInfo VZ = VZ();
        int orientation = VZ == null ? -1 : VZ.getOrientation();
        return -1 < orientation ? orientation : super.getOrientation();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.swan.apps.x.b.e
    /* renamed from: fh */
    public SelfT fi(int i) {
        PMSAppInfo VZ = VZ();
        if (VZ != null) {
            VZ.setOrientation(i);
            return (SelfT) super.fi(i);
        }
        return (SelfT) VF();
    }

    @Override // com.baidu.swan.apps.x.b.e
    public long VD() {
        return this.byo;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.swan.apps.x.b.e
    /* renamed from: ai */
    public SelfT aj(long j) {
        if (this.byo >= 1 || j <= 0) {
            return (SelfT) VF();
        }
        this.byo = j;
        return (SelfT) super.aj(j);
    }
}
