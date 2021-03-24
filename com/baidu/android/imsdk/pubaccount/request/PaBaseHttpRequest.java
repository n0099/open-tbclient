package com.baidu.android.imsdk.pubaccount.request;

import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.imsdk.internal.IMConfigInternal;
import com.baidu.android.imsdk.utils.BaseHttpRequest;
import com.baidu.android.imsdk.utils.Utility;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes2.dex */
public abstract class PaBaseHttpRequest extends BaseHttpRequest {
    public int mOsType = 1;

    @Override // com.baidu.android.imsdk.utils.BaseHttpRequest, com.baidu.android.imsdk.utils.HttpHelper.Request
    public Map<String, String> getHeaders() {
        HashMap hashMap = new HashMap();
        String bduss = IMConfigInternal.getInstance().getIMConfig(this.mContext).getBduss(this.mContext);
        hashMap.put("Cookie", "BDUSS=" + bduss);
        return hashMap;
    }

    @Override // com.baidu.android.imsdk.utils.BaseHttpRequest, com.baidu.android.imsdk.utils.HttpHelper.Request
    public String getHost() {
        if (getHostUrl() == null) {
            return null;
        }
        return getHostUrl() + "rest/3.0/im/box";
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

    public String getSignByMd5Error(String str, long j, long j2, String str2) {
        try {
            if (!TextUtils.isEmpty(str2)) {
                if (str2.equals(Constants.ERROR_MSG_MD5_NULL)) {
                    return j + str.substring(0, 28) + j2;
                } else if (str2.equals(Constants.ERROR_MSG_MD5_EMPTY)) {
                    return j + str.substring(0, 24) + j2;
                } else {
                    return str2;
                }
            }
            return j + str.substring(0, 20) + j2;
        } catch (Exception unused) {
            return "" + j + j2;
        }
    }
}
