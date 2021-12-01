package c.a.r0.n1.c.f;

import c.a.q0.s.q.d2;
import c.a.q0.s.q.v1;
import c.a.q0.s.q.x0;
import com.baidu.adp.BdUniqueId;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
import tbclient.User;
import tbclient.Userlike.ConcernData;
/* loaded from: classes6.dex */
public class a extends v1 {
    public static /* synthetic */ Interceptable $ic;
    public static final Integer l;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: j  reason: collision with root package name */
    public boolean f20200j;

    /* renamed from: k  reason: collision with root package name */
    public List<MetaData> f20201k;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(925570576, "Lc/a/r0/n1/c/f/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(925570576, "Lc/a/r0/n1/c/f/a;");
                return;
            }
        }
        l = 6;
    }

    public a() {
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
        this.f20201k = new ArrayList();
    }

    public static boolean o(ConcernData concernData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, concernData)) == null) {
            if (concernData == null) {
                return false;
            }
            return concernData.recom_type.equals(l);
        }
        return invokeL.booleanValue;
    }

    @Override // c.a.q0.s.q.v1
    public List<MetaData> g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f20201k : (List) invokeV.objValue;
    }

    @Override // c.a.q0.s.q.v1, c.a.q0.s.q.a
    public x0 getNegFeedBackData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? new x0() : (x0) invokeV.objValue;
    }

    @Override // c.a.q0.s.q.v1, c.a.q0.s.q.a
    public d2 getThreadData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return null;
        }
        return (d2) invokeV.objValue;
    }

    @Override // c.a.q0.s.q.v1, com.baidu.tieba.card.data.BaseCardInfo, c.a.d.m.e.n
    public BdUniqueId getType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? v1.f13067i : (BdUniqueId) invokeV.objValue;
    }

    @Override // c.a.q0.s.q.v1
    public void i(List<User> list) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048580, this, list) == null) || list == null) {
            return;
        }
        int min = Math.min(list.size(), 10);
        for (int i2 = 0; i2 < min; i2++) {
            MetaData metaData = new MetaData();
            metaData.parserProtobuf(list.get(i2));
            this.f20201k.add(metaData);
        }
    }

    public boolean k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f20200j : invokeV.booleanValue;
    }

    public void p(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048582, this, z) == null) {
            this.f20200j = z;
        }
    }
}
