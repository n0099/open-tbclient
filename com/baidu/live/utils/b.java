package com.baidu.live.utils;

import android.text.style.ForegroundColorSpan;
import android.text.style.URLSpan;
/* loaded from: classes3.dex */
public class b {
    public int aXB;
    public int aXC;
    public int aXD;
    public boolean aXE = false;
    private ForegroundColorSpan aXF;
    private URLSpan aXG;
    public String mUrl;

    public b(ForegroundColorSpan foregroundColorSpan) {
        this.aXF = foregroundColorSpan;
        this.aXD = foregroundColorSpan.getForegroundColor();
    }

    public void a(URLSpan uRLSpan) {
        this.aXG = uRLSpan;
        this.mUrl = uRLSpan.getURL();
        this.aXE = true;
    }
}
