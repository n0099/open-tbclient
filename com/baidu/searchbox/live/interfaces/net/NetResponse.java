package com.baidu.searchbox.live.interfaces.net;

import java.util.List;
import java.util.Map;
/* loaded from: classes4.dex */
public class NetResponse {
    public String decodedResponseStr;
    public int downSize;
    public Map<String, List<String>> headers;
    public String realHost;
    public byte[] retBytes;
    public NetStatData statData;
    public String traceid;
    public int responseCode = 0;
    public int netErrorCode = 0;
    public String exception = null;
    public String contentEncoding = "";
    public String contentType = "";
    public String contentLength = "";

    public boolean isSuccessful() {
        int i = this.responseCode;
        if (i >= 200 && i < 300) {
            return true;
        }
        return false;
    }
}
