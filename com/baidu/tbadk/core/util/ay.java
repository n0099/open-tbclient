package com.baidu.tbadk.core.util;

import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class ay {
    private String key;
    private List<Object> params = new ArrayList();

    public List<Object> getParams() {
        return this.params;
    }

    public String getKey() {
        return this.key;
    }

    public ay() {
    }

    public ay(String str) {
        this.key = str;
    }

    public ay ab(String str, String str2) {
        this.params.add(str);
        this.params.add(str2);
        return this;
    }

    public ay s(String str, int i) {
        this.params.add(str);
        this.params.add(Integer.valueOf(i));
        return this;
    }

    public ay g(String str, long j) {
        this.params.add(str);
        this.params.add(Long.valueOf(j));
        return this;
    }

    public void dt(String str) {
        int indexOf;
        if (!ba.isEmpty(str) && (indexOf = this.params.indexOf(str)) >= 0 && this.params.size() > indexOf + 1) {
            this.params.remove(indexOf);
            this.params.remove(indexOf);
        }
    }
}
