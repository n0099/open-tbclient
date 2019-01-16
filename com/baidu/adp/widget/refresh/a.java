package com.baidu.adp.widget.refresh;

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
import android.support.annotation.NonNull;
import android.support.v4.view.animation.FastOutSlowInInterpolator;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import android.view.animation.Transformation;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class a extends Drawable implements Animatable {
    private double Rg;
    private double Rh;
    private Animation mAnimation;
    boolean mFinishing;
    private View mParent;
    private Resources mResources;
    private float mRotation;
    float mRotationCount;
    private static final Interpolator LINEAR_INTERPOLATOR = new LinearInterpolator();
    static final Interpolator MATERIAL_INTERPOLATOR = new FastOutSlowInInterpolator();
    private static final int[] COLORS = {-16777216};
    private final ArrayList<Animation> mAnimators = new ArrayList<>();
    private final Drawable.Callback mCallback = new Drawable.Callback() { // from class: com.baidu.adp.widget.refresh.a.3
        @Override // android.graphics.drawable.Drawable.Callback
        public void invalidateDrawable(Drawable drawable) {
            a.this.invalidateSelf();
        }

        @Override // android.graphics.drawable.Drawable.Callback
        public void scheduleDrawable(Drawable drawable, Runnable runnable, long j) {
            a.this.scheduleSelf(runnable, j);
        }

        @Override // android.graphics.drawable.Drawable.Callback
        public void unscheduleDrawable(Drawable drawable, Runnable runnable) {
            a.this.unscheduleSelf(runnable);
        }
    };
    private final C0028a Rf = new C0028a(this.mCallback);

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(Context context, View view) {
        this.mParent = view;
        this.mResources = context.getResources();
        this.Rf.setColors(COLORS);
        bu(1);
        setupAnimators();
    }

    private void a(double d, double d2, double d3, double d4, float f, float f2) {
        C0028a c0028a = this.Rf;
        float f3 = this.mResources.getDisplayMetrics().density;
        this.Rg = f3 * d;
        this.Rh = f3 * d2;
        c0028a.setStrokeWidth(((float) d4) * f3);
        c0028a.d(f3 * d3);
        c0028a.setColorIndex(0);
        c0028a.setArrowDimensions(f * f3, f3 * f2);
        c0028a.u((int) this.Rg, (int) this.Rh);
    }

    public void bu(int i) {
        if (i == 0) {
            a(56.0d, 56.0d, 12.5d, 3.0d, 12.0f, 6.0f);
        } else {
            a(40.0d, 40.0d, 8.75d, 2.5d, 10.0f, 5.0f);
        }
    }

    public void az(boolean z) {
        this.Rf.setShowArrow(z);
    }

    public void setArrowScale(float f) {
        this.Rf.setArrowScale(f);
    }

    public void setStartEndTrim(float f, float f2) {
        this.Rf.setStartTrim(f);
        this.Rf.setEndTrim(f2);
    }

    public void setProgressRotation(float f) {
        this.Rf.setRotation(f);
    }

    public void setBackgroundColor(int i) {
        this.Rf.setBackgroundColor(i);
    }

    public void setColorSchemeColors(int... iArr) {
        this.Rf.setColors(iArr);
        this.Rf.setColorIndex(0);
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return (int) this.Rh;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return (int) this.Rg;
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        Rect bounds = getBounds();
        int save = canvas.save();
        canvas.rotate(this.mRotation, bounds.exactCenterX(), bounds.exactCenterY());
        this.Rf.draw(canvas, bounds);
        canvas.restoreToCount(save);
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i) {
        this.Rf.setAlpha(i);
    }

    @Override // android.graphics.drawable.Drawable
    public int getAlpha() {
        return this.Rf.getAlpha();
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        this.Rf.setColorFilter(colorFilter);
    }

    void setRotation(float f) {
        this.mRotation = f;
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    @Override // android.graphics.drawable.Animatable
    public boolean isRunning() {
        ArrayList<Animation> arrayList = this.mAnimators;
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            Animation animation = arrayList.get(i);
            if (animation.hasStarted() && !animation.hasEnded()) {
                return true;
            }
        }
        return false;
    }

    @Override // android.graphics.drawable.Animatable
    public void start() {
        this.mAnimation.reset();
        this.Rf.storeOriginals();
        if (this.Rf.getEndTrim() != this.Rf.getStartTrim()) {
            this.mFinishing = true;
            this.mAnimation.setDuration(666L);
            this.mParent.startAnimation(this.mAnimation);
            return;
        }
        this.Rf.setColorIndex(0);
        this.Rf.resetOriginals();
        this.mAnimation.setDuration(1332L);
        this.mParent.startAnimation(this.mAnimation);
    }

    @Override // android.graphics.drawable.Animatable
    public void stop() {
        this.mParent.clearAnimation();
        setRotation(0.0f);
        this.Rf.setShowArrow(false);
        this.Rf.setColorIndex(0);
        this.Rf.resetOriginals();
    }

    float a(C0028a c0028a) {
        return (float) Math.toRadians(c0028a.getStrokeWidth() / (6.283185307179586d * c0028a.pi()));
    }

    private int evaluateColorChange(float f, int i, int i2) {
        int intValue = Integer.valueOf(i).intValue();
        int i3 = (intValue >> 24) & 255;
        int i4 = (intValue >> 16) & 255;
        int i5 = (intValue >> 8) & 255;
        int i6 = intValue & 255;
        int intValue2 = Integer.valueOf(i2).intValue();
        return (i6 + ((int) (((intValue2 & 255) - i6) * f))) | ((i3 + ((int) ((((intValue2 >> 24) & 255) - i3) * f))) << 24) | ((i4 + ((int) ((((intValue2 >> 16) & 255) - i4) * f))) << 16) | ((((int) ((((intValue2 >> 8) & 255) - i5) * f)) + i5) << 8);
    }

    void a(float f, C0028a c0028a) {
        if (f > 0.75f) {
            c0028a.setColor(evaluateColorChange((f - 0.75f) / 0.25f, c0028a.getStartingColor(), c0028a.getNextColor()));
        }
    }

    void b(float f, C0028a c0028a) {
        a(f, c0028a);
        float a = a(c0028a);
        c0028a.setStartTrim((((c0028a.getStartingEndTrim() - a) - c0028a.getStartingStartTrim()) * f) + c0028a.getStartingStartTrim());
        c0028a.setEndTrim(c0028a.getStartingEndTrim());
        c0028a.setRotation(((((float) (Math.floor(c0028a.getStartingRotation() / 0.8f) + 1.0d)) - c0028a.getStartingRotation()) * f) + c0028a.getStartingRotation());
    }

    private void setupAnimators() {
        final C0028a c0028a = this.Rf;
        Animation animation = new Animation() { // from class: com.baidu.adp.widget.refresh.a.1
            @Override // android.view.animation.Animation
            public void applyTransformation(float f, Transformation transformation) {
                if (a.this.mFinishing) {
                    a.this.b(f, c0028a);
                    return;
                }
                float a = a.this.a(c0028a);
                float startingEndTrim = c0028a.getStartingEndTrim();
                float startingStartTrim = c0028a.getStartingStartTrim();
                float startingRotation = c0028a.getStartingRotation();
                a.this.a(f, c0028a);
                if (f <= 0.5f) {
                    c0028a.setStartTrim(startingStartTrim + (a.MATERIAL_INTERPOLATOR.getInterpolation(f / 0.5f) * (0.8f - a)));
                }
                if (f > 0.5f) {
                    c0028a.setEndTrim(((0.8f - a) * a.MATERIAL_INTERPOLATOR.getInterpolation((f - 0.5f) / 0.5f)) + startingEndTrim);
                }
                c0028a.setRotation((0.25f * f) + startingRotation);
                a.this.setRotation((216.0f * f) + (1080.0f * (a.this.mRotationCount / 5.0f)));
            }
        };
        animation.setRepeatCount(-1);
        animation.setRepeatMode(1);
        animation.setInterpolator(LINEAR_INTERPOLATOR);
        animation.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.adp.widget.refresh.a.2
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation2) {
                a.this.mRotationCount = 0.0f;
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation2) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation2) {
                c0028a.storeOriginals();
                c0028a.goToNextColor();
                c0028a.setStartTrim(c0028a.getEndTrim());
                if (a.this.mFinishing) {
                    a.this.mFinishing = false;
                    animation2.setDuration(1332L);
                    c0028a.setShowArrow(false);
                    return;
                }
                a.this.mRotationCount = (a.this.mRotationCount + 1.0f) % 5.0f;
            }
        });
        this.mAnimation = animation;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.adp.widget.refresh.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0028a {
        private double Rl;
        private int mAlpha;
        private Path mArrow;
        private int mArrowHeight;
        private float mArrowScale;
        private int mArrowWidth;
        private int mBackgroundColor;
        private final Drawable.Callback mCallback;
        private int mColorIndex;
        private int[] mColors;
        private int mCurrentColor;
        private boolean mShowArrow;
        private float mStartingEndTrim;
        private float mStartingRotation;
        private float mStartingStartTrim;
        private final RectF mTempBounds = new RectF();
        private final Paint mPaint = new Paint();
        private final Paint mArrowPaint = new Paint();
        private float mStartTrim = 0.0f;
        private float mEndTrim = 0.0f;
        private float mRotation = 0.0f;
        private float mStrokeWidth = 5.0f;
        private float Rk = 2.5f;
        private final Paint mCirclePaint = new Paint(1);

        C0028a(Drawable.Callback callback) {
            this.mCallback = callback;
            this.mPaint.setStrokeCap(Paint.Cap.SQUARE);
            this.mPaint.setAntiAlias(true);
            this.mPaint.setStyle(Paint.Style.STROKE);
            this.mArrowPaint.setStyle(Paint.Style.FILL);
            this.mArrowPaint.setAntiAlias(true);
        }

        public void setBackgroundColor(int i) {
            this.mBackgroundColor = i;
        }

        public void setArrowDimensions(float f, float f2) {
            this.mArrowWidth = (int) f;
            this.mArrowHeight = (int) f2;
        }

        public void draw(Canvas canvas, Rect rect) {
            RectF rectF = this.mTempBounds;
            rectF.set(rect);
            rectF.inset(this.Rk, this.Rk);
            float f = (this.mStartTrim + this.mRotation) * 360.0f;
            float f2 = ((this.mEndTrim + this.mRotation) * 360.0f) - f;
            this.mPaint.setColor(this.mCurrentColor);
            canvas.drawArc(rectF, f, f2, false, this.mPaint);
            a(canvas, f, f2, rect);
            if (this.mAlpha < 255) {
                this.mCirclePaint.setColor(this.mBackgroundColor);
                this.mCirclePaint.setAlpha(255 - this.mAlpha);
                canvas.drawCircle(rect.exactCenterX(), rect.exactCenterY(), rect.width() / 2, this.mCirclePaint);
            }
        }

        private void a(Canvas canvas, float f, float f2, Rect rect) {
            if (this.mShowArrow) {
                if (this.mArrow == null) {
                    this.mArrow = new Path();
                    this.mArrow.setFillType(Path.FillType.EVEN_ODD);
                } else {
                    this.mArrow.reset();
                }
                float f3 = (((int) this.Rk) / 2) * this.mArrowScale;
                float cos = (float) ((this.Rl * Math.cos(0.0d)) + rect.exactCenterX());
                this.mArrow.moveTo(0.0f, 0.0f);
                this.mArrow.lineTo(this.mArrowWidth * this.mArrowScale, 0.0f);
                this.mArrow.lineTo((this.mArrowWidth * this.mArrowScale) / 2.0f, this.mArrowHeight * this.mArrowScale);
                this.mArrow.offset(cos - f3, (float) ((this.Rl * Math.sin(0.0d)) + rect.exactCenterY()));
                this.mArrow.close();
                this.mArrowPaint.setColor(this.mCurrentColor);
                canvas.rotate((f + f2) - 5.0f, rect.exactCenterX(), rect.exactCenterY());
                canvas.drawPath(this.mArrow, this.mArrowPaint);
            }
        }

        public void setColors(@NonNull int[] iArr) {
            this.mColors = iArr;
            setColorIndex(0);
        }

        public void setColor(int i) {
            this.mCurrentColor = i;
        }

        public void setColorIndex(int i) {
            this.mColorIndex = i;
            this.mCurrentColor = this.mColors[this.mColorIndex];
        }

        public int getNextColor() {
            return this.mColors[getNextColorIndex()];
        }

        private int getNextColorIndex() {
            return (this.mColorIndex + 1) % this.mColors.length;
        }

        public void goToNextColor() {
            setColorIndex(getNextColorIndex());
        }

        public void setColorFilter(ColorFilter colorFilter) {
            this.mPaint.setColorFilter(colorFilter);
            invalidateSelf();
        }

        public void setAlpha(int i) {
            this.mAlpha = i;
        }

        public int getAlpha() {
            return this.mAlpha;
        }

        public void setStrokeWidth(float f) {
            this.mStrokeWidth = f;
            this.mPaint.setStrokeWidth(f);
            invalidateSelf();
        }

        public float getStrokeWidth() {
            return this.mStrokeWidth;
        }

        public void setStartTrim(float f) {
            this.mStartTrim = f;
            invalidateSelf();
        }

        public float getStartTrim() {
            return this.mStartTrim;
        }

        public float getStartingStartTrim() {
            return this.mStartingStartTrim;
        }

        public float getStartingEndTrim() {
            return this.mStartingEndTrim;
        }

        public int getStartingColor() {
            return this.mColors[this.mColorIndex];
        }

        public void setEndTrim(float f) {
            this.mEndTrim = f;
            invalidateSelf();
        }

        public float getEndTrim() {
            return this.mEndTrim;
        }

        public void setRotation(float f) {
            this.mRotation = f;
            invalidateSelf();
        }

        public void u(int i, int i2) {
            float ceil;
            float min = Math.min(i, i2);
            if (this.Rl <= 0.0d || min < 0.0f) {
                ceil = (float) Math.ceil(this.mStrokeWidth / 2.0f);
            } else {
                ceil = (float) ((min / 2.0f) - this.Rl);
            }
            this.Rk = ceil;
        }

        public void d(double d) {
            this.Rl = d;
        }

        public double pi() {
            return this.Rl;
        }

        public void setShowArrow(boolean z) {
            if (this.mShowArrow != z) {
                this.mShowArrow = z;
                invalidateSelf();
            }
        }

        public void setArrowScale(float f) {
            if (f != this.mArrowScale) {
                this.mArrowScale = f;
                invalidateSelf();
            }
        }

        public float getStartingRotation() {
            return this.mStartingRotation;
        }

        public void storeOriginals() {
            this.mStartingStartTrim = this.mStartTrim;
            this.mStartingEndTrim = this.mEndTrim;
            this.mStartingRotation = this.mRotation;
        }

        public void resetOriginals() {
            this.mStartingStartTrim = 0.0f;
            this.mStartingEndTrim = 0.0f;
            this.mStartingRotation = 0.0f;
            setStartTrim(0.0f);
            setEndTrim(0.0f);
            setRotation(0.0f);
        }

        private void invalidateSelf() {
            this.mCallback.invalidateDrawable(null);
        }
    }
}
