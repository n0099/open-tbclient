package c.a.p0.w2.q.g;

import android.view.View;
import androidx.core.view.InputDeviceCompat;
import c.a.o0.c1.k0;
import c.a.o0.c1.n0;
import c.a.o0.c1.s;
import c.a.o0.r.r.q;
import c.a.p0.l3.u;
import c.a.p0.w2.i.l;
import c.a.p0.w2.i.r;
import c.a.p0.w2.i.z;
import c.a.p0.w2.m.f.e0;
import c.a.p0.w2.m.f.g0;
import c.a.p0.w2.m.f.h0;
import c.a.p0.w2.m.f.m;
import c.a.p0.w2.m.f.o;
import c.a.p0.w2.m.f.p;
import c.a.p0.w2.m.f.p0;
import c.a.p0.w2.m.f.t0;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.LoginActivityConfig;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tbadk.core.data.ThreadData;
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
public class d extends c.a.p0.w2.q.g.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public PbFirstFloorItemAdapter A;
    public c.a.d.o.e.a B;
    public c.a.d.o.e.a C;
    public View.OnClickListener D;
    public p m;
    public h n;
    public PbFirstFloorCommentAndPraiseAdapter o;
    public e p;
    public PbFirstFloorEnterForumAdapter q;
    public t0 r;
    public PbReplyLoadMoreAdapter s;
    public p0 t;
    public g0 u;
    public h0 v;
    public o w;
    public m x;
    public e0 y;
    public g z;

    /* loaded from: classes3.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ d a;

        public a(d dVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = dVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                if (view.getId() == R.id.obfuscated_res_0x7f091991) {
                    if (this.a.J(11009)) {
                        this.a.L(8);
                    }
                } else if (view.getId() == R.id.obfuscated_res_0x7f091ccb && this.a.J(11009)) {
                    this.a.L(3);
                }
            }
        }
    }

    /* loaded from: classes3.dex */
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
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = dVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.o0.c1.k0
        /* renamed from: a */
        public ShareItem doInBackground() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return c.a.p0.w2.m.f.n1.b.d(this.a.K(), ShareSwitch.isOn() ? 1 : 6, this.a.f20467b.w());
            }
            return (ShareItem) invokeV.objValue;
        }
    }

    /* loaded from: classes3.dex */
    public class c implements s<ShareItem> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ int a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ d f20482b;

        public c(d dVar, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f20482b = dVar;
            this.a = i;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.o0.c1.s
        /* renamed from: a */
        public void onReturnDataInUI(ShareItem shareItem) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, shareItem) == null) {
                MessageManager.getInstance().sendMessage(new ImplicitShareMessage(this.f20482b.f20467b.getContext(), this.a, shareItem, false));
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
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

    @Override // c.a.p0.w2.q.g.a
    public void A(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, onClickListener) == null) {
            this.v.d0(onClickListener);
        }
    }

    @Override // c.a.p0.w2.q.g.a
    public void B(c.a.p0.w2.i.f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, fVar) == null) {
            this.r.t(fVar);
        }
    }

    @Override // c.a.p0.w2.q.g.a
    public void C(c.a.p0.w2.j.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, cVar) == null) {
            super.C(cVar);
            this.m.P0(cVar);
        }
    }

    @Override // c.a.p0.w2.q.g.a
    public void D(c.a.p0.w2.i.f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, fVar) == null) {
            this.n.A0(fVar);
        }
    }

    @Override // c.a.p0.w2.q.g.a
    public void E(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, str) == null) {
            this.n.q(str);
        }
    }

    public final boolean J(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048581, this, i)) == null) {
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (currentAccount == null || currentAccount.length() <= 0) {
                TbadkCoreApplication.getInst().login(this.f20467b.getPageContext(), new CustomMessage<>(2002001, new LoginActivityConfig(this.f20467b.x(), true, i)));
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
            c.a.p0.w2.i.f fVar = this.f20469d;
            if (fVar == null || fVar.O() == null) {
                return -1;
            }
            return this.f20469d.O().getActInfoType();
        }
        return invokeV.intValue;
    }

    public final void L(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048583, this, i) == null) {
            n0.b(new b(this), new c(this, i));
            StatisticItem statisticItem = new StatisticItem("c13833");
            statisticItem.param("obj_locate", 1);
            if (i == 3) {
                statisticItem.param("obj_type", 1);
            } else if (i == 8) {
                statisticItem.param("obj_type", 2);
            }
            TiebaStatic.log(statisticItem);
        }
    }

    public final void M() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            AbsVideoPbFragment t = this.f20467b.t();
            this.n = new h(t, t, PostData.v0);
            PbFirstFloorCommentAndPraiseAdapter pbFirstFloorCommentAndPraiseAdapter = new PbFirstFloorCommentAndPraiseAdapter(this.f20467b.t(), c.a.p0.w2.i.s.f19854f);
            this.o = pbFirstFloorCommentAndPraiseAdapter;
            pbFirstFloorCommentAndPraiseAdapter.n0(this.D);
            this.p = new e(this.f20467b.getContext(), z.f19874b);
            this.q = new PbFirstFloorEnterForumAdapter(this.f20467b, c.a.p0.w2.i.h.i);
            this.r = new t0(this.f20467b.t(), r.f19847h);
            this.u = new g0(this.f20467b.t(), l.f19833c, this.f20467b.getUniqueId());
            this.v = new h0(this.f20467b.t(), c.a.p0.w2.i.m.a);
            this.t = new p0(this.f20467b.t(), c.a.p0.w2.i.o.K0);
            this.w = new o(this.f20467b.t(), c.a.p0.w2.i.e.f19813c);
            m mVar = new m(this.f20467b.t(), q.f10926e);
            this.x = mVar;
            mVar.g0(true);
            this.y = new e0(this.f20467b.t());
            p pVar = new p(this.f20467b.t(), PostData.w0);
            this.m = pVar;
            pVar.Q0(this.f20467b.t());
            this.s = new PbReplyLoadMoreAdapter(this.f20467b.t(), PostData.C0);
            this.B = c.a.p0.l3.z.q().a(this.f20467b.t().getBaseFragmentActivity(), AdvertAppInfo.x);
            this.C = c.a.p0.l3.z.q().a(this.f20467b.t().getBaseFragmentActivity(), AdvertAppInfo.z);
            g gVar = new g(this.f20467b.getPageContext(), ThreadData.TYPE_ITEM, this.f20467b.getUniqueId());
            this.z = gVar;
            gVar.b0(this.f20468c);
            this.A = new PbFirstFloorItemAdapter(this.f20467b.getContext(), c.a.p0.w2.i.i.f19829c);
            this.f20470e.add(this.n);
            this.f20470e.add(this.o);
            this.f20470e.add(this.p);
            this.f20470e.add(this.q);
            this.f20470e.add(this.r);
            this.f20470e.add(this.t);
            this.f20470e.add(this.u);
            this.f20470e.add(this.v);
            this.f20470e.add(this.w);
            this.f20470e.add(this.x);
            this.f20470e.add(this.y);
            this.f20470e.add(this.B);
            this.f20470e.add(this.C);
            this.f20470e.add(this.m);
            this.f20470e.add(this.s);
            this.f20470e.add(this.z);
            this.f20470e.add(this.A);
            this.f20470e.add(new PbPrivateTitleAdapter(this.f20467b.t()));
            this.f20468c.a(this.f20470e);
        }
    }

    @Override // c.a.p0.w2.q.g.a
    public t0 e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.r : (t0) invokeV.objValue;
    }

    @Override // c.a.p0.w2.q.g.a
    public p f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.m : (p) invokeV.objValue;
    }

    @Override // c.a.p0.w2.q.g.a
    public PbFirstFloorCommentAndPraiseAdapter g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.o : (PbFirstFloorCommentAndPraiseAdapter) invokeV.objValue;
    }

    @Override // c.a.p0.w2.q.g.a
    public void l() {
        h hVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048588, this) == null) || (hVar = this.n) == null) {
            return;
        }
        hVar.H();
    }

    @Override // c.a.p0.w2.q.g.a
    public void m() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            t0 t0Var = this.r;
            if (t0Var != null) {
                t0Var.onDestroy();
            }
            PbFirstFloorCommentAndPraiseAdapter pbFirstFloorCommentAndPraiseAdapter = this.o;
            if (pbFirstFloorCommentAndPraiseAdapter != null) {
                pbFirstFloorCommentAndPraiseAdapter.onDestroy();
            }
        }
    }

    @Override // c.a.p0.w2.q.g.a
    public void o(boolean z) {
        c.a.d.o.e.a aVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048590, this, z) == null) && (aVar = this.C) != null && (aVar instanceof u)) {
            ((u) aVar).k(z);
        }
    }

    @Override // c.a.p0.w2.q.g.a
    public void p(c.a.p0.w2.i.f fVar, boolean z, String str, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048591, this, new Object[]{fVar, Boolean.valueOf(z), str, Boolean.valueOf(z2)}) == null) {
            this.m.t(fVar);
            this.m.setFromCDN(z);
            this.m.q(str);
            this.m.c(z2);
        }
    }

    @Override // c.a.p0.w2.q.g.a
    public void u(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, onClickListener) == null) {
            super.u(onClickListener);
            this.m.m(onClickListener);
        }
    }

    @Override // c.a.p0.w2.q.g.a
    public void v(TbRichTextView.y yVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, yVar) == null) {
            super.v(yVar);
            this.m.p(yVar);
        }
    }

    @Override // c.a.p0.w2.q.g.a
    public void w(View.OnLongClickListener onLongClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, onLongClickListener) == null) {
            super.w(onLongClickListener);
            this.m.d(onLongClickListener);
        }
    }

    @Override // c.a.p0.w2.q.g.a
    public void x(SortSwitchButton.f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, fVar) == null) {
            super.x(fVar);
            this.r.f0(fVar);
        }
    }

    @Override // c.a.p0.w2.q.g.a
    public void y(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048596, this, onClickListener) == null) {
            super.y(onClickListener);
            this.m.e(onClickListener);
            this.r.e(onClickListener);
            this.s.d0(onClickListener);
        }
    }

    @Override // c.a.p0.w2.q.g.a
    public void z(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048597, this, onClickListener) == null) {
            this.u.d0(onClickListener);
        }
    }
}
