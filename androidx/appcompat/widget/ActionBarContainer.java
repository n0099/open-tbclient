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

    @Override // android.view.ViewGroup, android.view.ViewParent
    public ActionMode startActionModeForChild(View view2, ActionMode.Callback callback) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048591, this, view2, callback)) == null) {
            return null;
        }
        return (ActionMode) invokeLL.objValue;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ActionBarContainer(Context context) {
        this(context, null);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    @Override // android.view.View
    public boolean verifyDrawable(Drawable drawable) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048593, this, drawable)) == null) {
            if ((drawable == this.mBackground && !this.mIsSplit) || ((drawable == this.mStackedBackground && this.mIsStacked) || ((drawable == this.mSplitBackground && this.mIsSplit) || super.verifyDrawable(drawable)))) {
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        ViewCompat.setBackground(this, new ActionBarBackgroundDrawable(this));
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.ActionBar);
        boolean z = false;
        this.mBackground = obtainStyledAttributes.getDrawable(0);
        this.mStackedBackground = obtainStyledAttributes.getDrawable(2);
        this.mHeight = obtainStyledAttributes.getDimensionPixelSize(13, -1);
        if (getId() == com.baidu.tieba.R.id.obfuscated_res_0x7f092035) {
            this.mIsSplit = true;
            this.mSplitBackground = obtainStyledAttributes.getDrawable(1);
        }
        obtainStyledAttributes.recycle();
        if (!this.mIsSplit ? !(this.mBackground != null || this.mStackedBackground != null) : this.mSplitBackground == null) {
            z = true;
        }
        setWillNotDraw(z);
    }

    @Override // android.widget.FrameLayout, android.view.View
    public void onMeasure(int i, int i2) {
        int i3;
        int i4;
        int i5;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048583, this, i, i2) == null) {
            if (this.mActionBarView == null && View.MeasureSpec.getMode(i2) == Integer.MIN_VALUE && (i5 = this.mHeight) >= 0) {
                i2 = View.MeasureSpec.makeMeasureSpec(Math.min(i5, View.MeasureSpec.getSize(i2)), Integer.MIN_VALUE);
            }
            super.onMeasure(i, i2);
            if (this.mActionBarView == null) {
                return;
            }
            int mode = View.MeasureSpec.getMode(i2);
            View view2 = this.mTabContainer;
            if (view2 != null && view2.getVisibility() != 8 && mode != 1073741824) {
                if (!isCollapsed(this.mActionBarView)) {
                    i3 = getMeasuredHeightWithMargins(this.mActionBarView);
                } else if (!isCollapsed(this.mContextView)) {
                    i3 = getMeasuredHeightWithMargins(this.mContextView);
                } else {
                    i3 = 0;
                }
                if (mode == Integer.MIN_VALUE) {
                    i4 = View.MeasureSpec.getSize(i2);
                } else {
                    i4 = Integer.MAX_VALUE;
                }
                setMeasuredDimension(getMeasuredWidth(), Math.min(i3 + getMeasuredHeightWithMargins(this.mTabContainer), i4));
            }
        }
    }

    private int getMeasuredHeightWithMargins(View view2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, this, view2)) == null) {
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) view2.getLayoutParams();
            return view2.getMeasuredHeight() + layoutParams.topMargin + layoutParams.bottomMargin;
        }
        return invokeL.intValue;
    }

    private boolean isCollapsed(View view2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, this, view2)) == null) {
            if (view2 != null && view2.getVisibility() != 8 && view2.getMeasuredHeight() != 0) {
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
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
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, motionEvent)) == null) {
            if (!this.mIsTransitioning && !super.onInterceptTouchEvent(motionEvent)) {
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
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

    public void setTabContainer(ScrollingTabContainerView scrollingTabContainerView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, scrollingTabContainerView) == null) {
            View view2 = this.mTabContainer;
            if (view2 != null) {
                removeView(view2);
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
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048589, this, z) == null) {
            this.mIsTransitioning = z;
            if (z) {
                i = 393216;
            } else {
                i = 262144;
            }
            setDescendantFocusability(i);
        }
    }

    @Override // android.view.View
    public void setVisibility(int i) {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048590, this, i) == null) {
            super.setVisibility(i);
            if (i == 0) {
                z = true;
            } else {
                z = false;
            }
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
            if (drawable3 != null && drawable3.isStateful()) {
                this.mSplitBackground.setState(getDrawableState());
            }
        }
    }

    public View getTabContainer() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.mTabContainer;
        }
        return (View) invokeV.objValue;
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
            this.mActionBarView = findViewById(com.baidu.tieba.R.id.obfuscated_res_0x7f09005b);
            this.mContextView = findViewById(com.baidu.tieba.R.id.obfuscated_res_0x7f090064);
        }
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        boolean z2;
        Drawable drawable;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048582, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)}) == null) {
            super.onLayout(z, i, i2, i3, i4);
            View view2 = this.mTabContainer;
            boolean z3 = true;
            boolean z4 = false;
            if (view2 != null && view2.getVisibility() != 8) {
                z2 = true;
            } else {
                z2 = false;
            }
            if (view2 != null && view2.getVisibility() != 8) {
                int measuredHeight = getMeasuredHeight();
                int i5 = ((FrameLayout.LayoutParams) view2.getLayoutParams()).bottomMargin;
                view2.layout(i, (measuredHeight - view2.getMeasuredHeight()) - i5, i3, measuredHeight - i5);
            }
            if (this.mIsSplit) {
                Drawable drawable2 = this.mSplitBackground;
                if (drawable2 != null) {
                    drawable2.setBounds(0, 0, getMeasuredWidth(), getMeasuredHeight());
                } else {
                    z3 = false;
                }
            } else {
                if (this.mBackground != null) {
                    if (this.mActionBarView.getVisibility() == 0) {
                        this.mBackground.setBounds(this.mActionBarView.getLeft(), this.mActionBarView.getTop(), this.mActionBarView.getRight(), this.mActionBarView.getBottom());
                    } else {
                        View view3 = this.mContextView;
                        if (view3 != null && view3.getVisibility() == 0) {
                            this.mBackground.setBounds(this.mContextView.getLeft(), this.mContextView.getTop(), this.mContextView.getRight(), this.mContextView.getBottom());
                        } else {
                            this.mBackground.setBounds(0, 0, 0, 0);
                        }
                    }
                    z4 = true;
                }
                this.mIsStacked = z2;
                if (z2 && (drawable = this.mStackedBackground) != null) {
                    drawable.setBounds(view2.getLeft(), view2.getTop(), view2.getRight(), view2.getBottom());
                } else {
                    z3 = z4;
                }
            }
            if (z3) {
                invalidate();
            }
        }
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
                View view2 = this.mActionBarView;
                if (view2 != null) {
                    this.mBackground.setBounds(view2.getLeft(), this.mActionBarView.getTop(), this.mActionBarView.getRight(), this.mActionBarView.getBottom());
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

    @Override // android.view.ViewGroup, android.view.ViewParent
    public ActionMode startActionModeForChild(View view2, ActionMode.Callback callback, int i) {
        InterceptResult invokeLLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(1048592, this, view2, callback, i)) == null) {
            if (i != 0) {
                return super.startActionModeForChild(view2, callback, i);
            }
            return null;
        }
        return (ActionMode) invokeLLI.objValue;
    }
}
