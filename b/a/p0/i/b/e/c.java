package b.a.p0.i.b.e;

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
    public static final boolean f10780e;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public Download f10781a;

    /* renamed from: b  reason: collision with root package name */
    public JSONObject f10782b;

    /* renamed from: c  reason: collision with root package name */
    public d f10783c;

    /* renamed from: d  reason: collision with root package name */
    public b.a.p0.i.b.f.b f10784d;

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
        public String f10785e;

        /* renamed from: f  reason: collision with root package name */
        public String f10786f;

        public /* synthetic */ b(String str, String str2, a aVar) {
            this(str, str2);
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                b.a.p0.i.b.a.n().t(this.f10786f);
                b.a.p0.i.b.a.n().l(this.f10785e);
                b.a.p0.i.b.a.n().k();
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
            this.f10785e = str;
            this.f10786f = str2;
        }
    }

    /* renamed from: b.a.p0.i.b.e.c$c  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public static class RunnableC0569c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public Download f10787e;

        /* renamed from: f  reason: collision with root package name */
        public JSONObject f10788f;

        /* renamed from: g  reason: collision with root package name */
        public b.a.p0.i.b.f.a f10789g;

        public /* synthetic */ RunnableC0569c(Download download, JSONObject jSONObject, b.a.p0.i.b.f.a aVar, a aVar2) {
            this(download, jSONObject, aVar);
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                b.a.p0.i.b.a.n().G(this.f10788f);
                b.a.p0.i.b.i.c.a(this.f10787e.getKeyByUser(), "installApp", null, null, new b.a.p0.i.b.i.a(this.f10788f));
                b.a.p0.i.b.a.n().r(AppRuntime.getAppContext(), this.f10787e.getUrl(), this.f10787e.getKeyByUser(), this.f10789g);
            }
        }

        public RunnableC0569c(@NonNull Download download, JSONObject jSONObject, @NonNull b.a.p0.i.b.f.a aVar) {
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
            this.f10787e = download;
            this.f10788f = jSONObject;
            this.f10789g = aVar;
        }
    }

    /* loaded from: classes4.dex */
    public class d implements b.a.p0.i.b.f.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public String f10790a;

        /* renamed from: b  reason: collision with root package name */
        public String f10791b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ c f10792c;

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
            this.f10792c = cVar;
        }

        @Override // b.a.p0.i.b.f.b
        public void a(b.a.p0.i.b.g.b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, bVar) == null) {
                if (c.f10780e) {
                    String str = "onResult mPackageName:" + this.f10790a;
                }
                this.f10792c.setResult(bVar);
                b.a.p0.i.b.c.b.f10728d.execute(new b(this.f10791b, this.f10790a, null));
            }
        }

        @Override // b.a.p0.i.b.f.a
        public void setFilePath(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
                this.f10791b = str;
            }
        }

        @Override // b.a.p0.i.b.f.a
        public void setPackageName(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
                this.f10790a = str;
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1001694691, "Lb/a/p0/i/b/e/c;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1001694691, "Lb/a/p0/i/b/e/c;");
                return;
            }
        }
        f10780e = k.f6863a;
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
        this.f10781a = download;
        this.f10782b = jSONObject;
        this.f10783c = new d(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setResult(b.a.p0.i.b.g.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, this, bVar) == null) {
            b.a.p0.i.b.f.b bVar2 = this.f10784d;
            if (bVar2 != null) {
                bVar2.a(bVar);
            }
            if (bVar != null && !bVar.d()) {
                b.a.p0.i.b.i.c.a(this.f10781a.getKeyByUser(), "installApp", com.baidu.pass.biometrics.face.liveness.b.a.g0, String.valueOf(bVar.c()), new b.a.p0.i.b.i.a(this.f10782b));
            }
            if (this.f10783c != null) {
                b.a.p0.i.b.a.n().B(this.f10781a.getKeyByUser(), this.f10783c);
                this.f10783c = null;
            }
        }
    }

    public void c(b.a.p0.i.b.f.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, bVar) == null) {
            this.f10784d = bVar;
            b.a.p0.i.b.c.b.f10728d.execute(new RunnableC0569c(this.f10781a, this.f10782b, this.f10783c, null));
        }
    }
}
