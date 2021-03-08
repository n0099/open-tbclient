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
/* loaded from: classes8.dex */
public abstract class b<SelfT extends b<SelfT>> extends e<SelfT> {
    private long dht;

    /* loaded from: classes8.dex */
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
        public /* synthetic */ e hQ(int i) {
            return super.hQ(i);
        }

        @Override // com.baidu.swan.apps.u.c.b, com.baidu.swan.apps.u.c.e
        public /* synthetic */ e oT(String str) {
            return super.oT(str);
        }

        @Override // com.baidu.swan.apps.u.c.b, com.baidu.swan.apps.u.c.e
        public /* synthetic */ e oU(String str) {
            return super.oU(str);
        }

        @Override // com.baidu.swan.apps.u.c.b, com.baidu.swan.apps.u.c.e
        public /* synthetic */ e oV(String str) {
            return super.oV(str);
        }

        @Override // com.baidu.swan.apps.u.c.b, com.baidu.swan.apps.u.c.e
        public /* synthetic */ e oW(String str) {
            return super.oW(str);
        }

        @Override // com.baidu.swan.apps.u.c.b, com.baidu.swan.apps.u.c.e
        public /* synthetic */ e oX(String str) {
            return super.oX(str);
        }

        @Override // com.baidu.swan.apps.u.c.b, com.baidu.swan.apps.u.c.e
        public /* synthetic */ e oY(String str) {
            return super.oY(str);
        }

        @Override // com.baidu.swan.apps.u.c.b, com.baidu.swan.apps.u.c.e
        public /* synthetic */ e oZ(String str) {
            return super.oZ(str);
        }

        @Override // com.baidu.swan.apps.u.c.b, com.baidu.swan.apps.u.c.e
        public /* synthetic */ e pa(String str) {
            return super.pa(str);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.apps.ao.e.d
        /* renamed from: ayY */
        public a ayZ() {
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
            return (SelfT) ayZ();
        }
        D(intent.getExtras());
        if (d.v(intent)) {
            pb("1250000000000000");
            o("box_cold_launch", -1L);
        }
        return (SelfT) ayZ();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.swan.apps.u.c.a.c
    /* renamed from: C */
    public SelfT D(Bundle bundle) {
        if (bundle == null) {
            return (SelfT) ayZ();
        }
        com.baidu.swan.apps.console.debugger.b.n(bundle);
        k.aEh().J(bundle);
        super.D(bundle);
        if (TextUtils.isEmpty(bundle.getString("mPage"))) {
            pk("mPage");
        }
        return (SelfT) ayZ();
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

    public static b ayL() {
        a aVar = new a();
        aVar.pa("小程序测试");
        aVar.oY("wSfMyKIbrbNg7ogTFTcBuk1P8mgGTlB1");
        aVar.cr(Color.parseColor("#FF308EF0"));
        aVar.pb("1230000000000000");
        aVar.oW("小程序简介");
        aVar.oV("测试服务类目");
        aVar.oU("测试主体信息");
        aVar.oZ("CdKRXT4IrCwTD6LIBS7DIlL8rmbKx58N");
        aVar.oT("1.0");
        aVar.oX("https://gss3.bdstatic.com/9rkZsjib41gCpNKfpU_Y_D3/searchbox/aps/1516937209_WechatIMG147.jpeg");
        return aVar;
    }

    public static String a(b bVar, SwanAppConfigData swanAppConfigData) {
        return b(oK(bVar.getPage()), swanAppConfigData);
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
        String deleteQueryParam = ai.deleteQueryParam(parse.getEncodedQuery(), com.baidu.swan.apps.scheme.a.a.dJB);
        if (!TextUtils.isEmpty(deleteQueryParam)) {
            a2 = a2 + "?" + deleteQueryParam;
        }
        return b(oK(a2), swanAppConfigData);
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

    public static String oK(String str) {
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
        if (com.baidu.swan.apps.ac.b.a.qP(delAllParamsFromUrl)) {
            return ai.deleteQueryParam(str, com.baidu.swan.apps.scheme.a.a.dJB);
        }
        if (swanAppConfigData.rY(j.sy(delAllParamsFromUrl))) {
            return str;
        }
        return null;
    }

    public JSONObject ayM() {
        String azf = azf();
        if (azf != null) {
            String queryParameter = Uri.parse(azf).getQueryParameter("_swaninfo");
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

    public String ate() {
        return "SwanAppLaunchInfo{mAppId='" + getAppId() + "', mAppKey='" + getAppKey() + "', mAppTitle='" + atf() + "', pmsAppInfo is null='" + azu() + "', launchFrom='" + azd() + "', launchScheme='" + azf() + "', page='" + getPage() + "', mErrorCode=" + ayO() + ", mErrorDetail='" + ayP() + "', mErrorMsg='" + ayQ() + "', mResumeDate='" + ayR() + "', maxSwanVersion='" + azg() + "', minSwanVersion='" + azh() + "', mVersion='" + getVersion() + "', mType=" + getType() + ", extraData=" + azi() + ", isDebug=" + isDebug() + ", targetSwanVersion='" + azo() + "', swanCoreVersion=" + asD() + ", appFrameType=" + getAppFrameType() + ", consoleSwitch=" + azp() + ", orientation=" + getOrientation() + ", versionCode='" + getVersionCode() + "', launchFlags=" + azq() + ", swanAppStartTime=" + ayX() + ", extStartTimestamp=" + azr() + ", remoteDebug='" + azs() + "', extJSonObject=" + azv() + ", launchId=" + azw() + '}';
    }

    @Override // com.baidu.swan.apps.u.c.e
    public String atf() {
        PMSAppInfo azt = azt();
        return (azt == null || TextUtils.isEmpty(azt.appName)) ? super.atf() : azt.appName;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.swan.apps.u.c.e
    /* renamed from: oL */
    public SelfT pa(String str) {
        PMSAppInfo azt = azt();
        if (azt != null) {
            azt.appName = str;
        }
        return (SelfT) super.pa(str);
    }

    @Override // com.baidu.swan.apps.u.c.e
    public String getAppKey() {
        PMSAppInfo azt = azt();
        return (azt == null || TextUtils.isEmpty(azt.appKey)) ? super.getAppKey() : azt.appKey;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.swan.apps.u.c.e
    /* renamed from: oM */
    public SelfT oZ(String str) {
        PMSAppInfo azt = azt();
        if (azt != null) {
            azt.appKey = str;
        }
        return (SelfT) super.oZ(str);
    }

    @Override // com.baidu.swan.apps.u.c.e
    public String getAppId() {
        PMSAppInfo azt = azt();
        return (azt == null || TextUtils.isEmpty(azt.appId)) ? super.getAppId() : azt.appId;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.swan.apps.u.c.e
    /* renamed from: oN */
    public SelfT oY(String str) {
        super.oY(str);
        PMSAppInfo azt = azt();
        if (azt != null) {
            azt.appId = str;
            return (SelfT) super.oY(str);
        }
        return (SelfT) ayZ();
    }

    @Override // com.baidu.swan.apps.u.c.e
    public String getIconUrl() {
        PMSAppInfo azt = azt();
        return (azt == null || TextUtils.isEmpty(azt.iconUrl)) ? super.getIconUrl() : azt.iconUrl;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.swan.apps.u.c.e
    /* renamed from: oO */
    public SelfT oX(String str) {
        super.oX(str);
        PMSAppInfo azt = azt();
        if (azt != null) {
            azt.iconUrl = str;
            return (SelfT) super.oX(str);
        }
        return (SelfT) ayZ();
    }

    @Override // com.baidu.swan.apps.u.c.e
    public String ayN() {
        PMSAppInfo azt = azt();
        return azt == null ? "" : azt.description;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.swan.apps.u.c.e
    /* renamed from: oP */
    public SelfT oW(String str) {
        PMSAppInfo azt = azt();
        if (azt != null) {
            azt.description = str;
            return (SelfT) super.oW(str);
        }
        return (SelfT) ayZ();
    }

    @Override // com.baidu.swan.apps.u.c.e
    public int ayO() {
        PMSAppInfo azt = azt();
        if (azt == null) {
            return 0;
        }
        return azt.appStatus;
    }

    @Override // com.baidu.swan.apps.u.c.e
    public String ayP() {
        PMSAppInfo azt = azt();
        return azt == null ? "" : azt.statusDetail;
    }

    @Override // com.baidu.swan.apps.u.c.e
    public String ayQ() {
        PMSAppInfo azt = azt();
        return azt == null ? "" : azt.statusDesc;
    }

    @Override // com.baidu.swan.apps.u.c.e
    public String ayR() {
        PMSAppInfo azt = azt();
        return azt == null ? "" : azt.resumeDate;
    }

    @Override // com.baidu.swan.apps.u.c.e
    public String ayS() {
        PMSAppInfo azt = azt();
        return azt == null ? "" : azt.serviceCategory;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.swan.apps.u.c.e
    /* renamed from: oQ */
    public SelfT oV(String str) {
        PMSAppInfo azt = azt();
        if (azt != null) {
            azt.serviceCategory = str;
            return (SelfT) super.oV(str);
        }
        return (SelfT) ayZ();
    }

    @Override // com.baidu.swan.apps.u.c.e
    public String ayT() {
        PMSAppInfo azt = azt();
        return azt == null ? "" : azt.subjectInfo;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.swan.apps.u.c.e
    /* renamed from: oR */
    public SelfT oU(String str) {
        PMSAppInfo azt = azt();
        if (azt != null) {
            azt.subjectInfo = str;
            return (SelfT) super.oU(str);
        }
        return (SelfT) ayZ();
    }

    @Override // com.baidu.swan.apps.u.c.e
    public SwanAppBearInfo ayU() {
        PMSAppInfo azt = azt();
        if (azt == null) {
            return null;
        }
        String str = azt.bearInfo;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return new SwanAppBearInfo(str);
    }

    @Override // com.baidu.swan.apps.u.c.e
    public String ayV() {
        PMSAppInfo azt = azt();
        if (azt == null) {
            return null;
        }
        return azt.quickAppKey;
    }

    @Override // com.baidu.swan.apps.u.c.e
    public String getVersion() {
        PMSAppInfo azt = azt();
        return azt == null ? "" : String.valueOf(azt.versionCode);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.swan.apps.u.c.e
    /* renamed from: oS */
    public SelfT oT(String str) {
        PMSAppInfo azt = azt();
        if (!TextUtils.isEmpty(str) && azt != null) {
            try {
                azt.versionCode = Integer.parseInt(str);
                return (SelfT) super.oT(str);
            } catch (NumberFormatException e) {
                if (DEBUG) {
                    e.printStackTrace();
                }
            }
        }
        return (SelfT) ayZ();
    }

    @Override // com.baidu.swan.apps.u.c.e
    public String getVersionCode() {
        PMSAppInfo azt = azt();
        return azt == null ? "" : azt.versionName;
    }

    @Override // com.baidu.swan.apps.u.c.e
    public int getType() {
        PMSAppInfo azt = azt();
        if (azt == null) {
            return 0;
        }
        return azt.type;
    }

    @Override // com.baidu.swan.apps.u.c.e
    public long ayW() {
        PMSAppInfo azt = azt();
        if (azt == null) {
            return 0L;
        }
        return azt.pkgSize;
    }

    @Override // com.baidu.swan.apps.u.c.e
    public int getOrientation() {
        PMSAppInfo azt = azt();
        int orientation = azt == null ? -1 : azt.getOrientation();
        return -1 < orientation ? orientation : super.getOrientation();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.swan.apps.u.c.e
    /* renamed from: hP */
    public SelfT hQ(int i) {
        PMSAppInfo azt = azt();
        if (azt != null) {
            azt.setOrientation(i);
            return (SelfT) super.hQ(i);
        }
        return (SelfT) ayZ();
    }

    @Override // com.baidu.swan.apps.u.c.e
    public long ayX() {
        return this.dht;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.swan.apps.u.c.e
    /* renamed from: cp */
    public SelfT cq(long j) {
        if (this.dht >= 1 || j <= 0) {
            return (SelfT) ayZ();
        }
        this.dht = j;
        return (SelfT) super.cq(j);
    }
}
