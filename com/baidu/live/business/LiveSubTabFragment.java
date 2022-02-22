package com.baidu.live.business;

import android.graphics.Rect;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import c.a.y.b.d.a;
import c.a.y.b.d.c.b;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.live.LiveFeedPageSdk;
import com.baidu.live.business.adapter.LiveSubTabAdapter;
import com.baidu.live.business.base.LiveBaseFragment;
import com.baidu.live.business.model.data.LiveFeedWrapData;
import com.baidu.live.business.model.data.LiveRoomEntity;
import com.baidu.live.business.model.data.LiveTabEntity;
import com.baidu.live.business.refresh.BdSwipeRefreshLayout;
import com.baidu.live.business.util.NetWorkUtils;
import com.baidu.live.business.view.emotion.EmptyView;
import com.baidu.live.business.view.emotion.ErrorView;
import com.baidu.live.business.view.emotion.LoadingView;
import com.baidu.live.framework.view.LiveFeedPageRoundRect;
import com.baidu.pyramid.runtime.service.ServiceManager;
import com.baidu.searchbox.launch.ExternalTransferSpeedStats;
import com.baidu.searchbox.launch.utils.SpeedStatsUtils;
import com.baidu.searchbox.live.interfaces.service.FloatingService;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.ubc.Flow;
import com.bumptech.glide.load.engine.GlideException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class LiveSubTabFragment extends LiveBaseFragment {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public a.b A;
    public int B;
    public int C;
    public c.a.y.e.a D;
    public c.a.y.e.a E;
    public boolean F;
    public Handler G;
    public ArrayList H;
    public Runnable I;

    /* renamed from: e  reason: collision with root package name */
    public View f34946e;

    /* renamed from: f  reason: collision with root package name */
    public RecyclerView f34947f;

    /* renamed from: g  reason: collision with root package name */
    public View f34948g;

    /* renamed from: h  reason: collision with root package name */
    public c.a.y.b.e.e f34949h;

    /* renamed from: i  reason: collision with root package name */
    public BdSwipeRefreshLayout f34950i;

    /* renamed from: j  reason: collision with root package name */
    public LoadingView f34951j;
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
    public Flow w;
    public Flow x;
    public BdSwipeRefreshLayout.j y;
    public RecyclerView.OnScrollListener z;

    /* loaded from: classes10.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ LiveSubTabFragment f34952e;

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
            this.f34952e = liveSubTabFragment;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f34952e.D == null) {
                return;
            }
            this.f34952e.D.detachFromContainer();
            this.f34952e.D.setPlayerListener(null);
            this.f34952e.D = null;
        }
    }

    /* loaded from: classes10.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ LiveSubTabFragment f34953e;

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
            this.f34953e = liveSubTabFragment;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f34953e.E == null) {
                return;
            }
            this.f34953e.E.detachFromContainer();
            this.f34953e.E.setPlayerListener(null);
            this.f34953e.E = null;
        }
    }

    /* loaded from: classes10.dex */
    public class c implements BdSwipeRefreshLayout.j {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ LiveSubTabFragment a;

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
            this.a = liveSubTabFragment;
        }

        @Override // com.baidu.live.business.refresh.BdSwipeRefreshLayout.j
        public void onRefresh() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.a.f34950i != null) {
                    this.a.f34950i.setRefreshing(true);
                }
                this.a.refreshFeedAndFollowAndBanner();
            }
        }
    }

    /* loaded from: classes10.dex */
    public class d extends RecyclerView.OnScrollListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public int a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ LiveSubTabFragment f34954b;

        public d(LiveSubTabFragment liveSubTabFragment) {
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
            this.f34954b = liveSubTabFragment;
            this.a = 0;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, recyclerView, i2) == null) {
                super.onScrollStateChanged(recyclerView, i2);
                if (i2 == 0) {
                    if (this.a + 4 >= this.f34954b.m.getItemCount() && this.f34954b.p == 0 && this.f34954b.r) {
                        this.f34954b.p = 1;
                        this.f34954b.loadMore();
                        c.a.y.b.c.a.v(recyclerView.getContext(), this.f34954b.t, this.f34954b.isImmer ? "chenjinshi" : "zhibopindao", this.f34954b.tab, this.f34954b.subTab);
                    }
                    this.f34954b.c0();
                }
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrolled(RecyclerView recyclerView, int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, recyclerView, i2, i3) == null) {
                this.a = this.f34954b.getLastVisiblePosition();
            }
        }
    }

    /* loaded from: classes10.dex */
    public class e implements a.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ LiveSubTabFragment a;

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
            this.a = liveSubTabFragment;
        }

        @Override // c.a.y.b.d.a.b
        public void a(c.a.y.b.d.c.c cVar, Map<String, String> map) {
            boolean z;
            LiveFeedWrapData liveFeedWrapData;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, cVar, map) == null) {
                if (cVar != null && !c.a.y.g.g.j.a(cVar.f26846d)) {
                    if (cVar.f26846d.contains(SpeedStatsUtils.UBC_VALUE_BANNER) && cVar.f26847e != null) {
                        c.a.y.b.b.b bVar = new c.a.y.b.b.b();
                        bVar.f26832b = cVar.f26847e;
                        bVar.b(this.a.u);
                        c.a.y.g.c.d.a().b(bVar);
                    }
                    if (cVar.f26846d.contains("follow") && cVar.f26848f != null) {
                        c.a.y.b.b.d dVar = new c.a.y.b.b.d();
                        dVar.f26833b = cVar.f26848f;
                        dVar.b(this.a.u);
                        c.a.y.g.c.d.a().b(dVar);
                    }
                    LiveFeedWrapData liveFeedWrapData2 = cVar.f26850h;
                    if (liveFeedWrapData2 != null) {
                        if (this.a.isValidData(liveFeedWrapData2.tab, liveFeedWrapData2.subTab, liveFeedWrapData2.refreshType)) {
                            this.a.requestKey = "";
                            this.a.sessionId = cVar.f26850h.sessionId;
                            this.a.feedStabilityLog(cVar.f26850h, this.a.i0(cVar.f26850h));
                            z = !c.a.y.g.g.d.c(cVar.f26850h.roomInfoList);
                        } else {
                            z = false;
                        }
                        this.a.r = cVar.f26850h.hasMore;
                        this.a.refreshIndex = cVar.f26850h.refreshIndex;
                        if (cVar.f26850h.isBigRefresh()) {
                            c.a.y.g.c.d.a().b(new c.a.y.b.b.c(this.a.u));
                        }
                    } else {
                        this.a.r = false;
                        z = false;
                    }
                    this.a.l0();
                    if (c.a.y.g.g.d.c(this.a.n) && !z) {
                        LiveSubTabFragment liveSubTabFragment = this.a;
                        EmptyView emptyView = liveSubTabFragment.l;
                        int i2 = cVar.a;
                        LiveFeedWrapData liveFeedWrapData3 = cVar.f26850h;
                        liveSubTabFragment.m0(emptyView, i2, liveFeedWrapData3, cVar.f26845c, liveFeedWrapData3 != null ? liveFeedWrapData3.sessionId : "", cVar.f26846d);
                        return;
                    }
                    LiveSubTabFragment liveSubTabFragment2 = this.a;
                    liveSubTabFragment2.show(liveSubTabFragment2.f34950i);
                    if (cVar == null || (liveFeedWrapData = cVar.f26850h) == null || !liveFeedWrapData.isBigRefresh() || this.a.f34947f == null) {
                        return;
                    }
                    this.a.f34947f.smoothScrollBy(0, 1);
                    return;
                }
                b(-100, "数据解析失败", map);
            }
        }

        @Override // c.a.y.b.d.a.b
        public void b(int i2, String str, Map<String, String> map) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeILL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, str, map) == null) && map != null && this.a.isValidData(map.get("tab"), map.get("subtab"), Integer.valueOf(map.get("refresh_type")).intValue())) {
                this.a.requestKey = "";
                this.a.r = false;
                this.a.l0();
                if (String.valueOf(0).equals(map.get("refresh_type"))) {
                    LiveSubTabFragment liveSubTabFragment = this.a;
                    liveSubTabFragment.m0(liveSubTabFragment.k, i2, null, "", map.get("session_id"), map.get("resource"));
                    return;
                }
                LiveFeedPageSdk.f().g().a(this.a.getActivity(), "服务器太累了，请稍后重试");
            }
        }
    }

    /* loaded from: classes10.dex */
    public class f implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ LiveSubTabFragment f34955e;

        public f(LiveSubTabFragment liveSubTabFragment) {
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
            this.f34955e = liveSubTabFragment;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f34955e.f0();
                this.f34955e.d0();
                this.f34955e.F = false;
            }
        }
    }

    /* loaded from: classes10.dex */
    public class g extends c.a.y.e.c.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ LiveRoomEntity a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ LiveSubTabFragment f34956b;

        public g(LiveSubTabFragment liveSubTabFragment, LiveRoomEntity liveRoomEntity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {liveSubTabFragment, liveRoomEntity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f34956b = liveSubTabFragment;
            this.a = liveRoomEntity;
        }

        @Override // com.baidu.searchbox.player.callback.IVideoPlayerCallback
        public void onEnd(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i2) == null) {
                this.f34956b.o0();
                if (i2 == 307) {
                    this.f34956b.H.add(Integer.valueOf(this.f34956b.B));
                    LiveSubTabFragment liveSubTabFragment = this.f34956b;
                    liveSubTabFragment.B = Math.max(liveSubTabFragment.B, this.f34956b.C) + 1;
                    this.f34956b.a0();
                }
            }
        }

        @Override // com.baidu.searchbox.player.callback.IVideoPlayerCallback
        public void onError(int i2, int i3, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, i3, str) == null) {
                String str2 = "player1 onError: " + str;
                this.f34956b.o0();
                this.f34956b.H.add(Integer.valueOf(this.f34956b.B));
                LiveSubTabFragment liveSubTabFragment = this.f34956b;
                liveSubTabFragment.B = Math.max(liveSubTabFragment.B, this.f34956b.C) + 1;
                this.f34956b.a0();
            }
        }

        @Override // com.baidu.searchbox.player.callback.IVideoPlayerCallback
        public void onInfo(int i2, int i3) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeII(Constants.METHOD_SEND_USER_MSG, this, i2, i3) == null) && i2 == 904) {
                this.f34956b.p0();
                View findViewByPosition = this.f34956b.f34947f.getLayoutManager().findViewByPosition(this.f34956b.B);
                if (findViewByPosition != null) {
                    this.f34956b.D.attachToContainer((LiveFeedPageRoundRect) findViewByPosition.findViewById(c.a.y.c.a.c.live_feed_page_item_cover_rect));
                }
            }
        }

        @Override // com.baidu.searchbox.player.callback.IVideoPlayerCallback
        public void onPause() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
                this.f34956b.o0();
            }
        }

        @Override // com.baidu.searchbox.player.callback.IVideoPlayerCallback
        public void onResume() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
                this.f34956b.p0();
            }
        }

        @Override // com.baidu.searchbox.player.callback.IVideoPlayerCallback
        public void onVideoSizeChanged(int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeII(1048581, this, i2, i3) == null) {
                LiveSubTabFragment liveSubTabFragment = this.f34956b;
                liveSubTabFragment.e0(i2, i3, this.a, liveSubTabFragment.D);
            }
        }
    }

    /* loaded from: classes10.dex */
    public class h extends c.a.y.e.c.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ LiveRoomEntity a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ LiveSubTabFragment f34957b;

        public h(LiveSubTabFragment liveSubTabFragment, LiveRoomEntity liveRoomEntity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {liveSubTabFragment, liveRoomEntity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f34957b = liveSubTabFragment;
            this.a = liveRoomEntity;
        }

        @Override // com.baidu.searchbox.player.callback.IVideoPlayerCallback
        public void onEnd(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i2) == null) {
                this.f34957b.q0();
                if (i2 == 307) {
                    this.f34957b.H.add(Integer.valueOf(this.f34957b.C));
                    LiveSubTabFragment liveSubTabFragment = this.f34957b;
                    liveSubTabFragment.C = Math.max(liveSubTabFragment.B, this.f34957b.C) + 1;
                    this.f34957b.b0();
                }
            }
        }

        @Override // com.baidu.searchbox.player.callback.IVideoPlayerCallback
        public void onError(int i2, int i3, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, i3, str) == null) {
                String str2 = "player2 onError: " + str;
                this.f34957b.q0();
                this.f34957b.H.add(Integer.valueOf(this.f34957b.C));
                LiveSubTabFragment liveSubTabFragment = this.f34957b;
                liveSubTabFragment.C = Math.max(liveSubTabFragment.B, this.f34957b.C) + 1;
                this.f34957b.b0();
            }
        }

        @Override // com.baidu.searchbox.player.callback.IVideoPlayerCallback
        public void onInfo(int i2, int i3) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeII(Constants.METHOD_SEND_USER_MSG, this, i2, i3) == null) && i2 == 904) {
                this.f34957b.r0();
                View findViewByPosition = this.f34957b.f34947f.getLayoutManager().findViewByPosition(this.f34957b.C);
                if (findViewByPosition != null) {
                    this.f34957b.E.attachToContainer((LiveFeedPageRoundRect) findViewByPosition.findViewById(c.a.y.c.a.c.live_feed_page_item_cover_rect));
                }
            }
        }

        @Override // com.baidu.searchbox.player.callback.IVideoPlayerCallback
        public void onPause() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
                this.f34957b.q0();
            }
        }

        @Override // com.baidu.searchbox.player.callback.IVideoPlayerCallback
        public void onResume() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
                this.f34957b.r0();
            }
        }

        @Override // com.baidu.searchbox.player.callback.IVideoPlayerCallback
        public void onVideoSizeChanged(int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeII(1048581, this, i2, i3) == null) {
                LiveSubTabFragment liveSubTabFragment = this.f34957b;
                liveSubTabFragment.e0(i2, i3, this.a, liveSubTabFragment.E);
            }
        }
    }

    /* loaded from: classes10.dex */
    public class i extends StaggeredGridLayoutManager {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ LiveSubTabFragment a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public i(LiveSubTabFragment liveSubTabFragment, int i2, int i3) {
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
            this.a = liveSubTabFragment;
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

    /* loaded from: classes10.dex */
    public class j implements ErrorView.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ LiveSubTabFragment a;

        public j(LiveSubTabFragment liveSubTabFragment) {
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
            this.a = liveSubTabFragment;
        }

        @Override // com.baidu.live.business.view.emotion.ErrorView.b
        public void a(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.a.refresh(false, true);
            }
        }
    }

    /* loaded from: classes10.dex */
    public class k implements LiveSubTabAdapter.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ LiveSubTabFragment a;

        public k(LiveSubTabFragment liveSubTabFragment) {
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
            this.a = liveSubTabFragment;
        }

        @Override // com.baidu.live.business.adapter.LiveSubTabAdapter.b
        public void a(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i2) == null) {
                if (i2 == this.a.B) {
                    if (this.a.D != null) {
                        this.a.D.detachFromContainer();
                        if (this.a.D.isPlaying()) {
                            this.a.D.stop();
                        }
                    }
                } else if (i2 != this.a.C || this.a.E == null) {
                } else {
                    this.a.E.detachFromContainer();
                    if (this.a.E.isPlaying()) {
                        this.a.E.stop();
                    }
                }
            }
        }

        @Override // com.baidu.live.business.adapter.LiveSubTabAdapter.b
        public void b(ViewGroup viewGroup, int i2, @NonNull LiveRoomEntity liveRoomEntity) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, viewGroup, i2, liveRoomEntity) == null) {
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
        this.y = new c(this);
        this.z = new d(this);
        this.A = new e(this);
        this.B = -1;
        this.C = -1;
        this.F = true;
        this.G = new Handler(Looper.getMainLooper());
        this.H = new ArrayList();
        this.I = new f(this);
    }

    public static LiveSubTabFragment newInstance(Bundle bundle) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65572, null, bundle)) == null) {
            LiveSubTabFragment liveSubTabFragment = new LiveSubTabFragment();
            if (bundle != null) {
                liveSubTabFragment.setArguments(bundle);
            }
            return liveSubTabFragment;
        }
        return (LiveSubTabFragment) invokeL.objValue;
    }

    public final void a0() {
        View findViewByPosition;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (findViewByPosition = this.f34947f.getLayoutManager().findViewByPosition(this.B)) == null) {
            return;
        }
        LiveFeedPageRoundRect liveFeedPageRoundRect = (LiveFeedPageRoundRect) findViewByPosition.findViewById(c.a.y.c.a.c.live_feed_page_item_cover_rect);
        LiveRoomEntity liveRoomEntity = (LiveRoomEntity) c.a.y.g.g.d.b(this.n, this.B);
        if (this.D == null) {
            c.a.y.e.a a2 = c.a.y.e.b.a(String.valueOf(this.u));
            this.D = a2;
            a2.setVideoScalingMode(0);
            this.D.mute(true);
            this.D.setAcceptVolumeChange(false);
            this.D.setPlayerListener(new g(this, liveRoomEntity));
        }
        if (this.n.get(this.B) != null && this.D.getVideoUrl() != null && !this.D.getVideoUrl().equals(this.n.get(this.B).playUrl)) {
            if (!this.H.contains(Integer.valueOf(this.B)) && !TextUtils.isEmpty(this.n.get(this.B).playUrl)) {
                this.D.detachFromContainer();
                if (this.D.isPlaying()) {
                    this.D.stop();
                }
                this.D.setVideoUrl(this.n.get(this.B).playUrl);
                this.D.start();
                return;
            }
            this.B = Math.max(this.B, this.C) + 1;
            a0();
            return;
        }
        if (this.D.getVideoUrl() == null && !TextUtils.isEmpty(this.n.get(this.B).playUrl)) {
            this.D.detachFromContainer();
            if (this.D.isPlaying()) {
                this.D.stop();
            }
            this.D.setVideoUrl(this.n.get(this.B).playUrl);
            this.D.start();
        }
        if (this.F) {
            this.D.detachFromContainer();
            this.D.attachToContainer(liveFeedPageRoundRect);
        }
    }

    public final void b0() {
        View findViewByPosition;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (findViewByPosition = this.f34947f.getLayoutManager().findViewByPosition(this.C)) == null) {
            return;
        }
        LiveFeedPageRoundRect liveFeedPageRoundRect = (LiveFeedPageRoundRect) findViewByPosition.findViewById(c.a.y.c.a.c.live_feed_page_item_cover_rect);
        LiveRoomEntity liveRoomEntity = (LiveRoomEntity) c.a.y.g.g.d.b(this.n, this.C);
        if (this.E == null) {
            c.a.y.e.a a2 = c.a.y.e.b.a(String.valueOf(this.u));
            this.E = a2;
            a2.setVideoScalingMode(0);
            this.E.mute(true);
            this.E.setAcceptVolumeChange(false);
            this.E.setPlayerListener(new h(this, liveRoomEntity));
        }
        if (this.n.get(this.C) != null && this.E.getVideoUrl() != null && !this.E.getVideoUrl().equals(this.n.get(this.C).playUrl)) {
            if (!this.H.contains(Integer.valueOf(this.C)) && !TextUtils.isEmpty(this.n.get(this.C).playUrl)) {
                this.E.detachFromContainer();
                if (this.E.isPlaying()) {
                    this.E.stop();
                }
                this.E.setVideoUrl(this.n.get(this.C).playUrl);
                this.E.start();
                return;
            }
            this.C = Math.max(this.B, this.C) + 1;
            b0();
            return;
        }
        if (this.E.getVideoUrl() == null && !TextUtils.isEmpty(this.n.get(this.C).playUrl)) {
            this.E.detachFromContainer();
            if (this.E.isPlaying()) {
                this.E.stop();
            }
            this.E.setVideoUrl(this.n.get(this.C).playUrl);
            this.E.start();
        }
        if (this.F) {
            this.E.detachFromContainer();
            this.E.attachToContainer(liveFeedPageRoundRect);
        }
    }

    public final void c0() {
        c.a.y.b.d.c.b bVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) && (bVar = this.mFeedConfig) != null && bVar.b()) {
            this.G.removeCallbacks(this.I);
            this.G.postDelayed(this.I, 500L);
        }
    }

    public final void d0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            FloatingService floatingService = (FloatingService) ServiceManager.getService(FloatingService.Companion.getSERVICE_REFERENCE());
            if ((floatingService == null || !floatingService.isFloatViewShowing()) && NetWorkUtils.c(getContext())) {
                a0();
                b0();
            }
        }
    }

    public final void e0(int i2, int i3, LiveRoomEntity liveRoomEntity, c.a.y.e.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048580, this, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), liveRoomEntity, aVar}) == null) {
            if (liveRoomEntity != null && liveRoomEntity.isDateLive()) {
                if (liveRoomEntity.showTpl == 3) {
                    aVar.setVideoScalingMode(9);
                } else {
                    aVar.setVideoScalingMode(0);
                }
            } else if (liveRoomEntity == null || !liveRoomEntity.isYYShow()) {
                aVar.setVideoScalingMode(0);
            } else if (i2 > i3) {
                aVar.setVideoScalingMode(2);
            } else {
                aVar.setVideoScalingMode(0);
            }
        }
    }

    public final void f0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            if (k0()) {
                this.B = g0((StaggeredGridLayoutManager) this.f34947f.getLayoutManager());
                this.C = -1;
                return;
            }
            this.B = getCurrentViewIndex((StaggeredGridLayoutManager) this.f34947f.getLayoutManager(), true);
            this.C = getCurrentViewIndex((StaggeredGridLayoutManager) this.f34947f.getLayoutManager(), false);
        }
    }

    public void feedStabilityLog(LiveFeedWrapData liveFeedWrapData, int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(1048582, this, liveFeedWrapData, i2) == null) || liveFeedWrapData == null) {
            return;
        }
        c.a.y.b.c.a.g(getActivity(), this.t, c.a.y.b.c.a.m(this.isImmer), liveFeedWrapData.errCode, liveFeedWrapData.errMsg, liveFeedWrapData.tab, liveFeedWrapData.subTab, liveFeedWrapData.sessionId, c.a.y.g.g.d.c(liveFeedWrapData.roomInfoList) ? 0 : liveFeedWrapData.roomInfoList.size(), i2, liveFeedWrapData.refreshType, liveFeedWrapData.refreshIndex);
    }

    public final int g0(StaggeredGridLayoutManager staggeredGridLayoutManager) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, staggeredGridLayoutManager)) == null) ? h0(Math.min(staggeredGridLayoutManager.findFirstVisibleItemPositions(null)[0], staggeredGridLayoutManager.findFirstVisibleItemPositions(null)[1]), Math.max(staggeredGridLayoutManager.findLastVisibleItemPositions(null)[0], staggeredGridLayoutManager.findLastVisibleItemPositions(null)[1]), staggeredGridLayoutManager) : invokeL.intValue;
    }

    public int getCurrentViewIndex(StaggeredGridLayoutManager staggeredGridLayoutManager, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, staggeredGridLayoutManager, z)) == null) {
            int i2 = !z ? 1 : 0;
            return h0(staggeredGridLayoutManager.findFirstVisibleItemPositions(null)[i2], staggeredGridLayoutManager.findLastVisibleItemPositions(null)[i2], staggeredGridLayoutManager);
        }
        return invokeLZ.intValue;
    }

    @Override // com.baidu.live.business.base.LiveBaseFragment
    public RecyclerView getRecyclerView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.f34947f : (RecyclerView) invokeV.objValue;
    }

    public final int h0(int i2, int i3, StaggeredGridLayoutManager staggeredGridLayoutManager) {
        InterceptResult invokeIIL;
        LiveRoomEntity liveRoomEntity;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIIL = interceptable.invokeIIL(1048586, this, i2, i3, staggeredGridLayoutManager)) == null) {
            for (int i4 = i2; i4 <= i3; i4++) {
                int i5 = i4 - i2;
                View childAt = staggeredGridLayoutManager.getChildAt(i5);
                if (childAt != null && !this.n.isEmpty() && i5 >= 0 && i5 < this.n.size() && (liveRoomEntity = this.n.get(i5)) != null && liveRoomEntity.canAutoPlay()) {
                    childAt.getLocationOnScreen(new int[2]);
                    Rect rect = new Rect();
                    childAt.getLocalVisibleRect(rect);
                    if (((rect.bottom - rect.top) * 3) / 2 > childAt.getHeight()) {
                        return i4;
                    }
                }
            }
            return -1;
        }
        return invokeIIL.intValue;
    }

    public final int i0(LiveFeedWrapData liveFeedWrapData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048587, this, liveFeedWrapData)) == null) {
            if (liveFeedWrapData != null) {
                if (liveFeedWrapData.refreshType == 0) {
                    this.n.clear();
                    this.o.clear();
                    this.H.clear();
                }
                if (!c.a.y.g.g.d.c(liveFeedWrapData.roomInfoList)) {
                    ArrayList arrayList = new ArrayList();
                    for (LiveRoomEntity liveRoomEntity : liveFeedWrapData.roomInfoList) {
                        if (liveRoomEntity != null && !c.a.y.g.g.j.a(liveRoomEntity.roomId) && this.o.add(liveRoomEntity.roomId)) {
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

    public final void initView() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            BdSwipeRefreshLayout bdSwipeRefreshLayout = (BdSwipeRefreshLayout) this.f34946e.findViewById(c.a.y.c.a.c.sub_frag_swipelayout);
            this.f34950i = bdSwipeRefreshLayout;
            bdSwipeRefreshLayout.setOnRefreshListener(this.y);
            RecyclerView recyclerView = (RecyclerView) this.f34946e.findViewById(c.a.y.c.a.c.sub_frag_recyclerview);
            this.f34947f = recyclerView;
            recyclerView.setLayoutManager(new i(this, 2, 1));
            this.f34947f.setItemAnimator(null);
            this.f34947f.addItemDecoration(new LiveItemDecoration(c.a.y.b.f.a.a(getContext(), 7.0f)));
            this.f34947f.setOverScrollMode(2);
            this.f34947f.addOnScrollListener(this.z);
            c.a.y.b.e.e eVar = new c.a.y.b.e.e(getContext());
            this.f34949h = eVar;
            this.f34950i.setProgressView(eVar);
            this.f34949h.t(this.isImmer);
            LoadingView loadingView = (LoadingView) this.f34946e.findViewById(c.a.y.c.a.c.sub_frag_loading);
            this.f34951j = loadingView;
            loadingView.onDarkModeChange(this.isImmer);
            ErrorView errorView = (ErrorView) this.f34946e.findViewById(c.a.y.c.a.c.sub_frag_error);
            this.k = errorView;
            errorView.onDarkModeChange(this.isImmer);
            EmptyView emptyView = (EmptyView) this.f34946e.findViewById(c.a.y.c.a.c.sub_frag_empty);
            this.l = emptyView;
            emptyView.onDarkModeChange(this.isImmer);
            this.k.setActionCallback(new j(this));
            this.f34948g = this.f34946e.findViewById(c.a.y.c.a.c.live_feed_page_sub_grag_gradient_space);
            j0();
        }
    }

    public final void j0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            LiveSubTabAdapter liveSubTabAdapter = new LiveSubTabAdapter(getContext(), this.isImmer, this.t, this.tab, this.subTab);
            this.m = liveSubTabAdapter;
            liveSubTabAdapter.setItemViewListener(new k(this));
            this.f34947f.setAdapter(this.m);
        }
    }

    public final boolean k0() {
        InterceptResult invokeV;
        b.a aVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            c.a.y.b.d.c.b bVar = this.mFeedConfig;
            return (bVar == null || (aVar = bVar.f26842d) == null || aVar.f26843b != 1) ? false : true;
        }
        return invokeV.booleanValue;
    }

    public final void l0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            BdSwipeRefreshLayout bdSwipeRefreshLayout = this.f34950i;
            if (bdSwipeRefreshLayout != null) {
                bdSwipeRefreshLayout.setRefreshing(false);
            }
            this.p = 0;
            if (this.m != null && !c.a.y.g.g.d.c(this.n)) {
                this.m.setHasMore(this.r);
                LiveSubTabAdapter liveSubTabAdapter = this.m;
                liveSubTabAdapter.notifyItemChanged(liveSubTabAdapter.getItemCount() - 1);
            }
            this.F = true;
            c0();
        }
    }

    public final void lazyLoad() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            LiveFeedPageSdk.m("LiveSubTabFragment lazyLoad needNewCreate" + this.needNewCreate + "  needLoadData " + this.s + "  tab " + this.tab + "  subTab " + this.subTab);
            if (this.needNewCreate && this.s) {
                this.needNewCreate = false;
                this.s = false;
                LiveFeedWrapData liveFeedWrapData = this.mFeedWrapData;
                if (liveFeedWrapData != null && this.tab.equals(liveFeedWrapData.tab) && this.subTab.equals(this.mFeedWrapData.subTab)) {
                    LiveFeedWrapData liveFeedWrapData2 = this.mFeedWrapData;
                    if (liveFeedWrapData2 != null) {
                        feedStabilityLog(this.mFeedWrapData, i0(liveFeedWrapData2));
                        LiveFeedWrapData liveFeedWrapData3 = this.mFeedWrapData;
                        this.r = liveFeedWrapData3.hasMore;
                        this.sessionId = liveFeedWrapData3.sessionId;
                        l0();
                        if (c.a.y.g.g.d.c(this.n) && c.a.y.g.g.d.c(this.mFeedWrapData.roomInfoList)) {
                            EmptyView emptyView = this.l;
                            LiveFeedWrapData liveFeedWrapData4 = this.mFeedWrapData;
                            m0(emptyView, 0, liveFeedWrapData4, "", liveFeedWrapData4.sessionId, "banner,tab,feed,follow,config");
                            return;
                        }
                        show(this.f34950i);
                        return;
                    }
                    return;
                }
                refreshFeed();
                RecyclerView recyclerView = this.f34947f;
                if (recyclerView != null && recyclerView.getChildCount() > 0) {
                    this.f34947f.scrollToPosition(0);
                }
                show(this.f34951j);
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x003e  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0043  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void m0(View view, int i2, LiveFeedWrapData liveFeedWrapData, String str, String str2, String str3) {
        JSONObject jSONObject;
        LiveFeedWrapData liveFeedWrapData2;
        int i3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048593, this, new Object[]{view, Integer.valueOf(i2), liveFeedWrapData, str, str2, str3}) == null) {
            String b2 = c.a.y.b.f.c.b(LiveFeedWrapData.getFeedCacheKey(this.tab, this.subTab), "");
            LiveFeedWrapData liveFeedWrapData3 = null;
            if (!TextUtils.isEmpty(b2)) {
                try {
                    jSONObject = new JSONObject(b2);
                    liveFeedWrapData2 = new LiveFeedWrapData();
                } catch (JSONException unused) {
                }
                try {
                    liveFeedWrapData2.parserJson(jSONObject, -1);
                    liveFeedWrapData2.isCacheData = true;
                    liveFeedWrapData3 = liveFeedWrapData2;
                } catch (JSONException unused2) {
                    liveFeedWrapData3 = liveFeedWrapData2;
                    c.a.y.b.f.c.g(LiveFeedWrapData.getFeedCacheKey(this.tab, this.subTab));
                    if (liveFeedWrapData3 != null) {
                    }
                }
            }
            if (liveFeedWrapData3 != null) {
                show(view);
                return;
            }
            i0(liveFeedWrapData3);
            this.r = liveFeedWrapData3.hasMore;
            this.sessionId = liveFeedWrapData3.sessionId;
            l0();
            if (c.a.y.g.g.d.c(liveFeedWrapData3.roomInfoList)) {
                show(view);
            } else {
                show(this.f34950i);
                if (LiveFeedPageSdk.f().g() != null) {
                    LiveFeedPageSdk.f().g().a(getActivity(), "服务器太累了，请稍后重试");
                }
            }
            if (liveFeedWrapData3.isCacheData) {
                if (i2 == -101) {
                    i3 = 1;
                } else {
                    i3 = (liveFeedWrapData == null || liveFeedWrapData.errCode == 0) ? 2 : 3;
                }
                c.a.y.b.c.a.p(getActivity(), this.t, c.a.y.b.c.a.m(this.isImmer), liveFeedWrapData == null ? -100 : liveFeedWrapData.errCode, liveFeedWrapData != null ? liveFeedWrapData.errMsg : "", str, str3, this.tab, this.subTab, str2, i3, ExternalTransferSpeedStats.FEED_PAGE, liveFeedWrapData3.cacheTime, System.currentTimeMillis(), 1);
            }
        }
    }

    public final void n0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048594, this, z) == null) {
            if (z) {
                c.a.y.e.a aVar = this.D;
                if (aVar != null) {
                    aVar.stop();
                    this.G.postDelayed(new a(this), 500L);
                    c.a.y.e.a aVar2 = this.E;
                    if (aVar2 != null) {
                        aVar2.stop();
                        this.G.postDelayed(new b(this), 500L);
                        return;
                    }
                    return;
                }
                return;
            }
            c.a.y.e.a aVar3 = this.D;
            if (aVar3 != null) {
                aVar3.detachFromContainer();
                this.D.setPlayerListener(null);
                this.D = null;
            }
            c.a.y.e.a aVar4 = this.E;
            if (aVar4 != null) {
                aVar4.detachFromContainer();
                this.E.setPlayerListener(null);
                this.E = null;
            }
        }
    }

    public final void o0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048595, this) == null) {
            LiveRoomEntity liveRoomEntity = (LiveRoomEntity) c.a.y.g.g.d.b(this.n, this.B);
            if (this.w == null || liveRoomEntity == null) {
                return;
            }
            c.a.y.b.c.a.t(getContext(), false, this.t, c.a.y.b.c.a.m(this.isImmer), this.B, this.tab, this.subTab, liveRoomEntity, this.w);
            this.w = null;
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048596, this, bundle) == null) {
            super.onActivityCreated(bundle);
        }
    }

    @Override // com.baidu.live.business.base.LiveBaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048597, this, bundle) == null) {
            super.onCreate(bundle);
            LiveFeedPageSdk.m("onCreate :  tab " + this.tab + "  subTab " + this.subTab);
            this.isImmer = getArguments().getBoolean(LiveBaseFragment.TAB_IS_IMMER);
            this.u = getArguments().getInt(LiveBaseFragment.TAB_BD_ID);
            this.t = getArguments().getString("source");
            String string = getArguments().getString(LiveBaseFragment.SCHEME_DEF_SUB_TAB_TYPE);
            LiveTabEntity liveTabEntity = (LiveTabEntity) getArguments().getParcelable(LiveBaseFragment.TAB_ENTITY_ITEM);
            this.mTabItem = liveTabEntity;
            this.tab = liveTabEntity.type;
            this.channelId = liveTabEntity.channelId;
            String str2 = "";
            if (c.a.y.g.g.d.c(liveTabEntity.subTabList)) {
                str = "";
            } else {
                str = "";
                for (LiveTabEntity.TabLabelInfo tabLabelInfo : this.mTabItem.subTabList) {
                    if (tabLabelInfo != null) {
                        if (!TextUtils.isEmpty(string) && string.equals(tabLabelInfo.type) && TextUtils.isEmpty(str2)) {
                            str2 = string;
                        }
                        if (tabLabelInfo.selected && TextUtils.isEmpty(str)) {
                            str = tabLabelInfo.type;
                        }
                    }
                }
            }
            if (TextUtils.isEmpty(str2)) {
                str2 = str;
            }
            this.subTab = str2;
            this.mPosition = getArguments().getInt(LiveBaseFragment.TAB_POSITION);
            this.needNewCreate = true;
        }
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048598, this, layoutInflater, viewGroup, bundle)) == null) {
            LiveFeedPageSdk.m("LiveSubTabFragment onCreateView :  tab " + this.tab + "  subTab " + this.subTab);
            View view = this.f34946e;
            if (view == null) {
                this.f34946e = layoutInflater.inflate(c.a.y.c.a.d.live_feed_page_sub_fragment_layout, viewGroup, false);
                initView();
            } else {
                ViewGroup viewGroup2 = (ViewGroup) view.getParent();
                if (viewGroup2 != null) {
                    viewGroup2.removeView(this.f34946e);
                }
            }
            if (this.mModel == null) {
                this.mModel = new c.a.y.b.d.a(getContext(), this.isImmer, this.t);
            }
            this.mModel.i(this.A);
            return this.f34946e;
        }
        return (View) invokeLLL.objValue;
    }

    @Override // com.baidu.live.business.base.LiveBaseFragment
    public void onDarkModeChange(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048599, this, str) == null) && this.q) {
            this.f34946e.setBackgroundColor(c.a.y.k.f.e().a(getContext(), this.isImmer, "color_F5F5F51"));
            GradientDrawable gradientDrawable = new GradientDrawable();
            gradientDrawable.setColors(new int[]{c.a.y.k.f.e().a(getContext(), this.isImmer, "color_white1"), c.a.y.k.f.e().a(getContext(), this.isImmer, "color_F5F5F51")});
            gradientDrawable.setGradientType(0);
            gradientDrawable.setOrientation(GradientDrawable.Orientation.TOP_BOTTOM);
            this.f34948g.setBackgroundDrawable(gradientDrawable);
            LiveSubTabAdapter liveSubTabAdapter = this.m;
            if (liveSubTabAdapter != null) {
                liveSubTabAdapter.notifyDataSetChanged();
            }
            c.a.y.b.e.e eVar = this.f34949h;
            if (eVar != null) {
                eVar.t(this.isImmer);
            }
            ErrorView errorView = this.k;
            if (errorView != null) {
                errorView.onDarkModeChange(this.isImmer);
            }
            EmptyView emptyView = this.l;
            if (emptyView != null) {
                emptyView.onDarkModeChange(this.isImmer);
            }
            LoadingView loadingView = this.f34951j;
            if (loadingView != null) {
                loadingView.onDarkModeChange(this.isImmer);
            }
        }
    }

    @Override // com.baidu.live.business.base.LiveBaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048600, this) == null) {
            super.onDestroy();
            LiveFeedPageSdk.m("LiveSubTabFragment onDestroy :  tab " + this.tab + "  subTab " + this.subTab);
            this.s = true;
            this.needNewCreate = true;
            this.q = false;
            this.r = false;
            this.n.clear();
            this.o.clear();
            LoadingView loadingView = this.f34951j;
            if (loadingView != null) {
                loadingView.destroy();
            }
            BdSwipeRefreshLayout bdSwipeRefreshLayout = this.f34950i;
            if (bdSwipeRefreshLayout != null) {
                bdSwipeRefreshLayout.setRefreshing(false);
            }
            this.H.clear();
            this.G.removeCallbacksAndMessages(null);
            n0(false);
        }
    }

    @Override // com.baidu.live.business.base.LiveBaseFragment
    public void onFragmentShow(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048601, this, z) == null) {
            LiveFeedPageSdk.m("LiveSubTabFragment onFragmentShow :" + z + "  tab " + this.tab + "  subTab " + this.subTab);
            if (z) {
                lazyLoad();
                onShowLog();
                return;
            }
            onHintLog();
            n0(false);
        }
    }

    public void onHintLog() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048602, this) == null) || this.v == null) {
            return;
        }
        LiveFeedPageSdk.m("LivePageLog onHintLog  " + this.tab + GlideException.IndentedAppendable.INDENT + this.subTab + "   " + this.v.hashCode());
        c.a.y.b.c.a.q(getActivity(), false, this.t, c.a.y.b.c.a.m(this.isImmer), this.tab, this.subTab, this.v);
        this.v = null;
    }

    public void onNetChange() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048603, this) == null) {
            if (NetWorkUtils.b(getContext()) && NetWorkUtils.c(getContext())) {
                c0();
                return;
            }
            c.a.y.e.a aVar = this.D;
            if (aVar != null) {
                aVar.detachFromContainer();
                this.D.stop();
            }
            c.a.y.e.a aVar2 = this.E;
            if (aVar2 != null) {
                aVar2.detachFromContainer();
                this.E.stop();
            }
        }
    }

    @Override // com.baidu.live.business.base.LiveBaseFragment
    public void onParentPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048604, this) == null) {
            LiveFeedPageSdk.m("LiveSubTabFragment onParentPause :  tab " + this.tab + "  subTab " + this.subTab);
            n0(true);
        }
    }

    @Override // com.baidu.live.business.base.LiveBaseFragment
    public void onParentResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048605, this) == null) {
            LiveFeedPageSdk.m("LiveSubTabFragment onParentResume :  tab " + this.tab + "  subTab " + this.subTab);
            c0();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048606, this) == null) {
            super.onPause();
            LiveFeedPageSdk.m("LiveSubTabFragment onPause  tab " + this.tab + "  subTab " + this.subTab);
            this.f34951j.onPause();
            BdSwipeRefreshLayout bdSwipeRefreshLayout = this.f34950i;
            if (bdSwipeRefreshLayout != null) {
                bdSwipeRefreshLayout.setRefreshing(false);
            }
            n0(true);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048607, this) == null) {
            LiveFeedPageSdk.m("LiveSubTabFragment onResume :  tab " + this.tab + "  subTab " + this.subTab);
            super.onResume();
            this.f34951j.onResume();
        }
    }

    public void onShowLog() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048608, this) == null) {
            this.v = c.a.y.b.c.a.q(getActivity(), true, this.t, c.a.y.b.c.a.m(this.isImmer), this.tab, this.subTab, null);
            LiveFeedPageSdk.m("LivePageLog onShowLog  " + this.tab + GlideException.IndentedAppendable.INDENT + this.subTab + "   " + this.v.hashCode());
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048609, this, view, bundle) == null) {
            super.onViewCreated(view, bundle);
            this.q = true;
            onDarkModeChange("day");
        }
    }

    public final void p0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048610, this) == null) {
            this.w = c.a.y.b.c.a.t(getContext(), true, this.t, c.a.y.b.c.a.m(this.isImmer), this.B, this.tab, this.subTab, (LiveRoomEntity) c.a.y.g.g.d.b(this.n, this.B), null);
        }
    }

    public final void q0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048611, this) == null) {
            LiveRoomEntity liveRoomEntity = (LiveRoomEntity) c.a.y.g.g.d.b(this.n, this.C);
            if (this.x == null || liveRoomEntity == null) {
                return;
            }
            c.a.y.b.c.a.t(getContext(), false, this.t, c.a.y.b.c.a.m(this.isImmer), this.C, this.tab, this.subTab, liveRoomEntity, this.x);
            this.x = null;
        }
    }

    public final void r0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048612, this) == null) {
            this.x = c.a.y.b.c.a.t(getContext(), true, this.t, c.a.y.b.c.a.m(this.isImmer), this.C, this.tab, this.subTab, (LiveRoomEntity) c.a.y.g.g.d.b(this.n, this.C), null);
        }
    }

    public void refresh(boolean z, boolean z2) {
        boolean refreshFeedAndFollow;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048613, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) || this.mModel == null) {
            return;
        }
        if (z) {
            refreshFeedAndFollow = refreshFeedAndFollowAndBanner();
        } else {
            refreshFeedAndFollow = refreshFeedAndFollow();
        }
        if (!refreshFeedAndFollow || this.f34950i == null) {
            return;
        }
        if (this.n.isEmpty()) {
            show(this.f34951j);
        }
        RecyclerView recyclerView = this.f34947f;
        if (recyclerView != null && recyclerView.getChildCount() > 0) {
            this.f34947f.scrollToPosition(0);
        }
        if (z2) {
            this.f34950i.setRefreshing(true);
        }
    }

    public void reset() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048614, this) == null) {
        }
    }

    public void show(View view) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048615, this, view) == null) || view == null) {
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
        LoadingView loadingView = this.f34951j;
        if (loadingView != null) {
            loadingView.setVisibility(view == loadingView ? 0 : 8);
        }
        BdSwipeRefreshLayout bdSwipeRefreshLayout = this.f34950i;
        if (bdSwipeRefreshLayout != null) {
            bdSwipeRefreshLayout.setVisibility(view != bdSwipeRefreshLayout ? 8 : 0);
        }
    }

    public void updateTabInfo(String str, String str2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048616, this, str, str2) == null) || c.a.y.g.g.j.a(str) || c.a.y.g.g.j.a(str2) || !str.equals(this.tab)) {
            return;
        }
        this.subTab = str2;
        LiveSubTabAdapter liveSubTabAdapter = this.m;
        if (liveSubTabAdapter != null) {
            liveSubTabAdapter.setThirdLevelTab(str2);
        }
    }
}
