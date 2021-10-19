package c.a.r0.h1.j.g;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import c.a.r0.b0.c0;
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
/* loaded from: classes3.dex */
public class c extends c.a.e.l.e.a<c.a.r0.b0.e0.j, CardViewHolder<c.a.r0.b0.k>> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public BdUniqueId m;
    public TbPageContext<?> n;
    public String o;
    public c.a.r0.b0.k p;
    public NEGFeedBackView.b q;
    public c0<c.a.r0.b0.e0.j> r;

    /* loaded from: classes3.dex */
    public class a extends c0<c.a.r0.b0.e0.j> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ c f18596b;

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
            this.f18596b = cVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.r0.b0.c0
        /* renamed from: d */
        public void a(View view, c.a.r0.b0.e0.j jVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view, jVar) == null) {
                int i2 = 2;
                if (this.f18596b.p.A == view) {
                    i2 = 1;
                } else if (view == this.f18596b.p.p.getCommentContainer()) {
                    i2 = 5;
                } else if (view == this.f18596b.p.q.getCommentContainer() || ((this.f18596b.p.R() == null || view.getId() != this.f18596b.p.R().getId()) && (this.f18596b.p.T() == null || view.getId() != this.f18596b.p.T().getId()))) {
                    i2 = 0;
                }
                if (i2 != 0) {
                    c.a.r0.h1.h.m.a.c(jVar.f15721e, this.f18596b.m, jVar.q(), i2);
                }
                c.a.r0.h1.j.c.e(view, jVar, this.f18596b.o);
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
    @Override // c.a.e.l.e.a
    /* renamed from: j0 */
    public CardViewHolder<c.a.r0.b0.k> U(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, viewGroup)) == null) {
            c.a.r0.b0.k kVar = new c.a.r0.b0.k(this.n, this.m);
            this.p = kVar;
            kVar.B(2);
            BdUniqueId bdUniqueId = this.m;
            if (bdUniqueId != null) {
                this.p.e0(bdUniqueId);
            }
            return new CardViewHolder<>(this.p);
        }
        return (CardViewHolder) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.a.e.l.e.a
    /* renamed from: k0 */
    public View a0(int i2, View view, ViewGroup viewGroup, c.a.r0.b0.e0.j jVar, CardViewHolder<c.a.r0.b0.k> cardViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048579, this, new Object[]{Integer.valueOf(i2), view, viewGroup, jVar, cardViewHolder})) == null) {
            jVar.K(jVar.position + 1);
            jVar.f15721e.T1 = jVar.q();
            c.a.r0.b0.k cardView = cardViewHolder.getCardView();
            cardView.g0(i2 + 1);
            cardView.k(jVar);
            cardView.m(this.r);
            cardView.A(this.q);
            c.a.r0.h1.h.m.a.f(jVar.f15721e, this.m, jVar.q());
            c.a.r0.h1.j.c.f(jVar, this.o);
            return cardViewHolder.getView();
        }
        return (View) invokeCommon.objValue;
    }
}
