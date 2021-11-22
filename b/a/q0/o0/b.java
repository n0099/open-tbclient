package b.a.q0.o0;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public abstract class b {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int FIX_MAX_COST = 5;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean isSwitchOpen;

    public b() {
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
        this.isSwitchOpen = b.a.q0.s.e0.b.j().g("page_stay_duration_switch", false);
    }

    private void updataSwitchStaus(boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(65537, this, z) == null) || this.isSwitchOpen == z) {
            return;
        }
        b.a.q0.s.e0.b.j().t("page_stay_duration_switch", true);
        this.isSwitchOpen = z;
    }

    public boolean canStat(d dVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, dVar)) == null) {
            if (dVar == null || dVar.p()) {
                return false;
            }
            if (dVar.f13529a) {
                dVar.x(c.b(dVar.h(), 6));
            } else {
                int c2 = getMaxCost() > e.b().c() ? e.b().c() : getMaxCost();
                if (c2 > 5) {
                    c2 = 5;
                }
                dVar.x(c.b(dVar.h(), c2));
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public abstract int getMaxCost();

    public abstract boolean isCurrentPageCanBeAddToSourceTrace();

    public boolean isSwitchOpen() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            if (!TbadkCoreApplication.getInst().isMainProcess(true)) {
                return this.isSwitchOpen;
            }
            if (!TbadkCoreApplication.getInst().isPageStayOpen()) {
                updataSwitchStaus(false);
                return false;
            } else if (!e.b().f()) {
                updataSwitchStaus(false);
                return false;
            } else {
                updataSwitchStaus(true);
                return true;
            }
        }
        return invokeV.booleanValue;
    }
}
