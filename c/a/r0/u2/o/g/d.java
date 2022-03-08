package c.a.r0.u2.o.g;

import android.view.View;
import androidx.core.view.InputDeviceCompat;
import c.a.q0.c1.k0;
import c.a.q0.c1.s;
import c.a.q0.r.r.e2;
import c.a.r0.j3.u;
import c.a.r0.u2.h.k;
import c.a.r0.u2.h.n;
import c.a.r0.u2.h.q;
import c.a.r0.u2.h.r;
import c.a.r0.u2.h.y;
import c.a.r0.u2.k.f.b0;
import c.a.r0.u2.k.f.c0;
import c.a.r0.u2.k.f.j0;
import c.a.r0.u2.k.f.l;
import c.a.r0.u2.k.f.m;
import c.a.r0.u2.k.f.n0;
import c.a.r0.u2.k.f.z;
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
import com.baidu.tieba.R;
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
/* loaded from: classes2.dex */
public class d extends c.a.r0.u2.o.g.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public PbFirstFloorItemAdapter A;
    public c.a.d.o.e.a B;
    public c.a.d.o.e.a C;
    public View.OnClickListener D;
    public m m;
    public h n;
    public PbFirstFloorCommentAndPraiseAdapter o;
    public e p;
    public PbFirstFloorEnterForumAdapter q;
    public n0 r;
    public PbReplyLoadMoreAdapter s;
    public j0 t;
    public b0 u;
    public c0 v;
    public l w;
    public c.a.r0.u2.k.f.j x;
    public z y;
    public g z;

    /* loaded from: classes2.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d f23995e;

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
            this.f23995e = dVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                if (view.getId() == R.id.qq_share_container) {
                    if (this.f23995e.J(11009)) {
                        this.f23995e.L(8);
                    }
                } else if (view.getId() == R.id.share_num_container && this.f23995e.J(11009)) {
                    this.f23995e.L(3);
                }
            }
        }
    }

    /* loaded from: classes2.dex */
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
        @Override // c.a.q0.c1.k0
        /* renamed from: a */
        public ShareItem doInBackground() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return c.a.r0.u2.k.f.h1.b.d(this.a.K(), ShareSwitch.isOn() ? 1 : 6, this.a.f23973b.getPbModel());
            }
            return (ShareItem) invokeV.objValue;
        }
    }

    /* loaded from: classes2.dex */
    public class c implements s<ShareItem> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ int a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ d f23996b;

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
            this.f23996b = dVar;
            this.a = i2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.q0.c1.s
        /* renamed from: a */
        public void onReturnDataInUI(ShareItem shareItem) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, shareItem) == null) {
                MessageManager.getInstance().sendMessage(new ImplicitShareMessage(this.f23996b.f23973b.getContext(), this.a, shareItem, false));
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

    @Override // c.a.r0.u2.o.g.a
    public void A(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, onClickListener) == null) {
            this.v.d0(onClickListener);
        }
    }

    @Override // c.a.r0.u2.o.g.a
    public void B(c.a.r0.u2.h.f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, fVar) == null) {
            this.r.t(fVar);
        }
    }

    @Override // c.a.r0.u2.o.g.a
    public void C(c.a.r0.u2.i.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, cVar) == null) {
            super.C(cVar);
            this.m.P0(cVar);
        }
    }

    @Override // c.a.r0.u2.o.g.a
    public void D(c.a.r0.u2.h.f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, fVar) == null) {
            this.n.A0(fVar);
        }
    }

    @Override // c.a.r0.u2.o.g.a
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
                TbadkCoreApplication.getInst().login(this.f23973b.getPageContext(), new CustomMessage<>(2002001, new LoginActivityConfig(this.f23973b.getPbActivity(), true, i2)));
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
            c.a.r0.u2.h.f fVar = this.f23975d;
            if (fVar == null || fVar.O() == null) {
                return -1;
            }
            return this.f23975d.O().w();
        }
        return invokeV.intValue;
    }

    public final void L(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048583, this, i2) == null) {
            c.a.q0.c1.n0.b(new b(this), new c(this, i2));
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
            AbsVideoPbFragment videoPbFragment = this.f23973b.getVideoPbFragment();
            this.n = new h(videoPbFragment, videoPbFragment, PostData.z0);
            PbFirstFloorCommentAndPraiseAdapter pbFirstFloorCommentAndPraiseAdapter = new PbFirstFloorCommentAndPraiseAdapter(this.f23973b.getVideoPbFragment(), r.f23134j);
            this.o = pbFirstFloorCommentAndPraiseAdapter;
            pbFirstFloorCommentAndPraiseAdapter.n0(this.D);
            this.p = new e(this.f23973b.getContext(), y.f23159f);
            this.q = new PbFirstFloorEnterForumAdapter(this.f23973b, c.a.r0.u2.h.h.m);
            this.r = new n0(this.f23973b.getVideoPbFragment(), q.l);
            this.u = new b0(this.f23973b.getVideoPbFragment(), k.f23111g, this.f23973b.getUniqueId());
            this.v = new c0(this.f23973b.getVideoPbFragment(), c.a.r0.u2.h.l.f23114e);
            this.t = new j0(this.f23973b.getVideoPbFragment(), n.O0);
            this.w = new l(this.f23973b.getVideoPbFragment(), c.a.r0.u2.h.e.f23089g);
            c.a.r0.u2.k.f.j jVar = new c.a.r0.u2.k.f.j(this.f23973b.getVideoPbFragment(), c.a.q0.r.r.q.k4);
            this.x = jVar;
            jVar.g0(true);
            this.y = new z(this.f23973b.getVideoPbFragment());
            m mVar = new m(this.f23973b.getVideoPbFragment(), PostData.A0);
            this.m = mVar;
            mVar.Q0(this.f23973b.getVideoPbFragment());
            this.s = new PbReplyLoadMoreAdapter(this.f23973b.getVideoPbFragment(), PostData.G0);
            this.B = c.a.r0.j3.z.q().a(this.f23973b.getVideoPbFragment().getBaseFragmentActivity(), AdvertAppInfo.C4);
            this.C = c.a.r0.j3.z.q().a(this.f23973b.getVideoPbFragment().getBaseFragmentActivity(), AdvertAppInfo.E4);
            g gVar = new g(this.f23973b.getPageContext(), e2.B3, this.f23973b.getUniqueId());
            this.z = gVar;
            gVar.b0(this.f23974c);
            this.A = new PbFirstFloorItemAdapter(this.f23973b.getContext(), c.a.r0.u2.h.i.f23107g);
            this.f23976e.add(this.n);
            this.f23976e.add(this.o);
            this.f23976e.add(this.p);
            this.f23976e.add(this.q);
            this.f23976e.add(this.r);
            this.f23976e.add(this.t);
            this.f23976e.add(this.u);
            this.f23976e.add(this.v);
            this.f23976e.add(this.w);
            this.f23976e.add(this.x);
            this.f23976e.add(this.y);
            this.f23976e.add(this.B);
            this.f23976e.add(this.C);
            this.f23976e.add(this.m);
            this.f23976e.add(this.s);
            this.f23976e.add(this.z);
            this.f23976e.add(this.A);
            this.f23976e.add(new PbPrivateTitleAdapter(this.f23973b.getVideoPbFragment()));
            this.f23974c.addAdapters(this.f23976e);
        }
    }

    @Override // c.a.r0.u2.o.g.a
    public n0 e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.r : (n0) invokeV.objValue;
    }

    @Override // c.a.r0.u2.o.g.a
    public m f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.m : (m) invokeV.objValue;
    }

    @Override // c.a.r0.u2.o.g.a
    public PbFirstFloorCommentAndPraiseAdapter g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.o : (PbFirstFloorCommentAndPraiseAdapter) invokeV.objValue;
    }

    @Override // c.a.r0.u2.o.g.a
    public void l() {
        h hVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048588, this) == null) || (hVar = this.n) == null) {
            return;
        }
        hVar.H();
    }

    @Override // c.a.r0.u2.o.g.a
    public void m() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            n0 n0Var = this.r;
            if (n0Var != null) {
                n0Var.onDestroy();
            }
            PbFirstFloorCommentAndPraiseAdapter pbFirstFloorCommentAndPraiseAdapter = this.o;
            if (pbFirstFloorCommentAndPraiseAdapter != null) {
                pbFirstFloorCommentAndPraiseAdapter.onDestroy();
            }
        }
    }

    @Override // c.a.r0.u2.o.g.a
    public void o(boolean z) {
        c.a.d.o.e.a aVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048590, this, z) == null) && (aVar = this.C) != null && (aVar instanceof u)) {
            ((u) aVar).k(z);
        }
    }

    @Override // c.a.r0.u2.o.g.a
    public void p(c.a.r0.u2.h.f fVar, boolean z, String str, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048591, this, new Object[]{fVar, Boolean.valueOf(z), str, Boolean.valueOf(z2)}) == null) {
            this.m.t(fVar);
            this.m.setFromCDN(z);
            this.m.q(str);
            this.m.c(z2);
        }
    }

    @Override // c.a.r0.u2.o.g.a
    public void u(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, onClickListener) == null) {
            super.u(onClickListener);
            this.m.m(onClickListener);
        }
    }

    @Override // c.a.r0.u2.o.g.a
    public void v(TbRichTextView.y yVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, yVar) == null) {
            super.v(yVar);
            this.m.p(yVar);
        }
    }

    @Override // c.a.r0.u2.o.g.a
    public void w(View.OnLongClickListener onLongClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, onLongClickListener) == null) {
            super.w(onLongClickListener);
            this.m.d(onLongClickListener);
        }
    }

    @Override // c.a.r0.u2.o.g.a
    public void x(SortSwitchButton.f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, fVar) == null) {
            super.x(fVar);
            this.r.f0(fVar);
        }
    }

    @Override // c.a.r0.u2.o.g.a
    public void y(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048596, this, onClickListener) == null) {
            super.y(onClickListener);
            this.m.e(onClickListener);
            this.r.e(onClickListener);
            this.s.d0(onClickListener);
        }
    }

    @Override // c.a.r0.u2.o.g.a
    public void z(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048597, this, onClickListener) == null) {
            this.u.d0(onClickListener);
        }
    }
}
