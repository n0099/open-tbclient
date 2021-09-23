package c.a.r0.j2.o.f;

import android.view.View;
import androidx.core.view.InputDeviceCompat;
import c.a.q0.d1.j0;
import c.a.q0.d1.m0;
import c.a.q0.d1.r;
import c.a.q0.s.q.d2;
import c.a.q0.s.q.q;
import c.a.r0.j2.h.o;
import c.a.r0.j2.h.p;
import c.a.r0.j2.h.w;
import c.a.r0.j2.k.e.a0;
import c.a.r0.j2.k.e.h0;
import c.a.r0.j2.k.e.k;
import c.a.r0.j2.k.e.l;
import c.a.r0.j2.k.e.l0;
import c.a.r0.j2.k.e.y;
import c.a.r0.y2.t;
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
/* loaded from: classes3.dex */
public class d extends c.a.r0.j2.o.f.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public c.a.e.l.e.a A;
    public c.a.e.l.e.a B;
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
    public c.a.r0.j2.k.e.i w;
    public y x;
    public g y;
    public PbFirstFloorItemAdapter z;

    /* loaded from: classes3.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d f20631e;

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
            this.f20631e = dVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                if (view.getId() == R.id.qq_share_container) {
                    if (this.f20631e.I(11009)) {
                        this.f20631e.K(8);
                    }
                } else if (view.getId() == R.id.share_num_container && this.f20631e.I(11009)) {
                    this.f20631e.K(3);
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b extends j0<ShareItem> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d f20632a;

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
            this.f20632a = dVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.q0.d1.j0
        /* renamed from: a */
        public ShareItem doInBackground() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return c.a.r0.j2.k.e.f1.b.d(this.f20632a.f20605b.getContext(), this.f20632a.J(), ShareSwitch.isOn() ? 1 : 6, this.f20632a.f20605b.getPbModel());
            }
            return (ShareItem) invokeV.objValue;
        }
    }

    /* loaded from: classes3.dex */
    public class c implements r<ShareItem> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ int f20633a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ d f20634b;

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
            this.f20634b = dVar;
            this.f20633a = i2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.q0.d1.r
        /* renamed from: a */
        public void onReturnDataInUI(ShareItem shareItem) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, shareItem) == null) {
                MessageManager.getInstance().sendMessage(new ImplicitShareMessage(this.f20634b.f20605b.getContext(), this.f20633a, shareItem, false));
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

    @Override // c.a.r0.j2.o.f.a
    public void A(c.a.r0.j2.h.e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, eVar) == null) {
            this.r.t(eVar);
        }
    }

    @Override // c.a.r0.j2.o.f.a
    public void B(c.a.r0.j2.i.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, cVar) == null) {
            super.B(cVar);
            this.m.W0(cVar);
        }
    }

    @Override // c.a.r0.j2.o.f.a
    public void C(c.a.r0.j2.h.e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, eVar) == null) {
            this.n.I0(eVar);
        }
    }

    @Override // c.a.r0.j2.o.f.a
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
                TbadkCoreApplication.getInst().login(this.f20605b.getPageContext(), new CustomMessage<>(2002001, new LoginActivityConfig(this.f20605b.getPbActivity(), true, i2)));
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
            c.a.r0.j2.h.e eVar = this.f20607d;
            if (eVar == null || eVar.O() == null) {
                return -1;
            }
            return this.f20607d.O().w();
        }
        return invokeV.intValue;
    }

    public final void K(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048582, this, i2) == null) {
            m0.b(new b(this), new c(this, i2));
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
            AbsVideoPbFragment videoPbFragment = this.f20605b.getVideoPbFragment();
            this.n = new h(videoPbFragment, videoPbFragment, PostData.u0);
            PbFirstFloorCommentAndPraiseAdapter pbFirstFloorCommentAndPraiseAdapter = new PbFirstFloorCommentAndPraiseAdapter(this.f20605b.getVideoPbFragment(), p.f19671j);
            this.o = pbFirstFloorCommentAndPraiseAdapter;
            pbFirstFloorCommentAndPraiseAdapter.t0(this.C);
            this.p = new e(this.f20605b.getContext(), w.f19700f);
            this.q = new PbFirstFloorEnterForumAdapter(this.f20605b, c.a.r0.j2.h.g.m);
            this.r = new l0(this.f20605b.getVideoPbFragment(), o.l);
            this.u = new a0(this.f20605b.getVideoPbFragment(), c.a.r0.j2.h.j.f19647g, this.f20605b.getUniqueId());
            this.t = new h0(this.f20605b.getVideoPbFragment(), c.a.r0.j2.h.l.J0);
            this.v = new k(this.f20605b.getVideoPbFragment(), c.a.r0.j2.h.d.f19623g);
            c.a.r0.j2.k.e.i iVar = new c.a.r0.j2.k.e.i(this.f20605b.getVideoPbFragment(), q.b4);
            this.w = iVar;
            iVar.o0(true);
            this.x = new y(this.f20605b.getVideoPbFragment());
            l lVar = new l(this.f20605b.getVideoPbFragment(), PostData.v0);
            this.m = lVar;
            lVar.X0(this.f20605b.getVideoPbFragment());
            this.s = new PbReplyLoadMoreAdapter(this.f20605b.getVideoPbFragment(), PostData.B0);
            this.A = c.a.r0.y2.y.o().a(this.f20605b.getVideoPbFragment().getBaseFragmentActivity(), AdvertAppInfo.s4);
            this.B = c.a.r0.y2.y.o().a(this.f20605b.getVideoPbFragment().getBaseFragmentActivity(), AdvertAppInfo.u4);
            g gVar = new g(this.f20605b.getPageContext(), d2.r3, this.f20605b.getUniqueId());
            this.y = gVar;
            gVar.j0(this.f20606c);
            this.z = new PbFirstFloorItemAdapter(this.f20605b.getContext(), c.a.r0.j2.h.h.f19642g);
            this.f20608e.add(this.n);
            this.f20608e.add(this.o);
            this.f20608e.add(this.p);
            this.f20608e.add(this.q);
            this.f20608e.add(this.r);
            this.f20608e.add(this.t);
            this.f20608e.add(this.u);
            this.f20608e.add(this.v);
            this.f20608e.add(this.w);
            this.f20608e.add(this.x);
            this.f20608e.add(this.A);
            this.f20608e.add(this.B);
            this.f20608e.add(this.m);
            this.f20608e.add(this.s);
            this.f20608e.add(this.y);
            this.f20608e.add(this.z);
            this.f20608e.add(new PbPrivateTitleAdapter(this.f20605b.getVideoPbFragment()));
            this.f20606c.addAdapters(this.f20608e);
        }
    }

    @Override // c.a.r0.j2.o.f.a
    public l0 e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.r : (l0) invokeV.objValue;
    }

    @Override // c.a.r0.j2.o.f.a
    public l f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.m : (l) invokeV.objValue;
    }

    @Override // c.a.r0.j2.o.f.a
    public PbFirstFloorCommentAndPraiseAdapter g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.o : (PbFirstFloorCommentAndPraiseAdapter) invokeV.objValue;
    }

    @Override // c.a.r0.j2.o.f.a
    public void l() {
        h hVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048587, this) == null) || (hVar = this.n) == null) {
            return;
        }
        hVar.P();
    }

    @Override // c.a.r0.j2.o.f.a
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

    @Override // c.a.r0.j2.o.f.a
    public void o(boolean z) {
        c.a.e.l.e.a aVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048589, this, z) == null) && (aVar = this.B) != null && (aVar instanceof t)) {
            ((t) aVar).k(z);
        }
    }

    @Override // c.a.r0.j2.o.f.a
    public void p(c.a.r0.j2.h.e eVar, boolean z, String str, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048590, this, new Object[]{eVar, Boolean.valueOf(z), str, Boolean.valueOf(z2)}) == null) {
            this.m.t(eVar);
            this.m.setFromCDN(z);
            this.m.q(str);
            this.m.c(z2);
        }
    }

    @Override // c.a.r0.j2.o.f.a
    public void u(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, onClickListener) == null) {
            super.u(onClickListener);
            this.m.m(onClickListener);
        }
    }

    @Override // c.a.r0.j2.o.f.a
    public void v(TbRichTextView.z zVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, zVar) == null) {
            super.v(zVar);
            this.m.p(zVar);
        }
    }

    @Override // c.a.r0.j2.o.f.a
    public void w(View.OnLongClickListener onLongClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, onLongClickListener) == null) {
            super.w(onLongClickListener);
            this.m.d(onLongClickListener);
        }
    }

    @Override // c.a.r0.j2.o.f.a
    public void x(SortSwitchButton.f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, fVar) == null) {
            super.x(fVar);
            this.r.n0(fVar);
        }
    }

    @Override // c.a.r0.j2.o.f.a
    public void y(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, onClickListener) == null) {
            super.y(onClickListener);
            this.m.e(onClickListener);
            this.r.e(onClickListener);
            this.s.l0(onClickListener);
        }
    }

    @Override // c.a.r0.j2.o.f.a
    public void z(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048596, this, onClickListener) == null) {
            this.u.l0(onClickListener);
        }
    }
}
