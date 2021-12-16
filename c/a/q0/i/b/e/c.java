package c.a.q0.i.b.e;

import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import c.a.q0.a.k;
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
/* loaded from: classes6.dex */
public class c {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: e  reason: collision with root package name */
    public static final boolean f10229e;
    public transient /* synthetic */ FieldHolder $fh;
    public Download a;

    /* renamed from: b  reason: collision with root package name */
    public JSONObject f10230b;

    /* renamed from: c  reason: collision with root package name */
    public d f10231c;

    /* renamed from: d  reason: collision with root package name */
    public c.a.q0.i.b.f.b f10232d;

    /* loaded from: classes6.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes6.dex */
    public static class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public String f10233e;

        /* renamed from: f  reason: collision with root package name */
        public String f10234f;

        public /* synthetic */ b(String str, String str2, a aVar) {
            this(str, str2);
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                c.a.q0.i.b.a.n().t(this.f10234f);
                c.a.q0.i.b.a.n().l(this.f10233e);
                c.a.q0.i.b.a.n().k();
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
            this.f10233e = str;
            this.f10234f = str2;
        }
    }

    /* renamed from: c.a.q0.i.b.e.c$c  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public static class RunnableC0659c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public Download f10235e;

        /* renamed from: f  reason: collision with root package name */
        public JSONObject f10236f;

        /* renamed from: g  reason: collision with root package name */
        public c.a.q0.i.b.f.a f10237g;

        public /* synthetic */ RunnableC0659c(Download download, JSONObject jSONObject, c.a.q0.i.b.f.a aVar, a aVar2) {
            this(download, jSONObject, aVar);
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                c.a.q0.i.b.a.n().G(this.f10236f);
                c.a.q0.i.b.i.c.a(this.f10235e.getKeyByUser(), "installApp", null, null, new c.a.q0.i.b.i.a(this.f10236f));
                c.a.q0.i.b.a.n().r(AppRuntime.getAppContext(), this.f10235e.getUrl(), this.f10235e.getKeyByUser(), this.f10237g);
            }
        }

        public RunnableC0659c(@NonNull Download download, JSONObject jSONObject, @NonNull c.a.q0.i.b.f.a aVar) {
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
            this.f10235e = download;
            this.f10236f = jSONObject;
            this.f10237g = aVar;
        }
    }

    /* loaded from: classes6.dex */
    public class d implements c.a.q0.i.b.f.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public String a;

        /* renamed from: b  reason: collision with root package name */
        public String f10238b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ c f10239c;

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
            this.f10239c = cVar;
        }

        @Override // c.a.q0.i.b.f.b
        public void a(c.a.q0.i.b.g.b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, bVar) == null) {
                if (c.f10229e) {
                    String str = "onResult mPackageName:" + this.a;
                }
                this.f10239c.setResult(bVar);
                c.a.q0.i.b.c.b.f10196d.execute(new b(this.f10238b, this.a, null));
            }
        }

        @Override // c.a.q0.i.b.f.a
        public void setFilePath(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
                this.f10238b = str;
            }
        }

        @Override // c.a.q0.i.b.f.a
        public void setPackageName(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
                this.a = str;
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1291094241, "Lc/a/q0/i/b/e/c;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1291094241, "Lc/a/q0/i/b/e/c;");
                return;
            }
        }
        f10229e = k.a;
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
        this.a = download;
        this.f10230b = jSONObject;
        this.f10231c = new d(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setResult(c.a.q0.i.b.g.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, this, bVar) == null) {
            c.a.q0.i.b.f.b bVar2 = this.f10232d;
            if (bVar2 != null) {
                bVar2.a(bVar);
            }
            if (bVar != null && !bVar.d()) {
                c.a.q0.i.b.i.c.a(this.a.getKeyByUser(), "installApp", com.baidu.pass.biometrics.face.liveness.b.a.g0, String.valueOf(bVar.c()), new c.a.q0.i.b.i.a(this.f10230b));
            }
            if (this.f10231c != null) {
                c.a.q0.i.b.a.n().B(this.a.getKeyByUser(), this.f10231c);
                this.f10231c = null;
            }
        }
    }

    public void c(c.a.q0.i.b.f.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, bVar) == null) {
            this.f10232d = bVar;
            c.a.q0.i.b.c.b.f10196d.execute(new RunnableC0659c(this.a, this.f10230b, this.f10231c, null));
        }
    }
}
