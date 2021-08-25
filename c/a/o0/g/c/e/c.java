package c.a.o0.g.c.e;

import androidx.annotation.NonNull;
import c.a.o0.a.k;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.down.manage.Download;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class c {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: e  reason: collision with root package name */
    public static final boolean f10869e;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public Download f10870a;

    /* renamed from: b  reason: collision with root package name */
    public JSONObject f10871b;

    /* renamed from: c  reason: collision with root package name */
    public d f10872c;

    /* renamed from: d  reason: collision with root package name */
    public c.a.o0.g.c.f.b f10873d;

    /* loaded from: classes3.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes3.dex */
    public static class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public String f10874e;

        /* renamed from: f  reason: collision with root package name */
        public String f10875f;

        public /* synthetic */ b(String str, String str2, a aVar) {
            this(str, str2);
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                c.a.o0.g.c.a.n().t(this.f10875f);
                c.a.o0.g.c.a.n().l(this.f10874e);
                c.a.o0.g.c.a.n().k();
            }
        }

        public b(String str, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, str2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f10874e = str;
            this.f10875f = str2;
        }
    }

    /* renamed from: c.a.o0.g.c.e.c$c  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static class RunnableC0544c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public Download f10876e;

        /* renamed from: f  reason: collision with root package name */
        public JSONObject f10877f;

        /* renamed from: g  reason: collision with root package name */
        public c.a.o0.g.c.f.a f10878g;

        public /* synthetic */ RunnableC0544c(Download download, JSONObject jSONObject, c.a.o0.g.c.f.a aVar, a aVar2) {
            this(download, jSONObject, aVar);
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                c.a.o0.g.c.a.n().G(this.f10877f);
                c.a.o0.g.c.i.c.a(this.f10876e.getKeyByUser(), "installApp", null, null, new c.a.o0.g.c.i.a(this.f10877f));
                c.a.o0.g.c.a.n().r(AppRuntime.getAppContext(), this.f10876e.getUrl(), this.f10876e.getKeyByUser(), this.f10878g);
            }
        }

        public RunnableC0544c(@NonNull Download download, JSONObject jSONObject, @NonNull c.a.o0.g.c.f.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {download, jSONObject, aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f10876e = download;
            this.f10877f = jSONObject;
            this.f10878g = aVar;
        }
    }

    /* loaded from: classes3.dex */
    public class d implements c.a.o0.g.c.f.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public String f10879a;

        /* renamed from: b  reason: collision with root package name */
        public String f10880b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ c f10881c;

        public d(c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f10881c = cVar;
        }

        @Override // c.a.o0.g.c.f.a
        public void a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                this.f10880b = str;
            }
        }

        @Override // c.a.o0.g.c.f.b
        public void b(c.a.o0.g.c.g.b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bVar) == null) {
                if (c.f10869e) {
                    String str = "onResult mPackageName:" + this.f10879a;
                }
                this.f10881c.d(bVar);
                c.a.o0.g.c.c.b.f10816d.execute(new b(this.f10880b, this.f10879a, null));
            }
        }

        @Override // c.a.o0.g.c.f.a
        public void setPackageName(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
                this.f10879a = str;
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1154183042, "Lc/a/o0/g/c/e/c;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1154183042, "Lc/a/o0/g/c/e/c;");
                return;
            }
        }
        f10869e = k.f7049a;
    }

    public c(Download download, JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {download, jSONObject};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f10870a = download;
        this.f10871b = jSONObject;
        this.f10872c = new d(this);
    }

    public void c(c.a.o0.g.c.f.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, bVar) == null) {
            this.f10873d = bVar;
            c.a.o0.g.c.c.b.f10816d.execute(new RunnableC0544c(this.f10870a, this.f10871b, this.f10872c, null));
        }
    }

    public final void d(c.a.o0.g.c.g.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bVar) == null) {
            c.a.o0.g.c.f.b bVar2 = this.f10873d;
            if (bVar2 != null) {
                bVar2.b(bVar);
            }
            if (bVar != null && !bVar.d()) {
                c.a.o0.g.c.i.c.a(this.f10870a.getKeyByUser(), "installApp", com.baidu.pass.biometrics.face.liveness.b.a.g0, String.valueOf(bVar.c()), new c.a.o0.g.c.i.a(this.f10871b));
            }
            if (this.f10872c != null) {
                c.a.o0.g.c.a.n().B(this.f10870a.getKeyByUser(), this.f10872c);
                this.f10872c = null;
            }
        }
    }
}
