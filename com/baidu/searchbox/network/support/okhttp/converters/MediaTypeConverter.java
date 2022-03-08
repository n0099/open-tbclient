package com.baidu.searchbox.network.support.okhttp.converters;

import com.baidu.searchbox.network.outback.core.MediaType;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public final class MediaTypeConverter {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public MediaTypeConverter() {
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

    public static MediaType fromOks(okhttp3.MediaType mediaType) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, mediaType)) == null) {
            if (mediaType != null) {
                return MediaType.parse(mediaType.toString());
            }
            return null;
        }
        return (MediaType) invokeL.objValue;
    }

    public static okhttp3.MediaType toOks(MediaType mediaType) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, mediaType)) == null) {
            if (mediaType != null) {
                return okhttp3.MediaType.parse(mediaType.toString());
            }
            return null;
        }
        return (okhttp3.MediaType) invokeL.objValue;
    }
}
