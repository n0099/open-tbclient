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
import androidx.core.view.InputDeviceCompat;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
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
import com.baidu.mobstat.Config;
import com.baidu.pyramid.runtime.service.ServiceManager;
import com.baidu.searchbox.launch.ExternalTransferSpeedStats;
import com.baidu.searchbox.launch.utils.SpeedStatsUtils;
import com.baidu.searchbox.live.interfaces.service.FloatingService;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.ubc.Flow;
import com.bumptech.glide.load.engine.GlideException;
import com.repackage.a80;
import com.repackage.d80;
import com.repackage.e80;
import com.repackage.ea0;
import com.repackage.f90;
import com.repackage.g90;
import com.repackage.i90;
import com.repackage.ka0;
import com.repackage.n80;
import com.repackage.o80;
import com.repackage.q80;
import com.repackage.t90;
import com.repackage.va0;
import com.repackage.w70;
import com.repackage.x70;
import com.repackage.y70;
import com.repackage.z70;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class LiveSubTabFragment extends LiveBaseFragment {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean A;
    public boolean B;
    public String C;
    public int D;
    public Flow E;
    public Flow F;
    public Flow G;
    public BdSwipeRefreshLayout.j H;
    public RecyclerView.OnScrollListener I;
    public a80.b J;
    public int K;
    public int L;
    public f90 M;
    public f90 N;
    public boolean O;
    public Handler P;
    public ArrayList Q;
    public Runnable R;
    public View n;
    public RecyclerView o;
    public View p;
    public n80 q;
    public BdSwipeRefreshLayout r;
    public LoadingView s;
    public ErrorView t;
    public EmptyView u;
    public LiveSubTabAdapter v;
    public final List<LiveRoomEntity> w;
    public final Set<String> x;
    public int y;
    public boolean z;

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
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.a.M == null) {
                return;
            }
            this.a.M.detachFromContainer();
            this.a.M.setPlayerListener(null);
            this.a.M = null;
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
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.a.N == null) {
                return;
            }
            this.a.N.detachFromContainer();
            this.a.N.setPlayerListener(null);
            this.a.N = null;
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
                if (this.a.r != null) {
                    this.a.r.setRefreshing(true);
                }
                this.a.L0();
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
                if (i == 0) {
                    if (this.a + 4 >= this.b.v.getItemCount() && this.b.y == 0 && this.b.A) {
                        this.b.y = 1;
                        this.b.loadMore();
                        z70.v(recyclerView.getContext(), this.b.C, this.b.d ? "chenjinshi" : "zhibopindao", this.b.i, this.b.k);
                    }
                    this.b.L1();
                }
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrolled(RecyclerView recyclerView, int i, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, recyclerView, i, i2) == null) {
                this.a = this.b.E0();
            }
        }
    }

    /* loaded from: classes2.dex */
    public class e implements a80.b {
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

        @Override // com.repackage.a80.b
        public void a(e80 e80Var, Map<String, String> map) {
            boolean z;
            LiveFeedWrapData liveFeedWrapData;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, e80Var, map) == null) {
                if (e80Var != null && !ka0.a(e80Var.d)) {
                    if (e80Var.d.contains(SpeedStatsUtils.UBC_VALUE_BANNER) && e80Var.e != null) {
                        w70 w70Var = new w70();
                        w70Var.b = e80Var.e;
                        w70Var.b(this.a.D);
                        t90.a().b(w70Var);
                    }
                    if (e80Var.d.contains("follow") && e80Var.f != null) {
                        y70 y70Var = new y70();
                        y70Var.b = e80Var.f;
                        y70Var.b(this.a.D);
                        t90.a().b(y70Var);
                    }
                    LiveFeedWrapData liveFeedWrapData2 = e80Var.h;
                    if (liveFeedWrapData2 != null) {
                        if (this.a.G0(liveFeedWrapData2.tab, liveFeedWrapData2.subTab, liveFeedWrapData2.refreshType)) {
                            this.a.m = "";
                            this.a.h = e80Var.h.sessionId;
                            this.a.O1(e80Var.h, this.a.T1(e80Var.h));
                            z = !ea0.c(e80Var.h.roomInfoList);
                        } else {
                            z = false;
                        }
                        this.a.A = e80Var.h.hasMore;
                        this.a.g = e80Var.h.refreshIndex;
                        if (e80Var.h.isBigRefresh()) {
                            t90.a().b(new x70(this.a.D));
                        }
                    } else {
                        this.a.A = false;
                        z = false;
                    }
                    this.a.f2();
                    if (ea0.c(this.a.w) && !z) {
                        LiveSubTabFragment liveSubTabFragment = this.a;
                        EmptyView emptyView = liveSubTabFragment.u;
                        int i = e80Var.a;
                        LiveFeedWrapData liveFeedWrapData3 = e80Var.h;
                        liveSubTabFragment.h2(emptyView, i, liveFeedWrapData3, e80Var.c, liveFeedWrapData3 != null ? liveFeedWrapData3.sessionId : "", e80Var.d);
                        return;
                    }
                    LiveSubTabFragment liveSubTabFragment2 = this.a;
                    liveSubTabFragment2.g2(liveSubTabFragment2.r);
                    if (e80Var == null || (liveFeedWrapData = e80Var.h) == null || !liveFeedWrapData.isBigRefresh() || this.a.o == null) {
                        return;
                    }
                    this.a.o.smoothScrollBy(0, 1);
                    return;
                }
                b(-100, "数据解析失败", map);
            }
        }

        @Override // com.repackage.a80.b
        public void b(int i, String str, Map<String, String> map) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeILL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, str, map) == null) && map != null && this.a.G0(map.get("tab"), map.get("subtab"), Integer.valueOf(map.get("refresh_type")).intValue())) {
                this.a.m = "";
                this.a.A = false;
                this.a.f2();
                if (String.valueOf(0).equals(map.get("refresh_type"))) {
                    LiveSubTabFragment liveSubTabFragment = this.a;
                    liveSubTabFragment.h2(liveSubTabFragment.t, i, null, "", map.get("session_id"), map.get("resource"));
                    return;
                }
                LiveFeedPageSdk.f().g().a(this.a.getActivity(), "服务器太累了，请稍后重试");
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
                this.a.Q1();
                this.a.M1();
                this.a.O = false;
            }
        }
    }

    /* loaded from: classes2.dex */
    public class g extends i90 {
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
                this.b.j2();
                if (i == 307) {
                    this.b.Q.add(Integer.valueOf(this.b.K));
                    LiveSubTabFragment liveSubTabFragment = this.b;
                    liveSubTabFragment.K = Math.max(liveSubTabFragment.K, this.b.L) + 1;
                    this.b.J1();
                }
            }
        }

        @Override // com.baidu.searchbox.player.callback.IVideoPlayerCallback
        public void onError(int i, int i2, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, i2, str) == null) {
                Log.e("LiveSubTabFragment", "player1 onError: " + str);
                this.b.j2();
                this.b.Q.add(Integer.valueOf(this.b.K));
                LiveSubTabFragment liveSubTabFragment = this.b;
                liveSubTabFragment.K = Math.max(liveSubTabFragment.K, this.b.L) + 1;
                this.b.J1();
            }
        }

        @Override // com.baidu.searchbox.player.callback.IVideoPlayerCallback
        public void onInfo(int i, int i2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeII(Constants.METHOD_SEND_USER_MSG, this, i, i2) == null) && i == 904) {
                this.b.k2();
                View findViewByPosition = this.b.o.getLayoutManager().findViewByPosition(this.b.K);
                if (findViewByPosition != null) {
                    this.b.M.attachToContainer((LiveFeedPageRoundRect) findViewByPosition.findViewById(R.id.obfuscated_res_0x7f09126a));
                }
            }
        }

        @Override // com.baidu.searchbox.player.callback.IVideoPlayerCallback
        public void onPause() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
                this.b.j2();
            }
        }

        @Override // com.baidu.searchbox.player.callback.IVideoPlayerCallback
        public void onResume() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
                this.b.k2();
            }
        }

        @Override // com.baidu.searchbox.player.callback.IVideoPlayerCallback
        public void onVideoSizeChanged(int i, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeII(1048581, this, i, i2) == null) {
                LiveSubTabFragment liveSubTabFragment = this.b;
                liveSubTabFragment.N1(i, i2, this.a, liveSubTabFragment.M);
            }
        }
    }

    /* loaded from: classes2.dex */
    public class h extends i90 {
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
                this.b.l2();
                if (i == 307) {
                    this.b.Q.add(Integer.valueOf(this.b.L));
                    LiveSubTabFragment liveSubTabFragment = this.b;
                    liveSubTabFragment.L = Math.max(liveSubTabFragment.K, this.b.L) + 1;
                    this.b.K1();
                }
            }
        }

        @Override // com.baidu.searchbox.player.callback.IVideoPlayerCallback
        public void onError(int i, int i2, String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, i2, str) == null) {
                Log.e("LiveSubTabFragment", "player2 onError: " + str);
                this.b.l2();
                this.b.Q.add(Integer.valueOf(this.b.L));
                LiveSubTabFragment liveSubTabFragment = this.b;
                liveSubTabFragment.L = Math.max(liveSubTabFragment.K, this.b.L) + 1;
                this.b.K1();
            }
        }

        @Override // com.baidu.searchbox.player.callback.IVideoPlayerCallback
        public void onInfo(int i, int i2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeII(Constants.METHOD_SEND_USER_MSG, this, i, i2) == null) && i == 904) {
                this.b.m2();
                View findViewByPosition = this.b.o.getLayoutManager().findViewByPosition(this.b.L);
                if (findViewByPosition != null) {
                    this.b.N.attachToContainer((LiveFeedPageRoundRect) findViewByPosition.findViewById(R.id.obfuscated_res_0x7f09126a));
                }
            }
        }

        @Override // com.baidu.searchbox.player.callback.IVideoPlayerCallback
        public void onPause() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
                this.b.l2();
            }
        }

        @Override // com.baidu.searchbox.player.callback.IVideoPlayerCallback
        public void onResume() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
                this.b.m2();
            }
        }

        @Override // com.baidu.searchbox.player.callback.IVideoPlayerCallback
        public void onVideoSizeChanged(int i, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeII(1048581, this, i, i2) == null) {
                LiveSubTabFragment liveSubTabFragment = this.b;
                liveSubTabFragment.N1(i, i2, this.a, liveSubTabFragment.N);
            }
        }
    }

    /* loaded from: classes2.dex */
    public class i extends StaggeredGridLayoutManager {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ LiveSubTabFragment a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public i(LiveSubTabFragment liveSubTabFragment, int i, int i2) {
            super(i, i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {liveSubTabFragment, Integer.valueOf(i), Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
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
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /* loaded from: classes2.dex */
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

        @Override // com.baidu.live.business.view.emotion.ErrorView.b
        public void a(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.a.e2(false, true);
            }
        }
    }

    /* loaded from: classes2.dex */
    public class k implements LiveSubTabAdapter.a {
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

        @Override // com.baidu.live.business.adapter.LiveSubTabAdapter.a
        public void a(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i) == null) {
                if (i == this.a.K) {
                    if (this.a.M != null) {
                        this.a.M.detachFromContainer();
                        if (this.a.M.isPlaying()) {
                            this.a.M.stop();
                        }
                    }
                } else if (i != this.a.L || this.a.N == null) {
                } else {
                    this.a.N.detachFromContainer();
                    if (this.a.N.isPlaying()) {
                        this.a.N.stop();
                    }
                }
            }
        }

        @Override // com.baidu.live.business.adapter.LiveSubTabAdapter.a
        public void b(ViewGroup viewGroup, int i, @NonNull LiveRoomEntity liveRoomEntity) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, viewGroup, i, liveRoomEntity) == null) {
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
        this.w = new ArrayList();
        this.x = new HashSet();
        this.y = 0;
        this.z = false;
        this.A = false;
        this.B = true;
        this.H = new c(this);
        this.I = new d(this);
        this.J = new e(this);
        this.K = -1;
        this.L = -1;
        this.O = true;
        this.P = new Handler(Looper.getMainLooper());
        this.Q = new ArrayList();
        this.R = new f(this);
    }

    public static LiveSubTabFragment X1(Bundle bundle) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65556, null, bundle)) == null) {
            LiveSubTabFragment liveSubTabFragment = new LiveSubTabFragment();
            if (bundle != null) {
                liveSubTabFragment.setArguments(bundle);
            }
            return liveSubTabFragment;
        }
        return (LiveSubTabFragment) invokeL.objValue;
    }

    @Override // com.baidu.live.business.base.LiveBaseFragment
    public RecyclerView F0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.o : (RecyclerView) invokeV.objValue;
    }

    @Override // com.baidu.live.business.base.LiveBaseFragment
    public void H0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) {
            LiveFeedPageSdk.m("LiveSubTabFragment onFragmentShow :" + z + "  tab " + this.i + "  subTab " + this.k);
            if (z) {
                lazyLoad();
                d2();
                return;
            }
            Z1();
            i2(false);
        }
    }

    public final void J1() {
        View findViewByPosition;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || (findViewByPosition = this.o.getLayoutManager().findViewByPosition(this.K)) == null) {
            return;
        }
        LiveFeedPageRoundRect liveFeedPageRoundRect = (LiveFeedPageRoundRect) findViewByPosition.findViewById(R.id.obfuscated_res_0x7f09126a);
        LiveRoomEntity liveRoomEntity = (LiveRoomEntity) ea0.b(this.w, this.K);
        if (this.M == null) {
            f90 a2 = g90.a(String.valueOf(this.D));
            this.M = a2;
            a2.setVideoScalingMode(0);
            this.M.mute(true);
            this.M.setAcceptVolumeChange(false);
            this.M.setPlayerListener(new g(this, liveRoomEntity));
        }
        if (this.w.get(this.K) != null && this.M.getVideoUrl() != null && !this.M.getVideoUrl().equals(this.w.get(this.K).playUrl)) {
            if (!this.Q.contains(Integer.valueOf(this.K)) && !TextUtils.isEmpty(this.w.get(this.K).playUrl)) {
                this.M.detachFromContainer();
                if (this.M.isPlaying()) {
                    this.M.stop();
                }
                this.M.setVideoUrl(this.w.get(this.K).playUrl);
                this.M.start();
                return;
            }
            this.K = Math.max(this.K, this.L) + 1;
            J1();
            return;
        }
        if (this.M.getVideoUrl() == null && !TextUtils.isEmpty(this.w.get(this.K).playUrl)) {
            this.M.detachFromContainer();
            if (this.M.isPlaying()) {
                this.M.stop();
            }
            this.M.setVideoUrl(this.w.get(this.K).playUrl);
            this.M.start();
        }
        if (this.O) {
            this.M.detachFromContainer();
            this.M.attachToContainer(liveFeedPageRoundRect);
        }
    }

    public final void K1() {
        View findViewByPosition;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || (findViewByPosition = this.o.getLayoutManager().findViewByPosition(this.L)) == null) {
            return;
        }
        LiveFeedPageRoundRect liveFeedPageRoundRect = (LiveFeedPageRoundRect) findViewByPosition.findViewById(R.id.obfuscated_res_0x7f09126a);
        LiveRoomEntity liveRoomEntity = (LiveRoomEntity) ea0.b(this.w, this.L);
        if (this.N == null) {
            f90 a2 = g90.a(String.valueOf(this.D));
            this.N = a2;
            a2.setVideoScalingMode(0);
            this.N.mute(true);
            this.N.setAcceptVolumeChange(false);
            this.N.setPlayerListener(new h(this, liveRoomEntity));
        }
        if (this.w.get(this.L) != null && this.N.getVideoUrl() != null && !this.N.getVideoUrl().equals(this.w.get(this.L).playUrl)) {
            if (!this.Q.contains(Integer.valueOf(this.L)) && !TextUtils.isEmpty(this.w.get(this.L).playUrl)) {
                this.N.detachFromContainer();
                if (this.N.isPlaying()) {
                    this.N.stop();
                }
                this.N.setVideoUrl(this.w.get(this.L).playUrl);
                this.N.start();
                return;
            }
            this.L = Math.max(this.K, this.L) + 1;
            K1();
            return;
        }
        if (this.N.getVideoUrl() == null && !TextUtils.isEmpty(this.w.get(this.L).playUrl)) {
            this.N.detachFromContainer();
            if (this.N.isPlaying()) {
                this.N.stop();
            }
            this.N.setVideoUrl(this.w.get(this.L).playUrl);
            this.N.start();
        }
        if (this.O) {
            this.N.detachFromContainer();
            this.N.attachToContainer(liveFeedPageRoundRect);
        }
    }

    public final void L1() {
        d80 d80Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048580, this) == null) && (d80Var = this.c) != null && d80Var.b()) {
            this.P.removeCallbacks(this.R);
            this.P.postDelayed(this.R, 500L);
        }
    }

    public final void M1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            FloatingService floatingService = (FloatingService) ServiceManager.getService(FloatingService.Companion.getSERVICE_REFERENCE());
            if ((floatingService == null || !floatingService.isFloatViewShowing()) && NetWorkUtils.c(getContext())) {
                J1();
                K1();
            }
        }
    }

    public final void N1(int i2, int i3, LiveRoomEntity liveRoomEntity, f90 f90Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048582, this, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), liveRoomEntity, f90Var}) == null) {
            if (liveRoomEntity != null && liveRoomEntity.isDateLive()) {
                if (liveRoomEntity.showTpl == 3) {
                    f90Var.setVideoScalingMode(9);
                } else {
                    f90Var.setVideoScalingMode(0);
                }
            } else if (liveRoomEntity == null || !liveRoomEntity.isYYShow()) {
                f90Var.setVideoScalingMode(0);
            } else if (i2 > i3) {
                f90Var.setVideoScalingMode(2);
            } else {
                f90Var.setVideoScalingMode(0);
            }
        }
    }

    public void O1(LiveFeedWrapData liveFeedWrapData, int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(1048583, this, liveFeedWrapData, i2) == null) || liveFeedWrapData == null) {
            return;
        }
        z70.g(getActivity(), this.C, z70.m(this.d), liveFeedWrapData.errCode, liveFeedWrapData.errMsg, liveFeedWrapData.tab, liveFeedWrapData.subTab, liveFeedWrapData.sessionId, ea0.c(liveFeedWrapData.roomInfoList) ? 0 : liveFeedWrapData.roomInfoList.size(), i2, liveFeedWrapData.refreshType, liveFeedWrapData.refreshIndex);
    }

    public int P1(StaggeredGridLayoutManager staggeredGridLayoutManager, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, staggeredGridLayoutManager, z)) == null) {
            int i2 = !z ? 1 : 0;
            return S1(staggeredGridLayoutManager.findFirstVisibleItemPositions(null)[i2], staggeredGridLayoutManager.findLastVisibleItemPositions(null)[i2], staggeredGridLayoutManager);
        }
        return invokeLZ.intValue;
    }

    public final void Q1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            if (W1()) {
                this.K = R1((StaggeredGridLayoutManager) this.o.getLayoutManager());
                this.L = -1;
                return;
            }
            this.K = P1((StaggeredGridLayoutManager) this.o.getLayoutManager(), true);
            this.L = P1((StaggeredGridLayoutManager) this.o.getLayoutManager(), false);
        }
    }

    public final int R1(StaggeredGridLayoutManager staggeredGridLayoutManager) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, staggeredGridLayoutManager)) == null) ? S1(Math.min(staggeredGridLayoutManager.findFirstVisibleItemPositions(null)[0], staggeredGridLayoutManager.findFirstVisibleItemPositions(null)[1]), Math.max(staggeredGridLayoutManager.findLastVisibleItemPositions(null)[0], staggeredGridLayoutManager.findLastVisibleItemPositions(null)[1]), staggeredGridLayoutManager) : invokeL.intValue;
    }

    public final int S1(int i2, int i3, StaggeredGridLayoutManager staggeredGridLayoutManager) {
        InterceptResult invokeIIL;
        LiveRoomEntity liveRoomEntity;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIIL = interceptable.invokeIIL(1048587, this, i2, i3, staggeredGridLayoutManager)) == null) {
            for (int i4 = i2; i4 <= i3; i4++) {
                int i5 = i4 - i2;
                View childAt = staggeredGridLayoutManager.getChildAt(i5);
                if (childAt != null && !this.w.isEmpty() && i5 >= 0 && i5 < this.w.size() && (liveRoomEntity = this.w.get(i5)) != null && liveRoomEntity.canAutoPlay()) {
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

    public final int T1(LiveFeedWrapData liveFeedWrapData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048588, this, liveFeedWrapData)) == null) {
            if (liveFeedWrapData != null) {
                if (liveFeedWrapData.refreshType == 0) {
                    this.w.clear();
                    this.x.clear();
                    this.Q.clear();
                }
                if (!ea0.c(liveFeedWrapData.roomInfoList)) {
                    ArrayList arrayList = new ArrayList();
                    for (LiveRoomEntity liveRoomEntity : liveFeedWrapData.roomInfoList) {
                        if (liveRoomEntity != null && !ka0.a(liveRoomEntity.roomId) && this.x.add(liveRoomEntity.roomId)) {
                            arrayList.add(liveRoomEntity);
                        }
                    }
                    this.w.addAll(arrayList);
                    int size = arrayList.size();
                    this.v.f(this.w);
                    return size;
                }
            }
            return 0;
        }
        return invokeL.intValue;
    }

    public final void U1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            LiveSubTabAdapter liveSubTabAdapter = new LiveSubTabAdapter(getContext(), this.d, this.C, this.i, this.k);
            this.v = liveSubTabAdapter;
            liveSubTabAdapter.o(new k(this));
            this.o.setAdapter(this.v);
        }
    }

    public final void V1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            BdSwipeRefreshLayout bdSwipeRefreshLayout = (BdSwipeRefreshLayout) this.n.findViewById(R.id.obfuscated_res_0x7f091dad);
            this.r = bdSwipeRefreshLayout;
            bdSwipeRefreshLayout.setOnRefreshListener(this.H);
            RecyclerView recyclerView = (RecyclerView) this.n.findViewById(R.id.obfuscated_res_0x7f091dac);
            this.o = recyclerView;
            recyclerView.setLayoutManager(new i(this, 2, 1));
            this.o.setItemAnimator(null);
            this.o.addItemDecoration(new LiveItemDecoration(o80.a(getContext(), 7.0f)));
            this.o.setOverScrollMode(2);
            this.o.addOnScrollListener(this.I);
            n80 n80Var = new n80(getContext());
            this.q = n80Var;
            this.r.setProgressView(n80Var);
            this.q.y(this.d);
            LoadingView loadingView = (LoadingView) this.n.findViewById(R.id.obfuscated_res_0x7f091dab);
            this.s = loadingView;
            loadingView.c(this.d);
            ErrorView errorView = (ErrorView) this.n.findViewById(R.id.obfuscated_res_0x7f091daa);
            this.t = errorView;
            errorView.c(this.d);
            EmptyView emptyView = (EmptyView) this.n.findViewById(R.id.obfuscated_res_0x7f091da9);
            this.u = emptyView;
            emptyView.a(this.d);
            this.t.setActionCallback(new j(this));
            this.p = this.n.findViewById(R.id.obfuscated_res_0x7f091275);
            U1();
        }
    }

    public final boolean W1() {
        InterceptResult invokeV;
        d80.a aVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            d80 d80Var = this.c;
            return (d80Var == null || (aVar = d80Var.d) == null || aVar.b != 1) ? false : true;
        }
        return invokeV.booleanValue;
    }

    public void Y1(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048592, this, str) == null) && this.z) {
            this.n.setBackgroundColor(va0.e().a(getContext(), this.d, "color_F5F5F51"));
            GradientDrawable gradientDrawable = new GradientDrawable();
            gradientDrawable.setColors(new int[]{va0.e().a(getContext(), this.d, "color_white1"), va0.e().a(getContext(), this.d, "color_F5F5F51")});
            gradientDrawable.setGradientType(0);
            gradientDrawable.setOrientation(GradientDrawable.Orientation.TOP_BOTTOM);
            this.p.setBackgroundDrawable(gradientDrawable);
            LiveSubTabAdapter liveSubTabAdapter = this.v;
            if (liveSubTabAdapter != null) {
                liveSubTabAdapter.notifyDataSetChanged();
            }
            n80 n80Var = this.q;
            if (n80Var != null) {
                n80Var.y(this.d);
            }
            ErrorView errorView = this.t;
            if (errorView != null) {
                errorView.c(this.d);
            }
            EmptyView emptyView = this.u;
            if (emptyView != null) {
                emptyView.a(this.d);
            }
            LoadingView loadingView = this.s;
            if (loadingView != null) {
                loadingView.c(this.d);
            }
        }
    }

    public void Z1() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048593, this) == null) || this.E == null) {
            return;
        }
        LiveFeedPageSdk.m("LivePageLog onHintLog  " + this.i + GlideException.IndentedAppendable.INDENT + this.k + "   " + this.E.hashCode());
        z70.q(getActivity(), false, this.C, z70.m(this.d), this.i, this.k, this.E);
        this.E = null;
    }

    public void a2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
            if (NetWorkUtils.b(getContext()) && NetWorkUtils.c(getContext())) {
                L1();
                return;
            }
            f90 f90Var = this.M;
            if (f90Var != null) {
                f90Var.detachFromContainer();
                this.M.stop();
            }
            f90 f90Var2 = this.N;
            if (f90Var2 != null) {
                f90Var2.detachFromContainer();
                this.N.stop();
            }
        }
    }

    public void b2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048595, this) == null) {
            LiveFeedPageSdk.m("LiveSubTabFragment onParentPause :  tab " + this.i + "  subTab " + this.k);
            i2(true);
        }
    }

    public void c2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048596, this) == null) {
            LiveFeedPageSdk.m("LiveSubTabFragment onParentResume :  tab " + this.i + "  subTab " + this.k);
            L1();
        }
    }

    public void d2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048597, this) == null) {
            this.E = z70.q(getActivity(), true, this.C, z70.m(this.d), this.i, this.k, null);
            LiveFeedPageSdk.m("LivePageLog onShowLog  " + this.i + GlideException.IndentedAppendable.INDENT + this.k + "   " + this.E.hashCode());
        }
    }

    public void e2(boolean z, boolean z2) {
        boolean K0;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048598, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) || this.f == null) {
            return;
        }
        if (z) {
            K0 = L0();
        } else {
            K0 = K0();
        }
        if (!K0 || this.r == null) {
            return;
        }
        if (this.w.isEmpty()) {
            g2(this.s);
        }
        RecyclerView recyclerView = this.o;
        if (recyclerView != null && recyclerView.getChildCount() > 0) {
            this.o.scrollToPosition(0);
        }
        if (z2) {
            this.r.setRefreshing(true);
        }
    }

    public final void f2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048599, this) == null) {
            BdSwipeRefreshLayout bdSwipeRefreshLayout = this.r;
            if (bdSwipeRefreshLayout != null) {
                bdSwipeRefreshLayout.setRefreshing(false);
            }
            this.y = 0;
            if (this.v != null && !ea0.c(this.w)) {
                this.v.n(this.A);
                LiveSubTabAdapter liveSubTabAdapter = this.v;
                liveSubTabAdapter.notifyItemChanged(liveSubTabAdapter.getItemCount() - 1);
            }
            this.O = true;
            L1();
        }
    }

    public void g2(View view2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048600, this, view2) == null) || view2 == null) {
            return;
        }
        ErrorView errorView = this.t;
        if (errorView != null) {
            errorView.d(view2 == errorView ? 0 : 8, this.d);
        }
        EmptyView emptyView = this.u;
        if (emptyView != null) {
            emptyView.b(view2 == emptyView ? 0 : 8, this.d);
        }
        LoadingView loadingView = this.s;
        if (loadingView != null) {
            loadingView.setVisibility(view2 == loadingView ? 0 : 8);
        }
        BdSwipeRefreshLayout bdSwipeRefreshLayout = this.r;
        if (bdSwipeRefreshLayout != null) {
            bdSwipeRefreshLayout.setVisibility(view2 != bdSwipeRefreshLayout ? 8 : 0);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x003e  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0043  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void h2(View view2, int i2, LiveFeedWrapData liveFeedWrapData, String str, String str2, String str3) {
        JSONObject jSONObject;
        LiveFeedWrapData liveFeedWrapData2;
        int i3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048601, this, new Object[]{view2, Integer.valueOf(i2), liveFeedWrapData, str, str2, str3}) == null) {
            String b2 = q80.b(LiveFeedWrapData.getFeedCacheKey(this.i, this.k), "");
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
                    q80.g(LiveFeedWrapData.getFeedCacheKey(this.i, this.k));
                    if (liveFeedWrapData3 != null) {
                    }
                }
            }
            if (liveFeedWrapData3 != null) {
                g2(view2);
                return;
            }
            T1(liveFeedWrapData3);
            this.A = liveFeedWrapData3.hasMore;
            this.h = liveFeedWrapData3.sessionId;
            f2();
            if (ea0.c(liveFeedWrapData3.roomInfoList)) {
                g2(view2);
            } else {
                g2(this.r);
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
                z70.p(getActivity(), this.C, z70.m(this.d), liveFeedWrapData == null ? -100 : liveFeedWrapData.errCode, liveFeedWrapData != null ? liveFeedWrapData.errMsg : "", str, str3, this.i, this.k, str2, i3, ExternalTransferSpeedStats.FEED_PAGE, liveFeedWrapData3.cacheTime, System.currentTimeMillis(), 1);
            }
        }
    }

    public final void i2(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048602, this, z) == null) {
            if (z) {
                f90 f90Var = this.M;
                if (f90Var != null) {
                    f90Var.stop();
                    this.P.postDelayed(new a(this), 500L);
                    f90 f90Var2 = this.N;
                    if (f90Var2 != null) {
                        f90Var2.stop();
                        this.P.postDelayed(new b(this), 500L);
                        return;
                    }
                    return;
                }
                return;
            }
            f90 f90Var3 = this.M;
            if (f90Var3 != null) {
                f90Var3.detachFromContainer();
                this.M.setPlayerListener(null);
                this.M = null;
            }
            f90 f90Var4 = this.N;
            if (f90Var4 != null) {
                f90Var4.detachFromContainer();
                this.N.setPlayerListener(null);
                this.N = null;
            }
        }
    }

    public final void j2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048603, this) == null) {
            LiveRoomEntity liveRoomEntity = (LiveRoomEntity) ea0.b(this.w, this.K);
            if (this.F == null || liveRoomEntity == null) {
                return;
            }
            z70.t(getContext(), false, this.C, z70.m(this.d), this.K, this.i, this.k, liveRoomEntity, this.F);
            this.F = null;
        }
    }

    public final void k2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048604, this) == null) {
            this.F = z70.t(getContext(), true, this.C, z70.m(this.d), this.K, this.i, this.k, (LiveRoomEntity) ea0.b(this.w, this.K), null);
        }
    }

    public final void l2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048605, this) == null) {
            LiveRoomEntity liveRoomEntity = (LiveRoomEntity) ea0.b(this.w, this.L);
            if (this.G == null || liveRoomEntity == null) {
                return;
            }
            z70.t(getContext(), false, this.C, z70.m(this.d), this.L, this.i, this.k, liveRoomEntity, this.G);
            this.G = null;
        }
    }

    public final void lazyLoad() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048606, this) == null) {
            LiveFeedPageSdk.m("LiveSubTabFragment lazyLoad needNewCreate" + this.e + "  needLoadData " + this.B + "  tab " + this.i + "  subTab " + this.k);
            if (this.e && this.B) {
                this.e = false;
                this.B = false;
                LiveFeedWrapData liveFeedWrapData = this.b;
                if (liveFeedWrapData != null && this.i.equals(liveFeedWrapData.tab) && this.k.equals(this.b.subTab)) {
                    LiveFeedWrapData liveFeedWrapData2 = this.b;
                    if (liveFeedWrapData2 != null) {
                        O1(this.b, T1(liveFeedWrapData2));
                        LiveFeedWrapData liveFeedWrapData3 = this.b;
                        this.A = liveFeedWrapData3.hasMore;
                        this.h = liveFeedWrapData3.sessionId;
                        f2();
                        if (ea0.c(this.w) && ea0.c(this.b.roomInfoList)) {
                            EmptyView emptyView = this.u;
                            LiveFeedWrapData liveFeedWrapData4 = this.b;
                            h2(emptyView, 0, liveFeedWrapData4, "", liveFeedWrapData4.sessionId, "banner,tab,feed,follow,config");
                            return;
                        }
                        g2(this.r);
                        return;
                    }
                    return;
                }
                J0();
                RecyclerView recyclerView = this.o;
                if (recyclerView != null && recyclerView.getChildCount() > 0) {
                    this.o.scrollToPosition(0);
                }
                g2(this.s);
            }
        }
    }

    public final void m2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048607, this) == null) {
            this.G = z70.t(getContext(), true, this.C, z70.m(this.d), this.L, this.i, this.k, (LiveRoomEntity) ea0.b(this.w, this.L), null);
        }
    }

    public void n2(String str, String str2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048608, this, str, str2) == null) || ka0.a(str) || ka0.a(str2) || !str.equals(this.i)) {
            return;
        }
        this.k = str2;
        LiveSubTabAdapter liveSubTabAdapter = this.v;
        if (liveSubTabAdapter != null) {
            liveSubTabAdapter.q(str2);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048609, this, bundle) == null) {
            super.onActivityCreated(bundle);
        }
    }

    @Override // com.baidu.live.business.base.LiveBaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048610, this, bundle) == null) {
            super.onCreate(bundle);
            LiveFeedPageSdk.m("onCreate :  tab " + this.i + "  subTab " + this.k);
            this.d = getArguments().getBoolean("tab_is_immer");
            this.D = getArguments().getInt("tab_bd_id");
            this.C = getArguments().getString("source");
            String string = getArguments().getString("scheme_def_tab_type");
            LiveTabEntity liveTabEntity = (LiveTabEntity) getArguments().getParcelable("tab_entity_item");
            this.a = liveTabEntity;
            this.i = liveTabEntity.type;
            this.j = liveTabEntity.channelId;
            String str2 = "";
            if (ea0.c(liveTabEntity.subTabList)) {
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
            this.k = str2;
            getArguments().getInt("tab_position");
            this.e = true;
        }
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048611, this, layoutInflater, viewGroup, bundle)) == null) {
            LiveFeedPageSdk.m("LiveSubTabFragment onCreateView :  tab " + this.i + "  subTab " + this.k);
            View view2 = this.n;
            if (view2 == null) {
                this.n = layoutInflater.inflate(R.layout.obfuscated_res_0x7f0d0506, viewGroup, false);
                V1();
            } else {
                ViewGroup viewGroup2 = (ViewGroup) view2.getParent();
                if (viewGroup2 != null) {
                    viewGroup2.removeView(this.n);
                }
            }
            if (this.f == null) {
                this.f = new a80(getContext(), this.d, this.C);
            }
            this.f.i(this.J);
            return this.n;
        }
        return (View) invokeLLL.objValue;
    }

    @Override // com.baidu.live.business.base.LiveBaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048612, this) == null) {
            super.onDestroy();
            LiveFeedPageSdk.m("LiveSubTabFragment onDestroy :  tab " + this.i + "  subTab " + this.k);
            this.B = true;
            this.e = true;
            this.z = false;
            this.A = false;
            this.w.clear();
            this.x.clear();
            LoadingView loadingView = this.s;
            if (loadingView != null) {
                loadingView.a();
            }
            BdSwipeRefreshLayout bdSwipeRefreshLayout = this.r;
            if (bdSwipeRefreshLayout != null) {
                bdSwipeRefreshLayout.setRefreshing(false);
            }
            this.Q.clear();
            this.P.removeCallbacksAndMessages(null);
            i2(false);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048613, this) == null) {
            super.onPause();
            LiveFeedPageSdk.m("LiveSubTabFragment onPause  tab " + this.i + "  subTab " + this.k);
            this.s.d();
            BdSwipeRefreshLayout bdSwipeRefreshLayout = this.r;
            if (bdSwipeRefreshLayout != null) {
                bdSwipeRefreshLayout.setRefreshing(false);
            }
            i2(true);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048614, this) == null) {
            LiveFeedPageSdk.m("LiveSubTabFragment onResume :  tab " + this.i + "  subTab " + this.k);
            super.onResume();
            this.s.e();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view2, Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048615, this, view2, bundle) == null) {
            super.onViewCreated(view2, bundle);
            this.z = true;
            Y1(Config.TRACE_VISIT_RECENT_DAY);
        }
    }
}
