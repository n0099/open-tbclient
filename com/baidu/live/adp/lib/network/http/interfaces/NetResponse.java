package com.baidu.live.adp.lib.network.http.interfaces;

import java.util.List;
import java.util.Map;
/* loaded from: classes11.dex */
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
}
