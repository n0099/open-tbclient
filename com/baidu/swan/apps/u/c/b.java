package com.baidu.swan.apps.u.c;

import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.swan.apps.ap.ai;
import com.baidu.swan.apps.model.SwanAppBearInfo;
import com.baidu.swan.apps.performance.k;
import com.baidu.swan.apps.runtime.config.SwanAppConfigData;
import com.baidu.swan.apps.scheme.actions.k.j;
import com.baidu.swan.apps.u.c.b;
import com.baidu.swan.pms.model.PMSAppInfo;
import java.io.File;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public abstract class b<SelfT extends b<SelfT>> extends e<SelfT> {
    private long cxT;

    /* loaded from: classes3.dex */
    public static final class a extends b<a> {
        @Override // com.baidu.swan.apps.u.c.b, com.baidu.swan.apps.u.c.a.c
        public /* synthetic */ com.baidu.swan.apps.u.c.a.c D(Bundle bundle) {
            return super.D(bundle);
        }

        @Override // com.baidu.swan.apps.u.c.b, com.baidu.swan.apps.u.c.e
        public /* synthetic */ e be(long j) {
            return super.be(j);
        }

        @Override // com.baidu.swan.apps.u.c.b, com.baidu.swan.apps.u.c.e
        public /* synthetic */ e il(int i) {
            return super.il(i);
        }

        @Override // com.baidu.swan.apps.u.c.b, com.baidu.swan.apps.u.c.e
        public /* synthetic */ e nQ(String str) {
            return super.nQ(str);
        }

        @Override // com.baidu.swan.apps.u.c.b, com.baidu.swan.apps.u.c.e
        public /* synthetic */ e nR(String str) {
            return super.nR(str);
        }

        @Override // com.baidu.swan.apps.u.c.b, com.baidu.swan.apps.u.c.e
        public /* synthetic */ e nS(String str) {
            return super.nS(str);
        }

        @Override // com.baidu.swan.apps.u.c.b, com.baidu.swan.apps.u.c.e
        public /* synthetic */ e nT(String str) {
            return super.nT(str);
        }

        @Override // com.baidu.swan.apps.u.c.b, com.baidu.swan.apps.u.c.e
        public /* synthetic */ e nU(String str) {
            return super.nU(str);
        }

        @Override // com.baidu.swan.apps.u.c.b, com.baidu.swan.apps.u.c.e
        public /* synthetic */ e nV(String str) {
            return super.nV(str);
        }

        @Override // com.baidu.swan.apps.u.c.b, com.baidu.swan.apps.u.c.e
        public /* synthetic */ e nW(String str) {
            return super.nW(str);
        }

        @Override // com.baidu.swan.apps.u.c.b, com.baidu.swan.apps.u.c.e
        public /* synthetic */ e nX(String str) {
            return super.nX(str);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.apps.ap.e.d
        /* renamed from: ars */
        public a art() {
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
            return (SelfT) art();
        }
        D(intent.getExtras());
        if (d.v(intent)) {
            nY("1250000000000000");
            n("box_cold_launch", -1L);
        }
        return (SelfT) art();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.swan.apps.u.c.a.c
    /* renamed from: C */
    public SelfT D(Bundle bundle) {
        if (bundle == null) {
            return (SelfT) art();
        }
        com.baidu.swan.apps.console.debugger.b.n(bundle);
        k.awE().J(bundle);
        super.D(bundle);
        if (TextUtils.isEmpty(bundle.getString("mPage"))) {
            oi("mPage");
        }
        return (SelfT) art();
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

    public static b arf() {
        a aVar = new a();
        aVar.nX("小程序测试");
        aVar.nV("wSfMyKIbrbNg7ogTFTcBuk1P8mgGTlB1");
        aVar.bf(Color.parseColor("#FF308EF0"));
        aVar.nY("1230000000000000");
        aVar.nT("小程序简介");
        aVar.nS("测试服务类目");
        aVar.nR("测试主体信息");
        aVar.nW("CdKRXT4IrCwTD6LIBS7DIlL8rmbKx58N");
        aVar.nQ("1.0");
        aVar.nU("https://gss3.bdstatic.com/9rkZsjib41gCpNKfpU_Y_D3/searchbox/aps/1516937209_WechatIMG147.jpeg");
        return aVar;
    }

    public static String a(b bVar, SwanAppConfigData swanAppConfigData) {
        return b(nH(bVar.getPage()), swanAppConfigData);
    }

    public static String a(String str, SwanAppConfigData swanAppConfigData) {
        if (TextUtils.isEmpty(str) || swanAppConfigData == null) {
            if (DEBUG) {
                Log.d("SwanAppLaunchInfo", "getPageInfo ret null - " + str);
            }
            return null;
        }
        Uri parse = Uri.parse(str);
        String j = ai.j(parse);
        if (TextUtils.isEmpty(j)) {
            if (DEBUG) {
                Log.d("SwanAppLaunchInfo", "getPageInfo appId is null");
            }
            return null;
        }
        String b = b(j, parse);
        if (TextUtils.isEmpty(b)) {
            if (DEBUG) {
                Log.d("SwanAppLaunchInfo", "getPageInfo no launchPath ");
            }
            return null;
        }
        String deleteQueryParam = ai.deleteQueryParam(parse.getEncodedQuery(), com.baidu.swan.apps.scheme.a.a.cWh);
        if (!TextUtils.isEmpty(deleteQueryParam)) {
            b = b + "?" + deleteQueryParam;
        }
        return b(nH(b), swanAppConfigData);
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

    public static String nH(String str) {
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
        if (com.baidu.swan.apps.ac.b.a.pO(delAllParamsFromUrl)) {
            return ai.deleteQueryParam(str, com.baidu.swan.apps.scheme.a.a.cWh);
        }
        if (swanAppConfigData.qR(j.rq(delAllParamsFromUrl))) {
            return str;
        }
        return null;
    }

    public JSONObject arg() {
        String arz = arz();
        if (arz != null) {
            String queryParameter = Uri.parse(arz).getQueryParameter("_swaninfo");
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

    public String alx() {
        return "SwanAppLaunchInfo{mAppId='" + getAppId() + "', mAppKey='" + getAppKey() + "', mAppTitle='" + aly() + "', pmsAppInfo is null='" + arO() + "', launchFrom='" + arx() + "', launchScheme='" + arz() + "', page='" + getPage() + "', mErrorCode=" + ari() + ", mErrorDetail='" + arj() + "', mErrorMsg='" + ark() + "', mResumeDate='" + arl() + "', maxSwanVersion='" + arA() + "', minSwanVersion='" + arB() + "', mVersion='" + getVersion() + "', mType=" + getType() + ", extraData=" + arC() + ", isDebug=" + isDebug() + ", targetSwanVersion='" + arI() + "', swanCoreVersion=" + akX() + ", appFrameType=" + getAppFrameType() + ", consoleSwitch=" + arJ() + ", orientation=" + getOrientation() + ", versionCode='" + getVersionCode() + "', launchFlags=" + arK() + ", swanAppStartTime=" + arr() + ", extStartTimestamp=" + arL() + ", remoteDebug='" + arM() + "', extJSonObject=" + arP() + ", launchId=" + arQ() + '}';
    }

    @Override // com.baidu.swan.apps.u.c.e
    public String aly() {
        PMSAppInfo arN = arN();
        return (arN == null || TextUtils.isEmpty(arN.appName)) ? super.aly() : arN.appName;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.swan.apps.u.c.e
    /* renamed from: nI */
    public SelfT nX(String str) {
        PMSAppInfo arN = arN();
        if (arN != null) {
            arN.appName = str;
        }
        return (SelfT) super.nX(str);
    }

    @Override // com.baidu.swan.apps.u.c.e
    public String getAppKey() {
        PMSAppInfo arN = arN();
        return (arN == null || TextUtils.isEmpty(arN.appKey)) ? super.getAppKey() : arN.appKey;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.swan.apps.u.c.e
    /* renamed from: nJ */
    public SelfT nW(String str) {
        PMSAppInfo arN = arN();
        if (arN != null) {
            arN.appKey = str;
        }
        return (SelfT) super.nW(str);
    }

    @Override // com.baidu.swan.apps.u.c.e
    public String getAppId() {
        PMSAppInfo arN = arN();
        return (arN == null || TextUtils.isEmpty(arN.appId)) ? super.getAppId() : arN.appId;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.swan.apps.u.c.e
    /* renamed from: nK */
    public SelfT nV(String str) {
        super.nV(str);
        PMSAppInfo arN = arN();
        if (arN != null) {
            arN.appId = str;
            return (SelfT) super.nV(str);
        }
        return (SelfT) art();
    }

    @Override // com.baidu.swan.apps.u.c.e
    public String getIconUrl() {
        PMSAppInfo arN = arN();
        return (arN == null || TextUtils.isEmpty(arN.iconUrl)) ? super.getIconUrl() : arN.iconUrl;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.swan.apps.u.c.e
    /* renamed from: nL */
    public SelfT nU(String str) {
        super.nU(str);
        PMSAppInfo arN = arN();
        if (arN != null) {
            arN.iconUrl = str;
            return (SelfT) super.nU(str);
        }
        return (SelfT) art();
    }

    @Override // com.baidu.swan.apps.u.c.e
    public String arh() {
        PMSAppInfo arN = arN();
        return arN == null ? "" : arN.description;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.swan.apps.u.c.e
    /* renamed from: nM */
    public SelfT nT(String str) {
        PMSAppInfo arN = arN();
        if (arN != null) {
            arN.description = str;
            return (SelfT) super.nT(str);
        }
        return (SelfT) art();
    }

    @Override // com.baidu.swan.apps.u.c.e
    public int ari() {
        PMSAppInfo arN = arN();
        if (arN == null) {
            return 0;
        }
        return arN.appStatus;
    }

    @Override // com.baidu.swan.apps.u.c.e
    public String arj() {
        PMSAppInfo arN = arN();
        return arN == null ? "" : arN.statusDetail;
    }

    @Override // com.baidu.swan.apps.u.c.e
    public String ark() {
        PMSAppInfo arN = arN();
        return arN == null ? "" : arN.statusDesc;
    }

    @Override // com.baidu.swan.apps.u.c.e
    public String arl() {
        PMSAppInfo arN = arN();
        return arN == null ? "" : arN.resumeDate;
    }

    @Override // com.baidu.swan.apps.u.c.e
    public String arm() {
        PMSAppInfo arN = arN();
        return arN == null ? "" : arN.serviceCategory;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.swan.apps.u.c.e
    /* renamed from: nN */
    public SelfT nS(String str) {
        PMSAppInfo arN = arN();
        if (arN != null) {
            arN.serviceCategory = str;
            return (SelfT) super.nS(str);
        }
        return (SelfT) art();
    }

    @Override // com.baidu.swan.apps.u.c.e
    public String arn() {
        PMSAppInfo arN = arN();
        return arN == null ? "" : arN.subjectInfo;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.swan.apps.u.c.e
    /* renamed from: nO */
    public SelfT nR(String str) {
        PMSAppInfo arN = arN();
        if (arN != null) {
            arN.subjectInfo = str;
            return (SelfT) super.nR(str);
        }
        return (SelfT) art();
    }

    @Override // com.baidu.swan.apps.u.c.e
    public SwanAppBearInfo aro() {
        PMSAppInfo arN = arN();
        if (arN == null) {
            return null;
        }
        String str = arN.bearInfo;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return new SwanAppBearInfo(str);
    }

    @Override // com.baidu.swan.apps.u.c.e
    public String arp() {
        PMSAppInfo arN = arN();
        if (arN == null) {
            return null;
        }
        return arN.quickAppKey;
    }

    @Override // com.baidu.swan.apps.u.c.e
    public String getVersion() {
        PMSAppInfo arN = arN();
        return arN == null ? "" : String.valueOf(arN.versionCode);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.swan.apps.u.c.e
    /* renamed from: nP */
    public SelfT nQ(String str) {
        PMSAppInfo arN = arN();
        if (!TextUtils.isEmpty(str) && arN != null) {
            try {
                arN.versionCode = Integer.parseInt(str);
                return (SelfT) super.nQ(str);
            } catch (NumberFormatException e) {
                if (DEBUG) {
                    e.printStackTrace();
                }
            }
        }
        return (SelfT) art();
    }

    @Override // com.baidu.swan.apps.u.c.e
    public String getVersionCode() {
        PMSAppInfo arN = arN();
        return arN == null ? "" : arN.versionName;
    }

    @Override // com.baidu.swan.apps.u.c.e
    public int getType() {
        PMSAppInfo arN = arN();
        if (arN == null) {
            return 0;
        }
        return arN.type;
    }

    @Override // com.baidu.swan.apps.u.c.e
    public long arq() {
        PMSAppInfo arN = arN();
        if (arN == null) {
            return 0L;
        }
        return arN.pkgSize;
    }

    @Override // com.baidu.swan.apps.u.c.e
    public int getOrientation() {
        PMSAppInfo arN = arN();
        int orientation = arN == null ? -1 : arN.getOrientation();
        return -1 < orientation ? orientation : super.getOrientation();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.swan.apps.u.c.e
    /* renamed from: ik */
    public SelfT il(int i) {
        PMSAppInfo arN = arN();
        if (arN != null) {
            arN.setOrientation(i);
            return (SelfT) super.il(i);
        }
        return (SelfT) art();
    }

    @Override // com.baidu.swan.apps.u.c.e
    public long arr() {
        return this.cxT;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.swan.apps.u.c.e
    /* renamed from: bd */
    public SelfT be(long j) {
        if (this.cxT >= 1 || j <= 0) {
            return (SelfT) art();
        }
        this.cxT = j;
        return (SelfT) super.be(j);
    }
}
