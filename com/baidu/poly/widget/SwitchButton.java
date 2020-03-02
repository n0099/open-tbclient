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
    private static int[] aSn = {16842912, 16842910, 16842919};
    private static int[] aSo = {-16842912, 16842910, 16842919};
    private int aSA;
    private int aSB;
    private int aSC;
    private int aSD;
    private int aSE;
    private int aSF;
    private int aSG;
    private int aSH;
    private Drawable aSI;
    private Drawable aSJ;
    private RectF aSK;
    private RectF aSL;
    private RectF aSM;
    private RectF aSN;
    private RectF aSO;
    private Paint aSP;
    private boolean aSQ;
    private boolean aSR;
    private boolean aSS;
    private ObjectAnimator aST;
    private float aSU;
    private RectF aSV;
    private float aSW;
    private float aSX;
    private float aSY;
    private int aSZ;
    private Drawable aSp;
    private Drawable aSq;
    private ColorStateList aSr;
    private ColorStateList aSs;
    private float aSt;
    private float aSu;
    private RectF aSv;
    private float aSw;
    private long aSx;
    private int aSy;
    private int aSz;
    private int aTa;
    private Paint aTb;
    private CharSequence aTc;
    private CharSequence aTd;
    private TextPaint aTe;
    private Layout aTf;
    private Layout aTg;
    private float aTh;
    private float aTi;
    private int aTj;
    private int aTk;
    private int aTl;
    private boolean aTm;
    private boolean aTn;
    private boolean aTo;
    private CompoundButton.OnCheckedChangeListener aTp;
    private boolean ab;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes11.dex */
    public static class a extends View.BaseSavedState {
        public static final Parcelable.Creator<a> CREATOR = new C0165a();
        CharSequence aTq;
        CharSequence aTr;

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
            TextUtils.writeToParcel(this.aTq, parcel, i);
            TextUtils.writeToParcel(this.aTr, parcel, i);
        }

        a(Parcelable parcelable) {
            super(parcelable);
        }

        private a(Parcel parcel) {
            super(parcel);
            this.aTq = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
            this.aTr = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
        }
    }

    public SwitchButton(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.aSS = false;
        this.aTm = false;
        this.aTn = false;
        this.aTo = false;
        c(attributeSet);
    }

    private void R() {
        ViewParent parent = getParent();
        if (parent != null) {
            parent.requestDisallowInterceptTouchEvent(true);
        }
        this.aTo = true;
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
        this.aSZ = ViewConfiguration.get(getContext()).getScaledTouchSlop();
        this.aTa = ViewConfiguration.getPressedStateDuration() + ViewConfiguration.getTapTimeout();
        this.aSP = new Paint(1);
        this.aTb = new Paint(1);
        this.aTb.setStyle(Paint.Style.STROKE);
        this.aTb.setStrokeWidth(getResources().getDisplayMetrics().density);
        this.aTe = getPaint();
        this.aSK = new RectF();
        this.aSL = new RectF();
        this.aSM = new RectF();
        this.aSv = new RectF();
        this.aSN = new RectF();
        this.aSO = new RectF();
        this.aST = ObjectAnimator.ofFloat(this, "progress", 0.0f, 0.0f).setDuration(250L);
        this.aST.setInterpolator(new AccelerateDecelerateInterpolator());
        this.aSV = new RectF();
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
        this.aTc = str2;
        this.aTd = str;
        this.aTj = i4;
        this.aTk = i3;
        this.aTl = i5;
        this.aSp = drawable;
        this.aSs = colorStateList;
        this.aSQ = this.aSp != null;
        this.aSy = i2;
        if (this.aSy == 0) {
            new TypedValue();
            this.aSy = 3309506;
        }
        if (!this.aSQ && this.aSs == null) {
            this.aSs = com.baidu.poly.widget.b.dA(this.aSy);
            this.aSD = this.aSs.getDefaultColor();
        }
        this.aSz = e(f5);
        this.aSA = e(f6);
        this.aSq = drawable2;
        this.aSr = colorStateList2;
        this.aSR = this.aSq != null;
        if (!this.aSR && this.aSr == null) {
            this.aSr = com.baidu.poly.widget.b.dB(this.aSy);
            this.aSE = this.aSr.getDefaultColor();
            this.aSF = this.aSr.getColorForState(aSn, this.aSE);
        }
        this.aSv.set(f, f3, f2, f4);
        this.aSw = this.aSv.width() >= 0.0f ? Math.max(f9, 1.0f) : f9;
        this.aSt = f7;
        this.aSu = f8;
        this.aSx = i;
        this.ab = z;
        this.aST.setDuration(this.aSx);
        if (isChecked()) {
            setProgress(1.0f);
        }
    }

    private int dy(int i) {
        int i2;
        int size = View.MeasureSpec.getSize(i);
        int mode = View.MeasureSpec.getMode(i);
        if (this.aSz == 0 && this.aSQ) {
            this.aSz = this.aSp.getIntrinsicWidth();
        }
        int e = e(this.aTh);
        if (this.aSw == 0.0f) {
            this.aSw = 1.8f;
        }
        if (mode == 1073741824) {
            int paddingLeft = (size - getPaddingLeft()) - getPaddingRight();
            if (this.aSz != 0) {
                int e2 = e(i2 * this.aSw);
                RectF rectF = this.aSv;
                int e3 = (this.aTk + e) - ((e2 - this.aSz) + e(Math.max(rectF.left, rectF.right)));
                float f = e2;
                RectF rectF2 = this.aSv;
                this.aSB = e(rectF2.right + rectF2.left + f + Math.max(e3, 0));
                if (this.aSB < 0) {
                    this.aSz = 0;
                }
                if (f + Math.max(this.aSv.left, 0.0f) + Math.max(this.aSv.right, 0.0f) + Math.max(e3, 0) > paddingLeft) {
                    this.aSz = 0;
                }
            }
            if (this.aSz == 0) {
                int e4 = e((((size - getPaddingLeft()) - getPaddingRight()) - Math.max(this.aSv.left, 0.0f)) - Math.max(this.aSv.right, 0.0f));
                if (e4 < 0) {
                    this.aSz = 0;
                    this.aSB = 0;
                    return size;
                }
                float f2 = e4;
                this.aSz = e(f2 / this.aSw);
                RectF rectF3 = this.aSv;
                this.aSB = e(f2 + rectF3.left + rectF3.right);
                if (this.aSB < 0) {
                    this.aSz = 0;
                    this.aSB = 0;
                    return size;
                }
                int i3 = e + this.aTk;
                int i4 = e4 - this.aSz;
                RectF rectF4 = this.aSv;
                int e5 = i3 - (i4 + e(Math.max(rectF4.left, rectF4.right)));
                if (e5 > 0) {
                    this.aSz -= e5;
                }
                if (this.aSz < 0) {
                    this.aSz = 0;
                    this.aSB = 0;
                    return size;
                }
                return size;
            }
            return size;
        }
        if (this.aSz == 0) {
            this.aSz = e(getResources().getDisplayMetrics().density * 20.0f);
        }
        if (this.aSw == 0.0f) {
            this.aSw = 1.8f;
        }
        int e6 = e(this.aSz * this.aSw);
        RectF rectF5 = this.aSv;
        int e7 = e((e + this.aTk) - (((e6 - this.aSz) + Math.max(rectF5.left, rectF5.right)) + this.aTj));
        float f3 = e6;
        RectF rectF6 = this.aSv;
        this.aSB = e(rectF6.right + rectF6.left + f3 + Math.max(0, e7));
        if (this.aSB < 0) {
            this.aSz = 0;
            this.aSB = 0;
            return size;
        }
        int e8 = e(Math.max(0.0f, this.aSv.left) + f3 + Math.max(0.0f, this.aSv.right) + Math.max(0, e7));
        return Math.max(e8, getPaddingLeft() + e8 + getPaddingRight());
    }

    private int e(double d) {
        return (int) Math.ceil(d);
    }

    private float getProgress() {
        return this.aSU;
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
        if (this.aSA == 0 && this.aSQ) {
            this.aSA = this.aSp.getIntrinsicHeight();
        }
        if (mode == 1073741824) {
            if (this.aSA != 0) {
                RectF rectF = this.aSv;
                this.aSC = e(i3 + rectF.top + rectF.bottom);
                this.aSC = e(Math.max(this.aSC, this.aTi));
                if ((((this.aSC + getPaddingTop()) + getPaddingBottom()) - Math.min(0.0f, this.aSv.top)) - Math.min(0.0f, this.aSv.bottom) > size) {
                    this.aSA = 0;
                }
            }
            if (this.aSA == 0) {
                this.aSC = e(((size - getPaddingTop()) - getPaddingBottom()) + Math.min(0.0f, this.aSv.top) + Math.min(0.0f, this.aSv.bottom));
                if (this.aSC < 0) {
                    this.aSC = 0;
                    this.aSA = 0;
                    return size;
                }
                RectF rectF2 = this.aSv;
                this.aSA = e((i4 - rectF2.top) - rectF2.bottom);
            }
            if (this.aSA < 0) {
                this.aSC = 0;
                this.aSA = 0;
                return size;
            }
            return size;
        }
        if (this.aSA == 0) {
            this.aSA = e(getResources().getDisplayMetrics().density * 20.0f);
        }
        RectF rectF3 = this.aSv;
        this.aSC = e(this.aSA + rectF3.top + rectF3.bottom);
        if (this.aSC < 0) {
            this.aSC = 0;
            this.aSA = 0;
            return size;
        }
        int e = e(this.aTi - i2);
        if (e > 0) {
            this.aSC += e;
            this.aSA = e + this.aSA;
        }
        int max = Math.max(this.aSA, this.aSC);
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
        this.aSU = f;
        invalidate();
    }

    private void setup() {
        int i;
        float paddingTop;
        float paddingLeft;
        int i2 = this.aSz;
        if (i2 != 0 && (i = this.aSA) != 0 && this.aSB != 0 && this.aSC != 0) {
            if (this.aSt == -1.0f) {
                this.aSt = Math.min(i2, i) / 2;
            }
            if (this.aSu == -1.0f) {
                this.aSu = Math.min(this.aSB, this.aSC) / 2;
            }
            int measuredWidth = (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight();
            int measuredHeight = (getMeasuredHeight() - getPaddingTop()) - getPaddingBottom();
            int e = e((this.aSB - Math.min(0.0f, this.aSv.left)) - Math.min(0.0f, this.aSv.right));
            int e2 = e((this.aSC - Math.min(0.0f, this.aSv.top)) - Math.min(0.0f, this.aSv.bottom));
            if (measuredHeight <= e2) {
                paddingTop = getPaddingTop() + Math.max(0.0f, this.aSv.top);
            } else {
                paddingTop = (((measuredHeight - e2) + 1) / 2) + getPaddingTop() + Math.max(0.0f, this.aSv.top);
            }
            if (measuredWidth <= this.aSB) {
                paddingLeft = getPaddingLeft() + Math.max(0.0f, this.aSv.left);
            } else {
                paddingLeft = (((measuredWidth - e) + 1) / 2) + getPaddingLeft() + Math.max(0.0f, this.aSv.left);
            }
            this.aSK.set(paddingLeft, paddingTop, this.aSz + paddingLeft, this.aSA + paddingTop);
            RectF rectF = this.aSK;
            float f = rectF.left;
            RectF rectF2 = this.aSv;
            float f2 = f - rectF2.left;
            RectF rectF3 = this.aSL;
            float f3 = rectF.top;
            float f4 = rectF2.top;
            rectF3.set(f2, f3 - f4, this.aSB + f2, (f3 - f4) + this.aSC);
            RectF rectF4 = this.aSM;
            RectF rectF5 = this.aSK;
            rectF4.set(rectF5.left, 0.0f, (this.aSL.right - this.aSv.right) - rectF5.width(), 0.0f);
            this.aSu = Math.min(Math.min(this.aSL.width(), this.aSL.height()) / 2.0f, this.aSu);
            Drawable drawable = this.aSq;
            if (drawable != null) {
                RectF rectF6 = this.aSL;
                drawable.setBounds((int) rectF6.left, (int) rectF6.top, e(rectF6.right), e(this.aSL.bottom));
            }
            if (this.aTf != null) {
                RectF rectF7 = this.aSL;
                float width = ((((((rectF7.width() + this.aTj) - this.aSz) - this.aSv.right) - this.aTf.getWidth()) / 2.0f) + rectF7.left) - this.aTl;
                RectF rectF8 = this.aSL;
                float height = ((rectF8.height() - this.aTf.getHeight()) / 2.0f) + rectF8.top;
                this.aSN.set(width, height, this.aTf.getWidth() + width, this.aTf.getHeight() + height);
            }
            if (this.aTg != null) {
                RectF rectF9 = this.aSL;
                float width2 = ((rectF9.right - (((((rectF9.width() + this.aTj) - this.aSz) - this.aSv.left) - this.aTg.getWidth()) / 2.0f)) - this.aTg.getWidth()) + this.aTl;
                RectF rectF10 = this.aSL;
                float height2 = ((rectF10.height() - this.aTg.getHeight()) / 2.0f) + rectF10.top;
                this.aSO.set(width2, height2, this.aTg.getWidth() + width2, this.aTg.getHeight() + height2);
            }
            this.aTn = true;
        }
    }

    protected void b(boolean z) {
        ObjectAnimator objectAnimator = this.aST;
        if (objectAnimator != null) {
            if (objectAnimator.isRunning()) {
                this.aST.cancel();
            }
            this.aST.setDuration(this.aSx);
            if (z) {
                this.aST.setFloatValues(this.aSU, 1.0f);
            } else {
                this.aST.setFloatValues(this.aSU, 0.0f);
            }
            this.aST.start();
        }
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    protected void drawableStateChanged() {
        ColorStateList colorStateList;
        ColorStateList colorStateList2;
        super.drawableStateChanged();
        if (!this.aSQ && (colorStateList2 = this.aSs) != null) {
            this.aSD = colorStateList2.getColorForState(getDrawableState(), this.aSD);
        } else {
            setDrawableState(this.aSp);
        }
        int[] iArr = isChecked() ? aSo : aSn;
        ColorStateList textColors = getTextColors();
        if (textColors != null) {
            int defaultColor = textColors.getDefaultColor();
            this.aSG = textColors.getColorForState(aSn, defaultColor);
            this.aSH = textColors.getColorForState(aSo, defaultColor);
        }
        if (!this.aSR && (colorStateList = this.aSr) != null) {
            this.aSE = colorStateList.getColorForState(getDrawableState(), this.aSE);
            this.aSF = this.aSr.getColorForState(iArr, this.aSE);
            return;
        }
        Drawable drawable = this.aSq;
        if ((drawable instanceof StateListDrawable) && this.ab) {
            drawable.setState(iArr);
            this.aSJ = this.aSq.getCurrent().mutate();
        } else {
            this.aSJ = null;
        }
        setDrawableState(this.aSq);
        Drawable drawable2 = this.aSq;
        if (drawable2 != null) {
            this.aSI = drawable2.getCurrent().mutate();
        }
    }

    public void g() {
        if (this.aTp == null) {
            toggle();
            return;
        }
        super.setOnCheckedChangeListener(null);
        toggle();
        super.setOnCheckedChangeListener(this.aTp);
    }

    public long getAnimationDuration() {
        return this.aSx;
    }

    public ColorStateList getBackColor() {
        return this.aSr;
    }

    public Drawable getBackDrawable() {
        return this.aSq;
    }

    public float getBackRadius() {
        return this.aSu;
    }

    public PointF getBackSizeF() {
        return new PointF(this.aSL.width(), this.aSL.height());
    }

    public CharSequence getTextOff() {
        return this.aTd;
    }

    public CharSequence getTextOn() {
        return this.aTc;
    }

    public ColorStateList getThumbColor() {
        return this.aSs;
    }

    public Drawable getThumbDrawable() {
        return this.aSp;
    }

    public float getThumbHeight() {
        return this.aSA;
    }

    public RectF getThumbMargin() {
        return this.aSv;
    }

    public float getThumbRadius() {
        return this.aSt;
    }

    public float getThumbRangeRatio() {
        return this.aSw;
    }

    public float getThumbWidth() {
        return this.aSz;
    }

    public int getTintColor() {
        return this.aSy;
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    protected void onDraw(Canvas canvas) {
        float progress;
        super.onDraw(canvas);
        if (!this.aTn) {
            setup();
        }
        if (this.aTn) {
            if (this.aSR) {
                if (this.ab && this.aSI != null && this.aSJ != null) {
                    Drawable drawable = isChecked() ? this.aSI : this.aSJ;
                    Drawable drawable2 = isChecked() ? this.aSJ : this.aSI;
                    int progress2 = (int) (getProgress() * 255.0f);
                    drawable.setAlpha(progress2);
                    drawable.draw(canvas);
                    drawable2.setAlpha(255 - progress2);
                    drawable2.draw(canvas);
                } else {
                    this.aSq.setAlpha(255);
                    this.aSq.draw(canvas);
                }
            } else if (this.ab) {
                int i = isChecked() ? this.aSE : this.aSF;
                int i2 = isChecked() ? this.aSF : this.aSE;
                int progress3 = (int) (getProgress() * 255.0f);
                this.aSP.setARGB((Color.alpha(i) * progress3) / 255, Color.red(i), Color.green(i), Color.blue(i));
                RectF rectF = this.aSL;
                float f = this.aSu;
                canvas.drawRoundRect(rectF, f, f, this.aSP);
                this.aSP.setARGB(((255 - progress3) * Color.alpha(i2)) / 255, Color.red(i2), Color.green(i2), Color.blue(i2));
                RectF rectF2 = this.aSL;
                float f2 = this.aSu;
                canvas.drawRoundRect(rectF2, f2, f2, this.aSP);
                this.aSP.setAlpha(255);
            } else {
                this.aSP.setColor(this.aSE);
                RectF rectF3 = this.aSL;
                float f3 = this.aSu;
                canvas.drawRoundRect(rectF3, f3, f3, this.aSP);
            }
            Layout layout = ((double) getProgress()) > 0.5d ? this.aTf : this.aTg;
            RectF rectF4 = ((double) getProgress()) > 0.5d ? this.aSN : this.aSO;
            if (layout != null && rectF4 != null) {
                if (getProgress() >= 0.75d) {
                    progress = (getProgress() * 4.0f) - 3.0f;
                } else {
                    progress = ((double) getProgress()) < 0.25d ? 1.0f - (getProgress() * 4.0f) : 0.0f;
                }
                int i3 = (int) (progress * 255.0f);
                int i4 = ((double) getProgress()) > 0.5d ? this.aSG : this.aSH;
                layout.getPaint().setARGB((i3 * Color.alpha(i4)) / 255, Color.red(i4), Color.green(i4), Color.blue(i4));
                canvas.save();
                canvas.translate(rectF4.left, rectF4.top);
                layout.draw(canvas);
                canvas.restore();
            }
            this.aSV.set(this.aSK);
            this.aSV.offset(this.aSU * this.aSM.width(), 0.0f);
            if (this.aSQ) {
                Drawable drawable3 = this.aSp;
                RectF rectF5 = this.aSV;
                drawable3.setBounds((int) rectF5.left, (int) rectF5.top, e(rectF5.right), e(this.aSV.bottom));
                this.aSp.draw(canvas);
            } else {
                this.aSP.setColor(this.aSD);
                RectF rectF6 = this.aSV;
                float f4 = this.aSt;
                canvas.drawRoundRect(rectF6, f4, f4, this.aSP);
            }
            if (this.aSS) {
                this.aTb.setColor(Color.parseColor("#AA0000"));
                canvas.drawRect(this.aSL, this.aTb);
                this.aTb.setColor(Color.parseColor("#0000FF"));
                canvas.drawRect(this.aSV, this.aTb);
                this.aTb.setColor(Color.parseColor(BaseBrowseView.ROOT_VIEW_COLOR));
                RectF rectF7 = this.aSM;
                float f5 = rectF7.left;
                float f6 = this.aSK.top;
                canvas.drawLine(f5, f6, rectF7.right, f6, this.aTb);
                this.aTb.setColor(Color.parseColor("#00CC00"));
                canvas.drawRect(((double) getProgress()) > 0.5d ? this.aSN : this.aSO, this.aTb);
            }
        }
    }

    @Override // android.widget.TextView, android.view.View
    protected void onMeasure(int i, int i2) {
        if (this.aTf == null && !TextUtils.isEmpty(this.aTc)) {
            this.aTf = d(this.aTc);
        }
        if (this.aTg == null && !TextUtils.isEmpty(this.aTd)) {
            this.aTg = d(this.aTd);
        }
        Layout layout = this.aTf;
        float width = layout != null ? layout.getWidth() : 0.0f;
        Layout layout2 = this.aTg;
        float width2 = layout2 != null ? layout2.getWidth() : 0.0f;
        if (width == 0.0f && width2 == 0.0f) {
            this.aTh = 0.0f;
        } else {
            this.aTh = Math.max(width, width2);
        }
        Layout layout3 = this.aTf;
        float height = layout3 != null ? layout3.getHeight() : 0.0f;
        Layout layout4 = this.aTg;
        float height2 = layout4 != null ? layout4.getHeight() : 0.0f;
        if (height == 0.0f && height2 == 0.0f) {
            this.aTi = 0.0f;
        } else {
            this.aTi = Math.max(height, height2);
        }
        setMeasuredDimension(dy(i), i(i2));
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        a aVar = (a) parcelable;
        a(aVar.aTq, aVar.aTr);
        this.aTm = true;
        super.onRestoreInstanceState(aVar.getSuperState());
        this.aTm = false;
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    public Parcelable onSaveInstanceState() {
        a aVar = new a(super.onSaveInstanceState());
        aVar.aTq = this.aTc;
        aVar.aTr = this.aTd;
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
        if (isEnabled() && isClickable() && isFocusable() && this.aTn) {
            int action = motionEvent.getAction();
            float x = motionEvent.getX() - this.aSW;
            float y = motionEvent.getY() - this.aSX;
            switch (action) {
                case 0:
                    this.aSW = motionEvent.getX();
                    this.aSX = motionEvent.getY();
                    this.aSY = this.aSW;
                    setPressed(true);
                    break;
                case 1:
                case 3:
                    this.aTo = false;
                    setPressed(false);
                    float eventTime = (float) (motionEvent.getEventTime() - motionEvent.getDownTime());
                    if (Math.abs(x) < this.aSZ && Math.abs(y) < this.aSZ && eventTime < this.aTa) {
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
                    setProgress(getProgress() + ((x2 - this.aSY) / this.aSM.width()));
                    if (!this.aTo && (Math.abs(x) > this.aSZ / 2 || Math.abs(y) > this.aSZ / 2)) {
                        if (y != 0.0f && Math.abs(x) <= Math.abs(y)) {
                            if (Math.abs(y) > Math.abs(x)) {
                                return false;
                            }
                        } else {
                            R();
                        }
                    }
                    this.aSY = x2;
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
        this.aSx = j;
    }

    public void setBackColor(ColorStateList colorStateList) {
        this.aSr = colorStateList;
        if (this.aSr != null) {
            setBackDrawable(null);
        }
        invalidate();
    }

    public void setBackColorRes(int i) {
        setBackColor(getResources().getColorStateList(i));
    }

    public void setBackDrawable(Drawable drawable) {
        this.aSq = drawable;
        this.aSR = this.aSq != null;
        refreshDrawableState();
        this.aTn = false;
        requestLayout();
        invalidate();
    }

    public void setBackDrawableRes(int i) {
        setBackDrawable(getResources().getDrawable(i));
    }

    public void setBackRadius(float f) {
        this.aSu = f;
        if (this.aSR) {
            return;
        }
        invalidate();
    }

    @Override // android.widget.CompoundButton, android.widget.Checkable
    public void setChecked(boolean z) {
        if (isChecked() != z) {
            b(z);
        }
        if (this.aTm) {
            setCheckedImmediatelyNoEvent(z);
        } else {
            super.setChecked(z);
        }
    }

    public void setCheckedImmediately(boolean z) {
        super.setChecked(z);
        ObjectAnimator objectAnimator = this.aST;
        if (objectAnimator != null && objectAnimator.isRunning()) {
            this.aST.cancel();
        }
        setProgress(z ? 1.0f : 0.0f);
        invalidate();
    }

    public void setCheckedImmediatelyNoEvent(boolean z) {
        if (this.aTp == null) {
            setCheckedImmediately(z);
            return;
        }
        super.setOnCheckedChangeListener(null);
        setCheckedImmediately(z);
        super.setOnCheckedChangeListener(this.aTp);
    }

    public void setCheckedNoEvent(boolean z) {
        if (this.aTp == null) {
            setChecked(z);
            return;
        }
        super.setOnCheckedChangeListener(null);
        setChecked(z);
        super.setOnCheckedChangeListener(this.aTp);
    }

    public void setDrawDebugRect(boolean z) {
        this.aSS = z;
        invalidate();
    }

    public void setFadeBack(boolean z) {
        this.ab = z;
    }

    @Override // android.widget.CompoundButton
    public void setOnCheckedChangeListener(CompoundButton.OnCheckedChangeListener onCheckedChangeListener) {
        super.setOnCheckedChangeListener(onCheckedChangeListener);
        this.aTp = onCheckedChangeListener;
    }

    public void setTextAdjust(int i) {
        this.aTl = i;
        this.aTn = false;
        requestLayout();
        invalidate();
    }

    public void setTextExtra(int i) {
        this.aTk = i;
        this.aTn = false;
        requestLayout();
        invalidate();
    }

    public void setTextThumbInset(int i) {
        this.aTj = i;
        this.aTn = false;
        requestLayout();
        invalidate();
    }

    public void setThumbColor(ColorStateList colorStateList) {
        this.aSs = colorStateList;
        if (this.aSs != null) {
            setThumbDrawable(null);
        }
        invalidate();
    }

    public void setThumbColorRes(int i) {
        setThumbColor(getResources().getColorStateList(i));
    }

    public void setThumbDrawable(Drawable drawable) {
        this.aSp = drawable;
        this.aSQ = this.aSp != null;
        refreshDrawableState();
        this.aTn = false;
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
        this.aSt = f;
        if (this.aSQ) {
            return;
        }
        invalidate();
    }

    public void setThumbRangeRatio(float f) {
        this.aSw = f;
        this.aTn = false;
        requestLayout();
    }

    public void setTintColor(int i) {
        this.aSy = i;
        this.aSs = com.baidu.poly.widget.b.dA(this.aSy);
        this.aSr = com.baidu.poly.widget.b.dB(this.aSy);
        this.aSR = false;
        this.aSQ = false;
        refreshDrawableState();
        invalidate();
    }

    public SwitchButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aSS = false;
        this.aTm = false;
        this.aTn = false;
        this.aTo = false;
        c(attributeSet);
    }

    public SwitchButton(Context context) {
        super(context);
        this.aSS = false;
        this.aTm = false;
        this.aTn = false;
        this.aTo = false;
        c(null);
    }

    private Layout d(CharSequence charSequence) {
        TextPaint textPaint = this.aTe;
        return new StaticLayout(charSequence, textPaint, (int) Math.ceil(Layout.getDesiredWidth(charSequence, textPaint)), Layout.Alignment.ALIGN_CENTER, 1.0f, 0.0f, false);
    }

    public void a(float f, float f2, float f3, float f4) {
        this.aSv.set(f, f2, f3, f4);
        this.aTn = false;
        requestLayout();
    }

    public void a(CharSequence charSequence, CharSequence charSequence2) {
        this.aTc = charSequence;
        this.aTd = charSequence2;
        this.aTf = null;
        this.aTg = null;
        this.aTn = false;
        requestLayout();
        invalidate();
    }
}
