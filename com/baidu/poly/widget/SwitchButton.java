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
    private static int[] aSo = {16842912, 16842910, 16842919};
    private static int[] aSp = {-16842912, 16842910, 16842919};
    private int aSA;
    private int aSB;
    private int aSC;
    private int aSD;
    private int aSE;
    private int aSF;
    private int aSG;
    private int aSH;
    private int aSI;
    private Drawable aSJ;
    private Drawable aSK;
    private RectF aSL;
    private RectF aSM;
    private RectF aSN;
    private RectF aSO;
    private RectF aSP;
    private Paint aSQ;
    private boolean aSR;
    private boolean aSS;
    private boolean aST;
    private ObjectAnimator aSU;
    private float aSV;
    private RectF aSW;
    private float aSX;
    private float aSY;
    private float aSZ;
    private Drawable aSq;
    private Drawable aSr;
    private ColorStateList aSs;
    private ColorStateList aSt;
    private float aSu;
    private float aSv;
    private RectF aSw;
    private float aSx;
    private long aSy;
    private int aSz;
    private int aTa;
    private int aTb;
    private Paint aTc;
    private CharSequence aTd;
    private CharSequence aTe;
    private TextPaint aTf;
    private Layout aTg;
    private Layout aTh;
    private float aTi;
    private float aTj;
    private int aTk;
    private int aTl;
    private int aTm;
    private boolean aTn;
    private boolean aTo;
    private boolean aTp;
    private CompoundButton.OnCheckedChangeListener aTq;
    private boolean ab;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes11.dex */
    public static class a extends View.BaseSavedState {
        public static final Parcelable.Creator<a> CREATOR = new C0165a();
        CharSequence aTr;
        CharSequence aTs;

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
            TextUtils.writeToParcel(this.aTr, parcel, i);
            TextUtils.writeToParcel(this.aTs, parcel, i);
        }

        a(Parcelable parcelable) {
            super(parcelable);
        }

        private a(Parcel parcel) {
            super(parcel);
            this.aTr = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
            this.aTs = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
        }
    }

    public SwitchButton(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.aST = false;
        this.aTn = false;
        this.aTo = false;
        this.aTp = false;
        c(attributeSet);
    }

    private void R() {
        ViewParent parent = getParent();
        if (parent != null) {
            parent.requestDisallowInterceptTouchEvent(true);
        }
        this.aTp = true;
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
        this.aTa = ViewConfiguration.get(getContext()).getScaledTouchSlop();
        this.aTb = ViewConfiguration.getPressedStateDuration() + ViewConfiguration.getTapTimeout();
        this.aSQ = new Paint(1);
        this.aTc = new Paint(1);
        this.aTc.setStyle(Paint.Style.STROKE);
        this.aTc.setStrokeWidth(getResources().getDisplayMetrics().density);
        this.aTf = getPaint();
        this.aSL = new RectF();
        this.aSM = new RectF();
        this.aSN = new RectF();
        this.aSw = new RectF();
        this.aSO = new RectF();
        this.aSP = new RectF();
        this.aSU = ObjectAnimator.ofFloat(this, "progress", 0.0f, 0.0f).setDuration(250L);
        this.aSU.setInterpolator(new AccelerateDecelerateInterpolator());
        this.aSW = new RectF();
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
        this.aTd = str2;
        this.aTe = str;
        this.aTk = i4;
        this.aTl = i3;
        this.aTm = i5;
        this.aSq = drawable;
        this.aSt = colorStateList;
        this.aSR = this.aSq != null;
        this.aSz = i2;
        if (this.aSz == 0) {
            new TypedValue();
            this.aSz = 3309506;
        }
        if (!this.aSR && this.aSt == null) {
            this.aSt = com.baidu.poly.widget.b.dA(this.aSz);
            this.aSE = this.aSt.getDefaultColor();
        }
        this.aSA = e(f5);
        this.aSB = e(f6);
        this.aSr = drawable2;
        this.aSs = colorStateList2;
        this.aSS = this.aSr != null;
        if (!this.aSS && this.aSs == null) {
            this.aSs = com.baidu.poly.widget.b.dB(this.aSz);
            this.aSF = this.aSs.getDefaultColor();
            this.aSG = this.aSs.getColorForState(aSo, this.aSF);
        }
        this.aSw.set(f, f3, f2, f4);
        this.aSx = this.aSw.width() >= 0.0f ? Math.max(f9, 1.0f) : f9;
        this.aSu = f7;
        this.aSv = f8;
        this.aSy = i;
        this.ab = z;
        this.aSU.setDuration(this.aSy);
        if (isChecked()) {
            setProgress(1.0f);
        }
    }

    private int dy(int i) {
        int i2;
        int size = View.MeasureSpec.getSize(i);
        int mode = View.MeasureSpec.getMode(i);
        if (this.aSA == 0 && this.aSR) {
            this.aSA = this.aSq.getIntrinsicWidth();
        }
        int e = e(this.aTi);
        if (this.aSx == 0.0f) {
            this.aSx = 1.8f;
        }
        if (mode == 1073741824) {
            int paddingLeft = (size - getPaddingLeft()) - getPaddingRight();
            if (this.aSA != 0) {
                int e2 = e(i2 * this.aSx);
                RectF rectF = this.aSw;
                int e3 = (this.aTl + e) - ((e2 - this.aSA) + e(Math.max(rectF.left, rectF.right)));
                float f = e2;
                RectF rectF2 = this.aSw;
                this.aSC = e(rectF2.right + rectF2.left + f + Math.max(e3, 0));
                if (this.aSC < 0) {
                    this.aSA = 0;
                }
                if (f + Math.max(this.aSw.left, 0.0f) + Math.max(this.aSw.right, 0.0f) + Math.max(e3, 0) > paddingLeft) {
                    this.aSA = 0;
                }
            }
            if (this.aSA == 0) {
                int e4 = e((((size - getPaddingLeft()) - getPaddingRight()) - Math.max(this.aSw.left, 0.0f)) - Math.max(this.aSw.right, 0.0f));
                if (e4 < 0) {
                    this.aSA = 0;
                    this.aSC = 0;
                    return size;
                }
                float f2 = e4;
                this.aSA = e(f2 / this.aSx);
                RectF rectF3 = this.aSw;
                this.aSC = e(f2 + rectF3.left + rectF3.right);
                if (this.aSC < 0) {
                    this.aSA = 0;
                    this.aSC = 0;
                    return size;
                }
                int i3 = e + this.aTl;
                int i4 = e4 - this.aSA;
                RectF rectF4 = this.aSw;
                int e5 = i3 - (i4 + e(Math.max(rectF4.left, rectF4.right)));
                if (e5 > 0) {
                    this.aSA -= e5;
                }
                if (this.aSA < 0) {
                    this.aSA = 0;
                    this.aSC = 0;
                    return size;
                }
                return size;
            }
            return size;
        }
        if (this.aSA == 0) {
            this.aSA = e(getResources().getDisplayMetrics().density * 20.0f);
        }
        if (this.aSx == 0.0f) {
            this.aSx = 1.8f;
        }
        int e6 = e(this.aSA * this.aSx);
        RectF rectF5 = this.aSw;
        int e7 = e((e + this.aTl) - (((e6 - this.aSA) + Math.max(rectF5.left, rectF5.right)) + this.aTk));
        float f3 = e6;
        RectF rectF6 = this.aSw;
        this.aSC = e(rectF6.right + rectF6.left + f3 + Math.max(0, e7));
        if (this.aSC < 0) {
            this.aSA = 0;
            this.aSC = 0;
            return size;
        }
        int e8 = e(Math.max(0.0f, this.aSw.left) + f3 + Math.max(0.0f, this.aSw.right) + Math.max(0, e7));
        return Math.max(e8, getPaddingLeft() + e8 + getPaddingRight());
    }

    private int e(double d) {
        return (int) Math.ceil(d);
    }

    private float getProgress() {
        return this.aSV;
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
        if (this.aSB == 0 && this.aSR) {
            this.aSB = this.aSq.getIntrinsicHeight();
        }
        if (mode == 1073741824) {
            if (this.aSB != 0) {
                RectF rectF = this.aSw;
                this.aSD = e(i3 + rectF.top + rectF.bottom);
                this.aSD = e(Math.max(this.aSD, this.aTj));
                if ((((this.aSD + getPaddingTop()) + getPaddingBottom()) - Math.min(0.0f, this.aSw.top)) - Math.min(0.0f, this.aSw.bottom) > size) {
                    this.aSB = 0;
                }
            }
            if (this.aSB == 0) {
                this.aSD = e(((size - getPaddingTop()) - getPaddingBottom()) + Math.min(0.0f, this.aSw.top) + Math.min(0.0f, this.aSw.bottom));
                if (this.aSD < 0) {
                    this.aSD = 0;
                    this.aSB = 0;
                    return size;
                }
                RectF rectF2 = this.aSw;
                this.aSB = e((i4 - rectF2.top) - rectF2.bottom);
            }
            if (this.aSB < 0) {
                this.aSD = 0;
                this.aSB = 0;
                return size;
            }
            return size;
        }
        if (this.aSB == 0) {
            this.aSB = e(getResources().getDisplayMetrics().density * 20.0f);
        }
        RectF rectF3 = this.aSw;
        this.aSD = e(this.aSB + rectF3.top + rectF3.bottom);
        if (this.aSD < 0) {
            this.aSD = 0;
            this.aSB = 0;
            return size;
        }
        int e = e(this.aTj - i2);
        if (e > 0) {
            this.aSD += e;
            this.aSB = e + this.aSB;
        }
        int max = Math.max(this.aSB, this.aSD);
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
        this.aSV = f;
        invalidate();
    }

    private void setup() {
        int i;
        float paddingTop;
        float paddingLeft;
        int i2 = this.aSA;
        if (i2 != 0 && (i = this.aSB) != 0 && this.aSC != 0 && this.aSD != 0) {
            if (this.aSu == -1.0f) {
                this.aSu = Math.min(i2, i) / 2;
            }
            if (this.aSv == -1.0f) {
                this.aSv = Math.min(this.aSC, this.aSD) / 2;
            }
            int measuredWidth = (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight();
            int measuredHeight = (getMeasuredHeight() - getPaddingTop()) - getPaddingBottom();
            int e = e((this.aSC - Math.min(0.0f, this.aSw.left)) - Math.min(0.0f, this.aSw.right));
            int e2 = e((this.aSD - Math.min(0.0f, this.aSw.top)) - Math.min(0.0f, this.aSw.bottom));
            if (measuredHeight <= e2) {
                paddingTop = getPaddingTop() + Math.max(0.0f, this.aSw.top);
            } else {
                paddingTop = (((measuredHeight - e2) + 1) / 2) + getPaddingTop() + Math.max(0.0f, this.aSw.top);
            }
            if (measuredWidth <= this.aSC) {
                paddingLeft = getPaddingLeft() + Math.max(0.0f, this.aSw.left);
            } else {
                paddingLeft = (((measuredWidth - e) + 1) / 2) + getPaddingLeft() + Math.max(0.0f, this.aSw.left);
            }
            this.aSL.set(paddingLeft, paddingTop, this.aSA + paddingLeft, this.aSB + paddingTop);
            RectF rectF = this.aSL;
            float f = rectF.left;
            RectF rectF2 = this.aSw;
            float f2 = f - rectF2.left;
            RectF rectF3 = this.aSM;
            float f3 = rectF.top;
            float f4 = rectF2.top;
            rectF3.set(f2, f3 - f4, this.aSC + f2, (f3 - f4) + this.aSD);
            RectF rectF4 = this.aSN;
            RectF rectF5 = this.aSL;
            rectF4.set(rectF5.left, 0.0f, (this.aSM.right - this.aSw.right) - rectF5.width(), 0.0f);
            this.aSv = Math.min(Math.min(this.aSM.width(), this.aSM.height()) / 2.0f, this.aSv);
            Drawable drawable = this.aSr;
            if (drawable != null) {
                RectF rectF6 = this.aSM;
                drawable.setBounds((int) rectF6.left, (int) rectF6.top, e(rectF6.right), e(this.aSM.bottom));
            }
            if (this.aTg != null) {
                RectF rectF7 = this.aSM;
                float width = ((((((rectF7.width() + this.aTk) - this.aSA) - this.aSw.right) - this.aTg.getWidth()) / 2.0f) + rectF7.left) - this.aTm;
                RectF rectF8 = this.aSM;
                float height = ((rectF8.height() - this.aTg.getHeight()) / 2.0f) + rectF8.top;
                this.aSO.set(width, height, this.aTg.getWidth() + width, this.aTg.getHeight() + height);
            }
            if (this.aTh != null) {
                RectF rectF9 = this.aSM;
                float width2 = ((rectF9.right - (((((rectF9.width() + this.aTk) - this.aSA) - this.aSw.left) - this.aTh.getWidth()) / 2.0f)) - this.aTh.getWidth()) + this.aTm;
                RectF rectF10 = this.aSM;
                float height2 = ((rectF10.height() - this.aTh.getHeight()) / 2.0f) + rectF10.top;
                this.aSP.set(width2, height2, this.aTh.getWidth() + width2, this.aTh.getHeight() + height2);
            }
            this.aTo = true;
        }
    }

    protected void b(boolean z) {
        ObjectAnimator objectAnimator = this.aSU;
        if (objectAnimator != null) {
            if (objectAnimator.isRunning()) {
                this.aSU.cancel();
            }
            this.aSU.setDuration(this.aSy);
            if (z) {
                this.aSU.setFloatValues(this.aSV, 1.0f);
            } else {
                this.aSU.setFloatValues(this.aSV, 0.0f);
            }
            this.aSU.start();
        }
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    protected void drawableStateChanged() {
        ColorStateList colorStateList;
        ColorStateList colorStateList2;
        super.drawableStateChanged();
        if (!this.aSR && (colorStateList2 = this.aSt) != null) {
            this.aSE = colorStateList2.getColorForState(getDrawableState(), this.aSE);
        } else {
            setDrawableState(this.aSq);
        }
        int[] iArr = isChecked() ? aSp : aSo;
        ColorStateList textColors = getTextColors();
        if (textColors != null) {
            int defaultColor = textColors.getDefaultColor();
            this.aSH = textColors.getColorForState(aSo, defaultColor);
            this.aSI = textColors.getColorForState(aSp, defaultColor);
        }
        if (!this.aSS && (colorStateList = this.aSs) != null) {
            this.aSF = colorStateList.getColorForState(getDrawableState(), this.aSF);
            this.aSG = this.aSs.getColorForState(iArr, this.aSF);
            return;
        }
        Drawable drawable = this.aSr;
        if ((drawable instanceof StateListDrawable) && this.ab) {
            drawable.setState(iArr);
            this.aSK = this.aSr.getCurrent().mutate();
        } else {
            this.aSK = null;
        }
        setDrawableState(this.aSr);
        Drawable drawable2 = this.aSr;
        if (drawable2 != null) {
            this.aSJ = drawable2.getCurrent().mutate();
        }
    }

    public void g() {
        if (this.aTq == null) {
            toggle();
            return;
        }
        super.setOnCheckedChangeListener(null);
        toggle();
        super.setOnCheckedChangeListener(this.aTq);
    }

    public long getAnimationDuration() {
        return this.aSy;
    }

    public ColorStateList getBackColor() {
        return this.aSs;
    }

    public Drawable getBackDrawable() {
        return this.aSr;
    }

    public float getBackRadius() {
        return this.aSv;
    }

    public PointF getBackSizeF() {
        return new PointF(this.aSM.width(), this.aSM.height());
    }

    public CharSequence getTextOff() {
        return this.aTe;
    }

    public CharSequence getTextOn() {
        return this.aTd;
    }

    public ColorStateList getThumbColor() {
        return this.aSt;
    }

    public Drawable getThumbDrawable() {
        return this.aSq;
    }

    public float getThumbHeight() {
        return this.aSB;
    }

    public RectF getThumbMargin() {
        return this.aSw;
    }

    public float getThumbRadius() {
        return this.aSu;
    }

    public float getThumbRangeRatio() {
        return this.aSx;
    }

    public float getThumbWidth() {
        return this.aSA;
    }

    public int getTintColor() {
        return this.aSz;
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    protected void onDraw(Canvas canvas) {
        float progress;
        super.onDraw(canvas);
        if (!this.aTo) {
            setup();
        }
        if (this.aTo) {
            if (this.aSS) {
                if (this.ab && this.aSJ != null && this.aSK != null) {
                    Drawable drawable = isChecked() ? this.aSJ : this.aSK;
                    Drawable drawable2 = isChecked() ? this.aSK : this.aSJ;
                    int progress2 = (int) (getProgress() * 255.0f);
                    drawable.setAlpha(progress2);
                    drawable.draw(canvas);
                    drawable2.setAlpha(255 - progress2);
                    drawable2.draw(canvas);
                } else {
                    this.aSr.setAlpha(255);
                    this.aSr.draw(canvas);
                }
            } else if (this.ab) {
                int i = isChecked() ? this.aSF : this.aSG;
                int i2 = isChecked() ? this.aSG : this.aSF;
                int progress3 = (int) (getProgress() * 255.0f);
                this.aSQ.setARGB((Color.alpha(i) * progress3) / 255, Color.red(i), Color.green(i), Color.blue(i));
                RectF rectF = this.aSM;
                float f = this.aSv;
                canvas.drawRoundRect(rectF, f, f, this.aSQ);
                this.aSQ.setARGB(((255 - progress3) * Color.alpha(i2)) / 255, Color.red(i2), Color.green(i2), Color.blue(i2));
                RectF rectF2 = this.aSM;
                float f2 = this.aSv;
                canvas.drawRoundRect(rectF2, f2, f2, this.aSQ);
                this.aSQ.setAlpha(255);
            } else {
                this.aSQ.setColor(this.aSF);
                RectF rectF3 = this.aSM;
                float f3 = this.aSv;
                canvas.drawRoundRect(rectF3, f3, f3, this.aSQ);
            }
            Layout layout = ((double) getProgress()) > 0.5d ? this.aTg : this.aTh;
            RectF rectF4 = ((double) getProgress()) > 0.5d ? this.aSO : this.aSP;
            if (layout != null && rectF4 != null) {
                if (getProgress() >= 0.75d) {
                    progress = (getProgress() * 4.0f) - 3.0f;
                } else {
                    progress = ((double) getProgress()) < 0.25d ? 1.0f - (getProgress() * 4.0f) : 0.0f;
                }
                int i3 = (int) (progress * 255.0f);
                int i4 = ((double) getProgress()) > 0.5d ? this.aSH : this.aSI;
                layout.getPaint().setARGB((i3 * Color.alpha(i4)) / 255, Color.red(i4), Color.green(i4), Color.blue(i4));
                canvas.save();
                canvas.translate(rectF4.left, rectF4.top);
                layout.draw(canvas);
                canvas.restore();
            }
            this.aSW.set(this.aSL);
            this.aSW.offset(this.aSV * this.aSN.width(), 0.0f);
            if (this.aSR) {
                Drawable drawable3 = this.aSq;
                RectF rectF5 = this.aSW;
                drawable3.setBounds((int) rectF5.left, (int) rectF5.top, e(rectF5.right), e(this.aSW.bottom));
                this.aSq.draw(canvas);
            } else {
                this.aSQ.setColor(this.aSE);
                RectF rectF6 = this.aSW;
                float f4 = this.aSu;
                canvas.drawRoundRect(rectF6, f4, f4, this.aSQ);
            }
            if (this.aST) {
                this.aTc.setColor(Color.parseColor("#AA0000"));
                canvas.drawRect(this.aSM, this.aTc);
                this.aTc.setColor(Color.parseColor("#0000FF"));
                canvas.drawRect(this.aSW, this.aTc);
                this.aTc.setColor(Color.parseColor(BaseBrowseView.ROOT_VIEW_COLOR));
                RectF rectF7 = this.aSN;
                float f5 = rectF7.left;
                float f6 = this.aSL.top;
                canvas.drawLine(f5, f6, rectF7.right, f6, this.aTc);
                this.aTc.setColor(Color.parseColor("#00CC00"));
                canvas.drawRect(((double) getProgress()) > 0.5d ? this.aSO : this.aSP, this.aTc);
            }
        }
    }

    @Override // android.widget.TextView, android.view.View
    protected void onMeasure(int i, int i2) {
        if (this.aTg == null && !TextUtils.isEmpty(this.aTd)) {
            this.aTg = d(this.aTd);
        }
        if (this.aTh == null && !TextUtils.isEmpty(this.aTe)) {
            this.aTh = d(this.aTe);
        }
        Layout layout = this.aTg;
        float width = layout != null ? layout.getWidth() : 0.0f;
        Layout layout2 = this.aTh;
        float width2 = layout2 != null ? layout2.getWidth() : 0.0f;
        if (width == 0.0f && width2 == 0.0f) {
            this.aTi = 0.0f;
        } else {
            this.aTi = Math.max(width, width2);
        }
        Layout layout3 = this.aTg;
        float height = layout3 != null ? layout3.getHeight() : 0.0f;
        Layout layout4 = this.aTh;
        float height2 = layout4 != null ? layout4.getHeight() : 0.0f;
        if (height == 0.0f && height2 == 0.0f) {
            this.aTj = 0.0f;
        } else {
            this.aTj = Math.max(height, height2);
        }
        setMeasuredDimension(dy(i), i(i2));
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        a aVar = (a) parcelable;
        a(aVar.aTr, aVar.aTs);
        this.aTn = true;
        super.onRestoreInstanceState(aVar.getSuperState());
        this.aTn = false;
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    public Parcelable onSaveInstanceState() {
        a aVar = new a(super.onSaveInstanceState());
        aVar.aTr = this.aTd;
        aVar.aTs = this.aTe;
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
        if (isEnabled() && isClickable() && isFocusable() && this.aTo) {
            int action = motionEvent.getAction();
            float x = motionEvent.getX() - this.aSX;
            float y = motionEvent.getY() - this.aSY;
            switch (action) {
                case 0:
                    this.aSX = motionEvent.getX();
                    this.aSY = motionEvent.getY();
                    this.aSZ = this.aSX;
                    setPressed(true);
                    break;
                case 1:
                case 3:
                    this.aTp = false;
                    setPressed(false);
                    float eventTime = (float) (motionEvent.getEventTime() - motionEvent.getDownTime());
                    if (Math.abs(x) < this.aTa && Math.abs(y) < this.aTa && eventTime < this.aTb) {
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
                    setProgress(getProgress() + ((x2 - this.aSZ) / this.aSN.width()));
                    if (!this.aTp && (Math.abs(x) > this.aTa / 2 || Math.abs(y) > this.aTa / 2)) {
                        if (y != 0.0f && Math.abs(x) <= Math.abs(y)) {
                            if (Math.abs(y) > Math.abs(x)) {
                                return false;
                            }
                        } else {
                            R();
                        }
                    }
                    this.aSZ = x2;
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
        this.aSy = j;
    }

    public void setBackColor(ColorStateList colorStateList) {
        this.aSs = colorStateList;
        if (this.aSs != null) {
            setBackDrawable(null);
        }
        invalidate();
    }

    public void setBackColorRes(int i) {
        setBackColor(getResources().getColorStateList(i));
    }

    public void setBackDrawable(Drawable drawable) {
        this.aSr = drawable;
        this.aSS = this.aSr != null;
        refreshDrawableState();
        this.aTo = false;
        requestLayout();
        invalidate();
    }

    public void setBackDrawableRes(int i) {
        setBackDrawable(getResources().getDrawable(i));
    }

    public void setBackRadius(float f) {
        this.aSv = f;
        if (this.aSS) {
            return;
        }
        invalidate();
    }

    @Override // android.widget.CompoundButton, android.widget.Checkable
    public void setChecked(boolean z) {
        if (isChecked() != z) {
            b(z);
        }
        if (this.aTn) {
            setCheckedImmediatelyNoEvent(z);
        } else {
            super.setChecked(z);
        }
    }

    public void setCheckedImmediately(boolean z) {
        super.setChecked(z);
        ObjectAnimator objectAnimator = this.aSU;
        if (objectAnimator != null && objectAnimator.isRunning()) {
            this.aSU.cancel();
        }
        setProgress(z ? 1.0f : 0.0f);
        invalidate();
    }

    public void setCheckedImmediatelyNoEvent(boolean z) {
        if (this.aTq == null) {
            setCheckedImmediately(z);
            return;
        }
        super.setOnCheckedChangeListener(null);
        setCheckedImmediately(z);
        super.setOnCheckedChangeListener(this.aTq);
    }

    public void setCheckedNoEvent(boolean z) {
        if (this.aTq == null) {
            setChecked(z);
            return;
        }
        super.setOnCheckedChangeListener(null);
        setChecked(z);
        super.setOnCheckedChangeListener(this.aTq);
    }

    public void setDrawDebugRect(boolean z) {
        this.aST = z;
        invalidate();
    }

    public void setFadeBack(boolean z) {
        this.ab = z;
    }

    @Override // android.widget.CompoundButton
    public void setOnCheckedChangeListener(CompoundButton.OnCheckedChangeListener onCheckedChangeListener) {
        super.setOnCheckedChangeListener(onCheckedChangeListener);
        this.aTq = onCheckedChangeListener;
    }

    public void setTextAdjust(int i) {
        this.aTm = i;
        this.aTo = false;
        requestLayout();
        invalidate();
    }

    public void setTextExtra(int i) {
        this.aTl = i;
        this.aTo = false;
        requestLayout();
        invalidate();
    }

    public void setTextThumbInset(int i) {
        this.aTk = i;
        this.aTo = false;
        requestLayout();
        invalidate();
    }

    public void setThumbColor(ColorStateList colorStateList) {
        this.aSt = colorStateList;
        if (this.aSt != null) {
            setThumbDrawable(null);
        }
        invalidate();
    }

    public void setThumbColorRes(int i) {
        setThumbColor(getResources().getColorStateList(i));
    }

    public void setThumbDrawable(Drawable drawable) {
        this.aSq = drawable;
        this.aSR = this.aSq != null;
        refreshDrawableState();
        this.aTo = false;
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
        this.aSu = f;
        if (this.aSR) {
            return;
        }
        invalidate();
    }

    public void setThumbRangeRatio(float f) {
        this.aSx = f;
        this.aTo = false;
        requestLayout();
    }

    public void setTintColor(int i) {
        this.aSz = i;
        this.aSt = com.baidu.poly.widget.b.dA(this.aSz);
        this.aSs = com.baidu.poly.widget.b.dB(this.aSz);
        this.aSS = false;
        this.aSR = false;
        refreshDrawableState();
        invalidate();
    }

    public SwitchButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aST = false;
        this.aTn = false;
        this.aTo = false;
        this.aTp = false;
        c(attributeSet);
    }

    public SwitchButton(Context context) {
        super(context);
        this.aST = false;
        this.aTn = false;
        this.aTo = false;
        this.aTp = false;
        c(null);
    }

    private Layout d(CharSequence charSequence) {
        TextPaint textPaint = this.aTf;
        return new StaticLayout(charSequence, textPaint, (int) Math.ceil(Layout.getDesiredWidth(charSequence, textPaint)), Layout.Alignment.ALIGN_CENTER, 1.0f, 0.0f, false);
    }

    public void a(float f, float f2, float f3, float f4) {
        this.aSw.set(f, f2, f3, f4);
        this.aTo = false;
        requestLayout();
    }

    public void a(CharSequence charSequence, CharSequence charSequence2) {
        this.aTd = charSequence;
        this.aTe = charSequence2;
        this.aTg = null;
        this.aTh = null;
        this.aTo = false;
        requestLayout();
        invalidate();
    }
}
