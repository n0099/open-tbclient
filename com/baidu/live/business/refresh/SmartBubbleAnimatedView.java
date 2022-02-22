package com.baidu.live.business.refresh;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import c.a.y.g.g.g;
import com.baidu.adp.plugin.PluginCenter;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes10.dex */
public class SmartBubbleAnimatedView extends View {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public long delayDuring;

    /* renamed from: e  reason: collision with root package name */
    public float f35006e;

    /* renamed from: f  reason: collision with root package name */
    public ValueAnimator f35007f;

    /* renamed from: g  reason: collision with root package name */
    public ValueAnimator f35008g;

    /* renamed from: h  reason: collision with root package name */
    public Paint f35009h;

    /* renamed from: i  reason: collision with root package name */
    public Paint f35010i;

    /* renamed from: j  reason: collision with root package name */
    public RectF f35011j;
    public Rect k;
    public e l;
    public int m;
    public boolean n;
    public String tipText;

    /* loaded from: classes10.dex */
    public class a implements ValueAnimator.AnimatorUpdateListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ SmartBubbleAnimatedView f35012e;

        public a(SmartBubbleAnimatedView smartBubbleAnimatedView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {smartBubbleAnimatedView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f35012e = smartBubbleAnimatedView;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, valueAnimator) == null) {
                ViewGroup.LayoutParams layoutParams = this.f35012e.getLayoutParams();
                layoutParams.height = this.f35012e.getResources().getDimensionPixelSize(c.a.y.c.a.a.pull_refresh_1);
                this.f35012e.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                this.f35012e.f35006e = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                if (this.f35012e.n && (layoutParams instanceof LinearLayout.LayoutParams)) {
                    LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) layoutParams;
                    int i2 = layoutParams2.topMargin;
                    if (i2 > 0) {
                        layoutParams2.topMargin = i2 - 5;
                    }
                    if (layoutParams2.topMargin < 0) {
                        layoutParams2.topMargin = 0;
                    }
                }
                this.f35012e.setLayoutParams(layoutParams);
                this.f35012e.requestLayout();
            }
        }
    }

    /* loaded from: classes10.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ SmartBubbleAnimatedView f35013e;

        public b(SmartBubbleAnimatedView smartBubbleAnimatedView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {smartBubbleAnimatedView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f35013e = smartBubbleAnimatedView;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f35013e.playDismissAnimation();
            }
        }
    }

    /* loaded from: classes10.dex */
    public class c implements ValueAnimator.AnimatorUpdateListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ SmartBubbleAnimatedView f35014e;

        public c(SmartBubbleAnimatedView smartBubbleAnimatedView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {smartBubbleAnimatedView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f35014e = smartBubbleAnimatedView;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, valueAnimator) == null) {
                ViewGroup.LayoutParams layoutParams = this.f35014e.getLayoutParams();
                layoutParams.height = (int) (layoutParams.height * ((Float) valueAnimator.getAnimatedValue()).floatValue());
                this.f35014e.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                this.f35014e.setLayoutParams(layoutParams);
                this.f35014e.requestLayout();
            }
        }
    }

    /* loaded from: classes10.dex */
    public class d implements Animator.AnimatorListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ SmartBubbleAnimatedView f35015e;

        public d(SmartBubbleAnimatedView smartBubbleAnimatedView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {smartBubbleAnimatedView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f35015e = smartBubbleAnimatedView;
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, animator) == null) || this.f35015e.l == null) {
                return;
            }
            this.f35015e.l.a();
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, animator) == null) || this.f35015e.l == null) {
                return;
            }
            this.f35015e.l.a();
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

    /* loaded from: classes10.dex */
    public interface e {
        void a();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SmartBubbleAnimatedView(Context context) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.delayDuring = PluginCenter.PLUGIN_RETRY_MIN_TIME_INTERVAL;
        this.f35006e = 0.0f;
        this.f35009h = new Paint();
        this.f35010i = new Paint();
        this.f35011j = new RectF();
        this.k = new Rect();
        this.n = false;
        d(null, 0);
    }

    public final void d(AttributeSet attributeSet, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048576, this, attributeSet, i2) == null) {
            this.f35009h.setColor(-16711681);
            this.f35010i.setColor(-7829368);
            this.f35010i.setTextSize(getResources().getDimensionPixelSize(c.a.y.c.a.a.pull_refresh_2));
            this.m = getResources().getDimensionPixelSize(c.a.y.c.a.a.pull_refresh_1);
        }
    }

    public int getTipViewHeight() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.m : invokeV.intValue;
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, canvas) == null) {
            float height = ((1.0f - this.f35006e) * getHeight()) / 2.0f;
            float width = (getWidth() / 2) + ((this.f35006e * getWidth()) / 2.0f);
            float height2 = (getHeight() / 2) + ((this.f35006e * getHeight()) / 2.0f);
            this.f35011j.set(((1.0f - this.f35006e) * getWidth()) / 2.0f, height, width, height2);
            float f2 = (height2 - height) / 2.0f;
            canvas.drawRoundRect(this.f35011j, f2, f2, this.f35009h);
            Paint paint = this.f35010i;
            String str = this.tipText;
            paint.getTextBounds(str, 0, str.length(), this.k);
            int width2 = this.k.width();
            int height3 = this.k.height();
            String str2 = this.tipText;
            canvas.drawText(str2, 0, str2.length(), (getWidth() - width2) / 2, getHeight() - ((getHeight() - height3) / 2), this.f35010i);
        }
    }

    public void playDismissAnimation() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            if (this.n) {
                e eVar = this.l;
                if (eVar != null) {
                    eVar.a();
                    return;
                }
                return;
            }
            ValueAnimator ofFloat = ValueAnimator.ofFloat(1.0f, 0.0f);
            this.f35008g = ofFloat;
            ofFloat.addUpdateListener(new c(this));
            this.f35008g.addListener(new d(this));
            this.f35008g.setDuration(300L);
            this.f35008g.start();
        }
    }

    public void playExpansionAnimation() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            this.f35007f = ValueAnimator.ofFloat(0.0f, 1.1f);
            if (this.n) {
                ViewGroup.LayoutParams layoutParams = getLayoutParams();
                if (layoutParams instanceof LinearLayout.LayoutParams) {
                    ((LinearLayout.LayoutParams) layoutParams).topMargin = 20;
                    setLayoutParams(layoutParams);
                }
            }
            this.f35007f.addUpdateListener(new a(this));
            this.f35007f.setDuration(400L);
            this.f35007f.start();
            g.a().postDelayed(new b(this), this.delayDuring);
        }
    }

    public void setExtrusionRemind(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048581, this, z) == null) {
            this.n = z;
        }
    }

    public void setOnBubbleAnimateListener(e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, eVar) == null) {
            this.l = eVar;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SmartBubbleAnimatedView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.delayDuring = PluginCenter.PLUGIN_RETRY_MIN_TIME_INTERVAL;
        this.f35006e = 0.0f;
        this.f35009h = new Paint();
        this.f35010i = new Paint();
        this.f35011j = new RectF();
        this.k = new Rect();
        this.n = false;
        d(attributeSet, 0);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SmartBubbleAnimatedView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet, Integer.valueOf(i2)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.delayDuring = PluginCenter.PLUGIN_RETRY_MIN_TIME_INTERVAL;
        this.f35006e = 0.0f;
        this.f35009h = new Paint();
        this.f35010i = new Paint();
        this.f35011j = new RectF();
        this.k = new Rect();
        this.n = false;
        d(attributeSet, i2);
    }
}
