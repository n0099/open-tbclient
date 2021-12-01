package c.g;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.fun.ad.sdk.internal.api.PidLoader;
import com.fun.ad.sdk.internal.api.PidLoaderCreator;
import com.fun.ad.sdk.internal.api.config.Ssp;
import com.fun.ad.sdk.internal.api.utils.LogPrinter;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes7.dex */
public class i {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final Map<String, PidLoaderCreator> a;

    /* renamed from: b  reason: collision with root package name */
    public final Map<Ssp.Pid, PidLoader> f28870b;

    public i(Map<String, PidLoaderCreator> map) {
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
        this.f28870b = new HashMap();
        this.a = map;
    }

    public PidLoader a(Ssp.Pid pid) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, pid)) == null) {
            synchronized (this.f28870b) {
                PidLoader pidLoader = this.f28870b.get(pid);
                if (pidLoader != null) {
                    return pidLoader;
                }
                PidLoaderCreator pidLoaderCreator = this.a.get(pid.ssp.type);
                if (pidLoaderCreator == null) {
                    LogPrinter.d("Cannot create PidLoader, because the ssp of pid.type:%s hasn't initialized.", pid.type);
                    return null;
                }
                PidLoader create = pidLoaderCreator.create(pid);
                if (create == null) {
                    LogPrinter.d("The creator of ssp:%s should't create null for pid:%s", pid.ssp.type, pid.type);
                    return null;
                }
                q0 q0Var = new q0(create);
                this.f28870b.put(pid, q0Var);
                return q0Var;
            }
        }
        return (PidLoader) invokeL.objValue;
    }
}
