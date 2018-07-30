package com.baidu.tbadk.core.util;

import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class an {
    private String key;
    private List<Object> params = new ArrayList();

    public List<Object> getParams() {
        return this.params;
    }

    public String getKey() {
        return this.key;
    }

    public an() {
    }

    public an(String str) {
        this.key = str;
    }

    public an af(String str, String str2) {
        this.params.add(str);
        this.params.add(str2);
        return this;
    }

    public an r(String str, int i) {
        this.params.add(str);
        this.params.add(Integer.valueOf(i));
        return this;
    }

    public an f(String str, long j) {
        this.params.add(str);
        this.params.add(Long.valueOf(j));
        return this;
    }

    public void delete(String str) {
        int indexOf;
        if (!ap.isEmpty(str) && (indexOf = this.params.indexOf(str)) >= 0 && this.params.size() > indexOf + 1) {
            this.params.remove(indexOf);
            this.params.remove(indexOf);
        }
    }
}
