package c.a.r0.a.h0.o.g.f;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import c.a.r0.a.h0.o.g.f.e;
import c.a.r0.a.h0.o.g.f.h;
import c.a.r0.a.z2.q0;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.sapi2.SapiWebView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.webkit.sdk.WebResourceResponse;
import java.io.File;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes.dex */
public class c extends c.a.r0.a.h0.o.g.f.a implements c.a.r0.a.h0.o.g.d.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b  reason: collision with root package name */
    public c.a.r0.a.h0.o.g.c.b.a f6916b;

    /* renamed from: c  reason: collision with root package name */
    public c.a.r0.a.h0.o.g.b.a f6917c;

    /* renamed from: d  reason: collision with root package name */
    public File f6918d;

    /* renamed from: e  reason: collision with root package name */
    public b f6919e;

    /* loaded from: classes.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f6920e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f6921f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ String f6922g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ c f6923h;

        public a(c cVar, String str, int i2, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar, str, Integer.valueOf(i2), str2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f6923h = cVar;
            this.f6920e = str;
            this.f6921f = i2;
            this.f6922g = str2;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f6923h.f6919e.onError(this.f6920e, this.f6921f, this.f6922g);
            }
        }
    }

    /* loaded from: classes.dex */
    public interface b {
        void onError(String str, int i2, String str2);
    }

    /* renamed from: c.a.r0.a.h0.o.g.f.c$c  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0407c implements e.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public c.a.r0.a.h0.o.g.b.a a;

        /* renamed from: b  reason: collision with root package name */
        public String f6924b;

        /* renamed from: c.a.r0.a.h0.o.g.f.c$c$a */
        /* loaded from: classes.dex */
        public class a implements c.a.r0.a.h0.o.g.b.b {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ File a;

            public a(C0407c c0407c, File file) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {c0407c, file};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = file;
            }

            @Override // c.a.r0.a.h0.o.g.b.b
            public void a() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    c.a.r0.w.d.L(this.a);
                }
            }
        }

        public C0407c(c cVar, c.a.r0.a.h0.o.g.b.a aVar, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar, aVar, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = aVar;
            this.f6924b = str;
        }

        @Override // c.a.r0.a.h0.o.g.f.e.a
        public void a(File file) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, file) == null) {
                try {
                    this.a.a(this.f6924b, file, new a(this, file));
                } catch (Exception e2) {
                    if (c.a.r0.a.h0.o.g.d.a.a) {
                        Log.getStackTraceString(e2);
                    }
                }
            }
        }

        @Override // c.a.r0.a.h0.o.g.f.e.a
        public void b(File file) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, file) == null) && c.a.r0.a.h0.o.g.d.a.a) {
                String str = "writer file fail, file = " + file;
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(@NonNull Context context, c.a.r0.a.h0.o.g.b.a aVar) {
        super(context, aVar);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, aVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (c.a.r0.a.h0.o.g.b.a) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f6916b = c.a.r0.a.h0.o.g.c.a.a().f();
        this.f6918d = new File(c.a.r0.a.h0.o.g.c.a.a().b(), "image_temp");
        this.f6917c = aVar;
        if (aVar == null) {
            h(context);
        }
    }

    @Override // c.a.r0.a.h0.o.g.f.h
    public WebResourceResponse a(@NonNull h.a aVar) {
        InterceptResult invokeL;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, aVar)) == null) {
            String d2 = aVar.d();
            if (!i(aVar)) {
                return aVar.b(d2, aVar.getRequestHeaders(), aVar.c());
            }
            String f2 = f(d2);
            InputStream inputStream = null;
            c.a.r0.a.h0.o.g.b.a aVar2 = this.f6917c;
            if (aVar2 != null && !aVar2.isClosed()) {
                inputStream = this.f6917c.get(f2);
            }
            if (inputStream != null) {
                if (c.a.r0.a.h0.o.g.d.a.a) {
                    String str = "adopt cached image, url = " + f2;
                }
                return new WebResourceResponse(aVar.getMimeType(), "UTF-8", inputStream);
            }
            c.a.r0.a.h0.o.g.f.b a2 = f.a(f2, g(aVar));
            if (a2 != null && (i2 = a2.a) >= 400 && this.f6919e != null) {
                d(f2, i2, a2.f6911b);
            }
            WebResourceResponse c2 = c(a2);
            if (c2 != null && c2.getData() != null) {
                c2.setData(new g(c2.getData(), new e(new File(this.f6918d, c.a.r0.a.h0.o.g.c.a.a().d().a(f2)), new C0407c(this, this.f6917c, f2))));
            }
            if (c.a.r0.a.h0.o.g.d.a.a) {
                StringBuilder sb = new StringBuilder();
                sb.append("download image, response = ");
                sb.append(c2 != null);
                sb.append(" ; url = ");
                sb.append(f2);
                sb.toString();
            }
            return c2;
        }
        return (WebResourceResponse) invokeL.objValue;
    }

    public final WebResourceResponse c(c.a.r0.a.h0.o.g.f.b bVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bVar)) == null) {
            if (bVar == null) {
                return null;
            }
            String str = bVar.f6914e;
            if (str != null && str.toLowerCase().contains("html")) {
                bVar.f6914e = SapiWebView.DATA_MIME_TYPE;
                bVar.f6913d = "UTF-8";
            }
            if (c.a.r0.a.z2.d.f()) {
                return new WebResourceResponse(bVar.f6914e, bVar.f6913d, bVar.a, bVar.f6911b, bVar.f6912c, bVar.f6915f);
            }
            return new WebResourceResponse(bVar.f6914e, "UTF-8", bVar.f6915f);
        }
        return (WebResourceResponse) invokeL.objValue;
    }

    public final void d(String str, int i2, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(Constants.METHOD_SEND_USER_MSG, this, str, i2, str2) == null) {
            q0.q().post(new a(this, str, i2, str2));
        }
    }

    public String e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? "image" : (String) invokeV.objValue;
    }

    public String f(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return str;
            }
            if (str.startsWith("intercept") && str.length() > 9) {
                str = str.substring(9);
            }
            if (c.a.r0.a.h0.o.g.d.a.a) {
                String str2 = "remote request url = " + str;
            }
            return str;
        }
        return (String) invokeL.objValue;
    }

    public Map<String, String> g(@NonNull h.a aVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, aVar)) == null) {
            Map<String, String> requestHeaders = aVar.getRequestHeaders();
            if (requestHeaders == null) {
                requestHeaders = new HashMap<>();
            }
            String f2 = c.a.r0.a.p2.b.l().f(f(aVar.d()), requestHeaders.get("Cookie"));
            if (!TextUtils.isEmpty(f2)) {
                requestHeaders.put("Cookie", f2);
                if (c.a.r0.a.h0.o.g.d.a.a) {
                    String str = "addCookiesToHeader cookie: " + f2;
                }
            }
            return requestHeaders;
        }
        return (Map) invokeL.objValue;
    }

    public final void h(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, context) == null) {
            File b2 = c.a.r0.a.h0.o.g.c.a.a().b();
            String e2 = e();
            if (!TextUtils.isEmpty(e2)) {
                b2 = new File(b2, e2);
            }
            if (c.a.r0.a.h0.o.g.d.a.a) {
                String str = "init default disk cache provider, path = " + b2;
            }
            c.a.r0.w.d.l(b2);
            this.f6917c = c.a.r0.a.c1.a.U().b(context, b2, c.a.r0.a.h0.o.g.c.a.a().g());
        }
    }

    public boolean i(@NonNull h.a aVar) {
        InterceptResult invokeL;
        Map<String, String> requestHeaders;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, aVar)) == null) {
            if (aVar.c()) {
                return this.f6916b.a(aVar) && (requestHeaders = aVar.getRequestHeaders()) != null && requestHeaders.containsKey("Accept") && (str = requestHeaders.get("Accept")) != null && str.startsWith("image");
            }
            return true;
        }
        return invokeL.booleanValue;
    }
}
