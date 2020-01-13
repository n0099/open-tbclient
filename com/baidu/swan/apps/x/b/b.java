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
/* loaded from: classes10.dex */
public abstract class b<SelfT extends b<SelfT>> extends e<SelfT> {
    private long bud;

    /* loaded from: classes10.dex */
    public static final class a extends b<a> {
        @Override // com.baidu.swan.apps.x.b.b, com.baidu.swan.apps.x.b.a.c
        public /* synthetic */ com.baidu.swan.apps.x.b.a.c B(Bundle bundle) {
            return super.B(bundle);
        }

        @Override // com.baidu.swan.apps.x.b.b, com.baidu.swan.apps.x.b.e
        public /* synthetic */ e af(long j) {
            return super.af(j);
        }

        @Override // com.baidu.swan.apps.x.b.b, com.baidu.swan.apps.x.b.e
        public /* synthetic */ e eS(int i) {
            return super.eS(i);
        }

        @Override // com.baidu.swan.apps.x.b.b, com.baidu.swan.apps.x.b.e
        public /* synthetic */ e ie(String str) {
            return super.ie(str);
        }

        @Override // com.baidu.swan.apps.x.b.b, com.baidu.swan.apps.x.b.e
        /* renamed from: if */
        public /* synthetic */ e mo23if(String str) {
            return super.mo23if(str);
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

        @Override // com.baidu.swan.apps.x.b.b, com.baidu.swan.apps.x.b.e
        public /* synthetic */ e ij(String str) {
            return super.ij(str);
        }

        @Override // com.baidu.swan.apps.x.b.b, com.baidu.swan.apps.x.b.e
        public /* synthetic */ e ik(String str) {
            return super.ik(str);
        }

        @Override // com.baidu.swan.apps.x.b.b, com.baidu.swan.apps.x.b.e
        public /* synthetic */ e il(String str) {
            return super.il(str);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.apps.as.d.d
        /* renamed from: To */
        public a Tp() {
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
            return (SelfT) Tp();
        }
        B(intent.getExtras());
        if (d.I(intent)) {
            im("1250000000000000");
        }
        return (SelfT) Tp();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.swan.apps.x.b.a.c
    /* renamed from: A */
    public SelfT B(Bundle bundle) {
        if (bundle == null) {
            return (SelfT) Tp();
        }
        com.baidu.swan.apps.console.debugger.b.n(bundle);
        super.B(bundle);
        if (TextUtils.isEmpty(bundle.getString("mPage"))) {
            iu("mPage");
        }
        return (SelfT) Tp();
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

    public static b Tc() {
        a aVar = new a();
        aVar.il("小程序测试");
        aVar.ij("wSfMyKIbrbNg7ogTFTcBuk1P8mgGTlB1");
        aVar.ag(Color.parseColor("#FF308EF0"));
        aVar.im("1230000000000000");
        aVar.ih("小程序简介");
        aVar.ig("测试服务类目");
        aVar.mo23if("测试主体信息");
        aVar.ik("CdKRXT4IrCwTD6LIBS7DIlL8rmbKx58N");
        aVar.ie("1.0");
        aVar.ii("https://gss3.bdstatic.com/9rkZsjib41gCpNKfpU_Y_D3/searchbox/aps/1516937209_WechatIMG147.jpeg");
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
        if (swanAppConfigData.kN(ag.delAllParamsFromUrl(str))) {
            return str;
        }
        return null;
    }

    public JSONObject Td() {
        String Tv = Tv();
        if (Tv != null) {
            String queryParameter = Uri.parse(Tv).getQueryParameter("_swaninfo");
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

    public String OK() {
        return "SwanAppLaunchInfo{mAppId='" + getAppId() + "', mAppKey='" + getAppKey() + "', mAppTitle='" + OL() + "', pmsAppInfo is null='" + TK() + "', launchFrom='" + Tt() + "', launchScheme='" + Tv() + "', page='" + getPage() + "', mErrorCode=" + Tf() + ", mErrorDetail='" + Tg() + "', mErrorMsg='" + Th() + "', mResumeDate='" + Ti() + "', maxSwanVersion='" + Tw() + "', minSwanVersion='" + Tx() + "', mVersion='" + getVersion() + "', mType=" + getType() + ", extraData=" + Ty() + ", isDebug=" + isDebug() + ", targetSwanVersion='" + TE() + "', swanCoreVersion=" + OA() + ", appFrameType=" + getAppFrameType() + ", consoleSwitch=" + TF() + ", orientation=" + getOrientation() + ", versionCode='" + getVersionCode() + "', launchFlags=" + TG() + ", swanAppStartTime=" + Tn() + ", extStartTimestamp=" + TH() + ", remoteDebug='" + TI() + "', extJSonObject=" + TL() + ", launchId=" + TM() + '}';
    }

    @Override // com.baidu.swan.apps.x.b.e
    public String OL() {
        PMSAppInfo TJ = TJ();
        return (TJ == null || TextUtils.isEmpty(TJ.appName)) ? super.OL() : TJ.appName;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.swan.apps.x.b.e
    /* renamed from: hV */
    public SelfT il(String str) {
        PMSAppInfo TJ = TJ();
        if (TJ != null) {
            TJ.appName = str;
        }
        return (SelfT) super.il(str);
    }

    @Override // com.baidu.swan.apps.x.b.e
    public String getAppKey() {
        PMSAppInfo TJ = TJ();
        return (TJ == null || TextUtils.isEmpty(TJ.appKey)) ? super.getAppKey() : TJ.appKey;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.swan.apps.x.b.e
    /* renamed from: hW */
    public SelfT ik(String str) {
        PMSAppInfo TJ = TJ();
        if (TJ != null) {
            TJ.appKey = str;
        }
        return (SelfT) super.ik(str);
    }

    @Override // com.baidu.swan.apps.x.b.e
    public String getAppId() {
        PMSAppInfo TJ = TJ();
        return (TJ == null || TextUtils.isEmpty(TJ.appId)) ? super.getAppId() : TJ.appId;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.swan.apps.x.b.e
    /* renamed from: hX */
    public SelfT ij(String str) {
        super.ij(str);
        PMSAppInfo TJ = TJ();
        if (TJ != null) {
            TJ.appId = str;
            return (SelfT) super.ij(str);
        }
        return (SelfT) Tp();
    }

    @Override // com.baidu.swan.apps.x.b.e
    public String getIconUrl() {
        PMSAppInfo TJ = TJ();
        return (TJ == null || TextUtils.isEmpty(TJ.iconUrl)) ? super.getIconUrl() : TJ.iconUrl;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.swan.apps.x.b.e
    /* renamed from: hY */
    public SelfT ii(String str) {
        super.ii(str);
        PMSAppInfo TJ = TJ();
        if (TJ != null) {
            TJ.iconUrl = str;
            return (SelfT) super.ii(str);
        }
        return (SelfT) Tp();
    }

    @Override // com.baidu.swan.apps.x.b.e
    public String Te() {
        PMSAppInfo TJ = TJ();
        return TJ == null ? "" : TJ.description;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.swan.apps.x.b.e
    /* renamed from: hZ */
    public SelfT ih(String str) {
        PMSAppInfo TJ = TJ();
        if (TJ != null) {
            TJ.description = str;
            return (SelfT) super.ih(str);
        }
        return (SelfT) Tp();
    }

    @Override // com.baidu.swan.apps.x.b.e
    public int Tf() {
        PMSAppInfo TJ = TJ();
        if (TJ == null) {
            return 0;
        }
        return TJ.appStatus;
    }

    @Override // com.baidu.swan.apps.x.b.e
    public String Tg() {
        PMSAppInfo TJ = TJ();
        return TJ == null ? "" : TJ.statusDetail;
    }

    @Override // com.baidu.swan.apps.x.b.e
    public String Th() {
        PMSAppInfo TJ = TJ();
        return TJ == null ? "" : TJ.statusDesc;
    }

    @Override // com.baidu.swan.apps.x.b.e
    public String Ti() {
        PMSAppInfo TJ = TJ();
        return TJ == null ? "" : TJ.resumeDate;
    }

    @Override // com.baidu.swan.apps.x.b.e
    public String Tj() {
        PMSAppInfo TJ = TJ();
        return TJ == null ? "" : TJ.serviceCategory;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.swan.apps.x.b.e
    /* renamed from: ia */
    public SelfT ig(String str) {
        PMSAppInfo TJ = TJ();
        if (TJ != null) {
            TJ.serviceCategory = str;
            return (SelfT) super.ig(str);
        }
        return (SelfT) Tp();
    }

    @Override // com.baidu.swan.apps.x.b.e
    public String Tk() {
        PMSAppInfo TJ = TJ();
        return TJ == null ? "" : TJ.subjectInfo;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.swan.apps.x.b.e
    /* renamed from: ib */
    public SelfT mo23if(String str) {
        PMSAppInfo TJ = TJ();
        if (TJ != null) {
            TJ.subjectInfo = str;
            return (SelfT) super.mo23if(str);
        }
        return (SelfT) Tp();
    }

    @Override // com.baidu.swan.apps.x.b.e
    public SwanAppBearInfo Tl() {
        PMSAppInfo TJ = TJ();
        if (TJ == null) {
            return null;
        }
        String str = TJ.bearInfo;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return new SwanAppBearInfo(str);
    }

    @Override // com.baidu.swan.apps.x.b.e
    public String getVersion() {
        PMSAppInfo TJ = TJ();
        return TJ == null ? "" : String.valueOf(TJ.versionCode);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.swan.apps.x.b.e
    /* renamed from: ic */
    public SelfT ie(String str) {
        PMSAppInfo TJ = TJ();
        if (!TextUtils.isEmpty(str) && TJ != null) {
            try {
                TJ.versionCode = Integer.parseInt(str);
                return (SelfT) super.ie(str);
            } catch (NumberFormatException e) {
                if (DEBUG) {
                    e.printStackTrace();
                }
            }
        }
        return (SelfT) Tp();
    }

    @Override // com.baidu.swan.apps.x.b.e
    public String getVersionCode() {
        PMSAppInfo TJ = TJ();
        return TJ == null ? "" : TJ.versionName;
    }

    @Override // com.baidu.swan.apps.x.b.e
    public int getType() {
        PMSAppInfo TJ = TJ();
        if (TJ == null) {
            return 0;
        }
        return TJ.type;
    }

    @Override // com.baidu.swan.apps.x.b.e
    public long Tm() {
        PMSAppInfo TJ = TJ();
        if (TJ == null) {
            return 0L;
        }
        return TJ.pkgSize;
    }

    @Override // com.baidu.swan.apps.x.b.e
    public int getOrientation() {
        PMSAppInfo TJ = TJ();
        int orientation = TJ == null ? -1 : TJ.getOrientation();
        return -1 < orientation ? orientation : super.getOrientation();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.swan.apps.x.b.e
    /* renamed from: eR */
    public SelfT eS(int i) {
        PMSAppInfo TJ = TJ();
        if (TJ != null) {
            TJ.setOrientation(i);
            return (SelfT) super.eS(i);
        }
        return (SelfT) Tp();
    }

    @Override // com.baidu.swan.apps.x.b.e
    public long Tn() {
        return this.bud;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.swan.apps.x.b.e
    /* renamed from: ae */
    public SelfT af(long j) {
        if (this.bud >= 1 || j <= 0) {
            return (SelfT) Tp();
        }
        this.bud = j;
        return (SelfT) super.af(j);
    }
}
