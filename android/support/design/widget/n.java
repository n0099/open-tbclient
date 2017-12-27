package android.support.design.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RadialGradient;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;
import android.support.design.R;
import android.support.v4.content.ContextCompat;
import android.support.v7.graphics.drawable.DrawableWrapper;
/* loaded from: classes2.dex */
class n extends DrawableWrapper {
    static final double pw = Math.cos(Math.toRadians(45.0d));
    private float mRotation;
    float pA;
    Path pB;
    float pC;
    float pD;
    float pE;
    float pF;
    private boolean pG;
    private final int pH;
    private final int pI;
    private final int pJ;
    private boolean pK;
    private boolean pL;
    final Paint px;
    final Paint py;
    final RectF pz;

    public n(Context context, Drawable drawable, float f, float f2, float f3) {
        super(drawable);
        this.pG = true;
        this.pK = true;
        this.pL = false;
        this.pH = ContextCompat.getColor(context, R.color.design_fab_shadow_start_color);
        this.pI = ContextCompat.getColor(context, R.color.design_fab_shadow_mid_color);
        this.pJ = ContextCompat.getColor(context, R.color.design_fab_shadow_end_color);
        this.px = new Paint(5);
        this.px.setStyle(Paint.Style.FILL);
        this.pA = Math.round(f);
        this.pz = new RectF();
        this.py = new Paint(this.px);
        this.py.setAntiAlias(false);
        d(f2, f3);
    }

    private static int j(float f) {
        int round = Math.round(f);
        return round % 2 == 1 ? round - 1 : round;
    }

    public void k(boolean z) {
        this.pK = z;
        invalidateSelf();
    }

    @Override // android.support.v7.graphics.drawable.DrawableWrapper, android.graphics.drawable.Drawable
    public void setAlpha(int i) {
        super.setAlpha(i);
        this.px.setAlpha(i);
        this.py.setAlpha(i);
    }

    @Override // android.support.v7.graphics.drawable.DrawableWrapper, android.graphics.drawable.Drawable
    protected void onBoundsChange(Rect rect) {
        this.pG = true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void d(float f, float f2) {
        if (f < 0.0f || f2 < 0.0f) {
            throw new IllegalArgumentException("invalid shadow size");
        }
        float j = j(f);
        float j2 = j(f2);
        if (j > j2) {
            if (!this.pL) {
                this.pL = true;
            }
            j = j2;
        }
        if (this.pF != j || this.pD != j2) {
            this.pF = j;
            this.pD = j2;
            this.pE = Math.round(j * 1.5f);
            this.pC = j2;
            this.pG = true;
            invalidateSelf();
        }
    }

    @Override // android.support.v7.graphics.drawable.DrawableWrapper, android.graphics.drawable.Drawable
    public boolean getPadding(Rect rect) {
        int ceil = (int) Math.ceil(a(this.pD, this.pA, this.pK));
        int ceil2 = (int) Math.ceil(b(this.pD, this.pA, this.pK));
        rect.set(ceil2, ceil, ceil2, ceil);
        return true;
    }

    public static float a(float f, float f2, boolean z) {
        return z ? (float) ((1.5f * f) + ((1.0d - pw) * f2)) : 1.5f * f;
    }

    public static float b(float f, float f2, boolean z) {
        if (z) {
            return (float) (f + ((1.0d - pw) * f2));
        }
        return f;
    }

    @Override // android.support.v7.graphics.drawable.DrawableWrapper, android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    @Override // android.support.v7.graphics.drawable.DrawableWrapper, android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        if (this.pG) {
            d(getBounds());
            this.pG = false;
        }
        d(canvas);
        super.draw(canvas);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void setRotation(float f) {
        if (this.mRotation != f) {
            this.mRotation = f;
            invalidateSelf();
        }
    }

    private void d(Canvas canvas) {
        int save = canvas.save();
        canvas.rotate(this.mRotation, this.pz.centerX(), this.pz.centerY());
        float f = (-this.pA) - this.pE;
        float f2 = this.pA;
        boolean z = this.pz.width() - (2.0f * f2) > 0.0f;
        boolean z2 = this.pz.height() - (2.0f * f2) > 0.0f;
        float f3 = this.pF - (this.pF * 0.25f);
        float f4 = f2 / ((this.pF - (this.pF * 0.5f)) + f2);
        float f5 = f2 / (f3 + f2);
        float f6 = f2 / (f2 + (this.pF - (this.pF * 1.0f)));
        int save2 = canvas.save();
        canvas.translate(this.pz.left + f2, this.pz.top + f2);
        canvas.scale(f4, f5);
        canvas.drawPath(this.pB, this.px);
        if (z) {
            canvas.scale(1.0f / f4, 1.0f);
            canvas.drawRect(0.0f, f, this.pz.width() - (2.0f * f2), -this.pA, this.py);
        }
        canvas.restoreToCount(save2);
        int save3 = canvas.save();
        canvas.translate(this.pz.right - f2, this.pz.bottom - f2);
        canvas.scale(f4, f6);
        canvas.rotate(180.0f);
        canvas.drawPath(this.pB, this.px);
        if (z) {
            canvas.scale(1.0f / f4, 1.0f);
            canvas.drawRect(0.0f, f, this.pz.width() - (2.0f * f2), this.pE + (-this.pA), this.py);
        }
        canvas.restoreToCount(save3);
        int save4 = canvas.save();
        canvas.translate(this.pz.left + f2, this.pz.bottom - f2);
        canvas.scale(f4, f6);
        canvas.rotate(270.0f);
        canvas.drawPath(this.pB, this.px);
        if (z2) {
            canvas.scale(1.0f / f6, 1.0f);
            canvas.drawRect(0.0f, f, this.pz.height() - (2.0f * f2), -this.pA, this.py);
        }
        canvas.restoreToCount(save4);
        int save5 = canvas.save();
        canvas.translate(this.pz.right - f2, this.pz.top + f2);
        canvas.scale(f4, f5);
        canvas.rotate(90.0f);
        canvas.drawPath(this.pB, this.px);
        if (z2) {
            canvas.scale(1.0f / f5, 1.0f);
            canvas.drawRect(0.0f, f, this.pz.height() - (2.0f * f2), -this.pA, this.py);
        }
        canvas.restoreToCount(save5);
        canvas.restoreToCount(save);
    }

    private void cc() {
        RectF rectF = new RectF(-this.pA, -this.pA, this.pA, this.pA);
        RectF rectF2 = new RectF(rectF);
        rectF2.inset(-this.pE, -this.pE);
        if (this.pB == null) {
            this.pB = new Path();
        } else {
            this.pB.reset();
        }
        this.pB.setFillType(Path.FillType.EVEN_ODD);
        this.pB.moveTo(-this.pA, 0.0f);
        this.pB.rLineTo(-this.pE, 0.0f);
        this.pB.arcTo(rectF2, 180.0f, 90.0f, false);
        this.pB.arcTo(rectF, 270.0f, -90.0f, false);
        this.pB.close();
        float f = -rectF2.top;
        if (f > 0.0f) {
            float f2 = this.pA / f;
            this.px.setShader(new RadialGradient(0.0f, 0.0f, f, new int[]{0, this.pH, this.pI, this.pJ}, new float[]{0.0f, f2, f2 + ((1.0f - f2) / 2.0f), 1.0f}, Shader.TileMode.CLAMP));
        }
        this.py.setShader(new LinearGradient(0.0f, rectF.top, 0.0f, rectF2.top, new int[]{this.pH, this.pI, this.pJ}, new float[]{0.0f, 0.5f, 1.0f}, Shader.TileMode.CLAMP));
        this.py.setAntiAlias(false);
    }

    private void d(Rect rect) {
        float f = this.pD * 1.5f;
        this.pz.set(rect.left + this.pD, rect.top + f, rect.right - this.pD, rect.bottom - f);
        getWrappedDrawable().setBounds((int) this.pz.left, (int) this.pz.top, (int) this.pz.right, (int) this.pz.bottom);
        cc();
    }

    public void k(float f) {
        d(f, this.pD);
    }

    public float cd() {
        return this.pF;
    }
}
