package com.baidu.tbadk.core.view.viewpager.bannerflow;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.q;
/* loaded from: classes.dex */
public abstract class a implements q {
    public static final BdUniqueId eAR = BdUniqueId.gen();

    public abstract Object bmP();

    public abstract String getImageUrl();

    @Override // com.baidu.adp.widget.ListView.q
    public BdUniqueId getType() {
        return eAR;
    }
}
