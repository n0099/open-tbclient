package c.a.s0.i.b.e;

import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import c.a.s0.a.k;
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
    public static final boolean f10963e;
    public transient /* synthetic */ FieldHolder $fh;
    public Download a;

    /* renamed from: b  reason: collision with root package name */
    public JSONObject f10964b;

    /* renamed from: c  reason: collision with root package name */
    public d f10965c;

    /* renamed from: d  reason: collision with root package name */
    public c.a.s0.i.b.f.b f10966d;

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
        public String f10967e;

        /* renamed from: f  reason: collision with root package name */
        public String f10968f;

        public /* synthetic */ b(String str, String str2, a aVar) {
            this(str, str2);
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                c.a.s0.i.b.a.n().t(this.f10968f);
                c.a.s0.i.b.a.n().l(this.f10967e);
                c.a.s0.i.b.a.n().k();
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
            this.f10967e = str;
            this.f10968f = str2;
        }
    }

    /* renamed from: c.a.s0.i.b.e.c$c  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public static class RunnableC0738c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public Download f10969e;

        /* renamed from: f  reason: collision with root package name */
        public JSONObject f10970f;

        /* renamed from: g  reason: collision with root package name */
        public c.a.s0.i.b.f.a f10971g;

        public /* synthetic */ RunnableC0738c(Download download, JSONObject jSONObject, c.a.s0.i.b.f.a aVar, a aVar2) {
            this(download, jSONObject, aVar);
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                c.a.s0.i.b.a.n().G(this.f10970f);
                c.a.s0.i.b.i.c.a(this.f10969e.getKeyByUser(), "installApp", null, null, new c.a.s0.i.b.i.a(this.f10970f));
                c.a.s0.i.b.a.n().r(AppRuntime.getAppContext(), this.f10969e.getUrl(), this.f10969e.getKeyByUser(), this.f10971g);
            }
        }

        public RunnableC0738c(@NonNull Download download, JSONObject jSONObject, @NonNull c.a.s0.i.b.f.a aVar) {
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
            this.f10969e = download;
            this.f10970f = jSONObject;
            this.f10971g = aVar;
        }
    }

    /* loaded from: classes6.dex */
    public class d implements c.a.s0.i.b.f.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public String a;

        /* renamed from: b  reason: collision with root package name */
        public String f10972b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ c f10973c;

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
            this.f10973c = cVar;
        }

        @Override // c.a.s0.i.b.f.b
        public void a(c.a.s0.i.b.g.b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, bVar) == null) {
                if (c.f10963e) {
                    String str = "onResult mPackageName:" + this.a;
                }
                this.f10973c.setResult(bVar);
                c.a.s0.i.b.c.b.f10930d.execute(new b(this.f10972b, this.a, null));
            }
        }

        @Override // c.a.s0.i.b.f.a
        public void setFilePath(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
                this.f10972b = str;
            }
        }

        @Override // c.a.s0.i.b.f.a
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
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-590029663, "Lc/a/s0/i/b/e/c;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-590029663, "Lc/a/s0/i/b/e/c;");
                return;
            }
        }
        f10963e = k.a;
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
        this.f10964b = jSONObject;
        this.f10965c = new d(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setResult(c.a.s0.i.b.g.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, this, bVar) == null) {
            c.a.s0.i.b.f.b bVar2 = this.f10966d;
            if (bVar2 != null) {
                bVar2.a(bVar);
            }
            if (bVar != null && !bVar.d()) {
                c.a.s0.i.b.i.c.a(this.a.getKeyByUser(), "installApp", com.baidu.pass.biometrics.face.liveness.b.a.g0, String.valueOf(bVar.c()), new c.a.s0.i.b.i.a(this.f10964b));
            }
            if (this.f10965c != null) {
                c.a.s0.i.b.a.n().B(this.a.getKeyByUser(), this.f10965c);
                this.f10965c = null;
            }
        }
    }

    public void c(c.a.s0.i.b.f.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, bVar) == null) {
            this.f10966d = bVar;
            c.a.s0.i.b.c.b.f10930d.execute(new RunnableC0738c(this.a, this.f10964b, this.f10965c, null));
        }
    }
}
