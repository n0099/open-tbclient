package c.a.u0.p1.i.h;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import c.a.l.d;
import c.a.l.l0;
import c.a.l.n0;
import c.a.l.w0.a;
import com.baidu.adp.BdUniqueId;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.card.ThreadCardViewHolder;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.ThreadCardUtils;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.NEGFeedBack.NEGFeedBackView;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes8.dex */
public class l extends c.a.u0.p1.a<c.a.u0.g0.d0.k, ThreadCardViewHolder<c.a.u0.g0.d0.k>> implements c.a.u0.t.f {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public BdUniqueId n;
    public TbPageContext<?> o;
    public NEGFeedBackView.b p;
    public String q;
    public boolean r;
    public c.a.u0.g0.b0<c.a.u0.g0.d0.k> s;

    /* loaded from: classes8.dex */
    public class a extends c.a.u0.g0.b0<c.a.u0.g0.d0.k> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ l f20707b;

        public a(l lVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {lVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f20707b = lVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.u0.g0.b0
        /* renamed from: d */
        public void a(View view, c.a.u0.g0.d0.k kVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view, kVar) == null) {
                int i2 = 1;
                c.a.u0.g0.u.b().d(true);
                c.a.u0.t.d.c().h("page_recommend", "show_");
                if (kVar == null || kVar.getThreadData() == null || c.a.d.f.p.m.isEmpty(kVar.getThreadData().w1())) {
                    return;
                }
                int id = view.getId();
                if (id == R.id.thread_card_root) {
                    TiebaStatic.log(kVar.A());
                    c.a.u0.t.d.c().i("page_recommend", "clk_", kVar.A());
                    c.a.u0.p1.i.m.a.b(kVar.f17886e, kVar.t(), kVar.q(), 1);
                } else if (id == R.id.thread_info_commont_container) {
                    TiebaStatic.log(kVar.A());
                    c.a.u0.t.d.c().i("page_recommend", "clk_", kVar.A());
                    c.a.u0.p1.i.m.a.b(kVar.f17886e, kVar.t(), kVar.q(), 1);
                    i2 = 5;
                } else {
                    if (id == R.id.thread_card_voice) {
                        TiebaStatic.log(kVar.U());
                        c.a.u0.t.d.c().i("page_recommend", "clk_", kVar.U());
                    } else {
                        if (id == R.id.user_avatar) {
                            TiebaStatic.log(kVar.T());
                            c.a.u0.t.d.c().i("page_recommend", "clk_", kVar.T());
                            c.a.u0.p1.i.m.a.b(kVar.f17886e, kVar.t(), kVar.q(), 4);
                        } else if (id == R.id.user_name) {
                            TiebaStatic.log(kVar.T());
                            c.a.u0.t.d.c().i("page_recommend", "clk_", kVar.T());
                            c.a.u0.p1.i.m.a.b(kVar.f17886e, kVar.t(), kVar.q(), 4);
                        } else if (id == R.id.forum_name_text) {
                            TiebaStatic.log(kVar.o());
                            c.a.u0.t.d.c().i("page_recommend", "clk_", kVar.o());
                        } else if (id == R.id.god_reply_voice_btn) {
                            StatisticItem statisticItem = new StatisticItem("c10760");
                            statisticItem.param("obj_locate", 4);
                            TiebaStatic.log(statisticItem);
                        } else if (id == R.id.god_reply_content) {
                            StatisticItem statisticItem2 = new StatisticItem("c10760");
                            statisticItem2.param("obj_locate", 2);
                            TiebaStatic.log(statisticItem2);
                            c.a.u0.p1.i.m.a.b(kVar.f17886e, kVar.t(), kVar.q(), 1);
                        } else if (id != R.id.god_reply_user_pendant_header && id != R.id.god_reply_username_text) {
                            if (view instanceof TbImageView) {
                                if (view.getTag(R.id.god_reply_image_layout) instanceof Integer) {
                                    StatisticItem statisticItem3 = new StatisticItem("c10760");
                                    statisticItem3.param("obj_locate", 3);
                                    TiebaStatic.log(statisticItem3);
                                }
                                TiebaStatic.log(kVar.Q());
                                c.a.u0.t.d.c().i("page_recommend", "clk_", kVar.Q());
                                c.a.u0.p1.i.m.a.b(kVar.f17886e, kVar.t(), kVar.q(), 2);
                            }
                        } else {
                            StatisticItem statisticItem4 = new StatisticItem("c10760");
                            statisticItem4.param("obj_locate", 1);
                            TiebaStatic.log(statisticItem4);
                        }
                        i2 = 2;
                    }
                    i2 = 0;
                }
                if (i2 != 0) {
                    c.a.u0.p1.i.m.a.c(kVar.f17886e, this.f20707b.n, kVar.q(), i2);
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public class b implements d.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public b(l lVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {lVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // c.a.l.d.b
        public void a(c.a.t0.s.r.a aVar, View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLL(1048576, this, aVar, view) == null) || aVar == null) {
                return;
            }
            if (view.getId() == R.id.user_name) {
                aVar.objType = 3;
            } else if (view.getId() == R.id.user_avatar) {
                aVar.objType = 4;
            } else {
                aVar.objType = 1;
            }
        }
    }

    /* loaded from: classes8.dex */
    public class c implements c.a.d.o.e.v {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ l f20708e;

        public c(l lVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {lVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f20708e = lVar;
        }

        @Override // c.a.d.o.e.v
        public void b(View view, c.a.d.o.e.n nVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i2, long j2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{view, nVar, bdUniqueId, viewGroup, Integer.valueOf(i2), Long.valueOf(j2)}) == null) && (nVar instanceof c.a.u0.g0.d0.k) && (view.getTag() instanceof ThreadCardViewHolder)) {
                ThreadCardViewHolder threadCardViewHolder = (ThreadCardViewHolder) view.getTag();
                c.a.u0.g0.d0.k kVar = (c.a.u0.g0.d0.k) nVar;
                kVar.f17891j = 1;
                if (this.f20708e.s != null) {
                    this.f20708e.s.a(threadCardViewHolder.getView(), kVar);
                }
                ThreadCardUtils.jumpToPB((c.a.t0.s.r.a) kVar, view.getContext(), 2, false);
                threadCardViewHolder.getCardView().o(new a.C0210a(1));
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public l(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, bdUniqueId};
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
        this.p = null;
        this.r = true;
        this.s = new a(this);
        this.o = tbPageContext;
        b0();
    }

    public final void b0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            c.a.u0.g0.d0.k.V = "c10705";
            c.a.u0.g0.d0.k.W = "c10730";
            c.a.u0.g0.d0.k.X = "c10731";
            c.a.u0.g0.d0.k.Y = "c10704";
            c.a.u0.g0.d0.k.Z = "c10755";
            c.a.u0.g0.d0.k.a0 = "c10710";
            c.a.u0.g0.d0.k.b0 = "c10736";
            c.a.u0.g0.d0.k.c0 = "c10737";
            c.a.u0.g0.d0.k.d0 = "c10711";
            c.a.u0.g0.d0.k.e0 = "c10758";
            c.a.u0.g0.d0.k.f0 = "c10757";
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.a.d.o.e.a
    /* renamed from: c0 */
    public ThreadCardViewHolder<c.a.u0.g0.d0.k> M(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, viewGroup)) == null) {
            l0.b bVar = new l0.b(this.o.getPageActivity());
            c.a.l.d dVar = new c.a.l.d(this.o.getPageActivity());
            dVar.s(this.n);
            dVar.b(1024);
            dVar.r(new b(this));
            bVar.o(dVar);
            bVar.n(new c.a.l.t(this.o.getPageActivity()));
            bVar.h(new c.a.l.k(this.o.getPageActivity()));
            c.a.l.n nVar = new c.a.l.n(this.o.getPageActivity());
            nVar.w(this.r);
            nVar.v("index");
            nVar.x(new StatisticItem("c13342"));
            bVar.h(nVar);
            n0 n0Var = new n0(this.o.getPageActivity());
            c.a.t0.s.r.f fVar = new c.a.t0.s.r.f();
            fVar.f13841b = 1;
            fVar.f13847h = 1;
            n0Var.u(fVar);
            n0Var.v(1);
            n0Var.z(3);
            n0Var.w(2);
            bVar.m(n0Var);
            l0 i2 = bVar.i();
            i2.r(2);
            ThreadCardViewHolder<c.a.u0.g0.d0.k> threadCardViewHolder = new ThreadCardViewHolder<>(i2);
            threadCardViewHolder.setPageId(this.n);
            V(new c(this));
            return threadCardViewHolder;
        }
        return (ThreadCardViewHolder) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.a.d.o.e.a
    /* renamed from: d0 */
    public View S(int i2, View view, ViewGroup viewGroup, c.a.u0.g0.d0.k kVar, ThreadCardViewHolder<c.a.u0.g0.d0.k> threadCardViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048580, this, new Object[]{Integer.valueOf(i2), view, viewGroup, kVar, threadCardViewHolder})) == null) {
            if (kVar == null || threadCardViewHolder == null || threadCardViewHolder.getCardView() == null) {
                return null;
            }
            kVar.J(kVar.position + 1);
            kVar.f17886e.T1 = kVar.q();
            c.a.u0.g0.u.b().a(kVar.P("c12190"));
            if (threadCardViewHolder.getCardView() instanceof c.a.u0.t.e) {
                threadCardViewHolder.getCardView().d(this.q);
            }
            c.a.l.b0 showNEGFeedBackView = threadCardViewHolder.showNEGFeedBackView(true);
            showNEGFeedBackView.t(this.p);
            threadCardViewHolder.showFollowUserDecorItemIfNeed(kVar.showFollowBtn(), this.m);
            showNEGFeedBackView.onBindDataToView(kVar.getNegFeedBackData());
            threadCardViewHolder.onBindDataToView(kVar);
            threadCardViewHolder.setOnSubCardClickListener(this.s);
            threadCardViewHolder.getCardView().onChangeSkinType(this.o, TbadkCoreApplication.getInst().getSkinType());
            c.a.u0.p1.i.m.a.f(kVar.f17886e, this.n, kVar.q());
            c.a.u0.p1.i.m.a.e(kVar.f17886e, kVar.t(), kVar.q());
            return threadCardViewHolder.getView();
        }
        return (View) invokeCommon.objValue;
    }

    public void e0(NEGFeedBackView.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, bVar) == null) {
            this.p = bVar;
        }
    }

    @Override // c.a.u0.t.f
    public void g(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, str) == null) {
            this.q = str;
        }
    }

    public void setFromCDN(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048583, this, z) == null) {
            this.r = z;
        }
    }
}
