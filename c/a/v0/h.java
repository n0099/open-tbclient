package c.a.v0;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.pyramid.annotation.Service;
import com.baidu.pyramid.annotation.Singleton;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.http.HttpManager;
import com.baidu.searchbox.http.request.PostBodyRequest;
import com.baidu.searchbox.http.request.PostByteRequest;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.IOException;
import java.io.InputStream;
import java.util.Map;
import okhttp3.MediaType;
import okhttp3.RequestBody;
import okhttp3.Response;
import okio.BufferedSink;
import okio.Okio;
import okio.Source;
@Singleton
@Service
/* loaded from: classes9.dex */
public class h extends c.a.v0.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes9.dex */
    public class a extends e0 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Response a;

        public a(h hVar, Response response) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hVar, response};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = response;
        }

        @Override // c.a.v0.e0
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.body().close();
            }
        }

        @Override // c.a.v0.e0
        public String b() throws IOException {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.a.body().string() : (String) invokeV.objValue;
        }

        @Override // c.a.v0.e0
        public int c() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.a.code() : invokeV.intValue;
        }

        @Override // c.a.v0.e0
        public String d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.a.message() : (String) invokeV.objValue;
        }

        @Override // c.a.v0.e0
        public boolean e() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.a.isSuccessful() : invokeV.booleanValue;
        }
    }

    /* loaded from: classes9.dex */
    public class b extends RequestBody {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Map a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ InputStream f26462b;

        public b(h hVar, Map map, InputStream inputStream) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hVar, map, inputStream};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = map;
            this.f26462b = inputStream;
        }

        @Override // okhttp3.RequestBody
        public long contentLength() throws IOException {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                if (this.a.containsKey("Content-Length")) {
                    try {
                        return Long.valueOf((String) this.a.get("Content-Length")).longValue();
                    } catch (Exception unused) {
                    }
                }
                return super.contentLength();
            }
            return invokeV.longValue;
        }

        @Override // okhttp3.RequestBody
        public MediaType contentType() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? MediaType.parse("application/octet-stream") : (MediaType) invokeV.objValue;
        }

        @Override // okhttp3.RequestBody
        public void writeTo(BufferedSink bufferedSink) throws IOException {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, bufferedSink) == null) {
                Source source = null;
                try {
                    source = Okio.source(this.f26462b);
                    bufferedSink.writeAll(source);
                } finally {
                    if (source != null) {
                        source.close();
                    }
                }
            }
        }
    }

    /* loaded from: classes9.dex */
    public class c extends e0 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Response a;

        public c(h hVar, Response response) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hVar, response};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = response;
        }

        @Override // c.a.v0.e0
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.body().close();
            }
        }

        @Override // c.a.v0.e0
        public String b() throws IOException {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.a.body().string() : (String) invokeV.objValue;
        }

        @Override // c.a.v0.e0
        public int c() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.a.code() : invokeV.intValue;
        }

        @Override // c.a.v0.e0
        public String d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.a.message() : (String) invokeV.objValue;
        }

        @Override // c.a.v0.e0
        public boolean e() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.a.isSuccessful() : invokeV.booleanValue;
        }
    }

    public h() {
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

    @Override // c.a.v0.a
    public e0 j(String str, InputStream inputStream, Map<String, String> map) throws IOException {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048576, this, str, inputStream, map)) == null) {
            PostBodyRequest.PostBodyRequestBuilder postRequest = HttpManager.getDefault(AppRuntime.getAppContext()).postRequest();
            postRequest.requestFrom(3);
            postRequest.url(str);
            for (Map.Entry<String, String> entry : map.entrySet()) {
                postRequest.addHeader(entry.getKey(), entry.getValue());
            }
            postRequest.cookieManager(HttpManager.getDefault(AppRuntime.getAppContext()).getCookieManager(true, true));
            postRequest.requestBody(new b(this, map, inputStream));
            return new c(this, postRequest.build().executeSync());
        }
        return (e0) invokeLLL.objValue;
    }

    @Override // c.a.v0.a
    public e0 k(String str, byte[] bArr, Map<String, String> map) throws IOException {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, bArr, map)) == null) {
            PostByteRequest.PostByteRequestBuilder postByteRequest = HttpManager.getDefault(AppRuntime.getAppContext()).postByteRequest();
            postByteRequest.requestFrom(3);
            postByteRequest.url(str);
            for (Map.Entry<String, String> entry : map.entrySet()) {
                postByteRequest.addHeader(entry.getKey(), entry.getValue());
            }
            postByteRequest.cookieManager(HttpManager.getDefault(AppRuntime.getAppContext()).getCookieManager(true, true));
            return new a(this, postByteRequest.content(bArr).build().executeSync());
        }
        return (e0) invokeLLL.objValue;
    }
}
