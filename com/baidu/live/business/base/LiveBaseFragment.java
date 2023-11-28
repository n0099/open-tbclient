package com.baidu.live.business.base;

import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import com.baidu.live.business.model.ILiveFeedModel;
import com.baidu.live.business.model.RequestUtil;
import com.baidu.live.business.model.data.LiveBannerEntity;
import com.baidu.live.business.model.data.LiveFeedConfig;
import com.baidu.live.business.model.data.LiveFeedReserveWrapData;
import com.baidu.live.business.model.data.LiveFeedWrapData;
import com.baidu.live.business.model.data.LiveRoomEntity;
import com.baidu.live.business.model.data.LiveTabEntity;
import com.baidu.live.feedpage.interfaces.ILiveFeedRefresh;
import com.baidu.tieba.w70;
/* loaded from: classes3.dex */
public abstract class LiveBaseFragment extends Fragment {
    public LiveTabEntity a;
    public LiveFeedWrapData b;
    public LiveFeedConfig c;
    public LiveFeedReserveWrapData d;
    public String e;
    public String f;
    public ILiveFeedModel h;
    public ILiveFeedModel.OnDataLoadCallback i;
    public String j;
    public String l;
    public int p;
    public a r;
    public ILiveFeedRefresh.OnLoadMoreListener s;
    public boolean g = true;
    public int k = 1;
    public String m = "";
    public String n = "";
    public String o = "";
    public String q = "";

    /* loaded from: classes3.dex */
    public interface a {
        void onBannerItemClick(LiveBannerEntity liveBannerEntity);

        void onBannerItemShow(LiveBannerEntity liveBannerEntity);

        void onClickFeedItemRoom(LiveRoomEntity liveRoomEntity, int i);

        void onFeedItemRoomShow(LiveRoomEntity liveRoomEntity, int i);

        void onFeedReserveHeaderItemClick(String str);

        void onFeedStabilityLog(LiveFeedWrapData liveFeedWrapData, int i);

        void onHitCache(String str, String str2, String str3, String str4, String str5, int i, LiveFeedWrapData liveFeedWrapData, LiveFeedWrapData liveFeedWrapData2);

        void onItemLabelClickListener(String str, int i, LiveRoomEntity liveRoomEntity);

        void onItemPlayerEnd(int i, String str, String str2, int i2, LiveRoomEntity liveRoomEntity);

        void onItemPlayerStart(int i, String str, String str2, int i2, LiveRoomEntity liveRoomEntity);

        void onShowToast(String str);

        void onSlideLoadMore(String str, String str2);

        void onTabPageHideLog(String str, String str2);

        void onTabPageShowLog(String str, String str2);
    }

    public abstract RecyclerView H2();

    public abstract void K2(boolean z);

    public int G2() {
        RecyclerView.LayoutManager layoutManager = H2().getLayoutManager();
        if (layoutManager instanceof LinearLayoutManager) {
            return ((LinearLayoutManager) layoutManager).findLastVisibleItemPosition();
        }
        if (!(layoutManager instanceof StaggeredGridLayoutManager)) {
            return 0;
        }
        int[] findLastVisibleItemPositions = ((StaggeredGridLayoutManager) layoutManager).findLastVisibleItemPositions(null);
        return Math.max(findLastVisibleItemPositions[0], findLastVisibleItemPositions[1]);
    }

    public void b() {
        J2(null);
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        this.b = null;
        w70.a().e(this);
    }

    public boolean I2(String str, String str2, int i) {
        if (str == null) {
            str = "";
        }
        if (str2 == null) {
            str2 = "";
        }
        return (str + "_" + str2 + "_" + i).equals(this.q);
    }

    public void J2(ILiveFeedRefresh.OnLoadMoreListener onLoadMoreListener) {
        this.s = onLoadMoreListener;
        this.p = 1;
        String str = this.q;
        if (str.equals(this.m + "_" + this.o + "_" + this.p)) {
            return;
        }
        this.q = this.m + "_" + this.o + "_" + this.p;
        this.k = this.k + 1;
        RequestUtil.setResource(40);
        ILiveFeedModel iLiveFeedModel = this.h;
        if (iLiveFeedModel != null) {
            iLiveFeedModel.reqSingleData(RequestUtil.getResourceParam(), this.l, this.p, this.m, this.n, this.o, this.k, this.i);
        }
    }

    public void L2(boolean z) {
        K2(z);
    }

    public void P2(String str) {
        this.f = str;
    }

    public void Q2(LiveFeedConfig liveFeedConfig) {
        this.c = liveFeedConfig;
    }

    public void R2(LiveFeedReserveWrapData liveFeedReserveWrapData) {
        this.d = liveFeedReserveWrapData;
    }

    public void S2(LiveFeedWrapData liveFeedWrapData) {
        this.b = liveFeedWrapData;
    }

    public void T2(a aVar) {
        this.r = aVar;
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
    }

    public boolean M2() {
        this.p = 0;
        String str = this.q;
        if (str.equals(this.m + "_" + this.o + "_" + this.p)) {
            return false;
        }
        this.q = this.m + "_" + this.o + "_" + this.p;
        this.l = "";
        this.k = 1;
        RequestUtil.setResource(40);
        ILiveFeedModel iLiveFeedModel = this.h;
        if (iLiveFeedModel != null) {
            iLiveFeedModel.reqSingleData(RequestUtil.getResourceParam(), this.l, this.p, this.m, this.n, this.o, this.k, this.i);
        }
        return true;
    }

    public boolean N2() {
        this.p = 0;
        String str = this.q;
        if (str.equals(this.m + "_" + this.o + "_" + this.p)) {
            return false;
        }
        this.q = this.m + "_" + this.o + "_" + this.p;
        this.l = "";
        this.k = 1;
        RequestUtil.setResource(59);
        ILiveFeedModel iLiveFeedModel = this.h;
        if (iLiveFeedModel != null) {
            iLiveFeedModel.reqSingleData(RequestUtil.getResourceParam(), this.l, this.p, this.m, this.n, this.o, this.k, this.i);
        }
        return true;
    }

    public boolean O2() {
        this.p = 0;
        String str = this.q;
        if (str.equals(this.m + "_" + this.o + "_" + this.p)) {
            return false;
        }
        this.q = this.m + "_" + this.o + "_" + this.p;
        this.l = "";
        this.k = 1;
        RequestUtil.setResource(58);
        ILiveFeedModel iLiveFeedModel = this.h;
        if (iLiveFeedModel != null) {
            iLiveFeedModel.reqSingleData(RequestUtil.getResourceParam(), this.l, this.p, this.m, this.n, this.o, this.k, this.i);
        }
        return true;
    }
}
