package c.a.p0.f1.p1.d;

import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.InputDeviceCompat;
import c.a.l.a;
import c.a.l.l0;
import c.a.l.t0;
import c.a.l.w0.a;
import c.a.o0.r.r.a2;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.card.AutoVideoCardViewHolder;
import com.baidu.card.ThreadCardViewHolder;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tbadk.core.util.CommonStatisticKey;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.ThreadCardUtils;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.view.ThreadGodReplyLayout;
import com.baidu.tieba.R;
import com.baidu.tieba.card.data.BaseCardInfo;
import com.baidu.tieba.tbadkCore.FrsViewData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes2.dex */
public class z extends c.a.p0.f1.k<a2, AutoVideoCardViewHolder<ThreadData>> implements c.a.p0.h0.z, c.a.p0.f1.o2.d, c.a.p0.v.f, c.a.p0.h0.a0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext<?> t;
    public String u;
    public String v;
    public int w;
    public c.a.p0.f1.o2.b x;
    public c.a.p0.h0.b0<ThreadData> y;

    /* loaded from: classes2.dex */
    public class a extends c.a.p0.h0.b0<ThreadData> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ z f14360b;

        public a(z zVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {zVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f14360b = zVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.p0.h0.b0
        /* renamed from: d */
        public void a(View view, ThreadData threadData) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view, threadData) == null) || view == null || threadData == null) {
                return;
            }
            if (this.f14360b.q != null) {
                this.f14360b.q.b(view, threadData, ThreadData.TYPE_VIDEO);
            }
            if ("c13010".equals(this.f14360b.v)) {
                TiebaStatic.log(new StatisticItem("c13010").param("obj_type", 2).param("fid", threadData.getFid()).param("tid", threadData.getTid()));
            }
            if (view.getId() == R.id.obfuscated_res_0x7f091f9a && threadData.isVideoThreadType()) {
                c.a.p0.f1.o2.c.k().h(this.f14360b.x, threadData, 1);
                this.f14360b.J0(threadData);
            } else if (view.getId() == R.id.obfuscated_res_0x7f090540) {
                TiebaStatic.log(new StatisticItem(CommonStatisticKey.USER_ICON_VISIT).param("obj_type", 3));
            } else if (view.getId() == R.id.obfuscated_res_0x7f0922bb || view.getId() == R.id.obfuscated_res_0x7f092296) {
                c.a.p0.f1.o2.c.k().h(this.f14360b.x, threadData, 2);
            } else if (view.getId() == R.id.obfuscated_res_0x7f090d37) {
                c.a.p0.f1.r2.q.a(this.f14360b.x, threadData.getRecomReason());
            } else if (view.getId() == R.id.obfuscated_res_0x7f09160b) {
                c.a.p0.f1.o2.c.k().h(this.f14360b.x, threadData, 4);
                this.f14360b.J0(threadData);
            } else if (view instanceof ThreadGodReplyLayout) {
                this.f14360b.J0(threadData);
            }
            if (view.getId() == R.id.obfuscated_res_0x7f09160b) {
                c.a.p0.f1.o2.a.e(threadData, 4, this.f14360b.f2571e, this.f14360b.x, this.f14360b.a0());
                c.a.p0.f1.r2.q.g(threadData, this.f14360b.j, 2);
            } else if (view.getId() == R.id.obfuscated_res_0x7f092361) {
                c.a.p0.f1.o2.a.e(threadData, 4, this.f14360b.f2571e, this.f14360b.x, this.f14360b.a0());
                c.a.p0.f1.r2.q.g(threadData, this.f14360b.j, 1);
            } else if (view.getId() != R.id.obfuscated_res_0x7f0922bb && view.getId() != R.id.obfuscated_res_0x7f092296) {
                if (view.getId() == R.id.obfuscated_res_0x7f091fac) {
                    c.a.p0.f1.o2.a.e(threadData, 5, this.f14360b.f2571e, this.f14360b.x, this.f14360b.a0());
                    c.a.p0.f1.r2.q.g(threadData, this.f14360b.j, 1);
                } else if (view instanceof ThreadGodReplyLayout) {
                    c.a.p0.f1.o2.a.e(threadData, 15, this.f14360b.f2571e, this.f14360b.x, this.f14360b.a0());
                    c.a.p0.f1.r2.q.g(threadData, this.f14360b.j, 1);
                } else if (view.getId() != R.id.obfuscated_res_0x7f091ccb) {
                    c.a.p0.f1.r2.q.g(threadData, this.f14360b.j, 1);
                    c.a.p0.f1.o2.a.e(threadData, 1, this.f14360b.f2571e, this.f14360b.x, this.f14360b.a0());
                } else {
                    c.a.p0.f1.o2.a.e(threadData, 14, this.f14360b.f2571e, this.f14360b.x, this.f14360b.a0());
                }
            } else {
                c.a.p0.f1.o2.a.e(threadData, 2, this.f14360b.f2571e, this.f14360b.x, this.f14360b.a0());
            }
        }
    }

    /* loaded from: classes2.dex */
    public class b implements a.InterfaceC0194a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ t0 a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ z f14361b;

        public b(z zVar, t0 t0Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {zVar, t0Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f14361b = zVar;
            this.a = t0Var;
        }

        @Override // c.a.l.a.InterfaceC0194a
        public void a(c.a.o0.r.r.a aVar) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) || aVar == null) {
                return;
            }
            Rect computeViewArea = ThreadCardUtils.computeViewArea(this.a.getVideoContainer());
            if (!(aVar instanceof ThreadData)) {
                ThreadCardUtils.jumpToPB(aVar, this.f14361b.a, this.f14361b.w, false, computeViewArea);
                return;
            }
            aVar.objType = 5;
            ThreadCardUtils.jumpToPB(aVar, this.f14361b.a, this.f14361b.w, false, computeViewArea);
        }
    }

    /* loaded from: classes2.dex */
    public class c implements c.a.d.o.e.w {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ z a;

        public c(z zVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {zVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = zVar;
        }

        @Override // c.a.d.o.e.w
        public void b(View view, c.a.d.o.e.n nVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i, long j) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{view, nVar, bdUniqueId, viewGroup, Integer.valueOf(i), Long.valueOf(j)}) == null) && (nVar instanceof a2) && (view.getTag() instanceof ThreadCardViewHolder)) {
                ThreadCardViewHolder threadCardViewHolder = (ThreadCardViewHolder) view.getTag();
                ThreadData threadData = ((a2) nVar).s;
                threadData.objType = 1;
                if (this.a.y != null) {
                    this.a.y.a(threadCardViewHolder.b(), threadData);
                }
                ThreadCardUtils.jumpToPB((c.a.o0.r.r.a) threadData, view.getContext(), this.a.w, false, c.a.l.e.a((c.a.d.o.e.s) viewGroup, view, i));
                threadCardViewHolder.c().o(new a.C0196a(1));
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public z(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2) {
        super(tbPageContext, bdUniqueId, bdUniqueId2);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, bdUniqueId, bdUniqueId2};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((TbPageContext) objArr2[0], (BdUniqueId) objArr2[1], (BdUniqueId) objArr2[2]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.w = 3;
        this.x = new c.a.p0.f1.o2.b();
        this.y = new a(this);
        this.t = tbPageContext;
    }

    public final c.a.p0.c3.u G0(ThreadData threadData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, threadData)) == null) {
            if (threadData == null) {
                return null;
            }
            c.a.p0.c3.u uVar = new c.a.p0.c3.u();
            if (100 == a0().tabType) {
                uVar.a = threadData.isFloor5Video() ? "3" : "25";
            } else {
                uVar.a = threadData.isFloor5Video() ? "3" : "2";
            }
            if (this.x.f14302e == 501) {
                uVar.a = "frs_tab";
            }
            uVar.f13505d = this.x.f14300c;
            uVar.f13504c = threadData.getTid();
            uVar.f13507f = threadData.mRecomSource;
            uVar.f13508g = threadData.mRecomReason;
            uVar.f13509h = threadData.mRecomWeight;
            uVar.l = threadData.mRecomAbTag;
            if (threadData.getThreadVideoInfo() != null) {
                uVar.m = threadData.getThreadVideoInfo().video_md5;
            }
            return uVar;
        }
        return (c.a.p0.c3.u) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.a.d.o.e.a
    /* renamed from: H0 */
    public AutoVideoCardViewHolder M(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, viewGroup)) == null) {
            l0.b bVar = new l0.b(this.t.getPageActivity(), false);
            c.a.l.g gVar = new c.a.l.g(this.t.getPageActivity(), true);
            gVar.t("frs");
            gVar.x("2003");
            gVar.u(new b(this, gVar));
            if (this.w == 502) {
                gVar.v(false);
            } else {
                gVar.v(true);
            }
            bVar.n(gVar);
            l0 k = bVar.k(BaseCardInfo.SupportType.CONTENT, viewGroup, this.m);
            AutoVideoCardViewHolder autoVideoCardViewHolder = new AutoVideoCardViewHolder(k);
            autoVideoCardViewHolder.k(this.f2571e);
            k.p(this.y);
            k.r(this.w);
            V(new c(this));
            autoVideoCardViewHolder.p(false);
            return autoVideoCardViewHolder;
        }
        return (AutoVideoCardViewHolder) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.a.p0.f1.k, c.a.d.o.e.a
    /* renamed from: I0 */
    public View S(int i, View view, ViewGroup viewGroup, a2 a2Var, AutoVideoCardViewHolder<ThreadData> autoVideoCardViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Integer.valueOf(i), view, viewGroup, a2Var, autoVideoCardViewHolder})) == null) {
            if (autoVideoCardViewHolder == null) {
                return null;
            }
            if (a2Var == null) {
                return autoVideoCardViewHolder.b();
            }
            if (autoVideoCardViewHolder.c() instanceof c.a.p0.v.e) {
                autoVideoCardViewHolder.c().e(this.u);
            }
            super.S(i, view, viewGroup, a2Var, autoVideoCardViewHolder);
            c.a.p0.f1.j.i(autoVideoCardViewHolder.c().f(), this.j);
            autoVideoCardViewHolder.w(G0(a2Var.s));
            autoVideoCardViewHolder.c().q(i);
            FrsViewData frsViewData = this.j;
            if (frsViewData != null && frsViewData.getForum() != null && !StringUtils.isNull(this.j.getForum().getTopic_special_icon()) && !StringUtils.isNull(this.j.getForum().getTopic_special_icon_right())) {
                a2Var.s.setSpecUrl(this.j.getForum().getTopic_special_icon(), this.j.getForum().getTopic_special_icon_right());
            }
            autoVideoCardViewHolder.g(a2Var.s);
            autoVideoCardViewHolder.c().onChangeSkinType(this.t, TbadkCoreApplication.getInst().getSkinType());
            autoVideoCardViewHolder.c().p(this.y);
            if (this.x != null) {
                FrsViewData frsViewData2 = this.j;
                a2Var.s.statFloor = (a2Var.position + 1) - (frsViewData2 != null ? frsViewData2.getTopThreadSize() : 0);
            }
            c.a.p0.f1.o2.c.k().c(this.x, a2Var.s);
            c.a.p0.f1.o2.c.k().b(a2Var.s);
            c.a.p0.f1.o2.c.k().e(a2Var.s, b0());
            c.a.p0.f1.o2.a.n(a2Var.s, this.f2571e, this.x, a0());
            FrsViewData frsViewData3 = this.j;
            if (frsViewData3 != null && frsViewData3.getForum() != null) {
                c.a.p0.f1.o2.a.l(a2Var.s, a0());
                c.a.p0.f1.o2.a.m(a2Var.s, this.j.getForum().getId());
            }
            if (100 == a0().tabType) {
                c.a.p0.f1.o2.c.k().f(a2Var.s);
            }
            a2Var.s.updateShowStatus();
            return autoVideoCardViewHolder.b();
        }
        return (View) invokeCommon.objValue;
    }

    public final void J0(ThreadData threadData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, threadData) == null) {
            TiebaStatic.log(new StatisticItem("c12126").param("tid", threadData.getId()).param("obj_locate", b0() ? 2 : 1).param("obj_id", threadData.getThreadAlaInfo() == null ? -1L : threadData.getThreadAlaInfo().live_id).param("obj_type", 1));
        }
    }

    @Override // c.a.p0.h0.z
    public void a(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, str) == null) {
        }
    }

    @Override // c.a.p0.v.f
    public void g(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, str) == null) {
            this.u = str;
        }
    }

    @Override // c.a.p0.f1.o2.d
    public c.a.p0.f1.o2.b j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.x : (c.a.p0.f1.o2.b) invokeV.objValue;
    }

    @Override // c.a.p0.h0.a0
    public void l(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048585, this, z) == null) {
        }
    }

    @Override // c.a.p0.h0.z
    public void r(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048586, this, i) == null) {
            this.w = i;
        }
    }

    @Override // c.a.p0.f1.k
    public void setFrom(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, str) == null) {
            this.v = str;
        }
    }
}
