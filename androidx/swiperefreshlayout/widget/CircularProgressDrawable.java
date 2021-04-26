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
import androidx.interpolator.view.animation.FastOutSlowInInterpolator;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
/* loaded from: classes.dex */
public class CircularProgressDrawable extends Drawable implements Animatable {
    public static final int ANIMATION_DURATION = 1332;
    public static final int ARROW_HEIGHT = 5;
    public static final int ARROW_HEIGHT_LARGE = 6;
    public static final int ARROW_WIDTH = 10;
    public static final int ARROW_WIDTH_LARGE = 12;
    public static final float CENTER_RADIUS = 7.5f;
    public static final float CENTER_RADIUS_LARGE = 11.0f;
    public static final float COLOR_CHANGE_OFFSET = 0.75f;
    public static final int DEFAULT = 1;
    public static final float GROUP_FULL_ROTATION = 216.0f;
    public static final int LARGE = 0;
    public static final float MAX_PROGRESS_ARC = 0.8f;
    public static final float MIN_PROGRESS_ARC = 0.01f;
    public static final float RING_ROTATION = 0.20999998f;
    public static final float SHRINK_OFFSET = 0.5f;
    public static final float STROKE_WIDTH = 2.5f;
    public static final float STROKE_WIDTH_LARGE = 3.0f;
    public Animator mAnimator;
    public boolean mFinishing;
    public Resources mResources;
    public final Ring mRing;
    public float mRotation;
    public float mRotationCount;
    public static final Interpolator LINEAR_INTERPOLATOR = new LinearInterpolator();
    public static final Interpolator MATERIAL_INTERPOLATOR = new FastOutSlowInInterpolator();
    public static final int[] COLORS = {-16777216};

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    /* loaded from: classes.dex */
    public @interface ProgressDrawableSize {
    }

    /* loaded from: classes.dex */
    public static class Ring {
        public Path mArrow;
        public int mArrowHeight;
        public int mArrowWidth;
        public int mColorIndex;
        public int[] mColors;
        public int mCurrentColor;
        public float mRingCenterRadius;
        public boolean mShowArrow;
        public float mStartingEndTrim;
        public float mStartingRotation;
        public float mStartingStartTrim;
        public final RectF mTempBounds = new RectF();
        public final Paint mPaint = new Paint();
        public final Paint mArrowPaint = new Paint();
        public final Paint mCirclePaint = new Paint();
        public float mStartTrim = 0.0f;
        public float mEndTrim = 0.0f;
        public float mRotation = 0.0f;
        public float mStrokeWidth = 5.0f;
        public float mArrowScale = 1.0f;
        public int mAlpha = 255;

        public Ring() {
            this.mPaint.setStrokeCap(Paint.Cap.SQUARE);
            this.mPaint.setAntiAlias(true);
            this.mPaint.setStyle(Paint.Style.STROKE);
            this.mArrowPaint.setStyle(Paint.Style.FILL);
            this.mArrowPaint.setAntiAlias(true);
            this.mCirclePaint.setColor(0);
        }

        public void draw(Canvas canvas, Rect rect) {
            RectF rectF = this.mTempBounds;
            float f2 = this.mRingCenterRadius;
            float f3 = (this.mStrokeWidth / 2.0f) + f2;
            if (f2 <= 0.0f) {
                f3 = (Math.min(rect.width(), rect.height()) / 2.0f) - Math.max((this.mArrowWidth * this.mArrowScale) / 2.0f, this.mStrokeWidth / 2.0f);
            }
            rectF.set(rect.centerX() - f3, rect.centerY() - f3, rect.centerX() + f3, rect.centerY() + f3);
            float f4 = this.mStartTrim;
            float f5 = this.mRotation;
            float f6 = (f4 + f5) * 360.0f;
            float f7 = ((this.mEndTrim + f5) * 360.0f) - f6;
            this.mPaint.setColor(this.mCurrentColor);
            this.mPaint.setAlpha(this.mAlpha);
            float f8 = this.mStrokeWidth / 2.0f;
            rectF.inset(f8, f8);
            canvas.drawCircle(rectF.centerX(), rectF.centerY(), rectF.width() / 2.0f, this.mCirclePaint);
            float f9 = -f8;
            rectF.inset(f9, f9);
            canvas.drawArc(rectF, f6, f7, false, this.mPaint);
            drawTriangle(canvas, f6, f7, rectF);
        }

        public void drawTriangle(Canvas canvas, float f2, float f3, RectF rectF) {
            if (this.mShowArrow) {
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
                float f4 = this.mArrowScale;
                path3.lineTo((this.mArrowWidth * f4) / 2.0f, this.mArrowHeight * f4);
                this.mArrow.offset(((Math.min(rectF.width(), rectF.height()) / 2.0f) + rectF.centerX()) - ((this.mArrowWidth * this.mArrowScale) / 2.0f), rectF.centerY() + (this.mStrokeWidth / 2.0f));
                this.mArrow.close();
                this.mArrowPaint.setColor(this.mCurrentColor);
                this.mArrowPaint.setAlpha(this.mAlpha);
                canvas.save();
                canvas.rotate(f2 + f3, rectF.centerX(), rectF.centerY());
                canvas.drawPath(this.mArrow, this.mArrowPaint);
                canvas.restore();
            }
        }

        public int getAlpha() {
            return this.mAlpha;
        }

        public float getArrowHeight() {
            return this.mArrowHeight;
        }

        public float getArrowScale() {
            return this.mArrowScale;
        }

        public float getArrowWidth() {
            return this.mArrowWidth;
        }

        public int getBackgroundColor() {
            return this.mCirclePaint.getColor();
        }

        public float getCenterRadius() {
            return this.mRingCenterRadius;
        }

        public int[] getColors() {
            return this.mColors;
        }

        public float getEndTrim() {
            return this.mEndTrim;
        }

        public int getNextColor() {
            return this.mColors[getNextColorIndex()];
        }

        public int getNextColorIndex() {
            return (this.mColorIndex + 1) % this.mColors.length;
        }

        public float getRotation() {
            return this.mRotation;
        }

        public boolean getShowArrow() {
            return this.mShowArrow;
        }

        public float getStartTrim() {
            return this.mStartTrim;
        }

        public int getStartingColor() {
            return this.mColors[this.mColorIndex];
        }

        public float getStartingEndTrim() {
            return this.mStartingEndTrim;
        }

        public float getStartingRotation() {
            return this.mStartingRotation;
        }

        public float getStartingStartTrim() {
            return this.mStartingStartTrim;
        }

        public Paint.Cap getStrokeCap() {
            return this.mPaint.getStrokeCap();
        }

        public float getStrokeWidth() {
            return this.mStrokeWidth;
        }

        public void goToNextColor() {
            setColorIndex(getNextColorIndex());
        }

        public void resetOriginals() {
            this.mStartingStartTrim = 0.0f;
            this.mStartingEndTrim = 0.0f;
            this.mStartingRotation = 0.0f;
            setStartTrim(0.0f);
            setEndTrim(0.0f);
            setRotation(0.0f);
        }

        public void setAlpha(int i2) {
            this.mAlpha = i2;
        }

        public void setArrowDimensions(float f2, float f3) {
            this.mArrowWidth = (int) f2;
            this.mArrowHeight = (int) f3;
        }

        public void setArrowScale(float f2) {
            if (f2 != this.mArrowScale) {
                this.mArrowScale = f2;
            }
        }

        public void setBackgroundColor(int i2) {
            this.mCirclePaint.setColor(i2);
        }

        public void setCenterRadius(float f2) {
            this.mRingCenterRadius = f2;
        }

        public void setColor(int i2) {
            this.mCurrentColor = i2;
        }

        public void setColorFilter(ColorFilter colorFilter) {
            this.mPaint.setColorFilter(colorFilter);
        }

        public void setColorIndex(int i2) {
            this.mColorIndex = i2;
            this.mCurrentColor = this.mColors[i2];
        }

        public void setColors(@NonNull int[] iArr) {
            this.mColors = iArr;
            setColorIndex(0);
        }

        public void setEndTrim(float f2) {
            this.mEndTrim = f2;
        }

        public void setRotation(float f2) {
            this.mRotation = f2;
        }

        public void setShowArrow(boolean z) {
            if (this.mShowArrow != z) {
                this.mShowArrow = z;
            }
        }

        public void setStartTrim(float f2) {
            this.mStartTrim = f2;
        }

        public void setStrokeCap(Paint.Cap cap) {
            this.mPaint.setStrokeCap(cap);
        }

        public void setStrokeWidth(float f2) {
            this.mStrokeWidth = f2;
            this.mPaint.setStrokeWidth(f2);
        }

        public void storeOriginals() {
            this.mStartingStartTrim = this.mStartTrim;
            this.mStartingEndTrim = this.mEndTrim;
            this.mStartingRotation = this.mRotation;
        }
    }

    public CircularProgressDrawable(@NonNull Context context) {
        this.mResources = ((Context) Preconditions.checkNotNull(context)).getResources();
        Ring ring = new Ring();
        this.mRing = ring;
        ring.setColors(COLORS);
        setStrokeWidth(2.5f);
        setupAnimators();
    }

    private void applyFinishTranslation(float f2, Ring ring) {
        updateRingColor(f2, ring);
        ring.setStartTrim(ring.getStartingStartTrim() + (((ring.getStartingEndTrim() - 0.01f) - ring.getStartingStartTrim()) * f2));
        ring.setEndTrim(ring.getStartingEndTrim());
        ring.setRotation(ring.getStartingRotation() + ((((float) (Math.floor(ring.getStartingRotation() / 0.8f) + 1.0d)) - ring.getStartingRotation()) * f2));
    }

    private int evaluateColorChange(float f2, int i2, int i3) {
        int i4 = (i2 >> 24) & 255;
        int i5 = (i2 >> 16) & 255;
        int i6 = (i2 >> 8) & 255;
        int i7 = i2 & 255;
        return ((i4 + ((int) ((((i3 >> 24) & 255) - i4) * f2))) << 24) | ((i5 + ((int) ((((i3 >> 16) & 255) - i5) * f2))) << 16) | ((i6 + ((int) ((((i3 >> 8) & 255) - i6) * f2))) << 8) | (i7 + ((int) (f2 * ((i3 & 255) - i7))));
    }

    private float getRotation() {
        return this.mRotation;
    }

    private void setRotation(float f2) {
        this.mRotation = f2;
    }

    private void setSizeParameters(float f2, float f3, float f4, float f5) {
        Ring ring = this.mRing;
        float f6 = this.mResources.getDisplayMetrics().density;
        ring.setStrokeWidth(f3 * f6);
        ring.setCenterRadius(f2 * f6);
        ring.setColorIndex(0);
        ring.setArrowDimensions(f4 * f6, f5 * f6);
    }

    private void setupAnimators() {
        final Ring ring = this.mRing;
        ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: androidx.swiperefreshlayout.widget.CircularProgressDrawable.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                CircularProgressDrawable.this.updateRingColor(floatValue, ring);
                CircularProgressDrawable.this.applyTransformation(floatValue, ring, false);
                CircularProgressDrawable.this.invalidateSelf();
            }
        });
        ofFloat.setRepeatCount(-1);
        ofFloat.setRepeatMode(1);
        ofFloat.setInterpolator(LINEAR_INTERPOLATOR);
        ofFloat.addListener(new Animator.AnimatorListener() { // from class: androidx.swiperefreshlayout.widget.CircularProgressDrawable.2
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
                CircularProgressDrawable.this.applyTransformation(1.0f, ring, true);
                ring.storeOriginals();
                ring.goToNextColor();
                CircularProgressDrawable circularProgressDrawable = CircularProgressDrawable.this;
                if (circularProgressDrawable.mFinishing) {
                    circularProgressDrawable.mFinishing = false;
                    animator.cancel();
                    animator.setDuration(1332L);
                    animator.start();
                    ring.setShowArrow(false);
                    return;
                }
                circularProgressDrawable.mRotationCount += 1.0f;
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                CircularProgressDrawable.this.mRotationCount = 0.0f;
            }
        });
        this.mAnimator = ofFloat;
    }

    public void applyTransformation(float f2, Ring ring, boolean z) {
        float interpolation;
        float f3;
        if (this.mFinishing) {
            applyFinishTranslation(f2, ring);
        } else if (f2 != 1.0f || z) {
            float startingRotation = ring.getStartingRotation();
            if (f2 < 0.5f) {
                interpolation = ring.getStartingStartTrim();
                f3 = (MATERIAL_INTERPOLATOR.getInterpolation(f2 / 0.5f) * 0.79f) + 0.01f + interpolation;
            } else {
                float startingStartTrim = ring.getStartingStartTrim() + 0.79f;
                interpolation = startingStartTrim - (((1.0f - MATERIAL_INTERPOLATOR.getInterpolation((f2 - 0.5f) / 0.5f)) * 0.79f) + 0.01f);
                f3 = startingStartTrim;
            }
            ring.setStartTrim(interpolation);
            ring.setEndTrim(f3);
            ring.setRotation(startingRotation + (0.20999998f * f2));
            setRotation((f2 + this.mRotationCount) * 216.0f);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        Rect bounds = getBounds();
        canvas.save();
        canvas.rotate(this.mRotation, bounds.exactCenterX(), bounds.exactCenterY());
        this.mRing.draw(canvas, bounds);
        canvas.restore();
    }

    @Override // android.graphics.drawable.Drawable
    public int getAlpha() {
        return this.mRing.getAlpha();
    }

    public boolean getArrowEnabled() {
        return this.mRing.getShowArrow();
    }

    public float getArrowHeight() {
        return this.mRing.getArrowHeight();
    }

    public float getArrowScale() {
        return this.mRing.getArrowScale();
    }

    public float getArrowWidth() {
        return this.mRing.getArrowWidth();
    }

    public int getBackgroundColor() {
        return this.mRing.getBackgroundColor();
    }

    public float getCenterRadius() {
        return this.mRing.getCenterRadius();
    }

    @NonNull
    public int[] getColorSchemeColors() {
        return this.mRing.getColors();
    }

    public float getEndTrim() {
        return this.mRing.getEndTrim();
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    public float getProgressRotation() {
        return this.mRing.getRotation();
    }

    public float getStartTrim() {
        return this.mRing.getStartTrim();
    }

    @NonNull
    public Paint.Cap getStrokeCap() {
        return this.mRing.getStrokeCap();
    }

    public float getStrokeWidth() {
        return this.mRing.getStrokeWidth();
    }

    @Override // android.graphics.drawable.Animatable
    public boolean isRunning() {
        return this.mAnimator.isRunning();
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i2) {
        this.mRing.setAlpha(i2);
        invalidateSelf();
    }

    public void setArrowDimensions(float f2, float f3) {
        this.mRing.setArrowDimensions(f2, f3);
        invalidateSelf();
    }

    public void setArrowEnabled(boolean z) {
        this.mRing.setShowArrow(z);
        invalidateSelf();
    }

    public void setArrowScale(float f2) {
        this.mRing.setArrowScale(f2);
        invalidateSelf();
    }

    public void setBackgroundColor(int i2) {
        this.mRing.setBackgroundColor(i2);
        invalidateSelf();
    }

    public void setCenterRadius(float f2) {
        this.mRing.setCenterRadius(f2);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        this.mRing.setColorFilter(colorFilter);
        invalidateSelf();
    }

    public void setColorSchemeColors(@NonNull int... iArr) {
        this.mRing.setColors(iArr);
        this.mRing.setColorIndex(0);
        invalidateSelf();
    }

    public void setProgressRotation(float f2) {
        this.mRing.setRotation(f2);
        invalidateSelf();
    }

    public void setStartEndTrim(float f2, float f3) {
        this.mRing.setStartTrim(f2);
        this.mRing.setEndTrim(f3);
        invalidateSelf();
    }

    public void setStrokeCap(@NonNull Paint.Cap cap) {
        this.mRing.setStrokeCap(cap);
        invalidateSelf();
    }

    public void setStrokeWidth(float f2) {
        this.mRing.setStrokeWidth(f2);
        invalidateSelf();
    }

    public void setStyle(int i2) {
        if (i2 == 0) {
            setSizeParameters(11.0f, 3.0f, 12.0f, 6.0f);
        } else {
            setSizeParameters(7.5f, 2.5f, 10.0f, 5.0f);
        }
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Animatable
    public void start() {
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

    @Override // android.graphics.drawable.Animatable
    public void stop() {
        this.mAnimator.cancel();
        setRotation(0.0f);
        this.mRing.setShowArrow(false);
        this.mRing.setColorIndex(0);
        this.mRing.resetOriginals();
        invalidateSelf();
    }

    public void updateRingColor(float f2, Ring ring) {
        if (f2 > 0.75f) {
            ring.setColor(evaluateColorChange((f2 - 0.75f) / 0.25f, ring.getStartingColor(), ring.getNextColor()));
        } else {
            ring.setColor(ring.getStartingColor());
        }
    }
}
