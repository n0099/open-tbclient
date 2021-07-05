package a.a.a.a;

import a.a.a.a.v.e;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes.dex */
public class p {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final Map<String, a> f1100a;

    /* renamed from: b  reason: collision with root package name */
    public final Map<e.a, n> f1101b;

    /* loaded from: classes.dex */
    public interface a {
        n a(e.a aVar);
    }

    public p(Map<String, a> map) {
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
        this.f1101b = new HashMap();
        this.f1100a = map;
    }

    public n a(e.a aVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, aVar)) == null) {
            synchronized (this.f1101b) {
                n nVar = this.f1101b.get(aVar);
                if (nVar != null) {
                    return nVar;
                }
                a aVar2 = this.f1100a.get(aVar.k.f1342c);
                if (aVar2 == null) {
                    a.a.a.a.y.d.a("Cannot create PidLoader, because the ssp of pid.type:%s hasn't initialized.", aVar.f1346d);
                    return null;
                }
                n a2 = aVar2.a(aVar);
                if (a2 == null) {
                    a.a.a.a.y.d.a("The creator of ssp:%s should't create null for pid:%s", aVar.k.f1342c, aVar.f1346d);
                    return null;
                }
                e eVar = new e(a2);
                this.f1101b.put(aVar, eVar);
                return eVar;
            }
        }
        return (n) invokeL.objValue;
    }
}
