package c.a.n0.a.h0.o.h.d;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import c.a.n0.t.d;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.clientupdate.download.DownloadManager;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.swan.apps.core.prefetch.image.config.image.SystemStrategyImpl;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
import org.apache.commons.lang3.text.ExtendedMessageFormat;
/* loaded from: classes.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public c.a.n0.a.h0.o.h.d.c.a f6035a;

    /* renamed from: b  reason: collision with root package name */
    public c.a.n0.a.h0.o.h.d.b.a f6036b;

    /* renamed from: c  reason: collision with root package name */
    public File f6037c;

    /* renamed from: d  reason: collision with root package name */
    public long f6038d;

    /* renamed from: e  reason: collision with root package name */
    public int f6039e;

    /* renamed from: f  reason: collision with root package name */
    public int f6040f;

    /* renamed from: c.a.n0.a.h0.o.h.d.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static /* synthetic */ class C0231a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes.dex */
    public static class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public c.a.n0.a.h0.o.h.d.c.a f6041a;

        /* renamed from: b  reason: collision with root package name */
        public c.a.n0.a.h0.o.h.d.b.a f6042b;

        /* renamed from: c  reason: collision with root package name */
        public File f6043c;

        /* renamed from: d  reason: collision with root package name */
        public long f6044d;

        /* renamed from: e  reason: collision with root package name */
        public int f6045e;

        /* renamed from: f  reason: collision with root package name */
        public int f6046f;

        public b() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f6045e = 0;
            this.f6046f = 0;
        }

        public b g(c.a.n0.a.h0.o.h.d.c.a aVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, aVar)) == null) {
                this.f6041a = aVar;
                return this;
            }
            return (b) invokeL.objValue;
        }

        public b h(c.a.n0.a.h0.o.h.d.b.a aVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar)) == null) {
                this.f6042b = aVar;
                return this;
            }
            return (b) invokeL.objValue;
        }

        public b i(long j2) {
            InterceptResult invokeJ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeJ = interceptable.invokeJ(Constants.METHOD_SEND_USER_MSG, this, j2)) == null) {
                this.f6044d = j2;
                return this;
            }
            return (b) invokeJ.objValue;
        }
    }

    /* loaded from: classes.dex */
    public static class c {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: a  reason: collision with root package name */
        public static final a f6047a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-815705825, "Lc/a/n0/a/h0/o/h/d/a$c;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-815705825, "Lc/a/n0/a/h0/o/h/d/a$c;");
                    return;
                }
            }
            f6047a = new a(null);
        }
    }

    public /* synthetic */ a(C0231a c0231a) {
        this();
    }

    public static a a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) ? c.f6047a : (a) invokeV.objValue;
    }

    public static String c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            return AppRuntime.getAppContext().getExternalCacheDir() + File.separator + "swan_hybrid";
        }
        return (String) invokeV.objValue;
    }

    public File b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            if (this.f6037c == null) {
                String m = d.m();
                if (TextUtils.isEmpty(m)) {
                    return null;
                }
                this.f6037c = new File(m, "swan_hybrid");
            }
            return this.f6037c;
        }
        return (File) invokeV.objValue;
    }

    public c.a.n0.a.h0.o.h.d.c.a d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            if (this.f6035a == null) {
                this.f6035a = new c.a.n0.a.h0.o.h.d.c.b();
            }
            return this.f6035a;
        }
        return (c.a.n0.a.h0.o.h.d.c.a) invokeV.objValue;
    }

    public int e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            if (this.f6039e <= 0) {
                this.f6039e = 60000;
            }
            return this.f6039e;
        }
        return invokeV.intValue;
    }

    public c.a.n0.a.h0.o.h.d.b.a f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            if (this.f6036b == null) {
                this.f6036b = new SystemStrategyImpl();
            }
            return this.f6036b;
        }
        return (c.a.n0.a.h0.o.h.d.b.a) invokeV.objValue;
    }

    public long g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            if (this.f6038d <= 0) {
                this.f6038d = DownloadManager.MIN_LEFT_SIZE;
            }
            return this.f6038d;
        }
        return invokeV.longValue;
    }

    public int h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            if (this.f6040f <= 0) {
                this.f6040f = 60000;
            }
            return this.f6040f;
        }
        return invokeV.intValue;
    }

    public void i(b bVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048582, this, bVar) == null) || bVar == null) {
            return;
        }
        this.f6035a = bVar.f6041a;
        this.f6036b = bVar.f6042b;
        this.f6037c = bVar.f6043c;
        this.f6038d = bVar.f6044d;
        this.f6039e = bVar.f6045e;
        this.f6040f = bVar.f6046f;
        if (c.a.n0.a.h0.o.h.e.a.f6048a) {
            toString();
        }
    }

    @NonNull
    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return "SwanHybridInterceptConfig{CacheKeyProvider=" + this.f6035a + ", InterceptStrategy=" + this.f6036b + ", CacheFolder=" + this.f6037c + ", MaxCacheSize=" + (this.f6038d / 1048576) + "MB, ConnectTimeout=" + this.f6039e + ", ReadTimeout=" + this.f6040f + ExtendedMessageFormat.END_FE;
        }
        return (String) invokeV.objValue;
    }

    public a() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }
}
