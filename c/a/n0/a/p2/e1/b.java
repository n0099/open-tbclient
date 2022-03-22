package c.a.n0.a.p2.e1;

import androidx.annotation.Nullable;
import c.a.n0.w.d;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.nio.channels.Channel;
/* loaded from: classes.dex */
public final class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(@Nullable Channel channel) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65536, null, channel) == null) && channel != null && channel.isOpen()) {
            d.d(channel);
        }
    }
}
