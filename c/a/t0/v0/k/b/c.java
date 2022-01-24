package c.a.t0.v0.k.b;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import c.a.t0.g0.d0;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.card.holder.CardViewHolder;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes8.dex */
public class c extends c.a.d.n.e.a<c.a.t0.v0.k.c.d, CardViewHolder<c.a.t0.v0.k.d.c>> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext<?> m;
    public d0 n;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(TbPageContext tbPageContext, d0 d0Var) {
        super(tbPageContext.getPageActivity(), c.a.t0.v0.k.c.d.f24387j);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, d0Var};
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
        this.n = d0Var;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.a.d.n.e.a
    /* renamed from: Z */
    public CardViewHolder<c.a.t0.v0.k.d.c> M(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, viewGroup)) == null) {
            c.a.t0.v0.k.d.c cVar = new c.a.t0.v0.k.d.c(this.m);
            cVar.n(this.f3364i);
            return new CardViewHolder<>(cVar);
        }
        return (CardViewHolder) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.a.d.n.e.a
    /* renamed from: a0 */
    public View S(int i2, View view, ViewGroup viewGroup, c.a.t0.v0.k.c.d dVar, CardViewHolder<c.a.t0.v0.k.d.c> cardViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048579, this, new Object[]{Integer.valueOf(i2), view, viewGroup, dVar, cardViewHolder})) == null) {
            if (dVar == null || cardViewHolder == null || cardViewHolder.getCardView() == null) {
                return null;
            }
            if (viewGroup instanceof BdTypeRecyclerView) {
                cardViewHolder.getCardView().s(dVar.needTopMargin);
            }
            cardViewHolder.getCardView().k(dVar);
            if (this.n != null) {
                cardViewHolder.getCardView().m(this.n);
            }
            return cardViewHolder.getView();
        }
        return (View) invokeCommon.objValue;
    }
}
