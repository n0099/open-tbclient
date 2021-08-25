package c.a.q0.v.d.c.h;

import android.content.Context;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import androidx.core.view.InputDeviceCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.fragment.app.FragmentTransaction;
import c.a.q0.d4.a;
import c.a.q0.v.d.c.e.h;
import c.a.q0.v.d.c.e.i;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.ala.data.TabData;
import com.baidu.ala.view.ScrollHorizontalTabView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.launch.TTIStats;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.CommonStatisticKey;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.TiebaStaticHelper;
import com.baidu.tbadk.widget.NestedNoScrollViewPager;
import com.baidu.tieba.R;
import com.baidu.tieba.ala.alasquare.live_tab.fragment.LiveTabBaseSubFragment;
import com.baidu.tieba.ala.alasquare.live_tab.fragment.LiveTabFriendSubFragment;
import com.baidu.tieba.ala.alasquare.live_tab.fragment.LiveTabRecomSubFragment;
import com.baidu.tieba.ala.alasquare.live_tab.fragment.LiveTabYYSubFragment;
import com.baidu.tieba.ala.alasquare.live_tab.fragment.LiveTabYanzhiSubFragment;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.material.appbar.AppBarLayout;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public CustomMessageListener A;
    public CustomMessageListener B;
    public ScrollHorizontalTabView.OnTabClickListener C;
    public CustomMessageListener D;

    /* renamed from: a  reason: collision with root package name */
    public TbPageContext f25196a;

    /* renamed from: b  reason: collision with root package name */
    public Context f25197b;

    /* renamed from: c  reason: collision with root package name */
    public ViewGroup f25198c;

    /* renamed from: d  reason: collision with root package name */
    public ViewGroup f25199d;

    /* renamed from: e  reason: collision with root package name */
    public AppBarLayout f25200e;

    /* renamed from: f  reason: collision with root package name */
    public LinearLayout f25201f;

    /* renamed from: g  reason: collision with root package name */
    public FrameLayout f25202g;

    /* renamed from: h  reason: collision with root package name */
    public c.a.q0.v.d.c.h.d f25203h;

    /* renamed from: i  reason: collision with root package name */
    public ScrollHorizontalTabView f25204i;

    /* renamed from: j  reason: collision with root package name */
    public NestedNoScrollViewPager f25205j;
    public g k;
    public boolean l;
    public boolean m;
    public int n;
    public FragmentManager o;
    public int p;
    public boolean q;
    public int r;
    public int s;
    public int t;
    public int u;
    public int v;
    public int w;
    public List<LiveTabBaseSubFragment> x;
    public SparseArray<String> y;
    public boolean z;

    /* renamed from: c.a.q0.v.d.c.h.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C1173a extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f25206a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C1173a(a aVar, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f25206a = aVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Boolean bool;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && (bool = (Boolean) customResponsedMessage.getData()) != null && bool.booleanValue()) {
                this.f25206a.l = false;
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f25207a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(a aVar, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f25207a = aVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || TbSingleton.getInstance().getYYLiveTabConfig() == null || ListUtils.isEmpty(TbSingleton.getInstance().getYYLiveTabConfig().a()) || this.f25207a.z) {
                return;
            }
            this.f25207a.z = true;
            this.f25207a.j(c.a.q0.v.d.c.c.e(), false, true);
        }
    }

    /* loaded from: classes3.dex */
    public class c implements ScrollHorizontalTabView.OnTabClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f25208a;

        public c(a aVar) {
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
            this.f25208a = aVar;
        }

        @Override // com.baidu.ala.view.ScrollHorizontalTabView.OnTabClickListener
        public void onClick(int i2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeI(1048576, this, i2) == null) || this.f25208a.y.size() == 0) {
                return;
            }
            int keyAt = this.f25208a.y.keyAt(i2);
            StatisticItem statisticItem = new StatisticItem(CommonStatisticKey.KEY_LIVE_SECOND_TAB_CLICK);
            statisticItem.param("obj_type", keyAt - this.f25208a.r);
            TiebaStaticHelper.addYYParam(statisticItem);
            TiebaStatic.log(statisticItem);
        }
    }

    /* loaded from: classes3.dex */
    public class d implements AppBarLayout.OnOffsetChangedListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f25209a;

        public d(a aVar) {
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
            this.f25209a = aVar;
        }

        @Override // com.google.android.material.appbar.AppBarLayout.OnOffsetChangedListener, com.google.android.material.appbar.AppBarLayout.BaseOnOffsetChangedListener
        public void onOffsetChanged(AppBarLayout appBarLayout, int i2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLI(1048576, this, appBarLayout, i2) == null) || i2 == 0 || i2 == this.f25209a.n) {
                return;
            }
            if (i2 - this.f25209a.n <= -4 && !this.f25209a.l) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921441, Boolean.FALSE));
                this.f25209a.l = true;
            }
            this.f25209a.n = i2;
        }
    }

    /* loaded from: classes3.dex */
    public class e implements ScrollHorizontalTabView.ScrollTabPageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public e(a aVar) {
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
                }
            }
        }

        @Override // com.baidu.ala.view.ScrollHorizontalTabView.ScrollTabPageListener
        public void onPageScrolled(int i2, float f2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i2), Float.valueOf(f2), Integer.valueOf(i3)}) == null) {
            }
        }

        @Override // com.baidu.ala.view.ScrollHorizontalTabView.ScrollTabPageListener
        public void onPageSelected(int i2, TabData tabData) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, tabData) == null) {
            }
        }

        @Override // com.baidu.ala.view.ScrollHorizontalTabView.ScrollTabPageListener
        public boolean onPrePageSelect(int i2, TabData tabData) {
            InterceptResult invokeIL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeIL = interceptable.invokeIL(Constants.METHOD_SEND_USER_MSG, this, i2, tabData)) == null) {
                return true;
            }
            return invokeIL.booleanValue;
        }
    }

    /* loaded from: classes3.dex */
    public class f extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f25210a;

        /* renamed from: c.a.q0.v.d.c.h.a$f$a  reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        public class RunnableC1174a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ f f25211e;

            public RunnableC1174a(f fVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {fVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f25211e = fVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f25211e.f25210a.k == null) {
                    return;
                }
                this.f25211e.f25210a.k.c();
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public f(a aVar, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f25210a = aVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) {
                c.a.e.e.m.e.a().postDelayed(new RunnableC1174a(this), 500L);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class g extends FragmentPagerAdapter {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public List<LiveTabBaseSubFragment> f25212a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public g(a aVar, FragmentManager fragmentManager, List<LiveTabBaseSubFragment> list) {
            super(fragmentManager);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, fragmentManager, list};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super((FragmentManager) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f25212a = list;
        }

        public final LiveTabBaseSubFragment a(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i2)) == null) {
                if (i2 < this.f25212a.size()) {
                    return this.f25212a.get(i2);
                }
                return null;
            }
            return (LiveTabBaseSubFragment) invokeI.objValue;
        }

        public void b() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || ListUtils.isEmpty(this.f25212a)) {
                return;
            }
            for (int i2 = 0; i2 < this.f25212a.size(); i2++) {
                LiveTabBaseSubFragment liveTabBaseSubFragment = this.f25212a.get(i2);
                if (liveTabBaseSubFragment != null) {
                    liveTabBaseSubFragment.loadData();
                }
            }
        }

        public void c() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || ListUtils.isEmpty(this.f25212a)) {
                return;
            }
            for (int i2 = 0; i2 < this.f25212a.size(); i2++) {
                LiveTabBaseSubFragment liveTabBaseSubFragment = this.f25212a.get(i2);
                if (liveTabBaseSubFragment != null) {
                    liveTabBaseSubFragment.notifyListViewChanged();
                }
            }
        }

        public void d(int i2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeI(1048579, this, i2) == null) || i2 < 0 || i2 >= this.f25212a.size()) {
                return;
            }
            this.f25212a.get(i2).refreshPage();
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public int getCount() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
                List<LiveTabBaseSubFragment> list = this.f25212a;
                if (list != null) {
                    return list.size();
                }
                return 0;
            }
            return invokeV.intValue;
        }

        @Override // androidx.fragment.app.FragmentPagerAdapter
        public Fragment getItem(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeI = interceptable.invokeI(1048581, this, i2)) == null) ? a(i2) : (Fragment) invokeI.objValue;
        }
    }

    public a(TbPageContext tbPageContext, FragmentManager fragmentManager, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, fragmentManager, Boolean.valueOf(z)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.l = false;
        this.p = -1;
        this.q = false;
        this.r = 3;
        this.s = 4;
        this.t = 5;
        this.u = 6;
        this.v = 7;
        this.w = 8;
        this.y = new SparseArray<>();
        this.z = false;
        this.A = new C1173a(this, 2921442);
        this.B = new b(this, 2001371);
        this.C = new c(this);
        this.D = new f(this, 2921414);
        this.f25196a = tbPageContext;
        this.m = z;
        this.f25197b = tbPageContext.getPageActivity();
        this.o = fragmentManager;
        q();
    }

    public void A(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048576, this, i2) == null) {
            int i3 = 0;
            if (i2 <= 0) {
                i2 = 0;
            }
            g gVar = this.k;
            if (gVar == null || i2 < gVar.getCount()) {
                i3 = i2;
            }
            NestedNoScrollViewPager nestedNoScrollViewPager = this.f25205j;
            if (nestedNoScrollViewPager != null) {
                nestedNoScrollViewPager.setCurrentItem(i3);
            }
        }
    }

    public void B(h hVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, hVar) == null) {
            i iVar = new i();
            iVar.f25094e = hVar;
            this.f25203h.k(iVar);
            this.f25201f.setVisibility(0);
        }
    }

    public void j(boolean z, boolean z2, boolean z3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2), Boolean.valueOf(z3)}) == null) {
            if (ListUtils.isEmpty(this.x) || z != this.q || z3) {
                this.q = z;
                if (!z) {
                    o();
                } else {
                    r(z3);
                }
                if (z2) {
                    s();
                }
            }
        }
    }

    public void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            MessageManager.getInstance().unRegisterListener(this.D);
            MessageManager.getInstance().unRegisterListener(this.A);
            MessageManager.getInstance().unRegisterListener(this.B);
        }
    }

    public final List<TabData> l(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048580, this, z)) == null) {
            ArrayList arrayList = new ArrayList();
            TabData tabData = new TabData();
            tabData.tabId = 100;
            tabData.tabName = this.f25197b.getResources().getString(R.string.special_recommend_tab_title);
            arrayList.add(tabData);
            TabData tabData2 = new TabData();
            tabData2.tabId = 200;
            tabData2.tabName = this.f25197b.getResources().getString(R.string.special_yanzhi_tab_title);
            arrayList.add(tabData2);
            if (z) {
                TabData tabData3 = new TabData();
                tabData3.tabId = 400;
                tabData3.tabName = this.f25197b.getResources().getString(R.string.special_friend_tab_title);
                arrayList.add(tabData3);
            }
            return arrayList;
        }
        return (List) invokeZ.objValue;
    }

    public ViewGroup m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f25198c : (ViewGroup) invokeV.objValue;
    }

    public void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            this.D.setTag(this.f25196a.getUniqueId());
            MessageManager.getInstance().registerListener(this.D);
            MessageManager.getInstance().registerListener(this.A);
            MessageManager.getInstance().registerListener(this.B);
        }
    }

    public void o() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            y();
            this.y.clear();
            boolean z = c.a.p0.s.d0.b.j().k("key_show_ala_friend_tab", 0) == 1;
            this.f25205j.setOffscreenPageLimit(z ? 2 : 1);
            this.x.add(LiveTabRecomSubFragment.newInstance(this.m, 1));
            this.x.add(LiveTabYanzhiSubFragment.newInstance(this.m));
            if (z) {
                this.x.add(LiveTabFriendSubFragment.newInstance(this.m));
            }
            g gVar = new g(this, this.o, this.x);
            this.k = gVar;
            this.f25205j.setAdapter(gVar);
            TbPageContext tbPageContext = this.f25196a;
            if (tbPageContext != null && tbPageContext.getPageActivity() != null && this.f25196a.getPageActivity().getIntent() != null) {
                int intExtra = this.f25196a.getPageActivity().getIntent().getIntExtra("locate_type", 0);
                if (intExtra == 17) {
                    this.p = 0;
                } else if (intExtra == 18) {
                    this.p = 1;
                }
            }
            this.f25204i.setViewPager(this.f25205j);
            this.f25204i.setScrollTabPageListener(new e(this));
            this.f25204i.setData(l(z));
        }
    }

    public final void p(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, z) == null) {
            if (z) {
                if (TbSingleton.getInstance().getYYLiveTabConfig() == null || ListUtils.isEmpty(TbSingleton.getInstance().getYYLiveTabConfig().a())) {
                    return;
                }
                List<a.C0817a> a2 = TbSingleton.getInstance().getYYLiveTabConfig().a();
                this.y.clear();
                this.y.put(this.s, this.f25197b.getResources().getString(R.string.special_recommend_tab_title));
                for (int i2 = 0; i2 < a2.size(); i2++) {
                    this.y.put(a2.get(i2).f16902a, a2.get(i2).f16903b);
                }
            } else if (this.y.size() == 0) {
                this.y.put(this.s, this.f25197b.getResources().getString(R.string.special_recommend_tab_title));
                this.y.put(this.t, this.f25197b.getResources().getString(R.string.special_music_tab_title));
                this.y.put(this.u, this.f25197b.getResources().getString(R.string.special_talk_tab_title));
                this.y.put(this.v, this.f25197b.getResources().getString(R.string.special_game_tab_title));
                this.y.put(this.w, this.f25197b.getResources().getString(R.string.special_other_tab_title));
            }
        }
    }

    public final void q() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            long currentTimeMillis = System.currentTimeMillis();
            try {
                ViewGroup viewGroup = (ViewGroup) LayoutInflater.from(this.f25197b).inflate(R.layout.ala_live_tab_layout, (ViewGroup) null);
                this.f25198c = viewGroup;
                AppBarLayout appBarLayout = (AppBarLayout) viewGroup.findViewById(R.id.live_tab_appbar_layout);
                this.f25200e = appBarLayout;
                appBarLayout.addOnOffsetChangedListener((AppBarLayout.OnOffsetChangedListener) new d(this));
                this.f25199d = (ViewGroup) this.f25198c.findViewById(R.id.live_tab_root_container);
                this.f25201f = (LinearLayout) this.f25198c.findViewById(R.id.live_tab_base_container);
                this.f25202g = (FrameLayout) this.f25198c.findViewById(R.id.super_entrance_container);
                ScrollHorizontalTabView scrollHorizontalTabView = (ScrollHorizontalTabView) this.f25198c.findViewById(R.id.live_tab_top_tab_layout);
                this.f25204i = scrollHorizontalTabView;
                scrollHorizontalTabView.setOnTabClickListener(this.C);
                this.f25203h = new c.a.q0.v.d.c.h.d(this.f25196a);
                this.f25205j = (NestedNoScrollViewPager) this.f25198c.findViewById(R.id.live_tab_view_pager);
                j(c.a.q0.v.d.c.c.e(), false, false);
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, this.f25197b.getResources().getDimensionPixelSize(R.dimen.tbds256));
                if (this.f25203h.j() != null && this.f25203h.j().getParent() == null) {
                    this.f25202g.addView(this.f25203h.j(), layoutParams);
                    this.f25201f.setVisibility(8);
                }
                ((FrameLayout.LayoutParams) this.f25199d.getLayoutParams()).bottomMargin = TbadkCoreApplication.getInst().getMainTabBottomBarHeight();
                v();
            } finally {
                TTIStats.record("AlaLiveTabView.initView", System.currentTimeMillis() - currentTimeMillis);
            }
        }
    }

    public final void r(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048586, this, z) == null) {
            long currentTimeMillis = System.currentTimeMillis();
            try {
                p(z);
                y();
                ArrayList arrayList = new ArrayList();
                this.x.add(LiveTabRecomSubFragment.newInstance(this.m, this.y.keyAt(0)));
                TabData tabData = new TabData();
                tabData.tabId = this.y.keyAt(0);
                tabData.tabName = this.y.valueAt(0);
                arrayList.add(tabData);
                t(this.y.keyAt(0));
                for (int i2 = 1; i2 < this.y.size(); i2++) {
                    int keyAt = this.y.keyAt(i2);
                    this.x.add(LiveTabYYSubFragment.newInstance(this.m, keyAt));
                    TabData tabData2 = new TabData();
                    tabData2.tabId = keyAt;
                    tabData2.tabName = this.y.valueAt(i2);
                    arrayList.add(tabData2);
                    t(keyAt);
                }
                g gVar = new g(this, this.o, this.x);
                this.k = gVar;
                gVar.notifyDataSetChanged();
                this.f25205j.setAdapter(this.k);
                this.f25205j.setOffscreenPageLimit(arrayList.size());
                this.p = 0;
                this.f25204i.setViewPager(this.f25205j);
                this.f25204i.setData(arrayList);
            } finally {
                TTIStats.record("AlaLiveTabView.initYYTabs", System.currentTimeMillis() - currentTimeMillis);
            }
        }
    }

    public void s() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            this.k.b();
        }
    }

    public final void t(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048588, this, i2) == null) {
            StatisticItem statisticItem = new StatisticItem(CommonStatisticKey.KEY_LIVE_SECOND_TAB_SHOW);
            statisticItem.param("obj_type", i2 - this.r);
            TiebaStaticHelper.addYYParam(statisticItem);
            TiebaStatic.log(statisticItem);
        }
    }

    public void u(boolean z) {
        c.a.q0.v.d.c.h.d dVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048589, this, z) == null) || (dVar = this.f25203h) == null) {
            return;
        }
        dVar.t(z);
    }

    public void v() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            int skinType = TbadkCoreApplication.getInst().getSkinType();
            this.f25203h.l(this.f25196a, skinType);
            this.f25204i.onChangeSkinType(skinType);
            SkinManager.setBackgroundColor(this.f25198c, R.color.CAM_X0202);
            SkinManager.setBackgroundColor(this.f25204i, R.color.CAM_X0202);
        }
    }

    public void w(boolean z) {
        int i2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048591, this, z) == null) && z && (i2 = this.p) != -1) {
            A(i2);
            this.p = -1;
        }
    }

    public void x() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            this.k.d(this.f25205j.getCurrentItem());
        }
    }

    public final void y() {
        FragmentManager fragmentManager;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            if (!ListUtils.isEmpty(this.x) && (fragmentManager = this.o) != null) {
                try {
                    FragmentTransaction beginTransaction = fragmentManager.beginTransaction();
                    int size = this.x.size();
                    for (int i2 = 0; i2 < size; i2++) {
                        if (this.x.get(i2) != null) {
                            beginTransaction.remove(this.x.get(i2));
                        }
                    }
                    beginTransaction.commit();
                    this.o.executePendingTransactions();
                } catch (Throwable th) {
                    BdLog.e(th.getMessage());
                }
            } else if (this.x == null) {
                this.x = new ArrayList();
            }
            this.x.clear();
            g gVar = this.k;
            if (gVar != null) {
                gVar.notifyDataSetChanged();
            }
        }
    }

    public void z(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048594, this, z) == null) {
            this.f25199d.setVisibility(z ? 0 : 8);
        }
    }
}
