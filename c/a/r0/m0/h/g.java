package c.a.r0.m0.h;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Arrays;
import java.util.Map;
import kotlin.Pair;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes6.dex */
public class g implements c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final c a;

    /* renamed from: b  reason: collision with root package name */
    public final Map<Integer, c> f19920b;

    public g(c defaultLayouter, Pair<Integer, ? extends c>... layouter) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {defaultLayouter, layouter};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        Intrinsics.checkNotNullParameter(defaultLayouter, "defaultLayouter");
        Intrinsics.checkNotNullParameter(layouter, "layouter");
        this.a = defaultLayouter;
        this.f19920b = MapsKt__MapsKt.mutableMapOf((Pair[]) Arrays.copyOf(layouter, layouter.length));
    }

    @Override // c.a.r0.m0.h.c
    public void a(c.a.r0.m0.e.a item, long j2, c.a.r0.m0.j.b displayer, c.a.r0.m0.a config) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{item, Long.valueOf(j2), displayer, config}) == null) {
            Intrinsics.checkNotNullParameter(item, "item");
            Intrinsics.checkNotNullParameter(displayer, "displayer");
            Intrinsics.checkNotNullParameter(config, "config");
            f(item).a(item, j2, displayer, config);
        }
    }

    @Override // c.a.r0.m0.h.c
    public void b(c.a.r0.m0.e.a item) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, item) == null) {
            Intrinsics.checkNotNullParameter(item, "item");
            f(item).b(item);
        }
    }

    @Override // c.a.r0.m0.h.c
    public void c(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(Constants.METHOD_SEND_USER_MSG, this, i2, i3) == null) {
            this.a.c(i2, i3);
            for (c cVar : this.f19920b.values()) {
                cVar.c(i2, i3);
            }
        }
    }

    @Override // c.a.r0.m0.h.c
    public void clear() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.a.clear();
            for (c cVar : this.f19920b.values()) {
                cVar.clear();
            }
        }
    }

    @Override // c.a.r0.m0.h.c
    public boolean d(c.a.r0.m0.e.a item, long j2, c.a.r0.m0.j.b displayer, c.a.r0.m0.a config) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048580, this, new Object[]{item, Long.valueOf(j2), displayer, config})) == null) {
            Intrinsics.checkNotNullParameter(item, "item");
            Intrinsics.checkNotNullParameter(displayer, "displayer");
            Intrinsics.checkNotNullParameter(config, "config");
            return f(item).d(item, j2, displayer, config);
        }
        return invokeCommon.booleanValue;
    }

    public int e(c.a.r0.m0.e.a item) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, item)) == null) {
            Intrinsics.checkNotNullParameter(item, "item");
            return item.e().j();
        }
        return invokeL.intValue;
    }

    public final c f(c.a.r0.m0.e.a aVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, aVar)) == null) {
            c cVar = this.f19920b.get(Integer.valueOf(e(aVar)));
            return cVar == null ? this.a : cVar;
        }
        return (c) invokeL.objValue;
    }
}
