package com.baidu.afd.videopaster.data;

import android.os.Build;
import android.provider.Settings;
import android.text.TextUtils;
import android.webkit.CookieManager;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.adp.framework.task.HttpMessageTask;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.j;
import com.baidu.mobads.interfaces.IXAdRequestInfo;
import com.baidu.mobstat.Config;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.task.TbHttpMessageTask;
import java.util.Map;
import org.apache.http.cookie.SM;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class VideoPasterRequestData extends HttpMessage {
    private static String _ANDROID_ID = "";
    private static final TbHttpMessageTask task = new TbHttpMessageTask(CmdConfigHttp.CMD_VIDEO_PASTER_AD_REQUEST, TbConfig.SERVER_ADDRESS + "tiebaads/ads");

    public VideoPasterRequestData(com.baidu.afd.videopaster.a aVar) {
        super(CmdConfigHttp.CMD_VIDEO_PASTER_AD_REQUEST);
        addCommonParams();
        addHeader(SM.COOKIE, CookieManager.getInstance().getCookie("tieba.baidu.com"));
        addParam("pid", aVar.rc());
        addParam("ac", "1");
        String ext = getExt(aVar);
        if (!StringUtils.isNull(ext)) {
            addParam("ext", ext);
        }
        addParam("is_https", 1);
        addParam("flr", String.valueOf(aVar.qR()));
        addParam("sw", String.valueOf(aVar.width()));
        addParam(IXAdRequestInfo.SCREEN_HEIGHT, String.valueOf(aVar.height()));
        addParam("apna", TbadkCoreApplication.getInst().getPackageName());
        addParam("fc", String.valueOf(aVar.qR()));
        addParam("ft", aVar.qP());
        addParam(Config.EXCEPTION_CRASH_TYPE, "2");
    }

    private static String getExt(com.baidu.afd.videopaster.a aVar) {
        if (aVar == null || aVar.qS() == null || aVar.qS().isEmpty()) {
            return null;
        }
        JSONArray jSONArray = new JSONArray();
        for (Map.Entry<String, String> entry : aVar.qS().entrySet()) {
            jSONArray.put(create(entry.getKey(), entry.getValue()));
        }
        return jSONArray.toString();
    }

    private void addCommonParams() {
        addParam("_client_version", TbConfig.getVersion());
        addParam("uid", TbadkCoreApplication.getCurrentAccount());
        addParam("cuid", TbadkCoreApplication.getInst().getCuid());
        addParam("cuid_galaxy2", TbadkCoreApplication.getInst().getCuidGalaxy2());
        addParam("c3_aid", TbadkCoreApplication.getInst().getCuidGalaxy3());
        addParam("model", Build.MODEL);
        addParam("_client_type", "2");
        addParam("_os_version", Build.VERSION.RELEASE);
        addParam("net_type", String.valueOf(j.netType()));
        addParam("_phone_imei", TbadkCoreApplication.getInst().getImei());
        addParam("android_id", androidId());
    }

    private static JSONObject create(String str, String str2) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("k", str);
            jSONObject.put("v", str2);
            return jSONObject;
        } catch (JSONException e) {
            return null;
        }
    }

    static {
        task.setMethod(HttpMessageTask.HTTP_METHOD.POST);
        task.setIsNeedAddCommenParam(false);
        task.setIsNeedAddStatisticsParam(false);
        task.setIsUseCurrentBDUSS(true);
        task.setmIsNBaiduServer(false);
        task.setResponsedClass(VideoPasterResponseData.class);
        MessageManager.getInstance().registerTask(task);
    }

    public static String androidId() {
        if (TextUtils.isEmpty(_ANDROID_ID)) {
            try {
                _ANDROID_ID = Settings.System.getString(TbadkCoreApplication.getInst().getContentResolver(), "android_id");
            } catch (Exception e) {
            }
        }
        return _ANDROID_ID;
    }
}
