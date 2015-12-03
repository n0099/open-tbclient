package com.baidu.tbadk.core.util;

import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class av {
    private List<Object> abS = new ArrayList();
    private String key;

    public List<Object> vj() {
        return this.abS;
    }

    public String getKey() {
        return this.key;
    }

    public av(String str) {
        this.key = str;
    }

    public av ab(String str, String str2) {
        this.abS.add(str);
        this.abS.add(str2);
        return this;
    }

    public av r(String str, int i) {
        this.abS.add(str);
        this.abS.add(Integer.valueOf(i));
        return this;
    }
}
