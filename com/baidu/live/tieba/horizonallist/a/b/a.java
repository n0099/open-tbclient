package com.baidu.live.tieba.horizonallist.a.b;

import android.annotation.TargetApi;
import android.view.View;
import com.baidu.live.tieba.horizonallist.a.a;
/* loaded from: classes3.dex */
public class a extends a.b {
    public a(View view) {
        super(view);
    }

    @Override // com.baidu.live.tieba.horizonallist.a.a.b, com.baidu.live.tieba.horizonallist.a.a.AbstractC0178a
    @TargetApi(14)
    public void setScrollX(int i) {
        this.view.setScrollX(i);
    }

    @Override // com.baidu.live.tieba.horizonallist.a.a.b, com.baidu.live.tieba.horizonallist.a.a.AbstractC0178a
    @TargetApi(11)
    public boolean isHardwareAccelerated() {
        return this.view.isHardwareAccelerated();
    }
}
