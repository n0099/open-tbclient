package com.baidu.searchbox.player.utils;

import android.annotation.SuppressLint;
import android.app.Activity;
import androidx.annotation.Nullable;
import com.baidu.searchbox.player.annotation.PublicMethod;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes2.dex */
public class BdActivityUtils {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public BdActivityUtils() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    @PublicMethod
    @SuppressLint({"SourceLockedOrientationActivity"})
    public static void requestLandscape(@Nullable Activity activity, boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLZ(65537, null, activity, z) == null) && activity != null) {
            if (z) {
                activity.setRequestedOrientation(8);
            } else {
                activity.setRequestedOrientation(0);
            }
            activity.getWindow().setFlags(1024, 1024);
        }
    }

    @PublicMethod
    @SuppressLint({"SourceLockedOrientationActivity"})
    public static void requestPortrait(@Nullable Activity activity) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65538, null, activity) == null) && activity != null) {
            activity.setRequestedOrientation(1);
        }
    }
}
