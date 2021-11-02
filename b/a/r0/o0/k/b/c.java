package b.a.r0.o0.k.b;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import b.a.r0.b0.c0;
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
/* loaded from: classes5.dex */
public class c extends b.a.e.l.e.a<b.a.r0.o0.k.c.d, CardViewHolder<b.a.r0.o0.k.d.c>> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext<?> m;
    public c0 n;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(TbPageContext tbPageContext, c0 c0Var) {
        super(tbPageContext.getPageActivity(), b.a.r0.o0.k.c.d.j);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, c0Var};
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
        this.n = c0Var;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // b.a.e.l.e.a
    /* renamed from: g0 */
    public CardViewHolder<b.a.r0.o0.k.d.c> T(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, viewGroup)) == null) {
            b.a.r0.o0.k.d.c cVar = new b.a.r0.o0.k.d.c(this.m);
            cVar.m(this.f2423i);
            return new CardViewHolder<>(cVar);
        }
        return (CardViewHolder) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // b.a.e.l.e.a
    /* renamed from: h0 */
    public View Z(int i2, View view, ViewGroup viewGroup, b.a.r0.o0.k.c.d dVar, CardViewHolder<b.a.r0.o0.k.d.c> cardViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048579, this, new Object[]{Integer.valueOf(i2), view, viewGroup, dVar, cardViewHolder})) == null) {
            if (dVar == null || cardViewHolder == null || cardViewHolder.getCardView() == null) {
                return null;
            }
            if (viewGroup instanceof BdTypeRecyclerView) {
                cardViewHolder.getCardView().q(dVar.needTopMargin);
            }
            cardViewHolder.getCardView().j(dVar);
            if (this.n != null) {
                cardViewHolder.getCardView().l(this.n);
            }
            return cardViewHolder.getView();
        }
        return (View) invokeCommon.objValue;
    }
}
