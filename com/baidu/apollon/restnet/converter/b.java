package com.baidu.apollon.restnet.converter;

import android.text.TextUtils;
import com.baidu.apollon.restnet.RestRuntimeException;
import com.baidu.apollon.restnet.rest.e;
import com.baidu.apollon.utils.FileCopyUtils;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
/* loaded from: classes6.dex */
public class b extends AbstractHttpMessageConverter<Object> {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static final Charset f36116a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1987578228, "Lcom/baidu/apollon/restnet/converter/b;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1987578228, "Lcom/baidu/apollon/restnet/converter/b;");
                return;
            }
        }
        f36116a = Charset.forName("UTF-8");
    }

    public b() {
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

    private Charset a(com.baidu.apollon.restnet.http.a aVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, this, aVar)) == null) {
            if (aVar != null && !TextUtils.isEmpty(aVar.j())) {
                return Charset.forName(aVar.j());
            }
            return f36116a;
        }
        return (Charset) invokeL.objValue;
    }

    @Override // com.baidu.apollon.restnet.converter.AbstractHttpMessageConverter
    public Object b(Class<?> cls, e eVar) throws IOException, RestRuntimeException {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, cls, eVar)) == null) {
            String copyToString = FileCopyUtils.copyToString(new InputStreamReader(eVar.c(), a(eVar.d())));
            a(copyToString);
            return copyToString;
        }
        return invokeLL.objValue;
    }
}
