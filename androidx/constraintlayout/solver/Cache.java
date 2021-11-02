package androidx.constraintlayout.solver;

import androidx.constraintlayout.solver.Pools;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes.dex */
public class Cache {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Pools.Pool<ArrayRow> arrayRowPool;
    public SolverVariable[] mIndexedVariables;
    public Pools.Pool<ArrayRow> optimizedArrayRowPool;
    public Pools.Pool<SolverVariable> solverVariablePool;

    public Cache() {
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
        this.optimizedArrayRowPool = new Pools.SimplePool(256);
        this.arrayRowPool = new Pools.SimplePool(256);
        this.solverVariablePool = new Pools.SimplePool(256);
        this.mIndexedVariables = new SolverVariable[32];
    }
}
