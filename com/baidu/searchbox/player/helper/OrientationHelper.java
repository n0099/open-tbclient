package com.baidu.searchbox.player.helper;

import android.content.Context;
import android.provider.Settings;
import android.view.OrientationEventListener;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.player.utils.BdVideoLog;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class OrientationHelper extends OrientationEventListener {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int ORIENTATION_CIRCLE_ANGLE = 360;
    public static final int ORIENTATION_DIVIDE_ANGLE = 23;
    public static final int ORIENTATION_LANDSCAPE_ANGLE_LEFT = 270;
    public static final int ORIENTATION_LANDSCAPE_ANGLE_RIGHT = 90;
    public static final int ORIENTATION_PORTRAIT_ANGLE_BOTTOM = 180;
    public static final int ORIENTATION_PORTRAIT_ANGLE_TOP = 0;
    public transient /* synthetic */ FieldHolder $fh;
    public int mLastOrientation;
    public IOrientationChange mListener;

    /* loaded from: classes4.dex */
    public interface IOrientationChange {
        void onOrientationChanged(int i2);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public OrientationHelper(Context context) {
        this(context, 3);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], ((Integer) objArr2[1]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public static boolean isLandscape(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(65538, null, i2)) == null) ? Math.abs(i2 + (-90)) <= 23 || Math.abs(i2 + (-270)) <= 23 : invokeI.booleanValue;
    }

    public static boolean isPortrait(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(65539, null, i2)) == null) ? (i2 >= 0 && i2 <= 23) || (337 <= i2 && i2 < 360) || Math.abs(i2 + (-180)) <= 23 : invokeI.booleanValue;
    }

    public static boolean isReverseLandscape(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(InputDeviceCompat.SOURCE_TRACKBALL, null, i2)) == null) ? Math.abs(i2 + (-90)) <= 23 : invokeI.booleanValue;
    }

    public static boolean isSystemOrientationLocked(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65541, null, context)) == null) ? Settings.System.getInt(context.getContentResolver(), "accelerometer_rotation", 0) == 0 : invokeL.booleanValue;
    }

    public boolean enableSensor() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            try {
                super.enable();
                return true;
            } catch (Exception e2) {
                BdVideoLog.w("enableSensor()", e2);
                return false;
            }
        }
        return invokeV.booleanValue;
    }

    public int getLastOrientation() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.mLastOrientation : invokeV.intValue;
    }

    @Override // android.view.OrientationEventListener
    public void onOrientationChanged(int i2) {
        IOrientationChange iOrientationChange;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2) == null) {
            this.mLastOrientation = i2;
            if (i2 == -1 || (iOrientationChange = this.mListener) == null) {
                return;
            }
            iOrientationChange.onOrientationChanged(i2);
        }
    }

    public void setListener(IOrientationChange iOrientationChange) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, iOrientationChange) == null) {
            this.mListener = iOrientationChange;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public OrientationHelper(Context context, int i2) {
        super(context, i2);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, Integer.valueOf(i2)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], ((Integer) objArr2[1]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }
}
