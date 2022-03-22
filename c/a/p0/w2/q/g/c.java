package c.a.p0.w2.q.g;

import android.text.TextUtils;
import android.view.View;
import androidx.core.view.InputDeviceCompat;
import c.a.d.f.p.l;
import c.a.d.o.e.n;
import c.a.o0.c1.k0;
import c.a.o0.c1.n0;
import c.a.o0.c1.s;
import c.a.o0.r.r.q;
import c.a.p0.l3.z;
import c.a.p0.w2.i.t;
import c.a.p0.w2.i.y;
import c.a.p0.w2.m.f.e0;
import c.a.p0.w2.m.f.m;
import c.a.p0.w2.m.f.o;
import c.a.p0.w2.m.f.z0;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.LoginActivityConfig;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tbadk.core.data.ForumData;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tbadk.core.util.FullBrowseHelper;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.coreExtra.share.ShareItem;
import com.baidu.tbadk.switchs.ShareSwitch;
import com.baidu.tieba.R;
import com.baidu.tieba.pb.pb.main.adapter.PbFirstFloorCommentAndPraiseAdapter;
import com.baidu.tieba.pb.pb.main.adapter.PbFirstFloorItemAdapter;
import com.baidu.tieba.pb.videopb.AbsVideoPbFragment;
import com.baidu.tieba.pb.videopb.fragment.DetailInfoFragment;
import com.baidu.tieba.share.ImplicitShareMessage;
import com.baidu.tieba.tbadkCore.data.PostData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes3.dex */
public class c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final List<c.a.d.o.e.a> a;

    /* renamed from: b  reason: collision with root package name */
    public DetailInfoFragment f20474b;

    /* renamed from: c  reason: collision with root package name */
    public c.a.p0.w2.i.f f20475c;

    /* renamed from: d  reason: collision with root package name */
    public BdTypeRecyclerView f20476d;

    /* renamed from: e  reason: collision with root package name */
    public List<n> f20477e;

    /* renamed from: f  reason: collision with root package name */
    public h f20478f;

    /* renamed from: g  reason: collision with root package name */
    public f f20479g;

    /* renamed from: h  reason: collision with root package name */
    public PbFirstFloorCommentAndPraiseAdapter f20480h;
    public o i;
    public m j;
    public e0 k;
    public PbFirstFloorItemAdapter l;
    public z0 m;
    public c.a.d.o.e.a n;
    public c.a.d.o.e.a o;
    public View.OnClickListener p;
    public View.OnClickListener q;

    /* loaded from: classes3.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ c a;

        /* renamed from: c.a.p0.w2.q.g.c$a$a  reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        public class C1526a implements FullBrowseHelper.IAcceptPrivacyConfirm {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ a a;

            /* renamed from: c.a.p0.w2.q.g.c$a$a$a  reason: collision with other inner class name */
            /* loaded from: classes3.dex */
            public class RunnableC1527a implements Runnable {
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ C1526a a;

                public RunnableC1527a(C1526a c1526a) {
                    Interceptable interceptable = $ic;
                    if (interceptable != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {c1526a};
                        interceptable.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.a = c1526a;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable = $ic;
                    if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                        this.a.a.a.f20474b.w().k2(3);
                    }
                }
            }

            public C1526a(a aVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = aVar;
            }

            @Override // com.baidu.tbadk.core.util.FullBrowseHelper.IAcceptPrivacyConfirm
            public void onConfirm() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    if (!l.z()) {
                        this.a.a.f20474b.T0();
                    } else {
                        c.a.d.f.m.e.a().postDelayed(new RunnableC1527a(this), 10L);
                    }
                }
            }
        }

        public a(c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = cVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.a.f20474b == null || this.a.f20474b.w() == null) {
                return;
            }
            FullBrowseHelper.checkAndShowFullBrowseModeDialog(this.a.f20474b.getPageContext(), new C1526a(this));
        }
    }

    /* loaded from: classes3.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ c a;

        public b(c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = cVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                if (view.getId() == R.id.obfuscated_res_0x7f091991) {
                    if (this.a.f(11009)) {
                        this.a.i(8);
                    }
                } else if (view.getId() == R.id.obfuscated_res_0x7f091ccb) {
                    if (this.a.f(11009)) {
                        this.a.i(3);
                    }
                } else if (this.a.f20474b == null || this.a.f20474b.t() == null || this.a.f20474b.t().Z2() == null) {
                } else {
                    this.a.f20474b.t().Z2().onClick(view);
                }
            }
        }
    }

    /* renamed from: c.a.p0.w2.q.g.c$c  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C1528c extends k0<ShareItem> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ c a;

        public C1528c(c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = cVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.o0.c1.k0
        /* renamed from: a */
        public ShareItem doInBackground() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return c.a.p0.w2.m.f.n1.b.d(this.a.h(), ShareSwitch.isOn() ? 1 : 6, this.a.f20474b.w());
            }
            return (ShareItem) invokeV.objValue;
        }
    }

    /* loaded from: classes3.dex */
    public class d implements s<ShareItem> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ int a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ c f20481b;

        public d(c cVar, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f20481b = cVar;
            this.a = i;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.o0.c1.s
        /* renamed from: a */
        public void onReturnDataInUI(ShareItem shareItem) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, shareItem) == null) {
                MessageManager.getInstance().sendMessage(new ImplicitShareMessage(this.f20481b.f20474b.getContext(), this.a, shareItem, false));
            }
        }
    }

    public c(DetailInfoFragment detailInfoFragment, BdTypeRecyclerView bdTypeRecyclerView) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {detailInfoFragment, bdTypeRecyclerView};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = new ArrayList();
        this.p = new a(this);
        this.q = new b(this);
        this.f20474b = detailInfoFragment;
        this.f20476d = bdTypeRecyclerView;
        k(detailInfoFragment, bdTypeRecyclerView);
    }

    public final void e(c.a.p0.a4.k0.o oVar) {
        ForumData l;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, oVar) == null) || oVar == null || this.f20475c == null || oVar.getAdvertAppInfo() == null) {
            return;
        }
        oVar.getAdvertAppInfo().j = new c.a.o0.r.r.e();
        if (this.f20475c.y() != null) {
            oVar.getAdvertAppInfo().j.f10837b = this.f20475c.y().a();
        }
        oVar.getAdvertAppInfo().j.a = oVar.L0();
        if (this.f20475c.l() != null && (l = this.f20475c.l()) != null) {
            oVar.getAdvertAppInfo().j.f10839d = l.getId();
            oVar.getAdvertAppInfo().j.f10840e = l.getFirst_class();
            oVar.getAdvertAppInfo().j.f10841f = l.getSecond_class();
        }
        AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
        if (currentAccountObj != null) {
            oVar.getAdvertAppInfo().j.f10842g = String.valueOf(currentAccountObj.isMemberCloseAdIsOpen());
        }
        oVar.getAdvertAppInfo().j.f10843h = oVar.getAdvertAppInfo().f29821h;
        oVar.getAdvertAppInfo().j.i = false;
    }

    public final boolean f(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i)) == null) {
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (currentAccount == null || currentAccount.length() <= 0) {
                TbadkCoreApplication.getInst().login(this.f20474b.getPageContext(), new CustomMessage<>(2002001, new LoginActivityConfig(this.f20474b.x(), true, i)));
                return false;
            }
            return true;
        }
        return invokeI.booleanValue;
    }

    public final List<n> g(c.a.p0.w2.i.f fVar) {
        InterceptResult invokeL;
        PostData postData;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, fVar)) == null) {
            c.a.p0.a4.k0.o oVar = null;
            if (fVar == null) {
                return null;
            }
            this.f20477e = new ArrayList();
            Iterator<PostData> it = fVar.F().iterator();
            while (true) {
                if (!it.hasNext()) {
                    postData = null;
                    break;
                }
                PostData next = it.next();
                if (next instanceof PostData) {
                    postData = next;
                    if (postData.A() == 1) {
                        break;
                    }
                }
            }
            if (postData == null && fVar.j() != null) {
                postData = fVar.j();
            }
            if (postData != null) {
                this.f20477e.add(postData);
            }
            y yVar = new y();
            ThreadData O = fVar.O();
            yVar.a = O;
            if (O != null && c.a.d.f.p.m.isEmpty(O.getForum_name())) {
                yVar.a.setForum_name(fVar.n());
            }
            this.f20477e.add(yVar);
            c.a.p0.w2.i.s sVar = new c.a.p0.w2.i.s(fVar.O(), fVar.d());
            sVar.f19855b = true;
            this.f20477e.add(sVar);
            if (postData != null && postData.o0 != null && (fVar.l() == null || !TextUtils.equals(fVar.l().getName(), this.f20474b.w().s0()) || !this.f20474b.w().y0())) {
                c.a.p0.w2.i.i iVar = new c.a.p0.w2.i.i(postData.o0);
                iVar.f19830b = this.f20474b.w().k1();
                this.f20477e.add(iVar);
            }
            List<c.a.p0.a4.k0.o> Y = fVar.Y();
            int i = 0;
            int i2 = -1;
            if (!c.a.p0.b2.o.k.a.e(Y) && (oVar = (c.a.p0.a4.k0.o) c.a.p0.b2.o.k.a.d(Y, 0)) != null) {
                i2 = oVar.getPosition();
            }
            if (fVar.f() != null) {
                c.a.p0.w2.i.e eVar = new c.a.p0.w2.i.e();
                eVar.f(TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0f69));
                this.f20477e.add(eVar);
                if (TbSingleton.getInstance().isBrowseMode()) {
                    this.f20477e.add(new t());
                } else {
                    int i3 = 1;
                    for (q qVar : fVar.f()) {
                        if (Y != null && i3 == i2) {
                            if (oVar != null) {
                                e(oVar);
                                c.a.p0.b2.o.k.a.a(this.f20477e, oVar);
                                i++;
                                if (oVar.getType() != AdvertAppInfo.x) {
                                    i3++;
                                }
                            }
                            if (i < Y.size() && (oVar = (c.a.p0.a4.k0.o) c.a.p0.b2.o.k.a.d(Y, i)) != null) {
                                i2 = oVar.getPosition();
                            }
                        }
                        c.a.p0.b2.o.k.a.a(this.f20477e, qVar);
                        i3++;
                        if (i3 == 4 && fVar.C() != null) {
                            c.a.p0.b2.o.k.a.a(this.f20477e, fVar.C());
                            i3++;
                        }
                    }
                }
            }
            return this.f20477e;
        }
        return (List) invokeL.objValue;
    }

    public final int h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            c.a.p0.w2.i.f fVar = this.f20475c;
            if (fVar == null || fVar.O() == null) {
                return -1;
            }
            return this.f20475c.O().getActInfoType();
        }
        return invokeV.intValue;
    }

    public final void i(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048580, this, i) == null) {
            n0.b(new C1528c(this), new d(this, i));
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

    public final void j(DetailInfoFragment detailInfoFragment) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, detailInfoFragment) == null) {
            this.n = z.q().a(detailInfoFragment.t().getBaseFragmentActivity(), AdvertAppInfo.x);
            this.o = z.q().a(detailInfoFragment.t().getBaseFragmentActivity(), AdvertAppInfo.z);
            this.a.add(this.n);
            this.a.add(this.o);
        }
    }

    public final void k(DetailInfoFragment detailInfoFragment, BdTypeRecyclerView bdTypeRecyclerView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048582, this, detailInfoFragment, bdTypeRecyclerView) == null) {
            AbsVideoPbFragment t = detailInfoFragment.t();
            this.f20478f = new h(t, t, PostData.v0);
            this.f20479g = new f(detailInfoFragment.getContext(), y.f19873b);
            PbFirstFloorCommentAndPraiseAdapter pbFirstFloorCommentAndPraiseAdapter = new PbFirstFloorCommentAndPraiseAdapter(detailInfoFragment.t(), c.a.p0.w2.i.s.f19854f);
            this.f20480h = pbFirstFloorCommentAndPraiseAdapter;
            pbFirstFloorCommentAndPraiseAdapter.n0(this.q);
            this.i = new o(detailInfoFragment.t(), c.a.p0.w2.i.e.f19813c);
            m mVar = new m(detailInfoFragment.t(), q.f10926e);
            this.j = mVar;
            mVar.g0(true);
            this.k = new e0(detailInfoFragment.t());
            this.l = new PbFirstFloorItemAdapter(detailInfoFragment.getContext(), c.a.p0.w2.i.i.f19829c);
            z0 z0Var = new z0(detailInfoFragment.t(), t.a);
            this.m = z0Var;
            z0Var.e0(this.p);
            this.a.add(this.f20478f);
            this.a.add(this.f20479g);
            this.a.add(this.f20480h);
            this.a.add(this.i);
            this.a.add(this.j);
            this.a.add(this.k);
            this.a.add(this.l);
            this.a.add(this.m);
            j(detailInfoFragment);
            bdTypeRecyclerView.a(this.a);
        }
    }

    public void l() {
        BdTypeRecyclerView bdTypeRecyclerView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048583, this) == null) || (bdTypeRecyclerView = this.f20476d) == null || bdTypeRecyclerView.getAdapter() == null) {
            return;
        }
        this.f20476d.getListAdapter().notifyDataSetChanged();
    }

    public void m() {
        h hVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) || (hVar = this.f20478f) == null) {
            return;
        }
        hVar.H();
    }

    public void n(c.a.p0.w2.i.f fVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048585, this, fVar) == null) || fVar == null) {
            return;
        }
        this.f20475c = fVar;
        BdTypeRecyclerView bdTypeRecyclerView = this.f20476d;
        if (bdTypeRecyclerView != null) {
            bdTypeRecyclerView.setVisibility(0);
        }
        this.f20478f.A0(fVar);
        this.j.f0(fVar);
        this.k.d0(fVar);
        this.f20476d.setData(g(fVar));
    }
}
