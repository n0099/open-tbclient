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
    private static int[] bPI = {16842912, 16842910, 16842919};
    private static int[] bPJ = {-16842912, 16842910, 16842919};
    private float ab;
    private float aow;
    private Drawable bPK;
    private Drawable bPL;
    private ColorStateList bPM;
    private ColorStateList bPN;
    private RectF bPO;
    private float bPP;
    private long bPQ;
    private boolean bPR;
    private int bPS;
    private int bPT;
    private int bPU;
    private int bPV;
    private int bPW;
    private int bPX;
    private int bPY;
    private int bPZ;
    private float bQA;
    private int bQB;
    private int bQC;
    private int bQD;
    private boolean bQE;
    private boolean bQF;
    private boolean bQG;
    private CompoundButton.OnCheckedChangeListener bQH;
    private Drawable bQa;
    private Drawable bQb;
    private RectF bQc;
    private RectF bQd;
    private RectF bQe;
    private RectF bQf;
    private RectF bQg;
    private Paint bQh;
    private boolean bQi;
    private boolean bQj;
    private boolean bQk;
    private ObjectAnimator bQl;
    private float bQm;
    private RectF bQn;
    private float bQo;
    private float bQp;
    private float bQq;
    private int bQr;
    private int bQs;
    private Paint bQt;
    private CharSequence bQu;
    private CharSequence bQv;
    private TextPaint bQw;
    private Layout bQx;
    private Layout bQy;
    private float bQz;
    private int ib;
    private int pb;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public static class a extends View.BaseSavedState {
        public static final Parcelable.Creator<a> CREATOR = new C0287a();
        CharSequence bQI;
        CharSequence bQJ;

        /* renamed from: com.baidu.poly.widget.SwitchButton$a$a  reason: collision with other inner class name */
        /* loaded from: classes6.dex */
        static class C0287a implements Parcelable.Creator<a> {
            C0287a() {
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // android.os.Parcelable.Creator
            /* renamed from: gB */
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
            TextUtils.writeToParcel(this.bQI, parcel, i);
            TextUtils.writeToParcel(this.bQJ, parcel, i);
        }

        a(Parcelable parcelable) {
            super(parcelable);
        }

        private a(Parcel parcel) {
            super(parcel);
            this.bQI = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
            this.bQJ = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
        }
    }

    public SwitchButton(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.bQk = false;
        this.bQE = false;
        this.bQF = false;
        this.bQG = false;
        c(attributeSet);
    }

    private void Xb() {
        ViewParent parent = getParent();
        if (parent != null) {
            parent.requestDisallowInterceptTouchEvent(true);
        }
        this.bQG = true;
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
        this.bQr = ViewConfiguration.get(getContext()).getScaledTouchSlop();
        this.bQs = ViewConfiguration.getPressedStateDuration() + ViewConfiguration.getTapTimeout();
        this.bQh = new Paint(1);
        this.bQt = new Paint(1);
        this.bQt.setStyle(Paint.Style.STROKE);
        this.bQt.setStrokeWidth(getResources().getDisplayMetrics().density);
        this.bQw = getPaint();
        this.bQc = new RectF();
        this.bQd = new RectF();
        this.bQe = new RectF();
        this.bPO = new RectF();
        this.bQf = new RectF();
        this.bQg = new RectF();
        this.bQl = ObjectAnimator.ofFloat(this, "progress", 0.0f, 0.0f).setDuration(250L);
        this.bQl.setInterpolator(new AccelerateDecelerateInterpolator());
        this.bQn = new RectF();
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
        this.bQu = str2;
        this.bQv = str;
        this.bQB = i4;
        this.bQC = i3;
        this.bQD = i5;
        this.bPK = drawable;
        this.bPN = colorStateList;
        this.bQi = this.bPK != null;
        this.bPS = i2;
        if (this.bPS == 0) {
            new TypedValue();
            this.bPS = 3309506;
        }
        if (!this.bQi && this.bPN == null) {
            this.bPN = com.baidu.poly.widget.b.gy(this.bPS);
            this.bPW = this.bPN.getDefaultColor();
        }
        this.bPT = p(f5);
        this.ib = p(f6);
        this.bPL = drawable2;
        this.bPM = colorStateList2;
        this.bQj = this.bPL != null;
        if (!this.bQj && this.bPM == null) {
            this.bPM = com.baidu.poly.widget.b.gz(this.bPS);
            this.bPX = this.bPM.getDefaultColor();
            this.bPY = this.bPM.getColorForState(bPI, this.bPX);
        }
        this.bPO.set(f, f3, f2, f4);
        this.bPP = this.bPO.width() >= 0.0f ? Math.max(f9, 1.0f) : f9;
        this.ab = f7;
        this.aow = f8;
        this.bPQ = i;
        this.bPR = z;
        this.bQl.setDuration(this.bPQ);
        if (isChecked()) {
            setProgress(1.0f);
        }
    }

    private float getProgress() {
        return this.bQm;
    }

    private boolean getStatusBasedOnPos() {
        return getProgress() > 0.5f;
    }

    private int gv(int i) {
        int i2;
        int size = View.MeasureSpec.getSize(i);
        int mode = View.MeasureSpec.getMode(i);
        if (this.bPT == 0 && this.bQi) {
            this.bPT = this.bPK.getIntrinsicWidth();
        }
        int p = p(this.bQz);
        if (this.bPP == 0.0f) {
            this.bPP = 1.8f;
        }
        if (mode == 1073741824) {
            int paddingLeft = (size - getPaddingLeft()) - getPaddingRight();
            if (this.bPT != 0) {
                int p2 = p(i2 * this.bPP);
                RectF rectF = this.bPO;
                int p3 = (this.bQC + p) - ((p2 - this.bPT) + p(Math.max(rectF.left, rectF.right)));
                float f = p2;
                RectF rectF2 = this.bPO;
                this.bPU = p(rectF2.right + rectF2.left + f + Math.max(p3, 0));
                if (this.bPU < 0) {
                    this.bPT = 0;
                }
                if (f + Math.max(this.bPO.left, 0.0f) + Math.max(this.bPO.right, 0.0f) + Math.max(p3, 0) > paddingLeft) {
                    this.bPT = 0;
                }
            }
            if (this.bPT == 0) {
                int p4 = p((((size - getPaddingLeft()) - getPaddingRight()) - Math.max(this.bPO.left, 0.0f)) - Math.max(this.bPO.right, 0.0f));
                if (p4 < 0) {
                    this.bPT = 0;
                    this.bPU = 0;
                    return size;
                }
                float f2 = p4;
                this.bPT = p(f2 / this.bPP);
                RectF rectF3 = this.bPO;
                this.bPU = p(f2 + rectF3.left + rectF3.right);
                if (this.bPU < 0) {
                    this.bPT = 0;
                    this.bPU = 0;
                    return size;
                }
                int i3 = p + this.bQC;
                int i4 = p4 - this.bPT;
                RectF rectF4 = this.bPO;
                int p5 = i3 - (i4 + p(Math.max(rectF4.left, rectF4.right)));
                if (p5 > 0) {
                    this.bPT -= p5;
                }
                if (this.bPT < 0) {
                    this.bPT = 0;
                    this.bPU = 0;
                    return size;
                }
                return size;
            }
            return size;
        }
        if (this.bPT == 0) {
            this.bPT = p(getResources().getDisplayMetrics().density * 20.0f);
        }
        if (this.bPP == 0.0f) {
            this.bPP = 1.8f;
        }
        int p6 = p(this.bPT * this.bPP);
        RectF rectF5 = this.bPO;
        int p7 = p((p + this.bQC) - (((p6 - this.bPT) + Math.max(rectF5.left, rectF5.right)) + this.bQB));
        float f3 = p6;
        RectF rectF6 = this.bPO;
        this.bPU = p(rectF6.right + rectF6.left + f3 + Math.max(0, p7));
        if (this.bPU < 0) {
            this.bPT = 0;
            this.bPU = 0;
            return size;
        }
        int p8 = p(Math.max(0.0f, this.bPO.left) + f3 + Math.max(0.0f, this.bPO.right) + Math.max(0, p7));
        return Math.max(p8, getPaddingLeft() + p8 + getPaddingRight());
    }

    private int gw(int i) {
        int i2;
        int i3;
        int i4;
        int size = View.MeasureSpec.getSize(i);
        int mode = View.MeasureSpec.getMode(i);
        if (this.ib == 0 && this.bQi) {
            this.ib = this.bPK.getIntrinsicHeight();
        }
        if (mode == 1073741824) {
            if (this.ib != 0) {
                RectF rectF = this.bPO;
                this.bPV = p(i3 + rectF.top + rectF.bottom);
                this.bPV = p(Math.max(this.bPV, this.bQA));
                if ((((this.bPV + getPaddingTop()) + getPaddingBottom()) - Math.min(0.0f, this.bPO.top)) - Math.min(0.0f, this.bPO.bottom) > size) {
                    this.ib = 0;
                }
            }
            if (this.ib == 0) {
                this.bPV = p(((size - getPaddingTop()) - getPaddingBottom()) + Math.min(0.0f, this.bPO.top) + Math.min(0.0f, this.bPO.bottom));
                if (this.bPV < 0) {
                    this.bPV = 0;
                    this.ib = 0;
                    return size;
                }
                RectF rectF2 = this.bPO;
                this.ib = p((i4 - rectF2.top) - rectF2.bottom);
            }
            if (this.ib < 0) {
                this.bPV = 0;
                this.ib = 0;
                return size;
            }
            return size;
        }
        if (this.ib == 0) {
            this.ib = p(getResources().getDisplayMetrics().density * 20.0f);
        }
        RectF rectF3 = this.bPO;
        this.bPV = p(this.ib + rectF3.top + rectF3.bottom);
        if (this.bPV < 0) {
            this.bPV = 0;
            this.ib = 0;
            return size;
        }
        int p = p(this.bQA - i2);
        if (p > 0) {
            this.bPV += p;
            this.ib = p + this.ib;
        }
        int max = Math.max(this.ib, this.bPV);
        return Math.max(Math.max(max, getPaddingTop() + max + getPaddingBottom()), getSuggestedMinimumHeight());
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
        this.bQm = f;
        invalidate();
    }

    private void setup() {
        int i;
        float paddingTop;
        float paddingLeft;
        int i2 = this.bPT;
        if (i2 != 0 && (i = this.ib) != 0 && this.bPU != 0 && this.bPV != 0) {
            if (this.ab == -1.0f) {
                this.ab = Math.min(i2, i) / 2;
            }
            if (this.aow == -1.0f) {
                this.aow = Math.min(this.bPU, this.bPV) / 2;
            }
            int measuredWidth = (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight();
            int measuredHeight = (getMeasuredHeight() - getPaddingTop()) - getPaddingBottom();
            int p = p((this.bPU - Math.min(0.0f, this.bPO.left)) - Math.min(0.0f, this.bPO.right));
            int p2 = p((this.bPV - Math.min(0.0f, this.bPO.top)) - Math.min(0.0f, this.bPO.bottom));
            if (measuredHeight <= p2) {
                paddingTop = getPaddingTop() + Math.max(0.0f, this.bPO.top);
            } else {
                paddingTop = (((measuredHeight - p2) + 1) / 2) + getPaddingTop() + Math.max(0.0f, this.bPO.top);
            }
            if (measuredWidth <= this.bPU) {
                paddingLeft = getPaddingLeft() + Math.max(0.0f, this.bPO.left);
            } else {
                paddingLeft = (((measuredWidth - p) + 1) / 2) + getPaddingLeft() + Math.max(0.0f, this.bPO.left);
            }
            this.bQc.set(paddingLeft, paddingTop, this.bPT + paddingLeft, this.ib + paddingTop);
            RectF rectF = this.bQc;
            float f = rectF.left;
            RectF rectF2 = this.bPO;
            float f2 = f - rectF2.left;
            RectF rectF3 = this.bQd;
            float f3 = rectF.top;
            float f4 = rectF2.top;
            rectF3.set(f2, f3 - f4, this.bPU + f2, (f3 - f4) + this.bPV);
            RectF rectF4 = this.bQe;
            RectF rectF5 = this.bQc;
            rectF4.set(rectF5.left, 0.0f, (this.bQd.right - this.bPO.right) - rectF5.width(), 0.0f);
            this.aow = Math.min(Math.min(this.bQd.width(), this.bQd.height()) / 2.0f, this.aow);
            Drawable drawable = this.bPL;
            if (drawable != null) {
                RectF rectF6 = this.bQd;
                drawable.setBounds((int) rectF6.left, (int) rectF6.top, p(rectF6.right), p(this.bQd.bottom));
            }
            if (this.bQx != null) {
                RectF rectF7 = this.bQd;
                float width = ((((((rectF7.width() + this.bQB) - this.bPT) - this.bPO.right) - this.bQx.getWidth()) / 2.0f) + rectF7.left) - this.bQD;
                RectF rectF8 = this.bQd;
                float height = ((rectF8.height() - this.bQx.getHeight()) / 2.0f) + rectF8.top;
                this.bQf.set(width, height, this.bQx.getWidth() + width, this.bQx.getHeight() + height);
            }
            if (this.bQy != null) {
                RectF rectF9 = this.bQd;
                float width2 = ((rectF9.right - (((((rectF9.width() + this.bQB) - this.bPT) - this.bPO.left) - this.bQy.getWidth()) / 2.0f)) - this.bQy.getWidth()) + this.bQD;
                RectF rectF10 = this.bQd;
                float height2 = ((rectF10.height() - this.bQy.getHeight()) / 2.0f) + rectF10.top;
                this.bQg.set(width2, height2, this.bQy.getWidth() + width2, this.bQy.getHeight() + height2);
            }
            this.bQF = true;
        }
    }

    protected void b(boolean z) {
        ObjectAnimator objectAnimator = this.bQl;
        if (objectAnimator != null) {
            if (objectAnimator.isRunning()) {
                this.bQl.cancel();
            }
            this.bQl.setDuration(this.bPQ);
            if (z) {
                this.bQl.setFloatValues(this.bQm, 1.0f);
            } else {
                this.bQl.setFloatValues(this.bQm, 0.0f);
            }
            this.bQl.start();
        }
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    protected void drawableStateChanged() {
        ColorStateList colorStateList;
        ColorStateList colorStateList2;
        super.drawableStateChanged();
        if (!this.bQi && (colorStateList2 = this.bPN) != null) {
            this.bPW = colorStateList2.getColorForState(getDrawableState(), this.bPW);
        } else {
            setDrawableState(this.bPK);
        }
        int[] iArr = isChecked() ? bPJ : bPI;
        ColorStateList textColors = getTextColors();
        if (textColors != null) {
            int defaultColor = textColors.getDefaultColor();
            this.bPZ = textColors.getColorForState(bPI, defaultColor);
            this.pb = textColors.getColorForState(bPJ, defaultColor);
        }
        if (!this.bQj && (colorStateList = this.bPM) != null) {
            this.bPX = colorStateList.getColorForState(getDrawableState(), this.bPX);
            this.bPY = this.bPM.getColorForState(iArr, this.bPX);
            return;
        }
        Drawable drawable = this.bPL;
        if ((drawable instanceof StateListDrawable) && this.bPR) {
            drawable.setState(iArr);
            this.bQb = this.bPL.getCurrent().mutate();
        } else {
            this.bQb = null;
        }
        setDrawableState(this.bPL);
        Drawable drawable2 = this.bPL;
        if (drawable2 != null) {
            this.bQa = drawable2.getCurrent().mutate();
        }
    }

    public long getAnimationDuration() {
        return this.bPQ;
    }

    public ColorStateList getBackColor() {
        return this.bPM;
    }

    public Drawable getBackDrawable() {
        return this.bPL;
    }

    public float getBackRadius() {
        return this.aow;
    }

    public PointF getBackSizeF() {
        return new PointF(this.bQd.width(), this.bQd.height());
    }

    public CharSequence getTextOff() {
        return this.bQv;
    }

    public CharSequence getTextOn() {
        return this.bQu;
    }

    public ColorStateList getThumbColor() {
        return this.bPN;
    }

    public Drawable getThumbDrawable() {
        return this.bPK;
    }

    public float getThumbHeight() {
        return this.ib;
    }

    public RectF getThumbMargin() {
        return this.bPO;
    }

    public float getThumbRadius() {
        return this.ab;
    }

    public float getThumbRangeRatio() {
        return this.bPP;
    }

    public float getThumbWidth() {
        return this.bPT;
    }

    public int getTintColor() {
        return this.bPS;
    }

    public void o() {
        if (this.bQH == null) {
            toggle();
            return;
        }
        super.setOnCheckedChangeListener(null);
        toggle();
        super.setOnCheckedChangeListener(this.bQH);
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (!this.bQF) {
            setup();
        }
        if (this.bQF) {
            if (this.bQj) {
                if (this.bPR && this.bQa != null && this.bQb != null) {
                    Drawable drawable = isChecked() ? this.bQa : this.bQb;
                    Drawable drawable2 = isChecked() ? this.bQb : this.bQa;
                    int progress = (int) (getProgress() * 255.0f);
                    drawable.setAlpha(progress);
                    drawable.draw(canvas);
                    drawable2.setAlpha(255 - progress);
                    drawable2.draw(canvas);
                } else {
                    this.bPL.setAlpha(255);
                    this.bPL.draw(canvas);
                }
            } else if (this.bPR) {
                int i = isChecked() ? this.bPX : this.bPY;
                int i2 = isChecked() ? this.bPY : this.bPX;
                int progress2 = (int) (getProgress() * 255.0f);
                this.bQh.setARGB((Color.alpha(i) * progress2) / 255, Color.red(i), Color.green(i), Color.blue(i));
                RectF rectF = this.bQd;
                float f = this.aow;
                canvas.drawRoundRect(rectF, f, f, this.bQh);
                this.bQh.setARGB(((255 - progress2) * Color.alpha(i2)) / 255, Color.red(i2), Color.green(i2), Color.blue(i2));
                RectF rectF2 = this.bQd;
                float f2 = this.aow;
                canvas.drawRoundRect(rectF2, f2, f2, this.bQh);
                this.bQh.setAlpha(255);
            } else {
                this.bQh.setColor(this.bPX);
                RectF rectF3 = this.bQd;
                float f3 = this.aow;
                canvas.drawRoundRect(rectF3, f3, f3, this.bQh);
            }
            Layout layout = ((double) getProgress()) > 0.5d ? this.bQx : this.bQy;
            RectF rectF4 = ((double) getProgress()) > 0.5d ? this.bQf : this.bQg;
            if (layout != null && rectF4 != null) {
                int progress3 = (int) ((((double) getProgress()) >= 0.75d ? (getProgress() * 4.0f) - 3.0f : ((double) getProgress()) < 0.25d ? 1.0f - (getProgress() * 4.0f) : 0.0f) * 255.0f);
                int i3 = ((double) getProgress()) > 0.5d ? this.bPZ : this.pb;
                layout.getPaint().setARGB((progress3 * Color.alpha(i3)) / 255, Color.red(i3), Color.green(i3), Color.blue(i3));
                canvas.save();
                canvas.translate(rectF4.left, rectF4.top);
                layout.draw(canvas);
                canvas.restore();
            }
            this.bQn.set(this.bQc);
            this.bQn.offset(this.bQm * this.bQe.width(), 0.0f);
            if (this.bQi) {
                Drawable drawable3 = this.bPK;
                RectF rectF5 = this.bQn;
                drawable3.setBounds((int) rectF5.left, (int) rectF5.top, p(rectF5.right), p(this.bQn.bottom));
                this.bPK.draw(canvas);
            } else {
                this.bQh.setColor(this.bPW);
                RectF rectF6 = this.bQn;
                float f4 = this.ab;
                canvas.drawRoundRect(rectF6, f4, f4, this.bQh);
            }
            if (this.bQk) {
                this.bQt.setColor(Color.parseColor("#AA0000"));
                canvas.drawRect(this.bQd, this.bQt);
                this.bQt.setColor(Color.parseColor("#0000FF"));
                canvas.drawRect(this.bQn, this.bQt);
                this.bQt.setColor(Color.parseColor("#000000"));
                RectF rectF7 = this.bQe;
                float f5 = rectF7.left;
                float f6 = this.bQc.top;
                canvas.drawLine(f5, f6, rectF7.right, f6, this.bQt);
                this.bQt.setColor(Color.parseColor("#00CC00"));
                canvas.drawRect(((double) getProgress()) > 0.5d ? this.bQf : this.bQg, this.bQt);
            }
        }
    }

    @Override // android.widget.TextView, android.view.View
    protected void onMeasure(int i, int i2) {
        if (this.bQx == null && !TextUtils.isEmpty(this.bQu)) {
            this.bQx = e(this.bQu);
        }
        if (this.bQy == null && !TextUtils.isEmpty(this.bQv)) {
            this.bQy = e(this.bQv);
        }
        Layout layout = this.bQx;
        float width = layout != null ? layout.getWidth() : 0.0f;
        Layout layout2 = this.bQy;
        float width2 = layout2 != null ? layout2.getWidth() : 0.0f;
        if (width == 0.0f && width2 == 0.0f) {
            this.bQz = 0.0f;
        } else {
            this.bQz = Math.max(width, width2);
        }
        Layout layout3 = this.bQx;
        float height = layout3 != null ? layout3.getHeight() : 0.0f;
        Layout layout4 = this.bQy;
        float height2 = layout4 != null ? layout4.getHeight() : 0.0f;
        if (height == 0.0f && height2 == 0.0f) {
            this.bQA = 0.0f;
        } else {
            this.bQA = Math.max(height, height2);
        }
        setMeasuredDimension(gv(i), gw(i2));
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        a aVar = (a) parcelable;
        a(aVar.bQI, aVar.bQJ);
        this.bQE = true;
        super.onRestoreInstanceState(aVar.getSuperState());
        this.bQE = false;
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    public Parcelable onSaveInstanceState() {
        a aVar = new a(super.onSaveInstanceState());
        aVar.bQI = this.bQu;
        aVar.bQJ = this.bQv;
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
        if (isEnabled() && isClickable() && isFocusable() && this.bQF) {
            int action = motionEvent.getAction();
            float x = motionEvent.getX() - this.bQo;
            float y = motionEvent.getY() - this.bQp;
            switch (action) {
                case 0:
                    this.bQo = motionEvent.getX();
                    this.bQp = motionEvent.getY();
                    this.bQq = this.bQo;
                    setPressed(true);
                    break;
                case 1:
                case 3:
                    this.bQG = false;
                    setPressed(false);
                    float eventTime = (float) (motionEvent.getEventTime() - motionEvent.getDownTime());
                    if (Math.abs(x) < this.bQr && Math.abs(y) < this.bQr && eventTime < this.bQs) {
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
                    setProgress(getProgress() + ((x2 - this.bQq) / this.bQe.width()));
                    if (!this.bQG && (Math.abs(x) > this.bQr / 2 || Math.abs(y) > this.bQr / 2)) {
                        if (y != 0.0f && Math.abs(x) <= Math.abs(y)) {
                            if (Math.abs(y) > Math.abs(x)) {
                                return false;
                            }
                        } else {
                            Xb();
                        }
                    }
                    this.bQq = x2;
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
        this.bPQ = j;
    }

    public void setBackColor(ColorStateList colorStateList) {
        this.bPM = colorStateList;
        if (this.bPM != null) {
            setBackDrawable(null);
        }
        invalidate();
    }

    public void setBackColorRes(int i) {
        setBackColor(getResources().getColorStateList(i));
    }

    public void setBackDrawable(Drawable drawable) {
        this.bPL = drawable;
        this.bQj = this.bPL != null;
        refreshDrawableState();
        this.bQF = false;
        requestLayout();
        invalidate();
    }

    public void setBackDrawableRes(int i) {
        setBackDrawable(getResources().getDrawable(i));
    }

    public void setBackRadius(float f) {
        this.aow = f;
        if (this.bQj) {
            return;
        }
        invalidate();
    }

    @Override // android.widget.CompoundButton, android.widget.Checkable
    public void setChecked(boolean z) {
        if (isChecked() != z) {
            b(z);
        }
        if (this.bQE) {
            setCheckedImmediatelyNoEvent(z);
        } else {
            super.setChecked(z);
        }
    }

    public void setCheckedImmediately(boolean z) {
        super.setChecked(z);
        ObjectAnimator objectAnimator = this.bQl;
        if (objectAnimator != null && objectAnimator.isRunning()) {
            this.bQl.cancel();
        }
        setProgress(z ? 1.0f : 0.0f);
        invalidate();
    }

    public void setCheckedImmediatelyNoEvent(boolean z) {
        if (this.bQH == null) {
            setCheckedImmediately(z);
            return;
        }
        super.setOnCheckedChangeListener(null);
        setCheckedImmediately(z);
        super.setOnCheckedChangeListener(this.bQH);
    }

    public void setCheckedNoEvent(boolean z) {
        if (this.bQH == null) {
            setChecked(z);
            return;
        }
        super.setOnCheckedChangeListener(null);
        setChecked(z);
        super.setOnCheckedChangeListener(this.bQH);
    }

    public void setDrawDebugRect(boolean z) {
        this.bQk = z;
        invalidate();
    }

    public void setFadeBack(boolean z) {
        this.bPR = z;
    }

    @Override // android.widget.CompoundButton
    public void setOnCheckedChangeListener(CompoundButton.OnCheckedChangeListener onCheckedChangeListener) {
        super.setOnCheckedChangeListener(onCheckedChangeListener);
        this.bQH = onCheckedChangeListener;
    }

    public void setTextAdjust(int i) {
        this.bQD = i;
        this.bQF = false;
        requestLayout();
        invalidate();
    }

    public void setTextExtra(int i) {
        this.bQC = i;
        this.bQF = false;
        requestLayout();
        invalidate();
    }

    public void setTextThumbInset(int i) {
        this.bQB = i;
        this.bQF = false;
        requestLayout();
        invalidate();
    }

    public void setThumbColor(ColorStateList colorStateList) {
        this.bPN = colorStateList;
        if (this.bPN != null) {
            setThumbDrawable(null);
        }
        invalidate();
    }

    public void setThumbColorRes(int i) {
        setThumbColor(getResources().getColorStateList(i));
    }

    public void setThumbDrawable(Drawable drawable) {
        this.bPK = drawable;
        this.bQi = this.bPK != null;
        refreshDrawableState();
        this.bQF = false;
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
        if (this.bQi) {
            return;
        }
        invalidate();
    }

    public void setThumbRangeRatio(float f) {
        this.bPP = f;
        this.bQF = false;
        requestLayout();
    }

    public void setTintColor(int i) {
        this.bPS = i;
        this.bPN = com.baidu.poly.widget.b.gy(this.bPS);
        this.bPM = com.baidu.poly.widget.b.gz(this.bPS);
        this.bQj = false;
        this.bQi = false;
        refreshDrawableState();
        invalidate();
    }

    public SwitchButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.bQk = false;
        this.bQE = false;
        this.bQF = false;
        this.bQG = false;
        c(attributeSet);
    }

    public SwitchButton(Context context) {
        super(context);
        this.bQk = false;
        this.bQE = false;
        this.bQF = false;
        this.bQG = false;
        c(null);
    }

    private Layout e(CharSequence charSequence) {
        TextPaint textPaint = this.bQw;
        return new StaticLayout(charSequence, textPaint, (int) Math.ceil(Layout.getDesiredWidth(charSequence, textPaint)), Layout.Alignment.ALIGN_CENTER, 1.0f, 0.0f, false);
    }

    public void a(float f, float f2, float f3, float f4) {
        this.bPO.set(f, f2, f3, f4);
        this.bQF = false;
        requestLayout();
    }

    public void a(CharSequence charSequence, CharSequence charSequence2) {
        this.bQu = charSequence;
        this.bQv = charSequence2;
        this.bQx = null;
        this.bQy = null;
        this.bQF = false;
        requestLayout();
        invalidate();
    }
}
