package com.baidu.live.tbadk.statics;

import java.util.HashMap;
import java.util.Map;
/* loaded from: classes11.dex */
public class AlaStaticItem {
    private String mKey;
    private Map<String, String> mParams = new HashMap();

    public AlaStaticItem(String str) {
        this.mKey = str;
    }

    public AlaStaticItem addParams(String str, String str2) {
        this.mParams.put(str, str2);
        return this;
    }

    public AlaStaticItem addParams(String str, int i) {
        this.mParams.put(str, String.valueOf(i));
        return this;
    }

    public AlaStaticItem addParams(String str, long j) {
        this.mParams.put(str, String.valueOf(j));
        return this;
    }

    public AlaStaticItem addParams(String str, double d) {
        this.mParams.put(str, String.valueOf(d));
        return this;
    }

    public Map<String, String> getParams() {
        return this.mParams;
    }

    public String getKey() {
        return this.mKey;
    }
}
