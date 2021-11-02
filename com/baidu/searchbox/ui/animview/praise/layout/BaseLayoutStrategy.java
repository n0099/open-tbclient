package com.baidu.searchbox.ui.animview.praise.layout;

import android.graphics.Rect;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.util.devices.DeviceUtil;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.ui.animview.base.IAnimatedElement;
import com.baidu.searchbox.ui.animview.base.IResourceProvider;
import com.baidu.searchbox.ui.animview.praise.layout.ILayoutStrategy;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Map;
/* loaded from: classes7.dex */
public abstract class BaseLayoutStrategy implements ILayoutStrategy {
    public static /* synthetic */ Interceptable $ic = null;
    public static final float ERUPTION_SIZE_DP = 313.0f;
    public static final float PRAISELEVEL_SIZE_DP = 170.0f;
    public static final float PRAISENUM_FACTOR_HEIGHT_BASED_PRAISELEVEL = 0.25f;
    public static final float PRAISENUM_FACTOR_POS_X_BASED_PRAISELEVEL = 0.1f;
    public static final float PRAISENUM_FACTOR_POS_Y_BASED_PRAISELEVEL = 0.15f;
    public static final float PRAISENUM_RATIO_BASED_PRAISENUM = 0.61f;
    public static final float SHAKE_SIZE_DP = 21.0f;
    public static final float WAVE_SIZE_DP = 116.0f;
    public transient /* synthetic */ FieldHolder $fh;
    public Rect mBaseRect;
    public ILayoutStrategy.ICallback mCallback;
    public int mCanvasHeight;
    public int mCanvasWidth;
    public IResourceProvider mProvider;

    public BaseLayoutStrategy(Rect rect, int i2, int i3, IResourceProvider iResourceProvider) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {rect, Integer.valueOf(i2), Integer.valueOf(i3), iResourceProvider};
            interceptable.invokeUnInit(65536, newInitContext);
            int i4 = newInitContext.flag;
            if ((i4 & 1) != 0) {
                int i5 = i4 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mBaseRect = rect;
        this.mProvider = iResourceProvider;
        this.mCanvasWidth = i2;
        this.mCanvasHeight = i3;
        this.mCallback = new ILayoutStrategy.ICallback(this) { // from class: com.baidu.searchbox.ui.animview.praise.layout.BaseLayoutStrategy.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ BaseLayoutStrategy this$0;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr2 = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i6 = newInitContext2.flag;
                    if ((i6 & 1) != 0) {
                        int i7 = i6 & 2;
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.this$0 = this;
            }

            @Override // com.baidu.searchbox.ui.animview.praise.layout.ILayoutStrategy.ICallback
            public void init(IAnimatedElement iAnimatedElement, int i6, int i7, int i8, int i9, IResourceProvider iResourceProvider2, Object... objArr2) {
                Interceptable interceptable2 = $ic;
                if (!(interceptable2 == null || interceptable2.invokeCommon(1048576, this, new Object[]{iAnimatedElement, Integer.valueOf(i6), Integer.valueOf(i7), Integer.valueOf(i8), Integer.valueOf(i9), iResourceProvider2, objArr2}) == null) || iAnimatedElement == null) {
                    return;
                }
                if (objArr2 == null) {
                    iAnimatedElement.init(i6, i7, i8, i9, iResourceProvider2, new Object[0]);
                } else {
                    iAnimatedElement.init(i6, i7, i8, i9, iResourceProvider2, objArr2);
                }
            }
        };
    }

    public abstract float getPraiseLevelFactorPosX();

    public int getPraiseLevelSize() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? DeviceUtil.ScreenInfo.dp2px(AppRuntime.getAppContext(), 170.0f) : invokeV.intValue;
    }

    public float getPraiseNumFactorDeltaX() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return 0.1f;
        }
        return invokeV.floatValue;
    }

    public float getPraiseNumFactorHeight() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return 0.25f;
        }
        return invokeV.floatValue;
    }

    public float getPraiseNumFactorPosX() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return 0.1f;
        }
        return invokeV.floatValue;
    }

    public float getPraiseNumFactorPosY() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return 0.15f;
        }
        return invokeV.floatValue;
    }

    public float getPraiseNumRatio() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return 0.61f;
        }
        return invokeV.floatValue;
    }

    @Override // com.baidu.searchbox.ui.animview.praise.layout.ILayoutStrategy
    public void getSize(int i2, Map<Integer, IAnimatedElement> map, int[] iArr) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeILL(1048583, this, i2, map, iArr) == null) || iArr == null || iArr.length < 2 || map == null || map.size() <= 0) {
            return;
        }
        if (i2 == 0) {
            iArr[0] = DeviceUtil.ScreenInfo.dp2px(AppRuntime.getAppContext(), 116.0f);
            iArr[1] = iArr[0];
        } else if (i2 == 1) {
            iArr[0] = DeviceUtil.ScreenInfo.dp2px(AppRuntime.getAppContext(), 21.0f);
            iArr[1] = iArr[0];
        } else if (i2 == 2) {
            iArr[0] = getPraiseLevelSize();
            iArr[1] = iArr[0];
        } else if (i2 != 3) {
            if (i2 != 4) {
                return;
            }
            iArr[0] = DeviceUtil.ScreenInfo.dp2px(AppRuntime.getAppContext(), 313.0f);
            iArr[1] = iArr[0];
        } else {
            IAnimatedElement iAnimatedElement = map.get(2);
            if (iAnimatedElement != null) {
                iArr[1] = (int) ((iAnimatedElement.getHeight() * getPraiseNumFactorHeight()) + 0.5f);
            }
            iArr[0] = (int) ((iArr[1] * getPraiseNumRatio()) + 0.5f);
        }
    }

    @Override // com.baidu.searchbox.ui.animview.praise.layout.ILayoutStrategy
    public void layout(int i2, Map<Integer, IAnimatedElement> map) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2, map) == null) {
            layout(i2, map, null);
        }
    }

    @Override // com.baidu.searchbox.ui.animview.praise.layout.ILayoutStrategy
    public void layout(int i2, Map<Integer, IAnimatedElement> map, ILayoutStrategy.ICallback iCallback) {
        IAnimatedElement iAnimatedElement;
        int centerX;
        int centerY;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeILL(1048585, this, i2, map, iCallback) == null) {
            if (iCallback == null) {
                iCallback = this.mCallback;
            }
            ILayoutStrategy.ICallback iCallback2 = iCallback;
            if (map == null || map.size() <= 0 || (iAnimatedElement = map.get(Integer.valueOf(i2))) == null) {
                return;
            }
            int[] iArr = new int[2];
            getSize(i2, map, iArr);
            if (i2 == 0 || i2 == 1) {
                centerX = this.mBaseRect.centerX() - (iArr[0] / 2);
                centerY = this.mBaseRect.centerY() - (iArr[1] / 2);
            } else if (i2 == 2) {
                centerX = (int) ((this.mBaseRect.centerX() - (iArr[0] * getPraiseLevelFactorPosX())) + 0.5f);
                centerY = (int) ((this.mBaseRect.centerY() - iArr[1]) + 0.5f);
            } else if (i2 == 3) {
                IAnimatedElement iAnimatedElement2 = map.get(2);
                if (iAnimatedElement2 != null) {
                    iCallback2.init(iAnimatedElement, ((iAnimatedElement2.getLeft() + (iAnimatedElement2.getWidth() / 2)) - ((int) ((getPraiseNumFactorPosX() * iAnimatedElement2.getWidth()) + 0.5f))) - iArr[0], (int) ((((iAnimatedElement2.getTop() + iAnimatedElement2.getHeight()) - (iAnimatedElement2.getHeight() * getPraiseNumFactorPosY())) - iArr[1]) + 0.5f), iArr[0], iArr[1], this.mProvider, Integer.valueOf((int) ((getPraiseNumFactorDeltaX() * iAnimatedElement2.getWidth()) + 0.5f)));
                    return;
                }
                return;
            } else if (i2 != 4) {
                return;
            } else {
                centerX = this.mBaseRect.centerX() - (iArr[0] / 2);
                centerY = (this.mBaseRect.centerY() - iArr[1]) + DeviceUtil.ScreenInfo.dp2px(AppRuntime.getAppContext(), 2.0f);
            }
            iCallback2.init(iAnimatedElement, centerX, centerY, iArr[0], iArr[1], this.mProvider, new Object[0]);
        }
    }
}
