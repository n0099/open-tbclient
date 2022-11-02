package com.baidu.platform.comapi.basestruct;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.Serializable;
/* loaded from: classes2.dex */
public class MapBound implements Serializable {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Point leftBottomPt;
    public Point rightTopPt;

    public MapBound() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.leftBottomPt = new Point();
        this.rightTopPt = new Point();
    }

    public int hashCode() {
        InterceptResult invokeV;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            Point point = this.leftBottomPt;
            int i2 = 0;
            if (point != null) {
                i = point.hashCode();
            } else {
                i = 0;
            }
            int i3 = i * 31;
            Point point2 = this.rightTopPt;
            if (point2 != null) {
                i2 = point2.hashCode();
            }
            return i3 + i2;
        }
        return invokeV.intValue;
    }

    public MapBound(int i, int i2, int i3, int i4) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i5 = newInitContext.flag;
            if ((i5 & 1) != 0) {
                int i6 = i5 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.leftBottomPt = new Point();
        this.rightTopPt = new Point();
        setLeftBottomPt(i, i2);
        setRightTopPt(i3, i4);
    }

    public boolean equals(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, obj)) == null) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof MapBound)) {
                return false;
            }
            MapBound mapBound = (MapBound) obj;
            Point point = this.leftBottomPt;
            if (point == null ? mapBound.leftBottomPt != null : !point.equals(mapBound.leftBottomPt)) {
                return false;
            }
            Point point2 = this.rightTopPt;
            Point point3 = mapBound.rightTopPt;
            if (point2 != null) {
                if (point2.equals(point3)) {
                    return true;
                }
            } else if (point3 == null) {
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public Point getCenterPt() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return new Point((this.leftBottomPt.getIntX() + this.rightTopPt.getIntX()) / 2, (this.leftBottomPt.getIntY() + this.rightTopPt.getIntY()) / 2);
        }
        return (Point) invokeV.objValue;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return "MapBound{leftBottomPt=" + this.leftBottomPt + ", rightTopPt=" + this.rightTopPt + '}';
        }
        return (String) invokeV.objValue;
    }

    public void setLeftBottomPt(int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048579, this, i, i2) == null) {
            this.leftBottomPt.setTo(i, i2);
        }
    }

    public void setRightTopPt(int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048581, this, i, i2) == null) {
            this.rightTopPt.setTo(i, i2);
        }
    }

    public void setLeftBottomPt(Point point) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, point) == null) {
            this.leftBottomPt.setTo(point);
        }
    }

    public void setRightTopPt(Point point) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, point) == null) {
            this.rightTopPt.setTo(point);
        }
    }

    public String toQuery() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return String.format("(%d,%d;%d,%d)", Integer.valueOf(this.leftBottomPt.getIntX()), Integer.valueOf(this.leftBottomPt.getIntY()), Integer.valueOf(this.rightTopPt.getIntX()), Integer.valueOf(this.rightTopPt.getIntY()));
        }
        return (String) invokeV.objValue;
    }
}
