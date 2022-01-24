package c.a.t0.m0.h;

import c.a.t0.m0.h.i.a;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes7.dex */
public abstract class a implements c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final c.a.t0.m0.h.i.a a;

    /* renamed from: b  reason: collision with root package name */
    public final a.InterfaceC1214a f19525b;

    public a(c.a.t0.m0.h.i.a retainer, a.InterfaceC1214a locator) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {retainer, locator};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        Intrinsics.checkNotNullParameter(retainer, "retainer");
        Intrinsics.checkNotNullParameter(locator, "locator");
        this.a = retainer;
        this.f19525b = locator;
    }

    @Override // c.a.t0.m0.h.c
    public void a(c.a.t0.m0.e.a item, long j2, c.a.t0.m0.j.b displayer, c.a.t0.m0.a config) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{item, Long.valueOf(j2), displayer, config}) == null) {
            Intrinsics.checkNotNullParameter(item, "item");
            Intrinsics.checkNotNullParameter(displayer, "displayer");
            Intrinsics.checkNotNullParameter(config, "config");
            this.f19525b.a(item, j2, displayer, config);
        }
    }

    @Override // c.a.t0.m0.h.c
    public void b(c.a.t0.m0.e.a item) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, item) == null) {
            Intrinsics.checkNotNullParameter(item, "item");
            this.a.b(item);
        }
    }

    @Override // c.a.t0.m0.h.c
    public void c(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(Constants.METHOD_SEND_USER_MSG, this, i2, i3) == null) {
            this.a.update(i2, i3);
        }
    }

    @Override // c.a.t0.m0.h.c
    public void clear() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.a.clear();
        }
    }

    @Override // c.a.t0.m0.h.c
    public boolean d(c.a.t0.m0.e.a item, long j2, c.a.t0.m0.j.b displayer, c.a.t0.m0.a config) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048580, this, new Object[]{item, Long.valueOf(j2), displayer, config})) == null) {
            Intrinsics.checkNotNullParameter(item, "item");
            Intrinsics.checkNotNullParameter(displayer, "displayer");
            Intrinsics.checkNotNullParameter(config, "config");
            item.f().B(this.a.a(item, j2, displayer, config));
            return item.f().p();
        }
        return invokeCommon.booleanValue;
    }
}
