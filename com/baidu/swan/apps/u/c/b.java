package com.baidu.swan.apps.u.c;

import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.swan.apps.ao.ai;
import com.baidu.swan.apps.model.SwanAppBearInfo;
import com.baidu.swan.apps.performance.k;
import com.baidu.swan.apps.runtime.config.SwanAppConfigData;
import com.baidu.swan.apps.scheme.actions.k.j;
import com.baidu.swan.apps.u.c.b;
import com.baidu.swan.pms.model.PMSAppInfo;
import java.io.File;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes9.dex */
public abstract class b<SelfT extends b<SelfT>> extends e<SelfT> {
    private long dfS;

    /* loaded from: classes9.dex */
    public static final class a extends b<a> {
        @Override // com.baidu.swan.apps.u.c.b, com.baidu.swan.apps.u.c.a.c
        public /* synthetic */ com.baidu.swan.apps.u.c.a.c D(Bundle bundle) {
            return super.D(bundle);
        }

        @Override // com.baidu.swan.apps.u.c.b, com.baidu.swan.apps.u.c.e
        public /* synthetic */ e cq(long j) {
            return super.cq(j);
        }

        @Override // com.baidu.swan.apps.u.c.b, com.baidu.swan.apps.u.c.e
        public /* synthetic */ e hP(int i) {
            return super.hP(i);
        }

        @Override // com.baidu.swan.apps.u.c.b, com.baidu.swan.apps.u.c.e
        public /* synthetic */ e oM(String str) {
            return super.oM(str);
        }

        @Override // com.baidu.swan.apps.u.c.b, com.baidu.swan.apps.u.c.e
        public /* synthetic */ e oN(String str) {
            return super.oN(str);
        }

        @Override // com.baidu.swan.apps.u.c.b, com.baidu.swan.apps.u.c.e
        public /* synthetic */ e oO(String str) {
            return super.oO(str);
        }

        @Override // com.baidu.swan.apps.u.c.b, com.baidu.swan.apps.u.c.e
        public /* synthetic */ e oP(String str) {
            return super.oP(str);
        }

        @Override // com.baidu.swan.apps.u.c.b, com.baidu.swan.apps.u.c.e
        public /* synthetic */ e oQ(String str) {
            return super.oQ(str);
        }

        @Override // com.baidu.swan.apps.u.c.b, com.baidu.swan.apps.u.c.e
        public /* synthetic */ e oR(String str) {
            return super.oR(str);
        }

        @Override // com.baidu.swan.apps.u.c.b, com.baidu.swan.apps.u.c.e
        public /* synthetic */ e oS(String str) {
            return super.oS(str);
        }

        @Override // com.baidu.swan.apps.u.c.b, com.baidu.swan.apps.u.c.e
        public /* synthetic */ e oT(String str) {
            return super.oT(str);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.apps.ao.e.d
        /* renamed from: ayV */
        public a ayW() {
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
            return (SelfT) ayW();
        }
        D(intent.getExtras());
        if (d.v(intent)) {
            oU("1250000000000000");
            o("box_cold_launch", -1L);
        }
        return (SelfT) ayW();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.swan.apps.u.c.a.c
    /* renamed from: C */
    public SelfT D(Bundle bundle) {
        if (bundle == null) {
            return (SelfT) ayW();
        }
        com.baidu.swan.apps.console.debugger.b.n(bundle);
        k.aEe().J(bundle);
        super.D(bundle);
        if (TextUtils.isEmpty(bundle.getString("mPage"))) {
            pd("mPage");
        }
        return (SelfT) ayW();
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

    public static b ayI() {
        a aVar = new a();
        aVar.oT("小程序测试");
        aVar.oR("wSfMyKIbrbNg7ogTFTcBuk1P8mgGTlB1");
        aVar.cr(Color.parseColor("#FF308EF0"));
        aVar.oU("1230000000000000");
        aVar.oP("小程序简介");
        aVar.oO("测试服务类目");
        aVar.oN("测试主体信息");
        aVar.oS("CdKRXT4IrCwTD6LIBS7DIlL8rmbKx58N");
        aVar.oM("1.0");
        aVar.oQ("https://gss3.bdstatic.com/9rkZsjib41gCpNKfpU_Y_D3/searchbox/aps/1516937209_WechatIMG147.jpeg");
        return aVar;
    }

    public static String a(b bVar, SwanAppConfigData swanAppConfigData) {
        return b(oD(bVar.getPage()), swanAppConfigData);
    }

    public static String a(String str, SwanAppConfigData swanAppConfigData) {
        if (TextUtils.isEmpty(str) || swanAppConfigData == null) {
            if (DEBUG) {
                Log.d("SwanAppLaunchInfo", "getPageInfo ret null - " + str);
            }
            return null;
        }
        Uri parse = Uri.parse(str);
        String l = ai.l(parse);
        if (TextUtils.isEmpty(l)) {
            if (DEBUG) {
                Log.d("SwanAppLaunchInfo", "getPageInfo appId is null");
            }
            return null;
        }
        String a2 = a(l, parse);
        if (TextUtils.isEmpty(a2)) {
            if (DEBUG) {
                Log.d("SwanAppLaunchInfo", "getPageInfo no launchPath ");
            }
            return null;
        }
        String deleteQueryParam = ai.deleteQueryParam(parse.getEncodedQuery(), com.baidu.swan.apps.scheme.a.a.dIa);
        if (!TextUtils.isEmpty(deleteQueryParam)) {
            a2 = a2 + "?" + deleteQueryParam;
        }
        return b(oD(a2), swanAppConfigData);
    }

    private static String a(String str, Uri uri) {
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

    public static String oD(String str) {
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
        if (com.baidu.swan.apps.ac.b.a.qI(delAllParamsFromUrl)) {
            return ai.deleteQueryParam(str, com.baidu.swan.apps.scheme.a.a.dIa);
        }
        if (swanAppConfigData.rR(j.sq(delAllParamsFromUrl))) {
            return str;
        }
        return null;
    }

    public JSONObject ayJ() {
        String azc = azc();
        if (azc != null) {
            String queryParameter = Uri.parse(azc).getQueryParameter("_swaninfo");
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

    public String atb() {
        return "SwanAppLaunchInfo{mAppId='" + getAppId() + "', mAppKey='" + getAppKey() + "', mAppTitle='" + atc() + "', pmsAppInfo is null='" + azr() + "', launchFrom='" + aza() + "', launchScheme='" + azc() + "', page='" + getPage() + "', mErrorCode=" + ayL() + ", mErrorDetail='" + ayM() + "', mErrorMsg='" + ayN() + "', mResumeDate='" + ayO() + "', maxSwanVersion='" + azd() + "', minSwanVersion='" + aze() + "', mVersion='" + getVersion() + "', mType=" + getType() + ", extraData=" + azf() + ", isDebug=" + isDebug() + ", targetSwanVersion='" + azl() + "', swanCoreVersion=" + asA() + ", appFrameType=" + getAppFrameType() + ", consoleSwitch=" + azm() + ", orientation=" + getOrientation() + ", versionCode='" + getVersionCode() + "', launchFlags=" + azn() + ", swanAppStartTime=" + ayU() + ", extStartTimestamp=" + azo() + ", remoteDebug='" + azp() + "', extJSonObject=" + azs() + ", launchId=" + azt() + '}';
    }

    @Override // com.baidu.swan.apps.u.c.e
    public String atc() {
        PMSAppInfo azq = azq();
        return (azq == null || TextUtils.isEmpty(azq.appName)) ? super.atc() : azq.appName;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.swan.apps.u.c.e
    /* renamed from: oE */
    public SelfT oT(String str) {
        PMSAppInfo azq = azq();
        if (azq != null) {
            azq.appName = str;
        }
        return (SelfT) super.oT(str);
    }

    @Override // com.baidu.swan.apps.u.c.e
    public String getAppKey() {
        PMSAppInfo azq = azq();
        return (azq == null || TextUtils.isEmpty(azq.appKey)) ? super.getAppKey() : azq.appKey;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.swan.apps.u.c.e
    /* renamed from: oF */
    public SelfT oS(String str) {
        PMSAppInfo azq = azq();
        if (azq != null) {
            azq.appKey = str;
        }
        return (SelfT) super.oS(str);
    }

    @Override // com.baidu.swan.apps.u.c.e
    public String getAppId() {
        PMSAppInfo azq = azq();
        return (azq == null || TextUtils.isEmpty(azq.appId)) ? super.getAppId() : azq.appId;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.swan.apps.u.c.e
    /* renamed from: oG */
    public SelfT oR(String str) {
        super.oR(str);
        PMSAppInfo azq = azq();
        if (azq != null) {
            azq.appId = str;
            return (SelfT) super.oR(str);
        }
        return (SelfT) ayW();
    }

    @Override // com.baidu.swan.apps.u.c.e
    public String getIconUrl() {
        PMSAppInfo azq = azq();
        return (azq == null || TextUtils.isEmpty(azq.iconUrl)) ? super.getIconUrl() : azq.iconUrl;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.swan.apps.u.c.e
    /* renamed from: oH */
    public SelfT oQ(String str) {
        super.oQ(str);
        PMSAppInfo azq = azq();
        if (azq != null) {
            azq.iconUrl = str;
            return (SelfT) super.oQ(str);
        }
        return (SelfT) ayW();
    }

    @Override // com.baidu.swan.apps.u.c.e
    public String ayK() {
        PMSAppInfo azq = azq();
        return azq == null ? "" : azq.description;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.swan.apps.u.c.e
    /* renamed from: oI */
    public SelfT oP(String str) {
        PMSAppInfo azq = azq();
        if (azq != null) {
            azq.description = str;
            return (SelfT) super.oP(str);
        }
        return (SelfT) ayW();
    }

    @Override // com.baidu.swan.apps.u.c.e
    public int ayL() {
        PMSAppInfo azq = azq();
        if (azq == null) {
            return 0;
        }
        return azq.appStatus;
    }

    @Override // com.baidu.swan.apps.u.c.e
    public String ayM() {
        PMSAppInfo azq = azq();
        return azq == null ? "" : azq.statusDetail;
    }

    @Override // com.baidu.swan.apps.u.c.e
    public String ayN() {
        PMSAppInfo azq = azq();
        return azq == null ? "" : azq.statusDesc;
    }

    @Override // com.baidu.swan.apps.u.c.e
    public String ayO() {
        PMSAppInfo azq = azq();
        return azq == null ? "" : azq.resumeDate;
    }

    @Override // com.baidu.swan.apps.u.c.e
    public String ayP() {
        PMSAppInfo azq = azq();
        return azq == null ? "" : azq.serviceCategory;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.swan.apps.u.c.e
    /* renamed from: oJ */
    public SelfT oO(String str) {
        PMSAppInfo azq = azq();
        if (azq != null) {
            azq.serviceCategory = str;
            return (SelfT) super.oO(str);
        }
        return (SelfT) ayW();
    }

    @Override // com.baidu.swan.apps.u.c.e
    public String ayQ() {
        PMSAppInfo azq = azq();
        return azq == null ? "" : azq.subjectInfo;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.swan.apps.u.c.e
    /* renamed from: oK */
    public SelfT oN(String str) {
        PMSAppInfo azq = azq();
        if (azq != null) {
            azq.subjectInfo = str;
            return (SelfT) super.oN(str);
        }
        return (SelfT) ayW();
    }

    @Override // com.baidu.swan.apps.u.c.e
    public SwanAppBearInfo ayR() {
        PMSAppInfo azq = azq();
        if (azq == null) {
            return null;
        }
        String str = azq.bearInfo;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return new SwanAppBearInfo(str);
    }

    @Override // com.baidu.swan.apps.u.c.e
    public String ayS() {
        PMSAppInfo azq = azq();
        if (azq == null) {
            return null;
        }
        return azq.quickAppKey;
    }

    @Override // com.baidu.swan.apps.u.c.e
    public String getVersion() {
        PMSAppInfo azq = azq();
        return azq == null ? "" : String.valueOf(azq.versionCode);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.swan.apps.u.c.e
    /* renamed from: oL */
    public SelfT oM(String str) {
        PMSAppInfo azq = azq();
        if (!TextUtils.isEmpty(str) && azq != null) {
            try {
                azq.versionCode = Integer.parseInt(str);
                return (SelfT) super.oM(str);
            } catch (NumberFormatException e) {
                if (DEBUG) {
                    e.printStackTrace();
                }
            }
        }
        return (SelfT) ayW();
    }

    @Override // com.baidu.swan.apps.u.c.e
    public String getVersionCode() {
        PMSAppInfo azq = azq();
        return azq == null ? "" : azq.versionName;
    }

    @Override // com.baidu.swan.apps.u.c.e
    public int getType() {
        PMSAppInfo azq = azq();
        if (azq == null) {
            return 0;
        }
        return azq.type;
    }

    @Override // com.baidu.swan.apps.u.c.e
    public long ayT() {
        PMSAppInfo azq = azq();
        if (azq == null) {
            return 0L;
        }
        return azq.pkgSize;
    }

    @Override // com.baidu.swan.apps.u.c.e
    public int getOrientation() {
        PMSAppInfo azq = azq();
        int orientation = azq == null ? -1 : azq.getOrientation();
        return -1 < orientation ? orientation : super.getOrientation();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.swan.apps.u.c.e
    /* renamed from: hO */
    public SelfT hP(int i) {
        PMSAppInfo azq = azq();
        if (azq != null) {
            azq.setOrientation(i);
            return (SelfT) super.hP(i);
        }
        return (SelfT) ayW();
    }

    @Override // com.baidu.swan.apps.u.c.e
    public long ayU() {
        return this.dfS;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.swan.apps.u.c.e
    /* renamed from: cp */
    public SelfT cq(long j) {
        if (this.dfS >= 1 || j <= 0) {
            return (SelfT) ayW();
        }
        this.dfS = j;
        return (SelfT) super.cq(j);
    }
}
