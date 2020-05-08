package com.baidu.sapi2.utils;

import android.text.TextUtils;
import com.baidu.sapi2.SapiContext;
import com.baidu.sapi2.ServiceManager;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLDecoder;
/* loaded from: classes6.dex */
public class QrLoginUtils {
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
        try {
            URL url = new URL(str);
            return ServiceManager.getInstance().getIsAccountManager().getConfignation().getEnvironment().getURL(true).equals(new StringBuilder().append(url.getProtocol()).append("://").append(url.getHost()).toString()) && !TextUtils.isEmpty(str) && str.contains("sign") && str.contains("/v2/api/qrcode") && str.contains("appName");
        } catch (MalformedURLException e) {
            return false;
        }
    }
}
