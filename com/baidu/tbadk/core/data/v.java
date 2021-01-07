package com.baidu.tbadk.core.data;

import com.baidu.adp.BdUniqueId;
/* loaded from: classes.dex */
public class v extends a implements com.baidu.tbadk.mvc.b.a {
    public static final BdUniqueId ePu = BdUniqueId.gen();
    public static final int[] ePv = {0, 1, 2, 3, 4, 5, 7, 8, 9, 10, 11};
    private int mType = 6;

    public void ox(int i) {
        this.mType = i;
    }

    public int getItemViewType() {
        return this.mType;
    }

    @Override // com.baidu.tbadk.core.data.a
    public bz boP() {
        return null;
    }

    @Override // com.baidu.tbadk.core.data.a
    public at boR() {
        return null;
    }
}
