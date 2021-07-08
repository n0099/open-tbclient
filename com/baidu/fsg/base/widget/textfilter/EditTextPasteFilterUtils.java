package com.baidu.fsg.base.widget.textfilter;

import android.content.Context;
import android.text.ClipboardManager;
import android.text.TextUtils;
import android.util.AttributeSet;
import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/* loaded from: classes2.dex */
public class EditTextPasteFilterUtils {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String EDITTEXT_PASTE_INTERCEPTOR_KEY = "textPasteInteceptor";
    public static final String EDITTEXT_PASTE_INTERCEPTOR_SEPERATOR = "\\|";
    public static final String REGX_DIGIT = "[1-9]\\d*[\\.]{0,1}\\d*|0\\.\\d*|\\.\\d*";
    public static final String REGX_EMAIL = "\\w+([-+.]\\w+)*@\\w+([-.]\\w+)*\\.\\w+([-.]\\w+)*";
    public static final String REGX_ID = "[0-9xX]+";
    public static final String REGX_NUMBER = "[0-9]+";
    public static final String regxEmailOrPhone = "\\w+([-+.]\\w+)*@\\w+([-.]\\w+)*\\.\\w+([-.]\\w+)*|[0-9]+";
    public transient /* synthetic */ FieldHolder $fh;

    public EditTextPasteFilterUtils() {
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

    public static String applyEditTextPasteFilters(Context context, List<IEditTextPasteFilter> list) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, context, list)) == null) {
            ClipboardManager clipboardManager = (ClipboardManager) context.getSystemService("clipboard");
            if (clipboardManager == null) {
                return "";
            }
            CharSequence text = clipboardManager.getText();
            String charSequence = TextUtils.isEmpty(text) ? "" : text.toString();
            if (!TextUtils.isEmpty(charSequence)) {
                for (IEditTextPasteFilter iEditTextPasteFilter : list) {
                    charSequence = iEditTextPasteFilter.intercept(charSequence);
                }
            }
            return charSequence;
        }
        return (String) invokeLL.objValue;
    }

    public static List<IEditTextPasteFilter> parseEditTextPasteFilter(AttributeSet attributeSet) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, attributeSet)) == null) {
            if (attributeSet == null) {
                return null;
            }
            return parseEditTextPasteFilter(attributeSet.getAttributeValue(null, "textPasteInteceptor"));
        }
        return (List) invokeL.objValue;
    }

    public static List<String> regxParse(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, str, str2)) == null) {
            ArrayList arrayList = new ArrayList();
            Matcher matcher = Pattern.compile(str2).matcher(str);
            while (matcher.find()) {
                arrayList.add(matcher.group());
            }
            return arrayList;
        }
        return (List) invokeLL.objValue;
    }

    public static List<IEditTextPasteFilter> parseEditTextPasteFilter(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, str)) == null) {
            ArrayList arrayList = new ArrayList();
            if (!TextUtils.isEmpty(str)) {
                String[] split = str.trim().split("\\|");
                String name = EditTextPasteFilterUtils.class.getPackage().getName();
                for (String str2 : split) {
                    try {
                        Object newInstance = Class.forName(name + "." + str2.trim()).newInstance();
                        if (newInstance != null && (newInstance instanceof IEditTextPasteFilter)) {
                            arrayList.add((IEditTextPasteFilter) newInstance);
                        }
                    } catch (Throwable th) {
                        th.printStackTrace();
                    }
                }
            }
            return arrayList;
        }
        return (List) invokeL.objValue;
    }
}
