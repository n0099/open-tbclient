package com.baidu.tbadk.core.view.viewpager.a;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.v;
/* loaded from: classes.dex */
public abstract class a implements v {
    public static final BdUniqueId aet = BdUniqueId.gen();

    public abstract String getImageUrl();

    public abstract Object vR();

    @Override // com.baidu.adp.widget.ListView.v
    public BdUniqueId getType() {
        return aet;
    }
}
