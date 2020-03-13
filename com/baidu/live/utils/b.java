package com.baidu.live.utils;

import android.text.style.ForegroundColorSpan;
import android.text.style.URLSpan;
/* loaded from: classes3.dex */
public class b {
    public int aDE;
    public int aDF;
    public int aDG;
    public boolean aDH = false;
    private ForegroundColorSpan aDI;
    private URLSpan aDJ;
    public String mUrl;

    public b(ForegroundColorSpan foregroundColorSpan) {
        this.aDI = foregroundColorSpan;
        this.aDG = foregroundColorSpan.getForegroundColor();
    }

    public void a(URLSpan uRLSpan) {
        this.aDJ = uRLSpan;
        this.mUrl = uRLSpan.getURL();
        this.aDH = true;
    }
}
