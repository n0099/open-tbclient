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
/* loaded from: classes11.dex */
public class SwitchButton extends CompoundButton {
    private static int[] bAZ = {16842912, 16842910, 16842919};
    private static int[] bBa = {-16842912, 16842910, 16842919};
    private float ab;
    private Paint bBA;
    private boolean bBB;
    private boolean bBC;
    private boolean bBD;
    private ObjectAnimator bBE;
    private float bBF;
    private RectF bBG;
    private float bBH;
    private float bBI;
    private float bBJ;
    private int bBK;
    private int bBL;
    private Paint bBM;
    private CharSequence bBN;
    private CharSequence bBO;
    private TextPaint bBP;
    private Layout bBQ;
    private Layout bBR;
    private float bBS;
    private float bBT;
    private int bBU;
    private int bBV;
    private int bBW;
    private boolean bBX;
    private boolean bBY;
    private boolean bBZ;
    private Drawable bBb;
    private Drawable bBc;
    private ColorStateList bBd;
    private ColorStateList bBe;
    private float bBf;
    private float bBg;
    private RectF bBh;
    private long bBi;
    private boolean bBj;
    private int bBk;
    private int bBl;
    private int bBm;
    private int bBn;
    private int bBo;
    private int bBp;
    private int bBq;
    private int bBr;
    private int bBs;
    private Drawable bBt;
    private Drawable bBu;
    private RectF bBv;
    private RectF bBw;
    private RectF bBx;
    private RectF bBy;
    private RectF bBz;
    private CompoundButton.OnCheckedChangeListener bCa;
    private int db;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes11.dex */
    public static class a extends View.BaseSavedState {
        public static final Parcelable.Creator<a> CREATOR = new C0250a();
        CharSequence bCb;
        CharSequence bCc;

        /* renamed from: com.baidu.poly.widget.SwitchButton$a$a  reason: collision with other inner class name */
        /* loaded from: classes11.dex */
        static class C0250a implements Parcelable.Creator<a> {
            C0250a() {
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // android.os.Parcelable.Creator
            /* renamed from: ec */
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
            TextUtils.writeToParcel(this.bCb, parcel, i);
            TextUtils.writeToParcel(this.bCc, parcel, i);
        }

        a(Parcelable parcelable) {
            super(parcelable);
        }

        private a(Parcel parcel) {
            super(parcel);
            this.bCb = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
            this.bCc = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
        }
    }

    public SwitchButton(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.bBD = false;
        this.bBX = false;
        this.bBY = false;
        this.bBZ = false;
        c(attributeSet);
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
        this.bBK = ViewConfiguration.get(getContext()).getScaledTouchSlop();
        this.bBL = ViewConfiguration.getPressedStateDuration() + ViewConfiguration.getTapTimeout();
        this.bBA = new Paint(1);
        this.bBM = new Paint(1);
        this.bBM.setStyle(Paint.Style.STROKE);
        this.bBM.setStrokeWidth(getResources().getDisplayMetrics().density);
        this.bBP = getPaint();
        this.bBv = new RectF();
        this.bBw = new RectF();
        this.bBx = new RectF();
        this.bBh = new RectF();
        this.bBy = new RectF();
        this.bBz = new RectF();
        this.bBE = ObjectAnimator.ofFloat(this, "progress", 0.0f, 0.0f).setDuration(250L);
        this.bBE.setInterpolator(new AccelerateDecelerateInterpolator());
        this.bBG = new RectF();
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
        this.bBN = str2;
        this.bBO = str;
        this.bBU = i4;
        this.bBV = i3;
        this.bBW = i5;
        this.bBb = drawable;
        this.bBe = colorStateList;
        this.bBB = this.bBb != null;
        this.db = i2;
        if (this.db == 0) {
            new TypedValue();
            this.db = 3309506;
        }
        if (!this.bBB && this.bBe == null) {
            this.bBe = com.baidu.poly.widget.b.dZ(this.db);
            this.bBo = this.bBe.getDefaultColor();
        }
        this.bBk = j(f5);
        this.bBl = j(f6);
        this.bBc = drawable2;
        this.bBd = colorStateList2;
        this.bBC = this.bBc != null;
        if (!this.bBC && this.bBd == null) {
            this.bBd = com.baidu.poly.widget.b.ea(this.db);
            this.bBp = this.bBd.getDefaultColor();
            this.bBq = this.bBd.getColorForState(bAZ, this.bBp);
        }
        this.bBh.set(f, f3, f2, f4);
        this.ab = this.bBh.width() >= 0.0f ? Math.max(f9, 1.0f) : f9;
        this.bBf = f7;
        this.bBg = f8;
        this.bBi = i;
        this.bBj = z;
        this.bBE.setDuration(this.bBi);
        if (isChecked()) {
            setProgress(1.0f);
        }
    }

    private int dX(int i) {
        int i2;
        int size = View.MeasureSpec.getSize(i);
        int mode = View.MeasureSpec.getMode(i);
        if (this.bBk == 0 && this.bBB) {
            this.bBk = this.bBb.getIntrinsicWidth();
        }
        int j = j(this.bBS);
        if (this.ab == 0.0f) {
            this.ab = 1.8f;
        }
        if (mode == 1073741824) {
            int paddingLeft = (size - getPaddingLeft()) - getPaddingRight();
            if (this.bBk != 0) {
                int j2 = j(i2 * this.ab);
                RectF rectF = this.bBh;
                int j3 = (this.bBV + j) - ((j2 - this.bBk) + j(Math.max(rectF.left, rectF.right)));
                float f = j2;
                RectF rectF2 = this.bBh;
                this.bBm = j(rectF2.right + rectF2.left + f + Math.max(j3, 0));
                if (this.bBm < 0) {
                    this.bBk = 0;
                }
                if (f + Math.max(this.bBh.left, 0.0f) + Math.max(this.bBh.right, 0.0f) + Math.max(j3, 0) > paddingLeft) {
                    this.bBk = 0;
                }
            }
            if (this.bBk == 0) {
                int j4 = j((((size - getPaddingLeft()) - getPaddingRight()) - Math.max(this.bBh.left, 0.0f)) - Math.max(this.bBh.right, 0.0f));
                if (j4 < 0) {
                    this.bBk = 0;
                    this.bBm = 0;
                    return size;
                }
                float f2 = j4;
                this.bBk = j(f2 / this.ab);
                RectF rectF3 = this.bBh;
                this.bBm = j(f2 + rectF3.left + rectF3.right);
                if (this.bBm < 0) {
                    this.bBk = 0;
                    this.bBm = 0;
                    return size;
                }
                int i3 = j + this.bBV;
                int i4 = j4 - this.bBk;
                RectF rectF4 = this.bBh;
                int j5 = i3 - (i4 + j(Math.max(rectF4.left, rectF4.right)));
                if (j5 > 0) {
                    this.bBk -= j5;
                }
                if (this.bBk < 0) {
                    this.bBk = 0;
                    this.bBm = 0;
                    return size;
                }
                return size;
            }
            return size;
        }
        if (this.bBk == 0) {
            this.bBk = j(getResources().getDisplayMetrics().density * 20.0f);
        }
        if (this.ab == 0.0f) {
            this.ab = 1.8f;
        }
        int j6 = j(this.bBk * this.ab);
        RectF rectF5 = this.bBh;
        int j7 = j((j + this.bBV) - (((j6 - this.bBk) + Math.max(rectF5.left, rectF5.right)) + this.bBU));
        float f3 = j6;
        RectF rectF6 = this.bBh;
        this.bBm = j(rectF6.right + rectF6.left + f3 + Math.max(0, j7));
        if (this.bBm < 0) {
            this.bBk = 0;
            this.bBm = 0;
            return size;
        }
        int j8 = j(Math.max(0.0f, this.bBh.left) + f3 + Math.max(0.0f, this.bBh.right) + Math.max(0, j7));
        return Math.max(j8, getPaddingLeft() + j8 + getPaddingRight());
    }

    private void da() {
        ViewParent parent = getParent();
        if (parent != null) {
            parent.requestDisallowInterceptTouchEvent(true);
        }
        this.bBZ = true;
    }

    private float getProgress() {
        return this.bBF;
    }

    private boolean getStatusBasedOnPos() {
        return getProgress() > 0.5f;
    }

    private int i(int i) {
        int i2;
        int i3;
        int i4;
        int size = View.MeasureSpec.getSize(i);
        int mode = View.MeasureSpec.getMode(i);
        if (this.bBl == 0 && this.bBB) {
            this.bBl = this.bBb.getIntrinsicHeight();
        }
        if (mode == 1073741824) {
            if (this.bBl != 0) {
                RectF rectF = this.bBh;
                this.bBn = j(i3 + rectF.top + rectF.bottom);
                this.bBn = j(Math.max(this.bBn, this.bBT));
                if ((((this.bBn + getPaddingTop()) + getPaddingBottom()) - Math.min(0.0f, this.bBh.top)) - Math.min(0.0f, this.bBh.bottom) > size) {
                    this.bBl = 0;
                }
            }
            if (this.bBl == 0) {
                this.bBn = j(((size - getPaddingTop()) - getPaddingBottom()) + Math.min(0.0f, this.bBh.top) + Math.min(0.0f, this.bBh.bottom));
                if (this.bBn < 0) {
                    this.bBn = 0;
                    this.bBl = 0;
                    return size;
                }
                RectF rectF2 = this.bBh;
                this.bBl = j((i4 - rectF2.top) - rectF2.bottom);
            }
            if (this.bBl < 0) {
                this.bBn = 0;
                this.bBl = 0;
                return size;
            }
            return size;
        }
        if (this.bBl == 0) {
            this.bBl = j(getResources().getDisplayMetrics().density * 20.0f);
        }
        RectF rectF3 = this.bBh;
        this.bBn = j(this.bBl + rectF3.top + rectF3.bottom);
        if (this.bBn < 0) {
            this.bBn = 0;
            this.bBl = 0;
            return size;
        }
        int j = j(this.bBT - i2);
        if (j > 0) {
            this.bBn += j;
            this.bBl = j + this.bBl;
        }
        int max = Math.max(this.bBl, this.bBn);
        return Math.max(Math.max(max, getPaddingTop() + max + getPaddingBottom()), getSuggestedMinimumHeight());
    }

    private int j(double d) {
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
        this.bBF = f;
        invalidate();
    }

    private void setup() {
        int i;
        float paddingTop;
        float paddingLeft;
        int i2 = this.bBk;
        if (i2 != 0 && (i = this.bBl) != 0 && this.bBm != 0 && this.bBn != 0) {
            if (this.bBf == -1.0f) {
                this.bBf = Math.min(i2, i) / 2;
            }
            if (this.bBg == -1.0f) {
                this.bBg = Math.min(this.bBm, this.bBn) / 2;
            }
            int measuredWidth = (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight();
            int measuredHeight = (getMeasuredHeight() - getPaddingTop()) - getPaddingBottom();
            int j = j((this.bBm - Math.min(0.0f, this.bBh.left)) - Math.min(0.0f, this.bBh.right));
            int j2 = j((this.bBn - Math.min(0.0f, this.bBh.top)) - Math.min(0.0f, this.bBh.bottom));
            if (measuredHeight <= j2) {
                paddingTop = getPaddingTop() + Math.max(0.0f, this.bBh.top);
            } else {
                paddingTop = (((measuredHeight - j2) + 1) / 2) + getPaddingTop() + Math.max(0.0f, this.bBh.top);
            }
            if (measuredWidth <= this.bBm) {
                paddingLeft = getPaddingLeft() + Math.max(0.0f, this.bBh.left);
            } else {
                paddingLeft = (((measuredWidth - j) + 1) / 2) + getPaddingLeft() + Math.max(0.0f, this.bBh.left);
            }
            this.bBv.set(paddingLeft, paddingTop, this.bBk + paddingLeft, this.bBl + paddingTop);
            RectF rectF = this.bBv;
            float f = rectF.left;
            RectF rectF2 = this.bBh;
            float f2 = f - rectF2.left;
            RectF rectF3 = this.bBw;
            float f3 = rectF.top;
            float f4 = rectF2.top;
            rectF3.set(f2, f3 - f4, this.bBm + f2, (f3 - f4) + this.bBn);
            RectF rectF4 = this.bBx;
            RectF rectF5 = this.bBv;
            rectF4.set(rectF5.left, 0.0f, (this.bBw.right - this.bBh.right) - rectF5.width(), 0.0f);
            this.bBg = Math.min(Math.min(this.bBw.width(), this.bBw.height()) / 2.0f, this.bBg);
            Drawable drawable = this.bBc;
            if (drawable != null) {
                RectF rectF6 = this.bBw;
                drawable.setBounds((int) rectF6.left, (int) rectF6.top, j(rectF6.right), j(this.bBw.bottom));
            }
            if (this.bBQ != null) {
                RectF rectF7 = this.bBw;
                float width = ((((((rectF7.width() + this.bBU) - this.bBk) - this.bBh.right) - this.bBQ.getWidth()) / 2.0f) + rectF7.left) - this.bBW;
                RectF rectF8 = this.bBw;
                float height = ((rectF8.height() - this.bBQ.getHeight()) / 2.0f) + rectF8.top;
                this.bBy.set(width, height, this.bBQ.getWidth() + width, this.bBQ.getHeight() + height);
            }
            if (this.bBR != null) {
                RectF rectF9 = this.bBw;
                float width2 = ((rectF9.right - (((((rectF9.width() + this.bBU) - this.bBk) - this.bBh.left) - this.bBR.getWidth()) / 2.0f)) - this.bBR.getWidth()) + this.bBW;
                RectF rectF10 = this.bBw;
                float height2 = ((rectF10.height() - this.bBR.getHeight()) / 2.0f) + rectF10.top;
                this.bBz.set(width2, height2, this.bBR.getWidth() + width2, this.bBR.getHeight() + height2);
            }
            this.bBY = true;
        }
    }

    protected void b(boolean z) {
        ObjectAnimator objectAnimator = this.bBE;
        if (objectAnimator != null) {
            if (objectAnimator.isRunning()) {
                this.bBE.cancel();
            }
            this.bBE.setDuration(this.bBi);
            if (z) {
                this.bBE.setFloatValues(this.bBF, 1.0f);
            } else {
                this.bBE.setFloatValues(this.bBF, 0.0f);
            }
            this.bBE.start();
        }
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    protected void drawableStateChanged() {
        ColorStateList colorStateList;
        ColorStateList colorStateList2;
        super.drawableStateChanged();
        if (!this.bBB && (colorStateList2 = this.bBe) != null) {
            this.bBo = colorStateList2.getColorForState(getDrawableState(), this.bBo);
        } else {
            setDrawableState(this.bBb);
        }
        int[] iArr = isChecked() ? bBa : bAZ;
        ColorStateList textColors = getTextColors();
        if (textColors != null) {
            int defaultColor = textColors.getDefaultColor();
            this.bBr = textColors.getColorForState(bAZ, defaultColor);
            this.bBs = textColors.getColorForState(bBa, defaultColor);
        }
        if (!this.bBC && (colorStateList = this.bBd) != null) {
            this.bBp = colorStateList.getColorForState(getDrawableState(), this.bBp);
            this.bBq = this.bBd.getColorForState(iArr, this.bBp);
            return;
        }
        Drawable drawable = this.bBc;
        if ((drawable instanceof StateListDrawable) && this.bBj) {
            drawable.setState(iArr);
            this.bBu = this.bBc.getCurrent().mutate();
        } else {
            this.bBu = null;
        }
        setDrawableState(this.bBc);
        Drawable drawable2 = this.bBc;
        if (drawable2 != null) {
            this.bBt = drawable2.getCurrent().mutate();
        }
    }

    public long getAnimationDuration() {
        return this.bBi;
    }

    public ColorStateList getBackColor() {
        return this.bBd;
    }

    public Drawable getBackDrawable() {
        return this.bBc;
    }

    public float getBackRadius() {
        return this.bBg;
    }

    public PointF getBackSizeF() {
        return new PointF(this.bBw.width(), this.bBw.height());
    }

    public CharSequence getTextOff() {
        return this.bBO;
    }

    public CharSequence getTextOn() {
        return this.bBN;
    }

    public ColorStateList getThumbColor() {
        return this.bBe;
    }

    public Drawable getThumbDrawable() {
        return this.bBb;
    }

    public float getThumbHeight() {
        return this.bBl;
    }

    public RectF getThumbMargin() {
        return this.bBh;
    }

    public float getThumbRadius() {
        return this.bBf;
    }

    public float getThumbRangeRatio() {
        return this.ab;
    }

    public float getThumbWidth() {
        return this.bBk;
    }

    public int getTintColor() {
        return this.db;
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (!this.bBY) {
            setup();
        }
        if (this.bBY) {
            if (this.bBC) {
                if (this.bBj && this.bBt != null && this.bBu != null) {
                    Drawable drawable = isChecked() ? this.bBt : this.bBu;
                    Drawable drawable2 = isChecked() ? this.bBu : this.bBt;
                    int progress = (int) (getProgress() * 255.0f);
                    drawable.setAlpha(progress);
                    drawable.draw(canvas);
                    drawable2.setAlpha(255 - progress);
                    drawable2.draw(canvas);
                } else {
                    this.bBc.setAlpha(255);
                    this.bBc.draw(canvas);
                }
            } else if (this.bBj) {
                int i = isChecked() ? this.bBp : this.bBq;
                int i2 = isChecked() ? this.bBq : this.bBp;
                int progress2 = (int) (getProgress() * 255.0f);
                this.bBA.setARGB((Color.alpha(i) * progress2) / 255, Color.red(i), Color.green(i), Color.blue(i));
                RectF rectF = this.bBw;
                float f = this.bBg;
                canvas.drawRoundRect(rectF, f, f, this.bBA);
                this.bBA.setARGB(((255 - progress2) * Color.alpha(i2)) / 255, Color.red(i2), Color.green(i2), Color.blue(i2));
                RectF rectF2 = this.bBw;
                float f2 = this.bBg;
                canvas.drawRoundRect(rectF2, f2, f2, this.bBA);
                this.bBA.setAlpha(255);
            } else {
                this.bBA.setColor(this.bBp);
                RectF rectF3 = this.bBw;
                float f3 = this.bBg;
                canvas.drawRoundRect(rectF3, f3, f3, this.bBA);
            }
            Layout layout = ((double) getProgress()) > 0.5d ? this.bBQ : this.bBR;
            RectF rectF4 = ((double) getProgress()) > 0.5d ? this.bBy : this.bBz;
            if (layout != null && rectF4 != null) {
                int progress3 = (int) ((((double) getProgress()) >= 0.75d ? (getProgress() * 4.0f) - 3.0f : ((double) getProgress()) < 0.25d ? 1.0f - (getProgress() * 4.0f) : 0.0f) * 255.0f);
                int i3 = ((double) getProgress()) > 0.5d ? this.bBr : this.bBs;
                layout.getPaint().setARGB((progress3 * Color.alpha(i3)) / 255, Color.red(i3), Color.green(i3), Color.blue(i3));
                canvas.save();
                canvas.translate(rectF4.left, rectF4.top);
                layout.draw(canvas);
                canvas.restore();
            }
            this.bBG.set(this.bBv);
            this.bBG.offset(this.bBF * this.bBx.width(), 0.0f);
            if (this.bBB) {
                Drawable drawable3 = this.bBb;
                RectF rectF5 = this.bBG;
                drawable3.setBounds((int) rectF5.left, (int) rectF5.top, j(rectF5.right), j(this.bBG.bottom));
                this.bBb.draw(canvas);
            } else {
                this.bBA.setColor(this.bBo);
                RectF rectF6 = this.bBG;
                float f4 = this.bBf;
                canvas.drawRoundRect(rectF6, f4, f4, this.bBA);
            }
            if (this.bBD) {
                this.bBM.setColor(Color.parseColor("#AA0000"));
                canvas.drawRect(this.bBw, this.bBM);
                this.bBM.setColor(Color.parseColor("#0000FF"));
                canvas.drawRect(this.bBG, this.bBM);
                this.bBM.setColor(Color.parseColor("#000000"));
                RectF rectF7 = this.bBx;
                float f5 = rectF7.left;
                float f6 = this.bBv.top;
                canvas.drawLine(f5, f6, rectF7.right, f6, this.bBM);
                this.bBM.setColor(Color.parseColor("#00CC00"));
                canvas.drawRect(((double) getProgress()) > 0.5d ? this.bBy : this.bBz, this.bBM);
            }
        }
    }

    @Override // android.widget.TextView, android.view.View
    protected void onMeasure(int i, int i2) {
        if (this.bBQ == null && !TextUtils.isEmpty(this.bBN)) {
            this.bBQ = d(this.bBN);
        }
        if (this.bBR == null && !TextUtils.isEmpty(this.bBO)) {
            this.bBR = d(this.bBO);
        }
        Layout layout = this.bBQ;
        float width = layout != null ? layout.getWidth() : 0.0f;
        Layout layout2 = this.bBR;
        float width2 = layout2 != null ? layout2.getWidth() : 0.0f;
        if (width == 0.0f && width2 == 0.0f) {
            this.bBS = 0.0f;
        } else {
            this.bBS = Math.max(width, width2);
        }
        Layout layout3 = this.bBQ;
        float height = layout3 != null ? layout3.getHeight() : 0.0f;
        Layout layout4 = this.bBR;
        float height2 = layout4 != null ? layout4.getHeight() : 0.0f;
        if (height == 0.0f && height2 == 0.0f) {
            this.bBT = 0.0f;
        } else {
            this.bBT = Math.max(height, height2);
        }
        setMeasuredDimension(dX(i), i(i2));
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        a aVar = (a) parcelable;
        a(aVar.bCb, aVar.bCc);
        this.bBX = true;
        super.onRestoreInstanceState(aVar.getSuperState());
        this.bBX = false;
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    public Parcelable onSaveInstanceState() {
        a aVar = new a(super.onSaveInstanceState());
        aVar.bCb = this.bBN;
        aVar.bCc = this.bBO;
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
        if (isEnabled() && isClickable() && isFocusable() && this.bBY) {
            int action = motionEvent.getAction();
            float x = motionEvent.getX() - this.bBH;
            float y = motionEvent.getY() - this.bBI;
            switch (action) {
                case 0:
                    this.bBH = motionEvent.getX();
                    this.bBI = motionEvent.getY();
                    this.bBJ = this.bBH;
                    setPressed(true);
                    break;
                case 1:
                case 3:
                    this.bBZ = false;
                    setPressed(false);
                    float eventTime = (float) (motionEvent.getEventTime() - motionEvent.getDownTime());
                    if (Math.abs(x) < this.bBK && Math.abs(y) < this.bBK && eventTime < this.bBL) {
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
                    setProgress(getProgress() + ((x2 - this.bBJ) / this.bBx.width()));
                    if (!this.bBZ && (Math.abs(x) > this.bBK / 2 || Math.abs(y) > this.bBK / 2)) {
                        if (y != 0.0f && Math.abs(x) <= Math.abs(y)) {
                            if (Math.abs(y) > Math.abs(x)) {
                                return false;
                            }
                        } else {
                            da();
                        }
                    }
                    this.bBJ = x2;
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
        this.bBi = j;
    }

    public void setBackColor(ColorStateList colorStateList) {
        this.bBd = colorStateList;
        if (this.bBd != null) {
            setBackDrawable(null);
        }
        invalidate();
    }

    public void setBackColorRes(int i) {
        setBackColor(getResources().getColorStateList(i));
    }

    public void setBackDrawable(Drawable drawable) {
        this.bBc = drawable;
        this.bBC = this.bBc != null;
        refreshDrawableState();
        this.bBY = false;
        requestLayout();
        invalidate();
    }

    public void setBackDrawableRes(int i) {
        setBackDrawable(getResources().getDrawable(i));
    }

    public void setBackRadius(float f) {
        this.bBg = f;
        if (this.bBC) {
            return;
        }
        invalidate();
    }

    @Override // android.widget.CompoundButton, android.widget.Checkable
    public void setChecked(boolean z) {
        if (isChecked() != z) {
            b(z);
        }
        if (this.bBX) {
            setCheckedImmediatelyNoEvent(z);
        } else {
            super.setChecked(z);
        }
    }

    public void setCheckedImmediately(boolean z) {
        super.setChecked(z);
        ObjectAnimator objectAnimator = this.bBE;
        if (objectAnimator != null && objectAnimator.isRunning()) {
            this.bBE.cancel();
        }
        setProgress(z ? 1.0f : 0.0f);
        invalidate();
    }

    public void setCheckedImmediatelyNoEvent(boolean z) {
        if (this.bCa == null) {
            setCheckedImmediately(z);
            return;
        }
        super.setOnCheckedChangeListener(null);
        setCheckedImmediately(z);
        super.setOnCheckedChangeListener(this.bCa);
    }

    public void setCheckedNoEvent(boolean z) {
        if (this.bCa == null) {
            setChecked(z);
            return;
        }
        super.setOnCheckedChangeListener(null);
        setChecked(z);
        super.setOnCheckedChangeListener(this.bCa);
    }

    public void setDrawDebugRect(boolean z) {
        this.bBD = z;
        invalidate();
    }

    public void setFadeBack(boolean z) {
        this.bBj = z;
    }

    @Override // android.widget.CompoundButton
    public void setOnCheckedChangeListener(CompoundButton.OnCheckedChangeListener onCheckedChangeListener) {
        super.setOnCheckedChangeListener(onCheckedChangeListener);
        this.bCa = onCheckedChangeListener;
    }

    public void setTextAdjust(int i) {
        this.bBW = i;
        this.bBY = false;
        requestLayout();
        invalidate();
    }

    public void setTextExtra(int i) {
        this.bBV = i;
        this.bBY = false;
        requestLayout();
        invalidate();
    }

    public void setTextThumbInset(int i) {
        this.bBU = i;
        this.bBY = false;
        requestLayout();
        invalidate();
    }

    public void setThumbColor(ColorStateList colorStateList) {
        this.bBe = colorStateList;
        if (this.bBe != null) {
            setThumbDrawable(null);
        }
        invalidate();
    }

    public void setThumbColorRes(int i) {
        setThumbColor(getResources().getColorStateList(i));
    }

    public void setThumbDrawable(Drawable drawable) {
        this.bBb = drawable;
        this.bBB = this.bBb != null;
        refreshDrawableState();
        this.bBY = false;
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
        this.bBf = f;
        if (this.bBB) {
            return;
        }
        invalidate();
    }

    public void setThumbRangeRatio(float f) {
        this.ab = f;
        this.bBY = false;
        requestLayout();
    }

    public void setTintColor(int i) {
        this.db = i;
        this.bBe = com.baidu.poly.widget.b.dZ(this.db);
        this.bBd = com.baidu.poly.widget.b.ea(this.db);
        this.bBC = false;
        this.bBB = false;
        refreshDrawableState();
        invalidate();
    }

    public SwitchButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.bBD = false;
        this.bBX = false;
        this.bBY = false;
        this.bBZ = false;
        c(attributeSet);
    }

    public SwitchButton(Context context) {
        super(context);
        this.bBD = false;
        this.bBX = false;
        this.bBY = false;
        this.bBZ = false;
        c(null);
    }

    public void j() {
        if (this.bCa == null) {
            toggle();
            return;
        }
        super.setOnCheckedChangeListener(null);
        toggle();
        super.setOnCheckedChangeListener(this.bCa);
    }

    private Layout d(CharSequence charSequence) {
        TextPaint textPaint = this.bBP;
        return new StaticLayout(charSequence, textPaint, (int) Math.ceil(Layout.getDesiredWidth(charSequence, textPaint)), Layout.Alignment.ALIGN_CENTER, 1.0f, 0.0f, false);
    }

    public void a(float f, float f2, float f3, float f4) {
        this.bBh.set(f, f2, f3, f4);
        this.bBY = false;
        requestLayout();
    }

    public void a(CharSequence charSequence, CharSequence charSequence2) {
        this.bBN = charSequence;
        this.bBO = charSequence2;
        this.bBQ = null;
        this.bBR = null;
        this.bBY = false;
        requestLayout();
        invalidate();
    }
}
