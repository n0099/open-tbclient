package com.baidu.tbadk.core.util;

import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class aq {
    private List<Object> abf = new ArrayList();
    private String key;

    public List<Object> uD() {
        return this.abf;
    }

    public String getKey() {
        return this.key;
    }

    public aq(String str) {
        this.key = str;
    }

    public aq ae(String str, String str2) {
        this.abf.add(str);
        this.abf.add(str2);
        return this;
    }

    public aq r(String str, int i) {
        this.abf.add(str);
        this.abf.add(Integer.valueOf(i));
        return this;
    }
}
