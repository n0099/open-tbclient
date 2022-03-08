package androidx.appcompat.widget;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.appcompat.R$attr;
import androidx.appcompat.R$id;
import androidx.appcompat.R$layout;
import androidx.appcompat.R$styleable;
import androidx.appcompat.view.ActionMode;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.core.view.InputDeviceCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.ViewPropertyAnimatorCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
/* loaded from: classes.dex */
public class ActionBarContextView extends AbsActionBarView {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public View mClose;
    public int mCloseItemLayout;
    public View mCustomView;
    public CharSequence mSubtitle;
    public int mSubtitleStyleRes;
    public TextView mSubtitleView;
    public CharSequence mTitle;
    public LinearLayout mTitleLayout;
    public boolean mTitleOptional;
    public int mTitleStyleRes;
    public TextView mTitleView;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ActionBarContextView(@NonNull Context context) {
        this(context, null);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    private void initTitle() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65539, this) == null) {
            if (this.mTitleLayout == null) {
                LayoutInflater.from(getContext()).inflate(R$layout.abc_action_bar_title_item, this);
                LinearLayout linearLayout = (LinearLayout) getChildAt(getChildCount() - 1);
                this.mTitleLayout = linearLayout;
                this.mTitleView = (TextView) linearLayout.findViewById(R$id.action_bar_title);
                this.mSubtitleView = (TextView) this.mTitleLayout.findViewById(R$id.action_bar_subtitle);
                if (this.mTitleStyleRes != 0) {
                    this.mTitleView.setTextAppearance(getContext(), this.mTitleStyleRes);
                }
                if (this.mSubtitleStyleRes != 0) {
                    this.mSubtitleView.setTextAppearance(getContext(), this.mSubtitleStyleRes);
                }
            }
            this.mTitleView.setText(this.mTitle);
            this.mSubtitleView.setText(this.mSubtitle);
            boolean z = !TextUtils.isEmpty(this.mTitle);
            boolean z2 = !TextUtils.isEmpty(this.mSubtitle);
            int i2 = 0;
            this.mSubtitleView.setVisibility(z2 ? 0 : 8);
            LinearLayout linearLayout2 = this.mTitleLayout;
            if (!z && !z2) {
                i2 = 8;
            }
            linearLayout2.setVisibility(i2);
            if (this.mTitleLayout.getParent() == null) {
                addView(this.mTitleLayout);
            }
        }
    }

    @Override // androidx.appcompat.widget.AbsActionBarView
    public /* bridge */ /* synthetic */ void animateToVisibility(int i2) {
        super.animateToVisibility(i2);
    }

    @Override // androidx.appcompat.widget.AbsActionBarView
    public /* bridge */ /* synthetic */ boolean canShowOverflowMenu() {
        return super.canShowOverflowMenu();
    }

    public void closeMode() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) && this.mClose == null) {
            killMode();
        }
    }

    @Override // androidx.appcompat.widget.AbsActionBarView
    public /* bridge */ /* synthetic */ void dismissPopupMenus() {
        super.dismissPopupMenus();
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateDefaultLayoutParams() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? new ViewGroup.MarginLayoutParams(-1, -2) : (ViewGroup.LayoutParams) invokeV.objValue;
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, attributeSet)) == null) ? new ViewGroup.MarginLayoutParams(getContext(), attributeSet) : (ViewGroup.LayoutParams) invokeL.objValue;
    }

    @Override // androidx.appcompat.widget.AbsActionBarView
    public /* bridge */ /* synthetic */ int getAnimatedVisibility() {
        return super.getAnimatedVisibility();
    }

    @Override // androidx.appcompat.widget.AbsActionBarView
    public /* bridge */ /* synthetic */ int getContentHeight() {
        return super.getContentHeight();
    }

    public CharSequence getSubtitle() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.mSubtitle : (CharSequence) invokeV.objValue;
    }

    public CharSequence getTitle() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.mTitle : (CharSequence) invokeV.objValue;
    }

    @Override // androidx.appcompat.widget.AbsActionBarView
    public boolean hideOverflowMenu() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            ActionMenuPresenter actionMenuPresenter = this.mActionMenuPresenter;
            if (actionMenuPresenter != null) {
                return actionMenuPresenter.hideOverflowMenu();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public void initForMode(ActionMode actionMode) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, actionMode) == null) {
            View view = this.mClose;
            if (view == null) {
                View inflate = LayoutInflater.from(getContext()).inflate(this.mCloseItemLayout, (ViewGroup) this, false);
                this.mClose = inflate;
                addView(inflate);
            } else if (view.getParent() == null) {
                addView(this.mClose);
            }
            this.mClose.findViewById(R$id.action_mode_close_button).setOnClickListener(new View.OnClickListener(this, actionMode) { // from class: androidx.appcompat.widget.ActionBarContextView.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ ActionBarContextView this$0;
                public final /* synthetic */ ActionMode val$mode;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, actionMode};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.this$0 = this;
                    this.val$mode = actionMode;
                }

                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, view2) == null) {
                        this.val$mode.finish();
                    }
                }
            });
            MenuBuilder menuBuilder = (MenuBuilder) actionMode.getMenu();
            ActionMenuPresenter actionMenuPresenter = this.mActionMenuPresenter;
            if (actionMenuPresenter != null) {
                actionMenuPresenter.dismissPopupMenus();
            }
            ActionMenuPresenter actionMenuPresenter2 = new ActionMenuPresenter(getContext());
            this.mActionMenuPresenter = actionMenuPresenter2;
            actionMenuPresenter2.setReserveOverflow(true);
            ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(-2, -1);
            menuBuilder.addMenuPresenter(this.mActionMenuPresenter, this.mPopupContext);
            ActionMenuView actionMenuView = (ActionMenuView) this.mActionMenuPresenter.getMenuView(this);
            this.mMenuView = actionMenuView;
            ViewCompat.setBackground(actionMenuView, null);
            addView(this.mMenuView, layoutParams);
        }
    }

    @Override // androidx.appcompat.widget.AbsActionBarView
    public /* bridge */ /* synthetic */ boolean isOverflowMenuShowPending() {
        return super.isOverflowMenuShowPending();
    }

    @Override // androidx.appcompat.widget.AbsActionBarView
    public boolean isOverflowMenuShowing() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            ActionMenuPresenter actionMenuPresenter = this.mActionMenuPresenter;
            if (actionMenuPresenter != null) {
                return actionMenuPresenter.isOverflowMenuShowing();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // androidx.appcompat.widget.AbsActionBarView
    public /* bridge */ /* synthetic */ boolean isOverflowReserved() {
        return super.isOverflowReserved();
    }

    public boolean isTitleOptional() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? this.mTitleOptional : invokeV.booleanValue;
    }

    public void killMode() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            removeAllViews();
            this.mCustomView = null;
            this.mMenuView = null;
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            super.onDetachedFromWindow();
            ActionMenuPresenter actionMenuPresenter = this.mActionMenuPresenter;
            if (actionMenuPresenter != null) {
                actionMenuPresenter.hideOverflowMenu();
                this.mActionMenuPresenter.hideSubMenus();
            }
        }
    }

    @Override // androidx.appcompat.widget.AbsActionBarView, android.view.View
    public /* bridge */ /* synthetic */ boolean onHoverEvent(MotionEvent motionEvent) {
        return super.onHoverEvent(motionEvent);
    }

    @Override // android.view.View
    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, accessibilityEvent) == null) {
            if (accessibilityEvent.getEventType() == 32) {
                accessibilityEvent.setSource(this);
                accessibilityEvent.setClassName(ActionBarContextView.class.getName());
                accessibilityEvent.setPackageName(getContext().getPackageName());
                accessibilityEvent.setContentDescription(this.mTitle);
                return;
            }
            super.onInitializeAccessibilityEvent(accessibilityEvent);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048596, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5)}) == null) {
            boolean isLayoutRtl = ViewUtils.isLayoutRtl(this);
            int paddingRight = isLayoutRtl ? (i4 - i2) - getPaddingRight() : getPaddingLeft();
            int paddingTop = getPaddingTop();
            int paddingTop2 = ((i5 - i3) - getPaddingTop()) - getPaddingBottom();
            View view = this.mClose;
            if (view != null && view.getVisibility() != 8) {
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.mClose.getLayoutParams();
                int i6 = isLayoutRtl ? marginLayoutParams.rightMargin : marginLayoutParams.leftMargin;
                int i7 = isLayoutRtl ? marginLayoutParams.leftMargin : marginLayoutParams.rightMargin;
                int next = AbsActionBarView.next(paddingRight, i6, isLayoutRtl);
                paddingRight = AbsActionBarView.next(next + positionChild(this.mClose, next, paddingTop, paddingTop2, isLayoutRtl), i7, isLayoutRtl);
            }
            int i8 = paddingRight;
            LinearLayout linearLayout = this.mTitleLayout;
            if (linearLayout != null && this.mCustomView == null && linearLayout.getVisibility() != 8) {
                i8 += positionChild(this.mTitleLayout, i8, paddingTop, paddingTop2, isLayoutRtl);
            }
            int i9 = i8;
            View view2 = this.mCustomView;
            if (view2 != null) {
                positionChild(view2, i9, paddingTop, paddingTop2, isLayoutRtl);
            }
            int paddingLeft = isLayoutRtl ? getPaddingLeft() : (i4 - i2) - getPaddingRight();
            ActionMenuView actionMenuView = this.mMenuView;
            if (actionMenuView != null) {
                positionChild(actionMenuView, paddingLeft, paddingTop, paddingTop2, !isLayoutRtl);
            }
        }
    }

    @Override // android.view.View
    public void onMeasure(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048597, this, i2, i3) == null) {
            if (View.MeasureSpec.getMode(i2) == 1073741824) {
                if (View.MeasureSpec.getMode(i3) != 0) {
                    int size = View.MeasureSpec.getSize(i2);
                    int i4 = this.mContentHeight;
                    if (i4 <= 0) {
                        i4 = View.MeasureSpec.getSize(i3);
                    }
                    int paddingTop = getPaddingTop() + getPaddingBottom();
                    int paddingLeft = (size - getPaddingLeft()) - getPaddingRight();
                    int i5 = i4 - paddingTop;
                    int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(i5, Integer.MIN_VALUE);
                    View view = this.mClose;
                    if (view != null) {
                        int measureChildView = measureChildView(view, paddingLeft, makeMeasureSpec, 0);
                        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.mClose.getLayoutParams();
                        paddingLeft = measureChildView - (marginLayoutParams.leftMargin + marginLayoutParams.rightMargin);
                    }
                    ActionMenuView actionMenuView = this.mMenuView;
                    if (actionMenuView != null && actionMenuView.getParent() == this) {
                        paddingLeft = measureChildView(this.mMenuView, paddingLeft, makeMeasureSpec, 0);
                    }
                    LinearLayout linearLayout = this.mTitleLayout;
                    if (linearLayout != null && this.mCustomView == null) {
                        if (this.mTitleOptional) {
                            this.mTitleLayout.measure(View.MeasureSpec.makeMeasureSpec(0, 0), makeMeasureSpec);
                            int measuredWidth = this.mTitleLayout.getMeasuredWidth();
                            boolean z = measuredWidth <= paddingLeft;
                            if (z) {
                                paddingLeft -= measuredWidth;
                            }
                            this.mTitleLayout.setVisibility(z ? 0 : 8);
                        } else {
                            paddingLeft = measureChildView(linearLayout, paddingLeft, makeMeasureSpec, 0);
                        }
                    }
                    View view2 = this.mCustomView;
                    if (view2 != null) {
                        ViewGroup.LayoutParams layoutParams = view2.getLayoutParams();
                        int i6 = layoutParams.width != -2 ? 1073741824 : Integer.MIN_VALUE;
                        int i7 = layoutParams.width;
                        if (i7 >= 0) {
                            paddingLeft = Math.min(i7, paddingLeft);
                        }
                        int i8 = layoutParams.height == -2 ? Integer.MIN_VALUE : 1073741824;
                        int i9 = layoutParams.height;
                        if (i9 >= 0) {
                            i5 = Math.min(i9, i5);
                        }
                        this.mCustomView.measure(View.MeasureSpec.makeMeasureSpec(paddingLeft, i6), View.MeasureSpec.makeMeasureSpec(i5, i8));
                    }
                    if (this.mContentHeight <= 0) {
                        int childCount = getChildCount();
                        int i10 = 0;
                        for (int i11 = 0; i11 < childCount; i11++) {
                            int measuredHeight = getChildAt(i11).getMeasuredHeight() + paddingTop;
                            if (measuredHeight > i10) {
                                i10 = measuredHeight;
                            }
                        }
                        setMeasuredDimension(size, i10);
                        return;
                    }
                    setMeasuredDimension(size, i4);
                    return;
                }
                throw new IllegalStateException(ActionBarContextView.class.getSimpleName() + " can only be used with android:layout_height=\"wrap_content\"");
            }
            throw new IllegalStateException(ActionBarContextView.class.getSimpleName() + " can only be used with android:layout_width=\"match_parent\" (or fill_parent)");
        }
    }

    @Override // androidx.appcompat.widget.AbsActionBarView, android.view.View
    public /* bridge */ /* synthetic */ boolean onTouchEvent(MotionEvent motionEvent) {
        return super.onTouchEvent(motionEvent);
    }

    @Override // androidx.appcompat.widget.AbsActionBarView
    public /* bridge */ /* synthetic */ void postShowOverflowMenu() {
        super.postShowOverflowMenu();
    }

    @Override // androidx.appcompat.widget.AbsActionBarView
    public void setContentHeight(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048600, this, i2) == null) {
            this.mContentHeight = i2;
        }
    }

    public void setCustomView(View view) {
        LinearLayout linearLayout;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048601, this, view) == null) {
            View view2 = this.mCustomView;
            if (view2 != null) {
                removeView(view2);
            }
            this.mCustomView = view;
            if (view != null && (linearLayout = this.mTitleLayout) != null) {
                removeView(linearLayout);
                this.mTitleLayout = null;
            }
            if (view != null) {
                addView(view);
            }
            requestLayout();
        }
    }

    public void setSubtitle(CharSequence charSequence) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048602, this, charSequence) == null) {
            this.mSubtitle = charSequence;
            initTitle();
        }
    }

    public void setTitle(CharSequence charSequence) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048603, this, charSequence) == null) {
            this.mTitle = charSequence;
            initTitle();
        }
    }

    public void setTitleOptional(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048604, this, z) == null) {
            if (z != this.mTitleOptional) {
                requestLayout();
            }
            this.mTitleOptional = z;
        }
    }

    @Override // androidx.appcompat.widget.AbsActionBarView, android.view.View
    public /* bridge */ /* synthetic */ void setVisibility(int i2) {
        super.setVisibility(i2);
    }

    @Override // androidx.appcompat.widget.AbsActionBarView
    public /* bridge */ /* synthetic */ ViewPropertyAnimatorCompat setupAnimatorToVisibility(int i2, long j2) {
        return super.setupAnimatorToVisibility(i2, j2);
    }

    @Override // android.view.ViewGroup
    public boolean shouldDelayChildPressedState() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048607, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // androidx.appcompat.widget.AbsActionBarView
    public boolean showOverflowMenu() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048608, this)) == null) {
            ActionMenuPresenter actionMenuPresenter = this.mActionMenuPresenter;
            if (actionMenuPresenter != null) {
                return actionMenuPresenter.showOverflowMenu();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ActionBarContextView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, R$attr.actionModeStyle);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ActionBarContextView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet, Integer.valueOf(i2)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        TintTypedArray obtainStyledAttributes = TintTypedArray.obtainStyledAttributes(context, attributeSet, R$styleable.ActionMode, i2, 0);
        ViewCompat.setBackground(this, obtainStyledAttributes.getDrawable(R$styleable.ActionMode_background));
        this.mTitleStyleRes = obtainStyledAttributes.getResourceId(R$styleable.ActionMode_titleTextStyle, 0);
        this.mSubtitleStyleRes = obtainStyledAttributes.getResourceId(R$styleable.ActionMode_subtitleTextStyle, 0);
        this.mContentHeight = obtainStyledAttributes.getLayoutDimension(R$styleable.ActionMode_height, 0);
        this.mCloseItemLayout = obtainStyledAttributes.getResourceId(R$styleable.ActionMode_closeItemLayout, R$layout.abc_action_mode_close_item_material);
        obtainStyledAttributes.recycle();
    }
}
