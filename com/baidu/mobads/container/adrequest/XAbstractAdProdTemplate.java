package com.baidu.mobads.container.adrequest;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.view.View;
import android.widget.RelativeLayout;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.ar.pose.PoseAR;
import com.baidu.mobads.container.XBaseAdContainer;
import com.baidu.mobads.container.XMyWebView;
import com.baidu.mobads.container.components.net.OAdURLConnection;
import com.baidu.mobads.container.config.AppConfigImp;
import com.baidu.mobads.container.error.XAdErrorCode;
import com.baidu.mobads.container.splash.SplashAdContainer;
import com.baidu.mobads.container.template.splash.XSplashTemplateAdContainer;
import com.baidu.mobads.container.util.ActivityUtils;
import com.baidu.mobads.container.util.DeviceUtils;
import com.baidu.mobads.container.util.RemoteXAdLogger;
import com.baidu.mobads.container.util.XAdRemoteEvent;
import com.baidu.mobads.container.util.XAdRemoteEventDispatcher;
import com.baidu.mobads.container.util.filedownloader.MaterialLoadErrorCode;
import com.baidu.mobads.container.util.filedownloader.MaterialLoader;
import com.baidu.mobads.container.util.filedownloader.MaterialLoadingListener;
import com.baidu.mobads.container.util.network.NetworkInfoUtils;
import com.baidu.sapi2.SapiWebView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class XAbstractAdProdTemplate extends XAdRemoteEventDispatcher implements XAdContainerContext {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String TAG = "XAbstractAdProdTemplate";
    public transient /* synthetic */ FieldHolder $fh;
    public boolean isCacheVideo;
    public Activity mActivity;
    public XBaseAdContainer mAdContainer;
    public RemoteXAdLogger mAdLogger;
    public String mAdPlaceId;
    public String mAdProd;
    public ProdAdRequestInfo mAdRequestInfo;
    public IXAdResponseInfo mAdResponseInfo;
    public JSONObject mAllParamObj;
    public Context mAppContext;
    public String mAppsid;
    public boolean mCacheVideoOnlyWifi;
    public IXAdInstanceInfo mCurrentAdInstance;
    public Context mCxt;
    public String mDisplayDownInfo;
    public boolean mIsTimeout;
    public Handler mLoadAdTimeoutHandler;
    public Runnable mLoadAdTimeoutRunnable;
    public CustomMaterialLoadingListener mMaterialLoadingListener;
    public boolean mNeedCache;
    public boolean mOnlyLoadAd;
    public int mTimeout;
    public OAdURLConnection oAdURLConnection;

    /* loaded from: classes3.dex */
    public static class CustomMaterialLoadingListener implements MaterialLoadingListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final Context mAppContext;
        public final IXAdInstanceInfo mInstanceInfo;
        public final WeakReference<XAbstractAdProdTemplate> mProdTemplate;

        public CustomMaterialLoadingListener(XAbstractAdProdTemplate xAbstractAdProdTemplate, IXAdInstanceInfo iXAdInstanceInfo) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {xAbstractAdProdTemplate, iXAdInstanceInfo};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.mProdTemplate = new WeakReference<>(xAbstractAdProdTemplate);
            this.mAppContext = xAbstractAdProdTemplate.mAppContext.getApplicationContext();
            this.mInstanceInfo = iXAdInstanceInfo;
        }

        @Override // com.baidu.mobads.container.util.filedownloader.MaterialLoadingListener
        public void onLoadingComplete(String str, View view, Bitmap bitmap) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLL(1048576, this, str, view, bitmap) == null) {
                Message obtain = Message.obtain();
                obtain.what = 0;
                Bundle bundle = new Bundle();
                bundle.putBoolean(MaterialLoader.KEY_OF_CACHING_RESULT, true);
                bundle.putLong(MaterialLoader.KEY_OF_DL_TIME_CONSUME, -1L);
                bundle.putString(MaterialLoader.KEY_OF_LOCAL_CREATIVE_URL, MaterialLoader.getInstance(this.mAppContext).getMaterialFilePath(str));
                obtain.setData(bundle);
                if (this.mProdTemplate.get() != null) {
                    this.mProdTemplate.get().processDlResult(obtain, this.mInstanceInfo);
                }
            }
        }

        @Override // com.baidu.mobads.container.util.filedownloader.MaterialLoadingListener
        public void onLoadingFailed(String str, View view, MaterialLoadErrorCode materialLoadErrorCode) {
            XAbstractAdProdTemplate xAbstractAdProdTemplate;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, view, materialLoadErrorCode) == null) || (xAbstractAdProdTemplate = this.mProdTemplate.get()) == null) {
                return;
            }
            xAbstractAdProdTemplate.videoCacheFailed();
            if (xAbstractAdProdTemplate.needCreateContainerAfterEndOfCache(this.mInstanceInfo)) {
                xAbstractAdProdTemplate.handleAllReady();
            }
        }

        @Override // com.baidu.mobads.container.util.filedownloader.MaterialLoadingListener
        public void onLoadingStarted(String str, View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, str, view) == null) {
            }
        }

        public void release() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
                this.mProdTemplate.clear();
            }
        }
    }

    public XAbstractAdProdTemplate(Context context, ProdAdRequestInfo prodAdRequestInfo) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, prodAdRequestInfo};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mAdLogger = RemoteXAdLogger.getInstance();
        this.mLoadAdTimeoutHandler = new Handler(Looper.getMainLooper());
        this.mLoadAdTimeoutRunnable = null;
        this.mMaterialLoadingListener = null;
        this.mTimeout = 10000;
        this.mCurrentAdInstance = null;
        this.mAdProd = "";
        this.mIsTimeout = false;
        this.mCxt = context;
        this.mAppContext = context.getApplicationContext();
        this.mAdRequestInfo = prodAdRequestInfo;
        this.mLoadAdTimeoutRunnable = new Runnable(this) { // from class: com.baidu.mobads.container.adrequest.XAbstractAdProdTemplate.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ XAbstractAdProdTemplate this$0;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr2 = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i4 = newInitContext2.flag;
                    if ((i4 & 1) != 0) {
                        int i5 = i4 & 2;
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.this$0 = this;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    try {
                        this.this$0.mIsTimeout = true;
                        this.this$0.handleRequestAdServerFail(XAdErrorCode.REQUEST_TIMEOUT.getCode(), XAdErrorCode.REQUEST_TIMEOUT.getMessage());
                    } catch (Exception e2) {
                        this.this$0.mAdLogger.d(e2);
                    }
                }
            }
        };
    }

    private boolean canDl(IXAdInstanceInfo iXAdInstanceInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65544, this, iXAdInstanceInfo)) == null) {
            return isFeedVideo(iXAdInstanceInfo) || NetworkInfoUtils.isWifiConnected(this.mAppContext).booleanValue() || isPicture(iXAdInstanceInfo);
        }
        return invokeL.booleanValue;
    }

    private void executeCacheVideo(ArrayList<IXAdInstanceInfo> arrayList) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65545, this, arrayList) == null) || arrayList == null || arrayList.size() <= 0) {
            return;
        }
        Iterator<IXAdInstanceInfo> it = arrayList.iterator();
        while (it.hasNext()) {
            IXAdInstanceInfo next = it.next();
            if (isNeedCacheVideo(next) && this.isCacheVideo) {
                cacheCreativeAsset(next);
            }
            if (isFeedVideo(next)) {
                MaterialLoader.getInstance(this.mAppContext).cacheMaterialForURLString(next.getMainPictureUrl(), null);
            }
        }
    }

    private void initWebView() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65546, this) == null) {
            ActivityUtils.runOnUiThread(new Runnable(this) { // from class: com.baidu.mobads.container.adrequest.XAbstractAdProdTemplate.4
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ XAbstractAdProdTemplate this$0;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.this$0 = this;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        try {
                            XMyWebView.create(this.this$0.getActivity(), RemoteXAdLogger.getInstance(), true, true).loadDataWithBaseURL(null, "", SapiWebView.DATA_MIME_TYPE, "UTF-8", null);
                        } catch (Exception unused) {
                        }
                    }
                }
            });
        }
    }

    private boolean isCachedVideoFile(IXAdInstanceInfo iXAdInstanceInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65547, this, iXAdInstanceInfo)) == null) {
            try {
                if (isVideo(iXAdInstanceInfo) && this.mCacheVideoOnlyWifi) {
                    return NetworkInfoUtils.isWifiConnected(this.mAppContext).booleanValue();
                }
                return true;
            } catch (Throwable th) {
                this.mAdLogger.d(TAG, th.getMessage());
                return true;
            }
        }
        return invokeL.booleanValue;
    }

    private boolean isFeedVideo(IXAdInstanceInfo iXAdInstanceInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65548, this, iXAdInstanceInfo)) == null) {
            if (iXAdInstanceInfo.getCreativeType().getValue().equals("video")) {
                return "feed".equals(getAdProd()) || "pvideo".equals(getAdProd());
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    private boolean isNeedCacheVideo(IXAdInstanceInfo iXAdInstanceInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65549, this, iXAdInstanceInfo)) == null) {
            if (iXAdInstanceInfo.getCreativeType().getValue().equals("video")) {
                return "feed".equals(getAdProd()) || "pvideo".equals(getAdProd());
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean needCreateContainerAfterEndOfCache(IXAdInstanceInfo iXAdInstanceInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65550, this, iXAdInstanceInfo)) == null) ? "rsplash".equals(getAdProd()) && isPicture(iXAdInstanceInfo) : invokeL.booleanValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void processDlResult(Message message, IXAdInstanceInfo iXAdInstanceInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65551, this, message, iXAdInstanceInfo) == null) {
            if (message.getData().getBoolean(MaterialLoader.KEY_OF_CACHING_RESULT)) {
                iXAdInstanceInfo.setLocalCreativeURL(message.getData().getString(MaterialLoader.KEY_OF_LOCAL_CREATIVE_URL));
                if (needCreateContainerAfterEndOfCache(iXAdInstanceInfo)) {
                    handleAllReady();
                }
                dispatchEvent(new XAdRemoteEvent("vdieoCacheSucc"));
                return;
            }
            dispatchEvent(new XAdRemoteEvent("vdieoCacheFailed"));
            iXAdInstanceInfo.setLocalCreativeURL(null);
            if (needCreateContainerAfterEndOfCache(iXAdInstanceInfo)) {
                handleAllReady();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void videoCacheFailed() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65552, this) == null) {
            dispatchEvent(new XAdRemoteEvent("vdieoCacheFailed"));
        }
    }

    public void cacheCreativeAsset(IXAdInstanceInfo iXAdInstanceInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, iXAdInstanceInfo) == null) {
            this.mAdLogger.d(TAG, "cacheCreativeAsset");
            String urlForCache = getUrlForCache(iXAdInstanceInfo);
            if (TextUtils.isEmpty(urlForCache)) {
                return;
            }
            iXAdInstanceInfo.setLocalCreativeURL(null);
            this.mMaterialLoadingListener = new CustomMaterialLoadingListener(this, iXAdInstanceInfo);
            MaterialLoader.getInstance(this.mAppContext).cacheMaterialForURLString(urlForCache, this.mMaterialLoadingListener);
        }
    }

    public void callbackAdFailed(int i2, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, str) == null) {
            HashMap hashMap = new HashMap();
            hashMap.put("error_message", str);
            hashMap.put("error_code", Integer.valueOf(i2));
            dispatchEvent(new XAdRemoteEvent("AdError", hashMap));
        }
    }

    public void createAdContainer() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) && "rsplash".equals(getAdProd())) {
            if (this.mCurrentAdInstance.getCreativeType().getValue().equals("html")) {
                this.mAdContainer = new XSplashTemplateAdContainer(this);
            } else {
                this.mAdContainer = new SplashAdContainer(this, this.mCxt);
            }
        }
    }

    public void destroy() {
        CustomMaterialLoadingListener customMaterialLoadingListener;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || (customMaterialLoadingListener = this.mMaterialLoadingListener) == null) {
            return;
        }
        customMaterialLoadingListener.release();
        this.mMaterialLoadingListener = null;
    }

    public void disposeTotalRequestTimer() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            Runnable runnable = this.mLoadAdTimeoutRunnable;
            if (runnable != null) {
                this.mLoadAdTimeoutHandler.removeCallbacks(runnable);
            }
            this.mLoadAdTimeoutRunnable = null;
        }
    }

    @Override // com.baidu.mobads.container.adrequest.XAdContainerContext
    public Activity getActivity() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            Activity activity = this.mActivity;
            if (activity != null) {
                return activity;
            }
            Context context = this.mCxt;
            if (context instanceof Activity) {
                this.mActivity = (Activity) context;
            } else if (getAdProdBase() != null && (getAdProdBase().getContext() instanceof Activity)) {
                this.mActivity = (Activity) getAdProdBase().getContext();
            }
            return this.mActivity;
        }
        return (Activity) invokeV.objValue;
    }

    @Override // com.baidu.mobads.container.adrequest.XAdContainerContext
    public int getAdHeight() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? Integer.valueOf(this.mAllParamObj.optString("h", "0")).intValue() : invokeV.intValue;
    }

    @Override // com.baidu.mobads.container.adrequest.XAdContainerContext
    public IXAdInstanceInfo getAdInstanceInfo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.mCurrentAdInstance : (IXAdInstanceInfo) invokeV.objValue;
    }

    @Override // com.baidu.mobads.container.adrequest.XAdContainerContext
    public String getAdPlacementId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.mAdPlaceId : (String) invokeV.objValue;
    }

    @Override // com.baidu.mobads.container.adrequest.XAdContainerContext
    public String getAdProd() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.mAdProd : (String) invokeV.objValue;
    }

    @Override // com.baidu.mobads.container.adrequest.XAdContainerContext
    public RelativeLayout getAdProdBase() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            View adView = getAdView();
            if (adView instanceof RelativeLayout) {
                return (RelativeLayout) adView;
            }
            return null;
        }
        return (RelativeLayout) invokeV.objValue;
    }

    @Override // com.baidu.mobads.container.adrequest.XAdContainerContext
    public JSONObject getAdReqParam() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.mAllParamObj : (JSONObject) invokeV.objValue;
    }

    @Override // com.baidu.mobads.container.adrequest.XAdContainerContext
    public IXAdResponseInfo getAdResponseInfo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.mAdResponseInfo : (IXAdResponseInfo) invokeV.objValue;
    }

    public View getAdView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            XBaseAdContainer xBaseAdContainer = this.mAdContainer;
            if (xBaseAdContainer instanceof SplashAdContainer) {
                return xBaseAdContainer.getAdView();
            }
            ProdAdRequestInfo prodAdRequestInfo = this.mAdRequestInfo;
            if (prodAdRequestInfo != null) {
                return prodAdRequestInfo.getAdContainer();
            }
            return null;
        }
        return (View) invokeV.objValue;
    }

    @Override // com.baidu.mobads.container.adrequest.XAdContainerContext
    public int getAdWidth() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? Integer.valueOf(this.mAllParamObj.optString("w", "0")).intValue() : invokeV.intValue;
    }

    @Override // com.baidu.mobads.container.adrequest.XAdContainerContext
    public Context getAppContext() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? this.mAppContext : (Context) invokeV.objValue;
    }

    @Override // com.baidu.mobads.container.adrequest.XAdContainerContext
    public String getAppSec() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            return this.mAppsid + "_cpr";
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.mobads.container.adrequest.XAdContainerContext
    public String getAppsid() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
            if (!TextUtils.isEmpty(this.mAppsid)) {
                return this.mAppsid;
            }
            return DeviceUtils.getInstance().getAppId(this.mAppContext);
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.mobads.container.adrequest.XAdContainerContext
    public XAdRemoteEventDispatcher getEventDispatcher() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) ? this : (XAdRemoteEventDispatcher) invokeV.objValue;
    }

    public String getUrlForCache(IXAdInstanceInfo iXAdInstanceInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048595, this, iXAdInstanceInfo)) == null) {
            if (iXAdInstanceInfo == null) {
                return "";
            }
            if ("video".equals(iXAdInstanceInfo.getCreativeType().getValue())) {
                return iXAdInstanceInfo.getVideoUrl();
            }
            if ("rich_media".equals(iXAdInstanceInfo.getCreativeType().getValue())) {
                return iXAdInstanceInfo.getMainPictureUrl();
            }
            return needCreateContainerAfterEndOfCache(iXAdInstanceInfo) ? iXAdInstanceInfo.getMainPictureUrl() : "";
        }
        return (String) invokeL.objValue;
    }

    public void handleAdClick(View view, JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048596, this, view, jSONObject) == null) {
        }
    }

    public void handleAdServerSuccess() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048597, this) == null) {
            executeCacheVideo(this.mAdResponseInfo.getAdInstanceList());
            if (!this.mNeedCache) {
                handleAllReady();
                return;
            }
            IXAdInstanceInfo primaryAdInstanceInfo = this.mAdResponseInfo.getPrimaryAdInstanceInfo();
            String urlForCache = getUrlForCache(primaryAdInstanceInfo);
            if (TextUtils.isEmpty(urlForCache)) {
                handleAllReady();
                return;
            }
            boolean booleanValue = MaterialLoader.getInstance(this.mAppContext).isCachedDataExistsForKey(urlForCache).booleanValue();
            if (booleanValue) {
                primaryAdInstanceInfo.setLocalCreativeURL(MaterialLoader.getInstance(this.mAppContext).getMaterialFilePath(urlForCache));
            } else {
                cacheCreativeAsset(primaryAdInstanceInfo);
            }
            if (!needCreateContainerAfterEndOfCache(primaryAdInstanceInfo) || booleanValue) {
                handleAllReady();
            }
        }
    }

    public void handleAllReady() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048598, this) == null) {
            ActivityUtils.runOnUiThread(new Runnable(this) { // from class: com.baidu.mobads.container.adrequest.XAbstractAdProdTemplate.3
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ XAbstractAdProdTemplate this$0;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.this$0 = this;
                }

                @Override // java.lang.Runnable
                public void run() {
                    XAdRemoteEvent xAdRemoteEvent;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        this.this$0.createAdContainer();
                        XAbstractAdProdTemplate xAbstractAdProdTemplate = this.this$0;
                        if (xAbstractAdProdTemplate.mAdContainer == null) {
                            xAbstractAdProdTemplate.callbackAdFailed(XAdErrorCode.AD_CONTAINER_NULL.getCode(), XAdErrorCode.AD_CONTAINER_NULL.getMessage());
                            return;
                        }
                        IXAdResponseInfo iXAdResponseInfo = xAbstractAdProdTemplate.mAdResponseInfo;
                        if (iXAdResponseInfo != null) {
                            xAdRemoteEvent = new XAdRemoteEvent("AdLoaded", iXAdResponseInfo.getOriginResponseStr());
                        } else {
                            xAdRemoteEvent = new XAdRemoteEvent("AdLoaded");
                        }
                        this.this$0.dispatchEvent(xAdRemoteEvent);
                        if (this.this$0.mOnlyLoadAd) {
                            return;
                        }
                        this.this$0.mAdLogger.d(XAbstractAdProdTemplate.TAG, "handleAllReady");
                        this.this$0.showAd();
                    }
                }
            });
        }
    }

    public void handleEvent(JSONObject jSONObject, Map<String, Object> map) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048599, this, jSONObject, map) == null) {
            XBaseAdContainer xBaseAdContainer = this.mAdContainer;
            if (xBaseAdContainer != null) {
                xBaseAdContainer.handleEvent(jSONObject, map);
            } else if (jSONObject == null || !"splash_focus_start_activity".equals(jSONObject.optString(PoseAR.MDL_START_POSE_FUN_EVENT_TYPE_KEY))) {
            } else {
                try {
                    Intent intent = (Intent) map.get("splash_focus_user_intent");
                    if (this.mCxt != null) {
                        this.mCxt.startActivity(intent);
                    }
                    dispatchEvent(new XAdRemoteEvent("AdFinishActivity"));
                } catch (Throwable th) {
                    RemoteXAdLogger.getInstance().e(th);
                }
            }
        }
    }

    public void handleRequestAdServerFail(int i2, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048600, this, i2, str) == null) {
            disposeTotalRequestTimer();
            callbackAdFailed(i2, str);
        }
    }

    public void handleRequestAdServerSuccess(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048601, this, str, str2) == null) {
            disposeTotalRequestTimer();
            try {
                setAdResponseInfo(new XAdResponseInfo(str));
                if (this.mAdResponseInfo == null) {
                    handleRequestAdServerFail(XAdErrorCode.ADELEMENT_PARSE_ERROR.getCode(), XAdErrorCode.ADELEMENT_PARSE_ERROR.getMessage());
                } else if (this.mAdResponseInfo.getAdInstanceList().size() > 0) {
                    this.mCurrentAdInstance = this.mAdResponseInfo.getPrimaryAdInstanceInfo();
                    handleAdServerSuccess();
                } else {
                    String errorCode = this.mAdResponseInfo.getErrorCode();
                    int parseInt = !TextUtils.isEmpty(errorCode) ? Integer.parseInt(errorCode) : 0;
                    String errorMessage = this.mAdResponseInfo.getErrorMessage();
                    if ("0".equals(errorCode) && TextUtils.isEmpty(errorMessage)) {
                        errorMessage = "无广告返回";
                    }
                    handleRequestNoAd(errorMessage, parseInt);
                }
            } catch (Exception unused) {
                handleRequestAdServerFail(XAdErrorCode.ADELEMENT_PARSE_ERROR.getCode(), XAdErrorCode.ADELEMENT_PARSE_ERROR.getMessage());
            }
        }
    }

    public void handleRequestNoAd(String str, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048602, this, str, i2) == null) {
            HashMap hashMap = new HashMap();
            hashMap.put("error_message", str);
            hashMap.put("error_code", Integer.valueOf(i2));
            dispatchEvent(new XAdRemoteEvent("AdEmptyList", hashMap));
        }
    }

    public void init() {
        ProdAdRequestInfo prodAdRequestInfo;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048603, this) == null) || (prodAdRequestInfo = this.mAdRequestInfo) == null) {
            return;
        }
        JSONObject allAdParam = prodAdRequestInfo.getAllAdParam();
        this.mAllParamObj = allAdParam;
        if (allAdParam == null) {
            return;
        }
        this.mAppsid = allAdParam.optString("appid");
        AppConfigImp.getInstance().setAppsid(this.mAppsid);
        this.mAdProd = this.mAllParamObj.optString("prod");
        this.mAdPlaceId = this.mAllParamObj.optString("apid");
        this.mDisplayDownInfo = this.mAllParamObj.optString("Display_Down_Info");
        this.mTimeout = this.mAllParamObj.optInt("timeout", 10000);
        this.mCacheVideoOnlyWifi = this.mAllParamObj.optBoolean("cacheVideoOnlyWifi", false);
        this.isCacheVideo = this.mAllParamObj.optBoolean("isCacheVideo", true);
        this.mNeedCache = this.mAllParamObj.optBoolean("needCache", false);
        this.mOnlyLoadAd = this.mAllParamObj.optBoolean("onlyLoadAd", false);
        if ("rsplash".equals(this.mAdProd) || "banner".equals(this.mAdProd)) {
            initWebView();
        }
    }

    public boolean isPicture(IXAdInstanceInfo iXAdInstanceInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048604, this, iXAdInstanceInfo)) == null) ? "static_image".equals(iXAdInstanceInfo.getCreativeType().getValue()) || "gif".equals(iXAdInstanceInfo.getCreativeType().getValue()) : invokeL.booleanValue;
    }

    public boolean isSplashAd(IXAdInstanceInfo iXAdInstanceInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048605, this, iXAdInstanceInfo)) == null) ? "rsplash".equals(getAdProd()) && isVideo(iXAdInstanceInfo) : invokeL.booleanValue;
    }

    public boolean isVideo(IXAdInstanceInfo iXAdInstanceInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048606, this, iXAdInstanceInfo)) == null) {
            if (iXAdInstanceInfo == null) {
                return false;
            }
            return "video".equals(iXAdInstanceInfo.getCreativeType().getValue());
        }
        return invokeL.booleanValue;
    }

    public void preloadVideoMaterial(IXAdInstanceInfo iXAdInstanceInfo) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048607, this, iXAdInstanceInfo) == null) || iXAdInstanceInfo == null || !isFeedVideo(iXAdInstanceInfo) || this.isCacheVideo) {
            return;
        }
        cacheCreativeAsset(iXAdInstanceInfo);
    }

    public void recordImpression(View view, JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048608, this, view, jSONObject) == null) {
        }
    }

    public void requestAd() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048609, this) == null) {
            init();
            ProdAdRequestInfo prodAdRequestInfo = this.mAdRequestInfo;
            OAdURLConnection oAdURLConnection = new OAdURLConnection(1, prodAdRequestInfo != null ? prodAdRequestInfo.toFullURL() : "", "GET");
            this.oAdURLConnection = oAdURLConnection;
            oAdURLConnection.setConnectTimeout(this.mTimeout);
            this.oAdURLConnection.addAdRequestListener(new OAdURLConnection.OnAdRequestListener(this) { // from class: com.baidu.mobads.container.adrequest.XAbstractAdProdTemplate.2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ XAbstractAdProdTemplate this$0;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.this$0 = this;
                }

                @Override // com.baidu.mobads.container.components.net.OAdURLConnection.OnAdRequestListener
                public void onFail(String str, int i2) {
                    Interceptable interceptable2 = $ic;
                    if (!(interceptable2 == null || interceptable2.invokeLI(1048576, this, str, i2) == null) || this.this$0.mIsTimeout) {
                        return;
                    }
                    this.this$0.handleRequestAdServerFail(XAdErrorCode.AD_REQUEST_ERROR.getCode(), XAdErrorCode.AD_REQUEST_ERROR.getMessage());
                }

                @Override // com.baidu.mobads.container.components.net.OAdURLConnection.OnAdRequestListener
                public void onSuccess(String str, String str2) {
                    Interceptable interceptable2 = $ic;
                    if (!(interceptable2 == null || interceptable2.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, str2) == null) || this.this$0.mIsTimeout) {
                        return;
                    }
                    this.this$0.handleRequestAdServerSuccess(str, "");
                }
            });
            startTotalRequestTimer();
            this.oAdURLConnection.asynLoad();
        }
    }

    @Override // com.baidu.mobads.container.adrequest.XAdContainerContext
    public void setActivity(Activity activity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048610, this, activity) == null) {
            this.mActivity = activity;
            if (this.mCxt instanceof Activity) {
                this.mCxt = activity;
            }
            ProdAdRequestInfo prodAdRequestInfo = this.mAdRequestInfo;
            if (prodAdRequestInfo == null || !(prodAdRequestInfo.mCxt instanceof Activity)) {
                return;
            }
            prodAdRequestInfo.mCxt = activity;
        }
    }

    public void setAdResponseInfo(IXAdResponseInfo iXAdResponseInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048611, this, iXAdResponseInfo) == null) {
            this.mAdResponseInfo = iXAdResponseInfo;
        }
    }

    public void setAppsid(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048612, this, str) == null) {
            this.mAppsid = str;
        }
    }

    public void showAd() {
        XBaseAdContainer xBaseAdContainer;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048613, this) == null) || (xBaseAdContainer = this.mAdContainer) == null) {
            return;
        }
        xBaseAdContainer.load();
    }

    public void startTotalRequestTimer() {
        Runnable runnable;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048614, this) == null) || (runnable = this.mLoadAdTimeoutRunnable) == null) {
            return;
        }
        this.mLoadAdTimeoutHandler.postDelayed(runnable, this.mTimeout);
    }
}
