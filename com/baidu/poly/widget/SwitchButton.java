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
/* loaded from: classes14.dex */
public class SwitchButton extends CompoundButton {
    private static int[] cqO = {16842912, 16842910, 16842919};
    private static int[] cqP = {-16842912, 16842910, 16842919};
    private float ab;
    private float aqt;
    private Drawable cqQ;
    private Drawable cqR;
    private ColorStateList cqS;
    private ColorStateList cqT;
    private RectF cqU;
    private float cqV;
    private long cqW;
    private boolean cqX;
    private int cqY;
    private int cqZ;
    private int crA;
    private int crB;
    private Paint crC;
    private CharSequence crD;
    private CharSequence crE;
    private TextPaint crF;
    private Layout crG;
    private Layout crH;
    private float crI;
    private float crJ;
    private int crK;
    private int crL;
    private int crM;
    private boolean crN;
    private boolean crO;
    private boolean crP;
    private CompoundButton.OnCheckedChangeListener crQ;
    private int cra;
    private int crb;
    private int crd;
    private int cre;
    private int crf;
    private int crg;
    private int crh;
    private int cri;
    private Drawable crj;
    private Drawable crk;
    private RectF crl;
    private RectF crm;
    private RectF crn;
    private RectF cro;
    private RectF crp;
    private Paint crq;
    private boolean crr;
    private boolean crs;
    private boolean crt;
    private ObjectAnimator cru;
    private float crv;
    private RectF crw;
    private float crx;
    private float cry;
    private float crz;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes14.dex */
    public static class a extends View.BaseSavedState {
        public static final Parcelable.Creator<a> CREATOR = new C0315a();
        CharSequence crR;
        CharSequence crS;

        /* renamed from: com.baidu.poly.widget.SwitchButton$a$a  reason: collision with other inner class name */
        /* loaded from: classes14.dex */
        static class C0315a implements Parcelable.Creator<a> {
            C0315a() {
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // android.os.Parcelable.Creator
            /* renamed from: fP */
            public a[] newArray(int i) {
                return new a[i];
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // android.os.Parcelable.Creator
            /* renamed from: o */
            public a createFromParcel(Parcel parcel) {
                return new a(parcel);
            }
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            TextUtils.writeToParcel(this.crR, parcel, i);
            TextUtils.writeToParcel(this.crS, parcel, i);
        }

        a(Parcelable parcelable) {
            super(parcelable);
        }

        private a(Parcel parcel) {
            super(parcel);
            this.crR = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
            this.crS = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
        }
    }

    public SwitchButton(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.crt = false;
        this.crN = false;
        this.crO = false;
        this.crP = false;
        a(attributeSet);
    }

    private void a(AttributeSet attributeSet) {
        this.crA = ViewConfiguration.get(getContext()).getScaledTouchSlop();
        this.crB = ViewConfiguration.getPressedStateDuration() + ViewConfiguration.getTapTimeout();
        this.crq = new Paint(1);
        this.crC = new Paint(1);
        this.crC.setStyle(Paint.Style.STROKE);
        this.crC.setStrokeWidth(getResources().getDisplayMetrics().density);
        this.crF = getPaint();
        this.crl = new RectF();
        this.crm = new RectF();
        this.crn = new RectF();
        this.cqU = new RectF();
        this.cro = new RectF();
        this.crp = new RectF();
        this.cru = ObjectAnimator.ofFloat(this, "progress", 0.0f, 0.0f).setDuration(250L);
        this.cru.setInterpolator(new AccelerateDecelerateInterpolator());
        this.crw = new RectF();
        Drawable drawable = null;
        ColorStateList colorStateList = null;
        float f = getResources().getDisplayMetrics().density * 2.0f;
        float f2 = 0.0f;
        float f3 = 0.0f;
        float f4 = 0.0f;
        float f5 = 0.0f;
        float f6 = 0.0f;
        float f7 = 0.0f;
        float f8 = -1.0f;
        float f9 = -1.0f;
        Drawable drawable2 = null;
        ColorStateList colorStateList2 = null;
        float f10 = 1.8f;
        int i = 250;
        boolean z = true;
        int i2 = 0;
        String str = null;
        String str2 = null;
        int i3 = 0;
        int i4 = 0;
        int i5 = 0;
        TypedArray obtainStyledAttributes = attributeSet == null ? null : getContext().obtainStyledAttributes(attributeSet, b.i.SwitchButton);
        if (obtainStyledAttributes != null) {
            drawable = obtainStyledAttributes.getDrawable(b.i.SwitchButton_kswThumbDrawable);
            colorStateList = obtainStyledAttributes.getColorStateList(b.i.SwitchButton_kswThumbColor);
            float dimension = obtainStyledAttributes.getDimension(b.i.SwitchButton_kswThumbMargin, f);
            f2 = obtainStyledAttributes.getDimension(b.i.SwitchButton_kswThumbMarginLeft, dimension);
            f3 = obtainStyledAttributes.getDimension(b.i.SwitchButton_kswThumbMarginRight, dimension);
            f4 = obtainStyledAttributes.getDimension(b.i.SwitchButton_kswThumbMarginTop, dimension);
            f5 = obtainStyledAttributes.getDimension(b.i.SwitchButton_kswThumbMarginBottom, dimension);
            f6 = obtainStyledAttributes.getDimension(b.i.SwitchButton_kswThumbWidth, 0.0f);
            f7 = obtainStyledAttributes.getDimension(b.i.SwitchButton_kswThumbHeight, 0.0f);
            f8 = obtainStyledAttributes.getDimension(b.i.SwitchButton_kswThumbRadius, -1.0f);
            f9 = obtainStyledAttributes.getDimension(b.i.SwitchButton_kswBackRadius, -1.0f);
            drawable2 = obtainStyledAttributes.getDrawable(b.i.SwitchButton_kswBackDrawable);
            colorStateList2 = obtainStyledAttributes.getColorStateList(b.i.SwitchButton_kswBackColor);
            f10 = obtainStyledAttributes.getFloat(b.i.SwitchButton_kswThumbRangeRatio, 1.8f);
            i = obtainStyledAttributes.getInteger(b.i.SwitchButton_kswAnimationDuration, 250);
            z = obtainStyledAttributes.getBoolean(b.i.SwitchButton_kswFadeBack, true);
            i2 = obtainStyledAttributes.getColor(b.i.SwitchButton_kswTintColor, 0);
            str = obtainStyledAttributes.getString(b.i.SwitchButton_kswTextOn);
            str2 = obtainStyledAttributes.getString(b.i.SwitchButton_kswTextOff);
            i3 = obtainStyledAttributes.getDimensionPixelSize(b.i.SwitchButton_kswTextThumbInset, 0);
            i4 = obtainStyledAttributes.getDimensionPixelSize(b.i.SwitchButton_kswTextExtra, 0);
            i5 = obtainStyledAttributes.getDimensionPixelSize(b.i.SwitchButton_kswTextAdjust, 0);
            obtainStyledAttributes.recycle();
        }
        int i6 = i5;
        TypedArray obtainStyledAttributes2 = attributeSet == null ? null : getContext().obtainStyledAttributes(attributeSet, new int[]{16842970, 16842981});
        if (obtainStyledAttributes2 != null) {
            boolean z2 = obtainStyledAttributes2.getBoolean(0, true);
            boolean z3 = obtainStyledAttributes2.getBoolean(1, z2);
            setFocusable(z2);
            setClickable(z3);
            obtainStyledAttributes2.recycle();
        } else {
            setFocusable(true);
            setClickable(true);
        }
        this.crD = str;
        this.crE = str2;
        this.crK = i3;
        this.crL = i4;
        this.crM = i6;
        this.cqQ = drawable;
        this.cqT = colorStateList;
        this.crr = this.cqQ != null;
        this.cqY = i2;
        if (this.cqY == 0) {
            new TypedValue();
            this.cqY = 3309506;
        }
        if (!this.crr && this.cqT == null) {
            this.cqT = com.baidu.poly.widget.b.fM(this.cqY);
            this.cre = this.cqT.getDefaultColor();
        }
        this.cqZ = j(f6);
        this.cra = j(f7);
        this.cqR = drawable2;
        this.cqS = colorStateList2;
        this.crs = this.cqR != null;
        if (!this.crs && this.cqS == null) {
            this.cqS = com.baidu.poly.widget.b.fN(this.cqY);
            this.crf = this.cqS.getDefaultColor();
            this.crg = this.cqS.getColorForState(cqO, this.crf);
        }
        this.cqU.set(f2, f4, f3, f5);
        this.cqV = this.cqU.width() >= 0.0f ? Math.max(f10, 1.0f) : f10;
        this.ab = f8;
        this.aqt = f9;
        this.cqW = i;
        this.cqX = z;
        this.cru.setDuration(this.cqW);
        if (isChecked()) {
            setProgress(1.0f);
        }
    }

    private void adM() {
        ViewParent parent = getParent();
        if (parent != null) {
            parent.requestDisallowInterceptTouchEvent(true);
        }
        this.crP = true;
    }

    private int fJ(int i) {
        int i2;
        int size = View.MeasureSpec.getSize(i);
        int mode = View.MeasureSpec.getMode(i);
        if (this.cqZ == 0 && this.crr) {
            this.cqZ = this.cqQ.getIntrinsicWidth();
        }
        int j = j(this.crI);
        if (this.cqV == 0.0f) {
            this.cqV = 1.8f;
        }
        if (mode == 1073741824) {
            int paddingLeft = (size - getPaddingLeft()) - getPaddingRight();
            if (this.cqZ != 0) {
                int j2 = j(i2 * this.cqV);
                RectF rectF = this.cqU;
                int j3 = (this.crL + j) - ((j2 - this.cqZ) + j(Math.max(rectF.left, rectF.right)));
                float f = j2;
                RectF rectF2 = this.cqU;
                this.crb = j(rectF2.right + rectF2.left + f + Math.max(j3, 0));
                if (this.crb < 0) {
                    this.cqZ = 0;
                }
                if (f + Math.max(this.cqU.left, 0.0f) + Math.max(this.cqU.right, 0.0f) + Math.max(j3, 0) > paddingLeft) {
                    this.cqZ = 0;
                }
            }
            if (this.cqZ == 0) {
                int j4 = j((((size - getPaddingLeft()) - getPaddingRight()) - Math.max(this.cqU.left, 0.0f)) - Math.max(this.cqU.right, 0.0f));
                if (j4 < 0) {
                    this.cqZ = 0;
                    this.crb = 0;
                    return size;
                }
                float f2 = j4;
                this.cqZ = j(f2 / this.cqV);
                RectF rectF3 = this.cqU;
                this.crb = j(f2 + rectF3.left + rectF3.right);
                if (this.crb < 0) {
                    this.cqZ = 0;
                    this.crb = 0;
                    return size;
                }
                int i3 = j + this.crL;
                int i4 = j4 - this.cqZ;
                RectF rectF4 = this.cqU;
                int j5 = i3 - (i4 + j(Math.max(rectF4.left, rectF4.right)));
                if (j5 > 0) {
                    this.cqZ -= j5;
                }
                if (this.cqZ < 0) {
                    this.cqZ = 0;
                    this.crb = 0;
                    return size;
                }
                return size;
            }
            return size;
        }
        if (this.cqZ == 0) {
            this.cqZ = j(getResources().getDisplayMetrics().density * 20.0f);
        }
        if (this.cqV == 0.0f) {
            this.cqV = 1.8f;
        }
        int j6 = j(this.cqZ * this.cqV);
        RectF rectF5 = this.cqU;
        int j7 = j((j + this.crL) - (((j6 - this.cqZ) + Math.max(rectF5.left, rectF5.right)) + this.crK));
        float f3 = j6;
        RectF rectF6 = this.cqU;
        this.crb = j(rectF6.right + rectF6.left + f3 + Math.max(0, j7));
        if (this.crb < 0) {
            this.cqZ = 0;
            this.crb = 0;
            return size;
        }
        int j8 = j(Math.max(0.0f, this.cqU.left) + f3 + Math.max(0.0f, this.cqU.right) + Math.max(0, j7));
        return Math.max(j8, getPaddingLeft() + j8 + getPaddingRight());
    }

    private int fK(int i) {
        int i2;
        int i3;
        int i4;
        int size = View.MeasureSpec.getSize(i);
        int mode = View.MeasureSpec.getMode(i);
        if (this.cra == 0 && this.crr) {
            this.cra = this.cqQ.getIntrinsicHeight();
        }
        if (mode == 1073741824) {
            if (this.cra != 0) {
                RectF rectF = this.cqU;
                this.crd = j(i3 + rectF.top + rectF.bottom);
                this.crd = j(Math.max(this.crd, this.crJ));
                if ((((this.crd + getPaddingTop()) + getPaddingBottom()) - Math.min(0.0f, this.cqU.top)) - Math.min(0.0f, this.cqU.bottom) > size) {
                    this.cra = 0;
                }
            }
            if (this.cra == 0) {
                this.crd = j(((size - getPaddingTop()) - getPaddingBottom()) + Math.min(0.0f, this.cqU.top) + Math.min(0.0f, this.cqU.bottom));
                if (this.crd < 0) {
                    this.crd = 0;
                    this.cra = 0;
                    return size;
                }
                RectF rectF2 = this.cqU;
                this.cra = j((i4 - rectF2.top) - rectF2.bottom);
            }
            if (this.cra < 0) {
                this.crd = 0;
                this.cra = 0;
                return size;
            }
            return size;
        }
        if (this.cra == 0) {
            this.cra = j(getResources().getDisplayMetrics().density * 20.0f);
        }
        RectF rectF3 = this.cqU;
        this.crd = j(this.cra + rectF3.top + rectF3.bottom);
        if (this.crd < 0) {
            this.crd = 0;
            this.cra = 0;
            return size;
        }
        int j = j(this.crJ - i2);
        if (j > 0) {
            this.crd += j;
            this.cra = j + this.cra;
        }
        int max = Math.max(this.cra, this.crd);
        return Math.max(Math.max(max, getPaddingTop() + max + getPaddingBottom()), getSuggestedMinimumHeight());
    }

    private float getProgress() {
        return this.crv;
    }

    private boolean getStatusBasedOnPos() {
        return getProgress() > 0.5f;
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
        this.crv = f;
        invalidate();
    }

    private void setup() {
        int i;
        float paddingTop;
        float paddingLeft;
        int i2 = this.cqZ;
        if (i2 != 0 && (i = this.cra) != 0 && this.crb != 0 && this.crd != 0) {
            if (this.ab == -1.0f) {
                this.ab = Math.min(i2, i) / 2;
            }
            if (this.aqt == -1.0f) {
                this.aqt = Math.min(this.crb, this.crd) / 2;
            }
            int measuredWidth = (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight();
            int measuredHeight = (getMeasuredHeight() - getPaddingTop()) - getPaddingBottom();
            int j = j((this.crb - Math.min(0.0f, this.cqU.left)) - Math.min(0.0f, this.cqU.right));
            int j2 = j((this.crd - Math.min(0.0f, this.cqU.top)) - Math.min(0.0f, this.cqU.bottom));
            if (measuredHeight <= j2) {
                paddingTop = getPaddingTop() + Math.max(0.0f, this.cqU.top);
            } else {
                paddingTop = (((measuredHeight - j2) + 1) / 2) + getPaddingTop() + Math.max(0.0f, this.cqU.top);
            }
            if (measuredWidth <= this.crb) {
                paddingLeft = getPaddingLeft() + Math.max(0.0f, this.cqU.left);
            } else {
                paddingLeft = (((measuredWidth - j) + 1) / 2) + getPaddingLeft() + Math.max(0.0f, this.cqU.left);
            }
            this.crl.set(paddingLeft, paddingTop, this.cqZ + paddingLeft, this.cra + paddingTop);
            RectF rectF = this.crl;
            float f = rectF.left;
            RectF rectF2 = this.cqU;
            float f2 = f - rectF2.left;
            RectF rectF3 = this.crm;
            float f3 = rectF.top;
            float f4 = rectF2.top;
            rectF3.set(f2, f3 - f4, this.crb + f2, (f3 - f4) + this.crd);
            RectF rectF4 = this.crn;
            RectF rectF5 = this.crl;
            rectF4.set(rectF5.left, 0.0f, (this.crm.right - this.cqU.right) - rectF5.width(), 0.0f);
            this.aqt = Math.min(Math.min(this.crm.width(), this.crm.height()) / 2.0f, this.aqt);
            Drawable drawable = this.cqR;
            if (drawable != null) {
                RectF rectF6 = this.crm;
                drawable.setBounds((int) rectF6.left, (int) rectF6.top, j(rectF6.right), j(this.crm.bottom));
            }
            if (this.crG != null) {
                RectF rectF7 = this.crm;
                float width = ((((((rectF7.width() + this.crK) - this.cqZ) - this.cqU.right) - this.crG.getWidth()) / 2.0f) + rectF7.left) - this.crM;
                RectF rectF8 = this.crm;
                float height = ((rectF8.height() - this.crG.getHeight()) / 2.0f) + rectF8.top;
                this.cro.set(width, height, this.crG.getWidth() + width, this.crG.getHeight() + height);
            }
            if (this.crH != null) {
                RectF rectF9 = this.crm;
                float width2 = ((rectF9.right - (((((rectF9.width() + this.crK) - this.cqZ) - this.cqU.left) - this.crH.getWidth()) / 2.0f)) - this.crH.getWidth()) + this.crM;
                RectF rectF10 = this.crm;
                float height2 = ((rectF10.height() - this.crH.getHeight()) / 2.0f) + rectF10.top;
                this.crp.set(width2, height2, this.crH.getWidth() + width2, this.crH.getHeight() + height2);
            }
            this.crO = true;
        }
    }

    protected void b(boolean z) {
        ObjectAnimator objectAnimator = this.cru;
        if (objectAnimator != null) {
            if (objectAnimator.isRunning()) {
                this.cru.cancel();
            }
            this.cru.setDuration(this.cqW);
            if (z) {
                this.cru.setFloatValues(this.crv, 1.0f);
            } else {
                this.cru.setFloatValues(this.crv, 0.0f);
            }
            this.cru.start();
        }
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    protected void drawableStateChanged() {
        ColorStateList colorStateList;
        ColorStateList colorStateList2;
        super.drawableStateChanged();
        if (!this.crr && (colorStateList2 = this.cqT) != null) {
            this.cre = colorStateList2.getColorForState(getDrawableState(), this.cre);
        } else {
            setDrawableState(this.cqQ);
        }
        int[] iArr = isChecked() ? cqP : cqO;
        ColorStateList textColors = getTextColors();
        if (textColors != null) {
            int defaultColor = textColors.getDefaultColor();
            this.crh = textColors.getColorForState(cqO, defaultColor);
            this.cri = textColors.getColorForState(cqP, defaultColor);
        }
        if (!this.crs && (colorStateList = this.cqS) != null) {
            this.crf = colorStateList.getColorForState(getDrawableState(), this.crf);
            this.crg = this.cqS.getColorForState(iArr, this.crf);
            return;
        }
        Drawable drawable = this.cqR;
        if ((drawable instanceof StateListDrawable) && this.cqX) {
            drawable.setState(iArr);
            this.crk = this.cqR.getCurrent().mutate();
        } else {
            this.crk = null;
        }
        setDrawableState(this.cqR);
        Drawable drawable2 = this.cqR;
        if (drawable2 != null) {
            this.crj = drawable2.getCurrent().mutate();
        }
    }

    public long getAnimationDuration() {
        return this.cqW;
    }

    public ColorStateList getBackColor() {
        return this.cqS;
    }

    public Drawable getBackDrawable() {
        return this.cqR;
    }

    public float getBackRadius() {
        return this.aqt;
    }

    public PointF getBackSizeF() {
        return new PointF(this.crm.width(), this.crm.height());
    }

    public CharSequence getTextOff() {
        return this.crE;
    }

    public CharSequence getTextOn() {
        return this.crD;
    }

    public ColorStateList getThumbColor() {
        return this.cqT;
    }

    public Drawable getThumbDrawable() {
        return this.cqQ;
    }

    public float getThumbHeight() {
        return this.cra;
    }

    public RectF getThumbMargin() {
        return this.cqU;
    }

    public float getThumbRadius() {
        return this.ab;
    }

    public float getThumbRangeRatio() {
        return this.cqV;
    }

    public float getThumbWidth() {
        return this.cqZ;
    }

    public int getTintColor() {
        return this.cqY;
    }

    public void o() {
        if (this.crQ == null) {
            toggle();
            return;
        }
        super.setOnCheckedChangeListener(null);
        toggle();
        super.setOnCheckedChangeListener(this.crQ);
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (!this.crO) {
            setup();
        }
        if (this.crO) {
            if (this.crs) {
                if (this.cqX && this.crj != null && this.crk != null) {
                    Drawable drawable = isChecked() ? this.crj : this.crk;
                    Drawable drawable2 = isChecked() ? this.crk : this.crj;
                    int progress = (int) (getProgress() * 255.0f);
                    drawable.setAlpha(progress);
                    drawable.draw(canvas);
                    drawable2.setAlpha(255 - progress);
                    drawable2.draw(canvas);
                } else {
                    this.cqR.setAlpha(255);
                    this.cqR.draw(canvas);
                }
            } else if (this.cqX) {
                int i = isChecked() ? this.crf : this.crg;
                int i2 = isChecked() ? this.crg : this.crf;
                int progress2 = (int) (getProgress() * 255.0f);
                this.crq.setARGB((Color.alpha(i) * progress2) / 255, Color.red(i), Color.green(i), Color.blue(i));
                RectF rectF = this.crm;
                float f = this.aqt;
                canvas.drawRoundRect(rectF, f, f, this.crq);
                this.crq.setARGB(((255 - progress2) * Color.alpha(i2)) / 255, Color.red(i2), Color.green(i2), Color.blue(i2));
                RectF rectF2 = this.crm;
                float f2 = this.aqt;
                canvas.drawRoundRect(rectF2, f2, f2, this.crq);
                this.crq.setAlpha(255);
            } else {
                this.crq.setColor(this.crf);
                RectF rectF3 = this.crm;
                float f3 = this.aqt;
                canvas.drawRoundRect(rectF3, f3, f3, this.crq);
            }
            Layout layout = ((double) getProgress()) > 0.5d ? this.crG : this.crH;
            RectF rectF4 = ((double) getProgress()) > 0.5d ? this.cro : this.crp;
            if (layout != null && rectF4 != null) {
                int progress3 = (int) ((((double) getProgress()) >= 0.75d ? (getProgress() * 4.0f) - 3.0f : ((double) getProgress()) < 0.25d ? 1.0f - (getProgress() * 4.0f) : 0.0f) * 255.0f);
                int i3 = ((double) getProgress()) > 0.5d ? this.crh : this.cri;
                layout.getPaint().setARGB((progress3 * Color.alpha(i3)) / 255, Color.red(i3), Color.green(i3), Color.blue(i3));
                canvas.save();
                canvas.translate(rectF4.left, rectF4.top);
                layout.draw(canvas);
                canvas.restore();
            }
            this.crw.set(this.crl);
            this.crw.offset(this.crv * this.crn.width(), 0.0f);
            if (this.crr) {
                Drawable drawable3 = this.cqQ;
                RectF rectF5 = this.crw;
                drawable3.setBounds((int) rectF5.left, (int) rectF5.top, j(rectF5.right), j(this.crw.bottom));
                this.cqQ.draw(canvas);
            } else {
                this.crq.setColor(this.cre);
                RectF rectF6 = this.crw;
                float f4 = this.ab;
                canvas.drawRoundRect(rectF6, f4, f4, this.crq);
            }
            if (this.crt) {
                this.crC.setColor(Color.parseColor("#AA0000"));
                canvas.drawRect(this.crm, this.crC);
                this.crC.setColor(Color.parseColor("#0000FF"));
                canvas.drawRect(this.crw, this.crC);
                this.crC.setColor(Color.parseColor("#000000"));
                RectF rectF7 = this.crn;
                float f5 = rectF7.left;
                float f6 = this.crl.top;
                canvas.drawLine(f5, f6, rectF7.right, f6, this.crC);
                this.crC.setColor(Color.parseColor("#00CC00"));
                canvas.drawRect(((double) getProgress()) > 0.5d ? this.cro : this.crp, this.crC);
            }
        }
    }

    @Override // android.widget.TextView, android.view.View
    protected void onMeasure(int i, int i2) {
        if (this.crG == null && !TextUtils.isEmpty(this.crD)) {
            this.crG = e(this.crD);
        }
        if (this.crH == null && !TextUtils.isEmpty(this.crE)) {
            this.crH = e(this.crE);
        }
        Layout layout = this.crG;
        float width = layout != null ? layout.getWidth() : 0.0f;
        Layout layout2 = this.crH;
        float width2 = layout2 != null ? layout2.getWidth() : 0.0f;
        if (width == 0.0f && width2 == 0.0f) {
            this.crI = 0.0f;
        } else {
            this.crI = Math.max(width, width2);
        }
        Layout layout3 = this.crG;
        float height = layout3 != null ? layout3.getHeight() : 0.0f;
        Layout layout4 = this.crH;
        float height2 = layout4 != null ? layout4.getHeight() : 0.0f;
        if (height == 0.0f && height2 == 0.0f) {
            this.crJ = 0.0f;
        } else {
            this.crJ = Math.max(height, height2);
        }
        setMeasuredDimension(fJ(i), fK(i2));
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        a aVar = (a) parcelable;
        a(aVar.crR, aVar.crS);
        this.crN = true;
        super.onRestoreInstanceState(aVar.getSuperState());
        this.crN = false;
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    public Parcelable onSaveInstanceState() {
        a aVar = new a(super.onSaveInstanceState());
        aVar.crR = this.crD;
        aVar.crS = this.crE;
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
        if (isEnabled() && isClickable() && isFocusable() && this.crO) {
            int action = motionEvent.getAction();
            float x = motionEvent.getX() - this.crx;
            float y = motionEvent.getY() - this.cry;
            switch (action) {
                case 0:
                    this.crx = motionEvent.getX();
                    this.cry = motionEvent.getY();
                    this.crz = this.crx;
                    setPressed(true);
                    break;
                case 1:
                case 3:
                    this.crP = false;
                    setPressed(false);
                    float eventTime = (float) (motionEvent.getEventTime() - motionEvent.getDownTime());
                    if (Math.abs(x) < this.crA && Math.abs(y) < this.crA && eventTime < this.crB) {
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
                    setProgress(getProgress() + ((x2 - this.crz) / this.crn.width()));
                    if (!this.crP && (Math.abs(x) > this.crA / 2 || Math.abs(y) > this.crA / 2)) {
                        if (y != 0.0f && Math.abs(x) <= Math.abs(y)) {
                            if (Math.abs(y) > Math.abs(x)) {
                                return false;
                            }
                        } else {
                            adM();
                        }
                    }
                    this.crz = x2;
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
        this.cqW = j;
    }

    public void setBackColor(ColorStateList colorStateList) {
        this.cqS = colorStateList;
        if (this.cqS != null) {
            setBackDrawable(null);
        }
        invalidate();
    }

    public void setBackColorRes(int i) {
        setBackColor(getResources().getColorStateList(i));
    }

    public void setBackDrawable(Drawable drawable) {
        this.cqR = drawable;
        this.crs = this.cqR != null;
        refreshDrawableState();
        this.crO = false;
        requestLayout();
        invalidate();
    }

    public void setBackDrawableRes(int i) {
        setBackDrawable(getResources().getDrawable(i));
    }

    public void setBackRadius(float f) {
        this.aqt = f;
        if (this.crs) {
            return;
        }
        invalidate();
    }

    @Override // android.widget.CompoundButton, android.widget.Checkable
    public void setChecked(boolean z) {
        if (isChecked() != z) {
            b(z);
        }
        if (this.crN) {
            setCheckedImmediatelyNoEvent(z);
        } else {
            super.setChecked(z);
        }
    }

    public void setCheckedImmediately(boolean z) {
        super.setChecked(z);
        ObjectAnimator objectAnimator = this.cru;
        if (objectAnimator != null && objectAnimator.isRunning()) {
            this.cru.cancel();
        }
        setProgress(z ? 1.0f : 0.0f);
        invalidate();
    }

    public void setCheckedImmediatelyNoEvent(boolean z) {
        if (this.crQ == null) {
            setCheckedImmediately(z);
            return;
        }
        super.setOnCheckedChangeListener(null);
        setCheckedImmediately(z);
        super.setOnCheckedChangeListener(this.crQ);
    }

    public void setCheckedNoEvent(boolean z) {
        if (this.crQ == null) {
            setChecked(z);
            return;
        }
        super.setOnCheckedChangeListener(null);
        setChecked(z);
        super.setOnCheckedChangeListener(this.crQ);
    }

    public void setDrawDebugRect(boolean z) {
        this.crt = z;
        invalidate();
    }

    public void setFadeBack(boolean z) {
        this.cqX = z;
    }

    @Override // android.widget.CompoundButton
    public void setOnCheckedChangeListener(CompoundButton.OnCheckedChangeListener onCheckedChangeListener) {
        super.setOnCheckedChangeListener(onCheckedChangeListener);
        this.crQ = onCheckedChangeListener;
    }

    public void setTextAdjust(int i) {
        this.crM = i;
        this.crO = false;
        requestLayout();
        invalidate();
    }

    public void setTextExtra(int i) {
        this.crL = i;
        this.crO = false;
        requestLayout();
        invalidate();
    }

    public void setTextThumbInset(int i) {
        this.crK = i;
        this.crO = false;
        requestLayout();
        invalidate();
    }

    public void setThumbColor(ColorStateList colorStateList) {
        this.cqT = colorStateList;
        if (this.cqT != null) {
            setThumbDrawable(null);
        }
        invalidate();
    }

    public void setThumbColorRes(int i) {
        setThumbColor(getResources().getColorStateList(i));
    }

    public void setThumbDrawable(Drawable drawable) {
        this.cqQ = drawable;
        this.crr = this.cqQ != null;
        refreshDrawableState();
        this.crO = false;
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
        if (this.crr) {
            return;
        }
        invalidate();
    }

    public void setThumbRangeRatio(float f) {
        this.cqV = f;
        this.crO = false;
        requestLayout();
    }

    public void setTintColor(int i) {
        this.cqY = i;
        this.cqT = com.baidu.poly.widget.b.fM(this.cqY);
        this.cqS = com.baidu.poly.widget.b.fN(this.cqY);
        this.crs = false;
        this.crr = false;
        refreshDrawableState();
        invalidate();
    }

    public SwitchButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.crt = false;
        this.crN = false;
        this.crO = false;
        this.crP = false;
        a(attributeSet);
    }

    public SwitchButton(Context context) {
        super(context);
        this.crt = false;
        this.crN = false;
        this.crO = false;
        this.crP = false;
        a(null);
    }

    private Layout e(CharSequence charSequence) {
        TextPaint textPaint = this.crF;
        return new StaticLayout(charSequence, textPaint, (int) Math.ceil(Layout.getDesiredWidth(charSequence, textPaint)), Layout.Alignment.ALIGN_CENTER, 1.0f, 0.0f, false);
    }

    public void a(float f, float f2, float f3, float f4) {
        this.cqU.set(f, f2, f3, f4);
        this.crO = false;
        requestLayout();
    }

    public void a(CharSequence charSequence, CharSequence charSequence2) {
        this.crD = charSequence;
        this.crE = charSequence2;
        this.crG = null;
        this.crH = null;
        this.crO = false;
        requestLayout();
        invalidate();
    }
}
