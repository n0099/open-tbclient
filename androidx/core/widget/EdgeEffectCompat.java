package androidx.core.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.os.Build;
import android.widget.EdgeEffect;
import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes.dex */
public final class EdgeEffectCompat {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public EdgeEffect mEdgeEffect;

    @Deprecated
    public EdgeEffectCompat(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mEdgeEffect = new EdgeEffect(context);
    }

    @Deprecated
    public boolean draw(Canvas canvas) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, canvas)) == null) ? this.mEdgeEffect.draw(canvas) : invokeL.booleanValue;
    }

    @Deprecated
    public void finish() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.mEdgeEffect.finish();
        }
    }

    @Deprecated
    public boolean isFinished() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.mEdgeEffect.isFinished() : invokeV.booleanValue;
    }

    @Deprecated
    public boolean onAbsorb(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048579, this, i2)) == null) {
            this.mEdgeEffect.onAbsorb(i2);
            return true;
        }
        return invokeI.booleanValue;
    }

    @Deprecated
    public boolean onPull(float f2) {
        InterceptResult invokeF;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeF = interceptable.invokeF(1048580, this, f2)) == null) {
            this.mEdgeEffect.onPull(f2);
            return true;
        }
        return invokeF.booleanValue;
    }

    @Deprecated
    public boolean onRelease() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            this.mEdgeEffect.onRelease();
            return this.mEdgeEffect.isFinished();
        }
        return invokeV.booleanValue;
    }

    @Deprecated
    public void setSize(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048583, this, i2, i3) == null) {
            this.mEdgeEffect.setSize(i2, i3);
        }
    }

    @Deprecated
    public boolean onPull(float f2, float f3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048581, this, new Object[]{Float.valueOf(f2), Float.valueOf(f3)})) == null) {
            onPull(this.mEdgeEffect, f2, f3);
            return true;
        }
        return invokeCommon.booleanValue;
    }

    public static void onPull(@NonNull EdgeEffect edgeEffect, float f2, float f3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65537, null, new Object[]{edgeEffect, Float.valueOf(f2), Float.valueOf(f3)}) == null) {
            if (Build.VERSION.SDK_INT >= 21) {
                edgeEffect.onPull(f2, f3);
            } else {
                edgeEffect.onPull(f2);
            }
        }
    }
}
