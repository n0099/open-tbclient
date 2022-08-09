package com.baidu.live.business.refresh;

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
public class LoadAnimStrategy {
    public static /* synthetic */ Interceptable $ic;
    public static LoadAnimStrategy sInstance;
    public transient /* synthetic */ FieldHolder $fh;
    public String loadMoreLottieRecRes;
    public String loadMoreLottieRes;
    public String loadMoreLottieRes1;
    public String loadMoreLottieRes2;
    public String loadMoreLottieRes3;
    public int loadMoreLottieResId;
    public int loadMoreLottieResId1;
    public int loadMoreLottieResId2;
    public int loadMoreLottieResId3;
    public int loadMoreLottieResRecId;
    public float loadingLottieHeight;
    public String loadingLottieImgRes;
    public String loadingLottieRecRes;
    public int loadingLottieRecResId;
    public String loadingLottieRes;
    public String loadingLottieRes1;
    public String loadingLottieRes2;
    public String loadingLottieRes3;
    public int loadingLottieResId;
    public int loadingLottieResId1;
    public int loadingLottieResId2;
    public int loadingLottieResId3;
    public float loadingLottieWidth;
    public int loopEndFrame;
    public int loopStartFrame;
    public int lottieTotalFrame;
    public String pullDownLottieRecRes;
    public int pullDownLottieRecResId;
    public String pullDownLottieRes;
    public String pullDownLottieRes1;
    public String pullDownLottieRes2;
    public String pullDownLottieRes3;
    public int pullDownLottieResId;
    public int pullDownLottieResId1;
    public int pullDownLottieResId2;
    public int pullDownLottieResId3;
    public int pullEndFrame;

    /* loaded from: classes2.dex */
    public static class Holder {
        public static /* synthetic */ Interceptable $ic;
        public static final LoadAnimStrategy INSTANCE;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-324480925, "Lcom/baidu/live/business/refresh/LoadAnimStrategy$Holder;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-324480925, "Lcom/baidu/live/business/refresh/LoadAnimStrategy$Holder;");
                    return;
                }
            }
            INSTANCE = new LoadAnimStrategy();
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

    public LoadAnimStrategy() {
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

    public static LoadAnimStrategy getInstance() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            if (sInstance == null) {
                sInstance = Holder.INSTANCE;
            }
            return sInstance;
        }
        return (LoadAnimStrategy) invokeV.objValue;
    }

    public void setLoadMoreAnimStrategy(String str, String str2, String str3, String str4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048576, this, str, str2, str3, str4) == null) {
            this.loadMoreLottieRes = str;
            this.loadMoreLottieRes1 = str2;
            this.loadMoreLottieRes2 = str3;
            this.loadMoreLottieRes3 = str4;
        }
    }

    public void setLoadMoreAnimStrategyId(int i, int i2, int i3, int i4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, i2, i3, i4) == null) {
            this.loadMoreLottieResId = i;
            this.loadMoreLottieResId1 = i2;
            this.loadMoreLottieResId2 = i3;
            this.loadMoreLottieResId3 = i4;
        }
    }

    public void setLoadingLottieRes(String str, String str2, String str3, String str4, String str5, float f, float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{str, str2, str3, str4, str5, Float.valueOf(f), Float.valueOf(f2)}) == null) {
            this.loadingLottieRes = str;
            this.loadingLottieRes1 = str2;
            this.loadingLottieRes2 = str3;
            this.loadingLottieRes3 = str4;
            this.loadingLottieImgRes = str5;
            this.loadingLottieWidth = f;
            this.loadingLottieHeight = f2;
        }
    }

    public void setLoadingLottieResId(int i, int i2, int i3, int i4, String str, float f, float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), str, Float.valueOf(f), Float.valueOf(f2)}) == null) {
            this.loadingLottieResId = i;
            this.loadingLottieResId1 = i2;
            this.loadingLottieResId2 = i3;
            this.loadingLottieResId3 = i4;
            this.loadingLottieImgRes = str;
            this.loadingLottieWidth = f;
            this.loadingLottieHeight = f2;
        }
    }

    public void setPullDownAnimStrategy(String str, String str2, String str3, String str4, int i, int i2, int i3, int i4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048580, this, new Object[]{str, str2, str3, str4, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)}) == null) {
            this.pullDownLottieRes = str;
            this.pullDownLottieRes1 = str2;
            this.pullDownLottieRes2 = str3;
            this.pullDownLottieRes3 = str4;
            this.pullEndFrame = i;
            this.loopStartFrame = i2;
            this.loopEndFrame = i3;
            this.lottieTotalFrame = i4;
        }
    }

    public void setRecLoadMoreAnimStrategy(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, str) == null) {
            this.loadMoreLottieRecRes = str;
        }
    }

    public void setRecLoadMoreAnimStrategyId(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048582, this, i) == null) {
            this.loadMoreLottieResRecId = i;
        }
    }

    public void setRecLoadingLottieRes(String str, String str2, float f, float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048583, this, new Object[]{str, str2, Float.valueOf(f), Float.valueOf(f2)}) == null) {
            this.loadingLottieRecRes = str;
            this.loadingLottieImgRes = str2;
            this.loadingLottieWidth = f;
            this.loadingLottieHeight = f2;
        }
    }

    public void setRecLoadingLottieResId(int i, String str, float f, float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TOUCHPAD, this, new Object[]{Integer.valueOf(i), str, Float.valueOf(f), Float.valueOf(f2)}) == null) {
            this.loadingLottieRecResId = i;
            this.loadingLottieImgRes = str;
            this.loadingLottieWidth = f;
            this.loadingLottieHeight = f2;
        }
    }

    public void setRecPullDownAnimStrategy(String str, int i, int i2, int i3, int i4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048585, this, new Object[]{str, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)}) == null) {
            this.pullDownLottieRecRes = str;
            this.pullEndFrame = i;
            this.loopStartFrame = i2;
            this.loopEndFrame = i3;
            this.lottieTotalFrame = i4;
        }
    }

    public void setRecPullDownAnimStrategyId(int i, int i2, int i3, int i4, int i5) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048586, this, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5)}) == null) {
            this.pullDownLottieRecResId = i;
            this.pullEndFrame = i2;
            this.loopStartFrame = i3;
            this.loopEndFrame = i4;
            this.lottieTotalFrame = i5;
        }
    }
}
