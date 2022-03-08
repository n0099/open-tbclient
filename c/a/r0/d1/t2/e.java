package c.a.r0.d1.t2;

import android.content.Context;
import android.content.res.Configuration;
import android.os.Handler;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.InputDeviceCompat;
import c.a.e.j;
import c.a.q0.r.r.e2;
import c.a.r0.f0.b0;
import com.baidu.adp.BdUniqueId;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.R;
import com.baidu.tieba.card.holder.CardViewHolder;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public class e extends c.a.d.o.e.a<c.a.r0.d1.j1.g, CardViewHolder<c.a.r0.d1.t2.a>> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean A;
    public c.a.r0.d1.t2.b B;
    public c.a.r0.z1.o.l.g C;
    public int D;
    public b0<c.a.r0.d1.j1.g> E;
    public TbPageContext m;
    public BdUniqueId n;
    public c.a.r0.d1.t2.a o;
    public boolean p;
    public List<c.a.r0.d1.t2.a> q;
    public Handler r;
    public c.a.r0.d1.j1.a s;
    public c t;
    public boolean u;
    public String v;
    public boolean w;
    public c.a.r0.d1.t2.j.a x;
    public String y;
    public c.a.r0.z1.o.l.f z;

    /* loaded from: classes2.dex */
    public class a extends b0<c.a.r0.d1.j1.g> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ e f16469b;

        public a(e eVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f16469b = eVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.r0.f0.b0
        /* renamed from: d */
        public void a(View view, c.a.r0.d1.j1.g gVar) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view, gVar) == null) || view == null || gVar == null) {
                return;
            }
            String str = gVar.f15706f;
            if (str == null) {
                str = null;
            }
            e2 e2Var = new e2();
            e2Var.T3(str);
            e2Var.F4(str);
            e2Var.J3(c.a.d.f.m.b.g(gVar.f15705e, 0L));
            e2Var.D3(gVar.A);
            e2Var.E4(40);
            if ((view.getId() == R.id.video_container || view.getId() == R.id.video_agg_container || view.getId() == R.id.mobile_network_play) && view.getTag() != null && (view.getTag() instanceof c.a.r0.d1.t2.a)) {
                c.a.r0.d1.t2.a aVar = (c.a.r0.d1.t2.a) view.getTag();
                if (this.f16469b.o != null && this.f16469b.o != aVar && (view.getId() == R.id.video_container || view.getId() == R.id.mobile_network_play)) {
                    this.f16469b.o.t0();
                }
                if (this.f16469b.o != aVar) {
                    this.f16469b.o = aVar;
                }
                if (this.f16469b.o != null) {
                    this.f16469b.o.k0(this.f16469b.w);
                }
            }
            if (view.getId() == R.id.title) {
                StatisticItem statisticItem = new StatisticItem("c12411");
                statisticItem.param("fid", gVar.f15705e);
                if (TbadkCoreApplication.isLogin()) {
                    statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
                }
                TiebaStatic.log(statisticItem);
                if (this.f16469b.o == null || this.f16469b.o.V()) {
                    return;
                }
                StatisticItem d2 = c.a.r0.x3.a.d(e2Var, "a023", "common_click", 1, gVar.I, false, null, null);
                if ("14".equals(this.f16469b.v)) {
                    d2.param("page_source", "newcategory");
                }
                c.a.r0.x3.c.g().c(this.f16469b.n, d2);
            } else if (view.getId() == R.id.agree_view_container) {
                StatisticItem statisticItem2 = new StatisticItem("c12414");
                statisticItem2.param("fid", gVar.f15705e);
                if (TbadkCoreApplication.isLogin()) {
                    statisticItem2.param("uid", TbadkCoreApplication.getCurrentAccount());
                }
                TiebaStatic.log(statisticItem2);
            } else if (view.getId() != R.id.thread_info_commont_container && view.getId() != R.id.card_root_view) {
                if (view.getId() != R.id.user_icon && view.getId() != R.id.user_name) {
                    if (view.getId() == R.id.attention) {
                        StatisticItem statisticItem3 = new StatisticItem("c12413");
                        statisticItem3.param("fid", gVar.f15705e);
                        if (TbadkCoreApplication.isLogin()) {
                            statisticItem3.param("uid", TbadkCoreApplication.getCurrentAccount());
                        }
                        TiebaStatic.log(statisticItem3);
                        return;
                    } else if (view.getId() == R.id.mobile_network_play) {
                        StatisticItem statisticItem4 = new StatisticItem("c12416");
                        statisticItem4.param("fid", gVar.f15705e);
                        if (TbadkCoreApplication.isLogin()) {
                            statisticItem4.param("uid", TbadkCoreApplication.getCurrentAccount());
                        }
                        TiebaStatic.log(statisticItem4);
                        return;
                    } else {
                        return;
                    }
                }
                StatisticItem statisticItem5 = new StatisticItem("c12412");
                statisticItem5.param("fid", gVar.f15705e);
                if (TbadkCoreApplication.isLogin()) {
                    statisticItem5.param("uid", TbadkCoreApplication.getCurrentAccount());
                }
                TiebaStatic.log(statisticItem5);
                StatisticItem d3 = c.a.r0.x3.a.d(e2Var, "a023", "common_click", 2, gVar.I, false, null, null);
                if ("14".equals(this.f16469b.v)) {
                    d3.param("page_source", "newcategory");
                }
                c.a.r0.x3.c.g().c(this.f16469b.n, d3);
            } else {
                StatisticItem statisticItem6 = new StatisticItem("c12415");
                statisticItem6.param("fid", gVar.f15705e);
                if (TbadkCoreApplication.isLogin()) {
                    statisticItem6.param("uid", TbadkCoreApplication.getCurrentAccount());
                }
                TiebaStatic.log(statisticItem6);
                StatisticItem d4 = c.a.r0.x3.a.d(e2Var, "a023", "common_click", 5, gVar.I, false, null, null);
                if ("14".equals(this.f16469b.v)) {
                    d4.param("page_source", "newcategory");
                }
                c.a.r0.x3.c.g().c(this.f16469b.n, d4);
            }
        }
    }

    /* loaded from: classes2.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ e f16470e;

        public b(e eVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f16470e = eVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.f16470e.p) {
                this.f16470e.p = false;
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e(TbPageContext<?> tbPageContext, c.a.r0.d1.j1.a aVar, c cVar, boolean z, String str, String str2, c.a.r0.z1.o.l.f fVar, BdUniqueId bdUniqueId, c.a.r0.d1.t2.b bVar, c.a.r0.z1.o.l.g gVar) {
        super(tbPageContext.getPageActivity().getBaseContext(), c.a.r0.d1.j1.g.K);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r3;
            Object[] objArr = {tbPageContext, aVar, cVar, Boolean.valueOf(z), str, str2, fVar, bdUniqueId, bVar, gVar};
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
        this.q = new ArrayList();
        this.r = new Handler();
        this.w = true;
        this.D = 1;
        this.E = new a(this);
        this.m = tbPageContext;
        this.n = bdUniqueId;
        this.s = aVar;
        this.u = z;
        this.t = cVar;
        this.v = str;
        this.x = new c.a.r0.d1.t2.j.a();
        this.y = str2;
        this.z = fVar;
        this.B = bVar;
        this.C = gVar;
    }

    public boolean g0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            c.a.r0.d1.t2.a aVar = this.o;
            if (aVar != null) {
                return aVar.isPlaying();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public boolean h0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            c.a.r0.d1.t2.a aVar = this.o;
            if (aVar != null) {
                return aVar.X();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public void i0(Configuration configuration) {
        int i2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048580, this, configuration) == null) || (i2 = configuration.orientation) == this.D) {
            return;
        }
        this.D = i2;
        c.a.r0.d1.t2.a aVar = this.o;
        if (aVar != null) {
            this.p = true;
            aVar.b0(configuration);
            if (configuration.orientation == 1) {
                this.r.postDelayed(new b(this), 500L);
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.a.d.o.e.a
    /* renamed from: j0 */
    public CardViewHolder<c.a.r0.d1.t2.a> M(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, viewGroup)) == null) {
            c.a.r0.d1.t2.a aVar = new c.a.r0.d1.t2.a(this.m, this.u, this.v, this.y, this.B);
            aVar.m(this.E);
            aVar.l0(this.C);
            this.q.add(aVar);
            return new CardViewHolder<>(aVar);
        }
        return (CardViewHolder) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.a.d.o.e.a
    /* renamed from: k0 */
    public View S(int i2, View view, ViewGroup viewGroup, c.a.r0.d1.j1.g gVar, CardViewHolder<c.a.r0.d1.t2.a> cardViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048582, this, new Object[]{Integer.valueOf(i2), view, viewGroup, gVar, cardViewHolder})) == null) {
            if (gVar == null || cardViewHolder == null) {
                return null;
            }
            if (gVar.i() != null) {
                gVar.i().keyFromHomePage = this.v;
            }
            if (!this.A) {
                if (!this.p) {
                    cardViewHolder.getCardView().a0(gVar, i2, this.s);
                    j trigger = gVar.getTrigger();
                    if (trigger != null) {
                        trigger.a();
                    }
                    cardViewHolder.getCardView().I = i2;
                    cardViewHolder.getCardView().setOnVideoContainerForegroundClickListener(this.t);
                } else {
                    cardViewHolder.getCardView().Y(gVar, i2, this.s);
                }
            }
            if (cardViewHolder.getCardView() instanceof c.a.r0.z1.o.l.h) {
                cardViewHolder.getCardView().setCurrentPlayCallBack(this.z);
            }
            String c2 = c.a.r0.x3.a.c(gVar.f15706f, "", "", gVar.A);
            e2 e2Var = new e2();
            e2Var.T3(gVar.f15706f);
            e2Var.F4(gVar.f15706f);
            e2Var.D3(gVar.A);
            e2Var.J3(c.a.d.f.m.b.g(gVar.f15705e, 0L));
            e2Var.E4(40);
            c.a.r0.x3.c.g().d(this.n, c2, c.a.r0.x3.a.f(e2Var, "a023", "common_exp", i2 + 1, false, null, null));
            return cardViewHolder.getView();
        }
        return (View) invokeCommon.objValue;
    }

    public boolean l0(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048583, this, i2)) == null) {
            c.a.r0.d1.t2.a aVar = this.o;
            if (aVar == null) {
                return false;
            }
            return aVar.c0(i2);
        }
        return invokeI.booleanValue;
    }

    public void m0() {
        c.a.r0.d1.t2.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) || (aVar = this.o) == null) {
            return;
        }
        aVar.d0();
    }

    public void n0() {
        c.a.r0.d1.t2.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048585, this) == null) || (aVar = this.o) == null) {
            return;
        }
        aVar.i0();
    }

    public void o0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048586, this, z) == null) {
            this.A = z;
        }
    }

    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            c.a.r0.d1.t2.j.a aVar = this.x;
            if (aVar != null) {
                aVar.d();
            }
            for (c.a.r0.d1.t2.a aVar2 : this.q) {
                if (aVar2 != null) {
                    aVar2.onDestroy();
                }
            }
        }
    }

    public void p0() {
        c.a.r0.d1.t2.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048588, this) == null) || (aVar = this.o) == null) {
            return;
        }
        aVar.s0();
    }

    public void q0() {
        c.a.r0.d1.t2.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048589, this) == null) || (aVar = this.o) == null) {
            return;
        }
        aVar.t0();
    }
}
