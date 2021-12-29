package com.baidu.tbadk.core.util;

import androidx.core.view.InputDeviceCompat;
import c.a.d.d.d;
import c.a.d.f.p.l;
import c.a.s0.s.k;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbConfig;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes11.dex */
public class TbImageHelper {
    public static /* synthetic */ Interceptable $ic;
    public static TbImageHelper mInstance;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean mIsWifiCache;
    public int mPostImageSize;
    public boolean mShowBigImage;
    public String mUrlQuality;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-705486624, "Lcom/baidu/tbadk/core/util/TbImageHelper;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-705486624, "Lcom/baidu/tbadk/core/util/TbImageHelper;");
        }
    }

    public TbImageHelper() {
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
        this.mIsWifiCache = false;
        this.mShowBigImage = false;
        this.mPostImageSize = 1300;
        this.mUrlQuality = String.valueOf(45);
        updateNetworkStatusCache();
        updateAll();
    }

    public static TbImageHelper getInstance() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            if (mInstance == null) {
                synchronized (TbImageHelper.class) {
                    if (mInstance == null) {
                        mInstance = new TbImageHelper();
                    }
                }
            }
            return mInstance;
        }
        return (TbImageHelper) invokeV.objValue;
    }

    public static boolean isSupportGifEmotions() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? FileHelper.checkSD() && d.c() : invokeV.booleanValue;
    }

    private void updateAll() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, this) == null) {
            updateFrsShowBigImage();
            updateUrlQuality();
            updatePostImageSize();
        }
    }

    private void updateNetworkStatusCache() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65541, this) == null) {
            this.mIsWifiCache = l.H();
        }
    }

    public boolean getIsWifi() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.mIsWifiCache : invokeV.booleanValue;
    }

    public int getPostImageHeightLimit() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? TbConfig.POST_IMAGE_HIGHT_LIMIT : invokeV.intValue;
    }

    public int getPostImageSize() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            updatePostImageSize();
            return this.mPostImageSize;
        }
        return invokeV.intValue;
    }

    public String getUrlQuality() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.mUrlQuality : (String) invokeV.objValue;
    }

    public boolean isShowBigImage() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.mShowBigImage : invokeV.booleanValue;
    }

    public void setNetworkIsWifi(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048581, this, z) == null) {
            this.mIsWifiCache = z;
            updateAll();
        }
    }

    public void setShowBigImage(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048582, this, z) == null) {
            this.mShowBigImage = z;
        }
    }

    public void updateFrsShowBigImage() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            boolean z = true;
            if (k.c().e() != 0 ? k.c().e() != 1 : !this.mIsWifiCache) {
                z = false;
            }
            setShowBigImage(z);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x0027, code lost:
        if (getIsWifi() != false) goto L15;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void updatePostImageSize() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            int d2 = k.c().d();
            int i2 = 1300;
            if (d2 != 0) {
                if (d2 != 1) {
                    if (d2 == 2 || d2 != 3) {
                        i2 = 1800;
                    }
                }
                i2 = 2000;
            }
            this.mPostImageSize = i2;
        }
    }

    public void updateUrlQuality() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            String valueOf = String.valueOf(45);
            if (k.c().e() == 0) {
                if (getIsWifi()) {
                    valueOf = String.valueOf(80);
                }
            } else if (k.c().e() == 1) {
                valueOf = String.valueOf(80);
            }
            this.mUrlQuality = valueOf;
        }
    }
}
