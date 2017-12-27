package android.support.v7.graphics.drawable;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.support.annotation.RestrictTo;
import android.support.v4.graphics.drawable.DrawableCompat;
import android.support.v7.appcompat.R;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
/* loaded from: classes2.dex */
public class DrawerArrowDrawable extends Drawable {
    public static final int ARROW_DIRECTION_END = 3;
    public static final int ARROW_DIRECTION_LEFT = 0;
    public static final int ARROW_DIRECTION_RIGHT = 1;
    public static final int ARROW_DIRECTION_START = 2;
    private static final float EW = (float) Math.toRadians(45.0d);
    private float EX;
    private float EY;
    private float EZ;
    private float Fa;
    private boolean Fb;
    private float Fd;
    private float mProgress;
    private final int mSize;
    private final Paint mPaint = new Paint();
    private final Path mPath = new Path();
    private boolean Fc = false;
    private int mDirection = 2;

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo
    /* loaded from: classes2.dex */
    public @interface ArrowDirection {
    }

    public DrawerArrowDrawable(Context context) {
        this.mPaint.setStyle(Paint.Style.STROKE);
        this.mPaint.setStrokeJoin(Paint.Join.MITER);
        this.mPaint.setStrokeCap(Paint.Cap.BUTT);
        this.mPaint.setAntiAlias(true);
        TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(null, R.styleable.DrawerArrowToggle, R.attr.drawerArrowStyle, R.style.Base_Widget_AppCompat_DrawerArrowToggle);
        setColor(obtainStyledAttributes.getColor(R.styleable.DrawerArrowToggle_color, 0));
        setBarThickness(obtainStyledAttributes.getDimension(R.styleable.DrawerArrowToggle_thickness, 0.0f));
        setSpinEnabled(obtainStyledAttributes.getBoolean(R.styleable.DrawerArrowToggle_spinBars, true));
        setGapSize(Math.round(obtainStyledAttributes.getDimension(R.styleable.DrawerArrowToggle_gapBetweenBars, 0.0f)));
        this.mSize = obtainStyledAttributes.getDimensionPixelSize(R.styleable.DrawerArrowToggle_drawableSize, 0);
        this.EY = Math.round(obtainStyledAttributes.getDimension(R.styleable.DrawerArrowToggle_barLength, 0.0f));
        this.EX = Math.round(obtainStyledAttributes.getDimension(R.styleable.DrawerArrowToggle_arrowHeadLength, 0.0f));
        this.EZ = obtainStyledAttributes.getDimension(R.styleable.DrawerArrowToggle_arrowShaftLength, 0.0f);
        obtainStyledAttributes.recycle();
    }

    public void setArrowHeadLength(float f) {
        if (this.EX != f) {
            this.EX = f;
            invalidateSelf();
        }
    }

    public float getArrowHeadLength() {
        return this.EX;
    }

    public void setArrowShaftLength(float f) {
        if (this.EZ != f) {
            this.EZ = f;
            invalidateSelf();
        }
    }

    public float getArrowShaftLength() {
        return this.EZ;
    }

    public float getBarLength() {
        return this.EY;
    }

    public void setBarLength(float f) {
        if (this.EY != f) {
            this.EY = f;
            invalidateSelf();
        }
    }

    public void setColor(int i) {
        if (i != this.mPaint.getColor()) {
            this.mPaint.setColor(i);
            invalidateSelf();
        }
    }

    public int getColor() {
        return this.mPaint.getColor();
    }

    public void setBarThickness(float f) {
        if (this.mPaint.getStrokeWidth() != f) {
            this.mPaint.setStrokeWidth(f);
            this.Fd = (float) ((f / 2.0f) * Math.cos(EW));
            invalidateSelf();
        }
    }

    public float getBarThickness() {
        return this.mPaint.getStrokeWidth();
    }

    public float getGapSize() {
        return this.Fa;
    }

    public void setGapSize(float f) {
        if (f != this.Fa) {
            this.Fa = f;
            invalidateSelf();
        }
    }

    public void setDirection(int i) {
        if (i != this.mDirection) {
            this.mDirection = i;
            invalidateSelf();
        }
    }

    public boolean isSpinEnabled() {
        return this.Fb;
    }

    public void setSpinEnabled(boolean z) {
        if (this.Fb != z) {
            this.Fb = z;
            invalidateSelf();
        }
    }

    public int getDirection() {
        return this.mDirection;
    }

    public void setVerticalMirror(boolean z) {
        if (this.Fc != z) {
            this.Fc = z;
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        boolean z;
        float strokeWidth;
        Rect bounds = getBounds();
        switch (this.mDirection) {
            case 0:
                z = false;
                break;
            case 1:
                z = true;
                break;
            case 2:
            default:
                if (DrawableCompat.getLayoutDirection(this) != 1) {
                    z = false;
                    break;
                } else {
                    z = true;
                    break;
                }
            case 3:
                if (DrawableCompat.getLayoutDirection(this) != 0) {
                    z = false;
                    break;
                } else {
                    z = true;
                    break;
                }
        }
        float a = a(this.EY, (float) Math.sqrt(this.EX * this.EX * 2.0f), this.mProgress);
        float a2 = a(this.EY, this.EZ, this.mProgress);
        float round = Math.round(a(0.0f, this.Fd, this.mProgress));
        float a3 = a(0.0f, EW, this.mProgress);
        float a4 = a(z ? 0.0f : -180.0f, z ? 180.0f : 0.0f, this.mProgress);
        float round2 = (float) Math.round(a * Math.cos(a3));
        float round3 = (float) Math.round(a * Math.sin(a3));
        this.mPath.rewind();
        float a5 = a(this.Fa + this.mPaint.getStrokeWidth(), -this.Fd, this.mProgress);
        float f = (-a2) / 2.0f;
        this.mPath.moveTo(f + round, 0.0f);
        this.mPath.rLineTo(a2 - (round * 2.0f), 0.0f);
        this.mPath.moveTo(f, a5);
        this.mPath.rLineTo(round2, round3);
        this.mPath.moveTo(f, -a5);
        this.mPath.rLineTo(round2, -round3);
        this.mPath.close();
        canvas.save();
        canvas.translate(bounds.centerX(), (float) (((((int) ((bounds.height() - (3.0f * strokeWidth)) - (this.Fa * 2.0f))) / 4) * 2) + (this.mPaint.getStrokeWidth() * 1.5d) + this.Fa));
        if (this.Fb) {
            canvas.rotate((z ^ this.Fc ? -1 : 1) * a4);
        } else if (z) {
            canvas.rotate(180.0f);
        }
        canvas.drawPath(this.mPath, this.mPaint);
        canvas.restore();
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i) {
        if (i != this.mPaint.getAlpha()) {
            this.mPaint.setAlpha(i);
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        this.mPaint.setColorFilter(colorFilter);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return this.mSize;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return this.mSize;
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    public float getProgress() {
        return this.mProgress;
    }

    public void setProgress(float f) {
        if (this.mProgress != f) {
            this.mProgress = f;
            invalidateSelf();
        }
    }

    public final Paint getPaint() {
        return this.mPaint;
    }

    private static float a(float f, float f2, float f3) {
        return ((f2 - f) * f3) + f;
    }
}
