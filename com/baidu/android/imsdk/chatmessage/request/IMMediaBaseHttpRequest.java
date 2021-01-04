package com.baidu.android.imsdk.chatmessage.request;

import com.baidu.android.imsdk.account.AccountManager;
import com.baidu.android.imsdk.account.AccountManagerImpl;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.imsdk.internal.IMConfigInternal;
import com.baidu.android.imsdk.utils.BaseHttpRequest;
import com.baidu.android.imsdk.utils.Utility;
import com.baidu.ar.constants.HttpConstants;
import com.baidu.sapi2.SapiContext;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeSet;
import org.apache.http.cookie.SM;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
abstract class IMMediaBaseHttpRequest extends BaseHttpRequest {
    private static final String TAG = "IMMediaBaseHttpRequest";

    @Override // com.baidu.android.imsdk.utils.BaseHttpRequest, com.baidu.android.imsdk.utils.HttpHelper.Request
    public Map<String, String> getHeaders() {
        HashMap hashMap = new HashMap();
        hashMap.put(SM.COOKIE, "BDUSS=" + IMConfigInternal.getInstance().getIMConfig(this.mContext).getBduss(this.mContext));
        return hashMap;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public String getHostUrl() {
        switch (Utility.readIntData(this.mContext, Constants.KEY_ENV, 0)) {
            case 0:
                return "https://pim.baidu.com/";
            case 1:
                return "http://rd-im-server.bcc-szth.baidu.com:8111/";
            case 2:
                return Constants.URL_HTTP_QA;
            case 3:
                return Constants.URL_HTTP_BOX;
            default:
                return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public String generateSign(JSONObject jSONObject) throws NoSuchAlgorithmException {
        if (jSONObject == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        TreeSet<String> treeSet = new TreeSet();
        Iterator<String> keys = jSONObject.keys();
        while (keys.hasNext()) {
            treeSet.add(keys.next());
        }
        for (String str : treeSet) {
            sb.append(str);
            sb.append("=");
            sb.append(jSONObject.opt(str));
        }
        return getMd5(sb.toString());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public JSONObject putCommonParams(JSONObject jSONObject) throws JSONException {
        jSONObject.put("appid", AccountManager.getAppid(this.mContext));
        jSONObject.put("timestamp", System.currentTimeMillis() / 1000);
        jSONObject.put("app_version", AccountManagerImpl.getInstance(this.mContext).getAppVersion());
        jSONObject.put(SapiContext.KEY_SDK_VERSION, IMConfigInternal.getInstance().getSDKVersionValue(this.mContext));
        jSONObject.put(HttpConstants.DEVICE_TYPE, 2);
        jSONObject.put("cuid", Utility.getDeviceId(this.mContext));
        jSONObject.put("origin_id", Utility.getTriggerId(this.mContext));
        return jSONObject;
    }

    @Override // com.baidu.android.imsdk.utils.BaseHttpRequest, com.baidu.android.imsdk.utils.HttpHelper.Request
    public String getMethod() {
        return "POST";
    }

    @Override // com.baidu.android.imsdk.utils.HttpHelper.Request
    public boolean shouldAbort() {
        return !AccountManager.getMediaRole(this.mContext) || AccountManager.isCuidLogin(this.mContext);
    }
}
