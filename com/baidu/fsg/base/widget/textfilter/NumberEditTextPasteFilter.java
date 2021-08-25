package com.baidu.fsg.base.widget.textfilter;

import android.text.TextUtils;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
/* loaded from: classes5.dex */
public class NumberEditTextPasteFilter implements IEditTextPasteFilter {
    public static /* synthetic */ Interceptable $ic = null;

    /* renamed from: a  reason: collision with root package name */
    public static final String f39640a = "NumberEditTextPasteFilter";
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1016219434, "Lcom/baidu/fsg/base/widget/textfilter/NumberEditTextPasteFilter;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1016219434, "Lcom/baidu/fsg/base/widget/textfilter/NumberEditTextPasteFilter;");
        }
    }

    public NumberEditTextPasteFilter() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    @Override // com.baidu.fsg.base.widget.textfilter.IEditTextPasteFilter
    public String intercept(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            List<String> regxParse = EditTextPasteFilterUtils.regxParse(str, "[0-9]+");
            if (regxParse == null || regxParse.size() <= 0) {
                return "";
            }
            StringBuilder sb = new StringBuilder();
            for (String str2 : regxParse) {
                if (!TextUtils.isEmpty(str2)) {
                    sb.append(str2);
                }
            }
            return sb.toString();
        }
        return (String) invokeL.objValue;
    }
}
