package com.baidu.tbadk.core.util;
/* loaded from: classes.dex */
public class au {
    public static String eo(String str) {
        String[] split = str.split("url=");
        if (split == null || split.length != 2) {
            return "";
        }
        return "nohead:url=" + split[1];
    }
}
