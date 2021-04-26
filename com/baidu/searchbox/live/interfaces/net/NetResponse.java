package com.baidu.searchbox.live.interfaces.net;

import java.util.List;
import java.util.Map;
/* loaded from: classes2.dex */
public class NetResponse {
    public String decodedResponseStr;
    public int downSize;
    public Map<String, List<String>> headers;
    public String realHost;
    public byte[] retBytes;
    public int responseCode = 0;
    public int netErrorCode = 0;
    public String exception = null;
    public String contentEncoding = "";
    public String contentType = "";
    public String contentLength = "";

    public boolean isSuccessful() {
        int i2 = this.responseCode;
        return i2 >= 200 && i2 < 300;
    }
}
