package com.baidu.live.gift;

import java.util.List;
/* loaded from: classes4.dex */
public class h {
    private String aGl;
    private boolean aGn;
    private List<g> aTq;
    private int categoryId;

    public int getCategoryId() {
        return this.categoryId;
    }

    public void setCategoryId(int i) {
        this.categoryId = i;
    }

    public void setCategoryName(String str) {
        this.aGl = str;
    }

    public List<g> FL() {
        return this.aTq;
    }

    public void F(List<g> list) {
        this.aTq = list;
    }

    public boolean FM() {
        return this.aGn;
    }

    public void bp(boolean z) {
        this.aGn = z;
    }
}
