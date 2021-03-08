package com.baidu.live.adp.lib.image.loader.interfaces;

import android.net.Uri;
import android.text.TextUtils;
import com.baidu.live.adp.lib.util.StringUtils;
import java.io.File;
import org.apache.http.HttpHost;
/* loaded from: classes10.dex */
public class GenerateImageAddressImpl implements IGenerateImageAddress {
    public static String sBigHeaderPhotoUrlPrefix = null;
    private static final String sDefaultHeaderPhotoPrefix = "https://himg.baidu.com/sys/portrait/item/";
    public static String sSmallHeaderPhotoUrlPrefix;

    @Override // com.baidu.live.adp.lib.image.loader.interfaces.IGenerateImageAddress
    public String generateUrl(String str, int i) {
        switch (i) {
            case 10:
            case 39:
            default:
                return str;
            case 12:
            case 25:
                if (TextUtils.isEmpty(str) || !str.startsWith(HttpHost.DEFAULT_SCHEME_NAME)) {
                    String str2 = sBigHeaderPhotoUrlPrefix;
                    if (StringUtils.isNull(str2)) {
                        str2 = sDefaultHeaderPhotoPrefix;
                    }
                    return str2 + str;
                }
                return str;
            case 35:
            case 36:
            case 37:
                if (TextUtils.isEmpty(str) || !str.startsWith("file://")) {
                    return Uri.fromFile(new File(str)).toString();
                }
                return str;
        }
    }
}
