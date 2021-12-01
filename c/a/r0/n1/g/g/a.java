package c.a.r0.n1.g.g;

import c.a.d.m.e.n;
import c.a.r0.n1.g.b;
import c.a.r0.n1.g.c;
import com.baidu.adp.BdUniqueId;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
/* loaded from: classes6.dex */
public class a implements b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public c a;

    /* renamed from: b  reason: collision with root package name */
    public c.a.r0.n1.g.a f20409b;

    public a(c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {cVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = cVar;
        this.f20409b = new c.a.r0.n1.g.f.a(this);
    }

    @Override // c.a.r0.n1.g.b
    public boolean a(BdUniqueId bdUniqueId, String str, String str2, String str3) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048576, this, bdUniqueId, str, str2, str3)) == null) {
            c.a.r0.n1.g.a aVar = this.f20409b;
            if (aVar != null) {
                return aVar.a(bdUniqueId, str, str2, str3);
            }
            return false;
        }
        return invokeLLLL.booleanValue;
    }

    @Override // c.a.r0.n1.g.b
    public boolean b(int i2, c.a.r0.n1.g.e.a aVar) {
        InterceptResult invokeIL;
        c cVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, aVar)) == null) {
            if (aVar == null || (cVar = this.a) == null) {
                return false;
            }
            cVar.setData(aVar.getDataList());
            return true;
        }
        return invokeIL.booleanValue;
    }

    @Override // c.a.r0.n1.g.b
    public boolean c(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2)) == null) {
            c cVar = this.a;
            if (cVar != null) {
                cVar.b(i2);
                return true;
            }
            return false;
        }
        return invokeI.booleanValue;
    }

    @Override // c.a.r0.n1.g.b
    public void setData(List<n> list) {
        c cVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, list) == null) || (cVar = this.a) == null) {
            return;
        }
        cVar.setData(list);
    }
}
