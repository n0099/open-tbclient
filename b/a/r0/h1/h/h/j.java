package b.a.r0.h1.h.h;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.InputDeviceCompat;
import b.a.l.l0;
import b.a.l.w0.a;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.card.ThreadCardViewHolder;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.ThreadCardUtils;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.card.data.BaseCardInfo;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class j extends b.a.e.m.e.a<b.a.r0.b0.f0.k, ThreadCardViewHolder<b.a.r0.b0.f0.k>> implements b.a.r0.p.f {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public BdUniqueId m;
    public TbPageContext<?> n;
    public b.a.r0.h1.h.k.f o;
    public String p;
    public boolean q;
    public b.a.e.m.e.s r;
    public b.a.r0.b0.d0<b.a.r0.b0.f0.k> s;

    /* loaded from: classes4.dex */
    public class a extends b.a.r0.b0.d0<b.a.r0.b0.f0.k> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ j f18866b;

        public a(j jVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {jVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f18866b = jVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // b.a.r0.b0.d0
        /* renamed from: d */
        public void a(View view, b.a.r0.b0.f0.k kVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view, kVar) == null) {
                b.a.r0.b0.v.b().d(true);
                b.a.r0.p.d.c().h("page_recommend", "show_");
                if (view == null || this.f18866b.o == null || kVar == null || kVar.getThreadData() == null || StringUtils.isNull(kVar.getThreadData().t1())) {
                    return;
                }
                if ((view.getTag() instanceof String) && !b.a.r0.h1.h.f.b(b.a.e.f.m.b.g(kVar.getThreadData().t1(), 0L))) {
                    b.a.r0.h1.h.f.a(b.a.e.f.m.b.g(kVar.getThreadData().t1(), 0L));
                    this.f18866b.o.e(b.a.e.f.m.b.g(kVar.getThreadData().t1(), 0L), kVar.E(), kVar.t(), kVar.q(), kVar.g(), b.a.e.f.m.b.e((String) view.getTag(), 1), "homepage", kVar.getThreadData().L());
                }
                this.f18866b.m0(view, kVar);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b implements b.a.e.m.e.w {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ j f18867e;

        public b(j jVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {jVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f18867e = jVar;
        }

        @Override // b.a.e.m.e.w
        public void b(View view, b.a.e.m.e.n nVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i2, long j) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{view, nVar, bdUniqueId, viewGroup, Integer.valueOf(i2), Long.valueOf(j)}) == null) && (nVar instanceof b.a.r0.b0.f0.k) && (view.getTag() instanceof ThreadCardViewHolder)) {
                ThreadCardViewHolder threadCardViewHolder = (ThreadCardViewHolder) view.getTag();
                b.a.r0.b0.f0.k kVar = (b.a.r0.b0.f0.k) nVar;
                kVar.k = 1;
                if (this.f18867e.s != null) {
                    this.f18867e.s.a(threadCardViewHolder.getView(), kVar);
                }
                ThreadCardUtils.jumpToPB((b.a.q0.s.q.a) kVar, view.getContext(), 2, false);
                threadCardViewHolder.getCardView().n(new a.C0092a(1));
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public j(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
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
        this.q = true;
        this.s = new a(this);
        this.n = tbPageContext;
        j0();
    }

    @Override // b.a.r0.p.f
    public void g(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
            this.p = str;
        }
    }

    public final void j0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            b.a.r0.b0.f0.k.Y = "c10705";
            b.a.r0.b0.f0.k.Z = "c10730";
            b.a.r0.b0.f0.k.a0 = "c10731";
            b.a.r0.b0.f0.k.b0 = "c10704";
            b.a.r0.b0.f0.k.c0 = "c10755";
            b.a.r0.b0.f0.k.i0 = "c10710";
            b.a.r0.b0.f0.k.j0 = "c10736";
            b.a.r0.b0.f0.k.k0 = "c10737";
            b.a.r0.b0.f0.k.l0 = "c10711";
            b.a.r0.b0.f0.k.m0 = "c10758";
            b.a.r0.b0.f0.k.n0 = "c10757";
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // b.a.e.m.e.a
    /* renamed from: k0 */
    public ThreadCardViewHolder T(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, viewGroup)) == null) {
            l0.b bVar = new l0.b(this.n.getPageActivity(), false);
            b.a.l.n nVar = new b.a.l.n(this.n.getPageActivity());
            nVar.w(this.q);
            nVar.v("index");
            bVar.h(nVar);
            l0 k = bVar.k(BaseCardInfo.SupportType.EXTEND, viewGroup, this.r);
            k.q(2);
            ThreadCardViewHolder threadCardViewHolder = new ThreadCardViewHolder(k);
            threadCardViewHolder.setPageId(this.m);
            c0(new b(this));
            return threadCardViewHolder;
        }
        return (ThreadCardViewHolder) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // b.a.e.m.e.a
    /* renamed from: l0 */
    public View Z(int i2, View view, ViewGroup viewGroup, b.a.r0.b0.f0.k kVar, ThreadCardViewHolder<b.a.r0.b0.f0.k> threadCardViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048581, this, new Object[]{Integer.valueOf(i2), view, viewGroup, kVar, threadCardViewHolder})) == null) {
            if (kVar == null || threadCardViewHolder == null || threadCardViewHolder.getView() == null || kVar.f16235e == null) {
                return null;
            }
            kVar.K(kVar.position + 1);
            kVar.f16235e.T1 = kVar.q();
            threadCardViewHolder.getCardView().p(i2);
            threadCardViewHolder.getCardView().setPage(this.p);
            threadCardViewHolder.onBindDataToView(kVar);
            threadCardViewHolder.getCardView().onChangeSkinType(this.n, TbadkCoreApplication.getInst().getSkinType());
            threadCardViewHolder.getCardView().o(this.s);
            b.a.r0.b0.v.b().a(kVar.B());
            b.a.r0.p.d.c().a(kVar.B());
            b.a.r0.h1.h.m.a.f(kVar.f16235e, this.m, kVar.q());
            return threadCardViewHolder.getView();
        }
        return (View) invokeCommon.objValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:31:0x00c2  */
    /* JADX WARN: Removed duplicated region for block: B:36:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void m0(View view, b.a.r0.b0.f0.k kVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null && interceptable.invokeLL(1048582, this, view, kVar) != null) {
            return;
        }
        int id = view.getId();
        int i2 = 3;
        if (view.getId() != R.id.thread_card_root && id != R.id.thread_info_commont_container) {
            if (id == R.id.god_reply_voice_btn) {
                StatisticItem statisticItem = new StatisticItem("c10760");
                statisticItem.param("obj_locate", 4);
                TiebaStatic.log(statisticItem);
            } else {
                if (id == R.id.god_reply_content) {
                    StatisticItem statisticItem2 = new StatisticItem("c10760");
                    statisticItem2.param("obj_locate", 2);
                    TiebaStatic.log(statisticItem2);
                    i2 = 5;
                    b.a.r0.h1.h.m.a.b(kVar.f16235e, kVar.t(), kVar.q(), 1);
                } else {
                    if (id != R.id.god_reply_user_pendant_header && id != R.id.god_reply_username_text) {
                        if (view instanceof TbImageView) {
                            if (view.getTag(R.id.god_reply_image_layout) instanceof Integer) {
                                StatisticItem statisticItem3 = new StatisticItem("c10760");
                                statisticItem3.param("obj_locate", 3);
                                TiebaStatic.log(statisticItem3);
                            }
                            TiebaStatic.log(kVar.R());
                            b.a.r0.p.d.c().i("page_recommend", "clk_", kVar.R());
                            b.a.r0.h1.h.m.a.b(kVar.f16235e, kVar.t(), kVar.q(), 2);
                        }
                    } else {
                        StatisticItem statisticItem4 = new StatisticItem("c10760");
                        statisticItem4.param("obj_locate", 1);
                        TiebaStatic.log(statisticItem4);
                    }
                    i2 = 0;
                }
                if (i2 == 0) {
                    b.a.r0.h1.h.m.a.c(kVar.f16235e, this.m, kVar.q(), i2);
                    return;
                }
                return;
            }
        } else {
            TiebaStatic.log(kVar.A());
            b.a.r0.p.d.c().i("page_recommend", "clk_", kVar.A());
            b.a.r0.h1.h.m.a.b(kVar.f16235e, kVar.t(), kVar.q(), 1);
        }
        i2 = 1;
        if (i2 == 0) {
        }
    }

    public void n0(b.a.r0.h1.h.k.f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, fVar) == null) {
            this.o = fVar;
        }
    }

    public void o0(b.a.e.m.e.s sVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, sVar) == null) {
            this.r = sVar;
        }
    }

    public void setFromCDN(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048585, this, z) == null) {
            this.q = z;
        }
    }
}
