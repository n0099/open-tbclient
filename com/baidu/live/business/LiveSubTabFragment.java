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
import com.baidu.tieba.g90;
import com.baidu.tieba.gb0;
import com.baidu.tieba.h90;
import com.baidu.tieba.hc0;
import com.baidu.tieba.i90;
import com.baidu.tieba.j90;
import com.baidu.tieba.o90;
import com.baidu.tieba.q90;
import com.baidu.tieba.s90;
import com.baidu.tieba.sb0;
import com.baidu.tieba.ta0;
import com.baidu.tieba.ua0;
import com.baidu.tieba.vb0;
import com.baidu.tieba.wa0;
import com.baidu.tieba.y90;
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
    public ta0 a0;
    public ta0 b0;
    public boolean c0;
    public Handler d0;
    public ArrayList e0;
    public boolean f0;
    public Runnable g0;
    public View t;
    public RecyclerView u;
    public View v;
    public o90 w;
    public BdSwipeRefreshLayout x;
    public LoadingView y;
    public ErrorView z;

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
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.a.b0 == null) {
                return;
            }
            this.a.b0.detachFromContainer();
            this.a.b0.setPlayerListener(null);
            this.a.b0 = null;
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
                this.a.x1();
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
                    this.b.P2();
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
                this.a = this.b.q1();
                if (Math.abs(i2) <= 1) {
                    return;
                }
                if ((this.b.K == 0 || ((this.b.K < 0 && i2 > 1) || (this.b.K > 0 && i2 < -1))) && this.b.L != null) {
                    this.b.L.a(i2 > 1);
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
                this.a.t3();
            }
        }

        @Override // com.baidu.live.business.model.LiveFeedInterstModel.OnInterestDataLoadCallback
        public void onSuccess(LiveFeedData liveFeedData, Map<String, String> map) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, liveFeedData, map) == null) {
                if (liveFeedData == null) {
                    onFail(-100, "数据解析失败", map);
                    return;
                }
                this.a.c3(liveFeedData);
                this.a.t3();
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
                this.a.V2();
                this.a.Q2();
                this.a.c0 = false;
            }
        }
    }

    /* loaded from: classes2.dex */
    public class g extends wa0 {
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
        public void onEnd(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i) == null) {
                this.b.A3();
                if (i == 307) {
                    this.b.e0.add(Integer.valueOf(this.b.Y));
                    LiveSubTabFragment liveSubTabFragment = this.b;
                    liveSubTabFragment.Y = Math.max(liveSubTabFragment.Y, this.b.Z) + 1;
                    this.b.N2();
                }
            }
        }

        @Override // com.baidu.searchbox.player.callback.IVideoPlayerCallback
        public void onError(int i, int i2, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, i2, str) == null) {
                Log.e("LiveSubTabFragment", "player1 onError: " + str);
                this.b.A3();
                this.b.e0.add(Integer.valueOf(this.b.Y));
                LiveSubTabFragment liveSubTabFragment = this.b;
                liveSubTabFragment.Y = Math.max(liveSubTabFragment.Y, this.b.Z) + 1;
                this.b.N2();
            }
        }

        @Override // com.baidu.searchbox.player.callback.IVideoPlayerCallback
        public void onInfo(int i, int i2) {
            LiveFeedPageRoundRect liveFeedPageRoundRect;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeII(Constants.METHOD_SEND_USER_MSG, this, i, i2) == null) && i == 904) {
                this.b.B3();
                View findViewByPosition = this.b.u.getLayoutManager().findViewByPosition(this.b.Y);
                if (findViewByPosition == null || (liveFeedPageRoundRect = (LiveFeedPageRoundRect) findViewByPosition.findViewById(R.id.obfuscated_res_0x7f091359)) == null) {
                    return;
                }
                this.b.a0.attachToContainer(liveFeedPageRoundRect);
            }
        }

        @Override // com.baidu.searchbox.player.callback.IVideoPlayerCallback
        public void onPause() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
                this.b.A3();
            }
        }

        @Override // com.baidu.searchbox.player.callback.IVideoPlayerCallback
        public void onResume() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
                this.b.B3();
            }
        }

        @Override // com.baidu.searchbox.player.callback.IVideoPlayerCallback
        public void onVideoSizeChanged(int i, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeII(1048581, this, i, i2) == null) {
                LiveSubTabFragment liveSubTabFragment = this.b;
                liveSubTabFragment.R2(i, i2, this.a, liveSubTabFragment.a0);
            }
        }
    }

    /* loaded from: classes2.dex */
    public class h extends wa0 {
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
        public void onEnd(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i) == null) {
                this.b.C3();
                if (i == 307) {
                    this.b.e0.add(Integer.valueOf(this.b.Z));
                    LiveSubTabFragment liveSubTabFragment = this.b;
                    liveSubTabFragment.Z = Math.max(liveSubTabFragment.Y, this.b.Z) + 1;
                    this.b.O2();
                }
            }
        }

        @Override // com.baidu.searchbox.player.callback.IVideoPlayerCallback
        public void onError(int i, int i2, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, i2, str) == null) {
                Log.e("LiveSubTabFragment", "player2 onError: " + str);
                this.b.C3();
                this.b.e0.add(Integer.valueOf(this.b.Z));
                LiveSubTabFragment liveSubTabFragment = this.b;
                liveSubTabFragment.Z = Math.max(liveSubTabFragment.Y, this.b.Z) + 1;
                this.b.O2();
            }
        }

        @Override // com.baidu.searchbox.player.callback.IVideoPlayerCallback
        public void onInfo(int i, int i2) {
            LiveFeedPageRoundRect liveFeedPageRoundRect;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeII(Constants.METHOD_SEND_USER_MSG, this, i, i2) == null) && i == 904) {
                this.b.D3();
                View findViewByPosition = this.b.u.getLayoutManager().findViewByPosition(this.b.Z);
                if (findViewByPosition == null || (liveFeedPageRoundRect = (LiveFeedPageRoundRect) findViewByPosition.findViewById(R.id.obfuscated_res_0x7f091359)) == null) {
                    return;
                }
                this.b.b0.attachToContainer(liveFeedPageRoundRect);
            }
        }

        @Override // com.baidu.searchbox.player.callback.IVideoPlayerCallback
        public void onPause() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
                this.b.C3();
            }
        }

        @Override // com.baidu.searchbox.player.callback.IVideoPlayerCallback
        public void onResume() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
                this.b.D3();
            }
        }

        @Override // com.baidu.searchbox.player.callback.IVideoPlayerCallback
        public void onVideoSizeChanged(int i, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeII(1048581, this, i, i2) == null) {
                LiveSubTabFragment liveSubTabFragment = this.b;
                liveSubTabFragment.R2(i, i2, this.a, liveSubTabFragment.b0);
            }
        }
    }

    /* loaded from: classes2.dex */
    public class i implements y90 {
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

        @Override // com.baidu.tieba.y90
        public void a(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.a.s3(false, true, null);
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
            if (!(interceptable == null || interceptable.invokeL(1048576, this, liveBannerEntity) == null) || this.a.r == null) {
                return;
            }
            this.a.r.onBannerItemClick(liveBannerEntity);
        }

        @Override // com.baidu.live.business.adapter.LiveSubTabAdapter.a
        public void onBannerItemShow(LiveBannerEntity liveBannerEntity) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, liveBannerEntity) == null) || this.a.r == null) {
                return;
            }
            this.a.r.onBannerItemShow(liveBannerEntity);
        }

        @Override // com.baidu.live.business.adapter.LiveSubTabAdapter.a
        public void onHeaderReserveClick(@Nullable String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
                this.a.m3(str);
            }
        }

        @Override // com.baidu.live.business.adapter.LiveSubTabAdapter.a
        public void onItemLabelClickListener(@NonNull String str, int i, @NonNull LiveRoomEntity liveRoomEntity) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLIL(1048579, this, str, i, liveRoomEntity) == null) || this.a.r == null) {
                return;
            }
            this.a.r.onItemLabelClickListener(str, i, liveRoomEntity);
        }

        @Override // com.baidu.live.business.adapter.LiveSubTabAdapter.a
        public void onItemViewClick(@NonNull LiveRoomEntity liveRoomEntity, int i) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLI(1048580, this, liveRoomEntity, i) == null) || this.a.r == null) {
                return;
            }
            this.a.r.onClickFeedItemRoom(liveRoomEntity, i);
            if (liveRoomEntity.isStatusLiving()) {
                try {
                    if (this.a.c == null || this.a.c.interestInsert == null || this.a.c.interestInsert.tab == null) {
                        return;
                    }
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
                } catch (Exception e) {
                    LiveFeedPageSdk.liveLog(e.getMessage());
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
                } else if (i != this.a.Z || this.a.b0 == null) {
                } else {
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
            if (!(interceptable == null || interceptable.invokeLI(1048582, this, liveRoomEntity, i) == null) || this.a.r == null) {
                return;
            }
            this.a.r.onFeedItemRoomShow(liveRoomEntity, i);
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
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.a.a0 == null) {
                return;
            }
            this.a.a0.detachFromContainer();
            this.a.a0.setPlayerListener(null);
            this.a.a0 = null;
        }
    }

    /* loaded from: classes2.dex */
    public interface l {
        void a(boolean z);
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
            if (!(interceptable == null || interceptable.invokeILL(1048576, this, i, str, map) == null) || (liveSubTabFragment = this.a.get()) == null) {
                return;
            }
            liveSubTabFragment.j3(i, str, map);
        }

        @Override // com.baidu.live.business.model.ILiveFeedModel.OnDataLoadCallback
        public void onSuccess(@Nullable LiveFeedData liveFeedData, Map<String, String> map) {
            LiveSubTabFragment liveSubTabFragment;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, liveFeedData, map) == null) || (liveSubTabFragment = this.a.get()) == null) {
                return;
            }
            liveSubTabFragment.k3(liveFeedData, map);
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

    public static LiveSubTabFragment h3(Bundle bundle) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65578, null, bundle)) == null) {
            LiveSubTabFragment liveSubTabFragment = new LiveSubTabFragment();
            if (bundle != null) {
                liveSubTabFragment.setArguments(bundle);
            }
            return liveSubTabFragment;
        }
        return (LiveSubTabFragment) invokeL.objValue;
    }

    public final void A3() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.r == null) {
            return;
        }
        this.r.onItemPlayerEnd(1, this.m, this.o, this.Y, (LiveRoomEntity) sb0.b(this.C, this.Y));
    }

    public final void B3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            if (this.r != null) {
                this.r.onItemPlayerStart(1, this.m, this.o, this.Y, (LiveRoomEntity) sb0.b(this.C, this.Y));
            }
            int i2 = this.Y;
            if (i2 < 0 || i2 >= this.C.size()) {
                return;
            }
            this.C.get(this.Y).beginTime = String.valueOf(System.currentTimeMillis());
        }
    }

    public final void C3() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || this.r == null) {
            return;
        }
        this.r.onItemPlayerEnd(2, this.m, this.o, this.Y, (LiveRoomEntity) sb0.b(this.C, this.Y));
    }

    public final void D3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            if (this.r != null) {
                this.r.onItemPlayerStart(2, this.m, this.o, this.Y, (LiveRoomEntity) sb0.b(this.C, this.Y));
            }
            int i2 = this.Z;
            if (i2 < 0 || i2 >= this.C.size()) {
                return;
            }
            this.C.get(this.Z).beginTime = String.valueOf(System.currentTimeMillis());
        }
    }

    public void E3(String str, String str2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048580, this, str, str2) == null) || vb0.a(str) || vb0.a(str2) || !str.equals(this.m)) {
            return;
        }
        this.o = str2;
        LiveSubTabAdapter liveSubTabAdapter = this.B;
        if (liveSubTabAdapter != null) {
            liveSubTabAdapter.n(str2);
        }
    }

    public void M2(ILiveFeedOther.LiveFeedStatusListener liveFeedStatusListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, liveFeedStatusListener) == null) {
            this.T = liveFeedStatusListener;
        }
    }

    public final void N2() {
        RecyclerView recyclerView;
        View findViewByPosition;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048582, this) == null) || (recyclerView = this.u) == null || recyclerView.getLayoutManager() == null || (findViewByPosition = this.u.getLayoutManager().findViewByPosition(this.Y)) == null || this.Y >= this.C.size()) {
            return;
        }
        LiveFeedPageRoundRect liveFeedPageRoundRect = (LiveFeedPageRoundRect) findViewByPosition.findViewById(R.id.obfuscated_res_0x7f091359);
        LiveRoomEntity liveRoomEntity = (LiveRoomEntity) sb0.b(this.C, this.Y);
        if (this.a0 == null) {
            ta0 a2 = ua0.a(String.valueOf(this.J));
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
            N2();
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

    public final void O2() {
        RecyclerView recyclerView;
        View findViewByPosition;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048583, this) == null) || (recyclerView = this.u) == null || recyclerView.getLayoutManager() == null || (findViewByPosition = this.u.getLayoutManager().findViewByPosition(this.Z)) == null || this.Z >= this.C.size()) {
            return;
        }
        LiveFeedPageRoundRect liveFeedPageRoundRect = (LiveFeedPageRoundRect) findViewByPosition.findViewById(R.id.obfuscated_res_0x7f091359);
        LiveRoomEntity liveRoomEntity = (LiveRoomEntity) sb0.b(this.C, this.Z);
        if (this.b0 == null) {
            ta0 a2 = ua0.a(String.valueOf(this.J));
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
            O2();
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

    public final void P2() {
        LiveFeedConfig liveFeedConfig;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) || "recommend".equals(this.e) || (liveFeedConfig = this.c) == null || !liveFeedConfig.supportPlay() || this.f0 || LiveFeedAbTest.b()) {
            return;
        }
        this.d0.removeCallbacks(this.g0);
        this.d0.postDelayed(this.g0, 500L);
    }

    public final void Q2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            FloatingService floatingService = (FloatingService) ServiceManager.getService(FloatingService.Companion.getSERVICE_REFERENCE());
            if ((floatingService == null || !floatingService.isFloatViewShowing()) && q90.h(getContext())) {
                N2();
                O2();
            }
        }
    }

    public final void R2(int i2, int i3, LiveRoomEntity liveRoomEntity, ta0 ta0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048586, this, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), liveRoomEntity, ta0Var}) == null) {
            if (liveRoomEntity == null || !liveRoomEntity.isYYShow()) {
                ta0Var.setVideoScalingMode(0);
            } else if (i2 > i3) {
                ta0Var.setVideoScalingMode(2);
            } else {
                ta0Var.setVideoScalingMode(0);
            }
        }
    }

    public boolean S2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            RecyclerView recyclerView = this.u;
            if (recyclerView != null) {
                return recyclerView.canScrollVertically(1);
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public void T2(LiveFeedWrapData liveFeedWrapData, int i2) {
        LiveBaseFragment.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(1048588, this, liveFeedWrapData, i2) == null) || liveFeedWrapData == null || (aVar = this.r) == null) {
            return;
        }
        aVar.onFeedStabilityLog(liveFeedWrapData, i2);
    }

    public int U2(StaggeredGridLayoutManager staggeredGridLayoutManager, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(1048589, this, staggeredGridLayoutManager, z)) == null) {
            int i2 = !z ? 1 : 0;
            if (LiveFeedAbTest.a()) {
                return Y2(staggeredGridLayoutManager.findFirstCompletelyVisibleItemPositions(null)[i2], staggeredGridLayoutManager.findLastCompletelyVisibleItemPositions(null)[i2], staggeredGridLayoutManager);
            }
            return Z2(staggeredGridLayoutManager.findFirstVisibleItemPositions(null)[i2], staggeredGridLayoutManager.findLastVisibleItemPositions(null)[i2], staggeredGridLayoutManager);
        }
        return invokeLZ.intValue;
    }

    public final void V2() {
        RecyclerView recyclerView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048590, this) == null) || (recyclerView = this.u) == null || recyclerView.getLayoutManager() == null) {
            return;
        }
        if (g3()) {
            this.Y = X2((StaggeredGridLayoutManager) this.u.getLayoutManager());
            this.Z = -1;
            return;
        }
        this.Y = U2((StaggeredGridLayoutManager) this.u.getLayoutManager(), true);
        this.Z = U2((StaggeredGridLayoutManager) this.u.getLayoutManager(), false);
    }

    public LiveFeedInterstModel W2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            if (this.R == null) {
                this.R = new LiveFeedInterstModel();
            }
            return this.R;
        }
        return (LiveFeedInterstModel) invokeV.objValue;
    }

    public final int X2(StaggeredGridLayoutManager staggeredGridLayoutManager) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048592, this, staggeredGridLayoutManager)) == null) {
            if (LiveFeedAbTest.a()) {
                return Y2(Math.min(staggeredGridLayoutManager.findFirstCompletelyVisibleItemPositions(null)[0], staggeredGridLayoutManager.findFirstCompletelyVisibleItemPositions(null)[1]), Math.max(staggeredGridLayoutManager.findLastCompletelyVisibleItemPositions(null)[0], staggeredGridLayoutManager.findLastCompletelyVisibleItemPositions(null)[1]), staggeredGridLayoutManager);
            }
            return Z2(Math.min(staggeredGridLayoutManager.findFirstVisibleItemPositions(null)[0], staggeredGridLayoutManager.findFirstVisibleItemPositions(null)[1]), Math.max(staggeredGridLayoutManager.findLastVisibleItemPositions(null)[0], staggeredGridLayoutManager.findLastVisibleItemPositions(null)[1]), staggeredGridLayoutManager);
        }
        return invokeL.intValue;
    }

    public final int Y2(int i2, int i3, StaggeredGridLayoutManager staggeredGridLayoutManager) {
        InterceptResult invokeIIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIIL = interceptable.invokeIIL(1048593, this, i2, i3, staggeredGridLayoutManager)) == null) {
            while (i2 <= i3) {
                LiveRoomEntity liveRoomEntity = (LiveRoomEntity) sb0.b(this.C, i2);
                if (liveRoomEntity != null && liveRoomEntity.canAutoPlay() && !liveRoomEntity.isTopicRoom()) {
                    return i2;
                }
                i2++;
            }
            return -1;
        }
        return invokeIIL.intValue;
    }

    public final int Z2(int i2, int i3, StaggeredGridLayoutManager staggeredGridLayoutManager) {
        InterceptResult invokeIIL;
        View childAt;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIIL = interceptable.invokeIIL(1048594, this, i2, i3, staggeredGridLayoutManager)) == null) {
            for (int i4 = i2; i4 <= i3; i4++) {
                LiveRoomEntity liveRoomEntity = (LiveRoomEntity) sb0.b(this.C, i4);
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

    public final int a3(LiveFeedWrapData liveFeedWrapData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048595, this, liveFeedWrapData)) == null) ? b3(liveFeedWrapData, null) : invokeL.intValue;
    }

    public final int b3(LiveFeedWrapData liveFeedWrapData, LiveFeedReserveWrapData liveFeedReserveWrapData) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048596, this, liveFeedWrapData, liveFeedReserveWrapData)) == null) {
            if (liveFeedWrapData != null) {
                if (liveFeedWrapData.refreshType == 0) {
                    this.C.clear();
                    this.D.clear();
                    this.e0.clear();
                    t3();
                    this.M = 0L;
                }
                if (sb0.c(liveFeedWrapData.roomInfoList)) {
                    return 0;
                }
                ArrayList arrayList = new ArrayList();
                for (LiveRoomEntity liveRoomEntity : liveFeedWrapData.roomInfoList) {
                    if (liveRoomEntity != null && !vb0.a(liveRoomEntity.roomId) && this.D.add(liveRoomEntity.roomId)) {
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
            return 0;
        }
        return invokeLL.intValue;
    }

    public final void c3(LiveFeedData liveFeedData) {
        LiveFeedWrapData liveFeedWrapData;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048597, this, liveFeedData) == null) || liveFeedData == null || (liveFeedWrapData = liveFeedData.feedWrapData) == null || this.P == -1 || sb0.c(liveFeedWrapData.roomInfoList)) {
            return;
        }
        LiveFeedPageSdk.liveLog("yjl_feed_tag", "===>>  handleInterestData ListUtils.isEmpty(feedData.feedWrapData.roomInfoList): " + sb0.c(liveFeedData.feedWrapData.roomInfoList));
        for (LiveRoomEntity liveRoomEntity : liveFeedData.feedWrapData.roomInfoList) {
            liveRoomEntity.hasInterest = true;
        }
        List<LiveRoomEntity> list = this.C;
        if (list == null || list.size() <= 1) {
            return;
        }
        this.C.get(this.P).hasInterestClick = true;
        this.C.addAll(this.P + 1, liveFeedData.feedWrapData.roomInfoList);
        this.B.updateData(this.C);
        this.B.notifyDataSetChanged();
        this.M++;
    }

    public final void d3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048598, this) == null) {
            LiveSubTabAdapter liveSubTabAdapter = new LiveSubTabAdapter(getContext(), this.e, this.m, this.o);
            this.B = liveSubTabAdapter;
            liveSubTabAdapter.k(this.c);
            this.B.m(new j(this));
            this.u.setAdapter(this.B);
        }
    }

    public final void e3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048599, this) == null) {
            BdSwipeRefreshLayout bdSwipeRefreshLayout = (BdSwipeRefreshLayout) this.t.findViewById(R.id.obfuscated_res_0x7f091f94);
            this.x = bdSwipeRefreshLayout;
            bdSwipeRefreshLayout.setOnRefreshListener(this.V);
            RecyclerView recyclerView = (RecyclerView) this.t.findViewById(R.id.obfuscated_res_0x7f091f93);
            this.u = recyclerView;
            recyclerView.setLayoutManager(new FixedStaggeredGridLayoutManager(2, 1));
            this.u.setItemAnimator(null);
            int b2 = q90.b(getContext(), 7.0f);
            if (LiveFeedPageSdk.VIDEO_BAR.equals(this.e)) {
                b2 = q90.b(getContext(), 8.0f);
            }
            this.u.addItemDecoration(new LiveItemDecoration(b2));
            this.u.setOverScrollMode(2);
            this.u.addOnScrollListener(this.W);
            o90 o90Var = new o90(getContext());
            this.w = o90Var;
            this.x.setProgressView(o90Var);
            this.w.y(this.e);
            LoadingView loadingView = (LoadingView) this.t.findViewById(R.id.obfuscated_res_0x7f091f92);
            this.y = loadingView;
            loadingView.c(this.e);
            ErrorView errorView = (ErrorView) this.t.findViewById(R.id.obfuscated_res_0x7f091f91);
            this.z = errorView;
            errorView.c(this.e);
            EmptyView emptyView = (EmptyView) this.t.findViewById(R.id.obfuscated_res_0x7f091f90);
            this.A = emptyView;
            emptyView.a(this.e);
            this.z.setActionCallback(new i(this));
            this.v = this.t.findViewById(R.id.obfuscated_res_0x7f091368);
            if (LiveFeedPageSdk.VIDEO_BAR.equals(this.e)) {
                int b3 = q90.b(getContext(), 9.0f);
                this.u.setPadding(b3, 0, b3, 0);
                this.v.setVisibility(8);
                this.x.setEnabled(false);
            }
            d3();
        }
    }

    public boolean f3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) ? this.H : invokeV.booleanValue;
    }

    public final boolean g3() {
        InterceptResult invokeV;
        LiveFeedConfig.PlayConfig playConfig;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) {
            LiveFeedConfig liveFeedConfig = this.c;
            return (liveFeedConfig == null || (playConfig = liveFeedConfig.playConfig) == null || playConfig.maxPlayCount != 1) ? false : true;
        }
        return invokeV.booleanValue;
    }

    public void i3(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048602, this, str) == null) && this.G) {
            this.t.setBackgroundColor(hc0.f().a(getContext(), this.e, "color_F5F5F51"));
            GradientDrawable gradientDrawable = new GradientDrawable();
            gradientDrawable.setColors(new int[]{hc0.f().a(getContext(), this.e, "color_white1"), hc0.f().a(getContext(), this.e, "color_F5F5F51")});
            gradientDrawable.setGradientType(0);
            gradientDrawable.setOrientation(GradientDrawable.Orientation.TOP_BOTTOM);
            this.v.setBackgroundDrawable(gradientDrawable);
            LiveSubTabAdapter liveSubTabAdapter = this.B;
            if (liveSubTabAdapter != null) {
                liveSubTabAdapter.notifyDataSetChanged();
            }
            o90 o90Var = this.w;
            if (o90Var != null) {
                o90Var.y(this.e);
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

    public final void j3(int i2, String str, Map<String, String> map) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeILL(1048603, this, i2, str, map) == null) && map != null && s1(map.get("tab"), map.get("subtab"), Integer.valueOf(map.get("refresh_type")).intValue())) {
            this.q = "";
            this.H = false;
            u3();
            if (String.valueOf(0).equals(map.get("refresh_type"))) {
                ILiveFeedRefresh.OnRefreshListener onRefreshListener = this.U;
                if (onRefreshListener != null) {
                    onRefreshListener.onPullRefreshEnd();
                }
                y3(this.z, i2, null, "", map.get("session_id"), map.get("resource"));
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

    public final void k3(LiveFeedData liveFeedData, Map<String, String> map) {
        boolean z;
        LiveFeedWrapData liveFeedWrapData;
        RecyclerView recyclerView;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048604, this, liveFeedData, map) == null) {
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
            if (liveFeedData != null && !vb0.a(liveFeedData.resource)) {
                LiveFeedConfig liveFeedConfig = liveFeedData.feedConfig;
                if (liveFeedConfig != null) {
                    this.Q = liveFeedConfig.minorUfoUrl;
                }
                if (liveFeedData.isMinor) {
                    j90 j90Var = new j90();
                    j90Var.b = liveFeedData.isMinor;
                    j90Var.c = this.Q;
                    j90Var.b(this.J);
                    gb0.a().b(j90Var);
                }
                if (liveFeedData.resource.contains(SpeedStatsUtils.UBC_VALUE_BANNER) && liveFeedData.bannerWrapData != null) {
                    g90 g90Var = new g90();
                    g90Var.b = liveFeedData.bannerWrapData;
                    g90Var.b(this.J);
                    gb0.a().b(g90Var);
                }
                if (liveFeedData.resource.contains("follow") && liveFeedData.followWrapData != null) {
                    i90 i90Var = new i90();
                    i90Var.b = liveFeedData.followWrapData;
                    i90Var.b(this.J);
                    gb0.a().b(i90Var);
                }
                LiveFeedWrapData liveFeedWrapData2 = liveFeedData.feedWrapData;
                if (liveFeedWrapData2 != null) {
                    if (s1(liveFeedWrapData2.tab, liveFeedWrapData2.subTab, liveFeedWrapData2.refreshType)) {
                        this.q = "";
                        this.l = liveFeedData.feedWrapData.sessionId;
                        T2(liveFeedData.feedWrapData, b3(liveFeedData.feedWrapData, liveFeedData.resource.contains("reserve") ? liveFeedData.reserveWrapData : null));
                        z = !sb0.c(liveFeedData.feedWrapData.roomInfoList);
                    } else {
                        z = false;
                    }
                    LiveFeedWrapData liveFeedWrapData3 = liveFeedData.feedWrapData;
                    this.H = liveFeedWrapData3.hasMore;
                    this.k = liveFeedWrapData3.refreshIndex;
                    if (liveFeedWrapData3.isBigRefresh()) {
                        gb0.a().b(new h90(this.J));
                    }
                } else {
                    this.H = false;
                    z = false;
                }
                u3();
                if (sb0.c(this.C) && !z) {
                    EmptyView emptyView = this.A;
                    int i2 = liveFeedData.errno;
                    LiveFeedWrapData liveFeedWrapData4 = liveFeedData.feedWrapData;
                    y3(emptyView, i2, liveFeedWrapData4, liveFeedData.logId, liveFeedWrapData4 != null ? liveFeedWrapData4.sessionId : "", liveFeedData.resource);
                    return;
                }
                x3(this.x);
                if (liveFeedData == null || (liveFeedWrapData = liveFeedData.feedWrapData) == null || !liveFeedWrapData.isBigRefresh() || (recyclerView = this.u) == null) {
                    return;
                }
                recyclerView.smoothScrollBy(0, 1);
                this.u.smoothScrollBy(0, -1);
                return;
            }
            j3(-100, "数据解析失败", map);
        }
    }

    public void l3() {
        LiveSubTabAdapter liveSubTabAdapter;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048605, this) == null) || (liveSubTabAdapter = this.B) == null) {
            return;
        }
        liveSubTabAdapter.notifyDataSetChanged();
    }

    public final void lazyLoad() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048606, this) == null) {
            LiveFeedPageSdk.liveLog("LiveSubTabFragment lazyLoad needNewCreate" + this.g + "  needLoadData " + this.I + "  tab " + this.m + "  subTab " + this.o);
            if (this.g && this.I) {
                this.g = false;
                this.I = false;
                LiveFeedWrapData liveFeedWrapData = this.b;
                if (liveFeedWrapData != null && this.m.equals(liveFeedWrapData.tab) && this.o.equals(this.b.subTab)) {
                    T2(this.b, b3(this.b, this.d));
                    LiveFeedWrapData liveFeedWrapData2 = this.b;
                    this.H = liveFeedWrapData2.hasMore;
                    this.l = liveFeedWrapData2.sessionId;
                    u3();
                    if (sb0.c(this.C) && sb0.c(this.b.roomInfoList)) {
                        EmptyView emptyView = this.A;
                        LiveFeedWrapData liveFeedWrapData3 = this.b;
                        y3(emptyView, 0, liveFeedWrapData3, "", liveFeedWrapData3.sessionId, this.j);
                        return;
                    }
                    x3(this.x);
                    return;
                }
                w1();
                RecyclerView recyclerView = this.u;
                if (recyclerView != null && recyclerView.getChildCount() > 0) {
                    this.u.scrollToPosition(0);
                }
                x3(this.y);
            }
        }
    }

    public final void m3(String str) {
        boolean z;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048607, this, str) == null) || this.B == null) {
            return;
        }
        RecyclerView recyclerView = this.u;
        if (recyclerView != null) {
            recyclerView.setItemAnimator(new DefaultItemAnimator());
        }
        Iterator<LiveRoomEntity> it = this.C.iterator();
        int i2 = 0;
        while (true) {
            if (!it.hasNext()) {
                z = false;
                break;
            }
            LiveRoomEntity next = it.next();
            if (next != null) {
                if (next.reserveHeaderInfo != null) {
                    it.remove();
                    z = true;
                    break;
                }
                i2++;
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

    public void n3() {
        LiveBaseFragment.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048608, this) == null) || (aVar = this.r) == null) {
            return;
        }
        aVar.onTabPageHideLog(this.m, this.o);
    }

    public void o3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048609, this) == null) {
            if (q90.f(getContext()) && q90.h(getContext())) {
                P2();
                return;
            }
            ta0 ta0Var = this.a0;
            if (ta0Var != null) {
                ta0Var.detachFromContainer();
                this.a0.stop();
            }
            ta0 ta0Var2 = this.b0;
            if (ta0Var2 != null) {
                ta0Var2.detachFromContainer();
                this.b0.stop();
            }
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048610, this, bundle) == null) {
            super.onActivityCreated(bundle);
        }
    }

    @Override // com.baidu.live.business.base.LiveBaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048611, this, bundle) == null) {
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
            if (sb0.c(liveTabEntity.subTabList)) {
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

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048612, this, layoutInflater, viewGroup, bundle)) == null) {
            LiveFeedPageSdk.liveLog("LiveSubTabFragment onCreateView :  tab " + this.m + "  subTab " + this.o);
            View view2 = this.t;
            if (view2 == null) {
                this.t = layoutInflater.inflate(R.layout.obfuscated_res_0x7f0d054c, viewGroup, false);
                e3();
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

    @Override // com.baidu.live.business.base.LiveBaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048613, this) == null) {
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
            z3(false);
            this.L = null;
            t3();
            this.M = 0L;
            this.R = null;
            LiveSubTabAdapter liveSubTabAdapter = this.B;
            if (liveSubTabAdapter != null) {
                liveSubTabAdapter.m(null);
            }
            this.t = null;
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048614, this) == null) {
            super.onPause();
            LiveFeedPageSdk.liveLog("LiveSubTabFragment onPause  tab " + this.m + "  subTab " + this.o);
            this.f0 = true;
            this.y.d();
            BdSwipeRefreshLayout bdSwipeRefreshLayout = this.x;
            if (bdSwipeRefreshLayout != null) {
                bdSwipeRefreshLayout.setRefreshing(false);
            }
            z3(true);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048615, this) == null) {
            LiveFeedPageSdk.liveLog("LiveSubTabFragment onResume :  tab " + this.m + "  subTab " + this.o);
            super.onResume();
            this.f0 = false;
            this.y.e();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view2, Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048616, this, view2, bundle) == null) {
            super.onViewCreated(view2, bundle);
            this.G = true;
            i3("day");
        }
    }

    public void p3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048617, this) == null) {
            LiveFeedPageSdk.liveLog("LiveSubTabFragment onParentPause :  tab " + this.m + "  subTab " + this.o);
            this.f0 = true;
            z3(true);
        }
    }

    public void q3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048618, this) == null) {
            LiveFeedPageSdk.liveLog("LiveSubTabFragment onParentResume :  tab " + this.m + "  subTab " + this.o);
            this.f0 = false;
            P2();
        }
    }

    @Override // com.baidu.live.business.base.LiveBaseFragment
    public RecyclerView r1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048619, this)) == null) ? this.u : (RecyclerView) invokeV.objValue;
    }

    public void r3() {
        LiveFeedConfig.InterestInsert interestInsert;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048620, this) == null) {
            LiveBaseFragment.a aVar = this.r;
            if (aVar != null) {
                aVar.onTabPageShowLog(this.m, this.o);
            }
            LiveFeedConfig liveFeedConfig = this.c;
            if (liveFeedConfig == null || (interestInsert = liveFeedConfig.interestInsert) == null || this.O == null || this.N == 0 || this.P == -1) {
                return;
            }
            long currentTimeMillis = System.currentTimeMillis();
            boolean isStatusLiving = this.O.isStatusLiving();
            boolean z = currentTimeMillis - this.N > ((long) interestInsert.duration) * 1000;
            boolean z2 = this.M <= ((long) interestInsert.frequency);
            LiveRoomEntity liveRoomEntity = this.O;
            boolean z3 = liveRoomEntity.hasInterest;
            boolean z4 = liveRoomEntity.hasInterestClick;
            LiveFeedPageSdk.liveLog("yjl_feed_tag", "mInterstInsertNumber : " + this.M);
            LiveFeedPageSdk.liveLog("yjl_feed_tag", "(endTime - mInterstStartTime) : " + (currentTimeMillis - this.N));
            LiveFeedPageSdk.liveLog("yjl_feed_tag", "interestInsert.duration * 1000 : " + (interestInsert.duration * 1000));
            LiveFeedPageSdk.liveLog("yjl_feed_tag", "overTime : " + z + " hasInsertOverTimes： " + z2 + " statusLiving： " + isStatusLiving + " \t mCurrentClickItemRoomEntity.hasInterest : " + this.O.hasInterest);
            if (isStatusLiving && z2 && z && !z3 && !z4) {
                LiveFeedInterstModel W2 = W2();
                LiveRoomEntity liveRoomEntity2 = this.O;
                W2.reqInterestData(liveRoomEntity2.sessionId, liveRoomEntity2.liveTag, liveRoomEntity2.feedTag, this.X);
            }
        }
    }

    public void s3(boolean z, boolean z2, ILiveFeedRefresh.OnRefreshListener onRefreshListener) {
        boolean z1;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048621, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2), onRefreshListener}) == null) {
            if (onRefreshListener != null) {
                this.U = onRefreshListener;
            }
            if (this.h != null) {
                if (z) {
                    z1 = x1();
                } else {
                    z1 = z1();
                }
                if (!z1 || this.x == null) {
                    return;
                }
                if (this.C.isEmpty()) {
                    x3(this.y);
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

    public final void t3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048622, this) == null) {
            this.N = 0L;
            this.P = -1;
            this.O = null;
        }
    }

    @Override // com.baidu.live.business.base.LiveBaseFragment
    public void u1(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048623, this, z) == null) {
            LiveFeedPageSdk.liveLog("LiveSubTabFragment onFragmentShow :" + z + "  tab " + this.m + "  subTab " + this.o);
            if (z) {
                lazyLoad();
                r3();
                return;
            }
            n3();
            z3(false);
        }
    }

    public final void u3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048624, this) == null) {
            BdSwipeRefreshLayout bdSwipeRefreshLayout = this.x;
            if (bdSwipeRefreshLayout != null) {
                bdSwipeRefreshLayout.setRefreshing(false);
            }
            this.F = 0;
            if (this.B != null && !sb0.c(this.C)) {
                this.B.l(this.H);
                LiveSubTabAdapter liveSubTabAdapter = this.B;
                liveSubTabAdapter.notifyItemChanged(liveSubTabAdapter.getItemCount() - 1);
            }
            this.c0 = true;
            P2();
        }
    }

    public void v3(l lVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048625, this, lVar) == null) {
            this.L = lVar;
        }
    }

    public void w3(ILiveFeedModel iLiveFeedModel) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048626, this, iLiveFeedModel) == null) {
            this.h = iLiveFeedModel;
            this.i = new m(this);
            this.j = this.h.getInitResource();
        }
    }

    public void x3(View view2) {
        ILiveFeedOther.LiveFeedStatusListener liveFeedStatusListener;
        ILiveFeedOther.LiveFeedStatusListener liveFeedStatusListener2;
        ILiveFeedOther.LiveFeedStatusListener liveFeedStatusListener3;
        ILiveFeedOther.LiveFeedStatusListener liveFeedStatusListener4;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048627, this, view2) == null) || view2 == null) {
            return;
        }
        BdSwipeRefreshLayout bdSwipeRefreshLayout = this.x;
        if (bdSwipeRefreshLayout != null) {
            bdSwipeRefreshLayout.setVisibility(view2 == bdSwipeRefreshLayout ? 0 : 8);
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
            if (view2 != this.x || (liveFeedStatusListener = this.T) == null) {
                return;
            }
            liveFeedStatusListener.onLoadSuccess();
            return;
        }
        ErrorView errorView = this.z;
        if (errorView != null) {
            errorView.e(view2 == errorView ? 0 : 8, this.e);
        }
        EmptyView emptyView = this.A;
        if (emptyView != null) {
            emptyView.c(view2 == emptyView ? 0 : 8, this.e);
        }
        LoadingView loadingView = this.y;
        if (loadingView != null) {
            loadingView.setVisibility(view2 != loadingView ? 8 : 0);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x0053  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0057  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void y3(View view2, int i2, LiveFeedWrapData liveFeedWrapData, String str, String str2, String str3) {
        LiveFeedWrapData liveFeedWrapData2;
        Interceptable interceptable = $ic;
        if (interceptable != null && interceptable.invokeCommon(1048628, this, new Object[]{view2, Integer.valueOf(i2), liveFeedWrapData, str, str2, str3}) != null) {
            return;
        }
        if (!"recommend".equals(this.e) && !LiveFeedPageSdk.VIDEO_BAR.equals(this.e)) {
            LiveFeedWrapData liveFeedWrapData3 = null;
            String b2 = s90.b(LiveFeedWrapData.getFeedCacheKey(this.m, this.o), "");
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
                        s90.g(LiveFeedWrapData.getFeedCacheKey(this.m, this.o));
                        liveFeedWrapData2 = liveFeedWrapData3;
                        if (liveFeedWrapData2 == null) {
                        }
                    }
                } catch (JSONException unused2) {
                }
                if (liveFeedWrapData2 == null) {
                    x3(view2);
                    return;
                }
                a3(liveFeedWrapData2);
                this.H = liveFeedWrapData2.hasMore;
                this.l = liveFeedWrapData2.sessionId;
                u3();
                if (sb0.c(liveFeedWrapData2.roomInfoList)) {
                    x3(view2);
                } else {
                    x3(this.x);
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
            x3(view2);
        }
    }

    public final void z3(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048629, this, z) == null) {
            this.d0.removeCallbacks(this.g0);
            if (z) {
                ta0 ta0Var = this.a0;
                if (ta0Var != null) {
                    ta0Var.stop();
                    this.d0.postDelayed(new k(this), 500L);
                    ta0 ta0Var2 = this.b0;
                    if (ta0Var2 != null) {
                        ta0Var2.stop();
                        this.d0.postDelayed(new a(this), 500L);
                        return;
                    }
                    return;
                }
                return;
            }
            ta0 ta0Var3 = this.a0;
            if (ta0Var3 != null) {
                ta0Var3.detachFromContainer();
                this.a0.setPlayerListener(null);
                this.a0 = null;
            }
            ta0 ta0Var4 = this.b0;
            if (ta0Var4 != null) {
                ta0Var4.detachFromContainer();
                this.b0.setPlayerListener(null);
                this.b0 = null;
            }
        }
    }
}
