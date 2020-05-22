package com.baidu.tbadk.core.view.viewpager.bannerflow;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.o;
/* loaded from: classes.dex */
public abstract class a implements o {
    public static final BdUniqueId dZB = BdUniqueId.gen();

    public abstract Object aXl();

    public abstract String getImageUrl();

    @Override // com.baidu.adp.widget.ListView.o
    public BdUniqueId getType() {
        return dZB;
    }
}
