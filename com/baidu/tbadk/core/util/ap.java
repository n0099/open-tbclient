package com.baidu.tbadk.core.util;

import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class ap {
    private List<Object> aaX = new ArrayList();
    private String key;

    public List<Object> uB() {
        return this.aaX;
    }

    public String getKey() {
        return this.key;
    }

    public ap(String str) {
        this.key = str;
    }

    public ap ae(String str, String str2) {
        this.aaX.add(str);
        this.aaX.add(str2);
        return this;
    }

    public ap r(String str, int i) {
        this.aaX.add(str);
        this.aaX.add(Integer.valueOf(i));
        return this;
    }
}
