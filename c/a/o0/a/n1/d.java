package c.a.o0.a.n1;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.IOException;
import okhttp3.FormBody;
import okhttp3.MediaType;
import okhttp3.RequestBody;
import okio.BufferedSink;
/* loaded from: classes.dex */
public final class d extends RequestBody {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public MediaType f7550a;

    /* renamed from: b  reason: collision with root package name */
    public final FormBody f7551b;

    public d(FormBody formBody) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {formBody};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f7551b = formBody;
    }

    public static d a(FormBody formBody, MediaType mediaType) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, formBody, mediaType)) == null) {
            d dVar = new d(formBody);
            dVar.b(mediaType);
            return dVar;
        }
        return (d) invokeLL.objValue;
    }

    public void b(MediaType mediaType) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, mediaType) == null) {
            this.f7550a = mediaType;
        }
    }

    @Override // okhttp3.RequestBody
    public long contentLength() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f7551b.contentLength() : invokeV.longValue;
    }

    @Override // okhttp3.RequestBody
    public MediaType contentType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            MediaType mediaType = this.f7550a;
            return mediaType == null ? this.f7551b.contentType() : mediaType;
        }
        return (MediaType) invokeV.objValue;
    }

    @Override // okhttp3.RequestBody
    public void writeTo(BufferedSink bufferedSink) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, bufferedSink) == null) {
            this.f7551b.writeTo(bufferedSink);
        }
    }
}
