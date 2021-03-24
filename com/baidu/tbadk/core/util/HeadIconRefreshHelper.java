package com.baidu.tbadk.core.util;

import com.baidu.adp.lib.util.StringUtils;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/* loaded from: classes3.dex */
public class HeadIconRefreshHelper {
    public static String headPortraitFilter(String str) {
        if (StringUtils.isNull(str)) {
            return "";
        }
        Matcher matcher = Pattern.compile("t=(\\d+)").matcher(str);
        if (matcher.find()) {
            String group = matcher.group(1);
            return str + "&tieba_portrait_time=" + group;
        }
        return str;
    }
}
