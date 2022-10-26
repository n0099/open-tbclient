package com.baidu.android.pushservice.d;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import okhttp3.Headers;
import okhttp3.Interceptor;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
/* loaded from: classes.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public static volatile a a;
    public transient /* synthetic */ FieldHolder $fh;
    public final OkHttpClient b;

    /* renamed from: com.baidu.android.pushservice.d.a$1  reason: invalid class name */
    /* loaded from: classes.dex */
    public /* synthetic */ class AnonymousClass1 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* renamed from: com.baidu.android.pushservice.d.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0020a implements Interceptor {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ a a;

        public C0020a(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = aVar;
        }

        public /* synthetic */ C0020a(a aVar, AnonymousClass1 anonymousClass1) {
            this(aVar);
        }

        @Override // okhttp3.Interceptor
        public Response intercept(Interceptor.Chain chain) throws IOException {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, chain)) == null) {
                try {
                    Request request = chain.request();
                    System.currentTimeMillis();
                    Response proceed = chain.proceed(request);
                    System.currentTimeMillis();
                    return proceed;
                } catch (Exception unused) {
                    return chain.proceed(chain.request());
                }
            }
            return (Response) invokeL.objValue;
        }
    }

    public a() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.b = new OkHttpClient.Builder().addInterceptor(new C0020a(this, null)).connectTimeout(15L, TimeUnit.SECONDS).readTimeout(15L, TimeUnit.SECONDS).build();
    }

    public static a a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            if (a == null) {
                synchronized (a.class) {
                    if (a == null) {
                        a = new a();
                    }
                }
            }
            return a;
        }
        return (a) invokeV.objValue;
    }

    public static Headers a(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, str, str2)) == null) {
            try {
                Headers.Builder builder = new Headers.Builder();
                if (!TextUtils.isEmpty(str)) {
                    builder.add("User-Agent", str);
                }
                if (!TextUtils.isEmpty(str2)) {
                    builder.add("Host", str2);
                }
                return builder.build();
            } catch (Exception unused) {
                return null;
            }
        }
        return (Headers) invokeLL.objValue;
    }

    public static Headers a(HashMap hashMap) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, hashMap)) == null) {
            if (hashMap == null || hashMap.isEmpty()) {
                return new Headers.Builder().build();
            }
            try {
                Headers.Builder builder = new Headers.Builder();
                for (Map.Entry entry : hashMap.entrySet()) {
                    builder.add((String) entry.getKey(), (String) entry.getValue());
                }
                return builder.build();
            } catch (Exception unused) {
                return null;
            }
        }
        return (Headers) invokeL.objValue;
    }

    public Bitmap a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            try {
                return BitmapFactory.decodeStream(this.b.newCall(new Request.Builder().url(str).build()).execute().body().byteStream());
            } catch (Exception unused) {
                return null;
            }
        }
        return (Bitmap) invokeL.objValue;
    }

    public b a(String str, String str2, String str3, HashMap hashMap, String str4) {
        InterceptResult invokeLLLLL;
        Request.Builder headers;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLLL = interceptable.invokeLLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, str2, str3, hashMap, str4)) == null) {
            b bVar = new b();
            try {
                if ("POST".equalsIgnoreCase(str2)) {
                    headers = new Request.Builder().url(str).headers(a(hashMap)).post(RequestBody.create(MediaType.parse(str4), str3));
                } else {
                    if (!TextUtils.isEmpty(str3) && str4.equals("application/x-www-form-urlencoded")) {
                        str = str + "?" + str3;
                    }
                    headers = new Request.Builder().url(str).headers(a(hashMap));
                }
                Response execute = this.b.newCall(headers.build()).execute();
                bVar.a(execute.code());
                bVar.a(execute.body().byteStream());
            } catch (IOException | Exception unused) {
            }
            return bVar;
        }
        return (b) invokeLLLLL.objValue;
    }

    public b a(String str, String str2, HashMap hashMap, String str3, String str4) {
        InterceptResult invokeLLLLL;
        Request.Builder headers;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLLL = interceptable.invokeLLLLL(Constants.METHOD_SEND_USER_MSG, this, str, str2, hashMap, str3, str4)) == null) {
            b bVar = new b();
            try {
                if ("POST".equalsIgnoreCase(str2)) {
                    headers = new Request.Builder().url(str).headers(a(str3, str4)).post(RequestBody.create(MediaType.parse("application/x-www-form-urlencoded"), c.a(hashMap)));
                } else {
                    if (hashMap != null && hashMap.size() > 0) {
                        str = str + "?" + c.a(hashMap);
                    }
                    headers = new Request.Builder().url(str).headers(a(str3, str4));
                }
                Response execute = this.b.newCall(headers.build()).execute();
                bVar.a(execute.code());
                bVar.a(execute.body().byteStream());
            } catch (IOException | Exception unused) {
            }
            return bVar;
        }
        return (b) invokeLLLLL.objValue;
    }
}
