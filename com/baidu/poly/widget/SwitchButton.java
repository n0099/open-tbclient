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
    private static int[] bYf = {16842912, 16842910, 16842919};
    private static int[] bYg = {-16842912, 16842910, 16842919};
    private float ab;
    private float aox;
    private RectF bYA;
    private RectF bYB;
    private RectF bYC;
    private RectF bYD;
    private Paint bYE;
    private boolean bYF;
    private boolean bYG;
    private boolean bYH;
    private ObjectAnimator bYI;
    private float bYJ;
    private RectF bYK;
    private float bYL;
    private float bYM;
    private float bYN;
    private int bYO;
    private int bYP;
    private Paint bYQ;
    private CharSequence bYR;
    private CharSequence bYS;
    private TextPaint bYT;
    private Layout bYU;
    private Layout bYV;
    private float bYW;
    private float bYX;
    private int bYY;
    private int bYZ;
    private Drawable bYh;
    private Drawable bYi;
    private ColorStateList bYj;
    private ColorStateList bYk;
    private RectF bYl;
    private float bYm;
    private long bYn;
    private boolean bYo;
    private int bYp;
    private int bYq;
    private int bYr;
    private int bYs;
    private int bYt;
    private int bYu;
    private int bYv;
    private int bYw;
    private Drawable bYx;
    private Drawable bYy;
    private RectF bYz;
    private int bZa;
    private boolean bZb;
    private boolean bZc;
    private boolean bZd;
    private CompoundButton.OnCheckedChangeListener bZe;
    private int ib;
    private int pb;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public static class a extends View.BaseSavedState {
        public static final Parcelable.Creator<a> CREATOR = new C0301a();
        CharSequence bZf;
        CharSequence bZg;

        /* renamed from: com.baidu.poly.widget.SwitchButton$a$a  reason: collision with other inner class name */
        /* loaded from: classes6.dex */
        static class C0301a implements Parcelable.Creator<a> {
            C0301a() {
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // android.os.Parcelable.Creator
            /* renamed from: gM */
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
            TextUtils.writeToParcel(this.bZf, parcel, i);
            TextUtils.writeToParcel(this.bZg, parcel, i);
        }

        a(Parcelable parcelable) {
            super(parcelable);
        }

        private a(Parcel parcel) {
            super(parcel);
            this.bZf = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
            this.bZg = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
        }
    }

    public SwitchButton(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.bYH = false;
        this.bZb = false;
        this.bZc = false;
        this.bZd = false;
        c(attributeSet);
    }

    private void YV() {
        ViewParent parent = getParent();
        if (parent != null) {
            parent.requestDisallowInterceptTouchEvent(true);
        }
        this.bZd = true;
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
        this.bYO = ViewConfiguration.get(getContext()).getScaledTouchSlop();
        this.bYP = ViewConfiguration.getPressedStateDuration() + ViewConfiguration.getTapTimeout();
        this.bYE = new Paint(1);
        this.bYQ = new Paint(1);
        this.bYQ.setStyle(Paint.Style.STROKE);
        this.bYQ.setStrokeWidth(getResources().getDisplayMetrics().density);
        this.bYT = getPaint();
        this.bYz = new RectF();
        this.bYA = new RectF();
        this.bYB = new RectF();
        this.bYl = new RectF();
        this.bYC = new RectF();
        this.bYD = new RectF();
        this.bYI = ObjectAnimator.ofFloat(this, "progress", 0.0f, 0.0f).setDuration(250L);
        this.bYI.setInterpolator(new AccelerateDecelerateInterpolator());
        this.bYK = new RectF();
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
        this.bYR = str2;
        this.bYS = str;
        this.bYY = i4;
        this.bYZ = i3;
        this.bZa = i5;
        this.bYh = drawable;
        this.bYk = colorStateList;
        this.bYF = this.bYh != null;
        this.bYp = i2;
        if (this.bYp == 0) {
            new TypedValue();
            this.bYp = 3309506;
        }
        if (!this.bYF && this.bYk == null) {
            this.bYk = com.baidu.poly.widget.b.gJ(this.bYp);
            this.bYt = this.bYk.getDefaultColor();
        }
        this.bYq = q(f5);
        this.ib = q(f6);
        this.bYi = drawable2;
        this.bYj = colorStateList2;
        this.bYG = this.bYi != null;
        if (!this.bYG && this.bYj == null) {
            this.bYj = com.baidu.poly.widget.b.gK(this.bYp);
            this.bYu = this.bYj.getDefaultColor();
            this.bYv = this.bYj.getColorForState(bYf, this.bYu);
        }
        this.bYl.set(f, f3, f2, f4);
        this.bYm = this.bYl.width() >= 0.0f ? Math.max(f9, 1.0f) : f9;
        this.ab = f7;
        this.aox = f8;
        this.bYn = i;
        this.bYo = z;
        this.bYI.setDuration(this.bYn);
        if (isChecked()) {
            setProgress(1.0f);
        }
    }

    private int gG(int i) {
        int i2;
        int size = View.MeasureSpec.getSize(i);
        int mode = View.MeasureSpec.getMode(i);
        if (this.bYq == 0 && this.bYF) {
            this.bYq = this.bYh.getIntrinsicWidth();
        }
        int q = q(this.bYW);
        if (this.bYm == 0.0f) {
            this.bYm = 1.8f;
        }
        if (mode == 1073741824) {
            int paddingLeft = (size - getPaddingLeft()) - getPaddingRight();
            if (this.bYq != 0) {
                int q2 = q(i2 * this.bYm);
                RectF rectF = this.bYl;
                int q3 = (this.bYZ + q) - ((q2 - this.bYq) + q(Math.max(rectF.left, rectF.right)));
                float f = q2;
                RectF rectF2 = this.bYl;
                this.bYr = q(rectF2.right + rectF2.left + f + Math.max(q3, 0));
                if (this.bYr < 0) {
                    this.bYq = 0;
                }
                if (f + Math.max(this.bYl.left, 0.0f) + Math.max(this.bYl.right, 0.0f) + Math.max(q3, 0) > paddingLeft) {
                    this.bYq = 0;
                }
            }
            if (this.bYq == 0) {
                int q4 = q((((size - getPaddingLeft()) - getPaddingRight()) - Math.max(this.bYl.left, 0.0f)) - Math.max(this.bYl.right, 0.0f));
                if (q4 < 0) {
                    this.bYq = 0;
                    this.bYr = 0;
                    return size;
                }
                float f2 = q4;
                this.bYq = q(f2 / this.bYm);
                RectF rectF3 = this.bYl;
                this.bYr = q(f2 + rectF3.left + rectF3.right);
                if (this.bYr < 0) {
                    this.bYq = 0;
                    this.bYr = 0;
                    return size;
                }
                int i3 = q + this.bYZ;
                int i4 = q4 - this.bYq;
                RectF rectF4 = this.bYl;
                int q5 = i3 - (i4 + q(Math.max(rectF4.left, rectF4.right)));
                if (q5 > 0) {
                    this.bYq -= q5;
                }
                if (this.bYq < 0) {
                    this.bYq = 0;
                    this.bYr = 0;
                    return size;
                }
                return size;
            }
            return size;
        }
        if (this.bYq == 0) {
            this.bYq = q(getResources().getDisplayMetrics().density * 20.0f);
        }
        if (this.bYm == 0.0f) {
            this.bYm = 1.8f;
        }
        int q6 = q(this.bYq * this.bYm);
        RectF rectF5 = this.bYl;
        int q7 = q((q + this.bYZ) - (((q6 - this.bYq) + Math.max(rectF5.left, rectF5.right)) + this.bYY));
        float f3 = q6;
        RectF rectF6 = this.bYl;
        this.bYr = q(rectF6.right + rectF6.left + f3 + Math.max(0, q7));
        if (this.bYr < 0) {
            this.bYq = 0;
            this.bYr = 0;
            return size;
        }
        int q8 = q(Math.max(0.0f, this.bYl.left) + f3 + Math.max(0.0f, this.bYl.right) + Math.max(0, q7));
        return Math.max(q8, getPaddingLeft() + q8 + getPaddingRight());
    }

    private int gH(int i) {
        int i2;
        int i3;
        int i4;
        int size = View.MeasureSpec.getSize(i);
        int mode = View.MeasureSpec.getMode(i);
        if (this.ib == 0 && this.bYF) {
            this.ib = this.bYh.getIntrinsicHeight();
        }
        if (mode == 1073741824) {
            if (this.ib != 0) {
                RectF rectF = this.bYl;
                this.bYs = q(i3 + rectF.top + rectF.bottom);
                this.bYs = q(Math.max(this.bYs, this.bYX));
                if ((((this.bYs + getPaddingTop()) + getPaddingBottom()) - Math.min(0.0f, this.bYl.top)) - Math.min(0.0f, this.bYl.bottom) > size) {
                    this.ib = 0;
                }
            }
            if (this.ib == 0) {
                this.bYs = q(((size - getPaddingTop()) - getPaddingBottom()) + Math.min(0.0f, this.bYl.top) + Math.min(0.0f, this.bYl.bottom));
                if (this.bYs < 0) {
                    this.bYs = 0;
                    this.ib = 0;
                    return size;
                }
                RectF rectF2 = this.bYl;
                this.ib = q((i4 - rectF2.top) - rectF2.bottom);
            }
            if (this.ib < 0) {
                this.bYs = 0;
                this.ib = 0;
                return size;
            }
            return size;
        }
        if (this.ib == 0) {
            this.ib = q(getResources().getDisplayMetrics().density * 20.0f);
        }
        RectF rectF3 = this.bYl;
        this.bYs = q(this.ib + rectF3.top + rectF3.bottom);
        if (this.bYs < 0) {
            this.bYs = 0;
            this.ib = 0;
            return size;
        }
        int q = q(this.bYX - i2);
        if (q > 0) {
            this.bYs += q;
            this.ib = q + this.ib;
        }
        int max = Math.max(this.ib, this.bYs);
        return Math.max(Math.max(max, getPaddingTop() + max + getPaddingBottom()), getSuggestedMinimumHeight());
    }

    private float getProgress() {
        return this.bYJ;
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
        this.bYJ = f;
        invalidate();
    }

    private void setup() {
        int i;
        float paddingTop;
        float paddingLeft;
        int i2 = this.bYq;
        if (i2 != 0 && (i = this.ib) != 0 && this.bYr != 0 && this.bYs != 0) {
            if (this.ab == -1.0f) {
                this.ab = Math.min(i2, i) / 2;
            }
            if (this.aox == -1.0f) {
                this.aox = Math.min(this.bYr, this.bYs) / 2;
            }
            int measuredWidth = (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight();
            int measuredHeight = (getMeasuredHeight() - getPaddingTop()) - getPaddingBottom();
            int q = q((this.bYr - Math.min(0.0f, this.bYl.left)) - Math.min(0.0f, this.bYl.right));
            int q2 = q((this.bYs - Math.min(0.0f, this.bYl.top)) - Math.min(0.0f, this.bYl.bottom));
            if (measuredHeight <= q2) {
                paddingTop = getPaddingTop() + Math.max(0.0f, this.bYl.top);
            } else {
                paddingTop = (((measuredHeight - q2) + 1) / 2) + getPaddingTop() + Math.max(0.0f, this.bYl.top);
            }
            if (measuredWidth <= this.bYr) {
                paddingLeft = getPaddingLeft() + Math.max(0.0f, this.bYl.left);
            } else {
                paddingLeft = (((measuredWidth - q) + 1) / 2) + getPaddingLeft() + Math.max(0.0f, this.bYl.left);
            }
            this.bYz.set(paddingLeft, paddingTop, this.bYq + paddingLeft, this.ib + paddingTop);
            RectF rectF = this.bYz;
            float f = rectF.left;
            RectF rectF2 = this.bYl;
            float f2 = f - rectF2.left;
            RectF rectF3 = this.bYA;
            float f3 = rectF.top;
            float f4 = rectF2.top;
            rectF3.set(f2, f3 - f4, this.bYr + f2, (f3 - f4) + this.bYs);
            RectF rectF4 = this.bYB;
            RectF rectF5 = this.bYz;
            rectF4.set(rectF5.left, 0.0f, (this.bYA.right - this.bYl.right) - rectF5.width(), 0.0f);
            this.aox = Math.min(Math.min(this.bYA.width(), this.bYA.height()) / 2.0f, this.aox);
            Drawable drawable = this.bYi;
            if (drawable != null) {
                RectF rectF6 = this.bYA;
                drawable.setBounds((int) rectF6.left, (int) rectF6.top, q(rectF6.right), q(this.bYA.bottom));
            }
            if (this.bYU != null) {
                RectF rectF7 = this.bYA;
                float width = ((((((rectF7.width() + this.bYY) - this.bYq) - this.bYl.right) - this.bYU.getWidth()) / 2.0f) + rectF7.left) - this.bZa;
                RectF rectF8 = this.bYA;
                float height = ((rectF8.height() - this.bYU.getHeight()) / 2.0f) + rectF8.top;
                this.bYC.set(width, height, this.bYU.getWidth() + width, this.bYU.getHeight() + height);
            }
            if (this.bYV != null) {
                RectF rectF9 = this.bYA;
                float width2 = ((rectF9.right - (((((rectF9.width() + this.bYY) - this.bYq) - this.bYl.left) - this.bYV.getWidth()) / 2.0f)) - this.bYV.getWidth()) + this.bZa;
                RectF rectF10 = this.bYA;
                float height2 = ((rectF10.height() - this.bYV.getHeight()) / 2.0f) + rectF10.top;
                this.bYD.set(width2, height2, this.bYV.getWidth() + width2, this.bYV.getHeight() + height2);
            }
            this.bZc = true;
        }
    }

    protected void b(boolean z) {
        ObjectAnimator objectAnimator = this.bYI;
        if (objectAnimator != null) {
            if (objectAnimator.isRunning()) {
                this.bYI.cancel();
            }
            this.bYI.setDuration(this.bYn);
            if (z) {
                this.bYI.setFloatValues(this.bYJ, 1.0f);
            } else {
                this.bYI.setFloatValues(this.bYJ, 0.0f);
            }
            this.bYI.start();
        }
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    protected void drawableStateChanged() {
        ColorStateList colorStateList;
        ColorStateList colorStateList2;
        super.drawableStateChanged();
        if (!this.bYF && (colorStateList2 = this.bYk) != null) {
            this.bYt = colorStateList2.getColorForState(getDrawableState(), this.bYt);
        } else {
            setDrawableState(this.bYh);
        }
        int[] iArr = isChecked() ? bYg : bYf;
        ColorStateList textColors = getTextColors();
        if (textColors != null) {
            int defaultColor = textColors.getDefaultColor();
            this.bYw = textColors.getColorForState(bYf, defaultColor);
            this.pb = textColors.getColorForState(bYg, defaultColor);
        }
        if (!this.bYG && (colorStateList = this.bYj) != null) {
            this.bYu = colorStateList.getColorForState(getDrawableState(), this.bYu);
            this.bYv = this.bYj.getColorForState(iArr, this.bYu);
            return;
        }
        Drawable drawable = this.bYi;
        if ((drawable instanceof StateListDrawable) && this.bYo) {
            drawable.setState(iArr);
            this.bYy = this.bYi.getCurrent().mutate();
        } else {
            this.bYy = null;
        }
        setDrawableState(this.bYi);
        Drawable drawable2 = this.bYi;
        if (drawable2 != null) {
            this.bYx = drawable2.getCurrent().mutate();
        }
    }

    public long getAnimationDuration() {
        return this.bYn;
    }

    public ColorStateList getBackColor() {
        return this.bYj;
    }

    public Drawable getBackDrawable() {
        return this.bYi;
    }

    public float getBackRadius() {
        return this.aox;
    }

    public PointF getBackSizeF() {
        return new PointF(this.bYA.width(), this.bYA.height());
    }

    public CharSequence getTextOff() {
        return this.bYS;
    }

    public CharSequence getTextOn() {
        return this.bYR;
    }

    public ColorStateList getThumbColor() {
        return this.bYk;
    }

    public Drawable getThumbDrawable() {
        return this.bYh;
    }

    public float getThumbHeight() {
        return this.ib;
    }

    public RectF getThumbMargin() {
        return this.bYl;
    }

    public float getThumbRadius() {
        return this.ab;
    }

    public float getThumbRangeRatio() {
        return this.bYm;
    }

    public float getThumbWidth() {
        return this.bYq;
    }

    public int getTintColor() {
        return this.bYp;
    }

    public void o() {
        if (this.bZe == null) {
            toggle();
            return;
        }
        super.setOnCheckedChangeListener(null);
        toggle();
        super.setOnCheckedChangeListener(this.bZe);
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (!this.bZc) {
            setup();
        }
        if (this.bZc) {
            if (this.bYG) {
                if (this.bYo && this.bYx != null && this.bYy != null) {
                    Drawable drawable = isChecked() ? this.bYx : this.bYy;
                    Drawable drawable2 = isChecked() ? this.bYy : this.bYx;
                    int progress = (int) (getProgress() * 255.0f);
                    drawable.setAlpha(progress);
                    drawable.draw(canvas);
                    drawable2.setAlpha(255 - progress);
                    drawable2.draw(canvas);
                } else {
                    this.bYi.setAlpha(255);
                    this.bYi.draw(canvas);
                }
            } else if (this.bYo) {
                int i = isChecked() ? this.bYu : this.bYv;
                int i2 = isChecked() ? this.bYv : this.bYu;
                int progress2 = (int) (getProgress() * 255.0f);
                this.bYE.setARGB((Color.alpha(i) * progress2) / 255, Color.red(i), Color.green(i), Color.blue(i));
                RectF rectF = this.bYA;
                float f = this.aox;
                canvas.drawRoundRect(rectF, f, f, this.bYE);
                this.bYE.setARGB(((255 - progress2) * Color.alpha(i2)) / 255, Color.red(i2), Color.green(i2), Color.blue(i2));
                RectF rectF2 = this.bYA;
                float f2 = this.aox;
                canvas.drawRoundRect(rectF2, f2, f2, this.bYE);
                this.bYE.setAlpha(255);
            } else {
                this.bYE.setColor(this.bYu);
                RectF rectF3 = this.bYA;
                float f3 = this.aox;
                canvas.drawRoundRect(rectF3, f3, f3, this.bYE);
            }
            Layout layout = ((double) getProgress()) > 0.5d ? this.bYU : this.bYV;
            RectF rectF4 = ((double) getProgress()) > 0.5d ? this.bYC : this.bYD;
            if (layout != null && rectF4 != null) {
                int progress3 = (int) ((((double) getProgress()) >= 0.75d ? (getProgress() * 4.0f) - 3.0f : ((double) getProgress()) < 0.25d ? 1.0f - (getProgress() * 4.0f) : 0.0f) * 255.0f);
                int i3 = ((double) getProgress()) > 0.5d ? this.bYw : this.pb;
                layout.getPaint().setARGB((progress3 * Color.alpha(i3)) / 255, Color.red(i3), Color.green(i3), Color.blue(i3));
                canvas.save();
                canvas.translate(rectF4.left, rectF4.top);
                layout.draw(canvas);
                canvas.restore();
            }
            this.bYK.set(this.bYz);
            this.bYK.offset(this.bYJ * this.bYB.width(), 0.0f);
            if (this.bYF) {
                Drawable drawable3 = this.bYh;
                RectF rectF5 = this.bYK;
                drawable3.setBounds((int) rectF5.left, (int) rectF5.top, q(rectF5.right), q(this.bYK.bottom));
                this.bYh.draw(canvas);
            } else {
                this.bYE.setColor(this.bYt);
                RectF rectF6 = this.bYK;
                float f4 = this.ab;
                canvas.drawRoundRect(rectF6, f4, f4, this.bYE);
            }
            if (this.bYH) {
                this.bYQ.setColor(Color.parseColor("#AA0000"));
                canvas.drawRect(this.bYA, this.bYQ);
                this.bYQ.setColor(Color.parseColor("#0000FF"));
                canvas.drawRect(this.bYK, this.bYQ);
                this.bYQ.setColor(Color.parseColor("#000000"));
                RectF rectF7 = this.bYB;
                float f5 = rectF7.left;
                float f6 = this.bYz.top;
                canvas.drawLine(f5, f6, rectF7.right, f6, this.bYQ);
                this.bYQ.setColor(Color.parseColor("#00CC00"));
                canvas.drawRect(((double) getProgress()) > 0.5d ? this.bYC : this.bYD, this.bYQ);
            }
        }
    }

    @Override // android.widget.TextView, android.view.View
    protected void onMeasure(int i, int i2) {
        if (this.bYU == null && !TextUtils.isEmpty(this.bYR)) {
            this.bYU = e(this.bYR);
        }
        if (this.bYV == null && !TextUtils.isEmpty(this.bYS)) {
            this.bYV = e(this.bYS);
        }
        Layout layout = this.bYU;
        float width = layout != null ? layout.getWidth() : 0.0f;
        Layout layout2 = this.bYV;
        float width2 = layout2 != null ? layout2.getWidth() : 0.0f;
        if (width == 0.0f && width2 == 0.0f) {
            this.bYW = 0.0f;
        } else {
            this.bYW = Math.max(width, width2);
        }
        Layout layout3 = this.bYU;
        float height = layout3 != null ? layout3.getHeight() : 0.0f;
        Layout layout4 = this.bYV;
        float height2 = layout4 != null ? layout4.getHeight() : 0.0f;
        if (height == 0.0f && height2 == 0.0f) {
            this.bYX = 0.0f;
        } else {
            this.bYX = Math.max(height, height2);
        }
        setMeasuredDimension(gG(i), gH(i2));
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        a aVar = (a) parcelable;
        a(aVar.bZf, aVar.bZg);
        this.bZb = true;
        super.onRestoreInstanceState(aVar.getSuperState());
        this.bZb = false;
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    public Parcelable onSaveInstanceState() {
        a aVar = new a(super.onSaveInstanceState());
        aVar.bZf = this.bYR;
        aVar.bZg = this.bYS;
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
        if (isEnabled() && isClickable() && isFocusable() && this.bZc) {
            int action = motionEvent.getAction();
            float x = motionEvent.getX() - this.bYL;
            float y = motionEvent.getY() - this.bYM;
            switch (action) {
                case 0:
                    this.bYL = motionEvent.getX();
                    this.bYM = motionEvent.getY();
                    this.bYN = this.bYL;
                    setPressed(true);
                    break;
                case 1:
                case 3:
                    this.bZd = false;
                    setPressed(false);
                    float eventTime = (float) (motionEvent.getEventTime() - motionEvent.getDownTime());
                    if (Math.abs(x) < this.bYO && Math.abs(y) < this.bYO && eventTime < this.bYP) {
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
                    setProgress(getProgress() + ((x2 - this.bYN) / this.bYB.width()));
                    if (!this.bZd && (Math.abs(x) > this.bYO / 2 || Math.abs(y) > this.bYO / 2)) {
                        if (y != 0.0f && Math.abs(x) <= Math.abs(y)) {
                            if (Math.abs(y) > Math.abs(x)) {
                                return false;
                            }
                        } else {
                            YV();
                        }
                    }
                    this.bYN = x2;
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
        this.bYn = j;
    }

    public void setBackColor(ColorStateList colorStateList) {
        this.bYj = colorStateList;
        if (this.bYj != null) {
            setBackDrawable(null);
        }
        invalidate();
    }

    public void setBackColorRes(int i) {
        setBackColor(getResources().getColorStateList(i));
    }

    public void setBackDrawable(Drawable drawable) {
        this.bYi = drawable;
        this.bYG = this.bYi != null;
        refreshDrawableState();
        this.bZc = false;
        requestLayout();
        invalidate();
    }

    public void setBackDrawableRes(int i) {
        setBackDrawable(getResources().getDrawable(i));
    }

    public void setBackRadius(float f) {
        this.aox = f;
        if (this.bYG) {
            return;
        }
        invalidate();
    }

    @Override // android.widget.CompoundButton, android.widget.Checkable
    public void setChecked(boolean z) {
        if (isChecked() != z) {
            b(z);
        }
        if (this.bZb) {
            setCheckedImmediatelyNoEvent(z);
        } else {
            super.setChecked(z);
        }
    }

    public void setCheckedImmediately(boolean z) {
        super.setChecked(z);
        ObjectAnimator objectAnimator = this.bYI;
        if (objectAnimator != null && objectAnimator.isRunning()) {
            this.bYI.cancel();
        }
        setProgress(z ? 1.0f : 0.0f);
        invalidate();
    }

    public void setCheckedImmediatelyNoEvent(boolean z) {
        if (this.bZe == null) {
            setCheckedImmediately(z);
            return;
        }
        super.setOnCheckedChangeListener(null);
        setCheckedImmediately(z);
        super.setOnCheckedChangeListener(this.bZe);
    }

    public void setCheckedNoEvent(boolean z) {
        if (this.bZe == null) {
            setChecked(z);
            return;
        }
        super.setOnCheckedChangeListener(null);
        setChecked(z);
        super.setOnCheckedChangeListener(this.bZe);
    }

    public void setDrawDebugRect(boolean z) {
        this.bYH = z;
        invalidate();
    }

    public void setFadeBack(boolean z) {
        this.bYo = z;
    }

    @Override // android.widget.CompoundButton
    public void setOnCheckedChangeListener(CompoundButton.OnCheckedChangeListener onCheckedChangeListener) {
        super.setOnCheckedChangeListener(onCheckedChangeListener);
        this.bZe = onCheckedChangeListener;
    }

    public void setTextAdjust(int i) {
        this.bZa = i;
        this.bZc = false;
        requestLayout();
        invalidate();
    }

    public void setTextExtra(int i) {
        this.bYZ = i;
        this.bZc = false;
        requestLayout();
        invalidate();
    }

    public void setTextThumbInset(int i) {
        this.bYY = i;
        this.bZc = false;
        requestLayout();
        invalidate();
    }

    public void setThumbColor(ColorStateList colorStateList) {
        this.bYk = colorStateList;
        if (this.bYk != null) {
            setThumbDrawable(null);
        }
        invalidate();
    }

    public void setThumbColorRes(int i) {
        setThumbColor(getResources().getColorStateList(i));
    }

    public void setThumbDrawable(Drawable drawable) {
        this.bYh = drawable;
        this.bYF = this.bYh != null;
        refreshDrawableState();
        this.bZc = false;
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
        if (this.bYF) {
            return;
        }
        invalidate();
    }

    public void setThumbRangeRatio(float f) {
        this.bYm = f;
        this.bZc = false;
        requestLayout();
    }

    public void setTintColor(int i) {
        this.bYp = i;
        this.bYk = com.baidu.poly.widget.b.gJ(this.bYp);
        this.bYj = com.baidu.poly.widget.b.gK(this.bYp);
        this.bYG = false;
        this.bYF = false;
        refreshDrawableState();
        invalidate();
    }

    public SwitchButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.bYH = false;
        this.bZb = false;
        this.bZc = false;
        this.bZd = false;
        c(attributeSet);
    }

    public SwitchButton(Context context) {
        super(context);
        this.bYH = false;
        this.bZb = false;
        this.bZc = false;
        this.bZd = false;
        c(null);
    }

    private Layout e(CharSequence charSequence) {
        TextPaint textPaint = this.bYT;
        return new StaticLayout(charSequence, textPaint, (int) Math.ceil(Layout.getDesiredWidth(charSequence, textPaint)), Layout.Alignment.ALIGN_CENTER, 1.0f, 0.0f, false);
    }

    public void a(float f, float f2, float f3, float f4) {
        this.bYl.set(f, f2, f3, f4);
        this.bZc = false;
        requestLayout();
    }

    public void a(CharSequence charSequence, CharSequence charSequence2) {
        this.bYR = charSequence;
        this.bYS = charSequence2;
        this.bYU = null;
        this.bYV = null;
        this.bZc = false;
        requestLayout();
        invalidate();
    }
}
