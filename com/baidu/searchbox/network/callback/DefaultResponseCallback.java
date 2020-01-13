package com.baidu.searchbox.network.callback;

import com.baidu.searchbox.network.core.Response;
/* loaded from: classes12.dex */
public abstract class DefaultResponseCallback extends ResponseCallback<Response> {
    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.baidu.searchbox.network.callback.ResponseCallback
    public Response parseResponse(Response response, int i) throws Exception {
        return response;
    }
}
