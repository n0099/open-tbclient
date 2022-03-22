package c.a.p0.n0.k;

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
/* loaded from: classes2.dex */
public final class f {
    public static /* synthetic */ Interceptable $ic;
    public static final f a;

    /* renamed from: b  reason: collision with root package name */
    public static final Pools.SimplePool<RectF> f16523b;

    /* renamed from: c  reason: collision with root package name */
    public static final Pools.SimplePool<PointF> f16524c;

    /* renamed from: d  reason: collision with root package name */
    public static final Pools.SimplePool<c.a.p0.n0.e.a> f16525d;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-550600771, "Lc/a/p0/n0/k/f;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-550600771, "Lc/a/p0/n0/k/f;");
                return;
            }
        }
        a = new f();
        f16523b = new Pools.SimplePool<>(200);
        f16524c = new Pools.SimplePool<>(200);
        f16525d = new Pools.SimplePool<>(1000);
    }

    public f() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public final c.a.p0.n0.e.a a(c.a.p0.n0.e.b data, DanmakuPlayer player) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, data, player)) == null) {
            Intrinsics.checkNotNullParameter(data, "data");
            Intrinsics.checkNotNullParameter(player, "player");
            c.a.p0.n0.e.a acquire = f16525d.acquire();
            if (acquire == null) {
                acquire = null;
            } else {
                acquire.l(data);
                acquire.p(player.m().w());
            }
            return acquire == null ? new c.a.p0.n0.e.a(data, player) : acquire;
        }
        return (c.a.p0.n0.e.a) invokeLL.objValue;
    }

    public final PointF b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            PointF acquire = f16524c.acquire();
            return acquire == null ? new PointF() : acquire;
        }
        return (PointF) invokeV.objValue;
    }

    public final RectF c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            RectF acquire = f16523b.acquire();
            return acquire == null ? new RectF() : acquire;
        }
        return (RectF) invokeV.objValue;
    }
}
