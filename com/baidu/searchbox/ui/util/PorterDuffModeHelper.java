package com.baidu.searchbox.ui.util;

import android.content.Context;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.Drawable;
import androidx.core.view.InputDeviceCompat;
import com.airbnb.lottie.LottieDrawable;
import com.airbnb.lottie.LottieProperty;
import com.airbnb.lottie.model.KeyPath;
import com.airbnb.lottie.value.LottieFrameInfo;
import com.airbnb.lottie.value.SimpleLottieValueCallback;
import com.baidu.android.common.ui.R;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public final class PorterDuffModeHelper {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int COLOR_FF = 255;
    public static final boolean DEBUG = false;
    public static final String TAG = "PorterDuffModeHelper";
    public transient /* synthetic */ FieldHolder $fh;

    public PorterDuffModeHelper() {
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

    public static void decorateSpecificMode(Context context, Drawable drawable, PorterDuff.Mode mode, int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLLI(65537, null, context, drawable, mode, i2) == null) || context == null || drawable == null) {
            return;
        }
        decorateSpecificMode(context, drawable, mode, i2, getUiCoverLayerColor(context));
    }

    public static void decorateSrcATopMode(Context context, Drawable drawable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65539, null, context, drawable) == null) {
            decorateSrcATopMode(context, drawable, 255);
        }
    }

    public static int getUiCoverLayerColor(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.AD_TEXT_ID, null, context)) == null) ? context.getResources().getColor(R.color.ui_cover_layer_color) : invokeL.intValue;
    }

    public static void decorateSpecificMode(Context context, Drawable drawable, PorterDuff.Mode mode, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(65538, null, new Object[]{context, drawable, mode, Integer.valueOf(i2), Integer.valueOf(i3)}) == null) || context == null || drawable == null) {
            return;
        }
        if (i2 >= 0 && i2 < 255) {
            i3 = Color.argb((Color.alpha(i3) * i2) / 255, Color.red(i3), Color.green(i3), Color.blue(i3));
        }
        if (drawable instanceof LottieDrawable) {
            LottieDrawable lottieDrawable = (LottieDrawable) drawable;
            lottieDrawable.addValueCallback(new KeyPath("**"), (KeyPath) LottieProperty.COLOR_FILTER, (SimpleLottieValueCallback<KeyPath>) new SimpleLottieValueCallback<ColorFilter>() { // from class: com.baidu.searchbox.ui.util.PorterDuffModeHelper.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i4 = newInitContext.flag;
                        if ((i4 & 1) != 0) {
                            int i5 = i4 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                        }
                    }
                }

                /* JADX DEBUG: Method merged with bridge method */
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // com.airbnb.lottie.value.SimpleLottieValueCallback
                public ColorFilter getValue(LottieFrameInfo<ColorFilter> lottieFrameInfo) {
                    InterceptResult invokeL;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL = interceptable2.invokeL(1048576, this, lottieFrameInfo)) == null) {
                        return null;
                    }
                    return (ColorFilter) invokeL.objValue;
                }
            });
            lottieDrawable.addValueCallback(new KeyPath("**"), (KeyPath) LottieProperty.COLOR_FILTER, (SimpleLottieValueCallback<KeyPath>) new SimpleLottieValueCallback<ColorFilter>(new PorterDuffColorFilter(i3, mode)) { // from class: com.baidu.searchbox.ui.util.PorterDuffModeHelper.2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ ColorFilter val$colorFilter;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {r6};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i4 = newInitContext.flag;
                        if ((i4 & 1) != 0) {
                            int i5 = i4 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.val$colorFilter = r6;
                }

                /* JADX DEBUG: Method merged with bridge method */
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // com.airbnb.lottie.value.SimpleLottieValueCallback
                public ColorFilter getValue(LottieFrameInfo<ColorFilter> lottieFrameInfo) {
                    InterceptResult invokeL;
                    Interceptable interceptable2 = $ic;
                    return (interceptable2 == null || (invokeL = interceptable2.invokeL(1048576, this, lottieFrameInfo)) == null) ? this.val$colorFilter : (ColorFilter) invokeL.objValue;
                }
            });
            return;
        }
        drawable.setColorFilter(i3, mode);
    }

    public static void decorateSrcATopMode(Context context, Drawable drawable, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(InputDeviceCompat.SOURCE_TRACKBALL, null, context, drawable, i2) == null) {
            decorateSpecificMode(context, drawable, PorterDuff.Mode.SRC_ATOP, i2);
        }
    }
}
