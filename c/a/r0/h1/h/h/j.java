package c.a.r0.h1.h.h;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.InputDeviceCompat;
import c.a.l.l0;
import c.a.l.v0.a;
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
/* loaded from: classes3.dex */
public class j extends c.a.e.l.e.a<c.a.r0.b0.e0.k, ThreadCardViewHolder<c.a.r0.b0.e0.k>> implements c.a.r0.p.f {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public BdUniqueId m;
    public TbPageContext<?> n;
    public c.a.r0.h1.h.k.f o;
    public String p;
    public boolean q;
    public c.a.e.l.e.s r;
    public c.a.r0.b0.c0<c.a.r0.b0.e0.k> s;

    /* loaded from: classes3.dex */
    public class a extends c.a.r0.b0.c0<c.a.r0.b0.e0.k> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ j f18463b;

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
            this.f18463b = jVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.r0.b0.c0
        /* renamed from: d */
        public void a(View view, c.a.r0.b0.e0.k kVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view, kVar) == null) {
                c.a.r0.b0.u.b().d(true);
                c.a.r0.p.d.c().h("page_recommend", "show_");
                if (view == null || this.f18463b.o == null || kVar == null || kVar.getThreadData() == null || StringUtils.isNull(kVar.getThreadData().s1())) {
                    return;
                }
                if ((view.getTag() instanceof String) && !c.a.r0.h1.h.f.b(c.a.e.e.m.b.g(kVar.getThreadData().s1(), 0L))) {
                    c.a.r0.h1.h.f.a(c.a.e.e.m.b.g(kVar.getThreadData().s1(), 0L));
                    this.f18463b.o.e(c.a.e.e.m.b.g(kVar.getThreadData().s1(), 0L), kVar.E(), kVar.t(), kVar.q(), kVar.g(), c.a.e.e.m.b.e((String) view.getTag(), 1), "homepage", kVar.getThreadData().L());
                }
                this.f18463b.n0(view, kVar);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b implements c.a.e.l.e.w {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ j f18464e;

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
            this.f18464e = jVar;
        }

        @Override // c.a.e.l.e.w
        public void b(View view, c.a.e.l.e.n nVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i2, long j2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{view, nVar, bdUniqueId, viewGroup, Integer.valueOf(i2), Long.valueOf(j2)}) == null) && (nVar instanceof c.a.r0.b0.e0.k) && (view.getTag() instanceof ThreadCardViewHolder)) {
                ThreadCardViewHolder threadCardViewHolder = (ThreadCardViewHolder) view.getTag();
                c.a.r0.b0.e0.k kVar = (c.a.r0.b0.e0.k) nVar;
                kVar.k = 1;
                if (this.f18464e.s != null) {
                    this.f18464e.s.a(threadCardViewHolder.getView(), kVar);
                }
                ThreadCardUtils.jumpToPB((c.a.q0.s.q.a) kVar, view.getContext(), 2, false);
                threadCardViewHolder.getCardView().o(new a.C0095a(1));
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
        k0();
    }

    @Override // c.a.r0.p.f
    public void g(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
            this.p = str;
        }
    }

    public final void k0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            c.a.r0.b0.e0.k.W = "c10705";
            c.a.r0.b0.e0.k.X = "c10730";
            c.a.r0.b0.e0.k.Y = "c10731";
            c.a.r0.b0.e0.k.Z = "c10704";
            c.a.r0.b0.e0.k.a0 = "c10755";
            c.a.r0.b0.e0.k.b0 = "c10710";
            c.a.r0.b0.e0.k.c0 = "c10736";
            c.a.r0.b0.e0.k.i0 = "c10737";
            c.a.r0.b0.e0.k.j0 = "c10711";
            c.a.r0.b0.e0.k.k0 = "c10758";
            c.a.r0.b0.e0.k.l0 = "c10757";
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.a.e.l.e.a
    /* renamed from: l0 */
    public ThreadCardViewHolder U(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, viewGroup)) == null) {
            l0.b bVar = new l0.b(this.n.getPageActivity(), false);
            c.a.l.n nVar = new c.a.l.n(this.n.getPageActivity());
            nVar.w(this.q);
            nVar.v("index");
            bVar.h(nVar);
            l0 k = bVar.k(BaseCardInfo.SupportType.EXTEND, viewGroup, this.r);
            k.r(2);
            ThreadCardViewHolder threadCardViewHolder = new ThreadCardViewHolder(k);
            threadCardViewHolder.setPageId(this.m);
            d0(new b(this));
            return threadCardViewHolder;
        }
        return (ThreadCardViewHolder) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.a.e.l.e.a
    /* renamed from: m0 */
    public View a0(int i2, View view, ViewGroup viewGroup, c.a.r0.b0.e0.k kVar, ThreadCardViewHolder<c.a.r0.b0.e0.k> threadCardViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048581, this, new Object[]{Integer.valueOf(i2), view, viewGroup, kVar, threadCardViewHolder})) == null) {
            if (kVar == null || threadCardViewHolder == null || threadCardViewHolder.getView() == null || kVar.f15721e == null) {
                return null;
            }
            kVar.K(kVar.position + 1);
            kVar.f15721e.T1 = kVar.q();
            threadCardViewHolder.getCardView().q(i2);
            threadCardViewHolder.getCardView().setPage(this.p);
            threadCardViewHolder.onBindDataToView(kVar);
            threadCardViewHolder.getCardView().onChangeSkinType(this.n, TbadkCoreApplication.getInst().getSkinType());
            threadCardViewHolder.getCardView().p(this.s);
            c.a.r0.b0.u.b().a(kVar.B());
            c.a.r0.p.d.c().a(kVar.B());
            c.a.r0.h1.h.m.a.f(kVar.f15721e, this.m, kVar.q());
            return threadCardViewHolder.getView();
        }
        return (View) invokeCommon.objValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:31:0x00c2  */
    /* JADX WARN: Removed duplicated region for block: B:36:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void n0(View view, c.a.r0.b0.e0.k kVar) {
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
                    c.a.r0.h1.h.m.a.b(kVar.f15721e, kVar.t(), kVar.q(), 1);
                } else {
                    if (id != R.id.god_reply_user_pendant_header && id != R.id.god_reply_username_text) {
                        if (view instanceof TbImageView) {
                            if (view.getTag(R.id.god_reply_image_layout) instanceof Integer) {
                                StatisticItem statisticItem3 = new StatisticItem("c10760");
                                statisticItem3.param("obj_locate", 3);
                                TiebaStatic.log(statisticItem3);
                            }
                            TiebaStatic.log(kVar.R());
                            c.a.r0.p.d.c().i("page_recommend", "clk_", kVar.R());
                            c.a.r0.h1.h.m.a.b(kVar.f15721e, kVar.t(), kVar.q(), 2);
                        }
                    } else {
                        StatisticItem statisticItem4 = new StatisticItem("c10760");
                        statisticItem4.param("obj_locate", 1);
                        TiebaStatic.log(statisticItem4);
                    }
                    i2 = 0;
                }
                if (i2 == 0) {
                    c.a.r0.h1.h.m.a.c(kVar.f15721e, this.m, kVar.q(), i2);
                    return;
                }
                return;
            }
        } else {
            TiebaStatic.log(kVar.A());
            c.a.r0.p.d.c().i("page_recommend", "clk_", kVar.A());
            c.a.r0.h1.h.m.a.b(kVar.f15721e, kVar.t(), kVar.q(), 1);
        }
        i2 = 1;
        if (i2 == 0) {
        }
    }

    public void o0(c.a.r0.h1.h.k.f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, fVar) == null) {
            this.o = fVar;
        }
    }

    public void p0(c.a.e.l.e.s sVar) {
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
