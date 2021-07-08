package com.baidu.fsg.base.restnet.a;

import android.text.TextUtils;
import com.baidu.fsg.base.ApollonConstants;
import com.baidu.fsg.base.restnet.RestRuntimeException;
import com.baidu.fsg.base.restnet.rest.e;
import com.baidu.fsg.base.utils.FileCopyUtils;
import com.baidu.fsg.base.utils.JsonUtils;
import com.baidu.fsg.base.utils.LogUtil;
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
import org.json.JSONException;
/* loaded from: classes2.dex */
public class c extends a<Object> {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static final Charset f5189a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1823001671, "Lcom/baidu/fsg/base/restnet/a/c;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1823001671, "Lcom/baidu/fsg/base/restnet/a/c;");
                return;
            }
        }
        f5189a = Charset.forName("UTF-8");
    }

    public c() {
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

    private Charset a(com.baidu.fsg.base.restnet.http.a aVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, this, aVar)) == null) {
            if (aVar != null && !TextUtils.isEmpty(aVar.j())) {
                return Charset.forName(aVar.j());
            }
            return f5189a;
        }
        return (Charset) invokeL.objValue;
    }

    @Override // com.baidu.fsg.base.restnet.a.a
    public Object b(Class<?> cls, e eVar) throws IOException, RestRuntimeException {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, cls, eVar)) == null) {
            InputStreamReader inputStreamReader = new InputStreamReader(eVar.c(), a(eVar.d()));
            String copyToString = FileCopyUtils.copyToString(inputStreamReader);
            if (ApollonConstants.DEBUG) {
                int length = copyToString.length();
                int i2 = 0;
                while (i2 < length) {
                    int i3 = i2 + 2000;
                    LogUtil.i("ServerResponse", i3 > length ? copyToString.substring(i2) : copyToString.substring(i2, i3));
                    i2 = i3;
                }
            }
            try {
                Object fromJson = JsonUtils.fromJson(copyToString, cls);
                inputStreamReader.close();
                return fromJson;
            } catch (JSONException e2) {
                throw new RestRuntimeException("Could not read JSON: " + e2.getMessage(), e2);
            }
        }
        return invokeLL.objValue;
    }
}
