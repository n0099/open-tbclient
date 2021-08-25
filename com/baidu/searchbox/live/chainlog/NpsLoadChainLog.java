package com.baidu.searchbox.live.chainlog;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.adrequest.IAdRequestParam;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.pyramid.runtime.service.ServiceManager;
import com.baidu.searchbox.live.interfaces.service.AppInfoService;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.ubc.UBCManager;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class NpsLoadChainLog {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int ERR_CODE_UNUSED = Integer.MIN_VALUE;
    public static final String FROM = "yysdk";
    public static final String PAGE = "liveroom";
    public static final int RESULT_FAIL = 0;
    public static final int RESULT_SUCCESS = 1;
    public static final int RESULT_UNUSED = -1;
    public static final String TYPE = "toload";
    public static final String UBC_ID_4347 = "4347";
    public static NpsLoadChainLog sInstance;
    public transient /* synthetic */ FieldHolder $fh;
    public AppInfoService appService;
    public String entry;
    public String hostName;
    public String hostVersion;
    public JSONObject pathJsonObj;
    public String pathTemp;
    public String pluginVersion;
    public String sessionId;
    public UBCManager ubcManager;

    /* renamed from: com.baidu.searchbox.live.chainlog.NpsLoadChainLog$1  reason: invalid class name */
    /* loaded from: classes5.dex */
    public static /* synthetic */ class AnonymousClass1 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes5.dex */
    public static class Holder {
        public static /* synthetic */ Interceptable $ic;
        public static final NpsLoadChainLog INSTANCE;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(509609826, "Lcom/baidu/searchbox/live/chainlog/NpsLoadChainLog$Holder;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(509609826, "Lcom/baidu/searchbox/live/chainlog/NpsLoadChainLog$Holder;");
                    return;
                }
            }
            INSTANCE = new NpsLoadChainLog(null);
        }

        public Holder() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65537, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                }
            }
        }
    }

    public /* synthetic */ NpsLoadChainLog(AnonymousClass1 anonymousClass1) {
        this();
    }

    private void genSessionId() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65538, this) == null) {
            this.sessionId = this.appService.getCuid() + "-" + System.currentTimeMillis();
        }
    }

    public static NpsLoadChainLog getInstance() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            if (sInstance == null) {
                sInstance = Holder.INSTANCE;
            }
            return sInstance;
        }
        return (NpsLoadChainLog) invokeV.objValue;
    }

    private boolean isDebug() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, this)) == null) {
            AppInfoService appInfoService = this.appService;
            if (appInfoService != null) {
                return appInfoService.isDebug();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    private boolean notLogPathNode(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.AD_TEXT_ID, this, str)) == null) {
            String str2 = this.pathTemp;
            if (str2 == null) {
                return false;
            }
            if (str2.contains(str)) {
                dLog(str + " 节点已经打过了");
            }
            return this.pathTemp.contains(str);
        }
        return invokeL.booleanValue;
    }

    public void dLog(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
            isDebug();
        }
    }

    public void endDownloadLiveNps(long j2, long j3) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Long.valueOf(j2), Long.valueOf(j3)}) == null) || notLogPathNode("livenpsEndDowlonad") || this.pathJsonObj == null) {
            return;
        }
        this.pathTemp += "livenpsEndDowlonad";
        try {
            this.pathJsonObj.put("livenpsEndDowlonad", genNodeJsonObj(1, Integer.MIN_VALUE, j2, j3));
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        showPathAndDuration();
        ubcLog();
    }

    public void endInitYY(boolean z, String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZL(Constants.METHOD_SEND_USER_MSG, this, z, str) == null) || notLogPathNode("initEnd") || this.pathJsonObj == null) {
            return;
        }
        this.pathTemp += "initEnd";
        try {
            this.pathJsonObj.put("initEnd", genNodeJsonObj(z ? 1 : 0, Integer.MIN_VALUE, str));
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        showPathAndDuration();
        ubcLog();
        if (z) {
            return;
        }
        reset();
    }

    public void endInstallEntrance(boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048579, this, z) == null) || notLogPathNode("entranceEndInstall") || this.pathJsonObj == null) {
            return;
        }
        this.pathTemp += "entranceEndInstall";
        try {
            this.pathJsonObj.put("entranceEndInstall", genNodeJsonObj(z ? 1 : 0, Integer.MIN_VALUE));
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        showPathAndDuration();
        ubcLog();
        if (z) {
            return;
        }
        reset();
    }

    public void endInstallLiveNps(boolean z, int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048580, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i2)}) == null) || notLogPathNode("endInstallLiveNps") || this.pathJsonObj == null) {
            return;
        }
        this.pathTemp += "endInstallLiveNps";
        try {
            this.pathJsonObj.put("livenpsEndInstall", genNodeJsonObj(z ? 1 : 0, i2));
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        showPathAndDuration();
        ubcLog();
        if (z) {
            return;
        }
        reset();
    }

    public void endLoadClazzLiveNps(boolean z, int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048581, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i2)}) == null) || notLogPathNode("livenpsEndLoad") || this.pathJsonObj == null) {
            return;
        }
        this.pathTemp += "livenpsEndLoad";
        try {
            this.pathJsonObj.put("livenpsEndLoad", genNodeJsonObj(z ? 1 : 0, i2));
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        showPathAndDuration();
        ubcLog();
        if (z) {
            return;
        }
        reset();
    }

    public void endMergeDexEntrance(boolean z, int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048582, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i2)}) == null) || notLogPathNode("entranceEndLoad") || this.pathJsonObj == null) {
            return;
        }
        this.pathTemp += "entranceEndLoad";
        try {
            this.pathJsonObj.put("entranceEndLoad", genNodeJsonObj(z ? 1 : 0, i2));
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        showPathAndDuration();
        ubcLog();
        if (z) {
            return;
        }
        reset();
    }

    public JSONObject genNodeJsonObj(int i2, int i3, String str) {
        InterceptResult invokeIIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIIL = interceptable.invokeIIL(1048585, this, i2, i3, str)) == null) {
            JSONObject genNodeJsonObj = genNodeJsonObj(i2, i3);
            try {
                genNodeJsonObj.put("errorMsg", str);
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
            return genNodeJsonObj;
        }
        return (JSONObject) invokeIIL.objValue;
    }

    public String getEntry() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.entry : (String) invokeV.objValue;
    }

    public String getHostName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.hostName : (String) invokeV.objValue;
    }

    public String getHostVersion() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.hostVersion : (String) invokeV.objValue;
    }

    public String getPath() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            JSONObject jSONObject = this.pathJsonObj;
            return jSONObject == null ? "" : jSONObject.toString();
        }
        return (String) invokeV.objValue;
    }

    public String getPluginVersion() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? this.pluginVersion : (String) invokeV.objValue;
    }

    public String getSessionId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? this.sessionId : (String) invokeV.objValue;
    }

    public void initAndStart() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            reset();
            genSessionId();
            this.pathJsonObj = new JSONObject();
            this.hostName = this.appService.getLiveAppId();
            this.hostVersion = this.appService.getVersionName();
        }
    }

    public void reset() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            this.sessionId = "";
            this.pluginVersion = "";
            this.entry = "";
            this.hostName = "";
            this.hostVersion = "";
            this.pathJsonObj = null;
            this.pathTemp = "";
        }
    }

    public void setEntry(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048594, this, str) == null) || notLogPathNode("entry") || this.pathJsonObj == null) {
            return;
        }
        this.entry = str;
        this.pathTemp += "entry";
        try {
            this.pathJsonObj.put("entry", genNodeJsonObj(-1, Integer.MIN_VALUE));
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        showPathAndDuration();
        ubcLog();
    }

    public void setPluginVersion(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, str) == null) {
            this.pluginVersion = str;
        }
    }

    public void showPathAndDuration() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048596, this) == null) && isDebug() && this.pathJsonObj != null) {
            String str = "path = " + this.pathJsonObj.toString();
        }
    }

    public void startDownloadLiveNps() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048597, this) == null) || notLogPathNode("livenpsStartDownload") || this.pathJsonObj == null) {
            return;
        }
        this.pathTemp += "livenpsStartDownload";
        try {
            this.pathJsonObj.put("livenpsStartDownload", genNodeJsonObj(-1, Integer.MIN_VALUE));
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        showPathAndDuration();
        ubcLog();
    }

    public void startInitYY() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048598, this) == null) || notLogPathNode("initStart") || this.pathJsonObj == null) {
            return;
        }
        this.pathTemp += "initStart";
        try {
            this.pathJsonObj.put("initStart", genNodeJsonObj(-1, Integer.MIN_VALUE));
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        showPathAndDuration();
        ubcLog();
    }

    public void startInstallEntrance() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048599, this) == null) || notLogPathNode("entranceStartInstall") || this.pathJsonObj == null) {
            return;
        }
        this.pathTemp += "entranceStartInstall";
        try {
            this.pathJsonObj.put("entranceStartInstall", genNodeJsonObj(-1, Integer.MIN_VALUE));
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        showPathAndDuration();
        ubcLog();
    }

    public void startInstallLiveNps() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048600, this) == null) || notLogPathNode("livenpsStartInstall") || this.pathJsonObj == null) {
            return;
        }
        this.pathTemp += "livenpsStartInstall";
        try {
            this.pathJsonObj.put("livenpsStartInstall", genNodeJsonObj(-1, Integer.MIN_VALUE));
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        showPathAndDuration();
        ubcLog();
    }

    public void startLoadClazzLiveNps() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048601, this) == null) || notLogPathNode("livenpsStartLoad") || this.pathJsonObj == null) {
            return;
        }
        this.pathTemp += "livenpsStartLoad";
        try {
            this.pathJsonObj.put("livenpsStartLoad", genNodeJsonObj(-1, Integer.MIN_VALUE));
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        showPathAndDuration();
        ubcLog();
    }

    public void startMergeDexEntrance() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048602, this) == null) || notLogPathNode("entranceStartLoad") || this.pathJsonObj == null) {
            return;
        }
        this.pathTemp += "entranceStartLoad";
        try {
            this.pathJsonObj.put("entranceStartLoad", genNodeJsonObj(-1, Integer.MIN_VALUE));
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        showPathAndDuration();
        ubcLog();
    }

    public void ubcLog() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048603, this) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("from", FROM);
                jSONObject.put("type", TYPE);
                jSONObject.put("page", PAGE);
                jSONObject.put("source", this.hostName);
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("path", getPath());
                jSONObject2.put("entry", this.entry);
                jSONObject2.put("yysdk_ver", "");
                jSONObject2.put("plugin_ver", this.pluginVersion);
                jSONObject2.put("is_end", 0);
                jSONObject2.put("session_id", this.sessionId);
                jSONObject2.put("hdid", "");
                jSONObject2.put(IAdRequestParam.APV, this.hostVersion);
                jSONObject2.put("sid", "");
                jSONObject2.put("tpl_id", "");
                jSONObject2.put("is_Mix", 0);
                jSONObject.put("ext", jSONObject2.toString());
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
            dLog(jSONObject.toString());
            dLog("-----------------------\n");
            this.ubcManager.onEvent(UBC_ID_4347, jSONObject.toString());
        }
    }

    public NpsLoadChainLog() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.ubcManager = (UBCManager) ServiceManager.getService(UBCManager.SERVICE_REFERENCE);
        this.appService = (AppInfoService) ServiceManager.getService(AppInfoService.Companion.getSERVICE_REFERENCE());
        this.sessionId = "";
        this.pluginVersion = "";
        this.hostName = "";
        this.hostVersion = "";
        this.entry = "";
    }

    public JSONObject genNodeJsonObj(int i2, int i3, long j2, long j3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(InputDeviceCompat.SOURCE_TOUCHPAD, this, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), Long.valueOf(j2), Long.valueOf(j3)})) == null) {
            JSONObject genNodeJsonObj = genNodeJsonObj(i2, i3);
            try {
                genNodeJsonObj.put("downloadSize", j2);
                genNodeJsonObj.put("totalSize", j3);
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
            return genNodeJsonObj;
        }
        return (JSONObject) invokeCommon.objValue;
    }

    public JSONObject genNodeJsonObj(int i2, int i3) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(1048583, this, i2, i3)) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("time", System.currentTimeMillis());
                if (-1 != i2) {
                    jSONObject.put("status", i2);
                }
                if (1 != i2 && Integer.MIN_VALUE != i3) {
                    jSONObject.put("errorCode", i2);
                }
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
            return jSONObject;
        }
        return (JSONObject) invokeII.objValue;
    }
}
