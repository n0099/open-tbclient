package c.a.s0.s2.y.f;

import android.view.View;
import androidx.core.view.InputDeviceCompat;
import c.a.r0.d1.k0;
import c.a.r0.d1.n0;
import c.a.r0.d1.s;
import c.a.r0.s.r.d2;
import c.a.s0.j3.t;
import c.a.s0.s2.r.n;
import c.a.s0.s2.r.q;
import c.a.s0.s2.r.r;
import c.a.s0.s2.u.f.a0;
import c.a.s0.s2.u.f.b0;
import c.a.s0.s2.u.f.i0;
import c.a.s0.s2.u.f.k;
import c.a.s0.s2.u.f.l;
import c.a.s0.s2.u.f.m0;
import c.a.s0.s2.u.f.y;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.LoginActivityConfig;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.coreExtra.share.ShareItem;
import com.baidu.tbadk.switchs.ShareSwitch;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.pb.pb.adapter.PbReplyLoadMoreAdapter;
import com.baidu.tieba.pb.pb.main.PbPrivateTitleAdapter;
import com.baidu.tieba.pb.pb.main.adapter.PbFirstFloorCommentAndPraiseAdapter;
import com.baidu.tieba.pb.pb.main.adapter.PbFirstFloorEnterForumAdapter;
import com.baidu.tieba.pb.pb.main.adapter.PbFirstFloorItemAdapter;
import com.baidu.tieba.pb.videopb.AbsVideoPbFragment;
import com.baidu.tieba.pb.videopb.fragment.DetailInfoAndReplyFragment;
import com.baidu.tieba.share.ImplicitShareMessage;
import com.baidu.tieba.tbadkCore.data.PostData;
import com.baidu.tieba.view.SortSwitchButton;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes8.dex */
public class d extends c.a.s0.s2.y.f.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public PbFirstFloorItemAdapter A;
    public c.a.d.m.e.a B;
    public c.a.d.m.e.a C;
    public View.OnClickListener D;
    public l m;
    public h n;
    public PbFirstFloorCommentAndPraiseAdapter o;
    public e p;
    public PbFirstFloorEnterForumAdapter q;
    public m0 r;
    public PbReplyLoadMoreAdapter s;
    public i0 t;
    public a0 u;
    public b0 v;
    public k w;
    public c.a.s0.s2.u.f.i x;
    public y y;
    public g z;

    /* loaded from: classes8.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d f23458e;

        public a(d dVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f23458e = dVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                if (view.getId() == c.a.s0.s2.i.qq_share_container) {
                    if (this.f23458e.J(11009)) {
                        this.f23458e.L(8);
                    }
                } else if (view.getId() == c.a.s0.s2.i.share_num_container && this.f23458e.J(11009)) {
                    this.f23458e.L(3);
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public class b extends k0<ShareItem> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ d a;

        public b(d dVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = dVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.r0.d1.k0
        /* renamed from: a */
        public ShareItem doInBackground() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return c.a.s0.s2.u.f.g1.b.d(this.a.K(), ShareSwitch.isOn() ? 1 : 6, this.a.f23434b.getPbModel());
            }
            return (ShareItem) invokeV.objValue;
        }
    }

    /* loaded from: classes8.dex */
    public class c implements s<ShareItem> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ int a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ d f23459b;

        public c(d dVar, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f23459b = dVar;
            this.a = i2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.r0.d1.s
        /* renamed from: a */
        public void onReturnDataInUI(ShareItem shareItem) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, shareItem) == null) {
                MessageManager.getInstance().sendMessage(new ImplicitShareMessage(this.f23459b.f23434b.getContext(), this.a, shareItem, false));
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d(DetailInfoAndReplyFragment detailInfoAndReplyFragment, BdTypeRecyclerView bdTypeRecyclerView) {
        super(detailInfoAndReplyFragment, bdTypeRecyclerView);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {detailInfoAndReplyFragment, bdTypeRecyclerView};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((DetailInfoAndReplyFragment) objArr2[0], (BdTypeRecyclerView) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.D = new a(this);
        M();
    }

    @Override // c.a.s0.s2.y.f.a
    public void A(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, onClickListener) == null) {
            this.v.k0(onClickListener);
        }
    }

    @Override // c.a.s0.s2.y.f.a
    public void B(c.a.s0.s2.r.f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, fVar) == null) {
            this.r.t(fVar);
        }
    }

    @Override // c.a.s0.s2.y.f.a
    public void C(c.a.s0.s2.s.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, cVar) == null) {
            super.C(cVar);
            this.m.W0(cVar);
        }
    }

    @Override // c.a.s0.s2.y.f.a
    public void D(c.a.s0.s2.r.f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, fVar) == null) {
            this.n.H0(fVar);
        }
    }

    @Override // c.a.s0.s2.y.f.a
    public void E(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, str) == null) {
            this.n.q(str);
        }
    }

    public final boolean J(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048581, this, i2)) == null) {
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (currentAccount == null || currentAccount.length() <= 0) {
                TbadkCoreApplication.getInst().login(this.f23434b.getPageContext(), new CustomMessage<>(2002001, new LoginActivityConfig(this.f23434b.getPbActivity(), true, i2)));
                return false;
            }
            return true;
        }
        return invokeI.booleanValue;
    }

    public final int K() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            c.a.s0.s2.r.f fVar = this.f23436d;
            if (fVar == null || fVar.O() == null) {
                return -1;
            }
            return this.f23436d.O().w();
        }
        return invokeV.intValue;
    }

    public final void L(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048583, this, i2) == null) {
            n0.b(new b(this), new c(this, i2));
            StatisticItem statisticItem = new StatisticItem("c13833");
            statisticItem.param("obj_locate", 1);
            if (i2 == 3) {
                statisticItem.param("obj_type", 1);
            } else if (i2 == 8) {
                statisticItem.param("obj_type", 2);
            }
            TiebaStatic.log(statisticItem);
        }
    }

    public final void M() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            AbsVideoPbFragment videoPbFragment = this.f23434b.getVideoPbFragment();
            this.n = new h(videoPbFragment, videoPbFragment, PostData.y0);
            PbFirstFloorCommentAndPraiseAdapter pbFirstFloorCommentAndPraiseAdapter = new PbFirstFloorCommentAndPraiseAdapter(this.f23434b.getVideoPbFragment(), r.f22567j);
            this.o = pbFirstFloorCommentAndPraiseAdapter;
            pbFirstFloorCommentAndPraiseAdapter.u0(this.D);
            this.p = new e(this.f23434b.getContext(), c.a.s0.s2.r.y.f22593f);
            this.q = new PbFirstFloorEnterForumAdapter(this.f23434b, c.a.s0.s2.r.h.m);
            this.r = new m0(this.f23434b.getVideoPbFragment(), q.l);
            this.u = new a0(this.f23434b.getVideoPbFragment(), c.a.s0.s2.r.k.f22543g, this.f23434b.getUniqueId());
            this.v = new b0(this.f23434b.getVideoPbFragment(), c.a.s0.s2.r.l.f22546e);
            this.t = new i0(this.f23434b.getVideoPbFragment(), n.N0);
            this.w = new k(this.f23434b.getVideoPbFragment(), c.a.s0.s2.r.e.f22519g);
            c.a.s0.s2.u.f.i iVar = new c.a.s0.s2.u.f.i(this.f23434b.getVideoPbFragment(), c.a.r0.s.r.q.h4);
            this.x = iVar;
            iVar.n0(true);
            this.y = new y(this.f23434b.getVideoPbFragment());
            l lVar = new l(this.f23434b.getVideoPbFragment(), PostData.z0);
            this.m = lVar;
            lVar.X0(this.f23434b.getVideoPbFragment());
            this.s = new PbReplyLoadMoreAdapter(this.f23434b.getVideoPbFragment(), PostData.F0);
            this.B = c.a.s0.j3.y.q().a(this.f23434b.getVideoPbFragment().getBaseFragmentActivity(), AdvertAppInfo.z4);
            this.C = c.a.s0.j3.y.q().a(this.f23434b.getVideoPbFragment().getBaseFragmentActivity(), AdvertAppInfo.B4);
            g gVar = new g(this.f23434b.getPageContext(), d2.y3, this.f23434b.getUniqueId());
            this.z = gVar;
            gVar.i0(this.f23435c);
            this.A = new PbFirstFloorItemAdapter(this.f23434b.getContext(), c.a.s0.s2.r.i.f22539g);
            this.f23437e.add(this.n);
            this.f23437e.add(this.o);
            this.f23437e.add(this.p);
            this.f23437e.add(this.q);
            this.f23437e.add(this.r);
            this.f23437e.add(this.t);
            this.f23437e.add(this.u);
            this.f23437e.add(this.v);
            this.f23437e.add(this.w);
            this.f23437e.add(this.x);
            this.f23437e.add(this.y);
            this.f23437e.add(this.B);
            this.f23437e.add(this.C);
            this.f23437e.add(this.m);
            this.f23437e.add(this.s);
            this.f23437e.add(this.z);
            this.f23437e.add(this.A);
            this.f23437e.add(new PbPrivateTitleAdapter(this.f23434b.getVideoPbFragment()));
            this.f23435c.addAdapters(this.f23437e);
        }
    }

    @Override // c.a.s0.s2.y.f.a
    public m0 e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.r : (m0) invokeV.objValue;
    }

    @Override // c.a.s0.s2.y.f.a
    public l f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.m : (l) invokeV.objValue;
    }

    @Override // c.a.s0.s2.y.f.a
    public PbFirstFloorCommentAndPraiseAdapter g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.o : (PbFirstFloorCommentAndPraiseAdapter) invokeV.objValue;
    }

    @Override // c.a.s0.s2.y.f.a
    public void l() {
        h hVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048588, this) == null) || (hVar = this.n) == null) {
            return;
        }
        hVar.K();
    }

    @Override // c.a.s0.s2.y.f.a
    public void m() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            m0 m0Var = this.r;
            if (m0Var != null) {
                m0Var.onDestroy();
            }
            PbFirstFloorCommentAndPraiseAdapter pbFirstFloorCommentAndPraiseAdapter = this.o;
            if (pbFirstFloorCommentAndPraiseAdapter != null) {
                pbFirstFloorCommentAndPraiseAdapter.onDestroy();
            }
        }
    }

    @Override // c.a.s0.s2.y.f.a
    public void o(boolean z) {
        c.a.d.m.e.a aVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048590, this, z) == null) && (aVar = this.C) != null && (aVar instanceof t)) {
            ((t) aVar).k(z);
        }
    }

    @Override // c.a.s0.s2.y.f.a
    public void p(c.a.s0.s2.r.f fVar, boolean z, String str, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048591, this, new Object[]{fVar, Boolean.valueOf(z), str, Boolean.valueOf(z2)}) == null) {
            this.m.t(fVar);
            this.m.setFromCDN(z);
            this.m.q(str);
            this.m.c(z2);
        }
    }

    @Override // c.a.s0.s2.y.f.a
    public void u(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, onClickListener) == null) {
            super.u(onClickListener);
            this.m.m(onClickListener);
        }
    }

    @Override // c.a.s0.s2.y.f.a
    public void v(TbRichTextView.y yVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, yVar) == null) {
            super.v(yVar);
            this.m.p(yVar);
        }
    }

    @Override // c.a.s0.s2.y.f.a
    public void w(View.OnLongClickListener onLongClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, onLongClickListener) == null) {
            super.w(onLongClickListener);
            this.m.d(onLongClickListener);
        }
    }

    @Override // c.a.s0.s2.y.f.a
    public void x(SortSwitchButton.f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, fVar) == null) {
            super.x(fVar);
            this.r.m0(fVar);
        }
    }

    @Override // c.a.s0.s2.y.f.a
    public void y(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048596, this, onClickListener) == null) {
            super.y(onClickListener);
            this.m.e(onClickListener);
            this.r.e(onClickListener);
            this.s.k0(onClickListener);
        }
    }

    @Override // c.a.s0.s2.y.f.a
    public void z(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048597, this, onClickListener) == null) {
            this.u.k0(onClickListener);
        }
    }
}
