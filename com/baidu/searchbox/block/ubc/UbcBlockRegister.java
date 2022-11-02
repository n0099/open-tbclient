package com.baidu.searchbox.block.ubc;

import android.content.Context;
import android.util.Log;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.pyramid.annotation.Service;
import com.baidu.pyramid.runtime.service.ServiceManager;
import com.baidu.searchbox.aperf.param.CommonUtils;
import com.baidu.searchbox.aperf.runtime.AperfRuntime;
import com.baidu.searchbox.block.impl.BlockInfo;
import com.baidu.searchbox.block.impl.BlockMonitor;
import com.baidu.searchbox.block.ioc.IBlockRegister;
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
/* loaded from: classes2.dex */
public class UbcBlockRegister implements IBlockRegister {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String KEY_BLOCK_CATCH_ACTIVE_UPLOAD = "key_block_catch_active_upload";
    public static final String KEY_EXT = "ext";
    public static final String TAG = "UbcBlockRegister";
    public static final String UBC_BLOCK = "3256";
    public static final int UI_TRACE_MAX_SIZE = 20;
    public static boolean sEnable;
    public transient /* synthetic */ FieldHolder $fh;
    public String separator;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-523093172, "Lcom/baidu/searchbox/block/ubc/UbcBlockRegister;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-523093172, "Lcom/baidu/searchbox/block/ubc/UbcBlockRegister;");
                return;
            }
        }
        sEnable = QuickPersistConfig.getInstance().getBoolean(KEY_BLOCK_CATCH_ACTIVE_UPLOAD, false);
    }

    public UbcBlockRegister() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.separator = "\r\n";
    }

    @Override // com.baidu.searchbox.block.ioc.IBlockRegister
    public boolean checkEnable() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return sEnable;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.searchbox.block.ioc.IBlockRegister
    public void onBlockCatch(Context context, BlockInfo blockInfo) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, blockInfo) != null) || !checkEnable()) {
            return;
        }
        if (AppConfig.isDebug()) {
            Log.d(BlockMonitor.TAG, "onBlockCatch  at UbcBlockCatchRegister");
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("type", blockInfo.getType());
            jSONObject.put("logid", blockInfo.getLogId());
            jSONObject.put("launchid", AperfRuntime.Runtime.getProcessUUID());
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
            jSONObject.put("heap", CommonUtils.getHeapInfo());
            jSONObject.put("sysMem", CommonUtils.getSysMem());
            jSONObject.put("isLowMemory", CommonUtils.isLowMemory());
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
            jSONObject.put("page", blockInfo.getCurrentPage());
            jSONObject.put(Constant.KEY_BLOCK_TIMESTAMP, blockInfo.getTimeStamp());
            jSONObject.put("launchTime", String.valueOf(Ruka.getProcessLaunchTime()));
            String stackTrace = blockInfo.getStackTrace();
            if (AppConfig.isDebug()) {
                Log.d(TAG, "stack format before: " + stackTrace);
            }
            String str = "Block" + this.separator + this.separator + stackTrace;
            jSONObject.put("stacktrace", str);
            if (AppConfig.isDebug()) {
                Log.d(TAG, "stack format after: " + str);
            }
            LinkedList<TrackUI> trackUIs = blockInfo.getTrackUIs();
            if (trackUIs != null && trackUIs.size() > 0) {
                JSONArray jSONArray = new JSONArray();
                int i = 1;
                int size = trackUIs.size() - 1;
                while (true) {
                    TrackUI trackUI = trackUIs.get(size);
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put("time", trackUI.getTimeStamp());
                    jSONObject2.put("page", RukaTrackUIUtil.trackUI2StringPage(trackUI));
                    jSONObject2.put("event", trackUI.getEvent());
                    jSONArray.put(jSONObject2);
                    int i2 = i + 1;
                    if (i >= 20) {
                        break;
                    }
                    int i3 = size - 1;
                    if (size <= 0) {
                        break;
                    }
                    size = i3;
                    i = i2;
                }
                jSONObject.put("pageTrace", jSONArray);
            }
            JSONObject jSONObject3 = new JSONObject();
            jSONObject3.put("ext", jSONObject);
            if (AppConfig.isDebug()) {
                Log.d(TAG, jSONObject3.toString());
            }
            UBCManager uBCManager = (UBCManager) ServiceManager.getService(UBCManager.SERVICE_REFERENCE);
            if (uBCManager != null) {
                uBCManager.onEvent("3256", jSONObject3);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
