package com.baidu.live.data;

import java.util.ArrayList;
/* loaded from: classes10.dex */
public class i {
    private String aHS;
    private ArrayList<Integer> aHT;
    private boolean aHU;
    private int categoryId;

    public void setCategoryId(int i) {
        this.categoryId = i;
    }

    public void setCategoryName(String str) {
        this.aHS = str;
    }

    public void f(ArrayList<Integer> arrayList) {
        this.aHT = arrayList;
    }

    public String getCategoryName() {
        return this.aHS;
    }

    public int getCategoryId() {
        return this.categoryId;
    }

    public ArrayList<Integer> Bq() {
        return this.aHT;
    }

    public void bs(boolean z) {
        this.aHU = z;
    }
}
