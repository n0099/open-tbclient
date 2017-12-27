package android.support.v7.widget;

import android.content.Context;
import android.os.Build;
import android.support.annotation.RestrictTo;
import android.support.v4.view.ViewCompat;
import android.support.v4.view.ViewPropertyAnimatorCompat;
import android.support.v7.appcompat.R;
import android.support.v7.view.ActionMode;
import android.support.v7.view.menu.MenuBuilder;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.widget.LinearLayout;
import android.widget.TextView;
@RestrictTo
/* loaded from: classes2.dex */
public class ActionBarContextView extends AbsActionBarView {
    private View Kd;
    private LinearLayout Ke;
    private TextView Kf;
    private int Kg;
    private int Kh;
    private boolean Ki;
    private int Kj;
    private View mCustomView;
    private CharSequence mTitle;
    private TextView mTitleView;
    private CharSequence ym;

    @Override // android.support.v7.widget.AbsActionBarView
    public /* bridge */ /* synthetic */ void animateToVisibility(int i) {
        super.animateToVisibility(i);
    }

    @Override // android.support.v7.widget.AbsActionBarView
    public /* bridge */ /* synthetic */ boolean canShowOverflowMenu() {
        return super.canShowOverflowMenu();
    }

    @Override // android.support.v7.widget.AbsActionBarView
    public /* bridge */ /* synthetic */ void dismissPopupMenus() {
        super.dismissPopupMenus();
    }

    @Override // android.support.v7.widget.AbsActionBarView
    public /* bridge */ /* synthetic */ int getAnimatedVisibility() {
        return super.getAnimatedVisibility();
    }

    @Override // android.support.v7.widget.AbsActionBarView
    public /* bridge */ /* synthetic */ int getContentHeight() {
        return super.getContentHeight();
    }

    @Override // android.support.v7.widget.AbsActionBarView
    public /* bridge */ /* synthetic */ boolean isOverflowMenuShowPending() {
        return super.isOverflowMenuShowPending();
    }

    @Override // android.support.v7.widget.AbsActionBarView
    public /* bridge */ /* synthetic */ boolean isOverflowReserved() {
        return super.isOverflowReserved();
    }

    @Override // android.support.v7.widget.AbsActionBarView, android.view.View
    public /* bridge */ /* synthetic */ boolean onHoverEvent(MotionEvent motionEvent) {
        return super.onHoverEvent(motionEvent);
    }

    @Override // android.support.v7.widget.AbsActionBarView, android.view.View
    public /* bridge */ /* synthetic */ boolean onTouchEvent(MotionEvent motionEvent) {
        return super.onTouchEvent(motionEvent);
    }

    @Override // android.support.v7.widget.AbsActionBarView
    public /* bridge */ /* synthetic */ void postShowOverflowMenu() {
        super.postShowOverflowMenu();
    }

    @Override // android.support.v7.widget.AbsActionBarView, android.view.View
    public /* bridge */ /* synthetic */ void setVisibility(int i) {
        super.setVisibility(i);
    }

    @Override // android.support.v7.widget.AbsActionBarView
    public /* bridge */ /* synthetic */ ViewPropertyAnimatorCompat setupAnimatorToVisibility(int i, long j) {
        return super.setupAnimatorToVisibility(i, j);
    }

    public ActionBarContextView(Context context) {
        this(context, null);
    }

    public ActionBarContextView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.actionModeStyle);
    }

    public ActionBarContextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        TintTypedArray obtainStyledAttributes = TintTypedArray.obtainStyledAttributes(context, attributeSet, R.styleable.ActionMode, i, 0);
        ViewCompat.setBackground(this, obtainStyledAttributes.getDrawable(R.styleable.ActionMode_background));
        this.Kg = obtainStyledAttributes.getResourceId(R.styleable.ActionMode_titleTextStyle, 0);
        this.Kh = obtainStyledAttributes.getResourceId(R.styleable.ActionMode_subtitleTextStyle, 0);
        this.mContentHeight = obtainStyledAttributes.getLayoutDimension(R.styleable.ActionMode_height, 0);
        this.Kj = obtainStyledAttributes.getResourceId(R.styleable.ActionMode_closeItemLayout, R.layout.abc_action_mode_close_item_material);
        obtainStyledAttributes.recycle();
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.mActionMenuPresenter != null) {
            this.mActionMenuPresenter.hideOverflowMenu();
            this.mActionMenuPresenter.fm();
        }
    }

    @Override // android.support.v7.widget.AbsActionBarView
    public void setContentHeight(int i) {
        this.mContentHeight = i;
    }

    public void setCustomView(View view) {
        if (this.mCustomView != null) {
            removeView(this.mCustomView);
        }
        this.mCustomView = view;
        if (view != null && this.Ke != null) {
            removeView(this.Ke);
            this.Ke = null;
        }
        if (view != null) {
            addView(view);
        }
        requestLayout();
    }

    public void setTitle(CharSequence charSequence) {
        this.mTitle = charSequence;
        fe();
    }

    public void setSubtitle(CharSequence charSequence) {
        this.ym = charSequence;
        fe();
    }

    public CharSequence getTitle() {
        return this.mTitle;
    }

    public CharSequence getSubtitle() {
        return this.ym;
    }

    private void fe() {
        int i = 8;
        if (this.Ke == null) {
            LayoutInflater.from(getContext()).inflate(R.layout.abc_action_bar_title_item, this);
            this.Ke = (LinearLayout) getChildAt(getChildCount() - 1);
            this.mTitleView = (TextView) this.Ke.findViewById(R.id.action_bar_title);
            this.Kf = (TextView) this.Ke.findViewById(R.id.action_bar_subtitle);
            if (this.Kg != 0) {
                this.mTitleView.setTextAppearance(getContext(), this.Kg);
            }
            if (this.Kh != 0) {
                this.Kf.setTextAppearance(getContext(), this.Kh);
            }
        }
        this.mTitleView.setText(this.mTitle);
        this.Kf.setText(this.ym);
        boolean z = !TextUtils.isEmpty(this.mTitle);
        boolean z2 = TextUtils.isEmpty(this.ym) ? false : true;
        this.Kf.setVisibility(z2 ? 0 : 8);
        LinearLayout linearLayout = this.Ke;
        if (z || z2) {
            i = 0;
        }
        linearLayout.setVisibility(i);
        if (this.Ke.getParent() == null) {
            addView(this.Ke);
        }
    }

    public void initForMode(final ActionMode actionMode) {
        if (this.Kd == null) {
            this.Kd = LayoutInflater.from(getContext()).inflate(this.Kj, (ViewGroup) this, false);
            addView(this.Kd);
        } else if (this.Kd.getParent() == null) {
            addView(this.Kd);
        }
        this.Kd.findViewById(R.id.action_mode_close_button).setOnClickListener(new View.OnClickListener() { // from class: android.support.v7.widget.ActionBarContextView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                actionMode.finish();
            }
        });
        MenuBuilder menuBuilder = (MenuBuilder) actionMode.getMenu();
        if (this.mActionMenuPresenter != null) {
            this.mActionMenuPresenter.fl();
        }
        this.mActionMenuPresenter = new ActionMenuPresenter(getContext());
        this.mActionMenuPresenter.D(true);
        ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(-2, -1);
        menuBuilder.addMenuPresenter(this.mActionMenuPresenter, this.mPopupContext);
        this.mMenuView = (ActionMenuView) this.mActionMenuPresenter.getMenuView(this);
        ViewCompat.setBackground(this.mMenuView, null);
        addView(this.mMenuView, layoutParams);
    }

    public void closeMode() {
        if (this.Kd == null) {
            killMode();
        }
    }

    public void killMode() {
        removeAllViews();
        this.mCustomView = null;
        this.mMenuView = null;
    }

    @Override // android.support.v7.widget.AbsActionBarView
    public boolean showOverflowMenu() {
        if (this.mActionMenuPresenter != null) {
            return this.mActionMenuPresenter.showOverflowMenu();
        }
        return false;
    }

    @Override // android.support.v7.widget.AbsActionBarView
    public boolean hideOverflowMenu() {
        if (this.mActionMenuPresenter != null) {
            return this.mActionMenuPresenter.hideOverflowMenu();
        }
        return false;
    }

    @Override // android.support.v7.widget.AbsActionBarView
    public boolean isOverflowMenuShowing() {
        if (this.mActionMenuPresenter != null) {
            return this.mActionMenuPresenter.isOverflowMenuShowing();
        }
        return false;
    }

    @Override // android.view.ViewGroup
    protected ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new ViewGroup.MarginLayoutParams(-1, -2);
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new ViewGroup.MarginLayoutParams(getContext(), attributeSet);
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        int i3 = 0;
        if (View.MeasureSpec.getMode(i) != 1073741824) {
            throw new IllegalStateException(getClass().getSimpleName() + " can only be used with android:layout_width=\"match_parent\" (or fill_parent)");
        }
        if (View.MeasureSpec.getMode(i2) == 0) {
            throw new IllegalStateException(getClass().getSimpleName() + " can only be used with android:layout_height=\"wrap_content\"");
        }
        int size = View.MeasureSpec.getSize(i);
        int size2 = this.mContentHeight > 0 ? this.mContentHeight : View.MeasureSpec.getSize(i2);
        int paddingTop = getPaddingTop() + getPaddingBottom();
        int paddingLeft = (size - getPaddingLeft()) - getPaddingRight();
        int i4 = size2 - paddingTop;
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(i4, Integer.MIN_VALUE);
        if (this.Kd != null) {
            int measureChildView = measureChildView(this.Kd, paddingLeft, makeMeasureSpec, 0);
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.Kd.getLayoutParams();
            paddingLeft = measureChildView - (marginLayoutParams.rightMargin + marginLayoutParams.leftMargin);
        }
        if (this.mMenuView != null && this.mMenuView.getParent() == this) {
            paddingLeft = measureChildView(this.mMenuView, paddingLeft, makeMeasureSpec, 0);
        }
        if (this.Ke != null && this.mCustomView == null) {
            if (this.Ki) {
                this.Ke.measure(View.MeasureSpec.makeMeasureSpec(0, 0), makeMeasureSpec);
                int measuredWidth = this.Ke.getMeasuredWidth();
                boolean z = measuredWidth <= paddingLeft;
                if (z) {
                    paddingLeft -= measuredWidth;
                }
                this.Ke.setVisibility(z ? 0 : 8);
            } else {
                paddingLeft = measureChildView(this.Ke, paddingLeft, makeMeasureSpec, 0);
            }
        }
        if (this.mCustomView != null) {
            ViewGroup.LayoutParams layoutParams = this.mCustomView.getLayoutParams();
            int i5 = layoutParams.width != -2 ? 1073741824 : Integer.MIN_VALUE;
            if (layoutParams.width >= 0) {
                paddingLeft = Math.min(layoutParams.width, paddingLeft);
            }
            this.mCustomView.measure(View.MeasureSpec.makeMeasureSpec(paddingLeft, i5), View.MeasureSpec.makeMeasureSpec(layoutParams.height >= 0 ? Math.min(layoutParams.height, i4) : i4, layoutParams.height == -2 ? Integer.MIN_VALUE : 1073741824));
        }
        if (this.mContentHeight <= 0) {
            int childCount = getChildCount();
            int i6 = 0;
            while (i3 < childCount) {
                int measuredHeight = getChildAt(i3).getMeasuredHeight() + paddingTop;
                if (measuredHeight <= i6) {
                    measuredHeight = i6;
                }
                i3++;
                i6 = measuredHeight;
            }
            setMeasuredDimension(size, i6);
            return;
        }
        setMeasuredDimension(size, size2);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int i5;
        boolean isLayoutRtl = ViewUtils.isLayoutRtl(this);
        int paddingRight = isLayoutRtl ? (i3 - i) - getPaddingRight() : getPaddingLeft();
        int paddingTop = getPaddingTop();
        int paddingTop2 = ((i4 - i2) - getPaddingTop()) - getPaddingBottom();
        if (this.Kd == null || this.Kd.getVisibility() == 8) {
            i5 = paddingRight;
        } else {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.Kd.getLayoutParams();
            int i6 = isLayoutRtl ? marginLayoutParams.rightMargin : marginLayoutParams.leftMargin;
            int i7 = isLayoutRtl ? marginLayoutParams.leftMargin : marginLayoutParams.rightMargin;
            int next = next(paddingRight, i6, isLayoutRtl);
            i5 = next(positionChild(this.Kd, next, paddingTop, paddingTop2, isLayoutRtl) + next, i7, isLayoutRtl);
        }
        if (this.Ke != null && this.mCustomView == null && this.Ke.getVisibility() != 8) {
            i5 += positionChild(this.Ke, i5, paddingTop, paddingTop2, isLayoutRtl);
        }
        if (this.mCustomView != null) {
            int positionChild = positionChild(this.mCustomView, i5, paddingTop, paddingTop2, isLayoutRtl) + i5;
        }
        int paddingLeft = isLayoutRtl ? getPaddingLeft() : (i3 - i) - getPaddingRight();
        if (this.mMenuView != null) {
            int positionChild2 = positionChild(this.mMenuView, paddingLeft, paddingTop, paddingTop2, !isLayoutRtl) + paddingLeft;
        }
    }

    @Override // android.view.ViewGroup
    public boolean shouldDelayChildPressedState() {
        return false;
    }

    @Override // android.view.View
    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        if (Build.VERSION.SDK_INT >= 14) {
            if (accessibilityEvent.getEventType() == 32) {
                accessibilityEvent.setSource(this);
                accessibilityEvent.setClassName(getClass().getName());
                accessibilityEvent.setPackageName(getContext().getPackageName());
                accessibilityEvent.setContentDescription(this.mTitle);
                return;
            }
            super.onInitializeAccessibilityEvent(accessibilityEvent);
        }
    }

    public void setTitleOptional(boolean z) {
        if (z != this.Ki) {
            requestLayout();
        }
        this.Ki = z;
    }

    public boolean isTitleOptional() {
        return this.Ki;
    }
}
