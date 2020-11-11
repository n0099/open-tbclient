package com.baidu.poly.widget;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PointF;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewParent;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.CompoundButton;
import com.baidu.poly.b;
/* loaded from: classes6.dex */
public class SwitchButton extends CompoundButton {
    private static int[] cdR = {16842912, 16842910, 16842919};
    private static int[] cdS = {-16842912, 16842910, 16842919};
    private float ab;
    private float aox;
    private Drawable cdT;
    private Drawable cdU;
    private ColorStateList cdV;
    private ColorStateList cdW;
    private RectF cdX;
    private float cdY;
    private long cdZ;
    private int ceA;
    private int ceB;
    private Paint ceC;
    private CharSequence ceD;
    private CharSequence ceE;
    private TextPaint ceF;
    private Layout ceG;
    private Layout ceH;
    private float ceI;
    private float ceJ;
    private int ceK;
    private int ceL;
    private int ceM;
    private boolean ceN;
    private boolean ceO;
    private boolean ceP;
    private CompoundButton.OnCheckedChangeListener ceQ;
    private boolean cea;
    private int ceb;
    private int cec;
    private int ced;
    private int cee;
    private int cef;
    private int ceg;
    private int ceh;
    private int cei;
    private Drawable cej;
    private Drawable cek;
    private RectF cel;
    private RectF cem;
    private RectF cen;
    private RectF ceo;
    private RectF cep;
    private Paint ceq;
    private boolean cer;
    private boolean ces;
    private boolean cet;
    private ObjectAnimator ceu;
    private float cev;
    private RectF cew;
    private float cex;
    private float cey;
    private float cez;
    private int ib;
    private int pb;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public static class a extends View.BaseSavedState {
        public static final Parcelable.Creator<a> CREATOR = new C0313a();
        CharSequence ceR;
        CharSequence ceS;

        /* renamed from: com.baidu.poly.widget.SwitchButton$a$a  reason: collision with other inner class name */
        /* loaded from: classes6.dex */
        static class C0313a implements Parcelable.Creator<a> {
            C0313a() {
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // android.os.Parcelable.Creator
            /* renamed from: gW */
            public a[] newArray(int i) {
                return new a[i];
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // android.os.Parcelable.Creator
            /* renamed from: n */
            public a createFromParcel(Parcel parcel) {
                return new a(parcel);
            }
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            TextUtils.writeToParcel(this.ceR, parcel, i);
            TextUtils.writeToParcel(this.ceS, parcel, i);
        }

        a(Parcelable parcelable) {
            super(parcelable);
        }

        private a(Parcel parcel) {
            super(parcel);
            this.ceR = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
            this.ceS = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
        }
    }

    public SwitchButton(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.cet = false;
        this.ceN = false;
        this.ceO = false;
        this.ceP = false;
        c(attributeSet);
    }

    private void abu() {
        ViewParent parent = getParent();
        if (parent != null) {
            parent.requestDisallowInterceptTouchEvent(true);
        }
        this.ceP = true;
    }

    private void c(AttributeSet attributeSet) {
        Drawable drawable;
        ColorStateList colorStateList;
        float f;
        float f2;
        float f3;
        float f4;
        float f5;
        float f6;
        float f7;
        float f8;
        Drawable drawable2;
        ColorStateList colorStateList2;
        int i;
        int i2;
        String str;
        int i3;
        float f9;
        boolean z;
        String str2;
        int i4;
        int i5;
        this.ceA = ViewConfiguration.get(getContext()).getScaledTouchSlop();
        this.ceB = ViewConfiguration.getPressedStateDuration() + ViewConfiguration.getTapTimeout();
        this.ceq = new Paint(1);
        this.ceC = new Paint(1);
        this.ceC.setStyle(Paint.Style.STROKE);
        this.ceC.setStrokeWidth(getResources().getDisplayMetrics().density);
        this.ceF = getPaint();
        this.cel = new RectF();
        this.cem = new RectF();
        this.cen = new RectF();
        this.cdX = new RectF();
        this.ceo = new RectF();
        this.cep = new RectF();
        this.ceu = ObjectAnimator.ofFloat(this, "progress", 0.0f, 0.0f).setDuration(250L);
        this.ceu.setInterpolator(new AccelerateDecelerateInterpolator());
        this.cew = new RectF();
        float f10 = getResources().getDisplayMetrics().density * 2.0f;
        TypedArray obtainStyledAttributes = attributeSet == null ? null : getContext().obtainStyledAttributes(attributeSet, b.i.SwitchButton);
        if (obtainStyledAttributes != null) {
            Drawable drawable3 = obtainStyledAttributes.getDrawable(b.i.SwitchButton_kswThumbDrawable);
            ColorStateList colorStateList3 = obtainStyledAttributes.getColorStateList(b.i.SwitchButton_kswThumbColor);
            float dimension = obtainStyledAttributes.getDimension(b.i.SwitchButton_kswThumbMargin, f10);
            float dimension2 = obtainStyledAttributes.getDimension(b.i.SwitchButton_kswThumbMarginLeft, dimension);
            float dimension3 = obtainStyledAttributes.getDimension(b.i.SwitchButton_kswThumbMarginRight, dimension);
            float dimension4 = obtainStyledAttributes.getDimension(b.i.SwitchButton_kswThumbMarginTop, dimension);
            float dimension5 = obtainStyledAttributes.getDimension(b.i.SwitchButton_kswThumbMarginBottom, dimension);
            float dimension6 = obtainStyledAttributes.getDimension(b.i.SwitchButton_kswThumbWidth, 0.0f);
            float dimension7 = obtainStyledAttributes.getDimension(b.i.SwitchButton_kswThumbHeight, 0.0f);
            float dimension8 = obtainStyledAttributes.getDimension(b.i.SwitchButton_kswThumbRadius, -1.0f);
            float dimension9 = obtainStyledAttributes.getDimension(b.i.SwitchButton_kswBackRadius, -1.0f);
            Drawable drawable4 = obtainStyledAttributes.getDrawable(b.i.SwitchButton_kswBackDrawable);
            ColorStateList colorStateList4 = obtainStyledAttributes.getColorStateList(b.i.SwitchButton_kswBackColor);
            float f11 = obtainStyledAttributes.getFloat(b.i.SwitchButton_kswThumbRangeRatio, 1.8f);
            int integer = obtainStyledAttributes.getInteger(b.i.SwitchButton_kswAnimationDuration, 250);
            boolean z2 = obtainStyledAttributes.getBoolean(b.i.SwitchButton_kswFadeBack, true);
            int color = obtainStyledAttributes.getColor(b.i.SwitchButton_kswTintColor, 0);
            String string = obtainStyledAttributes.getString(b.i.SwitchButton_kswTextOn);
            String string2 = obtainStyledAttributes.getString(b.i.SwitchButton_kswTextOff);
            int dimensionPixelSize = obtainStyledAttributes.getDimensionPixelSize(b.i.SwitchButton_kswTextThumbInset, 0);
            int dimensionPixelSize2 = obtainStyledAttributes.getDimensionPixelSize(b.i.SwitchButton_kswTextExtra, 0);
            int dimensionPixelSize3 = obtainStyledAttributes.getDimensionPixelSize(b.i.SwitchButton_kswTextAdjust, 0);
            obtainStyledAttributes.recycle();
            drawable = drawable3;
            colorStateList = colorStateList3;
            f = dimension2;
            f2 = dimension3;
            f3 = dimension4;
            f4 = dimension5;
            f5 = dimension6;
            f6 = dimension7;
            f7 = dimension8;
            f8 = dimension9;
            drawable2 = drawable4;
            colorStateList2 = colorStateList4;
            i = integer;
            i2 = color;
            str = string2;
            i3 = dimensionPixelSize2;
            f9 = f11;
            z = z2;
            str2 = string;
            i4 = dimensionPixelSize;
            i5 = dimensionPixelSize3;
        } else {
            drawable = null;
            colorStateList = null;
            f = 0.0f;
            f2 = 0.0f;
            f3 = 0.0f;
            f4 = 0.0f;
            f5 = 0.0f;
            f6 = 0.0f;
            f7 = -1.0f;
            f8 = -1.0f;
            drawable2 = null;
            colorStateList2 = null;
            i = 250;
            i2 = 0;
            str = null;
            i3 = 0;
            f9 = 1.8f;
            z = true;
            str2 = null;
            i4 = 0;
            i5 = 0;
        }
        TypedArray obtainStyledAttributes2 = attributeSet == null ? null : getContext().obtainStyledAttributes(attributeSet, new int[]{16842970, 16842981});
        if (obtainStyledAttributes2 != null) {
            boolean z3 = obtainStyledAttributes2.getBoolean(0, true);
            boolean z4 = obtainStyledAttributes2.getBoolean(1, z3);
            setFocusable(z3);
            setClickable(z4);
            obtainStyledAttributes2.recycle();
        } else {
            setFocusable(true);
            setClickable(true);
        }
        this.ceD = str2;
        this.ceE = str;
        this.ceK = i4;
        this.ceL = i3;
        this.ceM = i5;
        this.cdT = drawable;
        this.cdW = colorStateList;
        this.cer = this.cdT != null;
        this.ceb = i2;
        if (this.ceb == 0) {
            new TypedValue();
            this.ceb = 3309506;
        }
        if (!this.cer && this.cdW == null) {
            this.cdW = com.baidu.poly.widget.b.gT(this.ceb);
            this.cef = this.cdW.getDefaultColor();
        }
        this.cec = q(f5);
        this.ib = q(f6);
        this.cdU = drawable2;
        this.cdV = colorStateList2;
        this.ces = this.cdU != null;
        if (!this.ces && this.cdV == null) {
            this.cdV = com.baidu.poly.widget.b.gU(this.ceb);
            this.ceg = this.cdV.getDefaultColor();
            this.ceh = this.cdV.getColorForState(cdR, this.ceg);
        }
        this.cdX.set(f, f3, f2, f4);
        this.cdY = this.cdX.width() >= 0.0f ? Math.max(f9, 1.0f) : f9;
        this.ab = f7;
        this.aox = f8;
        this.cdZ = i;
        this.cea = z;
        this.ceu.setDuration(this.cdZ);
        if (isChecked()) {
            setProgress(1.0f);
        }
    }

    private int gQ(int i) {
        int i2;
        int size = View.MeasureSpec.getSize(i);
        int mode = View.MeasureSpec.getMode(i);
        if (this.cec == 0 && this.cer) {
            this.cec = this.cdT.getIntrinsicWidth();
        }
        int q = q(this.ceI);
        if (this.cdY == 0.0f) {
            this.cdY = 1.8f;
        }
        if (mode == 1073741824) {
            int paddingLeft = (size - getPaddingLeft()) - getPaddingRight();
            if (this.cec != 0) {
                int q2 = q(i2 * this.cdY);
                RectF rectF = this.cdX;
                int q3 = (this.ceL + q) - ((q2 - this.cec) + q(Math.max(rectF.left, rectF.right)));
                float f = q2;
                RectF rectF2 = this.cdX;
                this.ced = q(rectF2.right + rectF2.left + f + Math.max(q3, 0));
                if (this.ced < 0) {
                    this.cec = 0;
                }
                if (f + Math.max(this.cdX.left, 0.0f) + Math.max(this.cdX.right, 0.0f) + Math.max(q3, 0) > paddingLeft) {
                    this.cec = 0;
                }
            }
            if (this.cec == 0) {
                int q4 = q((((size - getPaddingLeft()) - getPaddingRight()) - Math.max(this.cdX.left, 0.0f)) - Math.max(this.cdX.right, 0.0f));
                if (q4 < 0) {
                    this.cec = 0;
                    this.ced = 0;
                    return size;
                }
                float f2 = q4;
                this.cec = q(f2 / this.cdY);
                RectF rectF3 = this.cdX;
                this.ced = q(f2 + rectF3.left + rectF3.right);
                if (this.ced < 0) {
                    this.cec = 0;
                    this.ced = 0;
                    return size;
                }
                int i3 = q + this.ceL;
                int i4 = q4 - this.cec;
                RectF rectF4 = this.cdX;
                int q5 = i3 - (i4 + q(Math.max(rectF4.left, rectF4.right)));
                if (q5 > 0) {
                    this.cec -= q5;
                }
                if (this.cec < 0) {
                    this.cec = 0;
                    this.ced = 0;
                    return size;
                }
                return size;
            }
            return size;
        }
        if (this.cec == 0) {
            this.cec = q(getResources().getDisplayMetrics().density * 20.0f);
        }
        if (this.cdY == 0.0f) {
            this.cdY = 1.8f;
        }
        int q6 = q(this.cec * this.cdY);
        RectF rectF5 = this.cdX;
        int q7 = q((q + this.ceL) - (((q6 - this.cec) + Math.max(rectF5.left, rectF5.right)) + this.ceK));
        float f3 = q6;
        RectF rectF6 = this.cdX;
        this.ced = q(rectF6.right + rectF6.left + f3 + Math.max(0, q7));
        if (this.ced < 0) {
            this.cec = 0;
            this.ced = 0;
            return size;
        }
        int q8 = q(Math.max(0.0f, this.cdX.left) + f3 + Math.max(0.0f, this.cdX.right) + Math.max(0, q7));
        return Math.max(q8, getPaddingLeft() + q8 + getPaddingRight());
    }

    private int gR(int i) {
        int i2;
        int i3;
        int i4;
        int size = View.MeasureSpec.getSize(i);
        int mode = View.MeasureSpec.getMode(i);
        if (this.ib == 0 && this.cer) {
            this.ib = this.cdT.getIntrinsicHeight();
        }
        if (mode == 1073741824) {
            if (this.ib != 0) {
                RectF rectF = this.cdX;
                this.cee = q(i3 + rectF.top + rectF.bottom);
                this.cee = q(Math.max(this.cee, this.ceJ));
                if ((((this.cee + getPaddingTop()) + getPaddingBottom()) - Math.min(0.0f, this.cdX.top)) - Math.min(0.0f, this.cdX.bottom) > size) {
                    this.ib = 0;
                }
            }
            if (this.ib == 0) {
                this.cee = q(((size - getPaddingTop()) - getPaddingBottom()) + Math.min(0.0f, this.cdX.top) + Math.min(0.0f, this.cdX.bottom));
                if (this.cee < 0) {
                    this.cee = 0;
                    this.ib = 0;
                    return size;
                }
                RectF rectF2 = this.cdX;
                this.ib = q((i4 - rectF2.top) - rectF2.bottom);
            }
            if (this.ib < 0) {
                this.cee = 0;
                this.ib = 0;
                return size;
            }
            return size;
        }
        if (this.ib == 0) {
            this.ib = q(getResources().getDisplayMetrics().density * 20.0f);
        }
        RectF rectF3 = this.cdX;
        this.cee = q(this.ib + rectF3.top + rectF3.bottom);
        if (this.cee < 0) {
            this.cee = 0;
            this.ib = 0;
            return size;
        }
        int q = q(this.ceJ - i2);
        if (q > 0) {
            this.cee += q;
            this.ib = q + this.ib;
        }
        int max = Math.max(this.ib, this.cee);
        return Math.max(Math.max(max, getPaddingTop() + max + getPaddingBottom()), getSuggestedMinimumHeight());
    }

    private float getProgress() {
        return this.cev;
    }

    private boolean getStatusBasedOnPos() {
        return getProgress() > 0.5f;
    }

    private int q(double d) {
        return (int) Math.ceil(d);
    }

    private void setDrawableState(Drawable drawable) {
        if (drawable != null) {
            drawable.setState(getDrawableState());
            invalidate();
        }
    }

    private void setProgress(float f) {
        if (f > 1.0f) {
            f = 1.0f;
        } else if (f < 0.0f) {
            f = 0.0f;
        }
        this.cev = f;
        invalidate();
    }

    private void setup() {
        int i;
        float paddingTop;
        float paddingLeft;
        int i2 = this.cec;
        if (i2 != 0 && (i = this.ib) != 0 && this.ced != 0 && this.cee != 0) {
            if (this.ab == -1.0f) {
                this.ab = Math.min(i2, i) / 2;
            }
            if (this.aox == -1.0f) {
                this.aox = Math.min(this.ced, this.cee) / 2;
            }
            int measuredWidth = (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight();
            int measuredHeight = (getMeasuredHeight() - getPaddingTop()) - getPaddingBottom();
            int q = q((this.ced - Math.min(0.0f, this.cdX.left)) - Math.min(0.0f, this.cdX.right));
            int q2 = q((this.cee - Math.min(0.0f, this.cdX.top)) - Math.min(0.0f, this.cdX.bottom));
            if (measuredHeight <= q2) {
                paddingTop = getPaddingTop() + Math.max(0.0f, this.cdX.top);
            } else {
                paddingTop = (((measuredHeight - q2) + 1) / 2) + getPaddingTop() + Math.max(0.0f, this.cdX.top);
            }
            if (measuredWidth <= this.ced) {
                paddingLeft = getPaddingLeft() + Math.max(0.0f, this.cdX.left);
            } else {
                paddingLeft = (((measuredWidth - q) + 1) / 2) + getPaddingLeft() + Math.max(0.0f, this.cdX.left);
            }
            this.cel.set(paddingLeft, paddingTop, this.cec + paddingLeft, this.ib + paddingTop);
            RectF rectF = this.cel;
            float f = rectF.left;
            RectF rectF2 = this.cdX;
            float f2 = f - rectF2.left;
            RectF rectF3 = this.cem;
            float f3 = rectF.top;
            float f4 = rectF2.top;
            rectF3.set(f2, f3 - f4, this.ced + f2, (f3 - f4) + this.cee);
            RectF rectF4 = this.cen;
            RectF rectF5 = this.cel;
            rectF4.set(rectF5.left, 0.0f, (this.cem.right - this.cdX.right) - rectF5.width(), 0.0f);
            this.aox = Math.min(Math.min(this.cem.width(), this.cem.height()) / 2.0f, this.aox);
            Drawable drawable = this.cdU;
            if (drawable != null) {
                RectF rectF6 = this.cem;
                drawable.setBounds((int) rectF6.left, (int) rectF6.top, q(rectF6.right), q(this.cem.bottom));
            }
            if (this.ceG != null) {
                RectF rectF7 = this.cem;
                float width = ((((((rectF7.width() + this.ceK) - this.cec) - this.cdX.right) - this.ceG.getWidth()) / 2.0f) + rectF7.left) - this.ceM;
                RectF rectF8 = this.cem;
                float height = ((rectF8.height() - this.ceG.getHeight()) / 2.0f) + rectF8.top;
                this.ceo.set(width, height, this.ceG.getWidth() + width, this.ceG.getHeight() + height);
            }
            if (this.ceH != null) {
                RectF rectF9 = this.cem;
                float width2 = ((rectF9.right - (((((rectF9.width() + this.ceK) - this.cec) - this.cdX.left) - this.ceH.getWidth()) / 2.0f)) - this.ceH.getWidth()) + this.ceM;
                RectF rectF10 = this.cem;
                float height2 = ((rectF10.height() - this.ceH.getHeight()) / 2.0f) + rectF10.top;
                this.cep.set(width2, height2, this.ceH.getWidth() + width2, this.ceH.getHeight() + height2);
            }
            this.ceO = true;
        }
    }

    protected void b(boolean z) {
        ObjectAnimator objectAnimator = this.ceu;
        if (objectAnimator != null) {
            if (objectAnimator.isRunning()) {
                this.ceu.cancel();
            }
            this.ceu.setDuration(this.cdZ);
            if (z) {
                this.ceu.setFloatValues(this.cev, 1.0f);
            } else {
                this.ceu.setFloatValues(this.cev, 0.0f);
            }
            this.ceu.start();
        }
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    protected void drawableStateChanged() {
        ColorStateList colorStateList;
        ColorStateList colorStateList2;
        super.drawableStateChanged();
        if (!this.cer && (colorStateList2 = this.cdW) != null) {
            this.cef = colorStateList2.getColorForState(getDrawableState(), this.cef);
        } else {
            setDrawableState(this.cdT);
        }
        int[] iArr = isChecked() ? cdS : cdR;
        ColorStateList textColors = getTextColors();
        if (textColors != null) {
            int defaultColor = textColors.getDefaultColor();
            this.cei = textColors.getColorForState(cdR, defaultColor);
            this.pb = textColors.getColorForState(cdS, defaultColor);
        }
        if (!this.ces && (colorStateList = this.cdV) != null) {
            this.ceg = colorStateList.getColorForState(getDrawableState(), this.ceg);
            this.ceh = this.cdV.getColorForState(iArr, this.ceg);
            return;
        }
        Drawable drawable = this.cdU;
        if ((drawable instanceof StateListDrawable) && this.cea) {
            drawable.setState(iArr);
            this.cek = this.cdU.getCurrent().mutate();
        } else {
            this.cek = null;
        }
        setDrawableState(this.cdU);
        Drawable drawable2 = this.cdU;
        if (drawable2 != null) {
            this.cej = drawable2.getCurrent().mutate();
        }
    }

    public long getAnimationDuration() {
        return this.cdZ;
    }

    public ColorStateList getBackColor() {
        return this.cdV;
    }

    public Drawable getBackDrawable() {
        return this.cdU;
    }

    public float getBackRadius() {
        return this.aox;
    }

    public PointF getBackSizeF() {
        return new PointF(this.cem.width(), this.cem.height());
    }

    public CharSequence getTextOff() {
        return this.ceE;
    }

    public CharSequence getTextOn() {
        return this.ceD;
    }

    public ColorStateList getThumbColor() {
        return this.cdW;
    }

    public Drawable getThumbDrawable() {
        return this.cdT;
    }

    public float getThumbHeight() {
        return this.ib;
    }

    public RectF getThumbMargin() {
        return this.cdX;
    }

    public float getThumbRadius() {
        return this.ab;
    }

    public float getThumbRangeRatio() {
        return this.cdY;
    }

    public float getThumbWidth() {
        return this.cec;
    }

    public int getTintColor() {
        return this.ceb;
    }

    public void o() {
        if (this.ceQ == null) {
            toggle();
            return;
        }
        super.setOnCheckedChangeListener(null);
        toggle();
        super.setOnCheckedChangeListener(this.ceQ);
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (!this.ceO) {
            setup();
        }
        if (this.ceO) {
            if (this.ces) {
                if (this.cea && this.cej != null && this.cek != null) {
                    Drawable drawable = isChecked() ? this.cej : this.cek;
                    Drawable drawable2 = isChecked() ? this.cek : this.cej;
                    int progress = (int) (getProgress() * 255.0f);
                    drawable.setAlpha(progress);
                    drawable.draw(canvas);
                    drawable2.setAlpha(255 - progress);
                    drawable2.draw(canvas);
                } else {
                    this.cdU.setAlpha(255);
                    this.cdU.draw(canvas);
                }
            } else if (this.cea) {
                int i = isChecked() ? this.ceg : this.ceh;
                int i2 = isChecked() ? this.ceh : this.ceg;
                int progress2 = (int) (getProgress() * 255.0f);
                this.ceq.setARGB((Color.alpha(i) * progress2) / 255, Color.red(i), Color.green(i), Color.blue(i));
                RectF rectF = this.cem;
                float f = this.aox;
                canvas.drawRoundRect(rectF, f, f, this.ceq);
                this.ceq.setARGB(((255 - progress2) * Color.alpha(i2)) / 255, Color.red(i2), Color.green(i2), Color.blue(i2));
                RectF rectF2 = this.cem;
                float f2 = this.aox;
                canvas.drawRoundRect(rectF2, f2, f2, this.ceq);
                this.ceq.setAlpha(255);
            } else {
                this.ceq.setColor(this.ceg);
                RectF rectF3 = this.cem;
                float f3 = this.aox;
                canvas.drawRoundRect(rectF3, f3, f3, this.ceq);
            }
            Layout layout = ((double) getProgress()) > 0.5d ? this.ceG : this.ceH;
            RectF rectF4 = ((double) getProgress()) > 0.5d ? this.ceo : this.cep;
            if (layout != null && rectF4 != null) {
                int progress3 = (int) ((((double) getProgress()) >= 0.75d ? (getProgress() * 4.0f) - 3.0f : ((double) getProgress()) < 0.25d ? 1.0f - (getProgress() * 4.0f) : 0.0f) * 255.0f);
                int i3 = ((double) getProgress()) > 0.5d ? this.cei : this.pb;
                layout.getPaint().setARGB((progress3 * Color.alpha(i3)) / 255, Color.red(i3), Color.green(i3), Color.blue(i3));
                canvas.save();
                canvas.translate(rectF4.left, rectF4.top);
                layout.draw(canvas);
                canvas.restore();
            }
            this.cew.set(this.cel);
            this.cew.offset(this.cev * this.cen.width(), 0.0f);
            if (this.cer) {
                Drawable drawable3 = this.cdT;
                RectF rectF5 = this.cew;
                drawable3.setBounds((int) rectF5.left, (int) rectF5.top, q(rectF5.right), q(this.cew.bottom));
                this.cdT.draw(canvas);
            } else {
                this.ceq.setColor(this.cef);
                RectF rectF6 = this.cew;
                float f4 = this.ab;
                canvas.drawRoundRect(rectF6, f4, f4, this.ceq);
            }
            if (this.cet) {
                this.ceC.setColor(Color.parseColor("#AA0000"));
                canvas.drawRect(this.cem, this.ceC);
                this.ceC.setColor(Color.parseColor("#0000FF"));
                canvas.drawRect(this.cew, this.ceC);
                this.ceC.setColor(Color.parseColor("#000000"));
                RectF rectF7 = this.cen;
                float f5 = rectF7.left;
                float f6 = this.cel.top;
                canvas.drawLine(f5, f6, rectF7.right, f6, this.ceC);
                this.ceC.setColor(Color.parseColor("#00CC00"));
                canvas.drawRect(((double) getProgress()) > 0.5d ? this.ceo : this.cep, this.ceC);
            }
        }
    }

    @Override // android.widget.TextView, android.view.View
    protected void onMeasure(int i, int i2) {
        if (this.ceG == null && !TextUtils.isEmpty(this.ceD)) {
            this.ceG = e(this.ceD);
        }
        if (this.ceH == null && !TextUtils.isEmpty(this.ceE)) {
            this.ceH = e(this.ceE);
        }
        Layout layout = this.ceG;
        float width = layout != null ? layout.getWidth() : 0.0f;
        Layout layout2 = this.ceH;
        float width2 = layout2 != null ? layout2.getWidth() : 0.0f;
        if (width == 0.0f && width2 == 0.0f) {
            this.ceI = 0.0f;
        } else {
            this.ceI = Math.max(width, width2);
        }
        Layout layout3 = this.ceG;
        float height = layout3 != null ? layout3.getHeight() : 0.0f;
        Layout layout4 = this.ceH;
        float height2 = layout4 != null ? layout4.getHeight() : 0.0f;
        if (height == 0.0f && height2 == 0.0f) {
            this.ceJ = 0.0f;
        } else {
            this.ceJ = Math.max(height, height2);
        }
        setMeasuredDimension(gQ(i), gR(i2));
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        a aVar = (a) parcelable;
        a(aVar.ceR, aVar.ceS);
        this.ceN = true;
        super.onRestoreInstanceState(aVar.getSuperState());
        this.ceN = false;
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    public Parcelable onSaveInstanceState() {
        a aVar = new a(super.onSaveInstanceState());
        aVar.ceR = this.ceD;
        aVar.ceS = this.ceE;
        return aVar;
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        if (i == i3 && i2 == i4) {
            return;
        }
        setup();
    }

    @Override // android.widget.TextView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (isEnabled() && isClickable() && isFocusable() && this.ceO) {
            int action = motionEvent.getAction();
            float x = motionEvent.getX() - this.cex;
            float y = motionEvent.getY() - this.cey;
            switch (action) {
                case 0:
                    this.cex = motionEvent.getX();
                    this.cey = motionEvent.getY();
                    this.cez = this.cex;
                    setPressed(true);
                    break;
                case 1:
                case 3:
                    this.ceP = false;
                    setPressed(false);
                    float eventTime = (float) (motionEvent.getEventTime() - motionEvent.getDownTime());
                    if (Math.abs(x) < this.ceA && Math.abs(y) < this.ceA && eventTime < this.ceB) {
                        performClick();
                        break;
                    } else {
                        boolean statusBasedOnPos = getStatusBasedOnPos();
                        if (statusBasedOnPos != isChecked()) {
                            playSoundEffect(0);
                            setChecked(statusBasedOnPos);
                            break;
                        } else {
                            b(statusBasedOnPos);
                            break;
                        }
                    }
                    break;
                case 2:
                    float x2 = motionEvent.getX();
                    setProgress(getProgress() + ((x2 - this.cez) / this.cen.width()));
                    if (!this.ceP && (Math.abs(x) > this.ceA / 2 || Math.abs(y) > this.ceA / 2)) {
                        if (y != 0.0f && Math.abs(x) <= Math.abs(y)) {
                            if (Math.abs(y) > Math.abs(x)) {
                                return false;
                            }
                        } else {
                            abu();
                        }
                    }
                    this.cez = x2;
                    break;
            }
            return true;
        }
        return false;
    }

    @Override // android.widget.CompoundButton, android.view.View
    public boolean performClick() {
        return super.performClick();
    }

    public void setAnimationDuration(long j) {
        this.cdZ = j;
    }

    public void setBackColor(ColorStateList colorStateList) {
        this.cdV = colorStateList;
        if (this.cdV != null) {
            setBackDrawable(null);
        }
        invalidate();
    }

    public void setBackColorRes(int i) {
        setBackColor(getResources().getColorStateList(i));
    }

    public void setBackDrawable(Drawable drawable) {
        this.cdU = drawable;
        this.ces = this.cdU != null;
        refreshDrawableState();
        this.ceO = false;
        requestLayout();
        invalidate();
    }

    public void setBackDrawableRes(int i) {
        setBackDrawable(getResources().getDrawable(i));
    }

    public void setBackRadius(float f) {
        this.aox = f;
        if (this.ces) {
            return;
        }
        invalidate();
    }

    @Override // android.widget.CompoundButton, android.widget.Checkable
    public void setChecked(boolean z) {
        if (isChecked() != z) {
            b(z);
        }
        if (this.ceN) {
            setCheckedImmediatelyNoEvent(z);
        } else {
            super.setChecked(z);
        }
    }

    public void setCheckedImmediately(boolean z) {
        super.setChecked(z);
        ObjectAnimator objectAnimator = this.ceu;
        if (objectAnimator != null && objectAnimator.isRunning()) {
            this.ceu.cancel();
        }
        setProgress(z ? 1.0f : 0.0f);
        invalidate();
    }

    public void setCheckedImmediatelyNoEvent(boolean z) {
        if (this.ceQ == null) {
            setCheckedImmediately(z);
            return;
        }
        super.setOnCheckedChangeListener(null);
        setCheckedImmediately(z);
        super.setOnCheckedChangeListener(this.ceQ);
    }

    public void setCheckedNoEvent(boolean z) {
        if (this.ceQ == null) {
            setChecked(z);
            return;
        }
        super.setOnCheckedChangeListener(null);
        setChecked(z);
        super.setOnCheckedChangeListener(this.ceQ);
    }

    public void setDrawDebugRect(boolean z) {
        this.cet = z;
        invalidate();
    }

    public void setFadeBack(boolean z) {
        this.cea = z;
    }

    @Override // android.widget.CompoundButton
    public void setOnCheckedChangeListener(CompoundButton.OnCheckedChangeListener onCheckedChangeListener) {
        super.setOnCheckedChangeListener(onCheckedChangeListener);
        this.ceQ = onCheckedChangeListener;
    }

    public void setTextAdjust(int i) {
        this.ceM = i;
        this.ceO = false;
        requestLayout();
        invalidate();
    }

    public void setTextExtra(int i) {
        this.ceL = i;
        this.ceO = false;
        requestLayout();
        invalidate();
    }

    public void setTextThumbInset(int i) {
        this.ceK = i;
        this.ceO = false;
        requestLayout();
        invalidate();
    }

    public void setThumbColor(ColorStateList colorStateList) {
        this.cdW = colorStateList;
        if (this.cdW != null) {
            setThumbDrawable(null);
        }
        invalidate();
    }

    public void setThumbColorRes(int i) {
        setThumbColor(getResources().getColorStateList(i));
    }

    public void setThumbDrawable(Drawable drawable) {
        this.cdT = drawable;
        this.cer = this.cdT != null;
        refreshDrawableState();
        this.ceO = false;
        requestLayout();
        invalidate();
    }

    public void setThumbDrawableRes(int i) {
        setThumbDrawable(getResources().getDrawable(i));
    }

    public void setThumbMargin(RectF rectF) {
        if (rectF == null) {
            a(0.0f, 0.0f, 0.0f, 0.0f);
        } else {
            a(rectF.left, rectF.top, rectF.right, rectF.bottom);
        }
    }

    public void setThumbRadius(float f) {
        this.ab = f;
        if (this.cer) {
            return;
        }
        invalidate();
    }

    public void setThumbRangeRatio(float f) {
        this.cdY = f;
        this.ceO = false;
        requestLayout();
    }

    public void setTintColor(int i) {
        this.ceb = i;
        this.cdW = com.baidu.poly.widget.b.gT(this.ceb);
        this.cdV = com.baidu.poly.widget.b.gU(this.ceb);
        this.ces = false;
        this.cer = false;
        refreshDrawableState();
        invalidate();
    }

    public SwitchButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.cet = false;
        this.ceN = false;
        this.ceO = false;
        this.ceP = false;
        c(attributeSet);
    }

    public SwitchButton(Context context) {
        super(context);
        this.cet = false;
        this.ceN = false;
        this.ceO = false;
        this.ceP = false;
        c(null);
    }

    private Layout e(CharSequence charSequence) {
        TextPaint textPaint = this.ceF;
        return new StaticLayout(charSequence, textPaint, (int) Math.ceil(Layout.getDesiredWidth(charSequence, textPaint)), Layout.Alignment.ALIGN_CENTER, 1.0f, 0.0f, false);
    }

    public void a(float f, float f2, float f3, float f4) {
        this.cdX.set(f, f2, f3, f4);
        this.ceO = false;
        requestLayout();
    }

    public void a(CharSequence charSequence, CharSequence charSequence2) {
        this.ceD = charSequence;
        this.ceE = charSequence2;
        this.ceG = null;
        this.ceH = null;
        this.ceO = false;
        requestLayout();
        invalidate();
    }
}
