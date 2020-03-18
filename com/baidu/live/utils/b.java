package com.baidu.live.utils;

import android.text.style.ForegroundColorSpan;
import android.text.style.URLSpan;
/* loaded from: classes3.dex */
public class b {
    public int aDS;
    public int aDT;
    public int aDU;
    public boolean aDV = false;
    private ForegroundColorSpan aDW;
    private URLSpan aDX;
    public String mUrl;

    public b(ForegroundColorSpan foregroundColorSpan) {
        this.aDW = foregroundColorSpan;
        this.aDU = foregroundColorSpan.getForegroundColor();
    }

    public void a(URLSpan uRLSpan) {
        this.aDX = uRLSpan;
        this.mUrl = uRLSpan.getURL();
        this.aDV = true;
    }
}
