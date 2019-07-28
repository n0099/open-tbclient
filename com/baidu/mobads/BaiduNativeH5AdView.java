package com.baidu.mobads;

import android.widget.RelativeLayout;
/* loaded from: classes5.dex */
public class BaiduNativeH5AdView extends RelativeLayout {
    private c agA;
    private a agB;

    /* loaded from: classes5.dex */
    public interface a {
    }

    public c getAdPlacement() {
        return this.agA;
    }

    protected void setAdPlacement(c cVar) {
        this.agA = cVar;
    }

    public void setEventListener(a aVar) {
        this.agB = aVar;
    }
}
