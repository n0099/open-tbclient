package android.support.v7.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.support.v4.graphics.drawable.DrawableCompat;
import android.support.v4.view.MotionEventCompat;
import android.support.v4.view.ViewCompat;
import android.support.v7.appcompat.R;
import android.support.v7.content.res.AppCompatResources;
import android.support.v7.text.AllCapsTransformationMethod;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.method.TransformationMethod;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.ViewConfiguration;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.animation.Animation;
import android.view.animation.Transformation;
import android.widget.CompoundButton;
/* loaded from: classes2.dex */
public class SwitchCompat extends CompoundButton {
    private static final int[] jn = {16842912};
    private int RR;
    private CharSequence WA;
    private boolean WB;
    private float WC;
    private float WD;
    private float WE;
    private int WF;
    private int WG;
    private int WH;
    private int WI;
    private int WJ;
    private int WK;
    private int WL;
    private ColorStateList WM;
    private Layout WN;
    private Layout WO;
    private TransformationMethod WP;
    a WQ;
    private Drawable Wl;
    private ColorStateList Wm;
    private PorterDuff.Mode Wn;
    private boolean Wo;
    private boolean Wp;
    private Drawable Wq;
    private ColorStateList Wr;
    private PorterDuff.Mode Ws;
    private boolean Wt;
    private boolean Wu;
    private int Wv;
    private int Ww;
    private int Wx;
    private boolean Wy;
    private CharSequence Wz;
    private TextPaint mJ;
    private final Rect mTempRect;
    private int mTouchMode;
    private int mTouchSlop;
    private VelocityTracker mVelocityTracker;

    public SwitchCompat(Context context) {
        this(context, null);
    }

    public SwitchCompat(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.switchStyle);
    }

    public SwitchCompat(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.Wm = null;
        this.Wn = null;
        this.Wo = false;
        this.Wp = false;
        this.Wr = null;
        this.Ws = null;
        this.Wt = false;
        this.Wu = false;
        this.mVelocityTracker = VelocityTracker.obtain();
        this.mTempRect = new Rect();
        this.mJ = new TextPaint(1);
        Resources resources = getResources();
        this.mJ.density = resources.getDisplayMetrics().density;
        TintTypedArray obtainStyledAttributes = TintTypedArray.obtainStyledAttributes(context, attributeSet, R.styleable.SwitchCompat, i, 0);
        this.Wl = obtainStyledAttributes.getDrawable(R.styleable.SwitchCompat_android_thumb);
        if (this.Wl != null) {
            this.Wl.setCallback(this);
        }
        this.Wq = obtainStyledAttributes.getDrawable(R.styleable.SwitchCompat_track);
        if (this.Wq != null) {
            this.Wq.setCallback(this);
        }
        this.Wz = obtainStyledAttributes.getText(R.styleable.SwitchCompat_android_textOn);
        this.WA = obtainStyledAttributes.getText(R.styleable.SwitchCompat_android_textOff);
        this.WB = obtainStyledAttributes.getBoolean(R.styleable.SwitchCompat_showText, true);
        this.Wv = obtainStyledAttributes.getDimensionPixelSize(R.styleable.SwitchCompat_thumbTextPadding, 0);
        this.Ww = obtainStyledAttributes.getDimensionPixelSize(R.styleable.SwitchCompat_switchMinWidth, 0);
        this.Wx = obtainStyledAttributes.getDimensionPixelSize(R.styleable.SwitchCompat_switchPadding, 0);
        this.Wy = obtainStyledAttributes.getBoolean(R.styleable.SwitchCompat_splitTrack, false);
        ColorStateList colorStateList = obtainStyledAttributes.getColorStateList(R.styleable.SwitchCompat_thumbTint);
        if (colorStateList != null) {
            this.Wm = colorStateList;
            this.Wo = true;
        }
        PorterDuff.Mode a2 = DrawableUtils.a(obtainStyledAttributes.getInt(R.styleable.SwitchCompat_thumbTintMode, -1), null);
        if (this.Wn != a2) {
            this.Wn = a2;
            this.Wp = true;
        }
        if (this.Wo || this.Wp) {
            in();
        }
        ColorStateList colorStateList2 = obtainStyledAttributes.getColorStateList(R.styleable.SwitchCompat_trackTint);
        if (colorStateList2 != null) {
            this.Wr = colorStateList2;
            this.Wt = true;
        }
        PorterDuff.Mode a3 = DrawableUtils.a(obtainStyledAttributes.getInt(R.styleable.SwitchCompat_trackTintMode, -1), null);
        if (this.Ws != a3) {
            this.Ws = a3;
            this.Wu = true;
        }
        if (this.Wt || this.Wu) {
            im();
        }
        int resourceId = obtainStyledAttributes.getResourceId(R.styleable.SwitchCompat_switchTextAppearance, 0);
        if (resourceId != 0) {
            setSwitchTextAppearance(context, resourceId);
        }
        obtainStyledAttributes.recycle();
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        this.mTouchSlop = viewConfiguration.getScaledTouchSlop();
        this.RR = viewConfiguration.getScaledMinimumFlingVelocity();
        refreshDrawableState();
        setChecked(isChecked());
    }

    public void setSwitchTextAppearance(Context context, int i) {
        TintTypedArray obtainStyledAttributes = TintTypedArray.obtainStyledAttributes(context, i, R.styleable.TextAppearance);
        ColorStateList colorStateList = obtainStyledAttributes.getColorStateList(R.styleable.TextAppearance_android_textColor);
        if (colorStateList != null) {
            this.WM = colorStateList;
        } else {
            this.WM = getTextColors();
        }
        int dimensionPixelSize = obtainStyledAttributes.getDimensionPixelSize(R.styleable.TextAppearance_android_textSize, 0);
        if (dimensionPixelSize != 0 && dimensionPixelSize != this.mJ.getTextSize()) {
            this.mJ.setTextSize(dimensionPixelSize);
            requestLayout();
        }
        ak(obtainStyledAttributes.getInt(R.styleable.TextAppearance_android_typeface, -1), obtainStyledAttributes.getInt(R.styleable.TextAppearance_android_textStyle, -1));
        if (obtainStyledAttributes.getBoolean(R.styleable.TextAppearance_textAllCaps, false)) {
            this.WP = new AllCapsTransformationMethod(getContext());
        } else {
            this.WP = null;
        }
        obtainStyledAttributes.recycle();
    }

    private void ak(int i, int i2) {
        Typeface typeface = null;
        switch (i) {
            case 1:
                typeface = Typeface.SANS_SERIF;
                break;
            case 2:
                typeface = Typeface.SERIF;
                break;
            case 3:
                typeface = Typeface.MONOSPACE;
                break;
        }
        setSwitchTypeface(typeface, i2);
    }

    public void setSwitchTypeface(Typeface typeface, int i) {
        Typeface create;
        if (i > 0) {
            if (typeface == null) {
                create = Typeface.defaultFromStyle(i);
            } else {
                create = Typeface.create(typeface, i);
            }
            setSwitchTypeface(create);
            int style = ((create != null ? create.getStyle() : 0) ^ (-1)) & i;
            this.mJ.setFakeBoldText((style & 1) != 0);
            this.mJ.setTextSkewX((style & 2) != 0 ? -0.25f : 0.0f);
            return;
        }
        this.mJ.setFakeBoldText(false);
        this.mJ.setTextSkewX(0.0f);
        setSwitchTypeface(typeface);
    }

    public void setSwitchTypeface(Typeface typeface) {
        if (this.mJ.getTypeface() != typeface) {
            this.mJ.setTypeface(typeface);
            requestLayout();
            invalidate();
        }
    }

    public void setSwitchPadding(int i) {
        this.Wx = i;
        requestLayout();
    }

    public int getSwitchPadding() {
        return this.Wx;
    }

    public void setSwitchMinWidth(int i) {
        this.Ww = i;
        requestLayout();
    }

    public int getSwitchMinWidth() {
        return this.Ww;
    }

    public void setThumbTextPadding(int i) {
        this.Wv = i;
        requestLayout();
    }

    public int getThumbTextPadding() {
        return this.Wv;
    }

    public void setTrackDrawable(Drawable drawable) {
        if (this.Wq != null) {
            this.Wq.setCallback(null);
        }
        this.Wq = drawable;
        if (drawable != null) {
            drawable.setCallback(this);
        }
        requestLayout();
    }

    public void setTrackResource(int i) {
        setTrackDrawable(AppCompatResources.getDrawable(getContext(), i));
    }

    public Drawable getTrackDrawable() {
        return this.Wq;
    }

    public void setTrackTintList(ColorStateList colorStateList) {
        this.Wr = colorStateList;
        this.Wt = true;
        im();
    }

    public ColorStateList getTrackTintList() {
        return this.Wr;
    }

    public void setTrackTintMode(PorterDuff.Mode mode) {
        this.Ws = mode;
        this.Wu = true;
        im();
    }

    public PorterDuff.Mode getTrackTintMode() {
        return this.Ws;
    }

    private void im() {
        if (this.Wq != null) {
            if (this.Wt || this.Wu) {
                this.Wq = this.Wq.mutate();
                if (this.Wt) {
                    DrawableCompat.setTintList(this.Wq, this.Wr);
                }
                if (this.Wu) {
                    DrawableCompat.setTintMode(this.Wq, this.Ws);
                }
                if (this.Wq.isStateful()) {
                    this.Wq.setState(getDrawableState());
                }
            }
        }
    }

    public void setThumbDrawable(Drawable drawable) {
        if (this.Wl != null) {
            this.Wl.setCallback(null);
        }
        this.Wl = drawable;
        if (drawable != null) {
            drawable.setCallback(this);
        }
        requestLayout();
    }

    public void setThumbResource(int i) {
        setThumbDrawable(AppCompatResources.getDrawable(getContext(), i));
    }

    public Drawable getThumbDrawable() {
        return this.Wl;
    }

    public void setThumbTintList(ColorStateList colorStateList) {
        this.Wm = colorStateList;
        this.Wo = true;
        in();
    }

    public ColorStateList getThumbTintList() {
        return this.Wm;
    }

    public void setThumbTintMode(PorterDuff.Mode mode) {
        this.Wn = mode;
        this.Wp = true;
        in();
    }

    public PorterDuff.Mode getThumbTintMode() {
        return this.Wn;
    }

    private void in() {
        if (this.Wl != null) {
            if (this.Wo || this.Wp) {
                this.Wl = this.Wl.mutate();
                if (this.Wo) {
                    DrawableCompat.setTintList(this.Wl, this.Wm);
                }
                if (this.Wp) {
                    DrawableCompat.setTintMode(this.Wl, this.Wn);
                }
                if (this.Wl.isStateful()) {
                    this.Wl.setState(getDrawableState());
                }
            }
        }
    }

    public void setSplitTrack(boolean z) {
        this.Wy = z;
        invalidate();
    }

    public boolean getSplitTrack() {
        return this.Wy;
    }

    public CharSequence getTextOn() {
        return this.Wz;
    }

    public void setTextOn(CharSequence charSequence) {
        this.Wz = charSequence;
        requestLayout();
    }

    public CharSequence getTextOff() {
        return this.WA;
    }

    public void setTextOff(CharSequence charSequence) {
        this.WA = charSequence;
        requestLayout();
    }

    public void setShowText(boolean z) {
        if (this.WB != z) {
            this.WB = z;
            requestLayout();
        }
    }

    public boolean getShowText() {
        return this.WB;
    }

    @Override // android.widget.TextView, android.view.View
    public void onMeasure(int i, int i2) {
        int i3;
        int i4;
        int i5 = 0;
        if (this.WB) {
            if (this.WN == null) {
                this.WN = l(this.Wz);
            }
            if (this.WO == null) {
                this.WO = l(this.WA);
            }
        }
        Rect rect = this.mTempRect;
        if (this.Wl != null) {
            this.Wl.getPadding(rect);
            i4 = (this.Wl.getIntrinsicWidth() - rect.left) - rect.right;
            i3 = this.Wl.getIntrinsicHeight();
        } else {
            i3 = 0;
            i4 = 0;
        }
        this.WH = Math.max(this.WB ? Math.max(this.WN.getWidth(), this.WO.getWidth()) + (this.Wv * 2) : 0, i4);
        if (this.Wq != null) {
            this.Wq.getPadding(rect);
            i5 = this.Wq.getIntrinsicHeight();
        } else {
            rect.setEmpty();
        }
        int i6 = rect.left;
        int i7 = rect.right;
        if (this.Wl != null) {
            Rect opticalBounds = DrawableUtils.getOpticalBounds(this.Wl);
            i6 = Math.max(i6, opticalBounds.left);
            i7 = Math.max(i7, opticalBounds.right);
        }
        int max = Math.max(this.Ww, i7 + i6 + (this.WH * 2));
        int max2 = Math.max(i5, i3);
        this.WF = max;
        this.WG = max2;
        super.onMeasure(i, i2);
        if (getMeasuredHeight() < max2) {
            setMeasuredDimension(ViewCompat.getMeasuredWidthAndState(this), max2);
        }
    }

    @Override // android.view.View
    public void onPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onPopulateAccessibilityEvent(accessibilityEvent);
        CharSequence charSequence = isChecked() ? this.Wz : this.WA;
        if (charSequence != null) {
            accessibilityEvent.getText().add(charSequence);
        }
    }

    private Layout l(CharSequence charSequence) {
        CharSequence transformation = this.WP != null ? this.WP.getTransformation(charSequence, this) : charSequence;
        return new StaticLayout(transformation, this.mJ, transformation != null ? (int) Math.ceil(Layout.getDesiredWidth(transformation, this.mJ)) : 0, Layout.Alignment.ALIGN_NORMAL, 1.0f, 0.0f, true);
    }

    private boolean h(float f, float f2) {
        if (this.Wl == null) {
            return false;
        }
        int thumbOffset = getThumbOffset();
        this.Wl.getPadding(this.mTempRect);
        int i = this.WJ - this.mTouchSlop;
        int i2 = (thumbOffset + this.WI) - this.mTouchSlop;
        return f > ((float) i2) && f < ((float) ((((this.WH + i2) + this.mTempRect.left) + this.mTempRect.right) + this.mTouchSlop)) && f2 > ((float) i) && f2 < ((float) (this.WL + this.mTouchSlop));
    }

    @Override // android.widget.TextView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        float f;
        this.mVelocityTracker.addMovement(motionEvent);
        switch (MotionEventCompat.getActionMasked(motionEvent)) {
            case 0:
                float x = motionEvent.getX();
                float y = motionEvent.getY();
                if (isEnabled() && h(x, y)) {
                    this.mTouchMode = 1;
                    this.WC = x;
                    this.WD = y;
                    break;
                }
                break;
            case 1:
            case 3:
                if (this.mTouchMode == 2) {
                    o(motionEvent);
                    super.onTouchEvent(motionEvent);
                    return true;
                }
                this.mTouchMode = 0;
                this.mVelocityTracker.clear();
                break;
            case 2:
                switch (this.mTouchMode) {
                    case 2:
                        float x2 = motionEvent.getX();
                        int thumbScrollRange = getThumbScrollRange();
                        float f2 = x2 - this.WC;
                        if (thumbScrollRange != 0) {
                            f = f2 / thumbScrollRange;
                        } else {
                            f = f2 > 0.0f ? 1.0f : -1.0f;
                        }
                        if (ViewUtils.isLayoutRtl(this)) {
                            f = -f;
                        }
                        float constrain = constrain(f + this.WE, 0.0f, 1.0f);
                        if (constrain != this.WE) {
                            this.WC = x2;
                            setThumbPosition(constrain);
                        }
                        return true;
                    case 1:
                        float x3 = motionEvent.getX();
                        float y2 = motionEvent.getY();
                        if (Math.abs(x3 - this.WC) > this.mTouchSlop || Math.abs(y2 - this.WD) > this.mTouchSlop) {
                            this.mTouchMode = 2;
                            getParent().requestDisallowInterceptTouchEvent(true);
                            this.WC = x3;
                            this.WD = y2;
                            return true;
                        }
                        break;
                }
        }
        return super.onTouchEvent(motionEvent);
    }

    private void n(MotionEvent motionEvent) {
        MotionEvent obtain = MotionEvent.obtain(motionEvent);
        obtain.setAction(3);
        super.onTouchEvent(obtain);
        obtain.recycle();
    }

    private void o(MotionEvent motionEvent) {
        boolean z = true;
        this.mTouchMode = 0;
        boolean z2 = motionEvent.getAction() == 1 && isEnabled();
        boolean isChecked = isChecked();
        if (z2) {
            this.mVelocityTracker.computeCurrentVelocity(1000);
            float xVelocity = this.mVelocityTracker.getXVelocity();
            if (Math.abs(xVelocity) > this.RR) {
                if (ViewUtils.isLayoutRtl(this)) {
                    if (xVelocity >= 0.0f) {
                        z = false;
                    }
                } else if (xVelocity <= 0.0f) {
                    z = false;
                }
            } else {
                z = getTargetCheckedState();
            }
        } else {
            z = isChecked;
        }
        if (z != isChecked) {
            playSoundEffect(0);
        }
        setChecked(z);
        n(motionEvent);
    }

    private void Q(final boolean z) {
        if (this.WQ != null) {
            io();
        }
        this.WQ = new a(this.WE, z ? 1.0f : 0.0f);
        this.WQ.setDuration(250L);
        this.WQ.setAnimationListener(new Animation.AnimationListener() { // from class: android.support.v7.widget.SwitchCompat.1
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                if (SwitchCompat.this.WQ == animation) {
                    SwitchCompat.this.setThumbPosition(z ? 1.0f : 0.0f);
                    SwitchCompat.this.WQ = null;
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        });
        startAnimation(this.WQ);
    }

    private void io() {
        if (this.WQ != null) {
            clearAnimation();
            this.WQ = null;
        }
    }

    private boolean getTargetCheckedState() {
        return this.WE > 0.5f;
    }

    void setThumbPosition(float f) {
        this.WE = f;
        invalidate();
    }

    @Override // android.widget.CompoundButton, android.widget.Checkable
    public void toggle() {
        setChecked(!isChecked());
    }

    @Override // android.widget.CompoundButton, android.widget.Checkable
    public void setChecked(boolean z) {
        super.setChecked(z);
        boolean isChecked = isChecked();
        if (getWindowToken() != null && ViewCompat.isLaidOut(this) && isShown()) {
            Q(isChecked);
            return;
        }
        io();
        setThumbPosition(isChecked ? 1.0f : 0.0f);
    }

    @Override // android.widget.TextView, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int i5;
        int i6;
        int i7;
        int height;
        int i8;
        int i9 = 0;
        super.onLayout(z, i, i2, i3, i4);
        if (this.Wl != null) {
            Rect rect = this.mTempRect;
            if (this.Wq != null) {
                this.Wq.getPadding(rect);
            } else {
                rect.setEmpty();
            }
            Rect opticalBounds = DrawableUtils.getOpticalBounds(this.Wl);
            i5 = Math.max(0, opticalBounds.left - rect.left);
            i9 = Math.max(0, opticalBounds.right - rect.right);
        } else {
            i5 = 0;
        }
        if (ViewUtils.isLayoutRtl(this)) {
            int paddingLeft = getPaddingLeft() + i5;
            i7 = ((this.WF + paddingLeft) - i5) - i9;
            i6 = paddingLeft;
        } else {
            int width = (getWidth() - getPaddingRight()) - i9;
            i6 = i9 + i5 + (width - this.WF);
            i7 = width;
        }
        switch (getGravity() & 112) {
            case 16:
                i8 = (((getPaddingTop() + getHeight()) - getPaddingBottom()) / 2) - (this.WG / 2);
                height = this.WG + i8;
                break;
            case 80:
                height = getHeight() - getPaddingBottom();
                i8 = height - this.WG;
                break;
            default:
                i8 = getPaddingTop();
                height = this.WG + i8;
                break;
        }
        this.WI = i6;
        this.WJ = i8;
        this.WL = height;
        this.WK = i7;
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        Rect rect;
        int i;
        int i2;
        int i3;
        Rect rect2 = this.mTempRect;
        int i4 = this.WI;
        int i5 = this.WJ;
        int i6 = this.WK;
        int i7 = this.WL;
        int thumbOffset = i4 + getThumbOffset();
        if (this.Wl != null) {
            rect = DrawableUtils.getOpticalBounds(this.Wl);
        } else {
            rect = DrawableUtils.INSETS_NONE;
        }
        if (this.Wq != null) {
            this.Wq.getPadding(rect2);
            int i8 = rect2.left + thumbOffset;
            if (rect != null) {
                if (rect.left > rect2.left) {
                    i4 += rect.left - rect2.left;
                }
                i3 = rect.top > rect2.top ? (rect.top - rect2.top) + i5 : i5;
                if (rect.right > rect2.right) {
                    i6 -= rect.right - rect2.right;
                }
                i2 = rect.bottom > rect2.bottom ? i7 - (rect.bottom - rect2.bottom) : i7;
            } else {
                i2 = i7;
                i3 = i5;
            }
            this.Wq.setBounds(i4, i3, i6, i2);
            i = i8;
        } else {
            i = thumbOffset;
        }
        if (this.Wl != null) {
            this.Wl.getPadding(rect2);
            int i9 = i - rect2.left;
            int i10 = i + this.WH + rect2.right;
            this.Wl.setBounds(i9, i5, i10, i7);
            Drawable background = getBackground();
            if (background != null) {
                DrawableCompat.setHotspotBounds(background, i9, i5, i10, i7);
            }
        }
        super.draw(canvas);
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    protected void onDraw(Canvas canvas) {
        int width;
        super.onDraw(canvas);
        Rect rect = this.mTempRect;
        Drawable drawable = this.Wq;
        if (drawable != null) {
            drawable.getPadding(rect);
        } else {
            rect.setEmpty();
        }
        int i = this.WJ;
        int i2 = this.WL;
        int i3 = i + rect.top;
        int i4 = i2 - rect.bottom;
        Drawable drawable2 = this.Wl;
        if (drawable != null) {
            if (this.Wy && drawable2 != null) {
                Rect opticalBounds = DrawableUtils.getOpticalBounds(drawable2);
                drawable2.copyBounds(rect);
                rect.left += opticalBounds.left;
                rect.right -= opticalBounds.right;
                int save = canvas.save();
                canvas.clipRect(rect, Region.Op.DIFFERENCE);
                drawable.draw(canvas);
                canvas.restoreToCount(save);
            } else {
                drawable.draw(canvas);
            }
        }
        int save2 = canvas.save();
        if (drawable2 != null) {
            drawable2.draw(canvas);
        }
        Layout layout = getTargetCheckedState() ? this.WN : this.WO;
        if (layout != null) {
            int[] drawableState = getDrawableState();
            if (this.WM != null) {
                this.mJ.setColor(this.WM.getColorForState(drawableState, 0));
            }
            this.mJ.drawableState = drawableState;
            if (drawable2 != null) {
                Rect bounds = drawable2.getBounds();
                width = bounds.right + bounds.left;
            } else {
                width = getWidth();
            }
            canvas.translate((width / 2) - (layout.getWidth() / 2), ((i3 + i4) / 2) - (layout.getHeight() / 2));
            layout.draw(canvas);
        }
        canvas.restoreToCount(save2);
    }

    @Override // android.widget.CompoundButton, android.widget.TextView
    public int getCompoundPaddingLeft() {
        if (!ViewUtils.isLayoutRtl(this)) {
            return super.getCompoundPaddingLeft();
        }
        int compoundPaddingLeft = super.getCompoundPaddingLeft() + this.WF;
        if (!TextUtils.isEmpty(getText())) {
            return compoundPaddingLeft + this.Wx;
        }
        return compoundPaddingLeft;
    }

    @Override // android.widget.CompoundButton, android.widget.TextView
    public int getCompoundPaddingRight() {
        if (ViewUtils.isLayoutRtl(this)) {
            return super.getCompoundPaddingRight();
        }
        int compoundPaddingRight = super.getCompoundPaddingRight() + this.WF;
        if (!TextUtils.isEmpty(getText())) {
            return compoundPaddingRight + this.Wx;
        }
        return compoundPaddingRight;
    }

    private int getThumbOffset() {
        float f;
        if (ViewUtils.isLayoutRtl(this)) {
            f = 1.0f - this.WE;
        } else {
            f = this.WE;
        }
        return (int) ((f * getThumbScrollRange()) + 0.5f);
    }

    private int getThumbScrollRange() {
        Rect rect;
        if (this.Wq != null) {
            Rect rect2 = this.mTempRect;
            this.Wq.getPadding(rect2);
            if (this.Wl != null) {
                rect = DrawableUtils.getOpticalBounds(this.Wl);
            } else {
                rect = DrawableUtils.INSETS_NONE;
            }
            return ((((this.WF - this.WH) - rect2.left) - rect2.right) - rect.left) - rect.right;
        }
        return 0;
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    protected int[] onCreateDrawableState(int i) {
        int[] onCreateDrawableState = super.onCreateDrawableState(i + 1);
        if (isChecked()) {
            mergeDrawableStates(onCreateDrawableState, jn);
        }
        return onCreateDrawableState;
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        int[] drawableState = getDrawableState();
        boolean z = false;
        Drawable drawable = this.Wl;
        if (drawable != null && drawable.isStateful()) {
            z = false | drawable.setState(drawableState);
        }
        Drawable drawable2 = this.Wq;
        if (drawable2 != null && drawable2.isStateful()) {
            z |= drawable2.setState(drawableState);
        }
        if (z) {
            invalidate();
        }
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    public void drawableHotspotChanged(float f, float f2) {
        if (Build.VERSION.SDK_INT >= 21) {
            super.drawableHotspotChanged(f, f2);
        }
        if (this.Wl != null) {
            DrawableCompat.setHotspot(this.Wl, f, f2);
        }
        if (this.Wq != null) {
            DrawableCompat.setHotspot(this.Wq, f, f2);
        }
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    protected boolean verifyDrawable(Drawable drawable) {
        return super.verifyDrawable(drawable) || drawable == this.Wl || drawable == this.Wq;
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    public void jumpDrawablesToCurrentState() {
        if (Build.VERSION.SDK_INT >= 11) {
            super.jumpDrawablesToCurrentState();
            if (this.Wl != null) {
                this.Wl.jumpToCurrentState();
            }
            if (this.Wq != null) {
                this.Wq.jumpToCurrentState();
            }
            io();
            setThumbPosition(isChecked() ? 1.0f : 0.0f);
        }
    }

    @Override // android.view.View
    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        accessibilityEvent.setClassName("android.widget.Switch");
    }

    @Override // android.view.View
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        if (Build.VERSION.SDK_INT >= 14) {
            super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
            accessibilityNodeInfo.setClassName("android.widget.Switch");
            CharSequence charSequence = isChecked() ? this.Wz : this.WA;
            if (!TextUtils.isEmpty(charSequence)) {
                CharSequence text = accessibilityNodeInfo.getText();
                if (TextUtils.isEmpty(text)) {
                    accessibilityNodeInfo.setText(charSequence);
                    return;
                }
                StringBuilder sb = new StringBuilder();
                sb.append(text).append(' ').append(charSequence);
                accessibilityNodeInfo.setText(sb);
            }
        }
    }

    private static float constrain(float f, float f2, float f3) {
        return f < f2 ? f2 : f > f3 ? f3 : f;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class a extends Animation {
        final float WT;
        final float WU;
        final float WV;

        a(float f, float f2) {
            this.WT = f;
            this.WU = f2;
            this.WV = f2 - f;
        }

        @Override // android.view.animation.Animation
        protected void applyTransformation(float f, Transformation transformation) {
            SwitchCompat.this.setThumbPosition(this.WT + (this.WV * f));
        }
    }
}
