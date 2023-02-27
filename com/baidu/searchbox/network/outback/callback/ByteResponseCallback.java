package com.baidu.searchbox.network.outback.callback;

import com.baidu.searchbox.network.outback.core.Response;
import com.baidu.searchbox.network.outback.core.ResponseBody;
import java.io.IOException;
/* loaded from: classes2.dex */
public abstract class ByteResponseCallback extends ResponseCallback<byte[]> {
    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.searchbox.network.outback.callback.ResponseCallback
    public byte[] parseResponse(Response response, int i) throws Exception {
        ResponseBody body = response.body();
        if (body != null) {
            return body.bytes();
        }
        throw new IOException("not get response body, status is " + i);
    }
}
