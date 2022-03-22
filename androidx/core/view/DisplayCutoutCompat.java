package androidx.core.view;

import android.graphics.Rect;
import android.os.Build;
import android.view.DisplayCutout;
import androidx.annotation.RequiresApi;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
/* loaded from: classes.dex */
public final class DisplayCutoutCompat {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final Object mDisplayCutout;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public DisplayCutoutCompat(Rect rect, List<Rect> list) {
        this(Build.VERSION.SDK_INT >= 28 ? new DisplayCutout(rect, list) : null);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {rect, list};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                this(newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public static DisplayCutoutCompat wrap(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, obj)) == null) {
            if (obj == null) {
                return null;
            }
            return new DisplayCutoutCompat(obj);
        }
        return (DisplayCutoutCompat) invokeL.objValue;
    }

    public boolean equals(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, obj)) == null) {
            if (this == obj) {
                return true;
            }
            if (obj == null || DisplayCutoutCompat.class != obj.getClass()) {
                return false;
            }
            DisplayCutoutCompat displayCutoutCompat = (DisplayCutoutCompat) obj;
            Object obj2 = this.mDisplayCutout;
            if (obj2 == null) {
                return displayCutoutCompat.mDisplayCutout == null;
            }
            return obj2.equals(displayCutoutCompat.mDisplayCutout);
        }
        return invokeL.booleanValue;
    }

    public List<Rect> getBoundingRects() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            if (Build.VERSION.SDK_INT >= 28) {
                return ((DisplayCutout) this.mDisplayCutout).getBoundingRects();
            }
            return null;
        }
        return (List) invokeV.objValue;
    }

    public int getSafeInsetBottom() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            if (Build.VERSION.SDK_INT >= 28) {
                return ((DisplayCutout) this.mDisplayCutout).getSafeInsetBottom();
            }
            return 0;
        }
        return invokeV.intValue;
    }

    public int getSafeInsetLeft() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            if (Build.VERSION.SDK_INT >= 28) {
                return ((DisplayCutout) this.mDisplayCutout).getSafeInsetLeft();
            }
            return 0;
        }
        return invokeV.intValue;
    }

    public int getSafeInsetRight() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            if (Build.VERSION.SDK_INT >= 28) {
                return ((DisplayCutout) this.mDisplayCutout).getSafeInsetRight();
            }
            return 0;
        }
        return invokeV.intValue;
    }

    public int getSafeInsetTop() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            if (Build.VERSION.SDK_INT >= 28) {
                return ((DisplayCutout) this.mDisplayCutout).getSafeInsetTop();
            }
            return 0;
        }
        return invokeV.intValue;
    }

    public int hashCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            Object obj = this.mDisplayCutout;
            if (obj == null) {
                return 0;
            }
            return obj.hashCode();
        }
        return invokeV.intValue;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return "DisplayCutoutCompat{" + this.mDisplayCutout + "}";
        }
        return (String) invokeV.objValue;
    }

    @RequiresApi(api = 28)
    public DisplayCutout unwrap() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? (DisplayCutout) this.mDisplayCutout : (DisplayCutout) invokeV.objValue;
    }

    public DisplayCutoutCompat(Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {obj};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.mDisplayCutout = obj;
    }
}
