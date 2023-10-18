package com.baidu.mobads.sdk.api;

import android.content.Context;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.sdk.internal.dj;
import com.baidu.mobads.sdk.internal.dr;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
/* loaded from: classes3.dex */
public class FullScreenVideoAd {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String TAG = "FullScreenVideoAd";
    public transient /* synthetic */ FieldHolder $fh;
    public dr mAdProd;
    public final Context mContext;
    public RequestParameters mRequestParameters;

    /* loaded from: classes3.dex */
    public interface FullScreenVideoAdListener extends ScreenVideoAdListener {
        @Override // com.baidu.mobads.sdk.api.ScreenVideoAdListener
        void onAdClick();

        @Override // com.baidu.mobads.sdk.api.ScreenVideoAdListener
        void onAdClose(float f);

        @Override // com.baidu.mobads.sdk.api.ScreenVideoAdListener
        void onAdFailed(String str);

        @Override // com.baidu.mobads.sdk.api.ScreenVideoAdListener
        void onAdShow();

        @Override // com.baidu.mobads.sdk.api.ScreenVideoAdListener
        void onAdSkip(float f);

        @Override // com.baidu.mobads.sdk.api.ScreenVideoAdListener
        void onVideoDownloadFailed();

        @Override // com.baidu.mobads.sdk.api.ScreenVideoAdListener
        void onVideoDownloadSuccess();

        @Override // com.baidu.mobads.sdk.api.ScreenVideoAdListener
        void playCompletion();
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public FullScreenVideoAd(Context context, String str, FullScreenVideoAdListener fullScreenVideoAdListener) {
        this(context, str, fullScreenVideoAdListener, false);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, str, fullScreenVideoAdListener};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (String) objArr2[1], (FullScreenVideoAdListener) objArr2[2], ((Boolean) objArr2[3]).booleanValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public FullScreenVideoAd(Context context, String str, FullScreenVideoAdListener fullScreenVideoAdListener, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, str, fullScreenVideoAdListener, Boolean.valueOf(z)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.mContext = context;
        dj djVar = new dj(this.mContext, str, z);
        this.mAdProd = djVar;
        djVar.a(fullScreenVideoAdListener);
    }

    public void biddingFail(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
            biddingFail(str, null);
        }
    }

    public void biddingSuccess(String str) {
        dr drVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) && (drVar = this.mAdProd) != null) {
            drVar.a(true, str);
        }
    }

    public void loadBiddingAd(String str) {
        dr drVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048583, this, str) == null) && (drVar = this.mAdProd) != null) {
            drVar.c(str);
        }
    }

    public void setAppSid(String str) {
        dr drVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str) == null) && (drVar = this.mAdProd) != null) {
            drVar.h(str);
        }
    }

    public void setBidFloor(int i) {
        dr drVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048585, this, i) == null) && (drVar = this.mAdProd) != null) {
            drVar.p = i;
        }
    }

    @Deprecated
    public void setBiddingData(String str) {
        dr drVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048586, this, str) == null) && (drVar = this.mAdProd) != null) {
            drVar.b(str);
        }
    }

    public void setRequestParameters(RequestParameters requestParameters) {
        dr drVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, requestParameters) == null) {
            this.mRequestParameters = requestParameters;
            if (requestParameters != null && (drVar = this.mAdProd) != null) {
                drVar.a(requestParameters);
            }
        }
    }

    public void biddingFail(String str, HashMap<String, Object> hashMap) {
        dr drVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, hashMap) == null) && (drVar = this.mAdProd) != null) {
            drVar.a(false, str, hashMap);
        }
    }

    public String getBiddingToken() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            dr drVar = this.mAdProd;
            if (drVar != null) {
                return drVar.m();
            }
            return null;
        }
        return (String) invokeV.objValue;
    }

    public String getECPMLevel() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            dr drVar = this.mAdProd;
            if (drVar != null) {
                return drVar.h();
            }
            return "";
        }
        return (String) invokeV.objValue;
    }

    public boolean isReady() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            dr drVar = this.mAdProd;
            if (drVar != null) {
                return drVar.g();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public synchronized void load() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            synchronized (this) {
                if (this.mAdProd != null) {
                    this.mAdProd.a();
                }
            }
        }
    }

    public synchronized void show() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            synchronized (this) {
                if (this.mAdProd != null) {
                    this.mAdProd.f();
                }
            }
        }
    }
}
