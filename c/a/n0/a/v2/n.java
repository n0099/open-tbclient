package c.a.n0.a.v2;

import android.text.TextUtils;
import com.baidu.android.util.io.DocumentOpenUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes.dex */
public class n {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static boolean a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            return TextUtils.equals(DocumentOpenUtil.PDF_TYPE, str) || TextUtils.equals(DocumentOpenUtil.DOCUMENT_TYPE, str) || TextUtils.equals(DocumentOpenUtil.SHEET_TYPE, str) || TextUtils.equals(DocumentOpenUtil.PRESENT_TYPE, str) || TextUtils.equals(DocumentOpenUtil.WORD_TYPE, str) || TextUtils.equals(DocumentOpenUtil.EXCEL_TYPE, str) || TextUtils.equals(DocumentOpenUtil.PPT_TYPE, str);
        }
        return invokeL.booleanValue;
    }

    public static String b(String str) {
        InterceptResult invokeL;
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return "";
            }
            String lowerCase = str.toLowerCase();
            char c2 = 65535;
            switch (lowerCase.hashCode()) {
                case 99640:
                    if (lowerCase.equals(DocumentOpenUtil.DOC)) {
                        c2 = 1;
                        break;
                    }
                    break;
                case 110834:
                    if (lowerCase.equals(DocumentOpenUtil.PDF)) {
                        c2 = 0;
                        break;
                    }
                    break;
                case 111220:
                    if (lowerCase.equals(DocumentOpenUtil.PPT)) {
                        c2 = 5;
                        break;
                    }
                    break;
                case 118783:
                    if (lowerCase.equals(DocumentOpenUtil.XLS)) {
                        c2 = 3;
                        break;
                    }
                    break;
                case 3088960:
                    if (lowerCase.equals(DocumentOpenUtil.DOCX)) {
                        c2 = 2;
                        break;
                    }
                    break;
                case 3447940:
                    if (lowerCase.equals(DocumentOpenUtil.PPTX)) {
                        c2 = 6;
                        break;
                    }
                    break;
                case 3682393:
                    if (lowerCase.equals(DocumentOpenUtil.XLSX)) {
                        c2 = 4;
                        break;
                    }
                    break;
            }
            switch (c2) {
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
                default:
                    str2 = "";
                    break;
            }
            return a(str2) ? str2 : "";
        }
        return (String) invokeL.objValue;
    }
}
