package b.a.w.b;

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
import b.a.w.b.d.a;
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
/* loaded from: classes6.dex */
public class a implements b.a.w.e.c.a<b.a.w.b.b.a> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String A;
    public b.a.w.b.d.c.b B;
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
    public final String f30032a;

    /* renamed from: b  reason: collision with root package name */
    public final int f30033b;

    /* renamed from: c  reason: collision with root package name */
    public Context f30034c;

    /* renamed from: d  reason: collision with root package name */
    public FragmentManager f30035d;

    /* renamed from: e  reason: collision with root package name */
    public View f30036e;

    /* renamed from: f  reason: collision with root package name */
    public View f30037f;

    /* renamed from: g  reason: collision with root package name */
    public AppBarLayout f30038g;

    /* renamed from: h  reason: collision with root package name */
    public NestedNoScrollViewPager f30039h;

    /* renamed from: i  reason: collision with root package name */
    public BaiduLiveTabAdapter f30040i;
    public SmartTabLayout j;
    public RecyclerView k;
    public RecyclerView l;
    public LiveFeedPageSubTipAdapter m;
    public LiveFeedPageConcernAdapter n;
    public FrameLayout o;
    public b.a.w.b.d.a p;
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

    /* renamed from: b.a.w.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public class C1450a extends BroadcastReceiver {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ a this$0;

        public C1450a(a aVar) {
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

    /* loaded from: classes6.dex */
    public class b implements a.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f30041a;

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
            this.f30041a = aVar;
        }

        @Override // b.a.w.b.d.a.b
        public void a(b.a.w.b.d.c.c cVar, Map<String, String> map) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, cVar, map) == null) {
                if (cVar == null) {
                    b(-100, "数据解析失败", map);
                } else if ("follow".equals(cVar.f30071d)) {
                    this.f30041a.x(cVar.f30073f);
                } else {
                    this.f30041a.t(cVar);
                }
            }
        }

        @Override // b.a.w.b.d.a.b
        public void b(int i2, String str, Map<String, String> map) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeILL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, str, map) == null) || map == null || TextUtils.isEmpty(map.get("resource")) || !TextUtils.equals("banner,tab,feed,follow,config", map.get("resource"))) {
                return;
            }
            b.a.w.b.d.c.c cVar = new b.a.w.b.d.c.c();
            cVar.a("banner,tab,feed,follow,config", i2, str);
            this.f30041a.t(cVar);
        }
    }

    /* loaded from: classes6.dex */
    public class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f30042e;

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
            this.f30042e = aVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f30042e.y();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class d implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f30043e;

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
            this.f30043e = aVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view) == null) && (this.f30043e.f30034c instanceof Activity) && !((Activity) this.f30043e.f30034c).isFinishing()) {
                ((Activity) this.f30043e.f30034c).finish();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class e implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f30044e;

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
            this.f30044e = aVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f30044e.y();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class f implements ViewPager.OnPageChangeListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f30045e;

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
            this.f30045e = aVar;
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
                int a2 = b.a.w.b.f.f.a();
                if (this.f30045e.f30040i.getItem(a2) instanceof LiveBaseFragment) {
                    ((LiveBaseFragment) this.f30045e.f30040i.getItem(a2)).onSelectedChanged(false);
                }
                b.a.w.b.f.f.c(i2);
                if (this.f30045e.f30040i.getItem(i2) instanceof LiveBaseFragment) {
                    ((LiveBaseFragment) this.f30045e.f30040i.getItem(i2)).onSelectedChanged(true);
                }
                this.f30045e.z(i2);
                this.f30045e.j.onDarkModeChange("day");
                this.f30045e.j.setScrollLineVisibility(i2);
                this.f30045e.f30040i.externalRefresh(i2, true, true);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class g implements SmartTabLayout.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f30046a;

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
            this.f30046a = aVar;
        }

        @Override // com.baidu.live.business.view.smarttab.SmartTabLayout.e
        public void a(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i2) == null) {
                LiveFeedPageSdk.l("二级 tab 点击：" + i2 + "   current：" + this.f30046a.f30039h.getCurrentItem());
                if (this.f30046a.f30039h.getCurrentItem() == i2) {
                    this.f30046a.f30040i.externalRefresh(i2, true, true);
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class h implements LiveFeedPageSubTipAdapter.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f30047a;

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
            this.f30047a = aVar;
        }

        @Override // com.baidu.live.business.adapter.LiveFeedPageSubTipAdapter.b
        public void a(View view, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, view, i2) == null) {
                int selectPos = this.f30047a.m.getSelectPos();
                LiveFeedPageSdk.l("三级 Tab 点击 pre: " + selectPos + GlideException.IndentedAppendable.INDENT + i2);
                this.f30047a.m.setSelectPos(i2);
                this.f30047a.m.notifyDataSetChanged();
                if (this.f30047a.f30040i == null || this.f30047a.f30039h == null) {
                    return;
                }
                if (selectPos != i2) {
                    this.f30047a.f30040i.onHintLog(this.f30047a.f30039h.getCurrentItem());
                }
                this.f30047a.R();
                if (selectPos != i2) {
                    this.f30047a.f30040i.onShowLog(this.f30047a.f30039h.getCurrentItem());
                }
                this.f30047a.f30040i.externalRefresh(this.f30047a.f30039h.getCurrentItem(), true, selectPos == i2);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class i implements ErrorView.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f30048a;

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
            this.f30048a = aVar;
        }

        @Override // com.baidu.live.business.view.emotion.ErrorView.b
        public void a(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                a aVar = this.f30048a;
                aVar.P(aVar.r);
                if (this.f30048a.p != null) {
                    this.f30048a.p.g();
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class j implements BannerView.h {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f30049a;

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
            this.f30049a = aVar;
        }

        @Override // com.baidu.live.business.view.banner.BannerView.h
        public void a(LiveBannerEntity liveBannerEntity) {
            LiveBannerEntity.b bVar;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, liveBannerEntity) == null) {
                if (liveBannerEntity != null && (bVar = liveBannerEntity.cmdInfo) != null && !b.a.w.e.g.j.a(bVar.f39571a)) {
                    LiveHostInfo liveHostInfo = liveBannerEntity.hostInfo;
                    b.a.w.b.c.a.e(this.f30049a.f30034c, this.f30049a.f30032a, liveBannerEntity.position, liveBannerEntity.roomId, liveBannerEntity.nid, liveBannerEntity.bannerType, liveHostInfo == null ? "" : liveHostInfo.uk, this.f30049a.G ? "chenjinshi" : "zhibopindao", liveBannerEntity.statInfo);
                    LiveFeedPageSdk.e().f().invokeScheme(this.f30049a.f30034c, liveBannerEntity.cmdInfo.f39571a);
                    return;
                }
                LiveFeedPageSdk.e().f().c(this.f30049a.f30034c, this.f30049a.f30034c.getResources().getString(b.a.w.c.a.e.live_feed_page_no_banner_configured));
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
        this.O = new C1450a(this);
        this.f30034c = context;
        this.f30032a = str2;
        this.f30035d = fragmentManager;
        this.A = str;
        this.L = z;
        this.H.f30051b = System.currentTimeMillis();
        this.G = "immersion".equals(this.A);
        this.f30033b = i2;
        b.a.w.e.c.d.a().d(this, b.a.w.b.b.b.class, this);
        b.a.w.e.c.d.a().d(this, b.a.w.b.b.d.class, this);
        b.a.w.e.c.d.a().d(this, b.a.w.b.b.c.class, this);
        C();
        b.a.w.b.d.a aVar = new b.a.w.b.d.a(this.f30034c, this.G, this.f30032a);
        this.p = aVar;
        aVar.i(this.M);
    }

    public final void A(b.a.w.b.d.c.c cVar) {
        b.a.w.b.d.c.g gVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, cVar) == null) || cVar == null) {
            return;
        }
        b.a.w.b.f.f.b();
        if (this.N || (gVar = cVar.f30074g) == null || b.a.w.e.g.d.c(gVar.f30092c)) {
            return;
        }
        this.N = true;
        List<LiveTabEntity> list = cVar.f30074g.f30092c;
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
        this.f30040i.setTabList(this.F, cVar.f30075h);
        this.j.setViewPager(this.f30039h);
        if (!b.a.w.e.g.d.c(this.F)) {
            b.a.w.b.f.f.c(i2);
            this.f30039h.setCurrentItem(i2);
        }
        this.f30040i.selectDefault(i2);
        if (cVar.f30074g.f30093d) {
            Context context = this.f30034c;
            String str = this.f30032a;
            String m = b.a.w.b.c.a.m(this.G);
            b.a.w.b.d.c.g gVar2 = cVar.f30074g;
            b.a.w.b.c.a.o(context, str, m, gVar2.f30090a, gVar2.f30091b, cVar.f30070c, cVar.f30071d, "", "", "", gVar2.f30095f, "tab", gVar2.f30094e, System.currentTimeMillis(), 1);
        }
    }

    public final void B() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            BannerView bannerView = new BannerView(this.f30034c);
            this.q = bannerView;
            bannerView.setShowRoundPicture(true, 10);
            this.q.setIndicatorGravity(81);
            this.q.setIndicatorMargin(0, 0, 0, (int) b.a.w.b.f.a.b(this.f30034c.getResources(), 7.0f));
            this.q.setLargeIndicatorItemSize((int) b.a.w.b.f.a.b(this.f30034c.getResources(), 4.0f));
            this.q.setSmallIndicatorItemSize((int) b.a.w.b.f.a.b(this.f30034c.getResources(), 4.0f));
            this.q.setIndicatorInterval((int) b.a.w.b.f.a.b(this.f30034c.getResources(), 6.0f));
            this.q.setAspectRatio(0.336f);
            this.q.setIsImmersion(this.G);
            this.q.setSource(this.f30032a);
            this.q.setOnBannerClickListener(new j(this));
            this.o.addView(this.q, new FrameLayout.LayoutParams(-1, -1));
        }
    }

    public final void C() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            View inflate = LayoutInflater.from(this.f30034c).inflate(b.a.w.c.a.d.live_feed_page_tab_layout, (ViewGroup) null);
            this.f30036e = inflate;
            this.f30037f = inflate.findViewById(b.a.w.c.a.c.live_tab_root_container);
            this.f30038g = (AppBarLayout) this.f30036e.findViewById(b.a.w.c.a.c.live_tab_appbar_layout);
            this.o = (FrameLayout) this.f30036e.findViewById(b.a.w.c.a.c.live_tab_content_container);
            this.j = (SmartTabLayout) this.f30036e.findViewById(b.a.w.c.a.c.live_tab_top_tab_layout);
            this.k = (RecyclerView) this.f30036e.findViewById(b.a.w.c.a.c.live_tab_top_tab_sub_tag_layout);
            this.l = (RecyclerView) this.f30036e.findViewById(b.a.w.c.a.c.live_tab_top_concern_list_layout);
            this.t = (LinearLayout) this.f30036e.findViewById(b.a.w.c.a.c.live_tab_base_container);
            this.u = this.f30036e.findViewById(b.a.w.c.a.c.live_tab_top_space_layout);
            this.v = (LinearLayout) this.f30036e.findViewById(b.a.w.c.a.c.live_tab_top_start_live_layout);
            this.w = (TextView) this.f30036e.findViewById(b.a.w.c.a.c.live_tab_top_start_live_tv);
            this.y = this.f30036e.findViewById(b.a.w.c.a.c.live_tab_top_tab_divider_view);
            FakeStartLiveButton fakeStartLiveButton = (FakeStartLiveButton) this.f30036e.findViewById(b.a.w.c.a.c.live_feed_page_fake_start_live_id);
            this.x = fakeStartLiveButton;
            fakeStartLiveButton.setOnClickListener(new c(this));
            ImageView imageView = (ImageView) this.f30036e.findViewById(b.a.w.c.a.c.live_feed_page_imm_back_btn);
            this.z = imageView;
            imageView.setOnClickListener(new d(this));
            this.z.setVisibility(this.G ? 0 : 8);
            if (this.G && b.a.w.e.g.c.a()) {
                this.f30036e.setPadding(0, b.a.w.e.g.c.d(this.f30034c), 0, 0);
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
            NestedNoScrollViewPager nestedNoScrollViewPager = (NestedNoScrollViewPager) this.f30036e.findViewById(b.a.w.c.a.c.live_tab_view_pager);
            this.f30039h = nestedNoScrollViewPager;
            nestedNoScrollViewPager.setId(View.generateViewId());
            this.f30039h.setOffscreenPageLimit(1);
            this.f30039h.setSaveEnabled(false);
            if ("immersion".equals(this.A)) {
                this.f30039h.setCanScrollHorizontally(true);
            }
            this.j.setOnPageChangeListener(new f(this));
            this.j.setOnTabClickListener(new g(this));
            BaiduLiveTabAdapter baiduLiveTabAdapter = new BaiduLiveTabAdapter(this.f30035d, this.f30033b, this.G, this.f30032a);
            this.f30040i = baiduLiveTabAdapter;
            this.f30039h.setAdapter(baiduLiveTabAdapter);
            this.j.setAllTabIsBold(false);
            this.j.setTabSelectedColorEnable(true);
            this.j.setShowBottomLine(this.G);
            this.j.setDarkModeCompatColor("color_FF33551", "color_1F1F1F");
            this.j.setIsImmersion(this.G);
            LiveFeedPageSubTipAdapter liveFeedPageSubTipAdapter = new LiveFeedPageSubTipAdapter(this.f30034c, this.G);
            this.m = liveFeedPageSubTipAdapter;
            liveFeedPageSubTipAdapter.setOnItemClickListener(new h(this));
            this.k.setAdapter(this.m);
            if (this.G) {
                RecyclerView recyclerView = this.k;
                if (recyclerView != null) {
                    recyclerView.setPadding(0, b.a.w.b.f.a.a(this.f30034c, 11.0f), 0, b.a.w.b.f.a.a(this.f30034c, 8.0f));
                }
                RecyclerView recyclerView2 = this.l;
                if (recyclerView2 != null) {
                    recyclerView2.setPadding(0, 0, 0, b.a.w.b.f.a.a(this.f30034c, 9.0f));
                }
            }
            LiveFeedPageConcernAdapter liveFeedPageConcernAdapter = new LiveFeedPageConcernAdapter(this.f30034c, this.G, this.f30032a);
            this.n = liveFeedPageConcernAdapter;
            this.l.setAdapter(liveFeedPageConcernAdapter);
            B();
            LoadingView loadingView = (LoadingView) this.f30036e.findViewById(b.a.w.c.a.c.live_tab_loading);
            this.r = loadingView;
            loadingView.onDarkModeChange(this.G);
            P(this.r);
            ErrorView errorView = (ErrorView) this.f30036e.findViewById(b.a.w.c.a.c.live_tab_error);
            this.s = errorView;
            errorView.setActionCallback(new i(this));
            E("day");
        }
    }

    public void D() {
        b.a.w.b.d.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || (aVar = this.p) == null) {
            return;
        }
        aVar.g();
    }

    public void E(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, str) == null) {
            View view = this.f30036e;
            if (view != null) {
                view.setBackgroundColor(b.a.w.i.f.e().a(this.f30034c, this.G, "color_white1"));
            }
            View view2 = this.u;
            if (view2 != null) {
                view2.setBackgroundColor(b.a.w.i.f.e().a(this.f30034c, this.G, "color_F5F5F52"));
            }
            TextView textView = this.w;
            if (textView != null) {
                textView.setTextColor(b.a.w.i.f.e().a(this.f30034c, this.G, "color_1F1F1F"));
            }
            BaiduLiveTabAdapter baiduLiveTabAdapter = this.f30040i;
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
            SmartTabLayout smartTabLayout = this.j;
            if (smartTabLayout != null) {
                smartTabLayout.onDarkModeChange(str);
            }
        }
    }

    public void F() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            b.a.w.e.c.d.a().e(this);
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
            b.a.w.b.f.f.b();
            BaiduLiveTabAdapter baiduLiveTabAdapter = this.f30040i;
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
        if (!(interceptable == null || interceptable.invokeV(1048582, this) == null) || (baiduLiveTabAdapter = this.f30040i) == null || (nestedNoScrollViewPager = this.f30039h) == null) {
            return;
        }
        baiduLiveTabAdapter.externalRefresh(nestedNoScrollViewPager.getCurrentItem(), true, true);
    }

    public final void H() {
        BaiduLiveTabAdapter baiduLiveTabAdapter;
        NestedNoScrollViewPager nestedNoScrollViewPager;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048583, this) == null) || (baiduLiveTabAdapter = this.f30040i) == null || (nestedNoScrollViewPager = this.f30039h) == null) {
            return;
        }
        baiduLiveTabAdapter.onHintLog(nestedNoScrollViewPager.getCurrentItem());
    }

    public final void I() {
        NestedNoScrollViewPager nestedNoScrollViewPager;
        NestedNoScrollViewPager nestedNoScrollViewPager2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            BaiduLiveTabAdapter baiduLiveTabAdapter = this.f30040i;
            if (baiduLiveTabAdapter != null && (nestedNoScrollViewPager2 = this.f30039h) != null) {
                baiduLiveTabAdapter.onShowLog(nestedNoScrollViewPager2.getCurrentItem());
            }
            if (this.H.a()) {
                BaiduLiveTabAdapter baiduLiveTabAdapter2 = this.f30040i;
                if (baiduLiveTabAdapter2 != null && (nestedNoScrollViewPager = this.f30039h) != null) {
                    baiduLiveTabAdapter2.externalRefresh(nestedNoScrollViewPager.getCurrentItem(), true, true);
                }
            } else {
                b.a.w.b.d.a aVar = this.p;
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

    public final void M(b.a.w.b.d.c.a aVar) {
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
            if (!b.a.w.e.g.d.c(aVar.f30065a)) {
                List<LiveBannerEntity> list = aVar.f30065a;
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
        if (!(interceptable == null || interceptable.invokeV(1048590, this) == null) || (context = this.f30034c) == null || this.J) {
            return;
        }
        this.K = NetWorkUtils.b(context);
        LiveFeedPageSdk.l("注册网络变化广播");
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
        this.f30034c.registerReceiver(this.O, intentFilter);
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
            View view2 = this.f30037f;
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
        if ((interceptable == null || interceptable.invokeV(1048592, this) == null) && this.f30034c != null && this.J) {
            LiveFeedPageSdk.l("解注册网络变化广播");
            this.f30034c.unregisterReceiver(this.O);
            this.J = false;
        }
    }

    public final void R() {
        BaiduLiveTabAdapter baiduLiveTabAdapter;
        NestedNoScrollViewPager nestedNoScrollViewPager;
        LiveTabEntity subTab;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048593, this) == null) || (baiduLiveTabAdapter = this.f30040i) == null || (nestedNoScrollViewPager = this.f30039h) == null || (subTab = baiduLiveTabAdapter.getSubTab(nestedNoScrollViewPager.getCurrentItem())) == null || TextUtils.isEmpty(subTab.type)) {
            return;
        }
        LiveTabEntity.TabLabelInfo selectSubTabInfo = this.m.getSelectSubTabInfo();
        this.f30040i.updateTabInfo(subTab.type, selectSubTabInfo != null ? selectSubTabInfo.type : "", this.f30039h.getCurrentItem());
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

    public final void t(b.a.w.b.d.c.c cVar) {
        b.a.w.b.d.c.g gVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048598, this, cVar) == null) {
            if (cVar != null && (gVar = cVar.f30074g) != null && !b.a.w.e.g.d.c(gVar.f30092c)) {
                w(cVar);
                P(this.f30037f);
                this.I = true;
                if (cVar.f30074g.f30093d) {
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
        return (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) ? this.f30036e : (View) invokeV.objValue;
    }

    public final void v(b.a.w.b.d.c.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048600, this, bVar) == null) {
            this.B = bVar;
            if (bVar != null) {
                this.H.b(bVar.f30067b * 1000);
            }
        }
    }

    public final void w(b.a.w.b.d.c.c cVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048601, this, cVar) == null) || cVar == null) {
            return;
        }
        v(cVar.f30076i);
        M(cVar.f30072e);
        A(cVar);
        z(b.a.w.b.f.f.a());
        x(cVar.f30073f);
    }

    public final void x(b.a.w.b.d.c.e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048602, this, eVar) == null) {
            if (eVar != null) {
                if (!b.a.w.e.g.d.c(eVar.f30084a)) {
                    this.n.setConcernList(eVar.f30084a);
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
        b.a.w.b.d.c.b bVar = this.B;
        if (bVar != null && !TextUtils.isEmpty(bVar.f30066a)) {
            c2 = this.B.f30066a;
        } else {
            c2 = LiveFeedPageSdk.e().c();
        }
        LiveFeedPageSdk.e().f().invokeScheme(this.f30034c, c2);
    }

    public final void z(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048604, this, i2) == null) {
            if (!b.a.w.e.g.d.c(this.F)) {
                if (i2 >= 0 && i2 < this.F.size()) {
                    List<LiveTabEntity.TabLabelInfo> list = this.F.get(i2).subTabList;
                    if (!b.a.w.e.g.d.c(list)) {
                        this.m.setSubTabList(list);
                        R();
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
            this.t.setMinimumHeight(b.a.w.b.f.a.a(this.f30034c, this.k.getVisibility() == 0 ? i3 : 42));
        }
    }

    /* loaded from: classes6.dex */
    public static class k {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public long f30050a;

        /* renamed from: b  reason: collision with root package name */
        public long f30051b;

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
            this.f30050a = 180000L;
        }

        public boolean a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                LiveFeedPageSdk.l("onShow   " + (System.currentTimeMillis() - this.f30051b));
                return System.currentTimeMillis() - this.f30051b > this.f30050a;
            }
            return invokeV.booleanValue;
        }

        public void b(long j) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j) == null) || j <= 0) {
                return;
            }
            this.f30050a = j;
        }

        public void c() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                this.f30051b = System.currentTimeMillis();
            }
        }

        public /* synthetic */ k(b bVar) {
            this();
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // b.a.w.e.c.a
    public void call(b.a.w.b.b.a aVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048594, this, aVar) == null) && aVar != null && aVar.a() == this.f30033b) {
            LiveFeedPageSdk.l("LiveEventBus event: " + aVar.getClass() + GlideException.IndentedAppendable.INDENT + aVar.a());
            if (aVar instanceof b.a.w.b.b.b) {
                b.a.w.b.d.c.a aVar2 = ((b.a.w.b.b.b) aVar).f30053b;
                if (aVar2 != null) {
                    M(aVar2);
                }
            } else if (aVar instanceof b.a.w.b.b.d) {
                b.a.w.b.d.c.e eVar = ((b.a.w.b.b.d) aVar).f30054b;
                if (eVar != null) {
                    x(eVar);
                }
            } else if (aVar instanceof b.a.w.b.b.c) {
                this.H.c();
            }
        }
    }
}
