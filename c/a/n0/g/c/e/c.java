package c.a.n0.g.c.e;

import androidx.annotation.NonNull;
import c.a.n0.a.k;
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
    public static final boolean f10623e;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public Download f10624a;

    /* renamed from: b  reason: collision with root package name */
    public JSONObject f10625b;

    /* renamed from: c  reason: collision with root package name */
    public d f10626c;

    /* renamed from: d  reason: collision with root package name */
    public c.a.n0.g.c.f.b f10627d;

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
        public String f10628e;

        /* renamed from: f  reason: collision with root package name */
        public String f10629f;

        public /* synthetic */ b(String str, String str2, a aVar) {
            this(str, str2);
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                c.a.n0.g.c.a.n().t(this.f10629f);
                c.a.n0.g.c.a.n().l(this.f10628e);
                c.a.n0.g.c.a.n().k();
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
            this.f10628e = str;
            this.f10629f = str2;
        }
    }

    /* renamed from: c.a.n0.g.c.e.c$c  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static class RunnableC0536c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public Download f10630e;

        /* renamed from: f  reason: collision with root package name */
        public JSONObject f10631f;

        /* renamed from: g  reason: collision with root package name */
        public c.a.n0.g.c.f.a f10632g;

        public /* synthetic */ RunnableC0536c(Download download, JSONObject jSONObject, c.a.n0.g.c.f.a aVar, a aVar2) {
            this(download, jSONObject, aVar);
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                c.a.n0.g.c.a.n().G(this.f10631f);
                c.a.n0.g.c.i.c.a(this.f10630e.getKeyByUser(), "installApp", null, null, new c.a.n0.g.c.i.a(this.f10631f));
                c.a.n0.g.c.a.n().r(AppRuntime.getAppContext(), this.f10630e.getUrl(), this.f10630e.getKeyByUser(), this.f10632g);
            }
        }

        public RunnableC0536c(@NonNull Download download, JSONObject jSONObject, @NonNull c.a.n0.g.c.f.a aVar) {
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
            this.f10630e = download;
            this.f10631f = jSONObject;
            this.f10632g = aVar;
        }
    }

    /* loaded from: classes3.dex */
    public class d implements c.a.n0.g.c.f.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public String f10633a;

        /* renamed from: b  reason: collision with root package name */
        public String f10634b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ c f10635c;

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
            this.f10635c = cVar;
        }

        @Override // c.a.n0.g.c.f.a
        public void a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                this.f10634b = str;
            }
        }

        @Override // c.a.n0.g.c.f.b
        public void b(c.a.n0.g.c.g.b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bVar) == null) {
                if (c.f10623e) {
                    String str = "onResult mPackageName:" + this.f10633a;
                }
                this.f10635c.d(bVar);
                c.a.n0.g.c.c.b.f10570d.execute(new b(this.f10634b, this.f10633a, null));
            }
        }

        @Override // c.a.n0.g.c.f.a
        public void setPackageName(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
                this.f10633a = str;
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(642768317, "Lc/a/n0/g/c/e/c;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(642768317, "Lc/a/n0/g/c/e/c;");
                return;
            }
        }
        f10623e = k.f6803a;
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
        this.f10624a = download;
        this.f10625b = jSONObject;
        this.f10626c = new d(this);
    }

    public void c(c.a.n0.g.c.f.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, bVar) == null) {
            this.f10627d = bVar;
            c.a.n0.g.c.c.b.f10570d.execute(new RunnableC0536c(this.f10624a, this.f10625b, this.f10626c, null));
        }
    }

    public final void d(c.a.n0.g.c.g.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bVar) == null) {
            c.a.n0.g.c.f.b bVar2 = this.f10627d;
            if (bVar2 != null) {
                bVar2.b(bVar);
            }
            if (bVar != null && !bVar.d()) {
                c.a.n0.g.c.i.c.a(this.f10624a.getKeyByUser(), "installApp", com.baidu.pass.biometrics.face.liveness.b.a.g0, String.valueOf(bVar.c()), new c.a.n0.g.c.i.a(this.f10625b));
            }
            if (this.f10626c != null) {
                c.a.n0.g.c.a.n().B(this.f10624a.getKeyByUser(), this.f10626c);
                this.f10626c = null;
            }
        }
    }
}
