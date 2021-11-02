package b.a.r0.x0.x1.d;

import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.InputDeviceCompat;
import b.a.l.l0;
import b.a.l.n0;
import b.a.l.v0.a;
import b.a.q0.s.q.b2;
import b.a.q0.s.q.c2;
import b.a.q0.s.q.d2;
import b.a.r0.x0.t0;
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
/* loaded from: classes5.dex */
public class b0 extends b.a.r0.x0.k<c2, AutoVideoCardViewHolder<d2>> implements b.a.r0.b0.a0, b.a.r0.x0.u2.d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean A;
    public b.a.r0.b0.c0<d2> B;
    public Set<String> x;
    public int y;
    public b.a.r0.x0.u2.b z;

    /* loaded from: classes5.dex */
    public class a extends b.a.r0.b0.c0<d2> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ b0 f26610b;

        public a(b0 b0Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {b0Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f26610b = b0Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // b.a.r0.b0.c0
        /* renamed from: d */
        public void a(View view, d2 d2Var) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view, d2Var) == null) || view == null || d2Var == null) {
                return;
            }
            if (view.getId() != R.id.user_name && view.getId() != R.id.user_avatar) {
                if (view.getId() == R.id.thread_info_commont_container) {
                    b.a.r0.x0.u2.a.e(d2Var, 5, this.f26610b.f2423i, this.f26610b.z, this.f26610b.h0());
                } else if (view.getId() == R.id.img_interview_live) {
                    b.a.r0.x0.u2.a.e(d2Var, 3, this.f26610b.f2423i, this.f26610b.z, this.f26610b.h0());
                } else if (view instanceof ThreadGodReplyLayout) {
                    b.a.r0.x0.u2.a.e(d2Var, 15, this.f26610b.f2423i, this.f26610b.z, this.f26610b.h0());
                } else if (view.getId() == R.id.share_num_container) {
                    b.a.r0.x0.u2.a.e(d2Var, 14, this.f26610b.f2423i, this.f26610b.z, this.f26610b.h0());
                } else if (view.getId() == R.id.img_agree) {
                    b.a.r0.x0.u2.a.e(d2Var, 12, this.f26610b.f2423i, this.f26610b.z, this.f26610b.h0());
                } else if (view.getId() == R.id.img_disagree) {
                    b.a.r0.x0.u2.a.e(d2Var, 13, this.f26610b.f2423i, this.f26610b.z, this.f26610b.h0());
                } else {
                    b.a.r0.x0.u2.a.e(d2Var, 1, this.f26610b.f2423i, this.f26610b.z, this.f26610b.h0());
                }
            } else {
                b.a.r0.x0.u2.a.e(d2Var, 2, this.f26610b.f2423i, this.f26610b.z, this.f26610b.h0());
            }
            if (view.getId() == R.id.user_name || view.getId() == R.id.user_avatar) {
                b.a.r0.x0.u2.c.j().g(this.f26610b.z, d2Var, 2);
            } else if (view.getId() == R.id.thread_card_root) {
                if (d2Var.k1() == 2 && d2Var.j1() != null) {
                    String d2 = d2Var.j1().d();
                    if (StringUtils.isNull(d2)) {
                        d2 = d2Var.j1().f();
                    }
                    String str = d2;
                    String valueOf = String.valueOf(d2Var.T());
                    String Z = d2Var.Z();
                    String g2 = d2Var.j1().g();
                    b.a.r0.l3.l0.a.c("frs", "CLICK", valueOf, Z, g2, "tieba.baidu.com/p/" + d2Var.j1().g(), str);
                    String f2 = d2Var.j1().f();
                    StatisticItem statisticItem = new StatisticItem("c13329");
                    statisticItem.param("fid", d2Var.T());
                    statisticItem.param("obj_id", f2);
                    TiebaStatic.log(statisticItem);
                }
                b.a.r0.x0.u2.c.j().g(this.f26610b.z, d2Var, 1);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements b.a.e.l.e.w {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b0 f26611e;

        public b(b0 b0Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {b0Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f26611e = b0Var;
        }

        @Override // b.a.e.l.e.w
        public void b(View view, b.a.e.l.e.n nVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i2, long j) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{view, nVar, bdUniqueId, viewGroup, Integer.valueOf(i2), Long.valueOf(j)}) == null) && (nVar instanceof c2) && (view.getTag() instanceof ThreadCardViewHolder)) {
                ThreadCardViewHolder threadCardViewHolder = (ThreadCardViewHolder) view.getTag();
                d2 d2Var = ((c2) nVar).w;
                d2Var.objType = 1;
                if (this.f26611e.B != null) {
                    this.f26611e.B.a(threadCardViewHolder.getView(), d2Var);
                }
                ThreadCardUtils.jumpToPB((b.a.q0.s.q.a) d2Var, view.getContext(), this.f26611e.y, false);
                threadCardViewHolder.getCardView().n(new a.C0090a(1));
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b0(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2, boolean z) {
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
        this.z = new b.a.r0.x0.u2.b();
        this.A = false;
        this.B = new a(this);
        this.x = new HashSet();
    }

    public final b.a.r0.q2.p E0(d2 d2Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, d2Var)) == null) {
            if (d2Var == null) {
                return null;
            }
            b.a.r0.q2.p pVar = new b.a.r0.q2.p();
            if (100 == h0().tabType) {
                pVar.f22882a = d2Var.W1() ? "3" : "25";
            } else {
                pVar.f22882a = d2Var.W1() ? "3" : "2";
            }
            pVar.f22885d = this.z.f26387c;
            pVar.f22884c = d2Var.s1();
            pVar.f22887f = d2Var.X0;
            pVar.f22888g = d2Var.b1;
            pVar.f22889h = d2Var.Y0;
            pVar.l = d2Var.Z0;
            if (d2Var.q1() != null) {
                pVar.m = d2Var.q1().video_md5;
            }
            return pVar;
        }
        return (b.a.r0.q2.p) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // b.a.e.l.e.a
    /* renamed from: F0 */
    public AutoVideoCardViewHolder T(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, viewGroup)) == null) {
            l0.b bVar = new l0.b(this.o.getPageActivity());
            b.a.l.d dVar = new b.a.l.d(this.o.getPageActivity());
            dVar.a(696);
            dVar.s(this.f2423i);
            bVar.o(dVar);
            b.a.l.r rVar = new b.a.l.r(this.o.getPageActivity());
            rVar.A(this.A);
            bVar.n(rVar);
            b.a.l.n nVar = new b.a.l.n(this.o.getPageActivity());
            nVar.w(this.A);
            nVar.v("frs");
            bVar.h(nVar);
            n0 n0Var = new n0(this.o.getPageActivity());
            b.a.q0.s.q.f fVar = new b.a.q0.s.q.f();
            if (100 == h0().tabType) {
                fVar.f13300b = 25;
                n0Var.v(19);
                n0Var.z(14);
            } else {
                fVar.f13300b = 2;
                n0Var.v(2);
                n0Var.z(1);
            }
            fVar.f13306h = 2;
            n0Var.u(fVar);
            n0Var.w(this.y);
            n0Var.a(16);
            bVar.m(n0Var);
            l0 i2 = bVar.i();
            AutoVideoCardViewHolder autoVideoCardViewHolder = new AutoVideoCardViewHolder(i2);
            autoVideoCardViewHolder.setPageId(this.f2423i);
            i2.o(this.B);
            i2.q(this.y);
            c0(new b(this));
            autoVideoCardViewHolder.showMultiDelDecorItem();
            return autoVideoCardViewHolder;
        }
        return (AutoVideoCardViewHolder) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // b.a.r0.x0.k, b.a.e.l.e.a
    /* renamed from: G0 */
    public View Z(int i2, View view, ViewGroup viewGroup, c2 c2Var, AutoVideoCardViewHolder<d2> autoVideoCardViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Integer.valueOf(i2), view, viewGroup, c2Var, autoVideoCardViewHolder})) == null) {
            if (autoVideoCardViewHolder == null) {
                return null;
            }
            if (this.z != null) {
                FrsViewData frsViewData = this.n;
                c2Var.w.T1 = (i2 + 1) - (frsViewData != null ? frsViewData.getTopThreadSize() : 0);
            }
            b.a.r0.x0.u2.c.j().c(this.z, c2Var.w);
            b.a.r0.x0.u2.a.m(c2Var.w, this.f2423i, this.z, h0());
            b2 j1 = c2Var.w.j1();
            if (j1 != null) {
                String f2 = j1.f();
                String d2 = j1.d();
                if (StringUtils.isNull(d2)) {
                    d2 = j1.f();
                }
                String str = d2;
                if (this.o.getOrignalPage() instanceof t0) {
                    t0 t0Var = (t0) this.o.getOrignalPage();
                    if (this.x.add(f2)) {
                        String forumId = t0Var.getForumId();
                        String forumName = t0Var.getForumName();
                        String g2 = j1.g();
                        b.a.r0.l3.l0.a.c("frs", "VIEW_TRUE", forumId, forumName, g2, "tieba.baidu.com/p/" + c2Var.w.s1(), str);
                    }
                }
                StatisticItem statisticItem = new StatisticItem("c13324");
                statisticItem.param("fid", c2Var.w.T());
                statisticItem.param("tid", c2Var.w.s1());
                statisticItem.param("obj_id", f2);
                statisticItem.param("thread_type", c2Var.w.o1());
                TiebaStatic.log(statisticItem);
            }
            if (c2Var != null) {
                c2Var.w.O4();
                if ((c2Var.w.q1() != null ? (char) 2 : (char) 1) == 2) {
                    autoVideoCardViewHolder.setVideoStatsData(E0(c2Var.w));
                }
                autoVideoCardViewHolder.getCardView().e().a(32);
                autoVideoCardViewHolder.onBindDataToView(c2Var.w);
                autoVideoCardViewHolder.getCardView().onChangeSkinType(this.o, TbadkCoreApplication.getInst().getSkinType());
                autoVideoCardViewHolder.getCardView().o(this.B);
                b.a.r0.x0.j.i(autoVideoCardViewHolder.getCardView().e(), this.n);
            }
            return autoVideoCardViewHolder.getView();
        }
        return (View) invokeCommon.objValue;
    }

    @Override // b.a.r0.b0.a0
    public void a(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, str) == null) {
        }
    }

    @Override // b.a.r0.x0.u2.d
    public b.a.r0.x0.u2.b j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.z : (b.a.r0.x0.u2.b) invokeV.objValue;
    }

    @Override // b.a.r0.x0.k
    public void j0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            super.j0();
            this.x.clear();
        }
    }

    @Override // b.a.r0.b0.a0
    public void r(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2) == null) {
            this.y = i2;
        }
    }

    @Override // b.a.r0.x0.k
    public void setFromCDN(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048585, this, z) == null) {
            this.A = z;
        }
    }
}
