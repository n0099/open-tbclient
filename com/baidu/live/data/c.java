package com.baidu.live.data;

import java.util.ArrayList;
/* loaded from: classes2.dex */
public class c {
    private String Vq;
    private ArrayList<Integer> Vr;
    private boolean Vs;
    private int categoryId;

    public void setCategoryId(int i) {
        this.categoryId = i;
    }

    public void setCategoryName(String str) {
        this.Vq = str;
    }

    public void e(ArrayList<Integer> arrayList) {
        this.Vr = arrayList;
    }

    public String getCategoryName() {
        return this.Vq;
    }

    public int getCategoryId() {
        return this.categoryId;
    }

    public ArrayList<Integer> pB() {
        return this.Vr;
    }

    public void at(boolean z) {
        this.Vs = z;
    }
}
