package com.baidu.live.data;

import java.util.ArrayList;
/* loaded from: classes3.dex */
public class f {
    private String auI;
    private ArrayList<Integer> auJ;
    private boolean auK;
    private int categoryId;

    public void setCategoryId(int i) {
        this.categoryId = i;
    }

    public void setCategoryName(String str) {
        this.auI = str;
    }

    public void f(ArrayList<Integer> arrayList) {
        this.auJ = arrayList;
    }

    public String getCategoryName() {
        return this.auI;
    }

    public int getCategoryId() {
        return this.categoryId;
    }

    public ArrayList<Integer> vW() {
        return this.auJ;
    }

    public void aY(boolean z) {
        this.auK = z;
    }
}
