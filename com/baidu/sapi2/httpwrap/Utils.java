package com.baidu.sapi2.httpwrap;

import com.baidu.android.imsdk.db.TableDefine;
import com.baidu.sapi2.SapiConfiguration;
import com.baidu.sapi2.SapiContext;
import com.baidu.sapi2.ServiceManager;
import com.baidu.sapi2.service.interfaces.ISAccountManager;
import com.baidu.sapi2.utils.SapiUtils;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes.dex */
class Utils {
    Utils() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Map<String, String> buildCommonParams() {
        SapiConfiguration confignation;
        HashMap hashMap = new HashMap();
        hashMap.put("client", "android");
        ISAccountManager isAccountManager = ServiceManager.getInstance().getIsAccountManager();
        if (isAccountManager != null && (confignation = isAccountManager.getConfignation()) != null) {
            hashMap.put("cuid", confignation.clientId);
            hashMap.put("clientid", confignation.clientId);
            hashMap.put("zid", isAccountManager.getCurrentZid(confignation.context));
            hashMap.put("clientip", confignation.clientIp);
            hashMap.put("appid", confignation.appId);
            hashMap.put(TableDefine.PaSubscribeColumns.COLUMN_TPL, confignation.tpl);
            hashMap.put("app_version", SapiUtils.getVersionName(confignation.context));
            hashMap.put(SapiContext.KEY_SDK_VERSION, isAccountManager.getVersionName());
            hashMap.put("sdkversion", isAccountManager.getVersionName());
        }
        return hashMap;
    }
}
