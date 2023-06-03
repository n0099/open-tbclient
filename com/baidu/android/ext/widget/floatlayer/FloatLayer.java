package com.baidu.android.ext.widget.floatlayer;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes.dex */
public class FloatLayer {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final Holder mHolder;
    public int mMarginTop;
    public final ViewGroup mTarget;

    /* loaded from: classes.dex */
    public interface Holder {
        @NonNull
        FloatLayer getFloatLayer();
    }

    public FloatLayer(@NonNull Holder holder, @NonNull ViewGroup viewGroup, int i) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {holder, viewGroup, Integer.valueOf(i)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mHolder = holder;
        this.mTarget = viewGroup;
        this.mMarginTop = i;
    }

    @Nullable
    private Container findContainer() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, this)) == null) {
            synchronized (this.mTarget) {
                for (int i = 0; i < this.mTarget.getChildCount(); i++) {
                    View childAt = this.mTarget.getChildAt(i);
                    if (childAt instanceof Container) {
                        return (Container) childAt;
                    }
                }
                return null;
            }
        }
        return (Container) invokeV.objValue;
    }

    @NonNull
    private Container getContainer() {
        InterceptResult invokeV;
        Container findContainer;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, this)) == null) {
            synchronized (this.mTarget) {
                findContainer = findContainer();
                if (findContainer == null) {
                    findContainer = new Container(getContext());
                    int height = this.mTarget.getHeight() - this.mMarginTop;
                    if (this.mTarget instanceof LinearLayout) {
                        i = -height;
                    } else {
                        i = this.mMarginTop;
                    }
                    if (height <= 0) {
                        height = -1;
                        i = 0;
                    }
                    LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, height);
                    layoutParams.setMargins(0, i, 0, 0);
                    findContainer.setLayoutParams(layoutParams);
                    this.mTarget.addView(findContainer);
                }
            }
            return findContainer;
        }
        return (Container) invokeV.objValue;
    }

    private Context getContext() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, this)) == null) {
            return this.mTarget.getContext();
        }
        return (Context) invokeV.objValue;
    }

    public View getView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            Container findContainer = findContainer();
            if (findContainer == null || findContainer.getChildCount() <= 0) {
                return null;
            }
            return findContainer.getChildAt(0);
        }
        return (View) invokeV.objValue;
    }

    public void reset() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            reset(false);
        }
    }

    public void reset(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z) == null) {
            synchronized (this.mTarget) {
                Container findContainer = findContainer();
                if (z && findContainer != null && findContainer.getChildCount() > 0) {
                    return;
                }
                if (findContainer != null) {
                    this.mTarget.removeView(findContainer);
                }
            }
        }
    }

    public void setMask(boolean z) {
        Container findContainer;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048579, this, z) == null) && (findContainer = findContainer()) != null) {
            findContainer.setClickable(z);
        }
    }

    public void show(@NonNull View view2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048580, this, view2) == null) && view2 != getView()) {
            reset();
            getContainer().addView(view2);
        }
    }

    public void show(@NonNull View view2, int i, int i2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLII(1048581, this, view2, i, i2) == null) && view2 != getView()) {
            reset();
            getContainer().addView(view2, i, i2);
        }
    }

    public void show(@NonNull View view2, ViewGroup.LayoutParams layoutParams) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048582, this, view2, layoutParams) == null) && view2 == getView()) {
            reset();
            getContainer().addView(view2, layoutParams);
        }
    }
}
