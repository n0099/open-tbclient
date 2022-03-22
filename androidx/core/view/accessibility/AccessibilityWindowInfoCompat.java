package androidx.core.view.accessibility;

import android.graphics.Rect;
import android.os.Build;
import android.view.accessibility.AccessibilityWindowInfo;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes.dex */
public class AccessibilityWindowInfoCompat {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int TYPE_ACCESSIBILITY_OVERLAY = 4;
    public static final int TYPE_APPLICATION = 1;
    public static final int TYPE_INPUT_METHOD = 2;
    public static final int TYPE_SPLIT_SCREEN_DIVIDER = 5;
    public static final int TYPE_SYSTEM = 3;
    public static final int UNDEFINED = -1;
    public transient /* synthetic */ FieldHolder $fh;
    public Object mInfo;

    public AccessibilityWindowInfoCompat(Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {obj};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mInfo = obj;
    }

    public static AccessibilityWindowInfoCompat obtain() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            if (Build.VERSION.SDK_INT >= 21) {
                return wrapNonNullInstance(AccessibilityWindowInfo.obtain());
            }
            return null;
        }
        return (AccessibilityWindowInfoCompat) invokeV.objValue;
    }

    public static String typeToString(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(65539, null, i)) == null) ? i != 1 ? i != 2 ? i != 3 ? i != 4 ? "<UNKNOWN>" : "TYPE_ACCESSIBILITY_OVERLAY" : "TYPE_SYSTEM" : "TYPE_INPUT_METHOD" : "TYPE_APPLICATION" : (String) invokeI.objValue;
    }

    public static AccessibilityWindowInfoCompat wrapNonNullInstance(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, obj)) == null) {
            if (obj != null) {
                return new AccessibilityWindowInfoCompat(obj);
            }
            return null;
        }
        return (AccessibilityWindowInfoCompat) invokeL.objValue;
    }

    public boolean equals(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, obj)) == null) {
            if (this == obj) {
                return true;
            }
            if (obj != null && (obj instanceof AccessibilityWindowInfoCompat)) {
                AccessibilityWindowInfoCompat accessibilityWindowInfoCompat = (AccessibilityWindowInfoCompat) obj;
                Object obj2 = this.mInfo;
                if (obj2 == null) {
                    if (accessibilityWindowInfoCompat.mInfo != null) {
                        return false;
                    }
                } else if (!obj2.equals(accessibilityWindowInfoCompat.mInfo)) {
                    return false;
                }
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public AccessibilityNodeInfoCompat getAnchor() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            if (Build.VERSION.SDK_INT >= 24) {
                return AccessibilityNodeInfoCompat.wrapNonNullInstance(((AccessibilityWindowInfo) this.mInfo).getAnchor());
            }
            return null;
        }
        return (AccessibilityNodeInfoCompat) invokeV.objValue;
    }

    public void getBoundsInScreen(Rect rect) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, rect) == null) || Build.VERSION.SDK_INT < 21) {
            return;
        }
        ((AccessibilityWindowInfo) this.mInfo).getBoundsInScreen(rect);
    }

    public AccessibilityWindowInfoCompat getChild(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048579, this, i)) == null) {
            if (Build.VERSION.SDK_INT >= 21) {
                return wrapNonNullInstance(((AccessibilityWindowInfo) this.mInfo).getChild(i));
            }
            return null;
        }
        return (AccessibilityWindowInfoCompat) invokeI.objValue;
    }

    public int getChildCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            if (Build.VERSION.SDK_INT >= 21) {
                return ((AccessibilityWindowInfo) this.mInfo).getChildCount();
            }
            return 0;
        }
        return invokeV.intValue;
    }

    public int getId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            if (Build.VERSION.SDK_INT >= 21) {
                return ((AccessibilityWindowInfo) this.mInfo).getId();
            }
            return -1;
        }
        return invokeV.intValue;
    }

    public int getLayer() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            if (Build.VERSION.SDK_INT >= 21) {
                return ((AccessibilityWindowInfo) this.mInfo).getLayer();
            }
            return -1;
        }
        return invokeV.intValue;
    }

    public AccessibilityWindowInfoCompat getParent() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            if (Build.VERSION.SDK_INT >= 21) {
                return wrapNonNullInstance(((AccessibilityWindowInfo) this.mInfo).getParent());
            }
            return null;
        }
        return (AccessibilityWindowInfoCompat) invokeV.objValue;
    }

    public AccessibilityNodeInfoCompat getRoot() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            if (Build.VERSION.SDK_INT >= 21) {
                return AccessibilityNodeInfoCompat.wrapNonNullInstance(((AccessibilityWindowInfo) this.mInfo).getRoot());
            }
            return null;
        }
        return (AccessibilityNodeInfoCompat) invokeV.objValue;
    }

    public CharSequence getTitle() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            if (Build.VERSION.SDK_INT >= 24) {
                return ((AccessibilityWindowInfo) this.mInfo).getTitle();
            }
            return null;
        }
        return (CharSequence) invokeV.objValue;
    }

    public int getType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            if (Build.VERSION.SDK_INT >= 21) {
                return ((AccessibilityWindowInfo) this.mInfo).getType();
            }
            return -1;
        }
        return invokeV.intValue;
    }

    public int hashCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            Object obj = this.mInfo;
            if (obj == null) {
                return 0;
            }
            return obj.hashCode();
        }
        return invokeV.intValue;
    }

    public boolean isAccessibilityFocused() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            if (Build.VERSION.SDK_INT >= 21) {
                return ((AccessibilityWindowInfo) this.mInfo).isAccessibilityFocused();
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public boolean isActive() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            if (Build.VERSION.SDK_INT >= 21) {
                return ((AccessibilityWindowInfo) this.mInfo).isActive();
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public boolean isFocused() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            if (Build.VERSION.SDK_INT >= 21) {
                return ((AccessibilityWindowInfo) this.mInfo).isFocused();
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public void recycle() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048591, this) == null) || Build.VERSION.SDK_INT < 21) {
            return;
        }
        ((AccessibilityWindowInfo) this.mInfo).recycle();
    }

    @NonNull
    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            StringBuilder sb = new StringBuilder();
            Rect rect = new Rect();
            getBoundsInScreen(rect);
            sb.append("AccessibilityWindowInfo[");
            sb.append("id=");
            sb.append(getId());
            sb.append(", type=");
            sb.append(typeToString(getType()));
            sb.append(", layer=");
            sb.append(getLayer());
            sb.append(", bounds=");
            sb.append(rect);
            sb.append(", focused=");
            sb.append(isFocused());
            sb.append(", active=");
            sb.append(isActive());
            sb.append(", hasParent=");
            sb.append(getParent() != null);
            sb.append(", hasChildren=");
            sb.append(getChildCount() > 0);
            sb.append(']');
            return sb.toString();
        }
        return (String) invokeV.objValue;
    }

    public static AccessibilityWindowInfoCompat obtain(AccessibilityWindowInfoCompat accessibilityWindowInfoCompat) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, accessibilityWindowInfoCompat)) == null) {
            if (Build.VERSION.SDK_INT < 21 || accessibilityWindowInfoCompat == null) {
                return null;
            }
            return wrapNonNullInstance(AccessibilityWindowInfo.obtain((AccessibilityWindowInfo) accessibilityWindowInfoCompat.mInfo));
        }
        return (AccessibilityWindowInfoCompat) invokeL.objValue;
    }
}
