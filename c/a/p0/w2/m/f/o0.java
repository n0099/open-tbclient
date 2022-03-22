package c.a.p0.w2.m.f;

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
public class o0 extends PostData {
    public static /* synthetic */ Interceptable $ic;
    public static final BdUniqueId H0;
    public transient /* synthetic */ FieldHolder $fh;
    public c.a.o0.r.r.c1 E0;
    public c.a.o0.r.r.c1 F0;
    public c.a.o0.r.r.c1 G0;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(218729476, "Lc/a/p0/w2/m/f/o0;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(218729476, "Lc/a/p0/w2/m/f/o0;");
                return;
            }
        }
        H0 = BdUniqueId.gen();
    }

    public o0() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public boolean J0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            c.a.o0.r.r.c1 c1Var = this.E0;
            if (c1Var == null || StringUtils.isNull(c1Var.f10824b)) {
                c.a.o0.r.r.c1 c1Var2 = this.F0;
                if (c1Var2 == null || StringUtils.isNull(c1Var2.f10824b)) {
                    c.a.o0.r.r.c1 c1Var3 = this.G0;
                    return (c1Var3 == null || StringUtils.isNull(c1Var3.f10824b)) ? false : true;
                }
                return true;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.tbadkCore.data.PostData, c.a.d.o.e.n
    public BdUniqueId getType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? H0 : (BdUniqueId) invokeV.objValue;
    }
}
