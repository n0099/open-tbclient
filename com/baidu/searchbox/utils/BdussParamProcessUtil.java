package com.baidu.searchbox.utils;

import android.text.TextUtils;
import com.baidu.android.common.others.url.UrlUtil;
import com.yy.hiidostatis.defs.obj.ParamableElem;
/* loaded from: classes4.dex */
public class BdussParamProcessUtil {
    public static String PARAM_BDUSS = "bduss";
    public static String PARAM_OPEN_BDUSS = "openbduss";

    public static String excludeBdussParam(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        return processBduss(processBduss(str, PARAM_OPEN_BDUSS), PARAM_BDUSS);
    }

    public static String processBduss(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        if (str.contains(str2)) {
            if (UrlUtil.isUrl(str)) {
                String urlField = UrlUtil.getUrlField(str, str2);
                if (!TextUtils.isEmpty(urlField)) {
                    return str.replace(str2 + "=" + urlField, "");
                }
                return str;
            }
            String urlField2 = UrlUtil.getUrlField(str, str2, "=", ParamableElem.DIVIDE_PARAM);
            if (!TextUtils.isEmpty(urlField2)) {
                return str.replace(str2 + "=" + urlField2, "");
            }
            return str;
        }
        return str;
    }
}
