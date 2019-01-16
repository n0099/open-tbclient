package com.baidu.tbadk.core.util;

import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class am {
    private String key;
    private List<Object> params = new ArrayList();

    public List<Object> getParams() {
        return this.params;
    }

    public String getKey() {
        return this.key;
    }

    public am() {
    }

    public am(String str) {
        this.key = str;
    }

    public am aB(String str, String str2) {
        this.params.add(str);
        this.params.add(str2);
        return this;
    }

    public am y(String str, int i) {
        this.params.add(str);
        this.params.add(Integer.valueOf(i));
        return this;
    }

    public am i(String str, long j) {
        this.params.add(str);
        this.params.add(Long.valueOf(j));
        return this;
    }

    private void J(List<Object> list) {
        this.params = list;
    }

    public void delete(String str) {
        int indexOf;
        if (!ao.isEmpty(str) && (indexOf = this.params.indexOf(str)) >= 0 && this.params.size() > indexOf + 1) {
            this.params.remove(indexOf);
            this.params.remove(indexOf);
        }
    }

    public am DY() {
        am amVar = new am(getKey());
        amVar.J(getParams());
        return amVar;
    }
}
