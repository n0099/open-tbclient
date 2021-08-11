package com.baidu.ar.arplay.core.engine.rotate;

import android.content.Context;
import android.view.OrientationEventListener;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes5.dex */
public class OrientationManager extends OrientationEventListener {
    public static /* synthetic */ Interceptable $ic;
    public static boolean isScreenOrientationLandscape;
    public static Orientation sGlobalOrientation;
    public transient /* synthetic */ FieldHolder $fh;
    public Orientation mCurrentOrientation;
    public List<OrientationListener> mListeners;

    /* loaded from: classes5.dex */
    public interface OrientationListener {
        void onRotateOrientation(Orientation orientation);
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1075588383, "Lcom/baidu/ar/arplay/core/engine/rotate/OrientationManager;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1075588383, "Lcom/baidu/ar/arplay/core/engine/rotate/OrientationManager;");
                return;
            }
        }
        sGlobalOrientation = Orientation.UNKNOWN;
        isScreenOrientationLandscape = false;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public OrientationManager(Context context) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.mCurrentOrientation = Orientation.PORTRAIT;
        this.mListeners = new ArrayList();
    }

    public static Orientation calcOrientation(int i2, Orientation orientation) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(65538, null, i2, orientation)) == null) {
            if (isScreenOrientationLandscape) {
                i2 = (i2 + 90) % 360;
            }
            Orientation certainOrientation = certainOrientation(i2);
            if (certainOrientation != null) {
                return certainOrientation;
            }
            Orientation[] probablyOrientation = probablyOrientation(i2);
            return (orientation == probablyOrientation[0] || orientation == probablyOrientation[1]) ? orientation : nearOrientation(i2);
        }
        return (Orientation) invokeIL.objValue;
    }

    public static Orientation certainOrientation(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65539, null, i2)) == null) {
            if ((i2 < 0 || i2 > 10) && (i2 < 350 || i2 > 359)) {
                if (i2 < 80 || i2 > 100) {
                    if (i2 < 170 || i2 > 190) {
                        if (i2 < 260 || i2 > 280) {
                            return null;
                        }
                        return Orientation.LANDSCAPE_REVERSE;
                    }
                    return Orientation.PORTRAIT_REVERSE;
                }
                return Orientation.LANDSCAPE;
            }
            return Orientation.PORTRAIT;
        }
        return (Orientation) invokeI.objValue;
    }

    public static Orientation getGlobalOrientation() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) ? sGlobalOrientation : (Orientation) invokeV.objValue;
    }

    public static Orientation nearOrientation(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(AdIconUtil.AD_TEXT_ID, null, i2)) == null) ? ((i2 < 0 || i2 > 45) && (i2 < 315 || i2 >= 360)) ? (i2 <= 45 || i2 >= 135) ? (i2 < 135 || i2 > 225) ? (i2 <= 225 || i2 >= 315) ? Orientation.PORTRAIT : Orientation.LANDSCAPE_REVERSE : Orientation.PORTRAIT_REVERSE : Orientation.LANDSCAPE : Orientation.PORTRAIT : (Orientation) invokeI.objValue;
    }

    public static Orientation[] probablyOrientation(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(AdIconUtil.BAIDU_LOGO_ID, null, i2)) == null) ? (i2 <= 0 || i2 >= 90) ? (i2 <= 90 || i2 >= 180) ? (i2 <= 180 || i2 >= 270) ? new Orientation[]{Orientation.LANDSCAPE_REVERSE, Orientation.PORTRAIT} : new Orientation[]{Orientation.PORTRAIT_REVERSE, Orientation.LANDSCAPE_REVERSE} : new Orientation[]{Orientation.LANDSCAPE, Orientation.PORTRAIT} : new Orientation[]{Orientation.PORTRAIT, Orientation.LANDSCAPE} : (Orientation[]) invokeI.objValue;
    }

    public static void setGlobalOrientation(Orientation orientation) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65543, null, orientation) == null) {
            sGlobalOrientation = orientation;
        }
    }

    public void addOrientationListener(OrientationListener orientationListener) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, orientationListener) == null) || orientationListener == null || this.mListeners.contains(orientationListener)) {
            return;
        }
        this.mListeners.add(orientationListener);
    }

    public void destroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            sGlobalOrientation = Orientation.UNKNOWN;
            this.mListeners.clear();
        }
    }

    @Override // android.view.OrientationEventListener
    public void disable() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            try {
                super.disable();
            } catch (RuntimeException e2) {
                e2.printStackTrace();
            }
        }
    }

    @Override // android.view.OrientationEventListener
    public void enable() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            try {
                super.enable();
            } catch (RuntimeException e2) {
                e2.printStackTrace();
            }
        }
    }

    public void notifyOrientationChanged() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            notifyOrientationChanged(this.mCurrentOrientation);
        }
    }

    public void notifyOrientationChanged(Orientation orientation) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, orientation) == null) {
            setGlobalOrientation(orientation);
            for (OrientationListener orientationListener : this.mListeners) {
                orientationListener.onRotateOrientation(orientation);
            }
        }
    }

    @Override // android.view.OrientationEventListener
    public void onOrientationChanged(int i2) {
        Orientation calcOrientation;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048582, this, i2) == null) || i2 == -1 || (calcOrientation = calcOrientation(i2, this.mCurrentOrientation)) == null) {
            return;
        }
        if (sGlobalOrientation == Orientation.UNKNOWN) {
            sGlobalOrientation = calcOrientation;
        }
        if (this.mCurrentOrientation != calcOrientation) {
            this.mCurrentOrientation = calcOrientation;
            notifyOrientationChanged(calcOrientation);
        }
    }

    public void removeOrientationListener(OrientationListener orientationListener) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048583, this, orientationListener) == null) && orientationListener != null && this.mListeners.contains(orientationListener)) {
            this.mListeners.remove(orientationListener);
        }
    }

    public void setScreenOrientationLandscape(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, z) == null) {
            isScreenOrientationLandscape = z;
        }
    }
}
