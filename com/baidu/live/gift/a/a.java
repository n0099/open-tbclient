package com.baidu.live.gift.a;

import java.util.ArrayList;
/* loaded from: classes6.dex */
public class a {
    private String WS;
    private boolean WT;
    private ArrayList<Integer> aaM;
    private int categoryId;

    public void setCategoryId(int i) {
        this.categoryId = i;
    }

    public void setCategoryName(String str) {
        this.WS = str;
    }

    public void g(ArrayList<Integer> arrayList) {
        this.aaM = arrayList;
    }

    public String getCategoryName() {
        return this.WS;
    }

    public int getCategoryId() {
        return this.categoryId;
    }

    public ArrayList<Integer> qB() {
        return this.aaM;
    }

    public void ah(boolean z) {
        this.WT = z;
    }
}
