package com.baidu.swan.apps.view.loading;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.annotation.SuppressLint;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.oe3;
import com.tachikoma.core.component.anim.AnimationProperty;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u0011\b\u0016\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u001f\u0010\bB\u0019\b\u0016\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010!\u001a\u00020 ¢\u0006\u0004\b\u001f\u0010\"J\r\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0017\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\u000b\u001a\u00020\u00022\b\u0010\n\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\r\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\r\u0010\u0004R\u0018\u0010\u000f\u001a\u0004\u0018\u00010\u000e8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0018\u0010\u0011\u001a\u0004\u0018\u00010\u000e8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0011\u0010\u0010R*\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u00128\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u0016\u0010\u001a\u001a\u00020\u00198\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0018\u0010\u001d\u001a\u0004\u0018\u00010\u001c8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001d\u0010\u001e¨\u0006#"}, d2 = {"Lcom/baidu/swan/apps/view/loading/SwanLoadingTipsView;", "Landroid/widget/RelativeLayout;", "", "doDestroy", "()V", "Landroid/content/Context;", "context", "init", "(Landroid/content/Context;)V", "", "tips", "startTipsAppearAnimation", "(Ljava/lang/String;)V", "startTipsDisAppearAnimation", "Landroid/animation/ObjectAnimator;", "appearAnimator", "Landroid/animation/ObjectAnimator;", "disAppearAnimator", "Lkotlin/Function0;", "tipsAnimationFinishCallback", "Lkotlin/Function0;", "getTipsAnimationFinishCallback", "()Lkotlin/jvm/functions/Function0;", "setTipsAnimationFinishCallback", "(Lkotlin/jvm/functions/Function0;)V", "Ljava/lang/Runnable;", "tipsDismissRunnable", "Ljava/lang/Runnable;", "Landroid/widget/TextView;", "tipsView", "Landroid/widget/TextView;", "<init>", "Landroid/util/AttributeSet;", "attrs", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "core_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
@SuppressLint({"SwanCommentErr"})
/* loaded from: classes2.dex */
public final class SwanLoadingTipsView extends RelativeLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Function0<Unit> a;
    public TextView b;
    public ObjectAnimator c;
    public ObjectAnimator d;
    public Runnable e;

    /* loaded from: classes2.dex */
    public static final class a implements Animator.AnimatorListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SwanLoadingTipsView a;

        /* JADX DEBUG: Incorrect args count in method signature: ()V */
        public a(SwanLoadingTipsView swanLoadingTipsView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {swanLoadingTipsView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = swanLoadingTipsView;
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, animator) == null) {
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, animator) == null) {
                oe3.b0(this.a.e, 2000L);
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, animator) == null) {
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, animator) == null) {
                this.a.setVisibility(0);
            }
        }
    }

    /* loaded from: classes2.dex */
    public static final class b implements Animator.AnimatorListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SwanLoadingTipsView a;

        /* JADX DEBUG: Incorrect args count in method signature: ()V */
        public b(SwanLoadingTipsView swanLoadingTipsView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {swanLoadingTipsView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = swanLoadingTipsView;
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, animator) == null) {
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, animator) == null) {
                this.a.setVisibility(8);
                Function0<Unit> tipsAnimationFinishCallback = this.a.getTipsAnimationFinishCallback();
                if (tipsAnimationFinishCallback != null) {
                    tipsAnimationFinishCallback.invoke();
                }
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, animator) == null) {
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, animator) == null) {
            }
        }
    }

    /* loaded from: classes2.dex */
    public static final class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SwanLoadingTipsView a;

        public c(SwanLoadingTipsView swanLoadingTipsView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {swanLoadingTipsView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = swanLoadingTipsView;
        }

        @Override // java.lang.Runnable
        public final void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.f();
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SwanLoadingTipsView(Context context) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        Intrinsics.checkNotNullParameter(context, "context");
        this.e = new c(this);
        d(context);
    }

    public final void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.a = null;
            Runnable runnable = this.e;
            if (runnable != null) {
                oe3.d0(runnable);
            }
            ObjectAnimator objectAnimator = this.c;
            if (objectAnimator != null) {
                if (objectAnimator != null) {
                    objectAnimator.removeAllListeners();
                }
                ObjectAnimator objectAnimator2 = this.c;
                if (objectAnimator2 != null) {
                    objectAnimator2.cancel();
                }
                this.c = null;
            }
            ObjectAnimator objectAnimator3 = this.d;
            if (objectAnimator3 != null) {
                if (objectAnimator3 != null) {
                    objectAnimator3.removeAllListeners();
                }
                ObjectAnimator objectAnimator4 = this.d;
                if (objectAnimator4 != null) {
                    objectAnimator4.cancel();
                }
                this.d = null;
            }
        }
    }

    public final void d(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context) == null) {
            View.inflate(context, R.layout.obfuscated_res_0x7f0d00b0, this);
            this.b = (TextView) findViewById(R.id.obfuscated_res_0x7f090191);
        }
    }

    public final void e(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
            if (str == null || str.length() == 0) {
                return;
            }
            TextView textView = this.b;
            if (textView != null) {
                textView.setText(str);
            }
            setVisibility(8);
            ObjectAnimator objectAnimator = this.c;
            if (objectAnimator != null) {
                if (objectAnimator != null) {
                    objectAnimator.removeAllListeners();
                }
                ObjectAnimator objectAnimator2 = this.c;
                if (objectAnimator2 != null) {
                    objectAnimator2.cancel();
                }
            }
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this, AnimationProperty.OPACITY, 0.0f, 1.0f);
            this.c = ofFloat;
            if (ofFloat != null) {
                ofFloat.setDuration(500L);
            }
            ObjectAnimator objectAnimator3 = this.c;
            if (objectAnimator3 != null) {
                objectAnimator3.setStartDelay(1000L);
            }
            ObjectAnimator objectAnimator4 = this.c;
            if (objectAnimator4 != null) {
                objectAnimator4.addListener(new a(this));
            }
            ObjectAnimator objectAnimator5 = this.c;
            if (objectAnimator5 != null) {
                objectAnimator5.start();
            }
        }
    }

    public final void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            ObjectAnimator objectAnimator = this.d;
            if (objectAnimator != null) {
                if (objectAnimator != null) {
                    objectAnimator.removeAllListeners();
                }
                ObjectAnimator objectAnimator2 = this.d;
                if (objectAnimator2 != null) {
                    objectAnimator2.cancel();
                }
            }
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this, AnimationProperty.OPACITY, 1.0f, 0.0f);
            this.d = ofFloat;
            if (ofFloat != null) {
                ofFloat.setDuration(500L);
            }
            ObjectAnimator objectAnimator3 = this.d;
            if (objectAnimator3 != null) {
                objectAnimator3.addListener(new b(this));
            }
            ObjectAnimator objectAnimator4 = this.d;
            if (objectAnimator4 != null) {
                objectAnimator4.start();
            }
        }
    }

    public final Function0<Unit> getTipsAnimationFinishCallback() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.a : (Function0) invokeV.objValue;
    }

    public final void setTipsAnimationFinishCallback(Function0<Unit> function0) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, function0) == null) {
            this.a = function0;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SwanLoadingTipsView(Context context, AttributeSet attrs) {
        super(context, attrs);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attrs};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(attrs, "attrs");
        this.e = new c(this);
        d(context);
    }
}
