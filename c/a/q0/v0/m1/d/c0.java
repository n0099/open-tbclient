package c.a.q0.v0.m1.d;

import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.InputDeviceCompat;
import c.a.l.l0;
import c.a.l.n0;
import c.a.l.v0.a;
import c.a.p0.s.q.a2;
import c.a.p0.s.q.c2;
import c.a.q0.v0.t0;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.card.AutoVideoCardViewHolder;
import com.baidu.card.ThreadCardViewHolder;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.ThreadCardUtils;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.view.ThreadGodReplyLayout;
import com.baidu.tieba.R;
import com.baidu.tieba.tbadkCore.FrsViewData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashSet;
import java.util.Set;
/* loaded from: classes4.dex */
public class c0 extends c.a.q0.v0.k<c2, AutoVideoCardViewHolder<c2>> implements c.a.q0.a0.z, c.a.q0.v0.j2.d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean A;
    public c.a.q0.a0.b0<c2> B;
    public Set<String> x;
    public int y;
    public c.a.q0.v0.j2.b z;

    /* loaded from: classes4.dex */
    public class a extends c.a.q0.a0.b0<c2> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ c0 f26501b;

        public a(c0 c0Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {c0Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f26501b = c0Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.q0.a0.b0
        /* renamed from: d */
        public void a(View view, c2 c2Var) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view, c2Var) == null) || view == null || c2Var == null) {
                return;
            }
            if (view.getId() != R.id.user_name && view.getId() != R.id.user_avatar) {
                if (view.getId() == R.id.thread_info_commont_container) {
                    c.a.q0.v0.j2.a.e(c2Var, 5, this.f26501b.f2970i, this.f26501b.z, this.f26501b.i0());
                } else if (view.getId() == R.id.img_interview_live) {
                    c.a.q0.v0.j2.a.e(c2Var, 3, this.f26501b.f2970i, this.f26501b.z, this.f26501b.i0());
                } else if (view instanceof ThreadGodReplyLayout) {
                    c.a.q0.v0.j2.a.e(c2Var, 15, this.f26501b.f2970i, this.f26501b.z, this.f26501b.i0());
                } else if (view.getId() == R.id.share_num_container) {
                    c.a.q0.v0.j2.a.e(c2Var, 14, this.f26501b.f2970i, this.f26501b.z, this.f26501b.i0());
                } else if (view.getId() == R.id.img_agree) {
                    c.a.q0.v0.j2.a.e(c2Var, 12, this.f26501b.f2970i, this.f26501b.z, this.f26501b.i0());
                } else if (view.getId() == R.id.img_disagree) {
                    c.a.q0.v0.j2.a.e(c2Var, 13, this.f26501b.f2970i, this.f26501b.z, this.f26501b.i0());
                } else {
                    c.a.q0.v0.j2.a.e(c2Var, 1, this.f26501b.f2970i, this.f26501b.z, this.f26501b.i0());
                }
            } else {
                c.a.q0.v0.j2.a.e(c2Var, 2, this.f26501b.f2970i, this.f26501b.z, this.f26501b.i0());
            }
            if (view.getId() == R.id.user_name || view.getId() == R.id.user_avatar) {
                c.a.q0.v0.j2.c.j().g(this.f26501b.z, c2Var, 2);
            } else if (view.getId() == R.id.thread_card_root) {
                if (c2Var.i1() == 2 && c2Var.h1() != null) {
                    String d2 = c2Var.h1().d();
                    if (StringUtils.isNull(d2)) {
                        d2 = c2Var.h1().f();
                    }
                    String str = d2;
                    String valueOf = String.valueOf(c2Var.T());
                    String Z = c2Var.Z();
                    String g2 = c2Var.h1().g();
                    c.a.q0.i3.k0.a.c("frs", "CLICK", valueOf, Z, g2, "tieba.baidu.com/p/" + c2Var.h1().g(), str);
                    String f2 = c2Var.h1().f();
                    StatisticItem statisticItem = new StatisticItem("c13329");
                    statisticItem.param("fid", c2Var.T());
                    statisticItem.param("obj_id", f2);
                    TiebaStatic.log(statisticItem);
                }
                c.a.q0.v0.j2.c.j().g(this.f26501b.z, c2Var, 1);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b implements c.a.e.l.e.w {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c0 f26502e;

        public b(c0 c0Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {c0Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f26502e = c0Var;
        }

        @Override // c.a.e.l.e.w
        public void b(View view, c.a.e.l.e.n nVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i2, long j2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{view, nVar, bdUniqueId, viewGroup, Integer.valueOf(i2), Long.valueOf(j2)}) == null) && (nVar instanceof c2) && (view.getTag() instanceof ThreadCardViewHolder)) {
                ThreadCardViewHolder threadCardViewHolder = (ThreadCardViewHolder) view.getTag();
                c2 c2Var = (c2) nVar;
                c2Var.objType = 1;
                if (this.f26502e.B != null) {
                    this.f26502e.B.a(threadCardViewHolder.getView(), c2Var);
                }
                ThreadCardUtils.jumpToPB((c.a.p0.s.q.a) c2Var, view.getContext(), this.f26502e.y, false);
                threadCardViewHolder.getCardView().o(new a.C0096a(1));
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c0(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2, boolean z) {
        super(tbPageContext, bdUniqueId, bdUniqueId2);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, bdUniqueId, bdUniqueId2, Boolean.valueOf(z)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((TbPageContext) objArr2[0], (BdUniqueId) objArr2[1], (BdUniqueId) objArr2[2]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.y = 3;
        this.z = new c.a.q0.v0.j2.b();
        this.A = false;
        this.B = new a(this);
        this.x = new HashSet();
    }

    public final c.a.q0.o2.o F0(c2 c2Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, c2Var)) == null) {
            if (c2Var == null) {
                return null;
            }
            c.a.q0.o2.o oVar = new c.a.q0.o2.o();
            oVar.f23216a = c2Var.T1() ? "3" : "2";
            oVar.f23219d = this.z.f26275c;
            oVar.f23218c = c2Var.q1();
            oVar.f23221f = c2Var.U0;
            oVar.f23222g = c2Var.Y0;
            oVar.f23223h = c2Var.V0;
            oVar.l = c2Var.W0;
            if (c2Var.o1() != null) {
                oVar.m = c2Var.o1().video_md5;
            }
            return oVar;
        }
        return (c.a.q0.o2.o) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.a.e.l.e.a
    /* renamed from: G0 */
    public AutoVideoCardViewHolder U(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, viewGroup)) == null) {
            l0.b bVar = new l0.b(this.o.getPageActivity());
            c.a.l.d dVar = new c.a.l.d(this.o.getPageActivity());
            dVar.a(696);
            dVar.s(this.f2970i);
            bVar.o(dVar);
            c.a.l.r rVar = new c.a.l.r(this.o.getPageActivity());
            rVar.A(this.A);
            bVar.n(rVar);
            c.a.l.n nVar = new c.a.l.n(this.o.getPageActivity());
            nVar.w(this.A);
            nVar.v("frs");
            bVar.h(nVar);
            n0 n0Var = new n0(this.o.getPageActivity());
            c.a.p0.s.q.f fVar = new c.a.p0.s.q.f();
            fVar.f14219b = 2;
            fVar.f14225h = 2;
            n0Var.u(fVar);
            n0Var.v(2);
            n0Var.z(1);
            n0Var.w(this.y);
            n0Var.a(16);
            bVar.m(n0Var);
            l0 i2 = bVar.i();
            AutoVideoCardViewHolder autoVideoCardViewHolder = new AutoVideoCardViewHolder(i2);
            autoVideoCardViewHolder.setPageId(this.f2970i);
            i2.p(this.B);
            i2.r(this.y);
            d0(new b(this));
            autoVideoCardViewHolder.showMultiDelDecorItem();
            return autoVideoCardViewHolder;
        }
        return (AutoVideoCardViewHolder) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.a.q0.v0.k, c.a.e.l.e.a
    /* renamed from: H0 */
    public View a0(int i2, View view, ViewGroup viewGroup, c2 c2Var, AutoVideoCardViewHolder<c2> autoVideoCardViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Integer.valueOf(i2), view, viewGroup, c2Var, autoVideoCardViewHolder})) == null) {
            if (autoVideoCardViewHolder == null) {
                return null;
            }
            if (this.z != null) {
                FrsViewData frsViewData = this.n;
                c2Var.Q1 = (i2 + 1) - (frsViewData != null ? frsViewData.getTopThreadSize() : 0);
            }
            c.a.q0.v0.j2.c.j().c(this.z, c2Var);
            c.a.q0.v0.j2.a.m(c2Var, this.f2970i, this.z, i0());
            a2 h1 = c2Var.h1();
            if (h1 != null) {
                String f2 = h1.f();
                String d2 = h1.d();
                if (StringUtils.isNull(d2)) {
                    d2 = h1.f();
                }
                String str = d2;
                if (this.o.getOrignalPage() instanceof t0) {
                    t0 t0Var = (t0) this.o.getOrignalPage();
                    if (this.x.add(f2)) {
                        String forumId = t0Var.getForumId();
                        String forumName = t0Var.getForumName();
                        String g2 = h1.g();
                        c.a.q0.i3.k0.a.c("frs", "VIEW_TRUE", forumId, forumName, g2, "tieba.baidu.com/p/" + c2Var.q1(), str);
                    }
                }
                StatisticItem statisticItem = new StatisticItem("c13324");
                statisticItem.param("fid", c2Var.T());
                statisticItem.param("tid", c2Var.q1());
                statisticItem.param("obj_id", f2);
                statisticItem.param("thread_type", c2Var.m1());
                TiebaStatic.log(statisticItem);
            }
            if (c2Var != null) {
                c2Var.C4();
                if ((c2Var.o1() != null ? (char) 2 : (char) 1) == 2) {
                    autoVideoCardViewHolder.setVideoStatsData(F0(c2Var));
                }
                autoVideoCardViewHolder.getCardView().e().a(32);
                autoVideoCardViewHolder.onBindDataToView(c2Var);
                autoVideoCardViewHolder.getCardView().onChangeSkinType(this.o, TbadkCoreApplication.getInst().getSkinType());
                autoVideoCardViewHolder.getCardView().p(this.B);
                c.a.q0.v0.j.i(autoVideoCardViewHolder.getCardView().e(), this.n);
            }
            return autoVideoCardViewHolder.getView();
        }
        return (View) invokeCommon.objValue;
    }

    @Override // c.a.q0.a0.z
    public void a(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, str) == null) {
        }
    }

    @Override // c.a.q0.v0.j2.d
    public c.a.q0.v0.j2.b j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.z : (c.a.q0.v0.j2.b) invokeV.objValue;
    }

    @Override // c.a.q0.v0.k
    public void k0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            super.k0();
            this.x.clear();
        }
    }

    @Override // c.a.q0.a0.z
    public void r(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2) == null) {
            this.y = i2;
        }
    }

    @Override // c.a.q0.v0.k
    public void setFromCDN(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048585, this, z) == null) {
            this.A = z;
        }
    }
}
