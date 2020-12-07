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
/* loaded from: classes25.dex */
public abstract class b<SelfT extends b<SelfT>> extends e<SelfT> {
    private long ddB;

    /* loaded from: classes25.dex */
    public static final class a extends b<a> {
        @Override // com.baidu.swan.apps.u.c.b, com.baidu.swan.apps.u.c.a.c
        public /* synthetic */ com.baidu.swan.apps.u.c.a.c D(Bundle bundle) {
            return super.D(bundle);
        }

        @Override // com.baidu.swan.apps.u.c.b, com.baidu.swan.apps.u.c.e
        public /* synthetic */ e cj(long j) {
            return super.cj(j);
        }

        @Override // com.baidu.swan.apps.u.c.b, com.baidu.swan.apps.u.c.e
        public /* synthetic */ e jx(int i) {
            return super.jx(i);
        }

        @Override // com.baidu.swan.apps.u.c.b, com.baidu.swan.apps.u.c.e
        public /* synthetic */ e pM(String str) {
            return super.pM(str);
        }

        @Override // com.baidu.swan.apps.u.c.b, com.baidu.swan.apps.u.c.e
        public /* synthetic */ e pN(String str) {
            return super.pN(str);
        }

        @Override // com.baidu.swan.apps.u.c.b, com.baidu.swan.apps.u.c.e
        public /* synthetic */ e pO(String str) {
            return super.pO(str);
        }

        @Override // com.baidu.swan.apps.u.c.b, com.baidu.swan.apps.u.c.e
        public /* synthetic */ e pP(String str) {
            return super.pP(str);
        }

        @Override // com.baidu.swan.apps.u.c.b, com.baidu.swan.apps.u.c.e
        public /* synthetic */ e pQ(String str) {
            return super.pQ(str);
        }

        @Override // com.baidu.swan.apps.u.c.b, com.baidu.swan.apps.u.c.e
        public /* synthetic */ e pR(String str) {
            return super.pR(str);
        }

        @Override // com.baidu.swan.apps.u.c.b, com.baidu.swan.apps.u.c.e
        public /* synthetic */ e pS(String str) {
            return super.pS(str);
        }

        @Override // com.baidu.swan.apps.u.c.b, com.baidu.swan.apps.u.c.e
        public /* synthetic */ e pT(String str) {
            return super.pT(str);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.apps.ap.e.d
        /* renamed from: aAZ */
        public a aBa() {
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
            return (SelfT) aBa();
        }
        D(intent.getExtras());
        if (d.v(intent)) {
            pU("1250000000000000");
            p("box_cold_launch", -1L);
        }
        return (SelfT) aBa();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.swan.apps.u.c.a.c
    /* renamed from: C */
    public SelfT D(Bundle bundle) {
        if (bundle == null) {
            return (SelfT) aBa();
        }
        com.baidu.swan.apps.console.debugger.b.n(bundle);
        k.aGj().J(bundle);
        super.D(bundle);
        if (TextUtils.isEmpty(bundle.getString("mPage"))) {
            qd("mPage");
        }
        return (SelfT) aBa();
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

    public static b aAM() {
        a aVar = new a();
        aVar.pT("小程序测试");
        aVar.pR("wSfMyKIbrbNg7ogTFTcBuk1P8mgGTlB1");
        aVar.ck(Color.parseColor("#FF308EF0"));
        aVar.pU("1230000000000000");
        aVar.pP("小程序简介");
        aVar.pO("测试服务类目");
        aVar.pN("测试主体信息");
        aVar.pS("CdKRXT4IrCwTD6LIBS7DIlL8rmbKx58N");
        aVar.pM("1.0");
        aVar.pQ("https://gss3.bdstatic.com/9rkZsjib41gCpNKfpU_Y_D3/searchbox/aps/1516937209_WechatIMG147.jpeg");
        return aVar;
    }

    public static String a(b bVar, SwanAppConfigData swanAppConfigData) {
        return b(pD(bVar.getPage()), swanAppConfigData);
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
        String deleteQueryParam = ai.deleteQueryParam(parse.getEncodedQuery(), com.baidu.swan.apps.scheme.a.a.dCd);
        if (!TextUtils.isEmpty(deleteQueryParam)) {
            b = b + "?" + deleteQueryParam;
        }
        return b(pD(b), swanAppConfigData);
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

    public static String pD(String str) {
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
        if (com.baidu.swan.apps.ac.b.a.rI(delAllParamsFromUrl)) {
            return ai.deleteQueryParam(str, com.baidu.swan.apps.scheme.a.a.dCd);
        }
        if (swanAppConfigData.sN(j.tm(delAllParamsFromUrl))) {
            return str;
        }
        return null;
    }

    public JSONObject aAN() {
        String aBg = aBg();
        if (aBg != null) {
            String queryParameter = Uri.parse(aBg).getQueryParameter("_swaninfo");
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

    public String ave() {
        return "SwanAppLaunchInfo{mAppId='" + getAppId() + "', mAppKey='" + getAppKey() + "', mAppTitle='" + avf() + "', pmsAppInfo is null='" + aBv() + "', launchFrom='" + aBe() + "', launchScheme='" + aBg() + "', page='" + getPage() + "', mErrorCode=" + aAP() + ", mErrorDetail='" + aAQ() + "', mErrorMsg='" + aAR() + "', mResumeDate='" + aAS() + "', maxSwanVersion='" + aBh() + "', minSwanVersion='" + aBi() + "', mVersion='" + getVersion() + "', mType=" + getType() + ", extraData=" + aBj() + ", isDebug=" + isDebug() + ", targetSwanVersion='" + aBp() + "', swanCoreVersion=" + auD() + ", appFrameType=" + getAppFrameType() + ", consoleSwitch=" + aBq() + ", orientation=" + getOrientation() + ", versionCode='" + getVersionCode() + "', launchFlags=" + aBr() + ", swanAppStartTime=" + aAY() + ", extStartTimestamp=" + aBs() + ", remoteDebug='" + aBt() + "', extJSonObject=" + aBw() + ", launchId=" + aBx() + '}';
    }

    @Override // com.baidu.swan.apps.u.c.e
    public String avf() {
        PMSAppInfo aBu = aBu();
        return (aBu == null || TextUtils.isEmpty(aBu.appName)) ? super.avf() : aBu.appName;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.swan.apps.u.c.e
    /* renamed from: pE */
    public SelfT pT(String str) {
        PMSAppInfo aBu = aBu();
        if (aBu != null) {
            aBu.appName = str;
        }
        return (SelfT) super.pT(str);
    }

    @Override // com.baidu.swan.apps.u.c.e
    public String getAppKey() {
        PMSAppInfo aBu = aBu();
        return (aBu == null || TextUtils.isEmpty(aBu.appKey)) ? super.getAppKey() : aBu.appKey;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.swan.apps.u.c.e
    /* renamed from: pF */
    public SelfT pS(String str) {
        PMSAppInfo aBu = aBu();
        if (aBu != null) {
            aBu.appKey = str;
        }
        return (SelfT) super.pS(str);
    }

    @Override // com.baidu.swan.apps.u.c.e
    public String getAppId() {
        PMSAppInfo aBu = aBu();
        return (aBu == null || TextUtils.isEmpty(aBu.appId)) ? super.getAppId() : aBu.appId;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.swan.apps.u.c.e
    /* renamed from: pG */
    public SelfT pR(String str) {
        super.pR(str);
        PMSAppInfo aBu = aBu();
        if (aBu != null) {
            aBu.appId = str;
            return (SelfT) super.pR(str);
        }
        return (SelfT) aBa();
    }

    @Override // com.baidu.swan.apps.u.c.e
    public String getIconUrl() {
        PMSAppInfo aBu = aBu();
        return (aBu == null || TextUtils.isEmpty(aBu.iconUrl)) ? super.getIconUrl() : aBu.iconUrl;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.swan.apps.u.c.e
    /* renamed from: pH */
    public SelfT pQ(String str) {
        super.pQ(str);
        PMSAppInfo aBu = aBu();
        if (aBu != null) {
            aBu.iconUrl = str;
            return (SelfT) super.pQ(str);
        }
        return (SelfT) aBa();
    }

    @Override // com.baidu.swan.apps.u.c.e
    public String aAO() {
        PMSAppInfo aBu = aBu();
        return aBu == null ? "" : aBu.description;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.swan.apps.u.c.e
    /* renamed from: pI */
    public SelfT pP(String str) {
        PMSAppInfo aBu = aBu();
        if (aBu != null) {
            aBu.description = str;
            return (SelfT) super.pP(str);
        }
        return (SelfT) aBa();
    }

    @Override // com.baidu.swan.apps.u.c.e
    public int aAP() {
        PMSAppInfo aBu = aBu();
        if (aBu == null) {
            return 0;
        }
        return aBu.appStatus;
    }

    @Override // com.baidu.swan.apps.u.c.e
    public String aAQ() {
        PMSAppInfo aBu = aBu();
        return aBu == null ? "" : aBu.statusDetail;
    }

    @Override // com.baidu.swan.apps.u.c.e
    public String aAR() {
        PMSAppInfo aBu = aBu();
        return aBu == null ? "" : aBu.statusDesc;
    }

    @Override // com.baidu.swan.apps.u.c.e
    public String aAS() {
        PMSAppInfo aBu = aBu();
        return aBu == null ? "" : aBu.resumeDate;
    }

    @Override // com.baidu.swan.apps.u.c.e
    public String aAT() {
        PMSAppInfo aBu = aBu();
        return aBu == null ? "" : aBu.serviceCategory;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.swan.apps.u.c.e
    /* renamed from: pJ */
    public SelfT pO(String str) {
        PMSAppInfo aBu = aBu();
        if (aBu != null) {
            aBu.serviceCategory = str;
            return (SelfT) super.pO(str);
        }
        return (SelfT) aBa();
    }

    @Override // com.baidu.swan.apps.u.c.e
    public String aAU() {
        PMSAppInfo aBu = aBu();
        return aBu == null ? "" : aBu.subjectInfo;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.swan.apps.u.c.e
    /* renamed from: pK */
    public SelfT pN(String str) {
        PMSAppInfo aBu = aBu();
        if (aBu != null) {
            aBu.subjectInfo = str;
            return (SelfT) super.pN(str);
        }
        return (SelfT) aBa();
    }

    @Override // com.baidu.swan.apps.u.c.e
    public SwanAppBearInfo aAV() {
        PMSAppInfo aBu = aBu();
        if (aBu == null) {
            return null;
        }
        String str = aBu.bearInfo;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return new SwanAppBearInfo(str);
    }

    @Override // com.baidu.swan.apps.u.c.e
    public String aAW() {
        PMSAppInfo aBu = aBu();
        if (aBu == null) {
            return null;
        }
        return aBu.quickAppKey;
    }

    @Override // com.baidu.swan.apps.u.c.e
    public String getVersion() {
        PMSAppInfo aBu = aBu();
        return aBu == null ? "" : String.valueOf(aBu.versionCode);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.swan.apps.u.c.e
    /* renamed from: pL */
    public SelfT pM(String str) {
        PMSAppInfo aBu = aBu();
        if (!TextUtils.isEmpty(str) && aBu != null) {
            try {
                aBu.versionCode = Integer.parseInt(str);
                return (SelfT) super.pM(str);
            } catch (NumberFormatException e) {
                if (DEBUG) {
                    e.printStackTrace();
                }
            }
        }
        return (SelfT) aBa();
    }

    @Override // com.baidu.swan.apps.u.c.e
    public String getVersionCode() {
        PMSAppInfo aBu = aBu();
        return aBu == null ? "" : aBu.versionName;
    }

    @Override // com.baidu.swan.apps.u.c.e
    public int getType() {
        PMSAppInfo aBu = aBu();
        if (aBu == null) {
            return 0;
        }
        return aBu.type;
    }

    @Override // com.baidu.swan.apps.u.c.e
    public long aAX() {
        PMSAppInfo aBu = aBu();
        if (aBu == null) {
            return 0L;
        }
        return aBu.pkgSize;
    }

    @Override // com.baidu.swan.apps.u.c.e
    public int getOrientation() {
        PMSAppInfo aBu = aBu();
        int orientation = aBu == null ? -1 : aBu.getOrientation();
        return -1 < orientation ? orientation : super.getOrientation();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.swan.apps.u.c.e
    /* renamed from: jw */
    public SelfT jx(int i) {
        PMSAppInfo aBu = aBu();
        if (aBu != null) {
            aBu.setOrientation(i);
            return (SelfT) super.jx(i);
        }
        return (SelfT) aBa();
    }

    @Override // com.baidu.swan.apps.u.c.e
    public long aAY() {
        return this.ddB;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.swan.apps.u.c.e
    /* renamed from: ci */
    public SelfT cj(long j) {
        if (this.ddB >= 1 || j <= 0) {
            return (SelfT) aBa();
        }
        this.ddB = j;
        return (SelfT) super.cj(j);
    }
}
