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
/* loaded from: classes10.dex */
public class SwitchButton extends CompoundButton {
    private static int[] aNN = {16842912, 16842910, 16842919};
    private static int[] aNO = {-16842912, 16842910, 16842919};
    private Drawable aNP;
    private Drawable aNQ;
    private ColorStateList aNR;
    private ColorStateList aNS;
    private float aNT;
    private float aNU;
    private RectF aNV;
    private float aNW;
    private long aNX;
    private int aNY;
    private int aNZ;
    private int aOA;
    private Paint aOB;
    private CharSequence aOC;
    private CharSequence aOD;
    private TextPaint aOE;
    private Layout aOF;
    private Layout aOG;
    private float aOH;
    private float aOI;
    private int aOJ;
    private int aOK;
    private int aOL;
    private boolean aOM;
    private boolean aON;
    private boolean aOO;
    private CompoundButton.OnCheckedChangeListener aOP;
    private int aOa;
    private int aOb;
    private int aOc;
    private int aOd;
    private int aOe;
    private int aOf;
    private int aOg;
    private int aOh;
    private Drawable aOi;
    private Drawable aOj;
    private RectF aOk;
    private RectF aOl;
    private RectF aOm;
    private RectF aOn;
    private RectF aOo;
    private Paint aOp;
    private boolean aOq;
    private boolean aOr;
    private boolean aOs;
    private ObjectAnimator aOt;
    private float aOu;
    private RectF aOv;
    private float aOw;
    private float aOx;
    private float aOy;
    private int aOz;
    private boolean ab;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes10.dex */
    public static class a extends View.BaseSavedState {
        public static final Parcelable.Creator<a> CREATOR = new C0156a();
        CharSequence aOQ;
        CharSequence aOR;

        /* renamed from: com.baidu.poly.widget.SwitchButton$a$a  reason: collision with other inner class name */
        /* loaded from: classes10.dex */
        static class C0156a implements Parcelable.Creator<a> {
            C0156a() {
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // android.os.Parcelable.Creator
            /* renamed from: dn */
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
            TextUtils.writeToParcel(this.aOQ, parcel, i);
            TextUtils.writeToParcel(this.aOR, parcel, i);
        }

        a(Parcelable parcelable) {
            super(parcelable);
        }

        private a(Parcel parcel) {
            super(parcel);
            this.aOQ = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
            this.aOR = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
        }
    }

    public SwitchButton(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.aOs = false;
        this.aOM = false;
        this.aON = false;
        this.aOO = false;
        c(attributeSet);
    }

    private void R() {
        ViewParent parent = getParent();
        if (parent != null) {
            parent.requestDisallowInterceptTouchEvent(true);
        }
        this.aOO = true;
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
        this.aOz = ViewConfiguration.get(getContext()).getScaledTouchSlop();
        this.aOA = ViewConfiguration.getPressedStateDuration() + ViewConfiguration.getTapTimeout();
        this.aOp = new Paint(1);
        this.aOB = new Paint(1);
        this.aOB.setStyle(Paint.Style.STROKE);
        this.aOB.setStrokeWidth(getResources().getDisplayMetrics().density);
        this.aOE = getPaint();
        this.aOk = new RectF();
        this.aOl = new RectF();
        this.aOm = new RectF();
        this.aNV = new RectF();
        this.aOn = new RectF();
        this.aOo = new RectF();
        this.aOt = ObjectAnimator.ofFloat(this, "progress", 0.0f, 0.0f).setDuration(250L);
        this.aOt.setInterpolator(new AccelerateDecelerateInterpolator());
        this.aOv = new RectF();
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
        this.aOC = str2;
        this.aOD = str;
        this.aOJ = i4;
        this.aOK = i3;
        this.aOL = i5;
        this.aNP = drawable;
        this.aNS = colorStateList;
        this.aOq = this.aNP != null;
        this.aNY = i2;
        if (this.aNY == 0) {
            new TypedValue();
            this.aNY = 3309506;
        }
        if (!this.aOq && this.aNS == null) {
            this.aNS = com.baidu.poly.widget.b.dk(this.aNY);
            this.aOd = this.aNS.getDefaultColor();
        }
        this.aNZ = e(f5);
        this.aOa = e(f6);
        this.aNQ = drawable2;
        this.aNR = colorStateList2;
        this.aOr = this.aNQ != null;
        if (!this.aOr && this.aNR == null) {
            this.aNR = com.baidu.poly.widget.b.dl(this.aNY);
            this.aOe = this.aNR.getDefaultColor();
            this.aOf = this.aNR.getColorForState(aNN, this.aOe);
        }
        this.aNV.set(f, f3, f2, f4);
        this.aNW = this.aNV.width() >= 0.0f ? Math.max(f9, 1.0f) : f9;
        this.aNT = f7;
        this.aNU = f8;
        this.aNX = i;
        this.ab = z;
        this.aOt.setDuration(this.aNX);
        if (isChecked()) {
            setProgress(1.0f);
        }
    }

    private int dh(int i) {
        int i2;
        int size = View.MeasureSpec.getSize(i);
        int mode = View.MeasureSpec.getMode(i);
        if (this.aNZ == 0 && this.aOq) {
            this.aNZ = this.aNP.getIntrinsicWidth();
        }
        int e = e(this.aOH);
        if (this.aNW == 0.0f) {
            this.aNW = 1.8f;
        }
        if (mode == 1073741824) {
            int paddingLeft = (size - getPaddingLeft()) - getPaddingRight();
            if (this.aNZ != 0) {
                int e2 = e(i2 * this.aNW);
                RectF rectF = this.aNV;
                int e3 = (this.aOK + e) - ((e2 - this.aNZ) + e(Math.max(rectF.left, rectF.right)));
                float f = e2;
                RectF rectF2 = this.aNV;
                this.aOb = e(rectF2.right + rectF2.left + f + Math.max(e3, 0));
                if (this.aOb < 0) {
                    this.aNZ = 0;
                }
                if (f + Math.max(this.aNV.left, 0.0f) + Math.max(this.aNV.right, 0.0f) + Math.max(e3, 0) > paddingLeft) {
                    this.aNZ = 0;
                }
            }
            if (this.aNZ == 0) {
                int e4 = e((((size - getPaddingLeft()) - getPaddingRight()) - Math.max(this.aNV.left, 0.0f)) - Math.max(this.aNV.right, 0.0f));
                if (e4 < 0) {
                    this.aNZ = 0;
                    this.aOb = 0;
                    return size;
                }
                float f2 = e4;
                this.aNZ = e(f2 / this.aNW);
                RectF rectF3 = this.aNV;
                this.aOb = e(f2 + rectF3.left + rectF3.right);
                if (this.aOb < 0) {
                    this.aNZ = 0;
                    this.aOb = 0;
                    return size;
                }
                int i3 = e + this.aOK;
                int i4 = e4 - this.aNZ;
                RectF rectF4 = this.aNV;
                int e5 = i3 - (i4 + e(Math.max(rectF4.left, rectF4.right)));
                if (e5 > 0) {
                    this.aNZ -= e5;
                }
                if (this.aNZ < 0) {
                    this.aNZ = 0;
                    this.aOb = 0;
                    return size;
                }
                return size;
            }
            return size;
        }
        if (this.aNZ == 0) {
            this.aNZ = e(getResources().getDisplayMetrics().density * 20.0f);
        }
        if (this.aNW == 0.0f) {
            this.aNW = 1.8f;
        }
        int e6 = e(this.aNZ * this.aNW);
        RectF rectF5 = this.aNV;
        int e7 = e((e + this.aOK) - (((e6 - this.aNZ) + Math.max(rectF5.left, rectF5.right)) + this.aOJ));
        float f3 = e6;
        RectF rectF6 = this.aNV;
        this.aOb = e(rectF6.right + rectF6.left + f3 + Math.max(0, e7));
        if (this.aOb < 0) {
            this.aNZ = 0;
            this.aOb = 0;
            return size;
        }
        int e8 = e(Math.max(0.0f, this.aNV.left) + f3 + Math.max(0.0f, this.aNV.right) + Math.max(0, e7));
        return Math.max(e8, getPaddingLeft() + e8 + getPaddingRight());
    }

    private int di(int i) {
        int i2;
        int i3;
        int i4;
        int size = View.MeasureSpec.getSize(i);
        int mode = View.MeasureSpec.getMode(i);
        if (this.aOa == 0 && this.aOq) {
            this.aOa = this.aNP.getIntrinsicHeight();
        }
        if (mode == 1073741824) {
            if (this.aOa != 0) {
                RectF rectF = this.aNV;
                this.aOc = e(i3 + rectF.top + rectF.bottom);
                this.aOc = e(Math.max(this.aOc, this.aOI));
                if ((((this.aOc + getPaddingTop()) + getPaddingBottom()) - Math.min(0.0f, this.aNV.top)) - Math.min(0.0f, this.aNV.bottom) > size) {
                    this.aOa = 0;
                }
            }
            if (this.aOa == 0) {
                this.aOc = e(((size - getPaddingTop()) - getPaddingBottom()) + Math.min(0.0f, this.aNV.top) + Math.min(0.0f, this.aNV.bottom));
                if (this.aOc < 0) {
                    this.aOc = 0;
                    this.aOa = 0;
                    return size;
                }
                RectF rectF2 = this.aNV;
                this.aOa = e((i4 - rectF2.top) - rectF2.bottom);
            }
            if (this.aOa < 0) {
                this.aOc = 0;
                this.aOa = 0;
                return size;
            }
            return size;
        }
        if (this.aOa == 0) {
            this.aOa = e(getResources().getDisplayMetrics().density * 20.0f);
        }
        RectF rectF3 = this.aNV;
        this.aOc = e(this.aOa + rectF3.top + rectF3.bottom);
        if (this.aOc < 0) {
            this.aOc = 0;
            this.aOa = 0;
            return size;
        }
        int e = e(this.aOI - i2);
        if (e > 0) {
            this.aOc += e;
            this.aOa = e + this.aOa;
        }
        int max = Math.max(this.aOa, this.aOc);
        return Math.max(Math.max(max, getPaddingTop() + max + getPaddingBottom()), getSuggestedMinimumHeight());
    }

    private int e(double d) {
        return (int) Math.ceil(d);
    }

    private float getProgress() {
        return this.aOu;
    }

    private boolean getStatusBasedOnPos() {
        return getProgress() > 0.5f;
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
        this.aOu = f;
        invalidate();
    }

    private void setup() {
        int i;
        float paddingTop;
        float paddingLeft;
        int i2 = this.aNZ;
        if (i2 != 0 && (i = this.aOa) != 0 && this.aOb != 0 && this.aOc != 0) {
            if (this.aNT == -1.0f) {
                this.aNT = Math.min(i2, i) / 2;
            }
            if (this.aNU == -1.0f) {
                this.aNU = Math.min(this.aOb, this.aOc) / 2;
            }
            int measuredWidth = (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight();
            int measuredHeight = (getMeasuredHeight() - getPaddingTop()) - getPaddingBottom();
            int e = e((this.aOb - Math.min(0.0f, this.aNV.left)) - Math.min(0.0f, this.aNV.right));
            int e2 = e((this.aOc - Math.min(0.0f, this.aNV.top)) - Math.min(0.0f, this.aNV.bottom));
            if (measuredHeight <= e2) {
                paddingTop = getPaddingTop() + Math.max(0.0f, this.aNV.top);
            } else {
                paddingTop = (((measuredHeight - e2) + 1) / 2) + getPaddingTop() + Math.max(0.0f, this.aNV.top);
            }
            if (measuredWidth <= this.aOb) {
                paddingLeft = getPaddingLeft() + Math.max(0.0f, this.aNV.left);
            } else {
                paddingLeft = (((measuredWidth - e) + 1) / 2) + getPaddingLeft() + Math.max(0.0f, this.aNV.left);
            }
            this.aOk.set(paddingLeft, paddingTop, this.aNZ + paddingLeft, this.aOa + paddingTop);
            RectF rectF = this.aOk;
            float f = rectF.left;
            RectF rectF2 = this.aNV;
            float f2 = f - rectF2.left;
            RectF rectF3 = this.aOl;
            float f3 = rectF.top;
            float f4 = rectF2.top;
            rectF3.set(f2, f3 - f4, this.aOb + f2, (f3 - f4) + this.aOc);
            RectF rectF4 = this.aOm;
            RectF rectF5 = this.aOk;
            rectF4.set(rectF5.left, 0.0f, (this.aOl.right - this.aNV.right) - rectF5.width(), 0.0f);
            this.aNU = Math.min(Math.min(this.aOl.width(), this.aOl.height()) / 2.0f, this.aNU);
            Drawable drawable = this.aNQ;
            if (drawable != null) {
                RectF rectF6 = this.aOl;
                drawable.setBounds((int) rectF6.left, (int) rectF6.top, e(rectF6.right), e(this.aOl.bottom));
            }
            if (this.aOF != null) {
                RectF rectF7 = this.aOl;
                float width = ((((((rectF7.width() + this.aOJ) - this.aNZ) - this.aNV.right) - this.aOF.getWidth()) / 2.0f) + rectF7.left) - this.aOL;
                RectF rectF8 = this.aOl;
                float height = ((rectF8.height() - this.aOF.getHeight()) / 2.0f) + rectF8.top;
                this.aOn.set(width, height, this.aOF.getWidth() + width, this.aOF.getHeight() + height);
            }
            if (this.aOG != null) {
                RectF rectF9 = this.aOl;
                float width2 = ((rectF9.right - (((((rectF9.width() + this.aOJ) - this.aNZ) - this.aNV.left) - this.aOG.getWidth()) / 2.0f)) - this.aOG.getWidth()) + this.aOL;
                RectF rectF10 = this.aOl;
                float height2 = ((rectF10.height() - this.aOG.getHeight()) / 2.0f) + rectF10.top;
                this.aOo.set(width2, height2, this.aOG.getWidth() + width2, this.aOG.getHeight() + height2);
            }
            this.aON = true;
        }
    }

    protected void b(boolean z) {
        ObjectAnimator objectAnimator = this.aOt;
        if (objectAnimator != null) {
            if (objectAnimator.isRunning()) {
                this.aOt.cancel();
            }
            this.aOt.setDuration(this.aNX);
            if (z) {
                this.aOt.setFloatValues(this.aOu, 1.0f);
            } else {
                this.aOt.setFloatValues(this.aOu, 0.0f);
            }
            this.aOt.start();
        }
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    protected void drawableStateChanged() {
        ColorStateList colorStateList;
        ColorStateList colorStateList2;
        super.drawableStateChanged();
        if (!this.aOq && (colorStateList2 = this.aNS) != null) {
            this.aOd = colorStateList2.getColorForState(getDrawableState(), this.aOd);
        } else {
            setDrawableState(this.aNP);
        }
        int[] iArr = isChecked() ? aNO : aNN;
        ColorStateList textColors = getTextColors();
        if (textColors != null) {
            int defaultColor = textColors.getDefaultColor();
            this.aOg = textColors.getColorForState(aNN, defaultColor);
            this.aOh = textColors.getColorForState(aNO, defaultColor);
        }
        if (!this.aOr && (colorStateList = this.aNR) != null) {
            this.aOe = colorStateList.getColorForState(getDrawableState(), this.aOe);
            this.aOf = this.aNR.getColorForState(iArr, this.aOe);
            return;
        }
        Drawable drawable = this.aNQ;
        if ((drawable instanceof StateListDrawable) && this.ab) {
            drawable.setState(iArr);
            this.aOj = this.aNQ.getCurrent().mutate();
        } else {
            this.aOj = null;
        }
        setDrawableState(this.aNQ);
        Drawable drawable2 = this.aNQ;
        if (drawable2 != null) {
            this.aOi = drawable2.getCurrent().mutate();
        }
    }

    public void g() {
        if (this.aOP == null) {
            toggle();
            return;
        }
        super.setOnCheckedChangeListener(null);
        toggle();
        super.setOnCheckedChangeListener(this.aOP);
    }

    public long getAnimationDuration() {
        return this.aNX;
    }

    public ColorStateList getBackColor() {
        return this.aNR;
    }

    public Drawable getBackDrawable() {
        return this.aNQ;
    }

    public float getBackRadius() {
        return this.aNU;
    }

    public PointF getBackSizeF() {
        return new PointF(this.aOl.width(), this.aOl.height());
    }

    public CharSequence getTextOff() {
        return this.aOD;
    }

    public CharSequence getTextOn() {
        return this.aOC;
    }

    public ColorStateList getThumbColor() {
        return this.aNS;
    }

    public Drawable getThumbDrawable() {
        return this.aNP;
    }

    public float getThumbHeight() {
        return this.aOa;
    }

    public RectF getThumbMargin() {
        return this.aNV;
    }

    public float getThumbRadius() {
        return this.aNT;
    }

    public float getThumbRangeRatio() {
        return this.aNW;
    }

    public float getThumbWidth() {
        return this.aNZ;
    }

    public int getTintColor() {
        return this.aNY;
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    protected void onDraw(Canvas canvas) {
        float progress;
        super.onDraw(canvas);
        if (!this.aON) {
            setup();
        }
        if (this.aON) {
            if (this.aOr) {
                if (this.ab && this.aOi != null && this.aOj != null) {
                    Drawable drawable = isChecked() ? this.aOi : this.aOj;
                    Drawable drawable2 = isChecked() ? this.aOj : this.aOi;
                    int progress2 = (int) (getProgress() * 255.0f);
                    drawable.setAlpha(progress2);
                    drawable.draw(canvas);
                    drawable2.setAlpha(255 - progress2);
                    drawable2.draw(canvas);
                } else {
                    this.aNQ.setAlpha(255);
                    this.aNQ.draw(canvas);
                }
            } else if (this.ab) {
                int i = isChecked() ? this.aOe : this.aOf;
                int i2 = isChecked() ? this.aOf : this.aOe;
                int progress3 = (int) (getProgress() * 255.0f);
                this.aOp.setARGB((Color.alpha(i) * progress3) / 255, Color.red(i), Color.green(i), Color.blue(i));
                RectF rectF = this.aOl;
                float f = this.aNU;
                canvas.drawRoundRect(rectF, f, f, this.aOp);
                this.aOp.setARGB(((255 - progress3) * Color.alpha(i2)) / 255, Color.red(i2), Color.green(i2), Color.blue(i2));
                RectF rectF2 = this.aOl;
                float f2 = this.aNU;
                canvas.drawRoundRect(rectF2, f2, f2, this.aOp);
                this.aOp.setAlpha(255);
            } else {
                this.aOp.setColor(this.aOe);
                RectF rectF3 = this.aOl;
                float f3 = this.aNU;
                canvas.drawRoundRect(rectF3, f3, f3, this.aOp);
            }
            Layout layout = ((double) getProgress()) > 0.5d ? this.aOF : this.aOG;
            RectF rectF4 = ((double) getProgress()) > 0.5d ? this.aOn : this.aOo;
            if (layout != null && rectF4 != null) {
                if (getProgress() >= 0.75d) {
                    progress = (getProgress() * 4.0f) - 3.0f;
                } else {
                    progress = ((double) getProgress()) < 0.25d ? 1.0f - (getProgress() * 4.0f) : 0.0f;
                }
                int i3 = (int) (progress * 255.0f);
                int i4 = ((double) getProgress()) > 0.5d ? this.aOg : this.aOh;
                layout.getPaint().setARGB((i3 * Color.alpha(i4)) / 255, Color.red(i4), Color.green(i4), Color.blue(i4));
                canvas.save();
                canvas.translate(rectF4.left, rectF4.top);
                layout.draw(canvas);
                canvas.restore();
            }
            this.aOv.set(this.aOk);
            this.aOv.offset(this.aOu * this.aOm.width(), 0.0f);
            if (this.aOq) {
                Drawable drawable3 = this.aNP;
                RectF rectF5 = this.aOv;
                drawable3.setBounds((int) rectF5.left, (int) rectF5.top, e(rectF5.right), e(this.aOv.bottom));
                this.aNP.draw(canvas);
            } else {
                this.aOp.setColor(this.aOd);
                RectF rectF6 = this.aOv;
                float f4 = this.aNT;
                canvas.drawRoundRect(rectF6, f4, f4, this.aOp);
            }
            if (this.aOs) {
                this.aOB.setColor(Color.parseColor("#AA0000"));
                canvas.drawRect(this.aOl, this.aOB);
                this.aOB.setColor(Color.parseColor("#0000FF"));
                canvas.drawRect(this.aOv, this.aOB);
                this.aOB.setColor(Color.parseColor(BaseBrowseView.ROOT_VIEW_COLOR));
                RectF rectF7 = this.aOm;
                float f5 = rectF7.left;
                float f6 = this.aOk.top;
                canvas.drawLine(f5, f6, rectF7.right, f6, this.aOB);
                this.aOB.setColor(Color.parseColor("#00CC00"));
                canvas.drawRect(((double) getProgress()) > 0.5d ? this.aOn : this.aOo, this.aOB);
            }
        }
    }

    @Override // android.widget.TextView, android.view.View
    protected void onMeasure(int i, int i2) {
        if (this.aOF == null && !TextUtils.isEmpty(this.aOC)) {
            this.aOF = d(this.aOC);
        }
        if (this.aOG == null && !TextUtils.isEmpty(this.aOD)) {
            this.aOG = d(this.aOD);
        }
        Layout layout = this.aOF;
        float width = layout != null ? layout.getWidth() : 0.0f;
        Layout layout2 = this.aOG;
        float width2 = layout2 != null ? layout2.getWidth() : 0.0f;
        if (width == 0.0f && width2 == 0.0f) {
            this.aOH = 0.0f;
        } else {
            this.aOH = Math.max(width, width2);
        }
        Layout layout3 = this.aOF;
        float height = layout3 != null ? layout3.getHeight() : 0.0f;
        Layout layout4 = this.aOG;
        float height2 = layout4 != null ? layout4.getHeight() : 0.0f;
        if (height == 0.0f && height2 == 0.0f) {
            this.aOI = 0.0f;
        } else {
            this.aOI = Math.max(height, height2);
        }
        setMeasuredDimension(dh(i), di(i2));
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        a aVar = (a) parcelable;
        a(aVar.aOQ, aVar.aOR);
        this.aOM = true;
        super.onRestoreInstanceState(aVar.getSuperState());
        this.aOM = false;
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    public Parcelable onSaveInstanceState() {
        a aVar = new a(super.onSaveInstanceState());
        aVar.aOQ = this.aOC;
        aVar.aOR = this.aOD;
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
        if (isEnabled() && isClickable() && isFocusable() && this.aON) {
            int action = motionEvent.getAction();
            float x = motionEvent.getX() - this.aOw;
            float y = motionEvent.getY() - this.aOx;
            switch (action) {
                case 0:
                    this.aOw = motionEvent.getX();
                    this.aOx = motionEvent.getY();
                    this.aOy = this.aOw;
                    setPressed(true);
                    break;
                case 1:
                case 3:
                    this.aOO = false;
                    setPressed(false);
                    float eventTime = (float) (motionEvent.getEventTime() - motionEvent.getDownTime());
                    if (Math.abs(x) < this.aOz && Math.abs(y) < this.aOz && eventTime < this.aOA) {
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
                    setProgress(getProgress() + ((x2 - this.aOy) / this.aOm.width()));
                    if (!this.aOO && (Math.abs(x) > this.aOz / 2 || Math.abs(y) > this.aOz / 2)) {
                        if (y != 0.0f && Math.abs(x) <= Math.abs(y)) {
                            if (Math.abs(y) > Math.abs(x)) {
                                return false;
                            }
                        } else {
                            R();
                        }
                    }
                    this.aOy = x2;
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
        this.aNX = j;
    }

    public void setBackColor(ColorStateList colorStateList) {
        this.aNR = colorStateList;
        if (this.aNR != null) {
            setBackDrawable(null);
        }
        invalidate();
    }

    public void setBackColorRes(int i) {
        setBackColor(getResources().getColorStateList(i));
    }

    public void setBackDrawable(Drawable drawable) {
        this.aNQ = drawable;
        this.aOr = this.aNQ != null;
        refreshDrawableState();
        this.aON = false;
        requestLayout();
        invalidate();
    }

    public void setBackDrawableRes(int i) {
        setBackDrawable(getResources().getDrawable(i));
    }

    public void setBackRadius(float f) {
        this.aNU = f;
        if (this.aOr) {
            return;
        }
        invalidate();
    }

    @Override // android.widget.CompoundButton, android.widget.Checkable
    public void setChecked(boolean z) {
        if (isChecked() != z) {
            b(z);
        }
        if (this.aOM) {
            setCheckedImmediatelyNoEvent(z);
        } else {
            super.setChecked(z);
        }
    }

    public void setCheckedImmediately(boolean z) {
        super.setChecked(z);
        ObjectAnimator objectAnimator = this.aOt;
        if (objectAnimator != null && objectAnimator.isRunning()) {
            this.aOt.cancel();
        }
        setProgress(z ? 1.0f : 0.0f);
        invalidate();
    }

    public void setCheckedImmediatelyNoEvent(boolean z) {
        if (this.aOP == null) {
            setCheckedImmediately(z);
            return;
        }
        super.setOnCheckedChangeListener(null);
        setCheckedImmediately(z);
        super.setOnCheckedChangeListener(this.aOP);
    }

    public void setCheckedNoEvent(boolean z) {
        if (this.aOP == null) {
            setChecked(z);
            return;
        }
        super.setOnCheckedChangeListener(null);
        setChecked(z);
        super.setOnCheckedChangeListener(this.aOP);
    }

    public void setDrawDebugRect(boolean z) {
        this.aOs = z;
        invalidate();
    }

    public void setFadeBack(boolean z) {
        this.ab = z;
    }

    @Override // android.widget.CompoundButton
    public void setOnCheckedChangeListener(CompoundButton.OnCheckedChangeListener onCheckedChangeListener) {
        super.setOnCheckedChangeListener(onCheckedChangeListener);
        this.aOP = onCheckedChangeListener;
    }

    public void setTextAdjust(int i) {
        this.aOL = i;
        this.aON = false;
        requestLayout();
        invalidate();
    }

    public void setTextExtra(int i) {
        this.aOK = i;
        this.aON = false;
        requestLayout();
        invalidate();
    }

    public void setTextThumbInset(int i) {
        this.aOJ = i;
        this.aON = false;
        requestLayout();
        invalidate();
    }

    public void setThumbColor(ColorStateList colorStateList) {
        this.aNS = colorStateList;
        if (this.aNS != null) {
            setThumbDrawable(null);
        }
        invalidate();
    }

    public void setThumbColorRes(int i) {
        setThumbColor(getResources().getColorStateList(i));
    }

    public void setThumbDrawable(Drawable drawable) {
        this.aNP = drawable;
        this.aOq = this.aNP != null;
        refreshDrawableState();
        this.aON = false;
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
        this.aNT = f;
        if (this.aOq) {
            return;
        }
        invalidate();
    }

    public void setThumbRangeRatio(float f) {
        this.aNW = f;
        this.aON = false;
        requestLayout();
    }

    public void setTintColor(int i) {
        this.aNY = i;
        this.aNS = com.baidu.poly.widget.b.dk(this.aNY);
        this.aNR = com.baidu.poly.widget.b.dl(this.aNY);
        this.aOr = false;
        this.aOq = false;
        refreshDrawableState();
        invalidate();
    }

    public SwitchButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aOs = false;
        this.aOM = false;
        this.aON = false;
        this.aOO = false;
        c(attributeSet);
    }

    public SwitchButton(Context context) {
        super(context);
        this.aOs = false;
        this.aOM = false;
        this.aON = false;
        this.aOO = false;
        c(null);
    }

    private Layout d(CharSequence charSequence) {
        TextPaint textPaint = this.aOE;
        return new StaticLayout(charSequence, textPaint, (int) Math.ceil(Layout.getDesiredWidth(charSequence, textPaint)), Layout.Alignment.ALIGN_CENTER, 1.0f, 0.0f, false);
    }

    public void a(float f, float f2, float f3, float f4) {
        this.aNV.set(f, f2, f3, f4);
        this.aON = false;
        requestLayout();
    }

    public void a(CharSequence charSequence, CharSequence charSequence2) {
        this.aOC = charSequence;
        this.aOD = charSequence2;
        this.aOF = null;
        this.aOG = null;
        this.aON = false;
        requestLayout();
        invalidate();
    }
}
