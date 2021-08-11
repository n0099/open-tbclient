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
import c.a.v.e.g.g;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class SmartBubbleAnimatedView extends View {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public long delayDuring;

    /* renamed from: e  reason: collision with root package name */
    public float f40586e;

    /* renamed from: f  reason: collision with root package name */
    public ValueAnimator f40587f;

    /* renamed from: g  reason: collision with root package name */
    public ValueAnimator f40588g;

    /* renamed from: h  reason: collision with root package name */
    public Paint f40589h;

    /* renamed from: i  reason: collision with root package name */
    public Paint f40590i;

    /* renamed from: j  reason: collision with root package name */
    public RectF f40591j;
    public Rect k;
    public e l;
    public int m;
    public boolean n;
    public String tipText;

    /* loaded from: classes5.dex */
    public class a implements ValueAnimator.AnimatorUpdateListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ SmartBubbleAnimatedView f40592e;

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
            this.f40592e = smartBubbleAnimatedView;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, valueAnimator) == null) {
                ViewGroup.LayoutParams layoutParams = this.f40592e.getLayoutParams();
                layoutParams.height = this.f40592e.getResources().getDimensionPixelSize(c.a.v.c.a.a.pull_refresh_1);
                this.f40592e.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                this.f40592e.f40586e = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                if (this.f40592e.n && (layoutParams instanceof LinearLayout.LayoutParams)) {
                    LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) layoutParams;
                    int i2 = layoutParams2.topMargin;
                    if (i2 > 0) {
                        layoutParams2.topMargin = i2 - 5;
                    }
                    if (layoutParams2.topMargin < 0) {
                        layoutParams2.topMargin = 0;
                    }
                }
                this.f40592e.setLayoutParams(layoutParams);
                this.f40592e.requestLayout();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ SmartBubbleAnimatedView f40593e;

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
            this.f40593e = smartBubbleAnimatedView;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f40593e.playDismissAnimation();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class c implements ValueAnimator.AnimatorUpdateListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ SmartBubbleAnimatedView f40594e;

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
            this.f40594e = smartBubbleAnimatedView;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, valueAnimator) == null) {
                ViewGroup.LayoutParams layoutParams = this.f40594e.getLayoutParams();
                layoutParams.height = (int) (layoutParams.height * ((Float) valueAnimator.getAnimatedValue()).floatValue());
                this.f40594e.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                this.f40594e.setLayoutParams(layoutParams);
                this.f40594e.requestLayout();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class d implements Animator.AnimatorListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ SmartBubbleAnimatedView f40595e;

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
            this.f40595e = smartBubbleAnimatedView;
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, animator) == null) || this.f40595e.l == null) {
                return;
            }
            this.f40595e.l.a();
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, animator) == null) || this.f40595e.l == null) {
                return;
            }
            this.f40595e.l.a();
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

    /* loaded from: classes5.dex */
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
        this.delayDuring = 4000L;
        this.f40586e = 0.0f;
        this.f40589h = new Paint();
        this.f40590i = new Paint();
        this.f40591j = new RectF();
        this.k = new Rect();
        this.n = false;
        d(null, 0);
    }

    public final void d(AttributeSet attributeSet, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048576, this, attributeSet, i2) == null) {
            this.f40589h.setColor(-16711681);
            this.f40590i.setColor(-7829368);
            this.f40590i.setTextSize(getResources().getDimensionPixelSize(c.a.v.c.a.a.pull_refresh_2));
            this.m = getResources().getDimensionPixelSize(c.a.v.c.a.a.pull_refresh_1);
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
            float height = ((1.0f - this.f40586e) * getHeight()) / 2.0f;
            float width = (getWidth() / 2) + ((this.f40586e * getWidth()) / 2.0f);
            float height2 = (getHeight() / 2) + ((this.f40586e * getHeight()) / 2.0f);
            this.f40591j.set(((1.0f - this.f40586e) * getWidth()) / 2.0f, height, width, height2);
            float f2 = (height2 - height) / 2.0f;
            canvas.drawRoundRect(this.f40591j, f2, f2, this.f40589h);
            Paint paint = this.f40590i;
            String str = this.tipText;
            paint.getTextBounds(str, 0, str.length(), this.k);
            int width2 = this.k.width();
            int height3 = this.k.height();
            String str2 = this.tipText;
            canvas.drawText(str2, 0, str2.length(), (getWidth() - width2) / 2, getHeight() - ((getHeight() - height3) / 2), this.f40590i);
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
            this.f40588g = ofFloat;
            ofFloat.addUpdateListener(new c(this));
            this.f40588g.addListener(new d(this));
            this.f40588g.setDuration(300L);
            this.f40588g.start();
        }
    }

    public void playExpansionAnimation() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            this.f40587f = ValueAnimator.ofFloat(0.0f, 1.1f);
            if (this.n) {
                ViewGroup.LayoutParams layoutParams = getLayoutParams();
                if (layoutParams instanceof LinearLayout.LayoutParams) {
                    ((LinearLayout.LayoutParams) layoutParams).topMargin = 20;
                    setLayoutParams(layoutParams);
                }
            }
            this.f40587f.addUpdateListener(new a(this));
            this.f40587f.setDuration(400L);
            this.f40587f.start();
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
        this.delayDuring = 4000L;
        this.f40586e = 0.0f;
        this.f40589h = new Paint();
        this.f40590i = new Paint();
        this.f40591j = new RectF();
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
        this.delayDuring = 4000L;
        this.f40586e = 0.0f;
        this.f40589h = new Paint();
        this.f40590i = new Paint();
        this.f40591j = new RectF();
        this.k = new Rect();
        this.n = false;
        d(attributeSet, i2);
    }
}
