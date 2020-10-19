package com.baidu.live.gift;

import java.util.List;
/* loaded from: classes4.dex */
public class i {
    private String aGU;
    private boolean aGW;
    private List<g> aSN;
    private int categoryId;

    public int getCategoryId() {
        return this.categoryId;
    }

    public void setCategoryId(int i) {
        this.categoryId = i;
    }

    public void setCategoryName(String str) {
        this.aGU = str;
    }

    public List<g> FE() {
        return this.aSN;
    }

    public void G(List<g> list) {
        this.aSN = list;
    }

    public boolean FF() {
        return this.aGW;
    }

    public void bl(boolean z) {
        this.aGW = z;
    }
}
