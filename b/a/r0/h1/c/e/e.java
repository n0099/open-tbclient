package b.a.r0.h1.c.e;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import b.a.l.a;
import b.a.l.d;
import b.a.l.g0;
import b.a.l.l0;
import b.a.l.n0;
import b.a.l.o0;
import b.a.l.w0.a;
import b.a.q0.s.q.d2;
import b.a.r0.b0.d0;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.card.Align;
import com.baidu.card.ThreadCardViewHolder;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.ThreadCardUtils;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.card.data.BaseCardInfo;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class e extends b.a.e.m.e.a<b.a.r0.b0.f0.k, ThreadCardViewHolder<b.a.r0.b0.f0.k>> implements b.a.r0.p.f {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public BdUniqueId m;
    public TbPageContext<?> n;
    public String o;
    public b.a.e.m.e.s p;
    public d0<b.a.r0.b0.f0.k> q;

    /* loaded from: classes4.dex */
    public class a extends d0<b.a.r0.b0.f0.k> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public a(e eVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // b.a.r0.b0.d0
        /* renamed from: d */
        public void a(View view, b.a.r0.b0.f0.k kVar) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view, kVar) == null) || view == null || kVar == null || kVar.getThreadData() == null || StringUtils.isNull(kVar.getThreadData().t1())) {
                return;
            }
            int id = view.getId();
            if (id != R.id.thread_card_root && id != R.id.thread_info_commont_container) {
                if (id != R.id.user_avatar && id != R.id.user_name) {
                    if (id == R.id.god_reply_voice_btn) {
                        StatisticItem statisticItem = new StatisticItem("c13423");
                        statisticItem.param("obj_locate", 4);
                        if (kVar != null) {
                            statisticItem.param("tid", kVar.l);
                            d2 d2Var = kVar.f16235e;
                            if (d2Var != null && d2Var.w1() != null) {
                                statisticItem.param("pid", kVar.f16235e.w1().G());
                            }
                        }
                        TiebaStatic.log(statisticItem);
                        return;
                    } else if (id == R.id.god_reply_content) {
                        StatisticItem statisticItem2 = new StatisticItem("c13423");
                        statisticItem2.param("obj_locate", 2);
                        if (kVar != null) {
                            statisticItem2.param("tid", kVar.l);
                            d2 d2Var2 = kVar.f16235e;
                            if (d2Var2 != null && d2Var2.w1() != null) {
                                statisticItem2.param("pid", kVar.f16235e.w1().G());
                            }
                        }
                        TiebaStatic.log(statisticItem2);
                        return;
                    } else if (id != R.id.god_reply_user_pendant_header && id != R.id.god_reply_username_text) {
                        if (id == R.id.god_reply_agree_view) {
                            StatisticItem statisticItem3 = new StatisticItem("c13423");
                            statisticItem3.param("obj_locate", 5);
                            if (kVar != null) {
                                statisticItem3.param("tid", kVar.l);
                                d2 d2Var3 = kVar.f16235e;
                                if (d2Var3 != null && d2Var3.w1() != null) {
                                    statisticItem3.param("pid", kVar.f16235e.w1().G());
                                }
                            }
                            TiebaStatic.log(statisticItem3);
                            return;
                        } else if (id == R.id.forum_name_text) {
                            b.a.r0.h1.c.c.b(view, kVar, 7);
                            return;
                        } else if (id != R.id.thread_card_title && id != R.id.thread_card_abstract) {
                            if (view instanceof TbImageView) {
                                if (view.getTag(R.id.god_reply_image_layout) instanceof Integer) {
                                    StatisticItem statisticItem4 = new StatisticItem("c13423");
                                    statisticItem4.param("obj_locate", 3);
                                    if (kVar != null) {
                                        statisticItem4.param("tid", kVar.l);
                                        d2 d2Var4 = kVar.f16235e;
                                        if (d2Var4 != null && d2Var4.w1() != null) {
                                            statisticItem4.param("pid", kVar.f16235e.w1().G());
                                        }
                                    }
                                    TiebaStatic.log(statisticItem4);
                                    return;
                                }
                                b.a.r0.h1.c.c.b(view, kVar, 6);
                                return;
                            }
                            return;
                        } else {
                            b.a.r0.h1.c.c.b(view, kVar, 2);
                            return;
                        }
                    } else {
                        StatisticItem statisticItem5 = new StatisticItem("c13423");
                        statisticItem5.param("obj_locate", 1);
                        if (kVar != null) {
                            statisticItem5.param("tid", kVar.l);
                            d2 d2Var5 = kVar.f16235e;
                            if (d2Var5 != null && d2Var5.w1() != null) {
                                statisticItem5.param("pid", kVar.f16235e.w1().G());
                            }
                        }
                        TiebaStatic.log(statisticItem5);
                        return;
                    }
                }
                b.a.r0.h1.c.c.b(view, kVar, 1);
                return;
            }
            b.a.r0.h1.c.c.b(view, kVar, 2);
        }
    }

    /* loaded from: classes4.dex */
    public class b implements d.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public b(e eVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar};
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
    public class c implements a.InterfaceC0090a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ g0 f18433a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ e f18434b;

        public c(e eVar, g0 g0Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar, g0Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f18434b = eVar;
            this.f18433a = g0Var;
        }

        @Override // b.a.l.a.InterfaceC0090a
        public void a(b.a.q0.s.q.a aVar) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) || aVar == null || aVar.getThreadData() == null || aVar.getThreadData().y1 == null) {
                return;
            }
            ThreadCardUtils.jumpToPB(aVar.getThreadData().y1, this.f18434b.f2421e, 1);
            b.a.r0.h1.c.c.b(this.f18433a.f(), aVar, 6);
        }
    }

    /* loaded from: classes4.dex */
    public class d implements a.InterfaceC0090a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ o0 f18435a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ e f18436b;

        public d(e eVar, o0 o0Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar, o0Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f18436b = eVar;
            this.f18435a = o0Var;
        }

        @Override // b.a.l.a.InterfaceC0090a
        public void a(b.a.q0.s.q.a aVar) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) || aVar == null || aVar.getThreadData() == null || aVar.getThreadData().y1 == null) {
                return;
            }
            ThreadCardUtils.jumpToPB(aVar.getThreadData().y1, this.f18436b.f2421e, 1);
            b.a.r0.h1.c.c.b(this.f18435a.f(), aVar, 6);
        }
    }

    /* renamed from: b.a.r0.h1.c.e.e$e  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C0941e implements b.a.e.m.e.w {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ e f18437e;

        public C0941e(e eVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f18437e = eVar;
        }

        @Override // b.a.e.m.e.w
        public void b(View view, b.a.e.m.e.n nVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i2, long j) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{view, nVar, bdUniqueId, viewGroup, Integer.valueOf(i2), Long.valueOf(j)}) == null) && (nVar instanceof b.a.r0.b0.f0.k) && (view.getTag() instanceof ThreadCardViewHolder)) {
                ThreadCardViewHolder threadCardViewHolder = (ThreadCardViewHolder) view.getTag();
                b.a.r0.b0.f0.k kVar = (b.a.r0.b0.f0.k) nVar;
                kVar.k = 1;
                if (this.f18437e.q != null) {
                    this.f18437e.q.a(threadCardViewHolder.getView(), kVar);
                }
                ThreadCardUtils.jumpToPB((b.a.q0.s.q.a) kVar, view.getContext(), 1, false);
                threadCardViewHolder.getCardView().n(new a.C0092a(1));
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
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
        this.q = new a(this);
        this.n = tbPageContext;
    }

    @Override // b.a.r0.p.f
    public void g(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
            this.o = str;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // b.a.e.m.e.a
    /* renamed from: j0 */
    public ThreadCardViewHolder<b.a.r0.b0.f0.k> T(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, viewGroup)) == null) {
            l0.b bVar = new l0.b(this.n.getPageActivity());
            b.a.l.d dVar = new b.a.l.d(this.n.getPageActivity());
            dVar.s(this.m);
            dVar.a(128);
            dVar.b(1024);
            dVar.r(new b(this));
            bVar.o(dVar);
            g0 g0Var = new g0(this.n);
            g0Var.m(Boolean.FALSE);
            g0Var.u(ImageViewerConfig.FROM_CONCERN);
            bVar.l().g(b.a.e.f.p.l.g(this.f2421e, R.dimen.tbds28));
            bVar.n(g0Var);
            g0 g0Var2 = new g0(this.n);
            g0Var2.m(Boolean.TRUE);
            g0Var2.u(ImageViewerConfig.FROM_CONCERN);
            g0Var2.x(b.a.q0.b.g.b.b(), UtilHelper.getDimenPixelSize(R.dimen.M_H_X004), b.a.q0.b.g.b.b(), UtilHelper.getDimenPixelSize(R.dimen.M_H_X004));
            g0Var2.v(new c(this, g0Var2));
            bVar.h(g0Var2);
            o0 o0Var = new o0(this.n.getPageActivity());
            o0Var.m(Boolean.TRUE);
            o0Var.t(new d(this, o0Var));
            bVar.h(o0Var);
            bVar.h(new b.a.l.k(this.n.getPageActivity()));
            n0 n0Var = new n0(this.n.getPageActivity());
            b.a.q0.s.q.f fVar = new b.a.q0.s.q.f();
            fVar.f14080b = 9;
            fVar.f14086h = 9;
            n0Var.u(fVar);
            n0Var.v(9);
            n0Var.z(4);
            n0Var.w(1);
            n0Var.a(32);
            bVar.m(n0Var);
            l0 k = bVar.k(BaseCardInfo.SupportType.FULL, viewGroup, this.p);
            k.q(1);
            ThreadCardViewHolder<b.a.r0.b0.f0.k> threadCardViewHolder = new ThreadCardViewHolder<>(k);
            threadCardViewHolder.setPageId(this.m);
            c0(new C0941e(this));
            return threadCardViewHolder;
        }
        return (ThreadCardViewHolder) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // b.a.e.m.e.a
    /* renamed from: k0 */
    public View Z(int i2, View view, ViewGroup viewGroup, b.a.r0.b0.f0.k kVar, ThreadCardViewHolder<b.a.r0.b0.f0.k> threadCardViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048580, this, new Object[]{Integer.valueOf(i2), view, viewGroup, kVar, threadCardViewHolder})) == null) {
            if (kVar == null || threadCardViewHolder == null || threadCardViewHolder.getView() == null || kVar.f16235e == null) {
                return null;
            }
            kVar.K(kVar.position + 1);
            threadCardViewHolder.getCardView().p(i2);
            b.a.r0.b0.v.b().a(kVar.i("c12351"));
            threadCardViewHolder.getCardView().setPage(this.o);
            threadCardViewHolder.showUnfollowedDecorItemIfNeed(true, Align.ALIGN_RIGHT_TOP);
            threadCardViewHolder.showConcernForumDecorItem();
            threadCardViewHolder.onBindDataToView(kVar);
            threadCardViewHolder.getCardView().onChangeSkinType(this.n, TbadkCoreApplication.getInst().getSkinType());
            threadCardViewHolder.getCardView().o(this.q);
            return threadCardViewHolder.getView();
        }
        return (View) invokeCommon.objValue;
    }

    public void l0(b.a.e.m.e.s sVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, sVar) == null) {
            this.p = sVar;
        }
    }
}
