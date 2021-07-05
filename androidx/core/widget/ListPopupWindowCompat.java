package androidx.core.widget;

import android.os.Build;
import android.view.View;
import android.widget.ListPopupWindow;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes.dex */
public final class ListPopupWindowCompat {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public ListPopupWindowCompat() {
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
    public static View.OnTouchListener createDragToOpenListener(Object obj, View view) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, obj, view)) == null) ? createDragToOpenListener((ListPopupWindow) obj, view) : (View.OnTouchListener) invokeLL.objValue;
    }

    @Nullable
    public static View.OnTouchListener createDragToOpenListener(@NonNull ListPopupWindow listPopupWindow, @NonNull View view) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, listPopupWindow, view)) == null) {
            if (Build.VERSION.SDK_INT >= 19) {
                return listPopupWindow.createDragToOpenListener(view);
            }
            return null;
        }
        return (View.OnTouchListener) invokeLL.objValue;
    }
}
