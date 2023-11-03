package com.baidu.nadcore.slidingtag;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.LinearInterpolator;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.constraintlayout.motion.widget.Key;
import androidx.core.content.ContextCompat;
import androidx.core.view.ViewCompat;
import com.baidu.searchbox.launch.utils.SpeedStatsUtils;
import com.baidu.tieba.R;
import com.baidu.tieba.oy0;
import com.baidu.tieba.p11;
import com.baidu.tieba.py0;
import com.baidu.tieba.qy0;
import com.baidu.tieba.sy0;
import com.baidu.tieba.t11;
import com.baidu.tieba.yn0;
import com.google.android.exoplayer2.text.ttml.TtmlNode;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.yy.gslbsdk.db.DelayTB;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt___RangesKt;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0082\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u00012\u00020\u0002B'\b\u0007\u0012\u0006\u0010R\u001a\u00020Q\u0012\n\b\u0002\u0010T\u001a\u0004\u0018\u00010S\u0012\b\b\u0002\u0010U\u001a\u00020\u0012¢\u0006\u0004\bV\u0010WJ\u000f\u0010\u0004\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0006\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0006\u0010\u0005J\u0017\u0010\t\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\u000b\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\u000b\u0010\nJ\u0017\u0010\r\u001a\u00020\f2\u0006\u0010\b\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010\u000f\u001a\u00020\f2\u0006\u0010\b\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\u000f\u0010\u000eJ\u0017\u0010\u0010\u001a\u00020\f2\u0006\u0010\b\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\u0010\u0010\u000eJ\u0017\u0010\u0011\u001a\u00020\f2\u0006\u0010\b\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\u0011\u0010\u000eJ\u000f\u0010\u0013\u001a\u00020\u0012H\u0016¢\u0006\u0004\b\u0013\u0010\u0014J\u000f\u0010\u0015\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u0015\u0010\u0016J\u001b\u0010\u0015\u001a\u0004\u0018\u00010\u00072\b\u0010\u0018\u001a\u0004\u0018\u00010\u0017H\u0002¢\u0006\u0004\b\u0015\u0010\u0019J!\u0010\u001d\u001a\u00020\u00032\u0006\u0010\u001b\u001a\u00020\u001a2\b\u0010\u001c\u001a\u0004\u0018\u00010\u0012H\u0016¢\u0006\u0004\b\u001d\u0010\u001eJ\u000f\u0010\u001f\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u001f\u0010\u0005J\u0019\u0010\"\u001a\u00020\u00032\b\u0010!\u001a\u0004\u0018\u00010 H\u0016¢\u0006\u0004\b\"\u0010#J!\u0010'\u001a\u00020\u00032\u0006\u0010$\u001a\u00020\u00072\b\u0010&\u001a\u0004\u0018\u00010%H\u0002¢\u0006\u0004\b'\u0010(J\u001f\u0010,\u001a\u00020\u00032\u0006\u0010)\u001a\u00020\u00122\u0006\u0010+\u001a\u00020*H\u0016¢\u0006\u0004\b,\u0010-J\u0017\u0010/\u001a\u00020\u00032\u0006\u0010.\u001a\u00020\u0012H\u0016¢\u0006\u0004\b/\u00100J\u0017\u00102\u001a\u00020\u00032\u0006\u00101\u001a\u00020\u0012H\u0016¢\u0006\u0004\b2\u00100J\u0019\u00105\u001a\u00020\u00032\b\u00104\u001a\u0004\u0018\u000103H\u0016¢\u0006\u0004\b5\u00106J\u0017\u00109\u001a\u00020\u00032\u0006\u00108\u001a\u000207H\u0002¢\u0006\u0004\b9\u0010:J\u0019\u0010;\u001a\u00020\u00032\b\u00104\u001a\u0004\u0018\u000103H\u0016¢\u0006\u0004\b;\u00106J!\u0010;\u001a\u00020\u00032\b\u00104\u001a\u0004\u0018\u0001032\u0006\u00108\u001a\u000207H\u0016¢\u0006\u0004\b;\u0010<J\u000f\u0010=\u001a\u00020\u0003H\u0016¢\u0006\u0004\b=\u0010\u0005R\u0016\u0010>\u001a\u0002078\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b>\u0010?R\u0016\u0010@\u001a\u0002078\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b@\u0010?R\u0016\u0010A\u001a\u00020\u001a8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bA\u0010BR\u0018\u0010!\u001a\u0004\u0018\u00010 8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b!\u0010CR\u0016\u0010E\u001a\u00020D8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bE\u0010FR\u0016\u0010.\u001a\u00020\u00128\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b.\u0010GR\u0016\u0010H\u001a\u00020\u00128\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bH\u0010GR\u0016\u0010I\u001a\u00020\u00128\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bI\u0010GR\u0018\u0010J\u001a\u0004\u0018\u0001038\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bJ\u0010KR\u0016\u0010M\u001a\u00020L8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bM\u0010NR\u0016\u0010O\u001a\u00020*8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bO\u0010P¨\u0006X"}, d2 = {"Lcom/baidu/nadcore/slidingtag/NadMultiSlidingView;", "Lcom/baidu/tieba/qy0;", "Landroid/widget/RelativeLayout;", "", "addViewToContainer", "()V", "destroy", "Landroid/view/View;", "animView", "fadeIn", "(Landroid/view/View;)V", "fadeOut", "Landroid/animation/ValueAnimator;", "getFadeInAlphaAnimator", "(Landroid/view/View;)Landroid/animation/ValueAnimator;", "getFadeInPositionAnimator", "getFadeOutAlphaAnimator", "getFadeUpPositionAnimator", "", "getMaxItemWidth", "()I", "getSlidingView", "()Landroid/view/View;", "Lcom/baidu/nadcore/model/NadSlidingTagModel$TagItem;", "item", "(Lcom/baidu/nadcore/model/NadSlidingTagModel$TagItem;)Landroid/view/View;", "", SpeedStatsUtils.IS_NIGHT_MODE, "textColor", "onNightModeChanged", "(ZLjava/lang/Integer;)V", "reset", "Lcom/baidu/nadcore/slidingtag/INadSlidingActionListener;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "setActionListener", "(Lcom/baidu/nadcore/slidingtag/INadSlidingActionListener;)V", "view", "", TtmlNode.ATTR_TTS_BACKGROUND_COLOR, "setBackground", "(Landroid/view/View;Ljava/lang/String;)V", "iconSize", "", "textSize", "setFontSize", "(IF)V", "maxWidthPx", "setMaxWidth", "(I)V", "visibility", "setVisibility", "Lcom/baidu/nadcore/model/NadSlidingTagModel;", "model", "start", "(Lcom/baidu/nadcore/model/NadSlidingTagModel;)V", "", DelayTB.DELAY, "startAnimWithDelay", "(J)V", "startDelay", "(Lcom/baidu/nadcore/model/NadSlidingTagModel;J)V", "stop", "delayMillis", "J", "intervalMillis", "isPlaying", "Z", "Lcom/baidu/nadcore/slidingtag/INadSlidingActionListener;", "Landroid/os/Handler;", "mainHandler", "Landroid/os/Handler;", "I", "showCount", "showIndex", "slidingModel", "Lcom/baidu/nadcore/model/NadSlidingTagModel;", "Ljava/lang/Runnable;", "startAnimation", "Ljava/lang/Runnable;", "textSizePx", "F", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attributeSet", "style", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "nadcore-lib-business"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes3.dex */
public final class NadMultiSlidingView extends RelativeLayout implements qy0 {
    public int a;
    public int b;
    public int c;
    public boolean d;
    public yn0 e;
    public float f;
    public long g;
    public long h;
    public py0 i;
    public final Handler j;
    public final Runnable k;

    @JvmOverloads
    public NadMultiSlidingView(Context context) {
        this(context, null, 0, 6, null);
    }

    @JvmOverloads
    public NadMultiSlidingView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
    }

    public int getMaxItemWidth() {
        return 0;
    }

    public View getSlidingView() {
        return this;
    }

    /* loaded from: classes3.dex */
    public static final class a extends AnimatorListenerAdapter {
        public final /* synthetic */ ValueAnimator b;
        public final /* synthetic */ ValueAnimator c;
        public final /* synthetic */ View d;

        public a(ValueAnimator valueAnimator, ValueAnimator valueAnimator2, View view2) {
            this.b = valueAnimator;
            this.c = valueAnimator2;
            this.d = view2;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animation) {
            Intrinsics.checkNotNullParameter(animation, "animation");
            Animation animation2 = this.d.getAnimation();
            if (animation2 != null) {
                animation2.cancel();
            }
            NadMultiSlidingView.this.removeView(this.d);
        }
    }

    /* loaded from: classes3.dex */
    public static final class b implements ValueAnimator.AnimatorUpdateListener {
        public final /* synthetic */ View a;

        public b(View view2) {
            this.a = view2;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public final void onAnimationUpdate(ValueAnimator valueAnimator) {
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
                this.a.setAlpha(f2.floatValue());
            }
        }
    }

    /* loaded from: classes3.dex */
    public static final class c implements ValueAnimator.AnimatorUpdateListener {
        public final /* synthetic */ View a;

        public c(View view2) {
            this.a = view2;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public final void onAnimationUpdate(ValueAnimator valueAnimator) {
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
                this.a.setAlpha(f2.floatValue());
            }
        }
    }

    /* loaded from: classes3.dex */
    public static final class d extends AnimatorListenerAdapter {
        public final /* synthetic */ View a;

        public d(View view2) {
            this.a = view2;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animation) {
            Intrinsics.checkNotNullParameter(animation, "animation");
            this.a.getTranslationY();
        }
    }

    /* loaded from: classes3.dex */
    public static final class e implements View.OnClickListener {
        public final /* synthetic */ yn0 a;
        public final /* synthetic */ py0 b;
        public final /* synthetic */ NadMultiSlidingView c;
        public final /* synthetic */ TextView d;
        public final /* synthetic */ yn0.c e;

        public e(yn0 yn0Var, py0 py0Var, NadMultiSlidingView nadMultiSlidingView, TextView textView, yn0.c cVar) {
            this.a = yn0Var;
            this.b = py0Var;
            this.c = nadMultiSlidingView;
            this.d = textView;
            this.e = cVar;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view2) {
            String str;
            py0 py0Var = this.b;
            Context context = this.c.getContext();
            yn0.c cVar = this.e;
            if (cVar != null) {
                str = cVar.a;
            } else {
                str = null;
            }
            py0Var.a(new oy0(context, str, CollectionsKt___CollectionsKt.indexOf((List<? extends yn0.c>) this.a.a, this.e), this.a.g));
        }
    }

    /* loaded from: classes3.dex */
    public static final class f implements Runnable {
        /* JADX DEBUG: Incorrect args count in method signature: ()V */
        public f() {
        }

        @Override // java.lang.Runnable
        public void run() {
            yn0.c cVar;
            List<yn0.c> list;
            List<yn0.c> list2;
            NadMultiSlidingView.this.j.removeCallbacksAndMessages(null);
            if (NadMultiSlidingView.this.getChildCount() > NadMultiSlidingView.this.a) {
                NadMultiSlidingView nadMultiSlidingView = NadMultiSlidingView.this;
                nadMultiSlidingView.w(nadMultiSlidingView.e, NadMultiSlidingView.this.h);
                return;
            }
            int i = 0;
            int i2 = NadMultiSlidingView.this.a;
            if (i2 >= 0) {
                while (true) {
                    if (i == 0) {
                        View childAt = NadMultiSlidingView.this.getChildAt(i);
                        if (childAt != null) {
                            NadMultiSlidingView.this.n(childAt);
                        }
                    } else if (i != NadMultiSlidingView.this.a) {
                        View childAt2 = NadMultiSlidingView.this.getChildAt(i);
                        if (childAt2 != null) {
                            NadMultiSlidingView.this.r(childAt2).start();
                        }
                    } else {
                        yn0 yn0Var = NadMultiSlidingView.this.e;
                        if (yn0Var != null && (list2 = yn0Var.a) != null) {
                            int size = list2.size();
                            NadMultiSlidingView nadMultiSlidingView2 = NadMultiSlidingView.this;
                            nadMultiSlidingView2.c = (nadMultiSlidingView2.c + 1) % size;
                        }
                        NadMultiSlidingView nadMultiSlidingView3 = NadMultiSlidingView.this;
                        yn0 yn0Var2 = nadMultiSlidingView3.e;
                        if (yn0Var2 != null && (list = yn0Var2.a) != null) {
                            cVar = (yn0.c) CollectionsKt___CollectionsKt.getOrNull(list, NadMultiSlidingView.this.c);
                        } else {
                            cVar = null;
                        }
                        View s = nadMultiSlidingView3.s(cVar);
                        if (s != null) {
                            NadMultiSlidingView.this.m(s);
                        }
                    }
                    if (i == i2) {
                        break;
                    }
                    i++;
                }
            }
            NadMultiSlidingView.this.j.postDelayed(this, NadMultiSlidingView.this.g + 200);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public NadMultiSlidingView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
        this.a = 2;
        this.b = (int) (t11.c.e(context) * 0.6d);
        this.f = t11.c.a(context, 12.0f);
        this.g = 800L;
        this.h = 800L;
        this.j = new Handler(Looper.getMainLooper());
        this.k = new f();
    }

    public /* synthetic */ NadMultiSlidingView(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    public void setFontSize(int i, float f2) {
        float f3 = this.f;
        if (f3 == f3) {
            return;
        }
        this.f = f2;
        if (this.d) {
            w(this.e, this.h);
        }
    }

    public final void u(View view2, String str) {
        int a2 = p11.a(str, R.color.nad_sliding_multi_bg_color_default);
        Drawable drawable = ContextCompat.getDrawable(getContext(), R.drawable.nad_sliding_multi_bg);
        if (drawable != null) {
            drawable.setColorFilter(new PorterDuffColorFilter(a2, PorterDuff.Mode.SRC_ATOP));
            Unit unit = Unit.INSTANCE;
        } else {
            drawable = null;
        }
        view2.setBackground(drawable);
    }

    public void w(yn0 yn0Var, long j) {
        t();
        if (yn0Var != null && !yn0Var.a.isEmpty()) {
            this.h = j;
            this.e = yn0Var;
            this.a = RangesKt___RangesKt.coerceAtMost(yn0Var.h, 3);
            this.g = yn0Var.d;
            l();
            v(j);
        }
    }

    public final void n(View view2) {
        ValueAnimator r = r(view2);
        ValueAnimator q = q(view2);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.play(r).with(q);
        animatorSet.addListener(new a(r, q, view2));
        animatorSet.start();
    }

    public final ValueAnimator o(View view2) {
        ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        ofFloat.setDuration(200L);
        ofFloat.setInterpolator(new LinearInterpolator());
        ofFloat.addUpdateListener(new b(view2));
        Intrinsics.checkNotNullExpressionValue(ofFloat, "ValueAnimator.ofFloat(0F…}\n            }\n        }");
        return ofFloat;
    }

    public final ValueAnimator p(View view2) {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view2, Key.TRANSLATION_Y, this.f + t11.c.a(getContext(), 13.0f), 0.0f);
        ofFloat.setDuration(200L);
        Intrinsics.checkNotNullExpressionValue(ofFloat, "ObjectAnimator.ofFloat(a…LT_RELAY_MILLIS\n        }");
        return ofFloat;
    }

    public final ValueAnimator q(View view2) {
        ValueAnimator ofFloat = ValueAnimator.ofFloat(1.0f, 0.0f);
        ofFloat.setDuration(200L);
        ofFloat.setInterpolator(new LinearInterpolator());
        ofFloat.addUpdateListener(new c(view2));
        Intrinsics.checkNotNullExpressionValue(ofFloat, "ValueAnimator.ofFloat(1F…}\n            }\n        }");
        return ofFloat;
    }

    public void setActionListener(py0 py0Var) {
        this.i = py0Var;
    }

    public void setMaxWidth(int i) {
        this.b = i;
    }

    @Override // android.view.View
    public void setVisibility(int i) {
        super.setVisibility(i);
    }

    public final void v(long j) {
        int i;
        List<yn0.c> list;
        if (this.a > 0) {
            yn0 yn0Var = this.e;
            if (yn0Var != null && (list = yn0Var.a) != null) {
                i = list.size();
            } else {
                i = 0;
            }
            if (i >= this.a) {
                this.j.postDelayed(this.k, j);
                this.d = true;
            }
        }
    }

    public final void l() {
        int i;
        yn0.c cVar;
        List<yn0.c> list;
        int i2;
        List<yn0.c> list2;
        List<yn0.c> list3;
        yn0 yn0Var = this.e;
        if (yn0Var != null && (list3 = yn0Var.a) != null) {
            i = list3.size();
        } else {
            i = 0;
        }
        if (i < this.a) {
            yn0 yn0Var2 = this.e;
            if (yn0Var2 != null && (list2 = yn0Var2.a) != null) {
                i2 = list2.size();
            } else {
                i2 = 0;
            }
            this.a = i2;
        }
        if (this.a <= 0) {
            return;
        }
        int a2 = (int) (this.f + t11.c.a(getContext(), 13.0f));
        if (getLayoutParams() == null) {
            setLayoutParams(new RelativeLayout.LayoutParams(-2, (this.a + 1) * a2));
        } else {
            getLayoutParams().height = (this.a + 1) * a2;
        }
        int i3 = this.a;
        for (int i4 = 0; i4 < i3; i4++) {
            yn0 yn0Var3 = this.e;
            if (yn0Var3 != null && (list = yn0Var3.a) != null) {
                cVar = (yn0.c) CollectionsKt___CollectionsKt.getOrNull(list, i4);
            } else {
                cVar = null;
            }
            View s = s(cVar);
            if (s != null) {
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
                layoutParams.addRule(12);
                layoutParams.addRule(9);
                layoutParams.bottomMargin = ((this.a - i4) - 1) * a2;
                Unit unit = Unit.INSTANCE;
                addView(s, layoutParams);
                this.c = i4;
            }
        }
    }

    public final void m(View view2) {
        if (getChildAt(getChildCount() - 1) != null) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.addRule(12);
            layoutParams.addRule(9);
            Unit unit = Unit.INSTANCE;
            addView(view2, layoutParams);
        }
        ValueAnimator p = p(view2);
        ValueAnimator o = o(view2);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.play(p).with(o);
        animatorSet.start();
    }

    public final ValueAnimator r(View view2) {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view2, Key.TRANSLATION_Y, view2.getTranslationY(), view2.getTranslationY() - (this.f + t11.c.a(getContext(), 13.0f)));
        ofFloat.setDuration(200L);
        ofFloat.addListener(new d(view2));
        Intrinsics.checkNotNullExpressionValue(ofFloat, "ObjectAnimator.ofFloat(a…\n            })\n        }");
        return ofFloat;
    }

    public final View s(yn0.c cVar) {
        yn0 yn0Var;
        TextView a2 = sy0.a(getContext(), cVar);
        if (a2 != null) {
            a2.setId(ViewCompat.generateViewId());
            a2.setTextSize(0, this.f);
            a2.setLayoutParams(new RelativeLayout.LayoutParams(-2, -2));
            a2.setPadding(t11.c.a(a2.getContext(), 10.0f), t11.c.a(a2.getContext(), 4.0f), t11.c.a(a2.getContext(), 10.0f), t11.c.a(a2.getContext(), 4.0f));
            a2.setMaxLines(1);
            a2.setMaxWidth(this.b);
            a2.setSingleLine();
            a2.setEllipsize(TextUtils.TruncateAt.END);
            a2.setGravity(16);
            a2.setIncludeFontPadding(false);
            a2.setVisibility(0);
            if (a2 != null) {
                yn0 yn0Var2 = this.e;
                u(a2, (yn0Var2 == null || (r1 = yn0Var2.f) == null) ? "" : "");
                py0 py0Var = this.i;
                if (py0Var != null && (yn0Var = this.e) != null) {
                    a2.setOnClickListener(new e(yn0Var, py0Var, this, a2, cVar));
                }
                return a2;
            }
            return null;
        }
        return null;
    }

    public final void t() {
        Animation animation;
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            if (childAt != null && (animation = childAt.getAnimation()) != null) {
                animation.cancel();
            }
        }
        Animation animation2 = getAnimation();
        if (animation2 != null) {
            animation2.cancel();
        }
        removeAllViews();
        this.j.removeCallbacksAndMessages(null);
        this.c = 0;
        this.e = null;
        this.i = null;
        this.d = false;
        this.h = 800L;
    }
}
