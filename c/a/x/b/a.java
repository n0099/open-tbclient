package c.a.x.b;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Color;
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
import c.a.x.b.d.a;
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
import com.baidu.live.business.view.search.LiveSearchGuideView;
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
/* loaded from: classes9.dex */
public class a implements c.a.x.g.c.a<c.a.x.b.b.a> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ImageView A;
    public LiveSearchGuideView B;
    public String C;
    public c.a.x.b.d.c.b D;
    public boolean E;
    public boolean F;
    public boolean G;
    public List<LiveTabEntity> H;
    public boolean I;
    public m J;
    public boolean K;
    public boolean L;
    public boolean M;
    public boolean N;
    public String O;
    public String P;
    public boolean Q;
    public a.b R;
    public boolean S;
    public final BroadcastReceiver T;
    public final String a;

    /* renamed from: b  reason: collision with root package name */
    public final int f26583b;

    /* renamed from: c  reason: collision with root package name */
    public Context f26584c;

    /* renamed from: d  reason: collision with root package name */
    public FragmentManager f26585d;

    /* renamed from: e  reason: collision with root package name */
    public View f26586e;

    /* renamed from: f  reason: collision with root package name */
    public View f26587f;

    /* renamed from: g  reason: collision with root package name */
    public AppBarLayout f26588g;

    /* renamed from: h  reason: collision with root package name */
    public NestedNoScrollViewPager f26589h;

    /* renamed from: i  reason: collision with root package name */
    public BaiduLiveTabAdapter f26590i;

    /* renamed from: j  reason: collision with root package name */
    public SmartTabLayout f26591j;
    public RecyclerView k;
    public RecyclerView l;
    public LiveFeedPageSubTipAdapter m;
    public LiveFeedPageConcernAdapter n;
    public FrameLayout o;
    public c.a.x.b.d.a p;
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

    /* renamed from: c.a.x.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public class C1592a implements BannerView.h {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ a a;

        public C1592a(a aVar) {
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
                if (liveBannerEntity != null && (bVar = liveBannerEntity.cmdInfo) != null && !c.a.x.g.g.j.a(bVar.a)) {
                    LiveHostInfo liveHostInfo = liveBannerEntity.hostInfo;
                    c.a.x.b.c.a.e(this.a.f26584c, this.a.a, liveBannerEntity.position, liveBannerEntity.roomId, liveBannerEntity.nid, liveBannerEntity.bannerType, liveHostInfo == null ? "" : liveHostInfo.uk, this.a.I ? "chenjinshi" : "zhibopindao", liveBannerEntity.materialId, liveBannerEntity.statInfo);
                    LiveFeedPageSdk.f().g().invokeScheme(this.a.f26584c, liveBannerEntity.cmdInfo.a);
                    return;
                }
                LiveFeedPageSdk.f().g().a(this.a.f26584c, this.a.f26584c.getResources().getString(c.a.x.c.a.e.live_feed_page_no_banner_configured));
            }
        }
    }

    /* loaded from: classes9.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f26592e;

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
            this.f26592e = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f26592e.f26588g == null) {
                return;
            }
            this.f26592e.f26588g.setExpanded(false, false);
        }
    }

    /* loaded from: classes9.dex */
    public class c extends BroadcastReceiver {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ a this$0;

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
            this.this$0 = aVar;
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, context, intent) == null) {
                this.this$0.L();
                boolean b2 = NetWorkUtils.b(context);
                if (!b2 || this.this$0.M) {
                    this.this$0.M = b2;
                    return;
                }
                this.this$0.M = true;
                if (this.this$0.K) {
                    LiveFeedPageSdk.m("网络变化: Tab 可用，Feed 刷新");
                    this.this$0.Q();
                    return;
                }
                LiveFeedPageSdk.m("网络变化: 全页面刷新");
                this.this$0.K();
            }
        }
    }

    /* loaded from: classes9.dex */
    public class d implements a.b {
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

        @Override // c.a.x.b.d.a.b
        public void a(c.a.x.b.d.c.c cVar, Map<String, String> map) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, cVar, map) == null) {
                if (cVar == null) {
                    b(-100, "数据解析失败", map);
                } else if ("follow".equals(cVar.f26613d)) {
                    this.a.C(cVar.f26615f);
                } else {
                    this.a.x(cVar);
                }
            }
        }

        @Override // c.a.x.b.d.a.b
        public void b(int i2, String str, Map<String, String> map) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeILL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, str, map) == null) || map == null || TextUtils.isEmpty(map.get("resource")) || !TextUtils.equals("banner,tab,feed,follow,config", map.get("resource"))) {
                return;
            }
            c.a.x.b.d.c.c cVar = new c.a.x.b.d.c.c();
            cVar.a("banner,tab,feed,follow,config", i2, str);
            this.a.x(cVar);
        }
    }

    /* loaded from: classes9.dex */
    public class e implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f26593e;

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
            this.f26593e = aVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                a aVar = this.f26593e;
                aVar.E(view, aVar.w);
            }
        }
    }

    /* loaded from: classes9.dex */
    public class f implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f26594e;

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
            this.f26594e = aVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view) == null) && (this.f26594e.f26584c instanceof Activity) && !((Activity) this.f26594e.f26584c).isFinishing()) {
                ((Activity) this.f26594e.f26584c).finish();
            }
        }
    }

    /* loaded from: classes9.dex */
    public class g implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f26595e;

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
            this.f26595e = aVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f26595e.H(true);
                c.a.x.b.c.a.w(this.f26595e.f26584c);
                LiveFeedPageSdk.f().q(this.f26595e.f26584c);
            }
        }
    }

    /* loaded from: classes9.dex */
    public class h implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f26596e;

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
            this.f26596e = aVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                a aVar = this.f26596e;
                aVar.E(view, aVar.w);
            }
        }
    }

    /* loaded from: classes9.dex */
    public class i implements ViewPager.OnPageChangeListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f26597e;

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
            this.f26597e = aVar;
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
                LiveFeedPageSdk.m("二级 tab 滑动/点击切换：" + i2);
                int a = c.a.x.b.f.f.a();
                if (this.f26597e.f26590i.getItem(a) instanceof LiveBaseFragment) {
                    ((LiveBaseFragment) this.f26597e.f26590i.getItem(a)).onSelectedChanged(false);
                }
                a aVar = this.f26597e;
                aVar.O = aVar.f26590i.getSubTab(i2).type;
                c.a.x.b.f.f.c(i2);
                if (this.f26597e.f26590i.getItem(i2) instanceof LiveBaseFragment) {
                    ((LiveBaseFragment) this.f26597e.f26590i.getItem(i2)).onSelectedChanged(true);
                }
                this.f26597e.F(i2);
                this.f26597e.f26591j.onDarkModeChange("day");
                this.f26597e.f26591j.setScrollLineVisibility(i2);
                this.f26597e.f26590i.externalRefresh(i2, true, true);
            }
        }
    }

    /* loaded from: classes9.dex */
    public class j implements SmartTabLayout.e {
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

        @Override // com.baidu.live.business.view.smarttab.SmartTabLayout.e
        public void a(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i2) == null) {
                LiveFeedPageSdk.m("二级 tab 点击：" + i2 + "   current：" + this.a.f26589h.getCurrentItem());
                if (this.a.f26589h.getCurrentItem() == i2) {
                    this.a.f26590i.externalRefresh(i2, true, true);
                }
            }
        }
    }

    /* loaded from: classes9.dex */
    public class k implements LiveFeedPageSubTipAdapter.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ a a;

        public k(a aVar) {
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
                this.a.Z(i2);
            }
        }
    }

    /* loaded from: classes9.dex */
    public class l implements ErrorView.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ a a;

        public l(a aVar) {
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
                aVar.a0(aVar.r);
                if (this.a.p != null) {
                    this.a.p.g();
                }
            }
        }
    }

    public a(Context context, int i2, FragmentManager fragmentManager, String str, String str2, boolean z, String str3, String str4, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, Integer.valueOf(i2), fragmentManager, str, str2, Boolean.valueOf(z), str3, str4, Boolean.valueOf(z2)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.F = true;
        this.G = false;
        this.H = new ArrayList();
        this.J = new m(null);
        this.N = false;
        this.R = new d(this);
        this.S = false;
        this.T = new c(this);
        this.f26584c = context;
        this.a = str2;
        this.f26585d = fragmentManager;
        this.C = str;
        this.O = str3;
        this.P = str4;
        this.Q = z2;
        this.N = z;
        this.J.f26598b = System.currentTimeMillis();
        this.I = "immersion".equals(this.C);
        this.f26583b = i2;
        c.a.x.g.c.d.a().d(this, c.a.x.b.b.b.class, this);
        c.a.x.g.c.d.a().d(this, c.a.x.b.b.d.class, this);
        c.a.x.g.c.d.a().d(this, c.a.x.b.b.c.class, this);
        J();
        c.a.x.b.d.a aVar = new c.a.x.b.d.a(this.f26584c, this.I, this.a);
        this.p = aVar;
        aVar.i(this.R);
    }

    public final void A(c.a.x.b.d.c.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, bVar) == null) {
            this.D = bVar;
            if (bVar != null) {
                this.J.b(bVar.f26607b * 1000);
                D(bVar);
            }
        }
    }

    public final void B(c.a.x.b.d.c.c cVar) {
        AppBarLayout appBarLayout;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, cVar) == null) || cVar == null) {
            return;
        }
        A(cVar.f26618i);
        W(cVar.f26614e);
        G(cVar);
        F(c.a.x.b.f.f.a());
        C(cVar.f26615f);
        if (this.Q && (appBarLayout = this.f26588g) != null) {
            this.Q = false;
            appBarLayout.post(new b(this));
        }
        if ("haokan".equals(LiveFeedPageSdk.f().e())) {
            this.f26591j.setCustomTextsSize(16);
        }
    }

    public final void C(c.a.x.b.d.c.e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, eVar) == null) {
            if (eVar != null) {
                if (!c.a.x.g.g.d.c(eVar.a)) {
                    this.n.setConcernList(eVar.a);
                    this.l.setVisibility(0);
                } else {
                    this.n.setConcernList(new ArrayList());
                    this.l.setVisibility(8);
                }
            }
            X();
        }
    }

    public final void D(c.a.x.b.d.c.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, bVar) == null) {
            if (!this.I && bVar.f26608c) {
                this.A.setVisibility(0);
                b0();
                c.a.x.b.c.a.x(this.f26584c);
                return;
            }
            this.A.setVisibility(8);
            H(false);
        }
    }

    public final void E(View view, TextView textView) {
        String c2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048580, this, view, textView) == null) {
            c.a.x.b.d.c.b bVar = this.D;
            if (bVar != null && !TextUtils.isEmpty(bVar.a)) {
                c2 = this.D.a;
            } else {
                c2 = LiveFeedPageSdk.f().c();
            }
            if (LiveFeedPageSdk.f().d() != null) {
                LiveFeedPageSdk.f().d().a(view, textView, c2);
            } else if (LiveFeedPageSdk.f().g() != null) {
                LiveFeedPageSdk.f().g().invokeScheme(this.f26584c, c2);
            }
        }
    }

    public final void F(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048581, this, i2) == null) {
            if (!c.a.x.g.g.d.c(this.H)) {
                if (i2 >= 0 && i2 < this.H.size()) {
                    List<LiveTabEntity.TabLabelInfo> list = this.H.get(i2).subTabList;
                    if (!c.a.x.g.g.d.c(list)) {
                        this.m.setSubTabList(list, this.P);
                        d0();
                        this.k.setVisibility(0);
                    } else {
                        this.k.setVisibility(8);
                    }
                }
            } else {
                this.k.setVisibility(8);
            }
            int i3 = this.I ? 93 : 81;
            boolean z = this.I;
            this.t.setMinimumHeight(c.a.x.b.f.a.a(this.f26584c, this.k.getVisibility() == 0 ? i3 : 42));
        }
    }

    public final void G(c.a.x.b.d.c.c cVar) {
        c.a.x.b.d.c.g gVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048582, this, cVar) == null) || cVar == null) {
            return;
        }
        c.a.x.b.f.f.b();
        if (this.S || (gVar = cVar.f26616g) == null || c.a.x.g.g.d.c(gVar.f26630c)) {
            return;
        }
        this.S = true;
        List<LiveTabEntity> list = cVar.f26616g.f26630c;
        this.H = list;
        int y = y(list);
        this.f26590i.setTabList(this.H, cVar.f26617h, cVar.f26618i);
        this.f26591j.setViewPager(this.f26589h);
        if (!c.a.x.g.g.d.c(this.H)) {
            c.a.x.b.f.f.c(y);
            this.f26589h.setCurrentItem(y);
        }
        this.f26590i.selectDefault(y);
        this.O = this.f26590i.getSubTab(y).type;
        if (cVar.f26616g.f26631d) {
            Context context = this.f26584c;
            String str = this.a;
            String m2 = c.a.x.b.c.a.m(this.I);
            c.a.x.b.d.c.g gVar2 = cVar.f26616g;
            c.a.x.b.c.a.p(context, str, m2, gVar2.a, gVar2.f26629b, cVar.f26612c, cVar.f26613d, "", "", "", gVar2.f26633f, "tab", gVar2.f26632e, System.currentTimeMillis(), 1);
        }
    }

    public final void H(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048583, this, z) == null) {
            LiveSearchGuideView liveSearchGuideView = this.B;
            if (liveSearchGuideView != null) {
                liveSearchGuideView.setVisibility(8);
            }
            if (z) {
                c.a.x.b.f.c.d("sp_search_guide_show", true);
            }
        }
    }

    public final void I() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            BannerView bannerView = new BannerView(this.f26584c);
            this.q = bannerView;
            bannerView.setShowRoundPicture(true, 10);
            this.q.setIndicatorGravity(81);
            this.q.setIndicatorMargin(0, 0, 0, (int) c.a.x.b.f.a.b(this.f26584c.getResources(), 7.0f));
            this.q.setLargeIndicatorItemSize((int) c.a.x.b.f.a.b(this.f26584c.getResources(), 4.0f));
            this.q.setSmallIndicatorItemSize((int) c.a.x.b.f.a.b(this.f26584c.getResources(), 4.0f));
            this.q.setIndicatorInterval((int) c.a.x.b.f.a.b(this.f26584c.getResources(), 6.0f));
            this.q.setAspectRatio(0.336f);
            this.q.setIsImmersion(this.I);
            this.q.setSource(this.a);
            this.q.setOnBannerClickListener(new C1592a(this));
            this.o.addView(this.q, new FrameLayout.LayoutParams(-1, -1));
        }
    }

    @SuppressLint({"InflateParams"})
    public final void J() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            View inflate = LayoutInflater.from(this.f26584c).inflate(c.a.x.c.a.d.live_feed_page_tab_layout, (ViewGroup) null);
            this.f26586e = inflate;
            this.f26587f = inflate.findViewById(c.a.x.c.a.c.live_tab_root_container);
            this.f26588g = (AppBarLayout) this.f26586e.findViewById(c.a.x.c.a.c.live_tab_appbar_layout);
            this.o = (FrameLayout) this.f26586e.findViewById(c.a.x.c.a.c.live_tab_content_container);
            this.f26591j = (SmartTabLayout) this.f26586e.findViewById(c.a.x.c.a.c.live_tab_top_tab_layout);
            this.k = (RecyclerView) this.f26586e.findViewById(c.a.x.c.a.c.live_tab_top_tab_sub_tag_layout);
            this.l = (RecyclerView) this.f26586e.findViewById(c.a.x.c.a.c.live_tab_top_concern_list_layout);
            this.t = (LinearLayout) this.f26586e.findViewById(c.a.x.c.a.c.live_tab_base_container);
            this.u = this.f26586e.findViewById(c.a.x.c.a.c.live_tab_top_space_layout);
            this.v = (LinearLayout) this.f26586e.findViewById(c.a.x.c.a.c.live_tab_top_start_live_layout);
            this.w = (TextView) this.f26586e.findViewById(c.a.x.c.a.c.live_tab_top_start_live_tv);
            this.y = this.f26586e.findViewById(c.a.x.c.a.c.live_tab_top_tab_divider_view);
            FakeStartLiveButton fakeStartLiveButton = (FakeStartLiveButton) this.f26586e.findViewById(c.a.x.c.a.c.live_feed_page_fake_start_live_id);
            this.x = fakeStartLiveButton;
            fakeStartLiveButton.setOnClickListener(new e(this));
            ImageView imageView = (ImageView) this.f26586e.findViewById(c.a.x.c.a.c.live_feed_page_imm_back_btn);
            this.z = imageView;
            imageView.setOnClickListener(new f(this));
            this.z.setVisibility(this.I ? 0 : 8);
            this.A = (ImageView) this.f26586e.findViewById(c.a.x.c.a.c.live_feed_page_search_btn);
            this.B = (LiveSearchGuideView) this.f26586e.findViewById(c.a.x.c.a.c.live_feed_page_search_guide);
            this.A.setOnClickListener(new g(this));
            if (this.I && c.a.x.g.g.c.a()) {
                this.f26586e.setPadding(0, c.a.x.g.g.c.d(this.f26584c), 0, 0);
            }
            this.v.setVisibility((!"haokan".equals(LiveFeedPageSdk.f().e()) || this.I || this.N) ? 8 : 0);
            this.v.setOnClickListener(new h(this));
            this.y.setVisibility(this.I ? 0 : 8);
            StaggeredGridLayoutManager staggeredGridLayoutManager = new StaggeredGridLayoutManager(1, 0);
            staggeredGridLayoutManager.setOrientation(0);
            this.k.setLayoutManager(staggeredGridLayoutManager);
            StaggeredGridLayoutManager staggeredGridLayoutManager2 = new StaggeredGridLayoutManager(1, 0);
            staggeredGridLayoutManager2.setOrientation(0);
            this.l.setLayoutManager(staggeredGridLayoutManager2);
            NestedNoScrollViewPager nestedNoScrollViewPager = (NestedNoScrollViewPager) this.f26586e.findViewById(c.a.x.c.a.c.live_tab_view_pager);
            this.f26589h = nestedNoScrollViewPager;
            nestedNoScrollViewPager.setId(View.generateViewId());
            this.f26589h.setOffscreenPageLimit(1);
            this.f26589h.setSaveEnabled(false);
            if ("immersion".equals(this.C)) {
                this.f26589h.setCanScrollHorizontally(true);
            }
            this.f26591j.setOnPageChangeListener(new i(this));
            this.f26591j.setOnTabClickListener(new j(this));
            BaiduLiveTabAdapter baiduLiveTabAdapter = new BaiduLiveTabAdapter(this.f26585d, this.f26583b, this.I, this.a, this.P);
            this.f26590i = baiduLiveTabAdapter;
            this.f26589h.setAdapter(baiduLiveTabAdapter);
            this.f26591j.setAllTabIsBold(false);
            this.f26591j.setTabSelectedColorEnable(true);
            this.f26591j.setShowBottomLine(this.I);
            if (this.I) {
                this.f26591j.setDarkModeCompatColor("color_white3", "color_1F1F1F");
            } else {
                this.f26591j.setDarkModeCompatColor("color_FF33551", "color_1F1F1F");
            }
            if ("haokan".equals(LiveFeedPageSdk.f().e())) {
                this.f26591j.setShowBottomLine(true);
                this.f26591j.setSelectedIndicatorColors(Color.parseColor("#222222"));
                this.f26591j.setDarkModeCompatColor("color_2222222", "color_888888");
            }
            this.f26591j.setIsImmersion(this.I);
            LiveFeedPageSubTipAdapter liveFeedPageSubTipAdapter = new LiveFeedPageSubTipAdapter(this.f26584c, this.I);
            this.m = liveFeedPageSubTipAdapter;
            liveFeedPageSubTipAdapter.setOnItemClickListener(new k(this));
            this.k.setAdapter(this.m);
            if (this.I) {
                RecyclerView recyclerView = this.k;
                if (recyclerView != null) {
                    recyclerView.setPadding(0, c.a.x.b.f.a.a(this.f26584c, 15.0f), 0, c.a.x.b.f.a.a(this.f26584c, 12.0f));
                }
                RecyclerView recyclerView2 = this.l;
                if (recyclerView2 != null) {
                    recyclerView2.setPadding(0, 0, 0, c.a.x.b.f.a.a(this.f26584c, 9.0f));
                }
            }
            LiveFeedPageConcernAdapter liveFeedPageConcernAdapter = new LiveFeedPageConcernAdapter(this.f26584c, this.I, this.a);
            this.n = liveFeedPageConcernAdapter;
            this.l.setAdapter(liveFeedPageConcernAdapter);
            I();
            LoadingView loadingView = (LoadingView) this.f26586e.findViewById(c.a.x.c.a.c.live_tab_loading);
            this.r = loadingView;
            loadingView.onDarkModeChange(this.I);
            a0(this.r);
            ErrorView errorView = (ErrorView) this.f26586e.findViewById(c.a.x.c.a.c.live_tab_error);
            this.s = errorView;
            errorView.setActionCallback(new l(this));
            O("day");
        }
    }

    public void K() {
        c.a.x.b.d.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048586, this) == null) || (aVar = this.p) == null) {
            return;
        }
        aVar.g();
    }

    public final void L() {
        BaiduLiveTabAdapter baiduLiveTabAdapter;
        NestedNoScrollViewPager nestedNoScrollViewPager;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048587, this) == null) || (baiduLiveTabAdapter = this.f26590i) == null || (nestedNoScrollViewPager = this.f26589h) == null) {
            return;
        }
        baiduLiveTabAdapter.notifyFragmentNetChange(nestedNoScrollViewPager.getCurrentItem());
    }

    public final void M() {
        BaiduLiveTabAdapter baiduLiveTabAdapter;
        NestedNoScrollViewPager nestedNoScrollViewPager;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048588, this) == null) || (baiduLiveTabAdapter = this.f26590i) == null || (nestedNoScrollViewPager = this.f26589h) == null) {
            return;
        }
        baiduLiveTabAdapter.notifyPause(nestedNoScrollViewPager.getCurrentItem());
    }

    public final void N() {
        BaiduLiveTabAdapter baiduLiveTabAdapter;
        NestedNoScrollViewPager nestedNoScrollViewPager;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048589, this) == null) || (baiduLiveTabAdapter = this.f26590i) == null || (nestedNoScrollViewPager = this.f26589h) == null) {
            return;
        }
        baiduLiveTabAdapter.notifyResume(nestedNoScrollViewPager.getCurrentItem());
    }

    public void O(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, str) == null) {
            View view = this.f26586e;
            if (view != null) {
                view.setBackgroundColor(c.a.x.k.f.e().a(this.f26584c, this.I, "color_white1"));
            }
            View view2 = this.u;
            if (view2 != null) {
                view2.setBackgroundColor(c.a.x.k.f.e().a(this.f26584c, this.I, "color_F5F5F52"));
            }
            TextView textView = this.w;
            if (textView != null) {
                textView.setTextColor(c.a.x.k.f.e().a(this.f26584c, this.I, "color_1F1F1F"));
            }
            BaiduLiveTabAdapter baiduLiveTabAdapter = this.f26590i;
            if (baiduLiveTabAdapter != null) {
                baiduLiveTabAdapter.onDarkModeChange(str);
            }
            ErrorView errorView = this.s;
            if (errorView != null) {
                errorView.onDarkModeChange(this.I);
            }
            LoadingView loadingView = this.r;
            if (loadingView != null) {
                loadingView.onDarkModeChange(this.I);
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
            SmartTabLayout smartTabLayout = this.f26591j;
            if (smartTabLayout != null) {
                smartTabLayout.onDarkModeChange(str);
            }
            ImageView imageView = this.A;
            if (imageView != null) {
                imageView.setImageResource(c.a.x.k.f.e().n());
            }
            LiveSearchGuideView liveSearchGuideView = this.B;
            if (liveSearchGuideView != null) {
                liveSearchGuideView.onDarkModeChange(str);
            }
        }
    }

    public void P() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            c.a.x.g.c.d.a().e(this);
            c0();
            BannerView bannerView = this.q;
            if (bannerView != null) {
                bannerView.onDestory();
            }
            LoadingView loadingView = this.r;
            if (loadingView != null) {
                loadingView.destroy();
            }
            this.F = true;
            c.a.x.b.f.f.b();
            BaiduLiveTabAdapter baiduLiveTabAdapter = this.f26590i;
            if (baiduLiveTabAdapter != null) {
                baiduLiveTabAdapter.onDestroy();
            }
            this.N = false;
            c.a.x.e.b.d(String.valueOf(this.f26583b));
        }
    }

    public void Q() {
        BaiduLiveTabAdapter baiduLiveTabAdapter;
        NestedNoScrollViewPager nestedNoScrollViewPager;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048592, this) == null) || (baiduLiveTabAdapter = this.f26590i) == null || (nestedNoScrollViewPager = this.f26589h) == null) {
            return;
        }
        baiduLiveTabAdapter.externalRefresh(nestedNoScrollViewPager.getCurrentItem(), true, true);
    }

    public final void R() {
        BaiduLiveTabAdapter baiduLiveTabAdapter;
        NestedNoScrollViewPager nestedNoScrollViewPager;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048593, this) == null) || (baiduLiveTabAdapter = this.f26590i) == null || (nestedNoScrollViewPager = this.f26589h) == null) {
            return;
        }
        baiduLiveTabAdapter.onHintLog(nestedNoScrollViewPager.getCurrentItem());
    }

    public final void S() {
        NestedNoScrollViewPager nestedNoScrollViewPager;
        NestedNoScrollViewPager nestedNoScrollViewPager2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
            BaiduLiveTabAdapter baiduLiveTabAdapter = this.f26590i;
            if (baiduLiveTabAdapter != null && (nestedNoScrollViewPager2 = this.f26589h) != null) {
                baiduLiveTabAdapter.onShowLog(nestedNoScrollViewPager2.getCurrentItem());
            }
            if (this.J.a()) {
                BaiduLiveTabAdapter baiduLiveTabAdapter2 = this.f26590i;
                if (baiduLiveTabAdapter2 != null && (nestedNoScrollViewPager = this.f26589h) != null) {
                    baiduLiveTabAdapter2.externalRefresh(nestedNoScrollViewPager.getCurrentItem(), true, true);
                }
            } else {
                c.a.x.b.d.a aVar = this.p;
                if (aVar != null && !this.F) {
                    aVar.f();
                }
            }
            this.F = false;
        }
    }

    public void T() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048595, this) == null) {
            LoadingView loadingView = this.r;
            if (loadingView != null) {
                loadingView.onPause();
            }
            v();
            M();
        }
    }

    public void U() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048596, this) == null) {
            LoadingView loadingView = this.r;
            if (loadingView != null) {
                loadingView.onResume();
            }
            w();
            N();
        }
    }

    public void V(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048597, this, z) == null) {
            LiveFeedPageSdk.m("onUserVisibleHint " + this.F + " " + z);
            if (this.E == z) {
                return;
            }
            this.E = z;
            if (z) {
                S();
                Y();
                return;
            }
            R();
            c0();
        }
    }

    public final void W(c.a.x.b.d.c.a aVar) {
        BannerView bannerView;
        FrameLayout frameLayout;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048598, this, aVar) == null) || (bannerView = this.q) == null || (frameLayout = this.o) == null) {
            return;
        }
        if (this.I) {
            frameLayout.setVisibility(8);
            this.q.setVisibility(8);
            v();
            this.G = false;
            return;
        }
        if (aVar != null) {
            if (!c.a.x.g.g.d.c(aVar.a)) {
                List<LiveBannerEntity> list = aVar.a;
                if (this.q.isBannerNeedUpdate(list)) {
                    BannerEntity bannerEntity = new BannerEntity();
                    bannerEntity.mBannerList = list;
                    bannerEntity.mBroadcastInterval = 5000;
                    this.q.setBannerEntity(bannerEntity);
                }
                this.q.setVisibility(0);
                this.G = true;
            } else {
                this.G = false;
                this.q.setVisibility(8);
            }
        } else {
            this.G = false;
            bannerView.setVisibility(8);
        }
        this.o.setVisibility(this.q.getVisibility() != 0 ? 8 : 0);
    }

    public final void X() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048599, this) == null) || this.u == null) {
            return;
        }
        RecyclerView recyclerView = this.l;
        boolean z = true;
        if (recyclerView != null && recyclerView.getVisibility() != 0) {
            z = false;
        }
        if (z && !this.I) {
            this.u.setVisibility(0);
        } else {
            this.u.setVisibility(8);
        }
    }

    public final void Y() {
        Context context;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048600, this) == null) || (context = this.f26584c) == null || this.L) {
            return;
        }
        this.M = NetWorkUtils.b(context);
        LiveFeedPageSdk.m("注册网络变化广播");
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
        this.f26584c.registerReceiver(this.T, intentFilter);
        this.L = true;
    }

    public final void Z(int i2) {
        NestedNoScrollViewPager nestedNoScrollViewPager;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048601, this, i2) == null) {
            int selectPos = this.m.getSelectPos();
            LiveFeedPageSdk.m("三级 Tab 点击 pre: " + selectPos + GlideException.IndentedAppendable.INDENT + i2);
            this.m.setSelectPos(i2);
            this.m.notifyDataSetChanged();
            BaiduLiveTabAdapter baiduLiveTabAdapter = this.f26590i;
            if (baiduLiveTabAdapter == null || (nestedNoScrollViewPager = this.f26589h) == null) {
                return;
            }
            if (selectPos != i2) {
                baiduLiveTabAdapter.onHintLog(nestedNoScrollViewPager.getCurrentItem());
            }
            d0();
            if (selectPos != i2) {
                this.f26590i.onShowLog(this.f26589h.getCurrentItem());
            }
            this.f26590i.externalRefresh(this.f26589h.getCurrentItem(), true, selectPos == i2);
        }
    }

    public void a0(View view) {
        ErrorView errorView;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048602, this, view) == null) {
            ErrorView errorView2 = this.s;
            int i2 = 8;
            if (errorView2 != null) {
                errorView2.toggleVisible(view == errorView2 ? 0 : 8, this.I);
            }
            LoadingView loadingView = this.r;
            if (loadingView != null) {
                loadingView.setVisibility(view == loadingView ? 0 : 8);
            }
            View view2 = this.f26587f;
            if (view2 != null) {
                view2.setVisibility(view == view2 ? 0 : 4);
            }
            FakeStartLiveButton fakeStartLiveButton = this.x;
            if (fakeStartLiveButton == null || (errorView = this.s) == null) {
                return;
            }
            if (errorView.getVisibility() == 0 && "haokan".equals(LiveFeedPageSdk.f().e()) && !this.N) {
                i2 = 0;
            }
            fakeStartLiveButton.setVisibility(i2);
        }
    }

    public final void b0() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048603, this) == null) || c.a.x.b.f.c.a("sp_search_guide_show", false)) {
            return;
        }
        this.B.setVisibility(0);
    }

    public final void c0() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048604, this) == null) && this.f26584c != null && this.L) {
            LiveFeedPageSdk.m("解注册网络变化广播");
            this.f26584c.unregisterReceiver(this.T);
            this.L = false;
        }
    }

    public final void d0() {
        BaiduLiveTabAdapter baiduLiveTabAdapter;
        NestedNoScrollViewPager nestedNoScrollViewPager;
        LiveTabEntity subTab;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048607, this) == null) || (baiduLiveTabAdapter = this.f26590i) == null || (nestedNoScrollViewPager = this.f26589h) == null || (subTab = baiduLiveTabAdapter.getSubTab(nestedNoScrollViewPager.getCurrentItem())) == null || TextUtils.isEmpty(subTab.type)) {
            return;
        }
        LiveTabEntity.TabLabelInfo selectSubTabInfo = this.m.getSelectSubTabInfo();
        String str = selectSubTabInfo.type;
        this.P = str;
        BaiduLiveTabAdapter baiduLiveTabAdapter2 = this.f26590i;
        String str2 = subTab.type;
        if (selectSubTabInfo == null) {
            str = "";
        }
        baiduLiveTabAdapter2.updateTabInfo(str2, str, this.f26589h.getCurrentItem());
    }

    public final void v() {
        BannerView bannerView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048608, this) == null) || (bannerView = this.q) == null) {
            return;
        }
        bannerView.onPause();
    }

    public final void w() {
        BannerView bannerView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048609, this) == null) && (bannerView = this.q) != null && this.G) {
            bannerView.onResume();
        }
    }

    public final void x(c.a.x.b.d.c.c cVar) {
        c.a.x.b.d.c.g gVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048610, this, cVar) == null) {
            if (cVar != null && (gVar = cVar.f26616g) != null && !c.a.x.g.g.d.c(gVar.f26630c)) {
                B(cVar);
                a0(this.f26587f);
                this.K = true;
                if (cVar.f26616g.f26631d) {
                    return;
                }
                this.J.c();
                return;
            }
            a0(this.s);
            this.K = false;
        }
    }

    public final int y(List<LiveTabEntity> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048611, this, list)) == null) {
            int size = list.size();
            int i2 = 0;
            int i3 = 0;
            for (int i4 = 0; i4 < size; i4++) {
                LiveTabEntity liveTabEntity = list.get(i4);
                if (liveTabEntity != null) {
                    if (!TextUtils.isEmpty(this.O) && i2 == 0 && this.O.equals(liveTabEntity.type)) {
                        LiveFeedPageSdk.m("scheme指定找到了二级Tab = " + liveTabEntity.name);
                        i2 = i4;
                    }
                    if (liveTabEntity.selected && i3 == 0) {
                        i3 = i4;
                    }
                }
            }
            return i2 != 0 ? i2 : i3;
        }
        return invokeL.intValue;
    }

    public View z() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048612, this)) == null) ? this.f26586e : (View) invokeV.objValue;
    }

    /* loaded from: classes9.dex */
    public static class m {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public long a;

        /* renamed from: b  reason: collision with root package name */
        public long f26598b;

        public m() {
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
                LiveFeedPageSdk.m("onShow   " + (System.currentTimeMillis() - this.f26598b));
                return System.currentTimeMillis() - this.f26598b > this.a;
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
                this.f26598b = System.currentTimeMillis();
            }
        }

        public /* synthetic */ m(d dVar) {
            this();
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.a.x.g.c.a
    public void call(c.a.x.b.b.a aVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048605, this, aVar) == null) && aVar != null && aVar.a() == this.f26583b) {
            LiveFeedPageSdk.m("LiveEventBus event: " + aVar.getClass() + GlideException.IndentedAppendable.INDENT + aVar.a());
            if (aVar instanceof c.a.x.b.b.b) {
                c.a.x.b.d.c.a aVar2 = ((c.a.x.b.b.b) aVar).f26599b;
                if (aVar2 != null) {
                    W(aVar2);
                }
            } else if (aVar instanceof c.a.x.b.b.d) {
                c.a.x.b.d.c.e eVar = ((c.a.x.b.b.d) aVar).f26600b;
                if (eVar != null) {
                    C(eVar);
                }
            } else if (aVar instanceof c.a.x.b.b.c) {
                this.J.c();
            }
        }
    }
}
