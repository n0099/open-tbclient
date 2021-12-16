package com.baidu.sapi2.utils;

import android.app.Activity;
import android.content.Context;
import android.os.Vibrator;
import com.baidu.sapi2.NoProguard;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes10.dex */
public class VibrateUtils implements NoProguard {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String TAG = "VibrateUtils";
    public transient /* synthetic */ FieldHolder $fh;

    public VibrateUtils() {
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

    public static void presetVibrate(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65537, null, context) == null) {
            if (context == null) {
                Log.e(TAG, "context must can not be null");
            } else {
                ((Vibrator) context.getSystemService("vibrator")).vibrate(new long[]{200, 500}, -1);
            }
        }
    }

    public static void vibrate(Context context, long[] jArr, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(65538, null, context, jArr, i2) == null) {
            if (context == null) {
                Log.e(TAG, "context must can not be null");
            } else {
                ((Vibrator) context.getSystemService("vibrator")).vibrate(jArr, i2);
            }
        }
    }

    public static void virateCancle(Activity activity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, null, activity) == null) {
            ((Vibrator) activity.getSystemService("vibrator")).cancel();
        }
    }
}
