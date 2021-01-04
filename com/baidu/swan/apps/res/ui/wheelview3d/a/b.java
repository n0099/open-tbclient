package com.baidu.swan.apps.res.ui.wheelview3d.a;
/* loaded from: classes9.dex */
public class b implements c {
    private int dDs;
    private int dDt;

    public b(int i, int i2) {
        this.dDs = i;
        this.dDt = i2;
    }

    @Override // com.baidu.swan.apps.res.ui.wheelview3d.a.c
    public Object getItem(int i) {
        if (i < 0 || i >= getItemsCount()) {
            return 0;
        }
        return Integer.valueOf(this.dDs + i);
    }

    @Override // com.baidu.swan.apps.res.ui.wheelview3d.a.c
    public int getItemsCount() {
        return (this.dDt - this.dDs) + 1;
    }
}
