package com.baidu.cyberplayer.sdk.extractor;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.cyberplayer.sdk.Keep;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.FileDescriptor;
import java.util.Map;
@Keep
/* loaded from: classes2.dex */
public class CyberExtractor {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String KEY_DURATION = "duration";
    public static final String KEY_HEIGHT = "height";
    public static final String KEY_WIDTH = "width";
    public static final int OPT_CATEGORY_FORMAT = 1;
    public static final String OPT_KEY_PREPARE_TIME_OUT = "prepare_time_out";
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public ExtractorProvider f4923a;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public CyberExtractor() {
        this(true);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                this(((Boolean) newInitContext.callArgs[0]).booleanValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public CyberExtractor(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Boolean.valueOf(z)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f4923a = a.a().a(z);
    }

    public Bundle getMetaData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            ExtractorProvider extractorProvider = this.f4923a;
            if (extractorProvider != null) {
                return extractorProvider.getMediaMeta();
            }
            return null;
        }
        return (Bundle) invokeV.objValue;
    }

    public void release() {
        ExtractorProvider extractorProvider;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (extractorProvider = this.f4923a) == null) {
            return;
        }
        extractorProvider.release();
        this.f4923a = null;
    }

    public void setDataSource(Context context, Uri uri) {
        ExtractorProvider extractorProvider;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, context, uri) == null) || (extractorProvider = this.f4923a) == null) {
            return;
        }
        extractorProvider.setDataSource(context, uri);
    }

    public void setDataSource(Context context, Uri uri, Map<String, String> map) {
        ExtractorProvider extractorProvider;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(1048579, this, context, uri, map) == null) || (extractorProvider = this.f4923a) == null) {
            return;
        }
        extractorProvider.setDataSource(context, uri, map);
    }

    public void setDataSource(FileDescriptor fileDescriptor) {
        ExtractorProvider extractorProvider;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048580, this, fileDescriptor) == null) || (extractorProvider = this.f4923a) == null) {
            return;
        }
        extractorProvider.setDataSource(fileDescriptor);
    }

    public void setDataSource(String str) {
        ExtractorProvider extractorProvider;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048581, this, str) == null) || (extractorProvider = this.f4923a) == null) {
            return;
        }
        extractorProvider.setDataSource(str);
    }

    public void setOption(int i2, String str, long j) {
        ExtractorProvider extractorProvider;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048582, this, new Object[]{Integer.valueOf(i2), str, Long.valueOf(j)}) == null) || (extractorProvider = this.f4923a) == null) {
            return;
        }
        extractorProvider.setOption(i2, str, j);
    }
}
