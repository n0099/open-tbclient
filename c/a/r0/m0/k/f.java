package c.a.r0.m0.k;

import android.graphics.PointF;
import android.graphics.RectF;
import androidx.core.util.Pools;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.danmu.ui.DanmakuPlayer;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes6.dex */
public final class f {
    public static /* synthetic */ Interceptable $ic;
    public static final f a;

    /* renamed from: b  reason: collision with root package name */
    public static final Pools.SimplePool<RectF> f19950b;

    /* renamed from: c  reason: collision with root package name */
    public static final Pools.SimplePool<PointF> f19951c;

    /* renamed from: d  reason: collision with root package name */
    public static final Pools.SimplePool<c.a.r0.m0.e.a> f19952d;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1831131462, "Lc/a/r0/m0/k/f;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1831131462, "Lc/a/r0/m0/k/f;");
                return;
            }
        }
        a = new f();
        f19950b = new Pools.SimplePool<>(200);
        f19951c = new Pools.SimplePool<>(200);
        f19952d = new Pools.SimplePool<>(1000);
    }

    public f() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public final c.a.r0.m0.e.a a(c.a.r0.m0.e.b data, DanmakuPlayer player) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, data, player)) == null) {
            Intrinsics.checkNotNullParameter(data, "data");
            Intrinsics.checkNotNullParameter(player, "player");
            c.a.r0.m0.e.a acquire = f19952d.acquire();
            if (acquire == null) {
                acquire = null;
            } else {
                acquire.l(data);
                acquire.p(player.m().w());
            }
            return acquire == null ? new c.a.r0.m0.e.a(data, player) : acquire;
        }
        return (c.a.r0.m0.e.a) invokeLL.objValue;
    }

    public final PointF b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            PointF acquire = f19951c.acquire();
            return acquire == null ? new PointF() : acquire;
        }
        return (PointF) invokeV.objValue;
    }

    public final RectF c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            RectF acquire = f19950b.acquire();
            return acquire == null ? new RectF() : acquire;
        }
        return (RectF) invokeV.objValue;
    }
}
