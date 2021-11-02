package com.baidu.android.util.android;

import android.content.Context;
import android.os.Build;
import android.os.VibrationEffect;
import android.os.Vibrator;
import androidx.annotation.RequiresPermission;
import androidx.core.content.ContextCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class VibrateUtils {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int[] amplitudes;
    public Context mContext;
    public Vibrator mVibrator;
    public long[] timings;

    /* renamed from: com.baidu.android.util.android.VibrateUtils$1  reason: invalid class name */
    /* loaded from: classes6.dex */
    public static /* synthetic */ class AnonymousClass1 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes6.dex */
    public static final class Builder {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public int[] amplitudes;
        public Context mContext;
        public Vibrator mVibrator;
        public long[] timings;

        public Builder(Vibrator vibrator, long[] jArr, Context context) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {vibrator, jArr, context};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.mVibrator = vibrator;
            this.mContext = context;
            this.timings = jArr;
        }

        public Builder amplitudes(int[] iArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, iArr)) == null) {
                this.amplitudes = iArr;
                return this;
            }
            return (Builder) invokeL.objValue;
        }

        public VibrateUtils build() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? new VibrateUtils(this, null) : (VibrateUtils) invokeV.objValue;
        }
    }

    public /* synthetic */ VibrateUtils(Builder builder, AnonymousClass1 anonymousClass1) {
        this(builder);
    }

    private boolean checkVibratePermission() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, this)) == null) {
            Context context = this.mContext;
            return context != null && ContextCompat.checkSelfPermission(context, "android.permission.VIBRATE") == 0;
        }
        return invokeV.booleanValue;
    }

    @RequiresPermission("android.permission.VIBRATE")
    public void cancelVibrator() {
        Vibrator vibrator;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && (vibrator = this.mVibrator) != null && vibrator.hasVibrator() && checkVibratePermission()) {
            this.mVibrator.cancel();
        }
    }

    @RequiresPermission("android.permission.VIBRATE")
    public void vibrateStart() {
        Vibrator vibrator;
        long[] jArr;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || !checkVibratePermission() || (vibrator = this.mVibrator) == null || (jArr = this.timings) == null || jArr.length <= 0 || !vibrator.hasVibrator()) {
            return;
        }
        if (Build.VERSION.SDK_INT >= 26) {
            int[] iArr = this.amplitudes;
            if (iArr != null && iArr.length > 0) {
                long[] jArr2 = this.timings;
                if (jArr2.length == iArr.length) {
                    if (jArr2.length == 1) {
                        this.mVibrator.vibrate(VibrationEffect.createOneShot(jArr2[0], iArr[0]));
                        return;
                    } else {
                        this.mVibrator.vibrate(VibrationEffect.createWaveform(jArr2, iArr, -1));
                        return;
                    }
                } else if (jArr2.length == 1) {
                    this.mVibrator.vibrate(VibrationEffect.createOneShot(jArr2[0], iArr[0]));
                    return;
                } else {
                    this.mVibrator.vibrate(VibrationEffect.createWaveform(jArr2, -1));
                    return;
                }
            }
            long[] jArr3 = this.timings;
            if (jArr3.length == 1) {
                this.mVibrator.vibrate(VibrationEffect.createOneShot(jArr3[0], -1));
                return;
            } else {
                this.mVibrator.vibrate(VibrationEffect.createWaveform(jArr3, -1));
                return;
            }
        }
        long[] jArr4 = this.timings;
        if (jArr4.length == 1) {
            this.mVibrator.vibrate(jArr4[0]);
        } else {
            this.mVibrator.vibrate(jArr4, -1);
        }
    }

    public VibrateUtils(Builder builder) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {builder};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mVibrator = builder.mVibrator;
        this.timings = builder.timings;
        this.amplitudes = builder.amplitudes;
        this.mContext = builder.mContext;
    }
}
