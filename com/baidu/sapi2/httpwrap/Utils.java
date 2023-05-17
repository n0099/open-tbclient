package com.baidu.sapi2.httpwrap;

import com.baidu.sapi2.SapiConfiguration;
import com.baidu.sapi2.ServiceManager;
import com.baidu.sapi2.service.interfaces.ISAccountManager;
import com.baidu.sapi2.utils.SapiUtils;
import com.baidu.searchbox.dns.transmit.model.DnsModel;
import com.baidu.searchbox.wordscommand.util.CommandUBCHelper;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes3.dex */
public class Utils {
    public static Map<String, String> buildCommonParams() {
        SapiConfiguration confignation;
        HashMap hashMap = new HashMap();
        hashMap.put(CommandUBCHelper.COMMAND_UBC_STATISTICS_SOURCE_VALUE_CLIENT, "android");
        ISAccountManager isAccountManager = ServiceManager.getInstance().getIsAccountManager();
        if (isAccountManager != null && (confignation = isAccountManager.getConfignation()) != null) {
            String clientId = SapiUtils.getClientId(confignation.context);
            hashMap.put("cuid", clientId);
            hashMap.put("clientid", clientId);
            hashMap.put("clientfrom", "native");
            hashMap.put("zid", isAccountManager.getCurrentZid(confignation.context));
            hashMap.put(DnsModel.CLIENTIP_KEY, confignation.clientIp);
            hashMap.put("appid", confignation.appId);
            hashMap.put("tpl", confignation.tpl);
            hashMap.put("app_version", SapiUtils.getVersionName(confignation.context));
            hashMap.put("sdk_version", isAccountManager.getVersionName());
            hashMap.put("sdkversion", isAccountManager.getVersionName());
        }
        return hashMap;
    }
}
