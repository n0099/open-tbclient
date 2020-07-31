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
/* loaded from: classes9.dex */
public class SwitchButton extends CompoundButton {
    private static int[] bBq = {16842912, 16842910, 16842919};
    private static int[] bBr = {-16842912, 16842910, 16842919};
    private float ab;
    private boolean bBA;
    private int bBB;
    private int bBC;
    private int bBD;
    private int bBE;
    private int bBF;
    private int bBG;
    private int bBH;
    private int bBI;
    private int bBJ;
    private int bBK;
    private Drawable bBL;
    private Drawable bBM;
    private RectF bBN;
    private RectF bBO;
    private RectF bBP;
    private RectF bBQ;
    private RectF bBR;
    private Paint bBS;
    private boolean bBT;
    private boolean bBU;
    private boolean bBV;
    private ObjectAnimator bBW;
    private float bBX;
    private RectF bBY;
    private float bBZ;
    private Drawable bBs;
    private Drawable bBt;
    private ColorStateList bBu;
    private ColorStateList bBv;
    private float bBw;
    private RectF bBx;
    private float bBy;
    private long bBz;
    private float bCa;
    private float bCb;
    private int bCc;
    private int bCd;
    private Paint bCe;
    private CharSequence bCf;
    private CharSequence bCg;
    private TextPaint bCh;
    private Layout bCi;
    private Layout bCj;
    private float bCk;
    private float bCl;
    private int bCm;
    private int bCn;
    private int bCo;
    private boolean bCp;
    private boolean bCq;
    private boolean bCr;
    private CompoundButton.OnCheckedChangeListener bCs;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes9.dex */
    public static class a extends View.BaseSavedState {
        public static final Parcelable.Creator<a> CREATOR = new C0253a();
        CharSequence bCt;
        CharSequence bCu;

        /* renamed from: com.baidu.poly.widget.SwitchButton$a$a  reason: collision with other inner class name */
        /* loaded from: classes9.dex */
        static class C0253a implements Parcelable.Creator<a> {
            C0253a() {
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
            TextUtils.writeToParcel(this.bCt, parcel, i);
            TextUtils.writeToParcel(this.bCu, parcel, i);
        }

        a(Parcelable parcelable) {
            super(parcelable);
        }

        private a(Parcel parcel) {
            super(parcel);
            this.bCt = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
            this.bCu = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
        }
    }

    public SwitchButton(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.bBV = false;
        this.bCp = false;
        this.bCq = false;
        this.bCr = false;
        c(attributeSet);
    }

    private void OC() {
        ViewParent parent = getParent();
        if (parent != null) {
            parent.requestDisallowInterceptTouchEvent(true);
        }
        this.bCr = true;
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
        this.bCc = ViewConfiguration.get(getContext()).getScaledTouchSlop();
        this.bCd = ViewConfiguration.getPressedStateDuration() + ViewConfiguration.getTapTimeout();
        this.bBS = new Paint(1);
        this.bCe = new Paint(1);
        this.bCe.setStyle(Paint.Style.STROKE);
        this.bCe.setStrokeWidth(getResources().getDisplayMetrics().density);
        this.bCh = getPaint();
        this.bBN = new RectF();
        this.bBO = new RectF();
        this.bBP = new RectF();
        this.bBx = new RectF();
        this.bBQ = new RectF();
        this.bBR = new RectF();
        this.bBW = ObjectAnimator.ofFloat(this, "progress", 0.0f, 0.0f).setDuration(250L);
        this.bBW.setInterpolator(new AccelerateDecelerateInterpolator());
        this.bBY = new RectF();
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
        this.bCf = str2;
        this.bCg = str;
        this.bCm = i4;
        this.bCn = i3;
        this.bCo = i5;
        this.bBs = drawable;
        this.bBv = colorStateList;
        this.bBT = this.bBs != null;
        this.bBB = i2;
        if (this.bBB == 0) {
            new TypedValue();
            this.bBB = 3309506;
        }
        if (!this.bBT && this.bBv == null) {
            this.bBv = com.baidu.poly.widget.b.dZ(this.bBB);
            this.bBG = this.bBv.getDefaultColor();
        }
        this.bBC = j(f5);
        this.bBD = j(f6);
        this.bBt = drawable2;
        this.bBu = colorStateList2;
        this.bBU = this.bBt != null;
        if (!this.bBU && this.bBu == null) {
            this.bBu = com.baidu.poly.widget.b.ea(this.bBB);
            this.bBH = this.bBu.getDefaultColor();
            this.bBI = this.bBu.getColorForState(bBq, this.bBH);
        }
        this.bBx.set(f, f3, f2, f4);
        this.bBy = this.bBx.width() >= 0.0f ? Math.max(f9, 1.0f) : f9;
        this.bBw = f7;
        this.ab = f8;
        this.bBz = i;
        this.bBA = z;
        this.bBW.setDuration(this.bBz);
        if (isChecked()) {
            setProgress(1.0f);
        }
    }

    private int dW(int i) {
        int i2;
        int size = View.MeasureSpec.getSize(i);
        int mode = View.MeasureSpec.getMode(i);
        if (this.bBC == 0 && this.bBT) {
            this.bBC = this.bBs.getIntrinsicWidth();
        }
        int j = j(this.bCk);
        if (this.bBy == 0.0f) {
            this.bBy = 1.8f;
        }
        if (mode == 1073741824) {
            int paddingLeft = (size - getPaddingLeft()) - getPaddingRight();
            if (this.bBC != 0) {
                int j2 = j(i2 * this.bBy);
                RectF rectF = this.bBx;
                int j3 = (this.bCn + j) - ((j2 - this.bBC) + j(Math.max(rectF.left, rectF.right)));
                float f = j2;
                RectF rectF2 = this.bBx;
                this.bBE = j(rectF2.right + rectF2.left + f + Math.max(j3, 0));
                if (this.bBE < 0) {
                    this.bBC = 0;
                }
                if (f + Math.max(this.bBx.left, 0.0f) + Math.max(this.bBx.right, 0.0f) + Math.max(j3, 0) > paddingLeft) {
                    this.bBC = 0;
                }
            }
            if (this.bBC == 0) {
                int j4 = j((((size - getPaddingLeft()) - getPaddingRight()) - Math.max(this.bBx.left, 0.0f)) - Math.max(this.bBx.right, 0.0f));
                if (j4 < 0) {
                    this.bBC = 0;
                    this.bBE = 0;
                    return size;
                }
                float f2 = j4;
                this.bBC = j(f2 / this.bBy);
                RectF rectF3 = this.bBx;
                this.bBE = j(f2 + rectF3.left + rectF3.right);
                if (this.bBE < 0) {
                    this.bBC = 0;
                    this.bBE = 0;
                    return size;
                }
                int i3 = j + this.bCn;
                int i4 = j4 - this.bBC;
                RectF rectF4 = this.bBx;
                int j5 = i3 - (i4 + j(Math.max(rectF4.left, rectF4.right)));
                if (j5 > 0) {
                    this.bBC -= j5;
                }
                if (this.bBC < 0) {
                    this.bBC = 0;
                    this.bBE = 0;
                    return size;
                }
                return size;
            }
            return size;
        }
        if (this.bBC == 0) {
            this.bBC = j(getResources().getDisplayMetrics().density * 20.0f);
        }
        if (this.bBy == 0.0f) {
            this.bBy = 1.8f;
        }
        int j6 = j(this.bBC * this.bBy);
        RectF rectF5 = this.bBx;
        int j7 = j((j + this.bCn) - (((j6 - this.bBC) + Math.max(rectF5.left, rectF5.right)) + this.bCm));
        float f3 = j6;
        RectF rectF6 = this.bBx;
        this.bBE = j(rectF6.right + rectF6.left + f3 + Math.max(0, j7));
        if (this.bBE < 0) {
            this.bBC = 0;
            this.bBE = 0;
            return size;
        }
        int j8 = j(Math.max(0.0f, this.bBx.left) + f3 + Math.max(0.0f, this.bBx.right) + Math.max(0, j7));
        return Math.max(j8, getPaddingLeft() + j8 + getPaddingRight());
    }

    private int dX(int i) {
        int i2;
        int i3;
        int i4;
        int size = View.MeasureSpec.getSize(i);
        int mode = View.MeasureSpec.getMode(i);
        if (this.bBD == 0 && this.bBT) {
            this.bBD = this.bBs.getIntrinsicHeight();
        }
        if (mode == 1073741824) {
            if (this.bBD != 0) {
                RectF rectF = this.bBx;
                this.bBF = j(i3 + rectF.top + rectF.bottom);
                this.bBF = j(Math.max(this.bBF, this.bCl));
                if ((((this.bBF + getPaddingTop()) + getPaddingBottom()) - Math.min(0.0f, this.bBx.top)) - Math.min(0.0f, this.bBx.bottom) > size) {
                    this.bBD = 0;
                }
            }
            if (this.bBD == 0) {
                this.bBF = j(((size - getPaddingTop()) - getPaddingBottom()) + Math.min(0.0f, this.bBx.top) + Math.min(0.0f, this.bBx.bottom));
                if (this.bBF < 0) {
                    this.bBF = 0;
                    this.bBD = 0;
                    return size;
                }
                RectF rectF2 = this.bBx;
                this.bBD = j((i4 - rectF2.top) - rectF2.bottom);
            }
            if (this.bBD < 0) {
                this.bBF = 0;
                this.bBD = 0;
                return size;
            }
            return size;
        }
        if (this.bBD == 0) {
            this.bBD = j(getResources().getDisplayMetrics().density * 20.0f);
        }
        RectF rectF3 = this.bBx;
        this.bBF = j(this.bBD + rectF3.top + rectF3.bottom);
        if (this.bBF < 0) {
            this.bBF = 0;
            this.bBD = 0;
            return size;
        }
        int j = j(this.bCl - i2);
        if (j > 0) {
            this.bBF += j;
            this.bBD = j + this.bBD;
        }
        int max = Math.max(this.bBD, this.bBF);
        return Math.max(Math.max(max, getPaddingTop() + max + getPaddingBottom()), getSuggestedMinimumHeight());
    }

    private float getProgress() {
        return this.bBX;
    }

    private boolean getStatusBasedOnPos() {
        return getProgress() > 0.5f;
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
        this.bBX = f;
        invalidate();
    }

    private void setup() {
        int i;
        float paddingTop;
        float paddingLeft;
        int i2 = this.bBC;
        if (i2 != 0 && (i = this.bBD) != 0 && this.bBE != 0 && this.bBF != 0) {
            if (this.bBw == -1.0f) {
                this.bBw = Math.min(i2, i) / 2;
            }
            if (this.ab == -1.0f) {
                this.ab = Math.min(this.bBE, this.bBF) / 2;
            }
            int measuredWidth = (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight();
            int measuredHeight = (getMeasuredHeight() - getPaddingTop()) - getPaddingBottom();
            int j = j((this.bBE - Math.min(0.0f, this.bBx.left)) - Math.min(0.0f, this.bBx.right));
            int j2 = j((this.bBF - Math.min(0.0f, this.bBx.top)) - Math.min(0.0f, this.bBx.bottom));
            if (measuredHeight <= j2) {
                paddingTop = getPaddingTop() + Math.max(0.0f, this.bBx.top);
            } else {
                paddingTop = (((measuredHeight - j2) + 1) / 2) + getPaddingTop() + Math.max(0.0f, this.bBx.top);
            }
            if (measuredWidth <= this.bBE) {
                paddingLeft = getPaddingLeft() + Math.max(0.0f, this.bBx.left);
            } else {
                paddingLeft = (((measuredWidth - j) + 1) / 2) + getPaddingLeft() + Math.max(0.0f, this.bBx.left);
            }
            this.bBN.set(paddingLeft, paddingTop, this.bBC + paddingLeft, this.bBD + paddingTop);
            RectF rectF = this.bBN;
            float f = rectF.left;
            RectF rectF2 = this.bBx;
            float f2 = f - rectF2.left;
            RectF rectF3 = this.bBO;
            float f3 = rectF.top;
            float f4 = rectF2.top;
            rectF3.set(f2, f3 - f4, this.bBE + f2, (f3 - f4) + this.bBF);
            RectF rectF4 = this.bBP;
            RectF rectF5 = this.bBN;
            rectF4.set(rectF5.left, 0.0f, (this.bBO.right - this.bBx.right) - rectF5.width(), 0.0f);
            this.ab = Math.min(Math.min(this.bBO.width(), this.bBO.height()) / 2.0f, this.ab);
            Drawable drawable = this.bBt;
            if (drawable != null) {
                RectF rectF6 = this.bBO;
                drawable.setBounds((int) rectF6.left, (int) rectF6.top, j(rectF6.right), j(this.bBO.bottom));
            }
            if (this.bCi != null) {
                RectF rectF7 = this.bBO;
                float width = ((((((rectF7.width() + this.bCm) - this.bBC) - this.bBx.right) - this.bCi.getWidth()) / 2.0f) + rectF7.left) - this.bCo;
                RectF rectF8 = this.bBO;
                float height = ((rectF8.height() - this.bCi.getHeight()) / 2.0f) + rectF8.top;
                this.bBQ.set(width, height, this.bCi.getWidth() + width, this.bCi.getHeight() + height);
            }
            if (this.bCj != null) {
                RectF rectF9 = this.bBO;
                float width2 = ((rectF9.right - (((((rectF9.width() + this.bCm) - this.bBC) - this.bBx.left) - this.bCj.getWidth()) / 2.0f)) - this.bCj.getWidth()) + this.bCo;
                RectF rectF10 = this.bBO;
                float height2 = ((rectF10.height() - this.bCj.getHeight()) / 2.0f) + rectF10.top;
                this.bBR.set(width2, height2, this.bCj.getWidth() + width2, this.bCj.getHeight() + height2);
            }
            this.bCq = true;
        }
    }

    protected void b(boolean z) {
        ObjectAnimator objectAnimator = this.bBW;
        if (objectAnimator != null) {
            if (objectAnimator.isRunning()) {
                this.bBW.cancel();
            }
            this.bBW.setDuration(this.bBz);
            if (z) {
                this.bBW.setFloatValues(this.bBX, 1.0f);
            } else {
                this.bBW.setFloatValues(this.bBX, 0.0f);
            }
            this.bBW.start();
        }
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    protected void drawableStateChanged() {
        ColorStateList colorStateList;
        ColorStateList colorStateList2;
        super.drawableStateChanged();
        if (!this.bBT && (colorStateList2 = this.bBv) != null) {
            this.bBG = colorStateList2.getColorForState(getDrawableState(), this.bBG);
        } else {
            setDrawableState(this.bBs);
        }
        int[] iArr = isChecked() ? bBr : bBq;
        ColorStateList textColors = getTextColors();
        if (textColors != null) {
            int defaultColor = textColors.getDefaultColor();
            this.bBJ = textColors.getColorForState(bBq, defaultColor);
            this.bBK = textColors.getColorForState(bBr, defaultColor);
        }
        if (!this.bBU && (colorStateList = this.bBu) != null) {
            this.bBH = colorStateList.getColorForState(getDrawableState(), this.bBH);
            this.bBI = this.bBu.getColorForState(iArr, this.bBH);
            return;
        }
        Drawable drawable = this.bBt;
        if ((drawable instanceof StateListDrawable) && this.bBA) {
            drawable.setState(iArr);
            this.bBM = this.bBt.getCurrent().mutate();
        } else {
            this.bBM = null;
        }
        setDrawableState(this.bBt);
        Drawable drawable2 = this.bBt;
        if (drawable2 != null) {
            this.bBL = drawable2.getCurrent().mutate();
        }
    }

    public long getAnimationDuration() {
        return this.bBz;
    }

    public ColorStateList getBackColor() {
        return this.bBu;
    }

    public Drawable getBackDrawable() {
        return this.bBt;
    }

    public float getBackRadius() {
        return this.ab;
    }

    public PointF getBackSizeF() {
        return new PointF(this.bBO.width(), this.bBO.height());
    }

    public CharSequence getTextOff() {
        return this.bCg;
    }

    public CharSequence getTextOn() {
        return this.bCf;
    }

    public ColorStateList getThumbColor() {
        return this.bBv;
    }

    public Drawable getThumbDrawable() {
        return this.bBs;
    }

    public float getThumbHeight() {
        return this.bBD;
    }

    public RectF getThumbMargin() {
        return this.bBx;
    }

    public float getThumbRadius() {
        return this.bBw;
    }

    public float getThumbRangeRatio() {
        return this.bBy;
    }

    public float getThumbWidth() {
        return this.bBC;
    }

    public int getTintColor() {
        return this.bBB;
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (!this.bCq) {
            setup();
        }
        if (this.bCq) {
            if (this.bBU) {
                if (this.bBA && this.bBL != null && this.bBM != null) {
                    Drawable drawable = isChecked() ? this.bBL : this.bBM;
                    Drawable drawable2 = isChecked() ? this.bBM : this.bBL;
                    int progress = (int) (getProgress() * 255.0f);
                    drawable.setAlpha(progress);
                    drawable.draw(canvas);
                    drawable2.setAlpha(255 - progress);
                    drawable2.draw(canvas);
                } else {
                    this.bBt.setAlpha(255);
                    this.bBt.draw(canvas);
                }
            } else if (this.bBA) {
                int i = isChecked() ? this.bBH : this.bBI;
                int i2 = isChecked() ? this.bBI : this.bBH;
                int progress2 = (int) (getProgress() * 255.0f);
                this.bBS.setARGB((Color.alpha(i) * progress2) / 255, Color.red(i), Color.green(i), Color.blue(i));
                RectF rectF = this.bBO;
                float f = this.ab;
                canvas.drawRoundRect(rectF, f, f, this.bBS);
                this.bBS.setARGB(((255 - progress2) * Color.alpha(i2)) / 255, Color.red(i2), Color.green(i2), Color.blue(i2));
                RectF rectF2 = this.bBO;
                float f2 = this.ab;
                canvas.drawRoundRect(rectF2, f2, f2, this.bBS);
                this.bBS.setAlpha(255);
            } else {
                this.bBS.setColor(this.bBH);
                RectF rectF3 = this.bBO;
                float f3 = this.ab;
                canvas.drawRoundRect(rectF3, f3, f3, this.bBS);
            }
            Layout layout = ((double) getProgress()) > 0.5d ? this.bCi : this.bCj;
            RectF rectF4 = ((double) getProgress()) > 0.5d ? this.bBQ : this.bBR;
            if (layout != null && rectF4 != null) {
                int progress3 = (int) ((((double) getProgress()) >= 0.75d ? (getProgress() * 4.0f) - 3.0f : ((double) getProgress()) < 0.25d ? 1.0f - (getProgress() * 4.0f) : 0.0f) * 255.0f);
                int i3 = ((double) getProgress()) > 0.5d ? this.bBJ : this.bBK;
                layout.getPaint().setARGB((progress3 * Color.alpha(i3)) / 255, Color.red(i3), Color.green(i3), Color.blue(i3));
                canvas.save();
                canvas.translate(rectF4.left, rectF4.top);
                layout.draw(canvas);
                canvas.restore();
            }
            this.bBY.set(this.bBN);
            this.bBY.offset(this.bBX * this.bBP.width(), 0.0f);
            if (this.bBT) {
                Drawable drawable3 = this.bBs;
                RectF rectF5 = this.bBY;
                drawable3.setBounds((int) rectF5.left, (int) rectF5.top, j(rectF5.right), j(this.bBY.bottom));
                this.bBs.draw(canvas);
            } else {
                this.bBS.setColor(this.bBG);
                RectF rectF6 = this.bBY;
                float f4 = this.bBw;
                canvas.drawRoundRect(rectF6, f4, f4, this.bBS);
            }
            if (this.bBV) {
                this.bCe.setColor(Color.parseColor("#AA0000"));
                canvas.drawRect(this.bBO, this.bCe);
                this.bCe.setColor(Color.parseColor("#0000FF"));
                canvas.drawRect(this.bBY, this.bCe);
                this.bCe.setColor(Color.parseColor("#000000"));
                RectF rectF7 = this.bBP;
                float f5 = rectF7.left;
                float f6 = this.bBN.top;
                canvas.drawLine(f5, f6, rectF7.right, f6, this.bCe);
                this.bCe.setColor(Color.parseColor("#00CC00"));
                canvas.drawRect(((double) getProgress()) > 0.5d ? this.bBQ : this.bBR, this.bCe);
            }
        }
    }

    @Override // android.widget.TextView, android.view.View
    protected void onMeasure(int i, int i2) {
        if (this.bCi == null && !TextUtils.isEmpty(this.bCf)) {
            this.bCi = d(this.bCf);
        }
        if (this.bCj == null && !TextUtils.isEmpty(this.bCg)) {
            this.bCj = d(this.bCg);
        }
        Layout layout = this.bCi;
        float width = layout != null ? layout.getWidth() : 0.0f;
        Layout layout2 = this.bCj;
        float width2 = layout2 != null ? layout2.getWidth() : 0.0f;
        if (width == 0.0f && width2 == 0.0f) {
            this.bCk = 0.0f;
        } else {
            this.bCk = Math.max(width, width2);
        }
        Layout layout3 = this.bCi;
        float height = layout3 != null ? layout3.getHeight() : 0.0f;
        Layout layout4 = this.bCj;
        float height2 = layout4 != null ? layout4.getHeight() : 0.0f;
        if (height == 0.0f && height2 == 0.0f) {
            this.bCl = 0.0f;
        } else {
            this.bCl = Math.max(height, height2);
        }
        setMeasuredDimension(dW(i), dX(i2));
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        a aVar = (a) parcelable;
        a(aVar.bCt, aVar.bCu);
        this.bCp = true;
        super.onRestoreInstanceState(aVar.getSuperState());
        this.bCp = false;
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    public Parcelable onSaveInstanceState() {
        a aVar = new a(super.onSaveInstanceState());
        aVar.bCt = this.bCf;
        aVar.bCu = this.bCg;
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
        if (isEnabled() && isClickable() && isFocusable() && this.bCq) {
            int action = motionEvent.getAction();
            float x = motionEvent.getX() - this.bBZ;
            float y = motionEvent.getY() - this.bCa;
            switch (action) {
                case 0:
                    this.bBZ = motionEvent.getX();
                    this.bCa = motionEvent.getY();
                    this.bCb = this.bBZ;
                    setPressed(true);
                    break;
                case 1:
                case 3:
                    this.bCr = false;
                    setPressed(false);
                    float eventTime = (float) (motionEvent.getEventTime() - motionEvent.getDownTime());
                    if (Math.abs(x) < this.bCc && Math.abs(y) < this.bCc && eventTime < this.bCd) {
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
                    setProgress(getProgress() + ((x2 - this.bCb) / this.bBP.width()));
                    if (!this.bCr && (Math.abs(x) > this.bCc / 2 || Math.abs(y) > this.bCc / 2)) {
                        if (y != 0.0f && Math.abs(x) <= Math.abs(y)) {
                            if (Math.abs(y) > Math.abs(x)) {
                                return false;
                            }
                        } else {
                            OC();
                        }
                    }
                    this.bCb = x2;
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
        this.bBz = j;
    }

    public void setBackColor(ColorStateList colorStateList) {
        this.bBu = colorStateList;
        if (this.bBu != null) {
            setBackDrawable(null);
        }
        invalidate();
    }

    public void setBackColorRes(int i) {
        setBackColor(getResources().getColorStateList(i));
    }

    public void setBackDrawable(Drawable drawable) {
        this.bBt = drawable;
        this.bBU = this.bBt != null;
        refreshDrawableState();
        this.bCq = false;
        requestLayout();
        invalidate();
    }

    public void setBackDrawableRes(int i) {
        setBackDrawable(getResources().getDrawable(i));
    }

    public void setBackRadius(float f) {
        this.ab = f;
        if (this.bBU) {
            return;
        }
        invalidate();
    }

    @Override // android.widget.CompoundButton, android.widget.Checkable
    public void setChecked(boolean z) {
        if (isChecked() != z) {
            b(z);
        }
        if (this.bCp) {
            setCheckedImmediatelyNoEvent(z);
        } else {
            super.setChecked(z);
        }
    }

    public void setCheckedImmediately(boolean z) {
        super.setChecked(z);
        ObjectAnimator objectAnimator = this.bBW;
        if (objectAnimator != null && objectAnimator.isRunning()) {
            this.bBW.cancel();
        }
        setProgress(z ? 1.0f : 0.0f);
        invalidate();
    }

    public void setCheckedImmediatelyNoEvent(boolean z) {
        if (this.bCs == null) {
            setCheckedImmediately(z);
            return;
        }
        super.setOnCheckedChangeListener(null);
        setCheckedImmediately(z);
        super.setOnCheckedChangeListener(this.bCs);
    }

    public void setCheckedNoEvent(boolean z) {
        if (this.bCs == null) {
            setChecked(z);
            return;
        }
        super.setOnCheckedChangeListener(null);
        setChecked(z);
        super.setOnCheckedChangeListener(this.bCs);
    }

    public void setDrawDebugRect(boolean z) {
        this.bBV = z;
        invalidate();
    }

    public void setFadeBack(boolean z) {
        this.bBA = z;
    }

    @Override // android.widget.CompoundButton
    public void setOnCheckedChangeListener(CompoundButton.OnCheckedChangeListener onCheckedChangeListener) {
        super.setOnCheckedChangeListener(onCheckedChangeListener);
        this.bCs = onCheckedChangeListener;
    }

    public void setTextAdjust(int i) {
        this.bCo = i;
        this.bCq = false;
        requestLayout();
        invalidate();
    }

    public void setTextExtra(int i) {
        this.bCn = i;
        this.bCq = false;
        requestLayout();
        invalidate();
    }

    public void setTextThumbInset(int i) {
        this.bCm = i;
        this.bCq = false;
        requestLayout();
        invalidate();
    }

    public void setThumbColor(ColorStateList colorStateList) {
        this.bBv = colorStateList;
        if (this.bBv != null) {
            setThumbDrawable(null);
        }
        invalidate();
    }

    public void setThumbColorRes(int i) {
        setThumbColor(getResources().getColorStateList(i));
    }

    public void setThumbDrawable(Drawable drawable) {
        this.bBs = drawable;
        this.bBT = this.bBs != null;
        refreshDrawableState();
        this.bCq = false;
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
        this.bBw = f;
        if (this.bBT) {
            return;
        }
        invalidate();
    }

    public void setThumbRangeRatio(float f) {
        this.bBy = f;
        this.bCq = false;
        requestLayout();
    }

    public void setTintColor(int i) {
        this.bBB = i;
        this.bBv = com.baidu.poly.widget.b.dZ(this.bBB);
        this.bBu = com.baidu.poly.widget.b.ea(this.bBB);
        this.bBU = false;
        this.bBT = false;
        refreshDrawableState();
        invalidate();
    }

    public SwitchButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.bBV = false;
        this.bCp = false;
        this.bCq = false;
        this.bCr = false;
        c(attributeSet);
    }

    public SwitchButton(Context context) {
        super(context);
        this.bBV = false;
        this.bCp = false;
        this.bCq = false;
        this.bCr = false;
        c(null);
    }

    public void j() {
        if (this.bCs == null) {
            toggle();
            return;
        }
        super.setOnCheckedChangeListener(null);
        toggle();
        super.setOnCheckedChangeListener(this.bCs);
    }

    private Layout d(CharSequence charSequence) {
        TextPaint textPaint = this.bCh;
        return new StaticLayout(charSequence, textPaint, (int) Math.ceil(Layout.getDesiredWidth(charSequence, textPaint)), Layout.Alignment.ALIGN_CENTER, 1.0f, 0.0f, false);
    }

    public void a(float f, float f2, float f3, float f4) {
        this.bBx.set(f, f2, f3, f4);
        this.bCq = false;
        requestLayout();
    }

    public void a(CharSequence charSequence, CharSequence charSequence2) {
        this.bCf = charSequence;
        this.bCg = charSequence2;
        this.bCi = null;
        this.bCj = null;
        this.bCq = false;
        requestLayout();
        invalidate();
    }
}
