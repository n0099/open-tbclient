package c.a.q0.v0.m1.d;

import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import androidx.core.view.InputDeviceCompat;
import c.a.l.d;
import c.a.l.j0;
import c.a.l.l0;
import c.a.l.n0;
import c.a.l.u0;
import c.a.l.v0.a;
import c.a.p0.s.q.b2;
import c.a.p0.s.q.c2;
import c.a.p0.s.q.x0;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.card.ThreadCardViewHolder;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
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
/* loaded from: classes4.dex */
public class t extends c.a.q0.v0.k<b2, ThreadCardViewHolder<b2>> implements c.a.q0.a0.z, c.a.q0.v0.j2.d, c.a.q0.o.f, c.a.q0.a0.a0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String A;
    public boolean B;
    public boolean C;
    public c.a.q0.v0.j2.b D;
    public int E;
    public c.a.q0.a0.b0<b2> F;
    public NEGFeedBackView.b G;
    public c.a.e.e.k.b<ConstrainImageLayout> H;
    public c.a.e.e.k.b<TbImageView> I;
    public TbPageContext<?> x;
    public HashSet<String> y;
    public String z;

    /* loaded from: classes4.dex */
    public class a extends c.a.q0.a0.b0<b2> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ t f26561b;

        public a(t tVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f26561b = tVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.q0.a0.b0
        /* renamed from: d */
        public void a(View view, b2 b2Var) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view, b2Var) == null) || view == null || b2Var == null) {
                return;
            }
            if (this.f26561b.u != null) {
                this.f26561b.u.b(view, b2Var, this.f26561b.K());
            }
            if ("c13010".equals(this.f26561b.A)) {
                TiebaStatic.log(new StatisticItem("c13010").param("obj_type", 1).param("fid", b2Var.w.T()).param("tid", b2Var.w.q1()));
            }
            if (view.getId() != R.id.user_name && view.getId() != R.id.user_avatar) {
                if (view.getId() == R.id.thread_info_commont_container) {
                    c.a.q0.v0.j2.a.e(b2Var.w, 5, this.f26561b.f2970i, this.f26561b.D, this.f26561b.i0());
                    c.a.q0.v0.m2.l.g(b2Var.w, this.f26561b.n, 1);
                } else if (view.getId() == R.id.share_num_container) {
                    c.a.q0.v0.j2.a.e(b2Var.w, 14, this.f26561b.f2970i, this.f26561b.D, this.f26561b.i0());
                } else if (view.getId() == R.id.img_agree) {
                    c.a.q0.v0.j2.a.e(b2Var.w, 12, this.f26561b.f2970i, this.f26561b.D, this.f26561b.i0());
                } else if (view.getId() == R.id.img_disagree) {
                    c.a.q0.v0.j2.a.e(b2Var.w, 13, this.f26561b.f2970i, this.f26561b.D, this.f26561b.i0());
                } else if (view instanceof TbImageView) {
                    if (this.f26561b.F.f15237a instanceof Boolean) {
                        if (((Boolean) this.f26561b.F.f15237a).booleanValue()) {
                            c.a.q0.v0.j2.a.e(b2Var.w, 1, this.f26561b.f2970i, this.f26561b.D, this.f26561b.i0());
                        } else {
                            c.a.q0.v0.j2.a.e(b2Var.w, 3, this.f26561b.f2970i, this.f26561b.D, this.f26561b.i0());
                        }
                    }
                    c.a.q0.v0.m2.l.g(b2Var.w, this.f26561b.n, 2);
                } else if (view instanceof ThreadGodReplyLayout) {
                    c.a.q0.v0.j2.a.e(b2Var.w, 15, this.f26561b.f2970i, this.f26561b.D, this.f26561b.i0());
                    c.a.q0.v0.m2.l.g(b2Var.w, this.f26561b.n, 1);
                } else {
                    c.a.q0.v0.j2.a.e(b2Var.w, 1, this.f26561b.f2970i, this.f26561b.D, this.f26561b.i0());
                    c.a.q0.v0.m2.l.g(b2Var.w, this.f26561b.n, 1);
                }
            } else {
                c.a.q0.v0.j2.a.e(b2Var.w, 2, this.f26561b.f2970i, this.f26561b.D, this.f26561b.i0());
            }
            if (view.getId() == R.id.user_name || view.getId() == R.id.user_avatar) {
                c.a.q0.v0.j2.c.j().g(this.f26561b.D, b2Var.w, 2);
            } else if (view.getId() == R.id.card_divider_tv) {
                c.a.q0.v0.m2.l.a(this.f26561b.D, b2Var.getRecomReason());
            } else if (view instanceof TbImageView) {
                if (this.f26561b.F.f15237a instanceof Boolean) {
                    if (((Boolean) this.f26561b.F.f15237a).booleanValue()) {
                        c.a.q0.v0.j2.c.j().g(this.f26561b.D, b2Var.w, 1);
                    } else {
                        c.a.q0.v0.j2.c.j().g(this.f26561b.D, b2Var.w, 3);
                    }
                }
            } else if (view.getId() == R.id.card_home_page_normal_thread_user_icon) {
                TiebaStatic.log(new StatisticItem(CommonStatisticKey.USER_ICON_VISIT).param("obj_type", 3));
            } else if (view.getId() == R.id.thread_card_voice) {
                c.a.q0.v0.j2.c.j().g(this.f26561b.D, b2Var.w, 5);
            } else if (!(view instanceof ThreadGodReplyLayout)) {
                c.a.q0.v0.j2.c.j().g(this.f26561b.D, b2Var.w, 1);
            } else {
                int i2 = 6;
                if (b2Var.w.t1() != null && b2Var.w.t1().K() != null && b2Var.w.t1().K().y() != null && b2Var.w.t1().K().y().size() > 0) {
                    i2 = b2Var.w.t1().N ? 9 : 8;
                }
                c.a.q0.v0.j2.c.j().g(this.f26561b.D, b2Var.w, i2);
            }
        }
    }

    /* loaded from: classes4.dex */
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
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.baidu.tieba.NEGFeedBack.NEGFeedBackView.b
        public void onCheckedChanged(x0 x0Var, CompoundButton compoundButton, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLZ(1048576, this, x0Var, compoundButton, z) == null) {
            }
        }

        @Override // com.baidu.tieba.NEGFeedBack.NEGFeedBackView.b
        public void onNEGFeedbackConfirm(ArrayList<Integer> arrayList, String str, x0 x0Var) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, arrayList, str, x0Var) == null) || arrayList == null || x0Var == null) {
                return;
            }
            StringBuilder sb = new StringBuilder();
            for (int i2 = 0; i2 < arrayList.size(); i2++) {
                sb.append(arrayList.get(i2) + ",");
            }
            if (sb.length() > 0) {
                sb.deleteCharAt(sb.length() - 1);
            }
            TiebaStatic.log(new StatisticItem("c11974").param("obj_locate", sb.toString()).param("fid", x0Var.c()).param("tid", x0Var.f()).param("nid", x0Var.e()).param("uid", TbadkCoreApplication.getCurrentAccount()).param("source", x0Var.l).param("weight", x0Var.k).param("ab_tag", x0Var.p).param("extra", x0Var.m).param("card_type", x0Var.o).param(TiebaStatic.Params.OBJ_FLOOR, x0Var.q));
        }

        @Override // com.baidu.tieba.NEGFeedBack.NEGFeedBackView.b
        public void onNEGFeedbackWindowShow(x0 x0Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, x0Var) == null) {
                TiebaStatic.log(new StatisticItem("c11973").param("fid", x0Var.c()).param("tid", x0Var.f()).param("uid", TbadkCoreApplication.getCurrentAccount()));
            }
        }
    }

    /* loaded from: classes4.dex */
    public class c implements c.a.e.e.k.c<ConstrainImageLayout> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ t f26562a;

        public c(t tVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f26562a = tVar;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // c.a.e.e.k.c
        public /* bridge */ /* synthetic */ ConstrainImageLayout a(ConstrainImageLayout constrainImageLayout) {
            ConstrainImageLayout constrainImageLayout2 = constrainImageLayout;
            e(constrainImageLayout2);
            return constrainImageLayout2;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // c.a.e.e.k.c
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
        @Override // c.a.e.e.k.c
        /* renamed from: f */
        public void b(ConstrainImageLayout constrainImageLayout) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048581, this, constrainImageLayout) == null) {
                constrainImageLayout.removeAllViews();
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.e.e.k.c
        /* renamed from: g */
        public ConstrainImageLayout d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? new ConstrainImageLayout(this.f26562a.x.getPageActivity()) : (ConstrainImageLayout) invokeV.objValue;
        }

        public ConstrainImageLayout h(ConstrainImageLayout constrainImageLayout) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, constrainImageLayout)) == null) ? constrainImageLayout : (ConstrainImageLayout) invokeL.objValue;
        }
    }

    /* loaded from: classes4.dex */
    public class d implements c.a.e.e.k.c<TbImageView> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ t f26563a;

        public d(t tVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f26563a = tVar;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // c.a.e.e.k.c
        public /* bridge */ /* synthetic */ TbImageView a(TbImageView tbImageView) {
            TbImageView tbImageView2 = tbImageView;
            e(tbImageView2);
            return tbImageView2;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // c.a.e.e.k.c
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
        @Override // c.a.e.e.k.c
        /* renamed from: f */
        public void b(TbImageView tbImageView) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048581, this, tbImageView) == null) {
                tbImageView.setOnClickListener(null);
                tbImageView.setForegroundColor(0);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.e.e.k.c
        /* renamed from: g */
        public TbImageView d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
                TbImageView tbImageView = new TbImageView(this.f26563a.x.getPageActivity());
                tbImageView.setDrawBorder(true);
                tbImageView.setBorderColor(SkinManager.getColor(R.color.common_color_10043));
                tbImageView.setBorderWidth(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.ds1));
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

    /* loaded from: classes4.dex */
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
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // c.a.l.d.b
        public void a(c.a.p0.s.q.a aVar, View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLL(1048576, this, aVar, view) == null) || aVar == null) {
                return;
            }
            if (view.getId() == R.id.user_name) {
                aVar.objType = 3;
            } else if (view.getId() == R.id.user_avatar) {
                aVar.objType = 4;
            } else {
                aVar.objType = 1;
            }
        }
    }

    /* loaded from: classes4.dex */
    public class f implements c.a.e.l.c.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ c.a.l.w f26564a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ t f26565b;

        public f(t tVar, c.a.l.w wVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tVar, wVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f26565b = tVar;
            this.f26564a = wVar;
        }

        @Override // c.a.e.l.c.b
        public void a(int i2, int i3, int i4) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIII(1048576, this, i2, i3, i4) == null) {
                this.f26565b.g0(i2, i3, i4);
                if (this.f26565b.N(1) && this.f26565b.N(2)) {
                    this.f26564a.v(null);
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class g implements c.a.e.l.e.w {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ t f26566e;

        public g(t tVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f26566e = tVar;
        }

        @Override // c.a.e.l.e.w
        public void b(View view, c.a.e.l.e.n nVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i2, long j2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{view, nVar, bdUniqueId, viewGroup, Integer.valueOf(i2), Long.valueOf(j2)}) == null) && (nVar instanceof b2) && (view.getTag() instanceof ThreadCardViewHolder)) {
                ThreadCardViewHolder threadCardViewHolder = (ThreadCardViewHolder) view.getTag();
                b2 b2Var = (b2) nVar;
                c2 c2Var = b2Var.w;
                c2Var.objType = 1;
                if (this.f26566e.F != null) {
                    this.f26566e.F.a(threadCardViewHolder.getView(), b2Var);
                }
                ThreadCardUtils.jumpToPB((c.a.p0.s.q.a) c2Var, view.getContext(), 3, false);
                threadCardViewHolder.getCardView().o(new a.C0096a(1));
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
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((TbPageContext) objArr2[0], (BdUniqueId) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.B = false;
        this.C = true;
        this.D = new c.a.q0.v0.j2.b();
        this.F = new a(this);
        this.G = new b(this);
        this.H = new c.a.e.e.k.b<>(new c(this), 6, 0);
        this.I = new c.a.e.e.k.b<>(new d(this), 12, 0);
        this.x = tbPageContext;
        this.f2970i = bdUniqueId2;
    }

    public final void N0(c2 c2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, c2Var) == null) {
            if (this.y == null) {
                this.y = new HashSet<>();
            }
            c.a.q0.v0.j2.c.j().d(c2Var, this.y);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.a.e.l.e.a
    /* renamed from: O0 */
    public ThreadCardViewHolder<b2> U(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, viewGroup)) == null) {
            l0.b bVar = new l0.b(this.x.getPageActivity());
            c.a.l.d dVar = new c.a.l.d(this.x.getPageActivity());
            dVar.a(4280);
            dVar.s(this.f2970i);
            dVar.r(new e(this));
            bVar.o(dVar);
            c.a.l.w wVar = new c.a.l.w(this.x.getPageActivity());
            wVar.s("frs");
            if (this.E == 502) {
                wVar.u(false);
            } else {
                wVar.u(true);
            }
            wVar.r(this.H);
            wVar.q(this.I);
            wVar.t(this.C);
            bVar.n(wVar);
            u0 u0Var = new u0(this.x.getPageActivity());
            u0Var.w(this.x);
            u0Var.v(3);
            bVar.h(u0Var);
            bVar.h(new j0(this.x.getPageActivity()));
            c.a.l.n nVar = new c.a.l.n(this.x.getPageActivity());
            bVar.h(nVar);
            nVar.w(this.C);
            nVar.v("frs");
            if (!N(1) || !N(2)) {
                wVar.v(new f(this, wVar));
            }
            n0 n0Var = new n0(this.x.getPageActivity());
            c.a.p0.s.q.f fVar = new c.a.p0.s.q.f();
            fVar.f14219b = this.B ? 10 : 2;
            fVar.f14225h = 2;
            FrsViewData frsViewData = this.n;
            if (frsViewData != null && frsViewData.getForum() != null && !c.a.e.e.p.k.isEmpty(this.n.getForum().getId())) {
                fVar.f14227j = this.n.getForum().getId();
            }
            n0Var.u(fVar);
            n0Var.v(2);
            n0Var.z(1);
            n0Var.w(3);
            n0Var.a(16);
            bVar.m(n0Var);
            bVar.l().g(c.a.e.e.p.l.g(this.f2966e, R.dimen.tbds28));
            l0 i2 = bVar.i();
            i2.r(3);
            ThreadCardViewHolder<b2> threadCardViewHolder = new ThreadCardViewHolder<>(i2);
            threadCardViewHolder.setPageId(this.f2970i);
            d0(new g(this));
            threadCardViewHolder.showMultiDelDecorItem();
            return threadCardViewHolder;
        }
        return (ThreadCardViewHolder) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.a.q0.v0.k, c.a.e.l.e.a
    /* renamed from: P0 */
    public View a0(int i2, View view, ViewGroup viewGroup, b2 b2Var, ThreadCardViewHolder<b2> threadCardViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Integer.valueOf(i2), view, viewGroup, b2Var, threadCardViewHolder})) == null) {
            super.a0(i2, view, viewGroup, b2Var, threadCardViewHolder);
            if (b2Var == null || threadCardViewHolder == null || threadCardViewHolder.getView() == null) {
                return null;
            }
            threadCardViewHolder.getCardView().setPage(this.z);
            c.a.q0.v0.j.i(threadCardViewHolder.getCardView().e(), this.n);
            FrsViewData frsViewData = this.n;
            if (frsViewData != null && frsViewData.getForum() != null && !StringUtils.isNull(this.n.getForum().getTopic_special_icon()) && !StringUtils.isNull(this.n.getForum().getTopic_special_icon_right())) {
                b2Var.w.m4(this.n.getForum().getTopic_special_icon(), this.n.getForum().getTopic_special_icon_right());
            }
            boolean z = (b2Var.w.J() == null || b2Var.w.J().getUserId() == null || !b2Var.w.J().getUserId().equals(TbadkCoreApplication.getCurrentAccount())) ? false : true;
            if (b2Var.w.t2() && b2Var.w.S() != null && !z) {
                threadCardViewHolder.showNEGFeedBackView(true).t(this.G);
            }
            threadCardViewHolder.showThemeAndStarDecorItem();
            if (threadCardViewHolder.getCardView().e() != null) {
                threadCardViewHolder.getCardView().e().a(32);
            }
            threadCardViewHolder.onBindDataToView(b2Var);
            threadCardViewHolder.getCardView().onChangeSkinType(this.x, TbadkCoreApplication.getInst().getSkinType());
            threadCardViewHolder.getCardView().p(this.F);
            if (this.D != null) {
                FrsViewData frsViewData2 = this.n;
                b2Var.w.Q1 = (b2Var.position + 1) - (frsViewData2 != null ? frsViewData2.getTopThreadSize() : 0);
            }
            c.a.q0.v0.j2.c.j().c(this.D, b2Var.w);
            N0(b2Var.w);
            b2Var.w.C4();
            c.a.q0.v0.j2.a.m(b2Var.w, this.f2970i, this.D, i0());
            FrsViewData frsViewData3 = this.n;
            if (frsViewData3 != null && frsViewData3.getForum() != null) {
                c.a.q0.v0.j2.a.l(b2Var.w, this.n.getForum().getId());
            }
            if (b2Var != null) {
                b2Var.w.C4();
            }
            return threadCardViewHolder.getView();
        }
        return (View) invokeCommon.objValue;
    }

    @Override // c.a.q0.a0.z
    public void a(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, str) == null) {
        }
    }

    @Override // c.a.q0.o.f
    public void g(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, str) == null) {
            this.z = str;
        }
    }

    @Override // c.a.q0.v0.j2.d
    public c.a.q0.v0.j2.b j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.D : (c.a.q0.v0.j2.b) invokeV.objValue;
    }

    @Override // c.a.q0.a0.a0
    public void l(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, z) == null) {
            this.B = z;
        }
    }

    @Override // c.a.q0.a0.z
    public void r(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048585, this, i2) == null) {
            this.E = i2;
        }
    }

    @Override // c.a.q0.v0.k, c.a.q0.a0.y
    public void setFrom(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, str) == null) {
            this.A = str;
        }
    }

    @Override // c.a.q0.v0.k
    public void setFromCDN(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048587, this, z) == null) {
            this.C = z;
        }
    }
}
