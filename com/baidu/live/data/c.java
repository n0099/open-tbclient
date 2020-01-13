package com.baidu.live.data;

import java.util.ArrayList;
/* loaded from: classes2.dex */
public class c {
    private String VG;
    private ArrayList<Integer> VH;
    private boolean VI;
    private int categoryId;

    public void setCategoryId(int i) {
        this.categoryId = i;
    }

    public void setCategoryName(String str) {
        this.VG = str;
    }

    public void e(ArrayList<Integer> arrayList) {
        this.VH = arrayList;
    }

    public String getCategoryName() {
        return this.VG;
    }

    public int getCategoryId() {
        return this.categoryId;
    }

    public ArrayList<Integer> pF() {
        return this.VH;
    }

    public void at(boolean z) {
        this.VI = z;
    }
}
