package com.baidu.live.data;

import java.util.ArrayList;
/* loaded from: classes11.dex */
public class i {
    private String aJs;
    private ArrayList<Integer> aJt;
    private boolean aJu;
    private int categoryId;

    public void setCategoryId(int i) {
        this.categoryId = i;
    }

    public void setCategoryName(String str) {
        this.aJs = str;
    }

    public void k(ArrayList<Integer> arrayList) {
        this.aJt = arrayList;
    }

    public String getCategoryName() {
        return this.aJs;
    }

    public int getCategoryId() {
        return this.categoryId;
    }

    public ArrayList<Integer> Ey() {
        return this.aJt;
    }

    public void bu(boolean z) {
        this.aJu = z;
    }
}
