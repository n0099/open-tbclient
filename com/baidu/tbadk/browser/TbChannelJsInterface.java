package com.baidu.tbadk.browser;

import android.text.TextUtils;
import android.webkit.JavascriptInterface;
import android.webkit.URLUtil;
import androidx.annotation.Keep;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.pyramid.runtime.service.ServiceManager;
import com.baidu.tbadk.browser.TbChannelJsInterface;
import com.baidu.tbadk.switchs.WebViewTrackerEnableSwitch;
import com.baidu.tieba.ah;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.ubc.UBCManager;
import com.kuaishou.weapon.p0.u;
import java.util.UUID;
import org.json.JSONObject;
@Keep
/* loaded from: classes3.dex */
public final class TbChannelJsInterface {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int DELAY_MILLIS = 10000;
    public transient /* synthetic */ FieldHolder $fh;
    public Runnable delayReportRunnable;
    public boolean isAlreadyReport;
    public long loadUrlStartTime;
    public final String logId;
    public String mUrl;
    public final long operationStartTime;
    public final boolean switchOn;
    public long webViewInitFinishTime;
    public long webViewInitStartTime;

    public TbChannelJsInterface(long j) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Long.valueOf(j)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.isAlreadyReport = false;
        this.switchOn = WebViewTrackerEnableSwitch.isOn();
        this.logId = UUID.randomUUID().toString();
        this.operationStartTime = j;
    }

    private boolean isValidUrl(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, this, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            if (!URLUtil.isAssetUrl(str) && !URLUtil.isFileUrl(str)) {
                if (!URLUtil.isHttpUrl(str) && !URLUtil.isHttpsUrl(str)) {
                    return false;
                }
                return str.contains("tieba.baidu.com");
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @JavascriptInterface
    /* renamed from: reportData */
    public void a(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) && this.switchOn) {
            removeDelayReportRunnable();
            if (!this.isAlreadyReport && !TextUtils.isEmpty(str)) {
                UBCManager uBCManager = (UBCManager) ServiceManager.getService(UBCManager.SERVICE_REFERENCE);
                if (!this.isAlreadyReport && uBCManager != null) {
                    this.isAlreadyReport = true;
                    uBCManager.onEvent("5607", str);
                }
            }
        }
    }

    private void addDelayReportRunnable(final String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65537, this, str) == null) && !this.isAlreadyReport && this.delayReportRunnable == null) {
            this.delayReportRunnable = new Runnable() { // from class: com.baidu.tieba.rp4
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // java.lang.Runnable
                public final void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        TbChannelJsInterface.this.a(str);
                    }
                }
            };
            ah.a().postDelayed(this.delayReportRunnable, 10000L);
        }
    }

    public void setWebViewInitFinishTime(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048579, this, j) == null) {
            this.webViewInitFinishTime = Math.max(j, this.operationStartTime);
        }
    }

    public void setWebViewInitStartTime(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048580, this, j) == null) {
            this.webViewInitStartTime = Math.max(j, this.operationStartTime);
        }
    }

    public void startLoadUrl(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048581, this, str) == null) && this.loadUrlStartTime <= 0 && isValidUrl(str)) {
            this.loadUrlStartTime = System.currentTimeMillis();
            this.mUrl = str;
        }
    }

    private void removeDelayReportRunnable() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65539, this) == null) && this.delayReportRunnable != null) {
            ah.a().removeCallbacks(this.delayReportRunnable);
            this.delayReportRunnable = null;
        }
    }

    @JavascriptInterface
    public String getInitData() {
        boolean z;
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            try {
                if (this.switchOn && !this.isAlreadyReport && isValidUrl(this.mUrl)) {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("logId", this.logId);
                    jSONObject.put("url", this.mUrl);
                    jSONObject.put("clientType", "Android");
                    if (!URLUtil.isNetworkUrl(this.mUrl)) {
                        z = true;
                    } else {
                        z = false;
                    }
                    jSONObject.put("isOfflinePackage", z);
                    jSONObject.put(u.x, this.operationStartTime);
                    jSONObject.put("wvst", this.webViewInitStartTime);
                    jSONObject.put("wvft", this.webViewInitFinishTime);
                    jSONObject.put("lst", this.loadUrlStartTime);
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put("perfData", jSONObject);
                    String jSONObject3 = jSONObject2.toString();
                    addDelayReportRunnable(jSONObject.toString());
                    return jSONObject3;
                }
                return "";
            } catch (Exception unused) {
                return "";
            }
        }
        return (String) invokeV.objValue;
    }
}
