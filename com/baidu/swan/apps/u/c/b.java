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
/* loaded from: classes8.dex */
public abstract class b<SelfT extends b<SelfT>> extends e<SelfT> {
    private long cvS;

    /* loaded from: classes8.dex */
    public static final class a extends b<a> {
        @Override // com.baidu.swan.apps.u.c.b, com.baidu.swan.apps.u.c.a.c
        public /* synthetic */ com.baidu.swan.apps.u.c.a.c D(Bundle bundle) {
            return super.D(bundle);
        }

        @Override // com.baidu.swan.apps.u.c.b, com.baidu.swan.apps.u.c.e
        public /* synthetic */ e bd(long j) {
            return super.bd(j);
        }

        @Override // com.baidu.swan.apps.u.c.b, com.baidu.swan.apps.u.c.e
        public /* synthetic */ e ib(int i) {
            return super.ib(i);
        }

        @Override // com.baidu.swan.apps.u.c.b, com.baidu.swan.apps.u.c.e
        public /* synthetic */ e nA(String str) {
            return super.nA(str);
        }

        @Override // com.baidu.swan.apps.u.c.b, com.baidu.swan.apps.u.c.e
        public /* synthetic */ e nB(String str) {
            return super.nB(str);
        }

        @Override // com.baidu.swan.apps.u.c.b, com.baidu.swan.apps.u.c.e
        public /* synthetic */ e nC(String str) {
            return super.nC(str);
        }

        @Override // com.baidu.swan.apps.u.c.b, com.baidu.swan.apps.u.c.e
        public /* synthetic */ e nD(String str) {
            return super.nD(str);
        }

        @Override // com.baidu.swan.apps.u.c.b, com.baidu.swan.apps.u.c.e
        public /* synthetic */ e nE(String str) {
            return super.nE(str);
        }

        @Override // com.baidu.swan.apps.u.c.b, com.baidu.swan.apps.u.c.e
        public /* synthetic */ e nx(String str) {
            return super.nx(str);
        }

        @Override // com.baidu.swan.apps.u.c.b, com.baidu.swan.apps.u.c.e
        public /* synthetic */ e ny(String str) {
            return super.ny(str);
        }

        @Override // com.baidu.swan.apps.u.c.b, com.baidu.swan.apps.u.c.e
        public /* synthetic */ e nz(String str) {
            return super.nz(str);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.apps.ap.e.d
        /* renamed from: aqI */
        public a aqJ() {
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
            return (SelfT) aqJ();
        }
        D(intent.getExtras());
        if (d.v(intent)) {
            nF("1250000000000000");
            n("box_cold_launch", -1L);
        }
        return (SelfT) aqJ();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.swan.apps.u.c.a.c
    /* renamed from: C */
    public SelfT D(Bundle bundle) {
        if (bundle == null) {
            return (SelfT) aqJ();
        }
        com.baidu.swan.apps.console.debugger.b.n(bundle);
        k.avV().J(bundle);
        super.D(bundle);
        if (TextUtils.isEmpty(bundle.getString("mPage"))) {
            nO("mPage");
        }
        return (SelfT) aqJ();
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

    public static b aqv() {
        a aVar = new a();
        aVar.nE("小程序测试");
        aVar.nC("wSfMyKIbrbNg7ogTFTcBuk1P8mgGTlB1");
        aVar.be(Color.parseColor("#FF308EF0"));
        aVar.nF("1230000000000000");
        aVar.nA("小程序简介");
        aVar.nz("测试服务类目");
        aVar.ny("测试主体信息");
        aVar.nD("CdKRXT4IrCwTD6LIBS7DIlL8rmbKx58N");
        aVar.nx("1.0");
        aVar.nB("https://gss3.bdstatic.com/9rkZsjib41gCpNKfpU_Y_D3/searchbox/aps/1516937209_WechatIMG147.jpeg");
        return aVar;
    }

    public static String a(b bVar, SwanAppConfigData swanAppConfigData) {
        return b(no(bVar.getPage()), swanAppConfigData);
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
        String deleteQueryParam = ai.deleteQueryParam(parse.getEncodedQuery(), com.baidu.swan.apps.scheme.a.a.cUh);
        if (!TextUtils.isEmpty(deleteQueryParam)) {
            b = b + "?" + deleteQueryParam;
        }
        return b(no(b), swanAppConfigData);
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

    public static String no(String str) {
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
        if (com.baidu.swan.apps.ac.b.a.pv(delAllParamsFromUrl)) {
            return ai.deleteQueryParam(str, com.baidu.swan.apps.scheme.a.a.cUh);
        }
        if (swanAppConfigData.qy(j.qX(delAllParamsFromUrl))) {
            return str;
        }
        return null;
    }

    public JSONObject aqw() {
        String aqP = aqP();
        if (aqP != null) {
            String queryParameter = Uri.parse(aqP).getQueryParameter("_swaninfo");
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

    public String akN() {
        return "SwanAppLaunchInfo{mAppId='" + getAppId() + "', mAppKey='" + getAppKey() + "', mAppTitle='" + akO() + "', pmsAppInfo is null='" + are() + "', launchFrom='" + aqN() + "', launchScheme='" + aqP() + "', page='" + getPage() + "', mErrorCode=" + aqy() + ", mErrorDetail='" + aqz() + "', mErrorMsg='" + aqA() + "', mResumeDate='" + aqB() + "', maxSwanVersion='" + aqQ() + "', minSwanVersion='" + aqR() + "', mVersion='" + getVersion() + "', mType=" + getType() + ", extraData=" + aqS() + ", isDebug=" + isDebug() + ", targetSwanVersion='" + aqY() + "', swanCoreVersion=" + akn() + ", appFrameType=" + getAppFrameType() + ", consoleSwitch=" + aqZ() + ", orientation=" + getOrientation() + ", versionCode='" + getVersionCode() + "', launchFlags=" + ara() + ", swanAppStartTime=" + aqH() + ", extStartTimestamp=" + arb() + ", remoteDebug='" + arc() + "', extJSonObject=" + arf() + ", launchId=" + arg() + '}';
    }

    @Override // com.baidu.swan.apps.u.c.e
    public String akO() {
        PMSAppInfo ard = ard();
        return (ard == null || TextUtils.isEmpty(ard.appName)) ? super.akO() : ard.appName;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.swan.apps.u.c.e
    /* renamed from: np */
    public SelfT nE(String str) {
        PMSAppInfo ard = ard();
        if (ard != null) {
            ard.appName = str;
        }
        return (SelfT) super.nE(str);
    }

    @Override // com.baidu.swan.apps.u.c.e
    public String getAppKey() {
        PMSAppInfo ard = ard();
        return (ard == null || TextUtils.isEmpty(ard.appKey)) ? super.getAppKey() : ard.appKey;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.swan.apps.u.c.e
    /* renamed from: nq */
    public SelfT nD(String str) {
        PMSAppInfo ard = ard();
        if (ard != null) {
            ard.appKey = str;
        }
        return (SelfT) super.nD(str);
    }

    @Override // com.baidu.swan.apps.u.c.e
    public String getAppId() {
        PMSAppInfo ard = ard();
        return (ard == null || TextUtils.isEmpty(ard.appId)) ? super.getAppId() : ard.appId;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.swan.apps.u.c.e
    /* renamed from: nr */
    public SelfT nC(String str) {
        super.nC(str);
        PMSAppInfo ard = ard();
        if (ard != null) {
            ard.appId = str;
            return (SelfT) super.nC(str);
        }
        return (SelfT) aqJ();
    }

    @Override // com.baidu.swan.apps.u.c.e
    public String getIconUrl() {
        PMSAppInfo ard = ard();
        return (ard == null || TextUtils.isEmpty(ard.iconUrl)) ? super.getIconUrl() : ard.iconUrl;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.swan.apps.u.c.e
    /* renamed from: ns */
    public SelfT nB(String str) {
        super.nB(str);
        PMSAppInfo ard = ard();
        if (ard != null) {
            ard.iconUrl = str;
            return (SelfT) super.nB(str);
        }
        return (SelfT) aqJ();
    }

    @Override // com.baidu.swan.apps.u.c.e
    public String aqx() {
        PMSAppInfo ard = ard();
        return ard == null ? "" : ard.description;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.swan.apps.u.c.e
    /* renamed from: nt */
    public SelfT nA(String str) {
        PMSAppInfo ard = ard();
        if (ard != null) {
            ard.description = str;
            return (SelfT) super.nA(str);
        }
        return (SelfT) aqJ();
    }

    @Override // com.baidu.swan.apps.u.c.e
    public int aqy() {
        PMSAppInfo ard = ard();
        if (ard == null) {
            return 0;
        }
        return ard.appStatus;
    }

    @Override // com.baidu.swan.apps.u.c.e
    public String aqz() {
        PMSAppInfo ard = ard();
        return ard == null ? "" : ard.statusDetail;
    }

    @Override // com.baidu.swan.apps.u.c.e
    public String aqA() {
        PMSAppInfo ard = ard();
        return ard == null ? "" : ard.statusDesc;
    }

    @Override // com.baidu.swan.apps.u.c.e
    public String aqB() {
        PMSAppInfo ard = ard();
        return ard == null ? "" : ard.resumeDate;
    }

    @Override // com.baidu.swan.apps.u.c.e
    public String aqC() {
        PMSAppInfo ard = ard();
        return ard == null ? "" : ard.serviceCategory;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.swan.apps.u.c.e
    /* renamed from: nu */
    public SelfT nz(String str) {
        PMSAppInfo ard = ard();
        if (ard != null) {
            ard.serviceCategory = str;
            return (SelfT) super.nz(str);
        }
        return (SelfT) aqJ();
    }

    @Override // com.baidu.swan.apps.u.c.e
    public String aqD() {
        PMSAppInfo ard = ard();
        return ard == null ? "" : ard.subjectInfo;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.swan.apps.u.c.e
    /* renamed from: nv */
    public SelfT ny(String str) {
        PMSAppInfo ard = ard();
        if (ard != null) {
            ard.subjectInfo = str;
            return (SelfT) super.ny(str);
        }
        return (SelfT) aqJ();
    }

    @Override // com.baidu.swan.apps.u.c.e
    public SwanAppBearInfo aqE() {
        PMSAppInfo ard = ard();
        if (ard == null) {
            return null;
        }
        String str = ard.bearInfo;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return new SwanAppBearInfo(str);
    }

    @Override // com.baidu.swan.apps.u.c.e
    public String aqF() {
        PMSAppInfo ard = ard();
        if (ard == null) {
            return null;
        }
        return ard.quickAppKey;
    }

    @Override // com.baidu.swan.apps.u.c.e
    public String getVersion() {
        PMSAppInfo ard = ard();
        return ard == null ? "" : String.valueOf(ard.versionCode);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.swan.apps.u.c.e
    /* renamed from: nw */
    public SelfT nx(String str) {
        PMSAppInfo ard = ard();
        if (!TextUtils.isEmpty(str) && ard != null) {
            try {
                ard.versionCode = Integer.parseInt(str);
                return (SelfT) super.nx(str);
            } catch (NumberFormatException e) {
                if (DEBUG) {
                    e.printStackTrace();
                }
            }
        }
        return (SelfT) aqJ();
    }

    @Override // com.baidu.swan.apps.u.c.e
    public String getVersionCode() {
        PMSAppInfo ard = ard();
        return ard == null ? "" : ard.versionName;
    }

    @Override // com.baidu.swan.apps.u.c.e
    public int getType() {
        PMSAppInfo ard = ard();
        if (ard == null) {
            return 0;
        }
        return ard.type;
    }

    @Override // com.baidu.swan.apps.u.c.e
    public long aqG() {
        PMSAppInfo ard = ard();
        if (ard == null) {
            return 0L;
        }
        return ard.pkgSize;
    }

    @Override // com.baidu.swan.apps.u.c.e
    public int getOrientation() {
        PMSAppInfo ard = ard();
        int orientation = ard == null ? -1 : ard.getOrientation();
        return -1 < orientation ? orientation : super.getOrientation();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.swan.apps.u.c.e
    /* renamed from: ia */
    public SelfT ib(int i) {
        PMSAppInfo ard = ard();
        if (ard != null) {
            ard.setOrientation(i);
            return (SelfT) super.ib(i);
        }
        return (SelfT) aqJ();
    }

    @Override // com.baidu.swan.apps.u.c.e
    public long aqH() {
        return this.cvS;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.swan.apps.u.c.e
    /* renamed from: bc */
    public SelfT bd(long j) {
        if (this.cvS >= 1 || j <= 0) {
            return (SelfT) aqJ();
        }
        this.cvS = j;
        return (SelfT) super.bd(j);
    }
}
