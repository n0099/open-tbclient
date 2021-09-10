package c.a.r0.j2.o.f;

import android.text.TextUtils;
import android.view.View;
import androidx.core.view.InputDeviceCompat;
import c.a.e.l.e.n;
import c.a.q0.d1.i0;
import c.a.q0.d1.l0;
import c.a.q0.d1.o;
import c.a.q0.s.q.d2;
import c.a.r0.j2.h.q;
import c.a.r0.j2.h.v;
import c.a.r0.j2.k.e.k;
import c.a.r0.j2.k.e.r0;
import c.a.r0.j2.k.e.y;
import c.a.r0.j3.i0.p;
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
    public final List<c.a.e.l.e.a> f20599a;

    /* renamed from: b  reason: collision with root package name */
    public DetailInfoFragment f20600b;

    /* renamed from: c  reason: collision with root package name */
    public c.a.r0.j2.h.e f20601c;

    /* renamed from: d  reason: collision with root package name */
    public BdTypeRecyclerView f20602d;

    /* renamed from: e  reason: collision with root package name */
    public List<n> f20603e;

    /* renamed from: f  reason: collision with root package name */
    public h f20604f;

    /* renamed from: g  reason: collision with root package name */
    public f f20605g;

    /* renamed from: h  reason: collision with root package name */
    public PbFirstFloorCommentAndPraiseAdapter f20606h;

    /* renamed from: i  reason: collision with root package name */
    public k f20607i;

    /* renamed from: j  reason: collision with root package name */
    public c.a.r0.j2.k.e.i f20608j;
    public y k;
    public PbFirstFloorItemAdapter l;
    public r0 m;
    public c.a.e.l.e.a n;
    public c.a.e.l.e.a o;
    public View.OnClickListener p;
    public View.OnClickListener q;

    /* loaded from: classes3.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c f20609e;

        /* renamed from: c.a.r0.j2.o.f.c$a$a  reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        public class C0975a implements FullBrowseHelper.IAcceptPrivacyConfirm {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ a f20610a;

            /* renamed from: c.a.r0.j2.o.f.c$a$a$a  reason: collision with other inner class name */
            /* loaded from: classes3.dex */
            public class RunnableC0976a implements Runnable {
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ C0975a f20611e;

                public RunnableC0976a(C0975a c0975a) {
                    Interceptable interceptable = $ic;
                    if (interceptable != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {c0975a};
                        interceptable.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f20611e = c0975a;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable = $ic;
                    if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                        this.f20611e.f20610a.f20609e.f20600b.getPbModel().W1(3);
                    }
                }
            }

            public C0975a(a aVar) {
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
                this.f20610a = aVar;
            }

            @Override // com.baidu.tbadk.core.util.FullBrowseHelper.IAcceptPrivacyConfirm
            public void onConfirm() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    if (!c.a.e.e.p.j.z()) {
                        this.f20610a.f20609e.f20600b.refreshByBrowseMode();
                    } else {
                        c.a.e.e.m.e.a().postDelayed(new RunnableC0976a(this), 10L);
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
            this.f20609e = cVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f20609e.f20600b == null || this.f20609e.f20600b.getPbModel() == null) {
                return;
            }
            FullBrowseHelper.checkAndShowFullBrowseModeDialog(this.f20609e.f20600b.getPageContext(), new C0975a(this));
        }
    }

    /* loaded from: classes3.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c f20612e;

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
            this.f20612e = cVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                if (view.getId() == R.id.qq_share_container) {
                    if (this.f20612e.f(11009)) {
                        this.f20612e.i(8);
                    }
                } else if (view.getId() == R.id.share_num_container) {
                    if (this.f20612e.f(11009)) {
                        this.f20612e.i(3);
                    }
                } else if (this.f20612e.f20600b == null || this.f20612e.f20600b.getVideoPbFragment() == null || this.f20612e.f20600b.getVideoPbFragment().getListener() == null) {
                } else {
                    this.f20612e.f20600b.getVideoPbFragment().getListener().onClick(view);
                }
            }
        }
    }

    /* renamed from: c.a.r0.j2.o.f.c$c  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C0977c extends i0<ShareItem> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ c f20613a;

        public C0977c(c cVar) {
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
            this.f20613a = cVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.q0.d1.i0
        /* renamed from: a */
        public ShareItem doInBackground() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return c.a.r0.j2.k.e.f1.b.d(this.f20613a.f20600b.getContext(), this.f20613a.h(), ShareSwitch.isOn() ? 1 : 6, this.f20613a.f20600b.getPbModel());
            }
            return (ShareItem) invokeV.objValue;
        }
    }

    /* loaded from: classes3.dex */
    public class d implements o<ShareItem> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ int f20614a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ c f20615b;

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
            this.f20615b = cVar;
            this.f20614a = i2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.q0.d1.o
        /* renamed from: a */
        public void onReturnDataInUI(ShareItem shareItem) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, shareItem) == null) {
                MessageManager.getInstance().sendMessage(new ImplicitShareMessage(this.f20615b.f20600b.getContext(), this.f20614a, shareItem, false));
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
        this.f20599a = new ArrayList();
        this.p = new a(this);
        this.q = new b(this);
        this.f20600b = detailInfoFragment;
        this.f20602d = bdTypeRecyclerView;
        k(detailInfoFragment, bdTypeRecyclerView);
    }

    public final void e(p pVar) {
        ForumData m;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, pVar) == null) || pVar == null || this.f20601c == null || pVar.getAdvertAppInfo() == null) {
            return;
        }
        pVar.getAdvertAppInfo().f4 = new c.a.q0.s.q.e();
        if (this.f20601c.y() != null) {
            pVar.getAdvertAppInfo().f4.f14144b = this.f20601c.y().a();
        }
        pVar.getAdvertAppInfo().f4.f14143a = pVar.E0();
        if (this.f20601c.m() != null && (m = this.f20601c.m()) != null) {
            pVar.getAdvertAppInfo().f4.f14146d = m.getId();
            pVar.getAdvertAppInfo().f4.f14147e = m.getFirst_class();
            pVar.getAdvertAppInfo().f4.f14148f = m.getSecond_class();
        }
        AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
        if (currentAccountObj != null) {
            pVar.getAdvertAppInfo().f4.f14149g = String.valueOf(currentAccountObj.isMemberCloseAdIsOpen());
        }
        pVar.getAdvertAppInfo().f4.f14150h = pVar.getAdvertAppInfo().d4;
        pVar.getAdvertAppInfo().f4.f14151i = false;
    }

    public final boolean f(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2)) == null) {
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (currentAccount == null || currentAccount.length() <= 0) {
                TbadkCoreApplication.getInst().login(this.f20600b.getPageContext(), new CustomMessage<>(2002001, new LoginActivityConfig(this.f20600b.getPbActivity(), true, i2)));
                return false;
            }
            return true;
        }
        return invokeI.booleanValue;
    }

    public final List<n> g(c.a.r0.j2.h.e eVar) {
        InterceptResult invokeL;
        PostData postData;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, eVar)) == null) {
            p pVar = null;
            if (eVar == null) {
                return null;
            }
            this.f20603e = new ArrayList();
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
                this.f20603e.add(postData);
            }
            if (c.a.q0.g1.b.e.d()) {
                return this.f20603e;
            }
            v vVar = new v();
            d2 O = eVar.O();
            vVar.f19684e = O;
            if (O != null && c.a.e.e.p.k.isEmpty(O.Z())) {
                vVar.f19684e.I3(eVar.o());
            }
            this.f20603e.add(vVar);
            c.a.r0.j2.h.p pVar2 = new c.a.r0.j2.h.p(eVar.O(), eVar.d());
            pVar2.f19658f = true;
            this.f20603e.add(pVar2);
            if (postData != null && postData.p0 != null && (eVar.m() == null || !TextUtils.equals(eVar.m().getName(), this.f20600b.getPbModel().p0()) || !this.f20600b.getPbModel().u0())) {
                c.a.r0.j2.h.h hVar = new c.a.r0.j2.h.h(postData.p0);
                hVar.f19629f = this.f20600b.getPbModel().e1();
                this.f20603e.add(hVar);
            }
            List<p> Y = eVar.Y();
            int i2 = 0;
            int i3 = -1;
            if (!c.a.r0.p1.o.k.a.e(Y) && (pVar = (p) c.a.r0.p1.o.k.a.d(Y, 0)) != null) {
                i3 = pVar.getPosition();
            }
            if (eVar.f() != null) {
                c.a.r0.j2.h.d dVar = new c.a.r0.j2.h.d();
                dVar.g(TbadkCoreApplication.getInst().getString(R.string.related_recommendation));
                this.f20603e.add(dVar);
                if (TbSingleton.getInstance().isBrowseMode()) {
                    this.f20603e.add(new q());
                } else {
                    int i4 = 1;
                    for (c.a.q0.s.q.q qVar : eVar.f()) {
                        if (Y != null && i4 == i3) {
                            if (pVar != null) {
                                e(pVar);
                                c.a.r0.p1.o.k.a.a(this.f20603e, pVar);
                                i2++;
                                if (pVar.getType() != AdvertAppInfo.r4) {
                                    i4++;
                                }
                            }
                            if (i2 < Y.size() && (pVar = (p) c.a.r0.p1.o.k.a.d(Y, i2)) != null) {
                                i3 = pVar.getPosition();
                            }
                        }
                        c.a.r0.p1.o.k.a.a(this.f20603e, qVar);
                        i4++;
                        if (i4 == 4 && eVar.C() != null) {
                            c.a.r0.p1.o.k.a.a(this.f20603e, eVar.C());
                            i4++;
                        }
                    }
                }
            }
            return this.f20603e;
        }
        return (List) invokeL.objValue;
    }

    public final int h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            c.a.r0.j2.h.e eVar = this.f20601c;
            if (eVar == null || eVar.O() == null) {
                return -1;
            }
            return this.f20601c.O().w();
        }
        return invokeV.intValue;
    }

    public final void i(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048580, this, i2) == null) {
            l0.b(new C0977c(this), new d(this, i2));
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
            this.n = c.a.r0.y2.y.o().a(detailInfoFragment.getVideoPbFragment().getBaseFragmentActivity(), AdvertAppInfo.r4);
            this.o = c.a.r0.y2.y.o().a(detailInfoFragment.getVideoPbFragment().getBaseFragmentActivity(), AdvertAppInfo.t4);
            this.f20599a.add(this.n);
            this.f20599a.add(this.o);
        }
    }

    public final void k(DetailInfoFragment detailInfoFragment, BdTypeRecyclerView bdTypeRecyclerView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048582, this, detailInfoFragment, bdTypeRecyclerView) == null) {
            AbsVideoPbFragment videoPbFragment = detailInfoFragment.getVideoPbFragment();
            this.f20604f = new h(videoPbFragment, videoPbFragment, PostData.u0);
            this.f20605g = new f(detailInfoFragment.getContext(), v.f19683f);
            PbFirstFloorCommentAndPraiseAdapter pbFirstFloorCommentAndPraiseAdapter = new PbFirstFloorCommentAndPraiseAdapter(detailInfoFragment.getVideoPbFragment(), c.a.r0.j2.h.p.f19656j);
            this.f20606h = pbFirstFloorCommentAndPraiseAdapter;
            pbFirstFloorCommentAndPraiseAdapter.t0(this.q);
            this.f20607i = new k(detailInfoFragment.getVideoPbFragment(), c.a.r0.j2.h.d.f19608g);
            c.a.r0.j2.k.e.i iVar = new c.a.r0.j2.k.e.i(detailInfoFragment.getVideoPbFragment(), c.a.q0.s.q.q.a4);
            this.f20608j = iVar;
            iVar.o0(true);
            this.k = new y(detailInfoFragment.getVideoPbFragment());
            this.l = new PbFirstFloorItemAdapter(detailInfoFragment.getContext(), c.a.r0.j2.h.h.f19627g);
            r0 r0Var = new r0(detailInfoFragment.getVideoPbFragment(), q.f19662e);
            this.m = r0Var;
            r0Var.l0(this.p);
            this.f20599a.add(this.f20604f);
            this.f20599a.add(this.f20605g);
            this.f20599a.add(this.f20606h);
            this.f20599a.add(this.f20607i);
            this.f20599a.add(this.f20608j);
            this.f20599a.add(this.k);
            this.f20599a.add(this.l);
            this.f20599a.add(this.m);
            j(detailInfoFragment);
            bdTypeRecyclerView.addAdapters(this.f20599a);
        }
    }

    public void l() {
        BdTypeRecyclerView bdTypeRecyclerView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048583, this) == null) || (bdTypeRecyclerView = this.f20602d) == null || bdTypeRecyclerView.getAdapter() == null) {
            return;
        }
        this.f20602d.getListAdapter().notifyDataSetChanged();
    }

    public void m() {
        h hVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) || (hVar = this.f20604f) == null) {
            return;
        }
        hVar.P();
    }

    public void n(c.a.r0.j2.h.e eVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048585, this, eVar) == null) || eVar == null) {
            return;
        }
        this.f20601c = eVar;
        BdTypeRecyclerView bdTypeRecyclerView = this.f20602d;
        if (bdTypeRecyclerView != null) {
            bdTypeRecyclerView.setVisibility(0);
        }
        this.f20604f.I0(eVar);
        this.f20608j.n0(eVar);
        this.k.l0(eVar);
        this.f20602d.setData(g(eVar));
    }
}
