package com.baidu.tbadk.core.util;

import com.baidu.adp.lib.util.StringUtils;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/* loaded from: classes.dex */
public class o {
    public static String sU(String str) {
        if (StringUtils.isNull(str)) {
            return "";
        }
        Matcher matcher = Pattern.compile("t=(\\d+)").matcher(str);
        if (matcher.find()) {
            return str + "&tieba_portrait_time=" + matcher.group(1);
        }
        return str;
    }
}
