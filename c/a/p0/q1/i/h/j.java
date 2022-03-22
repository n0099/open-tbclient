package c.a.p0.q1.i.h;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.InputDeviceCompat;
import c.a.l.l0;
import c.a.l.w0.a;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.card.ThreadCardViewHolder;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.ThreadCardUtils;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.card.data.BaseCardInfo;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes2.dex */
public class j extends c.a.d.o.e.a<c.a.p0.h0.e0.k, ThreadCardViewHolder<c.a.p0.h0.e0.k>> implements c.a.p0.v.f {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public BdUniqueId i;
    public TbPageContext<?> j;
    public c.a.p0.q1.i.k.f k;
    public String l;
    public boolean m;
    public c.a.d.o.e.s n;
    public c.a.p0.h0.b0<c.a.p0.h0.e0.k> o;

    /* loaded from: classes2.dex */
    public class a extends c.a.p0.h0.b0<c.a.p0.h0.e0.k> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ j f17419b;

        public a(j jVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {jVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f17419b = jVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.p0.h0.b0
        /* renamed from: d */
        public void a(View view, c.a.p0.h0.e0.k kVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view, kVar) == null) {
                c.a.p0.h0.u.b().d(true);
                c.a.p0.v.d.c().h("page_recommend", "show_");
                if (view == null || this.f17419b.k == null || kVar == null || kVar.getThreadData() == null || StringUtils.isNull(kVar.getThreadData().getTid())) {
                    return;
                }
                if ((view.getTag() instanceof String) && !c.a.p0.q1.i.f.b(c.a.d.f.m.b.g(kVar.getThreadData().getTid(), 0L))) {
                    c.a.p0.q1.i.f.a(c.a.d.f.m.b.g(kVar.getThreadData().getTid(), 0L));
                    this.f17419b.k.e(c.a.d.f.m.b.g(kVar.getThreadData().getTid(), 0L), kVar.D(), kVar.r(), kVar.q(), kVar.e(), c.a.d.f.m.b.e((String) view.getTag(), 1), "homepage", kVar.getThreadData().getBaijiahaoData());
                }
                this.f17419b.f0(view, kVar);
            }
        }
    }

    /* loaded from: classes2.dex */
    public class b implements c.a.d.o.e.w {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ j a;

        public b(j jVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {jVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = jVar;
        }

        @Override // c.a.d.o.e.w
        public void b(View view, c.a.d.o.e.n nVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i, long j) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{view, nVar, bdUniqueId, viewGroup, Integer.valueOf(i), Long.valueOf(j)}) == null) && (nVar instanceof c.a.p0.h0.e0.k) && (view.getTag() instanceof ThreadCardViewHolder)) {
                ThreadCardViewHolder threadCardViewHolder = (ThreadCardViewHolder) view.getTag();
                c.a.p0.h0.e0.k kVar = (c.a.p0.h0.e0.k) nVar;
                kVar.f15320f = 1;
                if (this.a.o != null) {
                    this.a.o.a(threadCardViewHolder.b(), kVar);
                }
                ThreadCardUtils.jumpToPB((c.a.o0.r.r.a) kVar, view.getContext(), 2, false);
                threadCardViewHolder.c().o(new a.C0196a(1));
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public j(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
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
        this.m = true;
        this.o = new a(this);
        this.j = tbPageContext;
        c0();
    }

    public final void c0() {
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
    /* renamed from: d0 */
    public ThreadCardViewHolder M(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, viewGroup)) == null) {
            l0.b bVar = new l0.b(this.j.getPageActivity(), false);
            c.a.l.n nVar = new c.a.l.n(this.j.getPageActivity());
            nVar.x(this.m);
            nVar.w("index");
            bVar.h(nVar);
            l0 k = bVar.k(BaseCardInfo.SupportType.EXTEND, viewGroup, this.n);
            k.r(2);
            ThreadCardViewHolder threadCardViewHolder = new ThreadCardViewHolder(k);
            threadCardViewHolder.k(this.i);
            V(new b(this));
            return threadCardViewHolder;
        }
        return (ThreadCardViewHolder) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.a.d.o.e.a
    /* renamed from: e0 */
    public View S(int i, View view, ViewGroup viewGroup, c.a.p0.h0.e0.k kVar, ThreadCardViewHolder<c.a.p0.h0.e0.k> threadCardViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048580, this, new Object[]{Integer.valueOf(i), view, viewGroup, kVar, threadCardViewHolder})) == null) {
            if (kVar == null || threadCardViewHolder == null || threadCardViewHolder.b() == null || kVar.a == null) {
                return null;
            }
            kVar.I(kVar.position + 1);
            kVar.a.statFloor = kVar.q();
            threadCardViewHolder.c().q(i);
            threadCardViewHolder.c().e(this.l);
            threadCardViewHolder.g(kVar);
            threadCardViewHolder.c().onChangeSkinType(this.j, TbadkCoreApplication.getInst().getSkinType());
            threadCardViewHolder.c().p(this.o);
            c.a.p0.h0.u.b().a(kVar.B());
            c.a.p0.v.d.c().a(kVar.B());
            c.a.p0.q1.i.m.a.h(kVar.a, this.i, kVar.q());
            return threadCardViewHolder.b();
        }
        return (View) invokeCommon.objValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:31:0x00c9  */
    /* JADX WARN: Removed duplicated region for block: B:36:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void f0(View view, c.a.p0.h0.e0.k kVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null && interceptable.invokeLL(1048581, this, view, kVar) != null) {
            return;
        }
        int id = view.getId();
        int i = 3;
        if (view.getId() == R.id.obfuscated_res_0x7f091f9a || id == R.id.obfuscated_res_0x7f091fac) {
            TiebaStatic.log(kVar.A());
            c.a.p0.v.d.c().i("page_recommend", "clk_", kVar.A());
            c.a.p0.q1.i.m.a.c(kVar.a, kVar.r(), kVar.q(), 1);
        } else if (id != R.id.obfuscated_res_0x7f090cd2) {
            if (id == R.id.obfuscated_res_0x7f090ccd) {
                StatisticItem statisticItem = new StatisticItem("c10760");
                statisticItem.param("obj_locate", 2);
                TiebaStatic.log(statisticItem);
                i = 5;
                c.a.p0.q1.i.m.a.c(kVar.a, kVar.r(), kVar.q(), 1);
            } else {
                if (id != R.id.obfuscated_res_0x7f090cd0 && id != R.id.obfuscated_res_0x7f090cd1) {
                    if (view instanceof TbImageView) {
                        if (view.getTag(R.id.obfuscated_res_0x7f090cce) instanceof Integer) {
                            StatisticItem statisticItem2 = new StatisticItem("c10760");
                            statisticItem2.param("obj_locate", 3);
                            TiebaStatic.log(statisticItem2);
                        }
                        TiebaStatic.log(kVar.P());
                        c.a.p0.v.d.c().i("page_recommend", "clk_", kVar.P());
                        c.a.p0.q1.i.m.a.c(kVar.a, kVar.r(), kVar.q(), 2);
                    }
                } else {
                    StatisticItem statisticItem3 = new StatisticItem("c10760");
                    statisticItem3.param("obj_locate", 1);
                    TiebaStatic.log(statisticItem3);
                }
                i = 0;
            }
            if (i == 0) {
                c.a.p0.q1.i.m.a.d(kVar.a, this.i, kVar.q(), i);
                return;
            }
            return;
        } else {
            StatisticItem statisticItem4 = new StatisticItem("c10760");
            statisticItem4.param("obj_locate", 4);
            TiebaStatic.log(statisticItem4);
        }
        i = 1;
        if (i == 0) {
        }
    }

    @Override // c.a.p0.v.f
    public void g(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, str) == null) {
            this.l = str;
        }
    }

    public void g0(c.a.p0.q1.i.k.f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, fVar) == null) {
            this.k = fVar;
        }
    }

    public void h0(c.a.d.o.e.s sVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, sVar) == null) {
            this.n = sVar;
        }
    }

    public void setFromCDN(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048585, this, z) == null) {
            this.m = z;
        }
    }
}
