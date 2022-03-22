package c.a.p0.f1.p1.d;

import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.InputDeviceCompat;
import c.a.l.l0;
import c.a.l.w0.a;
import c.a.o0.r.r.a2;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.card.ThreadCardViewHolder;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tbadk.core.util.CommonStatisticKey;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.ThreadCardUtils;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.view.ThreadGodReplyLayout;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.card.data.BaseCardInfo;
import com.baidu.tieba.tbadkCore.FrsViewData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes2.dex */
public class k extends c.a.p0.f1.k<a2, ThreadCardViewHolder<ThreadData>> implements c.a.p0.h0.z, c.a.p0.f1.o2.d, c.a.p0.v.f {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String t;
    public String u;
    public boolean v;
    public int w;
    public c.a.p0.h0.b0<ThreadData> x;

    /* loaded from: classes2.dex */
    public class a extends c.a.p0.h0.b0<ThreadData> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ k f14340b;

        public a(k kVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {kVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f14340b = kVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.p0.h0.b0
        /* renamed from: d */
        public void a(View view, ThreadData threadData) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view, threadData) == null) || view == null || threadData == null) {
                return;
            }
            if (this.f14340b.q != null) {
                this.f14340b.q.b(view, threadData, this.f14340b.getType());
            }
            if ("c13010".equals(this.f14340b.t)) {
                TiebaStatic.log(new StatisticItem("c13010").param("obj_type", 1).param("fid", threadData.getFid()).param("tid", threadData.getTid()));
            }
            if (view.getId() != R.id.obfuscated_res_0x7f0922bb && view.getId() != R.id.obfuscated_res_0x7f092296) {
                if (view.getId() == R.id.obfuscated_res_0x7f091fac) {
                    c.a.p0.f1.o2.a.e(threadData, 5, this.f14340b.f2571e, c.a.p0.f1.o2.d.f0, this.f14340b.a0());
                    c.a.p0.f1.r2.q.g(threadData, this.f14340b.j, 1);
                } else if (view.getId() == R.id.obfuscated_res_0x7f091ccb) {
                    c.a.p0.f1.o2.a.e(threadData, 14, this.f14340b.f2571e, c.a.p0.f1.o2.d.f0, this.f14340b.a0());
                } else if (view instanceof TbImageView) {
                    if (this.f14340b.x.a instanceof Boolean) {
                        if (((Boolean) this.f14340b.x.a).booleanValue()) {
                            c.a.p0.f1.o2.a.e(threadData, 1, this.f14340b.f2571e, c.a.p0.f1.o2.d.f0, this.f14340b.a0());
                        } else {
                            c.a.p0.f1.o2.a.e(threadData, 3, this.f14340b.f2571e, c.a.p0.f1.o2.d.f0, this.f14340b.a0());
                        }
                    }
                    c.a.p0.f1.r2.q.g(threadData, this.f14340b.j, 2);
                } else if (view instanceof ThreadGodReplyLayout) {
                    c.a.p0.f1.o2.a.e(threadData, 15, this.f14340b.f2571e, c.a.p0.f1.o2.d.f0, this.f14340b.a0());
                    c.a.p0.f1.r2.q.g(threadData, this.f14340b.j, 1);
                } else {
                    c.a.p0.f1.o2.a.e(threadData, 1, this.f14340b.f2571e, c.a.p0.f1.o2.d.f0, this.f14340b.a0());
                    c.a.p0.f1.r2.q.g(threadData, this.f14340b.j, 1);
                }
            } else {
                c.a.p0.f1.o2.a.e(threadData, 2, this.f14340b.f2571e, c.a.p0.f1.o2.d.f0, this.f14340b.a0());
            }
            if (view.getId() == R.id.obfuscated_res_0x7f091f9a && threadData.isVideoThreadType()) {
                this.f14340b.E0(threadData);
            } else if (view.getId() != R.id.obfuscated_res_0x7f0922bb && view.getId() != R.id.obfuscated_res_0x7f092296) {
                if (view.getId() == R.id.obfuscated_res_0x7f0904f7) {
                    c.a.p0.f1.r2.q.a(c.a.p0.f1.o2.d.f0, threadData.getRecomReason());
                } else if (view instanceof TbImageView) {
                    if (this.f14340b.x.a instanceof Boolean) {
                        if (((Boolean) this.f14340b.x.a).booleanValue()) {
                            c.a.p0.f1.o2.c.k().h(c.a.p0.f1.o2.d.f0, threadData, 1);
                        } else {
                            c.a.p0.f1.o2.c.k().h(c.a.p0.f1.o2.d.f0, threadData, 3);
                        }
                    }
                } else if (view.getId() == R.id.obfuscated_res_0x7f090540) {
                    TiebaStatic.log(new StatisticItem(CommonStatisticKey.USER_ICON_VISIT).param("obj_type", 3));
                } else if (view.getId() == R.id.obfuscated_res_0x7f091f9c) {
                    c.a.p0.f1.o2.c.k().h(c.a.p0.f1.o2.d.f0, threadData, 5);
                } else if (view instanceof ThreadGodReplyLayout) {
                    int i = 6;
                    if (threadData.getTopAgreePost() != null && threadData.getTopAgreePost().N() != null && threadData.getTopAgreePost().N().A() != null && threadData.getTopAgreePost().N().A().size() > 0) {
                        i = threadData.getTopAgreePost().L ? 9 : 8;
                    }
                    c.a.p0.f1.o2.c.k().h(c.a.p0.f1.o2.d.f0, threadData, i);
                } else {
                    c.a.p0.f1.o2.c.k().h(c.a.p0.f1.o2.d.f0, threadData, 1);
                }
            } else {
                c.a.p0.f1.o2.c.k().h(c.a.p0.f1.o2.d.f0, threadData, 2);
            }
        }
    }

    /* loaded from: classes2.dex */
    public class b implements c.a.d.o.e.w {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ k a;

        public b(k kVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {kVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = kVar;
        }

        @Override // c.a.d.o.e.w
        public void b(View view, c.a.d.o.e.n nVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i, long j) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{view, nVar, bdUniqueId, viewGroup, Integer.valueOf(i), Long.valueOf(j)}) == null) && (nVar instanceof a2) && (view.getTag() instanceof ThreadCardViewHolder)) {
                ThreadCardViewHolder threadCardViewHolder = (ThreadCardViewHolder) view.getTag();
                ThreadData threadData = ((a2) nVar).s;
                threadData.objType = 1;
                if (this.a.x != null) {
                    this.a.x.a(threadCardViewHolder.b(), threadData);
                }
                ThreadCardUtils.jumpToPB((c.a.o0.r.r.a) threadData, view.getContext(), this.a.w, false);
                threadCardViewHolder.c().o(new a.C0196a(1));
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public k(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2) {
        super(tbPageContext, bdUniqueId);
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
                super((TbPageContext) objArr2[0], (BdUniqueId) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.v = true;
        this.w = 3;
        this.x = new a(this);
        this.k = tbPageContext;
        this.f2571e = bdUniqueId2;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.a.d.o.e.a
    /* renamed from: C0 */
    public ThreadCardViewHolder<ThreadData> M(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, viewGroup)) == null) {
            l0.b bVar = new l0.b(this.k.getPageActivity(), false);
            c.a.l.z zVar = new c.a.l.z(this.k.getPageActivity());
            zVar.r("frs");
            zVar.s(this.v);
            if (this.w == 502) {
                zVar.t(false);
            } else {
                zVar.t(true);
            }
            bVar.n(zVar);
            l0 k = bVar.k(BaseCardInfo.SupportType.CONTENT, viewGroup, this.m);
            k.r(3);
            ThreadCardViewHolder<ThreadData> threadCardViewHolder = new ThreadCardViewHolder<>(k);
            threadCardViewHolder.k(this.f2571e);
            threadCardViewHolder.p(false);
            V(new b(this));
            return threadCardViewHolder;
        }
        return (ThreadCardViewHolder) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.a.p0.f1.k, c.a.d.o.e.a
    /* renamed from: D0 */
    public View S(int i, View view, ViewGroup viewGroup, a2 a2Var, ThreadCardViewHolder<ThreadData> threadCardViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Integer.valueOf(i), view, viewGroup, a2Var, threadCardViewHolder})) == null) {
            super.S(i, view, viewGroup, a2Var, threadCardViewHolder);
            if (a2Var == null || threadCardViewHolder == null || threadCardViewHolder.b() == null) {
                return null;
            }
            threadCardViewHolder.c().e(this.u);
            threadCardViewHolder.c().q(i);
            c.a.p0.f1.j.i(threadCardViewHolder.c().f(), this.j);
            FrsViewData frsViewData = this.j;
            if (frsViewData != null && frsViewData.getForum() != null && !StringUtils.isNull(this.j.getForum().getTopic_special_icon()) && !StringUtils.isNull(this.j.getForum().getTopic_special_icon_right())) {
                a2Var.s.setSpecUrl(this.j.getForum().getTopic_special_icon(), this.j.getForum().getTopic_special_icon_right());
            }
            threadCardViewHolder.g(a2Var.s);
            threadCardViewHolder.c().onChangeSkinType(this.k, TbadkCoreApplication.getInst().getSkinType());
            threadCardViewHolder.c().p(this.x);
            a2Var.s.updateShowStatus();
            return threadCardViewHolder.b();
        }
        return (View) invokeCommon.objValue;
    }

    public final void E0(ThreadData threadData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, threadData) == null) {
            TiebaStatic.log(new StatisticItem("c12126").param("tid", threadData.getId()).param("obj_locate", b0() ? 2 : 1).param("obj_id", threadData.getThreadAlaInfo() == null ? -1L : threadData.getThreadAlaInfo().live_id).param("obj_type", 1));
        }
    }

    @Override // c.a.p0.h0.z
    public void a(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, str) == null) {
        }
    }

    @Override // c.a.p0.v.f
    public void g(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, str) == null) {
            this.u = str;
        }
    }

    @Override // c.a.p0.f1.o2.d
    public c.a.p0.f1.o2.b j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? c.a.p0.f1.o2.d.f0 : (c.a.p0.f1.o2.b) invokeV.objValue;
    }

    @Override // c.a.p0.h0.z
    public void r(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i) == null) {
            this.w = i;
        }
    }

    @Override // c.a.p0.f1.k
    public void setFrom(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, str) == null) {
            this.t = str;
        }
    }

    @Override // c.a.p0.f1.k
    public void setFromCDN(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048586, this, z) == null) {
            this.v = z;
        }
    }
}
