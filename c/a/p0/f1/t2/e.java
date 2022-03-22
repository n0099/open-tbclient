package c.a.p0.f1.t2;

import android.content.Context;
import android.content.res.Configuration;
import android.os.Handler;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.InputDeviceCompat;
import c.a.e.j;
import c.a.p0.h0.b0;
import com.baidu.adp.BdUniqueId;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.ThreadData;
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
public class e extends c.a.d.o.e.a<c.a.p0.f1.j1.g, CardViewHolder<c.a.p0.f1.t2.a>> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public b0<c.a.p0.f1.j1.g> A;
    public TbPageContext i;
    public BdUniqueId j;
    public c.a.p0.f1.t2.a k;
    public boolean l;
    public List<c.a.p0.f1.t2.a> m;
    public Handler n;
    public c.a.p0.f1.j1.a o;
    public c p;
    public boolean q;
    public String r;
    public boolean s;
    public c.a.p0.f1.t2.j.a t;
    public String u;
    public c.a.p0.b2.o.l.f v;
    public boolean w;
    public c.a.p0.f1.t2.b x;
    public c.a.p0.b2.o.l.g y;
    public int z;

    /* loaded from: classes2.dex */
    public class a extends b0<c.a.p0.f1.j1.g> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ e f14669b;

        public a(e eVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f14669b = eVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.p0.h0.b0
        /* renamed from: d */
        public void a(View view, c.a.p0.f1.j1.g gVar) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view, gVar) == null) || view == null || gVar == null) {
                return;
            }
            String str = gVar.f14123b;
            if (str == null) {
                str = null;
            }
            ThreadData threadData = new ThreadData();
            threadData.setId(str);
            threadData.setTid(str);
            threadData.setFid(c.a.d.f.m.b.g(gVar.a, 0L));
            threadData.setBaijiahaoData(gVar.w);
            threadData.setThreadType(40);
            if ((view.getId() == R.id.obfuscated_res_0x7f09231b || view.getId() == R.id.obfuscated_res_0x7f09230e || view.getId() == R.id.obfuscated_res_0x7f09142a) && view.getTag() != null && (view.getTag() instanceof c.a.p0.f1.t2.a)) {
                c.a.p0.f1.t2.a aVar = (c.a.p0.f1.t2.a) view.getTag();
                if (this.f14669b.k != null && this.f14669b.k != aVar && (view.getId() == R.id.obfuscated_res_0x7f09231b || view.getId() == R.id.obfuscated_res_0x7f09142a)) {
                    this.f14669b.k.u0();
                }
                if (this.f14669b.k != aVar) {
                    this.f14669b.k = aVar;
                }
                if (this.f14669b.k != null) {
                    this.f14669b.k.l0(this.f14669b.s);
                }
            }
            if (view.getId() == R.id.obfuscated_res_0x7f09202b) {
                StatisticItem statisticItem = new StatisticItem("c12411");
                statisticItem.param("fid", gVar.a);
                if (TbadkCoreApplication.isLogin()) {
                    statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
                }
                TiebaStatic.log(statisticItem);
                if (this.f14669b.k == null || this.f14669b.k.W()) {
                    return;
                }
                StatisticItem d2 = c.a.p0.z3.a.d(threadData, "a023", "common_click", 1, gVar.E, false, null, null);
                if ("14".equals(this.f14669b.r)) {
                    d2.param("page_source", "newcategory");
                }
                c.a.p0.z3.c.g().c(this.f14669b.j, d2);
            } else if (view.getId() == R.id.obfuscated_res_0x7f09015e) {
                StatisticItem statisticItem2 = new StatisticItem("c12414");
                statisticItem2.param("fid", gVar.a);
                if (TbadkCoreApplication.isLogin()) {
                    statisticItem2.param("uid", TbadkCoreApplication.getCurrentAccount());
                }
                TiebaStatic.log(statisticItem2);
            } else if (view.getId() != R.id.obfuscated_res_0x7f091fac && view.getId() != R.id.obfuscated_res_0x7f090572) {
                if (view.getId() != R.id.obfuscated_res_0x7f0922a8 && view.getId() != R.id.obfuscated_res_0x7f0922bb) {
                    if (view.getId() == R.id.obfuscated_res_0x7f0902b9) {
                        StatisticItem statisticItem3 = new StatisticItem("c12413");
                        statisticItem3.param("fid", gVar.a);
                        if (TbadkCoreApplication.isLogin()) {
                            statisticItem3.param("uid", TbadkCoreApplication.getCurrentAccount());
                        }
                        TiebaStatic.log(statisticItem3);
                        return;
                    } else if (view.getId() == R.id.obfuscated_res_0x7f09142a) {
                        StatisticItem statisticItem4 = new StatisticItem("c12416");
                        statisticItem4.param("fid", gVar.a);
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
                statisticItem5.param("fid", gVar.a);
                if (TbadkCoreApplication.isLogin()) {
                    statisticItem5.param("uid", TbadkCoreApplication.getCurrentAccount());
                }
                TiebaStatic.log(statisticItem5);
                StatisticItem d3 = c.a.p0.z3.a.d(threadData, "a023", "common_click", 2, gVar.E, false, null, null);
                if ("14".equals(this.f14669b.r)) {
                    d3.param("page_source", "newcategory");
                }
                c.a.p0.z3.c.g().c(this.f14669b.j, d3);
            } else {
                StatisticItem statisticItem6 = new StatisticItem("c12415");
                statisticItem6.param("fid", gVar.a);
                if (TbadkCoreApplication.isLogin()) {
                    statisticItem6.param("uid", TbadkCoreApplication.getCurrentAccount());
                }
                TiebaStatic.log(statisticItem6);
                StatisticItem d4 = c.a.p0.z3.a.d(threadData, "a023", "common_click", 5, gVar.E, false, null, null);
                if ("14".equals(this.f14669b.r)) {
                    d4.param("page_source", "newcategory");
                }
                c.a.p0.z3.c.g().c(this.f14669b.j, d4);
            }
        }
    }

    /* loaded from: classes2.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ e a;

        public b(e eVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = eVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.a.l) {
                this.a.l = false;
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e(TbPageContext<?> tbPageContext, c.a.p0.f1.j1.a aVar, c cVar, boolean z, String str, String str2, c.a.p0.b2.o.l.f fVar, BdUniqueId bdUniqueId, c.a.p0.f1.t2.b bVar, c.a.p0.b2.o.l.g gVar) {
        super(tbPageContext.getPageActivity().getBaseContext(), c.a.p0.f1.j1.g.G);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r3;
            Object[] objArr = {tbPageContext, aVar, cVar, Boolean.valueOf(z), str, str2, fVar, bdUniqueId, bVar, gVar};
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
        this.m = new ArrayList();
        this.n = new Handler();
        this.s = true;
        this.z = 1;
        this.A = new a(this);
        this.i = tbPageContext;
        this.j = bdUniqueId;
        this.o = aVar;
        this.q = z;
        this.p = cVar;
        this.r = str;
        this.t = new c.a.p0.f1.t2.j.a();
        this.u = str2;
        this.v = fVar;
        this.x = bVar;
        this.y = gVar;
    }

    public boolean g0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            c.a.p0.f1.t2.a aVar = this.k;
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
            c.a.p0.f1.t2.a aVar = this.k;
            if (aVar != null) {
                return aVar.Y();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public void i0(Configuration configuration) {
        int i;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048580, this, configuration) == null) || (i = configuration.orientation) == this.z) {
            return;
        }
        this.z = i;
        c.a.p0.f1.t2.a aVar = this.k;
        if (aVar != null) {
            this.l = true;
            aVar.c0(configuration);
            if (configuration.orientation == 1) {
                this.n.postDelayed(new b(this), 500L);
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.a.d.o.e.a
    /* renamed from: j0 */
    public CardViewHolder<c.a.p0.f1.t2.a> M(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, viewGroup)) == null) {
            c.a.p0.f1.t2.a aVar = new c.a.p0.f1.t2.a(this.i, this.q, this.r, this.u, this.x);
            aVar.n(this.A);
            aVar.m0(this.y);
            this.m.add(aVar);
            return new CardViewHolder<>(aVar);
        }
        return (CardViewHolder) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.a.d.o.e.a
    /* renamed from: k0 */
    public View S(int i, View view, ViewGroup viewGroup, c.a.p0.f1.j1.g gVar, CardViewHolder<c.a.p0.f1.t2.a> cardViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048582, this, new Object[]{Integer.valueOf(i), view, viewGroup, gVar, cardViewHolder})) == null) {
            if (gVar == null || cardViewHolder == null) {
                return null;
            }
            if (gVar.getAgreeData() != null) {
                gVar.getAgreeData().keyFromHomePage = this.r;
            }
            if (!this.w) {
                if (!this.l) {
                    cardViewHolder.c().b0(gVar, i, this.o);
                    j trigger = gVar.getTrigger();
                    if (trigger != null) {
                        trigger.a();
                    }
                    cardViewHolder.c().E = i;
                    cardViewHolder.c().setOnVideoContainerForegroundClickListener(this.p);
                } else {
                    cardViewHolder.c().Z(gVar, i, this.o);
                }
            }
            if (cardViewHolder.c() instanceof c.a.p0.b2.o.l.h) {
                cardViewHolder.c().setCurrentPlayCallBack(this.v);
            }
            String c2 = c.a.p0.z3.a.c(gVar.f14123b, "", "", gVar.w);
            ThreadData threadData = new ThreadData();
            threadData.setId(gVar.f14123b);
            threadData.setTid(gVar.f14123b);
            threadData.setBaijiahaoData(gVar.w);
            threadData.setFid(c.a.d.f.m.b.g(gVar.a, 0L));
            threadData.setThreadType(40);
            c.a.p0.z3.c.g().d(this.j, c2, c.a.p0.z3.a.f(threadData, "a023", "common_exp", i + 1, false, null, null));
            return cardViewHolder.b();
        }
        return (View) invokeCommon.objValue;
    }

    public boolean l0(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048583, this, i)) == null) {
            c.a.p0.f1.t2.a aVar = this.k;
            if (aVar == null) {
                return false;
            }
            return aVar.d0(i);
        }
        return invokeI.booleanValue;
    }

    public void m0() {
        c.a.p0.f1.t2.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) || (aVar = this.k) == null) {
            return;
        }
        aVar.e0();
    }

    public void n0() {
        c.a.p0.f1.t2.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048585, this) == null) || (aVar = this.k) == null) {
            return;
        }
        aVar.j0();
    }

    public void o0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048586, this, z) == null) {
            this.w = z;
        }
    }

    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            c.a.p0.f1.t2.j.a aVar = this.t;
            if (aVar != null) {
                aVar.d();
            }
            for (c.a.p0.f1.t2.a aVar2 : this.m) {
                if (aVar2 != null) {
                    aVar2.onDestroy();
                }
            }
        }
    }

    public void p0() {
        c.a.p0.f1.t2.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048588, this) == null) || (aVar = this.k) == null) {
            return;
        }
        aVar.t0();
    }

    public void q0() {
        c.a.p0.f1.t2.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048589, this) == null) || (aVar = this.k) == null) {
            return;
        }
        aVar.u0();
    }
}
