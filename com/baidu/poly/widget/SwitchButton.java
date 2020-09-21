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
import android.support.v7.widget.helper.ItemTouchHelper;
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
    private static int[] bIZ = {16842912, 16842910, 16842919};
    private static int[] bJa = {-16842912, 16842910, 16842919};
    private float ab;
    private float anN;
    private boolean bJA;
    private boolean bJB;
    private ObjectAnimator bJC;
    private float bJD;
    private RectF bJE;
    private float bJF;
    private float bJG;
    private float bJH;
    private int bJI;
    private int bJJ;
    private Paint bJK;
    private CharSequence bJL;
    private CharSequence bJM;
    private TextPaint bJN;
    private Layout bJO;
    private Layout bJP;
    private float bJQ;
    private float bJR;
    private int bJS;
    private int bJT;
    private int bJU;
    private boolean bJV;
    private boolean bJW;
    private boolean bJX;
    private CompoundButton.OnCheckedChangeListener bJY;
    private Drawable bJb;
    private Drawable bJc;
    private ColorStateList bJd;
    private ColorStateList bJe;
    private RectF bJf;
    private float bJg;
    private long bJh;
    private boolean bJi;
    private int bJj;
    private int bJk;
    private int bJl;
    private int bJm;
    private int bJn;
    private int bJo;
    private int bJp;
    private int bJq;
    private Drawable bJr;
    private Drawable bJs;
    private RectF bJt;
    private RectF bJu;
    private RectF bJv;
    private RectF bJw;
    private RectF bJx;
    private Paint bJy;
    private boolean bJz;
    private int ib;
    private int pb;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes9.dex */
    public static class a extends View.BaseSavedState {
        public static final Parcelable.Creator<a> CREATOR = new C0272a();
        CharSequence bJZ;
        CharSequence bKa;

        /* renamed from: com.baidu.poly.widget.SwitchButton$a$a  reason: collision with other inner class name */
        /* loaded from: classes9.dex */
        static class C0272a implements Parcelable.Creator<a> {
            C0272a() {
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // android.os.Parcelable.Creator
            /* renamed from: gh */
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
            TextUtils.writeToParcel(this.bJZ, parcel, i);
            TextUtils.writeToParcel(this.bKa, parcel, i);
        }

        a(Parcelable parcelable) {
            super(parcelable);
        }

        private a(Parcel parcel) {
            super(parcel);
            this.bJZ = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
            this.bKa = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
        }
    }

    public SwitchButton(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.bJB = false;
        this.bJV = false;
        this.bJW = false;
        this.bJX = false;
        c(attributeSet);
    }

    private void Ve() {
        ViewParent parent = getParent();
        if (parent != null) {
            parent.requestDisallowInterceptTouchEvent(true);
        }
        this.bJX = true;
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
        this.bJI = ViewConfiguration.get(getContext()).getScaledTouchSlop();
        this.bJJ = ViewConfiguration.getPressedStateDuration() + ViewConfiguration.getTapTimeout();
        this.bJy = new Paint(1);
        this.bJK = new Paint(1);
        this.bJK.setStyle(Paint.Style.STROKE);
        this.bJK.setStrokeWidth(getResources().getDisplayMetrics().density);
        this.bJN = getPaint();
        this.bJt = new RectF();
        this.bJu = new RectF();
        this.bJv = new RectF();
        this.bJf = new RectF();
        this.bJw = new RectF();
        this.bJx = new RectF();
        this.bJC = ObjectAnimator.ofFloat(this, "progress", 0.0f, 0.0f).setDuration(250L);
        this.bJC.setInterpolator(new AccelerateDecelerateInterpolator());
        this.bJE = new RectF();
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
            int integer = obtainStyledAttributes.getInteger(b.i.SwitchButton_kswAnimationDuration, ItemTouchHelper.Callback.DEFAULT_SWIPE_ANIMATION_DURATION);
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
        this.bJL = str2;
        this.bJM = str;
        this.bJS = i4;
        this.bJT = i3;
        this.bJU = i5;
        this.bJb = drawable;
        this.bJe = colorStateList;
        this.bJz = this.bJb != null;
        this.bJj = i2;
        if (this.bJj == 0) {
            new TypedValue();
            this.bJj = 3309506;
        }
        if (!this.bJz && this.bJe == null) {
            this.bJe = com.baidu.poly.widget.b.ge(this.bJj);
            this.bJn = this.bJe.getDefaultColor();
        }
        this.bJk = p(f5);
        this.ib = p(f6);
        this.bJc = drawable2;
        this.bJd = colorStateList2;
        this.bJA = this.bJc != null;
        if (!this.bJA && this.bJd == null) {
            this.bJd = com.baidu.poly.widget.b.gf(this.bJj);
            this.bJo = this.bJd.getDefaultColor();
            this.bJp = this.bJd.getColorForState(bIZ, this.bJo);
        }
        this.bJf.set(f, f3, f2, f4);
        this.bJg = this.bJf.width() >= 0.0f ? Math.max(f9, 1.0f) : f9;
        this.ab = f7;
        this.anN = f8;
        this.bJh = i;
        this.bJi = z;
        this.bJC.setDuration(this.bJh);
        if (isChecked()) {
            setProgress(1.0f);
        }
    }

    private int gb(int i) {
        int i2;
        int size = View.MeasureSpec.getSize(i);
        int mode = View.MeasureSpec.getMode(i);
        if (this.bJk == 0 && this.bJz) {
            this.bJk = this.bJb.getIntrinsicWidth();
        }
        int p = p(this.bJQ);
        if (this.bJg == 0.0f) {
            this.bJg = 1.8f;
        }
        if (mode == 1073741824) {
            int paddingLeft = (size - getPaddingLeft()) - getPaddingRight();
            if (this.bJk != 0) {
                int p2 = p(i2 * this.bJg);
                RectF rectF = this.bJf;
                int p3 = (this.bJT + p) - ((p2 - this.bJk) + p(Math.max(rectF.left, rectF.right)));
                float f = p2;
                RectF rectF2 = this.bJf;
                this.bJl = p(rectF2.right + rectF2.left + f + Math.max(p3, 0));
                if (this.bJl < 0) {
                    this.bJk = 0;
                }
                if (f + Math.max(this.bJf.left, 0.0f) + Math.max(this.bJf.right, 0.0f) + Math.max(p3, 0) > paddingLeft) {
                    this.bJk = 0;
                }
            }
            if (this.bJk == 0) {
                int p4 = p((((size - getPaddingLeft()) - getPaddingRight()) - Math.max(this.bJf.left, 0.0f)) - Math.max(this.bJf.right, 0.0f));
                if (p4 < 0) {
                    this.bJk = 0;
                    this.bJl = 0;
                    return size;
                }
                float f2 = p4;
                this.bJk = p(f2 / this.bJg);
                RectF rectF3 = this.bJf;
                this.bJl = p(f2 + rectF3.left + rectF3.right);
                if (this.bJl < 0) {
                    this.bJk = 0;
                    this.bJl = 0;
                    return size;
                }
                int i3 = p + this.bJT;
                int i4 = p4 - this.bJk;
                RectF rectF4 = this.bJf;
                int p5 = i3 - (i4 + p(Math.max(rectF4.left, rectF4.right)));
                if (p5 > 0) {
                    this.bJk -= p5;
                }
                if (this.bJk < 0) {
                    this.bJk = 0;
                    this.bJl = 0;
                    return size;
                }
                return size;
            }
            return size;
        }
        if (this.bJk == 0) {
            this.bJk = p(getResources().getDisplayMetrics().density * 20.0f);
        }
        if (this.bJg == 0.0f) {
            this.bJg = 1.8f;
        }
        int p6 = p(this.bJk * this.bJg);
        RectF rectF5 = this.bJf;
        int p7 = p((p + this.bJT) - (((p6 - this.bJk) + Math.max(rectF5.left, rectF5.right)) + this.bJS));
        float f3 = p6;
        RectF rectF6 = this.bJf;
        this.bJl = p(rectF6.right + rectF6.left + f3 + Math.max(0, p7));
        if (this.bJl < 0) {
            this.bJk = 0;
            this.bJl = 0;
            return size;
        }
        int p8 = p(Math.max(0.0f, this.bJf.left) + f3 + Math.max(0.0f, this.bJf.right) + Math.max(0, p7));
        return Math.max(p8, getPaddingLeft() + p8 + getPaddingRight());
    }

    private int gc(int i) {
        int i2;
        int i3;
        int i4;
        int size = View.MeasureSpec.getSize(i);
        int mode = View.MeasureSpec.getMode(i);
        if (this.ib == 0 && this.bJz) {
            this.ib = this.bJb.getIntrinsicHeight();
        }
        if (mode == 1073741824) {
            if (this.ib != 0) {
                RectF rectF = this.bJf;
                this.bJm = p(i3 + rectF.top + rectF.bottom);
                this.bJm = p(Math.max(this.bJm, this.bJR));
                if ((((this.bJm + getPaddingTop()) + getPaddingBottom()) - Math.min(0.0f, this.bJf.top)) - Math.min(0.0f, this.bJf.bottom) > size) {
                    this.ib = 0;
                }
            }
            if (this.ib == 0) {
                this.bJm = p(((size - getPaddingTop()) - getPaddingBottom()) + Math.min(0.0f, this.bJf.top) + Math.min(0.0f, this.bJf.bottom));
                if (this.bJm < 0) {
                    this.bJm = 0;
                    this.ib = 0;
                    return size;
                }
                RectF rectF2 = this.bJf;
                this.ib = p((i4 - rectF2.top) - rectF2.bottom);
            }
            if (this.ib < 0) {
                this.bJm = 0;
                this.ib = 0;
                return size;
            }
            return size;
        }
        if (this.ib == 0) {
            this.ib = p(getResources().getDisplayMetrics().density * 20.0f);
        }
        RectF rectF3 = this.bJf;
        this.bJm = p(this.ib + rectF3.top + rectF3.bottom);
        if (this.bJm < 0) {
            this.bJm = 0;
            this.ib = 0;
            return size;
        }
        int p = p(this.bJR - i2);
        if (p > 0) {
            this.bJm += p;
            this.ib = p + this.ib;
        }
        int max = Math.max(this.ib, this.bJm);
        return Math.max(Math.max(max, getPaddingTop() + max + getPaddingBottom()), getSuggestedMinimumHeight());
    }

    private float getProgress() {
        return this.bJD;
    }

    private boolean getStatusBasedOnPos() {
        return getProgress() > 0.5f;
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
        this.bJD = f;
        invalidate();
    }

    private void setup() {
        int i;
        float paddingTop;
        float paddingLeft;
        int i2 = this.bJk;
        if (i2 != 0 && (i = this.ib) != 0 && this.bJl != 0 && this.bJm != 0) {
            if (this.ab == -1.0f) {
                this.ab = Math.min(i2, i) / 2;
            }
            if (this.anN == -1.0f) {
                this.anN = Math.min(this.bJl, this.bJm) / 2;
            }
            int measuredWidth = (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight();
            int measuredHeight = (getMeasuredHeight() - getPaddingTop()) - getPaddingBottom();
            int p = p((this.bJl - Math.min(0.0f, this.bJf.left)) - Math.min(0.0f, this.bJf.right));
            int p2 = p((this.bJm - Math.min(0.0f, this.bJf.top)) - Math.min(0.0f, this.bJf.bottom));
            if (measuredHeight <= p2) {
                paddingTop = getPaddingTop() + Math.max(0.0f, this.bJf.top);
            } else {
                paddingTop = (((measuredHeight - p2) + 1) / 2) + getPaddingTop() + Math.max(0.0f, this.bJf.top);
            }
            if (measuredWidth <= this.bJl) {
                paddingLeft = getPaddingLeft() + Math.max(0.0f, this.bJf.left);
            } else {
                paddingLeft = (((measuredWidth - p) + 1) / 2) + getPaddingLeft() + Math.max(0.0f, this.bJf.left);
            }
            this.bJt.set(paddingLeft, paddingTop, this.bJk + paddingLeft, this.ib + paddingTop);
            RectF rectF = this.bJt;
            float f = rectF.left;
            RectF rectF2 = this.bJf;
            float f2 = f - rectF2.left;
            RectF rectF3 = this.bJu;
            float f3 = rectF.top;
            float f4 = rectF2.top;
            rectF3.set(f2, f3 - f4, this.bJl + f2, (f3 - f4) + this.bJm);
            RectF rectF4 = this.bJv;
            RectF rectF5 = this.bJt;
            rectF4.set(rectF5.left, 0.0f, (this.bJu.right - this.bJf.right) - rectF5.width(), 0.0f);
            this.anN = Math.min(Math.min(this.bJu.width(), this.bJu.height()) / 2.0f, this.anN);
            Drawable drawable = this.bJc;
            if (drawable != null) {
                RectF rectF6 = this.bJu;
                drawable.setBounds((int) rectF6.left, (int) rectF6.top, p(rectF6.right), p(this.bJu.bottom));
            }
            if (this.bJO != null) {
                RectF rectF7 = this.bJu;
                float width = ((((((rectF7.width() + this.bJS) - this.bJk) - this.bJf.right) - this.bJO.getWidth()) / 2.0f) + rectF7.left) - this.bJU;
                RectF rectF8 = this.bJu;
                float height = ((rectF8.height() - this.bJO.getHeight()) / 2.0f) + rectF8.top;
                this.bJw.set(width, height, this.bJO.getWidth() + width, this.bJO.getHeight() + height);
            }
            if (this.bJP != null) {
                RectF rectF9 = this.bJu;
                float width2 = ((rectF9.right - (((((rectF9.width() + this.bJS) - this.bJk) - this.bJf.left) - this.bJP.getWidth()) / 2.0f)) - this.bJP.getWidth()) + this.bJU;
                RectF rectF10 = this.bJu;
                float height2 = ((rectF10.height() - this.bJP.getHeight()) / 2.0f) + rectF10.top;
                this.bJx.set(width2, height2, this.bJP.getWidth() + width2, this.bJP.getHeight() + height2);
            }
            this.bJW = true;
        }
    }

    protected void b(boolean z) {
        ObjectAnimator objectAnimator = this.bJC;
        if (objectAnimator != null) {
            if (objectAnimator.isRunning()) {
                this.bJC.cancel();
            }
            this.bJC.setDuration(this.bJh);
            if (z) {
                this.bJC.setFloatValues(this.bJD, 1.0f);
            } else {
                this.bJC.setFloatValues(this.bJD, 0.0f);
            }
            this.bJC.start();
        }
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    protected void drawableStateChanged() {
        ColorStateList colorStateList;
        ColorStateList colorStateList2;
        super.drawableStateChanged();
        if (!this.bJz && (colorStateList2 = this.bJe) != null) {
            this.bJn = colorStateList2.getColorForState(getDrawableState(), this.bJn);
        } else {
            setDrawableState(this.bJb);
        }
        int[] iArr = isChecked() ? bJa : bIZ;
        ColorStateList textColors = getTextColors();
        if (textColors != null) {
            int defaultColor = textColors.getDefaultColor();
            this.bJq = textColors.getColorForState(bIZ, defaultColor);
            this.pb = textColors.getColorForState(bJa, defaultColor);
        }
        if (!this.bJA && (colorStateList = this.bJd) != null) {
            this.bJo = colorStateList.getColorForState(getDrawableState(), this.bJo);
            this.bJp = this.bJd.getColorForState(iArr, this.bJo);
            return;
        }
        Drawable drawable = this.bJc;
        if ((drawable instanceof StateListDrawable) && this.bJi) {
            drawable.setState(iArr);
            this.bJs = this.bJc.getCurrent().mutate();
        } else {
            this.bJs = null;
        }
        setDrawableState(this.bJc);
        Drawable drawable2 = this.bJc;
        if (drawable2 != null) {
            this.bJr = drawable2.getCurrent().mutate();
        }
    }

    public long getAnimationDuration() {
        return this.bJh;
    }

    public ColorStateList getBackColor() {
        return this.bJd;
    }

    public Drawable getBackDrawable() {
        return this.bJc;
    }

    public float getBackRadius() {
        return this.anN;
    }

    public PointF getBackSizeF() {
        return new PointF(this.bJu.width(), this.bJu.height());
    }

    public CharSequence getTextOff() {
        return this.bJM;
    }

    public CharSequence getTextOn() {
        return this.bJL;
    }

    public ColorStateList getThumbColor() {
        return this.bJe;
    }

    public Drawable getThumbDrawable() {
        return this.bJb;
    }

    public float getThumbHeight() {
        return this.ib;
    }

    public RectF getThumbMargin() {
        return this.bJf;
    }

    public float getThumbRadius() {
        return this.ab;
    }

    public float getThumbRangeRatio() {
        return this.bJg;
    }

    public float getThumbWidth() {
        return this.bJk;
    }

    public int getTintColor() {
        return this.bJj;
    }

    public void o() {
        if (this.bJY == null) {
            toggle();
            return;
        }
        super.setOnCheckedChangeListener(null);
        toggle();
        super.setOnCheckedChangeListener(this.bJY);
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (!this.bJW) {
            setup();
        }
        if (this.bJW) {
            if (this.bJA) {
                if (this.bJi && this.bJr != null && this.bJs != null) {
                    Drawable drawable = isChecked() ? this.bJr : this.bJs;
                    Drawable drawable2 = isChecked() ? this.bJs : this.bJr;
                    int progress = (int) (getProgress() * 255.0f);
                    drawable.setAlpha(progress);
                    drawable.draw(canvas);
                    drawable2.setAlpha(255 - progress);
                    drawable2.draw(canvas);
                } else {
                    this.bJc.setAlpha(255);
                    this.bJc.draw(canvas);
                }
            } else if (this.bJi) {
                int i = isChecked() ? this.bJo : this.bJp;
                int i2 = isChecked() ? this.bJp : this.bJo;
                int progress2 = (int) (getProgress() * 255.0f);
                this.bJy.setARGB((Color.alpha(i) * progress2) / 255, Color.red(i), Color.green(i), Color.blue(i));
                RectF rectF = this.bJu;
                float f = this.anN;
                canvas.drawRoundRect(rectF, f, f, this.bJy);
                this.bJy.setARGB(((255 - progress2) * Color.alpha(i2)) / 255, Color.red(i2), Color.green(i2), Color.blue(i2));
                RectF rectF2 = this.bJu;
                float f2 = this.anN;
                canvas.drawRoundRect(rectF2, f2, f2, this.bJy);
                this.bJy.setAlpha(255);
            } else {
                this.bJy.setColor(this.bJo);
                RectF rectF3 = this.bJu;
                float f3 = this.anN;
                canvas.drawRoundRect(rectF3, f3, f3, this.bJy);
            }
            Layout layout = ((double) getProgress()) > 0.5d ? this.bJO : this.bJP;
            RectF rectF4 = ((double) getProgress()) > 0.5d ? this.bJw : this.bJx;
            if (layout != null && rectF4 != null) {
                int progress3 = (int) ((((double) getProgress()) >= 0.75d ? (getProgress() * 4.0f) - 3.0f : ((double) getProgress()) < 0.25d ? 1.0f - (getProgress() * 4.0f) : 0.0f) * 255.0f);
                int i3 = ((double) getProgress()) > 0.5d ? this.bJq : this.pb;
                layout.getPaint().setARGB((progress3 * Color.alpha(i3)) / 255, Color.red(i3), Color.green(i3), Color.blue(i3));
                canvas.save();
                canvas.translate(rectF4.left, rectF4.top);
                layout.draw(canvas);
                canvas.restore();
            }
            this.bJE.set(this.bJt);
            this.bJE.offset(this.bJD * this.bJv.width(), 0.0f);
            if (this.bJz) {
                Drawable drawable3 = this.bJb;
                RectF rectF5 = this.bJE;
                drawable3.setBounds((int) rectF5.left, (int) rectF5.top, p(rectF5.right), p(this.bJE.bottom));
                this.bJb.draw(canvas);
            } else {
                this.bJy.setColor(this.bJn);
                RectF rectF6 = this.bJE;
                float f4 = this.ab;
                canvas.drawRoundRect(rectF6, f4, f4, this.bJy);
            }
            if (this.bJB) {
                this.bJK.setColor(Color.parseColor("#AA0000"));
                canvas.drawRect(this.bJu, this.bJK);
                this.bJK.setColor(Color.parseColor("#0000FF"));
                canvas.drawRect(this.bJE, this.bJK);
                this.bJK.setColor(Color.parseColor("#000000"));
                RectF rectF7 = this.bJv;
                float f5 = rectF7.left;
                float f6 = this.bJt.top;
                canvas.drawLine(f5, f6, rectF7.right, f6, this.bJK);
                this.bJK.setColor(Color.parseColor("#00CC00"));
                canvas.drawRect(((double) getProgress()) > 0.5d ? this.bJw : this.bJx, this.bJK);
            }
        }
    }

    @Override // android.widget.TextView, android.view.View
    protected void onMeasure(int i, int i2) {
        if (this.bJO == null && !TextUtils.isEmpty(this.bJL)) {
            this.bJO = d(this.bJL);
        }
        if (this.bJP == null && !TextUtils.isEmpty(this.bJM)) {
            this.bJP = d(this.bJM);
        }
        Layout layout = this.bJO;
        float width = layout != null ? layout.getWidth() : 0.0f;
        Layout layout2 = this.bJP;
        float width2 = layout2 != null ? layout2.getWidth() : 0.0f;
        if (width == 0.0f && width2 == 0.0f) {
            this.bJQ = 0.0f;
        } else {
            this.bJQ = Math.max(width, width2);
        }
        Layout layout3 = this.bJO;
        float height = layout3 != null ? layout3.getHeight() : 0.0f;
        Layout layout4 = this.bJP;
        float height2 = layout4 != null ? layout4.getHeight() : 0.0f;
        if (height == 0.0f && height2 == 0.0f) {
            this.bJR = 0.0f;
        } else {
            this.bJR = Math.max(height, height2);
        }
        setMeasuredDimension(gb(i), gc(i2));
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        a aVar = (a) parcelable;
        a(aVar.bJZ, aVar.bKa);
        this.bJV = true;
        super.onRestoreInstanceState(aVar.getSuperState());
        this.bJV = false;
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    public Parcelable onSaveInstanceState() {
        a aVar = new a(super.onSaveInstanceState());
        aVar.bJZ = this.bJL;
        aVar.bKa = this.bJM;
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
        if (isEnabled() && isClickable() && isFocusable() && this.bJW) {
            int action = motionEvent.getAction();
            float x = motionEvent.getX() - this.bJF;
            float y = motionEvent.getY() - this.bJG;
            switch (action) {
                case 0:
                    this.bJF = motionEvent.getX();
                    this.bJG = motionEvent.getY();
                    this.bJH = this.bJF;
                    setPressed(true);
                    break;
                case 1:
                case 3:
                    this.bJX = false;
                    setPressed(false);
                    float eventTime = (float) (motionEvent.getEventTime() - motionEvent.getDownTime());
                    if (Math.abs(x) < this.bJI && Math.abs(y) < this.bJI && eventTime < this.bJJ) {
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
                    setProgress(getProgress() + ((x2 - this.bJH) / this.bJv.width()));
                    if (!this.bJX && (Math.abs(x) > this.bJI / 2 || Math.abs(y) > this.bJI / 2)) {
                        if (y != 0.0f && Math.abs(x) <= Math.abs(y)) {
                            if (Math.abs(y) > Math.abs(x)) {
                                return false;
                            }
                        } else {
                            Ve();
                        }
                    }
                    this.bJH = x2;
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
        this.bJh = j;
    }

    public void setBackColor(ColorStateList colorStateList) {
        this.bJd = colorStateList;
        if (this.bJd != null) {
            setBackDrawable(null);
        }
        invalidate();
    }

    public void setBackColorRes(int i) {
        setBackColor(getResources().getColorStateList(i));
    }

    public void setBackDrawable(Drawable drawable) {
        this.bJc = drawable;
        this.bJA = this.bJc != null;
        refreshDrawableState();
        this.bJW = false;
        requestLayout();
        invalidate();
    }

    public void setBackDrawableRes(int i) {
        setBackDrawable(getResources().getDrawable(i));
    }

    public void setBackRadius(float f) {
        this.anN = f;
        if (this.bJA) {
            return;
        }
        invalidate();
    }

    @Override // android.widget.CompoundButton, android.widget.Checkable
    public void setChecked(boolean z) {
        if (isChecked() != z) {
            b(z);
        }
        if (this.bJV) {
            setCheckedImmediatelyNoEvent(z);
        } else {
            super.setChecked(z);
        }
    }

    public void setCheckedImmediately(boolean z) {
        super.setChecked(z);
        ObjectAnimator objectAnimator = this.bJC;
        if (objectAnimator != null && objectAnimator.isRunning()) {
            this.bJC.cancel();
        }
        setProgress(z ? 1.0f : 0.0f);
        invalidate();
    }

    public void setCheckedImmediatelyNoEvent(boolean z) {
        if (this.bJY == null) {
            setCheckedImmediately(z);
            return;
        }
        super.setOnCheckedChangeListener(null);
        setCheckedImmediately(z);
        super.setOnCheckedChangeListener(this.bJY);
    }

    public void setCheckedNoEvent(boolean z) {
        if (this.bJY == null) {
            setChecked(z);
            return;
        }
        super.setOnCheckedChangeListener(null);
        setChecked(z);
        super.setOnCheckedChangeListener(this.bJY);
    }

    public void setDrawDebugRect(boolean z) {
        this.bJB = z;
        invalidate();
    }

    public void setFadeBack(boolean z) {
        this.bJi = z;
    }

    @Override // android.widget.CompoundButton
    public void setOnCheckedChangeListener(CompoundButton.OnCheckedChangeListener onCheckedChangeListener) {
        super.setOnCheckedChangeListener(onCheckedChangeListener);
        this.bJY = onCheckedChangeListener;
    }

    public void setTextAdjust(int i) {
        this.bJU = i;
        this.bJW = false;
        requestLayout();
        invalidate();
    }

    public void setTextExtra(int i) {
        this.bJT = i;
        this.bJW = false;
        requestLayout();
        invalidate();
    }

    public void setTextThumbInset(int i) {
        this.bJS = i;
        this.bJW = false;
        requestLayout();
        invalidate();
    }

    public void setThumbColor(ColorStateList colorStateList) {
        this.bJe = colorStateList;
        if (this.bJe != null) {
            setThumbDrawable(null);
        }
        invalidate();
    }

    public void setThumbColorRes(int i) {
        setThumbColor(getResources().getColorStateList(i));
    }

    public void setThumbDrawable(Drawable drawable) {
        this.bJb = drawable;
        this.bJz = this.bJb != null;
        refreshDrawableState();
        this.bJW = false;
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
        if (this.bJz) {
            return;
        }
        invalidate();
    }

    public void setThumbRangeRatio(float f) {
        this.bJg = f;
        this.bJW = false;
        requestLayout();
    }

    public void setTintColor(int i) {
        this.bJj = i;
        this.bJe = com.baidu.poly.widget.b.ge(this.bJj);
        this.bJd = com.baidu.poly.widget.b.gf(this.bJj);
        this.bJA = false;
        this.bJz = false;
        refreshDrawableState();
        invalidate();
    }

    public SwitchButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.bJB = false;
        this.bJV = false;
        this.bJW = false;
        this.bJX = false;
        c(attributeSet);
    }

    public SwitchButton(Context context) {
        super(context);
        this.bJB = false;
        this.bJV = false;
        this.bJW = false;
        this.bJX = false;
        c(null);
    }

    private Layout d(CharSequence charSequence) {
        TextPaint textPaint = this.bJN;
        return new StaticLayout(charSequence, textPaint, (int) Math.ceil(Layout.getDesiredWidth(charSequence, textPaint)), Layout.Alignment.ALIGN_CENTER, 1.0f, 0.0f, false);
    }

    public void a(float f, float f2, float f3, float f4) {
        this.bJf.set(f, f2, f3, f4);
        this.bJW = false;
        requestLayout();
    }

    public void a(CharSequence charSequence, CharSequence charSequence2) {
        this.bJL = charSequence;
        this.bJM = charSequence2;
        this.bJO = null;
        this.bJP = null;
        this.bJW = false;
        requestLayout();
        invalidate();
    }
}
