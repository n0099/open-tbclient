package com.baidu.tbadk.core.util;

import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class ar {
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

    public ar() {
    }

    public ar(String str) {
        this.key = str;
    }

    public ar dR(String str, String str2) {
        this.params.add(str);
        this.params.add(str2);
        return this;
    }

    public ar ap(String str, int i) {
        this.params.add(str);
        this.params.add(Integer.valueOf(i));
        return this;
    }

    public ar v(String str, long j) {
        this.params.add(str);
        this.params.add(Long.valueOf(j));
        return this;
    }

    public ar c(String str, double d) {
        this.params.add(str);
        this.params.add(Double.valueOf(d));
        return this;
    }

    private void bz(List<Object> list) {
        this.params = list;
    }

    public void delete(String str) {
        int indexOf;
        if (!au.isEmpty(str) && (indexOf = this.params.indexOf(str)) >= 0 && this.params.size() > indexOf + 1) {
            this.params.remove(indexOf);
            this.params.remove(indexOf);
        }
    }

    public boolean Bc(String str) {
        int indexOf;
        return !au.isEmpty(str) && (indexOf = this.params.indexOf(str)) >= 0 && this.params.size() > indexOf + 1;
    }

    public ar bsN() {
        ar arVar = new ar(getKey());
        arVar.bz(getParams());
        return arVar;
    }

    public void bsO() {
        TiebaStatic.log(this);
    }

    public static ar Bd(String str) {
        return new ar(str);
    }

    public String toString() {
        return "StatisticItem{key='" + this.key + "', position=" + this.position + ", params=" + this.params + '}';
    }
}
