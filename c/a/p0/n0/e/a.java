package c.a.p0.n0.e;

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
/* loaded from: classes2.dex */
public class a implements Comparable<a> {
    public static /* synthetic */ Interceptable $ic;
    public static final C1232a i;
    public static final a j;
    public transient /* synthetic */ FieldHolder $fh;
    public b a;

    /* renamed from: b  reason: collision with root package name */
    public ItemState f16439b;

    /* renamed from: c  reason: collision with root package name */
    public long f16440c;

    /* renamed from: d  reason: collision with root package name */
    public c.a.p0.n0.k.b f16441d;

    /* renamed from: e  reason: collision with root package name */
    public final c.b.b.q.a<c.a.p0.n0.f.d.d.a> f16442e;

    /* renamed from: f  reason: collision with root package name */
    public final c.a.p0.n0.e.d.a f16443f;

    /* renamed from: g  reason: collision with root package name */
    public final DrawState f16444g;

    /* renamed from: h  reason: collision with root package name */
    public int f16445h;

    /* renamed from: c.a.p0.n0.e.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static final class C1232a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public C1232a() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        public /* synthetic */ C1232a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final a a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? a.j : (a) invokeV.objValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-550779672, "Lc/a/p0/n0/e/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-550779672, "Lc/a/p0/n0/e/a;");
                return;
            }
        }
        i = new C1232a(null);
        j = new a(b.p.c(), null, 2, null);
    }

    public a(b data, DanmakuPlayer danmakuPlayer) {
        c.a.p0.n0.f.b m;
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
        this.a = data;
        this.f16439b = ItemState.Uninitialized;
        c.a.p0.n0.k.b bVar = null;
        if (danmakuPlayer != null && (m = danmakuPlayer.m()) != null) {
            bVar = m.w();
        }
        this.f16441d = bVar == null ? c.a.p0.n0.f.a.f16455h.a().f() : bVar;
        this.f16442e = new c.b.b.q.a<>(0);
        this.f16443f = new c.a.p0.n0.e.d.a(this.f16441d);
        this.f16444g = new DrawState();
        this.f16445h = -1;
    }

    public final void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.f16444g.t();
            if (this.f16439b.compareTo(ItemState.Measured) > 0) {
                this.f16439b = ItemState.Measured;
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
            return this.a.compareTo(other.a);
        }
        return invokeL.intValue;
    }

    public final c.b.b.q.a<c.a.p0.n0.f.d.d.a> d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f16442e : (c.b.b.q.a) invokeV.objValue;
    }

    public final b e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.a : (b) invokeV.objValue;
    }

    public final DrawState f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f16444g : (DrawState) invokeV.objValue;
    }

    public final long g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f16440c : invokeV.longValue;
    }

    public final int h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.f16445h : invokeV.intValue;
    }

    public final ItemState i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.f16439b : (ItemState) invokeV.objValue;
    }

    public final long j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.a.k() + this.f16443f.a() : invokeV.longValue;
    }

    public final boolean k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.f16443f.b() : invokeV.booleanValue;
    }

    public final void l(b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, bVar) == null) {
            Intrinsics.checkNotNullParameter(bVar, "<set-?>");
            this.a = bVar;
        }
    }

    public final void m(long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048588, this, j2) == null) {
            this.f16440c = j2;
        }
    }

    public final void n(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048589, this, i2) == null) {
            this.f16445h = i2;
        }
    }

    public final void o(ItemState itemState) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, itemState) == null) {
            Intrinsics.checkNotNullParameter(itemState, "<set-?>");
            this.f16439b = itemState;
        }
    }

    public final void p(c.a.p0.n0.k.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, bVar) == null) {
            Intrinsics.checkNotNullParameter(bVar, "<set-?>");
            this.f16441d = bVar;
        }
    }

    public /* synthetic */ a(b bVar, DanmakuPlayer danmakuPlayer, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(bVar, (i2 & 2) != 0 ? null : danmakuPlayer);
    }
}
