package com.baidu.mobads.sdk.internal;

import android.content.Context;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.View;
import com.baidu.mobads.sdk.api.IAdInterListener;
import com.baidu.mobads.sdk.api.IOAdEvent;
import com.baidu.mobads.sdk.api.IOAdEventListener;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public abstract class XAbstractAdProdTemplate {
    public static final String ERROR_CODE = "error_code";
    public static final String ERROR_MESSAGE = "error_message";
    public static final String TAG = "XAbstractProdTemplate";
    public String mAdDataObj;
    public String mAppsid;
    public Context mContext;
    public HashMap<String, String> mCustomRequestParameters;
    public XAdLogger mAdLogger = XAdLogger.getInstance();
    public IAdInterListener mAdInterlistener = null;
    public boolean mExecuteRequest = true;
    public IOAdEventListener mEventListener = new CustomAdEventListener();

    /* loaded from: classes2.dex */
    public class CustomAdEventListener implements IOAdEventListener {
        public CustomAdEventListener() {
        }

        private String getMessage(IOAdEvent iOAdEvent) {
            Map<String, Object> data;
            if (iOAdEvent != null) {
                String message = iOAdEvent.getMessage();
                if (!TextUtils.isEmpty(message) || (data = iOAdEvent.getData()) == null) {
                    return message;
                }
                Object obj = data.get("msg");
                return obj instanceof String ? (String) obj : message;
            }
            return null;
        }

        @Override // com.baidu.mobads.sdk.api.IOAdEventListener
        public void run(final IOAdEvent iOAdEvent) {
            XAbstractAdProdTemplate.runOnUiThread(new Runnable() { // from class: com.baidu.mobads.sdk.internal.XAbstractAdProdTemplate.CustomAdEventListener.1
                @Override // java.lang.Runnable
                public void run() {
                    if ("AdLoaded".equals(iOAdEvent.getType())) {
                        XAbstractAdProdTemplate.this.onADLoaded(iOAdEvent);
                    } else if ("AdStarted".equals(iOAdEvent.getType())) {
                        XAbstractAdProdTemplate.this.mAdDataObj = iOAdEvent.getMessage();
                        XAbstractAdProdTemplate.this.onAdPresent();
                    } else if ("AdImpression".equals(iOAdEvent.getType())) {
                        XAbstractAdProdTemplate.this.onADExposed(iOAdEvent.getMessage());
                    } else if ("AdStopped".equals(iOAdEvent.getType())) {
                        XAbstractAdProdTemplate.this.onAdClose(iOAdEvent);
                    } else {
                        String str = "";
                        int i = 0;
                        int i2 = 0;
                        if ("AdError".equals(iOAdEvent.getType())) {
                            HashMap hashMap = (HashMap) iOAdEvent.getData();
                            if (hashMap != null) {
                                str = (String) hashMap.get("error_message");
                                Object obj = hashMap.get("error_code");
                                Integer num = obj;
                                if (obj == null) {
                                    num = 0;
                                }
                                i = ((Integer) num).intValue();
                            }
                            XAbstractAdProdTemplate.this.onAdFailed(str, i);
                        } else if ("AdEmptyList".equals(iOAdEvent.getType())) {
                            HashMap hashMap2 = (HashMap) iOAdEvent.getData();
                            if (hashMap2 != null) {
                                str = (String) hashMap2.get("error_message");
                                Object obj2 = hashMap2.get("error_code");
                                Integer num2 = obj2;
                                if (obj2 == null) {
                                    num2 = 0;
                                }
                                i2 = ((Integer) num2).intValue();
                            }
                            XAbstractAdProdTemplate.this.onNoAd(i2, str);
                        } else if ("AdUserClick".equals(iOAdEvent.getType())) {
                            XAbstractAdProdTemplate.this.onAdClick(iOAdEvent.getMessage());
                        } else if ("AdLpClosed".equals(iOAdEvent.getType())) {
                            XAbstractAdProdTemplate.this.onLpClosed();
                        } else if ("playCompletion".equals(iOAdEvent.getType())) {
                            XAbstractAdProdTemplate.this.onVideoPlayCompletion();
                        } else if ("vdieoCacheSucc".equals(iOAdEvent.getType())) {
                            XAbstractAdProdTemplate.this.onVideoCacheSucc();
                        } else if ("vdieoCacheFailed".equals(iOAdEvent.getType())) {
                            XAbstractAdProdTemplate.this.onVideoCacheFail();
                        } else if ("AdStatusChange".equals(iOAdEvent.getType())) {
                            XAbstractAdProdTemplate.this.onADStatusChanged(iOAdEvent);
                        } else if (ISecurityInfo.AD_PERMISSION_CLICK.equals(iOAdEvent.getType())) {
                            XAbstractAdProdTemplate.this.onADPermissionShow(iOAdEvent.getMessage(), 1 == iOAdEvent.getCode());
                        } else if (ISecurityInfo.AD_PRIVACY_CLICK.equals(iOAdEvent.getType())) {
                            XAbstractAdProdTemplate.this.onADPrivacyClick(iOAdEvent.getMessage());
                        } else if (ISecurityInfo.UNION_LOGO_CLICK.equals(iOAdEvent.getType())) {
                            XAbstractAdProdTemplate.this.onAdUnionClick(iOAdEvent.getMessage());
                        } else if ("AdSkipped".equals(iOAdEvent.getType())) {
                            XAbstractAdProdTemplate.this.onAdSkipped(iOAdEvent.getMessage());
                        } else if ("AdFinishActivity".equals(iOAdEvent.getType())) {
                            XAbstractAdProdTemplate.this.onFinishActivity();
                        } else if (ISecurityInfo.AD_DOWNLOAD_WINDOW.equals(iOAdEvent.getType())) {
                            XAbstractAdProdTemplate.this.onAdDownloadWindowShow(iOAdEvent.getMessage(), 1 == iOAdEvent.getCode());
                        }
                    }
                }
            });
        }
    }

    public XAbstractAdProdTemplate(Context context) {
        this.mContext = context;
        RemoteDexLoader.getInstance().initRemoteDex(this.mContext);
        onRemoteLoadedSuccssfully();
    }

    private String buildCommandUri(String str, JSONObject jSONObject) {
        return "bdsdk://" + str + "?jsonObj=" + Uri.encode(jSONObject.toString());
    }

    public static void runOnUiThread(final Runnable runnable) {
        if (runnable == null) {
            return;
        }
        try {
            if (Looper.myLooper() == Looper.getMainLooper()) {
                runnable.run();
            } else {
                new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.baidu.mobads.sdk.internal.XAbstractAdProdTemplate.1
                    @Override // java.lang.Runnable
                    public void run() {
                        runnable.run();
                    }
                });
            }
        } catch (Exception unused) {
        }
    }

    public void destroy() {
        IAdInterListener iAdInterListener = this.mAdInterlistener;
        if (iAdInterListener != null) {
            iAdInterListener.destroyAd();
        }
    }

    public View getAdView() {
        IAdInterListener iAdInterListener = this.mAdInterlistener;
        if (iAdInterListener != null) {
            return iAdInterListener.getAdContainerView();
        }
        return null;
    }

    public void handleClick(View view, JSONObject jSONObject) {
        IAdInterListener iAdInterListener = this.mAdInterlistener;
        if (iAdInterListener != null) {
            iAdInterListener.onAdTaskProcess(view, buildCommandUri(IAdInterListener.AdCommandType.AD_CLICK, jSONObject));
        }
    }

    public void handleEvent(JSONObject jSONObject) {
        IAdInterListener iAdInterListener = this.mAdInterlistener;
        if (iAdInterListener != null) {
            iAdInterListener.onAdTaskProcess(buildCommandUri(IAdInterListener.AdCommandType.HANDLE_EVENT, jSONObject));
        }
    }

    public JSONObject hashMap2Json(HashMap<String, String> hashMap) {
        if (hashMap != null) {
            if (!hashMap.isEmpty()) {
                try {
                } catch (Exception unused) {
                    return null;
                }
            }
            return new JSONObject(hashMap);
        }
        return null;
    }

    public void onADExposed(String str) {
    }

    public void onADLoaded(IOAdEvent iOAdEvent) {
    }

    public void onADPermissionShow(String str, boolean z) {
    }

    public void onADPrivacyClick(String str) {
    }

    public void onADStatusChanged(IOAdEvent iOAdEvent) {
    }

    public void onAdClick(String str) {
    }

    public void onAdClose(IOAdEvent iOAdEvent) {
        removeAdAllListeners();
    }

    public void onAdDownloadWindowShow(String str, boolean z) {
    }

    public void onAdFailed(String str, int i) {
        removeAdAllListeners();
    }

    public void onAdPresent() {
    }

    public void onAdSkipped(String str) {
    }

    public void onAdUnionClick(String str) {
    }

    public void onFinishActivity() {
    }

    public void onLpClosed() {
    }

    public void onNoAd(int i, String str) {
        removeAdAllListeners();
    }

    public void onRemoteLoadedFailed() {
        onAdFailed("", 1);
    }

    public void onRemoteLoadedSuccssfully() {
        this.mAdInterlistener = (IAdInterListener) ReflectionUtils.getNewInstance(ISecurityInfo.PROD_REQUEST_INFO, getClass().getClassLoader(), new Class[]{Context.class}, this.mContext);
        if (this.mExecuteRequest) {
            return;
        }
        startAdRequest();
    }

    public void onVideoCacheFail() {
    }

    public void onVideoCacheSucc() {
    }

    public void onVideoPlayCompletion() {
    }

    public void recordImpression(View view, JSONObject jSONObject) {
        IAdInterListener iAdInterListener = this.mAdInterlistener;
        if (iAdInterListener != null) {
            iAdInterListener.onAdTaskProcess(view, buildCommandUri(IAdInterListener.AdCommandType.AD_IMPRESSION, jSONObject));
        }
    }

    public void registerAdListener() {
        IAdInterListener iAdInterListener = this.mAdInterlistener;
        if (iAdInterListener != null) {
            iAdInterListener.addEventListener("AdUserClick", this.mEventListener);
            this.mAdInterlistener.addEventListener("AdLoaded", this.mEventListener);
            this.mAdInterlistener.addEventListener("AdEmptyList", this.mEventListener);
            this.mAdInterlistener.addEventListener("AdStarted", this.mEventListener);
            this.mAdInterlistener.addEventListener("AdStopped", this.mEventListener);
            this.mAdInterlistener.addEventListener("AdError", this.mEventListener);
            this.mAdInterlistener.addEventListener("AdLpClosed", this.mEventListener);
            this.mAdInterlistener.addEventListener(ISecurityInfo.AD_START_LP, this.mEventListener);
            this.mAdInterlistener.addEventListener("AdImpression", this.mEventListener);
            this.mAdInterlistener.addEventListener("AdStatusChange", this.mEventListener);
            this.mAdInterlistener.addEventListener("AdSkipped", this.mEventListener);
            this.mAdInterlistener.addEventListener("vdieoCacheSucc", this.mEventListener);
            this.mAdInterlistener.addEventListener("vdieoCacheFailed", this.mEventListener);
            this.mAdInterlistener.addEventListener("playCompletion", this.mEventListener);
            this.mAdInterlistener.addEventListener(ISecurityInfo.AD_RVIDEO_PLAY_ERROR, this.mEventListener);
            this.mAdInterlistener.addEventListener(ISecurityInfo.AD_PERMISSION_CLICK, this.mEventListener);
            this.mAdInterlistener.addEventListener(ISecurityInfo.AD_PRIVACY_CLICK, this.mEventListener);
            this.mAdInterlistener.addEventListener(ISecurityInfo.UNION_LOGO_CLICK, this.mEventListener);
            this.mAdInterlistener.addEventListener(ISecurityInfo.AD_DOWNLOAD_WINDOW, this.mEventListener);
        }
    }

    public void removeAdAllListeners() {
        IAdInterListener iAdInterListener = this.mAdInterlistener;
        if (iAdInterListener != null) {
            iAdInterListener.removeAllListeners();
        }
    }

    public void setAppsid(String str) {
        this.mAppsid = str;
    }

    public void setCustomParameters(Map<String, String> map) {
        HashMap<String, String> hashMap = this.mCustomRequestParameters;
        if (hashMap == null) {
            this.mCustomRequestParameters = new HashMap<>();
        } else {
            hashMap.clear();
        }
        if (map == null || map.isEmpty()) {
            return;
        }
        for (Map.Entry<String, String> entry : map.entrySet()) {
            try {
                this.mCustomRequestParameters.put(entry.getKey().trim(), entry.getValue().trim());
            } catch (Throwable unused) {
            }
        }
    }

    public abstract void startAdRequest();

    public void handleEvent(JSONObject jSONObject, Map<String, Object> map) {
        IAdInterListener iAdInterListener = this.mAdInterlistener;
        if (iAdInterListener != null) {
            iAdInterListener.onAdTaskProcess(buildCommandUri(IAdInterListener.AdCommandType.HANDLE_EVENT, jSONObject), map);
        }
    }
}
