package com.baidu.searchbox.ui.view;

import android.content.Context;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.common.ui.R;
import com.baidu.android.util.devices.DeviceUtil;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.searchbox.ui.view.BadgeView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class BadgeFactory {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public BadgeFactory() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public static BadgeView createBadgeView(Context context, BadgeView.Type type) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, context, type)) == null) {
            BadgeView badgeView = new BadgeView(context);
            badgeView.setId(R.id.badge_view);
            badgeView.setType(type);
            return badgeView;
        }
        return (BadgeView) invokeLL.objValue;
    }

    public static BadgeView createBadgeViewInPx(Context context, BadgeView.Type type, int i2, int i3, int i4, int i5, int i6) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65539, null, new Object[]{context, type, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i6)})) == null) {
            BadgeView badgeView = new BadgeView(context);
            badgeView.setId(R.id.badge_view);
            badgeView.setType(type);
            badgeView.setBadgeMarginInPx(i3, i4, i5, i6);
            return badgeView;
        }
        return (BadgeView) invokeCommon.objValue;
    }

    @Deprecated
    public static BadgeView createDot(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, context)) == null) ? createBadgeView(context, BadgeView.Type.DOT, 53, 5, 10, 0, 0) : (BadgeView) invokeL.objValue;
    }

    @Deprecated
    public static BadgeView createMainTabBadge(Context context, boolean z) {
        InterceptResult invokeLZ;
        BadgeView createBadgeView;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(65543, null, context, z)) == null) {
            if (z) {
                createBadgeView = createBadgeView(context, BadgeView.Type.SMALL_TEXT, 49, 13, 5, 0, 0);
            } else {
                createBadgeView = createBadgeView(context, BadgeView.Type.SMALL_TEXT, 49, 13, 3, 0, 0);
            }
            createBadgeView.setId(R.id.badge_view);
            return createBadgeView;
        }
        return (BadgeView) invokeLZ.objValue;
    }

    public static BadgeView createMenuBadge(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65544, null, context)) == null) ? createBadgeView(context, BadgeView.Type.SMALL_TEXT, 53, 0, 0, 0, 0) : (BadgeView) invokeL.objValue;
    }

    @Deprecated
    public static BadgeView createTopMainTabBadge(Context context, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65545, null, context, i2)) == null) {
            BadgeView createBadgeView = createBadgeView(context, BadgeView.Type.SMALL_TEXT, 51, DeviceUtil.ScreenInfo.px2dp(context, i2) - 12, 3, 0, 0);
            createBadgeView.setId(R.id.badge_view);
            createBadgeView.setText("10+");
            return createBadgeView;
        }
        return (BadgeView) invokeLI.objValue;
    }

    @Deprecated
    public static BadgeView createDot(Context context, int i2, int i3, int i4, int i5) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(AdIconUtil.AD_TEXT_ID, null, new Object[]{context, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5)})) == null) ? createBadgeView(context, BadgeView.Type.DOT, 53, i2, i3, i4, i5) : (BadgeView) invokeCommon.objValue;
    }

    public static BadgeView createBadgeView(Context context, BadgeView.Type type, int i2, int i3, int i4, int i5, int i6) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65538, null, new Object[]{context, type, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i6)})) == null) {
            BadgeView badgeView = new BadgeView(context);
            badgeView.setId(R.id.badge_view);
            badgeView.setType(type);
            badgeView.setBadgeMargin(i3, i4, i5, i6);
            return badgeView;
        }
        return (BadgeView) invokeCommon.objValue;
    }

    @Deprecated
    public static BadgeView createMainTabBadge(Context context, int i2, int i3, int i4, int i5, int i6) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(AdIconUtil.BAIDU_LOGO_ID, null, new Object[]{context, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i6)})) == null) ? createBadgeView(context, BadgeView.Type.SMALL_TEXT, 49, i3, i4, i5, i6) : (BadgeView) invokeCommon.objValue;
    }
}
