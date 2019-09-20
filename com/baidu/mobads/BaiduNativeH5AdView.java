package com.baidu.mobads;

import android.widget.RelativeLayout;
/* loaded from: classes5.dex */
public class BaiduNativeH5AdView extends RelativeLayout {
    private c agW;
    private a agX;

    /* loaded from: classes5.dex */
    public interface a {
    }

    public c getAdPlacement() {
        return this.agW;
    }

    protected void setAdPlacement(c cVar) {
        this.agW = cVar;
    }

    public void setEventListener(a aVar) {
        this.agX = aVar;
    }
}
