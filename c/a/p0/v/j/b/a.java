package c.a.p0.v.j.b;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import c.a.p0.v.j.d.r;
import com.baidu.adp.BdUniqueId;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.card.holder.CardViewHolder;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public class a extends c.a.e.k.e.a<c.a.p0.v.j.d.d, CardViewHolder<c.a.p0.v.j.h.a>> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext m;

    /* renamed from: c.a.p0.v.j.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class View$OnClickListenerC1184a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c.a.p0.v.j.d.d f25289e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ a f25290f;

        public View$OnClickListenerC1184a(a aVar, c.a.p0.v.j.d.d dVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, dVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f25290f = aVar;
            this.f25289e = dVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f25290f.j0(this.f25289e);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(TbPageContext tbPageContext) {
        super(tbPageContext.getPageActivity(), c.a.p0.v.j.d.d.f25338f);
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
    }

    public final void i0(c.a.p0.v.j.d.d dVar, c.a.p0.v.j.h.a aVar) {
        c.a.p0.v.j.d.c g2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, dVar, aVar) == null) || (g2 = dVar.g()) == null || g2.f25337h == null) {
            return;
        }
        aVar.v(8);
        aVar.w(g2.f25337h.f25349a);
        aVar.l(this.m, TbadkCoreApplication.getInst().getSkinType());
    }

    public final void j0(c.a.p0.v.j.d.d dVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, dVar) == null) || dVar == null || dVar.g() == null || dVar.g().f25337h == null) {
            return;
        }
        r rVar = dVar.g().f25337h;
        c.a.o0.m.a.t(this.m.getPageActivity(), true, rVar.f25350b, rVar.f25349a);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.a.e.k.e.a
    /* renamed from: k0 */
    public CardViewHolder<c.a.p0.v.j.h.a> U(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, viewGroup)) == null) ? new CardViewHolder<>(new c.a.p0.v.j.h.a(this.m)) : (CardViewHolder) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.a.e.k.e.a
    /* renamed from: l0 */
    public View a0(int i2, View view, ViewGroup viewGroup, c.a.p0.v.j.d.d dVar, CardViewHolder<c.a.p0.v.j.h.a> cardViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048581, this, new Object[]{Integer.valueOf(i2), view, viewGroup, dVar, cardViewHolder})) == null) {
            if (cardViewHolder.getCardView() == null) {
                return null;
            }
            i0(dVar, cardViewHolder.getCardView());
            cardViewHolder.getCardView().j().setOnClickListener(new View$OnClickListenerC1184a(this, dVar));
            return cardViewHolder.getCardView().j();
        }
        return (View) invokeCommon.objValue;
    }
}
