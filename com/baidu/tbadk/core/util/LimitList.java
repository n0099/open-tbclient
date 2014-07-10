package com.baidu.tbadk.core.util;

import java.util.ArrayList;
/* loaded from: classes.dex */
public class LimitList extends ArrayList<String> {
    private static final long serialVersionUID = 1;
    private int mLimitSize;

    public LimitList() {
        this.mLimitSize = 0;
    }

    public LimitList(int i) {
        this.mLimitSize = 0;
        this.mLimitSize = i;
    }

    public void setLimitSize(int i) {
        this.mLimitSize = i;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.util.ArrayList, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean add(String str) {
        if (this.mLimitSize != 0 && this.mLimitSize < size()) {
            remove(0);
        }
        return super.add((LimitList) str);
    }
}
