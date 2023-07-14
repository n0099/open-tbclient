package com.baidu.live.business;

import android.graphics.Rect;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import com.baidu.live.LiveFeedPageSdk;
import com.baidu.live.business.adapter.LiveSubTabAdapter;
import com.baidu.live.business.base.LiveBaseFragment;
import com.baidu.live.business.model.ILiveFeedModel;
import com.baidu.live.business.model.LiveFeedInterstModel;
import com.baidu.live.business.model.data.LiveBannerEntity;
import com.baidu.live.business.model.data.LiveFeedConfig;
import com.baidu.live.business.model.data.LiveFeedData;
import com.baidu.live.business.model.data.LiveFeedReserveWrapData;
import com.baidu.live.business.model.data.LiveFeedWrapData;
import com.baidu.live.business.model.data.LiveRoomEntity;
import com.baidu.live.business.model.data.LiveTabEntity;
import com.baidu.live.business.refresh.BdSwipeRefreshLayout;
import com.baidu.live.business.test.LiveFeedAbTest;
import com.baidu.live.business.view.emotion.EmptyView;
import com.baidu.live.business.view.emotion.ErrorView;
import com.baidu.live.business.view.emotion.LoadingView;
import com.baidu.live.business.view.recyclerview.FixedStaggeredGridLayoutManager;
import com.baidu.live.feedpage.interfaces.ILiveFeedOther;
import com.baidu.live.feedpage.interfaces.ILiveFeedRefresh;
import com.baidu.live.framework.view.LiveFeedPageRoundRect;
import com.baidu.pyramid.runtime.service.ServiceManager;
import com.baidu.searchbox.download.lightdownload.LightFileUtils;
import com.baidu.searchbox.launch.utils.SpeedStatsUtils;
import com.baidu.searchbox.live.interfaces.service.FloatingService;
import com.baidu.searchbox.live.interfaces.service.LiveBdTlsScrollService;
import com.baidu.tieba.R;
import com.baidu.tieba.gb0;
import com.baidu.tieba.gd0;
import com.baidu.tieba.hb0;
import com.baidu.tieba.he0;
import com.baidu.tieba.ib0;
import com.baidu.tieba.jb0;
import com.baidu.tieba.ob0;
import com.baidu.tieba.qb0;
import com.baidu.tieba.sb0;
import com.baidu.tieba.sd0;
import com.baidu.tieba.tc0;
import com.baidu.tieba.uc0;
import com.baidu.tieba.vd0;
import com.baidu.tieba.wc0;
import com.baidu.tieba.yb0;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class LiveSubTabFragment extends LiveBaseFragment {
    public EmptyView A;
    public LiveSubTabAdapter B;
    public LiveFeedReserveWrapData E;
    public int J;
    public int K;
    public l L;
    public String Q;
    public LiveFeedInterstModel R;

    /* renamed from: T  reason: collision with root package name */
    public ILiveFeedOther.LiveFeedStatusListener f1041T;
    public ILiveFeedRefresh.OnRefreshListener U;
    public tc0 a0;
    public tc0 b0;
    public View t;
    public RecyclerView u;
    public View v;
    public ob0 w;
    public BdSwipeRefreshLayout x;
    public LoadingView y;
    public ErrorView z;
    public final List<LiveRoomEntity> C = new ArrayList();
    public final Set<String> D = new HashSet();
    public int F = 0;
    public boolean G = false;
    public boolean H = false;
    public boolean I = true;
    public long M = 0;
    public long N = 0;
    public LiveRoomEntity O = null;
    public int P = -1;
    public LiveBdTlsScrollService S = (LiveBdTlsScrollService) ServiceManager.getService(LiveBdTlsScrollService.Companion.getSERVICE_REFERENCE());
    public BdSwipeRefreshLayout.j V = new c();
    public RecyclerView.OnScrollListener W = new d();
    public LiveFeedInterstModel.OnInterestDataLoadCallback X = new e();
    public int Y = -1;
    public int Z = -1;
    public boolean c0 = true;
    public Handler d0 = new Handler(Looper.getMainLooper());
    public ArrayList e0 = new ArrayList();
    public boolean f0 = true;
    public Runnable g0 = new f();

    /* loaded from: classes3.dex */
    public interface l {
        void a(boolean z);
    }

    /* loaded from: classes3.dex */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (LiveSubTabFragment.this.b0 != null) {
                LiveSubTabFragment.this.b0.detachFromContainer();
                LiveSubTabFragment.this.b0.setPlayerListener(null);
                LiveSubTabFragment.this.b0 = null;
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b implements Runnable {
        public b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            LiveSubTabFragment.this.u.setItemAnimator(null);
        }
    }

    /* loaded from: classes3.dex */
    public class c implements BdSwipeRefreshLayout.j {
        public c() {
        }

        @Override // com.baidu.live.business.refresh.BdSwipeRefreshLayout.j
        public void onRefresh() {
            if (LiveSubTabFragment.this.x != null) {
                LiveSubTabFragment.this.x.setRefreshing(true);
            }
            LiveSubTabFragment.this.O1();
        }
    }

    /* loaded from: classes3.dex */
    public class d extends RecyclerView.OnScrollListener {
        public int a = 0;

        public d() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i) {
            super.onScrollStateChanged(recyclerView, i);
            if (LiveSubTabFragment.this.S != null) {
                LiveSubTabFragment.this.S.onTLSScrollStateChanged(i);
            }
            if (i == 0) {
                if (this.a + 4 >= LiveSubTabFragment.this.B.getItemCount() && LiveSubTabFragment.this.F == 0 && LiveSubTabFragment.this.H) {
                    LiveSubTabFragment.this.F = 1;
                    LiveSubTabFragment.this.b();
                    if (LiveSubTabFragment.this.r != null) {
                        LiveSubTabFragment.this.r.onSlideLoadMore(LiveSubTabFragment.this.m, LiveSubTabFragment.this.o);
                    }
                }
                LiveSubTabFragment.this.f3();
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrolled(RecyclerView recyclerView, int i, int i2) {
            if (LiveSubTabFragment.this.S != null) {
                LiveSubTabFragment.this.S.onTLSScrolled(i, i2);
            }
            this.a = LiveSubTabFragment.this.H1();
            boolean z = true;
            if (Math.abs(i2) <= 1) {
                return;
            }
            if ((LiveSubTabFragment.this.K == 0 || ((LiveSubTabFragment.this.K < 0 && i2 > 1) || (LiveSubTabFragment.this.K > 0 && i2 < -1))) && LiveSubTabFragment.this.L != null) {
                l lVar = LiveSubTabFragment.this.L;
                if (i2 <= 1) {
                    z = false;
                }
                lVar.a(z);
            }
            LiveSubTabFragment.this.K = i2;
        }
    }

    /* loaded from: classes3.dex */
    public class e implements LiveFeedInterstModel.OnInterestDataLoadCallback {
        public e() {
        }

        @Override // com.baidu.live.business.model.LiveFeedInterstModel.OnInterestDataLoadCallback
        public void onFail(int i, String str, Map<String, String> map) {
            LiveFeedPageSdk.liveLog("errCode :  errMsg " + str);
            LiveSubTabFragment.this.J3();
        }

        @Override // com.baidu.live.business.model.LiveFeedInterstModel.OnInterestDataLoadCallback
        public void onSuccess(LiveFeedData liveFeedData, Map<String, String> map) {
            if (liveFeedData != null) {
                LiveSubTabFragment.this.s3(liveFeedData);
                LiveSubTabFragment.this.J3();
                return;
            }
            onFail(-100, "数据解析失败", map);
        }
    }

    /* loaded from: classes3.dex */
    public class f implements Runnable {
        public f() {
        }

        @Override // java.lang.Runnable
        public void run() {
            LiveSubTabFragment.this.l3();
            LiveSubTabFragment.this.g3();
            LiveSubTabFragment.this.c0 = false;
        }
    }

    /* loaded from: classes3.dex */
    public class g extends wc0 {
        public final /* synthetic */ LiveRoomEntity a;

        public g(LiveRoomEntity liveRoomEntity) {
            this.a = liveRoomEntity;
        }

        @Override // com.baidu.searchbox.player.callback.IVideoPlayerCallback
        public void onVideoSizeChanged(int i, int i2) {
            LiveSubTabFragment liveSubTabFragment = LiveSubTabFragment.this;
            liveSubTabFragment.h3(i, i2, this.a, liveSubTabFragment.a0);
        }

        @Override // com.baidu.searchbox.player.callback.IVideoPlayerCallback
        public void onEnd(int i) {
            LiveSubTabFragment.this.Q3();
            if (i == 307) {
                LiveSubTabFragment.this.e0.add(Integer.valueOf(LiveSubTabFragment.this.Y));
                LiveSubTabFragment liveSubTabFragment = LiveSubTabFragment.this;
                liveSubTabFragment.Y = Math.max(liveSubTabFragment.Y, LiveSubTabFragment.this.Z) + 1;
                LiveSubTabFragment.this.d3();
            }
        }

        @Override // com.baidu.searchbox.player.callback.IVideoPlayerCallback
        public void onError(int i, int i2, String str) {
            Log.e("LiveSubTabFragment", "player1 onError: " + str);
            LiveSubTabFragment.this.Q3();
            LiveSubTabFragment.this.e0.add(Integer.valueOf(LiveSubTabFragment.this.Y));
            LiveSubTabFragment liveSubTabFragment = LiveSubTabFragment.this;
            liveSubTabFragment.Y = Math.max(liveSubTabFragment.Y, LiveSubTabFragment.this.Z) + 1;
            LiveSubTabFragment.this.d3();
        }

        @Override // com.baidu.searchbox.player.callback.IVideoPlayerCallback
        public void onInfo(int i, int i2) {
            LiveFeedPageRoundRect liveFeedPageRoundRect;
            if (i == 904) {
                LiveSubTabFragment.this.R3();
                View findViewByPosition = LiveSubTabFragment.this.u.getLayoutManager().findViewByPosition(LiveSubTabFragment.this.Y);
                if (findViewByPosition != null && (liveFeedPageRoundRect = (LiveFeedPageRoundRect) findViewByPosition.findViewById(R.id.obfuscated_res_0x7f091558)) != null) {
                    LiveSubTabFragment.this.a0.attachToContainer(liveFeedPageRoundRect);
                }
            }
        }

        @Override // com.baidu.searchbox.player.callback.IVideoPlayerCallback
        public void onPause() {
            LiveSubTabFragment.this.Q3();
        }

        @Override // com.baidu.searchbox.player.callback.IVideoPlayerCallback
        public void onResume() {
            LiveSubTabFragment.this.R3();
        }
    }

    /* loaded from: classes3.dex */
    public class h extends wc0 {
        public final /* synthetic */ LiveRoomEntity a;

        public h(LiveRoomEntity liveRoomEntity) {
            this.a = liveRoomEntity;
        }

        @Override // com.baidu.searchbox.player.callback.IVideoPlayerCallback
        public void onVideoSizeChanged(int i, int i2) {
            LiveSubTabFragment liveSubTabFragment = LiveSubTabFragment.this;
            liveSubTabFragment.h3(i, i2, this.a, liveSubTabFragment.b0);
        }

        @Override // com.baidu.searchbox.player.callback.IVideoPlayerCallback
        public void onEnd(int i) {
            LiveSubTabFragment.this.S3();
            if (i == 307) {
                LiveSubTabFragment.this.e0.add(Integer.valueOf(LiveSubTabFragment.this.Z));
                LiveSubTabFragment liveSubTabFragment = LiveSubTabFragment.this;
                liveSubTabFragment.Z = Math.max(liveSubTabFragment.Y, LiveSubTabFragment.this.Z) + 1;
                LiveSubTabFragment.this.e3();
            }
        }

        @Override // com.baidu.searchbox.player.callback.IVideoPlayerCallback
        public void onError(int i, int i2, String str) {
            Log.e("LiveSubTabFragment", "player2 onError: " + str);
            LiveSubTabFragment.this.S3();
            LiveSubTabFragment.this.e0.add(Integer.valueOf(LiveSubTabFragment.this.Z));
            LiveSubTabFragment liveSubTabFragment = LiveSubTabFragment.this;
            liveSubTabFragment.Z = Math.max(liveSubTabFragment.Y, LiveSubTabFragment.this.Z) + 1;
            LiveSubTabFragment.this.e3();
        }

        @Override // com.baidu.searchbox.player.callback.IVideoPlayerCallback
        public void onInfo(int i, int i2) {
            LiveFeedPageRoundRect liveFeedPageRoundRect;
            if (i == 904) {
                LiveSubTabFragment.this.T3();
                View findViewByPosition = LiveSubTabFragment.this.u.getLayoutManager().findViewByPosition(LiveSubTabFragment.this.Z);
                if (findViewByPosition != null && (liveFeedPageRoundRect = (LiveFeedPageRoundRect) findViewByPosition.findViewById(R.id.obfuscated_res_0x7f091558)) != null) {
                    LiveSubTabFragment.this.b0.attachToContainer(liveFeedPageRoundRect);
                }
            }
        }

        @Override // com.baidu.searchbox.player.callback.IVideoPlayerCallback
        public void onPause() {
            LiveSubTabFragment.this.S3();
        }

        @Override // com.baidu.searchbox.player.callback.IVideoPlayerCallback
        public void onResume() {
            LiveSubTabFragment.this.T3();
        }
    }

    /* loaded from: classes3.dex */
    public class i implements yb0 {
        public i() {
        }

        @Override // com.baidu.tieba.yb0
        public void a(View view2) {
            LiveSubTabFragment.this.I3(false, true, null);
        }
    }

    /* loaded from: classes3.dex */
    public class j implements LiveSubTabAdapter.a {
        public j() {
        }

        @Override // com.baidu.live.business.adapter.LiveSubTabAdapter.a
        public void onBannerItemClick(LiveBannerEntity liveBannerEntity) {
            if (LiveSubTabFragment.this.r != null) {
                LiveSubTabFragment.this.r.onBannerItemClick(liveBannerEntity);
            }
        }

        @Override // com.baidu.live.business.adapter.LiveSubTabAdapter.a
        public void onBannerItemShow(LiveBannerEntity liveBannerEntity) {
            if (LiveSubTabFragment.this.r != null) {
                LiveSubTabFragment.this.r.onBannerItemShow(liveBannerEntity);
            }
        }

        @Override // com.baidu.live.business.adapter.LiveSubTabAdapter.a
        public void onHeaderReserveClick(@Nullable String str) {
            LiveSubTabFragment.this.C3(str);
        }

        @Override // com.baidu.live.business.adapter.LiveSubTabAdapter.a
        public void onItemLabelClickListener(@NonNull String str, int i, @NonNull LiveRoomEntity liveRoomEntity) {
            if (LiveSubTabFragment.this.r != null) {
                LiveSubTabFragment.this.r.onItemLabelClickListener(str, i, liveRoomEntity);
            }
        }

        @Override // com.baidu.live.business.adapter.LiveSubTabAdapter.a
        public void onItemViewClick(@NonNull LiveRoomEntity liveRoomEntity, int i) {
            if (LiveSubTabFragment.this.r != null) {
                LiveSubTabFragment.this.r.onClickFeedItemRoom(liveRoomEntity, i);
                if (liveRoomEntity.isStatusLiving()) {
                    try {
                        if (LiveSubTabFragment.this.c != null && LiveSubTabFragment.this.c.interestInsert != null && LiveSubTabFragment.this.c.interestInsert.tab != null) {
                            JSONArray jSONArray = LiveSubTabFragment.this.c.interestInsert.tab;
                            int length = jSONArray.length();
                            String[] strArr = new String[length];
                            for (int i2 = 0; i2 < length; i2++) {
                                strArr[i2] = String.valueOf(jSONArray.get(i2));
                            }
                            for (int i3 = 0; i3 < length; i3++) {
                                if (liveRoomEntity.belongSubTab.equals(strArr[i3])) {
                                    LiveSubTabFragment.this.P = i;
                                    LiveSubTabFragment.this.O = liveRoomEntity;
                                    LiveSubTabFragment.this.N = System.currentTimeMillis();
                                    LiveFeedPageSdk.liveLog("yjl_feed_tag", "====>>>onItemViewClick  mCurrentClickPosition :" + LiveSubTabFragment.this.P);
                                }
                            }
                        }
                    } catch (Exception e) {
                        LiveFeedPageSdk.liveLog(e.getMessage());
                    }
                }
            }
        }

        @Override // com.baidu.live.business.adapter.LiveSubTabAdapter.a
        public void onItemViewRecycled(int i) {
            if (i == LiveSubTabFragment.this.Y) {
                if (LiveSubTabFragment.this.a0 != null) {
                    LiveSubTabFragment.this.a0.detachFromContainer();
                    if (LiveSubTabFragment.this.a0.isPlaying()) {
                        LiveSubTabFragment.this.a0.stop();
                    }
                }
            } else if (i == LiveSubTabFragment.this.Z && LiveSubTabFragment.this.b0 != null) {
                LiveSubTabFragment.this.b0.detachFromContainer();
                if (LiveSubTabFragment.this.b0.isPlaying()) {
                    LiveSubTabFragment.this.b0.stop();
                }
            }
        }

        @Override // com.baidu.live.business.adapter.LiveSubTabAdapter.a
        public void onItemViewShow(@NonNull LiveRoomEntity liveRoomEntity, int i) {
            if (LiveSubTabFragment.this.r != null) {
                LiveSubTabFragment.this.r.onFeedItemRoomShow(liveRoomEntity, i);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class k implements Runnable {
        public k() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (LiveSubTabFragment.this.a0 != null) {
                LiveSubTabFragment.this.a0.detachFromContainer();
                LiveSubTabFragment.this.a0.setPlayerListener(null);
                LiveSubTabFragment.this.a0 = null;
            }
        }
    }

    /* loaded from: classes3.dex */
    public static class m implements ILiveFeedModel.OnDataLoadCallback {
        public final WeakReference<LiveSubTabFragment> a;

        public m(LiveSubTabFragment liveSubTabFragment) {
            this.a = new WeakReference<>(liveSubTabFragment);
        }

        @Override // com.baidu.live.business.model.ILiveFeedModel.OnDataLoadCallback
        public void onFail(int i, @Nullable String str, @Nullable Map<String, String> map) {
            LiveSubTabFragment liveSubTabFragment = this.a.get();
            if (liveSubTabFragment == null) {
                return;
            }
            liveSubTabFragment.z3(i, str, map);
        }

        @Override // com.baidu.live.business.model.ILiveFeedModel.OnDataLoadCallback
        public void onSuccess(@Nullable LiveFeedData liveFeedData, Map<String, String> map) {
            LiveSubTabFragment liveSubTabFragment = this.a.get();
            if (liveSubTabFragment == null) {
                return;
            }
            liveSubTabFragment.A3(liveFeedData, map);
        }
    }

    @Override // com.baidu.live.business.base.LiveBaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        LiveFeedPageSdk.liveLog("LiveSubTabFragment onDestroy :  tab " + this.m + "  subTab " + this.o);
        this.I = true;
        this.g = true;
        this.G = false;
        this.H = false;
        this.C.clear();
        this.D.clear();
        LoadingView loadingView = this.y;
        if (loadingView != null) {
            loadingView.a();
        }
        BdSwipeRefreshLayout bdSwipeRefreshLayout = this.x;
        if (bdSwipeRefreshLayout != null) {
            bdSwipeRefreshLayout.setRefreshing(false);
        }
        this.e0.clear();
        this.d0.removeCallbacksAndMessages(null);
        P3(false);
        this.L = null;
        J3();
        this.M = 0L;
        this.R = null;
        LiveSubTabAdapter liveSubTabAdapter = this.B;
        if (liveSubTabAdapter != null) {
            liveSubTabAdapter.u(null);
        }
        this.t = null;
    }

    public static LiveSubTabFragment x3(Bundle bundle) {
        LiveSubTabFragment liveSubTabFragment = new LiveSubTabFragment();
        if (bundle != null) {
            liveSubTabFragment.setArguments(bundle);
        }
        return liveSubTabFragment;
    }

    public void L3(l lVar) {
        this.L = lVar;
    }

    public void M3(ILiveFeedModel iLiveFeedModel) {
        this.h = iLiveFeedModel;
        this.i = new m(this);
        this.j = this.h.getInitResource();
    }

    public void c3(ILiveFeedOther.LiveFeedStatusListener liveFeedStatusListener) {
        this.f1041T = liveFeedStatusListener;
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
    }

    public final int q3(LiveFeedWrapData liveFeedWrapData) {
        return r3(liveFeedWrapData, null);
    }

    public void U3(String str, String str2) {
        if (!vd0.a(str) && !vd0.a(str2) && str.equals(this.m)) {
            this.o = str2;
            LiveSubTabAdapter liveSubTabAdapter = this.B;
            if (liveSubTabAdapter != null) {
                liveSubTabAdapter.x(str2);
            }
        }
    }

    public void j3(LiveFeedWrapData liveFeedWrapData, int i2) {
        LiveBaseFragment.a aVar;
        if (liveFeedWrapData != null && (aVar = this.r) != null) {
            aVar.onFeedStabilityLog(liveFeedWrapData, i2);
        }
    }

    public int k3(StaggeredGridLayoutManager staggeredGridLayoutManager, boolean z) {
        int i2 = !z ? 1 : 0;
        if (LiveFeedAbTest.a()) {
            return o3(staggeredGridLayoutManager.findFirstCompletelyVisibleItemPositions(null)[i2], staggeredGridLayoutManager.findLastCompletelyVisibleItemPositions(null)[i2], staggeredGridLayoutManager);
        }
        return p3(staggeredGridLayoutManager.findFirstVisibleItemPositions(null)[i2], staggeredGridLayoutManager.findLastVisibleItemPositions(null)[i2], staggeredGridLayoutManager);
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view2, Bundle bundle) {
        super.onViewCreated(view2, bundle);
        this.G = true;
        y3("day");
    }

    public final int o3(int i2, int i3, StaggeredGridLayoutManager staggeredGridLayoutManager) {
        while (i2 <= i3) {
            LiveRoomEntity liveRoomEntity = (LiveRoomEntity) sd0.b(this.C, i2);
            if (liveRoomEntity != null && liveRoomEntity.canAutoPlay() && !liveRoomEntity.isTopicRoom()) {
                return i2;
            }
            i2++;
        }
        return -1;
    }

    public final void h3(int i2, int i3, LiveRoomEntity liveRoomEntity, tc0 tc0Var) {
        if (liveRoomEntity != null && liveRoomEntity.isYYShow()) {
            if (i2 > i3) {
                tc0Var.setVideoScalingMode(2);
                return;
            } else {
                tc0Var.setVideoScalingMode(0);
                return;
            }
        }
        tc0Var.setVideoScalingMode(0);
    }

    public final void A3(LiveFeedData liveFeedData, Map<String, String> map) {
        boolean z;
        LiveFeedWrapData liveFeedWrapData;
        RecyclerView recyclerView;
        if (String.valueOf(1).equals(map.get("refresh_type"))) {
            ILiveFeedRefresh.OnLoadMoreListener onLoadMoreListener = this.s;
            if (onLoadMoreListener != null) {
                onLoadMoreListener.onLoadMoreEnd();
            }
        } else {
            ILiveFeedRefresh.OnRefreshListener onRefreshListener = this.U;
            if (onRefreshListener != null) {
                onRefreshListener.onPullRefreshEnd();
            }
        }
        if (liveFeedData != null && !vd0.a(liveFeedData.resource)) {
            LiveFeedConfig liveFeedConfig = liveFeedData.feedConfig;
            if (liveFeedConfig != null) {
                this.Q = liveFeedConfig.minorUfoUrl;
            }
            if (liveFeedData.isMinor) {
                jb0 jb0Var = new jb0();
                jb0Var.b = liveFeedData.isMinor;
                jb0Var.c = this.Q;
                jb0Var.b(this.J);
                gd0.a().b(jb0Var);
            }
            if (liveFeedData.resource.contains(SpeedStatsUtils.UBC_VALUE_BANNER) && liveFeedData.bannerWrapData != null) {
                gb0 gb0Var = new gb0();
                gb0Var.b = liveFeedData.bannerWrapData;
                gb0Var.b(this.J);
                gd0.a().b(gb0Var);
            }
            if (liveFeedData.resource.contains("follow") && liveFeedData.followWrapData != null) {
                ib0 ib0Var = new ib0();
                ib0Var.b = liveFeedData.followWrapData;
                ib0Var.b(this.J);
                gd0.a().b(ib0Var);
            }
            LiveFeedWrapData liveFeedWrapData2 = liveFeedData.feedWrapData;
            String str = "";
            if (liveFeedWrapData2 != null) {
                if (J1(liveFeedWrapData2.tab, liveFeedWrapData2.subTab, liveFeedWrapData2.refreshType)) {
                    this.q = "";
                    this.l = liveFeedData.feedWrapData.sessionId;
                    LiveFeedReserveWrapData liveFeedReserveWrapData = null;
                    if (liveFeedData.resource.contains("reserve")) {
                        liveFeedReserveWrapData = liveFeedData.reserveWrapData;
                    }
                    j3(liveFeedData.feedWrapData, r3(liveFeedData.feedWrapData, liveFeedReserveWrapData));
                    z = !sd0.c(liveFeedData.feedWrapData.roomInfoList);
                } else {
                    z = false;
                }
                LiveFeedWrapData liveFeedWrapData3 = liveFeedData.feedWrapData;
                this.H = liveFeedWrapData3.hasMore;
                this.k = liveFeedWrapData3.refreshIndex;
                if (liveFeedWrapData3.isBigRefresh()) {
                    gd0.a().b(new hb0(this.J));
                }
            } else {
                this.H = false;
                z = false;
            }
            K3();
            if (sd0.c(this.C) && !z) {
                EmptyView emptyView = this.A;
                int i2 = liveFeedData.errno;
                LiveFeedWrapData liveFeedWrapData4 = liveFeedData.feedWrapData;
                String str2 = liveFeedData.logId;
                if (liveFeedWrapData4 != null) {
                    str = liveFeedWrapData4.sessionId;
                }
                O3(emptyView, i2, liveFeedWrapData4, str2, str, liveFeedData.resource);
                return;
            }
            N3(this.x);
            if (liveFeedData != null && (liveFeedWrapData = liveFeedData.feedWrapData) != null && liveFeedWrapData.isBigRefresh() && (recyclerView = this.u) != null) {
                recyclerView.smoothScrollBy(0, 1);
                this.u.smoothScrollBy(0, -1);
                return;
            }
            return;
        }
        z3(-100, "数据解析失败", map);
    }

    public void B3() {
        LiveSubTabAdapter liveSubTabAdapter = this.B;
        if (liveSubTabAdapter != null) {
            liveSubTabAdapter.notifyDataSetChanged();
        }
    }

    public void D3() {
        LiveBaseFragment.a aVar = this.r;
        if (aVar != null) {
            aVar.onTabPageHideLog(this.m, this.o);
        }
    }

    public void E3() {
        if (qb0.f(getContext()) && qb0.h(getContext())) {
            f3();
            return;
        }
        tc0 tc0Var = this.a0;
        if (tc0Var != null) {
            tc0Var.detachFromContainer();
            this.a0.stop();
        }
        tc0 tc0Var2 = this.b0;
        if (tc0Var2 != null) {
            tc0Var2.detachFromContainer();
            this.b0.stop();
        }
    }

    public void F3() {
        LiveFeedPageSdk.liveLog("LiveSubTabFragment onParentPause :  tab " + this.m + "  subTab " + this.o);
        this.f0 = true;
        P3(true);
    }

    public void G3() {
        LiveFeedPageSdk.liveLog("LiveSubTabFragment onParentResume :  tab " + this.m + "  subTab " + this.o);
        this.f0 = false;
        f3();
    }

    @Override // com.baidu.live.business.base.LiveBaseFragment
    public RecyclerView I1() {
        return this.u;
    }

    public final void J3() {
        this.N = 0L;
        this.P = -1;
        this.O = null;
    }

    public final void K3() {
        BdSwipeRefreshLayout bdSwipeRefreshLayout = this.x;
        if (bdSwipeRefreshLayout != null) {
            bdSwipeRefreshLayout.setRefreshing(false);
        }
        this.F = 0;
        if (this.B != null && !sd0.c(this.C)) {
            this.B.t(this.H);
            LiveSubTabAdapter liveSubTabAdapter = this.B;
            liveSubTabAdapter.notifyItemChanged(liveSubTabAdapter.getItemCount() - 1);
        }
        this.c0 = true;
        f3();
    }

    public final void Q3() {
        if (this.r != null) {
            this.r.onItemPlayerEnd(1, this.m, this.o, this.Y, (LiveRoomEntity) sd0.b(this.C, this.Y));
        }
    }

    public final void S3() {
        if (this.r != null) {
            this.r.onItemPlayerEnd(2, this.m, this.o, this.Y, (LiveRoomEntity) sd0.b(this.C, this.Y));
        }
    }

    public final void f3() {
        LiveFeedConfig liveFeedConfig;
        if (!"recommend".equals(this.e) && (liveFeedConfig = this.c) != null && liveFeedConfig.supportPlay() && !this.f0 && !LiveFeedAbTest.b()) {
            this.d0.removeCallbacks(this.g0);
            this.d0.postDelayed(this.g0, 500L);
        }
    }

    public final void g3() {
        FloatingService floatingService = (FloatingService) ServiceManager.getService(FloatingService.Companion.getSERVICE_REFERENCE());
        if ((floatingService != null && floatingService.isFloatViewShowing()) || !qb0.h(getContext())) {
            return;
        }
        d3();
        e3();
    }

    public boolean i3() {
        RecyclerView recyclerView = this.u;
        if (recyclerView != null) {
            return recyclerView.canScrollVertically(1);
        }
        return false;
    }

    public LiveFeedInterstModel m3() {
        if (this.R == null) {
            this.R = new LiveFeedInterstModel();
        }
        return this.R;
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        LiveFeedPageSdk.liveLog("LiveSubTabFragment onResume :  tab " + this.m + "  subTab " + this.o);
        super.onResume();
        this.f0 = false;
        this.y.e();
    }

    public final void t3() {
        LiveSubTabAdapter liveSubTabAdapter = new LiveSubTabAdapter(getContext(), this.e, this.m, this.o);
        this.B = liveSubTabAdapter;
        liveSubTabAdapter.s(this.c);
        this.B.u(new j());
        this.u.setAdapter(this.B);
    }

    public boolean v3() {
        return this.H;
    }

    public final boolean w3() {
        LiveFeedConfig.PlayConfig playConfig;
        LiveFeedConfig liveFeedConfig = this.c;
        if (liveFeedConfig != null && (playConfig = liveFeedConfig.playConfig) != null && playConfig.maxPlayCount == 1) {
            return true;
        }
        return false;
    }

    public final void C3(String str) {
        boolean z;
        if (this.B == null) {
            return;
        }
        RecyclerView recyclerView = this.u;
        if (recyclerView != null) {
            recyclerView.setItemAnimator(new DefaultItemAnimator());
        }
        Iterator<LiveRoomEntity> it = this.C.iterator();
        int i2 = 0;
        while (true) {
            if (it.hasNext()) {
                LiveRoomEntity next = it.next();
                if (next != null) {
                    if (next.reserveHeaderInfo != null) {
                        it.remove();
                        z = true;
                        break;
                    }
                    i2++;
                }
            } else {
                z = false;
                break;
            }
        }
        if (z) {
            this.B.updateData(this.C);
            this.B.notifyItemRemoved(i2);
        }
        LiveFeedReserveWrapData liveFeedReserveWrapData = this.E;
        if (liveFeedReserveWrapData != null && liveFeedReserveWrapData.isValid()) {
            this.C.addAll(0, this.E.roomInfos);
            this.B.updateData(this.C);
            this.B.notifyItemRangeInserted(0, this.E.roomInfos.size());
            RecyclerView recyclerView2 = this.u;
            if (recyclerView2 != null) {
                recyclerView2.scrollToPosition(0);
            }
        }
        RecyclerView recyclerView3 = this.u;
        if (recyclerView3 != null) {
            recyclerView3.postDelayed(new b(), 500L);
        }
        LiveBaseFragment.a aVar = this.r;
        if (aVar != null) {
            aVar.onFeedReserveHeaderItemClick(str);
        }
    }

    public void N3(View view2) {
        int i2;
        int i3;
        ILiveFeedOther.LiveFeedStatusListener liveFeedStatusListener;
        ILiveFeedOther.LiveFeedStatusListener liveFeedStatusListener2;
        ILiveFeedOther.LiveFeedStatusListener liveFeedStatusListener3;
        ILiveFeedOther.LiveFeedStatusListener liveFeedStatusListener4;
        int i4;
        if (view2 == null) {
            return;
        }
        BdSwipeRefreshLayout bdSwipeRefreshLayout = this.x;
        int i5 = 0;
        if (bdSwipeRefreshLayout != null) {
            if (view2 == bdSwipeRefreshLayout) {
                i4 = 0;
            } else {
                i4 = 8;
            }
            bdSwipeRefreshLayout.setVisibility(i4);
        }
        if (LiveFeedPageSdk.VIDEO_BAR.equals(this.e)) {
            this.z.d(8);
            this.A.b(8);
            this.y.setVisibility(8);
            if (view2 == this.z && (liveFeedStatusListener4 = this.f1041T) != null) {
                liveFeedStatusListener4.onError();
            }
            if (view2 == this.A && (liveFeedStatusListener3 = this.f1041T) != null) {
                liveFeedStatusListener3.onEmpty();
            }
            if (view2 == this.y && (liveFeedStatusListener2 = this.f1041T) != null) {
                liveFeedStatusListener2.onLoading();
            }
            if (view2 == this.x && (liveFeedStatusListener = this.f1041T) != null) {
                liveFeedStatusListener.onLoadSuccess();
                return;
            }
            return;
        }
        ErrorView errorView = this.z;
        if (errorView != null) {
            if (view2 == errorView) {
                i3 = 0;
            } else {
                i3 = 8;
            }
            errorView.e(i3, this.e);
        }
        EmptyView emptyView = this.A;
        if (emptyView != null) {
            if (view2 == emptyView) {
                i2 = 0;
            } else {
                i2 = 8;
            }
            emptyView.c(i2, this.e);
        }
        LoadingView loadingView = this.y;
        if (loadingView != null) {
            if (view2 != loadingView) {
                i5 = 8;
            }
            loadingView.setVisibility(i5);
        }
    }

    public final void s3(LiveFeedData liveFeedData) {
        LiveFeedWrapData liveFeedWrapData;
        if (liveFeedData != null && (liveFeedWrapData = liveFeedData.feedWrapData) != null && this.P != -1 && !sd0.c(liveFeedWrapData.roomInfoList)) {
            LiveFeedPageSdk.liveLog("yjl_feed_tag", "===>>  handleInterestData ListUtils.isEmpty(feedData.feedWrapData.roomInfoList): " + sd0.c(liveFeedData.feedWrapData.roomInfoList));
            for (LiveRoomEntity liveRoomEntity : liveFeedData.feedWrapData.roomInfoList) {
                liveRoomEntity.hasInterest = true;
            }
            List<LiveRoomEntity> list = this.C;
            if (list != null && list.size() > 1) {
                this.C.get(this.P).hasInterestClick = true;
                this.C.addAll(this.P + 1, liveFeedData.feedWrapData.roomInfoList);
                this.B.updateData(this.C);
                this.B.notifyDataSetChanged();
                this.M++;
            }
        }
    }

    public void y3(String str) {
        if (this.G) {
            this.t.setBackgroundColor(he0.f().a(getContext(), this.e, "color_F5F5F51"));
            GradientDrawable gradientDrawable = new GradientDrawable();
            gradientDrawable.setColors(new int[]{he0.f().a(getContext(), this.e, "color_white1"), he0.f().a(getContext(), this.e, "color_F5F5F51")});
            gradientDrawable.setGradientType(0);
            gradientDrawable.setOrientation(GradientDrawable.Orientation.TOP_BOTTOM);
            this.v.setBackgroundDrawable(gradientDrawable);
            LiveSubTabAdapter liveSubTabAdapter = this.B;
            if (liveSubTabAdapter != null) {
                liveSubTabAdapter.notifyDataSetChanged();
            }
            ob0 ob0Var = this.w;
            if (ob0Var != null) {
                ob0Var.y(this.e);
            }
            ErrorView errorView = this.z;
            if (errorView != null) {
                errorView.c(this.e);
            }
            EmptyView emptyView = this.A;
            if (emptyView != null) {
                emptyView.a(this.e);
            }
            LoadingView loadingView = this.y;
            if (loadingView != null) {
                loadingView.c(this.e);
            }
        }
    }

    public void H3() {
        LiveFeedConfig.InterestInsert interestInsert;
        boolean z;
        LiveBaseFragment.a aVar = this.r;
        if (aVar != null) {
            aVar.onTabPageShowLog(this.m, this.o);
        }
        LiveFeedConfig liveFeedConfig = this.c;
        if (liveFeedConfig != null && (interestInsert = liveFeedConfig.interestInsert) != null && this.O != null && this.N != 0 && this.P != -1) {
            long currentTimeMillis = System.currentTimeMillis();
            boolean isStatusLiving = this.O.isStatusLiving();
            boolean z2 = true;
            if (currentTimeMillis - this.N > interestInsert.duration * 1000) {
                z = true;
            } else {
                z = false;
            }
            if (this.M > interestInsert.frequency) {
                z2 = false;
            }
            LiveRoomEntity liveRoomEntity = this.O;
            boolean z3 = liveRoomEntity.hasInterest;
            boolean z4 = liveRoomEntity.hasInterestClick;
            LiveFeedPageSdk.liveLog("yjl_feed_tag", "mInterstInsertNumber : " + this.M);
            LiveFeedPageSdk.liveLog("yjl_feed_tag", "(endTime - mInterstStartTime) : " + (currentTimeMillis - this.N));
            LiveFeedPageSdk.liveLog("yjl_feed_tag", "interestInsert.duration * 1000 : " + (interestInsert.duration * 1000));
            LiveFeedPageSdk.liveLog("yjl_feed_tag", "overTime : " + z + " hasInsertOverTimes： " + z2 + " statusLiving： " + isStatusLiving + " \t mCurrentClickItemRoomEntity.hasInterest : " + this.O.hasInterest);
            if (isStatusLiving && z2 && z && !z3 && !z4) {
                LiveFeedInterstModel m3 = m3();
                LiveRoomEntity liveRoomEntity2 = this.O;
                m3.reqInterestData(liveRoomEntity2.sessionId, liveRoomEntity2.liveTag, liveRoomEntity2.feedTag, this.X);
            }
        }
    }

    public final void u3() {
        BdSwipeRefreshLayout bdSwipeRefreshLayout = (BdSwipeRefreshLayout) this.t.findViewById(R.id.obfuscated_res_0x7f0922ac);
        this.x = bdSwipeRefreshLayout;
        bdSwipeRefreshLayout.setScene(this.e);
        this.x.setOnRefreshListener(this.V);
        RecyclerView recyclerView = (RecyclerView) this.t.findViewById(R.id.obfuscated_res_0x7f0922ab);
        this.u = recyclerView;
        recyclerView.setLayoutManager(new FixedStaggeredGridLayoutManager(2, 1));
        this.u.setItemAnimator(null);
        int b2 = qb0.b(getContext(), 7.0f);
        if (LiveFeedPageSdk.VIDEO_BAR.equals(this.e)) {
            b2 = qb0.b(getContext(), 8.0f);
        }
        this.u.addItemDecoration(new LiveItemDecoration(b2));
        this.u.setOverScrollMode(2);
        this.u.addOnScrollListener(this.W);
        ob0 ob0Var = new ob0(getContext());
        this.w = ob0Var;
        ob0Var.z(this.e);
        this.x.setProgressView(this.w);
        this.w.y(this.e);
        LoadingView loadingView = (LoadingView) this.t.findViewById(R.id.obfuscated_res_0x7f0922aa);
        this.y = loadingView;
        loadingView.c(this.e);
        ErrorView errorView = (ErrorView) this.t.findViewById(R.id.obfuscated_res_0x7f0922a9);
        this.z = errorView;
        errorView.c(this.e);
        EmptyView emptyView = (EmptyView) this.t.findViewById(R.id.obfuscated_res_0x7f0922a8);
        this.A = emptyView;
        emptyView.a(this.e);
        this.z.setActionCallback(new i());
        this.v = this.t.findViewById(R.id.obfuscated_res_0x7f091567);
        if (LiveFeedPageSdk.VIDEO_BAR.equals(this.e)) {
            int b3 = qb0.b(getContext(), 9.0f);
            this.u.setPadding(b3, 0, b3, 0);
            this.v.setVisibility(8);
            this.x.setEnabled(false);
        }
        t3();
    }

    public void I3(boolean z, boolean z2, ILiveFeedRefresh.OnRefreshListener onRefreshListener) {
        boolean P1;
        if (onRefreshListener != null) {
            this.U = onRefreshListener;
        }
        if (this.h != null) {
            if (z) {
                P1 = O1();
            } else {
                P1 = P1();
            }
            if (P1 && this.x != null) {
                if (this.C.isEmpty()) {
                    N3(this.y);
                }
                RecyclerView recyclerView = this.u;
                if (recyclerView != null && recyclerView.getChildCount() > 0) {
                    this.u.scrollToPosition(0);
                }
                if (z2) {
                    this.x.setRefreshing(true);
                }
            }
        }
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        LiveFeedPageSdk.liveLog("LiveSubTabFragment onCreateView :  tab " + this.m + "  subTab " + this.o);
        View view2 = this.t;
        if (view2 == null) {
            this.t = layoutInflater.inflate(R.layout.obfuscated_res_0x7f0d05ce, viewGroup, false);
            u3();
        } else {
            ViewGroup viewGroup2 = (ViewGroup) view2.getParent();
            if (viewGroup2 != null) {
                viewGroup2.removeView(this.t);
            }
        }
        return this.t;
    }

    public final int p3(int i2, int i3, StaggeredGridLayoutManager staggeredGridLayoutManager) {
        View childAt;
        for (int i4 = i2; i4 <= i3; i4++) {
            LiveRoomEntity liveRoomEntity = (LiveRoomEntity) sd0.b(this.C, i4);
            if (liveRoomEntity != null && liveRoomEntity.canAutoPlay() && !liveRoomEntity.isTopicRoom() && (childAt = staggeredGridLayoutManager.getChildAt(i4 - i2)) != null) {
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

    @Override // com.baidu.live.business.base.LiveBaseFragment
    public void L1(boolean z) {
        LiveFeedPageSdk.liveLog("LiveSubTabFragment onFragmentShow :" + z + "  tab " + this.m + "  subTab " + this.o);
        if (z) {
            lazyLoad();
            H3();
            return;
        }
        D3();
        P3(false);
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x004f  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0053  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void O3(View view2, int i2, LiveFeedWrapData liveFeedWrapData, String str, String str2, String str3) {
        JSONObject jSONObject;
        LiveFeedWrapData liveFeedWrapData2;
        LiveFeedWrapData liveFeedWrapData3;
        if (!"recommend".equals(this.e) && !LiveFeedPageSdk.VIDEO_BAR.equals(this.e)) {
            LiveFeedWrapData liveFeedWrapData4 = null;
            String b2 = sb0.b(LiveFeedWrapData.getFeedCacheKey(this.m, this.o), "");
            if (!TextUtils.isEmpty(b2)) {
                try {
                    jSONObject = new JSONObject(b2);
                    liveFeedWrapData2 = new LiveFeedWrapData();
                } catch (JSONException unused) {
                }
                try {
                    liveFeedWrapData2.parserJson(jSONObject, -1, true);
                    liveFeedWrapData2.isCacheData = true;
                    liveFeedWrapData3 = liveFeedWrapData2;
                } catch (JSONException unused2) {
                    liveFeedWrapData4 = liveFeedWrapData2;
                    sb0.g(LiveFeedWrapData.getFeedCacheKey(this.m, this.o));
                    liveFeedWrapData3 = liveFeedWrapData4;
                    if (liveFeedWrapData3 == null) {
                    }
                }
                if (liveFeedWrapData3 == null) {
                    N3(view2);
                    return;
                }
                q3(liveFeedWrapData3);
                this.H = liveFeedWrapData3.hasMore;
                this.l = liveFeedWrapData3.sessionId;
                K3();
                if (sd0.c(liveFeedWrapData3.roomInfoList)) {
                    N3(view2);
                } else {
                    N3(this.x);
                    LiveBaseFragment.a aVar = this.r;
                    if (aVar != null) {
                        aVar.onShowToast("服务器太累了，请稍后重试");
                    }
                }
                LiveBaseFragment.a aVar2 = this.r;
                if (aVar2 != null) {
                    aVar2.onHitCache(this.m, this.o, str2, str, str3, i2, liveFeedWrapData3, liveFeedWrapData);
                    return;
                }
                return;
            }
            liveFeedWrapData3 = liveFeedWrapData4;
            if (liveFeedWrapData3 == null) {
            }
        } else {
            N3(view2);
        }
    }

    public final void P3(boolean z) {
        this.d0.removeCallbacks(this.g0);
        if (z) {
            tc0 tc0Var = this.a0;
            if (tc0Var != null) {
                tc0Var.stop();
                this.d0.postDelayed(new k(), 500L);
                tc0 tc0Var2 = this.b0;
                if (tc0Var2 != null) {
                    tc0Var2.stop();
                    this.d0.postDelayed(new a(), 500L);
                    return;
                }
                return;
            }
            return;
        }
        tc0 tc0Var3 = this.a0;
        if (tc0Var3 != null) {
            tc0Var3.detachFromContainer();
            this.a0.setPlayerListener(null);
            this.a0 = null;
        }
        tc0 tc0Var4 = this.b0;
        if (tc0Var4 != null) {
            tc0Var4.detachFromContainer();
            this.b0.setPlayerListener(null);
            this.b0 = null;
        }
    }

    public final int n3(StaggeredGridLayoutManager staggeredGridLayoutManager) {
        if (LiveFeedAbTest.a()) {
            return o3(Math.min(staggeredGridLayoutManager.findFirstCompletelyVisibleItemPositions(null)[0], staggeredGridLayoutManager.findFirstCompletelyVisibleItemPositions(null)[1]), Math.max(staggeredGridLayoutManager.findLastCompletelyVisibleItemPositions(null)[0], staggeredGridLayoutManager.findLastCompletelyVisibleItemPositions(null)[1]), staggeredGridLayoutManager);
        }
        return p3(Math.min(staggeredGridLayoutManager.findFirstVisibleItemPositions(null)[0], staggeredGridLayoutManager.findFirstVisibleItemPositions(null)[1]), Math.max(staggeredGridLayoutManager.findLastVisibleItemPositions(null)[0], staggeredGridLayoutManager.findLastVisibleItemPositions(null)[1]), staggeredGridLayoutManager);
    }

    public final void R3() {
        if (this.r != null) {
            this.r.onItemPlayerStart(1, this.m, this.o, this.Y, (LiveRoomEntity) sd0.b(this.C, this.Y));
        }
        int i2 = this.Y;
        if (i2 >= 0 && i2 < this.C.size()) {
            this.C.get(this.Y).beginTime = String.valueOf(System.currentTimeMillis());
        }
    }

    public final void T3() {
        if (this.r != null) {
            this.r.onItemPlayerStart(2, this.m, this.o, this.Y, (LiveRoomEntity) sd0.b(this.C, this.Y));
        }
        int i2 = this.Z;
        if (i2 >= 0 && i2 < this.C.size()) {
            this.C.get(this.Z).beginTime = String.valueOf(System.currentTimeMillis());
        }
    }

    public final void l3() {
        RecyclerView recyclerView = this.u;
        if (recyclerView != null && recyclerView.getLayoutManager() != null) {
            if (w3()) {
                this.Y = n3((StaggeredGridLayoutManager) this.u.getLayoutManager());
                this.Z = -1;
                return;
            }
            this.Y = k3((StaggeredGridLayoutManager) this.u.getLayoutManager(), true);
            this.Z = k3((StaggeredGridLayoutManager) this.u.getLayoutManager(), false);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        LiveFeedPageSdk.liveLog("LiveSubTabFragment onPause  tab " + this.m + "  subTab " + this.o);
        this.f0 = true;
        this.y.d();
        BdSwipeRefreshLayout bdSwipeRefreshLayout = this.x;
        if (bdSwipeRefreshLayout != null) {
            bdSwipeRefreshLayout.setRefreshing(false);
        }
        P3(true);
    }

    public final void d3() {
        View findViewByPosition;
        RecyclerView recyclerView = this.u;
        if (recyclerView != null && recyclerView.getLayoutManager() != null && (findViewByPosition = this.u.getLayoutManager().findViewByPosition(this.Y)) != null && this.Y < this.C.size()) {
            LiveFeedPageRoundRect liveFeedPageRoundRect = (LiveFeedPageRoundRect) findViewByPosition.findViewById(R.id.obfuscated_res_0x7f091558);
            LiveRoomEntity liveRoomEntity = (LiveRoomEntity) sd0.b(this.C, this.Y);
            if (this.a0 == null) {
                tc0 a2 = uc0.a(String.valueOf(this.J));
                this.a0 = a2;
                a2.setVideoScalingMode(0);
                this.a0.mute(true);
                this.a0.setAcceptVolumeChange(false);
                this.a0.setPlayerListener(new g(liveRoomEntity));
            }
            if (this.C.get(this.Y) != null && this.a0.getVideoUrl() != null && !this.a0.getVideoUrl().equals(this.C.get(this.Y).playUrl)) {
                if (!this.e0.contains(Integer.valueOf(this.Y)) && !TextUtils.isEmpty(this.C.get(this.Y).playUrl)) {
                    this.a0.detachFromContainer();
                    if (this.a0.isPlaying()) {
                        this.a0.stop();
                    }
                    this.a0.setVideoUrl(this.C.get(this.Y).playUrl);
                    this.a0.start();
                    return;
                }
                this.Y = Math.max(this.Y, this.Z) + 1;
                d3();
                return;
            }
            if (this.a0.getVideoUrl() == null && !TextUtils.isEmpty(this.C.get(this.Y).playUrl)) {
                this.a0.detachFromContainer();
                if (this.a0.isPlaying()) {
                    this.a0.stop();
                }
                this.a0.setVideoUrl(this.C.get(this.Y).playUrl);
                this.a0.start();
            }
            if (this.c0) {
                this.a0.detachFromContainer();
                if (liveFeedPageRoundRect != null) {
                    this.a0.attachToContainer(liveFeedPageRoundRect);
                }
            }
        }
    }

    public final void e3() {
        View findViewByPosition;
        RecyclerView recyclerView = this.u;
        if (recyclerView != null && recyclerView.getLayoutManager() != null && (findViewByPosition = this.u.getLayoutManager().findViewByPosition(this.Z)) != null && this.Z < this.C.size()) {
            LiveFeedPageRoundRect liveFeedPageRoundRect = (LiveFeedPageRoundRect) findViewByPosition.findViewById(R.id.obfuscated_res_0x7f091558);
            LiveRoomEntity liveRoomEntity = (LiveRoomEntity) sd0.b(this.C, this.Z);
            if (this.b0 == null) {
                tc0 a2 = uc0.a(String.valueOf(this.J));
                this.b0 = a2;
                a2.setVideoScalingMode(0);
                this.b0.mute(true);
                this.b0.setAcceptVolumeChange(false);
                this.b0.setPlayerListener(new h(liveRoomEntity));
            }
            if (this.C.get(this.Z) != null && this.b0.getVideoUrl() != null && !this.b0.getVideoUrl().equals(this.C.get(this.Z).playUrl)) {
                if (!this.e0.contains(Integer.valueOf(this.Z)) && !TextUtils.isEmpty(this.C.get(this.Z).playUrl)) {
                    this.b0.detachFromContainer();
                    if (this.b0.isPlaying()) {
                        this.b0.stop();
                    }
                    this.b0.setVideoUrl(this.C.get(this.Z).playUrl);
                    this.b0.start();
                    return;
                }
                this.Z = Math.max(this.Y, this.Z) + 1;
                e3();
                return;
            }
            if (this.b0.getVideoUrl() == null && !TextUtils.isEmpty(this.C.get(this.Z).playUrl)) {
                this.b0.detachFromContainer();
                if (this.b0.isPlaying()) {
                    this.b0.stop();
                }
                this.b0.setVideoUrl(this.C.get(this.Z).playUrl);
                this.b0.start();
            }
            if (this.c0) {
                this.b0.detachFromContainer();
                if (liveFeedPageRoundRect != null) {
                    this.b0.attachToContainer(liveFeedPageRoundRect);
                }
            }
        }
    }

    public final void lazyLoad() {
        LiveFeedPageSdk.liveLog("LiveSubTabFragment lazyLoad needNewCreate" + this.g + "  needLoadData " + this.I + "  tab " + this.m + "  subTab " + this.o);
        if (this.g && this.I) {
            this.g = false;
            this.I = false;
            LiveFeedWrapData liveFeedWrapData = this.b;
            if (liveFeedWrapData != null && this.m.equals(liveFeedWrapData.tab) && this.o.equals(this.b.subTab)) {
                j3(this.b, r3(this.b, this.d));
                LiveFeedWrapData liveFeedWrapData2 = this.b;
                this.H = liveFeedWrapData2.hasMore;
                this.l = liveFeedWrapData2.sessionId;
                K3();
                if (sd0.c(this.C) && sd0.c(this.b.roomInfoList)) {
                    EmptyView emptyView = this.A;
                    LiveFeedWrapData liveFeedWrapData3 = this.b;
                    O3(emptyView, 0, liveFeedWrapData3, "", liveFeedWrapData3.sessionId, this.j);
                    return;
                }
                N3(this.x);
                return;
            }
            N1();
            RecyclerView recyclerView = this.u;
            if (recyclerView != null && recyclerView.getChildCount() > 0) {
                this.u.scrollToPosition(0);
            }
            N3(this.y);
        }
    }

    @Override // com.baidu.live.business.base.LiveBaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        String str;
        super.onCreate(bundle);
        LiveFeedPageSdk.liveLog("onCreate :  tab " + this.m + "  subTab " + this.o);
        this.e = getArguments().getString("tab_scene");
        this.J = getArguments().getInt("tab_bd_id");
        String string = getArguments().getString("scheme_def_tab_type");
        LiveTabEntity liveTabEntity = (LiveTabEntity) getArguments().getParcelable("tab_entity_item");
        this.a = liveTabEntity;
        this.m = liveTabEntity.type;
        this.n = liveTabEntity.channelId;
        String str2 = "";
        if (sd0.c(liveTabEntity.subTabList)) {
            str = "";
        } else {
            str = "";
            for (LiveTabEntity.TabLabelInfo tabLabelInfo : this.a.subTabList) {
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
        this.o = str2;
        getArguments().getInt("tab_position");
        this.g = true;
    }

    public final int r3(LiveFeedWrapData liveFeedWrapData, LiveFeedReserveWrapData liveFeedReserveWrapData) {
        if (liveFeedWrapData == null) {
            return 0;
        }
        if (liveFeedWrapData.refreshType == 0) {
            this.C.clear();
            this.D.clear();
            this.e0.clear();
            J3();
            this.M = 0L;
        }
        if (sd0.c(liveFeedWrapData.roomInfoList)) {
            return 0;
        }
        ArrayList arrayList = new ArrayList();
        for (LiveRoomEntity liveRoomEntity : liveFeedWrapData.roomInfoList) {
            if (liveRoomEntity != null && !vd0.a(liveRoomEntity.roomId) && this.D.add(liveRoomEntity.roomId)) {
                arrayList.add(liveRoomEntity);
            }
        }
        this.C.addAll(arrayList);
        int size = arrayList.size();
        if (liveFeedReserveWrapData != null && liveFeedReserveWrapData.isValid()) {
            Iterator<LiveRoomEntity> it = this.C.iterator();
            while (it.hasNext()) {
                if (it.next().reserveHeaderInfo != null) {
                    it.remove();
                }
            }
            this.E = liveFeedReserveWrapData;
            LiveRoomEntity liveRoomEntity2 = new LiveRoomEntity();
            liveRoomEntity2.reserveHeaderInfo = liveFeedReserveWrapData.headerInfo;
            this.C.add(0, liveRoomEntity2);
        }
        this.B.m(this.C, this.f);
        return size;
    }

    public final void z3(int i2, String str, Map<String, String> map) {
        if (map != null && J1(map.get("tab"), map.get("subtab"), Integer.valueOf(map.get("refresh_type")).intValue())) {
            this.q = "";
            this.H = false;
            K3();
            if (String.valueOf(0).equals(map.get("refresh_type"))) {
                ILiveFeedRefresh.OnRefreshListener onRefreshListener = this.U;
                if (onRefreshListener != null) {
                    onRefreshListener.onPullRefreshEnd();
                }
                O3(this.z, i2, null, "", map.get("session_id"), map.get(LightFileUtils.DIRCTORY_DOWNLOAD_RESOURCE));
                return;
            }
            ILiveFeedRefresh.OnLoadMoreListener onLoadMoreListener = this.s;
            if (onLoadMoreListener != null) {
                onLoadMoreListener.onLoadMoreEnd();
            }
            LiveBaseFragment.a aVar = this.r;
            if (aVar != null) {
                aVar.onShowToast("服务器太累了，请稍后重试");
            }
        }
    }
}
