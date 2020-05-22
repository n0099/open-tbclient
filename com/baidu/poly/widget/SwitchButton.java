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
    private static int[] bwi = {16842912, 16842910, 16842919};
    private static int[] bwj = {-16842912, 16842910, 16842919};
    private float ab;
    private int bwA;
    private int bwB;
    private int bwC;
    private Drawable bwD;
    private Drawable bwE;
    private RectF bwF;
    private RectF bwG;
    private RectF bwH;
    private RectF bwI;
    private RectF bwJ;
    private Paint bwK;
    private boolean bwL;
    private boolean bwM;
    private boolean bwN;
    private ObjectAnimator bwO;
    private float bwP;
    private RectF bwQ;
    private float bwR;
    private float bwS;
    private float bwT;
    private int bwU;
    private int bwV;
    private Paint bwW;
    private CharSequence bwX;
    private CharSequence bwY;
    private TextPaint bwZ;
    private Drawable bwk;
    private Drawable bwl;
    private ColorStateList bwm;
    private ColorStateList bwn;
    private float bwo;
    private float bwp;
    private RectF bwq;
    private long bwr;
    private boolean bws;
    private int bwt;
    private int bwu;
    private int bwv;
    private int bww;
    private int bwx;
    private int bwy;
    private int bwz;
    private Layout bxa;
    private Layout bxb;
    private float bxc;
    private float bxd;
    private int bxe;
    private int bxf;
    private int bxg;
    private boolean bxh;
    private boolean bxi;
    private boolean bxj;
    private CompoundButton.OnCheckedChangeListener bxk;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes11.dex */
    public static class a extends View.BaseSavedState {
        public static final Parcelable.Creator<a> CREATOR = new C0244a();
        CharSequence bxl;
        CharSequence bxm;

        /* renamed from: com.baidu.poly.widget.SwitchButton$a$a  reason: collision with other inner class name */
        /* loaded from: classes11.dex */
        static class C0244a implements Parcelable.Creator<a> {
            C0244a() {
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // android.os.Parcelable.Creator
            /* renamed from: dP */
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
            TextUtils.writeToParcel(this.bxl, parcel, i);
            TextUtils.writeToParcel(this.bxm, parcel, i);
        }

        a(Parcelable parcelable) {
            super(parcelable);
        }

        private a(Parcel parcel) {
            super(parcel);
            this.bxl = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
            this.bxm = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
        }
    }

    public SwitchButton(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.bwN = false;
        this.bxh = false;
        this.bxi = false;
        this.bxj = false;
        c(attributeSet);
    }

    private void Nk() {
        ViewParent parent = getParent();
        if (parent != null) {
            parent.requestDisallowInterceptTouchEvent(true);
        }
        this.bxj = true;
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
        this.bwU = ViewConfiguration.get(getContext()).getScaledTouchSlop();
        this.bwV = ViewConfiguration.getPressedStateDuration() + ViewConfiguration.getTapTimeout();
        this.bwK = new Paint(1);
        this.bwW = new Paint(1);
        this.bwW.setStyle(Paint.Style.STROKE);
        this.bwW.setStrokeWidth(getResources().getDisplayMetrics().density);
        this.bwZ = getPaint();
        this.bwF = new RectF();
        this.bwG = new RectF();
        this.bwH = new RectF();
        this.bwq = new RectF();
        this.bwI = new RectF();
        this.bwJ = new RectF();
        this.bwO = ObjectAnimator.ofFloat(this, "progress", 0.0f, 0.0f).setDuration(250L);
        this.bwO.setInterpolator(new AccelerateDecelerateInterpolator());
        this.bwQ = new RectF();
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
        this.bwX = str2;
        this.bwY = str;
        this.bxe = i4;
        this.bxf = i3;
        this.bxg = i5;
        this.bwk = drawable;
        this.bwn = colorStateList;
        this.bwL = this.bwk != null;
        this.bwt = i2;
        if (this.bwt == 0) {
            new TypedValue();
            this.bwt = 3309506;
        }
        if (!this.bwL && this.bwn == null) {
            this.bwn = com.baidu.poly.widget.b.dM(this.bwt);
            this.bwy = this.bwn.getDefaultColor();
        }
        this.bwu = j(f5);
        this.bwv = j(f6);
        this.bwl = drawable2;
        this.bwm = colorStateList2;
        this.bwM = this.bwl != null;
        if (!this.bwM && this.bwm == null) {
            this.bwm = com.baidu.poly.widget.b.dN(this.bwt);
            this.bwz = this.bwm.getDefaultColor();
            this.bwA = this.bwm.getColorForState(bwi, this.bwz);
        }
        this.bwq.set(f, f3, f2, f4);
        this.ab = this.bwq.width() >= 0.0f ? Math.max(f9, 1.0f) : f9;
        this.bwo = f7;
        this.bwp = f8;
        this.bwr = i;
        this.bws = z;
        this.bwO.setDuration(this.bwr);
        if (isChecked()) {
            setProgress(1.0f);
        }
    }

    private int dK(int i) {
        int i2;
        int size = View.MeasureSpec.getSize(i);
        int mode = View.MeasureSpec.getMode(i);
        if (this.bwu == 0 && this.bwL) {
            this.bwu = this.bwk.getIntrinsicWidth();
        }
        int j = j(this.bxc);
        if (this.ab == 0.0f) {
            this.ab = 1.8f;
        }
        if (mode == 1073741824) {
            int paddingLeft = (size - getPaddingLeft()) - getPaddingRight();
            if (this.bwu != 0) {
                int j2 = j(i2 * this.ab);
                RectF rectF = this.bwq;
                int j3 = (this.bxf + j) - ((j2 - this.bwu) + j(Math.max(rectF.left, rectF.right)));
                float f = j2;
                RectF rectF2 = this.bwq;
                this.bww = j(rectF2.right + rectF2.left + f + Math.max(j3, 0));
                if (this.bww < 0) {
                    this.bwu = 0;
                }
                if (f + Math.max(this.bwq.left, 0.0f) + Math.max(this.bwq.right, 0.0f) + Math.max(j3, 0) > paddingLeft) {
                    this.bwu = 0;
                }
            }
            if (this.bwu == 0) {
                int j4 = j((((size - getPaddingLeft()) - getPaddingRight()) - Math.max(this.bwq.left, 0.0f)) - Math.max(this.bwq.right, 0.0f));
                if (j4 < 0) {
                    this.bwu = 0;
                    this.bww = 0;
                    return size;
                }
                float f2 = j4;
                this.bwu = j(f2 / this.ab);
                RectF rectF3 = this.bwq;
                this.bww = j(f2 + rectF3.left + rectF3.right);
                if (this.bww < 0) {
                    this.bwu = 0;
                    this.bww = 0;
                    return size;
                }
                int i3 = j + this.bxf;
                int i4 = j4 - this.bwu;
                RectF rectF4 = this.bwq;
                int j5 = i3 - (i4 + j(Math.max(rectF4.left, rectF4.right)));
                if (j5 > 0) {
                    this.bwu -= j5;
                }
                if (this.bwu < 0) {
                    this.bwu = 0;
                    this.bww = 0;
                    return size;
                }
                return size;
            }
            return size;
        }
        if (this.bwu == 0) {
            this.bwu = j(getResources().getDisplayMetrics().density * 20.0f);
        }
        if (this.ab == 0.0f) {
            this.ab = 1.8f;
        }
        int j6 = j(this.bwu * this.ab);
        RectF rectF5 = this.bwq;
        int j7 = j((j + this.bxf) - (((j6 - this.bwu) + Math.max(rectF5.left, rectF5.right)) + this.bxe));
        float f3 = j6;
        RectF rectF6 = this.bwq;
        this.bww = j(rectF6.right + rectF6.left + f3 + Math.max(0, j7));
        if (this.bww < 0) {
            this.bwu = 0;
            this.bww = 0;
            return size;
        }
        int j8 = j(Math.max(0.0f, this.bwq.left) + f3 + Math.max(0.0f, this.bwq.right) + Math.max(0, j7));
        return Math.max(j8, getPaddingLeft() + j8 + getPaddingRight());
    }

    private float getProgress() {
        return this.bwP;
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
        if (this.bwv == 0 && this.bwL) {
            this.bwv = this.bwk.getIntrinsicHeight();
        }
        if (mode == 1073741824) {
            if (this.bwv != 0) {
                RectF rectF = this.bwq;
                this.bwx = j(i3 + rectF.top + rectF.bottom);
                this.bwx = j(Math.max(this.bwx, this.bxd));
                if ((((this.bwx + getPaddingTop()) + getPaddingBottom()) - Math.min(0.0f, this.bwq.top)) - Math.min(0.0f, this.bwq.bottom) > size) {
                    this.bwv = 0;
                }
            }
            if (this.bwv == 0) {
                this.bwx = j(((size - getPaddingTop()) - getPaddingBottom()) + Math.min(0.0f, this.bwq.top) + Math.min(0.0f, this.bwq.bottom));
                if (this.bwx < 0) {
                    this.bwx = 0;
                    this.bwv = 0;
                    return size;
                }
                RectF rectF2 = this.bwq;
                this.bwv = j((i4 - rectF2.top) - rectF2.bottom);
            }
            if (this.bwv < 0) {
                this.bwx = 0;
                this.bwv = 0;
                return size;
            }
            return size;
        }
        if (this.bwv == 0) {
            this.bwv = j(getResources().getDisplayMetrics().density * 20.0f);
        }
        RectF rectF3 = this.bwq;
        this.bwx = j(this.bwv + rectF3.top + rectF3.bottom);
        if (this.bwx < 0) {
            this.bwx = 0;
            this.bwv = 0;
            return size;
        }
        int j = j(this.bxd - i2);
        if (j > 0) {
            this.bwx += j;
            this.bwv = j + this.bwv;
        }
        int max = Math.max(this.bwv, this.bwx);
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
        this.bwP = f;
        invalidate();
    }

    private void setup() {
        int i;
        float paddingTop;
        float paddingLeft;
        int i2 = this.bwu;
        if (i2 != 0 && (i = this.bwv) != 0 && this.bww != 0 && this.bwx != 0) {
            if (this.bwo == -1.0f) {
                this.bwo = Math.min(i2, i) / 2;
            }
            if (this.bwp == -1.0f) {
                this.bwp = Math.min(this.bww, this.bwx) / 2;
            }
            int measuredWidth = (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight();
            int measuredHeight = (getMeasuredHeight() - getPaddingTop()) - getPaddingBottom();
            int j = j((this.bww - Math.min(0.0f, this.bwq.left)) - Math.min(0.0f, this.bwq.right));
            int j2 = j((this.bwx - Math.min(0.0f, this.bwq.top)) - Math.min(0.0f, this.bwq.bottom));
            if (measuredHeight <= j2) {
                paddingTop = getPaddingTop() + Math.max(0.0f, this.bwq.top);
            } else {
                paddingTop = (((measuredHeight - j2) + 1) / 2) + getPaddingTop() + Math.max(0.0f, this.bwq.top);
            }
            if (measuredWidth <= this.bww) {
                paddingLeft = getPaddingLeft() + Math.max(0.0f, this.bwq.left);
            } else {
                paddingLeft = (((measuredWidth - j) + 1) / 2) + getPaddingLeft() + Math.max(0.0f, this.bwq.left);
            }
            this.bwF.set(paddingLeft, paddingTop, this.bwu + paddingLeft, this.bwv + paddingTop);
            RectF rectF = this.bwF;
            float f = rectF.left;
            RectF rectF2 = this.bwq;
            float f2 = f - rectF2.left;
            RectF rectF3 = this.bwG;
            float f3 = rectF.top;
            float f4 = rectF2.top;
            rectF3.set(f2, f3 - f4, this.bww + f2, (f3 - f4) + this.bwx);
            RectF rectF4 = this.bwH;
            RectF rectF5 = this.bwF;
            rectF4.set(rectF5.left, 0.0f, (this.bwG.right - this.bwq.right) - rectF5.width(), 0.0f);
            this.bwp = Math.min(Math.min(this.bwG.width(), this.bwG.height()) / 2.0f, this.bwp);
            Drawable drawable = this.bwl;
            if (drawable != null) {
                RectF rectF6 = this.bwG;
                drawable.setBounds((int) rectF6.left, (int) rectF6.top, j(rectF6.right), j(this.bwG.bottom));
            }
            if (this.bxa != null) {
                RectF rectF7 = this.bwG;
                float width = ((((((rectF7.width() + this.bxe) - this.bwu) - this.bwq.right) - this.bxa.getWidth()) / 2.0f) + rectF7.left) - this.bxg;
                RectF rectF8 = this.bwG;
                float height = ((rectF8.height() - this.bxa.getHeight()) / 2.0f) + rectF8.top;
                this.bwI.set(width, height, this.bxa.getWidth() + width, this.bxa.getHeight() + height);
            }
            if (this.bxb != null) {
                RectF rectF9 = this.bwG;
                float width2 = ((rectF9.right - (((((rectF9.width() + this.bxe) - this.bwu) - this.bwq.left) - this.bxb.getWidth()) / 2.0f)) - this.bxb.getWidth()) + this.bxg;
                RectF rectF10 = this.bwG;
                float height2 = ((rectF10.height() - this.bxb.getHeight()) / 2.0f) + rectF10.top;
                this.bwJ.set(width2, height2, this.bxb.getWidth() + width2, this.bxb.getHeight() + height2);
            }
            this.bxi = true;
        }
    }

    protected void b(boolean z) {
        ObjectAnimator objectAnimator = this.bwO;
        if (objectAnimator != null) {
            if (objectAnimator.isRunning()) {
                this.bwO.cancel();
            }
            this.bwO.setDuration(this.bwr);
            if (z) {
                this.bwO.setFloatValues(this.bwP, 1.0f);
            } else {
                this.bwO.setFloatValues(this.bwP, 0.0f);
            }
            this.bwO.start();
        }
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    protected void drawableStateChanged() {
        ColorStateList colorStateList;
        ColorStateList colorStateList2;
        super.drawableStateChanged();
        if (!this.bwL && (colorStateList2 = this.bwn) != null) {
            this.bwy = colorStateList2.getColorForState(getDrawableState(), this.bwy);
        } else {
            setDrawableState(this.bwk);
        }
        int[] iArr = isChecked() ? bwj : bwi;
        ColorStateList textColors = getTextColors();
        if (textColors != null) {
            int defaultColor = textColors.getDefaultColor();
            this.bwB = textColors.getColorForState(bwi, defaultColor);
            this.bwC = textColors.getColorForState(bwj, defaultColor);
        }
        if (!this.bwM && (colorStateList = this.bwm) != null) {
            this.bwz = colorStateList.getColorForState(getDrawableState(), this.bwz);
            this.bwA = this.bwm.getColorForState(iArr, this.bwz);
            return;
        }
        Drawable drawable = this.bwl;
        if ((drawable instanceof StateListDrawable) && this.bws) {
            drawable.setState(iArr);
            this.bwE = this.bwl.getCurrent().mutate();
        } else {
            this.bwE = null;
        }
        setDrawableState(this.bwl);
        Drawable drawable2 = this.bwl;
        if (drawable2 != null) {
            this.bwD = drawable2.getCurrent().mutate();
        }
    }

    public long getAnimationDuration() {
        return this.bwr;
    }

    public ColorStateList getBackColor() {
        return this.bwm;
    }

    public Drawable getBackDrawable() {
        return this.bwl;
    }

    public float getBackRadius() {
        return this.bwp;
    }

    public PointF getBackSizeF() {
        return new PointF(this.bwG.width(), this.bwG.height());
    }

    public CharSequence getTextOff() {
        return this.bwY;
    }

    public CharSequence getTextOn() {
        return this.bwX;
    }

    public ColorStateList getThumbColor() {
        return this.bwn;
    }

    public Drawable getThumbDrawable() {
        return this.bwk;
    }

    public float getThumbHeight() {
        return this.bwv;
    }

    public RectF getThumbMargin() {
        return this.bwq;
    }

    public float getThumbRadius() {
        return this.bwo;
    }

    public float getThumbRangeRatio() {
        return this.ab;
    }

    public float getThumbWidth() {
        return this.bwu;
    }

    public int getTintColor() {
        return this.bwt;
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (!this.bxi) {
            setup();
        }
        if (this.bxi) {
            if (this.bwM) {
                if (this.bws && this.bwD != null && this.bwE != null) {
                    Drawable drawable = isChecked() ? this.bwD : this.bwE;
                    Drawable drawable2 = isChecked() ? this.bwE : this.bwD;
                    int progress = (int) (getProgress() * 255.0f);
                    drawable.setAlpha(progress);
                    drawable.draw(canvas);
                    drawable2.setAlpha(255 - progress);
                    drawable2.draw(canvas);
                } else {
                    this.bwl.setAlpha(255);
                    this.bwl.draw(canvas);
                }
            } else if (this.bws) {
                int i = isChecked() ? this.bwz : this.bwA;
                int i2 = isChecked() ? this.bwA : this.bwz;
                int progress2 = (int) (getProgress() * 255.0f);
                this.bwK.setARGB((Color.alpha(i) * progress2) / 255, Color.red(i), Color.green(i), Color.blue(i));
                RectF rectF = this.bwG;
                float f = this.bwp;
                canvas.drawRoundRect(rectF, f, f, this.bwK);
                this.bwK.setARGB(((255 - progress2) * Color.alpha(i2)) / 255, Color.red(i2), Color.green(i2), Color.blue(i2));
                RectF rectF2 = this.bwG;
                float f2 = this.bwp;
                canvas.drawRoundRect(rectF2, f2, f2, this.bwK);
                this.bwK.setAlpha(255);
            } else {
                this.bwK.setColor(this.bwz);
                RectF rectF3 = this.bwG;
                float f3 = this.bwp;
                canvas.drawRoundRect(rectF3, f3, f3, this.bwK);
            }
            Layout layout = ((double) getProgress()) > 0.5d ? this.bxa : this.bxb;
            RectF rectF4 = ((double) getProgress()) > 0.5d ? this.bwI : this.bwJ;
            if (layout != null && rectF4 != null) {
                int progress3 = (int) ((((double) getProgress()) >= 0.75d ? (getProgress() * 4.0f) - 3.0f : ((double) getProgress()) < 0.25d ? 1.0f - (getProgress() * 4.0f) : 0.0f) * 255.0f);
                int i3 = ((double) getProgress()) > 0.5d ? this.bwB : this.bwC;
                layout.getPaint().setARGB((progress3 * Color.alpha(i3)) / 255, Color.red(i3), Color.green(i3), Color.blue(i3));
                canvas.save();
                canvas.translate(rectF4.left, rectF4.top);
                layout.draw(canvas);
                canvas.restore();
            }
            this.bwQ.set(this.bwF);
            this.bwQ.offset(this.bwP * this.bwH.width(), 0.0f);
            if (this.bwL) {
                Drawable drawable3 = this.bwk;
                RectF rectF5 = this.bwQ;
                drawable3.setBounds((int) rectF5.left, (int) rectF5.top, j(rectF5.right), j(this.bwQ.bottom));
                this.bwk.draw(canvas);
            } else {
                this.bwK.setColor(this.bwy);
                RectF rectF6 = this.bwQ;
                float f4 = this.bwo;
                canvas.drawRoundRect(rectF6, f4, f4, this.bwK);
            }
            if (this.bwN) {
                this.bwW.setColor(Color.parseColor("#AA0000"));
                canvas.drawRect(this.bwG, this.bwW);
                this.bwW.setColor(Color.parseColor("#0000FF"));
                canvas.drawRect(this.bwQ, this.bwW);
                this.bwW.setColor(Color.parseColor("#000000"));
                RectF rectF7 = this.bwH;
                float f5 = rectF7.left;
                float f6 = this.bwF.top;
                canvas.drawLine(f5, f6, rectF7.right, f6, this.bwW);
                this.bwW.setColor(Color.parseColor("#00CC00"));
                canvas.drawRect(((double) getProgress()) > 0.5d ? this.bwI : this.bwJ, this.bwW);
            }
        }
    }

    @Override // android.widget.TextView, android.view.View
    protected void onMeasure(int i, int i2) {
        if (this.bxa == null && !TextUtils.isEmpty(this.bwX)) {
            this.bxa = d(this.bwX);
        }
        if (this.bxb == null && !TextUtils.isEmpty(this.bwY)) {
            this.bxb = d(this.bwY);
        }
        Layout layout = this.bxa;
        float width = layout != null ? layout.getWidth() : 0.0f;
        Layout layout2 = this.bxb;
        float width2 = layout2 != null ? layout2.getWidth() : 0.0f;
        if (width == 0.0f && width2 == 0.0f) {
            this.bxc = 0.0f;
        } else {
            this.bxc = Math.max(width, width2);
        }
        Layout layout3 = this.bxa;
        float height = layout3 != null ? layout3.getHeight() : 0.0f;
        Layout layout4 = this.bxb;
        float height2 = layout4 != null ? layout4.getHeight() : 0.0f;
        if (height == 0.0f && height2 == 0.0f) {
            this.bxd = 0.0f;
        } else {
            this.bxd = Math.max(height, height2);
        }
        setMeasuredDimension(dK(i), i(i2));
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        a aVar = (a) parcelable;
        a(aVar.bxl, aVar.bxm);
        this.bxh = true;
        super.onRestoreInstanceState(aVar.getSuperState());
        this.bxh = false;
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    public Parcelable onSaveInstanceState() {
        a aVar = new a(super.onSaveInstanceState());
        aVar.bxl = this.bwX;
        aVar.bxm = this.bwY;
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
        if (isEnabled() && isClickable() && isFocusable() && this.bxi) {
            int action = motionEvent.getAction();
            float x = motionEvent.getX() - this.bwR;
            float y = motionEvent.getY() - this.bwS;
            switch (action) {
                case 0:
                    this.bwR = motionEvent.getX();
                    this.bwS = motionEvent.getY();
                    this.bwT = this.bwR;
                    setPressed(true);
                    break;
                case 1:
                case 3:
                    this.bxj = false;
                    setPressed(false);
                    float eventTime = (float) (motionEvent.getEventTime() - motionEvent.getDownTime());
                    if (Math.abs(x) < this.bwU && Math.abs(y) < this.bwU && eventTime < this.bwV) {
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
                    setProgress(getProgress() + ((x2 - this.bwT) / this.bwH.width()));
                    if (!this.bxj && (Math.abs(x) > this.bwU / 2 || Math.abs(y) > this.bwU / 2)) {
                        if (y != 0.0f && Math.abs(x) <= Math.abs(y)) {
                            if (Math.abs(y) > Math.abs(x)) {
                                return false;
                            }
                        } else {
                            Nk();
                        }
                    }
                    this.bwT = x2;
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
        this.bwr = j;
    }

    public void setBackColor(ColorStateList colorStateList) {
        this.bwm = colorStateList;
        if (this.bwm != null) {
            setBackDrawable(null);
        }
        invalidate();
    }

    public void setBackColorRes(int i) {
        setBackColor(getResources().getColorStateList(i));
    }

    public void setBackDrawable(Drawable drawable) {
        this.bwl = drawable;
        this.bwM = this.bwl != null;
        refreshDrawableState();
        this.bxi = false;
        requestLayout();
        invalidate();
    }

    public void setBackDrawableRes(int i) {
        setBackDrawable(getResources().getDrawable(i));
    }

    public void setBackRadius(float f) {
        this.bwp = f;
        if (this.bwM) {
            return;
        }
        invalidate();
    }

    @Override // android.widget.CompoundButton, android.widget.Checkable
    public void setChecked(boolean z) {
        if (isChecked() != z) {
            b(z);
        }
        if (this.bxh) {
            setCheckedImmediatelyNoEvent(z);
        } else {
            super.setChecked(z);
        }
    }

    public void setCheckedImmediately(boolean z) {
        super.setChecked(z);
        ObjectAnimator objectAnimator = this.bwO;
        if (objectAnimator != null && objectAnimator.isRunning()) {
            this.bwO.cancel();
        }
        setProgress(z ? 1.0f : 0.0f);
        invalidate();
    }

    public void setCheckedImmediatelyNoEvent(boolean z) {
        if (this.bxk == null) {
            setCheckedImmediately(z);
            return;
        }
        super.setOnCheckedChangeListener(null);
        setCheckedImmediately(z);
        super.setOnCheckedChangeListener(this.bxk);
    }

    public void setCheckedNoEvent(boolean z) {
        if (this.bxk == null) {
            setChecked(z);
            return;
        }
        super.setOnCheckedChangeListener(null);
        setChecked(z);
        super.setOnCheckedChangeListener(this.bxk);
    }

    public void setDrawDebugRect(boolean z) {
        this.bwN = z;
        invalidate();
    }

    public void setFadeBack(boolean z) {
        this.bws = z;
    }

    @Override // android.widget.CompoundButton
    public void setOnCheckedChangeListener(CompoundButton.OnCheckedChangeListener onCheckedChangeListener) {
        super.setOnCheckedChangeListener(onCheckedChangeListener);
        this.bxk = onCheckedChangeListener;
    }

    public void setTextAdjust(int i) {
        this.bxg = i;
        this.bxi = false;
        requestLayout();
        invalidate();
    }

    public void setTextExtra(int i) {
        this.bxf = i;
        this.bxi = false;
        requestLayout();
        invalidate();
    }

    public void setTextThumbInset(int i) {
        this.bxe = i;
        this.bxi = false;
        requestLayout();
        invalidate();
    }

    public void setThumbColor(ColorStateList colorStateList) {
        this.bwn = colorStateList;
        if (this.bwn != null) {
            setThumbDrawable(null);
        }
        invalidate();
    }

    public void setThumbColorRes(int i) {
        setThumbColor(getResources().getColorStateList(i));
    }

    public void setThumbDrawable(Drawable drawable) {
        this.bwk = drawable;
        this.bwL = this.bwk != null;
        refreshDrawableState();
        this.bxi = false;
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
        this.bwo = f;
        if (this.bwL) {
            return;
        }
        invalidate();
    }

    public void setThumbRangeRatio(float f) {
        this.ab = f;
        this.bxi = false;
        requestLayout();
    }

    public void setTintColor(int i) {
        this.bwt = i;
        this.bwn = com.baidu.poly.widget.b.dM(this.bwt);
        this.bwm = com.baidu.poly.widget.b.dN(this.bwt);
        this.bwM = false;
        this.bwL = false;
        refreshDrawableState();
        invalidate();
    }

    public SwitchButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.bwN = false;
        this.bxh = false;
        this.bxi = false;
        this.bxj = false;
        c(attributeSet);
    }

    public SwitchButton(Context context) {
        super(context);
        this.bwN = false;
        this.bxh = false;
        this.bxi = false;
        this.bxj = false;
        c(null);
    }

    public void j() {
        if (this.bxk == null) {
            toggle();
            return;
        }
        super.setOnCheckedChangeListener(null);
        toggle();
        super.setOnCheckedChangeListener(this.bxk);
    }

    private Layout d(CharSequence charSequence) {
        TextPaint textPaint = this.bwZ;
        return new StaticLayout(charSequence, textPaint, (int) Math.ceil(Layout.getDesiredWidth(charSequence, textPaint)), Layout.Alignment.ALIGN_CENTER, 1.0f, 0.0f, false);
    }

    public void a(float f, float f2, float f3, float f4) {
        this.bwq.set(f, f2, f3, f4);
        this.bxi = false;
        requestLayout();
    }

    public void a(CharSequence charSequence, CharSequence charSequence2) {
        this.bwX = charSequence;
        this.bwY = charSequence2;
        this.bxa = null;
        this.bxb = null;
        this.bxi = false;
        requestLayout();
        invalidate();
    }
}
