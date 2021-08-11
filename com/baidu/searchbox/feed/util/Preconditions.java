package com.baidu.searchbox.feed.util;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public final class Preconditions {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public Preconditions() {
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

    public static void checkArgumentFalse(boolean z, @Nullable Object obj, @NonNull String str, @Nullable Object... objArr) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(65537, null, new Object[]{Boolean.valueOf(z), obj, str, objArr}) == null) && z) {
            throw new IllegalArgumentException(String.format(str, objArr));
        }
    }

    public static void checkStateFalse(boolean z, @Nullable Object obj, @NonNull String str, @Nullable Object... objArr) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(65539, null, new Object[]{Boolean.valueOf(z), obj, str, objArr}) == null) && z) {
            throw new IllegalStateException(String.format(str, objArr));
        }
    }

    public static boolean isIllegalArgument(boolean z, @NonNull String str, @Nullable Object... objArr) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(AdIconUtil.AD_TEXT_ID, null, new Object[]{Boolean.valueOf(z), str, objArr})) == null) {
            if (z) {
                throw new IllegalArgumentException(String.format(str, objArr));
            }
            return z;
        }
        return invokeCommon.booleanValue;
    }

    public static boolean isIllegalState(boolean z, @NonNull String str, @Nullable Object... objArr) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65543, null, new Object[]{Boolean.valueOf(z), str, objArr})) == null) {
            if (z) {
                throw new IllegalStateException(String.format(str, objArr));
            }
            return z;
        }
        return invokeCommon.booleanValue;
    }

    public static void checkArgumentFalse(boolean z, @Nullable Object obj, @NonNull Throwable th) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(65538, null, new Object[]{Boolean.valueOf(z), obj, th}) == null) && z) {
            throw new IllegalArgumentException(th);
        }
    }

    public static void checkStateFalse(boolean z, @Nullable Object obj, @NonNull Throwable th) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TRACKBALL, null, new Object[]{Boolean.valueOf(z), obj, th}) == null) && z) {
            throw new IllegalStateException(th);
        }
    }

    public static boolean isIllegalArgument(boolean z, @NonNull Throwable th) {
        InterceptResult invokeZL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZL = interceptable.invokeZL(AdIconUtil.BAIDU_LOGO_ID, null, z, th)) == null) {
            if (z) {
                throw new IllegalArgumentException(th);
            }
            return z;
        }
        return invokeZL.booleanValue;
    }

    public static boolean isIllegalState(boolean z, @NonNull Throwable th) {
        InterceptResult invokeZL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZL = interceptable.invokeZL(65544, null, z, th)) == null) {
            if (z) {
                throw new IllegalStateException(th);
            }
            return z;
        }
        return invokeZL.booleanValue;
    }
}
