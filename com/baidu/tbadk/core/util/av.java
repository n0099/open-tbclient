package com.baidu.tbadk.core.util;

import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class av {
    private List<Object> acx = new ArrayList();
    private String key;

    public List<Object> uT() {
        return this.acx;
    }

    public String getKey() {
        return this.key;
    }

    public av() {
    }

    public av(String str) {
        this.key = str;
    }

    public av aa(String str, String str2) {
        this.acx.add(str);
        this.acx.add(str2);
        return this;
    }

    public av r(String str, int i) {
        this.acx.add(str);
        this.acx.add(Integer.valueOf(i));
        return this;
    }
}
