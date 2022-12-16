package com.baidu.android.imsdk.shield.request;

import android.content.Context;
import com.baidu.android.imsdk.account.AccountManager;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.imsdk.internal.IMConfigInternal;
import com.baidu.android.imsdk.utils.BaseHttpRequest;
import com.baidu.android.imsdk.utils.LogUtils;
import com.baidu.android.imsdk.utils.Utility;
import com.baidu.ar.constants.HttpConstants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public abstract class IMSubscriptionBaseRequest extends BaseHttpRequest {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String TAG = "IMSubscriptionBaseRequest";
    public transient /* synthetic */ FieldHolder $fh;
    public boolean ignoreUk;
    public String mKey;
    public List<String> mMiNiAppTopicList;
    public long mPaid;
    public String mSource;
    public List<Long> mTopicList;

    @Override // com.baidu.android.imsdk.utils.HttpHelper.Request
    public String getContentType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? "application/json" : (String) invokeV.objValue;
    }

    public abstract String getHostUrlParam();

    @Override // com.baidu.android.imsdk.utils.BaseHttpRequest, com.baidu.android.imsdk.utils.HttpHelper.Request
    public String getMethod() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? "POST" : (String) invokeV.objValue;
    }

    @Override // com.baidu.android.imsdk.utils.HttpHelper.Request
    public boolean shouldAbort() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    public IMSubscriptionBaseRequest(Context context, long j, List<Long> list, List<String> list2, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, Long.valueOf(j), list, list2, str, str2};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
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
        this.ignoreUk = false;
    }

    private String getHostUrl() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, this)) == null) {
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
                return Constants.URL_HTTP_RD_8111;
            }
            return "https://pim.baidu.com/";
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.android.imsdk.utils.BaseHttpRequest, com.baidu.android.imsdk.utils.HttpHelper.Request
    public Map<String, String> getHeaders() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            HashMap hashMap = new HashMap();
            hashMap.put("Cookie", "BDUSS=" + IMConfigInternal.getInstance().getIMConfig(this.mContext).getBduss(this.mContext));
            hashMap.put("Content-Type", "application/json");
            return hashMap;
        }
        return (Map) invokeV.objValue;
    }

    @Override // com.baidu.android.imsdk.utils.BaseHttpRequest, com.baidu.android.imsdk.utils.HttpHelper.Request
    public String getHost() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            if (getHostUrl() == null) {
                return null;
            }
            return getHostUrl() + "rest/3.0/im/subscription?method=" + getHostUrlParam();
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.android.imsdk.utils.BaseHttpRequest, com.baidu.android.imsdk.utils.HttpHelper.Request
    public byte[] getRequestParameter() {
        InterceptResult invokeV;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            try {
                long appid = AccountManager.getAppid(this.mContext);
                long currentTimeMillis = System.currentTimeMillis() / 1000;
                long uk = AccountManager.getUK(this.mContext);
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("appid", appid);
                jSONObject.put("timestamp", currentTimeMillis);
                jSONObject.put("cuid", Utility.getDeviceId(this.mContext));
                jSONObject.put(HttpConstants.DEVICE_TYPE, 2);
                jSONObject.put("app_version", Utility.getAppVersionName(this.mContext));
                jSONObject.put("sdk_version", IMConfigInternal.getInstance().getSDKVersionValue(this.mContext));
                if (!this.ignoreUk) {
                    jSONObject.put("uk", uk);
                }
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
                jSONObject.put(Constants.EXTRA_PAUID_TYPE, this.mPaid);
                jSONObject.put("source", this.mSource);
                if (this.ignoreUk) {
                    jSONObject.put("sign", getMd5(String.valueOf(appid) + currentTimeMillis));
                } else {
                    jSONObject.put("sign", getMd5(String.valueOf(appid) + uk + currentTimeMillis));
                }
                if (AccountManager.isCuidLogin(this.mContext)) {
                    i = 1;
                } else {
                    i = 0;
                }
                jSONObject.put("account_type", i);
                LogUtils.d(TAG, "IMSubscriptionBaseRequest msg :" + jSONObject.toString());
                return jSONObject.toString().getBytes();
            } catch (Exception e) {
                LogUtils.e(TAG, "IMSubscriptionBaseRequest getRequestParameter exception", e);
                return null;
            }
        }
        return (byte[]) invokeV.objValue;
    }

    public void setIgnoreUk(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048582, this, z) == null) {
            this.ignoreUk = z;
        }
    }
}
