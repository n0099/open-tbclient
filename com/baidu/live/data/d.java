package com.baidu.live.data;

import java.util.ArrayList;
/* loaded from: classes3.dex */
public class d {
    private String XA;
    private ArrayList<Integer> XB;
    private boolean XC;
    private int categoryId;

    public void setCategoryId(int i) {
        this.categoryId = i;
    }

    public void setCategoryName(String str) {
        this.XA = str;
    }

    public void f(ArrayList<Integer> arrayList) {
        this.XB = arrayList;
    }

    public String getCategoryName() {
        return this.XA;
    }

    public int getCategoryId() {
        return this.categoryId;
    }

    public ArrayList<Integer> qv() {
        return this.XB;
    }

    public void aw(boolean z) {
        this.XC = z;
    }
}
