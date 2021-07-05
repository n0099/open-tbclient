package com.baidu.afd;

import android.os.Build;
import android.provider.Settings;
import android.text.TextUtils;
import android.webkit.CookieManager;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.adp.framework.task.HttpMessageTask;
import com.baidu.mobads.container.adrequest.IAdRequestParam;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.mobstat.Config;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.browser.SearchJsBridge;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.TbPatternsCompat;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tieba.advert.sdk.data.SplashHttpRequest;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.c.e.p.j;
import d.a.d.h;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class AfdSyncRequestMessage extends HttpMessage {
    public static /* synthetic */ Interceptable $ic = null;
    public static String _ANDROID_ID = "";
    public static final TbHttpMessageTask task;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1725829671, "Lcom/baidu/afd/AfdSyncRequestMessage;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1725829671, "Lcom/baidu/afd/AfdSyncRequestMessage;");
                return;
            }
        }
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_AFD_REQUEST_ASYNC, SplashHttpRequest.url);
        task = tbHttpMessageTask;
        tbHttpMessageTask.setMethod(HttpMessageTask.HTTP_METHOD.POST);
        task.setIsNeedAddCommenParam(false);
        task.setIsNeedAddStatisticsParam(false);
        task.setIsUseCurrentBDUSS(false);
        task.setmIsNBaiduServer(false);
        task.setResponsedClass(AfdSyncResponseMessage.class);
        MessageManager.getInstance().registerTask(task);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AfdSyncRequestMessage(h hVar) {
        super(CmdConfigHttp.CMD_AFD_REQUEST_ASYNC);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {hVar};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super(((Integer) newInitContext.callArgs[0]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        addCommonParams();
        addHeader("Cookie", CookieManager.getInstance().getCookie(TbPatternsCompat.TB_DOMAIN_NAME));
        setUserAgent("bdtb for Android " + TbConfig.getVersion());
        addParam("pid", "1517888290046");
        addParam("ac", "1");
        addParam("ft", hVar.c());
        addParam("ext", getExt(hVar));
        addParam("flr", String.valueOf(hVar.b()));
        addParam("fc", String.valueOf(hVar.b()));
    }

    private void addCommonParams() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65538, this) == null) {
            addParam(SearchJsBridge.COOKIE_MOD, Build.MODEL);
            addParam("ver", TbConfig.getVersion());
            addParam("cuid", TbadkCoreApplication.getInst().getCuid());
            addParam("cuid_galaxy2", TbadkCoreApplication.getInst().getCuidGalaxy2());
            addParam("c3_aid", TbadkCoreApplication.getInst().getCuidGalaxy3());
            addParam(SearchJsBridge.COOKIE_OV, Build.VERSION.RELEASE);
            addParam("apna", TbadkCoreApplication.getInst().getPackageName());
            addParam("imei", TbadkCoreApplication.getInst().getImei());
            addParam("fmt", "json");
            addParam(IAdRequestParam.ANDROID_ID, androidId());
            addParam("ot", "2");
            addParam(Config.EXCEPTION_CRASH_TYPE, "2");
            addParam("nt", String.valueOf(j.I()));
            addParam("uid", TbadkCoreApplication.getCurrentAccount());
            addParam("is_https", 1);
        }
    }

    public static String androidId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            if (TextUtils.isEmpty(_ANDROID_ID)) {
                try {
                    _ANDROID_ID = Settings.System.getString(TbadkCoreApplication.getInst().getContentResolver(), IAdRequestParam.ANDROID_ID);
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
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65540, null, str, str2)) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put(Config.APP_KEY, str);
                jSONObject.put("v", str2);
                return jSONObject;
            } catch (JSONException unused) {
                return null;
            }
        }
        return (JSONObject) invokeLL.objValue;
    }

    public static String getExt(h hVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.AD_TEXT_ID, null, hVar)) == null) {
            JSONArray jSONArray = new JSONArray();
            for (Map.Entry<String, String> entry : hVar.d().entrySet()) {
                jSONArray.put(create(entry.getKey(), entry.getValue()));
            }
            return jSONArray.toString();
        }
        return (String) invokeL.objValue;
    }
}
