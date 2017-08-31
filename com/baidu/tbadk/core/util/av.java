package com.baidu.tbadk.core.util;
/* loaded from: classes.dex */
public class av {
    public static String eg(String str) {
        String[] split = str.split("url=");
        if (split == null || split.length != 2) {
            return "";
        }
        return "nohead:url=" + split[1];
    }
}
