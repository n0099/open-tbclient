package androidx.swiperefreshlayout.widget;

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
import androidx.core.content.ContextCompat;
import androidx.core.view.ViewCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes.dex */
public class CircleImageView extends ImageView {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int FILL_SHADOW_COLOR = 1023410176;
    public static final int KEY_SHADOW_COLOR = 503316480;
    public static final int SHADOW_ELEVATION = 4;
    public static final float SHADOW_RADIUS = 3.5f;
    public static final float X_OFFSET = 0.0f;
    public static final float Y_OFFSET = 1.75f;
    public transient /* synthetic */ FieldHolder $fh;
    public Animation.AnimationListener mListener;
    public int mShadowRadius;

    /* loaded from: classes.dex */
    public class OvalShadow extends OvalShape {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public RadialGradient mRadialGradient;
        public Paint mShadowPaint;
        public final /* synthetic */ CircleImageView this$0;

        public OvalShadow(CircleImageView circleImageView, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {circleImageView, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = circleImageView;
            this.mShadowPaint = new Paint();
            circleImageView.mShadowRadius = i;
            updateRadialGradient((int) rect().width());
        }

        private void updateRadialGradient(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(65537, this, i) == null) {
                float f = i / 2;
                RadialGradient radialGradient = new RadialGradient(f, f, this.this$0.mShadowRadius, new int[]{CircleImageView.FILL_SHADOW_COLOR, 0}, (float[]) null, Shader.TileMode.CLAMP);
                this.mRadialGradient = radialGradient;
                this.mShadowPaint.setShader(radialGradient);
            }
        }

        @Override // android.graphics.drawable.shapes.OvalShape, android.graphics.drawable.shapes.RectShape, android.graphics.drawable.shapes.Shape
        public void draw(Canvas canvas, Paint paint) {
            int width;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, canvas, paint) == null) {
                float width2 = this.this$0.getWidth() / 2;
                float height = this.this$0.getHeight() / 2;
                canvas.drawCircle(width2, height, width2, this.mShadowPaint);
                canvas.drawCircle(width2, height, width - this.this$0.mShadowRadius, paint);
            }
        }

        @Override // android.graphics.drawable.shapes.RectShape, android.graphics.drawable.shapes.Shape
        public void onResize(float f, float f2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Float.valueOf(f), Float.valueOf(f2)}) == null) {
                super.onResize(f, f2);
                updateRadialGradient((int) f);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CircleImageView(Context context, int i) {
        super(context);
        ShapeDrawable shapeDrawable;
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, Integer.valueOf(i)};
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
        float f = getContext().getResources().getDisplayMetrics().density;
        int i4 = (int) (1.75f * f);
        int i5 = (int) (0.0f * f);
        this.mShadowRadius = (int) (3.5f * f);
        if (elevationSupported()) {
            shapeDrawable = new ShapeDrawable(new OvalShape());
            ViewCompat.setElevation(this, f * 4.0f);
        } else {
            ShapeDrawable shapeDrawable2 = new ShapeDrawable(new OvalShadow(this, this.mShadowRadius));
            setLayerType(1, shapeDrawable2.getPaint());
            shapeDrawable2.getPaint().setShadowLayer(this.mShadowRadius, i5, i4, KEY_SHADOW_COLOR);
            int i6 = this.mShadowRadius;
            setPadding(i6, i6, i6, i6);
            shapeDrawable = shapeDrawable2;
        }
        shapeDrawable.getPaint().setColor(i);
        ViewCompat.setBackground(this, shapeDrawable);
    }

    private boolean elevationSupported() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65537, this)) == null) ? Build.VERSION.SDK_INT >= 21 : invokeV.booleanValue;
    }

    @Override // android.view.View
    public void onAnimationEnd() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            super.onAnimationEnd();
            Animation.AnimationListener animationListener = this.mListener;
            if (animationListener != null) {
                animationListener.onAnimationEnd(getAnimation());
            }
        }
    }

    @Override // android.view.View
    public void onAnimationStart() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            super.onAnimationStart();
            Animation.AnimationListener animationListener = this.mListener;
            if (animationListener != null) {
                animationListener.onAnimationStart(getAnimation());
            }
        }
    }

    @Override // android.widget.ImageView, android.view.View
    public void onMeasure(int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(Constants.METHOD_SEND_USER_MSG, this, i, i2) == null) {
            super.onMeasure(i, i2);
            if (elevationSupported()) {
                return;
            }
            setMeasuredDimension(getMeasuredWidth() + (this.mShadowRadius * 2), getMeasuredHeight() + (this.mShadowRadius * 2));
        }
    }

    public void setAnimationListener(Animation.AnimationListener animationListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, animationListener) == null) {
            this.mListener = animationListener;
        }
    }

    @Override // android.view.View
    public void setBackgroundColor(int i) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048580, this, i) == null) && (getBackground() instanceof ShapeDrawable)) {
            ((ShapeDrawable) getBackground()).getPaint().setColor(i);
        }
    }

    public void setBackgroundColorRes(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048581, this, i) == null) {
            setBackgroundColor(ContextCompat.getColor(getContext(), i));
        }
    }
}
