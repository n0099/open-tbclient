package com.baidu.live.data;

import java.util.ArrayList;
/* loaded from: classes10.dex */
public class i {
    private String aEF;
    private ArrayList<Integer> aEG;
    private boolean aEH;
    private int categoryId;

    public void setCategoryId(int i) {
        this.categoryId = i;
    }

    public void setCategoryName(String str) {
        this.aEF = str;
    }

    public void f(ArrayList<Integer> arrayList) {
        this.aEG = arrayList;
    }

    public String getCategoryName() {
        return this.aEF;
    }

    public int getCategoryId() {
        return this.categoryId;
    }

    public ArrayList<Integer> AD() {
        return this.aEG;
    }

    public void bq(boolean z) {
        this.aEH = z;
    }
}
