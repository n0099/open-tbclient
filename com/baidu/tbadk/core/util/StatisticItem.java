package com.baidu.tbadk.core.util;

import d.a.c.e.p.k;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class StatisticItem {
    public String key;
    public List<Object> params = new ArrayList();
    public int position;

    public StatisticItem() {
    }

    public static StatisticItem make(String str) {
        return new StatisticItem(str);
    }

    private void setParams(List<Object> list) {
        this.params = list;
    }

    public StatisticItem addParam(String str, String str2) {
        int index = getIndex(str);
        if (index > 0) {
            this.params.set(index, str2);
            return this;
        }
        return param(str, str2);
    }

    public StatisticItem copy() {
        StatisticItem statisticItem = new StatisticItem(getKey());
        statisticItem.setParams(getParams());
        return statisticItem;
    }

    public void delete(String str) {
        int indexOf;
        if (!k.isEmpty(str) && (indexOf = this.params.indexOf(str)) >= 0 && this.params.size() > indexOf + 1) {
            this.params.remove(indexOf);
            this.params.remove(indexOf);
        }
    }

    public void eventStat() {
        TiebaStatic.log(this);
    }

    public int getContentHashCode() {
        return this.params.hashCode();
    }

    public int getIndex(String str) {
        if (hasParam(str)) {
            return this.params.indexOf(str) + 1;
        }
        return -1;
    }

    public String getKey() {
        return this.key;
    }

    public List<Object> getParams() {
        return this.params;
    }

    public int getPosition() {
        return this.position;
    }

    public boolean hasParam(String str) {
        int indexOf;
        return !k.isEmpty(str) && (indexOf = this.params.indexOf(str)) >= 0 && this.params.size() > indexOf + 1;
    }

    public StatisticItem key(String str) {
        this.key = str;
        return this;
    }

    public StatisticItem param(String str, String str2) {
        this.params.add(str);
        this.params.add(str2);
        return this;
    }

    public void setPosition(int i2) {
        this.position = i2;
    }

    public String toString() {
        return "StatisticItem{key='" + this.key + "', position=" + this.position + ", params=" + this.params + '}';
    }

    public StatisticItem(String str) {
        this.key = str;
    }

    public StatisticItem param(String str, int i2) {
        this.params.add(str);
        this.params.add(Integer.valueOf(i2));
        return this;
    }

    public StatisticItem addParam(String str, int i2) {
        int index = getIndex(str);
        if (index > 0) {
            this.params.set(index, Integer.valueOf(i2));
            return this;
        }
        return param(str, i2);
    }

    public StatisticItem param(String str, long j) {
        this.params.add(str);
        this.params.add(Long.valueOf(j));
        return this;
    }

    public StatisticItem addParam(String str, long j) {
        int index = getIndex(str);
        if (index > 0) {
            this.params.set(index, Long.valueOf(j));
            return this;
        }
        return param(str, j);
    }

    public StatisticItem param(String str, double d2) {
        this.params.add(str);
        this.params.add(Double.valueOf(d2));
        return this;
    }

    public StatisticItem addParam(String str, double d2) {
        int index = getIndex(str);
        if (index > 0) {
            this.params.set(index, Double.valueOf(d2));
            return this;
        }
        return param(str, d2);
    }
}
