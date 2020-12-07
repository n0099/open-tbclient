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
/* loaded from: classes19.dex */
public class SwitchButton extends CompoundButton {
    private static int[] ciI = {16842912, 16842910, 16842919};
    private static int[] ciJ = {-16842912, 16842910, 16842919};
    private float ab;
    private float apv;
    private Drawable ciK;
    private Drawable ciL;
    private ColorStateList ciM;
    private ColorStateList ciN;
    private RectF ciO;
    private float ciP;
    private long ciQ;
    private boolean ciR;
    private int ciS;
    private int ciT;
    private int ciU;
    private int ciV;
    private int ciW;
    private int ciX;
    private int ciY;
    private int ciZ;
    private Layout cjA;
    private float cjB;
    private float cjC;
    private int cjD;
    private int cjE;
    private int cjF;
    private boolean cjG;
    private boolean cjH;
    private boolean cjI;
    private CompoundButton.OnCheckedChangeListener cjJ;
    private int cja;
    private int cjb;
    private Drawable cjc;
    private Drawable cjd;
    private RectF cje;
    private RectF cjf;
    private RectF cjg;
    private RectF cjh;
    private RectF cji;
    private Paint cjj;
    private boolean cjk;
    private boolean cjl;
    private boolean cjm;
    private ObjectAnimator cjn;
    private float cjo;
    private RectF cjp;
    private float cjq;
    private float cjr;
    private float cjs;
    private int cjt;
    private int cju;
    private Paint cjv;
    private CharSequence cjw;
    private CharSequence cjx;
    private TextPaint cjy;
    private Layout cjz;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes19.dex */
    public static class a extends View.BaseSavedState {
        public static final Parcelable.Creator<a> CREATOR = new C0322a();
        CharSequence cjK;
        CharSequence cjL;

        /* renamed from: com.baidu.poly.widget.SwitchButton$a$a  reason: collision with other inner class name */
        /* loaded from: classes19.dex */
        static class C0322a implements Parcelable.Creator<a> {
            C0322a() {
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // android.os.Parcelable.Creator
            /* renamed from: hq */
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
            TextUtils.writeToParcel(this.cjK, parcel, i);
            TextUtils.writeToParcel(this.cjL, parcel, i);
        }

        a(Parcelable parcelable) {
            super(parcelable);
        }

        private a(Parcel parcel) {
            super(parcel);
            this.cjK = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
            this.cjL = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
        }
    }

    public SwitchButton(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.cjm = false;
        this.cjG = false;
        this.cjH = false;
        this.cjI = false;
        c(attributeSet);
    }

    private void adT() {
        ViewParent parent = getParent();
        if (parent != null) {
            parent.requestDisallowInterceptTouchEvent(true);
        }
        this.cjI = true;
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
        this.cjt = ViewConfiguration.get(getContext()).getScaledTouchSlop();
        this.cju = ViewConfiguration.getPressedStateDuration() + ViewConfiguration.getTapTimeout();
        this.cjj = new Paint(1);
        this.cjv = new Paint(1);
        this.cjv.setStyle(Paint.Style.STROKE);
        this.cjv.setStrokeWidth(getResources().getDisplayMetrics().density);
        this.cjy = getPaint();
        this.cje = new RectF();
        this.cjf = new RectF();
        this.cjg = new RectF();
        this.ciO = new RectF();
        this.cjh = new RectF();
        this.cji = new RectF();
        this.cjn = ObjectAnimator.ofFloat(this, "progress", 0.0f, 0.0f).setDuration(250L);
        this.cjn.setInterpolator(new AccelerateDecelerateInterpolator());
        this.cjp = new RectF();
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
        this.cjw = str2;
        this.cjx = str;
        this.cjD = i4;
        this.cjE = i3;
        this.cjF = i5;
        this.ciK = drawable;
        this.ciN = colorStateList;
        this.cjk = this.ciK != null;
        this.ciS = i2;
        if (this.ciS == 0) {
            new TypedValue();
            this.ciS = 3309506;
        }
        if (!this.cjk && this.ciN == null) {
            this.ciN = com.baidu.poly.widget.b.hn(this.ciS);
            this.ciX = this.ciN.getDefaultColor();
        }
        this.ciT = p(f5);
        this.ciU = p(f6);
        this.ciL = drawable2;
        this.ciM = colorStateList2;
        this.cjl = this.ciL != null;
        if (!this.cjl && this.ciM == null) {
            this.ciM = com.baidu.poly.widget.b.ho(this.ciS);
            this.ciY = this.ciM.getDefaultColor();
            this.ciZ = this.ciM.getColorForState(ciI, this.ciY);
        }
        this.ciO.set(f, f3, f2, f4);
        this.ciP = this.ciO.width() >= 0.0f ? Math.max(f9, 1.0f) : f9;
        this.ab = f7;
        this.apv = f8;
        this.ciQ = i;
        this.ciR = z;
        this.cjn.setDuration(this.ciQ);
        if (isChecked()) {
            setProgress(1.0f);
        }
    }

    private float getProgress() {
        return this.cjo;
    }

    private boolean getStatusBasedOnPos() {
        return getProgress() > 0.5f;
    }

    private int hk(int i) {
        int i2;
        int size = View.MeasureSpec.getSize(i);
        int mode = View.MeasureSpec.getMode(i);
        if (this.ciT == 0 && this.cjk) {
            this.ciT = this.ciK.getIntrinsicWidth();
        }
        int p = p(this.cjB);
        if (this.ciP == 0.0f) {
            this.ciP = 1.8f;
        }
        if (mode == 1073741824) {
            int paddingLeft = (size - getPaddingLeft()) - getPaddingRight();
            if (this.ciT != 0) {
                int p2 = p(i2 * this.ciP);
                RectF rectF = this.ciO;
                int p3 = (this.cjE + p) - ((p2 - this.ciT) + p(Math.max(rectF.left, rectF.right)));
                float f = p2;
                RectF rectF2 = this.ciO;
                this.ciV = p(rectF2.right + rectF2.left + f + Math.max(p3, 0));
                if (this.ciV < 0) {
                    this.ciT = 0;
                }
                if (f + Math.max(this.ciO.left, 0.0f) + Math.max(this.ciO.right, 0.0f) + Math.max(p3, 0) > paddingLeft) {
                    this.ciT = 0;
                }
            }
            if (this.ciT == 0) {
                int p4 = p((((size - getPaddingLeft()) - getPaddingRight()) - Math.max(this.ciO.left, 0.0f)) - Math.max(this.ciO.right, 0.0f));
                if (p4 < 0) {
                    this.ciT = 0;
                    this.ciV = 0;
                    return size;
                }
                float f2 = p4;
                this.ciT = p(f2 / this.ciP);
                RectF rectF3 = this.ciO;
                this.ciV = p(f2 + rectF3.left + rectF3.right);
                if (this.ciV < 0) {
                    this.ciT = 0;
                    this.ciV = 0;
                    return size;
                }
                int i3 = p + this.cjE;
                int i4 = p4 - this.ciT;
                RectF rectF4 = this.ciO;
                int p5 = i3 - (i4 + p(Math.max(rectF4.left, rectF4.right)));
                if (p5 > 0) {
                    this.ciT -= p5;
                }
                if (this.ciT < 0) {
                    this.ciT = 0;
                    this.ciV = 0;
                    return size;
                }
                return size;
            }
            return size;
        }
        if (this.ciT == 0) {
            this.ciT = p(getResources().getDisplayMetrics().density * 20.0f);
        }
        if (this.ciP == 0.0f) {
            this.ciP = 1.8f;
        }
        int p6 = p(this.ciT * this.ciP);
        RectF rectF5 = this.ciO;
        int p7 = p((p + this.cjE) - (((p6 - this.ciT) + Math.max(rectF5.left, rectF5.right)) + this.cjD));
        float f3 = p6;
        RectF rectF6 = this.ciO;
        this.ciV = p(rectF6.right + rectF6.left + f3 + Math.max(0, p7));
        if (this.ciV < 0) {
            this.ciT = 0;
            this.ciV = 0;
            return size;
        }
        int p8 = p(Math.max(0.0f, this.ciO.left) + f3 + Math.max(0.0f, this.ciO.right) + Math.max(0, p7));
        return Math.max(p8, getPaddingLeft() + p8 + getPaddingRight());
    }

    private int hl(int i) {
        int i2;
        int i3;
        int i4;
        int size = View.MeasureSpec.getSize(i);
        int mode = View.MeasureSpec.getMode(i);
        if (this.ciU == 0 && this.cjk) {
            this.ciU = this.ciK.getIntrinsicHeight();
        }
        if (mode == 1073741824) {
            if (this.ciU != 0) {
                RectF rectF = this.ciO;
                this.ciW = p(i3 + rectF.top + rectF.bottom);
                this.ciW = p(Math.max(this.ciW, this.cjC));
                if ((((this.ciW + getPaddingTop()) + getPaddingBottom()) - Math.min(0.0f, this.ciO.top)) - Math.min(0.0f, this.ciO.bottom) > size) {
                    this.ciU = 0;
                }
            }
            if (this.ciU == 0) {
                this.ciW = p(((size - getPaddingTop()) - getPaddingBottom()) + Math.min(0.0f, this.ciO.top) + Math.min(0.0f, this.ciO.bottom));
                if (this.ciW < 0) {
                    this.ciW = 0;
                    this.ciU = 0;
                    return size;
                }
                RectF rectF2 = this.ciO;
                this.ciU = p((i4 - rectF2.top) - rectF2.bottom);
            }
            if (this.ciU < 0) {
                this.ciW = 0;
                this.ciU = 0;
                return size;
            }
            return size;
        }
        if (this.ciU == 0) {
            this.ciU = p(getResources().getDisplayMetrics().density * 20.0f);
        }
        RectF rectF3 = this.ciO;
        this.ciW = p(this.ciU + rectF3.top + rectF3.bottom);
        if (this.ciW < 0) {
            this.ciW = 0;
            this.ciU = 0;
            return size;
        }
        int p = p(this.cjC - i2);
        if (p > 0) {
            this.ciW += p;
            this.ciU = p + this.ciU;
        }
        int max = Math.max(this.ciU, this.ciW);
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
        this.cjo = f;
        invalidate();
    }

    private void setup() {
        int i;
        float paddingTop;
        float paddingLeft;
        int i2 = this.ciT;
        if (i2 != 0 && (i = this.ciU) != 0 && this.ciV != 0 && this.ciW != 0) {
            if (this.ab == -1.0f) {
                this.ab = Math.min(i2, i) / 2;
            }
            if (this.apv == -1.0f) {
                this.apv = Math.min(this.ciV, this.ciW) / 2;
            }
            int measuredWidth = (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight();
            int measuredHeight = (getMeasuredHeight() - getPaddingTop()) - getPaddingBottom();
            int p = p((this.ciV - Math.min(0.0f, this.ciO.left)) - Math.min(0.0f, this.ciO.right));
            int p2 = p((this.ciW - Math.min(0.0f, this.ciO.top)) - Math.min(0.0f, this.ciO.bottom));
            if (measuredHeight <= p2) {
                paddingTop = getPaddingTop() + Math.max(0.0f, this.ciO.top);
            } else {
                paddingTop = (((measuredHeight - p2) + 1) / 2) + getPaddingTop() + Math.max(0.0f, this.ciO.top);
            }
            if (measuredWidth <= this.ciV) {
                paddingLeft = getPaddingLeft() + Math.max(0.0f, this.ciO.left);
            } else {
                paddingLeft = (((measuredWidth - p) + 1) / 2) + getPaddingLeft() + Math.max(0.0f, this.ciO.left);
            }
            this.cje.set(paddingLeft, paddingTop, this.ciT + paddingLeft, this.ciU + paddingTop);
            RectF rectF = this.cje;
            float f = rectF.left;
            RectF rectF2 = this.ciO;
            float f2 = f - rectF2.left;
            RectF rectF3 = this.cjf;
            float f3 = rectF.top;
            float f4 = rectF2.top;
            rectF3.set(f2, f3 - f4, this.ciV + f2, (f3 - f4) + this.ciW);
            RectF rectF4 = this.cjg;
            RectF rectF5 = this.cje;
            rectF4.set(rectF5.left, 0.0f, (this.cjf.right - this.ciO.right) - rectF5.width(), 0.0f);
            this.apv = Math.min(Math.min(this.cjf.width(), this.cjf.height()) / 2.0f, this.apv);
            Drawable drawable = this.ciL;
            if (drawable != null) {
                RectF rectF6 = this.cjf;
                drawable.setBounds((int) rectF6.left, (int) rectF6.top, p(rectF6.right), p(this.cjf.bottom));
            }
            if (this.cjz != null) {
                RectF rectF7 = this.cjf;
                float width = ((((((rectF7.width() + this.cjD) - this.ciT) - this.ciO.right) - this.cjz.getWidth()) / 2.0f) + rectF7.left) - this.cjF;
                RectF rectF8 = this.cjf;
                float height = ((rectF8.height() - this.cjz.getHeight()) / 2.0f) + rectF8.top;
                this.cjh.set(width, height, this.cjz.getWidth() + width, this.cjz.getHeight() + height);
            }
            if (this.cjA != null) {
                RectF rectF9 = this.cjf;
                float width2 = ((rectF9.right - (((((rectF9.width() + this.cjD) - this.ciT) - this.ciO.left) - this.cjA.getWidth()) / 2.0f)) - this.cjA.getWidth()) + this.cjF;
                RectF rectF10 = this.cjf;
                float height2 = ((rectF10.height() - this.cjA.getHeight()) / 2.0f) + rectF10.top;
                this.cji.set(width2, height2, this.cjA.getWidth() + width2, this.cjA.getHeight() + height2);
            }
            this.cjH = true;
        }
    }

    protected void b(boolean z) {
        ObjectAnimator objectAnimator = this.cjn;
        if (objectAnimator != null) {
            if (objectAnimator.isRunning()) {
                this.cjn.cancel();
            }
            this.cjn.setDuration(this.ciQ);
            if (z) {
                this.cjn.setFloatValues(this.cjo, 1.0f);
            } else {
                this.cjn.setFloatValues(this.cjo, 0.0f);
            }
            this.cjn.start();
        }
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    protected void drawableStateChanged() {
        ColorStateList colorStateList;
        ColorStateList colorStateList2;
        super.drawableStateChanged();
        if (!this.cjk && (colorStateList2 = this.ciN) != null) {
            this.ciX = colorStateList2.getColorForState(getDrawableState(), this.ciX);
        } else {
            setDrawableState(this.ciK);
        }
        int[] iArr = isChecked() ? ciJ : ciI;
        ColorStateList textColors = getTextColors();
        if (textColors != null) {
            int defaultColor = textColors.getDefaultColor();
            this.cja = textColors.getColorForState(ciI, defaultColor);
            this.cjb = textColors.getColorForState(ciJ, defaultColor);
        }
        if (!this.cjl && (colorStateList = this.ciM) != null) {
            this.ciY = colorStateList.getColorForState(getDrawableState(), this.ciY);
            this.ciZ = this.ciM.getColorForState(iArr, this.ciY);
            return;
        }
        Drawable drawable = this.ciL;
        if ((drawable instanceof StateListDrawable) && this.ciR) {
            drawable.setState(iArr);
            this.cjd = this.ciL.getCurrent().mutate();
        } else {
            this.cjd = null;
        }
        setDrawableState(this.ciL);
        Drawable drawable2 = this.ciL;
        if (drawable2 != null) {
            this.cjc = drawable2.getCurrent().mutate();
        }
    }

    public long getAnimationDuration() {
        return this.ciQ;
    }

    public ColorStateList getBackColor() {
        return this.ciM;
    }

    public Drawable getBackDrawable() {
        return this.ciL;
    }

    public float getBackRadius() {
        return this.apv;
    }

    public PointF getBackSizeF() {
        return new PointF(this.cjf.width(), this.cjf.height());
    }

    public CharSequence getTextOff() {
        return this.cjx;
    }

    public CharSequence getTextOn() {
        return this.cjw;
    }

    public ColorStateList getThumbColor() {
        return this.ciN;
    }

    public Drawable getThumbDrawable() {
        return this.ciK;
    }

    public float getThumbHeight() {
        return this.ciU;
    }

    public RectF getThumbMargin() {
        return this.ciO;
    }

    public float getThumbRadius() {
        return this.ab;
    }

    public float getThumbRangeRatio() {
        return this.ciP;
    }

    public float getThumbWidth() {
        return this.ciT;
    }

    public int getTintColor() {
        return this.ciS;
    }

    public void o() {
        if (this.cjJ == null) {
            toggle();
            return;
        }
        super.setOnCheckedChangeListener(null);
        toggle();
        super.setOnCheckedChangeListener(this.cjJ);
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (!this.cjH) {
            setup();
        }
        if (this.cjH) {
            if (this.cjl) {
                if (this.ciR && this.cjc != null && this.cjd != null) {
                    Drawable drawable = isChecked() ? this.cjc : this.cjd;
                    Drawable drawable2 = isChecked() ? this.cjd : this.cjc;
                    int progress = (int) (getProgress() * 255.0f);
                    drawable.setAlpha(progress);
                    drawable.draw(canvas);
                    drawable2.setAlpha(255 - progress);
                    drawable2.draw(canvas);
                } else {
                    this.ciL.setAlpha(255);
                    this.ciL.draw(canvas);
                }
            } else if (this.ciR) {
                int i = isChecked() ? this.ciY : this.ciZ;
                int i2 = isChecked() ? this.ciZ : this.ciY;
                int progress2 = (int) (getProgress() * 255.0f);
                this.cjj.setARGB((Color.alpha(i) * progress2) / 255, Color.red(i), Color.green(i), Color.blue(i));
                RectF rectF = this.cjf;
                float f = this.apv;
                canvas.drawRoundRect(rectF, f, f, this.cjj);
                this.cjj.setARGB(((255 - progress2) * Color.alpha(i2)) / 255, Color.red(i2), Color.green(i2), Color.blue(i2));
                RectF rectF2 = this.cjf;
                float f2 = this.apv;
                canvas.drawRoundRect(rectF2, f2, f2, this.cjj);
                this.cjj.setAlpha(255);
            } else {
                this.cjj.setColor(this.ciY);
                RectF rectF3 = this.cjf;
                float f3 = this.apv;
                canvas.drawRoundRect(rectF3, f3, f3, this.cjj);
            }
            Layout layout = ((double) getProgress()) > 0.5d ? this.cjz : this.cjA;
            RectF rectF4 = ((double) getProgress()) > 0.5d ? this.cjh : this.cji;
            if (layout != null && rectF4 != null) {
                int progress3 = (int) ((((double) getProgress()) >= 0.75d ? (getProgress() * 4.0f) - 3.0f : ((double) getProgress()) < 0.25d ? 1.0f - (getProgress() * 4.0f) : 0.0f) * 255.0f);
                int i3 = ((double) getProgress()) > 0.5d ? this.cja : this.cjb;
                layout.getPaint().setARGB((progress3 * Color.alpha(i3)) / 255, Color.red(i3), Color.green(i3), Color.blue(i3));
                canvas.save();
                canvas.translate(rectF4.left, rectF4.top);
                layout.draw(canvas);
                canvas.restore();
            }
            this.cjp.set(this.cje);
            this.cjp.offset(this.cjo * this.cjg.width(), 0.0f);
            if (this.cjk) {
                Drawable drawable3 = this.ciK;
                RectF rectF5 = this.cjp;
                drawable3.setBounds((int) rectF5.left, (int) rectF5.top, p(rectF5.right), p(this.cjp.bottom));
                this.ciK.draw(canvas);
            } else {
                this.cjj.setColor(this.ciX);
                RectF rectF6 = this.cjp;
                float f4 = this.ab;
                canvas.drawRoundRect(rectF6, f4, f4, this.cjj);
            }
            if (this.cjm) {
                this.cjv.setColor(Color.parseColor("#AA0000"));
                canvas.drawRect(this.cjf, this.cjv);
                this.cjv.setColor(Color.parseColor("#0000FF"));
                canvas.drawRect(this.cjp, this.cjv);
                this.cjv.setColor(Color.parseColor("#000000"));
                RectF rectF7 = this.cjg;
                float f5 = rectF7.left;
                float f6 = this.cje.top;
                canvas.drawLine(f5, f6, rectF7.right, f6, this.cjv);
                this.cjv.setColor(Color.parseColor("#00CC00"));
                canvas.drawRect(((double) getProgress()) > 0.5d ? this.cjh : this.cji, this.cjv);
            }
        }
    }

    @Override // android.widget.TextView, android.view.View
    protected void onMeasure(int i, int i2) {
        if (this.cjz == null && !TextUtils.isEmpty(this.cjw)) {
            this.cjz = e(this.cjw);
        }
        if (this.cjA == null && !TextUtils.isEmpty(this.cjx)) {
            this.cjA = e(this.cjx);
        }
        Layout layout = this.cjz;
        float width = layout != null ? layout.getWidth() : 0.0f;
        Layout layout2 = this.cjA;
        float width2 = layout2 != null ? layout2.getWidth() : 0.0f;
        if (width == 0.0f && width2 == 0.0f) {
            this.cjB = 0.0f;
        } else {
            this.cjB = Math.max(width, width2);
        }
        Layout layout3 = this.cjz;
        float height = layout3 != null ? layout3.getHeight() : 0.0f;
        Layout layout4 = this.cjA;
        float height2 = layout4 != null ? layout4.getHeight() : 0.0f;
        if (height == 0.0f && height2 == 0.0f) {
            this.cjC = 0.0f;
        } else {
            this.cjC = Math.max(height, height2);
        }
        setMeasuredDimension(hk(i), hl(i2));
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        a aVar = (a) parcelable;
        a(aVar.cjK, aVar.cjL);
        this.cjG = true;
        super.onRestoreInstanceState(aVar.getSuperState());
        this.cjG = false;
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    public Parcelable onSaveInstanceState() {
        a aVar = new a(super.onSaveInstanceState());
        aVar.cjK = this.cjw;
        aVar.cjL = this.cjx;
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
        if (isEnabled() && isClickable() && isFocusable() && this.cjH) {
            int action = motionEvent.getAction();
            float x = motionEvent.getX() - this.cjq;
            float y = motionEvent.getY() - this.cjr;
            switch (action) {
                case 0:
                    this.cjq = motionEvent.getX();
                    this.cjr = motionEvent.getY();
                    this.cjs = this.cjq;
                    setPressed(true);
                    break;
                case 1:
                case 3:
                    this.cjI = false;
                    setPressed(false);
                    float eventTime = (float) (motionEvent.getEventTime() - motionEvent.getDownTime());
                    if (Math.abs(x) < this.cjt && Math.abs(y) < this.cjt && eventTime < this.cju) {
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
                    setProgress(getProgress() + ((x2 - this.cjs) / this.cjg.width()));
                    if (!this.cjI && (Math.abs(x) > this.cjt / 2 || Math.abs(y) > this.cjt / 2)) {
                        if (y != 0.0f && Math.abs(x) <= Math.abs(y)) {
                            if (Math.abs(y) > Math.abs(x)) {
                                return false;
                            }
                        } else {
                            adT();
                        }
                    }
                    this.cjs = x2;
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
        this.ciQ = j;
    }

    public void setBackColor(ColorStateList colorStateList) {
        this.ciM = colorStateList;
        if (this.ciM != null) {
            setBackDrawable(null);
        }
        invalidate();
    }

    public void setBackColorRes(int i) {
        setBackColor(getResources().getColorStateList(i));
    }

    public void setBackDrawable(Drawable drawable) {
        this.ciL = drawable;
        this.cjl = this.ciL != null;
        refreshDrawableState();
        this.cjH = false;
        requestLayout();
        invalidate();
    }

    public void setBackDrawableRes(int i) {
        setBackDrawable(getResources().getDrawable(i));
    }

    public void setBackRadius(float f) {
        this.apv = f;
        if (this.cjl) {
            return;
        }
        invalidate();
    }

    @Override // android.widget.CompoundButton, android.widget.Checkable
    public void setChecked(boolean z) {
        if (isChecked() != z) {
            b(z);
        }
        if (this.cjG) {
            setCheckedImmediatelyNoEvent(z);
        } else {
            super.setChecked(z);
        }
    }

    public void setCheckedImmediately(boolean z) {
        super.setChecked(z);
        ObjectAnimator objectAnimator = this.cjn;
        if (objectAnimator != null && objectAnimator.isRunning()) {
            this.cjn.cancel();
        }
        setProgress(z ? 1.0f : 0.0f);
        invalidate();
    }

    public void setCheckedImmediatelyNoEvent(boolean z) {
        if (this.cjJ == null) {
            setCheckedImmediately(z);
            return;
        }
        super.setOnCheckedChangeListener(null);
        setCheckedImmediately(z);
        super.setOnCheckedChangeListener(this.cjJ);
    }

    public void setCheckedNoEvent(boolean z) {
        if (this.cjJ == null) {
            setChecked(z);
            return;
        }
        super.setOnCheckedChangeListener(null);
        setChecked(z);
        super.setOnCheckedChangeListener(this.cjJ);
    }

    public void setDrawDebugRect(boolean z) {
        this.cjm = z;
        invalidate();
    }

    public void setFadeBack(boolean z) {
        this.ciR = z;
    }

    @Override // android.widget.CompoundButton
    public void setOnCheckedChangeListener(CompoundButton.OnCheckedChangeListener onCheckedChangeListener) {
        super.setOnCheckedChangeListener(onCheckedChangeListener);
        this.cjJ = onCheckedChangeListener;
    }

    public void setTextAdjust(int i) {
        this.cjF = i;
        this.cjH = false;
        requestLayout();
        invalidate();
    }

    public void setTextExtra(int i) {
        this.cjE = i;
        this.cjH = false;
        requestLayout();
        invalidate();
    }

    public void setTextThumbInset(int i) {
        this.cjD = i;
        this.cjH = false;
        requestLayout();
        invalidate();
    }

    public void setThumbColor(ColorStateList colorStateList) {
        this.ciN = colorStateList;
        if (this.ciN != null) {
            setThumbDrawable(null);
        }
        invalidate();
    }

    public void setThumbColorRes(int i) {
        setThumbColor(getResources().getColorStateList(i));
    }

    public void setThumbDrawable(Drawable drawable) {
        this.ciK = drawable;
        this.cjk = this.ciK != null;
        refreshDrawableState();
        this.cjH = false;
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
        if (this.cjk) {
            return;
        }
        invalidate();
    }

    public void setThumbRangeRatio(float f) {
        this.ciP = f;
        this.cjH = false;
        requestLayout();
    }

    public void setTintColor(int i) {
        this.ciS = i;
        this.ciN = com.baidu.poly.widget.b.hn(this.ciS);
        this.ciM = com.baidu.poly.widget.b.ho(this.ciS);
        this.cjl = false;
        this.cjk = false;
        refreshDrawableState();
        invalidate();
    }

    public SwitchButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.cjm = false;
        this.cjG = false;
        this.cjH = false;
        this.cjI = false;
        c(attributeSet);
    }

    public SwitchButton(Context context) {
        super(context);
        this.cjm = false;
        this.cjG = false;
        this.cjH = false;
        this.cjI = false;
        c(null);
    }

    private Layout e(CharSequence charSequence) {
        TextPaint textPaint = this.cjy;
        return new StaticLayout(charSequence, textPaint, (int) Math.ceil(Layout.getDesiredWidth(charSequence, textPaint)), Layout.Alignment.ALIGN_CENTER, 1.0f, 0.0f, false);
    }

    public void a(float f, float f2, float f3, float f4) {
        this.ciO.set(f, f2, f3, f4);
        this.cjH = false;
        requestLayout();
    }

    public void a(CharSequence charSequence, CharSequence charSequence2) {
        this.cjw = charSequence;
        this.cjx = charSequence2;
        this.cjz = null;
        this.cjA = null;
        this.cjH = false;
        requestLayout();
        invalidate();
    }
}
