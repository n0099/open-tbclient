package c.a.t0.e1.z1.d;

import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.InputDeviceCompat;
import c.a.l.l0;
import c.a.l.n0;
import c.a.l.w0.a;
import c.a.s0.s.q.c2;
import c.a.s0.s.q.e2;
import c.a.t0.e1.u0;
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
/* loaded from: classes7.dex */
public class c0 extends c.a.t0.e1.k<e2, AutoVideoCardViewHolder<e2>> implements c.a.t0.g0.b0, c.a.t0.e1.w2.d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean A;
    public c.a.t0.g0.d0<e2> B;
    public Set<String> x;
    public int y;
    public c.a.t0.e1.w2.b z;

    /* loaded from: classes7.dex */
    public class a extends c.a.t0.g0.d0<e2> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ c0 f17251b;

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
            this.f17251b = c0Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.t0.g0.d0
        /* renamed from: d */
        public void a(View view, e2 e2Var) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view, e2Var) == null) || view == null || e2Var == null) {
                return;
            }
            if (view.getId() != R.id.user_name && view.getId() != R.id.user_avatar) {
                if (view.getId() == R.id.thread_info_commont_container) {
                    c.a.t0.e1.w2.a.e(e2Var, 5, this.f17251b.f3364i, this.f17251b.z, this.f17251b.a0());
                } else if (view.getId() == R.id.img_interview_live) {
                    c.a.t0.e1.w2.a.e(e2Var, 3, this.f17251b.f3364i, this.f17251b.z, this.f17251b.a0());
                } else if (view instanceof ThreadGodReplyLayout) {
                    c.a.t0.e1.w2.a.e(e2Var, 15, this.f17251b.f3364i, this.f17251b.z, this.f17251b.a0());
                } else if (view.getId() == R.id.share_num_container) {
                    c.a.t0.e1.w2.a.e(e2Var, 14, this.f17251b.f3364i, this.f17251b.z, this.f17251b.a0());
                } else if (view.getId() == R.id.img_agree) {
                    c.a.t0.e1.w2.a.e(e2Var, 12, this.f17251b.f3364i, this.f17251b.z, this.f17251b.a0());
                } else if (view.getId() == R.id.img_disagree) {
                    c.a.t0.e1.w2.a.e(e2Var, 13, this.f17251b.f3364i, this.f17251b.z, this.f17251b.a0());
                } else {
                    c.a.t0.e1.w2.a.e(e2Var, 1, this.f17251b.f3364i, this.f17251b.z, this.f17251b.a0());
                }
            } else {
                c.a.t0.e1.w2.a.e(e2Var, 2, this.f17251b.f3364i, this.f17251b.z, this.f17251b.a0());
            }
            if (view.getId() == R.id.user_name || view.getId() == R.id.user_avatar) {
                c.a.t0.e1.w2.c.k().h(this.f17251b.z, e2Var, 2);
            } else if (view.getId() == R.id.thread_card_root) {
                if (e2Var.o1() == 2 && e2Var.n1() != null) {
                    String d2 = e2Var.n1().d();
                    if (StringUtils.isNull(d2)) {
                        d2 = e2Var.n1().f();
                    }
                    String str = d2;
                    String valueOf = String.valueOf(e2Var.U());
                    String b0 = e2Var.b0();
                    String g2 = e2Var.n1().g();
                    c.a.t0.x3.l0.a.c("frs", "CLICK", valueOf, b0, g2, "tieba.baidu.com/p/" + e2Var.n1().g(), str);
                    String f2 = e2Var.n1().f();
                    StatisticItem statisticItem = new StatisticItem("c13329");
                    statisticItem.param("fid", e2Var.U());
                    statisticItem.param("obj_id", f2);
                    TiebaStatic.log(statisticItem);
                }
                c.a.t0.e1.w2.c.k().h(this.f17251b.z, e2Var, 1);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b implements c.a.d.n.e.v {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c0 f17252e;

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
            this.f17252e = c0Var;
        }

        @Override // c.a.d.n.e.v
        public void b(View view, c.a.d.n.e.n nVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i2, long j2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{view, nVar, bdUniqueId, viewGroup, Integer.valueOf(i2), Long.valueOf(j2)}) == null) && (nVar instanceof e2) && (view.getTag() instanceof ThreadCardViewHolder)) {
                ThreadCardViewHolder threadCardViewHolder = (ThreadCardViewHolder) view.getTag();
                e2 e2Var = (e2) nVar;
                e2Var.objType = 1;
                if (this.f17252e.B != null) {
                    this.f17252e.B.a(threadCardViewHolder.getView(), e2Var);
                }
                ThreadCardUtils.jumpToPB((c.a.s0.s.q.a) e2Var, view.getContext(), this.f17252e.y, false);
                threadCardViewHolder.getCardView().o(new a.C0204a(1));
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
        this.z = new c.a.t0.e1.w2.b();
        this.A = false;
        this.B = new a(this);
        this.x = new HashSet();
    }

    @Override // c.a.t0.g0.b0
    public void a(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
        }
    }

    @Override // c.a.t0.e1.k
    public void c0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            super.c0();
            this.x.clear();
        }
    }

    @Override // c.a.t0.e1.w2.d
    public c.a.t0.e1.w2.b j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.z : (c.a.t0.e1.w2.b) invokeV.objValue;
    }

    @Override // c.a.t0.g0.b0
    public void r(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048581, this, i2) == null) {
            this.y = i2;
        }
    }

    @Override // c.a.t0.e1.k
    public void setFromCDN(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048582, this, z) == null) {
            this.A = z;
        }
    }

    public final c.a.t0.a3.t x0(e2 e2Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, e2Var)) == null) {
            if (e2Var == null) {
                return null;
            }
            c.a.t0.a3.t tVar = new c.a.t0.a3.t();
            if (100 == a0().tabType) {
                tVar.a = e2Var.a2() ? "3" : "25";
            } else {
                tVar.a = e2Var.a2() ? "3" : "2";
            }
            tVar.f15289d = this.z.f17048c;
            tVar.f15288c = e2Var.w1();
            tVar.f15291f = e2Var.Z0;
            tVar.f15292g = e2Var.d1;
            tVar.f15293h = e2Var.a1;
            tVar.l = e2Var.b1;
            if (e2Var.u1() != null) {
                tVar.m = e2Var.u1().video_md5;
            }
            return tVar;
        }
        return (c.a.t0.a3.t) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.a.d.n.e.a
    /* renamed from: y0 */
    public AutoVideoCardViewHolder M(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, viewGroup)) == null) {
            l0.b bVar = new l0.b(this.o.getPageActivity());
            c.a.l.d dVar = new c.a.l.d(this.o.getPageActivity());
            dVar.a(696);
            dVar.s(this.f3364i);
            bVar.o(dVar);
            c.a.l.r rVar = new c.a.l.r(this.o.getPageActivity());
            rVar.A(this.A);
            bVar.n(rVar);
            c.a.l.n nVar = new c.a.l.n(this.o.getPageActivity());
            nVar.w(this.A);
            nVar.v("frs");
            bVar.h(nVar);
            n0 n0Var = new n0(this.o.getPageActivity());
            c.a.s0.s.q.f fVar = new c.a.s0.s.q.f();
            if (100 == a0().tabType) {
                fVar.f13557b = 25;
                n0Var.v(19);
                n0Var.z(14);
            } else {
                fVar.f13557b = 2;
                n0Var.v(2);
                n0Var.z(1);
            }
            fVar.f13563h = 2;
            n0Var.u(fVar);
            n0Var.w(this.y);
            n0Var.a(16);
            bVar.m(n0Var);
            l0 i2 = bVar.i();
            AutoVideoCardViewHolder autoVideoCardViewHolder = new AutoVideoCardViewHolder(i2);
            autoVideoCardViewHolder.setPageId(this.f3364i);
            i2.p(this.B);
            i2.r(this.y);
            V(new b(this));
            autoVideoCardViewHolder.showMultiDelDecorItem();
            return autoVideoCardViewHolder;
        }
        return (AutoVideoCardViewHolder) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.a.t0.e1.k, c.a.d.n.e.a
    /* renamed from: z0 */
    public View S(int i2, View view, ViewGroup viewGroup, e2 e2Var, AutoVideoCardViewHolder<e2> autoVideoCardViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048585, this, new Object[]{Integer.valueOf(i2), view, viewGroup, e2Var, autoVideoCardViewHolder})) == null) {
            if (autoVideoCardViewHolder == null) {
                return null;
            }
            if (this.z != null) {
                FrsViewData frsViewData = this.n;
                e2Var.T1 = (i2 + 1) - (frsViewData != null ? frsViewData.getTopThreadSize() : 0);
            }
            c.a.t0.e1.w2.c.k().c(this.z, e2Var);
            c.a.t0.e1.w2.a.n(e2Var, this.f3364i, this.z, a0());
            c2 n1 = e2Var.n1();
            if (n1 != null) {
                String f2 = n1.f();
                String d2 = n1.d();
                if (StringUtils.isNull(d2)) {
                    d2 = n1.f();
                }
                String str = d2;
                if (this.o.getOrignalPage() instanceof u0) {
                    u0 u0Var = (u0) this.o.getOrignalPage();
                    if (this.x.add(f2)) {
                        String forumId = u0Var.getForumId();
                        String forumName = u0Var.getForumName();
                        String g2 = n1.g();
                        c.a.t0.x3.l0.a.c("frs", "VIEW_TRUE", forumId, forumName, g2, "tieba.baidu.com/p/" + e2Var.w1(), str);
                    }
                }
                StatisticItem statisticItem = new StatisticItem("c13324");
                statisticItem.param("fid", e2Var.U());
                statisticItem.param("tid", e2Var.w1());
                statisticItem.param("obj_id", f2);
                statisticItem.param("thread_type", e2Var.s1());
                TiebaStatic.log(statisticItem);
            }
            if (e2Var != null) {
                e2Var.T4();
                if ((e2Var.u1() != null ? (char) 2 : (char) 1) == 2) {
                    autoVideoCardViewHolder.setVideoStatsData(x0(e2Var));
                }
                autoVideoCardViewHolder.getCardView().f().a(32);
                autoVideoCardViewHolder.onBindDataToView(e2Var);
                autoVideoCardViewHolder.getCardView().onChangeSkinType(this.o, TbadkCoreApplication.getInst().getSkinType());
                autoVideoCardViewHolder.getCardView().p(this.B);
                c.a.t0.e1.j.i(autoVideoCardViewHolder.getCardView().f(), this.n);
            }
            return autoVideoCardViewHolder.getView();
        }
        return (View) invokeCommon.objValue;
    }
}
