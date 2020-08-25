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
    private static int[] bGU = {16842912, 16842910, 16842919};
    private static int[] bGV = {-16842912, 16842910, 16842919};
    private float ab;
    private float anj;
    private Drawable bGW;
    private Drawable bGX;
    private ColorStateList bGY;
    private ColorStateList bGZ;
    private float bHA;
    private float bHB;
    private float bHC;
    private int bHD;
    private int bHE;
    private Paint bHF;
    private CharSequence bHG;
    private CharSequence bHH;
    private TextPaint bHI;
    private Layout bHJ;
    private Layout bHK;
    private float bHL;
    private float bHM;
    private int bHN;
    private int bHO;
    private int bHP;
    private boolean bHQ;
    private boolean bHR;
    private boolean bHS;
    private CompoundButton.OnCheckedChangeListener bHT;
    private RectF bHa;
    private float bHb;
    private long bHc;
    private boolean bHd;
    private int bHe;
    private int bHf;
    private int bHg;
    private int bHh;
    private int bHi;
    private int bHj;
    private int bHk;
    private int bHl;
    private Drawable bHm;
    private Drawable bHn;
    private RectF bHo;
    private RectF bHp;
    private RectF bHq;
    private RectF bHr;
    private RectF bHs;
    private Paint bHt;
    private boolean bHu;
    private boolean bHv;
    private boolean bHw;
    private ObjectAnimator bHx;
    private float bHy;
    private RectF bHz;
    private int ib;
    private int pb;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public static class a extends View.BaseSavedState {
        public static final Parcelable.Creator<a> CREATOR = new C0274a();
        CharSequence bHU;
        CharSequence bHV;

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
            TextUtils.writeToParcel(this.bHU, parcel, i);
            TextUtils.writeToParcel(this.bHV, parcel, i);
        }

        a(Parcelable parcelable) {
            super(parcelable);
        }

        private a(Parcel parcel) {
            super(parcel);
            this.bHU = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
            this.bHV = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
        }
    }

    public SwitchButton(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.bHw = false;
        this.bHQ = false;
        this.bHR = false;
        this.bHS = false;
        c(attributeSet);
    }

    private void Uv() {
        ViewParent parent = getParent();
        if (parent != null) {
            parent.requestDisallowInterceptTouchEvent(true);
        }
        this.bHS = true;
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
        this.bHD = ViewConfiguration.get(getContext()).getScaledTouchSlop();
        this.bHE = ViewConfiguration.getPressedStateDuration() + ViewConfiguration.getTapTimeout();
        this.bHt = new Paint(1);
        this.bHF = new Paint(1);
        this.bHF.setStyle(Paint.Style.STROKE);
        this.bHF.setStrokeWidth(getResources().getDisplayMetrics().density);
        this.bHI = getPaint();
        this.bHo = new RectF();
        this.bHp = new RectF();
        this.bHq = new RectF();
        this.bHa = new RectF();
        this.bHr = new RectF();
        this.bHs = new RectF();
        this.bHx = ObjectAnimator.ofFloat(this, "progress", 0.0f, 0.0f).setDuration(250L);
        this.bHx.setInterpolator(new AccelerateDecelerateInterpolator());
        this.bHz = new RectF();
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
        this.bHG = str2;
        this.bHH = str;
        this.bHN = i4;
        this.bHO = i3;
        this.bHP = i5;
        this.bGW = drawable;
        this.bGZ = colorStateList;
        this.bHu = this.bGW != null;
        this.bHe = i2;
        if (this.bHe == 0) {
            new TypedValue();
            this.bHe = 3309506;
        }
        if (!this.bHu && this.bGZ == null) {
            this.bGZ = com.baidu.poly.widget.b.fV(this.bHe);
            this.bHi = this.bGZ.getDefaultColor();
        }
        this.bHf = p(f5);
        this.ib = p(f6);
        this.bGX = drawable2;
        this.bGY = colorStateList2;
        this.bHv = this.bGX != null;
        if (!this.bHv && this.bGY == null) {
            this.bGY = com.baidu.poly.widget.b.fW(this.bHe);
            this.bHj = this.bGY.getDefaultColor();
            this.bHk = this.bGY.getColorForState(bGU, this.bHj);
        }
        this.bHa.set(f, f3, f2, f4);
        this.bHb = this.bHa.width() >= 0.0f ? Math.max(f9, 1.0f) : f9;
        this.ab = f7;
        this.anj = f8;
        this.bHc = i;
        this.bHd = z;
        this.bHx.setDuration(this.bHc);
        if (isChecked()) {
            setProgress(1.0f);
        }
    }

    private int fS(int i) {
        int i2;
        int size = View.MeasureSpec.getSize(i);
        int mode = View.MeasureSpec.getMode(i);
        if (this.bHf == 0 && this.bHu) {
            this.bHf = this.bGW.getIntrinsicWidth();
        }
        int p = p(this.bHL);
        if (this.bHb == 0.0f) {
            this.bHb = 1.8f;
        }
        if (mode == 1073741824) {
            int paddingLeft = (size - getPaddingLeft()) - getPaddingRight();
            if (this.bHf != 0) {
                int p2 = p(i2 * this.bHb);
                RectF rectF = this.bHa;
                int p3 = (this.bHO + p) - ((p2 - this.bHf) + p(Math.max(rectF.left, rectF.right)));
                float f = p2;
                RectF rectF2 = this.bHa;
                this.bHg = p(rectF2.right + rectF2.left + f + Math.max(p3, 0));
                if (this.bHg < 0) {
                    this.bHf = 0;
                }
                if (f + Math.max(this.bHa.left, 0.0f) + Math.max(this.bHa.right, 0.0f) + Math.max(p3, 0) > paddingLeft) {
                    this.bHf = 0;
                }
            }
            if (this.bHf == 0) {
                int p4 = p((((size - getPaddingLeft()) - getPaddingRight()) - Math.max(this.bHa.left, 0.0f)) - Math.max(this.bHa.right, 0.0f));
                if (p4 < 0) {
                    this.bHf = 0;
                    this.bHg = 0;
                    return size;
                }
                float f2 = p4;
                this.bHf = p(f2 / this.bHb);
                RectF rectF3 = this.bHa;
                this.bHg = p(f2 + rectF3.left + rectF3.right);
                if (this.bHg < 0) {
                    this.bHf = 0;
                    this.bHg = 0;
                    return size;
                }
                int i3 = p + this.bHO;
                int i4 = p4 - this.bHf;
                RectF rectF4 = this.bHa;
                int p5 = i3 - (i4 + p(Math.max(rectF4.left, rectF4.right)));
                if (p5 > 0) {
                    this.bHf -= p5;
                }
                if (this.bHf < 0) {
                    this.bHf = 0;
                    this.bHg = 0;
                    return size;
                }
                return size;
            }
            return size;
        }
        if (this.bHf == 0) {
            this.bHf = p(getResources().getDisplayMetrics().density * 20.0f);
        }
        if (this.bHb == 0.0f) {
            this.bHb = 1.8f;
        }
        int p6 = p(this.bHf * this.bHb);
        RectF rectF5 = this.bHa;
        int p7 = p((p + this.bHO) - (((p6 - this.bHf) + Math.max(rectF5.left, rectF5.right)) + this.bHN));
        float f3 = p6;
        RectF rectF6 = this.bHa;
        this.bHg = p(rectF6.right + rectF6.left + f3 + Math.max(0, p7));
        if (this.bHg < 0) {
            this.bHf = 0;
            this.bHg = 0;
            return size;
        }
        int p8 = p(Math.max(0.0f, this.bHa.left) + f3 + Math.max(0.0f, this.bHa.right) + Math.max(0, p7));
        return Math.max(p8, getPaddingLeft() + p8 + getPaddingRight());
    }

    private int fT(int i) {
        int i2;
        int i3;
        int i4;
        int size = View.MeasureSpec.getSize(i);
        int mode = View.MeasureSpec.getMode(i);
        if (this.ib == 0 && this.bHu) {
            this.ib = this.bGW.getIntrinsicHeight();
        }
        if (mode == 1073741824) {
            if (this.ib != 0) {
                RectF rectF = this.bHa;
                this.bHh = p(i3 + rectF.top + rectF.bottom);
                this.bHh = p(Math.max(this.bHh, this.bHM));
                if ((((this.bHh + getPaddingTop()) + getPaddingBottom()) - Math.min(0.0f, this.bHa.top)) - Math.min(0.0f, this.bHa.bottom) > size) {
                    this.ib = 0;
                }
            }
            if (this.ib == 0) {
                this.bHh = p(((size - getPaddingTop()) - getPaddingBottom()) + Math.min(0.0f, this.bHa.top) + Math.min(0.0f, this.bHa.bottom));
                if (this.bHh < 0) {
                    this.bHh = 0;
                    this.ib = 0;
                    return size;
                }
                RectF rectF2 = this.bHa;
                this.ib = p((i4 - rectF2.top) - rectF2.bottom);
            }
            if (this.ib < 0) {
                this.bHh = 0;
                this.ib = 0;
                return size;
            }
            return size;
        }
        if (this.ib == 0) {
            this.ib = p(getResources().getDisplayMetrics().density * 20.0f);
        }
        RectF rectF3 = this.bHa;
        this.bHh = p(this.ib + rectF3.top + rectF3.bottom);
        if (this.bHh < 0) {
            this.bHh = 0;
            this.ib = 0;
            return size;
        }
        int p = p(this.bHM - i2);
        if (p > 0) {
            this.bHh += p;
            this.ib = p + this.ib;
        }
        int max = Math.max(this.ib, this.bHh);
        return Math.max(Math.max(max, getPaddingTop() + max + getPaddingBottom()), getSuggestedMinimumHeight());
    }

    private float getProgress() {
        return this.bHy;
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
        this.bHy = f;
        invalidate();
    }

    private void setup() {
        int i;
        float paddingTop;
        float paddingLeft;
        int i2 = this.bHf;
        if (i2 != 0 && (i = this.ib) != 0 && this.bHg != 0 && this.bHh != 0) {
            if (this.ab == -1.0f) {
                this.ab = Math.min(i2, i) / 2;
            }
            if (this.anj == -1.0f) {
                this.anj = Math.min(this.bHg, this.bHh) / 2;
            }
            int measuredWidth = (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight();
            int measuredHeight = (getMeasuredHeight() - getPaddingTop()) - getPaddingBottom();
            int p = p((this.bHg - Math.min(0.0f, this.bHa.left)) - Math.min(0.0f, this.bHa.right));
            int p2 = p((this.bHh - Math.min(0.0f, this.bHa.top)) - Math.min(0.0f, this.bHa.bottom));
            if (measuredHeight <= p2) {
                paddingTop = getPaddingTop() + Math.max(0.0f, this.bHa.top);
            } else {
                paddingTop = (((measuredHeight - p2) + 1) / 2) + getPaddingTop() + Math.max(0.0f, this.bHa.top);
            }
            if (measuredWidth <= this.bHg) {
                paddingLeft = getPaddingLeft() + Math.max(0.0f, this.bHa.left);
            } else {
                paddingLeft = (((measuredWidth - p) + 1) / 2) + getPaddingLeft() + Math.max(0.0f, this.bHa.left);
            }
            this.bHo.set(paddingLeft, paddingTop, this.bHf + paddingLeft, this.ib + paddingTop);
            RectF rectF = this.bHo;
            float f = rectF.left;
            RectF rectF2 = this.bHa;
            float f2 = f - rectF2.left;
            RectF rectF3 = this.bHp;
            float f3 = rectF.top;
            float f4 = rectF2.top;
            rectF3.set(f2, f3 - f4, this.bHg + f2, (f3 - f4) + this.bHh);
            RectF rectF4 = this.bHq;
            RectF rectF5 = this.bHo;
            rectF4.set(rectF5.left, 0.0f, (this.bHp.right - this.bHa.right) - rectF5.width(), 0.0f);
            this.anj = Math.min(Math.min(this.bHp.width(), this.bHp.height()) / 2.0f, this.anj);
            Drawable drawable = this.bGX;
            if (drawable != null) {
                RectF rectF6 = this.bHp;
                drawable.setBounds((int) rectF6.left, (int) rectF6.top, p(rectF6.right), p(this.bHp.bottom));
            }
            if (this.bHJ != null) {
                RectF rectF7 = this.bHp;
                float width = ((((((rectF7.width() + this.bHN) - this.bHf) - this.bHa.right) - this.bHJ.getWidth()) / 2.0f) + rectF7.left) - this.bHP;
                RectF rectF8 = this.bHp;
                float height = ((rectF8.height() - this.bHJ.getHeight()) / 2.0f) + rectF8.top;
                this.bHr.set(width, height, this.bHJ.getWidth() + width, this.bHJ.getHeight() + height);
            }
            if (this.bHK != null) {
                RectF rectF9 = this.bHp;
                float width2 = ((rectF9.right - (((((rectF9.width() + this.bHN) - this.bHf) - this.bHa.left) - this.bHK.getWidth()) / 2.0f)) - this.bHK.getWidth()) + this.bHP;
                RectF rectF10 = this.bHp;
                float height2 = ((rectF10.height() - this.bHK.getHeight()) / 2.0f) + rectF10.top;
                this.bHs.set(width2, height2, this.bHK.getWidth() + width2, this.bHK.getHeight() + height2);
            }
            this.bHR = true;
        }
    }

    protected void b(boolean z) {
        ObjectAnimator objectAnimator = this.bHx;
        if (objectAnimator != null) {
            if (objectAnimator.isRunning()) {
                this.bHx.cancel();
            }
            this.bHx.setDuration(this.bHc);
            if (z) {
                this.bHx.setFloatValues(this.bHy, 1.0f);
            } else {
                this.bHx.setFloatValues(this.bHy, 0.0f);
            }
            this.bHx.start();
        }
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    protected void drawableStateChanged() {
        ColorStateList colorStateList;
        ColorStateList colorStateList2;
        super.drawableStateChanged();
        if (!this.bHu && (colorStateList2 = this.bGZ) != null) {
            this.bHi = colorStateList2.getColorForState(getDrawableState(), this.bHi);
        } else {
            setDrawableState(this.bGW);
        }
        int[] iArr = isChecked() ? bGV : bGU;
        ColorStateList textColors = getTextColors();
        if (textColors != null) {
            int defaultColor = textColors.getDefaultColor();
            this.bHl = textColors.getColorForState(bGU, defaultColor);
            this.pb = textColors.getColorForState(bGV, defaultColor);
        }
        if (!this.bHv && (colorStateList = this.bGY) != null) {
            this.bHj = colorStateList.getColorForState(getDrawableState(), this.bHj);
            this.bHk = this.bGY.getColorForState(iArr, this.bHj);
            return;
        }
        Drawable drawable = this.bGX;
        if ((drawable instanceof StateListDrawable) && this.bHd) {
            drawable.setState(iArr);
            this.bHn = this.bGX.getCurrent().mutate();
        } else {
            this.bHn = null;
        }
        setDrawableState(this.bGX);
        Drawable drawable2 = this.bGX;
        if (drawable2 != null) {
            this.bHm = drawable2.getCurrent().mutate();
        }
    }

    public long getAnimationDuration() {
        return this.bHc;
    }

    public ColorStateList getBackColor() {
        return this.bGY;
    }

    public Drawable getBackDrawable() {
        return this.bGX;
    }

    public float getBackRadius() {
        return this.anj;
    }

    public PointF getBackSizeF() {
        return new PointF(this.bHp.width(), this.bHp.height());
    }

    public CharSequence getTextOff() {
        return this.bHH;
    }

    public CharSequence getTextOn() {
        return this.bHG;
    }

    public ColorStateList getThumbColor() {
        return this.bGZ;
    }

    public Drawable getThumbDrawable() {
        return this.bGW;
    }

    public float getThumbHeight() {
        return this.ib;
    }

    public RectF getThumbMargin() {
        return this.bHa;
    }

    public float getThumbRadius() {
        return this.ab;
    }

    public float getThumbRangeRatio() {
        return this.bHb;
    }

    public float getThumbWidth() {
        return this.bHf;
    }

    public int getTintColor() {
        return this.bHe;
    }

    public void o() {
        if (this.bHT == null) {
            toggle();
            return;
        }
        super.setOnCheckedChangeListener(null);
        toggle();
        super.setOnCheckedChangeListener(this.bHT);
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (!this.bHR) {
            setup();
        }
        if (this.bHR) {
            if (this.bHv) {
                if (this.bHd && this.bHm != null && this.bHn != null) {
                    Drawable drawable = isChecked() ? this.bHm : this.bHn;
                    Drawable drawable2 = isChecked() ? this.bHn : this.bHm;
                    int progress = (int) (getProgress() * 255.0f);
                    drawable.setAlpha(progress);
                    drawable.draw(canvas);
                    drawable2.setAlpha(255 - progress);
                    drawable2.draw(canvas);
                } else {
                    this.bGX.setAlpha(255);
                    this.bGX.draw(canvas);
                }
            } else if (this.bHd) {
                int i = isChecked() ? this.bHj : this.bHk;
                int i2 = isChecked() ? this.bHk : this.bHj;
                int progress2 = (int) (getProgress() * 255.0f);
                this.bHt.setARGB((Color.alpha(i) * progress2) / 255, Color.red(i), Color.green(i), Color.blue(i));
                RectF rectF = this.bHp;
                float f = this.anj;
                canvas.drawRoundRect(rectF, f, f, this.bHt);
                this.bHt.setARGB(((255 - progress2) * Color.alpha(i2)) / 255, Color.red(i2), Color.green(i2), Color.blue(i2));
                RectF rectF2 = this.bHp;
                float f2 = this.anj;
                canvas.drawRoundRect(rectF2, f2, f2, this.bHt);
                this.bHt.setAlpha(255);
            } else {
                this.bHt.setColor(this.bHj);
                RectF rectF3 = this.bHp;
                float f3 = this.anj;
                canvas.drawRoundRect(rectF3, f3, f3, this.bHt);
            }
            Layout layout = ((double) getProgress()) > 0.5d ? this.bHJ : this.bHK;
            RectF rectF4 = ((double) getProgress()) > 0.5d ? this.bHr : this.bHs;
            if (layout != null && rectF4 != null) {
                int progress3 = (int) ((((double) getProgress()) >= 0.75d ? (getProgress() * 4.0f) - 3.0f : ((double) getProgress()) < 0.25d ? 1.0f - (getProgress() * 4.0f) : 0.0f) * 255.0f);
                int i3 = ((double) getProgress()) > 0.5d ? this.bHl : this.pb;
                layout.getPaint().setARGB((progress3 * Color.alpha(i3)) / 255, Color.red(i3), Color.green(i3), Color.blue(i3));
                canvas.save();
                canvas.translate(rectF4.left, rectF4.top);
                layout.draw(canvas);
                canvas.restore();
            }
            this.bHz.set(this.bHo);
            this.bHz.offset(this.bHy * this.bHq.width(), 0.0f);
            if (this.bHu) {
                Drawable drawable3 = this.bGW;
                RectF rectF5 = this.bHz;
                drawable3.setBounds((int) rectF5.left, (int) rectF5.top, p(rectF5.right), p(this.bHz.bottom));
                this.bGW.draw(canvas);
            } else {
                this.bHt.setColor(this.bHi);
                RectF rectF6 = this.bHz;
                float f4 = this.ab;
                canvas.drawRoundRect(rectF6, f4, f4, this.bHt);
            }
            if (this.bHw) {
                this.bHF.setColor(Color.parseColor("#AA0000"));
                canvas.drawRect(this.bHp, this.bHF);
                this.bHF.setColor(Color.parseColor("#0000FF"));
                canvas.drawRect(this.bHz, this.bHF);
                this.bHF.setColor(Color.parseColor("#000000"));
                RectF rectF7 = this.bHq;
                float f5 = rectF7.left;
                float f6 = this.bHo.top;
                canvas.drawLine(f5, f6, rectF7.right, f6, this.bHF);
                this.bHF.setColor(Color.parseColor("#00CC00"));
                canvas.drawRect(((double) getProgress()) > 0.5d ? this.bHr : this.bHs, this.bHF);
            }
        }
    }

    @Override // android.widget.TextView, android.view.View
    protected void onMeasure(int i, int i2) {
        if (this.bHJ == null && !TextUtils.isEmpty(this.bHG)) {
            this.bHJ = d(this.bHG);
        }
        if (this.bHK == null && !TextUtils.isEmpty(this.bHH)) {
            this.bHK = d(this.bHH);
        }
        Layout layout = this.bHJ;
        float width = layout != null ? layout.getWidth() : 0.0f;
        Layout layout2 = this.bHK;
        float width2 = layout2 != null ? layout2.getWidth() : 0.0f;
        if (width == 0.0f && width2 == 0.0f) {
            this.bHL = 0.0f;
        } else {
            this.bHL = Math.max(width, width2);
        }
        Layout layout3 = this.bHJ;
        float height = layout3 != null ? layout3.getHeight() : 0.0f;
        Layout layout4 = this.bHK;
        float height2 = layout4 != null ? layout4.getHeight() : 0.0f;
        if (height == 0.0f && height2 == 0.0f) {
            this.bHM = 0.0f;
        } else {
            this.bHM = Math.max(height, height2);
        }
        setMeasuredDimension(fS(i), fT(i2));
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        a aVar = (a) parcelable;
        a(aVar.bHU, aVar.bHV);
        this.bHQ = true;
        super.onRestoreInstanceState(aVar.getSuperState());
        this.bHQ = false;
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    public Parcelable onSaveInstanceState() {
        a aVar = new a(super.onSaveInstanceState());
        aVar.bHU = this.bHG;
        aVar.bHV = this.bHH;
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
        if (isEnabled() && isClickable() && isFocusable() && this.bHR) {
            int action = motionEvent.getAction();
            float x = motionEvent.getX() - this.bHA;
            float y = motionEvent.getY() - this.bHB;
            switch (action) {
                case 0:
                    this.bHA = motionEvent.getX();
                    this.bHB = motionEvent.getY();
                    this.bHC = this.bHA;
                    setPressed(true);
                    break;
                case 1:
                case 3:
                    this.bHS = false;
                    setPressed(false);
                    float eventTime = (float) (motionEvent.getEventTime() - motionEvent.getDownTime());
                    if (Math.abs(x) < this.bHD && Math.abs(y) < this.bHD && eventTime < this.bHE) {
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
                    setProgress(getProgress() + ((x2 - this.bHC) / this.bHq.width()));
                    if (!this.bHS && (Math.abs(x) > this.bHD / 2 || Math.abs(y) > this.bHD / 2)) {
                        if (y != 0.0f && Math.abs(x) <= Math.abs(y)) {
                            if (Math.abs(y) > Math.abs(x)) {
                                return false;
                            }
                        } else {
                            Uv();
                        }
                    }
                    this.bHC = x2;
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
        this.bHc = j;
    }

    public void setBackColor(ColorStateList colorStateList) {
        this.bGY = colorStateList;
        if (this.bGY != null) {
            setBackDrawable(null);
        }
        invalidate();
    }

    public void setBackColorRes(int i) {
        setBackColor(getResources().getColorStateList(i));
    }

    public void setBackDrawable(Drawable drawable) {
        this.bGX = drawable;
        this.bHv = this.bGX != null;
        refreshDrawableState();
        this.bHR = false;
        requestLayout();
        invalidate();
    }

    public void setBackDrawableRes(int i) {
        setBackDrawable(getResources().getDrawable(i));
    }

    public void setBackRadius(float f) {
        this.anj = f;
        if (this.bHv) {
            return;
        }
        invalidate();
    }

    @Override // android.widget.CompoundButton, android.widget.Checkable
    public void setChecked(boolean z) {
        if (isChecked() != z) {
            b(z);
        }
        if (this.bHQ) {
            setCheckedImmediatelyNoEvent(z);
        } else {
            super.setChecked(z);
        }
    }

    public void setCheckedImmediately(boolean z) {
        super.setChecked(z);
        ObjectAnimator objectAnimator = this.bHx;
        if (objectAnimator != null && objectAnimator.isRunning()) {
            this.bHx.cancel();
        }
        setProgress(z ? 1.0f : 0.0f);
        invalidate();
    }

    public void setCheckedImmediatelyNoEvent(boolean z) {
        if (this.bHT == null) {
            setCheckedImmediately(z);
            return;
        }
        super.setOnCheckedChangeListener(null);
        setCheckedImmediately(z);
        super.setOnCheckedChangeListener(this.bHT);
    }

    public void setCheckedNoEvent(boolean z) {
        if (this.bHT == null) {
            setChecked(z);
            return;
        }
        super.setOnCheckedChangeListener(null);
        setChecked(z);
        super.setOnCheckedChangeListener(this.bHT);
    }

    public void setDrawDebugRect(boolean z) {
        this.bHw = z;
        invalidate();
    }

    public void setFadeBack(boolean z) {
        this.bHd = z;
    }

    @Override // android.widget.CompoundButton
    public void setOnCheckedChangeListener(CompoundButton.OnCheckedChangeListener onCheckedChangeListener) {
        super.setOnCheckedChangeListener(onCheckedChangeListener);
        this.bHT = onCheckedChangeListener;
    }

    public void setTextAdjust(int i) {
        this.bHP = i;
        this.bHR = false;
        requestLayout();
        invalidate();
    }

    public void setTextExtra(int i) {
        this.bHO = i;
        this.bHR = false;
        requestLayout();
        invalidate();
    }

    public void setTextThumbInset(int i) {
        this.bHN = i;
        this.bHR = false;
        requestLayout();
        invalidate();
    }

    public void setThumbColor(ColorStateList colorStateList) {
        this.bGZ = colorStateList;
        if (this.bGZ != null) {
            setThumbDrawable(null);
        }
        invalidate();
    }

    public void setThumbColorRes(int i) {
        setThumbColor(getResources().getColorStateList(i));
    }

    public void setThumbDrawable(Drawable drawable) {
        this.bGW = drawable;
        this.bHu = this.bGW != null;
        refreshDrawableState();
        this.bHR = false;
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
        if (this.bHu) {
            return;
        }
        invalidate();
    }

    public void setThumbRangeRatio(float f) {
        this.bHb = f;
        this.bHR = false;
        requestLayout();
    }

    public void setTintColor(int i) {
        this.bHe = i;
        this.bGZ = com.baidu.poly.widget.b.fV(this.bHe);
        this.bGY = com.baidu.poly.widget.b.fW(this.bHe);
        this.bHv = false;
        this.bHu = false;
        refreshDrawableState();
        invalidate();
    }

    public SwitchButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.bHw = false;
        this.bHQ = false;
        this.bHR = false;
        this.bHS = false;
        c(attributeSet);
    }

    public SwitchButton(Context context) {
        super(context);
        this.bHw = false;
        this.bHQ = false;
        this.bHR = false;
        this.bHS = false;
        c(null);
    }

    private Layout d(CharSequence charSequence) {
        TextPaint textPaint = this.bHI;
        return new StaticLayout(charSequence, textPaint, (int) Math.ceil(Layout.getDesiredWidth(charSequence, textPaint)), Layout.Alignment.ALIGN_CENTER, 1.0f, 0.0f, false);
    }

    public void a(float f, float f2, float f3, float f4) {
        this.bHa.set(f, f2, f3, f4);
        this.bHR = false;
        requestLayout();
    }

    public void a(CharSequence charSequence, CharSequence charSequence2) {
        this.bHG = charSequence;
        this.bHH = charSequence2;
        this.bHJ = null;
        this.bHK = null;
        this.bHR = false;
        requestLayout();
        invalidate();
    }
}
