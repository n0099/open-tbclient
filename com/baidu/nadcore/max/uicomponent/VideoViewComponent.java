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
import com.baidu.searchbox.live.interfaces.DI;
import com.baidu.tbadk.core.atomData.TbPreviewVideoActivityConfig;
import com.baidu.tbadk.core.atomData.WriteActivityConfig;
import com.baidu.tbadk.mutiprocess.mission.MissionEvent;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.dm0;
import com.repackage.eg0;
import com.repackage.em0;
import com.repackage.fh0;
import com.repackage.jm0;
import com.repackage.jp0;
import com.repackage.kp0;
import com.repackage.lm0;
import com.repackage.mn0;
import com.repackage.np0;
import com.repackage.q01;
import com.repackage.rm0;
import com.repackage.tm0;
import com.repackage.tw0;
import com.repackage.zl0;
import java.io.Serializable;
import java.util.HashMap;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000~\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0006\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\bF\u0010\bJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\u0007\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\t\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\t\u0010\bJ\u0017\u0010\f\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\nH\u0002¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000e\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u000e\u0010\bJ\u000f\u0010\u000f\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u000f\u0010\bJ\u0017\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\u0010\u0010\rJ\u0017\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u0011H\u0016¢\u0006\u0004\b\u0013\u0010\u0014J\u000f\u0010\u0015\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0015\u0010\bJ\u000f\u0010\u0016\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0016\u0010\bJ\u000f\u0010\u0017\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0017\u0010\bJ\u0017\u0010\u0018\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u0011H\u0002¢\u0006\u0004\b\u0018\u0010\u0014J\u0017\u0010\u001a\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0019H\u0016¢\u0006\u0004\b\u001a\u0010\u001bR\u0018\u0010\u001d\u001a\u0004\u0018\u00010\u001c8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0016\u0010 \u001a\u00020\u001f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b \u0010!R\u0018\u0010#\u001a\u0004\u0018\u00010\"8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b#\u0010$R\u0016\u0010&\u001a\u00020%8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b&\u0010'R\u0018\u0010)\u001a\u0004\u0018\u00010(8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b)\u0010*R\u0016\u0010+\u001a\u00020\u001f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b+\u0010!R\u0016\u0010-\u001a\u00020,8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b-\u0010.R\u0016\u0010/\u001a\u00020,8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b/\u0010.R\"\u00100\u001a\u00020%8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b0\u0010'\u001a\u0004\b1\u00102\"\u0004\b3\u00104R\u0018\u00106\u001a\u0004\u0018\u0001058\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b6\u00107R\u0018\u00109\u001a\u0004\u0018\u0001088\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b9\u0010:R\u0016\u0010;\u001a\u00020,8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b;\u0010.R\u0018\u0010=\u001a\u0004\u0018\u00010<8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b=\u0010>R\u0016\u0010?\u001a\u00020\u001f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b?\u0010!R\u001d\u0010E\u001a\u00020@8B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\bA\u0010B\u001a\u0004\bC\u0010D¨\u0006G"}, d2 = {"Lcom/baidu/nadcore/max/uicomponent/VideoViewComponent;", "Lcom/baidu/nadcore/component/AbsComponentPlugin;", "Lcom/baidu/nadcore/max/event/NestedScrollEvent;", "event", "", "handleNestedScrollEvent", "(Lcom/baidu/nadcore/max/event/NestedScrollEvent;)V", "initBackgroundView", "()V", "initRealVideoHolder", "Landroid/view/ViewGroup;", "parent", "initVideoHolder", "(Landroid/view/ViewGroup;)V", "initVideoPlayer", "injectService", "onCreateView", "Landroid/content/Intent;", "intent", "onNewIntent", "(Landroid/content/Intent;)V", MissionEvent.MESSAGE_PAUSE, "onRelease", "onResume", "parseData", "Lcom/baidu/nadcore/component/api/IComponentEvent;", "receiveEvent", "(Lcom/baidu/nadcore/component/api/IComponentEvent;)V", "", "backgroundImage", "Ljava/lang/String;", "", "isVideoVisible", "Z", "Lcom/baidu/nadcore/player/Player;", DI.LIVE_PLAYER, "Lcom/baidu/nadcore/player/Player;", "", "playerLoopCount", "I", "Lcom/baidu/nadcore/player/SimplePlayerStatusCallback;", "playerStatusCallback", "Lcom/baidu/nadcore/player/SimplePlayerStatusCallback;", "replayVideo", "", "screenHW", "D", "topMarginRatio", "videoHeight", "getVideoHeight", "()I", "setVideoHeight", "(I)V", "Lcom/baidu/nadcore/max/uiwidget/basic/VideoViewHolder;", "videoHolder", "Lcom/baidu/nadcore/max/uiwidget/basic/VideoViewHolder;", "Lcom/baidu/nadcore/model/AdVideoInfo;", TbPreviewVideoActivityConfig.KEY_VIDEO_INFO, "Lcom/baidu/nadcore/model/AdVideoInfo;", "videoRatio", "Landroid/widget/FrameLayout;", "videoRealHolder", "Landroid/widget/FrameLayout;", "videoStretchSwitch", "Lcom/baidu/nadcore/max/service/IVideoViewService;", "videoViewService$delegate", "Lkotlin/Lazy;", "getVideoViewService", "()Lcom/baidu/nadcore/max/service/IVideoViewService;", "videoViewService", "<init>", "nadcore-lib-business"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes2.dex */
public final class VideoViewComponent extends AbsComponentPlugin {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public jp0 d;
    public np0 e;
    public mn0 f;
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
                this.a.l().l(new em0(VideoEventTypeEnum.LEFT_SLIDE_ON_VIDEO));
            }
        }

        @Override // com.baidu.nadcore.max.uiwidget.basic.VideoViewHolder.a
        public void onClick() {
            jm0 jm0Var;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || this.a.p || (jm0Var = (jm0) this.a.l().q(jm0.class)) == null) {
                return;
            }
            jm0Var.j(true, true, false);
        }

        @Override // com.baidu.nadcore.max.uiwidget.basic.VideoViewHolder.a
        public void onTouch(View v, MotionEvent event) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, v, event) == null) {
                Intrinsics.checkNotNullParameter(v, "v");
                Intrinsics.checkNotNullParameter(event, "event");
                jm0 jm0Var = (jm0) this.a.l().q(jm0.class);
                if (jm0Var != null) {
                    jm0Var.i(event);
                }
            }
        }
    }

    /* loaded from: classes2.dex */
    public static final class b extends np0 {
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

        @Override // com.repackage.np0, com.repackage.gp0
        public void onInfo(int i, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeII(1048576, this, i, i2) == null) {
                if (i == 904) {
                    this.a.l().l(new em0(VideoEventTypeEnum.FIRST_FRAME_INTERVAL));
                } else if (i == 955 || i == 956) {
                    this.a.l().l(new em0(VideoEventTypeEnum.PLAY_SEEK_TO_END));
                    this.a.q++;
                }
            }
        }

        @Override // com.repackage.np0, com.repackage.gp0
        public void onUpdateProgress(int i, int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, i2, i3) == null) {
                this.a.l().l(new dm0(VideoEventTypeEnum.PLAY_INFO_PROCESS, i, i3));
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
                this.a.E(this.b.getMeasuredHeight());
                this.a.o = this.b.getMeasuredHeight() / this.b.getMeasuredWidth();
                this.a.B(this.b);
                this.a.z();
                this.a.A();
                this.a.C();
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

    public final void A() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.i == null && this.h != null) {
            this.i = new FrameLayout(getContext());
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
            tm0.a.a(layoutParams, q01.c.e(getContext()), this.g, this.o, 1 / this.n, this.k, this.m);
            VideoViewHolder videoViewHolder = this.h;
            if (videoViewHolder != null) {
                videoViewHolder.addView(this.i, layoutParams);
            }
        }
    }

    public final void B(ViewGroup viewGroup) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, viewGroup) == null) && this.h == null) {
            this.h = new VideoViewHolder(getContext());
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
            layoutParams.height = this.g;
            layoutParams.gravity = 48;
            VideoViewHolder videoViewHolder = this.h;
            if (videoViewHolder != null) {
                videoViewHolder.setBackgroundResource(R.drawable.obfuscated_res_0x7f080d5b);
                videoViewHolder.setEnableSlideLeft(true);
                videoViewHolder.setInterceptOnTouchListener(new a(this, viewGroup, layoutParams));
                viewGroup.addView(videoViewHolder, layoutParams);
            }
        }
    }

    public final void C() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) && this.d == null && this.f != null) {
            kp0 kp0Var = new kp0();
            kp0Var.a = 0;
            this.d = jp0.a.b(getContext(), 0, kp0Var);
            tw0 tw0Var = new tw0();
            tw0Var.k(false);
            tw0Var.l(true);
            tw0Var.p(false);
            tw0Var.q(false);
            tw0Var.j(2);
            tw0Var.n(this.j);
            tw0Var.m(true);
            tw0Var.o(false);
            this.e = new b(this);
            jp0 jp0Var = this.d;
            if (jp0Var != null) {
                jp0Var.d(tw0Var);
                jp0Var.setVideoScalingMode(0);
                FrameLayout frameLayout = this.i;
                if (frameLayout != null) {
                    jp0Var.attachToContainer(frameLayout);
                    mn0 mn0Var = this.f;
                    if (mn0Var != null) {
                        jp0Var.c(mn0Var);
                    }
                    jp0Var.a(this.e);
                    jp0Var.start();
                    return;
                }
                throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup");
            }
        }
    }

    public final void D(Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, intent) == null) {
            Serializable serializableExtra = intent.getSerializableExtra("map");
            if (!(serializableExtra instanceof HashMap)) {
                serializableExtra = null;
            }
            HashMap hashMap = (HashMap) serializableExtra;
            if (hashMap != null) {
                this.f = mn0.c(hashMap);
                Object obj = hashMap != null ? hashMap.get(WriteActivityConfig.VIDEO_INFO) : null;
                String str = obj instanceof String ? obj : null;
                if (str == null || str.length() == 0) {
                    return;
                }
                JSONObject jSONObject = new JSONObject(str);
                this.k = Intrinsics.areEqual("1", jSONObject.optString("video_stretch_switch", "0"));
                this.l = jSONObject.optString("background_image");
                this.m = jSONObject.optDouble("top_margin_ratio", -1.0d);
                this.n = jSONObject.optDouble("video_aspect_ratio", 1.78d);
                this.j = jSONObject.optInt("restart_video") == 1;
            }
        }
    }

    public final void E(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048580, this, i) == null) {
            this.g = i;
        }
    }

    @Override // com.baidu.nadcore.component.AbsComponentPlugin, com.baidu.nadcore.component.api.IComponentPlugin
    public void b(Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, intent) == null) {
            Intrinsics.checkNotNullParameter(intent, "intent");
            D(intent);
        }
    }

    @Override // com.baidu.nadcore.component.AbsComponentPlugin, com.baidu.nadcore.component.api.IComponentPlugin
    public void c(fh0 event) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, event) == null) {
            Intrinsics.checkNotNullParameter(event, "event");
            super.c(event);
            if (Intrinsics.areEqual(event.a(), zl0.class.getSimpleName())) {
                y((zl0) event);
            }
        }
    }

    @Override // com.baidu.nadcore.component.AbsComponentPlugin, com.baidu.nadcore.component.api.IComponentPlugin
    public void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            super.f();
            l().t(lm0.class, x());
        }
    }

    @Override // com.baidu.nadcore.component.AbsComponentPlugin, com.baidu.nadcore.component.api.IComponentPlugin
    public void i(ViewGroup parent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, parent) == null) {
            Intrinsics.checkNotNullParameter(parent, "parent");
            parent.post(new c(this, parent));
        }
    }

    @Override // com.baidu.nadcore.component.AbsComponentPlugin
    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            super.onPause();
            jp0 jp0Var = this.d;
            if (jp0Var != null) {
                jp0Var.pause();
            }
        }
    }

    @Override // com.baidu.nadcore.component.AbsComponentPlugin, com.baidu.nadcore.component.api.IComponentPlugin
    public void onRelease() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            super.onRelease();
            jp0 jp0Var = this.d;
            if (jp0Var != null) {
                jp0Var.release();
            }
            this.d = null;
            eg0.f(this.h);
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
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            super.onResume();
            jp0 jp0Var = this.d;
            if (jp0Var != null) {
                jp0Var.resume();
            }
        }
    }

    public final int w() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.g : invokeV.intValue;
    }

    public final lm0 x() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? (lm0) this.r.getValue() : (lm0) invokeV.objValue;
    }

    public final void y(zl0 zl0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, zl0Var) == null) {
            int i = rm0.$EnumSwitchMapping$0[zl0Var.getType().ordinal()];
            if (i == 1) {
                this.p = true;
                jp0 jp0Var = this.d;
                if (jp0Var == null || jp0Var.isPlaying()) {
                    return;
                }
                jp0Var.resume();
            } else if (i != 2) {
            } else {
                this.p = false;
                jp0 jp0Var2 = this.d;
                if (jp0Var2 == null || jp0Var2.isPause()) {
                    return;
                }
                jp0Var2.pause();
            }
        }
    }

    public final void z() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            String str = this.l;
            if (str == null || str.length() == 0) {
                return;
            }
            AdImageView adImageView = new AdImageView(getContext());
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
            adImageView.setBackgroundResource(R.drawable.obfuscated_res_0x7f080d5b);
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
}
