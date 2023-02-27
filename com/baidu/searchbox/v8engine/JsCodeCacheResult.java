package com.baidu.searchbox.v8engine;
/* loaded from: classes3.dex */
public class JsCodeCacheResult {
    public final String businessId;
    public final boolean isCacheUsed;
    public final String jsPath;

    public JsCodeCacheResult(String str, String str2, boolean z) {
        this.businessId = str;
        this.jsPath = str2;
        this.isCacheUsed = z;
    }

    public String toString() {
        return "JsCodeCacheResult{businessId='" + this.businessId + "', jsPath='" + this.jsPath + "', isCacheUsed=" + this.isCacheUsed + '}';
    }
}
