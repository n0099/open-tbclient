package com.baidu.android.imsdk.pubaccount.request;

import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.imsdk.internal.IMConfigInternal;
import com.baidu.android.imsdk.utils.BaseHttpRequest;
import com.baidu.android.imsdk.utils.Utility;
import java.util.HashMap;
import java.util.Map;
import org.apache.http.cookie.SM;
/* loaded from: classes3.dex */
public abstract class PaBaseHttpRequest extends BaseHttpRequest {
    protected int mOsType = 1;

    @Override // com.baidu.android.imsdk.utils.BaseHttpRequest, com.baidu.android.imsdk.utils.HttpHelper.Request
    public Map<String, String> getHeaders() {
        HashMap hashMap = new HashMap();
        hashMap.put(SM.COOKIE, "BDUSS=" + IMConfigInternal.getInstance().getIMConfig(this.mContext).getBduss(this.mContext));
        return hashMap;
    }

    @Override // com.baidu.android.imsdk.utils.BaseHttpRequest, com.baidu.android.imsdk.utils.HttpHelper.Request
    public String getHost() {
        if (getHostUrl() == null) {
            return null;
        }
        return getHostUrl() + "rest/3.0/im/box";
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public String getHostUrl() {
        switch (Utility.readIntData(this.mContext, Constants.KEY_ENV, 0)) {
            case 0:
                return "https://pim.baidu.com/";
            case 1:
                return Constants.URL_HTTP_RD;
            case 2:
                return Constants.URL_HTTP_QA;
            case 3:
                return Constants.URL_HTTP_BOX;
            default:
                return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public String getSignByMd5Error(String str, long j, long j2, String str2) {
        try {
            if (!TextUtils.isEmpty(str2)) {
                if (str2.equals(Constants.ERROR_MSG_MD5_NULL)) {
                    str2 = j + str.substring(0, 28) + j2;
                } else if (str2.equals(Constants.ERROR_MSG_MD5_EMPTY)) {
                    str2 = j + str.substring(0, 24) + j2;
                }
            } else {
                str2 = j + str.substring(0, 20) + j2;
            }
            return str2;
        } catch (Exception e) {
            return "" + j + j2;
        }
    }
}
