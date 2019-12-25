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
/* loaded from: classes9.dex */
public abstract class b<SelfT extends b<SelfT>> extends e<SelfT> {
    private long btp;

    /* loaded from: classes9.dex */
    public static final class a extends b<a> {
        @Override // com.baidu.swan.apps.x.b.b, com.baidu.swan.apps.x.b.a.c
        public /* synthetic */ com.baidu.swan.apps.x.b.a.c B(Bundle bundle) {
            return super.B(bundle);
        }

        @Override // com.baidu.swan.apps.x.b.b, com.baidu.swan.apps.x.b.e
        public /* synthetic */ e ac(long j) {
            return super.ac(j);
        }

        @Override // com.baidu.swan.apps.x.b.b, com.baidu.swan.apps.x.b.e
        public /* synthetic */ e eR(int i) {
            return super.eR(i);
        }

        @Override // com.baidu.swan.apps.x.b.b, com.baidu.swan.apps.x.b.e
        public /* synthetic */ e ia(String str) {
            return super.ia(str);
        }

        @Override // com.baidu.swan.apps.x.b.b, com.baidu.swan.apps.x.b.e
        public /* synthetic */ e ib(String str) {
            return super.ib(str);
        }

        @Override // com.baidu.swan.apps.x.b.b, com.baidu.swan.apps.x.b.e
        public /* synthetic */ e ic(String str) {
            return super.ic(str);
        }

        @Override // com.baidu.swan.apps.x.b.b, com.baidu.swan.apps.x.b.e
        public /* synthetic */ e ie(String str) {
            return super.ie(str);
        }

        @Override // com.baidu.swan.apps.x.b.b, com.baidu.swan.apps.x.b.e
        /* renamed from: if */
        public /* synthetic */ e mo20if(String str) {
            return super.mo20if(str);
        }

        @Override // com.baidu.swan.apps.x.b.b, com.baidu.swan.apps.x.b.e
        public /* synthetic */ e ig(String str) {
            return super.ig(str);
        }

        @Override // com.baidu.swan.apps.x.b.b, com.baidu.swan.apps.x.b.e
        public /* synthetic */ e ih(String str) {
            return super.ih(str);
        }

        @Override // com.baidu.swan.apps.x.b.b, com.baidu.swan.apps.x.b.e
        public /* synthetic */ e ii(String str) {
            return super.ii(str);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.apps.as.d.d
        /* renamed from: SR */
        public a SS() {
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
            return (SelfT) SS();
        }
        B(intent.getExtras());
        if (d.I(intent)) {
            ij("1250000000000000");
        }
        return (SelfT) SS();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.swan.apps.x.b.a.c
    /* renamed from: A */
    public SelfT B(Bundle bundle) {
        if (bundle == null) {
            return (SelfT) SS();
        }
        com.baidu.swan.apps.console.debugger.b.n(bundle);
        super.B(bundle);
        if (TextUtils.isEmpty(bundle.getString("mPage"))) {
            ir("mPage");
        }
        return (SelfT) SS();
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

    public static b SF() {
        a aVar = new a();
        aVar.ii("小程序测试");
        aVar.ig("wSfMyKIbrbNg7ogTFTcBuk1P8mgGTlB1");
        aVar.ad(Color.parseColor("#FF308EF0"));
        aVar.ij("1230000000000000");
        aVar.ie("小程序简介");
        aVar.ic("测试服务类目");
        aVar.ib("测试主体信息");
        aVar.ih("CdKRXT4IrCwTD6LIBS7DIlL8rmbKx58N");
        aVar.ia("1.0");
        aVar.mo20if("https://gss3.bdstatic.com/9rkZsjib41gCpNKfpU_Y_D3/searchbox/aps/1516937209_WechatIMG147.jpeg");
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
        if (swanAppConfigData.kK(ag.delAllParamsFromUrl(str))) {
            return str;
        }
        return null;
    }

    public JSONObject SG() {
        String SY = SY();
        if (SY != null) {
            String queryParameter = Uri.parse(SY).getQueryParameter("_swaninfo");
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

    public String Oo() {
        return "SwanAppLaunchInfo{mAppId='" + getAppId() + "', mAppKey='" + getAppKey() + "', mAppTitle='" + Op() + "', pmsAppInfo is null='" + Tn() + "', launchFrom='" + SW() + "', launchScheme='" + SY() + "', page='" + getPage() + "', mErrorCode=" + SI() + ", mErrorDetail='" + SJ() + "', mErrorMsg='" + SK() + "', mResumeDate='" + SL() + "', maxSwanVersion='" + SZ() + "', minSwanVersion='" + Ta() + "', mVersion='" + getVersion() + "', mType=" + getType() + ", extraData=" + Tb() + ", isDebug=" + isDebug() + ", targetSwanVersion='" + Th() + "', swanCoreVersion=" + Oe() + ", appFrameType=" + getAppFrameType() + ", consoleSwitch=" + Ti() + ", orientation=" + getOrientation() + ", versionCode='" + getVersionCode() + "', launchFlags=" + Tj() + ", swanAppStartTime=" + SQ() + ", extStartTimestamp=" + Tk() + ", remoteDebug='" + Tl() + "', extJSonObject=" + To() + ", launchId=" + Tp() + '}';
    }

    @Override // com.baidu.swan.apps.x.b.e
    public String Op() {
        PMSAppInfo Tm = Tm();
        return (Tm == null || TextUtils.isEmpty(Tm.appName)) ? super.Op() : Tm.appName;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.swan.apps.x.b.e
    /* renamed from: hS */
    public SelfT ii(String str) {
        PMSAppInfo Tm = Tm();
        if (Tm != null) {
            Tm.appName = str;
        }
        return (SelfT) super.ii(str);
    }

    @Override // com.baidu.swan.apps.x.b.e
    public String getAppKey() {
        PMSAppInfo Tm = Tm();
        return (Tm == null || TextUtils.isEmpty(Tm.appKey)) ? super.getAppKey() : Tm.appKey;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.swan.apps.x.b.e
    /* renamed from: hT */
    public SelfT ih(String str) {
        PMSAppInfo Tm = Tm();
        if (Tm != null) {
            Tm.appKey = str;
        }
        return (SelfT) super.ih(str);
    }

    @Override // com.baidu.swan.apps.x.b.e
    public String getAppId() {
        PMSAppInfo Tm = Tm();
        return (Tm == null || TextUtils.isEmpty(Tm.appId)) ? super.getAppId() : Tm.appId;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.swan.apps.x.b.e
    /* renamed from: hU */
    public SelfT ig(String str) {
        super.ig(str);
        PMSAppInfo Tm = Tm();
        if (Tm != null) {
            Tm.appId = str;
            return (SelfT) super.ig(str);
        }
        return (SelfT) SS();
    }

    @Override // com.baidu.swan.apps.x.b.e
    public String getIconUrl() {
        PMSAppInfo Tm = Tm();
        return (Tm == null || TextUtils.isEmpty(Tm.iconUrl)) ? super.getIconUrl() : Tm.iconUrl;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.swan.apps.x.b.e
    /* renamed from: hV */
    public SelfT mo20if(String str) {
        super.mo20if(str);
        PMSAppInfo Tm = Tm();
        if (Tm != null) {
            Tm.iconUrl = str;
            return (SelfT) super.mo20if(str);
        }
        return (SelfT) SS();
    }

    @Override // com.baidu.swan.apps.x.b.e
    public String SH() {
        PMSAppInfo Tm = Tm();
        return Tm == null ? "" : Tm.description;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.swan.apps.x.b.e
    /* renamed from: hW */
    public SelfT ie(String str) {
        PMSAppInfo Tm = Tm();
        if (Tm != null) {
            Tm.description = str;
            return (SelfT) super.ie(str);
        }
        return (SelfT) SS();
    }

    @Override // com.baidu.swan.apps.x.b.e
    public int SI() {
        PMSAppInfo Tm = Tm();
        if (Tm == null) {
            return 0;
        }
        return Tm.appStatus;
    }

    @Override // com.baidu.swan.apps.x.b.e
    public String SJ() {
        PMSAppInfo Tm = Tm();
        return Tm == null ? "" : Tm.statusDetail;
    }

    @Override // com.baidu.swan.apps.x.b.e
    public String SK() {
        PMSAppInfo Tm = Tm();
        return Tm == null ? "" : Tm.statusDesc;
    }

    @Override // com.baidu.swan.apps.x.b.e
    public String SL() {
        PMSAppInfo Tm = Tm();
        return Tm == null ? "" : Tm.resumeDate;
    }

    @Override // com.baidu.swan.apps.x.b.e
    public String SM() {
        PMSAppInfo Tm = Tm();
        return Tm == null ? "" : Tm.serviceCategory;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.swan.apps.x.b.e
    /* renamed from: hX */
    public SelfT ic(String str) {
        PMSAppInfo Tm = Tm();
        if (Tm != null) {
            Tm.serviceCategory = str;
            return (SelfT) super.ic(str);
        }
        return (SelfT) SS();
    }

    @Override // com.baidu.swan.apps.x.b.e
    public String SN() {
        PMSAppInfo Tm = Tm();
        return Tm == null ? "" : Tm.subjectInfo;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.swan.apps.x.b.e
    /* renamed from: hY */
    public SelfT ib(String str) {
        PMSAppInfo Tm = Tm();
        if (Tm != null) {
            Tm.subjectInfo = str;
            return (SelfT) super.ib(str);
        }
        return (SelfT) SS();
    }

    @Override // com.baidu.swan.apps.x.b.e
    public SwanAppBearInfo SO() {
        PMSAppInfo Tm = Tm();
        if (Tm == null) {
            return null;
        }
        String str = Tm.bearInfo;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return new SwanAppBearInfo(str);
    }

    @Override // com.baidu.swan.apps.x.b.e
    public String getVersion() {
        PMSAppInfo Tm = Tm();
        return Tm == null ? "" : String.valueOf(Tm.versionCode);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.swan.apps.x.b.e
    /* renamed from: hZ */
    public SelfT ia(String str) {
        PMSAppInfo Tm = Tm();
        if (!TextUtils.isEmpty(str) && Tm != null) {
            try {
                Tm.versionCode = Integer.parseInt(str);
                return (SelfT) super.ia(str);
            } catch (NumberFormatException e) {
                if (DEBUG) {
                    e.printStackTrace();
                }
            }
        }
        return (SelfT) SS();
    }

    @Override // com.baidu.swan.apps.x.b.e
    public String getVersionCode() {
        PMSAppInfo Tm = Tm();
        return Tm == null ? "" : Tm.versionName;
    }

    @Override // com.baidu.swan.apps.x.b.e
    public int getType() {
        PMSAppInfo Tm = Tm();
        if (Tm == null) {
            return 0;
        }
        return Tm.type;
    }

    @Override // com.baidu.swan.apps.x.b.e
    public long SP() {
        PMSAppInfo Tm = Tm();
        if (Tm == null) {
            return 0L;
        }
        return Tm.pkgSize;
    }

    @Override // com.baidu.swan.apps.x.b.e
    public int getOrientation() {
        PMSAppInfo Tm = Tm();
        int orientation = Tm == null ? -1 : Tm.getOrientation();
        return -1 < orientation ? orientation : super.getOrientation();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.swan.apps.x.b.e
    /* renamed from: eQ */
    public SelfT eR(int i) {
        PMSAppInfo Tm = Tm();
        if (Tm != null) {
            Tm.setOrientation(i);
            return (SelfT) super.eR(i);
        }
        return (SelfT) SS();
    }

    @Override // com.baidu.swan.apps.x.b.e
    public long SQ() {
        return this.btp;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.swan.apps.x.b.e
    /* renamed from: ab */
    public SelfT ac(long j) {
        if (this.btp >= 1 || j <= 0) {
            return (SelfT) SS();
        }
        this.btp = j;
        return (SelfT) super.ac(j);
    }
}
