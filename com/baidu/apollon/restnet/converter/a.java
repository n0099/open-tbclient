package com.baidu.apollon.restnet.converter;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.apollon.restnet.rest.e;
import com.baidu.apollon.utils.FileCopyUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
/* loaded from: classes3.dex */
public class a extends AbstractHttpMessageConverter<byte[]> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public a() {
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
    @Override // com.baidu.apollon.restnet.converter.AbstractHttpMessageConverter
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
