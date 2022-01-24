package c.a.t0.m0.e;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.danmu.data.ItemState;
import com.baidu.tieba.danmu.data.state.DrawState;
import com.baidu.tieba.danmu.ui.DanmakuPlayer;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes7.dex */
public class a implements Comparable<a> {
    public static /* synthetic */ Interceptable $ic;
    public static final C1211a m;
    public static final a n;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public b f19471e;

    /* renamed from: f  reason: collision with root package name */
    public ItemState f19472f;

    /* renamed from: g  reason: collision with root package name */
    public long f19473g;

    /* renamed from: h  reason: collision with root package name */
    public c.a.t0.m0.k.b f19474h;

    /* renamed from: i  reason: collision with root package name */
    public final c.b.b.q.a<c.a.t0.m0.f.d.d.a> f19475i;

    /* renamed from: j  reason: collision with root package name */
    public final c.a.t0.m0.e.d.a f19476j;
    public final DrawState k;
    public int l;

    /* renamed from: c.a.t0.m0.e.a$a  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public static final class C1211a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public C1211a() {
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

        public /* synthetic */ C1211a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final a a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? a.n : (a) invokeV.objValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(2070629923, "Lc/a/t0/m0/e/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(2070629923, "Lc/a/t0/m0/e/a;");
                return;
            }
        }
        m = new C1211a(null);
        n = new a(b.t.c(), null, 2, null);
    }

    public a(b data, DanmakuPlayer danmakuPlayer) {
        c.a.t0.m0.f.b m2;
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {data, danmakuPlayer};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        Intrinsics.checkNotNullParameter(data, "data");
        this.f19471e = data;
        this.f19472f = ItemState.Uninitialized;
        c.a.t0.m0.k.b bVar = null;
        if (danmakuPlayer != null && (m2 = danmakuPlayer.m()) != null) {
            bVar = m2.w();
        }
        this.f19474h = bVar == null ? c.a.t0.m0.f.a.f19485h.a().f() : bVar;
        this.f19475i = new c.b.b.q.a<>(0);
        this.f19476j = new c.a.t0.m0.e.d.a(this.f19474h);
        this.k = new DrawState();
        this.l = -1;
    }

    public final void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.k.t();
            if (this.f19472f.compareTo(ItemState.Measured) > 0) {
                this.f19472f = ItemState.Measured;
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.lang.Comparable
    /* renamed from: c */
    public int compareTo(a other) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, other)) == null) {
            Intrinsics.checkNotNullParameter(other, "other");
            return this.f19471e.compareTo(other.f19471e);
        }
        return invokeL.intValue;
    }

    public final c.b.b.q.a<c.a.t0.m0.f.d.d.a> d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f19475i : (c.b.b.q.a) invokeV.objValue;
    }

    public final b e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f19471e : (b) invokeV.objValue;
    }

    public final DrawState f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.k : (DrawState) invokeV.objValue;
    }

    public final long g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f19473g : invokeV.longValue;
    }

    public final int h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.l : invokeV.intValue;
    }

    public final ItemState i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.f19472f : (ItemState) invokeV.objValue;
    }

    public final long j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.f19471e.k() + this.f19476j.a() : invokeV.longValue;
    }

    public final boolean k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.f19476j.b() : invokeV.booleanValue;
    }

    public final void l(b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, bVar) == null) {
            Intrinsics.checkNotNullParameter(bVar, "<set-?>");
            this.f19471e = bVar;
        }
    }

    public final void m(long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048588, this, j2) == null) {
            this.f19473g = j2;
        }
    }

    public final void n(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048589, this, i2) == null) {
            this.l = i2;
        }
    }

    public final void o(ItemState itemState) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, itemState) == null) {
            Intrinsics.checkNotNullParameter(itemState, "<set-?>");
            this.f19472f = itemState;
        }
    }

    public final void p(c.a.t0.m0.k.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, bVar) == null) {
            Intrinsics.checkNotNullParameter(bVar, "<set-?>");
            this.f19474h = bVar;
        }
    }

    public /* synthetic */ a(b bVar, DanmakuPlayer danmakuPlayer, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(bVar, (i2 & 2) != 0 ? null : danmakuPlayer);
    }
}
