package c.a.d.f.j.b;

import android.net.http.Headers;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.adp.lib.network.http.IHttpNet;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.network.outback.core.Request;
import com.baidu.searchbox.network.outback.core.Response;
import com.baidu.searchbox.network.outback.manager.HttpManager;
import com.baidu.searchbox.network.outback.request.PostFormRequest;
import com.baidu.searchbox.network.outback.request.RequestCall;
import com.baidu.searchbox.network.outback.statistics.RequestCallException;
import com.baidu.searchbox.network.outback.support.request.HttpRequestCompat;
import com.baidu.searchbox.network.outback.support.request.PostMultiPartFormRequest;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.Map;
/* loaded from: classes.dex */
public class d implements IHttpNet {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final f a;

    /* renamed from: b  reason: collision with root package name */
    public Request.Builder<?> f1975b;

    /* renamed from: c  reason: collision with root package name */
    public RequestCall f1976c;

    /* renamed from: d  reason: collision with root package name */
    public Response f1977d;

    /* loaded from: classes.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public static final /* synthetic */ int[] a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1424779142, "Lc/a/d/f/j/b/d$a;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(1424779142, "Lc/a/d/f/j/b/d$a;");
                    return;
                }
            }
            int[] iArr = new int[IHttpNet.HttpNetType.values().length];
            a = iArr;
            try {
                iArr[IHttpNet.HttpNetType.GET.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[IHttpNet.HttpNetType.POST_FORM.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[IHttpNet.HttpNetType.POST_BYTE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    public d(f fVar, IHttpNet.HttpNetType httpNetType) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {fVar, httpNetType};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = fVar;
        int i4 = a.a[httpNetType.ordinal()];
        if (i4 == 1) {
            this.f1975b = HttpManager.getDefault(BdBaseApplication.getInst()).getRequest();
        } else if (i4 == 2) {
            this.f1975b = HttpManager.getDefault(BdBaseApplication.getInst()).postFormRequest();
        } else if (i4 != 3) {
        } else {
            this.f1975b = new HttpRequestCompat(HttpManager.getDefault(BdBaseApplication.getInst())).postMultiPartRequest();
        }
    }

    /* JADX WARN: Type inference failed for: r5v2, types: [com.baidu.searchbox.network.outback.core.Request$Builder] */
    @Override // com.baidu.adp.lib.network.http.IHttpNet
    public void a(URL url, int i2, int i3) {
        Request.Builder<?> builder;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLII(1048576, this, url, i2, i3) == null) || (builder = this.f1975b) == null || url == null) {
            return;
        }
        builder.url(url.toString()).connectionTimeout(i2).readTimeout(i3);
    }

    @Override // com.baidu.adp.lib.network.http.IHttpNet
    public Map<String, List<String>> b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            Response response = this.f1977d;
            if (response == null || response.headers() == null) {
                return null;
            }
            return this.f1977d.headers().toMultimap();
        }
        return (Map) invokeV.objValue;
    }

    @Override // com.baidu.adp.lib.network.http.IHttpNet
    public int c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            Request.Builder<?> builder = this.f1975b;
            if (builder == null) {
                return 0;
            }
            if (builder instanceof PostFormRequest.PostFormRequestBuilder) {
                ((PostFormRequest.PostFormRequestBuilder) builder).params(this.a.b().j());
            } else if (builder instanceof PostMultiPartFormRequest.PostMultiPartFormRequestBuilder) {
                ((PostMultiPartFormRequest.PostMultiPartFormRequestBuilder) builder).addParams(this.a.b().j());
                if (this.a.b().f1994f != null) {
                    for (Map.Entry<String, byte[]> entry : this.a.b().f1994f.entrySet()) {
                        String key = entry.getKey();
                        byte[] value = entry.getValue();
                        if (value != null) {
                            ((PostMultiPartFormRequest.PostMultiPartFormRequestBuilder) this.f1975b).addBytes(key, "file", "application/octet-stream", value);
                        }
                    }
                }
            }
            return 0;
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.adp.lib.network.http.IHttpNet
    public void connect() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
        }
    }

    @Override // com.baidu.adp.lib.network.http.IHttpNet
    public URL d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return null;
        }
        return (URL) invokeV.objValue;
    }

    @Override // com.baidu.adp.lib.network.http.IHttpNet
    public void disconnect() {
        RequestCall requestCall;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048581, this) == null) || (requestCall = this.f1976c) == null) {
            return;
        }
        requestCall.cancel();
    }

    @Override // com.baidu.adp.lib.network.http.IHttpNet
    public void e(URL url) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, url) == null) {
        }
    }

    @Override // com.baidu.adp.lib.network.http.IHttpNet
    public byte[] execute() throws RequestCallException, IOException {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            RequestCall makeRequestCall = this.f1975b.build().makeRequestCall();
            this.f1976c = makeRequestCall;
            Response executeSync = makeRequestCall.executeSync();
            this.f1977d = executeSync;
            if (executeSync == null || executeSync.body() == null) {
                return null;
            }
            return this.f1977d.body().bytes();
        }
        return (byte[]) invokeV.objValue;
    }

    @Override // com.baidu.adp.lib.network.http.IHttpNet
    public void f() {
        Request.Builder<?> builder;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) || (builder = this.f1975b) == null) {
            return;
        }
        builder.addHeaders(this.a.b().h());
    }

    @Override // com.baidu.adp.lib.network.http.IHttpNet
    public void g(URL url, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048585, this, url, z) == null) {
        }
    }

    @Override // com.baidu.adp.lib.network.http.IHttpNet
    public String getContentEncoding() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            Response response = this.f1977d;
            return (response == null || response.headers() == null) ? "" : this.f1977d.headers().get(Headers.CONTENT_ENCODING);
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.adp.lib.network.http.IHttpNet
    public long getContentLength() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            Response response = this.f1977d;
            if (response == null || response.body() == null) {
                return 0L;
            }
            return this.f1977d.body().contentLength();
        }
        return invokeV.longValue;
    }

    @Override // com.baidu.adp.lib.network.http.IHttpNet
    public String getContentType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            Response response = this.f1977d;
            return (response == null || response.body() == null || this.f1977d.body().contentType() == null) ? "" : this.f1977d.body().contentType().toString();
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.adp.lib.network.http.IHttpNet
    public int getResponseCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            Response response = this.f1977d;
            if (response == null) {
                return 0;
            }
            return response.code();
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.adp.lib.network.http.IHttpNet
    public void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
        }
    }
}
