package c.a.r0.l0.i;

import android.graphics.Canvas;
import c.a.r0.l0.k.g;
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
/* loaded from: classes2.dex */
public class c implements a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final a a;

    /* renamed from: b  reason: collision with root package name */
    public final Map<Integer, a> f18888b;

    public c(a defaultRenderer, Pair<Integer, ? extends a>... renderers) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {defaultRenderer, renderers};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        Intrinsics.checkNotNullParameter(defaultRenderer, "defaultRenderer");
        Intrinsics.checkNotNullParameter(renderers, "renderers");
        this.a = defaultRenderer;
        this.f18888b = MapsKt__MapsKt.mutableMapOf((Pair[]) Arrays.copyOf(renderers, renderers.length));
    }

    @Override // c.a.r0.l0.i.a
    public g a(c.a.r0.l0.e.a item, c.a.r0.l0.j.b displayer, c.a.r0.l0.a config) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048576, this, item, displayer, config)) == null) {
            Intrinsics.checkNotNullParameter(item, "item");
            Intrinsics.checkNotNullParameter(displayer, "displayer");
            Intrinsics.checkNotNullParameter(config, "config");
            a aVar = this.f18888b.get(Integer.valueOf(c(item)));
            if (aVar == null) {
                aVar = this.a;
            }
            return aVar.a(item, displayer, config);
        }
        return (g) invokeLLL.objValue;
    }

    @Override // c.a.r0.l0.i.a
    public void b(c.a.r0.l0.e.a item, Canvas canvas, c.a.r0.l0.j.b displayer, c.a.r0.l0.a config) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, item, canvas, displayer, config) == null) {
            Intrinsics.checkNotNullParameter(item, "item");
            Intrinsics.checkNotNullParameter(canvas, "canvas");
            Intrinsics.checkNotNullParameter(displayer, "displayer");
            Intrinsics.checkNotNullParameter(config, "config");
            a aVar = this.f18888b.get(Integer.valueOf(c(item)));
            if (aVar == null) {
                aVar = this.a;
            }
            aVar.b(item, canvas, displayer, config);
        }
    }

    public int c(c.a.r0.l0.e.a item) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, item)) == null) {
            Intrinsics.checkNotNullParameter(item, "item");
            return item.e().g();
        }
        return invokeL.intValue;
    }
}
