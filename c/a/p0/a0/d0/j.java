package c.a.p0.a0.d0;

import c.a.o0.s.q.c2;
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
/* loaded from: classes3.dex */
public class j extends k {
    public static /* synthetic */ Interceptable $ic;
    public static final BdUniqueId P0;
    public static final BdUniqueId Q0;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1076938787, "Lc/a/p0/a0/d0/j;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1076938787, "Lc/a/p0/a0/d0/j;");
                return;
            }
        }
        P0 = BdUniqueId.gen();
        Q0 = BdUniqueId.gen();
    }

    public j(c2 c2Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {c2Var};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f14959e = c2Var;
    }

    public static boolean Y(c2 c2Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, c2Var)) == null) {
            if (c2Var == null) {
                return false;
            }
            if (c2Var.m1() == 49 || c2Var.m1() == 69) {
                return true;
            }
            return c2Var.m1() == 67 && c2Var.j1() != null && c2Var.j1().friendRoomStatus == 2;
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

    @Override // c.a.p0.a0.d0.k, c.a.p0.a0.d0.b, c.a.o0.s.q.a
    public c2 getThreadData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f14959e : (c2) invokeV.objValue;
    }

    @Override // c.a.p0.a0.d0.k, com.baidu.tieba.card.data.BaseCardInfo, c.a.e.k.e.n
    public BdUniqueId getType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            c2 c2Var = this.f14959e;
            if (c2Var != null && c2Var.m1() == 67) {
                return Q0;
            }
            return P0;
        }
        return (BdUniqueId) invokeV.objValue;
    }
}
