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
    private static int[] aSm = {16842912, 16842910, 16842919};
    private static int[] aSn = {-16842912, 16842910, 16842919};
    private int aSA;
    private int aSB;
    private int aSC;
    private int aSD;
    private int aSE;
    private int aSF;
    private int aSG;
    private Drawable aSH;
    private Drawable aSI;
    private RectF aSJ;
    private RectF aSK;
    private RectF aSL;
    private RectF aSM;
    private RectF aSN;
    private Paint aSO;
    private boolean aSP;
    private boolean aSQ;
    private boolean aSR;
    private ObjectAnimator aSS;
    private float aST;
    private RectF aSU;
    private float aSV;
    private float aSW;
    private float aSX;
    private int aSY;
    private int aSZ;
    private Drawable aSo;
    private Drawable aSp;
    private ColorStateList aSq;
    private ColorStateList aSr;
    private float aSs;
    private float aSt;
    private RectF aSu;
    private float aSv;
    private long aSw;
    private int aSx;
    private int aSy;
    private int aSz;
    private Paint aTa;
    private CharSequence aTb;
    private CharSequence aTc;
    private TextPaint aTd;
    private Layout aTe;
    private Layout aTf;
    private float aTg;
    private float aTh;
    private int aTi;
    private int aTj;
    private int aTk;
    private boolean aTl;
    private boolean aTm;
    private boolean aTn;
    private CompoundButton.OnCheckedChangeListener aTo;
    private boolean ab;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes11.dex */
    public static class a extends View.BaseSavedState {
        public static final Parcelable.Creator<a> CREATOR = new C0165a();
        CharSequence aTp;
        CharSequence aTq;

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
            TextUtils.writeToParcel(this.aTp, parcel, i);
            TextUtils.writeToParcel(this.aTq, parcel, i);
        }

        a(Parcelable parcelable) {
            super(parcelable);
        }

        private a(Parcel parcel) {
            super(parcel);
            this.aTp = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
            this.aTq = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
        }
    }

    public SwitchButton(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.aSR = false;
        this.aTl = false;
        this.aTm = false;
        this.aTn = false;
        c(attributeSet);
    }

    private void R() {
        ViewParent parent = getParent();
        if (parent != null) {
            parent.requestDisallowInterceptTouchEvent(true);
        }
        this.aTn = true;
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
        this.aSY = ViewConfiguration.get(getContext()).getScaledTouchSlop();
        this.aSZ = ViewConfiguration.getPressedStateDuration() + ViewConfiguration.getTapTimeout();
        this.aSO = new Paint(1);
        this.aTa = new Paint(1);
        this.aTa.setStyle(Paint.Style.STROKE);
        this.aTa.setStrokeWidth(getResources().getDisplayMetrics().density);
        this.aTd = getPaint();
        this.aSJ = new RectF();
        this.aSK = new RectF();
        this.aSL = new RectF();
        this.aSu = new RectF();
        this.aSM = new RectF();
        this.aSN = new RectF();
        this.aSS = ObjectAnimator.ofFloat(this, "progress", 0.0f, 0.0f).setDuration(250L);
        this.aSS.setInterpolator(new AccelerateDecelerateInterpolator());
        this.aSU = new RectF();
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
        this.aTb = str2;
        this.aTc = str;
        this.aTi = i4;
        this.aTj = i3;
        this.aTk = i5;
        this.aSo = drawable;
        this.aSr = colorStateList;
        this.aSP = this.aSo != null;
        this.aSx = i2;
        if (this.aSx == 0) {
            new TypedValue();
            this.aSx = 3309506;
        }
        if (!this.aSP && this.aSr == null) {
            this.aSr = com.baidu.poly.widget.b.dA(this.aSx);
            this.aSC = this.aSr.getDefaultColor();
        }
        this.aSy = e(f5);
        this.aSz = e(f6);
        this.aSp = drawable2;
        this.aSq = colorStateList2;
        this.aSQ = this.aSp != null;
        if (!this.aSQ && this.aSq == null) {
            this.aSq = com.baidu.poly.widget.b.dB(this.aSx);
            this.aSD = this.aSq.getDefaultColor();
            this.aSE = this.aSq.getColorForState(aSm, this.aSD);
        }
        this.aSu.set(f, f3, f2, f4);
        this.aSv = this.aSu.width() >= 0.0f ? Math.max(f9, 1.0f) : f9;
        this.aSs = f7;
        this.aSt = f8;
        this.aSw = i;
        this.ab = z;
        this.aSS.setDuration(this.aSw);
        if (isChecked()) {
            setProgress(1.0f);
        }
    }

    private int dy(int i) {
        int i2;
        int size = View.MeasureSpec.getSize(i);
        int mode = View.MeasureSpec.getMode(i);
        if (this.aSy == 0 && this.aSP) {
            this.aSy = this.aSo.getIntrinsicWidth();
        }
        int e = e(this.aTg);
        if (this.aSv == 0.0f) {
            this.aSv = 1.8f;
        }
        if (mode == 1073741824) {
            int paddingLeft = (size - getPaddingLeft()) - getPaddingRight();
            if (this.aSy != 0) {
                int e2 = e(i2 * this.aSv);
                RectF rectF = this.aSu;
                int e3 = (this.aTj + e) - ((e2 - this.aSy) + e(Math.max(rectF.left, rectF.right)));
                float f = e2;
                RectF rectF2 = this.aSu;
                this.aSA = e(rectF2.right + rectF2.left + f + Math.max(e3, 0));
                if (this.aSA < 0) {
                    this.aSy = 0;
                }
                if (f + Math.max(this.aSu.left, 0.0f) + Math.max(this.aSu.right, 0.0f) + Math.max(e3, 0) > paddingLeft) {
                    this.aSy = 0;
                }
            }
            if (this.aSy == 0) {
                int e4 = e((((size - getPaddingLeft()) - getPaddingRight()) - Math.max(this.aSu.left, 0.0f)) - Math.max(this.aSu.right, 0.0f));
                if (e4 < 0) {
                    this.aSy = 0;
                    this.aSA = 0;
                    return size;
                }
                float f2 = e4;
                this.aSy = e(f2 / this.aSv);
                RectF rectF3 = this.aSu;
                this.aSA = e(f2 + rectF3.left + rectF3.right);
                if (this.aSA < 0) {
                    this.aSy = 0;
                    this.aSA = 0;
                    return size;
                }
                int i3 = e + this.aTj;
                int i4 = e4 - this.aSy;
                RectF rectF4 = this.aSu;
                int e5 = i3 - (i4 + e(Math.max(rectF4.left, rectF4.right)));
                if (e5 > 0) {
                    this.aSy -= e5;
                }
                if (this.aSy < 0) {
                    this.aSy = 0;
                    this.aSA = 0;
                    return size;
                }
                return size;
            }
            return size;
        }
        if (this.aSy == 0) {
            this.aSy = e(getResources().getDisplayMetrics().density * 20.0f);
        }
        if (this.aSv == 0.0f) {
            this.aSv = 1.8f;
        }
        int e6 = e(this.aSy * this.aSv);
        RectF rectF5 = this.aSu;
        int e7 = e((e + this.aTj) - (((e6 - this.aSy) + Math.max(rectF5.left, rectF5.right)) + this.aTi));
        float f3 = e6;
        RectF rectF6 = this.aSu;
        this.aSA = e(rectF6.right + rectF6.left + f3 + Math.max(0, e7));
        if (this.aSA < 0) {
            this.aSy = 0;
            this.aSA = 0;
            return size;
        }
        int e8 = e(Math.max(0.0f, this.aSu.left) + f3 + Math.max(0.0f, this.aSu.right) + Math.max(0, e7));
        return Math.max(e8, getPaddingLeft() + e8 + getPaddingRight());
    }

    private int e(double d) {
        return (int) Math.ceil(d);
    }

    private float getProgress() {
        return this.aST;
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
        if (this.aSz == 0 && this.aSP) {
            this.aSz = this.aSo.getIntrinsicHeight();
        }
        if (mode == 1073741824) {
            if (this.aSz != 0) {
                RectF rectF = this.aSu;
                this.aSB = e(i3 + rectF.top + rectF.bottom);
                this.aSB = e(Math.max(this.aSB, this.aTh));
                if ((((this.aSB + getPaddingTop()) + getPaddingBottom()) - Math.min(0.0f, this.aSu.top)) - Math.min(0.0f, this.aSu.bottom) > size) {
                    this.aSz = 0;
                }
            }
            if (this.aSz == 0) {
                this.aSB = e(((size - getPaddingTop()) - getPaddingBottom()) + Math.min(0.0f, this.aSu.top) + Math.min(0.0f, this.aSu.bottom));
                if (this.aSB < 0) {
                    this.aSB = 0;
                    this.aSz = 0;
                    return size;
                }
                RectF rectF2 = this.aSu;
                this.aSz = e((i4 - rectF2.top) - rectF2.bottom);
            }
            if (this.aSz < 0) {
                this.aSB = 0;
                this.aSz = 0;
                return size;
            }
            return size;
        }
        if (this.aSz == 0) {
            this.aSz = e(getResources().getDisplayMetrics().density * 20.0f);
        }
        RectF rectF3 = this.aSu;
        this.aSB = e(this.aSz + rectF3.top + rectF3.bottom);
        if (this.aSB < 0) {
            this.aSB = 0;
            this.aSz = 0;
            return size;
        }
        int e = e(this.aTh - i2);
        if (e > 0) {
            this.aSB += e;
            this.aSz = e + this.aSz;
        }
        int max = Math.max(this.aSz, this.aSB);
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
        this.aST = f;
        invalidate();
    }

    private void setup() {
        int i;
        float paddingTop;
        float paddingLeft;
        int i2 = this.aSy;
        if (i2 != 0 && (i = this.aSz) != 0 && this.aSA != 0 && this.aSB != 0) {
            if (this.aSs == -1.0f) {
                this.aSs = Math.min(i2, i) / 2;
            }
            if (this.aSt == -1.0f) {
                this.aSt = Math.min(this.aSA, this.aSB) / 2;
            }
            int measuredWidth = (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight();
            int measuredHeight = (getMeasuredHeight() - getPaddingTop()) - getPaddingBottom();
            int e = e((this.aSA - Math.min(0.0f, this.aSu.left)) - Math.min(0.0f, this.aSu.right));
            int e2 = e((this.aSB - Math.min(0.0f, this.aSu.top)) - Math.min(0.0f, this.aSu.bottom));
            if (measuredHeight <= e2) {
                paddingTop = getPaddingTop() + Math.max(0.0f, this.aSu.top);
            } else {
                paddingTop = (((measuredHeight - e2) + 1) / 2) + getPaddingTop() + Math.max(0.0f, this.aSu.top);
            }
            if (measuredWidth <= this.aSA) {
                paddingLeft = getPaddingLeft() + Math.max(0.0f, this.aSu.left);
            } else {
                paddingLeft = (((measuredWidth - e) + 1) / 2) + getPaddingLeft() + Math.max(0.0f, this.aSu.left);
            }
            this.aSJ.set(paddingLeft, paddingTop, this.aSy + paddingLeft, this.aSz + paddingTop);
            RectF rectF = this.aSJ;
            float f = rectF.left;
            RectF rectF2 = this.aSu;
            float f2 = f - rectF2.left;
            RectF rectF3 = this.aSK;
            float f3 = rectF.top;
            float f4 = rectF2.top;
            rectF3.set(f2, f3 - f4, this.aSA + f2, (f3 - f4) + this.aSB);
            RectF rectF4 = this.aSL;
            RectF rectF5 = this.aSJ;
            rectF4.set(rectF5.left, 0.0f, (this.aSK.right - this.aSu.right) - rectF5.width(), 0.0f);
            this.aSt = Math.min(Math.min(this.aSK.width(), this.aSK.height()) / 2.0f, this.aSt);
            Drawable drawable = this.aSp;
            if (drawable != null) {
                RectF rectF6 = this.aSK;
                drawable.setBounds((int) rectF6.left, (int) rectF6.top, e(rectF6.right), e(this.aSK.bottom));
            }
            if (this.aTe != null) {
                RectF rectF7 = this.aSK;
                float width = ((((((rectF7.width() + this.aTi) - this.aSy) - this.aSu.right) - this.aTe.getWidth()) / 2.0f) + rectF7.left) - this.aTk;
                RectF rectF8 = this.aSK;
                float height = ((rectF8.height() - this.aTe.getHeight()) / 2.0f) + rectF8.top;
                this.aSM.set(width, height, this.aTe.getWidth() + width, this.aTe.getHeight() + height);
            }
            if (this.aTf != null) {
                RectF rectF9 = this.aSK;
                float width2 = ((rectF9.right - (((((rectF9.width() + this.aTi) - this.aSy) - this.aSu.left) - this.aTf.getWidth()) / 2.0f)) - this.aTf.getWidth()) + this.aTk;
                RectF rectF10 = this.aSK;
                float height2 = ((rectF10.height() - this.aTf.getHeight()) / 2.0f) + rectF10.top;
                this.aSN.set(width2, height2, this.aTf.getWidth() + width2, this.aTf.getHeight() + height2);
            }
            this.aTm = true;
        }
    }

    protected void b(boolean z) {
        ObjectAnimator objectAnimator = this.aSS;
        if (objectAnimator != null) {
            if (objectAnimator.isRunning()) {
                this.aSS.cancel();
            }
            this.aSS.setDuration(this.aSw);
            if (z) {
                this.aSS.setFloatValues(this.aST, 1.0f);
            } else {
                this.aSS.setFloatValues(this.aST, 0.0f);
            }
            this.aSS.start();
        }
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    protected void drawableStateChanged() {
        ColorStateList colorStateList;
        ColorStateList colorStateList2;
        super.drawableStateChanged();
        if (!this.aSP && (colorStateList2 = this.aSr) != null) {
            this.aSC = colorStateList2.getColorForState(getDrawableState(), this.aSC);
        } else {
            setDrawableState(this.aSo);
        }
        int[] iArr = isChecked() ? aSn : aSm;
        ColorStateList textColors = getTextColors();
        if (textColors != null) {
            int defaultColor = textColors.getDefaultColor();
            this.aSF = textColors.getColorForState(aSm, defaultColor);
            this.aSG = textColors.getColorForState(aSn, defaultColor);
        }
        if (!this.aSQ && (colorStateList = this.aSq) != null) {
            this.aSD = colorStateList.getColorForState(getDrawableState(), this.aSD);
            this.aSE = this.aSq.getColorForState(iArr, this.aSD);
            return;
        }
        Drawable drawable = this.aSp;
        if ((drawable instanceof StateListDrawable) && this.ab) {
            drawable.setState(iArr);
            this.aSI = this.aSp.getCurrent().mutate();
        } else {
            this.aSI = null;
        }
        setDrawableState(this.aSp);
        Drawable drawable2 = this.aSp;
        if (drawable2 != null) {
            this.aSH = drawable2.getCurrent().mutate();
        }
    }

    public void g() {
        if (this.aTo == null) {
            toggle();
            return;
        }
        super.setOnCheckedChangeListener(null);
        toggle();
        super.setOnCheckedChangeListener(this.aTo);
    }

    public long getAnimationDuration() {
        return this.aSw;
    }

    public ColorStateList getBackColor() {
        return this.aSq;
    }

    public Drawable getBackDrawable() {
        return this.aSp;
    }

    public float getBackRadius() {
        return this.aSt;
    }

    public PointF getBackSizeF() {
        return new PointF(this.aSK.width(), this.aSK.height());
    }

    public CharSequence getTextOff() {
        return this.aTc;
    }

    public CharSequence getTextOn() {
        return this.aTb;
    }

    public ColorStateList getThumbColor() {
        return this.aSr;
    }

    public Drawable getThumbDrawable() {
        return this.aSo;
    }

    public float getThumbHeight() {
        return this.aSz;
    }

    public RectF getThumbMargin() {
        return this.aSu;
    }

    public float getThumbRadius() {
        return this.aSs;
    }

    public float getThumbRangeRatio() {
        return this.aSv;
    }

    public float getThumbWidth() {
        return this.aSy;
    }

    public int getTintColor() {
        return this.aSx;
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    protected void onDraw(Canvas canvas) {
        float progress;
        super.onDraw(canvas);
        if (!this.aTm) {
            setup();
        }
        if (this.aTm) {
            if (this.aSQ) {
                if (this.ab && this.aSH != null && this.aSI != null) {
                    Drawable drawable = isChecked() ? this.aSH : this.aSI;
                    Drawable drawable2 = isChecked() ? this.aSI : this.aSH;
                    int progress2 = (int) (getProgress() * 255.0f);
                    drawable.setAlpha(progress2);
                    drawable.draw(canvas);
                    drawable2.setAlpha(255 - progress2);
                    drawable2.draw(canvas);
                } else {
                    this.aSp.setAlpha(255);
                    this.aSp.draw(canvas);
                }
            } else if (this.ab) {
                int i = isChecked() ? this.aSD : this.aSE;
                int i2 = isChecked() ? this.aSE : this.aSD;
                int progress3 = (int) (getProgress() * 255.0f);
                this.aSO.setARGB((Color.alpha(i) * progress3) / 255, Color.red(i), Color.green(i), Color.blue(i));
                RectF rectF = this.aSK;
                float f = this.aSt;
                canvas.drawRoundRect(rectF, f, f, this.aSO);
                this.aSO.setARGB(((255 - progress3) * Color.alpha(i2)) / 255, Color.red(i2), Color.green(i2), Color.blue(i2));
                RectF rectF2 = this.aSK;
                float f2 = this.aSt;
                canvas.drawRoundRect(rectF2, f2, f2, this.aSO);
                this.aSO.setAlpha(255);
            } else {
                this.aSO.setColor(this.aSD);
                RectF rectF3 = this.aSK;
                float f3 = this.aSt;
                canvas.drawRoundRect(rectF3, f3, f3, this.aSO);
            }
            Layout layout = ((double) getProgress()) > 0.5d ? this.aTe : this.aTf;
            RectF rectF4 = ((double) getProgress()) > 0.5d ? this.aSM : this.aSN;
            if (layout != null && rectF4 != null) {
                if (getProgress() >= 0.75d) {
                    progress = (getProgress() * 4.0f) - 3.0f;
                } else {
                    progress = ((double) getProgress()) < 0.25d ? 1.0f - (getProgress() * 4.0f) : 0.0f;
                }
                int i3 = (int) (progress * 255.0f);
                int i4 = ((double) getProgress()) > 0.5d ? this.aSF : this.aSG;
                layout.getPaint().setARGB((i3 * Color.alpha(i4)) / 255, Color.red(i4), Color.green(i4), Color.blue(i4));
                canvas.save();
                canvas.translate(rectF4.left, rectF4.top);
                layout.draw(canvas);
                canvas.restore();
            }
            this.aSU.set(this.aSJ);
            this.aSU.offset(this.aST * this.aSL.width(), 0.0f);
            if (this.aSP) {
                Drawable drawable3 = this.aSo;
                RectF rectF5 = this.aSU;
                drawable3.setBounds((int) rectF5.left, (int) rectF5.top, e(rectF5.right), e(this.aSU.bottom));
                this.aSo.draw(canvas);
            } else {
                this.aSO.setColor(this.aSC);
                RectF rectF6 = this.aSU;
                float f4 = this.aSs;
                canvas.drawRoundRect(rectF6, f4, f4, this.aSO);
            }
            if (this.aSR) {
                this.aTa.setColor(Color.parseColor("#AA0000"));
                canvas.drawRect(this.aSK, this.aTa);
                this.aTa.setColor(Color.parseColor("#0000FF"));
                canvas.drawRect(this.aSU, this.aTa);
                this.aTa.setColor(Color.parseColor(BaseBrowseView.ROOT_VIEW_COLOR));
                RectF rectF7 = this.aSL;
                float f5 = rectF7.left;
                float f6 = this.aSJ.top;
                canvas.drawLine(f5, f6, rectF7.right, f6, this.aTa);
                this.aTa.setColor(Color.parseColor("#00CC00"));
                canvas.drawRect(((double) getProgress()) > 0.5d ? this.aSM : this.aSN, this.aTa);
            }
        }
    }

    @Override // android.widget.TextView, android.view.View
    protected void onMeasure(int i, int i2) {
        if (this.aTe == null && !TextUtils.isEmpty(this.aTb)) {
            this.aTe = d(this.aTb);
        }
        if (this.aTf == null && !TextUtils.isEmpty(this.aTc)) {
            this.aTf = d(this.aTc);
        }
        Layout layout = this.aTe;
        float width = layout != null ? layout.getWidth() : 0.0f;
        Layout layout2 = this.aTf;
        float width2 = layout2 != null ? layout2.getWidth() : 0.0f;
        if (width == 0.0f && width2 == 0.0f) {
            this.aTg = 0.0f;
        } else {
            this.aTg = Math.max(width, width2);
        }
        Layout layout3 = this.aTe;
        float height = layout3 != null ? layout3.getHeight() : 0.0f;
        Layout layout4 = this.aTf;
        float height2 = layout4 != null ? layout4.getHeight() : 0.0f;
        if (height == 0.0f && height2 == 0.0f) {
            this.aTh = 0.0f;
        } else {
            this.aTh = Math.max(height, height2);
        }
        setMeasuredDimension(dy(i), i(i2));
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        a aVar = (a) parcelable;
        a(aVar.aTp, aVar.aTq);
        this.aTl = true;
        super.onRestoreInstanceState(aVar.getSuperState());
        this.aTl = false;
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    public Parcelable onSaveInstanceState() {
        a aVar = new a(super.onSaveInstanceState());
        aVar.aTp = this.aTb;
        aVar.aTq = this.aTc;
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
        if (isEnabled() && isClickable() && isFocusable() && this.aTm) {
            int action = motionEvent.getAction();
            float x = motionEvent.getX() - this.aSV;
            float y = motionEvent.getY() - this.aSW;
            switch (action) {
                case 0:
                    this.aSV = motionEvent.getX();
                    this.aSW = motionEvent.getY();
                    this.aSX = this.aSV;
                    setPressed(true);
                    break;
                case 1:
                case 3:
                    this.aTn = false;
                    setPressed(false);
                    float eventTime = (float) (motionEvent.getEventTime() - motionEvent.getDownTime());
                    if (Math.abs(x) < this.aSY && Math.abs(y) < this.aSY && eventTime < this.aSZ) {
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
                    setProgress(getProgress() + ((x2 - this.aSX) / this.aSL.width()));
                    if (!this.aTn && (Math.abs(x) > this.aSY / 2 || Math.abs(y) > this.aSY / 2)) {
                        if (y != 0.0f && Math.abs(x) <= Math.abs(y)) {
                            if (Math.abs(y) > Math.abs(x)) {
                                return false;
                            }
                        } else {
                            R();
                        }
                    }
                    this.aSX = x2;
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
        this.aSw = j;
    }

    public void setBackColor(ColorStateList colorStateList) {
        this.aSq = colorStateList;
        if (this.aSq != null) {
            setBackDrawable(null);
        }
        invalidate();
    }

    public void setBackColorRes(int i) {
        setBackColor(getResources().getColorStateList(i));
    }

    public void setBackDrawable(Drawable drawable) {
        this.aSp = drawable;
        this.aSQ = this.aSp != null;
        refreshDrawableState();
        this.aTm = false;
        requestLayout();
        invalidate();
    }

    public void setBackDrawableRes(int i) {
        setBackDrawable(getResources().getDrawable(i));
    }

    public void setBackRadius(float f) {
        this.aSt = f;
        if (this.aSQ) {
            return;
        }
        invalidate();
    }

    @Override // android.widget.CompoundButton, android.widget.Checkable
    public void setChecked(boolean z) {
        if (isChecked() != z) {
            b(z);
        }
        if (this.aTl) {
            setCheckedImmediatelyNoEvent(z);
        } else {
            super.setChecked(z);
        }
    }

    public void setCheckedImmediately(boolean z) {
        super.setChecked(z);
        ObjectAnimator objectAnimator = this.aSS;
        if (objectAnimator != null && objectAnimator.isRunning()) {
            this.aSS.cancel();
        }
        setProgress(z ? 1.0f : 0.0f);
        invalidate();
    }

    public void setCheckedImmediatelyNoEvent(boolean z) {
        if (this.aTo == null) {
            setCheckedImmediately(z);
            return;
        }
        super.setOnCheckedChangeListener(null);
        setCheckedImmediately(z);
        super.setOnCheckedChangeListener(this.aTo);
    }

    public void setCheckedNoEvent(boolean z) {
        if (this.aTo == null) {
            setChecked(z);
            return;
        }
        super.setOnCheckedChangeListener(null);
        setChecked(z);
        super.setOnCheckedChangeListener(this.aTo);
    }

    public void setDrawDebugRect(boolean z) {
        this.aSR = z;
        invalidate();
    }

    public void setFadeBack(boolean z) {
        this.ab = z;
    }

    @Override // android.widget.CompoundButton
    public void setOnCheckedChangeListener(CompoundButton.OnCheckedChangeListener onCheckedChangeListener) {
        super.setOnCheckedChangeListener(onCheckedChangeListener);
        this.aTo = onCheckedChangeListener;
    }

    public void setTextAdjust(int i) {
        this.aTk = i;
        this.aTm = false;
        requestLayout();
        invalidate();
    }

    public void setTextExtra(int i) {
        this.aTj = i;
        this.aTm = false;
        requestLayout();
        invalidate();
    }

    public void setTextThumbInset(int i) {
        this.aTi = i;
        this.aTm = false;
        requestLayout();
        invalidate();
    }

    public void setThumbColor(ColorStateList colorStateList) {
        this.aSr = colorStateList;
        if (this.aSr != null) {
            setThumbDrawable(null);
        }
        invalidate();
    }

    public void setThumbColorRes(int i) {
        setThumbColor(getResources().getColorStateList(i));
    }

    public void setThumbDrawable(Drawable drawable) {
        this.aSo = drawable;
        this.aSP = this.aSo != null;
        refreshDrawableState();
        this.aTm = false;
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
        this.aSs = f;
        if (this.aSP) {
            return;
        }
        invalidate();
    }

    public void setThumbRangeRatio(float f) {
        this.aSv = f;
        this.aTm = false;
        requestLayout();
    }

    public void setTintColor(int i) {
        this.aSx = i;
        this.aSr = com.baidu.poly.widget.b.dA(this.aSx);
        this.aSq = com.baidu.poly.widget.b.dB(this.aSx);
        this.aSQ = false;
        this.aSP = false;
        refreshDrawableState();
        invalidate();
    }

    public SwitchButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aSR = false;
        this.aTl = false;
        this.aTm = false;
        this.aTn = false;
        c(attributeSet);
    }

    public SwitchButton(Context context) {
        super(context);
        this.aSR = false;
        this.aTl = false;
        this.aTm = false;
        this.aTn = false;
        c(null);
    }

    private Layout d(CharSequence charSequence) {
        TextPaint textPaint = this.aTd;
        return new StaticLayout(charSequence, textPaint, (int) Math.ceil(Layout.getDesiredWidth(charSequence, textPaint)), Layout.Alignment.ALIGN_CENTER, 1.0f, 0.0f, false);
    }

    public void a(float f, float f2, float f3, float f4) {
        this.aSu.set(f, f2, f3, f4);
        this.aTm = false;
        requestLayout();
    }

    public void a(CharSequence charSequence, CharSequence charSequence2) {
        this.aTb = charSequence;
        this.aTc = charSequence2;
        this.aTe = null;
        this.aTf = null;
        this.aTm = false;
        requestLayout();
        invalidate();
    }
}
