package com.baidu.live.utils;

import android.text.style.ForegroundColorSpan;
import android.text.style.URLSpan;
/* loaded from: classes3.dex */
public class b {
    public int aXG;
    public int aXH;
    public int aXI;
    public boolean aXJ = false;
    private ForegroundColorSpan aXK;
    private URLSpan aXL;
    public String mUrl;

    public b(ForegroundColorSpan foregroundColorSpan) {
        this.aXK = foregroundColorSpan;
        this.aXI = foregroundColorSpan.getForegroundColor();
    }

    public void a(URLSpan uRLSpan) {
        this.aXL = uRLSpan;
        this.mUrl = uRLSpan.getURL();
        this.aXJ = true;
    }
}
