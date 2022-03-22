package c.a.p0.q1.i.h;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.InputDeviceCompat;
import c.a.l.d;
import c.a.l.h0;
import c.a.l.l0;
import c.a.l.n0;
import c.a.l.w0.a;
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
/* loaded from: classes2.dex */
public class n extends c.a.p0.q1.a<c.a.p0.h0.e0.k, ThreadCardViewHolder<c.a.p0.h0.e0.k>> implements c.a.p0.v.f {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public BdUniqueId j;
    public TbPageContext<?> k;
    public NEGFeedBackView.b l;
    public c.a.p0.q1.i.k.f m;
    public String n;
    public boolean o;
    public c.a.d.f.k.b<ConstrainImageLayout> p;
    public c.a.d.f.k.b<TbImageView> q;
    public c.a.p0.h0.b0<c.a.p0.h0.e0.k> r;

    /* loaded from: classes2.dex */
    public class a implements c.a.d.f.k.c<ConstrainImageLayout> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ n a;

        public a(n nVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {nVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = nVar;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // c.a.d.f.k.c
        public /* bridge */ /* synthetic */ ConstrainImageLayout a(ConstrainImageLayout constrainImageLayout) {
            ConstrainImageLayout constrainImageLayout2 = constrainImageLayout;
            e(constrainImageLayout2);
            return constrainImageLayout2;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // c.a.d.f.k.c
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
        @Override // c.a.d.f.k.c
        /* renamed from: f */
        public void b(ConstrainImageLayout constrainImageLayout) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048581, this, constrainImageLayout) == null) {
                constrainImageLayout.removeAllViews();
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.d.f.k.c
        /* renamed from: g */
        public ConstrainImageLayout d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? new ConstrainImageLayout(this.a.k.getPageActivity()) : (ConstrainImageLayout) invokeV.objValue;
        }

        public ConstrainImageLayout h(ConstrainImageLayout constrainImageLayout) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, constrainImageLayout)) == null) ? constrainImageLayout : (ConstrainImageLayout) invokeL.objValue;
        }
    }

    /* loaded from: classes2.dex */
    public class b implements c.a.d.f.k.c<TbImageView> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ n a;

        public b(n nVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {nVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = nVar;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // c.a.d.f.k.c
        public /* bridge */ /* synthetic */ TbImageView a(TbImageView tbImageView) {
            TbImageView tbImageView2 = tbImageView;
            e(tbImageView2);
            return tbImageView2;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // c.a.d.f.k.c
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
        @Override // c.a.d.f.k.c
        /* renamed from: f */
        public void b(TbImageView tbImageView) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048581, this, tbImageView) == null) {
                tbImageView.setOnClickListener(null);
                tbImageView.setForegroundColor(0);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.d.f.k.c
        /* renamed from: g */
        public TbImageView d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
                TbImageView tbImageView = new TbImageView(this.a.k.getPageActivity());
                tbImageView.setDrawBorder(true);
                tbImageView.setBorderColor(SkinManager.getColor(R.color.common_color_10264));
                tbImageView.setBorderWidth(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f070198));
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

    /* loaded from: classes2.dex */
    public class c extends c.a.p0.h0.b0<c.a.p0.h0.e0.k> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ n f17421b;

        public c(n nVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {nVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f17421b = nVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.p0.h0.b0
        /* renamed from: d */
        public void a(View view, c.a.p0.h0.e0.k kVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view, kVar) == null) {
                c.a.p0.h0.u.b().d(true);
                c.a.p0.v.d.c().h("page_recommend", "show_");
                if (view == null || this.f17421b.m == null || kVar == null || kVar.getThreadData() == null || StringUtils.isNull(kVar.getThreadData().getTid())) {
                    return;
                }
                if ((view.getTag() instanceof String) && !c.a.p0.q1.i.f.b(c.a.d.f.m.b.g(kVar.getThreadData().getTid(), 0L))) {
                    c.a.p0.q1.i.f.a(c.a.d.f.m.b.g(kVar.getThreadData().getTid(), 0L));
                    this.f17421b.m.e(c.a.d.f.m.b.g(kVar.getThreadData().getTid(), 0L), kVar.D(), kVar.r(), kVar.q(), kVar.e(), c.a.d.f.m.b.e((String) view.getTag(), 1), "homepage", kVar.getThreadData().getBaijiahaoData());
                }
                this.f17421b.h0(view, kVar);
            }
        }
    }

    /* loaded from: classes2.dex */
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
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // c.a.l.d.b
        public void a(c.a.o0.r.r.a aVar, View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLL(1048576, this, aVar, view) == null) || aVar == null) {
                return;
            }
            if (view.getId() == R.id.obfuscated_res_0x7f0922bb) {
                aVar.objType = 3;
            } else if (view.getId() == R.id.obfuscated_res_0x7f092296) {
                aVar.objType = 4;
            } else {
                aVar.objType = 1;
            }
        }
    }

    /* loaded from: classes2.dex */
    public class e implements c.a.d.o.c.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ c.a.l.w a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ n f17422b;

        public e(n nVar, c.a.l.w wVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {nVar, wVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f17422b = nVar;
            this.a = wVar;
        }

        @Override // c.a.d.o.c.b
        public void a(int i, int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIII(1048576, this, i, i2, i3) == null) {
                this.f17422b.Y(i, i2, i3);
                if (this.f17422b.F(1) && this.f17422b.F(2)) {
                    this.a.w(null);
                }
            }
        }
    }

    /* loaded from: classes2.dex */
    public class f implements c.a.d.o.e.w {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ n a;

        public f(n nVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {nVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = nVar;
        }

        @Override // c.a.d.o.e.w
        public void b(View view, c.a.d.o.e.n nVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i, long j) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{view, nVar, bdUniqueId, viewGroup, Integer.valueOf(i), Long.valueOf(j)}) == null) && (nVar instanceof c.a.p0.h0.e0.k) && (view.getTag() instanceof ThreadCardViewHolder)) {
                ThreadCardViewHolder threadCardViewHolder = (ThreadCardViewHolder) view.getTag();
                c.a.p0.h0.e0.k kVar = (c.a.p0.h0.e0.k) nVar;
                kVar.f15320f = 1;
                if (this.a.r != null) {
                    this.a.r.a(threadCardViewHolder.b(), kVar);
                }
                ThreadCardUtils.jumpToPB((c.a.o0.r.r.a) kVar, view.getContext(), 2, false);
                threadCardViewHolder.c().o(new a.C0196a(1));
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
        this.l = null;
        this.o = true;
        this.p = new c.a.d.f.k.b<>(new a(this), 6, 0);
        this.q = new c.a.d.f.k.b<>(new b(this), 12, 0);
        this.r = new c(this);
        this.k = tbPageContext;
        e0();
    }

    public final void e0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            c.a.p0.h0.e0.k.R = "c10705";
            c.a.p0.h0.e0.k.S = "c10730";
            c.a.p0.h0.e0.k.T = "c10731";
            c.a.p0.h0.e0.k.U = "c10704";
            c.a.p0.h0.e0.k.V = "c10755";
            c.a.p0.h0.e0.k.W = "c10710";
            c.a.p0.h0.e0.k.X = "c10736";
            c.a.p0.h0.e0.k.Y = "c10737";
            c.a.p0.h0.e0.k.Z = "c10711";
            c.a.p0.h0.e0.k.g0 = "c10758";
            c.a.p0.h0.e0.k.h0 = "c10757";
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.a.d.o.e.a
    /* renamed from: f0 */
    public ThreadCardViewHolder M(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, viewGroup)) == null) {
            l0.b bVar = new l0.b(this.k.getPageActivity());
            c.a.l.d dVar = new c.a.l.d(this.k.getPageActivity());
            dVar.t(this.j);
            dVar.c(1024);
            dVar.s(new d(this));
            bVar.o(dVar);
            c.a.l.w wVar = new c.a.l.w(this.k.getPageActivity());
            wVar.t("index");
            wVar.s(this.p);
            wVar.r(this.q);
            wVar.u(this.o);
            bVar.n(wVar);
            c.a.l.s sVar = new c.a.l.s(this.k.getPageActivity());
            sVar.w(true);
            bVar.h(sVar);
            bVar.h(new h0(this.k.getPageActivity()));
            bVar.h(new c.a.l.a0(this.k.getPageActivity()));
            bVar.h(new c.a.l.k(this.k.getPageActivity()));
            c.a.l.n nVar = new c.a.l.n(this.k.getPageActivity());
            nVar.x(this.o);
            nVar.w("index");
            bVar.h(nVar);
            if (!F(1) || !F(2)) {
                wVar.w(new e(this, wVar));
            }
            n0 n0Var = new n0(this.k.getPageActivity());
            c.a.o0.r.r.f fVar = new c.a.o0.r.r.f();
            fVar.f10852b = 1;
            fVar.f10858h = 1;
            n0Var.v(fVar);
            n0Var.w(1);
            n0Var.A(3);
            n0Var.x(2);
            bVar.m(n0Var);
            l0 i = bVar.i();
            i.r(2);
            ThreadCardViewHolder threadCardViewHolder = new ThreadCardViewHolder(i);
            threadCardViewHolder.k(this.j);
            V(new f(this));
            return threadCardViewHolder;
        }
        return (ThreadCardViewHolder) invokeL.objValue;
    }

    @Override // c.a.p0.v.f
    public void g(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, str) == null) {
            this.n = str;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.a.d.o.e.a
    /* renamed from: g0 */
    public View S(int i, View view, ViewGroup viewGroup, c.a.p0.h0.e0.k kVar, ThreadCardViewHolder<c.a.p0.h0.e0.k> threadCardViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048581, this, new Object[]{Integer.valueOf(i), view, viewGroup, kVar, threadCardViewHolder})) == null) {
            if (kVar == null || threadCardViewHolder == null || threadCardViewHolder.b() == null || kVar.a == null) {
                return null;
            }
            kVar.I(kVar.position + 1);
            kVar.a.statFloor = kVar.q();
            threadCardViewHolder.c().e(this.n);
            threadCardViewHolder.q(true).u(this.l);
            threadCardViewHolder.m(kVar.showFollowBtn(), this.i);
            threadCardViewHolder.g(kVar);
            threadCardViewHolder.c().onChangeSkinType(this.k, TbadkCoreApplication.getInst().getSkinType());
            threadCardViewHolder.c().p(this.r);
            c.a.p0.h0.u.b().a(kVar.B());
            c.a.p0.v.d.c().i("page_recommend", "show_", kVar.B());
            c.a.p0.q1.i.m.a.h(kVar.a, this.j, kVar.q());
            c.a.p0.q1.i.m.a.g(kVar.a, kVar.r(), kVar.q());
            return threadCardViewHolder.b();
        }
        return (View) invokeCommon.objValue;
    }

    public final void h0(View view, c.a.p0.h0.e0.k kVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048582, this, view, kVar) == null) {
            int id = view.getId();
            int i = 3;
            if (view.getId() == R.id.obfuscated_res_0x7f091f9a) {
                TiebaStatic.log(kVar.A());
                c.a.p0.v.d.c().i("page_recommend", "clk_", kVar.A());
                c.a.p0.q1.i.m.a.c(kVar.a, kVar.r(), kVar.q(), 1);
                i = 1;
            } else if (id == R.id.obfuscated_res_0x7f091fac) {
                TiebaStatic.log(kVar.A());
                c.a.p0.v.d.c().i("page_recommend", "clk_", kVar.A());
                i = 5;
                c.a.p0.q1.i.m.a.c(kVar.a, kVar.r(), kVar.q(), 1);
            } else {
                if (id == R.id.obfuscated_res_0x7f091f9c) {
                    TiebaStatic.log(kVar.T());
                    c.a.p0.v.d.c().i("page_recommend", "clk_", kVar.T());
                } else {
                    if (id == R.id.obfuscated_res_0x7f092296) {
                        TiebaStatic.log(kVar.S());
                        c.a.p0.v.d.c().i("page_recommend", "clk_", kVar.S());
                        c.a.p0.q1.i.m.a.c(kVar.a, kVar.r(), kVar.q(), 4);
                    } else if (id == R.id.obfuscated_res_0x7f0922bb) {
                        TiebaStatic.log(kVar.S());
                        c.a.p0.v.d.c().i("page_recommend", "clk_", kVar.S());
                        c.a.p0.q1.i.m.a.c(kVar.a, kVar.r(), kVar.q(), 4);
                    } else if (id == R.id.obfuscated_res_0x7f090a68) {
                        TiebaStatic.log(kVar.k());
                        c.a.p0.v.d.c().i("page_recommend", "clk_", kVar.k());
                    } else if (id == R.id.obfuscated_res_0x7f090cd2) {
                        StatisticItem statisticItem = new StatisticItem("c10760");
                        statisticItem.param("obj_locate", 4);
                        TiebaStatic.log(statisticItem);
                    } else if (id == R.id.obfuscated_res_0x7f090ccd) {
                        StatisticItem statisticItem2 = new StatisticItem("c10760");
                        statisticItem2.param("obj_locate", 2);
                        TiebaStatic.log(statisticItem2);
                        c.a.p0.q1.i.m.a.c(kVar.a, kVar.r(), kVar.q(), 1);
                    } else if (id != R.id.obfuscated_res_0x7f090cd0 && id != R.id.obfuscated_res_0x7f090cd1) {
                        if (view instanceof TbImageView) {
                            if (view.getTag(R.id.obfuscated_res_0x7f090cce) instanceof Integer) {
                                StatisticItem statisticItem3 = new StatisticItem("c10760");
                                statisticItem3.param("obj_locate", 3);
                                TiebaStatic.log(statisticItem3);
                            }
                            TiebaStatic.log(kVar.P());
                            c.a.p0.v.d.c().i("page_recommend", "clk_", kVar.P());
                            c.a.p0.q1.i.m.a.c(kVar.a, kVar.r(), kVar.q(), 2);
                        }
                    } else {
                        StatisticItem statisticItem4 = new StatisticItem("c10760");
                        statisticItem4.param("obj_locate", 1);
                        TiebaStatic.log(statisticItem4);
                    }
                    i = 2;
                }
                i = 0;
            }
            if (i != 0) {
                c.a.p0.q1.i.m.a.d(kVar.a, this.j, kVar.q(), i);
            }
        }
    }

    public void i0(NEGFeedBackView.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, bVar) == null) {
            this.l = bVar;
        }
    }

    public void j0(c.a.p0.q1.i.k.f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, fVar) == null) {
            this.m = fVar;
        }
    }

    public void setFromCDN(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048585, this, z) == null) {
            this.o = z;
        }
    }
}
