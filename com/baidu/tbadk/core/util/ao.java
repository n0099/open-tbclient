package com.baidu.tbadk.core.util;

import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class ao {
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

    public ao() {
    }

    public ao(String str) {
        this.key = str;
    }

    public ao dk(String str, String str2) {
        this.params.add(str);
        this.params.add(str2);
        return this;
    }

    public ao ag(String str, int i) {
        this.params.add(str);
        this.params.add(Integer.valueOf(i));
        return this;
    }

    public ao s(String str, long j) {
        this.params.add(str);
        this.params.add(Long.valueOf(j));
        return this;
    }

    private void aN(List<Object> list) {
        this.params = list;
    }

    public void delete(String str) {
        int indexOf;
        if (!ar.isEmpty(str) && (indexOf = this.params.indexOf(str)) >= 0 && this.params.size() > indexOf + 1) {
            this.params.remove(indexOf);
            this.params.remove(indexOf);
        }
    }

    public boolean wG(String str) {
        int indexOf;
        return !ar.isEmpty(str) && (indexOf = this.params.indexOf(str)) >= 0 && this.params.size() > indexOf + 1;
    }

    public ao aWM() {
        ao aoVar = new ao(getKey());
        aoVar.aN(getParams());
        return aoVar;
    }

    public void aWN() {
        TiebaStatic.log(this);
    }

    public static ao wH(String str) {
        return new ao(str);
    }

    public String toString() {
        return "StatisticItem{key='" + this.key + "', position=" + this.position + ", params=" + this.params + '}';
    }
}
