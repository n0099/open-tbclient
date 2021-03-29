package com.baidu.swan.videoplayer.media.video;

import android.content.Context;
import android.graphics.Color;
import android.net.Uri;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import com.baidu.swan.apps.component.container.view.SwanAppComponentContainerView;
import com.baidu.tbadk.core.atomData.AlaLiveRoomActivityConfig;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.drawable.ScalingUtils;
import com.facebook.drawee.view.SimpleDraweeView;
import com.facebook.imagepipeline.common.ResizeOptions;
import com.facebook.imagepipeline.request.ImageRequestBuilder;
import d.b.g0.a.a0.b.a;
import d.b.g0.a.b1.g.c;
import java.io.File;
/* loaded from: classes3.dex */
public class VideoContainerManager extends a<VideoHolderWrapper, c> {
    public Context i;
    public SwanAppComponentContainerView j;
    public VideoHolderWrapper k;

    /* loaded from: classes3.dex */
    public class VideoHolderWrapper extends FrameLayout {

        /* renamed from: e  reason: collision with root package name */
        public FrameLayout f13069e;

        /* renamed from: f  reason: collision with root package name */
        public ImageView f13070f;

        /* renamed from: g  reason: collision with root package name */
        public SimpleDraweeView f13071g;

        public VideoHolderWrapper(@NonNull Context context) {
            super(context);
            e();
            d();
            c();
        }

        public void a(String str, SimpleDraweeView simpleDraweeView) {
            Uri b2 = b(str);
            if (b2 == null) {
                simpleDraweeView.setController(null);
                return;
            }
            ImageRequestBuilder newBuilderWithSource = ImageRequestBuilder.newBuilderWithSource(b2);
            int measuredWidth = simpleDraweeView.getMeasuredWidth() / 2;
            int measuredHeight = simpleDraweeView.getMeasuredHeight() / 2;
            if (measuredWidth > 0 && measuredHeight > 0) {
                newBuilderWithSource.setResizeOptions(new ResizeOptions(measuredWidth, measuredHeight));
            }
            simpleDraweeView.setController(Fresco.newDraweeControllerBuilder().setOldController(simpleDraweeView.getController()).setImageRequest(newBuilderWithSource.build()).build());
        }

        public Uri b(String str) {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            if (!str.startsWith("http://") && !str.startsWith("https://") && !str.startsWith("file://")) {
                if (str.startsWith("/")) {
                    return Uri.fromFile(new File(str));
                }
                return null;
            }
            return Uri.parse(str);
        }

        public final void c() {
            ImageView imageView = new ImageView(VideoContainerManager.this.i);
            this.f13070f = imageView;
            imageView.setImageResource(d.b.g0.s.c.btn_play);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
            layoutParams.gravity = 17;
            addView(this.f13070f, layoutParams);
        }

        public final void d() {
            this.f13071g = new SimpleDraweeView(getContext());
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
            this.f13071g.getHierarchy().setActualImageScaleType(ScalingUtils.ScaleType.CENTER_CROP);
            addView(this.f13071g, layoutParams);
        }

        public final void e() {
            this.f13069e = new FrameLayout(getContext());
            addView(this.f13069e, new FrameLayout.LayoutParams(-1, -1));
        }

        public View getPlayerIcon() {
            return this.f13070f;
        }

        public FrameLayout getVideoHolder() {
            return this.f13069e;
        }

        public SimpleDraweeView getVideoPoster() {
            return this.f13071g;
        }

        public void setPoster(String str) {
            setPoster(str, AlaLiveRoomActivityConfig.SDK_LIVE_COVER_KEY);
        }

        public void setPoster(String str, String str2) {
            if (TextUtils.isEmpty(str)) {
                return;
            }
            if (TextUtils.isEmpty(str2)) {
                str2 = AlaLiveRoomActivityConfig.SDK_LIVE_COVER_KEY;
            }
            ScalingUtils.ScaleType scaleType = ScalingUtils.ScaleType.CENTER_CROP;
            char c2 = 65535;
            int hashCode = str2.hashCode();
            if (hashCode != 3143043) {
                if (hashCode != 94852023) {
                    if (hashCode == 951526612 && str2.equals("contain")) {
                        c2 = 0;
                    }
                } else if (str2.equals(AlaLiveRoomActivityConfig.SDK_LIVE_COVER_KEY)) {
                    c2 = 1;
                }
            } else if (str2.equals("fill")) {
                c2 = 2;
            }
            if (c2 == 0) {
                ScalingUtils.ScaleType scaleType2 = ScalingUtils.ScaleType.CENTER_INSIDE;
            } else if (c2 == 1) {
                ScalingUtils.ScaleType scaleType3 = ScalingUtils.ScaleType.CENTER_CROP;
            } else if (c2 == 2) {
                ScalingUtils.ScaleType scaleType4 = ScalingUtils.ScaleType.FIT_XY;
            }
            this.f13071g.getHierarchy().setActualImageScaleType(ScalingUtils.ScaleType.CENTER_CROP);
            a(str, this.f13071g);
        }
    }

    public VideoContainerManager(@NonNull Context context, @NonNull c cVar) {
        super(context, cVar);
        this.i = context;
        SwanAppComponentContainerView swanAppComponentContainerView = new SwanAppComponentContainerView(this.i);
        this.j = swanAppComponentContainerView;
        swanAppComponentContainerView.setBackgroundColor(Color.parseColor("#666666"));
        g(1);
    }

    public SwanAppComponentContainerView I() {
        return this.j;
    }

    public FrameLayout J() {
        return K().getVideoHolder();
    }

    public final VideoHolderWrapper K() {
        if (this.k == null) {
            this.k = new VideoHolderWrapper(this.i);
        }
        return this.k;
    }

    public void L() {
        S(K().getPlayerIcon(), 8);
    }

    public void M() {
        S(K().getVideoPoster(), 8);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.b.g0.a.a0.b.a
    @NonNull
    /* renamed from: N */
    public VideoHolderWrapper v(@NonNull Context context) {
        return K();
    }

    public void O(View.OnClickListener onClickListener) {
        View playerIcon = K().getPlayerIcon();
        playerIcon.setOnClickListener(onClickListener);
        S(playerIcon, 0);
    }

    public void P(String str, String str2) {
        K().setPoster(str, str2);
        S(K().getVideoPoster(), 0);
    }

    public void Q(c cVar) {
        if (cVar == null) {
            return;
        }
        R(cVar);
    }

    public final void R(c cVar) {
        if (cVar == null) {
            return;
        }
        if (!(m() != null)) {
            if (K().getParent() instanceof ViewGroup) {
                ((ViewGroup) K().getParent()).removeView(K());
            }
            I().setDescendantFocusability(393216);
            d.b.g0.a.a0.b.c w = w();
            d.b.g0.a.c0.c.a("video", "Add CoverContainerWrapper " + w.a() + " position " + cVar.l);
            return;
        }
        c n = n();
        if (!TextUtils.equals(cVar.f43113f, n.f43113f) || !TextUtils.equals(cVar.f43114g, n.f43114g) || !TextUtils.equals(cVar.f43115h, n.f43115h)) {
            d.b.g0.a.a0.g.a.a("video", "updateCoverContainerPosition with different id");
        }
        d.b.g0.a.a0.b.c G = G(cVar);
        d.b.g0.a.c0.c.a("video", "Update CoverContainerWrapper " + G.a() + " position " + cVar.l);
    }

    public final void S(View view, int i) {
        if (view == null || view.getVisibility() == i) {
            return;
        }
        view.setVisibility(i);
    }

    @Override // d.b.g0.a.a0.b.a
    @NonNull
    public SwanAppComponentContainerView u(@NonNull Context context) {
        return this.j;
    }
}
