package c.a.n0.a.h0.o.h.g;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import c.a.n0.a.h0.o.h.g.d;
import c.a.n0.a.v2.q0;
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
public abstract class a implements c.a.n0.a.h0.o.h.e.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: b  reason: collision with root package name */
    public c.a.n0.a.h0.o.h.c.a f6052b;

    /* renamed from: c  reason: collision with root package name */
    public File f6053c;

    /* renamed from: d  reason: collision with root package name */
    public b f6054d;

    /* renamed from: c.a.n0.a.h0.o.h.g.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class RunnableC0233a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f6055e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f6056f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ String f6057g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ a f6058h;

        public RunnableC0233a(a aVar, String str, int i2, String str2) {
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
            this.f6058h = aVar;
            this.f6055e = str;
            this.f6056f = i2;
            this.f6057g = str2;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f6058h.f6054d.onError(this.f6055e, this.f6056f, this.f6057g);
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
        public c.a.n0.a.h0.o.h.c.a f6059a;

        /* renamed from: b  reason: collision with root package name */
        public String f6060b;

        /* renamed from: c.a.n0.a.h0.o.h.g.a$c$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public class C0234a implements c.a.n0.a.h0.o.h.c.b {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ File f6061a;

            public C0234a(c cVar, File file) {
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
                this.f6061a = file;
            }

            @Override // c.a.n0.a.h0.o.h.c.b
            public void a() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    c.a.n0.t.d.K(this.f6061a);
                }
            }
        }

        public c(a aVar, c.a.n0.a.h0.o.h.c.a aVar2, String str) {
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
            this.f6059a = aVar2;
            this.f6060b = str;
        }

        @Override // c.a.n0.a.h0.o.h.g.d.a
        public void a(File file) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, file) == null) {
                try {
                    this.f6059a.a(this.f6060b, file, new C0234a(this, file));
                } catch (Exception e2) {
                    if (c.a.n0.a.h0.o.h.e.a.f6048a) {
                        Log.getStackTraceString(e2);
                    }
                }
            }
        }

        @Override // c.a.n0.a.h0.o.h.g.d.a
        public void b(File file) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, file) == null) && c.a.n0.a.h0.o.h.e.a.f6048a) {
                String str = "writer file fail, file = " + file;
            }
        }
    }

    public a(@NonNull Context context, c.a.n0.a.h0.o.h.c.a aVar) {
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
        this.f6053c = new File(c.a.n0.a.h0.o.h.d.a.a().b(), "image_temp");
        this.f6052b = aVar;
        if (aVar == null) {
            g(context);
        }
    }

    public final WebResourceResponse b(c.a.n0.a.h0.o.h.g.b bVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, bVar)) == null) {
            if (bVar == null) {
                return null;
            }
            String str = bVar.f6066e;
            if (str != null && str.toLowerCase().contains("html")) {
                bVar.f6066e = SapiWebView.DATA_MIME_TYPE;
                bVar.f6065d = "UTF-8";
            }
            if (c.a.n0.a.v2.d.f()) {
                return new WebResourceResponse(bVar.f6066e, bVar.f6065d, bVar.f6062a, bVar.f6063b, bVar.f6064c, bVar.f6067f);
            }
            return new WebResourceResponse(bVar.f6066e, "UTF-8", bVar.f6067f);
        }
        return (WebResourceResponse) invokeL.objValue;
    }

    public final void c(String str, int i2, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, i2, str2) == null) {
            q0.q().post(new RunnableC0233a(this, str, i2, str2));
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
            if (c.a.n0.a.h0.o.h.e.a.f6048a) {
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
            File b2 = c.a.n0.a.h0.o.h.d.a.a().b();
            String d2 = d();
            if (!TextUtils.isEmpty(d2)) {
                b2 = new File(b2, d2);
            }
            if (c.a.n0.a.h0.o.h.e.a.f6048a) {
                String str = "init default disk cache provider, path = " + b2;
            }
            c.a.n0.t.d.k(b2);
            this.f6052b = c.a.n0.a.c1.a.P().b(context, b2, c.a.n0.a.h0.o.h.d.a.a().g());
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
            c.a.n0.a.h0.o.h.c.a aVar = this.f6052b;
            if (aVar != null && !aVar.isClosed()) {
                inputStream = this.f6052b.get(e2);
            }
            if (inputStream != null) {
                if (c.a.n0.a.h0.o.h.e.a.f6048a) {
                    String str = "adopt cached image, url = " + e2;
                }
                return new WebResourceResponse(gVar.getMimeType(), "UTF-8", inputStream);
            }
            c.a.n0.a.h0.o.h.g.b a2 = e.a(e2, f(gVar));
            if (a2 != null && (i2 = a2.f6062a) >= 400 && this.f6054d != null) {
                c(e2, i2, a2.f6063b);
            }
            WebResourceResponse b2 = b(a2);
            if (b2 != null && b2.getData() != null) {
                b2.setData(new f(b2.getData(), new d(new File(this.f6053c, c.a.n0.a.h0.o.h.d.a.a().d().a(e2)), new c(this, this.f6052b, e2))));
            }
            if (c.a.n0.a.h0.o.h.e.a.f6048a) {
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
