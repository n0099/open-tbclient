package com.baidu.android.imsdk.mcast;

import com.baidu.android.imsdk.internal.IMConfigInternal;
import com.baidu.android.imsdk.utils.BaseHttpRequest;
import java.util.HashMap;
import java.util.Map;
import org.apache.http.cookie.SM;
/* loaded from: classes9.dex */
public abstract class FileMessageHttpRequest extends BaseHttpRequest {
    @Override // com.baidu.android.imsdk.utils.BaseHttpRequest, com.baidu.android.imsdk.utils.HttpHelper.Request
    public Map<String, String> getHeaders() {
        HashMap hashMap = new HashMap();
        hashMap.put(SM.COOKIE, "BDUSS=" + IMConfigInternal.getInstance().getIMConfig(this.mContext).getBduss(this.mContext));
        return hashMap;
    }

    @Override // com.baidu.android.imsdk.utils.BaseHttpRequest, com.baidu.android.imsdk.utils.HttpHelper.Request
    public String getMethod() {
        return "GET";
    }
}
