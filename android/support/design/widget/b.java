package android.support.design.widget;

import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;
import android.support.v4.graphics.ColorUtils;
/* loaded from: classes2.dex */
class b extends Drawable {
    float lS;
    private int lT;
    private int lU;
    private int lV;
    private int lW;
    private ColorStateList lX;
    private int lY;
    private float mRotation;
    final Rect lQ = new Rect();
    final RectF lR = new RectF();
    private boolean lZ = true;
    final Paint mPaint = new Paint(1);

    public b() {
        this.mPaint.setStyle(Paint.Style.STROKE);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(int i, int i2, int i3, int i4) {
        this.lT = i;
        this.lU = i2;
        this.lV = i3;
        this.lW = i4;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(float f) {
        if (this.lS != f) {
            this.lS = f;
            this.mPaint.setStrokeWidth(1.3333f * f);
            this.lZ = true;
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        if (this.lZ) {
            this.mPaint.setShader(ba());
            this.lZ = false;
        }
        float strokeWidth = this.mPaint.getStrokeWidth() / 2.0f;
        RectF rectF = this.lR;
        copyBounds(this.lQ);
        rectF.set(this.lQ);
        rectF.left += strokeWidth;
        rectF.top += strokeWidth;
        rectF.right -= strokeWidth;
        rectF.bottom -= strokeWidth;
        canvas.save();
        canvas.rotate(this.mRotation, rectF.centerX(), rectF.centerY());
        canvas.drawOval(rectF, this.mPaint);
        canvas.restore();
    }

    @Override // android.graphics.drawable.Drawable
    public boolean getPadding(Rect rect) {
        int round = Math.round(this.lS);
        rect.set(round, round, round, round);
        return true;
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i) {
        this.mPaint.setAlpha(i);
        invalidateSelf();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(ColorStateList colorStateList) {
        if (colorStateList != null) {
            this.lY = colorStateList.getColorForState(getState(), this.lY);
        }
        this.lX = colorStateList;
        this.lZ = true;
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        this.mPaint.setColorFilter(colorFilter);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return this.lS > 0.0f ? -3 : -2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void setRotation(float f) {
        if (f != this.mRotation) {
            this.mRotation = f;
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    protected void onBoundsChange(Rect rect) {
        this.lZ = true;
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isStateful() {
        return (this.lX != null && this.lX.isStateful()) || super.isStateful();
    }

    @Override // android.graphics.drawable.Drawable
    protected boolean onStateChange(int[] iArr) {
        int colorForState;
        if (this.lX != null && (colorForState = this.lX.getColorForState(iArr, this.lY)) != this.lY) {
            this.lZ = true;
            this.lY = colorForState;
        }
        if (this.lZ) {
            invalidateSelf();
        }
        return this.lZ;
    }

    private Shader ba() {
        Rect rect = this.lQ;
        copyBounds(rect);
        float height = this.lS / rect.height();
        return new LinearGradient(0.0f, rect.top, 0.0f, rect.bottom, new int[]{ColorUtils.compositeColors(this.lT, this.lY), ColorUtils.compositeColors(this.lU, this.lY), ColorUtils.compositeColors(ColorUtils.setAlphaComponent(this.lU, 0), this.lY), ColorUtils.compositeColors(ColorUtils.setAlphaComponent(this.lW, 0), this.lY), ColorUtils.compositeColors(this.lW, this.lY), ColorUtils.compositeColors(this.lV, this.lY)}, new float[]{0.0f, height, 0.5f, 0.5f, 1.0f - height, 1.0f}, Shader.TileMode.CLAMP);
    }
}
