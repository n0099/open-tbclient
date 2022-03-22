package c.a.p0.f1.p1.d;

import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import androidx.core.view.InputDeviceCompat;
import c.a.l.l0;
import c.a.l.n0;
import c.a.l.w0.a;
import c.a.o0.r.r.a2;
import c.a.o0.r.r.v0;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.card.Align;
import com.baidu.card.ThreadCardViewHolder;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.util.CommonStatisticKey;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.ThreadCardUtils;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout;
import com.baidu.tbadk.core.view.ThreadGodReplyLayout;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.NEGFeedBack.NEGFeedBackView;
import com.baidu.tieba.R;
import com.baidu.tieba.card.data.BaseCardInfo;
import com.baidu.tieba.tbadkCore.FrsViewData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
/* loaded from: classes2.dex */
public class j extends c.a.p0.f1.k<a2, ThreadCardViewHolder<ThreadData>> implements c.a.p0.h0.z, c.a.p0.f1.o2.d, c.a.p0.v.f, c.a.p0.h0.a0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean t;
    public String u;
    public String v;
    public int w;
    public int x;
    public c.a.p0.h0.b0<ThreadData> y;
    public NEGFeedBackView.b z;

    /* loaded from: classes2.dex */
    public class a extends c.a.p0.h0.b0<ThreadData> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ j f14337b;

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
            this.f14337b = jVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.p0.h0.b0
        /* renamed from: d */
        public void a(View view, ThreadData threadData) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view, threadData) == null) || view == null || threadData == null) {
                return;
            }
            if (this.f14337b.q != null) {
                this.f14337b.q.b(view, threadData, this.f14337b.getType());
            }
            if ("c13010".equals(this.f14337b.u)) {
                TiebaStatic.log(new StatisticItem("c13010").param("obj_type", 1).param("fid", threadData.getFid()).param("tid", threadData.getTid()));
            }
            if (view.getId() != R.id.obfuscated_res_0x7f0922bb && view.getId() != R.id.obfuscated_res_0x7f092296) {
                if (view.getId() == R.id.obfuscated_res_0x7f091fac) {
                    c.a.p0.f1.o2.a.e(threadData, 5, this.f14337b.f2571e, c.a.p0.f1.o2.d.f0, this.f14337b.a0());
                    c.a.p0.f1.r2.q.g(threadData, this.f14337b.j, 1);
                } else if (view.getId() == R.id.obfuscated_res_0x7f091ccb) {
                    c.a.p0.f1.o2.a.e(threadData, 14, this.f14337b.f2571e, c.a.p0.f1.o2.d.f0, this.f14337b.a0());
                } else if (view.getId() == R.id.obfuscated_res_0x7f090e9b) {
                    c.a.p0.f1.o2.a.e(threadData, 12, this.f14337b.f2571e, c.a.p0.f1.o2.d.f0, this.f14337b.a0());
                } else if (view.getId() == R.id.obfuscated_res_0x7f090eb1) {
                    c.a.p0.f1.o2.a.e(threadData, 13, this.f14337b.f2571e, c.a.p0.f1.o2.d.f0, this.f14337b.a0());
                } else if (view instanceof TbImageView) {
                    if (this.f14337b.y.a instanceof Boolean) {
                        if (((Boolean) this.f14337b.y.a).booleanValue()) {
                            c.a.p0.f1.o2.a.e(threadData, 1, this.f14337b.f2571e, c.a.p0.f1.o2.d.f0, this.f14337b.a0());
                        } else {
                            c.a.p0.f1.o2.a.e(threadData, 3, this.f14337b.f2571e, c.a.p0.f1.o2.d.f0, this.f14337b.a0());
                        }
                    }
                    c.a.p0.f1.r2.q.g(threadData, this.f14337b.j, 2);
                } else if (view instanceof ThreadGodReplyLayout) {
                    c.a.p0.f1.o2.a.e(threadData, 15, this.f14337b.f2571e, c.a.p0.f1.o2.d.f0, this.f14337b.a0());
                    c.a.p0.f1.r2.q.g(threadData, this.f14337b.j, 1);
                } else {
                    c.a.p0.f1.o2.a.e(threadData, 1, this.f14337b.f2571e, c.a.p0.f1.o2.d.f0, this.f14337b.a0());
                    c.a.p0.f1.r2.q.g(threadData, this.f14337b.j, 1);
                }
            } else {
                c.a.p0.f1.o2.a.e(threadData, 2, this.f14337b.f2571e, c.a.p0.f1.o2.d.f0, this.f14337b.a0());
            }
            if (view.getId() == R.id.obfuscated_res_0x7f091f9a && threadData.isVideoThreadType()) {
                this.f14337b.G0(threadData);
            } else if (view.getId() != R.id.obfuscated_res_0x7f0922bb && view.getId() != R.id.obfuscated_res_0x7f092296) {
                if (view.getId() == R.id.obfuscated_res_0x7f0904f7) {
                    c.a.p0.f1.r2.q.a(c.a.p0.f1.o2.d.f0, threadData.getRecomReason());
                } else if (view instanceof TbImageView) {
                    if (this.f14337b.y.a instanceof Boolean) {
                        if (((Boolean) this.f14337b.y.a).booleanValue()) {
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

    /* loaded from: classes2.dex */
    public class c implements ThreadCommentAndPraiseInfoLayout.i {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ViewGroup a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ View f14338b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ int f14339c;

        public c(j jVar, ViewGroup viewGroup, View view, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {jVar, viewGroup, view, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = viewGroup;
            this.f14338b = view;
            this.f14339c = i;
        }

        @Override // com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout.i
        public void a(IntentConfig intentConfig) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, intentConfig) == null) && (intentConfig instanceof PbActivityConfig)) {
                ((PbActivityConfig) intentConfig).setVideoOriginArea(c.a.l.e.a((c.a.d.o.e.s) this.a, this.f14338b, this.f14339c));
            }
        }
    }

    /* loaded from: classes2.dex */
    public class d implements NEGFeedBackView.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public d(j jVar) {
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
                }
            }
        }

        @Override // com.baidu.tieba.NEGFeedBack.NEGFeedBackView.b
        public void a(ArrayList<Integer> arrayList, String str, v0 v0Var) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLLL(1048576, this, arrayList, str, v0Var) == null) || arrayList == null || v0Var == null) {
                return;
            }
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < arrayList.size(); i++) {
                sb.append(arrayList.get(i) + ",");
            }
            if (sb.length() > 0) {
                sb.deleteCharAt(sb.length() - 1);
            }
            TiebaStatic.log(new StatisticItem("c11974").param("obj_locate", sb.toString()).param("fid", v0Var.c()).param("tid", v0Var.f()).param("nid", v0Var.e()).param("uid", TbadkCoreApplication.getCurrentAccount()).param("source", v0Var.l).param("weight", v0Var.k).param("ab_tag", v0Var.p).param("extra", v0Var.m).param("card_type", v0Var.o).param(TiebaStatic.Params.OBJ_FLOOR, v0Var.q));
        }

        @Override // com.baidu.tieba.NEGFeedBack.NEGFeedBackView.b
        public void b(v0 v0Var, CompoundButton compoundButton, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, v0Var, compoundButton, z) == null) {
            }
        }

        @Override // com.baidu.tieba.NEGFeedBack.NEGFeedBackView.b
        public void c(v0 v0Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, v0Var) == null) {
                TiebaStatic.log(new StatisticItem("c11973").param("fid", v0Var.c()).param("tid", v0Var.f()).param("uid", TbadkCoreApplication.getCurrentAccount()));
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public j(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2) {
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
        this.t = false;
        this.w = 3;
        this.x = 13;
        this.y = new a(this);
        this.z = new d(this);
        this.k = tbPageContext;
        this.f2571e = bdUniqueId2;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.a.d.o.e.a
    /* renamed from: E0 */
    public ThreadCardViewHolder<ThreadData> M(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, viewGroup)) == null) {
            l0.b bVar = new l0.b(this.k.getPageActivity(), false);
            n0 n0Var = new n0(this.k.getPageActivity());
            c.a.o0.r.r.f fVar = new c.a.o0.r.r.f();
            if (100 == a0().tabType) {
                fVar.f10852b = this.t ? 10 : 25;
                n0Var.w(19);
                n0Var.A(14);
            } else {
                fVar.f10852b = this.t ? 10 : 2;
                if ("a070".equals(a0().locatePage)) {
                    n0Var.w(13);
                } else {
                    n0Var.w(2);
                }
                if (TbSingleton.getInstance().getFrsCurTabType() == this.x) {
                    n0Var.A(13);
                } else {
                    n0Var.A(1);
                }
            }
            fVar.f10858h = 2;
            FrsViewData frsViewData = this.j;
            if (frsViewData != null && frsViewData.getForum() != null && !c.a.d.f.p.m.isEmpty(this.j.getForum().getId())) {
                fVar.j = this.j.getForum().getId();
            }
            n0Var.v(fVar);
            n0Var.B("frs_page");
            n0Var.x(3);
            n0Var.b(48);
            bVar.m(n0Var);
            l0 k = bVar.k(BaseCardInfo.SupportType.BOTTOM, viewGroup, this.m);
            k.r(3);
            ThreadCardViewHolder<ThreadData> threadCardViewHolder = new ThreadCardViewHolder<>(k);
            threadCardViewHolder.k(this.f2571e);
            threadCardViewHolder.p(true);
            threadCardViewHolder.i(4, bVar.l());
            V(new b(this));
            return threadCardViewHolder;
        }
        return (ThreadCardViewHolder) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.a.p0.f1.k, c.a.d.o.e.a
    /* renamed from: F0 */
    public View S(int i, View view, ViewGroup viewGroup, a2 a2Var, ThreadCardViewHolder threadCardViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Integer.valueOf(i), view, viewGroup, a2Var, threadCardViewHolder})) == null) {
            super.S(i, view, viewGroup, a2Var, threadCardViewHolder);
            if (a2Var == null || threadCardViewHolder == null || threadCardViewHolder.b() == null) {
                return null;
            }
            threadCardViewHolder.c().e(this.v);
            threadCardViewHolder.c().q(i);
            c.a.p0.f1.j.i(threadCardViewHolder.c().f(), this.j);
            if (a2Var.s.getType() == ThreadData.TYPE_FAKE_VIDEO) {
                threadCardViewHolder.c().f().b(128);
            } else {
                threadCardViewHolder.c().f().c(128);
            }
            FrsViewData frsViewData = this.j;
            if (frsViewData != null && frsViewData.getForum() != null && !StringUtils.isNull(this.j.getForum().getTopic_special_icon()) && !StringUtils.isNull(this.j.getForum().getTopic_special_icon_right())) {
                a2Var.s.setSpecUrl(this.j.getForum().getTopic_special_icon(), this.j.getForum().getTopic_special_icon_right());
            }
            threadCardViewHolder.r(false, Align.ALIGN_RIGHT_BOTTOM, this.z);
            if (threadCardViewHolder.c().f() instanceof n0) {
                ((n0) threadCardViewHolder.c().f()).z(new c(this, viewGroup, view, i));
            }
            threadCardViewHolder.g(a2Var.s);
            threadCardViewHolder.c().onChangeSkinType(this.k, TbadkCoreApplication.getInst().getSkinType());
            threadCardViewHolder.c().p(this.y);
            a2Var.s.updateShowStatus();
            return threadCardViewHolder.b();
        }
        return (View) invokeCommon.objValue;
    }

    public final void G0(ThreadData threadData) {
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
            this.v = str;
        }
    }

    @Override // c.a.p0.f1.o2.d
    public c.a.p0.f1.o2.b j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? c.a.p0.f1.o2.d.f0 : (c.a.p0.f1.o2.b) invokeV.objValue;
    }

    @Override // c.a.p0.h0.a0
    public void l(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, z) == null) {
            this.t = z;
        }
    }

    @Override // c.a.p0.h0.z
    public void r(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048585, this, i) == null) {
            this.w = i;
        }
    }

    @Override // c.a.p0.f1.k
    public void setFrom(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, str) == null) {
            this.u = str;
        }
    }
}
