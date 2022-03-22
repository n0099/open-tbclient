package c.a.p0.f1.p1.d;

import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import androidx.core.view.InputDeviceCompat;
import c.a.l.d;
import c.a.l.j0;
import c.a.l.l0;
import c.a.l.n0;
import c.a.l.w0.a;
import c.a.o0.r.r.a2;
import c.a.o0.r.r.v0;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.card.ThreadCardViewHolder;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tbadk.core.util.CommonStatisticKey;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.ThreadCardUtils;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.view.ThreadGodReplyLayout;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.layout.ConstrainImageLayout;
import com.baidu.tieba.NEGFeedBack.NEGFeedBackView;
import com.baidu.tieba.R;
import com.baidu.tieba.tbadkCore.FrsViewData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.HashSet;
/* loaded from: classes2.dex */
public class t extends c.a.p0.f1.k<a2, ThreadCardViewHolder<a2>> implements c.a.p0.h0.z, c.a.p0.f1.o2.d, c.a.p0.v.f, c.a.p0.h0.a0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int A;
    public c.a.p0.h0.b0<a2> B;
    public NEGFeedBackView.b C;
    public c.a.d.f.k.b<ConstrainImageLayout> D;
    public c.a.d.f.k.b<TbImageView> E;
    public TbPageContext<?> t;
    public HashSet<String> u;
    public String v;
    public String w;
    public boolean x;
    public boolean y;
    public c.a.p0.f1.o2.b z;

    /* loaded from: classes2.dex */
    public class a extends c.a.p0.h0.b0<a2> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ t f14354b;

        public a(t tVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f14354b = tVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.p0.h0.b0
        /* renamed from: d */
        public void a(View view, a2 a2Var) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view, a2Var) == null) || view == null || a2Var == null) {
                return;
            }
            if (this.f14354b.q != null) {
                this.f14354b.q.b(view, a2Var, this.f14354b.getType());
            }
            if ("c13010".equals(this.f14354b.w)) {
                TiebaStatic.log(new StatisticItem("c13010").param("obj_type", 1).param("fid", a2Var.s.getFid()).param("tid", a2Var.s.getTid()));
            }
            if (view.getId() != R.id.obfuscated_res_0x7f0922bb && view.getId() != R.id.obfuscated_res_0x7f092296) {
                if (view.getId() == R.id.obfuscated_res_0x7f091fac) {
                    c.a.p0.f1.o2.a.e(a2Var.s, 5, this.f14354b.f2571e, this.f14354b.z, this.f14354b.a0());
                    c.a.p0.f1.r2.q.g(a2Var.s, this.f14354b.j, 1);
                } else if (view.getId() == R.id.obfuscated_res_0x7f091ccb) {
                    c.a.p0.f1.o2.a.e(a2Var.s, 14, this.f14354b.f2571e, this.f14354b.z, this.f14354b.a0());
                } else if (view.getId() == R.id.obfuscated_res_0x7f090e9b) {
                    c.a.p0.f1.o2.a.e(a2Var.s, 12, this.f14354b.f2571e, this.f14354b.z, this.f14354b.a0());
                } else if (view.getId() == R.id.obfuscated_res_0x7f090eb1) {
                    c.a.p0.f1.o2.a.e(a2Var.s, 13, this.f14354b.f2571e, this.f14354b.z, this.f14354b.a0());
                } else if (view instanceof TbImageView) {
                    if (this.f14354b.B.a instanceof Boolean) {
                        if (((Boolean) this.f14354b.B.a).booleanValue()) {
                            c.a.p0.f1.o2.a.e(a2Var.s, 1, this.f14354b.f2571e, this.f14354b.z, this.f14354b.a0());
                        } else {
                            c.a.p0.f1.o2.a.e(a2Var.s, 3, this.f14354b.f2571e, this.f14354b.z, this.f14354b.a0());
                        }
                    }
                    c.a.p0.f1.r2.q.g(a2Var.s, this.f14354b.j, 2);
                } else if (view instanceof ThreadGodReplyLayout) {
                    c.a.p0.f1.o2.a.e(a2Var.s, 15, this.f14354b.f2571e, this.f14354b.z, this.f14354b.a0());
                    c.a.p0.f1.r2.q.g(a2Var.s, this.f14354b.j, 1);
                } else {
                    c.a.p0.f1.o2.a.e(a2Var.s, 1, this.f14354b.f2571e, this.f14354b.z, this.f14354b.a0());
                    c.a.p0.f1.r2.q.g(a2Var.s, this.f14354b.j, 1);
                }
            } else {
                c.a.p0.f1.o2.a.e(a2Var.s, 2, this.f14354b.f2571e, this.f14354b.z, this.f14354b.a0());
            }
            if (view.getId() == R.id.obfuscated_res_0x7f0922bb || view.getId() == R.id.obfuscated_res_0x7f092296) {
                c.a.p0.f1.o2.c.k().h(this.f14354b.z, a2Var.s, 2);
            } else if (view.getId() == R.id.obfuscated_res_0x7f0904f7) {
                c.a.p0.f1.r2.q.a(this.f14354b.z, a2Var.getRecomReason());
            } else if (view instanceof TbImageView) {
                if (this.f14354b.B.a instanceof Boolean) {
                    if (((Boolean) this.f14354b.B.a).booleanValue()) {
                        c.a.p0.f1.o2.c.k().h(this.f14354b.z, a2Var.s, 1);
                    } else {
                        c.a.p0.f1.o2.c.k().h(this.f14354b.z, a2Var.s, 3);
                    }
                }
            } else if (view.getId() == R.id.obfuscated_res_0x7f090540) {
                TiebaStatic.log(new StatisticItem(CommonStatisticKey.USER_ICON_VISIT).param("obj_type", 3));
            } else if (view.getId() == R.id.obfuscated_res_0x7f091f9c) {
                c.a.p0.f1.o2.c.k().h(this.f14354b.z, a2Var.s, 5);
            } else if (!(view instanceof ThreadGodReplyLayout)) {
                c.a.p0.f1.o2.c.k().h(this.f14354b.z, a2Var.s, 1);
            } else {
                int i = 6;
                if (a2Var.s.getTopAgreePost() != null && a2Var.s.getTopAgreePost().N() != null && a2Var.s.getTopAgreePost().N().A() != null && a2Var.s.getTopAgreePost().N().A().size() > 0) {
                    i = a2Var.s.getTopAgreePost().L ? 9 : 8;
                }
                c.a.p0.f1.o2.c.k().h(this.f14354b.z, a2Var.s, i);
            }
        }
    }

    /* loaded from: classes2.dex */
    public class b implements NEGFeedBackView.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public b(t tVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tVar};
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

    /* loaded from: classes2.dex */
    public class c implements c.a.d.f.k.c<ConstrainImageLayout> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ t a;

        public c(t tVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = tVar;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // c.a.d.f.k.c
        public /* bridge */ /* synthetic */ ConstrainImageLayout a(ConstrainImageLayout constrainImageLayout) {
            ConstrainImageLayout constrainImageLayout2 = constrainImageLayout;
            e(constrainImageLayout2);
            return constrainImageLayout2;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // c.a.d.f.k.c
        public /* bridge */ /* synthetic */ ConstrainImageLayout c(ConstrainImageLayout constrainImageLayout) {
            ConstrainImageLayout constrainImageLayout2 = constrainImageLayout;
            h(constrainImageLayout2);
            return constrainImageLayout2;
        }

        public ConstrainImageLayout e(ConstrainImageLayout constrainImageLayout) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, constrainImageLayout)) == null) ? constrainImageLayout : (ConstrainImageLayout) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.d.f.k.c
        /* renamed from: f */
        public void b(ConstrainImageLayout constrainImageLayout) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048581, this, constrainImageLayout) == null) {
                constrainImageLayout.removeAllViews();
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.d.f.k.c
        /* renamed from: g */
        public ConstrainImageLayout d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? new ConstrainImageLayout(this.a.t.getPageActivity()) : (ConstrainImageLayout) invokeV.objValue;
        }

        public ConstrainImageLayout h(ConstrainImageLayout constrainImageLayout) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, constrainImageLayout)) == null) ? constrainImageLayout : (ConstrainImageLayout) invokeL.objValue;
        }
    }

    /* loaded from: classes2.dex */
    public class d implements c.a.d.f.k.c<TbImageView> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ t a;

        public d(t tVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = tVar;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // c.a.d.f.k.c
        public /* bridge */ /* synthetic */ TbImageView a(TbImageView tbImageView) {
            TbImageView tbImageView2 = tbImageView;
            e(tbImageView2);
            return tbImageView2;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // c.a.d.f.k.c
        public /* bridge */ /* synthetic */ TbImageView c(TbImageView tbImageView) {
            TbImageView tbImageView2 = tbImageView;
            h(tbImageView2);
            return tbImageView2;
        }

        public TbImageView e(TbImageView tbImageView) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, tbImageView)) == null) ? tbImageView : (TbImageView) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.d.f.k.c
        /* renamed from: f */
        public void b(TbImageView tbImageView) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048581, this, tbImageView) == null) {
                tbImageView.setOnClickListener(null);
                tbImageView.setForegroundColor(0);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.d.f.k.c
        /* renamed from: g */
        public TbImageView d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
                TbImageView tbImageView = new TbImageView(this.a.t.getPageActivity());
                tbImageView.setDrawBorder(true);
                tbImageView.setBorderColor(SkinManager.getColor(R.color.common_color_10043));
                tbImageView.setBorderWidth(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f070198));
                return tbImageView;
            }
            return (TbImageView) invokeV.objValue;
        }

        public TbImageView h(TbImageView tbImageView) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, tbImageView)) == null) {
                tbImageView.setOnClickListener(null);
                tbImageView.setForegroundColor(0);
                return tbImageView;
            }
            return (TbImageView) invokeL.objValue;
        }
    }

    /* loaded from: classes2.dex */
    public class e implements d.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public e(t tVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // c.a.l.d.b
        public void a(c.a.o0.r.r.a aVar, View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLL(1048576, this, aVar, view) == null) || aVar == null) {
                return;
            }
            if (view.getId() == R.id.obfuscated_res_0x7f0922bb) {
                aVar.objType = 3;
            } else if (view.getId() == R.id.obfuscated_res_0x7f092296) {
                aVar.objType = 4;
            } else {
                aVar.objType = 1;
            }
        }
    }

    /* loaded from: classes2.dex */
    public class f implements c.a.d.o.c.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ c.a.l.w a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ t f14355b;

        public f(t tVar, c.a.l.w wVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tVar, wVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f14355b = tVar;
            this.a = wVar;
        }

        @Override // c.a.d.o.c.b
        public void a(int i, int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIII(1048576, this, i, i2, i3) == null) {
                this.f14355b.Y(i, i2, i3);
                if (this.f14355b.F(1) && this.f14355b.F(2)) {
                    this.a.w(null);
                }
            }
        }
    }

    /* loaded from: classes2.dex */
    public class g implements c.a.d.o.e.w {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ t a;

        public g(t tVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = tVar;
        }

        @Override // c.a.d.o.e.w
        public void b(View view, c.a.d.o.e.n nVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i, long j) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{view, nVar, bdUniqueId, viewGroup, Integer.valueOf(i), Long.valueOf(j)}) == null) && (nVar instanceof a2) && (view.getTag() instanceof ThreadCardViewHolder)) {
                ThreadCardViewHolder threadCardViewHolder = (ThreadCardViewHolder) view.getTag();
                a2 a2Var = (a2) nVar;
                ThreadData threadData = a2Var.s;
                threadData.objType = 1;
                if (this.a.B != null) {
                    this.a.B.a(threadCardViewHolder.b(), a2Var);
                }
                ThreadCardUtils.jumpToPB((c.a.o0.r.r.a) threadData, view.getContext(), 3, false);
                threadCardViewHolder.c().o(new a.C0196a(1));
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public t(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2) {
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
        this.x = false;
        this.y = true;
        this.z = new c.a.p0.f1.o2.b();
        this.B = new a(this);
        this.C = new b(this);
        this.D = new c.a.d.f.k.b<>(new c(this), 6, 0);
        this.E = new c.a.d.f.k.b<>(new d(this), 12, 0);
        this.t = tbPageContext;
        this.f2571e = bdUniqueId2;
    }

    public final void E0(ThreadData threadData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, threadData) == null) {
            if (this.u == null) {
                this.u = new HashSet<>();
            }
            c.a.p0.f1.o2.c.k().d(threadData, this.u);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.a.d.o.e.a
    /* renamed from: F0 */
    public ThreadCardViewHolder<a2> M(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, viewGroup)) == null) {
            l0.b bVar = new l0.b(this.t.getPageActivity());
            c.a.l.d dVar = new c.a.l.d(this.t.getPageActivity());
            dVar.b(4280);
            dVar.t(this.f2571e);
            dVar.s(new e(this));
            bVar.o(dVar);
            c.a.l.w wVar = new c.a.l.w(this.t.getPageActivity());
            wVar.t("frs");
            if (this.A == 502) {
                wVar.v(false);
            } else {
                wVar.v(true);
            }
            wVar.s(this.D);
            wVar.r(this.E);
            wVar.u(this.y);
            bVar.n(wVar);
            c.a.l.v0 v0Var = new c.a.l.v0(this.t.getPageActivity());
            v0Var.x(this.t);
            v0Var.w(3);
            bVar.h(v0Var);
            bVar.h(new j0(this.t.getPageActivity()));
            c.a.l.n nVar = new c.a.l.n(this.t.getPageActivity());
            bVar.h(nVar);
            nVar.x(this.y);
            nVar.w("frs");
            if (!F(1) || !F(2)) {
                wVar.w(new f(this, wVar));
            }
            n0 n0Var = new n0(this.t.getPageActivity());
            c.a.o0.r.r.f fVar = new c.a.o0.r.r.f();
            if (100 == a0().tabType) {
                fVar.f10852b = this.x ? 10 : 25;
                n0Var.w(19);
                n0Var.A(14);
            } else {
                fVar.f10852b = this.x ? 10 : 2;
                n0Var.w(2);
                n0Var.A(1);
            }
            fVar.f10858h = 2;
            FrsViewData frsViewData = this.j;
            if (frsViewData != null && frsViewData.getForum() != null && !c.a.d.f.p.m.isEmpty(this.j.getForum().getId())) {
                fVar.j = this.j.getForum().getId();
            }
            n0Var.v(fVar);
            n0Var.x(3);
            n0Var.b(16);
            bVar.m(n0Var);
            bVar.l().h(c.a.d.f.p.n.f(this.a, R.dimen.tbds28));
            l0 i = bVar.i();
            i.r(3);
            ThreadCardViewHolder<a2> threadCardViewHolder = new ThreadCardViewHolder<>(i);
            threadCardViewHolder.k(this.f2571e);
            V(new g(this));
            threadCardViewHolder.o();
            return threadCardViewHolder;
        }
        return (ThreadCardViewHolder) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.a.p0.f1.k, c.a.d.o.e.a
    /* renamed from: G0 */
    public View S(int i, View view, ViewGroup viewGroup, a2 a2Var, ThreadCardViewHolder<a2> threadCardViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Integer.valueOf(i), view, viewGroup, a2Var, threadCardViewHolder})) == null) {
            super.S(i, view, viewGroup, a2Var, threadCardViewHolder);
            if (a2Var == null || threadCardViewHolder == null || threadCardViewHolder.b() == null) {
                return null;
            }
            threadCardViewHolder.c().e(this.v);
            c.a.p0.f1.j.i(threadCardViewHolder.c().f(), this.j);
            FrsViewData frsViewData = this.j;
            if (frsViewData != null && frsViewData.getForum() != null && !StringUtils.isNull(this.j.getForum().getTopic_special_icon()) && !StringUtils.isNull(this.j.getForum().getTopic_special_icon_right())) {
                a2Var.s.setSpecUrl(this.j.getForum().getTopic_special_icon(), this.j.getForum().getTopic_special_icon_right());
            }
            boolean z = (a2Var.s.getAuthor() == null || a2Var.s.getAuthor().getUserId() == null || !a2Var.s.getAuthor().getUserId().equals(TbadkCoreApplication.getCurrentAccount())) ? false : true;
            if (a2Var.s.isSmartFrsThread() && a2Var.s.getFeedBackReasonMap() != null && !z) {
                threadCardViewHolder.q(true).u(this.C);
            }
            threadCardViewHolder.t();
            if (threadCardViewHolder.c().f() != null) {
                threadCardViewHolder.c().f().b(32);
            }
            threadCardViewHolder.g(a2Var);
            threadCardViewHolder.c().onChangeSkinType(this.t, TbadkCoreApplication.getInst().getSkinType());
            threadCardViewHolder.c().p(this.B);
            if (this.z != null) {
                FrsViewData frsViewData2 = this.j;
                a2Var.s.statFloor = (a2Var.position + 1) - (frsViewData2 != null ? frsViewData2.getTopThreadSize() : 0);
            }
            c.a.p0.f1.o2.c.k().c(this.z, a2Var.s);
            E0(a2Var.s);
            a2Var.s.updateShowStatus();
            c.a.p0.f1.o2.a.n(a2Var.s, this.f2571e, this.z, a0());
            FrsViewData frsViewData3 = this.j;
            if (frsViewData3 != null && frsViewData3.getForum() != null) {
                c.a.p0.f1.o2.a.l(a2Var.s, a0());
                c.a.p0.f1.o2.a.m(a2Var.s, this.j.getForum().getId());
            }
            if (a2Var != null) {
                a2Var.s.updateShowStatus();
            }
            return threadCardViewHolder.b();
        }
        return (View) invokeCommon.objValue;
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
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.z : (c.a.p0.f1.o2.b) invokeV.objValue;
    }

    @Override // c.a.p0.h0.a0
    public void l(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, z) == null) {
            this.x = z;
        }
    }

    @Override // c.a.p0.h0.z
    public void r(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048585, this, i) == null) {
            this.A = i;
        }
    }

    @Override // c.a.p0.f1.k
    public void setFrom(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, str) == null) {
            this.w = str;
        }
    }

    @Override // c.a.p0.f1.k
    public void setFromCDN(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048587, this, z) == null) {
            this.y = z;
        }
    }
}
