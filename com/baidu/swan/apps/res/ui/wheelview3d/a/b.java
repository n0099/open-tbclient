package com.baidu.swan.apps.res.ui.wheelview3d.a;
/* loaded from: classes3.dex */
public class b implements c {
    private int maxValue;
    private int minValue;

    public b(int i, int i2) {
        this.minValue = i;
        this.maxValue = i2;
    }

    @Override // com.baidu.swan.apps.res.ui.wheelview3d.a.c
    public Object getItem(int i) {
        if (i < 0 || i >= getItemsCount()) {
            return 0;
        }
        return Integer.valueOf(this.minValue + i);
    }

    @Override // com.baidu.swan.apps.res.ui.wheelview3d.a.c
    public int getItemsCount() {
        return (this.maxValue - this.minValue) + 1;
    }
}
