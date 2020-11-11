package com.baidu.live.gift;

import java.util.List;
/* loaded from: classes4.dex */
public class h {
    private String aHW;
    private boolean aHY;
    private List<g> aVb;
    private int categoryId;

    public int getCategoryId() {
        return this.categoryId;
    }

    public void setCategoryId(int i) {
        this.categoryId = i;
    }

    public void setCategoryName(String str) {
        this.aHW = str;
    }

    public List<g> Gu() {
        return this.aVb;
    }

    public void F(List<g> list) {
        this.aVb = list;
    }

    public boolean Gv() {
        return this.aHY;
    }

    public void bn(boolean z) {
        this.aHY = z;
    }
}
