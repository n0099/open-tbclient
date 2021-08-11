package c.f.a.g.b;

import android.text.TextUtils;
import c.f.a.g.d.e;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.dxmpay.apollon.restnet.RestRuntimeException;
import com.dxmpay.apollon.restnet.converter.AbstractHttpMessageConverter;
import com.dxmpay.apollon.utils.FileCopyUtils;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
/* loaded from: classes4.dex */
public class b extends AbstractHttpMessageConverter<Object> {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: b  reason: collision with root package name */
    public static final Charset f32064b;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1904658941, "Lc/f/a/g/b/b;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1904658941, "Lc/f/a/g/b/b;");
                return;
            }
        }
        f32064b = Charset.forName("UTF-8");
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

    @Override // com.dxmpay.apollon.restnet.converter.AbstractHttpMessageConverter
    public Object d(Class<?> cls, e eVar) throws IOException, RestRuntimeException {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, cls, eVar)) == null) {
            String copyToString = FileCopyUtils.copyToString(new InputStreamReader(eVar.b(), e(eVar.c())));
            c(copyToString);
            return copyToString;
        }
        return invokeLL.objValue;
    }

    public final Charset e(c.f.a.g.c.a aVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar)) == null) {
            if (aVar != null && !TextUtils.isEmpty(aVar.j())) {
                return Charset.forName(aVar.j());
            }
            return f32064b;
        }
        return (Charset) invokeL.objValue;
    }
}
