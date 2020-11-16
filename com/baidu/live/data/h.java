package com.baidu.live.data;

import java.util.ArrayList;
/* loaded from: classes4.dex */
public class h {
    private String aGl;
    private ArrayList<Integer> aGm;
    private boolean aGn;
    private int categoryId;

    public void setCategoryId(int i) {
        this.categoryId = i;
    }

    public void setCategoryName(String str) {
        this.aGl = str;
    }

    public void k(ArrayList<Integer> arrayList) {
        this.aGm = arrayList;
    }

    public String getCategoryName() {
        return this.aGl;
    }

    public int getCategoryId() {
        return this.categoryId;
    }

    public ArrayList<Integer> Dx() {
        return this.aGm;
    }

    public void bp(boolean z) {
        this.aGn = z;
    }
}
