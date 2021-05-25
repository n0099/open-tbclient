package com.baidu.android.imsdk.shield.request;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.imsdk.internal.IMConfigInternal;
import com.baidu.android.imsdk.utils.BaseHttpRequest;
import com.baidu.android.imsdk.utils.Utility;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes.dex */
public abstract class IMSettingBaseHttpRequest extends BaseHttpRequest {
    @Override // com.baidu.android.imsdk.utils.BaseHttpRequest, com.baidu.android.imsdk.utils.HttpHelper.Request
    public Map<String, String> getHeaders() {
        HashMap hashMap = new HashMap();
        hashMap.put("Cookie", "BDUSS=" + IMConfigInternal.getInstance().getIMConfig(this.mContext).getBduss(this.mContext));
        return hashMap;
    }

    @Override // com.baidu.android.imsdk.utils.BaseHttpRequest, com.baidu.android.imsdk.utils.HttpHelper.Request
    public String getHost() {
        if (getHostUrl() == null) {
            return null;
        }
        return getHostUrl() + "rest/3.0/im/" + getHostUrlParam();
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
            return "http://rd-im-server.bcc-szth.baidu.com:8080/";
        }
        return "https://pim.baidu.com/";
    }

    public abstract String getHostUrlParam();

    @Override // com.baidu.android.imsdk.utils.BaseHttpRequest, com.baidu.android.imsdk.utils.HttpHelper.Request
    public String getMethod() {
        return "POST";
    }

    @Override // com.baidu.android.imsdk.utils.HttpHelper.Request
    public boolean shouldAbort() {
        return false;
    }
}
