package com.baidu.nadcore.slidingtag;

import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.motion.utils.Easing;
import androidx.core.content.ContextCompat;
import com.baidu.minivideo.effect.core.vlogedit.ShaderParams;
import com.baidu.nadcore.widget.AdImageView;
import com.baidu.nadcore.widget.IAdImageView;
import com.baidu.searchbox.launch.utils.SpeedStatsUtils;
import com.baidu.tieba.R;
import com.baidu.tieba.py0;
import com.baidu.tieba.qy0;
import com.baidu.tieba.t11;
import com.baidu.tieba.yn0;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.yy.gslbsdk.db.DelayTB;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000¢\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\t\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b&\u0018\u00002\u00020\u00012\u00020\u0002B*\b\u0007\u0012\b\u0010\u0083\u0001\u001a\u00030\u0082\u0001\u0012\n\u0010\u0085\u0001\u001a\u0005\u0018\u00010\u0084\u0001\u0012\u0007\u0010\u0086\u0001\u001a\u00020\u0006¢\u0006\u0006\b\u0087\u0001\u0010\u0088\u0001J\u000f\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0007\u001a\u00020\u0006H$¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\t\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\bJ\u0017\u0010\f\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\nH\u0004¢\u0006\u0004\b\f\u0010\rJ\u0017\u0010\u000e\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\nH\u0004¢\u0006\u0004\b\u000e\u0010\rJ\u000f\u0010\u000f\u001a\u00020\u0006H\u0004¢\u0006\u0004\b\u000f\u0010\bJ\u000f\u0010\u0010\u001a\u00020\u0006H$¢\u0006\u0004\b\u0010\u0010\bJ\u000f\u0010\u0011\u001a\u00020\nH\u0016¢\u0006\u0004\b\u0011\u0010\u0012J\u000f\u0010\u0013\u001a\u00020\u0003H\u0004¢\u0006\u0004\b\u0013\u0010\u0005J\u000f\u0010\u0015\u001a\u00020\u0014H\u0014¢\u0006\u0004\b\u0015\u0010\u0016J!\u0010\u001a\u001a\u00020\u00032\u0006\u0010\u0018\u001a\u00020\u00172\b\u0010\u0019\u001a\u0004\u0018\u00010\u0006H\u0016¢\u0006\u0004\b\u001a\u0010\u001bJ\u000f\u0010\u001c\u001a\u00020\u0003H\u0004¢\u0006\u0004\b\u001c\u0010\u0005J\u0019\u0010\u001f\u001a\u00020\u00032\b\u0010\u001e\u001a\u0004\u0018\u00010\u001dH\u0016¢\u0006\u0004\b\u001f\u0010 J\u0017\u0010#\u001a\u00020\u00032\u0006\u0010\"\u001a\u00020!H\u0004¢\u0006\u0004\b#\u0010$J\u0017\u0010%\u001a\u00020\u00032\u0006\u0010\"\u001a\u00020!H\u0004¢\u0006\u0004\b%\u0010$J\u001f\u0010)\u001a\u00020\u00032\u0006\u0010&\u001a\u00020\u00062\u0006\u0010(\u001a\u00020'H\u0016¢\u0006\u0004\b)\u0010*J\u0017\u0010+\u001a\u00020\u00032\u0006\u0010\"\u001a\u00020!H\u0004¢\u0006\u0004\b+\u0010$J\u0017\u0010,\u001a\u00020\u00032\u0006\u0010\"\u001a\u00020!H\u0004¢\u0006\u0004\b,\u0010$J\u0017\u0010.\u001a\u00020\u00032\u0006\u0010-\u001a\u00020\u0006H&¢\u0006\u0004\b.\u0010/J\u0019\u00100\u001a\u00020\u00032\b\u0010\"\u001a\u0004\u0018\u00010!H&¢\u0006\u0004\b0\u0010$J\u0017\u00103\u001a\u00020\u00032\u0006\u00102\u001a\u000201H\u0004¢\u0006\u0004\b3\u00104J\u0019\u00105\u001a\u00020\u00032\b\u0010\"\u001a\u0004\u0018\u00010!H&¢\u0006\u0004\b5\u0010$J!\u00105\u001a\u00020\u00032\b\u0010\"\u001a\u0004\u0018\u00010!2\u0006\u00102\u001a\u000201H&¢\u0006\u0004\b5\u00106J\u000f\u00107\u001a\u00020\u0003H\u0016¢\u0006\u0004\b7\u0010\u0005J\u0019\u0010:\u001a\u00020\u00032\b\u00109\u001a\u0004\u0018\u000108H\u0002¢\u0006\u0004\b:\u0010;J\u0019\u0010<\u001a\u00020\u00032\b\u00109\u001a\u0004\u0018\u000108H\u0002¢\u0006\u0004\b<\u0010;J\u0019\u0010=\u001a\u00020\u00032\b\u00109\u001a\u0004\u0018\u000108H\u0002¢\u0006\u0004\b=\u0010;J\u0019\u0010>\u001a\u00020\u00032\b\u00109\u001a\u0004\u0018\u000108H\u0002¢\u0006\u0004\b>\u0010;J\u0013\u0010?\u001a\u00020\n*\u00020\nH\u0004¢\u0006\u0004\b?\u0010@R\u001d\u0010F\u001a\u00020A8B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\bB\u0010C\u001a\u0004\bD\u0010ER\u001f\u0010I\u001a\u0004\u0018\u00010\n8B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\bG\u0010C\u001a\u0004\bH\u0010\u0012R\"\u0010J\u001a\u00020\u00068\u0004@\u0004X\u0084\u000e¢\u0006\u0012\n\u0004\bJ\u0010K\u001a\u0004\bL\u0010\b\"\u0004\bM\u0010/R\u0016\u0010N\u001a\u0002018\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bN\u0010OR\"\u0010P\u001a\u00020\u00068\u0004@\u0004X\u0084\u000e¢\u0006\u0012\n\u0004\bP\u0010K\u001a\u0004\bQ\u0010\b\"\u0004\bR\u0010/R\u001d\u0010W\u001a\u00020S8D@\u0004X\u0084\u0084\u0002¢\u0006\f\n\u0004\bT\u0010C\u001a\u0004\bU\u0010VR\u0016\u0010Y\u001a\u00020X8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bY\u0010ZR\u0016\u0010[\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b[\u0010KR\"\u0010\\\u001a\u00020'8\u0004@\u0004X\u0084\u000e¢\u0006\u0012\n\u0004\b\\\u0010]\u001a\u0004\b^\u0010_\"\u0004\b`\u0010aR\u0016\u0010b\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bb\u0010KR\u0016\u0010d\u001a\u00020c8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bd\u0010eR\u0016\u0010f\u001a\u00020\u00178\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bf\u0010gR\"\u0010h\u001a\u00020'8\u0004@\u0004X\u0084\u000e¢\u0006\u0012\n\u0004\bh\u0010]\u001a\u0004\bi\u0010_\"\u0004\bj\u0010aR\"\u0010k\u001a\u00020'8\u0004@\u0004X\u0084\u000e¢\u0006\u0012\n\u0004\bk\u0010]\u001a\u0004\bl\u0010_\"\u0004\bm\u0010aR\"\u0010p\u001a\b\u0012\u0004\u0012\u00020o0n8\u0004@\u0004X\u0084\u0004¢\u0006\f\n\u0004\bp\u0010q\u001a\u0004\br\u0010sR>\u0010v\u001a\u001e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060tj\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006`u8\u0004@\u0004X\u0084\u000e¢\u0006\u0012\n\u0004\bv\u0010w\u001a\u0004\bx\u0010y\"\u0004\bz\u0010{R\"\u0010|\u001a\u00020\u00068\u0004@\u0004X\u0084\u000e¢\u0006\u0012\n\u0004\b|\u0010K\u001a\u0004\b}\u0010\b\"\u0004\b~\u0010/R$\u0010\u007f\u001a\u00020\u00068\u0004@\u0004X\u0084\u000e¢\u0006\u0014\n\u0004\b\u007f\u0010K\u001a\u0005\b\u0080\u0001\u0010\b\"\u0005\b\u0081\u0001\u0010/¨\u0006\u0089\u0001"}, d2 = {"Lcom/baidu/nadcore/slidingtag/NadSlidingTagBaseView;", "Lcom/baidu/tieba/qy0;", "Landroid/widget/FrameLayout;", "", "destroy", "()V", "", "getCurrentMeasuredWidth", "()I", "getMaxItemWidth", "Landroid/view/View;", "view", "getMeasuredHeight", "(Landroid/view/View;)I", "getMeasuredWidth", "getNextIndex", "getNextMeasuredWidth", "getSlidingView", "()Landroid/view/View;", "makeSureAtLeastOneTvDisplayWhenStop", "Landroid/widget/LinearLayout$LayoutParams;", "newTextViewLayoutParams", "()Landroid/widget/LinearLayout$LayoutParams;", "", SpeedStatsUtils.IS_NIGHT_MODE, "textColor", "onNightModeChanged", "(ZLjava/lang/Integer;)V", "reset", "Lcom/baidu/nadcore/slidingtag/INadSlidingActionListener;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "setActionListener", "(Lcom/baidu/nadcore/slidingtag/INadSlidingActionListener;)V", "Lcom/baidu/nadcore/model/NadSlidingTagModel;", "model", "setAnimation", "(Lcom/baidu/nadcore/model/NadSlidingTagModel;)V", "setBgHolder", "iconSize", "", "textSize", "setFontSize", "(IF)V", "setFrame", "setIcon", "maxWidthPx", "setMaxWidth", "(I)V", "start", "", DelayTB.DELAY, "startAnimationWithDelay", "(J)V", "startDelay", "(Lcom/baidu/nadcore/model/NadSlidingTagModel;J)V", "stop", "Landroid/animation/ValueAnimator;", ShaderParams.VALUE_TYPE_ANIMATOR, "updateAlphaAnimation", "(Landroid/animation/ValueAnimator;)V", "updateBgWidth", "updateFadeInPositionAnimation", "updateFadeOutPositionAnimation", "removeFromParent", "(Landroid/view/View;)Landroid/view/View;", "Landroid/animation/AnimatorSet;", "animatorSet$delegate", "Lkotlin/Lazy;", "getAnimatorSet", "()Landroid/animation/AnimatorSet;", "animatorSet", "bgHolder$delegate", "getBgHolder", "bgHolder", "currentIdx", "I", "getCurrentIdx", "setCurrentIdx", "displayIntervalMillis", "J", "iconSizePx", "getIconSizePx", "setIconSizePx", "Landroid/widget/LinearLayout;", "linear$delegate", "getLinear", "()Landroid/widget/LinearLayout;", Easing.LINEAR_NAME, "Landroid/os/Handler;", "mainHandler", "Landroid/os/Handler;", "nextWidth", "originalY", "F", "getOriginalY", "()F", "setOriginalY", "(F)V", "prevWidth", "Ljava/lang/Runnable;", "startAnimation", "Ljava/lang/Runnable;", "stopAnimationFlag", "Z", "textHeight", "getTextHeight", "setTextHeight", "textSizePx", "getTextSizePx", "setTextSizePx", "", "Landroid/widget/TextView;", "tvList", "Ljava/util/List;", "getTvList", "()Ljava/util/List;", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "widthMap", "Ljava/util/HashMap;", "getWidthMap", "()Ljava/util/HashMap;", "setWidthMap", "(Ljava/util/HashMap;)V", "yBias", "getYBias", "setYBias", "yBiasWithoutIcon", "getYBiasWithoutIcon", "setYBiasWithoutIcon", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attributeSet", "style", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "nadcore-lib-business"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes3.dex */
public abstract class NadSlidingTagBaseView extends FrameLayout implements qy0 {
    public final Lazy a;
    public final Lazy b;
    public final List<TextView> c;
    public int d;
    public float e;
    public float f;
    public long g;
    public boolean h;
    public int i;
    public int j;
    public int k;
    public float l;
    public int m;
    public int n;
    public HashMap<Integer, Integer> o;
    public final Lazy p;

    private final AnimatorSet getAnimatorSet() {
        return (AnimatorSet) this.p.getValue();
    }

    private final View getBgHolder() {
        return (View) this.b.getValue();
    }

    public abstract int getCurrentMeasuredWidth();

    public final LinearLayout getLinear() {
        return (LinearLayout) this.a.getValue();
    }

    public int getMaxItemWidth() {
        return 0;
    }

    public abstract int getNextMeasuredWidth();

    public View getSlidingView() {
        return this;
    }

    public void setActionListener(py0 py0Var) {
    }

    public abstract void setMaxWidth(int i);

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public NadSlidingTagBaseView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
        this.a = LazyKt__LazyJVMKt.lazy(new Function0<LinearLayout>() { // from class: com.baidu.nadcore.slidingtag.NadSlidingTagBaseView$linear$2
            {
                super(0);
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final LinearLayout invoke() {
                View findViewById = NadSlidingTagBaseView.this.findViewById(R.id.nad_sliding_tag_layout_linear);
                Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(R.id.nad_sliding_tag_layout_linear)");
                return (LinearLayout) findViewById;
            }
        });
        this.b = LazyKt__LazyJVMKt.lazy(new Function0<View>() { // from class: com.baidu.nadcore.slidingtag.NadSlidingTagBaseView$bgHolder$2
            {
                super(0);
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final View invoke() {
                return NadSlidingTagBaseView.this.findViewById(R.id.nad_sliding_tag_layout_bg_holder);
            }
        });
        this.c = new ArrayList();
        this.g = 3000L;
        new Handler(Looper.getMainLooper());
        this.k = t11.c.a(context, 17.0f);
        this.l = t11.c.a(context, 12.0f);
        this.m = t11.c.a(context, 7.0f);
        this.n = t11.c.a(context, 8.0f);
        this.o = new HashMap<>();
        this.p = LazyKt__LazyJVMKt.lazy(new NadSlidingTagBaseView$animatorSet$2(this));
    }

    public final int o(View view2) {
        Intrinsics.checkNotNullParameter(view2, "view");
        view2.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
        return view2.getMeasuredHeight();
    }

    public final int p(View view2) {
        Intrinsics.checkNotNullParameter(view2, "view");
        view2.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
        return view2.getMeasuredWidth();
    }

    public final View s(View removeFromParent) {
        Intrinsics.checkNotNullParameter(removeFromParent, "$this$removeFromParent");
        ViewParent parent = removeFromParent.getParent();
        if (!(parent instanceof ViewGroup)) {
            parent = null;
        }
        ViewGroup viewGroup = (ViewGroup) parent;
        if (viewGroup != null) {
            viewGroup.removeView(removeFromParent);
        }
        return removeFromParent;
    }

    public final void setAnimation(yn0 model) {
        Intrinsics.checkNotNullParameter(model, "model");
        this.g = model.d;
    }

    public final void setCurrentIdx(int i) {
        this.d = i;
    }

    public final void setFrame(yn0 model) {
        int i;
        Intrinsics.checkNotNullParameter(model, "model");
        if (getLinear().getVisibility() == 0) {
            i = 0;
        } else {
            i = 8;
        }
        setVisibility(i);
    }

    public final void setIconSizePx(int i) {
        this.k = i;
    }

    public final void setOriginalY(float f) {
        this.e = f;
    }

    public final void setTextHeight(float f) {
        this.f = f;
    }

    public final void setTextSizePx(float f) {
        this.l = f;
    }

    public final void setWidthMap(HashMap<Integer, Integer> hashMap) {
        Intrinsics.checkNotNullParameter(hashMap, "<set-?>");
        this.o = hashMap;
    }

    public final void setYBias(int i) {
        this.m = i;
    }

    public final void setYBiasWithoutIcon(int i) {
        this.n = i;
    }

    public final void t(ValueAnimator valueAnimator) {
        Object obj;
        Float f = null;
        if (valueAnimator != null) {
            obj = valueAnimator.getAnimatedValue();
        } else {
            obj = null;
        }
        if (obj instanceof Float) {
            f = obj;
        }
        Float f2 = f;
        if (f2 != null) {
            float floatValue = f2.floatValue();
            TextView textView = (TextView) CollectionsKt___CollectionsKt.getOrNull(this.c, this.d);
            if (textView != null) {
                textView.setAlpha(floatValue);
            }
        }
    }

    public final void u(ValueAnimator valueAnimator) {
        Object obj;
        Integer num = null;
        if (valueAnimator != null) {
            obj = valueAnimator.getAnimatedValue();
        } else {
            obj = null;
        }
        if (obj instanceof Integer) {
            num = obj;
        }
        Integer num2 = num;
        if (num2 != null) {
            int intValue = num2.intValue();
            View bgHolder = getBgHolder();
            if (bgHolder != null) {
                ViewGroup.LayoutParams layoutParams = bgHolder.getLayoutParams();
                layoutParams.width = intValue;
                Unit unit = Unit.INSTANCE;
                bgHolder.setLayoutParams(layoutParams);
            }
        }
    }

    public final void v(ValueAnimator valueAnimator) {
        Object obj;
        Float f = null;
        if (valueAnimator != null) {
            obj = valueAnimator.getAnimatedValue();
        } else {
            obj = null;
        }
        if (obj instanceof Float) {
            f = obj;
        }
        Float f2 = f;
        if (f2 != null) {
            float floatValue = f2.floatValue();
            TextView textView = (TextView) CollectionsKt___CollectionsKt.getOrNull(this.c, this.d);
            if (textView != null) {
                textView.setY(this.e + (this.f * (1 - floatValue)));
            }
        }
    }

    public final void w(ValueAnimator valueAnimator) {
        Object obj;
        Float f = null;
        if (valueAnimator != null) {
            obj = valueAnimator.getAnimatedValue();
        } else {
            obj = null;
        }
        if (obj instanceof Float) {
            f = obj;
        }
        Float f2 = f;
        if (f2 != null) {
            float floatValue = f2.floatValue();
            TextView textView = (TextView) CollectionsKt___CollectionsKt.getOrNull(this.c, this.d);
            if (textView != null) {
                textView.setY(this.e - (this.f * floatValue));
            }
        }
    }

    public final int getCurrentIdx() {
        return this.d;
    }

    public final int getIconSizePx() {
        return this.k;
    }

    public final int getNextIndex() {
        int size = this.c.size();
        int i = this.d;
        int i2 = i + 1;
        if (i2 >= 0 && size > i2) {
            return i + 1;
        }
        return 0;
    }

    public final float getOriginalY() {
        return this.e;
    }

    public final float getTextHeight() {
        return this.f;
    }

    public final float getTextSizePx() {
        return this.l;
    }

    public final List<TextView> getTvList() {
        return this.c;
    }

    public final HashMap<Integer, Integer> getWidthMap() {
        return this.o;
    }

    public final int getYBias() {
        return this.m;
    }

    public final int getYBiasWithoutIcon() {
        return this.n;
    }

    public LinearLayout.LayoutParams r() {
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 16;
        return layoutParams;
    }

    public final void q() {
        if (getLinear().getChildCount() <= 0) {
            TextView textView = (TextView) CollectionsKt___CollectionsKt.getOrNull(this.c, this.d);
            if (textView != null) {
                textView.setAlpha(1.0f);
                textView.setVisibility(0);
                LinearLayout linear = getLinear();
                s(textView);
                linear.addView(textView, r());
                return;
            }
            return;
        }
        View childAt = getLinear().getChildAt(getLinear().getChildCount() - 1);
        if (childAt != null && (childAt instanceof TextView)) {
            TextView textView2 = (TextView) childAt;
            textView2.setAlpha(1.0f);
            textView2.setVisibility(0);
            LinearLayout linear2 = getLinear();
            s(childAt);
            linear2.addView(childAt, r());
            return;
        }
        TextView textView3 = (TextView) CollectionsKt___CollectionsKt.getOrNull(this.c, this.d);
        if (textView3 != null) {
            textView3.setAlpha(1.0f);
            textView3.setVisibility(0);
            LinearLayout linear3 = getLinear();
            s(textView3);
            linear3.addView(textView3, r());
        }
    }

    public final void setBgHolder(yn0 model) {
        int color;
        int i;
        Intrinsics.checkNotNullParameter(model, "model");
        View bgHolder = getBgHolder();
        if (bgHolder != null) {
            if (getLinear().getVisibility() == 0) {
                try {
                    color = Color.parseColor(model.f);
                } catch (Throwable unused) {
                    color = ContextCompat.getColor(bgHolder.getContext(), R.color.nad_sliding_tag_bg_color_default);
                }
                Drawable drawable = ContextCompat.getDrawable(bgHolder.getContext(), R.drawable.nad_sliding_tag_bg);
                if (drawable != null) {
                    drawable.setColorFilter(new PorterDuffColorFilter(color, PorterDuff.Mode.SRC_ATOP));
                    Unit unit = Unit.INSTANCE;
                } else {
                    drawable = null;
                }
                bgHolder.setBackground(drawable);
                ViewGroup.LayoutParams layoutParams = bgHolder.getLayoutParams();
                layoutParams.width = getCurrentMeasuredWidth();
                layoutParams.height = o(getLinear());
                Unit unit2 = Unit.INSTANCE;
                bgHolder.setLayoutParams(layoutParams);
                i = 0;
            } else {
                i = 8;
            }
            bgHolder.setVisibility(i);
        }
    }

    public final void setIcon(yn0 model) {
        Intrinsics.checkNotNullParameter(model, "model");
        if (StringsKt__StringsJVMKt.isBlank(model.b)) {
            return;
        }
        AdImageView adImageView = new AdImageView(getContext());
        adImageView.r(model.b);
        adImageView.setRadius(t11.c.a(adImageView.getContext(), 3.0f), t11.c.a(adImageView.getContext(), 3.0f), t11.c.a(adImageView.getContext(), 3.0f), t11.c.a(adImageView.getContext(), 3.0f));
        adImageView.setImageScaleType(IAdImageView.ImageScaleType.CENTER_CROP);
        adImageView.setVisibility(0);
        int i = this.k;
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(i, i);
        layoutParams.gravity = 16;
        layoutParams.setMargins(0, 0, t11.c.a(getContext(), 5.0f), 0);
        LinearLayout linear = getLinear();
        s(adImageView);
        linear.addView(adImageView, layoutParams);
    }

    public void setFontSize(int i, float f) {
        ViewGroup.LayoutParams layoutParams;
        this.k = i;
        this.l = f;
        getLinear().getLayoutParams().height = i + (t11.c.a(getContext(), 5.0f) * 2);
        View bgHolder = getBgHolder();
        if (bgHolder != null && (layoutParams = bgHolder.getLayoutParams()) != null) {
            layoutParams.height = o(getLinear());
        }
        this.f = f;
    }
}
