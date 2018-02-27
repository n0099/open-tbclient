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
    Drawable Ir;
    private boolean JP;
    private View JQ;
    private View JR;
    private View JS;
    Drawable JT;
    Drawable JU;
    boolean JV;
    boolean JW;
    private int mHeight;

    public ActionBarContainer(Context context) {
        this(context, null);
    }

    public ActionBarContainer(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        ViewCompat.setBackground(this, Build.VERSION.SDK_INT >= 21 ? new b(this) : new a(this));
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.ActionBar);
        this.Ir = obtainStyledAttributes.getDrawable(R.styleable.ActionBar_background);
        this.JT = obtainStyledAttributes.getDrawable(R.styleable.ActionBar_backgroundStacked);
        this.mHeight = obtainStyledAttributes.getDimensionPixelSize(R.styleable.ActionBar_height, -1);
        if (getId() == R.id.split_action_bar) {
            this.JV = true;
            this.JU = obtainStyledAttributes.getDrawable(R.styleable.ActionBar_backgroundSplit);
        }
        obtainStyledAttributes.recycle();
        setWillNotDraw(this.JV ? this.JU == null : this.Ir == null && this.JT == null);
    }

    @Override // android.view.View
    public void onFinishInflate() {
        super.onFinishInflate();
        this.JR = findViewById(R.id.action_bar);
        this.JS = findViewById(R.id.action_context_bar);
    }

    public void setPrimaryBackground(Drawable drawable) {
        boolean z = true;
        if (this.Ir != null) {
            this.Ir.setCallback(null);
            unscheduleDrawable(this.Ir);
        }
        this.Ir = drawable;
        if (drawable != null) {
            drawable.setCallback(this);
            if (this.JR != null) {
                this.Ir.setBounds(this.JR.getLeft(), this.JR.getTop(), this.JR.getRight(), this.JR.getBottom());
            }
        }
        if (this.JV) {
            if (this.JU != null) {
                z = false;
            }
        } else if (this.Ir != null || this.JT != null) {
            z = false;
        }
        setWillNotDraw(z);
        invalidate();
    }

    public void setStackedBackground(Drawable drawable) {
        boolean z = true;
        if (this.JT != null) {
            this.JT.setCallback(null);
            unscheduleDrawable(this.JT);
        }
        this.JT = drawable;
        if (drawable != null) {
            drawable.setCallback(this);
            if (this.JW && this.JT != null) {
                this.JT.setBounds(this.JQ.getLeft(), this.JQ.getTop(), this.JQ.getRight(), this.JQ.getBottom());
            }
        }
        if (this.JV) {
            if (this.JU != null) {
                z = false;
            }
        } else if (this.Ir != null || this.JT != null) {
            z = false;
        }
        setWillNotDraw(z);
        invalidate();
    }

    public void setSplitBackground(Drawable drawable) {
        boolean z = true;
        if (this.JU != null) {
            this.JU.setCallback(null);
            unscheduleDrawable(this.JU);
        }
        this.JU = drawable;
        if (drawable != null) {
            drawable.setCallback(this);
            if (this.JV && this.JU != null) {
                this.JU.setBounds(0, 0, getMeasuredWidth(), getMeasuredHeight());
            }
        }
        if (this.JV) {
            if (this.JU != null) {
                z = false;
            }
        } else if (this.Ir != null || this.JT != null) {
            z = false;
        }
        setWillNotDraw(z);
        invalidate();
    }

    @Override // android.view.View
    public void setVisibility(int i) {
        super.setVisibility(i);
        boolean z = i == 0;
        if (this.Ir != null) {
            this.Ir.setVisible(z, false);
        }
        if (this.JT != null) {
            this.JT.setVisible(z, false);
        }
        if (this.JU != null) {
            this.JU.setVisible(z, false);
        }
    }

    @Override // android.view.View
    protected boolean verifyDrawable(Drawable drawable) {
        return (drawable == this.Ir && !this.JV) || (drawable == this.JT && this.JW) || ((drawable == this.JU && this.JV) || super.verifyDrawable(drawable));
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        if (this.Ir != null && this.Ir.isStateful()) {
            this.Ir.setState(getDrawableState());
        }
        if (this.JT != null && this.JT.isStateful()) {
            this.JT.setState(getDrawableState());
        }
        if (this.JU != null && this.JU.isStateful()) {
            this.JU.setState(getDrawableState());
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void jumpDrawablesToCurrentState() {
        if (Build.VERSION.SDK_INT >= 11) {
            super.jumpDrawablesToCurrentState();
            if (this.Ir != null) {
                this.Ir.jumpToCurrentState();
            }
            if (this.JT != null) {
                this.JT.jumpToCurrentState();
            }
            if (this.JU != null) {
                this.JU.jumpToCurrentState();
            }
        }
    }

    public void setTransitioning(boolean z) {
        this.JP = z;
        setDescendantFocusability(z ? 393216 : 262144);
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        return this.JP || super.onInterceptTouchEvent(motionEvent);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        super.onTouchEvent(motionEvent);
        return true;
    }

    public void setTabContainer(ScrollingTabContainerView scrollingTabContainerView) {
        if (this.JQ != null) {
            removeView(this.JQ);
        }
        this.JQ = scrollingTabContainerView;
        if (scrollingTabContainerView != null) {
            addView(scrollingTabContainerView);
            ViewGroup.LayoutParams layoutParams = scrollingTabContainerView.getLayoutParams();
            layoutParams.width = -1;
            layoutParams.height = -2;
            scrollingTabContainerView.setAllowCollapse(false);
        }
    }

    public View getTabContainer() {
        return this.JQ;
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
        if (this.JR == null && View.MeasureSpec.getMode(i2) == Integer.MIN_VALUE && this.mHeight >= 0) {
            i2 = View.MeasureSpec.makeMeasureSpec(Math.min(this.mHeight, View.MeasureSpec.getSize(i2)), Integer.MIN_VALUE);
        }
        super.onMeasure(i, i2);
        if (this.JR != null) {
            int mode = View.MeasureSpec.getMode(i2);
            if (this.JQ != null && this.JQ.getVisibility() != 8 && mode != 1073741824) {
                if (!U(this.JR)) {
                    i3 = V(this.JR);
                } else if (!U(this.JS)) {
                    i3 = V(this.JS);
                } else {
                    i3 = 0;
                }
                setMeasuredDimension(getMeasuredWidth(), Math.min(i3 + V(this.JQ), mode == Integer.MIN_VALUE ? View.MeasureSpec.getSize(i2) : Integer.MAX_VALUE));
            }
        }
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        boolean z2;
        boolean z3 = true;
        super.onLayout(z, i, i2, i3, i4);
        View view = this.JQ;
        boolean z4 = (view == null || view.getVisibility() == 8) ? false : true;
        if (view != null && view.getVisibility() != 8) {
            int measuredHeight = getMeasuredHeight();
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) view.getLayoutParams();
            view.layout(i, (measuredHeight - view.getMeasuredHeight()) - layoutParams.bottomMargin, i3, measuredHeight - layoutParams.bottomMargin);
        }
        if (this.JV) {
            if (this.JU != null) {
                this.JU.setBounds(0, 0, getMeasuredWidth(), getMeasuredHeight());
            } else {
                z3 = false;
            }
        } else {
            if (this.Ir != null) {
                if (this.JR.getVisibility() == 0) {
                    this.Ir.setBounds(this.JR.getLeft(), this.JR.getTop(), this.JR.getRight(), this.JR.getBottom());
                } else if (this.JS != null && this.JS.getVisibility() == 0) {
                    this.Ir.setBounds(this.JS.getLeft(), this.JS.getTop(), this.JS.getRight(), this.JS.getBottom());
                } else {
                    this.Ir.setBounds(0, 0, 0, 0);
                }
                z2 = true;
            } else {
                z2 = false;
            }
            this.JW = z4;
            if (!z4 || this.JT == null) {
                z3 = z2;
            } else {
                this.JT.setBounds(view.getLeft(), view.getTop(), view.getRight(), view.getBottom());
            }
        }
        if (z3) {
            invalidate();
        }
    }
}
