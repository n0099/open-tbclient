package com.baidu.live.data;

import java.util.ArrayList;
/* loaded from: classes4.dex */
public class h {
    private String aIU;
    private ArrayList<Integer> aIV;
    private boolean aIW;
    private int categoryId;

    public void setCategoryId(int i) {
        this.categoryId = i;
    }

    public void setCategoryName(String str) {
        this.aIU = str;
    }

    public void k(ArrayList<Integer> arrayList) {
        this.aIV = arrayList;
    }

    public String getCategoryName() {
        return this.aIU;
    }

    public int getCategoryId() {
        return this.categoryId;
    }

    public ArrayList<Integer> Fi() {
        return this.aIV;
    }

    public void bx(boolean z) {
        this.aIW = z;
    }
}
