package com.baidu.swan.apps.an;

import android.text.TextUtils;
/* loaded from: classes2.dex */
public class h {
    public static boolean ik(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return TextUtils.equals("application/pdf", str) || TextUtils.equals("application/vnd.openxmlformats-officedocument.wordprocessingml.document", str) || TextUtils.equals("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet", str) || TextUtils.equals("application/vnd.openxmlformats-officedocument.presentationml.presentation", str) || TextUtils.equals("application/msword", str) || TextUtils.equals("application/vnd.ms-excel", str) || TextUtils.equals("application/vnd.ms-powerpoint", str);
    }

    public static String il(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        String str2 = "";
        String lowerCase = str.toLowerCase();
        char c = 65535;
        switch (lowerCase.hashCode()) {
            case 99640:
                if (lowerCase.equals("doc")) {
                    c = 1;
                    break;
                }
                break;
            case 110834:
                if (lowerCase.equals("pdf")) {
                    c = 0;
                    break;
                }
                break;
            case 111220:
                if (lowerCase.equals("ppt")) {
                    c = 5;
                    break;
                }
                break;
            case 118783:
                if (lowerCase.equals("xls")) {
                    c = 3;
                    break;
                }
                break;
            case 3088960:
                if (lowerCase.equals("docx")) {
                    c = 2;
                    break;
                }
                break;
            case 3447940:
                if (lowerCase.equals("pptx")) {
                    c = 6;
                    break;
                }
                break;
            case 3682393:
                if (lowerCase.equals("xlsx")) {
                    c = 4;
                    break;
                }
                break;
        }
        switch (c) {
            case 0:
                str2 = "application/pdf";
                break;
            case 1:
                str2 = "application/msword";
                break;
            case 2:
                str2 = "application/vnd.openxmlformats-officedocument.wordprocessingml.document";
                break;
            case 3:
                str2 = "application/vnd.ms-excel";
                break;
            case 4:
                str2 = "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet";
                break;
            case 5:
                str2 = "application/vnd.ms-powerpoint";
                break;
            case 6:
                str2 = "application/vnd.openxmlformats-officedocument.presentationml.presentation";
                break;
        }
        return !ik(str2) ? "" : str2;
    }
}
