package com.baidu.live.gift.a;

import java.util.ArrayList;
/* loaded from: classes6.dex */
public class a {
    private boolean WA;
    private String Wz;
    private ArrayList<Integer> aau;
    private int categoryId;

    public void setCategoryId(int i) {
        this.categoryId = i;
    }

    public void setCategoryName(String str) {
        this.Wz = str;
    }

    public void g(ArrayList<Integer> arrayList) {
        this.aau = arrayList;
    }

    public String getCategoryName() {
        return this.Wz;
    }

    public int getCategoryId() {
        return this.categoryId;
    }

    public ArrayList<Integer> qC() {
        return this.aau;
    }

    public void ah(boolean z) {
        this.WA = z;
    }
}
