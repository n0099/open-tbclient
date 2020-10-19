package com.baidu.android.imrtc.request;

import android.content.Context;
import com.baidu.android.imrtc.request.HttpExecutor;
import com.baidu.android.imsdk.utils.HttpHelper;
import java.util.Map;
/* loaded from: classes18.dex */
public abstract class BaseHttpRequest implements HttpExecutor.HttpRequest, HttpExecutor.ResponseHandler {
    protected Context mContext;

    @Override // com.baidu.android.imrtc.request.HttpExecutor.HttpRequest
    public abstract Map<String, String> getHeaders();

    @Override // com.baidu.android.imrtc.request.HttpExecutor.HttpRequest
    public abstract String getHost();

    @Override // com.baidu.android.imrtc.request.HttpExecutor.HttpRequest
    public String getMethod() {
        return "POST";
    }

    @Override // com.baidu.android.imrtc.request.HttpExecutor.HttpRequest
    public String getMediaType() {
        return HttpHelper.CONTENT_JSON;
    }
}
