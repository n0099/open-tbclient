package com.baidu.nadcore.max.uicomponent;

import android.content.Intent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.baidu.nadcore.component.AbsComponentPlugin;
import com.baidu.nadcore.max.event.VideoEventTypeEnum;
import com.baidu.nadcore.max.uicomponent.VideoViewComponent$videoViewService$2;
import com.baidu.nadcore.max.uiwidget.basic.VideoViewHolder;
import com.baidu.nadcore.widget.AdImageView;
import com.baidu.searchbox.live.interfaces.DI;
import com.baidu.tbadk.core.atomData.WriteActivityConfig;
import com.baidu.tbadk.mutiprocess.mission.MissionEvent;
import com.baidu.tieba.R;
import com.baidu.tieba.c11;
import com.baidu.tieba.cl0;
import com.baidu.tieba.dl0;
import com.baidu.tieba.gp0;
import com.baidu.tieba.hp0;
import com.baidu.tieba.il0;
import com.baidu.tieba.iw0;
import com.baidu.tieba.kd0;
import com.baidu.tieba.kl0;
import com.baidu.tieba.kp0;
import com.baidu.tieba.ne0;
import com.baidu.tieba.ql0;
import com.baidu.tieba.sl0;
import com.baidu.tieba.sm0;
import com.baidu.tieba.yk0;
import java.io.Serializable;
import java.util.HashMap;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000~\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0006\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\bF\u0010\bJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\u0007\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\t\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\t\u0010\bJ\u0017\u0010\f\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\nH\u0002¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000e\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u000e\u0010\bJ\u000f\u0010\u000f\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u000f\u0010\bJ\u0017\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\u0010\u0010\rJ\u0017\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u0011H\u0016¢\u0006\u0004\b\u0013\u0010\u0014J\u000f\u0010\u0015\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0015\u0010\bJ\u000f\u0010\u0016\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0016\u0010\bJ\u000f\u0010\u0017\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0017\u0010\bJ\u0017\u0010\u0018\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u0011H\u0002¢\u0006\u0004\b\u0018\u0010\u0014J\u0017\u0010\u001a\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0019H\u0016¢\u0006\u0004\b\u001a\u0010\u001bR\u0018\u0010\u001d\u001a\u0004\u0018\u00010\u001c8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0016\u0010 \u001a\u00020\u001f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b \u0010!R\u0018\u0010#\u001a\u0004\u0018\u00010\"8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b#\u0010$R\u0016\u0010&\u001a\u00020%8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b&\u0010'R\u0018\u0010)\u001a\u0004\u0018\u00010(8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b)\u0010*R\u0016\u0010+\u001a\u00020\u001f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b+\u0010!R\u0016\u0010-\u001a\u00020,8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b-\u0010.R\u0016\u0010/\u001a\u00020,8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b/\u0010.R\"\u00100\u001a\u00020%8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b0\u0010'\u001a\u0004\b1\u00102\"\u0004\b3\u00104R\u0018\u00106\u001a\u0004\u0018\u0001058\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b6\u00107R\u0018\u00109\u001a\u0004\u0018\u0001088\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b9\u0010:R\u0016\u0010;\u001a\u00020,8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b;\u0010.R\u0018\u0010=\u001a\u0004\u0018\u00010<8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b=\u0010>R\u0016\u0010?\u001a\u00020\u001f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b?\u0010!R\u001d\u0010E\u001a\u00020@8B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\bA\u0010B\u001a\u0004\bC\u0010D¨\u0006G"}, d2 = {"Lcom/baidu/nadcore/max/uicomponent/VideoViewComponent;", "Lcom/baidu/nadcore/component/AbsComponentPlugin;", "Lcom/baidu/nadcore/max/event/NestedScrollEvent;", "event", "", "handleNestedScrollEvent", "(Lcom/baidu/nadcore/max/event/NestedScrollEvent;)V", "initBackgroundView", "()V", "initRealVideoHolder", "Landroid/view/ViewGroup;", "parent", "initVideoHolder", "(Landroid/view/ViewGroup;)V", "initVideoPlayer", "injectService", "onCreateView", "Landroid/content/Intent;", "intent", "onNewIntent", "(Landroid/content/Intent;)V", MissionEvent.MESSAGE_PAUSE, "onRelease", "onResume", "parseData", "Lcom/baidu/nadcore/component/api/IComponentEvent;", "receiveEvent", "(Lcom/baidu/nadcore/component/api/IComponentEvent;)V", "", "backgroundImage", "Ljava/lang/String;", "", "isVideoVisible", "Z", "Lcom/baidu/nadcore/player/Player;", DI.LIVE_PLAYER, "Lcom/baidu/nadcore/player/Player;", "", "playerLoopCount", "I", "Lcom/baidu/nadcore/player/SimplePlayerStatusCallback;", "playerStatusCallback", "Lcom/baidu/nadcore/player/SimplePlayerStatusCallback;", "replayVideo", "", "screenHW", "D", "topMarginRatio", "videoHeight", "getVideoHeight", "()I", "setVideoHeight", "(I)V", "Lcom/baidu/nadcore/max/uiwidget/basic/VideoViewHolder;", "videoHolder", "Lcom/baidu/nadcore/max/uiwidget/basic/VideoViewHolder;", "Lcom/baidu/nadcore/model/AdVideoInfo;", "videoInfo", "Lcom/baidu/nadcore/model/AdVideoInfo;", "videoRatio", "Landroid/widget/FrameLayout;", "videoRealHolder", "Landroid/widget/FrameLayout;", "videoStretchSwitch", "Lcom/baidu/nadcore/max/service/IVideoViewService;", "videoViewService$delegate", "Lkotlin/Lazy;", "getVideoViewService", "()Lcom/baidu/nadcore/max/service/IVideoViewService;", "videoViewService", "<init>", "nadcore-lib-business"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes3.dex */
public final class VideoViewComponent extends AbsComponentPlugin {
    public gp0 d;
    public kp0 e;
    public sm0 f;
    public int g;
    public VideoViewHolder h;
    public FrameLayout i;
    public boolean j;
    public boolean k;
    public String l;
    public double m;
    public double n;
    public double o;
    public boolean p = true;
    public int q = 1;
    public final Lazy r = LazyKt__LazyJVMKt.lazy(new Function0<VideoViewComponent$videoViewService$2.a>() { // from class: com.baidu.nadcore.max.uicomponent.VideoViewComponent$videoViewService$2
        {
            super(0);
        }

        /* loaded from: classes3.dex */
        public static final class a implements kl0 {
            /* JADX DEBUG: Incorrect args count in method signature: ()V */
            public a() {
            }

            @Override // com.baidu.tieba.kl0
            public int getVideoHeight() {
                return VideoViewComponent.this.E();
            }

            @Override // com.baidu.tieba.kl0
            public FrameLayout getVideoHolder() {
                VideoViewHolder videoViewHolder;
                videoViewHolder = VideoViewComponent.this.h;
                return videoViewHolder;
            }

            @Override // com.baidu.tieba.kl0
            public boolean j() {
                return VideoViewComponent.this.p;
            }

            @Override // com.baidu.tieba.kl0
            public int k() {
                return VideoViewComponent.this.q;
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final a invoke() {
            return new a();
        }
    });

    public final kl0 F() {
        return (kl0) this.r.getValue();
    }

    /* loaded from: classes3.dex */
    public static final class a implements VideoViewHolder.a {
        public final /* synthetic */ ViewGroup b;

        public a(ViewGroup viewGroup, FrameLayout.LayoutParams layoutParams) {
            this.b = viewGroup;
        }

        @Override // com.baidu.nadcore.max.uiwidget.basic.VideoViewHolder.a
        public void a() {
            VideoViewComponent.this.g().j(new dl0(VideoEventTypeEnum.LEFT_SLIDE_ON_VIDEO));
        }

        @Override // com.baidu.nadcore.max.uiwidget.basic.VideoViewHolder.a
        public void onClick() {
            il0 il0Var;
            if (!VideoViewComponent.this.p && (il0Var = (il0) VideoViewComponent.this.g().q(il0.class)) != null) {
                il0Var.i(true, true, false);
            }
        }

        @Override // com.baidu.nadcore.max.uiwidget.basic.VideoViewHolder.a
        public void onTouch(View v, MotionEvent event) {
            Intrinsics.checkNotNullParameter(v, "v");
            Intrinsics.checkNotNullParameter(event, "event");
            il0 il0Var = (il0) VideoViewComponent.this.g().q(il0.class);
            if (il0Var != null) {
                il0Var.h(event);
            }
        }
    }

    /* loaded from: classes3.dex */
    public static final class b extends kp0 {
        /* JADX DEBUG: Incorrect args count in method signature: ()V */
        public b() {
        }

        @Override // com.baidu.tieba.kp0, com.baidu.tieba.dp0
        public void onInfo(int i, int i2) {
            if (i != 904) {
                if (i == 955 || i == 956) {
                    VideoViewComponent.this.g().j(new dl0(VideoEventTypeEnum.PLAY_SEEK_TO_END));
                    VideoViewComponent.this.q++;
                    return;
                }
                return;
            }
            VideoViewComponent.this.g().j(new dl0(VideoEventTypeEnum.FIRST_FRAME_INTERVAL));
        }

        @Override // com.baidu.tieba.kp0, com.baidu.tieba.dp0
        public void onUpdateProgress(int i, int i2, int i3) {
            VideoViewComponent.this.g().j(new cl0(VideoEventTypeEnum.PLAY_INFO_PROCESS, i, i3));
        }
    }

    /* loaded from: classes3.dex */
    public static final class c implements Runnable {
        public final /* synthetic */ ViewGroup b;

        public c(ViewGroup viewGroup) {
            this.b = viewGroup;
        }

        @Override // java.lang.Runnable
        public final void run() {
            VideoViewComponent.this.O(this.b.getMeasuredHeight());
            VideoViewComponent.this.o = this.b.getMeasuredHeight() / this.b.getMeasuredWidth();
            VideoViewComponent.this.L(this.b);
            VideoViewComponent.this.I();
            VideoViewComponent.this.J();
            VideoViewComponent.this.M();
        }
    }

    public final int E() {
        return this.g;
    }

    @Override // com.baidu.nadcore.component.AbsComponentPlugin
    public void onPause() {
        super.onPause();
        gp0 gp0Var = this.d;
        if (gp0Var != null) {
            gp0Var.pause();
        }
    }

    @Override // com.baidu.nadcore.component.AbsComponentPlugin, com.baidu.nadcore.component.api.IComponentPlugin
    public void onRelease() {
        super.onRelease();
        gp0 gp0Var = this.d;
        if (gp0Var != null) {
            gp0Var.release();
        }
        this.d = null;
        kd0.g(this.h);
        VideoViewHolder videoViewHolder = this.h;
        if (videoViewHolder != null) {
            videoViewHolder.removeAllViews();
        }
        this.h = null;
        this.i = null;
        this.l = null;
    }

    @Override // com.baidu.nadcore.component.AbsComponentPlugin
    public void onResume() {
        super.onResume();
        gp0 gp0Var = this.d;
        if (gp0Var != null) {
            gp0Var.resume();
        }
    }

    @Override // com.baidu.nadcore.component.AbsComponentPlugin, com.baidu.nadcore.component.api.IComponentPlugin
    public void y() {
        super.y();
        g().w(kl0.class, F());
    }

    @Override // com.baidu.nadcore.component.AbsComponentPlugin, com.baidu.nadcore.component.api.IComponentPlugin
    public void K(ViewGroup parent) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        parent.post(new c(parent));
    }

    public final void O(int i) {
        this.g = i;
    }

    @Override // com.baidu.nadcore.component.AbsComponentPlugin, com.baidu.nadcore.component.api.IComponentPlugin
    public void onNewIntent(Intent intent) {
        Intrinsics.checkNotNullParameter(intent, "intent");
        N(intent);
    }

    @Override // com.baidu.nadcore.component.AbsComponentPlugin, com.baidu.nadcore.component.api.IComponentPlugin
    public void t(ne0 event) {
        Intrinsics.checkNotNullParameter(event, "event");
        super.t(event);
        if (Intrinsics.areEqual(event.a(), yk0.class.getSimpleName())) {
            H((yk0) event);
        }
    }

    public final void H(yk0 yk0Var) {
        int i = ql0.$EnumSwitchMapping$0[yk0Var.b().ordinal()];
        if (i != 1) {
            if (i == 2) {
                this.p = false;
                gp0 gp0Var = this.d;
                if (gp0Var != null && !gp0Var.isPause()) {
                    gp0Var.pause();
                    return;
                }
                return;
            }
            return;
        }
        this.p = true;
        gp0 gp0Var2 = this.d;
        if (gp0Var2 != null && !gp0Var2.isPlaying()) {
            gp0Var2.resume();
        }
    }

    public final void L(ViewGroup viewGroup) {
        if (this.h == null) {
            this.h = new VideoViewHolder(b());
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
            layoutParams.height = this.g;
            layoutParams.gravity = 48;
            VideoViewHolder videoViewHolder = this.h;
            if (videoViewHolder != null) {
                videoViewHolder.setBackgroundResource(R.drawable.nad_max_panel_bg);
                videoViewHolder.setEnableSlideLeft(true);
                videoViewHolder.setInterceptOnTouchListener(new a(viewGroup, layoutParams));
                viewGroup.addView(videoViewHolder, layoutParams);
            }
        }
    }

    public final void I() {
        boolean z;
        String str = this.l;
        if (str != null && str.length() != 0) {
            z = false;
        } else {
            z = true;
        }
        if (z) {
            return;
        }
        AdImageView adImageView = new AdImageView(b());
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        adImageView.setBackgroundResource(R.drawable.nad_max_panel_bg);
        adImageView.s(this.l);
        adImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        adImageView.setLayoutParams(layoutParams);
        adImageView.setClickable(false);
        VideoViewHolder videoViewHolder = this.h;
        if (videoViewHolder != null) {
            videoViewHolder.addView(adImageView);
        }
    }

    public final void J() {
        if (this.i == null && this.h != null) {
            this.i = new FrameLayout(b());
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
            sl0.a.a(layoutParams, c11.c.e(b()), this.g, this.o, 1 / this.n, this.k, this.m);
            VideoViewHolder videoViewHolder = this.h;
            if (videoViewHolder != null) {
                videoViewHolder.addView(this.i, layoutParams);
            }
        }
    }

    public final void M() {
        if (this.d != null || this.f == null) {
            return;
        }
        hp0 hp0Var = new hp0();
        hp0Var.a = 0;
        this.d = gp0.a.a(b(), 0, hp0Var);
        iw0 iw0Var = new iw0();
        iw0Var.k(false);
        iw0Var.l(true);
        iw0Var.p(false);
        iw0Var.q(false);
        iw0Var.j(2);
        iw0Var.n(this.j);
        iw0Var.m(true);
        iw0Var.o(false);
        this.e = new b();
        gp0 gp0Var = this.d;
        if (gp0Var != null) {
            gp0Var.d(iw0Var);
            gp0Var.setVideoScalingMode(0);
            FrameLayout frameLayout = this.i;
            if (frameLayout != null) {
                gp0Var.attachToContainer(frameLayout);
                sm0 sm0Var = this.f;
                if (sm0Var != null) {
                    gp0Var.c(sm0Var);
                }
                gp0Var.a(this.e);
                gp0Var.start();
                return;
            }
            throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup");
        }
    }

    public final void N(Intent intent) {
        Object obj;
        boolean z;
        Serializable serializableExtra = intent.getSerializableExtra("map");
        String str = null;
        if (!(serializableExtra instanceof HashMap)) {
            serializableExtra = null;
        }
        HashMap hashMap = (HashMap) serializableExtra;
        if (hashMap != null) {
            this.f = sm0.c(hashMap);
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
