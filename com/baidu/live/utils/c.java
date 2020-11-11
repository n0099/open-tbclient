package com.baidu.live.utils;

import android.text.style.ForegroundColorSpan;
import android.text.style.URLSpan;
/* loaded from: classes4.dex */
public class c {
    public boolean bGA = false;
    private ForegroundColorSpan bGB;
    private URLSpan bGC;
    public int bGx;
    public int bGy;
    public int bGz;
    public String mUrl;

    public c(ForegroundColorSpan foregroundColorSpan) {
        this.bGB = foregroundColorSpan;
        this.bGz = foregroundColorSpan.getForegroundColor();
    }

    public void a(URLSpan uRLSpan) {
        this.bGC = uRLSpan;
        this.mUrl = uRLSpan.getURL();
        this.bGA = true;
    }
}
