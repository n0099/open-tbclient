package com.baidu.adp.widget.refresh;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RadialGradient;
import android.graphics.Shader;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.OvalShape;
import android.os.Build;
import android.view.animation.Animation;
import android.widget.ImageView;
import androidx.core.view.ViewCompat;
import androidx.swiperefreshlayout.widget.CircleImageView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public class BdCircleImageView extends ImageView {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public Animation.AnimationListener f30094e;

    /* renamed from: f  reason: collision with root package name */
    public int f30095f;

    /* loaded from: classes3.dex */
    public class a extends OvalShape {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public RadialGradient f30096e;

        /* renamed from: f  reason: collision with root package name */
        public Paint f30097f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ BdCircleImageView f30098g;

        public a(BdCircleImageView bdCircleImageView, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bdCircleImageView, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f30098g = bdCircleImageView;
            this.f30097f = new Paint();
            bdCircleImageView.f30095f = i2;
            a((int) rect().width());
        }

        public final void a(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i2) == null) {
                float f2 = i2 / 2;
                RadialGradient radialGradient = new RadialGradient(f2, f2, this.f30098g.f30095f, new int[]{CircleImageView.FILL_SHADOW_COLOR, 0}, (float[]) null, Shader.TileMode.CLAMP);
                this.f30096e = radialGradient;
                this.f30097f.setShader(radialGradient);
            }
        }

        @Override // android.graphics.drawable.shapes.OvalShape, android.graphics.drawable.shapes.RectShape, android.graphics.drawable.shapes.Shape
        public void draw(Canvas canvas, Paint paint) {
            int width;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, canvas, paint) == null) {
                float width2 = this.f30098g.getWidth() / 2;
                float height = this.f30098g.getHeight() / 2;
                canvas.drawCircle(width2, height, width2, this.f30097f);
                canvas.drawCircle(width2, height, width - this.f30098g.f30095f, paint);
            }
        }

        @Override // android.graphics.drawable.shapes.RectShape, android.graphics.drawable.shapes.Shape
        public void onResize(float f2, float f3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Float.valueOf(f2), Float.valueOf(f3)}) == null) {
                super.onResize(f2, f3);
                a((int) f2);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BdCircleImageView(Context context, int i2) {
        super(context);
        ShapeDrawable shapeDrawable;
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, Integer.valueOf(i2)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        float f2 = getContext().getResources().getDisplayMetrics().density;
        int i5 = (int) (1.75f * f2);
        int i6 = (int) (0.0f * f2);
        this.f30095f = (int) (3.5f * f2);
        if (a()) {
            shapeDrawable = new ShapeDrawable(new OvalShape());
            ViewCompat.setElevation(this, f2 * 4.0f);
        } else {
            ShapeDrawable shapeDrawable2 = new ShapeDrawable(new a(this, this.f30095f));
            ViewCompat.setLayerType(this, 1, shapeDrawable2.getPaint());
            shapeDrawable2.getPaint().setShadowLayer(this.f30095f, i6, i5, CircleImageView.KEY_SHADOW_COLOR);
            int i7 = this.f30095f;
            setPadding(i7, i7, i7, i7);
            shapeDrawable = shapeDrawable2;
        }
        shapeDrawable.getPaint().setColor(i2);
        setBackgroundDrawable(shapeDrawable);
    }

    public final boolean a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? Build.VERSION.SDK_INT >= 21 : invokeV.booleanValue;
    }

    @Override // android.view.View
    public void onAnimationEnd() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            super.onAnimationEnd();
            Animation.AnimationListener animationListener = this.f30094e;
            if (animationListener != null) {
                animationListener.onAnimationEnd(getAnimation());
            }
        }
    }

    @Override // android.view.View
    public void onAnimationStart() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            super.onAnimationStart();
            Animation.AnimationListener animationListener = this.f30094e;
            if (animationListener != null) {
                animationListener.onAnimationStart(getAnimation());
            }
        }
    }

    @Override // android.widget.ImageView, android.view.View
    public void onMeasure(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048579, this, i2, i3) == null) {
            super.onMeasure(i2, i3);
            if (a()) {
                return;
            }
            setMeasuredDimension(getMeasuredWidth() + (this.f30095f * 2), getMeasuredHeight() + (this.f30095f * 2));
        }
    }

    public void setAnimationListener(Animation.AnimationListener animationListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, animationListener) == null) {
            this.f30094e = animationListener;
        }
    }

    @Override // android.view.View
    public void setBackgroundColor(int i2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048581, this, i2) == null) && (getBackground() instanceof ShapeDrawable)) {
            ((ShapeDrawable) getBackground()).getPaint().setColor(i2);
        }
    }

    public void setBackgroundColorRes(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048582, this, i2) == null) {
            setBackgroundColor(getContext().getResources().getColor(i2));
        }
    }
}
