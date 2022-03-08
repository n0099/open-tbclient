package c.a.b0.v.o0;

import c.a.b0.v.c0.p;
import c.a.b0.v.z.h;
import c.a.b0.v.z.n;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.player.event.SystemEvent;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes.dex */
public final class g extends a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public g() {
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

    @Override // c.a.b0.v.f0.j
    public int[] getSubscribeEvent() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? new int[]{1} : (int[]) invokeV.objValue;
    }

    @Override // c.a.b0.v.o0.a, c.a.b0.v.f0.j
    public void n(p event) {
        c.a.b0.v.e it;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, event) == null) {
            Intrinsics.checkNotNullParameter(event, "event");
            if (!Intrinsics.areEqual(SystemEvent.ACTION_VOLUME_CHANGED, event.c()) || (it = i()) == null) {
                return;
            }
            Intrinsics.checkNotNullExpressionValue(it, "player");
            if (it.a0() || it.Q()) {
                it = null;
            }
            if (it != null) {
                int g2 = event.g(5);
                Intrinsics.checkNotNullExpressionValue(it, "it");
                n y = it.y();
                Intrinsics.checkNotNullExpressionValue(y, "it.playerCallbackManager");
                h c2 = y.c();
                if (c2 != null) {
                    c2.a(g2);
                }
            }
        }
    }
}
