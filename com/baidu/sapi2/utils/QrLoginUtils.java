package com.baidu.sapi2.utils;

import android.text.TextUtils;
import com.baidu.sapi2.NoProguard;
import com.baidu.sapi2.SapiContext;
import com.baidu.sapi2.ServiceManager;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLDecoder;
/* loaded from: classes2.dex */
public class QrLoginUtils implements NoProguard {
    public static String getJoinQrLoginPromptInfo(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (SapiContext.getInstance().getCurrentAccount() == null) {
            return "-1";
        }
        return String.format(SapiContext.getInstance().getJoinQrLoginPrompt(), URLDecoder.decode(SapiUtils.urlParamsToMap(str).get("appName")));
    }

    public static boolean isJoinQrLoginSchema(String str) {
        String url;
        StringBuilder sb;
        try {
            URL url2 = new URL(str);
            url = ServiceManager.getInstance().getIsAccountManager().getConfignation().getEnvironment().getURL(true);
            sb = new StringBuilder();
            sb.append(url2.getProtocol());
            sb.append("://");
            sb.append(url2.getHost());
        } catch (MalformedURLException unused) {
        }
        return url.equals(sb.toString()) && !TextUtils.isEmpty(str) && str.contains("sign") && str.contains("/v2/api/qrcode") && str.contains("appName");
    }
}
