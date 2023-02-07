package androidx.core.view;

import android.graphics.Rect;
import android.os.Build;
import android.view.DisplayCutout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.core.graphics.Insets;
import androidx.core.os.BuildCompat;
import androidx.core.util.ObjectsCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
/* loaded from: classes.dex */
public final class DisplayCutoutCompat {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final Object mDisplayCutout;

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public DisplayCutoutCompat(Rect rect, List<Rect> list) {
        this(r0);
        DisplayCutout displayCutout;
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
        if (Build.VERSION.SDK_INT >= 28) {
            displayCutout = new DisplayCutout(rect, list);
        } else {
            displayCutout = null;
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public DisplayCutoutCompat(@NonNull Insets insets, @Nullable Rect rect, @Nullable Rect rect2, @Nullable Rect rect3, @Nullable Rect rect4, @NonNull Insets insets2) {
        this(constructDisplayCutout(insets, rect, rect2, rect3, rect4, insets2));
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {insets, rect, rect2, rect3, rect4, insets2};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                this(newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    public DisplayCutoutCompat(Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {obj};
            interceptable.invokeUnInit(65538, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.mDisplayCutout = obj;
    }

    public static DisplayCutoutCompat wrap(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, obj)) == null) {
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
            if (obj != null && DisplayCutoutCompat.class == obj.getClass()) {
                return ObjectsCompat.equals(this.mDisplayCutout, ((DisplayCutoutCompat) obj).mDisplayCutout);
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public static DisplayCutout constructDisplayCutout(@NonNull Insets insets, @Nullable Rect rect, @Nullable Rect rect2, @Nullable Rect rect3, @Nullable Rect rect4, @NonNull Insets insets2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65539, null, new Object[]{insets, rect, rect2, rect3, rect4, insets2})) == null) {
            if (BuildCompat.isAtLeastR()) {
                return new DisplayCutout(insets.toPlatformInsets(), rect, rect2, rect3, rect4, insets2.toPlatformInsets());
            }
            int i = Build.VERSION.SDK_INT;
            if (i >= 29) {
                return new DisplayCutout(insets.toPlatformInsets(), rect, rect2, rect3, rect4);
            }
            if (i >= 28) {
                Rect rect5 = new Rect(insets.left, insets.top, insets.right, insets.bottom);
                ArrayList arrayList = new ArrayList();
                if (rect != null) {
                    arrayList.add(rect);
                }
                if (rect2 != null) {
                    arrayList.add(rect2);
                }
                if (rect3 != null) {
                    arrayList.add(rect3);
                }
                if (rect4 != null) {
                    arrayList.add(rect4);
                }
                return new DisplayCutout(rect5, arrayList);
            }
            return null;
        }
        return (DisplayCutout) invokeCommon.objValue;
    }

    @NonNull
    public List<Rect> getBoundingRects() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            if (Build.VERSION.SDK_INT >= 28) {
                return ((DisplayCutout) this.mDisplayCutout).getBoundingRects();
            }
            return Collections.emptyList();
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

    @NonNull
    public Insets getWaterfallInsets() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            if (BuildCompat.isAtLeastR()) {
                return Insets.toCompatInsets(((DisplayCutout) this.mDisplayCutout).getWaterfallInsets());
            }
            return Insets.NONE;
        }
        return (Insets) invokeV.objValue;
    }

    public int hashCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
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
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return "DisplayCutoutCompat{" + this.mDisplayCutout + "}";
        }
        return (String) invokeV.objValue;
    }

    @RequiresApi(api = 28)
    public DisplayCutout unwrap() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            return (DisplayCutout) this.mDisplayCutout;
        }
        return (DisplayCutout) invokeV.objValue;
    }
}
