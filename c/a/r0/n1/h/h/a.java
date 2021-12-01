package c.a.r0.n1.h.h;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.card.holder.CardViewHolder;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class a extends c.a.d.m.e.a<c.a.r0.n1.h.j.b, CardViewHolder<c.a.r0.g0.i>> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext<?> m;
    public c.a.r0.g0.i n;
    public BdUniqueId o;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(TbPageContext<?> tbPageContext) {
        super(tbPageContext.getPageActivity().getBaseContext(), c.a.r0.n1.h.j.d.f20536j);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (BdUniqueId) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.m = tbPageContext;
        c.a.r0.g0.i iVar = new c.a.r0.g0.i(tbPageContext);
        this.n = iVar;
        iVar.K("c10714", "c10739", "c10712", "c10738");
        this.n.setFrom("home");
    }

    public void g0(int i2) {
        c.a.r0.g0.i iVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2) == null) || (iVar = this.n) == null) {
            return;
        }
        iVar.l(this.m, i2);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.a.d.m.e.a
    /* renamed from: h0 */
    public CardViewHolder S(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, viewGroup)) == null) {
            if (this.n == null) {
                c.a.r0.g0.i iVar = new c.a.r0.g0.i(this.m);
                this.n = iVar;
                iVar.G(this.o);
                this.n.K("c10714", "c10739", "c10712", "c10738");
            }
            return new CardViewHolder(this.n);
        }
        return (CardViewHolder) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.a.d.m.e.a
    /* renamed from: i0 */
    public View Z(int i2, View view, ViewGroup viewGroup, c.a.r0.n1.h.j.b bVar, CardViewHolder cardViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048580, this, new Object[]{Integer.valueOf(i2), view, viewGroup, bVar, cardViewHolder})) == null) {
            if (cardViewHolder.getCardView() == null) {
                return null;
            }
            cardViewHolder.getCardView().k(bVar);
            c.a.r0.g0.v.b().a(new StatisticItem("c10714").param(TiebaStatic.Params.OBJ_PARAM3, c.a.r0.g0.m.e()));
            return cardViewHolder.getView();
        }
        return (View) invokeCommon.objValue;
    }

    public void j0(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, bdUniqueId) == null) {
            this.o = bdUniqueId;
            c.a.r0.g0.i iVar = this.n;
            if (iVar != null) {
                iVar.G(bdUniqueId);
            }
        }
    }
}
