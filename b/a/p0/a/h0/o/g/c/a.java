package b.a.p0.a.h0.o.g.c;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import b.a.p0.w.d;
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
    public b.a.p0.a.h0.o.g.c.c.a f5941a;

    /* renamed from: b  reason: collision with root package name */
    public b.a.p0.a.h0.o.g.c.b.a f5942b;

    /* renamed from: c  reason: collision with root package name */
    public File f5943c;

    /* renamed from: d  reason: collision with root package name */
    public long f5944d;

    /* renamed from: e  reason: collision with root package name */
    public int f5945e;

    /* renamed from: f  reason: collision with root package name */
    public int f5946f;

    /* renamed from: b.a.p0.a.h0.o.g.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static /* synthetic */ class C0247a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes.dex */
    public static class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public b.a.p0.a.h0.o.g.c.c.a f5947a;

        /* renamed from: b  reason: collision with root package name */
        public b.a.p0.a.h0.o.g.c.b.a f5948b;

        /* renamed from: c  reason: collision with root package name */
        public File f5949c;

        /* renamed from: d  reason: collision with root package name */
        public long f5950d;

        /* renamed from: e  reason: collision with root package name */
        public int f5951e;

        /* renamed from: f  reason: collision with root package name */
        public int f5952f;

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
            this.f5951e = 0;
            this.f5952f = 0;
        }

        public b g(b.a.p0.a.h0.o.g.c.c.a aVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, aVar)) == null) {
                this.f5947a = aVar;
                return this;
            }
            return (b) invokeL.objValue;
        }

        public b h(b.a.p0.a.h0.o.g.c.b.a aVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar)) == null) {
                this.f5948b = aVar;
                return this;
            }
            return (b) invokeL.objValue;
        }

        public b i(long j) {
            InterceptResult invokeJ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeJ = interceptable.invokeJ(Constants.METHOD_SEND_USER_MSG, this, j)) == null) {
                this.f5950d = j;
                return this;
            }
            return (b) invokeJ.objValue;
        }
    }

    /* loaded from: classes.dex */
    public static class c {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: a  reason: collision with root package name */
        public static final a f5953a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1751733568, "Lb/a/p0/a/h0/o/g/c/a$c;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(1751733568, "Lb/a/p0/a/h0/o/g/c/a$c;");
                    return;
                }
            }
            f5953a = new a(null);
        }
    }

    public /* synthetic */ a(C0247a c0247a) {
        this();
    }

    public static a a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) ? c.f5953a : (a) invokeV.objValue;
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
            if (this.f5943c == null) {
                String o = d.o();
                if (TextUtils.isEmpty(o)) {
                    return null;
                }
                this.f5943c = new File(o, "swan_hybrid");
            }
            return this.f5943c;
        }
        return (File) invokeV.objValue;
    }

    public b.a.p0.a.h0.o.g.c.c.a d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            if (this.f5941a == null) {
                this.f5941a = new b.a.p0.a.h0.o.g.c.c.b();
            }
            return this.f5941a;
        }
        return (b.a.p0.a.h0.o.g.c.c.a) invokeV.objValue;
    }

    public int e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            if (this.f5945e <= 0) {
                this.f5945e = 60000;
            }
            return this.f5945e;
        }
        return invokeV.intValue;
    }

    public b.a.p0.a.h0.o.g.c.b.a f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            if (this.f5942b == null) {
                this.f5942b = new SystemStrategyImpl();
            }
            return this.f5942b;
        }
        return (b.a.p0.a.h0.o.g.c.b.a) invokeV.objValue;
    }

    public long g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            if (this.f5944d <= 0) {
                this.f5944d = DownloadManager.MIN_LEFT_SIZE;
            }
            return this.f5944d;
        }
        return invokeV.longValue;
    }

    public int h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            if (this.f5946f <= 0) {
                this.f5946f = 60000;
            }
            return this.f5946f;
        }
        return invokeV.intValue;
    }

    public void i(b bVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048582, this, bVar) == null) || bVar == null) {
            return;
        }
        this.f5941a = bVar.f5947a;
        this.f5942b = bVar.f5948b;
        this.f5943c = bVar.f5949c;
        this.f5944d = bVar.f5950d;
        this.f5945e = bVar.f5951e;
        this.f5946f = bVar.f5952f;
        if (b.a.p0.a.h0.o.g.d.a.f5954a) {
            toString();
        }
    }

    @NonNull
    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return "SwanHybridInterceptConfig{CacheKeyProvider=" + this.f5941a + ", InterceptStrategy=" + this.f5942b + ", CacheFolder=" + this.f5943c + ", MaxCacheSize=" + (this.f5944d / 1048576) + "MB, ConnectTimeout=" + this.f5945e + ", ReadTimeout=" + this.f5946f + ExtendedMessageFormat.END_FE;
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
