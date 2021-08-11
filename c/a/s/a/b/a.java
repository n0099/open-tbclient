package c.a.s.a.b;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import android.webkit.WebSettings;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import okhttp3.Headers;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
/* loaded from: classes4.dex */
public class a {
    public static /* synthetic */ Interceptable $ic = null;

    /* renamed from: c  reason: collision with root package name */
    public static volatile a f29634c = null;

    /* renamed from: d  reason: collision with root package name */
    public static int f29635d = 1;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final OkHttpClient f29636a;

    /* renamed from: b  reason: collision with root package name */
    public Context f29637b;

    /* renamed from: c.a.s.a.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class RunnableC1384a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f29638e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ byte[] f29639f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ c f29640g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ a f29641h;

        public RunnableC1384a(a aVar, b bVar, byte[] bArr, c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, bVar, bArr, cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f29641h = aVar;
            this.f29638e = bVar;
            this.f29639f = bArr;
            this.f29640g = cVar;
        }

        @Override // java.lang.Runnable
        public final void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f29641h.e(this.f29638e.b(), this.f29638e.a(), this.f29639f, this.f29638e.d(), this.f29638e.c(), this.f29640g);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-273700809, "Lc/a/s/a/b/a;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-273700809, "Lc/a/s/a/b/a;");
        }
    }

    public a(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f29636a = new OkHttpClient.Builder().connectTimeout(30L, TimeUnit.SECONDS).readTimeout(30L, TimeUnit.SECONDS).build();
        this.f29637b = context;
    }

    public static a a(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, context)) == null) {
            if (f29634c == null) {
                synchronized (a.class) {
                    if (f29634c == null) {
                        f29634c = new a(context);
                    }
                }
            }
            return f29634c;
        }
        return (a) invokeL.objValue;
    }

    public static Headers c(Map<String, String> map) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, map)) == null) {
            try {
                Headers.Builder builder = new Headers.Builder();
                if (map != null && map.size() > 0) {
                    for (String str : map.keySet()) {
                        String str2 = str.toString();
                        builder.add(str2, map.get(str2));
                    }
                }
                return builder.build();
            } catch (Exception e2) {
                e2.printStackTrace();
                return null;
            }
        }
        return (Headers) invokeL.objValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0024  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final String b() {
        InterceptResult invokeV;
        String defaultUserAgent;
        int length;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            if (Build.VERSION.SDK_INT >= 17) {
                try {
                    defaultUserAgent = WebSettings.getDefaultUserAgent(this.f29637b);
                } catch (Exception unused) {
                }
                StringBuffer stringBuffer = new StringBuffer();
                length = defaultUserAgent.length();
                for (i2 = 0; i2 < length; i2++) {
                    char charAt = defaultUserAgent.charAt(i2);
                    if (charAt <= 31 || charAt >= 127) {
                        stringBuffer.append(String.format("\\u%04x", Integer.valueOf(charAt)));
                    } else {
                        stringBuffer.append(charAt);
                    }
                }
                c.a.s.a.e.c.a("HttpExecutor", "getUserAgent:" + stringBuffer.toString());
                return stringBuffer.toString();
            }
            defaultUserAgent = System.getProperty("http.agent");
            StringBuffer stringBuffer2 = new StringBuffer();
            length = defaultUserAgent.length();
            while (i2 < length) {
            }
            c.a.s.a.e.c.a("HttpExecutor", "getUserAgent:" + stringBuffer2.toString());
            return stringBuffer2.toString();
        }
        return (String) invokeV.objValue;
    }

    public final void e(String str, String str2, byte[] bArr, Map<String, String> map, String str3, c cVar) {
        Request.Builder addHeader;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{str, str2, bArr, map, str3, cVar}) == null) {
            try {
                if ("POST".equals(str)) {
                    if (TextUtils.isEmpty(str3)) {
                        str3 = "application/x-www-form-urlencoded";
                    }
                    addHeader = new Request.Builder().url(str2).headers(c(map)).removeHeader("User-Agent").addHeader("User-Agent", b()).post(RequestBody.create(MediaType.parse(str3), bArr));
                } else {
                    addHeader = new Request.Builder().url(str2).headers(c(map)).removeHeader("User-Agent").addHeader("User-Agent", b());
                }
                Response execute = this.f29636a.newCall(addHeader.build()).execute();
                byte[] bytes = execute.body().bytes();
                c.a.s.a.e.c.c("HttpExecutor", "requestUrl:" + str2 + "\nrequest method: " + str + "\nrequest contentType: " + str3 + "\nresponse : " + new String(bytes));
                cVar.a(execute.code(), bytes);
            } catch (Exception e2) {
                e2.printStackTrace();
                if (cVar != null) {
                    cVar.b(f29635d, "Http Unknown exception".getBytes());
                }
            }
        }
    }
}
