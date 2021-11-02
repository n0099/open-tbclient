package com.baidu.android.util.io;

import android.text.TextUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Locale;
@Deprecated
/* loaded from: classes6.dex */
public class DocumentOpenUtil {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String DOC = "doc";
    public static final String DOCUMENT_TYPE = "application/vnd.openxmlformats-officedocument.wordprocessingml.document";
    public static final String DOCX = "docx";
    public static final String EXCEL_TYPE = "application/vnd.ms-excel";
    public static final String OFFICE03_PLUGIN_PACKAGE_NAME = "com.baidu.browser.officereader";
    public static final String OFFICE07_PLUGIN_PACKAGE_NAME = "com.baidu.browser.officereaderx";
    public static final String OFFICE_PLUGIN_OPEN_FILE_METHOD = "open";
    public static final String PDF = "pdf";
    public static final String PDF_PLUGIN_OPEN_FILE_METHOD = "open";
    public static final String PDF_PLUGIN_PACKAGE_NAME = "com.baidu.browser.pdfviewer";
    public static final String PDF_TYPE = "application/pdf";
    public static final String PPT = "ppt";
    public static final String PPTX = "pptx";
    public static final String PPT_TYPE = "application/vnd.ms-powerpoint";
    public static final String PRESENT_TYPE = "application/vnd.openxmlformats-officedocument.presentationml.presentation";
    public static final String SHEET_TYPE = "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet";
    public static final String TXT = "txt";
    public static final String WORD_TYPE = "application/msword";
    public static final String XLS = "xls";
    public static final String XLSX = "xlsx";
    public transient /* synthetic */ FieldHolder $fh;

    public DocumentOpenUtil() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public static String getFixSupportMimeType(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, str, str2)) == null) {
            if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2) && !getSupportMimeType(str)) {
                String lowerCase = str2.toLowerCase(Locale.getDefault());
                char c2 = 65535;
                switch (lowerCase.hashCode()) {
                    case 99640:
                        if (lowerCase.equals(DOC)) {
                            c2 = 1;
                            break;
                        }
                        break;
                    case 110834:
                        if (lowerCase.equals(PDF)) {
                            c2 = 0;
                            break;
                        }
                        break;
                    case 111220:
                        if (lowerCase.equals(PPT)) {
                            c2 = 5;
                            break;
                        }
                        break;
                    case 118783:
                        if (lowerCase.equals(XLS)) {
                            c2 = 3;
                            break;
                        }
                        break;
                    case 3088960:
                        if (lowerCase.equals(DOCX)) {
                            c2 = 2;
                            break;
                        }
                        break;
                    case 3447940:
                        if (lowerCase.equals(PPTX)) {
                            c2 = 6;
                            break;
                        }
                        break;
                    case 3682393:
                        if (lowerCase.equals(XLSX)) {
                            c2 = 4;
                            break;
                        }
                        break;
                }
                switch (c2) {
                    case 0:
                        str = PDF_TYPE;
                        break;
                    case 1:
                        str = WORD_TYPE;
                        break;
                    case 2:
                        str = DOCUMENT_TYPE;
                        break;
                    case 3:
                        str = EXCEL_TYPE;
                        break;
                    case 4:
                        str = SHEET_TYPE;
                        break;
                    case 5:
                        str = PPT_TYPE;
                        break;
                    case 6:
                        str = PRESENT_TYPE;
                        break;
                }
                if (getSupportMimeType(str)) {
                    return str;
                }
            }
            return "";
        }
        return (String) invokeLL.objValue;
    }

    public static boolean getSupportMimeType(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            return TextUtils.equals(PDF_TYPE, str) || TextUtils.equals(DOCUMENT_TYPE, str) || TextUtils.equals(SHEET_TYPE, str) || TextUtils.equals(PRESENT_TYPE, str) || TextUtils.equals(WORD_TYPE, str) || TextUtils.equals(EXCEL_TYPE, str) || TextUtils.equals(PPT_TYPE, str);
        }
        return invokeL.booleanValue;
    }

    public static String guessSupportMimeTypeFromExt(String str) {
        InterceptResult invokeL;
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return "";
            }
            String lowerCase = str.toLowerCase(Locale.getDefault());
            char c2 = 65535;
            switch (lowerCase.hashCode()) {
                case 99640:
                    if (lowerCase.equals(DOC)) {
                        c2 = 1;
                        break;
                    }
                    break;
                case 110834:
                    if (lowerCase.equals(PDF)) {
                        c2 = 0;
                        break;
                    }
                    break;
                case 111220:
                    if (lowerCase.equals(PPT)) {
                        c2 = 5;
                        break;
                    }
                    break;
                case 118783:
                    if (lowerCase.equals(XLS)) {
                        c2 = 3;
                        break;
                    }
                    break;
                case 3088960:
                    if (lowerCase.equals(DOCX)) {
                        c2 = 2;
                        break;
                    }
                    break;
                case 3447940:
                    if (lowerCase.equals(PPTX)) {
                        c2 = 6;
                        break;
                    }
                    break;
                case 3682393:
                    if (lowerCase.equals(XLSX)) {
                        c2 = 4;
                        break;
                    }
                    break;
            }
            switch (c2) {
                case 0:
                    str2 = PDF_TYPE;
                    break;
                case 1:
                    str2 = WORD_TYPE;
                    break;
                case 2:
                    str2 = DOCUMENT_TYPE;
                    break;
                case 3:
                    str2 = EXCEL_TYPE;
                    break;
                case 4:
                    str2 = SHEET_TYPE;
                    break;
                case 5:
                    str2 = PPT_TYPE;
                    break;
                case 6:
                    str2 = PRESENT_TYPE;
                    break;
                default:
                    str2 = "";
                    break;
            }
            return getSupportMimeType(str2) ? str2 : "";
        }
        return (String) invokeL.objValue;
    }
}
