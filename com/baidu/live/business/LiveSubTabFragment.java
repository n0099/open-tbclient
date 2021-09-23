package com.baidu.live.business;

import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.InputDeviceCompat;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import c.a.w.b.d.a;
import c.a.w.e.g.j;
import c.a.w.i.f;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.live.LiveFeedPageSdk;
import com.baidu.live.business.adapter.LiveSubTabAdapter;
import com.baidu.live.business.base.LiveBaseFragment;
import com.baidu.live.business.model.data.LiveFeedWrapData;
import com.baidu.live.business.model.data.LiveRoomEntity;
import com.baidu.live.business.model.data.LiveTabEntity;
import com.baidu.live.business.refresh.BdSwipeRefreshLayout;
import com.baidu.live.business.view.emotion.EmptyView;
import com.baidu.live.business.view.emotion.ErrorView;
import com.baidu.live.business.view.emotion.LoadingView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.ubc.Flow;
import com.bumptech.glide.load.engine.GlideException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class LiveSubTabFragment extends LiveBaseFragment {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public View f40799e;

    /* renamed from: f  reason: collision with root package name */
    public RecyclerView f40800f;

    /* renamed from: g  reason: collision with root package name */
    public View f40801g;

    /* renamed from: h  reason: collision with root package name */
    public c.a.w.b.e.e f40802h;

    /* renamed from: i  reason: collision with root package name */
    public BdSwipeRefreshLayout f40803i;

    /* renamed from: j  reason: collision with root package name */
    public LoadingView f40804j;
    public ErrorView k;
    public EmptyView l;
    public LiveSubTabAdapter m;
    public final List<LiveRoomEntity> n;
    public final Set<String> o;
    public int p;
    public boolean q;
    public boolean r;
    public boolean s;
    public String t;
    public int u;
    public Flow v;
    public BdSwipeRefreshLayout.j w;
    public RecyclerView.OnScrollListener x;
    public a.b y;

    /* loaded from: classes5.dex */
    public class a implements BdSwipeRefreshLayout.j {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ LiveSubTabFragment f40805a;

        public a(LiveSubTabFragment liveSubTabFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {liveSubTabFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f40805a = liveSubTabFragment;
        }

        @Override // com.baidu.live.business.refresh.BdSwipeRefreshLayout.j
        public void onRefresh() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.f40805a.f40803i != null) {
                    this.f40805a.f40803i.setRefreshing(true);
                }
                this.f40805a.refreshFeedAndFollowAndBanner();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b extends RecyclerView.OnScrollListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public int f40806a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ LiveSubTabFragment f40807b;

        public b(LiveSubTabFragment liveSubTabFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {liveSubTabFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f40807b = liveSubTabFragment;
            this.f40806a = 0;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, recyclerView, i2) == null) {
                super.onScrollStateChanged(recyclerView, i2);
                if (i2 == 0 && this.f40806a + 4 >= this.f40807b.m.getItemCount() && this.f40807b.p == 0 && this.f40807b.r) {
                    this.f40807b.p = 1;
                    this.f40807b.loadMore();
                    c.a.w.b.c.a.t(recyclerView.getContext(), this.f40807b.t, this.f40807b.isImmer ? "chenjinshi" : "zhibopindao", this.f40807b.tab, this.f40807b.subTab);
                }
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrolled(RecyclerView recyclerView, int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, recyclerView, i2, i3) == null) {
                this.f40806a = this.f40807b.getLastVisiblePosition();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class c implements a.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ LiveSubTabFragment f40808a;

        public c(LiveSubTabFragment liveSubTabFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {liveSubTabFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f40808a = liveSubTabFragment;
        }

        @Override // c.a.w.b.d.a.b
        public void a(c.a.w.b.d.c.c cVar, Map<String, String> map) {
            boolean z;
            LiveFeedWrapData liveFeedWrapData;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, cVar, map) == null) {
                if (cVar != null && !j.a(cVar.f30431d)) {
                    if (cVar.f30431d.contains("banner") && cVar.f30432e != null) {
                        c.a.w.b.b.b bVar = new c.a.w.b.b.b();
                        bVar.f30413b = cVar.f30432e;
                        bVar.b(this.f40808a.u);
                        c.a.w.e.c.d.a().b(bVar);
                    }
                    if (cVar.f30431d.contains("follow") && cVar.f30433f != null) {
                        c.a.w.b.b.d dVar = new c.a.w.b.b.d();
                        dVar.f30414b = cVar.f30433f;
                        dVar.b(this.f40808a.u);
                        c.a.w.e.c.d.a().b(dVar);
                    }
                    LiveFeedWrapData liveFeedWrapData2 = cVar.f30435h;
                    if (liveFeedWrapData2 != null) {
                        if (this.f40808a.isValidData(liveFeedWrapData2.tab, liveFeedWrapData2.subTab, liveFeedWrapData2.refreshType)) {
                            this.f40808a.requestKey = "";
                            this.f40808a.sessionId = cVar.f30435h.sessionId;
                            this.f40808a.feedStabilityLog(cVar.f30435h, this.f40808a.B(cVar.f30435h));
                            z = !c.a.w.e.g.d.c(cVar.f30435h.roomInfoList);
                        } else {
                            z = false;
                        }
                        this.f40808a.r = cVar.f30435h.hasMore;
                        this.f40808a.refreshIndex = cVar.f30435h.refreshIndex;
                        if (cVar.f30435h.isBigRefresh()) {
                            c.a.w.e.c.d.a().b(new c.a.w.b.b.c(this.f40808a.u));
                        }
                    } else {
                        this.f40808a.r = false;
                        z = false;
                    }
                    this.f40808a.J();
                    if (c.a.w.e.g.d.c(this.f40808a.n) && !z) {
                        LiveSubTabFragment liveSubTabFragment = this.f40808a;
                        EmptyView emptyView = liveSubTabFragment.l;
                        int i2 = cVar.f30428a;
                        LiveFeedWrapData liveFeedWrapData3 = cVar.f30435h;
                        liveSubTabFragment.K(emptyView, i2, liveFeedWrapData3, cVar.f30430c, liveFeedWrapData3 != null ? liveFeedWrapData3.sessionId : "", cVar.f30431d);
                        return;
                    }
                    LiveSubTabFragment liveSubTabFragment2 = this.f40808a;
                    liveSubTabFragment2.show(liveSubTabFragment2.f40803i);
                    if (cVar == null || (liveFeedWrapData = cVar.f30435h) == null || !liveFeedWrapData.isBigRefresh() || this.f40808a.f40800f == null) {
                        return;
                    }
                    this.f40808a.f40800f.smoothScrollBy(0, 1);
                    return;
                }
                b(-100, "数据解析失败", map);
            }
        }

        @Override // c.a.w.b.d.a.b
        public void b(int i2, String str, Map<String, String> map) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeILL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, str, map) == null) && map != null && this.f40808a.isValidData(map.get("tab"), map.get("subtab"), Integer.valueOf(map.get("refresh_type")).intValue())) {
                this.f40808a.requestKey = "";
                this.f40808a.r = false;
                this.f40808a.J();
                if (String.valueOf(0).equals(map.get("refresh_type"))) {
                    LiveSubTabFragment liveSubTabFragment = this.f40808a;
                    liveSubTabFragment.K(liveSubTabFragment.k, i2, null, "", map.get("session_id"), map.get("resource"));
                    return;
                }
                LiveFeedPageSdk.e().f().c(this.f40808a.getActivity(), "服务器太累了，请稍后重试");
            }
        }
    }

    /* loaded from: classes5.dex */
    public class d extends StaggeredGridLayoutManager {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ LiveSubTabFragment f40809a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(LiveSubTabFragment liveSubTabFragment, int i2, int i3) {
            super(i2, i3);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {liveSubTabFragment, Integer.valueOf(i2), Integer.valueOf(i3)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i4 = newInitContext.flag;
                if ((i4 & 1) != 0) {
                    int i5 = i4 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super(((Integer) objArr2[0]).intValue(), ((Integer) objArr2[1]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f40809a = liveSubTabFragment;
        }

        @Override // androidx.recyclerview.widget.StaggeredGridLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
        public void onLayoutChildren(RecyclerView.Recycler recycler, RecyclerView.State state) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, recycler, state) == null) {
                try {
                    super.onLayoutChildren(recycler, state);
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class e implements ErrorView.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ LiveSubTabFragment f40810a;

        public e(LiveSubTabFragment liveSubTabFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {liveSubTabFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f40810a = liveSubTabFragment;
        }

        @Override // com.baidu.live.business.view.emotion.ErrorView.b
        public void a(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f40810a.refresh(false, true);
            }
        }
    }

    public LiveSubTabFragment() {
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
        this.n = new ArrayList();
        this.o = new HashSet();
        this.p = 0;
        this.q = false;
        this.r = false;
        this.s = true;
        this.w = new a(this);
        this.x = new b(this);
        this.y = new c(this);
    }

    public static LiveSubTabFragment newInstance(Bundle bundle) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65552, null, bundle)) == null) {
            LiveSubTabFragment liveSubTabFragment = new LiveSubTabFragment();
            if (bundle != null) {
                liveSubTabFragment.setArguments(bundle);
            }
            return liveSubTabFragment;
        }
        return (LiveSubTabFragment) invokeL.objValue;
    }

    public final int B(LiveFeedWrapData liveFeedWrapData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, liveFeedWrapData)) == null) {
            if (liveFeedWrapData != null) {
                if (liveFeedWrapData.refreshType == 0) {
                    this.n.clear();
                    this.o.clear();
                }
                if (!c.a.w.e.g.d.c(liveFeedWrapData.roomInfoList)) {
                    ArrayList arrayList = new ArrayList();
                    for (LiveRoomEntity liveRoomEntity : liveFeedWrapData.roomInfoList) {
                        if (liveRoomEntity != null && !j.a(liveRoomEntity.roomId) && this.o.add(liveRoomEntity.roomId)) {
                            arrayList.add(liveRoomEntity);
                        }
                    }
                    this.n.addAll(arrayList);
                    int size = arrayList.size();
                    this.m.addNew(this.n);
                    return size;
                }
            }
            return 0;
        }
        return invokeL.intValue;
    }

    public final void D() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            LiveSubTabAdapter liveSubTabAdapter = new LiveSubTabAdapter(getContext(), this.isImmer, this.t, this.tab, this.subTab);
            this.m = liveSubTabAdapter;
            this.f40800f.setAdapter(liveSubTabAdapter);
        }
    }

    public final void J() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            BdSwipeRefreshLayout bdSwipeRefreshLayout = this.f40803i;
            if (bdSwipeRefreshLayout != null) {
                bdSwipeRefreshLayout.setRefreshing(false);
            }
            this.p = 0;
            if (this.m == null || c.a.w.e.g.d.c(this.n)) {
                return;
            }
            this.m.setHasMore(this.r);
            LiveSubTabAdapter liveSubTabAdapter = this.m;
            liveSubTabAdapter.notifyItemChanged(liveSubTabAdapter.getItemCount() - 1);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x003e  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0043  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void K(View view, int i2, LiveFeedWrapData liveFeedWrapData, String str, String str2, String str3) {
        JSONObject jSONObject;
        LiveFeedWrapData liveFeedWrapData2;
        int i3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{view, Integer.valueOf(i2), liveFeedWrapData, str, str2, str3}) == null) {
            String a2 = c.a.w.b.f.c.a(LiveFeedWrapData.getFeedCacheKey(this.tab, this.subTab), "");
            LiveFeedWrapData liveFeedWrapData3 = null;
            if (!TextUtils.isEmpty(a2)) {
                try {
                    jSONObject = new JSONObject(a2);
                    liveFeedWrapData2 = new LiveFeedWrapData();
                } catch (JSONException unused) {
                }
                try {
                    liveFeedWrapData2.parserJson(jSONObject, -1);
                    liveFeedWrapData2.isCacheData = true;
                    liveFeedWrapData3 = liveFeedWrapData2;
                } catch (JSONException unused2) {
                    liveFeedWrapData3 = liveFeedWrapData2;
                    c.a.w.b.f.c.e(LiveFeedWrapData.getFeedCacheKey(this.tab, this.subTab));
                    if (liveFeedWrapData3 != null) {
                    }
                }
            }
            if (liveFeedWrapData3 != null) {
                show(view);
                return;
            }
            B(liveFeedWrapData3);
            this.r = liveFeedWrapData3.hasMore;
            this.sessionId = liveFeedWrapData3.sessionId;
            J();
            if (c.a.w.e.g.d.c(liveFeedWrapData3.roomInfoList)) {
                show(view);
            } else {
                show(this.f40803i);
                if (LiveFeedPageSdk.e().f() != null) {
                    LiveFeedPageSdk.e().f().c(getActivity(), "服务器太累了，请稍后重试");
                }
            }
            if (liveFeedWrapData3.isCacheData) {
                if (i2 == -101) {
                    i3 = 1;
                } else {
                    i3 = (liveFeedWrapData == null || liveFeedWrapData.errCode == 0) ? 2 : 3;
                }
                c.a.w.b.c.a.o(getActivity(), this.t, c.a.w.b.c.a.m(this.isImmer), liveFeedWrapData == null ? -100 : liveFeedWrapData.errCode, liveFeedWrapData != null ? liveFeedWrapData.errMsg : "", str, str3, this.tab, this.subTab, str2, i3, "feed", liveFeedWrapData3.cacheTime, System.currentTimeMillis(), 1);
            }
        }
    }

    public void feedStabilityLog(LiveFeedWrapData liveFeedWrapData, int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(1048580, this, liveFeedWrapData, i2) == null) || liveFeedWrapData == null) {
            return;
        }
        c.a.w.b.c.a.g(getActivity(), this.t, c.a.w.b.c.a.m(this.isImmer), liveFeedWrapData.errCode, liveFeedWrapData.errMsg, liveFeedWrapData.tab, liveFeedWrapData.subTab, liveFeedWrapData.sessionId, c.a.w.e.g.d.c(liveFeedWrapData.roomInfoList) ? 0 : liveFeedWrapData.roomInfoList.size(), i2, liveFeedWrapData.refreshType, liveFeedWrapData.refreshIndex);
    }

    @Override // com.baidu.live.business.base.LiveBaseFragment
    public RecyclerView getRecyclerView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f40800f : (RecyclerView) invokeV.objValue;
    }

    public final void initView() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            BdSwipeRefreshLayout bdSwipeRefreshLayout = (BdSwipeRefreshLayout) this.f40799e.findViewById(c.a.w.c.a.c.sub_frag_swipelayout);
            this.f40803i = bdSwipeRefreshLayout;
            bdSwipeRefreshLayout.setOnRefreshListener(this.w);
            RecyclerView recyclerView = (RecyclerView) this.f40799e.findViewById(c.a.w.c.a.c.sub_frag_recyclerview);
            this.f40800f = recyclerView;
            recyclerView.setLayoutManager(new d(this, 2, 1));
            this.f40800f.setItemAnimator(null);
            this.f40800f.addItemDecoration(new LiveItemDecoration(c.a.w.b.f.a.a(getContext(), 7.0f)));
            this.f40800f.setOverScrollMode(2);
            this.f40800f.addOnScrollListener(this.x);
            c.a.w.b.e.e eVar = new c.a.w.b.e.e(getContext());
            this.f40802h = eVar;
            this.f40803i.setProgressView(eVar);
            this.f40802h.u(this.isImmer);
            LoadingView loadingView = (LoadingView) this.f40799e.findViewById(c.a.w.c.a.c.sub_frag_loading);
            this.f40804j = loadingView;
            loadingView.onDarkModeChange(this.isImmer);
            ErrorView errorView = (ErrorView) this.f40799e.findViewById(c.a.w.c.a.c.sub_frag_error);
            this.k = errorView;
            errorView.onDarkModeChange(this.isImmer);
            EmptyView emptyView = (EmptyView) this.f40799e.findViewById(c.a.w.c.a.c.sub_frag_empty);
            this.l = emptyView;
            emptyView.onDarkModeChange(this.isImmer);
            this.k.setActionCallback(new e(this));
            this.f40801g = this.f40799e.findViewById(c.a.w.c.a.c.live_feed_page_sub_grag_gradient_space);
            D();
        }
    }

    public final void lazyLoad() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            LiveFeedPageSdk.l("LiveSubTabFragment lazyLoad needNewCreate" + this.needNewCreate + "  needLoadData " + this.s + "  tab " + this.tab + "  subTab " + this.subTab);
            if (this.needNewCreate && this.s) {
                this.needNewCreate = false;
                this.s = false;
                LiveFeedWrapData liveFeedWrapData = this.mFeedWrapData;
                if (liveFeedWrapData != null && this.tab.equals(liveFeedWrapData.tab) && this.subTab.equals(this.mFeedWrapData.subTab)) {
                    LiveFeedWrapData liveFeedWrapData2 = this.mFeedWrapData;
                    if (liveFeedWrapData2 != null) {
                        feedStabilityLog(this.mFeedWrapData, B(liveFeedWrapData2));
                        LiveFeedWrapData liveFeedWrapData3 = this.mFeedWrapData;
                        this.r = liveFeedWrapData3.hasMore;
                        this.sessionId = liveFeedWrapData3.sessionId;
                        J();
                        if (c.a.w.e.g.d.c(this.n) && c.a.w.e.g.d.c(this.mFeedWrapData.roomInfoList)) {
                            EmptyView emptyView = this.l;
                            LiveFeedWrapData liveFeedWrapData4 = this.mFeedWrapData;
                            K(emptyView, 0, liveFeedWrapData4, "", liveFeedWrapData4.sessionId, "banner,tab,feed,follow,config");
                            return;
                        }
                        show(this.f40803i);
                        return;
                    }
                    return;
                }
                refreshFeed();
                RecyclerView recyclerView = this.f40800f;
                if (recyclerView != null) {
                    recyclerView.scrollToPosition(0);
                }
                show(this.f40804j);
            }
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, bundle) == null) {
            super.onActivityCreated(bundle);
        }
    }

    @Override // com.baidu.live.business.base.LiveBaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, bundle) == null) {
            super.onCreate(bundle);
            LiveFeedPageSdk.l("onCreate :  tab " + this.tab + "  subTab " + this.subTab);
            this.isImmer = getArguments().getBoolean(LiveBaseFragment.TAB_IS_IMMER);
            this.u = getArguments().getInt(LiveBaseFragment.TAB_BD_ID);
            this.t = getArguments().getString("source");
            this.mTabItem = (LiveTabEntity) getArguments().getParcelable(LiveBaseFragment.TAB_ENTITY_ITEM);
            this.mFeedWrapData = (LiveFeedWrapData) getArguments().getParcelable(LiveBaseFragment.TAB_FEED_DATA);
            LiveTabEntity liveTabEntity = this.mTabItem;
            this.tab = liveTabEntity.type;
            this.channelId = liveTabEntity.channelId;
            if (!c.a.w.e.g.d.c(liveTabEntity.subTabList)) {
                Iterator<LiveTabEntity.TabLabelInfo> it = this.mTabItem.subTabList.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    LiveTabEntity.TabLabelInfo next = it.next();
                    if (next != null && next.selected) {
                        this.subTab = next.type;
                        break;
                    }
                }
            }
            this.mPosition = getArguments().getInt(LiveBaseFragment.TAB_POSITION);
            this.needNewCreate = true;
        }
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048586, this, layoutInflater, viewGroup, bundle)) == null) {
            LiveFeedPageSdk.l("LiveSubTabFragment onCreateView :  tab " + this.tab + "  subTab " + this.subTab);
            View view = this.f40799e;
            if (view == null) {
                this.f40799e = layoutInflater.inflate(c.a.w.c.a.d.live_feed_page_sub_fragment_layout, (ViewGroup) null);
                initView();
            } else {
                ViewGroup viewGroup2 = (ViewGroup) view.getParent();
                if (viewGroup2 != null) {
                    viewGroup2.removeView(this.f40799e);
                }
            }
            if (this.mModel == null) {
                this.mModel = new c.a.w.b.d.a(getContext(), this.isImmer, this.t);
            }
            this.mModel.i(this.y);
            return this.f40799e;
        }
        return (View) invokeLLL.objValue;
    }

    @Override // com.baidu.live.business.base.LiveBaseFragment
    public void onDarkModeChange(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048587, this, str) == null) && this.q) {
            this.f40799e.setBackgroundColor(f.e().a(getContext(), this.isImmer, "color_F5F5F51"));
            GradientDrawable gradientDrawable = new GradientDrawable();
            gradientDrawable.setColors(new int[]{f.e().a(getContext(), this.isImmer, "color_white1"), f.e().a(getContext(), this.isImmer, "color_F5F5F51")});
            gradientDrawable.setGradientType(0);
            gradientDrawable.setOrientation(GradientDrawable.Orientation.TOP_BOTTOM);
            this.f40801g.setBackgroundDrawable(gradientDrawable);
            LiveSubTabAdapter liveSubTabAdapter = this.m;
            if (liveSubTabAdapter != null) {
                liveSubTabAdapter.notifyDataSetChanged();
            }
            c.a.w.b.e.e eVar = this.f40802h;
            if (eVar != null) {
                eVar.u(this.isImmer);
            }
            ErrorView errorView = this.k;
            if (errorView != null) {
                errorView.onDarkModeChange(this.isImmer);
            }
            EmptyView emptyView = this.l;
            if (emptyView != null) {
                emptyView.onDarkModeChange(this.isImmer);
            }
            LoadingView loadingView = this.f40804j;
            if (loadingView != null) {
                loadingView.onDarkModeChange(this.isImmer);
            }
        }
    }

    @Override // com.baidu.live.business.base.LiveBaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            super.onDestroy();
            LiveFeedPageSdk.l("LiveSubTabFragment onDestroy :  tab " + this.tab + "  subTab " + this.subTab);
            this.s = true;
            this.needNewCreate = true;
            this.q = false;
            this.r = false;
            this.n.clear();
            this.o.clear();
            LoadingView loadingView = this.f40804j;
            if (loadingView != null) {
                loadingView.destroy();
            }
            BdSwipeRefreshLayout bdSwipeRefreshLayout = this.f40803i;
            if (bdSwipeRefreshLayout != null) {
                bdSwipeRefreshLayout.setRefreshing(false);
            }
        }
    }

    @Override // com.baidu.live.business.base.LiveBaseFragment
    public void onFragmentShow(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048589, this, z) == null) {
            LiveFeedPageSdk.l("LiveSubTabFragment onFragmentShow :" + z + "  tab " + this.tab + "  subTab " + this.subTab);
            if (z) {
                lazyLoad();
                onShowLog();
                return;
            }
            onHintLog();
        }
    }

    public void onHintLog() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048590, this) == null) || this.v == null) {
            return;
        }
        LiveFeedPageSdk.l("LivePageLog onHintLog  " + this.tab + GlideException.IndentedAppendable.INDENT + this.subTab + "   " + this.v.hashCode());
        c.a.w.b.c.a.p(getActivity(), false, this.t, c.a.w.b.c.a.m(this.isImmer), this.tab, this.subTab, this.v);
        this.v = null;
    }

    @Override // androidx.fragment.app.Fragment
    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            super.onPause();
            this.f40804j.onPause();
            BdSwipeRefreshLayout bdSwipeRefreshLayout = this.f40803i;
            if (bdSwipeRefreshLayout != null) {
                bdSwipeRefreshLayout.setRefreshing(false);
            }
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            super.onResume();
            this.f40804j.onResume();
        }
    }

    public void onShowLog() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            this.v = c.a.w.b.c.a.p(getActivity(), true, this.t, c.a.w.b.c.a.m(this.isImmer), this.tab, this.subTab, null);
            LiveFeedPageSdk.l("LivePageLog onShowLog  " + this.tab + GlideException.IndentedAppendable.INDENT + this.subTab + "   " + this.v.hashCode());
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048594, this, view, bundle) == null) {
            super.onViewCreated(view, bundle);
            this.q = true;
            onDarkModeChange("day");
        }
    }

    public void refresh(boolean z, boolean z2) {
        boolean refreshFeedAndFollow;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048595, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) || this.mModel == null) {
            return;
        }
        if (z) {
            refreshFeedAndFollow = refreshFeedAndFollowAndBanner();
        } else {
            refreshFeedAndFollow = refreshFeedAndFollow();
        }
        if (!refreshFeedAndFollow || this.f40803i == null) {
            return;
        }
        if (this.n.isEmpty()) {
            show(this.f40804j);
        }
        RecyclerView recyclerView = this.f40800f;
        if (recyclerView != null) {
            recyclerView.scrollToPosition(0);
        }
        if (z2) {
            this.f40803i.setRefreshing(true);
        }
    }

    public void reset() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048596, this) == null) {
        }
    }

    public void show(View view) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048597, this, view) == null) || view == null) {
            return;
        }
        ErrorView errorView = this.k;
        if (errorView != null) {
            errorView.toggleVisible(view == errorView ? 0 : 8, this.isImmer);
        }
        EmptyView emptyView = this.l;
        if (emptyView != null) {
            emptyView.toggleVisible(view == emptyView ? 0 : 8, this.isImmer);
        }
        LoadingView loadingView = this.f40804j;
        if (loadingView != null) {
            loadingView.setVisibility(view == loadingView ? 0 : 8);
        }
        BdSwipeRefreshLayout bdSwipeRefreshLayout = this.f40803i;
        if (bdSwipeRefreshLayout != null) {
            bdSwipeRefreshLayout.setVisibility(view != bdSwipeRefreshLayout ? 8 : 0);
        }
    }

    public void updateTabInfo(String str, String str2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048598, this, str, str2) == null) || j.a(str) || j.a(str2) || !str.equals(this.tab)) {
            return;
        }
        this.subTab = str2;
        LiveSubTabAdapter liveSubTabAdapter = this.m;
        if (liveSubTabAdapter != null) {
            liveSubTabAdapter.setThirdLevelTab(str2);
        }
    }
}
