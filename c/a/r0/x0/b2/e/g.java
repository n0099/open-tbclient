package c.a.r0.x0.b2.e;

import android.view.View;
import android.view.ViewGroup;
import c.a.l.l0;
import c.a.r0.x0.k;
import com.baidu.adp.BdUniqueId;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.card.ThreadCardViewHolder;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.card.data.BaseCardInfo;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class g extends k<c.a.r0.x0.b2.g.e, ThreadCardViewHolder<c.a.r0.x0.b2.g.e>> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public g(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2) {
        super(tbPageContext, bdUniqueId);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, bdUniqueId, bdUniqueId2};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((TbPageContext) objArr2[0], (BdUniqueId) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.o = tbPageContext;
        this.f2962i = bdUniqueId2;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.a.e.l.e.a
    /* renamed from: u0 */
    public ThreadCardViewHolder<c.a.r0.x0.b2.g.e> U(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, viewGroup)) == null) {
            l0.b bVar = new l0.b(this.o.getPageActivity(), true);
            bVar.n(new c.a.r0.x0.b2.f.d(this.o.getPageActivity()));
            bVar.l().b(0);
            bVar.l().c(0);
            bVar.l().f(0);
            bVar.l().e(0);
            bVar.l().h(0);
            bVar.l().g(0);
            ThreadCardViewHolder<c.a.r0.x0.b2.g.e> threadCardViewHolder = new ThreadCardViewHolder<>(bVar.k(BaseCardInfo.SupportType.FULL, viewGroup, this.q));
            threadCardViewHolder.setPageId(this.f2962i);
            return threadCardViewHolder;
        }
        return (ThreadCardViewHolder) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.a.r0.x0.k, c.a.e.l.e.a
    /* renamed from: v0 */
    public View a0(int i2, View view, ViewGroup viewGroup, c.a.r0.x0.b2.g.e eVar, ThreadCardViewHolder<c.a.r0.x0.b2.g.e> threadCardViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048579, this, new Object[]{Integer.valueOf(i2), view, viewGroup, eVar, threadCardViewHolder})) == null) {
            threadCardViewHolder.getCardView().q(i2);
            threadCardViewHolder.onBindDataToView(eVar);
            threadCardViewHolder.getCardView().onChangeSkinType(this.o, TbadkCoreApplication.getInst().getSkinType());
            return threadCardViewHolder.getView();
        }
        return (View) invokeCommon.objValue;
    }
}
