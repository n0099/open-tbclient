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
import c.a.v.f.g.g;
import com.baidu.adp.plugin.PluginCenter;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public class SmartBubbleAnimatedView extends View {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String a;

    /* renamed from: b  reason: collision with root package name */
    public long f25745b;

    /* renamed from: c  reason: collision with root package name */
    public float f25746c;

    /* renamed from: d  reason: collision with root package name */
    public ValueAnimator f25747d;

    /* renamed from: e  reason: collision with root package name */
    public ValueAnimator f25748e;

    /* renamed from: f  reason: collision with root package name */
    public Paint f25749f;

    /* renamed from: g  reason: collision with root package name */
    public Paint f25750g;

    /* renamed from: h  reason: collision with root package name */
    public RectF f25751h;
    public Rect i;
    public e j;
    public int k;
    public boolean l;

    /* loaded from: classes3.dex */
    public class a implements ValueAnimator.AnimatorUpdateListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SmartBubbleAnimatedView a;

        public a(SmartBubbleAnimatedView smartBubbleAnimatedView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {smartBubbleAnimatedView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = smartBubbleAnimatedView;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, valueAnimator) == null) {
                ViewGroup.LayoutParams layoutParams = this.a.getLayoutParams();
                layoutParams.height = this.a.getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f0705a2);
                this.a.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                this.a.f25746c = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                if (this.a.l && (layoutParams instanceof LinearLayout.LayoutParams)) {
                    LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) layoutParams;
                    int i = layoutParams2.topMargin;
                    if (i > 0) {
                        layoutParams2.topMargin = i - 5;
                    }
                    if (layoutParams2.topMargin < 0) {
                        layoutParams2.topMargin = 0;
                    }
                }
                this.a.setLayoutParams(layoutParams);
                this.a.requestLayout();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SmartBubbleAnimatedView a;

        public b(SmartBubbleAnimatedView smartBubbleAnimatedView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {smartBubbleAnimatedView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = smartBubbleAnimatedView;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.e();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class c implements ValueAnimator.AnimatorUpdateListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SmartBubbleAnimatedView a;

        public c(SmartBubbleAnimatedView smartBubbleAnimatedView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {smartBubbleAnimatedView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = smartBubbleAnimatedView;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, valueAnimator) == null) {
                ViewGroup.LayoutParams layoutParams = this.a.getLayoutParams();
                layoutParams.height = (int) (layoutParams.height * ((Float) valueAnimator.getAnimatedValue()).floatValue());
                this.a.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                this.a.setLayoutParams(layoutParams);
                this.a.requestLayout();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class d implements Animator.AnimatorListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SmartBubbleAnimatedView a;

        public d(SmartBubbleAnimatedView smartBubbleAnimatedView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {smartBubbleAnimatedView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = smartBubbleAnimatedView;
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, animator) == null) || this.a.j == null) {
                return;
            }
            this.a.j.a();
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, animator) == null) || this.a.j == null) {
                return;
            }
            this.a.j.a();
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

    /* loaded from: classes3.dex */
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f25745b = PluginCenter.PLUGIN_RETRY_MIN_TIME_INTERVAL;
        this.f25746c = 0.0f;
        this.f25749f = new Paint();
        this.f25750g = new Paint();
        this.f25751h = new RectF();
        this.i = new Rect();
        this.l = false;
        d(null, 0);
    }

    public final void d(AttributeSet attributeSet, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048576, this, attributeSet, i) == null) {
            this.f25749f.setColor(-16711681);
            this.f25750g.setColor(-7829368);
            this.f25750g.setTextSize(getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f0705a3));
            this.k = getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f0705a2);
        }
    }

    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            if (this.l) {
                e eVar = this.j;
                if (eVar != null) {
                    eVar.a();
                    return;
                }
                return;
            }
            ValueAnimator ofFloat = ValueAnimator.ofFloat(1.0f, 0.0f);
            this.f25748e = ofFloat;
            ofFloat.addUpdateListener(new c(this));
            this.f25748e.addListener(new d(this));
            this.f25748e.setDuration(300L);
            this.f25748e.start();
        }
    }

    public void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.f25747d = ValueAnimator.ofFloat(0.0f, 1.1f);
            if (this.l) {
                ViewGroup.LayoutParams layoutParams = getLayoutParams();
                if (layoutParams instanceof LinearLayout.LayoutParams) {
                    ((LinearLayout.LayoutParams) layoutParams).topMargin = 20;
                    setLayoutParams(layoutParams);
                }
            }
            this.f25747d.addUpdateListener(new a(this));
            this.f25747d.setDuration(400L);
            this.f25747d.start();
            g.a().postDelayed(new b(this), this.f25745b);
        }
    }

    public int getTipViewHeight() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.k : invokeV.intValue;
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, canvas) == null) {
            float height = ((1.0f - this.f25746c) * getHeight()) / 2.0f;
            float width = (getWidth() / 2) + ((this.f25746c * getWidth()) / 2.0f);
            float height2 = (getHeight() / 2) + ((this.f25746c * getHeight()) / 2.0f);
            this.f25751h.set(((1.0f - this.f25746c) * getWidth()) / 2.0f, height, width, height2);
            float f2 = (height2 - height) / 2.0f;
            canvas.drawRoundRect(this.f25751h, f2, f2, this.f25749f);
            Paint paint = this.f25750g;
            String str = this.a;
            paint.getTextBounds(str, 0, str.length(), this.i);
            int width2 = this.i.width();
            int height3 = this.i.height();
            String str2 = this.a;
            canvas.drawText(str2, 0, str2.length(), (getWidth() - width2) / 2, getHeight() - ((getHeight() - height3) / 2), this.f25750g);
        }
    }

    public void setExtrusionRemind(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048581, this, z) == null) {
            this.l = z;
        }
    }

    public void setOnBubbleAnimateListener(e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, eVar) == null) {
            this.j = eVar;
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
        this.f25745b = PluginCenter.PLUGIN_RETRY_MIN_TIME_INTERVAL;
        this.f25746c = 0.0f;
        this.f25749f = new Paint();
        this.f25750g = new Paint();
        this.f25751h = new RectF();
        this.i = new Rect();
        this.l = false;
        d(attributeSet, 0);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SmartBubbleAnimatedView(Context context, AttributeSet attributeSet, int i) {
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
        this.f25745b = PluginCenter.PLUGIN_RETRY_MIN_TIME_INTERVAL;
        this.f25746c = 0.0f;
        this.f25749f = new Paint();
        this.f25750g = new Paint();
        this.f25751h = new RectF();
        this.i = new Rect();
        this.l = false;
        d(attributeSet, i);
    }
}
