package com.baidu.live.gift;

import java.util.List;
/* loaded from: classes4.dex */
public class i {
    private String aDQ;
    private boolean aDS;
    private List<g> aPC;
    private int categoryId;

    public int getCategoryId() {
        return this.categoryId;
    }

    public void setCategoryId(int i) {
        this.categoryId = i;
    }

    public void setCategoryName(String str) {
        this.aDQ = str;
    }

    public List<g> EI() {
        return this.aPC;
    }

    public void E(List<g> list) {
        this.aPC = list;
    }

    public boolean EJ() {
        return this.aDS;
    }

    public void bh(boolean z) {
        this.aDS = z;
    }
}
