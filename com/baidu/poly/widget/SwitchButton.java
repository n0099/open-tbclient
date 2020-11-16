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
/* loaded from: classes6.dex */
public class SwitchButton extends CompoundButton {
    private static int[] cce = {16842912, 16842910, 16842919};
    private static int[] ccf = {-16842912, 16842910, 16842919};
    private float ab;
    private float aoD;
    private RectF ccA;
    private RectF ccB;
    private RectF ccC;
    private RectF ccD;
    private Paint ccE;
    private boolean ccF;
    private boolean ccG;
    private boolean ccH;
    private ObjectAnimator ccI;
    private float ccJ;
    private RectF ccK;
    private float ccL;
    private float ccM;
    private float ccN;
    private int ccO;
    private int ccP;
    private Paint ccQ;
    private CharSequence ccR;
    private CharSequence ccS;
    private TextPaint ccT;
    private Layout ccU;
    private Layout ccV;
    private float ccW;
    private float ccX;
    private int ccY;
    private int ccZ;
    private Drawable ccg;
    private Drawable cch;
    private ColorStateList cci;
    private ColorStateList ccj;
    private RectF cck;
    private float ccl;
    private long ccm;
    private boolean ccn;
    private int cco;
    private int ccp;
    private int ccq;
    private int ccr;
    private int cct;
    private int ccu;
    private int ccv;
    private int ccw;
    private Drawable ccx;
    private Drawable ccy;
    private RectF ccz;
    private int cda;
    private boolean cdb;
    private boolean cdc;
    private boolean cdd;
    private CompoundButton.OnCheckedChangeListener cde;
    private int ib;
    private int pb;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public static class a extends View.BaseSavedState {
        public static final Parcelable.Creator<a> CREATOR = new C0311a();
        CharSequence cdf;
        CharSequence cdg;

        /* renamed from: com.baidu.poly.widget.SwitchButton$a$a  reason: collision with other inner class name */
        /* loaded from: classes6.dex */
        static class C0311a implements Parcelable.Creator<a> {
            C0311a() {
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // android.os.Parcelable.Creator
            /* renamed from: gS */
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
            TextUtils.writeToParcel(this.cdf, parcel, i);
            TextUtils.writeToParcel(this.cdg, parcel, i);
        }

        a(Parcelable parcelable) {
            super(parcelable);
        }

        private a(Parcel parcel) {
            super(parcel);
            this.cdf = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
            this.cdg = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
        }
    }

    public SwitchButton(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.ccH = false;
        this.cdb = false;
        this.cdc = false;
        this.cdd = false;
        c(attributeSet);
    }

    private void aaL() {
        ViewParent parent = getParent();
        if (parent != null) {
            parent.requestDisallowInterceptTouchEvent(true);
        }
        this.cdd = true;
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
        this.ccO = ViewConfiguration.get(getContext()).getScaledTouchSlop();
        this.ccP = ViewConfiguration.getPressedStateDuration() + ViewConfiguration.getTapTimeout();
        this.ccE = new Paint(1);
        this.ccQ = new Paint(1);
        this.ccQ.setStyle(Paint.Style.STROKE);
        this.ccQ.setStrokeWidth(getResources().getDisplayMetrics().density);
        this.ccT = getPaint();
        this.ccz = new RectF();
        this.ccA = new RectF();
        this.ccB = new RectF();
        this.cck = new RectF();
        this.ccC = new RectF();
        this.ccD = new RectF();
        this.ccI = ObjectAnimator.ofFloat(this, "progress", 0.0f, 0.0f).setDuration(250L);
        this.ccI.setInterpolator(new AccelerateDecelerateInterpolator());
        this.ccK = new RectF();
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
        this.ccR = str2;
        this.ccS = str;
        this.ccY = i4;
        this.ccZ = i3;
        this.cda = i5;
        this.ccg = drawable;
        this.ccj = colorStateList;
        this.ccF = this.ccg != null;
        this.cco = i2;
        if (this.cco == 0) {
            new TypedValue();
            this.cco = 3309506;
        }
        if (!this.ccF && this.ccj == null) {
            this.ccj = com.baidu.poly.widget.b.gP(this.cco);
            this.cct = this.ccj.getDefaultColor();
        }
        this.ccp = p(f5);
        this.ib = p(f6);
        this.cch = drawable2;
        this.cci = colorStateList2;
        this.ccG = this.cch != null;
        if (!this.ccG && this.cci == null) {
            this.cci = com.baidu.poly.widget.b.gQ(this.cco);
            this.ccu = this.cci.getDefaultColor();
            this.ccv = this.cci.getColorForState(cce, this.ccu);
        }
        this.cck.set(f, f3, f2, f4);
        this.ccl = this.cck.width() >= 0.0f ? Math.max(f9, 1.0f) : f9;
        this.ab = f7;
        this.aoD = f8;
        this.ccm = i;
        this.ccn = z;
        this.ccI.setDuration(this.ccm);
        if (isChecked()) {
            setProgress(1.0f);
        }
    }

    private int gM(int i) {
        int i2;
        int size = View.MeasureSpec.getSize(i);
        int mode = View.MeasureSpec.getMode(i);
        if (this.ccp == 0 && this.ccF) {
            this.ccp = this.ccg.getIntrinsicWidth();
        }
        int p = p(this.ccW);
        if (this.ccl == 0.0f) {
            this.ccl = 1.8f;
        }
        if (mode == 1073741824) {
            int paddingLeft = (size - getPaddingLeft()) - getPaddingRight();
            if (this.ccp != 0) {
                int p2 = p(i2 * this.ccl);
                RectF rectF = this.cck;
                int p3 = (this.ccZ + p) - ((p2 - this.ccp) + p(Math.max(rectF.left, rectF.right)));
                float f = p2;
                RectF rectF2 = this.cck;
                this.ccq = p(rectF2.right + rectF2.left + f + Math.max(p3, 0));
                if (this.ccq < 0) {
                    this.ccp = 0;
                }
                if (f + Math.max(this.cck.left, 0.0f) + Math.max(this.cck.right, 0.0f) + Math.max(p3, 0) > paddingLeft) {
                    this.ccp = 0;
                }
            }
            if (this.ccp == 0) {
                int p4 = p((((size - getPaddingLeft()) - getPaddingRight()) - Math.max(this.cck.left, 0.0f)) - Math.max(this.cck.right, 0.0f));
                if (p4 < 0) {
                    this.ccp = 0;
                    this.ccq = 0;
                    return size;
                }
                float f2 = p4;
                this.ccp = p(f2 / this.ccl);
                RectF rectF3 = this.cck;
                this.ccq = p(f2 + rectF3.left + rectF3.right);
                if (this.ccq < 0) {
                    this.ccp = 0;
                    this.ccq = 0;
                    return size;
                }
                int i3 = p + this.ccZ;
                int i4 = p4 - this.ccp;
                RectF rectF4 = this.cck;
                int p5 = i3 - (i4 + p(Math.max(rectF4.left, rectF4.right)));
                if (p5 > 0) {
                    this.ccp -= p5;
                }
                if (this.ccp < 0) {
                    this.ccp = 0;
                    this.ccq = 0;
                    return size;
                }
                return size;
            }
            return size;
        }
        if (this.ccp == 0) {
            this.ccp = p(getResources().getDisplayMetrics().density * 20.0f);
        }
        if (this.ccl == 0.0f) {
            this.ccl = 1.8f;
        }
        int p6 = p(this.ccp * this.ccl);
        RectF rectF5 = this.cck;
        int p7 = p((p + this.ccZ) - (((p6 - this.ccp) + Math.max(rectF5.left, rectF5.right)) + this.ccY));
        float f3 = p6;
        RectF rectF6 = this.cck;
        this.ccq = p(rectF6.right + rectF6.left + f3 + Math.max(0, p7));
        if (this.ccq < 0) {
            this.ccp = 0;
            this.ccq = 0;
            return size;
        }
        int p8 = p(Math.max(0.0f, this.cck.left) + f3 + Math.max(0.0f, this.cck.right) + Math.max(0, p7));
        return Math.max(p8, getPaddingLeft() + p8 + getPaddingRight());
    }

    private int gN(int i) {
        int i2;
        int i3;
        int i4;
        int size = View.MeasureSpec.getSize(i);
        int mode = View.MeasureSpec.getMode(i);
        if (this.ib == 0 && this.ccF) {
            this.ib = this.ccg.getIntrinsicHeight();
        }
        if (mode == 1073741824) {
            if (this.ib != 0) {
                RectF rectF = this.cck;
                this.ccr = p(i3 + rectF.top + rectF.bottom);
                this.ccr = p(Math.max(this.ccr, this.ccX));
                if ((((this.ccr + getPaddingTop()) + getPaddingBottom()) - Math.min(0.0f, this.cck.top)) - Math.min(0.0f, this.cck.bottom) > size) {
                    this.ib = 0;
                }
            }
            if (this.ib == 0) {
                this.ccr = p(((size - getPaddingTop()) - getPaddingBottom()) + Math.min(0.0f, this.cck.top) + Math.min(0.0f, this.cck.bottom));
                if (this.ccr < 0) {
                    this.ccr = 0;
                    this.ib = 0;
                    return size;
                }
                RectF rectF2 = this.cck;
                this.ib = p((i4 - rectF2.top) - rectF2.bottom);
            }
            if (this.ib < 0) {
                this.ccr = 0;
                this.ib = 0;
                return size;
            }
            return size;
        }
        if (this.ib == 0) {
            this.ib = p(getResources().getDisplayMetrics().density * 20.0f);
        }
        RectF rectF3 = this.cck;
        this.ccr = p(this.ib + rectF3.top + rectF3.bottom);
        if (this.ccr < 0) {
            this.ccr = 0;
            this.ib = 0;
            return size;
        }
        int p = p(this.ccX - i2);
        if (p > 0) {
            this.ccr += p;
            this.ib = p + this.ib;
        }
        int max = Math.max(this.ib, this.ccr);
        return Math.max(Math.max(max, getPaddingTop() + max + getPaddingBottom()), getSuggestedMinimumHeight());
    }

    private float getProgress() {
        return this.ccJ;
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
        this.ccJ = f;
        invalidate();
    }

    private void setup() {
        int i;
        float paddingTop;
        float paddingLeft;
        int i2 = this.ccp;
        if (i2 != 0 && (i = this.ib) != 0 && this.ccq != 0 && this.ccr != 0) {
            if (this.ab == -1.0f) {
                this.ab = Math.min(i2, i) / 2;
            }
            if (this.aoD == -1.0f) {
                this.aoD = Math.min(this.ccq, this.ccr) / 2;
            }
            int measuredWidth = (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight();
            int measuredHeight = (getMeasuredHeight() - getPaddingTop()) - getPaddingBottom();
            int p = p((this.ccq - Math.min(0.0f, this.cck.left)) - Math.min(0.0f, this.cck.right));
            int p2 = p((this.ccr - Math.min(0.0f, this.cck.top)) - Math.min(0.0f, this.cck.bottom));
            if (measuredHeight <= p2) {
                paddingTop = getPaddingTop() + Math.max(0.0f, this.cck.top);
            } else {
                paddingTop = (((measuredHeight - p2) + 1) / 2) + getPaddingTop() + Math.max(0.0f, this.cck.top);
            }
            if (measuredWidth <= this.ccq) {
                paddingLeft = getPaddingLeft() + Math.max(0.0f, this.cck.left);
            } else {
                paddingLeft = (((measuredWidth - p) + 1) / 2) + getPaddingLeft() + Math.max(0.0f, this.cck.left);
            }
            this.ccz.set(paddingLeft, paddingTop, this.ccp + paddingLeft, this.ib + paddingTop);
            RectF rectF = this.ccz;
            float f = rectF.left;
            RectF rectF2 = this.cck;
            float f2 = f - rectF2.left;
            RectF rectF3 = this.ccA;
            float f3 = rectF.top;
            float f4 = rectF2.top;
            rectF3.set(f2, f3 - f4, this.ccq + f2, (f3 - f4) + this.ccr);
            RectF rectF4 = this.ccB;
            RectF rectF5 = this.ccz;
            rectF4.set(rectF5.left, 0.0f, (this.ccA.right - this.cck.right) - rectF5.width(), 0.0f);
            this.aoD = Math.min(Math.min(this.ccA.width(), this.ccA.height()) / 2.0f, this.aoD);
            Drawable drawable = this.cch;
            if (drawable != null) {
                RectF rectF6 = this.ccA;
                drawable.setBounds((int) rectF6.left, (int) rectF6.top, p(rectF6.right), p(this.ccA.bottom));
            }
            if (this.ccU != null) {
                RectF rectF7 = this.ccA;
                float width = ((((((rectF7.width() + this.ccY) - this.ccp) - this.cck.right) - this.ccU.getWidth()) / 2.0f) + rectF7.left) - this.cda;
                RectF rectF8 = this.ccA;
                float height = ((rectF8.height() - this.ccU.getHeight()) / 2.0f) + rectF8.top;
                this.ccC.set(width, height, this.ccU.getWidth() + width, this.ccU.getHeight() + height);
            }
            if (this.ccV != null) {
                RectF rectF9 = this.ccA;
                float width2 = ((rectF9.right - (((((rectF9.width() + this.ccY) - this.ccp) - this.cck.left) - this.ccV.getWidth()) / 2.0f)) - this.ccV.getWidth()) + this.cda;
                RectF rectF10 = this.ccA;
                float height2 = ((rectF10.height() - this.ccV.getHeight()) / 2.0f) + rectF10.top;
                this.ccD.set(width2, height2, this.ccV.getWidth() + width2, this.ccV.getHeight() + height2);
            }
            this.cdc = true;
        }
    }

    protected void b(boolean z) {
        ObjectAnimator objectAnimator = this.ccI;
        if (objectAnimator != null) {
            if (objectAnimator.isRunning()) {
                this.ccI.cancel();
            }
            this.ccI.setDuration(this.ccm);
            if (z) {
                this.ccI.setFloatValues(this.ccJ, 1.0f);
            } else {
                this.ccI.setFloatValues(this.ccJ, 0.0f);
            }
            this.ccI.start();
        }
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    protected void drawableStateChanged() {
        ColorStateList colorStateList;
        ColorStateList colorStateList2;
        super.drawableStateChanged();
        if (!this.ccF && (colorStateList2 = this.ccj) != null) {
            this.cct = colorStateList2.getColorForState(getDrawableState(), this.cct);
        } else {
            setDrawableState(this.ccg);
        }
        int[] iArr = isChecked() ? ccf : cce;
        ColorStateList textColors = getTextColors();
        if (textColors != null) {
            int defaultColor = textColors.getDefaultColor();
            this.ccw = textColors.getColorForState(cce, defaultColor);
            this.pb = textColors.getColorForState(ccf, defaultColor);
        }
        if (!this.ccG && (colorStateList = this.cci) != null) {
            this.ccu = colorStateList.getColorForState(getDrawableState(), this.ccu);
            this.ccv = this.cci.getColorForState(iArr, this.ccu);
            return;
        }
        Drawable drawable = this.cch;
        if ((drawable instanceof StateListDrawable) && this.ccn) {
            drawable.setState(iArr);
            this.ccy = this.cch.getCurrent().mutate();
        } else {
            this.ccy = null;
        }
        setDrawableState(this.cch);
        Drawable drawable2 = this.cch;
        if (drawable2 != null) {
            this.ccx = drawable2.getCurrent().mutate();
        }
    }

    public long getAnimationDuration() {
        return this.ccm;
    }

    public ColorStateList getBackColor() {
        return this.cci;
    }

    public Drawable getBackDrawable() {
        return this.cch;
    }

    public float getBackRadius() {
        return this.aoD;
    }

    public PointF getBackSizeF() {
        return new PointF(this.ccA.width(), this.ccA.height());
    }

    public CharSequence getTextOff() {
        return this.ccS;
    }

    public CharSequence getTextOn() {
        return this.ccR;
    }

    public ColorStateList getThumbColor() {
        return this.ccj;
    }

    public Drawable getThumbDrawable() {
        return this.ccg;
    }

    public float getThumbHeight() {
        return this.ib;
    }

    public RectF getThumbMargin() {
        return this.cck;
    }

    public float getThumbRadius() {
        return this.ab;
    }

    public float getThumbRangeRatio() {
        return this.ccl;
    }

    public float getThumbWidth() {
        return this.ccp;
    }

    public int getTintColor() {
        return this.cco;
    }

    public void o() {
        if (this.cde == null) {
            toggle();
            return;
        }
        super.setOnCheckedChangeListener(null);
        toggle();
        super.setOnCheckedChangeListener(this.cde);
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (!this.cdc) {
            setup();
        }
        if (this.cdc) {
            if (this.ccG) {
                if (this.ccn && this.ccx != null && this.ccy != null) {
                    Drawable drawable = isChecked() ? this.ccx : this.ccy;
                    Drawable drawable2 = isChecked() ? this.ccy : this.ccx;
                    int progress = (int) (getProgress() * 255.0f);
                    drawable.setAlpha(progress);
                    drawable.draw(canvas);
                    drawable2.setAlpha(255 - progress);
                    drawable2.draw(canvas);
                } else {
                    this.cch.setAlpha(255);
                    this.cch.draw(canvas);
                }
            } else if (this.ccn) {
                int i = isChecked() ? this.ccu : this.ccv;
                int i2 = isChecked() ? this.ccv : this.ccu;
                int progress2 = (int) (getProgress() * 255.0f);
                this.ccE.setARGB((Color.alpha(i) * progress2) / 255, Color.red(i), Color.green(i), Color.blue(i));
                RectF rectF = this.ccA;
                float f = this.aoD;
                canvas.drawRoundRect(rectF, f, f, this.ccE);
                this.ccE.setARGB(((255 - progress2) * Color.alpha(i2)) / 255, Color.red(i2), Color.green(i2), Color.blue(i2));
                RectF rectF2 = this.ccA;
                float f2 = this.aoD;
                canvas.drawRoundRect(rectF2, f2, f2, this.ccE);
                this.ccE.setAlpha(255);
            } else {
                this.ccE.setColor(this.ccu);
                RectF rectF3 = this.ccA;
                float f3 = this.aoD;
                canvas.drawRoundRect(rectF3, f3, f3, this.ccE);
            }
            Layout layout = ((double) getProgress()) > 0.5d ? this.ccU : this.ccV;
            RectF rectF4 = ((double) getProgress()) > 0.5d ? this.ccC : this.ccD;
            if (layout != null && rectF4 != null) {
                int progress3 = (int) ((((double) getProgress()) >= 0.75d ? (getProgress() * 4.0f) - 3.0f : ((double) getProgress()) < 0.25d ? 1.0f - (getProgress() * 4.0f) : 0.0f) * 255.0f);
                int i3 = ((double) getProgress()) > 0.5d ? this.ccw : this.pb;
                layout.getPaint().setARGB((progress3 * Color.alpha(i3)) / 255, Color.red(i3), Color.green(i3), Color.blue(i3));
                canvas.save();
                canvas.translate(rectF4.left, rectF4.top);
                layout.draw(canvas);
                canvas.restore();
            }
            this.ccK.set(this.ccz);
            this.ccK.offset(this.ccJ * this.ccB.width(), 0.0f);
            if (this.ccF) {
                Drawable drawable3 = this.ccg;
                RectF rectF5 = this.ccK;
                drawable3.setBounds((int) rectF5.left, (int) rectF5.top, p(rectF5.right), p(this.ccK.bottom));
                this.ccg.draw(canvas);
            } else {
                this.ccE.setColor(this.cct);
                RectF rectF6 = this.ccK;
                float f4 = this.ab;
                canvas.drawRoundRect(rectF6, f4, f4, this.ccE);
            }
            if (this.ccH) {
                this.ccQ.setColor(Color.parseColor("#AA0000"));
                canvas.drawRect(this.ccA, this.ccQ);
                this.ccQ.setColor(Color.parseColor("#0000FF"));
                canvas.drawRect(this.ccK, this.ccQ);
                this.ccQ.setColor(Color.parseColor("#000000"));
                RectF rectF7 = this.ccB;
                float f5 = rectF7.left;
                float f6 = this.ccz.top;
                canvas.drawLine(f5, f6, rectF7.right, f6, this.ccQ);
                this.ccQ.setColor(Color.parseColor("#00CC00"));
                canvas.drawRect(((double) getProgress()) > 0.5d ? this.ccC : this.ccD, this.ccQ);
            }
        }
    }

    @Override // android.widget.TextView, android.view.View
    protected void onMeasure(int i, int i2) {
        if (this.ccU == null && !TextUtils.isEmpty(this.ccR)) {
            this.ccU = e(this.ccR);
        }
        if (this.ccV == null && !TextUtils.isEmpty(this.ccS)) {
            this.ccV = e(this.ccS);
        }
        Layout layout = this.ccU;
        float width = layout != null ? layout.getWidth() : 0.0f;
        Layout layout2 = this.ccV;
        float width2 = layout2 != null ? layout2.getWidth() : 0.0f;
        if (width == 0.0f && width2 == 0.0f) {
            this.ccW = 0.0f;
        } else {
            this.ccW = Math.max(width, width2);
        }
        Layout layout3 = this.ccU;
        float height = layout3 != null ? layout3.getHeight() : 0.0f;
        Layout layout4 = this.ccV;
        float height2 = layout4 != null ? layout4.getHeight() : 0.0f;
        if (height == 0.0f && height2 == 0.0f) {
            this.ccX = 0.0f;
        } else {
            this.ccX = Math.max(height, height2);
        }
        setMeasuredDimension(gM(i), gN(i2));
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        a aVar = (a) parcelable;
        a(aVar.cdf, aVar.cdg);
        this.cdb = true;
        super.onRestoreInstanceState(aVar.getSuperState());
        this.cdb = false;
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    public Parcelable onSaveInstanceState() {
        a aVar = new a(super.onSaveInstanceState());
        aVar.cdf = this.ccR;
        aVar.cdg = this.ccS;
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
        if (isEnabled() && isClickable() && isFocusable() && this.cdc) {
            int action = motionEvent.getAction();
            float x = motionEvent.getX() - this.ccL;
            float y = motionEvent.getY() - this.ccM;
            switch (action) {
                case 0:
                    this.ccL = motionEvent.getX();
                    this.ccM = motionEvent.getY();
                    this.ccN = this.ccL;
                    setPressed(true);
                    break;
                case 1:
                case 3:
                    this.cdd = false;
                    setPressed(false);
                    float eventTime = (float) (motionEvent.getEventTime() - motionEvent.getDownTime());
                    if (Math.abs(x) < this.ccO && Math.abs(y) < this.ccO && eventTime < this.ccP) {
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
                    setProgress(getProgress() + ((x2 - this.ccN) / this.ccB.width()));
                    if (!this.cdd && (Math.abs(x) > this.ccO / 2 || Math.abs(y) > this.ccO / 2)) {
                        if (y != 0.0f && Math.abs(x) <= Math.abs(y)) {
                            if (Math.abs(y) > Math.abs(x)) {
                                return false;
                            }
                        } else {
                            aaL();
                        }
                    }
                    this.ccN = x2;
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
        this.ccm = j;
    }

    public void setBackColor(ColorStateList colorStateList) {
        this.cci = colorStateList;
        if (this.cci != null) {
            setBackDrawable(null);
        }
        invalidate();
    }

    public void setBackColorRes(int i) {
        setBackColor(getResources().getColorStateList(i));
    }

    public void setBackDrawable(Drawable drawable) {
        this.cch = drawable;
        this.ccG = this.cch != null;
        refreshDrawableState();
        this.cdc = false;
        requestLayout();
        invalidate();
    }

    public void setBackDrawableRes(int i) {
        setBackDrawable(getResources().getDrawable(i));
    }

    public void setBackRadius(float f) {
        this.aoD = f;
        if (this.ccG) {
            return;
        }
        invalidate();
    }

    @Override // android.widget.CompoundButton, android.widget.Checkable
    public void setChecked(boolean z) {
        if (isChecked() != z) {
            b(z);
        }
        if (this.cdb) {
            setCheckedImmediatelyNoEvent(z);
        } else {
            super.setChecked(z);
        }
    }

    public void setCheckedImmediately(boolean z) {
        super.setChecked(z);
        ObjectAnimator objectAnimator = this.ccI;
        if (objectAnimator != null && objectAnimator.isRunning()) {
            this.ccI.cancel();
        }
        setProgress(z ? 1.0f : 0.0f);
        invalidate();
    }

    public void setCheckedImmediatelyNoEvent(boolean z) {
        if (this.cde == null) {
            setCheckedImmediately(z);
            return;
        }
        super.setOnCheckedChangeListener(null);
        setCheckedImmediately(z);
        super.setOnCheckedChangeListener(this.cde);
    }

    public void setCheckedNoEvent(boolean z) {
        if (this.cde == null) {
            setChecked(z);
            return;
        }
        super.setOnCheckedChangeListener(null);
        setChecked(z);
        super.setOnCheckedChangeListener(this.cde);
    }

    public void setDrawDebugRect(boolean z) {
        this.ccH = z;
        invalidate();
    }

    public void setFadeBack(boolean z) {
        this.ccn = z;
    }

    @Override // android.widget.CompoundButton
    public void setOnCheckedChangeListener(CompoundButton.OnCheckedChangeListener onCheckedChangeListener) {
        super.setOnCheckedChangeListener(onCheckedChangeListener);
        this.cde = onCheckedChangeListener;
    }

    public void setTextAdjust(int i) {
        this.cda = i;
        this.cdc = false;
        requestLayout();
        invalidate();
    }

    public void setTextExtra(int i) {
        this.ccZ = i;
        this.cdc = false;
        requestLayout();
        invalidate();
    }

    public void setTextThumbInset(int i) {
        this.ccY = i;
        this.cdc = false;
        requestLayout();
        invalidate();
    }

    public void setThumbColor(ColorStateList colorStateList) {
        this.ccj = colorStateList;
        if (this.ccj != null) {
            setThumbDrawable(null);
        }
        invalidate();
    }

    public void setThumbColorRes(int i) {
        setThumbColor(getResources().getColorStateList(i));
    }

    public void setThumbDrawable(Drawable drawable) {
        this.ccg = drawable;
        this.ccF = this.ccg != null;
        refreshDrawableState();
        this.cdc = false;
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
        if (this.ccF) {
            return;
        }
        invalidate();
    }

    public void setThumbRangeRatio(float f) {
        this.ccl = f;
        this.cdc = false;
        requestLayout();
    }

    public void setTintColor(int i) {
        this.cco = i;
        this.ccj = com.baidu.poly.widget.b.gP(this.cco);
        this.cci = com.baidu.poly.widget.b.gQ(this.cco);
        this.ccG = false;
        this.ccF = false;
        refreshDrawableState();
        invalidate();
    }

    public SwitchButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.ccH = false;
        this.cdb = false;
        this.cdc = false;
        this.cdd = false;
        c(attributeSet);
    }

    public SwitchButton(Context context) {
        super(context);
        this.ccH = false;
        this.cdb = false;
        this.cdc = false;
        this.cdd = false;
        c(null);
    }

    private Layout e(CharSequence charSequence) {
        TextPaint textPaint = this.ccT;
        return new StaticLayout(charSequence, textPaint, (int) Math.ceil(Layout.getDesiredWidth(charSequence, textPaint)), Layout.Alignment.ALIGN_CENTER, 1.0f, 0.0f, false);
    }

    public void a(float f, float f2, float f3, float f4) {
        this.cck.set(f, f2, f3, f4);
        this.cdc = false;
        requestLayout();
    }

    public void a(CharSequence charSequence, CharSequence charSequence2) {
        this.ccR = charSequence;
        this.ccS = charSequence2;
        this.ccU = null;
        this.ccV = null;
        this.cdc = false;
        requestLayout();
        invalidate();
    }
}
