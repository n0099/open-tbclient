package b.a.r0.k2.y.f;

import android.view.View;
import androidx.core.view.InputDeviceCompat;
import b.a.q0.d1.i0;
import b.a.q0.d1.q;
import b.a.q0.s.q.d2;
import b.a.r0.k2.r.m;
import b.a.r0.k2.r.p;
import b.a.r0.k2.r.x;
import b.a.r0.k2.u.f.a0;
import b.a.r0.k2.u.f.h0;
import b.a.r0.k2.u.f.k;
import b.a.r0.k2.u.f.l;
import b.a.r0.k2.u.f.l0;
import b.a.r0.k2.u.f.y;
import b.a.r0.z2.t;
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
/* loaded from: classes5.dex */
public class d extends b.a.r0.k2.y.f.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public b.a.e.l.e.a A;
    public b.a.e.l.e.a B;
    public View.OnClickListener C;
    public l m;
    public h n;
    public PbFirstFloorCommentAndPraiseAdapter o;
    public e p;
    public PbFirstFloorEnterForumAdapter q;
    public l0 r;
    public PbReplyLoadMoreAdapter s;
    public h0 t;
    public a0 u;
    public k v;
    public b.a.r0.k2.u.f.i w;
    public y x;
    public g y;
    public PbFirstFloorItemAdapter z;

    /* loaded from: classes5.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d f19784e;

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
            this.f19784e = dVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                if (view.getId() == b.a.r0.k2.i.qq_share_container) {
                    if (this.f19784e.I(11009)) {
                        this.f19784e.K(8);
                    }
                } else if (view.getId() == b.a.r0.k2.i.share_num_container && this.f19784e.I(11009)) {
                    this.f19784e.K(3);
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b extends i0<ShareItem> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d f19785a;

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
            this.f19785a = dVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // b.a.q0.d1.i0
        /* renamed from: a */
        public ShareItem doInBackground() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return b.a.r0.k2.u.f.f1.b.d(this.f19785a.f19760b.getContext(), this.f19785a.J(), ShareSwitch.isOn() ? 1 : 6, this.f19785a.f19760b.getPbModel());
            }
            return (ShareItem) invokeV.objValue;
        }
    }

    /* loaded from: classes5.dex */
    public class c implements q<ShareItem> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ int f19786a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ d f19787b;

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
            this.f19787b = dVar;
            this.f19786a = i2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // b.a.q0.d1.q
        /* renamed from: a */
        public void onReturnDataInUI(ShareItem shareItem) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, shareItem) == null) {
                MessageManager.getInstance().sendMessage(new ImplicitShareMessage(this.f19787b.f19760b.getContext(), this.f19786a, shareItem, false));
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
        this.C = new a(this);
        L();
    }

    @Override // b.a.r0.k2.y.f.a
    public void A(b.a.r0.k2.r.f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, fVar) == null) {
            this.r.t(fVar);
        }
    }

    @Override // b.a.r0.k2.y.f.a
    public void B(b.a.r0.k2.s.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, cVar) == null) {
            super.B(cVar);
            this.m.W0(cVar);
        }
    }

    @Override // b.a.r0.k2.y.f.a
    public void C(b.a.r0.k2.r.f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, fVar) == null) {
            this.n.H0(fVar);
        }
    }

    @Override // b.a.r0.k2.y.f.a
    public void D(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, str) == null) {
            this.n.q(str);
        }
    }

    public final boolean I(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048580, this, i2)) == null) {
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (currentAccount == null || currentAccount.length() <= 0) {
                TbadkCoreApplication.getInst().login(this.f19760b.getPageContext(), new CustomMessage<>(2002001, new LoginActivityConfig(this.f19760b.getPbActivity(), true, i2)));
                return false;
            }
            return true;
        }
        return invokeI.booleanValue;
    }

    public final int J() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            b.a.r0.k2.r.f fVar = this.f19762d;
            if (fVar == null || fVar.O() == null) {
                return -1;
            }
            return this.f19762d.O().w();
        }
        return invokeV.intValue;
    }

    public final void K(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048582, this, i2) == null) {
            b.a.q0.d1.l0.b(new b(this), new c(this, i2));
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

    public final void L() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            AbsVideoPbFragment videoPbFragment = this.f19760b.getVideoPbFragment();
            this.n = new h(videoPbFragment, videoPbFragment, PostData.x0);
            PbFirstFloorCommentAndPraiseAdapter pbFirstFloorCommentAndPraiseAdapter = new PbFirstFloorCommentAndPraiseAdapter(this.f19760b.getVideoPbFragment(), b.a.r0.k2.r.q.j);
            this.o = pbFirstFloorCommentAndPraiseAdapter;
            pbFirstFloorCommentAndPraiseAdapter.u0(this.C);
            this.p = new e(this.f19760b.getContext(), x.f18826f);
            this.q = new PbFirstFloorEnterForumAdapter(this.f19760b, b.a.r0.k2.r.h.m);
            this.r = new l0(this.f19760b.getVideoPbFragment(), p.l);
            this.u = new a0(this.f19760b.getVideoPbFragment(), b.a.r0.k2.r.k.f18776g, this.f19760b.getUniqueId());
            this.t = new h0(this.f19760b.getVideoPbFragment(), m.M0);
            this.v = new k(this.f19760b.getVideoPbFragment(), b.a.r0.k2.r.e.f18754g);
            b.a.r0.k2.u.f.i iVar = new b.a.r0.k2.u.f.i(this.f19760b.getVideoPbFragment(), b.a.q0.s.q.q.b4);
            this.w = iVar;
            iVar.n0(true);
            this.x = new y(this.f19760b.getVideoPbFragment());
            l lVar = new l(this.f19760b.getVideoPbFragment(), PostData.y0);
            this.m = lVar;
            lVar.X0(this.f19760b.getVideoPbFragment());
            this.s = new PbReplyLoadMoreAdapter(this.f19760b.getVideoPbFragment(), PostData.E0);
            this.A = b.a.r0.z2.y.o().a(this.f19760b.getVideoPbFragment().getBaseFragmentActivity(), AdvertAppInfo.s4);
            this.B = b.a.r0.z2.y.o().a(this.f19760b.getVideoPbFragment().getBaseFragmentActivity(), AdvertAppInfo.u4);
            g gVar = new g(this.f19760b.getPageContext(), d2.r3, this.f19760b.getUniqueId());
            this.y = gVar;
            gVar.i0(this.f19761c);
            this.z = new PbFirstFloorItemAdapter(this.f19760b.getContext(), b.a.r0.k2.r.i.f18771g);
            this.f19763e.add(this.n);
            this.f19763e.add(this.o);
            this.f19763e.add(this.p);
            this.f19763e.add(this.q);
            this.f19763e.add(this.r);
            this.f19763e.add(this.t);
            this.f19763e.add(this.u);
            this.f19763e.add(this.v);
            this.f19763e.add(this.w);
            this.f19763e.add(this.x);
            this.f19763e.add(this.A);
            this.f19763e.add(this.B);
            this.f19763e.add(this.m);
            this.f19763e.add(this.s);
            this.f19763e.add(this.y);
            this.f19763e.add(this.z);
            this.f19763e.add(new PbPrivateTitleAdapter(this.f19760b.getVideoPbFragment()));
            this.f19761c.addAdapters(this.f19763e);
        }
    }

    @Override // b.a.r0.k2.y.f.a
    public l0 e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.r : (l0) invokeV.objValue;
    }

    @Override // b.a.r0.k2.y.f.a
    public l f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.m : (l) invokeV.objValue;
    }

    @Override // b.a.r0.k2.y.f.a
    public PbFirstFloorCommentAndPraiseAdapter g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.o : (PbFirstFloorCommentAndPraiseAdapter) invokeV.objValue;
    }

    @Override // b.a.r0.k2.y.f.a
    public void l() {
        h hVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048587, this) == null) || (hVar = this.n) == null) {
            return;
        }
        hVar.O();
    }

    @Override // b.a.r0.k2.y.f.a
    public void m() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            l0 l0Var = this.r;
            if (l0Var != null) {
                l0Var.onDestroy();
            }
            PbFirstFloorCommentAndPraiseAdapter pbFirstFloorCommentAndPraiseAdapter = this.o;
            if (pbFirstFloorCommentAndPraiseAdapter != null) {
                pbFirstFloorCommentAndPraiseAdapter.onDestroy();
            }
        }
    }

    @Override // b.a.r0.k2.y.f.a
    public void o(boolean z) {
        b.a.e.l.e.a aVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048589, this, z) == null) && (aVar = this.B) != null && (aVar instanceof t)) {
            ((t) aVar).k(z);
        }
    }

    @Override // b.a.r0.k2.y.f.a
    public void p(b.a.r0.k2.r.f fVar, boolean z, String str, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048590, this, new Object[]{fVar, Boolean.valueOf(z), str, Boolean.valueOf(z2)}) == null) {
            this.m.t(fVar);
            this.m.setFromCDN(z);
            this.m.q(str);
            this.m.c(z2);
        }
    }

    @Override // b.a.r0.k2.y.f.a
    public void u(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, onClickListener) == null) {
            super.u(onClickListener);
            this.m.m(onClickListener);
        }
    }

    @Override // b.a.r0.k2.y.f.a
    public void v(TbRichTextView.z zVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, zVar) == null) {
            super.v(zVar);
            this.m.p(zVar);
        }
    }

    @Override // b.a.r0.k2.y.f.a
    public void w(View.OnLongClickListener onLongClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, onLongClickListener) == null) {
            super.w(onLongClickListener);
            this.m.d(onLongClickListener);
        }
    }

    @Override // b.a.r0.k2.y.f.a
    public void x(SortSwitchButton.f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, fVar) == null) {
            super.x(fVar);
            this.r.m0(fVar);
        }
    }

    @Override // b.a.r0.k2.y.f.a
    public void y(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, onClickListener) == null) {
            super.y(onClickListener);
            this.m.e(onClickListener);
            this.r.e(onClickListener);
            this.s.k0(onClickListener);
        }
    }

    @Override // b.a.r0.k2.y.f.a
    public void z(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048596, this, onClickListener) == null) {
            this.u.k0(onClickListener);
        }
    }
}
