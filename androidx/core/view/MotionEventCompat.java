package androidx.core.view;

import android.view.MotionEvent;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes.dex */
public final class MotionEventCompat {
    public static /* synthetic */ Interceptable $ic = null;
    @Deprecated
    public static final int ACTION_HOVER_ENTER = 9;
    @Deprecated
    public static final int ACTION_HOVER_EXIT = 10;
    @Deprecated
    public static final int ACTION_HOVER_MOVE = 7;
    @Deprecated
    public static final int ACTION_MASK = 255;
    @Deprecated
    public static final int ACTION_POINTER_DOWN = 5;
    @Deprecated
    public static final int ACTION_POINTER_INDEX_MASK = 65280;
    @Deprecated
    public static final int ACTION_POINTER_INDEX_SHIFT = 8;
    @Deprecated
    public static final int ACTION_POINTER_UP = 6;
    @Deprecated
    public static final int ACTION_SCROLL = 8;
    @Deprecated
    public static final int AXIS_BRAKE = 23;
    @Deprecated
    public static final int AXIS_DISTANCE = 24;
    @Deprecated
    public static final int AXIS_GAS = 22;
    @Deprecated
    public static final int AXIS_GENERIC_1 = 32;
    @Deprecated
    public static final int AXIS_GENERIC_10 = 41;
    @Deprecated
    public static final int AXIS_GENERIC_11 = 42;
    @Deprecated
    public static final int AXIS_GENERIC_12 = 43;
    @Deprecated
    public static final int AXIS_GENERIC_13 = 44;
    @Deprecated
    public static final int AXIS_GENERIC_14 = 45;
    @Deprecated
    public static final int AXIS_GENERIC_15 = 46;
    @Deprecated
    public static final int AXIS_GENERIC_16 = 47;
    @Deprecated
    public static final int AXIS_GENERIC_2 = 33;
    @Deprecated
    public static final int AXIS_GENERIC_3 = 34;
    @Deprecated
    public static final int AXIS_GENERIC_4 = 35;
    @Deprecated
    public static final int AXIS_GENERIC_5 = 36;
    @Deprecated
    public static final int AXIS_GENERIC_6 = 37;
    @Deprecated
    public static final int AXIS_GENERIC_7 = 38;
    @Deprecated
    public static final int AXIS_GENERIC_8 = 39;
    @Deprecated
    public static final int AXIS_GENERIC_9 = 40;
    @Deprecated
    public static final int AXIS_HAT_X = 15;
    @Deprecated
    public static final int AXIS_HAT_Y = 16;
    @Deprecated
    public static final int AXIS_HSCROLL = 10;
    @Deprecated
    public static final int AXIS_LTRIGGER = 17;
    @Deprecated
    public static final int AXIS_ORIENTATION = 8;
    @Deprecated
    public static final int AXIS_PRESSURE = 2;
    public static final int AXIS_RELATIVE_X = 27;
    public static final int AXIS_RELATIVE_Y = 28;
    @Deprecated
    public static final int AXIS_RTRIGGER = 18;
    @Deprecated
    public static final int AXIS_RUDDER = 20;
    @Deprecated
    public static final int AXIS_RX = 12;
    @Deprecated
    public static final int AXIS_RY = 13;
    @Deprecated
    public static final int AXIS_RZ = 14;
    public static final int AXIS_SCROLL = 26;
    @Deprecated
    public static final int AXIS_SIZE = 3;
    @Deprecated
    public static final int AXIS_THROTTLE = 19;
    @Deprecated
    public static final int AXIS_TILT = 25;
    @Deprecated
    public static final int AXIS_TOOL_MAJOR = 6;
    @Deprecated
    public static final int AXIS_TOOL_MINOR = 7;
    @Deprecated
    public static final int AXIS_TOUCH_MAJOR = 4;
    @Deprecated
    public static final int AXIS_TOUCH_MINOR = 5;
    @Deprecated
    public static final int AXIS_VSCROLL = 9;
    @Deprecated
    public static final int AXIS_WHEEL = 21;
    @Deprecated
    public static final int AXIS_X = 0;
    @Deprecated
    public static final int AXIS_Y = 1;
    @Deprecated
    public static final int AXIS_Z = 11;
    @Deprecated
    public static final int BUTTON_PRIMARY = 1;
    public transient /* synthetic */ FieldHolder $fh;

    public MotionEventCompat() {
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

    @Deprecated
    public static int findPointerIndex(MotionEvent motionEvent, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65537, null, motionEvent, i)) == null) {
            return motionEvent.findPointerIndex(i);
        }
        return invokeLI.intValue;
    }

    @Deprecated
    public static float getAxisValue(MotionEvent motionEvent, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(InputDeviceCompat.SOURCE_TRACKBALL, null, motionEvent, i)) == null) {
            return motionEvent.getAxisValue(i);
        }
        return invokeLI.floatValue;
    }

    @Deprecated
    public static int getPointerId(MotionEvent motionEvent, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65544, null, motionEvent, i)) == null) {
            return motionEvent.getPointerId(i);
        }
        return invokeLI.intValue;
    }

    @Deprecated
    public static float getX(MotionEvent motionEvent, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65546, null, motionEvent, i)) == null) {
            return motionEvent.getX(i);
        }
        return invokeLI.floatValue;
    }

    @Deprecated
    public static float getY(MotionEvent motionEvent, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65547, null, motionEvent, i)) == null) {
            return motionEvent.getY(i);
        }
        return invokeLI.floatValue;
    }

    public static boolean isFromSource(MotionEvent motionEvent, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65548, null, motionEvent, i)) == null) {
            if ((motionEvent.getSource() & i) == i) {
                return true;
            }
            return false;
        }
        return invokeLI.booleanValue;
    }

    @Deprecated
    public static int getActionIndex(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, motionEvent)) == null) {
            return motionEvent.getActionIndex();
        }
        return invokeL.intValue;
    }

    @Deprecated
    public static int getActionMasked(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, motionEvent)) == null) {
            return motionEvent.getActionMasked();
        }
        return invokeL.intValue;
    }

    @Deprecated
    public static int getButtonState(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, null, motionEvent)) == null) {
            return motionEvent.getButtonState();
        }
        return invokeL.intValue;
    }

    @Deprecated
    public static int getPointerCount(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, null, motionEvent)) == null) {
            return motionEvent.getPointerCount();
        }
        return invokeL.intValue;
    }

    @Deprecated
    public static int getSource(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65545, null, motionEvent)) == null) {
            return motionEvent.getSource();
        }
        return invokeL.intValue;
    }

    @Deprecated
    public static float getAxisValue(MotionEvent motionEvent, int i, int i2) {
        InterceptResult invokeLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(65541, null, motionEvent, i, i2)) == null) {
            return motionEvent.getAxisValue(i, i2);
        }
        return invokeLII.floatValue;
    }
}
