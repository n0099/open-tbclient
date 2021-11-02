package b.i.c.a;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.ar.core.AugmentedFace;
import com.google.ar.core.Session;
import java.util.Map;
/* loaded from: classes6.dex */
public final class g {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final Map<Long, AugmentedFace> f32931a;

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
                return;
            }
        }
        this.f32931a = new com.google.ar.core.j(1, 0.75f, true);
    }

    public final synchronized AugmentedFace a(long j, Session session) {
        InterceptResult invokeJL;
        AugmentedFace augmentedFace;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJL = interceptable.invokeJL(1048576, this, j, session)) == null) {
            synchronized (this) {
                augmentedFace = this.f32931a.get(Long.valueOf(j));
                if (augmentedFace == null) {
                    augmentedFace = new AugmentedFace(j, session);
                    this.f32931a.put(Long.valueOf(j), augmentedFace);
                }
            }
            return augmentedFace;
        }
        return (AugmentedFace) invokeJL.objValue;
    }
}
