package com.baidu.tbadk.core.util;

import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class aw {
    private String key;
    private List<Object> params = new ArrayList();

    public List<Object> getParams() {
        return this.params;
    }

    public String getKey() {
        return this.key;
    }

    public aw() {
    }

    public aw(String str) {
        this.key = str;
    }

    public aw ac(String str, String str2) {
        this.params.add(str);
        this.params.add(str2);
        return this;
    }

    public aw s(String str, int i) {
        this.params.add(str);
        this.params.add(Integer.valueOf(i));
        return this;
    }
}
