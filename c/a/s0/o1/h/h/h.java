package c.a.s0.o1.h.h;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.InputDeviceCompat;
import c.a.l.l0;
import c.a.l.w0.a;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.card.ThreadCardViewHolder;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.ThreadCardUtils;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.R;
import com.baidu.tieba.card.data.BaseCardInfo;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes8.dex */
public class h extends c.a.d.m.e.a<c.a.s0.g0.f0.k, ThreadCardViewHolder<c.a.s0.g0.f0.k>> implements c.a.s0.t.f {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public BdUniqueId m;
    public TbPageContext<?> n;
    public c.a.s0.o1.h.k.f o;
    public String p;
    public c.a.d.m.e.s q;
    public c.a.s0.g0.d0<c.a.s0.g0.f0.k> r;

    /* loaded from: classes8.dex */
    public class a extends c.a.s0.g0.d0<c.a.s0.g0.f0.k> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ h f21015b;

        public a(h hVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f21015b = hVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.s0.g0.d0
        /* renamed from: d */
        public void a(View view, c.a.s0.g0.f0.k kVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view, kVar) == null) {
                c.a.s0.g0.v.b().d(true);
                c.a.s0.t.d.c().h("page_recommend", "show_");
                if (view == null || this.f21015b.o == null || kVar == null || kVar.getThreadData() == null || StringUtils.isNull(kVar.getThreadData().v1())) {
                    return;
                }
                if ((view.getTag() instanceof String) && !c.a.s0.o1.h.f.b(c.a.d.f.m.b.g(kVar.getThreadData().v1(), 0L))) {
                    c.a.s0.o1.h.f.a(c.a.d.f.m.b.g(kVar.getThreadData().v1(), 0L));
                    this.f21015b.o.e(c.a.d.f.m.b.g(kVar.getThreadData().v1(), 0L), kVar.E(), kVar.t(), kVar.q(), kVar.g(), c.a.d.f.m.b.e((String) view.getTag(), 1), "homepage", kVar.getThreadData().L());
                }
                this.f21015b.m0(view, kVar);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class b implements c.a.d.m.e.w {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ h f21016e;

        public b(h hVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f21016e = hVar;
        }

        @Override // c.a.d.m.e.w
        public void b(View view, c.a.d.m.e.n nVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i2, long j2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{view, nVar, bdUniqueId, viewGroup, Integer.valueOf(i2), Long.valueOf(j2)}) == null) && (nVar instanceof c.a.s0.g0.f0.k) && (view.getTag() instanceof ThreadCardViewHolder)) {
                ThreadCardViewHolder threadCardViewHolder = (ThreadCardViewHolder) view.getTag();
                c.a.s0.g0.f0.k kVar = (c.a.s0.g0.f0.k) nVar;
                kVar.f17733k = 1;
                if (this.f21016e.r != null) {
                    this.f21016e.r.a(threadCardViewHolder.getView(), kVar);
                }
                ThreadCardUtils.jumpToPB((c.a.r0.s.r.a) kVar, view.getContext(), 2, false);
                threadCardViewHolder.getCardView().o(new a.C0165a(1));
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public h(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
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
        this.r = new a(this);
        this.n = tbPageContext;
        j0();
    }

    @Override // c.a.s0.t.f
    public void g(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
            this.p = str;
        }
    }

    public final void j0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            c.a.s0.g0.f0.k.Y = "c10705";
            c.a.s0.g0.f0.k.Z = "c10730";
            c.a.s0.g0.f0.k.a0 = "c10731";
            c.a.s0.g0.f0.k.b0 = "c10704";
            c.a.s0.g0.f0.k.c0 = "c10755";
            c.a.s0.g0.f0.k.d0 = "c10710";
            c.a.s0.g0.f0.k.e0 = "c10736";
            c.a.s0.g0.f0.k.f0 = "c10737";
            c.a.s0.g0.f0.k.g0 = "c10711";
            c.a.s0.g0.f0.k.h0 = "c10758";
            c.a.s0.g0.f0.k.i0 = "c10757";
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.a.d.m.e.a
    /* renamed from: k0 */
    public ThreadCardViewHolder S(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, viewGroup)) == null) {
            l0.b bVar = new l0.b(this.n.getPageActivity(), false);
            c.a.l.k kVar = new c.a.l.k(this.n.getPageActivity());
            kVar.s();
            bVar.h(kVar);
            l0 k2 = bVar.k(BaseCardInfo.SupportType.EXTEND, viewGroup, this.q);
            k2.r(2);
            ThreadCardViewHolder threadCardViewHolder = new ThreadCardViewHolder(k2);
            threadCardViewHolder.setPageId(this.m);
            c0(new b(this));
            return threadCardViewHolder;
        }
        return (ThreadCardViewHolder) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.a.d.m.e.a
    /* renamed from: l0 */
    public View Z(int i2, View view, ViewGroup viewGroup, c.a.s0.g0.f0.k kVar, ThreadCardViewHolder<c.a.s0.g0.f0.k> threadCardViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048581, this, new Object[]{Integer.valueOf(i2), view, viewGroup, kVar, threadCardViewHolder})) == null) {
            if (kVar == null || threadCardViewHolder == null || threadCardViewHolder.getView() == null || kVar.f17727e == null) {
                return null;
            }
            kVar.K(kVar.position + 1);
            kVar.f17727e.U1 = kVar.q();
            threadCardViewHolder.getCardView().q(i2);
            threadCardViewHolder.getCardView().d(this.p);
            threadCardViewHolder.onBindDataToView(kVar);
            threadCardViewHolder.getCardView().onChangeSkinType(this.n, TbadkCoreApplication.getInst().getSkinType());
            threadCardViewHolder.getCardView().p(this.r);
            c.a.s0.g0.v.b().a(kVar.B());
            c.a.s0.t.d.c().a(kVar.B());
            c.a.s0.o1.h.m.a.f(kVar.f17727e, this.m, kVar.q());
            return threadCardViewHolder.getView();
        }
        return (View) invokeCommon.objValue;
    }

    public final void m0(View view, c.a.s0.g0.f0.k kVar) {
        StatisticItem A;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048582, this, view, kVar) == null) {
            int id = view.getId();
            if (kVar == null) {
                return;
            }
            if (view.getId() != R.id.thread_card_root && id != R.id.thread_info_commont_container) {
                if (id == R.id.forum_name_text || id == R.id.forum_enter_button) {
                    TiebaStatic.log(kVar.o());
                    c.a.s0.t.d.c().i("page_recommend", "clk_", kVar.o());
                    i2 = 9;
                } else {
                    i2 = 0;
                }
            } else {
                if (kVar.G()) {
                    A = kVar.D();
                } else {
                    A = kVar.A();
                }
                TiebaStatic.log(A);
                c.a.s0.t.d.c().i("page_recommend", "clk_", A);
                i2 = 1;
                c.a.s0.o1.h.m.a.a(kVar.f17727e, kVar.t(), kVar.q());
            }
            if (i2 != 0) {
                c.a.s0.o1.h.m.a.c(kVar.f17727e, this.m, kVar.q(), i2);
            }
        }
    }

    public void n0(c.a.s0.o1.h.k.f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, fVar) == null) {
            this.o = fVar;
        }
    }

    public void o0(c.a.d.m.e.s sVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, sVar) == null) {
            this.q = sVar;
        }
    }
}
