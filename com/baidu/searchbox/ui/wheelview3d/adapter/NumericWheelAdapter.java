package com.baidu.searchbox.ui.wheelview3d.adapter;
/* loaded from: classes14.dex */
public class NumericWheelAdapter implements WheelAdapter {
    private int maxValue;
    private int minValue;

    public NumericWheelAdapter(int i, int i2) {
        this.minValue = i;
        this.maxValue = i2;
    }

    @Override // com.baidu.searchbox.ui.wheelview3d.adapter.WheelAdapter
    public Object getItem(int i) {
        if (i < 0 || i >= getItemsCount()) {
            return 0;
        }
        return Integer.valueOf(this.minValue + i);
    }

    @Override // com.baidu.searchbox.ui.wheelview3d.adapter.WheelAdapter
    public int getItemsCount() {
        return (this.maxValue - this.minValue) + 1;
    }

    @Override // com.baidu.searchbox.ui.wheelview3d.adapter.WheelAdapter
    public int indexOf(Object obj) {
        try {
            return ((Integer) obj).intValue() - this.minValue;
        } catch (Exception e) {
            return -1;
        }
    }
}
