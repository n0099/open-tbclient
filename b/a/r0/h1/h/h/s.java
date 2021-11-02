package b.a.r0.h1.h.h;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.InputDeviceCompat;
import b.a.l.l0;
import b.a.l.n0;
import b.a.l.v0.a;
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
/* loaded from: classes4.dex */
public class s extends b.a.e.l.e.a<b.a.r0.b0.e0.k, ThreadCardViewHolder<b.a.r0.b0.e0.k>> implements b.a.r0.p.f {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public BdUniqueId m;
    public TbPageContext<?> n;
    public b.a.r0.h1.h.k.f o;
    public String p;
    public b.a.e.l.e.s q;
    public NEGFeedBackView.b r;
    public b.a.r0.b0.c0<b.a.r0.b0.e0.k> s;

    /* loaded from: classes4.dex */
    public class a extends b.a.r0.b0.c0<b.a.r0.b0.e0.k> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ s f17417b;

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
            this.f17417b = sVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // b.a.r0.b0.c0
        /* renamed from: d */
        public void a(View view, b.a.r0.b0.e0.k kVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view, kVar) == null) {
                b.a.r0.b0.u.b().d(true);
                b.a.r0.p.d.c().h("page_recommend", "show_");
                if (view == null || this.f17417b.o == null || kVar == null || kVar.getThreadData() == null || StringUtils.isNull(kVar.getThreadData().s1())) {
                    return;
                }
                if ((view.getTag() instanceof String) && !b.a.r0.h1.h.f.b(b.a.e.e.m.b.g(kVar.getThreadData().s1(), 0L))) {
                    b.a.r0.h1.h.f.a(b.a.e.e.m.b.g(kVar.getThreadData().s1(), 0L));
                    this.f17417b.o.e(b.a.e.e.m.b.g(kVar.getThreadData().s1(), 0L), kVar.E(), kVar.t(), kVar.q(), kVar.g(), b.a.e.e.m.b.e((String) view.getTag(), 1), "homepage", kVar.getThreadData().L());
                }
                this.f17417b.m0(view, kVar);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b implements b.a.e.l.e.w {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ s f17418e;

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
            this.f17418e = sVar;
        }

        @Override // b.a.e.l.e.w
        public void b(View view, b.a.e.l.e.n nVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i2, long j) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{view, nVar, bdUniqueId, viewGroup, Integer.valueOf(i2), Long.valueOf(j)}) == null) && (nVar instanceof b.a.r0.b0.e0.k) && (view.getTag() instanceof ThreadCardViewHolder)) {
                ThreadCardViewHolder threadCardViewHolder = (ThreadCardViewHolder) view.getTag();
                b.a.r0.b0.e0.k kVar = (b.a.r0.b0.e0.k) nVar;
                kVar.k = 1;
                if (this.f17418e.s != null) {
                    this.f17418e.s.a(threadCardViewHolder.getView(), kVar);
                }
                ThreadCardUtils.jumpToPB((b.a.q0.s.q.a) kVar, view.getContext(), 2, false, b.a.l.e.a((b.a.e.l.e.s) viewGroup, view, i2));
                threadCardViewHolder.getCardView().n(new a.C0090a(1));
            }
        }
    }

    /* loaded from: classes4.dex */
    public class c implements ThreadCommentAndPraiseInfoLayout.i {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ ViewGroup f17419a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ View f17420b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ int f17421c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ b.a.r0.b0.e0.k f17422d;

        public c(s sVar, ViewGroup viewGroup, View view, int i2, b.a.r0.b0.e0.k kVar) {
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
            this.f17419a = viewGroup;
            this.f17420b = view;
            this.f17421c = i2;
            this.f17422d = kVar;
        }

        @Override // com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout.i
        public void a(IntentConfig intentConfig) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, intentConfig) == null) && (intentConfig instanceof PbActivityConfig)) {
                ((PbActivityConfig) intentConfig).setVideoOriginArea(b.a.l.e.a((b.a.e.l.e.s) this.f17419a, this.f17420b, this.f17421c));
                if (this.f17422d.getThreadData() == null || this.f17422d.getThreadData().e1() == null) {
                    return;
                }
                StatisticItem w = this.f17422d.w(b.a.r0.b0.e0.k.n0);
                w.param("obj_type", this.f17422d.getThreadData().e1().id);
                w.param("obj_name", this.f17422d.getThreadData().e1().name);
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
        j0();
    }

    @Override // b.a.r0.p.f
    public void g(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
            this.p = str;
        }
    }

    public final void j0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            b.a.r0.b0.e0.k.X = "c10730";
            b.a.r0.b0.e0.k.Y = "c10731";
            b.a.r0.b0.e0.k.Z = "c10704";
            b.a.r0.b0.e0.k.a0 = "c10755";
            b.a.r0.b0.e0.k.b0 = "c10710";
            b.a.r0.b0.e0.k.c0 = "c10736";
            b.a.r0.b0.e0.k.i0 = "c10737";
            b.a.r0.b0.e0.k.j0 = "c10711";
            b.a.r0.b0.e0.k.k0 = "c10758";
            b.a.r0.b0.e0.k.l0 = "c10757";
            b.a.r0.b0.e0.k.o0 = "c10734";
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // b.a.e.l.e.a
    /* renamed from: k0 */
    public ThreadCardViewHolder T(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, viewGroup)) == null) {
            l0.b bVar = new l0.b(this.n.getPageActivity(), false);
            n0 n0Var = new n0(this.n.getPageActivity());
            b.a.q0.s.q.f fVar = new b.a.q0.s.q.f();
            fVar.f13300b = 1;
            fVar.f13306h = 1;
            n0Var.u(fVar);
            n0Var.v(1);
            n0Var.A("personalize_page");
            n0Var.z(3);
            n0Var.w(2);
            n0Var.a(32);
            bVar.m(n0Var);
            l0 k = bVar.k(BaseCardInfo.SupportType.BOTTOM, viewGroup, this.q);
            k.q(2);
            ThreadCardViewHolder threadCardViewHolder = new ThreadCardViewHolder(k);
            threadCardViewHolder.setPageId(this.m);
            c0(new b(this));
            return threadCardViewHolder;
        }
        return (ThreadCardViewHolder) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // b.a.e.l.e.a
    /* renamed from: l0 */
    public View Z(int i2, View view, ViewGroup viewGroup, b.a.r0.b0.e0.k kVar, ThreadCardViewHolder threadCardViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048581, this, new Object[]{Integer.valueOf(i2), view, viewGroup, kVar, threadCardViewHolder})) == null) {
            if (kVar == null || threadCardViewHolder == null || threadCardViewHolder.getView() == null || kVar.f14748e == null) {
                return null;
            }
            kVar.K(kVar.position + 1);
            kVar.f14748e.T1 = kVar.q();
            threadCardViewHolder.getCardView().p(i2);
            threadCardViewHolder.getCardView().setPage(this.p);
            if (threadCardViewHolder.getCardView().e() instanceof n0) {
                ((n0) threadCardViewHolder.getCardView().e()).y(new c(this, viewGroup, view, i2, kVar));
            }
            threadCardViewHolder.showNEGFeedBackViewIfNeed(false, Align.ALIGN_RIGHT_BOTTOM, this.r);
            threadCardViewHolder.onBindDataToView(kVar);
            threadCardViewHolder.getCardView().onChangeSkinType(this.n, TbadkCoreApplication.getInst().getSkinType());
            threadCardViewHolder.getCardView().o(this.s);
            b.a.r0.b0.u.b().a(kVar.B());
            b.a.r0.p.d.c().a(kVar.B());
            b.a.r0.h1.h.m.a.f(kVar.f14748e, this.m, kVar.q());
            return threadCardViewHolder.getView();
        }
        return (View) invokeCommon.objValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:42:0x00f6  */
    /* JADX WARN: Removed duplicated region for block: B:47:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void m0(View view, b.a.r0.b0.e0.k kVar) {
        StatisticItem A;
        Interceptable interceptable = $ic;
        if (interceptable != null && interceptable.invokeLL(1048582, this, view, kVar) != null) {
            return;
        }
        int id = view.getId();
        int i2 = 5;
        if (view.getId() != R.id.thread_card_root && id != R.id.thread_info_commont_container) {
            if (id == R.id.thread_card_voice) {
                TiebaStatic.log(kVar.V());
                b.a.r0.p.d.c().i("page_recommend", "clk_", kVar.V());
            } else {
                if (id == R.id.user_avatar) {
                    TiebaStatic.log(kVar.U());
                    b.a.r0.p.d.c().i("page_recommend", "clk_", kVar.U());
                } else if (id == R.id.user_name) {
                    TiebaStatic.log(kVar.U());
                    b.a.r0.p.d.c().i("page_recommend", "clk_", kVar.U());
                } else {
                    if (id == R.id.forum_name_text) {
                        TiebaStatic.log(kVar.o());
                        b.a.r0.p.d.c().i("page_recommend", "clk_", kVar.o());
                        i2 = 9;
                    } else if (id == R.id.god_reply_voice_btn) {
                        StatisticItem statisticItem = new StatisticItem("c10760");
                        statisticItem.param("obj_locate", 4);
                        TiebaStatic.log(statisticItem);
                    } else if (id == R.id.god_reply_content) {
                        StatisticItem statisticItem2 = new StatisticItem("c10760");
                        statisticItem2.param("obj_locate", 2);
                        TiebaStatic.log(statisticItem2);
                        b.a.r0.h1.h.m.a.b(kVar.f14748e, kVar.t(), kVar.q(), 1);
                    } else if (id == R.id.god_reply_user_pendant_header || id == R.id.god_reply_username_text) {
                        StatisticItem statisticItem3 = new StatisticItem("c10760");
                        statisticItem3.param("obj_locate", 1);
                        TiebaStatic.log(statisticItem3);
                    } else {
                        i2 = 0;
                    }
                    if (i2 != 0) {
                        b.a.r0.h1.h.m.a.c(kVar.f14748e, this.m, kVar.q(), i2);
                        return;
                    }
                    return;
                }
                i2 = 2;
                if (i2 != 0) {
                }
            }
        } else {
            if (b.a.r0.b0.e0.l.T(kVar.f14748e)) {
                A = kVar.D();
                TiebaStatic.log(A);
            } else {
                A = kVar.A();
                TiebaStatic.log(A);
            }
            b.a.r0.p.d.c().i("page_recommend", "clk_", A);
            b.a.r0.h1.h.m.a.b(kVar.f14748e, kVar.t(), kVar.q(), 1);
        }
        i2 = 1;
        if (i2 != 0) {
        }
    }

    public void n0(NEGFeedBackView.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, bVar) == null) {
            this.r = bVar;
        }
    }

    public void o0(b.a.r0.h1.h.k.f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, fVar) == null) {
            this.o = fVar;
        }
    }

    public void p0(b.a.e.l.e.s sVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, sVar) == null) {
            this.q = sVar;
        }
    }
}
