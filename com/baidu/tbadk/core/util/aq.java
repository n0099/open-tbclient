package com.baidu.tbadk.core.util;

import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class aq {
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

    public aq() {
    }

    public aq(String str) {
        this.key = str;
    }

    public aq dX(String str, String str2) {
        this.params.add(str);
        this.params.add(str2);
        return this;
    }

    public aq an(String str, int i) {
        this.params.add(str);
        this.params.add(Integer.valueOf(i));
        return this;
    }

    public aq w(String str, long j) {
        this.params.add(str);
        this.params.add(Long.valueOf(j));
        return this;
    }

    public aq c(String str, double d) {
        this.params.add(str);
        this.params.add(Double.valueOf(d));
        return this;
    }

    private void bE(List<Object> list) {
        this.params = list;
    }

    public void delete(String str) {
        int indexOf;
        if (!at.isEmpty(str) && (indexOf = this.params.indexOf(str)) >= 0 && this.params.size() > indexOf + 1) {
            this.params.remove(indexOf);
            this.params.remove(indexOf);
        }
    }

    public boolean BX(String str) {
        int indexOf;
        return !at.isEmpty(str) && (indexOf = this.params.indexOf(str)) >= 0 && this.params.size() > indexOf + 1;
    }

    public aq bwm() {
        aq aqVar = new aq(getKey());
        aqVar.bE(getParams());
        return aqVar;
    }

    public void bwn() {
        TiebaStatic.log(this);
    }

    public static aq BY(String str) {
        return new aq(str);
    }

    public String toString() {
        return "StatisticItem{key='" + this.key + "', position=" + this.position + ", params=" + this.params + '}';
    }
}
