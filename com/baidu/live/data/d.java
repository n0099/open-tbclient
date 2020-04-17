package com.baidu.live.data;

import java.util.ArrayList;
/* loaded from: classes3.dex */
public class d {
    private String apE;
    private ArrayList<Integer> apF;
    private boolean apG;
    private int categoryId;

    public void setCategoryId(int i) {
        this.categoryId = i;
    }

    public void setCategoryName(String str) {
        this.apE = str;
    }

    public void f(ArrayList<Integer> arrayList) {
        this.apF = arrayList;
    }

    public String getCategoryName() {
        return this.apE;
    }

    public int getCategoryId() {
        return this.categoryId;
    }

    public ArrayList<Integer> uM() {
        return this.apF;
    }

    public void aU(boolean z) {
        this.apG = z;
    }
}
