package c.a.q0.a.d0;

import c.a.d.f.p.m;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/* loaded from: classes2.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final c a;

    public b() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = new c();
    }

    public a a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            String str2 = null;
            if (m.isEmpty(str)) {
                return null;
            }
            Matcher matcher = Pattern.compile("\\$[0-9A-Za-z@_]{5,200}[#$]", 2).matcher(str);
            if (matcher.find()) {
                String group = matcher.group();
                Matcher matcher2 = Pattern.compile("\\$[0-9A-Za-z@_]{1,100}[!]", 2).matcher(str);
                String d2 = matcher2.find() ? e.d(matcher2.group()) : null;
                if (d2 != null && d2.startsWith("Y")) {
                    str2 = b(group);
                }
                return new a(group, str2, d2);
            }
            return null;
        }
        return (a) invokeL.objValue;
    }

    public final String b(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
            if (StringUtils.isNull(str)) {
                return null;
            }
            return this.a.a(e.f(str.replaceAll("\\$", "")));
        }
        return (String) invokeL.objValue;
    }
}
