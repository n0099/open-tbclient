package com.baidu.live.data;

import java.util.ArrayList;
/* loaded from: classes4.dex */
public class h {
    private String aHW;
    private ArrayList<Integer> aHX;
    private boolean aHY;
    private int categoryId;

    public void setCategoryId(int i) {
        this.categoryId = i;
    }

    public void setCategoryName(String str) {
        this.aHW = str;
    }

    public void k(ArrayList<Integer> arrayList) {
        this.aHX = arrayList;
    }

    public String getCategoryName() {
        return this.aHW;
    }

    public int getCategoryId() {
        return this.categoryId;
    }

    public ArrayList<Integer> Eg() {
        return this.aHX;
    }

    public void bn(boolean z) {
        this.aHY = z;
    }
}
