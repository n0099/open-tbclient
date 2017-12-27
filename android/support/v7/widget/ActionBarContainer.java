package android.support.v7.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.support.annotation.RestrictTo;
import android.support.v4.view.ViewCompat;
import android.support.v7.appcompat.R;
import android.util.AttributeSet;
import android.view.ActionMode;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
@RestrictTo
/* loaded from: classes2.dex */
public class ActionBarContainer extends FrameLayout {
    Drawable Ix;
    private boolean JV;
    private View JW;
    private View JX;
    private View JY;
    Drawable JZ;
    Drawable Ka;
    boolean Kb;
    boolean Kc;
    private int mHeight;

    public ActionBarContainer(Context context) {
        this(context, null);
    }

    public ActionBarContainer(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        ViewCompat.setBackground(this, Build.VERSION.SDK_INT >= 21 ? new b(this) : new a(this));
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.ActionBar);
        this.Ix = obtainStyledAttributes.getDrawable(R.styleable.ActionBar_background);
        this.JZ = obtainStyledAttributes.getDrawable(R.styleable.ActionBar_backgroundStacked);
        this.mHeight = obtainStyledAttributes.getDimensionPixelSize(R.styleable.ActionBar_height, -1);
        if (getId() == R.id.split_action_bar) {
            this.Kb = true;
            this.Ka = obtainStyledAttributes.getDrawable(R.styleable.ActionBar_backgroundSplit);
        }
        obtainStyledAttributes.recycle();
        setWillNotDraw(this.Kb ? this.Ka == null : this.Ix == null && this.JZ == null);
    }

    @Override // android.view.View
    public void onFinishInflate() {
        super.onFinishInflate();
        this.JX = findViewById(R.id.action_bar);
        this.JY = findViewById(R.id.action_context_bar);
    }

    public void setPrimaryBackground(Drawable drawable) {
        boolean z = true;
        if (this.Ix != null) {
            this.Ix.setCallback(null);
            unscheduleDrawable(this.Ix);
        }
        this.Ix = drawable;
        if (drawable != null) {
            drawable.setCallback(this);
            if (this.JX != null) {
                this.Ix.setBounds(this.JX.getLeft(), this.JX.getTop(), this.JX.getRight(), this.JX.getBottom());
            }
        }
        if (this.Kb) {
            if (this.Ka != null) {
                z = false;
            }
        } else if (this.Ix != null || this.JZ != null) {
            z = false;
        }
        setWillNotDraw(z);
        invalidate();
    }

    public void setStackedBackground(Drawable drawable) {
        boolean z = true;
        if (this.JZ != null) {
            this.JZ.setCallback(null);
            unscheduleDrawable(this.JZ);
        }
        this.JZ = drawable;
        if (drawable != null) {
            drawable.setCallback(this);
            if (this.Kc && this.JZ != null) {
                this.JZ.setBounds(this.JW.getLeft(), this.JW.getTop(), this.JW.getRight(), this.JW.getBottom());
            }
        }
        if (this.Kb) {
            if (this.Ka != null) {
                z = false;
            }
        } else if (this.Ix != null || this.JZ != null) {
            z = false;
        }
        setWillNotDraw(z);
        invalidate();
    }

    public void setSplitBackground(Drawable drawable) {
        boolean z = true;
        if (this.Ka != null) {
            this.Ka.setCallback(null);
            unscheduleDrawable(this.Ka);
        }
        this.Ka = drawable;
        if (drawable != null) {
            drawable.setCallback(this);
            if (this.Kb && this.Ka != null) {
                this.Ka.setBounds(0, 0, getMeasuredWidth(), getMeasuredHeight());
            }
        }
        if (this.Kb) {
            if (this.Ka != null) {
                z = false;
            }
        } else if (this.Ix != null || this.JZ != null) {
            z = false;
        }
        setWillNotDraw(z);
        invalidate();
    }

    @Override // android.view.View
    public void setVisibility(int i) {
        super.setVisibility(i);
        boolean z = i == 0;
        if (this.Ix != null) {
            this.Ix.setVisible(z, false);
        }
        if (this.JZ != null) {
            this.JZ.setVisible(z, false);
        }
        if (this.Ka != null) {
            this.Ka.setVisible(z, false);
        }
    }

    @Override // android.view.View
    protected boolean verifyDrawable(Drawable drawable) {
        return (drawable == this.Ix && !this.Kb) || (drawable == this.JZ && this.Kc) || ((drawable == this.Ka && this.Kb) || super.verifyDrawable(drawable));
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        if (this.Ix != null && this.Ix.isStateful()) {
            this.Ix.setState(getDrawableState());
        }
        if (this.JZ != null && this.JZ.isStateful()) {
            this.JZ.setState(getDrawableState());
        }
        if (this.Ka != null && this.Ka.isStateful()) {
            this.Ka.setState(getDrawableState());
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void jumpDrawablesToCurrentState() {
        if (Build.VERSION.SDK_INT >= 11) {
            super.jumpDrawablesToCurrentState();
            if (this.Ix != null) {
                this.Ix.jumpToCurrentState();
            }
            if (this.JZ != null) {
                this.JZ.jumpToCurrentState();
            }
            if (this.Ka != null) {
                this.Ka.jumpToCurrentState();
            }
        }
    }

    public void setTransitioning(boolean z) {
        this.JV = z;
        setDescendantFocusability(z ? 393216 : 262144);
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        return this.JV || super.onInterceptTouchEvent(motionEvent);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        super.onTouchEvent(motionEvent);
        return true;
    }

    public void setTabContainer(ScrollingTabContainerView scrollingTabContainerView) {
        if (this.JW != null) {
            removeView(this.JW);
        }
        this.JW = scrollingTabContainerView;
        if (scrollingTabContainerView != null) {
            addView(scrollingTabContainerView);
            ViewGroup.LayoutParams layoutParams = scrollingTabContainerView.getLayoutParams();
            layoutParams.width = -1;
            layoutParams.height = -2;
            scrollingTabContainerView.setAllowCollapse(false);
        }
    }

    public View getTabContainer() {
        return this.JW;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public ActionMode startActionModeForChild(View view, ActionMode.Callback callback) {
        return null;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public ActionMode startActionModeForChild(View view, ActionMode.Callback callback, int i) {
        if (i != 0) {
            return super.startActionModeForChild(view, callback, i);
        }
        return null;
    }

    private boolean U(View view) {
        return view == null || view.getVisibility() == 8 || view.getMeasuredHeight() == 0;
    }

    private int V(View view) {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) view.getLayoutParams();
        return layoutParams.bottomMargin + view.getMeasuredHeight() + layoutParams.topMargin;
    }

    @Override // android.widget.FrameLayout, android.view.View
    public void onMeasure(int i, int i2) {
        int i3;
        if (this.JX == null && View.MeasureSpec.getMode(i2) == Integer.MIN_VALUE && this.mHeight >= 0) {
            i2 = View.MeasureSpec.makeMeasureSpec(Math.min(this.mHeight, View.MeasureSpec.getSize(i2)), Integer.MIN_VALUE);
        }
        super.onMeasure(i, i2);
        if (this.JX != null) {
            int mode = View.MeasureSpec.getMode(i2);
            if (this.JW != null && this.JW.getVisibility() != 8 && mode != 1073741824) {
                if (!U(this.JX)) {
                    i3 = V(this.JX);
                } else if (!U(this.JY)) {
                    i3 = V(this.JY);
                } else {
                    i3 = 0;
                }
                setMeasuredDimension(getMeasuredWidth(), Math.min(i3 + V(this.JW), mode == Integer.MIN_VALUE ? View.MeasureSpec.getSize(i2) : Integer.MAX_VALUE));
            }
        }
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        boolean z2;
        boolean z3 = true;
        super.onLayout(z, i, i2, i3, i4);
        View view = this.JW;
        boolean z4 = (view == null || view.getVisibility() == 8) ? false : true;
        if (view != null && view.getVisibility() != 8) {
            int measuredHeight = getMeasuredHeight();
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) view.getLayoutParams();
            view.layout(i, (measuredHeight - view.getMeasuredHeight()) - layoutParams.bottomMargin, i3, measuredHeight - layoutParams.bottomMargin);
        }
        if (this.Kb) {
            if (this.Ka != null) {
                this.Ka.setBounds(0, 0, getMeasuredWidth(), getMeasuredHeight());
            } else {
                z3 = false;
            }
        } else {
            if (this.Ix != null) {
                if (this.JX.getVisibility() == 0) {
                    this.Ix.setBounds(this.JX.getLeft(), this.JX.getTop(), this.JX.getRight(), this.JX.getBottom());
                } else if (this.JY != null && this.JY.getVisibility() == 0) {
                    this.Ix.setBounds(this.JY.getLeft(), this.JY.getTop(), this.JY.getRight(), this.JY.getBottom());
                } else {
                    this.Ix.setBounds(0, 0, 0, 0);
                }
                z2 = true;
            } else {
                z2 = false;
            }
            this.Kc = z4;
            if (!z4 || this.JZ == null) {
                z3 = z2;
            } else {
                this.JZ.setBounds(view.getLeft(), view.getTop(), view.getRight(), view.getBottom());
            }
        }
        if (z3) {
            invalidate();
        }
    }
}
