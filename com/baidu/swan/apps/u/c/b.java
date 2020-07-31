package com.baidu.swan.apps.u.c;

import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.swan.apps.aq.aj;
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
    private long cog;

    /* loaded from: classes7.dex */
    public static final class a extends b<a> {
        @Override // com.baidu.swan.apps.u.c.b, com.baidu.swan.apps.u.c.a.c
        public /* synthetic */ com.baidu.swan.apps.u.c.a.c F(Bundle bundle) {
            return super.F(bundle);
        }

        @Override // com.baidu.swan.apps.u.c.b, com.baidu.swan.apps.u.c.e
        public /* synthetic */ e aY(long j) {
            return super.aY(j);
        }

        @Override // com.baidu.swan.apps.u.c.b, com.baidu.swan.apps.u.c.e
        public /* synthetic */ e fX(int i) {
            return super.fX(i);
        }

        @Override // com.baidu.swan.apps.u.c.b, com.baidu.swan.apps.u.c.e
        public /* synthetic */ e lA(String str) {
            return super.lA(str);
        }

        @Override // com.baidu.swan.apps.u.c.b, com.baidu.swan.apps.u.c.e
        public /* synthetic */ e lB(String str) {
            return super.lB(str);
        }

        @Override // com.baidu.swan.apps.u.c.b, com.baidu.swan.apps.u.c.e
        public /* synthetic */ e lC(String str) {
            return super.lC(str);
        }

        @Override // com.baidu.swan.apps.u.c.b, com.baidu.swan.apps.u.c.e
        public /* synthetic */ e lD(String str) {
            return super.lD(str);
        }

        @Override // com.baidu.swan.apps.u.c.b, com.baidu.swan.apps.u.c.e
        public /* synthetic */ e lE(String str) {
            return super.lE(str);
        }

        @Override // com.baidu.swan.apps.u.c.b, com.baidu.swan.apps.u.c.e
        public /* synthetic */ e lF(String str) {
            return super.lF(str);
        }

        @Override // com.baidu.swan.apps.u.c.b, com.baidu.swan.apps.u.c.e
        public /* synthetic */ e lG(String str) {
            return super.lG(str);
        }

        @Override // com.baidu.swan.apps.u.c.b, com.baidu.swan.apps.u.c.e
        public /* synthetic */ e lz(String str) {
            return super.lz(str);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.apps.aq.e.d
        /* renamed from: ajb */
        public a ajc() {
            return this;
        }
    }

    public static b r(Intent intent) {
        if (intent == null) {
            throw new IllegalArgumentException("intent must not be null.");
        }
        return new a().s(intent);
    }

    public SelfT s(Intent intent) {
        if (intent == null) {
            return (SelfT) ajc();
        }
        F(intent.getExtras());
        if (d.t(intent)) {
            lH("1250000000000000");
            k("box_cold_launch", -1L);
        }
        return (SelfT) ajc();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.swan.apps.u.c.a.c
    /* renamed from: E */
    public SelfT F(Bundle bundle) {
        if (bundle == null) {
            return (SelfT) ajc();
        }
        com.baidu.swan.apps.console.debugger.b.p(bundle);
        k.aoa().L(bundle);
        super.F(bundle);
        if (TextUtils.isEmpty(bundle.getString("mPage"))) {
            lQ("mPage");
        }
        return (SelfT) ajc();
    }

    @Override // com.baidu.swan.apps.u.c.a.c
    public Bundle toBundle() {
        Bundle bundle = super.toBundle();
        com.baidu.swan.apps.console.debugger.b.q(bundle);
        String appId = getAppId();
        if (!TextUtils.isEmpty(appId)) {
            bundle.putString("mAppId", appId);
        }
        return bundle;
    }

    public static b aiP() {
        a aVar = new a();
        aVar.lG("小程序测试");
        aVar.lE("wSfMyKIbrbNg7ogTFTcBuk1P8mgGTlB1");
        aVar.aZ(Color.parseColor("#FF308EF0"));
        aVar.lH("1230000000000000");
        aVar.lC("小程序简介");
        aVar.lB("测试服务类目");
        aVar.lA("测试主体信息");
        aVar.lF("CdKRXT4IrCwTD6LIBS7DIlL8rmbKx58N");
        aVar.lz("1.0");
        aVar.lD("https://gss3.bdstatic.com/9rkZsjib41gCpNKfpU_Y_D3/searchbox/aps/1516937209_WechatIMG147.jpeg");
        return aVar;
    }

    public static String a(b bVar, SwanAppConfigData swanAppConfigData) {
        return b(lq(bVar.getPage()), swanAppConfigData);
    }

    public static String a(String str, SwanAppConfigData swanAppConfigData) {
        if (TextUtils.isEmpty(str) || swanAppConfigData == null) {
            if (DEBUG) {
                Log.d("SwanAppLaunchInfo", "getPageInfo ret null - " + str);
            }
            return null;
        }
        Uri parse = Uri.parse(str);
        String j = aj.j(parse);
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
        String deleteQueryParam = aj.deleteQueryParam(parse.getEncodedQuery(), com.baidu.swan.apps.scheme.a.a.cLf);
        if (!TextUtils.isEmpty(deleteQueryParam)) {
            b = b + "?" + deleteQueryParam;
        }
        return b(lq(b), swanAppConfigData);
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

    public static String lq(String str) {
        if (!TextUtils.isEmpty(str) && str.startsWith(File.separator)) {
            return str.substring(1);
        }
        return str;
    }

    private static String b(String str, SwanAppConfigData swanAppConfigData) {
        if (TextUtils.isEmpty(str) || swanAppConfigData == null) {
            return null;
        }
        String delAllParamsFromUrl = aj.delAllParamsFromUrl(str);
        if (com.baidu.swan.apps.ad.b.a.nw(delAllParamsFromUrl)) {
            return aj.deleteQueryParam(str, com.baidu.swan.apps.scheme.a.a.cLf);
        }
        if (swanAppConfigData.oA(j.oZ(delAllParamsFromUrl))) {
            return str;
        }
        return null;
    }

    public JSONObject aiQ() {
        String aji = aji();
        if (aji != null) {
            String queryParameter = Uri.parse(aji).getQueryParameter("_swaninfo");
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

    public String aed() {
        return "SwanAppLaunchInfo{mAppId='" + getAppId() + "', mAppKey='" + getAppKey() + "', mAppTitle='" + aee() + "', pmsAppInfo is null='" + ajx() + "', launchFrom='" + ajg() + "', launchScheme='" + aji() + "', page='" + getPage() + "', mErrorCode=" + aiS() + ", mErrorDetail='" + aiT() + "', mErrorMsg='" + aiU() + "', mResumeDate='" + aiV() + "', maxSwanVersion='" + ajj() + "', minSwanVersion='" + ajk() + "', mVersion='" + getVersion() + "', mType=" + getType() + ", extraData=" + ajl() + ", isDebug=" + isDebug() + ", targetSwanVersion='" + ajr() + "', swanCoreVersion=" + adQ() + ", appFrameType=" + getAppFrameType() + ", consoleSwitch=" + ajs() + ", orientation=" + getOrientation() + ", versionCode='" + getVersionCode() + "', launchFlags=" + ajt() + ", swanAppStartTime=" + aja() + ", extStartTimestamp=" + aju() + ", remoteDebug='" + ajv() + "', extJSonObject=" + ajy() + ", launchId=" + ajz() + '}';
    }

    @Override // com.baidu.swan.apps.u.c.e
    public String aee() {
        PMSAppInfo ajw = ajw();
        return (ajw == null || TextUtils.isEmpty(ajw.appName)) ? super.aee() : ajw.appName;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.swan.apps.u.c.e
    /* renamed from: lr */
    public SelfT lG(String str) {
        PMSAppInfo ajw = ajw();
        if (ajw != null) {
            ajw.appName = str;
        }
        return (SelfT) super.lG(str);
    }

    @Override // com.baidu.swan.apps.u.c.e
    public String getAppKey() {
        PMSAppInfo ajw = ajw();
        return (ajw == null || TextUtils.isEmpty(ajw.appKey)) ? super.getAppKey() : ajw.appKey;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.swan.apps.u.c.e
    /* renamed from: ls */
    public SelfT lF(String str) {
        PMSAppInfo ajw = ajw();
        if (ajw != null) {
            ajw.appKey = str;
        }
        return (SelfT) super.lF(str);
    }

    @Override // com.baidu.swan.apps.u.c.e
    public String getAppId() {
        PMSAppInfo ajw = ajw();
        return (ajw == null || TextUtils.isEmpty(ajw.appId)) ? super.getAppId() : ajw.appId;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.swan.apps.u.c.e
    /* renamed from: lt */
    public SelfT lE(String str) {
        super.lE(str);
        PMSAppInfo ajw = ajw();
        if (ajw != null) {
            ajw.appId = str;
            return (SelfT) super.lE(str);
        }
        return (SelfT) ajc();
    }

    @Override // com.baidu.swan.apps.u.c.e
    public String getIconUrl() {
        PMSAppInfo ajw = ajw();
        return (ajw == null || TextUtils.isEmpty(ajw.iconUrl)) ? super.getIconUrl() : ajw.iconUrl;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.swan.apps.u.c.e
    /* renamed from: lu */
    public SelfT lD(String str) {
        super.lD(str);
        PMSAppInfo ajw = ajw();
        if (ajw != null) {
            ajw.iconUrl = str;
            return (SelfT) super.lD(str);
        }
        return (SelfT) ajc();
    }

    @Override // com.baidu.swan.apps.u.c.e
    public String aiR() {
        PMSAppInfo ajw = ajw();
        return ajw == null ? "" : ajw.description;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.swan.apps.u.c.e
    /* renamed from: lv */
    public SelfT lC(String str) {
        PMSAppInfo ajw = ajw();
        if (ajw != null) {
            ajw.description = str;
            return (SelfT) super.lC(str);
        }
        return (SelfT) ajc();
    }

    @Override // com.baidu.swan.apps.u.c.e
    public int aiS() {
        PMSAppInfo ajw = ajw();
        if (ajw == null) {
            return 0;
        }
        return ajw.appStatus;
    }

    @Override // com.baidu.swan.apps.u.c.e
    public String aiT() {
        PMSAppInfo ajw = ajw();
        return ajw == null ? "" : ajw.statusDetail;
    }

    @Override // com.baidu.swan.apps.u.c.e
    public String aiU() {
        PMSAppInfo ajw = ajw();
        return ajw == null ? "" : ajw.statusDesc;
    }

    @Override // com.baidu.swan.apps.u.c.e
    public String aiV() {
        PMSAppInfo ajw = ajw();
        return ajw == null ? "" : ajw.resumeDate;
    }

    @Override // com.baidu.swan.apps.u.c.e
    public String aiW() {
        PMSAppInfo ajw = ajw();
        return ajw == null ? "" : ajw.serviceCategory;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.swan.apps.u.c.e
    /* renamed from: lw */
    public SelfT lB(String str) {
        PMSAppInfo ajw = ajw();
        if (ajw != null) {
            ajw.serviceCategory = str;
            return (SelfT) super.lB(str);
        }
        return (SelfT) ajc();
    }

    @Override // com.baidu.swan.apps.u.c.e
    public String aiX() {
        PMSAppInfo ajw = ajw();
        return ajw == null ? "" : ajw.subjectInfo;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.swan.apps.u.c.e
    /* renamed from: lx */
    public SelfT lA(String str) {
        PMSAppInfo ajw = ajw();
        if (ajw != null) {
            ajw.subjectInfo = str;
            return (SelfT) super.lA(str);
        }
        return (SelfT) ajc();
    }

    @Override // com.baidu.swan.apps.u.c.e
    public SwanAppBearInfo aiY() {
        PMSAppInfo ajw = ajw();
        if (ajw == null) {
            return null;
        }
        String str = ajw.bearInfo;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return new SwanAppBearInfo(str);
    }

    @Override // com.baidu.swan.apps.u.c.e
    public String getVersion() {
        PMSAppInfo ajw = ajw();
        return ajw == null ? "" : String.valueOf(ajw.versionCode);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.swan.apps.u.c.e
    /* renamed from: ly */
    public SelfT lz(String str) {
        PMSAppInfo ajw = ajw();
        if (!TextUtils.isEmpty(str) && ajw != null) {
            try {
                ajw.versionCode = Integer.parseInt(str);
                return (SelfT) super.lz(str);
            } catch (NumberFormatException e) {
                if (DEBUG) {
                    e.printStackTrace();
                }
            }
        }
        return (SelfT) ajc();
    }

    @Override // com.baidu.swan.apps.u.c.e
    public String getVersionCode() {
        PMSAppInfo ajw = ajw();
        return ajw == null ? "" : ajw.versionName;
    }

    @Override // com.baidu.swan.apps.u.c.e
    public int getType() {
        PMSAppInfo ajw = ajw();
        if (ajw == null) {
            return 0;
        }
        return ajw.type;
    }

    @Override // com.baidu.swan.apps.u.c.e
    public long aiZ() {
        PMSAppInfo ajw = ajw();
        if (ajw == null) {
            return 0L;
        }
        return ajw.pkgSize;
    }

    @Override // com.baidu.swan.apps.u.c.e
    public int getOrientation() {
        PMSAppInfo ajw = ajw();
        int orientation = ajw == null ? -1 : ajw.getOrientation();
        return -1 < orientation ? orientation : super.getOrientation();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.swan.apps.u.c.e
    /* renamed from: fW */
    public SelfT fX(int i) {
        PMSAppInfo ajw = ajw();
        if (ajw != null) {
            ajw.setOrientation(i);
            return (SelfT) super.fX(i);
        }
        return (SelfT) ajc();
    }

    @Override // com.baidu.swan.apps.u.c.e
    public long aja() {
        return this.cog;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.swan.apps.u.c.e
    /* renamed from: aX */
    public SelfT aY(long j) {
        if (this.cog >= 1 || j <= 0) {
            return (SelfT) ajc();
        }
        this.cog = j;
        return (SelfT) super.aY(j);
    }
}
