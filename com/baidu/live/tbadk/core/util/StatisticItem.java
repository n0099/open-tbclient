package com.baidu.live.tbadk.core.util;

import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public class StatisticItem {
    private String key;
    private List<Object> params = new ArrayList();

    public List<Object> getParams() {
        return this.params;
    }

    public String getKey() {
        return this.key;
    }

    public StatisticItem() {
    }

    public StatisticItem(String str) {
        this.key = str;
    }

    public StatisticItem param(String str, String str2) {
        this.params.add(str);
        this.params.add(str2);
        return this;
    }

    public StatisticItem param(String str, int i) {
        this.params.add(str);
        this.params.add(Integer.valueOf(i));
        return this;
    }

    public StatisticItem param(String str, long j) {
        this.params.add(str);
        this.params.add(Long.valueOf(j));
        return this;
    }

    public StatisticItem param(String str, double d) {
        this.params.add(str);
        this.params.add(Double.valueOf(d));
        return this;
    }

    public StatisticItem key(String str) {
        this.key = str;
        return this;
    }

    public void delete(String str) {
        int indexOf;
        if (!StringHelper.isEmpty(str) && (indexOf = this.params.indexOf(str)) >= 0 && this.params.size() > indexOf + 1) {
            this.params.remove(indexOf);
            this.params.remove(indexOf);
        }
    }
}
