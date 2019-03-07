package com.baidu.tbadk.core.util;

import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class am {
    private String key;
    private List<Object> params = new ArrayList();
    private int position;

    public List<Object> getParams() {
        return this.params;
    }

    public String getKey() {
        return this.key;
    }

    public void setPosition(int i) {
        this.position = i;
    }

    public int getPosition() {
        return this.position;
    }

    public am() {
    }

    public am(String str) {
        this.key = str;
    }

    public am bJ(String str, String str2) {
        this.params.add(str);
        this.params.add(str2);
        return this;
    }

    public am T(String str, int i) {
        this.params.add(str);
        this.params.add(Integer.valueOf(i));
        return this;
    }

    public am k(String str, long j) {
        this.params.add(str);
        this.params.add(Long.valueOf(j));
        return this;
    }

    private void U(List<Object> list) {
        this.params = list;
    }

    public void delete(String str) {
        int indexOf;
        if (!ap.isEmpty(str) && (indexOf = this.params.indexOf(str)) >= 0 && this.params.size() > indexOf + 1) {
            this.params.remove(indexOf);
            this.params.remove(indexOf);
        }
    }

    public am adj() {
        am amVar = new am(getKey());
        amVar.U(getParams());
        return amVar;
    }
}
