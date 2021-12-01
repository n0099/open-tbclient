package c.a.p0.a.h0.o.g.c;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import c.a.p0.w.d;
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
    public c.a.p0.a.h0.o.g.c.c.a a;

    /* renamed from: b  reason: collision with root package name */
    public c.a.p0.a.h0.o.g.c.b.a f5863b;

    /* renamed from: c  reason: collision with root package name */
    public File f5864c;

    /* renamed from: d  reason: collision with root package name */
    public long f5865d;

    /* renamed from: e  reason: collision with root package name */
    public int f5866e;

    /* renamed from: f  reason: collision with root package name */
    public int f5867f;

    /* renamed from: c.a.p0.a.h0.o.g.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static /* synthetic */ class C0303a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes.dex */
    public static class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public c.a.p0.a.h0.o.g.c.c.a a;

        /* renamed from: b  reason: collision with root package name */
        public c.a.p0.a.h0.o.g.c.b.a f5868b;

        /* renamed from: c  reason: collision with root package name */
        public File f5869c;

        /* renamed from: d  reason: collision with root package name */
        public long f5870d;

        /* renamed from: e  reason: collision with root package name */
        public int f5871e;

        /* renamed from: f  reason: collision with root package name */
        public int f5872f;

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
            this.f5871e = 0;
            this.f5872f = 0;
        }

        public b g(c.a.p0.a.h0.o.g.c.c.a aVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, aVar)) == null) {
                this.a = aVar;
                return this;
            }
            return (b) invokeL.objValue;
        }

        public b h(c.a.p0.a.h0.o.g.c.b.a aVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar)) == null) {
                this.f5868b = aVar;
                return this;
            }
            return (b) invokeL.objValue;
        }

        public b i(long j2) {
            InterceptResult invokeJ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeJ = interceptable.invokeJ(Constants.METHOD_SEND_USER_MSG, this, j2)) == null) {
                this.f5870d = j2;
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
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-286322721, "Lc/a/p0/a/h0/o/g/c/a$c;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-286322721, "Lc/a/p0/a/h0/o/g/c/a$c;");
                    return;
                }
            }
            a = new a(null);
        }
    }

    public /* synthetic */ a(C0303a c0303a) {
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
            if (this.f5864c == null) {
                String o = d.o();
                if (TextUtils.isEmpty(o)) {
                    return null;
                }
                this.f5864c = new File(o, "swan_hybrid");
            }
            return this.f5864c;
        }
        return (File) invokeV.objValue;
    }

    public c.a.p0.a.h0.o.g.c.c.a d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            if (this.a == null) {
                this.a = new c.a.p0.a.h0.o.g.c.c.b();
            }
            return this.a;
        }
        return (c.a.p0.a.h0.o.g.c.c.a) invokeV.objValue;
    }

    public int e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            if (this.f5866e <= 0) {
                this.f5866e = 60000;
            }
            return this.f5866e;
        }
        return invokeV.intValue;
    }

    public c.a.p0.a.h0.o.g.c.b.a f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            if (this.f5863b == null) {
                this.f5863b = new SystemStrategyImpl();
            }
            return this.f5863b;
        }
        return (c.a.p0.a.h0.o.g.c.b.a) invokeV.objValue;
    }

    public long g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            if (this.f5865d <= 0) {
                this.f5865d = DownloadManager.MIN_LEFT_SIZE;
            }
            return this.f5865d;
        }
        return invokeV.longValue;
    }

    public int h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            if (this.f5867f <= 0) {
                this.f5867f = 60000;
            }
            return this.f5867f;
        }
        return invokeV.intValue;
    }

    public void i(b bVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048582, this, bVar) == null) || bVar == null) {
            return;
        }
        this.a = bVar.a;
        this.f5863b = bVar.f5868b;
        this.f5864c = bVar.f5869c;
        this.f5865d = bVar.f5870d;
        this.f5866e = bVar.f5871e;
        this.f5867f = bVar.f5872f;
        if (c.a.p0.a.h0.o.g.d.a.a) {
            toString();
        }
    }

    @NonNull
    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return "SwanHybridInterceptConfig{CacheKeyProvider=" + this.a + ", InterceptStrategy=" + this.f5863b + ", CacheFolder=" + this.f5864c + ", MaxCacheSize=" + (this.f5865d / 1048576) + "MB, ConnectTimeout=" + this.f5866e + ", ReadTimeout=" + this.f5867f + ExtendedMessageFormat.END_FE;
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
