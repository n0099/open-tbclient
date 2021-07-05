package com.baidu.mobads.sdk.internal;

import android.content.Context;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.View;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.sdk.api.IAdInterListener;
import com.baidu.mobads.sdk.api.IOAdEvent;
import com.baidu.mobads.sdk.api.IOAdEventListener;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public abstract class XAbstractAdProdTemplate {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String ERROR_CODE = "error_code";
    public static final String ERROR_MESSAGE = "error_message";
    public static final String TAG = "XAbstractProdTemplate";
    public transient /* synthetic */ FieldHolder $fh;
    public String mAdDataObj;
    public IAdInterListener mAdInterlistener;
    public XAdLogger mAdLogger;
    public String mAppsid;
    public Context mContext;
    public HashMap<String, String> mCustomRequestParameters;
    public IOAdEventListener mEventListener;
    public boolean mExecuteRequest;

    /* loaded from: classes3.dex */
    public class CustomAdEventListener implements IOAdEventListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ XAbstractAdProdTemplate this$0;

        public CustomAdEventListener(XAbstractAdProdTemplate xAbstractAdProdTemplate) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {xAbstractAdProdTemplate};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = xAbstractAdProdTemplate;
        }

        private String getMessage(IOAdEvent iOAdEvent) {
            InterceptResult invokeL;
            Map<String, Object> data;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65537, this, iOAdEvent)) == null) {
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
            return (String) invokeL.objValue;
        }

        @Override // com.baidu.mobads.sdk.api.IOAdEventListener
        public void run(IOAdEvent iOAdEvent) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, iOAdEvent) == null) {
                XAbstractAdProdTemplate.runOnUiThread(new Runnable(this, iOAdEvent) { // from class: com.baidu.mobads.sdk.internal.XAbstractAdProdTemplate.CustomAdEventListener.1
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ CustomAdEventListener this$1;
                    public final /* synthetic */ IOAdEvent val$evt;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this, iOAdEvent};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i2 = newInitContext.flag;
                            if ((i2 & 1) != 0) {
                                int i3 = i2 & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.this$1 = this;
                        this.val$evt = iOAdEvent;
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                            if ("AdLoaded".equals(this.val$evt.getType())) {
                                this.this$1.this$0.onADLoaded(this.val$evt);
                            } else if ("AdStarted".equals(this.val$evt.getType())) {
                                this.this$1.this$0.mAdDataObj = this.val$evt.getMessage();
                                this.this$1.this$0.onAdPresent();
                            } else if ("AdImpression".equals(this.val$evt.getType())) {
                                this.this$1.this$0.onADExposed(this.val$evt.getMessage());
                            } else if ("AdStopped".equals(this.val$evt.getType())) {
                                this.this$1.this$0.onAdClose(this.val$evt);
                            } else {
                                String str = "";
                                int i2 = 0;
                                int i3 = 0;
                                if ("AdError".equals(this.val$evt.getType())) {
                                    HashMap hashMap = (HashMap) this.val$evt.getData();
                                    if (hashMap != null) {
                                        str = (String) hashMap.get("error_message");
                                        Object obj = hashMap.get("error_code");
                                        Integer num = obj;
                                        if (obj == null) {
                                            num = 0;
                                        }
                                        i2 = ((Integer) num).intValue();
                                    }
                                    this.this$1.this$0.onAdFailed(str, i2);
                                } else if ("AdEmptyList".equals(this.val$evt.getType())) {
                                    HashMap hashMap2 = (HashMap) this.val$evt.getData();
                                    if (hashMap2 != null) {
                                        str = (String) hashMap2.get("error_message");
                                        Object obj2 = hashMap2.get("error_code");
                                        Integer num2 = obj2;
                                        if (obj2 == null) {
                                            num2 = 0;
                                        }
                                        i3 = ((Integer) num2).intValue();
                                    }
                                    this.this$1.this$0.onNoAd(i3, str);
                                } else if ("AdUserClick".equals(this.val$evt.getType())) {
                                    this.this$1.this$0.onAdClick(this.val$evt.getMessage());
                                } else if ("AdLpClosed".equals(this.val$evt.getType())) {
                                    this.this$1.this$0.onLpClosed();
                                } else if ("playCompletion".equals(this.val$evt.getType())) {
                                    this.this$1.this$0.onVideoPlayCompletion();
                                } else if ("vdieoCacheSucc".equals(this.val$evt.getType())) {
                                    this.this$1.this$0.onVideoCacheSucc();
                                } else if ("vdieoCacheFailed".equals(this.val$evt.getType())) {
                                    this.this$1.this$0.onVideoCacheFail();
                                } else if ("AdStatusChange".equals(this.val$evt.getType())) {
                                    this.this$1.this$0.onADStatusChanged(this.val$evt);
                                } else if (ISecurityInfo.AD_PERMISSION_CLICK.equals(this.val$evt.getType())) {
                                    this.this$1.this$0.onADPermissionShow(this.val$evt.getMessage(), 1 == this.val$evt.getCode());
                                } else if (ISecurityInfo.AD_PRIVACY_CLICK.equals(this.val$evt.getType())) {
                                    this.this$1.this$0.onADPrivacyClick(this.val$evt.getMessage());
                                } else if (ISecurityInfo.UNION_LOGO_CLICK.equals(this.val$evt.getType())) {
                                    this.this$1.this$0.onAdUnionClick(this.val$evt.getMessage());
                                } else if ("AdSkipped".equals(this.val$evt.getType())) {
                                    this.this$1.this$0.onAdSkipped(this.val$evt.getMessage());
                                } else if ("AdFinishActivity".equals(this.val$evt.getType())) {
                                    this.this$1.this$0.onFinishActivity();
                                } else if (ISecurityInfo.AD_DOWNLOAD_WINDOW.equals(this.val$evt.getType())) {
                                    this.this$1.this$0.onAdDownloadWindowShow(this.val$evt.getMessage(), 1 == this.val$evt.getCode());
                                }
                            }
                        }
                    }
                });
            }
        }
    }

    public XAbstractAdProdTemplate(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mAdLogger = XAdLogger.getInstance();
        this.mAdInterlistener = null;
        this.mExecuteRequest = true;
        this.mContext = context;
        this.mEventListener = new CustomAdEventListener(this);
        RemoteDexLoader.getInstance().initRemoteDex(this.mContext);
        onRemoteLoadedSuccssfully();
    }

    private String buildCommandUri(String str, JSONObject jSONObject) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, this, str, jSONObject)) == null) {
            return "bdsdk://" + str + "?jsonObj=" + Uri.encode(jSONObject.toString());
        }
        return (String) invokeLL.objValue;
    }

    public static void runOnUiThread(Runnable runnable) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65538, null, runnable) == null) || runnable == null) {
            return;
        }
        try {
            if (Looper.myLooper() == Looper.getMainLooper()) {
                runnable.run();
            } else {
                new Handler(Looper.getMainLooper()).post(new Runnable(runnable) { // from class: com.baidu.mobads.sdk.internal.XAbstractAdProdTemplate.1
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ Runnable val$runnable;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {runnable};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i2 = newInitContext.flag;
                            if ((i2 & 1) != 0) {
                                int i3 = i2 & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.val$runnable = runnable;
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                            this.val$runnable.run();
                        }
                    }
                });
            }
        } catch (Exception unused) {
        }
    }

    public void destroy() {
        IAdInterListener iAdInterListener;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (iAdInterListener = this.mAdInterlistener) == null) {
            return;
        }
        iAdInterListener.destroyAd();
    }

    public View getAdView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            IAdInterListener iAdInterListener = this.mAdInterlistener;
            if (iAdInterListener != null) {
                return iAdInterListener.getAdContainerView();
            }
            return null;
        }
        return (View) invokeV.objValue;
    }

    public void handleClick(View view, JSONObject jSONObject) {
        IAdInterListener iAdInterListener;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, view, jSONObject) == null) || (iAdInterListener = this.mAdInterlistener) == null) {
            return;
        }
        iAdInterListener.onAdTaskProcess(view, buildCommandUri(IAdInterListener.AdCommandType.AD_CLICK, jSONObject));
    }

    public void handleEvent(JSONObject jSONObject) {
        IAdInterListener iAdInterListener;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, jSONObject) == null) || (iAdInterListener = this.mAdInterlistener) == null) {
            return;
        }
        iAdInterListener.onAdTaskProcess(buildCommandUri(IAdInterListener.AdCommandType.HANDLE_EVENT, jSONObject));
    }

    public JSONObject hashMap2Json(HashMap<String, String> hashMap) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, hashMap)) == null) {
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
        return (JSONObject) invokeL.objValue;
    }

    public void onADExposed(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, str) == null) {
        }
    }

    public void onADLoaded(IOAdEvent iOAdEvent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, iOAdEvent) == null) {
        }
    }

    public void onADPermissionShow(String str, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, str, z) == null) {
        }
    }

    public void onADPrivacyClick(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, str) == null) {
        }
    }

    public void onADStatusChanged(IOAdEvent iOAdEvent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, iOAdEvent) == null) {
        }
    }

    public void onAdClick(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, str) == null) {
        }
    }

    public void onAdClose(IOAdEvent iOAdEvent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, iOAdEvent) == null) {
            removeAdAllListeners();
        }
    }

    public void onAdDownloadWindowShow(String str, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048589, this, str, z) == null) {
        }
    }

    public void onAdFailed(String str, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048590, this, str, i2) == null) {
            removeAdAllListeners();
        }
    }

    public void onAdPresent() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
        }
    }

    public void onAdSkipped(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, str) == null) {
        }
    }

    public void onAdUnionClick(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, str) == null) {
        }
    }

    public void onFinishActivity() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
        }
    }

    public void onLpClosed() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048595, this) == null) {
        }
    }

    public void onNoAd(int i2, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048596, this, i2, str) == null) {
            removeAdAllListeners();
        }
    }

    public void onRemoteLoadedFailed() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048597, this) == null) {
            onAdFailed("", 1);
        }
    }

    public void onRemoteLoadedSuccssfully() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048598, this) == null) {
            this.mAdInterlistener = (IAdInterListener) ReflectionUtils.getNewInstance(ISecurityInfo.PROD_REQUEST_INFO, getClass().getClassLoader(), new Class[]{Context.class}, this.mContext);
            if (this.mExecuteRequest) {
                return;
            }
            startAdRequest();
        }
    }

    public void onVideoCacheFail() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048599, this) == null) {
        }
    }

    public void onVideoCacheSucc() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048600, this) == null) {
        }
    }

    public void onVideoPlayCompletion() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048601, this) == null) {
        }
    }

    public void recordImpression(View view, JSONObject jSONObject) {
        IAdInterListener iAdInterListener;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048602, this, view, jSONObject) == null) || (iAdInterListener = this.mAdInterlistener) == null) {
            return;
        }
        iAdInterListener.onAdTaskProcess(view, buildCommandUri(IAdInterListener.AdCommandType.AD_IMPRESSION, jSONObject));
    }

    public void registerAdListener() {
        IAdInterListener iAdInterListener;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048603, this) == null) || (iAdInterListener = this.mAdInterlistener) == null) {
            return;
        }
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

    public void removeAdAllListeners() {
        IAdInterListener iAdInterListener;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048604, this) == null) || (iAdInterListener = this.mAdInterlistener) == null) {
            return;
        }
        iAdInterListener.removeAllListeners();
    }

    public void setAppsid(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048605, this, str) == null) {
            this.mAppsid = str;
        }
    }

    public void setCustomParameters(Map<String, String> map) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048606, this, map) == null) {
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
    }

    public abstract void startAdRequest();

    public void handleEvent(JSONObject jSONObject, Map<String, Object> map) {
        IAdInterListener iAdInterListener;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048580, this, jSONObject, map) == null) || (iAdInterListener = this.mAdInterlistener) == null) {
            return;
        }
        iAdInterListener.onAdTaskProcess(buildCommandUri(IAdInterListener.AdCommandType.HANDLE_EVENT, jSONObject), map);
    }
}
