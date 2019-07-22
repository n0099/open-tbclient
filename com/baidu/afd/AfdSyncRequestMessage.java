package com.baidu.afd;

import android.os.Build;
import android.provider.Settings;
import android.text.TextUtils;
import android.webkit.CookieManager;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.adp.framework.task.HttpMessageTask;
import com.baidu.appsearchlib.Info;
import com.baidu.mobstat.Config;
import com.baidu.sapi2.SapiAccountManager;
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
public class AfdSyncRequestMessage extends HttpMessage {
    private static String _ANDROID_ID = "";
    private static final TbHttpMessageTask task = new TbHttpMessageTask(CmdConfigHttp.CMD_AFD_REQUEST_ASYNC, "http://afd.baidu.com/afd/entry");

    public AfdSyncRequestMessage(g gVar) {
        super(CmdConfigHttp.CMD_AFD_REQUEST_ASYNC);
        addCommonParams();
        addHeader(SM.COOKIE, CookieManager.getInstance().getCookie("tieba.baidu.com"));
        setUserAgent("bdtb for Android " + TbConfig.getVersion());
        addParam(Info.kBaiduPIDKey, "1517888290046");
        addParam("ac", "1");
        addParam("ft", gVar.pc());
        addParam("ext", getExt(gVar));
        addParam("flr", String.valueOf(gVar.pe()));
        addParam("fc", String.valueOf(gVar.pe()));
    }

    private static String getExt(g gVar) {
        JSONArray jSONArray = new JSONArray();
        for (Map.Entry<String, String> entry : gVar.pf().entrySet()) {
            jSONArray.put(create(entry.getKey(), entry.getValue()));
        }
        return jSONArray.toString();
    }

    private void addCommonParams() {
        addParam("mod", Build.MODEL);
        addParam("ver", TbConfig.getVersion());
        addParam("cuid", TbadkCoreApplication.getInst().getCuid());
        addParam("cuid_galaxy2", TbadkCoreApplication.getInst().getCuidGalaxy2());
        addParam("ov", Build.VERSION.RELEASE);
        addParam("apna", TbadkCoreApplication.getInst().getPackageName());
        addParam("imei", TbadkCoreApplication.getInst().getImei());
        addParam("fmt", "json");
        addParam("android_id", androidId());
        addParam("ot", "2");
        addParam(Config.EXCEPTION_CRASH_TYPE, "2");
        addParam("nt", String.valueOf(com.baidu.adp.lib.util.j.netType()));
        addParam("uid", SapiAccountManager.getInstance().getSession("uid"));
        addParam("is_https", 1);
    }

    private static JSONObject create(String str, String str2) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(Config.APP_KEY, str);
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
        task.setIsUseCurrentBDUSS(false);
        task.setmIsNBaiduServer(false);
        task.setResponsedClass(AfdSyncResponseMessage.class);
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
