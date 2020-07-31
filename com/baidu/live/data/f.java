package com.baidu.live.data;

import java.util.ArrayList;
/* loaded from: classes4.dex */
public class f {
    private String ayb;
    private ArrayList<Integer> ayc;
    private boolean ayd;
    private int categoryId;

    public void setCategoryId(int i) {
        this.categoryId = i;
    }

    public void setCategoryName(String str) {
        this.ayb = str;
    }

    public void f(ArrayList<Integer> arrayList) {
        this.ayc = arrayList;
    }

    public String getCategoryName() {
        return this.ayb;
    }

    public int getCategoryId() {
        return this.categoryId;
    }

    public ArrayList<Integer> wW() {
        return this.ayc;
    }

    public void bb(boolean z) {
        this.ayd = z;
    }
}
