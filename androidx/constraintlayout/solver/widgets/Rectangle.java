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
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public boolean contains(int i2, int i3) {
        InterceptResult invokeII;
        int i4;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(1048576, this, i2, i3)) == null) {
            int i5 = this.x;
            return i2 >= i5 && i2 < i5 + this.width && i3 >= (i4 = this.y) && i3 < i4 + this.height;
        }
        return invokeII.booleanValue;
    }

    public int getCenterX() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? (this.x + this.width) / 2 : invokeV.intValue;
    }

    public int getCenterY() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? (this.y + this.height) / 2 : invokeV.intValue;
    }

    public void grow(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048579, this, i2, i3) == null) {
            this.x -= i2;
            this.y -= i3;
            this.width += i2 * 2;
            this.height += i3 * 2;
        }
    }

    public boolean intersects(Rectangle rectangle) {
        InterceptResult invokeL;
        int i2;
        int i3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, rectangle)) == null) {
            int i4 = this.x;
            int i5 = rectangle.x;
            return i4 >= i5 && i4 < i5 + rectangle.width && (i2 = this.y) >= (i3 = rectangle.y) && i2 < i3 + rectangle.height;
        }
        return invokeL.booleanValue;
    }

    public void setBounds(int i2, int i3, int i4, int i5) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIII(1048581, this, i2, i3, i4, i5) == null) {
            this.x = i2;
            this.y = i3;
            this.width = i4;
            this.height = i5;
        }
    }
}
