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
import com.baidu.tieba.R;
import com.baidu.tieba.d82;
import com.baidu.tieba.s62;
import com.baidu.tieba.u62;
import com.baidu.tieba.w72;
import com.baidu.tieba.xz2;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.drawable.ScalingUtils;
import com.facebook.drawee.view.SimpleDraweeView;
import com.facebook.imagepipeline.common.ResizeOptions;
import com.facebook.imagepipeline.request.ImageRequestBuilder;
import java.io.File;
/* loaded from: classes4.dex */
public class VideoContainerManager extends s62<VideoHolderWrapper, xz2> {
    public Context i;
    public SwanAppComponentContainerView j;
    public VideoHolderWrapper k;

    /* loaded from: classes4.dex */
    public class VideoHolderWrapper extends FrameLayout {
        public FrameLayout a;
        public ImageView b;
        public SimpleDraweeView c;

        public VideoHolderWrapper(@NonNull Context context) {
            super(context);
            e();
            d();
            c();
        }

        public void a(String str, SimpleDraweeView simpleDraweeView) {
            Uri b = b(str);
            if (b == null) {
                simpleDraweeView.setController(null);
                return;
            }
            ImageRequestBuilder newBuilderWithSource = ImageRequestBuilder.newBuilderWithSource(b);
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
                if (!str.startsWith("/")) {
                    return null;
                }
                return Uri.fromFile(new File(str));
            }
            return Uri.parse(str);
        }

        public final void c() {
            ImageView imageView = new ImageView(VideoContainerManager.this.i);
            this.b = imageView;
            imageView.setImageResource(R.drawable.obfuscated_res_0x7f0814a4);
            this.b.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
            this.b.setBackgroundResource(R.drawable.obfuscated_res_0x7f08149a);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
            layoutParams.gravity = 17;
            addView(this.b, layoutParams);
        }

        public final void d() {
            this.c = new SimpleDraweeView(getContext());
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
            this.c.getHierarchy().setActualImageScaleType(ScalingUtils.ScaleType.CENTER_CROP);
            addView(this.c, layoutParams);
        }

        public final void e() {
            this.a = new FrameLayout(getContext());
            addView(this.a, new FrameLayout.LayoutParams(-1, -1));
        }

        public View getPlayerIcon() {
            return this.b;
        }

        public FrameLayout getVideoHolder() {
            return this.a;
        }

        public SimpleDraweeView getVideoPoster() {
            return this.c;
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
            char c = 65535;
            int hashCode = str2.hashCode();
            if (hashCode != 3143043) {
                if (hashCode != 94852023) {
                    if (hashCode == 951526612 && str2.equals("contain")) {
                        c = 0;
                    }
                } else if (str2.equals(AlaLiveRoomActivityConfig.SDK_LIVE_COVER_KEY)) {
                    c = 1;
                }
            } else if (str2.equals("fill")) {
                c = 2;
            }
            if (c != 0) {
                if (c != 1) {
                    if (c == 2) {
                        ScalingUtils.ScaleType scaleType2 = ScalingUtils.ScaleType.FIT_XY;
                    }
                } else {
                    ScalingUtils.ScaleType scaleType3 = ScalingUtils.ScaleType.CENTER_CROP;
                }
            } else {
                ScalingUtils.ScaleType scaleType4 = ScalingUtils.ScaleType.CENTER_INSIDE;
            }
            this.c.getHierarchy().setActualImageScaleType(ScalingUtils.ScaleType.CENTER_CROP);
            a(str, this.c);
        }
    }

    public VideoContainerManager(@NonNull Context context, @NonNull xz2 xz2Var) {
        super(context, xz2Var);
        this.i = context;
        SwanAppComponentContainerView swanAppComponentContainerView = new SwanAppComponentContainerView(this.i);
        this.j = swanAppComponentContainerView;
        swanAppComponentContainerView.setBackgroundColor(Color.parseColor("#666666"));
        g(1);
    }

    public void N(String str, String str2) {
        I().setPoster(str, str2);
        Q(I().getVideoPoster(), 0);
    }

    public final void Q(View view2, int i) {
        if (view2 != null && view2.getVisibility() != i) {
            view2.setVisibility(i);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.s62
    @NonNull
    /* renamed from: L */
    public VideoHolderWrapper v(@NonNull Context context) {
        return I();
    }

    public void M(View.OnClickListener onClickListener) {
        View playerIcon = I().getPlayerIcon();
        playerIcon.setOnClickListener(onClickListener);
        Q(playerIcon, 0);
    }

    public void O(xz2 xz2Var) {
        if (xz2Var == null) {
            return;
        }
        P(xz2Var);
    }

    @Override // com.baidu.tieba.s62
    @NonNull
    public SwanAppComponentContainerView u(@NonNull Context context) {
        return this.j;
    }

    public SwanAppComponentContainerView G() {
        return this.j;
    }

    public FrameLayout H() {
        return I().getVideoHolder();
    }

    public final VideoHolderWrapper I() {
        if (this.k == null) {
            this.k = new VideoHolderWrapper(this.i);
        }
        return this.k;
    }

    public void J() {
        Q(I().getPlayerIcon(), 8);
    }

    public void K() {
        Q(I().getVideoPoster(), 8);
    }

    public final void P(xz2 xz2Var) {
        boolean z;
        if (xz2Var == null) {
            return;
        }
        if (m() != null) {
            z = true;
        } else {
            z = false;
        }
        if (!z) {
            if (I().getParent() instanceof ViewGroup) {
                ((ViewGroup) I().getParent()).removeView(I());
            }
            G().setDescendantFocusability(393216);
            u62 insert = insert();
            d82.b("video", "Add CoverContainerWrapper " + insert.a() + " position " + xz2Var.h);
            return;
        }
        xz2 n = n();
        if (!TextUtils.equals(xz2Var.b, n.b) || !TextUtils.equals(xz2Var.c, n.c) || !TextUtils.equals(xz2Var.d, n.d)) {
            w72.a("video", "updateCoverContainerPosition with different id");
        }
        u62 update = update((VideoContainerManager) xz2Var);
        d82.b("video", "Update CoverContainerWrapper " + update.a() + " position " + xz2Var.h);
    }
}
