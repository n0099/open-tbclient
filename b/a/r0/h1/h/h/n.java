package b.a.r0.h1.h.h;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.InputDeviceCompat;
import b.a.l.d;
import b.a.l.h0;
import b.a.l.l0;
import b.a.l.n0;
import b.a.l.w0.a;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.card.ThreadCardViewHolder;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.ThreadCardUtils;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.layout.ConstrainImageLayout;
import com.baidu.tieba.NEGFeedBack.NEGFeedBackView;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class n extends b.a.r0.h1.a<b.a.r0.b0.f0.k, ThreadCardViewHolder<b.a.r0.b0.f0.k>> implements b.a.r0.p.f {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public BdUniqueId n;
    public TbPageContext<?> o;
    public NEGFeedBackView.b p;
    public b.a.r0.h1.h.k.f q;
    public String r;
    public boolean s;
    public b.a.e.f.k.b<ConstrainImageLayout> t;
    public b.a.e.f.k.b<TbImageView> u;
    public b.a.r0.b0.d0<b.a.r0.b0.f0.k> v;

    /* loaded from: classes4.dex */
    public class a implements b.a.e.f.k.c<ConstrainImageLayout> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ n f18871a;

        public a(n nVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {nVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f18871a = nVar;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // b.a.e.f.k.c
        public /* bridge */ /* synthetic */ ConstrainImageLayout a(ConstrainImageLayout constrainImageLayout) {
            ConstrainImageLayout constrainImageLayout2 = constrainImageLayout;
            e(constrainImageLayout2);
            return constrainImageLayout2;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // b.a.e.f.k.c
        public /* bridge */ /* synthetic */ ConstrainImageLayout c(ConstrainImageLayout constrainImageLayout) {
            ConstrainImageLayout constrainImageLayout2 = constrainImageLayout;
            h(constrainImageLayout2);
            return constrainImageLayout2;
        }

        public ConstrainImageLayout e(ConstrainImageLayout constrainImageLayout) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, constrainImageLayout)) == null) ? constrainImageLayout : (ConstrainImageLayout) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // b.a.e.f.k.c
        /* renamed from: f */
        public void b(ConstrainImageLayout constrainImageLayout) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048581, this, constrainImageLayout) == null) {
                constrainImageLayout.removeAllViews();
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // b.a.e.f.k.c
        /* renamed from: g */
        public ConstrainImageLayout d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? new ConstrainImageLayout(this.f18871a.o.getPageActivity()) : (ConstrainImageLayout) invokeV.objValue;
        }

        public ConstrainImageLayout h(ConstrainImageLayout constrainImageLayout) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, constrainImageLayout)) == null) ? constrainImageLayout : (ConstrainImageLayout) invokeL.objValue;
        }
    }

    /* loaded from: classes4.dex */
    public class b implements b.a.e.f.k.c<TbImageView> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ n f18872a;

        public b(n nVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {nVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f18872a = nVar;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // b.a.e.f.k.c
        public /* bridge */ /* synthetic */ TbImageView a(TbImageView tbImageView) {
            TbImageView tbImageView2 = tbImageView;
            e(tbImageView2);
            return tbImageView2;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // b.a.e.f.k.c
        public /* bridge */ /* synthetic */ TbImageView c(TbImageView tbImageView) {
            TbImageView tbImageView2 = tbImageView;
            h(tbImageView2);
            return tbImageView2;
        }

        public TbImageView e(TbImageView tbImageView) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, tbImageView)) == null) ? tbImageView : (TbImageView) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // b.a.e.f.k.c
        /* renamed from: f */
        public void b(TbImageView tbImageView) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048581, this, tbImageView) == null) {
                tbImageView.setOnClickListener(null);
                tbImageView.setForegroundColor(0);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // b.a.e.f.k.c
        /* renamed from: g */
        public TbImageView d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
                TbImageView tbImageView = new TbImageView(this.f18872a.o.getPageActivity());
                tbImageView.setDrawBorder(true);
                tbImageView.setBorderColor(SkinManager.getColor(R.color.common_color_10264));
                tbImageView.setBorderWidth(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds1));
                return tbImageView;
            }
            return (TbImageView) invokeV.objValue;
        }

        public TbImageView h(TbImageView tbImageView) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, tbImageView)) == null) {
                tbImageView.setOnClickListener(null);
                tbImageView.setForegroundColor(0);
                return tbImageView;
            }
            return (TbImageView) invokeL.objValue;
        }
    }

    /* loaded from: classes4.dex */
    public class c extends b.a.r0.b0.d0<b.a.r0.b0.f0.k> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ n f18873b;

        public c(n nVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {nVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f18873b = nVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // b.a.r0.b0.d0
        /* renamed from: d */
        public void a(View view, b.a.r0.b0.f0.k kVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view, kVar) == null) {
                b.a.r0.b0.v.b().d(true);
                b.a.r0.p.d.c().h("page_recommend", "show_");
                if (view == null || this.f18873b.q == null || kVar == null || kVar.getThreadData() == null || StringUtils.isNull(kVar.getThreadData().t1())) {
                    return;
                }
                if ((view.getTag() instanceof String) && !b.a.r0.h1.h.f.b(b.a.e.f.m.b.g(kVar.getThreadData().t1(), 0L))) {
                    b.a.r0.h1.h.f.a(b.a.e.f.m.b.g(kVar.getThreadData().t1(), 0L));
                    this.f18873b.q.e(b.a.e.f.m.b.g(kVar.getThreadData().t1(), 0L), kVar.E(), kVar.t(), kVar.q(), kVar.g(), b.a.e.f.m.b.e((String) view.getTag(), 1), "homepage", kVar.getThreadData().L());
                }
                this.f18873b.o0(view, kVar);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class d implements d.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public d(n nVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {nVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // b.a.l.d.b
        public void a(b.a.q0.s.q.a aVar, View view) {
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

    /* loaded from: classes4.dex */
    public class e implements b.a.e.m.c.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b.a.l.w f18874a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ n f18875b;

        public e(n nVar, b.a.l.w wVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {nVar, wVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f18875b = nVar;
            this.f18874a = wVar;
        }

        @Override // b.a.e.m.c.b
        public void a(int i2, int i3, int i4) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIII(1048576, this, i2, i3, i4) == null) {
                this.f18875b.f0(i2, i3, i4);
                if (this.f18875b.M(1) && this.f18875b.M(2)) {
                    this.f18874a.v(null);
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class f implements b.a.e.m.e.w {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ n f18876e;

        public f(n nVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {nVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f18876e = nVar;
        }

        @Override // b.a.e.m.e.w
        public void b(View view, b.a.e.m.e.n nVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i2, long j) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{view, nVar, bdUniqueId, viewGroup, Integer.valueOf(i2), Long.valueOf(j)}) == null) && (nVar instanceof b.a.r0.b0.f0.k) && (view.getTag() instanceof ThreadCardViewHolder)) {
                ThreadCardViewHolder threadCardViewHolder = (ThreadCardViewHolder) view.getTag();
                b.a.r0.b0.f0.k kVar = (b.a.r0.b0.f0.k) nVar;
                kVar.k = 1;
                if (this.f18876e.v != null) {
                    this.f18876e.v.a(threadCardViewHolder.getView(), kVar);
                }
                ThreadCardUtils.jumpToPB((b.a.q0.s.q.a) kVar, view.getContext(), 2, false);
                threadCardViewHolder.getCardView().n(new a.C0092a(1));
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public n(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
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
        this.s = true;
        this.t = new b.a.e.f.k.b<>(new a(this), 6, 0);
        this.u = new b.a.e.f.k.b<>(new b(this), 12, 0);
        this.v = new c(this);
        this.o = tbPageContext;
        l0();
    }

    @Override // b.a.r0.p.f
    public void g(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
            this.r = str;
        }
    }

    public final void l0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            b.a.r0.b0.f0.k.Y = "c10705";
            b.a.r0.b0.f0.k.Z = "c10730";
            b.a.r0.b0.f0.k.a0 = "c10731";
            b.a.r0.b0.f0.k.b0 = "c10704";
            b.a.r0.b0.f0.k.c0 = "c10755";
            b.a.r0.b0.f0.k.i0 = "c10710";
            b.a.r0.b0.f0.k.j0 = "c10736";
            b.a.r0.b0.f0.k.k0 = "c10737";
            b.a.r0.b0.f0.k.l0 = "c10711";
            b.a.r0.b0.f0.k.m0 = "c10758";
            b.a.r0.b0.f0.k.n0 = "c10757";
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // b.a.e.m.e.a
    /* renamed from: m0 */
    public ThreadCardViewHolder T(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, viewGroup)) == null) {
            l0.b bVar = new l0.b(this.o.getPageActivity());
            b.a.l.d dVar = new b.a.l.d(this.o.getPageActivity());
            dVar.s(this.n);
            dVar.b(1024);
            dVar.r(new d(this));
            bVar.o(dVar);
            b.a.l.w wVar = new b.a.l.w(this.o.getPageActivity());
            wVar.s("index");
            wVar.r(this.t);
            wVar.q(this.u);
            wVar.t(this.s);
            bVar.n(wVar);
            b.a.l.s sVar = new b.a.l.s(this.o.getPageActivity());
            sVar.v(true);
            bVar.h(sVar);
            bVar.h(new h0(this.o.getPageActivity()));
            bVar.h(new b.a.l.a0(this.o.getPageActivity()));
            bVar.h(new b.a.l.k(this.o.getPageActivity()));
            b.a.l.n nVar = new b.a.l.n(this.o.getPageActivity());
            nVar.w(this.s);
            nVar.v("index");
            bVar.h(nVar);
            if (!M(1) || !M(2)) {
                wVar.v(new e(this, wVar));
            }
            n0 n0Var = new n0(this.o.getPageActivity());
            b.a.q0.s.q.f fVar = new b.a.q0.s.q.f();
            fVar.f14080b = 1;
            fVar.f14086h = 1;
            n0Var.u(fVar);
            n0Var.v(1);
            n0Var.z(3);
            n0Var.w(2);
            bVar.m(n0Var);
            l0 i2 = bVar.i();
            i2.q(2);
            ThreadCardViewHolder threadCardViewHolder = new ThreadCardViewHolder(i2);
            threadCardViewHolder.setPageId(this.n);
            c0(new f(this));
            return threadCardViewHolder;
        }
        return (ThreadCardViewHolder) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // b.a.e.m.e.a
    /* renamed from: n0 */
    public View Z(int i2, View view, ViewGroup viewGroup, b.a.r0.b0.f0.k kVar, ThreadCardViewHolder<b.a.r0.b0.f0.k> threadCardViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048581, this, new Object[]{Integer.valueOf(i2), view, viewGroup, kVar, threadCardViewHolder})) == null) {
            if (kVar == null || threadCardViewHolder == null || threadCardViewHolder.getView() == null || kVar.f16235e == null) {
                return null;
            }
            kVar.K(kVar.position + 1);
            kVar.f16235e.T1 = kVar.q();
            threadCardViewHolder.getCardView().setPage(this.r);
            threadCardViewHolder.showNEGFeedBackView(true).t(this.p);
            threadCardViewHolder.showFollowUserDecorItemIfNeed(kVar.showFollowBtn(), this.m);
            threadCardViewHolder.onBindDataToView(kVar);
            threadCardViewHolder.getCardView().onChangeSkinType(this.o, TbadkCoreApplication.getInst().getSkinType());
            threadCardViewHolder.getCardView().o(this.v);
            b.a.r0.b0.v.b().a(kVar.B());
            b.a.r0.p.d.c().i("page_recommend", "show_", kVar.B());
            b.a.r0.h1.h.m.a.f(kVar.f16235e, this.n, kVar.q());
            b.a.r0.h1.h.m.a.e(kVar.f16235e, kVar.t(), kVar.q());
            return threadCardViewHolder.getView();
        }
        return (View) invokeCommon.objValue;
    }

    public final void o0(View view, b.a.r0.b0.f0.k kVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048582, this, view, kVar) == null) {
            int id = view.getId();
            int i2 = 3;
            if (view.getId() == R.id.thread_card_root) {
                TiebaStatic.log(kVar.A());
                b.a.r0.p.d.c().i("page_recommend", "clk_", kVar.A());
                b.a.r0.h1.h.m.a.b(kVar.f16235e, kVar.t(), kVar.q(), 1);
                i2 = 1;
            } else if (id == R.id.thread_info_commont_container) {
                TiebaStatic.log(kVar.A());
                b.a.r0.p.d.c().i("page_recommend", "clk_", kVar.A());
                i2 = 5;
                b.a.r0.h1.h.m.a.b(kVar.f16235e, kVar.t(), kVar.q(), 1);
            } else {
                if (id == R.id.thread_card_voice) {
                    TiebaStatic.log(kVar.V());
                    b.a.r0.p.d.c().i("page_recommend", "clk_", kVar.V());
                } else {
                    if (id == R.id.user_avatar) {
                        TiebaStatic.log(kVar.U());
                        b.a.r0.p.d.c().i("page_recommend", "clk_", kVar.U());
                        b.a.r0.h1.h.m.a.b(kVar.f16235e, kVar.t(), kVar.q(), 4);
                    } else if (id == R.id.user_name) {
                        TiebaStatic.log(kVar.U());
                        b.a.r0.p.d.c().i("page_recommend", "clk_", kVar.U());
                        b.a.r0.h1.h.m.a.b(kVar.f16235e, kVar.t(), kVar.q(), 4);
                    } else if (id == R.id.forum_name_text) {
                        TiebaStatic.log(kVar.o());
                        b.a.r0.p.d.c().i("page_recommend", "clk_", kVar.o());
                    } else if (id == R.id.god_reply_voice_btn) {
                        StatisticItem statisticItem = new StatisticItem("c10760");
                        statisticItem.param("obj_locate", 4);
                        TiebaStatic.log(statisticItem);
                    } else if (id == R.id.god_reply_content) {
                        StatisticItem statisticItem2 = new StatisticItem("c10760");
                        statisticItem2.param("obj_locate", 2);
                        TiebaStatic.log(statisticItem2);
                        b.a.r0.h1.h.m.a.b(kVar.f16235e, kVar.t(), kVar.q(), 1);
                    } else if (id != R.id.god_reply_user_pendant_header && id != R.id.god_reply_username_text) {
                        if (view instanceof TbImageView) {
                            if (view.getTag(R.id.god_reply_image_layout) instanceof Integer) {
                                StatisticItem statisticItem3 = new StatisticItem("c10760");
                                statisticItem3.param("obj_locate", 3);
                                TiebaStatic.log(statisticItem3);
                            }
                            TiebaStatic.log(kVar.R());
                            b.a.r0.p.d.c().i("page_recommend", "clk_", kVar.R());
                            b.a.r0.h1.h.m.a.b(kVar.f16235e, kVar.t(), kVar.q(), 2);
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
                b.a.r0.h1.h.m.a.c(kVar.f16235e, this.n, kVar.q(), i2);
            }
        }
    }

    public void p0(NEGFeedBackView.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, bVar) == null) {
            this.p = bVar;
        }
    }

    public void q0(b.a.r0.h1.h.k.f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, fVar) == null) {
            this.q = fVar;
        }
    }

    public void setFromCDN(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048585, this, z) == null) {
            this.s = z;
        }
    }
}
