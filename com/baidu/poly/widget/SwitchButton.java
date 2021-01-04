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
    private static int[] cpL = {16842912, 16842910, 16842919};
    private static int[] cpM = {-16842912, 16842910, 16842919};
    private float ab;
    private float apR;
    private Drawable cpN;
    private Drawable cpO;
    private ColorStateList cpP;
    private ColorStateList cpQ;
    private RectF cpR;
    private float cpS;
    private long cpT;
    private boolean cpU;
    private int cpV;
    private int cpW;
    private int cpX;
    private int cpY;
    private int cpZ;
    private CharSequence cqA;
    private TextPaint cqB;
    private Layout cqC;
    private Layout cqD;
    private float cqE;
    private float cqF;
    private int cqG;
    private int cqH;
    private int cqI;
    private boolean cqJ;
    private boolean cqK;
    private boolean cqL;
    private CompoundButton.OnCheckedChangeListener cqM;
    private int cqa;
    private int cqb;
    private int cqc;
    private int cqd;
    private int cqe;
    private Drawable cqf;
    private Drawable cqg;
    private RectF cqh;
    private RectF cqi;
    private RectF cqj;
    private RectF cqk;
    private RectF cql;
    private Paint cqm;
    private boolean cqn;
    private boolean cqo;
    private boolean cqp;
    private ObjectAnimator cqq;
    private float cqr;
    private RectF cqs;
    private float cqt;
    private float cqu;
    private float cqv;
    private int cqw;
    private int cqx;
    private Paint cqy;
    private CharSequence cqz;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public static class a extends View.BaseSavedState {
        public static final Parcelable.Creator<a> CREATOR = new C0322a();
        CharSequence cqN;
        CharSequence cqO;

        /* renamed from: com.baidu.poly.widget.SwitchButton$a$a  reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        static class C0322a implements Parcelable.Creator<a> {
            C0322a() {
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // android.os.Parcelable.Creator
            /* renamed from: hp */
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
            TextUtils.writeToParcel(this.cqN, parcel, i);
            TextUtils.writeToParcel(this.cqO, parcel, i);
        }

        a(Parcelable parcelable) {
            super(parcelable);
        }

        private a(Parcel parcel) {
            super(parcel);
            this.cqN = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
            this.cqO = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
        }
    }

    public SwitchButton(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.cqp = false;
        this.cqJ = false;
        this.cqK = false;
        this.cqL = false;
        a(attributeSet);
    }

    private void a(AttributeSet attributeSet) {
        this.cqw = ViewConfiguration.get(getContext()).getScaledTouchSlop();
        this.cqx = ViewConfiguration.getPressedStateDuration() + ViewConfiguration.getTapTimeout();
        this.cqm = new Paint(1);
        this.cqy = new Paint(1);
        this.cqy.setStyle(Paint.Style.STROKE);
        this.cqy.setStrokeWidth(getResources().getDisplayMetrics().density);
        this.cqB = getPaint();
        this.cqh = new RectF();
        this.cqi = new RectF();
        this.cqj = new RectF();
        this.cpR = new RectF();
        this.cqk = new RectF();
        this.cql = new RectF();
        this.cqq = ObjectAnimator.ofFloat(this, "progress", 0.0f, 0.0f).setDuration(250L);
        this.cqq.setInterpolator(new AccelerateDecelerateInterpolator());
        this.cqs = new RectF();
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
        this.cqz = str;
        this.cqA = str2;
        this.cqG = i3;
        this.cqH = i4;
        this.cqI = i6;
        this.cpN = drawable;
        this.cpQ = colorStateList;
        this.cqn = this.cpN != null;
        this.cpV = i2;
        if (this.cpV == 0) {
            new TypedValue();
            this.cpV = 3309506;
        }
        if (!this.cqn && this.cpQ == null) {
            this.cpQ = com.baidu.poly.widget.b.hm(this.cpV);
            this.cqa = this.cpQ.getDefaultColor();
        }
        this.cpW = p(f6);
        this.cpX = p(f7);
        this.cpO = drawable2;
        this.cpP = colorStateList2;
        this.cqo = this.cpO != null;
        if (!this.cqo && this.cpP == null) {
            this.cpP = com.baidu.poly.widget.b.hn(this.cpV);
            this.cqb = this.cpP.getDefaultColor();
            this.cqc = this.cpP.getColorForState(cpL, this.cqb);
        }
        this.cpR.set(f2, f4, f3, f5);
        this.cpS = this.cpR.width() >= 0.0f ? Math.max(f10, 1.0f) : f10;
        this.ab = f8;
        this.apR = f9;
        this.cpT = i;
        this.cpU = z;
        this.cqq.setDuration(this.cpT);
        if (isChecked()) {
            setProgress(1.0f);
        }
    }

    private void afO() {
        ViewParent parent = getParent();
        if (parent != null) {
            parent.requestDisallowInterceptTouchEvent(true);
        }
        this.cqL = true;
    }

    private float getProgress() {
        return this.cqr;
    }

    private boolean getStatusBasedOnPos() {
        return getProgress() > 0.5f;
    }

    private int hj(int i) {
        int i2;
        int size = View.MeasureSpec.getSize(i);
        int mode = View.MeasureSpec.getMode(i);
        if (this.cpW == 0 && this.cqn) {
            this.cpW = this.cpN.getIntrinsicWidth();
        }
        int p = p(this.cqE);
        if (this.cpS == 0.0f) {
            this.cpS = 1.8f;
        }
        if (mode == 1073741824) {
            int paddingLeft = (size - getPaddingLeft()) - getPaddingRight();
            if (this.cpW != 0) {
                int p2 = p(i2 * this.cpS);
                RectF rectF = this.cpR;
                int p3 = (this.cqH + p) - ((p2 - this.cpW) + p(Math.max(rectF.left, rectF.right)));
                float f = p2;
                RectF rectF2 = this.cpR;
                this.cpY = p(rectF2.right + rectF2.left + f + Math.max(p3, 0));
                if (this.cpY < 0) {
                    this.cpW = 0;
                }
                if (f + Math.max(this.cpR.left, 0.0f) + Math.max(this.cpR.right, 0.0f) + Math.max(p3, 0) > paddingLeft) {
                    this.cpW = 0;
                }
            }
            if (this.cpW == 0) {
                int p4 = p((((size - getPaddingLeft()) - getPaddingRight()) - Math.max(this.cpR.left, 0.0f)) - Math.max(this.cpR.right, 0.0f));
                if (p4 < 0) {
                    this.cpW = 0;
                    this.cpY = 0;
                    return size;
                }
                float f2 = p4;
                this.cpW = p(f2 / this.cpS);
                RectF rectF3 = this.cpR;
                this.cpY = p(f2 + rectF3.left + rectF3.right);
                if (this.cpY < 0) {
                    this.cpW = 0;
                    this.cpY = 0;
                    return size;
                }
                int i3 = p + this.cqH;
                int i4 = p4 - this.cpW;
                RectF rectF4 = this.cpR;
                int p5 = i3 - (i4 + p(Math.max(rectF4.left, rectF4.right)));
                if (p5 > 0) {
                    this.cpW -= p5;
                }
                if (this.cpW < 0) {
                    this.cpW = 0;
                    this.cpY = 0;
                    return size;
                }
                return size;
            }
            return size;
        }
        if (this.cpW == 0) {
            this.cpW = p(getResources().getDisplayMetrics().density * 20.0f);
        }
        if (this.cpS == 0.0f) {
            this.cpS = 1.8f;
        }
        int p6 = p(this.cpW * this.cpS);
        RectF rectF5 = this.cpR;
        int p7 = p((p + this.cqH) - (((p6 - this.cpW) + Math.max(rectF5.left, rectF5.right)) + this.cqG));
        float f3 = p6;
        RectF rectF6 = this.cpR;
        this.cpY = p(rectF6.right + rectF6.left + f3 + Math.max(0, p7));
        if (this.cpY < 0) {
            this.cpW = 0;
            this.cpY = 0;
            return size;
        }
        int p8 = p(Math.max(0.0f, this.cpR.left) + f3 + Math.max(0.0f, this.cpR.right) + Math.max(0, p7));
        return Math.max(p8, getPaddingLeft() + p8 + getPaddingRight());
    }

    private int hk(int i) {
        int i2;
        int i3;
        int i4;
        int size = View.MeasureSpec.getSize(i);
        int mode = View.MeasureSpec.getMode(i);
        if (this.cpX == 0 && this.cqn) {
            this.cpX = this.cpN.getIntrinsicHeight();
        }
        if (mode == 1073741824) {
            if (this.cpX != 0) {
                RectF rectF = this.cpR;
                this.cpZ = p(i3 + rectF.top + rectF.bottom);
                this.cpZ = p(Math.max(this.cpZ, this.cqF));
                if ((((this.cpZ + getPaddingTop()) + getPaddingBottom()) - Math.min(0.0f, this.cpR.top)) - Math.min(0.0f, this.cpR.bottom) > size) {
                    this.cpX = 0;
                }
            }
            if (this.cpX == 0) {
                this.cpZ = p(((size - getPaddingTop()) - getPaddingBottom()) + Math.min(0.0f, this.cpR.top) + Math.min(0.0f, this.cpR.bottom));
                if (this.cpZ < 0) {
                    this.cpZ = 0;
                    this.cpX = 0;
                    return size;
                }
                RectF rectF2 = this.cpR;
                this.cpX = p((i4 - rectF2.top) - rectF2.bottom);
            }
            if (this.cpX < 0) {
                this.cpZ = 0;
                this.cpX = 0;
                return size;
            }
            return size;
        }
        if (this.cpX == 0) {
            this.cpX = p(getResources().getDisplayMetrics().density * 20.0f);
        }
        RectF rectF3 = this.cpR;
        this.cpZ = p(this.cpX + rectF3.top + rectF3.bottom);
        if (this.cpZ < 0) {
            this.cpZ = 0;
            this.cpX = 0;
            return size;
        }
        int p = p(this.cqF - i2);
        if (p > 0) {
            this.cpZ += p;
            this.cpX = p + this.cpX;
        }
        int max = Math.max(this.cpX, this.cpZ);
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
        this.cqr = f;
        invalidate();
    }

    private void setup() {
        int i;
        float paddingTop;
        float paddingLeft;
        int i2 = this.cpW;
        if (i2 != 0 && (i = this.cpX) != 0 && this.cpY != 0 && this.cpZ != 0) {
            if (this.ab == -1.0f) {
                this.ab = Math.min(i2, i) / 2;
            }
            if (this.apR == -1.0f) {
                this.apR = Math.min(this.cpY, this.cpZ) / 2;
            }
            int measuredWidth = (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight();
            int measuredHeight = (getMeasuredHeight() - getPaddingTop()) - getPaddingBottom();
            int p = p((this.cpY - Math.min(0.0f, this.cpR.left)) - Math.min(0.0f, this.cpR.right));
            int p2 = p((this.cpZ - Math.min(0.0f, this.cpR.top)) - Math.min(0.0f, this.cpR.bottom));
            if (measuredHeight <= p2) {
                paddingTop = getPaddingTop() + Math.max(0.0f, this.cpR.top);
            } else {
                paddingTop = (((measuredHeight - p2) + 1) / 2) + getPaddingTop() + Math.max(0.0f, this.cpR.top);
            }
            if (measuredWidth <= this.cpY) {
                paddingLeft = getPaddingLeft() + Math.max(0.0f, this.cpR.left);
            } else {
                paddingLeft = (((measuredWidth - p) + 1) / 2) + getPaddingLeft() + Math.max(0.0f, this.cpR.left);
            }
            this.cqh.set(paddingLeft, paddingTop, this.cpW + paddingLeft, this.cpX + paddingTop);
            RectF rectF = this.cqh;
            float f = rectF.left;
            RectF rectF2 = this.cpR;
            float f2 = f - rectF2.left;
            RectF rectF3 = this.cqi;
            float f3 = rectF.top;
            float f4 = rectF2.top;
            rectF3.set(f2, f3 - f4, this.cpY + f2, (f3 - f4) + this.cpZ);
            RectF rectF4 = this.cqj;
            RectF rectF5 = this.cqh;
            rectF4.set(rectF5.left, 0.0f, (this.cqi.right - this.cpR.right) - rectF5.width(), 0.0f);
            this.apR = Math.min(Math.min(this.cqi.width(), this.cqi.height()) / 2.0f, this.apR);
            Drawable drawable = this.cpO;
            if (drawable != null) {
                RectF rectF6 = this.cqi;
                drawable.setBounds((int) rectF6.left, (int) rectF6.top, p(rectF6.right), p(this.cqi.bottom));
            }
            if (this.cqC != null) {
                RectF rectF7 = this.cqi;
                float width = ((((((rectF7.width() + this.cqG) - this.cpW) - this.cpR.right) - this.cqC.getWidth()) / 2.0f) + rectF7.left) - this.cqI;
                RectF rectF8 = this.cqi;
                float height = ((rectF8.height() - this.cqC.getHeight()) / 2.0f) + rectF8.top;
                this.cqk.set(width, height, this.cqC.getWidth() + width, this.cqC.getHeight() + height);
            }
            if (this.cqD != null) {
                RectF rectF9 = this.cqi;
                float width2 = ((rectF9.right - (((((rectF9.width() + this.cqG) - this.cpW) - this.cpR.left) - this.cqD.getWidth()) / 2.0f)) - this.cqD.getWidth()) + this.cqI;
                RectF rectF10 = this.cqi;
                float height2 = ((rectF10.height() - this.cqD.getHeight()) / 2.0f) + rectF10.top;
                this.cql.set(width2, height2, this.cqD.getWidth() + width2, this.cqD.getHeight() + height2);
            }
            this.cqK = true;
        }
    }

    protected void b(boolean z) {
        ObjectAnimator objectAnimator = this.cqq;
        if (objectAnimator != null) {
            if (objectAnimator.isRunning()) {
                this.cqq.cancel();
            }
            this.cqq.setDuration(this.cpT);
            if (z) {
                this.cqq.setFloatValues(this.cqr, 1.0f);
            } else {
                this.cqq.setFloatValues(this.cqr, 0.0f);
            }
            this.cqq.start();
        }
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    protected void drawableStateChanged() {
        ColorStateList colorStateList;
        ColorStateList colorStateList2;
        super.drawableStateChanged();
        if (!this.cqn && (colorStateList2 = this.cpQ) != null) {
            this.cqa = colorStateList2.getColorForState(getDrawableState(), this.cqa);
        } else {
            setDrawableState(this.cpN);
        }
        int[] iArr = isChecked() ? cpM : cpL;
        ColorStateList textColors = getTextColors();
        if (textColors != null) {
            int defaultColor = textColors.getDefaultColor();
            this.cqd = textColors.getColorForState(cpL, defaultColor);
            this.cqe = textColors.getColorForState(cpM, defaultColor);
        }
        if (!this.cqo && (colorStateList = this.cpP) != null) {
            this.cqb = colorStateList.getColorForState(getDrawableState(), this.cqb);
            this.cqc = this.cpP.getColorForState(iArr, this.cqb);
            return;
        }
        Drawable drawable = this.cpO;
        if ((drawable instanceof StateListDrawable) && this.cpU) {
            drawable.setState(iArr);
            this.cqg = this.cpO.getCurrent().mutate();
        } else {
            this.cqg = null;
        }
        setDrawableState(this.cpO);
        Drawable drawable2 = this.cpO;
        if (drawable2 != null) {
            this.cqf = drawable2.getCurrent().mutate();
        }
    }

    public long getAnimationDuration() {
        return this.cpT;
    }

    public ColorStateList getBackColor() {
        return this.cpP;
    }

    public Drawable getBackDrawable() {
        return this.cpO;
    }

    public float getBackRadius() {
        return this.apR;
    }

    public PointF getBackSizeF() {
        return new PointF(this.cqi.width(), this.cqi.height());
    }

    public CharSequence getTextOff() {
        return this.cqA;
    }

    public CharSequence getTextOn() {
        return this.cqz;
    }

    public ColorStateList getThumbColor() {
        return this.cpQ;
    }

    public Drawable getThumbDrawable() {
        return this.cpN;
    }

    public float getThumbHeight() {
        return this.cpX;
    }

    public RectF getThumbMargin() {
        return this.cpR;
    }

    public float getThumbRadius() {
        return this.ab;
    }

    public float getThumbRangeRatio() {
        return this.cpS;
    }

    public float getThumbWidth() {
        return this.cpW;
    }

    public int getTintColor() {
        return this.cpV;
    }

    public void o() {
        if (this.cqM == null) {
            toggle();
            return;
        }
        super.setOnCheckedChangeListener(null);
        toggle();
        super.setOnCheckedChangeListener(this.cqM);
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (!this.cqK) {
            setup();
        }
        if (this.cqK) {
            if (this.cqo) {
                if (this.cpU && this.cqf != null && this.cqg != null) {
                    Drawable drawable = isChecked() ? this.cqf : this.cqg;
                    Drawable drawable2 = isChecked() ? this.cqg : this.cqf;
                    int progress = (int) (getProgress() * 255.0f);
                    drawable.setAlpha(progress);
                    drawable.draw(canvas);
                    drawable2.setAlpha(255 - progress);
                    drawable2.draw(canvas);
                } else {
                    this.cpO.setAlpha(255);
                    this.cpO.draw(canvas);
                }
            } else if (this.cpU) {
                int i = isChecked() ? this.cqb : this.cqc;
                int i2 = isChecked() ? this.cqc : this.cqb;
                int progress2 = (int) (getProgress() * 255.0f);
                this.cqm.setARGB((Color.alpha(i) * progress2) / 255, Color.red(i), Color.green(i), Color.blue(i));
                RectF rectF = this.cqi;
                float f = this.apR;
                canvas.drawRoundRect(rectF, f, f, this.cqm);
                this.cqm.setARGB(((255 - progress2) * Color.alpha(i2)) / 255, Color.red(i2), Color.green(i2), Color.blue(i2));
                RectF rectF2 = this.cqi;
                float f2 = this.apR;
                canvas.drawRoundRect(rectF2, f2, f2, this.cqm);
                this.cqm.setAlpha(255);
            } else {
                this.cqm.setColor(this.cqb);
                RectF rectF3 = this.cqi;
                float f3 = this.apR;
                canvas.drawRoundRect(rectF3, f3, f3, this.cqm);
            }
            Layout layout = ((double) getProgress()) > 0.5d ? this.cqC : this.cqD;
            RectF rectF4 = ((double) getProgress()) > 0.5d ? this.cqk : this.cql;
            if (layout != null && rectF4 != null) {
                int progress3 = (int) ((((double) getProgress()) >= 0.75d ? (getProgress() * 4.0f) - 3.0f : ((double) getProgress()) < 0.25d ? 1.0f - (getProgress() * 4.0f) : 0.0f) * 255.0f);
                int i3 = ((double) getProgress()) > 0.5d ? this.cqd : this.cqe;
                layout.getPaint().setARGB((progress3 * Color.alpha(i3)) / 255, Color.red(i3), Color.green(i3), Color.blue(i3));
                canvas.save();
                canvas.translate(rectF4.left, rectF4.top);
                layout.draw(canvas);
                canvas.restore();
            }
            this.cqs.set(this.cqh);
            this.cqs.offset(this.cqr * this.cqj.width(), 0.0f);
            if (this.cqn) {
                Drawable drawable3 = this.cpN;
                RectF rectF5 = this.cqs;
                drawable3.setBounds((int) rectF5.left, (int) rectF5.top, p(rectF5.right), p(this.cqs.bottom));
                this.cpN.draw(canvas);
            } else {
                this.cqm.setColor(this.cqa);
                RectF rectF6 = this.cqs;
                float f4 = this.ab;
                canvas.drawRoundRect(rectF6, f4, f4, this.cqm);
            }
            if (this.cqp) {
                this.cqy.setColor(Color.parseColor("#AA0000"));
                canvas.drawRect(this.cqi, this.cqy);
                this.cqy.setColor(Color.parseColor("#0000FF"));
                canvas.drawRect(this.cqs, this.cqy);
                this.cqy.setColor(Color.parseColor("#000000"));
                RectF rectF7 = this.cqj;
                float f5 = rectF7.left;
                float f6 = this.cqh.top;
                canvas.drawLine(f5, f6, rectF7.right, f6, this.cqy);
                this.cqy.setColor(Color.parseColor("#00CC00"));
                canvas.drawRect(((double) getProgress()) > 0.5d ? this.cqk : this.cql, this.cqy);
            }
        }
    }

    @Override // android.widget.TextView, android.view.View
    protected void onMeasure(int i, int i2) {
        if (this.cqC == null && !TextUtils.isEmpty(this.cqz)) {
            this.cqC = e(this.cqz);
        }
        if (this.cqD == null && !TextUtils.isEmpty(this.cqA)) {
            this.cqD = e(this.cqA);
        }
        Layout layout = this.cqC;
        float width = layout != null ? layout.getWidth() : 0.0f;
        Layout layout2 = this.cqD;
        float width2 = layout2 != null ? layout2.getWidth() : 0.0f;
        if (width == 0.0f && width2 == 0.0f) {
            this.cqE = 0.0f;
        } else {
            this.cqE = Math.max(width, width2);
        }
        Layout layout3 = this.cqC;
        float height = layout3 != null ? layout3.getHeight() : 0.0f;
        Layout layout4 = this.cqD;
        float height2 = layout4 != null ? layout4.getHeight() : 0.0f;
        if (height == 0.0f && height2 == 0.0f) {
            this.cqF = 0.0f;
        } else {
            this.cqF = Math.max(height, height2);
        }
        setMeasuredDimension(hj(i), hk(i2));
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        a aVar = (a) parcelable;
        a(aVar.cqN, aVar.cqO);
        this.cqJ = true;
        super.onRestoreInstanceState(aVar.getSuperState());
        this.cqJ = false;
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    public Parcelable onSaveInstanceState() {
        a aVar = new a(super.onSaveInstanceState());
        aVar.cqN = this.cqz;
        aVar.cqO = this.cqA;
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
        if (isEnabled() && isClickable() && isFocusable() && this.cqK) {
            int action = motionEvent.getAction();
            float x = motionEvent.getX() - this.cqt;
            float y = motionEvent.getY() - this.cqu;
            switch (action) {
                case 0:
                    this.cqt = motionEvent.getX();
                    this.cqu = motionEvent.getY();
                    this.cqv = this.cqt;
                    setPressed(true);
                    break;
                case 1:
                case 3:
                    this.cqL = false;
                    setPressed(false);
                    float eventTime = (float) (motionEvent.getEventTime() - motionEvent.getDownTime());
                    if (Math.abs(x) < this.cqw && Math.abs(y) < this.cqw && eventTime < this.cqx) {
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
                    setProgress(getProgress() + ((x2 - this.cqv) / this.cqj.width()));
                    if (!this.cqL && (Math.abs(x) > this.cqw / 2 || Math.abs(y) > this.cqw / 2)) {
                        if (y != 0.0f && Math.abs(x) <= Math.abs(y)) {
                            if (Math.abs(y) > Math.abs(x)) {
                                return false;
                            }
                        } else {
                            afO();
                        }
                    }
                    this.cqv = x2;
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
        this.cpT = j;
    }

    public void setBackColor(ColorStateList colorStateList) {
        this.cpP = colorStateList;
        if (this.cpP != null) {
            setBackDrawable(null);
        }
        invalidate();
    }

    public void setBackColorRes(int i) {
        setBackColor(getResources().getColorStateList(i));
    }

    public void setBackDrawable(Drawable drawable) {
        this.cpO = drawable;
        this.cqo = this.cpO != null;
        refreshDrawableState();
        this.cqK = false;
        requestLayout();
        invalidate();
    }

    public void setBackDrawableRes(int i) {
        setBackDrawable(getResources().getDrawable(i));
    }

    public void setBackRadius(float f) {
        this.apR = f;
        if (this.cqo) {
            return;
        }
        invalidate();
    }

    @Override // android.widget.CompoundButton, android.widget.Checkable
    public void setChecked(boolean z) {
        if (isChecked() != z) {
            b(z);
        }
        if (this.cqJ) {
            setCheckedImmediatelyNoEvent(z);
        } else {
            super.setChecked(z);
        }
    }

    public void setCheckedImmediately(boolean z) {
        super.setChecked(z);
        ObjectAnimator objectAnimator = this.cqq;
        if (objectAnimator != null && objectAnimator.isRunning()) {
            this.cqq.cancel();
        }
        setProgress(z ? 1.0f : 0.0f);
        invalidate();
    }

    public void setCheckedImmediatelyNoEvent(boolean z) {
        if (this.cqM == null) {
            setCheckedImmediately(z);
            return;
        }
        super.setOnCheckedChangeListener(null);
        setCheckedImmediately(z);
        super.setOnCheckedChangeListener(this.cqM);
    }

    public void setCheckedNoEvent(boolean z) {
        if (this.cqM == null) {
            setChecked(z);
            return;
        }
        super.setOnCheckedChangeListener(null);
        setChecked(z);
        super.setOnCheckedChangeListener(this.cqM);
    }

    public void setDrawDebugRect(boolean z) {
        this.cqp = z;
        invalidate();
    }

    public void setFadeBack(boolean z) {
        this.cpU = z;
    }

    @Override // android.widget.CompoundButton
    public void setOnCheckedChangeListener(CompoundButton.OnCheckedChangeListener onCheckedChangeListener) {
        super.setOnCheckedChangeListener(onCheckedChangeListener);
        this.cqM = onCheckedChangeListener;
    }

    public void setTextAdjust(int i) {
        this.cqI = i;
        this.cqK = false;
        requestLayout();
        invalidate();
    }

    public void setTextExtra(int i) {
        this.cqH = i;
        this.cqK = false;
        requestLayout();
        invalidate();
    }

    public void setTextThumbInset(int i) {
        this.cqG = i;
        this.cqK = false;
        requestLayout();
        invalidate();
    }

    public void setThumbColor(ColorStateList colorStateList) {
        this.cpQ = colorStateList;
        if (this.cpQ != null) {
            setThumbDrawable(null);
        }
        invalidate();
    }

    public void setThumbColorRes(int i) {
        setThumbColor(getResources().getColorStateList(i));
    }

    public void setThumbDrawable(Drawable drawable) {
        this.cpN = drawable;
        this.cqn = this.cpN != null;
        refreshDrawableState();
        this.cqK = false;
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
        if (this.cqn) {
            return;
        }
        invalidate();
    }

    public void setThumbRangeRatio(float f) {
        this.cpS = f;
        this.cqK = false;
        requestLayout();
    }

    public void setTintColor(int i) {
        this.cpV = i;
        this.cpQ = com.baidu.poly.widget.b.hm(this.cpV);
        this.cpP = com.baidu.poly.widget.b.hn(this.cpV);
        this.cqo = false;
        this.cqn = false;
        refreshDrawableState();
        invalidate();
    }

    public SwitchButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.cqp = false;
        this.cqJ = false;
        this.cqK = false;
        this.cqL = false;
        a(attributeSet);
    }

    public SwitchButton(Context context) {
        super(context);
        this.cqp = false;
        this.cqJ = false;
        this.cqK = false;
        this.cqL = false;
        a(null);
    }

    private Layout e(CharSequence charSequence) {
        TextPaint textPaint = this.cqB;
        return new StaticLayout(charSequence, textPaint, (int) Math.ceil(Layout.getDesiredWidth(charSequence, textPaint)), Layout.Alignment.ALIGN_CENTER, 1.0f, 0.0f, false);
    }

    public void a(float f, float f2, float f3, float f4) {
        this.cpR.set(f, f2, f3, f4);
        this.cqK = false;
        requestLayout();
    }

    public void a(CharSequence charSequence, CharSequence charSequence2) {
        this.cqz = charSequence;
        this.cqA = charSequence2;
        this.cqC = null;
        this.cqD = null;
        this.cqK = false;
        requestLayout();
        invalidate();
    }
}
