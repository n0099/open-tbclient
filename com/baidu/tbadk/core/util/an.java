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

    public an bS(String str, String str2) {
        this.params.add(str);
        this.params.add(str2);
        return this;
    }

    public an O(String str, int i) {
        this.params.add(str);
        this.params.add(Integer.valueOf(i));
        return this;
    }

    public an p(String str, long j) {
        this.params.add(str);
        this.params.add(Long.valueOf(j));
        return this;
    }

    private void av(List<Object> list) {
        this.params = list;
    }

    public void delete(String str) {
        int indexOf;
        if (!aq.isEmpty(str) && (indexOf = this.params.indexOf(str)) >= 0 && this.params.size() > indexOf + 1) {
            this.params.remove(indexOf);
            this.params.remove(indexOf);
        }
    }

    public an amJ() {
        an anVar = new an(getKey());
        anVar.av(getParams());
        return anVar;
    }

    public void amK() {
        TiebaStatic.log(this);
    }
}
