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
    private long cYn;

    /* loaded from: classes10.dex */
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
        public /* synthetic */ e jd(int i) {
            return super.jd(i);
        }

        @Override // com.baidu.swan.apps.u.c.b, com.baidu.swan.apps.u.c.e
        public /* synthetic */ e pl(String str) {
            return super.pl(str);
        }

        @Override // com.baidu.swan.apps.u.c.b, com.baidu.swan.apps.u.c.e
        public /* synthetic */ e pm(String str) {
            return super.pm(str);
        }

        @Override // com.baidu.swan.apps.u.c.b, com.baidu.swan.apps.u.c.e
        public /* synthetic */ e pn(String str) {
            return super.pn(str);
        }

        @Override // com.baidu.swan.apps.u.c.b, com.baidu.swan.apps.u.c.e
        public /* synthetic */ e po(String str) {
            return super.po(str);
        }

        @Override // com.baidu.swan.apps.u.c.b, com.baidu.swan.apps.u.c.e
        public /* synthetic */ e pp(String str) {
            return super.pp(str);
        }

        @Override // com.baidu.swan.apps.u.c.b, com.baidu.swan.apps.u.c.e
        public /* synthetic */ e pq(String str) {
            return super.pq(str);
        }

        @Override // com.baidu.swan.apps.u.c.b, com.baidu.swan.apps.u.c.e
        public /* synthetic */ e pr(String str) {
            return super.pr(str);
        }

        @Override // com.baidu.swan.apps.u.c.b, com.baidu.swan.apps.u.c.e
        public /* synthetic */ e ps(String str) {
            return super.ps(str);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.apps.ap.e.d
        /* renamed from: ayy */
        public a ayz() {
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
            return (SelfT) ayz();
        }
        D(intent.getExtras());
        if (d.v(intent)) {
            pt("1250000000000000");
            p("box_cold_launch", -1L);
        }
        return (SelfT) ayz();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.swan.apps.u.c.a.c
    /* renamed from: C */
    public SelfT D(Bundle bundle) {
        if (bundle == null) {
            return (SelfT) ayz();
        }
        com.baidu.swan.apps.console.debugger.b.n(bundle);
        k.aDJ().J(bundle);
        super.D(bundle);
        if (TextUtils.isEmpty(bundle.getString("mPage"))) {
            pC("mPage");
        }
        return (SelfT) ayz();
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

    public static b ayl() {
        a aVar = new a();
        aVar.ps("小程序测试");
        aVar.pq("wSfMyKIbrbNg7ogTFTcBuk1P8mgGTlB1");
        aVar.bL(Color.parseColor("#FF308EF0"));
        aVar.pt("1230000000000000");
        aVar.po("小程序简介");
        aVar.pn("测试服务类目");
        aVar.pm("测试主体信息");
        aVar.pr("CdKRXT4IrCwTD6LIBS7DIlL8rmbKx58N");
        aVar.pl("1.0");
        aVar.pp("https://gss3.bdstatic.com/9rkZsjib41gCpNKfpU_Y_D3/searchbox/aps/1516937209_WechatIMG147.jpeg");
        return aVar;
    }

    public static String a(b bVar, SwanAppConfigData swanAppConfigData) {
        return b(pc(bVar.getPage()), swanAppConfigData);
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
        String deleteQueryParam = ai.deleteQueryParam(parse.getEncodedQuery(), com.baidu.swan.apps.scheme.a.a.dwL);
        if (!TextUtils.isEmpty(deleteQueryParam)) {
            b = b + "?" + deleteQueryParam;
        }
        return b(pc(b), swanAppConfigData);
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

    public static String pc(String str) {
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
        if (com.baidu.swan.apps.ac.b.a.rh(delAllParamsFromUrl)) {
            return ai.deleteQueryParam(str, com.baidu.swan.apps.scheme.a.a.dwL);
        }
        if (swanAppConfigData.sk(j.sK(delAllParamsFromUrl))) {
            return str;
        }
        return null;
    }

    public JSONObject aym() {
        String ayF = ayF();
        if (ayF != null) {
            String queryParameter = Uri.parse(ayF).getQueryParameter("_swaninfo");
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

    public String asE() {
        return "SwanAppLaunchInfo{mAppId='" + getAppId() + "', mAppKey='" + getAppKey() + "', mAppTitle='" + asF() + "', pmsAppInfo is null='" + ayU() + "', launchFrom='" + ayD() + "', launchScheme='" + ayF() + "', page='" + getPage() + "', mErrorCode=" + ayo() + ", mErrorDetail='" + ayp() + "', mErrorMsg='" + ayq() + "', mResumeDate='" + ayr() + "', maxSwanVersion='" + ayG() + "', minSwanVersion='" + ayH() + "', mVersion='" + getVersion() + "', mType=" + getType() + ", extraData=" + ayI() + ", isDebug=" + isDebug() + ", targetSwanVersion='" + ayO() + "', swanCoreVersion=" + asd() + ", appFrameType=" + getAppFrameType() + ", consoleSwitch=" + ayP() + ", orientation=" + getOrientation() + ", versionCode='" + getVersionCode() + "', launchFlags=" + ayQ() + ", swanAppStartTime=" + ayx() + ", extStartTimestamp=" + ayR() + ", remoteDebug='" + ayS() + "', extJSonObject=" + ayV() + ", launchId=" + ayW() + '}';
    }

    @Override // com.baidu.swan.apps.u.c.e
    public String asF() {
        PMSAppInfo ayT = ayT();
        return (ayT == null || TextUtils.isEmpty(ayT.appName)) ? super.asF() : ayT.appName;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.swan.apps.u.c.e
    /* renamed from: pd */
    public SelfT ps(String str) {
        PMSAppInfo ayT = ayT();
        if (ayT != null) {
            ayT.appName = str;
        }
        return (SelfT) super.ps(str);
    }

    @Override // com.baidu.swan.apps.u.c.e
    public String getAppKey() {
        PMSAppInfo ayT = ayT();
        return (ayT == null || TextUtils.isEmpty(ayT.appKey)) ? super.getAppKey() : ayT.appKey;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.swan.apps.u.c.e
    /* renamed from: pe */
    public SelfT pr(String str) {
        PMSAppInfo ayT = ayT();
        if (ayT != null) {
            ayT.appKey = str;
        }
        return (SelfT) super.pr(str);
    }

    @Override // com.baidu.swan.apps.u.c.e
    public String getAppId() {
        PMSAppInfo ayT = ayT();
        return (ayT == null || TextUtils.isEmpty(ayT.appId)) ? super.getAppId() : ayT.appId;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.swan.apps.u.c.e
    /* renamed from: pf */
    public SelfT pq(String str) {
        super.pq(str);
        PMSAppInfo ayT = ayT();
        if (ayT != null) {
            ayT.appId = str;
            return (SelfT) super.pq(str);
        }
        return (SelfT) ayz();
    }

    @Override // com.baidu.swan.apps.u.c.e
    public String getIconUrl() {
        PMSAppInfo ayT = ayT();
        return (ayT == null || TextUtils.isEmpty(ayT.iconUrl)) ? super.getIconUrl() : ayT.iconUrl;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.swan.apps.u.c.e
    /* renamed from: pg */
    public SelfT pp(String str) {
        super.pp(str);
        PMSAppInfo ayT = ayT();
        if (ayT != null) {
            ayT.iconUrl = str;
            return (SelfT) super.pp(str);
        }
        return (SelfT) ayz();
    }

    @Override // com.baidu.swan.apps.u.c.e
    public String ayn() {
        PMSAppInfo ayT = ayT();
        return ayT == null ? "" : ayT.description;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.swan.apps.u.c.e
    /* renamed from: ph */
    public SelfT po(String str) {
        PMSAppInfo ayT = ayT();
        if (ayT != null) {
            ayT.description = str;
            return (SelfT) super.po(str);
        }
        return (SelfT) ayz();
    }

    @Override // com.baidu.swan.apps.u.c.e
    public int ayo() {
        PMSAppInfo ayT = ayT();
        if (ayT == null) {
            return 0;
        }
        return ayT.appStatus;
    }

    @Override // com.baidu.swan.apps.u.c.e
    public String ayp() {
        PMSAppInfo ayT = ayT();
        return ayT == null ? "" : ayT.statusDetail;
    }

    @Override // com.baidu.swan.apps.u.c.e
    public String ayq() {
        PMSAppInfo ayT = ayT();
        return ayT == null ? "" : ayT.statusDesc;
    }

    @Override // com.baidu.swan.apps.u.c.e
    public String ayr() {
        PMSAppInfo ayT = ayT();
        return ayT == null ? "" : ayT.resumeDate;
    }

    @Override // com.baidu.swan.apps.u.c.e
    public String ays() {
        PMSAppInfo ayT = ayT();
        return ayT == null ? "" : ayT.serviceCategory;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.swan.apps.u.c.e
    /* renamed from: pi */
    public SelfT pn(String str) {
        PMSAppInfo ayT = ayT();
        if (ayT != null) {
            ayT.serviceCategory = str;
            return (SelfT) super.pn(str);
        }
        return (SelfT) ayz();
    }

    @Override // com.baidu.swan.apps.u.c.e
    public String ayt() {
        PMSAppInfo ayT = ayT();
        return ayT == null ? "" : ayT.subjectInfo;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.swan.apps.u.c.e
    /* renamed from: pj */
    public SelfT pm(String str) {
        PMSAppInfo ayT = ayT();
        if (ayT != null) {
            ayT.subjectInfo = str;
            return (SelfT) super.pm(str);
        }
        return (SelfT) ayz();
    }

    @Override // com.baidu.swan.apps.u.c.e
    public SwanAppBearInfo ayu() {
        PMSAppInfo ayT = ayT();
        if (ayT == null) {
            return null;
        }
        String str = ayT.bearInfo;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return new SwanAppBearInfo(str);
    }

    @Override // com.baidu.swan.apps.u.c.e
    public String ayv() {
        PMSAppInfo ayT = ayT();
        if (ayT == null) {
            return null;
        }
        return ayT.quickAppKey;
    }

    @Override // com.baidu.swan.apps.u.c.e
    public String getVersion() {
        PMSAppInfo ayT = ayT();
        return ayT == null ? "" : String.valueOf(ayT.versionCode);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.swan.apps.u.c.e
    /* renamed from: pk */
    public SelfT pl(String str) {
        PMSAppInfo ayT = ayT();
        if (!TextUtils.isEmpty(str) && ayT != null) {
            try {
                ayT.versionCode = Integer.parseInt(str);
                return (SelfT) super.pl(str);
            } catch (NumberFormatException e) {
                if (DEBUG) {
                    e.printStackTrace();
                }
            }
        }
        return (SelfT) ayz();
    }

    @Override // com.baidu.swan.apps.u.c.e
    public String getVersionCode() {
        PMSAppInfo ayT = ayT();
        return ayT == null ? "" : ayT.versionName;
    }

    @Override // com.baidu.swan.apps.u.c.e
    public int getType() {
        PMSAppInfo ayT = ayT();
        if (ayT == null) {
            return 0;
        }
        return ayT.type;
    }

    @Override // com.baidu.swan.apps.u.c.e
    public long ayw() {
        PMSAppInfo ayT = ayT();
        if (ayT == null) {
            return 0L;
        }
        return ayT.pkgSize;
    }

    @Override // com.baidu.swan.apps.u.c.e
    public int getOrientation() {
        PMSAppInfo ayT = ayT();
        int orientation = ayT == null ? -1 : ayT.getOrientation();
        return -1 < orientation ? orientation : super.getOrientation();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.swan.apps.u.c.e
    /* renamed from: jc */
    public SelfT jd(int i) {
        PMSAppInfo ayT = ayT();
        if (ayT != null) {
            ayT.setOrientation(i);
            return (SelfT) super.jd(i);
        }
        return (SelfT) ayz();
    }

    @Override // com.baidu.swan.apps.u.c.e
    public long ayx() {
        return this.cYn;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.swan.apps.u.c.e
    /* renamed from: bJ */
    public SelfT bK(long j) {
        if (this.cYn >= 1 || j <= 0) {
            return (SelfT) ayz();
        }
        this.cYn = j;
        return (SelfT) super.bK(j);
    }
}
