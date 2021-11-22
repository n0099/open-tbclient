package b.a.p0.a.h0.o.g.f;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import b.a.p0.a.h0.o.g.f.e;
import b.a.p0.a.h0.o.g.f.h;
import b.a.p0.a.z2.q0;
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
public class c extends b.a.p0.a.h0.o.g.f.a implements b.a.p0.a.h0.o.g.d.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b  reason: collision with root package name */
    public b.a.p0.a.h0.o.g.c.b.a f5964b;

    /* renamed from: c  reason: collision with root package name */
    public b.a.p0.a.h0.o.g.b.a f5965c;

    /* renamed from: d  reason: collision with root package name */
    public File f5966d;

    /* renamed from: e  reason: collision with root package name */
    public b f5967e;

    /* loaded from: classes.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f5968e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f5969f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ String f5970g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ c f5971h;

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
            this.f5971h = cVar;
            this.f5968e = str;
            this.f5969f = i2;
            this.f5970g = str2;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f5971h.f5967e.onError(this.f5968e, this.f5969f, this.f5970g);
            }
        }
    }

    /* loaded from: classes.dex */
    public interface b {
        void onError(String str, int i2, String str2);
    }

    /* renamed from: b.a.p0.a.h0.o.g.f.c$c  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0249c implements e.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public b.a.p0.a.h0.o.g.b.a f5972a;

        /* renamed from: b  reason: collision with root package name */
        public String f5973b;

        /* renamed from: b.a.p0.a.h0.o.g.f.c$c$a */
        /* loaded from: classes.dex */
        public class a implements b.a.p0.a.h0.o.g.b.b {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ File f5974a;

            public a(C0249c c0249c, File file) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {c0249c, file};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f5974a = file;
            }

            @Override // b.a.p0.a.h0.o.g.b.b
            public void a() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    b.a.p0.w.d.L(this.f5974a);
                }
            }
        }

        public C0249c(c cVar, b.a.p0.a.h0.o.g.b.a aVar, String str) {
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
            this.f5972a = aVar;
            this.f5973b = str;
        }

        @Override // b.a.p0.a.h0.o.g.f.e.a
        public void a(File file) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, file) == null) {
                try {
                    this.f5972a.a(this.f5973b, file, new a(this, file));
                } catch (Exception e2) {
                    if (b.a.p0.a.h0.o.g.d.a.f5954a) {
                        Log.getStackTraceString(e2);
                    }
                }
            }
        }

        @Override // b.a.p0.a.h0.o.g.f.e.a
        public void b(File file) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, file) == null) && b.a.p0.a.h0.o.g.d.a.f5954a) {
                String str = "writer file fail, file = " + file;
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(@NonNull Context context, b.a.p0.a.h0.o.g.b.a aVar) {
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
                super((Context) objArr2[0], (b.a.p0.a.h0.o.g.b.a) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f5964b = b.a.p0.a.h0.o.g.c.a.a().f();
        this.f5966d = new File(b.a.p0.a.h0.o.g.c.a.a().b(), "image_temp");
        this.f5965c = aVar;
        if (aVar == null) {
            h(context);
        }
    }

    @Override // b.a.p0.a.h0.o.g.f.h
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
            b.a.p0.a.h0.o.g.b.a aVar2 = this.f5965c;
            if (aVar2 != null && !aVar2.isClosed()) {
                inputStream = this.f5965c.get(f2);
            }
            if (inputStream != null) {
                if (b.a.p0.a.h0.o.g.d.a.f5954a) {
                    String str = "adopt cached image, url = " + f2;
                }
                return new WebResourceResponse(aVar.getMimeType(), "UTF-8", inputStream);
            }
            b.a.p0.a.h0.o.g.f.b a2 = f.a(f2, g(aVar));
            if (a2 != null && (i2 = a2.f5958a) >= 400 && this.f5967e != null) {
                d(f2, i2, a2.f5959b);
            }
            WebResourceResponse c2 = c(a2);
            if (c2 != null && c2.getData() != null) {
                c2.setData(new g(c2.getData(), new e(new File(this.f5966d, b.a.p0.a.h0.o.g.c.a.a().d().a(f2)), new C0249c(this, this.f5965c, f2))));
            }
            if (b.a.p0.a.h0.o.g.d.a.f5954a) {
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

    public final WebResourceResponse c(b.a.p0.a.h0.o.g.f.b bVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bVar)) == null) {
            if (bVar == null) {
                return null;
            }
            String str = bVar.f5962e;
            if (str != null && str.toLowerCase().contains("html")) {
                bVar.f5962e = SapiWebView.DATA_MIME_TYPE;
                bVar.f5961d = "UTF-8";
            }
            if (b.a.p0.a.z2.d.f()) {
                return new WebResourceResponse(bVar.f5962e, bVar.f5961d, bVar.f5958a, bVar.f5959b, bVar.f5960c, bVar.f5963f);
            }
            return new WebResourceResponse(bVar.f5962e, "UTF-8", bVar.f5963f);
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
            if (b.a.p0.a.h0.o.g.d.a.f5954a) {
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
            String f2 = b.a.p0.a.p2.b.l().f(f(aVar.d()), requestHeaders.get("Cookie"));
            if (!TextUtils.isEmpty(f2)) {
                requestHeaders.put("Cookie", f2);
                if (b.a.p0.a.h0.o.g.d.a.f5954a) {
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
            File b2 = b.a.p0.a.h0.o.g.c.a.a().b();
            String e2 = e();
            if (!TextUtils.isEmpty(e2)) {
                b2 = new File(b2, e2);
            }
            if (b.a.p0.a.h0.o.g.d.a.f5954a) {
                String str = "init default disk cache provider, path = " + b2;
            }
            b.a.p0.w.d.l(b2);
            this.f5965c = b.a.p0.a.c1.a.U().b(context, b2, b.a.p0.a.h0.o.g.c.a.a().g());
        }
    }

    public boolean i(@NonNull h.a aVar) {
        InterceptResult invokeL;
        Map<String, String> requestHeaders;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, aVar)) == null) {
            if (aVar.c()) {
                return this.f5964b.a(aVar) && (requestHeaders = aVar.getRequestHeaders()) != null && requestHeaders.containsKey("Accept") && (str = requestHeaders.get("Accept")) != null && str.startsWith("image");
            }
            return true;
        }
        return invokeL.booleanValue;
    }
}
