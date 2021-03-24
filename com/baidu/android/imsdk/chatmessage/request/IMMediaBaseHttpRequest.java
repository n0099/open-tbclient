package com.baidu.android.imsdk.chatmessage.request;

import com.baidu.android.imsdk.account.AccountManager;
import com.baidu.android.imsdk.account.AccountManagerImpl;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.imsdk.internal.IMConfigInternal;
import com.baidu.android.imsdk.utils.BaseHttpRequest;
import com.baidu.android.imsdk.utils.Utility;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeSet;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public abstract class IMMediaBaseHttpRequest extends BaseHttpRequest {
    public static final String TAG = "IMMediaBaseHttpRequest";

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

    @Override // com.baidu.android.imsdk.utils.BaseHttpRequest, com.baidu.android.imsdk.utils.HttpHelper.Request
    public Map<String, String> getHeaders() {
        HashMap hashMap = new HashMap();
        String bduss = IMConfigInternal.getInstance().getIMConfig(this.mContext).getBduss(this.mContext);
        hashMap.put("Cookie", "BDUSS=" + bduss);
        return hashMap;
    }

    public String getHostUrl() {
        int readIntData = Utility.readIntData(this.mContext, Constants.KEY_ENV, 0);
        if (readIntData != 0) {
            if (readIntData != 1) {
                if (readIntData != 2) {
                    if (readIntData != 3) {
                        return null;
                    }
                    return Constants.URL_HTTP_BOX;
                }
                return Constants.URL_HTTP_QA;
            }
            return "http://rd-im-server.bcc-szth.baidu.com:8111/";
        }
        return "https://pim.baidu.com/";
    }

    @Override // com.baidu.android.imsdk.utils.BaseHttpRequest, com.baidu.android.imsdk.utils.HttpHelper.Request
    public String getMethod() {
        return "POST";
    }

    public JSONObject putCommonParams(JSONObject jSONObject) throws JSONException {
        jSONObject.put("appid", AccountManager.getAppid(this.mContext));
        jSONObject.put("timestamp", System.currentTimeMillis() / 1000);
        jSONObject.put("app_version", AccountManagerImpl.getInstance(this.mContext).getAppVersion());
        jSONObject.put("sdk_version", IMConfigInternal.getInstance().getSDKVersionValue(this.mContext));
        jSONObject.put("device_type", 2);
        jSONObject.put("cuid", Utility.getDeviceId(this.mContext));
        jSONObject.put("origin_id", Utility.getTriggerId(this.mContext));
        return jSONObject;
    }

    @Override // com.baidu.android.imsdk.utils.HttpHelper.Request
    public boolean shouldAbort() {
        return !AccountManager.getMediaRole(this.mContext) || AccountManager.isCuidLogin(this.mContext);
    }
}
