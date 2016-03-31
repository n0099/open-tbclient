package com.baidu.tbadk.core.util;

import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class aw {
    private List<Object> acf = new ArrayList();
    private String key;

    public List<Object> wr() {
        return this.acf;
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
        this.acf.add(str);
        this.acf.add(str2);
        return this;
    }

    public aw r(String str, int i) {
        this.acf.add(str);
        this.acf.add(Integer.valueOf(i));
        return this;
    }
}
