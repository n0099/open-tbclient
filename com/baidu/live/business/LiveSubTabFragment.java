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
import androidx.core.view.InputDeviceCompat;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import com.baidu.android.imsdk.internal.Constants;
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
import com.baidu.searchbox.launch.utils.SpeedStatsUtils;
import com.baidu.searchbox.live.interfaces.service.FloatingService;
import com.baidu.searchbox.live.interfaces.service.LiveBdTlsScrollService;
import com.baidu.tieba.R;
import com.baidu.tieba.aa0;
import com.baidu.tieba.ba0;
import com.baidu.tieba.ga0;
import com.baidu.tieba.ia0;
import com.baidu.tieba.ka0;
import com.baidu.tieba.kc0;
import com.baidu.tieba.lb0;
import com.baidu.tieba.mb0;
import com.baidu.tieba.nc0;
import com.baidu.tieba.ob0;
import com.baidu.tieba.qa0;
import com.baidu.tieba.y90;
import com.baidu.tieba.yb0;
import com.baidu.tieba.z90;
import com.baidu.tieba.zc0;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
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
/* loaded from: classes2.dex */
public class LiveSubTabFragment extends LiveBaseFragment {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public EmptyView A;
    public LiveSubTabAdapter B;
    public final List<LiveRoomEntity> C;
    public final Set<String> D;
    public LiveFeedReserveWrapData E;
    public int F;
    public boolean G;
    public boolean H;
    public boolean I;
    public int J;
    public int K;
    public l L;
    public long M;
    public long N;
    public LiveRoomEntity O;
    public int P;
    public String Q;
    public LiveFeedInterstModel R;
    public LiveBdTlsScrollService S;
    public ILiveFeedOther.LiveFeedStatusListener T;
    public ILiveFeedRefresh.OnRefreshListener U;
    public BdSwipeRefreshLayout.j V;
    public RecyclerView.OnScrollListener W;
    public LiveFeedInterstModel.OnInterestDataLoadCallback X;
    public int Y;
    public int Z;
    public lb0 a0;
    public lb0 b0;
    public boolean c0;
    public Handler d0;
    public ArrayList e0;
    public boolean f0;
    public Runnable g0;
    public View t;
    public RecyclerView u;
    public View v;
    public ga0 w;
    public BdSwipeRefreshLayout x;
    public LoadingView y;
    public ErrorView z;

    /* loaded from: classes2.dex */
    public interface l {
        void a(boolean z);
    }

    /* loaded from: classes2.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ LiveSubTabFragment a;

        public a(LiveSubTabFragment liveSubTabFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {liveSubTabFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = liveSubTabFragment;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.a.b0 != null) {
                this.a.b0.detachFromContainer();
                this.a.b0.setPlayerListener(null);
                this.a.b0 = null;
            }
        }
    }

    /* loaded from: classes2.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ LiveSubTabFragment a;

        public b(LiveSubTabFragment liveSubTabFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {liveSubTabFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = liveSubTabFragment;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.u.setItemAnimator(null);
            }
        }
    }

    /* loaded from: classes2.dex */
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
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
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
                if (this.a.x != null) {
                    this.a.x.setRefreshing(true);
                }
                this.a.J1();
            }
        }
    }

    /* loaded from: classes2.dex */
    public class d extends RecyclerView.OnScrollListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public int a;
        public final /* synthetic */ LiveSubTabFragment b;

        public d(LiveSubTabFragment liveSubTabFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {liveSubTabFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = liveSubTabFragment;
            this.a = 0;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, recyclerView, i) == null) {
                super.onScrollStateChanged(recyclerView, i);
                if (this.b.S != null) {
                    this.b.S.onTLSScrollStateChanged(i);
                }
                if (i == 0) {
                    if (this.a + 4 >= this.b.B.getItemCount() && this.b.F == 0 && this.b.H) {
                        this.b.F = 1;
                        this.b.b();
                        if (this.b.r != null) {
                            this.b.r.onSlideLoadMore(this.b.m, this.b.o);
                        }
                    }
                    this.b.a3();
                }
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrolled(RecyclerView recyclerView, int i, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, recyclerView, i, i2) == null) {
                if (this.b.S != null) {
                    this.b.S.onTLSScrolled(i, i2);
                }
                this.a = this.b.C1();
                boolean z = true;
                if (Math.abs(i2) <= 1) {
                    return;
                }
                if ((this.b.K == 0 || ((this.b.K < 0 && i2 > 1) || (this.b.K > 0 && i2 < -1))) && this.b.L != null) {
                    l lVar = this.b.L;
                    if (i2 <= 1) {
                        z = false;
                    }
                    lVar.a(z);
                }
                this.b.K = i2;
            }
        }
    }

    /* loaded from: classes2.dex */
    public class e implements LiveFeedInterstModel.OnInterestDataLoadCallback {
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
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = liveSubTabFragment;
        }

        @Override // com.baidu.live.business.model.LiveFeedInterstModel.OnInterestDataLoadCallback
        public void onFail(int i, String str, Map<String, String> map) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeILL(1048576, this, i, str, map) == null) {
                LiveFeedPageSdk.liveLog("errCode :  errMsg " + str);
                this.a.E3();
            }
        }

        @Override // com.baidu.live.business.model.LiveFeedInterstModel.OnInterestDataLoadCallback
        public void onSuccess(LiveFeedData liveFeedData, Map<String, String> map) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, liveFeedData, map) == null) {
                if (liveFeedData != null) {
                    this.a.n3(liveFeedData);
                    this.a.E3();
                    return;
                }
                onFail(-100, "数据解析失败", map);
            }
        }
    }

    /* loaded from: classes2.dex */
    public class f implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ LiveSubTabFragment a;

        public f(LiveSubTabFragment liveSubTabFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {liveSubTabFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = liveSubTabFragment;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.g3();
                this.a.b3();
                this.a.c0 = false;
            }
        }
    }

    /* loaded from: classes2.dex */
    public class g extends ob0 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ LiveRoomEntity a;
        public final /* synthetic */ LiveSubTabFragment b;

        public g(LiveSubTabFragment liveSubTabFragment, LiveRoomEntity liveRoomEntity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {liveSubTabFragment, liveRoomEntity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = liveSubTabFragment;
            this.a = liveRoomEntity;
        }

        @Override // com.baidu.searchbox.player.callback.IVideoPlayerCallback
        public void onInfo(int i, int i2) {
            LiveFeedPageRoundRect liveFeedPageRoundRect;
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeII(Constants.METHOD_SEND_USER_MSG, this, i, i2) != null) || i != 904) {
                return;
            }
            this.b.M3();
            View findViewByPosition = this.b.u.getLayoutManager().findViewByPosition(this.b.Y);
            if (findViewByPosition != null && (liveFeedPageRoundRect = (LiveFeedPageRoundRect) findViewByPosition.findViewById(R.id.obfuscated_res_0x7f0913fa)) != null) {
                this.b.a0.attachToContainer(liveFeedPageRoundRect);
            }
        }

        @Override // com.baidu.searchbox.player.callback.IVideoPlayerCallback
        public void onEnd(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i) == null) {
                this.b.L3();
                if (i == 307) {
                    this.b.e0.add(Integer.valueOf(this.b.Y));
                    LiveSubTabFragment liveSubTabFragment = this.b;
                    liveSubTabFragment.Y = Math.max(liveSubTabFragment.Y, this.b.Z) + 1;
                    this.b.Y2();
                }
            }
        }

        @Override // com.baidu.searchbox.player.callback.IVideoPlayerCallback
        public void onError(int i, int i2, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, i2, str) == null) {
                Log.e("LiveSubTabFragment", "player1 onError: " + str);
                this.b.L3();
                this.b.e0.add(Integer.valueOf(this.b.Y));
                LiveSubTabFragment liveSubTabFragment = this.b;
                liveSubTabFragment.Y = Math.max(liveSubTabFragment.Y, this.b.Z) + 1;
                this.b.Y2();
            }
        }

        @Override // com.baidu.searchbox.player.callback.IVideoPlayerCallback
        public void onPause() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
                this.b.L3();
            }
        }

        @Override // com.baidu.searchbox.player.callback.IVideoPlayerCallback
        public void onResume() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
                this.b.M3();
            }
        }

        @Override // com.baidu.searchbox.player.callback.IVideoPlayerCallback
        public void onVideoSizeChanged(int i, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeII(1048581, this, i, i2) == null) {
                LiveSubTabFragment liveSubTabFragment = this.b;
                liveSubTabFragment.c3(i, i2, this.a, liveSubTabFragment.a0);
            }
        }
    }

    /* loaded from: classes2.dex */
    public class h extends ob0 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ LiveRoomEntity a;
        public final /* synthetic */ LiveSubTabFragment b;

        public h(LiveSubTabFragment liveSubTabFragment, LiveRoomEntity liveRoomEntity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {liveSubTabFragment, liveRoomEntity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = liveSubTabFragment;
            this.a = liveRoomEntity;
        }

        @Override // com.baidu.searchbox.player.callback.IVideoPlayerCallback
        public void onInfo(int i, int i2) {
            LiveFeedPageRoundRect liveFeedPageRoundRect;
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeII(Constants.METHOD_SEND_USER_MSG, this, i, i2) != null) || i != 904) {
                return;
            }
            this.b.O3();
            View findViewByPosition = this.b.u.getLayoutManager().findViewByPosition(this.b.Z);
            if (findViewByPosition != null && (liveFeedPageRoundRect = (LiveFeedPageRoundRect) findViewByPosition.findViewById(R.id.obfuscated_res_0x7f0913fa)) != null) {
                this.b.b0.attachToContainer(liveFeedPageRoundRect);
            }
        }

        @Override // com.baidu.searchbox.player.callback.IVideoPlayerCallback
        public void onEnd(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i) == null) {
                this.b.N3();
                if (i == 307) {
                    this.b.e0.add(Integer.valueOf(this.b.Z));
                    LiveSubTabFragment liveSubTabFragment = this.b;
                    liveSubTabFragment.Z = Math.max(liveSubTabFragment.Y, this.b.Z) + 1;
                    this.b.Z2();
                }
            }
        }

        @Override // com.baidu.searchbox.player.callback.IVideoPlayerCallback
        public void onError(int i, int i2, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, i2, str) == null) {
                Log.e("LiveSubTabFragment", "player2 onError: " + str);
                this.b.N3();
                this.b.e0.add(Integer.valueOf(this.b.Z));
                LiveSubTabFragment liveSubTabFragment = this.b;
                liveSubTabFragment.Z = Math.max(liveSubTabFragment.Y, this.b.Z) + 1;
                this.b.Z2();
            }
        }

        @Override // com.baidu.searchbox.player.callback.IVideoPlayerCallback
        public void onPause() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
                this.b.N3();
            }
        }

        @Override // com.baidu.searchbox.player.callback.IVideoPlayerCallback
        public void onResume() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
                this.b.O3();
            }
        }

        @Override // com.baidu.searchbox.player.callback.IVideoPlayerCallback
        public void onVideoSizeChanged(int i, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeII(1048581, this, i, i2) == null) {
                LiveSubTabFragment liveSubTabFragment = this.b;
                liveSubTabFragment.c3(i, i2, this.a, liveSubTabFragment.b0);
            }
        }
    }

    /* loaded from: classes2.dex */
    public class i implements qa0 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ LiveSubTabFragment a;

        public i(LiveSubTabFragment liveSubTabFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {liveSubTabFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = liveSubTabFragment;
        }

        @Override // com.baidu.tieba.qa0
        public void a(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.a.D3(false, true, null);
            }
        }
    }

    /* loaded from: classes2.dex */
    public class j implements LiveSubTabAdapter.a {
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
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = liveSubTabFragment;
        }

        @Override // com.baidu.live.business.adapter.LiveSubTabAdapter.a
        public void onBannerItemClick(LiveBannerEntity liveBannerEntity) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, liveBannerEntity) == null) && this.a.r != null) {
                this.a.r.onBannerItemClick(liveBannerEntity);
            }
        }

        @Override // com.baidu.live.business.adapter.LiveSubTabAdapter.a
        public void onBannerItemShow(LiveBannerEntity liveBannerEntity) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, liveBannerEntity) == null) && this.a.r != null) {
                this.a.r.onBannerItemShow(liveBannerEntity);
            }
        }

        @Override // com.baidu.live.business.adapter.LiveSubTabAdapter.a
        public void onHeaderReserveClick(@Nullable String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) != null) {
                return;
            }
            this.a.x3(str);
        }

        @Override // com.baidu.live.business.adapter.LiveSubTabAdapter.a
        public void onItemLabelClickListener(@NonNull String str, int i, @NonNull LiveRoomEntity liveRoomEntity) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLIL(1048579, this, str, i, liveRoomEntity) == null) && this.a.r != null) {
                this.a.r.onItemLabelClickListener(str, i, liveRoomEntity);
            }
        }

        @Override // com.baidu.live.business.adapter.LiveSubTabAdapter.a
        public void onItemViewClick(@NonNull LiveRoomEntity liveRoomEntity, int i) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLI(1048580, this, liveRoomEntity, i) == null) && this.a.r != null) {
                this.a.r.onClickFeedItemRoom(liveRoomEntity, i);
                if (liveRoomEntity.isStatusLiving()) {
                    try {
                        if (this.a.c != null && this.a.c.interestInsert != null && this.a.c.interestInsert.tab != null) {
                            JSONArray jSONArray = this.a.c.interestInsert.tab;
                            int length = jSONArray.length();
                            String[] strArr = new String[length];
                            for (int i2 = 0; i2 < length; i2++) {
                                strArr[i2] = String.valueOf(jSONArray.get(i2));
                            }
                            for (int i3 = 0; i3 < length; i3++) {
                                if (liveRoomEntity.belongSubTab.equals(strArr[i3])) {
                                    this.a.P = i;
                                    this.a.O = liveRoomEntity;
                                    this.a.N = System.currentTimeMillis();
                                    LiveFeedPageSdk.liveLog("yjl_feed_tag", "====>>>onItemViewClick  mCurrentClickPosition :" + this.a.P);
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
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048581, this, i) == null) {
                if (i == this.a.Y) {
                    if (this.a.a0 != null) {
                        this.a.a0.detachFromContainer();
                        if (this.a.a0.isPlaying()) {
                            this.a.a0.stop();
                        }
                    }
                } else if (i == this.a.Z && this.a.b0 != null) {
                    this.a.b0.detachFromContainer();
                    if (this.a.b0.isPlaying()) {
                        this.a.b0.stop();
                    }
                }
            }
        }

        @Override // com.baidu.live.business.adapter.LiveSubTabAdapter.a
        public void onItemViewShow(@NonNull LiveRoomEntity liveRoomEntity, int i) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLI(1048582, this, liveRoomEntity, i) == null) && this.a.r != null) {
                this.a.r.onFeedItemRoomShow(liveRoomEntity, i);
            }
        }
    }

    /* loaded from: classes2.dex */
    public class k implements Runnable {
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
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = liveSubTabFragment;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.a.a0 != null) {
                this.a.a0.detachFromContainer();
                this.a.a0.setPlayerListener(null);
                this.a.a0 = null;
            }
        }
    }

    /* loaded from: classes2.dex */
    public static class m implements ILiveFeedModel.OnDataLoadCallback {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final WeakReference<LiveSubTabFragment> a;

        public m(LiveSubTabFragment liveSubTabFragment) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {liveSubTabFragment};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = new WeakReference<>(liveSubTabFragment);
        }

        @Override // com.baidu.live.business.model.ILiveFeedModel.OnDataLoadCallback
        public void onFail(int i, @Nullable String str, @Nullable Map<String, String> map) {
            LiveSubTabFragment liveSubTabFragment;
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeILL(1048576, this, i, str, map) != null) || (liveSubTabFragment = this.a.get()) == null) {
                return;
            }
            liveSubTabFragment.u3(i, str, map);
        }

        @Override // com.baidu.live.business.model.ILiveFeedModel.OnDataLoadCallback
        public void onSuccess(@Nullable LiveFeedData liveFeedData, Map<String, String> map) {
            LiveSubTabFragment liveSubTabFragment;
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, liveFeedData, map) != null) || (liveSubTabFragment = this.a.get()) == null) {
                return;
            }
            liveSubTabFragment.v3(liveFeedData, map);
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
        this.C = new ArrayList();
        this.D = new HashSet();
        this.F = 0;
        this.G = false;
        this.H = false;
        this.I = true;
        this.M = 0L;
        this.N = 0L;
        this.O = null;
        this.P = -1;
        this.S = (LiveBdTlsScrollService) ServiceManager.getService(LiveBdTlsScrollService.Companion.getSERVICE_REFERENCE());
        this.V = new c(this);
        this.W = new d(this);
        this.X = new e(this);
        this.Y = -1;
        this.Z = -1;
        this.c0 = true;
        this.d0 = new Handler(Looper.getMainLooper());
        this.e0 = new ArrayList();
        this.f0 = true;
        this.g0 = new f(this);
    }

    @Override // com.baidu.live.business.base.LiveBaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048616, this) == null) {
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
            K3(false);
            this.L = null;
            E3();
            this.M = 0L;
            this.R = null;
            LiveSubTabAdapter liveSubTabAdapter = this.B;
            if (liveSubTabAdapter != null) {
                liveSubTabAdapter.m(null);
            }
            this.t = null;
        }
    }

    public static LiveSubTabFragment s3(Bundle bundle) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65589, null, bundle)) == null) {
            LiveSubTabFragment liveSubTabFragment = new LiveSubTabFragment();
            if (bundle != null) {
                liveSubTabFragment.setArguments(bundle);
            }
            return liveSubTabFragment;
        }
        return (LiveSubTabFragment) invokeL.objValue;
    }

    public void G3(l lVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, lVar) == null) {
            this.L = lVar;
        }
    }

    public void H3(ILiveFeedModel iLiveFeedModel) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, iLiveFeedModel) == null) {
            this.h = iLiveFeedModel;
            this.i = new m(this);
            this.j = this.h.getInitResource();
        }
    }

    public void X2(ILiveFeedOther.LiveFeedStatusListener liveFeedStatusListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, liveFeedStatusListener) == null) {
            this.T = liveFeedStatusListener;
        }
    }

    public final int l3(LiveFeedWrapData liveFeedWrapData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048608, this, liveFeedWrapData)) == null) {
            return m3(liveFeedWrapData, null);
        }
        return invokeL.intValue;
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048613, this, bundle) == null) {
            super.onActivityCreated(bundle);
        }
    }

    public void P3(String str, String str2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048593, this, str, str2) == null) && !nc0.a(str) && !nc0.a(str2) && str.equals(this.m)) {
            this.o = str2;
            LiveSubTabAdapter liveSubTabAdapter = this.B;
            if (liveSubTabAdapter != null) {
                liveSubTabAdapter.n(str2);
            }
        }
    }

    public void e3(LiveFeedWrapData liveFeedWrapData, int i2) {
        LiveBaseFragment.a aVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLI(1048601, this, liveFeedWrapData, i2) == null) && liveFeedWrapData != null && (aVar = this.r) != null) {
            aVar.onFeedStabilityLog(liveFeedWrapData, i2);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view2, Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048619, this, view2, bundle) == null) {
            super.onViewCreated(view2, bundle);
            this.G = true;
            t3("day");
        }
    }

    public final int j3(int i2, int i3, StaggeredGridLayoutManager staggeredGridLayoutManager) {
        InterceptResult invokeIIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIIL = interceptable.invokeIIL(1048606, this, i2, i3, staggeredGridLayoutManager)) == null) {
            while (i2 <= i3) {
                LiveRoomEntity liveRoomEntity = (LiveRoomEntity) kc0.b(this.C, i2);
                if (liveRoomEntity != null && liveRoomEntity.canAutoPlay() && !liveRoomEntity.isTopicRoom()) {
                    return i2;
                }
                i2++;
            }
            return -1;
        }
        return invokeIIL.intValue;
    }

    public void A3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            LiveFeedPageSdk.liveLog("LiveSubTabFragment onParentPause :  tab " + this.m + "  subTab " + this.o);
            this.f0 = true;
            K3(true);
        }
    }

    public void B3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            LiveFeedPageSdk.liveLog("LiveSubTabFragment onParentResume :  tab " + this.m + "  subTab " + this.o);
            this.f0 = false;
            a3();
        }
    }

    public final void F3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            BdSwipeRefreshLayout bdSwipeRefreshLayout = this.x;
            if (bdSwipeRefreshLayout != null) {
                bdSwipeRefreshLayout.setRefreshing(false);
            }
            this.F = 0;
            if (this.B != null && !kc0.c(this.C)) {
                this.B.l(this.H);
                LiveSubTabAdapter liveSubTabAdapter = this.B;
                liveSubTabAdapter.notifyItemChanged(liveSubTabAdapter.getItemCount() - 1);
            }
            this.c0 = true;
            a3();
        }
    }

    public final void a3() {
        LiveFeedConfig liveFeedConfig;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048597, this) == null) && !"recommend".equals(this.e) && (liveFeedConfig = this.c) != null && liveFeedConfig.supportPlay() && !this.f0 && !LiveFeedAbTest.b()) {
            this.d0.removeCallbacks(this.g0);
            this.d0.postDelayed(this.g0, 500L);
        }
    }

    public final void b3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048598, this) == null) {
            FloatingService floatingService = (FloatingService) ServiceManager.getService(FloatingService.Companion.getSERVICE_REFERENCE());
            if ((floatingService != null && floatingService.isFloatViewShowing()) || !ia0.h(getContext())) {
                return;
            }
            Y2();
            Z2();
        }
    }

    public final void o3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048612, this) == null) {
            LiveSubTabAdapter liveSubTabAdapter = new LiveSubTabAdapter(getContext(), this.e, this.m, this.o);
            this.B = liveSubTabAdapter;
            liveSubTabAdapter.k(this.c);
            this.B.m(new j(this));
            this.u.setAdapter(this.B);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048617, this) == null) {
            super.onPause();
            LiveFeedPageSdk.liveLog("LiveSubTabFragment onPause  tab " + this.m + "  subTab " + this.o);
            this.f0 = true;
            this.y.d();
            BdSwipeRefreshLayout bdSwipeRefreshLayout = this.x;
            if (bdSwipeRefreshLayout != null) {
                bdSwipeRefreshLayout.setRefreshing(false);
            }
            K3(true);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048618, this) == null) {
            LiveFeedPageSdk.liveLog("LiveSubTabFragment onResume :  tab " + this.m + "  subTab " + this.o);
            super.onResume();
            this.f0 = false;
            this.y.e();
        }
    }

    public void z3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048629, this) == null) {
            if (ia0.f(getContext()) && ia0.h(getContext())) {
                a3();
                return;
            }
            lb0 lb0Var = this.a0;
            if (lb0Var != null) {
                lb0Var.detachFromContainer();
                this.a0.stop();
            }
            lb0 lb0Var2 = this.b0;
            if (lb0Var2 != null) {
                lb0Var2.detachFromContainer();
                this.b0.stop();
            }
        }
    }

    public void C3() {
        LiveFeedConfig.InterestInsert interestInsert;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
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
                    LiveFeedInterstModel h3 = h3();
                    LiveRoomEntity liveRoomEntity2 = this.O;
                    h3.reqInterestData(liveRoomEntity2.sessionId, liveRoomEntity2.liveTag, liveRoomEntity2.feedTag, this.X);
                }
            }
        }
    }

    public final void p3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048620, this) == null) {
            BdSwipeRefreshLayout bdSwipeRefreshLayout = (BdSwipeRefreshLayout) this.t.findViewById(R.id.obfuscated_res_0x7f09208a);
            this.x = bdSwipeRefreshLayout;
            bdSwipeRefreshLayout.setScene(this.e);
            this.x.setOnRefreshListener(this.V);
            RecyclerView recyclerView = (RecyclerView) this.t.findViewById(R.id.obfuscated_res_0x7f092089);
            this.u = recyclerView;
            recyclerView.setLayoutManager(new FixedStaggeredGridLayoutManager(2, 1));
            this.u.setItemAnimator(null);
            int b2 = ia0.b(getContext(), 7.0f);
            if (LiveFeedPageSdk.VIDEO_BAR.equals(this.e)) {
                b2 = ia0.b(getContext(), 8.0f);
            }
            this.u.addItemDecoration(new LiveItemDecoration(b2));
            this.u.setOverScrollMode(2);
            this.u.addOnScrollListener(this.W);
            ga0 ga0Var = new ga0(getContext());
            this.w = ga0Var;
            ga0Var.z(this.e);
            this.x.setProgressView(this.w);
            this.w.y(this.e);
            LoadingView loadingView = (LoadingView) this.t.findViewById(R.id.obfuscated_res_0x7f092088);
            this.y = loadingView;
            loadingView.c(this.e);
            ErrorView errorView = (ErrorView) this.t.findViewById(R.id.obfuscated_res_0x7f092087);
            this.z = errorView;
            errorView.c(this.e);
            EmptyView emptyView = (EmptyView) this.t.findViewById(R.id.obfuscated_res_0x7f092086);
            this.A = emptyView;
            emptyView.a(this.e);
            this.z.setActionCallback(new i(this));
            this.v = this.t.findViewById(R.id.obfuscated_res_0x7f091409);
            if (LiveFeedPageSdk.VIDEO_BAR.equals(this.e)) {
                int b3 = ia0.b(getContext(), 9.0f);
                this.u.setPadding(b3, 0, b3, 0);
                this.v.setVisibility(8);
                this.x.setEnabled(false);
            }
            o3();
        }
    }

    @Override // com.baidu.live.business.base.LiveBaseFragment
    public RecyclerView D1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.u;
        }
        return (RecyclerView) invokeV.objValue;
    }

    public final void E3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            this.N = 0L;
            this.P = -1;
            this.O = null;
        }
    }

    public final void L3() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048589, this) == null) && this.r != null) {
            this.r.onItemPlayerEnd(1, this.m, this.o, this.Y, (LiveRoomEntity) kc0.b(this.C, this.Y));
        }
    }

    public final void N3() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048591, this) == null) && this.r != null) {
            this.r.onItemPlayerEnd(2, this.m, this.o, this.Y, (LiveRoomEntity) kc0.b(this.C, this.Y));
        }
    }

    public boolean d3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) {
            RecyclerView recyclerView = this.u;
            if (recyclerView != null) {
                return recyclerView.canScrollVertically(1);
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public LiveFeedInterstModel h3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048604, this)) == null) {
            if (this.R == null) {
                this.R = new LiveFeedInterstModel();
            }
            return this.R;
        }
        return (LiveFeedInterstModel) invokeV.objValue;
    }

    public boolean q3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048621, this)) == null) {
            return this.H;
        }
        return invokeV.booleanValue;
    }

    public final boolean r3() {
        InterceptResult invokeV;
        LiveFeedConfig.PlayConfig playConfig;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048622, this)) == null) {
            LiveFeedConfig liveFeedConfig = this.c;
            if (liveFeedConfig != null && (playConfig = liveFeedConfig.playConfig) != null && playConfig.maxPlayCount == 1) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public void w3() {
        LiveSubTabAdapter liveSubTabAdapter;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048626, this) == null) && (liveSubTabAdapter = this.B) != null) {
            liveSubTabAdapter.notifyDataSetChanged();
        }
    }

    public void y3() {
        LiveBaseFragment.a aVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048628, this) == null) && (aVar = this.r) != null) {
            aVar.onTabPageHideLog(this.m, this.o);
        }
    }

    public void D3(boolean z, boolean z2, ILiveFeedRefresh.OnRefreshListener onRefreshListener) {
        boolean K1;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048580, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2), onRefreshListener}) == null) {
            if (onRefreshListener != null) {
                this.U = onRefreshListener;
            }
            if (this.h != null) {
                if (z) {
                    K1 = J1();
                } else {
                    K1 = K1();
                }
                if (K1 && this.x != null) {
                    if (this.C.isEmpty()) {
                        I3(this.y);
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
    }

    public final void u3(int i2, String str, Map<String, String> map) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeILL(1048624, this, i2, str, map) == null) && map != null && E1(map.get("tab"), map.get("subtab"), Integer.valueOf(map.get("refresh_type")).intValue())) {
            this.q = "";
            this.H = false;
            F3();
            if (String.valueOf(0).equals(map.get("refresh_type"))) {
                ILiveFeedRefresh.OnRefreshListener onRefreshListener = this.U;
                if (onRefreshListener != null) {
                    onRefreshListener.onPullRefreshEnd();
                }
                J3(this.z, i2, null, "", map.get("session_id"), map.get("resource"));
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

    @Override // com.baidu.live.business.base.LiveBaseFragment
    public void G1(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048583, this, z) == null) {
            LiveFeedPageSdk.liveLog("LiveSubTabFragment onFragmentShow :" + z + "  tab " + this.m + "  subTab " + this.o);
            if (z) {
                lazyLoad();
                C3();
                return;
            }
            y3();
            K3(false);
        }
    }

    public final void K3(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048588, this, z) == null) {
            this.d0.removeCallbacks(this.g0);
            if (z) {
                lb0 lb0Var = this.a0;
                if (lb0Var != null) {
                    lb0Var.stop();
                    this.d0.postDelayed(new k(this), 500L);
                    lb0 lb0Var2 = this.b0;
                    if (lb0Var2 != null) {
                        lb0Var2.stop();
                        this.d0.postDelayed(new a(this), 500L);
                        return;
                    }
                    return;
                }
                return;
            }
            lb0 lb0Var3 = this.a0;
            if (lb0Var3 != null) {
                lb0Var3.detachFromContainer();
                this.a0.setPlayerListener(null);
                this.a0 = null;
            }
            lb0 lb0Var4 = this.b0;
            if (lb0Var4 != null) {
                lb0Var4.detachFromContainer();
                this.b0.setPlayerListener(null);
                this.b0 = null;
            }
        }
    }

    public final int i3(StaggeredGridLayoutManager staggeredGridLayoutManager) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048605, this, staggeredGridLayoutManager)) == null) {
            if (LiveFeedAbTest.a()) {
                return j3(Math.min(staggeredGridLayoutManager.findFirstCompletelyVisibleItemPositions(null)[0], staggeredGridLayoutManager.findFirstCompletelyVisibleItemPositions(null)[1]), Math.max(staggeredGridLayoutManager.findLastCompletelyVisibleItemPositions(null)[0], staggeredGridLayoutManager.findLastCompletelyVisibleItemPositions(null)[1]), staggeredGridLayoutManager);
            }
            return k3(Math.min(staggeredGridLayoutManager.findFirstVisibleItemPositions(null)[0], staggeredGridLayoutManager.findFirstVisibleItemPositions(null)[1]), Math.max(staggeredGridLayoutManager.findLastVisibleItemPositions(null)[0], staggeredGridLayoutManager.findLastVisibleItemPositions(null)[1]), staggeredGridLayoutManager);
        }
        return invokeL.intValue;
    }

    public void I3(View view2) {
        int i2;
        int i3;
        ILiveFeedOther.LiveFeedStatusListener liveFeedStatusListener;
        ILiveFeedOther.LiveFeedStatusListener liveFeedStatusListener2;
        ILiveFeedOther.LiveFeedStatusListener liveFeedStatusListener3;
        ILiveFeedOther.LiveFeedStatusListener liveFeedStatusListener4;
        int i4;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048586, this, view2) != null) || view2 == null) {
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
            if (view2 == this.z && (liveFeedStatusListener4 = this.T) != null) {
                liveFeedStatusListener4.onError();
            }
            if (view2 == this.A && (liveFeedStatusListener3 = this.T) != null) {
                liveFeedStatusListener3.onEmpty();
            }
            if (view2 == this.y && (liveFeedStatusListener2 = this.T) != null) {
                liveFeedStatusListener2.onLoading();
            }
            if (view2 == this.x && (liveFeedStatusListener = this.T) != null) {
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

    public final void n3(LiveFeedData liveFeedData) {
        LiveFeedWrapData liveFeedWrapData;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048611, this, liveFeedData) == null) && liveFeedData != null && (liveFeedWrapData = liveFeedData.feedWrapData) != null && this.P != -1 && !kc0.c(liveFeedWrapData.roomInfoList)) {
            LiveFeedPageSdk.liveLog("yjl_feed_tag", "===>>  handleInterestData ListUtils.isEmpty(feedData.feedWrapData.roomInfoList): " + kc0.c(liveFeedData.feedWrapData.roomInfoList));
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

    public void t3(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048623, this, str) == null) && this.G) {
            this.t.setBackgroundColor(zc0.f().a(getContext(), this.e, "color_F5F5F51"));
            GradientDrawable gradientDrawable = new GradientDrawable();
            gradientDrawable.setColors(new int[]{zc0.f().a(getContext(), this.e, "color_white1"), zc0.f().a(getContext(), this.e, "color_F5F5F51")});
            gradientDrawable.setGradientType(0);
            gradientDrawable.setOrientation(GradientDrawable.Orientation.TOP_BOTTOM);
            this.v.setBackgroundDrawable(gradientDrawable);
            LiveSubTabAdapter liveSubTabAdapter = this.B;
            if (liveSubTabAdapter != null) {
                liveSubTabAdapter.notifyDataSetChanged();
            }
            ga0 ga0Var = this.w;
            if (ga0Var != null) {
                ga0Var.y(this.e);
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

    public final void x3(String str) {
        boolean z;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048627, this, str) != null) || this.B == null) {
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
            recyclerView3.postDelayed(new b(this), 500L);
        }
        LiveBaseFragment.a aVar = this.r;
        if (aVar != null) {
            aVar.onFeedReserveHeaderItemClick(str);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x0053  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0057  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void J3(View view2, int i2, LiveFeedWrapData liveFeedWrapData, String str, String str2, String str3) {
        LiveFeedWrapData liveFeedWrapData2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048587, this, new Object[]{view2, Integer.valueOf(i2), liveFeedWrapData, str, str2, str3}) == null) {
            if (!"recommend".equals(this.e) && !LiveFeedPageSdk.VIDEO_BAR.equals(this.e)) {
                LiveFeedWrapData liveFeedWrapData3 = null;
                String b2 = ka0.b(LiveFeedWrapData.getFeedCacheKey(this.m, this.o), "");
                if (!TextUtils.isEmpty(b2)) {
                    try {
                        JSONObject jSONObject = new JSONObject(b2);
                        LiveFeedWrapData liveFeedWrapData4 = new LiveFeedWrapData();
                        try {
                            liveFeedWrapData4.parserJson(jSONObject, -1, true);
                            liveFeedWrapData4.isCacheData = true;
                            liveFeedWrapData2 = liveFeedWrapData4;
                        } catch (JSONException unused) {
                            liveFeedWrapData3 = liveFeedWrapData4;
                            ka0.g(LiveFeedWrapData.getFeedCacheKey(this.m, this.o));
                            liveFeedWrapData2 = liveFeedWrapData3;
                            if (liveFeedWrapData2 == null) {
                            }
                        }
                    } catch (JSONException unused2) {
                    }
                    if (liveFeedWrapData2 == null) {
                        I3(view2);
                        return;
                    }
                    l3(liveFeedWrapData2);
                    this.H = liveFeedWrapData2.hasMore;
                    this.l = liveFeedWrapData2.sessionId;
                    F3();
                    if (kc0.c(liveFeedWrapData2.roomInfoList)) {
                        I3(view2);
                    } else {
                        I3(this.x);
                        LiveBaseFragment.a aVar = this.r;
                        if (aVar != null) {
                            aVar.onShowToast("服务器太累了，请稍后重试");
                        }
                    }
                    LiveBaseFragment.a aVar2 = this.r;
                    if (aVar2 != null) {
                        aVar2.onHitCache(this.m, this.o, str2, str, str3, i2, liveFeedWrapData2, liveFeedWrapData);
                        return;
                    }
                    return;
                }
                liveFeedWrapData2 = liveFeedWrapData3;
                if (liveFeedWrapData2 == null) {
                }
            } else {
                I3(view2);
            }
        }
    }

    public final void M3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            if (this.r != null) {
                this.r.onItemPlayerStart(1, this.m, this.o, this.Y, (LiveRoomEntity) kc0.b(this.C, this.Y));
            }
            int i2 = this.Y;
            if (i2 >= 0 && i2 < this.C.size()) {
                this.C.get(this.Y).beginTime = String.valueOf(System.currentTimeMillis());
            }
        }
    }

    public final void O3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            if (this.r != null) {
                this.r.onItemPlayerStart(2, this.m, this.o, this.Y, (LiveRoomEntity) kc0.b(this.C, this.Y));
            }
            int i2 = this.Z;
            if (i2 >= 0 && i2 < this.C.size()) {
                this.C.get(this.Z).beginTime = String.valueOf(System.currentTimeMillis());
            }
        }
    }

    public final void g3() {
        RecyclerView recyclerView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048603, this) == null) && (recyclerView = this.u) != null && recyclerView.getLayoutManager() != null) {
            if (r3()) {
                this.Y = i3((StaggeredGridLayoutManager) this.u.getLayoutManager());
                this.Z = -1;
                return;
            }
            this.Y = f3((StaggeredGridLayoutManager) this.u.getLayoutManager(), true);
            this.Z = f3((StaggeredGridLayoutManager) this.u.getLayoutManager(), false);
        }
    }

    public final void Y2() {
        RecyclerView recyclerView;
        View findViewByPosition;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048595, this) == null) && (recyclerView = this.u) != null && recyclerView.getLayoutManager() != null && (findViewByPosition = this.u.getLayoutManager().findViewByPosition(this.Y)) != null && this.Y < this.C.size()) {
            LiveFeedPageRoundRect liveFeedPageRoundRect = (LiveFeedPageRoundRect) findViewByPosition.findViewById(R.id.obfuscated_res_0x7f0913fa);
            LiveRoomEntity liveRoomEntity = (LiveRoomEntity) kc0.b(this.C, this.Y);
            if (this.a0 == null) {
                lb0 a2 = mb0.a(String.valueOf(this.J));
                this.a0 = a2;
                a2.setVideoScalingMode(0);
                this.a0.mute(true);
                this.a0.setAcceptVolumeChange(false);
                this.a0.setPlayerListener(new g(this, liveRoomEntity));
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
                Y2();
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

    public final void Z2() {
        RecyclerView recyclerView;
        View findViewByPosition;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048596, this) == null) && (recyclerView = this.u) != null && recyclerView.getLayoutManager() != null && (findViewByPosition = this.u.getLayoutManager().findViewByPosition(this.Z)) != null && this.Z < this.C.size()) {
            LiveFeedPageRoundRect liveFeedPageRoundRect = (LiveFeedPageRoundRect) findViewByPosition.findViewById(R.id.obfuscated_res_0x7f0913fa);
            LiveRoomEntity liveRoomEntity = (LiveRoomEntity) kc0.b(this.C, this.Z);
            if (this.b0 == null) {
                lb0 a2 = mb0.a(String.valueOf(this.J));
                this.b0 = a2;
                a2.setVideoScalingMode(0);
                this.b0.mute(true);
                this.b0.setAcceptVolumeChange(false);
                this.b0.setPlayerListener(new h(this, liveRoomEntity));
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
                Z2();
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

    public final void c3(int i2, int i3, LiveRoomEntity liveRoomEntity, lb0 lb0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048599, this, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), liveRoomEntity, lb0Var}) == null) {
            if (liveRoomEntity != null && liveRoomEntity.isYYShow()) {
                if (i2 > i3) {
                    lb0Var.setVideoScalingMode(2);
                    return;
                } else {
                    lb0Var.setVideoScalingMode(0);
                    return;
                }
            }
            lb0Var.setVideoScalingMode(0);
        }
    }

    public int f3(StaggeredGridLayoutManager staggeredGridLayoutManager, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(1048602, this, staggeredGridLayoutManager, z)) == null) {
            int i2 = !z ? 1 : 0;
            if (LiveFeedAbTest.a()) {
                return j3(staggeredGridLayoutManager.findFirstCompletelyVisibleItemPositions(null)[i2], staggeredGridLayoutManager.findLastCompletelyVisibleItemPositions(null)[i2], staggeredGridLayoutManager);
            }
            return k3(staggeredGridLayoutManager.findFirstVisibleItemPositions(null)[i2], staggeredGridLayoutManager.findLastVisibleItemPositions(null)[i2], staggeredGridLayoutManager);
        }
        return invokeLZ.intValue;
    }

    public final int k3(int i2, int i3, StaggeredGridLayoutManager staggeredGridLayoutManager) {
        InterceptResult invokeIIL;
        View childAt;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIIL = interceptable.invokeIIL(1048607, this, i2, i3, staggeredGridLayoutManager)) == null) {
            for (int i4 = i2; i4 <= i3; i4++) {
                LiveRoomEntity liveRoomEntity = (LiveRoomEntity) kc0.b(this.C, i4);
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
        return invokeIIL.intValue;
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048615, this, layoutInflater, viewGroup, bundle)) == null) {
            LiveFeedPageSdk.liveLog("LiveSubTabFragment onCreateView :  tab " + this.m + "  subTab " + this.o);
            View view2 = this.t;
            if (view2 == null) {
                this.t = layoutInflater.inflate(R.layout.obfuscated_res_0x7f0d056b, viewGroup, false);
                p3();
            } else {
                ViewGroup viewGroup2 = (ViewGroup) view2.getParent();
                if (viewGroup2 != null) {
                    viewGroup2.removeView(this.t);
                }
            }
            return this.t;
        }
        return (View) invokeLLL.objValue;
    }

    public final void lazyLoad() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048609, this) == null) {
            LiveFeedPageSdk.liveLog("LiveSubTabFragment lazyLoad needNewCreate" + this.g + "  needLoadData " + this.I + "  tab " + this.m + "  subTab " + this.o);
            if (this.g && this.I) {
                this.g = false;
                this.I = false;
                LiveFeedWrapData liveFeedWrapData = this.b;
                if (liveFeedWrapData != null && this.m.equals(liveFeedWrapData.tab) && this.o.equals(this.b.subTab)) {
                    e3(this.b, m3(this.b, this.d));
                    LiveFeedWrapData liveFeedWrapData2 = this.b;
                    this.H = liveFeedWrapData2.hasMore;
                    this.l = liveFeedWrapData2.sessionId;
                    F3();
                    if (kc0.c(this.C) && kc0.c(this.b.roomInfoList)) {
                        EmptyView emptyView = this.A;
                        LiveFeedWrapData liveFeedWrapData3 = this.b;
                        J3(emptyView, 0, liveFeedWrapData3, "", liveFeedWrapData3.sessionId, this.j);
                        return;
                    }
                    I3(this.x);
                    return;
                }
                I1();
                RecyclerView recyclerView = this.u;
                if (recyclerView != null && recyclerView.getChildCount() > 0) {
                    this.u.scrollToPosition(0);
                }
                I3(this.y);
            }
        }
    }

    public final int m3(LiveFeedWrapData liveFeedWrapData, LiveFeedReserveWrapData liveFeedReserveWrapData) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048610, this, liveFeedWrapData, liveFeedReserveWrapData)) == null) {
            if (liveFeedWrapData == null) {
                return 0;
            }
            if (liveFeedWrapData.refreshType == 0) {
                this.C.clear();
                this.D.clear();
                this.e0.clear();
                E3();
                this.M = 0L;
            }
            if (kc0.c(liveFeedWrapData.roomInfoList)) {
                return 0;
            }
            ArrayList arrayList = new ArrayList();
            for (LiveRoomEntity liveRoomEntity : liveFeedWrapData.roomInfoList) {
                if (liveRoomEntity != null && !nc0.a(liveRoomEntity.roomId) && this.D.add(liveRoomEntity.roomId)) {
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
            this.B.e(this.C, this.f);
            return size;
        }
        return invokeLL.intValue;
    }

    @Override // com.baidu.live.business.base.LiveBaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048614, this, bundle) == null) {
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
            if (kc0.c(liveTabEntity.subTabList)) {
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
    }

    public final void v3(LiveFeedData liveFeedData, Map<String, String> map) {
        boolean z;
        LiveFeedWrapData liveFeedWrapData;
        RecyclerView recyclerView;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048625, this, liveFeedData, map) == null) {
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
            if (liveFeedData != null && !nc0.a(liveFeedData.resource)) {
                LiveFeedConfig liveFeedConfig = liveFeedData.feedConfig;
                if (liveFeedConfig != null) {
                    this.Q = liveFeedConfig.minorUfoUrl;
                }
                if (liveFeedData.isMinor) {
                    ba0 ba0Var = new ba0();
                    ba0Var.b = liveFeedData.isMinor;
                    ba0Var.c = this.Q;
                    ba0Var.b(this.J);
                    yb0.a().b(ba0Var);
                }
                if (liveFeedData.resource.contains(SpeedStatsUtils.UBC_VALUE_BANNER) && liveFeedData.bannerWrapData != null) {
                    y90 y90Var = new y90();
                    y90Var.b = liveFeedData.bannerWrapData;
                    y90Var.b(this.J);
                    yb0.a().b(y90Var);
                }
                if (liveFeedData.resource.contains("follow") && liveFeedData.followWrapData != null) {
                    aa0 aa0Var = new aa0();
                    aa0Var.b = liveFeedData.followWrapData;
                    aa0Var.b(this.J);
                    yb0.a().b(aa0Var);
                }
                LiveFeedWrapData liveFeedWrapData2 = liveFeedData.feedWrapData;
                String str = "";
                if (liveFeedWrapData2 != null) {
                    if (E1(liveFeedWrapData2.tab, liveFeedWrapData2.subTab, liveFeedWrapData2.refreshType)) {
                        this.q = "";
                        this.l = liveFeedData.feedWrapData.sessionId;
                        LiveFeedReserveWrapData liveFeedReserveWrapData = null;
                        if (liveFeedData.resource.contains("reserve")) {
                            liveFeedReserveWrapData = liveFeedData.reserveWrapData;
                        }
                        e3(liveFeedData.feedWrapData, m3(liveFeedData.feedWrapData, liveFeedReserveWrapData));
                        z = !kc0.c(liveFeedData.feedWrapData.roomInfoList);
                    } else {
                        z = false;
                    }
                    LiveFeedWrapData liveFeedWrapData3 = liveFeedData.feedWrapData;
                    this.H = liveFeedWrapData3.hasMore;
                    this.k = liveFeedWrapData3.refreshIndex;
                    if (liveFeedWrapData3.isBigRefresh()) {
                        yb0.a().b(new z90(this.J));
                    }
                } else {
                    this.H = false;
                    z = false;
                }
                F3();
                if (kc0.c(this.C) && !z) {
                    EmptyView emptyView = this.A;
                    int i2 = liveFeedData.errno;
                    LiveFeedWrapData liveFeedWrapData4 = liveFeedData.feedWrapData;
                    String str2 = liveFeedData.logId;
                    if (liveFeedWrapData4 != null) {
                        str = liveFeedWrapData4.sessionId;
                    }
                    J3(emptyView, i2, liveFeedWrapData4, str2, str, liveFeedData.resource);
                    return;
                }
                I3(this.x);
                if (liveFeedData != null && (liveFeedWrapData = liveFeedData.feedWrapData) != null && liveFeedWrapData.isBigRefresh() && (recyclerView = this.u) != null) {
                    recyclerView.smoothScrollBy(0, 1);
                    this.u.smoothScrollBy(0, -1);
                    return;
                }
                return;
            }
            u3(-100, "数据解析失败", map);
        }
    }
}
