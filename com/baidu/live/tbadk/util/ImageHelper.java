package com.baidu.live.tbadk.util;
/* loaded from: classes3.dex */
public class ImageHelper {
    public static boolean canUseIp(String str) {
        if (str == null) {
            return false;
        }
        if (isCdn(str)) {
            return true;
        }
        int indexOf = str.indexOf("imgsrc");
        return (indexOf > 0 && indexOf < 20) || isPortrait(str);
    }

    public static boolean isCdn(String str) {
        int indexOf;
        return str != null && (indexOf = str.indexOf("hiphotos")) > 0 && indexOf < 20;
    }

    public static boolean isPortrait(String str) {
        int indexOf;
        return str != null && (indexOf = str.indexOf("tb.himg")) > 0 && indexOf < 20;
    }
}
