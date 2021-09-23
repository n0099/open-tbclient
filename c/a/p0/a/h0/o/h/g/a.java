package c.a.p0.a.h0.o.h.g;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import c.a.p0.a.h0.o.h.g.d;
import c.a.p0.a.v2.q0;
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
import java.util.Map;
/* loaded from: classes.dex */
public abstract class a implements c.a.p0.a.h0.o.h.e.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b  reason: collision with root package name */
    public c.a.p0.a.h0.o.h.c.a f6334b;

    /* renamed from: c  reason: collision with root package name */
    public File f6335c;

    /* renamed from: d  reason: collision with root package name */
    public b f6336d;

    /* renamed from: c.a.p0.a.h0.o.h.g.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class RunnableC0243a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f6337e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f6338f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ String f6339g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ a f6340h;

        public RunnableC0243a(a aVar, String str, int i2, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, str, Integer.valueOf(i2), str2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f6340h = aVar;
            this.f6337e = str;
            this.f6338f = i2;
            this.f6339g = str2;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f6340h.f6336d.onError(this.f6337e, this.f6338f, this.f6339g);
            }
        }
    }

    /* loaded from: classes.dex */
    public interface b {
        void onError(String str, int i2, String str2);
    }

    /* loaded from: classes.dex */
    public class c implements d.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public c.a.p0.a.h0.o.h.c.a f6341a;

        /* renamed from: b  reason: collision with root package name */
        public String f6342b;

        /* renamed from: c.a.p0.a.h0.o.h.g.a$c$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public class C0244a implements c.a.p0.a.h0.o.h.c.b {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ File f6343a;

            public C0244a(c cVar, File file) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {cVar, file};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f6343a = file;
            }

            @Override // c.a.p0.a.h0.o.h.c.b
            public void a() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    c.a.p0.t.d.K(this.f6343a);
                }
            }
        }

        public c(a aVar, c.a.p0.a.h0.o.h.c.a aVar2, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, aVar2, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f6341a = aVar2;
            this.f6342b = str;
        }

        @Override // c.a.p0.a.h0.o.h.g.d.a
        public void a(File file) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, file) == null) {
                try {
                    this.f6341a.a(this.f6342b, file, new C0244a(this, file));
                } catch (Exception e2) {
                    if (c.a.p0.a.h0.o.h.e.a.f6330a) {
                        Log.getStackTraceString(e2);
                    }
                }
            }
        }

        @Override // c.a.p0.a.h0.o.h.g.d.a
        public void b(File file) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, file) == null) && c.a.p0.a.h0.o.h.e.a.f6330a) {
                String str = "writer file fail, file = " + file;
            }
        }
    }

    public a(@NonNull Context context, c.a.p0.a.h0.o.h.c.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, aVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f6335c = new File(c.a.p0.a.h0.o.h.d.a.a().b(), "image_temp");
        this.f6334b = aVar;
        if (aVar == null) {
            g(context);
        }
    }

    public final WebResourceResponse b(c.a.p0.a.h0.o.h.g.b bVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, bVar)) == null) {
            if (bVar == null) {
                return null;
            }
            String str = bVar.f6348e;
            if (str != null && str.toLowerCase().contains("html")) {
                bVar.f6348e = SapiWebView.DATA_MIME_TYPE;
                bVar.f6347d = "UTF-8";
            }
            if (c.a.p0.a.v2.d.f()) {
                return new WebResourceResponse(bVar.f6348e, bVar.f6347d, bVar.f6344a, bVar.f6345b, bVar.f6346c, bVar.f6349f);
            }
            return new WebResourceResponse(bVar.f6348e, "UTF-8", bVar.f6349f);
        }
        return (WebResourceResponse) invokeL.objValue;
    }

    public final void c(String str, int i2, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, i2, str2) == null) {
            q0.q().post(new RunnableC0243a(this, str, i2, str2));
        }
    }

    public String d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? "" : (String) invokeV.objValue;
    }

    public String e(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return str;
            }
            if (str.startsWith("intercept") && str.length() > 9) {
                str = str.substring(9);
            }
            if (c.a.p0.a.h0.o.h.e.a.f6330a) {
                String str2 = "real request url = " + str;
            }
            return str;
        }
        return (String) invokeL.objValue;
    }

    public Map<String, String> f(@NonNull g gVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, gVar)) == null) ? gVar.getRequestHeaders() : (Map) invokeL.objValue;
    }

    public final void g(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, context) == null) {
            File b2 = c.a.p0.a.h0.o.h.d.a.a().b();
            String d2 = d();
            if (!TextUtils.isEmpty(d2)) {
                b2 = new File(b2, d2);
            }
            if (c.a.p0.a.h0.o.h.e.a.f6330a) {
                String str = "init default disk cache provider, path = " + b2;
            }
            c.a.p0.t.d.k(b2);
            this.f6334b = c.a.p0.a.c1.a.P().b(context, b2, c.a.p0.a.h0.o.h.d.a.a().g());
        }
    }

    public WebResourceResponse h(@NonNull g gVar) {
        InterceptResult invokeL;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, gVar)) == null) {
            String d2 = gVar.d();
            if (!i(gVar)) {
                return gVar.b(d2, gVar.getRequestHeaders(), gVar.c());
            }
            String e2 = e(d2);
            InputStream inputStream = null;
            c.a.p0.a.h0.o.h.c.a aVar = this.f6334b;
            if (aVar != null && !aVar.isClosed()) {
                inputStream = this.f6334b.get(e2);
            }
            if (inputStream != null) {
                if (c.a.p0.a.h0.o.h.e.a.f6330a) {
                    String str = "adopt cached image, url = " + e2;
                }
                return new WebResourceResponse(gVar.getMimeType(), "UTF-8", inputStream);
            }
            c.a.p0.a.h0.o.h.g.b a2 = e.a(e2, f(gVar));
            if (a2 != null && (i2 = a2.f6344a) >= 400 && this.f6336d != null) {
                c(e2, i2, a2.f6345b);
            }
            WebResourceResponse b2 = b(a2);
            if (b2 != null && b2.getData() != null) {
                b2.setData(new f(b2.getData(), new d(new File(this.f6335c, c.a.p0.a.h0.o.h.d.a.a().d().a(e2)), new c(this, this.f6334b, e2))));
            }
            if (c.a.p0.a.h0.o.h.e.a.f6330a) {
                StringBuilder sb = new StringBuilder();
                sb.append("download image, response = ");
                sb.append(b2 != null);
                sb.append(" ; url = ");
                sb.append(e2);
                sb.toString();
            }
            return b2;
        }
        return (WebResourceResponse) invokeL.objValue;
    }

    public abstract boolean i(@NonNull g gVar);
}
