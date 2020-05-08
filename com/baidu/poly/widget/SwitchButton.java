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
    private static int[] boI = {16842912, 16842910, 16842919};
    private static int[] boJ = {-16842912, 16842910, 16842919};
    private boolean ab;
    private Drawable boK;
    private Drawable boL;
    private ColorStateList boM;
    private ColorStateList boN;
    private float boO;
    private float boP;
    private RectF boQ;
    private float boR;
    private long boS;
    private int boT;
    private int boU;
    private int boV;
    private int boW;
    private int boX;
    private int boY;
    private int boZ;
    private float bpA;
    private int bpB;
    private int bpC;
    private int bpD;
    private boolean bpE;
    private boolean bpF;
    private boolean bpG;
    private CompoundButton.OnCheckedChangeListener bpH;
    private int bpa;
    private int bpb;
    private Drawable bpc;
    private Drawable bpd;
    private RectF bpe;
    private RectF bpf;
    private RectF bpg;
    private RectF bph;
    private RectF bpi;
    private Paint bpj;
    private boolean bpk;
    private boolean bpl;
    private ObjectAnimator bpm;
    private RectF bpn;
    private float bpo;
    private float bpp;
    private float bpq;
    private int bpr;
    private int bps;
    private Paint bpt;
    private CharSequence bpu;
    private CharSequence bpv;
    private TextPaint bpw;
    private Layout bpx;
    private Layout bpy;
    private float bpz;
    private int cb;
    private boolean tb;
    private float xb;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes11.dex */
    public static class a extends View.BaseSavedState {
        public static final Parcelable.Creator<a> CREATOR = new C0211a();
        CharSequence bpI;
        CharSequence bpJ;

        /* renamed from: com.baidu.poly.widget.SwitchButton$a$a  reason: collision with other inner class name */
        /* loaded from: classes11.dex */
        static class C0211a implements Parcelable.Creator<a> {
            C0211a() {
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
            TextUtils.writeToParcel(this.bpI, parcel, i);
            TextUtils.writeToParcel(this.bpJ, parcel, i);
        }

        a(Parcelable parcelable) {
            super(parcelable);
        }

        private a(Parcel parcel) {
            super(parcel);
            this.bpI = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
            this.bpJ = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
        }
    }

    public SwitchButton(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.bpl = false;
        this.bpE = false;
        this.bpF = false;
        this.bpG = false;
        c(attributeSet);
    }

    private void R() {
        ViewParent parent = getParent();
        if (parent != null) {
            parent.requestDisallowInterceptTouchEvent(true);
        }
        this.bpG = true;
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
        this.bpr = ViewConfiguration.get(getContext()).getScaledTouchSlop();
        this.bps = ViewConfiguration.getPressedStateDuration() + ViewConfiguration.getTapTimeout();
        this.bpj = new Paint(1);
        this.bpt = new Paint(1);
        this.bpt.setStyle(Paint.Style.STROKE);
        this.bpt.setStrokeWidth(getResources().getDisplayMetrics().density);
        this.bpw = getPaint();
        this.bpe = new RectF();
        this.bpf = new RectF();
        this.bpg = new RectF();
        this.boQ = new RectF();
        this.bph = new RectF();
        this.bpi = new RectF();
        this.bpm = ObjectAnimator.ofFloat(this, "progress", 0.0f, 0.0f).setDuration(250L);
        this.bpm.setInterpolator(new AccelerateDecelerateInterpolator());
        this.bpn = new RectF();
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
        this.bpu = str2;
        this.bpv = str;
        this.bpB = i4;
        this.bpC = i3;
        this.bpD = i5;
        this.boK = drawable;
        this.boN = colorStateList;
        this.tb = this.boK != null;
        this.boT = i2;
        if (this.boT == 0) {
            new TypedValue();
            this.boT = 3309506;
        }
        if (!this.tb && this.boN == null) {
            this.boN = com.baidu.poly.widget.b.dG(this.boT);
            this.boX = this.boN.getDefaultColor();
        }
        this.cb = j(f5);
        this.boU = j(f6);
        this.boL = drawable2;
        this.boM = colorStateList2;
        this.bpk = this.boL != null;
        if (!this.bpk && this.boM == null) {
            this.boM = com.baidu.poly.widget.b.dH(this.boT);
            this.boY = this.boM.getDefaultColor();
            this.boZ = this.boM.getColorForState(boI, this.boY);
        }
        this.boQ.set(f, f3, f2, f4);
        this.boR = this.boQ.width() >= 0.0f ? Math.max(f9, 1.0f) : f9;
        this.boO = f7;
        this.boP = f8;
        this.boS = i;
        this.ab = z;
        this.bpm.setDuration(this.boS);
        if (isChecked()) {
            setProgress(1.0f);
        }
    }

    private int dE(int i) {
        int i2;
        int size = View.MeasureSpec.getSize(i);
        int mode = View.MeasureSpec.getMode(i);
        if (this.cb == 0 && this.tb) {
            this.cb = this.boK.getIntrinsicWidth();
        }
        int j = j(this.bpz);
        if (this.boR == 0.0f) {
            this.boR = 1.8f;
        }
        if (mode == 1073741824) {
            int paddingLeft = (size - getPaddingLeft()) - getPaddingRight();
            if (this.cb != 0) {
                int j2 = j(i2 * this.boR);
                RectF rectF = this.boQ;
                int j3 = (this.bpC + j) - ((j2 - this.cb) + j(Math.max(rectF.left, rectF.right)));
                float f = j2;
                RectF rectF2 = this.boQ;
                this.boV = j(rectF2.right + rectF2.left + f + Math.max(j3, 0));
                if (this.boV < 0) {
                    this.cb = 0;
                }
                if (f + Math.max(this.boQ.left, 0.0f) + Math.max(this.boQ.right, 0.0f) + Math.max(j3, 0) > paddingLeft) {
                    this.cb = 0;
                }
            }
            if (this.cb == 0) {
                int j4 = j((((size - getPaddingLeft()) - getPaddingRight()) - Math.max(this.boQ.left, 0.0f)) - Math.max(this.boQ.right, 0.0f));
                if (j4 < 0) {
                    this.cb = 0;
                    this.boV = 0;
                    return size;
                }
                float f2 = j4;
                this.cb = j(f2 / this.boR);
                RectF rectF3 = this.boQ;
                this.boV = j(f2 + rectF3.left + rectF3.right);
                if (this.boV < 0) {
                    this.cb = 0;
                    this.boV = 0;
                    return size;
                }
                int i3 = j + this.bpC;
                int i4 = j4 - this.cb;
                RectF rectF4 = this.boQ;
                int j5 = i3 - (i4 + j(Math.max(rectF4.left, rectF4.right)));
                if (j5 > 0) {
                    this.cb -= j5;
                }
                if (this.cb < 0) {
                    this.cb = 0;
                    this.boV = 0;
                    return size;
                }
                return size;
            }
            return size;
        }
        if (this.cb == 0) {
            this.cb = j(getResources().getDisplayMetrics().density * 20.0f);
        }
        if (this.boR == 0.0f) {
            this.boR = 1.8f;
        }
        int j6 = j(this.cb * this.boR);
        RectF rectF5 = this.boQ;
        int j7 = j((j + this.bpC) - (((j6 - this.cb) + Math.max(rectF5.left, rectF5.right)) + this.bpB));
        float f3 = j6;
        RectF rectF6 = this.boQ;
        this.boV = j(rectF6.right + rectF6.left + f3 + Math.max(0, j7));
        if (this.boV < 0) {
            this.cb = 0;
            this.boV = 0;
            return size;
        }
        int j8 = j(Math.max(0.0f, this.boQ.left) + f3 + Math.max(0.0f, this.boQ.right) + Math.max(0, j7));
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
        if (this.boU == 0 && this.tb) {
            this.boU = this.boK.getIntrinsicHeight();
        }
        if (mode == 1073741824) {
            if (this.boU != 0) {
                RectF rectF = this.boQ;
                this.boW = j(i3 + rectF.top + rectF.bottom);
                this.boW = j(Math.max(this.boW, this.bpA));
                if ((((this.boW + getPaddingTop()) + getPaddingBottom()) - Math.min(0.0f, this.boQ.top)) - Math.min(0.0f, this.boQ.bottom) > size) {
                    this.boU = 0;
                }
            }
            if (this.boU == 0) {
                this.boW = j(((size - getPaddingTop()) - getPaddingBottom()) + Math.min(0.0f, this.boQ.top) + Math.min(0.0f, this.boQ.bottom));
                if (this.boW < 0) {
                    this.boW = 0;
                    this.boU = 0;
                    return size;
                }
                RectF rectF2 = this.boQ;
                this.boU = j((i4 - rectF2.top) - rectF2.bottom);
            }
            if (this.boU < 0) {
                this.boW = 0;
                this.boU = 0;
                return size;
            }
            return size;
        }
        if (this.boU == 0) {
            this.boU = j(getResources().getDisplayMetrics().density * 20.0f);
        }
        RectF rectF3 = this.boQ;
        this.boW = j(this.boU + rectF3.top + rectF3.bottom);
        if (this.boW < 0) {
            this.boW = 0;
            this.boU = 0;
            return size;
        }
        int j = j(this.bpA - i2);
        if (j > 0) {
            this.boW += j;
            this.boU = j + this.boU;
        }
        int max = Math.max(this.boU, this.boW);
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
        if (i2 != 0 && (i = this.boU) != 0 && this.boV != 0 && this.boW != 0) {
            if (this.boO == -1.0f) {
                this.boO = Math.min(i2, i) / 2;
            }
            if (this.boP == -1.0f) {
                this.boP = Math.min(this.boV, this.boW) / 2;
            }
            int measuredWidth = (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight();
            int measuredHeight = (getMeasuredHeight() - getPaddingTop()) - getPaddingBottom();
            int j = j((this.boV - Math.min(0.0f, this.boQ.left)) - Math.min(0.0f, this.boQ.right));
            int j2 = j((this.boW - Math.min(0.0f, this.boQ.top)) - Math.min(0.0f, this.boQ.bottom));
            if (measuredHeight <= j2) {
                paddingTop = getPaddingTop() + Math.max(0.0f, this.boQ.top);
            } else {
                paddingTop = (((measuredHeight - j2) + 1) / 2) + getPaddingTop() + Math.max(0.0f, this.boQ.top);
            }
            if (measuredWidth <= this.boV) {
                paddingLeft = getPaddingLeft() + Math.max(0.0f, this.boQ.left);
            } else {
                paddingLeft = (((measuredWidth - j) + 1) / 2) + getPaddingLeft() + Math.max(0.0f, this.boQ.left);
            }
            this.bpe.set(paddingLeft, paddingTop, this.cb + paddingLeft, this.boU + paddingTop);
            RectF rectF = this.bpe;
            float f = rectF.left;
            RectF rectF2 = this.boQ;
            float f2 = f - rectF2.left;
            RectF rectF3 = this.bpf;
            float f3 = rectF.top;
            float f4 = rectF2.top;
            rectF3.set(f2, f3 - f4, this.boV + f2, (f3 - f4) + this.boW);
            RectF rectF4 = this.bpg;
            RectF rectF5 = this.bpe;
            rectF4.set(rectF5.left, 0.0f, (this.bpf.right - this.boQ.right) - rectF5.width(), 0.0f);
            this.boP = Math.min(Math.min(this.bpf.width(), this.bpf.height()) / 2.0f, this.boP);
            Drawable drawable = this.boL;
            if (drawable != null) {
                RectF rectF6 = this.bpf;
                drawable.setBounds((int) rectF6.left, (int) rectF6.top, j(rectF6.right), j(this.bpf.bottom));
            }
            if (this.bpx != null) {
                RectF rectF7 = this.bpf;
                float width = ((((((rectF7.width() + this.bpB) - this.cb) - this.boQ.right) - this.bpx.getWidth()) / 2.0f) + rectF7.left) - this.bpD;
                RectF rectF8 = this.bpf;
                float height = ((rectF8.height() - this.bpx.getHeight()) / 2.0f) + rectF8.top;
                this.bph.set(width, height, this.bpx.getWidth() + width, this.bpx.getHeight() + height);
            }
            if (this.bpy != null) {
                RectF rectF9 = this.bpf;
                float width2 = ((rectF9.right - (((((rectF9.width() + this.bpB) - this.cb) - this.boQ.left) - this.bpy.getWidth()) / 2.0f)) - this.bpy.getWidth()) + this.bpD;
                RectF rectF10 = this.bpf;
                float height2 = ((rectF10.height() - this.bpy.getHeight()) / 2.0f) + rectF10.top;
                this.bpi.set(width2, height2, this.bpy.getWidth() + width2, this.bpy.getHeight() + height2);
            }
            this.bpF = true;
        }
    }

    protected void b(boolean z) {
        ObjectAnimator objectAnimator = this.bpm;
        if (objectAnimator != null) {
            if (objectAnimator.isRunning()) {
                this.bpm.cancel();
            }
            this.bpm.setDuration(this.boS);
            if (z) {
                this.bpm.setFloatValues(this.xb, 1.0f);
            } else {
                this.bpm.setFloatValues(this.xb, 0.0f);
            }
            this.bpm.start();
        }
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    protected void drawableStateChanged() {
        ColorStateList colorStateList;
        ColorStateList colorStateList2;
        super.drawableStateChanged();
        if (!this.tb && (colorStateList2 = this.boN) != null) {
            this.boX = colorStateList2.getColorForState(getDrawableState(), this.boX);
        } else {
            setDrawableState(this.boK);
        }
        int[] iArr = isChecked() ? boJ : boI;
        ColorStateList textColors = getTextColors();
        if (textColors != null) {
            int defaultColor = textColors.getDefaultColor();
            this.bpa = textColors.getColorForState(boI, defaultColor);
            this.bpb = textColors.getColorForState(boJ, defaultColor);
        }
        if (!this.bpk && (colorStateList = this.boM) != null) {
            this.boY = colorStateList.getColorForState(getDrawableState(), this.boY);
            this.boZ = this.boM.getColorForState(iArr, this.boY);
            return;
        }
        Drawable drawable = this.boL;
        if ((drawable instanceof StateListDrawable) && this.ab) {
            drawable.setState(iArr);
            this.bpd = this.boL.getCurrent().mutate();
        } else {
            this.bpd = null;
        }
        setDrawableState(this.boL);
        Drawable drawable2 = this.boL;
        if (drawable2 != null) {
            this.bpc = drawable2.getCurrent().mutate();
        }
    }

    public void g() {
        if (this.bpH == null) {
            toggle();
            return;
        }
        super.setOnCheckedChangeListener(null);
        toggle();
        super.setOnCheckedChangeListener(this.bpH);
    }

    public long getAnimationDuration() {
        return this.boS;
    }

    public ColorStateList getBackColor() {
        return this.boM;
    }

    public Drawable getBackDrawable() {
        return this.boL;
    }

    public float getBackRadius() {
        return this.boP;
    }

    public PointF getBackSizeF() {
        return new PointF(this.bpf.width(), this.bpf.height());
    }

    public CharSequence getTextOff() {
        return this.bpv;
    }

    public CharSequence getTextOn() {
        return this.bpu;
    }

    public ColorStateList getThumbColor() {
        return this.boN;
    }

    public Drawable getThumbDrawable() {
        return this.boK;
    }

    public float getThumbHeight() {
        return this.boU;
    }

    public RectF getThumbMargin() {
        return this.boQ;
    }

    public float getThumbRadius() {
        return this.boO;
    }

    public float getThumbRangeRatio() {
        return this.boR;
    }

    public float getThumbWidth() {
        return this.cb;
    }

    public int getTintColor() {
        return this.boT;
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    protected void onDraw(Canvas canvas) {
        float progress;
        super.onDraw(canvas);
        if (!this.bpF) {
            setup();
        }
        if (this.bpF) {
            if (this.bpk) {
                if (this.ab && this.bpc != null && this.bpd != null) {
                    Drawable drawable = isChecked() ? this.bpc : this.bpd;
                    Drawable drawable2 = isChecked() ? this.bpd : this.bpc;
                    int progress2 = (int) (getProgress() * 255.0f);
                    drawable.setAlpha(progress2);
                    drawable.draw(canvas);
                    drawable2.setAlpha(255 - progress2);
                    drawable2.draw(canvas);
                } else {
                    this.boL.setAlpha(255);
                    this.boL.draw(canvas);
                }
            } else if (this.ab) {
                int i = isChecked() ? this.boY : this.boZ;
                int i2 = isChecked() ? this.boZ : this.boY;
                int progress3 = (int) (getProgress() * 255.0f);
                this.bpj.setARGB((Color.alpha(i) * progress3) / 255, Color.red(i), Color.green(i), Color.blue(i));
                RectF rectF = this.bpf;
                float f = this.boP;
                canvas.drawRoundRect(rectF, f, f, this.bpj);
                this.bpj.setARGB(((255 - progress3) * Color.alpha(i2)) / 255, Color.red(i2), Color.green(i2), Color.blue(i2));
                RectF rectF2 = this.bpf;
                float f2 = this.boP;
                canvas.drawRoundRect(rectF2, f2, f2, this.bpj);
                this.bpj.setAlpha(255);
            } else {
                this.bpj.setColor(this.boY);
                RectF rectF3 = this.bpf;
                float f3 = this.boP;
                canvas.drawRoundRect(rectF3, f3, f3, this.bpj);
            }
            Layout layout = ((double) getProgress()) > 0.5d ? this.bpx : this.bpy;
            RectF rectF4 = ((double) getProgress()) > 0.5d ? this.bph : this.bpi;
            if (layout != null && rectF4 != null) {
                if (getProgress() >= 0.75d) {
                    progress = (getProgress() * 4.0f) - 3.0f;
                } else {
                    progress = ((double) getProgress()) < 0.25d ? 1.0f - (getProgress() * 4.0f) : 0.0f;
                }
                int i3 = (int) (progress * 255.0f);
                int i4 = ((double) getProgress()) > 0.5d ? this.bpa : this.bpb;
                layout.getPaint().setARGB((i3 * Color.alpha(i4)) / 255, Color.red(i4), Color.green(i4), Color.blue(i4));
                canvas.save();
                canvas.translate(rectF4.left, rectF4.top);
                layout.draw(canvas);
                canvas.restore();
            }
            this.bpn.set(this.bpe);
            this.bpn.offset(this.xb * this.bpg.width(), 0.0f);
            if (this.tb) {
                Drawable drawable3 = this.boK;
                RectF rectF5 = this.bpn;
                drawable3.setBounds((int) rectF5.left, (int) rectF5.top, j(rectF5.right), j(this.bpn.bottom));
                this.boK.draw(canvas);
            } else {
                this.bpj.setColor(this.boX);
                RectF rectF6 = this.bpn;
                float f4 = this.boO;
                canvas.drawRoundRect(rectF6, f4, f4, this.bpj);
            }
            if (this.bpl) {
                this.bpt.setColor(Color.parseColor("#AA0000"));
                canvas.drawRect(this.bpf, this.bpt);
                this.bpt.setColor(Color.parseColor("#0000FF"));
                canvas.drawRect(this.bpn, this.bpt);
                this.bpt.setColor(Color.parseColor("#000000"));
                RectF rectF7 = this.bpg;
                float f5 = rectF7.left;
                float f6 = this.bpe.top;
                canvas.drawLine(f5, f6, rectF7.right, f6, this.bpt);
                this.bpt.setColor(Color.parseColor("#00CC00"));
                canvas.drawRect(((double) getProgress()) > 0.5d ? this.bph : this.bpi, this.bpt);
            }
        }
    }

    @Override // android.widget.TextView, android.view.View
    protected void onMeasure(int i, int i2) {
        if (this.bpx == null && !TextUtils.isEmpty(this.bpu)) {
            this.bpx = d(this.bpu);
        }
        if (this.bpy == null && !TextUtils.isEmpty(this.bpv)) {
            this.bpy = d(this.bpv);
        }
        Layout layout = this.bpx;
        float width = layout != null ? layout.getWidth() : 0.0f;
        Layout layout2 = this.bpy;
        float width2 = layout2 != null ? layout2.getWidth() : 0.0f;
        if (width == 0.0f && width2 == 0.0f) {
            this.bpz = 0.0f;
        } else {
            this.bpz = Math.max(width, width2);
        }
        Layout layout3 = this.bpx;
        float height = layout3 != null ? layout3.getHeight() : 0.0f;
        Layout layout4 = this.bpy;
        float height2 = layout4 != null ? layout4.getHeight() : 0.0f;
        if (height == 0.0f && height2 == 0.0f) {
            this.bpA = 0.0f;
        } else {
            this.bpA = Math.max(height, height2);
        }
        setMeasuredDimension(dE(i), i(i2));
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        a aVar = (a) parcelable;
        a(aVar.bpI, aVar.bpJ);
        this.bpE = true;
        super.onRestoreInstanceState(aVar.getSuperState());
        this.bpE = false;
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    public Parcelable onSaveInstanceState() {
        a aVar = new a(super.onSaveInstanceState());
        aVar.bpI = this.bpu;
        aVar.bpJ = this.bpv;
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
        if (isEnabled() && isClickable() && isFocusable() && this.bpF) {
            int action = motionEvent.getAction();
            float x = motionEvent.getX() - this.bpo;
            float y = motionEvent.getY() - this.bpp;
            switch (action) {
                case 0:
                    this.bpo = motionEvent.getX();
                    this.bpp = motionEvent.getY();
                    this.bpq = this.bpo;
                    setPressed(true);
                    break;
                case 1:
                case 3:
                    this.bpG = false;
                    setPressed(false);
                    float eventTime = (float) (motionEvent.getEventTime() - motionEvent.getDownTime());
                    if (Math.abs(x) < this.bpr && Math.abs(y) < this.bpr && eventTime < this.bps) {
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
                    setProgress(getProgress() + ((x2 - this.bpq) / this.bpg.width()));
                    if (!this.bpG && (Math.abs(x) > this.bpr / 2 || Math.abs(y) > this.bpr / 2)) {
                        if (y != 0.0f && Math.abs(x) <= Math.abs(y)) {
                            if (Math.abs(y) > Math.abs(x)) {
                                return false;
                            }
                        } else {
                            R();
                        }
                    }
                    this.bpq = x2;
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
        this.boS = j;
    }

    public void setBackColor(ColorStateList colorStateList) {
        this.boM = colorStateList;
        if (this.boM != null) {
            setBackDrawable(null);
        }
        invalidate();
    }

    public void setBackColorRes(int i) {
        setBackColor(getResources().getColorStateList(i));
    }

    public void setBackDrawable(Drawable drawable) {
        this.boL = drawable;
        this.bpk = this.boL != null;
        refreshDrawableState();
        this.bpF = false;
        requestLayout();
        invalidate();
    }

    public void setBackDrawableRes(int i) {
        setBackDrawable(getResources().getDrawable(i));
    }

    public void setBackRadius(float f) {
        this.boP = f;
        if (this.bpk) {
            return;
        }
        invalidate();
    }

    @Override // android.widget.CompoundButton, android.widget.Checkable
    public void setChecked(boolean z) {
        if (isChecked() != z) {
            b(z);
        }
        if (this.bpE) {
            setCheckedImmediatelyNoEvent(z);
        } else {
            super.setChecked(z);
        }
    }

    public void setCheckedImmediately(boolean z) {
        super.setChecked(z);
        ObjectAnimator objectAnimator = this.bpm;
        if (objectAnimator != null && objectAnimator.isRunning()) {
            this.bpm.cancel();
        }
        setProgress(z ? 1.0f : 0.0f);
        invalidate();
    }

    public void setCheckedImmediatelyNoEvent(boolean z) {
        if (this.bpH == null) {
            setCheckedImmediately(z);
            return;
        }
        super.setOnCheckedChangeListener(null);
        setCheckedImmediately(z);
        super.setOnCheckedChangeListener(this.bpH);
    }

    public void setCheckedNoEvent(boolean z) {
        if (this.bpH == null) {
            setChecked(z);
            return;
        }
        super.setOnCheckedChangeListener(null);
        setChecked(z);
        super.setOnCheckedChangeListener(this.bpH);
    }

    public void setDrawDebugRect(boolean z) {
        this.bpl = z;
        invalidate();
    }

    public void setFadeBack(boolean z) {
        this.ab = z;
    }

    @Override // android.widget.CompoundButton
    public void setOnCheckedChangeListener(CompoundButton.OnCheckedChangeListener onCheckedChangeListener) {
        super.setOnCheckedChangeListener(onCheckedChangeListener);
        this.bpH = onCheckedChangeListener;
    }

    public void setTextAdjust(int i) {
        this.bpD = i;
        this.bpF = false;
        requestLayout();
        invalidate();
    }

    public void setTextExtra(int i) {
        this.bpC = i;
        this.bpF = false;
        requestLayout();
        invalidate();
    }

    public void setTextThumbInset(int i) {
        this.bpB = i;
        this.bpF = false;
        requestLayout();
        invalidate();
    }

    public void setThumbColor(ColorStateList colorStateList) {
        this.boN = colorStateList;
        if (this.boN != null) {
            setThumbDrawable(null);
        }
        invalidate();
    }

    public void setThumbColorRes(int i) {
        setThumbColor(getResources().getColorStateList(i));
    }

    public void setThumbDrawable(Drawable drawable) {
        this.boK = drawable;
        this.tb = this.boK != null;
        refreshDrawableState();
        this.bpF = false;
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
        this.boO = f;
        if (this.tb) {
            return;
        }
        invalidate();
    }

    public void setThumbRangeRatio(float f) {
        this.boR = f;
        this.bpF = false;
        requestLayout();
    }

    public void setTintColor(int i) {
        this.boT = i;
        this.boN = com.baidu.poly.widget.b.dG(this.boT);
        this.boM = com.baidu.poly.widget.b.dH(this.boT);
        this.bpk = false;
        this.tb = false;
        refreshDrawableState();
        invalidate();
    }

    public SwitchButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.bpl = false;
        this.bpE = false;
        this.bpF = false;
        this.bpG = false;
        c(attributeSet);
    }

    public SwitchButton(Context context) {
        super(context);
        this.bpl = false;
        this.bpE = false;
        this.bpF = false;
        this.bpG = false;
        c(null);
    }

    private Layout d(CharSequence charSequence) {
        TextPaint textPaint = this.bpw;
        return new StaticLayout(charSequence, textPaint, (int) Math.ceil(Layout.getDesiredWidth(charSequence, textPaint)), Layout.Alignment.ALIGN_CENTER, 1.0f, 0.0f, false);
    }

    public void a(float f, float f2, float f3, float f4) {
        this.boQ.set(f, f2, f3, f4);
        this.bpF = false;
        requestLayout();
    }

    public void a(CharSequence charSequence, CharSequence charSequence2) {
        this.bpu = charSequence;
        this.bpv = charSequence2;
        this.bpx = null;
        this.bpy = null;
        this.bpF = false;
        requestLayout();
        invalidate();
    }
}
