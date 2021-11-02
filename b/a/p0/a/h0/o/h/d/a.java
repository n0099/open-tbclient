package b.a.p0.a.h0.o.h.d;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import b.a.p0.t.d;
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
    public b.a.p0.a.h0.o.h.d.c.a f5651a;

    /* renamed from: b  reason: collision with root package name */
    public b.a.p0.a.h0.o.h.d.b.a f5652b;

    /* renamed from: c  reason: collision with root package name */
    public File f5653c;

    /* renamed from: d  reason: collision with root package name */
    public long f5654d;

    /* renamed from: e  reason: collision with root package name */
    public int f5655e;

    /* renamed from: f  reason: collision with root package name */
    public int f5656f;

    /* renamed from: b.a.p0.a.h0.o.h.d.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static /* synthetic */ class C0236a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes.dex */
    public static class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public b.a.p0.a.h0.o.h.d.c.a f5657a;

        /* renamed from: b  reason: collision with root package name */
        public b.a.p0.a.h0.o.h.d.b.a f5658b;

        /* renamed from: c  reason: collision with root package name */
        public File f5659c;

        /* renamed from: d  reason: collision with root package name */
        public long f5660d;

        /* renamed from: e  reason: collision with root package name */
        public int f5661e;

        /* renamed from: f  reason: collision with root package name */
        public int f5662f;

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
            this.f5661e = 0;
            this.f5662f = 0;
        }

        public b g(b.a.p0.a.h0.o.h.d.c.a aVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, aVar)) == null) {
                this.f5657a = aVar;
                return this;
            }
            return (b) invokeL.objValue;
        }

        public b h(b.a.p0.a.h0.o.h.d.b.a aVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar)) == null) {
                this.f5658b = aVar;
                return this;
            }
            return (b) invokeL.objValue;
        }

        public b i(long j) {
            InterceptResult invokeJ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeJ = interceptable.invokeJ(Constants.METHOD_SEND_USER_MSG, this, j)) == null) {
                this.f5660d = j;
                return this;
            }
            return (b) invokeJ.objValue;
        }
    }

    /* loaded from: classes.dex */
    public static class c {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: a  reason: collision with root package name */
        public static final a f5663a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-771794242, "Lb/a/p0/a/h0/o/h/d/a$c;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-771794242, "Lb/a/p0/a/h0/o/h/d/a$c;");
                    return;
                }
            }
            f5663a = new a(null);
        }
    }

    public /* synthetic */ a(C0236a c0236a) {
        this();
    }

    public static a a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) ? c.f5663a : (a) invokeV.objValue;
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
            if (this.f5653c == null) {
                String m = d.m();
                if (TextUtils.isEmpty(m)) {
                    return null;
                }
                this.f5653c = new File(m, "swan_hybrid");
            }
            return this.f5653c;
        }
        return (File) invokeV.objValue;
    }

    public b.a.p0.a.h0.o.h.d.c.a d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            if (this.f5651a == null) {
                this.f5651a = new b.a.p0.a.h0.o.h.d.c.b();
            }
            return this.f5651a;
        }
        return (b.a.p0.a.h0.o.h.d.c.a) invokeV.objValue;
    }

    public int e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            if (this.f5655e <= 0) {
                this.f5655e = 60000;
            }
            return this.f5655e;
        }
        return invokeV.intValue;
    }

    public b.a.p0.a.h0.o.h.d.b.a f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            if (this.f5652b == null) {
                this.f5652b = new SystemStrategyImpl();
            }
            return this.f5652b;
        }
        return (b.a.p0.a.h0.o.h.d.b.a) invokeV.objValue;
    }

    public long g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            if (this.f5654d <= 0) {
                this.f5654d = DownloadManager.MIN_LEFT_SIZE;
            }
            return this.f5654d;
        }
        return invokeV.longValue;
    }

    public int h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            if (this.f5656f <= 0) {
                this.f5656f = 60000;
            }
            return this.f5656f;
        }
        return invokeV.intValue;
    }

    public void i(b bVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048582, this, bVar) == null) || bVar == null) {
            return;
        }
        this.f5651a = bVar.f5657a;
        this.f5652b = bVar.f5658b;
        this.f5653c = bVar.f5659c;
        this.f5654d = bVar.f5660d;
        this.f5655e = bVar.f5661e;
        this.f5656f = bVar.f5662f;
        if (b.a.p0.a.h0.o.h.e.a.f5664a) {
            toString();
        }
    }

    @NonNull
    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return "SwanHybridInterceptConfig{CacheKeyProvider=" + this.f5651a + ", InterceptStrategy=" + this.f5652b + ", CacheFolder=" + this.f5653c + ", MaxCacheSize=" + (this.f5654d / 1048576) + "MB, ConnectTimeout=" + this.f5655e + ", ReadTimeout=" + this.f5656f + ExtendedMessageFormat.END_FE;
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
