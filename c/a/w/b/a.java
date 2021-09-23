package c.a.w.b;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import androidx.viewpager.widget.ViewPager;
import c.a.w.b.d.a;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.live.LiveFeedPageSdk;
import com.baidu.live.business.BaiduLiveTabAdapter;
import com.baidu.live.business.adapter.LiveFeedPageConcernAdapter;
import com.baidu.live.business.adapter.LiveFeedPageSubTipAdapter;
import com.baidu.live.business.base.LiveBaseFragment;
import com.baidu.live.business.model.data.LiveBannerEntity;
import com.baidu.live.business.model.data.LiveHostInfo;
import com.baidu.live.business.model.data.LiveTabEntity;
import com.baidu.live.business.util.NetWorkUtils;
import com.baidu.live.business.view.FakeStartLiveButton;
import com.baidu.live.business.view.banner.BannerEntity;
import com.baidu.live.business.view.banner.BannerView;
import com.baidu.live.business.view.emotion.ErrorView;
import com.baidu.live.business.view.emotion.LoadingView;
import com.baidu.live.business.view.smarttab.SmartTabLayout;
import com.baidu.live.business.view.viewpager.NestedNoScrollViewPager;
import com.baidu.live.framework.appbar.AppBarLayout;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bumptech.glide.load.engine.GlideException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
/* loaded from: classes4.dex */
public class a implements c.a.w.e.c.a<c.a.w.b.b.a> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String A;
    public c.a.w.b.d.c.b B;
    public boolean C;
    public boolean D;
    public boolean E;
    public List<LiveTabEntity> F;
    public boolean G;
    public k H;
    public boolean I;
    public boolean J;
    public boolean K;
    public boolean L;
    public a.b M;
    public boolean N;
    public final BroadcastReceiver O;

    /* renamed from: a  reason: collision with root package name */
    public final String f30391a;

    /* renamed from: b  reason: collision with root package name */
    public final int f30392b;

    /* renamed from: c  reason: collision with root package name */
    public Context f30393c;

    /* renamed from: d  reason: collision with root package name */
    public FragmentManager f30394d;

    /* renamed from: e  reason: collision with root package name */
    public View f30395e;

    /* renamed from: f  reason: collision with root package name */
    public View f30396f;

    /* renamed from: g  reason: collision with root package name */
    public AppBarLayout f30397g;

    /* renamed from: h  reason: collision with root package name */
    public NestedNoScrollViewPager f30398h;

    /* renamed from: i  reason: collision with root package name */
    public BaiduLiveTabAdapter f30399i;

    /* renamed from: j  reason: collision with root package name */
    public SmartTabLayout f30400j;
    public RecyclerView k;
    public RecyclerView l;
    public LiveFeedPageSubTipAdapter m;
    public LiveFeedPageConcernAdapter n;
    public FrameLayout o;
    public c.a.w.b.d.a p;
    public BannerView q;
    public LoadingView r;
    public ErrorView s;
    public LinearLayout t;
    public View u;
    public LinearLayout v;
    public TextView w;
    public FakeStartLiveButton x;
    public View y;
    public ImageView z;

    /* renamed from: c.a.w.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C1405a extends BroadcastReceiver {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ a this$0;

        public C1405a(a aVar) {
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
            this.this$0 = aVar;
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, context, intent) == null) {
                boolean b2 = NetWorkUtils.b(context);
                if (!b2 || this.this$0.K) {
                    this.this$0.K = b2;
                    return;
                }
                this.this$0.K = true;
                if (this.this$0.I) {
                    LiveFeedPageSdk.l("网络变化: Tab 可用，Feed 刷新");
                    this.this$0.H();
                    return;
                }
                LiveFeedPageSdk.l("网络变化: 全页面刷新");
                this.this$0.E();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b implements a.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f30401a;

        public b(a aVar) {
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
            this.f30401a = aVar;
        }

        @Override // c.a.w.b.d.a.b
        public void a(c.a.w.b.d.c.c cVar, Map<String, String> map) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, cVar, map) == null) {
                if (cVar == null) {
                    b(-100, "数据解析失败", map);
                } else if ("follow".equals(cVar.f30431d)) {
                    this.f30401a.y(cVar.f30433f);
                } else {
                    this.f30401a.u(cVar);
                }
            }
        }

        @Override // c.a.w.b.d.a.b
        public void b(int i2, String str, Map<String, String> map) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeILL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, str, map) == null) || map == null || TextUtils.isEmpty(map.get("resource")) || !TextUtils.equals("banner,tab,feed,follow,config", map.get("resource"))) {
                return;
            }
            c.a.w.b.d.c.c cVar = new c.a.w.b.d.c.c();
            cVar.a("banner,tab,feed,follow,config", i2, str);
            this.f30401a.u(cVar);
        }
    }

    /* loaded from: classes4.dex */
    public class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f30402e;

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
            this.f30402e = aVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f30402e.z();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class d implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f30403e;

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
            this.f30403e = aVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view) == null) && (this.f30403e.f30393c instanceof Activity) && !((Activity) this.f30403e.f30393c).isFinishing()) {
                ((Activity) this.f30403e.f30393c).finish();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class e implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f30404e;

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
                    return;
                }
            }
            this.f30404e = aVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f30404e.z();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class f implements ViewPager.OnPageChangeListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f30405e;

        public f(a aVar) {
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
            this.f30405e = aVar;
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i2) == null) {
            }
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i2, float f2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Integer.valueOf(i2), Float.valueOf(f2), Integer.valueOf(i3)}) == null) {
            }
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageSelected(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2) == null) {
                LiveFeedPageSdk.l("二级 tab 滑动/点击切换：" + i2);
                int a2 = c.a.w.b.f.f.a();
                if (this.f30405e.f30399i.getItem(a2) instanceof LiveBaseFragment) {
                    ((LiveBaseFragment) this.f30405e.f30399i.getItem(a2)).onSelectedChanged(false);
                }
                c.a.w.b.f.f.c(i2);
                if (this.f30405e.f30399i.getItem(i2) instanceof LiveBaseFragment) {
                    ((LiveBaseFragment) this.f30405e.f30399i.getItem(i2)).onSelectedChanged(true);
                }
                this.f30405e.A(i2);
                this.f30405e.f30400j.onDarkModeChange("day");
                this.f30405e.f30400j.setScrollLineVisibility(i2);
                this.f30405e.f30399i.externalRefresh(i2, true, true);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class g implements SmartTabLayout.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f30406a;

        public g(a aVar) {
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
            this.f30406a = aVar;
        }

        @Override // com.baidu.live.business.view.smarttab.SmartTabLayout.e
        public void a(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i2) == null) {
                LiveFeedPageSdk.l("二级 tab 点击：" + i2 + "   current：" + this.f30406a.f30398h.getCurrentItem());
                if (this.f30406a.f30398h.getCurrentItem() == i2) {
                    this.f30406a.f30399i.externalRefresh(i2, true, true);
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class h implements LiveFeedPageSubTipAdapter.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f30407a;

        public h(a aVar) {
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
            this.f30407a = aVar;
        }

        @Override // com.baidu.live.business.adapter.LiveFeedPageSubTipAdapter.b
        public void a(View view, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, view, i2) == null) {
                int selectPos = this.f30407a.m.getSelectPos();
                LiveFeedPageSdk.l("三级 Tab 点击 pre: " + selectPos + GlideException.IndentedAppendable.INDENT + i2);
                this.f30407a.m.setSelectPos(i2);
                this.f30407a.m.notifyDataSetChanged();
                if (this.f30407a.f30399i == null || this.f30407a.f30398h == null) {
                    return;
                }
                if (selectPos != i2) {
                    this.f30407a.f30399i.onHintLog(this.f30407a.f30398h.getCurrentItem());
                }
                this.f30407a.S();
                if (selectPos != i2) {
                    this.f30407a.f30399i.onShowLog(this.f30407a.f30398h.getCurrentItem());
                }
                this.f30407a.f30399i.externalRefresh(this.f30407a.f30398h.getCurrentItem(), true, selectPos == i2);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class i implements ErrorView.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f30408a;

        public i(a aVar) {
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
            this.f30408a = aVar;
        }

        @Override // com.baidu.live.business.view.emotion.ErrorView.b
        public void a(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                a aVar = this.f30408a;
                aVar.Q(aVar.r);
                if (this.f30408a.p != null) {
                    this.f30408a.p.g();
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class j implements BannerView.h {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f30409a;

        public j(a aVar) {
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
            this.f30409a = aVar;
        }

        @Override // com.baidu.live.business.view.banner.BannerView.h
        public void a(LiveBannerEntity liveBannerEntity) {
            LiveBannerEntity.b bVar;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, liveBannerEntity) == null) {
                if (liveBannerEntity != null && (bVar = liveBannerEntity.cmdInfo) != null && !c.a.w.e.g.j.a(bVar.f40849a)) {
                    LiveHostInfo liveHostInfo = liveBannerEntity.hostInfo;
                    c.a.w.b.c.a.e(this.f30409a.f30393c, this.f30409a.f30391a, liveBannerEntity.position, liveBannerEntity.roomId, liveBannerEntity.nid, liveBannerEntity.bannerType, liveHostInfo == null ? "" : liveHostInfo.uk, this.f30409a.G ? "chenjinshi" : "zhibopindao", liveBannerEntity.statInfo);
                    LiveFeedPageSdk.e().f().invokeScheme(this.f30409a.f30393c, liveBannerEntity.cmdInfo.f40849a);
                    return;
                }
                LiveFeedPageSdk.e().f().c(this.f30409a.f30393c, this.f30409a.f30393c.getResources().getString(c.a.w.c.a.e.live_feed_page_no_banner_configured));
            }
        }
    }

    public a(Context context, int i2, FragmentManager fragmentManager, String str, String str2, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, Integer.valueOf(i2), fragmentManager, str, str2, Boolean.valueOf(z)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.D = true;
        this.E = false;
        this.F = new ArrayList();
        this.H = new k(null);
        this.L = false;
        this.M = new b(this);
        this.N = false;
        this.O = new C1405a(this);
        this.f30393c = context;
        this.f30391a = str2;
        this.f30394d = fragmentManager;
        this.A = str;
        this.L = z;
        this.H.f30411b = System.currentTimeMillis();
        this.G = "immersion".equals(this.A);
        this.f30392b = i2;
        c.a.w.e.c.d.a().d(this, c.a.w.b.b.b.class, this);
        c.a.w.e.c.d.a().d(this, c.a.w.b.b.d.class, this);
        c.a.w.e.c.d.a().d(this, c.a.w.b.b.c.class, this);
        D();
        c.a.w.b.d.a aVar = new c.a.w.b.d.a(this.f30393c, this.G, this.f30391a);
        this.p = aVar;
        aVar.i(this.M);
    }

    public final void A(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048576, this, i2) == null) {
            if (!c.a.w.e.g.d.c(this.F)) {
                if (i2 >= 0 && i2 < this.F.size()) {
                    List<LiveTabEntity.TabLabelInfo> list = this.F.get(i2).subTabList;
                    if (!c.a.w.e.g.d.c(list)) {
                        this.m.setSubTabList(list);
                        S();
                        this.k.setVisibility(0);
                    } else {
                        this.k.setVisibility(8);
                    }
                }
            } else {
                this.k.setVisibility(8);
            }
            int i3 = this.G ? 85 : 81;
            boolean z = this.G;
            this.t.setMinimumHeight(c.a.w.b.f.a.a(this.f30393c, this.k.getVisibility() == 0 ? i3 : 42));
        }
    }

    public final void B(c.a.w.b.d.c.c cVar) {
        c.a.w.b.d.c.g gVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, cVar) == null) || cVar == null) {
            return;
        }
        c.a.w.b.f.f.b();
        if (this.N || (gVar = cVar.f30434g) == null || c.a.w.e.g.d.c(gVar.f30452c)) {
            return;
        }
        this.N = true;
        List<LiveTabEntity> list = cVar.f30434g.f30452c;
        this.F = list;
        int size = list.size();
        int i2 = 0;
        int i3 = 0;
        while (true) {
            if (i3 >= size) {
                break;
            } else if (this.F.get(i3).selected) {
                i2 = i3;
                break;
            } else {
                i3++;
            }
        }
        this.f30399i.setTabList(this.F, cVar.f30435h);
        this.f30400j.setViewPager(this.f30398h);
        if (!c.a.w.e.g.d.c(this.F)) {
            c.a.w.b.f.f.c(i2);
            this.f30398h.setCurrentItem(i2);
        }
        this.f30399i.selectDefault(i2);
        if (cVar.f30434g.f30453d) {
            Context context = this.f30393c;
            String str = this.f30391a;
            String m = c.a.w.b.c.a.m(this.G);
            c.a.w.b.d.c.g gVar2 = cVar.f30434g;
            c.a.w.b.c.a.o(context, str, m, gVar2.f30450a, gVar2.f30451b, cVar.f30430c, cVar.f30431d, "", "", "", gVar2.f30455f, "tab", gVar2.f30454e, System.currentTimeMillis(), 1);
        }
    }

    public final void C() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            BannerView bannerView = new BannerView(this.f30393c);
            this.q = bannerView;
            bannerView.setShowRoundPicture(true, 10);
            this.q.setIndicatorGravity(81);
            this.q.setIndicatorMargin(0, 0, 0, (int) c.a.w.b.f.a.b(this.f30393c.getResources(), 7.0f));
            this.q.setLargeIndicatorItemSize((int) c.a.w.b.f.a.b(this.f30393c.getResources(), 4.0f));
            this.q.setSmallIndicatorItemSize((int) c.a.w.b.f.a.b(this.f30393c.getResources(), 4.0f));
            this.q.setIndicatorInterval((int) c.a.w.b.f.a.b(this.f30393c.getResources(), 6.0f));
            this.q.setAspectRatio(0.336f);
            this.q.setIsImmersion(this.G);
            this.q.setSource(this.f30391a);
            this.q.setOnBannerClickListener(new j(this));
            this.o.addView(this.q, new FrameLayout.LayoutParams(-1, -1));
        }
    }

    public final void D() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            View inflate = LayoutInflater.from(this.f30393c).inflate(c.a.w.c.a.d.live_feed_page_tab_layout, (ViewGroup) null);
            this.f30395e = inflate;
            this.f30396f = inflate.findViewById(c.a.w.c.a.c.live_tab_root_container);
            this.f30397g = (AppBarLayout) this.f30395e.findViewById(c.a.w.c.a.c.live_tab_appbar_layout);
            this.o = (FrameLayout) this.f30395e.findViewById(c.a.w.c.a.c.live_tab_content_container);
            this.f30400j = (SmartTabLayout) this.f30395e.findViewById(c.a.w.c.a.c.live_tab_top_tab_layout);
            this.k = (RecyclerView) this.f30395e.findViewById(c.a.w.c.a.c.live_tab_top_tab_sub_tag_layout);
            this.l = (RecyclerView) this.f30395e.findViewById(c.a.w.c.a.c.live_tab_top_concern_list_layout);
            this.t = (LinearLayout) this.f30395e.findViewById(c.a.w.c.a.c.live_tab_base_container);
            this.u = this.f30395e.findViewById(c.a.w.c.a.c.live_tab_top_space_layout);
            this.v = (LinearLayout) this.f30395e.findViewById(c.a.w.c.a.c.live_tab_top_start_live_layout);
            this.w = (TextView) this.f30395e.findViewById(c.a.w.c.a.c.live_tab_top_start_live_tv);
            this.y = this.f30395e.findViewById(c.a.w.c.a.c.live_tab_top_tab_divider_view);
            FakeStartLiveButton fakeStartLiveButton = (FakeStartLiveButton) this.f30395e.findViewById(c.a.w.c.a.c.live_feed_page_fake_start_live_id);
            this.x = fakeStartLiveButton;
            fakeStartLiveButton.setOnClickListener(new c(this));
            ImageView imageView = (ImageView) this.f30395e.findViewById(c.a.w.c.a.c.live_feed_page_imm_back_btn);
            this.z = imageView;
            imageView.setOnClickListener(new d(this));
            this.z.setVisibility(this.G ? 0 : 8);
            if (this.G && c.a.w.e.g.c.a()) {
                this.f30395e.setPadding(0, c.a.w.e.g.c.d(this.f30393c), 0, 0);
            }
            this.v.setVisibility((!"haokan".equals(LiveFeedPageSdk.e().d()) || this.G || this.L) ? 8 : 0);
            this.v.setOnClickListener(new e(this));
            this.y.setVisibility(this.G ? 0 : 8);
            StaggeredGridLayoutManager staggeredGridLayoutManager = new StaggeredGridLayoutManager(1, 0);
            staggeredGridLayoutManager.setOrientation(0);
            this.k.setLayoutManager(staggeredGridLayoutManager);
            StaggeredGridLayoutManager staggeredGridLayoutManager2 = new StaggeredGridLayoutManager(1, 0);
            staggeredGridLayoutManager2.setOrientation(0);
            this.l.setLayoutManager(staggeredGridLayoutManager2);
            NestedNoScrollViewPager nestedNoScrollViewPager = (NestedNoScrollViewPager) this.f30395e.findViewById(c.a.w.c.a.c.live_tab_view_pager);
            this.f30398h = nestedNoScrollViewPager;
            nestedNoScrollViewPager.setId(View.generateViewId());
            this.f30398h.setOffscreenPageLimit(1);
            this.f30398h.setSaveEnabled(false);
            if ("immersion".equals(this.A)) {
                this.f30398h.setCanScrollHorizontally(true);
            }
            this.f30400j.setOnPageChangeListener(new f(this));
            this.f30400j.setOnTabClickListener(new g(this));
            BaiduLiveTabAdapter baiduLiveTabAdapter = new BaiduLiveTabAdapter(this.f30394d, this.f30392b, this.G, this.f30391a);
            this.f30399i = baiduLiveTabAdapter;
            this.f30398h.setAdapter(baiduLiveTabAdapter);
            this.f30400j.setAllTabIsBold(false);
            this.f30400j.setTabSelectedColorEnable(true);
            this.f30400j.setShowBottomLine(this.G);
            this.f30400j.setDarkModeCompatColor("color_FF33551", "color_1F1F1F");
            this.f30400j.setIsImmersion(this.G);
            LiveFeedPageSubTipAdapter liveFeedPageSubTipAdapter = new LiveFeedPageSubTipAdapter(this.f30393c, this.G);
            this.m = liveFeedPageSubTipAdapter;
            liveFeedPageSubTipAdapter.setOnItemClickListener(new h(this));
            this.k.setAdapter(this.m);
            if (this.G) {
                RecyclerView recyclerView = this.k;
                if (recyclerView != null) {
                    recyclerView.setPadding(0, c.a.w.b.f.a.a(this.f30393c, 11.0f), 0, c.a.w.b.f.a.a(this.f30393c, 8.0f));
                }
                RecyclerView recyclerView2 = this.l;
                if (recyclerView2 != null) {
                    recyclerView2.setPadding(0, 0, 0, c.a.w.b.f.a.a(this.f30393c, 9.0f));
                }
            }
            LiveFeedPageConcernAdapter liveFeedPageConcernAdapter = new LiveFeedPageConcernAdapter(this.f30393c, this.G, this.f30391a);
            this.n = liveFeedPageConcernAdapter;
            this.l.setAdapter(liveFeedPageConcernAdapter);
            C();
            LoadingView loadingView = (LoadingView) this.f30395e.findViewById(c.a.w.c.a.c.live_tab_loading);
            this.r = loadingView;
            loadingView.onDarkModeChange(this.G);
            Q(this.r);
            ErrorView errorView = (ErrorView) this.f30395e.findViewById(c.a.w.c.a.c.live_tab_error);
            this.s = errorView;
            errorView.setActionCallback(new i(this));
            F("day");
        }
    }

    public void E() {
        c.a.w.b.d.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || (aVar = this.p) == null) {
            return;
        }
        aVar.g();
    }

    public void F(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, str) == null) {
            View view = this.f30395e;
            if (view != null) {
                view.setBackgroundColor(c.a.w.i.f.e().a(this.f30393c, this.G, "color_white1"));
            }
            View view2 = this.u;
            if (view2 != null) {
                view2.setBackgroundColor(c.a.w.i.f.e().a(this.f30393c, this.G, "color_F5F5F52"));
            }
            TextView textView = this.w;
            if (textView != null) {
                textView.setTextColor(c.a.w.i.f.e().a(this.f30393c, this.G, "color_1F1F1F"));
            }
            BaiduLiveTabAdapter baiduLiveTabAdapter = this.f30399i;
            if (baiduLiveTabAdapter != null) {
                baiduLiveTabAdapter.onDarkModeChange(str);
            }
            ErrorView errorView = this.s;
            if (errorView != null) {
                errorView.onDarkModeChange(this.G);
            }
            LoadingView loadingView = this.r;
            if (loadingView != null) {
                loadingView.onDarkModeChange(this.G);
            }
            BannerView bannerView = this.q;
            if (bannerView != null) {
                bannerView.onDarkModeChange(str);
            }
            LiveFeedPageConcernAdapter liveFeedPageConcernAdapter = this.n;
            if (liveFeedPageConcernAdapter != null) {
                liveFeedPageConcernAdapter.notifyDataSetChanged();
            }
            LiveFeedPageSubTipAdapter liveFeedPageSubTipAdapter = this.m;
            if (liveFeedPageSubTipAdapter != null) {
                liveFeedPageSubTipAdapter.notifyDataSetChanged();
            }
            SmartTabLayout smartTabLayout = this.f30400j;
            if (smartTabLayout != null) {
                smartTabLayout.onDarkModeChange(str);
            }
        }
    }

    public void G() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            c.a.w.e.c.d.a().e(this);
            R();
            BannerView bannerView = this.q;
            if (bannerView != null) {
                bannerView.onDestory();
            }
            LoadingView loadingView = this.r;
            if (loadingView != null) {
                loadingView.destroy();
            }
            this.D = true;
            c.a.w.b.f.f.b();
            BaiduLiveTabAdapter baiduLiveTabAdapter = this.f30399i;
            if (baiduLiveTabAdapter != null) {
                baiduLiveTabAdapter.onDestroy();
            }
            this.L = false;
        }
    }

    public void H() {
        BaiduLiveTabAdapter baiduLiveTabAdapter;
        NestedNoScrollViewPager nestedNoScrollViewPager;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048583, this) == null) || (baiduLiveTabAdapter = this.f30399i) == null || (nestedNoScrollViewPager = this.f30398h) == null) {
            return;
        }
        baiduLiveTabAdapter.externalRefresh(nestedNoScrollViewPager.getCurrentItem(), true, true);
    }

    public final void I() {
        BaiduLiveTabAdapter baiduLiveTabAdapter;
        NestedNoScrollViewPager nestedNoScrollViewPager;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) || (baiduLiveTabAdapter = this.f30399i) == null || (nestedNoScrollViewPager = this.f30398h) == null) {
            return;
        }
        baiduLiveTabAdapter.onHintLog(nestedNoScrollViewPager.getCurrentItem());
    }

    public final void J() {
        NestedNoScrollViewPager nestedNoScrollViewPager;
        NestedNoScrollViewPager nestedNoScrollViewPager2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            BaiduLiveTabAdapter baiduLiveTabAdapter = this.f30399i;
            if (baiduLiveTabAdapter != null && (nestedNoScrollViewPager2 = this.f30398h) != null) {
                baiduLiveTabAdapter.onShowLog(nestedNoScrollViewPager2.getCurrentItem());
            }
            if (this.H.a()) {
                BaiduLiveTabAdapter baiduLiveTabAdapter2 = this.f30399i;
                if (baiduLiveTabAdapter2 != null && (nestedNoScrollViewPager = this.f30398h) != null) {
                    baiduLiveTabAdapter2.externalRefresh(nestedNoScrollViewPager.getCurrentItem(), true, true);
                }
            } else {
                c.a.w.b.d.a aVar = this.p;
                if (aVar != null && !this.D) {
                    aVar.f();
                }
            }
            this.D = false;
        }
    }

    public void K() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            LoadingView loadingView = this.r;
            if (loadingView != null) {
                loadingView.onPause();
            }
            r();
        }
    }

    public void L() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            LoadingView loadingView = this.r;
            if (loadingView != null) {
                loadingView.onResume();
            }
            s();
        }
    }

    public void M(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048588, this, z) == null) {
            LiveFeedPageSdk.l("onUserVisibleHint " + this.D + " " + z);
            if (this.C == z) {
                return;
            }
            this.C = z;
            if (z) {
                J();
                P();
                return;
            }
            I();
            R();
        }
    }

    public final void N(c.a.w.b.d.c.a aVar) {
        BannerView bannerView;
        FrameLayout frameLayout;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048589, this, aVar) == null) || (bannerView = this.q) == null || (frameLayout = this.o) == null) {
            return;
        }
        if (this.G) {
            frameLayout.setVisibility(8);
            this.q.setVisibility(8);
            r();
            this.E = false;
            return;
        }
        if (aVar != null) {
            if (!c.a.w.e.g.d.c(aVar.f30425a)) {
                List<LiveBannerEntity> list = aVar.f30425a;
                if (this.q.isBannerNeedUpdate(list)) {
                    BannerEntity bannerEntity = new BannerEntity();
                    bannerEntity.mBannerList = list;
                    bannerEntity.mBroadcastInterval = 5000;
                    this.q.setBannerEntity(bannerEntity);
                }
                this.q.setVisibility(0);
                this.E = true;
            } else {
                this.E = false;
                this.q.setVisibility(8);
            }
        } else {
            this.E = false;
            bannerView.setVisibility(8);
        }
        this.o.setVisibility(this.q.getVisibility() != 0 ? 8 : 0);
    }

    public final void O() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048590, this) == null) || this.u == null) {
            return;
        }
        RecyclerView recyclerView = this.l;
        boolean z = true;
        if (recyclerView != null && recyclerView.getVisibility() != 0) {
            z = false;
        }
        if (z && !this.G) {
            this.u.setVisibility(0);
        } else {
            this.u.setVisibility(8);
        }
    }

    public final void P() {
        Context context;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048591, this) == null) || (context = this.f30393c) == null || this.J) {
            return;
        }
        this.K = NetWorkUtils.b(context);
        LiveFeedPageSdk.l("注册网络变化广播");
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
        this.f30393c.registerReceiver(this.O, intentFilter);
        this.J = true;
    }

    public void Q(View view) {
        ErrorView errorView;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, view) == null) {
            ErrorView errorView2 = this.s;
            int i2 = 8;
            if (errorView2 != null) {
                errorView2.toggleVisible(view == errorView2 ? 0 : 8, this.G);
            }
            LoadingView loadingView = this.r;
            if (loadingView != null) {
                loadingView.setVisibility(view == loadingView ? 0 : 8);
            }
            View view2 = this.f30396f;
            if (view2 != null) {
                view2.setVisibility(view == view2 ? 0 : 4);
            }
            FakeStartLiveButton fakeStartLiveButton = this.x;
            if (fakeStartLiveButton == null || (errorView = this.s) == null) {
                return;
            }
            if (errorView.getVisibility() == 0 && "haokan".equals(LiveFeedPageSdk.e().d()) && !this.L) {
                i2 = 0;
            }
            fakeStartLiveButton.setVisibility(i2);
        }
    }

    public final void R() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048593, this) == null) && this.f30393c != null && this.J) {
            LiveFeedPageSdk.l("解注册网络变化广播");
            this.f30393c.unregisterReceiver(this.O);
            this.J = false;
        }
    }

    public final void S() {
        BaiduLiveTabAdapter baiduLiveTabAdapter;
        NestedNoScrollViewPager nestedNoScrollViewPager;
        LiveTabEntity subTab;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048594, this) == null) || (baiduLiveTabAdapter = this.f30399i) == null || (nestedNoScrollViewPager = this.f30398h) == null || (subTab = baiduLiveTabAdapter.getSubTab(nestedNoScrollViewPager.getCurrentItem())) == null || TextUtils.isEmpty(subTab.type)) {
            return;
        }
        LiveTabEntity.TabLabelInfo selectSubTabInfo = this.m.getSelectSubTabInfo();
        this.f30399i.updateTabInfo(subTab.type, selectSubTabInfo != null ? selectSubTabInfo.type : "", this.f30398h.getCurrentItem());
    }

    public final void r() {
        BannerView bannerView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048596, this) == null) && (bannerView = this.q) != null && this.E) {
            bannerView.onPause();
        }
    }

    public final void s() {
        BannerView bannerView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048597, this) == null) && (bannerView = this.q) != null && this.E) {
            bannerView.onResume();
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.a.w.e.c.a
    /* renamed from: t */
    public void call(c.a.w.b.b.a aVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048598, this, aVar) == null) && aVar != null && aVar.a() == this.f30392b) {
            LiveFeedPageSdk.l("LiveEventBus event: " + aVar.getClass() + GlideException.IndentedAppendable.INDENT + aVar.a());
            if (aVar instanceof c.a.w.b.b.b) {
                c.a.w.b.d.c.a aVar2 = ((c.a.w.b.b.b) aVar).f30413b;
                if (aVar2 != null) {
                    N(aVar2);
                }
            } else if (aVar instanceof c.a.w.b.b.d) {
                c.a.w.b.d.c.e eVar = ((c.a.w.b.b.d) aVar).f30414b;
                if (eVar != null) {
                    y(eVar);
                }
            } else if (aVar instanceof c.a.w.b.b.c) {
                this.H.c();
            }
        }
    }

    public final void u(c.a.w.b.d.c.c cVar) {
        c.a.w.b.d.c.g gVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048599, this, cVar) == null) {
            if (cVar != null && (gVar = cVar.f30434g) != null && !c.a.w.e.g.d.c(gVar.f30452c)) {
                x(cVar);
                Q(this.f30396f);
                this.I = true;
                if (cVar.f30434g.f30453d) {
                    return;
                }
                this.H.c();
                return;
            }
            Q(this.s);
            this.I = false;
        }
    }

    public View v() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) ? this.f30395e : (View) invokeV.objValue;
    }

    public final void w(c.a.w.b.d.c.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048601, this, bVar) == null) {
            this.B = bVar;
            if (bVar != null) {
                this.H.b(bVar.f30427b * 1000);
            }
        }
    }

    public final void x(c.a.w.b.d.c.c cVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048602, this, cVar) == null) || cVar == null) {
            return;
        }
        w(cVar.f30436i);
        N(cVar.f30432e);
        B(cVar);
        A(c.a.w.b.f.f.a());
        y(cVar.f30433f);
    }

    public final void y(c.a.w.b.d.c.e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048603, this, eVar) == null) {
            if (eVar != null) {
                if (!c.a.w.e.g.d.c(eVar.f30444a)) {
                    this.n.setConcernList(eVar.f30444a);
                    this.l.setVisibility(0);
                } else {
                    this.n.setConcernList(new ArrayList());
                    this.l.setVisibility(8);
                }
            }
            O();
        }
    }

    public final void z() {
        String c2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048604, this) == null) || LiveFeedPageSdk.e().f() == null) {
            return;
        }
        c.a.w.b.d.c.b bVar = this.B;
        if (bVar != null && !TextUtils.isEmpty(bVar.f30426a)) {
            c2 = this.B.f30426a;
        } else {
            c2 = LiveFeedPageSdk.e().c();
        }
        LiveFeedPageSdk.e().f().invokeScheme(this.f30393c, c2);
    }

    /* loaded from: classes4.dex */
    public static class k {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public long f30410a;

        /* renamed from: b  reason: collision with root package name */
        public long f30411b;

        public k() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f30410a = 180000L;
        }

        public boolean a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                LiveFeedPageSdk.l("onShow   " + (System.currentTimeMillis() - this.f30411b));
                return System.currentTimeMillis() - this.f30411b > this.f30410a;
            }
            return invokeV.booleanValue;
        }

        public void b(long j2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j2) == null) || j2 <= 0) {
                return;
            }
            this.f30410a = j2;
        }

        public void c() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                this.f30411b = System.currentTimeMillis();
            }
        }

        public /* synthetic */ k(b bVar) {
            this();
        }
    }
}
