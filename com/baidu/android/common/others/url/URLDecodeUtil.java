package com.baidu.android.common.others.url;

import android.text.TextUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
@Deprecated
/* loaded from: classes3.dex */
public class URLDecodeUtil {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String PERCENT_PATTEN = "%(?![0-9a-fA-F]{2})";
    public static final String PERCENT_TO_REPLACE = "%25";
    public static final String UTF_8 = "UTF-8";
    public transient /* synthetic */ FieldHolder $fh;

    public URLDecodeUtil() {
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

    public static String decodeWithUTF8(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return str;
            }
            try {
                return URLDecoder.decode(str.replaceAll("%(?![0-9a-fA-F]{2})", "%25"), "UTF-8");
            } catch (UnsupportedEncodingException e2) {
                e2.printStackTrace();
                return str;
            } catch (IllegalArgumentException e3) {
                e3.printStackTrace();
                return str;
            }
        }
        return (String) invokeL.objValue;
    }
}
