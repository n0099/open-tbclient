package com.baidu.tbadk.core.util;

import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class aq {
    private List<Object> aba = new ArrayList();
    private String key;

    public List<Object> uz() {
        return this.aba;
    }

    public String getKey() {
        return this.key;
    }

    public aq(String str) {
        this.key = str;
    }

    public aq ae(String str, String str2) {
        this.aba.add(str);
        this.aba.add(str2);
        return this;
    }

    public aq r(String str, int i) {
        this.aba.add(str);
        this.aba.add(Integer.valueOf(i));
        return this;
    }
}
