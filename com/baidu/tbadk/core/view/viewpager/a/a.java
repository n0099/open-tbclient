package com.baidu.tbadk.core.view.viewpager.a;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.f;
/* loaded from: classes.dex */
public abstract class a implements f {
    public static final BdUniqueId aqc = BdUniqueId.gen();

    public abstract String getImageUrl();

    public abstract Object xA();

    @Override // com.baidu.adp.widget.ListView.f
    public BdUniqueId getType() {
        return aqc;
    }
}
