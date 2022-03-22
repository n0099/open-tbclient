package c.a.p0.q1.k.g;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import c.a.p0.h0.b0;
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
/* loaded from: classes2.dex */
public class c extends c.a.d.o.e.a<c.a.p0.h0.e0.j, CardViewHolder<c.a.p0.h0.k>> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public BdUniqueId i;
    public TbPageContext<?> j;
    public String k;
    public c.a.p0.h0.k l;
    public NEGFeedBackView.b m;
    public b0<c.a.p0.h0.e0.j> n;

    /* loaded from: classes2.dex */
    public class a extends b0<c.a.p0.h0.e0.j> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ c f17500b;

        public a(c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f17500b = cVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.p0.h0.b0
        /* renamed from: d */
        public void a(View view, c.a.p0.h0.e0.j jVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view, jVar) == null) {
                int i = 2;
                if (this.f17500b.l.w == view) {
                    i = 1;
                } else if (view == this.f17500b.l.l.getCommentContainer()) {
                    i = 5;
                } else if (view == this.f17500b.l.m.getCommentContainer() || ((this.f17500b.l.L() == null || view.getId() != this.f17500b.l.L().getId()) && (this.f17500b.l.N() == null || view.getId() != this.f17500b.l.N().getId()))) {
                    i = 0;
                }
                if (i != 0) {
                    c.a.p0.q1.i.m.a.d(jVar.a, this.f17500b.i, jVar.q(), i);
                }
                c.a.p0.q1.k.c.j(view, jVar, this.f17500b.k);
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (BdUniqueId) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.m = null;
        this.n = new a(this);
        this.j = tbPageContext;
        this.k = str;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.a.d.o.e.a
    /* renamed from: b0 */
    public CardViewHolder<c.a.p0.h0.k> M(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, viewGroup)) == null) {
            c.a.p0.h0.k kVar = new c.a.p0.h0.k(this.j, this.i);
            this.l = kVar;
            kVar.C(2);
            BdUniqueId bdUniqueId = this.i;
            if (bdUniqueId != null) {
                this.l.X(bdUniqueId);
            }
            return new CardViewHolder<>(this.l);
        }
        return (CardViewHolder) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.a.d.o.e.a
    /* renamed from: c0 */
    public View S(int i, View view, ViewGroup viewGroup, c.a.p0.h0.e0.j jVar, CardViewHolder<c.a.p0.h0.k> cardViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048579, this, new Object[]{Integer.valueOf(i), view, viewGroup, jVar, cardViewHolder})) == null) {
            jVar.I(jVar.position + 1);
            jVar.a.statFloor = jVar.q();
            c.a.p0.h0.k c2 = cardViewHolder.c();
            c2.a0(i + 1);
            c2.l(jVar);
            c2.n(this.n);
            c2.B(this.m);
            c.a.p0.q1.i.m.a.h(jVar.a, this.i, jVar.q());
            c.a.p0.q1.k.c.p(jVar, this.k);
            return cardViewHolder.b();
        }
        return (View) invokeCommon.objValue;
    }
}
