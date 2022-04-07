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
/* loaded from: classes2.dex */
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

    /* loaded from: classes2.dex */
    public interface IOrientationChange {
        void onOrientationChanged(int i);
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], ((Integer) objArr2[1]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public static boolean isLandscape(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(65538, null, i)) == null) ? Math.abs(i + (-90)) <= 23 || Math.abs(i + (-270)) <= 23 : invokeI.booleanValue;
    }

    public static boolean isPortrait(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(65539, null, i)) == null) ? (i >= 0 && i <= 23) || (337 <= i && i < 360) || Math.abs(i + (-180)) <= 23 : invokeI.booleanValue;
    }

    public static boolean isReverseLandscape(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(InputDeviceCompat.SOURCE_TRACKBALL, null, i)) == null) ? Math.abs(i + (-90)) <= 23 : invokeI.booleanValue;
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
            } catch (Exception e) {
                BdVideoLog.w("enableSensor()", e);
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
    public void onOrientationChanged(int i) {
        IOrientationChange iOrientationChange;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i) == null) {
            this.mLastOrientation = i;
            if (i == -1 || (iOrientationChange = this.mListener) == null) {
                return;
            }
            iOrientationChange.onOrientationChanged(i);
        }
    }

    public void setListener(IOrientationChange iOrientationChange) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, iOrientationChange) == null) {
            this.mListener = iOrientationChange;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public OrientationHelper(Context context, int i) {
        super(context, i);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, Integer.valueOf(i)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], ((Integer) objArr2[1]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }
}
