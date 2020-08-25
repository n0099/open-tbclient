package com.baidu.tbadk.core.util;

import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
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

    public aq dD(String str, String str2) {
        this.params.add(str);
        this.params.add(str2);
        return this;
    }

    public aq ai(String str, int i) {
        this.params.add(str);
        this.params.add(Integer.valueOf(i));
        return this;
    }

    public aq u(String str, long j) {
        this.params.add(str);
        this.params.add(Long.valueOf(j));
        return this;
    }

    private void aV(List<Object> list) {
        this.params = list;
    }

    public void delete(String str) {
        int indexOf;
        if (!at.isEmpty(str) && (indexOf = this.params.indexOf(str)) >= 0 && this.params.size() > indexOf + 1) {
            this.params.remove(indexOf);
            this.params.remove(indexOf);
        }
    }

    public boolean Ac(String str) {
        int indexOf;
        return !at.isEmpty(str) && (indexOf = this.params.indexOf(str)) >= 0 && this.params.size() > indexOf + 1;
    }

    public aq bjm() {
        aq aqVar = new aq(getKey());
        aqVar.aV(getParams());
        return aqVar;
    }

    public void bjn() {
        TiebaStatic.log(this);
    }

    public static aq Ad(String str) {
        return new aq(str);
    }

    public String toString() {
        return "StatisticItem{key='" + this.key + "', position=" + this.position + ", params=" + this.params + '}';
    }
}
