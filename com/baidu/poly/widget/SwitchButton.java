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
/* loaded from: classes3.dex */
public class SwitchButton extends CompoundButton {
    private static int[] ckV = {16842912, 16842910, 16842919};
    private static int[] ckW = {-16842912, 16842910, 16842919};
    private float ab;
    private float apc;
    private Drawable ckX;
    private Drawable ckY;
    private ColorStateList ckZ;
    private ObjectAnimator clA;
    private float clB;
    private RectF clC;
    private float clD;
    private float clE;
    private float clF;
    private int clG;
    private int clH;
    private Paint clI;
    private CharSequence clJ;
    private CharSequence clK;
    private TextPaint clL;
    private Layout clM;
    private Layout clN;
    private float clO;
    private float clP;
    private int clQ;
    private int clR;
    private int clS;
    private boolean clT;
    private boolean clU;
    private boolean clV;
    private CompoundButton.OnCheckedChangeListener clW;
    private ColorStateList cla;
    private RectF clb;
    private float clc;
    private long cld;
    private boolean cle;
    private int clf;
    private int clg;
    private int clh;
    private int cli;
    private int clj;
    private int clk;
    private int cll;
    private int clm;
    private int cln;
    private int clo;
    private Drawable clp;
    private Drawable clq;
    private RectF clr;
    private RectF cls;
    private RectF clt;
    private RectF clu;
    private RectF clv;
    private Paint clw;
    private boolean clx;
    private boolean cly;
    private boolean clz;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public static class a extends View.BaseSavedState {
        public static final Parcelable.Creator<a> CREATOR = new C0305a();
        CharSequence clX;
        CharSequence clY;

        /* renamed from: com.baidu.poly.widget.SwitchButton$a$a  reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        static class C0305a implements Parcelable.Creator<a> {
            C0305a() {
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // android.os.Parcelable.Creator
            /* renamed from: fI */
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
            TextUtils.writeToParcel(this.clX, parcel, i);
            TextUtils.writeToParcel(this.clY, parcel, i);
        }

        a(Parcelable parcelable) {
            super(parcelable);
        }

        private a(Parcel parcel) {
            super(parcel);
            this.clX = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
            this.clY = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
        }
    }

    public SwitchButton(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.clz = false;
        this.clT = false;
        this.clU = false;
        this.clV = false;
        a(attributeSet);
    }

    private void a(AttributeSet attributeSet) {
        this.clG = ViewConfiguration.get(getContext()).getScaledTouchSlop();
        this.clH = ViewConfiguration.getPressedStateDuration() + ViewConfiguration.getTapTimeout();
        this.clw = new Paint(1);
        this.clI = new Paint(1);
        this.clI.setStyle(Paint.Style.STROKE);
        this.clI.setStrokeWidth(getResources().getDisplayMetrics().density);
        this.clL = getPaint();
        this.clr = new RectF();
        this.cls = new RectF();
        this.clt = new RectF();
        this.clb = new RectF();
        this.clu = new RectF();
        this.clv = new RectF();
        this.clA = ObjectAnimator.ofFloat(this, "progress", 0.0f, 0.0f).setDuration(250L);
        this.clA.setInterpolator(new AccelerateDecelerateInterpolator());
        this.clC = new RectF();
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
        this.clJ = str;
        this.clK = str2;
        this.clQ = i3;
        this.clR = i4;
        this.clS = i6;
        this.ckX = drawable;
        this.cla = colorStateList;
        this.clx = this.ckX != null;
        this.clf = i2;
        if (this.clf == 0) {
            new TypedValue();
            this.clf = 3309506;
        }
        if (!this.clx && this.cla == null) {
            this.cla = com.baidu.poly.widget.b.fF(this.clf);
            this.clk = this.cla.getDefaultColor();
        }
        this.clg = j(f6);
        this.clh = j(f7);
        this.ckY = drawable2;
        this.ckZ = colorStateList2;
        this.cly = this.ckY != null;
        if (!this.cly && this.ckZ == null) {
            this.ckZ = com.baidu.poly.widget.b.fG(this.clf);
            this.cll = this.ckZ.getDefaultColor();
            this.clm = this.ckZ.getColorForState(ckV, this.cll);
        }
        this.clb.set(f2, f4, f3, f5);
        this.clc = this.clb.width() >= 0.0f ? Math.max(f10, 1.0f) : f10;
        this.ab = f8;
        this.apc = f9;
        this.cld = i;
        this.cle = z;
        this.clA.setDuration(this.cld);
        if (isChecked()) {
            setProgress(1.0f);
        }
    }

    private void abV() {
        ViewParent parent = getParent();
        if (parent != null) {
            parent.requestDisallowInterceptTouchEvent(true);
        }
        this.clV = true;
    }

    private int fC(int i) {
        int i2;
        int size = View.MeasureSpec.getSize(i);
        int mode = View.MeasureSpec.getMode(i);
        if (this.clg == 0 && this.clx) {
            this.clg = this.ckX.getIntrinsicWidth();
        }
        int j = j(this.clO);
        if (this.clc == 0.0f) {
            this.clc = 1.8f;
        }
        if (mode == 1073741824) {
            int paddingLeft = (size - getPaddingLeft()) - getPaddingRight();
            if (this.clg != 0) {
                int j2 = j(i2 * this.clc);
                RectF rectF = this.clb;
                int j3 = (this.clR + j) - ((j2 - this.clg) + j(Math.max(rectF.left, rectF.right)));
                float f = j2;
                RectF rectF2 = this.clb;
                this.cli = j(rectF2.right + rectF2.left + f + Math.max(j3, 0));
                if (this.cli < 0) {
                    this.clg = 0;
                }
                if (f + Math.max(this.clb.left, 0.0f) + Math.max(this.clb.right, 0.0f) + Math.max(j3, 0) > paddingLeft) {
                    this.clg = 0;
                }
            }
            if (this.clg == 0) {
                int j4 = j((((size - getPaddingLeft()) - getPaddingRight()) - Math.max(this.clb.left, 0.0f)) - Math.max(this.clb.right, 0.0f));
                if (j4 < 0) {
                    this.clg = 0;
                    this.cli = 0;
                    return size;
                }
                float f2 = j4;
                this.clg = j(f2 / this.clc);
                RectF rectF3 = this.clb;
                this.cli = j(f2 + rectF3.left + rectF3.right);
                if (this.cli < 0) {
                    this.clg = 0;
                    this.cli = 0;
                    return size;
                }
                int i3 = j + this.clR;
                int i4 = j4 - this.clg;
                RectF rectF4 = this.clb;
                int j5 = i3 - (i4 + j(Math.max(rectF4.left, rectF4.right)));
                if (j5 > 0) {
                    this.clg -= j5;
                }
                if (this.clg < 0) {
                    this.clg = 0;
                    this.cli = 0;
                    return size;
                }
                return size;
            }
            return size;
        }
        if (this.clg == 0) {
            this.clg = j(getResources().getDisplayMetrics().density * 20.0f);
        }
        if (this.clc == 0.0f) {
            this.clc = 1.8f;
        }
        int j6 = j(this.clg * this.clc);
        RectF rectF5 = this.clb;
        int j7 = j((j + this.clR) - (((j6 - this.clg) + Math.max(rectF5.left, rectF5.right)) + this.clQ));
        float f3 = j6;
        RectF rectF6 = this.clb;
        this.cli = j(rectF6.right + rectF6.left + f3 + Math.max(0, j7));
        if (this.cli < 0) {
            this.clg = 0;
            this.cli = 0;
            return size;
        }
        int j8 = j(Math.max(0.0f, this.clb.left) + f3 + Math.max(0.0f, this.clb.right) + Math.max(0, j7));
        return Math.max(j8, getPaddingLeft() + j8 + getPaddingRight());
    }

    private int fD(int i) {
        int i2;
        int i3;
        int i4;
        int size = View.MeasureSpec.getSize(i);
        int mode = View.MeasureSpec.getMode(i);
        if (this.clh == 0 && this.clx) {
            this.clh = this.ckX.getIntrinsicHeight();
        }
        if (mode == 1073741824) {
            if (this.clh != 0) {
                RectF rectF = this.clb;
                this.clj = j(i3 + rectF.top + rectF.bottom);
                this.clj = j(Math.max(this.clj, this.clP));
                if ((((this.clj + getPaddingTop()) + getPaddingBottom()) - Math.min(0.0f, this.clb.top)) - Math.min(0.0f, this.clb.bottom) > size) {
                    this.clh = 0;
                }
            }
            if (this.clh == 0) {
                this.clj = j(((size - getPaddingTop()) - getPaddingBottom()) + Math.min(0.0f, this.clb.top) + Math.min(0.0f, this.clb.bottom));
                if (this.clj < 0) {
                    this.clj = 0;
                    this.clh = 0;
                    return size;
                }
                RectF rectF2 = this.clb;
                this.clh = j((i4 - rectF2.top) - rectF2.bottom);
            }
            if (this.clh < 0) {
                this.clj = 0;
                this.clh = 0;
                return size;
            }
            return size;
        }
        if (this.clh == 0) {
            this.clh = j(getResources().getDisplayMetrics().density * 20.0f);
        }
        RectF rectF3 = this.clb;
        this.clj = j(this.clh + rectF3.top + rectF3.bottom);
        if (this.clj < 0) {
            this.clj = 0;
            this.clh = 0;
            return size;
        }
        int j = j(this.clP - i2);
        if (j > 0) {
            this.clj += j;
            this.clh = j + this.clh;
        }
        int max = Math.max(this.clh, this.clj);
        return Math.max(Math.max(max, getPaddingTop() + max + getPaddingBottom()), getSuggestedMinimumHeight());
    }

    private float getProgress() {
        return this.clB;
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
        this.clB = f;
        invalidate();
    }

    private void setup() {
        int i;
        float paddingTop;
        float paddingLeft;
        int i2 = this.clg;
        if (i2 != 0 && (i = this.clh) != 0 && this.cli != 0 && this.clj != 0) {
            if (this.ab == -1.0f) {
                this.ab = Math.min(i2, i) / 2;
            }
            if (this.apc == -1.0f) {
                this.apc = Math.min(this.cli, this.clj) / 2;
            }
            int measuredWidth = (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight();
            int measuredHeight = (getMeasuredHeight() - getPaddingTop()) - getPaddingBottom();
            int j = j((this.cli - Math.min(0.0f, this.clb.left)) - Math.min(0.0f, this.clb.right));
            int j2 = j((this.clj - Math.min(0.0f, this.clb.top)) - Math.min(0.0f, this.clb.bottom));
            if (measuredHeight <= j2) {
                paddingTop = getPaddingTop() + Math.max(0.0f, this.clb.top);
            } else {
                paddingTop = (((measuredHeight - j2) + 1) / 2) + getPaddingTop() + Math.max(0.0f, this.clb.top);
            }
            if (measuredWidth <= this.cli) {
                paddingLeft = getPaddingLeft() + Math.max(0.0f, this.clb.left);
            } else {
                paddingLeft = (((measuredWidth - j) + 1) / 2) + getPaddingLeft() + Math.max(0.0f, this.clb.left);
            }
            this.clr.set(paddingLeft, paddingTop, this.clg + paddingLeft, this.clh + paddingTop);
            RectF rectF = this.clr;
            float f = rectF.left;
            RectF rectF2 = this.clb;
            float f2 = f - rectF2.left;
            RectF rectF3 = this.cls;
            float f3 = rectF.top;
            float f4 = rectF2.top;
            rectF3.set(f2, f3 - f4, this.cli + f2, (f3 - f4) + this.clj);
            RectF rectF4 = this.clt;
            RectF rectF5 = this.clr;
            rectF4.set(rectF5.left, 0.0f, (this.cls.right - this.clb.right) - rectF5.width(), 0.0f);
            this.apc = Math.min(Math.min(this.cls.width(), this.cls.height()) / 2.0f, this.apc);
            Drawable drawable = this.ckY;
            if (drawable != null) {
                RectF rectF6 = this.cls;
                drawable.setBounds((int) rectF6.left, (int) rectF6.top, j(rectF6.right), j(this.cls.bottom));
            }
            if (this.clM != null) {
                RectF rectF7 = this.cls;
                float width = ((((((rectF7.width() + this.clQ) - this.clg) - this.clb.right) - this.clM.getWidth()) / 2.0f) + rectF7.left) - this.clS;
                RectF rectF8 = this.cls;
                float height = ((rectF8.height() - this.clM.getHeight()) / 2.0f) + rectF8.top;
                this.clu.set(width, height, this.clM.getWidth() + width, this.clM.getHeight() + height);
            }
            if (this.clN != null) {
                RectF rectF9 = this.cls;
                float width2 = ((rectF9.right - (((((rectF9.width() + this.clQ) - this.clg) - this.clb.left) - this.clN.getWidth()) / 2.0f)) - this.clN.getWidth()) + this.clS;
                RectF rectF10 = this.cls;
                float height2 = ((rectF10.height() - this.clN.getHeight()) / 2.0f) + rectF10.top;
                this.clv.set(width2, height2, this.clN.getWidth() + width2, this.clN.getHeight() + height2);
            }
            this.clU = true;
        }
    }

    protected void b(boolean z) {
        ObjectAnimator objectAnimator = this.clA;
        if (objectAnimator != null) {
            if (objectAnimator.isRunning()) {
                this.clA.cancel();
            }
            this.clA.setDuration(this.cld);
            if (z) {
                this.clA.setFloatValues(this.clB, 1.0f);
            } else {
                this.clA.setFloatValues(this.clB, 0.0f);
            }
            this.clA.start();
        }
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    protected void drawableStateChanged() {
        ColorStateList colorStateList;
        ColorStateList colorStateList2;
        super.drawableStateChanged();
        if (!this.clx && (colorStateList2 = this.cla) != null) {
            this.clk = colorStateList2.getColorForState(getDrawableState(), this.clk);
        } else {
            setDrawableState(this.ckX);
        }
        int[] iArr = isChecked() ? ckW : ckV;
        ColorStateList textColors = getTextColors();
        if (textColors != null) {
            int defaultColor = textColors.getDefaultColor();
            this.cln = textColors.getColorForState(ckV, defaultColor);
            this.clo = textColors.getColorForState(ckW, defaultColor);
        }
        if (!this.cly && (colorStateList = this.ckZ) != null) {
            this.cll = colorStateList.getColorForState(getDrawableState(), this.cll);
            this.clm = this.ckZ.getColorForState(iArr, this.cll);
            return;
        }
        Drawable drawable = this.ckY;
        if ((drawable instanceof StateListDrawable) && this.cle) {
            drawable.setState(iArr);
            this.clq = this.ckY.getCurrent().mutate();
        } else {
            this.clq = null;
        }
        setDrawableState(this.ckY);
        Drawable drawable2 = this.ckY;
        if (drawable2 != null) {
            this.clp = drawable2.getCurrent().mutate();
        }
    }

    public long getAnimationDuration() {
        return this.cld;
    }

    public ColorStateList getBackColor() {
        return this.ckZ;
    }

    public Drawable getBackDrawable() {
        return this.ckY;
    }

    public float getBackRadius() {
        return this.apc;
    }

    public PointF getBackSizeF() {
        return new PointF(this.cls.width(), this.cls.height());
    }

    public CharSequence getTextOff() {
        return this.clK;
    }

    public CharSequence getTextOn() {
        return this.clJ;
    }

    public ColorStateList getThumbColor() {
        return this.cla;
    }

    public Drawable getThumbDrawable() {
        return this.ckX;
    }

    public float getThumbHeight() {
        return this.clh;
    }

    public RectF getThumbMargin() {
        return this.clb;
    }

    public float getThumbRadius() {
        return this.ab;
    }

    public float getThumbRangeRatio() {
        return this.clc;
    }

    public float getThumbWidth() {
        return this.clg;
    }

    public int getTintColor() {
        return this.clf;
    }

    public void o() {
        if (this.clW == null) {
            toggle();
            return;
        }
        super.setOnCheckedChangeListener(null);
        toggle();
        super.setOnCheckedChangeListener(this.clW);
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (!this.clU) {
            setup();
        }
        if (this.clU) {
            if (this.cly) {
                if (this.cle && this.clp != null && this.clq != null) {
                    Drawable drawable = isChecked() ? this.clp : this.clq;
                    Drawable drawable2 = isChecked() ? this.clq : this.clp;
                    int progress = (int) (getProgress() * 255.0f);
                    drawable.setAlpha(progress);
                    drawable.draw(canvas);
                    drawable2.setAlpha(255 - progress);
                    drawable2.draw(canvas);
                } else {
                    this.ckY.setAlpha(255);
                    this.ckY.draw(canvas);
                }
            } else if (this.cle) {
                int i = isChecked() ? this.cll : this.clm;
                int i2 = isChecked() ? this.clm : this.cll;
                int progress2 = (int) (getProgress() * 255.0f);
                this.clw.setARGB((Color.alpha(i) * progress2) / 255, Color.red(i), Color.green(i), Color.blue(i));
                RectF rectF = this.cls;
                float f = this.apc;
                canvas.drawRoundRect(rectF, f, f, this.clw);
                this.clw.setARGB(((255 - progress2) * Color.alpha(i2)) / 255, Color.red(i2), Color.green(i2), Color.blue(i2));
                RectF rectF2 = this.cls;
                float f2 = this.apc;
                canvas.drawRoundRect(rectF2, f2, f2, this.clw);
                this.clw.setAlpha(255);
            } else {
                this.clw.setColor(this.cll);
                RectF rectF3 = this.cls;
                float f3 = this.apc;
                canvas.drawRoundRect(rectF3, f3, f3, this.clw);
            }
            Layout layout = ((double) getProgress()) > 0.5d ? this.clM : this.clN;
            RectF rectF4 = ((double) getProgress()) > 0.5d ? this.clu : this.clv;
            if (layout != null && rectF4 != null) {
                int progress3 = (int) ((((double) getProgress()) >= 0.75d ? (getProgress() * 4.0f) - 3.0f : ((double) getProgress()) < 0.25d ? 1.0f - (getProgress() * 4.0f) : 0.0f) * 255.0f);
                int i3 = ((double) getProgress()) > 0.5d ? this.cln : this.clo;
                layout.getPaint().setARGB((progress3 * Color.alpha(i3)) / 255, Color.red(i3), Color.green(i3), Color.blue(i3));
                canvas.save();
                canvas.translate(rectF4.left, rectF4.top);
                layout.draw(canvas);
                canvas.restore();
            }
            this.clC.set(this.clr);
            this.clC.offset(this.clB * this.clt.width(), 0.0f);
            if (this.clx) {
                Drawable drawable3 = this.ckX;
                RectF rectF5 = this.clC;
                drawable3.setBounds((int) rectF5.left, (int) rectF5.top, j(rectF5.right), j(this.clC.bottom));
                this.ckX.draw(canvas);
            } else {
                this.clw.setColor(this.clk);
                RectF rectF6 = this.clC;
                float f4 = this.ab;
                canvas.drawRoundRect(rectF6, f4, f4, this.clw);
            }
            if (this.clz) {
                this.clI.setColor(Color.parseColor("#AA0000"));
                canvas.drawRect(this.cls, this.clI);
                this.clI.setColor(Color.parseColor("#0000FF"));
                canvas.drawRect(this.clC, this.clI);
                this.clI.setColor(Color.parseColor("#000000"));
                RectF rectF7 = this.clt;
                float f5 = rectF7.left;
                float f6 = this.clr.top;
                canvas.drawLine(f5, f6, rectF7.right, f6, this.clI);
                this.clI.setColor(Color.parseColor("#00CC00"));
                canvas.drawRect(((double) getProgress()) > 0.5d ? this.clu : this.clv, this.clI);
            }
        }
    }

    @Override // android.widget.TextView, android.view.View
    protected void onMeasure(int i, int i2) {
        if (this.clM == null && !TextUtils.isEmpty(this.clJ)) {
            this.clM = e(this.clJ);
        }
        if (this.clN == null && !TextUtils.isEmpty(this.clK)) {
            this.clN = e(this.clK);
        }
        Layout layout = this.clM;
        float width = layout != null ? layout.getWidth() : 0.0f;
        Layout layout2 = this.clN;
        float width2 = layout2 != null ? layout2.getWidth() : 0.0f;
        if (width == 0.0f && width2 == 0.0f) {
            this.clO = 0.0f;
        } else {
            this.clO = Math.max(width, width2);
        }
        Layout layout3 = this.clM;
        float height = layout3 != null ? layout3.getHeight() : 0.0f;
        Layout layout4 = this.clN;
        float height2 = layout4 != null ? layout4.getHeight() : 0.0f;
        if (height == 0.0f && height2 == 0.0f) {
            this.clP = 0.0f;
        } else {
            this.clP = Math.max(height, height2);
        }
        setMeasuredDimension(fC(i), fD(i2));
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        a aVar = (a) parcelable;
        a(aVar.clX, aVar.clY);
        this.clT = true;
        super.onRestoreInstanceState(aVar.getSuperState());
        this.clT = false;
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    public Parcelable onSaveInstanceState() {
        a aVar = new a(super.onSaveInstanceState());
        aVar.clX = this.clJ;
        aVar.clY = this.clK;
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
        if (isEnabled() && isClickable() && isFocusable() && this.clU) {
            int action = motionEvent.getAction();
            float x = motionEvent.getX() - this.clD;
            float y = motionEvent.getY() - this.clE;
            switch (action) {
                case 0:
                    this.clD = motionEvent.getX();
                    this.clE = motionEvent.getY();
                    this.clF = this.clD;
                    setPressed(true);
                    break;
                case 1:
                case 3:
                    this.clV = false;
                    setPressed(false);
                    float eventTime = (float) (motionEvent.getEventTime() - motionEvent.getDownTime());
                    if (Math.abs(x) < this.clG && Math.abs(y) < this.clG && eventTime < this.clH) {
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
                    setProgress(getProgress() + ((x2 - this.clF) / this.clt.width()));
                    if (!this.clV && (Math.abs(x) > this.clG / 2 || Math.abs(y) > this.clG / 2)) {
                        if (y != 0.0f && Math.abs(x) <= Math.abs(y)) {
                            if (Math.abs(y) > Math.abs(x)) {
                                return false;
                            }
                        } else {
                            abV();
                        }
                    }
                    this.clF = x2;
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
        this.cld = j;
    }

    public void setBackColor(ColorStateList colorStateList) {
        this.ckZ = colorStateList;
        if (this.ckZ != null) {
            setBackDrawable(null);
        }
        invalidate();
    }

    public void setBackColorRes(int i) {
        setBackColor(getResources().getColorStateList(i));
    }

    public void setBackDrawable(Drawable drawable) {
        this.ckY = drawable;
        this.cly = this.ckY != null;
        refreshDrawableState();
        this.clU = false;
        requestLayout();
        invalidate();
    }

    public void setBackDrawableRes(int i) {
        setBackDrawable(getResources().getDrawable(i));
    }

    public void setBackRadius(float f) {
        this.apc = f;
        if (this.cly) {
            return;
        }
        invalidate();
    }

    @Override // android.widget.CompoundButton, android.widget.Checkable
    public void setChecked(boolean z) {
        if (isChecked() != z) {
            b(z);
        }
        if (this.clT) {
            setCheckedImmediatelyNoEvent(z);
        } else {
            super.setChecked(z);
        }
    }

    public void setCheckedImmediately(boolean z) {
        super.setChecked(z);
        ObjectAnimator objectAnimator = this.clA;
        if (objectAnimator != null && objectAnimator.isRunning()) {
            this.clA.cancel();
        }
        setProgress(z ? 1.0f : 0.0f);
        invalidate();
    }

    public void setCheckedImmediatelyNoEvent(boolean z) {
        if (this.clW == null) {
            setCheckedImmediately(z);
            return;
        }
        super.setOnCheckedChangeListener(null);
        setCheckedImmediately(z);
        super.setOnCheckedChangeListener(this.clW);
    }

    public void setCheckedNoEvent(boolean z) {
        if (this.clW == null) {
            setChecked(z);
            return;
        }
        super.setOnCheckedChangeListener(null);
        setChecked(z);
        super.setOnCheckedChangeListener(this.clW);
    }

    public void setDrawDebugRect(boolean z) {
        this.clz = z;
        invalidate();
    }

    public void setFadeBack(boolean z) {
        this.cle = z;
    }

    @Override // android.widget.CompoundButton
    public void setOnCheckedChangeListener(CompoundButton.OnCheckedChangeListener onCheckedChangeListener) {
        super.setOnCheckedChangeListener(onCheckedChangeListener);
        this.clW = onCheckedChangeListener;
    }

    public void setTextAdjust(int i) {
        this.clS = i;
        this.clU = false;
        requestLayout();
        invalidate();
    }

    public void setTextExtra(int i) {
        this.clR = i;
        this.clU = false;
        requestLayout();
        invalidate();
    }

    public void setTextThumbInset(int i) {
        this.clQ = i;
        this.clU = false;
        requestLayout();
        invalidate();
    }

    public void setThumbColor(ColorStateList colorStateList) {
        this.cla = colorStateList;
        if (this.cla != null) {
            setThumbDrawable(null);
        }
        invalidate();
    }

    public void setThumbColorRes(int i) {
        setThumbColor(getResources().getColorStateList(i));
    }

    public void setThumbDrawable(Drawable drawable) {
        this.ckX = drawable;
        this.clx = this.ckX != null;
        refreshDrawableState();
        this.clU = false;
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
        if (this.clx) {
            return;
        }
        invalidate();
    }

    public void setThumbRangeRatio(float f) {
        this.clc = f;
        this.clU = false;
        requestLayout();
    }

    public void setTintColor(int i) {
        this.clf = i;
        this.cla = com.baidu.poly.widget.b.fF(this.clf);
        this.ckZ = com.baidu.poly.widget.b.fG(this.clf);
        this.cly = false;
        this.clx = false;
        refreshDrawableState();
        invalidate();
    }

    public SwitchButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.clz = false;
        this.clT = false;
        this.clU = false;
        this.clV = false;
        a(attributeSet);
    }

    public SwitchButton(Context context) {
        super(context);
        this.clz = false;
        this.clT = false;
        this.clU = false;
        this.clV = false;
        a(null);
    }

    private Layout e(CharSequence charSequence) {
        TextPaint textPaint = this.clL;
        return new StaticLayout(charSequence, textPaint, (int) Math.ceil(Layout.getDesiredWidth(charSequence, textPaint)), Layout.Alignment.ALIGN_CENTER, 1.0f, 0.0f, false);
    }

    public void a(float f, float f2, float f3, float f4) {
        this.clb.set(f, f2, f3, f4);
        this.clU = false;
        requestLayout();
    }

    public void a(CharSequence charSequence, CharSequence charSequence2) {
        this.clJ = charSequence;
        this.clK = charSequence2;
        this.clM = null;
        this.clN = null;
        this.clU = false;
        requestLayout();
        invalidate();
    }
}
