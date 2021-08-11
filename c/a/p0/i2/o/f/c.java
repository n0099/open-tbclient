package c.a.p0.i2.o.f;

import android.text.TextUtils;
import android.view.View;
import androidx.core.view.InputDeviceCompat;
import c.a.e.e.p.k;
import c.a.e.k.e.n;
import c.a.o0.b1.h0;
import c.a.o0.b1.k0;
import c.a.o0.s.q.c2;
import c.a.p0.i2.h.q;
import c.a.p0.i2.h.v;
import c.a.p0.i2.k.e.l;
import c.a.p0.i2.k.e.r0;
import c.a.p0.i2.k.e.z;
import c.a.p0.i3.h0.p;
import c.a.p0.x2.y;
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

    /* renamed from: a  reason: collision with root package name */
    public final List<c.a.e.k.e.a> f19711a;

    /* renamed from: b  reason: collision with root package name */
    public DetailInfoFragment f19712b;

    /* renamed from: c  reason: collision with root package name */
    public c.a.p0.i2.h.e f19713c;

    /* renamed from: d  reason: collision with root package name */
    public BdTypeRecyclerView f19714d;

    /* renamed from: e  reason: collision with root package name */
    public List<n> f19715e;

    /* renamed from: f  reason: collision with root package name */
    public h f19716f;

    /* renamed from: g  reason: collision with root package name */
    public f f19717g;

    /* renamed from: h  reason: collision with root package name */
    public PbFirstFloorCommentAndPraiseAdapter f19718h;

    /* renamed from: i  reason: collision with root package name */
    public l f19719i;

    /* renamed from: j  reason: collision with root package name */
    public c.a.p0.i2.k.e.j f19720j;
    public z k;
    public PbFirstFloorItemAdapter l;
    public r0 m;
    public c.a.e.k.e.a n;
    public c.a.e.k.e.a o;
    public View.OnClickListener p;
    public View.OnClickListener q;

    /* loaded from: classes3.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c f19721e;

        /* renamed from: c.a.p0.i2.o.f.c$a$a  reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        public class C0930a implements FullBrowseHelper.IAcceptPrivacyConfirm {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ a f19722a;

            /* renamed from: c.a.p0.i2.o.f.c$a$a$a  reason: collision with other inner class name */
            /* loaded from: classes3.dex */
            public class RunnableC0931a implements Runnable {
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ C0930a f19723e;

                public RunnableC0931a(C0930a c0930a) {
                    Interceptable interceptable = $ic;
                    if (interceptable != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {c0930a};
                        interceptable.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f19723e = c0930a;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable = $ic;
                    if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                        this.f19723e.f19722a.f19721e.f19712b.getPbModel().V1(3);
                    }
                }
            }

            public C0930a(a aVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f19722a = aVar;
            }

            @Override // com.baidu.tbadk.core.util.FullBrowseHelper.IAcceptPrivacyConfirm
            public void onConfirm() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    if (!c.a.e.e.p.j.z()) {
                        this.f19722a.f19721e.f19712b.refreshByBrowseMode();
                    } else {
                        c.a.e.e.m.e.a().postDelayed(new RunnableC0931a(this), 10L);
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
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f19721e = cVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f19721e.f19712b == null || this.f19721e.f19712b.getPbModel() == null) {
                return;
            }
            FullBrowseHelper.checkAndShowFullBrowseModeDialog(this.f19721e.f19712b.getPageContext(), new C0930a(this));
        }
    }

    /* loaded from: classes3.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c f19724e;

        public b(c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f19724e = cVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                if (view.getId() == R.id.qq_share_container) {
                    if (this.f19724e.f(11009)) {
                        this.f19724e.i(8);
                    }
                } else if (view.getId() == R.id.share_num_container) {
                    if (this.f19724e.f(11009)) {
                        this.f19724e.i(3);
                    }
                } else if (this.f19724e.f19712b == null || this.f19724e.f19712b.getVideoPbFragment() == null || this.f19724e.f19712b.getVideoPbFragment().getListener() == null) {
                } else {
                    this.f19724e.f19712b.getVideoPbFragment().getListener().onClick(view);
                }
            }
        }
    }

    /* renamed from: c.a.p0.i2.o.f.c$c  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C0932c extends h0<ShareItem> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ c f19725a;

        public C0932c(c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f19725a = cVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.o0.b1.h0
        /* renamed from: a */
        public ShareItem doInBackground() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return c.a.p0.i2.k.e.f1.b.d(this.f19725a.f19712b.getContext(), this.f19725a.h(), ShareSwitch.isOn() ? 1 : 6, this.f19725a.f19712b.getPbModel());
            }
            return (ShareItem) invokeV.objValue;
        }
    }

    /* loaded from: classes3.dex */
    public class d implements c.a.o0.b1.n<ShareItem> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ int f19726a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ c f19727b;

        public d(c cVar, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f19727b = cVar;
            this.f19726a = i2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.o0.b1.n
        /* renamed from: a */
        public void onReturnDataInUI(ShareItem shareItem) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, shareItem) == null) {
                MessageManager.getInstance().sendMessage(new ImplicitShareMessage(this.f19727b.f19712b.getContext(), this.f19726a, shareItem, false));
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
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f19711a = new ArrayList();
        this.p = new a(this);
        this.q = new b(this);
        this.f19712b = detailInfoFragment;
        this.f19714d = bdTypeRecyclerView;
        k(detailInfoFragment, bdTypeRecyclerView);
    }

    public final void e(p pVar) {
        ForumData m;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, pVar) == null) || pVar == null || this.f19713c == null || pVar.getAdvertAppInfo() == null) {
            return;
        }
        pVar.getAdvertAppInfo().c4 = new c.a.o0.s.q.e();
        if (this.f19713c.y() != null) {
            pVar.getAdvertAppInfo().c4.f13887b = this.f19713c.y().a();
        }
        pVar.getAdvertAppInfo().c4.f13886a = pVar.E0();
        if (this.f19713c.m() != null && (m = this.f19713c.m()) != null) {
            pVar.getAdvertAppInfo().c4.f13889d = m.getId();
            pVar.getAdvertAppInfo().c4.f13890e = m.getFirst_class();
            pVar.getAdvertAppInfo().c4.f13891f = m.getSecond_class();
        }
        AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
        if (currentAccountObj != null) {
            pVar.getAdvertAppInfo().c4.f13892g = String.valueOf(currentAccountObj.isMemberCloseAdIsOpen());
        }
        pVar.getAdvertAppInfo().c4.f13893h = pVar.getAdvertAppInfo().a4;
        pVar.getAdvertAppInfo().c4.f13894i = false;
    }

    public final boolean f(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2)) == null) {
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (currentAccount == null || currentAccount.length() <= 0) {
                TbadkCoreApplication.getInst().login(this.f19712b.getPageContext(), new CustomMessage<>(2002001, new LoginActivityConfig(this.f19712b.getPbActivity(), true, i2)));
                return false;
            }
            return true;
        }
        return invokeI.booleanValue;
    }

    public final List<n> g(c.a.p0.i2.h.e eVar) {
        InterceptResult invokeL;
        PostData postData;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, eVar)) == null) {
            p pVar = null;
            if (eVar == null) {
                return null;
            }
            this.f19715e = new ArrayList();
            Iterator<PostData> it = eVar.F().iterator();
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
            if (postData == null && eVar.j() != null) {
                postData = eVar.j();
            }
            if (postData != null) {
                this.f19715e.add(postData);
            }
            if (c.a.o0.e1.b.e.d()) {
                return this.f19715e;
            }
            v vVar = new v();
            c2 O = eVar.O();
            vVar.f18802e = O;
            if (O != null && k.isEmpty(O.Z())) {
                vVar.f18802e.B3(eVar.o());
            }
            this.f19715e.add(vVar);
            c.a.p0.i2.h.p pVar2 = new c.a.p0.i2.h.p(eVar.O(), eVar.d());
            pVar2.f18776f = true;
            this.f19715e.add(pVar2);
            if (postData != null && postData.p0 != null && (eVar.m() == null || !TextUtils.equals(eVar.m().getName(), this.f19712b.getPbModel().p0()) || !this.f19712b.getPbModel().u0())) {
                c.a.p0.i2.h.h hVar = new c.a.p0.i2.h.h(postData.p0);
                hVar.f18747f = this.f19712b.getPbModel().e1();
                this.f19715e.add(hVar);
            }
            List<p> Y = eVar.Y();
            int i2 = 0;
            int i3 = -1;
            if (!c.a.p0.o1.o.k.a.e(Y) && (pVar = (p) c.a.p0.o1.o.k.a.d(Y, 0)) != null) {
                i3 = pVar.getPosition();
            }
            if (eVar.f() != null) {
                c.a.p0.i2.h.d dVar = new c.a.p0.i2.h.d();
                dVar.g(TbadkCoreApplication.getInst().getString(R.string.related_recommendation));
                this.f19715e.add(dVar);
                if (TbSingleton.getInstance().isBrowseMode()) {
                    this.f19715e.add(new q());
                } else {
                    int i4 = 1;
                    for (c.a.o0.s.q.q qVar : eVar.f()) {
                        if (Y != null && i4 == i3) {
                            if (pVar != null) {
                                e(pVar);
                                c.a.p0.o1.o.k.a.a(this.f19715e, pVar);
                                i2++;
                                if (pVar.getType() != AdvertAppInfo.o4) {
                                    i4++;
                                }
                            }
                            if (i2 < Y.size() && (pVar = (p) c.a.p0.o1.o.k.a.d(Y, i2)) != null) {
                                i3 = pVar.getPosition();
                            }
                        }
                        c.a.p0.o1.o.k.a.a(this.f19715e, qVar);
                        i4++;
                        if (i4 == 4 && eVar.C() != null) {
                            c.a.p0.o1.o.k.a.a(this.f19715e, eVar.C());
                            i4++;
                        }
                    }
                }
            }
            return this.f19715e;
        }
        return (List) invokeL.objValue;
    }

    public final int h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            c.a.p0.i2.h.e eVar = this.f19713c;
            if (eVar == null || eVar.O() == null) {
                return -1;
            }
            return this.f19713c.O().w();
        }
        return invokeV.intValue;
    }

    public final void i(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048580, this, i2) == null) {
            k0.b(new C0932c(this), new d(this, i2));
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

    public final void j(DetailInfoFragment detailInfoFragment) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, detailInfoFragment) == null) {
            this.n = y.o().a(detailInfoFragment.getVideoPbFragment().getBaseFragmentActivity(), AdvertAppInfo.o4);
            this.o = y.o().a(detailInfoFragment.getVideoPbFragment().getBaseFragmentActivity(), AdvertAppInfo.q4);
            this.f19711a.add(this.n);
            this.f19711a.add(this.o);
        }
    }

    public final void k(DetailInfoFragment detailInfoFragment, BdTypeRecyclerView bdTypeRecyclerView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048582, this, detailInfoFragment, bdTypeRecyclerView) == null) {
            AbsVideoPbFragment videoPbFragment = detailInfoFragment.getVideoPbFragment();
            this.f19716f = new h(videoPbFragment, videoPbFragment, PostData.u0);
            this.f19717g = new f(detailInfoFragment.getContext(), v.f18801f);
            PbFirstFloorCommentAndPraiseAdapter pbFirstFloorCommentAndPraiseAdapter = new PbFirstFloorCommentAndPraiseAdapter(detailInfoFragment.getVideoPbFragment(), c.a.p0.i2.h.p.f18774j);
            this.f19718h = pbFirstFloorCommentAndPraiseAdapter;
            pbFirstFloorCommentAndPraiseAdapter.t0(this.q);
            this.f19719i = new l(detailInfoFragment.getVideoPbFragment(), c.a.p0.i2.h.d.f18726g);
            c.a.p0.i2.k.e.j jVar = new c.a.p0.i2.k.e.j(detailInfoFragment.getVideoPbFragment(), c.a.o0.s.q.q.X3);
            this.f19720j = jVar;
            jVar.o0(true);
            this.k = new z(detailInfoFragment.getVideoPbFragment());
            this.l = new PbFirstFloorItemAdapter(detailInfoFragment.getContext(), c.a.p0.i2.h.h.f18745g);
            r0 r0Var = new r0(detailInfoFragment.getVideoPbFragment(), q.f18780e);
            this.m = r0Var;
            r0Var.l0(this.p);
            this.f19711a.add(this.f19716f);
            this.f19711a.add(this.f19717g);
            this.f19711a.add(this.f19718h);
            this.f19711a.add(this.f19719i);
            this.f19711a.add(this.f19720j);
            this.f19711a.add(this.k);
            this.f19711a.add(this.l);
            this.f19711a.add(this.m);
            j(detailInfoFragment);
            bdTypeRecyclerView.addAdapters(this.f19711a);
        }
    }

    public void l() {
        BdTypeRecyclerView bdTypeRecyclerView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048583, this) == null) || (bdTypeRecyclerView = this.f19714d) == null || bdTypeRecyclerView.getAdapter() == null) {
            return;
        }
        this.f19714d.getListAdapter().notifyDataSetChanged();
    }

    public void m() {
        h hVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) || (hVar = this.f19716f) == null) {
            return;
        }
        hVar.P();
    }

    public void n(c.a.p0.i2.h.e eVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048585, this, eVar) == null) || eVar == null) {
            return;
        }
        this.f19713c = eVar;
        BdTypeRecyclerView bdTypeRecyclerView = this.f19714d;
        if (bdTypeRecyclerView != null) {
            bdTypeRecyclerView.setVisibility(0);
        }
        this.f19716f.I0(eVar);
        this.f19720j.n0(eVar);
        this.k.l0(eVar);
        this.f19714d.setData(g(eVar));
    }
}
