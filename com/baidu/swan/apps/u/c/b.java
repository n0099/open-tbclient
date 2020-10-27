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
    private long cSu;

    /* loaded from: classes10.dex */
    public static final class a extends b<a> {
        @Override // com.baidu.swan.apps.u.c.b, com.baidu.swan.apps.u.c.a.c
        public /* synthetic */ com.baidu.swan.apps.u.c.a.c D(Bundle bundle) {
            return super.D(bundle);
        }

        @Override // com.baidu.swan.apps.u.c.b, com.baidu.swan.apps.u.c.e
        public /* synthetic */ e bo(long j) {
            return super.bo(j);
        }

        @Override // com.baidu.swan.apps.u.c.b, com.baidu.swan.apps.u.c.e
        public /* synthetic */ e iT(int i) {
            return super.iT(i);
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

        @Override // com.baidu.swan.apps.u.c.b, com.baidu.swan.apps.u.c.e
        public /* synthetic */ e pb(String str) {
            return super.pb(str);
        }

        @Override // com.baidu.swan.apps.u.c.b, com.baidu.swan.apps.u.c.e
        public /* synthetic */ e pc(String str) {
            return super.pc(str);
        }

        @Override // com.baidu.swan.apps.u.c.b, com.baidu.swan.apps.u.c.e
        public /* synthetic */ e pd(String str) {
            return super.pd(str);
        }

        @Override // com.baidu.swan.apps.u.c.b, com.baidu.swan.apps.u.c.e
        public /* synthetic */ e pe(String str) {
            return super.pe(str);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.apps.ap.e.d
        /* renamed from: avY */
        public a avZ() {
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
            return (SelfT) avZ();
        }
        D(intent.getExtras());
        if (d.v(intent)) {
            pf("1250000000000000");
            p("box_cold_launch", -1L);
        }
        return (SelfT) avZ();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.swan.apps.u.c.a.c
    /* renamed from: C */
    public SelfT D(Bundle bundle) {
        if (bundle == null) {
            return (SelfT) avZ();
        }
        com.baidu.swan.apps.console.debugger.b.n(bundle);
        k.aBj().J(bundle);
        super.D(bundle);
        if (TextUtils.isEmpty(bundle.getString("mPage"))) {
            po("mPage");
        }
        return (SelfT) avZ();
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

    public static b avL() {
        a aVar = new a();
        aVar.pe("小程序测试");
        aVar.pc("wSfMyKIbrbNg7ogTFTcBuk1P8mgGTlB1");
        aVar.bp(Color.parseColor("#FF308EF0"));
        aVar.pf("1230000000000000");
        aVar.pa("小程序简介");
        aVar.oZ("测试服务类目");
        aVar.oY("测试主体信息");
        aVar.pd("CdKRXT4IrCwTD6LIBS7DIlL8rmbKx58N");
        aVar.oX("1.0");
        aVar.pb("https://gss3.bdstatic.com/9rkZsjib41gCpNKfpU_Y_D3/searchbox/aps/1516937209_WechatIMG147.jpeg");
        return aVar;
    }

    public static String a(b bVar, SwanAppConfigData swanAppConfigData) {
        return b(oO(bVar.getPage()), swanAppConfigData);
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
        String deleteQueryParam = ai.deleteQueryParam(parse.getEncodedQuery(), com.baidu.swan.apps.scheme.a.a.dqQ);
        if (!TextUtils.isEmpty(deleteQueryParam)) {
            b = b + "?" + deleteQueryParam;
        }
        return b(oO(b), swanAppConfigData);
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

    public static String oO(String str) {
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
        if (com.baidu.swan.apps.ac.b.a.qT(delAllParamsFromUrl)) {
            return ai.deleteQueryParam(str, com.baidu.swan.apps.scheme.a.a.dqQ);
        }
        if (swanAppConfigData.rW(j.sw(delAllParamsFromUrl))) {
            return str;
        }
        return null;
    }

    public JSONObject avM() {
        String awf = awf();
        if (awf != null) {
            String queryParameter = Uri.parse(awf).getQueryParameter("_swaninfo");
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

    public String aqd() {
        return "SwanAppLaunchInfo{mAppId='" + getAppId() + "', mAppKey='" + getAppKey() + "', mAppTitle='" + aqe() + "', pmsAppInfo is null='" + awu() + "', launchFrom='" + awd() + "', launchScheme='" + awf() + "', page='" + getPage() + "', mErrorCode=" + avO() + ", mErrorDetail='" + avP() + "', mErrorMsg='" + avQ() + "', mResumeDate='" + avR() + "', maxSwanVersion='" + awg() + "', minSwanVersion='" + awh() + "', mVersion='" + getVersion() + "', mType=" + getType() + ", extraData=" + awi() + ", isDebug=" + isDebug() + ", targetSwanVersion='" + awo() + "', swanCoreVersion=" + apD() + ", appFrameType=" + getAppFrameType() + ", consoleSwitch=" + awp() + ", orientation=" + getOrientation() + ", versionCode='" + getVersionCode() + "', launchFlags=" + awq() + ", swanAppStartTime=" + avX() + ", extStartTimestamp=" + awr() + ", remoteDebug='" + aws() + "', extJSonObject=" + awv() + ", launchId=" + aww() + '}';
    }

    @Override // com.baidu.swan.apps.u.c.e
    public String aqe() {
        PMSAppInfo awt = awt();
        return (awt == null || TextUtils.isEmpty(awt.appName)) ? super.aqe() : awt.appName;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.swan.apps.u.c.e
    /* renamed from: oP */
    public SelfT pe(String str) {
        PMSAppInfo awt = awt();
        if (awt != null) {
            awt.appName = str;
        }
        return (SelfT) super.pe(str);
    }

    @Override // com.baidu.swan.apps.u.c.e
    public String getAppKey() {
        PMSAppInfo awt = awt();
        return (awt == null || TextUtils.isEmpty(awt.appKey)) ? super.getAppKey() : awt.appKey;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.swan.apps.u.c.e
    /* renamed from: oQ */
    public SelfT pd(String str) {
        PMSAppInfo awt = awt();
        if (awt != null) {
            awt.appKey = str;
        }
        return (SelfT) super.pd(str);
    }

    @Override // com.baidu.swan.apps.u.c.e
    public String getAppId() {
        PMSAppInfo awt = awt();
        return (awt == null || TextUtils.isEmpty(awt.appId)) ? super.getAppId() : awt.appId;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.swan.apps.u.c.e
    /* renamed from: oR */
    public SelfT pc(String str) {
        super.pc(str);
        PMSAppInfo awt = awt();
        if (awt != null) {
            awt.appId = str;
            return (SelfT) super.pc(str);
        }
        return (SelfT) avZ();
    }

    @Override // com.baidu.swan.apps.u.c.e
    public String getIconUrl() {
        PMSAppInfo awt = awt();
        return (awt == null || TextUtils.isEmpty(awt.iconUrl)) ? super.getIconUrl() : awt.iconUrl;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.swan.apps.u.c.e
    /* renamed from: oS */
    public SelfT pb(String str) {
        super.pb(str);
        PMSAppInfo awt = awt();
        if (awt != null) {
            awt.iconUrl = str;
            return (SelfT) super.pb(str);
        }
        return (SelfT) avZ();
    }

    @Override // com.baidu.swan.apps.u.c.e
    public String avN() {
        PMSAppInfo awt = awt();
        return awt == null ? "" : awt.description;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.swan.apps.u.c.e
    /* renamed from: oT */
    public SelfT pa(String str) {
        PMSAppInfo awt = awt();
        if (awt != null) {
            awt.description = str;
            return (SelfT) super.pa(str);
        }
        return (SelfT) avZ();
    }

    @Override // com.baidu.swan.apps.u.c.e
    public int avO() {
        PMSAppInfo awt = awt();
        if (awt == null) {
            return 0;
        }
        return awt.appStatus;
    }

    @Override // com.baidu.swan.apps.u.c.e
    public String avP() {
        PMSAppInfo awt = awt();
        return awt == null ? "" : awt.statusDetail;
    }

    @Override // com.baidu.swan.apps.u.c.e
    public String avQ() {
        PMSAppInfo awt = awt();
        return awt == null ? "" : awt.statusDesc;
    }

    @Override // com.baidu.swan.apps.u.c.e
    public String avR() {
        PMSAppInfo awt = awt();
        return awt == null ? "" : awt.resumeDate;
    }

    @Override // com.baidu.swan.apps.u.c.e
    public String avS() {
        PMSAppInfo awt = awt();
        return awt == null ? "" : awt.serviceCategory;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.swan.apps.u.c.e
    /* renamed from: oU */
    public SelfT oZ(String str) {
        PMSAppInfo awt = awt();
        if (awt != null) {
            awt.serviceCategory = str;
            return (SelfT) super.oZ(str);
        }
        return (SelfT) avZ();
    }

    @Override // com.baidu.swan.apps.u.c.e
    public String avT() {
        PMSAppInfo awt = awt();
        return awt == null ? "" : awt.subjectInfo;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.swan.apps.u.c.e
    /* renamed from: oV */
    public SelfT oY(String str) {
        PMSAppInfo awt = awt();
        if (awt != null) {
            awt.subjectInfo = str;
            return (SelfT) super.oY(str);
        }
        return (SelfT) avZ();
    }

    @Override // com.baidu.swan.apps.u.c.e
    public SwanAppBearInfo avU() {
        PMSAppInfo awt = awt();
        if (awt == null) {
            return null;
        }
        String str = awt.bearInfo;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return new SwanAppBearInfo(str);
    }

    @Override // com.baidu.swan.apps.u.c.e
    public String avV() {
        PMSAppInfo awt = awt();
        if (awt == null) {
            return null;
        }
        return awt.quickAppKey;
    }

    @Override // com.baidu.swan.apps.u.c.e
    public String getVersion() {
        PMSAppInfo awt = awt();
        return awt == null ? "" : String.valueOf(awt.versionCode);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.swan.apps.u.c.e
    /* renamed from: oW */
    public SelfT oX(String str) {
        PMSAppInfo awt = awt();
        if (!TextUtils.isEmpty(str) && awt != null) {
            try {
                awt.versionCode = Integer.parseInt(str);
                return (SelfT) super.oX(str);
            } catch (NumberFormatException e) {
                if (DEBUG) {
                    e.printStackTrace();
                }
            }
        }
        return (SelfT) avZ();
    }

    @Override // com.baidu.swan.apps.u.c.e
    public String getVersionCode() {
        PMSAppInfo awt = awt();
        return awt == null ? "" : awt.versionName;
    }

    @Override // com.baidu.swan.apps.u.c.e
    public int getType() {
        PMSAppInfo awt = awt();
        if (awt == null) {
            return 0;
        }
        return awt.type;
    }

    @Override // com.baidu.swan.apps.u.c.e
    public long avW() {
        PMSAppInfo awt = awt();
        if (awt == null) {
            return 0L;
        }
        return awt.pkgSize;
    }

    @Override // com.baidu.swan.apps.u.c.e
    public int getOrientation() {
        PMSAppInfo awt = awt();
        int orientation = awt == null ? -1 : awt.getOrientation();
        return -1 < orientation ? orientation : super.getOrientation();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.swan.apps.u.c.e
    /* renamed from: iS */
    public SelfT iT(int i) {
        PMSAppInfo awt = awt();
        if (awt != null) {
            awt.setOrientation(i);
            return (SelfT) super.iT(i);
        }
        return (SelfT) avZ();
    }

    @Override // com.baidu.swan.apps.u.c.e
    public long avX() {
        return this.cSu;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.swan.apps.u.c.e
    /* renamed from: bn */
    public SelfT bo(long j) {
        if (this.cSu >= 1 || j <= 0) {
            return (SelfT) avZ();
        }
        this.cSu = j;
        return (SelfT) super.bo(j);
    }
}
