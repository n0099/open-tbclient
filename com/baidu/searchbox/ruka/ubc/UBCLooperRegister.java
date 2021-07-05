package com.baidu.searchbox.ruka.ubc;

import android.content.Context;
import android.util.Log;
import com.android.internal.http.multipart.Part;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.pyramid.annotation.Service;
import com.baidu.pyramid.runtime.service.ServiceManager;
import com.baidu.searchbox.aperf.param.CommonUtils;
import com.baidu.searchbox.config.AppConfig;
import com.baidu.searchbox.config.QuickPersistConfig;
import com.baidu.searchbox.looper.impl.LooperBlock;
import com.baidu.searchbox.looper.ioc.ILooperRegister;
import com.baidu.searchbox.ruka.Ruka;
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
/* loaded from: classes3.dex */
public class UBCLooperRegister extends ILooperRegister {
    public static /* synthetic */ Interceptable $ic = null;
    public static String KEY_BLOCK_ACTIVE_UPLOAD = "key_block_active_upload";
    public static final String KEY_EXT = "ext";
    public static final String TAG = "UBCLooperRegister";
    public static final String UBC_BLOCK = "1157";
    public static final int UI_TRACE_MAX_SIZE = 20;
    public static boolean sEnable;
    public transient /* synthetic */ FieldHolder $fh;
    public String separator;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1091441766, "Lcom/baidu/searchbox/ruka/ubc/UBCLooperRegister;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1091441766, "Lcom/baidu/searchbox/ruka/ubc/UBCLooperRegister;");
                return;
            }
        }
        sEnable = QuickPersistConfig.getInstance().getBoolean(KEY_BLOCK_ACTIVE_UPLOAD, false);
    }

    public UBCLooperRegister() {
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
        this.separator = Part.CRLF;
    }

    @Override // com.baidu.searchbox.looper.ioc.ILooperRegister
    public boolean checkEnable() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? sEnable : invokeV.booleanValue;
    }

    @Override // com.baidu.searchbox.looper.ioc.ILooperRegister
    public void onBlock(Context context, LooperBlock looperBlock) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, looperBlock) == null) {
            if (!sEnable) {
                if (AppConfig.isDebug()) {
                    Log.d(TAG, "UBCLooperRegister, sEnable = false");
                    return;
                }
                return;
            }
            if (AppConfig.isDebug()) {
                Log.d(TAG, "UBCLooperRegister, sEnable = true, write LooperBlock into UBC");
            }
            JSONObject jSONObject = new JSONObject();
            try {
                Object oSVersion = CommonUtils.getOSVersion();
                if (oSVersion != null) {
                    jSONObject.put("osversion", oSVersion);
                }
                jSONObject.put("memory", CommonUtils.getMemoryInfo());
                Object appVersion = CommonUtils.getAppVersion();
                if (appVersion != null) {
                    jSONObject.put("appversion", appVersion);
                }
                Object sDKVersion = CommonUtils.getSDKVersion(Constant.KEY_RUKA_CONFIG);
                if (sDKVersion != null) {
                    jSONObject.put("sdkversion", sDKVersion);
                }
                Object cPUInfo = CommonUtils.getCPUInfo();
                if (cPUInfo != null) {
                    jSONObject.put("cpu", cPUInfo);
                }
                Object network = CommonUtils.getNetwork();
                if (network != null) {
                    jSONObject.put("network", network);
                }
                Object packageName = CommonUtils.getPackageName();
                if (packageName != null) {
                    jSONObject.put("packagename", packageName);
                }
                jSONObject.put("launchTime", String.valueOf(Ruka.getProcessLaunchTime()));
                jSONObject.put("logid", looperBlock.getLogID());
                jSONObject.put("page", looperBlock.getCurrentPage());
                jSONObject.put("cpuusage", looperBlock.getCpuRateInfo());
                jSONObject.put("duration", looperBlock.getDuration());
                jSONObject.put("type", looperBlock.getType());
                jSONObject.put(Constant.KEY_TIME_COST_START, looperBlock.getStartLagTime());
                jSONObject.put(Constant.KEY_TIME_COST_END, looperBlock.getEndLagTime());
                String sb = looperBlock.getStackSb().toString();
                if (AppConfig.isDebug()) {
                    Log.d(TAG, "stack format before: " + sb);
                }
                String[] split = sb.split(this.separator + this.separator);
                if (split.length > 0) {
                    String str = split[0];
                    if (str.length() > 0 && str.contains("stack = ")) {
                        sb = "Looper" + looperBlock.getStackSb().toString().replace(str, "");
                    }
                }
                jSONObject.put("stacktrace", sb);
                if (AppConfig.isDebug()) {
                    Log.d(TAG, "stack format after: " + sb);
                }
                LinkedList<TrackUI> trackUIs = looperBlock.getTrackUIs();
                if (trackUIs != null && trackUIs.size() > 0) {
                    JSONArray jSONArray = new JSONArray();
                    int i2 = 1;
                    int size = trackUIs.size() - 1;
                    while (true) {
                        TrackUI trackUI = trackUIs.get(size);
                        JSONObject jSONObject2 = new JSONObject();
                        jSONObject2.put("time", trackUI.getTimeStamp());
                        jSONObject2.put("page", trackUI.toStringPage());
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
                UBCManager uBCManager = (UBCManager) ServiceManager.getService(UBCManager.SERVICE_REFERENCE);
                if (uBCManager != null) {
                    uBCManager.onEvent(UBC_BLOCK, jSONObject3);
                }
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
        }
    }
}
