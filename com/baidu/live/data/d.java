package com.baidu.live.data;

import java.util.ArrayList;
/* loaded from: classes3.dex */
public class d {
    private String Xq;
    private ArrayList<Integer> Xr;
    private boolean Xs;
    private int categoryId;

    public void setCategoryId(int i) {
        this.categoryId = i;
    }

    public void setCategoryName(String str) {
        this.Xq = str;
    }

    public void f(ArrayList<Integer> arrayList) {
        this.Xr = arrayList;
    }

    public String getCategoryName() {
        return this.Xq;
    }

    public int getCategoryId() {
        return this.categoryId;
    }

    public ArrayList<Integer> qq() {
        return this.Xr;
    }

    public void aw(boolean z) {
        this.Xs = z;
    }
}
