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
    private long byn;

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
        /* renamed from: VC */
        public a VD() {
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
            return (SelfT) VD();
        }
        B(intent.getExtras());
        if (d.I(intent)) {
            iB("1250000000000000");
        }
        return (SelfT) VD();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.swan.apps.x.b.a.c
    /* renamed from: A */
    public SelfT B(Bundle bundle) {
        if (bundle == null) {
            return (SelfT) VD();
        }
        com.baidu.swan.apps.console.debugger.b.n(bundle);
        super.B(bundle);
        if (TextUtils.isEmpty(bundle.getString("mPage"))) {
            iJ("mPage");
        }
        return (SelfT) VD();
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

    public static b Vq() {
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

    public JSONObject Vr() {
        String VJ = VJ();
        if (VJ != null) {
            String queryParameter = Uri.parse(VJ).getQueryParameter("_swaninfo");
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

    public String QY() {
        return "SwanAppLaunchInfo{mAppId='" + getAppId() + "', mAppKey='" + getAppKey() + "', mAppTitle='" + QZ() + "', pmsAppInfo is null='" + VY() + "', launchFrom='" + VH() + "', launchScheme='" + VJ() + "', page='" + getPage() + "', mErrorCode=" + Vt() + ", mErrorDetail='" + Vu() + "', mErrorMsg='" + Vv() + "', mResumeDate='" + Vw() + "', maxSwanVersion='" + VK() + "', minSwanVersion='" + VL() + "', mVersion='" + getVersion() + "', mType=" + getType() + ", extraData=" + VM() + ", isDebug=" + isDebug() + ", targetSwanVersion='" + VS() + "', swanCoreVersion=" + QO() + ", appFrameType=" + getAppFrameType() + ", consoleSwitch=" + VT() + ", orientation=" + getOrientation() + ", versionCode='" + getVersionCode() + "', launchFlags=" + VU() + ", swanAppStartTime=" + VB() + ", extStartTimestamp=" + VV() + ", remoteDebug='" + VW() + "', extJSonObject=" + VZ() + ", launchId=" + Wa() + '}';
    }

    @Override // com.baidu.swan.apps.x.b.e
    public String QZ() {
        PMSAppInfo VX = VX();
        return (VX == null || TextUtils.isEmpty(VX.appName)) ? super.QZ() : VX.appName;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.swan.apps.x.b.e
    /* renamed from: il */
    public SelfT iA(String str) {
        PMSAppInfo VX = VX();
        if (VX != null) {
            VX.appName = str;
        }
        return (SelfT) super.iA(str);
    }

    @Override // com.baidu.swan.apps.x.b.e
    public String getAppKey() {
        PMSAppInfo VX = VX();
        return (VX == null || TextUtils.isEmpty(VX.appKey)) ? super.getAppKey() : VX.appKey;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.swan.apps.x.b.e
    /* renamed from: im */
    public SelfT iz(String str) {
        PMSAppInfo VX = VX();
        if (VX != null) {
            VX.appKey = str;
        }
        return (SelfT) super.iz(str);
    }

    @Override // com.baidu.swan.apps.x.b.e
    public String getAppId() {
        PMSAppInfo VX = VX();
        return (VX == null || TextUtils.isEmpty(VX.appId)) ? super.getAppId() : VX.appId;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.swan.apps.x.b.e
    /* renamed from: in */
    public SelfT iy(String str) {
        super.iy(str);
        PMSAppInfo VX = VX();
        if (VX != null) {
            VX.appId = str;
            return (SelfT) super.iy(str);
        }
        return (SelfT) VD();
    }

    @Override // com.baidu.swan.apps.x.b.e
    public String getIconUrl() {
        PMSAppInfo VX = VX();
        return (VX == null || TextUtils.isEmpty(VX.iconUrl)) ? super.getIconUrl() : VX.iconUrl;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.swan.apps.x.b.e
    /* renamed from: io */
    public SelfT ix(String str) {
        super.ix(str);
        PMSAppInfo VX = VX();
        if (VX != null) {
            VX.iconUrl = str;
            return (SelfT) super.ix(str);
        }
        return (SelfT) VD();
    }

    @Override // com.baidu.swan.apps.x.b.e
    public String Vs() {
        PMSAppInfo VX = VX();
        return VX == null ? "" : VX.description;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.swan.apps.x.b.e
    /* renamed from: ip */
    public SelfT iw(String str) {
        PMSAppInfo VX = VX();
        if (VX != null) {
            VX.description = str;
            return (SelfT) super.iw(str);
        }
        return (SelfT) VD();
    }

    @Override // com.baidu.swan.apps.x.b.e
    public int Vt() {
        PMSAppInfo VX = VX();
        if (VX == null) {
            return 0;
        }
        return VX.appStatus;
    }

    @Override // com.baidu.swan.apps.x.b.e
    public String Vu() {
        PMSAppInfo VX = VX();
        return VX == null ? "" : VX.statusDetail;
    }

    @Override // com.baidu.swan.apps.x.b.e
    public String Vv() {
        PMSAppInfo VX = VX();
        return VX == null ? "" : VX.statusDesc;
    }

    @Override // com.baidu.swan.apps.x.b.e
    public String Vw() {
        PMSAppInfo VX = VX();
        return VX == null ? "" : VX.resumeDate;
    }

    @Override // com.baidu.swan.apps.x.b.e
    public String Vx() {
        PMSAppInfo VX = VX();
        return VX == null ? "" : VX.serviceCategory;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.swan.apps.x.b.e
    /* renamed from: iq */
    public SelfT iv(String str) {
        PMSAppInfo VX = VX();
        if (VX != null) {
            VX.serviceCategory = str;
            return (SelfT) super.iv(str);
        }
        return (SelfT) VD();
    }

    @Override // com.baidu.swan.apps.x.b.e
    public String Vy() {
        PMSAppInfo VX = VX();
        return VX == null ? "" : VX.subjectInfo;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.swan.apps.x.b.e
    /* renamed from: ir */
    public SelfT iu(String str) {
        PMSAppInfo VX = VX();
        if (VX != null) {
            VX.subjectInfo = str;
            return (SelfT) super.iu(str);
        }
        return (SelfT) VD();
    }

    @Override // com.baidu.swan.apps.x.b.e
    public SwanAppBearInfo Vz() {
        PMSAppInfo VX = VX();
        if (VX == null) {
            return null;
        }
        String str = VX.bearInfo;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return new SwanAppBearInfo(str);
    }

    @Override // com.baidu.swan.apps.x.b.e
    public String getVersion() {
        PMSAppInfo VX = VX();
        return VX == null ? "" : String.valueOf(VX.versionCode);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.swan.apps.x.b.e
    /* renamed from: is */
    public SelfT it(String str) {
        PMSAppInfo VX = VX();
        if (!TextUtils.isEmpty(str) && VX != null) {
            try {
                VX.versionCode = Integer.parseInt(str);
                return (SelfT) super.it(str);
            } catch (NumberFormatException e) {
                if (DEBUG) {
                    e.printStackTrace();
                }
            }
        }
        return (SelfT) VD();
    }

    @Override // com.baidu.swan.apps.x.b.e
    public String getVersionCode() {
        PMSAppInfo VX = VX();
        return VX == null ? "" : VX.versionName;
    }

    @Override // com.baidu.swan.apps.x.b.e
    public int getType() {
        PMSAppInfo VX = VX();
        if (VX == null) {
            return 0;
        }
        return VX.type;
    }

    @Override // com.baidu.swan.apps.x.b.e
    public long VA() {
        PMSAppInfo VX = VX();
        if (VX == null) {
            return 0L;
        }
        return VX.pkgSize;
    }

    @Override // com.baidu.swan.apps.x.b.e
    public int getOrientation() {
        PMSAppInfo VX = VX();
        int orientation = VX == null ? -1 : VX.getOrientation();
        return -1 < orientation ? orientation : super.getOrientation();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.swan.apps.x.b.e
    /* renamed from: fh */
    public SelfT fi(int i) {
        PMSAppInfo VX = VX();
        if (VX != null) {
            VX.setOrientation(i);
            return (SelfT) super.fi(i);
        }
        return (SelfT) VD();
    }

    @Override // com.baidu.swan.apps.x.b.e
    public long VB() {
        return this.byn;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.swan.apps.x.b.e
    /* renamed from: ai */
    public SelfT aj(long j) {
        if (this.byn >= 1 || j <= 0) {
            return (SelfT) VD();
        }
        this.byn = j;
        return (SelfT) super.aj(j);
    }
}
