package com.baidu.tbadk.core.util;

import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class ao {
    private List<Object> aaR = new ArrayList();
    private String key;

    public List<Object> uy() {
        return this.aaR;
    }

    public String getKey() {
        return this.key;
    }

    public ao(String str) {
        this.key = str;
    }

    public ao af(String str, String str2) {
        this.aaR.add(str);
        this.aaR.add(str2);
        return this;
    }

    public ao r(String str, int i) {
        this.aaR.add(str);
        this.aaR.add(Integer.valueOf(i));
        return this;
    }
}
