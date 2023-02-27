package com.baidu.searchbox.network.outback.support.request;

import com.baidu.searchbox.network.outback.core.Request;
import com.baidu.searchbox.network.outback.support.request.HttpCommonRequestBuilder;
/* loaded from: classes2.dex */
public abstract class HttpCommonRequest<T extends HttpCommonRequestBuilder> extends Request {
    public HttpCommonRequest(T t) {
        super(t);
    }
}
