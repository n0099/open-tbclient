package com.baidu.tbadk.core.view.viewpager.a;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.u;
/* loaded from: classes.dex */
public abstract class a implements u {
    public static final BdUniqueId aiH = BdUniqueId.gen();

    public abstract String getImageUrl();

    public abstract Object xX();

    @Override // com.baidu.adp.widget.ListView.u
    public BdUniqueId getType() {
        return aiH;
    }
}
