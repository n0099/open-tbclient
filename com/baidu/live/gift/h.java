package com.baidu.live.gift;

import java.util.List;
/* loaded from: classes10.dex */
public class h {
    private String aHS;
    private boolean aHU;
    private List<g> aXS;
    private int categoryId;

    public int getCategoryId() {
        return this.categoryId;
    }

    public void setCategoryId(int i) {
        this.categoryId = i;
    }

    public void setCategoryName(String str) {
        this.aHS = str;
    }

    public List<g> Ez() {
        return this.aXS;
    }

    public void G(List<g> list) {
        this.aXS = list;
    }

    public boolean EA() {
        return this.aHU;
    }

    public void bs(boolean z) {
        this.aHU = z;
    }
}
