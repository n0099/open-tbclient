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
    public final String f30438a;

    /* renamed from: b  reason: collision with root package name */
    public final int f30439b;

    /* renamed from: c  reason: collision with root package name */
    public Context f30440c;

    /* renamed from: d  reason: collision with root package name */
    public FragmentManager f30441d;

    /* renamed from: e  reason: collision with root package name */
    public View f30442e;

    /* renamed from: f  reason: collision with root package name */
    public View f30443f;

    /* renamed from: g  reason: collision with root package name */
    public AppBarLayout f30444g;

    /* renamed from: h  reason: collision with root package name */
    public NestedNoScrollViewPager f30445h;

    /* renamed from: i  reason: collision with root package name */
    public BaiduLiveTabAdapter f30446i;

    /* renamed from: j  reason: collision with root package name */
    public SmartTabLayout f30447j;
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
    public class C1408a extends BroadcastReceiver {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ a this$0;

        public C1408a(a aVar) {
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
        public final /* synthetic */ a f30448a;

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
            this.f30448a = aVar;
        }

        @Override // c.a.w.b.d.a.b
        public void a(c.a.w.b.d.c.c cVar, Map<String, String> map) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, cVar, map) == null) {
                if (cVar == null) {
                    b(-100, "数据解析失败", map);
                } else if ("follow".equals(cVar.f30478d)) {
                    this.f30448a.y(cVar.f30480f);
                } else {
                    this.f30448a.u(cVar);
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
            this.f30448a.u(cVar);
        }
    }

    /* loaded from: classes4.dex */
    public class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f30449e;

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
            this.f30449e = aVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f30449e.z();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class d implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f30450e;

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
            this.f30450e = aVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view) == null) && (this.f30450e.f30440c instanceof Activity) && !((Activity) this.f30450e.f30440c).isFinishing()) {
                ((Activity) this.f30450e.f30440c).finish();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class e implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f30451e;

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
            this.f30451e = aVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f30451e.z();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class f implements ViewPager.OnPageChangeListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f30452e;

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
            this.f30452e = aVar;
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
                if (this.f30452e.f30446i.getItem(a2) instanceof LiveBaseFragment) {
                    ((LiveBaseFragment) this.f30452e.f30446i.getItem(a2)).onSelectedChanged(false);
                }
                c.a.w.b.f.f.c(i2);
                if (this.f30452e.f30446i.getItem(i2) instanceof LiveBaseFragment) {
                    ((LiveBaseFragment) this.f30452e.f30446i.getItem(i2)).onSelectedChanged(true);
                }
                this.f30452e.A(i2);
                this.f30452e.f30447j.onDarkModeChange("day");
                this.f30452e.f30447j.setScrollLineVisibility(i2);
                this.f30452e.f30446i.externalRefresh(i2, true, true);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class g implements SmartTabLayout.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f30453a;

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
            this.f30453a = aVar;
        }

        @Override // com.baidu.live.business.view.smarttab.SmartTabLayout.e
        public void a(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i2) == null) {
                LiveFeedPageSdk.l("二级 tab 点击：" + i2 + "   current：" + this.f30453a.f30445h.getCurrentItem());
                if (this.f30453a.f30445h.getCurrentItem() == i2) {
                    this.f30453a.f30446i.externalRefresh(i2, true, true);
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class h implements LiveFeedPageSubTipAdapter.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f30454a;

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
            this.f30454a = aVar;
        }

        @Override // com.baidu.live.business.adapter.LiveFeedPageSubTipAdapter.b
        public void a(View view, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, view, i2) == null) {
                int selectPos = this.f30454a.m.getSelectPos();
                LiveFeedPageSdk.l("三级 Tab 点击 pre: " + selectPos + GlideException.IndentedAppendable.INDENT + i2);
                this.f30454a.m.setSelectPos(i2);
                this.f30454a.m.notifyDataSetChanged();
                if (this.f30454a.f30446i == null || this.f30454a.f30445h == null) {
                    return;
                }
                if (selectPos != i2) {
                    this.f30454a.f30446i.onHintLog(this.f30454a.f30445h.getCurrentItem());
                }
                this.f30454a.S();
                if (selectPos != i2) {
                    this.f30454a.f30446i.onShowLog(this.f30454a.f30445h.getCurrentItem());
                }
                this.f30454a.f30446i.externalRefresh(this.f30454a.f30445h.getCurrentItem(), true, selectPos == i2);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class i implements ErrorView.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f30455a;

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
            this.f30455a = aVar;
        }

        @Override // com.baidu.live.business.view.emotion.ErrorView.b
        public void a(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                a aVar = this.f30455a;
                aVar.Q(aVar.r);
                if (this.f30455a.p != null) {
                    this.f30455a.p.g();
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class j implements BannerView.h {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f30456a;

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
            this.f30456a = aVar;
        }

        @Override // com.baidu.live.business.view.banner.BannerView.h
        public void a(LiveBannerEntity liveBannerEntity) {
            LiveBannerEntity.b bVar;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, liveBannerEntity) == null) {
                if (liveBannerEntity != null && (bVar = liveBannerEntity.cmdInfo) != null && !c.a.w.e.g.j.a(bVar.f40853a)) {
                    LiveHostInfo liveHostInfo = liveBannerEntity.hostInfo;
                    c.a.w.b.c.a.e(this.f30456a.f30440c, this.f30456a.f30438a, liveBannerEntity.position, liveBannerEntity.roomId, liveBannerEntity.nid, liveBannerEntity.bannerType, liveHostInfo == null ? "" : liveHostInfo.uk, this.f30456a.G ? "chenjinshi" : "zhibopindao", liveBannerEntity.statInfo);
                    LiveFeedPageSdk.e().f().invokeScheme(this.f30456a.f30440c, liveBannerEntity.cmdInfo.f40853a);
                    return;
                }
                LiveFeedPageSdk.e().f().c(this.f30456a.f30440c, this.f30456a.f30440c.getResources().getString(c.a.w.c.a.e.live_feed_page_no_banner_configured));
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
        this.O = new C1408a(this);
        this.f30440c = context;
        this.f30438a = str2;
        this.f30441d = fragmentManager;
        this.A = str;
        this.L = z;
        this.H.f30458b = System.currentTimeMillis();
        this.G = "immersion".equals(this.A);
        this.f30439b = i2;
        c.a.w.e.c.d.a().d(this, c.a.w.b.b.b.class, this);
        c.a.w.e.c.d.a().d(this, c.a.w.b.b.d.class, this);
        c.a.w.e.c.d.a().d(this, c.a.w.b.b.c.class, this);
        D();
        c.a.w.b.d.a aVar = new c.a.w.b.d.a(this.f30440c, this.G, this.f30438a);
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
            this.t.setMinimumHeight(c.a.w.b.f.a.a(this.f30440c, this.k.getVisibility() == 0 ? i3 : 42));
        }
    }

    public final void B(c.a.w.b.d.c.c cVar) {
        c.a.w.b.d.c.g gVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, cVar) == null) || cVar == null) {
            return;
        }
        c.a.w.b.f.f.b();
        if (this.N || (gVar = cVar.f30481g) == null || c.a.w.e.g.d.c(gVar.f30499c)) {
            return;
        }
        this.N = true;
        List<LiveTabEntity> list = cVar.f30481g.f30499c;
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
        this.f30446i.setTabList(this.F, cVar.f30482h);
        this.f30447j.setViewPager(this.f30445h);
        if (!c.a.w.e.g.d.c(this.F)) {
            c.a.w.b.f.f.c(i2);
            this.f30445h.setCurrentItem(i2);
        }
        this.f30446i.selectDefault(i2);
        if (cVar.f30481g.f30500d) {
            Context context = this.f30440c;
            String str = this.f30438a;
            String m = c.a.w.b.c.a.m(this.G);
            c.a.w.b.d.c.g gVar2 = cVar.f30481g;
            c.a.w.b.c.a.o(context, str, m, gVar2.f30497a, gVar2.f30498b, cVar.f30477c, cVar.f30478d, "", "", "", gVar2.f30502f, "tab", gVar2.f30501e, System.currentTimeMillis(), 1);
        }
    }

    public final void C() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            BannerView bannerView = new BannerView(this.f30440c);
            this.q = bannerView;
            bannerView.setShowRoundPicture(true, 10);
            this.q.setIndicatorGravity(81);
            this.q.setIndicatorMargin(0, 0, 0, (int) c.a.w.b.f.a.b(this.f30440c.getResources(), 7.0f));
            this.q.setLargeIndicatorItemSize((int) c.a.w.b.f.a.b(this.f30440c.getResources(), 4.0f));
            this.q.setSmallIndicatorItemSize((int) c.a.w.b.f.a.b(this.f30440c.getResources(), 4.0f));
            this.q.setIndicatorInterval((int) c.a.w.b.f.a.b(this.f30440c.getResources(), 6.0f));
            this.q.setAspectRatio(0.336f);
            this.q.setIsImmersion(this.G);
            this.q.setSource(this.f30438a);
            this.q.setOnBannerClickListener(new j(this));
            this.o.addView(this.q, new FrameLayout.LayoutParams(-1, -1));
        }
    }

    public final void D() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            View inflate = LayoutInflater.from(this.f30440c).inflate(c.a.w.c.a.d.live_feed_page_tab_layout, (ViewGroup) null);
            this.f30442e = inflate;
            this.f30443f = inflate.findViewById(c.a.w.c.a.c.live_tab_root_container);
            this.f30444g = (AppBarLayout) this.f30442e.findViewById(c.a.w.c.a.c.live_tab_appbar_layout);
            this.o = (FrameLayout) this.f30442e.findViewById(c.a.w.c.a.c.live_tab_content_container);
            this.f30447j = (SmartTabLayout) this.f30442e.findViewById(c.a.w.c.a.c.live_tab_top_tab_layout);
            this.k = (RecyclerView) this.f30442e.findViewById(c.a.w.c.a.c.live_tab_top_tab_sub_tag_layout);
            this.l = (RecyclerView) this.f30442e.findViewById(c.a.w.c.a.c.live_tab_top_concern_list_layout);
            this.t = (LinearLayout) this.f30442e.findViewById(c.a.w.c.a.c.live_tab_base_container);
            this.u = this.f30442e.findViewById(c.a.w.c.a.c.live_tab_top_space_layout);
            this.v = (LinearLayout) this.f30442e.findViewById(c.a.w.c.a.c.live_tab_top_start_live_layout);
            this.w = (TextView) this.f30442e.findViewById(c.a.w.c.a.c.live_tab_top_start_live_tv);
            this.y = this.f30442e.findViewById(c.a.w.c.a.c.live_tab_top_tab_divider_view);
            FakeStartLiveButton fakeStartLiveButton = (FakeStartLiveButton) this.f30442e.findViewById(c.a.w.c.a.c.live_feed_page_fake_start_live_id);
            this.x = fakeStartLiveButton;
            fakeStartLiveButton.setOnClickListener(new c(this));
            ImageView imageView = (ImageView) this.f30442e.findViewById(c.a.w.c.a.c.live_feed_page_imm_back_btn);
            this.z = imageView;
            imageView.setOnClickListener(new d(this));
            this.z.setVisibility(this.G ? 0 : 8);
            if (this.G && c.a.w.e.g.c.a()) {
                this.f30442e.setPadding(0, c.a.w.e.g.c.d(this.f30440c), 0, 0);
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
            NestedNoScrollViewPager nestedNoScrollViewPager = (NestedNoScrollViewPager) this.f30442e.findViewById(c.a.w.c.a.c.live_tab_view_pager);
            this.f30445h = nestedNoScrollViewPager;
            nestedNoScrollViewPager.setId(View.generateViewId());
            this.f30445h.setOffscreenPageLimit(1);
            this.f30445h.setSaveEnabled(false);
            if ("immersion".equals(this.A)) {
                this.f30445h.setCanScrollHorizontally(true);
            }
            this.f30447j.setOnPageChangeListener(new f(this));
            this.f30447j.setOnTabClickListener(new g(this));
            BaiduLiveTabAdapter baiduLiveTabAdapter = new BaiduLiveTabAdapter(this.f30441d, this.f30439b, this.G, this.f30438a);
            this.f30446i = baiduLiveTabAdapter;
            this.f30445h.setAdapter(baiduLiveTabAdapter);
            this.f30447j.setAllTabIsBold(false);
            this.f30447j.setTabSelectedColorEnable(true);
            this.f30447j.setShowBottomLine(this.G);
            this.f30447j.setDarkModeCompatColor("color_FF33551", "color_1F1F1F");
            this.f30447j.setIsImmersion(this.G);
            LiveFeedPageSubTipAdapter liveFeedPageSubTipAdapter = new LiveFeedPageSubTipAdapter(this.f30440c, this.G);
            this.m = liveFeedPageSubTipAdapter;
            liveFeedPageSubTipAdapter.setOnItemClickListener(new h(this));
            this.k.setAdapter(this.m);
            if (this.G) {
                RecyclerView recyclerView = this.k;
                if (recyclerView != null) {
                    recyclerView.setPadding(0, c.a.w.b.f.a.a(this.f30440c, 11.0f), 0, c.a.w.b.f.a.a(this.f30440c, 8.0f));
                }
                RecyclerView recyclerView2 = this.l;
                if (recyclerView2 != null) {
                    recyclerView2.setPadding(0, 0, 0, c.a.w.b.f.a.a(this.f30440c, 9.0f));
                }
            }
            LiveFeedPageConcernAdapter liveFeedPageConcernAdapter = new LiveFeedPageConcernAdapter(this.f30440c, this.G, this.f30438a);
            this.n = liveFeedPageConcernAdapter;
            this.l.setAdapter(liveFeedPageConcernAdapter);
            C();
            LoadingView loadingView = (LoadingView) this.f30442e.findViewById(c.a.w.c.a.c.live_tab_loading);
            this.r = loadingView;
            loadingView.onDarkModeChange(this.G);
            Q(this.r);
            ErrorView errorView = (ErrorView) this.f30442e.findViewById(c.a.w.c.a.c.live_tab_error);
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
            View view = this.f30442e;
            if (view != null) {
                view.setBackgroundColor(c.a.w.i.f.e().a(this.f30440c, this.G, "color_white1"));
            }
            View view2 = this.u;
            if (view2 != null) {
                view2.setBackgroundColor(c.a.w.i.f.e().a(this.f30440c, this.G, "color_F5F5F52"));
            }
            TextView textView = this.w;
            if (textView != null) {
                textView.setTextColor(c.a.w.i.f.e().a(this.f30440c, this.G, "color_1F1F1F"));
            }
            BaiduLiveTabAdapter baiduLiveTabAdapter = this.f30446i;
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
            SmartTabLayout smartTabLayout = this.f30447j;
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
            BaiduLiveTabAdapter baiduLiveTabAdapter = this.f30446i;
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
        if (!(interceptable == null || interceptable.invokeV(1048583, this) == null) || (baiduLiveTabAdapter = this.f30446i) == null || (nestedNoScrollViewPager = this.f30445h) == null) {
            return;
        }
        baiduLiveTabAdapter.externalRefresh(nestedNoScrollViewPager.getCurrentItem(), true, true);
    }

    public final void I() {
        BaiduLiveTabAdapter baiduLiveTabAdapter;
        NestedNoScrollViewPager nestedNoScrollViewPager;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) || (baiduLiveTabAdapter = this.f30446i) == null || (nestedNoScrollViewPager = this.f30445h) == null) {
            return;
        }
        baiduLiveTabAdapter.onHintLog(nestedNoScrollViewPager.getCurrentItem());
    }

    public final void J() {
        NestedNoScrollViewPager nestedNoScrollViewPager;
        NestedNoScrollViewPager nestedNoScrollViewPager2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            BaiduLiveTabAdapter baiduLiveTabAdapter = this.f30446i;
            if (baiduLiveTabAdapter != null && (nestedNoScrollViewPager2 = this.f30445h) != null) {
                baiduLiveTabAdapter.onShowLog(nestedNoScrollViewPager2.getCurrentItem());
            }
            if (this.H.a()) {
                BaiduLiveTabAdapter baiduLiveTabAdapter2 = this.f30446i;
                if (baiduLiveTabAdapter2 != null && (nestedNoScrollViewPager = this.f30445h) != null) {
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
            if (!c.a.w.e.g.d.c(aVar.f30472a)) {
                List<LiveBannerEntity> list = aVar.f30472a;
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
        if (!(interceptable == null || interceptable.invokeV(1048591, this) == null) || (context = this.f30440c) == null || this.J) {
            return;
        }
        this.K = NetWorkUtils.b(context);
        LiveFeedPageSdk.l("注册网络变化广播");
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
        this.f30440c.registerReceiver(this.O, intentFilter);
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
            View view2 = this.f30443f;
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
        if ((interceptable == null || interceptable.invokeV(1048593, this) == null) && this.f30440c != null && this.J) {
            LiveFeedPageSdk.l("解注册网络变化广播");
            this.f30440c.unregisterReceiver(this.O);
            this.J = false;
        }
    }

    public final void S() {
        BaiduLiveTabAdapter baiduLiveTabAdapter;
        NestedNoScrollViewPager nestedNoScrollViewPager;
        LiveTabEntity subTab;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048594, this) == null) || (baiduLiveTabAdapter = this.f30446i) == null || (nestedNoScrollViewPager = this.f30445h) == null || (subTab = baiduLiveTabAdapter.getSubTab(nestedNoScrollViewPager.getCurrentItem())) == null || TextUtils.isEmpty(subTab.type)) {
            return;
        }
        LiveTabEntity.TabLabelInfo selectSubTabInfo = this.m.getSelectSubTabInfo();
        this.f30446i.updateTabInfo(subTab.type, selectSubTabInfo != null ? selectSubTabInfo.type : "", this.f30445h.getCurrentItem());
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
        if ((interceptable == null || interceptable.invokeL(1048598, this, aVar) == null) && aVar != null && aVar.a() == this.f30439b) {
            LiveFeedPageSdk.l("LiveEventBus event: " + aVar.getClass() + GlideException.IndentedAppendable.INDENT + aVar.a());
            if (aVar instanceof c.a.w.b.b.b) {
                c.a.w.b.d.c.a aVar2 = ((c.a.w.b.b.b) aVar).f30460b;
                if (aVar2 != null) {
                    N(aVar2);
                }
            } else if (aVar instanceof c.a.w.b.b.d) {
                c.a.w.b.d.c.e eVar = ((c.a.w.b.b.d) aVar).f30461b;
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
            if (cVar != null && (gVar = cVar.f30481g) != null && !c.a.w.e.g.d.c(gVar.f30499c)) {
                x(cVar);
                Q(this.f30443f);
                this.I = true;
                if (cVar.f30481g.f30500d) {
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
        return (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) ? this.f30442e : (View) invokeV.objValue;
    }

    public final void w(c.a.w.b.d.c.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048601, this, bVar) == null) {
            this.B = bVar;
            if (bVar != null) {
                this.H.b(bVar.f30474b * 1000);
            }
        }
    }

    public final void x(c.a.w.b.d.c.c cVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048602, this, cVar) == null) || cVar == null) {
            return;
        }
        w(cVar.f30483i);
        N(cVar.f30479e);
        B(cVar);
        A(c.a.w.b.f.f.a());
        y(cVar.f30480f);
    }

    public final void y(c.a.w.b.d.c.e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048603, this, eVar) == null) {
            if (eVar != null) {
                if (!c.a.w.e.g.d.c(eVar.f30491a)) {
                    this.n.setConcernList(eVar.f30491a);
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
        if (bVar != null && !TextUtils.isEmpty(bVar.f30473a)) {
            c2 = this.B.f30473a;
        } else {
            c2 = LiveFeedPageSdk.e().c();
        }
        LiveFeedPageSdk.e().f().invokeScheme(this.f30440c, c2);
    }

    /* loaded from: classes4.dex */
    public static class k {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public long f30457a;

        /* renamed from: b  reason: collision with root package name */
        public long f30458b;

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
            this.f30457a = 180000L;
        }

        public boolean a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                LiveFeedPageSdk.l("onShow   " + (System.currentTimeMillis() - this.f30458b));
                return System.currentTimeMillis() - this.f30458b > this.f30457a;
            }
            return invokeV.booleanValue;
        }

        public void b(long j2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j2) == null) || j2 <= 0) {
                return;
            }
            this.f30457a = j2;
        }

        public void c() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                this.f30458b = System.currentTimeMillis();
            }
        }

        public /* synthetic */ k(b bVar) {
            this();
        }
    }
}
