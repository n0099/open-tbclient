package com.baidu.android.imsdk.shield.request;

import android.content.Context;
import com.baidu.android.imsdk.account.AccountManager;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.imsdk.internal.IMConfigInternal;
import com.baidu.android.imsdk.utils.BaseHttpRequest;
import com.baidu.android.imsdk.utils.LogUtils;
import com.baidu.android.imsdk.utils.Utility;
import com.baidu.webkit.internal.utils.ZeusInitConfigUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public abstract class IMSubscriptionBaseRequest extends BaseHttpRequest {
    public static final String TAG = "IMSubscriptionBaseRequest";
    public String mKey;
    public List<String> mMiNiAppTopicList;
    public long mPaid;
    public String mSource;
    public List<Long> mTopicList;

    public IMSubscriptionBaseRequest(Context context, long j, List<Long> list, List<String> list2, String str, String str2) {
        if (list != null && list.size() > 0) {
            this.mTopicList = new ArrayList(list);
        }
        if (list2 != null && list2.size() > 0) {
            this.mMiNiAppTopicList = new ArrayList(list2);
        }
        this.mContext = context;
        this.mPaid = j;
        this.mKey = str;
        this.mSource = str2;
    }

    private String getHostUrl() {
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

    @Override // com.baidu.android.imsdk.utils.HttpHelper.Request
    public String getContentType() {
        return "application/json";
    }

    @Override // com.baidu.android.imsdk.utils.BaseHttpRequest, com.baidu.android.imsdk.utils.HttpHelper.Request
    public Map<String, String> getHeaders() {
        HashMap hashMap = new HashMap();
        hashMap.put("Cookie", "BDUSS=" + IMConfigInternal.getInstance().getIMConfig(this.mContext).getBduss(this.mContext));
        hashMap.put("Content-Type", "application/json");
        return hashMap;
    }

    @Override // com.baidu.android.imsdk.utils.BaseHttpRequest, com.baidu.android.imsdk.utils.HttpHelper.Request
    public String getHost() {
        if (getHostUrl() == null) {
            return null;
        }
        return getHostUrl() + "rest/3.0/im/subscription?method=" + getHostUrlParam();
    }

    public abstract String getHostUrlParam();

    @Override // com.baidu.android.imsdk.utils.BaseHttpRequest, com.baidu.android.imsdk.utils.HttpHelper.Request
    public String getMethod() {
        return "POST";
    }

    @Override // com.baidu.android.imsdk.utils.BaseHttpRequest, com.baidu.android.imsdk.utils.HttpHelper.Request
    public byte[] getRequestParameter() {
        try {
            long appid = AccountManager.getAppid(this.mContext);
            long currentTimeMillis = System.currentTimeMillis() / 1000;
            long uk = AccountManager.getUK(this.mContext);
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("appid", appid);
            jSONObject.put("timestamp", currentTimeMillis);
            jSONObject.put("cuid", Utility.getDeviceId(this.mContext));
            jSONObject.put("device_type", 2);
            jSONObject.put("app_version", Utility.getAppVersionName(this.mContext));
            jSONObject.put(ZeusInitConfigUtils.PREF_KEY_SDK_VERSION, IMConfigInternal.getInstance().getSDKVersionValue(this.mContext));
            jSONObject.put("uk", uk);
            if (this.mTopicList != null && this.mTopicList.size() > 0) {
                JSONArray jSONArray = new JSONArray();
                for (Long l : this.mTopicList) {
                    jSONArray.put(l.longValue());
                }
                jSONObject.put("topic_id", jSONArray);
            }
            if (this.mMiNiAppTopicList != null && this.mMiNiAppTopicList.size() > 0) {
                JSONArray jSONArray2 = new JSONArray();
                for (String str : this.mMiNiAppTopicList) {
                    jSONArray2.put(str);
                }
                jSONObject.put("fminapp_topic", jSONArray2);
            }
            jSONObject.put("pa_uid", this.mPaid);
            jSONObject.put("source", this.mSource);
            jSONObject.put("sign", getMd5(String.valueOf(appid) + uk + currentTimeMillis));
            jSONObject.put("account_type", AccountManager.isCuidLogin(this.mContext) ? 1 : 0);
            LogUtils.d(TAG, "IMSubscriptionBaseRequest msg :" + jSONObject.toString());
            return jSONObject.toString().getBytes();
        } catch (Exception e2) {
            LogUtils.e(TAG, "IMSubscriptionBaseRequest getRequestParameter exception", e2);
            return null;
        }
    }

    @Override // com.baidu.android.imsdk.utils.HttpHelper.Request
    public boolean shouldAbort() {
        return false;
    }
}
