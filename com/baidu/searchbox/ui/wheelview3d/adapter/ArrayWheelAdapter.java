package com.baidu.searchbox.ui.wheelview3d.adapter;

import java.util.List;
/* loaded from: classes4.dex */
public class ArrayWheelAdapter<T> implements WheelAdapter {
    public List<T> items;

    public ArrayWheelAdapter(List<T> list) {
        this.items = list;
    }

    @Override // com.baidu.searchbox.ui.wheelview3d.adapter.WheelAdapter
    public Object getItem(int i) {
        if (i >= 0 && i < this.items.size()) {
            return this.items.get(i);
        }
        return "";
    }

    @Override // com.baidu.searchbox.ui.wheelview3d.adapter.WheelAdapter
    public int indexOf(Object obj) {
        return this.items.indexOf(obj);
    }

    @Override // com.baidu.searchbox.ui.wheelview3d.adapter.WheelAdapter
    public int getItemsCount() {
        return this.items.size();
    }
}
