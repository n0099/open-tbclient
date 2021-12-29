package c.a.t0.o1.h.h;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.core.view.InputDeviceCompat;
import c.a.l.l0;
import c.a.l.w0.a;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.card.ThreadCardViewHolder;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbSingleton;
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
/* loaded from: classes7.dex */
public class f extends c.a.d.n.e.a<c.a.t0.g0.f0.k, ThreadCardViewHolder<c.a.t0.g0.f0.k>> implements c.a.t0.t.f {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public BdUniqueId m;
    public TbPageContext<?> n;
    public c.a.t0.o1.h.k.f o;
    public String p;
    public boolean q;
    public c.a.d.n.e.s r;
    public c.a.t0.g0.d0<c.a.t0.g0.f0.k> s;

    /* loaded from: classes7.dex */
    public class a extends c.a.t0.g0.d0<c.a.t0.g0.f0.k> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ f f21052b;

        public a(f fVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f21052b = fVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.t0.g0.d0
        /* renamed from: d */
        public void a(View view, c.a.t0.g0.f0.k kVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view, kVar) == null) {
                c.a.t0.g0.v.b().d(true);
                c.a.t0.t.d.c().h("page_recommend", "show_");
                if (view == null || this.f21052b.o == null || kVar == null || kVar.getThreadData() == null || StringUtils.isNull(kVar.getThreadData().v1())) {
                    return;
                }
                if ((view.getTag() instanceof String) && !c.a.t0.o1.h.f.b(c.a.d.f.m.b.g(kVar.getThreadData().v1(), 0L))) {
                    c.a.t0.o1.h.f.a(c.a.d.f.m.b.g(kVar.getThreadData().v1(), 0L));
                    this.f21052b.o.e(c.a.d.f.m.b.g(kVar.getThreadData().v1(), 0L), kVar.E(), kVar.t(), kVar.q(), kVar.g(), c.a.d.f.m.b.e((String) view.getTag(), 1), "homepage", kVar.getThreadData().L());
                }
                this.f21052b.f0(view, kVar);
                TbSingleton.getInstance().saveHomeRecommendItemClickTime();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b implements c.a.d.n.e.w {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ f f21053e;

        public b(f fVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f21053e = fVar;
        }

        @Override // c.a.d.n.e.w
        public void b(View view, c.a.d.n.e.n nVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i2, long j2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{view, nVar, bdUniqueId, viewGroup, Integer.valueOf(i2), Long.valueOf(j2)}) == null) && (nVar instanceof c.a.t0.g0.f0.k) && (view.getTag() instanceof ThreadCardViewHolder)) {
                ThreadCardViewHolder threadCardViewHolder = (ThreadCardViewHolder) view.getTag();
                c.a.t0.g0.f0.k kVar = (c.a.t0.g0.f0.k) nVar;
                kVar.f18228k = 1;
                if (this.f21053e.s != null) {
                    this.f21053e.s.a(threadCardViewHolder.getView(), kVar);
                }
                ThreadCardUtils.jumpToPB((c.a.s0.s.q.a) kVar, view.getContext(), 2, false);
                threadCardViewHolder.getCardView().o(new a.C0186a(1));
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public f(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
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
        c0();
    }

    public final void c0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            c.a.t0.g0.f0.k.Y = "c10705";
            c.a.t0.g0.f0.k.Z = "c10730";
            c.a.t0.g0.f0.k.a0 = "c10731";
            c.a.t0.g0.f0.k.b0 = "c10704";
            c.a.t0.g0.f0.k.c0 = "c10755";
            c.a.t0.g0.f0.k.d0 = "c10710";
            c.a.t0.g0.f0.k.e0 = "c10736";
            c.a.t0.g0.f0.k.f0 = "c10737";
            c.a.t0.g0.f0.k.g0 = "c10711";
            c.a.t0.g0.f0.k.h0 = "c10758";
            c.a.t0.g0.f0.k.i0 = "c10757";
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.a.d.n.e.a
    /* renamed from: d0 */
    public ThreadCardViewHolder M(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, viewGroup)) == null) {
            l0.b bVar = new l0.b(this.n.getPageActivity(), false);
            c.a.l.y yVar = new c.a.l.y(this.n.getPageActivity());
            yVar.p("index");
            yVar.q(this.q);
            bVar.n(yVar);
            l0 k2 = bVar.k(BaseCardInfo.SupportType.CONTENT, viewGroup, this.r);
            k2.r(2);
            ThreadCardViewHolder threadCardViewHolder = new ThreadCardViewHolder(k2);
            threadCardViewHolder.setPageId(this.m);
            V(new b(this));
            return threadCardViewHolder;
        }
        return (ThreadCardViewHolder) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.a.d.n.e.a
    /* renamed from: e0 */
    public View S(int i2, View view, ViewGroup viewGroup, c.a.t0.g0.f0.k kVar, ThreadCardViewHolder<c.a.t0.g0.f0.k> threadCardViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048580, this, new Object[]{Integer.valueOf(i2), view, viewGroup, kVar, threadCardViewHolder})) == null) {
            if (kVar == null || threadCardViewHolder == null || threadCardViewHolder.getView() == null || kVar.f18222e == null) {
                return null;
            }
            kVar.K(kVar.position + 1);
            kVar.f18222e.U1 = kVar.q();
            threadCardViewHolder.getCardView().q(i2);
            threadCardViewHolder.getCardView().d(this.p);
            threadCardViewHolder.onBindDataToView(kVar);
            threadCardViewHolder.getCardView().onChangeSkinType(this.n, TbadkCoreApplication.getInst().getSkinType());
            threadCardViewHolder.getCardView().p(this.s);
            c.a.t0.g0.v.b().a(kVar.B());
            c.a.t0.t.d.c().a(kVar.B());
            c.a.l.y yVar = (c.a.l.y) threadCardViewHolder.getCardView().g();
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) yVar.f4319j.singalImg.getLayoutParams();
            layoutParams.width = kVar.o;
            layoutParams.height = kVar.p;
            if (yVar.f4319j.singalImg.getVisibility() != 8) {
                yVar.f4319j.singalImg.setLayoutParams(layoutParams);
            }
            c.a.t0.o1.h.m.a.f(kVar.f18222e, this.m, kVar.q());
            c.a.t0.o1.h.m.a.e(kVar.f18222e, kVar.t(), kVar.q());
            return threadCardViewHolder.getView();
        }
        return (View) invokeCommon.objValue;
    }

    public final void f0(View view, c.a.t0.g0.f0.k kVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048581, this, view, kVar) == null) {
            int id = view.getId();
            int i2 = 3;
            if (view.getId() != R.id.thread_card_root && id != R.id.thread_info_commont_container) {
                if (id == R.id.user_avatar) {
                    TiebaStatic.log(kVar.U());
                    c.a.t0.t.d.c().i("page_recommend", "clk_", kVar.U());
                } else if (id == R.id.user_name) {
                    TiebaStatic.log(kVar.U());
                    c.a.t0.t.d.c().i("page_recommend", "clk_", kVar.U());
                } else if (id == R.id.forum_name_text) {
                    TiebaStatic.log(kVar.o());
                    c.a.t0.t.d.c().i("page_recommend", "clk_", kVar.o());
                    i2 = 9;
                } else {
                    if (id == R.id.god_reply_content) {
                        StatisticItem statisticItem = new StatisticItem("c10760");
                        statisticItem.param("obj_locate", 2);
                        TiebaStatic.log(statisticItem);
                    } else if (id != R.id.god_reply_user_pendant_header && id != R.id.god_reply_username_text) {
                        if (view instanceof TbImageView) {
                            if (view.getTag(R.id.god_reply_image_layout) instanceof Integer) {
                                StatisticItem statisticItem2 = new StatisticItem("c10760");
                                statisticItem2.param("obj_locate", 3);
                                TiebaStatic.log(statisticItem2);
                            }
                            TiebaStatic.log(kVar.R());
                            c.a.t0.t.d.c().i("page_recommend", "clk_", kVar.R());
                            c.a.t0.o1.h.m.a.b(kVar.f18222e, kVar.t(), kVar.q(), 2);
                        } else {
                            i2 = 0;
                        }
                    } else {
                        StatisticItem statisticItem3 = new StatisticItem("c10760");
                        statisticItem3.param("obj_locate", 1);
                        TiebaStatic.log(statisticItem3);
                    }
                    i2 = 5;
                }
                i2 = 2;
            } else {
                TiebaStatic.log(kVar.A());
                c.a.t0.t.d.c().i("page_recommend", "clk_", kVar.A());
                c.a.t0.o1.h.m.a.b(kVar.f18222e, kVar.t(), kVar.q(), 1);
                i2 = 1;
            }
            if (i2 != 0) {
                c.a.t0.o1.h.m.a.c(kVar.f18222e, this.m, kVar.q(), i2);
            }
        }
    }

    @Override // c.a.t0.t.f
    public void g(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, str) == null) {
            this.p = str;
        }
    }

    public void g0(c.a.t0.o1.h.k.f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, fVar) == null) {
            this.o = fVar;
        }
    }

    public void h0(c.a.d.n.e.s sVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, sVar) == null) {
            this.r = sVar;
        }
    }
}
