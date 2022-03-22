package c.a.p0.c0.f.c.h;

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
import c.a.p0.c0.f.c.e.h;
import c.a.p0.c0.f.c.e.i;
import c.a.p0.u4.a;
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
/* loaded from: classes2.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public CustomMessageListener A;
    public CustomMessageListener B;
    public ScrollHorizontalTabView.OnTabClickListener C;
    public CustomMessageListener D;
    public TbPageContext a;

    /* renamed from: b  reason: collision with root package name */
    public Context f13004b;

    /* renamed from: c  reason: collision with root package name */
    public ViewGroup f13005c;

    /* renamed from: d  reason: collision with root package name */
    public ViewGroup f13006d;

    /* renamed from: e  reason: collision with root package name */
    public AppBarLayout f13007e;

    /* renamed from: f  reason: collision with root package name */
    public LinearLayout f13008f;

    /* renamed from: g  reason: collision with root package name */
    public FrameLayout f13009g;

    /* renamed from: h  reason: collision with root package name */
    public c.a.p0.c0.f.c.h.d f13010h;
    public ScrollHorizontalTabView i;
    public NestedNoScrollViewPager j;
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

    /* renamed from: c.a.p0.c0.f.c.h.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class C0977a extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ a a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C0977a(a aVar, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = aVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Boolean bool;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && (bool = (Boolean) customResponsedMessage.getData()) != null && bool.booleanValue()) {
                this.a.l = false;
            }
        }
    }

    /* loaded from: classes2.dex */
    public class b extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ a a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(a aVar, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = aVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || TbSingleton.getInstance().getYYLiveTabConfig() == null || ListUtils.isEmpty(TbSingleton.getInstance().getYYLiveTabConfig().a()) || this.a.z) {
                return;
            }
            this.a.z = true;
            this.a.j(c.a.p0.c0.f.c.c.e(), false, true);
        }
    }

    /* loaded from: classes2.dex */
    public class c implements ScrollHorizontalTabView.OnTabClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ a a;

        public c(a aVar) {
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

        @Override // com.baidu.ala.view.ScrollHorizontalTabView.OnTabClickListener
        public void onClick(int i) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeI(1048576, this, i) == null) || this.a.y.size() == 0) {
                return;
            }
            int keyAt = this.a.y.keyAt(i);
            StatisticItem statisticItem = new StatisticItem(CommonStatisticKey.KEY_LIVE_SECOND_TAB_CLICK);
            statisticItem.param("obj_type", keyAt - this.a.r);
            TiebaStaticHelper.addYYParam(statisticItem);
            TiebaStatic.log(statisticItem);
        }
    }

    /* loaded from: classes2.dex */
    public class d implements AppBarLayout.OnOffsetChangedListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ a a;

        public d(a aVar) {
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

        @Override // com.google.android.material.appbar.AppBarLayout.OnOffsetChangedListener, com.google.android.material.appbar.AppBarLayout.BaseOnOffsetChangedListener
        public void onOffsetChanged(AppBarLayout appBarLayout, int i) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLI(1048576, this, appBarLayout, i) == null) || i == 0 || i == this.a.n) {
                return;
            }
            if (i - this.a.n <= -4 && !this.a.l) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921441, Boolean.FALSE));
                this.a.l = true;
            }
            this.a.n = i;
        }
    }

    /* loaded from: classes2.dex */
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
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.baidu.ala.view.ScrollHorizontalTabView.ScrollTabPageListener
        public void onPageScrolled(int i, float f2, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i), Float.valueOf(f2), Integer.valueOf(i2)}) == null) {
            }
        }

        @Override // com.baidu.ala.view.ScrollHorizontalTabView.ScrollTabPageListener
        public void onPageSelected(int i, TabData tabData) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, tabData) == null) {
            }
        }

        @Override // com.baidu.ala.view.ScrollHorizontalTabView.ScrollTabPageListener
        public boolean onPrePageSelect(int i, TabData tabData) {
            InterceptResult invokeIL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeIL = interceptable.invokeIL(Constants.METHOD_SEND_USER_MSG, this, i, tabData)) == null) {
                return true;
            }
            return invokeIL.booleanValue;
        }
    }

    /* loaded from: classes2.dex */
    public class f extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ a a;

        /* renamed from: c.a.p0.c0.f.c.h.a$f$a  reason: collision with other inner class name */
        /* loaded from: classes2.dex */
        public class RunnableC0978a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ f a;

            public RunnableC0978a(f fVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {fVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = fVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.a.a.k == null) {
                    return;
                }
                this.a.a.k.d();
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public f(a aVar, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = aVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) {
                c.a.d.f.m.e.a().postDelayed(new RunnableC0978a(this), 500L);
            }
        }
    }

    /* loaded from: classes2.dex */
    public class g extends FragmentPagerAdapter {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public List<LiveTabBaseSubFragment> a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public g(a aVar, FragmentManager fragmentManager, List<LiveTabBaseSubFragment> list) {
            super(fragmentManager);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, fragmentManager, list};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((FragmentManager) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = list;
        }

        public final LiveTabBaseSubFragment b(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i)) == null) {
                if (i < this.a.size()) {
                    return this.a.get(i);
                }
                return null;
            }
            return (LiveTabBaseSubFragment) invokeI.objValue;
        }

        public void c() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || ListUtils.isEmpty(this.a)) {
                return;
            }
            for (int i = 0; i < this.a.size(); i++) {
                LiveTabBaseSubFragment liveTabBaseSubFragment = this.a.get(i);
                if (liveTabBaseSubFragment != null) {
                    liveTabBaseSubFragment.loadData();
                }
            }
        }

        public void d() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || ListUtils.isEmpty(this.a)) {
                return;
            }
            for (int i = 0; i < this.a.size(); i++) {
                LiveTabBaseSubFragment liveTabBaseSubFragment = this.a.get(i);
                if (liveTabBaseSubFragment != null) {
                    liveTabBaseSubFragment.F0();
                }
            }
        }

        public void e(int i) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeI(1048579, this, i) == null) || i < 0 || i >= this.a.size()) {
                return;
            }
            this.a.get(i).n();
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public int getCount() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
                List<LiveTabBaseSubFragment> list = this.a;
                if (list != null) {
                    return list.size();
                }
                return 0;
            }
            return invokeV.intValue;
        }

        @Override // androidx.fragment.app.FragmentPagerAdapter
        public Fragment getItem(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeI = interceptable.invokeI(1048581, this, i)) == null) ? b(i) : (Fragment) invokeI.objValue;
        }
    }

    public a(TbPageContext tbPageContext, FragmentManager fragmentManager, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, fragmentManager, Boolean.valueOf(z)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
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
        this.A = new C0977a(this, 2921442);
        this.B = new b(this, 2001371);
        this.C = new c(this);
        this.D = new f(this, 2921414);
        this.a = tbPageContext;
        this.m = z;
        this.f13004b = tbPageContext.getPageActivity();
        this.o = fragmentManager;
        q();
    }

    public void A(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048576, this, i) == null) {
            int i2 = 0;
            if (i <= 0) {
                i = 0;
            }
            g gVar = this.k;
            if (gVar == null || i < gVar.getCount()) {
                i2 = i;
            }
            NestedNoScrollViewPager nestedNoScrollViewPager = this.j;
            if (nestedNoScrollViewPager != null) {
                nestedNoScrollViewPager.setCurrentItem(i2);
            }
        }
    }

    public void B(h hVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, hVar) == null) {
            i iVar = new i();
            iVar.a = hVar;
            this.f13010h.l(iVar);
            this.f13008f.setVisibility(0);
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
            tabData.tabName = this.f13004b.getResources().getString(R.string.obfuscated_res_0x7f0f1193);
            arrayList.add(tabData);
            TabData tabData2 = new TabData();
            tabData2.tabId = 200;
            tabData2.tabName = this.f13004b.getResources().getString(R.string.obfuscated_res_0x7f0f1196);
            arrayList.add(tabData2);
            if (z) {
                TabData tabData3 = new TabData();
                tabData3.tabId = 400;
                tabData3.tabName = this.f13004b.getResources().getString(R.string.obfuscated_res_0x7f0f118e);
                arrayList.add(tabData3);
            }
            return arrayList;
        }
        return (List) invokeZ.objValue;
    }

    public ViewGroup m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f13005c : (ViewGroup) invokeV.objValue;
    }

    public void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            this.D.setTag(this.a.getUniqueId());
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
            boolean z = c.a.o0.r.j0.b.k().l("key_show_ala_friend_tab", 0) == 1;
            this.j.setOffscreenPageLimit(z ? 2 : 1);
            this.x.add(LiveTabRecomSubFragment.P0(this.m, 1));
            this.x.add(LiveTabYanzhiSubFragment.Q0(this.m));
            if (z) {
                this.x.add(LiveTabFriendSubFragment.U0(this.m));
            }
            g gVar = new g(this, this.o, this.x);
            this.k = gVar;
            this.j.setAdapter(gVar);
            TbPageContext tbPageContext = this.a;
            if (tbPageContext != null && tbPageContext.getPageActivity() != null && this.a.getPageActivity().getIntent() != null) {
                int intExtra = this.a.getPageActivity().getIntent().getIntExtra("locate_type", 0);
                if (intExtra == 17) {
                    this.p = 0;
                } else if (intExtra == 18) {
                    this.p = 1;
                }
            }
            this.i.setViewPager(this.j);
            this.i.setScrollTabPageListener(new e(this));
            this.i.setData(l(z));
        }
    }

    public final void p(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, z) == null) {
            if (z) {
                if (TbSingleton.getInstance().getYYLiveTabConfig() == null || ListUtils.isEmpty(TbSingleton.getInstance().getYYLiveTabConfig().a())) {
                    return;
                }
                List<a.C1440a> a = TbSingleton.getInstance().getYYLiveTabConfig().a();
                this.y.clear();
                this.y.put(this.s, this.f13004b.getResources().getString(R.string.obfuscated_res_0x7f0f1193));
                for (int i = 0; i < a.size(); i++) {
                    this.y.put(a.get(i).a, a.get(i).f19015b);
                }
            } else if (this.y.size() == 0) {
                this.y.put(this.s, this.f13004b.getResources().getString(R.string.obfuscated_res_0x7f0f1193));
                this.y.put(this.t, this.f13004b.getResources().getString(R.string.obfuscated_res_0x7f0f1190));
                this.y.put(this.u, this.f13004b.getResources().getString(R.string.obfuscated_res_0x7f0f1195));
                this.y.put(this.v, this.f13004b.getResources().getString(R.string.obfuscated_res_0x7f0f118f));
                this.y.put(this.w, this.f13004b.getResources().getString(R.string.obfuscated_res_0x7f0f1191));
            }
        }
    }

    public final void q() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            long currentTimeMillis = System.currentTimeMillis();
            try {
                ViewGroup viewGroup = (ViewGroup) LayoutInflater.from(this.f13004b).inflate(R.layout.obfuscated_res_0x7f0d0100, (ViewGroup) null);
                this.f13005c = viewGroup;
                AppBarLayout appBarLayout = (AppBarLayout) viewGroup.findViewById(R.id.obfuscated_res_0x7f0912c7);
                this.f13007e = appBarLayout;
                appBarLayout.addOnOffsetChangedListener((AppBarLayout.OnOffsetChangedListener) new d(this));
                this.f13006d = (ViewGroup) this.f13005c.findViewById(R.id.obfuscated_res_0x7f0912ce);
                this.f13008f = (LinearLayout) this.f13005c.findViewById(R.id.obfuscated_res_0x7f0912c8);
                this.f13009g = (FrameLayout) this.f13005c.findViewById(R.id.obfuscated_res_0x7f091de0);
                ScrollHorizontalTabView scrollHorizontalTabView = (ScrollHorizontalTabView) this.f13005c.findViewById(R.id.obfuscated_res_0x7f0912d4);
                this.i = scrollHorizontalTabView;
                scrollHorizontalTabView.setOnTabClickListener(this.C);
                this.f13010h = new c.a.p0.c0.f.c.h.d(this.a);
                this.j = (NestedNoScrollViewPager) this.f13005c.findViewById(R.id.obfuscated_res_0x7f0912d6);
                j(c.a.p0.c0.f.c.c.e(), false, false);
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, this.f13004b.getResources().getDimensionPixelSize(R.dimen.tbds256));
                if (this.f13010h.k() != null && this.f13010h.k().getParent() == null) {
                    this.f13009g.addView(this.f13010h.k(), layoutParams);
                    this.f13008f.setVisibility(8);
                }
                ((FrameLayout.LayoutParams) this.f13006d.getLayoutParams()).bottomMargin = TbadkCoreApplication.getInst().getMainTabBottomBarHeight();
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
                this.x.add(LiveTabRecomSubFragment.P0(this.m, this.y.keyAt(0)));
                TabData tabData = new TabData();
                tabData.tabId = this.y.keyAt(0);
                tabData.tabName = this.y.valueAt(0);
                arrayList.add(tabData);
                t(this.y.keyAt(0));
                for (int i = 1; i < this.y.size(); i++) {
                    int keyAt = this.y.keyAt(i);
                    this.x.add(LiveTabYYSubFragment.V0(this.m, keyAt));
                    TabData tabData2 = new TabData();
                    tabData2.tabId = keyAt;
                    tabData2.tabName = this.y.valueAt(i);
                    arrayList.add(tabData2);
                    t(keyAt);
                }
                g gVar = new g(this, this.o, this.x);
                this.k = gVar;
                gVar.notifyDataSetChanged();
                this.j.setAdapter(this.k);
                this.j.setOffscreenPageLimit(arrayList.size());
                this.p = 0;
                this.i.setViewPager(this.j);
                this.i.setData(arrayList);
            } finally {
                TTIStats.record("AlaLiveTabView.initYYTabs", System.currentTimeMillis() - currentTimeMillis);
            }
        }
    }

    public void s() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            this.k.c();
        }
    }

    public final void t(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048588, this, i) == null) {
            StatisticItem statisticItem = new StatisticItem(CommonStatisticKey.KEY_LIVE_SECOND_TAB_SHOW);
            statisticItem.param("obj_type", i - this.r);
            TiebaStaticHelper.addYYParam(statisticItem);
            TiebaStatic.log(statisticItem);
        }
    }

    public void u(boolean z) {
        c.a.p0.c0.f.c.h.d dVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048589, this, z) == null) || (dVar = this.f13010h) == null) {
            return;
        }
        dVar.u(z);
    }

    public void v() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            int skinType = TbadkCoreApplication.getInst().getSkinType();
            this.f13010h.m(this.a, skinType);
            this.i.onChangeSkinType(skinType);
            SkinManager.setBackgroundColor(this.f13005c, R.color.CAM_X0202);
            SkinManager.setBackgroundColor(this.i, R.color.CAM_X0202);
        }
    }

    public void w(boolean z) {
        int i;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048591, this, z) == null) && z && (i = this.p) != -1) {
            A(i);
            this.p = -1;
        }
    }

    public void x() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            this.k.e(this.j.getCurrentItem());
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
                    for (int i = 0; i < size; i++) {
                        if (this.x.get(i) != null) {
                            beginTransaction.remove(this.x.get(i));
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
            this.f13006d.setVisibility(z ? 0 : 8);
        }
    }
}
