package com.baidu.live.utils;

import android.text.style.ForegroundColorSpan;
import android.text.style.URLSpan;
/* loaded from: classes10.dex */
public class c {
    public int bJW;
    public int bJX;
    public int bJY;
    public boolean bJZ = false;
    private ForegroundColorSpan bKa;
    private URLSpan bKb;
    public String mUrl;

    public c(ForegroundColorSpan foregroundColorSpan) {
        this.bKa = foregroundColorSpan;
        this.bJY = foregroundColorSpan.getForegroundColor();
    }

    public void a(URLSpan uRLSpan) {
        this.bKb = uRLSpan;
        this.mUrl = uRLSpan.getURL();
        this.bJZ = true;
    }
}
