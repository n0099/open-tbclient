package com.baidu.android.pushservice.y;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.pushservice.a0.i;
import com.baidu.android.pushservice.e;
import com.baidu.android.pushservice.pull.ClientEventInfo;
import com.baidu.android.pushservice.util.Utility;
import com.baidu.android.pushservice.w.h;
import com.baidu.android.pushservice.y.e.f;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.ConnectionPool;
import okhttp3.Headers;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Protocol;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import org.apache.http.protocol.HTTP;
/* loaded from: classes.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public static a c;
    public transient /* synthetic */ FieldHolder $fh;
    public Context a;
    public OkHttpClient b;

    /* renamed from: com.baidu.android.pushservice.y.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0042a implements Callback {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ClientEventInfo a;
        public final /* synthetic */ a b;

        public C0042a(a aVar, ClientEventInfo clientEventInfo) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, clientEventInfo};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = aVar;
            this.a = clientEventInfo;
        }

        @Override // okhttp3.Callback
        public void onFailure(Call call, IOException iOException) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, call, iOException) == null) {
                String str = "Request error :" + iOException.getMessage();
                Utility.a(this.b.a, this.a, false);
            }
        }

        @Override // okhttp3.Callback
        public void onResponse(Call call, Response response) throws IOException {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, call, response) == null) {
                try {
                    if (response.body() != null) {
                        this.b.a(response.body().bytes(), this.a);
                    } else {
                        Utility.a(this.b.a, this.a, false);
                    }
                } catch (Exception unused) {
                    Utility.a(this.b.a, this.a, false);
                }
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-676423374, "Lcom/baidu/android/pushservice/y/a;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-676423374, "Lcom/baidu/android/pushservice/y/a;");
        }
    }

    public a(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = context;
        this.b = a();
    }

    public static a a(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, context)) == null) {
            if (c == null) {
                c = new a(context);
            }
            return c;
        }
        return (a) invokeL.objValue;
    }

    public final Headers a(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048576, this, z)) == null) {
            HashMap hashMap = new HashMap();
            hashMap.put(HTTP.CONN_DIRECTIVE, HTTP.CONN_KEEP_ALIVE);
            hashMap.put("Content-Type", "application/proto");
            String c2 = i.c(this.a, "com.baidu.android.pushservice.USER_ACCESS_TOKEN");
            if (z && !TextUtils.isEmpty(c2)) {
                hashMap.put("cookie", "BDUSS=" + c2);
            }
            return com.baidu.android.pushservice.q.a.a(hashMap);
        }
        return (Headers) invokeZ.objValue;
    }

    public final OkHttpClient a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? new OkHttpClient.Builder().protocols(Arrays.asList(Protocol.HTTP_2, Protocol.HTTP_1_1)).pingInterval(1000L, TimeUnit.MILLISECONDS).connectTimeout(30L, TimeUnit.SECONDS).readTimeout(30L, TimeUnit.SECONDS).writeTimeout(30L, TimeUnit.SECONDS).connectionPool(new ConnectionPool()).build() : (OkHttpClient) invokeV.objValue;
    }

    public final Request a(byte[] bArr, String str, boolean z) {
        InterceptResult invokeLLZ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLZ = interceptable.invokeLLZ(Constants.METHOD_SEND_USER_MSG, this, bArr, str, z)) == null) ? new Request.Builder().url(str).post(a(bArr)).headers(a(z)).build() : (Request) invokeLLZ.objValue;
    }

    public final RequestBody a(byte[] bArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, bArr)) == null) ? RequestBody.create(MediaType.parse("application/proto"), bArr) : (RequestBody) invokeL.objValue;
    }

    public final void a(byte[] bArr, ClientEventInfo clientEventInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048580, this, bArr, clientEventInfo) == null) {
            try {
                f a = f.a(bArr);
                c.a(this.a, a.j());
                c.a(this.a, a.a());
                c.a(this.a, a.j().a());
                if (a.h() == h.i.a() && a.k() == 3 && a.g().size() > 0) {
                    new b(this.a).a(com.baidu.android.pushservice.y.e.i.a(a.g()));
                }
                if (a.n() && a.d().d() && a.d().c() == 1) {
                    Utility.a(this.a, clientEventInfo, false);
                }
                if (clientEventInfo.getHasConfirmDialog() == -1 || c.g(this.a) != 3) {
                    return;
                }
                Intent j = e.j(this.a);
                j.putExtra("push_start_source", clientEventInfo.getSource());
                this.a.sendBroadcast(j);
            } catch (Exception unused) {
                Utility.a(this.a, clientEventInfo, false);
            }
        }
    }

    public void a(byte[] bArr, String str, ClientEventInfo clientEventInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048581, this, bArr, str, clientEventInfo) == null) {
            this.b.newCall(a(bArr, str, true)).enqueue(new C0042a(this, clientEventInfo));
        }
    }

    public void a(byte[] bArr, String str, Callback callback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048582, this, bArr, str, callback) == null) {
            this.b.newCall(a(bArr, str, false)).enqueue(callback);
        }
    }
}
