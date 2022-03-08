package com.baidu.fsg.base.restnet.a;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.fsg.base.restnet.RestRuntimeException;
import com.baidu.fsg.base.restnet.rest.e;
import com.baidu.fsg.base.utils.FileCopyUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
/* loaded from: classes4.dex */
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

    /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
    @Override // com.baidu.fsg.base.restnet.a.a
    public /* bridge */ /* synthetic */ byte[] b(Class cls, e eVar) throws IOException, RestRuntimeException {
        return b2((Class<?>) cls, eVar);
    }

    @Override // com.baidu.fsg.base.restnet.a.a
    /* renamed from: b  reason: avoid collision after fix types in other method */
    public byte[] b2(Class<?> cls, e eVar) throws IOException {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, cls, eVar)) == null) {
            long i2 = eVar.a().i();
            if (i2 >= 0) {
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream((int) i2);
                FileCopyUtils.copy(eVar.d(), byteArrayOutputStream);
                return byteArrayOutputStream.toByteArray();
            }
            return FileCopyUtils.copyToByteArray(eVar.d());
        }
        return (byte[]) invokeLL.objValue;
    }
}
