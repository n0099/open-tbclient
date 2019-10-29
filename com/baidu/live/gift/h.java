package com.baidu.live.gift;

import java.util.List;
/* loaded from: classes6.dex */
public class h {
    private String WS;
    private boolean WT;
    private List<g> WU;
    private int categoryId;

    public int getCategoryId() {
        return this.categoryId;
    }

    public void setCategoryId(int i) {
        this.categoryId = i;
    }

    public void setCategoryName(String str) {
        this.WS = str;
    }

    public List<g> pt() {
        return this.WU;
    }

    public void s(List<g> list) {
        this.WU = list;
    }

    public boolean pu() {
        return this.WT;
    }

    public void ah(boolean z) {
        this.WT = z;
    }
}
