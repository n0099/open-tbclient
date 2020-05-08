package com.baidu.live.data;

import java.util.ArrayList;
/* loaded from: classes3.dex */
public class d {
    private String apK;
    private ArrayList<Integer> apL;
    private boolean apM;
    private int categoryId;

    public void setCategoryId(int i) {
        this.categoryId = i;
    }

    public void setCategoryName(String str) {
        this.apK = str;
    }

    public void f(ArrayList<Integer> arrayList) {
        this.apL = arrayList;
    }

    public String getCategoryName() {
        return this.apK;
    }

    public int getCategoryId() {
        return this.categoryId;
    }

    public ArrayList<Integer> uL() {
        return this.apL;
    }

    public void aU(boolean z) {
        this.apM = z;
    }
}
