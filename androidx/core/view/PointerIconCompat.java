package androidx.core.view;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.os.Build;
import android.view.PointerIcon;
import androidx.annotation.RestrictTo;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes.dex */
public final class PointerIconCompat {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int TYPE_ALIAS = 1010;
    public static final int TYPE_ALL_SCROLL = 1013;
    public static final int TYPE_ARROW = 1000;
    public static final int TYPE_CELL = 1006;
    public static final int TYPE_CONTEXT_MENU = 1001;
    public static final int TYPE_COPY = 1011;
    public static final int TYPE_CROSSHAIR = 1007;
    public static final int TYPE_DEFAULT = 1000;
    public static final int TYPE_GRAB = 1020;
    public static final int TYPE_GRABBING = 1021;
    public static final int TYPE_HAND = 1002;
    public static final int TYPE_HELP = 1003;
    public static final int TYPE_HORIZONTAL_DOUBLE_ARROW = 1014;
    public static final int TYPE_NO_DROP = 1012;
    public static final int TYPE_NULL = 0;
    public static final int TYPE_TEXT = 1008;
    public static final int TYPE_TOP_LEFT_DIAGONAL_DOUBLE_ARROW = 1017;
    public static final int TYPE_TOP_RIGHT_DIAGONAL_DOUBLE_ARROW = 1016;
    public static final int TYPE_VERTICAL_DOUBLE_ARROW = 1015;
    public static final int TYPE_VERTICAL_TEXT = 1009;
    public static final int TYPE_WAIT = 1004;
    public static final int TYPE_ZOOM_IN = 1018;
    public static final int TYPE_ZOOM_OUT = 1019;
    public transient /* synthetic */ FieldHolder $fh;
    public Object mPointerIcon;

    public PointerIconCompat(Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {obj};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mPointerIcon = obj;
    }

    public static PointerIconCompat create(Bitmap bitmap, float f2, float f3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65537, null, new Object[]{bitmap, Float.valueOf(f2), Float.valueOf(f3)})) == null) {
            if (Build.VERSION.SDK_INT >= 24) {
                return new PointerIconCompat(PointerIcon.create(bitmap, f2, f3));
            }
            return new PointerIconCompat(null);
        }
        return (PointerIconCompat) invokeCommon.objValue;
    }

    public static PointerIconCompat getSystemIcon(Context context, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65538, null, context, i2)) == null) {
            if (Build.VERSION.SDK_INT >= 24) {
                return new PointerIconCompat(PointerIcon.getSystemIcon(context, i2));
            }
            return new PointerIconCompat(null);
        }
        return (PointerIconCompat) invokeLI.objValue;
    }

    public static PointerIconCompat load(Resources resources, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65539, null, resources, i2)) == null) {
            if (Build.VERSION.SDK_INT >= 24) {
                return new PointerIconCompat(PointerIcon.load(resources, i2));
            }
            return new PointerIconCompat(null);
        }
        return (PointerIconCompat) invokeLI.objValue;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public Object getPointerIcon() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.mPointerIcon : invokeV.objValue;
    }
}
