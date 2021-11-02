package com.baidu.searchbox.ui.bubble.builder;

import android.graphics.Color;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.ui.bubble.BubbleManager;
import com.baidu.searchbox.ui.bubble.BubblePosition;
import com.baidu.searchbox.ui.bubble.manager.BubbleBaseManager;
import com.baidu.searchbox.ui.bubble.views.BubbleBaseView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public abstract class BubbleBuilder<T> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public BubbleBaseManager mBaseManager;
    public BubbleBaseView mBaseViews;

    public BubbleBuilder(BubbleBaseManager bubbleBaseManager) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {bubbleBaseManager};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mBaseViews = bubbleBaseManager.getViews();
        this.mBaseManager = bubbleBaseManager;
    }

    public BubbleBaseManager build() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.mBaseManager : (BubbleBaseManager) invokeV.objValue;
    }

    public BubbleBuilder<T> enableAnchorClk(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z)) == null) {
            this.mBaseManager.enableAnchorClk(z);
            return this;
        }
        return (BubbleBuilder) invokeZ.objValue;
    }

    public BubbleBuilder<T> enableAnimation(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z)) == null) {
            this.mBaseManager.enableAnimation(z);
            return this;
        }
        return (BubbleBuilder) invokeZ.objValue;
    }

    public BubbleBuilder<T> enableBgClk(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048579, this, z)) == null) {
            this.mBaseManager.enableBgClk(z);
            return this;
        }
        return (BubbleBuilder) invokeZ.objValue;
    }

    public BubbleBuilder<T> enableClkDismiss(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048580, this, z)) == null) {
            this.mBaseManager.enableClkDismiss(z);
            return this;
        }
        return (BubbleBuilder) invokeZ.objValue;
    }

    public BubbleBaseView getViews() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.mBaseViews : (BubbleBaseView) invokeV.objValue;
    }

    public BubbleBuilder<T> isAutoDetectShowPosition(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048582, this, z)) == null) {
            this.mBaseManager.getLocation().mIsAutoDetectShowPosition = z;
            return this;
        }
        return (BubbleBuilder) invokeZ.objValue;
    }

    public BubbleBuilder<T> setAnchorAndRootView(View view, ViewGroup viewGroup) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048583, this, view, viewGroup)) == null) {
            this.mBaseViews.setAnchorAndRootView(view, viewGroup);
            return this;
        }
        return (BubbleBuilder) invokeLL.objValue;
    }

    public BubbleBuilder<T> setAnchorView(View view) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, view)) == null) {
            this.mBaseViews.setAnchor(view);
            return this;
        }
        return (BubbleBuilder) invokeL.objValue;
    }

    public BubbleBuilder<T> setAutoDismiss(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048585, this, z)) == null) {
            this.mBaseManager.setAutoDismiss(z);
            return this;
        }
        return (BubbleBuilder) invokeZ.objValue;
    }

    public BubbleBuilder<T> setAutoDismissInterval(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048586, this, i2)) == null) {
            this.mBaseManager.setAutoDismissInterval(i2);
            return this;
        }
        return (BubbleBuilder) invokeI.objValue;
    }

    public BubbleBuilder<T> setBackgroundColor(int i2, int i3) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(1048587, this, i2, i3)) == null) {
            if (i2 != -1) {
                try {
                    this.mBaseViews.setDayModeBackground(i2);
                } catch (Exception unused) {
                    this.mBaseViews.setDayModeBackground(-1);
                    return this;
                }
            }
            if (i3 != -1) {
                try {
                    this.mBaseViews.setNightModeBackground(i3);
                } catch (Exception unused2) {
                    this.mBaseViews.setNightModeBackground(-1);
                }
            }
            return this;
        }
        return (BubbleBuilder) invokeII.objValue;
    }

    public BubbleBuilder<T> setForceShowLeftEndPoint() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            this.mBaseManager.getLocation().isShowLeftEndPoint = true;
            return this;
        }
        return (BubbleBuilder) invokeV.objValue;
    }

    public BubbleBuilder<T> setForceShowPosition(BubblePosition bubblePosition) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048590, this, bubblePosition)) == null) {
            this.mBaseManager.getLocation().mIsAutoDetectShowPosition = false;
            this.mBaseManager.getLocation().mBubbleForceShowPosition = bubblePosition;
            return this;
        }
        return (BubbleBuilder) invokeL.objValue;
    }

    public BubbleBuilder<T> setOffsetOfArrow(float f2) {
        InterceptResult invokeF;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeF = interceptable.invokeF(1048591, this, f2)) == null) {
            this.mBaseManager.setOffsetOfArrow(f2);
            return this;
        }
        return (BubbleBuilder) invokeF.objValue;
    }

    public BubbleBuilder<T> setOnAnchorClickListener(BubbleManager.OnAnchorClickListener onAnchorClickListener) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048592, this, onAnchorClickListener)) == null) {
            this.mBaseManager.setOnAnchorEventListener(onAnchorClickListener);
            return this;
        }
        return (BubbleBuilder) invokeL.objValue;
    }

    public BubbleBuilder<T> setOnBubbleEventListener(BubbleManager.OnBubbleEventListener onBubbleEventListener) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048593, this, onBubbleEventListener)) == null) {
            this.mBaseManager.setOnBubbleEventListener(onBubbleEventListener);
            return this;
        }
        return (BubbleBuilder) invokeL.objValue;
    }

    public BubbleBuilder<T> setPaddingBetweenAnchor(float f2) {
        InterceptResult invokeF;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeF = interceptable.invokeF(1048594, this, f2)) == null) {
            this.mBaseManager.getLocation().setPaddingBetweenAnchor(f2);
            return this;
        }
        return (BubbleBuilder) invokeF.objValue;
    }

    public BubbleBuilder<T> setBackgroundColor(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048588, this, str, str2)) == null) {
            if (!TextUtils.isEmpty(str)) {
                try {
                    this.mBaseViews.setDayModeBackground(Color.parseColor(str));
                } catch (Exception unused) {
                    this.mBaseViews.setDayModeBackground(-1);
                    return this;
                }
            }
            if (!TextUtils.isEmpty(str2)) {
                try {
                    this.mBaseViews.setNightModeBackground(Color.parseColor(str2));
                } catch (Exception unused2) {
                    this.mBaseViews.setNightModeBackground(-1);
                }
            }
            return this;
        }
        return (BubbleBuilder) invokeLL.objValue;
    }
}
