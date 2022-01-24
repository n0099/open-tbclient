package c.a.t0.p1.j.g;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import c.a.t0.g0.d0;
import com.baidu.adp.BdUniqueId;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.NEGFeedBack.NEGFeedBackView;
import com.baidu.tieba.card.holder.CardViewHolder;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes8.dex */
public class c extends c.a.d.n.e.a<c.a.t0.g0.f0.j, CardViewHolder<c.a.t0.g0.k>> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public BdUniqueId m;
    public TbPageContext<?> n;
    public String o;
    public c.a.t0.g0.k p;
    public NEGFeedBackView.b q;
    public d0<c.a.t0.g0.f0.j> r;

    /* loaded from: classes8.dex */
    public class a extends d0<c.a.t0.g0.f0.j> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ c f20929b;

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
            this.f20929b = cVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.t0.g0.d0
        /* renamed from: d */
        public void a(View view, c.a.t0.g0.f0.j jVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view, jVar) == null) {
                int i2 = 2;
                if (this.f20929b.p.A == view) {
                    i2 = 1;
                } else if (view == this.f20929b.p.p.getCommentContainer()) {
                    i2 = 5;
                } else if (view == this.f20929b.p.q.getCommentContainer() || ((this.f20929b.p.K() == null || view.getId() != this.f20929b.p.K().getId()) && (this.f20929b.p.M() == null || view.getId() != this.f20929b.p.M().getId()))) {
                    i2 = 0;
                }
                if (i2 != 0) {
                    c.a.t0.p1.h.m.a.c(jVar.f17600e, this.f20929b.m, jVar.q(), i2);
                }
                c.a.t0.p1.j.c.j(view, jVar, this.f20929b.o);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, String str) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, bdUniqueId, str};
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
        this.q = null;
        this.r = new a(this);
        this.n = tbPageContext;
        this.o = str;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.a.d.n.e.a
    /* renamed from: b0 */
    public CardViewHolder<c.a.t0.g0.k> M(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, viewGroup)) == null) {
            c.a.t0.g0.k kVar = new c.a.t0.g0.k(this.n, this.m);
            this.p = kVar;
            kVar.B(2);
            BdUniqueId bdUniqueId = this.m;
            if (bdUniqueId != null) {
                this.p.W(bdUniqueId);
            }
            return new CardViewHolder<>(this.p);
        }
        return (CardViewHolder) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.a.d.n.e.a
    /* renamed from: c0 */
    public View S(int i2, View view, ViewGroup viewGroup, c.a.t0.g0.f0.j jVar, CardViewHolder<c.a.t0.g0.k> cardViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048579, this, new Object[]{Integer.valueOf(i2), view, viewGroup, jVar, cardViewHolder})) == null) {
            jVar.K(jVar.position + 1);
            jVar.f17600e.T1 = jVar.q();
            c.a.t0.g0.k cardView = cardViewHolder.getCardView();
            cardView.Z(i2 + 1);
            cardView.k(jVar);
            cardView.m(this.r);
            cardView.A(this.q);
            c.a.t0.p1.h.m.a.f(jVar.f17600e, this.m, jVar.q());
            c.a.t0.p1.j.c.p(jVar, this.o);
            return cardViewHolder.getView();
        }
        return (View) invokeCommon.objValue;
    }
}
