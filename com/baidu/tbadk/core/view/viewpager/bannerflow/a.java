package com.baidu.tbadk.core.view.viewpager.bannerflow;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.h;
/* loaded from: classes.dex */
public abstract class a implements h {
    public static final BdUniqueId aAp = BdUniqueId.gen();

    public abstract Object Br();

    public abstract String getImageUrl();

    @Override // com.baidu.adp.widget.ListView.h
    public BdUniqueId getType() {
        return aAp;
    }
}
