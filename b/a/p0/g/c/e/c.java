package b.a.p0.g.c.e;

import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import b.a.p0.a.k;
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
/* loaded from: classes4.dex */
public class c {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: e  reason: collision with root package name */
    public static final boolean f10111e;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public Download f10112a;

    /* renamed from: b  reason: collision with root package name */
    public JSONObject f10113b;

    /* renamed from: c  reason: collision with root package name */
    public d f10114c;

    /* renamed from: d  reason: collision with root package name */
    public b.a.p0.g.c.f.b f10115d;

    /* loaded from: classes4.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes4.dex */
    public static class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public String f10116e;

        /* renamed from: f  reason: collision with root package name */
        public String f10117f;

        public /* synthetic */ b(String str, String str2, a aVar) {
            this(str, str2);
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                b.a.p0.g.c.a.n().t(this.f10117f);
                b.a.p0.g.c.a.n().l(this.f10116e);
                b.a.p0.g.c.a.n().k();
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
            this.f10116e = str;
            this.f10117f = str2;
        }
    }

    /* renamed from: b.a.p0.g.c.e.c$c  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public static class RunnableC0541c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public Download f10118e;

        /* renamed from: f  reason: collision with root package name */
        public JSONObject f10119f;

        /* renamed from: g  reason: collision with root package name */
        public b.a.p0.g.c.f.a f10120g;

        public /* synthetic */ RunnableC0541c(Download download, JSONObject jSONObject, b.a.p0.g.c.f.a aVar, a aVar2) {
            this(download, jSONObject, aVar);
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                b.a.p0.g.c.a.n().G(this.f10119f);
                b.a.p0.g.c.i.c.a(this.f10118e.getKeyByUser(), "installApp", null, null, new b.a.p0.g.c.i.a(this.f10119f));
                b.a.p0.g.c.a.n().r(AppRuntime.getAppContext(), this.f10118e.getUrl(), this.f10118e.getKeyByUser(), this.f10120g);
            }
        }

        public RunnableC0541c(@NonNull Download download, JSONObject jSONObject, @NonNull b.a.p0.g.c.f.a aVar) {
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
            this.f10118e = download;
            this.f10119f = jSONObject;
            this.f10120g = aVar;
        }
    }

    /* loaded from: classes4.dex */
    public class d implements b.a.p0.g.c.f.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public String f10121a;

        /* renamed from: b  reason: collision with root package name */
        public String f10122b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ c f10123c;

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
            this.f10123c = cVar;
        }

        @Override // b.a.p0.g.c.f.b
        public void a(b.a.p0.g.c.g.b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, bVar) == null) {
                if (c.f10111e) {
                    String str = "onResult mPackageName:" + this.f10121a;
                }
                this.f10123c.setResult(bVar);
                b.a.p0.g.c.c.b.f10058d.execute(new b(this.f10122b, this.f10121a, null));
            }
        }

        @Override // b.a.p0.g.c.f.a
        public void setFilePath(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
                this.f10122b = str;
            }
        }

        @Override // b.a.p0.g.c.f.a
        public void setPackageName(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
                this.f10121a = str;
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-163718914, "Lb/a/p0/g/c/e/c;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-163718914, "Lb/a/p0/g/c/e/c;");
                return;
            }
        }
        f10111e = k.f6397a;
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
        this.f10112a = download;
        this.f10113b = jSONObject;
        this.f10114c = new d(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setResult(b.a.p0.g.c.g.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, this, bVar) == null) {
            b.a.p0.g.c.f.b bVar2 = this.f10115d;
            if (bVar2 != null) {
                bVar2.a(bVar);
            }
            if (bVar != null && !bVar.d()) {
                b.a.p0.g.c.i.c.a(this.f10112a.getKeyByUser(), "installApp", com.baidu.pass.biometrics.face.liveness.b.a.g0, String.valueOf(bVar.c()), new b.a.p0.g.c.i.a(this.f10113b));
            }
            if (this.f10114c != null) {
                b.a.p0.g.c.a.n().B(this.f10112a.getKeyByUser(), this.f10114c);
                this.f10114c = null;
            }
        }
    }

    public void c(b.a.p0.g.c.f.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, bVar) == null) {
            this.f10115d = bVar;
            b.a.p0.g.c.c.b.f10058d.execute(new RunnableC0541c(this.f10112a, this.f10113b, this.f10114c, null));
        }
    }
}
