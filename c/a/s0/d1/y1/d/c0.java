package c.a.s0.d1.y1.d;

import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.InputDeviceCompat;
import c.a.l.l0;
import c.a.l.n0;
import c.a.l.w0.a;
import c.a.r0.s.r.b2;
import c.a.r0.s.r.d2;
import c.a.s0.d1.u0;
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
public class c0 extends c.a.s0.d1.k<d2, AutoVideoCardViewHolder<d2>> implements c.a.s0.g0.b0, c.a.s0.d1.v2.d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean A;
    public c.a.s0.g0.d0<d2> B;
    public Set<String> x;
    public int y;
    public c.a.s0.d1.v2.b z;

    /* loaded from: classes7.dex */
    public class a extends c.a.s0.g0.d0<d2> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ c0 f16691b;

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
            this.f16691b = c0Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.s0.g0.d0
        /* renamed from: d */
        public void a(View view, d2 d2Var) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view, d2Var) == null) || view == null || d2Var == null) {
                return;
            }
            if (view.getId() != R.id.user_name && view.getId() != R.id.user_avatar) {
                if (view.getId() == R.id.thread_info_commont_container) {
                    c.a.s0.d1.v2.a.e(d2Var, 5, this.f16691b.f2875i, this.f16691b.z, this.f16691b.h0());
                } else if (view.getId() == R.id.img_interview_live) {
                    c.a.s0.d1.v2.a.e(d2Var, 3, this.f16691b.f2875i, this.f16691b.z, this.f16691b.h0());
                } else if (view instanceof ThreadGodReplyLayout) {
                    c.a.s0.d1.v2.a.e(d2Var, 15, this.f16691b.f2875i, this.f16691b.z, this.f16691b.h0());
                } else if (view.getId() == R.id.share_num_container) {
                    c.a.s0.d1.v2.a.e(d2Var, 14, this.f16691b.f2875i, this.f16691b.z, this.f16691b.h0());
                } else if (view.getId() == R.id.img_agree) {
                    c.a.s0.d1.v2.a.e(d2Var, 12, this.f16691b.f2875i, this.f16691b.z, this.f16691b.h0());
                } else if (view.getId() == R.id.img_disagree) {
                    c.a.s0.d1.v2.a.e(d2Var, 13, this.f16691b.f2875i, this.f16691b.z, this.f16691b.h0());
                } else {
                    c.a.s0.d1.v2.a.e(d2Var, 1, this.f16691b.f2875i, this.f16691b.z, this.f16691b.h0());
                }
            } else {
                c.a.s0.d1.v2.a.e(d2Var, 2, this.f16691b.f2875i, this.f16691b.z, this.f16691b.h0());
            }
            if (view.getId() == R.id.user_name || view.getId() == R.id.user_avatar) {
                c.a.s0.d1.v2.c.k().h(this.f16691b.z, d2Var, 2);
            } else if (view.getId() == R.id.thread_card_root) {
                if (d2Var.n1() == 2 && d2Var.m1() != null) {
                    String d2 = d2Var.m1().d();
                    if (StringUtils.isNull(d2)) {
                        d2 = d2Var.m1().f();
                    }
                    String str = d2;
                    String valueOf = String.valueOf(d2Var.U());
                    String a0 = d2Var.a0();
                    String g2 = d2Var.m1().g();
                    c.a.s0.v3.l0.a.c("frs", "CLICK", valueOf, a0, g2, "tieba.baidu.com/p/" + d2Var.m1().g(), str);
                    String f2 = d2Var.m1().f();
                    StatisticItem statisticItem = new StatisticItem("c13329");
                    statisticItem.param("fid", d2Var.U());
                    statisticItem.param("obj_id", f2);
                    TiebaStatic.log(statisticItem);
                }
                c.a.s0.d1.v2.c.k().h(this.f16691b.z, d2Var, 1);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b implements c.a.d.m.e.w {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c0 f16692e;

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
            this.f16692e = c0Var;
        }

        @Override // c.a.d.m.e.w
        public void b(View view, c.a.d.m.e.n nVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i2, long j2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{view, nVar, bdUniqueId, viewGroup, Integer.valueOf(i2), Long.valueOf(j2)}) == null) && (nVar instanceof d2) && (view.getTag() instanceof ThreadCardViewHolder)) {
                ThreadCardViewHolder threadCardViewHolder = (ThreadCardViewHolder) view.getTag();
                d2 d2Var = (d2) nVar;
                d2Var.objType = 1;
                if (this.f16692e.B != null) {
                    this.f16692e.B.a(threadCardViewHolder.getView(), d2Var);
                }
                ThreadCardUtils.jumpToPB((c.a.r0.s.r.a) d2Var, view.getContext(), this.f16692e.y, false);
                threadCardViewHolder.getCardView().o(new a.C0165a(1));
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
        this.z = new c.a.s0.d1.v2.b();
        this.A = false;
        this.B = new a(this);
        this.x = new HashSet();
    }

    public final c.a.s0.z2.p E0(d2 d2Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, d2Var)) == null) {
            if (d2Var == null) {
                return null;
            }
            c.a.s0.z2.p pVar = new c.a.s0.z2.p();
            if (100 == h0().tabType) {
                pVar.a = d2Var.Z1() ? "3" : "25";
            } else {
                pVar.a = d2Var.Z1() ? "3" : "2";
            }
            pVar.f26407d = this.z.f16494c;
            pVar.f26406c = d2Var.v1();
            pVar.f26409f = d2Var.Z0;
            pVar.f26410g = d2Var.d1;
            pVar.f26411h = d2Var.a1;
            pVar.l = d2Var.b1;
            if (d2Var.t1() != null) {
                pVar.m = d2Var.t1().video_md5;
            }
            return pVar;
        }
        return (c.a.s0.z2.p) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.a.d.m.e.a
    /* renamed from: F0 */
    public AutoVideoCardViewHolder S(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, viewGroup)) == null) {
            l0.b bVar = new l0.b(this.o.getPageActivity());
            c.a.l.d dVar = new c.a.l.d(this.o.getPageActivity());
            dVar.a(696);
            dVar.s(this.f2875i);
            bVar.o(dVar);
            c.a.l.r rVar = new c.a.l.r(this.o.getPageActivity());
            rVar.A(this.A);
            bVar.n(rVar);
            c.a.l.n nVar = new c.a.l.n(this.o.getPageActivity());
            nVar.w(this.A);
            nVar.v("frs");
            bVar.h(nVar);
            n0 n0Var = new n0(this.o.getPageActivity());
            c.a.r0.s.r.f fVar = new c.a.r0.s.r.f();
            if (100 == h0().tabType) {
                fVar.f13309b = 25;
                n0Var.v(19);
                n0Var.z(14);
            } else {
                fVar.f13309b = 2;
                n0Var.v(2);
                n0Var.z(1);
            }
            fVar.f13315h = 2;
            n0Var.u(fVar);
            n0Var.w(this.y);
            n0Var.a(16);
            bVar.m(n0Var);
            l0 i2 = bVar.i();
            AutoVideoCardViewHolder autoVideoCardViewHolder = new AutoVideoCardViewHolder(i2);
            autoVideoCardViewHolder.setPageId(this.f2875i);
            i2.p(this.B);
            i2.r(this.y);
            c0(new b(this));
            autoVideoCardViewHolder.showMultiDelDecorItem();
            return autoVideoCardViewHolder;
        }
        return (AutoVideoCardViewHolder) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.a.s0.d1.k, c.a.d.m.e.a
    /* renamed from: G0 */
    public View Z(int i2, View view, ViewGroup viewGroup, d2 d2Var, AutoVideoCardViewHolder<d2> autoVideoCardViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Integer.valueOf(i2), view, viewGroup, d2Var, autoVideoCardViewHolder})) == null) {
            if (autoVideoCardViewHolder == null) {
                return null;
            }
            if (this.z != null) {
                FrsViewData frsViewData = this.n;
                d2Var.U1 = (i2 + 1) - (frsViewData != null ? frsViewData.getTopThreadSize() : 0);
            }
            c.a.s0.d1.v2.c.k().c(this.z, d2Var);
            c.a.s0.d1.v2.a.m(d2Var, this.f2875i, this.z, h0());
            b2 m1 = d2Var.m1();
            if (m1 != null) {
                String f2 = m1.f();
                String d2 = m1.d();
                if (StringUtils.isNull(d2)) {
                    d2 = m1.f();
                }
                String str = d2;
                if (this.o.getOrignalPage() instanceof u0) {
                    u0 u0Var = (u0) this.o.getOrignalPage();
                    if (this.x.add(f2)) {
                        String forumId = u0Var.getForumId();
                        String forumName = u0Var.getForumName();
                        String g2 = m1.g();
                        c.a.s0.v3.l0.a.c("frs", "VIEW_TRUE", forumId, forumName, g2, "tieba.baidu.com/p/" + d2Var.v1(), str);
                    }
                }
                StatisticItem statisticItem = new StatisticItem("c13324");
                statisticItem.param("fid", d2Var.U());
                statisticItem.param("tid", d2Var.v1());
                statisticItem.param("obj_id", f2);
                statisticItem.param("thread_type", d2Var.r1());
                TiebaStatic.log(statisticItem);
            }
            if (d2Var != null) {
                d2Var.S4();
                if ((d2Var.t1() != null ? (char) 2 : (char) 1) == 2) {
                    autoVideoCardViewHolder.setVideoStatsData(E0(d2Var));
                }
                autoVideoCardViewHolder.getCardView().f().a(32);
                autoVideoCardViewHolder.onBindDataToView(d2Var);
                autoVideoCardViewHolder.getCardView().onChangeSkinType(this.o, TbadkCoreApplication.getInst().getSkinType());
                autoVideoCardViewHolder.getCardView().p(this.B);
                c.a.s0.d1.j.i(autoVideoCardViewHolder.getCardView().f(), this.n);
            }
            return autoVideoCardViewHolder.getView();
        }
        return (View) invokeCommon.objValue;
    }

    @Override // c.a.s0.g0.b0
    public void a(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, str) == null) {
        }
    }

    @Override // c.a.s0.d1.v2.d
    public c.a.s0.d1.v2.b j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.z : (c.a.s0.d1.v2.b) invokeV.objValue;
    }

    @Override // c.a.s0.d1.k
    public void j0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            super.j0();
            this.x.clear();
        }
    }

    @Override // c.a.s0.g0.b0
    public void r(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2) == null) {
            this.y = i2;
        }
    }

    @Override // c.a.s0.d1.k
    public void setFromCDN(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048585, this, z) == null) {
            this.A = z;
        }
    }
}
