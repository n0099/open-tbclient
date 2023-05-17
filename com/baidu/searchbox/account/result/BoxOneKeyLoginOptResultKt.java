package com.baidu.searchbox.account.result;

import android.annotation.SuppressLint;
import kotlin.Metadata;
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\u001a\u0012\u0010\u0007\u001a\u00020\u00012\b\u0010\b\u001a\u0004\u0018\u00010\u0001H\u0007\"\u0010\u0010\u0000\u001a\u00020\u00018\u0002X\u0083T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0003\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0004\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u0010\u0010\u0005\u001a\u00020\u00018\u0002X\u0083D¢\u0006\u0002\n\u0000\"\u0010\u0010\u0006\u001a\u00020\u00018\u0002X\u0083T¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"MOBILE_AGREE_URL", "", "OPERATOR_TYPE_DX", "OPERATOR_TYPE_LT", "OPERATOR_TYPE_YD", "TELECOM_AGREE_URL", "UNICOM_AGREE_URL", "getAgreeUrl", "operateType", "lib-account-interface_release"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class BoxOneKeyLoginOptResultKt {
    @SuppressLint({"BDOfflineUrl"})
    public static final String MOBILE_AGREE_URL = "https://wap.cmpassport.com/resources/html/contract.html";
    public static final String OPERATOR_TYPE_DX = "3";
    public static final String OPERATOR_TYPE_LT = "2";
    public static final String OPERATOR_TYPE_YD = "1";
    @SuppressLint({"BDOfflineUrl"})
    public static final String TELECOM_AGREE_URL = "https://e.189.cn/sdk/agreement/detail.do?hidetop=true";
    @SuppressLint({"BDOfflineUrl"})
    public static final String UNICOM_AGREE_URL = "https://ms.zzx9.cn/html/oauth/protocol2.html";

    public static final String getAgreeUrl(String str) {
        if (str != null) {
            switch (str.hashCode()) {
                case 49:
                    if (str.equals("1")) {
                        return "https://wap.cmpassport.com/resources/html/contract.html";
                    }
                    break;
                case 50:
                    if (str.equals("2")) {
                        return "https://ms.zzx9.cn/html/oauth/protocol2.html";
                    }
                    break;
                case 51:
                    if (str.equals("3")) {
                        return TELECOM_AGREE_URL;
                    }
                    break;
            }
        }
        return "";
    }
}
