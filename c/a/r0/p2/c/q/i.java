package c.a.r0.p2.c.q;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.InputDeviceCompat;
import c.a.e.l.e.n;
import c.a.e.l.e.s;
import c.a.e.l.e.w;
import c.a.l.a0;
import c.a.l.d;
import c.a.l.h0;
import c.a.l.l0;
import c.a.l.n0;
import c.a.l.v0.a;
import c.a.r0.b0.c0;
import c.a.r0.b0.e0.k;
import c.a.r0.b0.e0.l;
import c.a.r0.p2.j.m;
import com.baidu.adp.BdUniqueId;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.card.AutoVideoCardViewHolder;
import com.baidu.card.ThreadCardViewHolder;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.util.ThreadCardUtils;
import com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public class i extends c.a.e.l.e.a<l, AutoVideoCardViewHolder<l>> implements c.a.r0.p.f {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public BdUniqueId m;
    public TbPageContext<?> n;
    public String o;
    public int p;
    public int q;
    public boolean r;
    public c0<l> s;

    /* loaded from: classes3.dex */
    public class a extends c0<l> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public a(i iVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {iVar};
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
        @Override // c.a.r0.b0.c0
        /* renamed from: d */
        public void a(View view, l lVar) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view, lVar) == null) || view == null || lVar == null || lVar.getThreadData() == null) {
                return;
            }
            int id = view.getId();
            if (id != R.id.thread_card_root && id != R.id.video_seg_title) {
                if (id == R.id.operable_video_container) {
                    c.a.r0.p2.a.a(view, lVar, 4);
                    return;
                } else if (id == R.id.forum_name_text) {
                    c.a.r0.p2.a.a(view, lVar, 7);
                    return;
                } else {
                    return;
                }
            }
            c.a.r0.p2.a.a(view, lVar, 2);
        }
    }

    /* loaded from: classes3.dex */
    public class b implements d.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public b(i iVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {iVar};
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
        public void a(c.a.q0.s.q.a aVar, View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLL(1048576, this, aVar, view) == null) || view == null || aVar == null || view.getId() == -1) {
                return;
            }
            int id = view.getId();
            if (id == R.id.user_name || id == R.id.user_avatar) {
                c.a.r0.p2.a.a(view, aVar, 1);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class c implements w {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ i f23301e;

        public c(i iVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {iVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f23301e = iVar;
        }

        @Override // c.a.e.l.e.w
        public void b(View view, n nVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i2, long j2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{view, nVar, bdUniqueId, viewGroup, Integer.valueOf(i2), Long.valueOf(j2)}) == null) && (nVar instanceof l) && (view.getTag() instanceof ThreadCardViewHolder)) {
                ThreadCardViewHolder threadCardViewHolder = (ThreadCardViewHolder) view.getTag();
                l lVar = (l) nVar;
                lVar.k = 1;
                if (this.f23301e.s != null) {
                    this.f23301e.s.a(threadCardViewHolder.getView(), lVar);
                }
                ThreadCardUtils.jumpToPB((c.a.q0.s.q.a) lVar, view.getContext(), 4, false, c.a.l.e.a((s) viewGroup, view, i2));
                threadCardViewHolder.getCardView().o(new a.C0095a(1));
            }
        }
    }

    /* loaded from: classes3.dex */
    public class d implements ThreadCommentAndPraiseInfoLayout.i {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ ViewGroup f23302a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ View f23303b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ int f23304c;

        public d(i iVar, ViewGroup viewGroup, View view, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {iVar, viewGroup, view, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f23302a = viewGroup;
            this.f23303b = view;
            this.f23304c = i2;
        }

        @Override // com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout.i
        public void a(IntentConfig intentConfig) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, intentConfig) == null) && (intentConfig instanceof PbActivityConfig)) {
                ((PbActivityConfig) intentConfig).setVideoOriginArea(c.a.l.e.a((s) this.f23302a, this.f23303b, this.f23304c));
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public i(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
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
        this.p = 0;
        this.q = 0;
        this.s = new a(this);
        this.n = tbPageContext;
        i0();
    }

    @Override // c.a.r0.p.f
    public void g(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
            this.o = str;
        }
    }

    public final void i0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            k.r0 = "c13542";
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.a.e.l.e.a
    /* renamed from: j0 */
    public AutoVideoCardViewHolder<l> U(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, viewGroup)) == null) {
            l0.b bVar = new l0.b(this.n.getPageActivity());
            c.a.l.d dVar = new c.a.l.d(this.n.getPageActivity());
            dVar.s(this.m);
            dVar.b(1024);
            dVar.b(32768);
            int i2 = this.p;
            if (i2 > 0) {
                dVar.a(i2);
            }
            dVar.q(false);
            dVar.v(false);
            dVar.r(new b(this));
            bVar.o(dVar);
            m mVar = new m(this.n.getPageActivity());
            mVar.w(this.m);
            mVar.t("profile");
            mVar.x(null);
            bVar.n(mVar);
            bVar.l().g(c.a.e.e.p.l.g(this.f2958e, R.dimen.tbds25));
            c.a.l.s sVar = new c.a.l.s(this.n.getPageActivity());
            sVar.v(true);
            bVar.h(sVar);
            bVar.h(new h0(this.n.getPageActivity()));
            bVar.h(new a0(this.n.getPageActivity()));
            bVar.h(new c.a.l.k(this.n.getPageActivity()));
            n0 n0Var = new n0(this.n.getPageActivity());
            c.a.q0.s.q.f fVar = new c.a.q0.s.q.f();
            fVar.f14190b = 3;
            fVar.f14196h = 3;
            n0Var.u(fVar);
            n0Var.v(8);
            n0Var.A("personalize_page");
            n0Var.z(6);
            n0Var.w(4);
            bVar.m(n0Var);
            l0 i3 = bVar.i();
            AutoVideoCardViewHolder<l> autoVideoCardViewHolder = new AutoVideoCardViewHolder<>(i3);
            autoVideoCardViewHolder.setPageId(this.m);
            i3.p(this.s);
            i3.r(4);
            autoVideoCardViewHolder.showPrivateDecorItem(this.q);
            d0(new c(this));
            return autoVideoCardViewHolder;
        }
        return (AutoVideoCardViewHolder) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.a.e.l.e.a
    /* renamed from: k0 */
    public View a0(int i2, View view, ViewGroup viewGroup, l lVar, AutoVideoCardViewHolder autoVideoCardViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048581, this, new Object[]{Integer.valueOf(i2), view, viewGroup, lVar, autoVideoCardViewHolder})) == null) {
            if (lVar == null) {
                return autoVideoCardViewHolder.getView();
            }
            if (autoVideoCardViewHolder == null) {
                return null;
            }
            lVar.K(lVar.position + 1);
            if (autoVideoCardViewHolder.getCardView() != null) {
                autoVideoCardViewHolder.getCardView().setPage(this.o);
            }
            if (!this.r) {
                autoVideoCardViewHolder.showThemeAndStarDecorItem();
            }
            if (autoVideoCardViewHolder.getCardView().e() instanceof n0) {
                ((n0) autoVideoCardViewHolder.getCardView().e()).y(new d(this, viewGroup, view, i2));
            }
            autoVideoCardViewHolder.onBindDataToView(lVar);
            autoVideoCardViewHolder.getCardView().onChangeSkinType(this.n, TbadkCoreApplication.getInst().getSkinType());
            autoVideoCardViewHolder.getCardView().p(this.s);
            c.a.r0.p2.a.b(lVar);
            return autoVideoCardViewHolder.getView();
        }
        return (View) invokeCommon.objValue;
    }

    public void l0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048582, this, z) == null) {
            this.r = z;
        }
    }

    public void m0(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048583, this, i2) == null) {
            this.q = i2;
        }
    }

    public void n0(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2) == null) {
        }
    }

    public void o0(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048585, this, i2) == null) {
            this.p = i2;
        }
    }
}
