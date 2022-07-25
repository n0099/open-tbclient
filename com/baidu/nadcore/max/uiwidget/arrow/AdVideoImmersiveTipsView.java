package com.baidu.nadcore.max.uiwidget.arrow;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.nadcore.widget.uiwidget.ExpandIconView;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.f11;
import com.repackage.q01;
import java.util.Arrays;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 =2\u00020\u0001:\u0001=B'\b\u0007\u0012\u0006\u00107\u001a\u000206\u0012\n\b\u0002\u00109\u001a\u0004\u0018\u000108\u0012\b\b\u0002\u0010:\u001a\u00020\u0002¢\u0006\u0004\b;\u0010<J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u000b\u0010\u0006J\u000f\u0010\f\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000e\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u000e\u0010\rJ\u001d\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0010\u0010\u0011J\u0015\u0010\u0012\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\u0012\u0010\nJ\r\u0010\u0013\u001a\u00020\u0004¢\u0006\u0004\b\u0013\u0010\rJ\u000f\u0010\u0014\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0014\u0010\rJ\u001d\u0010\u0018\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0017\u001a\u00020\u0015¢\u0006\u0004\b\u0018\u0010\u0019J\u0015\u0010\u001a\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u0002¢\u0006\u0004\b\u001a\u0010\u0006J\u0015\u0010\u001b\u001a\u00020\u00042\u0006\u0010\u0017\u001a\u00020\u0015¢\u0006\u0004\b\u001b\u0010\u001cR$\u0010\u001e\u001a\u0004\u0018\u00010\u001d8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R\u0016\u0010$\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b$\u0010%R$\u0010&\u001a\u0004\u0018\u00010\u001d8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b&\u0010\u001f\u001a\u0004\b'\u0010!\"\u0004\b(\u0010#R\u001c\u0010)\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e¢\u0006\f\n\u0004\b)\u0010%\u0012\u0004\b*\u0010\rR\u0018\u0010,\u001a\u0004\u0018\u00010+8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b,\u0010-R\u0016\u0010.\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b.\u0010%R$\u00100\u001a\u0004\u0018\u00010/8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b0\u00101\u001a\u0004\b2\u00103\"\u0004\b4\u00105¨\u0006>"}, d2 = {"Lcom/baidu/nadcore/max/uiwidget/arrow/AdVideoImmersiveTipsView;", "Landroid/widget/FrameLayout;", "", "type", "", "cancelArrowAnim", "(I)V", "", "fraction", "changeBottomMargin", "(F)V", "doArrowAnim", "doDefaultAnim", "()V", "doLightPieAnim", "time", "initGuideArrowAnim", "(II)V", "onScroll", "release", "resetAnim", "", "visible", "withAnim", "setTipsVisible", "(ZZ)V", "startCountDown", "stopCountDown", "(Z)V", "Lcom/baidu/nadcore/utils/UniversalCountDownTimer;", "animTimer", "Lcom/baidu/nadcore/utils/UniversalCountDownTimer;", "getAnimTimer", "()Lcom/baidu/nadcore/utils/UniversalCountDownTimer;", "setAnimTimer", "(Lcom/baidu/nadcore/utils/UniversalCountDownTimer;)V", "arrowVideoMargin", "I", "countDownTimer", "getCountDownTimer", "setCountDownTimer", "guideAnimType", "getGuideAnimType$annotations", "Landroid/animation/ObjectAnimator;", "guideTipAnimator", "Landroid/animation/ObjectAnimator;", "guideTipTime", "Landroid/view/View$OnClickListener;", "outClickListener", "Landroid/view/View$OnClickListener;", "getOutClickListener", "()Landroid/view/View$OnClickListener;", "setOutClickListener", "(Landroid/view/View$OnClickListener;)V", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "Companion", "nadcore-lib-business"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes2.dex */
public final class AdVideoImmersiveTipsView extends FrameLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public f11 a;
    public f11 b;
    public ObjectAnimator c;
    public int d;
    public View.OnClickListener e;
    public int f;
    public HashMap g;

    /* loaded from: classes2.dex */
    public static final class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AdVideoImmersiveTipsView a;

        public a(AdVideoImmersiveTipsView adVideoImmersiveTipsView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {adVideoImmersiveTipsView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = adVideoImmersiveTipsView;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view2) {
            View.OnClickListener outClickListener;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view2) == null) || (outClickListener = this.a.getOutClickListener()) == null) {
                return;
            }
            outClickListener.onClick((ExpandIconView) this.a.a(R.id.obfuscated_res_0x7f0902a2));
        }
    }

    /* loaded from: classes2.dex */
    public static final class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ImageView a;
        public final /* synthetic */ AdVideoImmersiveTipsView b;

        public b(ImageView imageView, AdVideoImmersiveTipsView adVideoImmersiveTipsView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {imageView, adVideoImmersiveTipsView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = imageView;
            this.b = adVideoImmersiveTipsView;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view2) {
            View.OnClickListener outClickListener;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view2) == null) || (outClickListener = this.b.getOutClickListener()) == null) {
                return;
            }
            outClickListener.onClick(this.a);
        }
    }

    /* loaded from: classes2.dex */
    public static final class c implements Animation.AnimationListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AdVideoImmersiveTipsView a;

        /* loaded from: classes2.dex */
        public static final class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ c a;

            /* renamed from: com.baidu.nadcore.max.uiwidget.arrow.AdVideoImmersiveTipsView$c$a$a  reason: collision with other inner class name */
            /* loaded from: classes2.dex */
            public static final class C0118a extends AnimatorListenerAdapter {
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ a a;

                /* JADX DEBUG: Incorrect args count in method signature: ()V */
                public C0118a(a aVar) {
                    Interceptable interceptable = $ic;
                    if (interceptable != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {aVar};
                        interceptable.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.a = aVar;
                }

                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    Interceptable interceptable = $ic;
                    if (interceptable == null || interceptable.invokeL(1048576, this, animator) == null) {
                        ImageView arrowPieImage = (ImageView) this.a.a.a.a(R.id.obfuscated_res_0x7f0902a3);
                        Intrinsics.checkNotNullExpressionValue(arrowPieImage, "arrowPieImage");
                        arrowPieImage.setVisibility(8);
                    }
                }
            }

            public a(c cVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {cVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = cVar;
            }

            @Override // java.lang.Runnable
            public final void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    ImageView arrowPieImage = (ImageView) this.a.a.a(R.id.obfuscated_res_0x7f0902a3);
                    Intrinsics.checkNotNullExpressionValue(arrowPieImage, "arrowPieImage");
                    if (arrowPieImage.getVisibility() == 0) {
                        ObjectAnimator duration = ObjectAnimator.ofFloat((ImageView) this.a.a.a(R.id.obfuscated_res_0x7f0902a3), "alpha", 1.0f).setDuration(500L);
                        Intrinsics.checkNotNullExpressionValue(duration, "ObjectAnimator.ofFloat(a…on(DEFUALT_ANIM_DURATION)");
                        duration.setFloatValues(1.0f, 0.0f);
                        duration.addListener(new C0118a(this));
                        duration.start();
                    }
                    ExpandIconView arrowImage = (ExpandIconView) this.a.a.a(R.id.obfuscated_res_0x7f0902a2);
                    Intrinsics.checkNotNullExpressionValue(arrowImage, "arrowImage");
                    arrowImage.setVisibility(0);
                }
            }
        }

        /* JADX DEBUG: Incorrect args count in method signature: ()V */
        public c(AdVideoImmersiveTipsView adVideoImmersiveTipsView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {adVideoImmersiveTipsView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = adVideoImmersiveTipsView;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, animation) == null) {
                this.a.postDelayed(new a(this), 2000L);
            }
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, animation) == null) {
            }
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, animation) == null) {
            }
        }
    }

    /* loaded from: classes2.dex */
    public static final class d extends f11.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AdVideoImmersiveTipsView a;
        public final /* synthetic */ int b;

        public d(AdVideoImmersiveTipsView adVideoImmersiveTipsView, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {adVideoImmersiveTipsView, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = adVideoImmersiveTipsView;
            this.b = i;
        }

        @Override // com.repackage.f11.b
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.e(this.b);
                f11 animTimer = this.a.getAnimTimer();
                if (animTimer != null) {
                    animTimer.a();
                }
                this.a.setAnimTimer(null);
            }
        }
    }

    /* loaded from: classes2.dex */
    public static final class e extends AnimatorListenerAdapter {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AdVideoImmersiveTipsView a;

        /* JADX DEBUG: Incorrect args count in method signature: ()V */
        public e(AdVideoImmersiveTipsView adVideoImmersiveTipsView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {adVideoImmersiveTipsView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = adVideoImmersiveTipsView;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, animator) == null) {
                TextView guideText = (TextView) this.a.a(R.id.obfuscated_res_0x7f090ca9);
                Intrinsics.checkNotNullExpressionValue(guideText, "guideText");
                guideText.setVisibility(8);
            }
        }
    }

    /* loaded from: classes2.dex */
    public static final class f extends f11.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AdVideoImmersiveTipsView a;

        /* JADX DEBUG: Incorrect args count in method signature: ()V */
        public f(AdVideoImmersiveTipsView adVideoImmersiveTipsView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {adVideoImmersiveTipsView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = adVideoImmersiveTipsView;
        }

        @Override // com.repackage.f11.b
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.setTipsVisible(false, true);
            }
        }

        @Override // com.repackage.f11.b
        public void e() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                this.a.setTipsVisible(true, true);
            }
        }

        @Override // com.repackage.f11.b
        public void f(long j) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeJ(Constants.METHOD_SEND_USER_MSG, this, j) == null) {
                TextView guideText = (TextView) this.a.a(R.id.obfuscated_res_0x7f090ca9);
                Intrinsics.checkNotNullExpressionValue(guideText, "guideText");
                StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
                Context context = this.a.getContext();
                Intrinsics.checkNotNullExpressionValue(context, "context");
                String string = context.getResources().getString(R.string.obfuscated_res_0x7f0f0b97);
                Intrinsics.checkNotNullExpressionValue(string, "context.resources.getStr…_max_countdown_tips_text)");
                String format = String.format(string, Arrays.copyOf(new Object[]{Long.valueOf(j / 1000)}, 1));
                Intrinsics.checkNotNullExpressionValue(format, "java.lang.String.format(format, *args)");
                guideText.setText(format);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1962275478, "Lcom/baidu/nadcore/max/uiwidget/arrow/AdVideoImmersiveTipsView;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1962275478, "Lcom/baidu/nadcore/max/uiwidget/arrow/AdVideoImmersiveTipsView;");
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public AdVideoImmersiveTipsView(Context context) {
        this(context, null, 0, 6, null);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
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

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public AdVideoImmersiveTipsView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet};
            interceptable.invokeUnInit(65538, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue(), ((Integer) objArr2[3]).intValue(), (DefaultConstructorMarker) objArr2[4]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public AdVideoImmersiveTipsView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet, Integer.valueOf(i)};
            interceptable.invokeUnInit(65539, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65539, newInitContext);
                return;
            }
        }
        Intrinsics.checkNotNullParameter(context, "context");
        LayoutInflater.from(context).inflate(R.layout.obfuscated_res_0x7f0d05c7, this);
        ((ExpandIconView) a(R.id.obfuscated_res_0x7f0902a2)).setOnClickListener(new a(this));
        ((ExpandIconView) a(R.id.obfuscated_res_0x7f0902a2)).setState(1, true);
    }

    public static /* synthetic */ void getGuideAnimType$annotations() {
    }

    public View a(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i)) == null) {
            if (this.g == null) {
                this.g = new HashMap();
            }
            View view2 = (View) this.g.get(Integer.valueOf(i));
            if (view2 == null) {
                View findViewById = findViewById(i);
                this.g.put(Integer.valueOf(i), findViewById);
                return findViewById;
            }
            return view2;
        }
        return (View) invokeI.objValue;
    }

    public final void c(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i) == null) {
            if (i == 0) {
                ((ExpandIconView) a(R.id.obfuscated_res_0x7f0902a2)).clearAnimation();
            } else if (i != 1) {
            } else {
                ((ExpandIconView) a(R.id.obfuscated_res_0x7f0902a2)).clearAnimation();
                ((ImageView) a(R.id.obfuscated_res_0x7f0902a3)).clearAnimation();
            }
        }
    }

    public final void d(float f2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeF(Constants.METHOD_SEND_USER_MSG, this, f2) == null) || Math.abs(f2) < 0.6f) {
            return;
        }
        float abs = (Math.abs(f2) - 0.6f) / 0.39999998f;
        int a2 = q01.c.a(getContext(), -4.0f);
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        if (!(layoutParams instanceof FrameLayout.LayoutParams)) {
            layoutParams = null;
        }
        FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) layoutParams;
        if (layoutParams2 != null) {
            layoutParams2.bottomMargin = a2 + ((int) (abs * (this.f - a2)));
        }
        setLayoutParams(layoutParams2);
    }

    public final void e(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048579, this, i) == null) {
            if (i == 0) {
                f();
            } else if (i != 1) {
            } else {
                ImageView imageView = (ImageView) a(R.id.obfuscated_res_0x7f0902a3);
                imageView.setOnClickListener(new b(imageView, this));
                g();
            }
        }
    }

    public final void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            ImageView arrowPieImage = (ImageView) a(R.id.obfuscated_res_0x7f0902a3);
            Intrinsics.checkNotNullExpressionValue(arrowPieImage, "arrowPieImage");
            if (arrowPieImage.getVisibility() == 0) {
                ImageView arrowPieImage2 = (ImageView) a(R.id.obfuscated_res_0x7f0902a3);
                Intrinsics.checkNotNullExpressionValue(arrowPieImage2, "arrowPieImage");
                arrowPieImage2.setVisibility(8);
            }
            ExpandIconView arrowImage = (ExpandIconView) a(R.id.obfuscated_res_0x7f0902a2);
            Intrinsics.checkNotNullExpressionValue(arrowImage, "arrowImage");
            if (arrowImage.getVisibility() != 0) {
                ExpandIconView arrowImage2 = (ExpandIconView) a(R.id.obfuscated_res_0x7f0902a2);
                Intrinsics.checkNotNullExpressionValue(arrowImage2, "arrowImage");
                arrowImage2.setVisibility(0);
            }
            ((ExpandIconView) a(R.id.obfuscated_res_0x7f0902a2)).startAnimation(AnimationUtils.loadAnimation(getContext(), R.anim.obfuscated_res_0x7f0100a1));
        }
    }

    public final void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            ExpandIconView arrowImage = (ExpandIconView) a(R.id.obfuscated_res_0x7f0902a2);
            Intrinsics.checkNotNullExpressionValue(arrowImage, "arrowImage");
            if (arrowImage.getVisibility() == 0) {
                ExpandIconView arrowImage2 = (ExpandIconView) a(R.id.obfuscated_res_0x7f0902a2);
                Intrinsics.checkNotNullExpressionValue(arrowImage2, "arrowImage");
                arrowImage2.setVisibility(8);
            }
            ImageView arrowPieImage = (ImageView) a(R.id.obfuscated_res_0x7f0902a3);
            Intrinsics.checkNotNullExpressionValue(arrowPieImage, "arrowPieImage");
            if (arrowPieImage.getVisibility() != 0) {
                ImageView arrowPieImage2 = (ImageView) a(R.id.obfuscated_res_0x7f0902a3);
                Intrinsics.checkNotNullExpressionValue(arrowPieImage2, "arrowPieImage");
                arrowPieImage2.setVisibility(0);
            }
            Animation loadAnimation = AnimationUtils.loadAnimation(getContext(), R.anim.obfuscated_res_0x7f0100a2);
            if (loadAnimation != null) {
                loadAnimation.setAnimationListener(new c(this));
            }
            ((ImageView) a(R.id.obfuscated_res_0x7f0902a3)).startAnimation(loadAnimation);
        }
    }

    public final f11 getAnimTimer() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.b : (f11) invokeV.objValue;
    }

    public final f11 getCountDownTimer() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.a : (f11) invokeV.objValue;
    }

    public final View.OnClickListener getOutClickListener() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.e : (View.OnClickListener) invokeV.objValue;
    }

    public final void h(int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048585, this, i, i2) == null) {
            this.d = i2;
            if (i < 0) {
                return;
            }
            if (i == 0) {
                e(i2);
            } else {
                if (i == 1 && i2 == 1) {
                    ExpandIconView arrowImage = (ExpandIconView) a(R.id.obfuscated_res_0x7f0902a2);
                    Intrinsics.checkNotNullExpressionValue(arrowImage, "arrowImage");
                    arrowImage.setVisibility(8);
                }
                if (this.b != null) {
                    return;
                }
                f11 f11Var = new f11(i * 1000, 1000L);
                f11Var.d(new d(this, i2));
                this.b = f11Var;
                if (f11Var != null) {
                    f11Var.e();
                }
            }
            ViewGroup.LayoutParams layoutParams = getLayoutParams();
            if (!(layoutParams instanceof FrameLayout.LayoutParams)) {
                layoutParams = null;
            }
            FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) layoutParams;
            this.f = layoutParams2 != null ? layoutParams2.bottomMargin : 0;
        }
    }

    public final void i(float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048586, this, f2) == null) {
            float max = Math.max(Math.min(f2, 1.0f), -1.0f);
            ((ExpandIconView) a(R.id.obfuscated_res_0x7f0902a2)).setFraction(max, false);
            d(max);
        }
    }

    public final void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            k();
            f11 f11Var = this.b;
            if (f11Var != null) {
                f11Var.a();
            }
            this.b = null;
            f11 f11Var2 = this.a;
            if (f11Var2 != null) {
                f11Var2.a();
            }
            this.a = null;
        }
    }

    public final void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            if (this.c != null) {
                this.c = null;
            }
            c(this.d);
        }
    }

    public final void l(int i) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048589, this, i) == null) && this.a == null) {
            f11 f11Var = new f11(i * 1000, 1000L);
            f11Var.d(new f(this));
            this.a = f11Var;
            if (f11Var != null) {
                f11Var.e();
            }
        }
    }

    public final void m(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048590, this, z) == null) {
            f11 f11Var = this.a;
            if (f11Var != null) {
                f11Var.a();
            }
            TextView guideText = (TextView) a(R.id.obfuscated_res_0x7f090ca9);
            Intrinsics.checkNotNullExpressionValue(guideText, "guideText");
            if (guideText.getVisibility() == 0) {
                setTipsVisible(false, z);
            }
        }
    }

    public final void setAnimTimer(f11 f11Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, f11Var) == null) {
            this.b = f11Var;
        }
    }

    public final void setCountDownTimer(f11 f11Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, f11Var) == null) {
            this.a = f11Var;
        }
    }

    public final void setOutClickListener(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, onClickListener) == null) {
            this.e = onClickListener;
        }
    }

    public final void setTipsVisible(boolean z, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048594, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
            int i = z ? 0 : 8;
            TextView guideText = (TextView) a(R.id.obfuscated_res_0x7f090ca9);
            Intrinsics.checkNotNullExpressionValue(guideText, "guideText");
            if (guideText.getVisibility() == i) {
                return;
            }
            if (!z2) {
                TextView guideText2 = (TextView) a(R.id.obfuscated_res_0x7f090ca9);
                Intrinsics.checkNotNullExpressionValue(guideText2, "guideText");
                guideText2.setVisibility(i);
                return;
            }
            ObjectAnimator objectAnimator = this.c;
            if (objectAnimator != null ? objectAnimator.isRunning() : false) {
                ObjectAnimator objectAnimator2 = this.c;
                if (objectAnimator2 != null) {
                    objectAnimator2.cancel();
                }
                this.c = null;
            }
            ObjectAnimator duration = ObjectAnimator.ofFloat((TextView) a(R.id.obfuscated_res_0x7f090ca9), "alpha", 1.0f).setDuration(500L);
            this.c = duration;
            if (z) {
                if (duration != null) {
                    duration.setFloatValues(0.0f, 1.0f);
                }
                TextView guideText3 = (TextView) a(R.id.obfuscated_res_0x7f090ca9);
                Intrinsics.checkNotNullExpressionValue(guideText3, "guideText");
                guideText3.setVisibility(0);
            } else {
                if (duration != null) {
                    duration.setFloatValues(1.0f, 0.0f);
                }
                ObjectAnimator objectAnimator3 = this.c;
                if (objectAnimator3 != null) {
                    objectAnimator3.addListener(new e(this));
                }
            }
            ObjectAnimator objectAnimator4 = this.c;
            if (objectAnimator4 != null) {
                objectAnimator4.start();
            }
        }
    }

    public /* synthetic */ AdVideoImmersiveTipsView(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }
}
