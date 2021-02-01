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
/* loaded from: classes4.dex */
public class SwitchButton extends CompoundButton {
    private static int[] cpm = {16842912, 16842910, 16842919};
    private static int[] cpn = {-16842912, 16842910, 16842919};
    private float ab;
    private float aoS;
    private int cpA;
    private int cpB;
    private int cpC;
    private int cpD;
    private int cpE;
    private int cpF;
    private int cpG;
    private int cpH;
    private Drawable cpI;
    private Drawable cpJ;
    private RectF cpK;
    private RectF cpL;
    private RectF cpM;
    private RectF cpN;
    private RectF cpO;
    private Paint cpP;
    private boolean cpQ;
    private boolean cpR;
    private boolean cpS;
    private ObjectAnimator cpT;
    private float cpU;
    private RectF cpV;
    private float cpW;
    private float cpX;
    private float cpY;
    private int cpZ;
    private Drawable cpo;
    private Drawable cpp;
    private ColorStateList cpq;
    private ColorStateList cpr;
    private RectF cps;
    private float cpv;
    private long cpw;
    private boolean cpx;
    private int cpy;
    private int cpz;
    private int cqa;
    private Paint cqb;
    private CharSequence cqc;
    private CharSequence cqd;
    private TextPaint cqe;
    private Layout cqf;
    private Layout cqg;
    private float cqh;
    private float cqi;
    private int cqj;
    private int cqk;
    private int cql;
    private boolean cqm;
    private boolean cqn;
    private boolean cqo;
    private CompoundButton.OnCheckedChangeListener cqp;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public static class a extends View.BaseSavedState {
        public static final Parcelable.Creator<a> CREATOR = new C0309a();
        CharSequence cqq;
        CharSequence cqr;

        /* renamed from: com.baidu.poly.widget.SwitchButton$a$a  reason: collision with other inner class name */
        /* loaded from: classes4.dex */
        static class C0309a implements Parcelable.Creator<a> {
            C0309a() {
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // android.os.Parcelable.Creator
            /* renamed from: fO */
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
            TextUtils.writeToParcel(this.cqq, parcel, i);
            TextUtils.writeToParcel(this.cqr, parcel, i);
        }

        a(Parcelable parcelable) {
            super(parcelable);
        }

        private a(Parcel parcel) {
            super(parcel);
            this.cqq = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
            this.cqr = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
        }
    }

    public SwitchButton(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.cpS = false;
        this.cqm = false;
        this.cqn = false;
        this.cqo = false;
        a(attributeSet);
    }

    private void a(AttributeSet attributeSet) {
        this.cpZ = ViewConfiguration.get(getContext()).getScaledTouchSlop();
        this.cqa = ViewConfiguration.getPressedStateDuration() + ViewConfiguration.getTapTimeout();
        this.cpP = new Paint(1);
        this.cqb = new Paint(1);
        this.cqb.setStyle(Paint.Style.STROKE);
        this.cqb.setStrokeWidth(getResources().getDisplayMetrics().density);
        this.cqe = getPaint();
        this.cpK = new RectF();
        this.cpL = new RectF();
        this.cpM = new RectF();
        this.cps = new RectF();
        this.cpN = new RectF();
        this.cpO = new RectF();
        this.cpT = ObjectAnimator.ofFloat(this, "progress", 0.0f, 0.0f).setDuration(250L);
        this.cpT.setInterpolator(new AccelerateDecelerateInterpolator());
        this.cpV = new RectF();
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
        this.cqc = str;
        this.cqd = str2;
        this.cqj = i3;
        this.cqk = i4;
        this.cql = i6;
        this.cpo = drawable;
        this.cpr = colorStateList;
        this.cpQ = this.cpo != null;
        this.cpy = i2;
        if (this.cpy == 0) {
            new TypedValue();
            this.cpy = 3309506;
        }
        if (!this.cpQ && this.cpr == null) {
            this.cpr = com.baidu.poly.widget.b.fL(this.cpy);
            this.cpD = this.cpr.getDefaultColor();
        }
        this.cpz = j(f6);
        this.cpA = j(f7);
        this.cpp = drawable2;
        this.cpq = colorStateList2;
        this.cpR = this.cpp != null;
        if (!this.cpR && this.cpq == null) {
            this.cpq = com.baidu.poly.widget.b.fM(this.cpy);
            this.cpE = this.cpq.getDefaultColor();
            this.cpF = this.cpq.getColorForState(cpm, this.cpE);
        }
        this.cps.set(f2, f4, f3, f5);
        this.cpv = this.cps.width() >= 0.0f ? Math.max(f10, 1.0f) : f10;
        this.ab = f8;
        this.aoS = f9;
        this.cpw = i;
        this.cpx = z;
        this.cpT.setDuration(this.cpw);
        if (isChecked()) {
            setProgress(1.0f);
        }
    }

    private void adJ() {
        ViewParent parent = getParent();
        if (parent != null) {
            parent.requestDisallowInterceptTouchEvent(true);
        }
        this.cqo = true;
    }

    private int fI(int i) {
        int i2;
        int size = View.MeasureSpec.getSize(i);
        int mode = View.MeasureSpec.getMode(i);
        if (this.cpz == 0 && this.cpQ) {
            this.cpz = this.cpo.getIntrinsicWidth();
        }
        int j = j(this.cqh);
        if (this.cpv == 0.0f) {
            this.cpv = 1.8f;
        }
        if (mode == 1073741824) {
            int paddingLeft = (size - getPaddingLeft()) - getPaddingRight();
            if (this.cpz != 0) {
                int j2 = j(i2 * this.cpv);
                RectF rectF = this.cps;
                int j3 = (this.cqk + j) - ((j2 - this.cpz) + j(Math.max(rectF.left, rectF.right)));
                float f = j2;
                RectF rectF2 = this.cps;
                this.cpB = j(rectF2.right + rectF2.left + f + Math.max(j3, 0));
                if (this.cpB < 0) {
                    this.cpz = 0;
                }
                if (f + Math.max(this.cps.left, 0.0f) + Math.max(this.cps.right, 0.0f) + Math.max(j3, 0) > paddingLeft) {
                    this.cpz = 0;
                }
            }
            if (this.cpz == 0) {
                int j4 = j((((size - getPaddingLeft()) - getPaddingRight()) - Math.max(this.cps.left, 0.0f)) - Math.max(this.cps.right, 0.0f));
                if (j4 < 0) {
                    this.cpz = 0;
                    this.cpB = 0;
                    return size;
                }
                float f2 = j4;
                this.cpz = j(f2 / this.cpv);
                RectF rectF3 = this.cps;
                this.cpB = j(f2 + rectF3.left + rectF3.right);
                if (this.cpB < 0) {
                    this.cpz = 0;
                    this.cpB = 0;
                    return size;
                }
                int i3 = j + this.cqk;
                int i4 = j4 - this.cpz;
                RectF rectF4 = this.cps;
                int j5 = i3 - (i4 + j(Math.max(rectF4.left, rectF4.right)));
                if (j5 > 0) {
                    this.cpz -= j5;
                }
                if (this.cpz < 0) {
                    this.cpz = 0;
                    this.cpB = 0;
                    return size;
                }
                return size;
            }
            return size;
        }
        if (this.cpz == 0) {
            this.cpz = j(getResources().getDisplayMetrics().density * 20.0f);
        }
        if (this.cpv == 0.0f) {
            this.cpv = 1.8f;
        }
        int j6 = j(this.cpz * this.cpv);
        RectF rectF5 = this.cps;
        int j7 = j((j + this.cqk) - (((j6 - this.cpz) + Math.max(rectF5.left, rectF5.right)) + this.cqj));
        float f3 = j6;
        RectF rectF6 = this.cps;
        this.cpB = j(rectF6.right + rectF6.left + f3 + Math.max(0, j7));
        if (this.cpB < 0) {
            this.cpz = 0;
            this.cpB = 0;
            return size;
        }
        int j8 = j(Math.max(0.0f, this.cps.left) + f3 + Math.max(0.0f, this.cps.right) + Math.max(0, j7));
        return Math.max(j8, getPaddingLeft() + j8 + getPaddingRight());
    }

    private int fJ(int i) {
        int i2;
        int i3;
        int i4;
        int size = View.MeasureSpec.getSize(i);
        int mode = View.MeasureSpec.getMode(i);
        if (this.cpA == 0 && this.cpQ) {
            this.cpA = this.cpo.getIntrinsicHeight();
        }
        if (mode == 1073741824) {
            if (this.cpA != 0) {
                RectF rectF = this.cps;
                this.cpC = j(i3 + rectF.top + rectF.bottom);
                this.cpC = j(Math.max(this.cpC, this.cqi));
                if ((((this.cpC + getPaddingTop()) + getPaddingBottom()) - Math.min(0.0f, this.cps.top)) - Math.min(0.0f, this.cps.bottom) > size) {
                    this.cpA = 0;
                }
            }
            if (this.cpA == 0) {
                this.cpC = j(((size - getPaddingTop()) - getPaddingBottom()) + Math.min(0.0f, this.cps.top) + Math.min(0.0f, this.cps.bottom));
                if (this.cpC < 0) {
                    this.cpC = 0;
                    this.cpA = 0;
                    return size;
                }
                RectF rectF2 = this.cps;
                this.cpA = j((i4 - rectF2.top) - rectF2.bottom);
            }
            if (this.cpA < 0) {
                this.cpC = 0;
                this.cpA = 0;
                return size;
            }
            return size;
        }
        if (this.cpA == 0) {
            this.cpA = j(getResources().getDisplayMetrics().density * 20.0f);
        }
        RectF rectF3 = this.cps;
        this.cpC = j(this.cpA + rectF3.top + rectF3.bottom);
        if (this.cpC < 0) {
            this.cpC = 0;
            this.cpA = 0;
            return size;
        }
        int j = j(this.cqi - i2);
        if (j > 0) {
            this.cpC += j;
            this.cpA = j + this.cpA;
        }
        int max = Math.max(this.cpA, this.cpC);
        return Math.max(Math.max(max, getPaddingTop() + max + getPaddingBottom()), getSuggestedMinimumHeight());
    }

    private float getProgress() {
        return this.cpU;
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
        this.cpU = f;
        invalidate();
    }

    private void setup() {
        int i;
        float paddingTop;
        float paddingLeft;
        int i2 = this.cpz;
        if (i2 != 0 && (i = this.cpA) != 0 && this.cpB != 0 && this.cpC != 0) {
            if (this.ab == -1.0f) {
                this.ab = Math.min(i2, i) / 2;
            }
            if (this.aoS == -1.0f) {
                this.aoS = Math.min(this.cpB, this.cpC) / 2;
            }
            int measuredWidth = (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight();
            int measuredHeight = (getMeasuredHeight() - getPaddingTop()) - getPaddingBottom();
            int j = j((this.cpB - Math.min(0.0f, this.cps.left)) - Math.min(0.0f, this.cps.right));
            int j2 = j((this.cpC - Math.min(0.0f, this.cps.top)) - Math.min(0.0f, this.cps.bottom));
            if (measuredHeight <= j2) {
                paddingTop = getPaddingTop() + Math.max(0.0f, this.cps.top);
            } else {
                paddingTop = (((measuredHeight - j2) + 1) / 2) + getPaddingTop() + Math.max(0.0f, this.cps.top);
            }
            if (measuredWidth <= this.cpB) {
                paddingLeft = getPaddingLeft() + Math.max(0.0f, this.cps.left);
            } else {
                paddingLeft = (((measuredWidth - j) + 1) / 2) + getPaddingLeft() + Math.max(0.0f, this.cps.left);
            }
            this.cpK.set(paddingLeft, paddingTop, this.cpz + paddingLeft, this.cpA + paddingTop);
            RectF rectF = this.cpK;
            float f = rectF.left;
            RectF rectF2 = this.cps;
            float f2 = f - rectF2.left;
            RectF rectF3 = this.cpL;
            float f3 = rectF.top;
            float f4 = rectF2.top;
            rectF3.set(f2, f3 - f4, this.cpB + f2, (f3 - f4) + this.cpC);
            RectF rectF4 = this.cpM;
            RectF rectF5 = this.cpK;
            rectF4.set(rectF5.left, 0.0f, (this.cpL.right - this.cps.right) - rectF5.width(), 0.0f);
            this.aoS = Math.min(Math.min(this.cpL.width(), this.cpL.height()) / 2.0f, this.aoS);
            Drawable drawable = this.cpp;
            if (drawable != null) {
                RectF rectF6 = this.cpL;
                drawable.setBounds((int) rectF6.left, (int) rectF6.top, j(rectF6.right), j(this.cpL.bottom));
            }
            if (this.cqf != null) {
                RectF rectF7 = this.cpL;
                float width = ((((((rectF7.width() + this.cqj) - this.cpz) - this.cps.right) - this.cqf.getWidth()) / 2.0f) + rectF7.left) - this.cql;
                RectF rectF8 = this.cpL;
                float height = ((rectF8.height() - this.cqf.getHeight()) / 2.0f) + rectF8.top;
                this.cpN.set(width, height, this.cqf.getWidth() + width, this.cqf.getHeight() + height);
            }
            if (this.cqg != null) {
                RectF rectF9 = this.cpL;
                float width2 = ((rectF9.right - (((((rectF9.width() + this.cqj) - this.cpz) - this.cps.left) - this.cqg.getWidth()) / 2.0f)) - this.cqg.getWidth()) + this.cql;
                RectF rectF10 = this.cpL;
                float height2 = ((rectF10.height() - this.cqg.getHeight()) / 2.0f) + rectF10.top;
                this.cpO.set(width2, height2, this.cqg.getWidth() + width2, this.cqg.getHeight() + height2);
            }
            this.cqn = true;
        }
    }

    protected void b(boolean z) {
        ObjectAnimator objectAnimator = this.cpT;
        if (objectAnimator != null) {
            if (objectAnimator.isRunning()) {
                this.cpT.cancel();
            }
            this.cpT.setDuration(this.cpw);
            if (z) {
                this.cpT.setFloatValues(this.cpU, 1.0f);
            } else {
                this.cpT.setFloatValues(this.cpU, 0.0f);
            }
            this.cpT.start();
        }
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    protected void drawableStateChanged() {
        ColorStateList colorStateList;
        ColorStateList colorStateList2;
        super.drawableStateChanged();
        if (!this.cpQ && (colorStateList2 = this.cpr) != null) {
            this.cpD = colorStateList2.getColorForState(getDrawableState(), this.cpD);
        } else {
            setDrawableState(this.cpo);
        }
        int[] iArr = isChecked() ? cpn : cpm;
        ColorStateList textColors = getTextColors();
        if (textColors != null) {
            int defaultColor = textColors.getDefaultColor();
            this.cpG = textColors.getColorForState(cpm, defaultColor);
            this.cpH = textColors.getColorForState(cpn, defaultColor);
        }
        if (!this.cpR && (colorStateList = this.cpq) != null) {
            this.cpE = colorStateList.getColorForState(getDrawableState(), this.cpE);
            this.cpF = this.cpq.getColorForState(iArr, this.cpE);
            return;
        }
        Drawable drawable = this.cpp;
        if ((drawable instanceof StateListDrawable) && this.cpx) {
            drawable.setState(iArr);
            this.cpJ = this.cpp.getCurrent().mutate();
        } else {
            this.cpJ = null;
        }
        setDrawableState(this.cpp);
        Drawable drawable2 = this.cpp;
        if (drawable2 != null) {
            this.cpI = drawable2.getCurrent().mutate();
        }
    }

    public long getAnimationDuration() {
        return this.cpw;
    }

    public ColorStateList getBackColor() {
        return this.cpq;
    }

    public Drawable getBackDrawable() {
        return this.cpp;
    }

    public float getBackRadius() {
        return this.aoS;
    }

    public PointF getBackSizeF() {
        return new PointF(this.cpL.width(), this.cpL.height());
    }

    public CharSequence getTextOff() {
        return this.cqd;
    }

    public CharSequence getTextOn() {
        return this.cqc;
    }

    public ColorStateList getThumbColor() {
        return this.cpr;
    }

    public Drawable getThumbDrawable() {
        return this.cpo;
    }

    public float getThumbHeight() {
        return this.cpA;
    }

    public RectF getThumbMargin() {
        return this.cps;
    }

    public float getThumbRadius() {
        return this.ab;
    }

    public float getThumbRangeRatio() {
        return this.cpv;
    }

    public float getThumbWidth() {
        return this.cpz;
    }

    public int getTintColor() {
        return this.cpy;
    }

    public void o() {
        if (this.cqp == null) {
            toggle();
            return;
        }
        super.setOnCheckedChangeListener(null);
        toggle();
        super.setOnCheckedChangeListener(this.cqp);
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (!this.cqn) {
            setup();
        }
        if (this.cqn) {
            if (this.cpR) {
                if (this.cpx && this.cpI != null && this.cpJ != null) {
                    Drawable drawable = isChecked() ? this.cpI : this.cpJ;
                    Drawable drawable2 = isChecked() ? this.cpJ : this.cpI;
                    int progress = (int) (getProgress() * 255.0f);
                    drawable.setAlpha(progress);
                    drawable.draw(canvas);
                    drawable2.setAlpha(255 - progress);
                    drawable2.draw(canvas);
                } else {
                    this.cpp.setAlpha(255);
                    this.cpp.draw(canvas);
                }
            } else if (this.cpx) {
                int i = isChecked() ? this.cpE : this.cpF;
                int i2 = isChecked() ? this.cpF : this.cpE;
                int progress2 = (int) (getProgress() * 255.0f);
                this.cpP.setARGB((Color.alpha(i) * progress2) / 255, Color.red(i), Color.green(i), Color.blue(i));
                RectF rectF = this.cpL;
                float f = this.aoS;
                canvas.drawRoundRect(rectF, f, f, this.cpP);
                this.cpP.setARGB(((255 - progress2) * Color.alpha(i2)) / 255, Color.red(i2), Color.green(i2), Color.blue(i2));
                RectF rectF2 = this.cpL;
                float f2 = this.aoS;
                canvas.drawRoundRect(rectF2, f2, f2, this.cpP);
                this.cpP.setAlpha(255);
            } else {
                this.cpP.setColor(this.cpE);
                RectF rectF3 = this.cpL;
                float f3 = this.aoS;
                canvas.drawRoundRect(rectF3, f3, f3, this.cpP);
            }
            Layout layout = ((double) getProgress()) > 0.5d ? this.cqf : this.cqg;
            RectF rectF4 = ((double) getProgress()) > 0.5d ? this.cpN : this.cpO;
            if (layout != null && rectF4 != null) {
                int progress3 = (int) ((((double) getProgress()) >= 0.75d ? (getProgress() * 4.0f) - 3.0f : ((double) getProgress()) < 0.25d ? 1.0f - (getProgress() * 4.0f) : 0.0f) * 255.0f);
                int i3 = ((double) getProgress()) > 0.5d ? this.cpG : this.cpH;
                layout.getPaint().setARGB((progress3 * Color.alpha(i3)) / 255, Color.red(i3), Color.green(i3), Color.blue(i3));
                canvas.save();
                canvas.translate(rectF4.left, rectF4.top);
                layout.draw(canvas);
                canvas.restore();
            }
            this.cpV.set(this.cpK);
            this.cpV.offset(this.cpU * this.cpM.width(), 0.0f);
            if (this.cpQ) {
                Drawable drawable3 = this.cpo;
                RectF rectF5 = this.cpV;
                drawable3.setBounds((int) rectF5.left, (int) rectF5.top, j(rectF5.right), j(this.cpV.bottom));
                this.cpo.draw(canvas);
            } else {
                this.cpP.setColor(this.cpD);
                RectF rectF6 = this.cpV;
                float f4 = this.ab;
                canvas.drawRoundRect(rectF6, f4, f4, this.cpP);
            }
            if (this.cpS) {
                this.cqb.setColor(Color.parseColor("#AA0000"));
                canvas.drawRect(this.cpL, this.cqb);
                this.cqb.setColor(Color.parseColor("#0000FF"));
                canvas.drawRect(this.cpV, this.cqb);
                this.cqb.setColor(Color.parseColor("#000000"));
                RectF rectF7 = this.cpM;
                float f5 = rectF7.left;
                float f6 = this.cpK.top;
                canvas.drawLine(f5, f6, rectF7.right, f6, this.cqb);
                this.cqb.setColor(Color.parseColor("#00CC00"));
                canvas.drawRect(((double) getProgress()) > 0.5d ? this.cpN : this.cpO, this.cqb);
            }
        }
    }

    @Override // android.widget.TextView, android.view.View
    protected void onMeasure(int i, int i2) {
        if (this.cqf == null && !TextUtils.isEmpty(this.cqc)) {
            this.cqf = e(this.cqc);
        }
        if (this.cqg == null && !TextUtils.isEmpty(this.cqd)) {
            this.cqg = e(this.cqd);
        }
        Layout layout = this.cqf;
        float width = layout != null ? layout.getWidth() : 0.0f;
        Layout layout2 = this.cqg;
        float width2 = layout2 != null ? layout2.getWidth() : 0.0f;
        if (width == 0.0f && width2 == 0.0f) {
            this.cqh = 0.0f;
        } else {
            this.cqh = Math.max(width, width2);
        }
        Layout layout3 = this.cqf;
        float height = layout3 != null ? layout3.getHeight() : 0.0f;
        Layout layout4 = this.cqg;
        float height2 = layout4 != null ? layout4.getHeight() : 0.0f;
        if (height == 0.0f && height2 == 0.0f) {
            this.cqi = 0.0f;
        } else {
            this.cqi = Math.max(height, height2);
        }
        setMeasuredDimension(fI(i), fJ(i2));
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        a aVar = (a) parcelable;
        a(aVar.cqq, aVar.cqr);
        this.cqm = true;
        super.onRestoreInstanceState(aVar.getSuperState());
        this.cqm = false;
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    public Parcelable onSaveInstanceState() {
        a aVar = new a(super.onSaveInstanceState());
        aVar.cqq = this.cqc;
        aVar.cqr = this.cqd;
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
        if (isEnabled() && isClickable() && isFocusable() && this.cqn) {
            int action = motionEvent.getAction();
            float x = motionEvent.getX() - this.cpW;
            float y = motionEvent.getY() - this.cpX;
            switch (action) {
                case 0:
                    this.cpW = motionEvent.getX();
                    this.cpX = motionEvent.getY();
                    this.cpY = this.cpW;
                    setPressed(true);
                    break;
                case 1:
                case 3:
                    this.cqo = false;
                    setPressed(false);
                    float eventTime = (float) (motionEvent.getEventTime() - motionEvent.getDownTime());
                    if (Math.abs(x) < this.cpZ && Math.abs(y) < this.cpZ && eventTime < this.cqa) {
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
                    setProgress(getProgress() + ((x2 - this.cpY) / this.cpM.width()));
                    if (!this.cqo && (Math.abs(x) > this.cpZ / 2 || Math.abs(y) > this.cpZ / 2)) {
                        if (y != 0.0f && Math.abs(x) <= Math.abs(y)) {
                            if (Math.abs(y) > Math.abs(x)) {
                                return false;
                            }
                        } else {
                            adJ();
                        }
                    }
                    this.cpY = x2;
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
        this.cpw = j;
    }

    public void setBackColor(ColorStateList colorStateList) {
        this.cpq = colorStateList;
        if (this.cpq != null) {
            setBackDrawable(null);
        }
        invalidate();
    }

    public void setBackColorRes(int i) {
        setBackColor(getResources().getColorStateList(i));
    }

    public void setBackDrawable(Drawable drawable) {
        this.cpp = drawable;
        this.cpR = this.cpp != null;
        refreshDrawableState();
        this.cqn = false;
        requestLayout();
        invalidate();
    }

    public void setBackDrawableRes(int i) {
        setBackDrawable(getResources().getDrawable(i));
    }

    public void setBackRadius(float f) {
        this.aoS = f;
        if (this.cpR) {
            return;
        }
        invalidate();
    }

    @Override // android.widget.CompoundButton, android.widget.Checkable
    public void setChecked(boolean z) {
        if (isChecked() != z) {
            b(z);
        }
        if (this.cqm) {
            setCheckedImmediatelyNoEvent(z);
        } else {
            super.setChecked(z);
        }
    }

    public void setCheckedImmediately(boolean z) {
        super.setChecked(z);
        ObjectAnimator objectAnimator = this.cpT;
        if (objectAnimator != null && objectAnimator.isRunning()) {
            this.cpT.cancel();
        }
        setProgress(z ? 1.0f : 0.0f);
        invalidate();
    }

    public void setCheckedImmediatelyNoEvent(boolean z) {
        if (this.cqp == null) {
            setCheckedImmediately(z);
            return;
        }
        super.setOnCheckedChangeListener(null);
        setCheckedImmediately(z);
        super.setOnCheckedChangeListener(this.cqp);
    }

    public void setCheckedNoEvent(boolean z) {
        if (this.cqp == null) {
            setChecked(z);
            return;
        }
        super.setOnCheckedChangeListener(null);
        setChecked(z);
        super.setOnCheckedChangeListener(this.cqp);
    }

    public void setDrawDebugRect(boolean z) {
        this.cpS = z;
        invalidate();
    }

    public void setFadeBack(boolean z) {
        this.cpx = z;
    }

    @Override // android.widget.CompoundButton
    public void setOnCheckedChangeListener(CompoundButton.OnCheckedChangeListener onCheckedChangeListener) {
        super.setOnCheckedChangeListener(onCheckedChangeListener);
        this.cqp = onCheckedChangeListener;
    }

    public void setTextAdjust(int i) {
        this.cql = i;
        this.cqn = false;
        requestLayout();
        invalidate();
    }

    public void setTextExtra(int i) {
        this.cqk = i;
        this.cqn = false;
        requestLayout();
        invalidate();
    }

    public void setTextThumbInset(int i) {
        this.cqj = i;
        this.cqn = false;
        requestLayout();
        invalidate();
    }

    public void setThumbColor(ColorStateList colorStateList) {
        this.cpr = colorStateList;
        if (this.cpr != null) {
            setThumbDrawable(null);
        }
        invalidate();
    }

    public void setThumbColorRes(int i) {
        setThumbColor(getResources().getColorStateList(i));
    }

    public void setThumbDrawable(Drawable drawable) {
        this.cpo = drawable;
        this.cpQ = this.cpo != null;
        refreshDrawableState();
        this.cqn = false;
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
        if (this.cpQ) {
            return;
        }
        invalidate();
    }

    public void setThumbRangeRatio(float f) {
        this.cpv = f;
        this.cqn = false;
        requestLayout();
    }

    public void setTintColor(int i) {
        this.cpy = i;
        this.cpr = com.baidu.poly.widget.b.fL(this.cpy);
        this.cpq = com.baidu.poly.widget.b.fM(this.cpy);
        this.cpR = false;
        this.cpQ = false;
        refreshDrawableState();
        invalidate();
    }

    public SwitchButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.cpS = false;
        this.cqm = false;
        this.cqn = false;
        this.cqo = false;
        a(attributeSet);
    }

    public SwitchButton(Context context) {
        super(context);
        this.cpS = false;
        this.cqm = false;
        this.cqn = false;
        this.cqo = false;
        a(null);
    }

    private Layout e(CharSequence charSequence) {
        TextPaint textPaint = this.cqe;
        return new StaticLayout(charSequence, textPaint, (int) Math.ceil(Layout.getDesiredWidth(charSequence, textPaint)), Layout.Alignment.ALIGN_CENTER, 1.0f, 0.0f, false);
    }

    public void a(float f, float f2, float f3, float f4) {
        this.cps.set(f, f2, f3, f4);
        this.cqn = false;
        requestLayout();
    }

    public void a(CharSequence charSequence, CharSequence charSequence2) {
        this.cqc = charSequence;
        this.cqd = charSequence2;
        this.cqf = null;
        this.cqg = null;
        this.cqn = false;
        requestLayout();
        invalidate();
    }
}
