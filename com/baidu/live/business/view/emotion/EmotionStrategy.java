package com.baidu.live.business.view.emotion;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes2.dex */
public class EmotionStrategy {
    public static /* synthetic */ Interceptable $ic;
    public static EmotionStrategy sInstance;
    public transient /* synthetic */ FieldHolder $fh;
    public float emptyHeight;
    public int emptyImageRes;
    public int emptyImageRes1;
    public int emptyImageRes2;
    public int emptyImageRes3;
    public float emptyWidth;
    public float errorHeight;
    public int errorImageRes;
    public int errorImageRes1;
    public int errorImageRes2;
    public int errorImageRes3;
    public float errorWidth;
    public float networkHeight;
    public int networkImageRes;
    public int networkImageRes1;
    public int networkImageRes2;
    public int networkImageRes3;
    public float networkWidth;
    public int placeHolderRes;
    public int placeHolderRes1;
    public int placeHolderRes2;
    public int placeHolderRes3;
    public int recEmptyImageRes;
    public int recErrorImageRes;
    public int recNetworkImageRes;
    public int recPlaceHolderRes;
    public int videoBarPlaceHolderRes;

    /* loaded from: classes2.dex */
    public static class Holder {
        public static /* synthetic */ Interceptable $ic;
        public static final EmotionStrategy INSTANCE;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1633872491, "Lcom/baidu/live/business/view/emotion/EmotionStrategy$Holder;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-1633872491, "Lcom/baidu/live/business/view/emotion/EmotionStrategy$Holder;");
                    return;
                }
            }
            INSTANCE = new EmotionStrategy();
        }

        public Holder() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65537, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                }
            }
        }
    }

    public EmotionStrategy() {
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

    public static EmotionStrategy getInstance() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            if (sInstance == null) {
                sInstance = Holder.INSTANCE;
            }
            return sInstance;
        }
        return (EmotionStrategy) invokeV.objValue;
    }

    public void setEmptyImageRes(int i, int i2, int i3, int i4, float f, float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Float.valueOf(f), Float.valueOf(f2)}) == null) {
            this.emptyImageRes = i;
            this.emptyImageRes1 = i2;
            this.emptyImageRes2 = i3;
            this.emptyImageRes3 = i4;
            this.emptyWidth = f;
            this.emptyHeight = f2;
        }
    }

    public void setErrorImageRes(int i, int i2, int i3, int i4, float f, float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Float.valueOf(f), Float.valueOf(f2)}) == null) {
            this.errorImageRes = i;
            this.errorImageRes1 = i2;
            this.errorImageRes2 = i3;
            this.errorImageRes3 = i4;
            this.errorWidth = f;
            this.errorHeight = f2;
        }
    }

    public void setNetworkImageRes(int i, int i2, int i3, int i4, float f, float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Float.valueOf(f), Float.valueOf(f2)}) == null) {
            this.networkImageRes = i;
            this.networkImageRes1 = i2;
            this.networkImageRes2 = i3;
            this.networkImageRes3 = i4;
            this.networkWidth = f;
            this.networkHeight = f2;
        }
    }

    public void setPlaceHolderRes(int i, int i2, int i3, int i4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIII(1048579, this, i, i2, i3, i4) == null) {
            this.placeHolderRes = i;
            this.placeHolderRes1 = i2;
            this.placeHolderRes2 = i3;
            this.placeHolderRes3 = i4;
        }
    }

    public void setRecEmptyImageRes(int i, float f, float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048580, this, new Object[]{Integer.valueOf(i), Float.valueOf(f), Float.valueOf(f2)}) == null) {
            this.recEmptyImageRes = i;
            this.emptyWidth = f;
            this.emptyHeight = f2;
        }
    }

    public void setRecErrorImageRes(int i, float f, float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048581, this, new Object[]{Integer.valueOf(i), Float.valueOf(f), Float.valueOf(f2)}) == null) {
            this.recErrorImageRes = i;
            this.errorWidth = f;
            this.errorHeight = f2;
        }
    }

    public void setRecNetworkImageRes(int i, float f, float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048582, this, new Object[]{Integer.valueOf(i), Float.valueOf(f), Float.valueOf(f2)}) == null) {
            this.recNetworkImageRes = i;
            this.networkWidth = f;
            this.networkHeight = f2;
        }
    }

    public void setRecPlaceHolderRes(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048583, this, i) == null) {
            this.recPlaceHolderRes = i;
        }
    }

    public void setVideoBarPlaceHolderRes(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i) == null) {
            this.videoBarPlaceHolderRes = i;
        }
    }
}
