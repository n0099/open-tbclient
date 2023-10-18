package com.baidu.mobads.sdk.api;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.view.KeyEvent;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.sdk.internal.a;
import com.baidu.mobads.sdk.internal.av;
import com.baidu.mobads.sdk.internal.cp;
import com.baidu.mobads.sdk.internal.dg;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
/* loaded from: classes3.dex */
public class ExpressInterstitialAd {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public InterstitialAdDislikeListener mAdDislikeListener;
    public String mAdPlaceId;
    public String mAppsid;
    public int mBidFloor;
    public Context mContext;
    public ExpressInterstitialListener mExpressInterstitialListener;
    public int mHeight;
    public InterAdDownloadWindowListener mInterAdDownloadWindowListener;
    public dg mNativeInterstitialAdProd;
    public RequestParameters mRequestParameters;
    public boolean mUseDialogContainer;
    public boolean mUseDialogFrame;
    public int mWidth;
    public boolean onlyFetchAd;

    /* loaded from: classes3.dex */
    public interface InterAdDownloadWindowListener {
        void adDownloadWindowClose();

        void adDownloadWindowShow();

        void onADPermissionClose();

        void onADPermissionShow();

        void onADPrivacyClick();

        void onADPrivacyClose();
    }

    /* loaded from: classes3.dex */
    public interface InterstitialAdDislikeListener {
        void interstitialAdDislikeClick();
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ExpressInterstitialAd(Context context, String str) {
        this(context, str, 500, 600);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, str};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (String) objArr2[1], ((Integer) objArr2[2]).intValue(), ((Integer) objArr2[3]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public ExpressInterstitialAd(Context context, String str, int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, str, Integer.valueOf(i), Integer.valueOf(i2)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.mUseDialogFrame = false;
        this.mBidFloor = -1;
        this.mUseDialogContainer = false;
        this.mContext = context;
        this.mAdPlaceId = str;
        this.mWidth = i;
        this.mHeight = i2;
    }

    public void biddingFail(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
            biddingFail(str, null);
        }
    }

    public void biddingSuccess(String str) {
        dg dgVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) && (dgVar = this.mNativeInterstitialAdProd) != null) {
            dgVar.a(true, str);
        }
    }

    public Object getAdDataForKey(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, str)) == null) {
            dg dgVar = this.mNativeInterstitialAdProd;
            if (dgVar != null) {
                return dgVar.a(str);
            }
            return null;
        }
        return invokeL.objValue;
    }

    public void loadBiddingAd(String str) {
        dg dgVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048585, this, str) == null) && (dgVar = this.mNativeInterstitialAdProd) != null) {
            dgVar.c(str);
        }
    }

    public void setAdDislikeListener(InterstitialAdDislikeListener interstitialAdDislikeListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, interstitialAdDislikeListener) == null) {
            this.mAdDislikeListener = interstitialAdDislikeListener;
        }
    }

    public void setAppSid(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, str) == null) {
            this.mAppsid = str;
        }
    }

    public void setBidFloor(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048588, this, i) == null) {
            this.mBidFloor = i;
        }
    }

    @Deprecated
    public void setBiddingData(String str) {
        dg dgVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048589, this, str) == null) && (dgVar = this.mNativeInterstitialAdProd) != null) {
            dgVar.b(str);
        }
    }

    public void setDialogFrame(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048590, this, z) == null) {
            this.mUseDialogFrame = z;
        }
    }

    public void setDownloadListener(InterAdDownloadWindowListener interAdDownloadWindowListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, interAdDownloadWindowListener) == null) {
            this.mInterAdDownloadWindowListener = interAdDownloadWindowListener;
        }
    }

    public void setLoadListener(ExpressInterstitialListener expressInterstitialListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, expressInterstitialListener) == null) {
            this.mExpressInterstitialListener = expressInterstitialListener;
        }
    }

    public void setRequestParameters(RequestParameters requestParameters) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, requestParameters) == null) {
            this.mRequestParameters = requestParameters;
        }
    }

    public void show(Activity activity) {
        dg dgVar;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048595, this, activity) != null) || (dgVar = this.mNativeInterstitialAdProd) == null) {
            return;
        }
        dgVar.a(activity);
        show();
    }

    public void useUseDialogContainer(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048596, this, z) == null) {
            this.mUseDialogContainer = z;
        }
    }

    private void initNativeInterstitialAdProd() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65539, this) == null) {
            cp cpVar = new cp(this.mContext);
            cpVar.a(new cp.a(this) { // from class: com.baidu.mobads.sdk.api.ExpressInterstitialAd.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ ExpressInterstitialAd this$0;

                @Override // com.baidu.mobads.sdk.internal.cp.a
                public void onAttachedToWindow() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    }
                }

                @Override // com.baidu.mobads.sdk.internal.cp.a
                public boolean onKeyDown(int i, KeyEvent keyEvent) {
                    InterceptResult invokeIL;
                    Interceptable interceptable2 = $ic;
                    return (interceptable2 == null || (invokeIL = interceptable2.invokeIL(Constants.METHOD_SEND_USER_MSG, this, i, keyEvent)) == null) ? i == 4 : invokeIL.booleanValue;
                }

                @Override // com.baidu.mobads.sdk.internal.cp.a
                public void onLayoutComplete(int i, int i2) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeII(1048579, this, i, i2) == null) {
                    }
                }

                @Override // com.baidu.mobads.sdk.internal.cp.a
                public void onWindowFocusChanged(boolean z) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeZ(1048580, this, z) == null) {
                    }
                }

                @Override // com.baidu.mobads.sdk.internal.cp.a
                public void onWindowVisibilityChanged(int i) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeI(1048581, this, i) == null) {
                    }
                }

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.this$0 = this;
                }

                @Override // com.baidu.mobads.sdk.internal.cp.a
                @SuppressLint({"MissingSuperCall"})
                public void onDetachedFromWindow() {
                    Interceptable interceptable2 = $ic;
                    if ((interceptable2 == null || interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && this.this$0.mNativeInterstitialAdProd != null) {
                        this.this$0.mNativeInterstitialAdProd.p();
                    }
                }
            });
            this.mNativeInterstitialAdProd = new dg(this.mContext, cpVar, this.mAdPlaceId);
            if (!TextUtils.isEmpty(this.mAppsid)) {
                this.mNativeInterstitialAdProd.o = this.mAppsid;
            }
            dg dgVar = this.mNativeInterstitialAdProd;
            dgVar.p = this.mBidFloor;
            dgVar.q = this.onlyFetchAd;
            dgVar.a(this.mExpressInterstitialListener);
            this.mNativeInterstitialAdProd.a(this.mInterAdDownloadWindowListener);
            this.mNativeInterstitialAdProd.a(this.mAdDislikeListener);
            this.mNativeInterstitialAdProd.c(this.mUseDialogFrame);
            this.mNativeInterstitialAdProd.d(this.mUseDialogContainer);
            RequestParameters requestParameters = this.mRequestParameters;
            if (requestParameters != null) {
                this.mNativeInterstitialAdProd.a(requestParameters);
            }
        }
    }

    private void reallyLoad() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, this) == null) {
            initNativeInterstitialAdProd();
            this.mNativeInterstitialAdProd.a();
        }
    }

    public void destroy() {
        dg dgVar;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048579, this) != null) || (dgVar = this.mNativeInterstitialAdProd) == null) {
            return;
        }
        dgVar.e();
    }

    public String getBiddingToken() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            this.onlyFetchAd = true;
            initNativeInterstitialAdProd();
            return this.mNativeInterstitialAdProd.m();
        }
        return (String) invokeV.objValue;
    }

    public String getECPMLevel() {
        InterceptResult invokeV;
        a x;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            dg dgVar = this.mNativeInterstitialAdProd;
            if (dgVar != null && (x = dgVar.x()) != null) {
                return x.z();
            }
            return "";
        }
        return (String) invokeV.objValue;
    }

    public boolean isReady() {
        InterceptResult invokeV;
        IAdInterListener iAdInterListener;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            dg dgVar = this.mNativeInterstitialAdProd;
            if (dgVar != null && (iAdInterListener = dgVar.k) != null) {
                return iAdInterListener.isAdReady();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public void load() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            if (this.mContext == null) {
                av.c().e("ExpressInterstitialAd", "请传一个非空的context再进行load");
                return;
            }
            this.onlyFetchAd = true;
            reallyLoad();
        }
    }

    public void show() {
        dg dgVar;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048594, this) != null) || (dgVar = this.mNativeInterstitialAdProd) == null) {
            return;
        }
        if (dgVar.g()) {
            this.mNativeInterstitialAdProd.h();
        } else {
            this.mNativeInterstitialAdProd.f((IOAdEvent) null);
        }
    }

    public void biddingFail(String str, HashMap<String, Object> hashMap) {
        dg dgVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, hashMap) == null) && (dgVar = this.mNativeInterstitialAdProd) != null) {
            dgVar.a(false, str, hashMap);
        }
    }
}
