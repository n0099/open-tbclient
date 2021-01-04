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
    private long diw;

    /* loaded from: classes9.dex */
    public static final class a extends b<a> {
        @Override // com.baidu.swan.apps.u.c.b, com.baidu.swan.apps.u.c.a.c
        public /* synthetic */ com.baidu.swan.apps.u.c.a.c D(Bundle bundle) {
            return super.D(bundle);
        }

        @Override // com.baidu.swan.apps.u.c.b, com.baidu.swan.apps.u.c.e
        public /* synthetic */ e ck(long j) {
            return super.ck(j);
        }

        @Override // com.baidu.swan.apps.u.c.b, com.baidu.swan.apps.u.c.e
        public /* synthetic */ e js(int i) {
            return super.js(i);
        }

        @Override // com.baidu.swan.apps.u.c.b, com.baidu.swan.apps.u.c.e
        public /* synthetic */ e pF(String str) {
            return super.pF(str);
        }

        @Override // com.baidu.swan.apps.u.c.b, com.baidu.swan.apps.u.c.e
        public /* synthetic */ e pG(String str) {
            return super.pG(str);
        }

        @Override // com.baidu.swan.apps.u.c.b, com.baidu.swan.apps.u.c.e
        public /* synthetic */ e pH(String str) {
            return super.pH(str);
        }

        @Override // com.baidu.swan.apps.u.c.b, com.baidu.swan.apps.u.c.e
        public /* synthetic */ e pI(String str) {
            return super.pI(str);
        }

        @Override // com.baidu.swan.apps.u.c.b, com.baidu.swan.apps.u.c.e
        public /* synthetic */ e pJ(String str) {
            return super.pJ(str);
        }

        @Override // com.baidu.swan.apps.u.c.b, com.baidu.swan.apps.u.c.e
        public /* synthetic */ e pK(String str) {
            return super.pK(str);
        }

        @Override // com.baidu.swan.apps.u.c.b, com.baidu.swan.apps.u.c.e
        public /* synthetic */ e pL(String str) {
            return super.pL(str);
        }

        @Override // com.baidu.swan.apps.u.c.b, com.baidu.swan.apps.u.c.e
        public /* synthetic */ e pM(String str) {
            return super.pM(str);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.apps.ao.e.d
        /* renamed from: aCq */
        public a aCr() {
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
            return (SelfT) aCr();
        }
        D(intent.getExtras());
        if (d.v(intent)) {
            pN("1250000000000000");
            p("box_cold_launch", -1L);
        }
        return (SelfT) aCr();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.swan.apps.u.c.a.c
    /* renamed from: C */
    public SelfT D(Bundle bundle) {
        if (bundle == null) {
            return (SelfT) aCr();
        }
        com.baidu.swan.apps.console.debugger.b.n(bundle);
        k.aHC().J(bundle);
        super.D(bundle);
        if (TextUtils.isEmpty(bundle.getString("mPage"))) {
            pW("mPage");
        }
        return (SelfT) aCr();
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

    public static b aCd() {
        a aVar = new a();
        aVar.pM("小程序测试");
        aVar.pK("wSfMyKIbrbNg7ogTFTcBuk1P8mgGTlB1");
        aVar.cl(Color.parseColor("#FF308EF0"));
        aVar.pN("1230000000000000");
        aVar.pI("小程序简介");
        aVar.pH("测试服务类目");
        aVar.pG("测试主体信息");
        aVar.pL("CdKRXT4IrCwTD6LIBS7DIlL8rmbKx58N");
        aVar.pF("1.0");
        aVar.pJ("https://gss3.bdstatic.com/9rkZsjib41gCpNKfpU_Y_D3/searchbox/aps/1516937209_WechatIMG147.jpeg");
        return aVar;
    }

    public static String a(b bVar, SwanAppConfigData swanAppConfigData) {
        return b(pw(bVar.getPage()), swanAppConfigData);
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
        String b2 = b(l, parse);
        if (TextUtils.isEmpty(b2)) {
            if (DEBUG) {
                Log.d("SwanAppLaunchInfo", "getPageInfo no launchPath ");
            }
            return null;
        }
        String deleteQueryParam = ai.deleteQueryParam(parse.getEncodedQuery(), com.baidu.swan.apps.scheme.a.a.dKI);
        if (!TextUtils.isEmpty(deleteQueryParam)) {
            b2 = b2 + "?" + deleteQueryParam;
        }
        return b(pw(b2), swanAppConfigData);
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

    public static String pw(String str) {
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
        if (com.baidu.swan.apps.ac.b.a.rB(delAllParamsFromUrl)) {
            return ai.deleteQueryParam(str, com.baidu.swan.apps.scheme.a.a.dKI);
        }
        if (swanAppConfigData.sK(j.tj(delAllParamsFromUrl))) {
            return str;
        }
        return null;
    }

    public JSONObject aCe() {
        String aCx = aCx();
        if (aCx != null) {
            String queryParameter = Uri.parse(aCx).getQueryParameter("_swaninfo");
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

    public String aww() {
        return "SwanAppLaunchInfo{mAppId='" + getAppId() + "', mAppKey='" + getAppKey() + "', mAppTitle='" + awx() + "', pmsAppInfo is null='" + aCM() + "', launchFrom='" + aCv() + "', launchScheme='" + aCx() + "', page='" + getPage() + "', mErrorCode=" + aCg() + ", mErrorDetail='" + aCh() + "', mErrorMsg='" + aCi() + "', mResumeDate='" + aCj() + "', maxSwanVersion='" + aCy() + "', minSwanVersion='" + aCz() + "', mVersion='" + getVersion() + "', mType=" + getType() + ", extraData=" + aCA() + ", isDebug=" + isDebug() + ", targetSwanVersion='" + aCG() + "', swanCoreVersion=" + avV() + ", appFrameType=" + getAppFrameType() + ", consoleSwitch=" + aCH() + ", orientation=" + getOrientation() + ", versionCode='" + getVersionCode() + "', launchFlags=" + aCI() + ", swanAppStartTime=" + aCp() + ", extStartTimestamp=" + aCJ() + ", remoteDebug='" + aCK() + "', extJSonObject=" + aCN() + ", launchId=" + aCO() + '}';
    }

    @Override // com.baidu.swan.apps.u.c.e
    public String awx() {
        PMSAppInfo aCL = aCL();
        return (aCL == null || TextUtils.isEmpty(aCL.appName)) ? super.awx() : aCL.appName;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.swan.apps.u.c.e
    /* renamed from: px */
    public SelfT pM(String str) {
        PMSAppInfo aCL = aCL();
        if (aCL != null) {
            aCL.appName = str;
        }
        return (SelfT) super.pM(str);
    }

    @Override // com.baidu.swan.apps.u.c.e
    public String getAppKey() {
        PMSAppInfo aCL = aCL();
        return (aCL == null || TextUtils.isEmpty(aCL.appKey)) ? super.getAppKey() : aCL.appKey;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.swan.apps.u.c.e
    /* renamed from: py */
    public SelfT pL(String str) {
        PMSAppInfo aCL = aCL();
        if (aCL != null) {
            aCL.appKey = str;
        }
        return (SelfT) super.pL(str);
    }

    @Override // com.baidu.swan.apps.u.c.e
    public String getAppId() {
        PMSAppInfo aCL = aCL();
        return (aCL == null || TextUtils.isEmpty(aCL.appId)) ? super.getAppId() : aCL.appId;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.swan.apps.u.c.e
    /* renamed from: pz */
    public SelfT pK(String str) {
        super.pK(str);
        PMSAppInfo aCL = aCL();
        if (aCL != null) {
            aCL.appId = str;
            return (SelfT) super.pK(str);
        }
        return (SelfT) aCr();
    }

    @Override // com.baidu.swan.apps.u.c.e
    public String getIconUrl() {
        PMSAppInfo aCL = aCL();
        return (aCL == null || TextUtils.isEmpty(aCL.iconUrl)) ? super.getIconUrl() : aCL.iconUrl;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.swan.apps.u.c.e
    /* renamed from: pA */
    public SelfT pJ(String str) {
        super.pJ(str);
        PMSAppInfo aCL = aCL();
        if (aCL != null) {
            aCL.iconUrl = str;
            return (SelfT) super.pJ(str);
        }
        return (SelfT) aCr();
    }

    @Override // com.baidu.swan.apps.u.c.e
    public String aCf() {
        PMSAppInfo aCL = aCL();
        return aCL == null ? "" : aCL.description;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.swan.apps.u.c.e
    /* renamed from: pB */
    public SelfT pI(String str) {
        PMSAppInfo aCL = aCL();
        if (aCL != null) {
            aCL.description = str;
            return (SelfT) super.pI(str);
        }
        return (SelfT) aCr();
    }

    @Override // com.baidu.swan.apps.u.c.e
    public int aCg() {
        PMSAppInfo aCL = aCL();
        if (aCL == null) {
            return 0;
        }
        return aCL.appStatus;
    }

    @Override // com.baidu.swan.apps.u.c.e
    public String aCh() {
        PMSAppInfo aCL = aCL();
        return aCL == null ? "" : aCL.statusDetail;
    }

    @Override // com.baidu.swan.apps.u.c.e
    public String aCi() {
        PMSAppInfo aCL = aCL();
        return aCL == null ? "" : aCL.statusDesc;
    }

    @Override // com.baidu.swan.apps.u.c.e
    public String aCj() {
        PMSAppInfo aCL = aCL();
        return aCL == null ? "" : aCL.resumeDate;
    }

    @Override // com.baidu.swan.apps.u.c.e
    public String aCk() {
        PMSAppInfo aCL = aCL();
        return aCL == null ? "" : aCL.serviceCategory;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.swan.apps.u.c.e
    /* renamed from: pC */
    public SelfT pH(String str) {
        PMSAppInfo aCL = aCL();
        if (aCL != null) {
            aCL.serviceCategory = str;
            return (SelfT) super.pH(str);
        }
        return (SelfT) aCr();
    }

    @Override // com.baidu.swan.apps.u.c.e
    public String aCl() {
        PMSAppInfo aCL = aCL();
        return aCL == null ? "" : aCL.subjectInfo;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.swan.apps.u.c.e
    /* renamed from: pD */
    public SelfT pG(String str) {
        PMSAppInfo aCL = aCL();
        if (aCL != null) {
            aCL.subjectInfo = str;
            return (SelfT) super.pG(str);
        }
        return (SelfT) aCr();
    }

    @Override // com.baidu.swan.apps.u.c.e
    public SwanAppBearInfo aCm() {
        PMSAppInfo aCL = aCL();
        if (aCL == null) {
            return null;
        }
        String str = aCL.bearInfo;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return new SwanAppBearInfo(str);
    }

    @Override // com.baidu.swan.apps.u.c.e
    public String aCn() {
        PMSAppInfo aCL = aCL();
        if (aCL == null) {
            return null;
        }
        return aCL.quickAppKey;
    }

    @Override // com.baidu.swan.apps.u.c.e
    public String getVersion() {
        PMSAppInfo aCL = aCL();
        return aCL == null ? "" : String.valueOf(aCL.versionCode);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.swan.apps.u.c.e
    /* renamed from: pE */
    public SelfT pF(String str) {
        PMSAppInfo aCL = aCL();
        if (!TextUtils.isEmpty(str) && aCL != null) {
            try {
                aCL.versionCode = Integer.parseInt(str);
                return (SelfT) super.pF(str);
            } catch (NumberFormatException e) {
                if (DEBUG) {
                    e.printStackTrace();
                }
            }
        }
        return (SelfT) aCr();
    }

    @Override // com.baidu.swan.apps.u.c.e
    public String getVersionCode() {
        PMSAppInfo aCL = aCL();
        return aCL == null ? "" : aCL.versionName;
    }

    @Override // com.baidu.swan.apps.u.c.e
    public int getType() {
        PMSAppInfo aCL = aCL();
        if (aCL == null) {
            return 0;
        }
        return aCL.type;
    }

    @Override // com.baidu.swan.apps.u.c.e
    public long aCo() {
        PMSAppInfo aCL = aCL();
        if (aCL == null) {
            return 0L;
        }
        return aCL.pkgSize;
    }

    @Override // com.baidu.swan.apps.u.c.e
    public int getOrientation() {
        PMSAppInfo aCL = aCL();
        int orientation = aCL == null ? -1 : aCL.getOrientation();
        return -1 < orientation ? orientation : super.getOrientation();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.swan.apps.u.c.e
    /* renamed from: jr */
    public SelfT js(int i) {
        PMSAppInfo aCL = aCL();
        if (aCL != null) {
            aCL.setOrientation(i);
            return (SelfT) super.js(i);
        }
        return (SelfT) aCr();
    }

    @Override // com.baidu.swan.apps.u.c.e
    public long aCp() {
        return this.diw;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.swan.apps.u.c.e
    /* renamed from: cj */
    public SelfT ck(long j) {
        if (this.diw >= 1 || j <= 0) {
            return (SelfT) aCr();
        }
        this.diw = j;
        return (SelfT) super.ck(j);
    }
}
