package com.baidu.tbadk.core.view.viewpager.a;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.v;
/* loaded from: classes.dex */
public abstract class a implements v {
    public static final BdUniqueId aok = BdUniqueId.gen();

    public abstract String getImageUrl();

    public abstract Object xf();

    @Override // com.baidu.adp.widget.ListView.v
    public BdUniqueId getType() {
        return aok;
    }
}
