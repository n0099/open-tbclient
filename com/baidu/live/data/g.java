package com.baidu.live.data;

import java.util.ArrayList;
/* loaded from: classes4.dex */
public class g {
    private String aDQ;
    private ArrayList<Integer> aDR;
    private boolean aDS;
    private int categoryId;

    public void setCategoryId(int i) {
        this.categoryId = i;
    }

    public void setCategoryName(String str) {
        this.aDQ = str;
    }

    public void k(ArrayList<Integer> arrayList) {
        this.aDR = arrayList;
    }

    public String getCategoryName() {
        return this.aDQ;
    }

    public int getCategoryId() {
        return this.categoryId;
    }

    public ArrayList<Integer> CJ() {
        return this.aDR;
    }

    public void bh(boolean z) {
        this.aDS = z;
    }
}
