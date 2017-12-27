package android.support.design.widget;

import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.os.Build;
import android.support.v4.text.TextDirectionHeuristicsCompat;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewCompat;
import android.support.v7.appcompat.R;
import android.support.v7.widget.TintTypedArray;
import android.text.TextPaint;
import android.text.TextUtils;
import android.view.View;
import android.view.animation.Interpolator;
/* loaded from: classes2.dex */
final class d {
    private static final boolean ma;
    private static final Paint mb;
    private boolean mA;
    private Bitmap mB;
    private Paint mD;
    private float mE;
    private float mF;
    private float mG;
    private int[] mH;
    private boolean mI;
    private Interpolator mK;
    private Interpolator mL;
    private float mM;
    private float mN;
    private float mO;
    private int mP;
    private float mQ;
    private float mS;
    private float mScale;
    private float mT;
    private CharSequence mText;
    private int mU;
    private final View mView;
    private boolean mc;
    private float md;
    private ColorStateList mm;
    private ColorStateList mn;
    private float mo;
    private float mp;
    private float mq;
    private float mr;
    private float ms;
    private float mt;
    private Typeface mu;
    private Typeface mw;
    private Typeface mx;
    private CharSequence my;
    private boolean mz;
    private int mi = 16;
    private int mj = 16;
    private float mk = 15.0f;
    private float ml = 15.0f;
    private final TextPaint mJ = new TextPaint(129);
    private final Rect mg = new Rect();
    private final Rect mf = new Rect();
    private final RectF mh = new RectF();

    static {
        ma = Build.VERSION.SDK_INT < 18;
        mb = null;
        if (mb != null) {
            mb.setAntiAlias(true);
            mb.setColor(-65281);
        }
    }

    public d(View view) {
        this.mView = view;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(Interpolator interpolator) {
        this.mL = interpolator;
        bn();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(Interpolator interpolator) {
        this.mK = interpolator;
        bn();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void c(float f) {
        if (this.mk != f) {
            this.mk = f;
            bn();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(ColorStateList colorStateList) {
        if (this.mn != colorStateList) {
            this.mn = colorStateList;
            bn();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void c(ColorStateList colorStateList) {
        if (this.mm != colorStateList) {
            this.mm = colorStateList;
            bn();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void c(int i, int i2, int i3, int i4) {
        if (!a(this.mf, i, i2, i3, i4)) {
            this.mf.set(i, i2, i3, i4);
            this.mI = true;
            bb();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void d(int i, int i2, int i3, int i4) {
        if (!a(this.mg, i, i2, i3, i4)) {
            this.mg.set(i, i2, i3, i4);
            this.mI = true;
            bb();
        }
    }

    void bb() {
        this.mc = this.mg.width() > 0 && this.mg.height() > 0 && this.mf.width() > 0 && this.mf.height() > 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void r(int i) {
        if (this.mi != i) {
            this.mi = i;
            bn();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int bc() {
        return this.mi;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void s(int i) {
        if (this.mj != i) {
            this.mj = i;
            bn();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int bd() {
        return this.mj;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void t(int i) {
        TintTypedArray obtainStyledAttributes = TintTypedArray.obtainStyledAttributes(this.mView.getContext(), i, R.styleable.TextAppearance);
        if (obtainStyledAttributes.hasValue(R.styleable.TextAppearance_android_textColor)) {
            this.mn = obtainStyledAttributes.getColorStateList(R.styleable.TextAppearance_android_textColor);
        }
        if (obtainStyledAttributes.hasValue(R.styleable.TextAppearance_android_textSize)) {
            this.ml = obtainStyledAttributes.getDimensionPixelSize(R.styleable.TextAppearance_android_textSize, (int) this.ml);
        }
        this.mP = obtainStyledAttributes.getInt(R.styleable.TextAppearance_android_shadowColor, 0);
        this.mN = obtainStyledAttributes.getFloat(R.styleable.TextAppearance_android_shadowDx, 0.0f);
        this.mO = obtainStyledAttributes.getFloat(R.styleable.TextAppearance_android_shadowDy, 0.0f);
        this.mM = obtainStyledAttributes.getFloat(R.styleable.TextAppearance_android_shadowRadius, 0.0f);
        obtainStyledAttributes.recycle();
        if (Build.VERSION.SDK_INT >= 16) {
            this.mu = v(i);
        }
        bn();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void u(int i) {
        TintTypedArray obtainStyledAttributes = TintTypedArray.obtainStyledAttributes(this.mView.getContext(), i, R.styleable.TextAppearance);
        if (obtainStyledAttributes.hasValue(R.styleable.TextAppearance_android_textColor)) {
            this.mm = obtainStyledAttributes.getColorStateList(R.styleable.TextAppearance_android_textColor);
        }
        if (obtainStyledAttributes.hasValue(R.styleable.TextAppearance_android_textSize)) {
            this.mk = obtainStyledAttributes.getDimensionPixelSize(R.styleable.TextAppearance_android_textSize, (int) this.mk);
        }
        this.mU = obtainStyledAttributes.getInt(R.styleable.TextAppearance_android_shadowColor, 0);
        this.mS = obtainStyledAttributes.getFloat(R.styleable.TextAppearance_android_shadowDx, 0.0f);
        this.mT = obtainStyledAttributes.getFloat(R.styleable.TextAppearance_android_shadowDy, 0.0f);
        this.mQ = obtainStyledAttributes.getFloat(R.styleable.TextAppearance_android_shadowRadius, 0.0f);
        obtainStyledAttributes.recycle();
        if (Build.VERSION.SDK_INT >= 16) {
            this.mw = v(i);
        }
        bn();
    }

    private Typeface v(int i) {
        TypedArray obtainStyledAttributes = this.mView.getContext().obtainStyledAttributes(i, new int[]{16843692});
        try {
            String string = obtainStyledAttributes.getString(0);
            if (string != null) {
                return Typeface.create(string, 0);
            }
            obtainStyledAttributes.recycle();
            return null;
        } finally {
            obtainStyledAttributes.recycle();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(Typeface typeface) {
        if (this.mu != typeface) {
            this.mu = typeface;
            bn();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(Typeface typeface) {
        if (this.mw != typeface) {
            this.mw = typeface;
            bn();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void c(Typeface typeface) {
        this.mw = typeface;
        this.mu = typeface;
        bn();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Typeface be() {
        return this.mu != null ? this.mu : Typeface.DEFAULT;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Typeface bf() {
        return this.mw != null ? this.mw : Typeface.DEFAULT;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void d(float f) {
        float constrain = m.constrain(f, 0.0f, 1.0f);
        if (constrain != this.md) {
            this.md = constrain;
            bi();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean setState(int[] iArr) {
        this.mH = iArr;
        if (isStateful()) {
            bn();
            return true;
        }
        return false;
    }

    final boolean isStateful() {
        return (this.mn != null && this.mn.isStateful()) || (this.mm != null && this.mm.isStateful());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public float bg() {
        return this.md;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public float bh() {
        return this.ml;
    }

    private void bi() {
        e(this.md);
    }

    private void e(float f) {
        f(f);
        this.ms = a(this.mq, this.mr, f, this.mK);
        this.mt = a(this.mo, this.mp, f, this.mK);
        g(a(this.mk, this.ml, f, this.mL));
        if (this.mn != this.mm) {
            this.mJ.setColor(b(bj(), bk(), f));
        } else {
            this.mJ.setColor(bk());
        }
        this.mJ.setShadowLayer(a(this.mQ, this.mM, f, null), a(this.mS, this.mN, f, null), a(this.mT, this.mO, f, null), b(this.mU, this.mP, f));
        ViewCompat.postInvalidateOnAnimation(this.mView);
    }

    private int bj() {
        return this.mH != null ? this.mm.getColorForState(this.mH, 0) : this.mm.getDefaultColor();
    }

    private int bk() {
        return this.mH != null ? this.mn.getColorForState(this.mH, 0) : this.mn.getDefaultColor();
    }

    private void bl() {
        float f = this.mG;
        h(this.ml);
        float measureText = this.my != null ? this.mJ.measureText(this.my, 0, this.my.length()) : 0.0f;
        int absoluteGravity = GravityCompat.getAbsoluteGravity(this.mj, this.mz ? 1 : 0);
        switch (absoluteGravity & 112) {
            case 48:
                this.mp = this.mg.top - this.mJ.ascent();
                break;
            case 80:
                this.mp = this.mg.bottom;
                break;
            default:
                this.mp = (((this.mJ.descent() - this.mJ.ascent()) / 2.0f) - this.mJ.descent()) + this.mg.centerY();
                break;
        }
        switch (absoluteGravity & GravityCompat.RELATIVE_HORIZONTAL_GRAVITY_MASK) {
            case 1:
                this.mr = this.mg.centerX() - (measureText / 2.0f);
                break;
            case 5:
                this.mr = this.mg.right - measureText;
                break;
            default:
                this.mr = this.mg.left;
                break;
        }
        h(this.mk);
        float measureText2 = this.my != null ? this.mJ.measureText(this.my, 0, this.my.length()) : 0.0f;
        int absoluteGravity2 = GravityCompat.getAbsoluteGravity(this.mi, this.mz ? 1 : 0);
        switch (absoluteGravity2 & 112) {
            case 48:
                this.mo = this.mf.top - this.mJ.ascent();
                break;
            case 80:
                this.mo = this.mf.bottom;
                break;
            default:
                this.mo = (((this.mJ.descent() - this.mJ.ascent()) / 2.0f) - this.mJ.descent()) + this.mf.centerY();
                break;
        }
        switch (absoluteGravity2 & GravityCompat.RELATIVE_HORIZONTAL_GRAVITY_MASK) {
            case 1:
                this.mq = this.mf.centerX() - (measureText2 / 2.0f);
                break;
            case 5:
                this.mq = this.mf.right - measureText2;
                break;
            default:
                this.mq = this.mf.left;
                break;
        }
        bo();
        g(f);
    }

    private void f(float f) {
        this.mh.left = a(this.mf.left, this.mg.left, f, this.mK);
        this.mh.top = a(this.mo, this.mp, f, this.mK);
        this.mh.right = a(this.mf.right, this.mg.right, f, this.mK);
        this.mh.bottom = a(this.mf.bottom, this.mg.bottom, f, this.mK);
    }

    public void draw(Canvas canvas) {
        float ascent;
        int save = canvas.save();
        if (this.my != null && this.mc) {
            float f = this.ms;
            float f2 = this.mt;
            boolean z = this.mA && this.mB != null;
            if (z) {
                ascent = this.mE * this.mScale;
                float f3 = this.mF * this.mScale;
            } else {
                ascent = this.mJ.ascent() * this.mScale;
                float descent = this.mJ.descent() * this.mScale;
            }
            if (z) {
                f2 += ascent;
            }
            if (this.mScale != 1.0f) {
                canvas.scale(this.mScale, this.mScale, f, f2);
            }
            if (z) {
                canvas.drawBitmap(this.mB, f, f2, this.mD);
            } else {
                canvas.drawText(this.my, 0, this.my.length(), f, f2, this.mJ);
            }
        }
        canvas.restoreToCount(save);
    }

    private boolean b(CharSequence charSequence) {
        return (ViewCompat.getLayoutDirection(this.mView) == 1 ? TextDirectionHeuristicsCompat.FIRSTSTRONG_RTL : TextDirectionHeuristicsCompat.FIRSTSTRONG_LTR).isRtl(charSequence, 0, charSequence.length());
    }

    private void g(float f) {
        h(f);
        this.mA = ma && this.mScale != 1.0f;
        if (this.mA) {
            bm();
        }
        ViewCompat.postInvalidateOnAnimation(this.mView);
    }

    private void h(float f) {
        float f2;
        boolean z;
        if (this.mText != null) {
            float width = this.mg.width();
            float width2 = this.mf.width();
            if (b(f, this.ml)) {
                f2 = this.ml;
                this.mScale = 1.0f;
                if (this.mx != this.mu) {
                    this.mx = this.mu;
                    z = true;
                } else {
                    z = false;
                }
            } else {
                f2 = this.mk;
                if (this.mx != this.mw) {
                    this.mx = this.mw;
                    z = true;
                } else {
                    z = false;
                }
                if (b(f, this.mk)) {
                    this.mScale = 1.0f;
                } else {
                    this.mScale = f / this.mk;
                }
                float f3 = this.ml / this.mk;
                width = width2 * f3 > width ? Math.min(width / f3, width2) : width2;
            }
            if (width > 0.0f) {
                z = this.mG != f2 || this.mI || z;
                this.mG = f2;
                this.mI = false;
            }
            if (this.my == null || z) {
                this.mJ.setTextSize(this.mG);
                this.mJ.setTypeface(this.mx);
                this.mJ.setLinearText(this.mScale != 1.0f);
                CharSequence ellipsize = TextUtils.ellipsize(this.mText, this.mJ, width, TextUtils.TruncateAt.END);
                if (!TextUtils.equals(ellipsize, this.my)) {
                    this.my = ellipsize;
                    this.mz = b(this.my);
                }
            }
        }
    }

    private void bm() {
        if (this.mB == null && !this.mf.isEmpty() && !TextUtils.isEmpty(this.my)) {
            e(0.0f);
            this.mE = this.mJ.ascent();
            this.mF = this.mJ.descent();
            int round = Math.round(this.mJ.measureText(this.my, 0, this.my.length()));
            int round2 = Math.round(this.mF - this.mE);
            if (round > 0 && round2 > 0) {
                this.mB = Bitmap.createBitmap(round, round2, Bitmap.Config.ARGB_8888);
                new Canvas(this.mB).drawText(this.my, 0, this.my.length(), 0.0f, round2 - this.mJ.descent(), this.mJ);
                if (this.mD == null) {
                    this.mD = new Paint(3);
                }
            }
        }
    }

    public void bn() {
        if (this.mView.getHeight() > 0 && this.mView.getWidth() > 0) {
            bl();
            bi();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setText(CharSequence charSequence) {
        if (charSequence == null || !charSequence.equals(this.mText)) {
            this.mText = charSequence;
            this.my = null;
            bo();
            bn();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public CharSequence getText() {
        return this.mText;
    }

    private void bo() {
        if (this.mB != null) {
            this.mB.recycle();
            this.mB = null;
        }
    }

    private static boolean b(float f, float f2) {
        return Math.abs(f - f2) < 0.001f;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ColorStateList bp() {
        return this.mn;
    }

    private static int b(int i, int i2, float f) {
        float f2 = 1.0f - f;
        return Color.argb((int) ((Color.alpha(i) * f2) + (Color.alpha(i2) * f)), (int) ((Color.red(i) * f2) + (Color.red(i2) * f)), (int) ((Color.green(i) * f2) + (Color.green(i2) * f)), (int) ((f2 * Color.blue(i)) + (Color.blue(i2) * f)));
    }

    private static float a(float f, float f2, float f3, Interpolator interpolator) {
        if (interpolator != null) {
            f3 = interpolator.getInterpolation(f3);
        }
        return a.a(f, f2, f3);
    }

    private static boolean a(Rect rect, int i, int i2, int i3, int i4) {
        return rect.left == i && rect.top == i2 && rect.right == i3 && rect.bottom == i4;
    }
}
