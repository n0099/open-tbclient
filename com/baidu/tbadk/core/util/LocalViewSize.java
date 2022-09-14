package com.baidu.tbadk.core.util;

import android.content.Context;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.location.BDLocation;
import com.baidu.tieba.ej;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.Serializable;
/* loaded from: classes3.dex */
public class LocalViewSize {
    public static /* synthetic */ Interceptable $ic;
    public static LocalViewSize sInstance;
    public transient /* synthetic */ FieldHolder $fh;
    public Context mContext;

    /* loaded from: classes3.dex */
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
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.mContext = null;
    }

    private ImageSize countPicSize(ImageSize imageSize, int i, int i2) {
        InterceptResult invokeLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(65538, this, imageSize, i, i2)) == null) {
            ImageSize imageSize2 = new ImageSize();
            int i3 = imageSize.height;
            int i4 = imageSize.width;
            if (i / i2 > i3 / i4) {
                imageSize2.height = i3;
                int i5 = (i3 * i2) / i;
                imageSize2.width = i5;
                if (i5 == 0) {
                    imageSize2.height = 324;
                    imageSize2.width = BDLocation.TypeServerDecryptError;
                }
            } else {
                imageSize2.width = i4;
                imageSize2.height = (i4 * i) / i2;
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
            int k = ej.k(this.mContext);
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
            imageSize.height = ej.i(this.mContext);
            imageSize.width = ej.k(this.mContext);
            return imageSize;
        }
        return (ImageSize) invokeV.objValue;
    }

    public int getMsgBPicMaxSizeInt() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            ImageSize msgBPicMaxSize = getMsgBPicMaxSize();
            int i = msgBPicMaxSize.height;
            int i2 = msgBPicMaxSize.width;
            return i >= i2 ? i : i2;
        }
        return invokeV.intValue;
    }

    public ImageSize getMsgBPicShowSize(ImageSize imageSize, int i, int i2) {
        InterceptResult invokeLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(1048580, this, imageSize, i, i2)) == null) {
            if (i <= imageSize.height / 2 && i2 <= imageSize.width / 2) {
                ImageSize imageSize2 = new ImageSize();
                imageSize2.height = i;
                imageSize2.width = i2;
                return imageSize2;
            }
            return countPicSize(imageSize, i, i2);
        }
        return (ImageSize) invokeLII.objValue;
    }

    public ImageSize getMsgSPicMaxSize() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            int k = ej.k(this.mContext);
            int i = 240;
            if (k < 240) {
                i = k / 3;
            } else if (k <= 320) {
                i = 80;
            } else if (k <= 480) {
                i = 160;
            } else if (k > 720) {
                i = k / 3;
            }
            ImageSize imageSize = new ImageSize();
            imageSize.height = i;
            imageSize.width = i;
            return imageSize;
        }
        return (ImageSize) invokeV.objValue;
    }

    public int getMsgSPicMaxSizeInt() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            ImageSize msgSPicMaxSize = getMsgSPicMaxSize();
            int i = msgSPicMaxSize.height;
            int i2 = msgSPicMaxSize.width;
            return i >= i2 ? i : i2;
        }
        return invokeV.intValue;
    }

    public ImageSize getMsgSPicShowSize(ImageSize imageSize, int i, int i2) {
        InterceptResult invokeLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(1048583, this, imageSize, i, i2)) == null) {
            if (i <= imageSize.height && i2 <= imageSize.width) {
                ImageSize imageSize2 = new ImageSize();
                int i3 = imageSize.height;
                int i4 = imageSize.width;
                if (i / i2 > i3 / i4) {
                    imageSize2.height = i3;
                    imageSize2.width = (i3 * i2) / i;
                } else {
                    imageSize2.width = i4;
                    imageSize2.height = (i4 * i) / i2;
                }
                return imageSize2;
            }
            return countPicSize(imageSize, i, i2);
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
            int i = msgUpPicMaxSize.height;
            int i2 = msgUpPicMaxSize.width;
            return i >= i2 ? i : i2;
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
