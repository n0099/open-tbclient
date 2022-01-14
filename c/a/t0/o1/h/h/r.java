package c.a.t0.o1.h.h;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.InputDeviceCompat;
import c.a.l.d;
import c.a.l.i0;
import c.a.l.l0;
import c.a.s0.s.q.e2;
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
/* loaded from: classes8.dex */
public class r extends c.a.d.n.e.a<c.a.t0.g0.f0.k, ThreadCardViewHolder<c.a.t0.g0.f0.k>> implements c.a.t0.t.f {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public BdUniqueId m;
    public TbPageContext<?> n;
    public boolean o;
    public NEGFeedBackView.b p;
    public c.a.t0.g0.d0<c.a.t0.g0.f0.k> q;

    /* loaded from: classes8.dex */
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

        @Override // c.a.l.d.b
        public void a(c.a.s0.s.q.a aVar, View view) {
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

    /* loaded from: classes8.dex */
    public class b implements c.a.d.n.e.w {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ r f20510e;

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
            this.f20510e = rVar;
        }

        @Override // c.a.d.n.e.w
        public void b(View view, c.a.d.n.e.n nVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i2, long j2) {
            c.a.t0.g0.f0.k kVar;
            e2 e2Var;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{view, nVar, bdUniqueId, viewGroup, Integer.valueOf(i2), Long.valueOf(j2)}) == null) || !(nVar instanceof c.a.t0.g0.f0.k) || (kVar = (c.a.t0.g0.f0.k) nVar) == null || (e2Var = kVar.f17778e) == null || e2Var.g1() == null) {
                return;
            }
            this.f20510e.h0(kVar.f17778e, view);
            TiebaStatic.log(kVar.A());
            TiebaStatic.log(kVar.o());
            this.f20510e.c0(kVar.f17778e, kVar.q());
        }
    }

    /* loaded from: classes8.dex */
    public class c extends c.a.t0.g0.d0<c.a.t0.g0.f0.k> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ r f20511b;

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
            this.f20511b = rVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.t0.g0.d0
        /* renamed from: d */
        public boolean c(View view, c.a.t0.g0.f0.k kVar, String str) {
            InterceptResult invokeLLL;
            e2 e2Var;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLLL = interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view, kVar, str)) == null) {
                if (kVar == null || (e2Var = kVar.f17778e) == null || e2Var.g1() == null) {
                    return false;
                }
                this.f20511b.h0(kVar.f17778e, view);
                TiebaStatic.log(kVar.A());
                TiebaStatic.log(kVar.o());
                this.f20511b.c0(kVar.f17778e, kVar.q());
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
        b0();
    }

    public final void b0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            c.a.t0.g0.f0.k.k0 = "c13388";
            c.a.t0.g0.f0.k.q0 = "c13389";
        }
    }

    public final void c0(e2 e2Var, int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(1048579, this, e2Var, i2) == null) || e2Var == null || e2Var.g1() == null) {
            return;
        }
        c.a.t0.v3.c.g().c(this.m, c.a.t0.v3.a.j(e2Var, "a002", "common_click", 1, i2, e2Var.g1().id));
    }

    public final void d0(e2 e2Var, int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(1048580, this, e2Var, i2) == null) || e2Var == null || e2Var.g1() == null) {
            return;
        }
        String str = e2Var.g1().id;
        c.a.t0.v3.c.g().d(this.m, c.a.t0.v3.a.c(e2Var.v1(), "", str, null), c.a.t0.v3.a.k(e2Var, "a002", "common_exp", i2, str));
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.a.d.n.e.a
    /* renamed from: e0 */
    public ThreadCardViewHolder<c.a.t0.g0.f0.k> M(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, viewGroup)) == null) {
            l0.b bVar = new l0.b(this.n.getPageActivity());
            c.a.l.d dVar = new c.a.l.d(this.n.getPageActivity());
            dVar.s(this.m);
            dVar.q(false);
            dVar.v(false);
            dVar.b(1024);
            dVar.r(new a(this));
            bVar.o(dVar);
            c.a.l.x xVar = new c.a.l.x(this.n.getPageActivity());
            xVar.o("index");
            xVar.p(this.o);
            bVar.n(xVar);
            bVar.m(new i0(this.n.getPageActivity()));
            ThreadCardViewHolder<c.a.t0.g0.f0.k> threadCardViewHolder = new ThreadCardViewHolder<>(bVar.j(BaseCardInfo.SupportType.FULL, viewGroup));
            threadCardViewHolder.setPageId(this.m);
            V(new b(this));
            return threadCardViewHolder;
        }
        return (ThreadCardViewHolder) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.a.d.n.e.a
    /* renamed from: f0 */
    public View S(int i2, View view, ViewGroup viewGroup, c.a.t0.g0.f0.k kVar, ThreadCardViewHolder<c.a.t0.g0.f0.k> threadCardViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048582, this, new Object[]{Integer.valueOf(i2), view, viewGroup, kVar, threadCardViewHolder})) == null) {
            if (kVar == null || threadCardViewHolder == null || threadCardViewHolder.getView() == null || kVar.f17778e == null) {
                return null;
            }
            kVar.K(kVar.position + 1);
            kVar.f17778e.T1 = kVar.q();
            threadCardViewHolder.showNEGFeedBackView(false).t(this.p);
            threadCardViewHolder.onBindDataToView(kVar);
            threadCardViewHolder.getCardView().onChangeSkinType(this.n, TbadkCoreApplication.getInst().getSkinType());
            threadCardViewHolder.getCardView().p(this.q);
            c.a.t0.g0.v.b().a(kVar.B());
            c.a.t0.t.d.c().i("page_recommend", "show_", kVar.B());
            d0(kVar.f17778e, kVar.q());
            return threadCardViewHolder.getView();
        }
        return (View) invokeCommon.objValue;
    }

    @Override // c.a.t0.t.f
    public void g(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, str) == null) {
        }
    }

    public void g0(NEGFeedBackView.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, bVar) == null) {
            this.p = bVar;
        }
    }

    public final void h0(e2 e2Var, View view) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048585, this, e2Var, view) == null) || e2Var == null || e2Var.g1() == null) {
            return;
        }
        String str = e2Var.g1().id;
        String str2 = e2Var.g1().link;
        String str3 = e2Var.g1().h5_url;
        Long l = e2Var.g1().swan_app_id;
        long parseLong = Long.parseLong(e2Var.v1());
        long U = e2Var.U();
        String str4 = e2Var.g1().name;
        c.a.s0.s.h0.b.k().x("smart_app_tid", parseLong);
        c.a.s0.s.h0.b.k().y("smart_app_name", str4);
        c.a.s0.s.h0.b.k().y("smart_app_id", str);
        if (StringUtils.isNull(str)) {
            return;
        }
        if (!c.a.t0.z.a.b(str, str2, "1191008600000000", e2Var.g1().is_game)) {
            if (StringUtils.isNull(str3)) {
                return;
            }
            c.a.s0.m.a.m(view.getContext(), str3);
        }
        c.a.t0.g0.m.a(e2Var.v1());
        TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_FE_FITE_PROGRAM_CLICK).param("fid", U).param("tid", parseLong).param("uid", TbadkCoreApplication.getCurrentAccount()).param("obj_name", str4).param("obj_id", l.longValue()).param("obj_source", "index_card").param("obj_param1", e2Var.g1().is_game.intValue()));
    }
}
