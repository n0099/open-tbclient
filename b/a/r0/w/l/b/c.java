package b.a.r0.w.l.b;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.card.holder.CardViewHolder;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class c extends b.a.e.l.e.a<b.a.r0.w.l.d.f, CardViewHolder<b.a.r0.w.l.h.b>> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext m;

    /* loaded from: classes5.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b.a.r0.w.l.d.f f25136e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ c f25137f;

        public a(c cVar, b.a.r0.w.l.d.f fVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar, fVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f25137f = cVar;
            this.f25136e = fVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f25137f.h0(this.f25136e);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(TbPageContext tbPageContext) {
        super(tbPageContext.getPageActivity(), b.a.r0.w.l.d.f.f25183f);
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

    public final void h0(b.a.r0.w.l.d.f fVar) {
        b.a.r0.w.l.d.c g2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, fVar) == null) || fVar == null || (g2 = fVar.g()) == null || g2.b() == null) {
            return;
        }
        if (!g2.c()) {
            TiebaStatic.log("c11864");
        } else {
            TiebaStatic.log("c11857");
        }
        String p = b.a.q0.s.e0.b.j().p("ala_personal_exp_detail_url", "https://sv.baidu.com/cashliveui/userLevel.html#/level");
        if (p == null) {
            return;
        }
        if (p.endsWith("/")) {
            p = p.substring(0, p.length() - 1);
        }
        b.a.q0.m.a.l(this.m.getPageActivity(), p);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // b.a.e.l.e.a
    /* renamed from: i0 */
    public CardViewHolder<b.a.r0.w.l.h.b> T(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, viewGroup)) == null) ? new CardViewHolder<>(new b.a.r0.w.l.h.b(this.m)) : (CardViewHolder) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // b.a.e.l.e.a
    /* renamed from: j0 */
    public View Z(int i2, View view, ViewGroup viewGroup, b.a.r0.w.l.d.f fVar, CardViewHolder<b.a.r0.w.l.h.b> cardViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048580, this, new Object[]{Integer.valueOf(i2), view, viewGroup, fVar, cardViewHolder})) == null) {
            if (cardViewHolder.getCardView() == null) {
                return null;
            }
            cardViewHolder.getCardView().j(fVar);
            cardViewHolder.getCardView().k(this.m, TbadkCoreApplication.getInst().getSkinType());
            cardViewHolder.getCardView().o.setOnClickListener(new a(this, fVar));
            return cardViewHolder.getCardView().i();
        }
        return (View) invokeCommon.objValue;
    }
}
