package com.baidu.live.utils;

import android.text.style.ForegroundColorSpan;
import android.text.style.URLSpan;
/* loaded from: classes3.dex */
public class b {
    public int aDC;
    public int aDD;
    public int aDE;
    public boolean aDF = false;
    private ForegroundColorSpan aDG;
    private URLSpan aDH;
    public String mUrl;

    public b(ForegroundColorSpan foregroundColorSpan) {
        this.aDG = foregroundColorSpan;
        this.aDE = foregroundColorSpan.getForegroundColor();
    }

    public void a(URLSpan uRLSpan) {
        this.aDH = uRLSpan;
        this.mUrl = uRLSpan.getURL();
        this.aDF = true;
    }
}
