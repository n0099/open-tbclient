package com.baidu.searchbox.network.callback;

import com.baidu.searchbox.network.core.Response;
import com.baidu.searchbox.network.core.ResponseBody;
import java.io.IOException;
/* loaded from: classes5.dex */
public abstract class ByteResponseCallback extends ResponseCallback<byte[]> {
    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.searchbox.network.callback.ResponseCallback
    public byte[] parseResponse(Response response, int i) throws Exception {
        ResponseBody body = response.body();
        if (body != null) {
            return body.bytes();
        }
        throw new IOException("not get response body, status is " + i);
    }
}
