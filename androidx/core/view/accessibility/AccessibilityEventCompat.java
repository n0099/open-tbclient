package androidx.core.view.accessibility;

import android.os.Build;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityRecord;
import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes.dex */
public final class AccessibilityEventCompat {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int CONTENT_CHANGE_TYPE_CONTENT_DESCRIPTION = 4;
    public static final int CONTENT_CHANGE_TYPE_PANE_APPEARED = 16;
    public static final int CONTENT_CHANGE_TYPE_PANE_DISAPPEARED = 32;
    public static final int CONTENT_CHANGE_TYPE_PANE_TITLE = 8;
    public static final int CONTENT_CHANGE_TYPE_SUBTREE = 1;
    public static final int CONTENT_CHANGE_TYPE_TEXT = 2;
    public static final int CONTENT_CHANGE_TYPE_UNDEFINED = 0;
    public static final int TYPES_ALL_MASK = -1;
    public static final int TYPE_ANNOUNCEMENT = 16384;
    public static final int TYPE_ASSIST_READING_CONTEXT = 16777216;
    public static final int TYPE_GESTURE_DETECTION_END = 524288;
    public static final int TYPE_GESTURE_DETECTION_START = 262144;
    @Deprecated
    public static final int TYPE_TOUCH_EXPLORATION_GESTURE_END = 1024;
    @Deprecated
    public static final int TYPE_TOUCH_EXPLORATION_GESTURE_START = 512;
    public static final int TYPE_TOUCH_INTERACTION_END = 2097152;
    public static final int TYPE_TOUCH_INTERACTION_START = 1048576;
    public static final int TYPE_VIEW_ACCESSIBILITY_FOCUSED = 32768;
    public static final int TYPE_VIEW_ACCESSIBILITY_FOCUS_CLEARED = 65536;
    public static final int TYPE_VIEW_CONTEXT_CLICKED = 8388608;
    @Deprecated
    public static final int TYPE_VIEW_HOVER_ENTER = 128;
    @Deprecated
    public static final int TYPE_VIEW_HOVER_EXIT = 256;
    @Deprecated
    public static final int TYPE_VIEW_SCROLLED = 4096;
    @Deprecated
    public static final int TYPE_VIEW_TEXT_SELECTION_CHANGED = 8192;
    public static final int TYPE_VIEW_TEXT_TRAVERSED_AT_MOVEMENT_GRANULARITY = 131072;
    public static final int TYPE_WINDOWS_CHANGED = 4194304;
    @Deprecated
    public static final int TYPE_WINDOW_CONTENT_CHANGED = 2048;
    public transient /* synthetic */ FieldHolder $fh;

    public AccessibilityEventCompat() {
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

    @Deprecated
    public static void appendRecord(AccessibilityEvent accessibilityEvent, AccessibilityRecordCompat accessibilityRecordCompat) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65537, null, accessibilityEvent, accessibilityRecordCompat) == null) {
            accessibilityEvent.appendRecord((AccessibilityRecord) accessibilityRecordCompat.getImpl());
        }
    }

    @Deprecated
    public static AccessibilityRecordCompat asRecord(AccessibilityEvent accessibilityEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, accessibilityEvent)) == null) ? new AccessibilityRecordCompat(accessibilityEvent) : (AccessibilityRecordCompat) invokeL.objValue;
    }

    public static int getAction(AccessibilityEvent accessibilityEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, accessibilityEvent)) == null) {
            if (Build.VERSION.SDK_INT >= 16) {
                return accessibilityEvent.getAction();
            }
            return 0;
        }
        return invokeL.intValue;
    }

    public static int getContentChangeTypes(AccessibilityEvent accessibilityEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, accessibilityEvent)) == null) {
            if (Build.VERSION.SDK_INT >= 19) {
                return accessibilityEvent.getContentChangeTypes();
            }
            return 0;
        }
        return invokeL.intValue;
    }

    public static int getMovementGranularity(AccessibilityEvent accessibilityEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, accessibilityEvent)) == null) {
            if (Build.VERSION.SDK_INT >= 16) {
                return accessibilityEvent.getMovementGranularity();
            }
            return 0;
        }
        return invokeL.intValue;
    }

    @Deprecated
    public static AccessibilityRecordCompat getRecord(AccessibilityEvent accessibilityEvent, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLI = interceptable.invokeLI(65542, null, accessibilityEvent, i2)) == null) ? new AccessibilityRecordCompat(accessibilityEvent.getRecord(i2)) : (AccessibilityRecordCompat) invokeLI.objValue;
    }

    @Deprecated
    public static int getRecordCount(AccessibilityEvent accessibilityEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65543, null, accessibilityEvent)) == null) ? accessibilityEvent.getRecordCount() : invokeL.intValue;
    }

    public static void setAction(AccessibilityEvent accessibilityEvent, int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(65544, null, accessibilityEvent, i2) == null) || Build.VERSION.SDK_INT < 16) {
            return;
        }
        accessibilityEvent.setAction(i2);
    }

    public static void setContentChangeTypes(AccessibilityEvent accessibilityEvent, int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(65545, null, accessibilityEvent, i2) == null) || Build.VERSION.SDK_INT < 19) {
            return;
        }
        accessibilityEvent.setContentChangeTypes(i2);
    }

    public static void setMovementGranularity(AccessibilityEvent accessibilityEvent, int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(65546, null, accessibilityEvent, i2) == null) || Build.VERSION.SDK_INT < 16) {
            return;
        }
        accessibilityEvent.setMovementGranularity(i2);
    }
}
