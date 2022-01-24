package c.a.t0.g0.f0;

import c.a.s0.s.q.e2;
import com.baidu.adp.BdUniqueId;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class j extends k {
    public static /* synthetic */ Interceptable $ic;
    public static final BdUniqueId U0;
    public static final BdUniqueId V0;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-2101002467, "Lc/a/t0/g0/f0/j;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-2101002467, "Lc/a/t0/g0/f0/j;");
                return;
            }
        }
        U0 = BdUniqueId.gen();
        V0 = BdUniqueId.gen();
    }

    public j(e2 e2Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {e2Var};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f17600e = e2Var;
    }

    public static boolean Y(e2 e2Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, e2Var)) == null) {
            if (e2Var == null) {
                return false;
            }
            if (e2Var.s1() == 49 || e2Var.s1() == 69) {
                return true;
            }
            return e2Var.s1() == 67 && e2Var.p1() != null && e2Var.p1().friendRoomStatus == 2;
        }
        return invokeL.booleanValue;
    }

    public StatisticItem b0(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            StatisticItem i2 = i(str);
            i2.delete("obj_type");
            i2.delete("obj_type");
            i2.param("obj_type", 3);
            return i2;
        }
        return (StatisticItem) invokeL.objValue;
    }

    @Override // c.a.t0.g0.f0.k, c.a.t0.g0.f0.b, c.a.s0.s.q.a
    public e2 getThreadData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f17600e : (e2) invokeV.objValue;
    }

    @Override // c.a.t0.g0.f0.k, com.baidu.tieba.card.data.BaseCardInfo, c.a.d.n.e.n
    public BdUniqueId getType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            e2 e2Var = this.f17600e;
            if (e2Var != null && e2Var.s1() == 67) {
                return V0;
            }
            return U0;
        }
        return (BdUniqueId) invokeV.objValue;
    }
}
