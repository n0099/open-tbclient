package c.a.q0.s.q;

import com.baidu.adp.BdUniqueId;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import tbclient.RecommendInfo;
import tbclient.SchoolRecomUserInfo;
/* loaded from: classes5.dex */
public class t1 extends d2 {
    public static /* synthetic */ Interceptable $ic;
    public static final BdUniqueId e4;
    public transient /* synthetic */ FieldHolder $fh;
    public String c4;
    public ArrayList<u1> d4;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-573962726, "Lc/a/q0/s/q/t1;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-573962726, "Lc/a/q0/s/q/t1;");
                return;
            }
        }
        e4 = BdUniqueId.gen();
    }

    public t1() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.c4 = "";
        this.d4 = new ArrayList<>();
    }

    public ArrayList<u1> T4() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.d4 : (ArrayList) invokeV.objValue;
    }

    public void U4(RecommendInfo recommendInfo) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, recommendInfo) == null) || recommendInfo == null) {
            return;
        }
        this.c4 = recommendInfo.title;
        for (SchoolRecomUserInfo schoolRecomUserInfo : recommendInfo.user_list) {
            if (schoolRecomUserInfo != null) {
                u1 u1Var = new u1();
                u1Var.f(schoolRecomUserInfo);
                this.d4.add(u1Var);
            }
        }
    }

    @Override // c.a.q0.s.q.d2
    public String getTitle() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.c4 : (String) invokeV.objValue;
    }

    @Override // c.a.q0.s.q.d2, com.baidu.tieba.card.data.BaseCardInfo, c.a.d.m.e.n
    public BdUniqueId getType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? e4 : (BdUniqueId) invokeV.objValue;
    }
}
