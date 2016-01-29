package com.baidu.tbadk.core.util;

import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class au {
    private List<Object> acS = new ArrayList();
    private String key;

    public List<Object> vY() {
        return this.acS;
    }

    public String getKey() {
        return this.key;
    }

    public au() {
    }

    public au(String str) {
        this.key = str;
    }

    public au aa(String str, String str2) {
        this.acS.add(str);
        this.acS.add(str2);
        return this;
    }

    public au r(String str, int i) {
        this.acS.add(str);
        this.acS.add(Integer.valueOf(i));
        return this;
    }
}
