package com.baidu.tbadk.core.view.viewpager.bannerflow;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.m;
/* loaded from: classes.dex */
public abstract class a implements m {
    public static final BdUniqueId cel = BdUniqueId.gen();

    public abstract Object alt();

    public abstract String getImageUrl();

    @Override // com.baidu.adp.widget.ListView.m
    public BdUniqueId getType() {
        return cel;
    }
}
