package androidx.swiperefreshlayout.widget;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import androidx.core.util.Preconditions;
import androidx.core.view.InputDeviceCompat;
import androidx.interpolator.view.animation.FastOutSlowInInterpolator;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
/* loaded from: classes.dex */
public class CircularProgressDrawable extends Drawable implements Animatable {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int ANIMATION_DURATION = 1332;
    public static final int ARROW_HEIGHT = 5;
    public static final int ARROW_HEIGHT_LARGE = 6;
    public static final int ARROW_WIDTH = 10;
    public static final int ARROW_WIDTH_LARGE = 12;
    public static final float CENTER_RADIUS = 7.5f;
    public static final float CENTER_RADIUS_LARGE = 11.0f;
    public static final int[] COLORS;
    public static final float COLOR_CHANGE_OFFSET = 0.75f;
    public static final int DEFAULT = 1;
    public static final float GROUP_FULL_ROTATION = 216.0f;
    public static final int LARGE = 0;
    public static final Interpolator LINEAR_INTERPOLATOR;
    public static final Interpolator MATERIAL_INTERPOLATOR;
    public static final float MAX_PROGRESS_ARC = 0.8f;
    public static final float MIN_PROGRESS_ARC = 0.01f;
    public static final float RING_ROTATION = 0.20999998f;
    public static final float SHRINK_OFFSET = 0.5f;
    public static final float STROKE_WIDTH = 2.5f;
    public static final float STROKE_WIDTH_LARGE = 3.0f;
    public transient /* synthetic */ FieldHolder $fh;
    public Animator mAnimator;
    public boolean mFinishing;
    public Resources mResources;
    public final Ring mRing;
    public float mRotation;
    public float mRotationCount;

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    /* loaded from: classes.dex */
    public @interface ProgressDrawableSize {
    }

    private int evaluateColorChange(float f, int i, int i2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65539, this, new Object[]{Float.valueOf(f), Integer.valueOf(i), Integer.valueOf(i2)})) == null) {
            int i3 = (i >> 24) & 255;
            int i4 = (i >> 16) & 255;
            int i5 = (i >> 8) & 255;
            int i6 = i & 255;
            return ((i3 + ((int) ((((i2 >> 24) & 255) - i3) * f))) << 24) | ((i4 + ((int) ((((i2 >> 16) & 255) - i4) * f))) << 16) | ((i5 + ((int) ((((i2 >> 8) & 255) - i5) * f))) << 8) | (i6 + ((int) (f * ((i2 & 255) - i6))));
        }
        return invokeCommon.intValue;
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            return -3;
        }
        return invokeV.intValue;
    }

    /* loaded from: classes.dex */
    public static class Ring {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public int mAlpha;
        public Path mArrow;
        public int mArrowHeight;
        public final Paint mArrowPaint;
        public float mArrowScale;
        public int mArrowWidth;
        public final Paint mCirclePaint;
        public int mColorIndex;
        public int[] mColors;
        public int mCurrentColor;
        public float mEndTrim;
        public final Paint mPaint;
        public float mRingCenterRadius;
        public float mRotation;
        public boolean mShowArrow;
        public float mStartTrim;
        public float mStartingEndTrim;
        public float mStartingRotation;
        public float mStartingStartTrim;
        public float mStrokeWidth;
        public final RectF mTempBounds;

        public Ring() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.mTempBounds = new RectF();
            this.mPaint = new Paint();
            this.mArrowPaint = new Paint();
            this.mCirclePaint = new Paint();
            this.mStartTrim = 0.0f;
            this.mEndTrim = 0.0f;
            this.mRotation = 0.0f;
            this.mStrokeWidth = 5.0f;
            this.mArrowScale = 1.0f;
            this.mAlpha = 255;
            this.mPaint.setStrokeCap(Paint.Cap.SQUARE);
            this.mPaint.setAntiAlias(true);
            this.mPaint.setStyle(Paint.Style.STROKE);
            this.mArrowPaint.setStyle(Paint.Style.FILL);
            this.mArrowPaint.setAntiAlias(true);
            this.mCirclePaint.setColor(0);
        }

        public void draw(Canvas canvas, Rect rect) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, canvas, rect) == null) {
                RectF rectF = this.mTempBounds;
                float f = this.mRingCenterRadius;
                float f2 = (this.mStrokeWidth / 2.0f) + f;
                if (f <= 0.0f) {
                    f2 = (Math.min(rect.width(), rect.height()) / 2.0f) - Math.max((this.mArrowWidth * this.mArrowScale) / 2.0f, this.mStrokeWidth / 2.0f);
                }
                rectF.set(rect.centerX() - f2, rect.centerY() - f2, rect.centerX() + f2, rect.centerY() + f2);
                float f3 = this.mStartTrim;
                float f4 = this.mRotation;
                float f5 = (f3 + f4) * 360.0f;
                float f6 = ((this.mEndTrim + f4) * 360.0f) - f5;
                this.mPaint.setColor(this.mCurrentColor);
                this.mPaint.setAlpha(this.mAlpha);
                float f7 = this.mStrokeWidth / 2.0f;
                rectF.inset(f7, f7);
                canvas.drawCircle(rectF.centerX(), rectF.centerY(), rectF.width() / 2.0f, this.mCirclePaint);
                float f8 = -f7;
                rectF.inset(f8, f8);
                canvas.drawArc(rectF, f5, f6, false, this.mPaint);
                drawTriangle(canvas, f5, f6, rectF);
            }
        }

        public void drawTriangle(Canvas canvas, float f, float f2, RectF rectF) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{canvas, Float.valueOf(f), Float.valueOf(f2), rectF}) == null) && this.mShowArrow) {
                Path path = this.mArrow;
                if (path == null) {
                    Path path2 = new Path();
                    this.mArrow = path2;
                    path2.setFillType(Path.FillType.EVEN_ODD);
                } else {
                    path.reset();
                }
                this.mArrow.moveTo(0.0f, 0.0f);
                this.mArrow.lineTo(this.mArrowWidth * this.mArrowScale, 0.0f);
                Path path3 = this.mArrow;
                float f3 = this.mArrowScale;
                path3.lineTo((this.mArrowWidth * f3) / 2.0f, this.mArrowHeight * f3);
                this.mArrow.offset(((Math.min(rectF.width(), rectF.height()) / 2.0f) + rectF.centerX()) - ((this.mArrowWidth * this.mArrowScale) / 2.0f), rectF.centerY() + (this.mStrokeWidth / 2.0f));
                this.mArrow.close();
                this.mArrowPaint.setColor(this.mCurrentColor);
                this.mArrowPaint.setAlpha(this.mAlpha);
                canvas.save();
                canvas.rotate(f + f2, rectF.centerX(), rectF.centerY());
                canvas.drawPath(this.mArrow, this.mArrowPaint);
                canvas.restore();
            }
        }

        public int getAlpha() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                return this.mAlpha;
            }
            return invokeV.intValue;
        }

        public float getArrowHeight() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
                return this.mArrowHeight;
            }
            return invokeV.floatValue;
        }

        public float getArrowScale() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
                return this.mArrowScale;
            }
            return invokeV.floatValue;
        }

        public float getArrowWidth() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
                return this.mArrowWidth;
            }
            return invokeV.floatValue;
        }

        public int getBackgroundColor() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
                return this.mCirclePaint.getColor();
            }
            return invokeV.intValue;
        }

        public float getCenterRadius() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
                return this.mRingCenterRadius;
            }
            return invokeV.floatValue;
        }

        public int[] getColors() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
                return this.mColors;
            }
            return (int[]) invokeV.objValue;
        }

        public float getEndTrim() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
                return this.mEndTrim;
            }
            return invokeV.floatValue;
        }

        public int getNextColor() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
                return this.mColors[getNextColorIndex()];
            }
            return invokeV.intValue;
        }

        public int getNextColorIndex() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
                return (this.mColorIndex + 1) % this.mColors.length;
            }
            return invokeV.intValue;
        }

        public float getRotation() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
                return this.mRotation;
            }
            return invokeV.floatValue;
        }

        public boolean getShowArrow() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
                return this.mShowArrow;
            }
            return invokeV.booleanValue;
        }

        public float getStartTrim() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
                return this.mStartTrim;
            }
            return invokeV.floatValue;
        }

        public int getStartingColor() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
                return this.mColors[this.mColorIndex];
            }
            return invokeV.intValue;
        }

        public float getStartingEndTrim() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
                return this.mStartingEndTrim;
            }
            return invokeV.floatValue;
        }

        public float getStartingRotation() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
                return this.mStartingRotation;
            }
            return invokeV.floatValue;
        }

        public float getStartingStartTrim() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
                return this.mStartingStartTrim;
            }
            return invokeV.floatValue;
        }

        public Paint.Cap getStrokeCap() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) {
                return this.mPaint.getStrokeCap();
            }
            return (Paint.Cap) invokeV.objValue;
        }

        public float getStrokeWidth() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) {
                return this.mStrokeWidth;
            }
            return invokeV.floatValue;
        }

        public void goToNextColor() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048597, this) == null) {
                setColorIndex(getNextColorIndex());
            }
        }

        public void resetOriginals() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048598, this) == null) {
                this.mStartingStartTrim = 0.0f;
                this.mStartingEndTrim = 0.0f;
                this.mStartingRotation = 0.0f;
                setStartTrim(0.0f);
                setEndTrim(0.0f);
                setRotation(0.0f);
            }
        }

        public void storeOriginals() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048614, this) == null) {
                this.mStartingStartTrim = this.mStartTrim;
                this.mStartingEndTrim = this.mEndTrim;
                this.mStartingRotation = this.mRotation;
            }
        }

        public void setAlpha(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048599, this, i) == null) {
                this.mAlpha = i;
            }
        }

        public void setArrowScale(float f) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeF(1048601, this, f) == null) && f != this.mArrowScale) {
                this.mArrowScale = f;
            }
        }

        public void setBackgroundColor(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048602, this, i) == null) {
                this.mCirclePaint.setColor(i);
            }
        }

        public void setCenterRadius(float f) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeF(1048603, this, f) == null) {
                this.mRingCenterRadius = f;
            }
        }

        public void setColor(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048604, this, i) == null) {
                this.mCurrentColor = i;
            }
        }

        public void setColorFilter(ColorFilter colorFilter) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048605, this, colorFilter) == null) {
                this.mPaint.setColorFilter(colorFilter);
            }
        }

        public void setColorIndex(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048606, this, i) == null) {
                this.mColorIndex = i;
                this.mCurrentColor = this.mColors[i];
            }
        }

        public void setColors(@NonNull int[] iArr) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048607, this, iArr) == null) {
                this.mColors = iArr;
                setColorIndex(0);
            }
        }

        public void setEndTrim(float f) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeF(1048608, this, f) == null) {
                this.mEndTrim = f;
            }
        }

        public void setRotation(float f) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeF(1048609, this, f) == null) {
                this.mRotation = f;
            }
        }

        public void setShowArrow(boolean z) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeZ(1048610, this, z) == null) && this.mShowArrow != z) {
                this.mShowArrow = z;
            }
        }

        public void setStartTrim(float f) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeF(1048611, this, f) == null) {
                this.mStartTrim = f;
            }
        }

        public void setStrokeCap(Paint.Cap cap) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048612, this, cap) == null) {
                this.mPaint.setStrokeCap(cap);
            }
        }

        public void setStrokeWidth(float f) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeF(1048613, this, f) == null) {
                this.mStrokeWidth = f;
                this.mPaint.setStrokeWidth(f);
            }
        }

        public void setArrowDimensions(float f, float f2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048600, this, new Object[]{Float.valueOf(f), Float.valueOf(f2)}) == null) {
                this.mArrowWidth = (int) f;
                this.mArrowHeight = (int) f2;
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-292090224, "Landroidx/swiperefreshlayout/widget/CircularProgressDrawable;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-292090224, "Landroidx/swiperefreshlayout/widget/CircularProgressDrawable;");
                return;
            }
        }
        LINEAR_INTERPOLATOR = new LinearInterpolator();
        MATERIAL_INTERPOLATOR = new FastOutSlowInInterpolator();
        COLORS = new int[]{-16777216};
    }

    private void setupAnimators() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65543, this) == null) {
            Ring ring = this.mRing;
            ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
            ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener(this, ring) { // from class: androidx.swiperefreshlayout.widget.CircularProgressDrawable.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ CircularProgressDrawable this$0;
                public final /* synthetic */ Ring val$ring;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, ring};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.this$0 = this;
                    this.val$ring = ring;
                }

                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, valueAnimator) == null) {
                        float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                        this.this$0.updateRingColor(floatValue, this.val$ring);
                        this.this$0.applyTransformation(floatValue, this.val$ring, false);
                        this.this$0.invalidateSelf();
                    }
                }
            });
            ofFloat.setRepeatCount(-1);
            ofFloat.setRepeatMode(1);
            ofFloat.setInterpolator(LINEAR_INTERPOLATOR);
            ofFloat.addListener(new Animator.AnimatorListener(this, ring) { // from class: androidx.swiperefreshlayout.widget.CircularProgressDrawable.2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ CircularProgressDrawable this$0;
                public final /* synthetic */ Ring val$ring;

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationCancel(Animator animator) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, animator) == null) {
                    }
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, animator) == null) {
                    }
                }

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, ring};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.this$0 = this;
                    this.val$ring = ring;
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationRepeat(Animator animator) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(Constants.METHOD_SEND_USER_MSG, this, animator) == null) {
                        this.this$0.applyTransformation(1.0f, this.val$ring, true);
                        this.val$ring.storeOriginals();
                        this.val$ring.goToNextColor();
                        CircularProgressDrawable circularProgressDrawable = this.this$0;
                        if (circularProgressDrawable.mFinishing) {
                            circularProgressDrawable.mFinishing = false;
                            animator.cancel();
                            animator.setDuration(1332L);
                            animator.start();
                            this.val$ring.setShowArrow(false);
                            return;
                        }
                        circularProgressDrawable.mRotationCount += 1.0f;
                    }
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048579, this, animator) == null) {
                        this.this$0.mRotationCount = 0.0f;
                    }
                }
            });
            this.mAnimator = ofFloat;
        }
    }

    public CircularProgressDrawable(@NonNull Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.mResources = ((Context) Preconditions.checkNotNull(context)).getResources();
        Ring ring = new Ring();
        this.mRing = ring;
        ring.setColors(COLORS);
        setStrokeWidth(2.5f);
        setupAnimators();
    }

    private void applyFinishTranslation(float f, Ring ring) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65538, this, new Object[]{Float.valueOf(f), ring}) == null) {
            updateRingColor(f, ring);
            ring.setStartTrim(ring.getStartingStartTrim() + (((ring.getStartingEndTrim() - 0.01f) - ring.getStartingStartTrim()) * f));
            ring.setEndTrim(ring.getStartingEndTrim());
            ring.setRotation(ring.getStartingRotation() + ((((float) (Math.floor(ring.getStartingRotation() / 0.8f) + 1.0d)) - ring.getStartingRotation()) * f));
        }
    }

    private float getRotation() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, this)) == null) {
            return this.mRotation;
        }
        return invokeV.floatValue;
    }

    @Override // android.graphics.drawable.Drawable
    public int getAlpha() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.mRing.getAlpha();
        }
        return invokeV.intValue;
    }

    public boolean getArrowEnabled() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.mRing.getShowArrow();
        }
        return invokeV.booleanValue;
    }

    public float getArrowHeight() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.mRing.getArrowHeight();
        }
        return invokeV.floatValue;
    }

    public float getArrowScale() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return this.mRing.getArrowScale();
        }
        return invokeV.floatValue;
    }

    public float getArrowWidth() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return this.mRing.getArrowWidth();
        }
        return invokeV.floatValue;
    }

    public int getBackgroundColor() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return this.mRing.getBackgroundColor();
        }
        return invokeV.intValue;
    }

    public float getCenterRadius() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return this.mRing.getCenterRadius();
        }
        return invokeV.floatValue;
    }

    @NonNull
    public int[] getColorSchemeColors() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            return this.mRing.getColors();
        }
        return (int[]) invokeV.objValue;
    }

    public float getEndTrim() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            return this.mRing.getEndTrim();
        }
        return invokeV.floatValue;
    }

    public float getProgressRotation() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            return this.mRing.getRotation();
        }
        return invokeV.floatValue;
    }

    public float getStartTrim() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            return this.mRing.getStartTrim();
        }
        return invokeV.floatValue;
    }

    @NonNull
    public Paint.Cap getStrokeCap() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            return this.mRing.getStrokeCap();
        }
        return (Paint.Cap) invokeV.objValue;
    }

    public float getStrokeWidth() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            return this.mRing.getStrokeWidth();
        }
        return invokeV.floatValue;
    }

    @Override // android.graphics.drawable.Animatable
    public boolean isRunning() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            return this.mAnimator.isRunning();
        }
        return invokeV.booleanValue;
    }

    @Override // android.graphics.drawable.Animatable
    public void stop() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048607, this) == null) {
            this.mAnimator.cancel();
            setRotation(0.0f);
            this.mRing.setShowArrow(false);
            this.mRing.setColorIndex(0);
            this.mRing.resetOriginals();
            invalidateSelf();
        }
    }

    private void setRotation(float f) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(65541, this, f) == null) {
            this.mRotation = f;
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, canvas) == null) {
            Rect bounds = getBounds();
            canvas.save();
            canvas.rotate(this.mRotation, bounds.exactCenterX(), bounds.exactCenterY());
            this.mRing.draw(canvas, bounds);
            canvas.restore();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048593, this, i) == null) {
            this.mRing.setAlpha(i);
            invalidateSelf();
        }
    }

    public void setArrowEnabled(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048595, this, z) == null) {
            this.mRing.setShowArrow(z);
            invalidateSelf();
        }
    }

    public void setArrowScale(float f) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048596, this, f) == null) {
            this.mRing.setArrowScale(f);
            invalidateSelf();
        }
    }

    public void setBackgroundColor(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048597, this, i) == null) {
            this.mRing.setBackgroundColor(i);
            invalidateSelf();
        }
    }

    public void setCenterRadius(float f) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048598, this, f) == null) {
            this.mRing.setCenterRadius(f);
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048599, this, colorFilter) == null) {
            this.mRing.setColorFilter(colorFilter);
            invalidateSelf();
        }
    }

    public void setColorSchemeColors(@NonNull int... iArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048600, this, iArr) == null) {
            this.mRing.setColors(iArr);
            this.mRing.setColorIndex(0);
            invalidateSelf();
        }
    }

    public void setProgressRotation(float f) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048601, this, f) == null) {
            this.mRing.setRotation(f);
            invalidateSelf();
        }
    }

    public void setStrokeCap(@NonNull Paint.Cap cap) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048603, this, cap) == null) {
            this.mRing.setStrokeCap(cap);
            invalidateSelf();
        }
    }

    public void setStrokeWidth(float f) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048604, this, f) == null) {
            this.mRing.setStrokeWidth(f);
            invalidateSelf();
        }
    }

    public void setStyle(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048605, this, i) == null) {
            if (i == 0) {
                setSizeParameters(11.0f, 3.0f, 12.0f, 6.0f);
            } else {
                setSizeParameters(7.5f, 2.5f, 10.0f, 5.0f);
            }
            invalidateSelf();
        }
    }

    private void setSizeParameters(float f, float f2, float f3, float f4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65542, this, new Object[]{Float.valueOf(f), Float.valueOf(f2), Float.valueOf(f3), Float.valueOf(f4)}) == null) {
            Ring ring = this.mRing;
            float f5 = this.mResources.getDisplayMetrics().density;
            ring.setStrokeWidth(f2 * f5);
            ring.setCenterRadius(f * f5);
            ring.setColorIndex(0);
            ring.setArrowDimensions(f3 * f5, f4 * f5);
        }
    }

    public void applyTransformation(float f, Ring ring, boolean z) {
        float interpolation;
        float f2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Float.valueOf(f), ring, Boolean.valueOf(z)}) == null) {
            if (this.mFinishing) {
                applyFinishTranslation(f, ring);
            } else if (f != 1.0f || z) {
                float startingRotation = ring.getStartingRotation();
                if (f < 0.5f) {
                    interpolation = ring.getStartingStartTrim();
                    f2 = (MATERIAL_INTERPOLATOR.getInterpolation(f / 0.5f) * 0.79f) + 0.01f + interpolation;
                } else {
                    float startingStartTrim = ring.getStartingStartTrim() + 0.79f;
                    interpolation = startingStartTrim - (((1.0f - MATERIAL_INTERPOLATOR.getInterpolation((f - 0.5f) / 0.5f)) * 0.79f) + 0.01f);
                    f2 = startingStartTrim;
                }
                ring.setStartTrim(interpolation);
                ring.setEndTrim(f2);
                ring.setRotation(startingRotation + (0.20999998f * f));
                setRotation((f + this.mRotationCount) * 216.0f);
            }
        }
    }

    public void setArrowDimensions(float f, float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048594, this, new Object[]{Float.valueOf(f), Float.valueOf(f2)}) == null) {
            this.mRing.setArrowDimensions(f, f2);
            invalidateSelf();
        }
    }

    public void setStartEndTrim(float f, float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048602, this, new Object[]{Float.valueOf(f), Float.valueOf(f2)}) == null) {
            this.mRing.setStartTrim(f);
            this.mRing.setEndTrim(f2);
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Animatable
    public void start() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048606, this) == null) {
            this.mAnimator.cancel();
            this.mRing.storeOriginals();
            if (this.mRing.getEndTrim() != this.mRing.getStartTrim()) {
                this.mFinishing = true;
                this.mAnimator.setDuration(666L);
                this.mAnimator.start();
                return;
            }
            this.mRing.setColorIndex(0);
            this.mRing.resetOriginals();
            this.mAnimator.setDuration(1332L);
            this.mAnimator.start();
        }
    }

    public void updateRingColor(float f, Ring ring) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048608, this, new Object[]{Float.valueOf(f), ring}) == null) {
            if (f > 0.75f) {
                ring.setColor(evaluateColorChange((f - 0.75f) / 0.25f, ring.getStartingColor(), ring.getNextColor()));
            } else {
                ring.setColor(ring.getStartingColor());
            }
        }
    }
}
