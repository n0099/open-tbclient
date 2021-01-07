package com.baidu.android.common.others.lang;

import android.text.TextUtils;
/* loaded from: classes4.dex */
public final class StringUtils {
    private StringUtils() {
    }

    public static boolean containsWhitespace(CharSequence charSequence) {
        if (TextUtils.isEmpty(charSequence)) {
            return false;
        }
        int length = charSequence.length();
        for (int i = 0; i < length; i++) {
            if (Character.isWhitespace(charSequence.charAt(i))) {
                return true;
            }
        }
        return false;
    }

    public static boolean startsWith(String str, String str2, boolean z) {
        if (str == null || str2 == null || str.length() < str2.length()) {
            return false;
        }
        if (str.startsWith(str2)) {
            return true;
        }
        if (z) {
            return str.substring(0, str2.length()).toLowerCase().equals(str2.toLowerCase());
        }
        return false;
    }

    public static boolean endsWith(String str, String str2, boolean z) {
        if (str == null || str2 == null) {
            return false;
        }
        if (str.endsWith(str2)) {
            return true;
        }
        if (str.length() < str2.length() || !z) {
            return false;
        }
        return str.substring(str.length() - str2.length()).toLowerCase().equals(str2.toLowerCase());
    }

    public static int getRepetitions(String str, String str2) {
        int i = 0;
        if (str == null || str2 == null || str.length() == 0 || str2.length() == 0) {
            return 0;
        }
        int i2 = 0;
        while (true) {
            int i3 = i;
            int indexOf = str.indexOf(str2, i2);
            if (indexOf != -1) {
                i = i3 + 1;
                i2 = indexOf + str2.length();
            } else {
                return i3;
            }
        }
    }

    public static int length(String str, boolean z) {
        char[] charArray;
        if (TextUtils.isEmpty(str)) {
            return 0;
        }
        int i = 0;
        for (char c : str.toCharArray()) {
            float f = 2.0f;
            if (c > 0 && c < 127 && z) {
                f = 1.0f;
            }
            i = (int) (f + i);
        }
        return i;
    }

    public static boolean isBlank(CharSequence charSequence) {
        int length;
        if (charSequence == null || (length = charSequence.length()) == 0) {
            return true;
        }
        for (int i = 0; i < length; i++) {
            if (!Character.isWhitespace(charSequence.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    public static String toHexString(byte[] bArr, String str, boolean z) {
        StringBuilder sb = new StringBuilder();
        for (byte b2 : bArr) {
            String hexString = Integer.toHexString(b2 & 255);
            if (z) {
                hexString = hexString.toUpperCase();
            }
            if (hexString.length() == 1) {
                sb.append("0");
            }
            sb.append(hexString).append(str);
        }
        return sb.length() > 1 ? sb.substring(0, sb.length() - 1) : sb.toString();
    }
}
