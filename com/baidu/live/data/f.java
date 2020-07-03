package com.baidu.live.data;

import java.util.ArrayList;
/* loaded from: classes3.dex */
public class f {
    private String awO;
    private ArrayList<Integer> awP;
    private boolean awQ;
    private int categoryId;

    public void setCategoryId(int i) {
        this.categoryId = i;
    }

    public void setCategoryName(String str) {
        this.awO = str;
    }

    public void f(ArrayList<Integer> arrayList) {
        this.awP = arrayList;
    }

    public String getCategoryName() {
        return this.awO;
    }

    public int getCategoryId() {
        return this.categoryId;
    }

    public ArrayList<Integer> wu() {
        return this.awP;
    }

    public void aY(boolean z) {
        this.awQ = z;
    }
}
