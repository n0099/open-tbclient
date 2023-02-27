package com.baidu.nadcore.video.videoplayer.ui;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Shader;
import android.util.AttributeSet;
import android.view.View;
import com.baidu.tieba.R;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u001b\u0012\u0006\u0010\u0013\u001a\u00020\u0012\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0014¢\u0006\u0004\b\u0016\u0010\u0017J\u0019\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0014¢\u0006\u0004\b\u0005\u0010\u0006R\u001d\u0010\f\u001a\u00020\u00078B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u001d\u0010\u0011\u001a\u00020\r8B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000e\u0010\t\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u0018"}, d2 = {"Lcom/baidu/nadcore/video/videoplayer/ui/BdVideoGradientMask;", "Landroid/view/View;", "Landroid/graphics/Canvas;", "canvas", "", "onDraw", "(Landroid/graphics/Canvas;)V", "Landroid/graphics/LinearGradient;", "linearGradient$delegate", "Lkotlin/Lazy;", "getLinearGradient", "()Landroid/graphics/LinearGradient;", "linearGradient", "Landroid/graphics/Paint;", "paint$delegate", "getPaint", "()Landroid/graphics/Paint;", "paint", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "nadcore-lib-widget"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes2.dex */
public final class BdVideoGradientMask extends View {
    public final Lazy a;
    public final Lazy b;

    private final LinearGradient getLinearGradient() {
        return (LinearGradient) this.b.getValue();
    }

    private final Paint getPaint() {
        return (Paint) this.a.getValue();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BdVideoGradientMask(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        this.a = LazyKt__LazyJVMKt.lazy(new Function0<Paint>() { // from class: com.baidu.nadcore.video.videoplayer.ui.BdVideoGradientMask$paint$2
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Paint invoke() {
                return new Paint();
            }
        });
        this.b = LazyKt__LazyJVMKt.lazy(new Function0<LinearGradient>() { // from class: com.baidu.nadcore.video.videoplayer.ui.BdVideoGradientMask$linearGradient$2
            {
                super(0);
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final LinearGradient invoke() {
                return new LinearGradient(0.0f, 0.0f, BdVideoGradientMask.this.getMeasuredWidth(), 0.0f, new int[]{BdVideoGradientMask.this.getResources().getColor(R.color.nad_bd_full_more_left_mask_start_color), BdVideoGradientMask.this.getResources().getColor(R.color.nad_bd_full_more_left_mask_50percent_color), BdVideoGradientMask.this.getResources().getColor(R.color.nad_bd_full_more_left_mask_75percent_color), BdVideoGradientMask.this.getResources().getColor(R.color.nad_bd_full_more_left_mask_95percent_color)}, new float[]{0.0f, 0.5f, 0.75f, 1.0f}, Shader.TileMode.CLAMP);
            }
        });
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        getPaint().setShader(getLinearGradient());
        if (canvas != null) {
            canvas.drawRect(0.0f, 0.0f, getWidth(), getHeight(), getPaint());
        }
    }
}
