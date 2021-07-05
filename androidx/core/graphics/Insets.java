package androidx.core.graphics;

import android.graphics.Rect;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes.dex */
public final class Insets {
    public static /* synthetic */ Interceptable $ic;
    @NonNull
    public static final Insets NONE;
    public transient /* synthetic */ FieldHolder $fh;
    public final int bottom;
    public final int left;
    public final int right;
    public final int top;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-501789065, "Landroidx/core/graphics/Insets;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-501789065, "Landroidx/core/graphics/Insets;");
                return;
            }
        }
        NONE = new Insets(0, 0, 0, 0);
    }

    public Insets(int i2, int i3, int i4, int i5) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i6 = newInitContext.flag;
            if ((i6 & 1) != 0) {
                int i7 = i6 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.left = i2;
        this.top = i3;
        this.right = i4;
        this.bottom = i5;
    }

    @NonNull
    public static Insets of(int i2, int i3, int i4, int i5) {
        InterceptResult invokeIIII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIIII = interceptable.invokeIIII(65538, null, i2, i3, i4, i5)) == null) {
            if (i2 == 0 && i3 == 0 && i4 == 0 && i5 == 0) {
                return NONE;
            }
            return new Insets(i2, i3, i4, i5);
        }
        return (Insets) invokeIIII.objValue;
    }

    @NonNull
    @RequiresApi(api = 29)
    public static Insets toCompatInsets(@NonNull android.graphics.Insets insets) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65540, null, insets)) == null) ? of(insets.left, insets.top, insets.right, insets.bottom) : (Insets) invokeL.objValue;
    }

    @NonNull
    @Deprecated
    @RequiresApi(api = 29)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public static Insets wrap(@NonNull android.graphics.Insets insets) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.AD_TEXT_ID, null, insets)) == null) ? toCompatInsets(insets) : (Insets) invokeL.objValue;
    }

    public boolean equals(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, obj)) == null) {
            if (this == obj) {
                return true;
            }
            if (obj == null || Insets.class != obj.getClass()) {
                return false;
            }
            Insets insets = (Insets) obj;
            return this.bottom == insets.bottom && this.left == insets.left && this.right == insets.right && this.top == insets.top;
        }
        return invokeL.booleanValue;
    }

    public int hashCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? (((((this.left * 31) + this.top) * 31) + this.right) * 31) + this.bottom : invokeV.intValue;
    }

    @NonNull
    @RequiresApi(api = 29)
    public android.graphics.Insets toPlatformInsets() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? android.graphics.Insets.of(this.left, this.top, this.right, this.bottom) : (android.graphics.Insets) invokeV.objValue;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return "Insets{left=" + this.left + ", top=" + this.top + ", right=" + this.right + ", bottom=" + this.bottom + '}';
        }
        return (String) invokeV.objValue;
    }

    @NonNull
    public static Insets of(@NonNull Rect rect) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65539, null, rect)) == null) ? of(rect.left, rect.top, rect.right, rect.bottom) : (Insets) invokeL.objValue;
    }
}
