package com.baidu.live.data;

import java.util.ArrayList;
/* loaded from: classes11.dex */
public class i {
    private String aGs;
    private ArrayList<Integer> aGt;
    private boolean aGu;
    private int categoryId;

    public void setCategoryId(int i) {
        this.categoryId = i;
    }

    public void setCategoryName(String str) {
        this.aGs = str;
    }

    public void f(ArrayList<Integer> arrayList) {
        this.aGt = arrayList;
    }

    public String getCategoryName() {
        return this.aGs;
    }

    public int getCategoryId() {
        return this.categoryId;
    }

    public ArrayList<Integer> Bn() {
        return this.aGt;
    }

    public void bs(boolean z) {
        this.aGu = z;
    }
}
