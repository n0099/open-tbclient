package com.baidu.afd.videopaster.data;

import android.os.Build;
import android.provider.Settings;
import android.text.TextUtils;
import android.webkit.CookieManager;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.adp.framework.task.HttpMessageTask;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.mobads.interfaces.IXAdRequestInfo;
import com.baidu.mobstat.Config;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.TbPatternsCompat;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.httpNet.HttpRequest;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tieba.recapp.report.AdUploadHttpRequest;
import d.b.b.e.p.j;
import d.b.c.m.a;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class VideoPasterRequestData extends HttpMessage {
    public static String _ANDROID_ID = "";
    public static final TbHttpMessageTask task;

    static {
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

    public VideoPasterRequestData(a aVar) {
        super(CmdConfigHttp.CMD_VIDEO_PASTER_AD_REQUEST);
        addCommonParams();
        addHeader("Cookie", CookieManager.getInstance().getCookie(TbPatternsCompat.TB_DOMAIN_NAME));
        addParam("pid", aVar.f());
        addParam("ac", "1");
        String ext = getExt(aVar);
        if (!StringUtils.isNull(ext)) {
            addParam("ext", ext);
        }
        addParam("is_https", 1);
        addParam("flr", String.valueOf(aVar.d()));
        addParam("sw", String.valueOf(aVar.g()));
        addParam(IXAdRequestInfo.SCREEN_HEIGHT, String.valueOf(aVar.e()));
        addParam("apna", TbadkCoreApplication.getInst().getPackageName());
        addParam("fc", String.valueOf(aVar.d()));
        addParam("ft", aVar.b());
        addParam(Config.EXCEPTION_CRASH_TYPE, "2");
    }

    private void addCommonParams() {
        addParam(HttpRequest.CLIENT_VERSION, TbConfig.getVersion());
        addParam("uid", TbadkCoreApplication.getCurrentAccount());
        addParam("cuid", TbadkCoreApplication.getInst().getCuid());
        addParam(TiebaStatic.Params.CUID_GALAXY2, TbadkCoreApplication.getInst().getCuidGalaxy2());
        addParam("c3_aid", TbadkCoreApplication.getInst().getCuidGalaxy3());
        addParam("model", Build.MODEL);
        addParam(HttpRequest.CLIENT_TYPE, "2");
        addParam(AdUploadHttpRequest.KEY_OS_VERSION, Build.VERSION.RELEASE);
        addParam("net_type", String.valueOf(j.I()));
        addParam(HttpRequest.PHONE_IMEI, TbadkCoreApplication.getInst().getImei());
        addParam("android_id", androidId());
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

    public static String getExt(a aVar) {
        if (aVar == null || aVar.c() == null || aVar.c().isEmpty()) {
            return null;
        }
        JSONArray jSONArray = new JSONArray();
        for (Map.Entry<String, String> entry : aVar.c().entrySet()) {
            jSONArray.put(create(entry.getKey(), entry.getValue()));
        }
        return jSONArray.toString();
    }
}
