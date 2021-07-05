package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.view.ActionMode;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.annotation.RestrictTo;
import androidx.appcompat.R;
import androidx.core.view.InputDeviceCompat;
import androidx.core.view.ViewCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
/* loaded from: classes.dex */
public class ActionBarContainer extends FrameLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public View mActionBarView;
    public Drawable mBackground;
    public View mContextView;
    public int mHeight;
    public boolean mIsSplit;
    public boolean mIsStacked;
    public boolean mIsTransitioning;
    public Drawable mSplitBackground;
    public Drawable mStackedBackground;
    public View mTabContainer;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ActionBarContainer(Context context) {
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

    private int getMeasuredHeightWithMargins(View view) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, this, view)) == null) {
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) view.getLayoutParams();
            return view.getMeasuredHeight() + layoutParams.topMargin + layoutParams.bottomMargin;
        }
        return invokeL.intValue;
    }

    private boolean isCollapsed(View view) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65539, this, view)) == null) ? view == null || view.getVisibility() == 8 || view.getMeasuredHeight() == 0 : invokeL.booleanValue;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void drawableStateChanged() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            super.drawableStateChanged();
            Drawable drawable = this.mBackground;
            if (drawable != null && drawable.isStateful()) {
                this.mBackground.setState(getDrawableState());
            }
            Drawable drawable2 = this.mStackedBackground;
            if (drawable2 != null && drawable2.isStateful()) {
                this.mStackedBackground.setState(getDrawableState());
            }
            Drawable drawable3 = this.mSplitBackground;
            if (drawable3 == null || !drawable3.isStateful()) {
                return;
            }
            this.mSplitBackground.setState(getDrawableState());
        }
    }

    public View getTabContainer() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.mTabContainer : (View) invokeV.objValue;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void jumpDrawablesToCurrentState() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            super.jumpDrawablesToCurrentState();
            Drawable drawable = this.mBackground;
            if (drawable != null) {
                drawable.jumpToCurrentState();
            }
            Drawable drawable2 = this.mStackedBackground;
            if (drawable2 != null) {
                drawable2.jumpToCurrentState();
            }
            Drawable drawable3 = this.mSplitBackground;
            if (drawable3 != null) {
                drawable3.jumpToCurrentState();
            }
        }
    }

    @Override // android.view.View
    public void onFinishInflate() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            super.onFinishInflate();
            this.mActionBarView = findViewById(R.id.action_bar);
            this.mContextView = findViewById(R.id.action_context_bar);
        }
    }

    @Override // android.view.View
    public boolean onHoverEvent(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, motionEvent)) == null) {
            super.onHoverEvent(motionEvent);
            return true;
        }
        return invokeL.booleanValue;
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, motionEvent)) == null) ? this.mIsTransitioning || super.onInterceptTouchEvent(motionEvent) : invokeL.booleanValue;
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        Drawable drawable;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048582, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5)}) == null) {
            super.onLayout(z, i2, i3, i4, i5);
            View view = this.mTabContainer;
            boolean z2 = true;
            boolean z3 = false;
            boolean z4 = (view == null || view.getVisibility() == 8) ? false : true;
            if (view != null && view.getVisibility() != 8) {
                int measuredHeight = getMeasuredHeight();
                int i6 = ((FrameLayout.LayoutParams) view.getLayoutParams()).bottomMargin;
                view.layout(i2, (measuredHeight - view.getMeasuredHeight()) - i6, i4, measuredHeight - i6);
            }
            if (this.mIsSplit) {
                Drawable drawable2 = this.mSplitBackground;
                if (drawable2 != null) {
                    drawable2.setBounds(0, 0, getMeasuredWidth(), getMeasuredHeight());
                } else {
                    z2 = false;
                }
            } else {
                if (this.mBackground != null) {
                    if (this.mActionBarView.getVisibility() == 0) {
                        this.mBackground.setBounds(this.mActionBarView.getLeft(), this.mActionBarView.getTop(), this.mActionBarView.getRight(), this.mActionBarView.getBottom());
                    } else {
                        View view2 = this.mContextView;
                        if (view2 != null && view2.getVisibility() == 0) {
                            this.mBackground.setBounds(this.mContextView.getLeft(), this.mContextView.getTop(), this.mContextView.getRight(), this.mContextView.getBottom());
                        } else {
                            this.mBackground.setBounds(0, 0, 0, 0);
                        }
                    }
                    z3 = true;
                }
                this.mIsStacked = z4;
                if (!z4 || (drawable = this.mStackedBackground) == null) {
                    z2 = z3;
                } else {
                    drawable.setBounds(view.getLeft(), view.getTop(), view.getRight(), view.getBottom());
                }
            }
            if (z2) {
                invalidate();
            }
        }
    }

    @Override // android.widget.FrameLayout, android.view.View
    public void onMeasure(int i2, int i3) {
        int measuredHeightWithMargins;
        int i4;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048583, this, i2, i3) == null) {
            if (this.mActionBarView == null && View.MeasureSpec.getMode(i3) == Integer.MIN_VALUE && (i4 = this.mHeight) >= 0) {
                i3 = View.MeasureSpec.makeMeasureSpec(Math.min(i4, View.MeasureSpec.getSize(i3)), Integer.MIN_VALUE);
            }
            super.onMeasure(i2, i3);
            if (this.mActionBarView == null) {
                return;
            }
            int mode = View.MeasureSpec.getMode(i3);
            View view = this.mTabContainer;
            if (view == null || view.getVisibility() == 8 || mode == 1073741824) {
                return;
            }
            if (!isCollapsed(this.mActionBarView)) {
                measuredHeightWithMargins = getMeasuredHeightWithMargins(this.mActionBarView);
            } else {
                measuredHeightWithMargins = !isCollapsed(this.mContextView) ? getMeasuredHeightWithMargins(this.mContextView) : 0;
            }
            setMeasuredDimension(getMeasuredWidth(), Math.min(measuredHeightWithMargins + getMeasuredHeightWithMargins(this.mTabContainer), mode == Integer.MIN_VALUE ? View.MeasureSpec.getSize(i3) : Integer.MAX_VALUE));
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, motionEvent)) == null) {
            super.onTouchEvent(motionEvent);
            return true;
        }
        return invokeL.booleanValue;
    }

    public void setPrimaryBackground(Drawable drawable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, drawable) == null) {
            Drawable drawable2 = this.mBackground;
            if (drawable2 != null) {
                drawable2.setCallback(null);
                unscheduleDrawable(this.mBackground);
            }
            this.mBackground = drawable;
            if (drawable != null) {
                drawable.setCallback(this);
                View view = this.mActionBarView;
                if (view != null) {
                    this.mBackground.setBounds(view.getLeft(), this.mActionBarView.getTop(), this.mActionBarView.getRight(), this.mActionBarView.getBottom());
                }
            }
            boolean z = true;
            if (!this.mIsSplit ? this.mBackground != null || this.mStackedBackground != null : this.mSplitBackground != null) {
                z = false;
            }
            setWillNotDraw(z);
            invalidate();
            if (Build.VERSION.SDK_INT >= 21) {
                invalidateOutline();
            }
        }
    }

    public void setSplitBackground(Drawable drawable) {
        Drawable drawable2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, drawable) == null) {
            Drawable drawable3 = this.mSplitBackground;
            if (drawable3 != null) {
                drawable3.setCallback(null);
                unscheduleDrawable(this.mSplitBackground);
            }
            this.mSplitBackground = drawable;
            boolean z = false;
            if (drawable != null) {
                drawable.setCallback(this);
                if (this.mIsSplit && (drawable2 = this.mSplitBackground) != null) {
                    drawable2.setBounds(0, 0, getMeasuredWidth(), getMeasuredHeight());
                }
            }
            if (!this.mIsSplit ? !(this.mBackground != null || this.mStackedBackground != null) : this.mSplitBackground == null) {
                z = true;
            }
            setWillNotDraw(z);
            invalidate();
            if (Build.VERSION.SDK_INT >= 21) {
                invalidateOutline();
            }
        }
    }

    public void setStackedBackground(Drawable drawable) {
        Drawable drawable2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, drawable) == null) {
            Drawable drawable3 = this.mStackedBackground;
            if (drawable3 != null) {
                drawable3.setCallback(null);
                unscheduleDrawable(this.mStackedBackground);
            }
            this.mStackedBackground = drawable;
            if (drawable != null) {
                drawable.setCallback(this);
                if (this.mIsStacked && (drawable2 = this.mStackedBackground) != null) {
                    drawable2.setBounds(this.mTabContainer.getLeft(), this.mTabContainer.getTop(), this.mTabContainer.getRight(), this.mTabContainer.getBottom());
                }
            }
            boolean z = true;
            if (!this.mIsSplit ? this.mBackground != null || this.mStackedBackground != null : this.mSplitBackground != null) {
                z = false;
            }
            setWillNotDraw(z);
            invalidate();
            if (Build.VERSION.SDK_INT >= 21) {
                invalidateOutline();
            }
        }
    }

    public void setTabContainer(ScrollingTabContainerView scrollingTabContainerView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, scrollingTabContainerView) == null) {
            View view = this.mTabContainer;
            if (view != null) {
                removeView(view);
            }
            this.mTabContainer = scrollingTabContainerView;
            if (scrollingTabContainerView != null) {
                addView(scrollingTabContainerView);
                ViewGroup.LayoutParams layoutParams = scrollingTabContainerView.getLayoutParams();
                layoutParams.width = -1;
                layoutParams.height = -2;
                scrollingTabContainerView.setAllowCollapse(false);
            }
        }
    }

    public void setTransitioning(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048589, this, z) == null) {
            this.mIsTransitioning = z;
            setDescendantFocusability(z ? 393216 : 262144);
        }
    }

    @Override // android.view.View
    public void setVisibility(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048590, this, i2) == null) {
            super.setVisibility(i2);
            boolean z = i2 == 0;
            Drawable drawable = this.mBackground;
            if (drawable != null) {
                drawable.setVisible(z, false);
            }
            Drawable drawable2 = this.mStackedBackground;
            if (drawable2 != null) {
                drawable2.setVisible(z, false);
            }
            Drawable drawable3 = this.mSplitBackground;
            if (drawable3 != null) {
                drawable3.setVisible(z, false);
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public ActionMode startActionModeForChild(View view, ActionMode.Callback callback) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048591, this, view, callback)) == null) {
            return null;
        }
        return (ActionMode) invokeLL.objValue;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public ActionMode startActionModeForChild(View view, ActionMode.Callback callback, int i2) {
        InterceptResult invokeLLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(1048592, this, view, callback, i2)) == null) {
            if (i2 != 0) {
                return super.startActionModeForChild(view, callback, i2);
            }
            return null;
        }
        return (ActionMode) invokeLLI.objValue;
    }

    @Override // android.view.View
    public boolean verifyDrawable(Drawable drawable) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048593, this, drawable)) == null) ? (drawable == this.mBackground && !this.mIsSplit) || (drawable == this.mStackedBackground && this.mIsStacked) || ((drawable == this.mSplitBackground && this.mIsSplit) || super.verifyDrawable(drawable)) : invokeL.booleanValue;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ActionBarContainer(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
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
                super((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        ViewCompat.setBackground(this, new ActionBarBackgroundDrawable(this));
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.ActionBar);
        this.mBackground = obtainStyledAttributes.getDrawable(R.styleable.ActionBar_background);
        this.mStackedBackground = obtainStyledAttributes.getDrawable(R.styleable.ActionBar_backgroundStacked);
        this.mHeight = obtainStyledAttributes.getDimensionPixelSize(R.styleable.ActionBar_height, -1);
        boolean z = true;
        if (getId() == R.id.split_action_bar) {
            this.mIsSplit = true;
            this.mSplitBackground = obtainStyledAttributes.getDrawable(R.styleable.ActionBar_backgroundSplit);
        }
        obtainStyledAttributes.recycle();
        if (!this.mIsSplit ? this.mBackground != null || this.mStackedBackground != null : this.mSplitBackground != null) {
            z = false;
        }
        setWillNotDraw(z);
    }
}
