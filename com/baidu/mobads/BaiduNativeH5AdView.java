package com.baidu.mobads;

import android.widget.RelativeLayout;
/* loaded from: classes5.dex */
public class BaiduNativeH5AdView extends RelativeLayout {
    private c aAc;
    private a aAd;

    /* loaded from: classes5.dex */
    public interface a {
    }

    public c getAdPlacement() {
        return this.aAc;
    }

    protected void setAdPlacement(c cVar) {
        this.aAc = cVar;
    }

    public void setEventListener(a aVar) {
        this.aAd = aVar;
    }
}
