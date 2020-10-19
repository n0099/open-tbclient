package com.baidu.live.data;

import java.util.ArrayList;
/* loaded from: classes4.dex */
public class g {
    private String aGU;
    private ArrayList<Integer> aGV;
    private boolean aGW;
    private int categoryId;

    public void setCategoryId(int i) {
        this.categoryId = i;
    }

    public void setCategoryName(String str) {
        this.aGU = str;
    }

    public void k(ArrayList<Integer> arrayList) {
        this.aGV = arrayList;
    }

    public String getCategoryName() {
        return this.aGU;
    }

    public int getCategoryId() {
        return this.categoryId;
    }

    public ArrayList<Integer> DG() {
        return this.aGV;
    }

    public void bl(boolean z) {
        this.aGW = z;
    }
}
