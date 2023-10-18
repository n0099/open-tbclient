package com.baidu.mobads.sdk.api;

import android.content.Context;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.sdk.api.IAdInterListener;
import com.baidu.mobads.sdk.api.RequestParameters;
import com.baidu.mobads.sdk.internal.ac;
import com.baidu.mobads.sdk.internal.ak;
import com.baidu.mobads.sdk.internal.di;
import com.baidu.mobads.sdk.internal.e;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
/* loaded from: classes3.dex */
public class BaiduNativeManager {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int FEED_TIMEOUT = 8000;
    public static final String TAG = "BaiduNativeManager";
    public transient /* synthetic */ FieldHolder $fh;
    public boolean isCacheVideo;
    public boolean isCacheVideoOnlyWifi;
    public final String mAdPlacementId;
    public String mAppSid;
    public int mBidFloor;
    public final Context mContext;
    public RequestParameters mRequestParameters;
    public int mTimeoutMillis;

    /* loaded from: classes3.dex */
    public interface EntryAdListener {
        void onLpClosed();

        void onNativeFail(int i, String str);

        void onNativeLoad(List<EntryResponse> list);

        void onNoAd(int i, String str);
    }

    /* loaded from: classes3.dex */
    public interface ExpressAdListener {
        void onLpClosed();

        void onNativeFail(int i, String str);

        void onNativeLoad(List<ExpressResponse> list);

        void onNoAd(int i, String str);

        void onVideoDownloadFailed();

        void onVideoDownloadSuccess();
    }

    /* loaded from: classes3.dex */
    public interface FeedAdListener {
        void onLpClosed();

        void onNativeFail(int i, String str);

        void onNativeLoad(List<NativeResponse> list);

        void onNoAd(int i, String str);

        void onVideoDownloadFailed();

        void onVideoDownloadSuccess();
    }

    /* loaded from: classes3.dex */
    public interface PortraitVideoAdListener extends FeedAdListener {
        void onAdClick();
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-1028990043, "Lcom/baidu/mobads/sdk/api/BaiduNativeManager;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-1028990043, "Lcom/baidu/mobads/sdk/api/BaiduNativeManager;");
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public BaiduNativeManager(Context context, String str) {
        this(context, str, 8000);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, str};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (String) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    public void loadContentAd(RequestParameters requestParameters, FeedAdListener feedAdListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048583, this, requestParameters, feedAdListener) == null) {
            e eVar = new e(this.mContext, new ac(feedAdListener), new di(this.mContext, getAdPlacemenId(requestParameters), "content", this.isCacheVideo, this.mTimeoutMillis));
            if (!TextUtils.isEmpty(this.mAppSid)) {
                eVar.b(this.mAppSid);
            }
            eVar.a(getBidFloor(requestParameters));
            eVar.a(this.isCacheVideoOnlyWifi);
            eVar.a(new ak());
            eVar.b(requestParameters);
        }
    }

    public void loadFeedAd(RequestParameters requestParameters, FeedAdListener feedAdListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048585, this, requestParameters, feedAdListener) == null) {
            e eVar = new e(this.mContext, getAdPlacemenId(requestParameters), new ac(feedAdListener), this.isCacheVideo, this.mTimeoutMillis);
            if (!TextUtils.isEmpty(this.mAppSid)) {
                eVar.b(this.mAppSid);
            }
            eVar.a(getBidFloor(requestParameters));
            eVar.a(this.isCacheVideoOnlyWifi);
            eVar.a(new ak());
            eVar.b(requestParameters);
        }
    }

    public void loadInsiteAd(RequestParameters requestParameters, FeedAdListener feedAdListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048587, this, requestParameters, feedAdListener) == null) {
            e eVar = new e(this.mContext, new ac(feedAdListener), new di(this.mContext, getAdPlacemenId(requestParameters), IAdInterListener.AdProdType.PRODUCT_INSITE, this.isCacheVideo, this.mTimeoutMillis));
            if (!TextUtils.isEmpty(this.mAppSid)) {
                eVar.b(this.mAppSid);
            }
            eVar.a(getBidFloor(requestParameters));
            eVar.a(this.isCacheVideoOnlyWifi);
            eVar.a(new ak());
            eVar.b(requestParameters);
        }
    }

    public void loadPortraitVideoAd(RequestParameters requestParameters, FeedAdListener feedAdListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048588, this, requestParameters, feedAdListener) == null) {
            e eVar = new e(this.mContext, new ac(feedAdListener), new di(this.mContext, getAdPlacemenId(requestParameters), IAdInterListener.AdProdType.PRODUCT_PORTRAITVIDEO, this.isCacheVideo, this.mTimeoutMillis));
            if (!TextUtils.isEmpty(this.mAppSid)) {
                eVar.b(this.mAppSid);
            }
            eVar.a(getBidFloor(requestParameters));
            eVar.a(this.isCacheVideoOnlyWifi);
            eVar.a(new ak());
            eVar.b(requestParameters);
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public BaiduNativeManager(Context context, String str, int i) {
        this(context, str, true, i);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, str, Integer.valueOf(i)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (String) objArr2[1], ((Boolean) objArr2[2]).booleanValue(), ((Integer) objArr2[3]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
    }

    @Deprecated
    public void setExpressFeedBiddingData(RequestParameters requestParameters, String str, ExpressAdListener expressAdListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048594, this, requestParameters, str, expressAdListener) == null) {
            e eVar = new e(this.mContext, getAdPlacemenId(requestParameters), expressAdListener, this.isCacheVideo, this.mTimeoutMillis);
            if (!TextUtils.isEmpty(this.mAppSid)) {
                eVar.b(this.mAppSid);
            }
            eVar.a(getBidFloor(requestParameters));
            eVar.a(this.isCacheVideoOnlyWifi);
            eVar.a(new ak());
            eVar.a(requestParameters);
            eVar.a(str);
        }
    }

    @Deprecated
    public void setFeedBiddingData(RequestParameters requestParameters, String str, FeedAdListener feedAdListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048595, this, requestParameters, str, feedAdListener) == null) {
            e eVar = new e(this.mContext, getAdPlacemenId(requestParameters), new ac(feedAdListener), this.isCacheVideo, this.mTimeoutMillis);
            if (!TextUtils.isEmpty(this.mAppSid)) {
                eVar.b(this.mAppSid);
            }
            eVar.a(getBidFloor(requestParameters));
            eVar.a(this.isCacheVideoOnlyWifi);
            eVar.a(new ak());
            eVar.a(requestParameters);
            eVar.a(str);
        }
    }

    @Deprecated
    public void setPortraitVideoBiddingData(RequestParameters requestParameters, String str, PortraitVideoAdListener portraitVideoAdListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048596, this, requestParameters, str, portraitVideoAdListener) == null) {
            e eVar = new e(this.mContext, new ac(portraitVideoAdListener), new di(this.mContext, getAdPlacemenId(requestParameters), IAdInterListener.AdProdType.PRODUCT_PORTRAITVIDEO, this.isCacheVideo, this.mTimeoutMillis));
            if (!TextUtils.isEmpty(this.mAppSid)) {
                eVar.b(this.mAppSid);
            }
            eVar.a(getBidFloor(requestParameters));
            eVar.a(this.isCacheVideoOnlyWifi);
            eVar.a(new ak());
            eVar.a(requestParameters);
            eVar.a(str);
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public BaiduNativeManager(Context context, String str, boolean z) {
        this(context, str, z, 8000);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, str, Boolean.valueOf(z)};
            interceptable.invokeUnInit(65539, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (String) objArr2[1], ((Boolean) objArr2[2]).booleanValue(), ((Integer) objArr2[3]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65539, newInitContext);
                return;
            }
        }
    }

    public BaiduNativeManager(Context context, String str, boolean z, int i) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, str, Boolean.valueOf(z), Integer.valueOf(i)};
            interceptable.invokeUnInit(InputDeviceCompat.SOURCE_TRACKBALL, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(InputDeviceCompat.SOURCE_TRACKBALL, newInitContext);
                return;
            }
        }
        this.isCacheVideo = true;
        this.mTimeoutMillis = 8000;
        this.isCacheVideoOnlyWifi = false;
        this.mBidFloor = -1;
        this.mContext = context;
        this.mAdPlacementId = str;
        this.isCacheVideo = z;
        this.mTimeoutMillis = i;
    }

    private String getAdPlacemenId(RequestParameters requestParameters) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, this, requestParameters)) == null) {
            if (requestParameters != null) {
                String adPlacementId = requestParameters.getAdPlacementId();
                if (!TextUtils.isEmpty(adPlacementId)) {
                    return adPlacementId;
                }
            }
            return this.mAdPlacementId;
        }
        return (String) invokeL.objValue;
    }

    private int getBidFloor(RequestParameters requestParameters) {
        InterceptResult invokeL;
        int bidFloor;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, this, requestParameters)) == null) {
            if (requestParameters != null && (bidFloor = requestParameters.getBidFloor()) > 0) {
                return bidFloor;
            }
            return this.mBidFloor;
        }
        return invokeL.intValue;
    }

    public void setAppSid(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, str) == null) {
            this.mAppSid = str;
        }
    }

    public void setBidFloor(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048592, this, i) == null) {
            this.mBidFloor = i;
        }
    }

    public void setCacheVideoOnlyWifi(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048593, this, z) == null) {
            this.isCacheVideoOnlyWifi = z;
        }
    }

    private void loadBiddingAd(RequestParameters requestParameters, String str, String str2, FeedAdListener feedAdListener, ExpressAdListener expressAdListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(65543, this, requestParameters, str, str2, feedAdListener, expressAdListener) == null) {
            di diVar = new di(this.mContext, getAdPlacemenId(requestParameters), str, this.isCacheVideo, this.mTimeoutMillis);
            if (!TextUtils.isEmpty(this.mAppSid)) {
                diVar.h(this.mAppSid);
            }
            diVar.p = getBidFloor(requestParameters);
            diVar.c(this.isCacheVideoOnlyWifi);
            if (feedAdListener != null) {
                diVar.a(new ac(feedAdListener));
            } else if (expressAdListener != null) {
                diVar.a(expressAdListener);
                diVar.a(1);
            }
            diVar.a(new ak());
            if (requestParameters == null) {
                requestParameters = new RequestParameters.Builder().build();
            }
            diVar.a(requestParameters);
            diVar.m();
            diVar.c(str2);
        }
    }

    public String getExpressFeedBiddingToken(RequestParameters requestParameters) {
        InterceptResult invokeL;
        RequestParameters requestParameters2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, requestParameters)) == null) {
            di diVar = new di(this.mContext, getAdPlacemenId(requestParameters), "feed", this.isCacheVideo, this.mTimeoutMillis);
            diVar.a(1);
            if (requestParameters == null) {
                requestParameters2 = new RequestParameters.Builder().build();
            } else {
                requestParameters2 = requestParameters;
            }
            if (!TextUtils.isEmpty(this.mAppSid)) {
                diVar.h(this.mAppSid);
            }
            diVar.p = getBidFloor(requestParameters);
            diVar.a(requestParameters2);
            this.mRequestParameters = requestParameters2;
            return diVar.m();
        }
        return (String) invokeL.objValue;
    }

    public String getFeedBiddingToken(RequestParameters requestParameters) {
        InterceptResult invokeL;
        RequestParameters requestParameters2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, requestParameters)) == null) {
            di diVar = new di(this.mContext, getAdPlacemenId(requestParameters), "feed", this.isCacheVideo, this.mTimeoutMillis);
            if (requestParameters == null) {
                requestParameters2 = new RequestParameters.Builder().build();
            } else {
                requestParameters2 = requestParameters;
            }
            if (!TextUtils.isEmpty(this.mAppSid)) {
                diVar.h(this.mAppSid);
            }
            diVar.p = getBidFloor(requestParameters);
            diVar.a(requestParameters2);
            this.mRequestParameters = requestParameters2;
            return diVar.m();
        }
        return (String) invokeL.objValue;
    }

    public String getPortraitVideoBiddingToken(RequestParameters requestParameters) {
        InterceptResult invokeL;
        RequestParameters requestParameters2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, requestParameters)) == null) {
            di diVar = new di(this.mContext, getAdPlacemenId(requestParameters), IAdInterListener.AdProdType.PRODUCT_PORTRAITVIDEO, this.isCacheVideo, this.mTimeoutMillis);
            if (requestParameters == null) {
                requestParameters2 = new RequestParameters.Builder().build();
            } else {
                requestParameters2 = requestParameters;
            }
            if (!TextUtils.isEmpty(this.mAppSid)) {
                diVar.h(this.mAppSid);
            }
            diVar.p = getBidFloor(requestParameters);
            diVar.a(requestParameters2);
            this.mRequestParameters = requestParameters2;
            return diVar.m();
        }
        return (String) invokeL.objValue;
    }

    public void loadBidAdForExpress(String str, ExpressAdListener expressAdListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, str, expressAdListener) == null) {
            loadBiddingAd(this.mRequestParameters, "feed", str, null, expressAdListener);
        }
    }

    public void loadBidAdForFeed(String str, FeedAdListener feedAdListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048580, this, str, feedAdListener) == null) {
            loadBiddingAd(this.mRequestParameters, "feed", str, feedAdListener, null);
        }
    }

    public void loadBidAdForPortraitVideo(String str, FeedAdListener feedAdListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048581, this, str, feedAdListener) == null) {
            loadBiddingAd(this.mRequestParameters, IAdInterListener.AdProdType.PRODUCT_PORTRAITVIDEO, str, feedAdListener, null);
        }
    }

    public void loadFeedEntryAd(RequestParameters requestParameters, EntryAdListener entryAdListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048586, this, requestParameters, entryAdListener) == null) {
            e eVar = new e(this.mContext, getAdPlacemenId(requestParameters), entryAdListener, this.isCacheVideo, this.mTimeoutMillis);
            if (!TextUtils.isEmpty(this.mAppSid)) {
                eVar.b(this.mAppSid);
            }
            eVar.b(requestParameters);
        }
    }

    public void loadPortraitVideoAd(RequestParameters requestParameters, PortraitVideoAdListener portraitVideoAdListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048589, this, requestParameters, portraitVideoAdListener) == null) {
            loadPortraitVideoAd(requestParameters, (FeedAdListener) portraitVideoAdListener);
        }
    }

    public void loadBidAdForPortraitVideo(String str, PortraitVideoAdListener portraitVideoAdListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048582, this, str, portraitVideoAdListener) == null) {
            loadBiddingAd(this.mRequestParameters, IAdInterListener.AdProdType.PRODUCT_PORTRAITVIDEO, str, portraitVideoAdListener, null);
        }
    }

    public void loadExpressAd(RequestParameters requestParameters, ExpressAdListener expressAdListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, requestParameters, expressAdListener) == null) {
            e eVar = new e(this.mContext, getAdPlacemenId(requestParameters), expressAdListener, this.isCacheVideo, this.mTimeoutMillis);
            if (!TextUtils.isEmpty(this.mAppSid)) {
                eVar.b(this.mAppSid);
            }
            eVar.a(getBidFloor(requestParameters));
            eVar.a(this.isCacheVideoOnlyWifi);
            eVar.a(new ak());
            eVar.b(requestParameters);
        }
    }

    public void loadPrerollVideo(RequestParameters requestParameters, FeedAdListener feedAdListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048590, this, requestParameters, feedAdListener) == null) {
            e eVar = new e(this.mContext, getAdPlacemenId(requestParameters), new ac(feedAdListener), this.isCacheVideo, 8000, IAdInterListener.AdProdType.PRODUCT_PREROLL);
            if (!TextUtils.isEmpty(this.mAppSid)) {
                eVar.b(this.mAppSid);
            }
            eVar.a(getBidFloor(requestParameters));
            eVar.b(requestParameters);
        }
    }
}
