package com.baidu.searchbox.util;

import android.util.Log;
import android.webkit.CookieManager;
import android.webkit.CookieSyncManager;
import com.baidu.android.common.others.url.UrlUtil;
import com.baidu.android.util.devices.DeviceUtil;
import com.baidu.pyramid.runtime.service.ServiceManager;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.config.AppConfig;
import com.baidu.searchbox.elasticthread.ExecutorUtilsExt;
import com.baidu.tieba.l10;
import com.baidu.ubc.UBCManager;
import java.util.HashMap;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class CuidCookieSync {
    public static final String BFE_COOKIE_KEY = "BAIDUCUID_BFESS";
    public static final String BFE_COOKIE_OPTION = "SameSite=None;Secure";
    public static final boolean DEBUG = LibBLCConfig.GLOBAL_DEBUG;
    public static final String TAG = "CuidCookie";

    private void setCUIDToSystemWebView(final String str, final String str2) {
        ExecutorUtilsExt.postOnElastic(new Runnable() { // from class: com.baidu.searchbox.util.CuidCookieSync.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    CookieManager.getInstance().setCookie(str, str2);
                    if (DeviceUtil.OSInfo.hasLollipop()) {
                        CookieManager.getInstance().flush();
                    } else {
                        CookieSyncManager.createInstance(AppRuntime.getAppContext());
                        CookieSyncManager.getInstance().sync();
                    }
                } catch (Exception e) {
                    if (CuidCookieSync.DEBUG) {
                        e.printStackTrace();
                    }
                    CuidCookieSync.this.errorUBC("setCUIDToSystemWebView MissingWebViewPackageException");
                }
            }
        }, "setCUIDToSystemWebView", 2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void errorUBC(String str) {
        try {
            HashMap hashMap = new HashMap();
            hashMap.put("from", "search");
            hashMap.put("page", "browser");
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("error", str);
            hashMap.put("ext", jSONObject.toString());
            ((UBCManager) ServiceManager.getService(UBCManager.SERVICE_REFERENCE)).onEvent("811", hashMap);
        } catch (Exception e) {
            if (DEBUG) {
                Log.e(TAG, "searchErrorUBC  error", e);
            }
        }
    }

    private String getBFECookie(String str) {
        return UrlUtil.getCookieStr(AppConfig.getCookieHost(), BFE_COOKIE_KEY, str, 31449600L) + BFE_COOKIE_OPTION;
    }

    public void setCUIDCookie() {
        IBaiduIdentityContext baiduIdentityContext = BaiduIdentityRuntime.getBaiduIdentityContext();
        if (!new CT().isDefaultCtv()) {
            String a = l10.a(BaiduIdentityManager.getInstance().getEnUid());
            String bFECookie = getBFECookie(a);
            baiduIdentityContext.setCookieManualNoBdussOperate("https://www.baidu.com", bFECookie, true);
            String cookieStr = UrlUtil.getCookieStr(AppConfig.getCookieHost(), "BAIDUCUID", a, 31449600L);
            baiduIdentityContext.setCookieManualNoBdussOperate("www.baidu.com", cookieStr, true);
            if (baiduIdentityContext.isBlinkEnable()) {
                setCUIDToSystemWebView("https://www.baidu.com", bFECookie);
                setCUIDToSystemWebView("www.baidu.com", cookieStr);
            }
        }
    }
}
