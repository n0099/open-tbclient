package c.a.q0.i2.k.e;

import c.a.p0.s.q.e1;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.tbadkCore.data.PostData;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public class f0 extends PostData {
    public static /* synthetic */ Interceptable $ic;
    public static final BdUniqueId G0;
    public transient /* synthetic */ FieldHolder $fh;
    public e1 D0;
    public e1 E0;
    public e1 F0;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(900576007, "Lc/a/q0/i2/k/e/f0;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(900576007, "Lc/a/q0/i2/k/e/f0;");
                return;
            }
        }
        G0 = BdUniqueId.gen();
    }

    public f0() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public boolean C0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            e1 e1Var = this.D0;
            if (e1Var == null || StringUtils.isNull(e1Var.f14205b)) {
                e1 e1Var2 = this.E0;
                if (e1Var2 == null || StringUtils.isNull(e1Var2.f14205b)) {
                    e1 e1Var3 = this.F0;
                    return (e1Var3 == null || StringUtils.isNull(e1Var3.f14205b)) ? false : true;
                }
                return true;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.tbadkCore.data.PostData, c.a.e.l.e.n
    public BdUniqueId getType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? G0 : (BdUniqueId) invokeV.objValue;
    }
}
