package c.a.t0.o1.h.h;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.InputDeviceCompat;
import c.a.l.l0;
import c.a.l.n0;
import c.a.l.w0.a;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.card.Align;
import com.baidu.card.ThreadCardViewHolder;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.ThreadCardUtils;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout;
import com.baidu.tieba.NEGFeedBack.NEGFeedBackView;
import com.baidu.tieba.R;
import com.baidu.tieba.card.data.BaseCardInfo;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class s extends c.a.d.n.e.a<c.a.t0.g0.f0.k, ThreadCardViewHolder<c.a.t0.g0.f0.k>> implements c.a.t0.t.f {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public BdUniqueId m;
    public TbPageContext<?> n;
    public c.a.t0.o1.h.k.f o;
    public String p;
    public c.a.d.n.e.s q;
    public NEGFeedBackView.b r;
    public c.a.t0.g0.d0<c.a.t0.g0.f0.k> s;

    /* loaded from: classes7.dex */
    public class a extends c.a.t0.g0.d0<c.a.t0.g0.f0.k> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ s f21075b;

        public a(s sVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {sVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f21075b = sVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.t0.g0.d0
        /* renamed from: d */
        public void a(View view, c.a.t0.g0.f0.k kVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view, kVar) == null) {
                c.a.t0.g0.v.b().d(true);
                c.a.t0.t.d.c().h("page_recommend", "show_");
                if (view == null || this.f21075b.o == null || kVar == null || kVar.getThreadData() == null || StringUtils.isNull(kVar.getThreadData().v1())) {
                    return;
                }
                if ((view.getTag() instanceof String) && !c.a.t0.o1.h.f.b(c.a.d.f.m.b.g(kVar.getThreadData().v1(), 0L))) {
                    c.a.t0.o1.h.f.a(c.a.d.f.m.b.g(kVar.getThreadData().v1(), 0L));
                    this.f21075b.o.e(c.a.d.f.m.b.g(kVar.getThreadData().v1(), 0L), kVar.E(), kVar.t(), kVar.q(), kVar.g(), c.a.d.f.m.b.e((String) view.getTag(), 1), "homepage", kVar.getThreadData().L());
                }
                this.f21075b.f0(view, kVar);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b implements c.a.d.n.e.w {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ s f21076e;

        public b(s sVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {sVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f21076e = sVar;
        }

        @Override // c.a.d.n.e.w
        public void b(View view, c.a.d.n.e.n nVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i2, long j2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{view, nVar, bdUniqueId, viewGroup, Integer.valueOf(i2), Long.valueOf(j2)}) == null) && (nVar instanceof c.a.t0.g0.f0.k) && (view.getTag() instanceof ThreadCardViewHolder)) {
                ThreadCardViewHolder threadCardViewHolder = (ThreadCardViewHolder) view.getTag();
                c.a.t0.g0.f0.k kVar = (c.a.t0.g0.f0.k) nVar;
                kVar.f18228k = 1;
                if (this.f21076e.s != null) {
                    this.f21076e.s.a(threadCardViewHolder.getView(), kVar);
                }
                ThreadCardUtils.jumpToPB((c.a.s0.s.q.a) kVar, view.getContext(), 2, false, c.a.l.e.a((c.a.d.n.e.s) viewGroup, view, i2));
                threadCardViewHolder.getCardView().o(new a.C0186a(1));
            }
        }
    }

    /* loaded from: classes7.dex */
    public class c implements ThreadCommentAndPraiseInfoLayout.i {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ViewGroup a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ View f21077b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ int f21078c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ c.a.t0.g0.f0.k f21079d;

        public c(s sVar, ViewGroup viewGroup, View view, int i2, c.a.t0.g0.f0.k kVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {sVar, viewGroup, view, Integer.valueOf(i2), kVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = viewGroup;
            this.f21077b = view;
            this.f21078c = i2;
            this.f21079d = kVar;
        }

        @Override // com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout.i
        public void a(IntentConfig intentConfig) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, intentConfig) == null) && (intentConfig instanceof PbActivityConfig)) {
                ((PbActivityConfig) intentConfig).setVideoOriginArea(c.a.l.e.a((c.a.d.n.e.s) this.a, this.f21077b, this.f21078c));
                if (this.f21079d.getThreadData() == null || this.f21079d.getThreadData().g1() == null) {
                    return;
                }
                StatisticItem w = this.f21079d.w(c.a.t0.g0.f0.k.q0);
                w.param("obj_type", this.f21079d.getThreadData().g1().id);
                w.param("obj_name", this.f21079d.getThreadData().g1().name);
                TiebaStatic.log(w);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public s(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
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
        this.s = new a(this);
        this.n = tbPageContext;
        c0();
    }

    public final void c0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            c.a.t0.g0.f0.k.Z = "c10730";
            c.a.t0.g0.f0.k.a0 = "c10731";
            c.a.t0.g0.f0.k.b0 = "c10704";
            c.a.t0.g0.f0.k.c0 = "c10755";
            c.a.t0.g0.f0.k.d0 = "c10710";
            c.a.t0.g0.f0.k.e0 = "c10736";
            c.a.t0.g0.f0.k.f0 = "c10737";
            c.a.t0.g0.f0.k.g0 = "c10711";
            c.a.t0.g0.f0.k.h0 = "c10758";
            c.a.t0.g0.f0.k.i0 = "c10757";
            c.a.t0.g0.f0.k.r0 = "c10734";
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.a.d.n.e.a
    /* renamed from: d0 */
    public ThreadCardViewHolder M(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, viewGroup)) == null) {
            l0.b bVar = new l0.b(this.n.getPageActivity(), false);
            n0 n0Var = new n0(this.n.getPageActivity());
            c.a.s0.s.q.f fVar = new c.a.s0.s.q.f();
            fVar.f13685b = 1;
            fVar.f13691h = 1;
            n0Var.u(fVar);
            n0Var.v(1);
            n0Var.A("personalize_page");
            n0Var.z(3);
            n0Var.w(2);
            n0Var.a(32);
            bVar.m(n0Var);
            l0 k2 = bVar.k(BaseCardInfo.SupportType.BOTTOM, viewGroup, this.q);
            k2.r(2);
            ThreadCardViewHolder threadCardViewHolder = new ThreadCardViewHolder(k2);
            threadCardViewHolder.setPageId(this.m);
            V(new b(this));
            return threadCardViewHolder;
        }
        return (ThreadCardViewHolder) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.a.d.n.e.a
    /* renamed from: e0 */
    public View S(int i2, View view, ViewGroup viewGroup, c.a.t0.g0.f0.k kVar, ThreadCardViewHolder threadCardViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048580, this, new Object[]{Integer.valueOf(i2), view, viewGroup, kVar, threadCardViewHolder})) == null) {
            if (kVar == null || threadCardViewHolder == null || threadCardViewHolder.getView() == null || kVar.f18222e == null) {
                return null;
            }
            kVar.K(kVar.position + 1);
            kVar.f18222e.U1 = kVar.q();
            threadCardViewHolder.getCardView().q(i2);
            threadCardViewHolder.getCardView().d(this.p);
            if (threadCardViewHolder.getCardView().f() instanceof n0) {
                ((n0) threadCardViewHolder.getCardView().f()).y(new c(this, viewGroup, view, i2, kVar));
            }
            threadCardViewHolder.showNEGFeedBackViewIfNeed(false, Align.ALIGN_RIGHT_BOTTOM, this.r);
            threadCardViewHolder.onBindDataToView(kVar);
            threadCardViewHolder.getCardView().onChangeSkinType(this.n, TbadkCoreApplication.getInst().getSkinType());
            threadCardViewHolder.getCardView().p(this.s);
            c.a.t0.g0.v.b().a(kVar.B());
            c.a.t0.t.d.c().a(kVar.B());
            c.a.t0.o1.h.m.a.f(kVar.f18222e, this.m, kVar.q());
            return threadCardViewHolder.getView();
        }
        return (View) invokeCommon.objValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:42:0x00f6  */
    /* JADX WARN: Removed duplicated region for block: B:47:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void f0(View view, c.a.t0.g0.f0.k kVar) {
        StatisticItem A;
        Interceptable interceptable = $ic;
        if (interceptable != null && interceptable.invokeLL(1048581, this, view, kVar) != null) {
            return;
        }
        int id = view.getId();
        int i2 = 5;
        if (view.getId() != R.id.thread_card_root && id != R.id.thread_info_commont_container) {
            if (id == R.id.thread_card_voice) {
                TiebaStatic.log(kVar.V());
                c.a.t0.t.d.c().i("page_recommend", "clk_", kVar.V());
            } else {
                if (id == R.id.user_avatar) {
                    TiebaStatic.log(kVar.U());
                    c.a.t0.t.d.c().i("page_recommend", "clk_", kVar.U());
                } else if (id == R.id.user_name) {
                    TiebaStatic.log(kVar.U());
                    c.a.t0.t.d.c().i("page_recommend", "clk_", kVar.U());
                } else {
                    if (id == R.id.forum_name_text) {
                        TiebaStatic.log(kVar.o());
                        c.a.t0.t.d.c().i("page_recommend", "clk_", kVar.o());
                        i2 = 9;
                    } else if (id == R.id.god_reply_voice_btn) {
                        StatisticItem statisticItem = new StatisticItem("c10760");
                        statisticItem.param("obj_locate", 4);
                        TiebaStatic.log(statisticItem);
                    } else if (id == R.id.god_reply_content) {
                        StatisticItem statisticItem2 = new StatisticItem("c10760");
                        statisticItem2.param("obj_locate", 2);
                        TiebaStatic.log(statisticItem2);
                        c.a.t0.o1.h.m.a.b(kVar.f18222e, kVar.t(), kVar.q(), 1);
                    } else if (id == R.id.god_reply_user_pendant_header || id == R.id.god_reply_username_text) {
                        StatisticItem statisticItem3 = new StatisticItem("c10760");
                        statisticItem3.param("obj_locate", 1);
                        TiebaStatic.log(statisticItem3);
                    } else {
                        i2 = 0;
                    }
                    if (i2 != 0) {
                        c.a.t0.o1.h.m.a.c(kVar.f18222e, this.m, kVar.q(), i2);
                        return;
                    }
                    return;
                }
                i2 = 2;
                if (i2 != 0) {
                }
            }
        } else {
            if (c.a.t0.g0.f0.l.T(kVar.f18222e)) {
                A = kVar.D();
                TiebaStatic.log(A);
            } else {
                A = kVar.A();
                TiebaStatic.log(A);
            }
            c.a.t0.t.d.c().i("page_recommend", "clk_", A);
            c.a.t0.o1.h.m.a.b(kVar.f18222e, kVar.t(), kVar.q(), 1);
        }
        i2 = 1;
        if (i2 != 0) {
        }
    }

    @Override // c.a.t0.t.f
    public void g(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, str) == null) {
            this.p = str;
        }
    }

    public void g0(NEGFeedBackView.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, bVar) == null) {
            this.r = bVar;
        }
    }

    public void h0(c.a.t0.o1.h.k.f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, fVar) == null) {
            this.o = fVar;
        }
    }

    public void i0(c.a.d.n.e.s sVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, sVar) == null) {
            this.q = sVar;
        }
    }
}
