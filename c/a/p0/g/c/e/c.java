package c.a.p0.g.c.e;

import androidx.annotation.NonNull;
import c.a.p0.a.k;
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
    public static final boolean f10897e;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public Download f10898a;

    /* renamed from: b  reason: collision with root package name */
    public JSONObject f10899b;

    /* renamed from: c  reason: collision with root package name */
    public d f10900c;

    /* renamed from: d  reason: collision with root package name */
    public c.a.p0.g.c.f.b f10901d;

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
        public String f10902e;

        /* renamed from: f  reason: collision with root package name */
        public String f10903f;

        public /* synthetic */ b(String str, String str2, a aVar) {
            this(str, str2);
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                c.a.p0.g.c.a.n().t(this.f10903f);
                c.a.p0.g.c.a.n().l(this.f10902e);
                c.a.p0.g.c.a.n().k();
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
            this.f10902e = str;
            this.f10903f = str2;
        }
    }

    /* renamed from: c.a.p0.g.c.e.c$c  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static class RunnableC0546c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public Download f10904e;

        /* renamed from: f  reason: collision with root package name */
        public JSONObject f10905f;

        /* renamed from: g  reason: collision with root package name */
        public c.a.p0.g.c.f.a f10906g;

        public /* synthetic */ RunnableC0546c(Download download, JSONObject jSONObject, c.a.p0.g.c.f.a aVar, a aVar2) {
            this(download, jSONObject, aVar);
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                c.a.p0.g.c.a.n().G(this.f10905f);
                c.a.p0.g.c.i.c.a(this.f10904e.getKeyByUser(), "installApp", null, null, new c.a.p0.g.c.i.a(this.f10905f));
                c.a.p0.g.c.a.n().r(AppRuntime.getAppContext(), this.f10904e.getUrl(), this.f10904e.getKeyByUser(), this.f10906g);
            }
        }

        public RunnableC0546c(@NonNull Download download, JSONObject jSONObject, @NonNull c.a.p0.g.c.f.a aVar) {
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
            this.f10904e = download;
            this.f10905f = jSONObject;
            this.f10906g = aVar;
        }
    }

    /* loaded from: classes3.dex */
    public class d implements c.a.p0.g.c.f.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public String f10907a;

        /* renamed from: b  reason: collision with root package name */
        public String f10908b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ c f10909c;

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
            this.f10909c = cVar;
        }

        @Override // c.a.p0.g.c.f.a
        public void a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                this.f10908b = str;
            }
        }

        @Override // c.a.p0.g.c.f.b
        public void b(c.a.p0.g.c.g.b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bVar) == null) {
                if (c.f10897e) {
                    String str = "onResult mPackageName:" + this.f10907a;
                }
                this.f10909c.d(bVar);
                c.a.p0.g.c.c.b.f10844d.execute(new b(this.f10908b, this.f10907a, null));
            }
        }

        @Override // c.a.p0.g.c.f.a
        public void setPackageName(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
                this.f10907a = str;
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1343832895, "Lc/a/p0/g/c/e/c;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1343832895, "Lc/a/p0/g/c/e/c;");
                return;
            }
        }
        f10897e = k.f7077a;
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
        this.f10898a = download;
        this.f10899b = jSONObject;
        this.f10900c = new d(this);
    }

    public void c(c.a.p0.g.c.f.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, bVar) == null) {
            this.f10901d = bVar;
            c.a.p0.g.c.c.b.f10844d.execute(new RunnableC0546c(this.f10898a, this.f10899b, this.f10900c, null));
        }
    }

    public final void d(c.a.p0.g.c.g.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bVar) == null) {
            c.a.p0.g.c.f.b bVar2 = this.f10901d;
            if (bVar2 != null) {
                bVar2.b(bVar);
            }
            if (bVar != null && !bVar.d()) {
                c.a.p0.g.c.i.c.a(this.f10898a.getKeyByUser(), "installApp", com.baidu.pass.biometrics.face.liveness.b.a.g0, String.valueOf(bVar.c()), new c.a.p0.g.c.i.a(this.f10899b));
            }
            if (this.f10900c != null) {
                c.a.p0.g.c.a.n().B(this.f10898a.getKeyByUser(), this.f10900c);
                this.f10900c = null;
            }
        }
    }
}
