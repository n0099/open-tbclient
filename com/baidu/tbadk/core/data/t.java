package com.baidu.tbadk.core.data;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes.dex */
public class t extends AbsThreadDataSupport implements com.baidu.tbadk.mvc.b.a {
    public static final BdUniqueId dIb = BdUniqueId.gen();
    public static final int[] dIc = {0, 1, 2, 3, 4, 5, 7, 8, 9, 10, 11};
    private int mType = 6;

    public void kq(int i) {
        this.mType = i;
    }

    public int getItemViewType() {
        return this.mType;
    }

    @Override // com.baidu.tbadk.core.data.AbsThreadDataSupport
    public bu aPS() {
        return null;
    }

    @Override // com.baidu.tbadk.core.data.AbsThreadDataSupport
    public ap aPU() {
        return null;
    }
}
