package c.a.r0.w0;

import c.a.q0.s.q.c2;
import c.a.q0.s.q.d2;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.lego.card.model.ICardInfo;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class a1 implements m0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public a1() {
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

    @Override // c.a.r0.w0.m0
    public c.a.e.l.e.a<? extends c2, ? extends TypeAdapter.ViewHolder> a(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, boolean z) {
        InterceptResult invokeLLZ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLZ = interceptable.invokeLLZ(1048576, this, tbPageContext, bdUniqueId, z)) == null) ? new c.a.r0.w0.n1.d.b0(tbPageContext, d2.T3, bdUniqueId, z) : (c.a.e.l.e.a) invokeLLZ.objValue;
    }

    @Override // c.a.r0.w0.m0
    public k<ICardInfo, ? extends TypeAdapter.ViewHolder> b(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLL = interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, tbPageContext, bdUniqueId, bdUniqueId2)) == null) ? new c.a.r0.w0.c2.a(tbPageContext, bdUniqueId, bdUniqueId2) : (k) invokeLLL.objValue;
    }

    @Override // c.a.r0.w0.m0
    public c.a.e.l.e.a<? extends d2, ? extends TypeAdapter.ViewHolder> c(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{tbPageContext, bdUniqueId, bdUniqueId2, Boolean.valueOf(z)})) == null) {
            if (bdUniqueId == c.a.r0.j3.y.a4) {
                return new c.a.r0.w0.n1.d.d(tbPageContext, bdUniqueId, z);
            }
            if (bdUniqueId == d2.T3) {
                return new c.a.r0.w0.n1.d.c0(tbPageContext, bdUniqueId, bdUniqueId2, z);
            }
            throw new IllegalArgumentException("Unsupported adapter type.");
        }
        return (c.a.e.l.e.a) invokeCommon.objValue;
    }

    @Override // c.a.r0.w0.m0
    public c.a.e.l.e.a<? extends d2, ? extends TypeAdapter.ViewHolder> d(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048579, this, tbPageContext, bdUniqueId, bdUniqueId2)) == null) {
            if (bdUniqueId == d2.U3) {
                return new c.a.r0.w0.n1.d.f(tbPageContext, bdUniqueId, bdUniqueId2);
            }
            throw new IllegalArgumentException("Unsupported adapter type.");
        }
        return (c.a.e.l.e.a) invokeLLL.objValue;
    }
}
