package com.baidu.down.common.intercepter;

import com.baidu.android.imsdk.utils.HanziToPinyin;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes5.dex */
public final class ResponseInfo {
    public String method;
    public Map<String, String> requestHeaders;
    public Map<String, String> responseHeaders;
    public int stateCode;
    public String url;

    public ResponseInfo(String str, String str2, int i) {
        this.method = null;
        this.url = null;
        this.stateCode = 200;
        this.requestHeaders = null;
        this.responseHeaders = null;
        this.method = str;
        this.url = str2;
        this.stateCode = i;
        this.requestHeaders = new HashMap();
        this.responseHeaders = new HashMap();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(this.method + HanziToPinyin.Token.SEPARATOR + this.stateCode + HanziToPinyin.Token.SEPARATOR + this.url + "\n");
        for (String str : this.requestHeaders.keySet()) {
            sb.append(str);
            sb.append(":");
            sb.append(this.requestHeaders.get(str));
            sb.append("\n");
        }
        sb.append("=== Response ===\n");
        for (String str2 : this.responseHeaders.keySet()) {
            sb.append(str2);
            sb.append(":");
            sb.append(this.responseHeaders.get(str2));
            sb.append("\n");
        }
        return sb.toString();
    }
}
