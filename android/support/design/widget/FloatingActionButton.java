package android.support.design.widget;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.support.annotation.RestrictTo;
import android.support.design.R;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.i;
import android.support.v4.content.res.ConfigurationHelper;
import android.support.v4.view.ViewCompat;
import android.support.v7.widget.AppCompatImageHelper;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.List;
@CoordinatorLayout.DefaultBehavior(Behavior.class)
/* loaded from: classes2.dex */
public class FloatingActionButton extends ab {
    public static final int SIZE_AUTO = -1;
    public static final int SIZE_MINI = 1;
    public static final int SIZE_NORMAL = 0;
    private int mSize;
    private final Rect oA;
    private AppCompatImageHelper oB;
    private i oC;
    private ColorStateList or;
    private PorterDuff.Mode ot;
    private int ou;
    private int ov;
    int ow;
    private int ox;
    boolean oy;
    final Rect oz;

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo
    /* loaded from: classes2.dex */
    public @interface Size {
    }

    @Override // android.support.design.widget.ab, android.widget.ImageView, android.view.View
    public /* bridge */ /* synthetic */ void setVisibility(int i) {
        super.setVisibility(i);
    }

    /* loaded from: classes2.dex */
    public static abstract class OnVisibilityChangedListener {
        public void onShown(FloatingActionButton floatingActionButton) {
        }

        public void onHidden(FloatingActionButton floatingActionButton) {
        }
    }

    public FloatingActionButton(Context context) {
        this(context, null);
    }

    public FloatingActionButton(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public FloatingActionButton(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.oz = new Rect();
        this.oA = new Rect();
        r.R(context);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.FloatingActionButton, i, R.style.Widget_Design_FloatingActionButton);
        this.or = obtainStyledAttributes.getColorStateList(R.styleable.FloatingActionButton_backgroundTint);
        this.ot = z.a(obtainStyledAttributes.getInt(R.styleable.FloatingActionButton_backgroundTintMode, -1), null);
        this.ov = obtainStyledAttributes.getColor(R.styleable.FloatingActionButton_rippleColor, 0);
        this.mSize = obtainStyledAttributes.getInt(R.styleable.FloatingActionButton_fabSize, -1);
        this.ou = obtainStyledAttributes.getDimensionPixelSize(R.styleable.FloatingActionButton_borderWidth, 0);
        float dimension = obtainStyledAttributes.getDimension(R.styleable.FloatingActionButton_elevation, 0.0f);
        float dimension2 = obtainStyledAttributes.getDimension(R.styleable.FloatingActionButton_pressedTranslationZ, 0.0f);
        this.oy = obtainStyledAttributes.getBoolean(R.styleable.FloatingActionButton_useCompatPadding, false);
        obtainStyledAttributes.recycle();
        this.oB = new AppCompatImageHelper(this);
        this.oB.loadFromAttributes(attributeSet, i);
        this.ox = (int) getResources().getDimension(R.dimen.design_fab_image_size);
        getImpl().a(this.or, this.ot, this.ov, this.ou);
        getImpl().setElevation(dimension);
        getImpl().m(dimension2);
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onMeasure(int i, int i2) {
        int sizeDimension = getSizeDimension();
        this.ow = (sizeDimension - this.ox) / 2;
        getImpl().bV();
        int min = Math.min(resolveAdjustedSize(sizeDimension, i), resolveAdjustedSize(sizeDimension, i2));
        setMeasuredDimension(this.oz.left + min + this.oz.right, min + this.oz.top + this.oz.bottom);
    }

    public int getRippleColor() {
        return this.ov;
    }

    public void setRippleColor(int i) {
        if (this.ov != i) {
            this.ov = i;
            getImpl().setRippleColor(i);
        }
    }

    @Override // android.view.View
    public ColorStateList getBackgroundTintList() {
        return this.or;
    }

    @Override // android.view.View
    public void setBackgroundTintList(ColorStateList colorStateList) {
        if (this.or != colorStateList) {
            this.or = colorStateList;
            getImpl().setBackgroundTintList(colorStateList);
        }
    }

    @Override // android.view.View
    public PorterDuff.Mode getBackgroundTintMode() {
        return this.ot;
    }

    @Override // android.view.View
    public void setBackgroundTintMode(PorterDuff.Mode mode) {
        if (this.ot != mode) {
            this.ot = mode;
            getImpl().setBackgroundTintMode(mode);
        }
    }

    @Override // android.view.View
    public void setBackgroundDrawable(Drawable drawable) {
        Log.i("FloatingActionButton", "Setting a custom background is not supported.");
    }

    @Override // android.view.View
    public void setBackgroundResource(int i) {
        Log.i("FloatingActionButton", "Setting a custom background is not supported.");
    }

    @Override // android.view.View
    public void setBackgroundColor(int i) {
        Log.i("FloatingActionButton", "Setting a custom background is not supported.");
    }

    @Override // android.widget.ImageView
    public void setImageResource(int i) {
        this.oB.setImageResource(i);
    }

    public void show() {
        show(null);
    }

    public void show(OnVisibilityChangedListener onVisibilityChangedListener) {
        a(onVisibilityChangedListener, true);
    }

    void a(OnVisibilityChangedListener onVisibilityChangedListener, boolean z) {
        getImpl().b(a(onVisibilityChangedListener), z);
    }

    public void hide() {
        hide(null);
    }

    public void hide(OnVisibilityChangedListener onVisibilityChangedListener) {
        b(onVisibilityChangedListener, true);
    }

    void b(OnVisibilityChangedListener onVisibilityChangedListener, boolean z) {
        getImpl().a(a(onVisibilityChangedListener), z);
    }

    public void setUseCompatPadding(boolean z) {
        if (this.oy != z) {
            this.oy = z;
            getImpl().bP();
        }
    }

    public boolean getUseCompatPadding() {
        return this.oy;
    }

    public void setSize(int i) {
        if (i != this.mSize) {
            this.mSize = i;
            requestLayout();
        }
    }

    public int getSize() {
        return this.mSize;
    }

    private i.a a(final OnVisibilityChangedListener onVisibilityChangedListener) {
        if (onVisibilityChangedListener == null) {
            return null;
        }
        return new i.a() { // from class: android.support.design.widget.FloatingActionButton.1
            @Override // android.support.design.widget.i.a
            public void bL() {
                onVisibilityChangedListener.onShown(FloatingActionButton.this);
            }

            @Override // android.support.design.widget.i.a
            public void bM() {
                onVisibilityChangedListener.onHidden(FloatingActionButton.this);
            }
        };
    }

    int getSizeDimension() {
        return D(this.mSize);
    }

    private int D(int i) {
        Resources resources = getResources();
        switch (i) {
            case -1:
                if (Math.max(ConfigurationHelper.getScreenWidthDp(resources), ConfigurationHelper.getScreenHeightDp(resources)) < 470) {
                    return D(1);
                }
                return D(0);
            case 0:
            default:
                return resources.getDimensionPixelSize(R.dimen.design_fab_size_normal);
            case 1:
                return resources.getDimensionPixelSize(R.dimen.design_fab_size_mini);
        }
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        getImpl().onAttachedToWindow();
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        getImpl().onDetachedFromWindow();
    }

    @Override // android.widget.ImageView, android.view.View
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        getImpl().c(getDrawableState());
    }

    @Override // android.widget.ImageView, android.view.View
    @TargetApi(11)
    public void jumpDrawablesToCurrentState() {
        super.jumpDrawablesToCurrentState();
        getImpl().bO();
    }

    public boolean getContentRect(Rect rect) {
        if (ViewCompat.isLaidOut(this)) {
            rect.set(0, 0, getWidth(), getHeight());
            rect.left += this.oz.left;
            rect.top += this.oz.top;
            rect.right -= this.oz.right;
            rect.bottom -= this.oz.bottom;
            return true;
        }
        return false;
    }

    public Drawable getContentBackground() {
        return getImpl().getContentBackground();
    }

    private static int resolveAdjustedSize(int i, int i2) {
        int mode = View.MeasureSpec.getMode(i2);
        int size = View.MeasureSpec.getSize(i2);
        switch (mode) {
            case Integer.MIN_VALUE:
                return Math.min(i, size);
            case 0:
            default:
                return i;
            case 1073741824:
                return size;
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (!getContentRect(this.oA) || this.oA.contains((int) motionEvent.getX(), (int) motionEvent.getY())) {
            return super.onTouchEvent(motionEvent);
        }
        return false;
    }

    /* loaded from: classes2.dex */
    public static class Behavior extends CoordinatorLayout.Behavior<FloatingActionButton> {
        private Rect mTmpRect;
        private OnVisibilityChangedListener oF;
        private boolean oG;

        public Behavior() {
            this.oG = true;
        }

        public Behavior(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.FloatingActionButton_Behavior_Layout);
            this.oG = obtainStyledAttributes.getBoolean(R.styleable.FloatingActionButton_Behavior_Layout_behavior_autoHide, true);
            obtainStyledAttributes.recycle();
        }

        public void setAutoHideEnabled(boolean z) {
            this.oG = z;
        }

        public boolean isAutoHideEnabled() {
            return this.oG;
        }

        @Override // android.support.design.widget.CoordinatorLayout.Behavior
        public void onAttachedToLayoutParams(CoordinatorLayout.LayoutParams layoutParams) {
            if (layoutParams.dodgeInsetEdges == 0) {
                layoutParams.dodgeInsetEdges = 80;
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.support.design.widget.CoordinatorLayout.Behavior
        public boolean onDependentViewChanged(CoordinatorLayout coordinatorLayout, FloatingActionButton floatingActionButton, View view) {
            if (view instanceof AppBarLayout) {
                a(coordinatorLayout, (AppBarLayout) view, floatingActionButton);
                return false;
            } else if (B(view)) {
                b(view, floatingActionButton);
                return false;
            } else {
                return false;
            }
        }

        private static boolean B(View view) {
            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            if (layoutParams instanceof CoordinatorLayout.LayoutParams) {
                return ((CoordinatorLayout.LayoutParams) layoutParams).getBehavior() instanceof BottomSheetBehavior;
            }
            return false;
        }

        private boolean a(View view, FloatingActionButton floatingActionButton) {
            return this.oG && ((CoordinatorLayout.LayoutParams) floatingActionButton.getLayoutParams()).getAnchorId() == view.getId() && floatingActionButton.getUserSetVisibility() == 0;
        }

        private boolean a(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, FloatingActionButton floatingActionButton) {
            if (a(appBarLayout, floatingActionButton)) {
                if (this.mTmpRect == null) {
                    this.mTmpRect = new Rect();
                }
                Rect rect = this.mTmpRect;
                v.b(coordinatorLayout, appBarLayout, rect);
                if (rect.bottom <= appBarLayout.getMinimumHeightForVisibleOverlappingContent()) {
                    floatingActionButton.b(this.oF, false);
                } else {
                    floatingActionButton.a(this.oF, false);
                }
                return true;
            }
            return false;
        }

        private boolean b(View view, FloatingActionButton floatingActionButton) {
            if (a(view, floatingActionButton)) {
                if (view.getTop() < ((CoordinatorLayout.LayoutParams) floatingActionButton.getLayoutParams()).topMargin + (floatingActionButton.getHeight() / 2)) {
                    floatingActionButton.b(this.oF, false);
                } else {
                    floatingActionButton.a(this.oF, false);
                }
                return true;
            }
            return false;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.support.design.widget.CoordinatorLayout.Behavior
        public boolean onLayoutChild(CoordinatorLayout coordinatorLayout, FloatingActionButton floatingActionButton, int i) {
            List<View> dependencies = coordinatorLayout.getDependencies(floatingActionButton);
            int size = dependencies.size();
            for (int i2 = 0; i2 < size; i2++) {
                View view = dependencies.get(i2);
                if (view instanceof AppBarLayout) {
                    if (a(coordinatorLayout, (AppBarLayout) view, floatingActionButton)) {
                        break;
                    }
                } else {
                    if (B(view) && b(view, floatingActionButton)) {
                        break;
                    }
                }
            }
            coordinatorLayout.onLayoutChild(floatingActionButton, i);
            a(coordinatorLayout, floatingActionButton);
            return true;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.support.design.widget.CoordinatorLayout.Behavior
        public boolean getInsetDodgeRect(CoordinatorLayout coordinatorLayout, FloatingActionButton floatingActionButton, Rect rect) {
            Rect rect2 = floatingActionButton.oz;
            rect.set(floatingActionButton.getLeft() + rect2.left, floatingActionButton.getTop() + rect2.top, floatingActionButton.getRight() - rect2.right, floatingActionButton.getBottom() - rect2.bottom);
            return true;
        }

        private void a(CoordinatorLayout coordinatorLayout, FloatingActionButton floatingActionButton) {
            int i;
            int i2 = 0;
            Rect rect = floatingActionButton.oz;
            if (rect != null && rect.centerX() > 0 && rect.centerY() > 0) {
                CoordinatorLayout.LayoutParams layoutParams = (CoordinatorLayout.LayoutParams) floatingActionButton.getLayoutParams();
                if (floatingActionButton.getRight() >= coordinatorLayout.getWidth() - layoutParams.rightMargin) {
                    i = rect.right;
                } else {
                    i = floatingActionButton.getLeft() <= layoutParams.leftMargin ? -rect.left : 0;
                }
                if (floatingActionButton.getBottom() >= coordinatorLayout.getHeight() - layoutParams.bottomMargin) {
                    i2 = rect.bottom;
                } else if (floatingActionButton.getTop() <= layoutParams.topMargin) {
                    i2 = -rect.top;
                }
                if (i2 != 0) {
                    ViewCompat.offsetTopAndBottom(floatingActionButton, i2);
                }
                if (i != 0) {
                    ViewCompat.offsetLeftAndRight(floatingActionButton, i);
                }
            }
        }
    }

    public float getCompatElevation() {
        return getImpl().getElevation();
    }

    public void setCompatElevation(float f) {
        getImpl().setElevation(f);
    }

    private i getImpl() {
        if (this.oC == null) {
            this.oC = bK();
        }
        return this.oC;
    }

    private i bK() {
        int i = Build.VERSION.SDK_INT;
        if (i >= 21) {
            return new j(this, new a(), z.sS);
        }
        if (i >= 14) {
            return new h(this, new a(), z.sS);
        }
        return new g(this, new a(), z.sS);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class a implements o {
        a() {
        }

        @Override // android.support.design.widget.o
        public float getRadius() {
            return FloatingActionButton.this.getSizeDimension() / 2.0f;
        }

        @Override // android.support.design.widget.o
        public void e(int i, int i2, int i3, int i4) {
            FloatingActionButton.this.oz.set(i, i2, i3, i4);
            FloatingActionButton.this.setPadding(FloatingActionButton.this.ow + i, FloatingActionButton.this.ow + i2, FloatingActionButton.this.ow + i3, FloatingActionButton.this.ow + i4);
        }

        @Override // android.support.design.widget.o
        public void setBackgroundDrawable(Drawable drawable) {
            FloatingActionButton.super.setBackgroundDrawable(drawable);
        }

        @Override // android.support.design.widget.o
        public boolean bN() {
            return FloatingActionButton.this.oy;
        }
    }
}
