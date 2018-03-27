package com.baidu.tbadk.core.view.viewpager.a;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.i;
/* loaded from: classes.dex */
public abstract class a implements i {
    public static final BdUniqueId bfM = BdUniqueId.gen();

    public abstract Object EM();

    public abstract String getImageUrl();

    @Override // com.baidu.adp.widget.ListView.i
    public BdUniqueId getType() {
        return bfM;
    }
}
