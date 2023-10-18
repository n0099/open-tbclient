package com.baidu.mobads.sdk.api;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.sdk.internal.a;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.ref.WeakReference;
/* loaded from: classes3.dex */
public class BaiduNativeAdPlacement {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String apid;
    public int feedPositionId;
    public int feedSequenceId;
    public int feedSessionId;
    public a mAdElementInfo;
    public String mAppsid;
    public boolean mClicked;
    public boolean mRequestStarted;
    public WeakReference<BaiduNativeH5AdView> mWeakAdView;
    public boolean mWinSended;

    public BaiduNativeAdPlacement() {
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
        this.mAdElementInfo = null;
        this.mRequestStarted = false;
        this.mWeakAdView = null;
        this.feedSessionId = 0;
        this.feedPositionId = 1;
        this.feedSequenceId = 1;
    }

    public BaiduNativeH5AdView getAdView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            WeakReference<BaiduNativeH5AdView> weakReference = this.mWeakAdView;
            if (weakReference != null) {
                return weakReference.get();
            }
            return null;
        }
        return (BaiduNativeH5AdView) invokeV.objValue;
    }

    public String getApId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.apid;
        }
        return (String) invokeV.objValue;
    }

    public int getPosistionId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.feedPositionId;
        }
        return invokeV.intValue;
    }

    public boolean getRequestStarted() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.mRequestStarted;
        }
        return invokeV.booleanValue;
    }

    public a getResponse() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.mAdElementInfo;
        }
        return (a) invokeV.objValue;
    }

    public int getSequenceId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return this.feedSequenceId;
        }
        return invokeV.intValue;
    }

    public int getSessionId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return this.feedSessionId;
        }
        return invokeV.intValue;
    }

    public boolean hasValidResponse() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            if (this.mAdElementInfo != null && isAdAvailable()) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public boolean isAdDataLoaded() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            BaiduNativeH5AdView adView = getAdView();
            if (adView != null) {
                return adView.isAdDataLoaded();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public boolean isWinSended() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            return this.mWinSended;
        }
        return invokeV.booleanValue;
    }

    public boolean isAdAvailable() {
        InterceptResult invokeV;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            if (this.mAdElementInfo != null && System.currentTimeMillis() - this.mAdElementInfo.y() <= 1800000) {
                z = true;
            } else {
                z = false;
            }
            if (z && !this.mClicked) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public void setAdResponse(a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, aVar) == null) {
            this.mWinSended = false;
            this.mAdElementInfo = aVar;
        }
    }

    public void setAdView(BaiduNativeH5AdView baiduNativeH5AdView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, baiduNativeH5AdView) == null) {
            this.mWeakAdView = new WeakReference<>(baiduNativeH5AdView);
        }
    }

    public void setApId(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, str) == null) {
            this.apid = str;
        }
    }

    public void setAppSid(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, str) == null) {
            this.mAppsid = str;
        }
    }

    public void setClicked(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048591, this, z) == null) {
            this.mClicked = z;
        }
    }

    public void setPositionId(int i) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeI(1048592, this, i) != null) || i < 1) {
            return;
        }
        this.feedPositionId = i;
    }

    public void setRequestStarted(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048593, this, z) == null) {
            this.mRequestStarted = z;
        }
    }

    public void setSessionId(int i) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeI(1048594, this, i) != null) || i < 1) {
            return;
        }
        this.feedSessionId = i;
        this.feedSequenceId = BaiduNativeFeedSession.getInstance().getSequenceId(i);
    }

    public void setWinSended(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048595, this, z) == null) {
            this.mWinSended = z;
        }
    }
}
