package androidx.fragment.app;

import android.animation.LayoutTransition;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.os.Build;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowInsets;
import android.widget.FrameLayout;
import androidx.core.view.InputDeviceCompat;
import androidx.fragment.R;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
/* loaded from: classes.dex */
public final class FragmentContainerView extends FrameLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ArrayList<View> mDisappearingFragmentChildren;
    public boolean mDrawDisappearingViewsFirst;
    public ArrayList<View> mTransitioningFragmentViews;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FragmentContainerView(Context context) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mDrawDisappearingViewsFirst = true;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, canvas) == null) {
            if (this.mDrawDisappearingViewsFirst && this.mDisappearingFragmentChildren != null) {
                for (int i = 0; i < this.mDisappearingFragmentChildren.size(); i++) {
                    super.drawChild(canvas, this.mDisappearingFragmentChildren.get(i), getDrawingTime());
                }
            }
            super.dispatchDraw(canvas);
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public FragmentContainerView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
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
                this((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FragmentContainerView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet, Integer.valueOf(i)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.mDrawDisappearingViewsFirst = true;
        if (isInEditMode()) {
            return;
        }
        throw new UnsupportedOperationException("FragmentContainerView must be within a FragmentActivity to be instantiated from XML.");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FragmentContainerView(Context context, AttributeSet attributeSet, FragmentManager fragmentManager) {
        super(context, attributeSet);
        String str;
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet, fragmentManager};
            interceptable.invokeUnInit(65539, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65539, newInitContext);
                return;
            }
        }
        this.mDrawDisappearingViewsFirst = true;
        String classAttribute = attributeSet.getClassAttribute();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.FragmentContainerView);
        classAttribute = classAttribute == null ? obtainStyledAttributes.getString(0) : classAttribute;
        String string = obtainStyledAttributes.getString(1);
        obtainStyledAttributes.recycle();
        int id = getId();
        Fragment findFragmentById = fragmentManager.findFragmentById(id);
        if (classAttribute != null && findFragmentById == null) {
            if (id <= 0) {
                if (string != null) {
                    str = " with tag " + string;
                } else {
                    str = "";
                }
                throw new IllegalStateException("FragmentContainerView must have an android:id to add Fragment " + classAttribute + str);
            }
            Fragment instantiate = fragmentManager.getFragmentFactory().instantiate(context.getClassLoader(), classAttribute);
            instantiate.onInflate(context, attributeSet, (Bundle) null);
            fragmentManager.beginTransaction().setReorderingAllowed(true).add(this, instantiate, string).commitNowAllowingStateLoss();
        }
    }

    private void addDisappearingFragmentView(View view2) {
        ArrayList<View> arrayList;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, this, view2) == null) {
            if (view2.getAnimation() != null || ((arrayList = this.mTransitioningFragmentViews) != null && arrayList.contains(view2))) {
                if (this.mDisappearingFragmentChildren == null) {
                    this.mDisappearingFragmentChildren = new ArrayList<>();
                }
                this.mDisappearingFragmentChildren.add(view2);
            }
        }
    }

    @Override // android.view.ViewGroup
    public void endViewTransition(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, view2) == null) {
            ArrayList<View> arrayList = this.mTransitioningFragmentViews;
            if (arrayList != null) {
                arrayList.remove(view2);
                ArrayList<View> arrayList2 = this.mDisappearingFragmentChildren;
                if (arrayList2 != null && arrayList2.remove(view2)) {
                    this.mDrawDisappearingViewsFirst = true;
                }
            }
            super.endViewTransition(view2);
        }
    }

    @Override // android.view.View
    public WindowInsets onApplyWindowInsets(WindowInsets windowInsets) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, windowInsets)) == null) {
            for (int i = 0; i < getChildCount(); i++) {
                getChildAt(i).dispatchApplyWindowInsets(new WindowInsets(windowInsets));
            }
            return windowInsets;
        }
        return (WindowInsets) invokeL.objValue;
    }

    @Override // android.view.ViewGroup, android.view.ViewManager
    public void removeView(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, view2) == null) {
            addDisappearingFragmentView(view2);
            super.removeView(view2);
        }
    }

    @Override // android.view.ViewGroup
    public void removeViewAt(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048585, this, i) == null) {
            addDisappearingFragmentView(getChildAt(i));
            super.removeViewAt(i);
        }
    }

    @Override // android.view.ViewGroup
    public void removeViewInLayout(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, view2) == null) {
            addDisappearingFragmentView(view2);
            super.removeViewInLayout(view2);
        }
    }

    public void setDrawDisappearingViewsLast(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048589, this, z) == null) {
            this.mDrawDisappearingViewsFirst = z;
        }
    }

    @Override // android.view.ViewGroup
    public void setLayoutTransition(LayoutTransition layoutTransition) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, layoutTransition) == null) {
            if (Build.VERSION.SDK_INT < 18) {
                super.setLayoutTransition(layoutTransition);
                return;
            }
            throw new UnsupportedOperationException("FragmentContainerView does not support Layout Transitions or animateLayoutChanges=\"true\".");
        }
    }

    @Override // android.view.ViewGroup
    public void startViewTransition(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, view2) == null) {
            if (view2.getParent() == this) {
                if (this.mTransitioningFragmentViews == null) {
                    this.mTransitioningFragmentViews = new ArrayList<>();
                }
                this.mTransitioningFragmentViews.add(view2);
            }
            super.startViewTransition(view2);
        }
    }

    @Override // android.view.ViewGroup
    public void addView(View view2, int i, ViewGroup.LayoutParams layoutParams) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(1048576, this, view2, i, layoutParams) == null) {
            if (FragmentManager.getViewFragment(view2) != null) {
                super.addView(view2, i, layoutParams);
                return;
            }
            throw new IllegalStateException("Views added to a FragmentContainerView must be associated with a Fragment. View " + view2 + " is not associated with a Fragment.");
        }
    }

    @Override // android.view.ViewGroup
    public boolean drawChild(Canvas canvas, View view2, long j) {
        InterceptResult invokeCommon;
        ArrayList<View> arrayList;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048579, this, new Object[]{canvas, view2, Long.valueOf(j)})) == null) {
            if (this.mDrawDisappearingViewsFirst && (arrayList = this.mDisappearingFragmentChildren) != null && arrayList.size() > 0 && this.mDisappearingFragmentChildren.contains(view2)) {
                return false;
            }
            return super.drawChild(canvas, view2, j);
        }
        return invokeCommon.booleanValue;
    }

    @Override // android.view.ViewGroup
    public boolean addViewInLayout(View view2, int i, ViewGroup.LayoutParams layoutParams, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{view2, Integer.valueOf(i), layoutParams, Boolean.valueOf(z)})) == null) {
            if (FragmentManager.getViewFragment(view2) != null) {
                return super.addViewInLayout(view2, i, layoutParams, z);
            }
            throw new IllegalStateException("Views added to a FragmentContainerView must be associated with a Fragment. View " + view2 + " is not associated with a Fragment.");
        }
        return invokeCommon.booleanValue;
    }

    @Override // android.view.ViewGroup
    public void removeAllViewsInLayout() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            for (int childCount = getChildCount() - 1; childCount >= 0; childCount--) {
                addDisappearingFragmentView(getChildAt(childCount));
            }
            super.removeAllViewsInLayout();
        }
    }

    @Override // android.view.ViewGroup
    public void removeDetachedView(View view2, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048583, this, view2, z) == null) {
            if (z) {
                addDisappearingFragmentView(view2);
            }
            super.removeDetachedView(view2, z);
        }
    }

    @Override // android.view.ViewGroup
    public void removeViews(int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048587, this, i, i2) == null) {
            for (int i3 = i; i3 < i + i2; i3++) {
                addDisappearingFragmentView(getChildAt(i3));
            }
            super.removeViews(i, i2);
        }
    }

    @Override // android.view.ViewGroup
    public void removeViewsInLayout(int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048588, this, i, i2) == null) {
            for (int i3 = i; i3 < i + i2; i3++) {
                addDisappearingFragmentView(getChildAt(i3));
            }
            super.removeViewsInLayout(i, i2);
        }
    }
}
