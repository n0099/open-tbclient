package com.baidu.tbadk.browser;

import android.text.TextUtils;
import android.webkit.JavascriptInterface;
import android.webkit.URLUtil;
import androidx.annotation.Keep;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.pyramid.runtime.service.ServiceManager;
import com.baidu.tbadk.browser.TbChannelJsInterface;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.switchs.WebViewTrackerEnableSwitch;
import com.baidu.tieba.gh;
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
    public static final int REPORT_FE_TYPE = 2;
    public static final int REPORT_NA_TYPE = 1;
    public transient /* synthetic */ FieldHolder $fh;
    public Runnable delayReportRunnable;
    public boolean isAlreadyReport;
    public long loadUrlStartTime;
    public final String mLogId;
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
        this.mLogId = UUID.randomUUID().toString();
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

    private void addDelayReportRunnable(final String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65537, this, str) == null) && !this.isAlreadyReport && this.delayReportRunnable == null) {
            this.delayReportRunnable = new Runnable() { // from class: com.baidu.tieba.iu4
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
            gh.a().postDelayed(this.delayReportRunnable, 10000L);
        }
    }

    public /* synthetic */ void a(String str) {
        tryReportDataToServer(str, 1);
    }

    @JavascriptInterface
    public void reportData(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
            tryReportDataToServer(str, 2);
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
            gh.a().removeCallbacks(this.delayReportRunnable);
            this.delayReportRunnable = null;
        }
    }

    private void tryReportDataToServer(String str, int i) {
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(InputDeviceCompat.SOURCE_TRACKBALL, this, str, i) == null) {
            removeDelayReportRunnable();
            if (this.switchOn && !this.isAlreadyReport && !TextUtils.isEmpty(str)) {
                this.isAlreadyReport = true;
                UBCManager uBCManager = (UBCManager) ServiceManager.getService(UBCManager.SERVICE_REFERENCE);
                if (uBCManager != null) {
                    uBCManager.onEvent("5607", str);
                }
                try {
                    JSONObject jSONObject = new JSONObject(str);
                    if (!TextUtils.equals(jSONObject.optString("logId", this.mLogId), this.mLogId)) {
                        return;
                    }
                    boolean optBoolean = jSONObject.optBoolean("isOfflinePackage", false);
                    try {
                        long optLong = jSONObject.optLong(u.x, -1L);
                        long optLong2 = jSONObject.optLong("wvst", -1L);
                        long optLong3 = jSONObject.optLong("wvft", -1L);
                        long optLong4 = jSONObject.optLong("lst", -1L);
                        long optLong5 = jSONObject.optLong("navigationStart", -1L);
                        long optLong6 = jSONObject.optLong("fetchStart", -1L);
                        long optLong7 = jSONObject.optLong("domainLookupStart", -1L);
                        long optLong8 = jSONObject.optLong("domainLookupEnd", -1L);
                        long optLong9 = jSONObject.optLong("connectStart", -1L);
                        long optLong10 = jSONObject.optLong("connectEnd", -1L);
                        long optLong11 = jSONObject.optLong("requestStart", -1L);
                        long optLong12 = jSONObject.optLong("responseStart", -1L);
                        long optLong13 = jSONObject.optLong("responseEnd", -1L);
                        long optLong14 = jSONObject.optLong("ds", -1L);
                        long optLong15 = jSONObject.optLong("df", -1L);
                        long optLong16 = jSONObject.optLong("drt", -1L);
                        long optLong17 = jSONObject.optLong("dt", -1L);
                        long optLong18 = jSONObject.optLong("autoFMP", -1L);
                        long optLong19 = jSONObject.optLong("autoFP", -1L);
                        long optLong20 = jSONObject.optLong("autoFCP", -1L);
                        int optInt = jSONObject.optInt("autoWVLCP", -1);
                        int optInt2 = jSONObject.optInt("autoWVFCP", -1);
                        long optLong21 = jSONObject.optLong("fp", -1L);
                        long optLong22 = jSONObject.optLong("fmp", -1L);
                        StatisticItem param = new StatisticItem(TbadkCoreStatisticKey.WEBVIEW_PERF_DATA_KEY).param("obj_param1", str).param(TiebaStatic.Params.OBJ_PARAM2, str);
                        if (optBoolean) {
                            str2 = "0";
                        } else {
                            str2 = "1";
                        }
                        try {
                            TiebaStatic.log(param.param("obj_id", str2).param("obj_type", i).param("obj_locate", 0).param("obj_source", 1).param(TiebaStatic.Params.OBJ_PARAM3, optLong22 - optLong).param(u.x, optLong).param("wvst", optLong2).param("wvft", optLong3).param("lst", optLong4).param("navigationStart", optLong5).param("fetchStart", optLong6).param("domainLookupStart", optLong7).param("domainLookupEnd", optLong8).param("connectStart", optLong9).param("connectEnd", optLong10).param("requestStart", optLong11).param("responseStart", optLong12).param("responseEnd", optLong13).param("ds", optLong14).param("df", optLong15).param("drt", optLong16).param("dt", optLong17).param("autoFMP", optLong18).param("autoFP", optLong19).param("autoFCP", optLong20).param("autoWVLCP", optInt).param("autoWVFCP", optInt2).param("fp", optLong21).param("fmp", optLong22).param("url", this.mUrl));
                        } catch (Exception unused) {
                        }
                    } catch (Exception unused2) {
                    }
                } catch (Exception unused3) {
                }
            }
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
                    jSONObject.put("logId", this.mLogId);
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
