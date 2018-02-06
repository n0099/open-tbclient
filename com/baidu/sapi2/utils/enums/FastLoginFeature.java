package com.baidu.sapi2.utils.enums;

import android.text.TextUtils;
import com.tencent.connect.common.Constants;
/* loaded from: classes.dex */
public enum FastLoginFeature {
    TX_WEIXIN_SSO("tweixin_sso"),
    SINA_WEIBO_SSO("tsina_sso"),
    SINA_WEIBO_WEBVIEW("tsina"),
    TX_WEIBO_WEBVIEW("tqq"),
    TX_QQ_WEBVIEW(Constants.SOURCE_QZONE),
    TX_QQ_SSO(Constants.SOURCE_QZONE),
    QR_LOGIN("qr_app_login"),
    NM_LOGIN("nuomi_login"),
    VOICE_LOGIN("voice_login"),
    HUAWEI_LOGIN("huawei_login"),
    CHUANKE_LOGIN("chuanke"),
    WANDA_FEIFAN_LOGIN("feifan"),
    MEIZU_SSO("meizu_sso");
    
    private String a;

    public static FastLoginFeature mapStrToValue(String str) {
        FastLoginFeature[] values;
        if (TextUtils.isEmpty(str)) {
            return getDefault();
        }
        for (FastLoginFeature fastLoginFeature : values()) {
            if (str.equals(fastLoginFeature.getStrValue())) {
                return fastLoginFeature;
            }
        }
        return getDefault();
    }

    public static FastLoginFeature getDefault() {
        return SINA_WEIBO_SSO;
    }

    FastLoginFeature(String str) {
        this.a = str;
    }

    public String getStrValue() {
        return this.a;
    }
}
