package b.a.r0.b0.e0;

import b.a.q0.s.q.d2;
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
/* loaded from: classes4.dex */
public class j extends k {
    public static /* synthetic */ Interceptable $ic;
    public static final BdUniqueId P0;
    public static final BdUniqueId Q0;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-139692162, "Lb/a/r0/b0/e0/j;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-139692162, "Lb/a/r0/b0/e0/j;");
                return;
            }
        }
        P0 = BdUniqueId.gen();
        Q0 = BdUniqueId.gen();
    }

    public j(d2 d2Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {d2Var};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f14748e = d2Var;
    }

    public static boolean Y(d2 d2Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, d2Var)) == null) {
            if (d2Var == null) {
                return false;
            }
            if (d2Var.o1() == 49 || d2Var.o1() == 69) {
                return true;
            }
            return d2Var.o1() == 67 && d2Var.l1() != null && d2Var.l1().friendRoomStatus == 2;
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

    @Override // b.a.r0.b0.e0.k, b.a.r0.b0.e0.b, b.a.q0.s.q.a
    public d2 getThreadData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f14748e : (d2) invokeV.objValue;
    }

    @Override // b.a.r0.b0.e0.k, com.baidu.tieba.card.data.BaseCardInfo, b.a.e.l.e.n
    public BdUniqueId getType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            d2 d2Var = this.f14748e;
            if (d2Var != null && d2Var.o1() == 67) {
                return Q0;
            }
            return P0;
        }
        return (BdUniqueId) invokeV.objValue;
    }
}
