package com.baidu.fsg.base.restnet.a;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.fsg.base.restnet.rest.e;
import com.baidu.fsg.base.utils.FileCopyUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
/* loaded from: classes5.dex */
public class b extends a<byte[]> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

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
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.fsg.base.restnet.a.a
    /* renamed from: c */
    public byte[] b(Class<?> cls, e eVar) throws IOException {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, cls, eVar)) == null) {
            long h2 = eVar.d().h();
            if (h2 >= 0) {
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream((int) h2);
                FileCopyUtils.copy(eVar.c(), byteArrayOutputStream);
                return byteArrayOutputStream.toByteArray();
            }
            return FileCopyUtils.copyToByteArray(eVar.c());
        }
        return (byte[]) invokeLL.objValue;
    }
}
