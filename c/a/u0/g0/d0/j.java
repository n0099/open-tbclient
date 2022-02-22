package c.a.u0.g0.d0;

import c.a.t0.s.r.e2;
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
/* loaded from: classes8.dex */
public class j extends k {
    public static /* synthetic */ Interceptable $ic;
    public static final BdUniqueId R0;
    public static final BdUniqueId S0;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(395166428, "Lc/a/u0/g0/d0/j;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(395166428, "Lc/a/u0/g0/d0/j;");
                return;
            }
        }
        R0 = BdUniqueId.gen();
        S0 = BdUniqueId.gen();
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
        this.f17886e = e2Var;
    }

    public static boolean X(e2 e2Var) {
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

    public StatisticItem a0(String str) {
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

    @Override // c.a.u0.g0.d0.k, c.a.u0.g0.d0.b, c.a.t0.s.r.a
    public e2 getThreadData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f17886e : (e2) invokeV.objValue;
    }

    @Override // c.a.u0.g0.d0.k, com.baidu.tieba.card.data.BaseCardInfo, c.a.d.o.e.n
    public BdUniqueId getType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            e2 e2Var = this.f17886e;
            if (e2Var != null && e2Var.s1() == 67) {
                return S0;
            }
            return R0;
        }
        return (BdUniqueId) invokeV.objValue;
    }
}
