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
import com.baidu.searchbox.picture.component.BaseBrowseView;
/* loaded from: classes11.dex */
public class SwitchButton extends CompoundButton {
    private static int[] aSB = {16842912, 16842910, 16842919};
    private static int[] aSC = {-16842912, 16842910, 16842919};
    private Drawable aSD;
    private Drawable aSE;
    private ColorStateList aSF;
    private ColorStateList aSG;
    private float aSH;
    private float aSI;
    private RectF aSJ;
    private float aSK;
    private long aSL;
    private int aSM;
    private int aSN;
    private int aSO;
    private int aSP;
    private int aSQ;
    private int aSR;
    private int aSS;
    private int aST;
    private int aSU;
    private int aSV;
    private Drawable aSW;
    private Drawable aSX;
    private RectF aSY;
    private RectF aSZ;
    private boolean aTA;
    private boolean aTB;
    private boolean aTC;
    private CompoundButton.OnCheckedChangeListener aTD;
    private RectF aTa;
    private RectF aTb;
    private RectF aTc;
    private Paint aTd;
    private boolean aTe;
    private boolean aTf;
    private boolean aTg;
    private ObjectAnimator aTh;
    private float aTi;
    private RectF aTj;
    private float aTk;
    private float aTl;
    private float aTm;
    private int aTn;
    private int aTo;
    private Paint aTp;
    private CharSequence aTq;
    private CharSequence aTr;
    private TextPaint aTs;
    private Layout aTt;
    private Layout aTu;
    private float aTv;
    private float aTw;
    private int aTx;
    private int aTy;
    private int aTz;
    private boolean ab;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes11.dex */
    public static class a extends View.BaseSavedState {
        public static final Parcelable.Creator<a> CREATOR = new C0165a();
        CharSequence aTE;
        CharSequence aTF;

        /* renamed from: com.baidu.poly.widget.SwitchButton$a$a  reason: collision with other inner class name */
        /* loaded from: classes11.dex */
        static class C0165a implements Parcelable.Creator<a> {
            C0165a() {
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // android.os.Parcelable.Creator
            /* renamed from: dD */
            public a[] newArray(int i) {
                return new a[i];
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // android.os.Parcelable.Creator
            /* renamed from: t */
            public a createFromParcel(Parcel parcel) {
                return new a(parcel);
            }
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            TextUtils.writeToParcel(this.aTE, parcel, i);
            TextUtils.writeToParcel(this.aTF, parcel, i);
        }

        a(Parcelable parcelable) {
            super(parcelable);
        }

        private a(Parcel parcel) {
            super(parcel);
            this.aTE = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
            this.aTF = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
        }
    }

    public SwitchButton(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.aTg = false;
        this.aTA = false;
        this.aTB = false;
        this.aTC = false;
        c(attributeSet);
    }

    private void R() {
        ViewParent parent = getParent();
        if (parent != null) {
            parent.requestDisallowInterceptTouchEvent(true);
        }
        this.aTC = true;
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
        this.aTn = ViewConfiguration.get(getContext()).getScaledTouchSlop();
        this.aTo = ViewConfiguration.getPressedStateDuration() + ViewConfiguration.getTapTimeout();
        this.aTd = new Paint(1);
        this.aTp = new Paint(1);
        this.aTp.setStyle(Paint.Style.STROKE);
        this.aTp.setStrokeWidth(getResources().getDisplayMetrics().density);
        this.aTs = getPaint();
        this.aSY = new RectF();
        this.aSZ = new RectF();
        this.aTa = new RectF();
        this.aSJ = new RectF();
        this.aTb = new RectF();
        this.aTc = new RectF();
        this.aTh = ObjectAnimator.ofFloat(this, "progress", 0.0f, 0.0f).setDuration(250L);
        this.aTh.setInterpolator(new AccelerateDecelerateInterpolator());
        this.aTj = new RectF();
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
        this.aTq = str2;
        this.aTr = str;
        this.aTx = i4;
        this.aTy = i3;
        this.aTz = i5;
        this.aSD = drawable;
        this.aSG = colorStateList;
        this.aTe = this.aSD != null;
        this.aSM = i2;
        if (this.aSM == 0) {
            new TypedValue();
            this.aSM = 3309506;
        }
        if (!this.aTe && this.aSG == null) {
            this.aSG = com.baidu.poly.widget.b.dA(this.aSM);
            this.aSR = this.aSG.getDefaultColor();
        }
        this.aSN = e(f5);
        this.aSO = e(f6);
        this.aSE = drawable2;
        this.aSF = colorStateList2;
        this.aTf = this.aSE != null;
        if (!this.aTf && this.aSF == null) {
            this.aSF = com.baidu.poly.widget.b.dB(this.aSM);
            this.aSS = this.aSF.getDefaultColor();
            this.aST = this.aSF.getColorForState(aSB, this.aSS);
        }
        this.aSJ.set(f, f3, f2, f4);
        this.aSK = this.aSJ.width() >= 0.0f ? Math.max(f9, 1.0f) : f9;
        this.aSH = f7;
        this.aSI = f8;
        this.aSL = i;
        this.ab = z;
        this.aTh.setDuration(this.aSL);
        if (isChecked()) {
            setProgress(1.0f);
        }
    }

    private int dy(int i) {
        int i2;
        int size = View.MeasureSpec.getSize(i);
        int mode = View.MeasureSpec.getMode(i);
        if (this.aSN == 0 && this.aTe) {
            this.aSN = this.aSD.getIntrinsicWidth();
        }
        int e = e(this.aTv);
        if (this.aSK == 0.0f) {
            this.aSK = 1.8f;
        }
        if (mode == 1073741824) {
            int paddingLeft = (size - getPaddingLeft()) - getPaddingRight();
            if (this.aSN != 0) {
                int e2 = e(i2 * this.aSK);
                RectF rectF = this.aSJ;
                int e3 = (this.aTy + e) - ((e2 - this.aSN) + e(Math.max(rectF.left, rectF.right)));
                float f = e2;
                RectF rectF2 = this.aSJ;
                this.aSP = e(rectF2.right + rectF2.left + f + Math.max(e3, 0));
                if (this.aSP < 0) {
                    this.aSN = 0;
                }
                if (f + Math.max(this.aSJ.left, 0.0f) + Math.max(this.aSJ.right, 0.0f) + Math.max(e3, 0) > paddingLeft) {
                    this.aSN = 0;
                }
            }
            if (this.aSN == 0) {
                int e4 = e((((size - getPaddingLeft()) - getPaddingRight()) - Math.max(this.aSJ.left, 0.0f)) - Math.max(this.aSJ.right, 0.0f));
                if (e4 < 0) {
                    this.aSN = 0;
                    this.aSP = 0;
                    return size;
                }
                float f2 = e4;
                this.aSN = e(f2 / this.aSK);
                RectF rectF3 = this.aSJ;
                this.aSP = e(f2 + rectF3.left + rectF3.right);
                if (this.aSP < 0) {
                    this.aSN = 0;
                    this.aSP = 0;
                    return size;
                }
                int i3 = e + this.aTy;
                int i4 = e4 - this.aSN;
                RectF rectF4 = this.aSJ;
                int e5 = i3 - (i4 + e(Math.max(rectF4.left, rectF4.right)));
                if (e5 > 0) {
                    this.aSN -= e5;
                }
                if (this.aSN < 0) {
                    this.aSN = 0;
                    this.aSP = 0;
                    return size;
                }
                return size;
            }
            return size;
        }
        if (this.aSN == 0) {
            this.aSN = e(getResources().getDisplayMetrics().density * 20.0f);
        }
        if (this.aSK == 0.0f) {
            this.aSK = 1.8f;
        }
        int e6 = e(this.aSN * this.aSK);
        RectF rectF5 = this.aSJ;
        int e7 = e((e + this.aTy) - (((e6 - this.aSN) + Math.max(rectF5.left, rectF5.right)) + this.aTx));
        float f3 = e6;
        RectF rectF6 = this.aSJ;
        this.aSP = e(rectF6.right + rectF6.left + f3 + Math.max(0, e7));
        if (this.aSP < 0) {
            this.aSN = 0;
            this.aSP = 0;
            return size;
        }
        int e8 = e(Math.max(0.0f, this.aSJ.left) + f3 + Math.max(0.0f, this.aSJ.right) + Math.max(0, e7));
        return Math.max(e8, getPaddingLeft() + e8 + getPaddingRight());
    }

    private int e(double d) {
        return (int) Math.ceil(d);
    }

    private float getProgress() {
        return this.aTi;
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
        if (this.aSO == 0 && this.aTe) {
            this.aSO = this.aSD.getIntrinsicHeight();
        }
        if (mode == 1073741824) {
            if (this.aSO != 0) {
                RectF rectF = this.aSJ;
                this.aSQ = e(i3 + rectF.top + rectF.bottom);
                this.aSQ = e(Math.max(this.aSQ, this.aTw));
                if ((((this.aSQ + getPaddingTop()) + getPaddingBottom()) - Math.min(0.0f, this.aSJ.top)) - Math.min(0.0f, this.aSJ.bottom) > size) {
                    this.aSO = 0;
                }
            }
            if (this.aSO == 0) {
                this.aSQ = e(((size - getPaddingTop()) - getPaddingBottom()) + Math.min(0.0f, this.aSJ.top) + Math.min(0.0f, this.aSJ.bottom));
                if (this.aSQ < 0) {
                    this.aSQ = 0;
                    this.aSO = 0;
                    return size;
                }
                RectF rectF2 = this.aSJ;
                this.aSO = e((i4 - rectF2.top) - rectF2.bottom);
            }
            if (this.aSO < 0) {
                this.aSQ = 0;
                this.aSO = 0;
                return size;
            }
            return size;
        }
        if (this.aSO == 0) {
            this.aSO = e(getResources().getDisplayMetrics().density * 20.0f);
        }
        RectF rectF3 = this.aSJ;
        this.aSQ = e(this.aSO + rectF3.top + rectF3.bottom);
        if (this.aSQ < 0) {
            this.aSQ = 0;
            this.aSO = 0;
            return size;
        }
        int e = e(this.aTw - i2);
        if (e > 0) {
            this.aSQ += e;
            this.aSO = e + this.aSO;
        }
        int max = Math.max(this.aSO, this.aSQ);
        return Math.max(Math.max(max, getPaddingTop() + max + getPaddingBottom()), getSuggestedMinimumHeight());
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
        this.aTi = f;
        invalidate();
    }

    private void setup() {
        int i;
        float paddingTop;
        float paddingLeft;
        int i2 = this.aSN;
        if (i2 != 0 && (i = this.aSO) != 0 && this.aSP != 0 && this.aSQ != 0) {
            if (this.aSH == -1.0f) {
                this.aSH = Math.min(i2, i) / 2;
            }
            if (this.aSI == -1.0f) {
                this.aSI = Math.min(this.aSP, this.aSQ) / 2;
            }
            int measuredWidth = (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight();
            int measuredHeight = (getMeasuredHeight() - getPaddingTop()) - getPaddingBottom();
            int e = e((this.aSP - Math.min(0.0f, this.aSJ.left)) - Math.min(0.0f, this.aSJ.right));
            int e2 = e((this.aSQ - Math.min(0.0f, this.aSJ.top)) - Math.min(0.0f, this.aSJ.bottom));
            if (measuredHeight <= e2) {
                paddingTop = getPaddingTop() + Math.max(0.0f, this.aSJ.top);
            } else {
                paddingTop = (((measuredHeight - e2) + 1) / 2) + getPaddingTop() + Math.max(0.0f, this.aSJ.top);
            }
            if (measuredWidth <= this.aSP) {
                paddingLeft = getPaddingLeft() + Math.max(0.0f, this.aSJ.left);
            } else {
                paddingLeft = (((measuredWidth - e) + 1) / 2) + getPaddingLeft() + Math.max(0.0f, this.aSJ.left);
            }
            this.aSY.set(paddingLeft, paddingTop, this.aSN + paddingLeft, this.aSO + paddingTop);
            RectF rectF = this.aSY;
            float f = rectF.left;
            RectF rectF2 = this.aSJ;
            float f2 = f - rectF2.left;
            RectF rectF3 = this.aSZ;
            float f3 = rectF.top;
            float f4 = rectF2.top;
            rectF3.set(f2, f3 - f4, this.aSP + f2, (f3 - f4) + this.aSQ);
            RectF rectF4 = this.aTa;
            RectF rectF5 = this.aSY;
            rectF4.set(rectF5.left, 0.0f, (this.aSZ.right - this.aSJ.right) - rectF5.width(), 0.0f);
            this.aSI = Math.min(Math.min(this.aSZ.width(), this.aSZ.height()) / 2.0f, this.aSI);
            Drawable drawable = this.aSE;
            if (drawable != null) {
                RectF rectF6 = this.aSZ;
                drawable.setBounds((int) rectF6.left, (int) rectF6.top, e(rectF6.right), e(this.aSZ.bottom));
            }
            if (this.aTt != null) {
                RectF rectF7 = this.aSZ;
                float width = ((((((rectF7.width() + this.aTx) - this.aSN) - this.aSJ.right) - this.aTt.getWidth()) / 2.0f) + rectF7.left) - this.aTz;
                RectF rectF8 = this.aSZ;
                float height = ((rectF8.height() - this.aTt.getHeight()) / 2.0f) + rectF8.top;
                this.aTb.set(width, height, this.aTt.getWidth() + width, this.aTt.getHeight() + height);
            }
            if (this.aTu != null) {
                RectF rectF9 = this.aSZ;
                float width2 = ((rectF9.right - (((((rectF9.width() + this.aTx) - this.aSN) - this.aSJ.left) - this.aTu.getWidth()) / 2.0f)) - this.aTu.getWidth()) + this.aTz;
                RectF rectF10 = this.aSZ;
                float height2 = ((rectF10.height() - this.aTu.getHeight()) / 2.0f) + rectF10.top;
                this.aTc.set(width2, height2, this.aTu.getWidth() + width2, this.aTu.getHeight() + height2);
            }
            this.aTB = true;
        }
    }

    protected void b(boolean z) {
        ObjectAnimator objectAnimator = this.aTh;
        if (objectAnimator != null) {
            if (objectAnimator.isRunning()) {
                this.aTh.cancel();
            }
            this.aTh.setDuration(this.aSL);
            if (z) {
                this.aTh.setFloatValues(this.aTi, 1.0f);
            } else {
                this.aTh.setFloatValues(this.aTi, 0.0f);
            }
            this.aTh.start();
        }
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    protected void drawableStateChanged() {
        ColorStateList colorStateList;
        ColorStateList colorStateList2;
        super.drawableStateChanged();
        if (!this.aTe && (colorStateList2 = this.aSG) != null) {
            this.aSR = colorStateList2.getColorForState(getDrawableState(), this.aSR);
        } else {
            setDrawableState(this.aSD);
        }
        int[] iArr = isChecked() ? aSC : aSB;
        ColorStateList textColors = getTextColors();
        if (textColors != null) {
            int defaultColor = textColors.getDefaultColor();
            this.aSU = textColors.getColorForState(aSB, defaultColor);
            this.aSV = textColors.getColorForState(aSC, defaultColor);
        }
        if (!this.aTf && (colorStateList = this.aSF) != null) {
            this.aSS = colorStateList.getColorForState(getDrawableState(), this.aSS);
            this.aST = this.aSF.getColorForState(iArr, this.aSS);
            return;
        }
        Drawable drawable = this.aSE;
        if ((drawable instanceof StateListDrawable) && this.ab) {
            drawable.setState(iArr);
            this.aSX = this.aSE.getCurrent().mutate();
        } else {
            this.aSX = null;
        }
        setDrawableState(this.aSE);
        Drawable drawable2 = this.aSE;
        if (drawable2 != null) {
            this.aSW = drawable2.getCurrent().mutate();
        }
    }

    public void g() {
        if (this.aTD == null) {
            toggle();
            return;
        }
        super.setOnCheckedChangeListener(null);
        toggle();
        super.setOnCheckedChangeListener(this.aTD);
    }

    public long getAnimationDuration() {
        return this.aSL;
    }

    public ColorStateList getBackColor() {
        return this.aSF;
    }

    public Drawable getBackDrawable() {
        return this.aSE;
    }

    public float getBackRadius() {
        return this.aSI;
    }

    public PointF getBackSizeF() {
        return new PointF(this.aSZ.width(), this.aSZ.height());
    }

    public CharSequence getTextOff() {
        return this.aTr;
    }

    public CharSequence getTextOn() {
        return this.aTq;
    }

    public ColorStateList getThumbColor() {
        return this.aSG;
    }

    public Drawable getThumbDrawable() {
        return this.aSD;
    }

    public float getThumbHeight() {
        return this.aSO;
    }

    public RectF getThumbMargin() {
        return this.aSJ;
    }

    public float getThumbRadius() {
        return this.aSH;
    }

    public float getThumbRangeRatio() {
        return this.aSK;
    }

    public float getThumbWidth() {
        return this.aSN;
    }

    public int getTintColor() {
        return this.aSM;
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    protected void onDraw(Canvas canvas) {
        float progress;
        super.onDraw(canvas);
        if (!this.aTB) {
            setup();
        }
        if (this.aTB) {
            if (this.aTf) {
                if (this.ab && this.aSW != null && this.aSX != null) {
                    Drawable drawable = isChecked() ? this.aSW : this.aSX;
                    Drawable drawable2 = isChecked() ? this.aSX : this.aSW;
                    int progress2 = (int) (getProgress() * 255.0f);
                    drawable.setAlpha(progress2);
                    drawable.draw(canvas);
                    drawable2.setAlpha(255 - progress2);
                    drawable2.draw(canvas);
                } else {
                    this.aSE.setAlpha(255);
                    this.aSE.draw(canvas);
                }
            } else if (this.ab) {
                int i = isChecked() ? this.aSS : this.aST;
                int i2 = isChecked() ? this.aST : this.aSS;
                int progress3 = (int) (getProgress() * 255.0f);
                this.aTd.setARGB((Color.alpha(i) * progress3) / 255, Color.red(i), Color.green(i), Color.blue(i));
                RectF rectF = this.aSZ;
                float f = this.aSI;
                canvas.drawRoundRect(rectF, f, f, this.aTd);
                this.aTd.setARGB(((255 - progress3) * Color.alpha(i2)) / 255, Color.red(i2), Color.green(i2), Color.blue(i2));
                RectF rectF2 = this.aSZ;
                float f2 = this.aSI;
                canvas.drawRoundRect(rectF2, f2, f2, this.aTd);
                this.aTd.setAlpha(255);
            } else {
                this.aTd.setColor(this.aSS);
                RectF rectF3 = this.aSZ;
                float f3 = this.aSI;
                canvas.drawRoundRect(rectF3, f3, f3, this.aTd);
            }
            Layout layout = ((double) getProgress()) > 0.5d ? this.aTt : this.aTu;
            RectF rectF4 = ((double) getProgress()) > 0.5d ? this.aTb : this.aTc;
            if (layout != null && rectF4 != null) {
                if (getProgress() >= 0.75d) {
                    progress = (getProgress() * 4.0f) - 3.0f;
                } else {
                    progress = ((double) getProgress()) < 0.25d ? 1.0f - (getProgress() * 4.0f) : 0.0f;
                }
                int i3 = (int) (progress * 255.0f);
                int i4 = ((double) getProgress()) > 0.5d ? this.aSU : this.aSV;
                layout.getPaint().setARGB((i3 * Color.alpha(i4)) / 255, Color.red(i4), Color.green(i4), Color.blue(i4));
                canvas.save();
                canvas.translate(rectF4.left, rectF4.top);
                layout.draw(canvas);
                canvas.restore();
            }
            this.aTj.set(this.aSY);
            this.aTj.offset(this.aTi * this.aTa.width(), 0.0f);
            if (this.aTe) {
                Drawable drawable3 = this.aSD;
                RectF rectF5 = this.aTj;
                drawable3.setBounds((int) rectF5.left, (int) rectF5.top, e(rectF5.right), e(this.aTj.bottom));
                this.aSD.draw(canvas);
            } else {
                this.aTd.setColor(this.aSR);
                RectF rectF6 = this.aTj;
                float f4 = this.aSH;
                canvas.drawRoundRect(rectF6, f4, f4, this.aTd);
            }
            if (this.aTg) {
                this.aTp.setColor(Color.parseColor("#AA0000"));
                canvas.drawRect(this.aSZ, this.aTp);
                this.aTp.setColor(Color.parseColor("#0000FF"));
                canvas.drawRect(this.aTj, this.aTp);
                this.aTp.setColor(Color.parseColor(BaseBrowseView.ROOT_VIEW_COLOR));
                RectF rectF7 = this.aTa;
                float f5 = rectF7.left;
                float f6 = this.aSY.top;
                canvas.drawLine(f5, f6, rectF7.right, f6, this.aTp);
                this.aTp.setColor(Color.parseColor("#00CC00"));
                canvas.drawRect(((double) getProgress()) > 0.5d ? this.aTb : this.aTc, this.aTp);
            }
        }
    }

    @Override // android.widget.TextView, android.view.View
    protected void onMeasure(int i, int i2) {
        if (this.aTt == null && !TextUtils.isEmpty(this.aTq)) {
            this.aTt = d(this.aTq);
        }
        if (this.aTu == null && !TextUtils.isEmpty(this.aTr)) {
            this.aTu = d(this.aTr);
        }
        Layout layout = this.aTt;
        float width = layout != null ? layout.getWidth() : 0.0f;
        Layout layout2 = this.aTu;
        float width2 = layout2 != null ? layout2.getWidth() : 0.0f;
        if (width == 0.0f && width2 == 0.0f) {
            this.aTv = 0.0f;
        } else {
            this.aTv = Math.max(width, width2);
        }
        Layout layout3 = this.aTt;
        float height = layout3 != null ? layout3.getHeight() : 0.0f;
        Layout layout4 = this.aTu;
        float height2 = layout4 != null ? layout4.getHeight() : 0.0f;
        if (height == 0.0f && height2 == 0.0f) {
            this.aTw = 0.0f;
        } else {
            this.aTw = Math.max(height, height2);
        }
        setMeasuredDimension(dy(i), i(i2));
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        a aVar = (a) parcelable;
        a(aVar.aTE, aVar.aTF);
        this.aTA = true;
        super.onRestoreInstanceState(aVar.getSuperState());
        this.aTA = false;
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    public Parcelable onSaveInstanceState() {
        a aVar = new a(super.onSaveInstanceState());
        aVar.aTE = this.aTq;
        aVar.aTF = this.aTr;
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
        if (isEnabled() && isClickable() && isFocusable() && this.aTB) {
            int action = motionEvent.getAction();
            float x = motionEvent.getX() - this.aTk;
            float y = motionEvent.getY() - this.aTl;
            switch (action) {
                case 0:
                    this.aTk = motionEvent.getX();
                    this.aTl = motionEvent.getY();
                    this.aTm = this.aTk;
                    setPressed(true);
                    break;
                case 1:
                case 3:
                    this.aTC = false;
                    setPressed(false);
                    float eventTime = (float) (motionEvent.getEventTime() - motionEvent.getDownTime());
                    if (Math.abs(x) < this.aTn && Math.abs(y) < this.aTn && eventTime < this.aTo) {
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
                    setProgress(getProgress() + ((x2 - this.aTm) / this.aTa.width()));
                    if (!this.aTC && (Math.abs(x) > this.aTn / 2 || Math.abs(y) > this.aTn / 2)) {
                        if (y != 0.0f && Math.abs(x) <= Math.abs(y)) {
                            if (Math.abs(y) > Math.abs(x)) {
                                return false;
                            }
                        } else {
                            R();
                        }
                    }
                    this.aTm = x2;
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
        this.aSL = j;
    }

    public void setBackColor(ColorStateList colorStateList) {
        this.aSF = colorStateList;
        if (this.aSF != null) {
            setBackDrawable(null);
        }
        invalidate();
    }

    public void setBackColorRes(int i) {
        setBackColor(getResources().getColorStateList(i));
    }

    public void setBackDrawable(Drawable drawable) {
        this.aSE = drawable;
        this.aTf = this.aSE != null;
        refreshDrawableState();
        this.aTB = false;
        requestLayout();
        invalidate();
    }

    public void setBackDrawableRes(int i) {
        setBackDrawable(getResources().getDrawable(i));
    }

    public void setBackRadius(float f) {
        this.aSI = f;
        if (this.aTf) {
            return;
        }
        invalidate();
    }

    @Override // android.widget.CompoundButton, android.widget.Checkable
    public void setChecked(boolean z) {
        if (isChecked() != z) {
            b(z);
        }
        if (this.aTA) {
            setCheckedImmediatelyNoEvent(z);
        } else {
            super.setChecked(z);
        }
    }

    public void setCheckedImmediately(boolean z) {
        super.setChecked(z);
        ObjectAnimator objectAnimator = this.aTh;
        if (objectAnimator != null && objectAnimator.isRunning()) {
            this.aTh.cancel();
        }
        setProgress(z ? 1.0f : 0.0f);
        invalidate();
    }

    public void setCheckedImmediatelyNoEvent(boolean z) {
        if (this.aTD == null) {
            setCheckedImmediately(z);
            return;
        }
        super.setOnCheckedChangeListener(null);
        setCheckedImmediately(z);
        super.setOnCheckedChangeListener(this.aTD);
    }

    public void setCheckedNoEvent(boolean z) {
        if (this.aTD == null) {
            setChecked(z);
            return;
        }
        super.setOnCheckedChangeListener(null);
        setChecked(z);
        super.setOnCheckedChangeListener(this.aTD);
    }

    public void setDrawDebugRect(boolean z) {
        this.aTg = z;
        invalidate();
    }

    public void setFadeBack(boolean z) {
        this.ab = z;
    }

    @Override // android.widget.CompoundButton
    public void setOnCheckedChangeListener(CompoundButton.OnCheckedChangeListener onCheckedChangeListener) {
        super.setOnCheckedChangeListener(onCheckedChangeListener);
        this.aTD = onCheckedChangeListener;
    }

    public void setTextAdjust(int i) {
        this.aTz = i;
        this.aTB = false;
        requestLayout();
        invalidate();
    }

    public void setTextExtra(int i) {
        this.aTy = i;
        this.aTB = false;
        requestLayout();
        invalidate();
    }

    public void setTextThumbInset(int i) {
        this.aTx = i;
        this.aTB = false;
        requestLayout();
        invalidate();
    }

    public void setThumbColor(ColorStateList colorStateList) {
        this.aSG = colorStateList;
        if (this.aSG != null) {
            setThumbDrawable(null);
        }
        invalidate();
    }

    public void setThumbColorRes(int i) {
        setThumbColor(getResources().getColorStateList(i));
    }

    public void setThumbDrawable(Drawable drawable) {
        this.aSD = drawable;
        this.aTe = this.aSD != null;
        refreshDrawableState();
        this.aTB = false;
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
        this.aSH = f;
        if (this.aTe) {
            return;
        }
        invalidate();
    }

    public void setThumbRangeRatio(float f) {
        this.aSK = f;
        this.aTB = false;
        requestLayout();
    }

    public void setTintColor(int i) {
        this.aSM = i;
        this.aSG = com.baidu.poly.widget.b.dA(this.aSM);
        this.aSF = com.baidu.poly.widget.b.dB(this.aSM);
        this.aTf = false;
        this.aTe = false;
        refreshDrawableState();
        invalidate();
    }

    public SwitchButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aTg = false;
        this.aTA = false;
        this.aTB = false;
        this.aTC = false;
        c(attributeSet);
    }

    public SwitchButton(Context context) {
        super(context);
        this.aTg = false;
        this.aTA = false;
        this.aTB = false;
        this.aTC = false;
        c(null);
    }

    private Layout d(CharSequence charSequence) {
        TextPaint textPaint = this.aTs;
        return new StaticLayout(charSequence, textPaint, (int) Math.ceil(Layout.getDesiredWidth(charSequence, textPaint)), Layout.Alignment.ALIGN_CENTER, 1.0f, 0.0f, false);
    }

    public void a(float f, float f2, float f3, float f4) {
        this.aSJ.set(f, f2, f3, f4);
        this.aTB = false;
        requestLayout();
    }

    public void a(CharSequence charSequence, CharSequence charSequence2) {
        this.aTq = charSequence;
        this.aTr = charSequence2;
        this.aTt = null;
        this.aTu = null;
        this.aTB = false;
        requestLayout();
        invalidate();
    }
}
