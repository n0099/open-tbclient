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
/* loaded from: classes9.dex */
public class SwitchButton extends CompoundButton {
    private static int[] aMV = {16842912, 16842910, 16842919};
    private static int[] aMW = {-16842912, 16842910, 16842919};
    private Drawable aMX;
    private Drawable aMY;
    private ColorStateList aMZ;
    private boolean aNA;
    private ObjectAnimator aNB;
    private float aNC;
    private RectF aND;
    private float aNE;
    private float aNF;
    private float aNG;
    private int aNH;
    private int aNI;
    private Paint aNJ;
    private CharSequence aNK;
    private CharSequence aNL;
    private TextPaint aNM;
    private Layout aNN;
    private Layout aNO;
    private float aNP;
    private float aNQ;
    private int aNR;
    private int aNS;
    private int aNT;
    private boolean aNU;
    private boolean aNV;
    private boolean aNW;
    private CompoundButton.OnCheckedChangeListener aNX;
    private ColorStateList aNa;
    private float aNb;
    private float aNc;
    private RectF aNd;
    private float aNe;
    private long aNf;
    private int aNg;
    private int aNh;
    private int aNi;
    private int aNj;
    private int aNk;
    private int aNl;
    private int aNm;
    private int aNn;
    private int aNo;
    private int aNp;
    private Drawable aNq;
    private Drawable aNr;
    private RectF aNs;
    private RectF aNt;
    private RectF aNu;
    private RectF aNv;
    private RectF aNw;
    private Paint aNx;
    private boolean aNy;
    private boolean aNz;
    private boolean ab;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes9.dex */
    public static class a extends View.BaseSavedState {
        public static final Parcelable.Creator<a> CREATOR = new C0154a();
        CharSequence aNY;
        CharSequence aNZ;

        /* renamed from: com.baidu.poly.widget.SwitchButton$a$a  reason: collision with other inner class name */
        /* loaded from: classes9.dex */
        static class C0154a implements Parcelable.Creator<a> {
            C0154a() {
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // android.os.Parcelable.Creator
            /* renamed from: dm */
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
            TextUtils.writeToParcel(this.aNY, parcel, i);
            TextUtils.writeToParcel(this.aNZ, parcel, i);
        }

        a(Parcelable parcelable) {
            super(parcelable);
        }

        private a(Parcel parcel) {
            super(parcel);
            this.aNY = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
            this.aNZ = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
        }
    }

    public SwitchButton(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.aNA = false;
        this.aNU = false;
        this.aNV = false;
        this.aNW = false;
        c(attributeSet);
    }

    private void R() {
        ViewParent parent = getParent();
        if (parent != null) {
            parent.requestDisallowInterceptTouchEvent(true);
        }
        this.aNW = true;
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
        this.aNH = ViewConfiguration.get(getContext()).getScaledTouchSlop();
        this.aNI = ViewConfiguration.getPressedStateDuration() + ViewConfiguration.getTapTimeout();
        this.aNx = new Paint(1);
        this.aNJ = new Paint(1);
        this.aNJ.setStyle(Paint.Style.STROKE);
        this.aNJ.setStrokeWidth(getResources().getDisplayMetrics().density);
        this.aNM = getPaint();
        this.aNs = new RectF();
        this.aNt = new RectF();
        this.aNu = new RectF();
        this.aNd = new RectF();
        this.aNv = new RectF();
        this.aNw = new RectF();
        this.aNB = ObjectAnimator.ofFloat(this, "progress", 0.0f, 0.0f).setDuration(250L);
        this.aNB.setInterpolator(new AccelerateDecelerateInterpolator());
        this.aND = new RectF();
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
        this.aNK = str2;
        this.aNL = str;
        this.aNR = i4;
        this.aNS = i3;
        this.aNT = i5;
        this.aMX = drawable;
        this.aNa = colorStateList;
        this.aNy = this.aMX != null;
        this.aNg = i2;
        if (this.aNg == 0) {
            new TypedValue();
            this.aNg = 3309506;
        }
        if (!this.aNy && this.aNa == null) {
            this.aNa = com.baidu.poly.widget.b.dj(this.aNg);
            this.aNl = this.aNa.getDefaultColor();
        }
        this.aNh = e(f5);
        this.aNi = e(f6);
        this.aMY = drawable2;
        this.aMZ = colorStateList2;
        this.aNz = this.aMY != null;
        if (!this.aNz && this.aMZ == null) {
            this.aMZ = com.baidu.poly.widget.b.dk(this.aNg);
            this.aNm = this.aMZ.getDefaultColor();
            this.aNn = this.aMZ.getColorForState(aMV, this.aNm);
        }
        this.aNd.set(f, f3, f2, f4);
        this.aNe = this.aNd.width() >= 0.0f ? Math.max(f9, 1.0f) : f9;
        this.aNb = f7;
        this.aNc = f8;
        this.aNf = i;
        this.ab = z;
        this.aNB.setDuration(this.aNf);
        if (isChecked()) {
            setProgress(1.0f);
        }
    }

    private int dg(int i) {
        int i2;
        int size = View.MeasureSpec.getSize(i);
        int mode = View.MeasureSpec.getMode(i);
        if (this.aNh == 0 && this.aNy) {
            this.aNh = this.aMX.getIntrinsicWidth();
        }
        int e = e(this.aNP);
        if (this.aNe == 0.0f) {
            this.aNe = 1.8f;
        }
        if (mode == 1073741824) {
            int paddingLeft = (size - getPaddingLeft()) - getPaddingRight();
            if (this.aNh != 0) {
                int e2 = e(i2 * this.aNe);
                RectF rectF = this.aNd;
                int e3 = (this.aNS + e) - ((e2 - this.aNh) + e(Math.max(rectF.left, rectF.right)));
                float f = e2;
                RectF rectF2 = this.aNd;
                this.aNj = e(rectF2.right + rectF2.left + f + Math.max(e3, 0));
                if (this.aNj < 0) {
                    this.aNh = 0;
                }
                if (f + Math.max(this.aNd.left, 0.0f) + Math.max(this.aNd.right, 0.0f) + Math.max(e3, 0) > paddingLeft) {
                    this.aNh = 0;
                }
            }
            if (this.aNh == 0) {
                int e4 = e((((size - getPaddingLeft()) - getPaddingRight()) - Math.max(this.aNd.left, 0.0f)) - Math.max(this.aNd.right, 0.0f));
                if (e4 < 0) {
                    this.aNh = 0;
                    this.aNj = 0;
                    return size;
                }
                float f2 = e4;
                this.aNh = e(f2 / this.aNe);
                RectF rectF3 = this.aNd;
                this.aNj = e(f2 + rectF3.left + rectF3.right);
                if (this.aNj < 0) {
                    this.aNh = 0;
                    this.aNj = 0;
                    return size;
                }
                int i3 = e + this.aNS;
                int i4 = e4 - this.aNh;
                RectF rectF4 = this.aNd;
                int e5 = i3 - (i4 + e(Math.max(rectF4.left, rectF4.right)));
                if (e5 > 0) {
                    this.aNh -= e5;
                }
                if (this.aNh < 0) {
                    this.aNh = 0;
                    this.aNj = 0;
                    return size;
                }
                return size;
            }
            return size;
        }
        if (this.aNh == 0) {
            this.aNh = e(getResources().getDisplayMetrics().density * 20.0f);
        }
        if (this.aNe == 0.0f) {
            this.aNe = 1.8f;
        }
        int e6 = e(this.aNh * this.aNe);
        RectF rectF5 = this.aNd;
        int e7 = e((e + this.aNS) - (((e6 - this.aNh) + Math.max(rectF5.left, rectF5.right)) + this.aNR));
        float f3 = e6;
        RectF rectF6 = this.aNd;
        this.aNj = e(rectF6.right + rectF6.left + f3 + Math.max(0, e7));
        if (this.aNj < 0) {
            this.aNh = 0;
            this.aNj = 0;
            return size;
        }
        int e8 = e(Math.max(0.0f, this.aNd.left) + f3 + Math.max(0.0f, this.aNd.right) + Math.max(0, e7));
        return Math.max(e8, getPaddingLeft() + e8 + getPaddingRight());
    }

    private int dh(int i) {
        int i2;
        int i3;
        int i4;
        int size = View.MeasureSpec.getSize(i);
        int mode = View.MeasureSpec.getMode(i);
        if (this.aNi == 0 && this.aNy) {
            this.aNi = this.aMX.getIntrinsicHeight();
        }
        if (mode == 1073741824) {
            if (this.aNi != 0) {
                RectF rectF = this.aNd;
                this.aNk = e(i3 + rectF.top + rectF.bottom);
                this.aNk = e(Math.max(this.aNk, this.aNQ));
                if ((((this.aNk + getPaddingTop()) + getPaddingBottom()) - Math.min(0.0f, this.aNd.top)) - Math.min(0.0f, this.aNd.bottom) > size) {
                    this.aNi = 0;
                }
            }
            if (this.aNi == 0) {
                this.aNk = e(((size - getPaddingTop()) - getPaddingBottom()) + Math.min(0.0f, this.aNd.top) + Math.min(0.0f, this.aNd.bottom));
                if (this.aNk < 0) {
                    this.aNk = 0;
                    this.aNi = 0;
                    return size;
                }
                RectF rectF2 = this.aNd;
                this.aNi = e((i4 - rectF2.top) - rectF2.bottom);
            }
            if (this.aNi < 0) {
                this.aNk = 0;
                this.aNi = 0;
                return size;
            }
            return size;
        }
        if (this.aNi == 0) {
            this.aNi = e(getResources().getDisplayMetrics().density * 20.0f);
        }
        RectF rectF3 = this.aNd;
        this.aNk = e(this.aNi + rectF3.top + rectF3.bottom);
        if (this.aNk < 0) {
            this.aNk = 0;
            this.aNi = 0;
            return size;
        }
        int e = e(this.aNQ - i2);
        if (e > 0) {
            this.aNk += e;
            this.aNi = e + this.aNi;
        }
        int max = Math.max(this.aNi, this.aNk);
        return Math.max(Math.max(max, getPaddingTop() + max + getPaddingBottom()), getSuggestedMinimumHeight());
    }

    private int e(double d) {
        return (int) Math.ceil(d);
    }

    private float getProgress() {
        return this.aNC;
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
        this.aNC = f;
        invalidate();
    }

    private void setup() {
        int i;
        float paddingTop;
        float paddingLeft;
        int i2 = this.aNh;
        if (i2 != 0 && (i = this.aNi) != 0 && this.aNj != 0 && this.aNk != 0) {
            if (this.aNb == -1.0f) {
                this.aNb = Math.min(i2, i) / 2;
            }
            if (this.aNc == -1.0f) {
                this.aNc = Math.min(this.aNj, this.aNk) / 2;
            }
            int measuredWidth = (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight();
            int measuredHeight = (getMeasuredHeight() - getPaddingTop()) - getPaddingBottom();
            int e = e((this.aNj - Math.min(0.0f, this.aNd.left)) - Math.min(0.0f, this.aNd.right));
            int e2 = e((this.aNk - Math.min(0.0f, this.aNd.top)) - Math.min(0.0f, this.aNd.bottom));
            if (measuredHeight <= e2) {
                paddingTop = getPaddingTop() + Math.max(0.0f, this.aNd.top);
            } else {
                paddingTop = (((measuredHeight - e2) + 1) / 2) + getPaddingTop() + Math.max(0.0f, this.aNd.top);
            }
            if (measuredWidth <= this.aNj) {
                paddingLeft = getPaddingLeft() + Math.max(0.0f, this.aNd.left);
            } else {
                paddingLeft = (((measuredWidth - e) + 1) / 2) + getPaddingLeft() + Math.max(0.0f, this.aNd.left);
            }
            this.aNs.set(paddingLeft, paddingTop, this.aNh + paddingLeft, this.aNi + paddingTop);
            RectF rectF = this.aNs;
            float f = rectF.left;
            RectF rectF2 = this.aNd;
            float f2 = f - rectF2.left;
            RectF rectF3 = this.aNt;
            float f3 = rectF.top;
            float f4 = rectF2.top;
            rectF3.set(f2, f3 - f4, this.aNj + f2, (f3 - f4) + this.aNk);
            RectF rectF4 = this.aNu;
            RectF rectF5 = this.aNs;
            rectF4.set(rectF5.left, 0.0f, (this.aNt.right - this.aNd.right) - rectF5.width(), 0.0f);
            this.aNc = Math.min(Math.min(this.aNt.width(), this.aNt.height()) / 2.0f, this.aNc);
            Drawable drawable = this.aMY;
            if (drawable != null) {
                RectF rectF6 = this.aNt;
                drawable.setBounds((int) rectF6.left, (int) rectF6.top, e(rectF6.right), e(this.aNt.bottom));
            }
            if (this.aNN != null) {
                RectF rectF7 = this.aNt;
                float width = ((((((rectF7.width() + this.aNR) - this.aNh) - this.aNd.right) - this.aNN.getWidth()) / 2.0f) + rectF7.left) - this.aNT;
                RectF rectF8 = this.aNt;
                float height = ((rectF8.height() - this.aNN.getHeight()) / 2.0f) + rectF8.top;
                this.aNv.set(width, height, this.aNN.getWidth() + width, this.aNN.getHeight() + height);
            }
            if (this.aNO != null) {
                RectF rectF9 = this.aNt;
                float width2 = ((rectF9.right - (((((rectF9.width() + this.aNR) - this.aNh) - this.aNd.left) - this.aNO.getWidth()) / 2.0f)) - this.aNO.getWidth()) + this.aNT;
                RectF rectF10 = this.aNt;
                float height2 = ((rectF10.height() - this.aNO.getHeight()) / 2.0f) + rectF10.top;
                this.aNw.set(width2, height2, this.aNO.getWidth() + width2, this.aNO.getHeight() + height2);
            }
            this.aNV = true;
        }
    }

    protected void b(boolean z) {
        ObjectAnimator objectAnimator = this.aNB;
        if (objectAnimator != null) {
            if (objectAnimator.isRunning()) {
                this.aNB.cancel();
            }
            this.aNB.setDuration(this.aNf);
            if (z) {
                this.aNB.setFloatValues(this.aNC, 1.0f);
            } else {
                this.aNB.setFloatValues(this.aNC, 0.0f);
            }
            this.aNB.start();
        }
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    protected void drawableStateChanged() {
        ColorStateList colorStateList;
        ColorStateList colorStateList2;
        super.drawableStateChanged();
        if (!this.aNy && (colorStateList2 = this.aNa) != null) {
            this.aNl = colorStateList2.getColorForState(getDrawableState(), this.aNl);
        } else {
            setDrawableState(this.aMX);
        }
        int[] iArr = isChecked() ? aMW : aMV;
        ColorStateList textColors = getTextColors();
        if (textColors != null) {
            int defaultColor = textColors.getDefaultColor();
            this.aNo = textColors.getColorForState(aMV, defaultColor);
            this.aNp = textColors.getColorForState(aMW, defaultColor);
        }
        if (!this.aNz && (colorStateList = this.aMZ) != null) {
            this.aNm = colorStateList.getColorForState(getDrawableState(), this.aNm);
            this.aNn = this.aMZ.getColorForState(iArr, this.aNm);
            return;
        }
        Drawable drawable = this.aMY;
        if ((drawable instanceof StateListDrawable) && this.ab) {
            drawable.setState(iArr);
            this.aNr = this.aMY.getCurrent().mutate();
        } else {
            this.aNr = null;
        }
        setDrawableState(this.aMY);
        Drawable drawable2 = this.aMY;
        if (drawable2 != null) {
            this.aNq = drawable2.getCurrent().mutate();
        }
    }

    public void g() {
        if (this.aNX == null) {
            toggle();
            return;
        }
        super.setOnCheckedChangeListener(null);
        toggle();
        super.setOnCheckedChangeListener(this.aNX);
    }

    public long getAnimationDuration() {
        return this.aNf;
    }

    public ColorStateList getBackColor() {
        return this.aMZ;
    }

    public Drawable getBackDrawable() {
        return this.aMY;
    }

    public float getBackRadius() {
        return this.aNc;
    }

    public PointF getBackSizeF() {
        return new PointF(this.aNt.width(), this.aNt.height());
    }

    public CharSequence getTextOff() {
        return this.aNL;
    }

    public CharSequence getTextOn() {
        return this.aNK;
    }

    public ColorStateList getThumbColor() {
        return this.aNa;
    }

    public Drawable getThumbDrawable() {
        return this.aMX;
    }

    public float getThumbHeight() {
        return this.aNi;
    }

    public RectF getThumbMargin() {
        return this.aNd;
    }

    public float getThumbRadius() {
        return this.aNb;
    }

    public float getThumbRangeRatio() {
        return this.aNe;
    }

    public float getThumbWidth() {
        return this.aNh;
    }

    public int getTintColor() {
        return this.aNg;
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    protected void onDraw(Canvas canvas) {
        float progress;
        super.onDraw(canvas);
        if (!this.aNV) {
            setup();
        }
        if (this.aNV) {
            if (this.aNz) {
                if (this.ab && this.aNq != null && this.aNr != null) {
                    Drawable drawable = isChecked() ? this.aNq : this.aNr;
                    Drawable drawable2 = isChecked() ? this.aNr : this.aNq;
                    int progress2 = (int) (getProgress() * 255.0f);
                    drawable.setAlpha(progress2);
                    drawable.draw(canvas);
                    drawable2.setAlpha(255 - progress2);
                    drawable2.draw(canvas);
                } else {
                    this.aMY.setAlpha(255);
                    this.aMY.draw(canvas);
                }
            } else if (this.ab) {
                int i = isChecked() ? this.aNm : this.aNn;
                int i2 = isChecked() ? this.aNn : this.aNm;
                int progress3 = (int) (getProgress() * 255.0f);
                this.aNx.setARGB((Color.alpha(i) * progress3) / 255, Color.red(i), Color.green(i), Color.blue(i));
                RectF rectF = this.aNt;
                float f = this.aNc;
                canvas.drawRoundRect(rectF, f, f, this.aNx);
                this.aNx.setARGB(((255 - progress3) * Color.alpha(i2)) / 255, Color.red(i2), Color.green(i2), Color.blue(i2));
                RectF rectF2 = this.aNt;
                float f2 = this.aNc;
                canvas.drawRoundRect(rectF2, f2, f2, this.aNx);
                this.aNx.setAlpha(255);
            } else {
                this.aNx.setColor(this.aNm);
                RectF rectF3 = this.aNt;
                float f3 = this.aNc;
                canvas.drawRoundRect(rectF3, f3, f3, this.aNx);
            }
            Layout layout = ((double) getProgress()) > 0.5d ? this.aNN : this.aNO;
            RectF rectF4 = ((double) getProgress()) > 0.5d ? this.aNv : this.aNw;
            if (layout != null && rectF4 != null) {
                if (getProgress() >= 0.75d) {
                    progress = (getProgress() * 4.0f) - 3.0f;
                } else {
                    progress = ((double) getProgress()) < 0.25d ? 1.0f - (getProgress() * 4.0f) : 0.0f;
                }
                int i3 = (int) (progress * 255.0f);
                int i4 = ((double) getProgress()) > 0.5d ? this.aNo : this.aNp;
                layout.getPaint().setARGB((i3 * Color.alpha(i4)) / 255, Color.red(i4), Color.green(i4), Color.blue(i4));
                canvas.save();
                canvas.translate(rectF4.left, rectF4.top);
                layout.draw(canvas);
                canvas.restore();
            }
            this.aND.set(this.aNs);
            this.aND.offset(this.aNC * this.aNu.width(), 0.0f);
            if (this.aNy) {
                Drawable drawable3 = this.aMX;
                RectF rectF5 = this.aND;
                drawable3.setBounds((int) rectF5.left, (int) rectF5.top, e(rectF5.right), e(this.aND.bottom));
                this.aMX.draw(canvas);
            } else {
                this.aNx.setColor(this.aNl);
                RectF rectF6 = this.aND;
                float f4 = this.aNb;
                canvas.drawRoundRect(rectF6, f4, f4, this.aNx);
            }
            if (this.aNA) {
                this.aNJ.setColor(Color.parseColor("#AA0000"));
                canvas.drawRect(this.aNt, this.aNJ);
                this.aNJ.setColor(Color.parseColor("#0000FF"));
                canvas.drawRect(this.aND, this.aNJ);
                this.aNJ.setColor(Color.parseColor(BaseBrowseView.ROOT_VIEW_COLOR));
                RectF rectF7 = this.aNu;
                float f5 = rectF7.left;
                float f6 = this.aNs.top;
                canvas.drawLine(f5, f6, rectF7.right, f6, this.aNJ);
                this.aNJ.setColor(Color.parseColor("#00CC00"));
                canvas.drawRect(((double) getProgress()) > 0.5d ? this.aNv : this.aNw, this.aNJ);
            }
        }
    }

    @Override // android.widget.TextView, android.view.View
    protected void onMeasure(int i, int i2) {
        if (this.aNN == null && !TextUtils.isEmpty(this.aNK)) {
            this.aNN = d(this.aNK);
        }
        if (this.aNO == null && !TextUtils.isEmpty(this.aNL)) {
            this.aNO = d(this.aNL);
        }
        Layout layout = this.aNN;
        float width = layout != null ? layout.getWidth() : 0.0f;
        Layout layout2 = this.aNO;
        float width2 = layout2 != null ? layout2.getWidth() : 0.0f;
        if (width == 0.0f && width2 == 0.0f) {
            this.aNP = 0.0f;
        } else {
            this.aNP = Math.max(width, width2);
        }
        Layout layout3 = this.aNN;
        float height = layout3 != null ? layout3.getHeight() : 0.0f;
        Layout layout4 = this.aNO;
        float height2 = layout4 != null ? layout4.getHeight() : 0.0f;
        if (height == 0.0f && height2 == 0.0f) {
            this.aNQ = 0.0f;
        } else {
            this.aNQ = Math.max(height, height2);
        }
        setMeasuredDimension(dg(i), dh(i2));
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        a aVar = (a) parcelable;
        a(aVar.aNY, aVar.aNZ);
        this.aNU = true;
        super.onRestoreInstanceState(aVar.getSuperState());
        this.aNU = false;
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    public Parcelable onSaveInstanceState() {
        a aVar = new a(super.onSaveInstanceState());
        aVar.aNY = this.aNK;
        aVar.aNZ = this.aNL;
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
        if (isEnabled() && isClickable() && isFocusable() && this.aNV) {
            int action = motionEvent.getAction();
            float x = motionEvent.getX() - this.aNE;
            float y = motionEvent.getY() - this.aNF;
            switch (action) {
                case 0:
                    this.aNE = motionEvent.getX();
                    this.aNF = motionEvent.getY();
                    this.aNG = this.aNE;
                    setPressed(true);
                    break;
                case 1:
                case 3:
                    this.aNW = false;
                    setPressed(false);
                    float eventTime = (float) (motionEvent.getEventTime() - motionEvent.getDownTime());
                    if (Math.abs(x) < this.aNH && Math.abs(y) < this.aNH && eventTime < this.aNI) {
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
                    setProgress(getProgress() + ((x2 - this.aNG) / this.aNu.width()));
                    if (!this.aNW && (Math.abs(x) > this.aNH / 2 || Math.abs(y) > this.aNH / 2)) {
                        if (y != 0.0f && Math.abs(x) <= Math.abs(y)) {
                            if (Math.abs(y) > Math.abs(x)) {
                                return false;
                            }
                        } else {
                            R();
                        }
                    }
                    this.aNG = x2;
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
        this.aNf = j;
    }

    public void setBackColor(ColorStateList colorStateList) {
        this.aMZ = colorStateList;
        if (this.aMZ != null) {
            setBackDrawable(null);
        }
        invalidate();
    }

    public void setBackColorRes(int i) {
        setBackColor(getResources().getColorStateList(i));
    }

    public void setBackDrawable(Drawable drawable) {
        this.aMY = drawable;
        this.aNz = this.aMY != null;
        refreshDrawableState();
        this.aNV = false;
        requestLayout();
        invalidate();
    }

    public void setBackDrawableRes(int i) {
        setBackDrawable(getResources().getDrawable(i));
    }

    public void setBackRadius(float f) {
        this.aNc = f;
        if (this.aNz) {
            return;
        }
        invalidate();
    }

    @Override // android.widget.CompoundButton, android.widget.Checkable
    public void setChecked(boolean z) {
        if (isChecked() != z) {
            b(z);
        }
        if (this.aNU) {
            setCheckedImmediatelyNoEvent(z);
        } else {
            super.setChecked(z);
        }
    }

    public void setCheckedImmediately(boolean z) {
        super.setChecked(z);
        ObjectAnimator objectAnimator = this.aNB;
        if (objectAnimator != null && objectAnimator.isRunning()) {
            this.aNB.cancel();
        }
        setProgress(z ? 1.0f : 0.0f);
        invalidate();
    }

    public void setCheckedImmediatelyNoEvent(boolean z) {
        if (this.aNX == null) {
            setCheckedImmediately(z);
            return;
        }
        super.setOnCheckedChangeListener(null);
        setCheckedImmediately(z);
        super.setOnCheckedChangeListener(this.aNX);
    }

    public void setCheckedNoEvent(boolean z) {
        if (this.aNX == null) {
            setChecked(z);
            return;
        }
        super.setOnCheckedChangeListener(null);
        setChecked(z);
        super.setOnCheckedChangeListener(this.aNX);
    }

    public void setDrawDebugRect(boolean z) {
        this.aNA = z;
        invalidate();
    }

    public void setFadeBack(boolean z) {
        this.ab = z;
    }

    @Override // android.widget.CompoundButton
    public void setOnCheckedChangeListener(CompoundButton.OnCheckedChangeListener onCheckedChangeListener) {
        super.setOnCheckedChangeListener(onCheckedChangeListener);
        this.aNX = onCheckedChangeListener;
    }

    public void setTextAdjust(int i) {
        this.aNT = i;
        this.aNV = false;
        requestLayout();
        invalidate();
    }

    public void setTextExtra(int i) {
        this.aNS = i;
        this.aNV = false;
        requestLayout();
        invalidate();
    }

    public void setTextThumbInset(int i) {
        this.aNR = i;
        this.aNV = false;
        requestLayout();
        invalidate();
    }

    public void setThumbColor(ColorStateList colorStateList) {
        this.aNa = colorStateList;
        if (this.aNa != null) {
            setThumbDrawable(null);
        }
        invalidate();
    }

    public void setThumbColorRes(int i) {
        setThumbColor(getResources().getColorStateList(i));
    }

    public void setThumbDrawable(Drawable drawable) {
        this.aMX = drawable;
        this.aNy = this.aMX != null;
        refreshDrawableState();
        this.aNV = false;
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
        this.aNb = f;
        if (this.aNy) {
            return;
        }
        invalidate();
    }

    public void setThumbRangeRatio(float f) {
        this.aNe = f;
        this.aNV = false;
        requestLayout();
    }

    public void setTintColor(int i) {
        this.aNg = i;
        this.aNa = com.baidu.poly.widget.b.dj(this.aNg);
        this.aMZ = com.baidu.poly.widget.b.dk(this.aNg);
        this.aNz = false;
        this.aNy = false;
        refreshDrawableState();
        invalidate();
    }

    public SwitchButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aNA = false;
        this.aNU = false;
        this.aNV = false;
        this.aNW = false;
        c(attributeSet);
    }

    public SwitchButton(Context context) {
        super(context);
        this.aNA = false;
        this.aNU = false;
        this.aNV = false;
        this.aNW = false;
        c(null);
    }

    private Layout d(CharSequence charSequence) {
        TextPaint textPaint = this.aNM;
        return new StaticLayout(charSequence, textPaint, (int) Math.ceil(Layout.getDesiredWidth(charSequence, textPaint)), Layout.Alignment.ALIGN_CENTER, 1.0f, 0.0f, false);
    }

    public void a(float f, float f2, float f3, float f4) {
        this.aNd.set(f, f2, f3, f4);
        this.aNV = false;
        requestLayout();
    }

    public void a(CharSequence charSequence, CharSequence charSequence2) {
        this.aNK = charSequence;
        this.aNL = charSequence2;
        this.aNN = null;
        this.aNO = null;
        this.aNV = false;
        requestLayout();
        invalidate();
    }
}
