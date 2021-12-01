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
/* loaded from: classes7.dex */
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
    public final String a;

    /* renamed from: b  reason: collision with root package name */
    public final int f26549b;

    /* renamed from: c  reason: collision with root package name */
    public Context f26550c;

    /* renamed from: d  reason: collision with root package name */
    public FragmentManager f26551d;

    /* renamed from: e  reason: collision with root package name */
    public View f26552e;

    /* renamed from: f  reason: collision with root package name */
    public View f26553f;

    /* renamed from: g  reason: collision with root package name */
    public AppBarLayout f26554g;

    /* renamed from: h  reason: collision with root package name */
    public NestedNoScrollViewPager f26555h;

    /* renamed from: i  reason: collision with root package name */
    public BaiduLiveTabAdapter f26556i;

    /* renamed from: j  reason: collision with root package name */
    public SmartTabLayout f26557j;

    /* renamed from: k  reason: collision with root package name */
    public RecyclerView f26558k;
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
    /* loaded from: classes7.dex */
    public class C1514a extends BroadcastReceiver {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ a this$0;

        public C1514a(a aVar) {
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
                    this.this$0.G();
                    return;
                }
                LiveFeedPageSdk.l("网络变化: 全页面刷新");
                this.this$0.D();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b implements a.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ a a;

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
            this.a = aVar;
        }

        @Override // c.a.w.b.d.a.b
        public void a(c.a.w.b.d.c.c cVar, Map<String, String> map) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, cVar, map) == null) {
                if (cVar == null) {
                    b(-100, "数据解析失败", map);
                } else if ("follow".equals(cVar.f26575d)) {
                    this.a.x(cVar.f26577f);
                } else {
                    this.a.t(cVar);
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
            this.a.t(cVar);
        }
    }

    /* loaded from: classes7.dex */
    public class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f26559e;

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
            this.f26559e = aVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f26559e.y();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class d implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f26560e;

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
            this.f26560e = aVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view) == null) && (this.f26560e.f26550c instanceof Activity) && !((Activity) this.f26560e.f26550c).isFinishing()) {
                ((Activity) this.f26560e.f26550c).finish();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class e implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f26561e;

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
            this.f26561e = aVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f26561e.y();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class f implements ViewPager.OnPageChangeListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f26562e;

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
            this.f26562e = aVar;
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
                int a = c.a.w.b.f.f.a();
                if (this.f26562e.f26556i.getItem(a) instanceof LiveBaseFragment) {
                    ((LiveBaseFragment) this.f26562e.f26556i.getItem(a)).onSelectedChanged(false);
                }
                c.a.w.b.f.f.c(i2);
                if (this.f26562e.f26556i.getItem(i2) instanceof LiveBaseFragment) {
                    ((LiveBaseFragment) this.f26562e.f26556i.getItem(i2)).onSelectedChanged(true);
                }
                this.f26562e.z(i2);
                this.f26562e.f26557j.onDarkModeChange("day");
                this.f26562e.f26557j.setScrollLineVisibility(i2);
                this.f26562e.f26556i.externalRefresh(i2, true, true);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class g implements SmartTabLayout.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ a a;

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
            this.a = aVar;
        }

        @Override // com.baidu.live.business.view.smarttab.SmartTabLayout.e
        public void a(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i2) == null) {
                LiveFeedPageSdk.l("二级 tab 点击：" + i2 + "   current：" + this.a.f26555h.getCurrentItem());
                if (this.a.f26555h.getCurrentItem() == i2) {
                    this.a.f26556i.externalRefresh(i2, true, true);
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class h implements LiveFeedPageSubTipAdapter.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ a a;

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
            this.a = aVar;
        }

        @Override // com.baidu.live.business.adapter.LiveFeedPageSubTipAdapter.b
        public void a(View view, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, view, i2) == null) {
                int selectPos = this.a.m.getSelectPos();
                LiveFeedPageSdk.l("三级 Tab 点击 pre: " + selectPos + GlideException.IndentedAppendable.INDENT + i2);
                this.a.m.setSelectPos(i2);
                this.a.m.notifyDataSetChanged();
                if (this.a.f26556i == null || this.a.f26555h == null) {
                    return;
                }
                if (selectPos != i2) {
                    this.a.f26556i.onHintLog(this.a.f26555h.getCurrentItem());
                }
                this.a.R();
                if (selectPos != i2) {
                    this.a.f26556i.onShowLog(this.a.f26555h.getCurrentItem());
                }
                this.a.f26556i.externalRefresh(this.a.f26555h.getCurrentItem(), true, selectPos == i2);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class i implements ErrorView.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ a a;

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
            this.a = aVar;
        }

        @Override // com.baidu.live.business.view.emotion.ErrorView.b
        public void a(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                a aVar = this.a;
                aVar.P(aVar.r);
                if (this.a.p != null) {
                    this.a.p.g();
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class j implements BannerView.h {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ a a;

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
            this.a = aVar;
        }

        @Override // com.baidu.live.business.view.banner.BannerView.h
        public void a(LiveBannerEntity liveBannerEntity) {
            LiveBannerEntity.b bVar;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, liveBannerEntity) == null) {
                if (liveBannerEntity != null && (bVar = liveBannerEntity.cmdInfo) != null && !c.a.w.e.g.j.a(bVar.a)) {
                    LiveHostInfo liveHostInfo = liveBannerEntity.hostInfo;
                    c.a.w.b.c.a.e(this.a.f26550c, this.a.a, liveBannerEntity.position, liveBannerEntity.roomId, liveBannerEntity.nid, liveBannerEntity.bannerType, liveHostInfo == null ? "" : liveHostInfo.uk, this.a.G ? "chenjinshi" : "zhibopindao", liveBannerEntity.statInfo);
                    LiveFeedPageSdk.e().f().invokeScheme(this.a.f26550c, liveBannerEntity.cmdInfo.a);
                    return;
                }
                LiveFeedPageSdk.e().f().a(this.a.f26550c, this.a.f26550c.getResources().getString(c.a.w.c.a.e.live_feed_page_no_banner_configured));
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
        this.O = new C1514a(this);
        this.f26550c = context;
        this.a = str2;
        this.f26551d = fragmentManager;
        this.A = str;
        this.L = z;
        this.H.f26563b = System.currentTimeMillis();
        this.G = "immersion".equals(this.A);
        this.f26549b = i2;
        c.a.w.e.c.d.a().d(this, c.a.w.b.b.b.class, this);
        c.a.w.e.c.d.a().d(this, c.a.w.b.b.d.class, this);
        c.a.w.e.c.d.a().d(this, c.a.w.b.b.c.class, this);
        C();
        c.a.w.b.d.a aVar = new c.a.w.b.d.a(this.f26550c, this.G, this.a);
        this.p = aVar;
        aVar.i(this.M);
    }

    public final void A(c.a.w.b.d.c.c cVar) {
        c.a.w.b.d.c.g gVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, cVar) == null) || cVar == null) {
            return;
        }
        c.a.w.b.f.f.b();
        if (this.N || (gVar = cVar.f26578g) == null || c.a.w.e.g.d.c(gVar.f26592c)) {
            return;
        }
        this.N = true;
        List<LiveTabEntity> list = cVar.f26578g.f26592c;
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
        this.f26556i.setTabList(this.F, cVar.f26579h);
        this.f26557j.setViewPager(this.f26555h);
        if (!c.a.w.e.g.d.c(this.F)) {
            c.a.w.b.f.f.c(i2);
            this.f26555h.setCurrentItem(i2);
        }
        this.f26556i.selectDefault(i2);
        if (cVar.f26578g.f26593d) {
            Context context = this.f26550c;
            String str = this.a;
            String m = c.a.w.b.c.a.m(this.G);
            c.a.w.b.d.c.g gVar2 = cVar.f26578g;
            c.a.w.b.c.a.o(context, str, m, gVar2.a, gVar2.f26591b, cVar.f26574c, cVar.f26575d, "", "", "", gVar2.f26595f, "tab", gVar2.f26594e, System.currentTimeMillis(), 1);
        }
    }

    public final void B() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            BannerView bannerView = new BannerView(this.f26550c);
            this.q = bannerView;
            bannerView.setShowRoundPicture(true, 10);
            this.q.setIndicatorGravity(81);
            this.q.setIndicatorMargin(0, 0, 0, (int) c.a.w.b.f.a.b(this.f26550c.getResources(), 7.0f));
            this.q.setLargeIndicatorItemSize((int) c.a.w.b.f.a.b(this.f26550c.getResources(), 4.0f));
            this.q.setSmallIndicatorItemSize((int) c.a.w.b.f.a.b(this.f26550c.getResources(), 4.0f));
            this.q.setIndicatorInterval((int) c.a.w.b.f.a.b(this.f26550c.getResources(), 6.0f));
            this.q.setAspectRatio(0.336f);
            this.q.setIsImmersion(this.G);
            this.q.setSource(this.a);
            this.q.setOnBannerClickListener(new j(this));
            this.o.addView(this.q, new FrameLayout.LayoutParams(-1, -1));
        }
    }

    public final void C() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            View inflate = LayoutInflater.from(this.f26550c).inflate(c.a.w.c.a.d.live_feed_page_tab_layout, (ViewGroup) null);
            this.f26552e = inflate;
            this.f26553f = inflate.findViewById(c.a.w.c.a.c.live_tab_root_container);
            this.f26554g = (AppBarLayout) this.f26552e.findViewById(c.a.w.c.a.c.live_tab_appbar_layout);
            this.o = (FrameLayout) this.f26552e.findViewById(c.a.w.c.a.c.live_tab_content_container);
            this.f26557j = (SmartTabLayout) this.f26552e.findViewById(c.a.w.c.a.c.live_tab_top_tab_layout);
            this.f26558k = (RecyclerView) this.f26552e.findViewById(c.a.w.c.a.c.live_tab_top_tab_sub_tag_layout);
            this.l = (RecyclerView) this.f26552e.findViewById(c.a.w.c.a.c.live_tab_top_concern_list_layout);
            this.t = (LinearLayout) this.f26552e.findViewById(c.a.w.c.a.c.live_tab_base_container);
            this.u = this.f26552e.findViewById(c.a.w.c.a.c.live_tab_top_space_layout);
            this.v = (LinearLayout) this.f26552e.findViewById(c.a.w.c.a.c.live_tab_top_start_live_layout);
            this.w = (TextView) this.f26552e.findViewById(c.a.w.c.a.c.live_tab_top_start_live_tv);
            this.y = this.f26552e.findViewById(c.a.w.c.a.c.live_tab_top_tab_divider_view);
            FakeStartLiveButton fakeStartLiveButton = (FakeStartLiveButton) this.f26552e.findViewById(c.a.w.c.a.c.live_feed_page_fake_start_live_id);
            this.x = fakeStartLiveButton;
            fakeStartLiveButton.setOnClickListener(new c(this));
            ImageView imageView = (ImageView) this.f26552e.findViewById(c.a.w.c.a.c.live_feed_page_imm_back_btn);
            this.z = imageView;
            imageView.setOnClickListener(new d(this));
            this.z.setVisibility(this.G ? 0 : 8);
            if (this.G && c.a.w.e.g.c.a()) {
                this.f26552e.setPadding(0, c.a.w.e.g.c.d(this.f26550c), 0, 0);
            }
            this.v.setVisibility((!"haokan".equals(LiveFeedPageSdk.e().d()) || this.G || this.L) ? 8 : 0);
            this.v.setOnClickListener(new e(this));
            this.y.setVisibility(this.G ? 0 : 8);
            StaggeredGridLayoutManager staggeredGridLayoutManager = new StaggeredGridLayoutManager(1, 0);
            staggeredGridLayoutManager.setOrientation(0);
            this.f26558k.setLayoutManager(staggeredGridLayoutManager);
            StaggeredGridLayoutManager staggeredGridLayoutManager2 = new StaggeredGridLayoutManager(1, 0);
            staggeredGridLayoutManager2.setOrientation(0);
            this.l.setLayoutManager(staggeredGridLayoutManager2);
            NestedNoScrollViewPager nestedNoScrollViewPager = (NestedNoScrollViewPager) this.f26552e.findViewById(c.a.w.c.a.c.live_tab_view_pager);
            this.f26555h = nestedNoScrollViewPager;
            nestedNoScrollViewPager.setId(View.generateViewId());
            this.f26555h.setOffscreenPageLimit(1);
            this.f26555h.setSaveEnabled(false);
            if ("immersion".equals(this.A)) {
                this.f26555h.setCanScrollHorizontally(true);
            }
            this.f26557j.setOnPageChangeListener(new f(this));
            this.f26557j.setOnTabClickListener(new g(this));
            BaiduLiveTabAdapter baiduLiveTabAdapter = new BaiduLiveTabAdapter(this.f26551d, this.f26549b, this.G, this.a);
            this.f26556i = baiduLiveTabAdapter;
            this.f26555h.setAdapter(baiduLiveTabAdapter);
            this.f26557j.setAllTabIsBold(false);
            this.f26557j.setTabSelectedColorEnable(true);
            this.f26557j.setShowBottomLine(this.G);
            this.f26557j.setDarkModeCompatColor("color_FF33551", "color_1F1F1F");
            this.f26557j.setIsImmersion(this.G);
            LiveFeedPageSubTipAdapter liveFeedPageSubTipAdapter = new LiveFeedPageSubTipAdapter(this.f26550c, this.G);
            this.m = liveFeedPageSubTipAdapter;
            liveFeedPageSubTipAdapter.setOnItemClickListener(new h(this));
            this.f26558k.setAdapter(this.m);
            if (this.G) {
                RecyclerView recyclerView = this.f26558k;
                if (recyclerView != null) {
                    recyclerView.setPadding(0, c.a.w.b.f.a.a(this.f26550c, 11.0f), 0, c.a.w.b.f.a.a(this.f26550c, 8.0f));
                }
                RecyclerView recyclerView2 = this.l;
                if (recyclerView2 != null) {
                    recyclerView2.setPadding(0, 0, 0, c.a.w.b.f.a.a(this.f26550c, 9.0f));
                }
            }
            LiveFeedPageConcernAdapter liveFeedPageConcernAdapter = new LiveFeedPageConcernAdapter(this.f26550c, this.G, this.a);
            this.n = liveFeedPageConcernAdapter;
            this.l.setAdapter(liveFeedPageConcernAdapter);
            B();
            LoadingView loadingView = (LoadingView) this.f26552e.findViewById(c.a.w.c.a.c.live_tab_loading);
            this.r = loadingView;
            loadingView.onDarkModeChange(this.G);
            P(this.r);
            ErrorView errorView = (ErrorView) this.f26552e.findViewById(c.a.w.c.a.c.live_tab_error);
            this.s = errorView;
            errorView.setActionCallback(new i(this));
            E("day");
        }
    }

    public void D() {
        c.a.w.b.d.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || (aVar = this.p) == null) {
            return;
        }
        aVar.g();
    }

    public void E(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, str) == null) {
            View view = this.f26552e;
            if (view != null) {
                view.setBackgroundColor(c.a.w.i.f.e().a(this.f26550c, this.G, "color_white1"));
            }
            View view2 = this.u;
            if (view2 != null) {
                view2.setBackgroundColor(c.a.w.i.f.e().a(this.f26550c, this.G, "color_F5F5F52"));
            }
            TextView textView = this.w;
            if (textView != null) {
                textView.setTextColor(c.a.w.i.f.e().a(this.f26550c, this.G, "color_1F1F1F"));
            }
            BaiduLiveTabAdapter baiduLiveTabAdapter = this.f26556i;
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
            SmartTabLayout smartTabLayout = this.f26557j;
            if (smartTabLayout != null) {
                smartTabLayout.onDarkModeChange(str);
            }
        }
    }

    public void F() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            c.a.w.e.c.d.a().e(this);
            Q();
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
            BaiduLiveTabAdapter baiduLiveTabAdapter = this.f26556i;
            if (baiduLiveTabAdapter != null) {
                baiduLiveTabAdapter.onDestroy();
            }
            this.L = false;
        }
    }

    public void G() {
        BaiduLiveTabAdapter baiduLiveTabAdapter;
        NestedNoScrollViewPager nestedNoScrollViewPager;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048582, this) == null) || (baiduLiveTabAdapter = this.f26556i) == null || (nestedNoScrollViewPager = this.f26555h) == null) {
            return;
        }
        baiduLiveTabAdapter.externalRefresh(nestedNoScrollViewPager.getCurrentItem(), true, true);
    }

    public final void H() {
        BaiduLiveTabAdapter baiduLiveTabAdapter;
        NestedNoScrollViewPager nestedNoScrollViewPager;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048583, this) == null) || (baiduLiveTabAdapter = this.f26556i) == null || (nestedNoScrollViewPager = this.f26555h) == null) {
            return;
        }
        baiduLiveTabAdapter.onHintLog(nestedNoScrollViewPager.getCurrentItem());
    }

    public final void I() {
        NestedNoScrollViewPager nestedNoScrollViewPager;
        NestedNoScrollViewPager nestedNoScrollViewPager2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            BaiduLiveTabAdapter baiduLiveTabAdapter = this.f26556i;
            if (baiduLiveTabAdapter != null && (nestedNoScrollViewPager2 = this.f26555h) != null) {
                baiduLiveTabAdapter.onShowLog(nestedNoScrollViewPager2.getCurrentItem());
            }
            if (this.H.a()) {
                BaiduLiveTabAdapter baiduLiveTabAdapter2 = this.f26556i;
                if (baiduLiveTabAdapter2 != null && (nestedNoScrollViewPager = this.f26555h) != null) {
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

    public void J() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            LoadingView loadingView = this.r;
            if (loadingView != null) {
                loadingView.onPause();
            }
            r();
        }
    }

    public void K() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            LoadingView loadingView = this.r;
            if (loadingView != null) {
                loadingView.onResume();
            }
            s();
        }
    }

    public void L(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048587, this, z) == null) {
            LiveFeedPageSdk.l("onUserVisibleHint " + this.D + " " + z);
            if (this.C == z) {
                return;
            }
            this.C = z;
            if (z) {
                I();
                O();
                return;
            }
            H();
            Q();
        }
    }

    public final void M(c.a.w.b.d.c.a aVar) {
        BannerView bannerView;
        FrameLayout frameLayout;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048588, this, aVar) == null) || (bannerView = this.q) == null || (frameLayout = this.o) == null) {
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
            if (!c.a.w.e.g.d.c(aVar.a)) {
                List<LiveBannerEntity> list = aVar.a;
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

    public final void N() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048589, this) == null) || this.u == null) {
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

    public final void O() {
        Context context;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048590, this) == null) || (context = this.f26550c) == null || this.J) {
            return;
        }
        this.K = NetWorkUtils.b(context);
        LiveFeedPageSdk.l("注册网络变化广播");
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
        this.f26550c.registerReceiver(this.O, intentFilter);
        this.J = true;
    }

    public void P(View view) {
        ErrorView errorView;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, view) == null) {
            ErrorView errorView2 = this.s;
            int i2 = 8;
            if (errorView2 != null) {
                errorView2.toggleVisible(view == errorView2 ? 0 : 8, this.G);
            }
            LoadingView loadingView = this.r;
            if (loadingView != null) {
                loadingView.setVisibility(view == loadingView ? 0 : 8);
            }
            View view2 = this.f26553f;
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

    public final void Q() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048592, this) == null) && this.f26550c != null && this.J) {
            LiveFeedPageSdk.l("解注册网络变化广播");
            this.f26550c.unregisterReceiver(this.O);
            this.J = false;
        }
    }

    public final void R() {
        BaiduLiveTabAdapter baiduLiveTabAdapter;
        NestedNoScrollViewPager nestedNoScrollViewPager;
        LiveTabEntity subTab;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048593, this) == null) || (baiduLiveTabAdapter = this.f26556i) == null || (nestedNoScrollViewPager = this.f26555h) == null || (subTab = baiduLiveTabAdapter.getSubTab(nestedNoScrollViewPager.getCurrentItem())) == null || TextUtils.isEmpty(subTab.type)) {
            return;
        }
        LiveTabEntity.TabLabelInfo selectSubTabInfo = this.m.getSelectSubTabInfo();
        this.f26556i.updateTabInfo(subTab.type, selectSubTabInfo != null ? selectSubTabInfo.type : "", this.f26555h.getCurrentItem());
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

    public final void t(c.a.w.b.d.c.c cVar) {
        c.a.w.b.d.c.g gVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048598, this, cVar) == null) {
            if (cVar != null && (gVar = cVar.f26578g) != null && !c.a.w.e.g.d.c(gVar.f26592c)) {
                w(cVar);
                P(this.f26553f);
                this.I = true;
                if (cVar.f26578g.f26593d) {
                    return;
                }
                this.H.c();
                return;
            }
            P(this.s);
            this.I = false;
        }
    }

    public View u() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) ? this.f26552e : (View) invokeV.objValue;
    }

    public final void v(c.a.w.b.d.c.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048600, this, bVar) == null) {
            this.B = bVar;
            if (bVar != null) {
                this.H.b(bVar.f26572b * 1000);
            }
        }
    }

    public final void w(c.a.w.b.d.c.c cVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048601, this, cVar) == null) || cVar == null) {
            return;
        }
        v(cVar.f26580i);
        M(cVar.f26576e);
        A(cVar);
        z(c.a.w.b.f.f.a());
        x(cVar.f26577f);
    }

    public final void x(c.a.w.b.d.c.e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048602, this, eVar) == null) {
            if (eVar != null) {
                if (!c.a.w.e.g.d.c(eVar.a)) {
                    this.n.setConcernList(eVar.a);
                    this.l.setVisibility(0);
                } else {
                    this.n.setConcernList(new ArrayList());
                    this.l.setVisibility(8);
                }
            }
            N();
        }
    }

    public final void y() {
        String c2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048603, this) == null) || LiveFeedPageSdk.e().f() == null) {
            return;
        }
        c.a.w.b.d.c.b bVar = this.B;
        if (bVar != null && !TextUtils.isEmpty(bVar.a)) {
            c2 = this.B.a;
        } else {
            c2 = LiveFeedPageSdk.e().c();
        }
        LiveFeedPageSdk.e().f().invokeScheme(this.f26550c, c2);
    }

    public final void z(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048604, this, i2) == null) {
            if (!c.a.w.e.g.d.c(this.F)) {
                if (i2 >= 0 && i2 < this.F.size()) {
                    List<LiveTabEntity.TabLabelInfo> list = this.F.get(i2).subTabList;
                    if (!c.a.w.e.g.d.c(list)) {
                        this.m.setSubTabList(list);
                        R();
                        this.f26558k.setVisibility(0);
                    } else {
                        this.f26558k.setVisibility(8);
                    }
                }
            } else {
                this.f26558k.setVisibility(8);
            }
            int i3 = this.G ? 85 : 81;
            boolean z = this.G;
            this.t.setMinimumHeight(c.a.w.b.f.a.a(this.f26550c, this.f26558k.getVisibility() == 0 ? i3 : 42));
        }
    }

    /* loaded from: classes7.dex */
    public static class k {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public long a;

        /* renamed from: b  reason: collision with root package name */
        public long f26563b;

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
            this.a = 180000L;
        }

        public boolean a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                LiveFeedPageSdk.l("onShow   " + (System.currentTimeMillis() - this.f26563b));
                return System.currentTimeMillis() - this.f26563b > this.a;
            }
            return invokeV.booleanValue;
        }

        public void b(long j2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j2) == null) || j2 <= 0) {
                return;
            }
            this.a = j2;
        }

        public void c() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                this.f26563b = System.currentTimeMillis();
            }
        }

        public /* synthetic */ k(b bVar) {
            this();
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.a.w.e.c.a
    public void call(c.a.w.b.b.a aVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048594, this, aVar) == null) && aVar != null && aVar.a() == this.f26549b) {
            LiveFeedPageSdk.l("LiveEventBus event: " + aVar.getClass() + GlideException.IndentedAppendable.INDENT + aVar.a());
            if (aVar instanceof c.a.w.b.b.b) {
                c.a.w.b.d.c.a aVar2 = ((c.a.w.b.b.b) aVar).f26564b;
                if (aVar2 != null) {
                    M(aVar2);
                }
            } else if (aVar instanceof c.a.w.b.b.d) {
                c.a.w.b.d.c.e eVar = ((c.a.w.b.b.d) aVar).f26565b;
                if (eVar != null) {
                    x(eVar);
                }
            } else if (aVar instanceof c.a.w.b.b.c) {
                this.H.c();
            }
        }
    }
}
