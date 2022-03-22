package c.a.n0.i.a.e;

import android.util.Log;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
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
/* loaded from: classes2.dex */
public class c {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: e  reason: collision with root package name */
    public static final boolean f8525e;
    public transient /* synthetic */ FieldHolder $fh;
    public Download a;

    /* renamed from: b  reason: collision with root package name */
    public JSONObject f8526b;

    /* renamed from: c  reason: collision with root package name */
    public d f8527c;

    /* renamed from: d  reason: collision with root package name */
    public c.a.n0.i.a.f.b f8528d;

    /* loaded from: classes2.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes2.dex */
    public static class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public String a;

        /* renamed from: b  reason: collision with root package name */
        public String f8529b;

        public /* synthetic */ b(String str, String str2, a aVar) {
            this(str, str2);
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                c.a.n0.i.a.a.n().t(this.f8529b);
                c.a.n0.i.a.a.n().l(this.a);
                c.a.n0.i.a.a.n().k();
            }
        }

        public b(String str, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, str2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = str;
            this.f8529b = str2;
        }
    }

    /* renamed from: c.a.n0.i.a.e.c$c  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static class RunnableC0677c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public Download a;

        /* renamed from: b  reason: collision with root package name */
        public JSONObject f8530b;

        /* renamed from: c  reason: collision with root package name */
        public c.a.n0.i.a.f.a f8531c;

        public /* synthetic */ RunnableC0677c(Download download, JSONObject jSONObject, c.a.n0.i.a.f.a aVar, a aVar2) {
            this(download, jSONObject, aVar);
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                c.a.n0.i.a.a.n().G(this.f8530b);
                c.a.n0.i.a.i.c.a(this.a.getKeyByUser(), "installApp", null, null, new c.a.n0.i.a.i.a(this.f8530b));
                c.a.n0.i.a.a.n().r(AppRuntime.getAppContext(), this.a.getUrl(), this.a.getKeyByUser(), this.f8531c);
            }
        }

        public RunnableC0677c(@NonNull Download download, JSONObject jSONObject, @NonNull c.a.n0.i.a.f.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {download, jSONObject, aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = download;
            this.f8530b = jSONObject;
            this.f8531c = aVar;
        }
    }

    /* loaded from: classes2.dex */
    public class d implements c.a.n0.i.a.f.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public String a;

        /* renamed from: b  reason: collision with root package name */
        public String f8532b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ c f8533c;

        public d(c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f8533c = cVar;
        }

        @Override // c.a.n0.i.a.f.b
        public void a(c.a.n0.i.a.g.b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, bVar) == null) {
                if (c.f8525e) {
                    Log.d("InstallAppLocal", "onResult mPackageName:" + this.a);
                }
                this.f8533c.setResult(bVar);
                c.a.n0.i.a.c.b.f8496d.execute(new b(this.f8532b, this.a, null));
            }
        }

        @Override // c.a.n0.i.a.f.a
        public void setFilePath(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
                this.f8532b = str;
            }
        }

        @Override // c.a.n0.i.a.f.a
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
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-223836611, "Lc/a/n0/i/a/e/c;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-223836611, "Lc/a/n0/i/a/e/c;");
                return;
            }
        }
        f8525e = c.a.n0.a.a.a;
    }

    public c(Download download, JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {download, jSONObject};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = download;
        this.f8526b = jSONObject;
        this.f8527c = new d(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setResult(c.a.n0.i.a.g.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, this, bVar) == null) {
            c.a.n0.i.a.f.b bVar2 = this.f8528d;
            if (bVar2 != null) {
                bVar2.a(bVar);
            }
            if (bVar != null && !bVar.d()) {
                c.a.n0.i.a.i.c.a(this.a.getKeyByUser(), "installApp", com.baidu.pass.biometrics.face.liveness.b.a.g0, String.valueOf(bVar.c()), new c.a.n0.i.a.i.a(this.f8526b));
            }
            if (this.f8527c != null) {
                c.a.n0.i.a.a.n().B(this.a.getKeyByUser(), this.f8527c);
                this.f8527c = null;
            }
        }
    }

    public void c(c.a.n0.i.a.f.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, bVar) == null) {
            this.f8528d = bVar;
            c.a.n0.i.a.c.b.f8496d.execute(new RunnableC0677c(this.a, this.f8526b, this.f8527c, null));
        }
    }
}
