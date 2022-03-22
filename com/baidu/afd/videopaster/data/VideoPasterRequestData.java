package com.baidu.afd.videopaster.data;

import android.os.Build;
import android.provider.Settings;
import android.text.TextUtils;
import android.webkit.CookieManager;
import androidx.core.view.InputDeviceCompat;
import c.a.d.f.p.l;
import c.a.e.m.a;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.adp.framework.task.HttpMessageTask;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.mobstat.Config;
import com.baidu.sofire.d.D;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.TbPatternsCompat;
import com.baidu.tbadk.core.util.httpNet.HttpRequest;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tieba.recapp.report.AdUploadHttpRequest;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class VideoPasterRequestData extends HttpMessage {
    public static /* synthetic */ Interceptable $ic = null;
    public static String _ANDROID_ID = "";
    public static final TbHttpMessageTask task;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(332024170, "Lcom/baidu/afd/videopaster/data/VideoPasterRequestData;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(332024170, "Lcom/baidu/afd/videopaster/data/VideoPasterRequestData;");
                return;
            }
        }
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_VIDEO_PASTER_AD_REQUEST, TbConfig.SERVER_ADDRESS + "tiebaads/ads");
        task = tbHttpMessageTask;
        tbHttpMessageTask.setMethod(HttpMessageTask.HTTP_METHOD.POST);
        task.setIsNeedAddCommenParam(false);
        task.setIsNeedAddStatisticsParam(false);
        task.setIsUseCurrentBDUSS(true);
        task.setmIsNBaiduServer(false);
        task.setResponsedClass(VideoPasterResponseData.class);
        MessageManager.getInstance().registerTask(task);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public VideoPasterRequestData(a aVar) {
        super(CmdConfigHttp.CMD_VIDEO_PASTER_AD_REQUEST);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {aVar};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super(((Integer) newInitContext.callArgs[0]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        addCommonParams();
        addHeader("Cookie", CookieManager.getInstance().getCookie(TbPatternsCompat.TB_DOMAIN_NAME));
        addParam("pid", aVar.g());
        addParam(D.COLUMN_PLUGIN_ACTIVITY_INFO_LIST, "1");
        String ext = getExt(aVar);
        if (!StringUtils.isNull(ext)) {
            addParam("ext", ext);
        }
        addParam("is_https", 1);
        addParam("flr", String.valueOf(aVar.b()));
        addParam(TbConfig.SW_APID, String.valueOf(aVar.f()));
        addParam("sh", String.valueOf(aVar.e()));
        addParam("apna", TbadkCoreApplication.getInst().getPackageName());
        addParam("fc", String.valueOf(aVar.b()));
        addParam("ft", aVar.c());
        addParam(Config.EXCEPTION_CRASH_TYPE, "2");
    }

    private void addCommonParams() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65538, this) == null) {
            addParam("_client_version", TbConfig.getVersion());
            addParam("uid", TbadkCoreApplication.getCurrentAccount());
            addParam("cuid", TbadkCoreApplication.getInst().getCuid());
            addParam("cuid_galaxy2", TbadkCoreApplication.getInst().getCuidGalaxy2());
            addParam("c3_aid", TbadkCoreApplication.getInst().getCuidGalaxy3());
            addParam("model", Build.MODEL);
            addParam(HttpRequest.CLIENT_TYPE, "2");
            addParam(AdUploadHttpRequest.KEY_OS_VERSION, Build.VERSION.RELEASE);
            addParam("net_type", String.valueOf(l.I()));
            addParam(HttpRequest.PHONE_IMEI, TbadkCoreApplication.getInst().getImei());
            addParam(HttpRequest.ANDROID_ID, androidId());
        }
    }

    public static String androidId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            if (TextUtils.isEmpty(_ANDROID_ID)) {
                try {
                    _ANDROID_ID = Settings.System.getString(TbadkCoreApplication.getInst().getContentResolver(), HttpRequest.ANDROID_ID);
                } catch (Exception unused) {
                }
            }
            return _ANDROID_ID;
        }
        return (String) invokeV.objValue;
    }

    public static JSONObject create(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, str, str2)) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("k", str);
                jSONObject.put("v", str2);
                return jSONObject;
            } catch (JSONException unused) {
                return null;
            }
        }
        return (JSONObject) invokeLL.objValue;
    }

    public static String getExt(a aVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, aVar)) == null) {
            if (aVar == null || aVar.d() == null || aVar.d().isEmpty()) {
                return null;
            }
            JSONArray jSONArray = new JSONArray();
            for (Map.Entry<String, String> entry : aVar.d().entrySet()) {
                jSONArray.put(create(entry.getKey(), entry.getValue()));
            }
            return jSONArray.toString();
        }
        return (String) invokeL.objValue;
    }
}
