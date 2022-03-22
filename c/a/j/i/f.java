package c.a.j.i;

import c.a.j.i.g.c;
import com.baidu.bdtask.model.ITaskModelData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
import java.util.Map;
import kotlin.TypeCastException;
/* loaded from: classes.dex */
public final class f {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Map<String, d<? extends ITaskModelData>> a;

    public f() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = new HashMap();
        c.a.j.i.k.a aVar = new c.a.j.i.k.a(this);
        this.a.put(aVar.b(), aVar);
        c cVar = new c(this);
        this.a.put(cVar.b(), cVar);
        c.a.j.i.l.a aVar2 = new c.a.j.i.l.a(this);
        this.a.put(aVar2.c(), aVar2);
        c.a.j.i.i.a aVar3 = new c.a.j.i.i.a(this);
        this.a.put(aVar3.b(), aVar3);
        c.a.j.i.h.a aVar4 = new c.a.j.i.h.a(this);
        this.a.put(aVar4.c(), aVar4);
        c.a.j.i.j.a aVar5 = new c.a.j.i.j.a(this);
        this.a.put(aVar5.b(), aVar5);
        c.a.j.i.e.a aVar6 = new c.a.j.i.e.a(this);
        this.a.put(aVar6.b(), aVar6);
        c.a.j.i.c.a aVar7 = new c.a.j.i.c.a(this);
        this.a.put(aVar7.c(), aVar7);
    }

    public final <T extends ITaskModelData> d<? extends T> a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            if (this.a.get(str) != null) {
                d<? extends ITaskModelData> dVar = this.a.get(str);
                if (dVar != null) {
                    return (d<? extends T>) dVar;
                }
                throw new TypeCastException("null cannot be cast to non-null type com.baidu.bdtask.model.ITaskModelCreator<out T>");
            }
            throw new IllegalArgumentException(("can not find " + str + " model creator!").toString());
        }
        return (d) invokeL.objValue;
    }
}
