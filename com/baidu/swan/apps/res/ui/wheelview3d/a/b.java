package com.baidu.swan.apps.res.ui.wheelview3d.a;
/* loaded from: classes8.dex */
public class b implements c {
    private int dCm;
    private int dCn;

    public b(int i, int i2) {
        this.dCm = i;
        this.dCn = i2;
    }

    @Override // com.baidu.swan.apps.res.ui.wheelview3d.a.c
    public Object getItem(int i) {
        if (i < 0 || i >= getItemsCount()) {
            return 0;
        }
        return Integer.valueOf(this.dCm + i);
    }

    @Override // com.baidu.swan.apps.res.ui.wheelview3d.a.c
    public int getItemsCount() {
        return (this.dCn - this.dCm) + 1;
    }
}
