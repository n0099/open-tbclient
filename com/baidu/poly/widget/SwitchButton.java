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
    private static int[] boD = {16842912, 16842910, 16842919};
    private static int[] boE = {-16842912, 16842910, 16842919};
    private boolean ab;
    private Drawable boF;
    private Drawable boG;
    private ColorStateList boH;
    private ColorStateList boI;
    private float boJ;
    private float boK;
    private RectF boL;
    private float boM;
    private long boN;
    private int boO;
    private int boP;
    private int boQ;
    private int boR;
    private int boS;
    private int boT;
    private int boU;
    private int boV;
    private int boW;
    private Drawable boX;
    private Drawable boY;
    private RectF boZ;
    private boolean bpA;
    private boolean bpB;
    private CompoundButton.OnCheckedChangeListener bpC;
    private RectF bpa;
    private RectF bpb;
    private RectF bpc;
    private RectF bpd;
    private Paint bpe;
    private boolean bpf;
    private boolean bpg;
    private ObjectAnimator bph;
    private RectF bpi;
    private float bpj;
    private float bpk;
    private float bpl;
    private int bpm;
    private int bpn;
    private Paint bpo;
    private CharSequence bpp;
    private CharSequence bpq;
    private TextPaint bpr;
    private Layout bps;
    private Layout bpt;
    private float bpu;
    private float bpv;
    private int bpw;
    private int bpx;
    private int bpy;
    private boolean bpz;
    private int cb;
    private boolean tb;
    private float xb;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes11.dex */
    public static class a extends View.BaseSavedState {
        public static final Parcelable.Creator<a> CREATOR = new C0189a();
        CharSequence bpD;
        CharSequence bpE;

        /* renamed from: com.baidu.poly.widget.SwitchButton$a$a  reason: collision with other inner class name */
        /* loaded from: classes11.dex */
        static class C0189a implements Parcelable.Creator<a> {
            C0189a() {
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // android.os.Parcelable.Creator
            /* renamed from: dJ */
            public a[] newArray(int i) {
                return new a[i];
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // android.os.Parcelable.Creator
            /* renamed from: m */
            public a createFromParcel(Parcel parcel) {
                return new a(parcel);
            }
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            TextUtils.writeToParcel(this.bpD, parcel, i);
            TextUtils.writeToParcel(this.bpE, parcel, i);
        }

        a(Parcelable parcelable) {
            super(parcelable);
        }

        private a(Parcel parcel) {
            super(parcel);
            this.bpD = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
            this.bpE = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
        }
    }

    public SwitchButton(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.bpg = false;
        this.bpz = false;
        this.bpA = false;
        this.bpB = false;
        c(attributeSet);
    }

    private void R() {
        ViewParent parent = getParent();
        if (parent != null) {
            parent.requestDisallowInterceptTouchEvent(true);
        }
        this.bpB = true;
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
        this.bpm = ViewConfiguration.get(getContext()).getScaledTouchSlop();
        this.bpn = ViewConfiguration.getPressedStateDuration() + ViewConfiguration.getTapTimeout();
        this.bpe = new Paint(1);
        this.bpo = new Paint(1);
        this.bpo.setStyle(Paint.Style.STROKE);
        this.bpo.setStrokeWidth(getResources().getDisplayMetrics().density);
        this.bpr = getPaint();
        this.boZ = new RectF();
        this.bpa = new RectF();
        this.bpb = new RectF();
        this.boL = new RectF();
        this.bpc = new RectF();
        this.bpd = new RectF();
        this.bph = ObjectAnimator.ofFloat(this, "progress", 0.0f, 0.0f).setDuration(250L);
        this.bph.setInterpolator(new AccelerateDecelerateInterpolator());
        this.bpi = new RectF();
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
        this.bpp = str2;
        this.bpq = str;
        this.bpw = i4;
        this.bpx = i3;
        this.bpy = i5;
        this.boF = drawable;
        this.boI = colorStateList;
        this.tb = this.boF != null;
        this.boO = i2;
        if (this.boO == 0) {
            new TypedValue();
            this.boO = 3309506;
        }
        if (!this.tb && this.boI == null) {
            this.boI = com.baidu.poly.widget.b.dG(this.boO);
            this.boS = this.boI.getDefaultColor();
        }
        this.cb = j(f5);
        this.boP = j(f6);
        this.boG = drawable2;
        this.boH = colorStateList2;
        this.bpf = this.boG != null;
        if (!this.bpf && this.boH == null) {
            this.boH = com.baidu.poly.widget.b.dH(this.boO);
            this.boT = this.boH.getDefaultColor();
            this.boU = this.boH.getColorForState(boD, this.boT);
        }
        this.boL.set(f, f3, f2, f4);
        this.boM = this.boL.width() >= 0.0f ? Math.max(f9, 1.0f) : f9;
        this.boJ = f7;
        this.boK = f8;
        this.boN = i;
        this.ab = z;
        this.bph.setDuration(this.boN);
        if (isChecked()) {
            setProgress(1.0f);
        }
    }

    private int dE(int i) {
        int i2;
        int size = View.MeasureSpec.getSize(i);
        int mode = View.MeasureSpec.getMode(i);
        if (this.cb == 0 && this.tb) {
            this.cb = this.boF.getIntrinsicWidth();
        }
        int j = j(this.bpu);
        if (this.boM == 0.0f) {
            this.boM = 1.8f;
        }
        if (mode == 1073741824) {
            int paddingLeft = (size - getPaddingLeft()) - getPaddingRight();
            if (this.cb != 0) {
                int j2 = j(i2 * this.boM);
                RectF rectF = this.boL;
                int j3 = (this.bpx + j) - ((j2 - this.cb) + j(Math.max(rectF.left, rectF.right)));
                float f = j2;
                RectF rectF2 = this.boL;
                this.boQ = j(rectF2.right + rectF2.left + f + Math.max(j3, 0));
                if (this.boQ < 0) {
                    this.cb = 0;
                }
                if (f + Math.max(this.boL.left, 0.0f) + Math.max(this.boL.right, 0.0f) + Math.max(j3, 0) > paddingLeft) {
                    this.cb = 0;
                }
            }
            if (this.cb == 0) {
                int j4 = j((((size - getPaddingLeft()) - getPaddingRight()) - Math.max(this.boL.left, 0.0f)) - Math.max(this.boL.right, 0.0f));
                if (j4 < 0) {
                    this.cb = 0;
                    this.boQ = 0;
                    return size;
                }
                float f2 = j4;
                this.cb = j(f2 / this.boM);
                RectF rectF3 = this.boL;
                this.boQ = j(f2 + rectF3.left + rectF3.right);
                if (this.boQ < 0) {
                    this.cb = 0;
                    this.boQ = 0;
                    return size;
                }
                int i3 = j + this.bpx;
                int i4 = j4 - this.cb;
                RectF rectF4 = this.boL;
                int j5 = i3 - (i4 + j(Math.max(rectF4.left, rectF4.right)));
                if (j5 > 0) {
                    this.cb -= j5;
                }
                if (this.cb < 0) {
                    this.cb = 0;
                    this.boQ = 0;
                    return size;
                }
                return size;
            }
            return size;
        }
        if (this.cb == 0) {
            this.cb = j(getResources().getDisplayMetrics().density * 20.0f);
        }
        if (this.boM == 0.0f) {
            this.boM = 1.8f;
        }
        int j6 = j(this.cb * this.boM);
        RectF rectF5 = this.boL;
        int j7 = j((j + this.bpx) - (((j6 - this.cb) + Math.max(rectF5.left, rectF5.right)) + this.bpw));
        float f3 = j6;
        RectF rectF6 = this.boL;
        this.boQ = j(rectF6.right + rectF6.left + f3 + Math.max(0, j7));
        if (this.boQ < 0) {
            this.cb = 0;
            this.boQ = 0;
            return size;
        }
        int j8 = j(Math.max(0.0f, this.boL.left) + f3 + Math.max(0.0f, this.boL.right) + Math.max(0, j7));
        return Math.max(j8, getPaddingLeft() + j8 + getPaddingRight());
    }

    private float getProgress() {
        return this.xb;
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
        if (this.boP == 0 && this.tb) {
            this.boP = this.boF.getIntrinsicHeight();
        }
        if (mode == 1073741824) {
            if (this.boP != 0) {
                RectF rectF = this.boL;
                this.boR = j(i3 + rectF.top + rectF.bottom);
                this.boR = j(Math.max(this.boR, this.bpv));
                if ((((this.boR + getPaddingTop()) + getPaddingBottom()) - Math.min(0.0f, this.boL.top)) - Math.min(0.0f, this.boL.bottom) > size) {
                    this.boP = 0;
                }
            }
            if (this.boP == 0) {
                this.boR = j(((size - getPaddingTop()) - getPaddingBottom()) + Math.min(0.0f, this.boL.top) + Math.min(0.0f, this.boL.bottom));
                if (this.boR < 0) {
                    this.boR = 0;
                    this.boP = 0;
                    return size;
                }
                RectF rectF2 = this.boL;
                this.boP = j((i4 - rectF2.top) - rectF2.bottom);
            }
            if (this.boP < 0) {
                this.boR = 0;
                this.boP = 0;
                return size;
            }
            return size;
        }
        if (this.boP == 0) {
            this.boP = j(getResources().getDisplayMetrics().density * 20.0f);
        }
        RectF rectF3 = this.boL;
        this.boR = j(this.boP + rectF3.top + rectF3.bottom);
        if (this.boR < 0) {
            this.boR = 0;
            this.boP = 0;
            return size;
        }
        int j = j(this.bpv - i2);
        if (j > 0) {
            this.boR += j;
            this.boP = j + this.boP;
        }
        int max = Math.max(this.boP, this.boR);
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
        this.xb = f;
        invalidate();
    }

    private void setup() {
        int i;
        float paddingTop;
        float paddingLeft;
        int i2 = this.cb;
        if (i2 != 0 && (i = this.boP) != 0 && this.boQ != 0 && this.boR != 0) {
            if (this.boJ == -1.0f) {
                this.boJ = Math.min(i2, i) / 2;
            }
            if (this.boK == -1.0f) {
                this.boK = Math.min(this.boQ, this.boR) / 2;
            }
            int measuredWidth = (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight();
            int measuredHeight = (getMeasuredHeight() - getPaddingTop()) - getPaddingBottom();
            int j = j((this.boQ - Math.min(0.0f, this.boL.left)) - Math.min(0.0f, this.boL.right));
            int j2 = j((this.boR - Math.min(0.0f, this.boL.top)) - Math.min(0.0f, this.boL.bottom));
            if (measuredHeight <= j2) {
                paddingTop = getPaddingTop() + Math.max(0.0f, this.boL.top);
            } else {
                paddingTop = (((measuredHeight - j2) + 1) / 2) + getPaddingTop() + Math.max(0.0f, this.boL.top);
            }
            if (measuredWidth <= this.boQ) {
                paddingLeft = getPaddingLeft() + Math.max(0.0f, this.boL.left);
            } else {
                paddingLeft = (((measuredWidth - j) + 1) / 2) + getPaddingLeft() + Math.max(0.0f, this.boL.left);
            }
            this.boZ.set(paddingLeft, paddingTop, this.cb + paddingLeft, this.boP + paddingTop);
            RectF rectF = this.boZ;
            float f = rectF.left;
            RectF rectF2 = this.boL;
            float f2 = f - rectF2.left;
            RectF rectF3 = this.bpa;
            float f3 = rectF.top;
            float f4 = rectF2.top;
            rectF3.set(f2, f3 - f4, this.boQ + f2, (f3 - f4) + this.boR);
            RectF rectF4 = this.bpb;
            RectF rectF5 = this.boZ;
            rectF4.set(rectF5.left, 0.0f, (this.bpa.right - this.boL.right) - rectF5.width(), 0.0f);
            this.boK = Math.min(Math.min(this.bpa.width(), this.bpa.height()) / 2.0f, this.boK);
            Drawable drawable = this.boG;
            if (drawable != null) {
                RectF rectF6 = this.bpa;
                drawable.setBounds((int) rectF6.left, (int) rectF6.top, j(rectF6.right), j(this.bpa.bottom));
            }
            if (this.bps != null) {
                RectF rectF7 = this.bpa;
                float width = ((((((rectF7.width() + this.bpw) - this.cb) - this.boL.right) - this.bps.getWidth()) / 2.0f) + rectF7.left) - this.bpy;
                RectF rectF8 = this.bpa;
                float height = ((rectF8.height() - this.bps.getHeight()) / 2.0f) + rectF8.top;
                this.bpc.set(width, height, this.bps.getWidth() + width, this.bps.getHeight() + height);
            }
            if (this.bpt != null) {
                RectF rectF9 = this.bpa;
                float width2 = ((rectF9.right - (((((rectF9.width() + this.bpw) - this.cb) - this.boL.left) - this.bpt.getWidth()) / 2.0f)) - this.bpt.getWidth()) + this.bpy;
                RectF rectF10 = this.bpa;
                float height2 = ((rectF10.height() - this.bpt.getHeight()) / 2.0f) + rectF10.top;
                this.bpd.set(width2, height2, this.bpt.getWidth() + width2, this.bpt.getHeight() + height2);
            }
            this.bpA = true;
        }
    }

    protected void b(boolean z) {
        ObjectAnimator objectAnimator = this.bph;
        if (objectAnimator != null) {
            if (objectAnimator.isRunning()) {
                this.bph.cancel();
            }
            this.bph.setDuration(this.boN);
            if (z) {
                this.bph.setFloatValues(this.xb, 1.0f);
            } else {
                this.bph.setFloatValues(this.xb, 0.0f);
            }
            this.bph.start();
        }
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    protected void drawableStateChanged() {
        ColorStateList colorStateList;
        ColorStateList colorStateList2;
        super.drawableStateChanged();
        if (!this.tb && (colorStateList2 = this.boI) != null) {
            this.boS = colorStateList2.getColorForState(getDrawableState(), this.boS);
        } else {
            setDrawableState(this.boF);
        }
        int[] iArr = isChecked() ? boE : boD;
        ColorStateList textColors = getTextColors();
        if (textColors != null) {
            int defaultColor = textColors.getDefaultColor();
            this.boV = textColors.getColorForState(boD, defaultColor);
            this.boW = textColors.getColorForState(boE, defaultColor);
        }
        if (!this.bpf && (colorStateList = this.boH) != null) {
            this.boT = colorStateList.getColorForState(getDrawableState(), this.boT);
            this.boU = this.boH.getColorForState(iArr, this.boT);
            return;
        }
        Drawable drawable = this.boG;
        if ((drawable instanceof StateListDrawable) && this.ab) {
            drawable.setState(iArr);
            this.boY = this.boG.getCurrent().mutate();
        } else {
            this.boY = null;
        }
        setDrawableState(this.boG);
        Drawable drawable2 = this.boG;
        if (drawable2 != null) {
            this.boX = drawable2.getCurrent().mutate();
        }
    }

    public void g() {
        if (this.bpC == null) {
            toggle();
            return;
        }
        super.setOnCheckedChangeListener(null);
        toggle();
        super.setOnCheckedChangeListener(this.bpC);
    }

    public long getAnimationDuration() {
        return this.boN;
    }

    public ColorStateList getBackColor() {
        return this.boH;
    }

    public Drawable getBackDrawable() {
        return this.boG;
    }

    public float getBackRadius() {
        return this.boK;
    }

    public PointF getBackSizeF() {
        return new PointF(this.bpa.width(), this.bpa.height());
    }

    public CharSequence getTextOff() {
        return this.bpq;
    }

    public CharSequence getTextOn() {
        return this.bpp;
    }

    public ColorStateList getThumbColor() {
        return this.boI;
    }

    public Drawable getThumbDrawable() {
        return this.boF;
    }

    public float getThumbHeight() {
        return this.boP;
    }

    public RectF getThumbMargin() {
        return this.boL;
    }

    public float getThumbRadius() {
        return this.boJ;
    }

    public float getThumbRangeRatio() {
        return this.boM;
    }

    public float getThumbWidth() {
        return this.cb;
    }

    public int getTintColor() {
        return this.boO;
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    protected void onDraw(Canvas canvas) {
        float progress;
        super.onDraw(canvas);
        if (!this.bpA) {
            setup();
        }
        if (this.bpA) {
            if (this.bpf) {
                if (this.ab && this.boX != null && this.boY != null) {
                    Drawable drawable = isChecked() ? this.boX : this.boY;
                    Drawable drawable2 = isChecked() ? this.boY : this.boX;
                    int progress2 = (int) (getProgress() * 255.0f);
                    drawable.setAlpha(progress2);
                    drawable.draw(canvas);
                    drawable2.setAlpha(255 - progress2);
                    drawable2.draw(canvas);
                } else {
                    this.boG.setAlpha(255);
                    this.boG.draw(canvas);
                }
            } else if (this.ab) {
                int i = isChecked() ? this.boT : this.boU;
                int i2 = isChecked() ? this.boU : this.boT;
                int progress3 = (int) (getProgress() * 255.0f);
                this.bpe.setARGB((Color.alpha(i) * progress3) / 255, Color.red(i), Color.green(i), Color.blue(i));
                RectF rectF = this.bpa;
                float f = this.boK;
                canvas.drawRoundRect(rectF, f, f, this.bpe);
                this.bpe.setARGB(((255 - progress3) * Color.alpha(i2)) / 255, Color.red(i2), Color.green(i2), Color.blue(i2));
                RectF rectF2 = this.bpa;
                float f2 = this.boK;
                canvas.drawRoundRect(rectF2, f2, f2, this.bpe);
                this.bpe.setAlpha(255);
            } else {
                this.bpe.setColor(this.boT);
                RectF rectF3 = this.bpa;
                float f3 = this.boK;
                canvas.drawRoundRect(rectF3, f3, f3, this.bpe);
            }
            Layout layout = ((double) getProgress()) > 0.5d ? this.bps : this.bpt;
            RectF rectF4 = ((double) getProgress()) > 0.5d ? this.bpc : this.bpd;
            if (layout != null && rectF4 != null) {
                if (getProgress() >= 0.75d) {
                    progress = (getProgress() * 4.0f) - 3.0f;
                } else {
                    progress = ((double) getProgress()) < 0.25d ? 1.0f - (getProgress() * 4.0f) : 0.0f;
                }
                int i3 = (int) (progress * 255.0f);
                int i4 = ((double) getProgress()) > 0.5d ? this.boV : this.boW;
                layout.getPaint().setARGB((i3 * Color.alpha(i4)) / 255, Color.red(i4), Color.green(i4), Color.blue(i4));
                canvas.save();
                canvas.translate(rectF4.left, rectF4.top);
                layout.draw(canvas);
                canvas.restore();
            }
            this.bpi.set(this.boZ);
            this.bpi.offset(this.xb * this.bpb.width(), 0.0f);
            if (this.tb) {
                Drawable drawable3 = this.boF;
                RectF rectF5 = this.bpi;
                drawable3.setBounds((int) rectF5.left, (int) rectF5.top, j(rectF5.right), j(this.bpi.bottom));
                this.boF.draw(canvas);
            } else {
                this.bpe.setColor(this.boS);
                RectF rectF6 = this.bpi;
                float f4 = this.boJ;
                canvas.drawRoundRect(rectF6, f4, f4, this.bpe);
            }
            if (this.bpg) {
                this.bpo.setColor(Color.parseColor("#AA0000"));
                canvas.drawRect(this.bpa, this.bpo);
                this.bpo.setColor(Color.parseColor("#0000FF"));
                canvas.drawRect(this.bpi, this.bpo);
                this.bpo.setColor(Color.parseColor("#000000"));
                RectF rectF7 = this.bpb;
                float f5 = rectF7.left;
                float f6 = this.boZ.top;
                canvas.drawLine(f5, f6, rectF7.right, f6, this.bpo);
                this.bpo.setColor(Color.parseColor("#00CC00"));
                canvas.drawRect(((double) getProgress()) > 0.5d ? this.bpc : this.bpd, this.bpo);
            }
        }
    }

    @Override // android.widget.TextView, android.view.View
    protected void onMeasure(int i, int i2) {
        if (this.bps == null && !TextUtils.isEmpty(this.bpp)) {
            this.bps = d(this.bpp);
        }
        if (this.bpt == null && !TextUtils.isEmpty(this.bpq)) {
            this.bpt = d(this.bpq);
        }
        Layout layout = this.bps;
        float width = layout != null ? layout.getWidth() : 0.0f;
        Layout layout2 = this.bpt;
        float width2 = layout2 != null ? layout2.getWidth() : 0.0f;
        if (width == 0.0f && width2 == 0.0f) {
            this.bpu = 0.0f;
        } else {
            this.bpu = Math.max(width, width2);
        }
        Layout layout3 = this.bps;
        float height = layout3 != null ? layout3.getHeight() : 0.0f;
        Layout layout4 = this.bpt;
        float height2 = layout4 != null ? layout4.getHeight() : 0.0f;
        if (height == 0.0f && height2 == 0.0f) {
            this.bpv = 0.0f;
        } else {
            this.bpv = Math.max(height, height2);
        }
        setMeasuredDimension(dE(i), i(i2));
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        a aVar = (a) parcelable;
        a(aVar.bpD, aVar.bpE);
        this.bpz = true;
        super.onRestoreInstanceState(aVar.getSuperState());
        this.bpz = false;
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    public Parcelable onSaveInstanceState() {
        a aVar = new a(super.onSaveInstanceState());
        aVar.bpD = this.bpp;
        aVar.bpE = this.bpq;
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
        if (isEnabled() && isClickable() && isFocusable() && this.bpA) {
            int action = motionEvent.getAction();
            float x = motionEvent.getX() - this.bpj;
            float y = motionEvent.getY() - this.bpk;
            switch (action) {
                case 0:
                    this.bpj = motionEvent.getX();
                    this.bpk = motionEvent.getY();
                    this.bpl = this.bpj;
                    setPressed(true);
                    break;
                case 1:
                case 3:
                    this.bpB = false;
                    setPressed(false);
                    float eventTime = (float) (motionEvent.getEventTime() - motionEvent.getDownTime());
                    if (Math.abs(x) < this.bpm && Math.abs(y) < this.bpm && eventTime < this.bpn) {
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
                    setProgress(getProgress() + ((x2 - this.bpl) / this.bpb.width()));
                    if (!this.bpB && (Math.abs(x) > this.bpm / 2 || Math.abs(y) > this.bpm / 2)) {
                        if (y != 0.0f && Math.abs(x) <= Math.abs(y)) {
                            if (Math.abs(y) > Math.abs(x)) {
                                return false;
                            }
                        } else {
                            R();
                        }
                    }
                    this.bpl = x2;
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
        this.boN = j;
    }

    public void setBackColor(ColorStateList colorStateList) {
        this.boH = colorStateList;
        if (this.boH != null) {
            setBackDrawable(null);
        }
        invalidate();
    }

    public void setBackColorRes(int i) {
        setBackColor(getResources().getColorStateList(i));
    }

    public void setBackDrawable(Drawable drawable) {
        this.boG = drawable;
        this.bpf = this.boG != null;
        refreshDrawableState();
        this.bpA = false;
        requestLayout();
        invalidate();
    }

    public void setBackDrawableRes(int i) {
        setBackDrawable(getResources().getDrawable(i));
    }

    public void setBackRadius(float f) {
        this.boK = f;
        if (this.bpf) {
            return;
        }
        invalidate();
    }

    @Override // android.widget.CompoundButton, android.widget.Checkable
    public void setChecked(boolean z) {
        if (isChecked() != z) {
            b(z);
        }
        if (this.bpz) {
            setCheckedImmediatelyNoEvent(z);
        } else {
            super.setChecked(z);
        }
    }

    public void setCheckedImmediately(boolean z) {
        super.setChecked(z);
        ObjectAnimator objectAnimator = this.bph;
        if (objectAnimator != null && objectAnimator.isRunning()) {
            this.bph.cancel();
        }
        setProgress(z ? 1.0f : 0.0f);
        invalidate();
    }

    public void setCheckedImmediatelyNoEvent(boolean z) {
        if (this.bpC == null) {
            setCheckedImmediately(z);
            return;
        }
        super.setOnCheckedChangeListener(null);
        setCheckedImmediately(z);
        super.setOnCheckedChangeListener(this.bpC);
    }

    public void setCheckedNoEvent(boolean z) {
        if (this.bpC == null) {
            setChecked(z);
            return;
        }
        super.setOnCheckedChangeListener(null);
        setChecked(z);
        super.setOnCheckedChangeListener(this.bpC);
    }

    public void setDrawDebugRect(boolean z) {
        this.bpg = z;
        invalidate();
    }

    public void setFadeBack(boolean z) {
        this.ab = z;
    }

    @Override // android.widget.CompoundButton
    public void setOnCheckedChangeListener(CompoundButton.OnCheckedChangeListener onCheckedChangeListener) {
        super.setOnCheckedChangeListener(onCheckedChangeListener);
        this.bpC = onCheckedChangeListener;
    }

    public void setTextAdjust(int i) {
        this.bpy = i;
        this.bpA = false;
        requestLayout();
        invalidate();
    }

    public void setTextExtra(int i) {
        this.bpx = i;
        this.bpA = false;
        requestLayout();
        invalidate();
    }

    public void setTextThumbInset(int i) {
        this.bpw = i;
        this.bpA = false;
        requestLayout();
        invalidate();
    }

    public void setThumbColor(ColorStateList colorStateList) {
        this.boI = colorStateList;
        if (this.boI != null) {
            setThumbDrawable(null);
        }
        invalidate();
    }

    public void setThumbColorRes(int i) {
        setThumbColor(getResources().getColorStateList(i));
    }

    public void setThumbDrawable(Drawable drawable) {
        this.boF = drawable;
        this.tb = this.boF != null;
        refreshDrawableState();
        this.bpA = false;
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
        this.boJ = f;
        if (this.tb) {
            return;
        }
        invalidate();
    }

    public void setThumbRangeRatio(float f) {
        this.boM = f;
        this.bpA = false;
        requestLayout();
    }

    public void setTintColor(int i) {
        this.boO = i;
        this.boI = com.baidu.poly.widget.b.dG(this.boO);
        this.boH = com.baidu.poly.widget.b.dH(this.boO);
        this.bpf = false;
        this.tb = false;
        refreshDrawableState();
        invalidate();
    }

    public SwitchButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.bpg = false;
        this.bpz = false;
        this.bpA = false;
        this.bpB = false;
        c(attributeSet);
    }

    public SwitchButton(Context context) {
        super(context);
        this.bpg = false;
        this.bpz = false;
        this.bpA = false;
        this.bpB = false;
        c(null);
    }

    private Layout d(CharSequence charSequence) {
        TextPaint textPaint = this.bpr;
        return new StaticLayout(charSequence, textPaint, (int) Math.ceil(Layout.getDesiredWidth(charSequence, textPaint)), Layout.Alignment.ALIGN_CENTER, 1.0f, 0.0f, false);
    }

    public void a(float f, float f2, float f3, float f4) {
        this.boL.set(f, f2, f3, f4);
        this.bpA = false;
        requestLayout();
    }

    public void a(CharSequence charSequence, CharSequence charSequence2) {
        this.bpp = charSequence;
        this.bpq = charSequence2;
        this.bps = null;
        this.bpt = null;
        this.bpA = false;
        requestLayout();
        invalidate();
    }
}
