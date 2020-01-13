package com.baidu.sapi2.utils;

import android.annotation.TargetApi;
import com.baidu.android.common.security.MD5Util;
import com.baidu.sapi2.SapiAccount;
import com.baidu.sapi2.SapiAccountManager;
import com.baidu.sapi2.SapiConfiguration;
import com.baidu.sapi2.SapiContext;
import com.baidu.sapi2.utils.SapiDeviceUtils;
import com.xiaomi.mipush.sdk.Constants;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class l {
    @TargetApi(8)
    public String a(Long l, String str, String str2) {
        SapiConfiguration confignation = SapiAccountManager.getInstance().getConfignation();
        String packageName = confignation.context.getPackageName();
        String packageSign = SapiUtils.getPackageSign(confignation.context, packageName);
        String packageSign2 = SapiUtils.getPackageSign(confignation.context, str);
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("type", "native");
            jSONObject.put("timestamp", l);
            jSONObject.put("host_api_key", confignation.bdOauthAppId);
            jSONObject.put("host_pkgname", packageName);
            jSONObject.put("host_key_hash", packageSign);
            SapiAccount currentAccount = SapiContext.getInstance(confignation.context).getCurrentAccount();
            jSONObject.put("bduss_sign", MD5Util.toMd5((currentAccount == null ? "" : currentAccount.bduss).getBytes(), false));
            jSONObject.put("pkgname", str);
            jSONObject.put("key_hash", packageSign2);
            jSONObject.put(Constants.APP_ID, str2);
        } catch (JSONException e) {
            Log.e(e);
        }
        String md5 = MD5Util.toMd5(("as#JU*342ns" + str2 + "#$FW34sfs").getBytes(), false);
        try {
            return SapiDeviceUtils.DeviceCrypto.base64Encode(new AES().encrypt(jSONObject.toString(), new StringBuffer(md5.substring(md5.length() - 16, md5.length())).reverse().toString(), md5.substring(0, 16)));
        } catch (Exception e2) {
            Log.e(e2);
            return "";
        }
    }
}
