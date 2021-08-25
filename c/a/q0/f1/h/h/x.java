package c.a.q0.f1.h.h;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import c.a.l.a;
import c.a.l.d;
import c.a.l.g0;
import c.a.l.l0;
import c.a.l.n0;
import c.a.l.p0;
import c.a.l.s0;
import c.a.l.v0.a;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.card.ThreadCardViewHolder;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.ThreadCardUtils;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.NEGFeedBack.NEGFeedBackView;
import com.baidu.tieba.R;
import com.baidu.tieba.card.data.BaseCardInfo;
import com.baidu.tieba.frs.FrsFragment;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public class x extends c.a.q0.f1.a<c.a.q0.a0.d0.k, ThreadCardViewHolder<c.a.q0.a0.d0.k>> implements c.a.q0.o.f {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public BdUniqueId n;
    public TbPageContext<?> o;
    public NEGFeedBackView.b p;
    public String q;
    public c.a.e.l.e.s r;
    public c.a.q0.a0.b0<c.a.q0.a0.d0.k> s;

    /* loaded from: classes3.dex */
    public class a extends c.a.q0.a0.b0<c.a.q0.a0.d0.k> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ x f17798b;

        public a(x xVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {xVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f17798b = xVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.q0.a0.b0
        /* renamed from: d */
        public void a(View view, c.a.q0.a0.d0.k kVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view, kVar) == null) {
                int i2 = 1;
                c.a.q0.a0.t.b().d(true);
                c.a.q0.o.d.c().h("page_recommend", "show_");
                if (view == null || kVar == null || kVar.getThreadData() == null || StringUtils.isNull(kVar.getThreadData().q1())) {
                    return;
                }
                int id = view.getId();
                if (id != R.id.thread_card_root && id != R.id.thread_info_commont_container) {
                    if (id == R.id.thread_card_voice) {
                        TiebaStatic.log(kVar.V());
                        c.a.q0.o.d.c().i("page_recommend", "clk_", kVar.V());
                    } else {
                        if (id == R.id.user_avatar) {
                            TiebaStatic.log(kVar.U());
                            c.a.q0.o.d.c().i("page_recommend", "clk_", kVar.U());
                            c.a.q0.f1.h.m.a.b(kVar.f15245e, kVar.t(), kVar.q(), 4);
                        } else if (id == R.id.user_name) {
                            TiebaStatic.log(kVar.U());
                            c.a.q0.o.d.c().i("page_recommend", "clk_", kVar.U());
                            c.a.q0.f1.h.m.a.b(kVar.f15245e, kVar.t(), kVar.q(), 4);
                        } else if (id == R.id.forum_name_text) {
                            TiebaStatic.log(kVar.o());
                            c.a.q0.o.d.c().i("page_recommend", "clk_", kVar.o());
                        } else if (id == R.id.god_reply_voice_btn) {
                            StatisticItem statisticItem = new StatisticItem("c10760");
                            statisticItem.param("obj_locate", 4);
                            TiebaStatic.log(statisticItem);
                        } else if (id == R.id.god_reply_content) {
                            StatisticItem statisticItem2 = new StatisticItem("c10760");
                            statisticItem2.param("obj_locate", 2);
                            TiebaStatic.log(statisticItem2);
                            c.a.q0.f1.h.m.a.b(kVar.f15245e, kVar.t(), kVar.q(), 1);
                        } else if (id != R.id.god_reply_user_pendant_header && id != R.id.god_reply_username_text) {
                            if (view instanceof TbImageView) {
                                if (view.getTag(R.id.god_reply_image_layout) instanceof Integer) {
                                    StatisticItem statisticItem3 = new StatisticItem("c10760");
                                    statisticItem3.param("obj_locate", 3);
                                    TiebaStatic.log(statisticItem3);
                                }
                                TiebaStatic.log(kVar.R());
                                c.a.q0.o.d.c().i("page_recommend", "clk_", kVar.R());
                                c.a.q0.f1.h.m.a.b(kVar.f15245e, kVar.t(), kVar.q(), 2);
                            }
                        } else {
                            StatisticItem statisticItem4 = new StatisticItem("c10760");
                            statisticItem4.param("obj_locate", 1);
                            TiebaStatic.log(statisticItem4);
                        }
                        i2 = 2;
                    }
                    i2 = 0;
                } else {
                    TiebaStatic.log(kVar.S("c12642"));
                    c.a.q0.o.d.c().i("page_recommend", "clk_", kVar.A());
                    c.a.q0.f1.h.m.a.b(kVar.f15245e, kVar.t(), kVar.q(), 1);
                }
                if (i2 != 0) {
                    c.a.q0.f1.h.m.a.c(kVar.f15245e, this.f17798b.n, kVar.q(), i2);
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b implements d.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public b(x xVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {xVar};
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
        public void a(c.a.p0.s.q.a aVar, View view) {
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

    /* loaded from: classes3.dex */
    public class c implements a.InterfaceC0094a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ s0 f17799a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ x f17800b;

        public c(x xVar, s0 s0Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {xVar, s0Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f17800b = xVar;
            this.f17799a = s0Var;
        }

        @Override // c.a.l.a.InterfaceC0094a
        public void a(c.a.p0.s.q.a aVar) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) || aVar == null || aVar.getThreadData() == null || aVar.getThreadData().v1 == null) {
                return;
            }
            c.a.p0.b1.t.e(1, this.f17800b.f2966e, aVar.getThreadData(), 0, this.f17799a.t(), "from_nani_video", "personalize_page", null, "index", "");
        }
    }

    /* loaded from: classes3.dex */
    public class d implements a.InterfaceC0094a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ s0 f17801a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ x f17802b;

        public d(x xVar, s0 s0Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {xVar, s0Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f17802b = xVar;
            this.f17801a = s0Var;
        }

        @Override // c.a.l.a.InterfaceC0094a
        public void a(c.a.p0.s.q.a aVar) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) || aVar == null || aVar.getThreadData() == null || aVar.getThreadData().v1 == null) {
                return;
            }
            c.a.p0.b1.t.e(1, this.f17802b.f2966e, aVar.getThreadData(), 0, this.f17801a.t(), "from_nani_video", "personalize_page", null, "index", "");
        }
    }

    /* loaded from: classes3.dex */
    public class e implements c.a.l.w0.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ s0 f17803a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ x f17804b;

        public e(x xVar, s0 s0Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {xVar, s0Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f17804b = xVar;
            this.f17803a = s0Var;
        }

        @Override // c.a.l.w0.a
        public void a(c.a.p0.s.q.a aVar) {
            boolean z;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) || aVar == null || aVar.getThreadData() == null || aVar.getThreadData().v1 == null) {
                return;
            }
            if (aVar.getThreadData().v1.r != null) {
                z = aVar.getThreadData().v1.r.is_vertical.intValue() == 1;
            } else {
                z = false;
            }
            c.a.p0.b1.t.d(1, z, this.f17804b.f2966e, aVar.getThreadData(), 0, this.f17803a.t(), "from_nani_video", FrsFragment.STAR_FRS, null, "frs", "");
        }
    }

    /* loaded from: classes3.dex */
    public class f implements c.a.e.l.e.w {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ x f17805e;

        public f(x xVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {xVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f17805e = xVar;
        }

        @Override // c.a.e.l.e.w
        public void b(View view, c.a.e.l.e.n nVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i2, long j2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{view, nVar, bdUniqueId, viewGroup, Integer.valueOf(i2), Long.valueOf(j2)}) == null) && (nVar instanceof c.a.q0.a0.d0.k) && (view.getTag() instanceof ThreadCardViewHolder)) {
                ThreadCardViewHolder threadCardViewHolder = (ThreadCardViewHolder) view.getTag();
                c.a.q0.a0.d0.k kVar = (c.a.q0.a0.d0.k) nVar;
                kVar.k = 1;
                if (this.f17805e.s != null) {
                    this.f17805e.s.a(threadCardViewHolder.getView(), kVar);
                }
                ThreadCardUtils.jumpToPB((c.a.p0.s.q.a) kVar, view.getContext(), 2, false);
                threadCardViewHolder.getCardView().o(new a.C0096a(1));
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public x(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
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
        this.s = new a(this);
        this.o = tbPageContext;
        m0();
    }

    @Override // c.a.q0.o.f
    public void g(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
            this.q = str;
        }
    }

    public final void m0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            c.a.q0.a0.d0.k.W = "c10705";
            c.a.q0.a0.d0.k.X = "c10730";
            c.a.q0.a0.d0.k.Y = "c10731";
            c.a.q0.a0.d0.k.Z = "c10704";
            c.a.q0.a0.d0.k.a0 = "c10755";
            c.a.q0.a0.d0.k.b0 = "c10710";
            c.a.q0.a0.d0.k.c0 = "c10736";
            c.a.q0.a0.d0.k.i0 = "c10737";
            c.a.q0.a0.d0.k.j0 = "c10711";
            c.a.q0.a0.d0.k.k0 = "c10758";
            c.a.q0.a0.d0.k.l0 = "c10757";
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.a.e.l.e.a
    /* renamed from: n0 */
    public ThreadCardViewHolder<c.a.q0.a0.d0.k> U(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, viewGroup)) == null) {
            l0.b bVar = new l0.b(this.o.getPageActivity());
            s0 s0Var = new s0(this.o.getPageActivity());
            c.a.l.d dVar = new c.a.l.d(this.o.getPageActivity());
            dVar.s(this.n);
            dVar.b(1024);
            dVar.r(new b(this));
            bVar.o(dVar);
            g0 g0Var = new g0(this.o);
            g0Var.m(Boolean.FALSE);
            g0Var.u("index");
            bVar.n(g0Var);
            g0 g0Var2 = new g0(this.o);
            g0Var2.m(Boolean.TRUE);
            g0Var2.u("index");
            g0Var2.x(UtilHelper.getDimenPixelSize(R.dimen.M_W_X005), UtilHelper.getDimenPixelSize(R.dimen.M_H_X004), UtilHelper.getDimenPixelSize(R.dimen.M_W_X005), UtilHelper.getDimenPixelSize(R.dimen.M_H_X003));
            g0Var2.v(new c(this, s0Var));
            bVar.h(g0Var2);
            s0Var.m(Boolean.TRUE);
            s0Var.v("index");
            s0Var.w(new d(this, s0Var));
            s0Var.x(new e(this, s0Var));
            bVar.h(s0Var);
            bVar.h(new p0(this.o.getPageActivity()));
            bVar.h(new c.a.l.k(this.o.getPageActivity()));
            n0 n0Var = new n0(this.o.getPageActivity());
            c.a.p0.s.q.f fVar = new c.a.p0.s.q.f();
            fVar.f14219b = 1;
            fVar.f14225h = 1;
            n0Var.u(fVar);
            n0Var.v(1);
            n0Var.z(3);
            n0Var.w(2);
            bVar.m(n0Var);
            l0 k = bVar.k(BaseCardInfo.SupportType.FULL, viewGroup, this.r);
            k.r(2);
            ThreadCardViewHolder<c.a.q0.a0.d0.k> threadCardViewHolder = new ThreadCardViewHolder<>(k);
            threadCardViewHolder.setPageId(this.n);
            d0(new f(this));
            return threadCardViewHolder;
        }
        return (ThreadCardViewHolder) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.a.e.l.e.a
    /* renamed from: o0 */
    public View a0(int i2, View view, ViewGroup viewGroup, c.a.q0.a0.d0.k kVar, ThreadCardViewHolder<c.a.q0.a0.d0.k> threadCardViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048581, this, new Object[]{Integer.valueOf(i2), view, viewGroup, kVar, threadCardViewHolder})) == null) {
            if (kVar == null || threadCardViewHolder == null || threadCardViewHolder.getView() == null || kVar.f15245e == null) {
                return null;
            }
            kVar.K(kVar.position + 1);
            kVar.f15245e.Q1 = kVar.q();
            threadCardViewHolder.getCardView().q(i2);
            c.a.q0.a0.t.b().a(kVar.T("c12641"));
            c.a.q0.o.d.c().i("page_recommend", "show_", kVar.B());
            threadCardViewHolder.getCardView().setPage(this.q);
            threadCardViewHolder.showNEGFeedBackView(true).t(this.p);
            threadCardViewHolder.showFollowUserDecorItemIfNeed(kVar.showFollowBtn(), this.m);
            threadCardViewHolder.onBindDataToView(kVar);
            threadCardViewHolder.getCardView().onChangeSkinType(this.o, TbadkCoreApplication.getInst().getSkinType());
            threadCardViewHolder.getCardView().p(this.s);
            c.a.q0.f1.h.m.a.f(kVar.f15245e, this.n, kVar.q());
            c.a.q0.f1.h.m.a.e(kVar.f15245e, kVar.t(), kVar.q());
            return threadCardViewHolder.getView();
        }
        return (View) invokeCommon.objValue;
    }

    public void p0(NEGFeedBackView.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, bVar) == null) {
            this.p = bVar;
        }
    }
}
