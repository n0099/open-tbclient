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
    private static int[] bGY = {16842912, 16842910, 16842919};
    private static int[] bGZ = {-16842912, 16842910, 16842919};
    private float ab;
    private float anl;
    private boolean bHA;
    private ObjectAnimator bHB;
    private float bHC;
    private RectF bHD;
    private float bHE;
    private float bHF;
    private float bHG;
    private int bHH;
    private int bHI;
    private Paint bHJ;
    private CharSequence bHK;
    private CharSequence bHL;
    private TextPaint bHM;
    private Layout bHN;
    private Layout bHO;
    private float bHP;
    private float bHQ;
    private int bHR;
    private int bHS;
    private int bHT;
    private boolean bHU;
    private boolean bHV;
    private boolean bHW;
    private CompoundButton.OnCheckedChangeListener bHX;
    private Drawable bHa;
    private Drawable bHb;
    private ColorStateList bHc;
    private ColorStateList bHd;
    private RectF bHe;
    private float bHf;
    private long bHg;
    private boolean bHh;
    private int bHi;
    private int bHj;
    private int bHk;
    private int bHl;
    private int bHm;
    private int bHn;
    private int bHo;
    private int bHp;
    private Drawable bHq;
    private Drawable bHr;
    private RectF bHs;
    private RectF bHt;
    private RectF bHu;
    private RectF bHv;
    private RectF bHw;
    private Paint bHx;
    private boolean bHy;
    private boolean bHz;
    private int ib;
    private int pb;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public static class a extends View.BaseSavedState {
        public static final Parcelable.Creator<a> CREATOR = new C0274a();
        CharSequence bHY;
        CharSequence bHZ;

        /* renamed from: com.baidu.poly.widget.SwitchButton$a$a  reason: collision with other inner class name */
        /* loaded from: classes6.dex */
        static class C0274a implements Parcelable.Creator<a> {
            C0274a() {
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // android.os.Parcelable.Creator
            /* renamed from: fY */
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
            TextUtils.writeToParcel(this.bHY, parcel, i);
            TextUtils.writeToParcel(this.bHZ, parcel, i);
        }

        a(Parcelable parcelable) {
            super(parcelable);
        }

        private a(Parcel parcel) {
            super(parcel);
            this.bHY = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
            this.bHZ = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
        }
    }

    public SwitchButton(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.bHA = false;
        this.bHU = false;
        this.bHV = false;
        this.bHW = false;
        c(attributeSet);
    }

    private void Uv() {
        ViewParent parent = getParent();
        if (parent != null) {
            parent.requestDisallowInterceptTouchEvent(true);
        }
        this.bHW = true;
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
        this.bHH = ViewConfiguration.get(getContext()).getScaledTouchSlop();
        this.bHI = ViewConfiguration.getPressedStateDuration() + ViewConfiguration.getTapTimeout();
        this.bHx = new Paint(1);
        this.bHJ = new Paint(1);
        this.bHJ.setStyle(Paint.Style.STROKE);
        this.bHJ.setStrokeWidth(getResources().getDisplayMetrics().density);
        this.bHM = getPaint();
        this.bHs = new RectF();
        this.bHt = new RectF();
        this.bHu = new RectF();
        this.bHe = new RectF();
        this.bHv = new RectF();
        this.bHw = new RectF();
        this.bHB = ObjectAnimator.ofFloat(this, "progress", 0.0f, 0.0f).setDuration(250L);
        this.bHB.setInterpolator(new AccelerateDecelerateInterpolator());
        this.bHD = new RectF();
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
        this.bHK = str2;
        this.bHL = str;
        this.bHR = i4;
        this.bHS = i3;
        this.bHT = i5;
        this.bHa = drawable;
        this.bHd = colorStateList;
        this.bHy = this.bHa != null;
        this.bHi = i2;
        if (this.bHi == 0) {
            new TypedValue();
            this.bHi = 3309506;
        }
        if (!this.bHy && this.bHd == null) {
            this.bHd = com.baidu.poly.widget.b.fV(this.bHi);
            this.bHm = this.bHd.getDefaultColor();
        }
        this.bHj = p(f5);
        this.ib = p(f6);
        this.bHb = drawable2;
        this.bHc = colorStateList2;
        this.bHz = this.bHb != null;
        if (!this.bHz && this.bHc == null) {
            this.bHc = com.baidu.poly.widget.b.fW(this.bHi);
            this.bHn = this.bHc.getDefaultColor();
            this.bHo = this.bHc.getColorForState(bGY, this.bHn);
        }
        this.bHe.set(f, f3, f2, f4);
        this.bHf = this.bHe.width() >= 0.0f ? Math.max(f9, 1.0f) : f9;
        this.ab = f7;
        this.anl = f8;
        this.bHg = i;
        this.bHh = z;
        this.bHB.setDuration(this.bHg);
        if (isChecked()) {
            setProgress(1.0f);
        }
    }

    private int fS(int i) {
        int i2;
        int size = View.MeasureSpec.getSize(i);
        int mode = View.MeasureSpec.getMode(i);
        if (this.bHj == 0 && this.bHy) {
            this.bHj = this.bHa.getIntrinsicWidth();
        }
        int p = p(this.bHP);
        if (this.bHf == 0.0f) {
            this.bHf = 1.8f;
        }
        if (mode == 1073741824) {
            int paddingLeft = (size - getPaddingLeft()) - getPaddingRight();
            if (this.bHj != 0) {
                int p2 = p(i2 * this.bHf);
                RectF rectF = this.bHe;
                int p3 = (this.bHS + p) - ((p2 - this.bHj) + p(Math.max(rectF.left, rectF.right)));
                float f = p2;
                RectF rectF2 = this.bHe;
                this.bHk = p(rectF2.right + rectF2.left + f + Math.max(p3, 0));
                if (this.bHk < 0) {
                    this.bHj = 0;
                }
                if (f + Math.max(this.bHe.left, 0.0f) + Math.max(this.bHe.right, 0.0f) + Math.max(p3, 0) > paddingLeft) {
                    this.bHj = 0;
                }
            }
            if (this.bHj == 0) {
                int p4 = p((((size - getPaddingLeft()) - getPaddingRight()) - Math.max(this.bHe.left, 0.0f)) - Math.max(this.bHe.right, 0.0f));
                if (p4 < 0) {
                    this.bHj = 0;
                    this.bHk = 0;
                    return size;
                }
                float f2 = p4;
                this.bHj = p(f2 / this.bHf);
                RectF rectF3 = this.bHe;
                this.bHk = p(f2 + rectF3.left + rectF3.right);
                if (this.bHk < 0) {
                    this.bHj = 0;
                    this.bHk = 0;
                    return size;
                }
                int i3 = p + this.bHS;
                int i4 = p4 - this.bHj;
                RectF rectF4 = this.bHe;
                int p5 = i3 - (i4 + p(Math.max(rectF4.left, rectF4.right)));
                if (p5 > 0) {
                    this.bHj -= p5;
                }
                if (this.bHj < 0) {
                    this.bHj = 0;
                    this.bHk = 0;
                    return size;
                }
                return size;
            }
            return size;
        }
        if (this.bHj == 0) {
            this.bHj = p(getResources().getDisplayMetrics().density * 20.0f);
        }
        if (this.bHf == 0.0f) {
            this.bHf = 1.8f;
        }
        int p6 = p(this.bHj * this.bHf);
        RectF rectF5 = this.bHe;
        int p7 = p((p + this.bHS) - (((p6 - this.bHj) + Math.max(rectF5.left, rectF5.right)) + this.bHR));
        float f3 = p6;
        RectF rectF6 = this.bHe;
        this.bHk = p(rectF6.right + rectF6.left + f3 + Math.max(0, p7));
        if (this.bHk < 0) {
            this.bHj = 0;
            this.bHk = 0;
            return size;
        }
        int p8 = p(Math.max(0.0f, this.bHe.left) + f3 + Math.max(0.0f, this.bHe.right) + Math.max(0, p7));
        return Math.max(p8, getPaddingLeft() + p8 + getPaddingRight());
    }

    private int fT(int i) {
        int i2;
        int i3;
        int i4;
        int size = View.MeasureSpec.getSize(i);
        int mode = View.MeasureSpec.getMode(i);
        if (this.ib == 0 && this.bHy) {
            this.ib = this.bHa.getIntrinsicHeight();
        }
        if (mode == 1073741824) {
            if (this.ib != 0) {
                RectF rectF = this.bHe;
                this.bHl = p(i3 + rectF.top + rectF.bottom);
                this.bHl = p(Math.max(this.bHl, this.bHQ));
                if ((((this.bHl + getPaddingTop()) + getPaddingBottom()) - Math.min(0.0f, this.bHe.top)) - Math.min(0.0f, this.bHe.bottom) > size) {
                    this.ib = 0;
                }
            }
            if (this.ib == 0) {
                this.bHl = p(((size - getPaddingTop()) - getPaddingBottom()) + Math.min(0.0f, this.bHe.top) + Math.min(0.0f, this.bHe.bottom));
                if (this.bHl < 0) {
                    this.bHl = 0;
                    this.ib = 0;
                    return size;
                }
                RectF rectF2 = this.bHe;
                this.ib = p((i4 - rectF2.top) - rectF2.bottom);
            }
            if (this.ib < 0) {
                this.bHl = 0;
                this.ib = 0;
                return size;
            }
            return size;
        }
        if (this.ib == 0) {
            this.ib = p(getResources().getDisplayMetrics().density * 20.0f);
        }
        RectF rectF3 = this.bHe;
        this.bHl = p(this.ib + rectF3.top + rectF3.bottom);
        if (this.bHl < 0) {
            this.bHl = 0;
            this.ib = 0;
            return size;
        }
        int p = p(this.bHQ - i2);
        if (p > 0) {
            this.bHl += p;
            this.ib = p + this.ib;
        }
        int max = Math.max(this.ib, this.bHl);
        return Math.max(Math.max(max, getPaddingTop() + max + getPaddingBottom()), getSuggestedMinimumHeight());
    }

    private float getProgress() {
        return this.bHC;
    }

    private boolean getStatusBasedOnPos() {
        return getProgress() > 0.5f;
    }

    private int p(double d) {
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
        this.bHC = f;
        invalidate();
    }

    private void setup() {
        int i;
        float paddingTop;
        float paddingLeft;
        int i2 = this.bHj;
        if (i2 != 0 && (i = this.ib) != 0 && this.bHk != 0 && this.bHl != 0) {
            if (this.ab == -1.0f) {
                this.ab = Math.min(i2, i) / 2;
            }
            if (this.anl == -1.0f) {
                this.anl = Math.min(this.bHk, this.bHl) / 2;
            }
            int measuredWidth = (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight();
            int measuredHeight = (getMeasuredHeight() - getPaddingTop()) - getPaddingBottom();
            int p = p((this.bHk - Math.min(0.0f, this.bHe.left)) - Math.min(0.0f, this.bHe.right));
            int p2 = p((this.bHl - Math.min(0.0f, this.bHe.top)) - Math.min(0.0f, this.bHe.bottom));
            if (measuredHeight <= p2) {
                paddingTop = getPaddingTop() + Math.max(0.0f, this.bHe.top);
            } else {
                paddingTop = (((measuredHeight - p2) + 1) / 2) + getPaddingTop() + Math.max(0.0f, this.bHe.top);
            }
            if (measuredWidth <= this.bHk) {
                paddingLeft = getPaddingLeft() + Math.max(0.0f, this.bHe.left);
            } else {
                paddingLeft = (((measuredWidth - p) + 1) / 2) + getPaddingLeft() + Math.max(0.0f, this.bHe.left);
            }
            this.bHs.set(paddingLeft, paddingTop, this.bHj + paddingLeft, this.ib + paddingTop);
            RectF rectF = this.bHs;
            float f = rectF.left;
            RectF rectF2 = this.bHe;
            float f2 = f - rectF2.left;
            RectF rectF3 = this.bHt;
            float f3 = rectF.top;
            float f4 = rectF2.top;
            rectF3.set(f2, f3 - f4, this.bHk + f2, (f3 - f4) + this.bHl);
            RectF rectF4 = this.bHu;
            RectF rectF5 = this.bHs;
            rectF4.set(rectF5.left, 0.0f, (this.bHt.right - this.bHe.right) - rectF5.width(), 0.0f);
            this.anl = Math.min(Math.min(this.bHt.width(), this.bHt.height()) / 2.0f, this.anl);
            Drawable drawable = this.bHb;
            if (drawable != null) {
                RectF rectF6 = this.bHt;
                drawable.setBounds((int) rectF6.left, (int) rectF6.top, p(rectF6.right), p(this.bHt.bottom));
            }
            if (this.bHN != null) {
                RectF rectF7 = this.bHt;
                float width = ((((((rectF7.width() + this.bHR) - this.bHj) - this.bHe.right) - this.bHN.getWidth()) / 2.0f) + rectF7.left) - this.bHT;
                RectF rectF8 = this.bHt;
                float height = ((rectF8.height() - this.bHN.getHeight()) / 2.0f) + rectF8.top;
                this.bHv.set(width, height, this.bHN.getWidth() + width, this.bHN.getHeight() + height);
            }
            if (this.bHO != null) {
                RectF rectF9 = this.bHt;
                float width2 = ((rectF9.right - (((((rectF9.width() + this.bHR) - this.bHj) - this.bHe.left) - this.bHO.getWidth()) / 2.0f)) - this.bHO.getWidth()) + this.bHT;
                RectF rectF10 = this.bHt;
                float height2 = ((rectF10.height() - this.bHO.getHeight()) / 2.0f) + rectF10.top;
                this.bHw.set(width2, height2, this.bHO.getWidth() + width2, this.bHO.getHeight() + height2);
            }
            this.bHV = true;
        }
    }

    protected void b(boolean z) {
        ObjectAnimator objectAnimator = this.bHB;
        if (objectAnimator != null) {
            if (objectAnimator.isRunning()) {
                this.bHB.cancel();
            }
            this.bHB.setDuration(this.bHg);
            if (z) {
                this.bHB.setFloatValues(this.bHC, 1.0f);
            } else {
                this.bHB.setFloatValues(this.bHC, 0.0f);
            }
            this.bHB.start();
        }
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    protected void drawableStateChanged() {
        ColorStateList colorStateList;
        ColorStateList colorStateList2;
        super.drawableStateChanged();
        if (!this.bHy && (colorStateList2 = this.bHd) != null) {
            this.bHm = colorStateList2.getColorForState(getDrawableState(), this.bHm);
        } else {
            setDrawableState(this.bHa);
        }
        int[] iArr = isChecked() ? bGZ : bGY;
        ColorStateList textColors = getTextColors();
        if (textColors != null) {
            int defaultColor = textColors.getDefaultColor();
            this.bHp = textColors.getColorForState(bGY, defaultColor);
            this.pb = textColors.getColorForState(bGZ, defaultColor);
        }
        if (!this.bHz && (colorStateList = this.bHc) != null) {
            this.bHn = colorStateList.getColorForState(getDrawableState(), this.bHn);
            this.bHo = this.bHc.getColorForState(iArr, this.bHn);
            return;
        }
        Drawable drawable = this.bHb;
        if ((drawable instanceof StateListDrawable) && this.bHh) {
            drawable.setState(iArr);
            this.bHr = this.bHb.getCurrent().mutate();
        } else {
            this.bHr = null;
        }
        setDrawableState(this.bHb);
        Drawable drawable2 = this.bHb;
        if (drawable2 != null) {
            this.bHq = drawable2.getCurrent().mutate();
        }
    }

    public long getAnimationDuration() {
        return this.bHg;
    }

    public ColorStateList getBackColor() {
        return this.bHc;
    }

    public Drawable getBackDrawable() {
        return this.bHb;
    }

    public float getBackRadius() {
        return this.anl;
    }

    public PointF getBackSizeF() {
        return new PointF(this.bHt.width(), this.bHt.height());
    }

    public CharSequence getTextOff() {
        return this.bHL;
    }

    public CharSequence getTextOn() {
        return this.bHK;
    }

    public ColorStateList getThumbColor() {
        return this.bHd;
    }

    public Drawable getThumbDrawable() {
        return this.bHa;
    }

    public float getThumbHeight() {
        return this.ib;
    }

    public RectF getThumbMargin() {
        return this.bHe;
    }

    public float getThumbRadius() {
        return this.ab;
    }

    public float getThumbRangeRatio() {
        return this.bHf;
    }

    public float getThumbWidth() {
        return this.bHj;
    }

    public int getTintColor() {
        return this.bHi;
    }

    public void o() {
        if (this.bHX == null) {
            toggle();
            return;
        }
        super.setOnCheckedChangeListener(null);
        toggle();
        super.setOnCheckedChangeListener(this.bHX);
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (!this.bHV) {
            setup();
        }
        if (this.bHV) {
            if (this.bHz) {
                if (this.bHh && this.bHq != null && this.bHr != null) {
                    Drawable drawable = isChecked() ? this.bHq : this.bHr;
                    Drawable drawable2 = isChecked() ? this.bHr : this.bHq;
                    int progress = (int) (getProgress() * 255.0f);
                    drawable.setAlpha(progress);
                    drawable.draw(canvas);
                    drawable2.setAlpha(255 - progress);
                    drawable2.draw(canvas);
                } else {
                    this.bHb.setAlpha(255);
                    this.bHb.draw(canvas);
                }
            } else if (this.bHh) {
                int i = isChecked() ? this.bHn : this.bHo;
                int i2 = isChecked() ? this.bHo : this.bHn;
                int progress2 = (int) (getProgress() * 255.0f);
                this.bHx.setARGB((Color.alpha(i) * progress2) / 255, Color.red(i), Color.green(i), Color.blue(i));
                RectF rectF = this.bHt;
                float f = this.anl;
                canvas.drawRoundRect(rectF, f, f, this.bHx);
                this.bHx.setARGB(((255 - progress2) * Color.alpha(i2)) / 255, Color.red(i2), Color.green(i2), Color.blue(i2));
                RectF rectF2 = this.bHt;
                float f2 = this.anl;
                canvas.drawRoundRect(rectF2, f2, f2, this.bHx);
                this.bHx.setAlpha(255);
            } else {
                this.bHx.setColor(this.bHn);
                RectF rectF3 = this.bHt;
                float f3 = this.anl;
                canvas.drawRoundRect(rectF3, f3, f3, this.bHx);
            }
            Layout layout = ((double) getProgress()) > 0.5d ? this.bHN : this.bHO;
            RectF rectF4 = ((double) getProgress()) > 0.5d ? this.bHv : this.bHw;
            if (layout != null && rectF4 != null) {
                int progress3 = (int) ((((double) getProgress()) >= 0.75d ? (getProgress() * 4.0f) - 3.0f : ((double) getProgress()) < 0.25d ? 1.0f - (getProgress() * 4.0f) : 0.0f) * 255.0f);
                int i3 = ((double) getProgress()) > 0.5d ? this.bHp : this.pb;
                layout.getPaint().setARGB((progress3 * Color.alpha(i3)) / 255, Color.red(i3), Color.green(i3), Color.blue(i3));
                canvas.save();
                canvas.translate(rectF4.left, rectF4.top);
                layout.draw(canvas);
                canvas.restore();
            }
            this.bHD.set(this.bHs);
            this.bHD.offset(this.bHC * this.bHu.width(), 0.0f);
            if (this.bHy) {
                Drawable drawable3 = this.bHa;
                RectF rectF5 = this.bHD;
                drawable3.setBounds((int) rectF5.left, (int) rectF5.top, p(rectF5.right), p(this.bHD.bottom));
                this.bHa.draw(canvas);
            } else {
                this.bHx.setColor(this.bHm);
                RectF rectF6 = this.bHD;
                float f4 = this.ab;
                canvas.drawRoundRect(rectF6, f4, f4, this.bHx);
            }
            if (this.bHA) {
                this.bHJ.setColor(Color.parseColor("#AA0000"));
                canvas.drawRect(this.bHt, this.bHJ);
                this.bHJ.setColor(Color.parseColor("#0000FF"));
                canvas.drawRect(this.bHD, this.bHJ);
                this.bHJ.setColor(Color.parseColor("#000000"));
                RectF rectF7 = this.bHu;
                float f5 = rectF7.left;
                float f6 = this.bHs.top;
                canvas.drawLine(f5, f6, rectF7.right, f6, this.bHJ);
                this.bHJ.setColor(Color.parseColor("#00CC00"));
                canvas.drawRect(((double) getProgress()) > 0.5d ? this.bHv : this.bHw, this.bHJ);
            }
        }
    }

    @Override // android.widget.TextView, android.view.View
    protected void onMeasure(int i, int i2) {
        if (this.bHN == null && !TextUtils.isEmpty(this.bHK)) {
            this.bHN = d(this.bHK);
        }
        if (this.bHO == null && !TextUtils.isEmpty(this.bHL)) {
            this.bHO = d(this.bHL);
        }
        Layout layout = this.bHN;
        float width = layout != null ? layout.getWidth() : 0.0f;
        Layout layout2 = this.bHO;
        float width2 = layout2 != null ? layout2.getWidth() : 0.0f;
        if (width == 0.0f && width2 == 0.0f) {
            this.bHP = 0.0f;
        } else {
            this.bHP = Math.max(width, width2);
        }
        Layout layout3 = this.bHN;
        float height = layout3 != null ? layout3.getHeight() : 0.0f;
        Layout layout4 = this.bHO;
        float height2 = layout4 != null ? layout4.getHeight() : 0.0f;
        if (height == 0.0f && height2 == 0.0f) {
            this.bHQ = 0.0f;
        } else {
            this.bHQ = Math.max(height, height2);
        }
        setMeasuredDimension(fS(i), fT(i2));
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        a aVar = (a) parcelable;
        a(aVar.bHY, aVar.bHZ);
        this.bHU = true;
        super.onRestoreInstanceState(aVar.getSuperState());
        this.bHU = false;
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    public Parcelable onSaveInstanceState() {
        a aVar = new a(super.onSaveInstanceState());
        aVar.bHY = this.bHK;
        aVar.bHZ = this.bHL;
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
        if (isEnabled() && isClickable() && isFocusable() && this.bHV) {
            int action = motionEvent.getAction();
            float x = motionEvent.getX() - this.bHE;
            float y = motionEvent.getY() - this.bHF;
            switch (action) {
                case 0:
                    this.bHE = motionEvent.getX();
                    this.bHF = motionEvent.getY();
                    this.bHG = this.bHE;
                    setPressed(true);
                    break;
                case 1:
                case 3:
                    this.bHW = false;
                    setPressed(false);
                    float eventTime = (float) (motionEvent.getEventTime() - motionEvent.getDownTime());
                    if (Math.abs(x) < this.bHH && Math.abs(y) < this.bHH && eventTime < this.bHI) {
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
                    setProgress(getProgress() + ((x2 - this.bHG) / this.bHu.width()));
                    if (!this.bHW && (Math.abs(x) > this.bHH / 2 || Math.abs(y) > this.bHH / 2)) {
                        if (y != 0.0f && Math.abs(x) <= Math.abs(y)) {
                            if (Math.abs(y) > Math.abs(x)) {
                                return false;
                            }
                        } else {
                            Uv();
                        }
                    }
                    this.bHG = x2;
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
        this.bHg = j;
    }

    public void setBackColor(ColorStateList colorStateList) {
        this.bHc = colorStateList;
        if (this.bHc != null) {
            setBackDrawable(null);
        }
        invalidate();
    }

    public void setBackColorRes(int i) {
        setBackColor(getResources().getColorStateList(i));
    }

    public void setBackDrawable(Drawable drawable) {
        this.bHb = drawable;
        this.bHz = this.bHb != null;
        refreshDrawableState();
        this.bHV = false;
        requestLayout();
        invalidate();
    }

    public void setBackDrawableRes(int i) {
        setBackDrawable(getResources().getDrawable(i));
    }

    public void setBackRadius(float f) {
        this.anl = f;
        if (this.bHz) {
            return;
        }
        invalidate();
    }

    @Override // android.widget.CompoundButton, android.widget.Checkable
    public void setChecked(boolean z) {
        if (isChecked() != z) {
            b(z);
        }
        if (this.bHU) {
            setCheckedImmediatelyNoEvent(z);
        } else {
            super.setChecked(z);
        }
    }

    public void setCheckedImmediately(boolean z) {
        super.setChecked(z);
        ObjectAnimator objectAnimator = this.bHB;
        if (objectAnimator != null && objectAnimator.isRunning()) {
            this.bHB.cancel();
        }
        setProgress(z ? 1.0f : 0.0f);
        invalidate();
    }

    public void setCheckedImmediatelyNoEvent(boolean z) {
        if (this.bHX == null) {
            setCheckedImmediately(z);
            return;
        }
        super.setOnCheckedChangeListener(null);
        setCheckedImmediately(z);
        super.setOnCheckedChangeListener(this.bHX);
    }

    public void setCheckedNoEvent(boolean z) {
        if (this.bHX == null) {
            setChecked(z);
            return;
        }
        super.setOnCheckedChangeListener(null);
        setChecked(z);
        super.setOnCheckedChangeListener(this.bHX);
    }

    public void setDrawDebugRect(boolean z) {
        this.bHA = z;
        invalidate();
    }

    public void setFadeBack(boolean z) {
        this.bHh = z;
    }

    @Override // android.widget.CompoundButton
    public void setOnCheckedChangeListener(CompoundButton.OnCheckedChangeListener onCheckedChangeListener) {
        super.setOnCheckedChangeListener(onCheckedChangeListener);
        this.bHX = onCheckedChangeListener;
    }

    public void setTextAdjust(int i) {
        this.bHT = i;
        this.bHV = false;
        requestLayout();
        invalidate();
    }

    public void setTextExtra(int i) {
        this.bHS = i;
        this.bHV = false;
        requestLayout();
        invalidate();
    }

    public void setTextThumbInset(int i) {
        this.bHR = i;
        this.bHV = false;
        requestLayout();
        invalidate();
    }

    public void setThumbColor(ColorStateList colorStateList) {
        this.bHd = colorStateList;
        if (this.bHd != null) {
            setThumbDrawable(null);
        }
        invalidate();
    }

    public void setThumbColorRes(int i) {
        setThumbColor(getResources().getColorStateList(i));
    }

    public void setThumbDrawable(Drawable drawable) {
        this.bHa = drawable;
        this.bHy = this.bHa != null;
        refreshDrawableState();
        this.bHV = false;
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
        if (this.bHy) {
            return;
        }
        invalidate();
    }

    public void setThumbRangeRatio(float f) {
        this.bHf = f;
        this.bHV = false;
        requestLayout();
    }

    public void setTintColor(int i) {
        this.bHi = i;
        this.bHd = com.baidu.poly.widget.b.fV(this.bHi);
        this.bHc = com.baidu.poly.widget.b.fW(this.bHi);
        this.bHz = false;
        this.bHy = false;
        refreshDrawableState();
        invalidate();
    }

    public SwitchButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.bHA = false;
        this.bHU = false;
        this.bHV = false;
        this.bHW = false;
        c(attributeSet);
    }

    public SwitchButton(Context context) {
        super(context);
        this.bHA = false;
        this.bHU = false;
        this.bHV = false;
        this.bHW = false;
        c(null);
    }

    private Layout d(CharSequence charSequence) {
        TextPaint textPaint = this.bHM;
        return new StaticLayout(charSequence, textPaint, (int) Math.ceil(Layout.getDesiredWidth(charSequence, textPaint)), Layout.Alignment.ALIGN_CENTER, 1.0f, 0.0f, false);
    }

    public void a(float f, float f2, float f3, float f4) {
        this.bHe.set(f, f2, f3, f4);
        this.bHV = false;
        requestLayout();
    }

    public void a(CharSequence charSequence, CharSequence charSequence2) {
        this.bHK = charSequence;
        this.bHL = charSequence2;
        this.bHN = null;
        this.bHO = null;
        this.bHV = false;
        requestLayout();
        invalidate();
    }
}
