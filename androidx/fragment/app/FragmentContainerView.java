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
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
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
    public FragmentContainerView(@NonNull Context context) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mDrawDisappearingViewsFirst = true;
    }

    private void addDisappearingFragmentView(@NonNull View view) {
        ArrayList<View> arrayList;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, this, view) == null) {
            if (view.getAnimation() != null || ((arrayList = this.mTransitioningFragmentViews) != null && arrayList.contains(view))) {
                if (this.mDisappearingFragmentChildren == null) {
                    this.mDisappearingFragmentChildren = new ArrayList<>();
                }
                this.mDisappearingFragmentChildren.add(view);
            }
        }
    }

    @Override // android.view.ViewGroup
    public void addView(@NonNull View view, int i2, @Nullable ViewGroup.LayoutParams layoutParams) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(1048576, this, view, i2, layoutParams) == null) {
            if (FragmentManager.getViewFragment(view) != null) {
                super.addView(view, i2, layoutParams);
                return;
            }
            throw new IllegalStateException("Views added to a FragmentContainerView must be associated with a Fragment. View " + view + " is not associated with a Fragment.");
        }
    }

    @Override // android.view.ViewGroup
    public boolean addViewInLayout(@NonNull View view, int i2, @Nullable ViewGroup.LayoutParams layoutParams, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{view, Integer.valueOf(i2), layoutParams, Boolean.valueOf(z)})) == null) {
            if (FragmentManager.getViewFragment(view) != null) {
                return super.addViewInLayout(view, i2, layoutParams, z);
            }
            throw new IllegalStateException("Views added to a FragmentContainerView must be associated with a Fragment. View " + view + " is not associated with a Fragment.");
        }
        return invokeCommon.booleanValue;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchDraw(@NonNull Canvas canvas) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, canvas) == null) {
            if (this.mDrawDisappearingViewsFirst && this.mDisappearingFragmentChildren != null) {
                for (int i2 = 0; i2 < this.mDisappearingFragmentChildren.size(); i2++) {
                    super.drawChild(canvas, this.mDisappearingFragmentChildren.get(i2), getDrawingTime());
                }
            }
            super.dispatchDraw(canvas);
        }
    }

    @Override // android.view.ViewGroup
    public boolean drawChild(@NonNull Canvas canvas, @NonNull View view, long j) {
        InterceptResult invokeCommon;
        ArrayList<View> arrayList;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048579, this, new Object[]{canvas, view, Long.valueOf(j)})) == null) {
            if (!this.mDrawDisappearingViewsFirst || (arrayList = this.mDisappearingFragmentChildren) == null || arrayList.size() <= 0 || !this.mDisappearingFragmentChildren.contains(view)) {
                return super.drawChild(canvas, view, j);
            }
            return false;
        }
        return invokeCommon.booleanValue;
    }

    @Override // android.view.ViewGroup
    public void endViewTransition(@NonNull View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, view) == null) {
            ArrayList<View> arrayList = this.mTransitioningFragmentViews;
            if (arrayList != null) {
                arrayList.remove(view);
                ArrayList<View> arrayList2 = this.mDisappearingFragmentChildren;
                if (arrayList2 != null && arrayList2.remove(view)) {
                    this.mDrawDisappearingViewsFirst = true;
                }
            }
            super.endViewTransition(view);
        }
    }

    @Override // android.view.View
    @NonNull
    @RequiresApi(20)
    public WindowInsets onApplyWindowInsets(@NonNull WindowInsets windowInsets) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, windowInsets)) == null) {
            for (int i2 = 0; i2 < getChildCount(); i2++) {
                getChildAt(i2).dispatchApplyWindowInsets(new WindowInsets(windowInsets));
            }
            return windowInsets;
        }
        return (WindowInsets) invokeL.objValue;
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
    public void removeDetachedView(@NonNull View view, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048583, this, view, z) == null) {
            if (z) {
                addDisappearingFragmentView(view);
            }
            super.removeDetachedView(view, z);
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewManager
    public void removeView(@NonNull View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, view) == null) {
            addDisappearingFragmentView(view);
            super.removeView(view);
        }
    }

    @Override // android.view.ViewGroup
    public void removeViewAt(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048585, this, i2) == null) {
            addDisappearingFragmentView(getChildAt(i2));
            super.removeViewAt(i2);
        }
    }

    @Override // android.view.ViewGroup
    public void removeViewInLayout(@NonNull View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, view) == null) {
            addDisappearingFragmentView(view);
            super.removeViewInLayout(view);
        }
    }

    @Override // android.view.ViewGroup
    public void removeViews(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048587, this, i2, i3) == null) {
            for (int i4 = i2; i4 < i2 + i3; i4++) {
                addDisappearingFragmentView(getChildAt(i4));
            }
            super.removeViews(i2, i3);
        }
    }

    @Override // android.view.ViewGroup
    public void removeViewsInLayout(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048588, this, i2, i3) == null) {
            for (int i4 = i2; i4 < i2 + i3; i4++) {
                addDisappearingFragmentView(getChildAt(i4));
            }
            super.removeViewsInLayout(i2, i3);
        }
    }

    public void setDrawDisappearingViewsLast(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048589, this, z) == null) {
            this.mDrawDisappearingViewsFirst = z;
        }
    }

    @Override // android.view.ViewGroup
    public void setLayoutTransition(@Nullable LayoutTransition layoutTransition) {
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
    public void startViewTransition(@NonNull View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, view) == null) {
            if (view.getParent() == this) {
                if (this.mTransitioningFragmentViews == null) {
                    this.mTransitioningFragmentViews = new ArrayList<>();
                }
                this.mTransitioningFragmentViews.add(view);
            }
            super.startViewTransition(view);
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public FragmentContainerView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
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
    public FragmentContainerView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i2) {
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
        this.mDrawDisappearingViewsFirst = true;
        if (!isInEditMode()) {
            throw new UnsupportedOperationException("FragmentContainerView must be within a FragmentActivity to be instantiated from XML.");
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FragmentContainerView(@NonNull Context context, @NonNull AttributeSet attributeSet, @NonNull FragmentManager fragmentManager) {
        super(context, attributeSet);
        String str;
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet, fragmentManager};
            interceptable.invokeUnInit(65539, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
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
        classAttribute = classAttribute == null ? obtainStyledAttributes.getString(R.styleable.FragmentContainerView_android_name) : classAttribute;
        String string = obtainStyledAttributes.getString(R.styleable.FragmentContainerView_android_tag);
        obtainStyledAttributes.recycle();
        int id = getId();
        Fragment findFragmentById = fragmentManager.findFragmentById(id);
        if (classAttribute == null || findFragmentById != null) {
            return;
        }
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
