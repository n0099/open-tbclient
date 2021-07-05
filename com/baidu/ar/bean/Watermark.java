package com.baidu.ar.bean;

import android.graphics.Bitmap;
import android.graphics.Point;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes.dex */
public class Watermark {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Bitmap mBitmap;
    public CoordinateType mCoordinateType;
    public String mFilePath;
    public float[] mRenderRect;
    public RotationType mRotationType;
    public float mScale;
    public Point mStartPoint;
    public StorageType mStorageType;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes.dex */
    public static final class CoordinateType {
        public static final /* synthetic */ CoordinateType[] $VALUES;
        public static /* synthetic */ Interceptable $ic;
        public static final CoordinateType LEFT_BOTTOM;
        public static final CoordinateType LEFT_TOP;
        public static final CoordinateType RIGHT_BOTTOM;
        public static final CoordinateType RIGHT_TOP;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1372541990, "Lcom/baidu/ar/bean/Watermark$CoordinateType;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-1372541990, "Lcom/baidu/ar/bean/Watermark$CoordinateType;");
                    return;
                }
            }
            LEFT_TOP = new CoordinateType("LEFT_TOP", 0);
            LEFT_BOTTOM = new CoordinateType("LEFT_BOTTOM", 1);
            RIGHT_TOP = new CoordinateType("RIGHT_TOP", 2);
            CoordinateType coordinateType = new CoordinateType("RIGHT_BOTTOM", 3);
            RIGHT_BOTTOM = coordinateType;
            $VALUES = new CoordinateType[]{LEFT_TOP, LEFT_BOTTOM, RIGHT_TOP, coordinateType};
        }

        public CoordinateType(String str, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    String str2 = (String) objArr2[0];
                    ((Integer) objArr2[1]).intValue();
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                }
            }
        }

        public static CoordinateType valueOf(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? (CoordinateType) Enum.valueOf(CoordinateType.class, str) : (CoordinateType) invokeL.objValue;
        }

        public static CoordinateType[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (CoordinateType[]) $VALUES.clone() : (CoordinateType[]) invokeV.objValue;
        }
    }

    public Watermark(Bitmap bitmap, Point point) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {bitmap, point};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mStorageType = StorageType.SDCARD;
        this.mCoordinateType = CoordinateType.LEFT_BOTTOM;
        this.mRotationType = RotationType.ROTATE_0;
        this.mScale = 1.0f;
        this.mBitmap = bitmap;
        this.mStartPoint = point;
    }

    public Watermark(String str, Point point) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, point};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.mStorageType = StorageType.SDCARD;
        this.mCoordinateType = CoordinateType.LEFT_BOTTOM;
        this.mRotationType = RotationType.ROTATE_0;
        this.mScale = 1.0f;
        this.mFilePath = str;
        this.mStartPoint = point;
    }

    public Bitmap getBitmap() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.mBitmap : (Bitmap) invokeV.objValue;
    }

    public CoordinateType getCoordinateType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.mCoordinateType : (CoordinateType) invokeV.objValue;
    }

    public String getFilePath() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.mFilePath : (String) invokeV.objValue;
    }

    public float[] getRenderRect() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.mRenderRect : (float[]) invokeV.objValue;
    }

    public RotationType getRotationType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.mRotationType : (RotationType) invokeV.objValue;
    }

    public float getScale() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.mScale : invokeV.floatValue;
    }

    public Point getStartPoint() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.mStartPoint : (Point) invokeV.objValue;
    }

    public StorageType getStorageType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.mStorageType : (StorageType) invokeV.objValue;
    }

    public void setBitmap(Bitmap bitmap) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, bitmap) == null) {
            this.mBitmap = bitmap;
        }
    }

    public void setCoordinateType(CoordinateType coordinateType) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, coordinateType) == null) {
            this.mCoordinateType = coordinateType;
        }
    }

    public void setFilePath(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, str) == null) {
            this.mFilePath = str;
        }
    }

    public void setRenderRect(float[] fArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, fArr) == null) {
            this.mRenderRect = fArr;
        }
    }

    public void setRotationType(RotationType rotationType) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, rotationType) == null) {
            this.mRotationType = rotationType;
        }
    }

    public void setScale(float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048589, this, f2) == null) {
            this.mScale = f2;
        }
    }

    public void setStartPoint(Point point) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, point) == null) {
            this.mStartPoint = point;
        }
    }

    public void setStorageType(StorageType storageType) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, storageType) == null) {
            this.mStorageType = storageType;
        }
    }
}
