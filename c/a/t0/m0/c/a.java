package c.a.t0.m0.c;

import android.annotation.SuppressLint;
import android.graphics.Bitmap;
import android.os.Build;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.danmu.cache.CacheManager;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes7.dex */
public final class a {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: f  reason: collision with root package name */
    public static final C1187a f19692f;

    /* renamed from: g  reason: collision with root package name */
    public static final a f19693g;
    public transient /* synthetic */ FieldHolder $fh;
    public final b a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f19694b;

    /* renamed from: c  reason: collision with root package name */
    public int f19695c;

    /* renamed from: d  reason: collision with root package name */
    public CacheManager f19696d;

    /* renamed from: e  reason: collision with root package name */
    public int f19697e;

    /* renamed from: c.a.t0.m0.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public static final class C1187a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public C1187a() {
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

        public /* synthetic */ C1187a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final a a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? a.f19693g : (a) invokeV.objValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(2070570341, "Lc/a/t0/m0/c/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(2070570341, "Lc/a/t0/m0/c/a;");
                return;
            }
        }
        f19692f = new C1187a(null);
        f19693g = new a();
    }

    public a() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = new b();
    }

    public final a b(int i2, int i3, int i4, boolean z, int i5) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Boolean.valueOf(z), Integer.valueOf(i5)})) == null) {
            synchronized (this) {
                this.a.a(i2, i3, i4, z, i5);
                this.f19697e = h(this.a.c());
            }
            return this;
        }
        return (a) invokeCommon.objValue;
    }

    public final void d() {
        CacheManager i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            synchronized (this) {
                int i3 = this.f19695c - 1;
                this.f19695c = i3;
                if (i3 <= 0 && this.f19694b && (i2 = i()) != null) {
                    i2.l(this);
                }
                Unit unit = Unit.INSTANCE;
            }
        }
    }

    public final void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            synchronized (this) {
                if (this.f19695c <= 0) {
                    n();
                } else {
                    this.f19694b = true;
                }
                Unit unit = Unit.INSTANCE;
            }
        }
    }

    public final void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            synchronized (this) {
                this.a.b();
                Unit unit = Unit.INSTANCE;
            }
        }
    }

    public final b g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            b bVar = this.a;
            if ((Intrinsics.areEqual(bVar.c(), c.a.t0.m0.g.b.b()) || bVar.c().isRecycled()) ? false : true) {
                return bVar;
            }
            return null;
        }
        return (b) invokeV.objValue;
    }

    @SuppressLint({"ObsoleteSdkInt"})
    public final int h(Bitmap bitmap) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, bitmap)) == null) {
            if (bitmap == null) {
                return 0;
            }
            if (Build.VERSION.SDK_INT >= 19) {
                return bitmap.getAllocationByteCount();
            }
            return bitmap.getRowBytes() * bitmap.getHeight();
        }
        return invokeL.intValue;
    }

    public final CacheManager i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f19696d : (CacheManager) invokeV.objValue;
    }

    public final int j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.a.e() : invokeV.intValue;
    }

    public final int k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.f19697e : invokeV.intValue;
    }

    public final int l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.a.f() : invokeV.intValue;
    }

    public final void m() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            synchronized (this) {
                this.f19695c++;
            }
        }
    }

    public final void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            synchronized (this) {
                if (!Intrinsics.areEqual(Thread.currentThread().getName(), "AkDanmaku-Cache")) {
                    BdLog.e(Intrinsics.stringPlus("DanmakuEngineDrawingCache recycle called must on cache thread but now on ", Thread.currentThread().getName()));
                }
                if (this.f19695c > 0) {
                    return;
                }
                this.f19694b = false;
                this.a.g();
                this.f19697e = 0;
                Unit unit = Unit.INSTANCE;
            }
        }
    }

    public final void o(CacheManager cacheManager) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, cacheManager) == null) {
            this.f19696d = cacheManager;
        }
    }
}
