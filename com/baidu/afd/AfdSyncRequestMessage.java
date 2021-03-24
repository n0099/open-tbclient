package com.baidu.afd;

import android.os.Build;
import android.provider.Settings;
import android.text.TextUtils;
import android.webkit.CookieManager;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.adp.framework.task.HttpMessageTask;
import com.baidu.mobstat.Config;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.TbPatternsCompat;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tieba.advert.sdk.data.SplashHttpRequest;
import d.b.b.e.p.j;
import d.b.c.h;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class AfdSyncRequestMessage extends HttpMessage {
    public static String _ANDROID_ID = "";
    public static final TbHttpMessageTask task;

    static {
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

    public AfdSyncRequestMessage(h hVar) {
        super(CmdConfigHttp.CMD_AFD_REQUEST_ASYNC);
        addCommonParams();
        addHeader("Cookie", CookieManager.getInstance().getCookie(TbPatternsCompat.TB_DOMAIN_NAME));
        setUserAgent("bdtb for Android " + TbConfig.getVersion());
        addParam("pid", "1517888290046");
        addParam("ac", "1");
        addParam("ft", hVar.b());
        addParam("ext", getExt(hVar));
        addParam("flr", String.valueOf(hVar.d()));
        addParam("fc", String.valueOf(hVar.d()));
    }

    private void addCommonParams() {
        addParam("mod", Build.MODEL);
        addParam("ver", TbConfig.getVersion());
        addParam("cuid", TbadkCoreApplication.getInst().getCuid());
        addParam(TiebaStatic.Params.CUID_GALAXY2, TbadkCoreApplication.getInst().getCuidGalaxy2());
        addParam("c3_aid", TbadkCoreApplication.getInst().getCuidGalaxy3());
        addParam("ov", Build.VERSION.RELEASE);
        addParam("apna", TbadkCoreApplication.getInst().getPackageName());
        addParam("imei", TbadkCoreApplication.getInst().getImei());
        addParam("fmt", "json");
        addParam("android_id", androidId());
        addParam("ot", "2");
        addParam(Config.EXCEPTION_CRASH_TYPE, "2");
        addParam("nt", String.valueOf(j.I()));
        addParam("uid", TbadkCoreApplication.getCurrentAccount());
        addParam("is_https", 1);
    }

    public static String androidId() {
        if (TextUtils.isEmpty(_ANDROID_ID)) {
            try {
                _ANDROID_ID = Settings.System.getString(TbadkCoreApplication.getInst().getContentResolver(), "android_id");
            } catch (Exception unused) {
            }
        }
        return _ANDROID_ID;
    }

    public static JSONObject create(String str, String str2) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(Config.APP_KEY, str);
            jSONObject.put("v", str2);
            return jSONObject;
        } catch (JSONException unused) {
            return null;
        }
    }

    public static String getExt(h hVar) {
        JSONArray jSONArray = new JSONArray();
        for (Map.Entry<String, String> entry : hVar.c().entrySet()) {
            jSONArray.put(create(entry.getKey(), entry.getValue()));
        }
        return jSONArray.toString();
    }
}
