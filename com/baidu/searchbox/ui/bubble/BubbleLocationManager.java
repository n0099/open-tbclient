package com.baidu.searchbox.ui.bubble;

import android.content.Context;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.common.ui.R;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.util.devices.DeviceUtil;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.searchbox.ui.bubble.views.BubbleBaseView;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class BubbleLocationManager {
    public static /* synthetic */ Interceptable $ic = null;
    public static final boolean DEBUG = false;
    public static final String TAG = "BubbleLocation";
    public transient /* synthetic */ FieldHolder $fh;
    public boolean isShowLeftEndPoint;
    public float mBetweenPadding;
    public BubblePosition mBubbleForceShowPosition;
    public boolean mD20Template;
    public boolean mIsAutoDetectShowPosition;
    public float mOffsetOfArrow;

    /* renamed from: com.baidu.searchbox.ui.bubble.BubbleLocationManager$1  reason: invalid class name */
    /* loaded from: classes7.dex */
    public static /* synthetic */ class AnonymousClass1 {
        public static final /* synthetic */ int[] $SwitchMap$com$baidu$searchbox$ui$bubble$BubblePosition;
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-895541500, "Lcom/baidu/searchbox/ui/bubble/BubbleLocationManager$1;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-895541500, "Lcom/baidu/searchbox/ui/bubble/BubbleLocationManager$1;");
                    return;
                }
            }
            int[] iArr = new int[BubblePosition.values().length];
            $SwitchMap$com$baidu$searchbox$ui$bubble$BubblePosition = iArr;
            try {
                iArr[BubblePosition.UP.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$baidu$searchbox$ui$bubble$BubblePosition[BubblePosition.DOWN.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$baidu$searchbox$ui$bubble$BubblePosition[BubblePosition.LEFT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$baidu$searchbox$ui$bubble$BubblePosition[BubblePosition.RIGHT.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    public BubbleLocationManager() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.isShowLeftEndPoint = false;
        this.mBetweenPadding = 0.0f;
        this.mIsAutoDetectShowPosition = true;
        this.mBubbleForceShowPosition = BubblePosition.INVALID;
        this.mD20Template = true;
    }

    private int getAnchorCenterDownMargin(BubbleBaseView bubbleBaseView) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65537, this, bubbleBaseView)) == null) ? (bubbleBaseView.mRootView.getMeasuredHeight() - getAnchorInRoot(bubbleBaseView)[1]) - (bubbleBaseView.mAnchorView.getMeasuredHeight() / 2) : invokeL.intValue;
    }

    private int getAnchorCenterLeftMargin(BubbleBaseView bubbleBaseView) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65538, this, bubbleBaseView)) == null) ? getAnchorInRoot(bubbleBaseView)[0] + (bubbleBaseView.mAnchorView.getMeasuredWidth() / 2) : invokeL.intValue;
    }

    private int getAnchorCenterUpMargin(BubbleBaseView bubbleBaseView) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65539, this, bubbleBaseView)) == null) ? getAnchorInRoot(bubbleBaseView)[1] + (bubbleBaseView.mAnchorView.getMeasuredHeight() / 2) : invokeL.intValue;
    }

    private int[] getAnchorInRoot(BubbleBaseView bubbleBaseView) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, this, bubbleBaseView)) == null) {
            int[] iArr = new int[2];
            bubbleBaseView.mAnchorView.getLocationOnScreen(iArr);
            int[] iArr2 = new int[2];
            bubbleBaseView.mRootView.getLocationOnScreen(iArr2);
            return new int[]{iArr[0] - iArr2[0], iArr[1] - iArr2[1]};
        }
        return (int[]) invokeL.objValue;
    }

    private int getBubbleRadius(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.AD_TEXT_ID, this, context)) == null) {
            if (this.mD20Template) {
                return context.getResources().getDimensionPixelSize(R.dimen.bubble_radius_d20);
            }
            return context.getResources().getDimensionPixelSize(R.dimen.bubble_radius);
        }
        return invokeL.intValue;
    }

    private boolean isDisplayableAtDown(BubbleBaseView bubbleBaseView) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.BAIDU_LOGO_ID, this, bubbleBaseView)) == null) ? bubbleBaseView.mBubbleView.getMeasuredHeight() + DeviceUtil.ScreenInfo.dp2px(bubbleBaseView.mAnchorView.getContext(), this.mBetweenPadding) <= (bubbleBaseView.mRootView.getMeasuredHeight() - bubbleBaseView.mAnchorView.getMeasuredHeight()) - getAnchorInRoot(bubbleBaseView)[1] && isVerticalArrowShowAbleThreshold(bubbleBaseView) : invokeL.booleanValue;
    }

    private boolean isDisplayableAtLeft(BubbleBaseView bubbleBaseView) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65543, this, bubbleBaseView)) == null) ? bubbleBaseView.mBubbleView.getMeasuredWidth() + DeviceUtil.ScreenInfo.dp2px(bubbleBaseView.mAnchorView.getContext(), this.mBetweenPadding) <= getAnchorInRoot(bubbleBaseView)[0] && isHorizontalArrowShowAble(bubbleBaseView) : invokeL.booleanValue;
    }

    private boolean isDisplayableAtPosition(BubbleBaseView bubbleBaseView, BubblePosition bubblePosition) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65544, this, bubbleBaseView, bubblePosition)) == null) {
            int i2 = AnonymousClass1.$SwitchMap$com$baidu$searchbox$ui$bubble$BubblePosition[bubblePosition.ordinal()];
            if (i2 != 1) {
                if (i2 != 2) {
                    if (i2 != 3) {
                        if (i2 != 4) {
                            return false;
                        }
                        return isDisplayableAtRight(bubbleBaseView);
                    }
                    return isDisplayableAtLeft(bubbleBaseView);
                }
                return isDisplayableAtDown(bubbleBaseView);
            }
            return isDisplayableAtUp(bubbleBaseView);
        }
        return invokeLL.booleanValue;
    }

    private boolean isDisplayableAtRight(BubbleBaseView bubbleBaseView) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65545, this, bubbleBaseView)) == null) ? bubbleBaseView.mBubbleView.getMeasuredWidth() + DeviceUtil.ScreenInfo.dp2px(bubbleBaseView.mAnchorView.getContext(), this.mBetweenPadding) <= (bubbleBaseView.mRootView.getMeasuredWidth() - bubbleBaseView.mAnchorView.getMeasuredWidth()) - getAnchorInRoot(bubbleBaseView)[0] && isHorizontalArrowShowAble(bubbleBaseView) : invokeL.booleanValue;
    }

    private boolean isDisplayableAtUp(BubbleBaseView bubbleBaseView) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65546, this, bubbleBaseView)) == null) ? bubbleBaseView.mBubbleView.getMeasuredHeight() + DeviceUtil.ScreenInfo.dp2px(bubbleBaseView.mAnchorView.getContext(), this.mBetweenPadding) <= getAnchorInRoot(bubbleBaseView)[1] && isVerticalArrowShowAbleThreshold(bubbleBaseView) : invokeL.booleanValue;
    }

    private boolean isHorizontalArrowShowAble(BubbleBaseView bubbleBaseView) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65547, this, bubbleBaseView)) == null) {
            float f2 = this.mD20Template ? 0.0f : 15.0f;
            Context context = bubbleBaseView.mAnchorView.getContext();
            int dp2px = DeviceUtil.ScreenInfo.dp2px(context, f2) + context.getResources().getDimensionPixelSize(R.dimen.bubble_radius) + (context.getResources().getDimensionPixelSize(R.dimen.bubble_horizontal_arrow_view_height) / 2);
            return dp2px <= getAnchorCenterUpMargin(bubbleBaseView) && dp2px <= getAnchorCenterDownMargin(bubbleBaseView);
        }
        return invokeL.booleanValue;
    }

    private boolean isVerticalArrowShowAbleThreshold(BubbleBaseView bubbleBaseView) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65548, this, bubbleBaseView)) == null) {
            float f2 = this.mD20Template ? 0.0f : 15.0f;
            Context context = bubbleBaseView.mAnchorView.getContext();
            int dp2px = DeviceUtil.ScreenInfo.dp2px(context, f2) + (getBubbleRadius(context) / 2) + (context.getResources().getDimensionPixelSize(R.dimen.bubble_vertical_arrow_view_width) / 2);
            return dp2px <= getAnchorCenterLeftMargin(bubbleBaseView) && dp2px <= getAnchorCenterRightMargin(bubbleBaseView);
        }
        return invokeL.booleanValue;
    }

    public int[] adjustPosition(BubbleBaseView bubbleBaseView, int[] iArr, BubblePosition bubblePosition) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048576, this, bubbleBaseView, iArr, bubblePosition)) == null) {
            if (bubbleBaseView == null) {
                return new int[]{0, 0};
            }
            if (bubblePosition == BubblePosition.INVALID) {
                return iArr;
            }
            Context context = bubbleBaseView.mRootView.getContext();
            int i2 = iArr[0];
            int i3 = iArr[1];
            int[] iArr2 = new int[2];
            int measuredWidth = bubbleBaseView.mBubbleView.getMeasuredWidth();
            int measuredHeight = bubbleBaseView.mBubbleView.getMeasuredHeight();
            int measuredWidth2 = bubbleBaseView.mRootView.getMeasuredWidth();
            int measuredHeight2 = bubbleBaseView.mRootView.getMeasuredHeight();
            float f2 = this.mD20Template ? 0.0f : 15.0f;
            if (bubblePosition != BubblePosition.UP && bubblePosition != BubblePosition.DOWN) {
                if (bubblePosition == BubblePosition.LEFT || bubblePosition == BubblePosition.RIGHT) {
                    int i4 = measuredHeight / 2;
                    if (i4 >= i3) {
                        iArr2[1] = DeviceUtil.ScreenInfo.dp2px(context, f2);
                    } else if (i4 >= measuredHeight2 - i3) {
                        iArr2[1] = (measuredHeight2 - measuredHeight) - DeviceUtil.ScreenInfo.dp2px(context, f2);
                    } else {
                        iArr2[1] = iArr[1] - (bubbleBaseView.mBubbleView.getMeasuredHeight() / 2);
                    }
                    if (bubblePosition == BubblePosition.LEFT) {
                        iArr2[0] = iArr[0] - bubbleBaseView.mBubbleView.getMeasuredWidth();
                    } else {
                        iArr2[0] = iArr[0];
                    }
                }
            } else {
                int i5 = measuredWidth / 2;
                if (i5 >= i2) {
                    iArr2[0] = DeviceUtil.ScreenInfo.dp2px(context, f2);
                } else if (i5 >= measuredWidth2 - i2) {
                    iArr2[0] = (measuredWidth2 - measuredWidth) - DeviceUtil.ScreenInfo.dp2px(context, f2);
                } else {
                    iArr2[0] = iArr[0] - (bubbleBaseView.mBubbleView.getMeasuredWidth() / 2);
                }
                if (bubblePosition == BubblePosition.UP) {
                    iArr2[1] = iArr[1] - bubbleBaseView.mBubbleView.getMeasuredHeight();
                } else {
                    iArr2[1] = iArr[1];
                }
            }
            return iArr2;
        }
        return (int[]) invokeLLL.objValue;
    }

    public BubblePosition detectShowPosition(BubbleBaseView bubbleBaseView) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bubbleBaseView)) == null) {
            if (!bubbleBaseView.isViewsValidate()) {
                return BubblePosition.INVALID;
            }
            if (this.mIsAutoDetectShowPosition) {
                if (isDisplayableAtUp(bubbleBaseView)) {
                    return BubblePosition.UP;
                }
                if (isDisplayableAtDown(bubbleBaseView)) {
                    return BubblePosition.DOWN;
                }
                if (isDisplayableAtLeft(bubbleBaseView)) {
                    return BubblePosition.LEFT;
                }
                if (isDisplayableAtRight(bubbleBaseView)) {
                    return BubblePosition.RIGHT;
                }
                return BubblePosition.INVALID;
            } else if (isDisplayableAtPosition(bubbleBaseView, this.mBubbleForceShowPosition)) {
                return this.mBubbleForceShowPosition;
            } else {
                return BubblePosition.INVALID;
            }
        }
        return (BubblePosition) invokeL.objValue;
    }

    public void enableD20Template(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z) == null) {
            this.mD20Template = z;
        }
    }

    public int getAnchorCenterRightMargin(BubbleBaseView bubbleBaseView) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, bubbleBaseView)) == null) ? (bubbleBaseView.mRootView.getMeasuredWidth() - getAnchorInRoot(bubbleBaseView)[0]) - (bubbleBaseView.mAnchorView.getMeasuredWidth() / 2) : invokeL.intValue;
    }

    public int[] getShowPosition(BubblePosition bubblePosition, BubbleBaseView bubbleBaseView) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048580, this, bubblePosition, bubbleBaseView)) == null) {
            if (bubblePosition == null || bubbleBaseView == null) {
                return new int[]{0, 0};
            }
            int[] iArr = new int[2];
            bubbleBaseView.mAnchorView.getLocationOnScreen(iArr);
            int[] iArr2 = new int[2];
            bubbleBaseView.mRootView.getLocationOnScreen(iArr2);
            int[] iArr3 = new int[2];
            if (bubblePosition == BubblePosition.UP) {
                iArr3[0] = iArr[0] - iArr2[0];
                if (!this.isShowLeftEndPoint) {
                    iArr3[0] = iArr3[0] + (bubbleBaseView.mAnchorView.getMeasuredWidth() / 2);
                }
                iArr3[1] = (iArr[1] - iArr2[1]) - DeviceUtil.ScreenInfo.dp2px(bubbleBaseView.mAnchorView.getContext(), this.mBetweenPadding);
            } else if (bubblePosition == BubblePosition.DOWN) {
                iArr3[0] = iArr[0] - iArr2[0];
                if (!this.isShowLeftEndPoint) {
                    iArr3[0] = iArr3[0] + (bubbleBaseView.mAnchorView.getMeasuredWidth() / 2);
                }
                iArr3[1] = (iArr[1] - iArr2[1]) + bubbleBaseView.mAnchorView.getMeasuredHeight() + DeviceUtil.ScreenInfo.dp2px(bubbleBaseView.mAnchorView.getContext(), this.mBetweenPadding);
            } else if (bubblePosition == BubblePosition.LEFT) {
                iArr3[0] = ((iArr[0] - iArr2[0]) - (bubbleBaseView.mArrowDown.getMeasuredWidth() / 2)) - DeviceUtil.ScreenInfo.dp2px(bubbleBaseView.mAnchorView.getContext(), this.mBetweenPadding);
                iArr3[1] = (iArr[1] - iArr2[1]) + (bubbleBaseView.mAnchorView.getMeasuredHeight() / 2);
            } else if (bubblePosition == BubblePosition.RIGHT) {
                iArr3[0] = (iArr[0] - iArr2[0]) + bubbleBaseView.mAnchorView.getMeasuredWidth() + DeviceUtil.ScreenInfo.dp2px(bubbleBaseView.mAnchorView.getContext(), this.mBetweenPadding);
                iArr3[1] = (iArr[1] - iArr2[1]) + (bubbleBaseView.mAnchorView.getMeasuredHeight() / 2);
            }
            int[] adjustPosition = adjustPosition(bubbleBaseView, iArr3, bubblePosition);
            if (bubblePosition != BubblePosition.UP && bubblePosition != BubblePosition.DOWN) {
                if (bubblePosition == BubblePosition.LEFT || bubblePosition == BubblePosition.RIGHT) {
                    bubbleBaseView.mBubbleArrow.setY(((iArr3[1] - adjustPosition[1]) - Math.max(bubbleBaseView.mArrowLeft.getMeasuredHeight() / 2, bubbleBaseView.mArrowRight.getMeasuredHeight() / 2)) + this.mOffsetOfArrow);
                }
            } else {
                bubbleBaseView.mBubbleArrow.setX(((iArr3[0] - adjustPosition[0]) - Math.max(bubbleBaseView.mArrowDown.getMeasuredWidth() / 2, bubbleBaseView.mArrowUp.getMeasuredWidth() / 2)) + this.mOffsetOfArrow);
            }
            return adjustPosition;
        }
        return (int[]) invokeLL.objValue;
    }

    public void setPaddingBetweenAnchor(float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048581, this, f2) == null) {
            this.mBetweenPadding = f2;
        }
    }
}
