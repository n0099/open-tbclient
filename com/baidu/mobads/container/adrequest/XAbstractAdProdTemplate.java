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
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class XAbstractAdProdTemplate extends XAdRemoteEventDispatcher implements XAdContainerContext {
    public static final String TAG = "XAbstractAdProdTemplate";
    public boolean isCacheVideo;
    public Activity mActivity;
    public XBaseAdContainer mAdContainer;
    public String mAdPlaceId;
    public ProdAdRequestInfo mAdRequestInfo;
    public IXAdResponseInfo mAdResponseInfo;
    public JSONObject mAllParamObj;
    public Context mAppContext;
    public String mAppsid;
    public boolean mCacheVideoOnlyWifi;
    public Context mCxt;
    public String mDisplayDownInfo;
    public Runnable mLoadAdTimeoutRunnable;
    public boolean mNeedCache;
    public boolean mOnlyLoadAd;
    public OAdURLConnection oAdURLConnection;
    public RemoteXAdLogger mAdLogger = RemoteXAdLogger.getInstance();
    public Handler mLoadAdTimeoutHandler = new Handler(Looper.getMainLooper());
    public CustomMaterialLoadingListener mMaterialLoadingListener = null;
    public int mTimeout = 10000;
    public IXAdInstanceInfo mCurrentAdInstance = null;
    public String mAdProd = "";
    public boolean mIsTimeout = false;

    /* loaded from: classes2.dex */
    public static class CustomMaterialLoadingListener implements MaterialLoadingListener {
        public final Context mAppContext;
        public final IXAdInstanceInfo mInstanceInfo;
        public final WeakReference<XAbstractAdProdTemplate> mProdTemplate;

        public CustomMaterialLoadingListener(XAbstractAdProdTemplate xAbstractAdProdTemplate, IXAdInstanceInfo iXAdInstanceInfo) {
            this.mProdTemplate = new WeakReference<>(xAbstractAdProdTemplate);
            this.mAppContext = xAbstractAdProdTemplate.mAppContext.getApplicationContext();
            this.mInstanceInfo = iXAdInstanceInfo;
        }

        @Override // com.baidu.mobads.container.util.filedownloader.MaterialLoadingListener
        public void onLoadingComplete(String str, View view, Bitmap bitmap) {
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

        @Override // com.baidu.mobads.container.util.filedownloader.MaterialLoadingListener
        public void onLoadingFailed(String str, View view, MaterialLoadErrorCode materialLoadErrorCode) {
            XAbstractAdProdTemplate xAbstractAdProdTemplate = this.mProdTemplate.get();
            if (xAbstractAdProdTemplate != null) {
                xAbstractAdProdTemplate.videoCacheFailed();
                if (xAbstractAdProdTemplate.needCreateContainerAfterEndOfCache(this.mInstanceInfo)) {
                    xAbstractAdProdTemplate.handleAllReady();
                }
            }
        }

        @Override // com.baidu.mobads.container.util.filedownloader.MaterialLoadingListener
        public void onLoadingStarted(String str, View view) {
        }

        public void release() {
            this.mProdTemplate.clear();
        }
    }

    public XAbstractAdProdTemplate(Context context, ProdAdRequestInfo prodAdRequestInfo) {
        this.mLoadAdTimeoutRunnable = null;
        this.mCxt = context;
        this.mAppContext = context.getApplicationContext();
        this.mAdRequestInfo = prodAdRequestInfo;
        this.mLoadAdTimeoutRunnable = new Runnable() { // from class: com.baidu.mobads.container.adrequest.XAbstractAdProdTemplate.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    XAbstractAdProdTemplate.this.mIsTimeout = true;
                    XAbstractAdProdTemplate.this.handleRequestAdServerFail(XAdErrorCode.REQUEST_TIMEOUT.getCode(), XAdErrorCode.REQUEST_TIMEOUT.getMessage());
                } catch (Exception e2) {
                    XAbstractAdProdTemplate.this.mAdLogger.d(e2);
                }
            }
        };
    }

    private boolean canDl(IXAdInstanceInfo iXAdInstanceInfo) {
        return isFeedVideo(iXAdInstanceInfo) || NetworkInfoUtils.isWifiConnected(this.mAppContext).booleanValue() || isPicture(iXAdInstanceInfo);
    }

    private void executeCacheVideo(ArrayList<IXAdInstanceInfo> arrayList) {
        if (arrayList == null || arrayList.size() <= 0) {
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
        ActivityUtils.runOnUiThread(new Runnable() { // from class: com.baidu.mobads.container.adrequest.XAbstractAdProdTemplate.4
            @Override // java.lang.Runnable
            public void run() {
                try {
                    XMyWebView.create(XAbstractAdProdTemplate.this.getActivity(), RemoteXAdLogger.getInstance(), true, true).loadDataWithBaseURL(null, "", SapiWebView.DATA_MIME_TYPE, "UTF-8", null);
                } catch (Exception unused) {
                }
            }
        });
    }

    private boolean isCachedVideoFile(IXAdInstanceInfo iXAdInstanceInfo) {
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

    private boolean isFeedVideo(IXAdInstanceInfo iXAdInstanceInfo) {
        if (iXAdInstanceInfo.getCreativeType().getValue().equals("video")) {
            return "feed".equals(getAdProd()) || "pvideo".equals(getAdProd());
        }
        return false;
    }

    private boolean isNeedCacheVideo(IXAdInstanceInfo iXAdInstanceInfo) {
        if (iXAdInstanceInfo.getCreativeType().getValue().equals("video")) {
            return "feed".equals(getAdProd()) || "pvideo".equals(getAdProd());
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean needCreateContainerAfterEndOfCache(IXAdInstanceInfo iXAdInstanceInfo) {
        return "rsplash".equals(getAdProd()) && isPicture(iXAdInstanceInfo);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void processDlResult(Message message, IXAdInstanceInfo iXAdInstanceInfo) {
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

    /* JADX INFO: Access modifiers changed from: private */
    public void videoCacheFailed() {
        dispatchEvent(new XAdRemoteEvent("vdieoCacheFailed"));
    }

    public void cacheCreativeAsset(IXAdInstanceInfo iXAdInstanceInfo) {
        this.mAdLogger.d(TAG, "cacheCreativeAsset");
        String urlForCache = getUrlForCache(iXAdInstanceInfo);
        if (TextUtils.isEmpty(urlForCache)) {
            return;
        }
        iXAdInstanceInfo.setLocalCreativeURL(null);
        this.mMaterialLoadingListener = new CustomMaterialLoadingListener(this, iXAdInstanceInfo);
        MaterialLoader.getInstance(this.mAppContext).cacheMaterialForURLString(urlForCache, this.mMaterialLoadingListener);
    }

    public void callbackAdFailed(int i2, String str) {
        HashMap hashMap = new HashMap();
        hashMap.put("error_message", str);
        hashMap.put("error_code", Integer.valueOf(i2));
        dispatchEvent(new XAdRemoteEvent("AdError", hashMap));
    }

    public void createAdContainer() {
        if ("rsplash".equals(getAdProd())) {
            if (this.mCurrentAdInstance.getCreativeType().getValue().equals("html")) {
                this.mAdContainer = new XSplashTemplateAdContainer(this);
            } else {
                this.mAdContainer = new SplashAdContainer(this, this.mCxt);
            }
        }
    }

    public void destroy() {
        CustomMaterialLoadingListener customMaterialLoadingListener = this.mMaterialLoadingListener;
        if (customMaterialLoadingListener != null) {
            customMaterialLoadingListener.release();
            this.mMaterialLoadingListener = null;
        }
    }

    public void disposeTotalRequestTimer() {
        Runnable runnable = this.mLoadAdTimeoutRunnable;
        if (runnable != null) {
            this.mLoadAdTimeoutHandler.removeCallbacks(runnable);
        }
        this.mLoadAdTimeoutRunnable = null;
    }

    @Override // com.baidu.mobads.container.adrequest.XAdContainerContext
    public Activity getActivity() {
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

    @Override // com.baidu.mobads.container.adrequest.XAdContainerContext
    public int getAdHeight() {
        return Integer.valueOf(this.mAllParamObj.optString("h", "0")).intValue();
    }

    @Override // com.baidu.mobads.container.adrequest.XAdContainerContext
    public IXAdInstanceInfo getAdInstanceInfo() {
        return this.mCurrentAdInstance;
    }

    @Override // com.baidu.mobads.container.adrequest.XAdContainerContext
    public String getAdPlacementId() {
        return this.mAdPlaceId;
    }

    @Override // com.baidu.mobads.container.adrequest.XAdContainerContext
    public String getAdProd() {
        return this.mAdProd;
    }

    @Override // com.baidu.mobads.container.adrequest.XAdContainerContext
    public RelativeLayout getAdProdBase() {
        View adView = getAdView();
        if (adView instanceof RelativeLayout) {
            return (RelativeLayout) adView;
        }
        return null;
    }

    @Override // com.baidu.mobads.container.adrequest.XAdContainerContext
    public JSONObject getAdReqParam() {
        return this.mAllParamObj;
    }

    @Override // com.baidu.mobads.container.adrequest.XAdContainerContext
    public IXAdResponseInfo getAdResponseInfo() {
        return this.mAdResponseInfo;
    }

    public View getAdView() {
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

    @Override // com.baidu.mobads.container.adrequest.XAdContainerContext
    public int getAdWidth() {
        return Integer.valueOf(this.mAllParamObj.optString("w", "0")).intValue();
    }

    @Override // com.baidu.mobads.container.adrequest.XAdContainerContext
    public Context getAppContext() {
        return this.mAppContext;
    }

    @Override // com.baidu.mobads.container.adrequest.XAdContainerContext
    public String getAppSec() {
        return this.mAppsid + "_cpr";
    }

    @Override // com.baidu.mobads.container.adrequest.XAdContainerContext
    public String getAppsid() {
        if (!TextUtils.isEmpty(this.mAppsid)) {
            return this.mAppsid;
        }
        return DeviceUtils.getInstance().getAppId(this.mAppContext);
    }

    @Override // com.baidu.mobads.container.adrequest.XAdContainerContext
    public XAdRemoteEventDispatcher getEventDispatcher() {
        return this;
    }

    public String getUrlForCache(IXAdInstanceInfo iXAdInstanceInfo) {
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

    public void handleAdClick(View view, JSONObject jSONObject) {
    }

    public void handleAdServerSuccess() {
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

    public void handleAllReady() {
        ActivityUtils.runOnUiThread(new Runnable() { // from class: com.baidu.mobads.container.adrequest.XAbstractAdProdTemplate.3
            @Override // java.lang.Runnable
            public void run() {
                XAdRemoteEvent xAdRemoteEvent;
                XAbstractAdProdTemplate.this.createAdContainer();
                XAbstractAdProdTemplate xAbstractAdProdTemplate = XAbstractAdProdTemplate.this;
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
                XAbstractAdProdTemplate.this.dispatchEvent(xAdRemoteEvent);
                if (XAbstractAdProdTemplate.this.mOnlyLoadAd) {
                    return;
                }
                XAbstractAdProdTemplate.this.mAdLogger.d(XAbstractAdProdTemplate.TAG, "handleAllReady");
                XAbstractAdProdTemplate.this.showAd();
            }
        });
    }

    public void handleEvent(JSONObject jSONObject, Map<String, Object> map) {
        XBaseAdContainer xBaseAdContainer = this.mAdContainer;
        if (xBaseAdContainer != null) {
            xBaseAdContainer.handleEvent(jSONObject, map);
        } else if (jSONObject == null || !"splash_focus_start_activity".equals(jSONObject.optString("event_type"))) {
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

    public void handleRequestAdServerFail(int i2, String str) {
        disposeTotalRequestTimer();
        callbackAdFailed(i2, str);
    }

    public void handleRequestAdServerSuccess(String str, String str2) {
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

    public void handleRequestNoAd(String str, int i2) {
        HashMap hashMap = new HashMap();
        hashMap.put("error_message", str);
        hashMap.put("error_code", Integer.valueOf(i2));
        dispatchEvent(new XAdRemoteEvent("AdEmptyList", hashMap));
    }

    public void init() {
        ProdAdRequestInfo prodAdRequestInfo = this.mAdRequestInfo;
        if (prodAdRequestInfo == null) {
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
        return "static_image".equals(iXAdInstanceInfo.getCreativeType().getValue()) || "gif".equals(iXAdInstanceInfo.getCreativeType().getValue());
    }

    public boolean isSplashAd(IXAdInstanceInfo iXAdInstanceInfo) {
        return "rsplash".equals(getAdProd()) && isVideo(iXAdInstanceInfo);
    }

    public boolean isVideo(IXAdInstanceInfo iXAdInstanceInfo) {
        if (iXAdInstanceInfo == null) {
            return false;
        }
        return "video".equals(iXAdInstanceInfo.getCreativeType().getValue());
    }

    public void preloadVideoMaterial(IXAdInstanceInfo iXAdInstanceInfo) {
        if (iXAdInstanceInfo == null || !isFeedVideo(iXAdInstanceInfo) || this.isCacheVideo) {
            return;
        }
        cacheCreativeAsset(iXAdInstanceInfo);
    }

    public void recordImpression(View view, JSONObject jSONObject) {
    }

    public void requestAd() {
        init();
        ProdAdRequestInfo prodAdRequestInfo = this.mAdRequestInfo;
        OAdURLConnection oAdURLConnection = new OAdURLConnection(1, prodAdRequestInfo != null ? prodAdRequestInfo.toFullURL() : "", "GET");
        this.oAdURLConnection = oAdURLConnection;
        oAdURLConnection.setConnectTimeout(this.mTimeout);
        this.oAdURLConnection.addAdRequestListener(new OAdURLConnection.OnAdRequestListener() { // from class: com.baidu.mobads.container.adrequest.XAbstractAdProdTemplate.2
            @Override // com.baidu.mobads.container.components.net.OAdURLConnection.OnAdRequestListener
            public void onFail(String str, int i2) {
                if (XAbstractAdProdTemplate.this.mIsTimeout) {
                    return;
                }
                XAbstractAdProdTemplate.this.handleRequestAdServerFail(XAdErrorCode.AD_REQUEST_ERROR.getCode(), XAdErrorCode.AD_REQUEST_ERROR.getMessage());
            }

            @Override // com.baidu.mobads.container.components.net.OAdURLConnection.OnAdRequestListener
            public void onSuccess(String str, String str2) {
                if (XAbstractAdProdTemplate.this.mIsTimeout) {
                    return;
                }
                XAbstractAdProdTemplate.this.handleRequestAdServerSuccess(str, "");
            }
        });
        startTotalRequestTimer();
        this.oAdURLConnection.asynLoad();
    }

    @Override // com.baidu.mobads.container.adrequest.XAdContainerContext
    public void setActivity(Activity activity) {
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

    public void setAdResponseInfo(IXAdResponseInfo iXAdResponseInfo) {
        this.mAdResponseInfo = iXAdResponseInfo;
    }

    public void setAppsid(String str) {
        this.mAppsid = str;
    }

    public void showAd() {
        XBaseAdContainer xBaseAdContainer = this.mAdContainer;
        if (xBaseAdContainer != null) {
            xBaseAdContainer.load();
        }
    }

    public void startTotalRequestTimer() {
        Runnable runnable = this.mLoadAdTimeoutRunnable;
        if (runnable != null) {
            this.mLoadAdTimeoutHandler.postDelayed(runnable, this.mTimeout);
        }
    }
}
