package com.baidu.swan.apps.res.ui.wheelview3d.a;
/* loaded from: classes9.dex */
public class b implements c {
    private int dAL;
    private int dAM;

    public b(int i, int i2) {
        this.dAL = i;
        this.dAM = i2;
    }

    @Override // com.baidu.swan.apps.res.ui.wheelview3d.a.c
    public Object getItem(int i) {
        if (i < 0 || i >= getItemsCount()) {
            return 0;
        }
        return Integer.valueOf(this.dAL + i);
    }

    @Override // com.baidu.swan.apps.res.ui.wheelview3d.a.c
    public int getItemsCount() {
        return (this.dAM - this.dAL) + 1;
    }
}
