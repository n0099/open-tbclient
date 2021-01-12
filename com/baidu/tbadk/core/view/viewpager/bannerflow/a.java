package com.baidu.tbadk.core.view.viewpager.bannerflow;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.n;
/* loaded from: classes.dex */
public abstract class a implements n {
    public static final BdUniqueId fmP = BdUniqueId.gen();

    public abstract Object bvi();

    public abstract String getImageUrl();

    @Override // com.baidu.adp.widget.ListView.n
    public BdUniqueId getType() {
        return fmP;
    }
}
