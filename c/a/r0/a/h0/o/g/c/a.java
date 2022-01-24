package c.a.r0.a.h0.o.g.c;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import c.a.r0.w.d;
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
    public c.a.r0.a.h0.o.g.c.c.a a;

    /* renamed from: b  reason: collision with root package name */
    public c.a.r0.a.h0.o.g.c.b.a f6900b;

    /* renamed from: c  reason: collision with root package name */
    public File f6901c;

    /* renamed from: d  reason: collision with root package name */
    public long f6902d;

    /* renamed from: e  reason: collision with root package name */
    public int f6903e;

    /* renamed from: f  reason: collision with root package name */
    public int f6904f;

    /* renamed from: c.a.r0.a.h0.o.g.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static /* synthetic */ class C0405a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes.dex */
    public static class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public c.a.r0.a.h0.o.g.c.c.a a;

        /* renamed from: b  reason: collision with root package name */
        public c.a.r0.a.h0.o.g.c.b.a f6905b;

        /* renamed from: c  reason: collision with root package name */
        public File f6906c;

        /* renamed from: d  reason: collision with root package name */
        public long f6907d;

        /* renamed from: e  reason: collision with root package name */
        public int f6908e;

        /* renamed from: f  reason: collision with root package name */
        public int f6909f;

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
            this.f6908e = 0;
            this.f6909f = 0;
        }

        public b g(c.a.r0.a.h0.o.g.c.c.a aVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, aVar)) == null) {
                this.a = aVar;
                return this;
            }
            return (b) invokeL.objValue;
        }

        public b h(c.a.r0.a.h0.o.g.c.b.a aVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar)) == null) {
                this.f6905b = aVar;
                return this;
            }
            return (b) invokeL.objValue;
        }

        public b i(long j2) {
            InterceptResult invokeJ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeJ = interceptable.invokeJ(Constants.METHOD_SEND_USER_MSG, this, j2)) == null) {
                this.f6907d = j2;
                return this;
            }
            return (b) invokeJ.objValue;
        }
    }

    /* loaded from: classes.dex */
    public static class c {
        public static /* synthetic */ Interceptable $ic;
        public static final a a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(2014499869, "Lc/a/r0/a/h0/o/g/c/a$c;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(2014499869, "Lc/a/r0/a/h0/o/g/c/a$c;");
                    return;
                }
            }
            a = new a(null);
        }
    }

    public /* synthetic */ a(C0405a c0405a) {
        this();
    }

    public static a a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) ? c.a : (a) invokeV.objValue;
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
            if (this.f6901c == null) {
                String o = d.o();
                if (TextUtils.isEmpty(o)) {
                    return null;
                }
                this.f6901c = new File(o, "swan_hybrid");
            }
            return this.f6901c;
        }
        return (File) invokeV.objValue;
    }

    public c.a.r0.a.h0.o.g.c.c.a d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            if (this.a == null) {
                this.a = new c.a.r0.a.h0.o.g.c.c.b();
            }
            return this.a;
        }
        return (c.a.r0.a.h0.o.g.c.c.a) invokeV.objValue;
    }

    public int e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            if (this.f6903e <= 0) {
                this.f6903e = 60000;
            }
            return this.f6903e;
        }
        return invokeV.intValue;
    }

    public c.a.r0.a.h0.o.g.c.b.a f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            if (this.f6900b == null) {
                this.f6900b = new SystemStrategyImpl();
            }
            return this.f6900b;
        }
        return (c.a.r0.a.h0.o.g.c.b.a) invokeV.objValue;
    }

    public long g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            if (this.f6902d <= 0) {
                this.f6902d = DownloadManager.MIN_LEFT_SIZE;
            }
            return this.f6902d;
        }
        return invokeV.longValue;
    }

    public int h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            if (this.f6904f <= 0) {
                this.f6904f = 60000;
            }
            return this.f6904f;
        }
        return invokeV.intValue;
    }

    public void i(b bVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048582, this, bVar) == null) || bVar == null) {
            return;
        }
        this.a = bVar.a;
        this.f6900b = bVar.f6905b;
        this.f6901c = bVar.f6906c;
        this.f6902d = bVar.f6907d;
        this.f6903e = bVar.f6908e;
        this.f6904f = bVar.f6909f;
        if (c.a.r0.a.h0.o.g.d.a.a) {
            toString();
        }
    }

    @NonNull
    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return "SwanHybridInterceptConfig{CacheKeyProvider=" + this.a + ", InterceptStrategy=" + this.f6900b + ", CacheFolder=" + this.f6901c + ", MaxCacheSize=" + (this.f6902d / 1048576) + "MB, ConnectTimeout=" + this.f6903e + ", ReadTimeout=" + this.f6904f + ExtendedMessageFormat.END_FE;
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
