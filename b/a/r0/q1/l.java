package b.a.r0.q1;

import com.baidu.adp.BdUniqueId;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.lego.card.adapter.LegoDelegateAdapter;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class l implements b.a.r0.q1.r.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public l() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    @Override // b.a.r0.q1.r.a
    public b.a.r0.q1.p.a a(b.a.r0.q1.p.e eVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, eVar)) == null) ? new b.a.r0.q1.p.c(eVar) : (b.a.r0.q1.p.a) invokeL.objValue;
    }

    @Override // b.a.r0.q1.r.a
    public b.a.r0.q1.o.g.a b(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, int i2) {
        InterceptResult invokeLLI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLI = interceptable.invokeLLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, tbPageContext, bdUniqueId, i2)) == null) ? new LegoDelegateAdapter(tbPageContext, bdUniqueId, i2) : (b.a.r0.q1.o.g.a) invokeLLI.objValue;
    }

    @Override // b.a.r0.q1.r.a
    public b.a.r0.q1.s.a c(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, tbPageContext, bdUniqueId)) == null) ? new b.a.r0.q1.s.c(tbPageContext, bdUniqueId) : (b.a.r0.q1.s.a) invokeLL.objValue;
    }
}
