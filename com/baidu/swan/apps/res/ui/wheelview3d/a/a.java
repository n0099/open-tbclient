package com.baidu.swan.apps.res.ui.wheelview3d.a;

import java.util.List;
/* loaded from: classes7.dex */
public class a<T> implements c {
    private List<T> items;

    public a(List<T> list) {
        this.items = list;
    }

    @Override // com.baidu.swan.apps.res.ui.wheelview3d.a.c
    public Object getItem(int i) {
        return (i < 0 || i >= this.items.size()) ? "" : this.items.get(i);
    }

    @Override // com.baidu.swan.apps.res.ui.wheelview3d.a.c
    public int getItemsCount() {
        return this.items.size();
    }
}
