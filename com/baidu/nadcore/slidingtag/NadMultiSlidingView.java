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
import androidx.core.view.InputDeviceCompat;
import androidx.core.view.ViewCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.crius.constants.NativeConstants;
import com.baidu.tieba.R;
import com.baidu.tieba.b21;
import com.baidu.tieba.b51;
import com.baidu.tieba.c21;
import com.baidu.tieba.d21;
import com.baidu.tieba.f21;
import com.baidu.tieba.lr0;
import com.baidu.tieba.y41;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
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
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0080\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u00012\u00020\u0002B'\b\u0007\u0012\u0006\u0010K\u001a\u00020J\u0012\n\b\u0002\u0010M\u001a\u0004\u0018\u00010L\u0012\b\b\u0002\u0010N\u001a\u00020 ¢\u0006\u0004\bO\u0010PJ\u000f\u0010\u0004\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0006\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0006\u0010\u0005J\u0017\u0010\t\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\u000b\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\u000b\u0010\nJ\u0017\u0010\r\u001a\u00020\f2\u0006\u0010\b\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010\u000f\u001a\u00020\f2\u0006\u0010\b\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\u000f\u0010\u000eJ\u0017\u0010\u0010\u001a\u00020\f2\u0006\u0010\b\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\u0010\u0010\u000eJ\u0017\u0010\u0011\u001a\u00020\f2\u0006\u0010\b\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\u0011\u0010\u000eJ\u001b\u0010\u0014\u001a\u0004\u0018\u00010\u00072\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012H\u0002¢\u0006\u0004\b\u0014\u0010\u0015J\u000f\u0010\u0016\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u0016\u0010\u0005J\u0019\u0010\u0019\u001a\u00020\u00032\b\u0010\u0018\u001a\u0004\u0018\u00010\u0017H\u0016¢\u0006\u0004\b\u0019\u0010\u001aJ!\u0010\u001e\u001a\u00020\u00032\u0006\u0010\u001b\u001a\u00020\u00072\b\u0010\u001d\u001a\u0004\u0018\u00010\u001cH\u0002¢\u0006\u0004\b\u001e\u0010\u001fJ\u001f\u0010$\u001a\u00020\u00032\u0006\u0010!\u001a\u00020 2\u0006\u0010#\u001a\u00020\"H\u0016¢\u0006\u0004\b$\u0010%J\u0017\u0010'\u001a\u00020\u00032\u0006\u0010&\u001a\u00020 H\u0016¢\u0006\u0004\b'\u0010(J\u0017\u0010*\u001a\u00020\u00032\u0006\u0010)\u001a\u00020 H\u0016¢\u0006\u0004\b*\u0010(J\u0019\u0010-\u001a\u00020\u00032\b\u0010,\u001a\u0004\u0018\u00010+H\u0016¢\u0006\u0004\b-\u0010.J\u0017\u00101\u001a\u00020\u00032\u0006\u00100\u001a\u00020/H\u0002¢\u0006\u0004\b1\u00102J\u0019\u00103\u001a\u00020\u00032\b\u0010,\u001a\u0004\u0018\u00010+H\u0016¢\u0006\u0004\b3\u0010.J!\u00103\u001a\u00020\u00032\b\u0010,\u001a\u0004\u0018\u00010+2\u0006\u00100\u001a\u00020/H\u0016¢\u0006\u0004\b3\u00104J\u000f\u00105\u001a\u00020\u0003H\u0016¢\u0006\u0004\b5\u0010\u0005R\u0016\u00106\u001a\u00020/8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b6\u00107R\u0016\u00108\u001a\u00020/8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b8\u00107R\u0016\u0010:\u001a\u0002098\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b:\u0010;R\u0018\u0010\u0018\u001a\u0004\u0018\u00010\u00178\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0018\u0010<R\u0016\u0010>\u001a\u00020=8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b>\u0010?R\u0016\u0010&\u001a\u00020 8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b&\u0010@R\u0016\u0010A\u001a\u00020 8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bA\u0010@R\u0016\u0010B\u001a\u00020 8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bB\u0010@R\u0018\u0010C\u001a\u0004\u0018\u00010+8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bC\u0010DR\u0016\u0010F\u001a\u00020E8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bF\u0010GR\u0016\u0010H\u001a\u00020\"8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bH\u0010I¨\u0006Q"}, d2 = {"Lcom/baidu/nadcore/slidingtag/NadMultiSlidingView;", "Lcom/baidu/tieba/d21;", "Landroid/widget/RelativeLayout;", "", "addViewToContainer", "()V", "destroy", "Landroid/view/View;", "animView", "fadeIn", "(Landroid/view/View;)V", "fadeOut", "Landroid/animation/ValueAnimator;", "getFadeInAlphaAnimator", "(Landroid/view/View;)Landroid/animation/ValueAnimator;", "getFadeInPositionAnimator", "getFadeOutAlphaAnimator", "getFadeUpPositionAnimator", "Lcom/baidu/nadcore/model/NadSlidingTagModel$TagItem;", "item", "getSlidingView", "(Lcom/baidu/nadcore/model/NadSlidingTagModel$TagItem;)Landroid/view/View;", "reset", "Lcom/baidu/nadcore/slidingtag/INadSlidingActionListener;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "setActionListener", "(Lcom/baidu/nadcore/slidingtag/INadSlidingActionListener;)V", NativeConstants.TYPE_VIEW, "", TtmlNode.ATTR_TTS_BACKGROUND_COLOR, "setBackground", "(Landroid/view/View;Ljava/lang/String;)V", "", "iconSize", "", "textSize", "setFontSize", "(IF)V", "maxWidthPx", "setMaxWidth", "(I)V", "visibility", "setVisibility", "Lcom/baidu/nadcore/model/NadSlidingTagModel;", "model", "start", "(Lcom/baidu/nadcore/model/NadSlidingTagModel;)V", "", DelayTB.DELAY, "startAnimWithDelay", "(J)V", "startDelay", "(Lcom/baidu/nadcore/model/NadSlidingTagModel;J)V", "stop", "delayMillis", "J", "intervalMillis", "", "isPlaying", "Z", "Lcom/baidu/nadcore/slidingtag/INadSlidingActionListener;", "Landroid/os/Handler;", "mainHandler", "Landroid/os/Handler;", "I", "showCount", "showIndex", "slidingModel", "Lcom/baidu/nadcore/model/NadSlidingTagModel;", "Ljava/lang/Runnable;", "startAnimation", "Ljava/lang/Runnable;", "textSizePx", "F", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attributeSet", "style", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "nadcore-lib-business"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes2.dex */
public final class NadMultiSlidingView extends RelativeLayout implements d21 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;
    public int b;
    public int c;
    public boolean d;
    public lr0 e;
    public float f;
    public long g;
    public long h;
    public c21 i;
    public final Handler j;
    public final Runnable k;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public NadMultiSlidingView(Context context) {
        this(context, null, 0, 6, null);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue(), ((Integer) objArr2[3]).intValue(), (DefaultConstructorMarker) objArr2[4]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public NadMultiSlidingView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue(), ((Integer) objArr2[3]).intValue(), (DefaultConstructorMarker) objArr2[4]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    /* loaded from: classes2.dex */
    public static final class a extends AnimatorListenerAdapter {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ NadMultiSlidingView a;
        public final /* synthetic */ ValueAnimator b;
        public final /* synthetic */ ValueAnimator c;
        public final /* synthetic */ View d;

        public a(NadMultiSlidingView nadMultiSlidingView, ValueAnimator valueAnimator, ValueAnimator valueAnimator2, View view2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {nadMultiSlidingView, valueAnimator, valueAnimator2, view2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = nadMultiSlidingView;
            this.b = valueAnimator;
            this.c = valueAnimator2;
            this.d = view2;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, animator) == null) {
                Animation animation = this.d.getAnimation();
                if (animation != null) {
                    animation.cancel();
                }
                this.a.removeView(this.d);
            }
        }
    }

    /* loaded from: classes2.dex */
    public static final class b implements ValueAnimator.AnimatorUpdateListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ View a;

        public b(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {view2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = view2;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public final void onAnimationUpdate(ValueAnimator valueAnimator) {
            Object obj;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, valueAnimator) == null) {
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
    }

    /* loaded from: classes2.dex */
    public static final class c implements ValueAnimator.AnimatorUpdateListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ View a;

        public c(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {view2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = view2;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public final void onAnimationUpdate(ValueAnimator valueAnimator) {
            Object obj;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, valueAnimator) == null) {
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
    }

    /* loaded from: classes2.dex */
    public static final class d extends AnimatorListenerAdapter {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ View a;

        public d(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {view2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = view2;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, animator) == null) {
                this.a.getTranslationY();
            }
        }
    }

    /* loaded from: classes2.dex */
    public static final class e implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ lr0 a;
        public final /* synthetic */ c21 b;
        public final /* synthetic */ NadMultiSlidingView c;
        public final /* synthetic */ TextView d;
        public final /* synthetic */ lr0.c e;

        public e(lr0 lr0Var, c21 c21Var, NadMultiSlidingView nadMultiSlidingView, TextView textView, lr0.c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {lr0Var, c21Var, nadMultiSlidingView, textView, cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = lr0Var;
            this.b = c21Var;
            this.c = nadMultiSlidingView;
            this.d = textView;
            this.e = cVar;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view2) {
            String str;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                c21 c21Var = this.b;
                Context context = this.c.getContext();
                lr0.c cVar = this.e;
                if (cVar != null) {
                    str = cVar.a;
                } else {
                    str = null;
                }
                c21Var.a(new b21(context, str, CollectionsKt___CollectionsKt.indexOf((List<? extends lr0.c>) this.a.a, this.e), this.a.g));
            }
        }
    }

    /* loaded from: classes2.dex */
    public static final class f implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ NadMultiSlidingView a;

        /* JADX DEBUG: Incorrect args count in method signature: ()V */
        public f(NadMultiSlidingView nadMultiSlidingView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {nadMultiSlidingView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = nadMultiSlidingView;
        }

        @Override // java.lang.Runnable
        public void run() {
            lr0.c cVar;
            List<lr0.c> list;
            List<lr0.c> list2;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.j.removeCallbacksAndMessages(null);
                if (this.a.getChildCount() > this.a.a) {
                    NadMultiSlidingView nadMultiSlidingView = this.a;
                    nadMultiSlidingView.w(nadMultiSlidingView.e, this.a.h);
                    return;
                }
                int i = 0;
                int i2 = this.a.a;
                if (i2 >= 0) {
                    while (true) {
                        if (i == 0) {
                            View childAt = this.a.getChildAt(i);
                            if (childAt != null) {
                                this.a.n(childAt);
                            }
                        } else if (i != this.a.a) {
                            View childAt2 = this.a.getChildAt(i);
                            if (childAt2 != null) {
                                this.a.r(childAt2).start();
                            }
                        } else {
                            lr0 lr0Var = this.a.e;
                            if (lr0Var != null && (list2 = lr0Var.a) != null) {
                                int size = list2.size();
                                NadMultiSlidingView nadMultiSlidingView2 = this.a;
                                nadMultiSlidingView2.c = (nadMultiSlidingView2.c + 1) % size;
                            }
                            NadMultiSlidingView nadMultiSlidingView3 = this.a;
                            lr0 lr0Var2 = nadMultiSlidingView3.e;
                            if (lr0Var2 != null && (list = lr0Var2.a) != null) {
                                cVar = (lr0.c) CollectionsKt___CollectionsKt.getOrNull(list, this.a.c);
                            } else {
                                cVar = null;
                            }
                            View s = nadMultiSlidingView3.s(cVar);
                            if (s != null) {
                                this.a.m(s);
                            }
                        }
                        if (i == i2) {
                            break;
                        }
                        i++;
                    }
                }
                this.a.j.postDelayed(this, this.a.g + 200);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public NadMultiSlidingView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet, Integer.valueOf(i)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        Intrinsics.checkNotNullParameter(context, "context");
        this.a = 2;
        this.b = (int) (b51.c.e(context) * 0.6d);
        this.f = b51.c.a(context, 12.0f);
        this.g = 800L;
        this.h = 800L;
        this.j = new Handler(Looper.getMainLooper());
        this.k = new f(this);
    }

    public /* synthetic */ NadMultiSlidingView(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    public final void n(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, view2) == null) {
            ValueAnimator r = r(view2);
            ValueAnimator q = q(view2);
            AnimatorSet animatorSet = new AnimatorSet();
            animatorSet.play(r).with(q);
            animatorSet.addListener(new a(this, r, q, view2));
            animatorSet.start();
        }
    }

    public void setActionListener(c21 c21Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, c21Var) == null) {
            this.i = c21Var;
        }
    }

    public void setMaxWidth(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048586, this, i) == null) {
            this.b = i;
        }
    }

    @Override // android.view.View
    public void setVisibility(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048587, this, i) == null) {
            super.setVisibility(i);
        }
    }

    public final void v(long j) {
        int i;
        List<lr0.c> list;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeJ(1048590, this, j) == null) && this.a > 0) {
            lr0 lr0Var = this.e;
            if (lr0Var != null && (list = lr0Var.a) != null) {
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
        lr0.c cVar;
        List<lr0.c> list;
        int i2;
        List<lr0.c> list2;
        List<lr0.c> list3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            lr0 lr0Var = this.e;
            if (lr0Var != null && (list3 = lr0Var.a) != null) {
                i = list3.size();
            } else {
                i = 0;
            }
            if (i < this.a) {
                lr0 lr0Var2 = this.e;
                if (lr0Var2 != null && (list2 = lr0Var2.a) != null) {
                    i2 = list2.size();
                } else {
                    i2 = 0;
                }
                this.a = i2;
            }
            if (this.a <= 0) {
                return;
            }
            int a2 = (int) (this.f + b51.c.a(getContext(), 13.0f));
            if (getLayoutParams() == null) {
                setLayoutParams(new RelativeLayout.LayoutParams(-2, (this.a + 1) * a2));
            } else {
                getLayoutParams().height = (this.a + 1) * a2;
            }
            int i3 = this.a;
            for (int i4 = 0; i4 < i3; i4++) {
                lr0 lr0Var3 = this.e;
                if (lr0Var3 != null && (list = lr0Var3.a) != null) {
                    cVar = (lr0.c) CollectionsKt___CollectionsKt.getOrNull(list, i4);
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
    }

    public final void m(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2) == null) {
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
    }

    public final ValueAnimator r(View view2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, view2)) == null) {
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view2, Key.TRANSLATION_Y, view2.getTranslationY(), view2.getTranslationY() - (this.f + b51.c.a(getContext(), 13.0f)));
            ofFloat.setDuration(200L);
            ofFloat.addListener(new d(view2));
            Intrinsics.checkNotNullExpressionValue(ofFloat, "ObjectAnimator.ofFloat(a…\n            })\n        }");
            return ofFloat;
        }
        return (ValueAnimator) invokeL.objValue;
    }

    public final ValueAnimator o(View view2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, view2)) == null) {
            ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
            ofFloat.setDuration(200L);
            ofFloat.setInterpolator(new LinearInterpolator());
            ofFloat.addUpdateListener(new b(view2));
            Intrinsics.checkNotNullExpressionValue(ofFloat, "ValueAnimator.ofFloat(0F…}\n            }\n        }");
            return ofFloat;
        }
        return (ValueAnimator) invokeL.objValue;
    }

    public final ValueAnimator p(View view2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, view2)) == null) {
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view2, Key.TRANSLATION_Y, this.f + b51.c.a(getContext(), 13.0f), 0.0f);
            ofFloat.setDuration(200L);
            Intrinsics.checkNotNullExpressionValue(ofFloat, "ObjectAnimator.ofFloat(a…LT_RELAY_MILLIS\n        }");
            return ofFloat;
        }
        return (ValueAnimator) invokeL.objValue;
    }

    public final ValueAnimator q(View view2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, view2)) == null) {
            ValueAnimator ofFloat = ValueAnimator.ofFloat(1.0f, 0.0f);
            ofFloat.setDuration(200L);
            ofFloat.setInterpolator(new LinearInterpolator());
            ofFloat.addUpdateListener(new c(view2));
            Intrinsics.checkNotNullExpressionValue(ofFloat, "ValueAnimator.ofFloat(1F…}\n            }\n        }");
            return ofFloat;
        }
        return (ValueAnimator) invokeL.objValue;
    }

    public final View s(lr0.c cVar) {
        InterceptResult invokeL;
        lr0 lr0Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, cVar)) == null) {
            TextView a2 = f21.a(getContext(), cVar);
            if (a2 != null) {
                a2.setId(ViewCompat.generateViewId());
                a2.setTextSize(0, this.f);
                a2.setLayoutParams(new RelativeLayout.LayoutParams(-2, -2));
                a2.setPadding(b51.c.a(a2.getContext(), 10.0f), b51.c.a(a2.getContext(), 4.0f), b51.c.a(a2.getContext(), 10.0f), b51.c.a(a2.getContext(), 4.0f));
                a2.setMaxLines(1);
                a2.setMaxWidth(this.b);
                a2.setSingleLine();
                a2.setEllipsize(TextUtils.TruncateAt.END);
                a2.setGravity(16);
                a2.setIncludeFontPadding(false);
                a2.setVisibility(0);
                if (a2 != null) {
                    lr0 lr0Var2 = this.e;
                    u(a2, (lr0Var2 == null || (r1 = lr0Var2.f) == null) ? "" : "");
                    c21 c21Var = this.i;
                    if (c21Var != null && (lr0Var = this.e) != null) {
                        a2.setOnClickListener(new e(lr0Var, c21Var, this, a2, cVar));
                    }
                    return a2;
                }
                return null;
            }
            return null;
        }
        return (View) invokeL.objValue;
    }

    public void setFontSize(int i, float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048585, this, new Object[]{Integer.valueOf(i), Float.valueOf(f2)}) == null) {
            float f3 = this.f;
            if (f3 == f3) {
                return;
            }
            this.f = f2;
            if (this.d) {
                w(this.e, this.h);
            }
        }
    }

    public final void u(View view2, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048589, this, view2, str) == null) {
            int a2 = y41.a(str, R.color.nad_sliding_multi_bg_color_default);
            Drawable drawable = ContextCompat.getDrawable(getContext(), R.drawable.nad_sliding_multi_bg);
            if (drawable != null) {
                drawable.setColorFilter(new PorterDuffColorFilter(a2, PorterDuff.Mode.SRC_ATOP));
                Unit unit = Unit.INSTANCE;
            } else {
                drawable = null;
            }
            view2.setBackground(drawable);
        }
    }

    public void w(lr0 lr0Var, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLJ(1048591, this, lr0Var, j) == null) {
            t();
            if (lr0Var != null && !lr0Var.a.isEmpty()) {
                this.h = j;
                this.e = lr0Var;
                this.a = RangesKt___RangesKt.coerceAtMost(lr0Var.h, 3);
                this.g = lr0Var.d;
                l();
                v(j);
            }
        }
    }

    public final void t() {
        Animation animation;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
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
}
