package com.baidu.live.data;

import java.util.ArrayList;
/* loaded from: classes4.dex */
public class h {
    private String aHf;
    private ArrayList<Integer> aHg;
    private boolean aHh;
    private int categoryId;

    public void setCategoryId(int i) {
        this.categoryId = i;
    }

    public void setCategoryName(String str) {
        this.aHf = str;
    }

    public void k(ArrayList<Integer> arrayList) {
        this.aHg = arrayList;
    }

    public String getCategoryName() {
        return this.aHf;
    }

    public int getCategoryId() {
        return this.categoryId;
    }

    public ArrayList<Integer> DN() {
        return this.aHg;
    }

    public void bm(boolean z) {
        this.aHh = z;
    }
}
