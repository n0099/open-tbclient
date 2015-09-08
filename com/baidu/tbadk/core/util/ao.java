package com.baidu.tbadk.core.util;

import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class ao {
    private List<Object> aba = new ArrayList();
    private String key;

    public List<Object> uD() {
        return this.aba;
    }

    public String getKey() {
        return this.key;
    }

    public ao(String str) {
        this.key = str;
    }

    public ao af(String str, String str2) {
        this.aba.add(str);
        this.aba.add(str2);
        return this;
    }

    public ao r(String str, int i) {
        this.aba.add(str);
        this.aba.add(Integer.valueOf(i));
        return this;
    }
}
