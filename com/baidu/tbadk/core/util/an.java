package com.baidu.tbadk.core.util;

import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class an {
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

    public an() {
    }

    public an(String str) {
        this.key = str;
    }

    public an cI(String str, String str2) {
        this.params.add(str);
        this.params.add(str2);
        return this;
    }

    public an af(String str, int i) {
        this.params.add(str);
        this.params.add(Integer.valueOf(i));
        return this;
    }

    public an t(String str, long j) {
        this.params.add(str);
        this.params.add(Long.valueOf(j));
        return this;
    }

    private void aK(List<Object> list) {
        this.params = list;
    }

    public void delete(String str) {
        int indexOf;
        if (!aq.isEmpty(str) && (indexOf = this.params.indexOf(str)) >= 0 && this.params.size() > indexOf + 1) {
            this.params.remove(indexOf);
            this.params.remove(indexOf);
        }
    }

    public boolean uH(String str) {
        int indexOf;
        return !aq.isEmpty(str) && (indexOf = this.params.indexOf(str)) >= 0 && this.params.size() > indexOf + 1;
    }

    public an aOQ() {
        an anVar = new an(getKey());
        anVar.aK(getParams());
        return anVar;
    }

    public void aOR() {
        TiebaStatic.log(this);
    }

    public static an uI(String str) {
        return new an(str);
    }
}
