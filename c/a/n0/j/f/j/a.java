package c.a.n0.j.f.j;

import android.os.Bundle;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import c.a.n0.a.p2.j0;
import c.a.n0.a.x.m.k;
import c.a.n0.j.f.b;
import c.a.n0.j.t.a;
import c.a.n0.q.e.e;
import c.a.n0.q.h.i;
import c.a.n0.q.o.g;
import c.a.n0.w.d;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
import java.util.Set;
/* loaded from: classes2.dex */
public class a extends k {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: f  reason: collision with root package name */
    public static final boolean f8744f;
    public transient /* synthetic */ FieldHolder $fh;
    @NonNull

    /* renamed from: c  reason: collision with root package name */
    public b f8745c;
    @NonNull

    /* renamed from: d  reason: collision with root package name */
    public c.a.n0.j.f.k.a f8746d;

    /* renamed from: e  reason: collision with root package name */
    public e<i> f8747e;

    /* renamed from: c.a.n0.j.f.j.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class C0705a extends c.a.n0.q.e.b<i> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ a a;

        public C0705a(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = aVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.n0.q.e.e
        /* renamed from: l */
        public String d(i iVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, iVar)) == null) ? a.d.g().getPath() : (String) invokeL.objValue;
        }

        @Override // c.a.n0.q.e.g
        @NonNull
        public Bundle m(@NonNull Bundle bundle, Set<String> set) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLL = interceptable.invokeLL(1048582, this, bundle, set)) == null) ? this.a.m(bundle, set) : (Bundle) invokeLL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.n0.q.e.b, c.a.n0.q.e.e
        /* renamed from: o */
        public void e(i iVar, c.a.n0.q.h.b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048583, this, iVar, bVar) == null) {
                super.e(iVar, bVar);
                if (a.f8744f) {
                    Log.e("ConsoleJsDownload", "onDownloadError: " + bVar.toString());
                }
                this.a.f8745c.a(false);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.n0.q.e.b, c.a.n0.q.e.e
        /* renamed from: p */
        public void i(i iVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, iVar) == null) {
                super.i(iVar);
                if (a.f8744f) {
                    Log.i("ConsoleJsDownload", "onDownloadFinish: " + iVar.toString());
                }
                if (!j0.a(new File(iVar.a), iVar.m)) {
                    if (a.f8744f) {
                        Log.e("ConsoleJsDownload", "onDownloadFinish: 校验签名失败");
                    }
                    this.a.f8745c.a(false);
                    return;
                }
                File a = this.a.f8746d.a();
                if (a.exists()) {
                    d.j(a);
                } else {
                    d.l(a);
                }
                boolean U = d.U(iVar.a, a.getAbsolutePath());
                if (U) {
                    this.a.f8746d.b(iVar.j, iVar.i);
                }
                d.k(iVar.a);
                this.a.f8745c.a(U);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.n0.q.e.b, c.a.n0.q.e.e
        /* renamed from: q */
        public void c(i iVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048585, this, iVar) == null) {
                super.c(iVar);
                if (a.f8744f) {
                    Log.i("ConsoleJsDownload", "onDownloadStart: " + iVar.toString());
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.n0.q.e.b, c.a.n0.q.e.e
        /* renamed from: r */
        public void f(i iVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048586, this, iVar) == null) {
                super.f(iVar);
                if (a.f8744f) {
                    Log.i("ConsoleJsDownload", "onDownloading: 其它地方正在下载此包");
                }
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1662268372, "Lc/a/n0/j/f/j/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1662268372, "Lc/a/n0/j/f/j/a;");
                return;
            }
        }
        f8744f = c.a.n0.a.a.a;
    }

    public a(@NonNull c.a.n0.j.f.k.a aVar, @NonNull b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {aVar, bVar};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f8747e = new C0705a(this);
        this.f8745c = bVar;
        this.f8746d = aVar;
    }

    @Override // c.a.n0.q.e.i
    public void D(c.a.n0.q.h.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, bVar) == null) {
            super.D(bVar);
            if (f8744f) {
                Log.e("ConsoleJsDownload", "onFetchError: " + bVar.toString());
            }
            this.f8745c.a(false);
        }
    }

    @Override // c.a.n0.q.e.i
    public void F() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            super.F();
            if (f8744f) {
                Log.i("ConsoleJsDownload", "onFetchSuccess");
            }
        }
    }

    @Override // c.a.n0.q.e.i
    public void G() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            super.G();
            if (f8744f) {
                Log.i("ConsoleJsDownload", "onNoPackage");
            }
            this.f8745c.a(false);
        }
    }

    @Override // c.a.n0.q.e.i
    public void H(g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, gVar) == null) {
            super.H(gVar);
            if (f8744f) {
                Log.i("ConsoleJsDownload", "onPrepareDownload");
            }
        }
    }

    @Override // c.a.n0.q.e.i
    public e<i> y() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f8747e : (e) invokeV.objValue;
    }
}
