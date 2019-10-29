package com.baidu.mobads;

import android.widget.RelativeLayout;
/* loaded from: classes5.dex */
public class BaiduNativeH5AdView extends RelativeLayout {
    private c aAu;
    private a aAv;

    /* loaded from: classes5.dex */
    public interface a {
    }

    public c getAdPlacement() {
        return this.aAu;
    }

    protected void setAdPlacement(c cVar) {
        this.aAu = cVar;
    }

    public void setEventListener(a aVar) {
        this.aAv = aVar;
    }
}
