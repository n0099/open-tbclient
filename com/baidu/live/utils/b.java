package com.baidu.live.utils;

import android.text.style.ForegroundColorSpan;
import android.text.style.URLSpan;
/* loaded from: classes3.dex */
public class b {
    public int aDD;
    public int aDE;
    public int aDF;
    public boolean aDG = false;
    private ForegroundColorSpan aDH;
    private URLSpan aDI;
    public String mUrl;

    public b(ForegroundColorSpan foregroundColorSpan) {
        this.aDH = foregroundColorSpan;
        this.aDF = foregroundColorSpan.getForegroundColor();
    }

    public void a(URLSpan uRLSpan) {
        this.aDI = uRLSpan;
        this.mUrl = uRLSpan.getURL();
        this.aDG = true;
    }
}
