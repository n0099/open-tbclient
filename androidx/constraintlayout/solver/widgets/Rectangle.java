package androidx.constraintlayout.solver.widgets;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes.dex */
public class Rectangle {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int height;
    public int width;
    public int x;
    public int y;

    public Rectangle() {
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

    public int getCenterX() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return (this.x + this.width) / 2;
        }
        return invokeV.intValue;
    }

    public int getCenterY() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return (this.y + this.height) / 2;
        }
        return invokeV.intValue;
    }

    public boolean contains(int i, int i2) {
        InterceptResult invokeII;
        int i3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(1048576, this, i, i2)) == null) {
            int i4 = this.x;
            if (i >= i4 && i < i4 + this.width && i2 >= (i3 = this.y) && i2 < i3 + this.height) {
                return true;
            }
            return false;
        }
        return invokeII.booleanValue;
    }

    public void grow(int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048579, this, i, i2) == null) {
            this.x -= i;
            this.y -= i2;
            this.width += i * 2;
            this.height += i2 * 2;
        }
    }

    public boolean intersects(Rectangle rectangle) {
        InterceptResult invokeL;
        int i;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, rectangle)) == null) {
            int i3 = this.x;
            int i4 = rectangle.x;
            if (i3 >= i4 && i3 < i4 + rectangle.width && (i = this.y) >= (i2 = rectangle.y) && i < i2 + rectangle.height) {
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public void setBounds(int i, int i2, int i3, int i4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIII(1048581, this, i, i2, i3, i4) == null) {
            this.x = i;
            this.y = i2;
            this.width = i3;
            this.height = i4;
        }
    }
}
