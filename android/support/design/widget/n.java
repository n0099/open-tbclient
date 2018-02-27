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
    static final double pv = Math.cos(Math.toRadians(45.0d));
    private float mRotation;
    Path pA;
    float pB;
    float pC;
    float pD;
    float pE;
    private boolean pF;
    private final int pG;
    private final int pH;
    private final int pI;
    private boolean pJ;
    private boolean pK;
    final Paint pw;
    final Paint px;
    final RectF py;
    float pz;

    public n(Context context, Drawable drawable, float f, float f2, float f3) {
        super(drawable);
        this.pF = true;
        this.pJ = true;
        this.pK = false;
        this.pG = ContextCompat.getColor(context, R.color.design_fab_shadow_start_color);
        this.pH = ContextCompat.getColor(context, R.color.design_fab_shadow_mid_color);
        this.pI = ContextCompat.getColor(context, R.color.design_fab_shadow_end_color);
        this.pw = new Paint(5);
        this.pw.setStyle(Paint.Style.FILL);
        this.pz = Math.round(f);
        this.py = new RectF();
        this.px = new Paint(this.pw);
        this.px.setAntiAlias(false);
        d(f2, f3);
    }

    private static int n(float f) {
        int round = Math.round(f);
        return round % 2 == 1 ? round - 1 : round;
    }

    public void m(boolean z) {
        this.pJ = z;
        invalidateSelf();
    }

    @Override // android.support.v7.graphics.drawable.DrawableWrapper, android.graphics.drawable.Drawable
    public void setAlpha(int i) {
        super.setAlpha(i);
        this.pw.setAlpha(i);
        this.px.setAlpha(i);
    }

    @Override // android.support.v7.graphics.drawable.DrawableWrapper, android.graphics.drawable.Drawable
    protected void onBoundsChange(Rect rect) {
        this.pF = true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void d(float f, float f2) {
        if (f < 0.0f || f2 < 0.0f) {
            throw new IllegalArgumentException("invalid shadow size");
        }
        float n = n(f);
        float n2 = n(f2);
        if (n > n2) {
            if (!this.pK) {
                this.pK = true;
            }
            n = n2;
        }
        if (this.pE != n || this.pC != n2) {
            this.pE = n;
            this.pC = n2;
            this.pD = Math.round(n * 1.5f);
            this.pB = n2;
            this.pF = true;
            invalidateSelf();
        }
    }

    @Override // android.support.v7.graphics.drawable.DrawableWrapper, android.graphics.drawable.Drawable
    public boolean getPadding(Rect rect) {
        int ceil = (int) Math.ceil(a(this.pC, this.pz, this.pJ));
        int ceil2 = (int) Math.ceil(b(this.pC, this.pz, this.pJ));
        rect.set(ceil2, ceil, ceil2, ceil);
        return true;
    }

    public static float a(float f, float f2, boolean z) {
        return z ? (float) ((1.5f * f) + ((1.0d - pv) * f2)) : 1.5f * f;
    }

    public static float b(float f, float f2, boolean z) {
        if (z) {
            return (float) (f + ((1.0d - pv) * f2));
        }
        return f;
    }

    @Override // android.support.v7.graphics.drawable.DrawableWrapper, android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    @Override // android.support.v7.graphics.drawable.DrawableWrapper, android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        if (this.pF) {
            e(getBounds());
            this.pF = false;
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
        canvas.rotate(this.mRotation, this.py.centerX(), this.py.centerY());
        float f = (-this.pz) - this.pD;
        float f2 = this.pz;
        boolean z = this.py.width() - (2.0f * f2) > 0.0f;
        boolean z2 = this.py.height() - (2.0f * f2) > 0.0f;
        float f3 = this.pE - (this.pE * 0.25f);
        float f4 = f2 / ((this.pE - (this.pE * 0.5f)) + f2);
        float f5 = f2 / (f3 + f2);
        float f6 = f2 / (f2 + (this.pE - (this.pE * 1.0f)));
        int save2 = canvas.save();
        canvas.translate(this.py.left + f2, this.py.top + f2);
        canvas.scale(f4, f5);
        canvas.drawPath(this.pA, this.pw);
        if (z) {
            canvas.scale(1.0f / f4, 1.0f);
            canvas.drawRect(0.0f, f, this.py.width() - (2.0f * f2), -this.pz, this.px);
        }
        canvas.restoreToCount(save2);
        int save3 = canvas.save();
        canvas.translate(this.py.right - f2, this.py.bottom - f2);
        canvas.scale(f4, f6);
        canvas.rotate(180.0f);
        canvas.drawPath(this.pA, this.pw);
        if (z) {
            canvas.scale(1.0f / f4, 1.0f);
            canvas.drawRect(0.0f, f, this.py.width() - (2.0f * f2), this.pD + (-this.pz), this.px);
        }
        canvas.restoreToCount(save3);
        int save4 = canvas.save();
        canvas.translate(this.py.left + f2, this.py.bottom - f2);
        canvas.scale(f4, f6);
        canvas.rotate(270.0f);
        canvas.drawPath(this.pA, this.pw);
        if (z2) {
            canvas.scale(1.0f / f6, 1.0f);
            canvas.drawRect(0.0f, f, this.py.height() - (2.0f * f2), -this.pz, this.px);
        }
        canvas.restoreToCount(save4);
        int save5 = canvas.save();
        canvas.translate(this.py.right - f2, this.py.top + f2);
        canvas.scale(f4, f5);
        canvas.rotate(90.0f);
        canvas.drawPath(this.pA, this.pw);
        if (z2) {
            canvas.scale(1.0f / f5, 1.0f);
            canvas.drawRect(0.0f, f, this.py.height() - (2.0f * f2), -this.pz, this.px);
        }
        canvas.restoreToCount(save5);
        canvas.restoreToCount(save);
    }

    private void cc() {
        RectF rectF = new RectF(-this.pz, -this.pz, this.pz, this.pz);
        RectF rectF2 = new RectF(rectF);
        rectF2.inset(-this.pD, -this.pD);
        if (this.pA == null) {
            this.pA = new Path();
        } else {
            this.pA.reset();
        }
        this.pA.setFillType(Path.FillType.EVEN_ODD);
        this.pA.moveTo(-this.pz, 0.0f);
        this.pA.rLineTo(-this.pD, 0.0f);
        this.pA.arcTo(rectF2, 180.0f, 90.0f, false);
        this.pA.arcTo(rectF, 270.0f, -90.0f, false);
        this.pA.close();
        float f = -rectF2.top;
        if (f > 0.0f) {
            float f2 = this.pz / f;
            this.pw.setShader(new RadialGradient(0.0f, 0.0f, f, new int[]{0, this.pG, this.pH, this.pI}, new float[]{0.0f, f2, f2 + ((1.0f - f2) / 2.0f), 1.0f}, Shader.TileMode.CLAMP));
        }
        this.px.setShader(new LinearGradient(0.0f, rectF.top, 0.0f, rectF2.top, new int[]{this.pG, this.pH, this.pI}, new float[]{0.0f, 0.5f, 1.0f}, Shader.TileMode.CLAMP));
        this.px.setAntiAlias(false);
    }

    private void e(Rect rect) {
        float f = this.pC * 1.5f;
        this.py.set(rect.left + this.pC, rect.top + f, rect.right - this.pC, rect.bottom - f);
        getWrappedDrawable().setBounds((int) this.py.left, (int) this.py.top, (int) this.py.right, (int) this.py.bottom);
        cc();
    }

    public void o(float f) {
        d(f, this.pC);
    }

    public float cd() {
        return this.pE;
    }
}
