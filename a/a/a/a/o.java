package a.a.a.a;

import a.a.a.a.s.h;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes.dex */
public class o {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final Map<String, a> f1092a;

    /* renamed from: b  reason: collision with root package name */
    public final Map<h.a, m> f1093b;

    /* loaded from: classes.dex */
    public interface a {
        m a(h.a aVar);
    }

    public o(Map<String, a> map) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {map};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f1093b = new HashMap();
        this.f1092a = map;
    }

    public m a(h.a aVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, aVar)) == null) {
            synchronized (this.f1093b) {
                m mVar = this.f1093b.get(aVar);
                if (mVar != null) {
                    return mVar;
                }
                a aVar2 = this.f1092a.get(aVar.l.f1358c);
                if (aVar2 == null) {
                    a.a.a.a.v.d.a("Cannot create PidLoader, because the ssp of pid.type:%s hasn't initialized.", aVar.f1362d);
                    return null;
                }
                m a2 = aVar2.a(aVar);
                if (a2 == null) {
                    a.a.a.a.v.d.a("The creator of ssp:%s should't create null for pid:%s", aVar.l.f1358c, aVar.f1362d);
                    return null;
                }
                d dVar = new d(a2);
                this.f1093b.put(aVar, dVar);
                return dVar;
            }
        }
        return (m) invokeL.objValue;
    }
}
