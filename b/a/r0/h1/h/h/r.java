package b.a.r0.h1.h.h;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.InputDeviceCompat;
import b.a.l.d;
import b.a.l.i0;
import b.a.l.l0;
import b.a.q0.s.q.d2;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.card.ThreadCardViewHolder;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.NEGFeedBack.NEGFeedBackView;
import com.baidu.tieba.R;
import com.baidu.tieba.card.data.BaseCardInfo;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class r extends b.a.e.l.e.a<b.a.r0.b0.e0.k, ThreadCardViewHolder<b.a.r0.b0.e0.k>> implements b.a.r0.p.f {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public BdUniqueId m;
    public TbPageContext<?> n;
    public boolean o;
    public NEGFeedBackView.b p;
    public b.a.r0.b0.c0<b.a.r0.b0.e0.k> q;

    /* loaded from: classes4.dex */
    public class a implements d.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public a(r rVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {rVar};
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
    public class b implements b.a.e.l.e.w {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ r f17415e;

        public b(r rVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {rVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f17415e = rVar;
        }

        @Override // b.a.e.l.e.w
        public void b(View view, b.a.e.l.e.n nVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i2, long j) {
            b.a.r0.b0.e0.k kVar;
            d2 d2Var;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{view, nVar, bdUniqueId, viewGroup, Integer.valueOf(i2), Long.valueOf(j)}) == null) || !(nVar instanceof b.a.r0.b0.e0.k) || (kVar = (b.a.r0.b0.e0.k) nVar) == null || (d2Var = kVar.f14748e) == null || d2Var.e1() == null) {
                return;
            }
            this.f17415e.o0(kVar.f14748e, view);
            TiebaStatic.log(kVar.A());
            TiebaStatic.log(kVar.o());
            this.f17415e.j0(kVar.f14748e, kVar.q());
        }
    }

    /* loaded from: classes4.dex */
    public class c extends b.a.r0.b0.c0<b.a.r0.b0.e0.k> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ r f17416b;

        public c(r rVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {rVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f17416b = rVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // b.a.r0.b0.c0
        /* renamed from: d */
        public boolean c(View view, b.a.r0.b0.e0.k kVar, String str) {
            InterceptResult invokeLLL;
            d2 d2Var;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLLL = interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view, kVar, str)) == null) {
                if (kVar == null || (d2Var = kVar.f14748e) == null || d2Var.e1() == null) {
                    return false;
                }
                this.f17416b.o0(kVar.f14748e, view);
                TiebaStatic.log(kVar.A());
                TiebaStatic.log(kVar.o());
                this.f17416b.j0(kVar.f14748e, kVar.q());
                return true;
            }
            return invokeLLL.booleanValue;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public r(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, bdUniqueId};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (BdUniqueId) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.o = true;
        this.p = null;
        this.q = new c(this);
        this.n = tbPageContext;
        i0();
    }

    @Override // b.a.r0.p.f
    public void g(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
        }
    }

    public final void i0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            b.a.r0.b0.e0.k.m0 = "c13388";
            b.a.r0.b0.e0.k.n0 = "c13389";
        }
    }

    public final void j0(d2 d2Var, int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(1048580, this, d2Var, i2) == null) || d2Var == null || d2Var.e1() == null) {
            return;
        }
        b.a.r0.k3.c.g().c(this.m, b.a.r0.k3.a.j(d2Var, "a002", "common_click", 1, i2, d2Var.e1().id));
    }

    public final void k0(d2 d2Var, int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(1048581, this, d2Var, i2) == null) || d2Var == null || d2Var.e1() == null) {
            return;
        }
        String str = d2Var.e1().id;
        b.a.r0.k3.c.g().d(this.m, b.a.r0.k3.a.c(d2Var.s1(), "", str, null), b.a.r0.k3.a.k(d2Var, "a002", "common_exp", i2, str));
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // b.a.e.l.e.a
    /* renamed from: l0 */
    public ThreadCardViewHolder<b.a.r0.b0.e0.k> T(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, viewGroup)) == null) {
            l0.b bVar = new l0.b(this.n.getPageActivity());
            b.a.l.d dVar = new b.a.l.d(this.n.getPageActivity());
            dVar.s(this.m);
            dVar.q(false);
            dVar.v(false);
            dVar.b(1024);
            dVar.r(new a(this));
            bVar.o(dVar);
            b.a.l.x xVar = new b.a.l.x(this.n.getPageActivity());
            xVar.o("index");
            xVar.p(this.o);
            bVar.n(xVar);
            bVar.m(new i0(this.n.getPageActivity()));
            ThreadCardViewHolder<b.a.r0.b0.e0.k> threadCardViewHolder = new ThreadCardViewHolder<>(bVar.j(BaseCardInfo.SupportType.FULL, viewGroup));
            threadCardViewHolder.setPageId(this.m);
            c0(new b(this));
            return threadCardViewHolder;
        }
        return (ThreadCardViewHolder) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // b.a.e.l.e.a
    /* renamed from: m0 */
    public View Z(int i2, View view, ViewGroup viewGroup, b.a.r0.b0.e0.k kVar, ThreadCardViewHolder<b.a.r0.b0.e0.k> threadCardViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048583, this, new Object[]{Integer.valueOf(i2), view, viewGroup, kVar, threadCardViewHolder})) == null) {
            if (kVar == null || threadCardViewHolder == null || threadCardViewHolder.getView() == null || kVar.f14748e == null) {
                return null;
            }
            kVar.K(kVar.position + 1);
            kVar.f14748e.T1 = kVar.q();
            threadCardViewHolder.showNEGFeedBackView(false).t(this.p);
            threadCardViewHolder.onBindDataToView(kVar);
            threadCardViewHolder.getCardView().onChangeSkinType(this.n, TbadkCoreApplication.getInst().getSkinType());
            threadCardViewHolder.getCardView().o(this.q);
            b.a.r0.b0.u.b().a(kVar.B());
            b.a.r0.p.d.c().i("page_recommend", "show_", kVar.B());
            k0(kVar.f14748e, kVar.q());
            return threadCardViewHolder.getView();
        }
        return (View) invokeCommon.objValue;
    }

    public void n0(NEGFeedBackView.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, bVar) == null) {
            this.p = bVar;
        }
    }

    public final void o0(d2 d2Var, View view) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048585, this, d2Var, view) == null) || d2Var == null || d2Var.e1() == null) {
            return;
        }
        String str = d2Var.e1().id;
        String str2 = d2Var.e1().link;
        String str3 = d2Var.e1().h5_url;
        Long l = d2Var.e1().swan_app_id;
        long parseLong = Long.parseLong(d2Var.s1());
        long T = d2Var.T();
        String str4 = d2Var.e1().name;
        b.a.q0.s.e0.b.j().w("smart_app_tid", parseLong);
        b.a.q0.s.e0.b.j().x("smart_app_name", str4);
        b.a.q0.s.e0.b.j().x("smart_app_id", str);
        if (StringUtils.isNull(str)) {
            return;
        }
        if (!b.a.r0.v.a.b(str, str2, "1191008600000000", d2Var.e1().is_game)) {
            if (StringUtils.isNull(str3)) {
                return;
            }
            b.a.q0.m.a.l(view.getContext(), str3);
        }
        b.a.r0.b0.m.a(d2Var.s1());
        TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_FE_FITE_PROGRAM_CLICK).param("fid", T).param("tid", parseLong).param("uid", TbadkCoreApplication.getCurrentAccount()).param("obj_name", str4).param("obj_id", l.longValue()).param("obj_source", "index_card").param("obj_param1", d2Var.e1().is_game.intValue()));
    }
}
