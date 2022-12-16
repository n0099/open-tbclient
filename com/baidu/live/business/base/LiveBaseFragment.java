package com.baidu.live.business.base;

import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.live.business.model.ILiveFeedModel;
import com.baidu.live.business.model.RequestUtil;
import com.baidu.live.business.model.data.LiveBannerEntity;
import com.baidu.live.business.model.data.LiveFeedConfig;
import com.baidu.live.business.model.data.LiveFeedReserveWrapData;
import com.baidu.live.business.model.data.LiveFeedWrapData;
import com.baidu.live.business.model.data.LiveRoomEntity;
import com.baidu.live.business.model.data.LiveTabEntity;
import com.baidu.live.feedpage.interfaces.ILiveFeedRefresh;
import com.baidu.tieba.tb0;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes2.dex */
public abstract class LiveBaseFragment extends Fragment {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public LiveTabEntity a;
    public LiveFeedWrapData b;
    public LiveFeedConfig c;
    public LiveFeedReserveWrapData d;
    public String e;
    public String f;
    public boolean g;
    public ILiveFeedModel h;
    public ILiveFeedModel.OnDataLoadCallback i;
    public String j;
    public int k;
    public String l;
    public String m;
    public String n;
    public String o;
    public int p;
    public String q;
    public a r;
    public ILiveFeedRefresh.OnLoadMoreListener s;

    /* loaded from: classes2.dex */
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

    public abstract void B1(boolean z);

    public abstract RecyclerView y1();

    public LiveBaseFragment() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.g = true;
        this.k = 1;
        this.m = "";
        this.n = "";
        this.o = "";
        this.q = "";
    }

    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            A1(null);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            super.onDestroy();
            this.b = null;
            tb0.a().e(this);
        }
    }

    public void A1(ILiveFeedRefresh.OnLoadMoreListener onLoadMoreListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, onLoadMoreListener) == null) {
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
    }

    public void C1(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z) == null) {
            B1(z);
        }
    }

    public void G1(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, str) == null) {
            this.f = str;
        }
    }

    public void H1(LiveFeedConfig liveFeedConfig) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, liveFeedConfig) == null) {
            this.c = liveFeedConfig;
        }
    }

    public void I1(LiveFeedReserveWrapData liveFeedReserveWrapData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, liveFeedReserveWrapData) == null) {
            this.d = liveFeedReserveWrapData;
        }
    }

    public void J1(LiveFeedWrapData liveFeedWrapData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, liveFeedWrapData) == null) {
            this.b = liveFeedWrapData;
        }
    }

    public void K1(a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, aVar) == null) {
            this.r = aVar;
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(@Nullable Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, bundle) == null) {
            super.onCreate(bundle);
        }
    }

    public boolean D1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
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
        return invokeV.booleanValue;
    }

    public boolean E1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
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
        return invokeV.booleanValue;
    }

    public boolean F1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
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
        return invokeV.booleanValue;
    }

    public int x1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            RecyclerView.LayoutManager layoutManager = y1().getLayoutManager();
            if (layoutManager instanceof LinearLayoutManager) {
                return ((LinearLayoutManager) layoutManager).findLastVisibleItemPosition();
            }
            if (!(layoutManager instanceof StaggeredGridLayoutManager)) {
                return 0;
            }
            int[] findLastVisibleItemPositions = ((StaggeredGridLayoutManager) layoutManager).findLastVisibleItemPositions(null);
            return Math.max(findLastVisibleItemPositions[0], findLastVisibleItemPositions[1]);
        }
        return invokeV.intValue;
    }

    public boolean z1(String str, String str2, int i) {
        InterceptResult invokeLLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(1048592, this, str, str2, i)) == null) {
            if (str == null) {
                str = "";
            }
            if (str2 == null) {
                str2 = "";
            }
            return (str + "_" + str2 + "_" + i).equals(this.q);
        }
        return invokeLLI.booleanValue;
    }
}
