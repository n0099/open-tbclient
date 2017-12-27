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
    private int RZ;
    private boolean WA;
    private boolean WB;
    private int WC;
    private int WD;
    private int WE;
    private boolean WF;
    private CharSequence WG;
    private CharSequence WH;
    private boolean WI;
    private float WJ;
    private float WK;
    private float WL;
    private int WM;
    private int WN;
    private int WO;
    private int WP;
    private int WQ;
    private int WR;
    private int WS;
    private ColorStateList WT;
    private Layout WU;
    private Layout WV;
    private TransformationMethod WW;
    a WX;
    private Drawable Ws;
    private ColorStateList Wt;
    private PorterDuff.Mode Wu;
    private boolean Wv;
    private boolean Ww;
    private Drawable Wx;
    private ColorStateList Wy;
    private PorterDuff.Mode Wz;
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
        this.Wt = null;
        this.Wu = null;
        this.Wv = false;
        this.Ww = false;
        this.Wy = null;
        this.Wz = null;
        this.WA = false;
        this.WB = false;
        this.mVelocityTracker = VelocityTracker.obtain();
        this.mTempRect = new Rect();
        this.mJ = new TextPaint(1);
        Resources resources = getResources();
        this.mJ.density = resources.getDisplayMetrics().density;
        TintTypedArray obtainStyledAttributes = TintTypedArray.obtainStyledAttributes(context, attributeSet, R.styleable.SwitchCompat, i, 0);
        this.Ws = obtainStyledAttributes.getDrawable(R.styleable.SwitchCompat_android_thumb);
        if (this.Ws != null) {
            this.Ws.setCallback(this);
        }
        this.Wx = obtainStyledAttributes.getDrawable(R.styleable.SwitchCompat_track);
        if (this.Wx != null) {
            this.Wx.setCallback(this);
        }
        this.WG = obtainStyledAttributes.getText(R.styleable.SwitchCompat_android_textOn);
        this.WH = obtainStyledAttributes.getText(R.styleable.SwitchCompat_android_textOff);
        this.WI = obtainStyledAttributes.getBoolean(R.styleable.SwitchCompat_showText, true);
        this.WC = obtainStyledAttributes.getDimensionPixelSize(R.styleable.SwitchCompat_thumbTextPadding, 0);
        this.WD = obtainStyledAttributes.getDimensionPixelSize(R.styleable.SwitchCompat_switchMinWidth, 0);
        this.WE = obtainStyledAttributes.getDimensionPixelSize(R.styleable.SwitchCompat_switchPadding, 0);
        this.WF = obtainStyledAttributes.getBoolean(R.styleable.SwitchCompat_splitTrack, false);
        ColorStateList colorStateList = obtainStyledAttributes.getColorStateList(R.styleable.SwitchCompat_thumbTint);
        if (colorStateList != null) {
            this.Wt = colorStateList;
            this.Wv = true;
        }
        PorterDuff.Mode a2 = DrawableUtils.a(obtainStyledAttributes.getInt(R.styleable.SwitchCompat_thumbTintMode, -1), null);
        if (this.Wu != a2) {
            this.Wu = a2;
            this.Ww = true;
        }
        if (this.Wv || this.Ww) {
            in();
        }
        ColorStateList colorStateList2 = obtainStyledAttributes.getColorStateList(R.styleable.SwitchCompat_trackTint);
        if (colorStateList2 != null) {
            this.Wy = colorStateList2;
            this.WA = true;
        }
        PorterDuff.Mode a3 = DrawableUtils.a(obtainStyledAttributes.getInt(R.styleable.SwitchCompat_trackTintMode, -1), null);
        if (this.Wz != a3) {
            this.Wz = a3;
            this.WB = true;
        }
        if (this.WA || this.WB) {
            im();
        }
        int resourceId = obtainStyledAttributes.getResourceId(R.styleable.SwitchCompat_switchTextAppearance, 0);
        if (resourceId != 0) {
            setSwitchTextAppearance(context, resourceId);
        }
        obtainStyledAttributes.recycle();
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        this.mTouchSlop = viewConfiguration.getScaledTouchSlop();
        this.RZ = viewConfiguration.getScaledMinimumFlingVelocity();
        refreshDrawableState();
        setChecked(isChecked());
    }

    public void setSwitchTextAppearance(Context context, int i) {
        TintTypedArray obtainStyledAttributes = TintTypedArray.obtainStyledAttributes(context, i, R.styleable.TextAppearance);
        ColorStateList colorStateList = obtainStyledAttributes.getColorStateList(R.styleable.TextAppearance_android_textColor);
        if (colorStateList != null) {
            this.WT = colorStateList;
        } else {
            this.WT = getTextColors();
        }
        int dimensionPixelSize = obtainStyledAttributes.getDimensionPixelSize(R.styleable.TextAppearance_android_textSize, 0);
        if (dimensionPixelSize != 0 && dimensionPixelSize != this.mJ.getTextSize()) {
            this.mJ.setTextSize(dimensionPixelSize);
            requestLayout();
        }
        ak(obtainStyledAttributes.getInt(R.styleable.TextAppearance_android_typeface, -1), obtainStyledAttributes.getInt(R.styleable.TextAppearance_android_textStyle, -1));
        if (obtainStyledAttributes.getBoolean(R.styleable.TextAppearance_textAllCaps, false)) {
            this.WW = new AllCapsTransformationMethod(getContext());
        } else {
            this.WW = null;
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
        this.WE = i;
        requestLayout();
    }

    public int getSwitchPadding() {
        return this.WE;
    }

    public void setSwitchMinWidth(int i) {
        this.WD = i;
        requestLayout();
    }

    public int getSwitchMinWidth() {
        return this.WD;
    }

    public void setThumbTextPadding(int i) {
        this.WC = i;
        requestLayout();
    }

    public int getThumbTextPadding() {
        return this.WC;
    }

    public void setTrackDrawable(Drawable drawable) {
        if (this.Wx != null) {
            this.Wx.setCallback(null);
        }
        this.Wx = drawable;
        if (drawable != null) {
            drawable.setCallback(this);
        }
        requestLayout();
    }

    public void setTrackResource(int i) {
        setTrackDrawable(AppCompatResources.getDrawable(getContext(), i));
    }

    public Drawable getTrackDrawable() {
        return this.Wx;
    }

    public void setTrackTintList(ColorStateList colorStateList) {
        this.Wy = colorStateList;
        this.WA = true;
        im();
    }

    public ColorStateList getTrackTintList() {
        return this.Wy;
    }

    public void setTrackTintMode(PorterDuff.Mode mode) {
        this.Wz = mode;
        this.WB = true;
        im();
    }

    public PorterDuff.Mode getTrackTintMode() {
        return this.Wz;
    }

    private void im() {
        if (this.Wx != null) {
            if (this.WA || this.WB) {
                this.Wx = this.Wx.mutate();
                if (this.WA) {
                    DrawableCompat.setTintList(this.Wx, this.Wy);
                }
                if (this.WB) {
                    DrawableCompat.setTintMode(this.Wx, this.Wz);
                }
                if (this.Wx.isStateful()) {
                    this.Wx.setState(getDrawableState());
                }
            }
        }
    }

    public void setThumbDrawable(Drawable drawable) {
        if (this.Ws != null) {
            this.Ws.setCallback(null);
        }
        this.Ws = drawable;
        if (drawable != null) {
            drawable.setCallback(this);
        }
        requestLayout();
    }

    public void setThumbResource(int i) {
        setThumbDrawable(AppCompatResources.getDrawable(getContext(), i));
    }

    public Drawable getThumbDrawable() {
        return this.Ws;
    }

    public void setThumbTintList(ColorStateList colorStateList) {
        this.Wt = colorStateList;
        this.Wv = true;
        in();
    }

    public ColorStateList getThumbTintList() {
        return this.Wt;
    }

    public void setThumbTintMode(PorterDuff.Mode mode) {
        this.Wu = mode;
        this.Ww = true;
        in();
    }

    public PorterDuff.Mode getThumbTintMode() {
        return this.Wu;
    }

    private void in() {
        if (this.Ws != null) {
            if (this.Wv || this.Ww) {
                this.Ws = this.Ws.mutate();
                if (this.Wv) {
                    DrawableCompat.setTintList(this.Ws, this.Wt);
                }
                if (this.Ww) {
                    DrawableCompat.setTintMode(this.Ws, this.Wu);
                }
                if (this.Ws.isStateful()) {
                    this.Ws.setState(getDrawableState());
                }
            }
        }
    }

    public void setSplitTrack(boolean z) {
        this.WF = z;
        invalidate();
    }

    public boolean getSplitTrack() {
        return this.WF;
    }

    public CharSequence getTextOn() {
        return this.WG;
    }

    public void setTextOn(CharSequence charSequence) {
        this.WG = charSequence;
        requestLayout();
    }

    public CharSequence getTextOff() {
        return this.WH;
    }

    public void setTextOff(CharSequence charSequence) {
        this.WH = charSequence;
        requestLayout();
    }

    public void setShowText(boolean z) {
        if (this.WI != z) {
            this.WI = z;
            requestLayout();
        }
    }

    public boolean getShowText() {
        return this.WI;
    }

    @Override // android.widget.TextView, android.view.View
    public void onMeasure(int i, int i2) {
        int i3;
        int i4;
        int i5 = 0;
        if (this.WI) {
            if (this.WU == null) {
                this.WU = l(this.WG);
            }
            if (this.WV == null) {
                this.WV = l(this.WH);
            }
        }
        Rect rect = this.mTempRect;
        if (this.Ws != null) {
            this.Ws.getPadding(rect);
            i4 = (this.Ws.getIntrinsicWidth() - rect.left) - rect.right;
            i3 = this.Ws.getIntrinsicHeight();
        } else {
            i3 = 0;
            i4 = 0;
        }
        this.WO = Math.max(this.WI ? Math.max(this.WU.getWidth(), this.WV.getWidth()) + (this.WC * 2) : 0, i4);
        if (this.Wx != null) {
            this.Wx.getPadding(rect);
            i5 = this.Wx.getIntrinsicHeight();
        } else {
            rect.setEmpty();
        }
        int i6 = rect.left;
        int i7 = rect.right;
        if (this.Ws != null) {
            Rect opticalBounds = DrawableUtils.getOpticalBounds(this.Ws);
            i6 = Math.max(i6, opticalBounds.left);
            i7 = Math.max(i7, opticalBounds.right);
        }
        int max = Math.max(this.WD, i7 + i6 + (this.WO * 2));
        int max2 = Math.max(i5, i3);
        this.WM = max;
        this.WN = max2;
        super.onMeasure(i, i2);
        if (getMeasuredHeight() < max2) {
            setMeasuredDimension(ViewCompat.getMeasuredWidthAndState(this), max2);
        }
    }

    @Override // android.view.View
    public void onPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onPopulateAccessibilityEvent(accessibilityEvent);
        CharSequence charSequence = isChecked() ? this.WG : this.WH;
        if (charSequence != null) {
            accessibilityEvent.getText().add(charSequence);
        }
    }

    private Layout l(CharSequence charSequence) {
        CharSequence transformation = this.WW != null ? this.WW.getTransformation(charSequence, this) : charSequence;
        return new StaticLayout(transformation, this.mJ, transformation != null ? (int) Math.ceil(Layout.getDesiredWidth(transformation, this.mJ)) : 0, Layout.Alignment.ALIGN_NORMAL, 1.0f, 0.0f, true);
    }

    private boolean h(float f, float f2) {
        if (this.Ws == null) {
            return false;
        }
        int thumbOffset = getThumbOffset();
        this.Ws.getPadding(this.mTempRect);
        int i = this.WQ - this.mTouchSlop;
        int i2 = (thumbOffset + this.WP) - this.mTouchSlop;
        return f > ((float) i2) && f < ((float) ((((this.WO + i2) + this.mTempRect.left) + this.mTempRect.right) + this.mTouchSlop)) && f2 > ((float) i) && f2 < ((float) (this.WS + this.mTouchSlop));
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
                    this.WJ = x;
                    this.WK = y;
                    break;
                }
                break;
            case 1:
            case 3:
                if (this.mTouchMode == 2) {
                    k(motionEvent);
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
                        float f2 = x2 - this.WJ;
                        if (thumbScrollRange != 0) {
                            f = f2 / thumbScrollRange;
                        } else {
                            f = f2 > 0.0f ? 1.0f : -1.0f;
                        }
                        if (ViewUtils.isLayoutRtl(this)) {
                            f = -f;
                        }
                        float constrain = constrain(f + this.WL, 0.0f, 1.0f);
                        if (constrain != this.WL) {
                            this.WJ = x2;
                            setThumbPosition(constrain);
                        }
                        return true;
                    case 1:
                        float x3 = motionEvent.getX();
                        float y2 = motionEvent.getY();
                        if (Math.abs(x3 - this.WJ) > this.mTouchSlop || Math.abs(y2 - this.WK) > this.mTouchSlop) {
                            this.mTouchMode = 2;
                            getParent().requestDisallowInterceptTouchEvent(true);
                            this.WJ = x3;
                            this.WK = y2;
                            return true;
                        }
                        break;
                }
        }
        return super.onTouchEvent(motionEvent);
    }

    private void j(MotionEvent motionEvent) {
        MotionEvent obtain = MotionEvent.obtain(motionEvent);
        obtain.setAction(3);
        super.onTouchEvent(obtain);
        obtain.recycle();
    }

    private void k(MotionEvent motionEvent) {
        boolean z = true;
        this.mTouchMode = 0;
        boolean z2 = motionEvent.getAction() == 1 && isEnabled();
        boolean isChecked = isChecked();
        if (z2) {
            this.mVelocityTracker.computeCurrentVelocity(1000);
            float xVelocity = this.mVelocityTracker.getXVelocity();
            if (Math.abs(xVelocity) > this.RZ) {
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
        j(motionEvent);
    }

    private void O(final boolean z) {
        if (this.WX != null) {
            io();
        }
        this.WX = new a(this.WL, z ? 1.0f : 0.0f);
        this.WX.setDuration(250L);
        this.WX.setAnimationListener(new Animation.AnimationListener() { // from class: android.support.v7.widget.SwitchCompat.1
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                if (SwitchCompat.this.WX == animation) {
                    SwitchCompat.this.setThumbPosition(z ? 1.0f : 0.0f);
                    SwitchCompat.this.WX = null;
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        });
        startAnimation(this.WX);
    }

    private void io() {
        if (this.WX != null) {
            clearAnimation();
            this.WX = null;
        }
    }

    private boolean getTargetCheckedState() {
        return this.WL > 0.5f;
    }

    void setThumbPosition(float f) {
        this.WL = f;
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
            O(isChecked);
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
        if (this.Ws != null) {
            Rect rect = this.mTempRect;
            if (this.Wx != null) {
                this.Wx.getPadding(rect);
            } else {
                rect.setEmpty();
            }
            Rect opticalBounds = DrawableUtils.getOpticalBounds(this.Ws);
            i5 = Math.max(0, opticalBounds.left - rect.left);
            i9 = Math.max(0, opticalBounds.right - rect.right);
        } else {
            i5 = 0;
        }
        if (ViewUtils.isLayoutRtl(this)) {
            int paddingLeft = getPaddingLeft() + i5;
            i7 = ((this.WM + paddingLeft) - i5) - i9;
            i6 = paddingLeft;
        } else {
            int width = (getWidth() - getPaddingRight()) - i9;
            i6 = i9 + i5 + (width - this.WM);
            i7 = width;
        }
        switch (getGravity() & 112) {
            case 16:
                i8 = (((getPaddingTop() + getHeight()) - getPaddingBottom()) / 2) - (this.WN / 2);
                height = this.WN + i8;
                break;
            case 80:
                height = getHeight() - getPaddingBottom();
                i8 = height - this.WN;
                break;
            default:
                i8 = getPaddingTop();
                height = this.WN + i8;
                break;
        }
        this.WP = i6;
        this.WQ = i8;
        this.WS = height;
        this.WR = i7;
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        Rect rect;
        int i;
        int i2;
        int i3;
        Rect rect2 = this.mTempRect;
        int i4 = this.WP;
        int i5 = this.WQ;
        int i6 = this.WR;
        int i7 = this.WS;
        int thumbOffset = i4 + getThumbOffset();
        if (this.Ws != null) {
            rect = DrawableUtils.getOpticalBounds(this.Ws);
        } else {
            rect = DrawableUtils.INSETS_NONE;
        }
        if (this.Wx != null) {
            this.Wx.getPadding(rect2);
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
            this.Wx.setBounds(i4, i3, i6, i2);
            i = i8;
        } else {
            i = thumbOffset;
        }
        if (this.Ws != null) {
            this.Ws.getPadding(rect2);
            int i9 = i - rect2.left;
            int i10 = i + this.WO + rect2.right;
            this.Ws.setBounds(i9, i5, i10, i7);
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
        Drawable drawable = this.Wx;
        if (drawable != null) {
            drawable.getPadding(rect);
        } else {
            rect.setEmpty();
        }
        int i = this.WQ;
        int i2 = this.WS;
        int i3 = i + rect.top;
        int i4 = i2 - rect.bottom;
        Drawable drawable2 = this.Ws;
        if (drawable != null) {
            if (this.WF && drawable2 != null) {
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
        Layout layout = getTargetCheckedState() ? this.WU : this.WV;
        if (layout != null) {
            int[] drawableState = getDrawableState();
            if (this.WT != null) {
                this.mJ.setColor(this.WT.getColorForState(drawableState, 0));
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
        int compoundPaddingLeft = super.getCompoundPaddingLeft() + this.WM;
        if (!TextUtils.isEmpty(getText())) {
            return compoundPaddingLeft + this.WE;
        }
        return compoundPaddingLeft;
    }

    @Override // android.widget.CompoundButton, android.widget.TextView
    public int getCompoundPaddingRight() {
        if (ViewUtils.isLayoutRtl(this)) {
            return super.getCompoundPaddingRight();
        }
        int compoundPaddingRight = super.getCompoundPaddingRight() + this.WM;
        if (!TextUtils.isEmpty(getText())) {
            return compoundPaddingRight + this.WE;
        }
        return compoundPaddingRight;
    }

    private int getThumbOffset() {
        float f;
        if (ViewUtils.isLayoutRtl(this)) {
            f = 1.0f - this.WL;
        } else {
            f = this.WL;
        }
        return (int) ((f * getThumbScrollRange()) + 0.5f);
    }

    private int getThumbScrollRange() {
        Rect rect;
        if (this.Wx != null) {
            Rect rect2 = this.mTempRect;
            this.Wx.getPadding(rect2);
            if (this.Ws != null) {
                rect = DrawableUtils.getOpticalBounds(this.Ws);
            } else {
                rect = DrawableUtils.INSETS_NONE;
            }
            return ((((this.WM - this.WO) - rect2.left) - rect2.right) - rect.left) - rect.right;
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
        Drawable drawable = this.Ws;
        if (drawable != null && drawable.isStateful()) {
            z = false | drawable.setState(drawableState);
        }
        Drawable drawable2 = this.Wx;
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
        if (this.Ws != null) {
            DrawableCompat.setHotspot(this.Ws, f, f2);
        }
        if (this.Wx != null) {
            DrawableCompat.setHotspot(this.Wx, f, f2);
        }
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    protected boolean verifyDrawable(Drawable drawable) {
        return super.verifyDrawable(drawable) || drawable == this.Ws || drawable == this.Wx;
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    public void jumpDrawablesToCurrentState() {
        if (Build.VERSION.SDK_INT >= 11) {
            super.jumpDrawablesToCurrentState();
            if (this.Ws != null) {
                this.Ws.jumpToCurrentState();
            }
            if (this.Wx != null) {
                this.Wx.jumpToCurrentState();
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
            CharSequence charSequence = isChecked() ? this.WG : this.WH;
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
        final float Xa;
        final float Xb;
        final float Xc;

        a(float f, float f2) {
            this.Xa = f;
            this.Xb = f2;
            this.Xc = f2 - f;
        }

        @Override // android.view.animation.Animation
        protected void applyTransformation(float f, Transformation transformation) {
            SwitchCompat.this.setThumbPosition(this.Xa + (this.Xc * f));
        }
    }
}
