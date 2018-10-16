package com.baidu.searchbox.http.callback;

import java.io.IOException;
import okhttp3.Response;
import okhttp3.ResponseBody;
/* loaded from: classes2.dex */
public abstract class StringResponseCallback extends ResponseCallback<String> {
    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.searchbox.http.callback.ResponseCallback
    public String parseResponse(Response response, int i) throws Exception {
        ResponseBody body = response.body();
        if (body != null) {
            return body.string();
        }
        throw new IOException("not get response body, status is " + i);
    }
}
