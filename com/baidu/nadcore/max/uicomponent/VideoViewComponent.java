package com.baidu.nadcore.max.uicomponent;

import android.content.Intent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.nadcore.component.AbsComponentPlugin;
import com.baidu.nadcore.max.event.VideoEventTypeEnum;
import com.baidu.nadcore.max.uiwidget.basic.VideoViewHolder;
import com.baidu.nadcore.widget.AdImageView;
import com.baidu.searchbox.live.frame.IntentData;
import com.baidu.searchbox.live.interfaces.DI;
import com.baidu.tbadk.core.atomData.WriteActivityConfig;
import com.baidu.tbadk.mutiprocess.mission.MissionEvent;
import com.baidu.tieba.R;
import com.baidu.tieba.as0;
import com.baidu.tieba.bs0;
import com.baidu.tieba.ep0;
import com.baidu.tieba.es0;
import com.baidu.tieba.gp0;
import com.baidu.tieba.kz0;
import com.baidu.tieba.m31;
import com.baidu.tieba.mo0;
import com.baidu.tieba.qo0;
import com.baidu.tieba.ro0;
import com.baidu.tieba.wh0;
import com.baidu.tieba.wo0;
import com.baidu.tieba.xi0;
import com.baidu.tieba.yo0;
import com.baidu.tieba.zp0;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.Serializable;
import java.util.HashMap;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000~\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0006\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\bF\u0010\bJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\u0007\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\t\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\t\u0010\bJ\u0017\u0010\f\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\nH\u0002¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000e\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u000e\u0010\bJ\u000f\u0010\u000f\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u000f\u0010\bJ\u0017\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\u0010\u0010\rJ\u0017\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u0011H\u0016¢\u0006\u0004\b\u0013\u0010\u0014J\u000f\u0010\u0015\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0015\u0010\bJ\u000f\u0010\u0016\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0016\u0010\bJ\u000f\u0010\u0017\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0017\u0010\bJ\u0017\u0010\u0018\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u0011H\u0002¢\u0006\u0004\b\u0018\u0010\u0014J\u0017\u0010\u001a\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0019H\u0016¢\u0006\u0004\b\u001a\u0010\u001bR\u0018\u0010\u001d\u001a\u0004\u0018\u00010\u001c8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0016\u0010 \u001a\u00020\u001f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b \u0010!R\u0018\u0010#\u001a\u0004\u0018\u00010\"8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b#\u0010$R\u0016\u0010&\u001a\u00020%8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b&\u0010'R\u0018\u0010)\u001a\u0004\u0018\u00010(8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b)\u0010*R\u0016\u0010+\u001a\u00020\u001f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b+\u0010!R\u0016\u0010-\u001a\u00020,8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b-\u0010.R\u0016\u0010/\u001a\u00020,8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b/\u0010.R\"\u00100\u001a\u00020%8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b0\u0010'\u001a\u0004\b1\u00102\"\u0004\b3\u00104R\u0018\u00106\u001a\u0004\u0018\u0001058\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b6\u00107R\u0018\u00109\u001a\u0004\u0018\u0001088\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b9\u0010:R\u0016\u0010;\u001a\u00020,8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b;\u0010.R\u0018\u0010=\u001a\u0004\u0018\u00010<8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b=\u0010>R\u0016\u0010?\u001a\u00020\u001f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b?\u0010!R\u001d\u0010E\u001a\u00020@8B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\bA\u0010B\u001a\u0004\bC\u0010D¨\u0006G"}, d2 = {"Lcom/baidu/nadcore/max/uicomponent/VideoViewComponent;", "Lcom/baidu/nadcore/component/AbsComponentPlugin;", "Lcom/baidu/nadcore/max/event/NestedScrollEvent;", "event", "", "handleNestedScrollEvent", "(Lcom/baidu/nadcore/max/event/NestedScrollEvent;)V", "initBackgroundView", "()V", "initRealVideoHolder", "Landroid/view/ViewGroup;", "parent", "initVideoHolder", "(Landroid/view/ViewGroup;)V", "initVideoPlayer", "injectService", "onCreateView", "Landroid/content/Intent;", IntentData.KEY, "onNewIntent", "(Landroid/content/Intent;)V", MissionEvent.MESSAGE_PAUSE, "onRelease", "onResume", "parseData", "Lcom/baidu/nadcore/component/api/IComponentEvent;", "receiveEvent", "(Lcom/baidu/nadcore/component/api/IComponentEvent;)V", "", "backgroundImage", "Ljava/lang/String;", "", "isVideoVisible", "Z", "Lcom/baidu/nadcore/player/Player;", DI.LIVE_PLAYER, "Lcom/baidu/nadcore/player/Player;", "", "playerLoopCount", "I", "Lcom/baidu/nadcore/player/SimplePlayerStatusCallback;", "playerStatusCallback", "Lcom/baidu/nadcore/player/SimplePlayerStatusCallback;", "replayVideo", "", "screenHW", "D", "topMarginRatio", "videoHeight", "getVideoHeight", "()I", "setVideoHeight", "(I)V", "Lcom/baidu/nadcore/max/uiwidget/basic/VideoViewHolder;", "videoHolder", "Lcom/baidu/nadcore/max/uiwidget/basic/VideoViewHolder;", "Lcom/baidu/nadcore/model/AdVideoInfo;", "videoInfo", "Lcom/baidu/nadcore/model/AdVideoInfo;", "videoRatio", "Landroid/widget/FrameLayout;", "videoRealHolder", "Landroid/widget/FrameLayout;", "videoStretchSwitch", "Lcom/baidu/nadcore/max/service/IVideoViewService;", "videoViewService$delegate", "Lkotlin/Lazy;", "getVideoViewService", "()Lcom/baidu/nadcore/max/service/IVideoViewService;", "videoViewService", "<init>", "nadcore-lib-business"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes2.dex */
public final class VideoViewComponent extends AbsComponentPlugin {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public as0 d;
    public es0 e;
    public zp0 f;
    public int g;
    public VideoViewHolder h;
    public FrameLayout i;
    public boolean j;
    public boolean k;
    public String l;
    public double m;
    public double n;
    public double o;
    public boolean p;
    public int q;
    public final Lazy r;

    public final yo0 w() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? (yo0) this.r.getValue() : (yo0) invokeV.objValue;
    }

    /* loaded from: classes2.dex */
    public static final class a implements VideoViewHolder.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ VideoViewComponent a;
        public final /* synthetic */ ViewGroup b;

        public a(VideoViewComponent videoViewComponent, ViewGroup viewGroup, FrameLayout.LayoutParams layoutParams) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {videoViewComponent, viewGroup, layoutParams};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = videoViewComponent;
            this.b = viewGroup;
        }

        @Override // com.baidu.nadcore.max.uiwidget.basic.VideoViewHolder.a
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.j().k(new ro0(VideoEventTypeEnum.LEFT_SLIDE_ON_VIDEO));
            }
        }

        @Override // com.baidu.nadcore.max.uiwidget.basic.VideoViewHolder.a
        public void onClick() {
            wo0 wo0Var;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && !this.a.p && (wo0Var = (wo0) this.a.j().p(wo0.class)) != null) {
                wo0Var.j(true, true, false);
            }
        }

        @Override // com.baidu.nadcore.max.uiwidget.basic.VideoViewHolder.a
        public void onTouch(View v, MotionEvent event) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, v, event) == null) {
                Intrinsics.checkNotNullParameter(v, "v");
                Intrinsics.checkNotNullParameter(event, "event");
                wo0 wo0Var = (wo0) this.a.j().p(wo0.class);
                if (wo0Var != null) {
                    wo0Var.i(event);
                }
            }
        }
    }

    /* loaded from: classes2.dex */
    public static final class b extends es0 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ VideoViewComponent a;

        /* JADX DEBUG: Incorrect args count in method signature: ()V */
        public b(VideoViewComponent videoViewComponent) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {videoViewComponent};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = videoViewComponent;
        }

        @Override // com.baidu.tieba.es0, com.baidu.tieba.xr0
        public void onInfo(int i, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeII(1048576, this, i, i2) == null) {
                if (i != 904) {
                    if (i == 955 || i == 956) {
                        this.a.j().k(new ro0(VideoEventTypeEnum.PLAY_SEEK_TO_END));
                        this.a.q++;
                        return;
                    }
                    return;
                }
                this.a.j().k(new ro0(VideoEventTypeEnum.FIRST_FRAME_INTERVAL));
            }
        }

        @Override // com.baidu.tieba.es0, com.baidu.tieba.xr0
        public void onUpdateProgress(int i, int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, i2, i3) == null) {
                this.a.j().k(new qo0(VideoEventTypeEnum.PLAY_INFO_PROCESS, i, i3));
            }
        }
    }

    /* loaded from: classes2.dex */
    public static final class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ VideoViewComponent a;
        public final /* synthetic */ ViewGroup b;

        public c(VideoViewComponent videoViewComponent, ViewGroup viewGroup) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {videoViewComponent, viewGroup};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = videoViewComponent;
            this.b = viewGroup;
        }

        @Override // java.lang.Runnable
        public final void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.D(this.b.getMeasuredHeight());
                this.a.o = this.b.getMeasuredHeight() / this.b.getMeasuredWidth();
                this.a.A(this.b);
                this.a.y();
                this.a.z();
                this.a.B();
            }
        }
    }

    public VideoViewComponent() {
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
        this.p = true;
        this.q = 1;
        this.r = LazyKt__LazyJVMKt.lazy(new VideoViewComponent$videoViewService$2(this));
    }

    @Override // com.baidu.nadcore.component.AbsComponentPlugin, com.baidu.nadcore.component.api.IComponentPlugin
    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            super.d();
            j().s(yo0.class, w());
        }
    }

    @Override // com.baidu.nadcore.component.AbsComponentPlugin
    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            super.onPause();
            as0 as0Var = this.d;
            if (as0Var != null) {
                as0Var.pause();
            }
        }
    }

    @Override // com.baidu.nadcore.component.AbsComponentPlugin, com.baidu.nadcore.component.api.IComponentPlugin
    public void onRelease() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            super.onRelease();
            as0 as0Var = this.d;
            if (as0Var != null) {
                as0Var.release();
            }
            this.d = null;
            wh0.e(this.h);
            VideoViewHolder videoViewHolder = this.h;
            if (videoViewHolder != null) {
                videoViewHolder.removeAllViews();
            }
            this.h = null;
            this.i = null;
            this.l = null;
        }
    }

    @Override // com.baidu.nadcore.component.AbsComponentPlugin
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            super.onResume();
            as0 as0Var = this.d;
            if (as0Var != null) {
                as0Var.resume();
            }
        }
    }

    public final int v() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            return this.g;
        }
        return invokeV.intValue;
    }

    public final void D(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048579, this, i) == null) {
            this.g = i;
        }
    }

    @Override // com.baidu.nadcore.component.AbsComponentPlugin, com.baidu.nadcore.component.api.IComponentPlugin
    public void b(xi0 event) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, event) == null) {
            Intrinsics.checkNotNullParameter(event, "event");
            super.b(event);
            if (Intrinsics.areEqual(event.a(), mo0.class.getSimpleName())) {
                x((mo0) event);
            }
        }
    }

    @Override // com.baidu.nadcore.component.AbsComponentPlugin, com.baidu.nadcore.component.api.IComponentPlugin
    public void g(ViewGroup parent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, parent) == null) {
            Intrinsics.checkNotNullParameter(parent, "parent");
            parent.post(new c(this, parent));
        }
    }

    @Override // com.baidu.nadcore.component.AbsComponentPlugin, com.baidu.nadcore.component.api.IComponentPlugin
    public void onNewIntent(Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, intent) == null) {
            Intrinsics.checkNotNullParameter(intent, "intent");
            C(intent);
        }
    }

    public final void A(ViewGroup viewGroup) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048576, this, viewGroup) == null) && this.h == null) {
            this.h = new VideoViewHolder(getContext());
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
            layoutParams.height = this.g;
            layoutParams.gravity = 48;
            VideoViewHolder videoViewHolder = this.h;
            if (videoViewHolder != null) {
                videoViewHolder.setBackgroundResource(R.drawable.obfuscated_res_0x7f080e07);
                videoViewHolder.setEnableSlideLeft(true);
                videoViewHolder.setInterceptOnTouchListener(new a(this, viewGroup, layoutParams));
                viewGroup.addView(videoViewHolder, layoutParams);
            }
        }
    }

    public final void x(mo0 mo0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, mo0Var) == null) {
            int i = ep0.$EnumSwitchMapping$0[mo0Var.getType().ordinal()];
            if (i != 1) {
                if (i == 2) {
                    this.p = false;
                    as0 as0Var = this.d;
                    if (as0Var != null && !as0Var.isPause()) {
                        as0Var.pause();
                        return;
                    }
                    return;
                }
                return;
            }
            this.p = true;
            as0 as0Var2 = this.d;
            if (as0Var2 != null && !as0Var2.isPlaying()) {
                as0Var2.resume();
            }
        }
    }

    public final void B() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) != null) || this.d != null || this.f == null) {
            return;
        }
        bs0 bs0Var = new bs0();
        bs0Var.a = 0;
        this.d = as0.a.b(getContext(), 0, bs0Var);
        kz0 kz0Var = new kz0();
        kz0Var.k(false);
        kz0Var.l(true);
        kz0Var.p(false);
        kz0Var.q(false);
        kz0Var.j(2);
        kz0Var.n(this.j);
        kz0Var.m(true);
        kz0Var.o(false);
        this.e = new b(this);
        as0 as0Var = this.d;
        if (as0Var != null) {
            as0Var.d(kz0Var);
            as0Var.setVideoScalingMode(0);
            FrameLayout frameLayout = this.i;
            if (frameLayout != null) {
                as0Var.attachToContainer(frameLayout);
                zp0 zp0Var = this.f;
                if (zp0Var != null) {
                    as0Var.c(zp0Var);
                }
                as0Var.a(this.e);
                as0Var.start();
                return;
            }
            throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup");
        }
    }

    public final void C(Intent intent) {
        Object obj;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, intent) == null) {
            Serializable serializableExtra = intent.getSerializableExtra("map");
            String str = null;
            if (!(serializableExtra instanceof HashMap)) {
                serializableExtra = null;
            }
            HashMap hashMap = (HashMap) serializableExtra;
            if (hashMap != null) {
                this.f = zp0.c(hashMap);
                if (hashMap != null) {
                    obj = hashMap.get(WriteActivityConfig.VIDEO_INFO);
                } else {
                    obj = null;
                }
                if (obj instanceof String) {
                    str = obj;
                }
                String str2 = str;
                boolean z2 = false;
                if (str2 != null && str2.length() != 0) {
                    z = false;
                } else {
                    z = true;
                }
                if (z) {
                    return;
                }
                JSONObject jSONObject = new JSONObject(str2);
                this.k = Intrinsics.areEqual("1", jSONObject.optString("video_stretch_switch", "0"));
                this.l = jSONObject.optString("background_image");
                this.m = jSONObject.optDouble("top_margin_ratio", -1.0d);
                this.n = jSONObject.optDouble("video_aspect_ratio", 1.78d);
                if (jSONObject.optInt("restart_video") == 1) {
                    z2 = true;
                }
                this.j = z2;
            }
        }
    }

    public final void y() {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            String str = this.l;
            if (str != null && str.length() != 0) {
                z = false;
            } else {
                z = true;
            }
            if (z) {
                return;
            }
            AdImageView adImageView = new AdImageView(getContext());
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
            adImageView.setBackgroundResource(R.drawable.obfuscated_res_0x7f080e07);
            adImageView.g(this.l);
            adImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            adImageView.setLayoutParams(layoutParams);
            adImageView.setClickable(false);
            VideoViewHolder videoViewHolder = this.h;
            if (videoViewHolder != null) {
                videoViewHolder.addView(adImageView);
            }
        }
    }

    public final void z() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048591, this) == null) && this.i == null && this.h != null) {
            this.i = new FrameLayout(getContext());
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
            gp0.a.a(layoutParams, m31.c.e(getContext()), this.g, this.o, 1 / this.n, this.k, this.m);
            VideoViewHolder videoViewHolder = this.h;
            if (videoViewHolder != null) {
                videoViewHolder.addView(this.i, layoutParams);
            }
        }
    }
}
