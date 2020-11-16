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
/* loaded from: classes7.dex */
public abstract class b<SelfT extends b<SelfT>> extends e<SelfT> {
    private long cWD;

    /* loaded from: classes7.dex */
    public static final class a extends b<a> {
        @Override // com.baidu.swan.apps.u.c.b, com.baidu.swan.apps.u.c.a.c
        public /* synthetic */ com.baidu.swan.apps.u.c.a.c D(Bundle bundle) {
            return super.D(bundle);
        }

        @Override // com.baidu.swan.apps.u.c.b, com.baidu.swan.apps.u.c.e
        public /* synthetic */ e bK(long j) {
            return super.bK(j);
        }

        @Override // com.baidu.swan.apps.u.c.b, com.baidu.swan.apps.u.c.e
        public /* synthetic */ e iZ(int i) {
            return super.iZ(i);
        }

        @Override // com.baidu.swan.apps.u.c.b, com.baidu.swan.apps.u.c.e
        public /* synthetic */ e pf(String str) {
            return super.pf(str);
        }

        @Override // com.baidu.swan.apps.u.c.b, com.baidu.swan.apps.u.c.e
        public /* synthetic */ e pg(String str) {
            return super.pg(str);
        }

        @Override // com.baidu.swan.apps.u.c.b, com.baidu.swan.apps.u.c.e
        public /* synthetic */ e ph(String str) {
            return super.ph(str);
        }

        @Override // com.baidu.swan.apps.u.c.b, com.baidu.swan.apps.u.c.e
        public /* synthetic */ e pi(String str) {
            return super.pi(str);
        }

        @Override // com.baidu.swan.apps.u.c.b, com.baidu.swan.apps.u.c.e
        public /* synthetic */ e pj(String str) {
            return super.pj(str);
        }

        @Override // com.baidu.swan.apps.u.c.b, com.baidu.swan.apps.u.c.e
        public /* synthetic */ e pk(String str) {
            return super.pk(str);
        }

        @Override // com.baidu.swan.apps.u.c.b, com.baidu.swan.apps.u.c.e
        public /* synthetic */ e pl(String str) {
            return super.pl(str);
        }

        @Override // com.baidu.swan.apps.u.c.b, com.baidu.swan.apps.u.c.e
        public /* synthetic */ e pm(String str) {
            return super.pm(str);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.apps.ap.e.d
        /* renamed from: axQ */
        public a axR() {
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
            return (SelfT) axR();
        }
        D(intent.getExtras());
        if (d.v(intent)) {
            pn("1250000000000000");
            p("box_cold_launch", -1L);
        }
        return (SelfT) axR();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.swan.apps.u.c.a.c
    /* renamed from: C */
    public SelfT D(Bundle bundle) {
        if (bundle == null) {
            return (SelfT) axR();
        }
        com.baidu.swan.apps.console.debugger.b.n(bundle);
        k.aDb().J(bundle);
        super.D(bundle);
        if (TextUtils.isEmpty(bundle.getString("mPage"))) {
            pw("mPage");
        }
        return (SelfT) axR();
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

    public static b axD() {
        a aVar = new a();
        aVar.pm("小程序测试");
        aVar.pk("wSfMyKIbrbNg7ogTFTcBuk1P8mgGTlB1");
        aVar.bL(Color.parseColor("#FF308EF0"));
        aVar.pn("1230000000000000");
        aVar.pi("小程序简介");
        aVar.ph("测试服务类目");
        aVar.pg("测试主体信息");
        aVar.pl("CdKRXT4IrCwTD6LIBS7DIlL8rmbKx58N");
        aVar.pf("1.0");
        aVar.pj("https://gss3.bdstatic.com/9rkZsjib41gCpNKfpU_Y_D3/searchbox/aps/1516937209_WechatIMG147.jpeg");
        return aVar;
    }

    public static String a(b bVar, SwanAppConfigData swanAppConfigData) {
        return b(oW(bVar.getPage()), swanAppConfigData);
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
        String deleteQueryParam = ai.deleteQueryParam(parse.getEncodedQuery(), com.baidu.swan.apps.scheme.a.a.dve);
        if (!TextUtils.isEmpty(deleteQueryParam)) {
            b = b + "?" + deleteQueryParam;
        }
        return b(oW(b), swanAppConfigData);
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

    public static String oW(String str) {
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
        if (com.baidu.swan.apps.ac.b.a.rb(delAllParamsFromUrl)) {
            return ai.deleteQueryParam(str, com.baidu.swan.apps.scheme.a.a.dve);
        }
        if (swanAppConfigData.sf(j.sF(delAllParamsFromUrl))) {
            return str;
        }
        return null;
    }

    public JSONObject axE() {
        String axX = axX();
        if (axX != null) {
            String queryParameter = Uri.parse(axX).getQueryParameter("_swaninfo");
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

    public String arV() {
        return "SwanAppLaunchInfo{mAppId='" + getAppId() + "', mAppKey='" + getAppKey() + "', mAppTitle='" + arW() + "', pmsAppInfo is null='" + aym() + "', launchFrom='" + axV() + "', launchScheme='" + axX() + "', page='" + getPage() + "', mErrorCode=" + axG() + ", mErrorDetail='" + axH() + "', mErrorMsg='" + axI() + "', mResumeDate='" + axJ() + "', maxSwanVersion='" + axY() + "', minSwanVersion='" + axZ() + "', mVersion='" + getVersion() + "', mType=" + getType() + ", extraData=" + aya() + ", isDebug=" + isDebug() + ", targetSwanVersion='" + ayg() + "', swanCoreVersion=" + arv() + ", appFrameType=" + getAppFrameType() + ", consoleSwitch=" + ayh() + ", orientation=" + getOrientation() + ", versionCode='" + getVersionCode() + "', launchFlags=" + ayi() + ", swanAppStartTime=" + axP() + ", extStartTimestamp=" + ayj() + ", remoteDebug='" + ayk() + "', extJSonObject=" + ayn() + ", launchId=" + ayo() + '}';
    }

    @Override // com.baidu.swan.apps.u.c.e
    public String arW() {
        PMSAppInfo ayl = ayl();
        return (ayl == null || TextUtils.isEmpty(ayl.appName)) ? super.arW() : ayl.appName;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.swan.apps.u.c.e
    /* renamed from: oX */
    public SelfT pm(String str) {
        PMSAppInfo ayl = ayl();
        if (ayl != null) {
            ayl.appName = str;
        }
        return (SelfT) super.pm(str);
    }

    @Override // com.baidu.swan.apps.u.c.e
    public String getAppKey() {
        PMSAppInfo ayl = ayl();
        return (ayl == null || TextUtils.isEmpty(ayl.appKey)) ? super.getAppKey() : ayl.appKey;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.swan.apps.u.c.e
    /* renamed from: oY */
    public SelfT pl(String str) {
        PMSAppInfo ayl = ayl();
        if (ayl != null) {
            ayl.appKey = str;
        }
        return (SelfT) super.pl(str);
    }

    @Override // com.baidu.swan.apps.u.c.e
    public String getAppId() {
        PMSAppInfo ayl = ayl();
        return (ayl == null || TextUtils.isEmpty(ayl.appId)) ? super.getAppId() : ayl.appId;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.swan.apps.u.c.e
    /* renamed from: oZ */
    public SelfT pk(String str) {
        super.pk(str);
        PMSAppInfo ayl = ayl();
        if (ayl != null) {
            ayl.appId = str;
            return (SelfT) super.pk(str);
        }
        return (SelfT) axR();
    }

    @Override // com.baidu.swan.apps.u.c.e
    public String getIconUrl() {
        PMSAppInfo ayl = ayl();
        return (ayl == null || TextUtils.isEmpty(ayl.iconUrl)) ? super.getIconUrl() : ayl.iconUrl;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.swan.apps.u.c.e
    /* renamed from: pa */
    public SelfT pj(String str) {
        super.pj(str);
        PMSAppInfo ayl = ayl();
        if (ayl != null) {
            ayl.iconUrl = str;
            return (SelfT) super.pj(str);
        }
        return (SelfT) axR();
    }

    @Override // com.baidu.swan.apps.u.c.e
    public String axF() {
        PMSAppInfo ayl = ayl();
        return ayl == null ? "" : ayl.description;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.swan.apps.u.c.e
    /* renamed from: pb */
    public SelfT pi(String str) {
        PMSAppInfo ayl = ayl();
        if (ayl != null) {
            ayl.description = str;
            return (SelfT) super.pi(str);
        }
        return (SelfT) axR();
    }

    @Override // com.baidu.swan.apps.u.c.e
    public int axG() {
        PMSAppInfo ayl = ayl();
        if (ayl == null) {
            return 0;
        }
        return ayl.appStatus;
    }

    @Override // com.baidu.swan.apps.u.c.e
    public String axH() {
        PMSAppInfo ayl = ayl();
        return ayl == null ? "" : ayl.statusDetail;
    }

    @Override // com.baidu.swan.apps.u.c.e
    public String axI() {
        PMSAppInfo ayl = ayl();
        return ayl == null ? "" : ayl.statusDesc;
    }

    @Override // com.baidu.swan.apps.u.c.e
    public String axJ() {
        PMSAppInfo ayl = ayl();
        return ayl == null ? "" : ayl.resumeDate;
    }

    @Override // com.baidu.swan.apps.u.c.e
    public String axK() {
        PMSAppInfo ayl = ayl();
        return ayl == null ? "" : ayl.serviceCategory;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.swan.apps.u.c.e
    /* renamed from: pc */
    public SelfT ph(String str) {
        PMSAppInfo ayl = ayl();
        if (ayl != null) {
            ayl.serviceCategory = str;
            return (SelfT) super.ph(str);
        }
        return (SelfT) axR();
    }

    @Override // com.baidu.swan.apps.u.c.e
    public String axL() {
        PMSAppInfo ayl = ayl();
        return ayl == null ? "" : ayl.subjectInfo;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.swan.apps.u.c.e
    /* renamed from: pd */
    public SelfT pg(String str) {
        PMSAppInfo ayl = ayl();
        if (ayl != null) {
            ayl.subjectInfo = str;
            return (SelfT) super.pg(str);
        }
        return (SelfT) axR();
    }

    @Override // com.baidu.swan.apps.u.c.e
    public SwanAppBearInfo axM() {
        PMSAppInfo ayl = ayl();
        if (ayl == null) {
            return null;
        }
        String str = ayl.bearInfo;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return new SwanAppBearInfo(str);
    }

    @Override // com.baidu.swan.apps.u.c.e
    public String axN() {
        PMSAppInfo ayl = ayl();
        if (ayl == null) {
            return null;
        }
        return ayl.quickAppKey;
    }

    @Override // com.baidu.swan.apps.u.c.e
    public String getVersion() {
        PMSAppInfo ayl = ayl();
        return ayl == null ? "" : String.valueOf(ayl.versionCode);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.swan.apps.u.c.e
    /* renamed from: pe */
    public SelfT pf(String str) {
        PMSAppInfo ayl = ayl();
        if (!TextUtils.isEmpty(str) && ayl != null) {
            try {
                ayl.versionCode = Integer.parseInt(str);
                return (SelfT) super.pf(str);
            } catch (NumberFormatException e) {
                if (DEBUG) {
                    e.printStackTrace();
                }
            }
        }
        return (SelfT) axR();
    }

    @Override // com.baidu.swan.apps.u.c.e
    public String getVersionCode() {
        PMSAppInfo ayl = ayl();
        return ayl == null ? "" : ayl.versionName;
    }

    @Override // com.baidu.swan.apps.u.c.e
    public int getType() {
        PMSAppInfo ayl = ayl();
        if (ayl == null) {
            return 0;
        }
        return ayl.type;
    }

    @Override // com.baidu.swan.apps.u.c.e
    public long axO() {
        PMSAppInfo ayl = ayl();
        if (ayl == null) {
            return 0L;
        }
        return ayl.pkgSize;
    }

    @Override // com.baidu.swan.apps.u.c.e
    public int getOrientation() {
        PMSAppInfo ayl = ayl();
        int orientation = ayl == null ? -1 : ayl.getOrientation();
        return -1 < orientation ? orientation : super.getOrientation();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.swan.apps.u.c.e
    /* renamed from: iY */
    public SelfT iZ(int i) {
        PMSAppInfo ayl = ayl();
        if (ayl != null) {
            ayl.setOrientation(i);
            return (SelfT) super.iZ(i);
        }
        return (SelfT) axR();
    }

    @Override // com.baidu.swan.apps.u.c.e
    public long axP() {
        return this.cWD;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.swan.apps.u.c.e
    /* renamed from: bJ */
    public SelfT bK(long j) {
        if (this.cWD >= 1 || j <= 0) {
            return (SelfT) axR();
        }
        this.cWD = j;
        return (SelfT) super.bK(j);
    }
}
