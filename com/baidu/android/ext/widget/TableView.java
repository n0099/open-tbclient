package com.baidu.android.ext.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes.dex */
public class TableView extends ViewGroup {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String TAG = "TableView";
    public transient /* synthetic */ FieldHolder $fh;
    public Builder mBuilder;
    public int mColumnCount;
    public boolean mHasBuilded;

    /* loaded from: classes.dex */
    public interface Builder<T> {
        int getColumns();

        int getCount();

        T getItem(int i);

        T getItem(int i, int i2);

        View newView(int i, int i2, int i3, ViewGroup viewGroup);
    }

    /* loaded from: classes.dex */
    public static class LayoutParams extends ViewGroup.LayoutParams {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public int col;
        public int pos;
        public int row;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public LayoutParams(int i, int i2) {
            super(i, i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Integer.valueOf(i), Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super(((Integer) objArr2[0]).intValue(), ((Integer) objArr2[1]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public LayoutParams(Context context, AttributeSet attributeSet) {
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
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public LayoutParams(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {layoutParams};
                interceptable.invokeUnInit(65538, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((ViewGroup.LayoutParams) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65538, newInitContext);
                    return;
                }
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TableView(Context context) {
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
        init();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TableView(Context context, AttributeSet attributeSet) {
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
        init();
    }

    private void init() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65538, this) == null) {
            this.mColumnCount = 1;
        }
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateDefaultLayoutParams() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return new LayoutParams(-2, -2);
        }
        return (ViewGroup.LayoutParams) invokeV.objValue;
    }

    public Builder getBuilder() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            return this.mBuilder;
        }
        return (Builder) invokeV.objValue;
    }

    public int getColumnCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            return this.mColumnCount;
        }
        return invokeV.intValue;
    }

    public boolean hasBuilded() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            return this.mHasBuilded;
        }
        return invokeV.booleanValue;
    }

    @Override // android.view.ViewGroup
    @SuppressLint({"BDThrowableCheck"})
    public void removeAllViews() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            throw new UnsupportedOperationException("removeAllViews() is not supported in TableView");
        }
    }

    public void requestRebuild() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048595, this) == null) {
            requestLayout();
            this.mHasBuilded = false;
        }
    }

    @Override // android.view.ViewGroup
    public void addView(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
            Log.e(TAG, "addView(View) is not supported in TableView");
        }
    }

    @Override // android.view.ViewGroup
    public boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, layoutParams)) == null) {
            return layoutParams instanceof LayoutParams;
        }
        return invokeL.booleanValue;
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, attributeSet)) == null) {
            return new LayoutParams(getContext(), attributeSet);
        }
        return (ViewGroup.LayoutParams) invokeL.objValue;
    }

    public int getPosition(View view2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048588, this, view2)) == null) {
            if (view2 == null) {
                return -1;
            }
            return ((LayoutParams) view2.getLayoutParams()).pos;
        }
        return invokeL.intValue;
    }

    @Override // android.view.ViewGroup, android.view.ViewManager
    @SuppressLint({"BDThrowableCheck"})
    public void removeView(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, view2) == null) {
            throw new UnsupportedOperationException("removeView(View) is not supported in TableView");
        }
    }

    @Override // android.view.ViewGroup
    @SuppressLint({"BDThrowableCheck"})
    public void removeViewAt(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048594, this, i) == null) {
            throw new UnsupportedOperationException("removeViewAt(int) is not supported in TableView");
        }
    }

    public void setBuilder(Builder builder) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048596, this, builder) == null) {
            this.mBuilder = builder;
            this.mHasBuilded = false;
        }
    }

    @Override // android.view.ViewGroup
    public void addView(View view2, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2, i) == null) {
            Log.e(TAG, "addView(View, int) is not supported in TableView");
        }
    }

    public View findViewByPosition(int i, int i2) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(1048582, this, i, i2)) == null) {
            return getChildAt((i * this.mColumnCount) + i2);
        }
        return (View) invokeII.objValue;
    }

    public void addView(View view2, int i, LayoutParams layoutParams) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(Constants.METHOD_SEND_USER_MSG, this, view2, i, layoutParams) == null) {
            Log.e(TAG, "addView(View, int, LayoutParams) is not supported in TableView");
        }
    }

    public void addView(View view2, LayoutParams layoutParams) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, view2, layoutParams) == null) {
            Log.e(TAG, "addView(View, LayoutParams)  is not supported in TableView");
        }
    }

    public void buildChildren() {
        int columns;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            this.mHasBuilded = true;
            super.removeAllViews();
            init();
            Builder builder = this.mBuilder;
            if (builder == null || (columns = builder.getColumns()) <= 0) {
                return;
            }
            int count = this.mBuilder.getCount();
            int i = 0;
            int i2 = 0;
            for (int i3 = 0; i3 < count; i3++) {
                View newView = this.mBuilder.newView(i3, i, i2, this);
                ViewGroup.LayoutParams layoutParams = newView.getLayoutParams();
                if (layoutParams == null) {
                    layoutParams = generateDefaultLayoutParams();
                }
                super.addView(newView, -1, layoutParams);
                LayoutParams layoutParams2 = (LayoutParams) newView.getLayoutParams();
                layoutParams2.pos = i3;
                layoutParams2.row = i;
                layoutParams2.col = i2;
                i2++;
                if (i2 >= columns) {
                    i++;
                    i2 = 0;
                }
            }
            this.mColumnCount = columns;
        }
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, layoutParams)) == null) {
            return new LayoutParams(layoutParams);
        }
        return (ViewGroup.LayoutParams) invokeL.objValue;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048590, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)}) == null) {
            int paddingLeft = getPaddingLeft();
            int paddingTop = getPaddingTop();
            int childCount = getChildCount();
            int measuredWidth = (getMeasuredWidth() - (getPaddingRight() + paddingLeft)) / this.mColumnCount;
            int i5 = paddingLeft;
            int i6 = 0;
            int i7 = 0;
            for (int i8 = 0; i8 < childCount; i8++) {
                View childAt = getChildAt(i8);
                if (childAt.getVisibility() != 8) {
                    childAt.layout(i5, paddingTop, childAt.getMeasuredWidth() + i5, childAt.getMeasuredHeight() + paddingTop);
                    i6 = Math.max(i6, childAt.getMeasuredHeight());
                }
                i5 += measuredWidth;
                i7++;
                if (i7 >= this.mColumnCount) {
                    paddingTop += i6;
                    i5 = paddingLeft;
                    i6 = 0;
                    i7 = 0;
                }
            }
        }
    }

    @Override // android.view.View
    public void onMeasure(int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048591, this, i, i2) == null) {
            if (!this.mHasBuilded) {
                buildChildren();
            }
            int paddingLeft = getPaddingLeft() + getPaddingRight();
            int paddingTop = getPaddingTop() + getPaddingBottom();
            int childCount = getChildCount();
            int size = View.MeasureSpec.getSize(i) - paddingLeft;
            int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(size / this.mColumnCount, 1073741824);
            int i3 = size % this.mColumnCount;
            int i4 = 0;
            int i5 = 0;
            int i6 = 0;
            for (int i7 = 0; i7 < childCount; i7++) {
                View childAt = getChildAt(i7);
                if (childAt.getVisibility() != 8) {
                    childAt.measure(makeMeasureSpec, ViewGroup.getChildMeasureSpec(i2, paddingTop, childAt.getLayoutParams().height));
                    i5 = Math.max(i5, childAt.getMeasuredHeight());
                }
                i6++;
                if (i6 >= this.mColumnCount) {
                    i4 += i5;
                    i5 = 0;
                    i6 = 0;
                }
            }
            int i8 = i4 + i5;
            if (i3 > 0) {
                int i9 = i3 / 2;
                setPadding(getPaddingLeft() + i9, getPaddingTop(), (getPaddingRight() + i3) - i9, getPaddingBottom());
            }
            setMeasuredDimension(size + paddingLeft, i8 + paddingTop);
        }
    }
}
