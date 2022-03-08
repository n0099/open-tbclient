package c.b.b.n.l.h.g;

import c.b.b.n.l.h.b;
import c.b.b.q.o;
import com.badlogic.gdx.utils.JsonValue;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public abstract class a extends b implements o.c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public a() {
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

    @Override // c.b.b.n.l.h.b, c.b.b.q.o.c
    public void a(o oVar, JsonValue jsonValue) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, oVar, jsonValue) == null) {
            ((Integer) oVar.l("minParticleCount", Integer.TYPE, jsonValue)).intValue();
            ((Integer) oVar.l("maxParticleCount", Integer.TYPE, jsonValue)).intValue();
        }
    }
}
