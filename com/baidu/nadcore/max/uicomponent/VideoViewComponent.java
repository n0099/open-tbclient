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
import com.baidu.tieba.aq0;
import com.baidu.tieba.du0;
import com.baidu.tieba.eu0;
import com.baidu.tieba.fq0;
import com.baidu.tieba.h61;
import com.baidu.tieba.hq0;
import com.baidu.tieba.hu0;
import com.baidu.tieba.ki0;
import com.baidu.tieba.n11;
import com.baidu.tieba.nj0;
import com.baidu.tieba.nq0;
import com.baidu.tieba.pq0;
import com.baidu.tieba.pr0;
import com.baidu.tieba.vp0;
import com.baidu.tieba.zp0;
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
    public du0 d;
    public hu0 e;
    public pr0 f;
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
        public static final class a implements hq0 {
            /* JADX DEBUG: Incorrect args count in method signature: ()V */
            public a() {
            }

            @Override // com.baidu.tieba.hq0
            public int getVideoHeight() {
                return VideoViewComponent.this.C();
            }

            @Override // com.baidu.tieba.hq0
            public FrameLayout getVideoHolder() {
                VideoViewHolder videoViewHolder;
                videoViewHolder = VideoViewComponent.this.h;
                return videoViewHolder;
            }

            @Override // com.baidu.tieba.hq0
            public boolean j() {
                return VideoViewComponent.this.p;
            }

            @Override // com.baidu.tieba.hq0
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

    public final hq0 D() {
        return (hq0) this.r.getValue();
    }

    /* loaded from: classes3.dex */
    public static final class a implements VideoViewHolder.a {
        public final /* synthetic */ ViewGroup b;

        public a(ViewGroup viewGroup, FrameLayout.LayoutParams layoutParams) {
            this.b = viewGroup;
        }

        @Override // com.baidu.nadcore.max.uiwidget.basic.VideoViewHolder.a
        public void a() {
            VideoViewComponent.this.d().j(new aq0(VideoEventTypeEnum.LEFT_SLIDE_ON_VIDEO));
        }

        @Override // com.baidu.nadcore.max.uiwidget.basic.VideoViewHolder.a
        public void onClick() {
            fq0 fq0Var;
            if (!VideoViewComponent.this.p && (fq0Var = (fq0) VideoViewComponent.this.d().r(fq0.class)) != null) {
                fq0Var.i(true, true, false);
            }
        }

        @Override // com.baidu.nadcore.max.uiwidget.basic.VideoViewHolder.a
        public void onTouch(View v, MotionEvent event) {
            Intrinsics.checkNotNullParameter(v, "v");
            Intrinsics.checkNotNullParameter(event, "event");
            fq0 fq0Var = (fq0) VideoViewComponent.this.d().r(fq0.class);
            if (fq0Var != null) {
                fq0Var.h(event);
            }
        }
    }

    /* loaded from: classes3.dex */
    public static final class b extends hu0 {
        /* JADX DEBUG: Incorrect args count in method signature: ()V */
        public b() {
        }

        @Override // com.baidu.tieba.hu0, com.baidu.tieba.au0
        public void onInfo(int i, int i2) {
            if (i != 904) {
                if (i == 955 || i == 956) {
                    VideoViewComponent.this.d().j(new aq0(VideoEventTypeEnum.PLAY_SEEK_TO_END));
                    VideoViewComponent.this.q++;
                    return;
                }
                return;
            }
            VideoViewComponent.this.d().j(new aq0(VideoEventTypeEnum.FIRST_FRAME_INTERVAL));
        }

        @Override // com.baidu.tieba.hu0, com.baidu.tieba.au0
        public void onUpdateProgress(int i, int i2, int i3) {
            VideoViewComponent.this.d().j(new zp0(VideoEventTypeEnum.PLAY_INFO_PROCESS, i, i3));
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
            VideoViewComponent.this.N(this.b.getMeasuredHeight());
            VideoViewComponent.this.o = this.b.getMeasuredHeight() / this.b.getMeasuredWidth();
            VideoViewComponent.this.J(this.b);
            VideoViewComponent.this.H();
            VideoViewComponent.this.I();
            VideoViewComponent.this.L();
        }
    }

    public final int C() {
        return this.g;
    }

    @Override // com.baidu.nadcore.component.AbsComponentPlugin
    public void onPause() {
        super.onPause();
        du0 du0Var = this.d;
        if (du0Var != null) {
            du0Var.pause();
        }
    }

    @Override // com.baidu.nadcore.component.AbsComponentPlugin, com.baidu.nadcore.component.api.IComponentPlugin
    public void onRelease() {
        super.onRelease();
        du0 du0Var = this.d;
        if (du0Var != null) {
            du0Var.release();
        }
        this.d = null;
        ki0.g(this.h);
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
        du0 du0Var = this.d;
        if (du0Var != null) {
            du0Var.resume();
        }
    }

    @Override // com.baidu.nadcore.component.AbsComponentPlugin, com.baidu.nadcore.component.api.IComponentPlugin
    public void y() {
        super.y();
        d().w(hq0.class, D());
    }

    @Override // com.baidu.nadcore.component.AbsComponentPlugin, com.baidu.nadcore.component.api.IComponentPlugin
    public void K(ViewGroup parent) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        parent.post(new c(parent));
    }

    public final void N(int i) {
        this.g = i;
    }

    @Override // com.baidu.nadcore.component.AbsComponentPlugin, com.baidu.nadcore.component.api.IComponentPlugin
    public void onNewIntent(Intent intent) {
        Intrinsics.checkNotNullParameter(intent, "intent");
        M(intent);
    }

    @Override // com.baidu.nadcore.component.AbsComponentPlugin, com.baidu.nadcore.component.api.IComponentPlugin
    public void t(nj0 event) {
        Intrinsics.checkNotNullParameter(event, "event");
        super.t(event);
        if (Intrinsics.areEqual(event.a(), vp0.class.getSimpleName())) {
            E((vp0) event);
        }
    }

    public final void E(vp0 vp0Var) {
        int i = nq0.$EnumSwitchMapping$0[vp0Var.getType().ordinal()];
        if (i != 1) {
            if (i == 2) {
                this.p = false;
                du0 du0Var = this.d;
                if (du0Var != null && !du0Var.isPause()) {
                    du0Var.pause();
                    return;
                }
                return;
            }
            return;
        }
        this.p = true;
        du0 du0Var2 = this.d;
        if (du0Var2 != null && !du0Var2.isPlaying()) {
            du0Var2.resume();
        }
    }

    public final void J(ViewGroup viewGroup) {
        if (this.h == null) {
            this.h = new VideoViewHolder(getContext());
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

    public final void H() {
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
        AdImageView adImageView = new AdImageView(getContext());
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        adImageView.setBackgroundResource(R.drawable.nad_max_panel_bg);
        adImageView.b(this.l);
        adImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        adImageView.setLayoutParams(layoutParams);
        adImageView.setClickable(false);
        VideoViewHolder videoViewHolder = this.h;
        if (videoViewHolder != null) {
            videoViewHolder.addView(adImageView);
        }
    }

    public final void I() {
        if (this.i == null && this.h != null) {
            this.i = new FrameLayout(getContext());
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
            pq0.a.a(layoutParams, h61.c.e(getContext()), this.g, this.o, 1 / this.n, this.k, this.m);
            VideoViewHolder videoViewHolder = this.h;
            if (videoViewHolder != null) {
                videoViewHolder.addView(this.i, layoutParams);
            }
        }
    }

    public final void L() {
        if (this.d != null || this.f == null) {
            return;
        }
        eu0 eu0Var = new eu0();
        eu0Var.a = 0;
        this.d = du0.a.b(getContext(), 0, eu0Var);
        n11 n11Var = new n11();
        n11Var.k(false);
        n11Var.l(true);
        n11Var.p(false);
        n11Var.q(false);
        n11Var.j(2);
        n11Var.n(this.j);
        n11Var.m(true);
        n11Var.o(false);
        this.e = new b();
        du0 du0Var = this.d;
        if (du0Var != null) {
            du0Var.d(n11Var);
            du0Var.setVideoScalingMode(0);
            FrameLayout frameLayout = this.i;
            if (frameLayout != null) {
                du0Var.attachToContainer(frameLayout);
                pr0 pr0Var = this.f;
                if (pr0Var != null) {
                    du0Var.c(pr0Var);
                }
                du0Var.a(this.e);
                du0Var.start();
                return;
            }
            throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup");
        }
    }

    public final void M(Intent intent) {
        Object obj;
        boolean z;
        Serializable serializableExtra = intent.getSerializableExtra("map");
        String str = null;
        if (!(serializableExtra instanceof HashMap)) {
            serializableExtra = null;
        }
        HashMap hashMap = (HashMap) serializableExtra;
        if (hashMap != null) {
            this.f = pr0.c(hashMap);
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
