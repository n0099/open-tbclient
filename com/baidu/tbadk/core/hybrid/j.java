package com.baidu.tbadk.core.hybrid;

import android.os.Build;
import android.text.TextUtils;
import android.webkit.MimeTypeMap;
import com.baidu.adp.plugin.proxy.ContentProviderProxy;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TiebaIMConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AccountData;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class j {
    public static List<String> adL = new ArrayList();
    public static List<String> adM = new ArrayList();

    static {
        adL.add("jpg");
        adL.add("jpeg");
        adL.add("png");
        adL.add("webp");
        adL.add("gif");
        adM.add("eot");
        adM.add("svg");
        adM.add("ttf");
        adM.add("woff");
        adM.add("ico");
    }

    public static boolean cX(String str) {
        return (TextUtils.isEmpty(str) || str.contains("/api")) ? false : true;
    }

    public static boolean cY(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return TextUtils.equals(MimeTypeMap.getFileExtensionFromUrl(str), "js");
    }

    public static boolean cZ(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return TextUtils.equals(MimeTypeMap.getFileExtensionFromUrl(str), "css");
    }

    public static String tV() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("_client_type=%s", "2")).append(ContentProviderProxy.PROVIDER_AUTHOR_SEPARATOR);
        sb.append(String.format("apid=%s", "2")).append(ContentProviderProxy.PROVIDER_AUTHOR_SEPARATOR);
        sb.append(String.format("_client_version=%s", TbConfig.getVersion())).append(ContentProviderProxy.PROVIDER_AUTHOR_SEPARATOR);
        sb.append(String.format("_phone_imei=%s", TbadkCoreApplication.getInst().getImei())).append(ContentProviderProxy.PROVIDER_AUTHOR_SEPARATOR);
        sb.append(String.format("_client_id=%s", TbadkCoreApplication.getClientId())).append(ContentProviderProxy.PROVIDER_AUTHOR_SEPARATOR);
        sb.append(String.format("subapp_type=%s", TbConfig.getSubappType())).append(ContentProviderProxy.PROVIDER_AUTHOR_SEPARATOR);
        sb.append(String.format("from=%s", TbadkCoreApplication.getFrom())).append(ContentProviderProxy.PROVIDER_AUTHOR_SEPARATOR);
        sb.append(String.format("cuid=%s", TbadkCoreApplication.getInst().getCuid())).append(ContentProviderProxy.PROVIDER_AUTHOR_SEPARATOR);
        sb.append(String.format("timestamp=%s", Long.toString(System.currentTimeMillis()))).append(ContentProviderProxy.PROVIDER_AUTHOR_SEPARATOR);
        sb.append(String.format("model=%s", Build.MODEL)).append(ContentProviderProxy.PROVIDER_AUTHOR_SEPARATOR);
        sb.append(String.format("pversion=%s", TiebaIMConfig.PROTOBUF_VERSION)).append(ContentProviderProxy.PROVIDER_AUTHOR_SEPARATOR);
        AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
        if (currentAccountObj != null) {
            String bduss = currentAccountObj.getBDUSS();
            if (bduss != null) {
                sb.append(String.format("BDUSS=%s", bduss)).append(ContentProviderProxy.PROVIDER_AUTHOR_SEPARATOR);
                sb.append(String.format("stoken=%s", com.baidu.tbadk.core.a.e.d(currentAccountObj))).append(ContentProviderProxy.PROVIDER_AUTHOR_SEPARATOR);
            } else {
                sb.append(String.format("BDUSS=%s", "")).append(ContentProviderProxy.PROVIDER_AUTHOR_SEPARATOR);
                sb.append(String.format("stoken=%s", "")).append(ContentProviderProxy.PROVIDER_AUTHOR_SEPARATOR);
            }
        } else {
            sb.append(String.format("BDUSS=%s", "")).append(ContentProviderProxy.PROVIDER_AUTHOR_SEPARATOR);
            sb.append(String.format("stoken=%s", "")).append(ContentProviderProxy.PROVIDER_AUTHOR_SEPARATOR);
        }
        return sb.toString();
    }
}
