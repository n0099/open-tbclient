package com.baidu.searchbox.http.callback;

import java.io.IOException;
import okhttp3.Response;
import okhttp3.ResponseBody;
/* loaded from: classes13.dex */
public abstract class ByteResponseCallback extends ResponseCallback<byte[]> {
    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.searchbox.http.callback.ResponseCallback
    public byte[] parseResponse(Response response, int i) throws Exception {
        ResponseBody body = response.body();
        if (body != null) {
            return body.bytes();
        }
        throw new IOException("not get response body, status is " + i);
    }
}
