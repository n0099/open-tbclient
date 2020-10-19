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
/* loaded from: classes10.dex */
public abstract class b<SelfT extends b<SelfT>> extends e<SelfT> {
    private long cJY;

    /* loaded from: classes10.dex */
    public static final class a extends b<a> {
        @Override // com.baidu.swan.apps.u.c.b, com.baidu.swan.apps.u.c.a.c
        public /* synthetic */ com.baidu.swan.apps.u.c.a.c D(Bundle bundle) {
            return super.D(bundle);
        }

        @Override // com.baidu.swan.apps.u.c.b, com.baidu.swan.apps.u.c.e
        public /* synthetic */ e bm(long j) {
            return super.bm(j);
        }

        @Override // com.baidu.swan.apps.u.c.b, com.baidu.swan.apps.u.c.e
        public /* synthetic */ e iI(int i) {
            return super.iI(i);
        }

        @Override // com.baidu.swan.apps.u.c.b, com.baidu.swan.apps.u.c.e
        public /* synthetic */ e oE(String str) {
            return super.oE(str);
        }

        @Override // com.baidu.swan.apps.u.c.b, com.baidu.swan.apps.u.c.e
        public /* synthetic */ e oF(String str) {
            return super.oF(str);
        }

        @Override // com.baidu.swan.apps.u.c.b, com.baidu.swan.apps.u.c.e
        public /* synthetic */ e oG(String str) {
            return super.oG(str);
        }

        @Override // com.baidu.swan.apps.u.c.b, com.baidu.swan.apps.u.c.e
        public /* synthetic */ e oH(String str) {
            return super.oH(str);
        }

        @Override // com.baidu.swan.apps.u.c.b, com.baidu.swan.apps.u.c.e
        public /* synthetic */ e oI(String str) {
            return super.oI(str);
        }

        @Override // com.baidu.swan.apps.u.c.b, com.baidu.swan.apps.u.c.e
        public /* synthetic */ e oJ(String str) {
            return super.oJ(str);
        }

        @Override // com.baidu.swan.apps.u.c.b, com.baidu.swan.apps.u.c.e
        public /* synthetic */ e oK(String str) {
            return super.oK(str);
        }

        @Override // com.baidu.swan.apps.u.c.b, com.baidu.swan.apps.u.c.e
        public /* synthetic */ e oL(String str) {
            return super.oL(str);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.apps.ap.e.d
        /* renamed from: aue */
        public a auf() {
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
            return (SelfT) auf();
        }
        D(intent.getExtras());
        if (d.v(intent)) {
            oM("1250000000000000");
            n("box_cold_launch", -1L);
        }
        return (SelfT) auf();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.swan.apps.u.c.a.c
    /* renamed from: C */
    public SelfT D(Bundle bundle) {
        if (bundle == null) {
            return (SelfT) auf();
        }
        com.baidu.swan.apps.console.debugger.b.n(bundle);
        k.azp().J(bundle);
        super.D(bundle);
        if (TextUtils.isEmpty(bundle.getString("mPage"))) {
            oV("mPage");
        }
        return (SelfT) auf();
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

    public static b atR() {
        a aVar = new a();
        aVar.oL("小程序测试");
        aVar.oJ("wSfMyKIbrbNg7ogTFTcBuk1P8mgGTlB1");
        aVar.bn(Color.parseColor("#FF308EF0"));
        aVar.oM("1230000000000000");
        aVar.oH("小程序简介");
        aVar.oG("测试服务类目");
        aVar.oF("测试主体信息");
        aVar.oK("CdKRXT4IrCwTD6LIBS7DIlL8rmbKx58N");
        aVar.oE("1.0");
        aVar.oI("https://gss3.bdstatic.com/9rkZsjib41gCpNKfpU_Y_D3/searchbox/aps/1516937209_WechatIMG147.jpeg");
        return aVar;
    }

    public static String a(b bVar, SwanAppConfigData swanAppConfigData) {
        return b(ov(bVar.getPage()), swanAppConfigData);
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
        String deleteQueryParam = ai.deleteQueryParam(parse.getEncodedQuery(), com.baidu.swan.apps.scheme.a.a.dip);
        if (!TextUtils.isEmpty(deleteQueryParam)) {
            b = b + "?" + deleteQueryParam;
        }
        return b(ov(b), swanAppConfigData);
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

    public static String ov(String str) {
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
        if (com.baidu.swan.apps.ac.b.a.qA(delAllParamsFromUrl)) {
            return ai.deleteQueryParam(str, com.baidu.swan.apps.scheme.a.a.dip);
        }
        if (swanAppConfigData.rD(j.sc(delAllParamsFromUrl))) {
            return str;
        }
        return null;
    }

    public JSONObject atS() {
        String aul = aul();
        if (aul != null) {
            String queryParameter = Uri.parse(aul).getQueryParameter("_swaninfo");
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

    public String aoi() {
        return "SwanAppLaunchInfo{mAppId='" + getAppId() + "', mAppKey='" + getAppKey() + "', mAppTitle='" + aoj() + "', pmsAppInfo is null='" + auA() + "', launchFrom='" + auj() + "', launchScheme='" + aul() + "', page='" + getPage() + "', mErrorCode=" + atU() + ", mErrorDetail='" + atV() + "', mErrorMsg='" + atW() + "', mResumeDate='" + atX() + "', maxSwanVersion='" + aum() + "', minSwanVersion='" + aun() + "', mVersion='" + getVersion() + "', mType=" + getType() + ", extraData=" + auo() + ", isDebug=" + isDebug() + ", targetSwanVersion='" + auu() + "', swanCoreVersion=" + anI() + ", appFrameType=" + getAppFrameType() + ", consoleSwitch=" + auv() + ", orientation=" + getOrientation() + ", versionCode='" + getVersionCode() + "', launchFlags=" + auw() + ", swanAppStartTime=" + aud() + ", extStartTimestamp=" + aux() + ", remoteDebug='" + auy() + "', extJSonObject=" + auB() + ", launchId=" + auC() + '}';
    }

    @Override // com.baidu.swan.apps.u.c.e
    public String aoj() {
        PMSAppInfo auz = auz();
        return (auz == null || TextUtils.isEmpty(auz.appName)) ? super.aoj() : auz.appName;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.swan.apps.u.c.e
    /* renamed from: ow */
    public SelfT oL(String str) {
        PMSAppInfo auz = auz();
        if (auz != null) {
            auz.appName = str;
        }
        return (SelfT) super.oL(str);
    }

    @Override // com.baidu.swan.apps.u.c.e
    public String getAppKey() {
        PMSAppInfo auz = auz();
        return (auz == null || TextUtils.isEmpty(auz.appKey)) ? super.getAppKey() : auz.appKey;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.swan.apps.u.c.e
    /* renamed from: ox */
    public SelfT oK(String str) {
        PMSAppInfo auz = auz();
        if (auz != null) {
            auz.appKey = str;
        }
        return (SelfT) super.oK(str);
    }

    @Override // com.baidu.swan.apps.u.c.e
    public String getAppId() {
        PMSAppInfo auz = auz();
        return (auz == null || TextUtils.isEmpty(auz.appId)) ? super.getAppId() : auz.appId;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.swan.apps.u.c.e
    /* renamed from: oy */
    public SelfT oJ(String str) {
        super.oJ(str);
        PMSAppInfo auz = auz();
        if (auz != null) {
            auz.appId = str;
            return (SelfT) super.oJ(str);
        }
        return (SelfT) auf();
    }

    @Override // com.baidu.swan.apps.u.c.e
    public String getIconUrl() {
        PMSAppInfo auz = auz();
        return (auz == null || TextUtils.isEmpty(auz.iconUrl)) ? super.getIconUrl() : auz.iconUrl;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.swan.apps.u.c.e
    /* renamed from: oz */
    public SelfT oI(String str) {
        super.oI(str);
        PMSAppInfo auz = auz();
        if (auz != null) {
            auz.iconUrl = str;
            return (SelfT) super.oI(str);
        }
        return (SelfT) auf();
    }

    @Override // com.baidu.swan.apps.u.c.e
    public String atT() {
        PMSAppInfo auz = auz();
        return auz == null ? "" : auz.description;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.swan.apps.u.c.e
    /* renamed from: oA */
    public SelfT oH(String str) {
        PMSAppInfo auz = auz();
        if (auz != null) {
            auz.description = str;
            return (SelfT) super.oH(str);
        }
        return (SelfT) auf();
    }

    @Override // com.baidu.swan.apps.u.c.e
    public int atU() {
        PMSAppInfo auz = auz();
        if (auz == null) {
            return 0;
        }
        return auz.appStatus;
    }

    @Override // com.baidu.swan.apps.u.c.e
    public String atV() {
        PMSAppInfo auz = auz();
        return auz == null ? "" : auz.statusDetail;
    }

    @Override // com.baidu.swan.apps.u.c.e
    public String atW() {
        PMSAppInfo auz = auz();
        return auz == null ? "" : auz.statusDesc;
    }

    @Override // com.baidu.swan.apps.u.c.e
    public String atX() {
        PMSAppInfo auz = auz();
        return auz == null ? "" : auz.resumeDate;
    }

    @Override // com.baidu.swan.apps.u.c.e
    public String atY() {
        PMSAppInfo auz = auz();
        return auz == null ? "" : auz.serviceCategory;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.swan.apps.u.c.e
    /* renamed from: oB */
    public SelfT oG(String str) {
        PMSAppInfo auz = auz();
        if (auz != null) {
            auz.serviceCategory = str;
            return (SelfT) super.oG(str);
        }
        return (SelfT) auf();
    }

    @Override // com.baidu.swan.apps.u.c.e
    public String atZ() {
        PMSAppInfo auz = auz();
        return auz == null ? "" : auz.subjectInfo;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.swan.apps.u.c.e
    /* renamed from: oC */
    public SelfT oF(String str) {
        PMSAppInfo auz = auz();
        if (auz != null) {
            auz.subjectInfo = str;
            return (SelfT) super.oF(str);
        }
        return (SelfT) auf();
    }

    @Override // com.baidu.swan.apps.u.c.e
    public SwanAppBearInfo aua() {
        PMSAppInfo auz = auz();
        if (auz == null) {
            return null;
        }
        String str = auz.bearInfo;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return new SwanAppBearInfo(str);
    }

    @Override // com.baidu.swan.apps.u.c.e
    public String aub() {
        PMSAppInfo auz = auz();
        if (auz == null) {
            return null;
        }
        return auz.quickAppKey;
    }

    @Override // com.baidu.swan.apps.u.c.e
    public String getVersion() {
        PMSAppInfo auz = auz();
        return auz == null ? "" : String.valueOf(auz.versionCode);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.swan.apps.u.c.e
    /* renamed from: oD */
    public SelfT oE(String str) {
        PMSAppInfo auz = auz();
        if (!TextUtils.isEmpty(str) && auz != null) {
            try {
                auz.versionCode = Integer.parseInt(str);
                return (SelfT) super.oE(str);
            } catch (NumberFormatException e) {
                if (DEBUG) {
                    e.printStackTrace();
                }
            }
        }
        return (SelfT) auf();
    }

    @Override // com.baidu.swan.apps.u.c.e
    public String getVersionCode() {
        PMSAppInfo auz = auz();
        return auz == null ? "" : auz.versionName;
    }

    @Override // com.baidu.swan.apps.u.c.e
    public int getType() {
        PMSAppInfo auz = auz();
        if (auz == null) {
            return 0;
        }
        return auz.type;
    }

    @Override // com.baidu.swan.apps.u.c.e
    public long auc() {
        PMSAppInfo auz = auz();
        if (auz == null) {
            return 0L;
        }
        return auz.pkgSize;
    }

    @Override // com.baidu.swan.apps.u.c.e
    public int getOrientation() {
        PMSAppInfo auz = auz();
        int orientation = auz == null ? -1 : auz.getOrientation();
        return -1 < orientation ? orientation : super.getOrientation();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.swan.apps.u.c.e
    /* renamed from: iH */
    public SelfT iI(int i) {
        PMSAppInfo auz = auz();
        if (auz != null) {
            auz.setOrientation(i);
            return (SelfT) super.iI(i);
        }
        return (SelfT) auf();
    }

    @Override // com.baidu.swan.apps.u.c.e
    public long aud() {
        return this.cJY;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.swan.apps.u.c.e
    /* renamed from: bl */
    public SelfT bm(long j) {
        if (this.cJY >= 1 || j <= 0) {
            return (SelfT) auf();
        }
        this.cJY = j;
        return (SelfT) super.bm(j);
    }
}
