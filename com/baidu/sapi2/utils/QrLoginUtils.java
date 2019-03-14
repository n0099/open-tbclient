package com.baidu.sapi2.utils;

import android.text.TextUtils;
import com.baidu.pass.biometrics.face.liveness.stat.LivenessStat;
import com.baidu.sapi2.ServiceManager;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLDecoder;
/* loaded from: classes3.dex */
public class QrLoginUtils {
    public static boolean isJoinQrLoginSchema(String str) {
        try {
            URL url = new URL(str);
            return ServiceManager.getInstance().getIsAccountManager().getConfignation().getEnvironment().getURL(true).equals(new StringBuilder().append(url.getProtocol()).append("://").append(url.getHost()).toString()) && !TextUtils.isEmpty(str) && str.contains("sign") && str.contains("/v2/api/qrcode") && str.contains("prompt");
        } catch (MalformedURLException e) {
            return false;
        }
    }

    public static String getJoinQrLoginPromptInfo(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (ServiceManager.getInstance().getIsAccountManager().getSession() == null) {
            return LivenessStat.TYPE_STRING_DEFAULT;
        }
        return URLDecoder.decode(SapiUtils.urlParamsToMap(str).get("prompt"));
    }
}
