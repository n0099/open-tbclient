package com.baidu.searchbox.http.callback;

import okhttp3.Response;
/* loaded from: classes2.dex */
public abstract class DefaultResponseCallback extends ResponseCallback<Response> {
    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.searchbox.http.callback.ResponseCallback
    public Response parseResponse(Response response, int i) throws Exception {
        return response;
    }
}
