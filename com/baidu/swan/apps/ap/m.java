package com.baidu.swan.apps.ap;

import android.text.TextUtils;
import com.baidu.android.util.io.DocumentOpenUtil;
/* loaded from: classes7.dex */
public class m {
    public static boolean getSupportMimeType(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return TextUtils.equals(DocumentOpenUtil.PDF_TYPE, str) || TextUtils.equals(DocumentOpenUtil.DOCUMENT_TYPE, str) || TextUtils.equals(DocumentOpenUtil.SHEET_TYPE, str) || TextUtils.equals(DocumentOpenUtil.PRESENT_TYPE, str) || TextUtils.equals(DocumentOpenUtil.WORD_TYPE, str) || TextUtils.equals(DocumentOpenUtil.EXCEL_TYPE, str) || TextUtils.equals(DocumentOpenUtil.PPT_TYPE, str);
    }

    public static String guessSupportMimeTypeFromExt(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        String str2 = "";
        String lowerCase = str.toLowerCase();
        char c = 65535;
        switch (lowerCase.hashCode()) {
            case 99640:
                if (lowerCase.equals(DocumentOpenUtil.DOC)) {
                    c = 1;
                    break;
                }
                break;
            case 110834:
                if (lowerCase.equals(DocumentOpenUtil.PDF)) {
                    c = 0;
                    break;
                }
                break;
            case 111220:
                if (lowerCase.equals(DocumentOpenUtil.PPT)) {
                    c = 5;
                    break;
                }
                break;
            case 118783:
                if (lowerCase.equals(DocumentOpenUtil.XLS)) {
                    c = 3;
                    break;
                }
                break;
            case 3088960:
                if (lowerCase.equals(DocumentOpenUtil.DOCX)) {
                    c = 2;
                    break;
                }
                break;
            case 3447940:
                if (lowerCase.equals(DocumentOpenUtil.PPTX)) {
                    c = 6;
                    break;
                }
                break;
            case 3682393:
                if (lowerCase.equals(DocumentOpenUtil.XLSX)) {
                    c = 4;
                    break;
                }
                break;
        }
        switch (c) {
            case 0:
                str2 = DocumentOpenUtil.PDF_TYPE;
                break;
            case 1:
                str2 = DocumentOpenUtil.WORD_TYPE;
                break;
            case 2:
                str2 = DocumentOpenUtil.DOCUMENT_TYPE;
                break;
            case 3:
                str2 = DocumentOpenUtil.EXCEL_TYPE;
                break;
            case 4:
                str2 = DocumentOpenUtil.SHEET_TYPE;
                break;
            case 5:
                str2 = DocumentOpenUtil.PPT_TYPE;
                break;
            case 6:
                str2 = DocumentOpenUtil.PRESENT_TYPE;
                break;
        }
        return !getSupportMimeType(str2) ? "" : str2;
    }
}
