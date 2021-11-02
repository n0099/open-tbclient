package b.a.r0.x0.x1.d;

import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import androidx.core.view.InputDeviceCompat;
import b.a.l.d;
import b.a.l.j0;
import b.a.l.l0;
import b.a.l.n0;
import b.a.l.u0;
import b.a.l.v0.a;
import b.a.q0.s.q.c2;
import b.a.q0.s.q.d2;
import b.a.q0.s.q.x0;
import b.a.r0.x0.b1;
import b.a.r0.x0.c1;
import b.a.r0.x0.e1;
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
import com.baidu.tieba.tbadkCore.FrsViewData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.HashSet;
/* loaded from: classes5.dex */
public class t extends b.a.r0.x0.k<c2, ThreadCardViewHolder<c2>> implements b.a.r0.b0.a0, b.a.r0.x0.u2.d, b.a.r0.p.f, b.a.r0.b0.b0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String A;
    public boolean B;
    public boolean C;
    public b.a.r0.x0.u2.b D;
    public int E;
    public b.a.r0.b0.c0<c2> F;
    public NEGFeedBackView.b G;
    public b.a.e.e.k.b<ConstrainImageLayout> H;
    public b.a.e.e.k.b<TbImageView> I;
    public TbPageContext<?> x;
    public HashSet<String> y;
    public String z;

    /* loaded from: classes5.dex */
    public class a extends b.a.r0.b0.c0<c2> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ t f26674b;

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
            this.f26674b = tVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // b.a.r0.b0.c0
        /* renamed from: d */
        public void a(View view, c2 c2Var) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view, c2Var) == null) || view == null || c2Var == null) {
                return;
            }
            if (this.f26674b.u != null) {
                this.f26674b.u.b(view, c2Var, this.f26674b.getType());
            }
            if ("c13010".equals(this.f26674b.A)) {
                TiebaStatic.log(new StatisticItem("c13010").param("obj_type", 1).param("fid", c2Var.w.T()).param("tid", c2Var.w.s1()));
            }
            if (view.getId() != e1.user_name && view.getId() != e1.user_avatar) {
                if (view.getId() == e1.thread_info_commont_container) {
                    b.a.r0.x0.u2.a.e(c2Var.w, 5, this.f26674b.f2423i, this.f26674b.D, this.f26674b.h0());
                    b.a.r0.x0.x2.l.g(c2Var.w, this.f26674b.n, 1);
                } else if (view.getId() == e1.share_num_container) {
                    b.a.r0.x0.u2.a.e(c2Var.w, 14, this.f26674b.f2423i, this.f26674b.D, this.f26674b.h0());
                } else if (view.getId() == e1.img_agree) {
                    b.a.r0.x0.u2.a.e(c2Var.w, 12, this.f26674b.f2423i, this.f26674b.D, this.f26674b.h0());
                } else if (view.getId() == e1.img_disagree) {
                    b.a.r0.x0.u2.a.e(c2Var.w, 13, this.f26674b.f2423i, this.f26674b.D, this.f26674b.h0());
                } else if (view instanceof TbImageView) {
                    if (this.f26674b.F.f14741a instanceof Boolean) {
                        if (((Boolean) this.f26674b.F.f14741a).booleanValue()) {
                            b.a.r0.x0.u2.a.e(c2Var.w, 1, this.f26674b.f2423i, this.f26674b.D, this.f26674b.h0());
                        } else {
                            b.a.r0.x0.u2.a.e(c2Var.w, 3, this.f26674b.f2423i, this.f26674b.D, this.f26674b.h0());
                        }
                    }
                    b.a.r0.x0.x2.l.g(c2Var.w, this.f26674b.n, 2);
                } else if (view instanceof ThreadGodReplyLayout) {
                    b.a.r0.x0.u2.a.e(c2Var.w, 15, this.f26674b.f2423i, this.f26674b.D, this.f26674b.h0());
                    b.a.r0.x0.x2.l.g(c2Var.w, this.f26674b.n, 1);
                } else {
                    b.a.r0.x0.u2.a.e(c2Var.w, 1, this.f26674b.f2423i, this.f26674b.D, this.f26674b.h0());
                    b.a.r0.x0.x2.l.g(c2Var.w, this.f26674b.n, 1);
                }
            } else {
                b.a.r0.x0.u2.a.e(c2Var.w, 2, this.f26674b.f2423i, this.f26674b.D, this.f26674b.h0());
            }
            if (view.getId() == e1.user_name || view.getId() == e1.user_avatar) {
                b.a.r0.x0.u2.c.j().g(this.f26674b.D, c2Var.w, 2);
            } else if (view.getId() == e1.card_divider_tv) {
                b.a.r0.x0.x2.l.a(this.f26674b.D, c2Var.getRecomReason());
            } else if (view instanceof TbImageView) {
                if (this.f26674b.F.f14741a instanceof Boolean) {
                    if (((Boolean) this.f26674b.F.f14741a).booleanValue()) {
                        b.a.r0.x0.u2.c.j().g(this.f26674b.D, c2Var.w, 1);
                    } else {
                        b.a.r0.x0.u2.c.j().g(this.f26674b.D, c2Var.w, 3);
                    }
                }
            } else if (view.getId() == e1.card_home_page_normal_thread_user_icon) {
                TiebaStatic.log(new StatisticItem(CommonStatisticKey.USER_ICON_VISIT).param("obj_type", 3));
            } else if (view.getId() == e1.thread_card_voice) {
                b.a.r0.x0.u2.c.j().g(this.f26674b.D, c2Var.w, 5);
            } else if (!(view instanceof ThreadGodReplyLayout)) {
                b.a.r0.x0.u2.c.j().g(this.f26674b.D, c2Var.w, 1);
            } else {
                int i2 = 6;
                if (c2Var.w.v1() != null && c2Var.w.v1().M() != null && c2Var.w.v1().M().y() != null && c2Var.w.v1().M().y().size() > 0) {
                    i2 = c2Var.w.v1().P ? 9 : 8;
                }
                b.a.r0.x0.u2.c.j().g(this.f26674b.D, c2Var.w, i2);
            }
        }
    }

    /* loaded from: classes5.dex */
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

    /* loaded from: classes5.dex */
    public class c implements b.a.e.e.k.c<ConstrainImageLayout> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ t f26675a;

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
            this.f26675a = tVar;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // b.a.e.e.k.c
        public /* bridge */ /* synthetic */ ConstrainImageLayout a(ConstrainImageLayout constrainImageLayout) {
            ConstrainImageLayout constrainImageLayout2 = constrainImageLayout;
            e(constrainImageLayout2);
            return constrainImageLayout2;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // b.a.e.e.k.c
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
        @Override // b.a.e.e.k.c
        /* renamed from: f */
        public void b(ConstrainImageLayout constrainImageLayout) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048581, this, constrainImageLayout) == null) {
                constrainImageLayout.removeAllViews();
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // b.a.e.e.k.c
        /* renamed from: g */
        public ConstrainImageLayout d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? new ConstrainImageLayout(this.f26675a.x.getPageActivity()) : (ConstrainImageLayout) invokeV.objValue;
        }

        public ConstrainImageLayout h(ConstrainImageLayout constrainImageLayout) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, constrainImageLayout)) == null) ? constrainImageLayout : (ConstrainImageLayout) invokeL.objValue;
        }
    }

    /* loaded from: classes5.dex */
    public class d implements b.a.e.e.k.c<TbImageView> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ t f26676a;

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
            this.f26676a = tVar;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // b.a.e.e.k.c
        public /* bridge */ /* synthetic */ TbImageView a(TbImageView tbImageView) {
            TbImageView tbImageView2 = tbImageView;
            e(tbImageView2);
            return tbImageView2;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // b.a.e.e.k.c
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
        @Override // b.a.e.e.k.c
        /* renamed from: f */
        public void b(TbImageView tbImageView) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048581, this, tbImageView) == null) {
                tbImageView.setOnClickListener(null);
                tbImageView.setForegroundColor(0);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // b.a.e.e.k.c
        /* renamed from: g */
        public TbImageView d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
                TbImageView tbImageView = new TbImageView(this.f26676a.x.getPageActivity());
                tbImageView.setDrawBorder(true);
                tbImageView.setBorderColor(SkinManager.getColor(b1.common_color_10043));
                tbImageView.setBorderWidth(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(c1.ds1));
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

    /* loaded from: classes5.dex */
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

        @Override // b.a.l.d.b
        public void a(b.a.q0.s.q.a aVar, View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLL(1048576, this, aVar, view) == null) || aVar == null) {
                return;
            }
            if (view.getId() == e1.user_name) {
                aVar.objType = 3;
            } else if (view.getId() == e1.user_avatar) {
                aVar.objType = 4;
            } else {
                aVar.objType = 1;
            }
        }
    }

    /* loaded from: classes5.dex */
    public class f implements b.a.e.l.c.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b.a.l.w f26677a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ t f26678b;

        public f(t tVar, b.a.l.w wVar) {
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
            this.f26678b = tVar;
            this.f26677a = wVar;
        }

        @Override // b.a.e.l.c.b
        public void a(int i2, int i3, int i4) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIII(1048576, this, i2, i3, i4) == null) {
                this.f26678b.f0(i2, i3, i4);
                if (this.f26678b.K(1) && this.f26678b.K(2)) {
                    this.f26677a.v(null);
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class g implements b.a.e.l.e.w {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ t f26679e;

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
            this.f26679e = tVar;
        }

        @Override // b.a.e.l.e.w
        public void b(View view, b.a.e.l.e.n nVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i2, long j) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{view, nVar, bdUniqueId, viewGroup, Integer.valueOf(i2), Long.valueOf(j)}) == null) && (nVar instanceof c2) && (view.getTag() instanceof ThreadCardViewHolder)) {
                ThreadCardViewHolder threadCardViewHolder = (ThreadCardViewHolder) view.getTag();
                c2 c2Var = (c2) nVar;
                d2 d2Var = c2Var.w;
                d2Var.objType = 1;
                if (this.f26679e.F != null) {
                    this.f26679e.F.a(threadCardViewHolder.getView(), c2Var);
                }
                ThreadCardUtils.jumpToPB((b.a.q0.s.q.a) d2Var, view.getContext(), 3, false);
                threadCardViewHolder.getCardView().n(new a.C0090a(1));
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
        this.D = new b.a.r0.x0.u2.b();
        this.F = new a(this);
        this.G = new b(this);
        this.H = new b.a.e.e.k.b<>(new c(this), 6, 0);
        this.I = new b.a.e.e.k.b<>(new d(this), 12, 0);
        this.x = tbPageContext;
        this.f2423i = bdUniqueId2;
    }

    public final void M0(d2 d2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, d2Var) == null) {
            if (this.y == null) {
                this.y = new HashSet<>();
            }
            b.a.r0.x0.u2.c.j().d(d2Var, this.y);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // b.a.e.l.e.a
    /* renamed from: N0 */
    public ThreadCardViewHolder<c2> T(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, viewGroup)) == null) {
            l0.b bVar = new l0.b(this.x.getPageActivity());
            b.a.l.d dVar = new b.a.l.d(this.x.getPageActivity());
            dVar.a(4280);
            dVar.s(this.f2423i);
            dVar.r(new e(this));
            bVar.o(dVar);
            b.a.l.w wVar = new b.a.l.w(this.x.getPageActivity());
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
            b.a.l.n nVar = new b.a.l.n(this.x.getPageActivity());
            bVar.h(nVar);
            nVar.w(this.C);
            nVar.v("frs");
            if (!K(1) || !K(2)) {
                wVar.v(new f(this, wVar));
            }
            n0 n0Var = new n0(this.x.getPageActivity());
            b.a.q0.s.q.f fVar = new b.a.q0.s.q.f();
            if (100 == h0().tabType) {
                fVar.f13300b = this.B ? 10 : 25;
                n0Var.v(19);
                n0Var.z(14);
            } else {
                fVar.f13300b = this.B ? 10 : 2;
                n0Var.v(2);
                n0Var.z(1);
            }
            fVar.f13306h = 2;
            FrsViewData frsViewData = this.n;
            if (frsViewData != null && frsViewData.getForum() != null && !b.a.e.e.p.k.isEmpty(this.n.getForum().getId())) {
                fVar.j = this.n.getForum().getId();
            }
            n0Var.u(fVar);
            n0Var.w(3);
            n0Var.a(16);
            bVar.m(n0Var);
            bVar.l().g(b.a.e.e.p.l.g(this.f2419e, c1.tbds28));
            l0 i2 = bVar.i();
            i2.q(3);
            ThreadCardViewHolder<c2> threadCardViewHolder = new ThreadCardViewHolder<>(i2);
            threadCardViewHolder.setPageId(this.f2423i);
            c0(new g(this));
            threadCardViewHolder.showMultiDelDecorItem();
            return threadCardViewHolder;
        }
        return (ThreadCardViewHolder) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // b.a.r0.x0.k, b.a.e.l.e.a
    /* renamed from: O0 */
    public View Z(int i2, View view, ViewGroup viewGroup, c2 c2Var, ThreadCardViewHolder<c2> threadCardViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Integer.valueOf(i2), view, viewGroup, c2Var, threadCardViewHolder})) == null) {
            super.Z(i2, view, viewGroup, c2Var, threadCardViewHolder);
            if (c2Var == null || threadCardViewHolder == null || threadCardViewHolder.getView() == null) {
                return null;
            }
            threadCardViewHolder.getCardView().setPage(this.z);
            b.a.r0.x0.j.i(threadCardViewHolder.getCardView().e(), this.n);
            FrsViewData frsViewData = this.n;
            if (frsViewData != null && frsViewData.getForum() != null && !StringUtils.isNull(this.n.getForum().getTopic_special_icon()) && !StringUtils.isNull(this.n.getForum().getTopic_special_icon_right())) {
                c2Var.w.w4(this.n.getForum().getTopic_special_icon(), this.n.getForum().getTopic_special_icon_right());
            }
            boolean z = (c2Var.w.J() == null || c2Var.w.J().getUserId() == null || !c2Var.w.J().getUserId().equals(TbadkCoreApplication.getCurrentAccount())) ? false : true;
            if (c2Var.w.x2() && c2Var.w.S() != null && !z) {
                threadCardViewHolder.showNEGFeedBackView(true).t(this.G);
            }
            threadCardViewHolder.showThemeAndStarDecorItem();
            if (threadCardViewHolder.getCardView().e() != null) {
                threadCardViewHolder.getCardView().e().a(32);
            }
            threadCardViewHolder.onBindDataToView(c2Var);
            threadCardViewHolder.getCardView().onChangeSkinType(this.x, TbadkCoreApplication.getInst().getSkinType());
            threadCardViewHolder.getCardView().o(this.F);
            if (this.D != null) {
                FrsViewData frsViewData2 = this.n;
                c2Var.w.T1 = (c2Var.position + 1) - (frsViewData2 != null ? frsViewData2.getTopThreadSize() : 0);
            }
            b.a.r0.x0.u2.c.j().c(this.D, c2Var.w);
            M0(c2Var.w);
            c2Var.w.O4();
            b.a.r0.x0.u2.a.m(c2Var.w, this.f2423i, this.D, h0());
            FrsViewData frsViewData3 = this.n;
            if (frsViewData3 != null && frsViewData3.getForum() != null) {
                b.a.r0.x0.u2.a.l(c2Var.w, this.n.getForum().getId());
            }
            if (c2Var != null) {
                c2Var.w.O4();
            }
            return threadCardViewHolder.getView();
        }
        return (View) invokeCommon.objValue;
    }

    @Override // b.a.r0.b0.a0
    public void a(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, str) == null) {
        }
    }

    @Override // b.a.r0.p.f
    public void g(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, str) == null) {
            this.z = str;
        }
    }

    @Override // b.a.r0.x0.u2.d
    public b.a.r0.x0.u2.b j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.D : (b.a.r0.x0.u2.b) invokeV.objValue;
    }

    @Override // b.a.r0.b0.b0
    public void l(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, z) == null) {
            this.B = z;
        }
    }

    @Override // b.a.r0.b0.a0
    public void r(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048585, this, i2) == null) {
            this.E = i2;
        }
    }

    @Override // b.a.r0.x0.k, b.a.r0.b0.z
    public void setFrom(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, str) == null) {
            this.A = str;
        }
    }

    @Override // b.a.r0.x0.k
    public void setFromCDN(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048587, this, z) == null) {
            this.C = z;
        }
    }
}
