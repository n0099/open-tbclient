package c.a.p0.f1.p1.d;

import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.InputDeviceCompat;
import c.a.l.l0;
import c.a.l.n0;
import c.a.l.w0.a;
import c.a.o0.r.r.z1;
import c.a.p0.f1.u0;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.card.AutoVideoCardViewHolder;
import com.baidu.card.ThreadCardViewHolder;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.ThreadData;
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
/* loaded from: classes2.dex */
public class c0 extends c.a.p0.f1.k<ThreadData, AutoVideoCardViewHolder<ThreadData>> implements c.a.p0.h0.z, c.a.p0.f1.o2.d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Set<String> t;
    public int u;
    public c.a.p0.f1.o2.b v;
    public boolean w;
    public c.a.p0.h0.b0<ThreadData> x;

    /* loaded from: classes2.dex */
    public class a extends c.a.p0.h0.b0<ThreadData> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ c0 f14322b;

        public a(c0 c0Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {c0Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f14322b = c0Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.p0.h0.b0
        /* renamed from: d */
        public void a(View view, ThreadData threadData) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view, threadData) == null) || view == null || threadData == null) {
                return;
            }
            if (view.getId() != R.id.obfuscated_res_0x7f0922bb && view.getId() != R.id.obfuscated_res_0x7f092296) {
                if (view.getId() == R.id.obfuscated_res_0x7f091fac) {
                    c.a.p0.f1.o2.a.e(threadData, 5, this.f14322b.f2571e, this.f14322b.v, this.f14322b.a0());
                } else if (view.getId() == R.id.obfuscated_res_0x7f090eb9) {
                    c.a.p0.f1.o2.a.e(threadData, 3, this.f14322b.f2571e, this.f14322b.v, this.f14322b.a0());
                } else if (view instanceof ThreadGodReplyLayout) {
                    c.a.p0.f1.o2.a.e(threadData, 15, this.f14322b.f2571e, this.f14322b.v, this.f14322b.a0());
                } else if (view.getId() == R.id.obfuscated_res_0x7f091ccb) {
                    c.a.p0.f1.o2.a.e(threadData, 14, this.f14322b.f2571e, this.f14322b.v, this.f14322b.a0());
                } else if (view.getId() == R.id.obfuscated_res_0x7f090e9b) {
                    c.a.p0.f1.o2.a.e(threadData, 12, this.f14322b.f2571e, this.f14322b.v, this.f14322b.a0());
                } else if (view.getId() == R.id.obfuscated_res_0x7f090eb1) {
                    c.a.p0.f1.o2.a.e(threadData, 13, this.f14322b.f2571e, this.f14322b.v, this.f14322b.a0());
                } else {
                    c.a.p0.f1.o2.a.e(threadData, 1, this.f14322b.f2571e, this.f14322b.v, this.f14322b.a0());
                }
            } else {
                c.a.p0.f1.o2.a.e(threadData, 2, this.f14322b.f2571e, this.f14322b.v, this.f14322b.a0());
            }
            if (view.getId() == R.id.obfuscated_res_0x7f0922bb || view.getId() == R.id.obfuscated_res_0x7f092296) {
                c.a.p0.f1.o2.c.k().h(this.f14322b.v, threadData, 2);
            } else if (view.getId() == R.id.obfuscated_res_0x7f091f9a) {
                if (threadData.getTaskInfoStatus() == 2 && threadData.getTaskInfoData() != null) {
                    String d2 = threadData.getTaskInfoData().d();
                    if (StringUtils.isNull(d2)) {
                        d2 = threadData.getTaskInfoData().f();
                    }
                    String str = d2;
                    String valueOf = String.valueOf(threadData.getFid());
                    String forum_name = threadData.getForum_name();
                    String g2 = threadData.getTaskInfoData().g();
                    c.a.p0.a4.m0.a.c("frs", "CLICK", valueOf, forum_name, g2, "tieba.baidu.com/p/" + threadData.getTaskInfoData().g(), str);
                    String f2 = threadData.getTaskInfoData().f();
                    StatisticItem statisticItem = new StatisticItem("c13329");
                    statisticItem.param("fid", threadData.getFid());
                    statisticItem.param("obj_id", f2);
                    TiebaStatic.log(statisticItem);
                }
                c.a.p0.f1.o2.c.k().h(this.f14322b.v, threadData, 1);
            }
        }
    }

    /* loaded from: classes2.dex */
    public class b implements c.a.d.o.e.w {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ c0 a;

        public b(c0 c0Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {c0Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = c0Var;
        }

        @Override // c.a.d.o.e.w
        public void b(View view, c.a.d.o.e.n nVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i, long j) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{view, nVar, bdUniqueId, viewGroup, Integer.valueOf(i), Long.valueOf(j)}) == null) && (nVar instanceof ThreadData) && (view.getTag() instanceof ThreadCardViewHolder)) {
                ThreadCardViewHolder threadCardViewHolder = (ThreadCardViewHolder) view.getTag();
                ThreadData threadData = (ThreadData) nVar;
                threadData.objType = 1;
                if (this.a.x != null) {
                    this.a.x.a(threadCardViewHolder.b(), threadData);
                }
                ThreadCardUtils.jumpToPB((c.a.o0.r.r.a) threadData, view.getContext(), this.a.u, false);
                threadCardViewHolder.c().o(new a.C0196a(1));
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
        this.u = 3;
        this.v = new c.a.p0.f1.o2.b();
        this.w = false;
        this.x = new a(this);
        this.t = new HashSet();
    }

    @Override // c.a.p0.h0.z
    public void a(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
        }
    }

    @Override // c.a.p0.f1.k
    public void c0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            super.c0();
            this.t.clear();
        }
    }

    @Override // c.a.p0.f1.o2.d
    public c.a.p0.f1.o2.b j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.v : (c.a.p0.f1.o2.b) invokeV.objValue;
    }

    @Override // c.a.p0.h0.z
    public void r(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048581, this, i) == null) {
            this.u = i;
        }
    }

    @Override // c.a.p0.f1.k
    public void setFromCDN(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048582, this, z) == null) {
            this.w = z;
        }
    }

    public final c.a.p0.c3.u w0(ThreadData threadData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, threadData)) == null) {
            if (threadData == null) {
                return null;
            }
            c.a.p0.c3.u uVar = new c.a.p0.c3.u();
            if (100 == a0().tabType) {
                uVar.a = threadData.isFloor5Video() ? "3" : "25";
            } else {
                uVar.a = threadData.isFloor5Video() ? "3" : "2";
            }
            uVar.f13505d = this.v.f14300c;
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
    /* renamed from: x0 */
    public AutoVideoCardViewHolder M(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, viewGroup)) == null) {
            l0.b bVar = new l0.b(this.k.getPageActivity());
            c.a.l.d dVar = new c.a.l.d(this.k.getPageActivity());
            dVar.b(696);
            dVar.t(this.f2571e);
            bVar.o(dVar);
            c.a.l.r rVar = new c.a.l.r(this.k.getPageActivity());
            rVar.A(this.w);
            bVar.n(rVar);
            c.a.l.n nVar = new c.a.l.n(this.k.getPageActivity());
            nVar.x(this.w);
            nVar.w("frs");
            bVar.h(nVar);
            n0 n0Var = new n0(this.k.getPageActivity());
            c.a.o0.r.r.f fVar = new c.a.o0.r.r.f();
            if (100 == a0().tabType) {
                fVar.f10852b = 25;
                n0Var.w(19);
                n0Var.A(14);
            } else {
                fVar.f10852b = 2;
                n0Var.w(2);
                n0Var.A(1);
            }
            fVar.f10858h = 2;
            n0Var.v(fVar);
            n0Var.x(this.u);
            n0Var.b(16);
            bVar.m(n0Var);
            l0 i = bVar.i();
            AutoVideoCardViewHolder autoVideoCardViewHolder = new AutoVideoCardViewHolder(i);
            autoVideoCardViewHolder.k(this.f2571e);
            i.p(this.x);
            i.r(this.u);
            V(new b(this));
            autoVideoCardViewHolder.o();
            return autoVideoCardViewHolder;
        }
        return (AutoVideoCardViewHolder) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.a.p0.f1.k, c.a.d.o.e.a
    /* renamed from: y0 */
    public View S(int i, View view, ViewGroup viewGroup, ThreadData threadData, AutoVideoCardViewHolder<ThreadData> autoVideoCardViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048585, this, new Object[]{Integer.valueOf(i), view, viewGroup, threadData, autoVideoCardViewHolder})) == null) {
            if (autoVideoCardViewHolder == null) {
                return null;
            }
            if (this.v != null) {
                FrsViewData frsViewData = this.j;
                threadData.statFloor = (i + 1) - (frsViewData != null ? frsViewData.getTopThreadSize() : 0);
            }
            c.a.p0.f1.o2.c.k().c(this.v, threadData);
            c.a.p0.f1.o2.a.n(threadData, this.f2571e, this.v, a0());
            z1 taskInfoData = threadData.getTaskInfoData();
            if (taskInfoData != null) {
                String f2 = taskInfoData.f();
                String d2 = taskInfoData.d();
                if (StringUtils.isNull(d2)) {
                    d2 = taskInfoData.f();
                }
                String str = d2;
                if (this.k.getOrignalPage() instanceof u0) {
                    u0 u0Var = (u0) this.k.getOrignalPage();
                    if (this.t.add(f2)) {
                        String c2 = u0Var.c();
                        String a2 = u0Var.a();
                        String g2 = taskInfoData.g();
                        c.a.p0.a4.m0.a.c("frs", "VIEW_TRUE", c2, a2, g2, "tieba.baidu.com/p/" + threadData.getTid(), str);
                    }
                }
                StatisticItem statisticItem = new StatisticItem("c13324");
                statisticItem.param("fid", threadData.getFid());
                statisticItem.param("tid", threadData.getTid());
                statisticItem.param("obj_id", f2);
                statisticItem.param("thread_type", threadData.getThreadType());
                TiebaStatic.log(statisticItem);
            }
            if (threadData != null) {
                threadData.updateShowStatus();
                if ((threadData.getThreadVideoInfo() != null ? (char) 2 : (char) 1) == 2) {
                    autoVideoCardViewHolder.w(w0(threadData));
                }
                autoVideoCardViewHolder.c().f().b(32);
                autoVideoCardViewHolder.g(threadData);
                autoVideoCardViewHolder.c().onChangeSkinType(this.k, TbadkCoreApplication.getInst().getSkinType());
                autoVideoCardViewHolder.c().p(this.x);
                c.a.p0.f1.j.i(autoVideoCardViewHolder.c().f(), this.j);
            }
            return autoVideoCardViewHolder.b();
        }
        return (View) invokeCommon.objValue;
    }
}
