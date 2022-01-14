package com.baidu.tbadk.core.util;

import android.content.Context;
import androidx.core.view.InputDeviceCompat;
import c.a.d.f.p.n;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.Serializable;
/* loaded from: classes11.dex */
public class LocalViewSize {
    public static /* synthetic */ Interceptable $ic;
    public static LocalViewSize sInstance;
    public transient /* synthetic */ FieldHolder $fh;
    public Context mContext;

    /* loaded from: classes11.dex */
    public static class ImageSize implements Serializable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public int height;
        public int width;

        public ImageSize() {
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
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(310937706, "Lcom/baidu/tbadk/core/util/LocalViewSize;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(310937706, "Lcom/baidu/tbadk/core/util/LocalViewSize;");
        }
    }

    public LocalViewSize() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.mContext = null;
    }

    private ImageSize countPicSize(ImageSize imageSize, int i2, int i3) {
        InterceptResult invokeLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(65538, this, imageSize, i2, i3)) == null) {
            ImageSize imageSize2 = new ImageSize();
            int i4 = imageSize.height;
            int i5 = imageSize.width;
            if (i2 / i3 > i4 / i5) {
                imageSize2.height = i4;
                int i6 = (i4 * i3) / i2;
                imageSize2.width = i6;
                if (i6 == 0) {
                    imageSize2.height = 324;
                    imageSize2.width = 162;
                }
            } else {
                imageSize2.width = i5;
                imageSize2.height = (i5 * i2) / i3;
            }
            return imageSize2;
        }
        return (ImageSize) invokeLII.objValue;
    }

    public static LocalViewSize getInstance() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            if (sInstance == null) {
                sInstance = new LocalViewSize();
            }
            return sInstance;
        }
        return (LocalViewSize) invokeV.objValue;
    }

    public int getEquipmentWidth() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            int k = n.k(this.mContext);
            if (k >= 1080) {
                return 1080;
            }
            return (k < 720 || k >= 1080) ? 480 : 720;
        }
        return invokeV.intValue;
    }

    public int getGroupHeaderSize() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return 600;
        }
        return invokeV.intValue;
    }

    public ImageSize getMsgBPicMaxSize() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            ImageSize imageSize = new ImageSize();
            imageSize.height = n.i(this.mContext);
            imageSize.width = n.k(this.mContext);
            return imageSize;
        }
        return (ImageSize) invokeV.objValue;
    }

    public int getMsgBPicMaxSizeInt() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            ImageSize msgBPicMaxSize = getMsgBPicMaxSize();
            int i2 = msgBPicMaxSize.height;
            int i3 = msgBPicMaxSize.width;
            return i2 >= i3 ? i2 : i3;
        }
        return invokeV.intValue;
    }

    public ImageSize getMsgBPicShowSize(ImageSize imageSize, int i2, int i3) {
        InterceptResult invokeLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(1048580, this, imageSize, i2, i3)) == null) {
            if (i2 <= imageSize.height / 2 && i3 <= imageSize.width / 2) {
                ImageSize imageSize2 = new ImageSize();
                imageSize2.height = i2;
                imageSize2.width = i3;
                return imageSize2;
            }
            return countPicSize(imageSize, i2, i3);
        }
        return (ImageSize) invokeLII.objValue;
    }

    public ImageSize getMsgSPicMaxSize() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            int k = n.k(this.mContext);
            int i2 = 240;
            if (k < 240) {
                i2 = k / 3;
            } else if (k <= 320) {
                i2 = 80;
            } else if (k <= 480) {
                i2 = 160;
            } else if (k > 720) {
                i2 = k / 3;
            }
            ImageSize imageSize = new ImageSize();
            imageSize.height = i2;
            imageSize.width = i2;
            return imageSize;
        }
        return (ImageSize) invokeV.objValue;
    }

    public int getMsgSPicMaxSizeInt() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            ImageSize msgSPicMaxSize = getMsgSPicMaxSize();
            int i2 = msgSPicMaxSize.height;
            int i3 = msgSPicMaxSize.width;
            return i2 >= i3 ? i2 : i3;
        }
        return invokeV.intValue;
    }

    public ImageSize getMsgSPicShowSize(ImageSize imageSize, int i2, int i3) {
        InterceptResult invokeLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(1048583, this, imageSize, i2, i3)) == null) {
            if (i2 <= imageSize.height && i3 <= imageSize.width) {
                ImageSize imageSize2 = new ImageSize();
                int i4 = imageSize.height;
                int i5 = imageSize.width;
                if (i2 / i3 > i4 / i5) {
                    imageSize2.height = i4;
                    imageSize2.width = (i4 * i3) / i2;
                } else {
                    imageSize2.width = i5;
                    imageSize2.height = (i5 * i2) / i3;
                }
                return imageSize2;
            }
            return countPicSize(imageSize, i2, i3);
        }
        return (ImageSize) invokeLII.objValue;
    }

    public ImageSize getMsgUpPicMaxSize() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            ImageSize imageSize = new ImageSize();
            imageSize.height = 600;
            imageSize.width = 600;
            return imageSize;
        }
        return (ImageSize) invokeV.objValue;
    }

    public int getMsgUpPicMaxSizeInt() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            ImageSize msgUpPicMaxSize = getMsgUpPicMaxSize();
            int i2 = msgUpPicMaxSize.height;
            int i3 = msgUpPicMaxSize.width;
            return i2 >= i3 ? i2 : i3;
        }
        return invokeV.intValue;
    }

    public void initial(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, context) == null) {
            this.mContext = context;
        }
    }
}
