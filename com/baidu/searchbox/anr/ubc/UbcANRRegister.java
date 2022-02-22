package com.baidu.searchbox.anr.ubc;

import android.content.Context;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.pyramid.annotation.Service;
import com.baidu.pyramid.runtime.service.ServiceManager;
import com.baidu.searchbox.anr.impl.ANRInfo;
import com.baidu.searchbox.anr.ioc.IANRRegister;
import com.baidu.searchbox.aperf.param.CommonUtils;
import com.baidu.searchbox.config.AppConfig;
import com.baidu.searchbox.config.QuickPersistConfig;
import com.baidu.searchbox.ruka.Ruka;
import com.baidu.searchbox.ruka.basic.RukaTrackUIUtil;
import com.baidu.searchbox.ruka.ioc.Constant;
import com.baidu.searchbox.track.ui.TrackUI;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.ubc.UBCManager;
import java.util.LinkedList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
@Service
/* loaded from: classes11.dex */
public class UbcANRRegister implements IANRRegister {
    public static /* synthetic */ Interceptable $ic = null;
    public static String KEY_ANR_ACTIVE_UPLOAD = "key_anr_active_upload";
    public static final String KEY_EXT = "ext";
    public static final String TAG = "UbcANRRegister";
    public static final String UBC_ANR = "1794";
    public static final int UI_TRACE_MAX_SIZE = 20;
    public static boolean sEnable;
    public transient /* synthetic */ FieldHolder $fh;
    public String separator;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-514694132, "Lcom/baidu/searchbox/anr/ubc/UbcANRRegister;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-514694132, "Lcom/baidu/searchbox/anr/ubc/UbcANRRegister;");
                return;
            }
        }
        sEnable = QuickPersistConfig.getInstance().getBoolean(KEY_ANR_ACTIVE_UPLOAD, false);
    }

    public UbcANRRegister() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.separator = "\r\n";
    }

    @Override // com.baidu.searchbox.anr.ioc.IANRRegister
    public boolean checkEnable() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? sEnable : invokeV.booleanValue;
    }

    @Override // com.baidu.searchbox.anr.ioc.IANRRegister
    public void onANR(Context context, ANRInfo aNRInfo) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, aNRInfo) == null) && checkEnable()) {
            AppConfig.isDebug();
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("type", aNRInfo.getType());
                jSONObject.put("logid", aNRInfo.getLogId());
                Object oSVersion = CommonUtils.getOSVersion();
                if (oSVersion != null) {
                    jSONObject.put("osversion", oSVersion);
                }
                Object appVersion = CommonUtils.getAppVersion();
                if (appVersion != null) {
                    jSONObject.put("appversion", appVersion);
                }
                jSONObject.put("cpu", CommonUtils.getCPUInfo());
                jSONObject.put("root", CommonUtils.getRootedInfo());
                jSONObject.put("emulator", CommonUtils.getEmulator());
                jSONObject.put("inStorage", CommonUtils.getInStorage());
                jSONObject.put("exStorage", CommonUtils.getExStorage());
                jSONObject.put("isLowMemory", CommonUtils.isLowMemory());
                jSONObject.put("heap", CommonUtils.getHeapInfo());
                jSONObject.put("sysMem", CommonUtils.getSysMem());
                jSONObject.put("VSSRSS", CommonUtils.getVSSRSS());
                jSONObject.put("PSS", CommonUtils.getPSS());
                jSONObject.put("procBit", CommonUtils.getProcessBit());
                jSONObject.put("ROM", CommonUtils.getROM());
                jSONObject.put("memory", String.valueOf(CommonUtils.getMemoryInfo()));
                if (Ruka.getLineMappingMode() >= 0) {
                    jSONObject.put(Constant.KEY_LINEMAPPING, Ruka.getLineMappingMode());
                }
                Object sDKVersion = CommonUtils.getSDKVersion(Constant.KEY_RUKA_CONFIG);
                if (sDKVersion != null) {
                    jSONObject.put("sdkversion", sDKVersion);
                }
                Object network = CommonUtils.getNetwork();
                if (network != null) {
                    jSONObject.put("network", network);
                }
                Object packageName = CommonUtils.getPackageName();
                if (packageName != null) {
                    jSONObject.put("packagename", packageName);
                }
                jSONObject.put("page", aNRInfo.getCurrentPage());
                jSONObject.put("fileid", aNRInfo.getLogId());
                jSONObject.put(Constant.KEY_ANR_TIMESTAMP, aNRInfo.getTimeStamp());
                jSONObject.put("launchTime", String.valueOf(Ruka.getProcessLaunchTime()));
                String stackTrace = aNRInfo.getStackTrace();
                if (AppConfig.isDebug()) {
                    String str = "stack format before: " + stackTrace;
                }
                String str2 = "ANR" + this.separator + this.separator + stackTrace;
                jSONObject.put("stacktrace", str2);
                if (AppConfig.isDebug()) {
                    String str3 = "stack format after: " + str2;
                }
                LinkedList<TrackUI> trackUIs = aNRInfo.getTrackUIs();
                if (trackUIs != null && trackUIs.size() > 0) {
                    JSONArray jSONArray = new JSONArray();
                    int i2 = 1;
                    int size = trackUIs.size() - 1;
                    while (true) {
                        TrackUI trackUI = trackUIs.get(size);
                        JSONObject jSONObject2 = new JSONObject();
                        jSONObject2.put("time", trackUI.getTimeStamp());
                        jSONObject2.put("page", RukaTrackUIUtil.trackUI2StringPage(trackUI));
                        jSONObject2.put("event", trackUI.getEvent());
                        jSONArray.put(jSONObject2);
                        int i3 = i2 + 1;
                        if (i2 >= 20) {
                            break;
                        }
                        int i4 = size - 1;
                        if (size <= 0) {
                            break;
                        }
                        size = i4;
                        i2 = i3;
                    }
                    jSONObject.put("pageTrace", jSONArray);
                }
                JSONObject jSONObject3 = new JSONObject();
                jSONObject3.put("ext", jSONObject);
                if (AppConfig.isDebug()) {
                    jSONObject3.toString();
                }
                UBCManager uBCManager = (UBCManager) ServiceManager.getService(UBCManager.SERVICE_REFERENCE);
                if (uBCManager != null) {
                    uBCManager.onEvent(UBC_ANR, jSONObject3);
                }
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
        }
    }
}
